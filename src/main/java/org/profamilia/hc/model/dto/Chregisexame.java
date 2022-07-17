package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;



/** @author Hibernate CodeGenerator */
public class Chregisexame implements Serializable {

    /** identifier field */
    private ChregisexamePK id;

    /** nullable persistent field */
    private String hreelaborclini;

    /** nullable persistent field */
    private String hreclaborclini;

    /** nullable persistent field */
    private String hreeimagediagn;

    /** nullable persistent field */
    private String hrecimagediagn;

    /** nullable persistent field */
    private String hreeestudpatol;

    /** nullable persistent field */
    private String hrecestudpatol;

    /** nullable persistent field */
    private String hreepruebembar;

    /** nullable persistent field */
    private String hrecpruebembar;

    /** nullable persistent field */
    private String hreecitologia;

    /** nullable persistent field */
    private String hreccitologia;

    /** nullable persistent field */
    private String hreecolposcopi;

    /** nullable persistent field */
    private String hreccolposcopi;

    /** nullable persistent field */
    private String hreecualexame;

    /** nullable persistent field */
    private String hreccualexame;

    /** nullable persistent field */
    private String hrecoperador;

    /** nullable persistent field */
    private Date hredfecregistr;
      
    /** nullable persistent field */
    private Integer hrenclinica; 


    /** nullable persistent field */
    private Integer version;

  
    /** default constructor */
    public Chregisexame() {
        id = new ChregisexamePK(); 
    }


    /**
     * @param id
     */
    public void setId(ChregisexamePK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChregisexamePK getId() {
        return id;
    }

    /**
     * @param hreelaborclini
     */
    public void setHreelaborclini(String hreelaborclini) {
        this.hreelaborclini = hreelaborclini;
    }

    /**
     * @return
     */
    public String getHreelaborclini() {
        return hreelaborclini;
    }

    /**
     * @param hreclaborclini
     */
    public void setHreclaborclini(String hreclaborclini) {
        this.hreclaborclini = hreclaborclini;
    }

    /**
     * @return
     */
    public String getHreclaborclini() {
        return hreclaborclini;
    }

    /**
     * @param hreeimagediagn
     */
    public void setHreeimagediagn(String hreeimagediagn) {
        this.hreeimagediagn = hreeimagediagn;
    }

    /**
     * @return
     */
    public String getHreeimagediagn() {
        return hreeimagediagn;
    }

    /**
     * @param hrecimagediagn
     */
    public void setHrecimagediagn(String hrecimagediagn) {
        this.hrecimagediagn = hrecimagediagn;
    }

    /**
     * @return
     */
    public String getHrecimagediagn() {
        return hrecimagediagn;
    }

    /**
     * @param hreeestudpatol
     */
    public void setHreeestudpatol(String hreeestudpatol) {
        this.hreeestudpatol = hreeestudpatol;
    }

    /**
     * @return
     */
    public String getHreeestudpatol() {
        return hreeestudpatol;
    }

    /**
     * @param hrecestudpatol
     */
    public void setHrecestudpatol(String hrecestudpatol) {
        this.hrecestudpatol = hrecestudpatol;
    }

    /**
     * @return
     */
    public String getHrecestudpatol() {
        return hrecestudpatol;
    }

    /**
     * @param hreepruebembar
     */
    public void setHreepruebembar(String hreepruebembar) {
        this.hreepruebembar = hreepruebembar;
    }

    /**
     * @return
     */
    public String getHreepruebembar() {
        return hreepruebembar;
    }

    /**
     * @param hrecpruebembar
     */
    public void setHrecpruebembar(String hrecpruebembar) {
        this.hrecpruebembar = hrecpruebembar;
    }

    /**
     * @return
     */
    public String getHrecpruebembar() {
        return hrecpruebembar;
    }

    /**
     * @param hreecitologia
     */
    public void setHreecitologia(String hreecitologia) {
        this.hreecitologia = hreecitologia;
    }

    /**
     * @return
     */
    public String getHreecitologia() {
        return hreecitologia;
    }

    /**
     * @param hreccitologia
     */
    public void setHreccitologia(String hreccitologia) {
        this.hreccitologia = hreccitologia;
    }

    /**
     * @return
     */
    public String getHreccitologia() {
        return hreccitologia;
    }

    /**
     * @param hreecolposcopi
     */
    public void setHreecolposcopi(String hreecolposcopi) {
        this.hreecolposcopi = hreecolposcopi;
    }

    /**
     * @return
     */
    public String getHreecolposcopi() {
        return hreecolposcopi;
    }

    /**
     * @param hreccolposcopi
     */
    public void setHreccolposcopi(String hreccolposcopi) {
        this.hreccolposcopi = hreccolposcopi;
    }

    /**
     * @return
     */
    public String getHreccolposcopi() {
        return hreccolposcopi;
    }

    /**
     * @param hreecualexame
     */
    public void setHreecualexame(String hreecualexame) {
        this.hreecualexame = hreecualexame;
    }

    /**
     * @return
     */
    public String getHreecualexame() {
        return hreecualexame;
    }

    /**
     * @param hreccualexame
     */
    public void setHreccualexame(String hreccualexame) {
        this.hreccualexame = hreccualexame;
    }

    /**
     * @return
     */
    public String getHreccualexame() {
        return hreccualexame;
    }

    /**
     * @param hrecoperador
     */
    public void setHrecoperador(String hrecoperador) {
        this.hrecoperador = hrecoperador;
    }

    /**
     * @return
     */
    public String getHrecoperador() {
        return hrecoperador;
    }

    /**
     * @param hredfecregistr
     */
    public void setHredfecregistr(Date hredfecregistr) {
        this.hredfecregistr = hredfecregistr;
    }

    /**
     * @return
     */
    public Date getHredfecregistr() {
        return hredfecregistr;
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
     * @param hrenclinica
     */
    public void setHrenclinica(Integer hrenclinica) {
        this.hrenclinica = hrenclinica;
    }

    /**
     * @return
     */
    public Integer getHrenclinica() {
        return hrenclinica;
    }
}
