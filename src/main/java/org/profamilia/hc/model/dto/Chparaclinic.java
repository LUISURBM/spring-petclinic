package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;

public class Chparaclinic implements Serializable {


    /** identifier field */
    private ChparaclinicPK id;

    /** nullable persistent field */
    private Integer hpantipopara;

    /** nullable persistent field */
    private String hpatdescripcio;

    /** nullable persistent field */
    private Date hpadfecregistr;

    /** nullable persistent field */
    private String hpacoperador;

    /** nullable persistent field */
    private Integer version;
    
    /** Almacena el nombre del tipo del antecedente*/
    private String hpacnomtipante;

    /** default constructor */
    public Chparaclinic() {
        id = new ChparaclinicPK();
    }
    
    public void setId(ChparaclinicPK id) {
        this.id = id;
    }

    public ChparaclinicPK getId() {
        return id;
    }

   
    public void setHpatdescripcio(String hpatdescripcio) {
        this.hpatdescripcio = hpatdescripcio;
    }

    public String getHpatdescripcio() {
        return hpatdescripcio;
    }

    public void setHpadfecregistr(Date hpadfecregistr) {
        this.hpadfecregistr = hpadfecregistr;
    }

    public Date getHpadfecregistr() {
        return hpadfecregistr;
    }

    public void setHpacoperador(String hpacoperador) {
        this.hpacoperador = hpacoperador;
    }

    public String getHpacoperador() {
        return hpacoperador;
    }


    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHpacnomtipante(String hpacnomtipante) {
        this.hpacnomtipante = hpacnomtipante;
    }

    public String getHpacnomtipante() {
        return hpacnomtipante;
    }

    public void setHpantipopara(Integer hpantipopara) {
        this.hpantipopara = hpantipopara;
    }

    public Integer getHpantipopara() {
        return hpantipopara;
    }
}
