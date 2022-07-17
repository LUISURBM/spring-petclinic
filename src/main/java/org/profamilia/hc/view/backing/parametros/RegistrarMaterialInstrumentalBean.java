package org.profamilia.hc.view.backing.parametros;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chmaterinstr;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;

public class RegistrarMaterialInstrumentalBean extends BaseBean{



    
    private Chmaterinstr materialAdd;
    
    private Chmaterinstr materialUpdate; 
    
    private List <Chmaterinstr> lstMaterial; 
    
    private HtmlDataTable dtMaterial; 
    
    private List lstEstado; 

    
    
    public RegistrarMaterialInstrumentalBean() {
    }
    
    public void init(){
        materialAdd = new Chmaterinstr(); 
        
        try {
 
            lstMaterial = this.serviceLocator.getCirugiaService().getListaMaterialInstrumental(); 
      
            
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }


    public String volver(){
        return BeanNavegacion.RUTA_IR_INICIO; 
    }

    public String modificarMaterial() {
        try {
             this.serviceLocator.getCirugiaService().updateMaterialInstrumental(materialUpdate);
             FacesUtils.addInfoMessage(MSG_ACTUALIZACION);
         } catch (ModelException e) {
                  FacesUtils.addErrorMessage(e.getMessage()); 
       }
        return BeanNavegacion.RUTA_IR_REGISTRAR_MATERIAL_INSTRUMENTAL;
    }
    

    public String editarMaterial() {
          materialUpdate = (Chmaterinstr)dtMaterial.getRowData();
        return BeanNavegacion.RUTA_IR_EDITAR_MATERIAL_INSTRUMENTAL;
    }
    
    
    public void eliminarMaterial() {

        Chmaterinstr materialDelete;
        materialDelete = (Chmaterinstr)dtMaterial.getRowData();

       try {
            this.serviceLocator.getCirugiaService().deleteMaterialInstrumental(materialDelete);
            lstMaterial.remove(materialDelete); 
            FacesUtils.addInfoMessage(MSG_ELIMINACION);
        } catch (ModelException e) {
                    FacesUtils.addErrorMessage(e.getMessage());             
        }catch (Exception ex) {
             FacesUtils.addErrorMessage("No se puede eliminar el material, Tiene Registro Instrumental asociadas "); 
            FacesUtils.addErrorMessage(ex.getMessage()); 
        }
        
        
    }

    public void agregarMaterial() {
      
        boolean wexito;
        wexito = true;
     
        
        if (lstMaterial == null || lstMaterial.isEmpty()) {
            lstMaterial = new ArrayList<Chmaterinstr>();
        }
        

        if(wexito){

        materialAdd.setHmidfecregistr(new Date());
        materialAdd.setHmicoperador(userName());
        materialAdd.setHmicestado(ESTADO_ACTIVO);

        try {
            serviceLocator.getCirugiaService().saveMaterialInstrumental(materialAdd);
            lstMaterial = this.serviceLocator.getCirugiaService().getListaMaterialInstrumental(); 
            FacesUtils.addInfoMessage(MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addInfoMessage(MSG_NO_ADICION);
            e.printStackTrace();
        }
        materialAdd = new Chmaterinstr();
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
     * @param dtMaterial
     */
    public void setDtMaterial(HtmlDataTable dtMaterial) {
        this.dtMaterial = dtMaterial;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtMaterial() {
        return dtMaterial;
    }

    /**
     * @param materialAdd
     */
    public void setMaterialAdd(Chmaterinstr materialAdd) {
        this.materialAdd = materialAdd;
    }

    /**
     * @return
     */
    public Chmaterinstr getMaterialAdd() {
        return materialAdd;
    }

    /**
     * @param lstMaterial
     */
    public void setLstMaterial(List<Chmaterinstr> lstMaterial) {
        this.lstMaterial = lstMaterial;
    }

    /**
     * @return
     */
    public List<Chmaterinstr> getLstMaterial() {
        return lstMaterial;
    }

    public void setMaterialUpdate(Chmaterinstr materialUpdate) {
        this.materialUpdate = materialUpdate;
    }

    public Chmaterinstr getMaterialUpdate() {
        return materialUpdate;
    }
}
