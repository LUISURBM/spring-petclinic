package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Clcomserv implements Serializable {

    private Integer numero;
    private String codigoexis;
    private String codigonuevo;
    private Integer version;
    private Integer subcateg;

   

    /** default constructor */
        public Clcomserv() {
           
        }

            public Integer getVersion() {
                    return version;
            }

            public void setVersion(Integer version) {
                    this.version = version;
            }
    public void setCodigonuevo(String codigonuevo) {
        this.codigonuevo = codigonuevo;
    }

    public String getCodigonuevo() {
        return codigonuevo;
    }
    public void setCodigoexis(String codigoexis) {
        this.codigoexis = codigoexis;
    }

    public String getCodigoexis() {
        return codigoexis;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setSubcateg(Integer subcateg) {
        this.subcateg = subcateg;
    }

    public Integer getSubcateg() {
        return subcateg;
    }
}
