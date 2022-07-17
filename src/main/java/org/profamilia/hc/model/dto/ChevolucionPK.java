package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChevolucionPK implements Serializable {

    /** identifier field */
    private Long hevlnumero;

    /** identifier field */
    private Integer hevnconsecutiv;

    /** identifier field */
    private String hevctiposervi;


    /** default constructor */
    public ChevolucionPK() {
    }


    /**
     * @param hevlnumero
     */
    public void setHevlnumero(Long hevlnumero) {
        this.hevlnumero = hevlnumero;
    }

    /**
     * @return
     */
    public Long getHevlnumero() {
        return hevlnumero;
    }

    /**
     * @param hevnconsecutiv
     */
    public void setHevnconsecutiv(Integer hevnconsecutiv) {
        this.hevnconsecutiv = hevnconsecutiv;
    }

    /**
     * @return
     */
    public Integer getHevnconsecutiv() {
        return hevnconsecutiv;
    }

    /**
     * @param hevctiposervi
     */
    public void setHevctiposervi(String hevctiposervi) {
        this.hevctiposervi = hevctiposervi;
    }

    /**
     * @return
     */
    public String getHevctiposervi() {
        return hevctiposervi;
    }
}
