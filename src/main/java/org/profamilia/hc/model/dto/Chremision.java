package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chremision implements Serializable {

    /** identifier field */
    private ChremisionPK id;

    /** nullable persistent field */
    private String hrecservicio;

    /** nullable persistent field */
    private Date hredfecregistr;

    /** nullable persistent field */
    private String hrecoperador;

    private String hrecdescripcio;

    private String hrecdesservici;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private boolean modoconsulta;


    /** default constructor */
    public Chremision() {
    }


    public void setId(ChremisionPK id) {
        this.id = id;
    }

    public ChremisionPK getId() {
        return id;
    }

    public void setHrecservicio(String hrecservicio) {
        this.hrecservicio = hrecservicio;
    }

    public String getHrecservicio() {
        return hrecservicio;
    }

    public void setHredfecregistr(Date hredfecregistr) {
        this.hredfecregistr = hredfecregistr;
    }

    public Date getHredfecregistr() {
        return hredfecregistr;
    }

    public void setHrecoperador(String hrecoperador) {
        this.hrecoperador = hrecoperador;
    }

    public String getHrecoperador() {
        return hrecoperador;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHrecdescripcio(String hrecdescripcio) {
        this.hrecdescripcio = hrecdescripcio;
    }

    public String getHrecdescripcio() {
        return hrecdescripcio;
    }

    public void setHrecdesservici(String hrecdesservici) {
        this.hrecdesservici = hrecdesservici;
    }

    public String getHrecdesservici() {
        if (hrecservicio != null && !hrecservicio.equals("")) {
            if (hrecservicio.equals("0")) {
                hrecdesservici = "OTRO";
            }
            if (hrecservicio.equals("890202.10")) {
                hrecdesservici = "C. ESPEC. DE CIRUGIA PLASTICA";
            }
            if (hrecservicio.equals("890202.12")) {
                hrecdesservici = "C. ESPEC. POR I.T.S./VIH";
            }
            if (hrecservicio.equals("890202.13")) {
                hrecdesservici = "C. ESPEC. DE FERTILIDAD";
            }
            if (hrecservicio.equals("890202.14")) {
                hrecdesservici = "C. ESPEC. DE SEXOLOGIA";
            }
            if (hrecservicio.equals("890202.21")) {
                hrecdesservici = "C. ESPEC. DE OTORRINOLARINGOLOGIA";
            }
            if (hrecservicio.equals("890202.22")) {
                hrecdesservici = "C. ESPEC. DERMATOLOGIA";
            }
            if (hrecservicio.equals("890202.23")) {
                hrecdesservici = "C. ESPEC. NEUROLOGIA";
            }
            if (hrecservicio.equals("890202.25")) {
                hrecdesservici = "C. ESPEC. GASTROENTEROLOGIA";
            }
            if (hrecservicio.equals("890202.26")) {
                hrecdesservici = "C. ESPEC. ORTOPEDIA";
            }
            if (hrecservicio.equals("890202.3")) {
                hrecdesservici = "C. ESPEC. DE GINECOLOGIA";
            }
            if (hrecservicio.equals("890202.4")) {
                hrecdesservici = "C. ESPEC. DE UROLOGIA";
            }
            if (hrecservicio.equals("890202.5")) {
                hrecdesservici = "C. ESPEC. DE CONTROL PRENATAL";
            }
            if (hrecservicio.equals("890202.6")) {
                hrecdesservici = "C. ESPEC. DE PEDIATRIA";
            }
            if (hrecservicio.equals("890202.7")) {
                hrecdesservici = "C. ESPEC. DE MAMA";
            }
            if (hrecservicio.equals("890202.8")) {
                hrecdesservici = "C. ESPEC. POR MEDICINA INTERNA";
            }
            if (hrecservicio.equals("890202.9")) {
                hrecdesservici = "C. ESPEC. DE CIRUG?A GENERAL";
            }
        }
        return hrecdesservici;
    }


    public void setModoconsulta(boolean modoconsulta) {
        this.modoconsulta = modoconsulta;
    }

    public boolean isModoconsulta() {
        modoconsulta = false;
        if (this.id != null && this.id.getHrelconsulta() != null
        && this.id.getHrenconsecuti() != null) {
            modoconsulta = true;
        }
        return modoconsulta;
        }
}


