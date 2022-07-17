package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chcervaaplic implements Serializable {

    /** identifier field */
    private ChcervaaplicPK id;

    /** persistent field */
    private Integer hcacnumerdosis;

    /** nullable persistent field */
    private String hcacobservacio;

    /** persistent field */
    private Date hcadfecregistr;

    /** persistent field */
    private String hcacoperador;

    /** nullable persistent field */
    private Integer version;



    /** default constructor */
    public Chcervaaplic() {
        id = new ChcervaaplicPK();
    }


    /**
     * @param id
     */
    public void setId(ChcervaaplicPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChcervaaplicPK getId() {
        return id;
    }

    /**
     * @param hcacnumerdosis
     */
    public void setHcacnumerdosis(Integer hcacnumerdosis) {
        this.hcacnumerdosis = hcacnumerdosis;
    }

    /**
     * @return
     */
    public Integer getHcacnumerdosis() {
        return hcacnumerdosis;
    }

    /**
     * @param hcacobservacio
     */
    public void setHcacobservacio(String hcacobservacio) {
        this.hcacobservacio = hcacobservacio;
    }

    /**
     * @return
     */
    public String getHcacobservacio() {
        return hcacobservacio;
    }

    /**
     * @param hcadfecregistr
     */
    public void setHcadfecregistr(Date hcadfecregistr) {
        this.hcadfecregistr = hcadfecregistr;
    }

    /**
     * @return
     */
    public Date getHcadfecregistr() {
        return hcadfecregistr;
    }

    /**
     * @param hcacoperador
     */
    public void setHcacoperador(String hcacoperador) {
        this.hcacoperador = hcacoperador;
    }

    /**
     * @return
     */
    public String getHcacoperador() {
        return hcacoperador;
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
