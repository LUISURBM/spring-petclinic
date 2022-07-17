package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;


/** @author Hibernate CodeGenerator */
public class ChdetaentpatolPK implements Serializable {

    /** identifier field */
    private Long heplidentregapatol;

    /** identifier field */
    private BigDecimal hepnpatologia;

    /** default constructor */
    public ChdetaentpatolPK() {
    }

    public Long getHeplidentregapatol() {
        return this.heplidentregapatol;
    }

    public void setHeplidentregapatol(Long heplidentregapatol) {
        this.heplidentregapatol = heplidentregapatol;
    }

    public BigDecimal getHepnpatologia() {
        return this.hepnpatologia;
    }

    public void setHepnpatologia(BigDecimal hepnpatologia) {
        this.hepnpatologia = hepnpatologia;
    }

}
