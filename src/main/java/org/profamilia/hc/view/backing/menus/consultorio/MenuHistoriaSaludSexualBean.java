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
import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.confirmarInsumoDTO;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.registro.OtrasOrdenesBean;
import org.profamilia.hc.view.backing.cirugia.registro.OtrasOrdenesCEBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarEscalaValoracionCaidasBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaHospitalizacionBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaLiquidosBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosBean;
import org.profamilia.hc.view.backing.comun.AntecedentesGeneralesUsuarioBean;
import org.profamilia.hc.view.backing.comun.AntecedentesGinecologicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.AntecedentesUsuarioBean;
import org.profamilia.hc.view.backing.comun.CerrarConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.ConfirmarInsumosBean;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioCirugiaBean;
import org.profamilia.hc.view.backing.comun.EncuestaViolenciaSivigilaBean;
import org.profamilia.hc.view.backing.comun.EncuestaViolenciaUsuarioBean;
import org.profamilia.hc.view.backing.comun.ExamenFisicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.ImpresionDiagnosticaUsuarioBean;
import org.profamilia.hc.view.backing.comun.MotivoBean;
import org.profamilia.hc.view.backing.comun.ParaclinicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.PausarConsultaBean;
import org.profamilia.hc.view.backing.comun.RegistrarEscalaValoracionCaidasCEBean;
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


public class MenuHistoriaSaludSexualBean extends BaseBean {

    private DatosBasicosUsuarioBean datosBasicosUsuario;

    private MotivoBean motivoConsulta;
    
    private CuestionarioCovidBean cuestionarioCovid;

    private AntecedentesUsuarioBean antecedentes;

    private AntecedentesGeneralesUsuarioBean antecedentesGenerales;
    
    private ParaclinicosUsuarioBean paraclinicos;

    private AntecedentesGinecologicosUsuarioBean antecedentesGinecologicos;

    private ExamenFisicoUsuarioBean examenFisicoUsuario;

    private EncuestaViolenciaUsuarioBean encuestaViolenciaUsuario;
    
    private EncuestaViolenciaSivigilaBean encuestaViolenciaSivigila;

    private ImpresionDiagnosticaUsuarioBean impresionDiagnosticaUsuarioBean;

    private AnatomiaPatologicaUsuarioBean anatomiaPatologicaUsuarioBean;

    private ControlSinCostoUsuarioBean controlSinCostoUsuarioBean;

    private FormulaMedicaUsuarioBean formulaMedicaUsuarioBean;
    
    private VademecumMedicoBean vademecumUsuarioBean;

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
    
    private boolean renderCovid;

    private boolean renderAntecedentesGenerales;

    private boolean renderAntecedentesGinecologicos;

    private boolean renderExamen;

    private boolean renderEncuestaViolencia;

    private boolean renderImpresionDiagnostica;
    
    private boolean renderParaclinicos;

    private boolean renderConducta;
    
    private boolean renderVademecum;

    private boolean renderCerrarConsulta;

    private boolean primeraConsulta;
    
    private boolean renderPausarConsulta;

    private String sexo;

    private Long numeroConsulta;

    private String cie10Principal;

    private String cie10Relacionado1;

    private String codigoCups;

    private Chantegineco antecedenteObject;
    
    private FormulaLiquidosBean formulaLiquidosBean;
    
    private OtrasOrdenesCEBean otrasOrdenesCEBean;

    private FormulaHospitalizacionBean formulaHospitalizacionBean;  
    
    private boolean renderOrdenesMedicas;
    
    private ConfirmarInsumosBean confirmarInsumos;
    
    private PausarConsultaBean pausarConsulta;
    
    private ConfirmarServiciosAdmisionBean confirmarServiciosAdmision;
    
    private boolean tiempoAtencion;
    
    private boolean renderServiciosAdmision;
    
    private OtrasOrdenesBean otrasOrdenesBean;
    
    private RegistrarEscalaValoracionCaidasCEBean registrarEscalaValoracionCaidasBean;
    
