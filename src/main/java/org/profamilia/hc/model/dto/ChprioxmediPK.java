package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;


/** @author Hibernate CodeGenerator */
public class ChprioxmediPK implements Serializable {

    /** identifier field */
    private BigDecimal hpmncodigprofe;

    /** identifier field */
    private Integer hpmncodigclini;


    /** default constructor */
    public ChprioxmediPK() {
    }


    /**
     * @param hpmncodigprofe
     */
    public void setHpmncodigprofe(BigDecimal hpmncodigprofe) {
        this.hpmncodigprofe = hpmncodigprofe;
    }

    /**
     * @return
     */
    public BigDecimal getHpmncodigprofe() {
        return hpmncodigprofe;
    }

    /**
     * @param hpmncodigclini
     */
    public void setHpmncodigclini(Integer hpmncodigclini) {
        this.hpmncodigclini = hpmncodigclini;
    }

    /**
     * @return
     */
    public Integer getHpmncodigclini() {
        return hpmncodigclini;
    }
}
