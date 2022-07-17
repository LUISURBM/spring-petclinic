package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChitemvrquirPK implements Serializable {

    /** identifier field */
    private Long hiqlcirugia;

    /** identifier field */
    private String hiqcliteral;

    /** identifier field */
    private Integer hiqnnumeral;



    /** default constructor */
    public ChitemvrquirPK() {
    }


    public void setHiqlcirugia(Long hiqlcirugia) {
        this.hiqlcirugia = hiqlcirugia;
    }

    public Long getHiqlcirugia() {
        return hiqlcirugia;
    }

    public void setHiqcliteral(String hiqcliteral) {
        this.hiqcliteral = hiqcliteral;
    }

    public String getHiqcliteral() {
        return hiqcliteral;
    }

    public void setHiqnnumeral(Integer hiqnnumeral) {
        this.hiqnnumeral = hiqnnumeral;
    }

    public Integer getHiqnnumeral() {
        return hiqnnumeral;
    }
}
