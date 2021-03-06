package org.profamilia.hc.model.dto;

import java.math.BigDecimal;

import java.util.Date;


/**
 * Cnprofxcon generated by hbm2java
 */
public class Cnprofxcon implements java.io.Serializable {


    private CnprofxconId id;
    private String cpncregnod;
    private String cpncmodnod;
    private String cpnccalnod;
    private String cpnctomnod;
    private String cpncpagada;
    private BigDecimal cpnavalpag;
    private Date cpndfeccon;
    private Date cpndfecreg;
    private Date cpndfecmod;
    private Date cpndfeccal;
    private String cpncusureg;
    private String cpncusumod;
    private String cpncusucal;
    private Integer cpnnclinic;
    private String cpncestado; 
    private Integer version;

    /**
     * @return the version
     */
    public final Integer getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public final void setVersion(Integer version) {
        this.version = version;
    }
    // Constructors

    /** default constructor */
    public Cnprofxcon() {
    }

    /** constructor with id */
    public
    // HS == CnprofxconId


    Cnprofxcon(CnprofxconId id) {
        this.id = id;
    }

    // HS SEPARADOR CONSTRUCTOR


    // Property accessors


    /**
     * @return
     */
    public CnprofxconId getId() {
        return this.id;
    }

    /**
     * @param id
     */
    public void setId(CnprofxconId id) {
        this.id = id;
    }


    /**
     * @return
     */
    public String getCpncregnod() {
        return this.cpncregnod;
    }

    /**
     * @param cpncregnod
     */
    public void setCpncregnod(String cpncregnod) {
        this.cpncregnod = cpncregnod;
    }


    /**
     * @return
     */
    public String getCpncmodnod() {
        return this.cpncmodnod;
    }

    /**
     * @param cpncmodnod
     */
    public void setCpncmodnod(String cpncmodnod) {
        this.cpncmodnod = cpncmodnod;
    }


    /**
     * @return
     */
    public String getCpnccalnod() {
        return this.cpnccalnod;
    }

    /**
     * @param cpnccalnod
     */
    public void setCpnccalnod(String cpnccalnod) {
        this.cpnccalnod = cpnccalnod;
    }


    /**
     * @return
     */
    public String getCpnctomnod() {
        return this.cpnctomnod;
    }

    /**
     * @param cpnctomnod
     */
    public void setCpnctomnod(String cpnctomnod) {
        this.cpnctomnod = cpnctomnod;
    }


    /**
     * @return
     */
    public String getCpncpagada() {
        return this.cpncpagada;
    }

    /**
     * @param cpncpagada
     */
    public void setCpncpagada(String cpncpagada) {
        this.cpncpagada = cpncpagada;
    }


    /**
     * @return
     */
    public BigDecimal getCpnavalpag() {
        return this.cpnavalpag;
    }

    /**
     * @param cpnavalpag
     */
    public void setCpnavalpag(BigDecimal cpnavalpag) {
        this.cpnavalpag = cpnavalpag;
    }


    /**
     * @return
     */
    public Date getCpndfeccon() {
        return this.cpndfeccon;
    }

    /**
     * @param cpndfeccon
     */
    public void setCpndfeccon(Date cpndfeccon) {
        this.cpndfeccon = cpndfeccon;
    }


    /**
     * @return
     */
    public Date getCpndfecreg() {
        return this.cpndfecreg;
    }

    /**
     * @param cpndfecreg
     */
    public void setCpndfecreg(Date cpndfecreg) {
        this.cpndfecreg = cpndfecreg;
    }


    /**
     * @return
     */
    public Date getCpndfecmod() {
        return this.cpndfecmod;
    }

    /**
     * @param cpndfecmod
     */
    public void setCpndfecmod(Date cpndfecmod) {
        this.cpndfecmod = cpndfecmod;
    }


    /**
     * @return
     */
    public Date getCpndfeccal() {
        return this.cpndfeccal;
    }

    /**
     * @param cpndfeccal
     */
    public void setCpndfeccal(Date cpndfeccal) {
        this.cpndfeccal = cpndfeccal;
    }


    /**
     * @return
     */
    public String getCpncusureg() {
        return this.cpncusureg;
    }

    /**
     * @param cpncusureg
     */
    public void setCpncusureg(String cpncusureg) {
        this.cpncusureg = cpncusureg;
    }


    /**
     * @return
     */
    public String getCpncusumod() {
        return this.cpncusumod;
    }

    /**
     * @param cpncusumod
     */
    public void setCpncusumod(String cpncusumod) {
        this.cpncusumod = cpncusumod;
    }


    /**
     * @return
     */
    public String getCpncusucal() {
        return this.cpncusucal;
    }

    /**
     * @param cpncusucal
     */
    public void setCpncusucal(String cpncusucal) {
        this.cpncusucal = cpncusucal;
    }


    /**
     * @return
     */
    public Integer getCpnnclinic() {
        return this.cpnnclinic;
    }

    /**
     * @param cpnnclinic
     */
    public void setCpnnclinic(Integer cpnnclinic) {
        this.cpnnclinic = cpnnclinic;
    }


    /**
     * @return
     */
    public BigDecimal getCpnnprofes() {
        if (this.id == null) {
            return null;
        }
        return this.id.getCpnnprofes();
    }

    public void setCpnnprofes(BigDecimal cpnnprofes) {
        if (this.id == null) {
            this.id = new CnprofxconId();
        }
        this.id.setCpnnprofes(cpnnprofes);
    }

    /**
     * @return
     */
    public Integer getCpnnconcli() {
        if (this.id == null) {
            return null;
        }
        return this.id.getCpnnconcli();
    }

    /**
     * @param cpnnconcli
     */
    public void setCpnnconcli(Integer cpnnconcli) {
        if (this.id == null) {
            this.id = new CnprofxconId();
        }
        this.id.setCpnnconcli(cpnnconcli);
    }


    /**
     * @param cpncestado
     */
    public void setCpncestado(String cpncestado) {
        this.cpncestado = cpncestado;
    }

    /**
     * @return
     */
    public String getCpncestado() {
        return cpncestado;
    }

   
}
