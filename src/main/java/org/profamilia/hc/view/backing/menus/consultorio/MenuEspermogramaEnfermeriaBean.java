 package org.profamilia.hc.view.backing.menus.consultorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultorio.ListaEspermogramaBean;
import org.profamilia.hc.view.backing.comun.AplicacionEspermogramaBean;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.ControlVasectomiaBean;
import org.profamilia.hc.view.backing.comun.CerrarConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.PausarConsultaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;


public class MenuEspermogramaEnfermeriaBean extends BaseBean {

     private ListaEspermogramaBean listaEspermograma;   
     private CerrarConsultaUsuarioBean cerrarConsultaUsuarioBean;
     private CerrarConsultaUsuarioBean cerrarConsultaEspermogramaBean;
     
     private AplicacionEspermogramaBean aplicacionBean; 
     private ControlVasectomiaBean vasectomiaBean;
     private DatosBasicosUsuarioBean datosBasicosUsuario;
     
     /** Almacena el usuario que se desea guardar */
     private Chusuario usuario;
     
     private Cnconsclin consulta;
     
     private boolean renderAplicacion; 
     
     private boolean renderCerrarConsulta; 

    private boolean renderCerrarEspermograma; 
     
     private Long numeroConsulta; 


    private boolean renderPausarConsulta;
    private PausarConsultaBean pausarConsulta;
    private boolean tiempoAtencion;
    
    private ConfirmarServiciosAdmisionBean confirmarServiciosAdmision;
                
    private boolean renderServiciosAdmision;

    
    
    
     public MenuEspermogramaEnfermeriaBean() {
     }
     
   
         public void init() {
            consulta = new Cnconsclin();

            listaEspermograma = (ListaEspermogramaBean)FacesUtils.getManagedBean("listaEspermogramaBean");
            usuario = listaEspermograma.getUsuario();
            
            renderServiciosAdmision =false;
            renderAplicacion = false;
            renderCerrarEspermograma = false; 


            if (listaEspermograma != null && listaEspermograma.getConsulta() != null && 
                listaEspermograma.getConsulta().getCconnumero() != null) {
                consulta = listaEspermograma.getConsulta();
                numeroConsulta = new Long(listaEspermograma.getConsulta().getCconnumero());
            }

             // RECOMENDACION VASECTOMIA 
             aplicacionBean =
                    (AplicacionEspermogramaBean)FacesUtils.getManagedBean("aplicacionEspermogramaBean");
             aplicacionBean.setUsuario(usuario);
             aplicacionBean.setMenuBean("menuEspermogramaEnfermeriaBean");
             aplicacionBean.setConsulta(consulta);
             aplicacionBean.setTipoServicio(TIPO_CONSULTA);
             aplicacionBean.inicalizarAplicacionBean();
             renderAplicacion = aplicacionBean.isConsultaCerrada();
             renderCerrarEspermograma = !aplicacionBean.isConsultaCerrada(); 
             if (renderCerrarEspermograma) {
                 aplicacionBean.setNextAction(BeanNavegacion.RUTA_IR_CERRAR_ESPERMOGRAMA);
             } else {
                 aplicacionBean.setNextAction(BeanNavegacion.RUTA_IR_CONTROL_VASECTOMIA);
             }

//          Cerrar Consulta espermograma
              cerrarConsultaEspermogramaBean = 
                      (CerrarConsultaUsuarioBean)FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
              cerrarConsultaEspermogramaBean.setUsuario(usuario);
              cerrarConsultaEspermogramaBean.setRenderImprimirEspermograma(true);
              cerrarConsultaEspermogramaBean.setNextAction(BeanNavegacion.RUTA_IR_ESPERMOGRAMA);
              cerrarConsultaEspermogramaBean.setMenuBean("menuEspermogramaEnfermeriaBean");
              cerrarConsultaEspermogramaBean.setConsulta(consulta);
              cerrarConsultaEspermogramaBean.setEsVacunacion(true); 
              cerrarConsultaEspermogramaBean.inicalizarCerrarConsultaBean();

             vasectomiaBean = 
                     (ControlVasectomiaBean)FacesUtils.getManagedBean("controlVasectomiaBean");
             vasectomiaBean.setUsuario(usuario);
             vasectomiaBean.setNextAction(BeanNavegacion.RUTA_IR_LISTA_ESPERMOGRAMA);
             vasectomiaBean.setMenuBean("menuEspermogramaEnfermeriaBean");
             vasectomiaBean.setConsulta(consulta);
             vasectomiaBean.setTipoServicio(TIPO_CONSULTA); 
             vasectomiaBean.inicializarVasectomia();
             renderCerrarConsulta = vasectomiaBean.esValido();
             
             // CERRAR CONSULTA ENTREGA
/*             cerrarConsultaUsuarioBean = 
                     (CerrarConsultaUsuarioBean)FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
             cerrarConsultaUsuarioBean.setUsuario(listaEspermograma.getUsuario());
             cerrarConsultaUsuarioBean.setNextAction(BeanNavegacion.RUTA_IR_LISTA_ESPERMOGRAMA);
             cerrarConsultaUsuarioBean.setMenuBean("menuEspermogramaEnfermeriaBean");
             cerrarConsultaUsuarioBean.setConsulta(consulta);
             cerrarConsultaUsuarioBean.setEsVacunacion(true); 
             cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
*/
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
    
    public String irPausarConsultaEspermograma() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_PAUSAR_CONSULTA_ESPERMOGRAMA;
    }
  
     public String irEspemograma() {
         inicializarUsuario();
         if (aplicacionBean != null) {
             aplicacionBean.setGeneroEspermograma(false);
         }
         return BeanNavegacion.RUTA_IR_ESPERMOGRAMA;
     }

     public String irRecomedacionVasectomia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CONTROL_VASECTOMIA;
     }

     public String irCerrarEspermograma() {
         if (cerrarConsultaEspermogramaBean != null) {
                  cerrarConsultaEspermogramaBean.inicalizarCerrarConsultaBean();
              }
         return BeanNavegacion.RUTA_IR_CERRAR_ESPERMOGRAMA;
     }

    public String irCerrarConsultaEspermograma() {
       if (cerrarConsultaUsuarioBean != null) {
                cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
            }
        return BeanNavegacion.RUTA_IR_CERRAR_CONSULTA_ESPERMOGRAMA;
        }
     
     public void inicializarUsuario() {
         if (listaEspermograma.getUsuario() != null)
             this.setUsuario(listaEspermograma.getUsuario());
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

    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    public Cnconsclin getConsulta() {
        return consulta;
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
	
	public String irServiciosAdmisionEspermograma() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_SERVICIOS_ADMISION_ESPERMOGRAMA;
    }

    public void setRenderServiciosAdmision(boolean renderServiciosAdmision) {
        this.renderServiciosAdmision = renderServiciosAdmision;
    }

    public boolean isRenderServiciosAdmision() {
        return renderServiciosAdmision;
    }

    public void setRenderCerrarEspermograma(boolean renderCerrarEspermograma) {
        this.renderCerrarEspermograma = renderCerrarEspermograma;
    }

    public boolean isRenderCerrarEspermograma() {
        return renderCerrarEspermograma;
    }
}
