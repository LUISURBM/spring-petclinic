package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import org.profamilia.hc.model.dto.ChcontroordenPK;


/** @author Hibernate CodeGenerator */
public class Chcontroorden implements Serializable {

    /** identifier field */
    private ChcontroordenPK id;

    /** nullable persistent field */
    private String hcocestado;

    /** nullable persistent field */
    private String hcocetapa;

    /** nullable persistent field */
    private String hcocoperaasig;

    /** nullable persistent field */
    private String hcocoperaadmi;

    /** nullable persistent field */
    private Date hcodfechaasig;

    /** nullable persistent field */
    private Date hcodfechaadmi;

    /** nullable persistent field */
    private String hcocordenenvi;
    
    /** nullable persistent field */
    private String hcocnombreord;
    
    /** nullable persistent field */
    private Integer version;
    
    /** nullable persistent field */
    private String hcocobserva;
    
    /** nullable persistent field */
    private boolean hcobsuspender;
    
    /** nullable persistent field */
    private boolean hcobrendersusp;
    
    /** nullable persistent field */
    private String hcocoperamodif;
    
    /** nullable persistent field */
    private Date hcodfechamodif;

    /** nullable persistent field */
    private Integer hconevoluconse;
    
    /** nullable persistent field */
    private String hcocsistoxige;
    
    /** nullable persistent field */
    private String hcoccantlitros;
   
    /** nullable persistent field */
    private Long hcoccantminutos;
    
    /** nullable persistent field */
    private String hcoccduracion;
    
    
    /** nullable persistent field */
    private String reciente;


    /** nullable persistent field */
    private boolean  renderOxigeno;
    
    private String nombreTipo;

    /** nullable persistent field */
    private String hcoccadminisoxig;
    
    /** nullable persistent field */
    private Date hcocdfechadminis;
    
    /** nullable persistent field */
    private String hcoccadminoxigdesc;
    
    /** nullable persistent field */
    private String hcoccestadoadminox;
    
    /** nullable persistent field */
    private boolean  renderOxigenoCriterio;
    
    /** nullable persistent field */
    private String nombreSistemaOx;
    
    /** nullable persistent field */
    private Date hcodhorainioxi;
    /** nullable persistent field */
    private Date hcodhorafinoxi;
    
    /** nullable persistent field */
    private Long hcolusuario; 

    /** default constructor */
    public Chcontroorden() {
        id = new ChcontroordenPK();
    }


