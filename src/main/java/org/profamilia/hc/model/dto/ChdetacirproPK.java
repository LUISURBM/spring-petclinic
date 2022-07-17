package org.profamilia.hc.model.dto;

import java.io.Serializable;

/** @author Hibernate CodeGenerator */
public class ChdetacirproPK implements Serializable {

    /** identifier field */
    private Long hdclconsuprinc;
    
    /** persistent field */
    private String hdccservicio; 



  

    /** default constructor */
    public ChdetacirproPK() {
    }


    /**
     * @param hdclconsuprinc
     */
    public void setHdclconsuprinc(Long hdclconsuprinc) {
        this.hdclconsuprinc = hdclconsuprinc;
    }

    /**
     * @return
     */
    public Long getHdclconsuprinc() {
        return hdclconsuprinc;
    }


    /**
     * @param hdccservicio
     */
    public void setHdccservicio(String hdccservicio) {
        this.hdccservicio = hdccservicio;
    }

    /**
     * @return
     */
    public String getHdccservicio() {
        return hdccservicio;
    }
}
