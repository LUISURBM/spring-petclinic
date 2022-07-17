package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChvacunacionPK implements Serializable {

    /** identifier field */
    private Long hvalconsulta;

    /** identifier field */
    private String hvactiposervi;

  

    /** default constructor */
    public ChvacunacionPK() {
    }

    public void setHvalconsulta(Long hvalconsulta) {
        this.hvalconsulta = hvalconsulta;
    }

    public Long getHvalconsulta() {
        return hvalconsulta;
    }

    public void setHvactiposervi(String hvactiposervi) {
        this.hvactiposervi = hvactiposervi;
    }

    public String getHvactiposervi() {
        return hvactiposervi;
    }
}
