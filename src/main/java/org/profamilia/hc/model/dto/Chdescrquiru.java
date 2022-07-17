package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;
import java.util.Set;


/** @author Hibernate CodeGenerator */
public class Chdescrquiru implements Serializable {

    /** identifier field */
    private Long hdqlnumero;

    /** nullable persistent field */
    private Chusuario hdqlusuario;

    /** persistent field */
    private Integer hdqnambito;

    /** persistent field */
    private Integer hdqnformareali;

    /** persistent field */
    private Date hdqdfechaproce;

    /** nullable persistent field */
    private Integer hdqnsalacirugi;

    /** nullable persistent field */
    private Integer hdqnclinica;

    /** nullable persistent field */
    private String hdqcestado;

    /** nullable persistent field */
    private Date hdqdfecregistr;

    /** nullable persistent field */
    private String hdqcoperador;

    /** nullable persistent field */
    private Integer version;
    
    /** persistent field */
    private Set<Chdetaldescr> chdetaldescrs;


    /** default constructor */
    public Chdescrquiru() {
    }


    /**
     * @param hdqlnumero
     */
    public void setHdqlnumero(Long hdqlnumero) {
        this.hdqlnumero = hdqlnumero;
    }

    /**
     * @return
     */
    public Long getHdqlnumero() {
        return hdqlnumero;
    }

    /**
     * @param hdqlusuario
     */
    public void setHdqlusuario(Chusuario hdqlusuario) {
        this.hdqlusuario = hdqlusuario;
    }

    /**
     * @return
     */
    public Chusuario getHdqlusuario() {
        return hdqlusuario;
    }

    /**
     * @param hdqnambito
     */
    public void setHdqnambito(Integer hdqnambito) {
        this.hdqnambito = hdqnambito;
    }

    /**
     * @return
     */
    public Integer getHdqnambito() {
        return hdqnambito;
    }

    /**
     * @param hdqnformareali
     */
    public void setHdqnformareali(Integer hdqnformareali) {
        this.hdqnformareali = hdqnformareali;
    }

    /**
     * @return
     */
    public Integer getHdqnformareali() {
        return hdqnformareali;
    }

    /**
     * @param hdqdfechaproce
     */
    public void setHdqdfechaproce(Date hdqdfechaproce) {
        this.hdqdfechaproce = hdqdfechaproce;
    }

    /**
     * @return
     */
    public Date getHdqdfechaproce() {
        return hdqdfechaproce;
    }

    /**
     * @param hdqnsalacirugi
     */
    public void setHdqnsalacirugi(Integer hdqnsalacirugi) {
        this.hdqnsalacirugi = hdqnsalacirugi;
    }

    /**
     * @return
     */
    public Integer getHdqnsalacirugi() {
        return hdqnsalacirugi;
    }

    /**
     * @param hdqnclinica
     */
    public void setHdqnclinica(Integer hdqnclinica) {
        this.hdqnclinica = hdqnclinica;
    }

    /**
     * @return
     */
    public Integer getHdqnclinica() {
        return hdqnclinica;
    }

    /**
     * @param hdqcestado
     */
    public void setHdqcestado(String hdqcestado) {
        this.hdqcestado = hdqcestado;
    }

    /**
     * @return
     */
    public String getHdqcestado() {
        return hdqcestado;
    }

    /**
     * @param hdqdfecregistr
     */
    public void setHdqdfecregistr(Date hdqdfecregistr) {
        this.hdqdfecregistr = hdqdfecregistr;
    }

    /**
     * @return
     */
    public Date getHdqdfecregistr() {
        return hdqdfecregistr;
    }

    /**
     * @param hdqcoperador
     */
    public void setHdqcoperador(String hdqcoperador) {
        this.hdqcoperador = hdqcoperador;
    }

    /**
     * @return
     */
    public String getHdqcoperador() {
        return hdqcoperador;
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
     * @param chdetaldescrs
     */
    public void setChdetaldescrs(Set<Chdetaldescr> chdetaldescrs) {
        this.chdetaldescrs = chdetaldescrs;
    }

    /**
     * @return
     */
    public Set<Chdetaldescr> getChdetaldescrs() {
        return chdetaldescrs;
    }
}
