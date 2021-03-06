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
import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chanteginecopre;
import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosBean;
import org.profamilia.hc.view.backing.comun.AntecedentesFamiliaresBean;
import org.profamilia.hc.view.backing.comun.AntecedentesGinecologicosNuevoPrenatalUsuarioBean;
import org.profamilia.hc.view.backing.comun.AntecedentesObstetricosPrenatalBean;
import org.profamilia.hc.view.backing.comun.AntecedentesUsuarioBean;
import org.profamilia.hc.view.backing.comun.CerrarConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.EncuestaViolenciaUsuarioBean;
import org.profamilia.hc.view.backing.comun.ExamenFisicoPrenatalUsuarioBean;
import org.profamilia.hc.view.backing.comun.ExamenFisicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.GestacionPrenatalUsuarioBean;
import org.profamilia.hc.view.backing.comun.ImpresionDiagnosticaUsuarioBean;
import org.profamilia.hc.view.backing.comun.MotivoBean;
import org.profamilia.hc.view.backing.comun.PausarConsultaBean;
import org.profamilia.hc.view.backing.comun.RegistrarEscalaValoracionCaidasCEBean;
import org.profamilia.hc.view.backing.comun.TamizajePrenatalUsuarioBean;
import org.profamilia.hc.view.backing.comun.ValoracionBiopsicosocialBean;
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
import org.profamilia.hc.view.backing.comun.conducta.VademecumMedicoBean;
import org.profamilia.hc.view.backing.comun.resumen.ResumenHistoriaEspecificaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.ExpandableTreeModel;
import org.profamilia.hc.view.util.FacesUtils;


public class MenuHistoriaNuevoPrenatalBean extends BaseBean {

    private DatosBasicosUsuarioBean datosBasicosUsuario;

    private MotivoBean motivoConsulta;

    private AntecedentesFamiliaresBean antecedentesFamiliares;

    private AntecedentesGinecologicosNuevoPrenatalUsuarioBean antecedentesGinecologicos;
    
    private AntecedentesObstetricosPrenatalBean antecedentesObstetricos; 

    private ExamenFisicoPrenatalUsuarioBean examenFisicoUsuarioPrenatal;
    
    private ExamenFisicoUsuarioBean examenFisicoUsuario;

    private GestacionPrenatalUsuarioBean gestacionBean;

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

    private boolean renderAntecedentesGenerales;

    private boolean renderAntecedentesGinecologicos;

    private boolean renderExamenFisicoPrenatal;
    
    private boolean renderExamenFisico;

    private boolean renderEncuestaViolencia;

    private boolean renderImpresionDiagnostica;

    private boolean renderConducta;

    private boolean renderCerrarConsulta;

    private boolean primeraConsulta;

    private boolean renderAntecedentesTemporales;

    private boolean renderAntecedentesPrenatal;
    
    private boolean renderAntecedentesObstetricos; 

    private boolean renderGestacionPrenatal;

    private boolean renderTamizajePrenatal;
    
    private boolean renderAntecedentesFamiliares; 

    private String sexo;

    private Long numeroConsulta;

    private String cie10Principal;

    private String cie10Relacionado1;

    private String codigoCups;

    private Chantegineco antecedenteObject;
    
    private String javaScriptText;

    String tensionArterial = null;

    Integer frecuenciaCardiaca = null;

    Integer frecuenciaRespiratoria = null;

    BigDecimal peso = null;

    String hallazgos = null;

    BigDecimal temperatura = null;
    
    BigDecimal imc = null;
    
    private VademecumMedicoBean vademecumUsuarioBean;

    private boolean renderVademecum;

    private boolean renderPausarConsulta;
    private PausarConsultaBean pausarConsulta;
    private boolean tiempoAtencion;
	
	private ConfirmarServiciosAdmisionBean confirmarServiciosAdmision;
			
	private boolean renderServiciosAdmision;
        
  
    
    private AntecedentesUsuarioBean antecedentes;
    
    private Chanteginecopre ginecopre;
    
    private ValoracionBiopsicosocialBean valoracionBiopsicosocialBean;
    
    private boolean renderValoracionBiopsicosocial;
    
    private CuestionarioCovidBean cuestionarioCovid;
    
    private boolean renderCovid;
    
