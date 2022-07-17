package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chdatosadvacuna implements Serializable {

    /** identifier field */
    private Long hdavnconsulta;

    /** persistent field */
    private Integer hdavndepart;

    /** persistent field */
    private Integer hdavnmuni;
    
    private String Hdacdiscapadid; 
    
    private String hdacdiscaselec;

    /** nullable persistent field */
    private Integer hdavnumcom;

    /** persistent field */
    private String hdavccondesplaz;

    /** persistent field */
    private String hdavcvicconflic;

    /** persistent field */
    private String hdavcestuact;

    /** nullable persistent field */
    private String hdavcinstitucion;

    /** nullable persistent field */
    private Date hdavdfur;

    /** nullable persistent field */
    private String hdavccondusua;

    /** nullable persistent field */
    private Integer hdavcembact;

    /** nullable persistent field */
    private Date hdavdfecpart;

    /** persistent field */
    private Date hdavdfecreg;

    /** persistent field */
    private String hdavcusuareg;

    /** nullable persistent field */
    private BigDecimal version;

    
    /** persistent field */
    private Long hdavnusuario;
    
    

    /** full constructor */
    public Chdatosadvacuna(Long hdavnconsulta, Integer hdavndepart, Integer hdavnmuni, Integer hdavnumcom, String hdavccondesplaz, String hdavcvicconflic, String hdavcestuact, String hdavcinstitucion, Date hdavdfur, String hdavccondusua, Integer hdavcembact, Date hdavdfecpart, Date hdavdfecreg, String hdavcusuareg, BigDecimal version) {
        this.hdavnconsulta = hdavnconsulta;
        this.hdavndepart = hdavndepart;
        this.hdavnmuni = hdavnmuni;
        this.hdavnumcom = hdavnumcom;
        this.hdavccondesplaz = hdavccondesplaz;
        this.hdavcvicconflic = hdavcvicconflic;
        this.hdavcestuact = hdavcestuact;
        this.hdavcinstitucion = hdavcinstitucion;
        this.hdavdfur = hdavdfur;
        this.hdavccondusua = hdavccondusua;
        this.hdavcembact = hdavcembact;
        this.hdavdfecpart = hdavdfecpart;
        this.hdavdfecreg = hdavdfecreg;
        this.hdavcusuareg = hdavcusuareg;
        this.version = version;
    }

    /** default constructor */
    public Chdatosadvacuna() {
    }

    /** minimal constructor */
    public Chdatosadvacuna(Long hdavnconsulta, Integer hdavndepart, Integer hdavnmuni, String hdavccondesplaz, String hdavcvicconflic, String hdavcestuact, Date hdavdfecreg, String hdavcusuareg) {
        this.hdavnconsulta = hdavnconsulta;
        this.hdavndepart = hdavndepart;
        this.hdavnmuni = hdavnmuni;
        this.hdavccondesplaz = hdavccondesplaz;
        this.hdavcvicconflic = hdavcvicconflic;
        this.hdavcestuact = hdavcestuact;
        this.hdavdfecreg = hdavdfecreg;
        this.hdavcusuareg = hdavcusuareg;
    }

    /** 
     * 		       Codigo consulta
     * 		    
     */
     
  
    public Integer getHdavndepart() {
        return this.hdavndepart;
    }

    public void setHdavndepart(Integer hdavndepart) {
        this.hdavndepart = hdavndepart;
    }

    public Integer getHdavnmuni() {
        return this.hdavnmuni;
    }

    public void setHdavnmuni(Integer hdavnmuni) {
        this.hdavnmuni = hdavnmuni;
    }

    public Integer getHdavnumcom() {
        return this.hdavnumcom;
    }

    public void setHdavnumcom(Integer hdavnumcom) {
        this.hdavnumcom = hdavnumcom;
    }

    public String getHdavccondesplaz() {
        return this.hdavccondesplaz;
    }

    public void setHdavccondesplaz(String hdavccondesplaz) {
        this.hdavccondesplaz = hdavccondesplaz;
    }

    public String getHdavcvicconflic() {
        return this.hdavcvicconflic;
    }

    public void setHdavcvicconflic(String hdavcvicconflic) {
        this.hdavcvicconflic = hdavcvicconflic;
    }

    public String getHdavcestuact() {
        return this.hdavcestuact;
    }

    public void setHdavcestuact(String hdavcestuact) {
        this.hdavcestuact = hdavcestuact;
    }

    public String getHdavcinstitucion() {
        return this.hdavcinstitucion;
    }

    public void setHdavcinstitucion(String hdavcinstitucion) {
        this.hdavcinstitucion = hdavcinstitucion;
    }

    public Date getHdavdfur() {
        return this.hdavdfur;
    }

    public void setHdavdfur(Date hdavdfur) {
        this.hdavdfur = hdavdfur;
    }

    public String getHdavccondusua() {
        return this.hdavccondusua;
    }

    public void setHdavccondusua(String hdavccondusua) {
        this.hdavccondusua = hdavccondusua;
    }

    public Integer getHdavcembact() {
        return this.hdavcembact;
    }

    public void setHdavcembact(Integer hdavcembact) {
        this.hdavcembact = hdavcembact;
    }

    public Date getHdavdfecpart() {
        return this.hdavdfecpart;
    }

    public void setHdavdfecpart(Date hdavdfecpart) {
        this.hdavdfecpart = hdavdfecpart;
    }

    public Date getHdavdfecreg() {
        return this.hdavdfecreg;
    }

    public void setHdavdfecreg(Date hdavdfecreg) {
        this.hdavdfecreg = hdavdfecreg;
    }

    public String getHdavcusuareg() {
        return this.hdavcusuareg;
    }

    public void setHdavcusuareg(String hdavcusuareg) {
        this.hdavcusuareg = hdavcusuareg;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hdavnconsulta", getHdavnconsulta())
            .toString();
    }

    public void setHdavnconsulta(Long hdavnconsulta) {
        this.hdavnconsulta = hdavnconsulta;
    }

    public Long getHdavnconsulta() {
        return hdavnconsulta;
    }

    public void setHdavnusuario(Long hdavnusuario) {
        this.hdavnusuario = hdavnusuario;
    }

    public Long getHdavnusuario() {
        return hdavnusuario;
    }

    public void setHdacdiscapadid(String hdacdiscapadid) {
        this.Hdacdiscapadid = hdacdiscapadid;
    }

    public String getHdacdiscapadid() {
        return Hdacdiscapadid;
    }

    public void setHdacdiscaselec(String hdacdiscaselec) {
        this.hdacdiscaselec = hdacdiscaselec;
    }

    public String getHdacdiscaselec() {
        return hdacdiscaselec;
    }
}
