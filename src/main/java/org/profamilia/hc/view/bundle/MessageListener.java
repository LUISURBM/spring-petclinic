package org.profamilia.hc.view.bundle;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.jboss.logging.Logger;


public class MessageListener implements PhaseListener {

    static final Logger log = Logger.getLogger(MessageListener.class);

    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }

    public void beforePhase(PhaseEvent e) {
        /*FacesContext fc = e.getFacesContext();
        UIViewRoot root = fc.getViewRoot();*/

        //Iterator i = fc.getClientIdsWithMessages();

        // UIComponent c = root.findComponent("body:formHistoriaExamenMama:panelTabAntecedentesGinecologicos:mnuNumGesta");    


    }

    public void afterPhase(PhaseEvent e) {
        //FacesContext fc = e.getFacesContext();
    }
}

