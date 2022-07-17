package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chsalaxprofe implements Serializable {

    /** identifier field */
    private ChsalaxprofeId id;

    /** nullable persistent field */
    private String hspcoperador;

    /** nullable persistent field */
    private Date hspdfechareg;
    
    /** nullable persistent field */
    private String hspcdescsala;

    /** nullable persistent field */
    private Integer version;

 
    /** default constructor */
    public Chsalaxprofe() {
        id = new ChsalaxprofeId();
    }


    public void setId(ChsalaxprofeId id) {
        this.id = id;
    }

    public ChsalaxprofeId getId() {
        return id;
    }

    public void setHspcoperador(String hspcoperador) {
        this.hspcoperador = hspcoperador;
    }

    public String getHspcoperador() {
        return hspcoperador;
    }

    public void setHspdfechareg(Date hspdfechareg) {
        this.hspdfechareg = hspdfechareg;
    }

    public Date getHspdfechareg() {
        return hspdfechareg;
    }


    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHspcdescsala(String hspcdescsala) {
        this.hspcdescsala = hspcdescsala;
    }

    public String getHspcdescsala() {
        return hspcdescsala;
    }
}
