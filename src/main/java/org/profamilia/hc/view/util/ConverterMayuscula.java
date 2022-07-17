package org.profamilia.hc.view.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;


public class ConverterMayuscula implements Converter {
    public ConverterMayuscula() {
    }


    /**
     * @param facesContext
     * @param uiComponent
     * @param string
     * @return
     */
    public Object getAsObject(FacesContext facesContext, 
                              UIComponent uiComponent, String string) {
                    if(string != null){
                        return string.toUpperCase();                
                    }
        return null; 
    }

    /**
     * @param facesContext
     * @param uiComponent
     * @param object
     * @return
     */
    public String getAsString(FacesContext facesContext, 
                              UIComponent uiComponent, Object object) {
        if (object != null) {
            return ((String)object).toUpperCase();
        }

        return null;

    }
}


