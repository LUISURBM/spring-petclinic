package org.profamilia.hc.view.backing.asesoria.menu;

import java.util.Date;

import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.asesoria.RegistrarAsesoriaAviseBean;
import org.profamilia.hc.view.backing.asesoria.RegistrarSeguimientoAviseBean;
import org.profamilia.hc.view.backing.asesoria.RegistrarUsuarioAsesoriaBean;
import org.profamilia.hc.view.util.FacesUtils;


public class MnuAsesoriaBean extends BaseBean {

    private RegistrarUsuarioAsesoriaBean usuarioAsesoriaBean;

    private RegistrarAsesoriaAviseBean asesoriaAvise;
    
    private RegistrarSeguimientoAviseBean seguimientoBean; 

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;
    
    private Date fechaAsesoria; 
    
    private boolean renderAsesoria; 
    
    private boolean renderSeguimiento;




    public void init() {

        // DATOS BASICOS USUARIO
        usuarioAsesoriaBean = 
                (RegistrarUsuarioAsesoriaBean)FacesUtils.getManagedBean("registrarUsuarioAsesoriaBean");
        usuarioAsesoriaBean.setNextAction(BeanNavegacion.RUTA_REGISTRAR_ASESORIA_AVISE);
        usuarioAsesoriaBean.setMenuBean("mnuAsesoriaBean");
       // renderasesoriaAvise = datosBasicosUsuario.esValido();

     if(usuarioAsesoriaBean!= null && usuarioAsesoriaBean.getUsuario() != null){
         usuario = usuarioAsesoriaBean.getUsuario(); 
         fechaAsesoria = usuarioAsesoriaBean.getFechaConsulta(); 
     }
     


        asesoriaAvise = 
                (RegistrarAsesoriaAviseBean)FacesUtils.getManagedBean("registrarAsesoriaAviseBean");
        asesoriaAvise.setUsuario(usuario);
        asesoriaAvise.setMenuBean("mnuAsesoriaBean");
        asesoriaAvise.init();
        
        
        
        seguimientoBean = (RegistrarSeguimientoAviseBean)FacesUtils.getManagedBean("registrarSeguimientoAviseBean"); 
        seguimientoBean.setFechaAsesoria(fechaAsesoria);
        seguimientoBean.setMenuBean("mnuAsesoriaBean");
        seguimientoBean.setUsuario(usuario);
        seguimientoBean.init();
        
        renderAsesoria = usuarioAsesoriaBean.isNavegarAsesoria(); 
        renderSeguimiento = usuarioAsesoriaBean.isNavegarSeguimiento(); 

    }


    /**
     * @return
     */
    public String irDatosUsuario() {
           usuarioAsesoriaBean = 
                   (RegistrarUsuarioAsesoriaBean)FacesUtils.getManagedBean("registrarUsuarioAsesoriaBean");
            usuarioAsesoriaBean.setRenderSeguimiento(false); 
            usuarioAsesoriaBean.setSelectedIndex(0);
          return BeanNavegacion.RUTA_IR_REGISTRAR_ASESORIA; 
       }

    /**
     * @return
     */
    public String irRegistrarAsesoria() {
            return BeanNavegacion.RUTA_REGISTRAR_ASESORIA_AVISE; 
       }

    /**
     * @return
     */
    public String irRegistrarSeguimiento() {
           seguimientoBean = (RegistrarSeguimientoAviseBean)FacesUtils.getManagedBean("registrarSeguimientoAviseBean"); 
           seguimientoBean.setGeneroReporte(false);
           return BeanNavegacion.RUTA_REGISTRAR_SEGUIMIENTO_AVISE; 
       }

    public void inicializarUsuario() {
        if (usuarioAsesoriaBean.getUsuario() != null)
            this.setUsuario(usuarioAsesoriaBean.getUsuario());
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
     * @param fechaAsesoria
     */
    public void setFechaAsesoria(Date fechaAsesoria) {
        this.fechaAsesoria = fechaAsesoria;
    }

    /**
     * @return
     */
    public Date getFechaAsesoria() {
        return fechaAsesoria;
    }

    /**
     * @param renderAsesoria
     */
    public void setRenderAsesoria(boolean renderAsesoria) {
        this.renderAsesoria = renderAsesoria;
    }

    /**
     * @return
     */
    public boolean isRenderAsesoria() {
        return renderAsesoria;
    }

    /**
     * @param renderSeguimiento
     */
    public void setRenderSeguimiento(boolean renderSeguimiento) {
        this.renderSeguimiento = renderSeguimiento;
    }

    /**
     * @return
     */
    public boolean isRenderSeguimiento() {
        return renderSeguimiento;
    }
}
