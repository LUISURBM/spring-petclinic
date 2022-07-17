package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;


/** @author Hibernate CodeGenerator */
public class ChseguavisPK implements Serializable {

    /** identifier field */
    private Date hsadfecase;

    /** identifier field */
    private Long hsalusuario;

    /** identifier field */
    private Integer hsanconsec;

    /** full constructor */
    public ChseguavisPK(Date hsadfecase, Long hsalusuario, Integer hsanconsec) {
        this.hsadfecase = hsadfecase;
        this.hsalusuario = hsalusuario;
        this.hsanconsec = hsanconsec;
    }

    /** default constructor */
    public ChseguavisPK() {
    }

    public Date getHsadfecase() {
        return this.hsadfecase;
    }

    public void setHsadfecase(Date hsadfecase) {
        this.hsadfecase = hsadfecase;
    }

    public Long getHsalusuario() {
        return this.hsalusuario;
    }

    public void setHsalusuario(Long hsalusuario) {
        this.hsalusuario = hsalusuario;
    }

    public Integer getHsanconsec() {
        return this.hsanconsec;
    }

    public void setHsanconsec(Integer hsanconsec) {
        this.hsanconsec = hsanconsec;
    }



}
