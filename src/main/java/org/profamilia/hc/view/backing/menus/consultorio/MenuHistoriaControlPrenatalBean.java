package org.profamilia.hc.view.backing.menus.consultorio;

import java.math.BigDecimal;

import java.util.ArrayList;

import org.profamilia.hc.view.backing.comun.conducta.VademecumMedicoBean;

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
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosBean;
import org.profamilia.hc.view.backing.comun.CerrarConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.EncuestaViolenciaUsuarioBean;
import org.profamilia.hc.view.backing.comun.ExamenFisicoPrenatalUsuarioBean;
import org.profamilia.hc.view.backing.comun.GestacionControlPranatalUsuarioBean;
import org.profamilia.hc.view.backing.comun.ImpresionDiagnosticaUsuarioBean;
import org.profamilia.hc.view.backing.comun.MotivoBean;
import org.profamilia.hc.view.backing.comun.PausarConsultaBean;
import org.profamilia.hc.view.backing.comun.TamizajePrenatalUsuarioBean;
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
import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;
import org.profamilia.hc.view.backing.comun.RegistrarEscalaValoracionCaidasCEBean;


public class MenuHistoriaControlPrenatalBean extends BaseBean {

    private DatosBasicosUsuarioBean datosBasicosUsuario;

    private MotivoBean motivoConsulta;

    private ExamenFisicoPrenatalUsuarioBean examenFisicoUsuario;

    private GestacionControlPranatalUsuarioBean gestacionBean;

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

    private TamizajePrenatalUsuarioBean tamizajeBean;

    private ExpandableTreeModel trnhistoria;

    private CerrarConsultaUsuarioBean cerrarConsultaUsuarioBean;

    private ResumenHistoriaEspecificaBean resumenEspecifico;


    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private boolean renderMotivo;

    private boolean renderExamen;

    private boolean renderEncuestaViolencia;

    private boolean renderImpresionDiagnostica;

    private boolean renderConducta;

    private boolean renderCerrarConsulta;

    private boolean primeraConsulta;

    private boolean renderAntecedentesTemporales;

    private boolean renderAntecedentesPrenatal;


    private boolean renderTamizajePrenatal;

    private boolean renderGestacionControlPrenatal;

    /** Almacena el codigo de la consulta principal*/
    private Long codigoHistoriaPrincipal;

    private Long numeroConsulta;

    private String sexo;

    private String cie10Principal;

    private String cie10Relacionado1;

    private String codigoCups;

    String tensionArterial = null;

    Integer frecuenciaCardiaca = null;

    Integer frecuenciaRespiratoria = null;

    BigDecimal peso = null;

    BigDecimal temperatura = null;
    
    private String javaScriptText;
    
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


    public void init() { 
    
        Double semanaEmbarazo = null; 
        Date fechaUltimaRegla = null;
		renderServiciosAdmision =false;		
        
        primeraConsulta = false;
        renderVademecum = true;
        
        renderEscalaCaidas = false;
              
        // DATOS BASICOS USUARIO
        datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_CONTROL_PRENATAL);
        datosBasicosUsuario.setMenuBean("menuHistoriaControlPrenatal");
        renderCovid = datosBasicosUsuario.esValido();

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
            sexo = datosBasicosUsuario.getUsuario().getHusesexo();
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


        // MOTIVO DE CONSULTA
        
