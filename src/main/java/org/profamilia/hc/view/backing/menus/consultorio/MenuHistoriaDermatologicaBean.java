package org.profamilia.hc.view.backing.menus.consultorio;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.view.backing.comun.PausarConsultaBean;
import org.profamilia.hc.view.backing.comun.conducta.VademecumMedicoBean;
import javax.faces.application.ViewHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.model.SelectItem;

import org.apache.commons.codec.binary.Base64;
import org.apache.myfaces.custom.tree2.TreeNode;
import org.apache.myfaces.custom.tree2.TreeNodeBase;

import org.apache.myfaces.renderkit.html.util.AddResource;
import org.apache.myfaces.renderkit.html.util.AddResourceFactory;

import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosBean;
import org.profamilia.hc.view.backing.comun.AntecedentesGeneralesUsuarioBean;
import org.profamilia.hc.view.backing.comun.AntecedentesUsuarioBean;
import org.profamilia.hc.view.backing.comun.CerrarConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.EncuestaViolenciaUsuarioBean;
import org.profamilia.hc.view.backing.comun.ExamenFisicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.ImpresionDiagnosticaUsuarioBean;
import org.profamilia.hc.view.backing.comun.MotivoBean;
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
import org.profamilia.hc.view.backing.cirugia.registro.OtrasOrdenesCEBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaHospitalizacionBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaLiquidosBean;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;
import org.profamilia.hc.view.backing.comun.RegistrarEscalaValoracionCaidasCEBean;


public class MenuHistoriaDermatologicaBean extends BaseBean {

    private DatosBasicosUsuarioBean datosBasicosUsuario;

    private MotivoBean motivoConsulta;

    private AntecedentesUsuarioBean antecedentes;

    private AntecedentesGeneralesUsuarioBean antecedentesGenerales;

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

    private CerrarConsultaUsuarioBean cerrarConsultaUsuarioBean;

    private ExpandableTreeModel trnhistoria;

    private ResumenHistoriaEspecificaBean resumenEspecifico;
    
    private AutorizacionServicioUsuarioBean autorizacionServicioUsuarioBean;

    private String javaScriptText;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private boolean renderMotivo;

    private boolean renderAntecedentesGenerales;

    private boolean renderExamen;

    private boolean renderEncuestaViolencia;

    private boolean renderImpresionDiagnostica;

    private boolean renderConducta;

    private boolean renderCerrarConsulta;

    private boolean primeraConsulta;

    private Long numeroConsulta;

    private String cie10Principal;

    private String cie10Relacionado1;

    private String codigoCups;

    private Chantegineco antecedenteObject;
    
    
    private VademecumMedicoBean vademecumUsuarioBean;

    private boolean renderVademecum;
    
    private boolean renderPausarConsulta;
                
    private PausarConsultaBean pausarConsulta;
    
    private boolean tiempoAtencion;
	
	private ConfirmarServiciosAdmisionBean confirmarServiciosAdmision;
			
	private boolean renderServiciosAdmision;
        
    private CuestionarioCovidBean cuestionarioCovid;
    
    private boolean renderCovid;
    
    private RegistrarEscalaValoracionCaidasCEBean registrarEscalaValoracionCaidasBean;
    
    private boolean renderEscalaCaidas;
    
    private List<SelectItem>lstPatologia;
    
    private boolean renderOrdenesMedicas;
    
    private FormulaLiquidosBean formulaLiquidosBean;
    
    private FormulaHospitalizacionBean formulaHospitalizacionBean;  

    private OtrasOrdenesBean otrasOrdenesBean;


