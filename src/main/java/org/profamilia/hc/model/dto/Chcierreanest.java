package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chcierreanest implements Serializable {

    /** identifier field */
    private Long hcilnumero;

    /** persistent field */
    private String hcicestadsalir;
        
    /** persistent field */
    private String hciccomplicaci;

    /** persistent field */
    private String hcicobsercompl;
    
    /** persistent field */
    private String hcicobservacio;
    
     /** persistent field */
    private String hcicoperador;
    
    /** persistent field */
    private Date hcidfecregistr;
    
     /** persistent field */
    private Integer version;
    

  
   
    
    
    /** default constructor */
    public Chcierreanest() {
    }


    public void setHcilnumero(Long hcilnumero) {
        this.hcilnumero = hcilnumero;
    }

    public Long getHcilnumero() {
        return hcilnumero;
    }

    public void setHcicestadsalir(String hcicestadsalir) {
        this.hcicestadsalir = hcicestadsalir;
    }

    public String getHcicestadsalir() {
        return hcicestadsalir;
    }

    public void setHciccomplicaci(String hciccomplicaci) {
        this.hciccomplicaci = hciccomplicaci;
    }

    public String getHciccomplicaci() {
        return hciccomplicaci;
    }

    public void setHcicobsercompl(String hcicobsercompl) {
        this.hcicobsercompl = hcicobsercompl;
    }

    public String getHcicobsercompl() {
        return hcicobsercompl;
    }

    public void setHcicobservacio(String hcicobservacio) {
        this.hcicobservacio = hcicobservacio;
    }

    public String getHcicobservacio() {
        return hcicobservacio;
    }

    public void setHcicoperador(String hcicoperador) {
        this.hcicoperador = hcicoperador;
    }

    public String getHcicoperador() {
        return hcicoperador;
    }

    public void setHcidfecregistr(Date hcidfecregistr) {
        this.hcidfecregistr = hcidfecregistr;
    }

    public Date getHcidfecregistr() {
        return hcidfecregistr;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }
}
