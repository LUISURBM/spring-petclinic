package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChexamelaborPK implements Serializable {

    /** identifier field */
    private Long hellconsulta;

    /** identifier field */
    private Integer helnconsecuti;

    /** identifier field */
    private String helctiposervi;

    /** identifier field */
    private Integer helnllave;


    /** default constructor */
    public ChexamelaborPK() {
    }


    public void setHellconsulta(Long hellconsulta) {
        this.hellconsulta = hellconsulta;
    }

    public Long getHellconsulta() {
        return hellconsulta;
    }

    public void setHelnconsecuti(Integer helnconsecuti) {
        this.helnconsecuti = helnconsecuti;
    }

    public Integer getHelnconsecuti() {
        return helnconsecuti;
    }

    public void setHelctiposervi(String helctiposervi) {
        this.helctiposervi = helctiposervi;
    }

    public String getHelctiposervi() {
        return helctiposervi;
    }

    public void setHelnllave(Integer helnllave) {
        this.helnllave = helnllave;
    }

    public Integer getHelnllave() {
        return helnllave;
    }
}
