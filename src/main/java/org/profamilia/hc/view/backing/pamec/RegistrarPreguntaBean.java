package org.profamilia.hc.view.backing.pamec;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chpamecindic;
import org.profamilia.hc.model.dto.Chpamecpregu;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;

public class RegistrarPreguntaBean extends BaseBean{


    private Chpamecindic indicadorObject; 
    
    private Chpamecpregu preguntaAdd;
    
    private Chpamecpregu preguntaUpdate; 
    
    private List <Chpamecpregu> lstPregunta; 
    
    private HtmlDataTable dtPregunta; 
    
    private List lstEstado; 

    
    
    public RegistrarPreguntaBean() {
    }
    
    public void init(){
        preguntaAdd = new Chpamecpregu(); 
        
        try {
        if(indicadorObject != null && indicadorObject.getId()!= null && indicadorObject.getId().getHpincodigtema() != null
        && indicadorObject.getId().getHpincodigo() != null){
            lstPregunta = this.serviceLocator.getCirugiaService().getListaPreguntaPamec(indicadorObject.getId().getHpincodigtema(),indicadorObject.getId().getHpincodigo()); 
        }
            
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }


    public String volverIndicadores(){
        return BeanNavegacion.RUTA_IR_REGISTRAR_INDICADOR_PAMEC; 
    }

    public String modificarPregunta() {
        try {
             this.serviceLocator.getCirugiaService().updatePreguntaPamec(preguntaUpdate);
             FacesUtils.addInfoMessage(MSG_ELIMINACION);
         } catch (ModelException e) {
                  FacesUtils.addErrorMessage(e.getMessage()); 
       }
        return BeanNavegacion.RUTA_IR_REGISTRAR_PREGUNTAS_PAMEC;
    }
    

    public String editarPregunta() {
          preguntaUpdate = (Chpamecpregu)dtPregunta.getRowData();
        return BeanNavegacion.RUTA_IR_EDITAR_PREGUNTA_PAMEC;
    }
    
    
    public void eliminarPregunta() {

        Chpamecpregu preguntaDelete;
        preguntaDelete = (Chpamecpregu)dtPregunta.getRowData();

       try {
            this.serviceLocator.getCirugiaService().deletePreguntaPamec(preguntaDelete);
            lstPregunta.remove(preguntaDelete); 
            FacesUtils.addInfoMessage(MSG_ELIMINACION);
        } catch (ModelException e) {
                    FacesUtils.addErrorMessage(e.getMessage());             
        }catch (Exception ex) {
             FacesUtils.addErrorMessage("No se puede eliminar la pregunta, Tiene respuestas asociadas "); 
            FacesUtils.addErrorMessage(ex.getMessage()); 
        }
        
        
    }

    public void agregarPregunta() {
      
        boolean wexito;
        wexito = true;
        String url = "body:infoPreguntaForm:panelTabRegistrarPregunta:"; 
        
        if (lstPregunta == null || lstPregunta.isEmpty()) {
            lstPregunta = new ArrayList<Chpamecpregu>();
        }
        
        
        if(indicadorObject == null || indicadorObject.getId() == null ||
        indicadorObject.getId().getHpincodigo() == null || indicadorObject.getId().getHpincodigtema() == null){
            wexito = false; 
        }

        if(preguntaAdd.getHppcdescripcio() == null || preguntaAdd.getHppcdescripcio().equals("") ){
          
            if(preguntaAdd.getHppcdescripcio() == null || preguntaAdd.getHppcdescripcio().equals("")){
                wexito = false;
                FacesUtils.addErrorMessage(url+"itDescripcionPregunta",MSG_CAMPO_OBLIGATORIO);
            }
        }

        if(wexito){

        preguntaAdd.setHppdfecregistr(new Date());
        preguntaAdd.setHppcoperador(userName());
        preguntaAdd.setHppcestado(ESTADO_ACTIVO);
        preguntaAdd.getId().setHppncodigtema(indicadorObject.getId().getHpincodigtema());
        preguntaAdd.getId().setHppncodigindic(indicadorObject.getId().getHpincodigo());

    
         

        try {
            serviceLocator.getCirugiaService().savePregunta(preguntaAdd);
            lstPregunta = this.serviceLocator.getCirugiaService().getListaPreguntaPamec(indicadorObject.getId().getHpincodigtema(),indicadorObject.getId().getHpincodigo()); 
            FacesUtils.addInfoMessage(MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addInfoMessage(MSG_NO_ADICION);
            e.printStackTrace();
        }
        preguntaAdd = new Chpamecpregu();
    }
    }

   
    
  


    /**
     * @param indicadorObject
     */
    public void setIndicadorObject(Chpamecindic indicadorObject) {
        this.indicadorObject = indicadorObject;
    }

    /**
     * @return
     */
    public Chpamecindic getIndicadorObject() {
        return indicadorObject;
    }

    /**
     * @param preguntaAdd
     */
    public void setPreguntaAdd(Chpamecpregu preguntaAdd) {
        this.preguntaAdd = preguntaAdd;
    }

    /**
     * @return
     */
    public Chpamecpregu getPreguntaAdd() {
        return preguntaAdd;
    }

    /**
     * @param preguntaUpdate
     */
    public void setPreguntaUpdate(Chpamecpregu preguntaUpdate) {
        this.preguntaUpdate = preguntaUpdate;
    }

    /**
     * @return
     */
    public Chpamecpregu getPreguntaUpdate() {
        return preguntaUpdate;
    }

    /**
     * @param lstPregunta
     */
    public void setLstPregunta(List<Chpamecpregu> lstPregunta) {
        this.lstPregunta = lstPregunta;
    }

    /**
     * @return
     */
    public List<Chpamecpregu> getLstPregunta() {
        return lstPregunta;
    }

    /**
     * @param dtPregunta
     */
    public void setDtPregunta(HtmlDataTable dtPregunta) {
        this.dtPregunta = dtPregunta;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtPregunta() {
        return dtPregunta;
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
