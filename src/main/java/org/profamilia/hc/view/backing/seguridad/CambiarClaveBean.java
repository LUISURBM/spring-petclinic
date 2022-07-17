package org.profamilia.hc.view.backing.seguridad;

import org.profamilia.hc.model.exceptions.DAOException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;


/**
 * CambiarClave
 * <p>
 * La clase CambiarClaveBean es usada para el cambio de clave del usuario.
 * @version v001 05/03/2010
 * @author <a href="mailto: jwcarranza@profamilia.org.co">John Carranza</a>
 */
public class CambiarClaveBean extends BaseBean {

    private String usuarioCambio;

    private String claveAnterior;

    private String claveNueva;

    private String claveNueva1;

    public CambiarClaveBean() {
    }

    /**
     * Initializes UsuarioBean.
     * @see BaseBean#init()
     */
    protected void init() {
    }

    /**
     * Backing bean action para una regla de navegacion global.
     * @return the navigation result
     */
    public Object volverInicio() {
        return BeanNavegacion.RUTA_INGRESO;
    }


    public void changePassword() {

        if (!claveNueva.equalsIgnoreCase(claveNueva1)) {
            FacesUtils.addErrorMessage(MSG_CLAVES);
        } else {

            try {
                this.serviceLocator.getClinicoService().changePassword(usuarioCambio, 
                                                                       claveAnterior, 
                                                                       claveNueva);
                FacesUtils.addInfoMessage(MSG_CLAVE_CAMBIADA);

            } catch (DAOException de) {
                FacesUtils.addErrorMessage(null, de.getMessage(), 
                                           MSG_CLAVE_NO_CAMBIADA);
            } catch (Exception e) {
                FacesUtils.addErrorMessage(null, e.getMessage(), 
                                           MSG_CLAVE_NO_CAMBIADA);
            }

        }

    }


    public void setClaveAnterior(String claveAnterior) {
        this.claveAnterior = claveAnterior;
    }

    public String getClaveAnterior() {
        return claveAnterior;
    }

    public void setClaveNueva(String claveNueva) {
        this.claveNueva = claveNueva;
    }

    public String getClaveNueva() {
        return claveNueva;
    }

    public void setClaveNueva1(String claveNueva1) {
        this.claveNueva1 = claveNueva1;
    }

    public String getClaveNueva1() {
        return claveNueva1;
    }

    public void setUsuarioCambio(String usuarioCambio) {
        this.usuarioCambio = usuarioCambio;
    }

    public String getUsuarioCambio() {
        return usuarioCambio;
    }
}
