package org.profamilia.hc.model.dto;

import java.util.Date;


public class Chreporte {

    private Integer hrencodigo;
    private Long hrenconsulta;
    private Integer hrentipoimpres;
    private String hrecdescripcio;
    private String hrecdescripcio2;
    private String hrecdescripcio3;
    private String hrecdescripcio4;
    private String hrecdescripcio5;
    private String hrectipodescri;
    private Date hredfecharegis;

    public Chreporte() {
    }

    /**
     * @param hrencodigo
     */
    public void setHrencodigo(Integer hrencodigo) {
        this.hrencodigo = hrencodigo;
    }

    /**
     * @return
     */
    public Integer getHrencodigo() {
        return hrencodigo;
    }

    /**
     * @param hrecdescripcio
     */
    public void setHrecdescripcio(String hrecdescripcio) {
        this.hrecdescripcio = hrecdescripcio;
    }

    /**
     * @return
     */
    public String getHrecdescripcio() {
        return hrecdescripcio;
    }

    /**
     * @param hrectipodescri
     */
    public void setHrectipodescri(String hrectipodescri) {
        this.hrectipodescri = hrectipodescri;
    }

    /**
     * @return
     */
    public String getHrectipodescri() {
        return hrectipodescri;
    }

    /**
     * @param hrentipoimpres
     */
    public void setHrentipoimpres(Integer hrentipoimpres) {
        this.hrentipoimpres = hrentipoimpres;
    }

    /**
     * @return
     */
    public Integer getHrentipoimpres() {
        return hrentipoimpres;
    }

    /**
     * @param hrecdescripcio2
     */
    public void setHrecdescripcio2(String hrecdescripcio2) {
        this.hrecdescripcio2 = hrecdescripcio2;
    }

    /**
     * @return
     */
    public String getHrecdescripcio2() {
        return hrecdescripcio2;
    }

    /**
     * @param hrecdescripcio3
     */
    public void setHrecdescripcio3(String hrecdescripcio3) {
        this.hrecdescripcio3 = hrecdescripcio3;
    }

    /**
     * @return
     */
    public String getHrecdescripcio3() {
        return hrecdescripcio3;
    }

    /**
     * @param hrecdescripcio4
     */
    public void setHrecdescripcio4(String hrecdescripcio4) {
        this.hrecdescripcio4 = hrecdescripcio4;
    }

    /**
     * @return
     */
    public String getHrecdescripcio4() {
        return hrecdescripcio4;
    }


    /**
     * @param hrenconsulta
     */
    public void setHrenconsulta(Long hrenconsulta) {
        this.hrenconsulta = hrenconsulta;
    }

    /**
     * @return
     */
    public Long getHrenconsulta() {
        return hrenconsulta;
    }

    /**
     * @param hrecdescripcio5
     */
    public void setHrecdescripcio5(String hrecdescripcio5) {
        this.hrecdescripcio5 = hrecdescripcio5;
    }

    /**
     * @return
     */
    public String getHrecdescripcio5() {
        return hrecdescripcio5;
    }

    /**
     * @param hredfecharegis
     */
    public void setHredfecharegis(Date hredfecharegis) {
        this.hredfecharegis = hredfecharegis;
    }

    /**
     * @return
     */
    public Date getHredfecharegis() {
        return hredfecharegis;
    }


}
