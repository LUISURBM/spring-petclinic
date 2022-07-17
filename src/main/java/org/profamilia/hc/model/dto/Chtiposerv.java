package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chtiposerv implements Serializable {

    /** identifier field */
    private Integer htsncodigo;

    /** persistent field */
    private String htscdescripc;

    /** persistent field */
    private String htscestado;


    /** persistent field */
    private String htscdescestado;

    /** persistent field */
    private String htscoperador;

    /** persistent field */
    private Date htsdfechregi;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chtiposerv() {
    }


    public Integer getHtsncodigo() {
        return this.htsncodigo;
    }

    public void setHtsncodigo(Integer htsncodigo) {
        this.htsncodigo = htsncodigo;
    }

    public String getHtscdescripc() {
        if (htscdescripc != null) {
            return this.htscdescripc.toUpperCase();
        }

        return this.htscdescripc;
    }

    public void setHtscdescripc(String htscdescripc) {
        this.htscdescripc = htscdescripc;
    }

    public String getHtscestado() {
        return this.htscestado;
    }

    public void setHtscestado(String htscestado) {
        this.htscestado = htscestado;
    }

    public String getHtscoperador() {
        return this.htscoperador;
    }

    public void setHtscoperador(String htscoperador) {
        this.htscoperador = htscoperador;
    }

    public Date getHtsdfechregi() {
        return this.htsdfechregi;
    }

    public void setHtsdfechregi(Date htsdfechregi) {
        this.htsdfechregi = htsdfechregi;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this).append("htsncodigo", 
                                                getHtsncodigo()).toString();
    }

    public void setHtscdescestado(String htscdescestado) {
        this.htscdescestado = htscdescestado;
    }

    public String getHtscdescestado() {
        htscdescestado = ""; 
    if(htscestado != null){
        if(htscestado.equals("AC")){
            htscdescestado = "Activo"; 
        }else if(htscestado.equals("IN")){
            htscdescestado = "Inactivo"; 
        }
    }
    
        return htscdescestado;
    }
}
