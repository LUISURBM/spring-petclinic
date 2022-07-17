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

import org.apache.commons.codec.binary.Base64;
import org.apache.myfaces.renderkit.html.util.AddResource;
import org.apache.myfaces.renderkit.html.util.AddResourceFactory;

import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosBean;
import org.profamilia.hc.view.backing.comun.AntecedentesGeneralesUsuarioBean;
import org.profamilia.hc.view.backing.comun.AntecedentesGinecologicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.AntecedentesUsuarioBean;
import org.profamilia.hc.view.backing.comun.CerrarConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.EncuestaViolenciaUsuarioBean;
import org.profamilia.hc.view.backing.comun.ExamenFisicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.ImpresionDiagnosticaUsuarioBean;
import org.profamilia.hc.view.backing.comun.MotivoBean;
import org.profamilia.hc.view.backing.comun.conducta.FormulaMedicaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.InterConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.RecomedacionUsuarioBean;
import org.profamilia.hc.view.backing.comun.resumen.ResumenHistoriaEspecificaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;


public class MenuHistoriaEfectoJoven extends BaseBean {

    private DatosBasicosUsuarioBean datosBasicosUsuario;

    private MotivoBean motivoConsulta;

    private AntecedentesUsuarioBean antecedentes;

    private AntecedentesGeneralesUsuarioBean antecedentesGenerales;

    private AntecedentesGinecologicosUsuarioBean antecedentesGinecologicos;

    private ExamenFisicoUsuarioBean examenFisicoUsuario;

    private EncuestaViolenciaUsuarioBean encuestaViolenciaUsuario;

    private ImpresionDiagnosticaUsuarioBean impresionDiagnosticaUsuarioBean;

    

    private FormulaMedicaUsuarioBean formulaMedicaUsuarioBean;

    private InterConsultaUsuarioBean interConsultaUsuarioBean;

    private RecomedacionUsuarioBean recomedacionUsuarioBean;

    private CerrarConsultaUsuarioBean cerrarConsultaUsuarioBean;

    private ResumenHistoriaEspecificaBean resumenEspecifico;


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

    private String sexo;

    private Long numeroConsulta;

    private String cie10Principal;

    private String cie10Relacionado1;

    private String codigoCups;

    private Chantegineco antecedenteObject;
    
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

    public void init() {
        primeraConsulta = false;

        String tensionArterial = null;
        Integer frecuenciaCardiaca = null;
        Integer frecuenciaRespiratoria = null;
        BigDecimal peso = null;
        String hallazgos = null;
        BigDecimal temperatura = null;
        
        boolean renderMasculino; 
        renderMasculino = false; 
        renderVademecum = true;
        renderPausarConsulta=false;
		renderServiciosAdmision =false;
             
        // DATOS BASICOS USUARIO
        datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_EFECTO_JOVEN);
        datosBasicosUsuario.setMenuBean("menuHistoriaEfectoJoven");
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
        cuestionarioCovid.setNextAction(BeanNavegacion.RUTA_IR_MOTIVO_EFECTO_JOVEN);
        cuestionarioCovid.setMenuBean("menuHistoriaEfectoJoven");
        cuestionarioCovid.inicializarCuestionario();
        renderMotivo= cuestionarioCovid.esValido();
         

