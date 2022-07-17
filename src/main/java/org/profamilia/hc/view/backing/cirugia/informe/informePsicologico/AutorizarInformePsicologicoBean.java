package org.profamilia.hc.view.backing.cirugia.informe.informePsicologico;

import java.util.List;

import org.apache.myfaces.component.html.ext.HtmlDataTable;


import org.profamilia.hc.model.dto.Chautoinfopsic;
import org.profamilia.hc.model.dto.Chautordescr;
import org.profamilia.hc.model.dto.Chautornota;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.autorizacion.descripcion.AprobarAclaracionDescripcionBean;
import org.profamilia.hc.view.util.FacesUtils;

public class AutorizarInformePsicologicoBean  extends BaseBean {



    private List<Chautoinfopsic> lstDescripcion;

    
    private HtmlDataTable dtDescripcionAutorizacion; 
    

    
    

    public AutorizarInformePsicologicoBean() {
    }
    
    
    public void init(){
        dtDescripcionAutorizacion = new HtmlDataTable();
 
        inicializarAutorizacion();
    }
    
    public void inicializarAutorizacion(){
        try {
            lstDescripcion = this.serviceLocator.getCirugiaService().getSolicitudesInformePsicologicoPorAprobar();
            
            if(lstDescripcion != null && !lstDescripcion.isEmpty()){
                for(Chautoinfopsic notaAux: lstDescripcion){
                    Cpclinica clinAux = new Cpclinica(); 
                    Integer codClinica = null; 
                    if(notaAux != null){
                        codClinica = notaAux.getHaipnclinica();     
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

    public String autorizarInformePsicologico() {
        FacesUtils.resetManagedBean("aprobarInformePsicologicoBean");
        Chautoinfopsic autoriSelect = (Chautoinfopsic)dtDescripcionAutorizacion.getRowData();
        AprobarInformePsicologicoBean aprobarBean = (AprobarInformePsicologicoBean)FacesUtils.getManagedBean("aprobarInformePsicologicoBean");
        
        if(aprobarBean != null && autoriSelect!= null){
            aprobarBean.setAutorizacion(autoriSelect);
        }
        
       
        return BeanNavegacion.RUTA_APROBAR_INFORME_PSICOLOGICO;
    }


    /**
     * @return
     */
    public String volverConsulta() {
        // Add event code here...
        return null;
    }


    public void setLstDescripcion(List<Chautoinfopsic> lstDescripcion) {
        this.lstDescripcion = lstDescripcion;
    }

    public List<Chautoinfopsic> getLstDescripcion() {
        return lstDescripcion;
    }

    public void setDtDescripcionAutorizacion(HtmlDataTable dtDescripcionAutorizacion) {
        this.dtDescripcionAutorizacion = dtDescripcionAutorizacion;
    }

    public HtmlDataTable getDtDescripcionAutorizacion() {
        return dtDescripcionAutorizacion;
    }
}