    private boolean renderEscalaCaidas;


    public void init() {
        primeraConsulta = false;
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
        renderPausarConsulta=false;
        
        renderEscalaCaidas= false;
      


        // DATOS BASICOS USUARIO
        datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_SALUD_SEXUAL);
        
        
        
        datosBasicosUsuario.setMenuBean("menuHistoriaSaludSexualBean");
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
             sexo = datosBasicosUsuario.getUsuario().getHusesexo();
         }
        
        if (datosBasicosUsuario != null && 
                  datosBasicosUsuario.getUsuario() != null && 
                  datosBasicosUsuario.getUsuario().getHusesexo() != null) {
                 
                  if (datosBasicosUsuario.getUsuario().getHusesexo() != null && datosBasicosUsuario.getUsuario().getHusesexo().equals(SEXO_MASCULINO)) {
                      renderMasculino = true; 
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
        cuestionarioCovid.setNextAction(BeanNavegacion.RUTA_IR_MOTIVO_SALUD_SEXUAL);
        cuestionarioCovid.setMenuBean("menuHistoriaSaludSexualBean");
        cuestionarioCovid.inicializarCuestionario();
        renderMotivo= cuestionarioCovid.esValido();


        // MOTIVO DE CONSULTA
        motivoConsulta = (MotivoBean)FacesUtils.getManagedBean("motivoBean");
        motivoConsulta.setTipoServicio(TIPO_CONSULTA);
        motivoConsulta.setNumeroConsulta(numeroConsulta);
        motivoConsulta.setOcultarasesoria(true);
        motivoConsulta.setNextAction(BeanNavegacion.RUTA_IR_PARACLINICOS_SALUD_SEXUAL);
        motivoConsulta.setMenuBean("menuHistoriaSaludSexualBean");
        motivoConsulta.inicializarMotivo();
        renderParaclinicos= motivoConsulta.esValido();
        
    
        
        // CONFIRMAR INSUMO
       /* if (datosBasicosUsuario != null && 
            datosBasicosUsuario.getConsulta() != null && 
            datosBasicosUsuario.getConsulta().getCconnumero() != null) {
            confirmarInsumos = 
                    (ConfirmarInsumosBean)FacesUtils.getManagedBean("confirmarInsumosBean");
                 if (datosBasicosUsuario.getConsulta().getCcocservic() != null) {
                     confirmarInsumos.setCodigoServicio(datosBasicosUsuario.getConsulta().getCcocservic().getCsvccodigo());
                     confirmarInsumos.setNumeroConsulta(numeroConsulta);
                     confirmarInsumos.consultarInsumos();
                 }
            
             }*/
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
        //PARACLINICOS
        
            paraclinicos = 
                    (ParaclinicosUsuarioBean)FacesUtils.getManagedBean("paraclinicosUsuarioBean");
            paraclinicos.setTipoServicio(TIPO_CONSULTA);
            
            paraclinicos.setNumeroConsulta(numeroConsulta);
            paraclinicos.setUsuario(datosBasicosUsuario.getUsuario());
            
            paraclinicos.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_SALUD_SEXUAL);
             if (primeraConsulta) {
              paraclinicos.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_GENERALES_SALUD_SEXUAL);
              }
            paraclinicos.setMenuBean("menuHistoriaSaludSexualBean");
            renderAntecedentesGenerales = paraclinicos.esValido();
            paraclinicos.inicializarParaclinicos();
        

        // ANTECEDENTES

        if (!primeraConsulta) {
            antecedentes = 
                    (AntecedentesUsuarioBean)FacesUtils.getManagedBean("antecedentesUsuarioBean");
            antecedentes.setTipoServicio(TIPO_CONSULTA);
            antecedentes.setNumeroConsulta(numeroConsulta);
            antecedentes.setTipoHistoria(HISTORIA_SALUD_SEXUAL);
            antecedentes.setUsuario(datosBasicosUsuario.getUsuario());
            antecedentes.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_GINECOLOGICOS_SALUD_SEXUAL);
            antecedentes.setMenuBean("menuHistoriaSaludSexualBean");
            if (sexo != null && sexo.equals(SEXO_MASCULINO)) {
                antecedentes.setNextAction(BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_SALUD_SEXUAL);
                renderEncuestaViolencia = antecedentes.esValido();
            } else if (sexo != null && sexo.equals(SEXO_FEMENINO)) {
                renderAntecedentesGinecologicos = antecedentes.esValido();
            }
            antecedentes.inicializarAntecedentes();
        }

        if (primeraConsulta) {
            // ANTECEDENTES GENERALES
            antecedentesGenerales = 
                    (AntecedentesGeneralesUsuarioBean)FacesUtils.getManagedBean("antecedentesGeneralesUsuarioBean");
            antecedentesGenerales.setTipoServicio(TIPO_CONSULTA);
            antecedentesGenerales.setTipoHistoria(HISTORIA_SALUD_SEXUAL);
            antecedentesGenerales.setNumeroConsulta(numeroConsulta);
            antecedentesGenerales.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_GINECOLOGICOS_SALUD_SEXUAL);
            antecedentesGenerales.setMenuBean("menuHistoriaSaludSexualBean");
            if (sexo != null && sexo.equals(SEXO_MASCULINO)) {
                antecedentesGenerales.setNextAction(BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_SALUD_SEXUAL);
                renderEncuestaViolencia = antecedentesGenerales.esValido();
            } else if (sexo != null && sexo.equals(SEXO_FEMENINO)) {
                renderAntecedentesGinecologicos = 
                        antecedentesGenerales.esValido();
            }
            antecedentesGenerales.inicializarAntecedentes();

        }
        
        
     
         
     
        

        // ANTECEDENTES GINECOLOGICOS

        antecedentesGinecologicos = 
                (AntecedentesGinecologicosUsuarioBean)FacesUtils.getManagedBean("antecedentesGinecologicosUsuarioBean");
        antecedentesGinecologicos.setTipoServicio(TIPO_CONSULTA);
        antecedentesGinecologicos.setNumeroConsulta(numeroConsulta);
        antecedentesGinecologicos.setUsuario(datosBasicosUsuario.getUsuario());
        antecedentesGinecologicos.setNextAction(BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_SALUD_SEXUAL);
        antecedentesGinecologicos.setMenuBean("menuHistoriaSaludSexualBean");
        antecedentesGinecologicos.inicializarAntecedentesGinecologicos();
        if (sexo != null && sexo.equals(SEXO_FEMENINO)) {
        renderEncuestaViolencia = antecedentesGinecologicos.esValido();
        }
        if (antecedentesGinecologicos != null) {
            antecedenteObject = antecedentesGinecologicos.getAntecedente();
        }


        // ENCUESTA DE VIOLENCIA
        encuestaViolenciaUsuario = 
                (EncuestaViolenciaUsuarioBean)FacesUtils.getManagedBean("encuestaViolenciaUsuarioBean");
        encuestaViolenciaUsuario.setTipoServicio(TIPO_CONSULTA);
        encuestaViolenciaUsuario.setNumeroConsulta(numeroConsulta);
        encuestaViolenciaUsuario.setNextAction(BeanNavegacion.RUTA_IR_REGISTRO_ESCALA_VALORACION_CAIDAS_SALUD_SEXUAL);
        encuestaViolenciaUsuario.setMenuBean("menuHistoriaSaludSexualBean");
        encuestaViolenciaUsuario.inicializarEncuesta();
        renderEscalaCaidas = encuestaViolenciaUsuario.esValido(); 

        // ENCUESTA DE VIOLENCIA SIVIGILA
        
         encuestaViolenciaSivigila = 
                 (EncuestaViolenciaSivigilaBean)FacesUtils.getManagedBean("encuestaViolenciaSivigilaBean");
         encuestaViolenciaSivigila.setTipoServicio(TIPO_CONSULTA);
         encuestaViolenciaSivigila.setNumeroConsulta(numeroConsulta);
         encuestaViolenciaSivigila.setMenuBean("menuHistoriaSaludSexualBean");
         if(datosBasicosUsuario != null && datosBasicosUsuario.getUsuario() != null &&datosBasicosUsuario.getUsuario().getHuslnumero()!= null )
         encuestaViolenciaSivigila.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero() );
         encuestaViolenciaSivigila.inicializarEncuesta();
        
         registrarEscalaValoracionCaidasBean = 
            (RegistrarEscalaValoracionCaidasCEBean)FacesUtils.getManagedBean("registrarEscalaValoracionCaidasCEBean");
            registrarEscalaValoracionCaidasBean.setNumeroConsulta(numeroConsulta);
        if (datosBasicosUsuario != null && 
            datosBasicosUsuario.getUsuario() != null && 
            datosBasicosUsuario.getUsuario().getHuslnumero() != null) {
                registrarEscalaValoracionCaidasBean.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
            }
            registrarEscalaValoracionCaidasBean.setMenuBean("menuHistoriaSaludSexualBean");
            registrarEscalaValoracionCaidasBean.setNextAction(BeanNavegacion.RUTA_IR_EXAMENFISICO_SALUD_SEXUAL);
            registrarEscalaValoracionCaidasBean.init();
            
            renderExamen = registrarEscalaValoracionCaidasBean.esValido();

        // EXAMEN FISICO
        examenFisicoUsuario = 
                (ExamenFisicoUsuarioBean)FacesUtils.getManagedBean("examenFisicoUsuarioBean");
        examenFisicoUsuario.setTipoServicio(TIPO_CONSULTA);
        examenFisicoUsuario.setTipoHistoria(IConstantes.HISTORIA_SALUD_SEXUAL);
        examenFisicoUsuario.setNumeroConsulta(numeroConsulta);
        examenFisicoUsuario.setNextAction(BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_SALUD_SEXUAL);
        examenFisicoUsuario.setMenuBean("menuHistoriaSaludSexualBean");
        examenFisicoUsuario.setConsecutivo(1);
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
        impresionDiagnosticaUsuarioBean.setRenderColposcopia(false);
        impresionDiagnosticaUsuarioBean.setDesHabilitarDiagnosticoPrincipal(false);
        impresionDiagnosticaUsuarioBean.setCodigoRelacionado3("");
        impresionDiagnosticaUsuarioBean.setNextAction(BeanNavegacion.RUTA_IR_RECOMENDACIONES_SALUD_SEXUAL);
        impresionDiagnosticaUsuarioBean.setMenuBean("menuHistoriaSaludSexualBean");
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
        recomedacionUsuarioBean.setMenuBean("menuHistoriaSaludSexualBean");
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
        anatomiaPatologicaUsuarioBean.setMenuBean("menuHistoriaSaludSexualBean");
        anatomiaPatologicaUsuarioBean.inicializarAnatomiaPatol();


        // CONDUCTA - CONTROL SIN COSTO
        controlSinCostoUsuarioBean = 
                (ControlSinCostoUsuarioBean)FacesUtils.getManagedBean("controlSinCostoUsuarioBean");
        controlSinCostoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        controlSinCostoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        controlSinCostoUsuarioBean.setCodigoCups(codigoCups);
        controlSinCostoUsuarioBean.setNumeroConsulta(numeroConsulta);
        controlSinCostoUsuarioBean.setMenuBean("menuHistoriaSaludSexualBean");
        controlSinCostoUsuarioBean.inicializarControlSinCosto();

        // CONDUCTA - FORMULA MEDICA
        formulaMedicaUsuarioBean = 
                (FormulaMedicaUsuarioBean)FacesUtils.getManagedBean("formulaMedicaUsuarioBean");
        formulaMedicaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        formulaMedicaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        formulaMedicaUsuarioBean.setNumeroConsulta(numeroConsulta);
        formulaMedicaUsuarioBean.setCodigoCIE10(cie10Principal);
        formulaMedicaUsuarioBean.setConsecutivo(1);
        formulaMedicaUsuarioBean.setMenuBean("menuHistoriaSaludSexualBean");
        formulaMedicaUsuarioBean.inicializardFormulaMedica();
        
        // CONDUCTA - FORMULA MEDICA
        vademecumUsuarioBean = (VademecumMedicoBean)FacesUtils.getManagedBean("vademecumMedicoBean");
        vademecumUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        vademecumUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        vademecumUsuarioBean.setNumeroConsulta(numeroConsulta);
        vademecumUsuarioBean.setCodigoCIE10(cie10Principal);
        vademecumUsuarioBean.setConsecutivo(1);
        vademecumUsuarioBean.setMenuBean("menuHistoriaSaludSexualBean");
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
        hospitalizacionUsuarioBean.setMenuBean("menuHistoriaSaludSexualBean");
        hospitalizacionUsuarioBean.inicializarHospitalizacion();

        // CONDUCTA - Cirug�as y procedimientos
        ordenCirugiaUsuarioBean = 
                (OrdenCirugiaUsuarioBean)FacesUtils.getManagedBean("ordenCirugiaUsuarioBean");
        ordenCirugiaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        ordenCirugiaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        ordenCirugiaUsuarioBean.setNumeroConsulta(numeroConsulta);
        ordenCirugiaUsuarioBean.setMenuBean("menuHistoriaSaludSexualBean");
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
        interConsultaUsuarioBean.setMenuBean("menuHistoriaSaludSexualBean");
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
        incapacidadUsuarioBean.setMenuBean("menuHistoriaSaludSexualBean");
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
        referenciaUsuarioBean.setMenuBean("menuHistoriaSaludSexualBean");
        referenciaUsuarioBean.inicializarReferencia();
        
        
        // CONDUCTA - AUTORIZACION DE SERVICIOS
        
         autorizacionServicioUsuarioBean =
                 (AutorizacionServicioUsuarioBean)FacesUtils.getManagedBean("autorizacionServicioUsuarioBean");
         autorizacionServicioUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
         
         autorizacionServicioUsuarioBean.setTipoServicio("C");
         autorizacionServicioUsuarioBean.setNumeroConsulta(numeroConsulta);
        // autorizacionServicioUsuarioBean.setTipoHistoria(motivoConsulta.getTipoHistoria());
         autorizacionServicioUsuarioBean.setOrigenAtencion(motivoConsulta.getCausaSelect());  
         autorizacionServicioUsuarioBean.setCodigoCups(codigoCups);
        autorizacionServicioUsuarioBean.setTipoDiagnostico(impresionDiagnosticaUsuarioBean.getImpresion().getHidntipodiagn());
        autorizacionServicioUsuarioBean.setCodigoDiagnostico(impresionDiagnosticaUsuarioBean.getImpresion().getHidcdiagprin());
        autorizacionServicioUsuarioBean.setCodigoDiagnostico1(impresionDiagnosticaUsuarioBean.getImpresion().getHidcdiagrela2());
        autorizacionServicioUsuarioBean.setCodigoDiagnostico2(impresionDiagnosticaUsuarioBean.getImpresion().getHidcdiagrela3());
         autorizacionServicioUsuarioBean.setMenuBean("menuHistoriaSaludSexualBean");
         autorizacionServicioUsuarioBean.inicializarAutorizacionServicio();


        // CONDUCTA - SOLICITUD RESERVA DE SANGRE
        reservaSangreUsuarioBean = 
                (ReservaSangreUsuarioBean)FacesUtils.getManagedBean("reservaSangreUsuarioBean");
        reservaSangreUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        reservaSangreUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        reservaSangreUsuarioBean.setNumeroConsulta(numeroConsulta);
        reservaSangreUsuarioBean.setConsecutivo(1);
        reservaSangreUsuarioBean.setMenuBean("menuHistoriaSaludSexualBean");
        reservaSangreUsuarioBean.inicializarReservaSangre();

        // CONDUCTA - CERTIFICADOS / CERTIFICADO MEDICO
        certMedicoUsuarioBean = 
                (CertMedicoUsuarioBean)FacesUtils.getManagedBean("certMedicoUsuarioBean");
        certMedicoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        certMedicoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        certMedicoUsuarioBean.setNumeroConsulta(numeroConsulta);
        certMedicoUsuarioBean.setMenuBean("menuHistoriaSaludSexualBean");
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
        certAsistenciaUsuarioBean.setMenuBean("menuHistoriaSaludSexualBean");
        certAsistenciaUsuarioBean.inicializarCertificadoAsistencia();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN ELECTROFISIOLOGICO
        examElectrofisiologicoUsuarioBean = 
                (ExamElectrofisiologicoUsuarioBean)FacesUtils.getManagedBean("examElectrofisioUsuarioBean");
        examElectrofisiologicoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        examElectrofisiologicoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        examElectrofisiologicoUsuarioBean.setNumeroConsulta(numeroConsulta);
        examElectrofisiologicoUsuarioBean.setCie10Principal(cie10Principal);
        examElectrofisiologicoUsuarioBean.setConsecutivo(1);
        examElectrofisiologicoUsuarioBean.setMenuBean("menuHistoriaSaludSexualBean");
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
        examImagenUsuarioBean.setMenuBean("menuHistoriaSaludSexualBean");
        examImagenUsuarioBean.inicializarExamImagen();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN LABORATORIO
        examLaboratorioUsuarioBean = 
                (ExamLaboratorioUsuarioBean)FacesUtils.getManagedBean("examLaboratorioUsuarioBean");
        examLaboratorioUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        examLaboratorioUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        examLaboratorioUsuarioBean.setNumeroConsulta(numeroConsulta);
        examLaboratorioUsuarioBean.setCie10Principal(cie10Principal);
        examLaboratorioUsuarioBean.setConsecutivo(1);
        examLaboratorioUsuarioBean.setMenuBean("menuHistoriaSaludSexualBean");
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
        cerrarConsultaUsuarioBean.setMenuBean("menuHistoriaSaludSexualBean");
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


        otrasOrdenesCEBean = 
                (OtrasOrdenesCEBean)FacesUtils.getManagedBean("otrasOrdenesCEBean");

        //OtrasOrdenesCEBean.setCirugia(evolucionMedico.getCirugia());
        otrasOrdenesCEBean.setConsecutivo(1);
        otrasOrdenesCEBean.setNumeroConsulta(numeroConsulta);
        otrasOrdenesCEBean.setTipoServicio(TIPO_HOSPITALIZACION);
        otrasOrdenesCEBean.init();
        
        otrasOrdenesBean = 
                (OtrasOrdenesBean)FacesUtils.getManagedBean("otrasOrdenesBean");

        //otrasOrdenesBean.setCirugia(evolucionMedico.getCirugia());
        otrasOrdenesBean.setConsecutivo(1);
        otrasOrdenesBean.setNumeroConsulta(numeroConsulta);
        otrasOrdenesBean.setTipoServicio(TIPO_HOSPITALIZACION);
        otrasOrdenesBean.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
        otrasOrdenesBean.init();
                
        
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


    /**
     * @return
     */
    public String irDatosSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_DATOS_SALUD_SEXUAL;
    }

    /**
     * @return
     */
    public String irMotivoSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_MOTIVO_SALUD_SEXUAL;
    }




    public String irViolenciaSivigilaSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_SIVIGILA_SALUD_SEXUAL;
    }
    /**
     * @return
     */
    public String irAntecedentesGeneralesSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_GENERALES_SALUD_SEXUAL;
    }


    /**
     * @return
     */
    public String irAntecedentesSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_SALUD_SEXUAL;
    }
    
    public String irCuestionarioCovidSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_SALUD_SEXUAL;
        }


    /**
     * @return
     */
    public String irAntecedentesGinecologicosSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_GINECOLOGICOS_SALUD_SEXUAL;
    }


