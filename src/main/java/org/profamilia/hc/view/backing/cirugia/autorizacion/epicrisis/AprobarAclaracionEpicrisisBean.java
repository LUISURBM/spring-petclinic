package org.profamilia.hc.view.backing.cirugia.autorizacion.epicrisis;

import java.util.Date;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;

import org.profamilia.hc.model.dto.Chautorepicr;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;

public class AprobarAclaracionEpicrisisBean extends BaseBean {


    private Chautorepicr autorizacion;

    private boolean renderRechazo;


    public AprobarAclaracionEpicrisisBean() {
    }


    /**
     * @param autorizacion
     */
    public void setAutorizacion(Chautorepicr autorizacion) {
        this.autorizacion = autorizacion;
    }

    /**
     * @return
     */
    public Chautorepicr getAutorizacion() {
        return autorizacion;
    }


    /**
     * @return
     */
    public String volver() {
        FacesUtils.resetManagedBean("autorizarAclaracionRegistrosBean");
        return BeanNavegacion.RUTA_IR_AUTORIZAR_REGISTROS;
    }

    /**
     * @param renderRechazo
     */
    public void setRenderRechazo(boolean renderRechazo) {
        this.renderRechazo = renderRechazo;
    }

    /**
     * @return
     */
    public boolean isRenderRechazo() {
        return renderRechazo;
    }

    /**
     * @param valueChangeEvent
     */
    public void setHaecaceptsolic(ValueChangeEvent valueChangeEvent) {
        autorizacion.setHaecaceptsolic((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void changeSolicitud() {
        renderRechazo = false;
        if (autorizacion != null && autorizacion.getHaecaceptsolic() != null && 
            autorizacion.getHaecaceptsolic().equals("N")) {
            renderRechazo = true;
        }
    }


    /**
     * @return
     */
    public String aceptar() {
        FacesUtils.resetManagedBean("autorizarAclaracionRegistrosBean");

        autorizacion.setHaecoperarespu(userName());
        autorizacion.setHaedfecharespu(new Date());
        if (!renderRechazo) {
            autorizacion.setHaecmotivrecha(null);
        }

        System.out.print("");

        try {
            this.serviceLocator.getCirugiaService().aprobarAutorizacionEpicrisis(autorizacion, 
                                                                                 userName());
            FacesUtils.addInfoMessage(MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ADICION);
            e.printStackTrace();
        }
        return BeanNavegacion.RUTA_IR_AUTORIZAR_REGISTROS;
    }


}
