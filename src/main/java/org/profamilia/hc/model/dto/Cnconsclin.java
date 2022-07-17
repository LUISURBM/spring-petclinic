package org.profamilia.hc.model.dto;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;


/**
 * Cnconsclin generated by hbm2java
 */
public class Cnconsclin implements java.io.Serializable {


    private Integer cconnumero;
    private Integer cconclinic;
    private Integer cconsalesp;
    private Integer cconconsul;
    private Integer ccontconcl;
    private Date ccodfeccon;
    private Integer cconhistor;
    private String ccoctipide;
    private BigDecimal ccoanumide;
    private String ccocprinom;
    private String ccocsegnom;
    private String ccocpriape;
    private String ccocsegape;
    private Integer cconclidoc;
    private Cptipodocu ccontipdoc;
    private BigDecimal cconnumdoc;
    private Integer cconprogra;
    private Integer cconcontra;
    private Cpservicio ccocservic;
    private Integer cconcantid;
    private BigDecimal ccoavalser;
    private Date ccodfecreg;
    private Date ccothorcon;
    private String ccocusureg;
    private String ccocetapa;
    private Date ccothorate;
    private String ccocusumod;
    private String ccocestado;
    private BigDecimal ccondonant;
    private String ccocgenero;
    private String horaRegi;
    private Chusuario ccolusuario;
    private boolean selectedRegistro; 
    private BigDecimal cirujanoSelect; 
    private String ccocintext;
    private String cconfaccli;
    private Integer tipoHistoria; 
    
    /** **/
    private boolean seleccionado; 
    
    private boolean renderEliminar; 
    
    private String servicioAtendido;
    
    private String nombreServicio; 

    private Integer version;
    
    private boolean renderCerrarIngreso;
    
    // DATOS
    
    private Chmedicament medicamento;
    
    private boolean itemSelect;

    /** default constructor */
    public Cnconsclin() {
    }


    /**
     * @param cconnumero
     */
    public void setCconnumero(Integer cconnumero) {
        this.cconnumero = cconnumero;
    }

    /**
     * @return
     */
    public Integer getCconnumero() {
        return cconnumero;
    }

    /**
     * @param cconclinic
     */
    public void setCconclinic(Integer cconclinic) {
        this.cconclinic = cconclinic;
    }

    /**
     * @return
     */
    public Integer getCconclinic() {
        return cconclinic;
    }

    /**
     * @param cconsalesp
     */
    public void setCconsalesp(Integer cconsalesp) {
        this.cconsalesp = cconsalesp;
    }

    /**
     * @return
     */
    public Integer getCconsalesp() {
        return cconsalesp;
    }

    /**
     * @param cconconsul
     */
    public void setCconconsul(Integer cconconsul) {
        this.cconconsul = cconconsul;
    }

    /**
     * @return
     */
    public Integer getCconconsul() {
        return cconconsul;
    }

    /**
     * @param ccontconcl
     */
    public void setCcontconcl(Integer ccontconcl) {
        this.ccontconcl = ccontconcl;
    }

    /**
     * @return
     */
    public Integer getCcontconcl() {
        return ccontconcl;
    }

    /**
     * @param ccodfeccon
     */
    public void setCcodfeccon(Date ccodfeccon) {
        this.ccodfeccon = ccodfeccon;
    }

    /**
     * @return
     */
    public Date getCcodfeccon() {
        return ccodfeccon;
    }

    /**
     * @param cconhistor
     */
    public void setCconhistor(Integer cconhistor) {
        this.cconhistor = cconhistor;
    }

    /**
     * @return
     */
    public Integer getCconhistor() {
        return cconhistor;
    }

    /**
     * @param ccoctipide
     */
    public void setCcoctipide(String ccoctipide) {
        this.ccoctipide = ccoctipide;
    }

    /**
     * @return
     */
    public String getCcoctipide() {
        return ccoctipide;
    }

    /**
     * @param ccoanumide
     */
    public void setCcoanumide(BigDecimal ccoanumide) {
        this.ccoanumide = ccoanumide;
    }

    /**
     * @return
     */
    public BigDecimal getCcoanumide() {
        return ccoanumide;
    }

