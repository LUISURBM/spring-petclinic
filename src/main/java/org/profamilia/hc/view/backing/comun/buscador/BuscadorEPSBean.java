package org.profamilia.hc.view.backing.comun.buscador;

import java.util.ArrayList;
import java.util.List;

import org.apache.myfaces.component.html.ext.HtmlDataTable;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.cirugia.consulta.ConsultarUsuarioCirugiaSinFacturaBean;
import org.profamilia.hc.view.backing.clinico.clinico.factura.ConsultarUsuarioConsultaSinFacturaBean;
import org.profamilia.hc.view.backing.sap.registro.RegistarUsuarioSapBean;
import org.profamilia.hc.view.util.FacesUtils;



public class BuscadorEPSBean extends BaseBean {

    
    
    private Cpentidadadm  eps;
    private List lstEps;
    private HtmlDataTable dtEps;
    private Cpentidadadm epsSelect;    
    private HtmlDataTable dtEpsSelec;
    private Integer beanAnterior;
    static final int ACTIVAR_DATOS_USUARIO = 0;
    static final int BEAN_USUARIO_CIRUGIA = 1;
    static final int BEAN_USUARIO_CONSULTA = 2;


    public BuscadorEPSBean() {
    }

   
    public void init() {
        eps = new Cpentidadadm();
        lstEps = new ArrayList();
        
    }

    public void consultarEps(){
        dtEps.setFirst(0);
    try{
        lstEps = 
        this.serviceLocator.getClinicoService().getEntidadEps(eps);
                
             
    } catch (ModelException e){
        e.printStackTrace();
    }
    
}
   
   public void agregarEps() {
    if (beanAnterior == null) {
       RegistarUsuarioSapBean usuaSapBean = (RegistarUsuarioSapBean)FacesUtils.getManagedBean("registarUsuarioSapBean"); 
    
       epsSelect = (Cpentidadadm)this.dtEps.getRowData();
       
       if (epsSelect != null ) {
           usuaSapBean.getItEps().setValue(epsSelect.getCeaccodigo());
           usuaSapBean.setSeleccionEps(epsSelect.getCeacnombre());
          
           usuaSapBean.getUsuario().setHuscentidadadm(epsSelect.getCeaccodigo());
           usuaSapBean.setDeshabilitarEps(true);

       }
       
       usuaSapBean.setSelectedIndex(ACTIVAR_DATOS_USUARIO);
       usuaSapBean.setRenderBuscador(false);
    } 
    if (beanAnterior == BEAN_USUARIO_CIRUGIA) {
        ConsultarUsuarioCirugiaSinFacturaBean usuarioCirugiaBean = (ConsultarUsuarioCirugiaSinFacturaBean)FacesUtils.getManagedBean("consultarUsuarioCirugiaSinFacturaBean"); 
        
        epsSelect = (Cpentidadadm)this.dtEps.getRowData();
        
        if (epsSelect != null ) {
            usuarioCirugiaBean.getItEps().setValue(epsSelect.getCeaccodigo());
            usuarioCirugiaBean.setSeleccionEps(epsSelect.getCeacnombre());
            
            usuarioCirugiaBean.getusuario().setHuscentidadadm(epsSelect.getCeaccodigo());
            usuarioCirugiaBean.setDeshabilitarEps(true);
        }
        
        usuarioCirugiaBean.setSelectedIndex(ACTIVAR_DATOS_USUARIO);
        usuarioCirugiaBean.setRenderBuscadorEPS(false);
        
    }
    
    
       if (beanAnterior == BEAN_USUARIO_CONSULTA) {
           ConsultarUsuarioConsultaSinFacturaBean usuarioCirugiaBean = (ConsultarUsuarioConsultaSinFacturaBean)FacesUtils.getManagedBean("consultarUsuarioConsultaSinFacturaBean"); 
           
           epsSelect = (Cpentidadadm)this.dtEps.getRowData();
           
           if (epsSelect != null ) {
               usuarioCirugiaBean.getItEps().setValue(epsSelect.getCeaccodigo());
               usuarioCirugiaBean.setSeleccionEps(epsSelect.getCeacnombre());
               
               usuarioCirugiaBean.getusuario().setHuscentidadadm(epsSelect.getCeaccodigo());
               usuarioCirugiaBean.setDeshabilitarEps(true);
           }
           
           usuarioCirugiaBean.setSelectedIndex(ACTIVAR_DATOS_USUARIO);
           usuarioCirugiaBean.setRenderBuscadorEPS(false);
           
       }
       
   }
   
   
   
  
  /**
   * @param eps
   */
  public void setEps(Cpentidadadm eps){
      this.eps = eps;
  }
  
    
/**
 * @return 
 */
   
   public Cpentidadadm getEps(){
       return eps;
   }
   
    /**
     * @param lstEps
     */
     public void setLstEps(List lstEps){
         this.lstEps = lstEps;
     }
    
/**
 * @return
 */
    public List getLstEps(){
        return lstEps;
    }

    /**
     * @param dtEps
     */
     public void setDtEps(HtmlDataTable dtEps) {
         this.dtEps = dtEps;
     }

    
    
    /**
     * @return
     */
    public HtmlDataTable getDtEps(){
        return dtEps;
    }
    

  
    /**
     * @param dtEpsSelec
     */
     public void setDtEpsSelec(HtmlDataTable dtEpsSelec){
         this.dtEpsSelec = dtEpsSelec;
     }

 
    
    /**
     * @return
     */
     public HtmlDataTable getDtEpsSelec(){
         return dtEpsSelec;
     }
    

   
    
    
    /**
     * @param epsSelect
     */
     public void setEpsSelect (Cpentidadadm epsSelect){
         this.epsSelect = epsSelect;
     }
    

   
    /**
     * @return
     */
     public Cpentidadadm getEpsSelect(){
         return epsSelect;
     }

    public void setBeanAnterior(Integer beanAnterior) {
        this.beanAnterior = beanAnterior;
    }

    public Integer getBeanAnterior() {
        return beanAnterior;
    }
}
