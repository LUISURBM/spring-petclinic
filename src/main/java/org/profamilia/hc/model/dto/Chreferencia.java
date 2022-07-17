package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chreferencia implements Serializable {

    /** identifier field */
    private ChreferenciaPK id;

    /** nullable persistent field */
    private String hrectiporefere;

    /** nullable persistent field */
    private String hrecnombrespon;

    /** nullable persistent field */
    private String hrecdirecrespo;

    /** nullable persistent field */
    private String hrectelefrespo;

    /** nullable persistent field */
    private String hrecanamnesis;
    
     /** nullable persistent field */
     private String hrecexamfisc;

    /** nullable persistent field */
    private String hrecapoyodiagn;

    /** nullable persistent field */
    private String hrecjustirefer;

    /** nullable persistent field */
    private Date hredfecregistr;

    /** nullable persistent field */
    private String hrecoperador;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String hrecetapa;

    /** nullable persistent field */
    private Date hredfecconf;

    /** nullable persistent field */
    private String hrecoperconf;

    /** nullable persistent field */
    private String hrecobsconf;
    
    private Integer hrendeparrespo; 
    
    private Integer hrenciudarespo;
    
    private String hreetipideresp; 
    
    private BigDecimal hreanumideresp; 
    
    private String hreccelulrespo; 
    
    private String hreclugarservi;
    
    private String hrecservisolic;
    
    private String hrecserviencu;
    
    private String hreccomplicaci ;
    
    private String hrectrataaplic;
    
    private String hrecmotivremis;
    
    private String hrecdiligforma;
    
    private String hreccopiahisto;
    
    private String hrecresulapoyo;
    
    private String hreccartapago;
    
    private String hrecdiagnosti;
    
    private Long hrenmedauttra;
    
    private String hrecmormatext;
    
    /** default constructor */
    public Chreferencia() {
    }


    public void setId(ChreferenciaPK id) {
        this.id = id;
    }

    public ChreferenciaPK getId() {
        return id;
    }

    public void setHrectiporefere(String hrectiporefere) {
        this.hrectiporefere = hrectiporefere;
    }

    public String getHrectiporefere() {
        return hrectiporefere;
    }

    public void setHrecnombrespon(String hrecnombrespon) {
        this.hrecnombrespon = hrecnombrespon;
    }

    public String getHrecnombrespon() {
        return hrecnombrespon;
    }

    public void setHrecdirecrespo(String hrecdirecrespo) {
        this.hrecdirecrespo = hrecdirecrespo;
    }

    public String getHrecdirecrespo() {
        return hrecdirecrespo;
    }

    public void setHrectelefrespo(String hrectelefrespo) {
        this.hrectelefrespo = hrectelefrespo;
    }

    public String getHrectelefrespo() {
        return hrectelefrespo;
    }

    public void setHrecanamnesis(String hrecanamnesis) {
        this.hrecanamnesis = hrecanamnesis;
    }

    public String getHrecanamnesis() {
        return hrecanamnesis;
    }

    public void setHrecapoyodiagn(String hrecapoyodiagn) {
        this.hrecapoyodiagn = hrecapoyodiagn;
    }

    public String getHrecapoyodiagn() {
        return hrecapoyodiagn;
    }

    public void setHrecjustirefer(String hrecjustirefer) {
        this.hrecjustirefer = hrecjustirefer;
    }

    public String getHrecjustirefer() {
        return hrecjustirefer;
    }

    public void setHredfecregistr(Date hredfecregistr) {
        this.hredfecregistr = hredfecregistr;
    }

    public Date getHredfecregistr() {
        return hredfecregistr;
    }

    public void setHrecoperador(String hrecoperador) {
        this.hrecoperador = hrecoperador;
    }

    public String getHrecoperador() {
        return hrecoperador;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }


    public void setHrecetapa(String hrecetapa) {
        this.hrecetapa = hrecetapa;
    }

    public String getHrecetapa() {
        return hrecetapa;
    }

    public void setHredfecconf(Date hredfecconf) {
        this.hredfecconf = hredfecconf;
    }

    public Date getHredfecconf() {
        return hredfecconf;
    }

    public void setHrecoperconf(String hrecoperconf) {
        this.hrecoperconf = hrecoperconf;
    }

    public String getHrecoperconf() {
        return hrecoperconf;
    }

    public void setHrecobsconf(String hrecobsconf) {
        this.hrecobsconf = hrecobsconf;
    }

    public String getHrecobsconf() {
        return hrecobsconf;
    }

    public void setHrendeparrespo(Integer hrendeparrespo) {
        this.hrendeparrespo = hrendeparrespo;
    }

    public Integer getHrendeparrespo() {
        return hrendeparrespo;
    }

    public void setHrenciudarespo(Integer hrenciudarespo) {
        this.hrenciudarespo = hrenciudarespo;
    }

    public Integer getHrenciudarespo() {
        return hrenciudarespo;
    }

    public void setHreetipideresp(String hreetipideresp) {
        this.hreetipideresp = hreetipideresp;
    }

    public String getHreetipideresp() {
        return hreetipideresp;
    }

    public void setHreanumideresp(BigDecimal hreanumideresp) {
        this.hreanumideresp = hreanumideresp;
    }

    public BigDecimal getHreanumideresp() {
        return hreanumideresp;
    }

    public void setHreccelulrespo(String hreccelulrespo) {
        this.hreccelulrespo = hreccelulrespo;
    }

    public String getHreccelulrespo() {
        return hreccelulrespo;
    }

    public void setHreclugarservi(String hreclugarservi) {
        this.hreclugarservi = hreclugarservi;
    }

    public String getHreclugarservi() {
        return hreclugarservi;
    }

    public void setHrecservisolic(String hrecservisolic) {
        this.hrecservisolic = hrecservisolic;
    }

    public String getHrecservisolic() {
        return hrecservisolic;
    }

    public void setHreccomplicaci(String hreccomplicaci) {
        this.hreccomplicaci = hreccomplicaci;
    }

    public String getHreccomplicaci() {
        return hreccomplicaci;
    }

    public void setHrectrataaplic(String hrectrataaplic) {
        this.hrectrataaplic = hrectrataaplic;
    }

    public String getHrectrataaplic() {
        return hrectrataaplic;
    }

    public void setHrecmotivremis(String hrecmotivremis) {
        this.hrecmotivremis = hrecmotivremis;
    }

    public String getHrecmotivremis() {
        return hrecmotivremis;
    }

    public void setHrecdiligforma(String hrecdiligforma) {
        this.hrecdiligforma = hrecdiligforma;
    }

    public String getHrecdiligforma() {
        return hrecdiligforma;
    }

    public void setHreccopiahisto(String hreccopiahisto) {
        this.hreccopiahisto = hreccopiahisto;
    }

    public String getHreccopiahisto() {
        return hreccopiahisto;
    }

    public void setHrecresulapoyo(String hrecresulapoyo) {
        this.hrecresulapoyo = hrecresulapoyo;
    }

    public String getHrecresulapoyo() {
        return hrecresulapoyo;
    }

    public void setHreccartapago(String hreccartapago) {
        this.hreccartapago = hreccartapago;
    }

    public String getHreccartapago() {
        return hreccartapago;
    }

    public void setHrecserviencu(String hrecserviencu) {
        this.hrecserviencu = hrecserviencu;
    }

    public String getHrecserviencu() {
        return hrecserviencu;
    }

    public void setHrecexamfisc(String hrecexamfisc) {
        this.hrecexamfisc = hrecexamfisc;
    }

    public String getHrecexamfisc() {
        return hrecexamfisc;
    }

    public void setHrecdiagnosti(String hrecdiagnosti) {
        this.hrecdiagnosti = hrecdiagnosti;
    }

    public String getHrecdiagnosti() {
        return hrecdiagnosti;
    }

    public void setHrenmedauttra(Long hrenmedauttra) {
        this.hrenmedauttra = hrenmedauttra;
    }

    public Long getHrenmedauttra() {
        return hrenmedauttra;
    }

    public void setHrecmormatext(String hrecmormatext) {
        this.hrecmormatext = hrecmormatext;
    }

    public String getHrecmormatext() {
        return hrecmormatext;
    }
}
