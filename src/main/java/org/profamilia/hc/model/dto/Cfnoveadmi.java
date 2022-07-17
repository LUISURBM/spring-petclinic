package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Cfnoveadmi implements Serializable {

    /** identifier field */
    private Long cnnconsec;

    /** persistent field */
    private Long cnnclinic;

    /** persistent field */
    private Date cndfecreg;

    /** persistent field */
    private String cncusuari;

    /** persistent field */
    private Double cnnsubtot;

    /** nullable persistent field */
    private Double cnniva;

    /** persistent field */
    private Double cnntotal;

    /** nullable persistent field */
    private Double cnndescto;

    /** persistent field */
    private String cnnestado;

    /** nullable persistent field */
    private Long version;

    /** nullable persistent field */
    private Double cnnrecaudo;

    /** nullable persistent field */
    private String cncplaca;

    /** nullable persistent field */
    private Double cnncambio;

    /** nullable persistent field */
    private Double cncnturno;

    /** persistent field */
    private Double cnnvalent;

    /** persistent field */
    private Double cnnvalrec;

    /** nullable persistent field */
    private String cncexecopago;

    /** persistent field */
    private Long cnnadmision;

    /** persistent field */
    private Double cnnvalprevio;

    /** full constructor */
    public Cfnoveadmi(Long cnnconsec, Long cnnclinic, Date cndfecreg, String cncusuari, Double cnnsubtot, Double cnniva, Double cnntotal, Double cnndescto, String cnnestado, Long version, Double cnnrecaudo, String cncplaca, Double cnncambio, Double cncnturno, Double cnnvalent, Double cnnvalrec, String cncexecopago, Long cnnadmision, Double cnnvalprevio) {
        this.cnnconsec = cnnconsec;
        this.cnnclinic = cnnclinic;
        this.cndfecreg = cndfecreg;
        this.cncusuari = cncusuari;
        this.cnnsubtot = cnnsubtot;
        this.cnniva = cnniva;
        this.cnntotal = cnntotal;
        this.cnndescto = cnndescto;
        this.cnnestado = cnnestado;
        this.version = version;
        this.cnnrecaudo = cnnrecaudo;
        this.cncplaca = cncplaca;
        this.cnncambio = cnncambio;
        this.cncnturno = cncnturno;
        this.cnnvalent = cnnvalent;
        this.cnnvalrec = cnnvalrec;
        this.cncexecopago = cncexecopago;
        this.cnnadmision = cnnadmision;
        this.cnnvalprevio = cnnvalprevio;
    }

    /** default constructor */
    public Cfnoveadmi() {
    }

    /** minimal constructor */
    public Cfnoveadmi(Long cnnconsec, Long cnnclinic, Date cndfecreg, String cncusuari, Double cnnsubtot, Double cnntotal, String cnnestado, Double cnnvalent, Double cnnvalrec, Long cnnadmision, Double cnnvalprevio) {
        this.cnnconsec = cnnconsec;
        this.cnnclinic = cnnclinic;
        this.cndfecreg = cndfecreg;
        this.cncusuari = cncusuari;
        this.cnnsubtot = cnnsubtot;
        this.cnntotal = cnntotal;
        this.cnnestado = cnnestado;
        this.cnnvalent = cnnvalent;
        this.cnnvalrec = cnnvalrec;
        this.cnnadmision = cnnadmision;
        this.cnnvalprevio = cnnvalprevio;
    }

    public Long getCnnconsec() {
        return this.cnnconsec;
    }

    public void setCnnconsec(Long cnnconsec) {
        this.cnnconsec = cnnconsec;
    }

    public Long getCnnclinic() {
        return this.cnnclinic;
    }

    public void setCnnclinic(Long cnnclinic) {
        this.cnnclinic = cnnclinic;
    }

    public Date getCndfecreg() {
        return this.cndfecreg;
    }

    public void setCndfecreg(Date cndfecreg) {
        this.cndfecreg = cndfecreg;
    }

    public String getCncusuari() {
        return this.cncusuari;
    }

    public void setCncusuari(String cncusuari) {
        this.cncusuari = cncusuari;
    }

    public Double getCnnsubtot() {
        return this.cnnsubtot;
    }

    public void setCnnsubtot(Double cnnsubtot) {
        this.cnnsubtot = cnnsubtot;
    }

    public Double getCnniva() {
        return this.cnniva;
    }

    public void setCnniva(Double cnniva) {
        this.cnniva = cnniva;
    }

    public Double getCnntotal() {
        return this.cnntotal;
    }

    public void setCnntotal(Double cnntotal) {
        this.cnntotal = cnntotal;
    }

    public Double getCnndescto() {
        return this.cnndescto;
    }

    public void setCnndescto(Double cnndescto) {
        this.cnndescto = cnndescto;
    }

    public String getCnnestado() {
        return this.cnnestado;
    }

    public void setCnnestado(String cnnestado) {
        this.cnnestado = cnnestado;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Double getCnnrecaudo() {
        return this.cnnrecaudo;
    }

    public void setCnnrecaudo(Double cnnrecaudo) {
        this.cnnrecaudo = cnnrecaudo;
    }

    public String getCncplaca() {
        return this.cncplaca;
    }

    public void setCncplaca(String cncplaca) {
        this.cncplaca = cncplaca;
    }

    public Double getCnncambio() {
        return this.cnncambio;
    }

    public void setCnncambio(Double cnncambio) {
        this.cnncambio = cnncambio;
    }

    public Double getCncnturno() {
        return this.cncnturno;
    }

    public void setCncnturno(Double cncnturno) {
        this.cncnturno = cncnturno;
    }

    public Double getCnnvalent() {
        return this.cnnvalent;
    }

    public void setCnnvalent(Double cnnvalent) {
        this.cnnvalent = cnnvalent;
    }

    public Double getCnnvalrec() {
        return this.cnnvalrec;
    }

    public void setCnnvalrec(Double cnnvalrec) {
        this.cnnvalrec = cnnvalrec;
    }

    public String getCncexecopago() {
        return this.cncexecopago;
    }

    public void setCncexecopago(String cncexecopago) {
        this.cncexecopago = cncexecopago;
    }

    public Long getCnnadmision() {
        return this.cnnadmision;
    }

    public void setCnnadmision(Long cnnadmision) {
        this.cnnadmision = cnnadmision;
    }

    public Double getCnnvalprevio() {
        return this.cnnvalprevio;
    }

    public void setCnnvalprevio(Double cnnvalprevio) {
        this.cnnvalprevio = cnnvalprevio;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cnnconsec", getCnnconsec())
            .toString();
    }

}
