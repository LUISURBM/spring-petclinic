package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chantquir implements Serializable {

    /** identifier field */
    private Long hanqnconsulta;

    /** persistent field */
    private String hanqcrefiere;

    /** nullable persistent field */
    private String hanqcdesc;

    /** persistent field */
    private Date hanqdfecreg;

    /** persistent field */
    private String hanqcusuareg;

    /** nullable persistent field */
    private BigDecimal version;

    /** full constructor */
    public Chantquir(Long hanqnconsulta, String hanqcrefiere, String hanqcdesc, Date hanqdfecreg, String hanqcusuareg, BigDecimal version) {
        this.hanqnconsulta = hanqnconsulta;
        this.hanqcrefiere = hanqcrefiere;
        this.hanqcdesc = hanqcdesc;
        this.hanqdfecreg = hanqdfecreg;
        this.hanqcusuareg = hanqcusuareg;
        this.version = version;
    }

    /** default constructor */
    public Chantquir() {
    }

    /** minimal constructor */
    public Chantquir(Long hanqnconsulta, String hanqcrefiere, Date hanqdfecreg, String hanqcusuareg) {
        this.hanqnconsulta = hanqnconsulta;
        this.hanqcrefiere = hanqcrefiere;
        this.hanqdfecreg = hanqdfecreg;
        this.hanqcusuareg = hanqcusuareg;
    }

    /** 
     * 		       Consulta asociada
     * 		    
     */
    public Long getHanqnconsulta() {
        return this.hanqnconsulta;
    }

    public void setHanqnconsulta(Long hanqnconsulta) {
        this.hanqnconsulta = hanqnconsulta;
    }

    public String getHanqcrefiere() {
        return this.hanqcrefiere;
    }

    public void setHanqcrefiere(String hanqcrefiere) {
        this.hanqcrefiere = hanqcrefiere;
    }

    public String getHanqcdesc() {
        return this.hanqcdesc;
    }

    public void setHanqcdesc(String hanqcdesc) {
        this.hanqcdesc = hanqcdesc;
    }

    public Date getHanqdfecreg() {
        return this.hanqdfecreg;
    }

    public void setHanqdfecreg(Date hanqdfecreg) {
        this.hanqdfecreg = hanqdfecreg;
    }

    public String getHanqcusuareg() {
        return this.hanqcusuareg;
    }

    public void setHanqcusuareg(String hanqcusuareg) {
        this.hanqcusuareg = hanqcusuareg;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hanqnconsulta", getHanqnconsulta())
            .toString();
    }

}
