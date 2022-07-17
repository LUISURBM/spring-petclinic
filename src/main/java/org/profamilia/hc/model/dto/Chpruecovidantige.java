package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chpruecovidantige implements Serializable {

    /** identifier field */
    private Long hpgnconsulta;

    /** nullable persistent field */
    private Long hpgnnumepaci;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String hpgusuareg;

    /** nullable persistent field */
    private Date hpgdfechreg;

    /** nullable persistent field */
    private String hpgctrabsalud;

    /** nullable persistent field */
    private String hpgccontadias;

    /** nullable persistent field */
    private Date hpgdfecsinto;

    /** nullable persistent field */
    private Integer hpgnnumesinto;

    /** nullable persistent field */
    private String hpgclugatoma;

    /** nullable persistent field */
    private String hpgclugaproc;

    /** nullable persistent field */
    private BigDecimal hpgntempambi;

    /** nullable persistent field */
    private String hpgcmarca;

    /** nullable persistent field */
    private String hpgclote;

    /** nullable persistent field */
    private String hpgcreginvim;

    /** nullable persistent field */
    private Date hpgdfechfabr;

    /** nullable persistent field */
    private Date hpgdfechvenci;

    /** nullable persistent field */
    private String hpgcresultado;

    /** nullable persistent field */
    private String hpgcobserv;
    
    /** nullable persistent field */
    private String hpgcsintopaci;

    /** full constructor */
    public Chpruecovidantige(Long hpgnconsulta, Long hpgnnumepaci, Integer version, String hpgusuareg, Date hpgdfechreg, String hpgctrabsalud, String hpgccontadias, Date hpgdfecsinto, Integer hpgnnumesinto, String hpgclugatoma, String hpgclugaproc, BigDecimal hpgntempambi, String hpgcmarca, String hpgclote, String hpgcreginvim, Date hpgdfechfabr, Date hpgdfechvenci, String hpgcresultado, String hpgcobserv, String hpgcsintopaci) {
        this.hpgnconsulta = hpgnconsulta;
        this.hpgnnumepaci = hpgnnumepaci;
        this.version = version;
        this.hpgusuareg = hpgusuareg;
        this.hpgdfechreg = hpgdfechreg;
        this.hpgctrabsalud = hpgctrabsalud;
        this.hpgccontadias = hpgccontadias;
        this.hpgdfecsinto = hpgdfecsinto;
        this.hpgnnumesinto = hpgnnumesinto;
        this.hpgclugatoma = hpgclugatoma;
        this.hpgclugaproc = hpgclugaproc;
        this.hpgntempambi = hpgntempambi;
        this.hpgcmarca = hpgcmarca;
        this.hpgclote = hpgclote;
        this.hpgcreginvim = hpgcreginvim;
        this.hpgdfechfabr = hpgdfechfabr;
        this.hpgdfechvenci = hpgdfechvenci;
        this.hpgcresultado = hpgcresultado;
        this.hpgcobserv = hpgcobserv;
        this.hpgcsintopaci = hpgcsintopaci;
    }

    /** default constructor */
    public Chpruecovidantige() {
    }

    /** minimal constructor */
    public Chpruecovidantige(Long hpgnconsulta) {
        this.hpgnconsulta = hpgnconsulta;
    }

    /** 
     * 		       NUMERO DE CONSULTA
     * 		    
     */
    public Long getHpgnconsulta() {
        return this.hpgnconsulta;
    }

    public void setHpgnconsulta(Long hpgnconsulta) {
        this.hpgnconsulta = hpgnconsulta;
    }

    public Long getHpgnnumepaci() {
        return this.hpgnnumepaci;
    }

    public void setHpgnnumepaci(Long hpgnnumepaci) {
        this.hpgnnumepaci = hpgnnumepaci;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getHpgusuareg() {
        return this.hpgusuareg;
    }

    public void setHpgusuareg(String hpgusuareg) {
        this.hpgusuareg = hpgusuareg;
    }

    public Date getHpgdfechreg() {
        return this.hpgdfechreg;
    }

    public void setHpgdfechreg(Date hpgdfechreg) {
        this.hpgdfechreg = hpgdfechreg;
    }

    public String getHpgctrabsalud() {
        return this.hpgctrabsalud;
    }

    public void setHpgctrabsalud(String hpgctrabsalud) {
        this.hpgctrabsalud = hpgctrabsalud;
    }

    public String getHpgccontadias() {
        return this.hpgccontadias;
    }

    public void setHpgccontadias(String hpgccontadias) {
        this.hpgccontadias = hpgccontadias;
    }

    public Date getHpgdfecsinto() {
        return this.hpgdfecsinto;
    }

    public void setHpgdfecsinto(Date hpgdfecsinto) {
        this.hpgdfecsinto = hpgdfecsinto;
    }

    public Integer getHpgnnumesinto() {
        return this.hpgnnumesinto;
    }

    public void setHpgnnumesinto(Integer hpgnnumesinto) {
        this.hpgnnumesinto = hpgnnumesinto;
    }

    public String getHpgclugatoma() {
        return this.hpgclugatoma;
    }

    public void setHpgclugatoma(String hpgclugatoma) {
        this.hpgclugatoma = hpgclugatoma;
    }

    public String getHpgclugaproc() {
        return this.hpgclugaproc;
    }

    public void setHpgclugaproc(String hpgclugaproc) {
        this.hpgclugaproc = hpgclugaproc;
    }

    public BigDecimal getHpgntempambi() {
        return this.hpgntempambi;
    }

    public void setHpgntempambi(BigDecimal hpgntempambi) {
        this.hpgntempambi = hpgntempambi;
    }

    public String getHpgcmarca() {
        return this.hpgcmarca;
    }

    public void setHpgcmarca(String hpgcmarca) {
        this.hpgcmarca = hpgcmarca;
    }

    public String getHpgclote() {
        return this.hpgclote;
    }

    public void setHpgclote(String hpgclote) {
        this.hpgclote = hpgclote;
    }

    public String getHpgcreginvim() {
        return this.hpgcreginvim;
    }

    public void setHpgcreginvim(String hpgcreginvim) {
        this.hpgcreginvim = hpgcreginvim;
    }

    public Date getHpgdfechfabr() {
        return this.hpgdfechfabr;
    }

    public void setHpgdfechfabr(Date hpgdfechfabr) {
        this.hpgdfechfabr = hpgdfechfabr;
    }

    public Date getHpgdfechvenci() {
        return this.hpgdfechvenci;
    }

    public void setHpgdfechvenci(Date hpgdfechvenci) {
        this.hpgdfechvenci = hpgdfechvenci;
    }

    public String getHpgcresultado() {
        return this.hpgcresultado;
    }

    public void setHpgcresultado(String hpgcresultado) {
        this.hpgcresultado = hpgcresultado;
    }

    public String getHpgcobserv() {
        return this.hpgcobserv;
    }

    public void setHpgcobserv(String hpgcobserv) {
        this.hpgcobserv = hpgcobserv;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hpgnconsulta", getHpgnconsulta())
            .toString();
    }


    public void setHpgcsintopaci(String hpgcsintopaci) {
        this.hpgcsintopaci = hpgcsintopaci;
    }

    public String getHpgcsintopaci() {
        return hpgcsintopaci;
    }
}