        // MOTIVO DE CONSULTA
        motivoConsulta = (MotivoBean)FacesUtils.getManagedBean("motivoBean");
        motivoConsulta.setTipoServicio(TIPO_CONSULTA);
        motivoConsulta.setNumeroConsulta(numeroConsulta);
        motivoConsulta.setOcultarasesoria(true);
        motivoConsulta.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_EFECTO_JOVEN);
        if (primeraConsulta) {
            motivoConsulta.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_GENERALES_EFECTO_JOVEN);
        }

        motivoConsulta.setMenuBean("menuHistoriaEfectoJoven");
        motivoConsulta.inicializarMotivo();
        renderAntecedentesGenerales = motivoConsulta.esValido();


        // ANTECEDENTES

        if (!primeraConsulta) {
            antecedentes = 
                    (AntecedentesUsuarioBean)FacesUtils.getManagedBean("antecedentesUsuarioBean");
            antecedentes.setTipoServicio(TIPO_CONSULTA);
            antecedentes.setNumeroConsulta(numeroConsulta);
            antecedentes.setTipoHistoria(HISTORIA_EFECTO_JOVEN);
            antecedentes.setUsuario(datosBasicosUsuario.getUsuario());
            antecedentes.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_GINECOLOGICOS_EFECTO_JOVEN);
            antecedentes.setMenuBean("menuHistoriaEfectoJoven");
            if (sexo != null && (sexo.equals(SEXO_MASCULINO) ||  sexo.equals(SEXO_TRANSEXUAL) || sexo.equals(SEXO_AMBIGUO) )) {
                antecedentes.setNextAction(BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_EFECTO_JOVEN);
                renderEncuestaViolencia = true;
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
            antecedentesGenerales.setTipoHistoria(HISTORIA_EFECTO_JOVEN);
            antecedentesGenerales.setNumeroConsulta(numeroConsulta);
            antecedentesGenerales.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_GINECOLOGICOS_EFECTO_JOVEN);
            antecedentesGenerales.setMenuBean("menuHistoriaEfectoJoven");
            if (sexo != null && (sexo.equals(SEXO_MASCULINO) ||  sexo.equals(SEXO_TRANSEXUAL) || sexo.equals(SEXO_AMBIGUO) )) {
                antecedentesGenerales.setNextAction(BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_EFECTO_JOVEN);
                renderEncuestaViolencia = true;
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
        antecedentesGinecologicos.setNextAction(BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_EFECTO_JOVEN);
        antecedentesGinecologicos.setMenuBean("menuHistoriaEfectoJoven");
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
        encuestaViolenciaUsuario.setNextAction(BeanNavegacion.RUTA_IR_EXAMENFISICO_EFECTO_JOVEN);
        encuestaViolenciaUsuario.setMenuBean("menuHistoriaEfectoJoven");
        encuestaViolenciaUsuario.inicializarEncuesta();
        renderExamen = encuestaViolenciaUsuario.esValido();


        // EXAMEN FISICO
        examenFisicoUsuario = 
                (ExamenFisicoUsuarioBean)FacesUtils.getManagedBean("examenFisicoUsuarioBean");
        examenFisicoUsuario.setTipoServicio(TIPO_CONSULTA);
        examenFisicoUsuario.setNumeroConsulta(numeroConsulta);
        examenFisicoUsuario.setNextAction(BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_EFECTO_JOVEN);
        examenFisicoUsuario.setMenuBean("menuHistoriaEfectoJoven");
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
        impresionDiagnosticaUsuarioBean.setNextAction(BeanNavegacion.RUTA_IR_RECOMENDACIONES_EFECTO_JOVEN);
        impresionDiagnosticaUsuarioBean.setMenuBean("menuHistoriaEfectoJoven");
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
        recomedacionUsuarioBean.setMenuBean("menuHistoriaEfectoJoven");
        recomedacionUsuarioBean.inicializarRecomedaciones();
        renderCerrarConsulta = recomedacionUsuarioBean.esValido();


      

        // CONDUCTA - FORMULA MEDICA
        formulaMedicaUsuarioBean = 
                (FormulaMedicaUsuarioBean)FacesUtils.getManagedBean("formulaMedicaUsuarioBean");
        formulaMedicaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        formulaMedicaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        formulaMedicaUsuarioBean.setNumeroConsulta(numeroConsulta);
        formulaMedicaUsuarioBean.setCodigoCIE10(cie10Principal);
        formulaMedicaUsuarioBean.setConsecutivo(1);
        formulaMedicaUsuarioBean.setMenuBean("menuHistoriaEfectoJoven");
        formulaMedicaUsuarioBean.inicializardFormulaMedica();
        
        // CONDUCTA - FORMULA MEDICA
           vademecumUsuarioBean = (VademecumMedicoBean)FacesUtils.getManagedBean("vademecumMedicoBean");
           vademecumUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
           vademecumUsuarioBean.setTipoServicio(TIPO_CONSULTA);
           vademecumUsuarioBean.setNumeroConsulta(numeroConsulta);
           vademecumUsuarioBean.setCodigoCIE10(cie10Principal);
           vademecumUsuarioBean.setConsecutivo(1);
           vademecumUsuarioBean.setMenuBean("menuHistoriaEfectoJoven");
        vademecumUsuarioBean.setRenderAlertaIve(false);
           vademecumUsuarioBean.inicializardFormulaMedica();


    

        // CONDUCTA - INTER-CONSULTA
        interConsultaUsuarioBean = 
                (InterConsultaUsuarioBean)FacesUtils.getManagedBean("interConsultaUsuarioBean");
        interConsultaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        interConsultaUsuarioBean.setTipoServicio(TIPO_CONSULTA);
        interConsultaUsuarioBean.setNumeroConsulta(numeroConsulta);
        interConsultaUsuarioBean.setCie10Principal(cie10Principal);
        interConsultaUsuarioBean.setConsecutivo(1);
        interConsultaUsuarioBean.setMenuBean("menuHistoriaEfectoJoven");
        if (datosBasicosUsuario.getConsulta() != null) {
            Long tipoDocuentoAdmision = 
                datosBasicosUsuario.getConsulta().getCcontipdoc().getCtdnnumero().longValue();
            if (tipoDocuentoAdmision == IConstantes.TIPO_DOCUMENTO_ADMISION) {
                    interConsultaUsuarioBean.setNumeroAdmision(datosBasicosUsuario.getConsulta().getCconnumdoc().longValue());
            }
        }
        interConsultaUsuarioBean.inicializarInterConsulta();

  

    


        // CERRAR CONSULTA
        cerrarConsultaUsuarioBean = 
                (CerrarConsultaUsuarioBean)FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
        cerrarConsultaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        cerrarConsultaUsuarioBean.setMenuBean("menuHistoriaEfectoJoven");
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

    public String irPausarConsultaControlEfectoJoven() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_PAUSAR_CONSULTA_EFECTO_JOVEN;
    }

    /**
     * @return
     */
    public String irDatosEfectoJoven() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_DATOS_EFECTO_JOVEN;
    }

    /**
     * @return
     */
    public String irMotivoEfectoJoven() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_MOTIVO_EFECTO_JOVEN;
    }
    
    public String irCuestionarioCovidEfectoJoven() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_EFECTO_JOVEN;
        }



    /**
     * @return
     */
    public String irAntecedentesGeneralesEfectoJoven() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_GENERALES_EFECTO_JOVEN;
    }


    /**
     * @return
     */
    public String irAntecedentesEfectoJoven() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_EFECTO_JOVEN;
    }


    /**
     * @return
     */
    public String irAntecedentesGinecologicosEfectoJoven() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_GINECOLOGICOS_EFECTO_JOVEN;
    }

    /**
     * @return
     */
    public String irExamenFisicoEfectoJoven() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EXAMENFISICO_EFECTO_JOVEN;
    }


    /**
     * @return
     */
    public String irEncuestaViolenciaEfectoJoven() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ENCUESTA_VIOLENCIA_EFECTO_JOVEN;
    }


    /**
     * @return
     */
    public String irImpDiagnosticaEfectoJoven() {

        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_EFECTO_JOVEN;
    }

   



    /**
     * @return
     */
    public String irFormulaMedicaEfectoJoven() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FORMULAMEDICA_EFECTO_JOVEN;
    }
    
    /**
     * @return
     */
    public String irVademecumMedicoEfectoJoven() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_VADEMCUM_EFECTO_JOVEN;
    }


    /**
     * @return
     */
    public String irInterConsultaEfectoJoven() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INTERCONSULTA_EFECTO_JOVEN;
    }


   



    /**
     * @return
     */
    public String irRecomedacionEfectoJoven() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RECOMENDACIONES_EFECTO_JOVEN;
    }


  
    /**
     * @return
     */
    public String irCerrarConsultaEfectoJoven() {
        if (cerrarConsultaUsuarioBean != null) {
            cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
        }
        return BeanNavegacion.RUTA_IR_CERRAR_CONSULTA_EFECTO_JOVEN;
    }




    /**
     * @return
     */
    public String irResumenHistoriaEfectoJoven() {

        inicializarUsuario();

        CerrarConsultaUsuarioBean cerrarConsultaEfectoJoven = 
            (CerrarConsultaUsuarioBean)FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
        cerrarConsultaEfectoJoven.inicalizarCerrarConsultaBean();

        FacesUtils.resetManagedBean("consultarFoliosBean");

        ConsultarFoliosBean generarResumen = 
            (ConsultarFoliosBean)FacesUtils.getManagedBean("consultarFoliosBean");
        if (generarResumen != null) {
            generarResumen.init();
            generarResumen.setEncabezado(true);
            generarResumen.setUsuario(datosBasicosUsuario.getUsuario());
            generarResumen.consultarFoliosUsuario();

        }
      
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_EFECTO_JOVEN;
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
    public String irServiciosAdmisionEfectoJoven() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_SERVICIOS_ADMISION_EFECTO_JOVEN;
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
