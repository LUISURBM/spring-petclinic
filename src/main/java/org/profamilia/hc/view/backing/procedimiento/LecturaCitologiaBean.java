//======================================================================================================================
// ARCHIVO LecturaCitologiaBean
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
import org.profamilia.hc.model.dto.Cncitolect;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cndesccito;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.webService.saludTotal.dto.response.ResultadosLCResponse;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
//======================================================================================================================
//  BIBLIOTECAS REQUERIDAS
//======================================================================================================================


//======================================================================================================================
//  CLASE LecturaCitologiaBean
//======================================================================================================================
public class LecturaCitologiaBean extends BaseBean {
    //------------------------------------------------------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //------------------------------------------------------------------------------------------------------------------
    private Cncitolect lectura;

    private List lstPrimeraLectura;

    private List lstSegundaLectura;

    private List lstMuestra;

    private List lstMicroorganismos;

    private List Categorizacion;

    private List lstHallazgos;

    private List lstAnomalidadesEscamosas;

    private List lstAnomalidadesGlandulares;

    private List lstCategorizacion;

    private boolean mostrarMicroOrganismos;

    private boolean mostrarEpiteliales;
    
    private boolean renderLectura; 

    private Cnconsclin consulta;

    private Cncitologi citologia;
    
    private Integer tipoLecturaCitologia; 

    //------------------------------------------------------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //------------------------------------------------------------------------------------------------------------------

    public LecturaCitologiaBean() {

    }

