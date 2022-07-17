package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;


/** @author Hibernate CodeGenerator */
public class ChproflectPK implements Serializable {

    /** identifier field */
    private BigDecimal hplncodprofes;

    /** identifier field */
    private Integer hplnclinlect;

    /** default constructor */
    public ChproflectPK() {
    }

    public BigDecimal getHplncodprofes() {
        return this.hplncodprofes;
    }

    public void setHplncodprofes(BigDecimal hplncodprofes) {
        this.hplncodprofes = hplncodprofes;
    }

    public Integer getHplnclinlect() {
        return this.hplnclinlect;
    }

    public void setHplnclinlect(Integer hplnclinlect) {
        this.hplnclinlect = hplnclinlect;
    }

}
