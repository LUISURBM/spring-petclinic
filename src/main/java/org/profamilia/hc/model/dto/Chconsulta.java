package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.Set;


/** @author Hibernate CodeGenerator */
public class Chconsulta implements Serializable {

    /** identifier field */
    private Long hcolnumero;

    /** identifier field */
    private String hcoctiposervi;

    /** nullable persistent field */
    private String hcocentidadadm;

    /** persistent field */
    private Chusuario hcolusuario;

    /** nullable persistent field */
    private Integer hconfolio;

    /** nullable persistent field */
    private Cpservicio hcocservicio;

    /** nullable persistent field */
    private Integer hcontipoconsu;

    /** nullable persistent field */
    private Date hcodfeccierre;
    
    /** nullable persistent field */
    private Date hcodfecinicio; 

    /** nullable persistent field */
    private String hcoeetapa;

    /** nullable persistent field */
    private String hcocnombacompa;

    /** nullable persistent field */
    private String hcocteleacompa;

    /** nullable persistent field */
    private String hcocnombrespo;

    /** nullable persistent field */
    private String hcoctelerespo;

    /** nullable persistent field */
    private String hcocoperador;

    /** nullable persistent field */
    private Date hcodfecregistr;

    /** nullable persistent field */
    private Integer hconclinica;

    /** nullable persistent field */
    private Integer version;
    
    /** nullable persistent field */
    private Long  hcolconsuclini; 
    
    /** nullable persistent field */
    private Long  hconcodagen; 
    
    /** nullable persistent field */
    private Set chimprdiags;

    /** nullable persistent field */
    private Set chriesgomamas;

    /** nullable persistent field */
    private Set chmotivocons;

    /** nullable persistent field */
    private Set chconductas;

    /** nullable persistent field */
    private Set chreferencias;

    /** nullable persistent field */
    private Set chexafismamas;

    /** nullable persistent field */
    private Set chexamfisicos;

    /** nullable persistent field */
    private Set chanatopatols;


    /** nullable persistent field */
    private Set chanteginecos;

    /** nullable persistent field */
    private Set chordecirugis;

    /** nullable persistent field */
    private Set chcuestplanis;

    /** nullable persistent field */
    private Set chantecemamas;
    
    /** nullable persistent field */
    private Set<Chantecvasec> chantecvasec;

    /** nullable persistent field */
    private Set chincapacidas;

    /** nullable persistent field */
    private Set chexamediagns;

    /** nullable persistent field */
    private Set chviolencias;
    
    /** nullable persistent field */
    private Set chidentiriesgo;

    /** nullable persistent field */
    private Set chpediexamens;

    /** persistent field */
    private Set chantecetemps;

    /** persistent field */
    private Set chformulameds;
    
    /** presistent field */
    private Set Chformulahos;

    /** persistent field */
    private Set chexameparacs;

    /** persistent field */
    private Set chnotamedicas;

    /** persistent field */
    private Set chantecegenes;

    /** persistent field */
    private Set<Chexameimage> chexameimages;

    /** persistent field */
    private Set<Chexamelabor> chexamelabors;

    /** persistent field */
    private Set<Chexameelect> chexameelects;

    private Set<Chremision> chremisions;

    private Set<Chresersangr> chresersangrs;

    private Set<Chremihospit> chremihospits;
    
    private Set<Chrevissiste> chrevissiste; 
    
    

    

    /** persistent field */
    private Set<Chcertmedico> chcertmedicos;


    /** persistent field */
    private Set chinfomamogrs;

    /** persistent field */
    private Set chingresoenf;

    
    //Consulta Psicologia
     /** persistent field */
    private Set chantecpsico;
    
    /** persistent field */
    private Set chevalugener; 
    
    /** persistent field */
    private Set chpladetrat; 
    
    /** persistent field */
    private Set<Chcervaaplic> chcervaaplic; 
    
    /** persistent field */
    private Set<Chmedicament> chmedicament; 
    
     /** persistent field */
     private Set<Chcuestester> chcuestester; 
     
    /** persistent field */
     private Set<Chestermascu> chestermascu; 
     
    /** persistent field */
     private Set<Chcontrolcon> chcontrolcon; 
     
    /** persistent field */ 
    private Set<Chproceconsu> chproceconsu; 
    
    /** persistent field */ 
    private Set<Chestadpsico> chestadpsico; 

    /** persistent field */ 
    private Set <Chremisilve> chremisilve; 
    
    /** persistent field */ 
    private Set <Chdispoaplic> chdispoaplic; 
    
    /** persistent field */
    private Set<Chantecprena> chantecprena; 
    
    /** persistent field */
    private Set<Chanteceobst> chanteceobst;
    
    /** persistent field */
    private Set<Chgestacion> chgestacion;
    