    /**
     * @param id
     */
    public void setId(ChcontroordenPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChcontroordenPK getId() {
        return id;
    }

    public void setHcocestado(String hcocestado) {
        this.hcocestado = hcocestado;
    }

    public String getHcocestado() {
        return hcocestado;
    }

    public void setHcocetapa(String hcocetapa) {
        this.hcocetapa = hcocetapa;
    }

    public String getHcocetapa() {
        return hcocetapa;
    }

    public void setHcocoperaasig(String hcocoperaasig) {
        this.hcocoperaasig = hcocoperaasig;
    }

    public String getHcocoperaasig() {
        return hcocoperaasig;
    }

    public void setHcocoperaadmi(String hcocoperaadmi) {
        this.hcocoperaadmi = hcocoperaadmi;
    }

    public String getHcocoperaadmi() {
        return hcocoperaadmi;
    }

    public void setHcodfechaasig(Date hcodfechaasig) {
        this.hcodfechaasig = hcodfechaasig;
    }

    public Date getHcodfechaasig() {
        return hcodfechaasig;
    }

    public void setHcodfechaadmi(Date hcodfechaadmi) {
        this.hcodfechaadmi = hcodfechaadmi;
    }

    public Date getHcodfechaadmi() {
        return hcodfechaadmi;
    }

    public void setHcocordenenvi(String hcocordenenvi) {
        this.hcocordenenvi = hcocordenenvi;
    }

    public String getHcocordenenvi() {
        return hcocordenenvi;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHcocnombreord(String hcocnombreord) {
        this.hcocnombreord = hcocnombreord;
    }

    public String getHcocnombreord() {
        return hcocnombreord;
    }

    public void setHcocobserva(String hcocobserva) {
        this.hcocobserva = hcocobserva;
    }

    public String getHcocobserva() {
        return hcocobserva;
    }

    public void setHcobsuspender(boolean hcobsuspender) {
        this.hcobsuspender = hcobsuspender;
    }

    public boolean isHcobsuspender() {
        return hcobsuspender;
    }

    public void setHcobrendersusp(boolean hcobrendersusp) {
        this.hcobrendersusp = hcobrendersusp;
    }

    public boolean isHcobrendersusp() {
        if (hcocetapa != null) {
            if (hcocetapa.equals("AD") || hcocetapa.equals("SP")) {
                hcobrendersusp = false;
            } else {
                hcobrendersusp = true;
            }
        }
        return hcobrendersusp;
    }

    public void setHcocoperamodif(String hcocoperamodif) {
        this.hcocoperamodif = hcocoperamodif;
    }

    public String getHcocoperamodif() {
        return hcocoperamodif;
    }

    public void setHcodfechamodif(Date hcodfechamodif) {
        this.hcodfechamodif = hcodfechamodif;
    }

    public Date getHcodfechamodif() {
        return hcodfechamodif;
    }


    public void setHconevoluconse(Integer hconevoluconse) {
        this.hconevoluconse = hconevoluconse;
    }

    public Integer getHconevoluconse() {
        return hconevoluconse;
    }

    public void setHcocsistoxige(String hcocsistoxige) {
        this.hcocsistoxige = hcocsistoxige;
    }

    public String getHcocsistoxige() {
        return hcocsistoxige;
    }

    public void setHcoccantlitros(String hcoccantlitros) {
        this.hcoccantlitros = hcoccantlitros;
    }

    public String getHcoccantlitros() {
        return hcoccantlitros;
    }

    public void setHcoccantminutos(Long hcoccantminutos) {
        this.hcoccantminutos = hcoccantminutos;
    }

    public Long getHcoccantminutos() {
        return hcoccantminutos;
    }

    public void setHcoccduracion(String hcoccduracion) {
        this.hcoccduracion = hcoccduracion;
    }

    public String getHcoccduracion() {
        return hcoccduracion;
    }

    public void setReciente(String reciente) {
        this.reciente = reciente;
    }

    public String getReciente() {
        return reciente;
    }

    public void setRenderOxigeno(boolean renderOxigeno) {
        this.renderOxigeno = renderOxigeno;
    }

    public boolean isRenderOxigeno() {
        renderOxigeno = false; 
        if( hcocnombreord != null && hcocnombreord.equals("OX")){
            renderOxigeno = true;   
        }
        
        return renderOxigeno;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getNombreTipo() {
     //   nombreTipo = ""; 
    if(hcocnombreord != null){
        if(hcocnombreord.equals("IV")){
            nombreTipo = "Iniciar v�a oral"; 
        }
        if(hcocnombreord.equals("RV")){
            nombreTipo = "Retirar sonda vesical"; 
        }
        if(hcocnombreord.equals("TS")){
            nombreTipo = "Tomar Retirar sonda vesicalglucometria"; 
        }
        if(hcocnombreord.equals("CP")){
            nombreTipo = "Cambio de posici�n"; 
        }
        if(hcocnombreord.equals("OX")){
            nombreTipo = "Oxigeno"; 
        }
        
        if(hcocnombreord.equals("OT")){
            nombreTipo = "Otro"; 
        }
    }
        return nombreTipo;
    }
    
    


    public void setHcoccadminisoxig(String hcoccadminisoxig) {
        this.hcoccadminisoxig = hcoccadminisoxig;
    }

    public String getHcoccadminisoxig() {
        return hcoccadminisoxig;
    }

    public void setHcocdfechadminis(Date hcocdfechadminis) {
        this.hcocdfechadminis = hcocdfechadminis;
    }

    public Date getHcocdfechadminis() {
        return hcocdfechadminis;
    }

    public void setHcoccadminoxigdesc(String hcoccadminoxigdesc) {
        this.hcoccadminoxigdesc = hcoccadminoxigdesc;
    }

    public String getHcoccadminoxigdesc() {
        return hcoccadminoxigdesc;
    }

    public void setHcoccestadoadminox(String hcoccestadoadminox) {
        this.hcoccestadoadminox = hcoccestadoadminox;
    }

    public String getHcoccestadoadminox() {
        return hcoccestadoadminox;
    }


    public void setRenderOxigenoCriterio(boolean renderOxigenoCriterio) {
        this.renderOxigenoCriterio = renderOxigenoCriterio;
    }

    public boolean isRenderOxigenoCriterio() {
        renderOxigenoCriterio = false; 
        if(hcocsistoxige==null){
            renderOxigeno = false;
        }else if( hcocsistoxige != null && hcocsistoxige.equals("S")){
            renderOxigeno = false;   
        } else if( hcocsistoxige != null && hcocsistoxige.equals("N")){
            renderOxigeno = true;   
        }
    
        
      return renderOxigenoCriterio;
    }

    public void setNombreSistemaOx(String nombreSistemaOx) {
        this.nombreSistemaOx = nombreSistemaOx;
    }

    public String getNombreSistemaOx() {
        
        if(hcocsistoxige != null){
            if(hcocsistoxige.equals("MA")){
                nombreSistemaOx = "Mascara"; 
            }
            if(hcocsistoxige.equals("CA")){
                nombreSistemaOx = "Canula"; 
            }
            if(hcocsistoxige.equals("VE")){
                nombreSistemaOx = "Ventury"; 
            }
           
        }
            return nombreSistemaOx;
        }

    public void setHcodhorainioxi(Date hcodhorainioxi) {
        this.hcodhorainioxi = hcodhorainioxi;
    }

    public Date getHcodhorainioxi() {
        return hcodhorainioxi;
    }

    public void setHcodhorafinoxi(Date hcodhorafinoxi) {
        this.hcodhorafinoxi = hcodhorafinoxi;
    }

    public Date getHcodhorafinoxi() {
        return hcodhorafinoxi;
    }

    public void setHcolusuario(Long hcolusuario) {
        this.hcolusuario = hcolusuario;
    }

    public Long getHcolusuario() {
        return hcolusuario;
    }
}
