package org.profamilia.hc.view.backing.cirugia.autorizacion.notaAclaratoria;

import java.util.Date;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import org.profamilia.hc.model.dto.Chautornota;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.model.exceptions.NoFoundMailException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.AlertaEmail;
import org.profamilia.hc.view.util.FacesUtils;

public class AprobarNotaAclaratoriaBean extends BaseBean{


    private Chautornota autorizacion; 
    
    private boolean renderRechazo;
    
    private AlertaEmail email = new AlertaEmail();
    
    

    public AprobarNotaAclaratoriaBean() {
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
    public void setHancaceptsolic(ValueChangeEvent valueChangeEvent) {
        autorizacion.setHancaceptsolic((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        
    
    public void changeSolicitud(){
        renderRechazo = false;
        if(autorizacion != null && autorizacion.getHancaceptsolic()!= null && autorizacion.getHancaceptsolic().equals("N"))        {
            renderRechazo = true; 
        }
    }


    /**
     * @return
     */
    public String aceptar() {   
        Cpclinica infoClinica = null;
        String recipientTo ="";
        
        autorizacion.setHadcoperarespu(userName());
        autorizacion.setHandfecharespu(new Date());
        if(!renderRechazo){
            autorizacion.setHancmotivrecha(null);
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
            this.serviceLocator.getCirugiaService().aprobarAutorizacionNotaAclratoria(autorizacion,userName());
            email.sendAprobacionMailNotaAclaratoria(autorizacion,recipientTo); 
            FacesUtils.addInfoMessage(MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ADICION);
            e.printStackTrace();
        } catch (NoFoundMailException e) {
            e.getMessage();
            FacesUtils.addErrorMessage(e.getMessage());
            return BeanNavegacion.RUTA_ACTUAL;
        }
        return BeanNavegacion.RUTA_HOME;
    }


    public void setAutorizacion(Chautornota autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Chautornota getAutorizacion() {
        return autorizacion;
    }
}
