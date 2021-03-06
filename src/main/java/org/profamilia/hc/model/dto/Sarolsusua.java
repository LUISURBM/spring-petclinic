package org.profamilia.hc.model.dto;

import java.util.Date;


/**
 * Sarolsusua generated by hbm2java
 */
public class

Sarolsusua implements java.io.Serializable {

    private SarolsusuaId id;
    private Date srudfeccre;
    private String srucusucre;
    private String srucetapa;
    private Date srudfecini;
    private Date srudfecfin;
    private Integer version;

    // Constructors

    /** default constructor */
    public Sarolsusua() {
    }

    /** constructor with id */
    public
    // HS == SarolId

    Sarolsusua(SarolsusuaId id) {
        this.id = id;
    }

    // HS SEPARADOR CONSTRUCTOR

    // Property accessors

    public SarolsusuaId getId() {
        return this.id;
    }

    public void setId(SarolsusuaId id) {
        this.id = id;
    }

    public String getSrucrol() {
        if (this.id == null) {
            return null;
        }
        return this.id.getSrucrol();
    }

    public void setSrucrol(String srucrol) {
        if (this.id == null) {
            this.id = new SarolsusuaId();
        }
        this.id.setSrucrol(srucrol);
    }

    public String getSrucaplica() {
        if (this.id == null) {
            return null;
        }
        return this.id.getSrucaplica();
    }

    public void setSrucaplica(String srucaplica) {
        if (this.id == null) {
            this.id = new SarolsusuaId();
        }
        this.id.setSrucaplica(srucaplica);
    }

    public String getSrucusuari() {
        if (this.id == null) {
            return null;
        }
        return this.id.getSrucusuari();
    }

    public void setSrucusuari(String srucusuari) {
        if (this.id == null) {
            this.id = new SarolsusuaId();
        }
        this.id.setSrucusuari(srucusuari);
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public final Date getSrudfeccre() {
        return srudfeccre;
    }

    public final void setSrudfeccre(Date srudfeccre) {
        this.srudfeccre = srudfeccre;
    }

    public final String getSrucusucre() {
        return srucusucre;
    }

    public final void setSrucusucre(String srucusucre) {
        this.srucusucre = srucusucre;
    }

    public final String getSrucetapa() {
        return srucetapa;
    }

    public final void setSrucetapa(String srucetapa) {
        this.srucetapa = srucetapa;
    }

    public final Date getSrudfecini() {
        return srudfecini;
    }

    public final void setSrudfecini(Date srudfecini) {
        this.srudfecini = srudfecini;
    }

    public final Date getSrudfecfin() {
        return srudfecfin;
    }

    public final void setSrudfecfin(Date srudfecfin) {
        this.srudfecfin = srudfecfin;
    }

}

