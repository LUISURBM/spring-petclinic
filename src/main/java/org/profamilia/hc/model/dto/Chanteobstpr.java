package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chanteobstpr implements Serializable {

    /** identifier field */
    private ChanteobstprPK id;

    private Integer haonnumgesta;
    private String haocintergene;
    private Integer haonnumaborto;
    private Integer haonectopico;
    private Integer haonmuerto;
    private Integer haonmolas;
    private String haocplacprevi;
    private String haocabrupio;
    private String haocrupprememb;
    private String haocpolhidramn;
    private String haocoligohidra;
    private String haocretcrcint;
    private Integer haonnumparto;
    private Date haodfup;
    private String haocparunimul;
    private String haoctipparto;
    private String haocviaparto;
    private String haocretplace;
    private String haocinfepost;
    private String haochemoobst;
    private String haoceclampsia;
    private String haocdeseclamp;
    private String haocpreclamps;
    private String haocdesprecla;
    private Integer haonnacivivo;
    private Integer haonmortina;
    private String haocmalformaci;
    private String haocmalforcual;
    private String haocmueperinat;
    private String haocmuepercual;
    private String haocleucorreas;
    private String haoccolposcopi;
    private String haocamenaparto;
    private String haocamenaabort;
    private String haocgemelar;
    private Integer haonpesonacer;
    
    /** nullable persistent field */
    private Date haodfecharegis;

    /** nullable persistent field */
    private String haocoperador;

    /** nullable persistent field */
    private Integer version;
    
    /** nullable persistent field */ 
    private String haocperintcor;
    
    /** nullable persistent field */
    private String haocpeincocual;
    
    /** default constructor */
    public Chanteobstpr() {
    }


    public void setId(ChanteobstprPK id) {
        this.id = id;
    }

    public ChanteobstprPK getId() {
        return id;
    }



    public void setHaodfecharegis(Date haodfecharegis) {
        this.haodfecharegis = haodfecharegis;
    }

    public Date getHaodfecharegis() {
        return haodfecharegis;
    }

    public void setHaocoperador(String haocoperador) {
        this.haocoperador = haocoperador;
    }

    public String getHaocoperador() {
        return haocoperador;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHaonnumgesta(Integer haonnumgesta) {
        this.haonnumgesta = haonnumgesta;
    }

    public Integer getHaonnumgesta() {
        return haonnumgesta;
    }

    public void setHaocintergene(String haocintergene) {
        this.haocintergene = haocintergene;
    }

    public String getHaocintergene() {
        return haocintergene;
    }

    public void setHaonnumaborto(Integer haonnumaborto) {
        this.haonnumaborto = haonnumaborto;
    }

    public Integer getHaonnumaborto() {
        return haonnumaborto;
    }

    public void setHaonectopico(Integer haonectopico) {
        this.haonectopico = haonectopico;
    }

    public Integer getHaonectopico() {
        return haonectopico;
    }

    public void setHaonmuerto(Integer haonmuerto) {
        this.haonmuerto = haonmuerto;
    }

    public Integer getHaonmuerto() {
        return haonmuerto;
    }

    public void setHaocplacprevi(String haocplacprevi) {
        this.haocplacprevi = haocplacprevi;
    }

    public String getHaocplacprevi() {
        return haocplacprevi;
    }

    public void setHaocabrupio(String haocabrupio) {
        this.haocabrupio = haocabrupio;
    }

    public String getHaocabrupio() {
        return haocabrupio;
    }

    public void setHaocrupprememb(String haocrupprememb) {
        this.haocrupprememb = haocrupprememb;
    }

    public String getHaocrupprememb() {
        return haocrupprememb;
    }

    public void setHaocpolhidramn(String haocpolhidramn) {
        this.haocpolhidramn = haocpolhidramn;
    }

    public String getHaocpolhidramn() {
        return haocpolhidramn;
    }

    public void setHaocoligohidra(String haocoligohidra) {
        this.haocoligohidra = haocoligohidra;
    }

    public String getHaocoligohidra() {
        return haocoligohidra;
    }

    public void setHaocretcrcint(String haocretcrcint) {
        this.haocretcrcint = haocretcrcint;
    }

    public String getHaocretcrcint() {
        return haocretcrcint;
    }

    public void setHaonnumparto(Integer haonnumparto) {
        this.haonnumparto = haonnumparto;
    }

    public Integer getHaonnumparto() {
        return haonnumparto;
    }

    public void setHaodfup(Date haodfup) {
        this.haodfup = haodfup;
    }

    public Date getHaodfup() {
        return haodfup;
    }

    public void setHaocparunimul(String haocparunimul) {
        this.haocparunimul = haocparunimul;
    }

    public String getHaocparunimul() {
        return haocparunimul;
    }

    public void setHaoctipparto(String haoctipparto) {
        this.haoctipparto = haoctipparto;
    }

    public String getHaoctipparto() {
        return haoctipparto;
    }

    public void setHaocviaparto(String haocviaparto) {
        this.haocviaparto = haocviaparto;
    }

    public String getHaocviaparto() {
        return haocviaparto;
    }

    public void setHaocretplace(String haocretplace) {
        this.haocretplace = haocretplace;
    }

    public String getHaocretplace() {
        return haocretplace;
    }

    public void setHaocinfepost(String haocinfepost) {
        this.haocinfepost = haocinfepost;
    }

    public String getHaocinfepost() {
        return haocinfepost;
    }

    public void setHaochemoobst(String haochemoobst) {
        this.haochemoobst = haochemoobst;
    }

    public String getHaochemoobst() {
        return haochemoobst;
    }

    public void setHaoceclampsia(String haoceclampsia) {
        this.haoceclampsia = haoceclampsia;
    }

    public String getHaoceclampsia() {
        return haoceclampsia;
    }

    public void setHaocdeseclamp(String haocdeseclamp) {
        this.haocdeseclamp = haocdeseclamp;
    }

    public String getHaocdeseclamp() {
        return haocdeseclamp;
    }

    public void setHaocpreclamps(String haocpreclamps) {
        this.haocpreclamps = haocpreclamps;
    }

    public String getHaocpreclamps() {
        return haocpreclamps;
    }

    public void setHaocdesprecla(String haocdesprecla) {
        this.haocdesprecla = haocdesprecla;
    }

    public String getHaocdesprecla() {
        return haocdesprecla;
    }

    public void setHaonnacivivo(Integer haonnacivivo) {
        this.haonnacivivo = haonnacivivo;
    }

    public Integer getHaonnacivivo() {
        return haonnacivivo;
    }

    public void setHaonmortina(Integer haonmortina) {
        this.haonmortina = haonmortina;
    }

    public Integer getHaonmortina() {
        return haonmortina;
    }

    public void setHaocmalformaci(String haocmalformaci) {
        this.haocmalformaci = haocmalformaci;
    }

    public String getHaocmalformaci() {
        return haocmalformaci;
    }

    public void setHaocmalforcual(String haocmalforcual) {
        this.haocmalforcual = haocmalforcual;
    }

    public String getHaocmalforcual() {
        return haocmalforcual;
    }

    public void setHaocmueperinat(String haocmueperinat) {
        this.haocmueperinat = haocmueperinat;
    }

    public String getHaocmueperinat() {
        return haocmueperinat;
    }

    public void setHaocmuepercual(String haocmuepercual) {
        this.haocmuepercual = haocmuepercual;
    }

    public String getHaocmuepercual() {
        return haocmuepercual;
    }

    public void setHaocleucorreas(String haocleucorreas) {
        this.haocleucorreas = haocleucorreas;
    }

    public String getHaocleucorreas() {
        return haocleucorreas;
    }

    public void setHaoccolposcopi(String haoccolposcopi) {
        this.haoccolposcopi = haoccolposcopi;
    }

    public String getHaoccolposcopi() {
        return haoccolposcopi;
    }

    public void setHaocamenaparto(String haocamenaparto) {
        this.haocamenaparto = haocamenaparto;
    }

    public String getHaocamenaparto() {
        return haocamenaparto;
    }

    public void setHaocamenaabort(String haocamenaabort) {
        this.haocamenaabort = haocamenaabort;
    }

    public String getHaocamenaabort() {
        return haocamenaabort;
    }

    public void setHaocgemelar(String haocgemelar) {
        this.haocgemelar = haocgemelar;
    }

    public String getHaocgemelar() {
        return haocgemelar;
    }

    public void setHaonpesonacer(Integer haonpesonacer) {
        this.haonpesonacer = haonpesonacer;
    }

    public Integer getHaonpesonacer() {
        return haonpesonacer;
    }

    public void setHaonmolas(Integer haonmolas) {
        this.haonmolas = haonmolas;
    }

    public Integer getHaonmolas() {
        return haonmolas;
    }

    public void setHaocperintcor(String haocperiointer) {
        this.haocperintcor = haocperiointer;
    }

    public String getHaocperintcor() {
        return haocperintcor;
    }

    public void setHaocpeincocual(String haocperiintecual) {
        this.haocpeincocual = haocperiintecual;
    }

    public String getHaocpeincocual() {
        return haocpeincocual;
    }
}
