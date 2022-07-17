package org.profamilia.hc.view.backing.menus.consultorio;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.ViewHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.commons.codec.binary.Base64;
import org.apache.myfaces.custom.tree2.TreeNode;
import org.apache.myfaces.custom.tree2.TreeNodeBase;

import org.apache.myfaces.renderkit.html.util.AddResource;
import org.apache.myfaces.renderkit.html.util.AddResourceFactory;

import org.profamilia.hc.model.dto.Cfdetafactura;
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
import org.profamilia.hc.view.backing.comun.ControlUsuarioIlveBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.ExamenFisicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.ImpresionDiagnosticaControlIlveBean;
import org.profamilia.hc.view.backing.comun.ImpresionDiagnosticaIlveBean;
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
import org.profamilia.hc.view.backing.comun.conducta.VademecumMedicoBean;
import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;
import org.profamilia.hc.view.backing.comun.IdentificacionRiegosBean;
import org.profamilia.hc.view.backing.comun.RegistrarEscalaValoracionCaidasCEBean;
import org.profamilia.hc.view.backing.comun.RemisionIlveBean;


public class MenuControlIlveBean extends BaseBean {

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
    
    private AutorizacionServicioUsuarioBean autorizacionServicioUsuarioBean;

    private ReservaSangreUsuarioBean reservaSangreUsuarioBean;

    private CertMedicoUsuarioBean certMedicoUsuarioBean;

    private CertAsistenciaUsuarioBean certAsistenciaUsuarioBean;

    private ExamElectrofisiologicoUsuarioBean examElectrofisiologicoUsuarioBean;

    private ExamImagenUsuarioBean examImagenUsuarioBean;

    private ExamLaboratorioUsuarioBean examLaboratorioUsuarioBean;

    private ControlUsuarioIlveBean control;

    private CerrarConsultaUsuarioBean cerrarConsultaUsuarioBean;

    private ResumenHistoriaEspecificaBean resumenEspecifico;

    private AplicacionDispositivoBean dispositivos;
    
    private AntecedentesGeneralesUsuarioBean antecedentesGenerales;

    private AntecedentesUsuarioBean antecedentes;
    
    private ImpresionDiagnosticaControlIlveBean impresionDiagnosticaControlIlveBean; 
    
    private VademecumMedicoBean vademecumUsuarioBean;

    private boolean renderVademecum;
    
    
    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private boolean renderConducta;

    private boolean renderCerrarConsulta;

    private boolean renderControl;
    
    private boolean renderImpresion;
    
    private boolean renderExamenFisico;

    private ExpandableTreeModel trnhistoria;

    private Long numeroConsulta;

    private String cie10Principal;

    private String cie10Relacionado1;

    private String codigoCups;
    
    private boolean primeraConsulta;
    
    private boolean renderAntecedentes;
    
    private String javaScriptText;

    private boolean renderPausarConsulta;
    private PausarConsultaBean pausarConsulta;
    private boolean tiempoAtencion;
    
    private ConfirmarServiciosAdmisionBean confirmarServiciosAdmision;
                
    private boolean renderServiciosAdmision;
    
    private CuestionarioCovidBean cuestionarioCovid;
    
    private boolean renderCovid;
    
    private RegistrarEscalaValoracionCaidasCEBean registrarEscalaValoracionCaidasBean;
    
    private boolean renderEscalaCaidas;
    
    private RemisionIlveBean remIlveBean;
    
    private IdentificacionRiegosBean identificacionRiesgos;
    
    private double numeroSemanasEcografia;
    

    public void init() {

        String tensionArterial = null;
        Integer frecuenciaCardiaca = null;
        Integer frecuenciaRespiratoria = null;
        BigDecimal peso = null;
        String hallazgos = null;
        BigDecimal temperatura = null;
        renderServiciosAdmision =false;
        double numeroDiasEcografia = 0;
        numeroSemanasEcografia = 0;
        
        boolean renderMasculino; 
         renderMasculino = false;    
         renderVademecum = true; 
         renderEscalaCaidas= false;
          


        // DATOS BASICOS USUARIO
        datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
            datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_CONTROL_ILVE);
        datosBasicosUsuario.setMenuBean("menuControlIlveBean");
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
        cuestionarioCovid.setNextAction(BeanNavegacion.RUTA_IR_CONTROL_USUARIO_ILVE);
        cuestionarioCovid.setMenuBean("menuControlIlveBean");
        cuestionarioCovid.inicializarCuestionario();
        renderControl= cuestionarioCovid.esValido();


