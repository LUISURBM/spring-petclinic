package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chexameparac implements Serializable {

    /** identifier field */
    private ChexameparacPK id;

    /** nullable persistent field */
    private Integer hepntipoexam;

    /** nullable persistent field */
    private String hepcdescripc;

    /** nullable persistent field */
    private String hepcoperador;

    /** nullable persistent field */
    private Date hepdfecregistr;

    /** Variable que almacena la descripcion del tipo de examen*/
    private String hepcdestipexam;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chexameparac() {
    }


    public void setId(ChexameparacPK id) {
        this.id = id;
    }

    public ChexameparacPK getId() {
        return id;
    }

    public void setHepntipoexam(Integer hepntipoexam) {
        this.hepntipoexam = hepntipoexam;
    }

    public Integer getHepntipoexam() {
        return hepntipoexam;
    }

    public void setHepcdescripc(String hepcdescripc) {
        this.hepcdescripc = hepcdescripc;
    }

    public String getHepcdescripc() {
        return hepcdescripc;
    }

    public void setHepcoperador(String hepcoperador) {
        this.hepcoperador = hepcoperador;
    }

    public String getHepcoperador() {
        return hepcoperador;
    }

    public void setHepdfecregistr(Date hepdfecregistr) {
        this.hepdfecregistr = hepdfecregistr;
    }

    public Date getHepdfecregistr() {
        return hepdfecregistr;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    public void setHepcdestipexam(String hepcdestipexam) {
        this.hepcdestipexam = hepcdestipexam;
    }

    public String getHepcdestipexam() {
        if (hepntipoexam != null) {
            if (hepntipoexam.equals(1)) {
                hepcdestipexam = "Electrofisiologicos";
            }
            if (hepntipoexam.equals(2)) {
                hepcdestipexam = "Imagenes";
            }
            if (hepntipoexam.equals(3)) {
                hepcdestipexam = "Laboratorios";
            }
        }
        return hepcdestipexam;
    }

    public Integer getVersion() {
        return version;
    }
}
