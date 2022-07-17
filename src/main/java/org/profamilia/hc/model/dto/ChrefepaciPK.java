package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChrefepaciPK implements Serializable {

    /** identifier field */
    private Long hrplconsulta;

    /** identifier field */
    private Integer hrpnconsecuti;


    /** full constructor */
    public ChrefepaciPK(Long hrplconsulta, Integer hrpnconsecuti) {
        this.hrplconsulta = hrplconsulta;
        this.hrpnconsecuti = hrpnconsecuti;
    }

    /** default constructor */
    public ChrefepaciPK() {
    }


    public void setHrplconsulta(Long hrplconsulta) {
        this.hrplconsulta = hrplconsulta;
    }

    public Long getHrplconsulta() {
        return hrplconsulta;
    }

    public void setHrpnconsecuti(Integer hrpnconsecuti) {
        this.hrpnconsecuti = hrpnconsecuti;
    }

    public Integer getHrpnconsecuti() {
        return hrpnconsecuti;
    }
}
