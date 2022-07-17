package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chregitelf implements Serializable {

    /** identifier field */
    private Long hrtlnumero;

    /** persistent field */
    private Long hrtlnumusu;

    /** persistent field */
    private String hrtcregistro;

    /** persistent field */
    private String hrtcusureg;

    /** persistent field */
    private Date hrtdfecreg;

    /** persistent field */
    private String hrtcusumod;

    /** persistent field */
    private Date hrtdfecmod;

    /** nullable persistent field */
    private Long version;
    
    private String hrtcproqui;
    
    private String hrtctos;
    
    private Integer hrtnnumdiatos;
    
    private String hrtcfiebre;
    
    private Integer hrtnnumdiafie;
    
    private String hrtcdolgar;
    
    private Integer hrtnnudidoga;
    
    private String hrtcconnal;
    
    private Integer hrtnnudicona;
    
    private String hrtcdifres;
    
    private Integer hrtnnudidire;
    
    private String hrtcfatiga;
    
    private Integer hrtnnumdiafat;
    
    private String hrtcescalofrio;
    
    private Integer hrtnnumdiaesc;
    
    private String hrtcninguna;
    
    
    

    /** full constructor */
    public Chregitelf(Long hrtlnumero, Long hrtlnumusu, String hrtcregistro, String hrtcusureg, Date hrtdfecreg, String hrtcusumod, Date hrtdfecmod, Long version) {
        this.hrtlnumero = hrtlnumero;
        this.hrtlnumusu = hrtlnumusu;
        this.hrtcregistro = hrtcregistro;
        this.hrtcusureg = hrtcusureg;
        this.hrtdfecreg = hrtdfecreg;
        this.hrtcusumod = hrtcusumod;
        this.hrtdfecmod = hrtdfecmod;
        this.version = version;
    }

    /** default constructor */
    public Chregitelf() {
    }

    /** minimal constructor */
    public Chregitelf(Long hrtlnumero, Long hrtlnumusu, String hrtcregistro, String hrtcusureg, Date hrtdfecreg, String hrtcusumod, Date hrtdfecmod) {
        this.hrtlnumero = hrtlnumero;
        this.hrtlnumusu = hrtlnumusu;
        this.hrtcregistro = hrtcregistro;
        this.hrtcusureg = hrtcusureg;
        this.hrtdfecreg = hrtdfecreg;
        this.hrtcusumod = hrtcusumod;
        this.hrtdfecmod = hrtdfecmod;
    }

    public Long getHrtlnumero() {
        return this.hrtlnumero;
    }

    public void setHrtlnumero(Long hrtlnumero) {
        this.hrtlnumero = hrtlnumero;
    }

    public Long getHrtlnumusu() {
        return this.hrtlnumusu;
    }

    public void setHrtlnumusu(Long hrtlnumusu) {
        this.hrtlnumusu = hrtlnumusu;
    }

    public String getHrtcregistro() {
        return this.hrtcregistro;
    }

    public void setHrtcregistro(String hrtcregistro) {
        this.hrtcregistro = hrtcregistro;
    }

    public String getHrtcusureg() {
        return this.hrtcusureg;
    }

    public void setHrtcusureg(String hrtcusureg) {
        this.hrtcusureg = hrtcusureg;
    }

    public Date getHrtdfecreg() {
        return this.hrtdfecreg;
    }

    public void setHrtdfecreg(Date hrtdfecreg) {
        this.hrtdfecreg = hrtdfecreg;
    }

    public String getHrtcusumod() {
        return this.hrtcusumod;
    }

    public void setHrtcusumod(String hrtcusumod) {
        this.hrtcusumod = hrtcusumod;
    }

    public Date getHrtdfecmod() {
        return this.hrtdfecmod;
    }

    public void setHrtdfecmod(Date hrtdfecmod) {
        this.hrtdfecmod = hrtdfecmod;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hrtlnumero", getHrtlnumero())
            .toString();
    }

    public Long get_hrtlnumero() {
        return hrtlnumero;
    }

    public Long get_hrtlnumusu() {
        return hrtlnumusu;
    }

    public String get_hrtcregistro() {
        return hrtcregistro;
    }

    public String get_hrtcusureg() {
        return hrtcusureg;
    }

    public Date get_hrtdfecreg() {
        return hrtdfecreg;
    }

    public String get_hrtcusumod() {
        return hrtcusumod;
    }

    public Date get_hrtdfecmod() {
        return hrtdfecmod;
    }

    public Long get_version() {
        return version;
    }

    public void setHrtctos(String hrtctos) {
        this.hrtctos = hrtctos;
    }

    public String getHrtctos() {
        return hrtctos;
    }

    public void setHrtnnumdiatos(Integer hrtnnumdiatos) {
        this.hrtnnumdiatos = hrtnnumdiatos;
    }

    public Integer getHrtnnumdiatos() {
        return hrtnnumdiatos;
    }

    public void setHrtcfiebre(String hrtcfiebre) {
        this.hrtcfiebre = hrtcfiebre;
    }

    public String getHrtcfiebre() {
        return hrtcfiebre;
    }

    public void setHrtnnumdiafie(Integer hrtnnumdiafie) {
        this.hrtnnumdiafie = hrtnnumdiafie;
    }

    public Integer getHrtnnumdiafie() {
        return hrtnnumdiafie;
    }

    public void setHrtcdolgar(String hrtcdolgar) {
        this.hrtcdolgar = hrtcdolgar;
    }

    public String getHrtcdolgar() {
        return hrtcdolgar;
    }

    public void setHrtnnudidoga(Integer hrtnnudidoga) {
        this.hrtnnudidoga = hrtnnudidoga;
    }

    public Integer getHrtnnudidoga() {
        return hrtnnudidoga;
    }

    public void setHrtcconnal(String hrtcconnal) {
        this.hrtcconnal = hrtcconnal;
    }

    public String getHrtcconnal() {
        return hrtcconnal;
    }

    public void setHrtnnudicona(Integer hrtnnudicona) {
        this.hrtnnudicona = hrtnnudicona;
    }

    public Integer getHrtnnudicona() {
        return hrtnnudicona;
    }

    public void setHrtcdifres(String hrtcdifres) {
        this.hrtcdifres = hrtcdifres;
    }

    public String getHrtcdifres() {
        return hrtcdifres;
    }

    public void setHrtnnudidire(Integer hrtnnudidire) {
        this.hrtnnudidire = hrtnnudidire;
    }

    public Integer getHrtnnudidire() {
        return hrtnnudidire;
    }

    public void setHrtcfatiga(String hrtcfatiga) {
        this.hrtcfatiga = hrtcfatiga;
    }

    public String getHrtcfatiga() {
        return hrtcfatiga;
    }

    public void setHrtnnumdiafat(Integer hrtnnumdiafat) {
        this.hrtnnumdiafat = hrtnnumdiafat;
    }

    public Integer getHrtnnumdiafat() {
        return hrtnnumdiafat;
    }

    public void setHrtcescalofrio(String hrtcescalofrio) {
        this.hrtcescalofrio = hrtcescalofrio;
    }

    public String getHrtcescalofrio() {
        return hrtcescalofrio;
    }

    public void setHrtnnumdiaesc(Integer hrtnnumdiaesc) {
        this.hrtnnumdiaesc = hrtnnumdiaesc;
    }

    public Integer getHrtnnumdiaesc() {
        return hrtnnumdiaesc;
    }

    public void setHrtcninguna(String hrtcninguna) {
        this.hrtcninguna = hrtcninguna;
    }

    public String getHrtcninguna() {
        return hrtcninguna;
    }

    public void setHrtcproqui(String hrtcproqui) {
        this.hrtcproqui = hrtcproqui;
    }

    public String getHrtcproqui() {
        return hrtcproqui;
    }
}
