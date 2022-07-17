package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;


/** @author Hibernate CodeGenerator */
public class Chaseavise implements Serializable {

    /** identifier field */
    private ChaseavisePK id;

    /** persistent field */
    private String havctipide;

    /** persistent field */
    private Long havanumide;

    /** persistent field */
    private Integer havnclinic;

    /** persistent field */
    private Integer havnescola;

    /** persistent field */
    private Integer havnedad;

    /** nullable persistent field */
    private String havcagrcon;

    

    /** persistent field */
    private Integer havnlugech;

    /** nullable persistent field */
    private String havcotrlug;

    /** persistent field */
    private Integer havntieocu;

    /** nullable persistent field */
    private String havcaccnin;

    /** nullable persistent field */
    private String havcaccden;

    /** nullable persistent field */
    private String havcaccate;

    /** nullable persistent field */
    private String havcaccapo;

    /** nullable persistent field */
    private String havcrecotr;

    /** nullable persistent field */
    private String havcrecnom;


    /** persistent field */
    private String havcremotr;

    /** nullable persistent field */
    private String havcnmbotr;

    /** persistent field */
    private Date havdfecreg;

    /** persistent field */
    private String havcusureg;

    /** persistent field */
    private Integer havnconavs;

    /** persistent field */
    private Integer havnintase;

    /** nullable persistent field */
    private String havetranqu;

    /** nullable persistent field */
    private String haveangust;

    /** nullable persistent field */
    private String havetriste;

    /** nullable persistent field */
    private String haveconfun;

    /** nullable persistent field */
    private String havedesori;

    /** nullable persistent field */
    private String haveansios;

    /** nullable persistent field */
    private String havesendes;

    /** nullable persistent field */
    private String haveimpote;

    /** nullable persistent field */
    private String havedolor;

    /** nullable persistent field */
    private String havehemato;

    /** nullable persistent field */
    private String havefractu;

    /** nullable persistent field */
    private String haveinsomn;

    /** nullable persistent field */
    private String haveinapet;

    /** nullable persistent field */
    private String havesendeb;

    /** nullable persistent field */
    private String haveahogo;

    /** nullable persistent field */
    private String haveagresi;

    /** nullable persistent field */
    private String haveaislam;

    /** nullable persistent field */
    private String havepasmad;

    /** nullable persistent field */
    private String havereftem;

    /** nullable persistent field */
    private String havedisper;

    /** nullable persistent field */
    private String havepenneg;

    /** nullable persistent field */
    private String havedifpro;

    /** nullable persistent field */
    private String haveideper;

    /** nullable persistent field */
    private String haveotro;

    /** nullable persistent field */
    private String havedocden;

    /** nullable persistent field */
    private String havepruemb;

    /** persistent field */
    private String havcestado;

    /** nullable persistent field */
    private String havcusumod;

    /** nullable persistent field */
    private Date havdfecmod;

    /** nullable persistent field */
    private String havepalpi;

    /** nullable persistent field */
    private String haveaccot;

    /** nullable persistent field */
    private String haveincme;

    /** nullable persistent field */
    private String havevalps;

    /** nullable persistent field */
    private String havecerme;

    /** nullable persistent field */
    private String haveotrdoc;

    /** nullable persistent field */
    private String havcnomdoc;

    /** nullable persistent field */
    private String havcnindoc;

    /** nullable persistent field */
    private String havcconclu;
    
    /** nullable persistent field */
    private String havcconpsi;

    /** nullable persistent field */
    private String havcremilv;

    /** nullable persistent field */
    private String havcotrcon;

    /** nullable persistent field */
    private Integer havndetint;

    /** nullable persistent field */
    private String havcremind;

    /** nullable persistent field */
    private String havcremcos;

    /** nullable persistent field */
    private String havcremeps;

    /** nullable persistent field */
    private String havcremips;

    /** nullable persistent field */
    private String havcremcau;

    /** nullable persistent field */
    private String havcremmay;

    /** nullable persistent field */
    private String havcremcon;

    /** nullable persistent field */
    private String havedoceco;

    /** nullable persistent field */
    private String haveagotad;

    /** nullable persistent field */
    private String havehostil;

    /** nullable persistent field */
    private String havedesesp;

    /** nullable persistent field */
    private String havedisfru;

    /** nullable persistent field */
    private String havehipera;

