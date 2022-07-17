package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chriesgomama implements Serializable {

    /** identifier field */
    private ChriesgomamaPK id;

    /** nullable persistent field */
    private String hrmemenarantes;

    /** nullable persistent field */
    private String hrmemenopadesp;

    /** nullable persistent field */
    private String hrmeembaradesp;

    /** nullable persistent field */
    private String hrmeterahormon;

    /** nullable persistent field */
    private String hrmeantecancer;

    /** nullable persistent field */
    private String hrmelactancia;

    /** nullable persistent field */
    private Integer hrmnantebiopma;

    /** nullable persistent field */
    private String hrmefamicancer;

    /** nullable persistent field */
    private String hrmcoperador;

    /** nullable persistent field */
    private Date hrmdfecregistr;

    /** nullable persistent field */
    private Integer hrmnanosterap;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String hrmccancerpers;

    /** nullable persistent field */
    private String hrmccancerfami;

    /** nullable persistent field */
    private Integer hrmnlactacum;


    /** default constructor */
    public Chriesgomama() {
    }


    public void setId(ChriesgomamaPK id) {
        this.id = id;
    }

    public ChriesgomamaPK getId() {
        return id;
    }

    public void setHrmemenarantes(String hrmemenarantes) {
        this.hrmemenarantes = hrmemenarantes;
    }

    public String getHrmemenarantes() {
        return hrmemenarantes;
    }

    public void setHrmemenopadesp(String hrmemenopadesp) {
        this.hrmemenopadesp = hrmemenopadesp;
    }

    public String getHrmemenopadesp() {
        return hrmemenopadesp;
    }

    public void setHrmeembaradesp(String hrmeembaradesp) {
        this.hrmeembaradesp = hrmeembaradesp;
    }

    public String getHrmeembaradesp() {
        return hrmeembaradesp;
    }

    public void setHrmeterahormon(String hrmeterahormon) {
        this.hrmeterahormon = hrmeterahormon;
    }

    public String getHrmeterahormon() {
        return hrmeterahormon;
    }

    public void setHrmeantecancer(String hrmeantecancer) {
        this.hrmeantecancer = hrmeantecancer;
    }

    public String getHrmeantecancer() {
        return hrmeantecancer;
    }

    public void setHrmelactancia(String hrmelactancia) {
        this.hrmelactancia = hrmelactancia;
    }

    public String getHrmelactancia() {
        return hrmelactancia;
    }

    public void setHrmnantebiopma(Integer hrmnantebiopma) {
        this.hrmnantebiopma = hrmnantebiopma;
    }

    public Integer getHrmnantebiopma() {
        return hrmnantebiopma;
    }

    public void setHrmefamicancer(String hrmefamicancer) {
        this.hrmefamicancer = hrmefamicancer;
    }

    public String getHrmefamicancer() {
        return hrmefamicancer;
    }

    public void setHrmcoperador(String hrmcoperador) {
        this.hrmcoperador = hrmcoperador;
    }

    public String getHrmcoperador() {
        return hrmcoperador;
    }

    public void setHrmdfecregistr(Date hrmdfecregistr) {
        this.hrmdfecregistr = hrmdfecregistr;
    }

    public Date getHrmdfecregistr() {
        return hrmdfecregistr;
    }

    public void setHrmnanosterap(Integer hrmnanosterap) {
        this.hrmnanosterap = hrmnanosterap;
    }

    public Integer getHrmnanosterap() {
        return hrmnanosterap;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHrmccancerpers(String hrmccancerpers) {
        this.hrmccancerpers = hrmccancerpers;
    }

    public String getHrmccancerpers() {
        return hrmccancerpers;
    }

    public void setHrmccancerfami(String hrmccancerfami) {
        this.hrmccancerfami = hrmccancerfami;
    }

    public String getHrmccancerfami() {
        return hrmccancerfami;
    }

    public void setHrmnlactacum(Integer hrmnlactacum) {
        this.hrmnlactacum = hrmnlactacum;
    }

    public Integer getHrmnlactacum() {
        return hrmnlactacum;
    }


}
