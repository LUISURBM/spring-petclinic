package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;




/** @author Hibernate CodeGenerator */
public class Chcontmedane implements Serializable {

    /** identifier field */
    private ChcontmedanePK id;

    /** persistent field */
    private Integer hmancodigvadem;

    /** nullable persistent field */
    private String hmacmedicament;

    /** nullable persistent field */
    private String hmacunidades;

    /** nullable persistent field */
    private Date hmadhoraadmini;

    /** nullable persistent field */
    private BigDecimal hmaninduccion;

    /** nullable persistent field */
    private BigDecimal hmanmantenimie;

    /** nullable persistent field */
    private String hmacetapa;

    /** nullable persistent field */
    private Date hmadfecregistr;

    /** nullable persistent field */
    private String hmacoperador;

    /** nullable persistent field */
    private Integer version;
    
    /** nullable persistent field */
    private String hmacunidapeso;
    
    /** nullable persistent field */
    private String hmacviaadmini;
    
    /** nullable persistent field*/
    private String hmacformadmi; 
    
    /** nullable persistent field*/ 
    private Integer hmacformdosis;
    
    /** nullable persistent field*/
    private String hmacviaadlocal;
    
    /** nullable persistent field*/
    private String hmacviaadotra;  
    
    /** nullable persistent field*/
    private BigDecimal hmantotalinma;
    
    /** nullable persistent field */
    private String hmacmedicamento;
   
    /** nullable persistent field */
    private String hmacdesunidades;
    
    /** nullable persistent field */
    private String hmadesviaadmini;
    
    /** nullable persistent field*/
    private String hmacdesformadmi; 
    
    /** nullable persistent field*/
    private String hmaccodsap; 
    
    /** not persistent field*/
    private FichaTecnicaCostosDTO fichaTecnicaCostosDTO; 

    /** default constructor */
    public Chcontmedane() {
        id = new ChcontmedanePK(); 
    }