    /** nullable persistent field */
    private String havepareja;

    /** nullable persistent field */
    private String havefamili;

    /** nullable persistent field */
    private String havedesamp;

    /** nullable persistent field */
    private String havepobrez;

    /** nullable persistent field */
    private String haveviolen;

    /** nullable persistent field */
    private String havedesemp;

    /** nullable persistent field */
    private String havedificu;

    /** nullable persistent field */
    private String haveconcen;

    /** nullable persistent field */
    private String havesuicid;

    /** nullable persistent field */
    private String havemareo;

    /** nullable persistent field */
    private String havcremapl;

    /** nullable persistent field */
    private String havcremmot;

    /** nullable persistent field */
    private Integer havnrelagr;

    /** nullable persistent field */
    private Integer havnparagr;

    /** nullable persistent field */
    private String havcotrpar;

    /** nullable persistent field */
    private String havcotrrel;

    /** nullable persistent field */
    private Integer havndiaeve;

    /** nullable persistent field */
    private Integer havnedages;

    /** nullable persistent field */
    private String havcintcri;

    /** nullable persistent field */
    private Integer version;
    
    /** persistent field */
    private Set hnseguavis;
    
    /** persistent field */
    private String haveantem; 
    
    /** persistent field */
    private String havcotracc; 

    /** default constructor */
    public Chaseavise() {
        id = new ChaseavisePK(); 
    }


    public void setId(ChaseavisePK id) {
        this.id = id;
    }

    public ChaseavisePK getId() {
        return id;
    }

    public void setHavctipide(String havctipide) {
        this.havctipide = havctipide;
    }

    public String getHavctipide() {
        return havctipide;
    }

    public void setHavanumide(Long havanumide) {
        this.havanumide = havanumide;
    }

    public Long getHavanumide() {
        return havanumide;
    }

    public void setHavnclinic(Integer havnclinic) {
        this.havnclinic = havnclinic;
    }

    public Integer getHavnclinic() {
        return havnclinic;
    }

    public void setHavnescola(Integer havnescola) {
        this.havnescola = havnescola;
    }

    public Integer getHavnescola() {
        return havnescola;
    }

    public void setHavnedad(Integer havnedad) {
        this.havnedad = havnedad;
    }

    public Integer getHavnedad() {
        return havnedad;
    }

    public void setHavcagrcon(String havcagrcon) {
        this.havcagrcon = havcagrcon;
    }

    public String getHavcagrcon() {
        return havcagrcon;
    }

    public void setHavnlugech(Integer havnlugech) {
        this.havnlugech = havnlugech;
    }

    public Integer getHavnlugech() {
        return havnlugech;
    }

    public void setHavcotrlug(String havcotrlug) {
        this.havcotrlug = havcotrlug;
    }

    public String getHavcotrlug() {
        return havcotrlug;
    }

    public void setHavntieocu(Integer havntieocu) {
        this.havntieocu = havntieocu;
    }

    public Integer getHavntieocu() {
        return havntieocu;
    }

    public void setHavcaccnin(String havcaccnin) {
        this.havcaccnin = havcaccnin;
    }

    public String getHavcaccnin() {
        return havcaccnin;
    }

    public void setHavcaccden(String havcaccden) {
        this.havcaccden = havcaccden;
    }

    public String getHavcaccden() {
        return havcaccden;
    }

    public void setHavcaccate(String havcaccate) {
        this.havcaccate = havcaccate;
    }

    public String getHavcaccate() {
        return havcaccate;
    }

    public void setHavcaccapo(String havcaccapo) {
        this.havcaccapo = havcaccapo;
    }

    public String getHavcaccapo() {
        return havcaccapo;
    }

    public void setHavcrecotr(String havcrecotr) {
        this.havcrecotr = havcrecotr;
    }

    public String getHavcrecotr() {
        return havcrecotr;
    }

    public void setHavcrecnom(String havcrecnom) {
        this.havcrecnom = havcrecnom;
    }

    public String getHavcrecnom() {
        return havcrecnom;
    }

    public void setHavcremotr(String havcremotr) {
        this.havcremotr = havcremotr;
    }

    public String getHavcremotr() {
        return havcremotr;
    }

    public void setHavcnmbotr(String havcnmbotr) {
        this.havcnmbotr = havcnmbotr;
    }

