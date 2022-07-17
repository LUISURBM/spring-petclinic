package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chpamecindic implements Serializable {

    /** identifier field */
    private ChpamecindicPK id;

    /** persistent field */
    private String hpicdescripcio;

    /** nullable persistent field */
    private String hpicestado;

    /** nullable persistent field */
    private Date hpidfecregistr;

    /** nullable persistent field */
    private String hpicoperador;

    /** nullable persistent field */
    private Integer version;
    
    /** nullable persistent field */
     private Boolean renderIndicador;
    
    
    public Chpamecindic(){
        id = new ChpamecindicPK (); 
    }


    /**
     * @param id
     */
    public void setId(ChpamecindicPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChpamecindicPK getId() {
        return id;
    }

    /**
     * @param hpicdescripcio
     */
    public void setHpicdescripcio(String hpicdescripcio) {
        this.hpicdescripcio = hpicdescripcio;
    }

    /**
     * @return
     */
    public String getHpicdescripcio() {
        return hpicdescripcio;
    }

    /**
     * @param hpicestado
     */
    public void setHpicestado(String hpicestado) {
        this.hpicestado = hpicestado;
    }

    /**
     * @return
     */
    public String getHpicestado() {
        return hpicestado;
    }

    /**
     * @param hpidfecregistr
     */
    public void setHpidfecregistr(Date hpidfecregistr) {
        this.hpidfecregistr = hpidfecregistr;
    }

    /**
     * @return
     */
    public Date getHpidfecregistr() {
        return hpidfecregistr;
    }

    /**
     * @param hpicoperador
     */
    public void setHpicoperador(String hpicoperador) {
        this.hpicoperador = hpicoperador;
    }

    /**
     * @return
     */
    public String getHpicoperador() {
        return hpicoperador;
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
     * @param renderIndicador
     */
    public void setRenderIndicador(Boolean renderIndicador) {
        this.renderIndicador = renderIndicador;
    }

    /**
     * @return
     */
    public Boolean getRenderIndicador() {
        return renderIndicador;
    }
}
