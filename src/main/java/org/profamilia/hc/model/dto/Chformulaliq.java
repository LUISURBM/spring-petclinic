package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chformulaliq implements Serializable {

    /** identifier field */
    private ChformulaliqPK id;

    /** nullable persistent field */
    private String hflcnombreliqu;

    /** nullable persistent field */
    private Integer hflncantidad;

    /** nullable persistent field */
    private Integer hflnvelocidadm;

    /** nullable persistent field */
    private String hflcviadminist;

    /** nullable persistent field */
    private String hflcformadmins;

   /** nullable persistent field */
    private Date hfldfecregistr;

    /** nullable persistent field */
    private String hflcoperador;

    /** nullable persistent field */
    private Integer version;

    /** Variable que almacen la descripci�n de la forma de administracion*/
    private String wdescforma;


    /** nullable persistent field */
    private String hflctiposangre;

    /** nullable persistent field */
    private String hflcgrupsangre;

    /** nullable persistent field */
    private String hflcfactosangre;

    /** nullable persistent field */
    private Integer hflnunidasangr;

    /** nullable persistent field */
    private Integer hflnsellocalid;

    /** nullable persistent field */
    private Date hfldsangrvenci;

    private String hflcdesctipoli;

    /** nullable persistent field */
    private String hflcestado;

    private boolean hflbrendersusp;

    private boolean hflbsuspender;
    
    /** nullable persistent field */
    private Long hfllusuario; 
    
    /** nullable persistent field */
    private String hflctiposerv; 
    
    /** nullable persistent field */
    private String hflctiposoluci;

    /** nullable persistent field */
    private String hflcotroliquid;
    
    /** nullable persistent field */
    private String hlacdescrsoluc;
    
    private String nombreOperador;
    
   
    

    /** default constructor */
    public Chformulaliq() {
    }


    /**
     * @param id
     */
    public void setId(ChformulaliqPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChformulaliqPK getId() {
        return id;
    }

    /**
     * @param hflcnombreliqu
     */
    public void setHflcnombreliqu(String hflcnombreliqu) {
        this.hflcnombreliqu = hflcnombreliqu;
    }

    /**
     * @return
     */
    public String getHflcnombreliqu() {
        return hflcnombreliqu;
    }

    /**
     * @param hflncantidad
     */
    public void setHflncantidad(Integer hflncantidad) {
        this.hflncantidad = hflncantidad;
    }

    /**
     * @return
     */
    public Integer getHflncantidad() {
        return hflncantidad;
    }

    /**
     * @param hflnvelocidadm
     */
    public void setHflnvelocidadm(Integer hflnvelocidadm) {
        this.hflnvelocidadm = hflnvelocidadm;
    }

    /**
     * @return
     */
    public Integer getHflnvelocidadm() {
        return hflnvelocidadm;
    }

    /**
     * @param hflcviadminist
     */
    public void setHflcviadminist(String hflcviadminist) {
        this.hflcviadminist = hflcviadminist;
    }

    /**
     * @return
     */
    public String getHflcviadminist() {
        return hflcviadminist;
    }

    /**
     * @param hflcformadmins
     */
    public void setHflcformadmins(String hflcformadmins) {
        this.hflcformadmins = hflcformadmins;
    }

    /**
     * @return
     */
    public String getHflcformadmins() {
        return hflcformadmins;
    }

    /**
     * @param hfldfecregistr
     */
    public void setHfldfecregistr(Date hfldfecregistr) {
        this.hfldfecregistr = hfldfecregistr;
    }

    /**
     * @return
     */
    public Date getHfldfecregistr() {
        return hfldfecregistr;
    }

    /**
     * @param hflcoperador
     */
    public void setHflcoperador(String hflcoperador) {
        this.hflcoperador = hflcoperador;
    }

    /**
     * @return
     */
    public String getHflcoperador() {
        return hflcoperador;
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
     * @param hflctiposangre
     */
    public void setHflctiposangre(String hflctiposangre) {
        this.hflctiposangre = hflctiposangre;
    }

    /**
     * @return
     */
    public String getHflctiposangre() {
        return hflctiposangre;
    }

    /**
     * @param hflcgrupsangre
     */
    public void setHflcgrupsangre(String hflcgrupsangre) {
        this.hflcgrupsangre = hflcgrupsangre;
    }

    /**
     * @return
     */
    public String getHflcgrupsangre() {
        return hflcgrupsangre;
    }

    /**
     * @param hflcfactosangre
     */
    public void setHflcfactosangre(String hflcfactosangre) {
        this.hflcfactosangre = hflcfactosangre;
    }

    /**
     * @return
     */
    public String getHflcfactosangre() {
        return hflcfactosangre;
    }

    /**
     * @param hflnunidasangr
     */
    public void setHflnunidasangr(Integer hflnunidasangr) {
        this.hflnunidasangr = hflnunidasangr;
    }

    /**
     * @return
     */
    public Integer getHflnunidasangr() {
        return hflnunidasangr;
    }

    /**
     * @param hflnsellocalid
     */
    public void setHflnsellocalid(Integer hflnsellocalid) {
        this.hflnsellocalid = hflnsellocalid;
    }

    /**
     * @return
     */
    public Integer getHflnsellocalid() {
        return hflnsellocalid;
    }

    /**
     * @param hfldsangrvenci
     */
    public void setHfldsangrvenci(Date hfldsangrvenci) {
        this.hfldsangrvenci = hfldsangrvenci;
    }

    /**
     * @return
     */
    public Date getHfldsangrvenci() {
        return hfldsangrvenci;
    }

    /**
     * @param wdescforma
     */
    public void setWdescforma(String wdescforma) {
        this.wdescforma = wdescforma;
    }


    /**
     * @return
     */
    public String getWdescforma() {
        if (this.getHflcformadmins() != null) {
            if (this.getHflcformadmins().equals("L")) {
                wdescforma = "Bolo";
            }
            if (this.getHflcformadmins().equals("I")) {
                wdescforma = "Infusi�n";
            }
        }

        return wdescforma;
    }


    public void setHflcdesctipoli(String hflcdesctipoli) {
        this.hflcdesctipoli = hflcdesctipoli;
    }

    public String getHflcdesctipoli() {
        if (hflcnombreliqu != null) {
            if (hflcnombreliqu.equals("01")) {
                hflcdesctipoli = "Lactato de Ringer";
            }else  if (hflcnombreliqu.equals("02")) {
                hflcdesctipoli = "Haemacell";
            } else  if (hflcnombreliqu.equals("03")) {
                hflcdesctipoli = "Dextranes";
            }else if (hflcnombreliqu.equals("04")) {
                hflcdesctipoli = "Globulos Rojos";
            }else  if (hflcnombreliqu.equals("05")) {
                hflcdesctipoli = "Sangre total";
            }else if (hflcnombreliqu.equals("06")) {
                hflcdesctipoli = "Plasma";
            }else if (hflcnombreliqu.equals("07")) {
                hflcdesctipoli = "Plaquetas";
            } else if (hflcnombreliqu.equals("08")) {
                hflcdesctipoli = "Soluci�n Salina Normal 0.9%";
            }else{
                hflcdesctipoli = hflcnombreliqu;
            }
        }
        return hflcdesctipoli;
    }

    /**
     * @param hflcestado
     */
    public void setHflcestado(String hflcestado) {
        this.hflcestado = hflcestado;
    }

    /**
     * @return
     */
    public String getHflcestado() {
        return hflcestado;
    }

    /**
     * @param hflbrendersusp
     */
    public void setHflbrendersusp(boolean hflbrendersusp) {
        this.hflbrendersusp = hflbrendersusp;
    }

    /**
     * @return
     */
    public boolean isHflbrendersusp() {
        if (hflcestado != null) {
            if (hflcestado.equals("SP")) {
                hflbrendersusp = false;
            } else {
                hflbrendersusp = true;
            }
        }
        return hflbrendersusp;
    }

    /**
     * @param hflbsuspender
     */
    public void setHflbsuspender(boolean hflbsuspender) {
        this.hflbsuspender = hflbsuspender;
    }

    /**
     * @return
     */
    public boolean isHflbsuspender() {
        return hflbsuspender;
    }


    /**
     * @param hfllusuario
     */
    public void setHfllusuario(Long hfllusuario) {
        this.hfllusuario = hfllusuario;
    }

    /**
     * @return
     */
    public Long getHfllusuario() {
        return hfllusuario;
    }

    /**
     * @param hflctiposerv
     */
    public void setHflctiposerv(String hflctiposerv) {
        this.hflctiposerv = hflctiposerv;
    }

    /**
     * @return
     */
    public String getHflctiposerv() {
        return hflctiposerv;
    }
    /**
     * @param hflctiposoluci
     */
    public void setHflctiposoluci(String hflctiposoluci) {
        this.hflctiposoluci = hflctiposoluci;
    }

    /**
     * @return
     */
    public String getHflctiposoluci() {
        return hflctiposoluci;
    }

    /**
     * @param hflcotroliquid
     */
    public void setHflcotroliquid(String hflcotroliquid) {
        this.hflcotroliquid = hflcotroliquid;
    }

    /**
     * @return
     */
    public String getHflcotroliquid() {
        return hflcotroliquid;
    }

    public void setHlacdescrsoluc(String hlacdescrsoluc) {
        this.hlacdescrsoluc = hlacdescrsoluc;
    }

    public String getHlacdescrsoluc() {
        hlacdescrsoluc = "";
        if (hflctiposoluci != null && !hflctiposoluci.equals(""))
            if (hflctiposoluci.equals("01")) {
                hlacdescrsoluc = "Lactato de Ringer";
            }

        if (hflctiposoluci.equals("02")) {
            hlacdescrsoluc = "Haemacell";
        }

        if (hflctiposoluci.equals("03")) {
            hlacdescrsoluc = "Dextranes";
        }

        if (hflctiposoluci.equals("04")) {
            hlacdescrsoluc = "Globulos Rojos";
        }

        if (hflctiposoluci.equals("05")) {
            hlacdescrsoluc = "Sangre total";
        }

        if (hflctiposoluci.equals("06")) {
            hlacdescrsoluc = "Plasma";
        }

        if (hflctiposoluci.equals("07")) {
            hlacdescrsoluc = "Plaquetas";
        }
        return hlacdescrsoluc;
    }


    public void setNombreOperador(String nombreOperador) {
        this.nombreOperador = nombreOperador;
    }

    public String getNombreOperador() {
        return nombreOperador;
    }
}
