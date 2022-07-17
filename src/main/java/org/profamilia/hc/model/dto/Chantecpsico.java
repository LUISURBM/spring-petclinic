package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chantecpsico implements Serializable {

    /** identifier field */
    private ChantecpsicoPK id;

    /** nullable persistent field */
    private String hapcsientenfer;

    /** nullable persistent field */
    private String hapcdescrenfer;

    /** nullable persistent field */
    private String hapcalterfisic;

    /** nullable persistent field */
    private String hapccualalter;

    /** nullable persistent field */
    private String hapcnuncafisic;

    /** nullable persistent field */
    private String hapcocasifisic;

    /** nullable persistent field */
    private String hapcalimtredia;

    /** nullable persistent field */
    private String hapcalimmasdia;

    /** nullable persistent field */
    private String hapctipoalime;

    /** nullable persistent field */
    private String hapcmedicformu;

    /** nullable persistent field */
    private String hapccualmedic;

    /** nullable persistent field */
    private String hapchabitsalud;

    /** nullable persistent field */
    private String hapccualhabit;

    /** nullable persistent field */
    private String hapcoriensexua;

    /** nullable persistent field */
    private String hapccualorien;

    /** nullable persistent field */
    private String hapcactuaparej;

    /** nullable persistent field */
    private String hapctipovincu;

    /** nullable persistent field */
    private String hapcsexuaactiv;

    /** nullable persistent field */
    private String hapcsexuasatis;

    /** nullable persistent field */
    private String hapcsexuadific;

    /** nullable persistent field */
    private String hapccualdific;

    /** nullable persistent field */
    private String hapctrastpsiqu;

    /** nullable persistent field */
    private String hapccualtrast;

    /** nullable persistent field */
    private String hapctipofamil;

    /** nullable persistent field */
    private String hapccompofamil;

    /** nullable persistent field */
    private String hapcvincufamil;

    /** nullable persistent field */
    private String hapcrelacfamil;

    /** nullable persistent field */
    private String hapcoperador;

    /** nullable persistent field */
    private Date hapdfecregistr;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chantecpsico() {
        id = new ChantecpsicoPK();
    }


    /**
     * @param id
     */
    public void setId(ChantecpsicoPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChantecpsicoPK getId() {
        return id;
    }

    /**
     * @param hapcoperador
     */
    public void setHapcoperador(String hapcoperador) {
        this.hapcoperador = hapcoperador;
    }

    /**
     * @return
     */
    public String getHapcoperador() {
        return hapcoperador;
    }

    /**
     * @param hapdfecregistr
     */
    public void setHapdfecregistr(Date hapdfecregistr) {
        this.hapdfecregistr = hapdfecregistr;
    }

    /**
     * @return
     */
    public Date getHapdfecregistr() {
        return hapdfecregistr;
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
     * @param hapcsientenfer
     */
    public void setHapcsientenfer(String hapcsientenfer) {
        this.hapcsientenfer = hapcsientenfer;
    }

    /**
     * @return
     */
    public String getHapcsientenfer() {
        return hapcsientenfer;
    }

    /**
     * @param hapcdescrenfer
     */
    public void setHapcdescrenfer(String hapcdescrenfer) {
        this.hapcdescrenfer = hapcdescrenfer;
    }

    /**
     * @return
     */
    public String getHapcdescrenfer() {
        return hapcdescrenfer;
    }

    

    /**
     * @param hapcalterfisic
     */
    public void setHapcalterfisic(String hapcalterfisic) {
        this.hapcalterfisic = hapcalterfisic;
    }

    /**
     * @return
     */
    public String getHapcalterfisic() {
        return hapcalterfisic;
    }

    /**
     * @param hapcnuncafisic
     */
    public void setHapcnuncafisic(String hapcnuncafisic) {
        this.hapcnuncafisic = hapcnuncafisic;
    }

    /**
     * @return
     */
    public String getHapcnuncafisic() {
        return hapcnuncafisic;
    }

    /**
     * @param hapcocasifisic
     */
    public void setHapcocasifisic(String hapcocasifisic) {
        this.hapcocasifisic = hapcocasifisic;
    }

    /**
     * @return
     */
    public String getHapcocasifisic() {
        return hapcocasifisic;
    }

    /**
     * @param hapcalimtredia
     */
    public void setHapcalimtredia(String hapcalimtredia) {
        this.hapcalimtredia = hapcalimtredia;
    }

    /**
     * @return
     */
    public String getHapcalimtredia() {
        return hapcalimtredia;
    }

    /**
     * @param hapcalimmasdia
     */
    public void setHapcalimmasdia(String hapcalimmasdia) {
        this.hapcalimmasdia = hapcalimmasdia;
    }

    /**
     * @return
     */
    public String getHapcalimmasdia() {
        return hapcalimmasdia;
    }

    /**
     * @param hapctipoalime
     */
    public void setHapctipoalime(String hapctipoalime) {
        this.hapctipoalime = hapctipoalime;
    }

    /**
     * @return
     */
    public String getHapctipoalime() {
        return hapctipoalime;
    }

    /**
     * @param hapcmedicformu
     */
    public void setHapcmedicformu(String hapcmedicformu) {
        this.hapcmedicformu = hapcmedicformu;
    }

    /**
     * @return
     */
    public String getHapcmedicformu() {
        return hapcmedicformu;
    }

    /**
     * @param hapccualmedic
     */
    public void setHapccualmedic(String hapccualmedic) {
        this.hapccualmedic = hapccualmedic;
    }

    /**
     * @return
     */
    public String getHapccualmedic() {
        return hapccualmedic;
    }

    /**
     * @param hapchabitsalud
     */
    public void setHapchabitsalud(String hapchabitsalud) {
        this.hapchabitsalud = hapchabitsalud;
    }

    /**
     * @return
     */
    public String getHapchabitsalud() {
        return hapchabitsalud;
    }

    /**
     * @param hapccualhabit
     */
    public void setHapccualhabit(String hapccualhabit) {
        this.hapccualhabit = hapccualhabit;
    }

    /**
     * @return
     */
    public String getHapccualhabit() {
        return hapccualhabit;
    }

    /**
     * @param hapccualalter
     */
    public void setHapccualalter(String hapccualalter) {
        this.hapccualalter = hapccualalter;
    }

    /**
     * @return
     */
    public String getHapccualalter() {
        return hapccualalter;
    }

    /**
     * @param hapcoriensexua
     */
    public void setHapcoriensexua(String hapcoriensexua) {
        this.hapcoriensexua = hapcoriensexua;
    }

    /**
     * @return
     */
    public String getHapcoriensexua() {
        return hapcoriensexua;
    }

    /**
     * @param hapcactuaparej
     */
    public void setHapcactuaparej(String hapcactuaparej) {
        this.hapcactuaparej = hapcactuaparej;
    }

    /**
     * @return
     */
    public String getHapcactuaparej() {
        return hapcactuaparej;
    }

    /**
     * @param hapctipovincu
     */
    public void setHapctipovincu(String hapctipovincu) {
        this.hapctipovincu = hapctipovincu;
    }

    /**
     * @return
     */
    public String getHapctipovincu() {
        return hapctipovincu;
    }

    /**
     * @param hapcsexuaactiv
     */
    public void setHapcsexuaactiv(String hapcsexuaactiv) {
        this.hapcsexuaactiv = hapcsexuaactiv;
    }

    /**
     * @return
     */
    public String getHapcsexuaactiv() {
        return hapcsexuaactiv;
    }

    /**
     * @param hapcsexuasatis
     */
    public void setHapcsexuasatis(String hapcsexuasatis) {
        this.hapcsexuasatis = hapcsexuasatis;
    }

    /**
     * @return
     */
    public String getHapcsexuasatis() {
        return hapcsexuasatis;
    }

    /**
     * @param hapcsexuadific
     */
    public void setHapcsexuadific(String hapcsexuadific) {
        this.hapcsexuadific = hapcsexuadific;
    }

    /**
     * @return
     */
    public String getHapcsexuadific() {
        return hapcsexuadific;
    }

    /**
     * @param hapccualdific
     */
    public void setHapccualdific(String hapccualdific) {
        this.hapccualdific = hapccualdific;
    }

    /**
     * @return
     */
    public String getHapccualdific() {
        return hapccualdific;
    }

    /**
     * @param hapctrastpsiqu
     */
    public void setHapctrastpsiqu(String hapctrastpsiqu) {
        this.hapctrastpsiqu = hapctrastpsiqu;
    }

    /**
     * @return
     */
    public String getHapctrastpsiqu() {
        return hapctrastpsiqu;
    }

    /**
     * @param hapccualtrast
     */
    public void setHapccualtrast(String hapccualtrast) {
        this.hapccualtrast = hapccualtrast;
    }

    /**
     * @return
     */
    public String getHapccualtrast() {
        return hapccualtrast;
    }

    /**
     * @param hapccualorien
     */
    public void setHapccualorien(String hapccualorien) {
        this.hapccualorien = hapccualorien;
    }

    /**
     * @return
     */
    public String getHapccualorien() {
        return hapccualorien;
    }

    /**
     * @param hapctipofamil
     */
    public void setHapctipofamil(String hapctipofamil) {
        this.hapctipofamil = hapctipofamil;
    }

    /**
     * @return
     */
    public String getHapctipofamil() {
        return hapctipofamil;
    }

    /**
     * @param hapccompofamil
     */
    public void setHapccompofamil(String hapccompofamil) {
        this.hapccompofamil = hapccompofamil;
    }

    /**
     * @return
     */
    public String getHapccompofamil() {
        return hapccompofamil;
    }

    /**
     * @param hapcvincufamil
     */
    public void setHapcvincufamil(String hapcvincufamil) {
        this.hapcvincufamil = hapcvincufamil;
    }

    /**
     * @return
     */
    public String getHapcvincufamil() {
        return hapcvincufamil;
    }

    /**
     * @param hapcrelacfamil
     */
    public void setHapcrelacfamil(String hapcrelacfamil) {
        this.hapcrelacfamil = hapcrelacfamil;
    }

    /**
     * @return
     */
    public String getHapcrelacfamil() {
        return hapcrelacfamil;
    }
}
