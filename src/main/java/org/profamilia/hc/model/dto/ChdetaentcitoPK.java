package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;


/** @author Hibernate CodeGenerator */
public class ChdetaentcitoPK implements Serializable {

    /** identifier field */
    private Long hdelidentregacitol;

    /** identifier field */
    private BigDecimal hdencitologia;

    /** default constructor */
    public ChdetaentcitoPK() {
    }

    public Long getHdelidentregacitol() {
        return this.hdelidentregacitol;
    }

    public void setHdelidentregacitol(Long hdelidentregacitol) {
        this.hdelidentregacitol = hdelidentregacitol;
    }

    public BigDecimal getHdencitologia() {
        return this.hdencitologia;
    }

    public void setHdencitologia(BigDecimal hdencitologia) {
        this.hdencitologia = hdencitologia;
    }

}
