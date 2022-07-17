package org.profamilia.hc.model.dto;

import java.math.BigDecimal;


public class RipsSaludtoolsDTO {

 
    private Long cstnadmisi;
    private String cstcautori;
    private BigDecimal cstavalcon;
    private BigDecimal cstavalcuo;
    private BigDecimal cstavalnet;
    private String cstcsrvadm;
    /** full constructor */
   

    /** default constructor */
    public RipsSaludtoolsDTO() {
    }


    public void setCstnadmisi(Long cstnadmisi) {
        this.cstnadmisi = cstnadmisi;
    }

    public Long getCstnadmisi() {
        return cstnadmisi;
    }

    public void setCstcautori(String cstcautori) {
        this.cstcautori = cstcautori;
    }

    public String getCstcautori() {
        return cstcautori;
    }

    public void setCstavalcon(BigDecimal cstavalcon) {
        this.cstavalcon = cstavalcon;
    }

    public BigDecimal getCstavalcon() {
        return cstavalcon;
    }

    public void setCstavalcuo(BigDecimal cstavalcuo) {
        this.cstavalcuo = cstavalcuo;
    }

    public BigDecimal getCstavalcuo() {
        return cstavalcuo;
    }

    public void setCstavalnet(BigDecimal cstavalnet) {
        this.cstavalnet = cstavalnet;
    }

    public BigDecimal getCstavalnet() {
        return cstavalnet;
    }

    public void setCstcsrvadm(String cstcsrvadm) {
        this.cstcsrvadm = cstcsrvadm;
    }

    public String getCstcsrvadm() {
        return cstcsrvadm;
    }
}
