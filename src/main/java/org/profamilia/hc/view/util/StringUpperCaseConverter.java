package org.profamilia.hc.view.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;


public class StringUpperCaseConverter implements Converter {
    public StringUpperCaseConverter() {
    }

    public Object getAsObject(FacesContext context, UIComponent component, 
                              String value) throws ConverterException {

        String stringUppercase;
        try {
            stringUppercase = value.toString().toUpperCase();
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage();
            message.setDetail("Error en la conversi�n a may�scula.");
            message.setSummary("Error en la conversi�n a may�scula.");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(message);
        }
        return stringUppercase;
    }

    public String getAsString(FacesContext facesContext, 
                              UIComponent uIComponent, Object value) {
        return value.toString();
    }

}
