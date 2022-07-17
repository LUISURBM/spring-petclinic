package org.profamilia.hc.view.backing.menus.consultorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.ViewHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.commons.codec.binary.Base64;
import org.apache.myfaces.renderkit.html.util.AddResource;
import org.apache.myfaces.renderkit.html.util.AddResourceFactory;

import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosBean;
import org.profamilia.hc.view.backing.comun.CerrarConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.AplicacionEspermogramaBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.PausarConsultaBean;
import org.profamilia.hc.view.backing.comun.conducta.RecomedacionUsuarioBean;
import org.profamilia.hc.view.backing.comun.resumen.ResumenHistoriaEspecificaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.ExpandableTreeModel;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;
import org.profamilia.hc.view.backing.comun.RegistrarEscalaValoracionCaidasCEBean;


public class MenuVasectomiaBean extends BaseBean {

    private DatosBasicosUsuarioBean datosBasicosUsuario;

    private AplicacionEspermogramaBean espermograma;

    private CerrarConsultaUsuarioBean cerrarConsultaUsuarioBean;
    private CerrarConsultaUsuarioBean cerrarConsultaEspermogramaBean;

    private ResumenHistoriaEspecificaBean resumenEspecifico;


    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;
    
    private Cnconsclin consulta;

    private boolean renderConducta;

    private boolean renderCerrarConsulta;

    private boolean renderControl;

    private ExpandableTreeModel trnhistoria;

    private Long numeroConsulta;
    
    private String javaScriptText;

    private boolean renderPausarConsulta;
    private PausarConsultaBean pausarConsulta;
    private boolean tiempoAtencion;
    
    private ConfirmarServiciosAdmisionBean confirmarServiciosAdmision;
			
    private boolean renderServiciosAdmision;
        
    private RegistrarEscalaValoracionCaidasCEBean registrarEscalaValoracionCaidasBean;
    
    private boolean renderEscalaCaidas;
    
    private boolean renderEscalaCaidasVasec;


    public void init() {
    
        renderEscalaCaidas= false;
        renderEscalaCaidasVasec= false;

        consulta = new Cnconsclin();
        // DATOS BASICOS USUARIO
        datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_MEDICO_ESPERMOGRAMA);
        datosBasicosUsuario.setMenuBean("menuVasectomiaBean");
        renderControl = datosBasicosUsuario.esValido();

        if (datosBasicosUsuario != null && 
            datosBasicosUsuario.getConsulta() != null && 
            datosBasicosUsuario.getConsulta().getCconnumero() != null) {
            consulta = datosBasicosUsuario.getConsulta();
            numeroConsulta = 
                    new Long(datosBasicosUsuario.getConsulta().getCconnumero());

        }
        
        
        espermograma = 
                (AplicacionEspermogramaBean)FacesUtils.getManagedBean("aplicacionEspermogramaBean");
        espermograma.setUsuario(datosBasicosUsuario.getUsuario());
        espermograma.setTipoServicio(TIPO_CONSULTA);
        espermograma.setConsulta(consulta);
        espermograma.setMenuBean("menuVasectomiaBean");
        espermograma.inicalizarAplicacionBean();
        renderEscalaCaidas = !espermograma.isConsultaCerrada();
        if (renderEscalaCaidas) {
            renderEscalaCaidasVasec = true;
            espermograma.setNextAction(BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_CONTROL_VASECTOMIA);
            if(consulta != null && consulta.getCcocservic() != null && consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_VASECTOMIA)){
                espermograma.setNextAction(BeanNavegacion.RUTA_IR_CERRAR_VASECTOMIA);
                renderEscalaCaidasVasec = false;
            }
        } else {
            espermograma.setNextAction(BeanNavegacion.RUTA_LISTA);
        }
        
        registrarEscalaValoracionCaidasBean = 
           (RegistrarEscalaValoracionCaidasCEBean)FacesUtils.getManagedBean("registrarEscalaValoracionCaidasCEBean");
           registrarEscalaValoracionCaidasBean.setNumeroConsulta(numeroConsulta);
        if (datosBasicosUsuario != null &&
           datosBasicosUsuario.getUsuario() != null && 
           datosBasicosUsuario.getUsuario().getHuslnumero() != null) {
               registrarEscalaValoracionCaidasBean.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
           }
           registrarEscalaValoracionCaidasBean.setMenuBean("menuVasectomiaBean");
           registrarEscalaValoracionCaidasBean.setNextAction(BeanNavegacion.RUTA_IR_CERRAR_VASECTOMIA);
           registrarEscalaValoracionCaidasBean.init();
           renderCerrarConsulta = registrarEscalaValoracionCaidasBean.esValido();


        //          Cerrar Consulta espermograma
         cerrarConsultaEspermogramaBean = 
                 (CerrarConsultaUsuarioBean)FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
         cerrarConsultaEspermogramaBean.setUsuario(datosBasicosUsuario.getUsuario());
