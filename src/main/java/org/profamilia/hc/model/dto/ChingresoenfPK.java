package org.profamilia.hc.model.dto;

import java.io.Serializable;

/** @author Hibernate CodeGenerator */
public class ChingresoenfPK implements Serializable {

    /** identifier field */
    private Long hielnumero;

    /** identifier field */
    private String hiectiposervi;

    /** full constructor */
    public ChingresoenfPK(Long hielnumero, String hiectiposervi) {
        this.hielnumero = hielnumero;
        this.hiectiposervi = hiectiposervi;
    }

    /** default constructor */
    public ChingresoenfPK() {
    }

    /**
     * @return
     */
    public Long getHielnumero() {
        return this.hielnumero;
    }

    /**
     * @param hielnumero
     */
    public void setHielnumero(Long hielnumero) {
        this.hielnumero = hielnumero;
    }

    /**
     * @return
     */
    public String getHiectiposervi() {
        return this.hiectiposervi;
    }

    /**
     * @param hiectiposervi
     */
    public void setHiectiposervi(String hiectiposervi) {
        this.hiectiposervi = hiectiposervi;
    }

   

}
