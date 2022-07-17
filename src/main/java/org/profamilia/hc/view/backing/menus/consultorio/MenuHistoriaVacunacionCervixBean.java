package org.profamilia.hc.view.backing.menus.consultorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.AplicacionVacunaCervixBean;
import org.profamilia.hc.view.backing.comun.CerrarConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.PausarConsultaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.RegistrarEscalaValoracionCaidasCEBean;


public class MenuHistoriaVacunacionCervixBean extends BaseBean {

    private DatosBasicosUsuarioBean datosBasicosUsuario;
    
    private CerrarConsultaUsuarioBean cerrarConsultaUsuarioBean;
    
    private AplicacionVacunaCervixBean aplicacionBean; 
    
    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;
    
    private boolean renderAplicacion; 
    
    private boolean renderCerrarConsulta; 
    
    private Long numeroConsulta; 
    
    private Integer numeroDosis;
    
    private boolean renderPausarConsulta;
    
    private PausarConsultaBean pausarConsulta;
    
    private boolean tiempoAtencion;
	
	private ConfirmarServiciosAdmisionBean confirmarServiciosAdmision;
			
	private boolean renderServiciosAdmision;
   
    private RegistrarEscalaValoracionCaidasCEBean registrarEscalaValoracionCaidasBean;
    
    private boolean renderEscalaCaidas;     


    public MenuHistoriaVacunacionCervixBean() {
    }
    
