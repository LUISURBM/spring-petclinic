package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Cwsaludtotal implements Serializable {

    /** identifier field */
    private Long cstnconsec;

    /** nullable persistent field */
    private Long cstlnumcon;

    /** nullable persistent field */
    private String cstcerror;

    /** nullable persistent field */
    private String cstcdescrip;

    /** nullable persistent field */
    private String cstcresutlc;
    
    /** nullable persistent field */
    private String cstcxml;

    /** nullable persistent field */
    private Date cstdfechregi;

    /** nullable persistent field */
    private String cstcusuareg;

    /** full constructor */
    public Cwsaludtotal(Long cstnconsec, Long cstlnumcon, String cstcerror, String cstcdescrip, String cstcresutlc, Date cstdfechregi, String cstcusuareg,String cstcxml) {
        this.cstnconsec = cstnconsec;
        this.cstlnumcon = cstlnumcon;
        this.cstcerror = cstcerror;
        this.cstcdescrip = cstcdescrip;
        this.cstcresutlc = cstcresutlc;
        this.cstdfechregi = cstdfechregi;
        this.cstcusuareg = cstcusuareg;
        this.cstcxml = cstcxml;
    }

    /** default constructor */
    public Cwsaludtotal() {
    }

    /** minimal constructor */
    public Cwsaludtotal(Long cstnconsec) {
        this.cstnconsec = cstnconsec;
    }

    /** 
     * 		       CONSECUTIVO
     * 		    
     */
    public Long getCstnconsec() {
        return this.cstnconsec;
    }

    public void setCstnconsec(Long cstnconsec) {
        this.cstnconsec = cstnconsec;
    }

    public Long getCstlnumcon() {
        return this.cstlnumcon;
    }

    public void setCstlnumcon(Long cstlnumcon) {
        this.cstlnumcon = cstlnumcon;
    }

    public String getCstcerror() {
        return this.cstcerror;
    }

    public void setCstcerror(String cstcerror) {
        this.cstcerror = cstcerror;
    }

    public String getCstcdescrip() {
        return this.cstcdescrip;
    }

    public void setCstcdescrip(String cstcdescrip) {
        this.cstcdescrip = cstcdescrip;
    }

    public String getCstcresutlc() {
        return this.cstcresutlc;
    }

    public void setCstcresutlc(String cstcresutlc) {
        this.cstcresutlc = cstcresutlc;
    }

    public Date getCstdfechregi() {
        return this.cstdfechregi;
    }

    public void setCstdfechregi(Date cstdfechregi) {
        this.cstdfechregi = cstdfechregi;
    }

    public String getCstcusuareg() {
        return this.cstcusuareg;
    }

    public void setCstcusuareg(String cstcusuareg) {
        this.cstcusuareg = cstcusuareg;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cstnconsec", getCstnconsec())
            .toString();
    }

    public void setCstcxml(String cstcxml) {
        this.cstcxml = cstcxml;
    }

    public String getCstcxml() {
        return cstcxml;
    }
}
