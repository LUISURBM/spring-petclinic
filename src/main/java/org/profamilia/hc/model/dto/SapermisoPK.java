package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class SapermisoPK implements Serializable {

    /** identifier field */
    private String spmcusuari;

    /** identifier field */
    private String spmcprogra;

    /** full constructor */
    public SapermisoPK(String spmcusuari, String spmcprogra) {
        this.spmcusuari = spmcusuari;
        this.spmcprogra = spmcprogra;
    }

    /** default constructor */
    public SapermisoPK() {
    }

    public String getSpmcusuari() {
        return this.spmcusuari;
    }

    public void setSpmcusuari(String spmcusuari) {
        this.spmcusuari = spmcusuari;
    }

    public String getSpmcprogra() {
        return this.spmcprogra;
    }

    public void setSpmcprogra(String spmcprogra) {
        this.spmcprogra = spmcprogra;
    }

    public String toString() {
        return new ToStringBuilder(this).append("spmcusuari", 
                                                getSpmcusuari()).append("spmcprogra", 
                                                                        getSpmcprogra()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof SapermisoPK))
            return false;
        SapermisoPK castOther = (SapermisoPK)other;
        return new EqualsBuilder().append(this.getSpmcusuari(), 
                                          castOther.getSpmcusuari()).append(this.getSpmcprogra(), 
                                                                            castOther.getSpmcprogra()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getSpmcusuari()).append(getSpmcprogra()).toHashCode();
    }

}
