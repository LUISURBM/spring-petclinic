package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Cfremiadmi implements Serializable {

    /** identifier field */
    private Long crannumero;

    /** persistent field */
    private Long cranadmisi;

    /** persistent field */
    private Integer cranclnorig;

    /** persistent field */
    private Integer cranclndest;

    /** persistent field */
    private Date cradfecreg;

    /** persistent field */
    private String cracusuari;

    /** persistent field */
    private String cracestado;

    /** nullable persistent field */
    private Integer version;

    /** full constructor */
    public Cfremiadmi(Long crannumero, Long cranadmisi, Integer cranclnorig, Integer cranclndest, Date cradfecreg, String cracusuari, String cracestado, Integer version) {
        this.crannumero = crannumero;
        this.cranadmisi = cranadmisi;
        this.cranclnorig = cranclnorig;
        this.cranclndest = cranclndest;
        this.cradfecreg = cradfecreg;
        this.cracusuari = cracusuari;
        this.cracestado = cracestado;
        this.version = version;
    }

    /** default constructor */
    public Cfremiadmi() {
    }

    /** minimal constructor */
    public Cfremiadmi(Long crannumero, Long cranadmisi, Integer cranclnorig, Integer cranclndest, Date cradfecreg, String cracusuari, String cracestado) {
        this.crannumero = crannumero;
        this.cranadmisi = cranadmisi;
        this.cranclnorig = cranclnorig;
        this.cranclndest = cranclndest;
        this.cradfecreg = cradfecreg;
        this.cracusuari = cracusuari;
        this.cracestado = cracestado;
    }

    public Long getCrannumero() {
        return this.crannumero;
    }

    public void setCrannumero(Long crannumero) {
        this.crannumero = crannumero;
    }

    public Long getCranadmisi() {
        return this.cranadmisi;
    }

    public void setCranadmisi(Long cranadmisi) {
        this.cranadmisi = cranadmisi;
    }

    public Integer getCranclnorig() {
        return this.cranclnorig;
    }

    public void setCranclnorig(Integer cranclnorig) {
        this.cranclnorig = cranclnorig;
    }

    public Integer getCranclndest() {
        return this.cranclndest;
    }

    public void setCranclndest(Integer cranclndest) {
        this.cranclndest = cranclndest;
    }

    public Date getCradfecreg() {
        return this.cradfecreg;
    }

    public void setCradfecreg(Date cradfecreg) {
        this.cradfecreg = cradfecreg;
    }

    public String getCracusuari() {
        return this.cracusuari;
    }

    public void setCracusuari(String cracusuari) {
        this.cracusuari = cracusuari;
    }

    public String getCracestado() {
        return this.cracestado;
    }

    public void setCracestado(String cracestado) {
        this.cracestado = cracestado;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("crannumero", getCrannumero())
            .toString();
    }

}
