package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chestermascu implements Serializable {

    /** identifier field */
    private ChestermascuPK id;

    /** persistent field */
    private String hemcinformetod;

    /** persistent field */
    private String hemcvasecdefin;

    /** persistent field */
    private String hemcvasecfalla;

    /** persistent field */
    private String hemcexitoesper;

    /** persistent field */
    private String hemcinforsufic;

    /** nullable persistent field */
    private String hemcoperador;

    /** nullable persistent field */
    private Date hemdfecreg;

    /** nullable persistent field */
    private String hemcaclarinfor;

    /** nullable persistent field */
    private String hemcaclardefin;

    /** nullable persistent field */
    private String hemcaclarfalla;

    /** nullable persistent field */
    private String hemcaclarexito;

    /** nullable persistent field */
    private String hemcaclarsufic;
    
    /** nullable persistent field */
    private String hemcvasecfalnue;
    
    /** nullable persistent field */
    private String hemcaclarfalnue;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chestermascu() {
        id = new ChestermascuPK();
    }


    /**
     * @param id
     */
    public void setId(ChestermascuPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChestermascuPK getId() {
        return id;
    }

    /**
     * @param hemcinformetod
     */
    public void setHemcinformetod(String hemcinformetod) {
        this.hemcinformetod = hemcinformetod;
    }

    /**
     * @return
     */
    public String getHemcinformetod() {
        return hemcinformetod;
    }

    /**
     * @param hemcvasecdefin
     */
    public void setHemcvasecdefin(String hemcvasecdefin) {
        this.hemcvasecdefin = hemcvasecdefin;
    }

    /**
     * @return
     */
    public String getHemcvasecdefin() {
        return hemcvasecdefin;
    }

    /**
     * @param hemcvasecfalla
     */
    public void setHemcvasecfalla(String hemcvasecfalla) {
        this.hemcvasecfalla = hemcvasecfalla;
    }

    /**
     * @return
     */
    public String getHemcvasecfalla() {
        return hemcvasecfalla;
    }

    /**
     * @param hemcexitoesper
     */
    public void setHemcexitoesper(String hemcexitoesper) {
        this.hemcexitoesper = hemcexitoesper;
    }

    /**
     * @return
     */
    public String getHemcexitoesper() {
        return hemcexitoesper;
    }

    /**
     * @param hemcinforsufic
     */
    public void setHemcinforsufic(String hemcinforsufic) {
        this.hemcinforsufic = hemcinforsufic;
    }

    /**
     * @return
     */
    public String getHemcinforsufic() {
        return hemcinforsufic;
    }

    /**
     * @param hemcoperador
     */
    public void setHemcoperador(String hemcoperador) {
        this.hemcoperador = hemcoperador;
    }

    /**
     * @return
     */
    public String getHemcoperador() {
        return hemcoperador;
    }

    /**
     * @param hemdfecreg
     */
    public void setHemdfecreg(Date hemdfecreg) {
        this.hemdfecreg = hemdfecreg;
    }

    /**
     * @return
     */
    public Date getHemdfecreg() {
        return hemdfecreg;
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
     * @param hemcaclarinfor
     */
    public void setHemcaclarinfor(String hemcaclarinfor) {
        this.hemcaclarinfor = hemcaclarinfor;
    }

    /**
     * @return
     */
    public String getHemcaclarinfor() {
        return hemcaclarinfor;
    }

    /**
     * @param hemcaclardefin
     */
    public void setHemcaclardefin(String hemcaclardefin) {
        this.hemcaclardefin = hemcaclardefin;
    }

    /**
     * @return
     */
    public String getHemcaclardefin() {
        return hemcaclardefin;
    }

    /**
     * @param hemcaclarfalla
     */
    public void setHemcaclarfalla(String hemcaclarfalla) {
        this.hemcaclarfalla = hemcaclarfalla;
    }

    /**
     * @return
     */
    public String getHemcaclarfalla() {
        return hemcaclarfalla;
    }

    /**
     * @param hemcaclarexito
     */
    public void setHemcaclarexito(String hemcaclarexito) {
        this.hemcaclarexito = hemcaclarexito;
    }

    /**
     * @return
     */
    public String getHemcaclarexito() {
        return hemcaclarexito;
    }

    /**
     * @param hemcaclarsufic
     */
    public void setHemcaclarsufic(String hemcaclarsufic) {
        this.hemcaclarsufic = hemcaclarsufic;
    }

    /**
     * @return
     */
    public String getHemcaclarsufic() {
        return hemcaclarsufic;
    }

    public void setHemcvasecfalnue(String hemcvasecfalnue) {
        this.hemcvasecfalnue = hemcvasecfalnue;
    }

    public String getHemcvasecfalnue() {
        return hemcvasecfalnue;
    }

    public void setHemcaclarfalnue(String hemcaclarfalnue) {
        this.hemcaclarfalnue = hemcaclarfalnue;
    }

    public String getHemcaclarfalnue() {
        return hemcaclarfalnue;
    }
}
