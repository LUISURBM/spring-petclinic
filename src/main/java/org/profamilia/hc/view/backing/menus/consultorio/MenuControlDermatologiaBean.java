package org.profamilia.hc.view.backing.menus.consultorio;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.ViewHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.view.backing.comun.conducta.VademecumMedicoBean;
import org.apache.commons.codec.binary.Base64;
import org.apache.myfaces.custom.tree2.TreeNode;
import org.apache.myfaces.custom.tree2.TreeNodeBase;

import org.apache.myfaces.renderkit.html.util.AddResource;
import org.apache.myfaces.renderkit.html.util.AddResourceFactory;

import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosBean;
import org.profamilia.hc.view.backing.comun.AntecedentesGeneralesUsuarioBean;
import org.profamilia.hc.view.backing.comun.AntecedentesUsuarioBean;
import org.profamilia.hc.view.backing.comun.AplicacionDispositivoBean;
import org.profamilia.hc.view.backing.comun.CerrarConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.ControlUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.ExamenFisicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.PausarConsultaBean;
import org.profamilia.hc.view.backing.comun.conducta.AnatomiaPatologicaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.AutorizacionServicioUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.CertAsistenciaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.CertMedicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ControlSinCostoUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ExamElectrofisiologicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ExamImagenUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ExamLaboratorioUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.FormulaMedicaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.HospitalizacionUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.IncapacidadUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.InterConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.OrdenCirugiaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.RecomedacionUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ReferenciaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ReservaSangreUsuarioBean;
import org.profamilia.hc.view.backing.comun.resumen.ResumenHistoriaEspecificaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.ExpandableTreeModel;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.view.backing.cirugia.registro.OtrasOrdenesBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaHospitalizacionBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaLiquidosBean;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;
import org.profamilia.hc.view.backing.comun.RegistrarEscalaValoracionCaidasCEBean;


public class MenuControlDermatologiaBean extends BaseBean {

    private DatosBasicosUsuarioBean datosBasicosUsuario;

    private ExamenFisicoUsuarioBean examenFisicoUsuario;

    private AnatomiaPatologicaUsuarioBean anatomiaPatologicaUsuarioBean;

    private ControlSinCostoUsuarioBean controlSinCostoUsuarioBean;

    private FormulaMedicaUsuarioBean formulaMedicaUsuarioBean;

    private HospitalizacionUsuarioBean hospitalizacionUsuarioBean;

    private OrdenCirugiaUsuarioBean ordenCirugiaUsuarioBean;

    private InterConsultaUsuarioBean interConsultaUsuarioBean;

    private IncapacidadUsuarioBean incapacidadUsuarioBean;

    private RecomedacionUsuarioBean recomedacionUsuarioBean;

    private ReferenciaUsuarioBean referenciaUsuarioBean;

    private ReservaSangreUsuarioBean reservaSangreUsuarioBean;

    private CertMedicoUsuarioBean certMedicoUsuarioBean;

    private CertAsistenciaUsuarioBean certAsistenciaUsuarioBean;

    private ExamElectrofisiologicoUsuarioBean examElectrofisiologicoUsuarioBean;

    private ExamImagenUsuarioBean examImagenUsuarioBean;

    private ExamLaboratorioUsuarioBean examLaboratorioUsuarioBean;

    private ControlUsuarioBean control;

    private CerrarConsultaUsuarioBean cerrarConsultaUsuarioBean;

    private ResumenHistoriaEspecificaBean resumenEspecifico;

    private AplicacionDispositivoBean dispositivos;
    
    private AntecedentesGeneralesUsuarioBean antecedentesGenerales;

    private AntecedentesUsuarioBean antecedentes;
    
    private AutorizacionServicioUsuarioBean autorizacionServicioUsuarioBean;
    
    private VademecumMedicoBean vademecumUsuarioBean;

    private boolean renderVademecum;
    
    private FormulaLiquidosBean formulaLiquidosBean;

    private FormulaHospitalizacionBean formulaHospitalizacionBean;  

    private OtrasOrdenesBean otrasOrdenesBean;
    
    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private boolean renderConducta;

    private boolean renderCerrarConsulta;

    private boolean renderControlDermatologia;

    private ExpandableTreeModel trnhistoria;

    private Long numeroConsulta;

    private String cie10Principal;

    private String cie10Relacionado1;

    private String codigoCups;
    
    private boolean primeraConsulta;
    
    private Chimprdiag impresion; 
    
    private Chmotivocon motivo;
    
    private String javaScriptText;

    private boolean renderPausarConsulta;
    private PausarConsultaBean pausarConsulta;
    private boolean tiempoAtencion;
    
    private boolean renderOrdenesMedicas;
    
    private ConfirmarServiciosAdmisionBean confirmarServiciosAdmision;
    private boolean renderServiciosAdmision;
    
    private CuestionarioCovidBean cuestionarioCovid;
    
    private boolean renderCovid;
    
    private RegistrarEscalaValoracionCaidasCEBean registrarEscalaValoracionCaidasBean;
    
    private boolean renderEscalaCaidas;
    
    
    private List<SelectItem>lstPatologia;

    
    public void init() {

        String tensionArterial = null;
        Integer frecuenciaCardiaca = null;
        Integer frecuenciaRespiratoria = null;
        BigDecimal peso = null;
        String hallazgos = null;
        BigDecimal temperatura = null;
        
        renderOrdenesMedicas = true;
        renderServiciosAdmision =false;
        
        boolean renderMasculino;
        renderMasculino = false;       

        renderVademecum = true;
        
        renderEscalaCaidas = false;
      
        // DATOS BASICOS USUARIO
        datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_CONTROL_DERMATOLOGIA);
        datosBasicosUsuario.setMenuBean("menuControlDermatologiaBean");
        renderCovid = datosBasicosUsuario.esValido();

