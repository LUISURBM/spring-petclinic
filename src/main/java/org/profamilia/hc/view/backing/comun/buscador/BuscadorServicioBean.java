package org.profamilia.hc.view.backing.comun.buscador;

import java.util.ArrayList;
import java.util.List;

import org.apache.myfaces.component.html.ext.HtmlDataTable;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;


public class BuscadorServicioBean extends BaseBean {

    
    
    private Cpservicio servicio;
    private List lstServicios;
    private HtmlDataTable dtServicios;
    private Cpservicio servicioSelect;    
    private HtmlDataTable dtServicioSelec;

    public BuscadorServicioBean() {
    }

   
    public void init() {
       
        
        servicio = new Cpservicio();
        lstServicios = new ArrayList();
        
    }

    public void consultarServicios(){
        dtServicios.setFirst(0);
    try{
        lstServicios = 
                this.serviceLocator.getClinicoService().getServicioSap(servicio);
                
             
    } catch (ModelException e){
        e.printStackTrace();
    }
    
}
   
   public void agregarServicio() {
       servicioSelect = (Cpservicio)this.dtServicios.getRowData();
       
   }
   
   
   
  
  /**
   * @param servicio
   */
  public void setServicio(Cpservicio servicio){
      this.servicio = servicio;
  }
  
    
/**
 * @return 
 */
   
   public Cpservicio getServicio(){
       return servicio;
   }
   
    /**
     * @param lstServicios
     */
     public void setLstServicios(List lstServicios){
         this.lstServicios = lstServicios;
     }
    
/**
 * @return
 */
    public List getLstServicios(){
        return lstServicios;
    }

    /**
     * @param dtServicios
     */
     public void setDtServicios(HtmlDataTable dtServicios) {
         this.dtServicios = dtServicios;
     }

    
    
    /**
     * @return
     */
    public HtmlDataTable getDtServicios(){
        return dtServicios;
    }
    

  
    /**
     * @param dtServicioSelec
     */
     public void setDtServicioSelec(HtmlDataTable dtServicioSelec){
         this.dtServicioSelec = dtServicioSelec;
     }

 
    
    /**
     * @return
     */
     public HtmlDataTable getDtServicioSelec(){
         return dtServicioSelec;
     }
    

   
    
    
    /**
     * @param servicioSelect
     */
     public void setServicioSelect (Cpservicio servicioSelect){
         this.servicioSelect = servicioSelect;
     }
    

   
    /**
     * @return
     */
     public Cpservicio getServicioSelect(){
         return servicioSelect;
     }


}
