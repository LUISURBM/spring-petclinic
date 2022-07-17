package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chpladetrat implements Serializable {

    /** identifier field */
    private ChpladetratPK id;
    
    /** nullable persistent field */
    private Integer hptnnumersesio; 
    
    /** nullable persistent field */
    private String hptctipointer; 
    
    /** nullable persistent field */
    private String hptccompromiso; 

    /** nullable persistent field */
    private String hptcoperador;

    /** nullable persistent field */
    private Date hptdfecregistr;

    /** nullable persistent field */
    private Integer version;

   

    /** default constructor */
    public Chpladetrat() {
       id =  new ChpladetratPK();
    }


    /**
     * @param id
     */
    public void setId(ChpladetratPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChpladetratPK getId() {
        return id;
    }

    /**
     * @param hptcoperador
     */
    public void setHptcoperador(String hptcoperador) {
        this.hptcoperador = hptcoperador;
    }

    /**
     * @return
     */
    public String getHptcoperador() {
        return hptcoperador;
    }

    /**
     * @param hptdfecregistr
     */
    public void setHptdfecregistr(Date hptdfecregistr) {
        this.hptdfecregistr = hptdfecregistr;
    }

    /**
     * @return
     */
    public Date getHptdfecregistr() {
        return hptdfecregistr;
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

    public void setHptnnumersesio(Integer hptnnumersesio) {
        this.hptnnumersesio = hptnnumersesio;
    }

    public Integer getHptnnumersesio() {
        return hptnnumersesio;
    }

    public void setHptctipointer(String hptctipointer) {
        this.hptctipointer = hptctipointer;
    }

    public String getHptctipointer() {
        return hptctipointer;
    }

    public void setHptccompromiso(String hptccompromiso) {
        this.hptccompromiso = hptccompromiso;
    }

    public String getHptccompromiso() {
        return hptccompromiso;
    }
}
