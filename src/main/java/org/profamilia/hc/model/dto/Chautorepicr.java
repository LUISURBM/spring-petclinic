package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chautorepicr implements Serializable {

    /** identifier field */
    private Long haelnumero;

    /** persistent field */
    private Long haelnumerepicr;

    /** persistent field */
    private Integer haenconseepicr;

    /** nullable persistent field */
    private String haecaceptsolic;

    /** nullable persistent field */
    private String haecmotivsolic;

    /** nullable persistent field */
    private String haecmotivrecha;

    /** persistent field */
    private Integer haenclinica;

    /** nullable persistent field */
    private Date haedfechasolic;

    /** nullable persistent field */
    private String haecoperasolic;

    /** nullable persistent field */
    private Date haedfecharespu;

    /** nullable persistent field */
    private String haecoperarespu;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chautorepicr() {
    }


    /**
     * @param haelnumero
     */
    public void setHaelnumero(Long haelnumero) {
        this.haelnumero = haelnumero;
    }

    /**
     * @return
     */
    public Long getHaelnumero() {
        return haelnumero;
    }

    /**
     * @param haelnumerepicr
     */
    public void setHaelnumerepicr(Long haelnumerepicr) {
        this.haelnumerepicr = haelnumerepicr;
    }

    /**
     * @return
     */
    public Long getHaelnumerepicr() {
        return haelnumerepicr;
    }

    /**
     * @param haenconseepicr
     */
    public void setHaenconseepicr(Integer haenconseepicr) {
        this.haenconseepicr = haenconseepicr;
    }

    /**
     * @return
     */
    public Integer getHaenconseepicr() {
        return haenconseepicr;
    }

    /**
     * @param haecaceptsolic
     */
    public void setHaecaceptsolic(String haecaceptsolic) {
        this.haecaceptsolic = haecaceptsolic;
    }

    /**
     * @return
     */
    public String getHaecaceptsolic() {
        return haecaceptsolic;
    }

    /**
     * @param haecmotivsolic
     */
    public void setHaecmotivsolic(String haecmotivsolic) {
        this.haecmotivsolic = haecmotivsolic;
    }

    /**
     * @return
     */
    public String getHaecmotivsolic() {
        return haecmotivsolic;
    }

    /**
     * @param haecmotivrecha
     */
    public void setHaecmotivrecha(String haecmotivrecha) {
        this.haecmotivrecha = haecmotivrecha;
    }

    /**
     * @return
     */
    public String getHaecmotivrecha() {
        return haecmotivrecha;
    }

    /**
     * @param haenclinica
     */
    public void setHaenclinica(Integer haenclinica) {
        this.haenclinica = haenclinica;
    }

    /**
     * @return
     */
    public Integer getHaenclinica() {
        return haenclinica;
    }

    /**
     * @param haedfechasolic
     */
    public void setHaedfechasolic(Date haedfechasolic) {
        this.haedfechasolic = haedfechasolic;
    }

    /**
     * @return
     */
    public Date getHaedfechasolic() {
        return haedfechasolic;
    }

    /**
     * @param haecoperasolic
     */
    public void setHaecoperasolic(String haecoperasolic) {
        this.haecoperasolic = haecoperasolic;
    }

    /**
     * @return
     */
    public String getHaecoperasolic() {
        return haecoperasolic;
    }

    /**
     * @param haedfecharespu
     */
    public void setHaedfecharespu(Date haedfecharespu) {
        this.haedfecharespu = haedfecharespu;
    }

    /**
     * @return
     */
    public Date getHaedfecharespu() {
        return haedfecharespu;
    }

    /**
     * @param haecoperarespu
     */
    public void setHaecoperarespu(String haecoperarespu) {
        this.haecoperarespu = haecoperarespu;
    }

    /**
     * @return
     */
    public String getHaecoperarespu() {
        return haecoperarespu;
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
