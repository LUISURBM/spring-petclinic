package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChparameducaPK implements Serializable {

    /** identifier field */
    private Integer hpennumero;

    /** identifier field */
    private String hpeccolumna;

 
    /** default constructor */
    public ChparameducaPK() {
    }


    /**
     * @param hpennumero
     */
    public void setHpennumero(Integer hpennumero) {
        this.hpennumero = hpennumero;
    }

    /**
     * @return
     */
    public Integer getHpennumero() {
        return hpennumero;
    }

    /**
     * @param hpeccolumna
     */
    public void setHpeccolumna(String hpeccolumna) {
        this.hpeccolumna = hpeccolumna;
    }

    /**
     * @return
     */
    public String getHpeccolumna() {
        return hpeccolumna;
    }
}
