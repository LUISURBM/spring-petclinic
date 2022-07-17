package org.profamilia.hc.view.backing.parametros;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chpaqueester;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;

public class RegistrarPaqueteInstrumentalBean extends BaseBean{



    
    private Chpaqueester paqueteAdd;
    
    private Chpaqueester paqueteUpdate; 
    
    private List <Chpaqueester> lstPaquete; 
    
    private HtmlDataTable dtPaquete; 
    
    private List lstEstado; 

    
    
    public RegistrarPaqueteInstrumentalBean() {
    }
    
    public void init(){
        paqueteAdd = new Chpaqueester(); 
        
        try {
 
            lstPaquete = this.serviceLocator.getCirugiaService().getListaPaqueteInstrumental(); 
      
            
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }


    public String volver(){
        return BeanNavegacion.RUTA_IR_INICIO; 
    }

    public String modificarPaquete() {
        try {
             this.serviceLocator.getCirugiaService().updatePaqueteInstrumental(paqueteUpdate);
             FacesUtils.addInfoMessage(MSG_ACTUALIZACION);
         } catch (ModelException e) {
                  FacesUtils.addErrorMessage(e.getMessage()); 
       }
        return BeanNavegacion.RUTA_IR_REGISTRAR_PAQUETE_INSTRUMENTAL;
    }
    

    public String editarPaquete() {
          paqueteUpdate = (Chpaqueester)dtPaquete.getRowData();
        return BeanNavegacion.RUTA_IR_EDITAR_PAQUETE_INSTRUMENTAL;
    }
    
    
    public void eliminarPaquete() {

        Chpaqueester paqueteDelete;
        paqueteDelete = (Chpaqueester)dtPaquete.getRowData();

       try {
            this.serviceLocator.getCirugiaService().deletePaqueteInstrumental(paqueteDelete);
            lstPaquete.remove(paqueteDelete); 
            FacesUtils.addInfoMessage(MSG_ELIMINACION);
        } catch (ModelException e) {
                    FacesUtils.addErrorMessage(e.getMessage());             
        }catch (Exception ex) {
             FacesUtils.addErrorMessage("No se puede eliminar el paquete, Tiene Registro Instrumental asociadas "); 
            FacesUtils.addErrorMessage(ex.getMessage()); 
        }
        
        
    }

    public void agregarPaquete() {
      
        boolean wexito;
        wexito = true;
     
        
        if (lstPaquete == null || lstPaquete.isEmpty()) {
            lstPaquete = new ArrayList<Chpaqueester>();
        }
        

        if(wexito){

        paqueteAdd.setHpedfecregistr(new Date());
        paqueteAdd.setHpecoperador(userName());
        paqueteAdd.setHpecestado(ESTADO_ACTIVO);

        try {
            serviceLocator.getCirugiaService().savePaqueteInstrumental(paqueteAdd);
            lstPaquete = this.serviceLocator.getCirugiaService().getListaPaqueteInstrumental(); 
            FacesUtils.addInfoMessage(MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addInfoMessage(MSG_NO_ADICION);
            e.printStackTrace();
        }
        paqueteAdd = new Chpaqueester();
    }
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


    /**
     * @param paqueteAdd
     */
    public void setPaqueteAdd(Chpaqueester paqueteAdd) {
        this.paqueteAdd = paqueteAdd;
    }

    /**
     * @return
     */
    public Chpaqueester getPaqueteAdd() {
        return paqueteAdd;
    }

    /**
     * @param paqueteUpdate
     */
    public void setPaqueteUpdate(Chpaqueester paqueteUpdate) {
        this.paqueteUpdate = paqueteUpdate;
    }

    /**
     * @return
     */
    public Chpaqueester getPaqueteUpdate() {
        return paqueteUpdate;
    }

    /**
     * @param lstPaquete
     */
    public void setLstPaquete(List<Chpaqueester> lstPaquete) {
        this.lstPaquete = lstPaquete;
    }

    /**
     * @return
     */
    public List<Chpaqueester> getLstPaquete() {
        return lstPaquete;
    }

    /**
     * @param dtPaquete
     */
    public void setDtPaquete(HtmlDataTable dtPaquete) {
        this.dtPaquete = dtPaquete;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtPaquete() {
        return dtPaquete;
    }
}
