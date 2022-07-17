package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chcupsxcon implements Serializable {

    /** identifier field */
    private Long ccupnconsec;

    /** persistent field */
    private long ccupnconsulta;

    /** persistent field */
    private String ccupccodcups;

    /** persistent field */
    private String ccupcusuareg;

    /** persistent field */
    private Date ccupdfecreg;

    /** nullable persistent field */
    private BigDecimal version;
    
    /** nullable persistent field */
    private String ccupcdatosrel;

    /** full constructor */
    public Chcupsxcon(Long ccupnconsec, long ccupnconsulta, String ccupccodcups, String ccupcusuareg, Date ccupdfecreg, BigDecimal version) {
        this.ccupnconsec = ccupnconsec;
        this.ccupnconsulta = ccupnconsulta;
        this.ccupccodcups = ccupccodcups;
        this.ccupcusuareg = ccupcusuareg;
        this.ccupdfecreg = ccupdfecreg;
        this.version = version;
    }

    /** default constructor */
    public Chcupsxcon() {
    }

    /** minimal constructor */
    public Chcupsxcon(Long ccupnconsec, long ccupnconsulta, String ccupccodcups, String ccupcusuareg, Date ccupdfecreg) {
        this.ccupnconsec = ccupnconsec;
        this.ccupnconsulta = ccupnconsulta;
        this.ccupccodcups = ccupccodcups;
        this.ccupcusuareg = ccupcusuareg;
        this.ccupdfecreg = ccupdfecreg;
    }

    /** 
     * 		       Secuencia
     * 		    
     */
    public Long getCcupnconsec() {
        return this.ccupnconsec;
    }

    public void setCcupnconsec(Long ccupnconsec) {
        this.ccupnconsec = ccupnconsec;
    }

    public long getCcupnconsulta() {
        return this.ccupnconsulta;
    }

    public void setCcupnconsulta(long ccupnconsulta) {
        this.ccupnconsulta = ccupnconsulta;
    }

    public String getCcupccodcups() {
        return this.ccupccodcups;
    }

    public void setCcupccodcups(String ccupccodcups) {
        this.ccupccodcups = ccupccodcups;
    }

    public String getCcupcusuareg() {
        return this.ccupcusuareg;
    }

    public void setCcupcusuareg(String ccupcusuareg) {
        this.ccupcusuareg = ccupcusuareg;
    }

    public Date getCcupdfecreg() {
        return this.ccupdfecreg;
    }

    public void setCcupdfecreg(Date ccupdfecreg) {
        this.ccupdfecreg = ccupdfecreg;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ccupnconsec", getCcupnconsec())
            .toString();
    }


    public void setCcupcdatosrel(String ccupcdatosrel) {
        this.ccupcdatosrel = ccupcdatosrel;
    }

    public String getCcupcdatosrel() {
        return ccupcdatosrel;
    }
}
