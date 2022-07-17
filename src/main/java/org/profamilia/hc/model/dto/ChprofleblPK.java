package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;


/** @author Hibernate CodeGenerator */
public class ChprofleblPK implements Serializable {

    /** identifier field */
    private BigDecimal hplncodprofes;

    /** identifier field */
    private Integer hplnclinica;

    /** default constructor */
    public ChprofleblPK() {
    }


    public void setHplncodprofes(BigDecimal hplncodprofes) {
        this.hplncodprofes = hplncodprofes;
    }

    public BigDecimal getHplncodprofes() {
        return hplncodprofes;
    }

    public void setHplnclinica(Integer hplnclinica) {
        this.hplnclinica = hplnclinica;
    }

    public Integer getHplnclinica() {
        return hplnclinica;
    }
}
