package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChevoluconsuPK implements Serializable {

    /** identifier field */
    private Long heclconsulta;

    /** identifier field */
    private Integer hecnconsecuti;

    /** identifier field */
    private String hecctiposervi;

    /** default constructor */
    public ChevoluconsuPK() {
    }


    public void setHeclconsulta(Long heclconsulta) {
        this.heclconsulta = heclconsulta;
    }

    public Long getHeclconsulta() {
        return heclconsulta;
    }

    public void setHecnconsecuti(Integer hecnconsecuti) {
        this.hecnconsecuti = hecnconsecuti;
    }

    public Integer getHecnconsecuti() {
        return hecnconsecuti;
    }

    public void setHecctiposervi(String hecctiposervi) {
        this.hecctiposervi = hecctiposervi;
    }

    public String getHecctiposervi() {
        return hecctiposervi;
    }
}
