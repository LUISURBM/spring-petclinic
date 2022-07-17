package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChexameimagePK implements Serializable {

    /** identifier field */
    private Long heilconsulta;

    /** identifier field */
    private Integer heinconsecuti;

    /** identifier field */
    private String heictiposervi;

    /** identifier field */
    private Integer heinllave;


    /** default constructor */
    public ChexameimagePK() {
    }


    public void setHeilconsulta(Long heilconsulta) {
        this.heilconsulta = heilconsulta;
    }

    public Long getHeilconsulta() {
        return heilconsulta;
    }

    public void setHeinconsecuti(Integer heinconsecuti) {
        this.heinconsecuti = heinconsecuti;
    }

    public Integer getHeinconsecuti() {
        return heinconsecuti;
    }

    public void setHeictiposervi(String heictiposervi) {
        this.heictiposervi = heictiposervi;
    }

    public String getHeictiposervi() {
        return heictiposervi;
    }

    public void setHeinllave(Integer heinllave) {
        this.heinllave = heinllave;
    }

    public Integer getHeinllave() {
        return heinllave;
    }
}