        if (datosBasicosUsuario != null && 
            datosBasicosUsuario.getConsulta() != null && 
            datosBasicosUsuario.getConsulta().getCconnumero() != null) {
            numeroConsulta = 
                    new Long(datosBasicosUsuario.getConsulta().getCconnumero());
            if (datosBasicosUsuario.getConsulta().getCcocservic() != null) {
                codigoCups = 
                        datosBasicosUsuario.getConsulta().getCcocservic().getCsvccodigo();
            }
        }
        
        
        if (datosBasicosUsuario != null && 
            datosBasicosUsuario.getUsuario() != null && 
            datosBasicosUsuario.getUsuario().getHusesexo() != null) {
           
            if (datosBasicosUsuario.getUsuario().getHusesexo() != null && datosBasicosUsuario.getUsuario().getHusesexo().equals(SEXO_MASCULINO)) {
                renderMasculino = true; 
            }
        }
        
        // MOTIVO DE CONSULTA
        cuestionarioCovid = (CuestionarioCovidBean)FacesUtils.getManagedBean("cuestionarioCovidBean");
        cuestionarioCovid.setTipoServicio(TIPO_CONSULTA);
        cuestionarioCovid.setNumeroConsulta(numeroConsulta);
        if(datosBasicosUsuario != null && datosBasicosUsuario.getUsuario() != null && datosBasicosUsuario.getUsuario().getHuslnumero() != null ){
            cuestionarioCovid.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
        }
        cuestionarioCovid.setNextAction(BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_CONTROL_DERMATOLOGIA);
        cuestionarioCovid.setMenuBean("menuControlDermatologiaBean");
        cuestionarioCovid.inicializarCuestionario();
        renderEscalaCaidas= cuestionarioCovid.esValido();
        
        
        registrarEscalaValoracionCaidasBean = 
           (RegistrarEscalaValoracionCaidasCEBean)FacesUtils.getManagedBean("registrarEscalaValoracionCaidasCEBean");
           registrarEscalaValoracionCaidasBean.setNumeroConsulta(numeroConsulta);
        if (datosBasicosUsuario != null &&
           datosBasicosUsuario.getUsuario() != null && 
           datosBasicosUsuario.getUsuario().getHuslnumero() != null) {
               registrarEscalaValoracionCaidasBean.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
           }
           registrarEscalaValoracionCaidasBean.setMenuBean("menuControlDermatologiaBean");
           registrarEscalaValoracionCaidasBean.setNextAction(BeanNavegacion.RUTA_IR_CONTROL_USUARIO_DERMATOLOGIA);
           registrarEscalaValoracionCaidasBean.init();
          renderControlDermatologia = registrarEscalaValoracionCaidasBean.esValido();
        


        // Antecedentes
        
         if (!primeraConsulta) {
             antecedentes = 
                     (AntecedentesUsuarioBean)FacesUtils.getManagedBean("antecedentesUsuarioBean");
             antecedentes.setTipoServicio(TIPO_CONSULTA);
             antecedentes.setNumeroConsulta(numeroConsulta);
             antecedentes.setTipoHistoria(HISTORIA_CONTROL_DERMATOLOGIA);
             antecedentes.setUsuario(datosBasicosUsuario.getUsuario());
             antecedentes.setNextAction(BeanNavegacion.RUTA_IR_CONTROL_USUARIO_DERMATOLOGIA);
             antecedentes.setMenuBean("menuControlDermatologiaBean");
             antecedentes.inicializarAntecedentes();
         }

         if (primeraConsulta) {
             // ANTECEDENTES GENERALES
             antecedentesGenerales = 
                     (AntecedentesGeneralesUsuarioBean)FacesUtils.getManagedBean("antecedentesGeneralesUsuarioBean");
             antecedentesGenerales.setTipoServicio(TIPO_CONSULTA);
             antecedentesGenerales.setTipoHistoria(HISTORIA_CONTROL_DERMATOLOGIA);
             antecedentesGenerales.setNumeroConsulta(numeroConsulta);
             antecedentesGenerales.setNextAction(BeanNavegacion.RUTA_IR_CONTROL_USUARIO_DERMATOLOGIA);
             antecedentesGenerales.setMenuBean("menuControlDermatologiaBean");
             antecedentesGenerales.inicializarAntecedentes();

         }
         
        // EXAMEN FISICO
        examenFisicoUsuario = 
                (ExamenFisicoUsuarioBean)FacesUtils.getManagedBean("examenFisicoUsuarioBean");
        examenFisicoUsuario.setTipoServicio(TIPO_CONSULTA);
        examenFisicoUsuario.setNumeroConsulta(numeroConsulta);
        examenFisicoUsuario.setConsecutivo(new Integer("1"));
        examenFisicoUsuario.setNextAction(BeanNavegacion.RUTA_IR_CONTROL_USUARIO_DERMATOLOGIA);
        examenFisicoUsuario.setMenuBean("menuControlDermatologiaBean");
        examenFisicoUsuario.setConsecutivo(1);
        examenFisicoUsuario.setRenderMaculino(renderMasculino);  
        examenFisicoUsuario.setUsuario(datosBasicosUsuario.getUsuario());
        examenFisicoUsuario.setCampoopcional(true);
        examenFisicoUsuario.inicializarExamen();
      

        if (examenFisicoUsuario != null && 
            examenFisicoUsuario.getExamen() != null) {
            tensionArterial = 
                    examenFisicoUsuario.getExamen().getHefcpresart1() + "/" + 
                    examenFisicoUsuario.getExamen().getHefcpresart2();

            frecuenciaCardiaca = 
                    examenFisicoUsuario.getExamen().getHefnfreccard();

            frecuenciaRespiratoria = 
                    examenFisicoUsuario.getExamen().getHefnfrecresp();

            peso = examenFisicoUsuario.getExamen().getHefapeso();

            hallazgos = examenFisicoUsuario.getExamen().getHefthallazgo();

            temperatura = examenFisicoUsuario.getExamen().getHefatemperatu();
        }


