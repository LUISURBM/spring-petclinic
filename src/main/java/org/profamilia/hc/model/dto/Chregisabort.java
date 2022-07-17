package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chregisabort implements Serializable {

    /** identifier field */
    private Long hralnumero;

    /** persistent field */
    private long hralregiusua;

    /** persistent field */
    private Date hradfechregi;

    /** persistent field */
    private String hracusuaregi;

    /** nullable persistent field */
    private String hracobservac;

    /** nullable persistent field */
    private Integer hranclinica;

    /** nullable persistent field */
    private String hracetapa;

    /** persistent field */
    private String hraceps;

    /** nullable persistent field */
    private Date hradultmen;

    /** nullable persistent field */
    private Double hransememb;

    /** persistent field */
    private String hraccontprog;

    /** persistent field */
    private String hracregistro;

    /** persistent field */
    private String hraconsumed;

    /** persistent field */
    private String hracpsicolo;

    /** persistent field */
    private String hracseguim;

    /** persistent field */
    private String hracproced;

    /** persistent field */
    private String hracadmin;

    /** nullable persistent field */
    private String hracfarma;

    /** nullable persistent field */
    private String hraccodcups;

    /** nullable persistent field */
    private String hracmedcons;

    /** nullable persistent field */
    private Date hradfecdismed;

    /** nullable persistent field */
    private Date hradfecusumed;

    /** nullable persistent field */
    private Date hradfectommed;
    
    /** nullable persistent field */
    private String hraccontrol;

    /** full constructor */
    public Chregisabort(Long hralnumero, long hralnumeusua, Date hradfechregi, String hracusuaregi, String hracobservac, Integer hranclinica, String hracetapa, String hraceps, Date hradultmen, Double hransememb, String hraccontprog, String hracregistro, String hraconsumed, String hracpsicolo, String hracseguim, String hracproced, String hracadmin, String hracfarma, String hraccodcups, String hracmedcons, Date hradfecdismed, Date hradfecusumed, Date hradfectommed) {
        this.hralnumero = hralnumero;
        this.hradfechregi = hradfechregi;
        this.hracusuaregi = hracusuaregi;
        this.hracobservac = hracobservac;
        this.hranclinica = hranclinica;
        this.hracetapa = hracetapa;
        this.hraceps = hraceps;
        this.hradultmen = hradultmen;
        this.hransememb = hransememb;
        this.hraccontprog = hraccontprog;
        this.hracregistro = hracregistro;
        this.hraconsumed = hraconsumed;
        this.hracpsicolo = hracpsicolo;
        this.hracseguim = hracseguim;
        this.hracproced = hracproced;
        this.hracadmin = hracadmin;
        this.hracfarma = hracfarma;
        this.hraccodcups = hraccodcups;
        this.hracmedcons = hracmedcons;
        this.hradfecdismed = hradfecdismed;
        this.hradfecusumed = hradfecusumed;
        this.hradfectommed = hradfectommed;
    }

    /** default constructor */
    public Chregisabort() {
    }

    /** minimal constructor */
    public Chregisabort(Long hralnumero, long hralnumeusua, Date hradfechregi, String hracusuaregi, String hraceps, String hraccontprog, String hracregistro, String hraconsumed, String hracpsicolo, String hracseguim, String hracproced, String hracadmin) {
        this.hralnumero = hralnumero;
        this.hradfechregi = hradfechregi;
        this.hracusuaregi = hracusuaregi;
        this.hraceps = hraceps;
        this.hraccontprog = hraccontprog;
        this.hracregistro = hracregistro;
        this.hraconsumed = hraconsumed;
        this.hracpsicolo = hracpsicolo;
        this.hracseguim = hracseguim;
        this.hracproced = hracproced;
        this.hracadmin = hracadmin;
    }

    public Long getHralnumero() {
        return this.hralnumero;
    }

    public void setHralnumero(Long hralnumero) {
        this.hralnumero = hralnumero;
    }
    
    public Date getHradfechregi() {
        return this.hradfechregi;
    }

    public void setHradfechregi(Date hradfechregi) {
        this.hradfechregi = hradfechregi;
    }

    public String getHracusuaregi() {
        return this.hracusuaregi;
    }

    public void setHracusuaregi(String hracusuaregi) {
        this.hracusuaregi = hracusuaregi;
    }

    public String getHracobservac() {
        return this.hracobservac;
    }

    public void setHracobservac(String hracobservac) {
        this.hracobservac = hracobservac;
    }

    public Integer getHranclinica() {
        return this.hranclinica;
    }

    public void setHranclinica(Integer hranclinica) {
        this.hranclinica = hranclinica;
    }

    public String getHracetapa() {
        return this.hracetapa;
    }

    public void setHracetapa(String hracetapa) {
        this.hracetapa = hracetapa;
    }

    public String getHraceps() {
        return this.hraceps;
    }

    public void setHraceps(String hraceps) {
        this.hraceps = hraceps;
    }

    public Date getHradultmen() {
        return this.hradultmen;
    }

    public void setHradultmen(Date hradultmen) {
        this.hradultmen = hradultmen;
    }

    public Double getHransememb() {
        return this.hransememb;
    }

    public void setHransememb(Double hransememb) {
        this.hransememb = hransememb;
    }

    public String getHraccontprog() {
        return this.hraccontprog;
    }

    public void setHraccontprog(String hraccontprog) {
        this.hraccontprog = hraccontprog;
    }

    public String getHracregistro() {
        return this.hracregistro;
    }

    public void setHracregistro(String hracregistro) {
        this.hracregistro = hracregistro;
    }

    public String getHraconsumed() {
        return this.hraconsumed;
    }

    public void setHraconsumed(String hraconsumed) {
        this.hraconsumed = hraconsumed;
    }

    public String getHracpsicolo() {
        return this.hracpsicolo;
    }

    public void setHracpsicolo(String hracpsicolo) {
        this.hracpsicolo = hracpsicolo;
    }

    public String getHracseguim() {
        return this.hracseguim;
    }

    public void setHracseguim(String hracseguim) {
        this.hracseguim = hracseguim;
    }

    public String getHracproced() {
        return this.hracproced;
    }

    public void setHracproced(String hracproced) {
        this.hracproced = hracproced;
    }

    public String getHracadmin() {
        return this.hracadmin;
    }

    public void setHracadmin(String hracadmin) {
        this.hracadmin = hracadmin;
    }

    public String getHracfarma() {
        return this.hracfarma;
    }

    public void setHracfarma(String hracfarma) {
        this.hracfarma = hracfarma;
    }

    public String getHraccodcups() {
        return this.hraccodcups;
    }

    public void setHraccodcups(String hraccodcups) {
        this.hraccodcups = hraccodcups;
    }

    public String getHracmedcons() {
        return this.hracmedcons;
    }

    public void setHracmedcons(String hracmedcons) {
        this.hracmedcons = hracmedcons;
    }

    public Date getHradfecdismed() {
        return this.hradfecdismed;
    }

    public void setHradfecdismed(Date hradfecdismed) {
        this.hradfecdismed = hradfecdismed;
    }

    public Date getHradfecusumed() {
        return this.hradfecusumed;
    }

    public void setHradfecusumed(Date hradfecusumed) {
        this.hradfecusumed = hradfecusumed;
    }

    public Date getHradfectommed() {
        return this.hradfectommed;
    }

    public void setHradfectommed(Date hradfectommed) {
        this.hradfectommed = hradfectommed;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hralnumero", getHralnumero())
            .toString();
    }

    public void setHralregiusua(long hralregiusua) {
        this.hralregiusua = hralregiusua;
    }

    public long getHralregiusua() {
        return hralregiusua;
    }

    public void setHraccontrol(String hraccontrol) {
        this.hraccontrol = hraccontrol;
    }

    public String getHraccontrol() {
        return hraccontrol;
    }
}
