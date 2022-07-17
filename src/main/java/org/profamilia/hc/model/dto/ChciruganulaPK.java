package org.profamilia.hc.model.dto;

import java.io.Serializable;

public class ChciruganulaPK implements Serializable {

    /** nullable persistent field */
    private Integer hcanconsec;

    /** identifier field */
    private Long hcalnumero;
    


    public ChciruganulaPK() {
    
       
    
    }

    public void setHcanconsec(Integer hcanconsec) {
        this.hcanconsec = hcanconsec;
    }

    public Integer getHcanconsec() {
        return hcanconsec;
    }

    public void setHcalnumero(Long hcalnumero) {
        this.hcalnumero = hcalnumero;
    }

    public Long getHcalnumero() {
        return hcalnumero;
    }
}
