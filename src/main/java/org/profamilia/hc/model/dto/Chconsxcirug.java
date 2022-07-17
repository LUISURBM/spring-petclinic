package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chconsxcirug implements Serializable {

    /** identifier field */
    private ChconsxcirugPK id;

    /** persistent field */
    private Date hccdfecregistr;

    /** persistent field */
    private String hcccoperador;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chconsxcirug() {
    }


    /**
     * @param id
     */
    public void setId(ChconsxcirugPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChconsxcirugPK getId() {
        return id;
    }

    /**
     * @param hccdfecregistr
     */
    public void setHccdfecregistr(Date hccdfecregistr) {
        this.hccdfecregistr = hccdfecregistr;
    }

    /**
     * @return
     */
    public Date getHccdfecregistr() {
        return hccdfecregistr;
    }

    /**
     * @param hcccoperador
     */
    public void setHcccoperador(String hcccoperador) {
        this.hcccoperador = hcccoperador;
    }

    /**
     * @return
     */
    public String getHcccoperador() {
        return hcccoperador;
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
}