        // Antecedentes
        
         if (!primeraConsulta) {
             antecedentes = 
                     (AntecedentesUsuarioBean)FacesUtils.getManagedBean("antecedentesUsuarioBean");
             antecedentes.setTipoServicio(TIPO_CONSULTA);
             antecedentes.setNumeroConsulta(numeroConsulta);
             antecedentes.setTipoHistoria(HISTORIA_CONTROL_INTERRUPCION);
             antecedentes.setUsuario(datosBasicosUsuario.getUsuario());
             antecedentes.setNextAction(BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_CONTROL_IVE);
             antecedentes.setMenuBean("menuControlIlveBean");
             antecedentes.inicializarAntecedentes();
             renderEscalaCaidas = antecedentes.esValido();
           
             
         }

         if (primeraConsulta) {
             // ANTECEDENTES GENERALES
             antecedentesGenerales = 
                     (AntecedentesGeneralesUsuarioBean)FacesUtils.getManagedBean("antecedentesGeneralesUsuarioBean");
             antecedentesGenerales.setTipoServicio(TIPO_CONSULTA);
             antecedentesGenerales.setTipoHistoria(HISTORIA_CONTROL_INTERRUPCION);
             antecedentesGenerales.setNumeroConsulta(numeroConsulta);
             antecedentesGenerales.setNextAction(BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_CONTROL_IVE);
             antecedentesGenerales.setMenuBean("menuControlIlveBean");
             antecedentesGenerales.inicializarAntecedentes();
             renderEscalaCaidas = antecedentesGenerales.esValido();

         }
         
        registrarEscalaValoracionCaidasBean = 
           (RegistrarEscalaValoracionCaidasCEBean)FacesUtils.getManagedBean("registrarEscalaValoracionCaidasCEBean");
           registrarEscalaValoracionCaidasBean.setNumeroConsulta(numeroConsulta);
        if (datosBasicosUsuario != null &&
           datosBasicosUsuario.getUsuario() != null && 
           datosBasicosUsuario.getUsuario().getHuslnumero() != null) {
               registrarEscalaValoracionCaidasBean.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
           }
           registrarEscalaValoracionCaidasBean.setMenuBean("menuControlIlveBean");
           registrarEscalaValoracionCaidasBean.setNextAction(BeanNavegacion.RUTA_IR_EXAMEN_FISICO_CONTROL_ILVE);
           registrarEscalaValoracionCaidasBean.init();
           renderExamenFisico = registrarEscalaValoracionCaidasBean.esValido();

        // EXAMEN FISICO
        examenFisicoUsuario = 
                (ExamenFisicoUsuarioBean)FacesUtils.getManagedBean("examenFisicoUsuarioBean");
        examenFisicoUsuario.setTipoServicio(TIPO_CONSULTA);
        examenFisicoUsuario.setNumeroConsulta(numeroConsulta);
        examenFisicoUsuario.setConsecutivo(new Integer("1"));
        examenFisicoUsuario.setNextAction(BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_CONTROL_ILVE);
        examenFisicoUsuario.setMenuBean("menuControlIlveBean");
        examenFisicoUsuario.setConsecutivo(1);
        examenFisicoUsuario.setRenderMaculino(renderMasculino);  
        examenFisicoUsuario.setUsuario(datosBasicosUsuario.getUsuario());
        examenFisicoUsuario.setTipoHistoria(IConstantes.HISTORIA_CONTROL_INTERRUPCION);
        examenFisicoUsuario.setCampoopcional(true);
        examenFisicoUsuario.inicializarExamen();
        renderImpresion = examenFisicoUsuario.esValido();
      
        
        
        
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