    /**
     * @param ccocprinom
     */
    public void setCcocprinom(String ccocprinom) {
        this.ccocprinom = ccocprinom;
    }

    /**
     * @return
     */
    public String getCcocprinom() {
        return ccocprinom;
    }

    /**
     * @param ccocsegnom
     */
    public void setCcocsegnom(String ccocsegnom) {
        this.ccocsegnom = ccocsegnom;
    }

    /**
     * @return
     */
    public String getCcocsegnom() {
        return ccocsegnom;
    }

    /**
     * @param ccocpriape
     */
    public void setCcocpriape(String ccocpriape) {
        this.ccocpriape = ccocpriape;
    }

    /**
     * @return
     */
    public String getCcocpriape() {
        return ccocpriape;
    }

    /**
     * @param ccocsegape
     */
    public void setCcocsegape(String ccocsegape) {
        this.ccocsegape = ccocsegape;
    }

    /**
     * @return
     */
    public String getCcocsegape() {
        return ccocsegape;
    }

    /**
     * @param cconclidoc
     */
    public void setCconclidoc(Integer cconclidoc) {
        this.cconclidoc = cconclidoc;
    }

    /**
     * @return
     */
    public Integer getCconclidoc() {
        return cconclidoc;
    }

    /**
     * @param ccontipdoc
     */
    public void setCcontipdoc(Cptipodocu ccontipdoc) {
        this.ccontipdoc = ccontipdoc;
    }

    /**
     * @return
     */
    public Cptipodocu getCcontipdoc() {
        return ccontipdoc;
    }

    /**
     * @param cconnumdoc
     */
    public void setCconnumdoc(BigDecimal cconnumdoc) {
        this.cconnumdoc = cconnumdoc;
    }

    /**
     * @return
     */
    public BigDecimal getCconnumdoc() {
        return cconnumdoc;
    }

    /**
     * @param cconprogra
     */
    public void setCconprogra(Integer cconprogra) {
        this.cconprogra = cconprogra;
    }

    /**
     * @return
     */
    public Integer getCconprogra() {
        return cconprogra;
    }

    /**
     * @param cconcontra
     */
    public void setCconcontra(Integer cconcontra) {
        this.cconcontra = cconcontra;
    }

    /**
     * @return
     */
    public Integer getCconcontra() {
        return cconcontra;
    }

    /**
     * @param ccocservic
     */
    public void setCcocservic(Cpservicio ccocservic) {
        this.ccocservic = ccocservic;
    }

    /**
     * @return
     */
    public Cpservicio getCcocservic() {
        return ccocservic;
    }

    /**
     * @param cconcantid
     */
    public void setCconcantid(Integer cconcantid) {
        this.cconcantid = cconcantid;
    }

    /**
     * @return
     */
    public Integer getCconcantid() {
        return cconcantid;
    }

    /**
     * @param ccoavalser
     */
    public void setCcoavalser(BigDecimal ccoavalser) {
        this.ccoavalser = ccoavalser;
    }

    /**
     * @return
     */
    public BigDecimal getCcoavalser() {
        return ccoavalser;
    }

    /**
     * @param ccodfecreg
     */
    public void setCcodfecreg(Date ccodfecreg) {
        this.ccodfecreg = ccodfecreg;
    }

    /**
     * @return
     */
    public Date getCcodfecreg() {
        return ccodfecreg;
    }

    /**
     * @param ccothorcon
     */
    public void setCcothorcon(Date ccothorcon) {
        this.ccothorcon = ccothorcon;
    }

    /**
     * @return
     */
    public Date getCcothorcon() {
        return ccothorcon;
    }

    /**
     * @param ccocusureg
     */
    public void setCcocusureg(String ccocusureg) {
        this.ccocusureg = ccocusureg;
    }

    /**
     * @return
     */
    public String getCcocusureg() {
        return ccocusureg;
    }

    /**
     * @param ccocetapa
     */
    public void setCcocetapa(String ccocetapa) {
        this.ccocetapa = ccocetapa;
    }

    /**
     * @return
     */
    public String getCcocetapa() {
        return ccocetapa;
    }

    /**
     * @param ccothorate
     */
    public void setCcothorate(Date ccothorate) {
        this.ccothorate = ccothorate;
    }

    /**
     * @return
     */
    public Date getCcothorate() {
        return ccothorate;
    }

