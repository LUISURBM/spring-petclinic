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

import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.asesoria.administrador.ConsultarAsesoriaBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosBean;
import org.profamilia.hc.view.backing.comun.AntecedentePsicologiaBean;
import org.profamilia.hc.view.backing.comun.CerrarConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.EvaluacionGeneralBean;
import org.profamilia.hc.view.backing.comun.ImpresionDiagnosticaUsuarioBean;
import org.profamilia.hc.view.backing.comun.MotivoBean;
import org.profamilia.hc.view.backing.comun.PausarConsultaBean;
import org.profamilia.hc.view.backing.comun.PlanTratamientoUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.CertAsistenciaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.CertMedicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ControlSinCostoUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.InterConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.RecomedacionUsuarioBean;
import org.profamilia.hc.view.backing.comun.resumen.ResumenHistoriaEspecificaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.ExpandableTreeModel;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;
import org.profamilia.hc.view.backing.comun.EncuestaViolenciaSivigilaBean;
import org.profamilia.hc.view.backing.comun.EncuestaViolenciaUsuarioBean;
import org.profamilia.hc.view.backing.comun.RegistrarEscalaValoracionCaidasCEBean;
import org.profamilia.hc.view.backing.comun.conducta.ReferenciaUsuarioBean;


public class MenuHistoriaPsicologicaBean extends BaseBean {

    private DatosBasicosUsuarioBean datosBasicosUsuario;

    private MotivoBean motivoConsulta;
    
    private AntecedentePsicologiaBean antecedentes;
    
    private EncuestaViolenciaUsuarioBean encuestaViolenciaUsuario;
    
    private EncuestaViolenciaSivigilaBean encuestaViolenciaSivigila;
    
    private EvaluacionGeneralBean evaluacion; 

    private ImpresionDiagnosticaUsuarioBean impresionDiagnosticaUsuarioBean;

     private ControlSinCostoUsuarioBean controlSinCostoUsuarioBean;

    private InterConsultaUsuarioBean interConsultaUsuarioBean;

    private RecomedacionUsuarioBean recomedacionUsuarioBean;

    private CertMedicoUsuarioBean certMedicoUsuarioBean;

    private CertAsistenciaUsuarioBean certAsistenciaUsuarioBean;

    private CerrarConsultaUsuarioBean cerrarConsultaUsuarioBean;

    private ResumenHistoriaEspecificaBean resumenEspecifico;
    
    private PlanTratamientoUsuarioBean planTratamientoBean; 

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private boolean renderMotivo;
    
    private boolean renderAntecedentesGenerales;
    
    private boolean renderEvaluacionGeneral; 

    private boolean renderImpresionDiagnostica;
    
    private boolean renderPlanTratamiento; 

    private boolean renderConducta;

    private boolean renderCerrarConsulta;

    private ExpandableTreeModel trnhistoria;

    private Long numeroConsulta;

    private String cie10Principal;

    private String cie10Relacionado1;

    private String codigoCups;    

    private String javaScriptText;
    
    private boolean renderPausarConsulta;
    
    private PausarConsultaBean pausarConsulta;
    
    private boolean tiempoAtencion;
    
    private CuestionarioCovidBean cuestionarioCovid;
	
	private ConfirmarServiciosAdmisionBean confirmarServiciosAdmision;
			
	private boolean renderServiciosAdmision;
        
    private ReferenciaUsuarioBean referenciaUsuarioBean;
    
    private boolean renderCovid;
    
    private boolean renderViolenciaPsicologica;
    
    private RegistrarEscalaValoracionCaidasCEBean registrarEscalaValoracionCaidasBean;
    
    private boolean renderEscalaCaidas;
    
    
    
    public void init() {
        String tensionArterial = null;
        Integer frecuenciaCardiaca = null;
        Integer frecuenciaRespiratoria = null;
        BigDecimal peso = null;
        String hallazgos = null;
        BigDecimal temperatura = null;
        renderPausarConsulta=false;
		renderServiciosAdmision =false;		
        
        // DATOS BASICOS USUARIO
        datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_PSICOLOGIA);
        datosBasicosUsuario.setMenuBean("menuHistoriaPsicologicaBean");
        renderCovid = datosBasicosUsuario.esValido();
        if(IConstantes.ACTIVAR_PAUSAR_CONSULTA){
        renderPausarConsulta = datosBasicosUsuario.esValido();
        }


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
        