        // IMPRESION DIAGNOSTICA
        impresionDiagnosticaControlIlveBean = 
                ( ImpresionDiagnosticaControlIlveBean)FacesUtils.getManagedBean("impresionDiagnosticaControlIlveBean");
        impresionDiagnosticaControlIlveBean.setUsuario(datosBasicosUsuario.getUsuario());
        impresionDiagnosticaControlIlveBean.setTipoServicio(TIPO_CONSULTA);
        impresionDiagnosticaControlIlveBean.setNumeroConsulta(numeroConsulta);
        impresionDiagnosticaControlIlveBean.setConsecutivo(new Integer("1"));
        impresionDiagnosticaControlIlveBean.setNextAction(BeanNavegacion.RUTA_IR_RECOMENDACIONES_CONTROL_ILVE);
        impresionDiagnosticaControlIlveBean.setCodigoDiagnostico(IConstantes.CODIGO_PRINCIPAL_ABORTO_MEDICO);
        impresionDiagnosticaControlIlveBean.setCodigoRelacionado1(IConstantes.CODIGO_REL1_EXTRACCION_MENSUAL);
        impresionDiagnosticaControlIlveBean.setCodigoRelacionado2(IConstantes.CODIGO_REL2_ASESORAMIENTO_GENERAL_ANTICONCEPCION);
        impresionDiagnosticaControlIlveBean.setCodigoRelacionado3("");
        impresionDiagnosticaControlIlveBean.setDisableRel1(true);
        impresionDiagnosticaControlIlveBean.setRequiredRel2(true);
        impresionDiagnosticaControlIlveBean.setMenuBean("menuControlIlveBean");      
        impresionDiagnosticaControlIlveBean.inicializarImpresion();
        renderConducta = impresionDiagnosticaControlIlveBean.esValido();
        
        if (impresionDiagnosticaControlIlveBean != null && 
            impresionDiagnosticaControlIlveBean.getImpresion() != null && 
            impresionDiagnosticaControlIlveBean.getImpresion().getHidnsemanembar() != 
            null) {
            numeroSemanasEcografia = 
                    impresionDiagnosticaControlIlveBean.getImpresion().getHidnsemanembar();
            numeroDiasEcografia = numeroSemanasEcografia * 7;
        }
      
        identificacionRiesgos = 
                (IdentificacionRiegosBean)FacesUtils.getManagedBean("identificacionRiesgoBean");
        identificacionRiesgos.setNumeroConsulta(numeroConsulta);
        identificacionRiesgos.setUsuario(datosBasicosUsuario.getUsuario());
        identificacionRiesgos.setNextAction(BeanNavegacion.RUTA_IR_CERTIFICADO_CONTROL_ILVE);
        identificacionRiesgos.setMenuBean("menuControlIlveBean");
        identificacionRiesgos.iniciarIdentificacionBean();
        identificacionRiesgos.setRenderPreguntasIVE(true);

        remIlveBean = 
                (RemisionIlveBean)FacesUtils.getManagedBean("remisionIlveBean");
        remIlveBean.setUsuario(datosBasicosUsuario.getUsuario());
        remIlveBean.setTipoServicio("C");
        remIlveBean.setNumeroSemanasEmbarazo(numeroSemanasEcografia);
        remIlveBean.setNumeroDiasEmbarazo(numeroDiasEcografia);
        remIlveBean.setNumeroConsulta(numeroConsulta);


        remIlveBean.setNextAction(BeanNavegacion.RUTA_ACTUAL);
        remIlveBean.setNextAction2(BeanNavegacion.RUTA_ACTUAL);
        remIlveBean.setMenuBean("menuControlIlveBean");
        remIlveBean.inicializarRemision();

