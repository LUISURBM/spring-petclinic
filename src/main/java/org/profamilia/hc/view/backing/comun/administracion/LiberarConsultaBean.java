package org.profamilia.hc.view.backing.comun.administracion;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;

import javax.faces.event.ValueChangeEvent;

import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;

public class LiberarConsultaBean extends BaseBean {

    private Date fechaActual; 
    
    private boolean existeConsulta; 
    
    private String msg_sin_registros; 
    
    private HtmlDataTable dtConsultas;
    
    private List<Cnconsclin> lstUsuarios; 
    
    private List<Cnconsclin> lstUsuariosSeleccionados; 

    public LiberarConsultaBean() {
    }
    
    public void init(){
        lstUsuarios = new ArrayList<Cnconsclin>();
        msg_sin_registros = IConstantes.MSG_SIN_CONSULTAR;
    }
    
    
    public void changeConsultas() {
        if (fechaActual != null && getClinica() != null) {
            try {
                this.lstUsuarios = 
                        this.serviceLocator.getClinicoService().getConsultasEnConsultorioDia(fechaActual, 
                                                                                getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    /**
     * @param valueChangeEvent
     */
    public void setFechaActual(ValueChangeEvent valueChangeEvent) {
        setFechaActual((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    

    /**
     * @param fechaActual
     */
    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    /**
     * @return
     */
    public Date getFechaActual() {
        return fechaActual;
    }

    /**
     * @param existeConsulta
     */
    public void setExisteConsulta(boolean existeConsulta) {
        this.existeConsulta = existeConsulta;
    }
    /**
     * @return
     */
    public boolean isExisteConsulta() {
        if (lstUsuarios.size() > 0) {
            existeConsulta = true;
        } else {
            existeConsulta = false;
            if (fechaActual != null) {
                String DATE_FORMAT = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                String fechaCons = sdf.format(fechaActual);
                msg_sin_registros = 
                        IConstantes.NO_EXISTEN_CONSULTAS_EN_CONSULTORIO_PARA_LA_FECHA + 
                        fechaCons;
            }
        }
        return existeConsulta;
    }
    /**
     * @param msg_sin_registros
     */
    public void setMsg_sin_registros(String msg_sin_registros) {
        this.msg_sin_registros = msg_sin_registros;
    }

    /**
     * @return
     */
    public String getMsg_sin_registros() {
        return msg_sin_registros;
    }

    /**
     * @param dtConsultas
     */
    public void setDtConsultas(HtmlDataTable dtConsultas) {
        this.dtConsultas = dtConsultas;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtConsultas() {
        return dtConsultas;
    }


    /**
     * @param lstUsuarios
     */
    public void setLstUsuarios(List<Cnconsclin> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    /**
     * @return
     */
    public List<Cnconsclin> getLstUsuarios() {
        return lstUsuarios;
    }
    
    public void changeSeleccionarTodos(){
        if(lstUsuarios!= null){
            for(Cnconsclin consultaTodas: lstUsuarios){
                consultaTodas.setSelectedRegistro(true);
            }
        }
        
    }
    
    public void changeSeleccionarNinguno(){
        if(lstUsuarios!= null){
            for(Cnconsclin consultaTodas: lstUsuarios){
                consultaTodas.setSelectedRegistro(false);
            }
        }
    }
    
    public void aceptar(){
        lstUsuariosSeleccionados = new ArrayList<Cnconsclin>();
        FacesUtils.addInfoMessage("LIBERAR CONSULTA");
        
        for(Cnconsclin consultaAux : lstUsuarios){
            if(consultaAux.isSelectedRegistro()){
                lstUsuariosSeleccionados.add(consultaAux);
            }
        }
        try {
            this.serviceLocator.getClinicoService().liberarConsultaClinica(lstUsuariosSeleccionados,userName());
            FacesUtils.addInfoMessage(MSG_ACTUALIZACION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ACTUALIZACION + e.getMessage());
        }
        
        lstUsuarios = new ArrayList<Cnconsclin>();
        fechaActual = null; 
        
    }

    public String volverConsulta() {
        return BeanNavegacion.RUTA_HOME;
    }
}
