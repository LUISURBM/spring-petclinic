package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Cisaludtool implements Serializable {

    /** identifier field */
    private String cstctipide;

    /** identifier field */
    private String cstanumide;

    /** identifier field */
    private String cstcnombre;

    /** identifier field */
    private String cstcapelli;

    /** identifier field */
    private String cstcfecate;

    /** identifier field */
    private String cstcservic;

    /** identifier field */
    private String cstctipoci;

    /** identifier field */
    private String cstccausae;

    /** identifier field */
    private String cstcciepri;

    /** identifier field */
    private String cstcdespri;

    /** identifier field */
    private String cstcciesec;

    /** identifier field */
    private String cstcdessec;

    /** identifier field */
    private String cstcclinic;

    /** identifier field */
    private String cstcprofes;

    /** identifier field */
    private String cstcdepart;

    /** identifier field */
    private String cstcciudad;

    /** identifier field */
    private String cstcsexo;

    /** identifier field */
    private String cstcedad;

    /** identifier field */
    private String cstcestado;

    /** identifier field */
    private String cstcerror;

    /** identifier field */
    private Integer cstnnomcli;

    /** identifier field */
    private Integer cstnconsec;

    /** identifier field */
    private Date cstdfeccon;

    /** identifier field */
    private Integer cstnconcep;

    /** identifier field */
    private String cstcautori;

    /** identifier field */
    private String cstccodcon;

    /** identifier field */
    private Integer cstnfincon;

    /** identifier field */
    private String cstncauext;

    /** identifier field */
    private String cstcdiagpr;

    /** identifier field */
    private String cstcdiagr1;

    /** identifier field */
    private Integer cstntipdia;

    /** identifier field */
    private BigDecimal cstavalcon;

    /** identifier field */
    private BigDecimal cstavalcuo;

    /** identifier field */
    private BigDecimal cstavalnet;

    /** identifier field */
    private Integer cstnclirip;

    /** identifier field */
    private Long cstnadmisi;

    /** identifier field */
    private String cstcsrvadm;

    /** identifier field */
    private Long cstlusuario;
    private int cstnsecuencia;
    private Integer version;
    
    //campos no persistentes
    private String sexo;
    private String tipoIden;

    /** full constructor */
    public Cisaludtool(String cstctipide, String cstanumide, String cstcnombre, String cstcapelli, String cstcfecate, String cstcservic, String cstctipoci, String cstccausae, String cstcciepri, String cstcdespri, String cstcciesec, String cstcdessec, String cstcclinic, String cstcprofes, String cstcdepart, String cstcciudad, String cstcsexo, String cstcedad, String cstcestado, String cstcerror, Integer cstnnomcli, Integer cstnconsec, Date cstdfeccon, Integer cstnconcep, String cstcautori, String cstccodcon, Integer cstnfincon, String cstncauext, String cstcdiagpr, String cstcdiagr1, Integer cstntipdia, BigDecimal cstavalcon, BigDecimal cstavalcuo, BigDecimal cstavalnet, Integer cstnclirip, Long cstnadmisi, String cstcsrvadm, Long cstlusuario) {
        this.cstctipide = cstctipide;
        this.cstanumide = cstanumide;
        this.cstcnombre = cstcnombre;
        this.cstcapelli = cstcapelli;
        this.cstcfecate = cstcfecate;
        this.cstcservic = cstcservic;
        this.cstctipoci = cstctipoci;
        this.cstccausae = cstccausae;
        this.cstcciepri = cstcciepri;
        this.cstcdespri = cstcdespri;
        this.cstcciesec = cstcciesec;
        this.cstcdessec = cstcdessec;
        this.cstcclinic = cstcclinic;
        this.cstcprofes = cstcprofes;
        this.cstcdepart = cstcdepart;
        this.cstcciudad = cstcciudad;
        this.cstcsexo = cstcsexo;
        this.cstcedad = cstcedad;
        this.cstcestado = cstcestado;
        this.cstcerror = cstcerror;
        this.cstnnomcli = cstnnomcli;
        this.cstnconsec = cstnconsec;
        this.cstdfeccon = cstdfeccon;
        this.cstnconcep = cstnconcep;
        this.cstcautori = cstcautori;
        this.cstccodcon = cstccodcon;
        this.cstnfincon = cstnfincon;
        this.cstncauext = cstncauext;
        this.cstcdiagpr = cstcdiagpr;
        this.cstcdiagr1 = cstcdiagr1;
        this.cstntipdia = cstntipdia;
        this.cstavalcon = cstavalcon;
        this.cstavalcuo = cstavalcuo;
        this.cstavalnet = cstavalnet;
        this.cstnclirip = cstnclirip;
        this.cstnadmisi = cstnadmisi;
        this.cstcsrvadm = cstcsrvadm;
        this.cstlusuario = cstlusuario;
    }

    /** default constructor */
    public Cisaludtool() {
    }

    public String getCstctipide() {
        return this.cstctipide;
    }

    public void setCstctipide(String cstctipide) {
        this.cstctipide = cstctipide;
    }

    public String getCstanumide() {
        return this.cstanumide;
    }

    public void setCstanumide(String cstanumide) {
        this.cstanumide = cstanumide;
    }

    public String getCstcnombre() {
        return this.cstcnombre;
    }

    public void setCstcnombre(String cstcnombre) {
        this.cstcnombre = cstcnombre;
    }

    public String getCstcapelli() {
        return this.cstcapelli;
    }

    public void setCstcapelli(String cstcapelli) {
        this.cstcapelli = cstcapelli;
    }

    public String getCstcfecate() {
        return this.cstcfecate;
    }

    public void setCstcfecate(String cstcfecate) {
        this.cstcfecate = cstcfecate;
    }

    public String getCstcservic() {
        return this.cstcservic;
    }

    public void setCstcservic(String cstcservic) {
        this.cstcservic = cstcservic;
    }

    public String getCstctipoci() {
        return this.cstctipoci;
    }

    public void setCstctipoci(String cstctipoci) {
        this.cstctipoci = cstctipoci;
    }

    public String getCstccausae() {
        return this.cstccausae;
    }

    public void setCstccausae(String cstccausae) {
        this.cstccausae = cstccausae;
    }

    public String getCstcciepri() {
        return this.cstcciepri;
    }

    public void setCstcciepri(String cstcciepri) {
        this.cstcciepri = cstcciepri;
    }

    public String getCstcdespri() {
        return this.cstcdespri;
    }

    public void setCstcdespri(String cstcdespri) {
        this.cstcdespri = cstcdespri;
    }

    public String getCstcciesec() {
        return this.cstcciesec;
    }

    public void setCstcciesec(String cstcciesec) {
        this.cstcciesec = cstcciesec;
    }

    public String getCstcdessec() {
        return this.cstcdessec;
    }

    public void setCstcdessec(String cstcdessec) {
        this.cstcdessec = cstcdessec;
    }

    public String getCstcclinic() {
        return this.cstcclinic;
    }

    public void setCstcclinic(String cstcclinic) {
        this.cstcclinic = cstcclinic;
    }

    public String getCstcprofes() {
        return this.cstcprofes;
    }

    public void setCstcprofes(String cstcprofes) {
        this.cstcprofes = cstcprofes;
    }

    public String getCstcdepart() {
        return this.cstcdepart;
    }

    public void setCstcdepart(String cstcdepart) {
        this.cstcdepart = cstcdepart;
    }

    public String getCstcciudad() {
        return this.cstcciudad;
    }

    public void setCstcciudad(String cstcciudad) {
        this.cstcciudad = cstcciudad;
    }

    public String getCstcsexo() {
        return this.cstcsexo;
    }

    public void setCstcsexo(String cstcsexo) {
        this.cstcsexo = cstcsexo;
    }

    public String getCstcedad() {
        return this.cstcedad;
    }

    public void setCstcedad(String cstcedad) {
        this.cstcedad = cstcedad;
    }

    public String getCstcestado() {
        return this.cstcestado;
    }

    public void setCstcestado(String cstcestado) {
        this.cstcestado = cstcestado;
    }

    public String getCstcerror() {
        return this.cstcerror;
    }

    public void setCstcerror(String cstcerror) {
        this.cstcerror = cstcerror;
    }

    public Integer getCstnnomcli() {
        return this.cstnnomcli;
    }

    public void setCstnnomcli(Integer cstnnomcli) {
        this.cstnnomcli = cstnnomcli;
    }

    public Integer getCstnconsec() {
        return this.cstnconsec;
    }

    public void setCstnconsec(Integer cstnconsec) {
        this.cstnconsec = cstnconsec;
    }

    public Date getCstdfeccon() {
        return this.cstdfeccon;
    }

    public void setCstdfeccon(Date cstdfeccon) {
        this.cstdfeccon = cstdfeccon;
    }

    public Integer getCstnconcep() {
        return this.cstnconcep;
    }

    public void setCstnconcep(Integer cstnconcep) {
        this.cstnconcep = cstnconcep;
    }

    public String getCstcautori() {
        return this.cstcautori;
    }

    public void setCstcautori(String cstcautori) {
        this.cstcautori = cstcautori;
    }

    public String getCstccodcon() {
        return this.cstccodcon;
    }

    public void setCstccodcon(String cstccodcon) {
        this.cstccodcon = cstccodcon;
    }

    public Integer getCstnfincon() {
        return this.cstnfincon;
    }

    public void setCstnfincon(Integer cstnfincon) {
        this.cstnfincon = cstnfincon;
    }

    public String getCstncauext() {
        return this.cstncauext;
    }

    public void setCstncauext(String cstncauext) {
        this.cstncauext = cstncauext;
    }

    public String getCstcdiagpr() {
        return this.cstcdiagpr;
    }

    public void setCstcdiagpr(String cstcdiagpr) {
        this.cstcdiagpr = cstcdiagpr;
    }

    public String getCstcdiagr1() {
        return this.cstcdiagr1;
    }

    public void setCstcdiagr1(String cstcdiagr1) {
        this.cstcdiagr1 = cstcdiagr1;
    }

    public Integer getCstntipdia() {
        return this.cstntipdia;
    }

    public void setCstntipdia(Integer cstntipdia) {
        this.cstntipdia = cstntipdia;
    }

    public BigDecimal getCstavalcon() {
        return this.cstavalcon;
    }

    public void setCstavalcon(BigDecimal cstavalcon) {
        this.cstavalcon = cstavalcon;
    }

    public BigDecimal getCstavalcuo() {
        return this.cstavalcuo;
    }

    public void setCstavalcuo(BigDecimal cstavalcuo) {
        this.cstavalcuo = cstavalcuo;
    }

    public BigDecimal getCstavalnet() {
        return this.cstavalnet;
    }

    public void setCstavalnet(BigDecimal cstavalnet) {
        this.cstavalnet = cstavalnet;
    }

    public Integer getCstnclirip() {
        return this.cstnclirip;
    }

    public void setCstnclirip(Integer cstnclirip) {
        this.cstnclirip = cstnclirip;
    }

    public Long getCstnadmisi() {
        return this.cstnadmisi;
    }

    public void setCstnadmisi(Long cstnadmisi) {
        this.cstnadmisi = cstnadmisi;
    }

    public String getCstcsrvadm() {
        return this.cstcsrvadm;
    }

    public void setCstcsrvadm(String cstcsrvadm) {
        this.cstcsrvadm = cstcsrvadm;
    }

    public Long getCstlusuario() {
        return this.cstlusuario;
    }

    public void setCstlusuario(Long cstlusuario) {
        this.cstlusuario = cstlusuario;
    }
    

    public String toString() {
        return new ToStringBuilder(this)
            .append("cstctipide", getCstctipide())
            .append("cstanumide", getCstanumide())
            .append("cstcnombre", getCstcnombre())
            .append("cstcapelli", getCstcapelli())
            .append("cstcfecate", getCstcfecate())
            .append("cstcservic", getCstcservic())
            .append("cstctipoci", getCstctipoci())
            .append("cstccausae", getCstccausae())
            .append("cstcciepri", getCstcciepri())
            .append("cstcdespri", getCstcdespri())
            .append("cstcciesec", getCstcciesec())
            .append("cstcdessec", getCstcdessec())
            .append("cstcclinic", getCstcclinic())
            .append("cstcprofes", getCstcprofes())
            .append("cstcdepart", getCstcdepart())
            .append("cstcciudad", getCstcciudad())
            .append("cstcsexo", getCstcsexo())
            .append("cstcedad", getCstcedad())
            .append("cstcestado", getCstcestado())
            .append("cstcerror", getCstcerror())
            .append("cstnnomcli", getCstnnomcli())
            .append("cstnconsec", getCstnconsec())
            .append("cstdfeccon", getCstdfeccon())
            .append("cstnconcep", getCstnconcep())
            .append("cstcautori", getCstcautori())
            .append("cstccodcon", getCstccodcon())
            .append("cstnfincon", getCstnfincon())
            .append("cstncauext", getCstncauext())
            .append("cstcdiagpr", getCstcdiagpr())
            .append("cstcdiagr1", getCstcdiagr1())
            .append("cstntipdia", getCstntipdia())
            .append("cstavalcon", getCstavalcon())
            .append("cstavalcuo", getCstavalcuo())
            .append("cstavalnet", getCstavalnet())
            .append("cstnclirip", getCstnclirip())
            .append("cstnadmisi", getCstnadmisi())
            .append("cstcsrvadm", getCstcsrvadm())
            .append("cstlusuario", getCstlusuario())
            .toString();
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setTipoIden(String tipoIden) {
        this.tipoIden = tipoIden;
    }

    public String getTipoIden() {
        return tipoIden;
    }

    public void setCstnsecuencia(int cstnsecuencia) {
        this.cstnsecuencia = cstnsecuencia;
    }

    public int getCstnsecuencia() {
        return cstnsecuencia;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }
}
