package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chotraorden implements Serializable {

    /** identifier field */
    private ChotraordenPK id;

    /** nullable persistent field */
    private String hoocestado;

    /** nullable persistent field */
    private String hoocetapa;

    /** nullable persistent field */
    private String hoocoperaasig;

    /** nullable persistent field */
    private String hoocoperaadmi;

    /** nullable persistent field */
    private Date hoodfechaasig;

    /** nullable persistent field */
    private Date hoodfechaadmi;

    /** nullable persistent field */
    private String hoocordenenvi;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String hoocnombreord;

    /** nullable persistent field */
    private String hoocobserva;

    /** nullable persistent field */
    private String hoocoperomodif;

    /** nullable persistent field */
    private Date hoodfechamodif;

    /** nullable persistent field */
    private Integer hoonevoluconse;

    /** nullable persistent field */
    private String hoocsistoxige;

    /** nullable persistent field */
    private String hooccantlitros;

    /** nullable persistent field */
    private Long hooccantminutos;

    /** nullable persistent field */
    private String hooccduracion;

    /** nullable persistent field */
    private String hooccadminisoxig;

    /** nullable persistent field */
    private Date hoocdfechadminis;

    /** nullable persistent field */
    private String hooccadminoxigdesc;

    /** nullable persistent field */
    private String hooccestadoadminox;
    
    private boolean hoobsuspender;
    
    public  Chotraorden(){
        
    }
    


    public void setId(ChotraordenPK id) {
        this.id = id;
    }

    public ChotraordenPK getId() {
        return id;
    }

    public void setHoocestado(String hoocestado) {
        this.hoocestado = hoocestado;
    }

    public String getHoocestado() {
        return hoocestado;
    }

    public void setHoocetapa(String hoocetapa) {
        this.hoocetapa = hoocetapa;
    }

    public String getHoocetapa() {
        return hoocetapa;
    }

    public void setHoocoperaasig(String hoocoperaasig) {
        this.hoocoperaasig = hoocoperaasig;
    }

    public String getHoocoperaasig() {
        return hoocoperaasig;
    }

    public void setHoocoperaadmi(String hoocoperaadmi) {
        this.hoocoperaadmi = hoocoperaadmi;
    }

    public String getHoocoperaadmi() {
        return hoocoperaadmi;
    }

    public void setHoodfechaasig(Date hoodfechaasig) {
        this.hoodfechaasig = hoodfechaasig;
    }

    public Date getHoodfechaasig() {
        return hoodfechaasig;
    }

    public void setHoodfechaadmi(Date hoodfechaadmi) {
        this.hoodfechaadmi = hoodfechaadmi;
    }

    public Date getHoodfechaadmi() {
        return hoodfechaadmi;
    }

    public void setHoocordenenvi(String hoocordenenvi) {
        this.hoocordenenvi = hoocordenenvi;
    }

    public String getHoocordenenvi() {
        return hoocordenenvi;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHoocnombreord(String hoocnombreord) {
        this.hoocnombreord = hoocnombreord;
    }

    public String getHoocnombreord() {
        return hoocnombreord;
    }

    public void setHoocobserva(String hoocobserva) {
        this.hoocobserva = hoocobserva;
    }

    public String getHoocobserva() {
        return hoocobserva;
    }

    public void setHoocoperomodif(String hoocoperomodif) {
        this.hoocoperomodif = hoocoperomodif;
    }

    public String getHoocoperomodif() {
        return hoocoperomodif;
    }

    public void setHoodfechamodif(Date hoodfechamodif) {
        this.hoodfechamodif = hoodfechamodif;
    }

    public Date getHoodfechamodif() {
        return hoodfechamodif;
    }

    public void setHoonevoluconse(Integer hoonevoluconse) {
        this.hoonevoluconse = hoonevoluconse;
    }

    public Integer getHoonevoluconse() {
        return hoonevoluconse;
    }

    public void setHoocsistoxige(String hoocsistoxige) {
        this.hoocsistoxige = hoocsistoxige;
    }

    public String getHoocsistoxige() {
        return hoocsistoxige;
    }

    public void setHooccantlitros(String hooccantlitros) {
        this.hooccantlitros = hooccantlitros;
    }

    public String getHooccantlitros() {
        return hooccantlitros;
    }

    public void setHooccantminutos(Long hooccantminutos) {
        this.hooccantminutos = hooccantminutos;
    }

    public Long getHooccantminutos() {
        return hooccantminutos;
    }

    public void setHooccduracion(String hooccduracion) {
        this.hooccduracion = hooccduracion;
    }

    public String getHooccduracion() {
        return hooccduracion;
    }

    public void setHooccadminisoxig(String hooccadminisoxig) {
        this.hooccadminisoxig = hooccadminisoxig;
    }

    public String getHooccadminisoxig() {
        return hooccadminisoxig;
    }

    public void setHoocdfechadminis(Date hoocdfechadminis) {
        this.hoocdfechadminis = hoocdfechadminis;
    }

    public Date getHoocdfechadminis() {
        return hoocdfechadminis;
    }

    public void setHooccadminoxigdesc(String hooccadminoxigdesc) {
        this.hooccadminoxigdesc = hooccadminoxigdesc;
    }

    public String getHooccadminoxigdesc() {
        return hooccadminoxigdesc;
    }

    public void setHooccestadoadminox(String hooccestadoadminox) {
        this.hooccestadoadminox = hooccestadoadminox;
    }

    public String getHooccestadoadminox() {
        return hooccestadoadminox;
    }

    public void setHoobsuspender(boolean hoobsuspender) {
        this.hoobsuspender = hoobsuspender;
    }

    public boolean isHoobsuspender() {
        return hoobsuspender;
    }
}
