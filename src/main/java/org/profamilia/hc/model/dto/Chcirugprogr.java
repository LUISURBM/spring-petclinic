package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;


/** @author Hibernate CodeGenerator */
public class Chcirugprogr implements Serializable {

    /** identifier field */
    private Long hcplnumero;

    /** nullable persistent field */
    private Date hcpdfechacirug;

    /** nullable persistent field */
    private Integer hcpntiempointe;

    /** nullable persistent field */
    private Integer hcpnsalainterv;

    /** nullable persistent field */
    private Chusuario hcplusuario;

    /** nullable persistent field */
    private String hcpcentidadadm;

    /** nullable persistent field */
    private String hcpcanestesiol;

    /** nullable persistent field */
    private String hcpcestado;

    /** nullable persistent field */
    private Date hcpdfecregistr;

    /** nullable persistent field */
    private Date hcpdfechamodif;

    /** nullable persistent field */
    private String hcpcoperador;

    /** nullable persistent field */
    private String hcpcoperamodif;

    /** nullable persistent field */
    private Integer hcpnclinica;

    /** nullable persistent field */
    private String hcpcetapa;

    private String horaRegi;

    /** nullable persistent field */
    private Date hcpdfechfincir;

    /** nullable persistent field */
    private String hcpctipoaneste;
    /** nullable persistent field */
    private String hcpctipoayudan;
    
    
    /** nullable persistent field */
    private String hcpcprofeayuda;

    /** nullable persistent field */
    private String hcpctipoestanc;

    /** nullable persistent field */
    private String hcpeayudantia;

    /** nullable persistent field */
    private Integer hcpndiasestanc;

    /** nullable persistent field */
    private String hcpcdescranest;

    /** nullable persistent field */
    private String hcpcdescrestan;

    /** persistent field */
    private Set<Chdetacirpro> chdetacirpros;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String hcpcingremedic;

    /** nullable persistent field */
    private String hcpcingreenfer;

    /** nullable persistent field */
    private String hcpcsalidenfer;

    /** nullable persistent field */
    private String hcpcsalidmedic;

    /** nullable persistent field */
    private String hcpcopersalmed;

    /** nullable persistent field */
    private String hcpcopersalenf;

    /** nullable persistent field */
    private Date hcpdfechsalmed;

    /** nullable persistent field */
    private Date hcpdfechsalenf;

    /** nullable persistent field */
    private Date hcpdfechingmed;

    /** nullable persistent field */
    private Date hcpdfechingenf;

    /** nullable persistent field */
    private String hcpcoperingmed;

    /** nullable persistent field */
    private String hcpcoperingenf;

    /** nullable persistent field */
    private String hcpcregisepicr;
    
    /** nullable persistent field */
    private String hcpcregisanest;

    /** nullable persistent field */
    private String hcpcoperaepicr;

    /** nullable persistent field */
    private String hcpcoperaanula;
    
    /** nullable persistent field */
    private String hcpcmotivanula; 
    
    /** nullable persistent field */
    private String hcpcobseranula; 

    /** nullable persistent field */
    private Date hcpdfechaanula;
    
    /** nullable persistent field */
    private String hcpcregisinstr; 
    
    /** nullable persistent field */
    private String hcpcoperainstr; 
    
    private String hcpcminutdurac; 
    
    private String hcpchoradurac; 
    
    private String hcpcressangre;
    
    private String hcpcobserv;
    
    private String hcpctipohemoco;
    
    private Integer hcpnnumerounid;
    
    /** nullable persistent field */
    private Chdescrquiru chdescrquiru;

    /** persistent field */
    private Set<Chepicrisi> chepicrisis;

    /** persistent field */
    private Set<Chcontrmedic> chcontrmedics;

    /** persistent field */
    private Set<Chnotaenferm> chnotaenferms;

    /** persistent field */
    private Set<Chcontroliqu> chcontroliqus;

    /** persistent field */
    private Set<Chcanalivena> chcanalivenas;
    
    /** persistent field */
    private Set<Chsignovital> chsignovitals;

    /** persistent field */
    private Set<Chevolucion> chevolucions;
    
