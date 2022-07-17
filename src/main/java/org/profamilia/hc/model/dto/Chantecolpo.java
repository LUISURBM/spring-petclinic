package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chantecolpo implements Serializable {

    /** identifier field */
    private ChantecolpoPK id;


    /** nullable persistent field */
    private Date hacdfecregistr;

    /** nullable persistent field */
    private String haccoperador;

    /** nullable persistent field */
    private Integer hacncompasexua;



    /** nullable persistent field */
    private String hacevacunvph;

    /** nullable persistent field */
    private Integer hacnnumervph;

    /** nullable persistent field */
    private String hacetipifvph;

    /** nullable persistent field */
    private String haccresultipif;
    
    /** nullable persistent field */
    private String hacefuma;


    /** nullable persistent field */
    private String hacediabetes;

    /** nullable persistent field */
    private String hacevih;

    /** nullable persistent field */
    private String haceets;
    
    
    /** nullable persistent field */
    private String haccfuma;


    /** nullable persistent field */
    private String haccdiabetes;

    /** nullable persistent field */
    private String haccvih;

    /** nullable persistent field */
    private String haccets;


    /** nullable persistent field */
    private String haccantecprevi;

    /** nullable persistent field */
    private String haccresulproce;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private Integer hacnnumgesta;
    // Parto
    private Integer hacnnumparto;
    // Aborto
    private Integer hacnnumaborto;
    // Cesarea
    private Integer hacnnumcesare;
    // Hijos Vivos
    private Integer hacnnumvivo;
    // Ectopicos
    private Integer hacnectopico;
    // Mortinatos
    private Integer hacnmortina;
    // olas
    private Integer hacnmolas;
    // Fehca del Ultimo Parto
    private Date hacdfup;
    // Metodo de Planificacion
    private String haccmetodoplan;

    private String haccotrometodo;

    // Fecha de la Ultima regla
    private Date hacdfur;

    private String haccotroresul;

    // Ultima Citologia
    private String haccultcitolo;
    // Resultado de la Citologia
    private String haccresulcitol;
    // Tipo de Ciclo
    private String hacetipciclo;
    // Frecuencia Inicial
    private Integer hacnfrefincicl;
    //Frecuencia
    private Integer hacnfreciclo;
    //Edad de la Menarquia    
    private Integer hacnmenarquia;
    
    /** nullable persistent field */
    private Integer hacndurciclo;
    
    
    /** nullable persistent field */
    private Integer hacndurfincicl;
    
    /** nullable persistent field */
    private String haccnoaplica;
    
    
    /** nullable persistent field */
    private Date hacdfeultiapl;
    
    /** nullable persistent field */
    private String haccpildoobser;

    /** nullable persistent field */
    private String haccpildouso;
    
    private Integer hacnedadrelac;
    
    private String haccgenotipifi; 


    /** default constructor */
    public Chantecolpo() {
    }


    public void setId(ChantecolpoPK id) {
        this.id = id;
    }

    public ChantecolpoPK getId() {
        return id;
    }

    public void setHacdfecregistr(Date hacdfecregistr) {
        this.hacdfecregistr = hacdfecregistr;
    }

    public Date getHacdfecregistr() {
        return hacdfecregistr;
    }

    public void setHaccoperador(String haccoperador) {
        this.haccoperador = haccoperador;
    }

    public String getHaccoperador() {
        return haccoperador;
    }

    public void setHacncompasexua(Integer hacncompasexua) {
        this.hacncompasexua = hacncompasexua;
    }

    public Integer getHacncompasexua() {
        return hacncompasexua;
    }

    public void setHacefuma(String hacefuma) {
        this.hacefuma = hacefuma;
    }

    public String getHacefuma() {
        return hacefuma;
    }

    public void setHacediabetes(String hacediabetes) {
        this.hacediabetes = hacediabetes;
    }

    public String getHacediabetes() {
        return hacediabetes;
    }

    public void setHacevih(String hacevih) {
        this.hacevih = hacevih;
    }

    public String getHacevih() {
        return hacevih;
    }

    public void setHaccantecprevi(String haccantecprevi) {
        this.haccantecprevi = haccantecprevi;
    }

    public String getHaccantecprevi() {
        return haccantecprevi;
    }

    public void setHaccresulproce(String haccresulproce) {
        this.haccresulproce = haccresulproce;
    }

    public String getHaccresulproce() {
        return haccresulproce;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHacevacunvph(String hacevacunvph) {
        this.hacevacunvph = hacevacunvph;
    }

    public String getHacevacunvph() {
        return hacevacunvph;
    }

    public void setHacnnumervph(Integer hacnnumervph) {
        this.hacnnumervph = hacnnumervph;
    }

    public Integer getHacnnumervph() {
        return hacnnumervph;
    }

    public void setHacetipifvph(String hacetipifvph) {
        this.hacetipifvph = hacetipifvph;
    }

    public String getHacetipifvph() {
        return hacetipifvph;
    }

    public void setHaccresultipif(String haccresultipif) {
        this.haccresultipif = haccresultipif;
    }

    public String getHaccresultipif() {
        return haccresultipif;
    }

    public void setHaceets(String haceets) {
        this.haceets = haceets;
    }

    public String getHaceets() {
        return haceets;
    }

    public void setHacnnumgesta(Integer hacnnumgesta) {
        this.hacnnumgesta = hacnnumgesta;
    }

    public Integer getHacnnumgesta() {
        return hacnnumgesta;
    }

    public void setHacnnumparto(Integer hacnnumparto) {
        this.hacnnumparto = hacnnumparto;
    }

    public Integer getHacnnumparto() {
        return hacnnumparto;
    }

    public void setHacnnumaborto(Integer hacnnumaborto) {
        this.hacnnumaborto = hacnnumaborto;
    }

    public Integer getHacnnumaborto() {
        return hacnnumaborto;
    }

    public void setHacnnumcesare(Integer hacnnumcesare) {
        this.hacnnumcesare = hacnnumcesare;
    }

    public Integer getHacnnumcesare() {
        return hacnnumcesare;
    }

    public void setHacnnumvivo(Integer hacnnumvivo) {
        this.hacnnumvivo = hacnnumvivo;
    }

    public Integer getHacnnumvivo() {
        return hacnnumvivo;
    }

    public void setHacnectopico(Integer hacnectopico) {
        this.hacnectopico = hacnectopico;
    }

    public Integer getHacnectopico() {
        return hacnectopico;
    }

    public void setHacnmortina(Integer hacnmortina) {
        this.hacnmortina = hacnmortina;
    }

    public Integer getHacnmortina() {
        return hacnmortina;
    }

    public void setHacnmolas(Integer hacnmolas) {
        this.hacnmolas = hacnmolas;
    }

    public Integer getHacnmolas() {
        return hacnmolas;
    }

    public void setHacdfup(Date hacdfup) {
        this.hacdfup = hacdfup;
    }

    public Date getHacdfup() {
        return hacdfup;
    }

    public void setHaccmetodoplan(String haccmetodoplan) {
        this.haccmetodoplan = haccmetodoplan;
    }

    public String getHaccmetodoplan() {
        return haccmetodoplan;
    }

    public void setHaccotrometodo(String haccotrometodo) {
        this.haccotrometodo = haccotrometodo;
    }

    public String getHaccotrometodo() {
        return haccotrometodo;
    }

    public void setHacdfur(Date hacdfur) {
        this.hacdfur = hacdfur;
    }

    public Date getHacdfur() {
        return hacdfur;
    }

    public void setHaccotroresul(String haccotroresul) {
        this.haccotroresul = haccotroresul;
    }

    public String getHaccotroresul() {
        return haccotroresul;
    }

    public void setHaccultcitolo(String haccultcitolo) {
        this.haccultcitolo = haccultcitolo;
    }

    public String getHaccultcitolo() {
        return haccultcitolo;
    }

    public void setHaccresulcitol(String haccresulcitol) {
        this.haccresulcitol = haccresulcitol;
    }

    public String getHaccresulcitol() {
        return haccresulcitol;
    }

    public void setHacetipciclo(String hacetipciclo) {
        this.hacetipciclo = hacetipciclo;
    }

    public String getHacetipciclo() {
        return hacetipciclo;
    }

    public void setHacnfrefincicl(Integer hacnfrefincicl) {
        this.hacnfrefincicl = hacnfrefincicl;
    }

    public Integer getHacnfrefincicl() {
        return hacnfrefincicl;
    }

    public void setHacnfreciclo(Integer hacnfreciclo) {
        this.hacnfreciclo = hacnfreciclo;
    }

    public Integer getHacnfreciclo() {
        return hacnfreciclo;
    }

    public void setHacnmenarquia(Integer hacnmenarquia) {
        this.hacnmenarquia = hacnmenarquia;
    }

    public Integer getHacnmenarquia() {
        return hacnmenarquia;
    }

    public void setHacndurciclo(Integer hacndurciclo) {
        this.hacndurciclo = hacndurciclo;
    }

    public Integer getHacndurciclo() {
        return hacndurciclo;
    }

    public void setHacndurfincicl(Integer hacndurfincicl) {
        this.hacndurfincicl = hacndurfincicl;
    }

    public Integer getHacndurfincicl() {
        return hacndurfincicl;
    }


    public void setHaccnoaplica(String haccnoaplica) {
        this.haccnoaplica = haccnoaplica;
    }

    public String getHaccnoaplica() {
        return haccnoaplica;
    }

    public void setHacdfeultiapl(Date hacdfeultiapl) {
        this.hacdfeultiapl = hacdfeultiapl;
    }

    public Date getHacdfeultiapl() {
        return hacdfeultiapl;
    }

    public void setHaccpildoobser(String haccpildoobser) {
        this.haccpildoobser = haccpildoobser;
    }

    public String getHaccpildoobser() {
        return haccpildoobser;
    }

    public void setHaccpildouso(String haccpildouso) {
        this.haccpildouso = haccpildouso;
    }

    public String getHaccpildouso() {
        return haccpildouso;
    }

    public void setHacnedadrelac(Integer hacnedadrelac) {
        this.hacnedadrelac = hacnedadrelac;
    }

    public Integer getHacnedadrelac() {
        return hacnedadrelac;
    }

    public void setHaccgenotipifi(String haccgenotipifi) {
        this.haccgenotipifi = haccgenotipifi;
    }

    public String getHaccgenotipifi() {
        return haccgenotipifi;
    }

    public void setHaccfuma(String haccfuma) {
        this.haccfuma = haccfuma;
    }

    public String getHaccfuma() {
        return haccfuma;
    }

    public void setHaccdiabetes(String haccdiabetes) {
        this.haccdiabetes = haccdiabetes;
    }

    public String getHaccdiabetes() {
        return haccdiabetes;
    }

    public void setHaccvih(String haccvih) {
        this.haccvih = haccvih;
    }

    public String getHaccvih() {
        return haccvih;
    }

    public void setHaccets(String haccets) {
        this.haccets = haccets;
    }

    public String getHaccets() {
        return haccets;
    }
}
