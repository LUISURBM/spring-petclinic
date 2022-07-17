package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;




/** @author Hibernate CodeGenerator */
public class Chvademprof implements Serializable {

    /** identifier field */
    private Integer hvpnconsecutiv;

    /** nullable persistent field */
    private String hvpccodigatc;

    /** nullable persistent field */
    private String hvpccodisap;

    /** nullable persistent field */
    private String hvpccodicum;

    /** nullable persistent field */
    private String hvpcclastera;

    /** persistent field */
    private String hvpcprincactiv;

    /** nullable persistent field */
    private String hvpcmarca;

    /** persistent field */
    private String hvpcconcentrac;

    /** persistent field */
    private String hvpcunidmedi;

    /** persistent field */
    private String hvpcformafarma;

    /** nullable persistent field */
    private String hvpcprescome;

    /** nullable persistent field */
    private String hvpcregisani;

    /** nullable persistent field */
    private String hvpcfabrican;

    /** nullable persistent field */
    private String hvpcviaadmo;

    /** nullable persistent field */
    private String hvpctipovent;

    /** nullable persistent field */
    private String hvpcindicacion;

    /** nullable persistent field */
    private String hvpccontrindic;

    /** nullable persistent field */
    private String hvpcaclaracion;

    /** nullable persistent field */
    private String hvpcmedicpos;

    /** nullable persistent field */
    private String hvpccomercial;

    /** nullable persistent field */
    private String hvpccodigcomer;

    /** nullable persistent field */
    private String hvpcanestesia;

    /** nullable persistent field */
    private String hvpcinicianest;

    /** persistent field */
    private String hvpcoperador;

    /** persistent field */
    private Date hvpdfecharegis;

    /** nullable persistent field */
    private String hvpcoperamodif;

    /** nullable persistent field */
    private Date hvpdfechamodif;

    /** nullable persistent field */
    private String hvpcobservaci;
    
    /** nullable persistent field */
    private String hvpctratamiento;
    
    
    /** nullable persistent field */
    private String hvpcdialforma;

    /** nullable persistent field */
    private Integer version;
    
    /** nullable persistent field */
    private String  hvpcformadmi;
    
    
    /**Datos */
    
     private Integer hvpncantidad;
     
    private Integer hvpnfrecuencia;
    
    private String hvpcfrecuencia;
    
    private Integer hvpnduracion;
    
    private String hvpcduracion;
    
    
    private String hvpcprincactiv2;
    private String hvpcprincactiv3;
    private String hvpcopera1;
    private String hvpcopera2;
    private String hvpcopera3;
    
    private boolean renderEscribir;
    
    private String hvpcmedicprof;
    
    private String hvpcalerta;
    
    private boolean renderAlerta; 
    
    /** not persistent fields**/
    private FichaTecnicaCostosDTO fichaTecnica;

    /** default constructor */
    public Chvademprof() {

    }

    public void setHvpnconsecutiv(Integer hvpnconsecutiv) {
        this.hvpnconsecutiv = hvpnconsecutiv;
    }

    public Integer getHvpnconsecutiv() {
        return hvpnconsecutiv;
    }

    public void setHvpccodigatc(String hvpccodigatc) {
        this.hvpccodigatc = hvpccodigatc;
    }

    public String getHvpccodigatc() {
        return hvpccodigatc;
    }

    public void setHvpccodisap(String hvpccodisap) {
        this.hvpccodisap = hvpccodisap;
    }

    public String getHvpccodisap() {
        return hvpccodisap;
    }

    public void setHvpccodicum(String hvpccodicum) {
        this.hvpccodicum = hvpccodicum;
    }

    public String getHvpccodicum() {
        return hvpccodicum;
    }

    public void setHvpcclastera(String hvpcclastera) {
        this.hvpcclastera = hvpcclastera;
    }

    public String getHvpcclastera() {
        return hvpcclastera;
    }

    public void setHvpcprincactiv(String hvpcprincactiv) {
        this.hvpcprincactiv = hvpcprincactiv;
    }

    public String getHvpcprincactiv() {
        return hvpcprincactiv;
    }

    public void setHvpcmarca(String hvpcmarca) {
        this.hvpcmarca = hvpcmarca;
    }

    public String getHvpcmarca() {
        return hvpcmarca;
    }

