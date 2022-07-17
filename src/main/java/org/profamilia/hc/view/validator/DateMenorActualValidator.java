package org.profamilia.hc.view.validator;

import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


public class DateMenorActualValidator implements Validator {

    public void validate(FacesContext facesContext, UIComponent component, 
                         Object object) throws ValidatorException {

        if (object instanceof java.util.Date) {
            Date fechaActual = new Date();
            Date fechaMinima = null; 
            Calendar fechaMenor = Calendar.getInstance(); 
            fechaMenor.set(Calendar.YEAR,1900);
            fechaMenor.set(Calendar.MONTH,01);
            fechaMenor.set(Calendar.DAY_OF_MONTH,01);
            fechaMinima = fechaMenor.getTime();
            
            
            if (fechaActual.before((Date)object)) {
                FacesMessage facesMessage = 
                    new FacesMessage("La fecha debe ser menor que la fecha actual");
                throw new ValidatorException(facesMessage);
            }else if(fechaMinima.after((Date)object)){
                FacesMessage facesMessage = 
                    new FacesMessage("La fecha debe ser mayor que el ano 1900");
                throw new ValidatorException(facesMessage);
            }

        }

    }
}