    /**
     * @param id
     */
    public void setId(ChcontmedanePK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChcontmedanePK getId() {
        return id;
    }

    /**
     * @param hmancodigvadem
     */
    public void setHmancodigvadem(Integer hmancodigvadem) {
        this.hmancodigvadem = hmancodigvadem;
    }

    /**
     * @return
     */
    public Integer getHmancodigvadem() {
        return hmancodigvadem;
    }

    /**
     * @param hmacmedicament
     */
    public void setHmacmedicament(String hmacmedicament) {
        this.hmacmedicament = hmacmedicament;
    }

    /**
     * @return
     */
    public String getHmacmedicament() {
        return hmacmedicament;
    }

    /**
     * @param hmacunidades
     */
    public void setHmacunidades(String hmacunidades) {
        this.hmacunidades = hmacunidades;
    }

    /**
     * @return
     */
    public String getHmacunidades() {
        return hmacunidades;
    }

    /**
     * @param hmadhoraadmini
     */
    public void setHmadhoraadmini(Date hmadhoraadmini) {
        this.hmadhoraadmini = hmadhoraadmini;
    }

    /**
     * @return
     */
    public Date getHmadhoraadmini() {
        return hmadhoraadmini;
    }

    /**
     * @param hmaninduccion
     */
    public void setHmaninduccion(BigDecimal hmaninduccion) {
        this.hmaninduccion = hmaninduccion;
    }

    /**
     * @return
     */
    public BigDecimal getHmaninduccion() {
        return hmaninduccion;
    }

    /**
     * @param hmanmantenimie
     */
    public void setHmanmantenimie(BigDecimal hmanmantenimie) {
        this.hmanmantenimie = hmanmantenimie;
    }

    /**
     * @return
     */
    public BigDecimal getHmanmantenimie() {
        return hmanmantenimie;
    }

    /**
     * @param hmacetapa
     */
    public void setHmacetapa(String hmacetapa) {
        this.hmacetapa = hmacetapa;
    }

    /**
     * @return
     */
    public String getHmacetapa() {
        return hmacetapa;
    }

    /**
     * @param hmadfecregistr
     */
    public void setHmadfecregistr(Date hmadfecregistr) {
        this.hmadfecregistr = hmadfecregistr;
    }

    /**
     * @return
     */
    public Date getHmadfecregistr() {
        return hmadfecregistr;
    }

    /**
     * @param hmacoperador
     */
    public void setHmacoperador(String hmacoperador) {
        this.hmacoperador = hmacoperador;
    }

    /**
     * @return
     */
    public String getHmacoperador() {
        return hmacoperador;
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

    public void setHmacunidapeso(String hmacunidapeso) {
        this.hmacunidapeso = hmacunidapeso;
    }

    public String getHmacunidapeso() {
        return hmacunidapeso;
    }

    public void setHmacviaadmini(String hmacviaadmini) {
        this.hmacviaadmini = hmacviaadmini;
    }

    public String getHmacviaadmini() {
        return hmacviaadmini;
    }

    public void setHmacformadmi(String hmacformadmi) {
        this.hmacformadmi = hmacformadmi;
    }

    public String getHmacformadmi() {
        return hmacformadmi;
    }

    public void setHmacformdosis(Integer hmacformdosis) {
        this.hmacformdosis = hmacformdosis;
    }

    public Integer getHmacformdosis() {
        return hmacformdosis;
    }

    public void setHmacviaadlocal(String hmacviaadlocal) {
        this.hmacviaadlocal = hmacviaadlocal;
    }

    public String getHmacviaadlocal() {
        return hmacviaadlocal;
    }

    public void setHmacviaadotra(String hmacviaadotra) {
        this.hmacviaadotra = hmacviaadotra;
    }

    public String getHmacviaadotra() {
        return hmacviaadotra;
    }

    public void setHmantotalinma(BigDecimal hmantotalinma) {
        this.hmantotalinma = hmantotalinma;
    }

    public BigDecimal getHmantotalinma() {
        return hmantotalinma;
    }

    public void setHmacmedicamento(String hmacmedicamento) {
        this.hmacmedicamento = hmacmedicamento;
    }

    public String getHmacmedicamento() {
        return hmacmedicamento;
    }

    public void setHmacdesunidades(String hmacdesunidades) {
        this.hmacdesunidades = hmacdesunidades;
    }

    public String getHmacdesunidades() {
        hmacdesunidades = "";
        if(hmacunidapeso!= null){
            if(hmacunidapeso.toUpperCase().equals("GR")){
                hmacdesunidades = "Gramos"; 
            }

            else if(hmacunidapeso.toUpperCase().equals("ML")){
                hmacdesunidades = "Miligramos"; 
            }
            else if(hmacunidapeso.toUpperCase().equals("MC")){
                hmacdesunidades = "Microgramos"; 
            }else if(hmacunidapeso.toUpperCase().equals("UN")){
                hmacdesunidades = "Unidades"; 
            }else{
                hmacdesunidades = hmacunidapeso;
            }
        }
        return hmacdesunidades;
    }

    public void setHmadesviaadmini(String hmadesviaadmini) {
        this.hmadesviaadmini = hmadesviaadmini;
    }

    public String getHmadesviaadmini() {
        hmadesviaadmini= "";
        if(hmacviaadmini != null){
            if(hmacviaadmini.equals("IV")){
                hmadesviaadmini  = "Intravenosa";
            }
            if(hmacviaadmini.equals("IM")){
                hmadesviaadmini  = "Intramuscular";
            }
            if(hmacviaadmini.equals("SC")){
                hmadesviaadmini  = "Subcut�nea";
            }
            if(hmacviaadmini.equals("PE")){
                hmadesviaadmini  = "Peridural";
            }
            if(hmacviaadmini.equals("SU")){
                hmadesviaadmini  = "Subaracniodea";
            }
            if(hmacviaadmini.equals("LO")){
                hmadesviaadmini  = "Local";
            }
            if(hmacviaadmini.equals("OT")){
                hmadesviaadmini  = "Otra";
            }
            
           
        }
    
    
        return hmadesviaadmini;
    }

    public void setHmacdesformadmi(String hmacdesformadmi) {
        this.hmacdesformadmi = hmacdesformadmi;
    }

    public String getHmacdesformadmi() {
        hmacdesformadmi = "";
        if(hmacformadmi!= null){
            if(hmacformadmi.equals("BO")){
                hmacdesformadmi = "Bolo"; 
            }

            if(hmacformadmi.equals("IM")){
                hmacdesformadmi = "Infusi�n en minutos"; 
            }
            if(hmacformadmi.equals("IC")){
                hmacdesformadmi = "Infusi�n continua"; 
            }
       
        }
        return hmacdesformadmi;
        }

    public void setHmaccodsap(String hmaccodsap) {
        this.hmaccodsap = hmaccodsap;
    }

    public String getHmaccodsap() {
        return hmaccodsap;
    }

    public void setFichaTecnicaCostosDTO(FichaTecnicaCostosDTO fichaTecnicaCostosDTO) {
        this.fichaTecnicaCostosDTO = fichaTecnicaCostosDTO;
    }

    public FichaTecnicaCostosDTO getFichaTecnicaCostosDTO() {
        return fichaTecnicaCostosDTO;
    }
}