    /**
     * @param ccocusumod
     */
    public void setCcocusumod(String ccocusumod) {
        this.ccocusumod = ccocusumod;
    }

    /**
     * @return
     */
    public String getCcocusumod() {
        return ccocusumod;
    }

    /**
     * @param ccocestado
     */
    public void setCcocestado(String ccocestado) {
        this.ccocestado = ccocestado;
    }

    /**
     * @return
     */
    public String getCcocestado() {
        return ccocestado;
    }

    /**
     * @param ccondonant
     */
    public void setCcondonant(BigDecimal ccondonant) {
        this.ccondonant = ccondonant;
    }

    /**
     * @return
     */
    public BigDecimal getCcondonant() {
        return ccondonant;
    }

    /**
     * @param ccocgenero
     */
    public void setCcocgenero(String ccocgenero) {
        this.ccocgenero = ccocgenero;
    }

    /**
     * @return
     */
    public String getCcocgenero() {
        return ccocgenero;
    }

    /**
     * @param horaRegi
     */
    public void setHoraRegi(String horaRegi) {
        this.horaRegi = horaRegi;
    }

    /**
     * @return
     */
    public String getHoraRegi() {
        if (ccothorate != null) {
            GregorianCalendar fecha = new GregorianCalendar();
            fecha.setTime(ccothorate);
            int hora;
            int minuto;
            String horaSelect = "";
            String minutoSelect = "";

            hora = fecha.get(Calendar.HOUR_OF_DAY);
            minuto = fecha.get(Calendar.MINUTE);

            if (hora < 10) {
                horaSelect = "0" + hora;
            } else {
                horaSelect = hora + "";
            }
            if (minuto < 10) {
                minutoSelect = "0" + minuto;
            } else {
                minutoSelect = minuto + "";
            }


            this.horaRegi = horaSelect + ":" + minutoSelect;
        }

        return horaRegi;
    }

    /**
     * @param ccolusuario
     */
    public void setCcolusuario(Chusuario ccolusuario) {
        this.ccolusuario = ccolusuario;
    }

    /**
     * @return
     */
    public Chusuario getCcolusuario() {
        return ccolusuario;
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

    public void setSelectedRegistro(boolean selectedRegistro) {
        this.selectedRegistro = selectedRegistro;
    }

    public boolean isSelectedRegistro() {
        return selectedRegistro;
    }

    public void setCirujanoSelect(BigDecimal cirujanoSelect) {
        this.cirujanoSelect = cirujanoSelect;
    }

    public BigDecimal getCirujanoSelect() {
        return cirujanoSelect;
    }


    public void setCcocintext(String ccocintext) {
        this.ccocintext = ccocintext;
    }

    public String getCcocintext() {
        return ccocintext;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setSeleccionado(ValueChangeEvent valueChangeEvent){
        setSeleccionado((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public boolean isSeleccionado() {
        return seleccionado;
    }


    public void setCconfaccli(String cconfaccli) {
        this.cconfaccli = cconfaccli;
    }

    public String getCconfaccli() {
        return cconfaccli;
    }
    
    public void setServicioAtendido(String servicioAtendido) {
        this.servicioAtendido = servicioAtendido;
    }

    public String getServicioAtendido() {
        return servicioAtendido;
    }

    public void setRenderEliminar(boolean renderEliminar) {
        this.renderEliminar = renderEliminar;
    }

    public boolean isRenderEliminar() {
        return renderEliminar;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

 
    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    public Integer getTipoHistoria() {
        return tipoHistoria;
    }

    public void setMedicamento(Chmedicament medicamento) {
        this.medicamento = medicamento;
    }

    public Chmedicament getMedicamento() {
     if(medicamento == null){
         medicamento = new Chmedicament();
     }
        return medicamento;
    }

    public void setRenderCerrarIngreso(boolean renderCerrarIngreso) {
        this.renderCerrarIngreso = renderCerrarIngreso;
    }

    public boolean isRenderCerrarIngreso() {
        return renderCerrarIngreso;
    }

    public void setItemSelect(boolean itemSelect) {
        this.itemSelect = itemSelect;
    }

    public boolean isItemSelect() {
        return itemSelect;
    }
}
