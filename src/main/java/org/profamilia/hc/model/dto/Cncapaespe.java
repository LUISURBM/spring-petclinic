package org.profamilia.hc.model.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Cnplanfert generated by hbm2java
 */

public class Cncapaespe implements java.io.Serializable {

	/**
	 * serialVersionUID class Cnplanfert
	 */
	private static final long serialVersionUID = 761154282710002686L;
	
	private CncapaespeId id;
        private String ccectipide;
        private BigDecimal cceanumide;
        private String ccecpacien;
        private Date ccedfeccap;
        private Integer ccenesperm;
        private Integer ccencantid;
        private Integer ccenprorap;
        private Integer ccenprolen;
        private Integer ccenpendul;
        private Integer cceninmovi;
        private Integer ccenvitali;
        private Integer ccenposcan;
        private Integer ccenposrap;
        private Integer ccenposlen;
        private Integer ccenpospen;
        private Integer ccenposinm;
        private Integer ccenposvit;
        private Integer ccennormal;
        private Integer ccenligelo;
        private Integer ccenmarelo;
        private Integer ccenanoacr;
        private Integer ccenanomul;
        private String ccexobserv;
        private Date ccedfecreg;
        private String ccecusureg;
        private BigDecimal cceavolume;
        private BigDecimal cceaposvol;
        private Integer ccenprogre;
        private Integer ccenpospgr;
        private Integer ccenanorma;
        private Integer ccenanocab;
        private Integer ccenanopie;
        private Integer ccenanofla;
        private String ccectipocp;
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
	public Cncapaespe() {
            id = new CncapaespeId();
	}

	/** constructor with id */
	// HS == CncapaespeId
	public Cncapaespe(CncapaespeId id) {
		this.id = id;
	}

	// HS SEPARADOR CONSTRUCTOR

	// Property accessors

	public CncapaespeId getId() {
        if(id == null){
            id = new CncapaespeId();
        }
        
		return this.id;
	}

	public void setId(CncapaespeId id) {
	    if(id == null){
	        id = new CncapaespeId();
	    }
		this.id = id;
	}

    public void setCcectipide(String ccectipide) {
        this.ccectipide = ccectipide;
    }

    public String getCcectipide() {
        return ccectipide;
    }

    public void setCceanumide(BigDecimal cceanumide) {
        this.cceanumide = cceanumide;
    }

    public BigDecimal getCceanumide() {
        return cceanumide;
    }

    public void setCcecpacien(String ccecpacien) {
        this.ccecpacien = ccecpacien;
    }

    public String getCcecpacien() {
        return ccecpacien;
    }

    public void setCcedfeccap(Date ccedfeccap) {
        this.ccedfeccap = ccedfeccap;
    }

    public Date getCcedfeccap() {
        return ccedfeccap;
    }

    public void setCcenesperm(Integer ccenesperm) {
        this.ccenesperm = ccenesperm;
    }

    public Integer getCcenesperm() {
        return ccenesperm;
    }

    public void setCcencantid(Integer ccencantid) {
        this.ccencantid = ccencantid;
    }

    public Integer getCcencantid() {
        return ccencantid;
    }

    public void setCcenprorap(Integer ccenprorap) {
        this.ccenprorap = ccenprorap;
    }

    public Integer getCcenprorap() {
        return ccenprorap;
    }

    public void setCcenprolen(Integer ccenprolen) {
        this.ccenprolen = ccenprolen;
    }

    public Integer getCcenprolen() {
        return ccenprolen;
    }

    public void setCcenpendul(Integer ccenpendul) {
        this.ccenpendul = ccenpendul;
    }

    public Integer getCcenpendul() {
        return ccenpendul;
    }

    public void setCceninmovi(Integer cceninmovi) {
        this.cceninmovi = cceninmovi;
    }

    public Integer getCceninmovi() {
        return cceninmovi;
    }

    public void setCcenvitali(Integer ccenvitali) {
        this.ccenvitali = ccenvitali;
    }

    public Integer getCcenvitali() {
        return ccenvitali;
    }

    public void setCcenposcan(Integer ccenposcan) {
        this.ccenposcan = ccenposcan;
    }

    public Integer getCcenposcan() {
        return ccenposcan;
    }

    public void setCcenposrap(Integer ccenposrap) {
        this.ccenposrap = ccenposrap;
    }

    public Integer getCcenposrap() {
        return ccenposrap;
    }

