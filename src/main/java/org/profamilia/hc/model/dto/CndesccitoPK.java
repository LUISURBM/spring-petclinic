package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class CndesccitoPK implements Serializable {

    /** identifier field */
    private String cdictabla;

    /** identifier field */
    private String cdiccampo;

    /** identifier field */
    private Integer cdinconsec;


    /** default constructor */
    public CndesccitoPK() {
    }

    public String getCdictabla() {
        return this.cdictabla;
    }

    public void setCdictabla(String cdictabla) {
        this.cdictabla = cdictabla;
    }

    public String getCdiccampo() {
        return this.cdiccampo;
    }

    public void setCdiccampo(String cdiccampo) {
        this.cdiccampo = cdiccampo;
    }

    public Integer getCdinconsec() {
        return this.cdinconsec;
    }

    public void setCdinconsec(Integer cdinconsec) {
        this.cdinconsec = cdinconsec;
    }


}
