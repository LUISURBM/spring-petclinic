package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;



/** @author Hibernate CodeGenerator */
public class Chvademecum implements Serializable {

    /** identifier field */
    private Integer hvdnconsecutiv;

    /** persistent field */
    private String hvdccodigatc;

    /** persistent field */
    private String hvdcprincactiv;

    /** persistent field */
    private String hvdcconcentrac;

    /** persistent field */
    private String hvdcformafarma;

    /** nullable persistent field */
    private String hvdcaclaracion;

    /** nullable persistent field */
    private String hvdcmedicpos;

    /** nullable persistent field */
    private String hvdccomercial;

    /** nullable persistent field */
    private String hvdccodigcomer;

    /** nullable persistent field */
    private String hvdcindicacion;

    /** nullable persistent field */
    private String hvdccontrindic;

    /** nullable persistent field */
    private String hvdcunidad;

    /** nullable persistent field */
    private String hvdcanestesia;

    /** persistent field */
    private String hvdcoperador;

    /** persistent field */
    private Date hvddfecharegis;

    /** nullable persistent field */
    private String hvdcoperamodif;

    /** nullable persistent field */
    private Date hvddfechamodif;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String hvdcviaaerea;
    
    /** nullable persistent field */
    private String hvdcinicianest;
    
    // variables para busqueda
    
     private String hvdcprincactiv2;
     private String hvdcprincactiv3;
     private String hvdcopera1;
     private String hvdcopera2;
     private String hvdcopera3;
     

    private String hvdcviaadmini;
    private String hvdcformadmi;
    

   
    /** default constructor */
    public Chvademecum() {
    }


    /**
     * @param hvdnconsecutiv
     */
    public void setHvdnconsecutiv(Integer hvdnconsecutiv) {
        this.hvdnconsecutiv = hvdnconsecutiv;
    }

    /**
     * @return
     */
    public Integer getHvdnconsecutiv() {
        return hvdnconsecutiv;
    }

    /**
     * @param hvdccodigatc
     */
    public void setHvdccodigatc(String hvdccodigatc) {
        this.hvdccodigatc = hvdccodigatc;
    }

    /**
     * @return
     */
    public String getHvdccodigatc() {
        return hvdccodigatc;
    }

    /**
     * @param hvdcprincactiv
     */
    public void setHvdcprincactiv(String hvdcprincactiv) {
        this.hvdcprincactiv = hvdcprincactiv;
    }

    /**
     * @return
     */
    public String getHvdcprincactiv() {
        return hvdcprincactiv;
    }

    /**
     * @param hvdcconcentrac
     */
    public void setHvdcconcentrac(String hvdcconcentrac) {
        this.hvdcconcentrac = hvdcconcentrac;
    }

    /**
     * @return
     */
    public String getHvdcconcentrac() {
        return hvdcconcentrac;
    }

    /**
     * @param hvdcformafarma
     */
    public void setHvdcformafarma(String hvdcformafarma) {
        this.hvdcformafarma = hvdcformafarma;
    }

    /**
     * @return
     */
    public String getHvdcformafarma() {
        return hvdcformafarma;
    }

    /**
     * @param hvdcaclaracion
     */
    public void setHvdcaclaracion(String hvdcaclaracion) {
        this.hvdcaclaracion = hvdcaclaracion;
    }

    /**
     * @return
     */
    public String getHvdcaclaracion() {
        return hvdcaclaracion;
    }

    /**
     * @param hvdcmedicpos
     */
    public void setHvdcmedicpos(String hvdcmedicpos) {
        this.hvdcmedicpos = hvdcmedicpos;
    }

    /**
     * @return
     */
    public String getHvdcmedicpos() {
        return hvdcmedicpos;
    }

    /**
     * @param hvdccomercial
     */
    public void setHvdccomercial(String hvdccomercial) {
        this.hvdccomercial = hvdccomercial;
    }

    /**
     * @return
     */
    public String getHvdccomercial() {
        return hvdccomercial;
    }

    /**
     * @param hvdccodigcomer
     */
    public void setHvdccodigcomer(String hvdccodigcomer) {
        this.hvdccodigcomer = hvdccodigcomer;
    }

    /**
     * @return
     */
    public String getHvdccodigcomer() {
        return hvdccodigcomer;
    }

    /**
     * @param hvdcindicacion
     */
    public void setHvdcindicacion(String hvdcindicacion) {
        this.hvdcindicacion = hvdcindicacion;
    }