    /** persistent field */
    private Set<Chcontrolpre>  chcontrolpre;    
    
    /** persistent field */
    private Set<Chtamizalapr> chtamizalapr;
    
    
    /** persistent field */
    private Set<Chcancecervi> chcancecervi;
    
    
    /** persistent field */
    private Set<Chvalorprean> chvalorprean;
    
    /** persistent field */
    private Set<Chcuestanest> chcuestanest;
    
    /** persistent field */
    private Set<Chexafisane> chexafisane;
    
    
    /** persistent field */
    private Set<Chresulparac> chresulparac;
    
    
    /** persistent field */
    private Set<Chregisexame> chregisexame;
    
    
    /** persistent field */
    private Set<Chvacunacion> chvacunacion;
    
    /** persistent field */
    private Set<Chevoluconsu> chevoluconsu;
    
    /** nullable persistent field */
    private Set<Chcontrvasec> chcontrvasec;

    /** nullable persistent field */
    private Set<Chespervasec> chespervasec;
    
    private String nombreServicio;
    
    private String hcoccieringr;
    
    private Long hconprocasoc;
    
    /** nullable persistent field */
    private Set<Chantecolpo> chantecolpo;
    
    /** nullable persistent field */
    private Set<Chantecolpo> chcolposcopia;
    
    /** nullable persistent field */
    private Set<Chvalorabiopsi> chvalorabiopsi;
    
    /** nullable persistent field */
    private Set<Chasesoriaive> chasesoriaive;
    
    /** nullable persistent field */
    private Set<Chantecdetal> chantecdetal;
    
    private Long hconproasoret;

    /** nullable persistent field */
    private Set<Chpsicoantec> chpsicoantec;
    
    /** nullable persistent field */
    private Set<Chregcomenf> chregcomenf;
    
    /** nullable persistent field */
    private Set<Chinfopsico> chinfopsico;
    
    /** nullable persistent field */
    private Set<Chescvalcai> chescvalcai;
    
    /** nullable persistent field */
    private Set<Chfertecog> chfertecog;
    
    /** nullable persistent field */
    private Set<Chfertdato> chfertdato;
    
    /** persistent field */
    private String hlicmotiimpr;
    
    /** persistent field */
    private String hlicmotivoeps;
    
    /** persistent field */
    private String hlicmotivootro;
    
    private boolean renderMotivoEPS;
    
    private boolean renderMotivoOtro;
    
    private String hcocreaconinf;
    
    private String hcoccuacondil;
    
    private String hcocautusodat;
    
    /** nullable persistent field */
    private Set<Chrefepaci> chrefepaci;
    
    /** presistent field */
    private Set Chpapsicologico;
    
    /** presistent field */
    private Set Chpruecovidanticu;
    
    /** presistent field */
    private Set Chpruecovidantige;
    
    private String hcocurlsurvey;
    /** presistent field */
    private Cptipodocu hcontipdoc;
    /** presistent field */
    private BigDecimal hconnumdoc;
    
    /** nullable persistent field */
    private Set<Chconinfxcon> chconinfxcon;
    /** nullable persistent field */
    private Set<Chantox> chantox;
    /** nullable persistent field */
    private Set<Chantfami> chantfami;
    /** nullable persistent field */
    private Set<Chanttrans> chanttrans;
    /** nullable persistent field */
    private Set<Chantalerg> chantalerg;
    /** nullable persistent field */
    private Set<Chanttrauma> chanttrauma;
    /** nullable persistent field */
    private Set<Chantfarma> chantfarma;
    /** nullable persistent field */
    private Set<Chantit> chantit;
    /** nullable persistent field */
    private Set<Chantpatol> chantpatol;
    /** nullable persistent field */
    private Set<Chantquir> chantquir;
    
    
    


    /** default constructor */
    public Chconsulta() {
    }

    /**
     * @param hcocentidadadm
     */
    public void setHcocentidadadm(String hcocentidadadm) {
        this.hcocentidadadm = hcocentidadadm;
    }

    /**
     * @return
     */
    public String getHcocentidadadm() {
        return hcocentidadadm;
    }

    /**
     * @param hcolusuario
     */
    public void setHcolusuario(Chusuario hcolusuario) {
        this.hcolusuario = hcolusuario;
    }

    /**
     * @return
     */
    public Chusuario getHcolusuario() {
        return hcolusuario;
    }

    /**
     * @param hconfolio
     */
    public void setHconfolio(Integer hconfolio) {
        this.hconfolio = hconfolio;
    }

    /**
     * @return
     */
    public Integer getHconfolio() {
        return hconfolio;
    }

    /**
     * @param hcocservicio
     */
    public void setHcocservicio(Cpservicio hcocservicio) {
        this.hcocservicio = hcocservicio;
    }

