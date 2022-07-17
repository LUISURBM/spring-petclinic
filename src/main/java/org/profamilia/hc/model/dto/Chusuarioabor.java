package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chusuarioabor implements Serializable {

    /** identifier field */
    private Long hualnumero;

    /** nullable persistent field */
    private String huactipoiden;

    /** nullable persistent field */
    private Long huaanumeiden;

    /** persistent field */
    private String huacprimernomb;

    /** nullable persistent field */
    private String huacsegundnomb;

    /** persistent field */
    private String huacprimerapel;

    /** nullable persistent field */
    private String huacsegundapel;

    /** persistent field */
    private Date huadfechnaci;

    /** nullable persistent field */
    private String huactelefono;

    /** nullable persistent field */
    private String huaccelular;

    /** nullable persistent field */
    private Integer huanciudad;

    /** nullable persistent field */
    private String huaccorreo;

    /** nullable persistent field */
    private Integer huandepart;

    /** nullable persistent field */
    private Date huadfecreg;

    /** nullable persistent field */
    private String huacusureg;

    /** full constructor */
    public Chusuarioabor(Long hualnumero, String huactipoiden, Long huaanumeiden, String huacprimernomb, String huacsegundnomb, String huacprimerapel, String huacsegundapel, Date huadfechnaci, String huactelefono, String huaccelular, BigDecimal huanedad, Integer huanciudad, String huaccorreo, Integer huandepart, Date huadfecreg, String huacusureg) {
        this.hualnumero = hualnumero;
        this.huactipoiden = huactipoiden;
        this.huaanumeiden = huaanumeiden;
        this.huacprimernomb = huacprimernomb;
        this.huacsegundnomb = huacsegundnomb;
        this.huacprimerapel = huacprimerapel;
        this.huacsegundapel = huacsegundapel;
        this.huadfechnaci = huadfechnaci;
        this.huactelefono = huactelefono;
        this.huaccelular = huaccelular;
        this.huanciudad = huanciudad;
        this.huaccorreo = huaccorreo;
        this.huandepart = huandepart;
        this.huadfecreg = huadfecreg;
        this.huacusureg = huacusureg;
    }

    /** default constructor */
    public Chusuarioabor() {
    }

    /** minimal constructor */
    public Chusuarioabor(Long hualnumero, String huacprimernomb, String huacprimerapel, Date huadfechnaci, BigDecimal huanedad) {
        this.hualnumero = hualnumero;
        this.huacprimernomb = huacprimernomb;
        this.huacprimerapel = huacprimerapel;
        this.huadfechnaci = huadfechnaci;
    }

    public Long getHualnumero() {
        return this.hualnumero;
    }

    public void setHualnumero(Long hualnumero) {
        this.hualnumero = hualnumero;
    }

    public String getHuactipoiden() {
        return this.huactipoiden;
    }

    public void setHuactipoiden(String huactipoiden) {
        this.huactipoiden = huactipoiden;
    }

    public Long getHuaanumeiden() {
        return this.huaanumeiden;
    }

    public void setHuaanumeiden(Long huaanumeiden) {
        this.huaanumeiden = huaanumeiden;
    }

    public String getHuacprimernomb() {
        return this.huacprimernomb;
    }

    public void setHuacprimernomb(String huacprimernomb) {
        this.huacprimernomb = huacprimernomb;
    }

    public String getHuacsegundnomb() {
        return this.huacsegundnomb;
    }

    public void setHuacsegundnomb(String huacsegundnomb) {
        this.huacsegundnomb = huacsegundnomb;
    }

    public String getHuacprimerapel() {
        return this.huacprimerapel;
    }

    public void setHuacprimerapel(String huacprimerapel) {
        this.huacprimerapel = huacprimerapel;
    }

    public String getHuacsegundapel() {
        return this.huacsegundapel;
    }

    public void setHuacsegundapel(String huacsegundapel) {
        this.huacsegundapel = huacsegundapel;
    }

    public Date getHuadfechnaci() {
        return this.huadfechnaci;
    }

    public void setHuadfechnaci(Date huadfechnaci) {
        this.huadfechnaci = huadfechnaci;
    }

    public String getHuactelefono() {
        return this.huactelefono;
    }

    public void setHuactelefono(String huactelefono) {
        this.huactelefono = huactelefono;
    }

    public String getHuaccelular() {
        return this.huaccelular;
    }

    public void setHuaccelular(String huaccelular) {
        this.huaccelular = huaccelular;
    }


    public Integer getHuanciudad() {
        return this.huanciudad;
    }

    public void setHuanciudad(Integer huanciudad) {
        this.huanciudad = huanciudad;
    }

    public String getHuaccorreo() {
        return this.huaccorreo;
    }

    public void setHuaccorreo(String huaccorreo) {
        this.huaccorreo = huaccorreo;
    }

    public Integer getHuandepart() {
        return this.huandepart;
    }

    public void setHuandepart(Integer huandepart) {
        this.huandepart = huandepart;
    }

    public Date getHuadfecreg() {
        return this.huadfecreg;
    }

    public void setHuadfecreg(Date huadfecreg) {
        this.huadfecreg = huadfecreg;
    }

    public String getHuacusureg() {
        return this.huacusureg;
    }

    public void setHuacusureg(String huacusureg) {
        this.huacusureg = huacusureg;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hualnumero", getHualnumero())
            .toString();
    }

}