        // CONTROL
        control = 
                (ControlUsuarioIlveBean)FacesUtils.getManagedBean("controlUsuarioIlveBean");
        control.setUsuario(datosBasicosUsuario.getUsuario());
        control.setTipoServicio(TIPO_CONSULTA);
        control.setNumeroConsulta(numeroConsulta);
        control.setConsecutivo(new Integer("1"));
        if(!primeraConsulta){
            control.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_CONTROL_ILVE);   
        }else if(primeraConsulta){
            control.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_GENERALES_CONTROL_ILVE);   
        }
        control.setCodigoDiagnostico(IConstantes.CODIGO_PRINCIPAL_ABORTO_MEDICO);
        control.setCodigoRelacionado1(IConstantes.CODIGO_REL1_EXTRACCION_MENSUAL);
        control.setCodigoRelacionado2(IConstantes.CODIGO_REL2_ASESORAMIENTO_GENERAL_ANTICONCEPCION);
        control.setCodigoRelacionado3("");
        control.setDisableRel1(true);
        control.setRequiredRel2(true);
        control.setMenuBean("menuControlIlveBean");      
        control.inicializarControl();
        renderAntecedentes = control.esValido();
        
        if (control != null && 
            control.getImpresion() != null && 
            control.getImpresion().getHidcdiagprin() != 
            null) {
            cie10Principal = 
                    control.getImpresion().getHidcdiagprin();
            cie10Relacionado1 = 
                    control.getImpresion().getHidcdiagrela1();
        }



      

        // CONDUCTA RECOMENDACIONES
        recomedacionUsuarioBean = 
                (RecomedacionUsuarioBean)FacesUtils.getManagedBean("recomedacionUsuarioBean");
        recomedacionUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        recomedacionUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        recomedacionUsuarioBean.setNumeroConsulta(numeroConsulta);
        recomedacionUsuarioBean.setMenuBean("menuControlIlveBean");
        recomedacionUsuarioBean.inicializarRecomedaciones();
        renderCerrarConsulta = recomedacionUsuarioBean.esValido();


        // APLICACION - RETIRO DISPOSITIVOS
        dispositivos = 
                (AplicacionDispositivoBean)FacesUtils.getManagedBean("aplicacionDispositivoBean");
        dispositivos.setUsuario(datosBasicosUsuario.getUsuario());
        dispositivos.setTipoServicio(TIPO_CONSULTA);
        dispositivos.setNumeroConsulta(numeroConsulta);
        dispositivos.setMenuBean("menuControlIlveBean");
        dispositivos.inicializarAplicacionDispositivo();


        // CONDUCTA - ANATOMIA PATOLOGICA
        anatomiaPatologicaUsuarioBean = 
                (AnatomiaPatologicaUsuarioBean)FacesUtils.getManagedBean("anatomiaPatolUsuarioBean");
        anatomiaPatologicaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        anatomiaPatologicaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        anatomiaPatologicaUsuarioBean.setNumeroConsulta(numeroConsulta);
        anatomiaPatologicaUsuarioBean.setConsecutivo(1);
        anatomiaPatologicaUsuarioBean.setMenuBean("menuControlIlveBean");
        anatomiaPatologicaUsuarioBean.inicializarAnatomiaPatol();


        // CONDUCTA - CONTROL SIN COSTO
        controlSinCostoUsuarioBean = 
                (ControlSinCostoUsuarioBean)FacesUtils.getManagedBean("controlSinCostoUsuarioBean");
        controlSinCostoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        controlSinCostoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        controlSinCostoUsuarioBean.setCodigoCups(codigoCups);
        controlSinCostoUsuarioBean.setNumeroConsulta(numeroConsulta);
        controlSinCostoUsuarioBean.setMenuBean("menuControlIlveBean");
        controlSinCostoUsuarioBean.inicializarControlSinCosto();

        // CONDUCTA - FORMULA MEDICA
        formulaMedicaUsuarioBean = 
                (FormulaMedicaUsuarioBean)FacesUtils.getManagedBean("formulaMedicaUsuarioBean");
        formulaMedicaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        formulaMedicaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        formulaMedicaUsuarioBean.setNumeroConsulta(numeroConsulta);
        formulaMedicaUsuarioBean.setCodigoCIE10(cie10Principal);
        formulaMedicaUsuarioBean.setConsecutivo(1);
        formulaMedicaUsuarioBean.setMenuBean("menuControlIlveBean");
        formulaMedicaUsuarioBean.inicializardFormulaMedica();
        
        // CONDUCTA - FORMULA MEDICA
            vademecumUsuarioBean = (VademecumMedicoBean)FacesUtils.getManagedBean("vademecumMedicoBean");
            vademecumUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
            vademecumUsuarioBean.setTipoServicio(TIPO_CONSULTA);
            vademecumUsuarioBean.setNumeroConsulta(numeroConsulta);
            vademecumUsuarioBean.setCodigoCIE10(cie10Principal);
            vademecumUsuarioBean.setConsecutivo(1);
            vademecumUsuarioBean.setMenuBean("menuControlIlveBean");
            vademecumUsuarioBean.setRenderAlertaIve(true);
            vademecumUsuarioBean.inicializardFormulaMedica();


        // CONDUCTA - REMISION HOSPITALIZACION
        hospitalizacionUsuarioBean = 
                (HospitalizacionUsuarioBean)FacesUtils.getManagedBean("hospitalizacionUsuarioBean");
        hospitalizacionUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        hospitalizacionUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        hospitalizacionUsuarioBean.setNumeroConsulta(numeroConsulta);
        hospitalizacionUsuarioBean.setCiel0Principal(cie10Principal);
        hospitalizacionUsuarioBean.setConsecutivo(1);
        hospitalizacionUsuarioBean.setMenuBean("menuControlIlveBean");
        hospitalizacionUsuarioBean.inicializarHospitalizacion();

        // CONDUCTA - Cirug�as y procedimientos
        ordenCirugiaUsuarioBean = 
                (OrdenCirugiaUsuarioBean)FacesUtils.getManagedBean("ordenCirugiaUsuarioBean");
        ordenCirugiaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        ordenCirugiaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        ordenCirugiaUsuarioBean.setNumeroConsulta(numeroConsulta);
        ordenCirugiaUsuarioBean.setConsecutivo(1);
        ordenCirugiaUsuarioBean.setMenuBean("menuControlIlveBean");
        ordenCirugiaUsuarioBean.inicializarOrdenCirugia();

        // CONDUCTA - INTER-CONSULTA
        interConsultaUsuarioBean = 
                (InterConsultaUsuarioBean)FacesUtils.getManagedBean("interConsultaUsuarioBean");
        interConsultaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        interConsultaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        interConsultaUsuarioBean.setNumeroConsulta(numeroConsulta);
        interConsultaUsuarioBean.setCie10Principal(cie10Principal);
        interConsultaUsuarioBean.setConsecutivo(1);
        interConsultaUsuarioBean.setMenuBean("menuControlIlveBean");
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
        incapacidadUsuarioBean.setMenuBean("menuControlIlveBean");
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
        referenciaUsuarioBean.setMenuBean("menuControlIlveBean");
        referenciaUsuarioBean.inicializarReferencia();


        // CONDUCTA - AUTORIZACION DE SERVICIOS
        
         autorizacionServicioUsuarioBean =
                 (AutorizacionServicioUsuarioBean)FacesUtils.getManagedBean("autorizacionServicioUsuarioBean");
         autorizacionServicioUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
         
         autorizacionServicioUsuarioBean.setTipoServicio(TIPO_CONSULTA);
         autorizacionServicioUsuarioBean.setNumeroConsulta(numeroConsulta);
