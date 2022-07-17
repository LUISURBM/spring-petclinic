package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;

import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chpregucuest implements Serializable {

    /** identifier field */
    private Integer hpcncodigo;

    /** persistent field */
    private String hpccdescripcio;

    /** nullable persistent field */
    private Date hpcdfecregistr;

    /** nullable persistent field */
    private String hpccoperador;

    /** nullable persistent field */
    private Integer hpcnorden;

    /** nullable persistent field */
    private String hpcctipocuest;

    /** nullable persistent field */
    private BigDecimal version;

    /** Variable que almacena 'S' si la pregunta es afirmativa, 'N' de lo contrario */
    private String hpccrespuesta;

    /** Variable que almacena true si el usuario(a) Fuma*/
    private boolean mostrarFumar;

    /** Almacena la anotacion de cada pregunta */
    private String hpccanotacion;

    /** full constructor */
    public Chpregucuest(Integer hpcncodigo, String hpccdescripcio, 
                        Date hpcdfecregistr, String hpccoperador, 
                        Integer hpcnorden, String hpcctipocuest, 
                        BigDecimal version) {
        this.hpcncodigo = hpcncodigo;
        this.hpccdescripcio = hpccdescripcio;
        this.hpcdfecregistr = hpcdfecregistr;
        this.hpccoperador = hpccoperador;
        this.hpcnorden = hpcnorden;
        this.hpcctipocuest = hpcctipocuest;
        this.version = version;
    }

    /** default constructor */
    public Chpregucuest() {
    }

    /** minimal constructor */
    public Chpregucuest(Integer hpcncodigo, String hpccdescripcio) {
        this.hpcncodigo = hpcncodigo;
        this.hpccdescripcio = hpccdescripcio;
    }

    public Integer getHpcncodigo() {
        return this.hpcncodigo;
    }

    public void setHpcncodigo(Integer hpcncodigo) {
        this.hpcncodigo = hpcncodigo;
    }

    public String getHpccdescripcio() {
        return this.hpccdescripcio;
    }

    public void setHpccdescripcio(String hpccdescripcio) {
        this.hpccdescripcio = hpccdescripcio;
    }

    public Date getHpcdfecregistr() {
        return this.hpcdfecregistr;
    }

    public void setHpcdfecregistr(Date hpcdfecregistr) {
        this.hpcdfecregistr = hpcdfecregistr;
    }

    public String getHpccoperador() {
        return this.hpccoperador;
    }

    public void setHpccoperador(String hpccoperador) {
        this.hpccoperador = hpccoperador;
    }

    public Integer getHpcnorden() {
        return this.hpcnorden;
    }

    public void setHpcnorden(Integer hpcnorden) {
        this.hpcnorden = hpcnorden;
    }

    public String getHpcctipocuest() {
        return this.hpcctipocuest;
    }

    public void setHpcctipocuest(String hpcctipocuest) {
        this.hpcctipocuest = hpcctipocuest;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this).append("hpcncodigo", 
                                                getHpcncodigo()).toString();
    }

    /**
     * @param valueChangeEvent
     */
    public void setHpccrespuesta(ValueChangeEvent valueChangeEvent) {
        setHpccrespuesta((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setHpccrespuesta(String hpccrespuesta) {
        this.hpccrespuesta = hpccrespuesta;
    }


    public String getHpccrespuesta() {
        return hpccrespuesta;
    }

    public void setMostrarFumar(boolean mostrarFumar) {
        this.mostrarFumar = mostrarFumar;
    }

    public boolean isMostrarFumar() {
        return mostrarFumar;
    }

    public void changeFumar() {
        if (hpcncodigo != null && hpcncodigo.equals(12)) {
            if (hpccrespuesta.equals("S")) {
                mostrarFumar = true;
            } else {
                mostrarFumar = false;
            }
        }

    }

    public void setHpccanotacion(String hpccanotacion) {
        this.hpccanotacion = hpccanotacion;
    }

    public String getHpccanotacion() {
        return hpccanotacion;
    }
}
