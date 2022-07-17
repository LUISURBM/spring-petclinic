package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Cpparentes implements Serializable {

    /** identifier field */
    private String cpancodigo;

    /** persistent field */
    private String cpacdescrip;

    /** persistent field */
    private String cpacestado;

    /** persistent field */
    private Date cpadfecreg;

    /** persistent field */
    private String cpacusuari;

    /** nullable persistent field */
    private Integer version;

    /** full constructor */
    public Cpparentes(String cpancodigo, String cpacdescrip, String cpacestado, Date cpadfecreg, String cpacusuari, Integer version) {
        this.cpancodigo = cpancodigo;
        this.cpacdescrip = cpacdescrip;
        this.cpacestado = cpacestado;
        this.cpadfecreg = cpadfecreg;
        this.cpacusuari = cpacusuari;
        this.version = version;
    }

    /** default constructor */
    public Cpparentes() {
    }

    /** minimal constructor */
    public Cpparentes(String cpancodigo, String cpacdescrip, String cpacestado, Date cpadfecreg, String cpacusuari) {
        this.cpancodigo = cpancodigo;
        this.cpacdescrip = cpacdescrip;
        this.cpacestado = cpacestado;
        this.cpadfecreg = cpadfecreg;
        this.cpacusuari = cpacusuari;
    }

    public String getCpancodigo() {
        return this.cpancodigo;
    }

    public void setCpancodigo(String cpancodigo) {
        this.cpancodigo = cpancodigo;
    }

    public String getCpacdescrip() {
        return this.cpacdescrip;
    }

    public void setCpacdescrip(String cpacdescrip) {
        this.cpacdescrip = cpacdescrip;
    }

    public String getCpacestado() {
        return this.cpacestado;
    }

    public void setCpacestado(String cpacestado) {
        this.cpacestado = cpacestado;
    }

    public Date getCpadfecreg() {
        return this.cpadfecreg;
    }

    public void setCpadfecreg(Date cpadfecreg) {
        this.cpadfecreg = cpadfecreg;
    }

    public String getCpacusuari() {
        return this.cpacusuari;
    }

    public void setCpacusuari(String cpacusuari) {
        this.cpacusuari = cpacusuari;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cpancodigo", getCpancodigo())
            .toString();
    }

}