    public void setHvpcconcentrac(String hvpcconcentrac) {
        this.hvpcconcentrac = hvpcconcentrac;
    }

    public String getHvpcconcentrac() {
        return hvpcconcentrac;
    }

    public void setHvpcunidmedi(String hvpcunidmedi) {
        this.hvpcunidmedi = hvpcunidmedi;
    }

    public String getHvpcunidmedi() {
        return hvpcunidmedi;
    }

    public void setHvpcformafarma(String hvpcformafarma) {
        this.hvpcformafarma = hvpcformafarma;
    }

    public String getHvpcformafarma() {
        return hvpcformafarma;
    }

    public void setHvpcprescome(String hvpcprescome) {
        this.hvpcprescome = hvpcprescome;
    }

    public String getHvpcprescome() {
        return hvpcprescome;
    }

    public void setHvpcregisani(String hvpcregisani) {
        this.hvpcregisani = hvpcregisani;
    }

    public String getHvpcregisani() {
        return hvpcregisani;
    }

    public void setHvpcfabrican(String hvpcfabrican) {
        this.hvpcfabrican = hvpcfabrican;
    }

    public String getHvpcfabrican() {
        return hvpcfabrican;
    }

    public void setHvpcviaadmo(String hvpcviaadmo) {
        this.hvpcviaadmo = hvpcviaadmo;
    }

    public String getHvpcviaadmo() {
        return hvpcviaadmo;
    }

    public void setHvpctipovent(String hvpctipovent) {
        this.hvpctipovent = hvpctipovent;
    }

    public String getHvpctipovent() {
        return hvpctipovent;
    }

    public void setHvpcindicacion(String hvpcindicacion) {
        this.hvpcindicacion = hvpcindicacion;
    }

    public String getHvpcindicacion() {
        return hvpcindicacion;
    }

    public void setHvpccontrindic(String hvpccontrindic) {
        this.hvpccontrindic = hvpccontrindic;
    }

    public String getHvpccontrindic() {
        return hvpccontrindic;
    }

    public void setHvpcaclaracion(String hvpcaclaracion) {
        this.hvpcaclaracion = hvpcaclaracion;
    }

    public String getHvpcaclaracion() {
        return hvpcaclaracion;
    }

    public void setHvpcmedicpos(String hvpcmedicpos) {
        this.hvpcmedicpos = hvpcmedicpos;
    }

    public String getHvpcmedicpos() {
        return hvpcmedicpos;
    }

    public void setHvpccomercial(String hvpccomercial) {
        this.hvpccomercial = hvpccomercial;
    }

    public String getHvpccomercial() {
        return hvpccomercial;
    }

    public void setHvpccodigcomer(String hvpccodigcomer) {
        this.hvpccodigcomer = hvpccodigcomer;
    }

    public String getHvpccodigcomer() {
        return hvpccodigcomer;
    }

    public void setHvpcanestesia(String hvpcanestesia) {
        this.hvpcanestesia = hvpcanestesia;
    }

    public String getHvpcanestesia() {
        return hvpcanestesia;
    }

    public void setHvpcinicianest(String hvpcinicianest) {
        this.hvpcinicianest = hvpcinicianest;
    }

    public String getHvpcinicianest() {
        return hvpcinicianest;
    }

    public void setHvpcoperador(String hvpcoperador) {
        this.hvpcoperador = hvpcoperador;
    }

    public String getHvpcoperador() {
        return hvpcoperador;
    }

    public void setHvpdfecharegis(Date hvpdfecharegis) {
        this.hvpdfecharegis = hvpdfecharegis;
    }

    public Date getHvpdfecharegis() {
        return hvpdfecharegis;
    }

    public void setHvpcoperamodif(String hvpcoperamodif) {
        this.hvpcoperamodif = hvpcoperamodif;
    }

    public String getHvpcoperamodif() {
        return hvpcoperamodif;
    }

    public void setHvpdfechamodif(Date hvpdfechamodif) {
        this.hvpdfechamodif = hvpdfechamodif;
    }

