package org.profamilia.hc.view.backing.pamec;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.myfaces.component.html.ext.HtmlDataTable;

import org.profamilia.hc.model.dto.Chpamectema;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;

public class RegistrarTemaBean extends BaseBean{


    private HtmlDataTable dtTema; 
    
    private List lstTema; 
    
    private Chpamectema temaAdd; 
    
    private Chpamectema temaUpdate; 
    
    private List lstEstado; 


    public RegistrarTemaBean() {
    
      
    }
    
    public void init(){
        temaAdd = new Chpamectema(); 
        lstTema = new ArrayList(); 
        dtTema = new HtmlDataTable();
        
        try {
            lstTema = this.serviceLocator.getCirugiaService().getListaTemasPamec(); 
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    public String modificarTema() {
        try {
             this.serviceLocator.getCirugiaService().updateTemaPamec(temaUpdate);
             FacesUtils.addInfoMessage(MSG_ELIMINACION);
         } catch (ModelException e) {
                  FacesUtils.addErrorMessage(e.getMessage()); 
       }
        return BeanNavegacion.RUTA_IR_REGISTRAR_TEMA_PAMEC;
    }
    
    
    
    public String editarTema() {
          temaUpdate = (Chpamectema)dtTema.getRowData();
        return BeanNavegacion.RUTA_IR_EDITAR_TEMA_PAMEC;
    }
        
        
    
    
   
    
    public void eliminarTema() {

        Chpamectema temaDelete;
        temaDelete = (Chpamectema)dtTema.getRowData();

       try {
            this.serviceLocator.getCirugiaService().deleteTemaPamec(temaDelete);
            lstTema.remove(temaDelete); 
            FacesUtils.addInfoMessage(MSG_ELIMINACION);
        } catch (ModelException e) {
            if (e.getMessage().indexOf("ORA-02292") != -1) {
                FacesUtils.addErrorMessage("No se puede eliminar el grupo, Tiene subgrupos asociados ");  
            }else{
                FacesUtils.addErrorMessage(e.getMessage()); 
            }
            
        } catch (Exception ex) {
             FacesUtils.addErrorMessage("No se puede eliminar el tema, Tiene indicadores asociados:  " ); 
             FacesUtils.addErrorMessage(ex.getMessage()); 
            }
    }
    
    public void agregarTema() {
       Chpamectema temaObject = null;
        boolean wexito;
        wexito = true;
        String url = "body:regTemaForm:panelTabRegistrarTema:"; 
        
        if (lstTema == null || lstTema.isEmpty()) {
            lstTema = new ArrayList<Chpamectema>();
        }

        if(temaAdd.getHptcdescripcio() == null || temaAdd.getHptcdescripcio().equals("") ){
          

            if(temaAdd.getHptcdescripcio() == null || temaAdd.getHptcdescripcio().equals("")){
                wexito = false;
                FacesUtils.addErrorMessage(url+"itDescripcionTema",MSG_CAMPO_OBLIGATORIO);
            }
        }

        if(wexito){

        temaAdd.setHptdfecregistr(new Date());
        temaAdd.setHptcoperador(userName());
        temaAdd.setHptcestado(ESTADO_ACTIVO);

  
         

        try {
            serviceLocator.getCirugiaService().saveTema(temaAdd);
            lstTema = this.serviceLocator.getCirugiaService().getListaTemasPamec(); 
            FacesUtils.addInfoMessage(MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addInfoMessage(MSG_NO_ADICION);
            e.printStackTrace();
        }
        temaAdd = new Chpamectema();
    }
 }

    /**
     * @return
     */
    public String registrarIndicadores(){
        RegistrarIndicadorBean indicadorBean = (RegistrarIndicadorBean)FacesUtils.getManagedBean("registrarIndicadorBean"); 
        Chpamectema temaIndicador = null;
        temaIndicador = (Chpamectema)dtTema.getRowData(); 
        indicadorBean.setTemaObject(temaIndicador);
        indicadorBean.init();
    
        
        return BeanNavegacion.RUTA_IR_REGISTRAR_INDICADOR_PAMEC; 
    }

    /**
     * @param dtTema
     */
    public void setDtTema(HtmlDataTable dtTema) {
        this.dtTema = dtTema;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtTema() {
        return dtTema;
    }

    /**
     * @param lstTema
     */
    public void setLstTema(List lstTema) {
        this.lstTema = lstTema;
    }

    /**
     * @return
     */
    public List getLstTema() {
        return lstTema;
    }

    /**
     * @param temaAdd
     */
    public void setTemaAdd(Chpamectema temaAdd) {
        this.temaAdd = temaAdd;
    }

    /**
     * @return
     */
    public Chpamectema getTemaAdd() {
        return temaAdd;
    }

  

    /**
     * @param temaUpdate
     */
    public void setTemaUpdate(Chpamectema temaUpdate) {
        this.temaUpdate = temaUpdate;
    }

    /**
     * @return
     */
    public Chpamectema getTemaUpdate() {
        return temaUpdate;
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
