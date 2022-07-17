package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chantpatol implements Serializable {

    /** identifier field */
    private Long hagnconsulta;

    /** persistent field */
    private String hagcrefiere;

    /** nullable persistent field */
    private String hagcdescri;

    /** persistent field */
    private Date hagdfecreg;

    /** persistent field */
    private String hagcusuareg;

    /** nullable persistent field */
    private BigDecimal version;

    /** full constructor */
    public Chantpatol(Long hagnconsulta, String hagcrefiere, String hagcdescri, Date hagdfecreg, String hagcusuareg, BigDecimal version) {
        this.hagnconsulta = hagnconsulta;
        this.hagcrefiere = hagcrefiere;
        this.hagcdescri = hagcdescri;
        this.hagdfecreg = hagdfecreg;
        this.hagcusuareg = hagcusuareg;
        this.version = version;
    }

    /** default constructor */
    public Chantpatol() {
    }

    /** minimal constructor */
    public Chantpatol(Long hagnconsulta, String hagcrefiere, Date hagdfecreg, String hagcusuareg) {
        this.hagnconsulta = hagnconsulta;
        this.hagcrefiere = hagcrefiere;
        this.hagdfecreg = hagdfecreg;
        this.hagcusuareg = hagcusuareg;
    }

    /** 
     * 		       Consulta asociada
     * 		    
     */
    public Long getHagnconsulta() {
        return this.hagnconsulta;
    }

    public void setHagnconsulta(Long hagnconsulta) {
        this.hagnconsulta = hagnconsulta;
    }

    public String getHagcrefiere() {
        return this.hagcrefiere;
    }

    public void setHagcrefiere(String hagcrefiere) {
        this.hagcrefiere = hagcrefiere;
    }

    public String getHagcdescri() {
        return this.hagcdescri;
    }

    public void setHagcdescri(String hagcdescri) {
        this.hagcdescri = hagcdescri;
    }

    public Date getHagdfecreg() {
        return this.hagdfecreg;
    }

    public void setHagdfecreg(Date hagdfecreg) {
        this.hagdfecreg = hagdfecreg;
    }

    public String getHagcusuareg() {
        return this.hagcusuareg;
    }

    public void setHagcusuareg(String hagcusuareg) {
        this.hagcusuareg = hagcusuareg;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hagnconsulta", getHagnconsulta())
            .toString();
    }

}
