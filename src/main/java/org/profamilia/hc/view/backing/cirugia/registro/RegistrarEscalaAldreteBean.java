package org.profamilia.hc.view.backing.cirugia.registro;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chaldrete;
import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class RegistrarEscalaAldreteBean extends BaseBean {

    private Chcirugprogr cirugia;

    private String menuBean;

    private HtmlDataTable dtCirugias;

    private List lstCirugias;

    private List<Cnconsclin> lstConsclin;

    private String esHoraActual;

    private List lstOpciones;

    private boolean mostrarHoraActual;

    private Integer tiempoAdministracion;

    private String navegationRule;

    private String nextAction;

    private List lstActividad;

    private List lstRespiracion;

    private List lstCirculacion;

    private List lstEstadoConciencia;

    private List lstSaturacion;

    private List lstAmbulacion;

    private List lstDolor;

    private List lstSangrado;

    private List lstTolerancia;

    private List lstEliminacion;

    private Chaldrete aldreteObject;

    private Chaldrete bromageObject;

    private boolean renderAmbulatorio;

    private String msgAdvertencia;

    private String msgAdvertencia2;

    private String msgAdvertencia3;

    private String numeroEscala;

    private List lstEscalaBromage;

    private List<Chaldrete> lstHistorial;

    private String msgActividad;

    private String msgRespiracion;

    private String msgCirculacion;

    private String msgEstado;

    private String msgSaturacion;

    private String msgAmbulacion;

    private String msgDolor;

    private String msgSangrado;

    private String msgTolerancia;

    private String msgEliminacion;

    public RegistrarEscalaAldreteBean() {
    }

    public void init() {

        lstCirugias = new ArrayList();
        dtCirugias = new HtmlDataTable();
        aldreteObject = new Chaldrete();
        bromageObject = new Chaldrete();
        msgAdvertencia = "";
        msgAdvertencia2 = "";
        msgAdvertencia3 = "";
    

        StringBuffer sb = new StringBuffer();
        sb.append("Para autorizar el traslado a su habitaci�n el paciente hospitalizado debe tener m�nimo 8 puntos.  ");

        StringBuffer sb2 = new StringBuffer();
        sb2.append("Para autorizar el egreso del (la) paciente ambulatoria/o debe tener 10 puntos para sentarla/o y  vestirse sola/o");

        StringBuffer sb3 = new StringBuffer();
        sb3.append("Para autorizar el egreso del (la) paciente ambulatoria/o debe tener  17 puntos para dar alta de la instituci�n   ");


        msgAdvertencia = sb.toString();
        msgAdvertencia2 = sb2.toString();
        msgAdvertencia3 = sb3.toString();


        if (cirugia != null) {
            try {
                lstConsclin = 
                        this.serviceLocator.getCirugiaService().getCirugiasPorFactura(cirugia);
            } catch (ModelException e) {
                e.printStackTrace();
            }


            // Cargamos las cirugias programadas
            if (lstConsclin != null && !lstConsclin.isEmpty()) {
                Iterator it = lstConsclin.iterator();
                Cnconsclin conclin;

                while (it.hasNext()) {
                    conclin = (Cnconsclin)it.next();
                    lstCirugias.add(conclin.getCcocservic());
                }
            }


            if (cirugia.getChdetacirpros() != null && 
                !cirugia.getChdetacirpros().isEmpty()) {
                Chdetacirpro detalle = null;
                Iterator it = cirugia.getChdetacirpros().iterator();
                while (it.hasNext()) {
                    detalle = (Chdetacirpro)it.next();

                    if (detalle != null && detalle.getId() != null && 
                        detalle.getId().getHdccservicio() != null) {
                        Cpservicio servicio;
                        servicio = null;
                        try {
                            servicio = 
                                    this.serviceLocator.getClinicoService().getServicioPorId(detalle.getId().getHdccservicio());
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }
                        lstCirugias.add(servicio);
                    }
                }
            }
            cargarHistorial();

        }
    }


    public void cargarHistorial() {
        if (cirugia != null && cirugia.getHcplnumero() != null) {
            try {
                lstHistorial = 
                        serviceLocator.getCirugiaService().getAldrete(cirugia.getHcplnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * @param valueChangeEvent
     */
    public void setEsHoraActual(ValueChangeEvent valueChangeEvent) {
        setEsHoraActual((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHalnactividad(ValueChangeEvent valueChangeEvent) {
        aldreteObject.setHalnactividad((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHalnrespiracio(ValueChangeEvent valueChangeEvent) {
        aldreteObject.setHalnrespiracio((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHalncirculacio(ValueChangeEvent valueChangeEvent) {
        aldreteObject.setHalncirculacio((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHalnestadconci(ValueChangeEvent valueChangeEvent) {
        aldreteObject.setHalnestadconci((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHalnsaturoxige(ValueChangeEvent valueChangeEvent) {
        aldreteObject.setHalnsaturoxige((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHalnambulacion(ValueChangeEvent valueChangeEvent) {
        aldreteObject.setHalnambulacion((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setHalndolor(ValueChangeEvent valueChangeEvent) {
        aldreteObject.setHalndolor((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setHalnsangrposqu(ValueChangeEvent valueChangeEvent) {
        aldreteObject.setHalnsangrposqu((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setHalntolerliqui(ValueChangeEvent valueChangeEvent) {
        aldreteObject.setHalntolerliqui((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setHalnelimiurina(ValueChangeEvent valueChangeEvent) {
         aldreteObject.setHalnelimiurina((Integer)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }


    /**
     * @param cirugia
     */
    public void setCirugia(Chcirugprogr cirugia) {
        this.cirugia = cirugia;
    }

    /**
     * @return
     */
    public Chcirugprogr getCirugia() {
        return cirugia;
    }


    /**
     * @param dtCirugias
     */
    public void setDtCirugias(HtmlDataTable dtCirugias) {
        this.dtCirugias = dtCirugias;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCirugias() {
        return dtCirugias;
    }

    /**
     * @param lstCirugias
     */
    public void setLstCirugias(List lstCirugias) {
        this.lstCirugias = lstCirugias;
    }

    /**
     * @return
     */
    public List getLstCirugias() {
        return lstCirugias;
    }

    /**
     * @param msgAdvertencia
     */
    public void setMsgAdvertencia(String msgAdvertencia) {
        this.msgAdvertencia = msgAdvertencia;
    }

    /**
     * @return
     */
    public String getMsgAdvertencia() {
        return msgAdvertencia;
    }

    /**
     * @param msgAdvertencia2
     */
    public void setMsgAdvertencia2(String msgAdvertencia2) {
        this.msgAdvertencia2 = msgAdvertencia2;
    }

    /**
     * @return
     */
    public String getMsgAdvertencia2() {
        return msgAdvertencia2;
    }

    /**
     * @param msgAdvertencia3
     */
    public void setMsgAdvertencia3(String msgAdvertencia3) {
        this.msgAdvertencia3 = msgAdvertencia3;
    }

    /**
     * @return
     */
    public String getMsgAdvertencia3() {
        return msgAdvertencia3;
    }

    /**
     * @param menuBean
     */
    public void setMenuBean(String menuBean) {
        this.menuBean = menuBean;
    }

    /**
     * @return
     */
    public String getMenuBean() {
        return menuBean;
    }


    public void ChangeEsHoraActual() {
        if (esHoraActual != null && esHoraActual.equals("N")) {
            mostrarHoraActual = true;
        } else {
            mostrarHoraActual = false;
        }
    }


    /**
     * @param esHoraActual
     */
    public void setEsHoraActual(String esHoraActual) {
        this.esHoraActual = esHoraActual;
    }

    /**
     * @return
     */
    public String getEsHoraActual() {
        return esHoraActual;
    }

    /**
     * @param lstOpciones
     */
    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    /**
     * @return
     */
    public List getLstOpciones() {
        if (lstOpciones == null) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
    }

    /**
     * @param mostrarHoraActual
     */
    public void setMostrarHoraActual(boolean mostrarHoraActual) {
        this.mostrarHoraActual = mostrarHoraActual;
    }

    /**
     * @return
     */
    public boolean isMostrarHoraActual() {
        return mostrarHoraActual;
    }

    /**
     * @param tiempoAdministracion
     */
    public void setTiempoAdministracion(Integer tiempoAdministracion) {
        this.tiempoAdministracion = tiempoAdministracion;
    }

    /**
     * @return
     */
    public Integer getTiempoAdministracion() {
        return tiempoAdministracion;
    }

    /**
     * @param navegationRule
     */
    public void setNavegationRule(String navegationRule) {
        this.navegationRule = navegationRule;
    }

    /**
     * @return
     */
    public String getNavegationRule() {
        return navegationRule;
    }

    /**
     * @return
     */
    public String aceptar() {
        nextAction = "";
        aldreteObject.setHalnclinica(this.getClinica().getCclncodigo());
        aldreteObject.setHalcestado(ESTADO_VIGENTE);
        aldreteObject.setHaldfecregistr(new Date());
        aldreteObject.setHalcoperador(userName());
        aldreteObject.setHalctipoescal(ESCALA_ADRETE);
        if (cirugia != null) {
            aldreteObject.setHallusuario(cirugia.getHcplusuario().getHuslnumero());
            aldreteObject.getId().setHallconsulta(cirugia.getHcplnumero());
        }

        if (esHoraActual != null && esHoraActual.equals("N") && 
            tiempoAdministracion != null) {

            Calendar fechaCalendarAdmin;
            fechaCalendarAdmin = Calendar.getInstance();
            fechaCalendarAdmin.setTime(new Date());
            fechaCalendarAdmin.add(Calendar.MINUTE, 
                                   (tiempoAdministracion * -1));
            aldreteObject.setHaldfechaactiv(fechaCalendarAdmin.getTime());


        } else {
            aldreteObject.setHaldfechaactiv(new Date());
        }


        try {
            this.serviceLocator.getCirugiaService().saveAldrete(aldreteObject);
            calcularEscalaAldrete();
            nextAction = navegationRule;
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            e.printStackTrace();
        }


        return BeanNavegacion.RUTA_ACTUAL;


    }

    /**
     * @return
     */
    public String aceptarBromage() {
        nextAction = "";
        bromageObject.setHalnclinica(this.getClinica().getCclncodigo());
        bromageObject.setHalcestado(ESTADO_VIGENTE);
        bromageObject.setHaldfecregistr(new Date());
        bromageObject.setHalcoperador(userName());
        bromageObject.setHalctipoescal(ESCALA_BROMAGE);
        if (cirugia != null) {
            bromageObject.setHallusuario(cirugia.getHcplusuario().getHuslnumero());
            bromageObject.getId().setHallconsulta(cirugia.getHcplnumero());
        }

        if (esHoraActual != null && esHoraActual.equals("N") && 
            tiempoAdministracion != null) {

            Calendar fechaCalendarAdmin;
            fechaCalendarAdmin = Calendar.getInstance();
            fechaCalendarAdmin.setTime(new Date());
            fechaCalendarAdmin.add(Calendar.MINUTE, 
                                   (tiempoAdministracion * -1));
            bromageObject.setHaldfechaactiv(fechaCalendarAdmin.getTime());


        } else {
            bromageObject.setHaldfechaactiv(new Date());
        }


        try {
            this.serviceLocator.getCirugiaService().saveAldrete(bromageObject);
            calcularEscalaAldrete();
            nextAction = navegationRule;
            cargarHistorial();
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            e.printStackTrace();
        }


        return BeanNavegacion.RUTA_ACTUAL;


    }


    public String volver() {
        FacesUtils.resetManagedBean("consultarUsuariosIngresadosBean");
        FacesUtils.resetManagedBean("registrarEscalaAldreteBean");
        return BeanNavegacion.RUTA_IR_LISTA_NOTAS_ENFERMERIA;
    }


    /**
     * @param lstConsclin
     */
    public void setLstConsclin(List<Cnconsclin> lstConsclin) {
        this.lstConsclin = lstConsclin;
    }

    /**
     * @return
     */
    public List<Cnconsclin> getLstConsclin() {
        return lstConsclin;
    }

    /**
     * @param nextAction
     */
    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    /**
     * @return
     */
    public String getNextAction() {
        return nextAction;
    }

    /**
     * @param bromageObject
     */
    public void setBromageObject(Chaldrete bromageObject) {
        this.bromageObject = bromageObject;
    }

    /**
     * @return
     */
    public Chaldrete getBromageObject() {
        return bromageObject;
    }

    /**
     * @param lstActividad
     */
    public void setLstActividad(List lstActividad) {
        this.lstActividad = lstActividad;
    }

    /**
     * @return
     */
    public List getLstActividad() {
        if (lstActividad == null || lstActividad.isEmpty()) {
            lstActividad = new ArrayList();

            lstActividad.add(new SelectItem(2, 
                                            "Capaz de mover las cuatro extremidades "));
            lstActividad.add(new SelectItem(1, 
                                            "Capaz de mover dos extremidades  "));
            lstActividad.add(new SelectItem(0, "Incapaz de moverse "));
        }
        return lstActividad;
    }

    /**
     * @param lstRespiracion
     */
    public void setLstRespiracion(List lstRespiracion) {
        this.lstRespiracion = lstRespiracion;
    }

    /**
     * @return
     */
    public List getLstRespiracion() {
        if (lstRespiracion == null || lstRespiracion.isEmpty()) {
            lstRespiracion = new ArrayList();

            lstRespiracion.add(new SelectItem(2, 
                                              "Capaz de respirar y toser profundamente; sin dificultad respiratoria "));
            lstRespiracion.add(new SelectItem(1, 
                                              "Con dificultad respiratoria, respiraci�n superficial o disnea "));
            lstRespiracion.add(new SelectItem(0, 
                                              "Apnea o en ventilaci�n mec�nica "));
        }
        return lstRespiracion;
    }

    /**
     * @param lstCirculacion
     */
    public void setLstCirculacion(List lstCirculacion) {
        this.lstCirculacion = lstCirculacion;
    }

    /**
     * @return
     */
    public List getLstCirculacion() {
        if (lstCirculacion == null || lstCirculacion.isEmpty()) {
            lstCirculacion = new ArrayList();

            lstCirculacion.add(new SelectItem(2, 
                                              "Presi�n arterial < 15 mmHg del valor preoperatorio"));
            lstCirculacion.add(new SelectItem(1, 
                                              "Presi�n arterial > 20 y < 50 mmHg del valor preoperatorio"));
            lstCirculacion.add(new SelectItem(0, 
                                              "Presi�n arterial > 50 mmHg del valor preoperatorio"));
        }
        return lstCirculacion;
    }

    /**
     * @param lstEstadoConciencia
     */
    public void setLstEstadoConciencia(List lstEstadoConciencia) {
        this.lstEstadoConciencia = lstEstadoConciencia;
    }

    /**
     * @return
     */
    public List getLstEstadoConciencia() {
        if (lstEstadoConciencia == null || lstEstadoConciencia.isEmpty()) {
            lstEstadoConciencia = new ArrayList();

            lstEstadoConciencia.add(new SelectItem(2, 
                                                   "Completamente despierto "));
            lstEstadoConciencia.add(new SelectItem(1, 
                                                   "Despertable al llamado "));
            lstEstadoConciencia.add(new SelectItem(0, 
                                                   "No respuesta al llamado "));
        }
        return lstEstadoConciencia;
    }

    /**
     * @param lstSaturacion
     */
    public void setLstSaturacion(List lstSaturacion) {
        this.lstSaturacion = lstSaturacion;
    }

    /**
     * @return
     */
    public List getLstSaturacion() {
        if (lstSaturacion == null || lstSaturacion.isEmpty()) {
            lstSaturacion = new ArrayList();

            lstSaturacion.add(new SelectItem(2, 
                                             "Capaz de mantener SpO2 > 92 mmHg, sin oxigeno "));
            lstSaturacion.add(new SelectItem(1, 
                                             "Necesita oxigeno para mantener SpO2 > 90 mmHg "));
            lstSaturacion.add(new SelectItem(0, 
                                             "SpO2 < 90 mmHg, a�n con suplemento de ox�geno  "));
        }
        return lstSaturacion;
    }

    /**
     * @param lstAmbulacion
     */
    public void setLstAmbulacion(List lstAmbulacion) {
        this.lstAmbulacion = lstAmbulacion;
    }

    /**
     * @return
     */
    public List getLstAmbulacion() {
        if (lstAmbulacion == null || lstAmbulacion.isEmpty()) {
            lstAmbulacion = new ArrayList();
            lstAmbulacion.add(new SelectItem(2, 
                                             "Capaz de pararse y caminar "));
            lstAmbulacion.add(new SelectItem(1, "V�rtigo al pararse "));
            lstAmbulacion.add(new SelectItem(0, 
                                             "Mareo a�n en posici�n dec�bito supino "));
        }
        return lstAmbulacion;
    }


    public void setLstEscalaBromage(List lstEscalaBromage) {
        this.lstEscalaBromage = lstEscalaBromage;
    }

    public List getLstEscalaBromage() {
        if (lstEscalaBromage == null || lstEscalaBromage.isEmpty()) {
            lstEscalaBromage = new ArrayList();
            lstEscalaBromage.add(new SelectItem(0, "No par�lisis "));
            lstEscalaBromage.add(new SelectItem(1, 
                                                "Incapacidad para levantar los miembros superiores en extensi�n "));
            lstEscalaBromage.add(new SelectItem(2, 
                                                "Incapacidad para flejar la rodilla "));
            lstEscalaBromage.add(new SelectItem(3, 
                                                "Incapacidad para flejar el tobillo "));
        }
        return lstEscalaBromage;
    }

    /**
     * @param lstDolor
     */
    public void setLstDolor(List lstDolor) {
        this.lstDolor = lstDolor;
    }

    /**
     * @return
     */
    public List getLstDolor() {
        if (lstDolor == null || lstDolor.isEmpty()) {
            lstDolor = new ArrayList();

            lstDolor.add(new SelectItem(2, "No refiere dolor "));
            lstDolor.add(new SelectItem(1, 
                                        "Dolor leve, tolerable y maneja con medicaci�n oral "));
            lstDolor.add(new SelectItem(0, 
                                        "Dolor moderado a severo y manejado con medicaci�n parenteral "));
        }
        return lstDolor;
    }

    /**
     * @param renderAmbulatorio
     */
    public void setRenderAmbulatorio(boolean renderAmbulatorio) {
        this.renderAmbulatorio = renderAmbulatorio;
    }

    /**
     * @return
     */
    public boolean isRenderAmbulatorio() {
        return renderAmbulatorio;
    }

    /**
     * @param numeroEscala
     */
    public void setNumeroEscala(String numeroEscala) {
        this.numeroEscala = numeroEscala;
    }

    /**
     * @return
     */
    public String getNumeroEscala() {
        return numeroEscala;
    }

    /**
     * @param lstSangrado
     */
    public void setLstSangrado(List lstSangrado) {
        this.lstSangrado = lstSangrado;
    }

    /**
     * @return
     */
    public List getLstSangrado() {
        if (lstSangrado == null || lstSangrado.isEmpty()) {
            lstSangrado = new ArrayList();

            lstSangrado.add(new SelectItem(2, 
                                           "Herida seca y limpia; no hay necesidad de cambiar curaci�n  "));
            lstSangrado.add(new SelectItem(1, 
                                           "Herida h�meda pero sangrado controlado; necesidad de cambiar curaci�n "));
            lstSangrado.add(new SelectItem(0, 
                                           "Herida con sangrado no controlado y francamente anormal; causa alteraciones "));
        }
        return lstSangrado;
    }

    /**
     * @param lstTolerancia
     */
    public void setLstTolerancia(List lstTolerancia) {
        this.lstTolerancia = lstTolerancia;
    }

    /**
     * @return
     */
    public List getLstTolerancia() {
        if (lstTolerancia == null || lstTolerancia.isEmpty()) {
            lstTolerancia = new ArrayList();

            lstTolerancia.add(new SelectItem(2, 
                                             "Acepta e ingiere sin dificultad "));
            lstTolerancia.add(new SelectItem(1, 
                                             "Refiere n�useas y acepta poco v�a oral  "));
            lstTolerancia.add(new SelectItem(0, 
                                             "Presenta n�useas persistentes y v�mito "));
        }
        return lstTolerancia;
    }

    /**
     * @param lstEliminacion
     */
    public void setLstEliminacion(List lstEliminacion) {
        this.lstEliminacion = lstEliminacion;
    }

    /**
     * @return
     */
    public List getLstEliminacion() {
        if (lstEliminacion == null || lstEliminacion.isEmpty()) {
            lstEliminacion = new ArrayList();

            lstEliminacion.add(new SelectItem(2, 
                                              "Presenta eliminaci�n urinaria en forma espont�nea"));
            lstEliminacion.add(new SelectItem(1, 
                                              "Incapaz de eliminar pero no refiere incomodidad "));
            lstEliminacion.add(new SelectItem(0, 
                                              "Incapaz de eliminar e inc�modo "));
        }
        return lstEliminacion;
    }

    /**
     * @param aldreteObject
     */
    public void setAldreteObject(Chaldrete aldreteObject) {
        this.aldreteObject = aldreteObject;
    }

    /**
     * @return
     */
    public Chaldrete getAldreteObject() {
        return aldreteObject;
    }

    /**
     * @param lstHistorial
     */
    public void setLstHistorial(List<Chaldrete> lstHistorial) {
        this.lstHistorial = lstHistorial;
    }

    /**
     * @return
     */
    public List<Chaldrete> getLstHistorial() {
        return lstHistorial;
    }

    public void setHalcpacieambul(ValueChangeEvent valueChangeEvent) {
        aldreteObject.setHalcpacieambul((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void changeAmbulatorio() {
        renderAmbulatorio = false;
        if (aldreteObject != null && 
            aldreteObject.getHalcpacieambul() != null) {
            if (aldreteObject.getHalcpacieambul().equals("S")) {
                renderAmbulatorio = true;
            }
        }
    }


    public void calcularEscalaAldrete() {
        Integer calculoEscala = null;
        calculoEscala = 0;
        if (aldreteObject != null) {
            if (aldreteObject.getHalnactividad() != null) {
                calculoEscala = 
                        calculoEscala + aldreteObject.getHalnactividad();
                msgActividad = 
                        " Actividad Puntaje: " + aldreteObject.getHalnactividad() + 
                        "  ";
            }


            if (aldreteObject.getHalnrespiracio() != null) {
                calculoEscala = 
                        calculoEscala + aldreteObject.getHalnrespiracio();
                msgRespiracion = 
                        " Respiraci�n Puntaje: " + aldreteObject.getHalnrespiracio() + 
                        "  ";
            }

            if (aldreteObject.getHalncirculacio() != null) {
                calculoEscala = 
                        calculoEscala + aldreteObject.getHalncirculacio();
                msgCirculacion = 
                        "Circulaci�n Puntaje: " + aldreteObject.getHalncirculacio() + 
                        "  ";
            }

            if (aldreteObject.getHalnestadconci() != null) {
                calculoEscala = 
                        calculoEscala + aldreteObject.getHalnestadconci();
                msgEstado = 
                        "Estado de consciencia Puntaje: " + aldreteObject.getHalnestadconci() + 
                        "  ";
            }

            if (aldreteObject.getHalnsaturoxige() != null) {
                calculoEscala = 
                        calculoEscala + aldreteObject.getHalnsaturoxige();
                msgSaturacion = 
                        "Saturacion de oxigeno Puntaje: " + aldreteObject.getHalnsaturoxige() + 
                        "  ";
            }

            if (aldreteObject.getHalnambulacion() != null) {
                calculoEscala = 
                        calculoEscala + aldreteObject.getHalnambulacion();
                msgAmbulacion = 
                        "Ambulacion Puntaje: " + aldreteObject.getHalnambulacion() + 
                        "  ";
            }

            if (aldreteObject.getHalndolor() != null) {
                calculoEscala = calculoEscala + aldreteObject.getHalndolor();
                msgDolor = 
                        "Dolor Puntaje: " + aldreteObject.getHalndolor() + "  ";
            }

            if (aldreteObject.getHalnsangrposqu() != null) {
                calculoEscala = 
                        calculoEscala + aldreteObject.getHalnsangrposqu();
                msgSangrado = 
                        "Sangrado postquirurgico Puntaje: " + aldreteObject.getHalnsangrposqu() + 
                        "  ";
            }

            if (aldreteObject.getHalntolerliqui() != null) {
                calculoEscala = 
                        calculoEscala + aldreteObject.getHalntolerliqui();
                msgTolerancia = 
                        "Tolerancia a los l�quidos por v�a oral Puntaje: " + 
                        aldreteObject.getHalntolerliqui() + "  ";
            }

            if (aldreteObject.getHalnelimiurina() != null) {
                calculoEscala = 
                        calculoEscala + aldreteObject.getHalnelimiurina();
                msgEliminacion = 
                        "Eliminaci�n urinaria Puntaje: " + aldreteObject.getHalnelimiurina() + 
                        "  ";
            }

            numeroEscala = "Escala Aldrete (Puntaje): " + calculoEscala;
        }

    }


    /**
     * @param msgActividad
     */
    public void setMsgActividad(String msgActividad) {
        this.msgActividad = msgActividad;
    }

    /**
     * @return
     */
    public String getMsgActividad() {
        return msgActividad;
    }

    /**
     * @param msgRespiracion
     */
    public void setMsgRespiracion(String msgRespiracion) {
        this.msgRespiracion = msgRespiracion;
    }

    /**
     * @return
     */
    public String getMsgRespiracion() {
        return msgRespiracion;
    }

    /**
     * @param msgCirculacion
     */
    public void setMsgCirculacion(String msgCirculacion) {
        this.msgCirculacion = msgCirculacion;
    }

    /**
     * @return
     */
    public String getMsgCirculacion() {
        return msgCirculacion;
    }

    /**
     * @param msgEstado
     */
    public void setMsgEstado(String msgEstado) {
        this.msgEstado = msgEstado;
    }

    /**
     * @return
     */
    public String getMsgEstado() {
        return msgEstado;
    }

    /**
     * @param msgSaturacion
     */
    public void setMsgSaturacion(String msgSaturacion) {
        this.msgSaturacion = msgSaturacion;
    }

    /**
     * @return
     */
    public String getMsgSaturacion() {
        return msgSaturacion;
    }

    /**
     * @param msgAmbulacion
     */
    public void setMsgAmbulacion(String msgAmbulacion) {
        this.msgAmbulacion = msgAmbulacion;
    }

    /**
     * @return
     */
    public String getMsgAmbulacion() {
        return msgAmbulacion;
    }

    /**
     * @param msgDolor
     */
    public void setMsgDolor(String msgDolor) {
        this.msgDolor = msgDolor;
    }

    /**
     * @return
     */
    public String getMsgDolor() {
        return msgDolor;
    }

    /**
     * @param msgSangrado
     */
    public void setMsgSangrado(String msgSangrado) {
        this.msgSangrado = msgSangrado;
    }

    /**
     * @return
     */
    public String getMsgSangrado() {
        return msgSangrado;
    }

    /**
     * @param msgTolerancia
     */
    public void setMsgTolerancia(String msgTolerancia) {
        this.msgTolerancia = msgTolerancia;
    }

    /**
     * @return
     */
    public String getMsgTolerancia() {
        return msgTolerancia;
    }

    /**
     * @param msgEliminacion
     */
    public void setMsgEliminacion(String msgEliminacion) {
        this.msgEliminacion = msgEliminacion;
    }

    /**
     * @return
     */
    public String getMsgEliminacion() {
        return msgEliminacion;
    }


  
}
