package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chpruerapi implements Serializable {

    /** identifier field */
    private Long hprlconsulta;

    /** nullable persistent field */
    private Long hprndepartamen;

    /** nullable persistent field */
    private Long hprnmunicipio;

    /** nullable persistent field */
    private String hprntemperatura;

    /** nullable persistent field */
    private String hprcvih;

    /** nullable persistent field */
    private String hprchepatitisb;

    /** nullable persistent field */
    private String hprchepatitisc;

    /** nullable persistent field */
    private String hprcsifilis;

    /** nullable persistent field */
    private String hprcprueemba;

    /** nullable persistent field */
    private String hprcmarcavih;

    /** nullable persistent field */
    private String hprclotevih;

    /** nullable persistent field */
    private String hprcreginvvih;

    /** nullable persistent field */
    private Date hprdfecvenvih;

    /** nullable persistent field */
    private String hprcresulvih;

    /** nullable persistent field */
    private String hprcmarcahepab;

    /** nullable persistent field */
    private String hprclotehepab;

    /** nullable persistent field */
    private String hprcreginvhepb;

    /** nullable persistent field */
        private Date hprdfecvenhepb;

    /** nullable persistent field */
    private String hprcresulhepab;

    /** nullable persistent field */
    private String hprcmarcahepac;

    /** nullable persistent field */
    private String hprclotehepac;

    /** nullable persistent field */
    private String hprcreginvhepc;

    /** nullable persistent field */
    private Date hprdfecvenhepc;

    /** nullable persistent field */
    private String hprcresulhepac;

    /** nullable persistent field */
    private String hprcmarcasifil;

    /** nullable persistent field */
    private String hprclotesifi;

    /** nullable persistent field */
    private String hprcreginvsif;

    /** nullable persistent field */
    private Date hprdfecvensif;

    /** nullable persistent field */
    private String hprcresulsifil;

    /** nullable persistent field */
    private String hprcmarcapruemb;

    /** nullable persistent field */
    private String hprclotepruemb;

    /** nullable persistent field */
    private String hprcreginvpruemb;

    /** nullable persistent field */
    private Date hprdfecvenpruemb;

    /** nullable persistent field */
    private String hprcresulpruemb;

    /** nullable persistent field */
    private String hprcobservacion;

    /** persistent field */
    private Date hprdfecregistr;

    /** persistent field */
    private String hprcoperador;

    /** nullable persistent field */
    private Integer version;
    
    private String nombreProfesional;
    
    private String cargoProfesional;

    /** full constructor */
    public Chpruerapi(Long hprlconsulta, Long hprndepartamen, Long hprnmunicipio, String hprntemperatura, String hprcvih, String hprchepatitisb, String hprchepatitisc, String hprcsifilis, String hprcprueemba, String hprcmarcavih, String hprclotevih, String hprcreginvvih, Date hprdfecvenvih, String hprcresulvih, String hprcmarcahepab, String hprclotehepab, String hprcreginvhepb, Date hprdfecvenhepb, String hprcresulhepab, String hprcmarcahepac, String hprclotehepac, String hprcreginvhepc, Date hprdfecvenhepc, String hprcresulhepac, String hprcmarcasifil, String hprclotesifi, String hprcreginvsif, Date hprdfecvensif, String hprcresulsifil, String hprcmarcapruemb, String hprclotepruemb, String hprcreginvpruemb, Date hprdfecvenpruemb, String hprcresulpruemb, String hprcobservacion, Date hprdfecregistr, String hprcoperador, Integer version) {
        this.hprlconsulta = hprlconsulta;
        this.hprndepartamen = hprndepartamen;
        this.hprnmunicipio = hprnmunicipio;
        this.hprntemperatura = hprntemperatura;
        this.hprcvih = hprcvih;
        this.hprchepatitisb = hprchepatitisb;
        this.hprchepatitisc = hprchepatitisc;
        this.hprcsifilis = hprcsifilis;
        this.hprcprueemba = hprcprueemba;
        this.hprcmarcavih = hprcmarcavih;
        this.hprclotevih = hprclotevih;
        this.hprcreginvvih = hprcreginvvih;
        this.hprdfecvenvih = hprdfecvenvih;
        this.hprcresulvih = hprcresulvih;
        this.hprcmarcahepab = hprcmarcahepab;
        this.hprclotehepab = hprclotehepab;
        this.hprcreginvhepb = hprcreginvhepb;
        this.hprdfecvenhepb = hprdfecvenhepb;
        this.hprcresulhepab = hprcresulhepab;
        this.hprcmarcahepac = hprcmarcahepac;
        this.hprclotehepac = hprclotehepac;
        this.hprcreginvhepc = hprcreginvhepc;
        this.hprdfecvenhepc = hprdfecvenhepc;
        this.hprcresulhepac = hprcresulhepac;
        this.hprcmarcasifil = hprcmarcasifil;
        this.hprclotesifi = hprclotesifi;
        this.hprcreginvsif = hprcreginvsif;
        this.hprdfecvensif = hprdfecvensif;
        this.hprcresulsifil = hprcresulsifil;
        this.hprcmarcapruemb = hprcmarcapruemb;
        this.hprclotepruemb = hprclotepruemb;
        this.hprcreginvpruemb = hprcreginvpruemb;
        this.hprdfecvenpruemb = hprdfecvenpruemb;
        this.hprcresulpruemb = hprcresulpruemb;
        this.hprcobservacion = hprcobservacion;
        this.hprdfecregistr = hprdfecregistr;
        this.hprcoperador = hprcoperador;
        this.version = version;
    }

    /** default constructor */
    public Chpruerapi() {
    }

    /** minimal constructor */
    public Chpruerapi(Long hprlconsulta, Date hprdfecregistr, String hprcoperador) {
        this.hprlconsulta = hprlconsulta;
        this.hprdfecregistr = hprdfecregistr;
        this.hprcoperador = hprcoperador;
    }

    public Long getHprlconsulta() {
        return this.hprlconsulta;
    }

    public void setHprlconsulta(Long hprlconsulta) {
        this.hprlconsulta = hprlconsulta;
    }

    public Long getHprndepartamen() {
        return this.hprndepartamen;
    }

    public void setHprndepartamen(Long hprndepartamen) {
        this.hprndepartamen = hprndepartamen;
    }

    public Long getHprnmunicipio() {
        return this.hprnmunicipio;
    }

    public void setHprnmunicipio(Long hprnmunicipio) {
        this.hprnmunicipio = hprnmunicipio;
    }

    public String getHprntemperatura() {
        return this.hprntemperatura;
    }

    public void setHprntemperatura(String hprntemperatura) {
        this.hprntemperatura = hprntemperatura;
    }

    public String getHprcvih() {
        return this.hprcvih;
    }

    public void setHprcvih(String hprcvih) {
        this.hprcvih = hprcvih;
    }

    public String getHprchepatitisb() {
        return this.hprchepatitisb;
    }

    public void setHprchepatitisb(String hprchepatitisb) {
        this.hprchepatitisb = hprchepatitisb;
    }

    public String getHprchepatitisc() {
        return this.hprchepatitisc;
    }

    public void setHprchepatitisc(String hprchepatitisc) {
        this.hprchepatitisc = hprchepatitisc;
    }

    public String getHprcsifilis() {
        return this.hprcsifilis;
    }

    public void setHprcsifilis(String hprcsifilis) {
        this.hprcsifilis = hprcsifilis;
    }

    public String getHprcprueemba() {
        return this.hprcprueemba;
    }

    public void setHprcprueemba(String hprcprueemba) {
        this.hprcprueemba = hprcprueemba;
    }

    public String getHprcmarcavih() {
        return this.hprcmarcavih;
    }

    public void setHprcmarcavih(String hprcmarcavih) {
        this.hprcmarcavih = hprcmarcavih;
    }

    public String getHprclotevih() {
        return this.hprclotevih;
    }

    public void setHprclotevih(String hprclotevih) {
        this.hprclotevih = hprclotevih;
    }

    public String getHprcreginvvih() {
        return this.hprcreginvvih;
    }

    public void setHprcreginvvih(String hprcreginvvih) {
        this.hprcreginvvih = hprcreginvvih;
    }

    public Date getHprdfecvenvih() {
        return this.hprdfecvenvih;
    }

    public void setHprdfecvenvih(Date hprdfecvenvih) {
        this.hprdfecvenvih = hprdfecvenvih;
    }

    public String getHprcresulvih() {
        return this.hprcresulvih;
    }

    public void setHprcresulvih(String hprcresulvih) {
        this.hprcresulvih = hprcresulvih;
    }

    public String getHprcmarcahepab() {
        return this.hprcmarcahepab;
    }

    public void setHprcmarcahepab(String hprcmarcahepab) {
        this.hprcmarcahepab = hprcmarcahepab;
    }

    public String getHprclotehepab() {
        return this.hprclotehepab;
    }

    public void setHprclotehepab(String hprclotehepab) {
        this.hprclotehepab = hprclotehepab;
    }

    public String getHprcreginvhepb() {
        return this.hprcreginvhepb;
    }

    public void setHprcreginvhepb(String hprcreginvhepb) {
        this.hprcreginvhepb = hprcreginvhepb;
    }

    public Date getHprdfecvenhepb() {
        return this.hprdfecvenhepb;
    }

    public void setHprdfecvenhepb(Date hprdfecvenhepb) {
        this.hprdfecvenhepb = hprdfecvenhepb;
    }

    public String getHprcresulhepab() {
        return this.hprcresulhepab;
    }

    public void setHprcresulhepab(String hprcresulhepab) {
        this.hprcresulhepab = hprcresulhepab;
    }

    public String getHprcmarcahepac() {
        return this.hprcmarcahepac;
    }

    public void setHprcmarcahepac(String hprcmarcahepac) {
        this.hprcmarcahepac = hprcmarcahepac;
    }

    public String getHprclotehepac() {
        return this.hprclotehepac;
    }

    public void setHprclotehepac(String hprclotehepac) {
        this.hprclotehepac = hprclotehepac;
    }

    public String getHprcreginvhepc() {
        return this.hprcreginvhepc;
    }

    public void setHprcreginvhepc(String hprcreginvhepc) {
        this.hprcreginvhepc = hprcreginvhepc;
    }

    public Date getHprdfecvenhepc() {
        return this.hprdfecvenhepc;
    }

    public void setHprdfecvenhepc(Date hprdfecvenhepc) {
        this.hprdfecvenhepc = hprdfecvenhepc;
    }

    public String getHprcresulhepac() {
        return this.hprcresulhepac;
    }

    public void setHprcresulhepac(String hprcresulhepac) {
        this.hprcresulhepac = hprcresulhepac;
    }

    public String getHprcmarcasifil() {
        return this.hprcmarcasifil;
    }

    public void setHprcmarcasifil(String hprcmarcasifil) {
        this.hprcmarcasifil = hprcmarcasifil;
    }

    public String getHprclotesifi() {
        return this.hprclotesifi;
    }

    public void setHprclotesifi(String hprclotesifi) {
        this.hprclotesifi = hprclotesifi;
    }

    public String getHprcreginvsif() {
        return this.hprcreginvsif;
    }

    public void setHprcreginvsif(String hprcreginvsif) {
        this.hprcreginvsif = hprcreginvsif;
    }

    public Date getHprdfecvensif() {
        return this.hprdfecvensif;
    }

    public void setHprdfecvensif(Date hprdfecvensif) {
        this.hprdfecvensif = hprdfecvensif;
    }

    public String getHprcresulsifil() {
        return this.hprcresulsifil;
    }

    public void setHprcresulsifil(String hprcresulsifil) {
        this.hprcresulsifil = hprcresulsifil;
    }

    public String getHprcmarcapruemb() {
        return this.hprcmarcapruemb;
    }

    public void setHprcmarcapruemb(String hprcmarcapruemb) {
        this.hprcmarcapruemb = hprcmarcapruemb;
    }

    public String getHprclotepruemb() {
        return this.hprclotepruemb;
    }

    public void setHprclotepruemb(String hprclotepruemb) {
        this.hprclotepruemb = hprclotepruemb;
    }

    public String getHprcreginvpruemb() {
        return this.hprcreginvpruemb;
    }

    public void setHprcreginvpruemb(String hprcreginvpruemb) {
        this.hprcreginvpruemb = hprcreginvpruemb;
    }

    public Date getHprdfecvenpruemb() {
        return this.hprdfecvenpruemb;
    }

    public void setHprdfecvenpruemb(Date hprdfecvenpruemb) {
        this.hprdfecvenpruemb = hprdfecvenpruemb;
    }

    public String getHprcresulpruemb() {
        return this.hprcresulpruemb;
    }

    public void setHprcresulpruemb(String hprcresulpruemb) {
        this.hprcresulpruemb = hprcresulpruemb;
    }

    public String getHprcobservacion() {
        return this.hprcobservacion;
    }

    public void setHprcobservacion(String hprcobservacion) {
        this.hprcobservacion = hprcobservacion;
    }

    public Date getHprdfecregistr() {
        return this.hprdfecregistr;
    }

    public void setHprdfecregistr(Date hprdfecregistr) {
        this.hprdfecregistr = hprdfecregistr;
    }

    public String getHprcoperador() {
        return this.hprcoperador;
    }

    public void setHprcoperador(String hprcoperador) {
        this.hprcoperador = hprcoperador;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hprlconsulta", getHprlconsulta())
            .toString();
    }

    public void setNombreProfesional(String nombreProfesional) {
        this.nombreProfesional = nombreProfesional;
    }

    public String getNombreProfesional() {
        return nombreProfesional;
    }

    public void setCargoProfesional(String cargoProfesional) {
        this.cargoProfesional = cargoProfesional;
    }

    public String getCargoProfesional() {
        return cargoProfesional;
    }
}
