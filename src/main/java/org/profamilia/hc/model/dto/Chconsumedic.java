package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chconsumedic implements Serializable {

    /** identifier field */
    private ChconsumedicPK id;

    /** persistent field */
    private Integer hcmnnumersala;

    /** persistent field */
    private Date hcmdfecregistr;

    /** persistent field */
    private String hcmcoperador;

    /** nullable persistent field */
    private Integer version;

    /** default constructor */
    public Chconsumedic() {
    }


    /**
     * @param id
     */
    public void setId(ChconsumedicPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChconsumedicPK getId() {
        return id;
    }

    /**
     * @param hcmnnumersala
     */
    public void setHcmnnumersala(Integer hcmnnumersala) {
        this.hcmnnumersala = hcmnnumersala;
    }

    /**
     * @return
     */
    public Integer getHcmnnumersala() {
        return hcmnnumersala;
    }

    /**
     * @param hcmdfecregistr
     */
    public void setHcmdfecregistr(Date hcmdfecregistr) {
        this.hcmdfecregistr = hcmdfecregistr;
    }

    /**
     * @return
     */
    public Date getHcmdfecregistr() {
        return hcmdfecregistr;
    }

    /**
     * @param hcmcoperador
     */
    public void setHcmcoperador(String hcmcoperador) {
        this.hcmcoperador = hcmcoperador;
    }

    /**
     * @return
     */
    public String getHcmcoperador() {
        return hcmcoperador;
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
