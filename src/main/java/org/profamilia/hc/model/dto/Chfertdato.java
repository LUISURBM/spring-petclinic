package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class Chfertdato implements Serializable {

    /** identifier field */
    private Long hfdlconsulta;

    /** nullable persistent field */
    private String hfdctipide;

    /** nullable persistent field */
    private BigDecimal hfdanumide;

    /** nullable persistent field */
    private String hfdcprinom;

    /** nullable persistent field */
    private String hfdcpriape;

    /** nullable persistent field */
    private String hfdcsegnom;

    /** nullable persistent field */
    private String hfdcsegape;

    /** nullable persistent field */
    private Date hfddfecnac;

    /** nullable persistent field */
    private String hfdcocupac;

    /** nullable persistent field */
    private String hfdcdonant;
    
    /** nullable persistent field */
    private Integer hfdncoddon;

    /** nullable persistent field */
    private String hfdcpareja;
    
    /** nullable persistent field */
    private String hfdcnumpareja;

    /** nullable persistent field */
    private Integer version;
    
    /** nullable persistent field */
    private Date hfddfecreg;
    
    /** nullable persistent field */
    private String hfdcnomreg;
    
    /** nullable persistent field */
    private Integer hfdncodocupac;

 

    /** default constructor */
    public Chfertdato() {
    }


    /**
     * @param hfdlconsulta
     */
    public void setHfdlconsulta(Long hfdlconsulta) {
        this.hfdlconsulta = hfdlconsulta;
    }

    /**
     * @return
     */
    public Long getHfdlconsulta() {
        return hfdlconsulta;
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


    public void setHfdctipide(String hfdctipide) {
        this.hfdctipide = hfdctipide;
    }

    public String getHfdctipide() {
        return hfdctipide;
    }

    public void setHfdanumide(BigDecimal hfdanumide) {
        this.hfdanumide = hfdanumide;
    }

    public BigDecimal getHfdanumide() {
        return hfdanumide;
    }

    public void setHfdcprinom(String hfdcprinom) {
        this.hfdcprinom = hfdcprinom;
    }

    public String getHfdcprinom() {
        return hfdcprinom;
    }

    public void setHfdcpriape(String hfdcpriape) {
        this.hfdcpriape = hfdcpriape;
    }

    public String getHfdcpriape() {
        return hfdcpriape;
    }

    public void setHfdcsegnom(String hfdcsegnom) {
        this.hfdcsegnom = hfdcsegnom;
    }

    public String getHfdcsegnom() {
        return hfdcsegnom;
    }

    public void setHfdcsegape(String hfdcsegape) {
        this.hfdcsegape = hfdcsegape;
    }

    public String getHfdcsegape() {
        return hfdcsegape;
    }

    public void setHfddfecnac(Date hfddfecnac) {
        this.hfddfecnac = hfddfecnac;
    }

    public Date getHfddfecnac() {
        return hfddfecnac;
    }

    public void setHfdcocupac(String hfdcocupac) {
        this.hfdcocupac = hfdcocupac;
    }

    public String getHfdcocupac() {
        return hfdcocupac;
    }

    public void setHfdcdonant(String hfdcdonant) {
        this.hfdcdonant = hfdcdonant;
    }

    public String getHfdcdonant() {
        return hfdcdonant;
    }

    public void setHfdncoddon(Integer hfdncoddon) {
        this.hfdncoddon = hfdncoddon;
    }

    public Integer getHfdncoddon() {
        return hfdncoddon;
    }

    public void setHfdcpareja(String hfdcpareja) {
        this.hfdcpareja = hfdcpareja;
    }

    public String getHfdcpareja() {
        return hfdcpareja;
    }

    public void setHfdcnumpareja(String hfdcnumpareja) {
        this.hfdcnumpareja = hfdcnumpareja;
    }

    public String getHfdcnumpareja() {
        return hfdcnumpareja;
    }

    public void setHfddfecreg(Date hfddfecreg) {
        this.hfddfecreg = hfddfecreg;
    }

    public Date getHfddfecreg() {
        return hfddfecreg;
    }

    public void setHfdcnomreg(String hfdcnomreg) {
        this.hfdcnomreg = hfdcnomreg;
    }

    public String getHfdcnomreg() {
        return hfdcnomreg;
    }

    public void setHfdncodocupac(Integer hfdncodocupac) {
        this.hfdncodocupac = hfdncodocupac;
    }

    public Integer getHfdncodocupac() {
        return hfdncodocupac;
    }
}
