package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;


/** @author Hibernate CodeGenerator */
public class Chmedicament implements Serializable {


    private ChmedicamentId id;

    /** identifier field */
    private String hmecmedicament;

    /** identifier field */
    private String hmecpresentaci;
    
    /** identifier field */
    private String hmecnomblabo;

    /** identifier field */
    private String hmecviadministr;

    /** identifier field */
    private String hmecviadminotr;

    /** identifier field */
    private String hmeclotemedic;

    /** identifier field */
    private String hmecsitioaplic;

    /** identifier field */
    private Date hmedfechavenci;

    /** identifier field */
    private BigDecimal hmecadosis;

    /** identifier field */
    private Date hmedfecregistr;

    /** identifier field */
    private String hmecoperador;

    /** identifier field */
    private Integer version;

    /** identifier field */
    private String hmectiposerv;
    
    /** identifier field */
    private String hmecobservac;
    
    /** identifier field */
    private Integer hmennumervacun; 
    
    /** identifier field */
    private String hmecunidmedi;
    
    private Integer hmentipohisto; 
    
    private String hmecpresereacc; 
    
    private String hmeccualcompl;
    
    private String hmeccualreacc;
    
    private String hmecpresecompl;
    
    private boolean renderReacciones;
    
    private boolean renderComplicaciones;
    
    private String hmelcregiacti; 
    
    private String hmelcgrusangu; 
    
    private String hmelcrh; 
    
    private boolean selectObs;
    
    private boolean aplicacion;
    
    private boolean vacunacion;
    
    private boolean medicamento;

 

    /** default constructor */
    public Chmedicament() {
        id = new ChmedicamentId ();
    
    }

    public void setId(ChmedicamentId id) {
        this.id = id;
    }

    public ChmedicamentId getId() {
        return id;
    }

    public void setHmecmedicament(String hmecmedicament) {
        this.hmecmedicament = hmecmedicament;
    }

    public String getHmecmedicament() {
        return hmecmedicament;
    }

    public void setHmecpresentaci(String hmecpresentaci) {
        this.hmecpresentaci = hmecpresentaci;
    }

    public String getHmecpresentaci() {
        return hmecpresentaci;
    }

    public void setHmecviadministr(String hmecviadministr) {
        this.hmecviadministr = hmecviadministr;
    }

    public String getHmecviadministr() {
        return hmecviadministr;
    }

    public void setHmecviadminotr(String hmecviadminotr) {
        this.hmecviadminotr = hmecviadminotr;
    }

    public String getHmecviadminotr() {
        return hmecviadminotr;
    }

    public void setHmeclotemedic(String hmeclotemedic) {
        this.hmeclotemedic = hmeclotemedic;
    }

    public String getHmeclotemedic() {
        return hmeclotemedic;
    }

    public void setHmecsitioaplic(String hmecsitioaplic) {
        this.hmecsitioaplic = hmecsitioaplic;
    }

    public String getHmecsitioaplic() {
        return hmecsitioaplic;
    }

    public void setHmedfechavenci(Date hmedfechavenci) {
        this.hmedfechavenci = hmedfechavenci;
    }

    public Date getHmedfechavenci() {
        return hmedfechavenci;
    }

    public void setHmecadosis(BigDecimal hmecadosis) {
        this.hmecadosis = hmecadosis;
    }

    public BigDecimal getHmecadosis() {
        return hmecadosis;
    }

    public void setHmedfecregistr(Date hmedfecregistr) {
        this.hmedfecregistr = hmedfecregistr;
    }

    public Date getHmedfecregistr() {
        return hmedfecregistr;
    }

    public void setHmecoperador(String hmecoperador) {
        this.hmecoperador = hmecoperador;
    }

