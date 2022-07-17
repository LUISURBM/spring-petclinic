package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChvsolsivigPK implements Serializable {

    /** identifier field */
    private Long hvslconsulta;

    /** identifier field */
    private Long hvslnumerusuar;

 

    /** default constructor */
    public ChvsolsivigPK() {
    }

    public void setHvslconsulta(Long hvslconsulta) {
        this.hvslconsulta = hvslconsulta;
    }

    public Long getHvslconsulta() {
        return hvslconsulta;
    }

    public void setHvslnumerusuar(Long hvslnumerusuar) {
        this.hvslnumerusuar = hvslnumerusuar;
    }

    public Long getHvslnumerusuar() {
        return hvslnumerusuar;
    }
}