        // CONTROL_DERMATOLOGIA
        control = 
                (ControlUsuarioBean)FacesUtils.getManagedBean("controlUsuarioBean");
        control.setUsuario(datosBasicosUsuario.getUsuario());
        control.setTipoServicio(TIPO_CONSULTA);
        control.setNumeroConsulta(numeroConsulta);
        control.setLstPatologias(getLstPatologia());
        control.setConsecutivo(new Integer("1"));
        control.setNextAction(BeanNavegacion.RUTA_IR_RECOMENDACIONES_CONTROL_DERMATOLOGIA);
        control.setMenuBean("menuControlDermatologiaBean");
        control.setCodigoDiagnostico("");
        control.setCodigoRelacionado1("");
        control.setCodigoRelacionado2("");
        control.setCodigoRelacionado3("");
        control.setDisableRel1(false);
        control.setRequiredRel2(false);
        
        control.inicializarControl();
        renderConducta = control.esValido();
        
        if (control != null && 
            control.getImpresion() != null && 
            control.getImpresion().getHidcdiagprin() != 
            null) {
            cie10Principal = 
                    control.getImpresion().getHidcdiagprin();
            cie10Relacionado1 = 
                    control.getImpresion().getHidcdiagrela1();
                    
               impresion =      control.getImpresion(); 
        }
        
        if(control != null && control.getMotivo() != null){
            motivo = control.getMotivo() ;
        }



      

        // CONDUCTA RECOMENDACIONES
        recomedacionUsuarioBean = 
                (RecomedacionUsuarioBean)FacesUtils.getManagedBean("recomedacionUsuarioBean");
        recomedacionUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        recomedacionUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        recomedacionUsuarioBean.setNumeroConsulta(numeroConsulta);
        recomedacionUsuarioBean.setMenuBean("menuControlDermatologiaBean");
        recomedacionUsuarioBean.inicializarRecomedaciones();
        renderCerrarConsulta = recomedacionUsuarioBean.esValido();


        // APLICACION - RETIRO DISPOSITIVOS
        dispositivos = 
                (AplicacionDispositivoBean)FacesUtils.getManagedBean("aplicacionDispositivoBean");
        dispositivos.setUsuario(datosBasicosUsuario.getUsuario());
        dispositivos.setTipoServicio(TIPO_CONSULTA);
        dispositivos.setNumeroConsulta(numeroConsulta);
        dispositivos.setMenuBean("menuControlDermatologiaBean");
        dispositivos.inicializarAplicacionDispositivo();


        // CONDUCTA - ANATOMIA PATOLOGICA
        anatomiaPatologicaUsuarioBean = 
                (AnatomiaPatologicaUsuarioBean)FacesUtils.getManagedBean("anatomiaPatolUsuarioBean");
        anatomiaPatologicaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        anatomiaPatologicaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        anatomiaPatologicaUsuarioBean.setNumeroConsulta(numeroConsulta);
        anatomiaPatologicaUsuarioBean.setConsecutivo(1);
        anatomiaPatologicaUsuarioBean.setMenuBean("menuControlDermatologiaBean");
        anatomiaPatologicaUsuarioBean.inicializarAnatomiaPatol();


        // CONDUCTA - CONTROL_DERMATOLOGIA SIN COSTO
        controlSinCostoUsuarioBean = 
                (ControlSinCostoUsuarioBean)FacesUtils.getManagedBean("controlSinCostoUsuarioBean");
        controlSinCostoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        controlSinCostoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        controlSinCostoUsuarioBean.setCodigoCups(codigoCups);
        controlSinCostoUsuarioBean.setNumeroConsulta(numeroConsulta);
        controlSinCostoUsuarioBean.setMenuBean("menuControlDermatologiaBean");
        controlSinCostoUsuarioBean.inicializarControlSinCosto();
        
        formulaLiquidosBean = 
                (FormulaLiquidosBean)FacesUtils.getManagedBean("formulaLiquidosBean");
        formulaLiquidosBean.setUsuario(datosBasicosUsuario.getUsuario());
        formulaLiquidosBean.setTipoServicio(TIPO_CONSULTA);
        formulaLiquidosBean.setNumeroCirugia(numeroConsulta);
        formulaLiquidosBean.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
        formulaLiquidosBean.setConsecutivo(1);
        formulaLiquidosBean.init();


        formulaHospitalizacionBean = 
                (FormulaHospitalizacionBean)FacesUtils.getManagedBean("formulaHospitalizacionBean");
        formulaHospitalizacionBean.setUsuario(datosBasicosUsuario.getUsuario());
        formulaHospitalizacionBean.setTipoServicio(TIPO_CONSULTA);
        formulaHospitalizacionBean.setNumeroCirugia(numeroConsulta);
        formulaHospitalizacionBean.setRenderProfilaxis(true);
        formulaHospitalizacionBean.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
        formulaHospitalizacionBean.setConsecutivo(1);
        formulaHospitalizacionBean.init();
        

                otrasOrdenesBean = 
                        (OtrasOrdenesBean)FacesUtils.getManagedBean("otrasOrdenesBean");

                //otrasOrdenesBean.setCirugia(evolucionMedico.getCirugia());
                otrasOrdenesBean.setConsecutivo(1);
                otrasOrdenesBean.setNumeroConsulta(numeroConsulta);
                otrasOrdenesBean.setTipoServicio(TIPO_HOSPITALIZACION);
                otrasOrdenesBean.init();
                
        

        // CONDUCTA - FORMULA MEDICA
        formulaMedicaUsuarioBean = 
                (FormulaMedicaUsuarioBean)FacesUtils.getManagedBean("formulaMedicaUsuarioBean");
        formulaMedicaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        formulaMedicaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        formulaMedicaUsuarioBean.setNumeroConsulta(numeroConsulta);
        formulaMedicaUsuarioBean.setCodigoCIE10(cie10Principal);
        formulaMedicaUsuarioBean.setConsecutivo(1);
        formulaMedicaUsuarioBean.setMenuBean("menuControlDermatologiaBean");
        formulaMedicaUsuarioBean.inicializardFormulaMedica();
        
