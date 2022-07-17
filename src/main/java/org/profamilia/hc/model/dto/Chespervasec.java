package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Clob;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chespervasec implements Serializable {

    /** identifier field */
    private Long hevlconsulta;

    /** nullable persistent field */
    private String  hevcresulesper;

    /** nullable persistent field */
    private Date hevdfechatoma;

    /** nullable persistent field */
    private Date hevdfecharesul;

    /** nullable persistent field */
    private Date hevdfechamuest;

    /** nullable persistent field */
    private String hevcesperpostv;

    /** nullable persistent field */
    private BigDecimal hevarecueesper;

    /** nullable persistent field */
    private String hevcoperador;

    /** nullable persistent field */
    private Date hevdfecregistr;

    /** persistent field */
    private String hevctiposervi;

    /** nullable persistent field */
    private Integer version;
    
    
    private String hevcesperent;

   

    /** default constructor */
    public Chespervasec() {
    }


    public void setHevlconsulta(Long hevlconsulta) {
        this.hevlconsulta = hevlconsulta;
    }

    public Long getHevlconsulta() {
        return hevlconsulta;
    }

    public void setHevcresulesper(String hevcresulesper) {
        this.hevcresulesper = hevcresulesper;
    }

    public String getHevcresulesper() {
        return hevcresulesper;
    }

    public void setHevdfechatoma(Date hevdfechatoma) {
        this.hevdfechatoma = hevdfechatoma;
    }

    public Date getHevdfechatoma() {
        return hevdfechatoma;
    }

    public void setHevdfecharesul(Date hevdfecharesul) {
        this.hevdfecharesul = hevdfecharesul;
    }

    public Date getHevdfecharesul() {
        return hevdfecharesul;
    }

    public void setHevdfechamuest(Date hevdfechamuest) {
        this.hevdfechamuest = hevdfechamuest;
    }

    public Date getHevdfechamuest() {
        return hevdfechamuest;
    }

    public void setHevcesperpostv(String hevcesperpostv) {
        this.hevcesperpostv = hevcesperpostv;
    }

    public String getHevcesperpostv() {
        return hevcesperpostv;
    }

    public void setHevarecueesper(BigDecimal hevarecueesper) {
        this.hevarecueesper = hevarecueesper;
    }

    public BigDecimal getHevarecueesper() {
        return hevarecueesper;
    }

    public void setHevcoperador(String hevcoperador) {
        this.hevcoperador = hevcoperador;
    }

    public String getHevcoperador() {
        return hevcoperador;
    }

    public void setHevdfecregistr(Date hevdfecregistr) {
        this.hevdfecregistr = hevdfecregistr;
    }

    public Date getHevdfecregistr() {
        return hevdfecregistr;
    }

    public void setHevctiposervi(String hevctiposervi) {
        this.hevctiposervi = hevctiposervi;
    }

    public String getHevctiposervi() {
        return hevctiposervi;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHevcesperent(String hevcesperent) {
        this.hevcesperent = hevcesperent;
    }

    public String getHevcesperent() {
        return hevcesperent;
    }
}
