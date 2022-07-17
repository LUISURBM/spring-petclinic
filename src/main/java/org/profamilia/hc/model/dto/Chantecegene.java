package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chantecegene implements Serializable {

    /** identifier field */
    private ChantecegenePK id;

    /** nullable persistent field */
    private Integer hanntipoante;

    /** nullable persistent field */
    private String hantdescripcio;

    /** nullable persistent field */
    private Date handfecregistr;

    /** nullable persistent field */
    private String hancoperador;

    /** nullable persistent field */
    private Integer version;

    /** Almacena el nombre del tipo del antecedente*/
    private String hancnomtipante;
    
    /** Almacena el nombre del tipo del antecedente*/
    private String hancreacvac;

    /** Almacena el nombre del tipo del antecedente*/
    private String hancreacvacdesc;



    /** default constructor */
    public Chantecegene() {
        id = new ChantecegenePK();
    }


    public ChantecegenePK getId() {
        return this.id;
    }

    public void setId(ChantecegenePK id) {
        this.id = id;
    }

    public Integer getHanntipoante() {
        return this.hanntipoante;
    }

    public void setHanntipoante(Integer hanntipoante) {
        this.hanntipoante = hanntipoante;
    }

    public String getHantdescripcio() {
        return this.hantdescripcio;
    }

    public void setHantdescripcio(String hantdescripcio) {
        this.hantdescripcio = hantdescripcio;
    }

    public Date getHandfecregistr() {
        return this.handfecregistr;
    }

    public void setHandfecregistr(Date handfecregistr) {
        this.handfecregistr = handfecregistr;
    }

    public String getHancoperador() {
        return this.hancoperador;
    }

    public void setHancoperador(String hancoperador) {
        this.hancoperador = hancoperador;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setHancnomtipante(String hancnomtipante) {
        this.hancnomtipante = hancnomtipante;
    }
    
    

    public String getHancnomtipante() {
        if (hanntipoante.equals(new Integer(1))|| hanntipoante.equals(new Integer(20))) {
            hancnomtipante = "Alergias";
        }
        if (hanntipoante.equals(new Integer(2))|| hanntipoante.equals(new Integer(21))) {
            hancnomtipante = "I.T.S.";
        }
        if (hanntipoante.equals(new Integer(3))) {
            hancnomtipante = "Familiares";
        }
        if (hanntipoante.equals(new Integer(4))|| hanntipoante.equals(new Integer(23))) {
            hancnomtipante = "Patol�gicos";
        }
        if (hanntipoante.equals(new Integer(5))||hanntipoante.equals(new Integer(24))) {
            hancnomtipante = "Quir�rgicos";
        }
        if (hanntipoante.equals(new Integer(6))|| hanntipoante.equals(new Integer(25))) {
            hancnomtipante = "Farmacologicos";
        }
        if (hanntipoante.equals(new Integer(7))|| hanntipoante.equals(new Integer(26))) {
            hancnomtipante = "Transfusionales";
        }
        if (hanntipoante.equals(new Integer(8)) || hanntipoante.equals(new Integer(27))) {
            hancnomtipante = "Traum�ticos";
        }
        if (hanntipoante.equals(new Integer(9))|| hanntipoante.equals(new Integer(28))) {
            hancnomtipante = "Toxicos";
        }
        if (hanntipoante.equals(new Integer(10))) {
            hancnomtipante = "Medicacion Durante el Embarazo";
        }
        if (hanntipoante.equals(new Integer(11))) {
            hancnomtipante = "Parto y atenci�n del mismo";
        }
        if (hanntipoante.equals(new Integer(12))) {
            hancnomtipante = "Complicaciones Perinatales";
        }
        if (hanntipoante.equals(new Integer(13))) {
            hancnomtipante = "Inmunizaciones";
        }
        if (hanntipoante.equals(new Integer(14))) {
            hancnomtipante = "Desarrollo Sicomotor";
        }
        if (hanntipoante.equals(new Integer(15))) {
            hancnomtipante = "Alimentaci�n";
        }
        if (hanntipoante.equals(new Integer(16))) {
            hancnomtipante = "Hospitalizaciones Previas";
        }
        
        if (hanntipoante.equals(new Integer(22))) {
            hancnomtipante = "Psicologicos";
        }
        
        if (hanntipoante.equals(new Integer(29))) {
            hancnomtipante = "Nutricionales";
        }


        return hancnomtipante;
    }

    public void setHancreacvac(String hancreacvac) {
        this.hancreacvac = hancreacvac;
    }

    public String getHancreacvac() {
        return hancreacvac;
    }

    public void setHancreacvacdesc(String hancreacvacdesc) {
        this.hancreacvacdesc = hancreacvacdesc;
    }

    public String getHancreacvacdesc() {
        return hancreacvacdesc;
    }
}