//         cerrarConsultaEspermogramaBean.setNextAction(BeanNavegacion.RUTA_LISTA);
         cerrarConsultaEspermogramaBean.setRenderImprimirEspermograma(true);
         cerrarConsultaEspermogramaBean.setNextAction(BeanNavegacion.RUTA_IR_MEDICO_ESPERMOGRAMA);
         cerrarConsultaEspermogramaBean.setMenuBean("menuVasectomiaBean");
         cerrarConsultaEspermogramaBean.setConsulta(consulta);
         cerrarConsultaEspermogramaBean.setEsVacunacion(true); 
         cerrarConsultaEspermogramaBean.inicalizarCerrarConsultaBean();

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
		 
		renderServiciosAdmision =false;

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
    
    public String irPausarConsultaControlVasectomia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_PAUSAR_CONSULTA_CONTROL_VASECTOMIA;
    }

    /**
     * @return
     */
    public String irDatosVasectomiaControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_DATOS_VASECTOMIA;
    }
    
    public String irCuestionarioCovidSaludSexual() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_SALUD_SEXUAL;
        }



    /**
     * @return
     */
    public String irEspermogramaUsuario() {
        inicializarUsuario();
//        return BeanNavegacion.RUTA_IR_CONTROL_VASECTOMIA;
        return BeanNavegacion.RUTA_IR_CONTROL_ESPERMOGRAMA;
    }

    /**
     * @return
     */
    public String irEspermogramaMedico() {
        inicializarUsuario();
    //        return BeanNavegacion.RUTA_IR_CONTROL_VASECTOMIA;
        if (espermograma != null) {
            espermograma.setGeneroEspermograma(false);
        }
        return BeanNavegacion.RUTA_IR_MEDICO_ESPERMOGRAMA;
    }

    /**
     * @return
     */
    public String irRecomedacionVasectomia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RECOMENDACIONES_VASECTOMIA;
    }


    /**
     * @return
     */
    public String irCerrarConsultaControl() {
        if (cerrarConsultaUsuarioBean != null) {
            cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
        }
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERRAR_VASECTOMIA;
    }

   

    /**
     * @return
     */
    public String irResumenHistoriaControl() {
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
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_CONTROL_VASECTOMIA;
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
	public String irServiciosAdmisionControlVasectomia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_SERVICIOS_ADMISION_CONTROL_VASECTOMIA;
    }

    public void setRenderServiciosAdmision(boolean renderServiciosAdmision) {
        this.renderServiciosAdmision = renderServiciosAdmision;
    }

    public boolean isRenderServiciosAdmision() {
        return renderServiciosAdmision;
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
    public String irEscalaValoracionCaidasControlVasectomia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_CONTROL_VASECTOMIA;
    }

    public void setRenderEscalaCaidasVasec(boolean renderEscalaCaidasVasec) {
        this.renderEscalaCaidasVasec = renderEscalaCaidasVasec;
    }

    public boolean isRenderEscalaCaidasVasec() {
        return renderEscalaCaidasVasec;
    }
}