    /**
     * @return
     */
    public String getHvdcindicacion() {
        return hvdcindicacion;
    }

    /**
     * @param hvdccontrindic
     */
    public void setHvdccontrindic(String hvdccontrindic) {
        this.hvdccontrindic = hvdccontrindic;
    }

    /**
     * @return
     */
    public String getHvdccontrindic() {
        return hvdccontrindic;
    }

    /**
     * @param hvdcunidad
     */
    public void setHvdcunidad(String hvdcunidad) {
        this.hvdcunidad = hvdcunidad;
    }

    /**
     * @return
     */
    public String getHvdcunidad() {
        return hvdcunidad;
    }

    /**
     * @param hvdcanestesia
     */
    public void setHvdcanestesia(String hvdcanestesia) {
        this.hvdcanestesia = hvdcanestesia;
    }

    /**
     * @return
     */
    public String getHvdcanestesia() {
        return hvdcanestesia;
    }

    /**
     * @param hvdcoperador
     */
    public void setHvdcoperador(String hvdcoperador) {
        this.hvdcoperador = hvdcoperador;
    }

    /**
     * @return
     */
    public String getHvdcoperador() {
        return hvdcoperador;
    }

    /**
     * @param hvddfecharegis
     */
    public void setHvddfecharegis(Date hvddfecharegis) {
        this.hvddfecharegis = hvddfecharegis;
    }

    /**
     * @return
     */
    public Date getHvddfecharegis() {
        return hvddfecharegis;
    }

    /**
     * @param hvdcoperamodif
     */
    public void setHvdcoperamodif(String hvdcoperamodif) {
        this.hvdcoperamodif = hvdcoperamodif;
    }

    /**
     * @return
     */
    public String getHvdcoperamodif() {
        return hvdcoperamodif;
    }

    /**
     * @param hvddfechamodif
     */
    public void setHvddfechamodif(Date hvddfechamodif) {
        this.hvddfechamodif = hvddfechamodif;
    }

    /**
     * @return
     */
    public Date getHvddfechamodif() {
        return hvddfechamodif;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param hvdcviaaerea
     */
    public void setHvdcviaaerea(String hvdcviaaerea) {
        this.hvdcviaaerea = hvdcviaaerea;
    }

    /**
     * @return
     */
    public String getHvdcviaaerea() {
        return hvdcviaaerea;
    }

    /**
     * @param hvdcinicianest
     */
    public void setHvdcinicianest(String hvdcinicianest) {
        this.hvdcinicianest = hvdcinicianest;
    }

    /**
     * @return
     */
    public String getHvdcinicianest() {
        return hvdcinicianest;
    }
    
    /**
     * @param hvdcprincactiv2
     */
    public void setHvdcprincactiv2(String hvdcprincactiv2) {
        this.hvdcprincactiv2 = hvdcprincactiv2;
    }

    /**
     * @return
     */
    public String getHvdcprincactiv2() {
        return hvdcprincactiv2;
    }
    /**
     * @param hvdcprincactiv3
     */
    public void setHvdcprincactiv3(String hvdcprincactiv3) {
        this.hvdcprincactiv3 = hvdcprincactiv3;
    }

    /**
     * @return
     */
    public String getHvdcprincactiv3() {
        return hvdcprincactiv3;
    }
    
    /**
     * @param hvdcopera1
     */
    public void setHvdcopera1(String hvdcopera1) {
        this.hvdcopera1 = hvdcopera1;
    }

    /**
     * @return
     */
    public String getHvdcopera1() {
        return hvdcopera1;
    }
    
    /**
     * @param hvdcopera2
     */
    public void setHvdcopera2(String hvdcopera2) {
        this.hvdcopera2 = hvdcopera2;
    }

    /**
     * @return
     */
    public String getHvdcopera2() {
        return hvdcopera2;
    }
    /**
     * @param hvdcopera3
     */
    public void setHvdcopera3(String hvdcopera3) {
        this.hvdcopera3 = hvdcopera3;
    }

    /**
     * @return
     */
    public String getHvdcopera3() {
        return hvdcopera3;
    }


    public void setHvdcviaadmini(String hvdcviaadmini) {
        this.hvdcviaadmini = hvdcviaadmini;
    }

    public String getHvdcviaadmini() {
        return hvdcviaadmini;
    }

    public void setHvdcformadmi(String hvdcformadmi) {
        this.hvdcformadmi = hvdcformadmi;
    }

    public String getHvdcformadmi() {
        return hvdcformadmi;
    }
}
