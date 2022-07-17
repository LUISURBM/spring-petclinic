package org.profamilia.hc.view.validator;

import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


public class DateValidatorEmbarazoCirugia implements Validator {

    public void validate(FacesContext facesContext, UIComponent component, 
                         Object object) throws ValidatorException {

        if (object instanceof java.util.Date) {
            Date fechaActual = new Date();
            Date fechaMinima = null; 
            Calendar fechaMenor = Calendar.getInstance(); 
            
            fechaMenor.add(Calendar.DAY_OF_YEAR,-3);
            fechaMinima = fechaMenor.getTime();
            System.out.println(fechaMinima + "   " + fechaActual + "   "  +fechaMenor );
            
            if (fechaActual.before((Date)object)) {
                FacesMessage facesMessage = 
                    new FacesMessage("La fecha es mayor a tres dias");
                throw new ValidatorException(facesMessage);
            }else if(fechaMinima.after((Date)object)){
                FacesMessage facesMessage = 
                    new FacesMessage("repetir la prueba de embarazo en orina y registrar con fecha de hoy");
                throw new ValidatorException(facesMessage);
            }

        }

    }
}
