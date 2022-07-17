package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.profamilia.hc.model.BasicBean;


/** @author Hibernate CodeGenerator */
public class Chentregapatol extends BasicBean implements Serializable {

    /** identifier field */
    private Long heplidentificador;

    /** persistent field */
    private Date hepdfechaenvio;

    /** persistent field */
    private Integer hepnlablectura;

    /** persistent field */
    private Integer hepnclinica;

    /** persistent field */
    private String hepcoperador;

    /** persistent field */
    private Date hepdfechamod;

    /** persistent field */
    private Set chdetaentpatols  = new HashSet(0);
    
    // Datos Envio Centro de Origen
    
    /** persistent field */
    private Date hepdenvioorig;  
    
    /** persistent field */
    private String hepcempenvio;   
    
    /** persistent field */
    private String hepcnumguia;   
    
    /** persistent field */
    private String hepcobservenvio;   
    

    /** default constructor */
    public Chentregapatol() {
    }

    /** 
     * 		       Identificador del listado de patologias que se entregan para su analisis.
     * 		    
     */
    public Long getHeplidentificador() {
        return this.heplidentificador;
    }

    public void setHeplidentificador(Long heplidentificador) {
        this.heplidentificador = heplidentificador;
    }

    public Date getHepdfechaenvio() {
        return this.hepdfechaenvio;
    }

    public void setHepdfechaenvio(Date hepdfechaenvio) {
        this.hepdfechaenvio = hepdfechaenvio;
    }

    public Integer getHepnlablectura() {
        return this.hepnlablectura;
    }

    public void setHepnlablectura(Integer hepnlablectura) {
        this.hepnlablectura = hepnlablectura;
    }

    public Integer getHepnclinica() {
        return this.hepnclinica;
    }

    public void setHepnclinica(Integer hepnclinica) {
        this.hepnclinica = hepnclinica;
    }

    public String getHepcoperador() {
        return this.hepcoperador;
    }

    public void setHepcoperador(String hepcoperador) {
        this.hepcoperador = hepcoperador;
    }

    public Date getHepdfechamod() {
        return this.hepdfechamod;
    }

    public void setHepdfechamod(Date hepdfechamod) {
        this.hepdfechamod = hepdfechamod;
    }

    public Set getChdetaentpatols() {
        return this.chdetaentpatols;
    }

    public void setChdetaentpatols(Set chdetaentpatols) {
        this.chdetaentpatols = chdetaentpatols;
    }

    public void setHepdenvioorig(Date hepdenvioorig) {
        this.hepdenvioorig = hepdenvioorig;
    }

    public Date getHepdenvioorig() {
        return hepdenvioorig;
    }

    public void setHepcempenvio(String hepcempenvio) {
        this.hepcempenvio = hepcempenvio;
    }

    public String getHepcempenvio() {
        return hepcempenvio;
    }

    public void setHepcnumguia(String hepcnumguia) {
        this.hepcnumguia = hepcnumguia;
    }

    public String getHepcnumguia() {
        return hepcnumguia;
    }

    public void setHepcobservenvio(String hepcobservenvio) {
        this.hepcobservenvio = hepcobservenvio;
    }

    public String getHepcobservenvio() {
        return hepcobservenvio;
    }
}
