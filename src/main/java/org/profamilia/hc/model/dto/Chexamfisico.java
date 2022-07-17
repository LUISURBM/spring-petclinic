package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chexamfisico implements Serializable {

    /** identifier field */
    private ChexamfisicoPK id;

    /** nullable persistent field */
    private String hefcpresart1;

    /** nullable persistent field */
    private Integer hefnfreccard;

    /** nullable persistent field */
    private Integer hefnfrecresp;

    /** nullable persistent field */
    private BigDecimal hefapeso;

    /** nullable persistent field */
    private BigDecimal hefatalla;

    /** nullable persistent field */
    private BigDecimal hefaimc;

    /** nullable persistent field */
    private BigDecimal hefatemperatu;

    /** nullable persistent field */
    private Integer hefnpericefali;

    /** nullable persistent field */
    private Integer hefnsatuoxihe;

    /** nullable persistent field */
    private String hefthallazgo;

    /** nullable persistent field */
    private Date hefdfecregistr;

    /** nullable persistent field */
    private String hefcoperador;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String hefcpresart2;

    /** nullable persistent field */
    private String hefetipotemper;

    /** nullable persistent field */
    private String heferefiepiel;

    /** nullable persistent field */
    private String hefcrefiepiel;

    /** nullable persistent field */
    private String heferefiecrane;

    /** nullable persistent field */
    private String hefcrefiecrane;

    /** nullable persistent field */
    private String heferefieojos;

    /** nullable persistent field */
    private String hefcrefieojos;

    /** nullable persistent field */
    private String heferefieoidos;

    /** nullable persistent field */
    private String hefcrefieoidos;

    /** nullable persistent field */
    private String heferefienariz;

    /** nullable persistent field */
    private String hefcrefienariz;

    /** nullable persistent field */
    private String heferefieboca;

    /** nullable persistent field */
    private String hefcrefieboca;

    /** nullable persistent field */
    private String heferefiecuell;

    /** nullable persistent field */
    private String hefcrefiecuell;

    /** nullable persistent field */
    private String heferefietorax;

    /** nullable persistent field */
    private String hefcrefietorax;

    /** nullable persistent field */
    private String heferefiecoraz;

    /** nullable persistent field */
    private String hefcrefiecoraz;

    /** nullable persistent field */
    private String heferefiesenos;

    /** nullable persistent field */
    private String hefcrefiesenos;

    /** nullable persistent field */
    private String heferefieabdom;

    /** nullable persistent field */
    private String hefcrefieabdom;

    /** nullable persistent field */
    private String heferefiegenit;

    /** nullable persistent field */
    private String hefcrefiegenit;

    /** nullable persistent field */
    private String heferefieextre;

    /** nullable persistent field */
    private String hefcrefieextre;

    /** nullable persistent field */
    private String heferefieneuro;

    /** nullable persistent field */
    private String hefcrefieneuro;

    /** nullable persistent field */
    private String heferefietacto;

    /** nullable persistent field */
    private String hefcrefietacto;
    
    /** nullable persistent field */
    private String hefcdiscapadid;
    
    /** nullable persistent field */
    private String hefcdiscaselec;

    /** nullable persistent field */
    private String hefelugartemp;
    
   private String hefcdudointen; 
    
    private Integer hefnduradolor; 
    
    private Integer hefnescadolor; 
    private String hefcposiutero;
    private String hefcdesviautero;
    private String hefccuellocerra;
    private String hefcobscuecerra;
    private String hefcdolormovcuello;
    private String hefcsangrado;
    private String hefcecoespecialis;
    private Integer hefnedadsem;
    private Integer hefnedaddia;
    private Integer hefntamauterocm;
    private Integer  hefntamauteroml;
    private String  hefcevalupelvi;
    private String hefcconfiembar;
    private Integer hefnspo2;
   
    
    /** nullable persistent field */
    private String hefcobsereco;
    
    private String hefcdesccfemb;
    
    /** default constructor */
    public Chexamfisico() {
    }


    public void setId(ChexamfisicoPK id) {
        this.id = id;
    }

    public ChexamfisicoPK getId() {
        return id;
    }

    public void setHefcpresart1(String hefcpresart1) {
        this.hefcpresart1 = hefcpresart1;
    }

    public String getHefcpresart1() {
        return hefcpresart1;
    }

    public void setHefnfreccard(Integer hefnfreccard) {
        this.hefnfreccard = hefnfreccard;
    }

    public Integer getHefnfreccard() {
        return hefnfreccard;
    }

    public void setHefnfrecresp(Integer hefnfrecresp) {
        this.hefnfrecresp = hefnfrecresp;
    }

    public Integer getHefnfrecresp() {
        return hefnfrecresp;
    }

    public void setHefapeso(BigDecimal hefapeso) {
        this.hefapeso = hefapeso;
    }

    public BigDecimal getHefapeso() {
        return hefapeso;
    }

    public void setHefatalla(BigDecimal hefatalla) {
        this.hefatalla = hefatalla;
    }

    public BigDecimal getHefatalla() {
        return hefatalla;
    }

    public void setHefaimc(BigDecimal hefaimc) {
        this.hefaimc = hefaimc;
    }

    public BigDecimal getHefaimc() {
        return hefaimc;
    }

    public void setHefatemperatu(BigDecimal hefatemperatu) {
        this.hefatemperatu = hefatemperatu;
    }

    public BigDecimal getHefatemperatu() {
        return hefatemperatu;
    }

    public void setHefnpericefali(Integer hefnpericefali) {
        this.hefnpericefali = hefnpericefali;
    }

    public Integer getHefnpericefali() {
        return hefnpericefali;
    }

    public void setHefnsatuoxihe(Integer hefnsatuoxihe) {
        this.hefnsatuoxihe = hefnsatuoxihe;
    }

    public Integer getHefnsatuoxihe() {
        return hefnsatuoxihe;
    }

    public void setHefthallazgo(String hefthallazgo) {
        this.hefthallazgo = hefthallazgo;
    }

    public String getHefthallazgo() {
        return hefthallazgo;
    }

    public void setHefdfecregistr(Date hefdfecregistr) {
        this.hefdfecregistr = hefdfecregistr;
    }

    public Date getHefdfecregistr() {
        return hefdfecregistr;
    }

    public void setHefcoperador(String hefcoperador) {
        this.hefcoperador = hefcoperador;
    }

    public String getHefcoperador() {
        return hefcoperador;
    }


    public void setHefcpresart2(String hefcpresart2) {
        this.hefcpresart2 = hefcpresart2;
    }

    public String getHefcpresart2() {
        return hefcpresart2;
    }

    public void setHefetipotemper(String hefetipotemper) {
        this.hefetipotemper = hefetipotemper;
    }

    public String getHefetipotemper() {
        return hefetipotemper;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    /**
     * @param heferefiepiel
     */
    public void setHeferefiepiel(String heferefiepiel) {
        this.heferefiepiel = heferefiepiel;
    }

    /**
     * @return
     */
    public String getHeferefiepiel() {
        return heferefiepiel;
    }

    /**
     * @param hefcrefiepiel
     */
    public void setHefcrefiepiel(String hefcrefiepiel) {
        this.hefcrefiepiel = hefcrefiepiel;
    }

    /**
     * @return
     */
    public String getHefcrefiepiel() {
        return hefcrefiepiel;
    }

    /**
     * @param heferefiecrane
     */
    public void setHeferefiecrane(String heferefiecrane) {
        this.heferefiecrane = heferefiecrane;
    }

    /**
     * @return
     */
    public String getHeferefiecrane() {
        return heferefiecrane;
    }

    /**
     * @param hefcrefiecrane
     */
    public void setHefcrefiecrane(String hefcrefiecrane) {
        this.hefcrefiecrane = hefcrefiecrane;
    }

    /**
     * @return
     */
    public String getHefcrefiecrane() {
        return hefcrefiecrane;
    }

    /**
     * @param heferefieojos
     */
    public void setHeferefieojos(String heferefieojos) {
        this.heferefieojos = heferefieojos;
    }

    /**
     * @return
     */
    public String getHeferefieojos() {
        return heferefieojos;
    }

    /**
     * @param hefcrefieojos
     */
    public void setHefcrefieojos(String hefcrefieojos) {
        this.hefcrefieojos = hefcrefieojos;
    }

    /**
     * @return
     */
    public String getHefcrefieojos() {
        return hefcrefieojos;
    }

    /**
     * @param heferefieoidos
     */
    public void setHeferefieoidos(String heferefieoidos) {
        this.heferefieoidos = heferefieoidos;
    }

    /**
     * @return
     */
    public String getHeferefieoidos() {
        return heferefieoidos;
    }

    /**
     * @param hefcrefieoidos
     */
    public void setHefcrefieoidos(String hefcrefieoidos) {
        this.hefcrefieoidos = hefcrefieoidos;
    }

    /**
     * @return
     */
    public String getHefcrefieoidos() {
        return hefcrefieoidos;
    }

    /**
     * @param heferefienariz
     */
    public void setHeferefienariz(String heferefienariz) {
        this.heferefienariz = heferefienariz;
    }

    /**
     * @return
     */
    public String getHeferefienariz() {
        return heferefienariz;
    }

    /**
     * @param hefcrefienariz
     */
    public void setHefcrefienariz(String hefcrefienariz) {
        this.hefcrefienariz = hefcrefienariz;
    }

    /**
     * @return
     */
    public String getHefcrefienariz() {
        return hefcrefienariz;
    }

    /**
     * @param heferefieboca
     */
    public void setHeferefieboca(String heferefieboca) {
        this.heferefieboca = heferefieboca;
    }

    /**
     * @return
     */
    public String getHeferefieboca() {
        return heferefieboca;
    }

    /**
     * @param hefcrefieboca
     */
    public void setHefcrefieboca(String hefcrefieboca) {
        this.hefcrefieboca = hefcrefieboca;
    }

    /**
     * @return
     */
    public String getHefcrefieboca() {
        return hefcrefieboca;
    }

    /**
     * @param heferefiecuell
     */
    public void setHeferefiecuell(String heferefiecuell) {
        this.heferefiecuell = heferefiecuell;
    }

    /**
     * @return
     */
    public String getHeferefiecuell() {
        return heferefiecuell;
    }

    /**
     * @param hefcrefiecuell
     */
    public void setHefcrefiecuell(String hefcrefiecuell) {
        this.hefcrefiecuell = hefcrefiecuell;
    }

    /**
     * @return
     */
    public String getHefcrefiecuell() {
        return hefcrefiecuell;
    }

    /**
     * @param heferefietorax
     */
    public void setHeferefietorax(String heferefietorax) {
        this.heferefietorax = heferefietorax;
    }

    /**
     * @return
     */
    public String getHeferefietorax() {
        return heferefietorax;
    }

    /**
     * @param hefcrefietorax
     */
    public void setHefcrefietorax(String hefcrefietorax) {
        this.hefcrefietorax = hefcrefietorax;
    }

    /**
     * @return
     */
    public String getHefcrefietorax() {
        return hefcrefietorax;
    }

    /**
     * @param heferefiecoraz
     */
    public void setHeferefiecoraz(String heferefiecoraz) {
        this.heferefiecoraz = heferefiecoraz;
    }

    /**
     * @return
     */
    public String getHeferefiecoraz() {
        return heferefiecoraz;
    }

    /**
     * @param hefcrefiecoraz
     */
    public void setHefcrefiecoraz(String hefcrefiecoraz) {
        this.hefcrefiecoraz = hefcrefiecoraz;
    }

    /**
     * @return
     */
    public String getHefcrefiecoraz() {
        return hefcrefiecoraz;
    }

    /**
     * @param heferefiesenos
     */
    public void setHeferefiesenos(String heferefiesenos) {
        this.heferefiesenos = heferefiesenos;
    }

    /**
     * @return
     */
    public String getHeferefiesenos() {
        return heferefiesenos;
    }

    /**
     * @param hefcrefiesenos
     */
    public void setHefcrefiesenos(String hefcrefiesenos) {
        this.hefcrefiesenos = hefcrefiesenos;
    }

    /**
     * @return
     */
    public String getHefcrefiesenos() {
        return hefcrefiesenos;
    }

    /**
     * @param heferefieabdom
     */
    public void setHeferefieabdom(String heferefieabdom) {
        this.heferefieabdom = heferefieabdom;
    }

    /**
     * @return
     */
    public String getHeferefieabdom() {
        return heferefieabdom;
    }

    /**
     * @param hefcrefieabdom
     */
    public void setHefcrefieabdom(String hefcrefieabdom) {
        this.hefcrefieabdom = hefcrefieabdom;
    }

    /**
     * @return
     */
    public String getHefcrefieabdom() {
        return hefcrefieabdom;
    }

    /**
     * @param heferefiegenit
     */
    public void setHeferefiegenit(String heferefiegenit) {
        this.heferefiegenit = heferefiegenit;
    }

    /**
     * @return
     */
    public String getHeferefiegenit() {
        return heferefiegenit;
    }

    /**
     * @param hefcrefiegenit
     */
    public void setHefcrefiegenit(String hefcrefiegenit) {
        this.hefcrefiegenit = hefcrefiegenit;
    }

    /**
     * @return
     */
    public String getHefcrefiegenit() {
        return hefcrefiegenit;
    }

    /**
     * @param heferefieextre
     */
    public void setHeferefieextre(String heferefieextre) {
        this.heferefieextre = heferefieextre;
    }

    /**
     * @return
     */
    public String getHeferefieextre() {
        return heferefieextre;
    }

    /**
     * @param hefcrefieextre
     */
    public void setHefcrefieextre(String hefcrefieextre) {
        this.hefcrefieextre = hefcrefieextre;
    }

    /**
     * @return
     */
    public String getHefcrefieextre() {
        return hefcrefieextre;
    }

    /**
     * @param heferefieneuro
     */
    public void setHeferefieneuro(String heferefieneuro) {
        this.heferefieneuro = heferefieneuro;
    }

    /**
     * @return
     */
    public String getHeferefieneuro() {
        return heferefieneuro;
    }

    /**
     * @param hefcrefieneuro
     */
    public void setHefcrefieneuro(String hefcrefieneuro) {
        this.hefcrefieneuro = hefcrefieneuro;
    }

    /**
     * @return
     */
    public String getHefcrefieneuro() {
        return hefcrefieneuro;
    }

    /**
     * @param heferefietacto
     */
    public void setHeferefietacto(String heferefietacto) {
        this.heferefietacto = heferefietacto;
    }

    /**
     * @return
     */
    public String getHeferefietacto() {
        return heferefietacto;
    }

    /**
     * @param hefcrefietacto
     */
    public void setHefcrefietacto(String hefcrefietacto) {
        this.hefcrefietacto = hefcrefietacto;
    }

    /**
     * @return
     */
    public String getHefcrefietacto() {
        return hefcrefietacto;
    }

    public void setHefcdiscapadid(String hefcdiscapadid) {
        this.hefcdiscapadid = hefcdiscapadid;
    }

    public String getHefcdiscapadid() {
        return hefcdiscapadid;
    }

    public void setHefcdiscaselec(String hefcdiscaselec) {
        this.hefcdiscaselec = hefcdiscaselec;
    }

    public String getHefcdiscaselec() {
        return hefcdiscaselec;
    }


    public void setHefelugartemp(String hefelugartemp) {
        this.hefelugartemp = hefelugartemp;
    }

    public String getHefelugartemp() {
        return hefelugartemp;
    }

    public void setHefcposiutero(String hefcposiutero) {
        this.hefcposiutero = hefcposiutero;
    }

    public String getHefcposiutero() {
        return hefcposiutero;
    }

    public void setHefcdesviautero(String hefcdesviautero) {
        this.hefcdesviautero = hefcdesviautero;
    }

    public String getHefcdesviautero() {
        return hefcdesviautero;
    }

    public void setHefccuellocerra(String hefccuellocerra) {
        this.hefccuellocerra = hefccuellocerra;
    }

    public String getHefccuellocerra() {
        return hefccuellocerra;
    }

    public void setHefcobscuecerra(String hefcobscuecerra) {
        this.hefcobscuecerra = hefcobscuecerra;
    }

    public String getHefcobscuecerra() {
        return hefcobscuecerra;
    }

    public void setHefcdolormovcuello(String hefcdolormovcuello) {
        this.hefcdolormovcuello = hefcdolormovcuello;
    }

    public String getHefcdolormovcuello() {
        return hefcdolormovcuello;
    }

    public void setHefcsangrado(String hefcsangrado) {
        this.hefcsangrado = hefcsangrado;
    }

    public String getHefcsangrado() {
        return hefcsangrado;
    }

    public void setHefcecoespecialis(String hefcecoespecialis) {
        this.hefcecoespecialis = hefcecoespecialis;
    }

    public String getHefcecoespecialis() {
        return hefcecoespecialis;
    }

    public void setHefnedadsem(Integer hefnedadsem) {
        this.hefnedadsem = hefnedadsem;
    }

    public Integer getHefnedadsem() {
        return hefnedadsem;
    }

    public void setHefnedaddia(Integer hefnedaddia) {
        this.hefnedaddia = hefnedaddia;
    }

    public Integer getHefnedaddia() {
        return hefnedaddia;
    }

    public void setHefntamauterocm(Integer hefntamauterocm) {
        this.hefntamauterocm = hefntamauterocm;
    }

    public Integer getHefntamauterocm() {
        return hefntamauterocm;
    }

    public void setHefntamauteroml(Integer hefntamauteroml) {
        this.hefntamauteroml = hefntamauteroml;
    }

    public Integer getHefntamauteroml() {
        return hefntamauteroml;
    }
    
    public void setHefcdudointen(String hefcdudointen) {
        this.hefcdudointen = hefcdudointen;
    }

    public String getHefcdudointen() {
        return hefcdudointen;
    }

    public void setHefnduradolor(Integer hefnduradolor) {
        this.hefnduradolor = hefnduradolor;
    }

    public Integer getHefnduradolor() {
        return hefnduradolor;
    }

    public void setHefnescadolor(Integer hefnescadolor) {
        this.hefnescadolor = hefnescadolor;
    }

    public Integer getHefnescadolor() {
        return hefnescadolor;
    }

    public void setHefcevalupelvi(String hefcevalupelvi) {
        this.hefcevalupelvi = hefcevalupelvi;
    }

    public String getHefcevalupelvi() {
        return hefcevalupelvi;
    }

    public void setHefcconfiembar(String hefcconfiembar) {
        this.hefcconfiembar = hefcconfiembar;
    }

    public String getHefcconfiembar() {
        return hefcconfiembar;
    }

    public void setHefcobsereco(String hefcobsereco) {
        this.hefcobsereco = hefcobsereco;
    }

    public String getHefcobsereco() {
        return hefcobsereco;
    }

    public void setHefcdesccfemb(String hefcdesccfemb) {
        this.hefcdesccfemb = hefcdesccfemb;
    }

    public String getHefcdesccfemb() {
        return hefcdesccfemb;
    }

    public void setHefnspo2(Integer hefnspo2) {
        this.hefnspo2 = hefnspo2;
    }

    public Integer getHefnspo2() {
        return hefnspo2;
    }
}
