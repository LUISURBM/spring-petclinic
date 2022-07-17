package org.profamilia.hc.model.dto;

import java.io.Serializable;

public class ChserviautorPK  implements Serializable {

    /** identifier field */
    private Long hselconsulta;
    
    /** identifier field */
    private Integer hsenconsecutiv;

    public ChserviautorPK() {
    
    }


    public void setHselconsulta(Long hselconsulta) {
        this.hselconsulta = hselconsulta;
    }

    public Long getHselconsulta() {
        return hselconsulta;
    }

    public void setHsenconsecutiv(Integer hsenconsecutiv) {
        this.hsenconsecutiv = hsenconsecutiv;
    }

    public Integer getHsenconsecutiv() {
        return hsenconsecutiv;
    }
}
