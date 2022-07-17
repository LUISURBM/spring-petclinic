package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;



/** @author Hibernate CodeGenerator */
public class Chestadpsico implements Serializable {

    /** identifier field */
    private ChestadpsicoPK id;

    /** nullable persistent field */
    private String hepcoperador;

    /** nullable persistent field */
    private Date hepdfecreg;

    /** nullable persistent field */
    private String hepcareaafect;

    /** nullable persistent field */
    private String hepcareacogni;

    /** nullable persistent field */
    private String hepcareasomat;

    /** nullable persistent field */
    private String hepcarearelac;

    /** nullable persistent field */
    private String hepcotrosomat;

    /** nullable persistent field */
    private String hepcotrorelac;

    /** nullable persistent field */
    private String hepcotrocogni;

    /** nullable persistent field */
    private String hepcobservacio;
     
    /** nullable persistent field */
    private String hepccualfobia;

    /** nullable persistent field */
    private Integer version;

   

    /** default constructor */
    public Chestadpsico() {
        id = new ChestadpsicoPK();
    
    }


    /**
     * @param id
     */
    public void setId(ChestadpsicoPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChestadpsicoPK getId() {
        return id;
    }

    /**
     * @param hepcoperador
     */
    public void setHepcoperador(String hepcoperador) {
        this.hepcoperador = hepcoperador;
    }

    /**
     * @return
     */
    public String getHepcoperador() {
        return hepcoperador;
    }

    /**
     * @param hepdfecreg
     */
    public void setHepdfecreg(Date hepdfecreg) {
        this.hepdfecreg = hepdfecreg;
    }

    /**
     * @return
     */
    public Date getHepdfecreg() {
        return hepdfecreg;
    }

    /**
     * @param hepcareaafect
     */
    public void setHepcareaafect(String hepcareaafect) {
        this.hepcareaafect = hepcareaafect;
    }

    /**
     * @return
     */
    public String getHepcareaafect() {
        return hepcareaafect;
    }

    /**
     * @param hepcareacogni
     */
    public void setHepcareacogni(String hepcareacogni) {
        this.hepcareacogni = hepcareacogni;
    }

    /**
     * @return
     */
    public String getHepcareacogni() {
        return hepcareacogni;
    }

    /**
     * @param hepcareasomat
     */
    public void setHepcareasomat(String hepcareasomat) {
        this.hepcareasomat = hepcareasomat;
    }

    /**
     * @return
     */
    public String getHepcareasomat() {
        return hepcareasomat;
    }

    /**
     * @param hepcarearelac
     */
    public void setHepcarearelac(String hepcarearelac) {
        this.hepcarearelac = hepcarearelac;
    }

    /**
     * @return
     */
    public String getHepcarearelac() {
        return hepcarearelac;
    }

    /**
     * @param hepcotrosomat
     */
    public void setHepcotrosomat(String hepcotrosomat) {
        this.hepcotrosomat = hepcotrosomat;
    }

    /**
     * @return
     */
    public String getHepcotrosomat() {
        return hepcotrosomat;
    }

    /**
     * @param hepcotrorelac
     */
    public void setHepcotrorelac(String hepcotrorelac) {
        this.hepcotrorelac = hepcotrorelac;
    }

    /**
     * @return
     */
    public String getHepcotrorelac() {
        return hepcotrorelac;
    }

    /**
     * @param hepcotrocogni
     */
    public void setHepcotrocogni(String hepcotrocogni) {
        this.hepcotrocogni = hepcotrocogni;
    }

    /**
     * @return
     */
    public String getHepcotrocogni() {
        return hepcotrocogni;
    }

    /**
     * @param hepcobservacio
     */
    public void setHepcobservacio(String hepcobservacio) {
        this.hepcobservacio = hepcobservacio;
    }

    /**
     * @return
     */
    public String getHepcobservacio() {
        return hepcobservacio;
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
     * @param hepccualfobia
     */
    public void setHepccualfobia(String hepccualfobia) {
        this.hepccualfobia = hepccualfobia;
    }

    /**
     * @return
     */
    public String getHepccualfobia() {
        return hepccualfobia;
    }
}
