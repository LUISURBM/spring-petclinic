package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chautoriserv implements Serializable {

    /** identifier field */
    private Long  haulconsulta;

    /** nullable persistent field */
    private String hauctipsersoli;

    /** nullable persistent field */
    private String haucprioriaten;

    /** nullable persistent field */
    private String haucmansegugui;
    
    /** identifier field */
    private Integer haunconsecutiv;

    /** nullable persistent field */ 
    private String hauctiposervi;
    
    /** nullable persistent field */ 
    private String haucnombrservi;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String haucjustifclin;

    /** nullable persistent field */
    private Date haudfecharegis;
    
    /** nullable persistent field */
    private String haucoperador; 
    
    /** nullable persistent field */ 
    private String haucorigeatenc;
    
    /** nullable persistent field */ 
    private String hauctipoconsul;
    
    /** nullable persistent field */ 
    private String haucdiagnprinc;
    
    /** nullable persistent field */ 
    private String haucdescrprinc;
    
    /** nullable persistent field */ 
    private String haucdiagrelac1;
    
    /** nullable persistent field */ 
    private String haucdescrelac1;
    
    /** nullable persistent field */ 
    private String haucdiagrelac2;
    
    /** nullable persistent field */ 
    private String haucdescrelac2;
    
    /** nullable persistent field */ 
    private Integer haunclinica;
   
    /** nullable persistent field */ 
    private String haucentidad;
 
    /** nullable persistent field */ 
    private String hauecobersalud;
    
    /** nullable persistent field */ 
    private String haueubicapacie;

    /** nullable persistent field */ 
    private String haucservhospi;
   
    /** nullable persistent field */ 
    private Integer hauncamahospi;

    /** nullable persistent field */ 
    private String hauctelinform;

    /** nullable persistent field */ 
    private String haucextinform;

    /** nullable persistent field */ 
    private String hauccelinform;

    /** nullable persistent field */ 
    private Integer haunorigenate;

    private boolean modoconsulta;
    
    private boolean imprimir;     


    /** default constructor */
    public Chautoriserv() {
     
    }


    public void setHaulconsulta(Long haulconsulta) {
        this.haulconsulta = haulconsulta;
    }

    public Long getHaulconsulta() {
        return haulconsulta;
    }

    public void setHauctipsersoli(String hauctipsersoli) {
        this.hauctipsersoli = hauctipsersoli;
    }

    public String getHauctipsersoli() {
        return hauctipsersoli;
    }

    public void setHaucprioriaten(String haucprioriaten) {
        this.haucprioriaten = haucprioriaten;
    }

    public String getHaucprioriaten() {
        return haucprioriaten;
    }

    public void setHaucmansegugui(String haucmansegugui) {
        this.haucmansegugui = haucmansegugui;
    }

    public String getHaucmansegugui() {
        return haucmansegugui;
    }

    public void setHaunconsecutiv(Integer haunconsecutiv) {
        this.haunconsecutiv = haunconsecutiv;
    }

    public Integer getHaunconsecutiv() {
        return haunconsecutiv;
    }

    public void setHauctiposervi(String hauctiposervi) {
        this.hauctiposervi = hauctiposervi;
    }

    public String getHauctiposervi() {
        return hauctiposervi;
    }

    public void setHaucnombrservi(String haucnombrservi) {
        this.haucnombrservi = haucnombrservi;
    }

    public String getHaucnombrservi() {
        return haucnombrservi;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHaucjustifclin(String haucjustifclin) {
        this.haucjustifclin = haucjustifclin;
    }

    public String getHaucjustifclin() {
        return haucjustifclin;
    }

    public void setHaudfecharegis(Date haudfecharegis) {
        this.haudfecharegis = haudfecharegis;
    }

    public Date getHaudfecharegis() {
        return haudfecharegis;
    }

    public void setHaucoperador(String haucoperador) {
        this.haucoperador = haucoperador;
    }

    public String getHaucoperador() {
        return haucoperador;
    }

    public void setHaucorigeatenc(String haucorigeatenc) {
        this.haucorigeatenc = haucorigeatenc;
    }

    public String getHaucorigeatenc() {
        return haucorigeatenc;
    }

    public void setHauctipoconsul(String hauctipoconsul) {
        this.hauctipoconsul = hauctipoconsul;
    }

    public String getHauctipoconsul() {
        return hauctipoconsul;
    }

    public void setHaucdiagnprinc(String haucdiagnprinc) {
        this.haucdiagnprinc = haucdiagnprinc;
    }

    public String getHaucdiagnprinc() {
        return haucdiagnprinc;
    }

    public void setHaucdescrprinc(String haucdescrprinc) {
        this.haucdescrprinc = haucdescrprinc;
    }

    public String getHaucdescrprinc() {
        return haucdescrprinc;
    }

    public void setHaucdiagrelac1(String haucdiagrelac1) {
        this.haucdiagrelac1 = haucdiagrelac1;
    }

    public String getHaucdiagrelac1() {
        return haucdiagrelac1;
    }

    public void setHaucdescrelac1(String haucdescrelac1) {
        this.haucdescrelac1 = haucdescrelac1;
    }

    public String getHaucdescrelac1() {
        return haucdescrelac1;
    }

    public void setHaucdiagrelac2(String haucdiagrelac2) {
        this.haucdiagrelac2 = haucdiagrelac2;
    }

    public String getHaucdiagrelac2() {
        return haucdiagrelac2;
    }

    public void setHaucdescrelac2(String haucdescrelac2) {
        this.haucdescrelac2 = haucdescrelac2;
    }

    public String getHaucdescrelac2() {
        return haucdescrelac2;
    }

    public void setModoconsulta(boolean modoconsulta) {
        this.modoconsulta = modoconsulta;
    }

    public boolean isModoconsulta() {
        return modoconsulta;
    }

    public void setImprimir(boolean imprimir) {
        this.imprimir = imprimir;
    }

    public boolean isImprimir() {
        return imprimir;
    }

    public void setHaunclinica(Integer haunclinica) {
        this.haunclinica = haunclinica;
    }

    public Integer getHaunclinica() {
        return haunclinica;
    }

    public void setHaucentidad(String haucentidad) {
        this.haucentidad = haucentidad;
    }

    public String getHaucentidad() {
        return haucentidad;
    }

    public void setHauecobersalud(String hauecobersalud) {
        this.hauecobersalud = hauecobersalud;
    }

    public String getHauecobersalud() {
        return hauecobersalud;
    }

    public void setHaueubicapacie(String haueubicapacie) {
        this.haueubicapacie = haueubicapacie;
    }

    public String getHaueubicapacie() {
        return haueubicapacie;
    }

    public void setHaucservhospi(String haucservhospi) {
        this.haucservhospi = haucservhospi;
    }

    public String getHaucservhospi() {
        return haucservhospi;
    }

    public void setHauncamahospi(Integer hauncamahospi) {
        this.hauncamahospi = hauncamahospi;
    }

    public Integer getHauncamahospi() {
        return hauncamahospi;
    }

    public void setHauctelinform(String hauctelinform) {
        this.hauctelinform = hauctelinform;
    }

    public String getHauctelinform() {
        return hauctelinform;
    }

    public void setHaucextinform(String haucextinform) {
        this.haucextinform = haucextinform;
    }

    public String getHaucextinform() {
        return haucextinform;
    }

    public void setHauccelinform(String hauccelinform) {
        this.hauccelinform = hauccelinform;
    }

    public String getHauccelinform() {
        return hauccelinform;
    }


    public void setHaunorigenate(Integer haunorigenate) {
        this.haunorigenate = haunorigenate;
    }

    public Integer getHaunorigenate() {
        return haunorigenate;
    }
}
