package org.profamilia.hc.model.dto;

import java.io.Serializable;



/** @author Hibernate CodeGenerator */
public class ChregisexamePK implements Serializable {

    /** identifier field */
    private Long hrelconsulta;

    /** identifier field */
    private Integer hrenconsecuti;

 
    /** default constructor */
    public ChregisexamePK() {
    }


    /**
     * @param hrelconsulta
     */
    public void setHrelconsulta(Long hrelconsulta) {
        this.hrelconsulta = hrelconsulta;
    }

    /**
     * @return
     */
    public Long getHrelconsulta() {
        return hrelconsulta;
    }

    /**
     * @param hrenconsecuti
     */
    public void setHrenconsecuti(Integer hrenconsecuti) {
        this.hrenconsecuti = hrenconsecuti;
    }

    /**
     * @return
     */
    public Integer getHrenconsecuti() {
        return hrenconsecuti;
    }
}
