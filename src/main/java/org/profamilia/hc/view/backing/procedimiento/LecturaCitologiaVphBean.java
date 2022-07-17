//======================================================================================================================
// ARCHIVO LecturaVPHBean
// FECHA CREACI�N: 
// AUTOR: jariano, nlis
// Descripcion: 
//======================================================================================================================
package org.profamilia.hc.view.backing.procedimiento;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cncitovphlect;
import org.profamilia.hc.model.dto.Cndesccito;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


//======================================================================================================================
//  BIBLIOTECAS REQUERIDAS
//======================================================================================================================
//======================================================================================================================
//  CLASE LecturaCitologiaVphBean
//======================================================================================================================
public class LecturaCitologiaVphBean extends BaseBean {

    //------------------------------------------------------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //------------------------------------------------------------------------------------------------------------------
    private Cncitovphlect lectura;

    private List lstPrimeraLectura;

    private boolean mostrarEpiteliales;

    private boolean mostrarGenotipificacion;

    private boolean renderLectura;

    private Chconsulta consulta;

    private Cnconsclin consclin;

    private Cncitologi datos;//Cncitologi
    
    private List lstConducta;

    private List lstGenoPos;

    private List lstGenoPosSelect;
    

    //------------------------------------------------------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //------------------------------------------------------------------------------------------------------------------
    public LecturaCitologiaVphBean() {

    }

