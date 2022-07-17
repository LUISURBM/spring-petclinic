package org.profamilia.hc.view.backing.clinico.clinico.servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import org.profamilia.hc.model.dto.Chserxtipo;
import org.profamilia.hc.model.dto.Chtiposerv;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;

public class AsignarServicioXTipoBean extends BaseBean {


    private Chtiposerv tipoServicio;
    
    private Cpservicio servicio; 
    
    private List<Cpservicio> lstServicios; 
    
    private List<Chserxtipo> lstServiciosAsignados; 
    
    private HtmlDataTable dtServicios; 
    
    private HtmlDataTable dtServiciosAsignados; 
    


    public AsignarServicioXTipoBean() {
    }
    
    
    public void init(){
        servicio = new Cpservicio(); 
        servicio = new Cpservicio();
    }
    
    public void cargarDatos(){
       List<Chserxtipo> lstServiciosAsignadosAux = null;
       Cpservicio servAux = null; 
       
        
       
     
           lstServiciosAsignados = new ArrayList<Chserxtipo>(); 
     
       
        lstServiciosAsignadosAux = new ArrayList<Chserxtipo>();
    
        try {
            lstServiciosAsignadosAux  = serviceLocator.getClinicoService().getLstServicioXTipo(tipoServicio.getHtsncodigo());
        } catch (ModelException e) {
            e.printStackTrace();
        }
        
        if(lstServiciosAsignadosAux != null && !lstServiciosAsignadosAux.isEmpty()){
            for(Chserxtipo servXTipoAux: lstServiciosAsignadosAux){
                try {
                    servAux = serviceLocator.getClinicoService().getServicioPorId(servXTipoAux.getComp_id().getHstccodiserv());
                    
                    if(servAux != null){
                        servXTipoAux.setDescServicio(servAux.getCsvcnombre());
                    }
                    
                    lstServiciosAsignados.add(servXTipoAux);
                    
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
                
        }
        
    }

    public void setTipoServicio(Chtiposerv tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Chtiposerv getTipoServicio() {
        return tipoServicio;
    }
    
    public void setLstServiciosAsignados(List<Chserxtipo> lstServiciosAsignados) {
        this.lstServiciosAsignados = lstServiciosAsignados;
    }

    public List<Chserxtipo> getLstServiciosAsignados() {
        return lstServiciosAsignados;
    }
    
    
    
    
    public String volver(){
        FacesUtils.resetManagedBean("registrarTipoServicioBean");
        return BeanNavegacion.RUTA_IR_REGISTRAR_TIPO_SERVICIO; 
    }


    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }
    
    public void setLstServicios(List<Cpservicio> lstServicios) {
        this.lstServicios = lstServicios;
    }

    public List<Cpservicio> getLstServicios() {
        return lstServicios;
    }
    
    public void setDtServicios(HtmlDataTable dtServicios) {
        this.dtServicios = dtServicios;
    }

    public HtmlDataTable getDtServicios() {
        return dtServicios;
    }
    
    public void consultarServicios(){
        dtServicios.setFirst(0);
        try {
            lstServicios = 
                    this.serviceLocator.getClinicoService().getServiciosSalud(servicio);
        } catch (ModelException e) {
            e.printStackTrace();
        }
        
        servicio = new Cpservicio();
    }

    public Cpservicio getServicio() {
        return servicio;
    }
    
    
    public void eliminarServicio(){
        Chserxtipo servxtipoAux = new Chserxtipo();
        servxtipoAux = (Chserxtipo)dtServiciosAsignados.getRowData();
        lstServiciosAsignados.remove(servxtipoAux);


        try {
            serviceLocator.getClinicoService().deleteServicioXTipo(servxtipoAux);
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }


    public void agregarServicio() {
        Cpservicio servicioAux = (Cpservicio)dtServicios.getRowData(); 
        Chserxtipo servxtipoAux = new Chserxtipo();
        
            if(servicioAux != null && tipoServicio != null){
                servxtipoAux.getComp_id().setHstccodiserv(servicioAux.getCsvccodigo());
                servxtipoAux.getComp_id().setHstncoditipo(tipoServicio.getHtsncodigo());
                servxtipoAux.setHstcestado(ESTADO_ACTIVO);
                servxtipoAux.setHstcoperador(userName());
                servxtipoAux.setHstdfechregi(new Date());


            try {
                this.serviceLocator.getClinicoService().saveServicioXTipo(servxtipoAux);
                cargarDatos();
                FacesUtils.addInfoMessage(MSG_ADICION);
            } catch (ModelException e) {
               e.printStackTrace();
               FacesUtils.addErrorMessage("Error " + e.getMessage() );
            } catch (Exception ex) {
               ex.printStackTrace();
               FacesUtils.addErrorMessage("Error " + ex.getMessage() );
            }
        }
        
        

    }


    public void setDtServiciosAsignados(HtmlDataTable dtServiciosAsignados) {
        this.dtServiciosAsignados = dtServiciosAsignados;
    }

    public HtmlDataTable getDtServiciosAsignados() {
        return dtServiciosAsignados;
    }
}
