package org.profamilia.hc.view.backing.clinico.clinico.factura;


import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import java.util.StringTokenizer;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chregiconpro;
import org.profamilia.hc.model.dto.Chserxtipo;
import org.profamilia.hc.model.dto.ChserxtipoPK;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpcontrato;
import org.profamilia.hc.model.dto.Cpdepadane;
import org.profamilia.hc.model.dto.Cpdonante;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpprograma;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptipodocu;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.buscador.BuscadorFacturasBean;
import org.profamilia.hc.view.backing.clinico.comun.BuscadorCirugiasBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorEPSBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorOcupacionBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorServicioBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.backing.cirugia.consulta.ConsultarCirugiasProgramarBean;
import org.profamilia.hc.view.backing.cirugia.registro.ProgramarCirugiaBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioCirugiaBean;


public class RegistrarConsultaSinFacturaBean extends BaseBean {


    private Chusuario usuario;

    private int selectedIndex;

    static final int ACTIVAR_MODIFICAR_CIRUGIA = 0;
    static final int ACTIVAR_BUSCADOR_CIRUGIAS = 1;

    private List<Chregiconpro> lstCirugiasRegistradas;

    private HtmlDataTable dtConsultasCirugia;

    private HtmlDataTable dtCirugiasRegistradas;

    private Chregiconpro regcirpro;

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

    private boolean renderBuscadorServicio;

    private boolean registrarCirugia;

    private String seleccionServicio;

    private UIInput itDonante;

    private UIInput itPrograma;

    private UIInput itFactura;

    private UIInput itTipusu;

    private UIInput itFecha;

    private boolean deshabilitarServicio;

    private Cpservicio servicio;

    static final int BEAN_REGISTRAR_CIRUGIA = 1;

    private boolean mostrarCirugias;

    BuscadorCirugiasBean buscadorCirugias;

    private List<Cpservicio> lstCirugias;

    private HtmlDataTable dtServicios;
    ProgramarCirugiaBean programar;
    boolean wejecuto = false;

    /** Lista de listServiciosIve */
    private List listServiciosIve;

    private String servicioIve;

    public RegistrarConsultaSinFacturaBean() {
    }

    public void init() {
        lstCirugias = new ArrayList<Cpservicio>();
        listServiciosIve = new ArrayList<Chserxtipo>();
        listSexos = new ArrayList<SelectItem>();
        listEstadoCivil = new ArrayList<SelectItem>();
        listTipoIdentificacion = new ArrayList<SelectItem>();
        dtConsultasCirugia = new HtmlDataTable();
        dtCirugiasRegistradas = new HtmlDataTable();
        cargarConsultas();
        regcirpro = new Chregiconpro();
        registrarCirugia = true;
        wejecuto = false;
    }

