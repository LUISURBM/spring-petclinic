package org.profamilia.hc.view.backing.clinico.clinico.servicio;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import org.profamilia.hc.model.dto.Chtiposerv;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;

public class RegistrarTipoServicioBean extends BaseBean{
    
    
    private Chtiposerv tipoServicio;
    
    private List<Chtiposerv> lstTipoServicio;
    
    private HtmlDataTable dtTipoServicio; 
    
    public RegistrarTipoServicioBean() {
        
    }
    
    
    public void init(){
        tipoServicio = new Chtiposerv();
        lstTipoServicio = new ArrayList<Chtiposerv>(); 
        inicializarLista();
    }
    
    
    public void inicializarLista(){
        try {
            lstTipoServicio = serviceLocator.getClinicoService().getLstTipoServicio();
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }


    /**
     * @param tipoServicio
     */
    public void setTipoServicio(Chtiposerv tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * @return
     */
    public Chtiposerv getTipoServicio() {
        return tipoServicio;
    }
    
    
    public String volver(){
        return BeanNavegacion.RUTA_HOME;
    }

    public void setLstTipoServicio(List <Chtiposerv> lstTipoServicio) {
        this.lstTipoServicio = lstTipoServicio;
    }

    public List<Chtiposerv> getLstTipoServicio() {
        return lstTipoServicio;
    }

    public void setDtTipoServicio(HtmlDataTable dtTipoServicio) {
        this.dtTipoServicio = dtTipoServicio;
    }

    public HtmlDataTable getDtTipoServicio() {
        return dtTipoServicio;
    }
    
    public void adicionarTipoServicio(){
        
        
        tipoServicio.setHtscestado(ESTADO_ACTIVO);
        tipoServicio.setHtscoperador(userName());
        tipoServicio.setHtsdfechregi(new Date());


        try {
            serviceLocator.getClinicoService().saveTipoServicio(tipoServicio);
            FacesUtils.addInfoMessage(MSG_ADICION);
            inicializarLista();
            tipoServicio = new Chtiposerv(); 
        } catch (ModelException e) {
             FacesUtils.addErrorMessage("Error " + e.getMessage());
        } catch (Exception ex) {
             FacesUtils.addErrorMessage("Error " + ex.getMessage());
        }
       
    }
    
    
    public void cambiarEstado(){
        
        
        Chtiposerv tipoServicioObject;
        
        tipoServicioObject = (Chtiposerv)dtTipoServicio.getRowData(); 
        
        if(tipoServicioObject != null){
            if(tipoServicioObject.getHtscestado().equals(ESTADO_ACTIVO)){
                tipoServicioObject.setHtscestado(ESTADO_INACTIVO);
            }else{
                tipoServicioObject.setHtscestado(ESTADO_ACTIVO);
            }
            
            
            try {
                 serviceLocator.getClinicoService().saveTipoServicio(tipoServicioObject);
                 FacesUtils.addInfoMessage(MSG_ACTUALIZACION);
                 inicializarLista();
                 tipoServicio = new Chtiposerv(); 
             } catch (ModelException e) {
                  FacesUtils.addErrorMessage("Error " + e.getMessage());
             } catch (Exception ex) {
                  FacesUtils.addErrorMessage("Error " + ex.getMessage());
             }
            
        }
        
     
       
       
    }
    
    
    
    
    public String adicionarServicio(){
    
    
        FacesUtils.resetManagedBean("asignarServicioXTipoBean");
        AsignarServicioXTipoBean asignarServicio = (AsignarServicioXTipoBean)FacesUtils.getManagedBean("asignarServicioXTipoBean");
        Chtiposerv tipoServicioObject;
   
        tipoServicioObject = (Chtiposerv)dtTipoServicio.getRowData(); 
        
        if(asignarServicio != null && tipoServicioObject != null){
            asignarServicio.setTipoServicio(tipoServicioObject);
            asignarServicio.cargarDatos();
        }
        
        return BeanNavegacion.RUTA_ASIGNAR_SERVICIO_X_TIPO; 
    }
}
