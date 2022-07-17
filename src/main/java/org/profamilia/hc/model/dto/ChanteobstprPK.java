package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChanteobstprPK implements Serializable {

    /** identifier field */
    private Long haolconsulta;

    /** identifier field */
    private String haoctiposervi;


    /** default constructor */
    public ChanteobstprPK() {
    }


    public void setHaolconsulta(Long haolconsulta) {
        this.haolconsulta = haolconsulta;
    }

    public Long getHaolconsulta() {
        return haolconsulta;
    }

    public void setHaoctiposervi(String haoctiposervi) {
        this.haoctiposervi = haoctiposervi;
    }

    public String getHaoctiposervi() {
        return haoctiposervi;
    }
}
