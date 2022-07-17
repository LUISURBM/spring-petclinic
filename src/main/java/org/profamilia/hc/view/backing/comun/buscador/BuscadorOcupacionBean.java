package org.profamilia.hc.view.backing.comun.buscador;

import java.util.ArrayList;
import java.util.List;

import org.apache.myfaces.component.html.ext.HtmlDataTable;
import org.profamilia.hc.model.dto.Cpocupacio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.cirugia.consulta.ConsultarUsuarioCirugiaSinFacturaBean;
import org.profamilia.hc.view.backing.clinico.clinico.factura.ConsultarUsuarioConsultaSinFacturaBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosFertilidadBean;
import org.profamilia.hc.view.backing.sap.registro.RegistarUsuarioSapBean;
import org.profamilia.hc.view.util.FacesUtils;


public class BuscadorOcupacionBean extends BaseBean {

    
    
    private Cpocupacio  ocupacion;
    private List lstOcupacion;
    private HtmlDataTable dtOcupacion;
    private Cpocupacio ocupacionSelect;    
    private HtmlDataTable dtOcupacionSelec;
    private Integer beanAnterior;
    static final int ACTIVAR_DATOS_USUARIO = 0;
    static final int BEAN_USUARIO_CIRUGIA = 1;
    static final int BEAN_USUARIO_CONSULTA= 2;
    static final int BEAN_USUARIO_DATOS_USUARIO= 3;
    static final int BEAN_USUARIO_DATOS_FERTILIDAD= 4;
    


    public BuscadorOcupacionBean() {
    }

   
    public void init() {
       
        
        ocupacion = new Cpocupacio();
        lstOcupacion = new ArrayList();
        
    }

    public void consultarOcupacion(){
        dtOcupacion.setFirst(0);
    try{
        lstOcupacion = 
        this.serviceLocator.getClinicoService().getOcupacion(ocupacion);
                
             
    } catch (ModelException e){
        e.printStackTrace();
    }
    
}
   
