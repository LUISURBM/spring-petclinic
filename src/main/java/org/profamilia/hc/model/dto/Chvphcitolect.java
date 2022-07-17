package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chvphcitolect implements Serializable {

    /** identifier field */
    private Integer hvcnconsec;

    /** persistent field */
    private Integer hvcnclinic;

    /** persistent field */
    private Integer hvcnnumero;

    /** persistent field */
    private Date hvcdprilec;

    /** persistent field */
    private String hvccprilec;

    /** persistent field */
    private String hvccnompri;

    /** nullable persistent field */
    private Date hvcdseglec;

    /** nullable persistent field */
    private String hvccseglec;

    /** nullable persistent field */
    private String hvccnomseg;

    /** nullable persistent field */
    private String hvcccalmue;

    /** nullable persistent field */
    private String hvccmicorg;

    /** nullable persistent field */
    private String hvccotrmic;

    /** nullable persistent field */
    private String hvcccatego;

    /** nullable persistent field */
    private String hvccotrhal;

    /** nullable persistent field */
    private String hvccanoesc;

    /** nullable persistent field */
    private String hvccanogla;

    /** nullable persistent field */
    private String hvccotrneo;

    /** nullable persistent field */
    private String hvccobserv;

    /** persistent field */
    private String hvccusureg;

    /** nullable persistent field */
    private Date hvcdfecreg;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String hvccnumpri;

    /** nullable persistent field */
    private String hvccnumseg;

    /** full constructor */
    public Chvphcitolect(Integer hvcnconsec, Integer hvcnclinic, Integer hvcnnumero, Date hvcdprilec, String hvccprilec, String hvccnompri, Date hvcdseglec, String hvccseglec, String hvccnomseg, String hvcccalmue, String hvccmicorg, String hvccotrmic, String hvcccatego, String hvccotrhal, String hvccanoesc, String hvccanogla, String hvccotrneo, String hvccobserv, String hvccusureg, Date hvcdfecreg, Integer version, String hvccnumpri, String hvccnumseg) {
        this.hvcnconsec = hvcnconsec;
        this.hvcnclinic = hvcnclinic;
        this.hvcnnumero = hvcnnumero;
        this.hvcdprilec = hvcdprilec;
        this.hvccprilec = hvccprilec;
        this.hvccnompri = hvccnompri;
        this.hvcdseglec = hvcdseglec;
        this.hvccseglec = hvccseglec;
        this.hvccnomseg = hvccnomseg;
        this.hvcccalmue = hvcccalmue;
        this.hvccmicorg = hvccmicorg;
        this.hvccotrmic = hvccotrmic;
        this.hvcccatego = hvcccatego;
        this.hvccotrhal = hvccotrhal;
        this.hvccanoesc = hvccanoesc;
        this.hvccanogla = hvccanogla;
        this.hvccotrneo = hvccotrneo;
        this.hvccobserv = hvccobserv;
        this.hvccusureg = hvccusureg;
        this.hvcdfecreg = hvcdfecreg;
        this.version = version;
        this.hvccnumpri = hvccnumpri;
        this.hvccnumseg = hvccnumseg;
    }

    /** default constructor */
    public Chvphcitolect() {
    }

    /** minimal constructor */
    public Chvphcitolect(Integer hvcnconsec, Integer hvcnclinic, Integer hvcnnumero, Date hvcdprilec, String hvccprilec, String hvccnompri, String hvccusureg) {
        this.hvcnconsec = hvcnconsec;
        this.hvcnclinic = hvcnclinic;
        this.hvcnnumero = hvcnnumero;
        this.hvcdprilec = hvcdprilec;
        this.hvccprilec = hvccprilec;
        this.hvccnompri = hvccnompri;
        this.hvccusureg = hvccusureg;
    }

    public Integer getHvcnconsec() {
        return this.hvcnconsec;
    }

    public void setHvcnconsec(Integer hvcnconsec) {
        this.hvcnconsec = hvcnconsec;
    }

    public Integer getHvcnclinic() {
        return this.hvcnclinic;
    }

    public void setHvcnclinic(Integer hvcnclinic) {
        this.hvcnclinic = hvcnclinic;
    }

    public Integer getHvcnnumero() {
        return this.hvcnnumero;
    }

    public void setHvcnnumero(Integer hvcnnumero) {
        this.hvcnnumero = hvcnnumero;
    }

    public Date getHvcdprilec() {
        return this.hvcdprilec;
    }

    public void setHvcdprilec(Date hvcdprilec) {
        this.hvcdprilec = hvcdprilec;
    }

    public String getHvccprilec() {
        return this.hvccprilec;
    }

    public void setHvccprilec(String hvccprilec) {
        this.hvccprilec = hvccprilec;
    }

    public String getHvccnompri() {
        return this.hvccnompri;
    }

    public void setHvccnompri(String hvccnompri) {
        this.hvccnompri = hvccnompri;
    }

    public Date getHvcdseglec() {
        return this.hvcdseglec;
    }

    public void setHvcdseglec(Date hvcdseglec) {
        this.hvcdseglec = hvcdseglec;
    }

    public String getHvccseglec() {
        return this.hvccseglec;
    }

    public void setHvccseglec(String hvccseglec) {
        this.hvccseglec = hvccseglec;
    }

    public String getHvccnomseg() {
        return this.hvccnomseg;
    }

    public void setHvccnomseg(String hvccnomseg) {
        this.hvccnomseg = hvccnomseg;
    }

    public String getHvcccalmue() {
        return this.hvcccalmue;
    }

    public void setHvcccalmue(String hvcccalmue) {
        this.hvcccalmue = hvcccalmue;
    }

    public String getHvccmicorg() {
        return this.hvccmicorg;
    }

    public void setHvccmicorg(String hvccmicorg) {
        this.hvccmicorg = hvccmicorg;
    }

    public String getHvccotrmic() {
        return this.hvccotrmic;
    }

    public void setHvccotrmic(String hvccotrmic) {
        this.hvccotrmic = hvccotrmic;
    }

    public String getHvcccatego() {
        return this.hvcccatego;
    }

    public void setHvcccatego(String hvcccatego) {
        this.hvcccatego = hvcccatego;
    }

    public String getHvccotrhal() {
        return this.hvccotrhal;
    }

    public void setHvccotrhal(String hvccotrhal) {
        this.hvccotrhal = hvccotrhal;
    }

    public String getHvccanoesc() {
        return this.hvccanoesc;
    }

    public void setHvccanoesc(String hvccanoesc) {
        this.hvccanoesc = hvccanoesc;
    }

    public String getHvccanogla() {
        return this.hvccanogla;
    }

    public void setHvccanogla(String hvccanogla) {
        this.hvccanogla = hvccanogla;
    }

    public String getHvccotrneo() {
        return this.hvccotrneo;
    }

    public void setHvccotrneo(String hvccotrneo) {
        this.hvccotrneo = hvccotrneo;
    }

    public String getHvccobserv() {
        return this.hvccobserv;
    }

    public void setHvccobserv(String hvccobserv) {
        this.hvccobserv = hvccobserv;
    }

    public String getHvccusureg() {
        return this.hvccusureg;
    }

    public void setHvccusureg(String hvccusureg) {
        this.hvccusureg = hvccusureg;
    }

    public Date getHvcdfecreg() {
        return this.hvcdfecreg;
    }

    public void setHvcdfecreg(Date hvcdfecreg) {
        this.hvcdfecreg = hvcdfecreg;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getHvccnumpri() {
        return this.hvccnumpri;
    }

    public void setHvccnumpri(String hvccnumpri) {
        this.hvccnumpri = hvccnumpri;
    }

    public String getHvccnumseg() {
        return this.hvccnumseg;
    }

    public void setHvccnumseg(String hvccnumseg) {
        this.hvccnumseg = hvccnumseg;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hvcnconsec", getHvcnconsec())
            .toString();
    }

}