        public void init() {
        
            numeroDosis = null; 
            renderPausarConsulta=false;
			renderServiciosAdmision =false;
            renderEscalaCaidas = false;


            // DATOS BASICOS USUARIO
            datosBasicosUsuario = 
                    (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
            datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_VACUNACION_CERVIX);
            datosBasicosUsuario.setMenuBean("menuHistoriaVacunacionCervixBean");
            renderAplicacion = datosBasicosUsuario.esValido();
            if(IConstantes.ACTIVAR_PAUSAR_CONSULTA){
            renderPausarConsulta = datosBasicosUsuario.esValido();
            }
   
            if (datosBasicosUsuario != null && 
                datosBasicosUsuario.getConsulta() != null && 
                datosBasicosUsuario.getConsulta().getCconnumero() != null) {
                numeroConsulta = 
                        new Long(datosBasicosUsuario.getConsulta().getCconnumero());

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
            
            if(datosBasicosUsuario!= null && datosBasicosUsuario.getConsulta()!= null && datosBasicosUsuario.getConsulta().getCcocservic()!= null &&
            datosBasicosUsuario.getConsulta().getCcocservic().getCsvccodigo()!= null){
                if(datosBasicosUsuario.getConsulta().getCcocservic().getCsvccodigo().equals(CODIGO_VACUNACION_CERVIX_PRIMERA_TOMA)
                || datosBasicosUsuario.getConsulta().getCcocservic().getCsvccodigo().equals(CODIGO_VACUNACION_GARDASIL_PRIMERA_TOMA) 
                || datosBasicosUsuario.getConsulta().getCcocservic().getCsvccodigo().equals(CODIGO_VACUNACION_CERVIX_PRIMERA_TOMA_PAQUETE)
                ||  datosBasicosUsuario.getConsulta().getCcocservic().getCsvccodigo().equals(CODIGO_VACUNACION_GARDASIL_PRIMERA_TOMA_PAQUETE) ){
                    numeroDosis = 1; 
                }
                if(datosBasicosUsuario.getConsulta().getCcocservic().getCsvccodigo().equals(CODIGO_VACUNACION_CERVIX_SEGUNDA_TOMA)
                || datosBasicosUsuario.getConsulta().getCcocservic().getCsvccodigo().equals(CODIGO_VACUNACION_GARDASIL_SEGUNDA_TOMA)
                || datosBasicosUsuario.getConsulta().getCcocservic().getCsvccodigo().equals(CODIGO_VACUNACION_CERVIX_SEGUNDA_TOMA_PAQUETE)
                || datosBasicosUsuario.getConsulta().getCcocservic().getCsvccodigo().equals(CODIGO_VACUNACION_GARDASIL_SEGUNDA_TOMA_PAQUETE)){
                    numeroDosis = 2; 
                }
                if(datosBasicosUsuario.getConsulta().getCcocservic().getCsvccodigo().equals(CODIGO_VACUNACION_CERVIX_TERCERA_TOMA)
                || datosBasicosUsuario.getConsulta().getCcocservic().getCsvccodigo().equals(CODIGO_VACUNACION_GARDASIL_TERCERA_TOMA)
                || datosBasicosUsuario.getConsulta().getCcocservic().getCsvccodigo().equals(CODIGO_VACUNACION_CERVIX_TERCERA_TOMA_PAQUETE)
                || datosBasicosUsuario.getConsulta().getCcocservic().getCsvccodigo().equals(CODIGO_VACUNACION_GARDASIL_TERCERA_TOMA_PAQUETE) ){
                    numeroDosis = 3; 
                }
            }
            
            // APLICACION CERVIX 
            aplicacionBean = 
                    (AplicacionVacunaCervixBean)FacesUtils.getManagedBean("aplicacionVacunaCervixBean");
            aplicacionBean.setUsuario(datosBasicosUsuario.getUsuario());
            aplicacionBean.setNextAction(BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_CERVIX_VACUNACION);
            aplicacionBean.setMenuBean("menuHistoriaVacunacionCervixBean");
            aplicacionBean.setNumeroDosis(numeroDosis);
            aplicacionBean.setNumeroConsulta(numeroConsulta);
            aplicacionBean.setTipoServicio(TIPO_CONSULTA); 
            aplicacionBean.inicalizarAplicacionBean();
            renderEscalaCaidas = aplicacionBean.esValido();
            
        registrarEscalaValoracionCaidasBean = 
           (RegistrarEscalaValoracionCaidasCEBean)FacesUtils.getManagedBean("registrarEscalaValoracionCaidasCEBean");
           registrarEscalaValoracionCaidasBean.setNumeroConsulta(numeroConsulta);
        if (datosBasicosUsuario != null &&
           datosBasicosUsuario.getUsuario() != null && 
           datosBasicosUsuario.getUsuario().getHuslnumero() != null) {
               registrarEscalaValoracionCaidasBean.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
           }
           registrarEscalaValoracionCaidasBean.setMenuBean("menuHistoriaVacunacionCervixBean");
           registrarEscalaValoracionCaidasBean.setNextAction(BeanNavegacion.RUTA_IR_CERRAR_CONSULTA_VACUNACION_CERVIX);
           registrarEscalaValoracionCaidasBean.init();
           renderCerrarConsulta = registrarEscalaValoracionCaidasBean.esValido();
            
            
            // CERRAR CONSULTA
            cerrarConsultaUsuarioBean = 
                    (CerrarConsultaUsuarioBean)FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
            cerrarConsultaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
            cerrarConsultaUsuarioBean.setMenuBean("menuHistoriaVacunacionCervixBean");
            cerrarConsultaUsuarioBean.setConsulta(datosBasicosUsuario.getConsulta());
            cerrarConsultaUsuarioBean.setEsVacunacion(true); 
            cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();

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
  

    public String irPausarConsultaCervixVacunacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_PAUSAR_CONSULTA_CERVIX_VACUNACION;
    }
    
    public String irDatosVacunacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_VACUNACION_CERVIX;
        }

    public String irVacunacionCervix() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_VACUNACION_CERVIX;
        }

    public String irCerrarVacunacionCervix() {
            if (cerrarConsultaUsuarioBean != null) {
                cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
            }
        return BeanNavegacion.RUTA_IR_CERRAR_CONSULTA_VACUNACION_CERVIX;
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
	
	public String irserviciosadmisionCervixVacunacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_SERVICIOS_ADMISION_CERVIX_VACUNACION;
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
    public String irEscalaValoracionCaidasCervixVacunacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_CERVIX_VACUNACION;
    }
}
