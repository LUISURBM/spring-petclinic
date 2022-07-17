package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;



/** @author Hibernate CodeGenerator */
public class Chremisilve implements Serializable {

    /** identifier field */
    private ChremisilvePK id;

    /** persistent field */
    private String hriccertimedic;

    /** nullable persistent field */
    private String hrictiporemis;

    /** nullable persistent field */
    private String hricotroremis;

    /** persistent field */
    private String hricoperador;

    /** persistent field */
    private Date hridfecreg;

    /** nullable persistent field */
    private Integer version;
        
    /** nullable persistent field */
    private String hricmetodplani;

    /** nullable persistent field */
    private String hricotrometod;
    
    /** nullable persistent field */
    private String hricaceptpacie; 
    
    /** nullable persistent field */
    private String hricmotivrecha; 
    
    /** nullable persistent field */
    private String hriccausailve; 
    
    /** nullable persistent field */
    private String hriccausailve2; 


    /** nullable persistent field */
    private String hriccausailve3; 

    /** nullable persistent field */
    private String hricdeseaplan; 

    /** nullable persistent field */
    private String hricsumiprofa; 

    /** nullable persistent field */
    private String hricsumiprofno; 

    /** nullable persistent field */
    private String hricsumiotro; 
    
    /** nullable persistent field */
    private String hricescogvolun; 
    
    /** nullable persistent field */
    private String hricdesinvoem; 
    
    /** nullable persistent field */
    private String hricpsicosocial; 
    
    /** nullable persistent field */
    private String hricdescrpsico; 
    
    /** nullable persistent field */
    private String hricantemedi;
    
    /** nullable persistent field */
    private String hricdesantmed; 
    
    /** nullable persistent field */
    private String hricobserplan;
    
    private String hricinicimetod;

    /** default constructor */
    public Chremisilve() {
        id = new ChremisilvePK ();
    }


    /**
     * @param id
     */
    public void setId(ChremisilvePK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChremisilvePK getId() {
        return id;
    }

    /**
     * @param hriccertimedic
     */
    public void setHriccertimedic(String hriccertimedic) {
        this.hriccertimedic = hriccertimedic;
    }

    /**
     * @return
     */
    public String getHriccertimedic() {
        return hriccertimedic;
    }

    /**
     * @param hrictiporemis
     */
    public void setHrictiporemis(String hrictiporemis) {
        this.hrictiporemis = hrictiporemis;
    }

    /**
     * @return
     */
    public String getHrictiporemis() {
        return hrictiporemis;
    }

    /**
     * @param hricotroremis
     */
    public void setHricotroremis(String hricotroremis) {
        this.hricotroremis = hricotroremis;
    }

    /**
     * @return
     */
    public String getHricotroremis() {
        return hricotroremis;
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
     * @param hricoperador
     */
    public void setHricoperador(String hricoperador) {
        this.hricoperador = hricoperador;
    }

    /**
     * @return
     */
    public String getHricoperador() {
        return hricoperador;
    }

    /**
     * @param hridfecreg
     */
    public void setHridfecreg(Date hridfecreg) {
        this.hridfecreg = hridfecreg;
    }

    /**
     * @return
     */
    public Date getHridfecreg() {
        return hridfecreg;
    }

    /**
     * @param hricmetodplani
     */
    public void setHricmetodplani(String hricmetodplani) {
        this.hricmetodplani = hricmetodplani;
    }

    /**
     * @return
     */
    public String getHricmetodplani() {
        return hricmetodplani;
    }

    /**
     * @param hricotrometod
     */
    public void setHricotrometod(String hricotrometod) {
        this.hricotrometod = hricotrometod;
    }

    /**
     * @return
     */
    public String getHricotrometod() {
        return hricotrometod;
    }

    /**
     * @param hricaceptpacie
     */
    public void setHricaceptpacie(String hricaceptpacie) {
        this.hricaceptpacie = hricaceptpacie;
    }

    /**
     * @return
     */
    public String getHricaceptpacie() {
        return hricaceptpacie;
    }

    public void setHricmotivrecha(String hricmotivrecha) {
        this.hricmotivrecha = hricmotivrecha;
    }

    public String getHricmotivrecha() {
        return hricmotivrecha;
    }

    public void setHriccausailve(String hriccausailve) {
        this.hriccausailve = hriccausailve;
    }

    public String getHriccausailve() {
        return hriccausailve;
    }


    public void setHricdeseaplan(String hricdeseaplan) {
        this.hricdeseaplan = hricdeseaplan;
    }

    public String getHricdeseaplan() {
        return hricdeseaplan;
    }


    public void setHricsumiprofa(String hricsumiprofa) {
        this.hricsumiprofa = hricsumiprofa;
    }

    public String getHricsumiprofa() {
        return hricsumiprofa;
    }


    public void setHricsumiprofno(String hricsumiprofno) {
        this.hricsumiprofno = hricsumiprofno;
    }

    public String getHricsumiprofno() {
        return hricsumiprofno;
    }

    public void setHricsumiotro(String hricsumiotro) {
        this.hricsumiotro = hricsumiotro;
    }

    public String getHricsumiotro() {
        return hricsumiotro;
    }

    public void setHricescogvolun(String hricescogvolun) {
        this.hricescogvolun = hricescogvolun;
    }

    public String getHricescogvolun() {
        return hricescogvolun;
    }

    public void setHricdesinvoem(String hricdesinvoem) {
        this.hricdesinvoem = hricdesinvoem;
    }

    public String getHricdesinvoem() {
        return hricdesinvoem;
    }

    public void setHricpsicosocial(String hricpsicosocial) {
        this.hricpsicosocial = hricpsicosocial;
    }

    public String getHricpsicosocial() {
        return hricpsicosocial;
    }

    public void setHricdescrpsico(String hricdescrpsico) {
        this.hricdescrpsico = hricdescrpsico;
    }

    public String getHricdescrpsico() {
        return hricdescrpsico;
    }

    public void setHricantemedi(String hricantemedi) {
        this.hricantemedi = hricantemedi;
    }

    public String getHricantemedi() {
        return hricantemedi;
    }

    public void setHricdesantmed(String hricdesantmed) {
        this.hricdesantmed = hricdesantmed;
    }

    public String getHricdesantmed() {
        return hricdesantmed;
    }

    public void setHricobserplan(String hricobserplan) {
        this.hricobserplan = hricobserplan;
    }

    public String getHricobserplan() {
        return hricobserplan;
    }

    public void setHriccausailve2(String hriccausailve2) {
        this.hriccausailve2 = hriccausailve2;
    }

    public String getHriccausailve2() {
        return hriccausailve2;
    }

    public void setHriccausailve3(String hriccausailve3) {
        this.hriccausailve3 = hriccausailve3;
    }

    public String getHriccausailve3() {
        return hriccausailve3;
    }

    public void setHricinicimetod(String hricinicimetod) {
        this.hricinicimetod = hricinicimetod;
    }

    public String getHricinicimetod() {
        return hricinicimetod;
    }
}
