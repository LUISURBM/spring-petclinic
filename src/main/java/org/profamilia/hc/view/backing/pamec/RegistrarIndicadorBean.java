package org.profamilia.hc.view.backing.pamec;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chpamecindic;
import org.profamilia.hc.model.dto.Chpamectema;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;

public class RegistrarIndicadorBean extends BaseBean {

    private Chpamectema temaObject; 
    
    private Chpamecindic indicadorAdd; 
       
    private Chpamecindic indicadorUpdate; 
    
    private List<Chpamecindic> lstIndicador; 
    
    private HtmlDataTable dtIndicador; 
    
    private List lstEstado; 


    public RegistrarIndicadorBean() {
    }
    
    
    public void init(){
        indicadorAdd = new Chpamecindic();
        
        try {
        if(temaObject != null && temaObject.getHptncodigo()!= null){
            lstIndicador = this.serviceLocator.getCirugiaService().getListaIndicadorPamec(temaObject.getHptncodigo()); 
        }
            
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }
    
  
    
    
    public String volverTemas(){
        FacesUtils.resetManagedBean("registrarTemaBean");
        return BeanNavegacion.RUTA_IR_REGISTRAR_TEMA_PAMEC; 
        
    }
    
    
    public String modificarIndicador() {
        try {
             this.serviceLocator.getCirugiaService().updateIndicadorPamec(indicadorUpdate);
             FacesUtils.addInfoMessage(MSG_ELIMINACION);
         } catch (ModelException e) {
                  FacesUtils.addErrorMessage(e.getMessage()); 
       }
        return BeanNavegacion.RUTA_IR_REGISTRAR_INDICADOR_PAMEC;
    }
    
    
    
    public String editarIndicador() {
          indicadorUpdate = (Chpamecindic)dtIndicador.getRowData();
        return BeanNavegacion.RUTA_IR_EDITAR_INDICADOR_PAMEC;
    }
      
      
      
    public String registrarPregunta(){
        Chpamecindic indicadorObject = null; 
        indicadorObject = (Chpamecindic)dtIndicador.getRowData(); 
    
        RegistrarPreguntaBean preguntaBean = (RegistrarPreguntaBean)FacesUtils.getManagedBean("registrarPreguntaBean"); 
        preguntaBean.setIndicadorObject(indicadorObject);
        preguntaBean.init();
    
     return BeanNavegacion.RUTA_IR_REGISTRAR_PREGUNTAS_PAMEC; 
        
    }
        
    
    
    
    
    public void eliminarIndicador() {

        Chpamecindic indicadorDelete;
        indicadorDelete = (Chpamecindic)dtIndicador.getRowData();

       try {
            this.serviceLocator.getCirugiaService().deleteIndicadorPamec(indicadorDelete);
            lstIndicador.remove(indicadorDelete); 
            FacesUtils.addInfoMessage(MSG_ELIMINACION);
        } catch (ModelException e) {
            if (e.getMessage().indexOf("ORA-02292") != -1) {
                FacesUtils.addErrorMessage("No se puede eliminar el Indicador, Tiene preguntas asociadas ");  
            }else{
                FacesUtils.addErrorMessage(e.getMessage()); 
            }
            
        }catch (Exception ex) {
             FacesUtils.addErrorMessage("No se puede eliminar el indicador, Tiene preguntas asociadas " ); 
             FacesUtils.addErrorMessage(ex.getMessage()); 
            }
        
        
    }
    
    public void agregarIndicador() {
      
        boolean wexito;
        wexito = true;
        String url = "body:infoIndicadorForm:panelTabRegistrarIndicador:"; 
        
        if (lstIndicador == null || lstIndicador.isEmpty()) {
            lstIndicador = new ArrayList<Chpamecindic>();
        }
        
        
        if(temaObject == null || temaObject.getHptncodigo() == null){
            wexito = false; 
        }

        if(indicadorAdd.getHpicdescripcio() == null || indicadorAdd.getHpicdescripcio().equals("") ){
           

            if(indicadorAdd.getHpicdescripcio() == null || indicadorAdd.getHpicdescripcio().equals("")){
                wexito = false;
                FacesUtils.addErrorMessage(url+"itDescripcionIndicador",MSG_CAMPO_OBLIGATORIO);
            }
        }

        if(wexito){

        indicadorAdd.setHpidfecregistr(new Date());
        indicadorAdd.setHpicoperador(userName());
        indicadorAdd.setHpicestado(ESTADO_ACTIVO);
        indicadorAdd.getId().setHpincodigtema(temaObject.getHptncodigo());

    
         

        try {
            serviceLocator.getCirugiaService().saveIndicador(indicadorAdd);
            lstIndicador = this.serviceLocator.getCirugiaService().getListaIndicadorPamec(temaObject.getHptncodigo()); 
            FacesUtils.addInfoMessage(MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addInfoMessage(MSG_NO_ADICION);
            e.printStackTrace();
        }
        indicadorAdd = new Chpamecindic();
    }
    }

    


    /**
     * @param temaObject
     */
    public void setTemaObject(Chpamectema temaObject) {
        this.temaObject = temaObject;
    }

    /**
     * @return
     */
    public Chpamectema getTemaObject() {
        return temaObject;
    }

   
    /**
     * @param lstIndicador
     */
    public void setLstIndicador(List<Chpamecindic> lstIndicador) {
        this.lstIndicador = lstIndicador;
    }

    /**
     * @return
     */
    public List<Chpamecindic> getLstIndicador() {
        return lstIndicador;
    }

    /**
     * @param dtIndicador
     */
    public void setDtIndicador(HtmlDataTable dtIndicador) {
        this.dtIndicador = dtIndicador;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtIndicador() {
        return dtIndicador;
    }

    /**
     * @param indicadorAdd
     */
    public void setIndicadorAdd(Chpamecindic indicadorAdd) {
        this.indicadorAdd = indicadorAdd;
    }

    /**
     * @return
     */
    public Chpamecindic getIndicadorAdd() {
        return indicadorAdd;
    }

    /**
     * @param indicadorUpdate
     */
    public void setIndicadorUpdate(Chpamecindic indicadorUpdate) {
        this.indicadorUpdate = indicadorUpdate;
    }

    /**
     * @return
     */
    public Chpamecindic getIndicadorUpdate() {
        return indicadorUpdate;
    }

    /**
     * @param lstEstado
     */
    public void setLstEstado(List lstEstado) {
        this.lstEstado = lstEstado;
    }

    /**
     * @return
     */
    public List getLstEstado() {
     if(lstEstado == null || lstEstado.isEmpty()){
         lstEstado = new ArrayList(); 
         lstEstado.add(new SelectItem("AC","Activo"));
         lstEstado.add(new SelectItem("IN","Inactivo"));
     }
        return lstEstado;
    }
}
