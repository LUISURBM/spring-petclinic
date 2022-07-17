package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chcertasiad implements Serializable {

    /** identifier field */
    private Long hcalnumero;

    /** persistent field */
    private Date hcadfechareg;

    /** persistent field */
    private String hcaccertifica;

    /** persistent field */
    private String hcacoperador;

    /** nullable persistent field */
    private String hcaetipoideaco;

    /** nullable persistent field */
    private Long hcaanumideacom;

    /** nullable persistent field */
    private String hcacnombreacom;

    /** nullable persistent field */
    private Integer version;

    /** full constructor */
    public Chcertasiad(Long hcalnumero, Date hcadfechareg, String hcaccertifica, String hcacoperador, String hcaetipoideaco, Long hcaanumideacom, String hcacnombreacom, Integer version) {
        this.hcalnumero = hcalnumero;
        this.hcadfechareg = hcadfechareg;
        this.hcaccertifica = hcaccertifica;
        this.hcacoperador = hcacoperador;
        this.hcaetipoideaco = hcaetipoideaco;
        this.hcaanumideacom = hcaanumideacom;
        this.hcacnombreacom = hcacnombreacom;
        this.version = version;
    }

    /** default constructor */
    public Chcertasiad() {
    }

    /** minimal constructor */
    public Chcertasiad(Long hcalnumero, Date hcadfechareg, String hcaccertifica, String hcacoperador) {
        this.hcalnumero = hcalnumero;
        this.hcadfechareg = hcadfechareg;
        this.hcaccertifica = hcaccertifica;
        this.hcacoperador = hcacoperador;
    }

    public Long getHcalnumero() {
        return this.hcalnumero;
    }

    public void setHcalnumero(Long hcalnumero) {
        this.hcalnumero = hcalnumero;
    }

    public Date getHcadfechareg() {
        return this.hcadfechareg;
    }

    public void setHcadfechareg(Date hcadfechareg) {
        this.hcadfechareg = hcadfechareg;
    }

    public String getHcaccertifica() {
        return this.hcaccertifica;
    }

    public void setHcaccertifica(String hcaccertifica) {
        this.hcaccertifica = hcaccertifica;
    }

    public String getHcacoperador() {
        return this.hcacoperador;
    }

    public void setHcacoperador(String hcacoperador) {
        this.hcacoperador = hcacoperador;
    }

    public String getHcaetipoideaco() {
        return this.hcaetipoideaco;
    }

    public void setHcaetipoideaco(String hcaetipoideaco) {
        this.hcaetipoideaco = hcaetipoideaco;
    }

    public Long getHcaanumideacom() {
        return this.hcaanumideacom;
    }

    public void setHcaanumideacom(Long hcaanumideacom) {
        this.hcaanumideacom = hcaanumideacom;
    }

    public String getHcacnombreacom() {
        return this.hcacnombreacom;
    }

    public void setHcacnombreacom(String hcacnombreacom) {
        this.hcacnombreacom = hcacnombreacom;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hcalnumero", getHcalnumero())
            .toString();
    }

}
