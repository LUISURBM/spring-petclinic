package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChhistoxclinPK implements Serializable {

    /** identifier field */
    private Long hhclusuario;

    /** identifier field */
    private Integer hhcnclinica;

    /** default constructor */
    public ChhistoxclinPK() {
    }


    /**
     * @param hhclusuario
     */
    public void setHhclusuario(Long hhclusuario) {
        this.hhclusuario = hhclusuario;
    }

    /**
     * @return
     */
    public Long getHhclusuario() {
        return hhclusuario;
    }

    /**
     * @param hhcnclinica
     */
    public void setHhcnclinica(Integer hhcnclinica) {
        this.hhcnclinica = hhcnclinica;
    }

    /**
     * @return
     */
    public Integer getHhcnclinica() {
        return hhcnclinica;
    }
}
