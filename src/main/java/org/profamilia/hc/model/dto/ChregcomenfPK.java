package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChregcomenfPK implements Serializable {

    /** identifier field */
    private Long hrcelconsulta;

    /** identifier field */
    private Integer hrcenconsecuti;


    /** full constructor */
    public ChregcomenfPK(Long hrcelconsulta, Integer hrcenconsecuti) {
        this.hrcelconsulta = hrcelconsulta;
        this.hrcenconsecuti = hrcenconsecuti;
    }

    /** default constructor */
    public ChregcomenfPK() {
    }

    public Long gethrcelconsulta() {
        return this.hrcelconsulta;
    }

    public void sethrcelconsulta(Long hrcelconsulta) {
        this.hrcelconsulta = hrcelconsulta;
    }

    public Integer gethrcenconsecuti() {
        return this.hrcenconsecuti;
    }

    public void sethrcenconsecuti(Integer hrcenconsecuti) {
        this.hrcenconsecuti = hrcenconsecuti;
    }

}
