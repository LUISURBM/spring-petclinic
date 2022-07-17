package org.profamilia.hc.view.backing.cirugia.registro;


import java.math.BigDecimal;

import java.net.URL;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.myfaces.component.html.ext.HtmlDataTable;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chsegutelefo;
import org.profamilia.hc.model.dto.ChsegutelefoPK;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.PruebasRapidasDTO;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


public class RegistrarSeguimientoTelefonicoBean extends BaseBean implements JRDataSource {

    /** Almacena la descripcion del Seguimiento Telefonico*/
    private String seguimientoTelefonico;

    /** Almacena la cirugia a la cual se le esta haciendo el seguimiento telefonico */
    private Chcirugprogr cirugia;

    /** Almacena el seguimiento telefonico a persistir*/
    private Chsegutelefo segTelefono;
    
    /** Almacena el bean de navegacion*/
    private String nextAction; 

    private String esHoraActual;
    
    private String contesta;
    
    private String observacionAdicional;
    
    private String cualMolestia;
    
    private String cualMolestiaFlebitis;
    
    private String cualMedicamento;
    
    private String recomendacionSelect;
    
    private String recomendaciones;
    
    private String corolaSelect;
    
    private String dolorSelect;
    
    private String calorSelect;
    
    private String enrojecimientoSelect;
    
    private String sangreSelect;
    
    private String pusSelect;
    
    private String liquidoSelect;
    
    private String olorSelect;
    
    private String canalizacionSelect;
    
    private String dolorCanaliSelect;
    
    private String recuperacionSelect;
    
    private String pusVenaSelect;
    
    private String posoperatorioSelect;
    
    private String posoperatorioPorqueno;
    
    private String signosSelect;
    
    private String antibioticoSelect;
    
    private String medicamentoSelect;
    
    private String hospitalSelect;
    
    private String cualHospital;
    
    private String algunMedicamentoTextSelect;
    
    private String cualAlgunMedicamento;
    
    private String tratamientoSelect;
    
    private String cual;
    
    private String observacion;

    private boolean mostrarHoraActual;
    
    private boolean mostrarAdicional;
    
    private boolean mostrarAdicionalFlebitis;
    
    private boolean mostrarItem;
    
    private boolean mostrarCualMolestia;
    
    private boolean mostrarCualMolestiaFlebitis;
    
    private boolean mostrarCualMedicamento;
    
    private boolean mostrarRecomendaciones;
    
    private boolean mostrarContesta;
    
    private boolean mostrarSelectCorola;
    
    private boolean mostrarposoperatorioSelect;
    
    private boolean mostrarAntibioticoSelect;
    
    private boolean mostrarHospitalSelect;
    
    private boolean mostrarAlgunMedicamentoTextSelect;
    
    private Integer tiempoAdministracion;

    private List lstOpciones;
    
    private List lstOpcionesComprobacion;
    
    private List lstTratamiento;
    
    private List<Chsegutelefo> lstSeguimientoTelefonico;
    
    private HtmlDataTable dtSeguimiento;

    private String molestiaFlebitis;
    
    private String observacionAdicionalFlebitis;
    
    private String observacionFlebitis;
    
    private String cualAntibioticoSelect;
    
    private boolean renderColoracion;
    private boolean renderDolor;
    private boolean renderCalor;
    private boolean renderEnrojecimiento;
    private boolean renderSangre;
    private boolean renderPus;
    private boolean renderLiquido;
    private boolean renderOlor;
    private boolean renderMolestia;
    private boolean renderObservacionesAdicionales;
    private boolean renderCanalizacion;
    private boolean renderDolorCanali;
    private boolean renderRecuperacion;
    private boolean renderPusVena;
    private boolean renderMolestiaFlebitis;
    private boolean renderObservacioAdicionalesFlebitis;
    private boolean renderPosoperatorio;
    private boolean renderSignos;
    private boolean renderAntibiotico;
    private boolean renderMedicamento;
    private boolean renderHospital;
    private boolean renderAlgunMedicamento;
    private boolean renderTratamiento;
    private boolean renderlRecomendaciones;
    private boolean botonImprimir;
    private int index = -1;
    private boolean generoReporte;
    private List<Object[]> lstViniso;
    private String nombreProfesional;
    private String cargoProfesional;
    private String codigoProfesional;
    private String regProfesional;
    private Date fechaViniso;

    


    public RegistrarSeguimientoTelefonicoBean() {
    }


    public void init() {
        mostrarAdicional = false;
        mostrarCualMolestia = false;
        mostrarCualMedicamento = false;
        mostrarRecomendaciones = false;
        mostrarContesta = false;
        mostrarSelectCorola = false;
        mostrarAntibioticoSelect = false;
        mostrarHospitalSelect = false;
        mostrarAlgunMedicamentoTextSelect = false;
        segTelefono = new Chsegutelefo();
        dtSeguimiento = new HtmlDataTable();
        cargarDatos();
        renderColoracion=false;
        renderDolor=false;
        renderCalor=false;
        renderEnrojecimiento=false;
        renderSangre=false;
        renderPus=false;
        renderLiquido=false;
        renderOlor=false;
        renderMolestia=false;
        renderObservacionesAdicionales=false;
        renderCanalizacion=false;
        renderDolorCanali=false;
        renderRecuperacion=false;
        renderPusVena=false;
        renderMolestiaFlebitis=false;
        renderObservacioAdicionalesFlebitis=false;
        renderPosoperatorio=false;
        renderSignos=false;
        renderAntibiotico=false;
        renderMedicamento=false;
        renderHospital=false;
        renderAlgunMedicamento=false;
        renderTratamiento=false;
        renderlRecomendaciones=false;
        botonImprimir = false;

        
        
    }

    public void cargarDatos() {
        if (cirugia != null) {
            try {
             lstSeguimientoTelefonico= 
                     this.serviceLocator.getCirugiaService().getSeguimientoTelefonico(cirugia.getHcplnumero());
         } catch (ModelException e) {
             e.printStackTrace();
          }

         if (lstSeguimientoTelefonico == null || lstSeguimientoTelefonico.isEmpty()) {
             lstSeguimientoTelefonico = new ArrayList<Chsegutelefo>();
         }
        }
    }



    /**
     * @param seguimientoTelefonico
     */
    public void setSeguimientoTelefonico(String seguimientoTelefonico) {
        this.seguimientoTelefonico = seguimientoTelefonico;
    }

