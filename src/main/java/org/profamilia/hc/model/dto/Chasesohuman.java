package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

/** @author Hibernate CodeGenerator */
public class Chasesohuman implements Serializable {

    /** identifier field */
    private Long hahlnumero;

    /** persistent field */
    private String hahetipoiden;

    /** persistent field */
    private Long hahanumeiden;

    /** persistent field */
    private Long hahlnumusu;

    /** persistent field */
    private String hahcprimernomb;

    /** nullable persistent field */
    private String hahcsegundnomb;

    /** persistent field */
    private String hahcprimerapel;

    /** nullable persistent field */
    private String hahcsegundapel;

    /** nullable persistent field */
    private String hahesexo;

    /** nullable persistent field */
    private Date hahdfechanacim;

    /** persistent field */
    private Date hahdfecregistr;

    /** persistent field */
    private String hahcoperador;

    /** persistent field */
    private String haheestado;

    /** nullable persistent field */
    private Integer hahnfinanciado;

    /** nullable persistent field */
    private Integer hahnclinica;

    /** persistent field */
    private String hahetipoaseso;

    /** persistent field */
    private Date hahdfechaaseso;

    /** nullable persistent field */
    private Integer hahnedad;

    /** nullable persistent field */
    private Integer version;
    
    /** nullable persistent field */
    private String wdesctipoase;

 
    /** default constructor */
    public Chasesohuman() {
    }

    /**
     * @return
     */
    public Long getHahlnumero() {
        return this.hahlnumero;
    }

    /**
     * @param hahlnumero
     */
    public void setHahlnumero(Long hahlnumero) {
        this.hahlnumero = hahlnumero;
    }

    /**
     * @return
     */
    public String getHahetipoiden() {
        return this.hahetipoiden;
    }

    /**
     * @param hahetipoiden
     */
    public void setHahetipoiden(String hahetipoiden) {
        this.hahetipoiden = hahetipoiden;
    }

    /**
     * @return
     */
    public Long getHahanumeiden() {
        return this.hahanumeiden;
    }

    /**
     * @param hahanumeiden
     */
    public void setHahanumeiden(Long hahanumeiden) {
        this.hahanumeiden = hahanumeiden;
    }

    /**
     * @return
     */
    public Long getHahlnumusu() {
        return this.hahlnumusu;
    }

    /**
     * @param hahlnumusu
     */
    public void setHahlnumusu(Long hahlnumusu) {
        this.hahlnumusu = hahlnumusu;
    }

    /**
     * @return
     */
    public String getHahcprimernomb() {
        return this.hahcprimernomb;
    }

    /**
     * @param hahcprimernomb
     */
    public void setHahcprimernomb(String hahcprimernomb) {
        this.hahcprimernomb = hahcprimernomb;
    }

    /**
     * @return
     */
    public String getHahcsegundnomb() {
        return this.hahcsegundnomb;
    }

    /**
     * @param hahcsegundnomb
     */
    public void setHahcsegundnomb(String hahcsegundnomb) {
        this.hahcsegundnomb = hahcsegundnomb;
    }

    /**
     * @return
     */
    public String getHahcprimerapel() {
        return this.hahcprimerapel;
    }

    /**
     * @param hahcprimerapel
     */
    public void setHahcprimerapel(String hahcprimerapel) {
        this.hahcprimerapel = hahcprimerapel;
    }

    /**
     * @return
     */
    public String getHahcsegundapel() {
        return this.hahcsegundapel;
    }

    /**
     * @param hahcsegundapel
     */
    public void setHahcsegundapel(String hahcsegundapel) {
        this.hahcsegundapel = hahcsegundapel;
    }

    /**
     * @return
     */
    public String getHahesexo() {
        return this.hahesexo;
    }

    /**
     * @param hahesexo
     */
    public void setHahesexo(String hahesexo) {
        this.hahesexo = hahesexo;
    }

    /**
     * @return
     */
    public Date getHahdfechanacim() {
        return this.hahdfechanacim;
    }

    /**
     * @param hahdfechanacim
     */
    public void setHahdfechanacim(Date hahdfechanacim) {
        this.hahdfechanacim = hahdfechanacim;
    }

