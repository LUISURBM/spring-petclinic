package org.profamilia.hc.view.validator;

import java.math.BigDecimal;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


public class RangoTiempoMetodo implements Validator {

    public void validate(FacesContext facesContext, UIComponent component, 
                         Object object) throws ValidatorException {

        if (object instanceof BigDecimal) {
            BigDecimal annos = (BigDecimal)object;
            if (annos.intValue() < 0  || annos.intValue() >= 100) {
                FacesMessage facesMessage = 
                    new FacesMessage("Error el tiempo de uso es incorrecto");
                throw new ValidatorException(facesMessage);
            }

        }

    }
}
