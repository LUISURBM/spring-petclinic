package org.profamilia.hc.view.validator;

import java.math.BigDecimal;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


public class RangoSemanaEmbarazo implements Validator {

    public void validate(FacesContext facesContext, UIComponent component, 
                         Object object) throws ValidatorException {

        if (object instanceof java.lang.Integer) {
            Integer semana = (Integer)object;
            if (semana< 0 || semana > 40) {
                FacesMessage facesMessage = 
                    new FacesMessage("La Semana de Embarazo debe estar entre 0 y 40 ");
                throw new ValidatorException(facesMessage);
            }

        }
        
        
        if (object instanceof BigDecimal) {
            BigDecimal semana = (BigDecimal)object;
            if (semana.intValue()< 0 || semana.intValue() > 40) {
                FacesMessage facesMessage = 
                    new FacesMessage("La Semana de Embarazo debe estar entre 0 y 40 ");
                throw new ValidatorException(facesMessage);
            }

        }

    }
}
