package org.profamilia.hc.view.backing.menus.cirugia;

import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarNotaEnfermeriaBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarResumenEnfermeriaCirugiaBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.util.FacesUtils;


public class MenuSalidaEnfermeriaBean extends BaseBean {

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private RegistrarNotaEnfermeriaBean notaEnfermeria;

    private ConsultarResumenEnfermeriaCirugiaBean resumen;


    public void init() {
        notaEnfermeria = 
                (RegistrarNotaEnfermeriaBean)FacesUtils.getManagedBean("registrarNotaEnfermeriaBean");
        resumen = 
                (ConsultarResumenEnfermeriaCirugiaBean)FacesUtils.getManagedBean("consultarResumenEnfermeriaCirugiaBean");

        if (notaEnfermeria != null && notaEnfermeria.getCirugia() != null && 
            resumen != null) {
            resumen.setCodigoCirugia(notaEnfermeria.getCirugia().getHcplnumero());
        }

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
     * @return
     */
    public String irNotasEnfermeria() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_NOTA_ENFERMERIA_INGRESO;
    }

    /**
     * @return
     */
    public String irIngresoLiquidos() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_LIQUIDOS_INGRESO_ENFERMERIA;
    }


    public void inicializarUsuario() {
        /*      if (ingreso!= null &&  ingreso.getIngreso()!= null
           && ingreso.getIngreso().getHielusuario() != null)
           this.setUsuario(ingreso.getIngreso().getHielusuario());    */
    }


    public String irSalidaEnfermeria() {
        DatosBasicosUsuarioBean datosUsuario;
        notaEnfermeria = 
                (RegistrarNotaEnfermeriaBean)FacesUtils.getManagedBean("registrarNotaEnfermeriaBean");
        resumen = 
                (ConsultarResumenEnfermeriaCirugiaBean)FacesUtils.getManagedBean("consultarResumenEnfermeriaCirugiaBean");
        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        if (notaEnfermeria != null && notaEnfermeria.getCirugia() != null && 
            notaEnfermeria.getCirugia().getHcplnumero() != null) {

            ConsultarResumenEnfermeriaCirugiaBean consultar = 
                (ConsultarResumenEnfermeriaCirugiaBean)FacesUtils.getManagedBean("consultarResumenEnfermeriaCirugiaBean");

            consultar.setCodigoCirugia(notaEnfermeria.getCirugia().getHcplnumero());
            consultar.setUsuario(notaEnfermeria.getCirugia().getHcplusuario());
            consultar.consultarResumen();

            datosUsuario.setUsuario(notaEnfermeria.getCirugia().getHcplusuario());
            datosUsuario.inicializarUsuario();

            return BeanNavegacion.RUTA_IR_SALIDA_ENFERMERIA;
        }
        FacesUtils.addErrorMessage("Error!!! Consultando Notas de Enfermeria");
        return BeanNavegacion.RUTA_ACTUAL;
    }


}
