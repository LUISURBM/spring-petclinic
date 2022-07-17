package org.profamilia.hc.view.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


public class CreaSapValidator implements Validator {

    public void validate(FacesContext facesContext, UIComponent component, 
                         Object object) throws ValidatorException {

        String invalidChars = "_|";

        for (int i = 0; i < invalidChars.length(); i++) {
            char c = invalidChars.charAt(i);
            if (object.toString().indexOf(c) != -1) {

                FacesMessage facesMessage = 
                    new FacesMessage("Se encontr� un caracter Invalido(| _).");
                throw new ValidatorException(facesMessage);

            }
        }

    }
}
