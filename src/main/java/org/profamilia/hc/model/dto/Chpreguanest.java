package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;


/** @author Hibernate CodeGenerator */
public class Chpreguanest implements Serializable {

    /** identifier field */
    private Integer hpancodigo;

    /** persistent field */
    private String hpacdescripcio;

    /** nullable persistent field */
    private Date hpadfecregistr;

    /** nullable persistent field */
    private String hpacoperador;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private Integer hpanorden;

    /** Variable que almacena 'S' si la pregunta es afirmativa, 'N' de lo contrario */
    private String hpacrespuesta;

    /** Variable que almacena true si el usuario(a) Fuma*/
    private boolean mostrarFumar;

    /** Almacena la anotacion de cada pregunta */
    private String hpacanotacion;


    /** default constructor */
    public Chpreguanest() {
    }


    /**
     * @param hpancodigo
     */
    public void setHpancodigo(Integer hpancodigo) {
        this.hpancodigo = hpancodigo;
    }

    /**
     * @return
     */
    public Integer getHpancodigo() {
        return hpancodigo;
    }

    /**
     * @param hpacdescripcio
     */
    public void setHpacdescripcio(String hpacdescripcio) {
        this.hpacdescripcio = hpacdescripcio;
    }

    /**
     * @return
     */
    public String getHpacdescripcio() {
        return hpacdescripcio;
    }

    /**
     * @param hpadfecregistr
     */
    public void setHpadfecregistr(Date hpadfecregistr) {
        this.hpadfecregistr = hpadfecregistr;
    }

    /**
     * @return
     */
    public Date getHpadfecregistr() {
        return hpadfecregistr;
    }

    /**
     * @param hpacoperador
     */
    public void setHpacoperador(String hpacoperador) {
        this.hpacoperador = hpacoperador;
    }

    /**
     * @return
     */
    public String getHpacoperador() {
        return hpacoperador;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param hpacrespuesta
     */
    public void setHpacrespuesta(String hpacrespuesta) {
        this.hpacrespuesta = hpacrespuesta;
    }

    /**
     * @return
     */
    public String getHpacrespuesta() {
        return hpacrespuesta;
    }

    public void setMostrarFumar(boolean mostrarFumar) {
        this.mostrarFumar = mostrarFumar;
    }

    public boolean isMostrarFumar() {
        return mostrarFumar;
    }


    /**
     * @param valueChangeEvent
     */
    public void setHpacrespuesta(ValueChangeEvent valueChangeEvent) {
        setHpacrespuesta((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param hpanorden
     */
    public void setHpanorden(Integer hpanorden) {
        this.hpanorden = hpanorden;
    }

    /**
     * @return
     */
    public Integer getHpanorden() {
        return hpanorden;
    }

    /**
     * @param hpacanotacion
     */
    public void setHpacanotacion(String hpacanotacion) {
        this.hpacanotacion = hpacanotacion;
    }

    /**
     * @return
     */
    public String getHpacanotacion() {
        return hpacanotacion;
    }
}