   public void agregarOcupacion() {
      if (beanAnterior == null) {
           RegistarUsuarioSapBean usuariSapBean = (RegistarUsuarioSapBean)FacesUtils.getManagedBean("registarUsuarioSapBean"); 
   
           ocupacionSelect = (Cpocupacio)this.dtOcupacion.getRowData();
       
           if (ocupacionSelect != null ) {
               usuariSapBean.getItOcupacion().setValue(ocupacionSelect.getCocncodigo());
               usuariSapBean.setSeleccionOcupacion(ocupacionSelect.getCoccdescri());
          
               usuariSapBean.getUsuario().setHusnocupacion(ocupacionSelect.getCocncodigo());
               usuariSapBean.setDeshabilitarOcupacion(true);

           }
       
           usuariSapBean.setSelectedIndex(ACTIVAR_DATOS_USUARIO);
           usuariSapBean.setRenderBuscadorOcupacion(false);
      }

      if (beanAnterior == BEAN_USUARIO_CIRUGIA) {
           ConsultarUsuarioCirugiaSinFacturaBean usuarioCirugiaBean = (ConsultarUsuarioCirugiaSinFacturaBean)FacesUtils.getManagedBean("consultarUsuarioCirugiaSinFacturaBean"); 
           
           ocupacionSelect = (Cpocupacio)this.dtOcupacion.getRowData();
           
           if (ocupacionSelect != null ) {
               usuarioCirugiaBean.getItOcupacion().setValue(ocupacionSelect.getCocncodigo());
               usuarioCirugiaBean.setSeleccionOcupacion(ocupacionSelect.getCoccdescri());
               
               usuarioCirugiaBean.getusuario().setHusnocupacion(ocupacionSelect.getCocncodigo());
               usuarioCirugiaBean.setDeshabilitarOcupacion(true);
           }
           
           usuarioCirugiaBean.setSelectedIndex(ACTIVAR_DATOS_USUARIO);
           usuarioCirugiaBean.setRenderBuscadorOcupacion(false);
           
       }else if (beanAnterior == BEAN_USUARIO_CONSULTA) {
           ConsultarUsuarioConsultaSinFacturaBean usuarioCirugiaBean = (ConsultarUsuarioConsultaSinFacturaBean)FacesUtils.getManagedBean("consultarUsuarioConsultaSinFacturaBean"); 
           
           ocupacionSelect = (Cpocupacio)this.dtOcupacion.getRowData();
           
           if (ocupacionSelect != null ) {
               usuarioCirugiaBean.getItOcupacion().setValue(ocupacionSelect.getCocncodigo());
               usuarioCirugiaBean.setSeleccionOcupacion(ocupacionSelect.getCoccdescri());
               
               usuarioCirugiaBean.getusuario().setHusnocupacion(ocupacionSelect.getCocncodigo());
               usuarioCirugiaBean.setDeshabilitarOcupacion(true);
           }
           
           usuarioCirugiaBean.setSelectedIndex(ACTIVAR_DATOS_USUARIO);
           usuarioCirugiaBean.setRenderBuscadorOcupacion(false);
           
       }else if (beanAnterior == BEAN_USUARIO_DATOS_USUARIO) {
           DatosBasicosUsuarioBean usuarioBean = (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean"); 
           
           ocupacionSelect = (Cpocupacio)this.dtOcupacion.getRowData();
           
           if (ocupacionSelect != null ) {
               usuarioBean.getItOcupacion().setValue(ocupacionSelect.getCocncodigo());
               usuarioBean.setSeleccionOcupacion(ocupacionSelect.getCoccdescri());
               
               usuarioBean.getUsuario().setHusnocupacion(ocupacionSelect.getCocncodigo());
               usuarioBean.setDeshabilitarOcupacion(true);
           }
           
           usuarioBean.setSelectedIndex(ACTIVAR_DATOS_USUARIO);
           usuarioBean.setRenderBuscadorOcupacion(false);
           
       }
       
       else if (beanAnterior == BEAN_USUARIO_DATOS_FERTILIDAD) {
                  DatosFertilidadBean fertilidadBean = (DatosFertilidadBean)FacesUtils.getManagedBean("datosFertilidadBean"); 
                  
                  ocupacionSelect = (Cpocupacio)this.dtOcupacion.getRowData();
                  
                  if (ocupacionSelect != null ) {
                      fertilidadBean.getItOcupacion().setValue(ocupacionSelect.getCocncodigo());
                      fertilidadBean.setSeleccionOcupacion(ocupacionSelect.getCoccdescri());
                      
                      fertilidadBean.getFertdato().setHfdncodocupac(ocupacionSelect.getCocncodigo());
                      fertilidadBean.getFertdato().setHfdcocupac(ocupacionSelect.getCoccdescri());
                    
                  }
                  
                  fertilidadBean.setSelectedIndex(ACTIVAR_DATOS_USUARIO);
                  fertilidadBean.setRenderBuscadorOcupacion(false);
                  
              }
       
       
             
       
   }
   
   
   
  
  /**
   * @param ocupacion
   */
  public void setOcupacion(Cpocupacio ocupacion){
      this.ocupacion = ocupacion;
  }
  
    
/**
 * @return 
 */
   
   public Cpocupacio getOcupacion(){
       return ocupacion;
   }
   
    /**
     * @param lstOcupacion
     */
     public void setLstOcupacion(List lstOcupacion){
         this.lstOcupacion = lstOcupacion;
     }
    
/**
 * @return
 */
    public List getLstOcupacion(){
        return lstOcupacion;
    }

    /**
     * @param dtOcupacion
     */
     public void setDtOcupacion(HtmlDataTable dtOcupacion) {
         this.dtOcupacion = dtOcupacion;
     }

    
    
    /**
     * @return
     */
    public HtmlDataTable getDtOcupacion(){
        return dtOcupacion;
    }
    

  
    /**
     * @param dtOcupacionSelec
     */
     public void setDtOcupacionSelec(HtmlDataTable dtOcupacionSelec){
         this.dtOcupacionSelec = dtOcupacionSelec;
     }

 
    
    /**
     * @return
     */
     public HtmlDataTable getDtOcupacionSelec(){
         return dtOcupacionSelec;
     }
    

   
    
    
    /**
     * @param ocupacionSelect
     */
     public void setOcupacionSelect (Cpocupacio ocupacionSelect){
         this.ocupacionSelect = ocupacionSelect;
     }
    

   
    /**
     * @return
     */
     public Cpocupacio getOcupacionSelect(){
         return ocupacionSelect;
     }


    public void setBeanAnterior(Integer beanAnterior) {
        this.beanAnterior = beanAnterior;
    }

    public Integer getBeanAnterior() {
        return beanAnterior;
    }
}
