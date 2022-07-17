package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chseguipsico implements Serializable {

    /** identifier field */
    private ChseguipsicoPK id;

    /** nullable persistent field */
    private String hspcoperador;
    
    /** nullable persistent field */
    private String hspcretrocumpl;
    
    /** nullable persistent field */
    private String hspcavancpsico;
    
    /** nullable persistent field */
    private String hspcrevistarea;
    
    /** nullable persistent field */
    private String hspcobsergener;

    /** nullable persistent field */
    private Date hspdfecregistr;

    /** nullable persistent field */
    private Integer version;



    /** default constructor */
    public Chseguipsico() {
        id = new ChseguipsicoPK();
    }


    /**
     * @param id
     */
    public void setId(ChseguipsicoPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChseguipsicoPK getId() {
        return id;
    }

    /**
     * @param hspcoperador
     */
    public void setHspcoperador(String hspcoperador) {
        this.hspcoperador = hspcoperador;
    }

    /**
     * @return
     */
    public String getHspcoperador() {
        return hspcoperador;
    }

    /**
     * @param hspdfecregistr
     */
    public void setHspdfecregistr(Date hspdfecregistr) {
        this.hspdfecregistr = hspdfecregistr;
    }

    /**
     * @return
     */
    public Date getHspdfecregistr() {
        return hspdfecregistr;
    }
    /**
     * @param hspcretrocumpl
     */
    public void setHspcretrocumpl(String hspcretrocumpl) {
        this.hspcretrocumpl = hspcretrocumpl;
    }

    /**
     * @return
     */
    public String getHspcretrocumpl() {
        return hspcretrocumpl;
    }

    /**
     * @param hspcavancpsico
     */
    public void setHspcavancpsico(String hspcavancpsico) {
        this.hspcavancpsico = hspcavancpsico;
    }

    /**
     * @return
     */
    public String getHspcavancpsico() {
        return hspcavancpsico;
    }

    /**
     * @param hspcrevistarea
     */
    public void setHspcrevistarea(String hspcrevistarea) {
        this.hspcrevistarea = hspcrevistarea;
    }

    /**
     * @return
     */
    public String getHspcrevistarea() {
        return hspcrevistarea;
    }

    /**
     * @param hspcobsergener
     */
    public void setHspcobsergener(String hspcobsergener) {
        this.hspcobsergener = hspcobsergener;
    }

    /**
     * @return
     */
    public String getHspcobsergener() {
        return hspcobsergener;
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

   
}