    /** persistent field */
    private Set<Chanatopatol> chanatopatols;


    private boolean cerrarCirugia;
    
    /** persistent field */
    private Set<Chingresoenf> chingresoenfs;


    /** persistent field */
    private Set<Chanestesia> chanestesia;
    
    /** persistent field */
    private Set<Chposicanest> chposicanest;
    
    /** persistent field */
   private Set<Chmonitoria> chmonitoria; 
        
    /** persistent field */
    private Set<Chcontmedane> chcontmedane;
    
    /** persistent field */
    private Set<Chsegutelefo> chsegutelefo;

    /** persistent field */
    private Set<Chverquirofa> chverquirofa;
    
    /** persistent field */
    private Set<Chventiaerea> chventiaerea;
    
    /** persistent field */
    private Set<Chcierreanest> chcierreanest;
    
    /** persistent field */
    private Set<Chciruganula> chciruganula;
    
    /** nullable persistent field */
    private Set<Chconducta> chconductas;

    /** nullable persistent field */
    private Set<Chtecnianest> chtecnianests;
    
    private String nombreServicio;
    
    private String nombreAnestesiologo;
    
    private String nombreAyudante;
    
    private String primerNombre;
    
    private String segundoNombre;
    
    private String primerApellido;
    
    private String segundoApellido;
    
    private Long numeiden;
    
    /** persistent field */
    private Integer hcpnordenllega;
    
    private String nombreMedico;
    
    private String descSala;
    
    private String hcpctiposedacio;
    
    private String tipoSedacion;
    
    private String nombreeps;
    
    private String numerocelular;
    
    private String numerofijo;
    
    private String reservaSangre;
    
    /** persistent field */
    private String hcpcnomresiden;
    
    
    private String autorizaContacto; 
    
    private String etapa;
    
    private Integer edad; 
    
    private String asegurador; 
    
    private String telefono; 
    
    private String anestesia;
    
    /** nullable persistent field */
    private Set<Chescvalcai> chescvalcai;
    


    /** default constructor */
    public Chcirugprogr() {

    }


    /**
     * @param hcplnumero
     */
    public void setHcplnumero(Long hcplnumero) {
        this.hcplnumero = hcplnumero;
    }

    /**
     * @return
     */
    public Long getHcplnumero() {
        return hcplnumero;
    }

    /**
     * @param hcpdfechacirug
     */
    public void setHcpdfechacirug(Date hcpdfechacirug) {
        this.hcpdfechacirug = hcpdfechacirug;
    }

    /**
     * @return
     */
    public Date getHcpdfechacirug() {
        return hcpdfechacirug;
    }

    /**
     * @param hcpntiempointe
     */
    public void setHcpntiempointe(Integer hcpntiempointe) {
        this.hcpntiempointe = hcpntiempointe;
    }

    /**
     * @return
     */
    public Integer getHcpntiempointe() {
        return hcpntiempointe;
    }

    /**
     * @param hcpnsalainterv
     */
    public void setHcpnsalainterv(Integer hcpnsalainterv) {
        this.hcpnsalainterv = hcpnsalainterv;
    }

    /**
     * @return
     */
    public Integer getHcpnsalainterv() {
        return hcpnsalainterv;
    }

    /**
     * @param hcplusuario
     */
    public void setHcplusuario(Chusuario hcplusuario) {
        this.hcplusuario = hcplusuario;
    }

    /**
     * @return
     */
    public Chusuario getHcplusuario() {
        return hcplusuario;
    }

    /**
     * @param hcpcentidadadm
     */
    public void setHcpcentidadadm(String hcpcentidadadm) {
        this.hcpcentidadadm = hcpcentidadadm;
    }

    /**
     * @return
     */
    public String getHcpcentidadadm() {
        return hcpcentidadadm;
    }


    /**
     * @param hcpcanestesiol
     */
    public void setHcpcanestesiol(String hcpcanestesiol) {
        this.hcpcanestesiol = hcpcanestesiol;
    }

    /**
     * @return
     */
    public String getHcpcanestesiol() {
        return hcpcanestesiol;
    }
    
