package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chpsicoantec implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.ChpsicoantecPK id;

    /** nullable persistent field */
    private String hpacpresedisca;

    /** nullable persistent field */
    private String hpaccualdisca;

    /** nullable persistent field */
    private String hpactrastmenta;

    /** nullable persistent field */
    private String hpaccualtrast;

    /** nullable persistent field */
    private String hpacvidasexac;

    /** nullable persistent field */
    private String hpachabitsalud;

    /** nullable persistent field */
    private String hpaccualhabit;

    /** nullable persistent field */
    private String hpacviolesexual;

    /** nullable persistent field */
    private String hpacviolefisic;

    /** nullable persistent field */
    private String hpacvioleecono;

    /** nullable persistent field */
    private String hpacviolepsico;

    /** nullable persistent field */
    private String hpacsustapsico;

    /** nullable persistent field */
    private String hpaccualsusta;

    /** nullable persistent field */
    private String hpactomamedi;

    /** nullable persistent field */
    private String hpaccualmedi;

    /** nullable persistent field */
    private String hpacenfediag;

    /** nullable persistent field */
    private String hpaccualenfe;

    /** nullable persistent field */
    private String hpacrelacsatis;

    /** nullable persistent field */
    private String hpacquitavida;

    /** nullable persistent field */
    private String hpacmanequit;

    /** nullable persistent field */
    private String hpacvicconfarm;

    /** nullable persistent field */
    private Integer hpanedadhabla;

    /** nullable persistent field */
    private Integer hpanedadgateo;

    /** nullable persistent field */
    private Integer hpanedadcamino;

    /** nullable persistent field */
    private Integer hpanhorasduerm;

    /** nullable persistent field */
    private String hpacdificapren;

    /** nullable persistent field */
    private String hpaccualdific;

    /** nullable persistent field */
    private String hpacsociapare;

    /** nullable persistent field */
    private String hpacobssoci;

    /** nullable persistent field */
    private String hpacrutiesta;

    /** nullable persistent field */
    private String hpacualruti;

    /** nullable persistent field */
    private String hpactemppred;

    /** nullable persistent field */
    private String hpacobstemp;

    /** nullable persistent field */
    private String hpacoperador;

    /** nullable persistent field */
    private Date hpadfecregistr;

    /** nullable persistent field */
    private Integer version;

    /** default constructor */
    public Chpsicoantec() {
    }

   
    public void setHpacpresedisca(String hpacpresedisca) {
        this.hpacpresedisca = hpacpresedisca;
    }

    public String getHpacpresedisca() {
        return hpacpresedisca;
    }

    public void setHpaccualdisca(String hpaccualdisca) {
        this.hpaccualdisca = hpaccualdisca;
    }

    public String getHpaccualdisca() {
        return hpaccualdisca;
    }

    public void setHpactrastmenta(String hpactrastmenta) {
        this.hpactrastmenta = hpactrastmenta;
    }

    public String getHpactrastmenta() {
        return hpactrastmenta;
    }

    public void setHpaccualtrast(String hpaccualtrast) {
        this.hpaccualtrast = hpaccualtrast;
    }

    public String getHpaccualtrast() {
        return hpaccualtrast;
    }

    public void setHpacvidasexac(String hpacvidasexac) {
        this.hpacvidasexac = hpacvidasexac;
    }

    public String getHpacvidasexac() {
        return hpacvidasexac;
    }

    public void setHpachabitsalud(String hpachabitsalud) {
        this.hpachabitsalud = hpachabitsalud;
    }

    public String getHpachabitsalud() {
        return hpachabitsalud;
    }

    public void setHpaccualhabit(String hpaccualhabit) {
        this.hpaccualhabit = hpaccualhabit;
    }

    public String getHpaccualhabit() {
        return hpaccualhabit;
    }

    public void setHpacviolesexual(String hpacviolesexual) {
        this.hpacviolesexual = hpacviolesexual;
    }

    public String getHpacviolesexual() {
        return hpacviolesexual;
    }

    public void setHpacviolefisic(String hpacviolefisic) {
        this.hpacviolefisic = hpacviolefisic;
    }

    public String getHpacviolefisic() {
        return hpacviolefisic;
    }

    public void setHpacvioleecono(String hpacvioleecono) {
        this.hpacvioleecono = hpacvioleecono;
    }

    public String getHpacvioleecono() {
        return hpacvioleecono;
    }

    public void setHpacviolepsico(String hpacviolepsico) {
        this.hpacviolepsico = hpacviolepsico;
    }

    public String getHpacviolepsico() {
        return hpacviolepsico;
    }

    public void setHpacsustapsico(String hpacsustapsico) {
        this.hpacsustapsico = hpacsustapsico;
    }

    public String getHpacsustapsico() {
        return hpacsustapsico;
    }

    public void setHpaccualsusta(String hpaccualsusta) {
        this.hpaccualsusta = hpaccualsusta;
    }

    public String getHpaccualsusta() {
        return hpaccualsusta;
    }

    public void setHpactomamedi(String hpactomamedi) {
        this.hpactomamedi = hpactomamedi;
    }

    public String getHpactomamedi() {
        return hpactomamedi;
    }

    public void setHpaccualmedi(String hpaccualmedi) {
        this.hpaccualmedi = hpaccualmedi;
    }

    public String getHpaccualmedi() {
        return hpaccualmedi;
    }

    public void setHpacenfediag(String hpacenfediag) {
        this.hpacenfediag = hpacenfediag;
    }

    public String getHpacenfediag() {
        return hpacenfediag;
    }

    public void setHpaccualenfe(String hpaccualenfe) {
        this.hpaccualenfe = hpaccualenfe;
    }

    public String getHpaccualenfe() {
        return hpaccualenfe;
    }

    public void setHpacrelacsatis(String hpacrelacsatis) {
        this.hpacrelacsatis = hpacrelacsatis;
    }

    public String getHpacrelacsatis() {
        return hpacrelacsatis;
    }

    public void setHpacquitavida(String hpacquitavida) {
        this.hpacquitavida = hpacquitavida;
    }

    public String getHpacquitavida() {
        return hpacquitavida;
    }

    public void setHpacmanequit(String hpacmanequit) {
        this.hpacmanequit = hpacmanequit;
    }

    public String getHpacmanequit() {
        return hpacmanequit;
    }

    public void setHpacvicconfarm(String hpacvicconfarm) {
        this.hpacvicconfarm = hpacvicconfarm;
    }

    public String getHpacvicconfarm() {
        return hpacvicconfarm;
    }

    public void setHpanedadhabla(Integer hpanedadhabla) {
        this.hpanedadhabla = hpanedadhabla;
    }

    public Integer getHpanedadhabla() {
        return hpanedadhabla;
    }

    public void setHpanedadgateo(Integer hpanedadgateo) {
        this.hpanedadgateo = hpanedadgateo;
    }

    public Integer getHpanedadgateo() {
        return hpanedadgateo;
    }

    public void setHpanedadcamino(Integer hpanedadcamino) {
        this.hpanedadcamino = hpanedadcamino;
    }

    public Integer getHpanedadcamino() {
        return hpanedadcamino;
    }

    public void setHpanhorasduerm(Integer hpanhorasduerm) {
        this.hpanhorasduerm = hpanhorasduerm;
    }

    public Integer getHpanhorasduerm() {
        return hpanhorasduerm;
    }

    public void setHpacdificapren(String hpacdificapren) {
        this.hpacdificapren = hpacdificapren;
    }

    public String getHpacdificapren() {
        return hpacdificapren;
    }

    public void setHpaccualdific(String hpaccualdific) {
        this.hpaccualdific = hpaccualdific;
    }

    public String getHpaccualdific() {
        return hpaccualdific;
    }

    public void setHpacsociapare(String hpacsociapare) {
        this.hpacsociapare = hpacsociapare;
    }

    public String getHpacsociapare() {
        return hpacsociapare;
    }

    public void setHpacobssoci(String hpacobssoci) {
        this.hpacobssoci = hpacobssoci;
    }

    public String getHpacobssoci() {
        return hpacobssoci;
    }

    public void setHpacrutiesta(String hpacrutiesta) {
        this.hpacrutiesta = hpacrutiesta;
    }

    public String getHpacrutiesta() {
        return hpacrutiesta;
    }

    public void setHpacualruti(String hpacualruti) {
        this.hpacualruti = hpacualruti;
    }

    public String getHpacualruti() {
        return hpacualruti;
    }

    public void setHpactemppred(String hpactemppred) {
        this.hpactemppred = hpactemppred;
    }

    public String getHpactemppred() {
        return hpactemppred;
    }

    public void setHpacobstemp(String hpacobstemp) {
        this.hpacobstemp = hpacobstemp;
    }

    public String getHpacobstemp() {
        return hpacobstemp;
    }

    public void setHpacoperador(String hpacoperador) {
        this.hpacoperador = hpacoperador;
    }

    public String getHpacoperador() {
        return hpacoperador;
    }

    public void setHpadfecregistr(Date hpadfecregistr) {
        this.hpadfecregistr = hpadfecregistr;
    }

    public Date getHpadfecregistr() {
        return hpadfecregistr;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setId(ChpsicoantecPK id) {
        this.id = id;
    }

    public ChpsicoantecPK getId() {
        return id;
    }
}
