package org.profamilia.hc.view.backing.cirugia.informe.informePsicologico;

import java.util.Date;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;

import org.profamilia.hc.model.dto.Chautoinfopsic;
import org.profamilia.hc.model.dto.Chautornota;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.model.exceptions.NoFoundMailException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.AlertaEmail;
import org.profamilia.hc.view.util.FacesUtils;

public class AprobarInformePsicologicoBean extends BaseBean{


    private Chautoinfopsic autorizacion; 
    
    private boolean renderRechazo;
    
    private AlertaEmail email = new AlertaEmail();
    
    

    public AprobarInformePsicologicoBean() {
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
    public void setHaipcaceptsolic(ValueChangeEvent valueChangeEvent) {
        autorizacion.setHaipcaceptsolic((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        
    
    public void changeSolicitud(){
        renderRechazo = false;
        if(autorizacion != null && autorizacion.getHaipcaceptsolic()!= null && autorizacion.getHaipcaceptsolic().equals("N"))        {
            renderRechazo = true; 
        }
    }


    /**
     * @return
     */
    public String aceptar() {   
        Cpclinica infoClinica = null;
        String recipientTo ="";
        
        autorizacion.setHaipcoperarespu(userName());
        autorizacion.setHaipdfecharespu(new Date());
        if(!renderRechazo){
            autorizacion.setHaipcmotivrecha(null);
        }
        
        if("S".equals(autorizacion.getHaipcaceptsolic())){
            autorizacion.setHaipcetapa("AP");
        }else if("N".equals(autorizacion.getHaipcaceptsolic())) {
            autorizacion.setHaipcetapa("RE");
        }
        try {
         if(this.getClinica()!= null && this.getClinica().getCclncodigo()!= null ){
             infoClinica = 
                     this.serviceLocator.getClinicoService().getClinica(this.getClinica().getCclncodigo());
         }
           
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_CONSULTA);
        }
        if(infoClinica.getCclccoradm() !=null){
            recipientTo = infoClinica.getCclccoradm();
        }
        
        try {
            this.serviceLocator.getCirugiaService().aprobarAutorizacionInformePsicologico(autorizacion);
            email.sendAprobacionMailNotaAclaratoria(autorizacion,recipientTo); 
            FacesUtils.addInfoMessage(MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ADICION);
            e.printStackTrace();
        }catch (NoFoundMailException e) {
            e.getMessage();
            FacesUtils.addErrorMessage(e.getMessage());
            return BeanNavegacion.RUTA_ACTUAL;
        }
        return BeanNavegacion.RUTA_HOME;
    }


    public void setAutorizacion(Chautoinfopsic autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Chautoinfopsic getAutorizacion() {
        return autorizacion;
    }
}
