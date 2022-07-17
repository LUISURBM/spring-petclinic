package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chsaludtotal implements Serializable {

    /** identifier field */
    private Long contrato;

    /** identifier field */
    private String tipoiden;

    /** identifier field */
    private BigDecimal numiden;

    /** identifier field */
    private String primerapellido;

    /** identifier field */
    private String segundoapellido;

    /** identifier field */
    private String nombres;

    /** identifier field */
    private Date fechanac;

    /** identifier field */
    private Integer edad;

    /** identifier field */
    private String sucursal;

    /** identifier field */
    private String numerocelular;

    /** identifier field */
    private String direccion;

    /** identifier field */
    private String otrocontrato;

    /** full constructor */
    public Chsaludtotal(Long contrato, String tipoiden, BigDecimal numiden, String primerapellido, String segundoapellido, String nombres, Date fechanac, Integer edad, String sucursal, String numerocelular, String direccion, String otrocontrato) {
        this.contrato = contrato;
        this.tipoiden = tipoiden;
        this.numiden = numiden;
        this.primerapellido = primerapellido;
        this.segundoapellido = segundoapellido;
        this.nombres = nombres;
        this.fechanac = fechanac;
        this.edad = edad;
        this.sucursal = sucursal;
        this.numerocelular = numerocelular;
        this.direccion = direccion;
        this.otrocontrato = otrocontrato;
    }

    /** default constructor */
    public Chsaludtotal() {
    }

    public Long getContrato() {
        return this.contrato;
    }

    public void setContrato(Long contrato) {
        this.contrato = contrato;
    }

    public String getTipoiden() {
        return this.tipoiden;
    }

    public void setTipoiden(String tipoiden) {
        this.tipoiden = tipoiden;
    }

    public BigDecimal getNumiden() {
        return this.numiden;
    }

    public void setNumiden(BigDecimal numiden) {
        this.numiden = numiden;
    }

    public String getPrimerapellido() {
        return this.primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return this.segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getFechanac() {
        return this.fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public Integer getEdad() {
        return this.edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSucursal() {
        return this.sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getNumerocelular() {
        return this.numerocelular;
    }

    public void setNumerocelular(String numerocelular) {
        this.numerocelular = numerocelular;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getOtrocontrato() {
        return this.otrocontrato;
    }

    public void setOtrocontrato(String otrocontrato) {
        this.otrocontrato = otrocontrato;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("contrato", getContrato())
            .append("tipoiden", getTipoiden())
            .append("numiden", getNumiden())
            .append("primerapellido", getPrimerapellido())
            .append("segundoapellido", getSegundoapellido())
            .append("nombres", getNombres())
            .append("fechanac", getFechanac())
            .append("edad", getEdad())
            .append("sucursal", getSucursal())
            .append("numerocelular", getNumerocelular())
            .append("direccion", getDireccion())
            .append("otrocontrato", getOtrocontrato())
            .toString();
    }

}
