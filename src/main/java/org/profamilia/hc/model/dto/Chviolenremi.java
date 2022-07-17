package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chviolenremi implements Serializable {

    /** identifier field */
    private String hvrccodigo;

    /** nullable persistent field */
    private String hvrcdescripcio;

    /** nullable persistent field */
    private String hvrcinterno;

    /** nullable persistent field */
    private Date hvrdfecregistr;

    /** nullable persistent field */
    private String hvrcoperador;

    /** nullable persistent field */
    private Integer version;
    
    private String hvrcestado;


    /** default constructor */
    public Chviolenremi() {
    }


    public void setHvrccodigo(String hvrccodigo) {
        this.hvrccodigo = hvrccodigo;
    }

    public String getHvrccodigo() {
        return hvrccodigo;
    }

    public void setHvrcdescripcio(String hvrcdescripcio) {
        this.hvrcdescripcio = hvrcdescripcio;
    }

    public String getHvrcdescripcio() {
        return hvrcdescripcio;
    }

    public void setHvrcinterno(String hvrcinterno) {
        this.hvrcinterno = hvrcinterno;
    }

    public String getHvrcinterno() {
        return hvrcinterno;
    }

    public void setHvrdfecregistr(Date hvrdfecregistr) {
        this.hvrdfecregistr = hvrdfecregistr;
    }

    public Date getHvrdfecregistr() {
        return hvrdfecregistr;
    }

    public void setHvrcoperador(String hvrcoperador) {
        this.hvrcoperador = hvrcoperador;
    }

    public String getHvrcoperador() {
        return hvrcoperador;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHvrcestado(String hvrcestado) {
        this.hvrcestado = hvrcestado;
    }

    public String getHvrcestado() {
        return hvrcestado;
    }
}
