package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chtiempaten implements Serializable {

    /** identifier field */
    private Integer ctanconsec;

    /** persistent field */
    private Long ctanconsulta;

    /** persistent field */
    private Date ctadhora;

    /** persistent field */
    private String ctacetapa;

    /** nullable persistent field */
    private Integer ctancausa;

    /** persistent field */
    private Date ctadfechregi;

    /** persistent field */
    private Integer ctancodmed;

    /** persistent field */
    private String ctacusuareg;

    /** nullable persistent field */
    private Integer version;
    
    /** persistent field */
    private String ctacestado;

    /** full constructor */
    public Chtiempaten(Integer ctanconsec, Long ctanconsulta, Date ctadhora, String ctacetapa, Integer ctancausa, Date ctadfechregi, Integer ctancodmed, String ctacusuareg, Integer version, String ctacestado) {
        this.ctanconsec = ctanconsec;
        this.ctanconsulta = ctanconsulta;
        this.ctadhora = ctadhora;
        this.ctacetapa = ctacetapa;
        this.ctancausa = ctancausa;
        this.ctadfechregi = ctadfechregi;
        this.ctancodmed = ctancodmed;
        this.ctacusuareg = ctacusuareg;
        this.version = version;
        this.ctacestado = ctacestado;
    }

    /** default constructor */
    public Chtiempaten() {
    }

    /** minimal constructor */
    public Chtiempaten(Integer ctanconsec, Long ctanconsulta, Date ctadhora, String ctacetapa, Date ctadfechregi, Integer ctancodmed, String ctacusuareg,String ctacestado) {
        this.ctanconsec = ctanconsec;
        this.ctanconsulta = ctanconsulta;
        this.ctadhora = ctadhora;
        this.ctacetapa = ctacetapa;
        this.ctadfechregi = ctadfechregi;
        this.ctancodmed = ctancodmed;
        this.ctacusuareg = ctacusuareg;
        this.ctacestado = ctacestado;
    }

    /** 
     * 		       Consecutivo
     * 		    
     */
    public Integer getCtanconsec() {
        return this.ctanconsec;
    }

    public void setCtanconsec(Integer ctanconsec) {
        this.ctanconsec = ctanconsec;
    }

    public Long getCtanconsulta() {
        return this.ctanconsulta;
    }

    public void setCtanconsulta(Long ctanconsulta) {
        this.ctanconsulta = ctanconsulta;
    }

    public Date getCtadhora() {
        return this.ctadhora;
    }

    public void setCtadhora(Date ctadhora) {
        this.ctadhora = ctadhora;
    }

    public String getCtacetapa() {
        return this.ctacetapa;
    }

    public void setCtacetapa(String ctacetapa) {
        this.ctacetapa = ctacetapa;
    }

    public Integer getCtancausa() {
        return this.ctancausa;
    }

    public void setCtancausa(Integer ctancausa) {
        this.ctancausa = ctancausa;
    }

    public Date getCtadfechregi() {
        return this.ctadfechregi;
    }

    public void setCtadfechregi(Date ctadfechregi) {
        this.ctadfechregi = ctadfechregi;
    }

    public Integer getCtancodmed() {
        return this.ctancodmed;
    }

    public void setCtancodmed(Integer ctancodmed) {
        this.ctancodmed = ctancodmed;
    }

    public String getCtacusuareg() {
        return this.ctacusuareg;
    }

    public void setCtacusuareg(String ctacusuareg) {
        this.ctacusuareg = ctacusuareg;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctanconsec", getCtanconsec())
            .toString();
    }

    public void setCtacestado(String ctacestado) {
        this.ctacestado = ctacestado;
    }

    public String getCtacestado() {
        return ctacestado;
    }
}
