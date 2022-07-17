package org.profamilia.hc.model.dto;

import java.io.Serializable;



/** @author Hibernate CodeGenerator */
public class ChcirdetdescPK implements Serializable {

    /** identifier field */
    private Long hcdlnumero;

    /** identifier field */
    private Integer hcdnconsec;

    /** identifier field */
    private String hcdcintervenci;


    /** default constructor */
    public ChcirdetdescPK() {
   
    }


   

    /**
     * @param hcdlnumero
     */
    public void setHcdlnumero(Long hcdlnumero) {
        this.hcdlnumero = hcdlnumero;
    }

    /**
     * @return
     */
    public Long getHcdlnumero() {
        return hcdlnumero;
    }

    /**
     * @param hcdnconsec
     */
    public void setHcdnconsec(Integer hcdnconsec) {
        this.hcdnconsec = hcdnconsec;
    }

    /**
     * @return
     */
    public Integer getHcdnconsec() {
        return hcdnconsec;
    }

    /**
     * @param hcdcintervenci
     */
    public void setHcdcintervenci(String hcdcintervenci) {
        this.hcdcintervenci = hcdcintervenci;
    }

    /**
     * @return
     */
    public String getHcdcintervenci() {
        return hcdcintervenci;
    }
}
