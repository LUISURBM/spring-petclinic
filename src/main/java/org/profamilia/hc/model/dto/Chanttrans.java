package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chanttrans implements Serializable {

    /** identifier field */
    private Long hantnconsulta;

    /** persistent field */
    private String hantcrefiere;

    /** nullable persistent field */
    private String hantcdesc;

    /** persistent field */
    private Date hantdfecreg;

    /** persistent field */
    private String hantcusuareg;

    /** nullable persistent field */
    private BigDecimal version;

    /** full constructor */
    public Chanttrans(Long hantnconsulta, String hantcrefiere, String hantcdesc, Date hantdfecreg, String hantcusuareg, BigDecimal version) {
        this.hantnconsulta = hantnconsulta;
        this.hantcrefiere = hantcrefiere;
        this.hantcdesc = hantcdesc;
        this.hantdfecreg = hantdfecreg;
        this.hantcusuareg = hantcusuareg;
        this.version = version;
    }

    /** default constructor */
    public Chanttrans() {
    }

    /** minimal constructor */
    public Chanttrans(Long hantnconsulta, String hantcrefiere, Date hantdfecreg, String hantcusuareg) {
        this.hantnconsulta = hantnconsulta;
        this.hantcrefiere = hantcrefiere;
        this.hantdfecreg = hantdfecreg;
        this.hantcusuareg = hantcusuareg;
    }

    /** 
     * 		       Consulta asociada
     * 		    
     */
    public Long getHantnconsulta() {
        return this.hantnconsulta;
    }

    public void setHantnconsulta(Long hantnconsulta) {
        this.hantnconsulta = hantnconsulta;
    }

    public String getHantcrefiere() {
        return this.hantcrefiere;
    }

    public void setHantcrefiere(String hantcrefiere) {
        this.hantcrefiere = hantcrefiere;
    }

    public String getHantcdesc() {
        return this.hantcdesc;
    }

    public void setHantcdesc(String hantcdesc) {
        this.hantcdesc = hantcdesc;
    }

    public Date getHantdfecreg() {
        return this.hantdfecreg;
    }

    public void setHantdfecreg(Date hantdfecreg) {
        this.hantdfecreg = hantdfecreg;
    }

    public String getHantcusuareg() {
        return this.hantcusuareg;
    }

    public void setHantcusuareg(String hantcusuareg) {
        this.hantcusuareg = hantcusuareg;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hantnconsulta", getHantnconsulta())
            .toString();
    }

}
