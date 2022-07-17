package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChconsxcirugPK implements Serializable {

    /** identifier field */
    private Long hcclconsclin;

    /** identifier field */
    private Integer hccncirugia;


    /** default constructor */
    public ChconsxcirugPK() {
    }


    /**
     * @param hcclconsclin
     */
    public void setHcclconsclin(Long hcclconsclin) {
        this.hcclconsclin = hcclconsclin;
    }

    /**
     * @return
     */
    public Long getHcclconsclin() {
        return hcclconsclin;
    }

    /**
     * @param hccncirugia
     */
    public void setHccncirugia(Integer hccncirugia) {
        this.hccncirugia = hccncirugia;
    }

    /**
     * @return
     */
    public Integer getHccncirugia() {
        return hccncirugia;
    }
}
