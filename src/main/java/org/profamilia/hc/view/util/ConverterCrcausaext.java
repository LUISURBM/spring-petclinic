package org.profamilia.hc.view.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.profamilia.hc.model.dto.Crcausaext;


public class ConverterCrcausaext implements Converter {
    public ConverterCrcausaext() {
    }

    public Object getAsObject(FacesContext arg0, UIComponent arg1, 
                              String arg2) {
        Crcausaext causa = null;
        if (arg2 != null && !arg2.equals("")) {
            causa = new Crcausaext();
            String[] valores = arg2.split(",");
            causa.setCcancodigo(Integer.valueOf(valores[0]));
            causa.setCcacdescri(valores[1]);
        }
        return causa;
    }


    public String getAsString(FacesContext arg0, UIComponent arg1, 
                              Object arg2) {
        String valor = null;

        if (arg2 != null) {
            Crcausaext causa = ((Crcausaext)arg2);
            if (causa.getCcancodigo() != null && 
                causa.getCcacdescri() != null) {
                valor = causa.getCcancodigo() + "," + causa.getCcacdescri();
            } else {
                valor = "";
            }
        } else {
            valor = "";
        }
        return valor;
    }

}