    public void setCcenposlen(Integer ccenposlen) {
        this.ccenposlen = ccenposlen;
    }

    public Integer getCcenposlen() {
        return ccenposlen;
    }

    public void setCcenpospen(Integer ccenpospen) {
        this.ccenpospen = ccenpospen;
    }

    public Integer getCcenpospen() {
        return ccenpospen;
    }

    public void setCcenposinm(Integer ccenposinm) {
        this.ccenposinm = ccenposinm;
    }

    public Integer getCcenposinm() {
        return ccenposinm;
    }

    public void setCcenposvit(Integer ccenposvit) {
        this.ccenposvit = ccenposvit;
    }

    public Integer getCcenposvit() {
        return ccenposvit;
    }

    public void setCcennormal(Integer ccennormal) {
        this.ccennormal = ccennormal;
    }

    public Integer getCcennormal() {
        return ccennormal;
    }

    public void setCcenligelo(Integer ccenligelo) {
        this.ccenligelo = ccenligelo;
    }

    public Integer getCcenligelo() {
        return ccenligelo;
    }

    public void setCcenmarelo(Integer ccenmarelo) {
        this.ccenmarelo = ccenmarelo;
    }

    public Integer getCcenmarelo() {
        return ccenmarelo;
    }

    public void setCcenanoacr(Integer ccenanoacr) {
        this.ccenanoacr = ccenanoacr;
    }

    public Integer getCcenanoacr() {
        return ccenanoacr;
    }

    public void setCcenanomul(Integer ccenanomul) {
        this.ccenanomul = ccenanomul;
    }

    public Integer getCcenanomul() {
        return ccenanomul;
    }

    public void setCcexobserv(String ccexobserv) {
        this.ccexobserv = ccexobserv;
    }

    public String getCcexobserv() {
        return ccexobserv;
    }

    public void setCcedfecreg(Date ccedfecreg) {
        this.ccedfecreg = ccedfecreg;
    }

    public Date getCcedfecreg() {
        return ccedfecreg;
    }

    public void setCcecusureg(String ccecusureg) {
        this.ccecusureg = ccecusureg;
    }

    public String getCcecusureg() {
        return ccecusureg;
    }

    public void setCceavolume(BigDecimal cceavolume) {
        this.cceavolume = cceavolume;
    }

    public BigDecimal getCceavolume() {
        return cceavolume;
    }

    public void setCceaposvol(BigDecimal cceaposvol) {
        this.cceaposvol = cceaposvol;
    }

    public BigDecimal getCceaposvol() {
        return cceaposvol;
    }

    public void setCcenprogre(Integer ccenprogre) {
        this.ccenprogre = ccenprogre;
    }

    public Integer getCcenprogre() {
        return ccenprogre;
    }

    public void setCcenpospgr(Integer ccenpospgr) {
        this.ccenpospgr = ccenpospgr;
    }

    public Integer getCcenpospgr() {
        return ccenpospgr;
    }

    public void setCcenanorma(Integer ccenanorma) {
        this.ccenanorma = ccenanorma;
    }

    public Integer getCcenanorma() {
        return ccenanorma;
    }

    public void setCcenanocab(Integer ccenanocab) {
        this.ccenanocab = ccenanocab;
    }

    public Integer getCcenanocab() {
        return ccenanocab;
    }

    public void setCcenanopie(Integer ccenanopie) {
        this.ccenanopie = ccenanopie;
    }

    public Integer getCcenanopie() {
        return ccenanopie;
    }

    public void setCcenanofla(Integer ccenanofla) {
        this.ccenanofla = ccenanofla;
    }

    public Integer getCcenanofla() {
        return ccenanofla;
    }

    public void setCcectipocp(String ccectipocp) {
        this.ccectipocp = ccectipocp;
    }

    public String getCcectipocp() {
        return ccectipocp;
    }
    
    public Integer getCcenclinic() {
        if (this.id == null) {
            return null;
        }
        return this.id.getCcenclinic();
    }

    public void setCcenclinic(Integer ccenclinic) {
        if (this.id == null) {
            this.id = new CncapaespeId();
        }
        this.id.setCcenclinic(ccenclinic);
    }

    public Integer getCcennumero() {
        if (this.id == null) {
            return null;
        }
        return this.id.getCcennumero();
    }

    public void setCcennumero(Integer ccennumero) {
        if (this.id == null) {
            this.id = new CncapaespeId();
        }
        this.id.setCcennumero(ccennumero);
    }

}