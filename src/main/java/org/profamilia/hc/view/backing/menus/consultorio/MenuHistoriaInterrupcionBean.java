package org.profamilia.hc.view.backing.menus.consultorio;

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
import org.profamilia.hc.model.dto.Chformulamed;
import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.asesoria.administrador.ConsultarAsesoriaBean;
import org.profamilia.hc.view.backing.cirugia.registro.OtrasOrdenesBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaHospitalizacionBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaLiquidosBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosBean;
import org.profamilia.hc.view.backing.comun.AntecedentesGeneralesUsuarioBean;
import org.profamilia.hc.view.backing.comun.AntecedentesGinecologicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.AntecedentesUsuarioBean;
import org.profamilia.hc.view.backing.comun.AntecedentesUsuarioDetalladoBean;
import org.profamilia.hc.view.backing.comun.AsesoriaIveBean;
import org.profamilia.hc.view.backing.comun.CerrarConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.EncuestaViolenciaUsuarioBean;
import org.profamilia.hc.view.backing.comun.EstadoPsicoemocionalBean;
import org.profamilia.hc.view.backing.comun.ExamenFisicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.IdentificacionRiegosBean;
import org.profamilia.hc.view.backing.comun.ImpresionDiagnosticaIlveBean;
import org.profamilia.hc.view.backing.comun.ImpresionDiagnosticaUsuarioBean;
import org.profamilia.hc.view.backing.comun.MotivoBean;
import org.profamilia.hc.view.backing.comun.PausarConsultaBean;
import org.profamilia.hc.view.backing.comun.RemisionIlveBean;
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
import org.profamilia.hc.view.backing.comun.conducta.VademecumMedicoBean;
import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.model.dto.Chmetodoplan;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.view.backing.cirugia.registro.OtrasOrdenesBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaHospitalizacionBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaLiquidosBean;
import org.profamilia.hc.view.backing.comun.AplicacionDispositivoBean;
import org.profamilia.hc.view.backing.comun.AsesoriaIveBean;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;
import org.profamilia.hc.view.backing.comun.MetodosAnticoncepcionBean;
import org.profamilia.hc.view.backing.comun.RegistrarEscalaValoracionCaidasCEBean;


public class MenuHistoriaInterrupcionBean extends BaseBean {


    private DatosBasicosUsuarioBean datosBasicosUsuario;
    private MotivoBean motivoConsulta;
    private AntecedentesUsuarioBean antecedentes;
    private AntecedentesUsuarioDetalladoBean antecedentesDetallados;
     private AntecedentesGeneralesUsuarioBean  antecedentesGenerales;
    private AntecedentesGinecologicosUsuarioBean antecedentesGinecologicos;
    private ExamenFisicoUsuarioBean examenFisicoUsuario;
    private EncuestaViolenciaUsuarioBean encuestaViolenciaUsuario;
    private EstadoPsicoemocionalBean estadoPsicoemocional;
    private ImpresionDiagnosticaIlveBean impresionDiagnosticaIveUsuarioBean;
    private ImpresionDiagnosticaUsuarioBean impresionDiagnosticaUsuarioBean;
    private RemisionIlveBean remIlveBean;
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
    private CerrarConsultaUsuarioBean cerrarConsultaUsuarioBean;
    private ExpandableTreeModel trnhistoria;
    private ResumenHistoriaEspecificaBean resumenEspecifico;
    private IdentificacionRiegosBean identificacionRiesgos;
    private FormulaLiquidosBean formulaLiquidosBean;
    private FormulaHospitalizacionBean formulaHospitalizacionBean;  
    private OtrasOrdenesBean otrasOrdenesBean;
    private boolean renderOrdenesMedicas;
    private Chusuario usuario;
    private boolean renderMotivo;
    private boolean renderAntecedentesGenerales;
    private boolean renderAntecedentesGinecologicos;
    private boolean renderExamen;
    private boolean renderIdentificacionRiegos;
    private boolean renderEncuestaViolencia;
    private boolean renderEstadoPsico;
    private boolean renderImpresionDiagnostica;
    private boolean renderConducta;
    private boolean renderCerrarConsulta;
    private boolean primeraConsulta;
    private boolean renderRemision;
    private boolean renderAntecedentesInterrupcion; 
    private String sexo;
    private Long numeroConsulta;
    private String cie10Principal;
    private String cie10Relacionado1;
    private String codigoCups;
    private Chantegineco antecedenteObject;
    private double numeroSemanasEcografia;
    private boolean renderImpresionDiagnosticaIVE; 

    private String javaScriptText;

    private VademecumMedicoBean vademecumUsuarioBean;

    private boolean renderVademecum;
    
    private boolean renderPausarConsulta;
            
    private PausarConsultaBean pausarConsulta;
    
    private boolean tiempoAtencion;
	
    private ConfirmarServiciosAdmisionBean confirmarServiciosAdmision;
			
    private boolean renderServiciosAdmision;
    
    private boolean renderAsesoriaIVE;
    
    private AsesoriaIveBean asesoriaIVE;
    
    private CuestionarioCovidBean cuestionarioCovid;
    
    private boolean renderCovid;
    
    private RegistrarEscalaValoracionCaidasCEBean registrarEscalaValoracionCaidasBean;
    
    private boolean renderEscalaCaidas;
    
    private MetodosAnticoncepcionBean metodos;
    
    private AplicacionDispositivoBean dispositivos;
    
    private boolean renderMetodos;
    
    private boolean renderDispositivos;


    public void init() {
        primeraConsulta = false;
        String tensionArterial = null;
        Integer frecuenciaCardiaca = null;
        Integer frecuenciaRespiratoria = null;
        java.math.BigDecimal peso = null;
        String hallazgos = null;
        java.math.BigDecimal temperatura = null;
        double numeroSemanas = 0;
        numeroSemanasEcografia = 0;
        double numeroDias = 0;
        double numeroDiasEcografia = 0;
        boolean renderMasculino;
        renderMasculino = false;
        renderVademecum = true;
        renderPausarConsulta=false;
	renderServiciosAdmision =false;	
	renderOrdenesMedicas = true;
        boolean confirmaEmbarazo = true; 
        renderEscalaCaidas= false;
        renderMetodos = false;
        renderDispositivos = false;
      


        datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_CUESTIONARIO_INTERRUPCION);
        datosBasicosUsuario.setMenuBean("menuHistoriaInterrupcionBean");
	datosBasicosUsuario.setTipoHistoria(IConstantes.HISTORIA_INTERRUPCION);
        datosBasicosUsuario.setRenderViveSola(true);
        renderCovid = datosBasicosUsuario.esValido();
        if(IConstantes.ACTIVAR_PAUSAR_CONSULTA){
        renderPausarConsulta = datosBasicosUsuario.esValido();
        }
        