        // CONDUCTA - FORMULA MEDICA
              vademecumUsuarioBean = (VademecumMedicoBean)FacesUtils.getManagedBean("vademecumMedicoBean");
              vademecumUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
              vademecumUsuarioBean.setTipoServicio(TIPO_CONSULTA);
              vademecumUsuarioBean.setNumeroConsulta(numeroConsulta);
              vademecumUsuarioBean.setCodigoCIE10(cie10Principal);
              vademecumUsuarioBean.setConsecutivo(1);
              vademecumUsuarioBean.setMenuBean("inicializardFormulaMedica");
              vademecumUsuarioBean.setRenderAlertaIve(false);
              vademecumUsuarioBean.inicializardFormulaMedica();


        // CONDUCTA - REMISION HOSPITALIZACION
        hospitalizacionUsuarioBean = 
                (HospitalizacionUsuarioBean)FacesUtils.getManagedBean("hospitalizacionUsuarioBean");
        hospitalizacionUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        hospitalizacionUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        hospitalizacionUsuarioBean.setNumeroConsulta(numeroConsulta);
        hospitalizacionUsuarioBean.setCiel0Principal(cie10Principal);
        hospitalizacionUsuarioBean.setConsecutivo(1);
        hospitalizacionUsuarioBean.setMenuBean("menuControlDermatologiaBean");
        hospitalizacionUsuarioBean.inicializarHospitalizacion();

        // CONDUCTA - Cirug�as y procedimientos
        ordenCirugiaUsuarioBean = 
                (OrdenCirugiaUsuarioBean)FacesUtils.getManagedBean("ordenCirugiaUsuarioBean");
        ordenCirugiaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        ordenCirugiaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        ordenCirugiaUsuarioBean.setNumeroConsulta(numeroConsulta);
        ordenCirugiaUsuarioBean.setConsecutivo(1);
        ordenCirugiaUsuarioBean.setMenuBean("menuControlDermatologiaBean");
        if (datosBasicosUsuario.getConsulta() != null) {
            Long tipoDocuentoAdmision = 
                datosBasicosUsuario.getConsulta().getCcontipdoc().getCtdnnumero().longValue();
            if (tipoDocuentoAdmision == IConstantes.TIPO_DOCUMENTO_ADMISION) {
                    ordenCirugiaUsuarioBean.setNumeroAdmision(datosBasicosUsuario.getConsulta().getCconnumdoc().longValue());
            }
        }
        ordenCirugiaUsuarioBean.inicializarOrdenCirugia();

        // CONDUCTA - INTER-CONSULTA
        interConsultaUsuarioBean = 
                (InterConsultaUsuarioBean)FacesUtils.getManagedBean("interConsultaUsuarioBean");
        interConsultaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        interConsultaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        interConsultaUsuarioBean.setNumeroConsulta(numeroConsulta);
        interConsultaUsuarioBean.setCie10Principal(cie10Principal);
        interConsultaUsuarioBean.setConsecutivo(1);
        interConsultaUsuarioBean.setMenuBean("menuControlDermatologiaBean");
        if (datosBasicosUsuario.getConsulta() != null) {
            Long tipoDocuentoAdmision = 
                datosBasicosUsuario.getConsulta().getCcontipdoc().getCtdnnumero().longValue();
            if (tipoDocuentoAdmision == IConstantes.TIPO_DOCUMENTO_ADMISION) {
                    interConsultaUsuarioBean.setNumeroAdmision(datosBasicosUsuario.getConsulta().getCconnumdoc().longValue());
            }
        }
        interConsultaUsuarioBean.inicializarInterConsulta();

        // CONDUCTA - INCAPACIDAD
        incapacidadUsuarioBean = 
                (IncapacidadUsuarioBean)FacesUtils.getManagedBean("incapacidadUsuarioBean");
        incapacidadUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        incapacidadUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        incapacidadUsuarioBean.setNumeroConsulta(numeroConsulta);
        incapacidadUsuarioBean.setCie10Principal(cie10Principal);
        incapacidadUsuarioBean.setCie10Relacionado1(cie10Relacionado1);
        incapacidadUsuarioBean.setCodigoCups(codigoCups);
        incapacidadUsuarioBean.setConsecutivo(1);
        incapacidadUsuarioBean.setMenuBean("menuControlDermatologiaBean");
        incapacidadUsuarioBean.inicializarIncapacidad();


        // CONDUCTA - REFERENCIA
        referenciaUsuarioBean = 
                (ReferenciaUsuarioBean)FacesUtils.getManagedBean("referenciaUsuarioBean");
        referenciaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        referenciaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        referenciaUsuarioBean.setNumeroConsulta(numeroConsulta);
        referenciaUsuarioBean.setConsultaAux(datosBasicosUsuario.getConsulta());
        referenciaUsuarioBean.setTensionArterial(tensionArterial);
        referenciaUsuarioBean.setFrecuenciaCardiaca(frecuenciaCardiaca);
        referenciaUsuarioBean.setFrecuenciaRespiratoria(frecuenciaRespiratoria);
        referenciaUsuarioBean.setPeso(peso);
        referenciaUsuarioBean.setHallazgos(hallazgos);
        referenciaUsuarioBean.setTemperatura(temperatura);
        referenciaUsuarioBean.setConsecutivo(1);
        referenciaUsuarioBean.setMenuBean("menuControlDermatologiaBean");
        referenciaUsuarioBean.inicializarReferencia();


        // CONDUCTA - SOLICITUD RESERVA DE SANGRE
        reservaSangreUsuarioBean = 
                (ReservaSangreUsuarioBean)FacesUtils.getManagedBean("reservaSangreUsuarioBean");
        reservaSangreUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        reservaSangreUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        reservaSangreUsuarioBean.setNumeroConsulta(numeroConsulta);
        reservaSangreUsuarioBean.setConsecutivo(1);
        reservaSangreUsuarioBean.setMenuBean("menuControlDermatologiaBean");
        reservaSangreUsuarioBean.inicializarReservaSangre();

        // CONDUCTA - CERTIFICADOS / CERTIFICADO MEDICO
        certMedicoUsuarioBean = 
                (CertMedicoUsuarioBean)FacesUtils.getManagedBean("certMedicoUsuarioBean");
        certMedicoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        certMedicoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        certMedicoUsuarioBean.setNumeroConsulta(numeroConsulta);
        certMedicoUsuarioBean.setMenuBean("menuControlDermatologiaBean");
        certMedicoUsuarioBean.setConsecutivo(1);
        certMedicoUsuarioBean.inicializarCertificadoMedico();
        certMedicoUsuarioBean.setEsCirugia(false);