    /**
     * @param hcpcprofeayuda
     */
    public void setHcpcprofeayuda(String hcpcprofeayuda) {
        this.hcpcprofeayuda = hcpcprofeayuda;
    }

    /**
     * @return
     */
    public String getHcpcprofeayuda() {
        return hcpcprofeayuda;
    }

    /**
     * @param hcpcestado
     */
    public void setHcpcestado(String hcpcestado) {
        this.hcpcestado = hcpcestado;
    }

    /**
     * @return
     */
    public String getHcpcestado() {
        return hcpcestado;
    }

    /**
     * @param hcpdfecregistr
     */
    public void setHcpdfecregistr(Date hcpdfecregistr) {
        this.hcpdfecregistr = hcpdfecregistr;
    }

    /**
     * @return
     */
    public Date getHcpdfecregistr() {
        return hcpdfecregistr;
    }

    /**
     * @param hcpcoperador
     */
    public void setHcpcoperador(String hcpcoperador) {
        this.hcpcoperador = hcpcoperador;
    }

    /**
     * @return
     */
    public String getHcpcoperador() {
        return hcpcoperador;
    }

    /**
     * @param hcpnclinica
     */
    public void setHcpnclinica(Integer hcpnclinica) {
        this.hcpnclinica = hcpnclinica;
    }