    /**
     * @return
     */
    public Cpservicio getHcocservicio() {
        return hcocservicio;
    }

    /**
     * @param hcontipoconsu
     */
    public void setHcontipoconsu(Integer hcontipoconsu) {
        this.hcontipoconsu = hcontipoconsu;
    }

    /**
     * @return
     */
    public Integer getHcontipoconsu() {
        return hcontipoconsu;
    }

    /**
     * @param hcodfeccierre
     */
    public void setHcodfeccierre(Date hcodfeccierre) {
        this.hcodfeccierre = hcodfeccierre;
    }

    /**
     * @return
     */
    public Date getHcodfeccierre() {
        return hcodfeccierre;
    }

    /**
     * @param hcoeetapa
     */
    public void setHcoeetapa(String hcoeetapa) {
        this.hcoeetapa = hcoeetapa;
    }

    /**
     * @return
     */
    public String getHcoeetapa() {
        return hcoeetapa;
    }

    /**
     * @param hcocnombacompa
     */
    public void setHcocnombacompa(String hcocnombacompa) {
        this.hcocnombacompa = hcocnombacompa;
    }

    /**
     * @return
     */
    public String getHcocnombacompa() {
        return hcocnombacompa;
    }

    /**
     * @param hcocteleacompa
     */
    public void setHcocteleacompa(String hcocteleacompa) {
        this.hcocteleacompa = hcocteleacompa;
    }

    /**
     * @return
     */
    public String getHcocteleacompa() {
        return hcocteleacompa;
    }

    /**
     * @param hcocnombrespo
     */
    public void setHcocnombrespo(String hcocnombrespo) {
        this.hcocnombrespo = hcocnombrespo;
    }

    /**
     * @return
     */
    public String getHcocnombrespo() {
        return hcocnombrespo;
    }

    /**
     * @param hcoctelerespo
     */
    public void setHcoctelerespo(String hcoctelerespo) {
        this.hcoctelerespo = hcoctelerespo;
    }

    /**
     * @return
     */
    public String getHcoctelerespo() {
        return hcoctelerespo;
    }

    /**
     * @param hcocoperador
     */
    public void setHcocoperador(String hcocoperador) {
        this.hcocoperador = hcocoperador;
    }

    /**
     * @return
     */
    public String getHcocoperador() {
        return hcocoperador;
    }

    /**
     * @param hcodfecregistr
     */
    public void setHcodfecregistr(Date hcodfecregistr) {
        this.hcodfecregistr = hcodfecregistr;
    }

    /**
     * @return
     */
    public Date getHcodfecregistr() {
        return hcodfecregistr;
    }

    /**
     * @param hconclinica
     */
    public void setHconclinica(Integer hconclinica) {
        this.hconclinica = hconclinica;
    }