        // CONDUCTA - CERTIFICADOS / CERTIFICADO DE ASISTENCIA
        certAsistenciaUsuarioBean = 
                (CertAsistenciaUsuarioBean)FacesUtils.getManagedBean("certAsistenciaUsuarioBean");
        certAsistenciaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        certAsistenciaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        certAsistenciaUsuarioBean.setNumeroConsulta(numeroConsulta);
        certAsistenciaUsuarioBean.setCodigoCups(codigoCups);
        certAsistenciaUsuarioBean.setConsecutivo(1);
        certAsistenciaUsuarioBean.setMenuBean("menuControlDermatologiaBean");
        certAsistenciaUsuarioBean.inicializarCertificadoAsistencia();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN ELECTROFISIOLOGICO
        examElectrofisiologicoUsuarioBean = 
                (ExamElectrofisiologicoUsuarioBean)FacesUtils.getManagedBean("examElectrofisioUsuarioBean");
        examElectrofisiologicoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        examElectrofisiologicoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        examElectrofisiologicoUsuarioBean.setNumeroConsulta(numeroConsulta);
        examElectrofisiologicoUsuarioBean.setCie10Principal(cie10Principal);
        examElectrofisiologicoUsuarioBean.setConsecutivo(1);
        examElectrofisiologicoUsuarioBean.setMenuBean("menuControlDermatologiaBean");
        examElectrofisiologicoUsuarioBean.inicializarExamElectrofisiologico();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN IMAGEN
        examImagenUsuarioBean = 
                (ExamImagenUsuarioBean)FacesUtils.getManagedBean("examImagenUsuarioBean");
        examImagenUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        examImagenUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        examImagenUsuarioBean.setNumeroConsulta(numeroConsulta);
        examImagenUsuarioBean.setConsecutivo(1);
        examImagenUsuarioBean.setCie10Principal(cie10Principal);
        examImagenUsuarioBean.setMenuBean("menuControlDermatologiaBean");
        examImagenUsuarioBean.inicializarExamImagen();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN LABORATORIO
        examLaboratorioUsuarioBean = 
                (ExamLaboratorioUsuarioBean)FacesUtils.getManagedBean("examLaboratorioUsuarioBean");
        examLaboratorioUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        examLaboratorioUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        examLaboratorioUsuarioBean.setNumeroConsulta(numeroConsulta);
        examLaboratorioUsuarioBean.setConsecutivo(1);
        examLaboratorioUsuarioBean.setCie10Principal(cie10Principal);
        examLaboratorioUsuarioBean.setMenuBean("menuControlDermatologiaBean");
        if (datosBasicosUsuario.getConsulta() != null) {
            Long tipoDocuentoAdmision = 
                datosBasicosUsuario.getConsulta().getCcontipdoc().getCtdnnumero().longValue();
            if (tipoDocuentoAdmision == IConstantes.TIPO_DOCUMENTO_ADMISION) {
                    examLaboratorioUsuarioBean.setNumeroAdmision(datosBasicosUsuario.getConsulta().getCconnumdoc().longValue());
            }
        }
        examLaboratorioUsuarioBean.inicializarExamLaboratorio();

        // CERRAR CONSULTA
        cerrarConsultaUsuarioBean = 
                (CerrarConsultaUsuarioBean)FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
        cerrarConsultaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        cerrarConsultaUsuarioBean.setMenuBean("menuControlDermatologiaBean");
        cerrarConsultaUsuarioBean.setConsulta(datosBasicosUsuario.getConsulta());
        cerrarConsultaUsuarioBean.setEsVacunacion(false); 
        cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
        
        
        // CONDUCTA - AUTORIZACION DE SERVICIOS
        
         autorizacionServicioUsuarioBean =
                 (AutorizacionServicioUsuarioBean)FacesUtils.getManagedBean("autorizacionServicioUsuarioBean");
         autorizacionServicioUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
         
         autorizacionServicioUsuarioBean.setTipoServicio("C");
         autorizacionServicioUsuarioBean.setNumeroConsulta(numeroConsulta);
        // autorizacionServicioUsuarioBean.setTipoHistoria(motivoConsulta.getTipoHistoria());
        if(motivo != null && motivo.getHmcncausaexte() != null)
         autorizacionServicioUsuarioBean.setOrigenAtencion(motivo.getHmcncausaexte().toString());  
         autorizacionServicioUsuarioBean.setCodigoCups(codigoCups);
         if(impresion != null){
             autorizacionServicioUsuarioBean.setTipoDiagnostico(impresion.getHidntipodiagn());
             autorizacionServicioUsuarioBean.setCodigoDiagnostico(impresion.getHidcdiagprin());
             autorizacionServicioUsuarioBean.setCodigoDiagnostico1(impresion.getHidcdiagrela2());
             autorizacionServicioUsuarioBean.setCodigoDiagnostico2(impresion.getHidcdiagrela3());
                  
         }
         autorizacionServicioUsuarioBean.setMenuBean("menuControlDermatologiaBean");
         autorizacionServicioUsuarioBean.inicializarAutorizacionServicio();


        //RESUMEN DE LA HISTORIA CLINICA

        resumenEspecifico = 
                (ResumenHistoriaEspecificaBean)FacesUtils.getManagedBean("resumenHistoriaEspecificaBean");
        resumenEspecifico.setUsuario(datosBasicosUsuario.getUsuario());
        
        renderPausarConsulta=false;
        if(IConstantes.ACTIVAR_PAUSAR_CONSULTA) {
            renderPausarConsulta = datosBasicosUsuario.esValido();
        }
        
