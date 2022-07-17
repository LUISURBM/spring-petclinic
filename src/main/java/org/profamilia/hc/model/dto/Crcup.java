package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Crcup implements Serializable {

    /** identifier field */
    private String crcuvcodigo;

    /** nullable persistent field */
    private String crcuvdescrip;

    /** nullable persistent field */
    private String crcuvusureg;

    /** nullable persistent field */
    private Date crcutfecreg;

    /** nullable persistent field */
    private String crcuvestado;

    /** nullable persistent field */
    private BigDecimal version;

    /** nullable persistent field */
    private String crcuccapitu;

    /** nullable persistent field */
    private String crcucexsecc;
    
    private boolean servicioSeleccionado;
    
    private boolean modoConsulta;

    /** full constructor */
    public Crcup(String crcuvcodigo, String crcuvdescrip, String crcuvusureg, Date crcutfecreg, String crcuvestado, BigDecimal version, String crcuccapitu, String crcucexsecc) {
        this.crcuvcodigo = crcuvcodigo;
        this.crcuvdescrip = crcuvdescrip;
        this.crcuvusureg = crcuvusureg;
        this.crcutfecreg = crcutfecreg;
        this.crcuvestado = crcuvestado;
        this.version = version;
        this.crcuccapitu = crcuccapitu;
        this.crcucexsecc = crcucexsecc;
    }

    /** default constructor */
    public Crcup() {
    }

    /** minimal constructor */
    public Crcup(String crcuvcodigo) {
        this.crcuvcodigo = crcuvcodigo;
    }

    /** 
     * 		       PRIMARIA
     * CODIGO CUP
     * 		    
     */
    public String getCrcuvcodigo() {
        return this.crcuvcodigo;
    }

    public void setCrcuvcodigo(String crcuvcodigo) {
        this.crcuvcodigo = crcuvcodigo;
    }

    public String getCrcuvdescrip() {
        return this.crcuvdescrip;
    }

    public void setCrcuvdescrip(String crcuvdescrip) {
        this.crcuvdescrip = crcuvdescrip;
    }

    public String getCrcuvusureg() {
        return this.crcuvusureg;
    }

    public void setCrcuvusureg(String crcuvusureg) {
        this.crcuvusureg = crcuvusureg;
    }

    public Date getCrcutfecreg() {
        return this.crcutfecreg;
    }

    public void setCrcutfecreg(Date crcutfecreg) {
        this.crcutfecreg = crcutfecreg;
    }

    public String getCrcuvestado() {
        return this.crcuvestado;
    }

    public void setCrcuvestado(String crcuvestado) {
        this.crcuvestado = crcuvestado;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public String getCrcuccapitu() {
        return this.crcuccapitu;
    }

    public void setCrcuccapitu(String crcuccapitu) {
        this.crcuccapitu = crcuccapitu;
    }

    public String getCrcucexsecc() {
        return this.crcucexsecc;
    }

    public void setCrcucexsecc(String crcucexsecc) {
        this.crcucexsecc = crcucexsecc;
    }
    

    public String toString() {
        return new ToStringBuilder(this)
            .append("crcuvcodigo", getCrcuvcodigo())
            .toString();
    }

    public void setServicioSeleccionado(boolean servicioSeleccionado) {
        this.servicioSeleccionado = servicioSeleccionado;
    }

    public boolean isServicioSeleccionado() {
        return servicioSeleccionado;
    }


    public void setModoConsulta(boolean modoConsulta) {
        this.modoConsulta = modoConsulta;
    }

    public boolean isModoConsulta() {
        return modoConsulta;
    }
}
