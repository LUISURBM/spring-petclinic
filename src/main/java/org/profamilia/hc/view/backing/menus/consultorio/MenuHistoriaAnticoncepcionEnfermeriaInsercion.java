package org.profamilia.hc.view.backing.menus.consultorio;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.faces.application.ViewHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.commons.codec.binary.Base64;
import org.apache.myfaces.renderkit.html.util.AddResource;
import org.apache.myfaces.renderkit.html.util.AddResourceFactory;

import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosBean;
import org.profamilia.hc.view.backing.comun.AntecedentesGeneralesUsuarioBean;
import org.profamilia.hc.view.backing.comun.AntecedentesGinecologicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.AntecedentesTemporalesUsuario;
import org.profamilia.hc.view.backing.comun.AntecedentesUsuarioBean;
import org.profamilia.hc.view.backing.comun.AplicacionDispositivoBean;
import org.profamilia.hc.view.backing.comun.CerrarConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.EncuestaViolenciaUsuarioBean;
import org.profamilia.hc.view.backing.comun.ExamenFisicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.ImpresionDiagnosticaUsuarioBean;
import org.profamilia.hc.view.backing.comun.MetodosAnticoncepcionBean;
import org.profamilia.hc.view.backing.comun.MotivoBean;
import org.profamilia.hc.view.backing.comun.PausarConsultaBean;
import org.profamilia.hc.view.backing.comun.conducta.FormulaMedicaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.RecomedacionUsuarioBean;
import org.profamilia.hc.view.backing.comun.resumen.ResumenHistoriaEspecificaBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.backing.comun.conducta.VademecumMedicoBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.model.dto.Crripsserv;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;
import org.profamilia.hc.view.backing.comun.conducta.AnatomiaPatologicaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.AutorizacionServicioUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.CertAsistenciaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.CertMedicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ControlSinCostoUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ExamElectrofisiologicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ExamImagenUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ExamLaboratorioUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.HospitalizacionUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.IncapacidadUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.InterConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.OrdenCirugiaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ReferenciaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ReservaSangreUsuarioBean;


public class MenuHistoriaAnticoncepcionEnfermeriaInsercion extends BaseBean {

    private DatosBasicosUsuarioBean datosBasicosUsuario;

    private MotivoBean motivoConsulta;

    private AntecedentesUsuarioBean antecedentes;

    private AntecedentesGeneralesUsuarioBean antecedentesGenerales;

    private AntecedentesTemporalesUsuario antecedentesTemporales;

    private AntecedentesGinecologicosUsuarioBean antecedentesGinecologicos;

    private ExamenFisicoUsuarioBean examenFisicoUsuario;

    private EncuestaViolenciaUsuarioBean encuestaViolenciaUsuario;

    private ImpresionDiagnosticaUsuarioBean impresionDiagnosticaUsuarioBean;

    private MetodosAnticoncepcionBean metodos;

    private RecomedacionUsuarioBean recomedacionUsuarioBean;

    private FormulaMedicaUsuarioBean formulaMedicaUsuarioBean;
  
    //   private ExpandableTreeModel trnhistoria;

    private CerrarConsultaUsuarioBean cerrarConsultaUsuarioBean;

    private ResumenHistoriaEspecificaBean resumenEspecifico;

    private AplicacionDispositivoBean dispositivos;

    private Crripsserv rips;


    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private boolean renderMotivo;

    private boolean renderAntecedentesGenerales;

    private boolean renderAntecedentesGinecologicos;

    private boolean renderExamen;

    private boolean renderEncuestaViolencia;

    private boolean renderImpresionDiagnostica;

    private boolean renderConducta;

    private boolean renderCerrarConsulta;

    private boolean primeraConsulta;

    private boolean renderAntecedentesTemporales;

    private boolean renderMetodosPlanificacion;
    
    private boolean renderAplicacion; 

    private String sexo;

    private Long numeroConsulta;

    private String cie10Principal;

    private String cie10Relacionado1;

    private String codigoCups;

    private Chantegineco antecedenteObject;

    String tensionArterial = null;

    Integer frecuenciaCardiaca = null;