    public Date getHvpdfechamodif() {
        return hvpdfechamodif;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHvpcprincactiv2(String hvpcprincactiv2) {
        this.hvpcprincactiv2 = hvpcprincactiv2;
    }

    public String getHvpcprincactiv2() {
        return hvpcprincactiv2;
    }

    public void setHvpcprincactiv3(String hvpcprincactiv3) {
        this.hvpcprincactiv3 = hvpcprincactiv3;
    }

    public String getHvpcprincactiv3() {
        return hvpcprincactiv3;
    }

    public void setHvpcopera1(String hvpcopera1) {
        this.hvpcopera1 = hvpcopera1;
    }

    public String getHvpcopera1() {
        return hvpcopera1;
    }

    public void setHvpcopera2(String hvpcopera2) {
        this.hvpcopera2 = hvpcopera2;
    }

    public String getHvpcopera2() {
        return hvpcopera2;
    }

    public void setHvpcopera3(String hvpcopera3) {
        this.hvpcopera3 = hvpcopera3;
    }

    public String getHvpcopera3() {
        return hvpcopera3;
    }

    public void setHvpncantidad(Integer hvpncantidad) {
        this.hvpncantidad = hvpncantidad;
    }

    public Integer getHvpncantidad() {
        return hvpncantidad;
    }

    public void setHvpnfrecuencia(Integer hvpnfrecuencia) {
        this.hvpnfrecuencia = hvpnfrecuencia;
    }

    public Integer getHvpnfrecuencia() {
        return hvpnfrecuencia;
    }

    public void setHvpcfrecuencia(String hvpcfrecuencia) {
        this.hvpcfrecuencia = hvpcfrecuencia;
    }

    public String getHvpcfrecuencia() {
        return hvpcfrecuencia;
    }

    public void setHvpnduracion(Integer hvpnduracion) {
        this.hvpnduracion = hvpnduracion;
    }

    public Integer getHvpnduracion() {
        return hvpnduracion;
    }

    public void setHvpcduracion(String hvpcduracion) {
        this.hvpcduracion = hvpcduracion;
    }

    public String getHvpcduracion() {
        return hvpcduracion;
    }

    public void setRenderEscribir(boolean renderEscribir) {
        this.renderEscribir = renderEscribir;
    }

    public boolean isRenderEscribir() {
        renderEscribir = false; 
        if(hvpnconsecutiv != null && hvpnconsecutiv.intValue()==0){
            renderEscribir = true; 
        }
        
        
        return renderEscribir;
    }

    public void setHvpcmedicprof(String hvpcmedicprof) {
        this.hvpcmedicprof = hvpcmedicprof;
    }

    public String getHvpcmedicprof() {
        hvpcmedicprof = "";
    if(hvpccodisap != null && !hvpccodisap.equals("") &&  !hvpccodisap.equals("0") ){
        hvpcmedicprof = "SI";
    }
    
        return hvpcmedicprof;
    }

    public void setHvpcobservaci(String hvpcobservaci) {
        this.hvpcobservaci = hvpcobservaci;
    }

    public String getHvpcobservaci() {
        return hvpcobservaci;
    }

    public void setHvpcdialforma(String hvpcdialforma) {
        this.hvpcdialforma = hvpcdialforma;
    }

    public String getHvpcdialforma() {
        return hvpcdialforma;
    }

    public void setHvpctratamiento(String hvpctratamiento) {
        this.hvpctratamiento = hvpctratamiento;
    }

    public String getHvpctratamiento() {
        return hvpctratamiento;
    }

    public void setHvpcalerta(String hvpcalerta) {
        this.hvpcalerta = hvpcalerta;
    }

    public String getHvpcalerta() {
        return hvpcalerta;
    }

    public void setRenderAlerta(boolean renderAlerta) {
        this.renderAlerta = renderAlerta;
    }

    public boolean isRenderAlerta() {
    renderAlerta = false; 
     if(hvpcalerta != null && !hvpcalerta.equals("")){
         renderAlerta = true; 
     }
    
        return renderAlerta;
    }


    public void setFichaTecnica(FichaTecnicaCostosDTO fichaTecnica) {
        this.fichaTecnica = fichaTecnica;
    }

    public FichaTecnicaCostosDTO getFichaTecnica() {
        return fichaTecnica;
    }

    public void setHvpcformadmi(String hvpcformadmi) {
        this.hvpcformadmi = hvpcformadmi;
    }

    public String getHvpcformadmi() {
        return hvpcformadmi;
    }
}
