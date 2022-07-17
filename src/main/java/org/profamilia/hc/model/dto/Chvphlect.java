package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chvphlect implements Serializable {

    /** identifier field */
    private Integer hvlnconsec;

    /** persistent field */
    private Integer hvlnclinic;

    /** persistent field */
    private Integer hvlnnumero;

    /** persistent field */
    private Date hvldfeclec;

    /** persistent field */
    private String hvlclectur;

    /** persistent field */
    private String hvlcnomlec;

    /** nullable persistent field */
    private String hvlcobserv;

    /** persistent field */
    private String hvlcusureg;

    /** nullable persistent field */
    private Date hvldfecreg;

    /** nullable persistent field */
    private String hvlcnumtar;

    /** nullable persistent field */
    private String hvlcgenoneg;

    /** nullable persistent field */
    private String hvlcgt16;

    /** nullable persistent field */
    private String hvlcgt18;

    /** nullable persistent field */
    private String hvlcgt31;

    /** nullable persistent field */
    private String hvlcgt45;

    /** nullable persistent field */
    private String hvlcgt51;

    /** nullable persistent field */
    private String hvlcgt52;

    /** nullable persistent field */
    private String hvlcgt3858;

    /** nullable persistent field */
    private String hvlcgt353968;

    /** nullable persistent field */
    private String hvlcgt565966;

    /** nullable persistent field */
    private String hvlcconduc;
    
    /** nullable persistent field */
    private Integer version;

    /** full constructor */
    public Chvphlect(Integer hvlnconsec, Integer hvlnclinic, Integer hvlnnumero, Date hvldfeclec, String hvlclectur, String hvlcnomlec, String hvlcobserv, String hvlcusureg, Date hvldfecreg, String hvlcnumtar, Integer version) {
        this.hvlnconsec = hvlnconsec;
        this.hvlnclinic = hvlnclinic;
        this.hvlnnumero = hvlnnumero;
        this.hvldfeclec = hvldfeclec;
        this.hvlclectur = hvlclectur;
        this.hvlcnomlec = hvlcnomlec;
        this.hvlcobserv = hvlcobserv;
        this.hvlcusureg = hvlcusureg;
        this.hvldfecreg = hvldfecreg;
        this.hvlcnumtar = hvlcnumtar;
        this.version = version;
    }

    /** default constructor */
    public Chvphlect() {
    }

    /** minimal constructor */
    public Chvphlect(Integer hvlnconsec, Integer hvlnclinic, Integer hvlnnumero, Date hvldfeclec, String hvlclectur, String hvlcnomlec, String hvlcusureg) {
        this.hvlnconsec = hvlnconsec;
        this.hvlnclinic = hvlnclinic;
        this.hvlnnumero = hvlnnumero;
        this.hvldfeclec = hvldfeclec;
        this.hvlclectur = hvlclectur;
        this.hvlcnomlec = hvlcnomlec;
        this.hvlcusureg = hvlcusureg;
    }

    public Integer getHvlnconsec() {
        return this.hvlnconsec;
    }

    public void setHvlnconsec(Integer hvlnconsec) {
        this.hvlnconsec = hvlnconsec;
    }

    public Integer getHvlnclinic() {
        return this.hvlnclinic;
    }

    public void setHvlnclinic(Integer hvlnclinic) {
        this.hvlnclinic = hvlnclinic;
    }

    public Integer getHvlnnumero() {
        return this.hvlnnumero;
    }

    public void setHvlnnumero(Integer hvlnnumero) {
        this.hvlnnumero = hvlnnumero;
    }

    public Date getHvldfeclec() {
        return hvldfeclec;
    }

    public void setHvldfeclec(Date hvldfeclec) {
        this.hvldfeclec = hvldfeclec;
    }

    public String getHvlclectur() {
        return hvlclectur;
    }

    public void setHvlclectur(String hvlclectur) {
        this.hvlclectur = hvlclectur;
    }

    public String getHvlcnomlec() {
        return hvlcnomlec;
    }

    public void setHvlcnomlec(String hvlcnomlec) {
        this.hvlcnomlec = hvlcnomlec;
    }

    public String getHvlcobserv() {
        return this.hvlcobserv;
    }

    public void setHvlcobserv(String hvlcobserv) {
        this.hvlcobserv = hvlcobserv;
    }

    public String getHvlcusureg() {
        return this.hvlcusureg;
    }

    public void setHvlcusureg(String hvlcusureg) {
        this.hvlcusureg = hvlcusureg;
    }

    public Date getHvldfecreg() {
        return this.hvldfecreg;
    }

    public void setHvldfecreg(Date hvldfecreg) {
        this.hvldfecreg = hvldfecreg;
    }

    public String getHvlcnumtar() {
        return hvlcnumtar;
    }

    public void setHvlcnumtar(String hvlcnumtar) {
        this.hvlcnumtar = hvlcnumtar;
    }

    public String getHvlcgenoneg() {
        return hvlcgenoneg;
    }

    public void setHvlcgenoneg(String hvlcgenoneg) {
        this.hvlcgenoneg = hvlcgenoneg;
    }

    public String getHvlcgt16() {
        return hvlcgt16;
    }

    public void setHvlcgt16(String hvlcgt16) {
        this.hvlcgt16 = hvlcgt16;
    }

    public String getHvlcgt18() {
        return hvlcgt18;
    }

    public void setHvlcgt18(String hvlcgt18) {
        this.hvlcgt18 = hvlcgt18;
    }

    public String getHvlcgt31() {
        return hvlcgt31;
    }

    public void setHvlcgt31(String hvlcgt31) {
        this.hvlcgt31 = hvlcgt31;
    }

    public String getHvlcgt45() {
        return hvlcgt45;
    }

    public void setHvlcgt45(String hvlcgt45) {
        this.hvlcgt45 = hvlcgt45;
    }

    public String getHvlcgt51() {
        return hvlcgt51;
    }

    public void setHvlcgt51(String hvlcgt51) {
        this.hvlcgt51 = hvlcgt51;
    }

    public String getHvlcgt52() {
        return hvlcgt52;
    }

    public void setHvlcgt52(String hvlcgt52) {
        this.hvlcgt52 = hvlcgt52;
    }

    public String getHvlcgt3858() {
        return hvlcgt3858;
    }

    public void setHvlcgt3858(String hvlcgt3858) {
        this.hvlcgt3858 = hvlcgt3858;
    }

    public String getHvlcgt353968() {
        return hvlcgt353968;
    }

    public void setHvlcgt353968(String hvlcgt353968) {
        this.hvlcgt353968 = hvlcgt353968;
    }

    public String getHvlcgt565966() {
        return hvlcgt565966;
    }

    public void setHvlcgt565966(String hvlcgt565966) {
        this.hvlcgt565966 = hvlcgt565966;
    }

    public String getHvlcconduc() {
        return hvlcconduc;
    }

    public void setHvlcconduc(String hvlcconduc) {
        this.hvlcconduc = hvlcconduc;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hvlnconsec", getHvlnconsec())
            .toString();
    }

}
