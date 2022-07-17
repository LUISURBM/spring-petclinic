package org.profamilia.hc.view.bundle;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.jboss.logging.Logger;


public class MessageListenerEbol implements PhaseListener {

    static final Logger log = Logger.getLogger(MessageListenerEbol.class);

    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }

    public void beforePhase(PhaseEvent e) {
        /*FacesContext fc = e.getFacesContext();
        UIViewRoot root = fc.getViewRoot();

        Iterator i = fc.getClientIdsWithMessages();
        while (i.hasNext()) {
            String clientId = (String) i.next();
            UIComponent c = root.findComponent(clientId);
            EditableValueHolder val = (EditableValueHolder)c;
            String fieldRef = (String) c.getAttributes().get("fieldRef");
            if (fieldRef != null) {
                Iterator j = fc.getMessages(clientId);
                while (j.hasNext()) {
                    FacesMessage fm = (FacesMessage) j.next();
                    fm.setDetail(fieldRef + ": " + fm.getDetail());
                }
            }
        }*/
    }

    public void afterPhase(PhaseEvent e) {
        //FacesContext fc = e.getFacesContext();
    }
}