    /**
     * @return
     */
    public Integer getHcpnclinica() {
        return hcpnclinica;
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
     * @param hcpcetapa
     */
    public void setHcpcetapa(String hcpcetapa) {
        this.hcpcetapa = hcpcetapa;
    }

    /**
     * @return
     */
    public String getHcpcetapa() {
        return hcpcetapa;
    }


    /**
     * @param horaRegi
     */
    public void setHoraRegi(String horaRegi) {
        this.horaRegi = horaRegi;
    }

    /**
     * @return
     */
    public String getHoraRegi() {
        if (hcpdfechacirug != null) {
            GregorianCalendar fecha = new GregorianCalendar();
            fecha.setTime(hcpdfechacirug);
            int hora;
            int minuto;
            String horaSelect = "";
            String minutoSelect = "";

            hora = fecha.get(Calendar.HOUR_OF_DAY);
            minuto = fecha.get(Calendar.MINUTE);

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


            this.horaRegi = horaSelect + ":" + minutoSelect;
        }

        return horaRegi;
    }


    /**
     * @param hcpdfechamodif
     */
    public void setHcpdfechamodif(Date hcpdfechamodif) {
        this.hcpdfechamodif = hcpdfechamodif;
    }

    /**
     * @return
     */
    public Date getHcpdfechamodif() {
        return hcpdfechamodif;
    }

    /**
     * @param hcpcoperamodif
     */
    public void setHcpcoperamodif(String hcpcoperamodif) {
        this.hcpcoperamodif = hcpcoperamodif;
    }

    /**
     * @return
     */
    public String getHcpcoperamodif() {
        return hcpcoperamodif;
    }

    /**
     * @param hcpdfechfincir
     */
    public void setHcpdfechfincir(Date hcpdfechfincir) {
        this.hcpdfechfincir = hcpdfechfincir;
    }

    /**
     * @return
     */
    public Date getHcpdfechfincir() {
        return hcpdfechfincir;
    }

    /**
     * @param hcpctipoaneste
     */
    public void setHcpctipoaneste(String hcpctipoaneste) {
        this.hcpctipoaneste = hcpctipoaneste;
    }

    /**
     * @return
     */
    public String getHcpctipoaneste() {
        return hcpctipoaneste;
    }

    /**
     * @param hcpctipoestanc
     */
    public void setHcpctipoestanc(String hcpctipoestanc) {
        this.hcpctipoestanc = hcpctipoestanc;
    }

    /**
     * @return
     */
    public String getHcpctipoestanc() {
        return hcpctipoestanc;
    }

    /**
     * @param hcpeayudantia
     */
    public void setHcpeayudantia(String hcpeayudantia) {
        this.hcpeayudantia = hcpeayudantia;
    }

    /**
     * @return
     */
    public String getHcpeayudantia() {
        return hcpeayudantia;
    }

    /**
     * @param hcpndiasestanc
     */
    public void setHcpndiasestanc(Integer hcpndiasestanc) {
        this.hcpndiasestanc = hcpndiasestanc;
    }

    /**
     * @return
     */
    public Integer getHcpndiasestanc() {
        return hcpndiasestanc;
    }

    public void setHcpcdescranest(String hcpcdescranest) {
        this.hcpcdescranest = hcpcdescranest;
    }

    public String getHcpcdescranest() {
        if (hcpctipoaneste != null) {
            if (hcpctipoaneste.equals("2")) {
                hcpcdescranest = "General";
            }
            if (hcpctipoaneste.equals("3")) {
                hcpcdescranest = "Local";
            }
            
            if (hcpctipoaneste.equals("4")) {
                hcpcdescranest = "Regional";
            }
            
            if (hcpctipoaneste.equals("5")) {
                hcpcdescranest = "Sedaci�n";
            }
            
            if (hcpctipoaneste.equals("6")) {
                hcpcdescranest = "Local";
            }
            
            
            if (hcpctipoaneste.equals("7")) {
                hcpcdescranest = "Local Controlada";
            }
            if (hcpctipoaneste.equals("8")) {
                hcpcdescranest = "Sin Anestesia";
            }
            
            
        }
        return hcpcdescranest;
    }

    /**
     * @param hcpcdescrestan
     */
    public void setHcpcdescrestan(String hcpcdescrestan) {
        this.hcpcdescrestan = hcpcdescrestan;
    }

    /**
     * @return
     */
    public String getHcpcdescrestan() {
        if (hcpctipoaneste != null) {
            if (hcpctipoestanc.equals("H")) {
                hcpcdescrestan = "Hospitalizaci�n";
            }
            if (hcpctipoestanc.equals("A")) {
                hcpcdescrestan = "Ambulatoria";
            }
        }
        return hcpcdescrestan;
    }


    /**
     * @param chdetacirpros
     */
    public void setChdetacirpros(Set<Chdetacirpro> chdetacirpros) {
        this.chdetacirpros = chdetacirpros;
    }

    /**
     * @return
     */
    public Set<Chdetacirpro> getChdetacirpros() {
        return chdetacirpros;
    }

    /**
     * @param hcpcingremedic
     */
    public void setHcpcingremedic(String hcpcingremedic) {
        this.hcpcingremedic = hcpcingremedic;
    }

    /**
     * @return
     */
    public String getHcpcingremedic() {
        return hcpcingremedic;
    }

    /**
     * @param hcpcingreenfer
     */
    public void setHcpcingreenfer(String hcpcingreenfer) {
        this.hcpcingreenfer = hcpcingreenfer;
    }

    /**
     * @return
     */
    public String getHcpcingreenfer() {
        return hcpcingreenfer;
    }

    /**
     * @param hcpcsalidenfer
     */
    public void setHcpcsalidenfer(String hcpcsalidenfer) {
        this.hcpcsalidenfer = hcpcsalidenfer;
    }

    /**
     * @return
     */
    public String getHcpcsalidenfer() {
        return hcpcsalidenfer;
    }

    /**
     * @param hcpcsalidmedic
     */
    public void setHcpcsalidmedic(String hcpcsalidmedic) {
        this.hcpcsalidmedic = hcpcsalidmedic;
    }

    /**
     * @return
     */
    public String getHcpcsalidmedic() {
        return hcpcsalidmedic;
    }

    /**
     * @param hcpcopersalmed
     */
    public void setHcpcopersalmed(String hcpcopersalmed) {
        this.hcpcopersalmed = hcpcopersalmed;
    }

    /**
     * @return
     */
    public String getHcpcopersalmed() {
        return hcpcopersalmed;
    }

    /**
     * @param hcpcopersalenf
     */
    public void setHcpcopersalenf(String hcpcopersalenf) {
        this.hcpcopersalenf = hcpcopersalenf;
    }

    /**
     * @return
     */
    public String getHcpcopersalenf() {
        return hcpcopersalenf;
    }

    /**
     * @param hcpdfechsalmed
     */
    public void setHcpdfechsalmed(Date hcpdfechsalmed) {
        this.hcpdfechsalmed = hcpdfechsalmed;
    }

    /**
     * @return
     */
    public Date getHcpdfechsalmed() {
        return hcpdfechsalmed;
    }

    /**
     * @param hcpdfechsalenf
     */
    public void setHcpdfechsalenf(Date hcpdfechsalenf) {
        this.hcpdfechsalenf = hcpdfechsalenf;
    }

    /**
     * @return
     */
    public Date getHcpdfechsalenf() {
        return hcpdfechsalenf;
    }

    /**
     * @param hcpdfechingmed
     */
    public void setHcpdfechingmed(Date hcpdfechingmed) {
        this.hcpdfechingmed = hcpdfechingmed;
    }

    /**
     * @return
     */
    public Date getHcpdfechingmed() {
        return hcpdfechingmed;
    }

    /**
     * @param hcpdfechingenf
     */
    public void setHcpdfechingenf(Date hcpdfechingenf) {
        this.hcpdfechingenf = hcpdfechingenf;
    }

    /**
     * @return
     */
    public Date getHcpdfechingenf() {
        return hcpdfechingenf;
    }

    /**
     * @param hcpcoperingmed
     */
    public void setHcpcoperingmed(String hcpcoperingmed) {
        this.hcpcoperingmed = hcpcoperingmed;
    }

    /**
     * @return
     */
    public String getHcpcoperingmed() {
        return hcpcoperingmed;
    }

    /**
     * @param hcpcoperingenf
     */
    public void setHcpcoperingenf(String hcpcoperingenf) {
        this.hcpcoperingenf = hcpcoperingenf;
    }

    /**
     * @return
     */
    public String getHcpcoperingenf() {
        return hcpcoperingenf;
    }

    /**
     * @param cerrarCirugia
     */
    public void setCerrarCirugia(boolean cerrarCirugia) {
        this.cerrarCirugia = cerrarCirugia;
    }

    /**
     * @return
     */
    public boolean isCerrarCirugia() {
        cerrarCirugia = false;
        if (hcpcsalidmedic != null && hcpcsalidmedic.equals("S")) {
            cerrarCirugia = true;
        }
        return cerrarCirugia;
    }


    /**
     * @param hcpcregisepicr
     */
    public void setHcpcregisepicr(String hcpcregisepicr) {
        this.hcpcregisepicr = hcpcregisepicr;
    }

    /**
     * @return
     */
    public String getHcpcregisepicr() {
        return hcpcregisepicr;
    }

    /**
     * @param hcpcoperaepicr
     */
    public void setHcpcoperaepicr(String hcpcoperaepicr) {
        this.hcpcoperaepicr = hcpcoperaepicr;
    }

    /**
     * @return
     */
    public String getHcpcoperaepicr() {
        return hcpcoperaepicr;
    }

    /**
     * @param hcpcoperaanula
     */
    public void setHcpcoperaanula(String hcpcoperaanula) {
        this.hcpcoperaanula = hcpcoperaanula;
    }

    /**
     * @return
     */
    public String getHcpcoperaanula() {
        return hcpcoperaanula;
    }

    /**
     * @param hcpdfechaanula
     */
    public void setHcpdfechaanula(Date hcpdfechaanula) {
        this.hcpdfechaanula = hcpdfechaanula;
    }

    /**
     * @return
     */
    public Date getHcpdfechaanula() {
        return hcpdfechaanula;
    }

    /**
     * @param chdescrquiru
     */
    public void setChdescrquiru(Chdescrquiru chdescrquiru) {
        this.chdescrquiru = chdescrquiru;
    }

    /**
     * @return
     */
    public Chdescrquiru getChdescrquiru() {
        return chdescrquiru;
    }


    /**
     * @param chepicrisis
     */
    public void setChepicrisis(Set<Chepicrisi> chepicrisis) {
        this.chepicrisis = chepicrisis;
    }

    /**
     * @return
     */
    public Set<Chepicrisi> getChepicrisis() {
        return chepicrisis;
    }


    /**
     * @param chcontrmedics
     */
    public void setChcontrmedics(Set<Chcontrmedic> chcontrmedics) {
        this.chcontrmedics = chcontrmedics;
    }

    /**
     * @return
     */
    public Set<Chcontrmedic> getChcontrmedics() {
        return chcontrmedics;
    }

    /**
     * @param chnotaenferms
     */
    public void setChnotaenferms(Set<Chnotaenferm> chnotaenferms) {
        this.chnotaenferms = chnotaenferms;
    }

    /**
     * @return
     */
    public Set<Chnotaenferm> getChnotaenferms() {
        return chnotaenferms;
    }

    /**
     * @param chcontroliqus
     */
    public void setChcontroliqus(Set<Chcontroliqu> chcontroliqus) {
        this.chcontroliqus = chcontroliqus;
    }

    /**
     * @return
     */
    public Set<Chcontroliqu> getChcontroliqus() {
        return chcontroliqus;
    }

    /**
     * @param chcanalivenas
     */
    public void setChcanalivenas(Set<Chcanalivena> chcanalivenas) {
        this.chcanalivenas = chcanalivenas;
    }

    /**
     * @return
     */
    public Set<Chcanalivena> getChcanalivenas() {
        return chcanalivenas;
    }

    /**
     * @param chsignovitals
     */
    public void setChsignovitals(Set<Chsignovital> chsignovitals) {
        this.chsignovitals = chsignovitals;
    }

    /**
     * @return
     */
    public Set<Chsignovital> getChsignovitals() {
        return chsignovitals;
    }

    /**
     * @param chevolucions
     */
    public void setChevolucions(Set<Chevolucion> chevolucions) {
        this.chevolucions = chevolucions;
    }

    /**
     * @return
     */
    public Set<Chevolucion> getChevolucions() {
        return chevolucions;
    }

    /**
     * @param chingresoenfs
     */
    public void setChingresoenfs(Set<Chingresoenf> chingresoenfs) {
        this.chingresoenfs = chingresoenfs;
    }

    /**
     * @return
     */
    public Set<Chingresoenf> getChingresoenfs() {
        return chingresoenfs;
    }

    /**
     * @param hcpcmotivanula
     */
    public void setHcpcmotivanula(String hcpcmotivanula) {
        this.hcpcmotivanula = hcpcmotivanula;
    }

    /**
     * @return
     */
    public String getHcpcmotivanula() {
        return hcpcmotivanula;
    }

    /**
     * @param hcpcregisinstr
     */
    public void setHcpcregisinstr(String hcpcregisinstr) {
        this.hcpcregisinstr = hcpcregisinstr;
    }

    /**
     * @return
     */
    public String getHcpcregisinstr() {
        return hcpcregisinstr;
    }

    /**
     * @param hcpcoperainstr
     */
    public void setHcpcoperainstr(String hcpcoperainstr) {
        this.hcpcoperainstr = hcpcoperainstr;
    }

    /**
     * @return
     */
    public String getHcpcoperainstr() {
        return hcpcoperainstr;
    }

    /**
     * @param hcpcobseranula
     */
    public void setHcpcobseranula(String hcpcobseranula) {
        this.hcpcobseranula = hcpcobseranula;
    }

    /**
     * @return
     */
    public String getHcpcobseranula() {
        return hcpcobseranula;
    }

    /**
     * @param chanestesia
     */
    public void setChanestesia(Set<Chanestesia> chanestesia) {
        this.chanestesia = chanestesia;
    }

    /**
     * @return
     */
    public Set<Chanestesia> getChanestesia() {
        return chanestesia;
    }




    /**
     * @param chcontmedane
     */
    public void setChcontmedane(Set<Chcontmedane> chcontmedane) {
        this.chcontmedane = chcontmedane;
    }

    /**
     * @return
     */
    public Set<Chcontmedane> getChcontmedane() {
        return chcontmedane;
    }

    /**
     * @param hcpctipoayudan
     */
    public void setHcpctipoayudan(String hcpctipoayudan) {
        this.hcpctipoayudan = hcpctipoayudan;
    }

    /**
     * @return
     */
    public String getHcpctipoayudan() {
        return hcpctipoayudan;
    }

    /**
     * @param hcpcregisanest
     */
    public void setHcpcregisanest(String hcpcregisanest) {
        this.hcpcregisanest = hcpcregisanest;
    }

    /**
     * @return
     */
    public String getHcpcregisanest() {
        return hcpcregisanest;
    }

    /**
     * @param chsegutelefo
     */
    public void setChsegutelefo(Set<Chsegutelefo> chsegutelefo) {
        this.chsegutelefo = chsegutelefo;
    }

    /**
     * @return
     */
    public Set<Chsegutelefo> getChsegutelefo() {
        return chsegutelefo;
    }

    /**
     * @param chverquirofa
     */
    public void setChverquirofa(Set<Chverquirofa> chverquirofa) {
        this.chverquirofa = chverquirofa;
    }

    /**
     * @return
     */
    public Set<Chverquirofa> getChverquirofa() {
        return chverquirofa;
    }


    /**
     * @param hcpcminutdurac
     */
    public void setHcpcminutdurac(String hcpcminutdurac) {
        this.hcpcminutdurac = hcpcminutdurac;
    }

    /**
     * @return
     */
    public String getHcpcminutdurac() {
        return hcpcminutdurac;
    }

    /**
     * @param hcpchoradurac
     */
    public void setHcpchoradurac(String hcpchoradurac) {
        this.hcpchoradurac = hcpchoradurac;
    }

    /**
     * @return
     */
    public String getHcpchoradurac() {
        return hcpchoradurac;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setChposicanest(Set<Chposicanest> chposicanest) {
        this.chposicanest = chposicanest;
    }

    public Set<Chposicanest> getChposicanest() {
        return chposicanest;
    }

    public void setChmonitoria(Set<Chmonitoria> chmonitoria) {
        this.chmonitoria = chmonitoria;
    }

    public Set<Chmonitoria> getChmonitoria() {
        return chmonitoria;
    }

    public void setNombreAnestesiologo(String nombreAnestesiologo) {
        this.nombreAnestesiologo = nombreAnestesiologo;
    }

    public String getNombreAnestesiologo() {
        return nombreAnestesiologo;
    }

    public void setNombreAyudante(String nombreAyudante) {
        this.nombreAyudante = nombreAyudante;
    }

    public String getNombreAyudante() {
        return nombreAyudante;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setNumeiden(Long numeiden) {
        this.numeiden = numeiden;
    }

    public Long getNumeiden() {
        return numeiden;
    }

    public void setHcpnordenllega(Integer hcpnordenllega) {
        this.hcpnordenllega = hcpnordenllega;
    }

    public Integer getHcpnordenllega() {
        return hcpnordenllega;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setChventiaerea(Set<Chventiaerea> chventiaerea) {
        this.chventiaerea = chventiaerea;
    }

    public Set<Chventiaerea> getChventiaerea() {
        return chventiaerea;
    }

    public void setChcierreanest(Set<Chcierreanest> chcierreanest) {
        this.chcierreanest = chcierreanest;
    }

    public Set<Chcierreanest> getChcierreanest() {
        return chcierreanest;
    }

    public void setChciruganula(Set<Chciruganula> chciruganula) {
        this.chciruganula = chciruganula;
    }

    public Set<Chciruganula> getChciruganula() {
        return chciruganula;
    }

    public void setDescSala(String descSala) {
        this.descSala = descSala;
    }

    public String getDescSala() {
        return descSala;
    }


    public void setChconductas(Set<Chconducta> chconductas) {
        this.chconductas = chconductas;
    }

    public Set<Chconducta> getChconductas() {
        return chconductas;
    }

    public void setHcpctiposedacio(String hcpctiposedacio) {
        this.hcpctiposedacio = hcpctiposedacio;
    }

    public String getHcpctiposedacio() {
        return hcpctiposedacio;
    }

    public void setTipoSedacion(String tipoSedacion) {
        this.tipoSedacion = tipoSedacion;
    }

    public String getTipoSedacion() {
        return tipoSedacion;
    }

    public void setNombreeps(String nombreeps) {
        this.nombreeps = nombreeps;
    }

    public String getNombreeps() {
        return nombreeps;
    }

    public void setNumerocelular(String numerocelular) {
        this.numerocelular = numerocelular;
    }

    public String getNumerocelular() {
        return numerocelular;
    }

    public void setNumerofijo(String numerofijo) {
        this.numerofijo = numerofijo;
    }

    public String getNumerofijo() {
        return numerofijo;
    }

    public void setHcpcnomresiden(String hcpcnomresiden) {
        this.hcpcnomresiden = hcpcnomresiden;
    }

    public String getHcpcnomresiden() {
        return hcpcnomresiden;
    }

    public void setChanatopatols(Set<Chanatopatol> chanatopatols) {
        this.chanatopatols = chanatopatols;
    }

    public Set<Chanatopatol> getChanatopatols() {
        return chanatopatols;
    }
    
    public void setAutorizaContacto(String autorizaContacto) {
        this.autorizaContacto = autorizaContacto;
    }

    public String getAutorizaContacto() {
        return autorizaContacto;
    }

    public void setChtecnianests(Set<Chtecnianest> chtecnianests) {
        this.chtecnianests = chtecnianests;
    }

    public Set<Chtecnianest> getChtecnianests() {
        return chtecnianests;
    }

    public void setHcpcressangre(String hcpcressangre) {
        this.hcpcressangre = hcpcressangre;
    }

    public String getHcpcressangre() {
        return hcpcressangre;
    }

    public void setHcpctipohemoco(String hcpctipohemoco) {
        this.hcpctipohemoco = hcpctipohemoco;
    }

    public String getHcpctipohemoco() {
        return hcpctipohemoco;
    }

    public void setHcpnnumerounid(Integer hcpnnumerounid) {
        this.hcpnnumerounid = hcpnnumerounid;
    }

    public Integer getHcpnnumerounid() {
        return hcpnnumerounid;
    }


    public void setHcpcobserv(String hcpcobserv) {
        this.hcpcobserv = hcpcobserv;
    }

    public String getHcpcobserv() {
        return hcpcobserv;
    }
    
    /**
     * @param reservaSangre
     */
    public void setReservaSangre(String reservaSangre) {
        this.reservaSangre = reservaSangre;
    }

    /**
     * @return
     */
    public String getReservaSangre() {
        if (hcpcressangre != null) {
            if (hcpcressangre.equals("S")) {
                reservaSangre = "SI";
            }
            if (hcpcressangre.equals("N")) {
                reservaSangre = "NO";
            }
        }
        return reservaSangre;
    }

    /**
     * @param Etapa
     */
    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    /**
     * @return
     */
    public String getEtapa() {
        if (hcpcetapa == null) {
           etapa = "No registrada";
        } else if (hcpcetapa.equals("PR")) {
           etapa = "Programada Cirugia";
        } else if (hcpcetapa.equals("IE")) {
           etapa = "Ingreso Enfermeria";
        } else if (hcpcetapa.equals("PQ")) {
           etapa = "Pendiente Quirofano";
        } else if (hcpcetapa.equals("EQ")) {
           etapa = "En Quirofano";
        } else if (hcpcetapa.equals("ER")) {
           etapa = "En Recuperaci�n";
        } else if (hcpcetapa.equals("AT")) {
           etapa = "Atendida";
        } else if (hcpcetapa.equals("ES")) {
           etapa = "Espera Ingreso Enfermeria";
        } else {
           etapa = hcpcetapa;
        }
        return etapa;
    }


    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setAsegurador(String asegurador) {
        this.asegurador = asegurador;
    }

    public String getAsegurador() {
        return asegurador;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setAnestesia(String anestesia) {
        this.anestesia = anestesia;
    }

    public String getAnestesia() {
        return anestesia;
    }

    public void setChescvalcai(Set<Chescvalcai> chescvalcai) {
        this.chescvalcai = chescvalcai;
    }

    public Set<Chescvalcai> getChescvalcai() {
        return chescvalcai;
    }
}
