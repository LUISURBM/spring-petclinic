package org.profamilia.hc.view.validator;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


public class RangoDiasEmbarazo implements Validator {

    public void validate(FacesContext facesContext, UIComponent component, 
                         Object object) throws ValidatorException {

        if (object instanceof java.lang.Integer) {
            Integer semana = (Integer)object;
            if (semana<= 0 || semana > 6) {
                FacesMessage facesMessage = 
                    new FacesMessage("Los d�as de embarazo esta entre 1 y 6 ");
                throw new ValidatorException(facesMessage);
            }

        }


    }
}