    public void cargarConsultas() {

        if (usuario != null) {
            regcirpro.setHrcnprogra(1);
            regcirpro.setHrcndonant(new BigDecimal(1));
            try {
                lstCirugiasRegistradas = 
                        this.serviceLocator.getCirugiaService().getConsultasCirugiaSinFactura(usuario);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstCirugiasRegistradas == null || 
                lstCirugiasRegistradas.isEmpty()) {
                lstCirugiasRegistradas = new ArrayList<Chregiconpro>();
            }

            changeEdad();
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
     * @param dtConsultasCirugia
     */
    public void setDtConsultasCirugia(HtmlDataTable dtConsultasCirugia) {
        this.dtConsultasCirugia = dtConsultasCirugia;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtConsultasCirugia() {
        return dtConsultasCirugia;
    }


    /**
     * @param lstCirugiasRegistradas
     */
    public void setLstCirugiasRegistradas(List<Chregiconpro> lstCirugiasRegistradas) {
        this.lstCirugiasRegistradas = lstCirugiasRegistradas;
    }

    /**
     * @return
     */
    public List<Chregiconpro> getLstCirugiasRegistradas() {
        return lstCirugiasRegistradas;
    }

    /**
     * @param dtCirugiasRegistradas
     */
    public void setDtCirugiasRegistradas(HtmlDataTable dtCirugiasRegistradas) {
        this.dtCirugiasRegistradas = dtCirugiasRegistradas;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCirugiasRegistradas() {
        return dtCirugiasRegistradas;
    }

    public String agregarConsulta() {

        boolean wexito = true;


        if (!wejecuto) {


            navegationRule = "";
            wejecuto = true;

            regcirpro.setHrcnclinic(this.getClinica());
            regcirpro.setHrctfecreg(new Date());
            regcirpro.setHrcdfeccirpro(new Date());
            regcirpro.setHrclusuario(usuario);
            regcirpro.setHrcctipide(usuario.getHusetipoiden());
            regcirpro.setHrcanumide(new BigDecimal(usuario.getHusanumeiden()));
            regcirpro.setHrccusureg(userName());
            regcirpro.setHrccestado(IConstantes.ESTADO_VIGENTE);
            regcirpro.setHrccetapa(IConstantes.ETAPA_PROGRAMADA_CIRUGIA);


            Cpservicio servicioAux = new Cpservicio();

          {
                try {
                    servicioAux = 
                            this.serviceLocator.getClinicoService().getServicioPorId(servicioIve);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
            Cptipodocu tipodocu = new Cptipodocu();
            try {
                tipodocu = 
                        this.serviceLocator.getCirugiaService().getTipoDocuPorId(IConstantes.CDOC_IVEFAC);
            } catch (ModelException e) {
                e.printStackTrace();
            }

          
                    try {
                        this.serviceLocator.getClinicoService().saveConsultaSinFactura(regcirpro, 
                                                                                      usuario, 
                                                                                      servicioAux, 
                                                                                      tipodocu, 
                                                                                      userName());
                    } catch (ModelException e) {
                        wexito = false;
                        navegationRule = "";
                        FacesUtils.addErrorMessage(MSG_NO_ADICION + ":  " + 
                                                   e.getMessage());
                                                   e.printStackTrace();
                    } catch (Exception e1) {
                        wexito = false;
                        navegationRule = "";
                        FacesUtils.addErrorMessage(MSG_NO_ADICION + 
                                                   e1.getMessage());
                                                   e1.printStackTrace();
                    }

                  
                if (wexito) {
                


                    FacesUtils.addInfoMessage(MSG_ADICION);
                    // FacesUtils.resetManagedBean("registrarCirugiaSinFacturaBean");
                    FacesUtils.resetManagedBean("consultarUsuarioConsultaSinFacturaBean");
                    navegationRule = BeanNavegacion.RUTA_IR_CONSULTA_SIN_FACTURA;
                    registrarCirugia = true;
                    FacesUtils.resetManagedBean("registrarConsultaSinFacturaBean");
                } else {
                    navegationRule = "";
                }
            }

    

            return navegationRule;
    
      
    }

    public String seleccionarCirugia() {
        regcirpro = new Chregiconpro();
        regcirpro = (Chregiconpro)dtCirugiasRegistradas.getRowData();
        Cpservicio servicioAux = new Cpservicio();
        try {
            servicioAux = 
                    this.serviceLocator.getClinicoService().getServicioPorId(regcirpro.getHrccservic().getCsvccodigo());
        } catch (ModelException e) {
            e.printStackTrace();
        }
        itDonante.setValue(regcirpro.getHrcndonant());
        itPrograma.setValue(regcirpro.getHrcnprogra());
        itFactura.setValue(regcirpro.getHrcnnumfac());
        itTipusu.setValue(regcirpro.getHrcntipusu());
        itFecha.setValue(regcirpro.getHrcdfeccirpro());
        seleccionServicio = servicioAux.getCsvcnombre();
        registrarCirugia = false;
        selectedIndex = ACTIVAR_MODIFICAR_CIRUGIA;
        return BeanNavegacion.RUTA_ACTUAL;
    }

    /*   public String nuevoRegistro() {
        regcirpro = new Chregicirpro();
        registrarCirugia = true;
        seleccionServicio = " ";
        return BeanNavegacion.RUTA_IR_REGISTRAR_CIRUGIA_SIN_FACTURA;
    }*/

    public String confirmarCirugia() {

        boolean wexito = true;
        regcirpro.setHrccusucnf(userName());
        regcirpro.setHrccetapa(IConstantes.ETAPA_CONFIRMADA);
        navegationRule = "";
        if (regcirpro == null || regcirpro.getHrcnnumfac() == null || 
            regcirpro.getHrcnnumfac().intValue() == 0) {
            FacesUtils.addErrorMessage("body:formRegistrarCirugia:panelTabRegistrarCirugia:numeroFactura", 
                                       MSG_CAMPO_OBLIGATORIO);
            wexito = false;
        }

        /* Selecciona el numero de consulta cl�nica del servicio de la factura de sap */
        if (wexito) {
            try {
                regcirpro.setHrcnconfac(this.serviceLocator.getCirugiaService().getNumeroConsultaClinicaPorDocumento(regcirpro.getHrcnclinic().getCclncodigo(), 
                                                                                                                     IConstantes.CDOC_FACSAP, 
                                                                                                                     regcirpro.getHrcnnumfac(), 
                                                                                                                     regcirpro.getHrccservic().getCsvccodigo()));
            } catch (ModelException e) {
                wexito = false;
                e.printStackTrace();
            }

            if (regcirpro.getHrcnconfac() == null) {
                wexito = false;
                FacesUtils.addErrorMessage(MSG_NO_EXISTE_CONSULTA + 
                                           ": Factura SAP - " + 
                                           regcirpro.getHrcnnumfac());
            }
        }

        /* verifica que la consulta clinica inicial del registro de cirugia sin factura exista y este vigentes */
        if (wexito) {
            Integer wconini = null;
            try {
                wconini = 
                        this.serviceLocator.getCirugiaService().getNumeroConsultaClinicaPorDocumento(regcirpro.getHrcnclinic().getCclncodigo(), 
                                                                                                     IConstantes.CDOC_CISFAC, 
                                                                                                     new BigDecimal(regcirpro.getHrcnnumero()), 
                                                                                                     regcirpro.getHrccservic().getCsvccodigo());
            } catch (ModelException e) {
                wexito = false;
                e.printStackTrace();
            }

            if (wconini == null || 
                wconini.intValue() != regcirpro.getHrcnconini().intValue()) {
                wexito = false;
                FacesUtils.addErrorMessage(MSG_NO_EXISTE_CONSULTA + 
                                           ": Cirugia sin Factura - " + 
                                           regcirpro.getHrcnnumero());
            }
        }

       if (wexito) {
            try {
                this.serviceLocator.getCirugiaService().confirmarConsultaSinFactura(regcirpro);
                FacesUtils.addInfoMessage(MSG_ADICION);
                FacesUtils.resetManagedBean("registrarCirugiaSinFacturaBean");
                FacesUtils.resetManagedBean("consultarUsuarioCirugiaSinFacturaBean");
                navegationRule = 
                        BeanNavegacion.RUTA_IR_CONSULTA_USUARIO_CIRUGIA_SIN_FACTURA;
            } catch (ModelException e) {
                navegationRule = "";
                FacesUtils.addErrorMessage(MSG_NO_ADICION + ":  " + 
                                           e.getMessage());

            } catch (Exception e1) {
                navegationRule = "";
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
                        (ArrayList<Chsexo>)this.getServiceLocator().getClinicoService().getSexoNew();
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

    public void setRenderBuscadorServicio(boolean renderBuscadorServicio) {
        this.renderBuscadorServicio = renderBuscadorServicio;
    }

    public boolean isRenderBuscadorServicio() {
        return renderBuscadorServicio;
    }

    public void renderServicio() {
        renderBuscadorServicio = true;
        selectedIndex = ACTIVAR_BUSCADOR_CIRUGIAS;
        BuscadorServicioBean buscador = 
            (BuscadorServicioBean)FacesUtils.getManagedBean("buscadorServicioBean");
    }


    public void aceptarServicio() {

        BuscadorServicioBean servicioAux = 
            (BuscadorServicioBean)FacesUtils.getManagedBean("buscadorServicioBean");


        if (servicioAux != null && servicioAux.getServicioSelect() != null) {
            lstCirugias.add(servicioAux.getServicioSelect());
            seleccionServicio = 
                    servicioAux.getServicioSelect().getCsvcnombre();

            regcirpro.setHrccservic(servicioAux.getServicioSelect());
            deshabilitarServicio = true;

        }
        selectedIndex = ACTIVAR_MODIFICAR_CIRUGIA;
        renderBuscadorServicio = false;

        FacesUtils.resetManagedBean("buscadorServicioBean");


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

    public void setRegistrarCirugia(boolean registrarCirugia) {
        this.registrarCirugia = registrarCirugia;
    }

    public boolean isRegistrarCirugia() {
        return registrarCirugia;
    }

    public void consultarCirugias() {
        // Consulta cirug�as 
        FacesUtils.resetManagedBean("buscadorCirugiasBean");
        BuscadorCirugiasBean cirugias;
        cirugias = 
                (BuscadorCirugiasBean)FacesUtils.getManagedBean("buscadorCirugiasBean");
        if (cirugias != null) {
            cirugias.init();
        }
        selectedIndex = ACTIVAR_BUSCADOR_CIRUGIAS;
        mostrarCirugias = true;

    }

    /**
     * @param mostrarCirugias
     */
    public void setMostrarCirugias(boolean mostrarCirugias) {
        this.mostrarCirugias = mostrarCirugias;
    }

    /**
     * @return
     */
    public boolean isMostrarCirugias() {
        return mostrarCirugias;
    }

    public void aceptarCirugia() {
        // 
        buscadorCirugias = 
                (BuscadorCirugiasBean)FacesUtils.getManagedBean("buscadorCirugiasBean");
        if (buscadorCirugias != null) {
            lstCirugias = buscadorCirugias.getLstCirugiaSelec();
            if (lstCirugias != null && !lstCirugias.isEmpty()) {
                for (Cpservicio servicio: lstCirugias) {
                    String codigoServicio = servicio.getCsvccodigo();
                }
            }
            mostrarCirugias = false;
            selectedIndex = ACTIVAR_MODIFICAR_CIRUGIA;
        }
    }

    /**
     * @param lstCirugias
     */
    public void setLstCirugias(List<Cpservicio> lstCirugias) {
        this.lstCirugias = lstCirugias;
    }

    /**
     * @return
     */
    public List<Cpservicio> getLstCirugias() {
        return lstCirugias;
    }

    public void eliminarCirugia() {
        // Elimina registro de la cirug�a seleccionado 
        Cpservicio servicioSelec;
        servicioSelec = (Cpservicio)dtServicios.getRowData();
        lstCirugias.remove(servicioSelec);
        if (lstCirugias != null && !lstCirugias.isEmpty()) {
            for (Cpservicio servicio: lstCirugias) {
                String codigoServicio = servicio.getCsvccodigo();
            }

        }

    }

    /**
     * @param dtServicios
     */
    public void setDtServicios(HtmlDataTable dtServicios) {
        this.dtServicios = dtServicios;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtServicios() {
        return dtServicios;
    }

    public void volver() {
        FacesUtils.resetManagedBean("registrarCirugiaSinFacturaBean");
        selectedIndex = ACTIVAR_MODIFICAR_CIRUGIA;

    }


   

    public void setServicioIve(String servicioIve) {
        this.servicioIve = servicioIve;
    }

    public String getServicioIve() {
        return servicioIve;
    }

    public void setListServiciosIve(List listServiciosIve) {
        this.listServiciosIve = listServiciosIve;
    }

    public List getListServiciosIve() { 
    Integer numeroServicio;
    numeroServicio = 44;
    Cpservicio servicio = null;
    if (listServiciosIve == null || listServiciosIve.isEmpty()) {
            listServiciosIve = new ArrayList<SelectItem>();
            ArrayList<Chserxtipo> listServiciosIveAux = null;
            try {
                listServiciosIveAux = 
                        (ArrayList<Chserxtipo>)this.serviceLocator.getClinicoService().getLstServicioXTipo(numeroServicio);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listServiciosIveAux.isEmpty()) {

                Iterator it = listServiciosIveAux.iterator();
                int i = 0;
                listServiciosIve.add(new SelectItem("", 
                                                "Seleccione una opci�n ..."));
               
                                                
                while (it.hasNext()) {
                    try {
                        servicio = (Cpservicio)this.serviceLocator.getClinicoService().getServicioPorId(listServiciosIveAux.get(i).get_comp_id().getHstccodiserv());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    it.next();
                    listServiciosIve.add(new SelectItem(servicio.getCsvccodigo(), 
                                                        servicio.getCsvcnombre()
                                                   ));
                    i++;
                }
            }
        }
        return listServiciosIve;
    }
}
