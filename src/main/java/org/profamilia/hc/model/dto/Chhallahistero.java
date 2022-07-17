package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chhallahistero implements Serializable {

    /** identifier field */
    private Long hhhlconsulta;

    /** nullable persistent field */
    private String hhhctiposerv;

    /** nullable persistent field */
    private Date hhhdfechregi;

    /** nullable persistent field */
    private String hhhcusuaregi;

    /** nullable persistent field */
    private Long hhhlnumeusua;

    /** nullable persistent field */
    private String hhhchallazgo;

    /** nullable persistent field */
    private String hhhcvaginosc;

    /** nullable persistent field */
    private String hhhccancervi;

    /** nullable persistent field */
    private String hhhcaspeendo;

    /** nullable persistent field */
    private String hhhcostituba;

    /** nullable persistent field */
    private String hhhcmasaintr;

    /** nullable persistent field */
    private String hhhcotros;

    /** nullable persistent field */
    private Integer version;

    /** full constructor */
    public Chhallahistero(Long hhhlconsulta, String hhhctiposerv, Date hhhdfechregi, String hhhcusuaregi, Long hhhlnumeusua, String hhhchallazgo, String hhhcvaginosc, String hhhccancervi, String hhhcaspeendo, String hhhcostituba, String hhhcmasaintr, String hhhcotros, Integer version) {
        this.hhhlconsulta = hhhlconsulta;
        this.hhhctiposerv = hhhctiposerv;
        this.hhhdfechregi = hhhdfechregi;
        this.hhhcusuaregi = hhhcusuaregi;
        this.hhhlnumeusua = hhhlnumeusua;
        this.hhhchallazgo = hhhchallazgo;
        this.hhhcvaginosc = hhhcvaginosc;
        this.hhhccancervi = hhhccancervi;
        this.hhhcaspeendo = hhhcaspeendo;
        this.hhhcostituba = hhhcostituba;
        this.hhhcmasaintr = hhhcmasaintr;
        this.hhhcotros = hhhcotros;
        this.version = version;
    }

    /** default constructor */
    public Chhallahistero() {
    }

    /** minimal constructor */
    public Chhallahistero(Long hhhlconsulta) {
        this.hhhlconsulta = hhhlconsulta;
    }

    /** 
     * 		       NUMERO DE CONSULTA
     * 		    
     */
    public Long getHhhlconsulta() {
        return this.hhhlconsulta;
    }

    public void setHhhlconsulta(Long hhhlconsulta) {
        this.hhhlconsulta = hhhlconsulta;
    }

    public String getHhhctiposerv() {
        return this.hhhctiposerv;
    }

    public void setHhhctiposerv(String hhhctiposerv) {
        this.hhhctiposerv = hhhctiposerv;
    }

    public Date getHhhdfechregi() {
        return this.hhhdfechregi;
    }

    public void setHhhdfechregi(Date hhhdfechregi) {
        this.hhhdfechregi = hhhdfechregi;
    }

    public String getHhhcusuaregi() {
        return this.hhhcusuaregi;
    }

    public void setHhhcusuaregi(String hhhcusuaregi) {
        this.hhhcusuaregi = hhhcusuaregi;
    }

    public Long getHhhlnumeusua() {
        return this.hhhlnumeusua;
    }

    public void setHhhlnumeusua(Long hhhlnumeusua) {
        this.hhhlnumeusua = hhhlnumeusua;
    }

    public String getHhhchallazgo() {
        return this.hhhchallazgo;
    }

    public void setHhhchallazgo(String hhhchallazgo) {
        this.hhhchallazgo = hhhchallazgo;
    }

    public String getHhhcvaginosc() {
        return this.hhhcvaginosc;
    }

    public void setHhhcvaginosc(String hhhcvaginosc) {
        this.hhhcvaginosc = hhhcvaginosc;
    }

    public String getHhhccancervi() {
        return this.hhhccancervi;
    }

    public void setHhhccancervi(String hhhccancervi) {
        this.hhhccancervi = hhhccancervi;
    }

    public String getHhhcaspeendo() {
        return this.hhhcaspeendo;
    }

    public void setHhhcaspeendo(String hhhcaspeendo) {
        this.hhhcaspeendo = hhhcaspeendo;
    }

    public String getHhhcostituba() {
        return this.hhhcostituba;
    }

    public void setHhhcostituba(String hhhcostituba) {
        this.hhhcostituba = hhhcostituba;
    }

    public String getHhhcmasaintr() {
        return this.hhhcmasaintr;
    }

    public void setHhhcmasaintr(String hhhcmasaintr) {
        this.hhhcmasaintr = hhhcmasaintr;
    }

    public String getHhhcotros() {
        return this.hhhcotros;
    }

    public void setHhhcotros(String hhhcotros) {
        this.hhhcotros = hhhcotros;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hhhlconsulta", getHhhlconsulta())
            .toString();
    }

}
