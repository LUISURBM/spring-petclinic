package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chcertmedico implements Serializable {

    /** identifier field */
    private ChcertmedicoPK id;

    /** persistent field */
    private Date hcmdfechareg;

    /** nullable persistent field */
    private String hcmccertifica;

    /** persistent field */
    private String hcmcoperador;

    /** nullable persistent field */
    private String hcmetipoideaco;

    /** nullable persistent field */
    private Long hcmanumideacom;

    /** nullable persistent field */
    private String hcmcnombreacom;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chcertmedico() {
    }


    public void setId(ChcertmedicoPK id) {
        this.id = id;
    }

    public ChcertmedicoPK getId() {
        return id;
    }

    public void setHcmdfechareg(Date hcmdfechareg) {
        this.hcmdfechareg = hcmdfechareg;
    }

    public Date getHcmdfechareg() {
        return hcmdfechareg;
    }

    public void setHcmccertifica(String hcmccertifica) {
        this.hcmccertifica = hcmccertifica;
    }

    public String getHcmccertifica() {
        return hcmccertifica;
    }

    public void setHcmcoperador(String hcmcoperador) {
        this.hcmcoperador = hcmcoperador;
    }

    public String getHcmcoperador() {
        return hcmcoperador;
    }

    public void setHcmetipoideaco(String hcmetipoideaco) {
        this.hcmetipoideaco = hcmetipoideaco;
    }

    public String getHcmetipoideaco() {
        return hcmetipoideaco;
    }

    public void setHcmanumideacom(Long hcmanumideacom) {
        this.hcmanumideacom = hcmanumideacom;
    }

    public Long getHcmanumideacom() {
        return hcmanumideacom;
    }

    public void setHcmcnombreacom(String hcmcnombreacom) {
        this.hcmcnombreacom = hcmcnombreacom;
    }

    public String getHcmcnombreacom() {
        return hcmcnombreacom;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

}
