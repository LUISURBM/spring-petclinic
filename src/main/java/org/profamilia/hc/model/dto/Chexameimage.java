package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chexameimage implements Serializable {

    /** identifier field */
    private ChexameimagePK id;

    /** nullable persistent field */
    private String heicobservacio;

    /** nullable persistent field */
    private String heicoperador;

    /** nullable persistent field */
    private Date heidfecregistr;

    /** nullable persistent field */
    private Integer version;

    /** persistent field */
    private Cpservicio cpservicio;

    private boolean modoconsulta;


    /** default constructor */
    public Chexameimage() {
    }


    public void setId(ChexameimagePK id) {
        this.id = id;
    }

    public ChexameimagePK getId() {
        return id;
    }

    public void setHeicobservacio(String heicobservacio) {
        this.heicobservacio = heicobservacio;
    }

    public String getHeicobservacio() {
        return heicobservacio;
    }

    public void setHeicoperador(String heicoperador) {
        this.heicoperador = heicoperador;
    }

    public String getHeicoperador() {
        return heicoperador;
    }

    public void setHeidfecregistr(Date heidfecregistr) {
        this.heidfecregistr = heidfecregistr;
    }

    public Date getHeidfecregistr() {
        return heidfecregistr;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setCpservicio(Cpservicio cpservicio) {
        this.cpservicio = cpservicio;
    }

    public Cpservicio getCpservicio() {
        return cpservicio;
    }

    public void setModoconsulta(boolean modoconsulta) {
        this.modoconsulta = modoconsulta;
    }

    public boolean isModoconsulta() {
        modoconsulta = false;
        if (this.id != null && this.id.getHeilconsulta() != null) {
            modoconsulta = true;
        }
        return modoconsulta;
    }
}