    Integer frecuenciaRespiratoria = null;

    BigDecimal peso = null;

    String hallazgos = null;

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
    
    private AnatomiaPatologicaUsuarioBean anatomiaPatologicaUsuarioBean;
    
    private ControlSinCostoUsuarioBean controlSinCostoUsuarioBean;

    private HospitalizacionUsuarioBean hospitalizacionUsuarioBean;

    private OrdenCirugiaUsuarioBean ordenCirugiaUsuarioBean;

    private InterConsultaUsuarioBean interConsultaUsuarioBean;

    private IncapacidadUsuarioBean incapacidadUsuarioBean;

    private ReferenciaUsuarioBean referenciaUsuarioBean;

    private ReservaSangreUsuarioBean reservaSangreUsuarioBean;

    private CertMedicoUsuarioBean certMedicoUsuarioBean;

    private CertAsistenciaUsuarioBean certAsistenciaUsuarioBean;

    private ExamElectrofisiologicoUsuarioBean examElectrofisiologicoUsuarioBean;

    private ExamImagenUsuarioBean examImagenUsuarioBean;

    private ExamLaboratorioUsuarioBean examLaboratorioUsuarioBean;
    
    private AutorizacionServicioUsuarioBean autorizacionServicioUsuarioBean;
    
    
    private boolean renderCovid;