    /**
     * @return
     */
    public String getSeguimientoTelefonico() {
        return seguimientoTelefonico;
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
     * @return
     */
    public String aceptar() {
        botonImprimir = false;
        ChsegutelefoPK idsegTelefono = new ChsegutelefoPK();
        idsegTelefono.setHstlnumero(cirugia.getHcplnumero());
        idsegTelefono.setHstctiposervi(TIPO_HOSPITALIZACION);
        nextAction = ""; 
        segTelefono.setHstcsegtelefo(seguimientoTelefonico);
        segTelefono.setHstcoperador(userName());
        segTelefono.setHstdfecregistr(new Date());
        segTelefono.setHstlusuario(cirugia.getHcplusuario().getHuslnumero());
        segTelefono.setHstnclinica(cirugia.getHcpnclinica());
        segTelefono.setHstcestado(ETAPA_VIGENTE);
        segTelefono.setHstcreccoloro(corolaSelect);
        segTelefono.setHstcdolormedi(dolorSelect);
        segTelefono.setHstccalorheri(calorSelect);
        segTelefono.setHstcenroherid(enrojecimientoSelect);
        segTelefono.setHstcsalisanher(sangreSelect);
        segTelefono.setHstcsalipusher(pusSelect);
        segTelefono.setHstcsaliliqher(liquidoSelect);
        segTelefono.setHstcmalolorhe(olorSelect);
        segTelefono.setHstcpremolest(cualMolestia);
        if(cualMolestia != null && cualMolestia.equals("S")){
            segTelefono.setHstccualmoles(cual);
        }
        segTelefono.setHstcobseradic(observacionAdicional);
        if(observacionAdicional != null && observacionAdicional.equals("S")){
            segTelefono.setHstcobservaci(observacion);
        }
        segTelefono.setHstcenrositio(canalizacionSelect);
        segTelefono.setHstcpresedolo(dolorCanaliSelect);
        segTelefono.setHstcrecucanal(recuperacionSelect);
        segTelefono.setHstcpussavena(pusVenaSelect);
        segTelefono.setHstcpresmoles(molestiaFlebitis);
        if(molestiaFlebitis != null && molestiaFlebitis.equals("S")){
            segTelefono.setHstcmolescual(cualMolestiaFlebitis);
        }
        segTelefono.setHstcobservadi(observacionAdicionalFlebitis);
        if(observacionAdicionalFlebitis != null && observacionAdicionalFlebitis.equals("S")){
            segTelefono.setHstcobseracio(observacionFlebitis);
        }

        segTelefono.setHstccasiconpos(posoperatorioSelect);

        if (posoperatorioSelect != null && posoperatorioSelect.equals("N")) {
            segTelefono.setHstcnoasiconpos(posoperatorioPorqueno);
        }   
        segTelefono.setHstcsigantcon(signosSelect);
        segTelefono.setHstcordeantiv(antibioticoSelect);
        if(antibioticoSelect != null && antibioticoSelect.equals("S")){
          segTelefono.setHstccualantiv(cualAntibioticoSelect);
        }

        
        segTelefono.setHstcmedimedic(medicamentoSelect);
        segTelefono.setHstcmedpospr(hospitalSelect);
        if(hospitalSelect != null && hospitalSelect.equals("S")){
            segTelefono.setHstccualhosp(cualHospital);
        }
        segTelefono.setHstcdiermedic(algunMedicamentoTextSelect);
        if(algunMedicamentoTextSelect != null && algunMedicamentoTextSelect.equals("S")){
            segTelefono.setHstccualmedic(cualAlgunMedicamento);
        }
        
        segTelefono.setHstcdeputrata(tratamientoSelect);
        
        segTelefono.setHstcrecoemiti(recomendacionSelect);

        if (recomendacionSelect != null && recomendacionSelect.equals("S")) {
            segTelefono.setHstcrecomend(recomendaciones);
        }
        
        segTelefono.setId(idsegTelefono);

        if (esHoraActual != null && esHoraActual.equals("N") && tiempoAdministracion != null) {
             Calendar fechaCalendarAdmin;
             fechaCalendarAdmin = Calendar.getInstance();
             fechaCalendarAdmin.setTime(new Date());
             fechaCalendarAdmin.add(Calendar.MINUTE, (tiempoAdministracion * -1));
             segTelefono.setHstdfechaseg(fechaCalendarAdmin.getTime());
        } else {
            segTelefono.setHstdfechaseg(new Date());
        }

        try {
           segTelefono= this.serviceLocator.getCirugiaService().saveSeguimientoTelefonico(segTelefono);
           botonImprimir = true;
            nextAction = BeanNavegacion.RUTA_IR_INICIO; 
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ADICION);
            nextAction = BeanNavegacion.RUTA_ACTUAL; 
            e.printStackTrace();
        }




        return null;
    }
    public String cerrarSeguimiento(){
        FacesUtils.resetManagedBean("registrarSeguimientoTelefonicoBean");
        FacesUtils.resetManagedBean("consultarFoliosSeguimientoTelefonicoBean");
        FacesUtils.resetManagedBean("consultarUsuarioSeguimientoTelefonicoBean");
        return nextAction;
    }
    
