package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chmotivocon implements Serializable {

    /** identifier field */
    private ChmotivoconPK id;

    /** */
    
    /** nullable persistent field */
    private Integer hmcncausaexte;

    /** nullable persistent field */
    private Integer hmcnfinalidad;

    /** nullable persistent field */
    private String hmctenferactal;

    /** nullable persistent field */
    private String hmctdescripcio;

    /** nullable persistent field */
    private Date hmcdfecregistr;

    /** nullable persistent field */
    private String hmccoperador;

    /** nullable persistent field */
    private String hmceofreasesor;

    /** nullable persistent field */
    private String hmcereciasesor;

    /** nullable persistent field */
    private String hmccrevisistem;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String hmccgrupsangre;

    /** nullable persistent field */
    private String hmccfactosangre;

    /** nullable persistent field */
    private String hmccecografia;
    
    /** nullable persistent field */
    private String hmcctipoconta;
    
    /** nullable persistent field */
    private String hmcccualconta;
    
    /** nullable persistent field */
    private String hmccefecsecun;
    
    /** nullable persistent field */
    private Integer hmcnescadolor;
    
    /** nullable persistent field */
    private Integer hmcnduradolor;
    
    /** nullable persistent field */
    private String hmccconsumedi;
    
    /** nullable persistent field */
    private String hmccpresangro;
    
    /** nullable persistent field */
    private String hmcccantisang;
    
    /** nullable persistent field */
    private Integer hmcndurasangr;
    
    /** nullable persistent field */
    private Integer hmcninicisang;
    
    /** nullable persistent field */
    private String hmccpreseexpu;
    
    /** nullable persistent field */
    private String hmccexpultran;
    
    /** nullable persistent field */
    private Integer hmcnprimexpul;
    
    /** nullable persistent field */
    private Integer hmcnsangmayor;
    
    /** nullable persistent field */
    private String hmccoblimedic;
    
    /** nullable persistent field */
    private String hmcctipocontr;
    
    /** nullable persistent field */
    private String hmccrepoecogr;
    
    /** nullable persistent field */
    private BigDecimal hmcngrosendom;
    
    /** nullable persistent field */
    private String hmccdopplerva;
    
    /** nullable persistent field */
    private String hmccdoppcardn;
    
    /** nullable persistent field */
    private String hmcccomplicac;
    
    /** nullable persistent field */
    private String hmcccompmulti;
    
    /** nullable persistent field */
    private String hmccespacanal;
    
    /** nullable persistent field */
    private String hmccespacondu;
    
    /** nullable persistent field */
    private String hmccanticonce;
    
    /** nullable persistent field */
    private String hmccmetoantic;
    
    /** nullable persistent field */
    private String hmcctolemetod;
    
    /** nullable persistent field */
    private String hmccinicimetod;
    
    /** nullable persistent field */
    private String hmccmetodinici;
    
    /** nullable persistent field */ 
    private String hmccotrometo;
    
    /** nullable persistent field */ 
    private String hmccmetodantn;
    
    /** nullable persistent field */
    private String hmccotrometon;
        
    /** nullable persistent field */
    private String hmccsangposte;
    
    /** nullable persistent field */
    private String hmccdudointen;
    
    /** nullable persistent field */
    private String hmcctiemsangro;
    
    /** nullable persistent field */
    private String hmcctiemexpuls;
    
    /** nullable persistent field */
    private String hmcctiemduraci;
    
    
    
    /** nullable persistent field */
    private String hmccmanioprev;
    
    /** nullable persistent field */
    private String hmccmaniofarma;
    
    /** nullable persistent field */
    private String hmccmanioinstru;
        
    /** nullable persistent field */
    private String hmccmaniootro;
    
    /** nullable persistent field */
    private String hmccmaniootrodesc;
    
    /** nullable persistent field */
    private String hmccmanioobser;
    
    
    /** nullable persistent field */
    private String hmccinteractua;
    
    /** nullable persistent field */
    private String hmccinteroprof;
    
    /** nullable persistent field */
    private String hmccinterasegu;
    
    /** nullable persistent field */
    private String hmccinterobser;
    
    /** nullable persistent field */
    private String hmcctiemdusang;
    
    
    /** nullable persistent field */
    private String hmcctipoconps;
    
    private String hmcctipoproce;
    
    /** nullable persistent field */
    private String hmccteleorien;
    
    /** nullable persistent field */
    private String hmccecoobservac;
    
    /** nullable persistent field */
    private String hmccantiobservac;
        
    /** nullable persistent field */
    private String hmccanticual;
    
    /** nullable persistent field */
    private String hmccobsconemb;
    
  
    private String hmcctrapatol;
    
    private String hmcctippatol;
    
    private String hmcccualpat;
    
    private String hmccrespatol;
   
   private String hmccresbiop;
   
   private String hmccdesres;
   
   private Integer hmnclashisto;

   private Integer hmngradtumor;
   
   private Integer hmnencuestaphq9;


 

    
        /** default constructor */
        public Chmotivocon() {
        
            id = new ChmotivoconPK(); 
        }


    /**
     * @param id
     */
    public void setId(ChmotivoconPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChmotivoconPK getId() {
        return id;
    }

    /**
     * @param hmcncausaexte
     */
    public void setHmcncausaexte(Integer hmcncausaexte) {
        this.hmcncausaexte = hmcncausaexte;
    }

    /**
     * @return
     */
    public Integer getHmcncausaexte() {
        return hmcncausaexte;
    }

    /**
     * @param hmcnfinalidad
     */
    public void setHmcnfinalidad(Integer hmcnfinalidad) {
        this.hmcnfinalidad = hmcnfinalidad;
    }

    /**
     * @return
     */
    public Integer getHmcnfinalidad() {
        return hmcnfinalidad;
    }

    /**
     * @param hmctenferactal
     */
    public void setHmctenferactal(String hmctenferactal) {
        this.hmctenferactal = hmctenferactal;
    }

    /**
     * @return
     */
    public String getHmctenferactal() {
        return hmctenferactal;
    }

    /**
     * @param hmctdescripcio
     */
    public void setHmctdescripcio(String hmctdescripcio) {
        this.hmctdescripcio = hmctdescripcio;
    }

    /**
     * @return
     */
    public String getHmctdescripcio() {
        return hmctdescripcio;
    }

    /**
     * @param hmcdfecregistr
     */
    public void setHmcdfecregistr(Date hmcdfecregistr) {
        this.hmcdfecregistr = hmcdfecregistr;
    }

    /**
     * @return
     */
    public Date getHmcdfecregistr() {
        return hmcdfecregistr;
    }

    /**
     * @param hmccoperador
     */
    public void setHmccoperador(String hmccoperador) {
        this.hmccoperador = hmccoperador;
    }

    /**
     * @return
     */
    public String getHmccoperador() {
        return hmccoperador;
    }

    /**
     * @param hmceofreasesor
     */
    public void setHmceofreasesor(String hmceofreasesor) {
        this.hmceofreasesor = hmceofreasesor;
    }

    /**
     * @return
     */
    public String getHmceofreasesor() {
        return hmceofreasesor;
    }

    /**
     * @param hmcereciasesor
     */
    public void setHmcereciasesor(String hmcereciasesor) {
        this.hmcereciasesor = hmcereciasesor;
    }

    /**
     * @return
     */
    public String getHmcereciasesor() {
        return hmcereciasesor;
    }

    /**
     * @param hmccrevisistem
     */
    public void setHmccrevisistem(String hmccrevisistem) {
        this.hmccrevisistem = hmccrevisistem;
    }

    /**
     * @return
     */
    public String getHmccrevisistem() {
        return hmccrevisistem;
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
     * @param hmccgrupsangre
     */
    public void setHmccgrupsangre(String hmccgrupsangre) {
        this.hmccgrupsangre = hmccgrupsangre;
    }

    /**
     * @return
     */
    public String getHmccgrupsangre() {
        return hmccgrupsangre;
    }

    /**
     * @param hmccfactosangre
     */
    public void setHmccfactosangre(String hmccfactosangre) {
        this.hmccfactosangre = hmccfactosangre;
    }

    /**
     * @return
     */
    public String getHmccfactosangre() {
        return hmccfactosangre;
    }

    /**
     * @param hmccecografia
     */
    public void setHmccecografia(String hmccecografia) {
        this.hmccecografia = hmccecografia;
    }

    /**
     * @return
     */
    public String getHmccecografia() {
        return hmccecografia;
    }

    /**
     * @param hmcctipoconta
     */
    public void setHmcctipoconta(String hmcctipoconta) {
        this.hmcctipoconta = hmcctipoconta;
    }

    /**
     * @return
     */
    public String getHmcctipoconta() {
        return hmcctipoconta;
    }

    /**
     * @param hmcccualconta
     */
    public void setHmcccualconta(String hmcccualconta) {
        this.hmcccualconta = hmcccualconta;
    }

    /**
     * @return
     */
    public String getHmcccualconta() {
        return hmcccualconta;
    }

    /**
     * 
     * @param hmccefecsecun
     */


    public void setHmccefecsecun(String hmccefecsecun) {
        this.hmccefecsecun = hmccefecsecun;
    }

    /**
     * 
     * @return
     */

    public String getHmccefecsecun() {
        return hmccefecsecun;
    }
    
    /**
     * 
     * @param hmcnescadolor
     */
    public void setHmcnescadolor(Integer hmcnescadolor) {
        this.hmcnescadolor = hmcnescadolor;
    }
    
    /**
     * 
     * @return
     */
    public Integer getHmcnescadolor() {
        return hmcnescadolor;
    }

    /**
     * 
     * @param hmcnduradolor
     */
    public void setHmcnduradolor(Integer hmcnduradolor) {
        this.hmcnduradolor = hmcnduradolor;
    }
    
    /**
     * 
     * @return
     */
    public Integer getHmcnduradolor() {
        return hmcnduradolor;
    }
    
    /**
     * 
     * @param hmccconsumedi
     */
    public void setHmccconsumedi(String hmccconsumedi) {
        this.hmccconsumedi = hmccconsumedi;
    }
    
    /**
     * 
     * @return
     */
    public String getHmccconsumedi() {
        return hmccconsumedi;
    }
    /**
     * 
     * @param hmccpresangro
     */
    public void setHmccpresangro(String hmccpresangro) {
        this.hmccpresangro = hmccpresangro;
    }
    /**
     * 
     * @return
     */
    public String getHmccpresangro() {
        return hmccpresangro;
    }
    /**
     * 
     * @param hmcccantisang
     */
    public void setHmcccantisang(String hmcccantisang) {
        this.hmcccantisang = hmcccantisang;
    }
    /**
     * 
     * @return
     */
    public String getHmcccantisang() {
        return hmcccantisang;
    }
    /**
     * 
     * @param hmcndurasangr
     */
    public void setHmcndurasangr(Integer hmcndurasangr) {
        this.hmcndurasangr = hmcndurasangr;
    }
    /**
     * 
     * @return
     */
    public Integer getHmcndurasangr() {
        return hmcndurasangr;
    }
    /**
     * 
     * @param hmcninicisang
     */
    public void setHmcninicisang(Integer hmcninicisang) {
        this.hmcninicisang = hmcninicisang;
    }
    /**
     * 
     * @return
     */
    public Integer getHmcninicisang() {
        return hmcninicisang;
    }
    /**
     * 
     * @param hmccpreseexpu
     */
    public void setHmccpreseexpu(String hmccpreseexpu) {
        this.hmccpreseexpu = hmccpreseexpu;
    }
    /**
     * 
     * @return
     */
    public String getHmccpreseexpu() {
        return hmccpreseexpu;
    }
    /**
     * 
     * @param hmccexpultran
     */
    public void setHmccexpultran(String hmccexpultran) {
        this.hmccexpultran = hmccexpultran;
    }
    /**
     * 
     * @return
     */
    public String getHmccexpultran() {
        return hmccexpultran;
    }
    /**
     * 
     * @param hmcnsangmayor
     */
    public void setHmcnsangmayor(Integer hmcnsangmayor) {
        this.hmcnsangmayor = hmcnsangmayor;
    }
    /**
     * 
     * @return
     */
    public Integer getHmcnsangmayor() {
        return hmcnsangmayor;
    }
   /**
     * 
     * @param hmccoblimedic
     */

    public void setHmccoblimedic(String hmccoblimedic) {
        this.hmccoblimedic = hmccoblimedic;
    }
    /**
     * 
     * @return
     */
    public String getHmccoblimedic() {
        return hmccoblimedic;
    }
    /**
     * 
     * @param hmcnprimexpul
     */
    public void setHmcnprimexpul(Integer hmcnprimexpul) {
        this.hmcnprimexpul = hmcnprimexpul;
    }
    /**
     * 
     * @return
     */
    public Integer getHmcnprimexpul() {
        return hmcnprimexpul;
    }
    /**
     * 
     * @param hmcctipocontr
     */
    public void setHmcctipocontr(String hmcctipocontr) {
        this.hmcctipocontr = hmcctipocontr;
    }
    /**
     * 
     * @return
     */
    public String getHmcctipocontr() {
        return hmcctipocontr;
    }

    public void setHmccrepoecogr(String hmccrepoecogr) {
        this.hmccrepoecogr = hmccrepoecogr;
    }

    public String getHmccrepoecogr() {
        return hmccrepoecogr;
    }

    public void setHmcngrosendom(BigDecimal hmcngrosendom) {
        this.hmcngrosendom = hmcngrosendom;
    }

    public BigDecimal getHmcngrosendom() {
        return hmcngrosendom;
    }

    public void setHmccdopplerva(String hmccdopplerva) {
        this.hmccdopplerva = hmccdopplerva;
    }

    public String getHmccdopplerva() {
        return hmccdopplerva;
    }

    public void setHmccdoppcardn(String hmccdoppcardn) {
        this.hmccdoppcardn = hmccdoppcardn;
    }

    public String getHmccdoppcardn() {
        return hmccdoppcardn;
    }

    public void setHmcccomplicac(String hmcccomplicac) {
        this.hmcccomplicac = hmcccomplicac;
    }

    public String getHmcccomplicac() {
        return hmcccomplicac;
    }

    public void setHmcccompmulti(String hmcccompmulti) {
        this.hmcccompmulti = hmcccompmulti;
    }

    public String getHmcccompmulti() {
        return hmcccompmulti;
    }

    public void setHmccespacanal(String hmccespacanal) {
        this.hmccespacanal = hmccespacanal;
    }

    public String getHmccespacanal() {
        return hmccespacanal;
    }

    public void setHmccespacondu(String hmccespacondu) {
        this.hmccespacondu = hmccespacondu;
    }

    public String getHmccespacondu() {
        return hmccespacondu;
    }

    public void setHmccanticonce(String hmccanticonce) {
        this.hmccanticonce = hmccanticonce;
    }

    public String getHmccanticonce() {
        return hmccanticonce;
    }

    public void setHmccmetoantic(String hmccmetoantic) {
        this.hmccmetoantic = hmccmetoantic;
    }

    public String getHmccmetoantic() {
        return hmccmetoantic;
    }

    public void setHmcctolemetod(String hmcctolemetod) {
        this.hmcctolemetod = hmcctolemetod;
    }

    public String getHmcctolemetod() {
        return hmcctolemetod;
    }

    public void setHmccinicimetod(String hmccinicimetod) {
        this.hmccinicimetod = hmccinicimetod;
    }

    public String getHmccinicimetod() {
        return hmccinicimetod;
    }

    public void setHmccmetodinici(String hmccmetodinici) {
        this.hmccmetodinici = hmccmetodinici;
    }

    public String getHmccmetodinici() {
        return hmccmetodinici;
    }

    public void setHmccotrometo(String hmccotrometo) {
        this.hmccotrometo = hmccotrometo;
    }

    public String getHmccotrometo() {
        return hmccotrometo;
    }

    public void setHmccmetodantn(String hmccmetodantn) {
        this.hmccmetodantn = hmccmetodantn;
    }

    public String getHmccmetodantn() {
        return hmccmetodantn;
    }

    public void setHmccotrometon(String hmccotrometon) {
        this.hmccotrometon = hmccotrometon;
    }

    public String getHmccotrometon() {
        return hmccotrometon;
    }

    public void setHmccsangposte(String hmccsangposte) {
        this.hmccsangposte = hmccsangposte;
    }

    public String getHmccsangposte() {
        return hmccsangposte;
    }

    public void setHmccdudointen(String hmccdudointen) {
        this.hmccdudointen = hmccdudointen;
    }

    public String getHmccdudointen() {
        return hmccdudointen;
    }

    public void setHmcctiemsangro(String hmcctiemsangro) {
        this.hmcctiemsangro = hmcctiemsangro;
    }

    public String getHmcctiemsangro() {
        return hmcctiemsangro;
    }

    public void setHmcctiemexpuls(String hmcctiemexpuls) {
        this.hmcctiemexpuls = hmcctiemexpuls;
    }

    public String getHmcctiemexpuls() {
        return hmcctiemexpuls;
    }

    public void setHmcctiemduraci(String hmcctiemduraci) {
        this.hmcctiemduraci = hmcctiemduraci;
    }

    public String getHmcctiemduraci() {
        return hmcctiemduraci;
    }

    public void setHmccmanioprev(String hmccmanioprev) {
        this.hmccmanioprev = hmccmanioprev;
    }

    public String getHmccmanioprev() {
        return hmccmanioprev;
    }

    public void setHmccmaniofarma(String hmccmaniofarma) {
        this.hmccmaniofarma = hmccmaniofarma;
    }

    public String getHmccmaniofarma() {
        return hmccmaniofarma;
    }

    public void setHmccmanioinstru(String hmccmanioinstru) {
        this.hmccmanioinstru = hmccmanioinstru;
    }

    public String getHmccmanioinstru() {
        return hmccmanioinstru;
    }

    public void setHmccmaniootro(String hmccmaniootro) {
        this.hmccmaniootro = hmccmaniootro;
    }

    public String getHmccmaniootro() {
        return hmccmaniootro;
    }

    public void setHmccmaniootrodesc(String hmccmaniootrodesc) {
        this.hmccmaniootrodesc = hmccmaniootrodesc;
    }

    public String getHmccmaniootrodesc() {
        return hmccmaniootrodesc;
    }

    public void setHmccmanioobser(String hmccmanioobser) {
        this.hmccmanioobser = hmccmanioobser;
    }

    public String getHmccmanioobser() {
        return hmccmanioobser;
    }

    public void setHmccinteractua(String hmccinteractua) {
        this.hmccinteractua = hmccinteractua;
    }

    public String getHmccinteractua() {
        return hmccinteractua;
    }

    public void setHmccinteroprof(String hmccinteroprof) {
        this.hmccinteroprof = hmccinteroprof;
    }

    public String getHmccinteroprof() {
        return hmccinteroprof;
    }

    public void setHmccinterasegu(String hmccinterasegu) {
        this.hmccinterasegu = hmccinterasegu;
    }

    public String getHmccinterasegu() {
        return hmccinterasegu;
    }

    public void setHmccinterobser(String hmccinterobser) {
        this.hmccinterobser = hmccinterobser;
    }

    public String getHmccinterobser() {
        return hmccinterobser;
    }


    public void setHmcctiemdusang(String hmcctiemdusang) {
        this.hmcctiemdusang = hmcctiemdusang;
    }

    public String getHmcctiemdusang() {
        return hmcctiemdusang;
    }

    public void setHmcctipoconps(String hmcctipoconps) {
        this.hmcctipoconps = hmcctipoconps;
    }

    public String getHmcctipoconps() {
        return hmcctipoconps;
    }

    public void setHmcctipoproce(String hmcctipoproce) {
        this.hmcctipoproce = hmcctipoproce;
    }

    public String getHmcctipoproce() {
        return hmcctipoproce;
    }

    public void setHmccteleorien(String hmccteleorien) {
        this.hmccteleorien = hmccteleorien;
    }

    public String getHmccteleorien() {
        return hmccteleorien;
    }

    public void setHmccecoobservac(String hmccecoobservac) {
        this.hmccecoobservac = hmccecoobservac;
    }

    public String getHmccecoobservac() {
        return hmccecoobservac;
    }

    public void setHmccantiobservac(String hmccantiobservac) {
        this.hmccantiobservac = hmccantiobservac;
      
    
    }

    public String getHmccantiobservac() {
        return hmccantiobservac;
    }

    public void setHmccanticual(String hmccanticual) {
        this.hmccanticual = hmccanticual;
    }

    public String getHmccanticual() {
        return hmccanticual;
    }

    public void setHmccobsconemb(String hmccobsconemb) {
        this.hmccobsconemb = hmccobsconemb;
    }

    public String getHmccobsconemb() {
        return hmccobsconemb;
    }


    public void setHmcctrapatol(String hmcctrapatol) {
        this.hmcctrapatol = hmcctrapatol;
    }

    public String getHmcctrapatol() {
        return hmcctrapatol;
    }

    public void setHmcctippatol(String hmcctippatol) {
        this.hmcctippatol = hmcctippatol;
    }

    public String getHmcctippatol() {
        return hmcctippatol;
    }

    public void setHmcccualpat(String hmcccualpat) {
        this.hmcccualpat = hmcccualpat;
    }

    public String getHmcccualpat() {
        return hmcccualpat;
    }

    public void setHmccrespatol(String hmccrespatol) {
        this.hmccrespatol = hmccrespatol;
    }

    public String getHmccrespatol() {
        return hmccrespatol;
    }

 

    public void setHmccdesres(String hmccdesres) {
        this.hmccdesres = hmccdesres;
    }

    public String getHmccdesres() {
        return hmccdesres;
    }

    public void setHmccresbiop(String hmccresbiop) {
        this.hmccresbiop = hmccresbiop;
    }

    public String getHmccresbiop() {
        return hmccresbiop;
    }

    public void setHmnclashisto(Integer hmnclashisto) {
        this.hmnclashisto = hmnclashisto;
    }

    public Integer getHmnclashisto() {
        return hmnclashisto;
    }

    public void setHmngradtumor(Integer hmngradtumor) {
        this.hmngradtumor = hmngradtumor;
    }

    public Integer getHmngradtumor() {
        return hmngradtumor;
    }

    public void setHmnencuestaphq9(Integer hmnencuestaphq9) {
        this.hmnencuestaphq9 = hmnencuestaphq9;
    }

    public Integer getHmnencuestaphq9() {
        return hmnencuestaphq9;
    }
}
