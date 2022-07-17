package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChevalugenerPK implements Serializable {

    /** identifier field */
    private Long heglconsulta;

    /** identifier field */
    private String hegctiposerv;


    /** default constructor */
    public ChevalugenerPK() {
    }


    /**
     * @param heglconsulta
     */
    public void setHeglconsulta(Long heglconsulta) {
        this.heglconsulta = heglconsulta;
    }

    /**
     * @return
     */
    public Long getHeglconsulta() {
        return heglconsulta;
    }

    /**
     * @param hegctiposerv
     */
    public void setHegctiposerv(String hegctiposerv) {
        this.hegctiposerv = hegctiposerv;
    }

    /**
     * @return
     */
    public String getHegctiposerv() {
        return hegctiposerv;
    }
}
