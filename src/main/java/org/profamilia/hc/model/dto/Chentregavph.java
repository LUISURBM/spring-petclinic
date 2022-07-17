package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chentregavph implements Serializable {

    /** identifier field */
    private Long hevlidentificador;

    /** persistent field */
    private Date hevdfechaenvio;

    /** persistent field */
    private Date hevdfechamod;

    /** persistent field */
    private Long hevnlablectura;

    /** persistent field */
    private Integer hevnclinica;

    /** persistent field */
    private String hevcoperador;

    /** persistent field */
    private Set chdetaentvphs;

    /** full constructor */
    public Chentregavph(Long hevlidentificador, Date hevdfechaenvio, Date hevdfechamod, Long hevnlablectura, Integer hevnclinica, String hevcoperador, Set chdetaentvphs) {
        this.hevlidentificador = hevlidentificador;
        this.hevdfechaenvio = hevdfechaenvio;
        this.hevdfechamod = hevdfechamod;
        this.hevnlablectura = hevnlablectura;
        this.hevnclinica = hevnclinica;
        this.hevcoperador = hevcoperador;
        this.chdetaentvphs = chdetaentvphs;
    }

    /** default constructor */
    public Chentregavph() {
    }

    /** 
     * 		       Identificador del listado de vphs que se entregan para su analisis.
     * 		    
     */
    public Long getHevlidentificador() {
        return this.hevlidentificador;
    }

    public void setHevlidentificador(Long hevlidentificador) {
        this.hevlidentificador = hevlidentificador;
    }

    public Date getHevdfechaenvio() {
        return this.hevdfechaenvio;
    }

    public void setHevdfechaenvio(Date hevdfechaenvio) {
        this.hevdfechaenvio = hevdfechaenvio;
    }

    public Date getHevdfechamod() {
        return this.hevdfechamod;
    }

    public void setHevdfechamod(Date hevdfechamod) {
        this.hevdfechamod = hevdfechamod;
    }

    public Long getHevnlablectura() {
        return this.hevnlablectura;
    }

    public void setHevnlablectura(Long hevnlablectura) {
        this.hevnlablectura = hevnlablectura;
    }

    public Integer getHevnclinica() {
        return this.hevnclinica;
    }

    public void setHevnclinica(Integer hevnclinica) {
        this.hevnclinica = hevnclinica;
    }

    public String getHevcoperador() {
        return this.hevcoperador;
    }

    public void setHevcoperador(String hevcoperador) {
        this.hevcoperador = hevcoperador;
    }

    public Set getChdetaentvphs() {
        return this.chdetaentvphs;
    }

    public void setChdetaentvphs(Set chdetaentvphs) {
        this.chdetaentvphs = chdetaentvphs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hevlidentificador", getHevlidentificador())
            .toString();
    }

}
