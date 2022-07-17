package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chformulahos implements Serializable {

    /** identifier field */
    private ChformulahosPK id;

    /** nullable persistent field */
    private String hfhcmedicament;

    /** nullable persistent field */
    private String hfhcpresentaci;

    /** nullable persistent field */
    private BigDecimal hfhcadosis;

    /** nullable persistent field */
    private Integer hfhnfrecuadmin;

    /** nullable persistent field */
    private String hfhcviadministr;

    /** nullable persistent field */
    private String hfhcviadminotr;

    /** nullable persistent field */
    private String hfhcformaadmin;

    /** nullable persistent field */
    private Integer version;

    /**Variable que almacena la descripci�n de la forma deAdministracion*/
    private String wdesforma;

    /** Variable que almacena las unidades de la dosis*/
    private String hfhcunidad;

    /** nullable persistent field */
    private Integer hfhnvolumburet;

    /** nullable persistent field */
    private Integer hfhntiempburet;

    /** nullable persistent field */
    private Integer hfhnvelocinfus;

    /** nullable persistent field */
    private String hfhcetapa;

    private boolean hfhbsuspender;

    private boolean hfhbrendersusp;

    /** nullable persistent field */
    private Date hfhdfecregistr;

    /** nullable persistent field */
    private String hfhcoperador;

    private Date hfhdfechamodif;

    /** nullable persistent field */
    private String hfhcoperamodif;
    
    /** nullable persistent field */
    private Date hfhdhorasumin; 
    
    /** identifier field */
    private String hfhctiposerv;
    
    /** identifier field */
    private Long hfhlusuario;

    /** identifier field */
    private String hfhcunitiempo;

    /** nullable persistent field */
    private Integer hfhntiempotot;

    /** nullable persistent field */
    private Integer hfhnconsmedic;

    /** identifier field */
    private String hfhcviaintreco;
    
    private String wdescunidad;

    /** nullable persistent field */
    private Date hfhdhorasusp; 

    /** nullable persistent field */
    private Integer hfhnevolususp;
    
    /** nullable persistent field */
    private String hfhcconcimedi;
    
    private String hfhccodsap;

    /** default constructor */
    public Chformulahos() {
    }


    /**
     * @param id
     */
    public void setId(ChformulahosPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChformulahosPK getId() {
        return id;
    }

    /**
     * @param hfhcmedicament
     */
    public void setHfhcmedicament(String hfhcmedicament) {
        this.hfhcmedicament = hfhcmedicament;
    }

    /**
     * @return
     */
    public String getHfhcmedicament() {
        return hfhcmedicament;
    }

    /**
     * @param hfhcpresentaci
     */
    public void setHfhcpresentaci(String hfhcpresentaci) {
        this.hfhcpresentaci = hfhcpresentaci;
    }

    /**
     * @return
     */
    public String getHfhcpresentaci() {
        return hfhcpresentaci;
    }

    /**
     * @param hfhcadosis
     */
    public void setHfhcadosis(BigDecimal hfhcadosis) {
        this.hfhcadosis = hfhcadosis;
    }

    /**
     * @return
     */
    public BigDecimal getHfhcadosis() {
        return hfhcadosis;
    }


    /**
     * @param hfhcviadministr
     */
    public void setHfhcviadministr(String hfhcviadministr) {
        this.hfhcviadministr = hfhcviadministr;
    }

    /**
     * @return
     */
    public String getHfhcviadministr() {
        return hfhcviadministr;
    }

    /**
     * @param hfhcviadminotr
     */
    public void setHfhcviadminotr(String hfhcviadminotr) {
        this.hfhcviadminotr = hfhcviadminotr;
    }

    /**
     * @return
     */
    public String getHfhcviadminotr() {
        return hfhcviadminotr;
    }

    /**
     * @param hfhcformaadmin
     */
    public void setHfhcformaadmin(String hfhcformaadmin) {
        this.hfhcformaadmin = hfhcformaadmin;
    }

    /**
     * @return
     */
    public String getHfhcformaadmin() {
        return hfhcformaadmin;
    }

    /**
     * @param hfhdfecregistr
     */
    public void setHfhdfecregistr(Date hfhdfecregistr) {
        this.hfhdfecregistr = hfhdfecregistr;
    }

    /**
     * @return
     */
    public Date getHfhdfecregistr() {
        return hfhdfecregistr;
    }

    /**
     * @param hfhcoperador
     */
    public void setHfhcoperador(String hfhcoperador) {
        this.hfhcoperador = hfhcoperador;
    }

    /**
     * @return
     */
    public String getHfhcoperador() {
        return hfhcoperador;
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
     * @param hfhcunidad
     */
    public void setHfhcunidad(String hfhcunidad) {
        this.hfhcunidad = hfhcunidad;
    }

    /**
     * @return
     */
    public String getHfhcunidad() {
        return hfhcunidad;
    }

    /**
     * @param hfhnvolumburet
     */
    public void setHfhnvolumburet(Integer hfhnvolumburet) {
        this.hfhnvolumburet = hfhnvolumburet;
    }

    /**
     * @return
     */
    public Integer getHfhnvolumburet() {
        return hfhnvolumburet;
    }

    /**
     * @param hfhntiempburet
     */
    public void setHfhntiempburet(Integer hfhntiempburet) {
        this.hfhntiempburet = hfhntiempburet;
    }

    /**
     * @return
     */
    public Integer getHfhntiempburet() {
        return hfhntiempburet;
    }

    /**
     * @param hfhnvelocinfus
     */
    public void setHfhnvelocinfus(Integer hfhnvelocinfus) {
        this.hfhnvelocinfus = hfhnvelocinfus;
    }

    /**
     * @return
     */
    public Integer getHfhnvelocinfus() {
        return hfhnvelocinfus;
    }

    /**
     * @param wdesforma
     */
    public void setWdesforma(String wdesforma) {
        this.wdesforma = wdesforma;
    }

    /**
     * @return
     */
    public String getWdesforma() {
        if (hfhcviaintreco != null) {
            wdesforma = hfhcviaintreco;
        }
        return wdesforma;
    }

    /**
     * @param hfhcetapa
     */
    public void setHfhcetapa(String hfhcetapa) {
        this.hfhcetapa = hfhcetapa;
    }

    /**
     * @return
     */
    public String getHfhcetapa() {
        return hfhcetapa;
    }

    /**
     * @param hfhnfrecuadmin
     */
    public void setHfhnfrecuadmin(Integer hfhnfrecuadmin) {
        this.hfhnfrecuadmin = hfhnfrecuadmin;
    }

    /**
     * @return
     */
    public Integer getHfhnfrecuadmin() {
        return hfhnfrecuadmin;
    }

    /**
     * @param hfhdfechamodif
     */
    public void setHfhdfechamodif(Date hfhdfechamodif) {
        this.hfhdfechamodif = hfhdfechamodif;
    }

    /**
     * @return
     */
    public Date getHfhdfechamodif() {
        return hfhdfechamodif;
    }

    /**
     * @param hfhcoperamodif
     */
    public void setHfhcoperamodif(String hfhcoperamodif) {
        this.hfhcoperamodif = hfhcoperamodif;
    }

    /**
     * @return
     */
    public String getHfhcoperamodif() {
        return hfhcoperamodif;
    }

    /**
     * @param hfhbsuspender
     */
    public void setHfhbsuspender(boolean hfhbsuspender) {
        this.hfhbsuspender = hfhbsuspender;
    }

    /**
     * @return
     */
    public boolean isHfhbsuspender() {
        return hfhbsuspender;
    }

    /**
     * @param hfhbrendersusp
     */
    public void setHfhbrendersusp(boolean hfhbrendersusp) {
        this.hfhbrendersusp = hfhbrendersusp;
    }

    /**
     * @return
     */
    public boolean isHfhbrendersusp() {
        if (hfhcetapa != null) {
            if (hfhcetapa.equals("SP")) {
                hfhbrendersusp = false;
            } else {
                hfhbrendersusp = true;
            }
        }
        return hfhbrendersusp;
    }


    /**
     * @param hfhdhorasumin
     */
    public void setHfhdhorasumin(Date hfhdhorasumin) {
        this.hfhdhorasumin = hfhdhorasumin;
    }

    /**
     * @return
     */
    public Date getHfhdhorasumin() {
        return hfhdhorasumin;
    }

    /**
     * @param hfhctiposerv
     */
    public void setHfhctiposerv(String hfhctiposerv) {
        this.hfhctiposerv = hfhctiposerv;
    }

    /**
     * @return
     */
    public String getHfhctiposerv() {
        return hfhctiposerv;
    }

    /**
     * @param hfhlusuario
     */
    public void setHfhlusuario(Long hfhlusuario) {
        this.hfhlusuario = hfhlusuario;
    }

    /**
     * @return
     */
    public Long getHfhlusuario() {
        return hfhlusuario;
    }


    public void setHfhcunitiempo(String hfhcunitiempo) {
        this.hfhcunitiempo = hfhcunitiempo;
    }

    public String getHfhcunitiempo() {
        return hfhcunitiempo;
    }

    public void setHfhntiempotot(Integer hfhntiempotot) {
        this.hfhntiempotot = hfhntiempotot;
    }

    public Integer getHfhntiempotot() {
        return hfhntiempotot;
    }

    public void setHfhnconsmedic(Integer hfhnconsmedic) {
        this.hfhnconsmedic = hfhnconsmedic;
    }

    public Integer getHfhnconsmedic() {
        return hfhnconsmedic;
    }

    public void setHfhcviaintreco(String hfhcviaintreco) {
        this.hfhcviaintreco = hfhcviaintreco;
    }

    public String getHfhcviaintreco() {
        return hfhcviaintreco;
    }


    public void setWdescunidad(String wdescunidad) {
        this.wdescunidad = wdescunidad;
    }

    public String getWdescunidad() {
        wdescunidad = "";
    if(hfhcunitiempo != null){
        if(hfhcunitiempo.equals("H")){
            wdescunidad  = "Horas";
        }
        if(hfhcunitiempo.equals("M")){
            wdescunidad  = "Minutos";
        }
        if(hfhcunitiempo.equals("U")){
            wdescunidad  = "Dosis Unica";
        }
    }
    
        return wdescunidad;
    }


    public void setHfhdhorasusp(Date hfhdhorasusp) {
        this.hfhdhorasusp = hfhdhorasusp;
    }

    public Date getHfhdhorasusp() {
        return hfhdhorasusp;
    }

    public void setHfhnevolususp(Integer hfhnevolususp) {
        this.hfhnevolususp = hfhnevolususp;
    }

    public Integer getHfhnevolususp() {
        return hfhnevolususp;
    }

    public void setHfhcconcimedi(String hfhcconcimedi) {
        this.hfhcconcimedi = hfhcconcimedi;
    }

    public String getHfhcconcimedi() {
        return hfhcconcimedi;
    }


    public void setHfhccodsap(String hfhccodsap) {
        this.hfhccodsap = hfhccodsap;
    }

    public String getHfhccodsap() {
        return hfhccodsap;
    }
}
