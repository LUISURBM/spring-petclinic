package org.profamilia.hc.view.backing.menus;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.myfaces.custom.tree2.TreeNode;
import org.apache.myfaces.custom.tree2.TreeNodeBase;
import org.profamilia.hc.view.backing.comun.conducta.VademecumMedicoBean;
import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.consulta.EsterilizacionFemeninaBean;
import org.profamilia.hc.view.backing.cirugia.registro.OtrasOrdenesBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaHospitalizacionBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaLiquidosBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosBean;
import org.profamilia.hc.view.backing.comun.AntecedentesGeneralesUsuarioBean;
import org.profamilia.hc.view.backing.comun.AntecedentesGinecologicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.AntecedentesUsuarioBean;
import org.profamilia.hc.view.backing.comun.CerrarConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.EncuestaViolenciaUsuarioBean;
import org.profamilia.hc.view.backing.comun.ExamenFisicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.ImpresionDiagnosticaUsuarioBean;
import org.profamilia.hc.view.backing.comun.MotivoBean;
import org.profamilia.hc.view.backing.comun.PausarConsultaBean;
import org.profamilia.hc.view.backing.comun.RegistrarEscalaValoracionCaidasCEBean;
import org.profamilia.hc.view.backing.comun.conducta.AnatomiaPatologicaUsuarioBean;
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


public class MenuProcesosEsterilizacionBean extends BaseBean {

    private DatosBasicosUsuarioBean datosBasicosUsuario;

    private MotivoBean motivoConsulta;

    private ExamenFisicoUsuarioBean examenFisicoUsuario;

    private EncuestaViolenciaUsuarioBean encuestaViolenciaUsuario;

    private ImpresionDiagnosticaUsuarioBean impresionDiagnosticaUsuarioBean;

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

    private EsterilizacionFemeninaBean esterilizacionFemeninaBean;

    private AntecedentesGinecologicosUsuarioBean antecedentesGinecologicos;

    private CerrarConsultaUsuarioBean cerrarConsultaUsuarioBean;
    
    private ResumenHistoriaEspecificaBean resumenEspecifico;
    
    private AntecedentesUsuarioBean antecedentes;
    
    private AntecedentesGeneralesUsuarioBean antecedentesGenerales;
    
    private FormulaLiquidosBean formulaLiquidosBean;

    private FormulaHospitalizacionBean formulaHospitalizacionBean;    
    
    private OtrasOrdenesBean otrasOrdenesBean;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private boolean renderMotivo;

    private boolean renderExamen;

    private boolean renderEncuestaViolencia;

    private boolean renderImpresionDiagnostica;

    private boolean renderConducta;

    private boolean renderCuestionario;

    private boolean renderAntGinecologicos;
    
    private boolean renderCerrarConsulta;

    private ExpandableTreeModel trnhistoria;

    private String nombreMenuBean = "menuProcesosEsterilizacionBean";

    private Long numeroConsulta;
    
    private Chantegineco antecedenteObject;
    
    private String cie10Principal;

    private String cie10Relacionado1;
    
    private String codigoCups;
    
    private boolean renderAntecedentesGenerales; 
    
    private boolean primeraConsulta; 
    
    private Long numeroUsuario; 
    
    private VademecumMedicoBean vademecumUsuarioBean;

    private boolean renderVademecum;

    private boolean renderPausarConsulta;
    
    private PausarConsultaBean pausarConsulta;
    
    private boolean tiempoAtencion;
    
    
    private CuestionarioCovidBean cuestionarioCovid;
    
    private boolean renderCovid;
    
    private RegistrarEscalaValoracionCaidasCEBean registrarEscalaValoracionCaidasBean;
    
    private boolean renderEscalaCaidas;

