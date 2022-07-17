package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;

import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chusuario implements Serializable {

    /** identifier field */
    private Long huslnumero;

    /** persistent field */
    private String husetipoiden;

    /** persistent field */
    private Long husanumeiden;

    /** persistent field */
    private String huscprimernomb;

    /** nullable persistent field */
    private String huscsegundnomb;

    /** persistent field */
    private String huscprimerapel;

    /** nullable persistent field */
    private String huscsegundapel;

    /** nullable persistent field */
    private String huseestadcivil;

    /** nullable persistent field */
    private String husesexo;

    /** nullable persistent field */
    private String huscdireccion;

    /** nullable persistent field */
    private String huscbarrio;

    /** nullable persistent field */
    private String husctelefono;

    /** nullable persistent field */
    private Date husdfechanacim;

    /** nullable persistent field */
    private String husezonareside;

    /** nullable persistent field */
    private Integer husndepartamen;

    /** nullable persistent field */
    private Integer husnciudad;

    /** nullable persistent field */
    private String husetipoafilia;

    /** nullable persistent field */
    private String huscentidadadm;

    /** nullable persistent field */
    private Integer husnocupacion;

    /** nullable persistent field */
    private String huscnomacompana;

    /** nullable persistent field */
    private String husctelacompana;

    /** nullable persistent field */
    private String huscnomresponsa;

    /** nullable persistent field */
    private String husctelresponsa;

    /** nullable persistent field */
    private String huscparresponsa;

    /** nullable persistent field */
    private String husccorreoelec;

    /** nullable persistent field */
    private Integer husnfolioactua;

    /** nullable persistent field */
    private Date husdfecregistr;

    /** nullable persistent field */
    private String huscoperador;

    /** nullable persistent field */
    private String husehistoria;

    /** nullable persistent field */
    private Date husdultimacons;

    /** nullable persistent field */
    private Integer husnestrato;

    /** nullable persistent field */
    private Integer husnniveledu;

    /** nullable persistent field */
    private String huseestado;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String huseautorcont;

    /** nullable persistent field */
    private String huscteloficina;

    /** nullable persistent field */
    private String huseautoficina;

    /** nullable persistent field */
    private String huseautcasa;

    /** nullable persistent field */
    private String husccelular;

    /** nullable persistent field */
    private String huseautcelular;

    /** nullable persistent field */
    private String huseautmensaj;

    /** nullable persistent field */
    private String huseautcorreoe;

    /** Almacena la edad del usuario*/
    private Integer edad;
    
    /** nullable persistent field */
    private String huscetnia;
    
    /** nullable persistent field */
    private String husetipcliente;
        
    /** nullable persistent field */
    private Integer husnconoprofam;
    
    /** nullable persistent field*/
    private String huscnumafiliac;
    
    /** nullable persistent field */
    private String husetipvincula;
    
    /** nullable persistent field */
    private Integer husnnumecontr;
    
    /** nullable persistent field */
    private String husedicapadad;
    
    /** nullable persistent field */
    private String husediscaselec;
    
    /** nullable persistent field */
    private String husccodinaci;
    
    private String huscnombralter; 
    
    private String huscpaisresi;


    /** persistent field */
    private Set chconsultas;
    
    private String husccodsap;
    
    private String huscidengene;
    
    private String huscoriesexu;
    
    private String huscvivesolo; 
    
    private String hcocreaconinf;
    
    private String hcoccuacondil;
    
    private String hcocautusodat;
    
    private Long husnaceppolprv;

    /** full constructor */
    public Chusuario(Long huslnumero, String husetipoiden, Long husanumeiden, 
                     String huscprimernomb, String huscsegundnomb, 
                     String huscprimerapel, String huscsegundapel, 
                     String huseestadcivil, String husesexo, 
                     String huscdireccion, String huscbarrio, 
                     String husctelefono, Date husdfechanacim, 
                     String husezonareside, Integer husndepartamen, 
                     Integer husnciudad, String husetipoafilia, 
                     String huscentidadadm, Integer husnocupacion, 
                     String huscnomacompana, String husctelacompana, 
                     String huscnomresponsa, String husctelresponsa, 
                     String huscparresponsa, String husccorreoelec, 
                     Integer husnfolioactua, Date husdfecregistr, 
                     String huscoperador, String husehistoria, 
                     Date husdultimacons, Integer husnestrato, 
                     Integer husnniveledu, String huseestado, Integer version, 
                     String huseautorcont, String huscteloficina, 
                     String huseautoficina, String huseautcasa, 
                     String husccelular, String huseautcelular, 
                     String huseautmensaj, String huseautcorreoe, 
                     String husetipcliente, String huscnumafiliac,
                     String husetipvincula, Integer husnnumecontr,
                     String husccodinaci, Set chconsultas,String husccodsap,
                     Long husnaceppolprv, String huscpaisresi) {
        this.huslnumero = huslnumero;
        this.husetipoiden = husetipoiden;
        this.husanumeiden = husanumeiden;
        this.huscprimernomb = huscprimernomb;
        this.huscsegundnomb = huscsegundnomb;
        this.huscprimerapel = huscprimerapel;
        this.huscsegundapel = huscsegundapel;
        this.huseestadcivil = huseestadcivil;
        this.husesexo = husesexo;
        this.huscdireccion = huscdireccion;
        this.huscbarrio = huscbarrio;
        this.husctelefono = husctelefono;
        this.husdfechanacim = husdfechanacim;
        this.husezonareside = husezonareside;
        this.husndepartamen = husndepartamen;
        this.husnciudad = husnciudad;
        this.husetipoafilia = husetipoafilia;
        this.huscentidadadm = huscentidadadm;
        this.husnocupacion = husnocupacion;
        this.huscnomacompana = huscnomacompana;
        this.husctelacompana = husctelacompana;
        this.huscnomresponsa = huscnomresponsa;
        this.husctelresponsa = husctelresponsa;
        this.huscparresponsa = huscparresponsa;
        this.husccorreoelec = husccorreoelec;
        this.husnfolioactua = husnfolioactua;
        this.husdfecregistr = husdfecregistr;
        this.huscoperador = huscoperador;
        this.husehistoria = husehistoria;
        this.husdultimacons = husdultimacons;
        this.husnestrato = husnestrato;
        this.husnniveledu = husnniveledu;
        this.huseestado = huseestado;
        this.version = version;
        this.huseautorcont = huseautorcont;
        this.huscteloficina = huscteloficina;
        this.huseautoficina = huseautoficina;
        this.huseautcasa = huseautcasa;
        this.husccelular = husccelular;
        this.huseautcelular = huseautcelular;
        this.huseautmensaj = huseautmensaj;
        this.huseautcorreoe = huseautcorreoe;
        this.husetipcliente = husetipcliente;
        this.huscnumafiliac = huscnumafiliac;
        this.husetipvincula = husetipvincula;
        this.husnnumecontr = husnnumecontr;
        this.husccodinaci = husccodinaci;
        this.chconsultas = chconsultas;
        this.husccodsap = husccodsap;
        this.husnaceppolprv = husnaceppolprv;
        this.huscpaisresi = huscpaisresi;
    }

    /** default constructor */
    public Chusuario() {
    }

    /** minimal constructor */
    public Chusuario(Long huslnumero, String husetipoiden, Long husanumeiden, 
                     String huscprimernomb, String huscprimerapel, 
                     Set chconsultas) {
        this.huslnumero = huslnumero;
        this.husetipoiden = husetipoiden;
        this.husanumeiden = husanumeiden;
        this.huscprimernomb = huscprimernomb;
        this.huscprimerapel = huscprimerapel;
        this.chconsultas = chconsultas;
    }


    /**
     * @param fecha
     * @return
     */
    public static int calcularEdad(Date fecha) {
        Calendar birth = new GregorianCalendar();
        Calendar today = new GregorianCalendar();
        int age = 0;
        int factor = 0;
        Date birthDate = fecha;
        Date currentDate = new Date(); //current date
        birth.setTime(birthDate);
        today.setTime(currentDate);
        if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
            if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
                if (today.get(Calendar.DATE) < birth.get(Calendar.DATE)) {
                    factor = -1; //Aun no celebra su cumpleanos
                }
            } else {
                factor = -1; //Aun no celebra su cumpleanos
            }
        }
        age = (today.get(Calendar.YEAR) - birth.get(Calendar.YEAR)) + factor;
        return age;
    }

    public Long getHuslnumero() {
        return this.huslnumero;
    }

    public void setHuslnumero(Long huslnumero) {
        this.huslnumero = huslnumero;
    }

    public String getHusetipoiden() {
        return this.husetipoiden;
    }

    public void setHusetipoiden(String husetipoiden) {
        this.husetipoiden = husetipoiden;
    }

    public Long getHusanumeiden() {
        return this.husanumeiden;
    }

    public void setHusanumeiden(Long husanumeiden) {
        this.husanumeiden = husanumeiden;
    }

    public String getHuscprimernomb() {
    
    if(huscprimernomb != null && !huscprimernomb.equals("")){
        return this.huscprimernomb.toUpperCase();
    }
        return this.huscprimernomb;
    }

    public void setHuscprimernomb(String huscprimernomb) {
        this.huscprimernomb = huscprimernomb;
    }

    public String getHuscsegundnomb() {
    
        if(huscsegundnomb != null && !huscsegundnomb.equals("")){
            return this.huscsegundnomb.toUpperCase();
        }
        return this.huscsegundnomb;
    }

    public void setHuscsegundnomb(String huscsegundnomb) {
        this.huscsegundnomb = huscsegundnomb;
    }

    public String getHuscprimerapel() {
        if(huscprimerapel != null && !huscprimerapel.equals("")){
            return this.huscprimerapel.toUpperCase();
        }
        return this.huscprimerapel;
    }

    public void setHuscprimerapel(String huscprimerapel) {
        this.huscprimerapel = huscprimerapel;
    }

    public String getHuscsegundapel() {
        if(huscsegundapel != null && !huscsegundapel.equals("")){
            return this.huscsegundapel.toUpperCase();
        }
        return this.huscsegundapel;
    }

    public void setHuscsegundapel(String huscsegundapel) {
        this.huscsegundapel = huscsegundapel;
    }

    public String getHuseestadcivil() {
        return this.huseestadcivil;
    }

    public void setHuseestadcivil(String huseestadcivil) {
        this.huseestadcivil = huseestadcivil;
    }

    public String getHusesexo() {
        return this.husesexo;
    }

    public void setHusesexo(String husesexo) {
        this.husesexo = husesexo;
    }

    public String getHuscdireccion() {
        return this.huscdireccion;
    }

    public void setHuscdireccion(String huscdireccion) {
        this.huscdireccion = huscdireccion;
    }

    public String getHuscbarrio() {
        return this.huscbarrio;
    }

    public void setHuscbarrio(String huscbarrio) {
        this.huscbarrio = huscbarrio;
    }

    public String getHusctelefono() {
        return this.husctelefono;
    }

    public void setHusctelefono(String husctelefono) {
        this.husctelefono = husctelefono;
    }

    public Date getHusdfechanacim() {
        return this.husdfechanacim;
    }

    public void setHusdfechanacim(Date husdfechanacim) {
        this.husdfechanacim = husdfechanacim;
    }

    /**
     * @param valueChangeEvent
     */
    public void setHusdfechanacim(ValueChangeEvent valueChangeEvent) {
        setHusdfechanacim((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public String getHusezonareside() {
        return this.husezonareside;
    }

    public void setHusezonareside(String husezonareside) {
        this.husezonareside = husezonareside;
    }

    public Integer getHusndepartamen() {
        return this.husndepartamen;
    }

    public void setHusndepartamen(Integer husndepartamen) {
        this.husndepartamen = husndepartamen;
    }

    public Integer getHusnciudad() {
        return this.husnciudad;
    }

    public void setHusnciudad(Integer husnciudad) {
        this.husnciudad = husnciudad;
    }

    public String getHusetipoafilia() {
        return this.husetipoafilia;
    }

    public void setHusetipoafilia(String husetipoafilia) {
        this.husetipoafilia = husetipoafilia;
    }

    public String getHuscentidadadm() {
        if(huscentidadadm != null && !huscentidadadm.equals("")){
            return this.huscentidadadm.toUpperCase();
        }
        return this.huscentidadadm;
    }

    public void setHuscentidadadm(String huscentidadadm) {
        this.huscentidadadm = huscentidadadm;
    }

    public Integer getHusnocupacion() {
        return this.husnocupacion;
    }

    public void setHusnocupacion(Integer husnocupacion) {
        this.husnocupacion = husnocupacion;
    }

    public String getHuscnomacompana() {
        return this.huscnomacompana;
    }

    public void setHuscnomacompana(String huscnomacompana) {
        this.huscnomacompana = huscnomacompana;
    }

    public String getHusctelacompana() {
        return this.husctelacompana;
    }

    public void setHusctelacompana(String husctelacompana) {
        this.husctelacompana = husctelacompana;
    }

    public String getHuscnomresponsa() {
        return this.huscnomresponsa;
    }

    public void setHuscnomresponsa(String huscnomresponsa) {
        this.huscnomresponsa = huscnomresponsa;
    }

    public String getHusctelresponsa() {
        return this.husctelresponsa;
    }

    public void setHusctelresponsa(String husctelresponsa) {
        this.husctelresponsa = husctelresponsa;
    }

    public String getHuscparresponsa() {
        return this.huscparresponsa;
    }

    public void setHuscparresponsa(String huscparresponsa) {
        this.huscparresponsa = huscparresponsa;
    }

    public String getHusccorreoelec() {
        return this.husccorreoelec;
    }

    public void setHusccorreoelec(String husccorreoelec) {
        this.husccorreoelec = husccorreoelec;
    }

    public Integer getHusnfolioactua() {
        return this.husnfolioactua;
    }

    public void setHusnfolioactua(Integer husnfolioactua) {
        this.husnfolioactua = husnfolioactua;
    }

    public Date getHusdfecregistr() {
        return this.husdfecregistr;
    }

    public void setHusdfecregistr(Date husdfecregistr) {
        this.husdfecregistr = husdfecregistr;
    }

    public String getHuscoperador() {
        return this.huscoperador;
    }

    public void setHuscoperador(String huscoperador) {
        this.huscoperador = huscoperador;
    }

    public String getHusehistoria() {
        return this.husehistoria;
    }

    public void setHusehistoria(String husehistoria) {
        this.husehistoria = husehistoria;
    }

    public Date getHusdultimacons() {
        return this.husdultimacons;
    }

    public void setHusdultimacons(Date husdultimacons) {
        this.husdultimacons = husdultimacons;
    }

    public Integer getHusnestrato() {
        return this.husnestrato;
    }

    public void setHusnestrato(Integer husnestrato) {
        this.husnestrato = husnestrato;
    }

    public Integer getHusnniveledu() {
        return this.husnniveledu;
    }

    public void setHusnniveledu(Integer husnniveledu) {
        this.husnniveledu = husnniveledu;
    }

    public String getHuseestado() {
        return this.huseestado;
    }

    public void setHuseestado(String huseestado) {
        this.huseestado = huseestado;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getHuseautorcont() {
        return this.huseautorcont;
    }

    public void setHuseautorcont(String huseautorcont) {
        this.huseautorcont = huseautorcont;
    }

    public String getHuscteloficina() {
        return this.huscteloficina;
    }

    /**
     * @param huscteloficina
     */
    public void setHuscteloficina(String huscteloficina) {
        this.huscteloficina = huscteloficina;
    }

    /**
     * @return
     */
    public String getHuseautoficina() {
        return this.huseautoficina;
    }

    /**
     * @param huseautoficina
     */
    public void setHuseautoficina(String huseautoficina) {
        this.huseautoficina = huseautoficina;
    }

    /**
     * @return
     */
    public String getHuseautcasa() {
        return this.huseautcasa;
    }

    /**
     * @param huseautcasa
     */
    public void setHuseautcasa(String huseautcasa) {
        this.huseautcasa = huseautcasa;
    }

    /**
     * @return
     */
    public String getHusccelular() {
        return this.husccelular;
    }

    /**
     * @param husccelular
     */
    public void setHusccelular(String husccelular) {
        this.husccelular = husccelular;
    }

    /**
     * @return
     */
    public String getHuseautcelular() {
        return this.huseautcelular;
    }

    /**
     * @param huseautcelular
     */
    public void setHuseautcelular(String huseautcelular) {
        this.huseautcelular = huseautcelular;
    }

    /**
     * @return
     */
    public String getHuseautmensaj() {
        return this.huseautmensaj;
    }

    /**
     * @param huseautmensaj
     */
    public void setHuseautmensaj(String huseautmensaj) {
        this.huseautmensaj = huseautmensaj;
    }

    /**
     * @return
     */
    public String getHuseautcorreoe() {
        return this.huseautcorreoe;
    }

    /**
     * @param huseautcorreoe
     */
    public void setHuseautcorreoe(String huseautcorreoe) {
        this.huseautcorreoe = huseautcorreoe;
    }

    /**
     * @return
     */
    public Set getChconsultas() {
        return this.chconsultas;
    }

    /**
     * @param chconsultas
     */
    public void setChconsultas(Set chconsultas) {
        this.chconsultas = chconsultas;
    }

    /**
     * @return
     */
    public String toString() {
        return new ToStringBuilder(this).append("huslnumero", 
                                                getHuslnumero()).toString();
    }

    /**
     * @param edad
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * @return
     */
    public Integer getEdad() {

        if (this.husdfechanacim != null)
            setEdad(calcularEdad(this.husdfechanacim));

        return edad;
    }

    /**
     * @param huscetnia
     */
    public void setHuscetnia(String huscetnia) {
        this.huscetnia = huscetnia;
    }

    /**
     * @return
     */
    public String getHuscetnia() {
        return huscetnia;
    }

    /**
     * @param husnconoprofam
     */
    public void setHusnconoprofam(Integer husnconoprofam) {
        this.husnconoprofam = husnconoprofam;
    }

    /**
     * @return
     */
    public Integer getHusnconoprofam() {
        return husnconoprofam;
    }


    public void setHusetipcliente(String husetipcliente) {
        this.husetipcliente = husetipcliente;
    }

    public String getHusetipcliente() {
        return husetipcliente;
    }
    
    public void setHuscnumafiliac(String huscnumafiliac) {
        this.huscnumafiliac = huscnumafiliac;
    }

    public String getHuscnumafiliac() {
        return huscnumafiliac;
    }
    
    
    public void setHusetipvincula(String husetipvincula) {
        this.husetipvincula = husetipvincula;
    }

    public String getHusetipvincula() {
        return husetipvincula;
    }

    public void setHusnnumecontr(Integer husnnumecontr) {
        this.husnnumecontr = husnnumecontr;
    }

    public Integer getHusnnumecontr() {
        return husnnumecontr;
    }

    public void setHusedicapadad(String husedicapadad) {
        this.husedicapadad = husedicapadad;
    }

    public String getHusedicapadad() {
        return husedicapadad;
    }

    public void setHusediscaselec(String husediscaselec) {
        this.husediscaselec = husediscaselec;
    }

    public String getHusediscaselec() {
        return husediscaselec;
    }
    
    public void setHusccodinaci(String husccodinaci) {
        this.husccodinaci = husccodinaci;
    }

    public String getHusccodinaci() {
        return husccodinaci;
    }

    public void setHuscnombralter(String huscnombralter) {
        this.huscnombralter = huscnombralter;
    }

    public String getHuscnombralter() {
        return huscnombralter;
    }

    public void setHusccodsap(String husccodsap) {
        this.husccodsap = husccodsap;
    }

    public String getHusccodsap() {
        return husccodsap;
    }

    public void setHuscidengene(String huscidengene) {
        this.huscidengene = huscidengene;
    }

    public String getHuscidengene() {
        return huscidengene;
    }

    public void setHuscoriesexu(String huscoriesexu) {
        this.huscoriesexu = huscoriesexu;
    }

    public String getHuscoriesexu() {
        return huscoriesexu;
    }

    public void setHuscvivesolo(String huscvivesolo) {
        this.huscvivesolo = huscvivesolo;
    }

    public String getHuscvivesolo() {
        return huscvivesolo;
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

    public void setHusnaceppolprv(Long husnaceppolprv) {
        this.husnaceppolprv = husnaceppolprv;
    }

    public Long getHusnaceppolprv() {
        return husnaceppolprv;
    }

    public void setHuscpaisresi(String huscpaisresi) {
        this.huscpaisresi = huscpaisresi;
    }

    public String getHuscpaisresi() {
        return huscpaisresi;
    }
}
