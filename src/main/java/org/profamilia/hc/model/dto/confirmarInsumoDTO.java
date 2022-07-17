package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;


public class confirmarInsumoDTO implements Serializable {

    private String hricservicio;

    private String hricobserv;

    private Date hridfecregistr;

    private String hricutilizo;

    private Long version;
    
    private String nombreServicio;
    
    private Boolean consumo;
    
    private Long hrinconsulta;

    private Long hrinconsecuti;

    /** full constructor */
    public confirmarInsumoDTO(String hricservicio, String hricobserv, Date hridfecregistr, String hricutilizo, Long version,String nombreServicio,Boolean consumo,Long hrinconsulta,Long hrinconsecuti) {
        this.hricservicio = hricservicio;
        this.hricobserv = hricobserv;
        this.hridfecregistr = hridfecregistr;
        this.hricutilizo = hricutilizo;
        this.version = version;
        this.nombreServicio=nombreServicio;
        this.consumo = consumo;
        this.hrinconsulta = hrinconsulta;
        this.hrinconsecuti = hrinconsecuti;
        
    }


    public confirmarInsumoDTO() {
    }


    public void setHricservicio(String hricservicio) {
        this.hricservicio = hricservicio;
    }

    public String getHricservicio() {
        return hricservicio;
    }

    public void setHricobserv(String hricobserv) {
        this.hricobserv = hricobserv;
    }

    public String getHricobserv() {
        return hricobserv;
    }

    public void setHridfecregistr(Date hridfecregistr) {
        this.hridfecregistr = hridfecregistr;
    }

    public Date getHridfecregistr() {
        return hridfecregistr;
    }

    public void setHricutilizo(String hricutilizo) {
        this.hricutilizo = hricutilizo;
    }

    public String getHricutilizo() {
        return hricutilizo;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getVersion() {
        return version;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setConsumo(Boolean consumo) {
        this.consumo = consumo;
    }

    public Boolean getConsumo() {
        return consumo;
    }

    public void setHrinconsulta(Long hrinconsulta) {
        this.hrinconsulta = hrinconsulta;
    }

    public Long getHrinconsulta() {
        return hrinconsulta;
    }

    public void setHrinconsecuti(Long hrinconsecuti) {
        this.hrinconsecuti = hrinconsecuti;
    }

    public Long getHrinconsecuti() {
        return hrinconsecuti;
    }
}
