package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChingresomedPK implements Serializable {

    /** identifier field */
    private Long himlnumero;

    /** identifier field */
    private String himctiposervi;


    /** default constructor */
    public ChingresomedPK() {
    }


    /**
     * @param himlnumero
     */
    public void setHimlnumero(Long himlnumero) {
        this.himlnumero = himlnumero;
    }

    /**
     * @return
     */
    public Long getHimlnumero() {
        return himlnumero;
    }

    /**
     * @param himctiposervi
     */
    public void setHimctiposervi(String himctiposervi) {
        this.himctiposervi = himctiposervi;
    }

    /**
     * @return
     */
    public String getHimctiposervi() {
        return himctiposervi;
    }
}
