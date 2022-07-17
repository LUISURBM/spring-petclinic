package org.profamilia.hc.model.dto;


/** @author Nlis */
public class CpmunidaneId implements java.io.Serializable {


    private Integer cmdncoddep;
    private Integer cmdncodmun;


    // Constructors

    /** default constructor */
    public CpmunidaneId() {
    }


    // HS SEPARADOR CONSTRUCTOR


    // Property accessors


    public Integer getCmdncoddep() {
        return this.cmdncoddep;
    }

    public void setCmdncoddep(Integer cmdncoddep) {
        this.cmdncoddep = cmdncoddep;
    }


    public Integer getCmdncodmun() {
        return this.cmdncodmun;
    }

    public void setCmdncodmun(Integer cmdncodmun) {
        this.cmdncodmun = cmdncodmun;
    }


    // no tiene llave compuesta.


}
