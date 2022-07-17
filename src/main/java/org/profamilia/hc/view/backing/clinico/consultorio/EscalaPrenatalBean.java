package org.profamilia.hc.view.backing.clinico.consultorio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.profamilia.hc.view.backing.BaseBean;


public class EscalaPrenatalBean extends BaseBean {


    private List lstEdad;

    private List lstParidad;

    private String edadSelect;

    private String paridadSelect;

    /** Almacena true si la consulta pertenece al primer tercio de embarazo*/
    private boolean primerTercio;

    /** Almacena true si la consulta pertenece al segundo tercio de embarazo*/
    private boolean segundoTercio;

    /** Almacena true si la consulta pertenece al tercer tercio de embarazo*/
    private boolean tercerTercio;

    /** Almacena true si la usuaria sufre de Aborto Habitual o Infertilidad false de lo contrario*/
    private boolean sufreAborto;

    /** Almacena true si la usuaria sufre de Retencion Placentaria false de lo contrario*/
    private boolean sufreRetencion;

    /** Almacena true si el recien nacido pesa mas de 4000 gramos false de lo contrario*/
    private boolean pesoMayor;

    /** Almacena true si el recien nacido pesa menos de 2500 gramos false de lo contrario*/
    private boolean pesoMenor;

    /** Almacena true si la usuaria sufre de Aborto Habitual o Infertilidad false de lo contrario*/
    private boolean htaInducida;

    /** Almacena true si la usuaria sufre de Retencion Placentaria false de lo contrario*/
    private boolean embarazoGemelar;

    /** Almacena true si el recien nacido pesa mas de 4000 gramos false de lo contrario*/
    private boolean muerteNeonatal;

    /** Almacena true si el recien nacido pesa menos de 2500 gramos false de lo contrario*/
    private boolean partoDificil;

    private Integer tipoHistoria;


    /** Almacena true si  */
    public


    EscalaPrenatalBean() {
    }

    public void init() {

        lstEdad = new ArrayList();
        lstParidad = new ArrayList();

        primerTercio = true;
    }

    public void setLstEdad(List lstEdad) {
        this.lstEdad = lstEdad;
    }

    public List getLstEdad() {
        if (lstEdad.size() == 0) {
            lstEdad.add(new SelectItem("1", "<16"));
            lstEdad.add(new SelectItem("2", "16-35"));
            lstEdad.add(new SelectItem("3", ">35"));
        }
        return lstEdad;
    }

    public void setLstParidad(List lstParidad) {
        this.lstParidad = lstParidad;
    }

    public List getLstParidad() {
        if (lstParidad.size() == 0) {
            lstParidad.add(new SelectItem("1", "0"));
            lstParidad.add(new SelectItem("2", "1-4"));
            lstParidad.add(new SelectItem("3", ">5"));
        }
        return lstParidad;
    }

    public void setEdadSelect(String edadSelect) {
        this.edadSelect = edadSelect;
    }

    public String getEdadSelect() {
        return edadSelect;
    }

    public void setParidadSelect(String paridadSelect) {
        this.paridadSelect = paridadSelect;
    }

    public String getParidadSelect() {
        return paridadSelect;
    }

    public void setSufreAborto(boolean sufreAborto) {
        this.sufreAborto = sufreAborto;
    }

    public boolean isSufreAborto() {
        return sufreAborto;
    }

    public void setSufreRetencion(boolean sufreRetencion) {
        this.sufreRetencion = sufreRetencion;
    }

    public boolean isSufreRetencion() {
        return sufreRetencion;
    }

    public void setPesoMayor(boolean pesoMayor) {
        this.pesoMayor = pesoMayor;
    }

    public boolean isPesoMayor() {
        return pesoMayor;
    }

    public void setPesoMenor(boolean pesoMenor) {
        this.pesoMenor = pesoMenor;
    }

    public boolean isPesoMenor() {
        return pesoMenor;
    }

    public void setHtaInducida(boolean htaInducida) {
        this.htaInducida = htaInducida;
    }

    public boolean isHtaInducida() {
        return htaInducida;
    }

    public void setEmbarazoGemelar(boolean embarazoGemelar) {
        this.embarazoGemelar = embarazoGemelar;
    }

    public boolean isEmbarazoGemelar() {
        return embarazoGemelar;
    }

    public void setMuerteNeonatal(boolean muerteNeonatal) {
        this.muerteNeonatal = muerteNeonatal;
    }

    public boolean isMuerteNeonatal() {
        return muerteNeonatal;
    }

    public void setPartoDificil(boolean partoDificil) {
        this.partoDificil = partoDificil;
    }

    public boolean isPartoDificil() {
        return partoDificil;
    }

    public void setPrimerTercio(boolean primerTercio) {
        this.primerTercio = primerTercio;
    }

    public boolean isPrimerTercio() {
        return primerTercio;
    }

    public void setSegundoTercio(boolean segundoTercio) {
        this.segundoTercio = segundoTercio;
    }

    public boolean isSegundoTercio() {
        return segundoTercio;
    }

    public void setTercerTercio(boolean tercerTercio) {
        this.tercerTercio = tercerTercio;
    }

    public boolean isTercerTercio() {
        return tercerTercio;
    }

    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    public Integer getTipoHistoria() {
        return tipoHistoria;
    }
}