        if (datosBasicosUsuario != null && 
            datosBasicosUsuario.getUsuario() != null && 
            datosBasicosUsuario.getUsuario().getHuslnumero() != null)
            try {
                primeraConsulta = 
                        getServiceLocator().getClinicoService().esPrimeraConsulta(datosBasicosUsuario.getUsuario());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        if (datosBasicosUsuario != null && 
            datosBasicosUsuario.getUsuario() != null && 
            datosBasicosUsuario.getUsuario().getHusesexo() != null) {

            sexo = datosBasicosUsuario.getUsuario().getHusesexo();
            if (sexo != null && 
                (sexo.equals(SEXO_MASCULINO) || sexo.equals(SEXO_TRANSEXUAL) || 
                 sexo.equals(SEXO_AMBIGUO))) {
                renderMasculino = true;
            }
        }

        if (datosBasicosUsuario != null && 
            datosBasicosUsuario.getConsulta() != null && 
            datosBasicosUsuario.getConsulta().getCconnumero() != null) {
            numeroConsulta = 
                    new Long(datosBasicosUsuario.getConsulta().getCconnumero().longValue());
            if (datosBasicosUsuario.getConsulta().getCcocservic() != null)
                codigoCups = 
                        datosBasicosUsuario.getConsulta().getCcocservic().getCsvccodigo();
        }
        
        
	      datosBasicosUsuario.setTipoHistoria(IConstantes.HISTORIA_INTERRUPCION);        
	      datosBasicosUsuario.setRenderViveSola(true);


        if(IConstantes.ACTIVAR_PAUSAR_CONSULTA){
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
        
	      // MOTIVO DE CONSULTA
	      cuestionarioCovid = (CuestionarioCovidBean)FacesUtils.getManagedBean("cuestionarioCovidBean");
	      cuestionarioCovid.setTipoServicio(TIPO_CONSULTA);
	      cuestionarioCovid.setNumeroConsulta(numeroConsulta);
	      if(datosBasicosUsuario != null && datosBasicosUsuario.getUsuario() != null && datosBasicosUsuario.getUsuario().getHuslnumero() != null ){
	          cuestionarioCovid.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
	      }
	      cuestionarioCovid.setNextAction(BeanNavegacion.RUTA_IR_MOTIVO_INTERRUPCION);
	      cuestionarioCovid.setMenuBean("menuHistoriaInterrupcionBean");
	      cuestionarioCovid.inicializarCuestionario();
	      renderMotivo= cuestionarioCovid.esValido();
        
        
        motivoConsulta = (MotivoBean)FacesUtils.getManagedBean("motivoBean");
        motivoConsulta.setTipoServicio("C");
        motivoConsulta.setNumeroConsulta(numeroConsulta);
        motivoConsulta.setTipoHistoria(HISTORIA_INTERRUPCION);
        motivoConsulta.setEsIlve(true);
        //        motivoConsulta.setCausaSelect(CAUSA_OTRA);
        motivoConsulta.setFinalidadSelect(FINALIDAD_CONSULTA_NO_APLICA);
        motivoConsulta.setRenderEcografia(true);
        motivoConsulta.setOcultarasesoria(true);
        motivoConsulta.setRenderConocioProfamilia(true);
        motivoConsulta.setEnfermedadOpcional(true);
      //  motivoConsulta.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_INTERRUPCION);
       // if (primeraConsulta) {
	   motivoConsulta.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_DETALLADOS_INTERRUPCION);
	// }
        
        motivoConsulta.setMenuBean("menuHistoriaInterrupcionBean");
        motivoConsulta.inicializarMotivo();
        renderAntecedentesGenerales = motivoConsulta.esValido();
        
        
	      if (!primeraConsulta) {
	      antecedentes = 
	              (AntecedentesUsuarioBean)FacesUtils.getManagedBean("antecedentesUsuarioBean");
	      antecedentes.setTipoServicio(TIPO_CONSULTA);
	      antecedentes.setNumeroConsulta(numeroConsulta);
	      antecedentes.setTipoHistoria(HISTORIA_INTERRUPCION);
	      antecedentes.setUsuario(datosBasicosUsuario.getUsuario());
	      antecedentes.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_DETALLADOS_INTERRUPCION);
	      antecedentes.setMenuBean("menuHistoriaInterrupcionBean");
	      renderAntecedentesInterrupcion = motivoConsulta.esValido();
	      antecedentes.inicializarAntecedentes();
              }      
        
	      if (primeraConsulta) {
	      antecedentesGenerales = 
	              (AntecedentesGeneralesUsuarioBean)FacesUtils.getManagedBean("antecedentesGeneralesUsuarioBean");
	      antecedentesGenerales.setTipoServicio("C");
	      antecedentesGenerales.setTipoHistoria(IConstantes.HISTORIA_INTERRUPCION);
	      antecedentesGenerales.setNumeroConsulta(numeroConsulta);
	      antecedentesGenerales.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_DETALLADOS_INTERRUPCION);
	      antecedentesGenerales.setMenuBean("menuHistoriaInterrupcionBean");
	     
