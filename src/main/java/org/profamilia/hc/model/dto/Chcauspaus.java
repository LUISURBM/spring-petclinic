package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chcauspaus implements Serializable {

    /** identifier field */
    private Integer ccpnconsec;

    /** persistent field */
    private String ccpcdescrip;

    /** persistent field */
    private String ccpcestado;

    /** nullable persistent field */
    private Integer version;

    /** full constructor */
    public Chcauspaus(Integer ccpnconsec, String ccpcdescrip, String ccpcestado, Integer version) {
        this.ccpnconsec = ccpnconsec;
        this.ccpcdescrip = ccpcdescrip;
        this.ccpcestado = ccpcestado;
        this.version = version;
    }

    /** default constructor */
    public Chcauspaus() {
    }

    /** minimal constructor */
    public Chcauspaus(Integer ccpnconsec, String ccpcdescrip, String ccpcestado) {
        this.ccpnconsec = ccpnconsec;
        this.ccpcdescrip = ccpcdescrip;
        this.ccpcestado = ccpcestado;
    }

    /** 
     * 		       Consecutivo
     * 		    
     */
    public Integer getCcpnconsec() {
        return this.ccpnconsec;
    }

    public void setCcpnconsec(Integer ccpnconsec) {
        this.ccpnconsec = ccpnconsec;
    }

    public String getCcpcdescrip() {
        return this.ccpcdescrip;
    }

    public void setCcpcdescrip(String ccpcdescrip) {
        this.ccpcdescrip = ccpcdescrip;
    }

    public String getCcpcestado() {
        return this.ccpcestado;
    }

    public void setCcpcestado(String ccpcestado) {
        this.ccpcestado = ccpcestado;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ccpnconsec", getCcpnconsec())
            .toString();
    }

}
