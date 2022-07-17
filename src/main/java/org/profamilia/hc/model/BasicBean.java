package org.profamilia.hc.model;
	

import org.jboss.logging.Logger;
import org.profamilia.hc.view.util.FacesUtils;


/**
 * BasicBean
 * <p>
 * La clase BasicBean es usado para implementar la clonacion de objetos.
 * 
 * @author <a href="mailto: j_carranza_s@hotmail.com">Jhon Carranza</a>
 */
public class BasicBean implements Cloneable {

    static final Logger log = Logger.getLogger(BasicBean.class);

    /**
     * Constructor por defecto.
     */
    public BasicBean() {
    }

    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException ex) {
            log.error("No se puede duplicar el objeto", ex);
            FacesUtils.addErrorMessage("No se puede duplicar el objeto");
        }
        return obj;
    }
}