    public void init() {
        primeraConsulta = false;

        String tensionArterial = null;
        Integer frecuenciaCardiaca = null;
        Integer frecuenciaRespiratoria = null;
        BigDecimal peso = null;
        String hallazgos = null;
        BigDecimal temperatura = null;
        renderOrdenesMedicas = true;
        
        boolean renderMasculino; 
        renderMasculino = false;   
        renderVademecum = true; 
        renderPausarConsulta=false;
		renderServiciosAdmision =false;
        renderEscalaCaidas = false;
        // DATOS BASICOS USUARIO
        datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_OTRAS_ESPECIALIDADES);
        datosBasicosUsuario.setMenuBean("menuHistoriaDermatologicaBean");
        renderOrdenesMedicas = datosBasicosUsuario.esValido();
        renderCovid = datosBasicosUsuario.esValido();
        if(IConstantes.ACTIVAR_PAUSAR_CONSULTA){
        renderPausarConsulta = datosBasicosUsuario.esValido();
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
        cuestionarioCovid.setNextAction(BeanNavegacion.RUTA_IR_MOTIVO_OTRAS_ESPECIALIDADES);
        cuestionarioCovid.setMenuBean("menuHistoriaDermatologicaBean");
        cuestionarioCovid.inicializarCuestionario();
        renderMotivo= cuestionarioCovid.esValido();
           
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
        motivoConsulta = (MotivoBean)FacesUtils.getManagedBean("motivoBean");
        motivoConsulta.setTipoServicio(TIPO_CONSULTA);
        motivoConsulta.setNumeroConsulta(numeroConsulta);
        motivoConsulta.setLstPatologias(getLstPatologia());
        motivoConsulta.setOcultarasesoria(true);
        motivoConsulta.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_OTRAS_ESPECIALIDADES);
        if (primeraConsulta) {
            motivoConsulta.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_GENERALES_OTRAS_ESPECIALIDADES);
        }

        motivoConsulta.setMenuBean("menuHistoriaDermatologicaBean");
        motivoConsulta.inicializarMotivo();
        renderAntecedentesGenerales = motivoConsulta.esValido();


        // ANTECEDENTES

        if (!primeraConsulta) {
            antecedentes = 
                    (AntecedentesUsuarioBean)FacesUtils.getManagedBean("antecedentesUsuarioBean");
            antecedentes.setTipoServicio(TIPO_CONSULTA);
            antecedentes.setNumeroConsulta(numeroConsulta);
            antecedentes.setTipoHistoria(HISTORIA_OTRAS_ESPECIALIDADES);
            antecedentes.setUsuario(datosBasicosUsuario.getUsuario());
            antecedentes.setNextAction(BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_OTRAS_ESPECIALIDADES);
            antecedentes.setMenuBean("menuHistoriaDermatologicaBean");
            antecedentes.inicializarAntecedentes();
            renderEncuestaViolencia = antecedentes.esValido(); 
        }

        if (primeraConsulta) {
            // ANTECEDENTES GENERALES
            antecedentesGenerales = 
                    (AntecedentesGeneralesUsuarioBean)FacesUtils.getManagedBean("antecedentesGeneralesUsuarioBean");
            antecedentesGenerales.setTipoServicio(TIPO_CONSULTA);
            antecedentesGenerales.setTipoHistoria(HISTORIA_OTRAS_ESPECIALIDADES);
            antecedentesGenerales.setNumeroConsulta(numeroConsulta);
            antecedentesGenerales.setNextAction(BeanNavegacion.RUTA_IR_EXAMENFISICO_OTRAS_ESPECIALIDADES);
            antecedentesGenerales.setMenuBean("menuHistoriaDermatologicaBean");
            antecedentesGenerales.setNextAction(BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_OTRAS_ESPECIALIDADES);
            antecedentesGenerales.inicializarAntecedentes();
            renderEncuestaViolencia = antecedentesGenerales.esValido(); 

        }

        // ENCUESTA DE VIOLENCIA
        encuestaViolenciaUsuario = 
                (EncuestaViolenciaUsuarioBean)FacesUtils.getManagedBean("encuestaViolenciaUsuarioBean");
        encuestaViolenciaUsuario.setTipoServicio(TIPO_CONSULTA);
        encuestaViolenciaUsuario.setNumeroConsulta(numeroConsulta);
        encuestaViolenciaUsuario.setNextAction(BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_OTRAS_ESPECIALIDADES);
        encuestaViolenciaUsuario.setMenuBean("menuHistoriaDermatologicaBean");
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
           registrarEscalaValoracionCaidasBean.setMenuBean("menuHistoriaDermatologicaBean");
           registrarEscalaValoracionCaidasBean.setNextAction(BeanNavegacion.RUTA_IR_EXAMENFISICO_OTRAS_ESPECIALIDADES);
           registrarEscalaValoracionCaidasBean.init();
            renderExamen = registrarEscalaValoracionCaidasBean.esValido();


        // EXAMEN FISICO
        examenFisicoUsuario = 
                (ExamenFisicoUsuarioBean)FacesUtils.getManagedBean("examenFisicoUsuarioBean");
        examenFisicoUsuario.setTipoServicio(TIPO_CONSULTA);
        examenFisicoUsuario.setNumeroConsulta(numeroConsulta);
        examenFisicoUsuario.setConsecutivo(1);
        examenFisicoUsuario.setNextAction(BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_OTRAS_ESPECIALIDADES);
        examenFisicoUsuario.setMenuBean("menuHistoriaDermatologicaBean");
        examenFisicoUsuario.setRenderMaculino(renderMasculino);  
        examenFisicoUsuario.setUsuario(datosBasicosUsuario.getUsuario());
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
        impresionDiagnosticaUsuarioBean.setDesHabilitarDiagnosticoPrincipal(false);
        impresionDiagnosticaUsuarioBean.setRenderColposcopia(false);
        impresionDiagnosticaUsuarioBean.setCodigoRelacionado3("");
        impresionDiagnosticaUsuarioBean.setNextAction(BeanNavegacion.RUTA_IR_RECOMENDACIONES_OTRAS_ESPECIALIDADES);
        impresionDiagnosticaUsuarioBean.setMenuBean("menuHistoriaDermatologicaBean");
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


        // CONDUCTA - RECOMENDACIONES
        recomedacionUsuarioBean = 
                (RecomedacionUsuarioBean)FacesUtils.getManagedBean("recomedacionUsuarioBean");
        recomedacionUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        recomedacionUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        recomedacionUsuarioBean.setNumeroConsulta(numeroConsulta);
        recomedacionUsuarioBean.setMenuBean("menuHistoriaDermatologicaBean");
        recomedacionUsuarioBean.inicializarRecomedaciones();
        renderCerrarConsulta = recomedacionUsuarioBean.esValido();


        // CONDUCTA - ANATOMIA PATOLOGICA
        anatomiaPatologicaUsuarioBean = 
                (AnatomiaPatologicaUsuarioBean)FacesUtils.getManagedBean("anatomiaPatolUsuarioBean");
        anatomiaPatologicaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        anatomiaPatologicaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        anatomiaPatologicaUsuarioBean.setNumeroConsulta(numeroConsulta);
        anatomiaPatologicaUsuarioBean.setAntecedente(antecedenteObject);
        anatomiaPatologicaUsuarioBean.setConsecutivo(1);
        anatomiaPatologicaUsuarioBean.setMenuBean("menuHistoriaDermatologicaBean");
        anatomiaPatologicaUsuarioBean.inicializarAnatomiaPatol();


        // CONDUCTA - CONTROL SIN COSTO
        controlSinCostoUsuarioBean = 
                (ControlSinCostoUsuarioBean)FacesUtils.getManagedBean("controlSinCostoUsuarioBean");
        controlSinCostoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        controlSinCostoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        controlSinCostoUsuarioBean.setCodigoCups(codigoCups);
        controlSinCostoUsuarioBean.setNumeroConsulta(numeroConsulta);
        controlSinCostoUsuarioBean.setMenuBean("menuHistoriaDermatologicaBean");
        controlSinCostoUsuarioBean.inicializarControlSinCosto();

        // CONDUCTA - FORMULA MEDICA
        formulaMedicaUsuarioBean = 
                (FormulaMedicaUsuarioBean)FacesUtils.getManagedBean("formulaMedicaUsuarioBean");
        formulaMedicaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        formulaMedicaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        formulaMedicaUsuarioBean.setNumeroConsulta(numeroConsulta);
        formulaMedicaUsuarioBean.setCodigoCIE10(cie10Principal);
        formulaMedicaUsuarioBean.setConsecutivo(1);
        formulaMedicaUsuarioBean.setMenuBean("menuHistoriaDermatologicaBean");
        formulaMedicaUsuarioBean.inicializardFormulaMedica();
        

                // CONDUCTA - FORMULA MEDICA
                vademecumUsuarioBean = (VademecumMedicoBean)FacesUtils.getManagedBean("vademecumMedicoBean");
                vademecumUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
                vademecumUsuarioBean.setTipoServicio(TIPO_CONSULTA);
                vademecumUsuarioBean.setNumeroConsulta(numeroConsulta);
                vademecumUsuarioBean.setCodigoCIE10(cie10Principal);
                vademecumUsuarioBean.setConsecutivo(1);
                vademecumUsuarioBean.setMenuBean("menuHistoriaDermatologicaBean");
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
        hospitalizacionUsuarioBean.setMenuBean("menuHistoriaDermatologicaBean");
        hospitalizacionUsuarioBean.inicializarHospitalizacion();

        // CONDUCTA - Cirug�as y procedimientos
        ordenCirugiaUsuarioBean = 
                (OrdenCirugiaUsuarioBean)FacesUtils.getManagedBean("ordenCirugiaUsuarioBean");
        ordenCirugiaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        ordenCirugiaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        ordenCirugiaUsuarioBean.setNumeroConsulta(numeroConsulta);
        ordenCirugiaUsuarioBean.setMenuBean("menuHistoriaDermatologicaBean");
        ordenCirugiaUsuarioBean.setConsecutivo(1);
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
        interConsultaUsuarioBean.setMenuBean("menuHistoriaDermatologicaBean");
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
        incapacidadUsuarioBean.setMenuBean("menuHistoriaDermatologicaBean");
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
        referenciaUsuarioBean.setMenuBean("menuHistoriaDermatologicaBean");
        referenciaUsuarioBean.inicializarReferencia();
        
        // CONDUCTA - AUTORIZACION DE SERVICIOS
        
         autorizacionServicioUsuarioBean =
                 (AutorizacionServicioUsuarioBean)FacesUtils.getManagedBean("autorizacionServicioUsuarioBean");
         autorizacionServicioUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
         
         autorizacionServicioUsuarioBean.setTipoServicio(TIPO_CONSULTA);
         autorizacionServicioUsuarioBean.setNumeroConsulta(numeroConsulta);
         //autorizacionServicioUsuarioBean.setTipoHistoria(motivoConsulta.getTipoHistoria());
         autorizacionServicioUsuarioBean.setOrigenAtencion(motivoConsulta.getCausaSelect());  
         autorizacionServicioUsuarioBean.setCodigoCups(codigoCups);
         autorizacionServicioUsuarioBean.setTipoDiagnostico(impresionDiagnosticaUsuarioBean.getImpresion().getHidntipodiagn());
         autorizacionServicioUsuarioBean.setCodigoDiagnostico(impresionDiagnosticaUsuarioBean.getImpresion().getHidcdiagprin());
         autorizacionServicioUsuarioBean.setCodigoDiagnostico1(impresionDiagnosticaUsuarioBean.getImpresion().getHidcdiagrela2());
         autorizacionServicioUsuarioBean.setCodigoDiagnostico2(impresionDiagnosticaUsuarioBean.getImpresion().getHidcdiagrela3());
         autorizacionServicioUsuarioBean.setMenuBean("menuHistoriaDermatologicaBean");
         autorizacionServicioUsuarioBean.inicializarAutorizacionServicio();


        // CONDUCTA - SOLICITUD RESERVA DE SANGRE
        reservaSangreUsuarioBean = 
                (ReservaSangreUsuarioBean)FacesUtils.getManagedBean("reservaSangreUsuarioBean");
        reservaSangreUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        reservaSangreUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        reservaSangreUsuarioBean.setNumeroConsulta(numeroConsulta);
        reservaSangreUsuarioBean.setConsecutivo(1);
        reservaSangreUsuarioBean.setMenuBean("menuHistoriaDermatologicaBean");
        reservaSangreUsuarioBean.inicializarReservaSangre();

        // CONDUCTA - CERTIFICADOS / CERTIFICADO MEDICO
        certMedicoUsuarioBean = 
                (CertMedicoUsuarioBean)FacesUtils.getManagedBean("certMedicoUsuarioBean");
        certMedicoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        certMedicoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        certMedicoUsuarioBean.setNumeroConsulta(numeroConsulta);
        certMedicoUsuarioBean.setMenuBean("menuHistoriaDermatologicaBean");
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
        certAsistenciaUsuarioBean.setMenuBean("menuHistoriaDermatologicaBean");
        certAsistenciaUsuarioBean.inicializarCertificadoAsistencia();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN ELECTROFISIOLOGICO
        examElectrofisiologicoUsuarioBean = 
                (ExamElectrofisiologicoUsuarioBean)FacesUtils.getManagedBean("examElectrofisioUsuarioBean");
        examElectrofisiologicoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        examElectrofisiologicoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        examElectrofisiologicoUsuarioBean.setNumeroConsulta(numeroConsulta);
        examElectrofisiologicoUsuarioBean.setCie10Principal(cie10Principal);
        examElectrofisiologicoUsuarioBean.setConsecutivo(1);
        examElectrofisiologicoUsuarioBean.setMenuBean("menuHistoriaDermatologicaBean");
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
        examImagenUsuarioBean.setMenuBean("menuHistoriaDermatologicaBean");
        examImagenUsuarioBean.inicializarExamImagen();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN LABORATORIO
        examLaboratorioUsuarioBean = 
                (ExamLaboratorioUsuarioBean)FacesUtils.getManagedBean("examLaboratorioUsuarioBean");
        examLaboratorioUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        examLaboratorioUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        examLaboratorioUsuarioBean.setNumeroConsulta(numeroConsulta);
        examLaboratorioUsuarioBean.setCie10Principal(cie10Principal);
        examLaboratorioUsuarioBean.setConsecutivo(1);
        examLaboratorioUsuarioBean.setMenuBean("menuHistoriaDermatologicaBean");
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
        cerrarConsultaUsuarioBean.setMenuBean("menuHistoriaDermatologicaBean");
        cerrarConsultaUsuarioBean.setConsulta(datosBasicosUsuario.getConsulta());
        cerrarConsultaUsuarioBean.setEsVacunacion(false); 
        cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();


        //RESUMEN DE LA HISTORIA CLINICA

        resumenEspecifico = 
                (ResumenHistoriaEspecificaBean)FacesUtils.getManagedBean("resumenHistoriaEspecificaBean");
        resumenEspecifico.setUsuario(datosBasicosUsuario.getUsuario());
        
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
        otrasOrdenesBean.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
        otrasOrdenesBean.init();


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

    public String irPausarConsultaOtrasEspecialidades() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_PAUSAR_CONSULTA_OTRAS_ESPECIALIDADES;
    }

    /**
     * @return
     */
    public String irDatosDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_DATOS_OTRAS_ESPECIALIDADES;
    }

    /**
     * @return
     */
    public String irMotivoDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_MOTIVO_OTRAS_ESPECIALIDADES;
    }
    
    public String irCuestionarioCovidDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_OTRAS_ESPECIALIDADES;
        }



    /**
     * @return
     */
    public String irAntecedentesGeneralesDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_GENERALES_OTRAS_ESPECIALIDADES;
    }


    /**
     * @return
     */
    public String irAntecedentesDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_OTRAS_ESPECIALIDADES;
    }


    /**
     * @return
     */
    public String irExamenFisicoDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EXAMENFISICO_OTRAS_ESPECIALIDADES;
    }


    /**
     * @return
     */
    public String irEncuestaViolenciaDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_OTRAS_ESPECIALIDADES;
    }


    /**
     * @return
     */
    public String irImpDiagnosticaDermatologia() {

        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_OTRAS_ESPECIALIDADES;
    }

    /**
     * @return
     */
    public String irAnatPatologicaDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANATOMIAPATOLOGICA_OTRAS_ESPECIALIDADES;
    }

    /**
     * @return
     */
    public String irControlSinCostoDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CONTOLSINCOSTO_OTRAS_ESPECIALIDADES;
    }


    /**
     * @return
     */
    public String irFormulaMedicaDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FORMULAMEDICA_OTRAS_ESPECIALIDADES;
    }
    
    /**
     * @return
     */
    public String irVademecumMedicoDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_VADEMCUM_OTRAS_ESPECIALIDADES;
    }

    /**
     * @return
     */
    public String irRemHospitalizacionDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_HOSPITALZACION_OTRAS_ESPECIALIDADES;
    }


    /**
     * @return
     */
    public String irIncapacidadDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INCAPACIDAD_OTRAS_ESPECIALIDADES;
    }


    /**
     * @return
     */
    public String irInterConsultaDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INTERCONSULTA_OTRAS_ESPECIALIDADES;
    }


    /**
     * @return
     */
    public String irOrdenCirugiaDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ORDENCIRUGIA_OTRAS_ESPECIALIDADES;
    }


    /**
     * @return
     */
    public String irReferenciaDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_REFERENCIA_OTRAS_ESPECIALIDADES;
    }
    
    /**
     * 
     * @return
     */
    public String irAutorizacionServicioDermatologia(){
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_AUTORIZACION_SERVICIO_OTRAS_ESPECIALIDADES;
    }

    /**
     * @return
     */
    public String irReservaSangreDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESERVA_SANGRE_OTRAS_ESPECIALIDADES;
    }


    /**
     * @return
     */
    public String irRecomedacionDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RECOMENDACIONES_OTRAS_ESPECIALIDADES;
    }


    /**
     * @return
     */
    public String irCertMedicoDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADOMEDICO_OTRAS_ESPECIALIDADES;
    }

    /**
     * @return
     */
    public String irCertAsistenciaDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADO_ASISTENCIA_OTRAS_ESPECIALIDADES;
    }

    /**
     * @return
     */
    public String irExamElectrofisiologicoDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ELECTROFISIOLOGICO_OTRAS_ESPECIALIDADES;
    }

    /**
     * @return
     */
    public String irExamImagenDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMAGENES_OTRAS_ESPECIALIDADES;
    }

    /**
     * @return
     */
    public String irExamLaboratorioDermatologia() {
        inicializarUsuario();

        return BeanNavegacion.RUTA_IR_LABORATORIO_OTRAS_ESPECIALIDADES;
    }


    /**
     * @return
     */
    public String irCerrarConsultaDermatologia() {
        if (cerrarConsultaUsuarioBean != null) {
            cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
        }
        return BeanNavegacion.RUTA_IR_CERRAR_CONSULTA_OTRAS_ESPECIALIDADES;
    }


    /**
     * @return
     */
    public String irResumenHistoriaEspecificaDermatologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_OTRAS_ESPECIALIDADES;
    }

    /**
     * @return
     */
    public String irResumenHistoriaDermatologia() {

        inicializarUsuario();

        CerrarConsultaUsuarioBean cerrarConsultaDermatologia = 
            (CerrarConsultaUsuarioBean)FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
        cerrarConsultaDermatologia.inicalizarCerrarConsultaBean();

        FacesUtils.resetManagedBean("consultarFoliosBean");

        ConsultarFoliosBean generarResumen = 
            (ConsultarFoliosBean)FacesUtils.getManagedBean("consultarFoliosBean");
        if (generarResumen != null) {
            generarResumen.init();
            generarResumen.setEncabezado(true);
            generarResumen.setUsuario(datosBasicosUsuario.getUsuario());
            generarResumen.consultarFoliosUsuario();

        }
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_OTRAS_ESPECIALIDADES;
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
	
	public String irServiciosAdmisionOtrasEspecialidades() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_SERVICIOS_ADMISION_OTRAS_ESPECIALIDADES;
    }
    /**
    * @return
    */
    public String irOrdenMedicamentosDermatologia() {
       return BeanNavegacion.RUTA_IR_ORDEN_MEDICAMENTOS_OTRAS_ESPECIALIDADES; 
    }

    /**
    * @return
    */
    public String irOrdenLiquidosDermatologia() {
       
       return BeanNavegacion.RUTA_IR_ORDEN_LIQUIDOS_OTRAS_ESPECIALIDADES;
    }
    
    public String irRegistrarOtrasOrdenesDermatologia() {
       return BeanNavegacion.RUTA_IR_OTRAS_ORDENES_OTRAS_ESPECIALIDADES;
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
    public String irEscalaValoracionCaidasOtrasEspecialidades() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_OTRAS_ESPECIALIDADES;
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


    public void setRenderOrdenesMedicas(boolean renderOrdenesMedicas) {
        this.renderOrdenesMedicas = renderOrdenesMedicas;
    }

    public boolean isRenderOrdenesMedicas() {
        return renderOrdenesMedicas;
    }
}
