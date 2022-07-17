package org.profamilia.hc.model.dto;

import java.io.Serializable;



/** @author Hibernate CodeGenerator */
public class Chcirdetdesc implements Serializable {

    /** identifier field */
    private ChcirdetdescPK id;
    private String Hcdcestado;
    private String hcdcintervepra;        



    /** default constructor */
    public Chcirdetdesc() {
        id =  new  ChcirdetdescPK(); 
    }


    /**
     * @param id
     */
    public void setId(ChcirdetdescPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChcirdetdescPK getId() {
        return id;
    }

    public void setHcdcestado(String hcdcestado) {
        this.Hcdcestado = hcdcestado;
    }

    public String getHcdcestado() {
        return Hcdcestado;
    }


    public void setHcdcintervepra(String hcdcintervepra) {
        this.hcdcintervepra = hcdcintervepra;
    }

    public String getHcdcintervepra() {
        return hcdcintervepra;
    }
}
