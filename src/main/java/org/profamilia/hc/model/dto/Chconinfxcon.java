package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chconinfxcon implements Serializable {

    /** identifier field */
    private Long hcicnconsec;

    /** nullable persistent field */
    private Long hcicnconsulta;

    /** nullable persistent field */
    private Chplanconsinfo hcicnnucoin;

    /** nullable persistent field */
    private String hciccusuaregi;

    /** nullable persistent field */
    private Date hcicdfechregi;

    /** nullable persistent field */
    private Integer version;
    

    /** full constructor */
    public Chconinfxcon(Long hcicnconsec, Long hcicnconsulta, Chplanconsinfo hcicnnucoin, String hciccusuaregi, Date hcicdfechregi, Integer version) {
        this.hcicnconsec = hcicnconsec;
        this.hcicnconsulta = hcicnconsulta;
        this.hcicnnucoin = hcicnnucoin;
        this.hciccusuaregi = hciccusuaregi;
        this.hcicdfechregi = hcicdfechregi;
        this.version = version;
    }

    /** default constructor */
    public Chconinfxcon() {
    }

    /** minimal constructor */
    public Chconinfxcon(Long hcicnconsec) {
        this.hcicnconsec = hcicnconsec;
    }

    /** 
     * 		       Consecutivo
     * 		    
     */
    public Long getHcicnconsec() {
        return this.hcicnconsec;
    }

    public void setHcicnconsec(Long hcicnconsec) {
        this.hcicnconsec = hcicnconsec;
    }

    public Long getHcicnconsulta() {
        return this.hcicnconsulta;
    }

    public void setHcicnconsulta(Long hcicnconsulta) {
        this.hcicnconsulta = hcicnconsulta;
    }

    public Chplanconsinfo getHcicnnucoin() {
        return this.hcicnnucoin;
    }

    public void setHcicnnucoin(Chplanconsinfo hcicnnucoin) {
        this.hcicnnucoin = hcicnnucoin;
    }

    public String getHciccusuaregi() {
        return this.hciccusuaregi;
    }

    public void setHciccusuaregi(String hciccusuaregi) {
        this.hciccusuaregi = hciccusuaregi;
    }

    public Date getHcicdfechregi() {
        return this.hcicdfechregi;
    }

    public void setHcicdfechregi(Date hcicdfechregi) {
        this.hcicdfechregi = hcicdfechregi;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hcicnconsec", getHcicnconsec())
            .toString();
    }

}
