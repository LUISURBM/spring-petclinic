package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chepicrisi implements Serializable {

    /** identifier field */
    private ChepicrisiPK id;

    /** nullable persistent field */
    private Long heplusuario;

    /** nullable persistent field */
    private String hepcmotivocons;

    /** nullable persistent field */
    private String hepcestaingres;

    /** nullable persistent field */
    private String hepcenfeactual;

    /** nullable persistent field */
    private String hepcantecedent;

    /** nullable persistent field */
    private String hepcrevisistem;

    /** nullable persistent field */
    private String hepchallaexafi;

    /** nullable persistent field */
    private String hepcconducta;

    /** nullable persistent field */
    private String hepcevolucion;

    /** nullable persistent field */
    private String hepcexamapoyo;

    /** nullable persistent field */
    private String hepccondegres;

    /** nullable persistent field */
    private Integer hepnclinica;

    /** nullable persistent field */
    private String hepcestado;

    /** nullable persistent field */
    private Date hepdfecregistr;

    /** nullable persistent field */
    private String hepcoperador;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String hepcdiagingnpresu;

    /** nullable persistent field */
    private String hepcdiagnconfi;

    /** nullable persistent field */
    private String hepcdiagingnrelacu;

    /** nullable persistent field */
    private String hepctipousuari;

    /** nullable persistent field */
    private Date hepdfechaingre;

    /** nullable persistent field */
    private Date hepdfechaegres;

    /** nullable persistent field */
    private String hepcserviingre;

    /** nullable persistent field */
    private String hepcserviegres;
    
    /** nullable persistent field */
    private String hepcdiagingrelacd;
    
    /** nullable persistent field */
    private String hepcdiagingrelact;
    
    /** nullable persistent field */
    private String hepcdiagegrrelacu;
    
    /** nullable persistent field */
    private String hepcdiagegrrelacd;
    
    /** nullable persistent field */
    private String hepcdiagegrrelact;
    
    /** nullable persistent field */
    private String hepcdiagegrpresu;
    
    /** nullable persistent field */
    private String hepcintres;
    
    /** nullable persistent field */
    private String hepcindterap;
    
    /** nullable persistent field */
    private String hepcplaman;



    /** default constructor */
    public Chepicrisi() {
    }


    /**
     * @param id
     */
    public void setId(ChepicrisiPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChepicrisiPK getId() {
        return id;
    }

    /**
     * @param heplusuario
     */
    public void setHeplusuario(Long heplusuario) {
        this.heplusuario = heplusuario;
    }

    /**
     * @return
     */
    public Long getHeplusuario() {
        return heplusuario;
    }

    /**
     * @param hepcmotivocons
     */
    public void setHepcmotivocons(String hepcmotivocons) {
        this.hepcmotivocons = hepcmotivocons;
    }

    /**
     * @return
     */
    public String getHepcmotivocons() {
        return hepcmotivocons;
    }

    /**
     * @param hepcestaingres
     */
    public void setHepcestaingres(String hepcestaingres) {
        this.hepcestaingres = hepcestaingres;
    }

    /**
     * @return
     */
    public String getHepcestaingres() {
        return hepcestaingres;
    }

    /**
     * @param hepcenfeactual
     */
    public void setHepcenfeactual(String hepcenfeactual) {
        this.hepcenfeactual = hepcenfeactual;
    }

    /**
     * @return
     */
    public String getHepcenfeactual() {
        return hepcenfeactual;
    }

    /**
     * @param hepcantecedent
     */
    public void setHepcantecedent(String hepcantecedent) {
        this.hepcantecedent = hepcantecedent;
    }

    /**
     * @return
     */
    public String getHepcantecedent() {
        return hepcantecedent;
    }

    /**
     * @param hepcrevisistem
     */
    public void setHepcrevisistem(String hepcrevisistem) {
        this.hepcrevisistem = hepcrevisistem;
    }

    /**
     * @return
     */
    public String getHepcrevisistem() {
        return hepcrevisistem;
    }

    /**
     * @param hepchallaexafi
     */
    public void setHepchallaexafi(String hepchallaexafi) {
        this.hepchallaexafi = hepchallaexafi;
    }

    /**
     * @return
     */
    public String getHepchallaexafi() {
        return hepchallaexafi;
    }


    /**
     * @param hepcconducta
     */
    public void setHepcconducta(String hepcconducta) {
        this.hepcconducta = hepcconducta;
    }

    /**
     * @return
     */
    public String getHepcconducta() {
        return hepcconducta;
    }

    /**
     * @param hepcevolucion
     */
    public void setHepcevolucion(String hepcevolucion) {
        this.hepcevolucion = hepcevolucion;
    }

    /**
     * @return
     */
    public String getHepcevolucion() {
        return hepcevolucion;
    }

    /**
     * @param hepcexamapoyo
     */
    public void setHepcexamapoyo(String hepcexamapoyo) {
        this.hepcexamapoyo = hepcexamapoyo;
    }

    /**
     * @return
     */
    public String getHepcexamapoyo() {
        return hepcexamapoyo;
    }

    /**
     * @param hepccondegres
     */
    public void setHepccondegres(String hepccondegres) {
        this.hepccondegres = hepccondegres;
    }

    /**
     * @return
     */
    public String getHepccondegres() {
        return hepccondegres;
    }

    /**
     * @param hepnclinica
     */
    public void setHepnclinica(Integer hepnclinica) {
        this.hepnclinica = hepnclinica;
    }

    /**
     * @return
     */
    public Integer getHepnclinica() {
        return hepnclinica;
    }

    /**
     * @param hepcestado
     */
    public void setHepcestado(String hepcestado) {
        this.hepcestado = hepcestado;
    }

    /**
     * @return
     */
    public String getHepcestado() {
        return hepcestado;
    }

    /**
     * @param hepdfecregistr
     */
    public void setHepdfecregistr(Date hepdfecregistr) {
        this.hepdfecregistr = hepdfecregistr;
    }

    /**
     * @return
     */
    public Date getHepdfecregistr() {
        return hepdfecregistr;
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
     * @param hepcdiagnconfi
     */
    public void setHepcdiagnconfi(String hepcdiagnconfi) {
        this.hepcdiagnconfi = hepcdiagnconfi;
    }

    /**
     * @return
     */
    public String getHepcdiagnconfi() {
        return hepcdiagnconfi;
    }

    /**
     * @param hepcdiagnrelac
     */

    /**
     * @param hepctipousuari
     */
    public void setHepctipousuari(String hepctipousuari) {
        this.hepctipousuari = hepctipousuari;
    }

    /**
     * @return
     */
    public String getHepctipousuari() {
        return hepctipousuari;
    }

    /**
     * @param hepdfechaingre
     */
    public void setHepdfechaingre(Date hepdfechaingre) {
        this.hepdfechaingre = hepdfechaingre;
    }

    /**
     * @return
     */
    public Date getHepdfechaingre() {
        return hepdfechaingre;
    }

    /**
     * @param hepdfechaegres
     */
    public void setHepdfechaegres(Date hepdfechaegres) {
        this.hepdfechaegres = hepdfechaegres;
    }

    /**
     * @return
     */
    public Date getHepdfechaegres() {
        return hepdfechaegres;
    }

    /**
     * @param hepcserviingre
     */
    public void setHepcserviingre(String hepcserviingre) {
        this.hepcserviingre = hepcserviingre;
    }

    /**
     * @return
     */
    public String getHepcserviingre() {
        return hepcserviingre;
    }

    /**
     * @param hepcserviegres
     */
    public void setHepcserviegres(String hepcserviegres) {
        this.hepcserviegres = hepcserviegres;
    }

    /**
     * @return
     */
    public String getHepcserviegres() {
        return hepcserviegres;
    }

    public void setHepcdiagingnpresu(String hepcdiagingnpresu) {
        this.hepcdiagingnpresu = hepcdiagingnpresu;
    }

    public String getHepcdiagingnpresu() {
        return hepcdiagingnpresu;
    }

   

    public void setHepcdiagingrelacd(String hepcdiagingrelacd) {
        this.hepcdiagingrelacd = hepcdiagingrelacd;
    }

    public String getHepcdiagingrelacd() {
        return hepcdiagingrelacd;
    }

    public void setHepcdiagingrelact(String hepcdiagingrelact) {
        this.hepcdiagingrelact = hepcdiagingrelact;
    }

    public String getHepcdiagingrelact() {
        return hepcdiagingrelact;
    }

    public void setHepcdiagegrrelacu(String hepcdiagegrrelacu) {
        this.hepcdiagegrrelacu = hepcdiagegrrelacu;
    }

    public String getHepcdiagegrrelacu() {
        return hepcdiagegrrelacu;
    }

    public void setHepcdiagegrrelacd(String hepcdiagegrrelacd) {
        this.hepcdiagegrrelacd = hepcdiagegrrelacd;
    }

    public String getHepcdiagegrrelacd() {
        return hepcdiagegrrelacd;
    }

    public void setHepcdiagegrrelact(String hepcdiagegrrelact) {
        this.hepcdiagegrrelact = hepcdiagegrrelact;
    }

    public String getHepcdiagegrrelact() {
        return hepcdiagegrrelact;
    }

    public void setHepcdiagegrpresu(String hepcdiagegrpresu) {
        this.hepcdiagegrpresu = hepcdiagegrpresu;
    }

    public String getHepcdiagegrpresu() {
        return hepcdiagegrpresu;
    }

    public void setHepcintres(String hepcintres) {
        this.hepcintres = hepcintres;
    }

    public String getHepcintres() {
        return hepcintres;
    }


    public void setHepcindterap(String hepcindterap) {
        this.hepcindterap = hepcindterap;
    }

    public String getHepcindterap() {
        return hepcindterap;
    }

    public void setHepcdiagingnrelacu(String hepcdiagingnrelacu) {
        this.hepcdiagingnrelacu = hepcdiagingnrelacu;
    }

    public String getHepcdiagingnrelacu() {
        return hepcdiagingnrelacu;
    }

    public void setHepcplaman(String hepcplaman) {
        this.hepcplaman = hepcplaman;
    }

    public String getHepcplaman() {
        return hepcplaman;
    }
}
