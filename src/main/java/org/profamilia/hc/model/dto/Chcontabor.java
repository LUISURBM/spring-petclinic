package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chcontabor implements Serializable {

    /** identifier field */
    private Long hcanconsec;

    /** nullable persistent field */
    private Long hcannumero;

    /** nullable persistent field */
    private Long hcalnumeusua;

    /** nullable persistent field */
    private String hcactipocont;

    /** nullable persistent field */
    private String hcacobserva;

    /** nullable persistent field */
    private Date hcadfechobse;

    /** nullable persistent field */
    private String hcacusuareg;

    /** nullable persistent field */
    private String hcacfarma;


    /** nullable persistent field */
    private Integer hcancodclin;


    /** nullable persistent field */
    private String hcacmotcierre;

    /** nullable persistent field */
    private String hcacotromocierre;
    /** nullable persistent field */
    private Long hcannumcons;
    


    /** full constructor */
    public Chcontabor(Long hcanconsec, Long hcannumero, Long hcalnumeusua, String hcactipocont, String hcacobserva, Date hcadfechobse, String hcacusuareg, String hcacfarma, String hcaccodcup, Integer hcancodclin, Date hcadfecdismed, Date hcadusuamed, Date hcadfectoma, String hcacmedcon, String hcacmotcierre, String hcacotromocierre) {
        this.hcanconsec = hcanconsec;
        this.hcannumero = hcannumero;
        this.hcalnumeusua = hcalnumeusua;
        this.hcactipocont = hcactipocont;
        this.hcacobserva = hcacobserva;
        this.hcadfechobse = hcadfechobse;
        this.hcacusuareg = hcacusuareg;
        this.hcacfarma = hcacfarma;
        this.hcancodclin = hcancodclin;
        this.hcacmotcierre = hcacmotcierre;
        this.hcacotromocierre = hcacotromocierre;
    }

    /** default constructor */
    public Chcontabor() {
    }

    /** minimal constructor */
    public Chcontabor(Long hcanconsec) {
        this.hcanconsec = hcanconsec;
    }

    /** 
     * 		       consecutivo
     * 		    
     */
    public Long getHcanconsec() {
        return this.hcanconsec;
    }

    public void setHcanconsec(Long hcanconsec) {
        this.hcanconsec = hcanconsec;
    }

    public Long getHcannumero() {
        return this.hcannumero;
    }

    public void setHcannumero(Long hcannumero) {
        this.hcannumero = hcannumero;
    }

    public Long getHcalnumeusua() {
        return this.hcalnumeusua;
    }

    public void setHcalnumeusua(Long hcalnumeusua) {
        this.hcalnumeusua = hcalnumeusua;
    }

    public String getHcactipocont() {
        return this.hcactipocont;
    }

    public void setHcactipocont(String hcactipocont) {
        this.hcactipocont = hcactipocont;
    }

    public String getHcacobserva() {
        return this.hcacobserva;
    }

    public void setHcacobserva(String hcacobserva) {
        this.hcacobserva = hcacobserva;
    }

    public Date getHcadfechobse() {
        return this.hcadfechobse;
    }

    public void setHcadfechobse(Date hcadfechobse) {
        this.hcadfechobse = hcadfechobse;
    }

    public String getHcacusuareg() {
        return this.hcacusuareg;
    }

    public void setHcacusuareg(String hcacusuareg) {
        this.hcacusuareg = hcacusuareg;
    }

    public String getHcacfarma() {
        return this.hcacfarma;
    }

    public void setHcacfarma(String hcacfarma) {
        this.hcacfarma = hcacfarma;
    }

  

    public Integer getHcancodclin() {
        return this.hcancodclin;
    }

    public void setHcancodclin(Integer hcancodclin) {
        this.hcancodclin = hcancodclin;
    }

 

    public String getHcacmotcierre() {
        return this.hcacmotcierre;
    }

    public void setHcacmotcierre(String hcacmotcierre) {
        this.hcacmotcierre = hcacmotcierre;
    }

    public String getHcacotromocierre() {
        return this.hcacotromocierre;
    }

    public void setHcacotromocierre(String hcacotromocierre) {
        this.hcacotromocierre = hcacotromocierre;
    }
    
    

    public String toString() {
        return new ToStringBuilder(this)
            .append("hcanconsec", getHcanconsec())
            .toString();
    }


    public void setHcannumcons(Long hcannumcons) {
        this.hcannumcons = hcannumcons;
    }

    public Long getHcannumcons() {
        return hcannumcons;
    }
}