    private RegistrarEscalaValoracionCaidasCEBean registrarEscalaValoracionCaidasBean;
    
    private boolean renderEscalaCaidas;
    
    private AutorizacionServicioUsuarioBean autorizacionServicioUsuarioBean;

    public void init() {
        primeraConsulta = false;
        double semanaEmbarazo = 0; 
        Date fechaUltimaRegla = null;
        Integer numeroPartos = 0;
		renderServiciosAdmision =false;


        // DATOS BASICOS USUARIO
        datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_NUEVO_PRENATAL);
        datosBasicosUsuario.setMenuBean("menuHistoriaNuevoPrenatalBean");
        renderCovid = datosBasicosUsuario.esValido();

        
                    renderVademecum = true; 
               

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
        cuestionarioCovid = (CuestionarioCovidBean)FacesUtils.getManagedBean("cuestionarioCovidBean");
        cuestionarioCovid.setTipoServicio(TIPO_CONSULTA);
        cuestionarioCovid.setNumeroConsulta(numeroConsulta);
        if(datosBasicosUsuario != null && datosBasicosUsuario.getUsuario() != null && datosBasicosUsuario.getUsuario().getHuslnumero() != null ){
            cuestionarioCovid.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
        }
        cuestionarioCovid.setNextAction(BeanNavegacion.RUTA_IR_MOTIVO_NUEVO_PRENATAL);
        cuestionarioCovid.setMenuBean("menuHistoriaNuevoPrenatalBean");
        cuestionarioCovid.inicializarCuestionario();
        renderMotivo= cuestionarioCovid.esValido();

