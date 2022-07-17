package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chlogimpresi implements Serializable {

    /** identifier field */
    private Long hlilnumero;

    /** persistent field */
    private Long hlilusuario;

    /** persistent field */
    private Date hlidfecharegis;

    /** persistent field */
    private String hlicoperador;
    
    private Integer hlinclinica; 

    /** nullable persistent field */
    private Integer version;
    
    /** persistent field */
    private String hlicimpreconsu;
    
    /** persistent field */
    private String hlicmotiimpr;
    
    /** persistent field */
    private String hlicmotivoeps;
    
    /** persistent field */
    private String hlicmotivootro;
    
    /** persistent field */
    private Long hlilconsulta;


    /** default constructor */
    public Chlogimpresi() {
    }


    /**
     * @param hlilnumero
     */
    public void setHlilnumero(Long hlilnumero) {
        this.hlilnumero = hlilnumero;
    }

    /**
     * @return
     */
    public Long getHlilnumero() {
        return hlilnumero;
    }

    /**
     * @param hlilusuario
     */
    public void setHlilusuario(long hlilusuario) {
        this.hlilusuario = hlilusuario;
    }

    /**
     * @return
     */
    public long getHlilusuario() {
        return hlilusuario;
    }

    /**
     * @param hlidfecharegis
     */
    public void setHlidfecharegis(Date hlidfecharegis) {
        this.hlidfecharegis = hlidfecharegis;
    }

    /**
     * @return
     */
    public Date getHlidfecharegis() {
        return hlidfecharegis;
    }

    /**
     * @param hlicoperador
     */
    public void setHlicoperador(String hlicoperador) {
        this.hlicoperador = hlicoperador;
    }

    /**
     * @return
     */
    public String getHlicoperador() {
        return hlicoperador;
    }

    /**
     * @param hlinclinica
     */
    public void setHlinclinica(Integer hlinclinica) {
        this.hlinclinica = hlinclinica;
    }

    /**
     * @return
     */
    public Integer getHlinclinica() {
        return hlinclinica;
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
     * @param hlicimpreconsu
     */
    public void setHlicimpreconsu(String hlicimpreconsu) {
        this.hlicimpreconsu = hlicimpreconsu;
    }

    /**
     * @return
     */
    public String getHlicimpreconsu() {
        return hlicimpreconsu;
    }

    public void setHlicmotiimpr(String hlicmotiimpr) {
        this.hlicmotiimpr = hlicmotiimpr;
    }

    public String getHlicmotiimpr() {
        return hlicmotiimpr;
    }

    public void setHlicmotivoeps(String hlicmotivoeps) {
        this.hlicmotivoeps = hlicmotivoeps;
    }

    public String getHlicmotivoeps() {
        return hlicmotivoeps;
    }

    public void setHlicmotivootro(String hlicmotivootro) {
        this.hlicmotivootro = hlicmotivootro;
    }

    public String getHlicmotivootro() {
        return hlicmotivootro;
    }

    public void setHlilconsulta(Long hlilconsulta) {
        this.hlilconsulta = hlilconsulta;
    }

    public Long getHlilconsulta() {
        return hlilconsulta;
    }
}
