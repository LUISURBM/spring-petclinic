package org.profamilia.hc.view.util;

import java.math.BigDecimal;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;


public class BigDecimalNumberFormatConverter implements Converter {
    public BigDecimalNumberFormatConverter() {
    }

   public Object getAsObject(FacesContext facesContext, 
                              UIComponent uiComponent, String texto) {
        BigDecimal valor;

        DecimalFormat formateador = new DecimalFormat("##,#");
        try {
            if (texto != null && !texto.equals("")) {
                valor = new BigDecimal(formateador.parse(texto).doubleValue());
                return valor;
            }
            else{
                valor=new BigDecimal(0);
                return valor;
             }
          
        } catch (Exception e) {
            FacesMessage message = new FacesMessage();
            message.setDetail("Error de formato");
            message.setSummary("Error de formato");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(message);
        }
    }

   
    public String getAsString(FacesContext facesContext, 
                              UIComponent uiComponent, Object object) {
        try {
            NumberFormat nf = NumberFormat.getInstance();
            return nf.format(object);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage();
            message.setDetail("Error de formato");
            message.setSummary("Error de formato");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(message);
        }
    }
}
