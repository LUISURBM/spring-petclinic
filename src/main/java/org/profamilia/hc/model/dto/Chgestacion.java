package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chgestacion implements Serializable {

    /** identifier field */
    private ChgestacionPK id;

    /** nullable persistent field */
    private String hgeeprevantite;

    /** nullable persistent field */
    private String hgeeantidosis1;

    /** nullable persistent field */
    private Date hgedfecantdos1;

    /** nullable persistent field */
    private String hgeeantidosis2;

    /** nullable persistent field */
    private Date hgedfecantdos2;

    /** nullable persistent field */
    private String hgeepreantrube;

    /** nullable persistent field */
    private String hgeeactantrube;

    /** nullable persistent field */
    private Date hgedfecantrube;

    /** nullable persistent field */
    private String hgecrhpaciente;

    /** nullable persistent field */
    private String hgecgrupopacie;

    /** nullable persistent field */
    private String hgecrhesposo;

    /** nullable persistent field */
    private String hgecgrupoespos;

    /** nullable persistent field */
    private String hgecsensibilid;

    /** nullable persistent field */
    private String hgeesolicivih1;

    /** nullable persistent field */
    private String hgeerealizvih1;

    /** nullable persistent field */
    private Date hgedfecregistr;

    /** nullable persistent field */
    private String hgecoperador;

    /** nullable persistent field */
    private Long hgelconsulprin;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String hgecedadgest;   
    
    /** nullable persistent field */
    private String hgecconedages;
    
    /** nullable persistent field */
    private String hgecsignosinto;
    
    /** nullable persistent field */
    private String hgecmovimfetal;
    
    

    /** default constructor */
    public Chgestacion() {
    }


    public void setId(ChgestacionPK id) {
        this.id = id;
    }

    public ChgestacionPK getId() {
        return id;
    }

    public void setHgeeprevantite(String hgeeprevantite) {
        this.hgeeprevantite = hgeeprevantite;
    }

    public String getHgeeprevantite() {
        return hgeeprevantite;
    }

    public void setHgeeantidosis1(String hgeeantidosis1) {
        this.hgeeantidosis1 = hgeeantidosis1;
    }

    public String getHgeeantidosis1() {
        return hgeeantidosis1;
    }

    public void setHgedfecantdos1(Date hgedfecantdos1) {
        this.hgedfecantdos1 = hgedfecantdos1;
    }

    public Date getHgedfecantdos1() {
        return hgedfecantdos1;
    }

    public void setHgeeantidosis2(String hgeeantidosis2) {
        this.hgeeantidosis2 = hgeeantidosis2;
    }

    public String getHgeeantidosis2() {
        return hgeeantidosis2;
    }

    public void setHgedfecantdos2(Date hgedfecantdos2) {
        this.hgedfecantdos2 = hgedfecantdos2;
    }

    public Date getHgedfecantdos2() {
        return hgedfecantdos2;
    }

    public void setHgeepreantrube(String hgeepreantrube) {
        this.hgeepreantrube = hgeepreantrube;
    }

    public String getHgeepreantrube() {
        return hgeepreantrube;
    }

    public void setHgeeactantrube(String hgeeactantrube) {
        this.hgeeactantrube = hgeeactantrube;
    }

    public String getHgeeactantrube() {
        return hgeeactantrube;
    }

    public void setHgedfecantrube(Date hgedfecantrube) {
        this.hgedfecantrube = hgedfecantrube;
    }

    public Date getHgedfecantrube() {
        return hgedfecantrube;
    }

    public void setHgecrhpaciente(String hgecrhpaciente) {
        this.hgecrhpaciente = hgecrhpaciente;
    }

    public String getHgecrhpaciente() {
        return hgecrhpaciente;
    }

    public void setHgecgrupopacie(String hgecgrupopacie) {
        this.hgecgrupopacie = hgecgrupopacie;
    }

    public String getHgecgrupopacie() {
        return hgecgrupopacie;
    }

    public void setHgecrhesposo(String hgecrhesposo) {
        this.hgecrhesposo = hgecrhesposo;
    }

    public String getHgecrhesposo() {
        return hgecrhesposo;
    }

    public void setHgecgrupoespos(String hgecgrupoespos) {
        this.hgecgrupoespos = hgecgrupoespos;
    }

    public String getHgecgrupoespos() {
        return hgecgrupoespos;
    }

    public void setHgecsensibilid(String hgecsensibilid) {
        this.hgecsensibilid = hgecsensibilid;
    }

    public String getHgecsensibilid() {
        return hgecsensibilid;
    }

    public void setHgeesolicivih1(String hgeesolicivih1) {
        this.hgeesolicivih1 = hgeesolicivih1;
    }

    public String getHgeesolicivih1() {
        return hgeesolicivih1;
    }

    public void setHgeerealizvih1(String hgeerealizvih1) {
        this.hgeerealizvih1 = hgeerealizvih1;
    }

    public String getHgeerealizvih1() {
        return hgeerealizvih1;
    }

    public void setHgedfecregistr(Date hgedfecregistr) {
        this.hgedfecregistr = hgedfecregistr;
    }

    public Date getHgedfecregistr() {
        return hgedfecregistr;
    }

    public void setHgecoperador(String hgecoperador) {
        this.hgecoperador = hgecoperador;
    }

    public String getHgecoperador() {
        return hgecoperador;
    }

    public void setHgelconsulprin(Long hgelconsulprin) {
        this.hgelconsulprin = hgelconsulprin;
    }

    public Long getHgelconsulprin() {
        return hgelconsulprin;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHgecedadgest(String hgecedadgest) {
        this.hgecedadgest = hgecedadgest;
    }

    public String getHgecedadgest() {
        return hgecedadgest;
    }
    
    public void setHgecsignosinto(String hgecsignosinto) {
        this.hgecsignosinto = hgecsignosinto;
    }

    public String getHgecsignosinto() {
        return hgecsignosinto;
    }

    public void setHgecconedages(String hgecconedages) {
        this.hgecconedages = hgecconedages;
    }

    public String getHgecconedages() {
        return hgecconedages;
    }

    public void setHgecmovimfetal(String hgecmovimfetal) {
        this.hgecmovimfetal = hgecmovimfetal;
    }

    public String getHgecmovimfetal() {
        return hgecmovimfetal;
    }
}
