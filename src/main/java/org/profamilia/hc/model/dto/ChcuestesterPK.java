package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChcuestesterPK implements Serializable {

    /** identifier field */
    private Long hcelconsulta;

    /** identifier field */
    private String hcectiposerv;

    /** default constructor */
    public ChcuestesterPK() {
    }

    public Long getHcelconsulta() {
        return this.hcelconsulta;
    }

    public void setHcelconsulta(Long hcelconsulta) {
        this.hcelconsulta = hcelconsulta;
    }

    public String getHcectiposerv() {
        return this.hcectiposerv;
    }

    public void setHcectiposerv(String hcectiposerv) {
        this.hcectiposerv = hcectiposerv;
    }

}