        if(IConstantes.ACTIVAR_PAUSAR_CONSULTA) {
           tiempoAtencion =datosBasicosUsuario.esValido();
           if (tiempoAtencion) {
               
               try {
                   List<Chtiempaten> chtiempatenList = new ArrayList<Chtiempaten>();
                   chtiempatenList = 
                           getServiceLocator().getClinicoService().consultarTiempoAtencionVigentesXconsulta(numeroConsulta);
                   if (chtiempatenList.isEmpty()) {
                       Chtiempaten chtiempatenAux = new Chtiempaten();
                       chtiempatenAux.setCtanconsulta(numeroConsulta);
                       chtiempatenAux.setCtacetapa("AB");
                       chtiempatenAux.setCtacestado("VG");
                       chtiempatenAux.setCtadhora(new Date());
                       chtiempatenAux.setCtadfechregi(new Date());
                       chtiempatenAux.setCtancausa(0);
                       chtiempatenAux.setCtacusuareg(getUsuarioSystem().getCurcusuari());
                       chtiempatenAux.setCtancodmed(Integer.parseInt(getUsuarioSystem().getCurnprofes().toString()));
                       this.getServiceLocator().getClinicoService().saveRegistroTiempoAtencion(chtiempatenAux);
                   }
               } catch (ModelException e) {
                   e.printStackTrace();
               }
           }
        }

