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

import org.profamilia.hc.model.dto.Chinfomamogr;
import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarInformeEcografiasBean;
import org.profamilia.hc.view.backing.comun.CerrarInformeEcografiaBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.PausarConsultaBean;
import org.profamilia.hc.view.backing.comun.resumen.ResumenHistoriaEspecificaBean;
import org.profamilia.hc.view.backing.procedimiento.InformeEcografiaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;


public class MenuInformeEcografiaBean extends BaseBean {

    private DatosBasicosUsuarioBean datosBasicosUsuario;


    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private InformeEcografiaBean informe;

    private CerrarInformeEcografiaBean cerrarInformeEcografiaBean;

    private boolean renderInforme;

    private boolean renderCerrar;

    private ResumenHistoriaEspecificaBean resumenEspecifico;
    
    private Chinfomamogr informeObject;

    private String javaScriptText;

    private Long numeroConsulta;

    private boolean renderPausarConsulta;
    private PausarConsultaBean pausarConsulta;
    private boolean tiempoAtencion;
	
	private ConfirmarServiciosAdmisionBean confirmarServiciosAdmision;
			
	private boolean renderServiciosAdmision;
        
    private CuestionarioCovidBean cuestionarioCovid;
    private boolean renderCovid;

    public void init() {


        // DATOS BASICOS USUARIO
        datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_ECOGRAFIA);
        datosBasicosUsuario.setMenuBean("menuInformeEcografiaBean");
        renderCovid = datosBasicosUsuario.esValido();
        
        if (datosBasicosUsuario != null && 
            datosBasicosUsuario.getConsulta() != null && 
            datosBasicosUsuario.getConsulta().getCconnumero() != null) {
            numeroConsulta = 
                    new Long(datosBasicosUsuario.getConsulta().getCconnumero());
        }
        
        // MOTIVO DE CONSULTA
        cuestionarioCovid = (CuestionarioCovidBean)FacesUtils.getManagedBean("cuestionarioCovidBean");
        cuestionarioCovid.setTipoServicio(TIPO_CONSULTA);
        cuestionarioCovid.setNumeroConsulta(numeroConsulta);
        if(datosBasicosUsuario != null && datosBasicosUsuario.getUsuario() != null && datosBasicosUsuario.getUsuario().getHuslnumero() != null ){
            cuestionarioCovid.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
        }
        cuestionarioCovid.setNextAction(BeanNavegacion.RUTA_IR_INFORME_ECOGRAFIA);
        cuestionarioCovid.setMenuBean("menuInformeEcografiaBean");
        cuestionarioCovid.inicializarCuestionario();
        renderInforme= cuestionarioCovid.esValido();


        informe = 
                (InformeEcografiaBean)FacesUtils.getManagedBean("informeEcografiaBean");
        informe.setTipoServicio(TIPO_CONSULTA);
        informe.setConsulta(datosBasicosUsuario.getConsulta());
        informe.setUsuario(datosBasicosUsuario.getUsuario());
        informe.setNextAction(BeanNavegacion.RUTA_IR_CERRAR_ECOGRAFIA);
        informe.setMenuBean("menuInformeEcografiaBean");
        informe.inicializarEcografia();
        
        renderCerrar = informe.esValido();
        
        if(informe!= null && informe.getInforme()!=null){
            informeObject = informe.getInforme(); 
        }


        // CERRAR CONSULTA
        cerrarInformeEcografiaBean = 
                (CerrarInformeEcografiaBean)FacesUtils.getManagedBean("cerrarInformeEcografiaBean");
        cerrarInformeEcografiaBean.setUsuario(datosBasicosUsuario.getUsuario());
        cerrarInformeEcografiaBean.setConsulta(datosBasicosUsuario.getConsulta());
        cerrarInformeEcografiaBean.setInforme(informeObject);
        cerrarInformeEcografiaBean.setMenuBean("menuInformeEcografiaBean");
        cerrarInformeEcografiaBean.setConsulta(datosBasicosUsuario.getConsulta());
        cerrarInformeEcografiaBean.setEsVacunacion(false); 
        cerrarInformeEcografiaBean.inicalizarCerrarConsultaBean();


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
    
    public String irPausarConsultaEcografia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_PAUSAR_CONSULTA_ECOGRAFIA;
    }

    /**
     * @return
     */
    public String irDatosEcografia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_DATOS_ECOGRAFIA;
    }
    
    public String irCuestionarioCovidEcografia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_ECOGRAFIA;
        }



    /**
     * @return
     */
    public String irInformeEcografia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INFORME_ECOGRAFIA;
    }
    
    /**
     * @return
     */
     public String irCargarImagen(){
        /* inicializarUsuario();*/
         return BeanNavegacion.RUTA_IR_CARGA_IMAGEN;
     }

    /**
     * @return
     */
    public String irCerrarEcografia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERRAR_ECOGRAFIA;
    }


    /**
     * @return
     */
    public String irResumenHistoriaEspecificaEcografia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_ECOGRAFIA;
    }


    /**
     * @return
     */
    public String irResumenHistoriaEcografia() {
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
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_ECOGRAFIA;
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
     * @param renderInforme
     */
    public void setRenderInforme(boolean renderInforme) {
        this.renderInforme = renderInforme;
    }

    /**
     * @return
     */
    public boolean isRenderInforme() {
        return renderInforme;
    }

    /**
     * @param renderCerrar
     */
    public void setRenderCerrar(boolean renderCerrar) {
        this.renderCerrar = renderCerrar;
    }

    /**
     * @return
     */
    public boolean isRenderCerrar() {
        return renderCerrar;
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


    public void setRenderCovid(boolean renderCovid) {
        this.renderCovid = renderCovid;
    }

    public boolean isRenderCovid() {
        return renderCovid;
    }
}

