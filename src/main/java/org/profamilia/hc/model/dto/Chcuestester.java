package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chcuestester implements Serializable {

    /** identifier field */
    private ChcuestesterPK comp_id;

    /** nullable persistent field */
    private String hcecoperador;

    /** nullable persistent field */
    private Date hcedfecreg;

    /** nullable persistent field */
    private BigDecimal version;

    /** nullable persistent field */
    private String hcecobserv;

    /** nullable persistent field */
    private String hcecenfermo;

    /** nullable persistent field */
    private String hcecenfergrav;

    /** nullable persistent field */
    private String hcecoperado;

    /** nullable persistent field */
    private String hcectransfusion;

    /** nullable persistent field */
    private String hcecpresionalta;

    /** nullable persistent field */
    private String hcecejercicio;

    /** nullable persistent field */
    private String hcecpalpitacion;

    /** nullable persistent field */
    private String hcecsoplo;

    /** nullable persistent field */
    private String hcecasma;

    /** nullable persistent field */
    private String hcectos;

    /** nullable persistent field */
    private String hcecgripa;

    /** nullable persistent field */
    private String hcecfuma;

    /** nullable persistent field */
    private Integer hcecnocigarrillo;

    /** nullable persistent field */
    private String hcecprobanestesia;

    /** nullable persistent field */
    private String hcecalergia;

    /** nullable persistent field */
    private String hcecdrogas;

    /** nullable persistent field */
    private String hcecconvulsion;

    /** nullable persistent field */
    private String hcecenfermental;

    /** nullable persistent field */
    private String hcecdiabetes;

    /** nullable persistent field */
    private String hcechepatitis;

    /** nullable persistent field */
    private String hcecotraenfer;

    /** nullable persistent field */
    private String hcecembarazo;

    /** nullable persistent field */
    private Date hcedfechultmes;

    /** nullable persistent field */
    private String hcecmesnorm;

    /** nullable persistent field */
    private String hcecmetplan;

    /** nullable persistent field */
    private Date hcedfechaparto;

    /** nullable persistent field */
    private String hcecinfomet;

    /** nullable persistent field */
    private String hcecmetdef;

    /** nullable persistent field */
    private String hcecligfalla;

    /** nullable persistent field */
    private String hcecinsester;

    /** nullable persistent field */
    private String hcecanenfermo;

    /** nullable persistent field */
    private String hcecanenfergrav;

    /** nullable persistent field */
    private String hcecanoperado;

    /** nullable persistent field */
    private String hcecantransfusion;

    /** nullable persistent field */
    private String hcecanpresionalta;

    /** nullable persistent field */
    private String hcecanejercicio;

    /** nullable persistent field */
    private String hcecanpalpitacion;

    /** nullable persistent field */
    private String hcecansoplo;

    /** nullable persistent field */
    private String hcecanasma;

    /** nullable persistent field */
    private String hcecantos;

    /** nullable persistent field */
    private String hcecangripa;

    /** nullable persistent field */
    private String hcecanfuma;

    /** nullable persistent field */
    private String hcecanprobanestesia;

    /** nullable persistent field */
    private String hcecanalergia;

    /** nullable persistent field */
    private String hcecandrogas;

    /** nullable persistent field */
    private String hcecanconvulsion;

    /** nullable persistent field */
    private String hcecanenfermental;

    /** nullable persistent field */
    private String hcecandiabetes;

    /** nullable persistent field */
    private String hcecanhepatitis;

    /** nullable persistent field */
    private String hcecanotraenfer;

    /** nullable persistent field */
    private String hcecanembarazo;

    /** nullable persistent field */
    private String hcecanmesnorm;

    /** nullable persistent field */
    private String hcecanmetplan;

    /** nullable persistent field */
    private String hcecaninfomet;

    /** nullable persistent field */
    private String hcecanmetdef;

    /** nullable persistent field */
    private String hcecanligfalla;

    /** nullable persistent field */
    private String hcecaninsester;

    /** nullable persistent field */
    private String hcecesparto;

    /** nullable persistent field */
    private String hcecutilmetplan;

    /** default constructor */
    public Chcuestester() {
        comp_id = new ChcuestesterPK();
    }


    public void setComp_id(ChcuestesterPK comp_id) {
        this.comp_id = comp_id;
    }

    public ChcuestesterPK getComp_id() {
        return comp_id;
    }

    public void setHcecoperador(String hcecoperador) {
        this.hcecoperador = hcecoperador;
    }

    public String getHcecoperador() {
        return hcecoperador;
    }

    public void setHcedfecreg(Date hcedfecreg) {
        this.hcedfecreg = hcedfecreg;
    }

    public Date getHcedfecreg() {
        return hcedfecreg;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setHcecobserv(String hcecobserv) {
        this.hcecobserv = hcecobserv;
    }

    public String getHcecobserv() {
        return hcecobserv;
    }

    public void setHcecenfermo(String hcecenfermo) {
        this.hcecenfermo = hcecenfermo;
    }

    public String getHcecenfermo() {
        return hcecenfermo;
    }

    public void setHcecenfergrav(String hcecenfergrav) {
        this.hcecenfergrav = hcecenfergrav;
    }

    public String getHcecenfergrav() {
        return hcecenfergrav;
    }

    public void setHcecoperado(String hcecoperado) {
        this.hcecoperado = hcecoperado;
    }

    public String getHcecoperado() {
        return hcecoperado;
    }

    public void setHcectransfusion(String hcectransfusion) {
        this.hcectransfusion = hcectransfusion;
    }

    public String getHcectransfusion() {
        return hcectransfusion;
    }

    public void setHcecpresionalta(String hcecpresionalta) {
        this.hcecpresionalta = hcecpresionalta;
    }

    public String getHcecpresionalta() {
        return hcecpresionalta;
    }

    public void setHcecejercicio(String hcecejercicio) {
        this.hcecejercicio = hcecejercicio;
    }

    public String getHcecejercicio() {
        return hcecejercicio;
    }

    public void setHcecpalpitacion(String hcecpalpitacion) {
        this.hcecpalpitacion = hcecpalpitacion;
    }

    public String getHcecpalpitacion() {
        return hcecpalpitacion;
    }

    public void setHcecsoplo(String hcecsoplo) {
        this.hcecsoplo = hcecsoplo;
    }

    public String getHcecsoplo() {
        return hcecsoplo;
    }

    public void setHcecasma(String hcecasma) {
        this.hcecasma = hcecasma;
    }

    public String getHcecasma() {
        return hcecasma;
    }

    public void setHcectos(String hcectos) {
        this.hcectos = hcectos;
    }

    public String getHcectos() {
        return hcectos;
    }

    public void setHcecgripa(String hcecgripa) {
        this.hcecgripa = hcecgripa;
    }

    public String getHcecgripa() {
        return hcecgripa;
    }

    public void setHcecfuma(String hcecfuma) {
        this.hcecfuma = hcecfuma;
    }

    public String getHcecfuma() {
        return hcecfuma;
    }

    public void setHcecnocigarrillo(Integer hcecnocigarrillo) {
        this.hcecnocigarrillo = hcecnocigarrillo;
    }

    public Integer getHcecnocigarrillo() {
        return hcecnocigarrillo;
    }

    public void setHcecprobanestesia(String hcecprobanestesia) {
        this.hcecprobanestesia = hcecprobanestesia;
    }

    public String getHcecprobanestesia() {
        return hcecprobanestesia;
    }

    public void setHcecalergia(String hcecalergia) {
        this.hcecalergia = hcecalergia;
    }

    public String getHcecalergia() {
        return hcecalergia;
    }

    public void setHcecdrogas(String hcecdrogas) {
        this.hcecdrogas = hcecdrogas;
    }

    public String getHcecdrogas() {
        return hcecdrogas;
    }

    public void setHcecconvulsion(String hcecconvulsion) {
        this.hcecconvulsion = hcecconvulsion;
    }

    public String getHcecconvulsion() {
        return hcecconvulsion;
    }

    public void setHcecenfermental(String hcecenfermental) {
        this.hcecenfermental = hcecenfermental;
    }

    public String getHcecenfermental() {
        return hcecenfermental;
    }

    public void setHcecdiabetes(String hcecdiabetes) {
        this.hcecdiabetes = hcecdiabetes;
    }

    public String getHcecdiabetes() {
        return hcecdiabetes;
    }

    public void setHcechepatitis(String hcechepatitis) {
        this.hcechepatitis = hcechepatitis;
    }

    public String getHcechepatitis() {
        return hcechepatitis;
    }

    public void setHcecotraenfer(String hcecotraenfer) {
        this.hcecotraenfer = hcecotraenfer;
    }

    public String getHcecotraenfer() {
        return hcecotraenfer;
    }

    public void setHcecembarazo(String hcecembarazo) {
        this.hcecembarazo = hcecembarazo;
    }

    public String getHcecembarazo() {
        return hcecembarazo;
    }

    public void setHcedfechultmes(Date hcedfechultmes) {
        this.hcedfechultmes = hcedfechultmes;
    }

    public Date getHcedfechultmes() {
        return hcedfechultmes;
    }

    public void setHcecmesnorm(String hcecmesnorm) {
        this.hcecmesnorm = hcecmesnorm;
    }

    public String getHcecmesnorm() {
        return hcecmesnorm;
    }

    public void setHcecmetplan(String hcecmetplan) {
        this.hcecmetplan = hcecmetplan;
    }

    public String getHcecmetplan() {
        return hcecmetplan;
    }

    public void setHcedfechaparto(Date hcedfechaparto) {
        this.hcedfechaparto = hcedfechaparto;
    }

    public Date getHcedfechaparto() {
        return hcedfechaparto;
    }

    public void setHcecinfomet(String hcecinfomet) {
        this.hcecinfomet = hcecinfomet;
    }

    public String getHcecinfomet() {
        return hcecinfomet;
    }

    public void setHcecmetdef(String hcecmetdef) {
        this.hcecmetdef = hcecmetdef;
    }

    public String getHcecmetdef() {
        return hcecmetdef;
    }

    public void setHcecligfalla(String hcecligfalla) {
        this.hcecligfalla = hcecligfalla;
    }

    public String getHcecligfalla() {
        return hcecligfalla;
    }

    public void setHcecinsester(String hcecinsester) {
        this.hcecinsester = hcecinsester;
    }

    public String getHcecinsester() {
        return hcecinsester;
    }

    public void setHcecanenfermo(String hcecanenfermo) {
        this.hcecanenfermo = hcecanenfermo;
    }

    public String getHcecanenfermo() {
        return hcecanenfermo;
    }

    public void setHcecanenfergrav(String hcecanenfergrav) {
        this.hcecanenfergrav = hcecanenfergrav;
    }

    public String getHcecanenfergrav() {
        return hcecanenfergrav;
    }

    public void setHcecanoperado(String hcecanoperado) {
        this.hcecanoperado = hcecanoperado;
    }

    public String getHcecanoperado() {
        return hcecanoperado;
    }

    public void setHcecantransfusion(String hcecantransfusion) {
        this.hcecantransfusion = hcecantransfusion;
    }

    public String getHcecantransfusion() {
        return hcecantransfusion;
    }

    public void setHcecanpresionalta(String hcecanpresionalta) {
        this.hcecanpresionalta = hcecanpresionalta;
    }

    public String getHcecanpresionalta() {
        return hcecanpresionalta;
    }

    public void setHcecanejercicio(String hcecanejercicio) {
        this.hcecanejercicio = hcecanejercicio;
    }

    public String getHcecanejercicio() {
        return hcecanejercicio;
    }

    public void setHcecanpalpitacion(String hcecanpalpitacion) {
        this.hcecanpalpitacion = hcecanpalpitacion;
    }

    public String getHcecanpalpitacion() {
        return hcecanpalpitacion;
    }

    public void setHcecansoplo(String hcecansoplo) {
        this.hcecansoplo = hcecansoplo;
    }

    public String getHcecansoplo() {
        return hcecansoplo;
    }

    public void setHcecanasma(String hcecanasma) {
        this.hcecanasma = hcecanasma;
    }

    public String getHcecanasma() {
        return hcecanasma;
    }

    public void setHcecantos(String hcecantos) {
        this.hcecantos = hcecantos;
    }

    public String getHcecantos() {
        return hcecantos;
    }

    public void setHcecangripa(String hcecangripa) {
        this.hcecangripa = hcecangripa;
    }

    public String getHcecangripa() {
        return hcecangripa;
    }

    public void setHcecanfuma(String hcecanfuma) {
        this.hcecanfuma = hcecanfuma;
    }

    public String getHcecanfuma() {
        return hcecanfuma;
    }

    public void setHcecanprobanestesia(String hcecanprobanestesia) {
        this.hcecanprobanestesia = hcecanprobanestesia;
    }

    public String getHcecanprobanestesia() {
        return hcecanprobanestesia;
    }

    public void setHcecanalergia(String hcecanalergia) {
        this.hcecanalergia = hcecanalergia;
    }

    public String getHcecanalergia() {
        return hcecanalergia;
    }

    public void setHcecandrogas(String hcecandrogas) {
        this.hcecandrogas = hcecandrogas;
    }

    public String getHcecandrogas() {
        return hcecandrogas;
    }

    public void setHcecanconvulsion(String hcecanconvulsion) {
        this.hcecanconvulsion = hcecanconvulsion;
    }

    public String getHcecanconvulsion() {
        return hcecanconvulsion;
    }

    public void setHcecanenfermental(String hcecanenfermental) {
        this.hcecanenfermental = hcecanenfermental;
    }

    public String getHcecanenfermental() {
        return hcecanenfermental;
    }

    public void setHcecandiabetes(String hcecandiabetes) {
        this.hcecandiabetes = hcecandiabetes;
    }

    public String getHcecandiabetes() {
        return hcecandiabetes;
    }

    public void setHcecanhepatitis(String hcecanhepatitis) {
        this.hcecanhepatitis = hcecanhepatitis;
    }

    public String getHcecanhepatitis() {
        return hcecanhepatitis;
    }

    public void setHcecanotraenfer(String hcecanotraenfer) {
        this.hcecanotraenfer = hcecanotraenfer;
    }

    public String getHcecanotraenfer() {
        return hcecanotraenfer;
    }

    public void setHcecanembarazo(String hcecanembarazo) {
        this.hcecanembarazo = hcecanembarazo;
    }

    public String getHcecanembarazo() {
        return hcecanembarazo;
    }

    public void setHcecanmesnorm(String hcecanmesnorm) {
        this.hcecanmesnorm = hcecanmesnorm;
    }

    public String getHcecanmesnorm() {
        return hcecanmesnorm;
    }

    public void setHcecanmetplan(String hcecanmetplan) {
        this.hcecanmetplan = hcecanmetplan;
    }

    public String getHcecanmetplan() {
        return hcecanmetplan;
    }

    public void setHcecaninfomet(String hcecaninfomet) {
        this.hcecaninfomet = hcecaninfomet;
    }

    public String getHcecaninfomet() {
        return hcecaninfomet;
    }

    public void setHcecanmetdef(String hcecanmetdef) {
        this.hcecanmetdef = hcecanmetdef;
    }

    public String getHcecanmetdef() {
        return hcecanmetdef;
    }

    public void setHcecanligfalla(String hcecanligfalla) {
        this.hcecanligfalla = hcecanligfalla;
    }

    public String getHcecanligfalla() {
        return hcecanligfalla;
    }

    public void setHcecaninsester(String hcecaninsester) {
        this.hcecaninsester = hcecaninsester;
    }

    public String getHcecaninsester() {
        return hcecaninsester;
    }

    public void setHcecesparto(String hcecesparto) {
        this.hcecesparto = hcecesparto;
    }

    public String getHcecesparto() {
        return hcecesparto;
    }

    public void setHcecutilmetplan(String hcecutilmetplan) {
        this.hcecutilmetplan = hcecutilmetplan;
    }

    public String getHcecutilmetplan() {
        return hcecutilmetplan;
    }
}
