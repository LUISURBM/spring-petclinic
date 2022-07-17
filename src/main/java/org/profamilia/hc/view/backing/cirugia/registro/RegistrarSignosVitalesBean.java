package org.profamilia.hc.view.backing.cirugia.registro;

import java.io.File;

import java.math.BigDecimal;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chnotaenferm;
import org.profamilia.hc.model.dto.Chsignovital;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.resumen.GenerarFoliosCirugiaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


public class RegistrarSignosVitalesBean extends BaseBean {

    private Chsignovital signo;

    private boolean esFebril;

    private List lstTemperatura;

    private Chcirugprogr cirugia;

    private boolean esIngreso;

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

    private List<Chsignovital> lstHistorialSignosVitalesTomados;

    private boolean generoReporte;

    private String msgPresion;

    private String msgPresion2;

    private String msgFrecuenciaCardiaca;

    private String msgFrecuenciaRespiratoria;

    private String msgTemperatura;

    private String msgSaturacion;
    
    private Cpservicio servicio;
    
    private Chdetacirpro detalleCirugia;
    
    private String tipoServicio;
    
    private String legendServicio;
    
    private boolean notaEnfeProce;
    
    private String legendTablaServicio;


    public RegistrarSignosVitalesBean() {
    }

    public void init() {
    
        lstTemperatura = new ArrayList();
        lstCirugias = new ArrayList();
        dtCirugias = new HtmlDataTable();
        lstHistorialSignosVitalesTomados = new ArrayList<Chsignovital>();
        setGeneroReporte(false);
        
        legendServicio="Cirugia(s) Programada(s)";
        legendTablaServicio= "Intervenci�n(es)";
            
        if (cirugia != null) {
            if(notaEnfeProce){
                legendServicio="Procedimiento(s)";
                legendTablaServicio ="Procedimiento(s)";
                try {
                    lstConsclin = 
                            this.serviceLocator.getClinicoService().getConsultaClinica(cirugia.getHcplnumero().longValue());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                // Cargamos los procedimientos
                if (lstConsclin != null && !lstConsclin.isEmpty()) {
                    Iterator it = lstConsclin.iterator();
                    Cnconsclin conclin;

                    while (it.hasNext()) {
                        conclin = (Cnconsclin)it.next();
                        lstCirugias.add(conclin.getCcocservic());
                    }
                }
            }
            
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

            if (esIngreso && cirugia != null) {
                try {
                    if (cirugia != null && cirugia.getHcplnumero() != null) {
                        signo = 
                                this.getServiceLocator().getCirugiaService().getSignosVitales(cirugia.getHcplnumero());
                    }
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }

            if (signo == null) {
                signo = new Chsignovital();
                signo.setHsvetipotemper("A");
                esHoraActual = "S";
            } else {
                if (signo.getHsvetipotemper() != null && 
                    signo.getHsvetipotemper().equals("F")) {
                    esFebril = true;
                } else {
                    esFebril = false;
                }
            }

            if (cirugia != null) {
                try {
                    lstHistorialSignosVitalesTomados = 
                            this.serviceLocator.getCirugiaService().getSignosVitalesTomados(cirugia.getHcplnumero());


                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }

            if (cirugia.getChdetacirpros() != null && !cirugia.getChdetacirpros().isEmpty()) {
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
        }
    }

    /**
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        Chsignovital signoAux = null;

        try {
            if (cirugia != null && cirugia.getHcplnumero() != null) {
                signoAux = 
                        this.getServiceLocator().getCirugiaService().getSignosVitales(cirugia.getHcplnumero());
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (signoAux != null) {
            esValido = true;
        }

        return esValido;
    }

    /**
     * @param valueChangeEvent
     */
    public void setTipoTempSelect(ValueChangeEvent valueChangeEvent) {
        signo.setHsvetipotemper((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHsvatemperatu(ValueChangeEvent valueChangeEvent) {
        signo.setHsvatemperatu((BigDecimal)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHsvnsatuoxihe(ValueChangeEvent valueChangeEvent) {
        signo.setHsvnsatuoxihe((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHsvnfreccard(ValueChangeEvent valueChangeEvent) {
        signo.setHsvnfreccard((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setHsvnfrecresp(ValueChangeEvent valueChangeEvent) {
        signo.setHsvnfrecresp((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
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
    public void setHsvnpresart1(ValueChangeEvent valueChangeEvent) {
        signo.setHsvnpresart1((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHsvnpresart2(ValueChangeEvent valueChangeEvent) {
        signo.setHsvnpresart2((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param signo
     */
    public void setSigno(Chsignovital signo) {
        this.signo = signo;
    }

    /**
     * @return
     */
    public Chsignovital getSigno() {
        return signo;
    }

    /**
     * @param esFebril
     */
    public void setEsFebril(boolean esFebril) {
        this.esFebril = esFebril;
    }

    /**
     * @return
     */
    public boolean isEsFebril() {
        return esFebril;
    }

    /**
     * @param lstTemperatura
     */
    public void setLstTemperatura(List lstTemperatura) {
        this.lstTemperatura = lstTemperatura;
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
     * @param esIngreso
     */
    public void setEsIngreso(boolean esIngreso) {
        this.esIngreso = esIngreso;
    }

    /**
     * @return
     */
    public boolean isEsIngreso() {
        return esIngreso;
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

    /**
     * @return
     */
    public List getLstTemperatura() {
        if (lstTemperatura.size() == 0) {
            lstTemperatura.add(new SelectItem("", "Seleccione una opcion"));
            lstTemperatura.add(new SelectItem("A", "Afebril"));
            lstTemperatura.add(new SelectItem("F", "Febril"));
        }
        return lstTemperatura;
    }

    public void changeTemperatura() {
        if (signo != null && signo.getHsvetipotemper() != null && 
            signo.getHsvetipotemper().equals("F")) {
            esFebril = true;
        } 
         else {
            esFebril = false;
        }
    }

    public void ChangeMensajePresion1() {
        msgPresion = "";
        msgPresion2 = "";
        //validamos el campo de los signos vitales
        if (cirugia.getHcplusuario().getEdad() > IConstantes.rango_edad && signo.getHsvnpresart1() != null ) {
            if (signo.getHsvnpresart1() < IConstantes.presion_mmmin || 
                signo.getHsvnpresart1() > IConstantes.presion_mmmax) {
                msgPresion = IMsg.MSG_PRESION_ARTERIAL_SISTOLICA;

            }
        }
    }

    public void ChangeMensajePresion2() {

        msgPresion2 = "";
        //validamos el campo de los signos vitales
        if (cirugia.getHcplusuario().getEdad() > IConstantes.rango_edad && signo.getHsvnpresart2() != null) {
            if (signo.getHsvnpresart2() < IConstantes.presion_Hgmin || 
                signo.getHsvnpresart2() > IConstantes.presion_Hgmax) {

                msgPresion2 = IMsg.MSG_PRESION_ARTERIAL_DIASTOLICA;

            }
        }
    }


    public void ChangeMensajeFrecCardiaca() {

        msgFrecuenciaCardiaca = "";
        //validamos el campo de los signos vitales
        // validacion de la frecuencia cardiaca
         if (cirugia.getHcplusuario().getEdad() > IConstantes.rango_edad && signo.getHsvnfreccard() != null) {
            if (signo.getHsvnfreccard() < IConstantes.frec_cardmin || 
                signo.getHsvnfreccard() > IConstantes.frec_cardmax) {
                msgFrecuenciaCardiaca = IMsg.MSG_FRECUENCIA_CARDIACA;

            }
        }
    }

    public void ChangeMensajeFrecRespiratoria() {

        msgFrecuenciaRespiratoria = "";
        //validamos el campo de los signos vitales
        // validacion de la frecuencia cardiaca
        if ((cirugia.getHcplusuario().getEdad() > IConstantes.rango_edad) && signo.getHsvnfrecresp()!= null ) {
            if (signo.getHsvnfrecresp() < IConstantes.frec_respmin || 
                signo.getHsvnfrecresp() > IConstantes.frec_respmax) {
                msgFrecuenciaRespiratoria = MSG_FRECUENCIA_RESPIRATORIA;

            }
        }
    }

    public void ChangeMensajeTemperatura() {

        msgTemperatura = "";
        //validamos el campo de los signos vitales
        // validacion de la frecuencia cardiaca
        if (signo.getHsvatemperatu() != null && signo.getHsvatemperatu().intValue() > 0) {
            Integer febril;
            //compara la temperatura con la constante
            febril = signo.getHsvatemperatu().compareTo(IConstantes.febril_cent);

            Integer febril1;
            febril1 = signo.getHsvatemperatu().compareTo(IConstantes.febril_min);

            if ((febril == 1) || (febril1 == -1)) {
                if (febril1 == -1) {
                    msgTemperatura = IMsg.MSG_TEMPERATURA_BAJA;
                }
                if (febril == 1) {
                    msgTemperatura = IMsg.MSG_TEMPERATURA_ALTA;
                }
            }
        }
    }

    public void ChangeMensajeSaturacion() {

        msgSaturacion = "";
        //validamos el campo de los signos vitales
        // validacion de la frecuencia cardiaca
        if (signo != null && signo.getHsvnsatuoxihe() != null && (signo.getHsvnsatuoxihe() < IConstantes.saturacion || 
            signo.getHsvnsatuoxihe() > IConstantes.saturacion_maxima)) {
            msgSaturacion = 
                    ("La Saturaci�n esta fuera de Rango: " + IConstantes.saturacion + 
                     "-" + IConstantes.saturacion_maxima);
        }
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
        boolean wexito = true;
        nextAction = "";
        signo.setHsvnclinica(this.getClinica().getCclncodigo());
        signo.setHsvcestado(ESTADO_VIGENTE);
        signo.setHsvdfecregistr(new Date());
        signo.setHsvcoperador(userName());
        signo.setHsvctipoproced(TIPO_PROCEDIMIENTO_ENFERMERIA);
        if (cirugia != null) {
            signo.setHsvlusuario(cirugia.getHcplusuario().getHuslnumero());
            signo.getId().setHsvlconsulta(cirugia.getHcplnumero());
        }

        if (esHoraActual != null && esHoraActual.equals("N") && 
            tiempoAdministracion != null) {

            Calendar fechaCalendarAdmin;
            fechaCalendarAdmin = Calendar.getInstance();
            fechaCalendarAdmin.setTime(new Date());
            fechaCalendarAdmin.add(Calendar.MINUTE, (tiempoAdministracion * -1));
            signo.setHsvdfechaactiv(fechaCalendarAdmin.getTime());
        } else {
            signo.setHsvdfechaactiv(new Date());
        }
        wexito = true;
        //validamos el campo de los signos vitales
        if (cirugia.getHcplusuario().getEdad() > IConstantes.rango_edad) {
            if (signo.getHsvnpresart1() < IConstantes.presion_mmmin || 
                signo.getHsvnpresart1() > IConstantes.presion_mmmax) {
                FacesUtils.addInfoMessage(IMsg.MSG_PRESION_ARTERIAL_SISTOLICA + 
                                          signo.getHsvnpresart1() + "mm");
            }
        }

        if (cirugia.getHcplusuario().getEdad() > IConstantes.rango_edad) {
            if (signo.getHsvnpresart2() < IConstantes.presion_Hgmin || 
                signo.getHsvnpresart2() > IConstantes.presion_Hgmax) {
                FacesUtils.addInfoMessage(IMsg.MSG_PRESION_ARTERIAL_DIASTOLICA + 
                                          signo.getHsvnpresart2() + "Hg");
            }
        }

        // validacion de la frecuencia cardiaca
        if (cirugia.getHcplusuario().getEdad() > IConstantes.rango_edad) {
            if (signo.getHsvnfreccard() < IConstantes.frec_cardmin || 
                signo.getHsvnfreccard() > IConstantes.frec_cardmax) {
                FacesUtils.addInfoMessage(IMsg.MSG_FRECUENCIA_CARDIACA + 
                                          signo.getHsvnfreccard() + " " + 
                                          "l.p.m");
            }
        }

        if (cirugia.getHcplusuario().getEdad() > IConstantes.rango_edad) {
 /*           if (signo.getHsvnfrecresp() < IConstantes.frec_respmin || 
                signo.getHsvnfrecresp() > IConstantes.frec_respmax) {
                FacesUtils.addInfoMessage(IMsg.MSG_FRECUENCIA_RESPIRATORIA + 
                                          signo.getHsvnfrecresp() + " " + 
                                          "r.p.m");

            } 
*/       
        }

        if ("F".equals(signo.getHsvetipotemper())) {
            Integer febril;
            //compara la temperatura con la constante
            febril = 
                    signo.getHsvatemperatu().compareTo(IConstantes.febril_cent);
            if (febril == 1 || febril == 0) {
                FacesUtils.addInfoMessage(IMsg.MSG_TEMPERATURA_ALTA + 
                                          signo.getHsvatemperatu() + "�C");
            }
            Integer febril1;
            febril1 = 
                    signo.getHsvatemperatu().compareTo(IConstantes.febril_min);
            if (febril == 0 || febril == -1) {
                FacesUtils.addInfoMessage(IMsg.MSG_TEMPERATURA_BAJA + 
                                          signo.getHsvatemperatu() + "�C");
            }

            if (signo.getHsvnsatuoxihe() <= IConstantes.saturacion || 
                signo.getHsvnsatuoxihe() >= IConstantes.saturacion_maxima) {
                FacesUtils.addInfoMessage("La Saturaci�n esta fuera de Rango: " + 
                                          IConstantes.saturacion + "-" + 
                                          IConstantes.saturacion_maxima + 
                                          ": " + signo.getHsvnsatuoxihe() + 
                                          " " + "%");
            }
        }

        if (wexito) {
            try {
                if(tipoServicio != null ){
                    signo.setHsvctiposervi(tipoServicio);
                }
                this.serviceLocator.getCirugiaService().saveSignosVitales(signo);
                nextAction = navegationRule;
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                e.printStackTrace();
            }

            if (esIngreso) {
                FacesUtils.resetManagedBean(menuBean);
                return nextAction;
            } else {
                return BeanNavegacion.RUTA_ACTUAL;
            }
        } else {
            return nextAction = "";
        }

    }

    public String volver() {
        return "irListaNotasEnfermeria";
    }


    public void setLstHistorialSignosVitalesTomados(List<Chsignovital> lstHistorialSignosVitalesTomados) {
        this.lstHistorialSignosVitalesTomados = 
                lstHistorialSignosVitalesTomados;
    }

    public List<Chsignovital> getLstHistorialSignosVitalesTomados() {
        return lstHistorialSignosVitalesTomados;
    }


    public void generarReporte() {
        Chusuario usuario = null;
        Chcirugprogr cirugiaAux = null;
        GenerarFoliosCirugiaBean bean = (GenerarFoliosCirugiaBean)FacesUtils.getManagedBean("generarFoliosCirugiaBean");
        byte[] result = null;
        
        try {
        if(tipoServicio == null){
            cirugiaAux = this.serviceLocator.getCirugiaService().getFolioCirugiaCompleto(cirugia.getHcplnumero());
        }else{
            cirugiaAux = cirugia;
            lstConsclin = 
                    this.serviceLocator.getClinicoService().getConsultaClinica(cirugia.getHcplnumero().longValue());
        }
            usuario = this.serviceLocator.getClinicoService().getUsuario(cirugia.getHcplusuario().getHuslnumero());
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (bean != null && cirugiaAux != null && usuario != null) {
            if (lstConsclin!=null && !lstConsclin.isEmpty()) {
                result = bean.generarSignosVitales(usuario, cirugiaAux, -1, lstConsclin.get(0));
            }else{
                result = bean.generarSignosVitales(usuario, cirugiaAux, -1,null);
            }
        }
        if (result != null) {
            PdfServletUtils.showPdfDocument(result,"SignosVitales.pdf", false);
            setGeneroReporte(true);
        } else {
            FacesUtils.addErrorMessage("No pudo generar Reporte Signos Vitales. ");
            setGeneroReporte(false);
        }
    }
    
    public void resetDatos(){
        signo = new Chsignovital();
        init();
    }

    /**
     * @param generoReporte
     */
    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    /**
     * @return
     */
    public boolean isGeneroReporte() {
        return generoReporte;
    }

    /**
     * @param msgPresion
     */
    public void setMsgPresion(String msgPresion) {
        this.msgPresion = msgPresion;
    }

    /**
     * @return
     */
    public String getMsgPresion() {
        return msgPresion;
    }

    /**
     * @param msgPresion2
     */
    public void setMsgPresion2(String msgPresion2) {
        this.msgPresion2 = msgPresion2;
    }

    /**
     * @return
     */
    public String getMsgPresion2() {
        return msgPresion2;
    }

    /**
     * @param msgFrecuenciaCardiaca
     */
    public void setMsgFrecuenciaCardiaca(String msgFrecuenciaCardiaca) {
        this.msgFrecuenciaCardiaca = msgFrecuenciaCardiaca;
    }

    /**
     * @return
     */
    public String getMsgFrecuenciaCardiaca() {
        return msgFrecuenciaCardiaca;
    }

    /**
     * @param msgFrecuenciaRespiratoria
     */
    public void setMsgFrecuenciaRespiratoria(String msgFrecuenciaRespiratoria) {
        this.msgFrecuenciaRespiratoria = msgFrecuenciaRespiratoria;
    }

    /**
     * @return
     */
    public String getMsgFrecuenciaRespiratoria() {
        return msgFrecuenciaRespiratoria;
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

    public void setMsgTemperatura(String msgTemperatura) {
        this.msgTemperatura = msgTemperatura;
    }

    public String getMsgTemperatura() {
        return msgTemperatura;
    }

    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }

    public void setDetalleCirugia(Chdetacirpro detalleCirugia) {
        this.detalleCirugia = detalleCirugia;
    }

    public Chdetacirpro getDetalleCirugia() {
        return detalleCirugia;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setLstConsclin(List<Cnconsclin> lstConsclin) {
        this.lstConsclin = lstConsclin;
    }

    public List<Cnconsclin> getLstConsclin() {
        return lstConsclin;
    }

    public void setLegendServicio(String legendServicio) {
        this.legendServicio = legendServicio;
    }

    public String getLegendServicio() {
        return legendServicio;
    }

    public void setNotaEnfeProce(Boolean notaEnfeProce) {
        this.notaEnfeProce = notaEnfeProce;
    }

    public Boolean getNotaEnfeProce() {
        return notaEnfeProce;
    }

    public void setLegendTablaServicio(String legendTablaServicio) {
        this.legendTablaServicio = legendTablaServicio;
    }

    public String getLegendTablaServicio() {
        return legendTablaServicio;
    }
}
