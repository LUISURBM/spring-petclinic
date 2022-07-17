package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chanatopatol implements Serializable {

    /** identifier field */
    private ChanatopatolPK id;

    /** nullable persistent field */
    private String hapcorigepieza;

    /** nullable persistent field */
    private Date hapdfecregistr;

    /** nullable persistent field */
    private String hapcoperador;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chanatopatol() {
    }


    public void setId(ChanatopatolPK id) {
        this.id = id;
    }

    public ChanatopatolPK getId() {
    if(id == null){
        id = new ChanatopatolPK();
    }
        return id;
    }

    public void setHapcorigepieza(String hapcorigepieza) {
        this.hapcorigepieza = hapcorigepieza;
    }

    public String getHapcorigepieza() {
        return hapcorigepieza;
    }

    public void setHapdfecregistr(Date hapdfecregistr) {
        this.hapdfecregistr = hapdfecregistr;
    }

    public Date getHapdfecregistr() {
        return hapdfecregistr;
    }

    public void setHapcoperador(String hapcoperador) {
        this.hapcoperador = hapcoperador;
    }

    public String getHapcoperador() {
        return hapcoperador;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }
}
