package org.profamilia.hc.model.dto;
import java.util.Date;


/**
 * Cpusuxsala generated by hbm2java
 */

public class Cpusuxsala  implements java.io.Serializable {



    private CpusuxsalaId id;
    private Date cusdfecreg;
    private String cuscusureg;
    private Integer version;

   /** default constructor */
    public Cpusuxsala() {
    }


    // HS == CpusuxsalaId


    /**
     * @param id
     */
    public void setId(CpusuxsalaId id) {
        this.id = id;
    }

    /**
     * @return
     */
    public CpusuxsalaId getId() {
        return id;
    }

    /**
     * @param cusdfecreg
     */
    public void setCusdfecreg(Date cusdfecreg) {
        this.cusdfecreg = cusdfecreg;
    }

    /**
     * @return
     */
    public Date getCusdfecreg() {
        return cusdfecreg;
    }

    /**
     * @param cuscusureg
     */
    public void setCuscusureg(String cuscusureg) {
        this.cuscusureg = cuscusureg;
    }

    /**
     * @return
     */
    public String getCuscusureg() {
        return cuscusureg;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return
     */
    public Integer getVersion() {
        return version;
    }
}
