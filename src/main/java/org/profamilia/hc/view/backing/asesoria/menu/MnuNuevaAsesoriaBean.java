package org.profamilia.hc.view.backing.asesoria.menu;

import java.util.Date;

import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.asesoria.RegistrarUsuarioAsesoriaBean;
import org.profamilia.hc.view.backing.asesoria.RegistroUsuarioNuevaAsesoriaBean;
import org.profamilia.hc.view.util.FacesUtils;


public class MnuNuevaAsesoriaBean extends BaseBean {

    private RegistroUsuarioNuevaAsesoriaBean registroUsuarioNuevaAsesoriaBean;


    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private Date fechaAsesoria;
    private boolean renderAsesoria;

    public void init() {

        // DATOS BASICOS USUARIO
        registroUsuarioNuevaAsesoriaBean = 
                (RegistroUsuarioNuevaAsesoriaBean)FacesUtils.getManagedBean("registroUsuarioNuevaAsesoriaBean");
        registroUsuarioNuevaAsesoriaBean.setNextAction(BeanNavegacion.RUTA_IR_REGISTRAR_ASESORIAS_NUEVA);
        registroUsuarioNuevaAsesoriaBean.setMenuBean("mnuNuevaAsesoriaBean");
        
        if (registroUsuarioNuevaAsesoriaBean != null && 
            registroUsuarioNuevaAsesoriaBean.getUsuario() != null) {
            usuario = registroUsuarioNuevaAsesoriaBean.getUsuario();
            fechaAsesoria = 
                    registroUsuarioNuevaAsesoriaBean.getFechaConsulta();
        }

        renderAsesoria = registroUsuarioNuevaAsesoriaBean.isNavegarAsesoria();


        RegistrarUsuarioAsesoriaBean encabezado = (RegistrarUsuarioAsesoriaBean)FacesUtils.getManagedBean("registrarUsuarioAsesoriaBean");
       
        if(encabezado != null && usuario != null){
            encabezado.setUsuario(usuario);
            encabezado.init();
        }
        
    }


    /**
     * @return
     */
    public String irDatosUsuario() {
        registroUsuarioNuevaAsesoriaBean = 
                (RegistroUsuarioNuevaAsesoriaBean)FacesUtils.getManagedBean("registroUsuarioNuevaAsesoriaBean");
        registroUsuarioNuevaAsesoriaBean.setSelectedIndex(0);
        return BeanNavegacion.RUTA_IR_REGISTRAR_USUARIO_NUEVA_ASESORIA;
    }

    /**
     * @return
     */
    public String irRegistrarOtraNuevaAsesoria() {
        FacesUtils.resetManagedBean("reporteOtrasAsesoriasBean");
        /*      ReporteOtrasAsesoriasBean reporteAsesoria =
               (ReporteOtrasAsesoriasBean)FacesUtils.getManagedBean("reporteOtrasAsesoriasBean");
           if (reporteAsesoria != null) {
               reporteAsesoria.setGeneroReporte(false);
               reporteAsesoria.init();
           }*/

        return BeanNavegacion.RUTA_IR_REGISTRAR_ASESORIAS_NUEVA;
    }

    public void inicializarUsuario() {
        if (registroUsuarioNuevaAsesoriaBean.getUsuario() != null)
            this.setUsuario(registroUsuarioNuevaAsesoriaBean.getUsuario());
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

}
