package org.profamilia.hc.model.dto;


import java.math.BigDecimal;

import java.util.Date;

/**
 * Ccdescempl generated by hbm2java
 */
public class

Ccdescempl implements java.io.Serializable {

    private CcdescemplId id;
    private Integer cdencantid;
    private BigDecimal cdeapordsc;
    private Integer cdengrpcmp;
    private String cdecusumod;
    private Date cdedfecmod;
    private String cdecusureg;
    private Date cdedfecreg;

    private Integer version;


    /**
     * @return the version
     */
    public final Integer getVersion() {
        return version;
    }

    /**
     * @param version
     *            the version to set
     */
    public final void setVersion(Integer version) {
        this.version = version;
    }

    // Constructors

    /** default constructor */
    public Ccdescempl() {
    }

    /** constructor with id */
    public
    // HS == CcprdxusuaId

    Ccdescempl(CcdescemplId id) {
        this.id = id;
    }

    // HS SEPARADOR CONSTRUCTOR

    // Property accessors

    public CcdescemplId getId() {
        return this.id;
    }

    public void setId(CcdescemplId id) {
        this.id = id;
    }

    public Integer getCdencantid() {
        return this.cdencantid;
    }

    public void setCdencantid(Integer cdencantid) {
        this.cdencantid = cdencantid;
    }

    public BigDecimal getCdeapordsc() {
        return this.cdeapordsc;
    }

    public void setCdeapordsc(BigDecimal cdeapordsc) {
        this.cdeapordsc = cdeapordsc;
    }

    public Date getCdedfecmod() {
        return this.cdedfecmod;
    }

    public void setCdedfecmod(Date cdedfecmod) {
        this.cdedfecmod = cdedfecmod;
    }

    public String getCdecservic() {
        if (this.id == null) {
            return null;
        }
        return this.id.getCdecservic();
    }

    public void setCdecservic(String cdecservic) {
        if (this.id == null) {
            this.id = new CcdescemplId();
        }
        this.id.setCdecservic(cdecservic);
    }

    public Integer getCdengrupo() {
        if (this.id == null) {
            return null;
        }
        return this.id.getCdengrupo();
    }

    public void setCdengrupo(Integer cdengrupo) {
        if (this.id == null) {
            this.id = new CcdescemplId();
        }
        this.id.setCdengrupo(cdengrupo);
    }

    public Integer getCdensubgru() {
        if (this.id == null) {
            return null;
        }
        return this.id.getCdensubgru();
    }

    public void setCdensubgru(Integer cdensubgru) {
        if (this.id == null) {
            this.id = new CcdescemplId();
        }
        this.id.setCdensubgru(cdensubgru);
    }

    public String getCdectipide() {
        if (this.id == null) {
            return null;
        }
        return this.id.getCdectipide();
    }

    public void setCdectipide(String cdectipide) {
        if (this.id == null) {
            this.id = new CcdescemplId();
        }
        this.id.setCdectipide(cdectipide);
    }

    public Integer getCdenanno() {
        if (this.id == null) {
            return null;
        }
        return this.id.getCdenanno();
    }

    public void setCdenanno(Integer cdenanno) {
        if (this.id == null) {
            this.id = new CcdescemplId();
        }
        this.id.setCdenanno(cdenanno);
    }

    public BigDecimal getCdeanumide() {
        if (this.id == null) {
            return null;
        }
        return this.id.getCdeanumide();
    }

    public void setCdeanumide(BigDecimal cdeanumide) {
        if (this.id == null) {
            this.id = new CcdescemplId();
        }
        this.id.setCdeanumide(cdeanumide);
    }

    public final String getCdecusumod() {
        return cdecusumod;
    }

    public final void setCdecusumod(String cdecusumod) {
        this.cdecusumod = cdecusumod;
    }

    public final String getCdecusureg() {
        return cdecusureg;
    }

    public final void setCdecusureg(String cdecusureg) {
        this.cdecusureg = cdecusureg;
    }

    public final Date getCdedfecreg() {
        return cdedfecreg;
    }

    public final void setCdedfecreg(Date cdedfecreg) {
        this.cdedfecreg = cdedfecreg;
    }

    public final Integer getCdengrpcmp() {
        return cdengrpcmp;
    }

    public final void setCdengrpcmp(Integer cdengrpcmp) {
        this.cdengrpcmp = cdengrpcmp;
    }
}
