package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chcontroliqu implements Serializable {

    /** identifier field */
    private ChcontroliquPK id;

    /** nullable persistent field */
    private String hclctipoliquid;

    /** nullable persistent field */
    private String hclcotroliqpar;

    /** nullable persistent field */
    private String hclcvialiquido;

    /** nullable persistent field */
    private Integer hclncantidad;

    /** nullable persistent field */
    private Date hcldfechactivi;

    /** nullable persistent field */
    private Date hcldfecregistr;

    /** nullable persistent field */
    private String hclcoperador;

    /** nullable persistent field */
    private Integer hclnclinica;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String hclcetapa;

    /** nullable persistent field */
    private String hclctipoliqadm;

    /** nullable persistent field */
    private String hclctipoliqpar;

    /** nullable persistent field */
    private Integer hclncantisumin;

    /** nullable persistent field */
    private Date hcldfechactfin;

    /** nullable persistent field */
    private String hclcoperadmodif;

    /** nullable persistent field */
    private Integer hclndiuresis;

    /** nullable persistent field */
    private Integer hclndeposicion;

    /** nullable persistent field */
    private Integer hclndrenaje;

    /** nullable persistent field */
    private String hclcdrenaje;

    /** nullable persistent field */
    private String hclcdiuresis;

    /** nullable persistent field */
    private String hclctipodiure;

    /** nullable persistent field */
    private String hclcdeposicion;

    /** nullable persistent field */
    private String hclccuantdiure;

    /** nullable persistent field */
    private String hclccuantdepos;

    /** nullable persistent field */
    private String hclccuantdrena;

    /** nullable persistent field */
    private String hclctipodrena;

    /** nullable persistent field */
    private String hcldhoraactivi;

    /** nullable persistent field */
    private String hcldhoraactfin;

    /** nullable persistent field */
    private String hclcdesctipoli;

    /** nullable persistent field */
    private boolean mostrarOtra;

    /** nullable persistent field */
    private String cantidadDiuresis;

    /** nullable persistent field */
    private String cantidadDeposiciones;

    /** nullable persistent field */
    private String cantidadDrenaje;

    /** nullable persistent field */
    private String desTipoDiuresis;

    /** nullable persistent field */
    private String desTipoDrenaje;

    /** nullable persistent field */
    private String hclctiposangre;

    /** nullable persistent field */
    private String hclcgrupsangre;

    /** nullable persistent field */
    private String hclcfactosangre;

    /** nullable persistent field */
    private Integer hclnunidasangr;

    /** nullable persistent field */
    private Integer hclnsellocalid;

    /** nullable persistent field */
    private Date hcldsangrvenci;

    /** nullable persistent field */
    private String hclcobsliqelim;

    /** nullable persistent field */
    private String hclcemesis;

    private boolean hclbdeshaelimi;

    private String tipoRegistro;


    /** nullable persistent field */
    private Integer hclnvelocidadm;

    /** nullable persistent field */
    private String hclcformadmins;


    /** nullable persistent field */
    private Long hcllusuario;

    /** nullable persistent field */
    private String hclcestado;

    /** nullable persistent field */
    private String hclctiposoluci;


    /** nullable persistent field */
    private String hclcotroliquid;

    /** nullable persistent field */
    private String hclcemecua;


    /** nullable persistent field */
    private Integer hclnemecan;


    /** Variable que almacen la descripci�n de la forma de administracion*/
    private String wdescforma;

    private String hclcetapcontro;

    private String hclcmoduladmin;

    private String hclcliquielimi;

    private String nombreOperador;

    private Integer totalLiqAdmin;

    private Integer totalLiqElim;

    private String hclcotroliqvo;

    private String hclcoobsliqvo;


    /** default constructor */
    public Chcontroliqu() {
        id = new ChcontroliquPK();
    }


    /**
     * @param id
     */
    public void setId(ChcontroliquPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChcontroliquPK getId() {
        return id;
    }

    /**
     * @param hclctipoliquid
     */
    public void setHclctipoliquid(String hclctipoliquid) {
        this.hclctipoliquid = hclctipoliquid;
    }

    /**
     * @return
     */
    public String getHclctipoliquid() {
        return hclctipoliquid;
    }

    /**
     * @param hclcotroliqpar
     */
    public void setHclcotroliqpar(String hclcotroliqpar) {
        this.hclcotroliqpar = hclcotroliqpar;
    }

    /**
     * @return
     */
    public String getHclcotroliqpar() {
        return hclcotroliqpar;
    }

    /**
     * @param hclcvialiquido
     */
    public void setHclcvialiquido(String hclcvialiquido) {
        this.hclcvialiquido = hclcvialiquido;
    }

    /**
     * @return
     */
    public String getHclcvialiquido() {
        return hclcvialiquido;
    }

    /**
     * @param hclncantidad
     */
    public void setHclncantidad(Integer hclncantidad) {
        this.hclncantidad = hclncantidad;
    }

    /**
     * @return
     */
    public Integer getHclncantidad() {
        return hclncantidad;
    }

    /**
     * @param hcldfechactivi
     */
    public void setHcldfechactivi(Date hcldfechactivi) {
        this.hcldfechactivi = hcldfechactivi;
    }

    /**
     * @return
     */
    public Date getHcldfechactivi() {
        return hcldfechactivi;
    }

    /**
     * @param hcldfecregistr
     */
    public void setHcldfecregistr(Date hcldfecregistr) {
        this.hcldfecregistr = hcldfecregistr;
    }

    /**
     * @return
     */
    public Date getHcldfecregistr() {
        return hcldfecregistr;
    }

    /**
     * @param hclcoperador
     */
    public void setHclcoperador(String hclcoperador) {
        this.hclcoperador = hclcoperador;
    }

    /**
     * @return
     */
    public String getHclcoperador() {
        return hclcoperador;
    }

    /**
     * @param hclnclinica
     */
    public void setHclnclinica(Integer hclnclinica) {
        this.hclnclinica = hclnclinica;
    }

    /**
     * @return
     */
    public Integer getHclnclinica() {
        return hclnclinica;
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
     * @param hclcetapa
     */
    public void setHclcetapa(String hclcetapa) {
        this.hclcetapa = hclcetapa;
    }

    /**
     * @return
     */
    public String getHclcetapa() {
        return hclcetapa;
    }

    /**
     * @param hclctipoliqadm
     */
    public void setHclctipoliqadm(String hclctipoliqadm) {
        this.hclctipoliqadm = hclctipoliqadm;
    }

    /**
     * @return
     */
    public String getHclctipoliqadm() {
        return hclctipoliqadm;
    }

    /**
     * @param hclctipoliqpar
     */
    public void setHclctipoliqpar(String hclctipoliqpar) {
        this.hclctipoliqpar = hclctipoliqpar;
    }

    /**
     * @return
     */
    public String getHclctipoliqpar() {
        return hclctipoliqpar;
    }

    /**
     * @param hclncantisumin
     */
    public void setHclncantisumin(Integer hclncantisumin) {
        this.hclncantisumin = hclncantisumin;
    }

    /**
     * @return
     */
    public Integer getHclncantisumin() {
        return hclncantisumin;
    }

    /**
     * @param hcldfechactfin
     */
    public void setHcldfechactfin(Date hcldfechactfin) {
        this.hcldfechactfin = hcldfechactfin;
    }

    /**
     * @return
     */
    public Date getHcldfechactfin() {
        return hcldfechactfin;
    }

    /**
     * @param hclcoperadmodif
     */
    public void setHclcoperadmodif(String hclcoperadmodif) {
        this.hclcoperadmodif = hclcoperadmodif;
    }

    /**
     * @return
     */
    public String getHclcoperadmodif() {
        return hclcoperadmodif;
    }

    /**
     * @param hclndiuresis
     */
    public void setHclndiuresis(Integer hclndiuresis) {
        this.hclndiuresis = hclndiuresis;
    }

    /**
     * @return
     */
    public Integer getHclndiuresis() {
        return hclndiuresis;
    }

    /**
     * @param hclndeposicion
     */
    public void setHclndeposicion(Integer hclndeposicion) {
        this.hclndeposicion = hclndeposicion;
    }

    /**
     * @return
     */
    public Integer getHclndeposicion() {
        return hclndeposicion;
    }

    /**
     * @param hclndrenaje
     */
    public void setHclndrenaje(Integer hclndrenaje) {
        this.hclndrenaje = hclndrenaje;
    }

    /**
     * @return
     */
    public Integer getHclndrenaje() {
        return hclndrenaje;
    }

    /**
     * @param hclcdrenaje
     */
    public void setHclcdrenaje(String hclcdrenaje) {
        this.hclcdrenaje = hclcdrenaje;
    }

    /**
     * @return
     */
    public String getHclcdrenaje() {
        return hclcdrenaje;
    }

    /**
     * @param hclcdiuresis
     */
    public void setHclcdiuresis(String hclcdiuresis) {
        this.hclcdiuresis = hclcdiuresis;
    }

    /**
     * @return
     */
    public String getHclcdiuresis() {
        return hclcdiuresis;
    }

    /**
     * @param hclctipodiure
     */
    public void setHclctipodiure(String hclctipodiure) {
        this.hclctipodiure = hclctipodiure;
    }

    /**
     * @return
     */
    public String getHclctipodiure() {
        return hclctipodiure;
    }

    /**
     * @param hclcdeposicion
     */
    public void setHclcdeposicion(String hclcdeposicion) {
        this.hclcdeposicion = hclcdeposicion;
    }

    /**
     * @return
     */
    public String getHclcdeposicion() {
        return hclcdeposicion;
    }

    /**
     * @param hclccuantdiure
     */
    public void setHclccuantdiure(String hclccuantdiure) {
        this.hclccuantdiure = hclccuantdiure;
    }

    /**
     * @return
     */
    public String getHclccuantdiure() {
        return hclccuantdiure;
    }

    /**
     * @param hclccuantdepos
     */
    public void setHclccuantdepos(String hclccuantdepos) {
        this.hclccuantdepos = hclccuantdepos;
    }

    /**
     * @return
     */
    public String getHclccuantdepos() {
        return hclccuantdepos;
    }

    /**
     * @param hclccuantdrena
     */
    public void setHclccuantdrena(String hclccuantdrena) {
        this.hclccuantdrena = hclccuantdrena;
    }

    /**
     * @return
     */
    public String getHclccuantdrena() {
        return hclccuantdrena;
    }

    /**
     * @param hclctipodrena
     */
    public void setHclctipodrena(String hclctipodrena) {
        this.hclctipodrena = hclctipodrena;
    }

    /**
     * @return
     */
    public String getHclctipodrena() {
        return hclctipodrena;
    }

    /**
     * @param hcldhoraactivi
     */
    public void setHcldhoraactivi(String hcldhoraactivi) {
        this.hcldhoraactivi = hcldhoraactivi;
    }

    /**
     * @return
     */
    public String getHcldhoraactivi() {
        if (hcldfechactivi != null) {
            Calendar fecha = Calendar.getInstance();
            fecha.setTime(hcldfechactivi);

            String f = "";

            if (hcldfechactivi != null) {
                String DATE_FORMAT = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                f = sdf.format(hcldfechactivi);
            }

            Integer hora = fecha.get(Calendar.HOUR_OF_DAY);
            Integer minuto = fecha.get(Calendar.MINUTE);

            String horaSelect = "";
            String minutoSelect = "";

            if (hora < 10) {
                horaSelect = "0" + hora;
            } else {
                horaSelect = hora + "";
            }
            if (minuto < 10) {
                minutoSelect = "0" + minuto;
            } else {
                minutoSelect = minuto + "";
            }
            this.hcldhoraactivi = f + " _ " + horaSelect + ":" + minutoSelect;

        }
        return hcldhoraactivi;
    }


    /**
     * @param hcldhoraactfin
     */
    public void setHcldhoraactfin(String hcldhoraactfin) {
        this.hcldhoraactfin = hcldhoraactfin;
    }

    /**
     * @return
     */
    public String getHcldhoraactfin() {
        if (hcldfechactfin != null) {
            Calendar fecha = Calendar.getInstance();
            fecha.setTime(hcldfechactfin);
            String f = "";

            if (hcldfechactfin != null) {
                String DATE_FORMAT = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                f = sdf.format(hcldfechactfin);
            }

            Integer hora = fecha.get(Calendar.HOUR_OF_DAY);
            Integer minuto = fecha.get(Calendar.MINUTE);

            String horaSelect = "";
            String minutoSelect = "";

            if (hora < 10) {
                horaSelect = "0" + hora;
            } else {
                horaSelect = hora + "";
            }
            if (minuto < 10) {
                minutoSelect = "0" + minuto;
            } else {
                minutoSelect = minuto + "";
            }
            this.hcldhoraactfin = f + " _ " + horaSelect + ":" + minutoSelect;

        }
        return hcldhoraactfin;
    }


    /**
     * @param hclcdesctipoli
     */
    public void setHclcdesctipoli(String hclcdesctipoli) {
        this.hclcdesctipoli = hclcdesctipoli;
    }

    /**
     * @return
     */
    public String getHclcdesctipoli() {
        if (hclctipoliquid != null) {
            if (hclctipoliquid.equals("01")) {
                hclcdesctipoli = "Lactato de Ringer";
            } else if (hclctipoliquid.equals("02")) {
                hclcdesctipoli = "Haemacell";
            } else if (hclctipoliquid.equals("03")) {
                hclcdesctipoli = "Dextranes";
            } else if (hclctipoliquid.equals("04")) {
                hclcdesctipoli = "Globulos Rojos";
            } else if (hclctipoliquid.equals("05")) {
                hclcdesctipoli = "Sangre total";
            } else if (hclctipoliquid.equals("06")) {
                hclcdesctipoli = "Plasma";
            } else if (hclctipoliquid.equals("07")) {
                hclcdesctipoli = "Plaquetas";
            } else if (hclctipoliquid.equals("08")) {
                hclcdesctipoli = "Soluci�n Salina Normal 0.9%";
            } else if (hclctipoliquid.equals("09")) {
                hclcdesctipoli = "Jugo";
            } else if (hclctipoliquid.equals("10")) {
                hclcdesctipoli = "Agua";
            } else if (hclctipoliquid.equals("11")) {
                hclcdesctipoli = "Sopa";
            } else if (hclctipoliquid.equals("12")) {
                hclcdesctipoli = "Caldo";
            }
        }
        return hclcdesctipoli;
    }


    /**
     * @param mostrarOtra
     */
    public void setMostrarOtra(boolean mostrarOtra) {
        this.mostrarOtra = mostrarOtra;
    }

    /**
     * @return
     */
    public boolean isMostrarOtra() {
        if (hclctipoliquid != null && hclctipoliquid.equals("07")) {
            mostrarOtra = true;
        } else {
            mostrarOtra = false;
        }
        return mostrarOtra;
    }


    /**
     * @param hclctiposangre
     */
    public void setHclctiposangre(String hclctiposangre) {
        this.hclctiposangre = hclctiposangre;
    }

    /**
     * @return
     */
    public String getHclctiposangre() {
        return hclctiposangre;
    }

    /**
     * @param hclcgrupsangre
     */
    public void setHclcgrupsangre(String hclcgrupsangre) {
        this.hclcgrupsangre = hclcgrupsangre;
    }

    /**
     * @return
     */
    public String getHclcgrupsangre() {
        return hclcgrupsangre;
    }

    /**
     * @param hclcfactosangre
     */
    public void setHclcfactosangre(String hclcfactosangre) {
        this.hclcfactosangre = hclcfactosangre;
    }

    /**
     * @return
     */
    public String getHclcfactosangre() {
        return hclcfactosangre;
    }

    /**
     * @param hclnunidasangr
     */
    public void setHclnunidasangr(Integer hclnunidasangr) {
        this.hclnunidasangr = hclnunidasangr;
    }

    /**
     * @return
     */
    public Integer getHclnunidasangr() {
        return hclnunidasangr;
    }

    /**
     * @param hclnsellocalid
     */
    public void setHclnsellocalid(Integer hclnsellocalid) {
        this.hclnsellocalid = hclnsellocalid;
    }

    /**
     * @return
     */
    public Integer getHclnsellocalid() {
        return hclnsellocalid;
    }

    /**
     * @param hcldsangrvenci
     */
    public void setHcldsangrvenci(Date hcldsangrvenci) {
        this.hcldsangrvenci = hcldsangrvenci;
    }

    /**
     * @return
     */
    public Date getHcldsangrvenci() {
        return hcldsangrvenci;
    }


    /**
     * @param cantidadDiuresis
     */
    public void setCantidadDiuresis(String cantidadDiuresis) {
        this.cantidadDiuresis = cantidadDiuresis;
    }

    /**
     * @return
     */
    public String getCantidadDiuresis() {
        cantidadDiuresis = "--";
        if (hclccuantdiure != null && hclccuantdiure.equals("S") && 
            hclndiuresis != null) {
            cantidadDiuresis = hclndiuresis.toString() + " mL";
        } else if (hclccuantdiure != null && hclccuantdiure.equals("N")) {
            cantidadDiuresis = "No Cuantificado";
        }
        return cantidadDiuresis;
    }

    /**
     * @param cantidadDeposiciones
     */
    public void setCantidadDeposiciones(String cantidadDeposiciones) {
        this.cantidadDeposiciones = cantidadDeposiciones;
    }

    /**
     * @return
     */
    public String getCantidadDeposiciones() {
        cantidadDeposiciones = "--";
        if (hclccuantdepos != null && hclccuantdepos.equals("S") && 
            hclndeposicion != null) {
            cantidadDeposiciones = hclndeposicion.toString() + " mL";
        } else if (hclccuantdepos != null && hclccuantdepos.equals("N")) {
            cantidadDeposiciones = "No Cuantificado";
        }
        return cantidadDeposiciones;
    }

    /**
     * @param cantidadDrenaje
     */
    public void setCantidadDrenaje(String cantidadDrenaje) {
        this.cantidadDrenaje = cantidadDrenaje;
    }

    /**
     * @return
     */
    public String getCantidadDrenaje() {
        cantidadDrenaje = "--";
        if (hclccuantdrena != null && hclccuantdrena.equals("S") && 
            hclndrenaje != null) {
            cantidadDrenaje = hclndrenaje.toString() + " mL";
        } else if (hclccuantdrena != null && hclccuantdrena.equals("N")) {
            cantidadDrenaje = "No Cuantificado";
        }
        return cantidadDrenaje;
    }

    /**
     * @param desTipoDiuresis
     */
    public void setDesTipoDiuresis(String desTipoDiuresis) {
        this.desTipoDiuresis = desTipoDiuresis;
    }

    /**
     * @return
     */
    public String getDesTipoDiuresis() {
        if (hclctipodiure != null) {
            if (hclctipodiure.equals("S")) {
                desTipoDiuresis = "Sonda";
            }
            if (hclctipodiure.equals("E")) {
                desTipoDiuresis = "Espontanea";
            }
        }
        return desTipoDiuresis;
    }

    /**
     * @param desTipoDrenaje
     */
    public void setDesTipoDrenaje(String desTipoDrenaje) {
        this.desTipoDrenaje = desTipoDrenaje;
    }

    /**
     * @return
     */
    public String getDesTipoDrenaje() {
        if (hclctipodrena != null) {
            if (hclctipodrena.equals("S")) {
                desTipoDrenaje = "Sonda";
            }
            if (hclctipodrena.equals("H")) {
                desTipoDrenaje = "Hemovac";
            }
        }
        return desTipoDrenaje;
    }


    /**
     * @param hclbdeshaelimi
     */
    public void setHclbdeshaelimi(boolean hclbdeshaelimi) {
        this.hclbdeshaelimi = hclbdeshaelimi;
    }

    /**
     * @return
     */
    public boolean isHclbdeshaelimi() {
        return hclbdeshaelimi;
    }


    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public void setHclcobsliqelim(String hclcobsliqelim) {
        this.hclcobsliqelim = hclcobsliqelim;
    }

    public String getHclcobsliqelim() {
        return hclcobsliqelim;
    }

    public void setHclcemesis(String hclcemesis) {
        this.hclcemesis = hclcemesis;
    }

    public String getHclcemesis() {
        return hclcemesis;
    }

    public void setHclnvelocidadm(Integer hclnvelocidadm) {
        this.hclnvelocidadm = hclnvelocidadm;
    }

    public Integer getHclnvelocidadm() {
        return hclnvelocidadm;
    }

    public void setHclcformadmins(String hclcformadmins) {
        this.hclcformadmins = hclcformadmins;
    }

    public String getHclcformadmins() {
        return hclcformadmins;
    }

    public void setHcllusuario(Long hcllusuario) {
        this.hcllusuario = hcllusuario;
    }

    public Long getHcllusuario() {
        return hcllusuario;
    }

    public void setHclcestado(String hclcestado) {
        this.hclcestado = hclcestado;
    }

    public String getHclcestado() {
        return hclcestado;
    }

    public void setHclctiposoluci(String hclctiposoluci) {
        this.hclctiposoluci = hclctiposoluci;
    }

    public String getHclctiposoluci() {
        return hclctiposoluci;
    }


    public void setHclcotroliquid(String hclcotroliquid) {
        this.hclcotroliquid = hclcotroliquid;
    }

    public String getHclcotroliquid() {
        return hclcotroliquid;
    }


    /**
     * @param wdescforma
     */
    public void setWdescforma(String wdescforma) {
        this.wdescforma = wdescforma;
    }


    /**
     * @return
     */
    public String getWdescforma() {
        if (this.getHclcformadmins() != null) {
            if (this.getHclcformadmins().equals("L")) {
                wdescforma = "Bolo";
            }
            if (this.getHclcformadmins().equals("I")) {
                wdescforma = "Infusi�n";
            }
        }

        return wdescforma;
    }

    public void setHclcemecua(String hclcemecua) {
        this.hclcemecua = hclcemecua;
    }

    public String getHclcemecua() {
        return hclcemecua;
    }

    public void setHclnemecan(Integer hclnemecan) {
        this.hclnemecan = hclnemecan;
    }

    public Integer getHclnemecan() {
        return hclnemecan;
    }

    public void setHclcetapcontro(String hclcetapcontro) {
        this.hclcetapcontro = hclcetapcontro;
    }

    public String getHclcetapcontro() {
        return hclcetapcontro;
    }

    public void setHclcmoduladmin(String hclcmoduladmin) {
        this.hclcmoduladmin = hclcmoduladmin;
    }

    public String getHclcmoduladmin() {
        return hclcmoduladmin;
    }

    public void setHclcliquielimi(String hclcliquielimi) {
        this.hclcliquielimi = hclcliquielimi;
    }

    public String getHclcliquielimi() {
        return hclcliquielimi;
    }


    public void setNombreOperador(String nombreOperador) {
        this.nombreOperador = nombreOperador;
    }

    public String getNombreOperador() {
        return nombreOperador;
    }

    public void setTotalLiqAdmin(Integer totalLiqAdmin) {
        this.totalLiqAdmin = totalLiqAdmin;
    }

    public Integer getTotalLiqAdmin() {
        return totalLiqAdmin;
    }

    public void setTotalLiqElim(Integer totalLiqElim) {
        this.totalLiqElim = totalLiqElim;
    }

    public Integer getTotalLiqElim() {
        return totalLiqElim;
    }

    public void setHclcotroliqvo(String hclcotroliqvo) {
        this.hclcotroliqvo = hclcotroliqvo;
    }

    public String getHclcotroliqvo() {
        return hclcotroliqvo;
    }

    public void setHclcoobsliqvo(String hclcoobsliqvo) {
        this.hclcoobsliqvo = hclcoobsliqvo;
    }

    public String getHclcoobsliqvo() {
        return hclcoobsliqvo;
    }
}
