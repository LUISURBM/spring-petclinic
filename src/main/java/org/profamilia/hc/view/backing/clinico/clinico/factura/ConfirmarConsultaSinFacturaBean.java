package org.profamilia.hc.view.backing.clinico.clinico.factura;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chregiconpro;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpcontrato;
import org.profamilia.hc.model.dto.Cpdonante;
import org.profamilia.hc.model.dto.Cpprograma;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class ConfirmarConsultaSinFacturaBean extends BaseBean {


    private Chusuario usuario;

    private int selectedIndex;

    private Chregiconpro regcirpro;
    
    private Cpclinica clinica;
    
    private String navegationRule;

    /** Lista de sexos */
    private List<SelectItem> listSexos;

    /** Almacena la lista de los posibles estados civil  */
    private List<SelectItem> listEstadoCivil;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    private Integer edad;

    private List lstDonantes;

    private List lstTipoUsuarios;

    private List lstProgramas;

    private String seleccionServicio;

    private UIInput itDonante;

    private UIInput itPrograma;

    private UIInput itFactura;

    private UIInput itTipusu;

    private UIInput itFecha;

    private boolean deshabilitarServicio;
    
    private Cpservicio servicio;
    
    private Long numeroCirugia; 




    public ConfirmarConsultaSinFacturaBean() {
    
    }

    public void init() {
        listSexos = new ArrayList<SelectItem>();
        listEstadoCivil = new ArrayList<SelectItem>();
        listTipoIdentificacion = new ArrayList<SelectItem>();
        
        if(numeroCirugia!= null){

            try {
                regcirpro = serviceLocator.getCirugiaService().getConsultasinfacByNumero(numeroCirugia);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (usuario == null) {
                try {
                    usuario = serviceLocator.getClinicoService().getUsuario(regcirpro.getHrclusuario().getHuslnumero());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }

            if (regcirpro != null && regcirpro.getHrcnclinic() != null) {
                try {
                    clinica = serviceLocator.getClinicoService().getClinica(regcirpro.getHrcnclinic().getCclncodigo());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }

            if (regcirpro != null && regcirpro.getHrccservic() != null) {
                try {
                    servicio = serviceLocator.getClinicoService().getServicioPorId(regcirpro.getHrccservic().getCsvccodigo());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
            
            
        }
    }

    /**
     * @param selectedIndex
     */
    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    /**
     * @return
     */
    public int getSelectedIndex() {
        return selectedIndex;
    }


    /**
     * @param usuario
     */
    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return
     */
    public Chusuario getUsuario() {
        return usuario;
    }

    /**
     * @param clinica
     */
    public void setClinica(Cpclinica clinica) {
        this.clinica = clinica;
    }

    /**
     * @return
     */
    public Cpclinica getClinica() {
        return clinica;
    }

    public String confirmarConsulta() {

        boolean wexito = true; 
        regcirpro.setHrccusucnf(userName());
        regcirpro.setHrccetapa(IConstantes.ETAPA_CONFIRMADA);
        navegationRule = ""; 


        /* Selecciona el numero de consulta cl�nica del servicio de la factura de sap */
        if (wexito) {
            try {    
              Cnconsclin consultaAux = this.serviceLocator.getCirugiaService().getNumeroConsultaClinicaIVEPorDocumento(regcirpro.getHrcnclinic().getCclncodigo(),IConstantes.CDOC_FACSAP,regcirpro.getHrcnnumfac(),regcirpro.getHrccservic().getCsvccodigo());
            
                if(consultaAux != null && consultaAux.getCconnumero() != null && consultaAux.getCcocservic().getCsvccodigo() != null){
                    regcirpro.setHrcnconfac(consultaAux.getCconnumero()); 
                    regcirpro.setWservic(consultaAux.getCcocservic().getCsvccodigo());
                    System.out.println("Servicio::: " + consultaAux.getCcocservic().getCsvccodigo());
                    System.out.println("Servicio::: " + consultaAux.getCconnumero());
                }
                
            } catch (ModelException e) {
                wexito = false;
                e.printStackTrace();
            }
            
            if (regcirpro.getHrcnconfac() == null) {
                wexito = false;
                FacesUtils.addErrorMessage(MSG_NO_EXISTE_CONSULTA +": Factura SAP - " + regcirpro.getHrcnnumfac());
            }
        }

        /* verifica que la consulta clinica inicial del registro de cirugia sin factura exista y este vigentes */
        /*if (wexito) {
            Integer wconini = null;
            try {    
                wconini = this.serviceLocator.getCirugiaService().getNumeroConsultaClinicaPorDocumento(regcirpro.getHrcnclinic().getCclncodigo(),IConstantes.CDOC_IVEFAC,regcirpro.getHrcnnumero().intValue(),regcirpro.getHrccservic().getCsvccodigo()); 
            } catch (ModelException e) {
                wexito = false;
                e.printStackTrace();
            }
            
            if (wconini == null || wconini.intValue() != regcirpro.getHrcnconini().intValue()) {
                wexito = false;
                FacesUtils.addErrorMessage(MSG_NO_EXISTE_CONSULTA +": Cirugia sin Factura - " + regcirpro.getHrcnnumero());
            }
        }*/

        if (wexito) {
           try {
               this.serviceLocator.getCirugiaService().confirmarConsultaSinFactura(regcirpro);
               FacesUtils.addInfoMessage(MSG_ADICION);
               FacesUtils.resetManagedBean("confirmarConsultaSinFacturaBean");
               FacesUtils.resetManagedBean("listaConsultaSinFacturaBean");
               navegationRule = BeanNavegacion.RUTA_IR_LISTA_CONSULTA_SIN_FACTURA;
           } catch (ModelException e) {
               navegationRule =  "";
               FacesUtils.addErrorMessage(MSG_NO_ADICION +":  " + e.getMessage());
                    
           } catch (Exception e1) {
               navegationRule =  "";
               FacesUtils.addErrorMessage(MSG_NO_ADICION + e1.getMessage());
           }        
        }

        return navegationRule; 

    }

    public void setNavegationRule(String navegationRule) {
        this.navegationRule = navegationRule;
    }

    public String getNavegationRule() {
        return navegationRule;
    }

    /**
     * @param param
     */
    public void setListSexos(List<SelectItem> param) {
        this.listSexos = param;
    }


    /**
     * @return La lista de los sexos que existen
     */
    public List getListSexos() {
        if (listSexos.size() == 0) {
            ArrayList<Chsexo> listSexoAux = null;
            try {
                listSexoAux = 
                        (ArrayList<Chsexo>)this.getServiceLocator().getClinicoService().getSexo();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listSexoAux.isEmpty()) {

                Iterator it = listSexoAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listSexos.add(new SelectItem(listSexoAux.get(i).getCsxecodigo(), 
                                                 listSexoAux.get(i).getCsxcdescripcio()));
                    i++;
                }
            }
        }
        return listSexos;
    }

    public void setListEstadoCivil(List<SelectItem> listEstadoCivil) {
        this.listEstadoCivil = listEstadoCivil;
    }

    public List<SelectItem> getListEstadoCivil() {
        if (listEstadoCivil.size() == 0) {
            ArrayList<Chestadociv> listEstadoCivilAux = null;
            try {
                listEstadoCivilAux = 
                        (ArrayList<Chestadociv>)this.getServiceLocator().getClinicoService().getEstadoCivil();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listEstadoCivilAux.isEmpty()) {

                Iterator it = listEstadoCivilAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listEstadoCivil.add(new SelectItem(listEstadoCivilAux.get(i).getCececodigo(), 
                                                       listEstadoCivilAux.get(i).getCeccdescripcio()));
                    i++;
                }
            }
        }
        return listEstadoCivil;
    }

    public void setListTipoIdentificacion(List<SelectItem> param) {
        this.listTipoIdentificacion = param;
    }

    public List<SelectItem> getListTipoIdentificacion() {
        if (listTipoIdentificacion.size() == 0) {
            ArrayList<Cptipoiden> listTipoIdentificacionAux = null;
            try {
                listTipoIdentificacionAux = 
                        (ArrayList<Cptipoiden>)this.serviceLocator.getClinicoService().getTipoIdentificacion();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listTipoIdentificacionAux.isEmpty()) {

                Iterator it = listTipoIdentificacionAux.iterator();
                int i = 0;
                listTipoIdentificacion.add(new SelectItem("", 
                                                          "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listTipoIdentificacion.add(new SelectItem(listTipoIdentificacionAux.get(i).getCticcodigo(), 
                                                              listTipoIdentificacionAux.get(i).getCticdescri()));
                    i++;
                }
            }
        }

        return listTipoIdentificacion;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setRegcirpro(Chregiconpro regcirpro) {
        this.regcirpro = regcirpro;
    }

    public Chregiconpro getRegcirpro() {
        return regcirpro;
    }


    /**
     * @param param
     */
    public void setLstDonantes(List<SelectItem> param) {
        this.lstDonantes = param;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstDonantes() {
        if (lstDonantes == null || lstDonantes.isEmpty()) {
            lstDonantes = new ArrayList<SelectItem>();
            ArrayList<Cpdonante> lstDonantesAux = null;
            try {
                lstDonantesAux = 
                        (ArrayList<Cpdonante>)this.serviceLocator.getClinicoService().getDonante();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstDonantesAux.isEmpty()) {

                Iterator it = lstDonantesAux.iterator();
                int i = 0;
                lstDonantes.add(new SelectItem("", 
                                                     "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstDonantes.add(new SelectItem(lstDonantesAux.get(i).getCdnncodigo(), 
                                                         lstDonantesAux.get(i).getCdnncodigo().toString() + 
                                                         " " + 
                                                         lstDonantesAux.get(i).getCdncdescri()));
                    i++;
                }
            }
        }
        return lstDonantes;
    }

    /**
     * @param param
     */
    public void setLstTipoUsuarios(List<SelectItem> param) {
        this.lstTipoUsuarios = param;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstTipoUsuarios() {
        if (lstTipoUsuarios == null || lstTipoUsuarios.isEmpty()) {
            lstTipoUsuarios = new ArrayList<SelectItem>();
            ArrayList<Cpcontrato> lstTipoUsuariosAux = null;
            try {
                lstTipoUsuariosAux = 
                        (ArrayList<Cpcontrato>)this.serviceLocator.getClinicoService().getTipoUsuarioClinico(this.getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstTipoUsuariosAux.isEmpty()) {

                Iterator it = lstTipoUsuariosAux.iterator();
                int i = 0;
                lstTipoUsuarios.add(new SelectItem("", 
                                                     "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstTipoUsuarios.add(new SelectItem(lstTipoUsuariosAux.get(i).getId().getCcnnnumero(), 
                                                         lstTipoUsuariosAux.get(i).getId().getCcnnnumero().toString() + 
                                                         " " + 
                                                         lstTipoUsuariosAux.get(i).getCcncdescri()));
                    i++;
                }
            }
        }
        return lstTipoUsuarios;
    }


    /**
     * @param param
     */
    public void setLstProgramas(List<SelectItem> param) {
        this.lstProgramas = param;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstProgramas() {
        if (lstProgramas == null || lstProgramas.isEmpty()) {
            lstProgramas = new ArrayList<SelectItem>();
            ArrayList<Cpprograma> lstProgramasAux = null;
            try {
                lstProgramasAux = 
                        (ArrayList<Cpprograma>)this.serviceLocator.getClinicoService().getPrograma();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstProgramasAux.isEmpty()) {

                Iterator it = lstProgramasAux.iterator();
                int i = 0;
                lstProgramas.add(new SelectItem("", 
                                                     "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstProgramas.add(new SelectItem(lstProgramasAux.get(i).getCpgncodigo(), 
                                                         lstProgramasAux.get(i).getCpgncodigo().toString() + 
                                                         " " + 
                                                         lstProgramasAux.get(i).getCpgcnombre()));
                    i++;
                }
            }
        }
        return lstProgramas;
    }

    public void changeEdad() {
        if (usuario != null && usuario.getHusdfechanacim() != null) {
            setEdad(calcularEdad(usuario.getHusdfechanacim(), new Date()));
        }
    }


    /**
     * @param deshabilitarServicio
     */
    public void setDeshabilitarServicio(boolean deshabilitarServicio) {
        this.deshabilitarServicio = deshabilitarServicio;
    }

    /**
     * @return
     */
    public boolean isDeshabilitarServicio() {
        return deshabilitarServicio;
    }


    public void setItFecha(UIInput itFecha) {
        this.itFecha = itFecha;
    }

    public UIInput getItFecha() {
        return itFecha;
    }

    public void setItTipusu(UIInput itTipusu) {
        this.itTipusu = itTipusu;
    }

    public UIInput getItTipusu() {
        return itTipusu;
    }

    public void setItDonante(UIInput itDonante) {
        this.itDonante = itDonante;
    }

    public UIInput getItDonante() {
        return itDonante;
    }

    public void setItPrograma(UIInput itPrograma) {
        this.itPrograma = itPrograma;
    }

    public UIInput getItPrograma() {
        return itPrograma;
    }

    public void setItFactura(UIInput itFactura) {
        this.itFactura = itFactura;
    }

    public UIInput getItFactura() {
        return itFactura;
    }

    /**
     * @param valueChangeEvent
     */
    public void setServicio(ValueChangeEvent valueChangeEvent) {
        regcirpro.setHrccservic(((Cpservicio)valueChangeEvent.getNewValue()));
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setSeleccionServicio(String seleccionServicio) {
        this.seleccionServicio = seleccionServicio;
    }

    public String getSeleccionServicio() {
        return seleccionServicio;
    }

    public void changeSeleccionServicio() {
        seleccionServicio = null;

        if (regcirpro.getHrccservic() != null) {
            try {
                servicio = 
                        (Cpservicio)this.serviceLocator.getClinicoService().getServicioPorId(regcirpro.getHrccservic().getCsvccodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (servicio != null && servicio.getCsvccodigo() != null && 
                servicio.getCsvccodigo().equals(regcirpro.getHrccservic())) {
                seleccionServicio = servicio.getCsvcnombre();
            } else {
                FacesUtils.addErrorMessage(seleccionServicio = 
                                           "Servicio: " + regcirpro.getHrccservic() + 
                                           " no existe");
            }
        } else {
            FacesUtils.addErrorMessage(seleccionServicio = 
                                       "Por Favor escriba un C�digo de Servicio");
        }
    }

    /**
     * @param valueChangeEvent
     */
    public void setDonanteSelect(ValueChangeEvent valueChangeEvent) {
        regcirpro.setHrcndonant((BigDecimal)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setProgramaSelect(ValueChangeEvent valueChangeEvent) {
        regcirpro.setHrcnprogra((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setTipusuSelect(ValueChangeEvent valueChangeEvent) {
        regcirpro.setHrcntipusu((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param numeroCirugia
     */
    public void setNumeroCirugia(Long numeroCirugia) {
        this.numeroCirugia = numeroCirugia;
    }

    /**
     * @return
     */
    public Long getNumeroCirugia() {
        return numeroCirugia;
    }

    public void set_servicio(Cpservicio _servicio) {
        this.servicio = _servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }
}
