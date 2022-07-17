package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chexamelabor implements Serializable {

    /** identifier field */
    private ChexamelaborPK id;

    /** nullable persistent field */
    private String helcobservacio;

    /** nullable persistent field */
    private String helcoperador;

    /** nullable persistent field */
    private Date heldfecregistr;

    /** nullable persistent field */
    private Integer version;

    /** persistent field */
    private Cpservicio cpservicio;

    private boolean modoconsulta;
    
    private String servicioLiberado;


    /** default constructor */
    public Chexamelabor() {
    }


    /**
     * @param id
     */
    public void setId(ChexamelaborPK id) {
        this.id = id;
    }

    public ChexamelaborPK getId() {
        return id;
    }

    public void setHelcobservacio(String helcobservacio) {
        this.helcobservacio = helcobservacio;
    }

    public String getHelcobservacio() {
        return helcobservacio;
    }

    public void setHelcoperador(String helcoperador) {
        this.helcoperador = helcoperador;
    }

    public String getHelcoperador() {
        return helcoperador;
    }

    public void setHeldfecregistr(Date heldfecregistr) {
        this.heldfecregistr = heldfecregistr;
    }

    public Date getHeldfecregistr() {
        return heldfecregistr;
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
        if (this.id != null && this.id.getHellconsulta() != null) {
            modoconsulta = true;
        }
        return modoconsulta;
    }

    public void setServicioLiberado(String servicioLiberado) {
        this.servicioLiberado = servicioLiberado;
    }

    public String getServicioLiberado() {
        return servicioLiberado;
    }
}