        if(IConstantes.ACTIVAR_PAUSAR_CONSULTA){
            tiempoAtencion =datosBasicosUsuario.esValido();
            if (tiempoAtencion) {
                
                try {
                    List<Chtiempaten> chtiempatenList = new ArrayList();
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
        
        
        // MOTIVO DE CONSULTA
        cuestionarioCovid = (CuestionarioCovidBean)FacesUtils.getManagedBean("cuestionarioCovidBean");
        cuestionarioCovid.setTipoServicio(TIPO_CONSULTA);
        cuestionarioCovid.setNumeroConsulta(numeroConsulta);
        if(datosBasicosUsuario != null && datosBasicosUsuario.getUsuario() != null && datosBasicosUsuario.getUsuario().getHuslnumero() != null ){
            cuestionarioCovid.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
        }
        cuestionarioCovid.setNextAction(BeanNavegacion.RUTA_IR_REGISTRO_ESCALA_VALORACION_CAIDAS_PSICOLOGIA);
        cuestionarioCovid.setMenuBean("menuHistoriaPsicologicaBean");
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
           registrarEscalaValoracionCaidasBean.setMenuBean("menuHistoriaPsicologicaBean");
           registrarEscalaValoracionCaidasBean.setNextAction(BeanNavegacion.RUTA_IR_MOTIVO_PSICOLOGIA);
           registrarEscalaValoracionCaidasBean.init();
           
           renderMotivo = registrarEscalaValoracionCaidasBean.esValido();
         

        // MOTIVO DE CONSULTA
       
        
        motivoConsulta = (MotivoBean)FacesUtils.getManagedBean("motivoBean");
        motivoConsulta.setTipoServicio(TIPO_CONSULTA);
        motivoConsulta.setNumeroConsulta(numeroConsulta);
        motivoConsulta.setOcultarasesoria(true);
        motivoConsulta.setFinalidadSelect(FINALIDAD_CONSULTA_NO_APLICA);
        motivoConsulta.setTipoHistoria(HISTORIA_PSICOLOGICA);
        motivoConsulta.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_PSICOLOGIA);
        motivoConsulta.setMenuBean("menuHistoriaPsicologicaBean");
        motivoConsulta.inicializarMotivo();
        renderAntecedentesGenerales = motivoConsulta.esValido();


        // ANTECEDENTES

     
            antecedentes = 
            (AntecedentePsicologiaBean)FacesUtils.getManagedBean("antecedentePsicologiaBean");
            antecedentes.setTipoServicio(TIPO_CONSULTA);
            antecedentes.setNumeroConsulta(numeroConsulta);
            antecedentes.setTipoHistoria(HISTORIA_PSICOLOGICA);
            antecedentes.setUsuario(datosBasicosUsuario.getUsuario());
            antecedentes.setNextAction(BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_PSICOLOGICA);
            antecedentes.setMenuBean("menuHistoriaPsicologicaBean");
            antecedentes.inicializarAntecedentes();
           
            renderViolenciaPsicologica = antecedentes.esValido(); 
            
        // ENCUESTA DE VIOLENCIA
        encuestaViolenciaUsuario = 
                (EncuestaViolenciaUsuarioBean)FacesUtils.getManagedBean("encuestaViolenciaUsuarioBean");
        encuestaViolenciaUsuario.setTipoServicio(TIPO_CONSULTA);
        encuestaViolenciaUsuario.setNumeroConsulta(numeroConsulta);
        encuestaViolenciaUsuario.setNextAction(BeanNavegacion.RUTA_IR_EVALUACION_GENERAL_PSICOLOGIA);
        encuestaViolenciaUsuario.setMenuBean("menuHistoriaPsicologicaBean");
        encuestaViolenciaUsuario.inicializarEncuesta();
        renderEvaluacionGeneral = encuestaViolenciaUsuario.esValido();
            
            
            // EVALUACION GENERAL
        evaluacion = 
                (EvaluacionGeneralBean)FacesUtils.getManagedBean("evaluacionGeneralBean");
        evaluacion.setTipoServicio(TIPO_CONSULTA);
        evaluacion.setNumeroConsulta(numeroConsulta);
        evaluacion.setTipoHistoria(HISTORIA_PSICOLOGICA);
        evaluacion.setUsuario(datosBasicosUsuario.getUsuario());
        evaluacion.setNextAction(BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_PSICOLOGIA);
        evaluacion.setMenuBean("menuHistoriaPsicologicaBean");
        evaluacion.inicializarEvaluacion();
        renderImpresionDiagnostica = evaluacion.esValido(); 
     

      

        // IMPRESION DIAGNOSTICA
        impresionDiagnosticaUsuarioBean = 
                (ImpresionDiagnosticaUsuarioBean)FacesUtils.getManagedBean("impresionDiagnosticaUsuarioBean");
        impresionDiagnosticaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        impresionDiagnosticaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        impresionDiagnosticaUsuarioBean.setNumeroConsulta(numeroConsulta);
        impresionDiagnosticaUsuarioBean.setConsecutivo(1);
        impresionDiagnosticaUsuarioBean.setCodigoDiagnostico("");
        impresionDiagnosticaUsuarioBean.setCodigoRelacionado1("");
        impresionDiagnosticaUsuarioBean.setCodigoRelacionado2("");
        impresionDiagnosticaUsuarioBean.setCodigoRelacionado3("");
        impresionDiagnosticaUsuarioBean.setDisableRel1(false);
        impresionDiagnosticaUsuarioBean.setRequiredRel2(false);
        impresionDiagnosticaUsuarioBean.setRenderColposcopia(false);
        impresionDiagnosticaUsuarioBean.setDesHabilitarDiagnosticoPrincipal(false);
        impresionDiagnosticaUsuarioBean.setCodigoRelacionado3("");
        impresionDiagnosticaUsuarioBean.setNextAction(BeanNavegacion.RUTA_IR_PLAN_TRATAMIENTO_PSICOLOGIA);
        impresionDiagnosticaUsuarioBean.setMenuBean("menuHistoriaPsicologicaBean");
        impresionDiagnosticaUsuarioBean.setDesHabilitarDiagnosticoPrincipal(false);
        impresionDiagnosticaUsuarioBean.inicializarImpresion();
        renderPlanTratamiento = impresionDiagnosticaUsuarioBean.esValido();

        // SE OBTIENE EL CODIGO DEL DIAGNOSTICO PRINCIPAL 

        if (impresionDiagnosticaUsuarioBean != null && 
            impresionDiagnosticaUsuarioBean.getImpresion() != null && 
            impresionDiagnosticaUsuarioBean.getImpresion().getHidcdiagprin() != 
            null) {
            cie10Principal = 
                    impresionDiagnosticaUsuarioBean.getImpresion().getHidcdiagprin();
            cie10Relacionado1 = 
                    impresionDiagnosticaUsuarioBean.getImpresion().getHidcdiagrela1();
        }
        
        
        
        
        planTratamientoBean = 
                (PlanTratamientoUsuarioBean)FacesUtils.getManagedBean("planTratamientoUsuarioBean");
        planTratamientoBean.setTipoServicio(TIPO_CONSULTA);
        planTratamientoBean.setNumeroConsulta(numeroConsulta);
        planTratamientoBean.setTipoHistoria(HISTORIA_PSICOLOGICA);
        planTratamientoBean.setUsuario(datosBasicosUsuario.getUsuario());
        planTratamientoBean.setNextAction(BeanNavegacion.RUTA_IR_RECOMENDACIONES_PSICOLOGIA);
        planTratamientoBean.setMenuBean("menuHistoriaPsicologicaBean");
        planTratamientoBean.inicializarPlanTratamiento();
        renderConducta = planTratamientoBean.esValido(); 


        // CONDUCTA RECOMENDACIONES
        recomedacionUsuarioBean = 
                (RecomedacionUsuarioBean)FacesUtils.getManagedBean("recomedacionUsuarioBean");
        recomedacionUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        recomedacionUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        recomedacionUsuarioBean.setNumeroConsulta(numeroConsulta);
        recomedacionUsuarioBean.setMenuBean("menuHistoriaPsicologicaBean");
        recomedacionUsuarioBean.inicializarRecomedaciones();
        renderCerrarConsulta = recomedacionUsuarioBean.esValido();


        // CONDUCTA - CONTROL SIN COSTO
        controlSinCostoUsuarioBean = 
                (ControlSinCostoUsuarioBean)FacesUtils.getManagedBean("controlSinCostoUsuarioBean");
        controlSinCostoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        controlSinCostoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        controlSinCostoUsuarioBean.setCodigoCups(codigoCups);
        controlSinCostoUsuarioBean.setNumeroConsulta(numeroConsulta);
        controlSinCostoUsuarioBean.setMenuBean("menuHistoriaPsicologicaBean");
        controlSinCostoUsuarioBean.inicializarControlSinCosto();

        // ENCUESTA DE VIOLENCIA SIVIGILA
        
         encuestaViolenciaSivigila = 
                 (EncuestaViolenciaSivigilaBean)FacesUtils.getManagedBean("encuestaViolenciaSivigilaBean");
         encuestaViolenciaSivigila.setTipoServicio(TIPO_CONSULTA);
         encuestaViolenciaSivigila.setNumeroConsulta(numeroConsulta);
         encuestaViolenciaSivigila.setMenuBean("menuHistoriaPsicologicaBean");
         if(datosBasicosUsuario != null && datosBasicosUsuario.getUsuario() != null &&datosBasicosUsuario.getUsuario().getHuslnumero()!= null )
         encuestaViolenciaSivigila.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero() );
         encuestaViolenciaSivigila.inicializarEncuesta();
        

        // CONDUCTA - INTER-CONSULTA
        interConsultaUsuarioBean = 
                (InterConsultaUsuarioBean)FacesUtils.getManagedBean("interConsultaUsuarioBean");
        interConsultaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        interConsultaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        interConsultaUsuarioBean.setNumeroConsulta(numeroConsulta);
        interConsultaUsuarioBean.setCie10Principal(cie10Principal);
        interConsultaUsuarioBean.setConsecutivo(1);
        interConsultaUsuarioBean.setMenuBean("menuHistoriaPsicologicaBean");
        if (datosBasicosUsuario.getConsulta() != null) {
            Long tipoDocuentoAdmision = 
                datosBasicosUsuario.getConsulta().getCcontipdoc().getCtdnnumero().longValue();
            if (tipoDocuentoAdmision == IConstantes.TIPO_DOCUMENTO_ADMISION) {
                    interConsultaUsuarioBean.setNumeroAdmision(datosBasicosUsuario.getConsulta().getCconnumdoc().longValue());
            }
        }
        interConsultaUsuarioBean.inicializarInterConsulta();


        // CONDUCTA - CERTIFICADOS / CERTIFICADO MEDICO
        certMedicoUsuarioBean = 
                (CertMedicoUsuarioBean)FacesUtils.getManagedBean("certMedicoUsuarioBean");
        certMedicoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        certMedicoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        certMedicoUsuarioBean.setNumeroConsulta(numeroConsulta);
        certMedicoUsuarioBean.setMenuBean("menuHistoriaPsicologicaBean");
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
        certAsistenciaUsuarioBean.setMenuBean("menuHistoriaPsicologicaBean");
        certAsistenciaUsuarioBean.inicializarCertificadoAsistencia();

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
        referenciaUsuarioBean.setMenuBean("menuHistoriaPsicologicaBean");
        referenciaUsuarioBean.inicializarReferencia();

        // CERRAR CONSULTA
        cerrarConsultaUsuarioBean = 
                (CerrarConsultaUsuarioBean)FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
        cerrarConsultaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        cerrarConsultaUsuarioBean.setMenuBean("menuHistoriaPsicologicaBean");
        cerrarConsultaUsuarioBean.setConsulta(datosBasicosUsuario.getConsulta());
        cerrarConsultaUsuarioBean.setEsVacunacion(false); 
        cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();


        //RESUMEN DE LA HISTORIA CLINICA

        resumenEspecifico = 
                (ResumenHistoriaEspecificaBean)FacesUtils.getManagedBean("resumenHistoriaEspecificaBean");
        resumenEspecifico.setUsuario(datosBasicosUsuario.getUsuario());
        
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
    
    public String irPausarConsultaPsicologica() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_PAUSAR_CONSULTA_PSICOLOGICA;
    }

