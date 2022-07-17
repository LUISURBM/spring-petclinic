package org.profamilia.hc.view.backing.cirugia.autorizacion.descripcion;

import java.util.List;

import org.apache.myfaces.component.html.ext.HtmlDataTable;

import org.profamilia.hc.model.dto.Chautordescr;
import org.profamilia.hc.model.dto.Chautorepicr;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.autorizacion.epicrisis.AprobarAclaracionEpicrisisBean;
import org.profamilia.hc.view.util.FacesUtils;

public class AutorizarAclaracionRegistrosBean  extends BaseBean {



    private List<Chautordescr> lstDescripcion;
    
    private List<Chautorepicr> lstEpicrisis; 
    
    private HtmlDataTable dtDescripcionAutorizacion; 
    
    private HtmlDataTable dtEpicrisisAutorizacion; 
    
    

    public AutorizarAclaracionRegistrosBean() {
    }
    
    
    public void init(){
        dtDescripcionAutorizacion = new HtmlDataTable();
        dtEpicrisisAutorizacion = new HtmlDataTable(); 
        inicializarAutorizacion();
    }
    
    public void inicializarAutorizacion(){
        try {
            lstDescripcion = this.serviceLocator.getCirugiaService().getSolicitudesPorAprobar(getClinica().getCclncodigo());
            lstEpicrisis= this.serviceLocator.getCirugiaService().getEpicrisisPorAprobar(getClinica().getCclncodigo());
        } catch (ModelException e) {
            e.printStackTrace();
        }
        
       
    }

    public String autorizarDescripcion() {
        FacesUtils.resetManagedBean("aprobarAclaracionDescripcionBean");
       Chautordescr autoriSelect = (Chautordescr)dtDescripcionAutorizacion.getRowData(); 
        AprobarAclaracionDescripcionBean aprobarBean = (AprobarAclaracionDescripcionBean)FacesUtils.getManagedBean("aprobarAclaracionDescripcionBean");
        
        if(aprobarBean != null && autoriSelect!= null){
            aprobarBean.setAutorizacion(autoriSelect);
        }
       
       
        return BeanNavegacion.RUTA_APROBAR_ACLARACION_DQX;
    }


    /**
     * @return
     */
    public String autorizarEpicrisis() {
        FacesUtils.resetManagedBean("aprobarAclaracionEpicrisisBean");
       Chautorepicr autoriSelect = (Chautorepicr)dtEpicrisisAutorizacion.getRowData(); 
        AprobarAclaracionEpicrisisBean aprobarBean = (AprobarAclaracionEpicrisisBean)FacesUtils.getManagedBean("aprobarAclaracionEpicrisisBean");
        
        if(aprobarBean != null && autoriSelect!= null){
            aprobarBean.setAutorizacion(autoriSelect);
        }
        return BeanNavegacion.RUTA_APROBAR_ACLARACION_EPICRISIS;
    }

    /**
     * @return
     */
    public String volverConsulta() {
        // Add event code here...
        return null;
    }

    /**
     * @param lstDescripcion
     */
    public void setLstDescripcion(List<Chautordescr> lstDescripcion) {
        this.lstDescripcion = lstDescripcion;
    }

    /**
     * @return
     */
    public List<Chautordescr> getLstDescripcion() {
        return lstDescripcion;
    }

    /**
     * @param dtDescripcionAutorizacion
     */
    public void setDtDescripcionAutorizacion(HtmlDataTable dtDescripcionAutorizacion) {
        this.dtDescripcionAutorizacion = dtDescripcionAutorizacion;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtDescripcionAutorizacion() {
        return dtDescripcionAutorizacion;
    }

    /**
     * @param lstEpicrisis
     */
    public void setLstEpicrisis(List<Chautorepicr> lstEpicrisis) {
        this.lstEpicrisis = lstEpicrisis;
    }

    /**
     * @return
     */
    public List<Chautorepicr> getLstEpicrisis() {
        return lstEpicrisis;
    }

    /**
     * @param dtEpicrisisAutorizacion
     */
    public void setDtEpicrisisAutorizacion(HtmlDataTable dtEpicrisisAutorizacion) {
        this.dtEpicrisisAutorizacion = dtEpicrisisAutorizacion;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtEpicrisisAutorizacion() {
        return dtEpicrisisAutorizacion;
    }
}