    /**
     * @return
     */
    public Date getHahdfecregistr() {
        return this.hahdfecregistr;
    }

    /**
     * @param hahdfecregistr
     */
    public void setHahdfecregistr(Date hahdfecregistr) {
        this.hahdfecregistr = hahdfecregistr;
    }

    /**
     * @return
     */
    public String getHahcoperador() {
        return this.hahcoperador;
    }

    /**
     * @param hahcoperador
     */
    public void setHahcoperador(String hahcoperador) {
        this.hahcoperador = hahcoperador;
    }

    /**
     * @return
     */
    public String getHaheestado() {
        return this.haheestado;
    }

    /**
     * @param haheestado
     */
    public void setHaheestado(String haheestado) {
        this.haheestado = haheestado;
    }

    /**
     * @return
     */
    public Integer getHahnfinanciado() {
        return this.hahnfinanciado;
    }

    /**
     * @param hahnfinanciado
     */
    public void setHahnfinanciado(Integer hahnfinanciado) {
        this.hahnfinanciado = hahnfinanciado;
    }

    /**
     * @return
     */
    public Integer getHahnclinica() {
        return this.hahnclinica;
    }

    /**
     * @param hahnclinica
     */
    public void setHahnclinica(Integer hahnclinica) {
        this.hahnclinica = hahnclinica;
    }

    /**
     * @return
     */
    public String getHahetipoaseso() {
        return this.hahetipoaseso;
    }

    /**
     * @param hahetipoaseso
     */
    public void setHahetipoaseso(String hahetipoaseso) {
        this.hahetipoaseso = hahetipoaseso;
    }

    /**
     * @return
     */
    public Date getHahdfechaaseso() {
        return this.hahdfechaaseso;
    }

    /**
     * @param hahdfechaaseso
     */
    public void setHahdfechaaseso(Date hahdfechaaseso) {
        this.hahdfechaaseso = hahdfechaaseso;
    }

    /**
     * @return
     */
    public Integer getHahnedad() {
        if (this.hahdfechanacim != null)
            setHahnedad(calcularEdad(this.hahdfechanacim));

        return hahnedad;
        }
        
    /**
     * @param hahnedad
     */
    public void setHahnedad(Integer hahnedad) {
        this.hahnedad = hahnedad;
    }

    /**
     * @return
     */
    public Integer getVersion() {
        return this.version;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
    
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


    /**
     * @param wdesctipoase
     */
    public void setWdesctipoase(String wdesctipoase) {
        this.wdesctipoase = wdesctipoase;
    }

    /**
     * @return
     */
    public String getWdesctipoase() {
        wdesctipoase = ""; 
        String codasesoria = ""; 
    if(hahetipoaseso!= null &&  !hahetipoaseso.equals("")){
      
            StringTokenizer st = 
                new StringTokenizer(hahetipoaseso, 
                                    ",");
                                    
            while(st.hasMoreTokens()){
                codasesoria = (String)st.nextElement(); 
                
                if(codasesoria.equals("1")){
                    wdesctipoase = wdesctipoase + "Actividades Educativas - Planificaci�n Familiar" + ", "; 
                }
                else if(codasesoria.equals("2")){
                    wdesctipoase = wdesctipoase + "Actividades educativas - Prevenci�n C�ncer"  + ", "; 
                }
                else if(codasesoria.equals("3")){
                    wdesctipoase =  wdesctipoase + "Actividades Educativas- ITS - VIH/SIDA"  + ", "; 
                }
                else if(codasesoria.equals("4")){
                    wdesctipoase = wdesctipoase + "DSR - Violencia Intrafamiliar y Abuso Sexual"  + ", "; 
                }
                else if(codasesoria.equals("5")){
                    wdesctipoase = wdesctipoase + "Act. Educ. Salud B�sica Familiar"  + ", "; 
                }
                else if(codasesoria.equals("6")){
                    wdesctipoase = wdesctipoase + "Asesor�a Personalizada"  + ", "; 
                } 
            }
            
        if(wdesctipoase != null && wdesctipoase.length() > 1)
        {
            wdesctipoase = wdesctipoase.substring(0, wdesctipoase.length() - 2);
        }
            
            
            
        
    }
    
        return wdesctipoase;
    }
}
