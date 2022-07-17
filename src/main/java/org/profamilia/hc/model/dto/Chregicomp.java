package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chregicomp implements Serializable {

    /** identifier field */
    private Long hrclnumero;

    /** persistent field */
    private Long hrclnumusu;

    /** persistent field */
    private String hrccregistro;

    /** persistent field */
    private String hrccusureg;

    /** persistent field */
    private Date hrcdfecreg;

    /** persistent field */
    private String hrccusumod;

    /** persistent field */
    private Date hrcdfecmod;

    /** nullable persistent field */
    private Long version;
    
    private Integer hrcnclinic; 

  

    /** default constructor */
    public Chregicomp() {
    }


    public void setHrclnumero(Long hrclnumero) {
        this.hrclnumero = hrclnumero;
    }

    public Long getHrclnumero() {
        return hrclnumero;
    }

    public void setHrclnumusu(Long hrclnumusu) {
        this.hrclnumusu = hrclnumusu;
    }

    public Long getHrclnumusu() {
        return hrclnumusu;
    }

    public void setHrccregistro(String hrccregistro) {
        this.hrccregistro = hrccregistro;
    }

    public String getHrccregistro() {
        return hrccregistro;
    }

    public void setHrccusureg(String hrccusureg) {
        this.hrccusureg = hrccusureg;
    }

    public String getHrccusureg() {
        return hrccusureg;
    }

    public void setHrcdfecreg(Date hrcdfecreg) {
        this.hrcdfecreg = hrcdfecreg;
    }

    public Date getHrcdfecreg() {
        return hrcdfecreg;
    }

    public void setHrccusumod(String hrccusumod) {
        this.hrccusumod = hrccusumod;
    }

    public String getHrccusumod() {
        return hrccusumod;
    }

    public void setHrcdfecmod(Date hrcdfecmod) {
        this.hrcdfecmod = hrcdfecmod;
    }

    public Date getHrcdfecmod() {
        return hrcdfecmod;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getVersion() {
        return version;
    }

    public void setHrcnclinic(Integer hrcnclinic) {
        this.hrcnclinic = hrcnclinic;
    }

    public Integer getHrcnclinic() {
        return hrcnclinic;
    }
}
