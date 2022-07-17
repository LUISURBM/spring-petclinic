package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chlibrovph implements Serializable {

    /** identifier field */
    private Long hlvnconsec;

    /** persistent field */
    private String hlvcprimernomb;

    /** nullable persistent field */
    private String hlvcsegundnomb;

    /** persistent field */
    private String hlvcprimerapel;

    /** nullable persistent field */
    private String hlvcsegundapel;

    /** persistent field */
    private String hlvetipoiden;

    /** persistent field */
    private Long hlvanumeiden;

    /** nullable persistent field */
    private String hlvcnombrerecl;

    /** nullable persistent field */
    private String hlvcoperador;

    /** nullable persistent field */
    private Date hlvdfecregistr;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String hlvcparentesco;

    /** nullable persistent field */
    private String hlvcconducta;

    /** full constructor */
    public Chlibrovph(Long hlvnconsec, String hlvcprimernomb, String hlvcsegundnomb, String hlvcprimerapel, String hlvcsegundapel, String hlvetipoiden, Long hlvanumeiden, String hlvcnombrerecl, String hlvcoperador, Date hlvdfecregistr, Integer version, String hlvcparentesco, String hlvcconducta) {
        this.hlvnconsec = hlvnconsec;
        this.hlvcprimernomb = hlvcprimernomb;
        this.hlvcsegundnomb = hlvcsegundnomb;
        this.hlvcprimerapel = hlvcprimerapel;
        this.hlvcsegundapel = hlvcsegundapel;
        this.hlvetipoiden = hlvetipoiden;
        this.hlvanumeiden = hlvanumeiden;
        this.hlvcnombrerecl = hlvcnombrerecl;
        this.hlvcoperador = hlvcoperador;
        this.hlvdfecregistr = hlvdfecregistr;
        this.version = version;
        this.hlvcparentesco = hlvcparentesco;
        this.hlvcconducta = hlvcconducta;
    }

    /** default constructor */
    public Chlibrovph() {
    }

    /** minimal constructor */
    public Chlibrovph(Long hlvnconsec, String hlvcprimernomb, String hlvcprimerapel, String hlvetipoiden, Long hlvanumeiden) {
        this.hlvnconsec = hlvnconsec;
        this.hlvcprimernomb = hlvcprimernomb;
        this.hlvcprimerapel = hlvcprimerapel;
        this.hlvetipoiden = hlvetipoiden;
        this.hlvanumeiden = hlvanumeiden;
    }

    public Long getHlvnconsec() {
        return this.hlvnconsec;
    }

    public void setHlvnconsec(Long hlvnconsec) {
        this.hlvnconsec = hlvnconsec;
    }

    public String getHlvcprimernomb() {
        return this.hlvcprimernomb;
    }

    public void setHlvcprimernomb(String hlvcprimernomb) {
        this.hlvcprimernomb = hlvcprimernomb;
    }

    public String getHlvcsegundnomb() {
        return this.hlvcsegundnomb;
    }

    public void setHlvcsegundnomb(String hlvcsegundnomb) {
        this.hlvcsegundnomb = hlvcsegundnomb;
    }

    public String getHlvcprimerapel() {
        return this.hlvcprimerapel;
    }

    public void setHlvcprimerapel(String hlvcprimerapel) {
        this.hlvcprimerapel = hlvcprimerapel;
    }

    public String getHlvcsegundapel() {
        return this.hlvcsegundapel;
    }

    public void setHlvcsegundapel(String hlvcsegundapel) {
        this.hlvcsegundapel = hlvcsegundapel;
    }

    public String getHlvetipoiden() {
        return this.hlvetipoiden;
    }

    public void setHlvetipoiden(String hlvetipoiden) {
        this.hlvetipoiden = hlvetipoiden;
    }

    public Long getHlvanumeiden() {
        return this.hlvanumeiden;
    }

    public void setHlvanumeiden(Long hlvanumeiden) {
        this.hlvanumeiden = hlvanumeiden;
    }

    public String getHlvcnombrerecl() {
        return this.hlvcnombrerecl;
    }

    public void setHlvcnombrerecl(String hlvcnombrerecl) {
        this.hlvcnombrerecl = hlvcnombrerecl;
    }

    public String getHlvcoperador() {
        return this.hlvcoperador;
    }

    public void setHlvcoperador(String hlvcoperador) {
        this.hlvcoperador = hlvcoperador;
    }

    public Date getHlvdfecregistr() {
        return this.hlvdfecregistr;
    }

    public void setHlvdfecregistr(Date hlvdfecregistr) {
        this.hlvdfecregistr = hlvdfecregistr;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getHlvcparentesco() {
        return this.hlvcparentesco;
    }

    public void setHlvcparentesco(String hlvcparentesco) {
        this.hlvcparentesco = hlvcparentesco;
    }

    public String getHlvcconducta() {
        return this.hlvcconducta;
    }

    public void setHlvcconducta(String hlvcconducta) {
        this.hlvcconducta = hlvcconducta;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hlvnconsec", getHlvnconsec())
            .toString();
    }

}
