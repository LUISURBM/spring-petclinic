package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChestermascuPK implements Serializable {

    /** identifier field */
    private Long hemlconsulta;

    /** identifier field */
    private String hemctiposerv;


    /** default constructor */
    public ChestermascuPK() {
    }

    /**
     * @param hemlconsulta
     */
    public void setHemlconsulta(Long hemlconsulta) {
        this.hemlconsulta = hemlconsulta;
    }

    /**
     * @return
     */
    public Long getHemlconsulta() {
        return hemlconsulta;
    }

    /**
     * @param hemctiposerv
     */
    public void setHemctiposerv(String hemctiposerv) {
        this.hemctiposerv = hemctiposerv;
    }

    /**
     * @return
     */
    public String getHemctiposerv() {
        return hemctiposerv;
    }
}
