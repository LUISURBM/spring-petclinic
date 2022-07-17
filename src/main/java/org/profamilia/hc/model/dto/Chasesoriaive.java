package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chasesoriaive implements Serializable {

    /** identifier field */
    private Long hailconsulta;

    /** nullable persistent field */
    private Date haidfecregistr;

    /** nullable persistent field */
    private String haicoperador;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String haicobservacion;

    /** nullable persistent field */
    private String haicderecho;

    /** nullable persistent field */
    private String haicrespdeci;

    /** nullable persistent field */
    private String haicautodeci;

    /** nullable persistent field */
    private String haiccontgest;

    /** nullable persistent field */
    private String haicadopcion;

    /** nullable persistent field */
    private String haicintvolemb;

    /** full constructor */
    public Chasesoriaive(Long hailconsulta, Date haidfecregistr, String haicoperador, Integer version, String haicobservacion, String haicderecho, String haicrespdeci, String haicautodeci, String haiccontgest, String haicadopcion, String haicintvolemb) {
        this.hailconsulta = hailconsulta;
        this.haidfecregistr = haidfecregistr;
        this.haicoperador = haicoperador;
        this.version = version;
        this.haicobservacion = haicobservacion;
        this.haicderecho = haicderecho;
        this.haicrespdeci = haicrespdeci;
        this.haicautodeci = haicautodeci;
        this.haiccontgest = haiccontgest;
        this.haicadopcion = haicadopcion;
        this.haicintvolemb = haicintvolemb;
    }

    /** default constructor */
    public Chasesoriaive() {
    }

    /** minimal constructor */
    public Chasesoriaive(Long hailconsulta) {
        this.hailconsulta = hailconsulta;
    }

    public Long getHailconsulta() {
        return this.hailconsulta;
    }

    public void setHailconsulta(Long hailconsulta) {
        this.hailconsulta = hailconsulta;
    }

    public Date getHaidfecregistr() {
        return this.haidfecregistr;
    }

    public void setHaidfecregistr(Date haidfecregistr) {
        this.haidfecregistr = haidfecregistr;
    }

    public String getHaicoperador() {
        return this.haicoperador;
    }

    public void setHaicoperador(String haicoperador) {
        this.haicoperador = haicoperador;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getHaicobservacion() {
        return this.haicobservacion;
    }

    public void setHaicobservacion(String haicobservacion) {
        this.haicobservacion = haicobservacion;
    }

    public String getHaicderecho() {
        return this.haicderecho;
    }

    public void setHaicderecho(String haicderecho) {
        this.haicderecho = haicderecho;
    }

    public String getHaicrespdeci() {
        return this.haicrespdeci;
    }

    public void setHaicrespdeci(String haicrespdeci) {
        this.haicrespdeci = haicrespdeci;
    }

    public String getHaicautodeci() {
        return this.haicautodeci;
    }

    public void setHaicautodeci(String haicautodeci) {
        this.haicautodeci = haicautodeci;
    }

    public String getHaiccontgest() {
        return this.haiccontgest;
    }

    public void setHaiccontgest(String haiccontgest) {
        this.haiccontgest = haiccontgest;
    }

    public String getHaicadopcion() {
        return this.haicadopcion;
    }

    public void setHaicadopcion(String haicadopcion) {
        this.haicadopcion = haicadopcion;
    }

    public String getHaicintvolemb() {
        return this.haicintvolemb;
    }

    public void setHaicintvolemb(String haicintvolemb) {
        this.haicintvolemb = haicintvolemb;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hailconsulta", getHailconsulta())
            .toString();
    }

}
