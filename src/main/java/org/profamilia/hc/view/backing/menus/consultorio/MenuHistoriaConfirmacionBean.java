package org.profamilia.hc.view.backing.menus.consultorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.CerrarConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.ConfirmarServicioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.PausarConsultaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;


public class MenuHistoriaConfirmacionBean extends BaseBean {

    private DatosBasicosUsuarioBean datosBasicosUsuario;
    
    private ConfirmarServicioBean confirmacionBean;
    
    private CerrarConsultaUsuarioBean cerrarConsultaUsuarioBean;
    
    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;
    
    private boolean renderConfirmacion; 
    
    private boolean renderCerrarConsulta; 
    
    private Long numeroConsulta; 
    
    private Cpservicio codigoServicio;

    private boolean renderPausarConsulta;

    private PausarConsultaBean pausarConsulta;

    private boolean tiempoAtencion;
	
	private ConfirmarServiciosAdmisionBean confirmarServiciosAdmision;
			
	private boolean renderServiciosAdmision;


    public MenuHistoriaConfirmacionBean() {
    }
    
  
        public void init() {
        
       
			renderServiciosAdmision =false;
            // DATOS BASICOS USUARIO
            datosBasicosUsuario = 
                    (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
            datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_CONFIRMACION_PRESTACION);
            datosBasicosUsuario.setMenuBean("menuHistoriaConfirmacionBean");
            renderConfirmacion = datosBasicosUsuario.esValido();
            /*renderPausarConsulta = datosBasicosUsuario.esValido();*/
   
            if (datosBasicosUsuario != null && 
                datosBasicosUsuario.getConsulta() != null && 
                datosBasicosUsuario.getConsulta().getCconnumero() != null) {
                numeroConsulta = 
                        new Long(datosBasicosUsuario.getConsulta().getCconnumero());

            }
            
            if (datosBasicosUsuario != null && 
                         datosBasicosUsuario.getServicio()!= null) {
                codigoServicio = datosBasicosUsuario.getServicio();

            }
            
            // CONFIRMAR CONSULTA
            confirmacionBean = 
                    (ConfirmarServicioBean)FacesUtils.getManagedBean("confirmarServicioBean");
            confirmacionBean.setUsuario(datosBasicosUsuario.getUsuario());
            confirmacionBean.setMenuBean("menuHistoriaConfirmacionBean");
            confirmacionBean.setNumeroConsulta(numeroConsulta);
            confirmacionBean.setConsulta(datosBasicosUsuario.getConsulta());
            confirmacionBean.inicalizarConfirmarServicioBean();
            /*renderCerrarConsulta = confirmacionBean.esValido();
            if(renderCerrarConsulta){
                confirmacionBean.setNextAction(BeanNavegacion.RUTA_IR_CERRAR_CONSULTA_CONFIRMACION);
            }

            // CERRAR CONSULTA
           cerrarConsultaUsuarioBean =
                    (CerrarConsultaUsuarioBean)FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
            cerrarConsultaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
            cerrarConsultaUsuarioBean.setMenuBean("menuHistoriaConfirmacionBean");
            cerrarConsultaUsuarioBean.setConsulta(datosBasicosUsuario.getConsulta());
            cerrarConsultaUsuarioBean.setEsVacunacion(true);
            cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean()

        tiempoAtencion = datosBasicosUsuario.esValido();

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

        // PAUSAR CONSULTA     
        if (renderPausarConsulta) {
            pausarConsulta = 
                    (PausarConsultaBean)FacesUtils.getManagedBean("pausarConsultaBean");
            pausarConsulta.setNumeroConsulta(numeroConsulta);
            pausarConsulta.getCausasPausarConsultas();
        }
             ;*/
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

        initPausarConsulta();
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
        
    
    public String irPausarConsultaConfirmacion() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_PAUSAR_CONSULTA_CONFIRMACION;
    }
  
 
    public String irDatosUsuario() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_DATOS_CONFIRMACION_HISTORIA;
        }

    public String irConfirmacionServicio() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CONFIRMACION_PRESTACION;
        }

    public String irCerrarConfirmacion() {
            if (cerrarConsultaUsuarioBean != null) {
                cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
            }
        return BeanNavegacion.RUTA_IR_CERRAR_CONSULTA_CONFIRMACION;
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

    public void setRenderConfirmacion(boolean renderConfirmacion) {
        this.renderConfirmacion = renderConfirmacion;
    }

    public boolean isRenderConfirmacion() {
        return renderConfirmacion;
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
    
}
