package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChincapacidaPK implements Serializable {

    /** identifier field */
    private Long hinlconsulta;

    /** identifier field */
    private String hinctiposervi;

    /** identifier field */
    private Integer hinnconsecutiv;


    /** default constructor */
    public ChincapacidaPK() {
    }


    public void setHinlconsulta(Long hinlconsulta) {
        this.hinlconsulta = hinlconsulta;
    }

    public Long getHinlconsulta() {
        return hinlconsulta;
    }

    public void setHinctiposervi(String hinctiposervi) {
        this.hinctiposervi = hinctiposervi;
    }

    public String getHinctiposervi() {
        return hinctiposervi;
    }

    public void setHinnconsecutiv(Integer hinnconsecutiv) {
        this.hinnconsecutiv = hinnconsecutiv;
    }

    public Integer getHinnconsecutiv() {
        return hinnconsecutiv;
    }
}
