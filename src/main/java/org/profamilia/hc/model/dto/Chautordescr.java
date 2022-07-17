package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;



/** @author Hibernate CodeGenerator */
public class Chautordescr implements Serializable {

    /** identifier field */
    private Long hadlnumero;

    /** persistent field */
    private Long hadlnumerdescr;

    /** persistent field */
    private Integer hadnconsedescr;

    /** nullable persistent field */
    private String hadcaceptsolic;

    /** nullable persistent field */
    private String hadcmotivsolic;

    /** nullable persistent field */
    private String hadcmotivrecha;

    /** persistent field */
    private Integer hadnclinica;

    /** nullable persistent field */
    private Date haddfechasolic;

    /** nullable persistent field */
    private String hadcoperasolic;

    /** nullable persistent field */
    private Date haddfecharespu;

    /** nullable persistent field */
    private String hadcoperarespu;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chautordescr() {
    }


    /**
     * @param hadlnumero
     */
    public void setHadlnumero(Long hadlnumero) {
        this.hadlnumero = hadlnumero;
    }

    /**
     * @return
     */
    public Long getHadlnumero() {
        return hadlnumero;
    }

    /**
     * @param hadlnumerdescr
     */
    public void setHadlnumerdescr(Long hadlnumerdescr) {
        this.hadlnumerdescr = hadlnumerdescr;
    }

    /**
     * @return
     */
    public Long getHadlnumerdescr() {
        return hadlnumerdescr;
    }

    /**
     * @param hadnconsedescr
     */
    public void setHadnconsedescr(Integer hadnconsedescr) {
        this.hadnconsedescr = hadnconsedescr;
    }

    /**
     * @return
     */
    public Integer getHadnconsedescr() {
        return hadnconsedescr;
    }

    /**
     * @param hadcaceptsolic
     */
    public void setHadcaceptsolic(String hadcaceptsolic) {
        this.hadcaceptsolic = hadcaceptsolic;
    }

    /**
     * @return
     */
    public String getHadcaceptsolic() {
        return hadcaceptsolic;
    }

    /**
     * @param hadcmotivsolic
     */
    public void setHadcmotivsolic(String hadcmotivsolic) {
        this.hadcmotivsolic = hadcmotivsolic;
    }

    /**
     * @return
     */
    public String getHadcmotivsolic() {
        return hadcmotivsolic;
    }

    /**
     * @param hadcmotivrecha
     */
    public void setHadcmotivrecha(String hadcmotivrecha) {
        this.hadcmotivrecha = hadcmotivrecha;
    }

    /**
     * @return
     */
    public String getHadcmotivrecha() {
        return hadcmotivrecha;
    }

    /**
     * @param hadnclinica
     */
    public void setHadnclinica(Integer hadnclinica) {
        this.hadnclinica = hadnclinica;
    }

    /**
     * @return
     */
    public Integer getHadnclinica() {
        return hadnclinica;
    }

    /**
     * @param haddfechasolic
     */
    public void setHaddfechasolic(Date haddfechasolic) {
        this.haddfechasolic = haddfechasolic;
    }

    /**
     * @return
     */
    public Date getHaddfechasolic() {
        return haddfechasolic;
    }

    /**
     * @param hadcoperasolic
     */
    public void setHadcoperasolic(String hadcoperasolic) {
        this.hadcoperasolic = hadcoperasolic;
    }

    /**
     * @return
     */
    public String getHadcoperasolic() {
        return hadcoperasolic;
    }

    /**
     * @param haddfecharespu
     */
    public void setHaddfecharespu(Date haddfecharespu) {
        this.haddfecharespu = haddfecharespu;
    }

    /**
     * @return
     */
    public Date getHaddfecharespu() {
        return haddfecharespu;
    }

    /**
     * @param hadcoperarespu
     */
    public void setHadcoperarespu(String hadcoperarespu) {
        this.hadcoperarespu = hadcoperarespu;
    }

    /**
     * @return
     */
    public String getHadcoperarespu() {
        return hadcoperarespu;
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
