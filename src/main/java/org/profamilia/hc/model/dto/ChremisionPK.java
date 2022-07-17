package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChremisionPK implements Serializable {

    /** identifier field */
    private Long hrelconsulta;

    /** identifier field */
    private Integer hrenconsecuti;

    /** identifier field */
    private String hrectiposervi;

    /** identifier field */
    private Integer hrenllave;


    /** default constructor */
    public ChremisionPK() {
    }


    public void setHrelconsulta(Long hrelconsulta) {
        this.hrelconsulta = hrelconsulta;
    }

    public Long getHrelconsulta() {
        return hrelconsulta;
    }

    public void setHrenconsecuti(Integer hrenconsecuti) {
        this.hrenconsecuti = hrenconsecuti;
    }

    public Integer getHrenconsecuti() {
        return hrenconsecuti;
    }

    public void setHrectiposervi(String hrectiposervi) {
        this.hrectiposervi = hrectiposervi;
    }

    public String getHrectiposervi() {
        return hrectiposervi;
    }

    public void setHrenllave(Integer hrenllave) {
        this.hrenllave = hrenllave;
    }

    public Integer getHrenllave() {
        return hrenllave;
    }
}
