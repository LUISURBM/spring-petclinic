package org.profamilia.hc.model.dto;

import java.util.Date;

/**
 * Cpprograma generated by hbm2java
 */
public class

Cpprograma implements java.io.Serializable {

    private Integer cpgncodigo;
    private String cpgcnombre;
    private String cpgcestado;
    private Date cpgdfecreg;
    private String cpgcusuar;

    private Integer version;

    /**
     * @return the version
     */
    public final Integer getVersion() {
        return version;
    }

    /**
     * @param version
     *            the version to set
     */
    public final void setVersion(Integer version) {
        this.version = version;
    }

    // Constructors

    /** default constructor */
    public Cpprograma() {
    }

    /** constructor with id */
    public
    // HS == short

    Cpprograma(Integer cpgncodigo) {
        this.cpgncodigo = cpgncodigo;
    }

    // HS SEPARADOR CONSTRUCTOR

    // Property accessors

    public Integer getCpgncodigo() {
        return this.cpgncodigo;
    }

    public void setCpgncodigo(Integer cpgncodigo) {
        this.cpgncodigo = cpgncodigo;
    }

    public String getCpgcnombre() {
        return this.cpgcnombre;
    }

    public void setCpgcnombre(String cpgcnombre) {
        this.cpgcnombre = cpgcnombre;
    }

    public String getCpgcestado() {
        return this.cpgcestado;
    }

    public void setCpgcestado(String cpgcestado) {
        this.cpgcestado = cpgcestado;
    }

    public Date getCpgdfecreg() {
        return this.cpgdfecreg;
    }

    public void setCpgdfecreg(Date cpgdfecreg) {
        this.cpgdfecreg = cpgdfecreg;
    }

    public void setCpgcusuar(String cpgcusuar) {
        this.cpgcusuar = cpgcusuar;
    }

    public String getCpgcusuar() {
        return cpgcusuar;
    }
    
    // no tiene llave compuesta.
}