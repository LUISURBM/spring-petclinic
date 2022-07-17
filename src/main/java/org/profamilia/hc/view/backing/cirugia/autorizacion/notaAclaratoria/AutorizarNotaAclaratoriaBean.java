package org.profamilia.hc.view.backing.cirugia.autorizacion.notaAclaratoria;

import java.util.List;

import org.apache.myfaces.component.html.ext.HtmlDataTable;


import org.profamilia.hc.model.dto.Chautordescr;
import org.profamilia.hc.model.dto.Chautornota;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.autorizacion.descripcion.AprobarAclaracionDescripcionBean;
import org.profamilia.hc.view.util.FacesUtils;

public class AutorizarNotaAclaratoriaBean  extends BaseBean {



    private List<Chautornota> lstDescripcion;

    
    private HtmlDataTable dtDescripcionAutorizacion; 
    

    
    

    public AutorizarNotaAclaratoriaBean() {
    }
    
    
    public void init(){
        dtDescripcionAutorizacion = new HtmlDataTable();
 
        inicializarAutorizacion();
    }
    
    public void inicializarAutorizacion(){
        try {
            lstDescripcion = this.serviceLocator.getCirugiaService().getSolicitudesNotaAclaratoriaPorAprobar();
            
            if(lstDescripcion != null && !lstDescripcion.isEmpty()){
                for(Chautornota notaAux: lstDescripcion){
                    Cpclinica clinAux = new Cpclinica(); 
                    Integer codClinica = null; 
                    if(notaAux != null){
                        codClinica = notaAux.getHannclinica();     
                    }
                    
                    
                    if(codClinica != null ){
                        clinAux = serviceLocator.getClinicoService().getClinica(codClinica);  
                        
                        if(clinAux != null){
                            notaAux.setNombreClinica(clinAux.getCclcnombre());
                        }
                    }
                    
                    
                }
            }
           
        } catch (ModelException e) {
            e.printStackTrace();
        }
        
       
    }

    public String autorizarNotaAclaratoria() {
        FacesUtils.resetManagedBean("aprobarNotaAclaratoriaBean");
        Chautornota autoriSelect = (Chautornota)dtDescripcionAutorizacion.getRowData();
        AprobarNotaAclaratoriaBean aprobarBean = (AprobarNotaAclaratoriaBean)FacesUtils.getManagedBean("aprobarNotaAclaratoriaBean");
        
        if(aprobarBean != null && autoriSelect!= null){
            aprobarBean.setAutorizacion(autoriSelect);
        }
        
       
        return BeanNavegacion.RUTA_APROBAR_NOTA_ACLARATORIA;
    }


    /**
     * @return
     */
    public String volverConsulta() {
        // Add event code here...
        return null;
    }


    public void setLstDescripcion(List<Chautornota> lstDescripcion) {
        this.lstDescripcion = lstDescripcion;
    }

    public List<Chautornota> getLstDescripcion() {
        return lstDescripcion;
    }

    public void setDtDescripcionAutorizacion(HtmlDataTable dtDescripcionAutorizacion) {
        this.dtDescripcionAutorizacion = dtDescripcionAutorizacion;
    }

    public HtmlDataTable getDtDescripcionAutorizacion() {
        return dtDescripcionAutorizacion;
    }
}
