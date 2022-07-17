package org.profamilia.hc.model.dto;

import java.util.Date;


/** @author Nlis */
public class Cpmunidane implements java.io.Serializable {

    private CpmunidaneId id;
    private String cmdcnomdpt;
    private String cmdcnommun;
    private Date cmddfecreg;
    private String cmdcusuar;
    private String cmdcdane;

    private Integer version;

    /**
     * @return the version
     */
    public final Integer getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public final void setVersion(Integer version) {
        this.version = version;
    }
    // Constructors

    /** default constructor */
    public Cpmunidane() {
    }

    /** constructor with id */
    public
    // HS == CpmunidaneId


    Cpmunidane(CpmunidaneId id) {
        this.id = id;
    }

    // HS SEPARADOR CONSTRUCTOR


    // Property accessors


    public CpmunidaneId getId() {
        return this.id;
    }

    public void setId(CpmunidaneId id) {
        this.id = id;
    }


    public String getCmdcnomdpt() {
        return this.cmdcnomdpt;
    }

    public void setCmdcnomdpt(String cmdcnomdpt) {
        this.cmdcnomdpt = cmdcnomdpt;
    }


    public String getCmdcnommun() {
        return this.cmdcnommun;
    }

    public void setCmdcnommun(String cmdcnommun) {
        this.cmdcnommun = cmdcnommun;
    }


    public Date getCmddfecreg() {
        return this.cmddfecreg;
    }

    public void setCmddfecreg(Date cmddfecreg) {
        this.cmddfecreg = cmddfecreg;
    }


    public String getCmdcusuar() {
        return this.cmdcusuar;
    }

    public void setCmdcusuar(String cmdcusuar) {
        this.cmdcusuar = cmdcusuar;
    }


    public Integer getCmdncoddep() {
        if (this.id == null) {
            return null;
        }
        return this.id.getCmdncoddep();
    }

    public void setCmdncoddep(Integer cmdncoddep) {
        if (this.id == null) {
            this.id = new CpmunidaneId();
        }
        this.id.setCmdncoddep(cmdncoddep);
    }

    public Integer getCmdncodmun() {
        if (this.id == null) {
            return null;
        }
        return this.id.getCmdncodmun();
    }

    public void setCmdncodmun(Integer cmdncodmun) {
        if (this.id == null) {
            this.id = new CpmunidaneId();
        }
        this.id.setCmdncodmun(cmdncodmun);
    }


    public void setCmdcdane(String cmdcdane) {
        this.cmdcdane = cmdcdane;
    }

    public String getCmdcdane() {
        return cmdcdane;
    }
}