/**
 *@return 
 */
 
public String irParaclinicosSaludSexual(){
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_PARACLINICOS_SALUD_SEXUAL;
}
 
 
 
    /**
     * @return
     */
    public String irExamenFisicoSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EXAMENFISICO_SALUD_SEXUAL;
    }


    /**
     * @return
     */
    public String irEncuestaViolenciaSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_SALUD_SEXUAL;
    }


    /**
     * @return
     */
    public String irImpDiagnosticaSaludSexual() {

        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_SALUD_SEXUAL;
    }

    /**
     * @return
     */
    public String irAnatPatologicaSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANATOMIAPATOLOGICA_SALUD_SEXUAL;
    }

    /**
     * @return
     */
    public String irControlSinCostoSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CONTOLSINCOSTO_SALUD_SEXUAL;
    }


    /**
     * @return
     */
    public String irFormulaMedicaSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FORMULAMEDICA_SALUD_SEXUAL;
    }
    
    /**
     * @return
     */
    public String irVademecumMedicoSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_VADEMCUM_SALUD_SEXUAL;
    }

    /**
     * @return
     */
    public String irRemHospitalizacionSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_HOSPITALZACION_SALUD_SEXUAL;
    }


    /**
     * @return
     */
    public String irIncapacidadSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INCAPACIDAD_SALUD_SEXUAL;
    }
    
    public String irConfirmarInsumosSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CONFIRMAR_INSUMOS_SALUD_SEXUAL;
    }
    
    public String irPausarConsultaSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_PAUSAR_CONSULTA_SALUD_SEXUAL;
    }


    /**
     * @return
     */
    public String irInterConsultaSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INTERCONSULTA_SALUD_SEXUAL;
    }


    /**
     * @return
     */
    public String irOrdenCirugiaSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ORDENCIRUGIA_SALUD_SEXUAL;
    }


    /**
     * @return
     */
    public String irReferenciaSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_REFERENCIA_SALUD_SEXUAL;
    }
    
    
    /**
     * @return
     */
     public String irAutorizacionServicioSaludSexual(){
         inicializarUsuario();
         return BeanNavegacion.RUTA_IR_AUTORIZACION_SERVICIOS_SALUD_SEXUAL;
     }


    /**
     * @return
     */
    public String irReservaSangreSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESERVA_SANGRE_SALUD_SEXUAL;
    }


    /**
     * @return
     */
    public String irRecomedacionSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RECOMENDACIONES_SALUD_SEXUAL;
    }


    /**
     * @return
     */
    public String irCertMedicoSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADOMEDICO_SALUD_SEXUAL;
    }

    /**
     * @return
     */
    public String irCertAsistenciaSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADO_ASISTENCIA_SALUD_SEXUAL;
    }

    /**
     * @return
     */
    public String irExamElectrofisiologicoSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ELECTROFISIOLOGICO_SALUD_SEXUAL;
    }

    /**
     * @return
     */
    public String irExamImagenSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMAGENES_SALUD_SEXUAL;
    }

    /**
     * @return
     */
    public String irExamLaboratorioSaludSexual() {
        inicializarUsuario();

        return BeanNavegacion.RUTA_IR_LABORATORIO_SALUD_SEXUAL;
    }


    /**
     * @return
     */
    public String irCerrarConsultaSaludSexual() {
        if (cerrarConsultaUsuarioBean != null) {
            cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
        }
        return BeanNavegacion.RUTA_IR_CERRAR_CONSULTA_SALUD_SEXUAL;
    }
    
    
    /**
     * @return
     */
    public String irOrdenMedicamentosSaludSexual() {
        return BeanNavegacion.RUTA_IR_ORDEN_MEDICAMENTOS_SALUD_SEXUAL; 
    }

    /**
     * @return
     */
    public String irOrdenLiquidosSaludSexual() {
        
        return BeanNavegacion.RUTA_IR_ORDEN_LIQUIDOS_SALUD_SEXUAL;
    }
    
    public String irRegistrarOtrasOrdenesSaludSexual() {
        return BeanNavegacion.RUTA_IR_OTRAS_ORDENES_SALUD_SEXUAL;
    }


    /**
     * @return
     */
    public String irResumenHistoriaEspecificaSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_SALUD_SEXUAL;
    }

    /**
     * @return
     */
    public String irResumenHistoriaSaludSexual() {

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
      
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_SALUD_SEXUAL;
    }

    public void inicializarUsuario() {
        if (datosBasicosUsuario.getUsuario() != null)
            this.setUsuario(datosBasicosUsuario.getUsuario());
    }
    
    
    /**
     * @return
     */
    public String irEscalaValoracionCaidasSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_REGISTRO_ESCALA_VALORACION_CAIDAS_SALUD_SEXUAL;
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


    public void setRenderParaclinicos(boolean renderParaclinicos) {
        this.renderParaclinicos = renderParaclinicos;
    }

    public boolean isRenderParaclinicos() {
        return renderParaclinicos;
    }
    

        /**
         * @param vademecumUsuarioBean
         */
        public void setVademecumUsuarioBean(VademecumMedicoBean vademecumUsuarioBean) {
            this.vademecumUsuarioBean = vademecumUsuarioBean;
        }

        /**
         * @return
         */
        public VademecumMedicoBean getVademecumUsuarioBean() {
            return vademecumUsuarioBean;
        }

        public void setRenderVademecum(boolean renderVademecum) {
            this.renderVademecum = renderVademecum;
        }

        public boolean isRenderVademecum() {
            return renderVademecum;
        }
    
    public void openPopupClicked(ActionEvent event) {
        javaScriptText = "";
        Long numeroUsuario = null;
        String encodedText = "";
        String cod = "";
        
        numeroUsuario = datosBasicosUsuario.getUsuario().getHusanumeiden();
        
        if(numeroUsuario != null){
            cod = "[N_MERO_ID_]= " + numeroUsuario.toString(); 
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
            
                                    // http://wgesdoc/DocuWare/Platform/WebClient/1/Integration?p=V&fc=0ee1c783-c5e9-4232-b6cc-b651dd62bd02&q=W05fTUVST19JRF9dID0gNTIzNDU2Nzg1
                                    //http://wgesdoc/DocuWare/Platform/WebClient/1/Integration?p=RLV&fc=0ee1c783-c5e9-4232-b6cc-b651dd62bd02&q=W05fTUVST19JRF9dID0gNTIzNDU2Nzg1
        javaScriptText = "window.open('http://wgesdoc/DocuWare/Platform/WebClient/1/Integration?p=RLV&fc=0ee1c783-c5e9-4232-b6cc-b651dd62bd02&q=" + encodedText + "' );";
        
        // Add the Javascript to the rendered page's header for immediate execution
        AddResource addResource = AddResourceFactory.getInstance(facesContext);
        
        addResource.addInlineScriptAtPosition(null, AddResource.HEADER_BEGIN, javaScriptText); 
     
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
    
    public String irServiciosAdmisionSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_SERVICIOS_ADMISION_SALUD_SEXUAL;
    }

    public void setRenderServiciosAdmision(boolean renderServiciosAdmision) {
        this.renderServiciosAdmision = renderServiciosAdmision;
    }

    public boolean isRenderServiciosAdmision() {
        return renderServiciosAdmision;
    }

    public void setOtrasOrdenesBean(OtrasOrdenesBean otrasOrdenesBean) {
        this.otrasOrdenesBean = otrasOrdenesBean;
    }

    public OtrasOrdenesBean getOtrasOrdenesBean() {
        return otrasOrdenesBean;
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
}