    public void init() {
    
        String tensionArterial = null;
        Integer frecuenciaCardiaca = null;
        Integer frecuenciaRespiratoria = null;
        BigDecimal peso = null;
        String hallazgos = null;
        BigDecimal temperatura = null;
        
        boolean renderMasculino; 
        renderMasculino = false; 
        
        
        renderVademecum = false;
        
        renderEscalaCaidas = false;
            
            if(this.getClinica()!= null && this.getClinica().getCclncodigo() != null &&
            (this.getClinica().getCclncodigo().equals(new Integer(1)) ||
            this.getClinica().getCclncodigo().equals(new Integer(6)) ||
            this.getClinica().getCclncodigo().equals(new Integer(7)) ||
            this.getClinica().getCclncodigo().equals(new Integer(36)) ||
            this.getClinica().getCclncodigo().equals(new Integer(79)) ||
            this.getClinica().getCclncodigo().equals(new Integer(11)) ||
            this.getClinica().getCclncodigo().equals(new Integer(4)))){
                renderVademecum = true; 
            }

        // DATOS BASICOS USUARIO
        datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_ESTERILIZACION);
        datosBasicosUsuario.setMenuBean(nombreMenuBean);
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
            datosBasicosUsuario.getConsulta() != null && 
            datosBasicosUsuario.getUsuario().getHuslnumero() != null) {
            numeroUsuario = datosBasicosUsuario.getUsuario().getHuslnumero();         
        }
        
       
        

                // PRIMERA CONSULTA

                if (datosBasicosUsuario != null && 
                    datosBasicosUsuario.getUsuario() != null && 
                    datosBasicosUsuario.getUsuario().getHuslnumero() != null) {
                    try {
                        primeraConsulta = 
                                this.getServiceLocator().getClinicoService().esPrimeraConsulta(datosBasicosUsuario.getUsuario());
                    } catch (ModelException e) {
                        e.printStackTrace();
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
        cuestionarioCovid.setNextAction(BeanNavegacion.RUTA_IR_MOTIVO_ESTERILIZACION);
        cuestionarioCovid.setMenuBean(nombreMenuBean);
        cuestionarioCovid.inicializarCuestionario();
        renderMotivo= cuestionarioCovid.esValido();

        // MOTIVO DE CONSULTA
        motivoConsulta = (MotivoBean)FacesUtils.getManagedBean("motivoBean");
        motivoConsulta.setTipoServicio(TIPO_CONSULTA);
        motivoConsulta.setNumeroConsulta(numeroConsulta);
        motivoConsulta.setNextAction(BeanNavegacion.RUTA_IR_CUESTIONARIO_ESTERILIZACION);
        motivoConsulta.setMenuBean(nombreMenuBean);
        motivoConsulta.setCausaSelect(IConstantes.CAUSA_OTRA);
        motivoConsulta.setOcultarasesoria(true);
        motivoConsulta.setFinalidadSelect(IConstantes.FINALIDAD_CONSULTA_PLANIFICACION);
        motivoConsulta.inicializarMotivo();
        renderCuestionario = motivoConsulta.esValido();
        
        // CUESTIONARIO
        esterilizacionFemeninaBean = 
                (EsterilizacionFemeninaBean)FacesUtils.getManagedBean("esterFemeninaBean");
        esterilizacionFemeninaBean.setTipoServicio(TIPO_CONSULTA);
        esterilizacionFemeninaBean.setUsuario(datosBasicosUsuario.getUsuario());
        esterilizacionFemeninaBean.setConsulta(datosBasicosUsuario.getConsulta());
        esterilizacionFemeninaBean.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_ESTERILIZACION);
        if (primeraConsulta) {
          esterilizacionFemeninaBean.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_GENERALES_ESTERILIZACION);
            }
        esterilizacionFemeninaBean.setMenuBean(nombreMenuBean);
        esterilizacionFemeninaBean.inicializarEsterilizacionFem();
        renderAntecedentesGenerales = esterilizacionFemeninaBean.esValido();
        
        
        if (!primeraConsulta) {
                 antecedentes = 
                         (AntecedentesUsuarioBean)FacesUtils.getManagedBean("antecedentesUsuarioBean");
                 antecedentes.setTipoServicio(TIPO_CONSULTA);
                 antecedentes.setNumeroConsulta(numeroConsulta);
                 antecedentes.setTipoHistoria(HISTORIA_ESTERILIZACION_FEMENINA);
                 antecedentes.setUsuario(datosBasicosUsuario.getUsuario());
                 antecedentes.setNextAction(BeanNavegacion.RUTA_IR_ANT_GINECOLOGICOS_ESTERILIZACION);
                 antecedentes.setMenuBean(nombreMenuBean);
                 antecedentes.inicializarAntecedentes();
                 renderAntGinecologicos = antecedentes.esValido(); 
             }

             if (primeraConsulta) {
                 // ANTECEDENTES GENERALES
                 antecedentesGenerales = 
                         (AntecedentesGeneralesUsuarioBean)FacesUtils.getManagedBean("antecedentesGeneralesUsuarioBean");
                 antecedentesGenerales.setTipoServicio(TIPO_CONSULTA);
                 antecedentesGenerales.setTipoHistoria(HISTORIA_ESTERILIZACION_FEMENINA);
                 antecedentesGenerales.setNumeroConsulta(numeroConsulta);
                 antecedentesGenerales.setNextAction(BeanNavegacion.RUTA_IR_ANT_GINECOLOGICOS_ESTERILIZACION);
                 antecedentesGenerales.setMenuBean(nombreMenuBean);
                  antecedentesGenerales.inicializarAntecedentes();
                 renderAntGinecologicos = antecedentesGenerales.esValido(); 
             }

    
        // ANTECEDENTES GINECOLOGICOS
         antecedentesGinecologicos = 
                 (AntecedentesGinecologicosUsuarioBean)FacesUtils.getManagedBean("antecedentesGinecologicosUsuarioBean");
         antecedentesGinecologicos.setTipoServicio(TIPO_CONSULTA);
         antecedentesGinecologicos.setNumeroConsulta(numeroConsulta);
         antecedentesGinecologicos.setUsuario(datosBasicosUsuario.getUsuario());
         antecedentesGinecologicos.setNextAction(BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_ESTERILIZACION);
         antecedentesGinecologicos.setMenuBean(nombreMenuBean);
         antecedentesGinecologicos.inicializarAntecedentesGinecologicos();
         renderEncuestaViolencia = antecedentesGinecologicos.esValido();

         if (antecedentesGinecologicos != null) {
             antecedenteObject = antecedentesGinecologicos.getAntecedente();
         }

        // ENCUESTA DE VIOLENCIA
        encuestaViolenciaUsuario = 
                (EncuestaViolenciaUsuarioBean)FacesUtils.getManagedBean("encuestaViolenciaUsuarioBean");
        encuestaViolenciaUsuario.setTipoServicio(TIPO_CONSULTA);
        encuestaViolenciaUsuario.setNumeroConsulta(numeroConsulta);
        encuestaViolenciaUsuario.setNextAction(BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_ESTERILIZACION_FEMENINA);
        encuestaViolenciaUsuario.setMenuBean(nombreMenuBean);
        encuestaViolenciaUsuario.inicializarEncuesta();
        renderEscalaCaidas = encuestaViolenciaUsuario.esValido();
        
        registrarEscalaValoracionCaidasBean = 
           (RegistrarEscalaValoracionCaidasCEBean)FacesUtils.getManagedBean("registrarEscalaValoracionCaidasCEBean");
           registrarEscalaValoracionCaidasBean.setNumeroConsulta(numeroConsulta);
        if (datosBasicosUsuario != null &&
           datosBasicosUsuario.getUsuario() != null && 
           datosBasicosUsuario.getUsuario().getHuslnumero() != null) {
               registrarEscalaValoracionCaidasBean.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
           }
           registrarEscalaValoracionCaidasBean.setNextAction(BeanNavegacion.RUTA_IR_EXAMEN_FISICO_ESTERILIZACION);
           registrarEscalaValoracionCaidasBean.init();
           renderExamen = registrarEscalaValoracionCaidasBean.esValido();

        // EXAMEN FISICO
        examenFisicoUsuario = 
                (ExamenFisicoUsuarioBean)FacesUtils.getManagedBean("examenFisicoUsuarioBean");
        examenFisicoUsuario.setTipoServicio(TIPO_CONSULTA);
        examenFisicoUsuario.setNumeroConsulta(numeroConsulta);
        examenFisicoUsuario.setConsecutivo(1);
        examenFisicoUsuario.setNextAction(BeanNavegacion.RUTA_IR_IMP_DIAGNOSTICA_ESTERILIZACION);
        examenFisicoUsuario.setMenuBean(nombreMenuBean);
        examenFisicoUsuario.setUsuario(datosBasicosUsuario.getUsuario());
        examenFisicoUsuario.setRenderMaculino(renderMasculino);  
        examenFisicoUsuario.inicializarExamen();
        renderImpresionDiagnostica = examenFisicoUsuario.esValido();
        
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
        impresionDiagnosticaUsuarioBean.setNextAction(BeanNavegacion.RUTA_IR_RECOMENDACIONES_ESTERILIZACION);
        impresionDiagnosticaUsuarioBean.setMenuBean(nombreMenuBean);
        impresionDiagnosticaUsuarioBean.setTipoDiagnostico(TIPO_IMPRESION_CONFIRMADO_NUEVO);
        impresionDiagnosticaUsuarioBean.setCodigoDiagnostico(DIAGNOSTICO_EXAMEN_MEDICO_GENERAL);
        impresionDiagnosticaUsuarioBean.setDesHabilitarDiagnosticoPrincipal(false);
        impresionDiagnosticaUsuarioBean.inicializarImpresion();
        renderConducta = impresionDiagnosticaUsuarioBean.esValido();
        
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
        

        // CONDUCTA - ANATOMIA PATOLOGICA
         anatomiaPatologicaUsuarioBean = 
                 (AnatomiaPatologicaUsuarioBean)FacesUtils.getManagedBean("anatomiaPatolUsuarioBean");
         anatomiaPatologicaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
         anatomiaPatologicaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
         anatomiaPatologicaUsuarioBean.setNumeroConsulta(numeroConsulta);
         anatomiaPatologicaUsuarioBean.setAntecedente(antecedenteObject);
         anatomiaPatologicaUsuarioBean.setConsecutivo(1);
         anatomiaPatologicaUsuarioBean.setMenuBean(nombreMenuBean);
         anatomiaPatologicaUsuarioBean.inicializarAnatomiaPatol();

        // CONDUCTA - CONTROL SIN COSTO
        controlSinCostoUsuarioBean = 
                (ControlSinCostoUsuarioBean)FacesUtils.getManagedBean("controlSinCostoUsuarioBean");
        controlSinCostoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        controlSinCostoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        controlSinCostoUsuarioBean.setNumeroConsulta(numeroConsulta);
        controlSinCostoUsuarioBean.setMenuBean(nombreMenuBean);
        controlSinCostoUsuarioBean.inicializarControlSinCosto();

        // CONDUCTA - FORMULA MEDICA
         formulaMedicaUsuarioBean = 
                 (FormulaMedicaUsuarioBean)FacesUtils.getManagedBean("formulaMedicaUsuarioBean");
         formulaMedicaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
         formulaMedicaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
         formulaMedicaUsuarioBean.setNumeroConsulta(numeroConsulta);
         formulaMedicaUsuarioBean.setCodigoCIE10(cie10Principal);
         formulaMedicaUsuarioBean.setConsecutivo(1);
         formulaMedicaUsuarioBean.setMenuBean(nombreMenuBean);
         formulaMedicaUsuarioBean.inicializardFormulaMedica();
         

                // CONDUCTA - FORMULA MEDICA
                vademecumUsuarioBean = (VademecumMedicoBean)FacesUtils.getManagedBean("vademecumMedicoBean");
                vademecumUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
                vademecumUsuarioBean.setTipoServicio(TIPO_CONSULTA);
                vademecumUsuarioBean.setNumeroConsulta(numeroConsulta);
                vademecumUsuarioBean.setCodigoCIE10(cie10Principal);
                vademecumUsuarioBean.setConsecutivo(1);
                vademecumUsuarioBean.setMenuBean(nombreMenuBean);
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
        hospitalizacionUsuarioBean.setMenuBean(nombreMenuBean);
        hospitalizacionUsuarioBean.inicializarHospitalizacion();

        // CONDUCTA - Cirug�as y procedimientos
        ordenCirugiaUsuarioBean = 
                (OrdenCirugiaUsuarioBean)FacesUtils.getManagedBean("ordenCirugiaUsuarioBean");
        ordenCirugiaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        ordenCirugiaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        ordenCirugiaUsuarioBean.setNumeroConsulta(numeroConsulta);
        ordenCirugiaUsuarioBean.setConsecutivo(1);
        ordenCirugiaUsuarioBean.setMenuBean(nombreMenuBean);
        ordenCirugiaUsuarioBean.setEsLigadura(true);
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
        interConsultaUsuarioBean.setMenuBean(nombreMenuBean);
        interConsultaUsuarioBean.setConsecutivo(1);
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
        incapacidadUsuarioBean.setMenuBean(nombreMenuBean);
        incapacidadUsuarioBean.setCie10Principal(cie10Principal);
        incapacidadUsuarioBean.setCie10Relacionado1(cie10Relacionado1);
        incapacidadUsuarioBean.setCodigoCups(codigoCups);
        incapacidadUsuarioBean.setConsecutivo(1);
        incapacidadUsuarioBean.inicializarIncapacidad();

        // CONDUCTA - RECOMENDACIONES
        recomedacionUsuarioBean = 
                (RecomedacionUsuarioBean)FacesUtils.getManagedBean("recomedacionUsuarioBean");
        recomedacionUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        recomedacionUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        recomedacionUsuarioBean.setNumeroConsulta(numeroConsulta);
        recomedacionUsuarioBean.setMenuBean(nombreMenuBean);
        recomedacionUsuarioBean.inicializarRecomedaciones();
        renderCerrarConsulta = recomedacionUsuarioBean.esValido(); 

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
         referenciaUsuarioBean.setMenuBean(nombreMenuBean);
         referenciaUsuarioBean.inicializarReferencia();

        // CONDUCTA - SOLICITUD RESERVA DE SANGRE
         reservaSangreUsuarioBean = 
                 (ReservaSangreUsuarioBean)FacesUtils.getManagedBean("reservaSangreUsuarioBean");
         reservaSangreUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
         reservaSangreUsuarioBean.setTipoServicio(TIPO_CONSULTA);
         reservaSangreUsuarioBean.setNumeroConsulta(numeroConsulta);
         reservaSangreUsuarioBean.setConsecutivo(1);
         reservaSangreUsuarioBean.setMenuBean(nombreMenuBean);
         reservaSangreUsuarioBean.inicializarReservaSangre();

        // CONDUCTA - CERTIFICADOS / CERTIFICADO MEDICO
         certMedicoUsuarioBean = 
                 (CertMedicoUsuarioBean)FacesUtils.getManagedBean("certMedicoUsuarioBean");
         certMedicoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
         certMedicoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
         certMedicoUsuarioBean.setNumeroConsulta(numeroConsulta);
         certMedicoUsuarioBean.setMenuBean(nombreMenuBean);
         certMedicoUsuarioBean.setConsecutivo(1);
         certMedicoUsuarioBean.setEsCirugia(false);
         certMedicoUsuarioBean.inicializarCertificadoMedico();

        // CONDUCTA - CERTIFICADOS / CERTIFICADO DE ASISTENCIA
         certAsistenciaUsuarioBean = 
                 (CertAsistenciaUsuarioBean)FacesUtils.getManagedBean("certAsistenciaUsuarioBean");
         certAsistenciaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
         certAsistenciaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
         certAsistenciaUsuarioBean.setNumeroConsulta(numeroConsulta);
         certAsistenciaUsuarioBean.setCodigoCups(codigoCups);
         certAsistenciaUsuarioBean.setConsecutivo(1);
         certAsistenciaUsuarioBean.setMenuBean(nombreMenuBean);
         certAsistenciaUsuarioBean.inicializarCertificadoAsistencia();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN ELECTROFISIOLOGICO
         examElectrofisiologicoUsuarioBean = 
                 (ExamElectrofisiologicoUsuarioBean)FacesUtils.getManagedBean("examElectrofisioUsuarioBean");
         examElectrofisiologicoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
         examElectrofisiologicoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
         examElectrofisiologicoUsuarioBean.setNumeroConsulta(numeroConsulta);
         examElectrofisiologicoUsuarioBean.setCie10Principal(cie10Principal);
         examElectrofisiologicoUsuarioBean.setConsecutivo(1);
         examElectrofisiologicoUsuarioBean.setMenuBean(nombreMenuBean);
         examElectrofisiologicoUsuarioBean.inicializarExamElectrofisiologico();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN IMAGEN
         examImagenUsuarioBean = 
                 (ExamImagenUsuarioBean)FacesUtils.getManagedBean("examImagenUsuarioBean");
         examImagenUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
         examImagenUsuarioBean.setTipoServicio(TIPO_CONSULTA);
         examImagenUsuarioBean.setNumeroConsulta(numeroConsulta);
         examImagenUsuarioBean.setAntecedente(antecedenteObject);
         examImagenUsuarioBean.setCie10Principal(cie10Principal);
         examImagenUsuarioBean.setConsecutivo(1);
         examImagenUsuarioBean.setMenuBean(nombreMenuBean);
         examImagenUsuarioBean.inicializarExamImagen();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN LABORATORIO
         examLaboratorioUsuarioBean = 
                 (ExamLaboratorioUsuarioBean)FacesUtils.getManagedBean("examLaboratorioUsuarioBean");
         examLaboratorioUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
         examLaboratorioUsuarioBean.setTipoServicio(TIPO_CONSULTA);
         examLaboratorioUsuarioBean.setNumeroConsulta(numeroConsulta);
         examLaboratorioUsuarioBean.setCie10Principal(cie10Principal);
         examLaboratorioUsuarioBean.setConsecutivo(1);
         examLaboratorioUsuarioBean.setMenuBean(nombreMenuBean);
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
         cerrarConsultaUsuarioBean.setMenuBean(nombreMenuBean);
         cerrarConsultaUsuarioBean.setConsulta(datosBasicosUsuario.getConsulta());
         cerrarConsultaUsuarioBean.setEsVacunacion(false); 
         cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
         
 

        formulaLiquidosBean = 
                (FormulaLiquidosBean)FacesUtils.getManagedBean("formulaLiquidosBean");
        formulaLiquidosBean.setUsuario(datosBasicosUsuario.getUsuario());
        formulaLiquidosBean.setTipoServicio(TIPO_CONSULTA);
        formulaLiquidosBean.setNumeroCirugia(numeroConsulta);
        formulaLiquidosBean.setNumeroUsuario(numeroUsuario);
        formulaLiquidosBean.setConsecutivo(1);
        formulaLiquidosBean.init();


        formulaHospitalizacionBean = 
                (FormulaHospitalizacionBean)FacesUtils.getManagedBean("formulaHospitalizacionBean");
        formulaHospitalizacionBean.setUsuario(datosBasicosUsuario.getUsuario());
        formulaHospitalizacionBean.setTipoServicio(TIPO_CONSULTA);
        formulaHospitalizacionBean.setNumeroCirugia(numeroConsulta);
        formulaHospitalizacionBean.setRenderProfilaxis(true);
        formulaHospitalizacionBean.setNumeroUsuario(numeroUsuario);
        formulaHospitalizacionBean.setConsecutivo(1);
        formulaHospitalizacionBean.init();
        

        otrasOrdenesBean = 
                (OtrasOrdenesBean)FacesUtils.getManagedBean("otrasOrdenesBean");

        //otrasOrdenesBean.setCirugia(evolucionMedico.getCirugia());
        otrasOrdenesBean.setConsecutivo(1);
        otrasOrdenesBean.setNumeroConsulta(numeroConsulta);
        otrasOrdenesBean.setTipoServicio(TIPO_HOSPITALIZACION);
        otrasOrdenesBean.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
        otrasOrdenesBean.init();
                

         
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
    
    public String irPausarConsultaEsterilizacionFemenina() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_PAUSAR_CONSULTA_ESTERILIZACION_FEMENINA;
    }

    public void setTrnhistoria(ExpandableTreeModel trnhistoria) {
        this.trnhistoria = trnhistoria;
    }


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

    public void inicializarUsuario() {

        if (datosBasicosUsuario.getUsuario() != null)
            this.setUsuario(datosBasicosUsuario.getUsuario());
    }

    /**
     * @return
     */
    public String irDatosEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_DATOS_ESTERILIZACION;
    }

    /**
     * @return
     */
    public String irMotivoEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_MOTIVO_ESTERILIZACION;
    }
    
    public String irCuestionarioCovidEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_ESTERILIZACION;
        }



    /**
     * @return
     */
    public String irCuestionarioEsterilizacion() {
        inicializarUsuario();
        if(esterilizacionFemeninaBean!= null){
            esterilizacionFemeninaBean.setGeneroConsentimiento(false);
        }
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_ESTERILIZACION;
    }


    /**
     * @return
     */
    public String irExamenFisicoEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EXAMEN_FISICO_ESTERILIZACION;
    }


    /**
     * @return
     */
    public String irEncuestaViolenciaEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_ESTERILIZACION;
    }


    /**
     * @return
     */
    public String irImpDiagnosticaEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMP_DIAGNOSTICA_ESTERILIZACION;
    }

    /**
     * @return
     */
    public String irAnatPatologicaEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANAT_PATOLOGICA_ESTERILIZACION;
    }

    /**
     * @return
     */
    public String irControlSinCostoEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CONTROL_SIN_COSTO_ESTERILIZACION;
    }


    /**
     * @return
     */
    public String irFormulaMedicaEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FORMULA_MEDICA_ESTERILIZACION;
    }
    
    /**
     * @return
     */
    public String irVademecumMedicoEsterelizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_VADEMCUM_SALUD_SEXUAL;
    }

    /**
     * @return
     */
    public String irRemHospitalizacionEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_REM_HOSPITALIZACION_ESTERILIZACION;
    }


    /**
     * @return
     */
    public String irOrdenCirugiaEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ORDEN_CIRUGIA_ESTERILIZACION;
    }

    /**
     * @return
     */
    public String irInterConsultaEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INTERCONSULTA_ESTERILIZACION;
    }

    /**
     * @return
     */
    public String irIncapacidadEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INCAPACIDAD_ESTERILIZACION;
    }

    /**
     * @return
     */
    public String irRecomedacionEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RECOMENDACIONES_ESTERILIZACION;
    }

    /**
     * @return
     */
    public String irReferenciaEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_REFERENCIA_ESTERILIZACION;
    }

    /**
     * @return
     */
    public String irReservaSangreEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESERVA_SANGRE_ESTERILIZACION;
    }


    /**
     * @return
     */
    public String irCertMedicoEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERT_MEDICO_ESTERILIZACION;
    }

    /**
     * @return
     */
    public String irCertAsistenciaEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERT_ASISTENCIA_ESTERILIZACION;
    }


    /**
     * @return
     */
    public String irExamElectrofisiologicoEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EXAM_ELECTROFISIOLOGICO_ESTERILIZACION;
    }

    /**
     * @return
     */
    public String irExamImagenEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EXAM_IMAGEN_ESTERILIZACION;
    }

    /**
     * @return
     */
    public String irExamLaboratorioEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EXAM_LABORATORIO_ESTERILIZACION;
    }

    /**
     * @return
     */
    public String irAntGinecologicos() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANT_GINECOLOGICOS_ESTERILIZACION;
    }

    /**
     * @return
     */
    public String irCerrarEsterilizacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERRAR_CONSULTA_ESTERILIZACION;
    }


    /**
     * @return
     */
    public String irAntecedentesGeneralesEsterilizacionFemenina() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_GENERALES_ESTERILIZACION;
        }
        

        /**
         * @return
         */
        public String irResumenHistoriaEsterilizacionFemenina() {

            inicializarUsuario();

            CerrarConsultaUsuarioBean cerrarConsultaSaludSexual = 
                (CerrarConsultaUsuarioBean)FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
            cerrarConsultaSaludSexual.inicalizarCerrarConsultaBean();

            FacesUtils.resetManagedBean("consultarFoliosBean");

            ConsultarFoliosBean generarResumen = 
                (ConsultarFoliosBean)FacesUtils.getManagedBean("consultarFoliosBean");
            if (generarResumen != null) {
                generarResumen.init();
                generarResumen.setEncabezado(true);
                generarResumen.setUsuario(datosBasicosUsuario.getUsuario());
                generarResumen.consultarFoliosUsuario();

            }
          
            return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_ESTERILIZACION_FEMENINA;
        }

        
    /**
     * @return
     */
    public String irResumenHistoriaEspecificaEsterilizacionFemenina() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_ESTERILIZACION_FEMENINA;
    }


    /**
     * @return
     */
    public String irAntecedentesEsterilizacionFemenina() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_ESTERILIZACION;
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
     * @param renderExamen
     */
    public void setRenderExamen(boolean renderExamen) {
        this.renderExamen = renderExamen;
    }

    /**
     * @return
     */
    public boolean isRenderExamen() {
        return renderExamen;
    }

    /**
     * @param renderEncuestaViolencia
     */
    public void setRenderEncuestaViolencia(boolean renderEncuestaViolencia) {
        this.renderEncuestaViolencia = renderEncuestaViolencia;
    }

    /**
     * @return
     */
    public boolean isRenderEncuestaViolencia() {
        return renderEncuestaViolencia;
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
     * @param renderCuestionario
     */
    public void setRenderCuestionario(boolean renderCuestionario) {
        this.renderCuestionario = renderCuestionario;
    }

    /**
     * @return
     */
    public boolean isRenderCuestionario() {
        return renderCuestionario;
    }

    /**
     * @param renderAntGinecologicos
     */
    public void setRenderAntGinecologicos(boolean renderAntGinecologicos) {
        this.renderAntGinecologicos = renderAntGinecologicos;
    }

    /**
     * @return
     */
    public boolean isRenderAntGinecologicos() {
        return renderAntGinecologicos;
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
     * @return
     */
    public String irOrdenMedicamentosEsterilizacion() {
        return BeanNavegacion.RUTA_IR_ORDEN_MEDICAMENTOS_ESTERILIZACION; 
    }

    /**
     * @return
     */
    public String irOrdenLiquidosEsterilizacion() {
        
        return BeanNavegacion.RUTA_IR_ORDEN_LIQUIDOS_ESTERILIZACION;
    }
    
    public String irOtrasOrdenesEsterilizacion() {
        return BeanNavegacion.RUTA_IR_OTRAS_ORDENES_ESTERILIZACION;
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


    public void setRenderCovid(boolean renderCovid) {
        this.renderCovid = renderCovid;
    }

    public boolean isRenderCovid() {
        return renderCovid;
    }
    
    /**
     * @return
     */
    public String irEscalaValoracionCaidasEsterilizacionFemenina() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_ESTERILIZACION_FEMENINA;
    }

    public void setRenderEscalaCaidas(boolean renderEscalaCaidas) {
        this.renderEscalaCaidas = renderEscalaCaidas;
    }

    public boolean isRenderEscalaCaidas() {
        return renderEscalaCaidas;
    }
}