    public void generarArchivoPdf() {
        index = -1;
        generoReporte = false;
        try {
            lstViniso = serviceLocator.getCirugiaService().getRegistroSegTelefonico(segTelefono.getId().getHstlnumero(),segTelefono.getId().getHstlconsecutiv());
            fechaViniso = segTelefono.getHstdfecregistr();
        } catch (ModelException e) {
            // TODO
        }
        if (lstViniso == null || lstViniso.isEmpty()) {
            FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
        } else {
            try {
                try {
                
                   Cpprofesio profesionalAct = 
                            serviceLocator.getClinicoService().getProfesionalPorUsuario(segTelefono.getHstcoperador(),
                                                                                    this.getClinica().getCclncodigo());
                    if(profesionalAct!=null){
                    nombreProfesional = profesionalAct.getCpfcnombre();
                    codigoProfesional = ""+profesionalAct.getCpfncodigo();
                    regProfesional = profesionalAct.getCpfcregmedic();
                     cargoProfesional = 
                            serviceLocator.getClinicoService().getDescripcionTipoEspecialidad(profesionalAct.getCpfntipoespe());
                    }
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                String nombreArchivo = "Impresion_Viniso";
                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/FO-GS-VE-004.jasper");
                URL url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);

                if (url != null) {
                    Map parameters = new HashMap();
                    parameters.put("IMAGEN",url_profamilia);

                    byte[] bytes;

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);
                    bytes = 
                            JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                    PdfServletUtils.showPdfDocument(bytes, 
                    nombreArchivo + 
                    Calendar.getInstance().getTimeInMillis() + ".pdf", 
                                                    false);
                    generoReporte = true;


                   

                }
            } catch (Exception e) {
                //generoReporte = false;
                e.printStackTrace();
                FacesUtils.addErrorMessage("No se genero el archivo " + 
                                           e.getMessage());
            }
        }
    }
    
    /**
     * @return
     */
    public boolean next() {
        index++;
        return (index < 1);
    }

    
    
    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();
        Object[] b = new Object[lstViniso.size()];
        b = lstViniso.get(index);
        if (fieldName.equals("CLINICA")) {        
          value = (String)b[0];
            return value;
        }
      
        else  if (fieldName.equals("NOMBRES")) {        
                if(b[2]!=null){
                    value = (String)b[1]+" "+(String)b[2];
                }
                else{
                    value = (String)b[1];
                }
                return value;
          }
        else if (fieldName.equals("NO_HISTORIA")) {        
          value =(String)b[50]+" "+ ((BigDecimal)b[51]).toString();
            return value;
        }
        else if (fieldName.equals("FECHA")) {        
          value = fechaViniso;
            return value;
        }
        else if (fieldName.equals("PRIM_APELLIDO")) {        
          value = (String)b[3];
            return value;
        }
        else if (fieldName.equals("SEG_APELLIDO")) {        
          value = (String)b[4];
            return value;
        }
        else if (fieldName.equals("LLAMADA")) { 
        value ="N";
        if(b[9]!=null){
            value ="S";
        }
            return value;
        }
        else if (fieldName.equals("OBS_LLAMADAS")) {        
          value = (String)b[9];
            return value;
        }
        else if (fieldName.equals("PH1")) {        
          value = (String)b[17];
            return value;
        }
        else if (fieldName.equals("PH2")) {        
          value = (String)b[18];
            return value;
        }
        else if (fieldName.equals("PH3")) {        
          value = (String)b[19];
            return value;
        }
        else if (fieldName.equals("PH4")) {        
          value = (String)b[20];
            return value;
        }
        else if (fieldName.equals("PH5")) {        
          value = (String)b[21];
            return value;
        }
        else if (fieldName.equals("PH6")) {        
          value = (String)b[22];
            return value;
        }
        else if (fieldName.equals("PH7")) {        
          value = (String)b[23];
            return value;
        }
        else if (fieldName.equals("PH8")) {        
          value = (String)b[24];
            return value;
        }
        else if (fieldName.equals("PHM")) {        
          value = (String)b[25];
            return value;
        }
        else if (fieldName.equals("PHO")) {        
          value = (String)b[26];
            return value;
        }
        else if (fieldName.equals("PHOD")) {        
          value = (String)b[28];
            return value;
        }
        else if (fieldName.equals("PF1")) {        
          value = (String)b[29];
            return value;
        }
        else if (fieldName.equals("PF2")) {        
          value = (String)b[30];
            return value;
        }
        else if (fieldName.equals("PF3")) {        
          value = (String)b[31];
            return value;
        }
      
        else if (fieldName.equals("PF4")) {        
          value = (String)b[32];
            return value;
        }
        else if (fieldName.equals("PFM")) {        
          value = (String)b[33];
            return value;
        }
        else if (fieldName.equals("PFO")) {        
          value = (String)b[34];
            return value;
        }
        else if (fieldName.equals("PFOA")) {        
          value = (String)b[36];
            return value;
        }
        else if (fieldName.equals("PO1")) {        
          value = (String)b[37];
            return value;
        }
        else if (fieldName.equals("PO2")) {        
          value = (String)b[38];
            return value;
        }
        else if (fieldName.equals("PO3")) {        
          value = (String)b[39];
            return value;
        }
        else if (fieldName.equals("PO_CUAL3")) {        
          value = (String)b[40];
            return value;
        }
        else if (fieldName.equals("PO4")) {        
          value = (String)b[41];
            return value;
        }
        else if (fieldName.equals("PO5")) {        
          value = (String)b[42];
            return value;
        }
        else if (fieldName.equals("PO6")) {        
          value = (String)b[44];
            return value;
        }
        else if (fieldName.equals("PO_CUAL6")) {        
          value = (String)b[45];
            return value;
        }
        else if (fieldName.equals("PO7")) {        
          value = (String)b[46];
          if(value !=null && value.equals("S")){
              value ="Sano";
          }
          else if(value !=null && value.equals("E")){
              value = "Enfermo";
          }
            else if(value !=null && value.equals("NA")){
                value = "No Aplica";
            }
            return value;
        }
        else if (fieldName.equals("NOMBRE_PROFESIONAL")) {        
          value = nombreProfesional;
            return value;
        }
        else if (fieldName.equals("REGISTRO_MEDICO")) {        
          value = regProfesional;
            return value;
        }
        else if (fieldName.equals("CODIGO_MEDICO")) {        
          value = codigoProfesional;
            return value;
        }
        else if (fieldName.equals("CARGO_MEDICO")) {        
          value = cargoProfesional;
            return value;
        }
        else if (fieldName.equals("RECOMENDACIONES")) {        
          value = (String)b[48];
            return value;
        }

        return value;
    }
    
    
    
    /**
     * @param valueChangeEvent
     */
    public void setContesta(ValueChangeEvent valueChangeEvent) {
        setContesta((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeContesta() {
        if (contesta != null && contesta.equals("N")) {
            limpiarRegistro();
            mostrarContesta = true;
            mostrarItem = false;
        } else if(contesta != null && contesta.equals("S")) {
            limpiarRegistro();
            mostrarContesta = false;
            mostrarItem = true;
        }
    }
    

    /**
     * @param valueChangeEvent
     */
    public void setEsHoraActual(ValueChangeEvent valueChangeEvent) {
        setEsHoraActual((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeEsHoraActual() {
        if (esHoraActual != null && esHoraActual.equals("N")) {
            mostrarHoraActual = true;
            mostrarItem = false;
        } else if(esHoraActual != null && esHoraActual.equals("S")) {
            mostrarItem = true;
            mostrarHoraActual = false;
        }
    }
    public void changeTodosSiPreguntasHeridaQuirurgica() {
        inicializarPreguntasHeridaQuirurgica("S");
    }
    
    public void changeTodosNoPreguntasHeridaQuirurgica() {
        inicializarPreguntasHeridaQuirurgica("N");
    }
    
    public void changeNingunoPreguntasHeridaQuirurgica() {
        inicializarPreguntasHeridaQuirurgica(null);
    }
    
    public void changeNoAplicaPreguntasHeridaQuirurgica() {
        inicializarPreguntasHeridaQuirurgica("NA");
    }
    
    public void inicializarPreguntasHeridaQuirurgica(String opcion){
            
            corolaSelect=opcion;
            segTelefono.setHstcreccoloro(corolaSelect);
            dolorSelect=opcion;
            segTelefono.setHstcdolormedi(dolorSelect);
            calorSelect=opcion;
            segTelefono.setHstccalorheri(calorSelect);
            enrojecimientoSelect=opcion;
            segTelefono.setHstcenroherid(enrojecimientoSelect);
            sangreSelect=opcion;
            segTelefono.setHstcsalisanher(sangreSelect);
            pusSelect=opcion;
            segTelefono.setHstcsalipusher(pusSelect);
            liquidoSelect=opcion;
            segTelefono.setHstcsaliliqher(liquidoSelect);
            olorSelect=opcion;
            segTelefono.setHstcmalolorhe(olorSelect);
            cualMolestia=opcion;
            segTelefono.setHstcpremolest(cualMolestia);
            cual=null;
            segTelefono.setHstccualmoles(cual);
            observacionAdicional=opcion;
            segTelefono.setHstcobseradic(observacionAdicional);
            observacion=null;
            segTelefono.setHstcobservaci(observacion);
            ChangeRenderOpciones();
            ChangeCualMolestia();
            ChangeObservaciones();
        }
        
    public void changeTodosSiPreguntasFlebitis() {
        inicializarPreguntasFlebitis("S");
    }
    
    public void changeTodosNoPreguntasFlebitis() {
        inicializarPreguntasFlebitis("N");
    }
    
    public void changeNingunoPreguntasFlebitis() {
        inicializarPreguntasFlebitis(null);
    }
    public void changeNoAplicaPreguntasFlebitis() {
        inicializarPreguntasFlebitis("NA");
    }
    
    public void inicializarPreguntasFlebitis(String opcion){
            canalizacionSelect=opcion;
            segTelefono.setHstcenrositio(canalizacionSelect);
            dolorCanaliSelect=opcion;
            segTelefono.setHstcpresedolo(dolorCanaliSelect);
            recuperacionSelect=opcion;
            segTelefono.setHstcrecucanal(recuperacionSelect);
            pusVenaSelect=opcion;
            segTelefono.setHstcpussavena(pusVenaSelect);
            molestiaFlebitis=opcion;
            segTelefono.setHstcpresmoles(molestiaFlebitis);
            cualMolestiaFlebitis=null;
            segTelefono.setHstcmolescual(cualMolestiaFlebitis);
            observacionAdicionalFlebitis=opcion;
            segTelefono.setHstcobservadi(observacionAdicionalFlebitis);
            observacionFlebitis=null;
            segTelefono.setHstcobseracio(observacionFlebitis);
            ChangeRenderOpciones();
            ChangeCualMolestiaFlebitis();
            ChangeObservacionesFlebitis();
            
        }
        
    public void changeTodosSiPreguntasControlPosOperatorio() {
        inicializarPreguntasControlPosOperatorio("S");
    }
    
    public void changeTodosNoPreguntasControlPosOperatorio() {
        inicializarPreguntasControlPosOperatorio("N");
    }
    
    public void changeNingunoPreguntasControlPosOperatorio() {
        inicializarPreguntasControlPosOperatorio(null);
    }
    
    public void changeNoAplicaPreguntasControlPosOperatorio() {
        inicializarPreguntasControlPosOperatorio("NA");
    }
    
    public void inicializarPreguntasControlPosOperatorio(String opcion){
            posoperatorioSelect = opcion;
            segTelefono.setHstccasiconpos(posoperatorioSelect);
            posoperatorioPorqueno=null;
            signosSelect = opcion;
            segTelefono.setHstcsigantcon(signosSelect);
            antibioticoSelect = opcion;
            segTelefono.setHstcordeantiv(antibioticoSelect);
            segTelefono.setHstccualantiv(null);
            medicamentoSelect = opcion;
            segTelefono.setHstcmedimedic(medicamentoSelect);
            hospitalSelect = opcion;
            segTelefono.setHstcmedpospr(hospitalSelect);
            segTelefono.setHstccualhosp(null);
            algunMedicamentoTextSelect = opcion;
            segTelefono.setHstcdiermedic(algunMedicamentoTextSelect);
            segTelefono.setHstccualmedic(null);
            if(opcion != null && opcion.equals("N")){
                tratamientoSelect = "E";
            }else{
                tratamientoSelect = opcion;
            }
            segTelefono.setHstcdeputrata(tratamientoSelect);
            recomendacionSelect = opcion;
            segTelefono.setHstcrecoemiti(recomendacionSelect);
            segTelefono.setHstcrecomend(null);
            
            ChangeRenderOpciones();
            ChangePosoperatorioSelect();
            ChangeAntibioticoSelect();
            ChangeHospitalSelect();
            ChangeAlgunMedicamentoTextSelect();
            ChangeRecomendaciones();
            
        }
        
    
        
    /**
     * @param valueChangeEvent
     */
    public void setSelectCorola(ValueChangeEvent valueChangeEvent) {
        setCorolaSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setSelectDolor(ValueChangeEvent valueChangeEvent) {
        setDolorSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setCalorSelect(ValueChangeEvent valueChangeEvent) {
        setCalorSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setEnrojecimientoSelect(ValueChangeEvent valueChangeEvent) {
        setEnrojecimientoSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setSangreSelect(ValueChangeEvent valueChangeEvent) {
        setSangreSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    
    /**
     * @param valueChangeEvent
     */
    public void setPusSelect(ValueChangeEvent valueChangeEvent) {
        setPusSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setLiquidoSelect(ValueChangeEvent valueChangeEvent) {
        setLiquidoSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setOlorSelect(ValueChangeEvent valueChangeEvent) {
        setOlorSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setDolorCanaliSelect(ValueChangeEvent valueChangeEvent) {
        setDolorCanaliSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setCanalizacionSelect(ValueChangeEvent valueChangeEvent) {
        setCanalizacionSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    
    /**
     * @param valueChangeEvent
     */
    public void setRecuperacionSelect(ValueChangeEvent valueChangeEvent) {
        setRecuperacionSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    
    /**
     * @param valueChangeEvent
     */
    public void setPusVenaSelect(ValueChangeEvent valueChangeEvent) {
        setPusVenaSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    
    /**
     * @param valueChangeEvent
     */
    public void setSignosSelect(ValueChangeEvent valueChangeEvent) {
        setSignosSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    
    /**
     * @param valueChangeEvent
     */
    public void setAntibioticoSelect(ValueChangeEvent valueChangeEvent) {
        setAntibioticoSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    
    /**
     * @param valueChangeEvent
     */
    public void setMedicamentoSelect(ValueChangeEvent valueChangeEvent) {
        setMedicamentoSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setTratamientoSelect(ValueChangeEvent valueChangeEvent) {
        setTratamientoSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    
    
    
    
    public void ChangeAntibioticoSelect(){
        if((antibioticoSelect != null && antibioticoSelect.equals("N")) || (antibioticoSelect != null && antibioticoSelect.equals("NA")) ){
            mostrarAntibioticoSelect = false;
        }else if(antibioticoSelect != null && antibioticoSelect.equals("S")){
            mostrarAntibioticoSelect = true;
        }else if(antibioticoSelect == null){
            mostrarAntibioticoSelect = false;
        }
        ChangeRenderOpciones();
    }
    
    
    
    
    
    /**
     * @param valueChangeEvent
     */
    public void setObservacionAdicional(ValueChangeEvent valueChangeEvent) {
        setObservacionAdicional((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void ChangeObservaciones(){
        if((observacionAdicional != null && observacionAdicional.equals("N")) || (observacionAdicional != null && observacionAdicional.equals("NA"))){
            mostrarAdicional = false;
        }else if(observacionAdicional != null && observacionAdicional.equals("S")){
            mostrarAdicional = true;
        }else if(observacionAdicional == null ){
            mostrarAdicional = false;
        }
        ChangeRenderOpciones();
    }
    
    
    /**
     * @param valueChangeEvent
     */
    public void setObservacionAdicionalFlebitis(ValueChangeEvent valueChangeEvent) {
        setObservacionAdicionalFlebitis((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void ChangeObservacionesFlebitis(){
        if((observacionAdicionalFlebitis != null && observacionAdicionalFlebitis.equals("N"))|| (observacionAdicionalFlebitis != null && observacionAdicionalFlebitis.equals("NA"))){
            mostrarAdicionalFlebitis = false;
        }else if(observacionAdicionalFlebitis != null && observacionAdicionalFlebitis.equals("S")){
            mostrarAdicionalFlebitis = true;
        }else if(observacionAdicionalFlebitis == null){
            mostrarAdicionalFlebitis = false;
        }
        ChangeRenderOpciones();
    }
    
    
    /**
     * @param valueChangeEvent
     */
    public void setCualMolestia(ValueChangeEvent valueChangeEvent) {
        setCualMolestia((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void ChangeCualMolestia(){
        if((cualMolestia != null && cualMolestia.equals("N")) || (cualMolestia != null && cualMolestia.equals("NA"))  ){
            mostrarCualMolestia = false;
        }else if(cualMolestia != null && cualMolestia.equals("S")){
            mostrarCualMolestia = true;
        }else if(cualMolestia == null ){
            mostrarCualMolestia = false;
        }
        ChangeRenderOpciones();
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setCualMolestiaFlebitis(ValueChangeEvent valueChangeEvent) {
        setMolestiaFlebitis((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void ChangeCualMolestiaFlebitis(){
        if((molestiaFlebitis != null && molestiaFlebitis.equals("N")) || (molestiaFlebitis != null && molestiaFlebitis.equals("NA"))){
            mostrarCualMolestiaFlebitis = false;
        }else if(molestiaFlebitis != null && molestiaFlebitis.equals("S")){
            mostrarCualMolestiaFlebitis = true;
        }else if(molestiaFlebitis == null){
            mostrarCualMolestiaFlebitis = false;
        }
        ChangeRenderOpciones();
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setPosoperatorioSelect(ValueChangeEvent valueChangeEvent) {
        setPosoperatorioSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void ChangePosoperatorioSelect(){
        if(posoperatorioSelect != null && posoperatorioSelect.equals("N")){
            mostrarposoperatorioSelect = true;
        }else if(posoperatorioSelect != null && posoperatorioSelect.equals("S")){
            mostrarposoperatorioSelect = false;
        }else if(posoperatorioSelect == null){
            mostrarposoperatorioSelect = false;
        }else if(posoperatorioSelect != null && posoperatorioSelect.equals("NA")){
            mostrarposoperatorioSelect = false;
        }
    }
    
    
    
    /**
     * @param valueChangeEvent
     */
    public void setCualMedicamento(ValueChangeEvent valueChangeEvent) {
        setCualMedicamento((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void ChangeCualMedicamento(){
        if((cualMedicamento != null && cualMedicamento.equals("N")) || (cualMedicamento != null && cualMedicamento.equals("NA")) ){
            mostrarCualMedicamento = false;
        }else if(cualMedicamento != null && cualMedicamento.equals("S")){
            mostrarCualMedicamento = true;
        }
    }

    /**
     * @param valueChangeEvent
     */
    public void setRecomendacioneSelect(ValueChangeEvent valueChangeEvent) {
        setRecomendacionSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void ChangeRecomendaciones(){
        if((recomendacionSelect != null && recomendacionSelect.equals("N")) || (recomendacionSelect != null && recomendacionSelect.equals("NA"))){
            mostrarRecomendaciones = false;
        }else if(recomendacionSelect != null && recomendacionSelect.equals("S")){
            mostrarRecomendaciones = true;
        }else if(recomendacionSelect == null){
            mostrarRecomendaciones = false;
        }
        ChangeRenderOpciones();
    }

    
    /**
     * @param valueChangeEvent
     */
    public void setAlgunMedicamentoTextSelect(ValueChangeEvent valueChangeEvent) {
        setAlgunMedicamentoTextSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void ChangeAlgunMedicamentoTextSelect(){
        if((algunMedicamentoTextSelect != null && algunMedicamentoTextSelect.equals("N")) || (algunMedicamentoTextSelect != null && algunMedicamentoTextSelect.equals("NA")) ){
            mostrarAlgunMedicamentoTextSelect = false;
        }else if(algunMedicamentoTextSelect != null && algunMedicamentoTextSelect.equals("S")){
            mostrarAlgunMedicamentoTextSelect = true;
        }else if(algunMedicamentoTextSelect == null){
            mostrarAlgunMedicamentoTextSelect = false;
        }
        ChangeRenderOpciones();
    }
    
    
    /**
     * @param valueChangeEvent
     */
    public void setHospitalSelect(ValueChangeEvent valueChangeEvent) {
        setHospitalSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void ChangeHospitalSelect(){
        if((hospitalSelect != null && hospitalSelect.equals("N")) || ((hospitalSelect != null && hospitalSelect.equals("NA"))) ){
            mostrarHospitalSelect = false;
        }else if(hospitalSelect != null && hospitalSelect.equals("S")){
            mostrarHospitalSelect = true;
        }else if(hospitalSelect == null){
            mostrarHospitalSelect = false;
        }
        ChangeRenderOpciones();
    }
    
    
    public void limpiarRegistro(){
        changeNingunoPreguntasHeridaQuirurgica();
        changeNingunoPreguntasFlebitis();
        changeNingunoPreguntasControlPosOperatorio();
        mostrarAdicional = false;
        mostrarCualMolestia = false;
        mostrarCualMedicamento = false;
        mostrarRecomendaciones = false;
        mostrarContesta = false;
        mostrarSelectCorola = false;
        mostrarAntibioticoSelect = false;
        mostrarHospitalSelect = false;
        mostrarAlgunMedicamentoTextSelect = false;
        renderColoracion=false;
        renderDolor=false;
        renderCalor=false;
        renderEnrojecimiento=false;
        renderSangre=false;
        renderPus=false;
        renderLiquido=false;
        renderOlor=false;
        renderMolestia=false;
        renderObservacionesAdicionales=false;
        renderCanalizacion=false;
        renderDolorCanali=false;
        renderRecuperacion=false;
        renderPusVena=false;
        renderMolestiaFlebitis=false;
        renderObservacioAdicionalesFlebitis=false;
        renderPosoperatorio=false;
        renderSignos=false;
        renderAntibiotico=false;
        renderMedicamento=false;
        renderHospital=false;
        renderAlgunMedicamento=false;
        renderTratamiento=false;
        renderlRecomendaciones=false;
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
            lstOpciones.add(new SelectItem("NA", "NO APLICA"));
        }
        return lstOpciones;
    }


    /**
     * @param lstTratamiento
     */
    public void setLstTratamiento(List lstTratamiento) {
        this.lstTratamiento = lstTratamiento;
    }

    /**
     * @return
     */
    public List getLstTratamiento() {
        if (lstTratamiento == null) {
            lstTratamiento = new ArrayList();
            lstTratamiento.add(new SelectItem("S", "SANO"));
            lstTratamiento.add(new SelectItem("E", "ENFERMO"));
            lstTratamiento.add(new SelectItem("NA", "NO APLICA"));
        }
        return lstTratamiento;
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
     * @param lstSeguimientoTelefonico
     */
    public void setLstSeguimientoTelefonico(List<Chsegutelefo> lstSeguimientoTelefonico) {
        this.lstSeguimientoTelefonico = lstSeguimientoTelefonico;
    }

    /**
     * @return
     */
    public List<Chsegutelefo> getLstSeguimientoTelefonico() {
        return lstSeguimientoTelefonico;
    }

    /**
     * @param dtSeguimiento
     */
    public void setDtSeguimiento(HtmlDataTable dtSeguimiento) {
        this.dtSeguimiento = dtSeguimiento;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtSeguimiento() {
        return dtSeguimiento;
    }


    public void setMostrarItem(boolean mostrarItem) {
        this.mostrarItem = mostrarItem;
    }

    public boolean isMostrarItem() {
        return mostrarItem;
    }

    public void setObservacionAdicional(String observacionAdicional) {
        this.observacionAdicional = observacionAdicional;
    }

    public String getObservacionAdicional() {
        return observacionAdicional;
    }

    public void setMostrarAdicional(boolean mostrarAdicional) {
        this.mostrarAdicional = mostrarAdicional;
    }

    public boolean isMostrarAdicional() {
        return mostrarAdicional;
    }

    public void setMostrarCualMolestia(boolean mostrarCualMolestia) {
        this.mostrarCualMolestia = mostrarCualMolestia;
    }

    public boolean isMostrarCualMolestia() {
        return mostrarCualMolestia;
    }


    public void setCualMolestia(String cualMolestia) {
        this.cualMolestia = cualMolestia;
    }

    public String getCualMolestia() {
        return cualMolestia;
    }

    public void setCualMedicamento(String cualMedicamento) {
        this.cualMedicamento = cualMedicamento;
    }

    public String getCualMedicamento() {
        return cualMedicamento;
    }

    public void setMostrarCualMedicamento(boolean mostrarCualMedicamento) {
        this.mostrarCualMedicamento = mostrarCualMedicamento;
    }

    public boolean isMostrarCualMedicamento() {
        return mostrarCualMedicamento;
    }

    public void setRecomendacionSelect(String recomendacionSelect) {
        this.recomendacionSelect = recomendacionSelect;
    }

    public String getRecomendacionSelect() {
        return recomendacionSelect;
    }

    public void setMostrarRecomendaciones(boolean mostrarRecomendaciones) {
        this.mostrarRecomendaciones = mostrarRecomendaciones;
    }

    public boolean isMostrarRecomendaciones() {
        return mostrarRecomendaciones;
    }

    public void setContesta(String contesta) {
        this.contesta = contesta;
    }

    public String getContesta() {
        return contesta;
    }

    public void setMostrarContesta(boolean mostrarContesta) {
        this.mostrarContesta = mostrarContesta;
    }

    public boolean isMostrarContesta() {
        return mostrarContesta;
    }

    public void setCorolaSelect(String corolaSelect) {
        this.corolaSelect = corolaSelect;
    }

    public String getCorolaSelect() {
        return corolaSelect;
    }

    public void setMostrarSelectCorola(boolean mostrarSelectCorola) {
        this.mostrarSelectCorola = mostrarSelectCorola;
    }

    public boolean isMostrarSelectCorola() {
        return mostrarSelectCorola;
    }

    public void setDolorSelect(String dolorSelect) {
        this.dolorSelect = dolorSelect;
    }

    public String getDolorSelect() {
        return dolorSelect;
    }

    public void setCalorSelect(String calorSelect) {
        this.calorSelect = calorSelect;
    }

    public String getCalorSelect() {
        return calorSelect;
    }

    public void setEnrojecimientoSelect(String enrojecimientoSelect) {
        this.enrojecimientoSelect = enrojecimientoSelect;
    }

    public String getEnrojecimientoSelect() {
        return enrojecimientoSelect;
    }

    public void setSangreSelect(String sangreSelect) {
        this.sangreSelect = sangreSelect;
    }

    public String getSangreSelect() {
        return sangreSelect;
    }

    public void setPusSelect(String pusSelect) {
        this.pusSelect = pusSelect;
    }

    public String getPusSelect() {
        return pusSelect;
    }

    public void setLiquidoSelect(String liquidoSelect) {
        this.liquidoSelect = liquidoSelect;
    }

    public String getLiquidoSelect() {
        return liquidoSelect;
    }

    public void setOlorSelect(String olorSelect) {
        this.olorSelect = olorSelect;
    }

    public String getOlorSelect() {
        return olorSelect;
    }

    public void set_canalizacionSelect(String _canalizacionSelect) {
        this.canalizacionSelect = _canalizacionSelect;
    }

    public String getCanalizacionSelect() {
        return canalizacionSelect;
    }

    public void setCanalizacionSelect(String canalizacionSelect) {
        this.canalizacionSelect = canalizacionSelect;
    }

    public void setDolorCanaliSelect(String dolorCanaliSelect) {
        this.dolorCanaliSelect = dolorCanaliSelect;
    }

    public String getDolorCanaliSelect() {
        return dolorCanaliSelect;
    }

    public void setRecuperacionSelect(String recuperacionSelect) {
        this.recuperacionSelect = recuperacionSelect;
    }

    public String getRecuperacionSelect() {
        return recuperacionSelect;
    }

    public void setPusVenaSelect(String pusVenaSelect) {
        this.pusVenaSelect = pusVenaSelect;
    }

    public String getPusVenaSelect() {
        return pusVenaSelect;
    }

    public void setPosoperatorioSelect(String posoperatorioSelect) {
        this.posoperatorioSelect = posoperatorioSelect;
    }

    public String getPosoperatorioSelect() {
        return posoperatorioSelect;
    }

    public void setMostrarposoperatorioSelect(boolean mostrarposoperatorioSelect) {
        this.mostrarposoperatorioSelect = mostrarposoperatorioSelect;
    }

    public boolean isMostrarposoperatorioSelect() {
        return mostrarposoperatorioSelect;
    }

    public void setSignosSelect(String signosSelect) {
        this.signosSelect = signosSelect;
    }

    public String getSignosSelect() {
        return signosSelect;
    }

    public void setAntibioticoSelect(String antibioticoSelect) {
        this.antibioticoSelect = antibioticoSelect;
    }

    public String getAntibioticoSelect() {
        return antibioticoSelect;
    }

    public void setMostrarAntibioticoSelect(boolean mostrarAntibioticoSelect) {
        this.mostrarAntibioticoSelect = mostrarAntibioticoSelect;
    }

    public boolean isMostrarAntibioticoSelect() {
        return mostrarAntibioticoSelect;
    }

    public void setMedicamentoSelect(String medicamentoSelect) {
        this.medicamentoSelect = medicamentoSelect;
    }

    public String getMedicamentoSelect() {
        return medicamentoSelect;
    }

    public void setHospitalSelect(String hospitalSelect) {
        this.hospitalSelect = hospitalSelect;
    }

    public String getHospitalSelect() {
        return hospitalSelect;
    }

    public void setMostrarHospitalSelect(boolean mostrarHospitalSelect) {
        this.mostrarHospitalSelect = mostrarHospitalSelect;
    }

    public boolean isMostrarHospitalSelect() {
        return mostrarHospitalSelect;
    }

    public void setAlgunMedicamentoTextSelect(String algunMedicamentoTextSelect) {
        this.algunMedicamentoTextSelect = algunMedicamentoTextSelect;
    }

    public String getAlgunMedicamentoTextSelect() {
        return algunMedicamentoTextSelect;
    }

    public void setMostrarAlgunMedicamentoTextSelect(boolean mostrarAlgunMedicamentoTextSelect) {
        this.mostrarAlgunMedicamentoTextSelect = mostrarAlgunMedicamentoTextSelect;
    }

    public boolean isMostrarAlgunMedicamentoTextSelect() {
        return mostrarAlgunMedicamentoTextSelect;
    }

    public void setTratamientoSelect(String tratamientoSelect) {
        this.tratamientoSelect = tratamientoSelect;
    }

    public String getTratamientoSelect() {
        return tratamientoSelect;
    }

    public void setCual(String cual) {
        this.cual = cual;
    }

    public String getCual() {
        return cual;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setCualMolestiaFlebitis(String cualMolestiaFlebitis) {
        this.cualMolestiaFlebitis = cualMolestiaFlebitis;
    }

    public String getCualMolestiaFlebitis() {
        return cualMolestiaFlebitis;
    }

    public void setMolestiaFlebitis(String molestiaFlebitis) {
        this.molestiaFlebitis = molestiaFlebitis;
    }

    public String getMolestiaFlebitis() {
        return molestiaFlebitis;
    }

    public void setObservacionAdicionalFlebitis(String observacionAdicionalFlebitis) {
        this.observacionAdicionalFlebitis = observacionAdicionalFlebitis;
    }

    public String getObservacionAdicionalFlebitis() {
        return observacionAdicionalFlebitis;
    }

    public void setObservacionFlebitis(String observacionFlebitis) {
        this.observacionFlebitis = observacionFlebitis;
    }

    public String getObservacionFlebitis() {
        return observacionFlebitis;
    }

    public void setMostrarAdicionalFlebitis(boolean mostrarAdicionalFlebitis) {
        this.mostrarAdicionalFlebitis = mostrarAdicionalFlebitis;
    }

    public boolean isMostrarAdicionalFlebitis() {
        return mostrarAdicionalFlebitis;
    }

    public void setMostrarCualMolestiaFlebitis(boolean mostrarCualMolestiaFlebitis) {
        this.mostrarCualMolestiaFlebitis = mostrarCualMolestiaFlebitis;
    }

    public boolean isMostrarCualMolestiaFlebitis() {
        return mostrarCualMolestiaFlebitis;
    }

    public void setCualAntibioticoSelect(String cualAntibioticoSelect) {
        this.cualAntibioticoSelect = cualAntibioticoSelect;
    }

    public String getCualAntibioticoSelect() {
        return cualAntibioticoSelect;
    }

    public void ChangeRenderOpciones() {
        renderColoracion=false;
        renderDolor=false;
        renderCalor=false;
        renderEnrojecimiento=false;
        renderSangre=false;
        renderPus=false;
        renderLiquido=false;
        renderOlor=false;
        renderMolestia=false;
        renderObservacionesAdicionales=false;
        renderCanalizacion=false;
        renderDolorCanali=false;
        renderRecuperacion=false;
        renderPusVena=false;
        renderMolestiaFlebitis=false;
        renderObservacioAdicionalesFlebitis=false;
        renderPosoperatorio=false;
        renderSignos=false;
        renderAntibiotico=false;
        renderMedicamento=false;
        renderHospital=false;
        renderAlgunMedicamento=false;
        renderTratamiento=false;
        renderlRecomendaciones=false;
        
        if (corolaSelect != null && corolaSelect.equals("S")) {
            renderColoracion = true;
        }
        if (dolorSelect != null && dolorSelect.equals("S")) {
            renderDolor = true;
        }

        if (calorSelect != null && calorSelect.equals("S")) {
            renderCalor = true;
        }

        if (enrojecimientoSelect != null && enrojecimientoSelect.equals("S")) {
            renderEnrojecimiento = true;
        }
        
        if (sangreSelect != null && sangreSelect.equals("S")) {
            renderSangre = true;
        }

        if (pusSelect != null && pusSelect.equals("S")) {
            renderPus = true;
        }
        if (liquidoSelect != null && liquidoSelect.equals("S")) {
            renderLiquido = true;
        }
        if (olorSelect != null && olorSelect.equals("S")) {
            renderOlor = true;
        }
        
        if (cualMolestia != null && cualMolestia.equals("S")) {
            renderMolestia = true;
        }
        
        if (molestiaFlebitis != null && molestiaFlebitis.equals("S")) {
            renderMolestiaFlebitis = true;
        }
        
        if (observacionAdicional != null && observacionAdicional.equals("S")) {
            renderObservacionesAdicionales = true;
        }
        
        if (canalizacionSelect != null && canalizacionSelect.equals("S")) {
            renderCanalizacion = true;
        }
        if (dolorCanaliSelect != null && dolorCanaliSelect.equals("S")) {
            renderDolorCanali = true;
        }
        if (recuperacionSelect != null && recuperacionSelect.equals("S")) {
            renderRecuperacion = true;
        }
        if (pusVenaSelect != null && pusVenaSelect.equals("S")) {
            renderPusVena = true;
        }
        
        if (observacionAdicionalFlebitis != null && observacionAdicionalFlebitis.equals("S")) {
            renderObservacioAdicionalesFlebitis = true;
        }
        
        
    }

    public void setRenderColoracion(boolean renderColoracion) {
        this.renderColoracion = renderColoracion;
    }

    public boolean isRenderColoracion() {
        return renderColoracion;
    }

    public void setRenderDolor(boolean renderDolor) {
        this.renderDolor = renderDolor;
    }

    public boolean isRenderDolor() {
        return renderDolor;
    }

    public void setRenderCalor(boolean renderCalor) {
        this.renderCalor = renderCalor;
    }

    public boolean isRenderCalor() {
        return renderCalor;
    }

    public void setRenderEnrojecimiento(boolean renderEnrojecimiento) {
        this.renderEnrojecimiento = renderEnrojecimiento;
    }

    public boolean isRenderEnrojecimiento() {
        return renderEnrojecimiento;
    }

    public void setRenderSangre(boolean renderSangre) {
        this.renderSangre = renderSangre;
    }

    public boolean isRenderSangre() {
        return renderSangre;
    }

    public void setRenderPus(boolean renderPus) {
        this.renderPus = renderPus;
    }

    public boolean isRenderPus() {
        return renderPus;
    }

    public void setRenderLiquido(boolean renderLiquido) {
        this.renderLiquido = renderLiquido;
    }

    public boolean isRenderLiquido() {
        return renderLiquido;
    }

    public void setRenderOlor(boolean renderOlor) {
        this.renderOlor = renderOlor;
    }

    public boolean isRenderOlor() {
        return renderOlor;
    }

    public void setRenderMolestia(boolean renderMolestia) {
        this.renderMolestia = renderMolestia;
    }

    public boolean isRenderMolestia() {
        return renderMolestia;
    }

    public void setRenderObservacionesAdicionales(boolean renderObservacionesAdicionales) {
        this.renderObservacionesAdicionales = renderObservacionesAdicionales;
    }

    public boolean isRenderObservacionesAdicionales() {
        return renderObservacionesAdicionales;
    }

    public void setRenderCanalizacion(boolean renderCanalizacion) {
        this.renderCanalizacion = renderCanalizacion;
    }

    public boolean isRenderCanalizacion() {
        return renderCanalizacion;
    }

    public void setRenderDolorCanali(boolean renderDolorCanali) {
        this.renderDolorCanali = renderDolorCanali;
    }

    public boolean isRenderDolorCanali() {
        return renderDolorCanali;
    }

    public void setRenderRecuperacion(boolean renderRecuperacion) {
        this.renderRecuperacion = renderRecuperacion;
    }

    public boolean isRenderRecuperacion() {
        return renderRecuperacion;
    }

    public void setRenderPusVena(boolean renderPusVena) {
        this.renderPusVena = renderPusVena;
    }

    public boolean isRenderPusVena() {
        return renderPusVena;
    }

    public void setRenderMolestiaFlebitis(boolean renderMolestiaFlebitis) {
        this.renderMolestiaFlebitis = renderMolestiaFlebitis;
    }

    public boolean isRenderMolestiaFlebitis() {
        return renderMolestiaFlebitis;
    }

    public void setRenderObservacioAdicionalesFlebitis(boolean renderObservacioAdicionalesFlebitis) {
        this.renderObservacioAdicionalesFlebitis = renderObservacioAdicionalesFlebitis;
    }

    public boolean isRenderObservacioAdicionalesFlebitis() {
        return renderObservacioAdicionalesFlebitis;
    }

    public void setRenderPosoperatorio(boolean renderPosoperatorio) {
        this.renderPosoperatorio = renderPosoperatorio;
    }

    public boolean isRenderPosoperatorio() {
        return renderPosoperatorio;
    }

    public void setRenderSignos(boolean renderSignos) {
        this.renderSignos = renderSignos;
    }

    public boolean isRenderSignos() {
        return renderSignos;
    }

    public void setRenderAntibiotico(boolean renderAntibiotico) {
        this.renderAntibiotico = renderAntibiotico;
    }

    public boolean isRenderAntibiotico() {
        return renderAntibiotico;
    }

    public void setRenderMedicamento(boolean renderMedicamento) {
        this.renderMedicamento = renderMedicamento;
    }

    public boolean isRenderMedicamento() {
        return renderMedicamento;
    }

    public void setRenderHospital(boolean renderHospital) {
        this.renderHospital = renderHospital;
    }

    public boolean isRenderHospital() {
        return renderHospital;
    }

    public void setRenderAlgunMedicamento(boolean renderAlgunMedicamento) {
        this.renderAlgunMedicamento = renderAlgunMedicamento;
    }

    public boolean isRenderAlgunMedicamento() {
        return renderAlgunMedicamento;
    }

    public void setRenderTratamiento(boolean renderTratamiento) {
        this.renderTratamiento = renderTratamiento;
    }

    public boolean isRenderTratamiento() {
        return renderTratamiento;
    }

    public void setRenderlRecomendaciones(boolean renderlRecomendaciones) {
        this.renderlRecomendaciones = renderlRecomendaciones;
    }

    public boolean isRenderlRecomendaciones() {
        return renderlRecomendaciones;
    }

    public void setCualHospital(String cualHospital) {
        this.cualHospital = cualHospital;
    }

    public String getCualHospital() {
        return cualHospital;
    }

    public void setPosoperatorioPorqueno(String posoperatorioPorqueno) {
        this.posoperatorioPorqueno = posoperatorioPorqueno;
    }

    public String getPosoperatorioPorqueno() {
        return posoperatorioPorqueno;
    }

    public void setCualAlgunMedicamento(String cualAlgunMedicamento) {
        this.cualAlgunMedicamento = cualAlgunMedicamento;
    }

    public String getCualAlgunMedicamento() {
        return cualAlgunMedicamento;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setLstOpcionesComprobacion(List lstOpcionesComprobacion) {
        this.lstOpcionesComprobacion = lstOpcionesComprobacion;
    }

    public List getLstOpcionesComprobacion() {
        if (lstOpcionesComprobacion == null) {
            lstOpcionesComprobacion = new ArrayList();
            lstOpcionesComprobacion.add(new SelectItem("S", "SI"));
            lstOpcionesComprobacion.add(new SelectItem("N", "NO"));
        }
        return lstOpcionesComprobacion;
    }

    public void setBotonImprimir(boolean botonImprimir) {
        this.botonImprimir = botonImprimir;
    }

    public boolean isBotonImprimir() {
        return botonImprimir;
    }

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }
}
