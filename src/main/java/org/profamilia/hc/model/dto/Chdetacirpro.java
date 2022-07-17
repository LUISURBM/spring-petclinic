package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;

/** @author Hibernate CodeGenerator */
public class Chdetacirpro implements Serializable {

    /** identifier field */
    private ChdetacirproPK id;

    /** persistent field */
    private Date hdcdfecharegis;

    /** persistent field */
    private String hdccoperaregis;
    
    /** persistent field */
    private BigDecimal hdcnmedicatien; 
    
    /** persistent field */
    private Long hdclusuario; 
    
    /** identifier field */
    private Long hdclconsuasoci;

    /** nullable persistent field */
    private Date hdcdfechamodif;

    /** nullable persistent field */
    private String hdccoperamodif;

    /** persistent field */
    private String hdccestado;

    /** persistent field */
    private Integer hdcnclinica;
    
    /** persistent field */
    private String hdccdescrservi;

    /** nullable persistent field */
    private Integer version;
    
    /** **/
    private boolean seleccionado; 
    
    
    /** nullable persistent field */
    private boolean renderEliminar;
    
    /** nullable persistent field */
   private String  hdccdescrquiru; 
    
    /** nullable persistent field */
    private Integer hdcnconsedescr; 
    
    /** Campo que deshabilita la descripci�n quirurgica, si ya realizo la misma */
    private boolean modoConsulta; 
    
    private String nombreServicios;
    
    private UIInput checkSeleccion;
    
    private boolean renderAnatomia;




    /** default constructor */
    public Chdetacirpro() {
        id = new ChdetacirproPK(); 
    }


    /**
     * @param id
     */
    public void setId(ChdetacirproPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChdetacirproPK getId() {
        return id;
    }

    /**
     * @param hdcdfecharegis
     */
    public void setHdcdfecharegis(Date hdcdfecharegis) {
        this.hdcdfecharegis = hdcdfecharegis;
    }

    /**
     * @return
     */
    public Date getHdcdfecharegis() {
        return hdcdfecharegis;
    }

    /**
     * @param hdccoperaregis
     */
    public void setHdccoperaregis(String hdccoperaregis) {
        this.hdccoperaregis = hdccoperaregis;
    }

    /**
     * @return
     */
    public String getHdccoperaregis() {
        return hdccoperaregis;
    }

    /**
     * @param hdcnmedicatien
     */
    public void setHdcnmedicatien(BigDecimal hdcnmedicatien) {
        this.hdcnmedicatien = hdcnmedicatien;
    }

    /**
     * @return
     */
    public BigDecimal getHdcnmedicatien() {
        return hdcnmedicatien;
    }

    /**
     * @param hdclusuario
     */
    public void setHdclusuario(Long hdclusuario) {
        this.hdclusuario = hdclusuario;
    }

    /**
     * @return
     */
    public Long getHdclusuario() {
        return hdclusuario;
    }


    /**
     * @param hdcdfechamodif
     */
    public void setHdcdfechamodif(Date hdcdfechamodif) {
        this.hdcdfechamodif = hdcdfechamodif;
    }

    /**
     * @return
     */
    public Date getHdcdfechamodif() {
        return hdcdfechamodif;
    }

    /**
     * @param hdccoperamodif
     */
    public void setHdccoperamodif(String hdccoperamodif) {
        this.hdccoperamodif = hdccoperamodif;
    }

    /**
     * @return
     */
    public String getHdccoperamodif() {
        return hdccoperamodif;
    }

    /**
     * @param hdccestado
     */
    public void setHdccestado(String hdccestado) {
        this.hdccestado = hdccestado;
    }

    /**
     * @return
     */
    public String getHdccestado() {
        return hdccestado;
    }

    /**
     * @param hdcnclinica
     */
    public void setHdcnclinica(Integer hdcnclinica) {
        this.hdcnclinica = hdcnclinica;
    }

    /**
     * @return
     */
    public Integer getHdcnclinica() {
        return hdcnclinica;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param hdclconsuasoci
     */
    public void setHdclconsuasoci(Long hdclconsuasoci) {
        this.hdclconsuasoci = hdclconsuasoci;
    }

    /**
     * @return
     */
    public Long getHdclconsuasoci() {
        return hdclconsuasoci;
    }

    /**
     * @param hdccdescrservi
     */
    public void setHdccdescrservi(String hdccdescrservi) {
        this.hdccdescrservi = hdccdescrservi;
    }

    /**
     * @return
     */
    public String getHdccdescrservi() {
        return hdccdescrservi;
    }

    /**
     * @param renderEliminar
     */
    public void setRenderEliminar(boolean renderEliminar) {
        this.renderEliminar = renderEliminar;
    }

    /**
     * @return
     */
    public boolean isRenderEliminar() {
    if(id!= null && getId().getHdclconsuprinc() != null){
        renderEliminar = false; 
    }else{
        renderEliminar = true; 
    }
        return renderEliminar;
    }

    /**
     * @param seleccionado
     */
    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    /**
     * @param valueChangeEvent
     */
    public void setSeleccionado(ValueChangeEvent valueChangeEvent){
        setSeleccionado((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @return
     */
    public boolean isSeleccionado() {
   
        return seleccionado;
    }

    /**
     * @param hdccdescrquiru
     */
    public void setHdccdescrquiru(String hdccdescrquiru) {
        this.hdccdescrquiru = hdccdescrquiru;
    }

    /**
     * @return
     */
    public String getHdccdescrquiru() {
        return hdccdescrquiru;
    }



    /**
     * @param hdcnconsedescr
     */
    public void setHdcnconsedescr(Integer hdcnconsedescr) {
        this.hdcnconsedescr = hdcnconsedescr;
    }

    /**
     * @return
     */
    public Integer getHdcnconsedescr() {
        return hdcnconsedescr;
    }

    /**
     * @param modoConsulta
     */
    public void setModoConsulta(boolean modoConsulta) {
        this.modoConsulta = modoConsulta;
    }

    /**
     * @return
     */
    public boolean isModoConsulta() {
        modoConsulta = false; 
        if(hdccdescrquiru != null && hdccdescrquiru.equals("S")){
            modoConsulta = true; 
        }
        return modoConsulta;
    }

    public void setNombreServicios(String nombreServicios) {
        this.nombreServicios = nombreServicios;
    }

    public String getNombreServicios() {
        return nombreServicios;
    }

    public void setCheckSeleccion(UIInput checkSeleccion) {
        this.checkSeleccion = checkSeleccion;
    }

    public UIInput getCheckSeleccion() {
        return checkSeleccion;
    }

    public void setRenderAnatomia(boolean renderAnatomia) {
        this.renderAnatomia = renderAnatomia;
    }

    public boolean isRenderAnatomia() {
        return renderAnatomia;
    }
}
