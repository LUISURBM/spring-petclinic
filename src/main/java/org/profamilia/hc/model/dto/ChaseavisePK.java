package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;


/** @author Hibernate CodeGenerator */
public class ChaseavisePK implements Serializable {

    /** identifier field */
    private Date havdfecase;

    /** identifier field */
    private Long havlusuario;

    /** full constructor */
    public ChaseavisePK(Date havdfecase, Long havlusuario) {
        this.havdfecase = havdfecase;
        this.havlusuario = havlusuario;
    }

    /** default constructor */
    public ChaseavisePK() {
    }

    /**
     * @return
     */
    public Date getHavdfecase() {
        return this.havdfecase;
    }

    /**
     * @param havdfecase
     */
    public void setHavdfecase(Date havdfecase) {
        this.havdfecase = havdfecase;
    }

    /**
     * @return
     */
    public Long getHavlusuario() {
        return this.havlusuario;
    }

    /**
     * @param havlusuario
     */
    public void setHavlusuario(Long havlusuario) {
        this.havlusuario = havlusuario;
    }

    

}
