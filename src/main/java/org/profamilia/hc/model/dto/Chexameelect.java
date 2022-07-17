package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chexameelect implements Serializable {

    /** identifier field */
    private ChexameelectPK id;

    /** nullable persistent field */
    private String heecobservacio;

    /** nullable persistent field */
    private String heecoperador;

    /** nullable persistent field */
    private Date heedfecregistr;

    /** persistent field */
    private Cpservicio cpservicio;

    /** nullable persistent field */
    private Integer version;

    private boolean modoconsulta;


    /** default constructor */
    public Chexameelect() {
    }


    /**
     * @param id
     */
    public void setId(ChexameelectPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChexameelectPK getId() {
        return id;
    }

    /**
     * @param heecobservacio
     */
    public void setHeecobservacio(String heecobservacio) {
        this.heecobservacio = heecobservacio;
    }

    /**
     * @return
     */
    public String getHeecobservacio() {
        return heecobservacio;
    }

    /**
     * @param heecoperador
     */
    public void setHeecoperador(String heecoperador) {
        this.heecoperador = heecoperador;
    }

    /**
     * @return
     */
    public String getHeecoperador() {
        return heecoperador;
    }

    /**
     * @param heedfecregistr
     */
    public void setHeedfecregistr(Date heedfecregistr) {
        this.heedfecregistr = heedfecregistr;
    }

    /**
     * @return
     */
    public Date getHeedfecregistr() {
        return heedfecregistr;
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
     * @param cpservicio
     */
    public void setCpservicio(Cpservicio cpservicio) {
        this.cpservicio = cpservicio;
    }

    /**
     * @return
     */
    public Cpservicio getCpservicio() {
        return cpservicio;
    }

    /**
     * @param modoconsulta
     */
    public void setModoconsulta(boolean modoconsulta) {
        this.modoconsulta = modoconsulta;
    }

    /**
     * @return
     */
    public boolean isModoconsulta() {
        modoconsulta = false;
        if (this.id != null && this.id.getHeelconsulta() != null) {
            modoconsulta = true;
        }
        return modoconsulta;
    }
}
