package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chantecfarma implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.ChantecfarmaPK comp_id;

    /** nullable persistent field */
    private String hafcaines;

    /** nullable persistent field */
    private String hafcainecual;

    /** nullable persistent field */
    private String hafcainefrecu;

    /** nullable persistent field */
    private String hafcantiagre;

    /** nullable persistent field */
    private String hafcaagrecual;

    /** nullable persistent field */
    private String hafcaagrefrecu;

    /** nullable persistent field */
    private String hafcanticoag;

    /** nullable persistent field */
    private String hafcacoagcual;

    /** nullable persistent field */
    private String hafcacoagfrec;

    /** nullable persistent field */
    private String hafcaplimedic;

    /** nullable persistent field */
    private String hafcaplmedcual;

    /** nullable persistent field */
    private String hafcaplivacu;

    /** nullable persistent field */
    private String hafcapvacucual;

    /** nullable persistent field */
    private Long haflapvacudias;

    /** nullable persistent field */
    private Date hafdfecharegis;

    /** nullable persistent field */
    private String hafcoperador;

    /** nullable persistent field */
    private Integer version;

    /** full constructor */
    public Chantecfarma(org.profamilia.hc.model.dto.ChantecfarmaPK comp_id, String hafcaines, String hafcainecual, String hafcainefrecu, String hafcantiagre, String hafcaagrecual, String hafcaagrefrecu, String hafcanticoag, String hafcacoagcual, String hafcacoagfrec, String hafcaplimedic, String hafcaplmedcual, String hafcaplivacu, String hafcapvacucual, Long haflapvacudias, Date hafdfecharegis, String hafcoperador, Integer version) {
        this.comp_id = comp_id;
        this.hafcaines = hafcaines;
        this.hafcainecual = hafcainecual;
        this.hafcainefrecu = hafcainefrecu;
        this.hafcantiagre = hafcantiagre;
        this.hafcaagrecual = hafcaagrecual;
        this.hafcaagrefrecu = hafcaagrefrecu;
        this.hafcanticoag = hafcanticoag;
        this.hafcacoagcual = hafcacoagcual;
        this.hafcacoagfrec = hafcacoagfrec;
        this.hafcaplimedic = hafcaplimedic;
        this.hafcaplmedcual = hafcaplmedcual;
        this.hafcaplivacu = hafcaplivacu;
        this.hafcapvacucual = hafcapvacucual;
        this.haflapvacudias = haflapvacudias;
        this.hafdfecharegis = hafdfecharegis;
        this.hafcoperador = hafcoperador;
        this.version = version;
    }

    /** default constructor */
    public Chantecfarma() {
    }

    /** minimal constructor */
    public Chantecfarma(org.profamilia.hc.model.dto.ChantecfarmaPK comp_id) {
        this.comp_id = comp_id;
    }

    public org.profamilia.hc.model.dto.ChantecfarmaPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(org.profamilia.hc.model.dto.ChantecfarmaPK comp_id) {
        this.comp_id = comp_id;
    }

    public String getHafcaines() {
        return this.hafcaines;
    }

    public void setHafcaines(String hafcaines) {
        this.hafcaines = hafcaines;
    }

    public String getHafcainecual() {
        return this.hafcainecual;
    }

    public void setHafcainecual(String hafcainecual) {
        this.hafcainecual = hafcainecual;
    }

    public String getHafcainefrecu() {
        return this.hafcainefrecu;
    }

    public void setHafcainefrecu(String hafcainefrecu) {
        this.hafcainefrecu = hafcainefrecu;
    }

    public String getHafcantiagre() {
        return this.hafcantiagre;
    }

    public void setHafcantiagre(String hafcantiagre) {
        this.hafcantiagre = hafcantiagre;
    }

    public String getHafcaagrecual() {
        return this.hafcaagrecual;
    }

    public void setHafcaagrecual(String hafcaagrecual) {
        this.hafcaagrecual = hafcaagrecual;
    }

    public String getHafcaagrefrecu() {
        return this.hafcaagrefrecu;
    }

    public void setHafcaagrefrecu(String hafcaagrefrecu) {
        this.hafcaagrefrecu = hafcaagrefrecu;
    }

    public String getHafcanticoag() {
        return this.hafcanticoag;
    }

    public void setHafcanticoag(String hafcanticoag) {
        this.hafcanticoag = hafcanticoag;
    }

    public String getHafcacoagcual() {
        return this.hafcacoagcual;
    }

    public void setHafcacoagcual(String hafcacoagcual) {
        this.hafcacoagcual = hafcacoagcual;
    }

    public String getHafcacoagfrec() {
        return this.hafcacoagfrec;
    }

    public void setHafcacoagfrec(String hafcacoagfrec) {
        this.hafcacoagfrec = hafcacoagfrec;
    }

    public String getHafcaplimedic() {
        return this.hafcaplimedic;
    }

    public void setHafcaplimedic(String hafcaplimedic) {
        this.hafcaplimedic = hafcaplimedic;
    }

    public String getHafcaplmedcual() {
        return this.hafcaplmedcual;
    }

    public void setHafcaplmedcual(String hafcaplmedcual) {
        this.hafcaplmedcual = hafcaplmedcual;
    }

    public String getHafcaplivacu() {
        return this.hafcaplivacu;
    }

    public void setHafcaplivacu(String hafcaplivacu) {
        this.hafcaplivacu = hafcaplivacu;
    }

    public String getHafcapvacucual() {
        return this.hafcapvacucual;
    }

    public void setHafcapvacucual(String hafcapvacucual) {
        this.hafcapvacucual = hafcapvacucual;
    }

    public Long getHaflapvacudias() {
        return this.haflapvacudias;
    }

    public void setHaflapvacudias(Long haflapvacudias) {
        this.haflapvacudias = haflapvacudias;
    }

    public Date getHafdfecharegis() {
        return this.hafdfecharegis;
    }

    public void setHafdfecharegis(Date hafdfecharegis) {
        this.hafdfecharegis = hafdfecharegis;
    }

    public String getHafcoperador() {
        return this.hafcoperador;
    }

    public void setHafcoperador(String hafcoperador) {
        this.hafcoperador = hafcoperador;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Chantecfarma) ) return false;
        Chantecfarma castOther = (Chantecfarma) other;
        return new EqualsBuilder()
            .append(this.getComp_id(), castOther.getComp_id())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getComp_id())
            .toHashCode();
    }

}