    public void init() {

        lstPrimeraLectura = new ArrayList();
        lstMuestra = new ArrayList();
        lstMicroorganismos = new ArrayList();
        Categorizacion = new ArrayList();
        lstHallazgos = new ArrayList();
        lstAnomalidadesEscamosas = new ArrayList();
        lstAnomalidadesGlandulares = new ArrayList();
        lstSegundaLectura = new ArrayList();
        lstCategorizacion = new ArrayList();
        lectura = null;
        mostrarMicroOrganismos = false;
        renderLectura=false;

/*
        try {
            if (consulta != null) {
               citologia = this.serviceLocator.getClinicoService().getUsuarioCitologia(consulta);
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }
*/
        try {
            if (citologia != null && citologia.getCcinconsec() != null) {
                lectura = 
                        this.serviceLocator.getClinicoService().getLecturaCitologia(citologia.getCcinconsec());
                renderLectura = true; 
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (lectura == null) {
            lectura = new Cncitolect();
        } else {
            if (lectura != null && lectura.getClccmicorg() != null && 
                lectura.getClccmicorg().equals(IConstantes.CALIDAD_DE_MUESTRA_OTROS)) {
                mostrarMicroOrganismos = true;
            } else {
                mostrarMicroOrganismos = false;
            }

            if (lectura != null && lectura.getClcccatego() != null && 
                lectura.getClcccatego().equals(IConstantes.ANORMALIDADES_CELULARES_EPTITELIALES)) {
                mostrarEpiteliales = true;
            } else {
                mostrarEpiteliales = false;
            }
        }
    }


    //------------------------------------------------------------------------------------------------------------------
    //  Get/Set
    //------------------------------------------------------------------------------------------------------------------

    /**
     * @param lectura
     */
    public void setLectura(Cncitolect lectura) {
        this.lectura = lectura;
    }

    /**
     * @return
     */
    public Cncitolect getLectura() {
        return lectura;
    }


    /**
     * @param citologia
     */
    public void setCitologia(Cncitologi citologia) {
        this.citologia = citologia;
    }

    /**
     * @return
     */
    public Cncitologi getCitologia() {
        return citologia;
    }

    /**
     * @param consulta
     */
    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    /**
     * @return
     */
    public Cnconsclin getConsulta() {
        return consulta;
    }

    /**
     * @param mostrarMicroOrganismos
     */
    public void setMostrarMicroOrganismos(boolean mostrarMicroOrganismos) {
        this.mostrarMicroOrganismos = mostrarMicroOrganismos;
    }

    /**
     * @return
     */
    public boolean isMostrarMicroOrganismos() {
        return mostrarMicroOrganismos;
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
     * @param lstMuestra
     */
    public void setLstMuestra(List lstMuestra) {
        this.lstMuestra = lstMuestra;
    }

    /**
     * @return
     */
    public List getLstMuestra() {
        if (lstMuestra.size() == 0) {
            ArrayList<Cndesccito> lstLecturaAux = null;
            try {
                lstLecturaAux = 
                        (ArrayList<Cndesccito>)this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitolect", 
                                                                                                                           "clcccalmue");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstLecturaAux.isEmpty()) {

                lstMuestra.add(new SelectItem("", 
                                              "Seleccione una opcion ..."));
                Iterator it = lstLecturaAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstMuestra.add(new SelectItem((lstLecturaAux.get(i).getCdicvalor()), 
                                                  lstLecturaAux.get(i).getCdicvalor() + 
                                                  "  " + 
                                                  lstLecturaAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        System.out.print(lectura.getClcccalmue()+" Test");
        if (lectura != null && lectura.getClcccalmue() != null && !lectura.getClcccalmue().equals("4.3") && 
            !lectura.getClcccalmue().equals("4.4")) {
            renderLectura = true;
        } else {
            renderLectura = false;
        }
        System.out.print("render "+renderLectura);
        return lstMuestra;
    }

    /**
     * @param lstMicroorganismos
     */
    public void setLstMicroorganismos(List lstMicroorganismos) {
        this.lstMicroorganismos = lstMicroorganismos;
    }

    /**
     * @return
     */
    public List getLstMicroorganismos() {
        if (lstMicroorganismos.size() == 0) {
            ArrayList<Cndesccito> lstLecturaAux = null;
            try {
                lstLecturaAux = 
                        (ArrayList<Cndesccito>)this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitolect", 
                                                                                                                           "clccmicorg");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstLecturaAux.isEmpty()) {

                lstMicroorganismos.add(new SelectItem("", 
                                                      "Seleccione una opcion ..."));
                Iterator it = lstLecturaAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstMicroorganismos.add(new SelectItem((lstLecturaAux.get(i).getCdicvalor()), 
                                                          lstLecturaAux.get(i).getCdicvalor() + 
                                                          "  " + 
                                                          lstLecturaAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstMicroorganismos;
    }

    /**
     * @param categorizacion
     */
    public void setCategorizacion(List categorizacion) {
        this.Categorizacion = categorizacion;
    }

    /**
     * @return
     */
    public List getCategorizacion() {
        return Categorizacion;
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
     * @param lstHallazgos
     */
    public void setLstHallazgos(List lstHallazgos) {
        this.lstHallazgos = lstHallazgos;
    }

    /**
     * @return
     */
    public List getLstHallazgos() {
        if (lstHallazgos.size() == 0) {
            ArrayList<Cndesccito> lstLecturaAux = null;
            try {
                lstLecturaAux = 
                        (ArrayList<Cndesccito>)this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitolect", 
                                                                                                                           "clccotrhal");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstLecturaAux.isEmpty()) {

                lstHallazgos.add(new SelectItem("", 
                                                "Seleccione una opcion ..."));
                Iterator it = lstLecturaAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstHallazgos.add(new SelectItem((lstLecturaAux.get(i).getCdicvalor()), 
                                                    lstLecturaAux.get(i).getCdicvalor() + 
                                                    "  " + 
                                                    lstLecturaAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstHallazgos;
    }


    /**
     * @param lstAnomalidadesEscamosas
     */
    public void setLstAnomalidadesEscamosas(List lstAnomalidadesEscamosas) {
        this.lstAnomalidadesEscamosas = lstAnomalidadesEscamosas;
    }

    /**
     * @return
     */
    public List getLstAnomalidadesEscamosas() {
        if (lstAnomalidadesEscamosas.size() == 0) {
            ArrayList<Cndesccito> lstLecturaAux = null;
            try {
                lstLecturaAux = 
                        (ArrayList<Cndesccito>)this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitolect", 
                                                                                                                           "clccanoesc");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstLecturaAux.isEmpty()) {

                lstAnomalidadesEscamosas.add(new SelectItem("", 
                                                            "Seleccione una opcion ..."));
                Iterator it = lstLecturaAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstAnomalidadesEscamosas.add(new SelectItem((lstLecturaAux.get(i).getCdicvalor()), 
                                                                lstLecturaAux.get(i).getCdicvalor() + 
                                                                "  " + 
                                                                lstLecturaAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstAnomalidadesEscamosas;
    }


    /**
     * @param lstAnomalidadesGlandulares
     */
    public void setLstAnomalidadesGlandulares(List lstAnomalidadesGlandulares) {
        this.lstAnomalidadesGlandulares = lstAnomalidadesGlandulares;
    }

    /**
     * @return
     */
    public List getLstAnomalidadesGlandulares() {
        if (lstAnomalidadesGlandulares.size() == 0) {
            ArrayList<Cndesccito> lstLecturaAux = null;
            try {
                lstLecturaAux = 
                        (ArrayList<Cndesccito>)this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitolect", 
                                                                                                                           "clccanogla");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstLecturaAux.isEmpty()) {

                lstAnomalidadesGlandulares.add(new SelectItem("", 
                                                              "Seleccione una opcion ..."));
                Iterator it = lstLecturaAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstAnomalidadesGlandulares.add(new SelectItem((lstLecturaAux.get(i).getCdicvalor()), 
                                                                  lstLecturaAux.get(i).getCdicvalor() + 
                                                                  "  " + 
                                                                  lstLecturaAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstAnomalidadesGlandulares;
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
                lstLecturaAux = 
                        (ArrayList<Cndesccito>)this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitolect", 
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
                                                         lstLecturaAux.get(i).getCdicvalor() + 
                                                         "  " + 
                                                         lstLecturaAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstPrimeraLectura;
    }

    /**
     * @param lstSegundaLectura
     */
    public void setLstSegundaLectura(List lstSegundaLectura) {
        this.lstSegundaLectura = lstSegundaLectura;
    }

    /**
     * @return
     */
    public List getLstSegundaLectura() {
        if (lstSegundaLectura.size() == 0) {
            ArrayList<Cndesccito> lstLecturaAux = null;
            try {
                lstLecturaAux = 
                        (ArrayList<Cndesccito>)this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitolect", 
                                                                                                                           "clccseglec");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstLecturaAux.isEmpty()) {

                lstSegundaLectura.add(new SelectItem("", 
                                                     "Seleccione una opcion ..."));
                Iterator it = lstLecturaAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstSegundaLectura.add(new SelectItem((lstLecturaAux.get(i).getCdicvalor()), 
                                                         lstLecturaAux.get(i).getCdicvalor() + 
                                                         "  " + 
                                                         lstLecturaAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstSegundaLectura;
    }

    /**
     * @param lstCategorizacion
     */
    public void setLstCategorizacion(List lstCategorizacion) {
        this.lstCategorizacion = lstCategorizacion;
    }

    /**
     * @return
     */
    public List getLstCategorizacion() {
        if (lstCategorizacion.size() == 0) {
            ArrayList<Cndesccito> lstLecturaAux = null;
            try {
                lstLecturaAux = 
                        (ArrayList<Cndesccito>)this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitolect", 
                                                                                                                           "clcccatego");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstLecturaAux.isEmpty()) {

                lstCategorizacion.add(new SelectItem("", 
                                                     "Seleccione una opcion ..."));
                Iterator it = lstLecturaAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstCategorizacion.add(new SelectItem((lstLecturaAux.get(i).getCdicvalor()), 
                                                         lstLecturaAux.get(i).getCdicvalor() + 
                                                         "  " + 
                                                         lstLecturaAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstCategorizacion;
    }

    //------------------------------------------------------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //------------------------------------------------------------------------------------------------------------------

    public void changeMicroorganismos() {
        if (lectura != null && lectura.getClccmicorg() != null && 
            lectura.getClccmicorg().equals(IConstantes.CALIDAD_DE_MUESTRA_OTROS)) {
            mostrarMicroOrganismos = true;
        } else {
            mostrarMicroOrganismos = false;
        }
    }


    public void changeCategorizacion() {
        if (lectura != null && lectura.getClcccatego() != null && 
            lectura.getClcccatego().equals(IConstantes.ANORMALIDADES_CELULARES_EPTITELIALES)) {
            mostrarEpiteliales = true;
        } else {
            mostrarEpiteliales = false;
        }
    }
    
    public void changeCalidad(){
        renderLectura = false; 
            
            if(lectura!= null && lectura.getClcccalmue() != null 
            && (!lectura.getClcccalmue().equals("4.3") && !lectura.getClcccalmue().equals("4.4") )  ){
                renderLectura = true; 
            }
        
    }

    // ValueChangeEvent

    /**
     * @param valueChangeEvent
     */
    public void setClccmicorg(ValueChangeEvent valueChangeEvent) {
        lectura.setClccmicorg((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setClcccatego(ValueChangeEvent valueChangeEvent) {
        lectura.setClcccatego((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setClcccalmue(ValueChangeEvent valueChangeEvent) {
        lectura.setClcccalmue((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    //------------------------------------------------------------------------------------------------------------------
    //  Boton Principal 
    //------------------------------------------------------------------------------------------------------------------

    /**
     * @return
     */
    public String aceptar() {
        boolean wexito = true;


        if (lectura != null && lectura.getClcdprilec() != null && 
            lectura.getClcdseglec() != null) {
            if (lectura.getClcdprilec().after(lectura.getClcdseglec())) {
                FacesUtils.addErrorMessage("body:formLecturaCitologia:panelTabLecturaCitologia:calendarSegundaLectura", 
                                           MSG_FECHA_INCORRECTA_CITOLOGIA);
                wexito = false;
            }

        }
        
        if(lectura!= null && lectura.getClcccalmue() != null 
        && (lectura.getClcccalmue().equals("4.3") || lectura.getClcccalmue().equals("4.4"))){
            lectura.setClccmicorg(null);
            lectura.setClccotrmic(null);
            lectura.setClcccatego(null);
            lectura.setClccanoesc(null);
            lectura.setClccanogla(null);
            lectura.setClccotrhal(null);
            lectura.setClccotrneo(null);
        }
        
        if (citologia != null) {

            lectura.setClcdfecreg(new Date());
            lectura.setClccusureg(userName());
            lectura.setClcnconsec(citologia.getCcinconsec());
            lectura.setClcnclinic(this.getClinica().getCclncodigo());
            lectura.setClcnnumero(citologia.getCcinnumero());

        } else {
            wexito = false;
        }
        if (wexito) {
            try {
                this.serviceLocator.getClinicoService().saveLecturaCitologia(lectura,consulta,userName(),tipoLecturaCitologia);
                //this.serviceLocator.getClinicoService().closeLecturaCitologia(consulta);
              /* if (consulta != null && consulta.getCconcontra() != null && (consulta.getCconcontra().equals(IConstantes.NUM_CONTRATO_SALUDTOTAL1) || 
                    consulta.getCconcontra().equals(IConstantes.NUM_CONTRATO_SALUDTOTAL2))) {
                    if (tipoLecturaCitologia.equals(IConstantes.HISTORIA_LECTURA_CITOLOGIA_BASE_LIQUIDA)) {
                        ResultadosLCResponse resultadosLCResponse = 
                            new ResultadosLCResponse();
                        resultadosLCResponse = 
                                this.serviceLocator.getClinicoService().envioResultadosBaseLiquidSaludTotal(consulta.getCcolusuario(), 
                                                                                                            consulta, 
                                                                                                            lectura);
                        if (resultadosLCResponse.getData().getError().equals("0")) {
                            FacesUtils.addInfoMessage(IMsg.MSG_ADICION + 
                                                      "Respuesta WS: " + 
                                                      resultadosLCResponse.getNotification().getMessage() + 
                                                      " Estado: " + 
                                                      resultadosLCResponse.getNotification().getStatus());
                        } else {
                            FacesUtils.addInfoMessage(IMsg.MSG_ADICION + 
                                                      "Respuesta WS:" + 
                                                      "Error: " + 
                                                      resultadosLCResponse.getData().getError() + 
                                                      " " + "Descripcion:  " + 
                                                      resultadosLCResponse.getData().getDescripcion() + 
                                                      " " + "Resultado LC: " + 
                                                      resultadosLCResponse.getData().getResultadoLC());
                        }
                    }
                }*/
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                FacesUtils.resetManagedBean("lecturaCitologiaBean");
                FacesUtils.resetManagedBean("consultarFoliosCitologiaBean");
                FacesUtils.resetManagedBean("consultarUsuarioBean");
                return BeanNavegacion.RUTA_IR_INICIO;
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                e.printStackTrace();
                return BeanNavegacion.RUTA_ACTUAL;
            }
        }
        return BeanNavegacion.RUTA_ACTUAL;
    }


    public void setTipoLecturaCitologia(Integer tipoLecturaCitologia) {
        this.tipoLecturaCitologia = tipoLecturaCitologia;
    }

    public Integer getTipoLecturaCitologia() {
        return tipoLecturaCitologia;
    }
}
