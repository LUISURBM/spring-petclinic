package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;


/** @author Hibernate CodeGenerator */
public class ChprofpatolPK implements Serializable {

    /** identifier field */
    private BigDecimal hppncodprofes;

    /** identifier field */
    private Integer hppnclinlect;
    
    /** persistent field */
    private String hppcservicio;

    /** default constructor */
    public ChprofpatolPK() {
    }

    public BigDecimal getHppncodprofes() {
        return this.hppncodprofes;
    }

    public void setHppncodprofes(BigDecimal hppncodprofes) {
        this.hppncodprofes = hppncodprofes;
    }

    public Integer getHppnclinlect() {
        return this.hppnclinlect;
    }

    public void setHppnclinlect(Integer hppnclinlect) {
        this.hppnclinlect = hppnclinlect;
    }
    
    public String getHppcservicio() {
        return this.hppcservicio;
    }

    public void setHppcservicio(String hppcservicio) {
        this.hppcservicio = hppcservicio;
    }

}