    /**
     * @return
     */
    public String irDatosPsicologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_DATOS_PSICOLOGIA;
    }

    /**
     * @return
     */
    public String irMotivoPsicologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_MOTIVO_PSICOLOGIA;
    }
    
    public String irCuestionarioCovidPsicologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_PSICOLOGIA;
        }


    /**
     * @return
     */
    public String irAntecedentesPsicologia() {
        
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_PSICOLOGIA;
        }

    /**
     * @return
     */
    public String irEvaluacionGeneral() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EVALUACION_GENERAL_PSICOLOGIA; 
    }


    /**
     * @return
     */
    public String irImpDiagnosticaPsicologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_PSICOLOGIA;
    }

    /**
     * @return
     */
    public String irPlanTratamiento() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_PLAN_TRATAMIENTO_PSICOLOGIA; 
        }

    /**
     * @return
     */
    public String irControlSinCostoPsicologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CONTOLSINCOSTO_PSICOLOGIA; 
    }

    /**
     * @return
     */
    public String irInterConsultaPsicologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INTERCONSULTA_PSICOLOGIA; 
    }

    /**
     * @return
     */
    public String irViolenciaSivigilaPsicologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_VIOLENCIA_SIVIGILA_PSICOLOGIA; 
    }
    /**
     * @return
     */
    public String irRecomedacionPsicologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RECOMENDACIONES_PSICOLOGIA; 
    }

    /**
     * @return
     */
    public String irCertMedicoPsicologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADOMEDICO_PSICOLOGIA; 
    }

    /**
     * @return
     */
    public String irCertAsistenciaPsicologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADO_ASISTENCIA_PSICOLOGIA; 
    }


    /**
     * @return
     */
    public String irCerrarConsultaPsicologia() {
        if (cerrarConsultaUsuarioBean != null) {
            cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
        }
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERRAR_PSICOLOGIA;
    }

    /**
     * @return
     */
    public String irReferenciaPsicologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_REFERENCIA_PSICOLOGIA; 
    }


    /**
     * @return
     */
    public String irResumenHistoriaPsicologia() {
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
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_PSICOLOGIA;
    }
    
    
    public String irCertificadosIlve() {
          
        inicializarUsuario();
        FacesUtils.resetManagedBean("consultarAsesoriaBean");
        ConsultarAsesoriaBean generarResumen = 
            (ConsultarAsesoriaBean)FacesUtils.getManagedBean("consultarAsesoriaBean");
        if (generarResumen != null) {
            
            generarResumen.setUsuario(datosBasicosUsuario.getUsuario());
            generarResumen.init();
            generarResumen.consultarAsesoriasUsuario();

        }
        
        return BeanNavegacion.RUTA_IR_CERTIFICADO_PSICOLOGIA;
        
    }


    public void inicializarUsuario() {
        FacesUtils.resetManagedBean("encuestaViolenciaUsuario");
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
     * @param renderMotivo
     */
    public void setRenderMotivo(boolean renderMotivo) {
        this.renderMotivo = renderMotivo;
    }

    /**
     * @return
     */
    public boolean isRenderMotivo() {
        return renderMotivo;
    }

    /**
     * @param renderPlanTratamiento
     */
    public void setRenderPlanTratamiento(boolean renderPlanTratamiento) {
        this.renderPlanTratamiento = renderPlanTratamiento;
    }

    /**
     * @return
     */
    public boolean isRenderPlanTratamiento() {
        return renderPlanTratamiento;
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
     * @param renderAntecedentesGenerales
     */
    public void setRenderAntecedentesGenerales(boolean renderAntecedentesGenerales) {
        this.renderAntecedentesGenerales = renderAntecedentesGenerales;
    }

    /**
     * @return
     */
    public boolean isRenderAntecedentesGenerales() {
        return renderAntecedentesGenerales;
    }

    /**
     * @param renderImpresionDiagnostica
     */
    public void setRenderImpresionDiagnostica(boolean renderImpresionDiagnostica) {
        this.renderImpresionDiagnostica = renderImpresionDiagnostica;
    }

    /**
     * @return
     */
    public boolean isRenderImpresionDiagnostica() {
        return renderImpresionDiagnostica;
    }

    /**
     * @param renderEvaluacionGeneral
     */
    public void setRenderEvaluacionGeneral(boolean renderEvaluacionGeneral) {
        this.renderEvaluacionGeneral = renderEvaluacionGeneral;
    }

    /**
     * @return
     */
    public boolean isRenderEvaluacionGeneral() {
        return renderEvaluacionGeneral;
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
	public String irServiciosAdmisionPsicologica() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_SERVICIOS_ADMISION_PSICOLOGICA;
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
    public String irEncuestaViolenciaPsicologica() {
    
        inicializarUsuario();
        
        return BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_PSICOLOGICA;
    }
    
    /**
     * @return
     */
    public String irEscalaValoracionCaidasPsicologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_REGISTRO_ESCALA_VALORACION_CAIDAS_PSICOLOGIA;
    }

    public void setRenderEscalaCaidas(boolean renderEscalaCaidas) {
        this.renderEscalaCaidas = renderEscalaCaidas;
    }

    public boolean isRenderEscalaCaidas() {
        return renderEscalaCaidas;
    }
}
