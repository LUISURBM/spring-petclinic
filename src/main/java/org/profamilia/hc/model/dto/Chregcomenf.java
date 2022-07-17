package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chregcomenf implements Serializable {

    /** identifier field */
    private ChregcomenfPK id;

    /** nullable persistent field */
    private String hrcecdescripc;

    /** nullable persistent field */
    private String hrcecoperador;

    /** nullable persistent field */
    private Date hrcedfecregistr;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chregcomenf() {
    }


    public void setId(ChregcomenfPK id) {
        this.id = id;
    }

    public ChregcomenfPK getId() {
        return id;
    }

    public void sethrcecdescripc(String hrcecdescripc) {
        this.hrcecdescripc = hrcecdescripc;
    }

    public String gethrcecdescripc() {
        return hrcecdescripc;
    }

    public void sethrcecoperador(String hrcecoperador) {
        this.hrcecoperador = hrcecoperador;
    }

    public String gethrcecoperador() {
        return hrcecoperador;
    }

    public void sethrcedfecregistr(Date hrcedfecregistr) {
        this.hrcedfecregistr = hrcedfecregistr;
    }

    public Date gethrcedfecregistr() {
        return hrcedfecregistr;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }
}
