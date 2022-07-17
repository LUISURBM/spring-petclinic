package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chpruecovidanticu implements Serializable {

    /** identifier field */
    private Long hpanconsulta;

    /** nullable persistent field */
    private Long hpannumepaci;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String hpausuareg;

    /** nullable persistent field */
    private Date hpadfechreg;

    /** nullable persistent field */
    private String hpaccercepid;

    /** nullable persistent field */
    private String hpactrabsalud;

    /** nullable persistent field */
    private String hpaccontadias;

    /** nullable persistent field */
    private String hpacsintopaci;

    /** nullable persistent field */
    private Date hpadfecsinto;

    /** nullable persistent field */
    private Integer hpannumesintevol;

    /** nullable persistent field */
    private String hpaclugatoma;

    /** nullable persistent field */
    private BigDecimal hpantempambi;

    /** nullable persistent field */
    private String hpacmarca;

    /** nullable persistent field */
    private String hpaclote;

    /** nullable persistent field */
    private String hpacreginvim;

    /** nullable persistent field */
    private Date hpadfechfabr;

    /** nullable persistent field */
    private Date hpadfechvenci;

    /** nullable persistent field */
    private String hpacresultado;

    /** nullable persistent field */
    private String hpactipoantig;

    /** nullable persistent field */
    private String hpacobserv;

    /** full constructor */
    public Chpruecovidanticu(Long hpanconsulta, Long hpannumepaci, Integer version, String hpausuareg, Date hpadfechreg, String hpaccercepid, String hpactrabsalud, String hpaccontadias, String hpacsintopaci, Date hpadfecsinto, Integer hpannumesintevol, String hpaclugatoma, BigDecimal hpantempambi, String hpacmarca, String hpaclote, String hpacreginvim, Date hpadfechfabr, Date hpadfechvenci, String hpacresultado, String hpactipoantig, String hpacobserv) {
        this.hpanconsulta = hpanconsulta;
        this.hpannumepaci = hpannumepaci;
        this.version = version;
        this.hpausuareg = hpausuareg;
        this.hpadfechreg = hpadfechreg;
        this.hpaccercepid = hpaccercepid;
        this.hpactrabsalud = hpactrabsalud;
        this.hpaccontadias = hpaccontadias;
        this.hpacsintopaci = hpacsintopaci;
        this.hpadfecsinto = hpadfecsinto;
        this.hpannumesintevol = hpannumesintevol;
        this.hpaclugatoma = hpaclugatoma;
        this.hpantempambi = hpantempambi;
        this.hpacmarca = hpacmarca;
        this.hpaclote = hpaclote;
        this.hpacreginvim = hpacreginvim;
        this.hpadfechfabr = hpadfechfabr;
        this.hpadfechvenci = hpadfechvenci;
        this.hpacresultado = hpacresultado;
        this.hpactipoantig = hpactipoantig;
        this.hpacobserv = hpacobserv;
    }

    /** default constructor */
    public Chpruecovidanticu() {
    }

    /** minimal constructor */
    public Chpruecovidanticu(Long hpanconsulta) {
        this.hpanconsulta = hpanconsulta;
    }

    /** 
     * 		       NUMERO DE CONSULTA
     * 		    
     */
    public Long getHpanconsulta() {
        return this.hpanconsulta;
    }

    public void setHpanconsulta(Long hpanconsulta) {
        this.hpanconsulta = hpanconsulta;
    }

    public Long getHpannumepaci() {
        return this.hpannumepaci;
    }

    public void setHpannumepaci(Long hpannumepaci) {
        this.hpannumepaci = hpannumepaci;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getHpausuareg() {
        return this.hpausuareg;
    }

    public void setHpausuareg(String hpausuareg) {
        this.hpausuareg = hpausuareg;
    }

    public Date getHpadfechreg() {
        return this.hpadfechreg;
    }

    public void setHpadfechreg(Date hpadfechreg) {
        this.hpadfechreg = hpadfechreg;
    }

    public String getHpaccercepid() {
        return this.hpaccercepid;
    }

    public void setHpaccercepid(String hpaccercepid) {
        this.hpaccercepid = hpaccercepid;
    }

    public String getHpactrabsalud() {
        return this.hpactrabsalud;
    }

    public void setHpactrabsalud(String hpactrabsalud) {
        this.hpactrabsalud = hpactrabsalud;
    }

    public String getHpaccontadias() {
        return this.hpaccontadias;
    }

    public void setHpaccontadias(String hpaccontadias) {
        this.hpaccontadias = hpaccontadias;
    }

    public String getHpacsintopaci() {
        return this.hpacsintopaci;
    }

    public void setHpacsintopaci(String hpacsintopaci) {
        this.hpacsintopaci = hpacsintopaci;
    }

    public Date getHpadfecsinto() {
        return this.hpadfecsinto;
    }

    public void setHpadfecsinto(Date hpadfecsinto) {
        this.hpadfecsinto = hpadfecsinto;
    }

    public Integer getHpannumesintevol() {
        return this.hpannumesintevol;
    }

    public void setHpannumesintevol(Integer hpannumesintevol) {
        this.hpannumesintevol = hpannumesintevol;
    }

    public String getHpaclugatoma() {
        return this.hpaclugatoma;
    }

    public void setHpaclugatoma(String hpaclugatoma) {
        this.hpaclugatoma = hpaclugatoma;
    }

    public BigDecimal getHpantempambi() {
        return this.hpantempambi;
    }

    public void setHpantempambi(BigDecimal hpantempambi) {
        this.hpantempambi = hpantempambi;
    }

    public String getHpacmarca() {
        return this.hpacmarca;
    }

    public void setHpacmarca(String hpacmarca) {
        this.hpacmarca = hpacmarca;
    }

    public String getHpaclote() {
        return this.hpaclote;
    }

    public void setHpaclote(String hpaclote) {
        this.hpaclote = hpaclote;
    }

    public String getHpacreginvim() {
        return this.hpacreginvim;
    }

    public void setHpacreginvim(String hpacreginvim) {
        this.hpacreginvim = hpacreginvim;
    }

    public Date getHpadfechfabr() {
        return this.hpadfechfabr;
    }

    public void setHpadfechfabr(Date hpadfechfabr) {
        this.hpadfechfabr = hpadfechfabr;
    }

    public Date getHpadfechvenci() {
        return this.hpadfechvenci;
    }

    public void setHpadfechvenci(Date hpadfechvenci) {
        this.hpadfechvenci = hpadfechvenci;
    }

    public String getHpacresultado() {
        return this.hpacresultado;
    }

    public void setHpacresultado(String hpacresultado) {
        this.hpacresultado = hpacresultado;
    }

    public String getHpactipoantig() {
        return this.hpactipoantig;
    }

    public void setHpactipoantig(String hpactipoantig) {
        this.hpactipoantig = hpactipoantig;
    }

    public String getHpacobserv() {
        return this.hpacobserv;
    }

    public void setHpacobserv(String hpacobserv) {
        this.hpacobserv = hpacobserv;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hpanconsulta", getHpanconsulta())
            .toString();
    }

}