    public String getHavcnmbotr() {
        return havcnmbotr;
    }

    public void setHavdfecreg(Date havdfecreg) {
        this.havdfecreg = havdfecreg;
    }

    public Date getHavdfecreg() {
        return havdfecreg;
    }

    public void setHavcusureg(String havcusureg) {
        this.havcusureg = havcusureg;
    }

    public String getHavcusureg() {
        return havcusureg;
    }

    public void setHavnconavs(Integer havnconavs) {
        this.havnconavs = havnconavs;
    }

    public Integer getHavnconavs() {
        return havnconavs;
    }

    public void setHavnintase(Integer havnintase) {
        this.havnintase = havnintase;
    }

    public Integer getHavnintase() {
        return havnintase;
    }

    public void setHavetranqu(String havetranqu) {
        this.havetranqu = havetranqu;
    }

    public String getHavetranqu() {
        return havetranqu;
    }

    public void setHaveangust(String haveangust) {
        this.haveangust = haveangust;
    }

    public String getHaveangust() {
        return haveangust;
    }

    public void setHavetriste(String havetriste) {
        this.havetriste = havetriste;
    }

    public String getHavetriste() {
        return havetriste;
    }

    public void setHaveconfun(String haveconfun) {
        this.haveconfun = haveconfun;
    }

    public String getHaveconfun() {
        return haveconfun;
    }

    public void setHavedesori(String havedesori) {
        this.havedesori = havedesori;
    }

    public String getHavedesori() {
        return havedesori;
    }

    public void setHaveansios(String haveansios) {
        this.haveansios = haveansios;
    }

    public String getHaveansios() {
        return haveansios;
    }

    public void setHavesendes(String havesendes) {
        this.havesendes = havesendes;
    }

    public String getHavesendes() {
        return havesendes;
    }

    public void setHaveimpote(String haveimpote) {
        this.haveimpote = haveimpote;
    }

    public String getHaveimpote() {
        return haveimpote;
    }

    public void setHavedolor(String havedolor) {
        this.havedolor = havedolor;
    }

    public String getHavedolor() {
        return havedolor;
    }

    public void setHavehemato(String havehemato) {
        this.havehemato = havehemato;
    }

    public String getHavehemato() {
        return havehemato;
    }

    public void setHavefractu(String havefractu) {
        this.havefractu = havefractu;
    }

    public String getHavefractu() {
        return havefractu;
    }

    public void setHaveinsomn(String haveinsomn) {
        this.haveinsomn = haveinsomn;
    }

    public String getHaveinsomn() {
        return haveinsomn;
    }

    public void setHaveinapet(String haveinapet) {
        this.haveinapet = haveinapet;
    }

    public String getHaveinapet() {
        return haveinapet;
    }

    public void setHavesendeb(String havesendeb) {
        this.havesendeb = havesendeb;
    }

    public String getHavesendeb() {
        return havesendeb;
    }

    public void setHaveahogo(String haveahogo) {
        this.haveahogo = haveahogo;
    }

    public String getHaveahogo() {
        return haveahogo;
    }

    public void setHaveagresi(String haveagresi) {
        this.haveagresi = haveagresi;
    }

    public String getHaveagresi() {
        return haveagresi;
    }

    public void setHaveaislam(String haveaislam) {
        this.haveaislam = haveaislam;
    }

    public String getHaveaislam() {
        return haveaislam;
    }

    public void setHavepasmad(String havepasmad) {
        this.havepasmad = havepasmad;
    }

    public String getHavepasmad() {
        return havepasmad;
    }

    public void setHavereftem(String havereftem) {
        this.havereftem = havereftem;
    }

    public String getHavereftem() {
        return havereftem;
    }

    public void setHavedisper(String havedisper) {
        this.havedisper = havedisper;
    }

    public String getHavedisper() {
        return havedisper;
    }

    public void setHavepenneg(String havepenneg) {
        this.havepenneg = havepenneg;
    }

    public String getHavepenneg() {
        return havepenneg;
    }

    public void setHavedifpro(String havedifpro) {
        this.havedifpro = havedifpro;
    }

    public String getHavedifpro() {
        return havedifpro;
    }

    public void setHaveideper(String haveideper) {
        this.haveideper = haveideper;
    }

    public String getHaveideper() {
        return haveideper;
    }

    public void setHaveotro(String haveotro) {
        this.haveotro = haveotro;
    }