	          renderAntecedentesInterrupcion = 
                  motivoConsulta.esValido();
	      antecedentesGenerales.inicializarAntecedentes();
	      
              }       
     
            antecedentesDetallados = 
                    (AntecedentesUsuarioDetalladoBean)FacesUtils.getManagedBean("antecedentesUsuarioDetalladoBean");
            antecedentesDetallados.setTipoServicio("C");
            antecedentesDetallados.setNumeroConsulta(numeroConsulta);
            antecedentesDetallados.setTipoHistoria(IConstantes.HISTORIA_INTERRUPCION);
            antecedentesDetallados.setUsuario(datosBasicosUsuario.getUsuario());
            antecedentesDetallados.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_GINECOLOGICOS_INTERRUPCION);
            antecedentesDetallados.setMenuBean("menuHistoriaInterrupcionBean");
            if (sexo != null && sexo.equals("M")) {
                antecedentesDetallados.setNextAction(BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_INTERRUPCION);
                renderEncuestaViolencia = true;
            } else if (sexo != null && sexo.equals("F"))
                renderAntecedentesGinecologicos = antecedentesDetallados.esValido();
            antecedentesDetallados.setRenderPrimeraVez(primeraConsulta);
            antecedentesDetallados.inicializarAntecedentes();
        
        /*if (primeraConsulta) {
            antecedentesGenerales = 
                    (AntecedentesGeneralesUsuarioBean)FacesUtils.getManagedBean("antecedentesGeneralesUsuarioBean");
            antecedentesGenerales.setTipoServicio("C");
            antecedentesGenerales.setTipoHistoria(IConstantes.HISTORIA_INTERRUPCION);
            antecedentesGenerales.setNumeroConsulta(numeroConsulta);
            antecedentesGenerales.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_GINECOLOGICOS_INTERRUPCION);
            antecedentesGenerales.setMenuBean("menuHistoriaInterrupcionBean");
            if (sexo != null && sexo.equals("M")) {
                antecedentesGenerales.setNextAction(BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_INTERRUPCION);
                renderEncuestaViolencia = true;
            } else if (sexo != null && sexo.equals("F"))
                renderAntecedentesGinecologicos = 
                        antecedentesGenerales.esValido();
            antecedentesGenerales.inicializarAntecedentes();
        }
        */
        antecedentesGinecologicos = 
                (AntecedentesGinecologicosUsuarioBean)FacesUtils.getManagedBean("antecedentesGinecologicosUsuarioBean");
        antecedentesGinecologicos.setTipoServicio("C");
        antecedentesGinecologicos.setNumeroConsulta(numeroConsulta);
        antecedentesGinecologicos.setUsuario(datosBasicosUsuario.getUsuario());
	antecedentesGinecologicos.setTipoHistoria(IConstantes.HISTORIA_INTERRUPCION);
        antecedentesGinecologicos.setNextAction(BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_INTERRUPCION);
        antecedentesGinecologicos.setMenuBean("menuHistoriaInterrupcionBean");
        antecedentesGinecologicos.inicializarAntecedentesGinecologicos();
        antecedentesGinecologicos.setOcultarmensaje(true);
        antecedentesGinecologicos.setEsIlve(true);
        renderEncuestaViolencia = antecedentesGinecologicos.esValido();
        if (antecedentesGinecologicos != null)
            antecedenteObject = antecedentesGinecologicos.getAntecedente();

        encuestaViolenciaUsuario = 
                (EncuestaViolenciaUsuarioBean)FacesUtils.getManagedBean("encuestaViolenciaUsuarioBean");
        encuestaViolenciaUsuario.setTipoServicio("C");
        encuestaViolenciaUsuario.setNumeroConsulta(numeroConsulta);
        encuestaViolenciaUsuario.setNextAction(BeanNavegacion.RUTA_IR_PSICOEMOCIONAL_INTERRUPCION);
        encuestaViolenciaUsuario.setMenuBean("menuHistoriaInterrupcionBean");
        encuestaViolenciaUsuario.inicializarEncuesta();
        renderEstadoPsico = encuestaViolenciaUsuario.esValido();

        estadoPsicoemocional = 
                (EstadoPsicoemocionalBean)FacesUtils.getManagedBean("estadoPsicoemocionalBean");
        estadoPsicoemocional.setTipoServicio("C");
        estadoPsicoemocional.setNumeroConsulta(numeroConsulta);
        estadoPsicoemocional.setNextAction(BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_INTERRUPCION);
        estadoPsicoemocional.setMenuBean("menuHistoriaInterrupcionBean");
        estadoPsicoemocional.inicializarEstadoPsicoemocional();
        renderEscalaCaidas = estadoPsicoemocional.esValido();

        registrarEscalaValoracionCaidasBean = 
                (RegistrarEscalaValoracionCaidasCEBean)FacesUtils.getManagedBean("registrarEscalaValoracionCaidasCEBean");
        registrarEscalaValoracionCaidasBean.setNumeroConsulta(numeroConsulta);
        if (datosBasicosUsuario != null && 
            datosBasicosUsuario.getUsuario() != null && 
            datosBasicosUsuario.getUsuario().getHuslnumero() != null) {
            registrarEscalaValoracionCaidasBean.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
        }
        registrarEscalaValoracionCaidasBean.setMenuBean("menuHistoriaInterrupcionBean");
        registrarEscalaValoracionCaidasBean.setNextAction(BeanNavegacion.RUTA_IR_EXAMENFISICO_INTERRUPCION);
        registrarEscalaValoracionCaidasBean.init();
        renderExamen = registrarEscalaValoracionCaidasBean.esValido();


        examenFisicoUsuario = 
                (ExamenFisicoUsuarioBean)FacesUtils.getManagedBean("examenFisicoUsuarioBean");
        examenFisicoUsuario.setTipoServicio("C");
        examenFisicoUsuario.setNumeroConsulta(numeroConsulta);
        examenFisicoUsuario.setNextAction(BeanNavegacion.RUTA_IR_IDENTIFICACION_RIESGOS_INTERRUPCION);
        examenFisicoUsuario.setNextAction2(BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_INTERRUPCION);
        examenFisicoUsuario.setMenuBean("menuHistoriaInterrupcionBean");
        examenFisicoUsuario.setConsecutivo(1);
        examenFisicoUsuario.setUsuario(datosBasicosUsuario.getUsuario());
	examenFisicoUsuario.setTipoHistoria(IConstantes.HISTORIA_INTERRUPCION);
        examenFisicoUsuario.setRenderMaculino(renderMasculino);
        examenFisicoUsuario.setRenderIve(true);
        examenFisicoUsuario.setRenderEscala(false);
        examenFisicoUsuario.inicializarExamen();
        renderIdentificacionRiegos = examenFisicoUsuario.esValido();
        
        if(!examenFisicoUsuario.confirmaEmbarazo() && examenFisicoUsuario.esValido()){
            renderIdentificacionRiegos = false; 
            renderAsesoriaIVE = false; 
            renderImpresionDiagnostica = true;
            confirmaEmbarazo =  false; 
        }
        
        if (examenFisicoUsuario != null && 
            examenFisicoUsuario.getExamen() != null) {
            tensionArterial = 
                    (new StringBuilder()).append(examenFisicoUsuario.getExamen().getHefcpresart1()).append("/").append(examenFisicoUsuario.getExamen().getHefcpresart2()).toString();
            frecuenciaCardiaca = 
                    examenFisicoUsuario.getExamen().getHefnfreccard();
            frecuenciaRespiratoria = 
                    examenFisicoUsuario.getExamen().getHefnfrecresp();
            peso = examenFisicoUsuario.getExamen().getHefapeso();
            hallazgos = examenFisicoUsuario.getExamen().getHefthallazgo();
            temperatura = examenFisicoUsuario.getExamen().getHefatemperatu();
        }

        if(confirmaEmbarazo){
            identificacionRiesgos = 
                    (IdentificacionRiegosBean)FacesUtils.getManagedBean("identificacionRiesgoBean");
            identificacionRiesgos.setNumeroConsulta(numeroConsulta);
            identificacionRiesgos.setUsuario(datosBasicosUsuario.getUsuario());
            identificacionRiesgos.setNextAction(BeanNavegacion.RUTA_IR_INTERRUPCION_ILVE);
            identificacionRiesgos.setMenuBean("menuHistoriaInterrupcionBean");
            identificacionRiesgos.iniciarIdentificacionBean();
            identificacionRiesgos.setRenderPreguntasIVE(true);
            renderRemision = identificacionRiesgos.esValido();
            
           // asesoriaIVE = (AsesoriaIveBean)FacesUtils.getManagedBean("asesoriaIveBean");
           // asesoriaIVE.setNumeroConsulta(numeroConsulta);
            //asesoriaIVE.setUsuario(datosBasicosUsuario.getUsuario());
           // asesoriaIVE.setNextAction(BeanNavegacion.RUTA_IR_INTERRUPCION_ILVE);
           // asesoriaIVE.setMenuBean("menuHistoriaInterrupcionBean");
           // asesoriaIVE.inicializarasesoria();
           // renderRemision = asesoriaIVE.esValido();
            
            if (antecedentesGinecologicos != null && 
                antecedentesGinecologicos.getAntecedente() != null && 
                antecedentesGinecologicos.getAntecedente().getHagdfur() != null) {
                numeroSemanas = 
                        calcularSemanasEmbarazo(antecedentesGinecologicos.getAntecedente().getHagdfur());
                numeroDias = 
                        calcularDiasEmbarazo(antecedentesGinecologicos.getAntecedente().getHagdfur());
            }
        }
       

	      remIlveBean = 
	              (RemisionIlveBean)FacesUtils.getManagedBean("remisionIlveBean");
	      remIlveBean.setUsuario(datosBasicosUsuario.getUsuario());
	      remIlveBean.setTipoServicio("C");
	      remIlveBean.setNumeroSemanasEmbarazo(numeroSemanasEcografia);
	      remIlveBean.setNumeroDiasEmbarazo(numeroDiasEcografia);
	      remIlveBean.setNumeroConsulta(numeroConsulta);
	      remIlveBean.setMenuBean("menuHistoriaInterrupcionBean");
	      remIlveBean.inicializarRemision();
              
	      // METODOS DE PLANIFICACION
	       List<Cnconsclin> consultaMetodoList = null;
              if(datosBasicosUsuario.getConsulta() != null && datosBasicosUsuario.getConsulta().getCconnumdoc() != null){
                  try {
                      consultaMetodoList = 
                              this.serviceLocator.getClinicoService().getConsultaAdmisionXGrupoSubGrupoInterrupcion(datosBasicosUsuario.getConsulta().getCconnumdoc().longValue());
                  } catch (ModelException e) {
                      e.printStackTrace();
                  }
              }
              
	      metodos = 
	              (MetodosAnticoncepcionBean)FacesUtils.getManagedBean("metodosAnticoncepcionBean");
	      metodos.setUsuario(datosBasicosUsuario.getUsuario());
	      metodos.setTipoServicio(TIPO_CONSULTA);
	      metodos.setNumeroConsulta(numeroConsulta);
	      metodos.setSexo(sexo);
	      metodos.setMenuBean("menuHistoriaInterrupcionBean");
	      metodos.setServicioMetodoPaqList(consultaMetodoList);

	      if (consultaMetodoList != null && 
	          !consultaMetodoList.isEmpty()) {
	              metodos.setNextAction(BeanNavegacion.RUTA_IR_APLICACION_RETITO_INTERRUPCION_ILVE);
	          
	      }else{
	              metodos.setNextAction(BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_IVE_INTERRUPCION);
	      }

	      metodos.inicializarMetodo();
	      boolean renderMetodoRegistro = false;
	      renderMetodoRegistro = metodos.esValido();
              
	      // APLICACION - RETIRO DISPOSITIVOS
	      dispositivos = 
	              (AplicacionDispositivoBean)FacesUtils.getManagedBean("aplicacionDispositivoBean");
	      dispositivos.setUsuario(datosBasicosUsuario.getUsuario());
	      dispositivos.setTipoServicio(TIPO_CONSULTA);
	      dispositivos.setNumeroConsulta(numeroConsulta);
	      dispositivos.setMenuBean("menuHistoriaInterrupcionBean");
	      dispositivos.setNextAction(BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_IVE_INTERRUPCION);
	      dispositivos.inicializarAplicacionDispositivo();

        if (remIlveBean != null && remIlveBean.getRemision() != null && 
            "S".equals(remIlveBean.getRemision().getHricinicimetod()) && consultaMetodoList != null && !consultaMetodoList.isEmpty()
            && examenFisicoUsuario != null && examenFisicoUsuario.getExamen() != null && "S".equals(examenFisicoUsuario.getExamen().getHefcconfiembar())) {
            renderMetodos = true;
            
            remIlveBean.setNextAction(BeanNavegacion.RUTA_IR_METODO_INTERRUPCION);
            remIlveBean.setNextAction2(BeanNavegacion.RUTA_IR_METODO_INTERRUPCION);
            remIlveBean.inicializarRemision();

            if (renderMetodoRegistro && consultaMetodoList!= null && !consultaMetodoList.isEmpty()) {
                if (metodos.getDiagnostico() != null && 
                    metodos.getDiagnostico().getHedcmetodopaci() != null) {
                    boolean exitenServicios = false;
                    List<Integer> listaTipoHistoria = new ArrayList();
                    listaTipoHistoria.add(28);
                    listaTipoHistoria.add(29);
                    listaTipoHistoria.add(60);
                    try {
                        exitenServicios = 
                                this.serviceLocator.getClinicoService().getConsultaAdmisionXTiposHistorias(datosBasicosUsuario.getConsulta().getCconnumdoc().longValue(), 
                                                                                                           listaTipoHistoria);
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    if (exitenServicios) {
                        renderDispositivos = true;
                    }

                }

            }
        } else {
            renderMetodos = false;
            renderDispositivos = false;
            remIlveBean.setNextAction(BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_IVE_INTERRUPCION);
            remIlveBean.setNextAction2(BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_INTERRUPCION);
            remIlveBean.inicializarRemision();

        }
	     
	      

	      boolean ilvefarmacologico = false;
	      boolean ilveameu = false;
	      boolean ilvedilatacion = false;
	      boolean continuaIve = false;

	      if (remIlveBean != null && remIlveBean.getRemision() != null && 
	          remIlveBean.getRemision().getHrictiporemis() != null) {

	          if (remIlveBean.getRemision().getHrictiporemis().equals("QL") 
                  || remIlveBean.getRemision().getHrictiporemis().equals("QG")
                  || remIlveBean.getRemision().getHrictiporemis().equals("AG")
                  || remIlveBean.getRemision().getHrictiporemis().equals("AB")) {
	              ilveameu = true;
	          }

	          if (remIlveBean.getRemision().getHrictiporemis().equals("IM") ||
                  remIlveBean.getRemision().getHrictiporemis().equals("FA")) {
	              ilvefarmacologico = true;
	          }
	          
	          if (remIlveBean.getRemision().getHrictiporemis().equals("DE")) {
	              ilvedilatacion = true;
	          }
	          
	          
	      }
              
            if (!confirmaEmbarazo){
                renderImpresionDiagnostica = examenFisicoUsuario.esValido();
            }else{
                if(remIlveBean != null ){
                    continuaIve = remIlveBean.isRenderContinua(); 
                }
                
                if(continuaIve){
                    renderImpresionDiagnosticaIVE = remIlveBean.esValido();
                }else{
                    renderImpresionDiagnostica = remIlveBean.esValido();
                }
            }
	      
              
	      impresionDiagnosticaIveUsuarioBean = 
	              (ImpresionDiagnosticaIlveBean)FacesUtils.getManagedBean("impresionDiagnosticaIlveBean");
	      impresionDiagnosticaIveUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
	      impresionDiagnosticaIveUsuarioBean.setTipoServicio("C");
	      impresionDiagnosticaIveUsuarioBean.setNumeroConsulta(numeroConsulta);
	      impresionDiagnosticaIveUsuarioBean.setConsecutivo(1);
	      
	      impresionDiagnosticaIveUsuarioBean.setNextAction(BeanNavegacion.RUTA_IR_RECOMENDACIONES_INTERRUPCION);
	      impresionDiagnosticaIveUsuarioBean.setNextAction2(BeanNavegacion.RUTA_IR_RECOMENDACIONES_INTERRUPCION);
	      impresionDiagnosticaIveUsuarioBean.setSemanaEmbarazo(numeroSemanas);
	      impresionDiagnosticaIveUsuarioBean.setRenderHistoriaIlve(true);
	      impresionDiagnosticaIveUsuarioBean.setCodigoDiagnostico(IConstantes.CODIGO_PRINCIPAL_CONSULTA_ILVE);
	      impresionDiagnosticaIveUsuarioBean.setCodigoRelacionado1(IConstantes.CODIGO_REL1_EXTRACCION_MENSUAL);
	      impresionDiagnosticaIveUsuarioBean.setCodigoRelacionado2(IConstantes.CODIGO_RELACIONADO2_CONSULTA_ILVE);
	      impresionDiagnosticaIveUsuarioBean.setCodigoRelacionado3(IConstantes.CODIGO_REL3_ASESORAMIENTO_GENERAL_ANTICONCEPCION);
	      impresionDiagnosticaIveUsuarioBean.setDisableRel1(false);
	      impresionDiagnosticaIveUsuarioBean.setRequiredRel2(true);
	          //impresionDiagnosticaUsuarioBean.setCodigoRelacionado3(IConstantes.CODIGO_REL3_PROBLEMAS_EMBARAZO_NO_DESEADO);
	      impresionDiagnosticaIveUsuarioBean.setCodigoRelacionado3(IConstantes.CODIGO_REL2_ASESORAMIENTO_GENERAL_ANTICONCEPCION);
	      impresionDiagnosticaIveUsuarioBean.setDisableRel3(false);

	      impresionDiagnosticaIveUsuarioBean.setDesHabilitarDiagnosticoPrincipal(false);
	      impresionDiagnosticaIveUsuarioBean.setTipoDiagnostico(TIPO_IMPRESION_DIAGNOSTICA);
	      
	      impresionDiagnosticaIveUsuarioBean.setMenuBean("menuHistoriaInterrupcionBean");
	      impresionDiagnosticaIveUsuarioBean.inicializarImpresion();
              
	      if (impresionDiagnosticaIveUsuarioBean != null && 
	          impresionDiagnosticaIveUsuarioBean.getImpresion() != null && 
	          impresionDiagnosticaIveUsuarioBean.getImpresion().getHidnsemanembar() != 
	          null) {
	          numeroSemanasEcografia = 
	                  impresionDiagnosticaIveUsuarioBean.getImpresion().getHidnsemanembar();
	          numeroDiasEcografia = numeroSemanasEcografia * 7;
	      }



	      if (impresionDiagnosticaIveUsuarioBean != null && 
	          impresionDiagnosticaIveUsuarioBean.getImpresion() != null && 
	          impresionDiagnosticaIveUsuarioBean.getImpresion().getHidcdiagprin() != 
	          null) {
	          cie10Principal = 
	                  impresionDiagnosticaIveUsuarioBean.getImpresion().getHidcdiagprin();
	          cie10Relacionado1 = 
	                  impresionDiagnosticaIveUsuarioBean.getImpresion().getHidcdiagrela1();
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
	      impresionDiagnosticaUsuarioBean.setNextAction(BeanNavegacion.RUTA_IR_RECOMENDACIONES_INTERRUPCION);
	      impresionDiagnosticaUsuarioBean.setMenuBean("menuHistoriaInterrupcionBean");
	      impresionDiagnosticaUsuarioBean.setDesHabilitarDiagnosticoPrincipal(false);
	      impresionDiagnosticaUsuarioBean.inicializarImpresion();
              

	      if(continuaIve){
                  renderConducta = impresionDiagnosticaIveUsuarioBean.esValido();
            }else{
               renderConducta = impresionDiagnosticaUsuarioBean.esValido();
              }

      
        recomedacionUsuarioBean = 
                (RecomedacionUsuarioBean)FacesUtils.getManagedBean("recomedacionUsuarioBean");
        recomedacionUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        recomedacionUsuarioBean.setTipoServicio("C");
        recomedacionUsuarioBean.setNumeroConsulta(numeroConsulta);
        recomedacionUsuarioBean.setMenuBean("menuHistoriaInterrupcionBean");
        recomedacionUsuarioBean.inicializarRecomedaciones();
        renderCerrarConsulta = recomedacionUsuarioBean.esValido();
        anatomiaPatologicaUsuarioBean = 
                (AnatomiaPatologicaUsuarioBean)FacesUtils.getManagedBean("anatomiaPatolUsuarioBean");
        anatomiaPatologicaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        anatomiaPatologicaUsuarioBean.setTipoServicio("C");
        anatomiaPatologicaUsuarioBean.setNumeroConsulta(numeroConsulta);
        anatomiaPatologicaUsuarioBean.setAntecedente(antecedenteObject);
        anatomiaPatologicaUsuarioBean.setConsecutivo(Integer.valueOf(1));
        anatomiaPatologicaUsuarioBean.setMenuBean("menuHistoriaInterrupcionBean");
        anatomiaPatologicaUsuarioBean.inicializarAnatomiaPatol();
        controlSinCostoUsuarioBean = 
                (ControlSinCostoUsuarioBean)FacesUtils.getManagedBean("controlSinCostoUsuarioBean");
        controlSinCostoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        controlSinCostoUsuarioBean.setTipoServicio("C");
        controlSinCostoUsuarioBean.setCodigoCups(codigoCups);
        controlSinCostoUsuarioBean.setNumeroConsulta(numeroConsulta);
        controlSinCostoUsuarioBean.setMenuBean("menuHistoriaInterrupcionBean");
        controlSinCostoUsuarioBean.inicializarControlSinCosto();

        List<Chformulamed> lstPrescripciones;
        lstPrescripciones = new ArrayList<Chformulamed>();

        Chformulamed formula = null;
        if (ilvefarmacologico || ilveameu || ilvedilatacion) {
            formula = new Chformulamed();
            formula.setHfocoperador(userName());
            formula.setHfoccontraindi("");
            formula.setHfodfecregistr(new Date());

            if (ilvefarmacologico) {
                formula = new Chformulamed();
                formula.setImprimir(true);
                formula.setHfocadosis(4);
                formula.setHfocmedicament("MISOPROSTOL 200MG TABLETA");
                formula.setHfoctratramien("Aplicar las 4 tabletas  a las 48 horas de la mifepristona  ");
                formula.setHfocviadministr("Vsl");
                formula.setHfoccontraindi("");
                formula.setHfodfecregistr(new Date());
                formula.setHfocoperador(userName());
                formula.setHfoccontraindi("Colocar debajo de la lengua hasta que se disuelva la pastilla ");
                formula.setHfoctiposerv("C");
                formula.setHfocconcentr("200");
                formula.setHfocunidmedi("mcg");
                formula.setHfocformafarma("TABL");
                formula.setHfoccodisap("1000000028");
                lstPrescripciones.add(formula);
                
                formula = new Chformulamed();
                formula.setImprimir(true);
                formula.setHfocadosis(1);
                formula.setHfocmedicament("MIFEPRISTONA ");
                formula.setHfoctratramien("Tomar 1 tableta �nica dosis ");
                formula.setHfocviadministr("VO");
                formula.setHfoccontraindi("");
                formula.setHfodfecregistr(new Date());
                formula.setHfocoperador(userName());
                formula.setHfoccontraindi("");
                formula.setHfoctiposerv("C");
                formula.setHfocconcentr("200");
                formula.setHfocunidmedi("MG");
                formula.setHfocformafarma("TABL");
                formula.setHfoccodisap("1000001122");
                lstPrescripciones.add(formula);
                
                formula = new Chformulamed();
                formula.setImprimir(true);
                formula.setHfocadosis(2);
                formula.setHfocmedicament("IBUPROFENO");
                formula.setHfoctratramien("Dosis inicial de 2 tabletas y continuar con 1 tableta cada 4-8 horas seg�n dolor. ");
                formula.setHfocviadministr("VO");
                formula.setHfoccontraindi("");
                formula.setHfodfecregistr(new Date());
                formula.setHfocoperador(userName());
                formula.setHfoccontraindi("");
                formula.setHfoctiposerv("C");
                formula.setHfocconcentr("400");
                formula.setHfocunidmedi("mg");
                formula.setHfocformafarma("TABL");
                
                formula.setHfoccodisap("1000000550");
                lstPrescripciones.add(formula);
            }

            if (ilveameu) {
                formula = new Chformulamed();
                formula.setImprimir(true);
                formula.setHfocadosis(2);
                formula.setHfocmedicament("MISOPROSTOL 200MG TABLETA");
                formula.setHfoctratramien("Medicaci�n para maduraci�n cervical  ");
                formula.setHfocviadministr("VA");
                formula.setHfoccontraindi("");
                formula.setHfodfecregistr(new Date());
                formula.setHfocoperador(userName());
                formula.setHfoccontraindi("Este medicamento ser� administrado  directamente por el profesional de la medicina o enfermeria ");
                formula.setHfoctiposerv("C");
                formula.setHfocconcentr("200");
                formula.setHfocunidmedi("mcg");
                formula.setHfocformafarma("TABL");
                formula.setHfoccodisap("1000000028");
                lstPrescripciones.add(formula);
                
                // MAyor a 12 semanas 
                if(numeroSemanasEcografia >= 12){
                    formula = new Chformulamed();
                    formula.setImprimir(true);
                    formula.setHfocadosis(1);
                    formula.setHfocmedicament("MIFEPRISTONA ");
                    formula.setHfoctratramien("Tomar 1 tableta �nica dosis 24 a 48 horas de anterioridad a la aplicaci�n del misoprostol");
                    formula.setHfocviadministr("VO");
                    formula.setHfoccontraindi("");
                    formula.setHfodfecregistr(new Date());
                    formula.setHfocoperador(userName());
                    formula.setHfoccontraindi("");
                    formula.setHfoctiposerv("C");
                    formula.setHfocconcentr("200");
                    formula.setHfocunidmedi("MG");
                    formula.setHfocformafarma("TABL");
                    formula.setHfoccodisap("1000001122");
                    lstPrescripciones.add(formula);
                }
                
                

            }
            
            
            if (ilvedilatacion) {
                formula = new Chformulamed();
                formula.setImprimir(true);
                formula.setHfocadosis(2);
                formula.setHfocmedicament("MISOPROSTOL 200MG TABLETA");
                formula.setHfoctratramien("Medicaci�n para maduraci�n cervical  ");
                formula.setHfocviadministr("VA");
                formula.setHfoccontraindi("");
                formula.setHfodfecregistr(new Date());
                formula.setHfocoperador(userName());
                formula.setHfoccontraindi("Este medicamento ser� administrado  directamente por el profesional de la medicina o enfermeria ");
                formula.setHfoctiposerv("C");
                formula.setHfocconcentr("200");
                formula.setHfocunidmedi("mcg");
                formula.setHfocformafarma("TABL");
                formula.setHfoccodisap("1000000028");
                lstPrescripciones.add(formula);
                
                
                formula = new Chformulamed();
                formula.setImprimir(true);
                formula.setHfocadosis(1);
                formula.setHfocmedicament("MIFEPRISTONA ");
                formula.setHfoctratramien("Tomar 1 tableta �nica dosis 24 a 48 horas de anterioridad a la aplicaci�n del misoprostol");
                formula.setHfocviadministr("VO");
                formula.setHfoccontraindi("");
                formula.setHfodfecregistr(new Date());
                formula.setHfocoperador(userName());
                formula.setHfoccontraindi("");
                formula.setHfoctiposerv("C");
                formula.setHfocconcentr("200");
                formula.setHfocunidmedi("MG");
                formula.setHfocformafarma("TABL");
                formula.setHfoccodisap("1000001122");
                lstPrescripciones.add(formula);
                
                
            }



          


        }


        formulaMedicaUsuarioBean = 
                (FormulaMedicaUsuarioBean)FacesUtils.getManagedBean("formulaMedicaUsuarioBean");
        formulaMedicaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        formulaMedicaUsuarioBean.setTipoServicio("C");
        formulaMedicaUsuarioBean.setNumeroConsulta(numeroConsulta);
        formulaMedicaUsuarioBean.setCodigoCIE10(cie10Principal);
        formulaMedicaUsuarioBean.setConsecutivo(Integer.valueOf(1));
        formulaMedicaUsuarioBean.setMenuBean("menuHistoriaInterrupcionBean");
        formulaMedicaUsuarioBean.inicializardFormulaMedica();

        // CONDUCTA - FORMULA MEDICA
        vademecumUsuarioBean = 
                (VademecumMedicoBean)FacesUtils.getManagedBean("vademecumMedicoBean");
        vademecumUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        vademecumUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        vademecumUsuarioBean.setNumeroConsulta(numeroConsulta);
        vademecumUsuarioBean.setLstPrescripcionesDefecto(lstPrescripciones);
        vademecumUsuarioBean.setCodigoCIE10(cie10Principal);
        vademecumUsuarioBean.setConsecutivo(1);
        vademecumUsuarioBean.setMenuBean("menuHistoriaInterrupcionBean");
        vademecumUsuarioBean.setRenderAlertaIve(true);
        vademecumUsuarioBean.inicializardFormulaMedica();


        hospitalizacionUsuarioBean = 
                (HospitalizacionUsuarioBean)FacesUtils.getManagedBean("hospitalizacionUsuarioBean");
        hospitalizacionUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        hospitalizacionUsuarioBean.setTipoServicio("C");
        hospitalizacionUsuarioBean.setNumeroConsulta(numeroConsulta);
        hospitalizacionUsuarioBean.setCiel0Principal(cie10Principal);
        hospitalizacionUsuarioBean.setConsecutivo(Integer.valueOf(1));
        hospitalizacionUsuarioBean.setMenuBean("menuHistoriaInterrupcionBean");
        hospitalizacionUsuarioBean.inicializarHospitalizacion();
        ordenCirugiaUsuarioBean = 
                (OrdenCirugiaUsuarioBean)FacesUtils.getManagedBean("ordenCirugiaUsuarioBean");
        ordenCirugiaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        ordenCirugiaUsuarioBean.setTipoServicio("C");
        ordenCirugiaUsuarioBean.setNumeroConsulta(numeroConsulta);
        ordenCirugiaUsuarioBean.setMenuBean("menuHistoriaInterrupcionBean");
        ordenCirugiaUsuarioBean.setConsecutivo(Integer.valueOf(1));
	      if (datosBasicosUsuario.getConsulta() != null) {
	          Long tipoDocuentoAdmision = 
	              datosBasicosUsuario.getConsulta().getCcontipdoc().getCtdnnumero().longValue();
	          if (tipoDocuentoAdmision == IConstantes.TIPO_DOCUMENTO_ADMISION) {
	                  ordenCirugiaUsuarioBean.setNumeroAdmision(datosBasicosUsuario.getConsulta().getCconnumdoc().longValue());
	          }
	      }
        ordenCirugiaUsuarioBean.inicializarOrdenCirugia();
        interConsultaUsuarioBean = 
                (InterConsultaUsuarioBean)FacesUtils.getManagedBean("interConsultaUsuarioBean");
        interConsultaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        interConsultaUsuarioBean.setTipoServicio("C");
        if (ilveameu || ilvedilatacion) {
            interConsultaUsuarioBean.setEsIlve(true);
        }
        interConsultaUsuarioBean.setNumeroConsulta(numeroConsulta);
        interConsultaUsuarioBean.setCie10Principal(cie10Principal);
        interConsultaUsuarioBean.setConsecutivo(Integer.valueOf(1));
        interConsultaUsuarioBean.setMenuBean("menuHistoriaInterrupcionBean");
	      if (datosBasicosUsuario.getConsulta() != null) {
	          Long tipoDocuentoAdmision = 
	              datosBasicosUsuario.getConsulta().getCcontipdoc().getCtdnnumero().longValue();
	          if (tipoDocuentoAdmision == IConstantes.TIPO_DOCUMENTO_ADMISION) {
	                  interConsultaUsuarioBean.setNumeroAdmision(datosBasicosUsuario.getConsulta().getCconnumdoc().longValue());
	          }
	      }
        interConsultaUsuarioBean.inicializarInterConsulta();
        incapacidadUsuarioBean = 
                (IncapacidadUsuarioBean)FacesUtils.getManagedBean("incapacidadUsuarioBean");
        incapacidadUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        incapacidadUsuarioBean.setTipoServicio("C");
        incapacidadUsuarioBean.setNumeroConsulta(numeroConsulta);
        incapacidadUsuarioBean.setCie10Principal(cie10Principal);
        incapacidadUsuarioBean.setCie10Relacionado1(cie10Relacionado1);
        incapacidadUsuarioBean.setCodigoCups(codigoCups);
        incapacidadUsuarioBean.setConsecutivo(Integer.valueOf(1));
        incapacidadUsuarioBean.setMenuBean("menuHistoriaInterrupcionBean");
        incapacidadUsuarioBean.inicializarIncapacidad();

        referenciaUsuarioBean = 
                (ReferenciaUsuarioBean)FacesUtils.getManagedBean("referenciaUsuarioBean");
        referenciaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        referenciaUsuarioBean.setTipoServicio("C");
        referenciaUsuarioBean.setNumeroConsulta(numeroConsulta);
        referenciaUsuarioBean.setConsultaAux(datosBasicosUsuario.getConsulta());
        referenciaUsuarioBean.setTensionArterial(tensionArterial);
        referenciaUsuarioBean.setFrecuenciaCardiaca(frecuenciaCardiaca);
        referenciaUsuarioBean.setFrecuenciaRespiratoria(frecuenciaRespiratoria);
        referenciaUsuarioBean.setPeso(peso);
        referenciaUsuarioBean.setHallazgos(hallazgos);
        referenciaUsuarioBean.setTemperatura(temperatura);
        referenciaUsuarioBean.setConsecutivo(Integer.valueOf(1));
        referenciaUsuarioBean.setMenuBean("menuHistoriaInterrupcionBean");
        referenciaUsuarioBean.inicializarReferencia();


        autorizacionServicioUsuarioBean = 
                (AutorizacionServicioUsuarioBean)FacesUtils.getManagedBean("autorizacionServicioUsuarioBean");
        autorizacionServicioUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());

        autorizacionServicioUsuarioBean.setTipoServicio("C");
        autorizacionServicioUsuarioBean.setNumeroConsulta(numeroConsulta);
        autorizacionServicioUsuarioBean.setTipoHistoria(motivoConsulta.getTipoHistoria());
        autorizacionServicioUsuarioBean.setOrigenAtencion(motivoConsulta.getCausaSelect());
        autorizacionServicioUsuarioBean.setCodigoCups(codigoCups);
       // autorizacionServicioUsuarioBean.setTipoDiagnostico(impresionDiagnosticaIveUsuarioBean.getTipoDiagnostico());
       //autorizacionServicioUsuarioBean.setCodigoDiagnostico(impresionDiagnosticaIveUsuarioBean.getCodigoDiagnostico());
       // autorizacionServicioUsuarioBean.setCodigoDiagnostico1(impresionDiagnosticaIveUsuarioBean.getCodigoRelacionado1());
        //autorizacionServicioUsuarioBean.setCodigoDiagnostico2(impresionDiagnosticaIveUsuarioBean.getCodigoRelacionado2());
        autorizacionServicioUsuarioBean.setMenuBean("menuHistoriaInterrupcionBean");
        autorizacionServicioUsuarioBean.inicializarAutorizacionServicio();


        reservaSangreUsuarioBean = 
                (ReservaSangreUsuarioBean)FacesUtils.getManagedBean("reservaSangreUsuarioBean");
        reservaSangreUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        reservaSangreUsuarioBean.setTipoServicio("C");
        reservaSangreUsuarioBean.setNumeroConsulta(numeroConsulta);
        reservaSangreUsuarioBean.setConsecutivo(Integer.valueOf(1));
        reservaSangreUsuarioBean.setMenuBean("menuHistoriaInterrupcionBean");
        reservaSangreUsuarioBean.inicializarReservaSangre();
        certMedicoUsuarioBean = 
                (CertMedicoUsuarioBean)FacesUtils.getManagedBean("certMedicoUsuarioBean");
        certMedicoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        certMedicoUsuarioBean.setTipoServicio("C");
        certMedicoUsuarioBean.setNumeroConsulta(numeroConsulta);
        certMedicoUsuarioBean.setMenuBean("menuHistoriaInterrupcionBean");
        certMedicoUsuarioBean.setConsecutivo(Integer.valueOf(1));
        certMedicoUsuarioBean.setEsCirugia(false);
        certMedicoUsuarioBean.inicializarCertificadoMedico();
        certAsistenciaUsuarioBean = 
                (CertAsistenciaUsuarioBean)FacesUtils.getManagedBean("certAsistenciaUsuarioBean");
        certAsistenciaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        certAsistenciaUsuarioBean.setTipoServicio("C");
        certAsistenciaUsuarioBean.setNumeroConsulta(numeroConsulta);
        certAsistenciaUsuarioBean.setCodigoCups(codigoCups);
        certAsistenciaUsuarioBean.setConsecutivo(Integer.valueOf(1));
        certAsistenciaUsuarioBean.setMenuBean("menuHistoriaInterrupcionBean");
        certAsistenciaUsuarioBean.inicializarCertificadoAsistencia();

        examElectrofisiologicoUsuarioBean = 
                (ExamElectrofisiologicoUsuarioBean)FacesUtils.getManagedBean("examElectrofisioUsuarioBean");
        examElectrofisiologicoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        examElectrofisiologicoUsuarioBean.setTipoServicio("C");
        examElectrofisiologicoUsuarioBean.setNumeroConsulta(numeroConsulta);
        examElectrofisiologicoUsuarioBean.setCie10Principal(cie10Principal);
        examElectrofisiologicoUsuarioBean.setConsecutivo(Integer.valueOf(1));
        examElectrofisiologicoUsuarioBean.setMenuBean("menuHistoriaInterrupcionBean");
        examElectrofisiologicoUsuarioBean.inicializarExamElectrofisiologico();

        examImagenUsuarioBean = 
                (ExamImagenUsuarioBean)FacesUtils.getManagedBean("examImagenUsuarioBean");
        examImagenUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        examImagenUsuarioBean.setTipoServicio("C");
        examImagenUsuarioBean.setNumeroConsulta(numeroConsulta);
        examImagenUsuarioBean.setAntecedente(antecedenteObject);
        examImagenUsuarioBean.setCie10Principal(cie10Principal);
        examImagenUsuarioBean.setConsecutivo(Integer.valueOf(1));
        examImagenUsuarioBean.setMenuBean("menuHistoriaInterrupcionBean");
        examImagenUsuarioBean.inicializarExamImagen();
        examLaboratorioUsuarioBean = 
                (ExamLaboratorioUsuarioBean)FacesUtils.getManagedBean("examLaboratorioUsuarioBean");
        examLaboratorioUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        examLaboratorioUsuarioBean.setTipoServicio("C");
        examLaboratorioUsuarioBean.setNumeroConsulta(numeroConsulta);
        examLaboratorioUsuarioBean.setCie10Principal(cie10Principal);
        examLaboratorioUsuarioBean.setConsecutivo(Integer.valueOf(1));
        examLaboratorioUsuarioBean.setMenuBean("menuHistoriaInterrupcionBean");
	      if (datosBasicosUsuario.getConsulta() != null) {
	          Long tipoDocuentoAdmision = 
	              datosBasicosUsuario.getConsulta().getCcontipdoc().getCtdnnumero().longValue();
	          if (tipoDocuentoAdmision == IConstantes.TIPO_DOCUMENTO_ADMISION) {
	                  examLaboratorioUsuarioBean.setNumeroAdmision(datosBasicosUsuario.getConsulta().getCconnumdoc().longValue());
	          }
	      }
        examLaboratorioUsuarioBean.inicializarExamLaboratorio();


        cerrarConsultaUsuarioBean = 
                (CerrarConsultaUsuarioBean)FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
        cerrarConsultaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        cerrarConsultaUsuarioBean.setMenuBean("menuHistoriaInterrupcionBean");
        cerrarConsultaUsuarioBean.setConsulta(datosBasicosUsuario.getConsulta());
        cerrarConsultaUsuarioBean.setEsVacunacion(false);
        cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
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
                      formulaHospitalizacionBean.setRenderIve(true);
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
    
    
    public String irPausarConsultaInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_PAUSAR_CONSULTA_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irDatosInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_DATOS_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irMotivoInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_MOTIVO_INTERRUPCION;
    }
    
    public String irCuestionarioCovidInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_INTERRUPCION;
        }


    /**
     * @return
     */
    public String irAntecedentesGeneralesInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_GENERALES_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irAntecedentesInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_INTERRUPCION;
        
    }
    

    /**
     * @return
     */
    public String irAntecedentesDetalladoInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_DETALLADOS_INTERRUPCION;
    }


    /**
     * @return
     */
    public String irAntecedentesGinecologicosInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_GINECOLOGICOS_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irExamenFisicoInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EXAMENFISICO_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irEstadoPsicoemocionalInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_PSICOEMOCIONAL_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irEncuestaViolenciaInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irImpDiagnosticaInterrupcionIve() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_IVE_INTERRUPCION;
    
    }
    /**
     * @return
     */
    public String irImpDiagnosticaInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irAnatPatologicaInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANATOMIAPATOLOGICA_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irControlSinCostoInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CONTOLSINCOSTO_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irFormulaMedicaInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FORMULAMEDICA_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irVademecumMedicoInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_VADEMCUM_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irRemHospitalizacionInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_HOSPITALZACION_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irIncapacidadInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INCAPACIDAD_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irInterConsultaInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INTERCONSULTA_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irOrdenCirugiaInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ORDENCIRUGIA_INTERRUPCION;
    }
    
    public String irServiciosAdmisionInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_SERVICIOS_ADMISION_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irReferenciaInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_REFERENCIA_INTERRUPCION;
    }


    /**
     * @return
     */
    public String irAutorizacionServicioInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_AUTORIZACION_SERVICIOS_INTERRUPCION;
    }

    /**
     * 
     * @return
     */
    public String irIdentificacionRiesgoInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IDENTIFICACION_RIESGOS_INTERRUPCION;
    }


    /**
     * @return
     */
    public String irReservaSangreInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESERVA_SANGRE_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irRecomedacionInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RECOMENDACIONES_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irCertMedicoInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADOMEDICO_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irCertAsistenciaInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADO_ASISTENCIA_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irExamElectrofisiologicoInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ELECTROFISIOLOGICO_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irExamImagenInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMAGENES_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irExamLaboratorioInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_LABORATORIO_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irCerrarConsultaInterrupcion() {
        if (cerrarConsultaUsuarioBean != null)
            cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
        return BeanNavegacion.RUTA_IR_CERRAR_CONSULTA_INTERRUPCION;
    }

    /**
     * @return
     */
    public String irRemisionIlveInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INTERRUPCION_ILVE;
    }
    
    
    /**
     * @return
     */
    public String irOrdenMedicamentosInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ORDEN_MEDICAMENTOS_INTERRUPCION; 
    }

    /**
     * @return
     */
    public String irOrdenLiquidosInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ORDEN_LIQUIDOS_INTERRUPCION;
    }
    
    public String irRegistrarOtrasOrdenesInterrupcion() {
        return BeanNavegacion.RUTA_IR_OTRAS_ORDENES_INTERRUPCION;
    }

    /**
     * @param renderEstadoPsico
     */
    public void setRenderEstadoPsico(boolean renderEstadoPsico) {
        this.renderEstadoPsico = renderEstadoPsico;
    }

    /**
     * @return
     */
    public boolean isRenderEstadoPsico() {
        return renderEstadoPsico;
    }

    /**
     * @return
     */
    public String irResumenHistoriaInterrupcion() {
        inicializarUsuario();
        CerrarConsultaUsuarioBean cerrarConsultaInterrupcion = 
            (CerrarConsultaUsuarioBean)FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
        cerrarConsultaInterrupcion.inicalizarCerrarConsultaBean();

        FacesUtils.resetManagedBean("consultarFoliosBean");

        ConsultarFoliosBean generarResumen = 
            (ConsultarFoliosBean)FacesUtils.getManagedBean("consultarFoliosBean");
        if (generarResumen != null) {
            generarResumen.init();
            generarResumen.setEncabezado(true);
            generarResumen.setUsuario(datosBasicosUsuario.getUsuario());
            generarResumen.consultarFoliosUsuario();

        }

        return "irResumenHistoriaInterrupcion";
    }

    public void inicializarUsuario() {
        if (datosBasicosUsuario.getUsuario() != null)
            setUsuario(datosBasicosUsuario.getUsuario());
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
     * @param renderRemision
     */
    public void setRenderRemision(boolean renderRemision) {
        this.renderRemision = renderRemision;
    }

    /**
     * @return
     */
    public boolean isRenderRemision() {
        return renderRemision;
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
        itemNode11.getChildren().add(new TreeNodeBase("itemNode11_1", "M�dico", 
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


    public MenuHistoriaInterrupcionBean() {
    }


    public void setNumeroSemanasEcografia(double numeroSemanasEcografia) {
        this.numeroSemanasEcografia = numeroSemanasEcografia;
    }

    public double getNumeroSemanasEcografia() {
        return numeroSemanasEcografia;
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

        return "irConsultaCertificadoInterrupcion";

    }

    public void openPopupClicked(ActionEvent event) {
        javaScriptText = "";
        Long numeroUsuario = null;
        String encodedText = "";
        String cod = "";

        numeroUsuario = datosBasicosUsuario.getUsuario().getHusanumeiden();

        if (numeroUsuario != null) {
            cod = "[N_MERO_ID_] = " + numeroUsuario.toString();
        }

        String urlString = "/apolo:80/DocuWare/";

        String encodedAuten;

        // Base64
        System.out.println("Numero Usuario String " + 
                           numeroUsuario.toString());
        encodedText = new String(Base64.encodeBase64(cod.getBytes()));
        // encodedAuten = new String(Base64.encodeBase64(autenticacion.getBytes()));


        urlString = urlString + encodedText;
        System.out.println(urlString);

        FacesContext facesContext = FacesContext.getCurrentInstance();

        // This is the proper way to get the view's url
        ViewHandler viewHandler = 
            facesContext.getApplication().getViewHandler();
        String actionUrl = urlString;


        javaScriptText = "window.open('http://wgesdoc/DocuWare/Platform/WebClient/1/Integration?p=RLV&fc=0ee1c783-c5e9-4232-b6cc-b651dd62bd02&q=" + encodedText + "' );";
        // Add the Javascript to the rendered page's header for immediate execution
        AddResource addResource = AddResourceFactory.getInstance(facesContext);

        addResource.addInlineScriptAtPosition(null, AddResource.HEADER_BEGIN, 
                                              javaScriptText);

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

    public void setRenderIdentificacionRiegos(boolean renderIdentificacionRiegos) {
        this.renderIdentificacionRiegos = renderIdentificacionRiegos;
    }

    public boolean isRenderIdentificacionRiegos() {
        return renderIdentificacionRiegos;
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
	
	
	
    public void setRenderServiciosAdmision(boolean renderServiciosAdmision) {
        this.renderServiciosAdmision = renderServiciosAdmision;
    }

    public boolean isRenderServiciosAdmision() {
        return renderServiciosAdmision;
    }

    public void setRenderOrdenesMedicas(boolean renderOrdenesMedicas) {
        this.renderOrdenesMedicas = renderOrdenesMedicas;
    }

    public boolean isRenderOrdenesMedicas() {
        return renderOrdenesMedicas;
    }
    
    /**
     * @return
     */
    public String irAsesoriaInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ASESORIA_INTERRUPCION;
    }

    public void setRenderAsesoriaIVE(boolean renderAsesoriaIVE) {
        this.renderAsesoriaIVE = renderAsesoriaIVE;
    }

    public boolean isRenderAsesoriaIVE() {
        return renderAsesoriaIVE;
    }

    public void setRenderAntecedentesInterrupcion(boolean renderAntecedentesInterrupcion) {
        this.renderAntecedentesInterrupcion = renderAntecedentesInterrupcion;
    }

    public boolean isRenderAntecedentesInterrupcion() {
        return renderAntecedentesInterrupcion;
    }

    public void setRenderImpresionDiagnosticaIVE(boolean renderImpresionDiagnosticaIVE) {
        this.renderImpresionDiagnosticaIVE = renderImpresionDiagnosticaIVE;
    }

    public boolean isRenderImpresionDiagnosticaIVE() {
        return renderImpresionDiagnosticaIVE;
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
    public String irEscalaValoracionCaidasInterrupcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_INTERRUPCION;
    }


    public void setRenderMetodos(boolean renderMetodos) {
        this.renderMetodos = renderMetodos;
    }

    public boolean isRenderMetodos() {
        return renderMetodos;
    }

    public void setRenderDispositivos(boolean renderDispositivos) {
        this.renderDispositivos = renderDispositivos;
    }

    public boolean isRenderDispositivos() {
        return renderDispositivos;
    }
    
     /**
      * @return
      */
     public String irMetodoPlanificacion() {
         inicializarUsuario();
         return BeanNavegacion.RUTA_IR_METODO_INTERRUPCION;
     }

     

     public String irAplicacionRetiro() {
         inicializarUsuario();
         return BeanNavegacion.RUTA_IR_APLICACION_RETITO_INTERRUPCION_ILVE;
     }
}

