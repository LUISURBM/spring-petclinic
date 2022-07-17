package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChconsumedicPK implements Serializable {

    /** identifier field */
    private Integer hcmnclinica;

    /** identifier field */
    private Integer hcmncodigprofe;

    /** default constructor */
    public ChconsumedicPK() {
    }

    /**
     * @param hcmnclinica
     */
    public void setHcmnclinica(Integer hcmnclinica) {
        this.hcmnclinica = hcmnclinica;
    }

    /**
     * @return
     */
    public Integer getHcmnclinica() {
        return hcmnclinica;
    }

    /**
     * @param hcmncodigprofe
     */
    public void setHcmncodigprofe(Integer hcmncodigprofe) {
        this.hcmncodigprofe = hcmncodigprofe;
    }

    /**
     * @return
     */
    public Integer getHcmncodigprofe() {
        return hcmncodigprofe;
    }
}