//         autorizacionServicioUsuarioBean.setTipoHistoria(motivoConsulta.getTipoHistoria());
//         autorizacionServicioUsuarioBean.setOrigenAtencion(motivoConsulta.getCausaSelect());  
         autorizacionServicioUsuarioBean.setCodigoCups(codigoCups);
//         autorizacionServicioUsuarioBean.setTipoDiagnostico(impresionDiagnosticaControlIlveBean.getTipoDiagnostico());
         autorizacionServicioUsuarioBean.setCodigoDiagnostico(impresionDiagnosticaControlIlveBean.getCodigoDiagnostico());
         autorizacionServicioUsuarioBean.setCodigoDiagnostico1(impresionDiagnosticaControlIlveBean.getCodigoRelacionado1());
         autorizacionServicioUsuarioBean.setCodigoDiagnostico2(impresionDiagnosticaControlIlveBean.getCodigoRelacionado2());
         autorizacionServicioUsuarioBean.setMenuBean("menuControlIlveBean");
         autorizacionServicioUsuarioBean.inicializarAutorizacionServicio();


    

        // CONDUCTA - SOLICITUD RESERVA DE SANGRE
        reservaSangreUsuarioBean = 
                (ReservaSangreUsuarioBean)FacesUtils.getManagedBean("reservaSangreUsuarioBean");
        reservaSangreUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        reservaSangreUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        reservaSangreUsuarioBean.setNumeroConsulta(numeroConsulta);
        reservaSangreUsuarioBean.setConsecutivo(1);
        reservaSangreUsuarioBean.setMenuBean("menuControlIlveBean");
        reservaSangreUsuarioBean.inicializarReservaSangre();

        // CONDUCTA - CERTIFICADOS / CERTIFICADO MEDICO
        certMedicoUsuarioBean = 
                (CertMedicoUsuarioBean)FacesUtils.getManagedBean("certMedicoUsuarioBean");
        certMedicoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        certMedicoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        certMedicoUsuarioBean.setNumeroConsulta(numeroConsulta);
        certMedicoUsuarioBean.setMenuBean("menuControlIlveBean");
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
        certAsistenciaUsuarioBean.setMenuBean("menuControlIlveBean");
        certAsistenciaUsuarioBean.inicializarCertificadoAsistencia();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN ELECTROFISIOLOGICO
        examElectrofisiologicoUsuarioBean = 
                (ExamElectrofisiologicoUsuarioBean)FacesUtils.getManagedBean("examElectrofisioUsuarioBean");
        examElectrofisiologicoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        examElectrofisiologicoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        examElectrofisiologicoUsuarioBean.setNumeroConsulta(numeroConsulta);
        examElectrofisiologicoUsuarioBean.setCie10Principal(cie10Principal);
        examElectrofisiologicoUsuarioBean.setConsecutivo(1);
        examElectrofisiologicoUsuarioBean.setMenuBean("menuControlIlveBean");
        examElectrofisiologicoUsuarioBean.inicializarExamElectrofisiologico();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN IMAGEN
        examImagenUsuarioBean = 
                (ExamImagenUsuarioBean)FacesUtils.getManagedBean("examImagenUsuarioBean");
        examImagenUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        examImagenUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        examImagenUsuarioBean.setNumeroConsulta(numeroConsulta);
        examImagenUsuarioBean.setConsecutivo(1);
        examImagenUsuarioBean.setCie10Principal(cie10Principal);
        examImagenUsuarioBean.setMenuBean("menuControlIlveBean");
        examImagenUsuarioBean.inicializarExamImagen();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN LABORATORIO
        examLaboratorioUsuarioBean = 
                (ExamLaboratorioUsuarioBean)FacesUtils.getManagedBean("examLaboratorioUsuarioBean");
        examLaboratorioUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        examLaboratorioUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        examLaboratorioUsuarioBean.setNumeroConsulta(numeroConsulta);
        examLaboratorioUsuarioBean.setConsecutivo(1);
        examLaboratorioUsuarioBean.setCie10Principal(cie10Principal);
        examLaboratorioUsuarioBean.setMenuBean("menuControlIlveBean");
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
        cerrarConsultaUsuarioBean.setMenuBean("menuControlIlveBean");
        cerrarConsultaUsuarioBean.setConsulta(datosBasicosUsuario.getConsulta());
        cerrarConsultaUsuarioBean.setEsVacunacion(false); 
        cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();


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

    }
    
    private void initPausarConsulta() {
        
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
    
    public String irPausarConsultaInterrupcionControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_PAUSAR_CONSULTA_INTERRUPCION_CONTROL;
    }


    /**
     * @return
     */
    public String irDatosControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_DATOS_CONTROL_ILVE;
    }


    /**
     * @return
     */
    public String irMotivoControlIlve() {
        inicializarUsuario();

        return BeanNavegacion.RUTA_IR_MOTIVO_CONTROL_ILVE;
    }
    
    public String irCuestionarioCovidControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_CONTROL_ILVE;
        }

    
  
    /**
     * @return
     */
    public String irAntecedentesGeneralesControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_GENERALES_CONTROL_ILVE; 
    }


    /**
     * @return
     */
    public String irAntecedentesControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_CONTROL_ILVE;
    }



    /**
     * @return
     */
    public String irExamenFisicoControlIlve() {

        inicializarUsuario();

        return BeanNavegacion.RUTA_IR_EXAMEN_FISICO_CONTROL_ILVE;
    }
    
    
    /**
     * @return
     */
     
     public String irImpresionDiagnosticaControlIlve(){
         inicializarUsuario();
         return BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_ILVE;
     }



    /**
     * @return
     */
    public String irImpDiagnosticaControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_CONTROL_ILVE;
    }


    public String irControlUsuarioIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CONTROL_USUARIO_ILVE;
    }


    /**
     * @return
     */
    public String irAnatPatologicaControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANATOMIAPATOLOGICA_CONTROL_ILVE;
    }

    /**
     * @return
     */
    public String irAplicacionRetiroIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_APLICACION_RETITO_CONTROL_ILVE;
    }

    /**
     * @return
     */
    public String irControlSinCostoControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CONTOLSINCOSTO_CONTROL_ILVE;
    }


    /**
     * @return
     */
    public String irFormulaMedicaControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FORMULAMEDICA_CONTROL_ILVE;
    }
    
    /**
       * @return
       */
      public String irVademecumMedicoControlIlve() {
          inicializarUsuario();
          return BeanNavegacion.RUTA_IR_VADEMCUM_CONTROL_ILVE;
      }

    /**
     * @return
     */
    public String irRemHospitalizacionControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_HOSPITALZACION_CONTROL_ILVE;
    }


    /**
     * @return
     */
    public String irIncapacidadControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INCAPACIDAD_CONTROL_ILVE;
    }


    /**
     * @return
     */
    public String irInterConsultaControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INTERCONSULTA_CONTROL_ILVE;
    }


    /**
     * @return
     */
    public String irOrdenCirugiaControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ORDENCIRUGIA_CONTROL_ILVE;
    }


    /**
     * @return
     */
    public String irReferenciaControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_REFERENCIA_CONTROL_ILVE;
    }
    
    
    /**
     * @return
     */
     public String irAutorizacionServicioControlIlve(){
         inicializarUsuario();
         return BeanNavegacion.RUTA_IR_AUTORIZACION_SERVICIOS_CONTROL_ILVE;
     }

    /**
     * @return
     */
    public String irReservaSangreControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESERVA_SANGRE_CONTROL_ILVE;
    }


    /**
     * @return
     */
    public String irRecomedacionControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RECOMENDACIONES_CONTROL_ILVE;
    }


    /**
     * @return
     */
    public String irCertMedicoControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADOMEDICO_CONTROL_ILVE;
    }

    /**
     * @return
     */
    public String irCertAsistenciaControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADO_ASISTENCIA_CONTROL_ILVE;
    }

    /**
     * @return
     */
    public String irExamElectrofisiologicoControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ELECTROFISIOLOGICO_CONTROL_ILVE;
    }

    /**
     * @return
     */
    public String irExamImagenControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMAGENES_CONTROL_ILVE;
    }

    /**
     * @return
     */
    public String irExamLaboratorioControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_LABORATORIO_CONTROL_ILVE;
    }


    public String irCerrarConsultaControlIlve() {
        if (cerrarConsultaUsuarioBean != null) {
            cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
        }
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERRAR_CONTROL_ILVE;
    }

    /**
     * @return
     */
    public String irResumenHistoriaEspecificaControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_CONTROL_ILVE;
    }


    /**
     * @return
     */
    public String irResumenHistoriaControlIlve() {
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
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_CONTROL_ILVE;
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
     * @param renderControl
     */
    public void setRenderControl(boolean renderControl) {
        this.renderControl = renderControl;
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
    public boolean isRenderControl() {
        return renderControl;
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
            new TreeNodeBase("itemNode2", "Control", false);
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


    public void setRenderImpresion(boolean renderImpresion) {
        this.renderImpresion = renderImpresion;
    }

    public boolean isRenderImpresion() {
        return renderImpresion;
    }

    public void setRenderExamenFisico(boolean renderExamenFisico) {
        this.renderExamenFisico = renderExamenFisico;
    }

    public boolean isRenderExamenFisico() {
        return renderExamenFisico;
    }


    public void setRenderAntecedentes(boolean renderAntecedentes) {
        this.renderAntecedentes = renderAntecedentes;
    }

    public boolean isRenderAntecedentes() {
        return renderAntecedentes;
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
	
	public String irServiciosAdmisionInterrupcionControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_SERVICIOS_ADMISION_INTERRUPCION_CONTROL;
    }

    public void setRenderServiciosAdmision(boolean renderServiciosAdmision) {
        this.renderServiciosAdmision = renderServiciosAdmision;
    }

    public boolean isRenderServiciosAdmision() {
        return renderServiciosAdmision;
    }

    public void setRenderCovid(boolean renderCovid) {
        this.renderCovid = renderCovid;
    }

    public boolean isRenderCovid() {
        return renderCovid;
    }
    
    /**
     * @return
     */
    public String irEscalaValoracionCaidasControlIlve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_CONTROL_IVE;
    }

    public void setRenderEscalaCaidas(boolean renderEscalaCaidas) {
        this.renderEscalaCaidas = renderEscalaCaidas;
    }

    public boolean isRenderEscalaCaidas() {
        return renderEscalaCaidas;
    }
    
    /**
     * 
     * @return
     */
    public String irIdentificacionControlRiesgoInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IDENTIFICACION_RIESGOS_CONTROL_ILVE;
    }
    
    /**
     * @return
     */
    public String irRemisionControlIlveInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADO_CONTROL_ILVE;
    }
}
