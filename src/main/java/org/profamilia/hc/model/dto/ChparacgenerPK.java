package org.profamilia.hc.model.dto;

import java.io.Serializable;

public class ChparacgenerPK   implements Serializable {



        /** identifier field */
        private Long hpglconsulta;

        /** identifier field */
        private Integer hpgnconsecuti;
        
        
        
    public ChparacgenerPK() {
    }


    public void setHpglconsulta(Long hpglconsulta) {
        this.hpglconsulta = hpglconsulta;
    }

    public Long getHpglconsulta() {
        return hpglconsulta;
    }

    public void setHpgnconsecuti(Integer hpgnconsecuti) {
        this.hpgnconsecuti = hpgnconsecuti;
    }

    public Integer getHpgnconsecuti() {
        return hpgnconsecuti;
    }
}
