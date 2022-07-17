package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;


/** @author Hibernate CodeGenerator */
public class CnregfertiPK implements Serializable {

    /** identifier field */
    private Integer crfnclinic;

    /** identifier field */
    private String crfctipide;

    /** identifier field */
    private BigDecimal crfanumide;


    /** default constructor */
    public CnregfertiPK() {
    }


    /**
     * @param crfnclinic
     */
    public void setCrfnclinic(Integer crfnclinic) {
        this.crfnclinic = crfnclinic;
    }

    /**
     * @return
     */
    public Integer getCrfnclinic() {
        return crfnclinic;
    }

    /**
     * @param crfctipide
     */
    public void setCrfctipide(String crfctipide) {
        this.crfctipide = crfctipide;
    }

    /**
     * @return
     */
    public String getCrfctipide() {
        return crfctipide;
    }

    /**
     * @param crfanumide
     */
    public void setCrfanumide(BigDecimal crfanumide) {
        this.crfanumide = crfanumide;
    }

    /**
     * @return
     */
    public BigDecimal getCrfanumide() {
        return crfanumide;
    }
}