    public String getHaveotro() {
        return haveotro;
    }

    public void setHavedocden(String havedocden) {
        this.havedocden = havedocden;
    }

    public String getHavedocden() {
        return havedocden;
    }

    public void setHavepruemb(String havepruemb) {
        this.havepruemb = havepruemb;
    }

    public String getHavepruemb() {
        return havepruemb;
    }

    public void setHavcestado(String havcestado) {
        this.havcestado = havcestado;
    }

    public String getHavcestado() {
        return havcestado;
    }

    public void setHavcusumod(String havcusumod) {
        this.havcusumod = havcusumod;
    }

    public String getHavcusumod() {
        return havcusumod;
    }

    public void setHavdfecmod(Date havdfecmod) {
        this.havdfecmod = havdfecmod;
    }

    public Date getHavdfecmod() {
        return havdfecmod;
    }

    public void setHavepalpi(String havepalpi) {
        this.havepalpi = havepalpi;
    }

    public String getHavepalpi() {
        return havepalpi;
    }

    public void setHaveaccot(String haveaccot) {
        this.haveaccot = haveaccot;
    }

    public String getHaveaccot() {
        return haveaccot;
    }

    public void setHaveincme(String haveincme) {
        this.haveincme = haveincme;
    }

    public String getHaveincme() {
        return haveincme;
    }

    public void setHavevalps(String havevalps) {
        this.havevalps = havevalps;
    }

    public String getHavevalps() {
        return havevalps;
    }

    public void setHavecerme(String havecerme) {
        this.havecerme = havecerme;
    }

    public String getHavecerme() {
        return havecerme;
    }

    public void setHaveotrdoc(String haveotrdoc) {
        this.haveotrdoc = haveotrdoc;
    }

    public String getHaveotrdoc() {
        return haveotrdoc;
    }

    public void setHavcnomdoc(String havcnomdoc) {
        this.havcnomdoc = havcnomdoc;
    }

    public String getHavcnomdoc() {
        return havcnomdoc;
    }

    public void setHavcnindoc(String havcnindoc) {
        this.havcnindoc = havcnindoc;
    }

    public String getHavcnindoc() {
        return havcnindoc;
    }

    public void setHavcconclu(String havcconclu) {
        this.havcconclu = havcconclu;
    }

    public String getHavcconclu() {
        return havcconclu;
    }

    public void setHavcremilv(String havcremilv) {
        this.havcremilv = havcremilv;
    }

    public String getHavcremilv() {
        return havcremilv;
    }

    public void setHavcotrcon(String havcotrcon) {
        this.havcotrcon = havcotrcon;
    }

    public String getHavcotrcon() {
        return havcotrcon;
    }

    public void setHavndetint(Integer havndetint) {
        this.havndetint = havndetint;
    }

    public Integer getHavndetint() {
        return havndetint;
    }

    public void setHavcremind(String havcremind) {
        this.havcremind = havcremind;
    }

    public String getHavcremind() {
        return havcremind;
    }

    public void setHavcremcos(String havcremcos) {
        this.havcremcos = havcremcos;
    }

    public String getHavcremcos() {
        return havcremcos;
    }

    public void setHavcremeps(String havcremeps) {
        this.havcremeps = havcremeps;
    }

    public String getHavcremeps() {
        return havcremeps;
    }

    public void setHavcremips(String havcremips) {
        this.havcremips = havcremips;
    }

    public String getHavcremips() {
        return havcremips;
    }

    public void setHavcremcau(String havcremcau) {
        this.havcremcau = havcremcau;
    }

    public String getHavcremcau() {
        return havcremcau;
    }

    public void setHavcremmay(String havcremmay) {
        this.havcremmay = havcremmay;
    }

    public String getHavcremmay() {
        return havcremmay;
    }

    public void setHavcremcon(String havcremcon) {
        this.havcremcon = havcremcon;
    }

    public String getHavcremcon() {
        return havcremcon;
    }

    public void setHavedoceco(String havedoceco) {
        this.havedoceco = havedoceco;
    }

    public String getHavedoceco() {
        return havedoceco;
    }

    public void setHaveagotad(String haveagotad) {
        this.haveagotad = haveagotad;
    }

    public String getHaveagotad() {
        return haveagotad;
    }