        // MOTIVO DE CONSULTA
        motivoConsulta = (MotivoBean)FacesUtils.getManagedBean("motivoBean");
        motivoConsulta.setTipoServicio(TIPO_CONSULTA);
        motivoConsulta.setNumeroConsulta(numeroConsulta);
        motivoConsulta.setOcultarasesoria(true);
        motivoConsulta.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_NUEVO_PRENATAL);
        if (primeraConsulta) {
            motivoConsulta.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_NUEVO_PRENATAL);
        }

        motivoConsulta.setMenuBean("menuHistoriaNuevoPrenatalBean");
        motivoConsulta.inicializarMotivo();
        renderAntecedentesPrenatal = motivoConsulta.esValido();
        renderAntecedentesGenerales = motivoConsulta.esValido();


      
        
        // ANTECEDENTES GENERALES
         antecedentes = 
                 (AntecedentesUsuarioBean)FacesUtils.getManagedBean("antecedentesUsuarioBean");
         antecedentes.setTipoServicio(TIPO_CONSULTA);
         antecedentes.setNumeroConsulta(numeroConsulta);
         antecedentes.setTipoHistoria(HISTORIA_PRENATAL);
         antecedentes.setUsuario(datosBasicosUsuario.getUsuario());
         antecedentes.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_GINECOLOGICOS_NUEVO_PRENATAL);
         antecedentes.setMenuBean("menuHistoriaNuevoPrenatalBeanBean");
         renderAntecedentesGinecologicos = antecedentes.esValido();
         antecedentes.inicializarAntecedentes();



        // ANTECEDENTES GINECOLOGICOS

        antecedentesGinecologicos = 
                (AntecedentesGinecologicosNuevoPrenatalUsuarioBean)FacesUtils.getManagedBean("antecedentesGinecologicosNuevoPrenatalUsuarioBean");
        antecedentesGinecologicos.setTipoServicio(TIPO_CONSULTA);
        antecedentesGinecologicos.setNumeroConsulta(numeroConsulta);
        antecedentesGinecologicos.setUsuario(datosBasicosUsuario.getUsuario());
        antecedentesGinecologicos.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_OBSTETRICOS_NUEVO_PRENATAL);
        antecedentesGinecologicos.setMenuBean("menuHistoriaNuevoPrenatalBean");
        antecedentesGinecologicos.setOcultarmensaje(true);
        antecedentesGinecologicos.inicializarAntecedentesGinecologicos();
        renderAntecedentesObstetricos = antecedentesGinecologicos.esValido();
        
        
        

        if (antecedentesGinecologicos != null) {
            ginecopre = antecedentesGinecologicos.getAntecedente();
            
        }
        
        if(ginecopre != null){
            fechaUltimaRegla = ginecopre.getHagdfur();
          
        }
        
        if(fechaUltimaRegla!= null){
            semanaEmbarazo = calcularSemanasEmbarazo(fechaUltimaRegla);
        }

        antecedentesObstetricos = 
                (AntecedentesObstetricosPrenatalBean)FacesUtils.getManagedBean("antecedentesObstetricosPrenatalBean");
        antecedentesObstetricos.setTipoServicio(TIPO_CONSULTA);
        antecedentesObstetricos.setNumeroConsulta(numeroConsulta);
        antecedentesObstetricos.setUsuario(datosBasicosUsuario.getUsuario());
        antecedentesObstetricos.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_FAMILIARES_NUEVO_PRENATAL);
        antecedentesObstetricos.setMenuBean("menuHistoriaNuevoPrenatalBean");
        antecedentesObstetricos.inicializarAntecedentesGinecoObstetricos();
        renderAntecedentesFamiliares = antecedentesObstetricos.esValido();
        
        if(antecedentesObstetricos != null && antecedentesObstetricos.getAntecedente() != null
        && antecedentesObstetricos.getAntecedente().getHaonnumparto() != null){
            numeroPartos =  antecedentesObstetricos.getAntecedente().getHaonnumparto(); 
        }
        
        

                // ANTECEDENTES

                antecedentesFamiliares = 
                        (AntecedentesFamiliaresBean)FacesUtils.getManagedBean("antecedentesFamiliaresBean");
                antecedentesFamiliares.setTipoServicio(TIPO_CONSULTA);
                antecedentesFamiliares.setConsulta(datosBasicosUsuario.getConsulta());
                antecedentesFamiliares.setUsuario(datosBasicosUsuario.getUsuario());
                antecedentesFamiliares.setNextAction(BeanNavegacion.RUTA_IR_GESTACION_NUEVO_PRENATAL);
                antecedentesFamiliares.setMenuBean("menuHistoriaNuevoPrenatalBean");
                antecedentesFamiliares.inicializarAntecedentes();
                renderGestacionPrenatal = antecedentesFamiliares.esValido();
        
        
        


        // GESTACION 

        gestacionBean = 
                (GestacionPrenatalUsuarioBean)FacesUtils.getManagedBean("gestacionPrenatalUsuarioBean");
        gestacionBean.setTipoServicio(TIPO_CONSULTA);
        gestacionBean.setConsulta(datosBasicosUsuario.getConsulta());
        gestacionBean.setNextAction(BeanNavegacion.RUTA_IR_VALORACION_BIOPSICOSOCIAL_NUEVO_PRENATAL);
        gestacionBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
        gestacionBean.setFechaultimaregla(fechaUltimaRegla);
        gestacionBean.inicializarGestacion();
        renderValoracionBiopsicosocial = gestacionBean.esValido();

        // BIOPSICOSOCIAL 

        valoracionBiopsicosocialBean = 
                (ValoracionBiopsicosocialBean)FacesUtils.getManagedBean("valoracionBiopsicosocialBean");
        valoracionBiopsicosocialBean.setNumeroConsulta(numeroConsulta);
        valoracionBiopsicosocialBean.setNextAction(BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_NUEVO_PRENATAL);
        valoracionBiopsicosocialBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
        valoracionBiopsicosocialBean.setUsuario(datosBasicosUsuario.getUsuario());
        valoracionBiopsicosocialBean.setNumParto(numeroPartos);
        valoracionBiopsicosocialBean.inicializarValoracionBiopsicosocial();
        renderEncuestaViolencia = valoracionBiopsicosocialBean.esValido();
        
        // ENCUESTA DE VIOLENCIA
        encuestaViolenciaUsuario = 
                (EncuestaViolenciaUsuarioBean)FacesUtils.getManagedBean("encuestaViolenciaUsuarioBean");
        encuestaViolenciaUsuario.setTipoServicio(TIPO_CONSULTA);
        encuestaViolenciaUsuario.setTipoHistoria(HISTORIA_PRENATAL);
        encuestaViolenciaUsuario.setNumeroConsulta(numeroConsulta);
        encuestaViolenciaUsuario.setNextAction(BeanNavegacion.RUTA_IR_TAMIZAJE_NUEVO_PRENATAL);
        encuestaViolenciaUsuario.setMenuBean("menuHistoriaNuevoPrenatalBean");
        encuestaViolenciaUsuario.inicializarEncuesta();
        renderTamizajePrenatal = encuestaViolenciaUsuario.esValido();
        
        
        
        //TAMIZAJE PRENATAL

        tamizajeBean = 
                (TamizajePrenatalUsuarioBean)FacesUtils.getManagedBean("tamizajePrenatalUsuarioBean");
        tamizajeBean.setUsuario(datosBasicosUsuario.getUsuario());
        tamizajeBean.setTipoServicio(TIPO_CONSULTA);
        tamizajeBean.setConsulta(datosBasicosUsuario.getConsulta());
        tamizajeBean.setNextAction(BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_NUEVO_PRENATAL);
        tamizajeBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
        tamizajeBean.inicializarTamizaje();
        renderEscalaCaidas = tamizajeBean.esValido();
        
        
        registrarEscalaValoracionCaidasBean = 
           (RegistrarEscalaValoracionCaidasCEBean)FacesUtils.getManagedBean("registrarEscalaValoracionCaidasCEBean");
           registrarEscalaValoracionCaidasBean.setNumeroConsulta(numeroConsulta);
        if (datosBasicosUsuario != null &&
           datosBasicosUsuario.getUsuario() != null && 
           datosBasicosUsuario.getUsuario().getHuslnumero() != null) {
               registrarEscalaValoracionCaidasBean.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
           }
           registrarEscalaValoracionCaidasBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
           registrarEscalaValoracionCaidasBean.setNextAction(BeanNavegacion.RUTA_IR_EXAMEN_FISICO_GENERAL_NUEVO_PRENATAL);
           registrarEscalaValoracionCaidasBean.init();
           renderExamenFisico = registrarEscalaValoracionCaidasBean.esValido();
        
        
        // EXAMEN FISICO
        examenFisicoUsuario = 
                (ExamenFisicoUsuarioBean)FacesUtils.getManagedBean("examenFisicoUsuarioBean");
        examenFisicoUsuario.setTipoServicio(TIPO_CONSULTA);
        examenFisicoUsuario.setNumeroConsulta(numeroConsulta);
        examenFisicoUsuario.setNextAction(BeanNavegacion.RUTA_IR_EXAMENFISICO_NUEVO_PRENATAL);
        examenFisicoUsuario.setMenuBean("menuHistoriaNuevoPrenatalBean");
        examenFisicoUsuario.setConsecutivo(1);
        examenFisicoUsuario.setUsuario(datosBasicosUsuario.getUsuario());
        examenFisicoUsuario.setObligatoriaTemperatura(true);
        examenFisicoUsuario.inicializarExamen();
        renderExamenFisicoPrenatal = examenFisicoUsuario.esValido();

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

            //hallazgos = examenFisicoUsuario.getExamen().getHefthallazgo();   

            temperatura = examenFisicoUsuario.getExamen().getHefatemperatu();
            
            imc  = examenFisicoUsuario.getExamen().getHefaimc();
        }



        // EXAMEN FISICO PRENATAL
        examenFisicoUsuarioPrenatal = 
                (ExamenFisicoPrenatalUsuarioBean)FacesUtils.getManagedBean("examenFisicoPrenatalUsuarioBean");
        examenFisicoUsuarioPrenatal.setTipoServicio(TIPO_CONSULTA);
        examenFisicoUsuarioPrenatal.setNumeroConsulta(numeroConsulta);
        examenFisicoUsuarioPrenatal.setNextAction(BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_NUEVO_PRENATAL);
        examenFisicoUsuarioPrenatal.setMenuBean("menuHistoriaNuevoPrenatalBean");
        examenFisicoUsuarioPrenatal.setSemanaGestacion(semanaEmbarazo);
        examenFisicoUsuarioPrenatal.setUsuario(datosBasicosUsuario.getUsuario());
        examenFisicoUsuarioPrenatal.setImc(imc);
        examenFisicoUsuarioPrenatal.inicializarExamen();
        renderImpresionDiagnostica = examenFisicoUsuarioPrenatal.esValido();
        
        
         if(examenFisicoUsuarioPrenatal != null && 
            examenFisicoUsuarioPrenatal.getControl() != null) {
            /*tensionArterial = 
                    examenFisicoUsuario.getControl().getHcpcpresart1() + "/" + 
                    examenFisicoUsuario.getControl().getHcpcpresart2();

            frecuenciaCardiaca = 
                    examenFisicoUsuario.getControl().getHcpnfreccard();

            frecuenciaRespiratoria = 
                    examenFisicoUsuario.getControl().getHcpnfrecresp();

            peso = examenFisicoUsuario.getControl().getHcpapeso();
            */
            hallazgos = ""; 
            
            if(examenFisicoUsuarioPrenatal.getControl().getHcpthallaextre()!= null){
                hallazgos =  hallazgos + " ORL: " + examenFisicoUsuarioPrenatal.getControl().getHcpthallaextre() + "\n.";    
            }
            
            if(examenFisicoUsuarioPrenatal.getControl().getHcpthallaorl()!= null){
                hallazgos = hallazgos + "Cardio Pulmonar: " + examenFisicoUsuarioPrenatal.getControl().getHcpthallaorl() + "\n.";    
            }
            
            if(examenFisicoUsuarioPrenatal.getControl().getHcpthallcarpul()!= null){
                hallazgos = hallazgos + "Extremidades: " + examenFisicoUsuarioPrenatal.getControl().getHcpthallcarpul()+ "\n.";      
            }
            
            if(examenFisicoUsuarioPrenatal.getControl().getHcpthallsisner()!= null){
                hallazgos = hallazgos + "Sistema nervioso central" +examenFisicoUsuarioPrenatal.getControl().getHcpthallsisner()+ "\n.";    
            }

            temperatura = examenFisicoUsuarioPrenatal.getControl().getHcpatemperatu();
        }
        

        // IMPRESION DIAGNOSTICA
        impresionDiagnosticaUsuarioBean = 
                (ImpresionDiagnosticaUsuarioBean)FacesUtils.getManagedBean("impresionDiagnosticaUsuarioBean");
        impresionDiagnosticaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        impresionDiagnosticaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        impresionDiagnosticaUsuarioBean.setNumeroConsulta(numeroConsulta);
        impresionDiagnosticaUsuarioBean.setConsecutivo(1);
        impresionDiagnosticaUsuarioBean.setNextAction(BeanNavegacion.RUTA_IR_RECOMENDACIONES_NUEVO_PRENATAL);
        impresionDiagnosticaUsuarioBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
        impresionDiagnosticaUsuarioBean.setDesHabilitarDiagnosticoPrincipal(false);
        impresionDiagnosticaUsuarioBean.inicializarImpresion();
        impresionDiagnosticaUsuarioBean.setCodigoDiagnostico("");
        impresionDiagnosticaUsuarioBean.setCodigoRelacionado1("");
        impresionDiagnosticaUsuarioBean.setCodigoRelacionado2("");
        impresionDiagnosticaUsuarioBean.setCodigoRelacionado3("");
        impresionDiagnosticaUsuarioBean.setDisableRel1(false);
        impresionDiagnosticaUsuarioBean.setRequiredRel2(false);
        impresionDiagnosticaUsuarioBean.setRenderColposcopia(false);
        impresionDiagnosticaUsuarioBean.setDesHabilitarDiagnosticoPrincipal(false);
        impresionDiagnosticaUsuarioBean.setCodigoRelacionado3("");
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


     
        // CONDUCTA RECOMENDACIONES
        recomedacionUsuarioBean = 
                (RecomedacionUsuarioBean)FacesUtils.getManagedBean("recomedacionUsuarioBean");
        recomedacionUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        recomedacionUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        recomedacionUsuarioBean.setNumeroConsulta(numeroConsulta);
        recomedacionUsuarioBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
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
        anatomiaPatologicaUsuarioBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
        anatomiaPatologicaUsuarioBean.inicializarAnatomiaPatol();


        // CONDUCTA - CONTROL SIN COSTO
        controlSinCostoUsuarioBean = 
                (ControlSinCostoUsuarioBean)FacesUtils.getManagedBean("controlSinCostoUsuarioBean");
        controlSinCostoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        controlSinCostoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        controlSinCostoUsuarioBean.setCodigoCups(codigoCups);
        controlSinCostoUsuarioBean.setNumeroConsulta(numeroConsulta);
        controlSinCostoUsuarioBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
        controlSinCostoUsuarioBean.inicializarControlSinCosto();

        // CONDUCTA - FORMULA MEDICA
        formulaMedicaUsuarioBean = 
                (FormulaMedicaUsuarioBean)FacesUtils.getManagedBean("formulaMedicaUsuarioBean");
        formulaMedicaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        formulaMedicaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        formulaMedicaUsuarioBean.setNumeroConsulta(numeroConsulta);
        formulaMedicaUsuarioBean.setCodigoCIE10(cie10Principal);
        formulaMedicaUsuarioBean.setConsecutivo(1);
        formulaMedicaUsuarioBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
        formulaMedicaUsuarioBean.inicializardFormulaMedica();
        

                // CONDUCTA - FORMULA MEDICA
                vademecumUsuarioBean = (VademecumMedicoBean)FacesUtils.getManagedBean("vademecumMedicoBean");
                vademecumUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
                vademecumUsuarioBean.setTipoServicio(TIPO_CONSULTA);
                vademecumUsuarioBean.setNumeroConsulta(numeroConsulta);
                vademecumUsuarioBean.setCodigoCIE10(cie10Principal);
                vademecumUsuarioBean.setConsecutivo(1);
                vademecumUsuarioBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
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
        hospitalizacionUsuarioBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
        hospitalizacionUsuarioBean.inicializarHospitalizacion();

        // CONDUCTA - Cirug???as y procedimientos
        ordenCirugiaUsuarioBean = 
                (OrdenCirugiaUsuarioBean)FacesUtils.getManagedBean("ordenCirugiaUsuarioBean");
        ordenCirugiaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        ordenCirugiaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        ordenCirugiaUsuarioBean.setNumeroConsulta(numeroConsulta);
        ordenCirugiaUsuarioBean.setConsecutivo(1);
        ordenCirugiaUsuarioBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
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
        interConsultaUsuarioBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
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
        incapacidadUsuarioBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
        incapacidadUsuarioBean.inicializarIncapacidad();
        
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
         autorizacionServicioUsuarioBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
         autorizacionServicioUsuarioBean.inicializarAutorizacionServicio();



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
        referenciaUsuarioBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
        referenciaUsuarioBean.inicializarReferencia();


        // CONDUCTA - SOLICITUD RESERVA DE SANGRE
        reservaSangreUsuarioBean = 
                (ReservaSangreUsuarioBean)FacesUtils.getManagedBean("reservaSangreUsuarioBean");
        reservaSangreUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        reservaSangreUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        reservaSangreUsuarioBean.setNumeroConsulta(numeroConsulta);
        reservaSangreUsuarioBean.setConsecutivo(1);
        reservaSangreUsuarioBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
        reservaSangreUsuarioBean.inicializarReservaSangre();

        // CONDUCTA - CERTIFICADOS / CERTIFICADO MEDICO
        certMedicoUsuarioBean = 
                (CertMedicoUsuarioBean)FacesUtils.getManagedBean("certMedicoUsuarioBean");
        certMedicoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        certMedicoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        certMedicoUsuarioBean.setNumeroConsulta(numeroConsulta);
        certMedicoUsuarioBean.setConsecutivo(1);
        certMedicoUsuarioBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
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
        certAsistenciaUsuarioBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
        certAsistenciaUsuarioBean.inicializarCertificadoAsistencia();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN ELECTROFISIOLOGICO
        examElectrofisiologicoUsuarioBean = 
                (ExamElectrofisiologicoUsuarioBean)FacesUtils.getManagedBean("examElectrofisioUsuarioBean");
        examElectrofisiologicoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        examElectrofisiologicoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        examElectrofisiologicoUsuarioBean.setNumeroConsulta(numeroConsulta);
        examElectrofisiologicoUsuarioBean.setCie10Principal(cie10Principal);
        examElectrofisiologicoUsuarioBean.setConsecutivo(1);
        examElectrofisiologicoUsuarioBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
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
        examImagenUsuarioBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
        examImagenUsuarioBean.inicializarExamImagen();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN LABORATORIO
        examLaboratorioUsuarioBean = 
                (ExamLaboratorioUsuarioBean)FacesUtils.getManagedBean("examLaboratorioUsuarioBean");
        examLaboratorioUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        examLaboratorioUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        examLaboratorioUsuarioBean.setNumeroConsulta(numeroConsulta);
        examLaboratorioUsuarioBean.setCie10Principal(cie10Principal);
        examLaboratorioUsuarioBean.setConsecutivo(1);
        examLaboratorioUsuarioBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
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
        cerrarConsultaUsuarioBean.setMenuBean("menuHistoriaNuevoPrenatalBean");
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
    }
    
    public String irPausarConsultaPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_PAUSAR_CONSULTA_NUEVO_PRENATAL;
    }
    
    /**
     * @return
     */
    public String irDatosPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_DATOS_NUEVO_PRENATAL;
    }

    /**
     * @return
     */
    public String irMotivoPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_MOTIVO_NUEVO_PRENATAL;
    }
    
    public String irCuestionarioCovidPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_NUEVO_PRENATAL;
        }



    /**
     * @return
     */
    public String irAntecedentesEspecificosPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_FAMILIARES_NUEVO_PRENATAL;
    }


    /**
     * @return
     */
    public String irAntecedentesGinecologicosPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_GINECOLOGICOS_NUEVO_PRENATAL;
    }


    /**
     * @return
     */
    public String irAntecedentesObstetricosPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_OBSTETRICOS_NUEVO_PRENATAL;
    }
    
    /**
     * @return
     */
    public String irAntecedentesFamiliaresPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_FAMILIARES_NUEVO_PRENATAL;
    }


    /**
     * @return
     */
    public String irExamenFisicoPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EXAMENFISICO_NUEVO_PRENATAL;
    }


    /**
     * @return
     */
    public String irEncuestaViolenciaPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_NUEVO_PRENATAL;
    }


    /**
     * @return
     */
    public String irImpDiagnosticaPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_NUEVO_PRENATAL;
    }


    /**
     * @return
     */
    public String irGestacionPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_GESTACION_NUEVO_PRENATAL;
    }

    /**
     * @return
     */
    public String irTamizajePrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_TAMIZAJE_NUEVO_PRENATAL;
    }


    /**
     * @return
     */
    public String irAnatPatologicaPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANATOMIAPATOLOGICA_NUEVO_PRENATAL;
    }

    /**
     * @return
     */
    public String irControlSinCostoPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CONTOLSINCOSTO_NUEVO_PRENATAL;
    }


    /**
     * @return
     */
    public String irFormulaMedicaPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FORMULAMEDICA_NUEVO_PRENATAL;
    }
    
    
    /**
     * @return
     */
    public String irVademecumMedicoPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_VADEMECUM_NUEVO_PRENATAL;
    }

    /**
     * @return
     */
    public String irRemHospitalizacionPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_HOSPITALZACION_NUEVO_PRENATAL;
    }


    /**
     * @return
     */
    public String irIncapacidadPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INCAPACIDAD_NUEVO_PRENATAL;
    }


    /**
     * @return
     */
    public String irInterConsultaPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INTERCONSULTA_NUEVO_PRENATAL;
    }


    /**
     * @return
     */
    public String irOrdenCirugiaPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ORDENCIRUGIA_NUEVO_PRENATAL;
    }


    /**
     * @return
     */
    public String irReferenciaPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_REFERENCIA_NUEVO_PRENATAL;
    }

    /**
     * @return
     */
    public String irReservaSangrePrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESERVA_SANGRE_NUEVO_PRENATAL;
    }


    /**
     * @return
     */
    public String irRecomedacionPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RECOMENDACIONES_NUEVO_PRENATAL;
    }


    /**
     * @return
     */
    public String irCertMedicoPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADOMEDICO_NUEVO_PRENATAL;
    }

    /**
     * @return
     */
    public String irCertAsistenciaPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADO_ASISTENCIA_NUEVO_PRENATAL;
    }

    /**
     * @return
     */
    public String irExamElectrofisiologicoPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ELECTROFISIOLOGICO_NUEVO_PRENATAL;
    }

    /**
     * @return
     */
    public String irExamImagenPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMAGENES_NUEVO_PRENATAL;
    }
    
    /**
     * @return
     */
    public String irAutorizacionServiciosPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_AUTORIZACION_SERVICIOS_NUEVO_PRENATAL;
    }

    /**
     * @return
     */
    public String irExamLaboratorioPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_LABORATORIO_NUEVO_PRENATAL;
    }


    /**
     * @return
     */
    public String irCerrarConsultaPrenatal() {
        inicializarUsuario();
        if (cerrarConsultaUsuarioBean != null) {
            cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
        }
        return BeanNavegacion.RUTA_IR_CERRAR_CONSULTA_NUEVO_PRENATAL;
    }


    /**
     * @return
     */
    public String irResumenHistoriaEspecificaPrenatal() {
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
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_NUEVO_PRENATAL;
    }

    /**
     * @return
     */
    public String irResumenHistoriaPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_NUEVO_PRENATAL;
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
    public void setRenderExamenFisicoPrenatal(boolean renderExamen) {
        this.renderExamenFisicoPrenatal = renderExamen;
    }

    /**
     * @return
     */
    public boolean isRenderExamenFisicoPrenatal() {
        return renderExamenFisicoPrenatal;
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
     * @param renderAntecedentesGinecologicos
     */
    public void setRenderAntecedentesGinecologicos(boolean renderAntecedentesGinecologicos) {
        this.renderAntecedentesGinecologicos = renderAntecedentesGinecologicos;
    }

    /**
     * @return
     */
    public boolean isRenderAntecedentesGinecologicos() {
        return renderAntecedentesGinecologicos;
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
     * @param renderGestacionPrenatal
     */
    public void setRenderGestacionPrenatal(boolean renderGestacionPrenatal) {
        this.renderGestacionPrenatal = renderGestacionPrenatal;
    }

    /**
     * @return
     */
    public boolean isRenderGestacionPrenatal() {
        return renderGestacionPrenatal;
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
     * @param renderAntecedentesObstetricos
     */
    public void setRenderAntecedentesObstetricos(boolean renderAntecedentesObstetricos) {
        this.renderAntecedentesObstetricos = renderAntecedentesObstetricos;
    }

    /**
     * @return
     */
    public boolean isRenderAntecedentesObstetricos() {
        return renderAntecedentesObstetricos;
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
            new TreeNodeBase("itemNode4", "Remisi???n Hospitalizaci???n", false);
        TreeNodeBase itemNode5 = 
            new TreeNodeBase("itemNode5", "Incapacidad", false);
        TreeNodeBase itemNode6 = 
            new TreeNodeBase("itemNode6", "Inter Consulta", false);
        TreeNodeBase itemNode7 = 
            new TreeNodeBase("itemNode7", "Cirug???as y procedimientos", false);
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
            new TreeNodeBase("raiz", "Ex???menes Clinicos", false);
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
	
	public String irServiciosAdmisionPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_SERVICIOS_ADMISION_PRENATAL;
    }

    public void setRenderServiciosAdmision(boolean renderServiciosAdmision) {
        this.renderServiciosAdmision = renderServiciosAdmision;
    }

    public boolean isRenderServiciosAdmision() {
        return renderServiciosAdmision;
    }
    
    /**
     * @return
     */
    public String irAntecedentesGeneralesPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_NUEVO_PRENATAL;
    }

    public void setRenderAntecedentesFamiliares(boolean renderAntecedentesFamiliares) {
        this.renderAntecedentesFamiliares = renderAntecedentesFamiliares;
    }

    public boolean isRenderAntecedentesFamiliares() {
        return renderAntecedentesFamiliares;
    }
    
    /**
     * @return
     */
    public String irValoracionBiopsicosocialNuevoPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_VALORACION_BIOPSICOSOCIAL_NUEVO_PRENATAL;
    }

    public void setRenderValoracionBiopsicosocial(boolean renderValoracionBiopsicosocial) {
        this.renderValoracionBiopsicosocial = renderValoracionBiopsicosocial;
    }

    public boolean isRenderValoracionBiopsicosocial() {
        return renderValoracionBiopsicosocial;
    }

    public void setRenderExamenFisico(boolean renderExamenFisico) {
        this.renderExamenFisico = renderExamenFisico;
    }

    public boolean isRenderExamenFisico() {
        return renderExamenFisico;
    }
    
    /**
     * @return
     */
    public String irExamenFisicoGeneralNuevoPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EXAMEN_FISICO_GENERAL_NUEVO_PRENATAL;
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
    public String irEscalaValoracionCaidasNuevoPrenatal() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_NUEVO_PRENATAL;
    }
}
