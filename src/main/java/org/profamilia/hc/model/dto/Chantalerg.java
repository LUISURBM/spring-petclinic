package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chantalerg implements Serializable {

    /** identifier field */
    private Long hananconsulta;

    /** persistent field */
    private String hanacrefiere;

    /** nullable persistent field */
    private String hanacdesc;

    /** nullable persistent field */
    private String hanacmedchk;

    /** nullable persistent field */
    private String hanacalichk;

    /** nullable persistent field */
    private String hanacsusambchk;

    /** nullable persistent field */
    private String hanacsuspielchk;

    /** nullable persistent field */
    private String hanacpicadchk;

    /** nullable persistent field */
    private String hanacotrachk;

    /** nullable persistent field */
    private String hanacmedcual;

    /** nullable persistent field */
    private String hanacalicual;

    /** nullable persistent field */
    private String hanacsusambcual;

    /** nullable persistent field */
    private String hanacsuspielcual;

    /** nullable persistent field */
    private String hanacpicadcual;

    /** nullable persistent field */
    private String hanacotracual;

    /** persistent field */
    private Date hanadfecreg;

    /** persistent field */
    private String hanacusuareg;

    /** nullable persistent field */
    private BigDecimal version;

    /** full constructor */
    public Chantalerg(Long hananconsulta, String hanacrefiere, String hanacdesc, String hanacmedchk, String hanacalichk, String hanacsusambchk, String hanacsuspielchk, String hanacpicadchk, String hanacotrachk, String hanacmedcual, String hanacalicual, String hanacsusambcual, String hanacsuspielcual, String hanacpicadcual, String hanacotracual, Date hanadfecreg, String hanacusuareg, BigDecimal version) {
        this.hananconsulta = hananconsulta;
        this.hanacrefiere = hanacrefiere;
        this.hanacdesc = hanacdesc;
        this.hanacmedchk = hanacmedchk;
        this.hanacalichk = hanacalichk;
        this.hanacsusambchk = hanacsusambchk;
        this.hanacsuspielchk = hanacsuspielchk;
        this.hanacpicadchk = hanacpicadchk;
        this.hanacotrachk = hanacotrachk;
        this.hanacmedcual = hanacmedcual;
        this.hanacalicual = hanacalicual;
        this.hanacsusambcual = hanacsusambcual;
        this.hanacsuspielcual = hanacsuspielcual;
        this.hanacpicadcual = hanacpicadcual;
        this.hanacotracual = hanacotracual;
        this.hanadfecreg = hanadfecreg;
        this.hanacusuareg = hanacusuareg;
        this.version = version;
    }

    /** default constructor */
    public Chantalerg() {
    }

    /** minimal constructor */
    public Chantalerg(Long hananconsulta, String hanacrefiere, Date hanadfecreg, String hanacusuareg) {
        this.hananconsulta = hananconsulta;
        this.hanacrefiere = hanacrefiere;
        this.hanadfecreg = hanadfecreg;
        this.hanacusuareg = hanacusuareg;
    }

    /** 
     * 		       Consulta asociada
     * 		    
     */
    public Long getHananconsulta() {
        return this.hananconsulta;
    }

    public void setHananconsulta(Long hananconsulta) {
        this.hananconsulta = hananconsulta;
    }

    public String getHanacrefiere() {
        return this.hanacrefiere;
    }

    public void setHanacrefiere(String hanacrefiere) {
        this.hanacrefiere = hanacrefiere;
    }

    public String getHanacdesc() {
        return this.hanacdesc;
    }

    public void setHanacdesc(String hanacdesc) {
        this.hanacdesc = hanacdesc;
    }

    public String getHanacmedchk() {
        return this.hanacmedchk;
    }

    public void setHanacmedchk(String hanacmedchk) {
        this.hanacmedchk = hanacmedchk;
    }

    public String getHanacalichk() {
        return this.hanacalichk;
    }

    public void setHanacalichk(String hanacalichk) {
        this.hanacalichk = hanacalichk;
    }

    public String getHanacsusambchk() {
        return this.hanacsusambchk;
    }

    public void setHanacsusambchk(String hanacsusambchk) {
        this.hanacsusambchk = hanacsusambchk;
    }

    public String getHanacsuspielchk() {
        return this.hanacsuspielchk;
    }

    public void setHanacsuspielchk(String hanacsuspielchk) {
        this.hanacsuspielchk = hanacsuspielchk;
    }

    public String getHanacpicadchk() {
        return this.hanacpicadchk;
    }

    public void setHanacpicadchk(String hanacpicadchk) {
        this.hanacpicadchk = hanacpicadchk;
    }

    public String getHanacotrachk() {
        return this.hanacotrachk;
    }

    public void setHanacotrachk(String hanacotrachk) {
        this.hanacotrachk = hanacotrachk;
    }

    public String getHanacmedcual() {
        return this.hanacmedcual;
    }

    public void setHanacmedcual(String hanacmedcual) {
        this.hanacmedcual = hanacmedcual;
    }

    public String getHanacalicual() {
        return this.hanacalicual;
    }

    public void setHanacalicual(String hanacalicual) {
        this.hanacalicual = hanacalicual;
    }

    public String getHanacsusambcual() {
        return this.hanacsusambcual;
    }

    public void setHanacsusambcual(String hanacsusambcual) {
        this.hanacsusambcual = hanacsusambcual;
    }

    public String getHanacsuspielcual() {
        return this.hanacsuspielcual;
    }

    public void setHanacsuspielcual(String hanacsuspielcual) {
        this.hanacsuspielcual = hanacsuspielcual;
    }

    public String getHanacpicadcual() {
        return this.hanacpicadcual;
    }

    public void setHanacpicadcual(String hanacpicadcual) {
        this.hanacpicadcual = hanacpicadcual;
    }

    public String getHanacotracual() {
        return this.hanacotracual;
    }

    public void setHanacotracual(String hanacotracual) {
        this.hanacotracual = hanacotracual;
    }

    public Date getHanadfecreg() {
        return this.hanadfecreg;
    }

    public void setHanadfecreg(Date hanadfecreg) {
        this.hanadfecreg = hanadfecreg;
    }

    public String getHanacusuareg() {
        return this.hanacusuareg;
    }

    public void setHanacusuareg(String hanacusuareg) {
        this.hanacusuareg = hanacusuareg;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hananconsulta", getHananconsulta())
            .toString();
    }

}