        try {
        if(datosBasicosUsuario!= null && datosBasicosUsuario.getUsuario()!= null && datosBasicosUsuario.getUsuario().getHuslnumero()!=null){
            codigoHistoriaPrincipal =
                                this.serviceLocator.getClinicoService().getConsultaPrenatalPrincipal(datosBasicosUsuario.getUsuario().getHuslnumero()); 
        }
           
        } catch (ModelException e) {
            e.printStackTrace();
        }
        
        
        if (codigoHistoriaPrincipal != null) {
            try {
                fechaUltimaRegla =
                    this.serviceLocator.getClinicoService().getFechaUltimoPeriodo(codigoHistoriaPrincipal);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        
        
        if(fechaUltimaRegla!= null){
            semanaEmbarazo = calcularSemanasEmbarazo(fechaUltimaRegla);
        }
        
        cuestionarioCovid = (CuestionarioCovidBean)FacesUtils.getManagedBean("cuestionarioCovidBean");
        cuestionarioCovid.setTipoServicio(TIPO_CONSULTA);
        cuestionarioCovid.setNumeroConsulta(numeroConsulta);
        if(datosBasicosUsuario != null && datosBasicosUsuario.getUsuario() != null && datosBasicosUsuario.getUsuario().getHuslnumero() != null ){
            cuestionarioCovid.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
        }
        cuestionarioCovid.setNextAction(BeanNavegacion.RUTA_IR_MOTIVO_CONTROL_PRENATAL);
        cuestionarioCovid.setMenuBean("menuHistoriaControlPrenatal");
        cuestionarioCovid.inicializarCuestionario();
        renderMotivo= cuestionarioCovid.esValido();

        
        motivoConsulta = (MotivoBean)FacesUtils.getManagedBean("motivoBean");
        motivoConsulta.setTipoServicio(TIPO_CONSULTA);
        motivoConsulta.setNumeroConsulta(numeroConsulta);
        motivoConsulta.setOcultarasesoria(true);
        motivoConsulta.setNextAction(BeanNavegacion.RUTA_IR_GESTACION_CONTROL_PRENATAL);
        if (primeraConsulta) {
            motivoConsulta.setNextAction(BeanNavegacion.RUTA_IR_GESTACION_CONTROL_PRENATAL);
        }

        motivoConsulta.setMenuBean("menuHistoriaControlPrenatal");
        motivoConsulta.inicializarMotivo();
        renderGestacionControlPrenatal = motivoConsulta.esValido();
        
        
        // MOTIVO DE CONSULTA
        

        // GESTACION 

        gestacionBean = 
                (GestacionControlPranatalUsuarioBean)FacesUtils.getManagedBean("gestacionControlPranatalUsuarioBean");
        gestacionBean.setTipoServicio(TIPO_CONSULTA);
        gestacionBean.setConsulta(datosBasicosUsuario.getConsulta());
        gestacionBean.setNextAction(BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_CONTROL_PRENATAL);
        gestacionBean.setMenuBean("menuHistoriaControlPrenatal");
        gestacionBean.setUsuario(datosBasicosUsuario.getUsuario());
        gestacionBean.inicializarGestacion();
        renderEncuestaViolencia = gestacionBean.esValido();


        // ENCUESTA DE VIOLENCIA
        encuestaViolenciaUsuario = 
                (EncuestaViolenciaUsuarioBean)FacesUtils.getManagedBean("encuestaViolenciaUsuarioBean");
        encuestaViolenciaUsuario.setTipoServicio(TIPO_CONSULTA);
        encuestaViolenciaUsuario.setNumeroConsulta(numeroConsulta);
        encuestaViolenciaUsuario.setNextAction(BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_CONTROL_PRENATAL);
        encuestaViolenciaUsuario.setMenuBean("menuHistoriaControlPrenatal");
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
           registrarEscalaValoracionCaidasBean.setMenuBean("menuHistoriaControlPrenatal");
           registrarEscalaValoracionCaidasBean.setNextAction(BeanNavegacion.RUTA_IR_EXAMENFISICO_CONTROL_PRENATAL);
           registrarEscalaValoracionCaidasBean.init();
           renderExamen = registrarEscalaValoracionCaidasBean.esValido();



        // EXAMEN FISICO
        examenFisicoUsuario = 
                (ExamenFisicoPrenatalUsuarioBean)FacesUtils.getManagedBean("examenFisicoPrenatalUsuarioBean");
        examenFisicoUsuario.setTipoServicio(TIPO_CONSULTA);
        examenFisicoUsuario.setNumeroConsulta(numeroConsulta);
        examenFisicoUsuario.setNextAction(BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_CONTROL_PRENATAL);
        examenFisicoUsuario.setMenuBean("menuHistoriaControlPrenatal");
        examenFisicoUsuario.setUsuario(datosBasicosUsuario.getUsuario());
        examenFisicoUsuario.setSemanaGestacion(semanaEmbarazo);
        examenFisicoUsuario.setCodigoHistoriaPrincipal(codigoHistoriaPrincipal);
        examenFisicoUsuario.inicializarExamen();
        renderImpresionDiagnostica = examenFisicoUsuario.esValido();

        if (examenFisicoUsuario != null && 
            examenFisicoUsuario.getControl()!= null) {
            tensionArterial = 
                    examenFisicoUsuario.getControl().getHcpcpresart1() + "/" + 
                    examenFisicoUsuario.getControl().getHcpcpresart2();

            frecuenciaCardiaca = 
                    examenFisicoUsuario.getControl().getHcpnfreccard();

            frecuenciaRespiratoria = 
                    examenFisicoUsuario.getControl().getHcpnfrecresp();

            peso = examenFisicoUsuario.getControl().getHcpapeso();

            

            temperatura = examenFisicoUsuario.getControl().getHcpatemperatu();
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
        impresionDiagnosticaUsuarioBean.setNextAction(BeanNavegacion.RUTA_IR_TAMIZAJE_CONTROL_PRENATAL);
        impresionDiagnosticaUsuarioBean.setMenuBean("menuHistoriaControlPrenatal");
        impresionDiagnosticaUsuarioBean.setDesHabilitarDiagnosticoPrincipal(false);
        impresionDiagnosticaUsuarioBean.inicializarImpresion();
        renderTamizajePrenatal = impresionDiagnosticaUsuarioBean.esValido();

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


        //TAMIZAJE PRENATAL

        tamizajeBean = 
                (TamizajePrenatalUsuarioBean)FacesUtils.getManagedBean("tamizajePrenatalUsuarioBean");
        tamizajeBean.setUsuario(datosBasicosUsuario.getUsuario());
        tamizajeBean.setTipoServicio(TIPO_CONSULTA);
        tamizajeBean.setConsulta(datosBasicosUsuario.getConsulta());
        tamizajeBean.setCodigoHistoriaPrincipal(codigoHistoriaPrincipal);
        tamizajeBean.setNextAction(BeanNavegacion.RUTA_IR_RECOMENDACIONES_CONTROL_PRENATAL);
        tamizajeBean.setMenuBean("menuHistoriaControlPrenatal");
        tamizajeBean.setUsuario(datosBasicosUsuario.getUsuario());
        tamizajeBean.inicializarTamizaje();
        renderConducta = tamizajeBean.esValido();


        // CONDUCTA RECOMENDACIONES
        recomedacionUsuarioBean = 
                (RecomedacionUsuarioBean)FacesUtils.getManagedBean("recomedacionUsuarioBean");
        recomedacionUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        recomedacionUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        recomedacionUsuarioBean.setNumeroConsulta(numeroConsulta);
        recomedacionUsuarioBean.setMenuBean("menuHistoriaControlPrenatal");
        recomedacionUsuarioBean.inicializarRecomedaciones();
        renderCerrarConsulta = recomedacionUsuarioBean.esValido();


        // CONDUCTA - ANATOMIA PATOLOGICA
        anatomiaPatologicaUsuarioBean = 
                (AnatomiaPatologicaUsuarioBean)FacesUtils.getManagedBean("anatomiaPatolUsuarioBean");
        anatomiaPatologicaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        anatomiaPatologicaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        anatomiaPatologicaUsuarioBean.setNumeroConsulta(numeroConsulta);
        anatomiaPatologicaUsuarioBean.setConsecutivo(1);
        anatomiaPatologicaUsuarioBean.setMenuBean("menuHistoriaControlPrenatal");
        anatomiaPatologicaUsuarioBean.inicializarAnatomiaPatol();


        // CONDUCTA - CONTROL SIN COSTO
        controlSinCostoUsuarioBean = 
                (ControlSinCostoUsuarioBean)FacesUtils.getManagedBean("controlSinCostoUsuarioBean");
        controlSinCostoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        controlSinCostoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        controlSinCostoUsuarioBean.setCodigoCups(codigoCups);
        controlSinCostoUsuarioBean.setNumeroConsulta(numeroConsulta);
        controlSinCostoUsuarioBean.setMenuBean("menuHistoriaControlPrenatal");
        controlSinCostoUsuarioBean.inicializarControlSinCosto();

        // CONDUCTA - FORMULA MEDICA
        formulaMedicaUsuarioBean = 
                (FormulaMedicaUsuarioBean)FacesUtils.getManagedBean("formulaMedicaUsuarioBean");
        formulaMedicaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        formulaMedicaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        formulaMedicaUsuarioBean.setNumeroConsulta(numeroConsulta);
        formulaMedicaUsuarioBean.setCodigoCIE10(cie10Principal);
        formulaMedicaUsuarioBean.setConsecutivo(1);
        formulaMedicaUsuarioBean.setMenuBean("menuHistoriaControlPrenatal");
        formulaMedicaUsuarioBean.inicializardFormulaMedica();
        

                // CONDUCTA - FORMULA MEDICA
                vademecumUsuarioBean = (VademecumMedicoBean)FacesUtils.getManagedBean("vademecumMedicoBean");
                vademecumUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
                vademecumUsuarioBean.setTipoServicio(TIPO_CONSULTA);
                vademecumUsuarioBean.setNumeroConsulta(numeroConsulta);
                vademecumUsuarioBean.setCodigoCIE10(cie10Principal);
                vademecumUsuarioBean.setConsecutivo(1);
                vademecumUsuarioBean.setMenuBean("menuHistoriaControlPrenatal");
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
        hospitalizacionUsuarioBean.setMenuBean("menuHistoriaControlPrenatal");
        hospitalizacionUsuarioBean.inicializarHospitalizacion();

        // CONDUCTA - Cirug�as y procedimientos
        ordenCirugiaUsuarioBean = 
                (OrdenCirugiaUsuarioBean)FacesUtils.getManagedBean("ordenCirugiaUsuarioBean");
        ordenCirugiaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        ordenCirugiaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        ordenCirugiaUsuarioBean.setNumeroConsulta(numeroConsulta);
        ordenCirugiaUsuarioBean.setConsecutivo(1);
        ordenCirugiaUsuarioBean.setMenuBean("menuHistoriaControlPrenatal");
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
        interConsultaUsuarioBean.setMenuBean("menuHistoriaControlPrenatal");
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
        incapacidadUsuarioBean.setMenuBean("menuHistoriaControlPrenatal");
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
        referenciaUsuarioBean.setTemperatura(temperatura);
        referenciaUsuarioBean.setConsecutivo(1);
        referenciaUsuarioBean.setMenuBean("menuHistoriaControlPrenatal");
        referenciaUsuarioBean.inicializarReferencia();


        // CONDUCTA - SOLICITUD RESERVA DE SANGRE
        reservaSangreUsuarioBean = 
                (ReservaSangreUsuarioBean)FacesUtils.getManagedBean("reservaSangreUsuarioBean");
        reservaSangreUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        reservaSangreUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        reservaSangreUsuarioBean.setNumeroConsulta(numeroConsulta);
        reservaSangreUsuarioBean.setConsecutivo(1);
        reservaSangreUsuarioBean.setMenuBean("menuHistoriaControlPrenatal");
        reservaSangreUsuarioBean.inicializarReservaSangre();

        // CONDUCTA - CERTIFICADOS / CERTIFICADO MEDICO
        certMedicoUsuarioBean = 
                (CertMedicoUsuarioBean)FacesUtils.getManagedBean("certMedicoUsuarioBean");
        certMedicoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        certMedicoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        certMedicoUsuarioBean.setNumeroConsulta(numeroConsulta);
        certMedicoUsuarioBean.setConsecutivo(1);
        certMedicoUsuarioBean.setMenuBean("menuHistoriaControlPrenatal");
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
        certAsistenciaUsuarioBean.setMenuBean("menuHistoriaControlPrenatal");
        certAsistenciaUsuarioBean.inicializarCertificadoAsistencia();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN ELECTROFISIOLOGICO
        examElectrofisiologicoUsuarioBean = 
                (ExamElectrofisiologicoUsuarioBean)FacesUtils.getManagedBean("examElectrofisioUsuarioBean");
        examElectrofisiologicoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        examElectrofisiologicoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        examElectrofisiologicoUsuarioBean.setNumeroConsulta(numeroConsulta);
        examElectrofisiologicoUsuarioBean.setCie10Principal(cie10Principal);
        examElectrofisiologicoUsuarioBean.setConsecutivo(1);
        examElectrofisiologicoUsuarioBean.setMenuBean("menuHistoriaControlPrenatal");
        examElectrofisiologicoUsuarioBean.inicializarExamElectrofisiologico();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN IMAGEN
        examImagenUsuarioBean = 
                (ExamImagenUsuarioBean)FacesUtils.getManagedBean("examImagenUsuarioBean");
        examImagenUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        examImagenUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        examImagenUsuarioBean.setNumeroConsulta(numeroConsulta);
        examImagenUsuarioBean.setCie10Principal(cie10Principal);
        examImagenUsuarioBean.setConsecutivo(1);
        examImagenUsuarioBean.setMenuBean("menuHistoriaControlPrenatal");
        examImagenUsuarioBean.inicializarExamImagen();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN LABORATORIO
        examLaboratorioUsuarioBean = 
                (ExamLaboratorioUsuarioBean)FacesUtils.getManagedBean("examLaboratorioUsuarioBean");
        examLaboratorioUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        examLaboratorioUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        examLaboratorioUsuarioBean.setNumeroConsulta(numeroConsulta);
        examLaboratorioUsuarioBean.setCie10Principal(cie10Principal);
        examLaboratorioUsuarioBean.setConsecutivo(1);
        examLaboratorioUsuarioBean.setMenuBean("menuHistoriaControlPrenatal");
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
        cerrarConsultaUsuarioBean.setMenuBean("menuHistoriaControlPrenatal");
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
		 
		 // SERVICIOS ADMISION
		if(IConstantes.ACTIVAR_SERVICIOS_ADMISION){
        renderServiciosAdmision = datosBasicosUsuario.esValido();
        if (renderServiciosAdmision) {
            confirmarServiciosAdmision = 
                    (ConfirmarServiciosAdmisionBean)FacesUtils.getManagedBean("confirmarServiciosAdmisionBean");
            confirmarServiciosAdmision.setNumeroAdmision(datosBasicosUsuario.getConsulta().getCconnumdoc().longValue());
            if (confirmarServiciosAdmision.getNumeroAdmision() != null) {
                confirmarServiciosAdmision.init();
                confirmarServiciosAdmision.consultarServiciosAdmision();
                List<Cfdetafactura> cfdetafacturaList = confirmarServiciosAdmision.getCfdetafacturaList();
                confirmarServiciosAdmision.setUsuario(datosBasicosUsuario.getUsuario());
                if(cfdetafacturaList == null || cfdetafacturaList.isEmpty()){
                    renderServiciosAdmision = false;
                }
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
    
    public String irPausarConsultaControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_PAUSAR_CONSULTA_CONTROL_PRENATAL;
    }

    /**
     * @return
     */
    public String irDatosControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_DATOS_CONTROL_PRENATAL;
    }

    /**
     * @return
     */
    public String irMotivoControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_MOTIVO_CONTROL_PRENATAL;
    }
    
    public String irCuestionarioCovidControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_CONTROL_PRENATAL;
        }


    /**
     * @return
     */
    public String irExamenFisicoControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EXAMENFISICO_CONTROL_PRENATAL;
    }


    /**
     * @return
     */
    public String irEncuestaViolenciaControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_CONTROL_PRENATAL;
    }


