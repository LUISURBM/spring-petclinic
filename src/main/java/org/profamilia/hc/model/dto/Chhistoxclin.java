package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chhistoxclin implements Serializable {

    /** identifier field */
    private ChhistoxclinPK id;

    /** nullable persistent field */
    private Integer hhcntiphis;

    /** nullable persistent field */
    private Date hhcdfechahis;

    /** nullable persistent field */
    private String hhcelocaliza;

    /** nullable persistent field */
    private String hhccoperador;

    /** nullable persistent field */
    private Date hhcdfecregistr;

    /** nullable persistent field */
    private Long hhclnumanter;

    /** persistent field */
    private String hhceestadocli;

    /** nullable persistent field */
    private Integer version;

  

    /** default constructor */
    public Chhistoxclin() {
    }


    /**
     * @param id
     */
    public void setId(ChhistoxclinPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChhistoxclinPK getId() {
        return id;
    }

    /**
     * @param hhcntiphis
     */
    public void setHhcntiphis(Integer hhcntiphis) {
        this.hhcntiphis = hhcntiphis;
    }

    /**
     * @return
     */
    public Integer getHhcntiphis() {
        return hhcntiphis;
    }

    /**
     * @param hhcdfechahis
     */
    public void setHhcdfechahis(Date hhcdfechahis) {
        this.hhcdfechahis = hhcdfechahis;
    }

    /**
     * @return
     */
    public Date getHhcdfechahis() {
        return hhcdfechahis;
    }

    /**
     * @param hhcelocaliza
     */
    public void setHhcelocaliza(String hhcelocaliza) {
        this.hhcelocaliza = hhcelocaliza;
    }

    /**
     * @return
     */
    public String getHhcelocaliza() {
        return hhcelocaliza;
    }

    /**
     * @param hhccoperador
     */
    public void setHhccoperador(String hhccoperador) {
        this.hhccoperador = hhccoperador;
    }

    /**
     * @return
     */
    public String getHhccoperador() {
        return hhccoperador;
    }

    /**
     * @param hhcdfecregistr
     */
    public void setHhcdfecregistr(Date hhcdfecregistr) {
        this.hhcdfecregistr = hhcdfecregistr;
    }

    /**
     * @return
     */
    public Date getHhcdfecregistr() {
        return hhcdfecregistr;
    }

    /**
     * @param hhclnumanter
     */
    public void setHhclnumanter(Long hhclnumanter) {
        this.hhclnumanter = hhclnumanter;
    }

    /**
     * @return
     */
    public Long getHhclnumanter() {
        return hhclnumanter;
    }

    /**
     * @param hhceestadocli
     */
    public void setHhceestadocli(String hhceestadocli) {
        this.hhceestadocli = hhceestadocli;
    }

    /**
     * @return
     */
    public String getHhceestadocli() {
        return hhceestadocli;
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
