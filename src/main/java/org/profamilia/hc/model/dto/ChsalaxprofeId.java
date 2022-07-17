package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;


/** @author Hibernate CodeGenerator */
public class ChsalaxprofeId implements Serializable {

    /** identifier field */
    private BigDecimal hspnnumero;

    /** identifier field */
    private Integer hspnsala;

    /** identifier field */
    private Integer hspnclinica;

    /** full constructor */
   

    /** default constructor */
    public ChsalaxprofeId() {
    }


    public void setHspnnumero(BigDecimal hspnnumero) {
        this.hspnnumero = hspnnumero;
    }

    public BigDecimal getHspnnumero() {
        return hspnnumero;
    }

    public void setHspnsala(Integer hspnsala) {
        this.hspnsala = hspnsala;
    }

    public Integer getHspnsala() {
        return hspnsala;
    }

    public void setHspnclinica(Integer hspnclinica) {
        this.hspnclinica = hspnclinica;
    }

    public Integer getHspnclinica() {
        return hspnclinica;
    }
}