    public void setHavehostil(String havehostil) {
        this.havehostil = havehostil;
    }

    public String getHavehostil() {
        return havehostil;
    }

    public void setHavedesesp(String havedesesp) {
        this.havedesesp = havedesesp;
    }

    public String getHavedesesp() {
        return havedesesp;
    }

    public void setHavedisfru(String havedisfru) {
        this.havedisfru = havedisfru;
    }

    public String getHavedisfru() {
        return havedisfru;
    }

    public void setHavehipera(String havehipera) {
        this.havehipera = havehipera;
    }

    public String getHavehipera() {
        return havehipera;
    }

    public void setHavepareja(String havepareja) {
        this.havepareja = havepareja;
    }

    public String getHavepareja() {
        return havepareja;
    }

    public void setHavefamili(String havefamili) {
        this.havefamili = havefamili;
    }

    public String getHavefamili() {
        return havefamili;
    }

    public void setHavedesamp(String havedesamp) {
        this.havedesamp = havedesamp;
    }

    public String getHavedesamp() {
        return havedesamp;
    }

    public void setHavepobrez(String havepobrez) {
        this.havepobrez = havepobrez;
    }

    public String getHavepobrez() {
        return havepobrez;
    }

    public void setHaveviolen(String haveviolen) {
        this.haveviolen = haveviolen;
    }

    public String getHaveviolen() {
        return haveviolen;
    }

    public void setHavedesemp(String havedesemp) {
        this.havedesemp = havedesemp;
    }

    public String getHavedesemp() {
        return havedesemp;
    }

    public void setHavedificu(String havedificu) {
        this.havedificu = havedificu;
    }

    public String getHavedificu() {
        return havedificu;
    }

    public void setHaveconcen(String haveconcen) {
        this.haveconcen = haveconcen;
    }

    public String getHaveconcen() {
        return haveconcen;
    }

    public void setHavesuicid(String havesuicid) {
        this.havesuicid = havesuicid;
    }

    public String getHavesuicid() {
        return havesuicid;
    }

    public void setHavemareo(String havemareo) {
        this.havemareo = havemareo;
    }

    public String getHavemareo() {
        return havemareo;
    }

    public void setHavcremapl(String havcremapl) {
        this.havcremapl = havcremapl;
    }

    public String getHavcremapl() {
        return havcremapl;
    }

    public void setHavcremmot(String havcremmot) {
        this.havcremmot = havcremmot;
    }

    public String getHavcremmot() {
        return havcremmot;
    }

    public void setHavnrelagr(Integer havnrelagr) {
        this.havnrelagr = havnrelagr;
    }

    public Integer getHavnrelagr() {
        return havnrelagr;
    }

    public void setHavnparagr(Integer havnparagr) {
        this.havnparagr = havnparagr;
    }

    public Integer getHavnparagr() {
        return havnparagr;
    }

    public void setHavcotrpar(String havcotrpar) {
        this.havcotrpar = havcotrpar;
    }

    public String getHavcotrpar() {
        return havcotrpar;
    }

    public void setHavcotrrel(String havcotrrel) {
        this.havcotrrel = havcotrrel;
    }

    public String getHavcotrrel() {
        return havcotrrel;
    }

    public void setHavndiaeve(Integer havndiaeve) {
        this.havndiaeve = havndiaeve;
    }

    public Integer getHavndiaeve() {
        return havndiaeve;
    }

    public void setHavnedages(Integer havnedages) {
        this.havnedages = havnedages;
    }

    public Integer getHavnedages() {
        return havnedages;
    }

    public void setHavcintcri(String havcintcri) {
        this.havcintcri = havcintcri;
    }

    public String getHavcintcri() {
        return havcintcri;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHnseguavis(Set hnseguavis) {
        this.hnseguavis = hnseguavis;
    }

    public Set getHnseguavis() {
        return hnseguavis;
    }

    public void setHaveantem(String haveantem) {
        this.haveantem = haveantem;
    }

    public String getHaveantem() {
        return haveantem;
    }

    public void setHavcotracc(String havcotracc) {
        this.havcotracc = havcotracc;
    }

    public String getHavcotracc() {
        return havcotracc;
    }

    public void setHavcconpsi(String havcconpsi) {
        this.havcconpsi = havcconpsi;
    }

    public String getHavcconpsi() {
        return havcconpsi;
    }
}