        // PAUSAR CONSULTA
         if(IConstantes.ACTIVAR_PAUSAR_CONSULTA){
             if(renderPausarConsulta){
             pausarConsulta = 
                     (PausarConsultaBean)FacesUtils.getManagedBean("pausarConsultaBean");
                  pausarConsulta.setNumeroConsulta(numeroConsulta);
                  if(numeroConsulta != null){
                      pausarConsulta.init();
                      pausarConsulta.getCausasPausarConsultas();
                  }
              }
         }
                // SERVICIOS ADMISION
        if (IConstantes.ACTIVAR_SERVICIOS_ADMISION) {
            if (datosBasicosUsuario.getConsulta() != null) {
                Long tipoDocuentoAdmision = 
                    datosBasicosUsuario.getConsulta().getCcontipdoc().getCtdnnumero().longValue();
                if (tipoDocuentoAdmision == 
                    IConstantes.TIPO_DOCUMENTO_ADMISION) {
                    renderServiciosAdmision = datosBasicosUsuario.esValido();
                    if (renderServiciosAdmision) {
                        confirmarServiciosAdmision = 
                                (ConfirmarServiciosAdmisionBean)FacesUtils.getManagedBean("confirmarServiciosAdmisionBean");
                        confirmarServiciosAdmision.setNumeroAdmision(datosBasicosUsuario.getConsulta().getCconnumdoc().longValue());
                        if (confirmarServiciosAdmision.getNumeroAdmision() != 
                            null) {
                            confirmarServiciosAdmision.init();
                            confirmarServiciosAdmision.setConsulta(datosBasicosUsuario.getConsulta());
                            confirmarServiciosAdmision.setUsuario(datosBasicosUsuario.getUsuario());
                            confirmarServiciosAdmision.consultarServiciosAdmision();
                            List<Cfdetafactura> cfdetafacturaList = 
                                confirmarServiciosAdmision.getCfdetafacturaList();
                            if (cfdetafacturaList == null || 
                                cfdetafacturaList.isEmpty()) {
                                renderServiciosAdmision = false;
                            }
                        }
                    }
                }
            }
        }


    }
    
    public String irPausarConsultaControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_PAUSAR_CONSULTA_CONTROL_DERMATOLOGIA;
    }
    
    public String irCuestionarioCovidControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_CONTROL_DERMATOLOGIA;
        }


    /**
     * @return
     */
    public String irDatosControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_DATOS_CONTROL_DERMATOLOGIA;
    }


    /**
     * @return
     */
    public String irMotivoControlDermatologia() {
        inicializarUsuario();

        return BeanNavegacion.RUTA_IR_MOTIVO_CONTROL_DERMATOLOGIA;
    }
    
    
  
    /**
     * @return
     */
    public String irAntecedentesGeneralesControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_GENERALES_CONTROL_DERMATOLOGIA; 
    }


    /**
     * @return
     */
    public String irAntecedentesControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_CONTROL_DERMATOLOGIA;
    }



    /**
     * @return
     */
    public String irExamenFisicoControlDermatologia() {

        inicializarUsuario();

        return BeanNavegacion.RUTA_IR_EXAMEN_FISICO_CONTROL_DERMATOLOGIA;
    }

    /**
     * @return
     */
    public String irImpDiagnosticaControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_CONTROL_DERMATOLOGIA;
    }


    public String irControlDermatologiaUsuario() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CONTROL_USUARIO_DERMATOLOGIA;
    }


    /**
     * @return
     */
    public String irAnatPatologicaControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANATOMIAPATOLOGICA_CONTROL_DERMATOLOGIA;
    }

    /**
     * @return
     */
    public String irAplicacionRetiro() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_APLICACION_RETITO_CONTROL_DERMATOLOGIA;
    }

    /**
     * @return
     */
    public String irControlDermatologiaSinCostoControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CONTOL_SIN_COSTO_CONTROL_DERMATOLOGIA;
    }


    /**
     * @return
     */
    public String irFormulaMedicaControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FORMULAMEDICA_CONTROL_DERMATOLOGIA;
    }
    

        /**
         * @return
         */
        public String irVademecumMedicoControlDermatologia() {
            inicializarUsuario();
            return BeanNavegacion.RUTA_IR_VADEMCUM_CONTROL_DERMATOLOGIA;
        }

    /**
     * @return
     */
    public String irRemHospitalizacionControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_HOSPITALZACION_CONTROL_DERMATOLOGIA;
    }
    
    /**
     * @return
     */
     public String irAutorizacionServicioControlDermatologia(){
         inicializarUsuario();
         return BeanNavegacion.RUTA_IR_AUTORIZACION_SERVICIOS_CONTROL_DERMATOLOGIA;
     }


    /**
     * @return
     */
    public String irIncapacidadControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INCAPACIDAD_CONTROL_DERMATOLOGIA;
    }


    /**
     * @return
     */
    public String irInterConsultaControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INTERCONSULTA_CONTROL_DERMATOLOGIA;
    }


    /**
     * @return
     */
    public String irOrdenCirugiaControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ORDENCIRUGIA_CONTROL_DERMATOLOGIA;
    }


    /**
     * @return
     */
    public String irReferenciaControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_REFERENCIA_CONTROL_DERMATOLOGIA;
    }

    /**
     * @return
     */
    public String irReservaSangreControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESERVA_SANGRE_CONTROL_DERMATOLOGIA;
    }


    /**
     * @return
     */
    public String irRecomedacionControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RECOMENDACIONES_CONTROL_DERMATOLOGIA;
    }


    /**
     * @return
     */
    public String irCertMedicoControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADOMEDICO_CONTROL_DERMATOLOGIA;
    }

    /**
     * @return
     */
    public String irCertAsistenciaControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADO_ASISTENCIA_CONTROL_DERMATOLOGIA;
    }

    /**
     * @return
     */
    public String irExamElectrofisiologicoControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ELECTROFISIOLOGICO_CONTROL_DERMATOLOGIA;
    }

    /**
     * @return
     */
    public String irExamImagenControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMAGENES_CONTROL_DERMATOLOGIA;
    }

    /**
     * @return
     */
    public String irExamLaboratorioControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_LABORATORIO_CONTROL_DERMATOLOGIA;
    }


    public String irCerrarConsultaControlDermatologia() {
        if (cerrarConsultaUsuarioBean != null) {
            cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
        }
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERRAR_CONTROL_DERMATOLOGIA;
    }

    /**
     * @return
     */
    public String irResumenHistoriaEspecificaControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_CONTROL_DERMATOLOGIA;
    }


    /**
     * @return
     */
    public String irResumenHistoriaControlDermatologia() {
        inicializarUsuario();

        FacesUtils.resetManagedBean("consultarFoliosBean");

        ConsultarFoliosBean generarResumen = 
            (ConsultarFoliosBean)FacesUtils.getManagedBean("consultarFoliosBean");
        if (generarResumen != null) {
            generarResumen.init();
            generarResumen.setEncabezado(true);
            generarResumen.setUsuario(datosBasicosUsuario.getUsuario());
            generarResumen.consultarFoliosUsuario();

        }
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_CONTROL_DERMATOLOGIA;
    }


    public void inicializarUsuario() {

        if (datosBasicosUsuario.getUsuario() != null)
            this.setUsuario(datosBasicosUsuario.getUsuario());
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
     * @param renderConducta
     */
    public void setRenderConducta(boolean renderConducta) {
        this.renderConducta = renderConducta;
    }

    /**
     * @return
     */
    public boolean isRenderConducta() {
        return renderConducta;
    }



    /**
     * @param renderCerrarConsulta
     */
    public void setRenderCerrarConsulta(boolean renderCerrarConsulta) {
        this.renderCerrarConsulta = renderCerrarConsulta;
    }

    /**
     * @return
     */
    public boolean isRenderCerrarConsulta() {
        return renderCerrarConsulta;
    }


    /**
     * @param renderControlDermatologia
     */
    public void setRenderControlDermatologia(boolean renderControlDermatologia) {
        this.renderControlDermatologia = renderControlDermatologia;
    }
    
    /**
     * @param primeraConsulta
     */
    public void setPrimeraConsulta(boolean primeraConsulta) {
        this.primeraConsulta = primeraConsulta;
    }

    /**
     * @return
     */
    public boolean isPrimeraConsulta() {
        return primeraConsulta;
    }

    /**
     * @return
     */
    public boolean isRenderControlDermatologia() {
        return renderControlDermatologia;
    }

    /**
     * @param trnhistoria
     */
    public void setTrnhistoria(ExpandableTreeModel trnhistoria) {
        this.trnhistoria = trnhistoria;
    }

    /**
     * @return
     */
    public ExpandableTreeModel getTrnhistoria() {
        TreeNode treeData = new TreeNodeBase("raiz", "Conducta", false);

        TreeNodeBase itemNode1 = 
            new TreeNodeBase("itemNode1", "Anatomia Patologica", false);
        TreeNodeBase itemNode2 = 
            new TreeNodeBase("itemNode2", "ControlDermatologia", false);
        TreeNodeBase itemNode3 = 
            new TreeNodeBase("itemNode3", "Formula Medica", false);
        TreeNodeBase itemNode4 = 
            new TreeNodeBase("itemNode4", "Remisi�n Hospitalizaci�n", false);
        TreeNodeBase itemNode5 = 
            new TreeNodeBase("itemNode5", "Incapacidad", false);
        TreeNodeBase itemNode6 = 
            new TreeNodeBase("itemNode6", "Inter Consulta", false);
        TreeNodeBase itemNode7 = 
            new TreeNodeBase("itemNode7", "Cirug�as y procedimientos", false);
        TreeNodeBase itemNode8 = 
            new TreeNodeBase("itemNode8", "Recomendaciones", false);
        TreeNodeBase itemNode9 = 
            new TreeNodeBase("itemNode9", "Referencia", false);
        TreeNodeBase itemNode10 = 
            new TreeNodeBase("itemNode10", "Reserva de Sangre", false);

        TreeNodeBase itemNode11 = 
            new TreeNodeBase("raiz", "Certificados", false);
        itemNode11.getChildren().add(new TreeNodeBase("itemNode11_1", "Medico", 
                                                      true));
        itemNode11.getChildren().add(new TreeNodeBase("itemNode11_2", 
                                                      "De Asistencia", true));

        TreeNodeBase itemNode12 = 
            new TreeNodeBase("raiz", "Ex�menes Clinicos", false);
        itemNode12.getChildren().add(new TreeNodeBase("itemNode12_1", 
                                                      "ElectroFisiologicos", 
                                                      true));
        itemNode12.getChildren().add(new TreeNodeBase("itemNode12_2", "Imagen", 
                                                      true));
        itemNode12.getChildren().add(new TreeNodeBase("itemNode12_3", 
                                                      "Laboratorio", true));


        treeData.getChildren().add(itemNode1);
        treeData.getChildren().add(itemNode2);
        treeData.getChildren().add(itemNode3);
        treeData.getChildren().add(itemNode4);
        treeData.getChildren().add(itemNode5);
        treeData.getChildren().add(itemNode6);
        treeData.getChildren().add(itemNode7);
        treeData.getChildren().add(itemNode8);
        treeData.getChildren().add(itemNode9);
        treeData.getChildren().add(itemNode10);
        treeData.getChildren().add(itemNode11);
        treeData.getChildren().add(itemNode12);

        ExpandableTreeModel treeDataExtended = 
            new ExpandableTreeModel(treeData);

        treeDataExtended.setExpanded(treeData, true);
        treeDataExtended.setExpanded(itemNode11, true);
        treeDataExtended.setExpanded(itemNode12, true);

        return treeDataExtended;
    }
    
    public void openPopupClicked(ActionEvent event) {
        javaScriptText = "";
        Long numeroUsuario = null;
        String encodedText = "";
        String cod = "";
        
        numeroUsuario = datosBasicosUsuario.getUsuario().getHusanumeiden();
        
        if(numeroUsuario != null){
            cod = "[N_MERO_ID_] = " + numeroUsuario.toString(); 
        }
        
        String urlString = "/apolo:80/DocuWare/"; 
        
        String encodedAuten;

        // Base64
        System.out.println("Numero Usuario String "+numeroUsuario.toString());
        encodedText = new String(Base64.encodeBase64(cod.getBytes()));
        // encodedAuten = new String(Base64.encodeBase64(autenticacion.getBytes()));
        
        
         urlString = urlString + encodedText ; 
         System.out.println(urlString);
        
        FacesContext facesContext = FacesContext.getCurrentInstance();

        // This is the proper way to get the view's url
        ViewHandler viewHandler = facesContext.getApplication().getViewHandler();
        String actionUrl = urlString;
            
        
        javaScriptText = "window.open('http://wgesdoc/DocuWare/Platform/WebClient/1/Integration?p=RLV&fc=0ee1c783-c5e9-4232-b6cc-b651dd62bd02&q=" + encodedText + "' );";
        
        // Add the Javascript to the rendered page's header for immediate execution
        AddResource addResource = AddResourceFactory.getInstance(facesContext);
        
        addResource.addInlineScriptAtPosition(null, AddResource.HEADER_BEGIN, javaScriptText); 
     
    }


    public void setVademecumUsuarioBean(VademecumMedicoBean vademecumUsuarioBean) {
        this.vademecumUsuarioBean = vademecumUsuarioBean;
    }

    public VademecumMedicoBean getVademecumUsuarioBean() {
        return vademecumUsuarioBean;
    }

    public void setRenderVademecum(boolean renderVademecum) {
        this.renderVademecum = renderVademecum;
    }

    public boolean isRenderVademecum() {
        return renderVademecum;
    }


    public void setRenderOrdenesMedicas(boolean renderOrdenesMedicas) {
        this.renderOrdenesMedicas = renderOrdenesMedicas;
    }

    public boolean isRenderOrdenesMedicas() {
        return renderOrdenesMedicas;
    }

    public void setRenderPausarConsulta(boolean renderPausarConsulta) {
        this.renderPausarConsulta = renderPausarConsulta;
    }

    public boolean isRenderPausarConsulta() {
        return renderPausarConsulta;
    }

    public void setPausarConsulta(PausarConsultaBean pausarConsulta) {
        this.pausarConsulta = pausarConsulta;
    }

    public PausarConsultaBean getPausarConsulta() {
        return pausarConsulta;
    }
	
	public String irServiciosAdmisionControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_SERVICIOS_ADMISION_CONTROL_DERMATOLOGIA;
    }

    public void setRenderServiciosAdmision(boolean renderServiciosAdmision) {
        this.renderServiciosAdmision = renderServiciosAdmision;
    }

    public boolean isRenderServiciosAdmision() {
        return renderServiciosAdmision;
    }
    public String irOrdenLiquidosControlDermatologia() {
        return BeanNavegacion.RUTA_IR_ORDEN_LIQUIDOS_CONTROL_DERMATOLOGIA;
    }
    
    public String irRegistrarOtrasOrdenesControlDermatologia() {
        return BeanNavegacion.RUTA_IR_OTRAS_ORDENES_CONTROL_DERMATOLOGIA;
    }
    
    public String irOrdenMedicamentosControlDermatologia() {
        return BeanNavegacion.RUTA_IR_ORDEN_MEDICAMENTOS_CONTROL_DERMATOLOGIA;
    }

    public void setRenderCovid(boolean renderCovid) {
        this.renderCovid = renderCovid;
    }

    public boolean isRenderCovid() {
        return renderCovid;
    }
    public String irRegistrarOtrasOrdenesControlDermatologiaAneste() {
        return BeanNavegacion.RUTA_IR_OTRAS_ORDENES_CONTROL_DERMATOLOGIA_ANESTE;
    }
    
    /**
     * @return
     */
    public String irEscalaValoracionCaidasControlDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_CONTROL_DERMATOLOGIA;
    }

    public void setRenderEscalaCaidas(boolean renderEscalaCaidas) {
        this.renderEscalaCaidas = renderEscalaCaidas;
    }

    public boolean isRenderEscalaCaidas() {
        return renderEscalaCaidas;
    }
    
    public void setLstPatologia(List<SelectItem> lstPatologia) {
        this.lstPatologia = lstPatologia;
    }

    public List<SelectItem> getLstPatologia() {
    if(lstPatologia == null || lstPatologia.isEmpty()){
        lstPatologia = new ArrayList<SelectItem>();
            lstPatologia.add(new SelectItem("","Seleccione una opci�n ..."));
            lstPatologia.add(new SelectItem("PI","Piel"));
            lstPatologia.add(new SelectItem("GN","Ganglio"));
            lstPatologia.add(new SelectItem("TI","Tiroides"));
            lstPatologia.add(new SelectItem("OT","Otro"));
    }
        return lstPatologia;
    }



  
  
  
}
