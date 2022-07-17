package org.profamilia.hc.view.backing.cirugia.autorizacion.descripcion;

import java.util.Date;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;

import org.profamilia.hc.model.dto.Chautordescr;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;

public class AprobarAclaracionDescripcionBean extends BaseBean{


    private Chautordescr autorizacion; 
    
    private boolean renderRechazo; 
    
    

    public AprobarAclaracionDescripcionBean() {
    }

    

    /**
     * @param autorizacion
     */
    public void setAutorizacion(Chautordescr autorizacion) {
        this.autorizacion = autorizacion;
    }

    /**
     * @return
     */
    public Chautordescr getAutorizacion() {
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
    public void setHadcaceptsolic(ValueChangeEvent valueChangeEvent) {
        autorizacion.setHadcaceptsolic((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        
    
    public void changeSolicitud(){
        renderRechazo = false;
        if(autorizacion != null && autorizacion.getHadcaceptsolic()!= null && autorizacion.getHadcaceptsolic().equals("N"))        {
            renderRechazo = true; 
        }
    }


    /**
     * @return
     */
    public String aceptar() {   
        FacesUtils.resetManagedBean("autorizarAclaracionRegistrosBean");
        
        autorizacion.setHadcoperarespu(userName());
        autorizacion.setHaddfecharespu(new Date());
        if(!renderRechazo){
            autorizacion.setHadcmotivrecha(null);
        }
        
        System.out.print("");
        
        try {
            this.serviceLocator.getCirugiaService().aprobarAutorizacionDescripcion(autorizacion,userName());
            FacesUtils.addInfoMessage(MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ADICION);
            e.printStackTrace();
        }
        return BeanNavegacion.RUTA_IR_AUTORIZAR_REGISTROS;
    }
}