    public void init() {
        primeraConsulta = false;
        
        Date fechaUltimoParto;
        fechaUltimoParto = null;

        Date fechaUltimaRegla;
        fechaUltimaRegla = null;
        
        boolean renderMasculino; 
        renderMasculino = false; 
        
       
        renderVademecum = true;
        renderPausarConsulta=false;
        renderServiciosAdmision =false;
              



        // DATOS BASICOS USUARIO
        datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_ENFERMERIA_INSERCION);
        datosBasicosUsuario.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
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
            datosBasicosUsuario.getUsuario() != null && 
            datosBasicosUsuario.getUsuario().getHusesexo() != null) {
            sexo = datosBasicosUsuario.getUsuario().getHusesexo();
            if (sexo != null && (sexo.equals(SEXO_MASCULINO) ||  sexo.equals(SEXO_TRANSEXUAL) || sexo.equals(SEXO_AMBIGUO) )) {
                            renderMasculino = true; 
                        }
        }

        if (datosBasicosUsuario.getConsulta() != null) {
            try {
                rips = 
this.serviceLocator.getClinicoService().getParametrosRipsXClinica(datosBasicosUsuario.getConsulta());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        //
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
        cuestionarioCovid.setNextAction(BeanNavegacion.RUTA_IR_MOTIVO_ANTICONCEPCION_ENFERMERIA_INSERCION);
        cuestionarioCovid.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
        cuestionarioCovid.inicializarCuestionario();
        renderMotivo= cuestionarioCovid.esValido();

        // MOTIVO DE CONSULTA
        motivoConsulta = (MotivoBean)FacesUtils.getManagedBean("motivoBean");
        motivoConsulta.setTipoServicio(TIPO_CONSULTA);
        motivoConsulta.setNumeroConsulta(numeroConsulta);
        motivoConsulta.setCausaSelect(CAUSA_OTRA);
        motivoConsulta.setFinalidadSelect(FINALIDAD_CONSULTA_PLANIFICACION);
        motivoConsulta.setModoconsulta(true);
        motivoConsulta.setEnfermedadOpcional(true);
        motivoConsulta.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_ANTICONCEPCION_ENFERMERIA_INSERCION);
        if (primeraConsulta) {
            motivoConsulta.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_GENERALES_ANTICONCEPCION_ENFERMERIA_INSERCION);
        }

        motivoConsulta.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
        motivoConsulta.inicializarMotivo();
        renderAntecedentesGenerales = motivoConsulta.esValido();


        // ANTECEDENTES

        antecedentesGenerales = 
                (AntecedentesGeneralesUsuarioBean)FacesUtils.getManagedBean("antecedentesGeneralesUsuarioBean");

        antecedentes = 
                (AntecedentesUsuarioBean)FacesUtils.getManagedBean("antecedentesUsuarioBean");


        if (primeraConsulta) {

            // ANTECEDENTES GENERALES

            antecedentesGenerales.setTipoServicio(TIPO_CONSULTA);
            antecedentesGenerales.setNumeroConsulta(numeroConsulta);
            antecedentesGenerales.setTipoHistoria(HISTORIA_ANTICONCEPCION_TEMPORAL);
            antecedentesGenerales.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_TEMPORALES_ANTICONCEPCION_ENFERMERIA_INSERCION);
            antecedentesGenerales.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
            antecedentesGenerales.inicializarAntecedentes();
            if (sexo != null && (sexo.equals(SEXO_MASCULINO) ||  sexo.equals(SEXO_TRANSEXUAL) || sexo.equals(SEXO_AMBIGUO) )) {
                antecedentesGenerales.setNextAction(BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_ANTICONCEPCION_ENFERMERIA_INSERCION);
                renderEncuestaViolencia = antecedentesGenerales.esValido();
            } else if (sexo != null && sexo.equals(SEXO_FEMENINO)) {
                renderAntecedentesTemporales = 
                        antecedentesGenerales.esValido();
            }


        } else {
            antecedentes.setTipoServicio(TIPO_CONSULTA);
            antecedentes.setNumeroConsulta(numeroConsulta);
            antecedentes.setTipoHistoria(HISTORIA_ANTICONCEPCION_TEMPORAL);
            antecedentes.setUsuario(datosBasicosUsuario.getUsuario());
            antecedentes.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_TEMPORALES_ANTICONCEPCION_ENFERMERIA_INSERCION);
            antecedentes.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
            antecedentes.inicializarAntecedentes();
            if (sexo != null && (sexo.equals(SEXO_MASCULINO) ||  sexo.equals(SEXO_TRANSEXUAL) || sexo.equals(SEXO_AMBIGUO) )) {
                antecedentes.setNextAction(BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_ANTICONCEPCION_ENFERMERIA_INSERCION);
                renderEncuestaViolencia = antecedentes.esValido(); 
            } else if (sexo != null && sexo.equals(SEXO_FEMENINO)) {
                renderAntecedentesTemporales = antecedentes.esValido();
            }

        }


        // ANTECEDENTES TEMPORALES

        antecedentesTemporales = 
                (AntecedentesTemporalesUsuario)FacesUtils.getManagedBean("antecedentesTemporalesUsuario");
        antecedentesTemporales.setTipoServicio(TIPO_CONSULTA);
        antecedentesTemporales.setNumeroConsulta(numeroConsulta);
        antecedentesTemporales.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_GINECOLOGICOS_ANTICONCEPCION_ENFERMERIA_INSERCION);
        antecedentesTemporales.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
        antecedentesTemporales.setUsuario(datosBasicosUsuario.getUsuario());
        antecedentesTemporales.inicializarAntecedentes();
        renderAntecedentesGinecologicos = antecedentesTemporales.esValido();
        
        if(antecedentesTemporales!= null && antecedentesTemporales.getCuestionario()!= null){
                        fechaUltimoParto =  antecedentesTemporales.getCuestionario().getHcpdfechaparto();
                        fechaUltimaRegla = antecedentesTemporales.getCuestionario().getHcpdfechultmes(); 
                    }
       


        // ANTECEDENTES GINECOLOGICOS
         if (sexo != null && sexo.equals(SEXO_FEMENINO)) {
        antecedentesGinecologicos = 
                (AntecedentesGinecologicosUsuarioBean)FacesUtils.getManagedBean("antecedentesGinecologicosUsuarioBean");
        antecedentesGinecologicos.setTipoServicio(TIPO_CONSULTA);
        antecedentesGinecologicos.setNumeroConsulta(numeroConsulta);
        antecedentesGinecologicos.setFup(fechaUltimoParto);
        antecedentesGinecologicos.setFur(fechaUltimaRegla);
        antecedentesGinecologicos.setUsuario(datosBasicosUsuario.getUsuario());
        antecedentesGinecologicos.setNextAction(BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_ANTICONCEPCION_ENFERMERIA_INSERCION);
        antecedentesGinecologicos.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
        antecedentesGinecologicos.inicializarAntecedentesGinecologicos();
        renderEncuestaViolencia = antecedentesGinecologicos.esValido();

        if (antecedentesGinecologicos != null) {
            antecedenteObject = antecedentesGinecologicos.getAntecedente();
        }
        }


        // ENCUESTA DE VIOLENCIA
        encuestaViolenciaUsuario = 
                (EncuestaViolenciaUsuarioBean)FacesUtils.getManagedBean("encuestaViolenciaUsuarioBean");
        encuestaViolenciaUsuario.setTipoServicio(TIPO_CONSULTA);
        encuestaViolenciaUsuario.setNumeroConsulta(numeroConsulta);
        encuestaViolenciaUsuario.setNextAction(BeanNavegacion.RUTA_IR_EXAMENFISICO_ANTICONCEPCION_ENFERMERIA_INSERCION);
        encuestaViolenciaUsuario.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
        encuestaViolenciaUsuario.inicializarEncuesta();
        renderExamen = encuestaViolenciaUsuario.esValido();


        // EXAMEN FISICO
        examenFisicoUsuario = 
                (ExamenFisicoUsuarioBean)FacesUtils.getManagedBean("examenFisicoUsuarioBean");
        examenFisicoUsuario.setTipoServicio(TIPO_CONSULTA);
        examenFisicoUsuario.setNumeroConsulta(numeroConsulta);
        examenFisicoUsuario.setNextAction(BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_ANTICONCEPCION_ENFERMERIA_INSERCION);
        examenFisicoUsuario.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
        examenFisicoUsuario.setUsuario(datosBasicosUsuario.getUsuario());
        examenFisicoUsuario.setConsecutivo(1);
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
        impresionDiagnosticaUsuarioBean.setConsecutivo(1);
        impresionDiagnosticaUsuarioBean.setNumeroConsulta(numeroConsulta);
        impresionDiagnosticaUsuarioBean.setCodigoDiagnostico("");
        impresionDiagnosticaUsuarioBean.setCodigoRelacionado1("");
        impresionDiagnosticaUsuarioBean.setCodigoRelacionado2("");
        impresionDiagnosticaUsuarioBean.setCodigoRelacionado3("");
        impresionDiagnosticaUsuarioBean.setDisableRel1(false);
        impresionDiagnosticaUsuarioBean.setRequiredRel2(false);
        impresionDiagnosticaUsuarioBean.setRenderColposcopia(false);
        impresionDiagnosticaUsuarioBean.setDesHabilitarDiagnosticoPrincipal(false);
        impresionDiagnosticaUsuarioBean.setCodigoRelacionado3("");
        impresionDiagnosticaUsuarioBean.setNextAction(BeanNavegacion.RUTA_IR_METODO_PLANIFICACION_ANTICONCEPCION_ENFERMERIA_INSERCION);
        impresionDiagnosticaUsuarioBean.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
        if (rips != null) {
            if (rips.getCrsntipdia() != null) {
                impresionDiagnosticaUsuarioBean.setTipoDiagnostico(rips.getCrsntipdia());
            }

            if (rips.getCrscdiagpr() != null) {
                impresionDiagnosticaUsuarioBean.setCodigoDiagnostico(rips.getCrscdiagpr());

            }
        }
        impresionDiagnosticaUsuarioBean.setDesHabilitarDiagnosticoPrincipal(false);
        impresionDiagnosticaUsuarioBean.inicializarImpresion();
        renderMetodosPlanificacion = 
                impresionDiagnosticaUsuarioBean.esValido();

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


        // METODOS DE PLANIFICACION


        metodos = 
                (MetodosAnticoncepcionBean)FacesUtils.getManagedBean("metodosAnticoncepcionBean");
        metodos.setUsuario(datosBasicosUsuario.getUsuario());
        metodos.setTipoServicio(TIPO_CONSULTA);
        metodos.setNumeroConsulta(numeroConsulta);
        metodos.setSexo(sexo);
        metodos.setNextAction(BeanNavegacion.RUTA_IR_APLICACION_RETITO_ANTICONCEPCION_ENFERMERIA_INSERCION);
        metodos.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
        metodos.inicializarMetodo();
        renderAplicacion = metodos.esValido();

        // APLICACION - RETIRO DISPOSITIVOS
        dispositivos = 
                (AplicacionDispositivoBean)FacesUtils.getManagedBean("aplicacionDispositivoBean");
        dispositivos.setUsuario(datosBasicosUsuario.getUsuario());
        dispositivos.setTipoServicio(TIPO_CONSULTA);
        dispositivos.setNumeroConsulta(numeroConsulta);
        dispositivos.setNextAction(BeanNavegacion.RUTA_IR_RECOMENDACIONES_ANTICONCEPCION_ENFERMERIA_INSERCION);
        dispositivos.setRenderMotivoRetiro(false);
        dispositivos.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
        dispositivos.inicializarAplicacionDispositivo();
        renderConducta = dispositivos.esValido();

        // CONDUCTA RECOMENDACIONES
        recomedacionUsuarioBean = 
                (RecomedacionUsuarioBean)FacesUtils.getManagedBean("recomedacionUsuarioBean");
        recomedacionUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        recomedacionUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        recomedacionUsuarioBean.setNumeroConsulta(numeroConsulta);
        recomedacionUsuarioBean.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
        recomedacionUsuarioBean.inicializarRecomedaciones();
        renderCerrarConsulta = recomedacionUsuarioBean.esValido();
        
        anatomiaPatologicaUsuarioBean = 
                (AnatomiaPatologicaUsuarioBean)FacesUtils.getManagedBean("anatomiaPatolUsuarioBean");
        anatomiaPatologicaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        anatomiaPatologicaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        anatomiaPatologicaUsuarioBean.setNumeroConsulta(numeroConsulta);
        anatomiaPatologicaUsuarioBean.setAntecedente(antecedenteObject);
        anatomiaPatologicaUsuarioBean.setConsecutivo(1);
        anatomiaPatologicaUsuarioBean.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
        anatomiaPatologicaUsuarioBean.inicializarAnatomiaPatol();
        
        // CONDUCTA - CONTROL SIN COSTO
        controlSinCostoUsuarioBean = 
                (ControlSinCostoUsuarioBean)FacesUtils.getManagedBean("controlSinCostoUsuarioBean");
        controlSinCostoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        controlSinCostoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        controlSinCostoUsuarioBean.setCodigoCups(codigoCups);
        controlSinCostoUsuarioBean.setNumeroConsulta(numeroConsulta);
        controlSinCostoUsuarioBean.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
        controlSinCostoUsuarioBean.inicializarControlSinCosto();

      

        // CONDUCTA - REMISION HOSPITALIZACION
        hospitalizacionUsuarioBean = 
                (HospitalizacionUsuarioBean)FacesUtils.getManagedBean("hospitalizacionUsuarioBean");
        hospitalizacionUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        hospitalizacionUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        hospitalizacionUsuarioBean.setNumeroConsulta(numeroConsulta);
        hospitalizacionUsuarioBean.setCiel0Principal(cie10Principal);
        hospitalizacionUsuarioBean.setConsecutivo(1);
        hospitalizacionUsuarioBean.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
        hospitalizacionUsuarioBean.inicializarHospitalizacion();

        // CONDUCTA - Cirug�as y procedimientos
        ordenCirugiaUsuarioBean = 
                (OrdenCirugiaUsuarioBean)FacesUtils.getManagedBean("ordenCirugiaUsuarioBean");
        ordenCirugiaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        ordenCirugiaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        ordenCirugiaUsuarioBean.setNumeroConsulta(numeroConsulta);
        ordenCirugiaUsuarioBean.setConsecutivo(1);
        ordenCirugiaUsuarioBean.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
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
        interConsultaUsuarioBean.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
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
        incapacidadUsuarioBean.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
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
        referenciaUsuarioBean.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
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
         autorizacionServicioUsuarioBean.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
         autorizacionServicioUsuarioBean.inicializarAutorizacionServicio();


        // CONDUCTA - SOLICITUD RESERVA DE SANGRE
        reservaSangreUsuarioBean = 
                (ReservaSangreUsuarioBean)FacesUtils.getManagedBean("reservaSangreUsuarioBean");
        reservaSangreUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        reservaSangreUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        reservaSangreUsuarioBean.setNumeroConsulta(numeroConsulta);
        reservaSangreUsuarioBean.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
        reservaSangreUsuarioBean.setConsecutivo(1);
        reservaSangreUsuarioBean.inicializarReservaSangre();

        // CONDUCTA - CERTIFICADOS / CERTIFICADO MEDICO
        certMedicoUsuarioBean = 
                (CertMedicoUsuarioBean)FacesUtils.getManagedBean("certMedicoUsuarioBean");
        certMedicoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        certMedicoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        certMedicoUsuarioBean.setNumeroConsulta(numeroConsulta);
        certMedicoUsuarioBean.setConsecutivo(1);
        certMedicoUsuarioBean.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
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
        certAsistenciaUsuarioBean.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
        certAsistenciaUsuarioBean.inicializarCertificadoAsistencia();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN ELECTROFISIOLOGICO
        examElectrofisiologicoUsuarioBean = 
                (ExamElectrofisiologicoUsuarioBean)FacesUtils.getManagedBean("examElectrofisioUsuarioBean");
        examElectrofisiologicoUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        examElectrofisiologicoUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        examElectrofisiologicoUsuarioBean.setNumeroConsulta(numeroConsulta);
        examElectrofisiologicoUsuarioBean.setCie10Principal(cie10Principal);
        examElectrofisiologicoUsuarioBean.setConsecutivo(1);
        examElectrofisiologicoUsuarioBean.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
        examElectrofisiologicoUsuarioBean.inicializarExamElectrofisiologico();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN IMAGEN
        examImagenUsuarioBean = 
                (ExamImagenUsuarioBean)FacesUtils.getManagedBean("examImagenUsuarioBean");
        examImagenUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        examImagenUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        examImagenUsuarioBean.setNumeroConsulta(numeroConsulta);
        examImagenUsuarioBean.setAntecedente(antecedenteObject);
        examImagenUsuarioBean.setConsecutivo(1);
        examImagenUsuarioBean.setCie10Principal(cie10Principal);
        examImagenUsuarioBean.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
        examImagenUsuarioBean.inicializarExamImagen();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN LABORATORIO
        examLaboratorioUsuarioBean = 
                (ExamLaboratorioUsuarioBean)FacesUtils.getManagedBean("examLaboratorioUsuarioBean");
        examLaboratorioUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        examLaboratorioUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        examLaboratorioUsuarioBean.setNumeroConsulta(numeroConsulta);
        examLaboratorioUsuarioBean.setCie10Principal(cie10Principal);
        examLaboratorioUsuarioBean.setConsecutivo(1);
        examLaboratorioUsuarioBean.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
        if (datosBasicosUsuario.getConsulta() != null) {
            Long tipoDocuentoAdmision = 
                datosBasicosUsuario.getConsulta().getCcontipdoc().getCtdnnumero().longValue();
            if (tipoDocuentoAdmision == IConstantes.TIPO_DOCUMENTO_ADMISION) {
                    examLaboratorioUsuarioBean.setNumeroAdmision(datosBasicosUsuario.getConsulta().getCconnumdoc().longValue());
            }
        }
        examLaboratorioUsuarioBean.inicializarExamLaboratorio();

        
        // CONDUCTA - FORMULA MEDICA
           formulaMedicaUsuarioBean = 
                   (FormulaMedicaUsuarioBean)FacesUtils.getManagedBean("formulaMedicaUsuarioBean");
           formulaMedicaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
           formulaMedicaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
           formulaMedicaUsuarioBean.setNumeroConsulta(numeroConsulta);
           formulaMedicaUsuarioBean.setCodigoCIE10(cie10Principal);
           formulaMedicaUsuarioBean.setConsecutivo(1);
           formulaMedicaUsuarioBean.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
           formulaMedicaUsuarioBean.inicializardFormulaMedica();
           
           

                // CONDUCTA - FORMULA MEDICA
                vademecumUsuarioBean = (VademecumMedicoBean)FacesUtils.getManagedBean("vademecumMedicoBean");
                vademecumUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
                vademecumUsuarioBean.setTipoServicio(TIPO_CONSULTA);
                vademecumUsuarioBean.setNumeroConsulta(numeroConsulta);
                vademecumUsuarioBean.setCodigoCIE10(cie10Principal);
                vademecumUsuarioBean.setConsecutivo(1);
                vademecumUsuarioBean.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
        vademecumUsuarioBean.setRenderAlertaIve(false);
                vademecumUsuarioBean.inicializardFormulaMedica();





        
        // CERRAR CONSULTA
        cerrarConsultaUsuarioBean = 
                (CerrarConsultaUsuarioBean)FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
        cerrarConsultaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        cerrarConsultaUsuarioBean.setMenuBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
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

    public String irPausarConsultaAnticoncepcionEnfermeriaInsercion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_PAUSAR_CONSULTA_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }

    /**
     * @return
     */
    public String irDatosAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_DATOS_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }

    /**
     * @return
     */
    public String irMotivoAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_MOTIVO_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }
    
    public String irCuestionarioCovidAnticoncepcionEnfermeriaInsercion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_ENFERMERIA_INSERCION;
        }



    /**
     * @return
     */
    public String irAntecedentesGeneralesAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_GENERALES_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }


    /**
     * @return
     */
    public String irAntecedentesAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }


    /**
     * @return
     */
    public String irAntecedentesTemporalesAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_TEMPORALES_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }

    /**
     * @return
     */
    public String irAntecedentesGinecologicosAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_GINECOLOGICOS_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }

    /**
     * @return
     */
    public String irExamenFisicoAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EXAMENFISICO_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }


    /**
     * @return
     */
    public String irEncuestaViolenciaAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }


    /**
     * @return
     */
    public String irImpDiagnosticaAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }

    /**
     * @return
     */
    public String irMetodoPlanificacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_METODO_PLANIFICACION_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }

    
    /**
     * @return
     */
    public String irAnatPatologicaAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANATOMIAPATOLOGICA_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }


    public String irAplicacionRetiro() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_APLICACION_RETITO_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }

    /**
     * @return
     */
    public String irControlSinCostoAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CONTOLSINCOSTO_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }


    /**
     * @return
     */
    public String irFormulaMedicaAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FORMULAMEDICA_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }
    

        /**
         * @return
         */
        public String irVademecumMedicoAnticoncepcion() {
            inicializarUsuario();
            return BeanNavegacion.RUTA_IR_VADEMCUM_ANTICONCEPCION_ENFERMERIA_INSERCION;
        }

    /**
     * @return
     */
    public String irRemHospitalizacionAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_HOSPITALZACION_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }


    /**
     * @return
     */
    public String irIncapacidadAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INCAPACIDAD_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }


    /**
     * @return
     */
    public String irInterConsultaAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INTERCONSULTA_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }


    /**
     * @return
     */
    public String irOrdenCirugiaAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ORDENCIRUGIA_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }


    /**
     * @return
     */
    public String irReferenciaAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_REFERENCIA_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }
    /**
     * 
     * @return
     */
    public String irAutorizacionServicioAnticoncepcion(){
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_REFERENCIA_AUTORIZACION_SERVICIO_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }

    /**
     * @return
     */
    public String irReservaSangreAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESERVA_SANGRE_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }


    /**
     * @return
     */
    public String irRecomedacionAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RECOMENDACIONES_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }


    /**
     * @return
     */
    public String irCertMedicoAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADOMEDICO_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }

    /**
     * @return
     */
    public String irCertAsistenciaAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADO_ASISTENCIA_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }

    /**
     * @return
     */
    public String irExamElectrofisiologicoAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ELECTROFISIOLOGICO_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }

    /**
     * @return
     */
    public String irExamImagenAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMAGENES_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }

    /**
     * @return
     */
    public String irExamLaboratorioAnticoncepcion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_LABORATORIO_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }


    /**
     * @return
     */
    public String irCerrarConsultaAnticoncepcion() {
        inicializarUsuario();
        if (cerrarConsultaUsuarioBean != null) {
            cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
        }
        return BeanNavegacion.RUTA_IR_CERRAR_CONSULTA_ANTICONCEPCION_ENFERMERIA_INSERCION;
    }


   

    /**
     * @return
     */
    public String irResumenHistoriaAnticoncepcion() {
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
        return BeanNavegacion.RUTA_IR_RESUMEN_ANTICONCEPCION_ENFERMERIA_INSERCION;
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
     * @param renderMetodosPlanificacion
     */
    public void setRenderMetodosPlanificacion(boolean renderMetodosPlanificacion) {
        this.renderMetodosPlanificacion = renderMetodosPlanificacion;
    }

    /**
     * @return
     */
    public boolean isRenderMetodosPlanificacion() {
        return renderMetodosPlanificacion;
    }

    /**
     * @param renderAplicacion
     */
    public void setRenderAplicacion(boolean renderAplicacion) {
        this.renderAplicacion = renderAplicacion;
    }

    /**
     * @return
     */
    public boolean isRenderAplicacion() {
        return renderAplicacion;
    }


    /**
     * @param trnhistoria
     */
    /*   public void setTrnhistoria(ExpandableTreeModel trnhistoria) {
        this.trnhistoria = trnhistoria;
    }
*/
    /**
     * @return
     */
    /* public ExpandableTreeModel getTrnhistoria() {
        TreeNode treeData = new TreeNodeBase("raiz", "Conducta", false);

        TreeNodeBase itemNode1 = new TreeNodeBase("itemNode1", "Anatomia Patologica", false);
        TreeNodeBase itemNode2 = new TreeNodeBase("itemNode2", "Control", false);
        TreeNodeBase itemNode3 = new TreeNodeBase("itemNode3", "Formula Medica", false);
        TreeNodeBase itemNode4 = new TreeNodeBase("itemNode4", "Remisi�n Hospitalizaci�n", false);
        TreeNodeBase itemNode5 = new TreeNodeBase("itemNode5", "Incapacidad", false);
        TreeNodeBase itemNode6 = new TreeNodeBase("itemNode6", "Inter Consulta", false);
        TreeNodeBase itemNode7 = new TreeNodeBase("itemNode7", "Cirug�as y procedimientos", false);
        TreeNodeBase itemNode8 = new TreeNodeBase("itemNode8", "Recomendaciones", false);
        TreeNodeBase itemNode9 = new TreeNodeBase("itemNode9", "Referencia", false);
        TreeNodeBase itemNode10 = new TreeNodeBase("itemNode10", "Reserva de Sangre", false);

        TreeNodeBase itemNode11 = new TreeNodeBase("raiz", "Certificados", false);
        itemNode11.getChildren().add(new TreeNodeBase("itemNode11_1", "Medico", true));
        itemNode11.getChildren().add(new TreeNodeBase("itemNode11_2", "De Asistencia", true));

        TreeNodeBase itemNode12 = new TreeNodeBase("raiz", "Ex�menes Clinicos", false);
        itemNode12.getChildren().add(new TreeNodeBase("itemNode12_1", "ElectroFisiologicos", true));
        itemNode12.getChildren().add(new TreeNodeBase("itemNode12_2", "Imagen", true));
        itemNode12.getChildren().add(new TreeNodeBase("itemNode12_3", "Laboratorio", true));


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

        ExpandableTreeModel treeDataExtended = new ExpandableTreeModel(treeData);

        treeDataExtended.setExpanded(treeData,true);
        treeDataExtended.setExpanded(itemNode11,true);
        treeDataExtended.setExpanded(itemNode12,true);

        return treeDataExtended;
        }*/

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
	
	public String irServiciosAdmisionAnticoncepcionEnfermeriaInsercion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_SERVICIOS_ADMISION_ANTICONCEPCION_ENFERMERIA_INSERCION;
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
  
}
