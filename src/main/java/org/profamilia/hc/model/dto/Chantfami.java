package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chantfami implements Serializable {

    /** identifier field */
    private Long hanfnconsulta;

    /** persistent field */
    private String hanfcrefiere;

    /** nullable persistent field */
    private String hanfcdesc;

    /** persistent field */
    private Date hanfdfecreg;

    /** persistent field */
    private String hanfcusuareg;

    /** nullable persistent field */
    private String version;

    /** full constructor */
    public Chantfami(Long hanfnconsulta, String hanfcrefiere, String hanfcdesc, Date hanfdfecreg, String hanfcusuareg, String version) {
        this.hanfnconsulta = hanfnconsulta;
        this.hanfcrefiere = hanfcrefiere;
        this.hanfcdesc = hanfcdesc;
        this.hanfdfecreg = hanfdfecreg;
        this.hanfcusuareg = hanfcusuareg;
        this.version = version;
    }

    /** default constructor */
    public Chantfami() {
    }

    /** minimal constructor */
    public Chantfami(Long hanfnconsulta, String hanfcrefiere, Date hanfdfecreg, String hanfcusuareg) {
        this.hanfnconsulta = hanfnconsulta;
        this.hanfcrefiere = hanfcrefiere;
        this.hanfdfecreg = hanfdfecreg;
        this.hanfcusuareg = hanfcusuareg;
    }

    /** 
     * 		       Consulta asociada
     * 		    
     */
    public Long getHanfnconsulta() {
        return this.hanfnconsulta;
    }

    public void setHanfnconsulta(Long hanfnconsulta) {
        this.hanfnconsulta = hanfnconsulta;
    }

    public String getHanfcrefiere() {
        return this.hanfcrefiere;
    }

    public void setHanfcrefiere(String hanfcrefiere) {
        this.hanfcrefiere = hanfcrefiere;
    }

    public String getHanfcdesc() {
        return this.hanfcdesc;
    }

    public void setHanfcdesc(String hanfcdesc) {
        this.hanfcdesc = hanfcdesc;
    }

    public Date getHanfdfecreg() {
        return this.hanfdfecreg;
    }

    public void setHanfdfecreg(Date hanfdfecreg) {
        this.hanfdfecreg = hanfdfecreg;
    }

    public String getHanfcusuareg() {
        return this.hanfcusuareg;
    }

    public void setHanfcusuareg(String hanfcusuareg) {
        this.hanfcusuareg = hanfcusuareg;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hanfnconsulta", getHanfnconsulta())
            .toString();
    }

}
