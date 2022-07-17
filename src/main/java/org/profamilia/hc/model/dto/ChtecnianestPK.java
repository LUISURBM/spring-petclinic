package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChtecnianestPK implements Serializable {

    /** identifier field */
    private Long htalnumero;

    /** identifier field */
    private String htactiposervi;

    /** default constructor */
    public ChtecnianestPK() {
    }

    /**
     * @return
     */
    public Long getHtalnumero() {
        return this.htalnumero;
    }

    /**
     * @param htalnumero
     */
    public void setHtalnumero(Long htalnumero) {
        this.htalnumero = htalnumero;
    }

    /**
     * @return
     */
    public String getHtactiposervi() {
        return this.htactiposervi;
    }

    /**
     * @param htactiposervi
     */
    public void setHtactiposervi(String htactiposervi) {
        this.htactiposervi = htactiposervi;
    }


}