    public void init() {

        mostrarGenotipificacion = false;
        lstPrimeraLectura = new ArrayList();
        lstConducta = new ArrayList();
        lstGenoPos = new ArrayList();
        lstGenoPosSelect = new ArrayList();

        try {
            /*
            if (consulta != null) {
                datos
                        = this.serviceLocator.getClinicoService().getUsuarioCitologia(consulta);
            }
            */
            if (consclin != null) {
                datos = this.serviceLocator.getClinicoService().getUsuarioCitologia(consclin);
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }

        try {
            if (datos != null && datos.getCcinconsec() != null) {
                lectura = this.serviceLocator.getClinicoService().getLecturaCitologiaVph(datos.getCcinconsec());
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (lectura == null) {
            lectura = new Cncitovphlect();
        } else {
            if (lectura.getCcvcgenoneg() != null && lectura.getCcvcgenoneg().equals("N")) {
                mostrarGenotipificacion = true;
            } else {
                mostrarGenotipificacion = false;
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //  Get/Set
    //------------------------------------------------------------------------------------------------------------------
    /**
     * @param lectura
     */
    public void setLectura(Cncitovphlect lectura) {
        this.lectura = lectura;
    }

    /**
     * @return
     */
    public Cncitovphlect getLectura() {
        return lectura;
    }

    public Cncitologi getDatos() {
        return datos;
    }

    public void setDatos(Cncitologi datos) {
        this.datos = datos;
    }

    public List getLstConducta() {
        if (lstConducta.size() == 0) {
            ArrayList<Cndesccito> lstAux = null;
            try {
                lstAux
                        = (ArrayList<Cndesccito>) this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("chlibrovph",
                                "ctmcvphcond");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstAux.isEmpty()) {
                Iterator it = lstAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstConducta.add(new SelectItem((lstAux.get(i).getCdicvalor()),
                            lstAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstConducta;
    }

    public void setLstConducta(List lstConducta) {
        this.lstConducta = lstConducta;
    }
    
    public List getLstGenoPos() {
        if (lstGenoPos.size() == 0) {
            ArrayList<Cndesccito> lstAux = null;
            try {
                lstAux
                        = (ArrayList<Cndesccito>) this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cnvphlect",
                                "ctmcvphgeno");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstAux.isEmpty()) {
                Iterator it = lstAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstGenoPos.add(new SelectItem((lstAux.get(i).getCdicvalor()),
                            lstAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstGenoPos;
    }

    public void setLstGenoPos(List lstGenoPos) {
        this.lstGenoPos = lstGenoPos;
    }

    public List getLstGenoPosSelect() {
        return lstGenoPosSelect;
    }

    public void setLstGenoPosSelect(List lstGenoPosSelect) {
        this.lstGenoPosSelect = lstGenoPosSelect;
    }

    /**
     * @param consulta
     */
    public void setConsulta(Chconsulta consulta) {
        this.consulta = consulta;
    }

    /**
     * @return
     */
    public Chconsulta getConsulta() {
        return consulta;
    }

    public Cnconsclin getConsclin() {
        return consclin;
    }

    public void setConsclin(Cnconsclin consclin) {
        this.consclin = consclin;
    }

    public boolean isMostrarGenotipificacion() {
        return mostrarGenotipificacion;
    }

    public void setMostrarGenotipificacion(boolean mostrarGenotipificacion) {
        this.mostrarGenotipificacion = mostrarGenotipificacion;
    }

    /**
     * @param renderLectura
     */
    public void setRenderLectura(boolean renderLectura) {
        this.renderLectura = renderLectura;
    }

    /**
     * @return
     */
    public boolean isRenderLectura() {
        return renderLectura;
    }

    /**
     * @param valueChangeEvent
     */
    public void setCcvcgenoneg(ValueChangeEvent valueChangeEvent) {
        lectura.setCcvcgenoneg((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void setCcvcgt16(ValueChangeEvent valueChangeEvent) {
        lectura.setCcvcgt16((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void setCcvcgt18(ValueChangeEvent valueChangeEvent) {
        lectura.setCcvcgt18((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void setCcvcgt31(ValueChangeEvent valueChangeEvent) {
        lectura.setCcvcgt31((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void setCcvcgt45(ValueChangeEvent valueChangeEvent) {
        lectura.setCcvcgt45((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void setCcvcgt51(ValueChangeEvent valueChangeEvent) {
        lectura.setCcvcgt51((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void setCcvcgt52(ValueChangeEvent valueChangeEvent) {
        lectura.setCcvcgt52((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void setCcvcgt3858(ValueChangeEvent valueChangeEvent) {
        lectura.setCcvcgt3858((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void setCcvcgt353968(ValueChangeEvent valueChangeEvent) {
        lectura.setCcvcgt353968((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void setCcvcgt565966(ValueChangeEvent valueChangeEvent) {
        lectura.setCcvcgt565966((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param mostrarEpiteliales
     */
    public void setMostrarEpiteliales(boolean mostrarEpiteliales) {
        this.mostrarEpiteliales = mostrarEpiteliales;
    }

    /**
     * @return
     */
    public boolean isMostrarEpiteliales() {
        return mostrarEpiteliales;
    }

    /**
     * @param lstPrimeraLectura
     */
    public void setLstPrimeraLectura(List lstPrimeraLectura) {
        this.lstPrimeraLectura = lstPrimeraLectura;
    }

    /**
     * @return
     */
    public List getLstPrimeraLectura() {
        if (lstPrimeraLectura.size() == 0) {
            ArrayList<Cndesccito> lstLecturaAux = null;
            try {
                lstLecturaAux
                        = (ArrayList<Cndesccito>) this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitolect",
                                "clccprilec");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstLecturaAux.isEmpty()) {

                lstPrimeraLectura.add(new SelectItem("",
                        "Seleccione una opcion ..."));
                Iterator it = lstLecturaAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstPrimeraLectura.add(new SelectItem((lstLecturaAux.get(i).getCdicvalor()),
                            lstLecturaAux.get(i).getCdicvalor()
                            + "  "
                            + lstLecturaAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstPrimeraLectura;
    }

    //------------------------------------------------------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //------------------------------------------------------------------------------------------------------------------
    // ValueChangeEvent
    public void changeGenotipificacion() {
        if (lectura.getCcvcgenoneg() != null
                && lectura.getCcvcgenoneg().equals("N")) {
            mostrarGenotipificacion = true;
        } else {
            mostrarGenotipificacion = false;
            lectura.setCcvcgt16("N");
            lectura.setCcvcgt18("N");
            lectura.setCcvcgt31("N");
            lectura.setCcvcgt45("N");
            lectura.setCcvcgt51("N");
            lectura.setCcvcgt52("N");
            
            lectura.setCcvcgt3858("N");
            lectura.setCcvcgt353968("N");
            lectura.setCcvcgt565966("N");
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //  Boton Principal 
    //------------------------------------------------------------------------------------------------------------------

    /**
     * @return
     */
    public String aceptar() {
        boolean wexito = true;
        StringBuffer sbErrorres = new StringBuffer();

        String genoPos = "";
        if (lstGenoPosSelect != null && !lstGenoPosSelect.isEmpty()) {
            Iterator it = lstGenoPosSelect.iterator();
            int i = 0;
            while (it.hasNext()) {
                genoPos = genoPos + "," + lstGenoPosSelect.get(i);
                it.next();
                i++;
            }

            if (genoPos != null && genoPos.length() > 2) {
                genoPos = genoPos.substring(1, genoPos.length());
            }
        }
        if (datos != null && lectura != null) {
            lectura.setCcvdfeclec(new Date());
            lectura.setCcvdfecreg(new Date());
            lectura.setCcvcusureg(userName());
            lectura.setCcvnconsec(datos.getCcinconsec());
            lectura.setCcvnclinic(this.getClinica().getCclncodigo());
            lectura.setCcvnnumero(datos.getCcinnumero());
            
            
            if (userName() != null) {
                Cpprofesio profesional;
                profesional = null;
                try {
                    if (this.getClinica() != null) {
                        profesional = serviceLocator.getClinicoService().getProfesionalPorUsuario(userName(),
                                        getClinica().getCclncodigo());
                    }

                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (profesional != null && profesional.getCpfntippro() != null) {
                    int tipoProf = profesional.getCpfntippro();
                    switch (tipoProf) {//Codigos seg�n Cptipoespe
                        case 15: //BACTERIOLOGO
                            lectura.setCcvclectur("15");
                            break;
                        default:
                        lectura.setCcvclectur("15");  //REMOVER ESTA LINEA
                        sbErrorres.append("La lectura se debe realizar por un Bacteri�logo.");
                    }
                }

                if (lectura.getCcvclectur() == null) {
                    lectura.setCcvclectur("15");
                    //wexito = false;
                    sbErrorres.append("La lectura se debe realizar por un Bacteri�logo.");
                }
                
                if (lectura.getCcvcgenoneg() == null) {
                    lectura.setCcvcgenoneg("S");
                }
                if ("N".equals(lectura.getCcvcgenoneg())) {
                    if ("N".equals(lectura.getCcvcgt16()) && "N".equals(lectura.getCcvcgt18())
                        && "N".equals(lectura.getCcvcgt31()) && "N".equals(lectura.getCcvcgt45())
                        && "N".equals(lectura.getCcvcgt51()) && "N".equals(lectura.getCcvcgt52())
                        && "N".equals(lectura.getCcvcgt3858()) && "N".equals(lectura.getCcvcgt353968())
                        && "N".equals(lectura.getCcvcgt565966())
                        ) {
                            wexito = false;
                            if (sbErrorres.toString().length() > 0) {
                                sbErrorres.append(", ");
                            }
                            sbErrorres.append("Si el Resultado de la Genotipificaci�n es positivo, al menos una opci�n debe ser positiva.");
                        }
                }
            }
            lectura.setCcvcnomlec(getUsuarioSystem().getCurcnombre());
            

        } else {
            wexito = false;
        }
        if (wexito) {
            try {
                this.serviceLocator.getClinicoService().saveLecturaCitologiaVph(lectura);
                consclin.setCcocetapa(IConstantes.ETAPA_ATENDIDO);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                FacesUtils.resetManagedBean("lecturaCitologiaVphBean");
                FacesUtils.resetManagedBean("consultarFoliosVphBean");
                FacesUtils.resetManagedBean("consultarUsuarioBean");
                return BeanNavegacion.RUTA_IR_INICIO;
            } catch (Exception e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                e.printStackTrace();
                return BeanNavegacion.RUTA_ACTUAL;
            }
        }
        if (sbErrorres.toString().length() > 0) {
            FacesUtils.addErrorMessage(sbErrorres.toString());
        }
         
        return BeanNavegacion.RUTA_ACTUAL;
    }
    
    

}
