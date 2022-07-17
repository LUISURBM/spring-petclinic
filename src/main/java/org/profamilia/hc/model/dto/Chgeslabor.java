package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chgeslabor implements Serializable {

    /** identifier field */
    private Long hglnconsec;

    /** persistent field */
    private Long hglnclinica;

    /** persistent field */
    private Long hglncodprof;

    /** persistent field */
    private Date hgldfechreg;

    /** persistent field */
    private String hglcusuareg;

    /** persistent field */
    private String hglcestado;

    /** persistent field */
    private Integer version;

    /** full constructor */
    public Chgeslabor(Long hglnconsec, Long hglnclinica, Long hglncodprof, Date hgldfechreg, String hglcusuareg, String hglcestado, Integer version) {
        this.hglnconsec = hglnconsec;
        this.hglnclinica = hglnclinica;
        this.hglncodprof = hglncodprof;
        this.hgldfechreg = hgldfechreg;
        this.hglcusuareg = hglcusuareg;
        this.hglcestado = hglcestado;
        this.version = version;
    }

    /** default constructor */
    public Chgeslabor() {
    }

    /** 
     * 		       COSECUTIVO
     * 		    
     */
    public Long getHglnconsec() {
        return this.hglnconsec;
    }

    public void setHglnconsec(Long hglnconsec) {
        this.hglnconsec = hglnconsec;
    }

    public Long getHglnclinica() {
        return this.hglnclinica;
    }

    public void setHglnclinica(Long hglnclinica) {
        this.hglnclinica = hglnclinica;
    }

    public Long getHglncodprof() {
        return this.hglncodprof;
    }

    public void setHglncodprof(Long hglncodprof) {
        this.hglncodprof = hglncodprof;
    }

    public Date getHgldfechreg() {
        return this.hgldfechreg;
    }

    public void setHgldfechreg(Date hgldfechreg) {
        this.hgldfechreg = hgldfechreg;
    }

    public String getHglcusuareg() {
        return this.hglcusuareg;
    }

    public void setHglcusuareg(String hglcusuareg) {
        this.hglcusuareg = hglcusuareg;
    }

    public String getHglcestado() {
        return this.hglcestado;
    }

    public void setHglcestado(String hglcestado) {
        this.hglcestado = hglcestado;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hglnconsec", getHglnconsec())
            .toString();
    }

}