    public String getHmecoperador() {
        return hmecoperador;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHmectiposerv(String hmectiposerv) {
        this.hmectiposerv = hmectiposerv;
    }

    public String getHmectiposerv() {
        return hmectiposerv;
    }

    public void setHmecnomblabo(String hmecnomblabo) {
        this.hmecnomblabo = hmecnomblabo;
    }

    public String getHmecnomblabo() {
        return hmecnomblabo;
    }

    public void setHmecobservac(String hmecobservac) {
        this.hmecobservac = hmecobservac;
    }

    public String getHmecobservac() {
        return hmecobservac;
    }

    public void setHmennumervacun(Integer hmennumervacun) {
        this.hmennumervacun = hmennumervacun;
    }

    public Integer getHmennumervacun() {
        return hmennumervacun;
    }

    public void setHmecunidmedi(String hmecunidmedi) {
        this.hmecunidmedi = hmecunidmedi;
    }

    public String getHmecunidmedi() {
        return hmecunidmedi;
    }


    public void setHmentipohisto(Integer hmentipohisto) {
        this.hmentipohisto = hmentipohisto;
    }

    public Integer getHmentipohisto() {
        return hmentipohisto;
    }

    public void setHmecpresereacc(String hmecpresereacc) {
        this.hmecpresereacc = hmecpresereacc;
    }

    public String getHmecpresereacc() {
        return hmecpresereacc;
    }

    public void setHmeccualcompl(String hmeccualcompl) {
        this.hmeccualcompl = hmeccualcompl;
    }

    public String getHmeccualcompl() {
        return hmeccualcompl;
    }

    public void setHmeccualreacc(String hmeccualreacc) {
        this.hmeccualreacc = hmeccualreacc;
    }

    public String getHmeccualreacc() {
        return hmeccualreacc;
    }

    public void setHmecpresecompl(String hmecpresecompl) {
        this.hmecpresecompl = hmecpresecompl;
    }

    public String getHmecpresecompl() {
        return hmecpresecompl;
    }
    
    
    public void setHmecpresereacc(ValueChangeEvent valueChangeEvent) {
        setHmecpresereacc((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        
        
    public void setHmecpresecompl(ValueChangeEvent valueChangeEvent) {
       setHmecpresecompl((String)valueChangeEvent.getNewValue());
       ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
       }
        
        
    public void changeReacciones(){
       renderReacciones= false; 
       if(hmecpresereacc != null){
           if(hmecpresereacc.equals("S") ){
               renderReacciones= true; 
           }
       }
       
    }
    
    
    public void changeComplicaciones(){
    renderComplicaciones = false; 
    if(hmecpresecompl != null){
     if(hmecpresecompl.equals("S") ){
         renderComplicaciones = true; 
     }
    }
    }


    public void setRenderReacciones(boolean renderReacciones) {
        this.renderReacciones = renderReacciones;
    }

    public boolean isRenderReacciones() {
        return renderReacciones;
    }

    public void setRenderComplicaciones(boolean renderComplicaciones) {
        this.renderComplicaciones = renderComplicaciones;
    }

    public boolean isRenderComplicaciones() {
        return renderComplicaciones;
    }

    public void setHmelcregiacti(String hmelcregiacti) {
        this.hmelcregiacti = hmelcregiacti;
    }

    public String getHmelcregiacti() {
        return hmelcregiacti;
    }


    public void setHmelcgrusangu(String hmelcgrusangu) {
        this.hmelcgrusangu = hmelcgrusangu;
    }

    public String getHmelcgrusangu() {
        return hmelcgrusangu;
    }

    public void setHmelcrh(String hmelcrh) {
        this.hmelcrh = hmelcrh;
    }

    public String getHmelcrh() {
        return hmelcrh;
    }

    public void setSelectObs(boolean selectObs) {
        this.selectObs = selectObs;
    }

    public boolean isSelectObs() {
        return selectObs;
    }

    public void setAplicacion(boolean aplicacion) {
        this.aplicacion = aplicacion;
    }

    public boolean isAplicacion() {
        return aplicacion;
    }


    public void setVacunacion(boolean vacunacion) {
        this.vacunacion = vacunacion;
    }

    public boolean isVacunacion() {
        return vacunacion;
    }

    public void setMedicamento(boolean medicamento) {
        this.medicamento = medicamento;
    }

    public boolean isMedicamento() {
        return medicamento;
    }
}