    /**
     * @return
     */
    public String irImpDiagnosticaControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_CONTROL_PRENATAL;
    }


    /**
     * @return
     */
    public String irGestacionControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_GESTACION_CONTROL_PRENATAL;
    }

    /**
     * @return
     */
    public String irTamizajeControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_TAMIZAJE_CONTROL_PRENATAL;
    }


    /**
     * @return
     */
    public String irAnatPatologicaControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANATOMIAPATOLOGICA_CONTROL_PRENATAL;
    }

    /**
     * @return
     */
    public String irControlSinCostoControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CONTOLSINCOSTO_CONTROL_PRENATAL;
    }


    /**
     * @return
     */
    public String irFormulaMedicaControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FORMULAMEDICA_CONTROL_PRENATAL;
    }
    
    /**
     * @return
     */
    public String irVademecumMedicoControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_VADEMCUM_PRENATAL;
    }

    /**
     * @return
     */
    public String irRemHospitalizacionControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_HOSPITALZACION_CONTROL_PRENATAL;
    }


    /**
     * @return
     */
    public String irIncapacidadControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INCAPACIDAD_CONTROL_PRENATAL;
    }


    /**
     * @return
     */
    public String irInterConsultaControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INTERCONSULTA_CONTROL_PRENATAL;
    }


    /**
     * @return
     */
    public String irOrdenCirugiaControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ORDENCIRUGIA_CONTROL_PRENATAL;
    }


    /**
     * @return
     */
    public String irReferenciaControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_REFERENCIA_CONTROL_PRENATAL;
    }

    /**
     * @return
     */
    public String irReservaSangreControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESERVA_SANGRE_CONTROL_PRENATAL;
    }


    /**
     * @return
     */
    public String irRecomedacionControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RECOMENDACIONES_CONTROL_PRENATAL;
    }


    /**
     * @return
     */
    public String irCertMedicoControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADOMEDICO_CONTROL_PRENATAL;
    }

    /**
     * @return
     */
    public String irCertAsistenciaControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADO_ASISTENCIA_CONTROL_PRENATAL;
    }

    /**
     * @return
     */
    public String irExamElectrofisiologicoControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ELECTROFISIOLOGICO_CONTROL_PRENATAL;
    }

    /**
     * @return
     */
    public String irExamImagenControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMAGENES_CONTROL_PRENATAL;
    }

    /**
     * @return
     */
    public String irExamLaboratorioControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_LABORATORIO_CONTROL_PRENATAL;
    }

    /**
     * @return
     */
    public String irCerrarConsultaControlPrenatal() {
        inicializarUsuario();
        if (cerrarConsultaUsuarioBean != null) {
            cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
        }
        return BeanNavegacion.RUTA_IR_CERRAR_CONSULTA_CONTROL_PRENATAL;
    }


    /**
     * @return
     */
    public String irResumenHistoriaEspecificaControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_CONTROL_PRENATAL;
    }


    public String irResumenHistoriaControlPrenatal() {
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

        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_CONTROL_PRENATAL;
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
     * @param renderAntecedentesTemporales
     */
    public void setRenderAntecedentesTemporales(boolean renderAntecedentesTemporales) {
        this.renderAntecedentesTemporales = renderAntecedentesTemporales;
    }

    /**
     * @return
     */
    public boolean isRenderAntecedentesTemporales() {
        return renderAntecedentesTemporales;
    }

    /**
     * @param renderAntecedentesPrenatal
     */
    public void setRenderAntecedentesPrenatal(boolean renderAntecedentesPrenatal) {
        this.renderAntecedentesPrenatal = renderAntecedentesPrenatal;
    }

    /**
     * @return
     */
    public boolean isRenderAntecedentesPrenatal() {
        return renderAntecedentesPrenatal;
    }


    /**
     * @param renderGestacionControlPrenatal
     */
    public void setRenderGestacionControlPrenatal(boolean renderGestacionControlPrenatal) {
        this.renderGestacionControlPrenatal = renderGestacionControlPrenatal;
    }

    /**
     * @return
     */
    public boolean isRenderGestacionControlPrenatal() {
        return renderGestacionControlPrenatal;
    }

    /**
     * @param renderTamizajePrenatal
     */
    public void setRenderTamizajePrenatal(boolean renderTamizajePrenatal) {
        this.renderTamizajePrenatal = renderTamizajePrenatal;
    }

    /**
     * @return
     */
    public boolean isRenderTamizajePrenatal() {
        return renderTamizajePrenatal;
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
	
	public String irServiciosAdmisionControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_SERVICIOS_ADMISION_CONTROL_PRENATAL;
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

    public void setRenderEscalaCaidas(boolean renderEscalaCaidas) {
        this.renderEscalaCaidas = renderEscalaCaidas;
    }

    public boolean isRenderEscalaCaidas() {
        return renderEscalaCaidas;
    }
    
    /**
     * @return
     */
    public String irEscalaValoracionCaidasControlPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_CONTROL_PRENATAL;
    }
}