    /**
     * @return
     */
    public Integer getHconclinica() {
        return hconclinica;
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
     * @param chimprdiags
     */
    public void setChimprdiags(Set chimprdiags) {
        this.chimprdiags = chimprdiags;
    }

    /**
     * @return
     */
    public Set getChimprdiags() {
        return chimprdiags;
    }

    /**
     * @param chriesgomamas
     */
    public void setChriesgomamas(Set chriesgomamas) {
        this.chriesgomamas = chriesgomamas;
    }

    /**
     * @return
     */
    public Set getChriesgomamas() {
        return chriesgomamas;
    }

    /**
     * @param chmotivocons
     */
    public void setChmotivocons(Set chmotivocons) {
        this.chmotivocons = chmotivocons;
    }

    /**
     * @return
     */
    public Set getChmotivocons() {
        return chmotivocons;
    }

    /**
     * @param chconductas
     */
    public void setChconductas(Set chconductas) {
        this.chconductas = chconductas;
    }

    /**
     * @return
     */
    public Set getChconductas() {
        return chconductas;
    }

    /**
     * @param chreferencias
     */
    public void setChreferencias(Set chreferencias) {
        this.chreferencias = chreferencias;
    }

    /**
     * @return
     */
    public Set getChreferencias() {
        return chreferencias;
    }

    /**
     * @param chexafismamas
     */
    public void setChexafismamas(Set chexafismamas) {
        this.chexafismamas = chexafismamas;
    }

    /**
     * @return
     */
    public Set getChexafismamas() {
        return chexafismamas;
    }

    /**
     * @param chexamfisicos
     */
    public void setChexamfisicos(Set chexamfisicos) {
        this.chexamfisicos = chexamfisicos;
    }

    /**
     * @return
     */
    public Set getChexamfisicos() {
        return chexamfisicos;
    }

    /**
     * @param chanatopatols
     */
    public void setChanatopatols(Set chanatopatols) {
        this.chanatopatols = chanatopatols;
    }

    /**
     * @return
     */
    public Set getChanatopatols() {
        return chanatopatols;
    }

    /**
     * @param chanteginecos
     */
    public void setChanteginecos(Set chanteginecos) {
        this.chanteginecos = chanteginecos;
    }

    /**
     * @return
     */
    public Set getChanteginecos() {
        return chanteginecos;
    }

    /**
     * @param chordecirugis
     */
    public void setChordecirugis(Set chordecirugis) {
        this.chordecirugis = chordecirugis;
    }

    /**
     * @return
     */
    public Set getChordecirugis() {
        return chordecirugis;
    }

    /**
     * @param chcuestplanis
     */
    public void setChcuestplanis(Set chcuestplanis) {
        this.chcuestplanis = chcuestplanis;
    }

    /**
     * @return
     */
    public Set getChcuestplanis() {
        return chcuestplanis;
    }

    /**
     * @param chantecemamas
     */
    public void setChantecemamas(Set chantecemamas) {
        this.chantecemamas = chantecemamas;
    }

    /**
     * @return
     */
    public Set getChantecemamas() {
        return chantecemamas;
    }

    /**
     * @param chincapacidas
     */
    public void setChincapacidas(Set chincapacidas) {
        this.chincapacidas = chincapacidas;
    }

    /**
     * @return
     */
    public Set getChincapacidas() {
        return chincapacidas;
    }

    /**
     * @param chexamediagns
     */
    public void setChexamediagns(Set chexamediagns) {
        this.chexamediagns = chexamediagns;
    }

    /**
     * @return
     */
    public Set getChexamediagns() {
        return chexamediagns;
    }

    /**
     * @param chviolencias
     */
    public void setChviolencias(Set chviolencias) {
        this.chviolencias = chviolencias;
    }

    /**
     * @return
     */
    public Set getChviolencias() {
        return chviolencias;
    }

    /**
     * @param chpediexamens
     */
    public void setChpediexamens(Set chpediexamens) {
        this.chpediexamens = chpediexamens;
    }

    /**
     * @return
     */
    public Set getChpediexamens() {
        return chpediexamens;
    }

    /**
     * @param chantecetemps
     */
    public void setChantecetemps(Set chantecetemps) {
        this.chantecetemps = chantecetemps;
    }

    /**
     * @return
     */
    public Set getChantecetemps() {
        return chantecetemps;
    }

    /**
     * @param chformulameds
     */
    public void setChformulameds(Set chformulameds) {
        this.chformulameds = chformulameds;
    }

    /**
     * @return
     */
    public Set getChformulameds() {
        return chformulameds;
    }
    
   

    /**
     * @param chexameparacs
     */
    public void setChexameparacs(Set chexameparacs) {
        this.chexameparacs = chexameparacs;
    }

    /**
     * @return
     */
    public Set getChexameparacs() {
        return chexameparacs;
    }

    /**
     * @param chnotamedicas
     */
    public void setChnotamedicas(Set chnotamedicas) {
        this.chnotamedicas = chnotamedicas;
    }

    /**
     * @return
     */
    public Set getChnotamedicas() {
        return chnotamedicas;
    }

    /**
     * @param chantecegenes
     */
    public void setChantecegenes(Set chantecegenes) {
        this.chantecegenes = chantecegenes;
    }

    /**
     * @return
     */
    public Set getChantecegenes() {
        return chantecegenes;
    }


    /**
     * @param chexamelabors
     */
    public void setChexamelabors(Set<Chexamelabor> chexamelabors) {
        this.chexamelabors = chexamelabors;
    }

    /**
     * @return
     */
    public Set<Chexamelabor> getChexamelabors() {
        return chexamelabors;
    }

    /**
     * @param chexameelects
     */
    public void setChexameelects(Set<Chexameelect> chexameelects) {
        this.chexameelects = chexameelects;
    }

    /**
     * @return
     */
    public Set<Chexameelect> getChexameelects() {
        return chexameelects;
    }

    /**
     * @param chremisions
     */
    public void setChremisions(Set<Chremision> chremisions) {
        this.chremisions = chremisions;
    }

    /**
     * @return
     */
    public Set<Chremision> getChremisions() {
        return chremisions;
    }

  

  
  

   


    /**
     * @param chcertmedicos
     */
    public void setChcertmedicos(Set<Chcertmedico> chcertmedicos) {
        this.chcertmedicos = chcertmedicos;
    }

    /**
     * @return
     */
    public Set<Chcertmedico> getChcertmedicos() {
        return chcertmedicos;
    }

    /**
     * @param chinfomamogrs
     */
    public void setChinfomamogrs(Set chinfomamogrs) {
        this.chinfomamogrs = chinfomamogrs;
    }

    /**
     * @return
     */
    public Set getChinfomamogrs() {
        return chinfomamogrs;
    }

    /**
     * @param chingresoenf
     */
    public void setChingresoenf(Set chingresoenf) {
        this.chingresoenf = chingresoenf;
    }

    /**
     * @return
     */
    public Set getChingresoenf() {
        return chingresoenf;
    }

 

    /**
     * @param chexameimages
     */
    public void setChexameimages(Set<Chexameimage> chexameimages) {
        this.chexameimages = chexameimages;
    }

    /**
     * @return
     */
    public Set<Chexameimage> getChexameimages() {
        return chexameimages;
    }

    /**
     * @param chresersangrs
     */
    public void setChresersangrs(Set<Chresersangr> chresersangrs) {
        this.chresersangrs = chresersangrs;
    }

    /**
     * @return
     */
    public Set<Chresersangr> getChresersangrs() {
        return chresersangrs;
    }

    /**
     * @param chremihospits
     */
    public void setChremihospits(Set<Chremihospit> chremihospits) {
        this.chremihospits = chremihospits;
    }

    /**
     * @return
     */
    public Set<Chremihospit> getChremihospits() {
        return chremihospits;
    }

    /**
     * @param chantecpsico
     */
    public void setChantecpsico(Set chantecpsico) {
        this.chantecpsico = chantecpsico;
    }

    /**
     * @return
     */
    public Set getChantecpsico() {
        return chantecpsico;
    }

    /**
     * @param chevalugener
     */
    public void setChevalugener(Set chevalugener) {
        this.chevalugener = chevalugener;
    }

    /**
     * @return
     */
    public Set getChevalugener() {
        return chevalugener;
    }

    /**
     * @param chpladetrat
     */
    public void setChpladetrat(Set chpladetrat) {
        this.chpladetrat = chpladetrat;
    }

    /**
     * @return
     */
    public Set getChpladetrat() {
        return chpladetrat;
    }


    /**
     * @param chcervaaplic
     */
    public void setChcervaaplic(Set<Chcervaaplic> chcervaaplic) {
        this.chcervaaplic = chcervaaplic;
    }

    /**
     * @return
     */
    public Set<Chcervaaplic> getChcervaaplic() {
        return chcervaaplic;
    }

    /**
     * @param chcuestester
     */
    public void setChcuestester(Set<Chcuestester> chcuestester) {
        this.chcuestester = chcuestester;
    }

    /**
     * @return
     */
    public Set<Chcuestester> getChcuestester() {
        return chcuestester;
    }

    /**
     * @param chestermascu
     */
    public void setChestermascu(Set<Chestermascu> chestermascu) {
        this.chestermascu = chestermascu;
    }

    /**
     * @return
     */
    public Set<Chestermascu> getChestermascu() {
        return chestermascu;
    }

    /**
     * @param chcontrolcon
     */
    public void setChcontrolcon(Set<Chcontrolcon> chcontrolcon) {
        this.chcontrolcon = chcontrolcon;
    }

    /**
     * @return
     */
    public Set<Chcontrolcon> getChcontrolcon() {
        return chcontrolcon;
    }

    /**
     * @param chproceconsu
     */
    public void setChproceconsu(Set<Chproceconsu> chproceconsu) {
        this.chproceconsu = chproceconsu;
    }

    /**
     * @return
     */
    public Set<Chproceconsu> getChproceconsu() {
        return chproceconsu;
    }

    /**
     * @param chestadpsico
     */
    public void setChestadpsico(Set<Chestadpsico> chestadpsico) {
        this.chestadpsico = chestadpsico;
    }

    /**
     * @return
     */
    public Set<Chestadpsico> getChestadpsico() {
        return chestadpsico;
    }

    /**
     * @param chremisilve
     */
    public void setChremisilve(Set<Chremisilve> chremisilve) {
        this.chremisilve = chremisilve;
    }

    /**
     * @return
     */
    public Set<Chremisilve> getChremisilve() {
        return chremisilve;
    }

    /**
     * @param chdispoaplic
     */
    public void setChdispoaplic(Set<Chdispoaplic> chdispoaplic) {
        this.chdispoaplic = chdispoaplic;
    }

    /**
     * @return
     */
    public Set<Chdispoaplic> getChdispoaplic() {
        return chdispoaplic;
    }

    /**
     * @param chantecprena
     */
    public void setChantecprena(Set<Chantecprena> chantecprena) {
        this.chantecprena = chantecprena;
    }

    /**
     * @return
     */
    public Set<Chantecprena> getChantecprena() {
        return chantecprena;
    }

    /**
     * @param chanteceobst
     */
    public void setChanteceobst(Set<Chanteceobst> chanteceobst) {
        this.chanteceobst = chanteceobst;
    }

    /**
     * @return
     */
    public Set<Chanteceobst> getChanteceobst() {
        return chanteceobst;
    }

    /**
     * @param chgestacion
     */
    public void setChgestacion(Set<Chgestacion> chgestacion) {
        this.chgestacion = chgestacion;
    }

    /**
     * @return
     */
    public Set<Chgestacion> getChgestacion() {
        return chgestacion;
    }

    /**
     * @param chcontrolpre
     */
    public void setChcontrolpre(Set<Chcontrolpre> chcontrolpre) {
        this.chcontrolpre = chcontrolpre;
    }

    /**
     * @return
     */
    public Set<Chcontrolpre> getChcontrolpre() {
        return chcontrolpre;
    }

    /**
     * @param chtamizalapr
     */
    public void setChtamizalapr(Set<Chtamizalapr> chtamizalapr) {
        this.chtamizalapr = chtamizalapr;
    }

    /**
     * @return
     */
    public Set<Chtamizalapr> getChtamizalapr() {
        return chtamizalapr;
    }

    /**
     * @param hcolconsuclini
     */
    public void setHcolconsuclini(Long hcolconsuclini) {
        this.hcolconsuclini = hcolconsuclini;
    }

    /**
     * @return
     */
    public Long getHcolconsuclini() {
        return hcolconsuclini;
    }

    /**
     * @param hcolnumero
     */
    public void setHcolnumero(Long hcolnumero) {
        this.hcolnumero = hcolnumero;
    }

    /**
     * @return
     */
    public Long getHcolnumero() {
        return hcolnumero;
    }

    /**
     * @param hcoctiposervi
     */
    public void setHcoctiposervi(String hcoctiposervi) {
        this.hcoctiposervi = hcoctiposervi;
    }

    /**
     * @return
     */
    public String getHcoctiposervi() {
        return hcoctiposervi;
    }

    /**
     * @param chcancecervi
     */
    public void setChcancecervi(Set<Chcancecervi> chcancecervi) {
        this.chcancecervi = chcancecervi;
    }

    /**
     * @return
     */
    public Set<Chcancecervi> getChcancecervi() {
        return chcancecervi;
    }

    /**
     * @param hcodfecinicio
     */
    public void setHcodfecinicio(Date hcodfecinicio) {
        this.hcodfecinicio = hcodfecinicio;
    }

    /**
     * @return
     */
    public Date getHcodfecinicio() {
        return hcodfecinicio;
    }

    /**
     * @param chvalorprean
     */
    public void setChvalorprean(Set<Chvalorprean> chvalorprean) {
        this.chvalorprean = chvalorprean;
    }

    /**
     * @return
     */
    public Set<Chvalorprean> getChvalorprean() {
        return chvalorprean;
    }

  
    /**
     * @param chexafisane
     */
    public void setChexafisane(Set<Chexafisane> chexafisane) {
        this.chexafisane = chexafisane;
    }

    /**
     * @return
     */
    public Set<Chexafisane> getChexafisane() {
        return chexafisane;
    }

    /**
     * @param chresulparac
     */
    public void setChresulparac(Set<Chresulparac> chresulparac) {
        this.chresulparac = chresulparac;
    }

    /**
     * @return
     */
    public Set<Chresulparac> getChresulparac() {
        return chresulparac;
    }

    /**
     * @param chcuestanest
     */
    public void setChcuestanest(Set<Chcuestanest> chcuestanest) {
        this.chcuestanest = chcuestanest;
    }

    /**
     * @return
     */
    public Set<Chcuestanest> getChcuestanest() {
        return chcuestanest;
    }

    /**
     * @param chregisexame
     */
    public void setChregisexame(Set<Chregisexame> chregisexame) {
        this.chregisexame = chregisexame;
    }

    /**
     * @return
     */
    public Set<Chregisexame> getChregisexame() {
        return chregisexame;
    }

    /**
     * @param chrevissiste
     */
    public void setChrevissiste(Set<Chrevissiste> chrevissiste) {
        this.chrevissiste = chrevissiste;
    }

    /**
     * @return
     */
    public Set<Chrevissiste> getChrevissiste() {
        return chrevissiste;
    }

    public void setChcontrvasec(Set<Chcontrvasec> chcontrvasec) {
        this.chcontrvasec = chcontrvasec;
    }

    public Set<Chcontrvasec> getChcontrvasec() {
        return chcontrvasec;
    }

    public void setChmedicament(Set<Chmedicament> chmedicament) {
        this.chmedicament = chmedicament;
    }

    public Set<Chmedicament> getChmedicament() {
        return chmedicament;
    }

    public void setChvacunacion(Set<Chvacunacion> chvacunacion) {
        this.chvacunacion = chvacunacion;
    }

    public Set<Chvacunacion> getChvacunacion() {
        return chvacunacion;
    }

    public void setChformulahos(Set chformulahos) {
        this.Chformulahos = chformulahos;
    }

    public Set getChformulahos() {
        return Chformulahos;
    }

    public void setChevoluconsu(Set<Chevoluconsu> chevoluconsu) {
        this.chevoluconsu = chevoluconsu;
    }

    public Set<Chevoluconsu> getChevoluconsu() {
        return chevoluconsu;
    }

    public void setChidentiriesgo(Set chidentiriesgo) {
        this.chidentiriesgo = chidentiriesgo;
    }

    public Set getChidentiriesgo() {
        return chidentiriesgo;
    }
    
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setHconcodagen(Long hconcodagen) {
        this.hconcodagen = hconcodagen;
    }

    public Long getHconcodagen() {
        return hconcodagen;
    }

    public void setHcoccieringr(String hcoccieringr) {
        this.hcoccieringr = hcoccieringr;
    }

    public String getHcoccieringr() {
        return hcoccieringr;
    }

    public void setChantecvasec(Set<Chantecvasec> chantecvasec) {
        this.chantecvasec = chantecvasec;
    }

    public Set<Chantecvasec> getChantecvasec() {
        return chantecvasec;
    }

    public void setHconprocasoc(Long hconprocasoc) {
        this.hconprocasoc = hconprocasoc;
    }

    public Long getHconprocasoc() {
        return hconprocasoc;
    }

    
    public void setChespervasec(Set<Chespervasec> chespervasec) {
        this.chespervasec = chespervasec;
    }

    public Set<Chespervasec> getChespervasec() {
        return chespervasec;
    }


    public void setChantecolpo(Set<Chantecolpo> chantecolpo) {
        this.chantecolpo = chantecolpo;
    }

    public Set<Chantecolpo> getChantecolpo() {
        return chantecolpo;
    }

    public void setChcolposcopia(Set<Chantecolpo> chcolposcopia) {
        this.chcolposcopia = chcolposcopia;
    }

    public Set<Chantecolpo> getChcolposcopia() {
        return chcolposcopia;
    }

    public void setChvalorabiopsi(Set<Chvalorabiopsi> chvalorabiopsi) {
        this.chvalorabiopsi = chvalorabiopsi;
    }

    public Set<Chvalorabiopsi> getChvalorabiopsi() {
        return chvalorabiopsi;
    }

    public void setChasesoriaive(Set<Chasesoriaive> chasesoriaive) {
        this.chasesoriaive = chasesoriaive;
    }

    public Set<Chasesoriaive> getChasesoriaive() {
        return chasesoriaive;
    }

    public void setChantecdetal(Set<Chantecdetal> chantecdetal) {
        this.chantecdetal = chantecdetal;
    }

    public Set<Chantecdetal> getChantecdetal() {
        return chantecdetal;
    }

    public void setHconproasoret(Long hconproasoret) {
        this.hconproasoret = hconproasoret;
    }

    public Long getHconproasoret() {
        return hconproasoret;
    }

    public void setChpsicoantec(Set<Chpsicoantec> chpsicoantec) {
        this.chpsicoantec = chpsicoantec;
    }

    public Set<Chpsicoantec> getChpsicoantec() {
        return chpsicoantec;
    }

    public void setChregcomenf(Set<Chregcomenf> chregcomenf) {
        this.chregcomenf = chregcomenf;
    }

    public Set<Chregcomenf> getChregcomenf() {
        return chregcomenf;
    }

    public void setChinfopsico(Set<Chinfopsico> chinfopsico) {
        this.chinfopsico = chinfopsico;
    }

    public Set<Chinfopsico> getChinfopsico() {
        return chinfopsico;
    }

    public void setChescvalcai(Set<Chescvalcai> chescvalcai) {
        this.chescvalcai = chescvalcai;
    }

    public Set<Chescvalcai> getChescvalcai() {
        return chescvalcai;
    }


    public void setChfertecog(Set<Chfertecog> chfertecog) {
        this.chfertecog = chfertecog;
    }

    public Set<Chfertecog> getChfertecog() {
        return chfertecog;
    }


    public void setChfertdato(Set<Chfertdato> chfertdato) {
        this.chfertdato = chfertdato;
    }

    public Set<Chfertdato> getChfertdato() {
        return chfertdato;
    }

    public void setHlicmotiimpr(String hlicmotiimpr) {
        this.hlicmotiimpr = hlicmotiimpr;
    }

    public String getHlicmotiimpr() {
        return hlicmotiimpr;
    }

    public void setHlicmotivoeps(String hlicmotivoeps) {
        this.hlicmotivoeps = hlicmotivoeps;
    }

    public String getHlicmotivoeps() {
        return hlicmotivoeps;
    }

    public void setHlicmotivootro(String hlicmotivootro) {
        this.hlicmotivootro = hlicmotivootro;
    }

    public String getHlicmotivootro() {
        return hlicmotivootro;
    }

    public void setRenderMotivoEPS(boolean renderMotivoEPS) {
        this.renderMotivoEPS = renderMotivoEPS;
    }

    public boolean isRenderMotivoEPS() {
        return renderMotivoEPS;
    }

    public void setRenderMotivoOtro(boolean renderMotivoOtro) {
        this.renderMotivoOtro = renderMotivoOtro;
    }

    public boolean isRenderMotivoOtro() {
        return renderMotivoOtro;
    }

    public void setHcocreaconinf(String hcocreaconinf) {
        this.hcocreaconinf = hcocreaconinf;
    }

    public String getHcocreaconinf() {
        return hcocreaconinf;
    }

    public void setHcoccuacondil(String hcoccuacondil) {
        this.hcoccuacondil = hcoccuacondil;
    }

    public String getHcoccuacondil() {
        return hcoccuacondil;
    }

    public void setHcocautusodat(String hcocautusodat) {
        this.hcocautusodat = hcocautusodat;
    }

    public String getHcocautusodat() {
        return hcocautusodat;
    }

    public void setChrefepaci(Set<Chrefepaci> chrefepaci) {
        this.chrefepaci = chrefepaci;
    }

    public Set<Chrefepaci> getChrefepaci() {
        return chrefepaci;
    }


    public void setChpapsicologico(Set chpapsicologico) {
        this.Chpapsicologico = chpapsicologico;
    }

    public Set getChpapsicologico() {
        return Chpapsicologico;
    }

    public void setChpruecovidanticu(Set chpruecovidanticu) {
        this.Chpruecovidanticu = chpruecovidanticu;
    }

    public Set getChpruecovidanticu() {
        return Chpruecovidanticu;
    }

    public void setChpruecovidantige(Set chpruecovidantige) {
        this.Chpruecovidantige = chpruecovidantige;
    }

    public Set getChpruecovidantige() {
        return Chpruecovidantige;
    }

    public void setHcocurlsurvey(String hcocurlsurvey) {
        this.hcocurlsurvey = hcocurlsurvey;
    }

    public String getHcocurlsurvey() {
        return hcocurlsurvey;
    }
    public void setHconnumdoc(BigDecimal hconnumdoc) {
        this.hconnumdoc = hconnumdoc;
    }

    public BigDecimal getHconnumdoc() {
        return hconnumdoc;
    }

    public void setHcontipdoc(Cptipodocu hcontipdoc) {
        this.hcontipdoc = hcontipdoc;
    }

    public Cptipodocu getHcontipdoc() {
        return hcontipdoc;
    }

    public void setChconinfxcon(Set<Chconinfxcon> chconinfxcon) {
        this.chconinfxcon = chconinfxcon;
    }

    public Set<Chconinfxcon> getChconinfxcon() {
        return chconinfxcon;
    }

    public void setChantox(Set<Chantox> chantox) {
        this.chantox = chantox;
    }

    public Set<Chantox> getChantox() {
        return chantox;
    }

    public void setChantfami(Set<Chantfami> chantfami) {
        this.chantfami = chantfami;
    }

    public Set<Chantfami> getChantfami() {
        return chantfami;
    }

    public void setChanttrans(Set<Chanttrans> chanttrans) {
        this.chanttrans = chanttrans;
    }

    public Set<Chanttrans> getChanttrans() {
        return chanttrans;
    }

    public void setChantalerg(Set<Chantalerg> chantalerg) {
        this.chantalerg = chantalerg;
    }

    public Set<Chantalerg> getChantalerg() {
        return chantalerg;
    }

    public void setChanttrauma(Set<Chanttrauma> chanttrauma) {
        this.chanttrauma = chanttrauma;
    }

    public Set<Chanttrauma> getChanttrauma() {
        return chanttrauma;
    }

    public void setChantfarma(Set<Chantfarma> chantfarma) {
        this.chantfarma = chantfarma;
    }

    public Set<Chantfarma> getChantfarma() {
        return chantfarma;
    }

    public void setChantit(Set<Chantit> chantit) {
        this.chantit = chantit;
    }

    public Set<Chantit> getChantit() {
        return chantit;
    }

    public void setChantpatol(Set<Chantpatol> chantpatol) {
        this.chantpatol = chantpatol;
    }

    public Set<Chantpatol> getChantpatol() {
        return chantpatol;
    }

    public void setChantquir(Set<Chantquir> chantquir) {
        this.chantquir = chantquir;
    }

    public Set<Chantquir> getChantquir() {
        return chantquir;
    }
}
