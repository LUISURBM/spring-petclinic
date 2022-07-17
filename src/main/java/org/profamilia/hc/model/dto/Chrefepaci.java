package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chrefepaci implements Serializable {

    /** identifier field */
    private ChrefepaciPK id;

    /** persistent field */
    private String hrpcrefepaci;

    /** persistent field */
    private String hrpcinstrece;

    /** persistent field */
    private String hrpchoraconf;

    /** persistent field */
    private String hrpcminuconf;

    /** persistent field */
    private String hrpcpresambu;
    
    /** persistent field */
    private String hrpctipoambu;
    
    /** persistent field */
    private String hrpchorallega;
    
    /** persistent field */
    private String hrpcminullega;    
    
    /** persistent field */
    private String hrpctripurecib;
     
    /** persistent field */
    private String hrpchorasali;
    
    /** persistent field */
    private String hrpcminusali;
    
    /** persistent field */
    private String hrpchoraingr;
    
    /** persistent field */
    private String hrpcminuingr;
    
    /** persistent field */
    private String hrpcnomfunges;
    
    /** persistent field */
    private String hrpcusureg;

    /** persistent field */
    private Date hrpdfecreg;
 
    /** nullable persistent field */
    private Integer version;
  

    /** default constructor */
    public Chrefepaci() {
    }


    public void setHrpcrefepaci(String hrpcrefepaci) {
        this.hrpcrefepaci = hrpcrefepaci;
    }

    public String getHrpcrefepaci() {
        return hrpcrefepaci;
    }

    public void setHrpcinstrece(String hrpcinstrece) {
        this.hrpcinstrece = hrpcinstrece;
    }

    public String getHrpcinstrece() {
        return hrpcinstrece;
    }

    public void setHrpchoraconf(String hrpchoraconf) {
        this.hrpchoraconf = hrpchoraconf;
    }

    public String getHrpchoraconf() {
        return hrpchoraconf;
    }

    public void setHrpcminuconf(String hrpcminuconf) {
        this.hrpcminuconf = hrpcminuconf;
    }

    public String getHrpcminuconf() {
        return hrpcminuconf;
    }

    public void setHrpcpresambu(String hrpcpresambu) {
        this.hrpcpresambu = hrpcpresambu;
    }

    public String getHrpcpresambu() {
        return hrpcpresambu;
    }

    public void setHrpctipoambu(String hrpctipoambu) {
        this.hrpctipoambu = hrpctipoambu;
    }

    public String getHrpctipoambu() {
        return hrpctipoambu;
    }

    public void setHrpchorallega(String hrpchorallega) {
        this.hrpchorallega = hrpchorallega;
    }

    public String getHrpchorallega() {
        return hrpchorallega;
    }

    public void setHrpcminullega(String hrpcminullega) {
        this.hrpcminullega = hrpcminullega;
    }

    public String getHrpcminullega() {
        return hrpcminullega;
    }

    public void setHrpctripurecib(String hrpctripurecib) {
        this.hrpctripurecib = hrpctripurecib;
    }

    public String getHrpctripurecib() {
        return hrpctripurecib;
    }

    public void setHrpchorasali(String hrpchorasali) {
        this.hrpchorasali = hrpchorasali;
    }

    public String getHrpchorasali() {
        return hrpchorasali;
    }

    public void setHrpcminusali(String hrpcminusali) {
        this.hrpcminusali = hrpcminusali;
    }

    public String getHrpcminusali() {
        return hrpcminusali;
    }

    public void setHrpchoraingr(String hrpchoraingr) {
        this.hrpchoraingr = hrpchoraingr;
    }

    public String getHrpchoraingr() {
        return hrpchoraingr;
    }

    public void setHrpcminuingr(String hrpcminuingr) {
        this.hrpcminuingr = hrpcminuingr;
    }

    public String getHrpcminuingr() {
        return hrpcminuingr;
    }

    public void setHrpcnomfunges(String hrpcnomfunges) {
        this.hrpcnomfunges = hrpcnomfunges;
    }

    public String getHrpcnomfunges() {
        return hrpcnomfunges;
    }

    public void setHrpcusureg(String hrpcusureg) {
        this.hrpcusureg = hrpcusureg;
    }

    public String getHrpcusureg() {
        return hrpcusureg;
    }

    public void setHrpdfecreg(Date hrpdfecreg) {
        this.hrpdfecreg = hrpdfecreg;
    }

    public Date getHrpdfecreg() {
        return hrpdfecreg;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setId(ChrefepaciPK id) {
        this.id = id;
    }

    public ChrefepaciPK getId() {
        return id;
    }
}
