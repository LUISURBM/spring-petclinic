//=======================================================================
// ARCHIVO RegistrarTecnicaAnestesiaBean
// FECHA CREACI�N: 
// AUTOR: jariano, nlis
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.cirugia.registro;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chtecnianest;
import org.profamilia.hc.model.dto.ChtecnianestPK;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//====================================================================


//=================================================================
//  CLASE RegistrarTecnicaAnestesiaBean
//=======================================================================

public class RegistrarTecnicaAnestesiaBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chtecnianest tecnica;
    private boolean esAnestesiaGeneral;
    private boolean esAnestesiaRegional;
    private boolean esAnestesiaLocal;
    private boolean mostrarNeuroaxial;
    private List lstFormulaGeneral;
    private List lstFormulaRegional;
    private List lstTipoNeuroaxial;

    private Date fechainiciooxigeno;
    private Date fechafinoxigeno;
    private Integer horainiciooxigeno;
    private Integer horafinoxigeno;
    private Integer minutoiniciooxigeno;
    private Integer minutofinoxigeno;


    private Date fechainicionitroso;
    private Date fechafinnitroso;
    private Integer horainicionitroso;
    private Integer horafinnitroso;
    private Integer minutoinicionitroso;
    private Integer minutofinnitroso;

    private Date fechainicioinhalatorio;
    private Date fechafininhalatorio;
    private Integer horainicioinhalatorio;
    private Integer horafininhalatorio;
    private Integer minutoinicioinhalatorio;
    private Integer minutofininhalatorio;

    private Date fechacambio;
    private Integer horacambio;
    private Integer minutocambio;
    private List listHora;
    private List lstMinutos;
    private List lstOpciones;
    private List lstAgente;

    private boolean mostraroxigeno;
    private boolean mostrarnitroso;
    private boolean mostrarVolumenInduccion;
    private boolean mostrarVolumenMantenimiento;
    private boolean mostrarcambio;

    private Long numeroCirugia;
    private String tipoServicio;
    private UIInput mnuFormaAdministracionRegional;
    
    private List ltsOxigeno; 
    
    private List ltsOxigenoNitroso; 
    
    private String navegationRule;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public RegistrarTecnicaAnestesiaBean() {
    }

    public void init() {
        tecnica = new Chtecnianest();

        lstFormulaGeneral = new ArrayList();
        lstFormulaRegional = new ArrayList();
        lstTipoNeuroaxial = new ArrayList();
        lstMinutos = new ArrayList();
        listHora = new ArrayList();
        lstAgente = new ArrayList();
        lstOpciones = new ArrayList();

        cargarDatos();
    }

    public void cargarDatos() {


        try {
            tecnica = 
                    this.serviceLocator.getClinicoService().getTecnicaAnestesia(numeroCirugia);
        } catch (ModelException e) {
            e.printStackTrace();
        }
        
        fechainiciooxigeno  = new Date();
        fechafinoxigeno = new Date();
        fechacambio = new Date();
        fechafininhalatorio = new Date();
        fechafinnitroso = new Date();
        fechainicioinhalatorio = new Date();
        fechainicionitroso = new Date();
        
        esAnestesiaGeneral = true;
        if (tecnica == null) {
            tecnica = new Chtecnianest();
          
            
        } else {
            if (tecnica.getHtacanestgener() != null && 
                tecnica.getHtacanestgener().equals("S")) {
                esAnestesiaGeneral = true;

            } else if (tecnica.getHtacanestgener() != null && 
                       tecnica.getHtacanestgener().equals("N")) {
                esAnestesiaGeneral = false;
            }

            if (tecnica.getHtacanestregio() != null && 
                tecnica.getHtacanestregio().equals("S")) {
                esAnestesiaRegional = true;

            } else if (tecnica.getHtacanestregio() != null && 
                       tecnica.getHtacanestregio().equals("N")) {
                esAnestesiaRegional = false;
            }


            if (tecnica.getHtacanestlocal() != null && 
                tecnica.getHtacanestlocal().equals("S")) {
                esAnestesiaLocal = true;

            } else if (tecnica.getHtacanestlocal() != null && 
                       tecnica.getHtacanestlocal().equals("N")) {
                esAnestesiaLocal = false;
            }


            if (tecnica.getHtactipoanereg() != null && 
                tecnica.getHtactipoanereg().equals("NE")) {
                mostrarNeuroaxial = true;
            } else {
                mostrarNeuroaxial = false;
            }


            if (tecnica.getHtadfechinioxi() != null) {
                Calendar fechaaux = Calendar.getInstance();
                fechaaux.setTime(tecnica.getHtadfechinioxi());
                fechainiciooxigeno = tecnica.getHtadfechinioxi();
                horainiciooxigeno = fechaaux.get(Calendar.HOUR_OF_DAY);
                minutoiniciooxigeno = fechaaux.get(Calendar.MINUTE);

            }

            if (tecnica.getHtadfechfinoxi() != null) {
                Calendar fechaaux = Calendar.getInstance();
                fechaaux.setTime(tecnica.getHtadfechfinoxi());
                fechafinoxigeno = tecnica.getHtadfechfinoxi();
                horafinoxigeno = fechaaux.get(Calendar.HOUR_OF_DAY);
                minutofinoxigeno = fechaaux.get(Calendar.MINUTE);
            }


            if (tecnica.getHtadfechininit() != null) {
                Calendar fechaaux = Calendar.getInstance();
                fechaaux.setTime(tecnica.getHtadfechininit());
                fechainicionitroso = tecnica.getHtadfechininit();
                horainicionitroso = fechaaux.get(Calendar.HOUR_OF_DAY);
                minutoinicionitroso = fechaaux.get(Calendar.MINUTE);
            }

            if (tecnica.getHtadfechfinnit() != null) {
                Calendar fechaaux = Calendar.getInstance();
                fechaaux.setTime(tecnica.getHtadfechfinnit());
                fechafinnitroso = tecnica.getHtadfechfinnit();
                horafinnitroso = fechaaux.get(Calendar.HOUR_OF_DAY);
                minutofinnitroso = fechaaux.get(Calendar.MINUTE);
            }


            if (tecnica.getHtadfechiniinh() != null) {
                Calendar fechaaux = Calendar.getInstance();
                fechaaux.setTime(tecnica.getHtadfechiniinh());
                fechainicioinhalatorio = tecnica.getHtadfechiniinh();
                horainicioinhalatorio = fechaaux.get(Calendar.HOUR_OF_DAY);
                minutoinicioinhalatorio = fechaaux.get(Calendar.MINUTE);
            }

            if (tecnica.getHtadfechfininh() != null) {
                Calendar fechaaux = Calendar.getInstance();
                fechaaux.setTime(tecnica.getHtadfechfininh());
                fechafininhalatorio = tecnica.getHtadfechfininh();
                horafininhalatorio = fechaaux.get(Calendar.HOUR_OF_DAY);
                minutofininhalatorio = fechaaux.get(Calendar.MINUTE);
            }


            if (tecnica.getHtadfechacambi() != null) {
                Calendar fechaaux = Calendar.getInstance();
                fechaaux.setTime(tecnica.getHtadfechacambi());
                fechacambio = tecnica.getHtadfechacambi();
                horacambio = fechaaux.get(Calendar.HOUR_OF_DAY);
                minutocambio = fechaaux.get(Calendar.MINUTE);
            }

            if (tecnica.getHtanoxigeno() != null && 
                !tecnica.getHtanoxigeno().equals(0)) {
                mostraroxigeno = true;
            } else {
                mostraroxigeno = false;
            }


            if (tecnica != null && tecnica.getHtanoxidonitro() != null && 
                !tecnica.getHtanoxidonitro().equals(0)) {
                mostrarnitroso = true;
            } else {
                mostrarnitroso = false;
            }


            if (tecnica.getHtacinducagent() != null && 
                !tecnica.getHtacinducagent().equals("")) {
                mostrarVolumenInduccion = true;
            } else {
                mostrarVolumenInduccion = false;
            }

            if (tecnica.getHtacmanteagent() != null && 
                !tecnica.getHtacmanteagent().equals("")) {
                mostrarVolumenMantenimiento = true;
            } else {
                mostrarVolumenMantenimiento = false;
            }


            if (tecnica.getHtaccambiconce() != null && 
                tecnica.getHtaccambiconce().equals("S")) {
                mostrarcambio = true;
            } else {
                mostrarcambio = false;
            }

        }
    }


    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------

    /**
     * @param tecnica
     */
    public void setTecnica(Chtecnianest tecnica) {
        this.tecnica = tecnica;
    }

    /**
     * @return
     */
    public Chtecnianest getTecnica() {
        return tecnica;
    }

    /**
     * @param esAnestesiaGeneral
     */
    public void setEsAnestesiaGeneral(boolean esAnestesiaGeneral) {
        this.esAnestesiaGeneral = esAnestesiaGeneral;
    }

    /**
     * @return
     */
    public boolean isEsAnestesiaGeneral() {
        return esAnestesiaGeneral;
    }

    /**
     * @param esAnestesiaRegional
     */
    public void setEsAnestesiaRegional(boolean esAnestesiaRegional) {
        this.esAnestesiaRegional = esAnestesiaRegional;
    }

    /**
     * @return
     */
    public boolean isEsAnestesiaRegional() {
        return esAnestesiaRegional;
    }

    /**
     * @param esAnestesiaLocal
     */
    public void setEsAnestesiaLocal(boolean esAnestesiaLocal) {
        this.esAnestesiaLocal = esAnestesiaLocal;
    }

    /**
     * @return
     */
    public boolean isEsAnestesiaLocal() {
        return esAnestesiaLocal;
    }

    /**
     * @param lstFormulaGeneral
     */
    public void setLstFormulaGeneral(List lstFormulaGeneral) {
        this.lstFormulaGeneral = lstFormulaGeneral;
    }

    /**
     * @return
     */
    public List getLstFormulaGeneral() {
        if (lstFormulaGeneral.size() == 0) {
            
            lstFormulaGeneral.add(new SelectItem("IH", "Inhalatoria."));
            lstFormulaGeneral.add(new SelectItem("IV", "Intravenosa"));
            lstFormulaGeneral.add(new SelectItem("BA", "Balanceada"));
        }
        return lstFormulaGeneral;
    }

    /**
     * @param lstFormulaRegional
     */
    public void setLstFormulaRegional(List lstFormulaRegional) {
        this.lstFormulaRegional = lstFormulaRegional;
    }

    /**
     * @return
     */
    public List getLstFormulaRegional() {
        if (lstFormulaRegional.size() == 0) {
            lstFormulaRegional.add(new SelectItem("", "Seleccione.."));
            lstFormulaRegional.add(new SelectItem("NE", "Neuroaxial"));
            lstFormulaRegional.add(new SelectItem("BP", "Bloqueo plejos"));
            lstFormulaRegional.add(new SelectItem("BT", "Bloqueo Troncular"));
            lstFormulaRegional.add(new SelectItem("OT", "Otros"));
        }
        return lstFormulaRegional;
    }

    /**
     * @param lstTipoNeuroaxial
     */
    public void setLstTipoNeuroaxial(List lstTipoNeuroaxial) {
        this.lstTipoNeuroaxial = lstTipoNeuroaxial;
    }

    /**
     * @return
     */
    public List getLstTipoNeuroaxial() {
        if (lstTipoNeuroaxial.size() == 0) {
            lstTipoNeuroaxial.add(new SelectItem("P", "Peridural"));
            lstTipoNeuroaxial.add(new SelectItem("S", "Subaracnoidea"));
        }
        return lstTipoNeuroaxial;
    }

    /**
     * @param mostrarNeuroaxial
     */
    public void setMostrarNeuroaxial(boolean mostrarNeuroaxial) {
        this.mostrarNeuroaxial = mostrarNeuroaxial;
    }

    /**
     * @return
     */
    public boolean isMostrarNeuroaxial() {
        return mostrarNeuroaxial;
    }

    /**
     * @param mnuFormaAdministracionRegional
     */
    public void setMnuFormaAdministracionRegional(UIInput mnuFormaAdministracionRegional) {
        this.mnuFormaAdministracionRegional = mnuFormaAdministracionRegional;
    }

    /**
     * @return
     */
    public UIInput getMnuFormaAdministracionRegional() {
        return mnuFormaAdministracionRegional;
    }


    /**
     * @param fechainiciooxigeno
     */
    public void setFechainiciooxigeno(Date fechainiciooxigeno) {
        this.fechainiciooxigeno = fechainiciooxigeno;
    }

    /**
     * @return
     */
    public Date getFechainiciooxigeno() {
        return fechainiciooxigeno;
    }

    /**
     * @param fechafinoxigeno
     */
    public void setFechafinoxigeno(Date fechafinoxigeno) {
        this.fechafinoxigeno = fechafinoxigeno;
    }

    /**
     * @return
     */
    public Date getFechafinoxigeno() {
        return fechafinoxigeno;
    }

    /**
     * @param horainiciooxigeno
     */
    public void setHorainiciooxigeno(Integer horainiciooxigeno) {
        this.horainiciooxigeno = horainiciooxigeno;
    }

    /**
     * @return
     */
    public Integer getHorainiciooxigeno() {
        return horainiciooxigeno;
    }

    /**
     * @param horafinoxigeno
     */
    public void setHorafinoxigeno(Integer horafinoxigeno) {
        this.horafinoxigeno = horafinoxigeno;
    }

    /**
     * @return
     */
    public Integer getHorafinoxigeno() {
        return horafinoxigeno;
    }

    /**
     * @param minutoiniciooxigeno
     */
    public void setMinutoiniciooxigeno(Integer minutoiniciooxigeno) {
        this.minutoiniciooxigeno = minutoiniciooxigeno;
    }

    /**
     * @return
     */
    public Integer getMinutoiniciooxigeno() {
        return minutoiniciooxigeno;
    }

    /**
     * @param minutofinoxigeno
     */
    public void setMinutofinoxigeno(Integer minutofinoxigeno) {
        this.minutofinoxigeno = minutofinoxigeno;
    }

    /**
     * @return
     */
    public Integer getMinutofinoxigeno() {
        return minutofinoxigeno;
    }

    /**
     * @return
     */
    public List getListHora() {
        if (listHora.size() == 0) {
            listHora.add(new SelectItem("", "--"));
            listHora.add(new SelectItem(6, "06"));
            listHora.add(new SelectItem(7, "07"));
            listHora.add(new SelectItem(8, "08"));
            listHora.add(new SelectItem(9, "09"));
            listHora.add(new SelectItem(10, "10"));
            listHora.add(new SelectItem(11, "11"));
            listHora.add(new SelectItem(12, "12"));
            listHora.add(new SelectItem(13, "13"));
            listHora.add(new SelectItem(14, "14"));
            listHora.add(new SelectItem(15, "15"));
            listHora.add(new SelectItem(16, "16"));
            listHora.add(new SelectItem(17, "17"));
            listHora.add(new SelectItem(18, "18"));
            listHora.add(new SelectItem(19, "19"));
            listHora.add(new SelectItem(20, "20"));

        }
        return listHora;
    }


    /**
     * @param listHora
     */
    public void setListHora(List listHora) {
        this.listHora = listHora;
    }


    /**
     * @param lstMinutos
     */
    public void setLstMinutos(List lstMinutos) {
        this.lstMinutos = lstMinutos;
    }

    /**
     * @return
     */
    public List getLstMinutos() {
        if (lstMinutos.size() == 0) {
            lstMinutos.add(new SelectItem("", "--"));
            lstMinutos.add(new SelectItem(00, "00"));
            lstMinutos.add(new SelectItem(05, "05"));
            lstMinutos.add(new SelectItem(10, "10"));
            lstMinutos.add(new SelectItem(15, "15"));
            lstMinutos.add(new SelectItem(20, "20"));
            lstMinutos.add(new SelectItem(25, "25"));
            lstMinutos.add(new SelectItem(30, "30"));
            lstMinutos.add(new SelectItem(35, "35"));
            lstMinutos.add(new SelectItem(40, "40"));
            lstMinutos.add(new SelectItem(45, "45"));
            lstMinutos.add(new SelectItem(50, "50"));
            lstMinutos.add(new SelectItem(55, "55"));
        }
        return lstMinutos;
    }

    /**
     * @param fechainicionitroso
     */
    public void setFechainicionitroso(Date fechainicionitroso) {
        this.fechainicionitroso = fechainicionitroso;
    }

    /**
     * @return
     */
    public Date getFechainicionitroso() {
        return fechainicionitroso;
    }

    /**
     * @param fechafinnitroso
     */
    public void setFechafinnitroso(Date fechafinnitroso) {
        this.fechafinnitroso = fechafinnitroso;
    }

    /**
     * @return
     */
    public Date getFechafinnitroso() {
        return fechafinnitroso;
    }

    /**
     * @param horainicionitroso
     */
    public void setHorainicionitroso(Integer horainicionitroso) {
        this.horainicionitroso = horainicionitroso;
    }

    /**
     * @return
     */
    public Integer getHorainicionitroso() {
        return horainicionitroso;
    }

    /**
     * @param horafinnitroso
     */
    public void setHorafinnitroso(Integer horafinnitroso) {
        this.horafinnitroso = horafinnitroso;
    }

    /**
     * @return
     */
    public Integer getHorafinnitroso() {
        return horafinnitroso;
    }

    /**
     * @param minutoinicionitroso
     */
    public void setMinutoinicionitroso(Integer minutoinicionitroso) {
        this.minutoinicionitroso = minutoinicionitroso;
    }

    /**
     * @return
     */
    public Integer getMinutoinicionitroso() {
        return minutoinicionitroso;
    }

    /**
     * @param minutofinnitroso
     */
    public void setMinutofinnitroso(Integer minutofinnitroso) {
        this.minutofinnitroso = minutofinnitroso;
    }

    /**
     * @return
     */
    public Integer getMinutofinnitroso() {
        return minutofinnitroso;
    }

    /**
     * @param fechainicioinhalatorio
     */
    public void setFechainicioinhalatorio(Date fechainicioinhalatorio) {
        this.fechainicioinhalatorio = fechainicioinhalatorio;
    }

    /**
     * @return
     */
    public Date getFechainicioinhalatorio() {
        return fechainicioinhalatorio;
    }

    /**
     * @param fechafininhalatorio
     */
    public void setFechafininhalatorio(Date fechafininhalatorio) {
        this.fechafininhalatorio = fechafininhalatorio;
    }

    /**
     * @return
     */
    public Date getFechafininhalatorio() {
        return fechafininhalatorio;
    }

    /**
     * @param horainicioinhalatorio
     */
    public void setHorainicioinhalatorio(Integer horainicioinhalatorio) {
        this.horainicioinhalatorio = horainicioinhalatorio;
    }

    /**
     * @return
     */
    public Integer getHorainicioinhalatorio() {
        return horainicioinhalatorio;
    }

    /**
     * @param horafininhalatorio
     */
    public void setHorafininhalatorio(Integer horafininhalatorio) {
        this.horafininhalatorio = horafininhalatorio;
    }

    /**
     * @return
     */
    public Integer getHorafininhalatorio() {
        return horafininhalatorio;
    }

    /**
     * @param minutoinicioinhalatorio
     */
    public void setMinutoinicioinhalatorio(Integer minutoinicioinhalatorio) {
        this.minutoinicioinhalatorio = minutoinicioinhalatorio;
    }

    /**
     * @return
     */
    public Integer getMinutoinicioinhalatorio() {
        return minutoinicioinhalatorio;
    }

    /**
     * @param minutofininhalatorio
     */
    public void setMinutofininhalatorio(Integer minutofininhalatorio) {
        this.minutofininhalatorio = minutofininhalatorio;
    }

    /**
     * @return
     */
    public Integer getMinutofininhalatorio() {
        return minutofininhalatorio;
    }

    /**
     * @param fechacambio
     */
    public void setFechacambio(Date fechacambio) {
        this.fechacambio = fechacambio;
    }

    /**
     * @return
     */
    public Date getFechacambio() {
        return fechacambio;
    }

    /**
     * @param horacambio
     */
    public void setHoracambio(Integer horacambio) {
        this.horacambio = horacambio;
    }

    /**
     * @return
     */
    public Integer getHoracambio() {
        return horacambio;
    }

    /**
     * @param minutocambio
     */
    public void setMinutocambio(Integer minutocambio) {
        this.minutocambio = minutocambio;
    }

    /**
     * @return
     */
    public Integer getMinutocambio() {
        return minutocambio;
    }

    /**
     * @param mostraroxigeno
     */
    public void setMostraroxigeno(boolean mostraroxigeno) {
        this.mostraroxigeno = mostraroxigeno;
    }

    /**
     * @return
     */
    public boolean isMostraroxigeno() {
        return mostraroxigeno;
    }

    /**
     * @param mostrarnitroso
     */
    public void setMostrarnitroso(boolean mostrarnitroso) {
        this.mostrarnitroso = mostrarnitroso;
    }

    /**
     * @return
     */
    public boolean isMostrarnitroso() {
        return mostrarnitroso;
    }

    /**
     * @param lstAgente
     */
    public void setLstAgente(List lstAgente) {
        this.lstAgente = lstAgente;
    }

    /**
     * @return
     */
    public List getLstAgente() {
        if (lstAgente.size() == 0) {
       
            lstAgente.add(new SelectItem("H", "Halotano"));
            lstAgente.add(new SelectItem("E", "Enflurano"));
            lstAgente.add(new SelectItem("I", "Isoflurano"));
            lstAgente.add(new SelectItem("S", "Sevoflurano"));
            lstAgente.add(new SelectItem("D", "Desflurano"));
        }
        return lstAgente;
    }

    /**
     * @param mostrarVolumenInduccion
     */
    public void setMostrarVolumenInduccion(boolean mostrarVolumenInduccion) {
        this.mostrarVolumenInduccion = mostrarVolumenInduccion;
    }

    /**
     * @return
     */
    public boolean isMostrarVolumenInduccion() {
        return mostrarVolumenInduccion;
    }

    /**
     * @param mostrarVolumenMantenimiento
     */
    public void setMostrarVolumenMantenimiento(boolean mostrarVolumenMantenimiento) {
        this.mostrarVolumenMantenimiento = mostrarVolumenMantenimiento;
    }

    /**
     * @return
     */
    public boolean isMostrarVolumenMantenimiento() {
        return mostrarVolumenMantenimiento;
    }


    /**
     * @param lstOpciones
     */
    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    /**
     * @return
     */
    public List getLstOpciones() {
        if (lstOpciones.size() == 0) {
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
    }

    /**
     * @param mostrarcambio
     */
    public void setMostrarcambio(boolean mostrarcambio) {
        this.mostrarcambio = mostrarcambio;
    }

    /**
     * @return
     */
    public boolean isMostrarcambio() {
        return mostrarcambio;
    }

    /**
     * @param numeroCirugia
     */
    public void setNumeroCirugia(Long numeroCirugia) {
        this.numeroCirugia = numeroCirugia;
    }

    /**
     * @return
     */
    public Long getNumeroCirugia() {
        return numeroCirugia;
    }

    /**
     * @param tipoServicio
     */
    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * @return
     */
    public String getTipoServicio() {
        return tipoServicio;
    }

    //-----------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //-----------------------------------------------------------------------

    /**
     * @param valueChangeEvent
     */
    public void setEsAnestesiaGeneral(ValueChangeEvent valueChangeEvent) {
        setEsAnestesiaGeneral((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setEsAnestesiaRegional(ValueChangeEvent valueChangeEvent) {
        setEsAnestesiaRegional((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setEsAnestesiaLocal(ValueChangeEvent valueChangeEvent) {
        setEsAnestesiaLocal((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHtactipoanereg(ValueChangeEvent valueChangeEvent) {
        tecnica.setHtactipoanereg((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHtanoxigeno(ValueChangeEvent valueChangeEvent) {
        tecnica.setHtanoxigeno((BigDecimal)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHtanoxidonitro(ValueChangeEvent valueChangeEvent) {
        tecnica.setHtanoxidonitro((BigDecimal)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHtacinducagent(ValueChangeEvent valueChangeEvent) {
        tecnica.setHtacinducagent((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHtacmanteagent(ValueChangeEvent valueChangeEvent) {
        tecnica.setHtacmanteagent((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHtaccambiconce(ValueChangeEvent valueChangeEvent) {
        tecnica.setHtaccambiconce((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void changeAnestesiaGeneral() {
        if (esAnestesiaGeneral) {
            tecnica.setHtacanestgener("S");
        } else {
            tecnica.setHtacanestgener("N");
        }
    }

    public void changeAnestesiaRegional() {
        if (esAnestesiaRegional) {
            tecnica.setHtacanestregio("S");
        } else {
            tecnica.setHtactiponeuroa(null);
            tecnica.setHtactipoanereg("");
            mnuFormaAdministracionRegional.setValue("");
            mostrarNeuroaxial = false;
            tecnica.setHtacanestregio("N");
        }
    }

    public void changeAnestesiaLocal() {
        if (esAnestesiaLocal) {
            tecnica.setHtacanestlocal("S");
        } else {
            tecnica.setHtacanestlocal("N");
        }
    }

    public void changeFormaAdministracionRegional() {
        if (tecnica != null && tecnica.getHtactipoanereg() != null && 
            tecnica.getHtactipoanereg().equals("NE")) {
            mostrarNeuroaxial = true;
        } else {
            tecnica.setHtactiponeuroa(null);
            mostrarNeuroaxial = false;
        }
    }


    public void changeOxigeno() {
        mostraroxigeno = false;
        if (tecnica != null && tecnica.getHtanoxigeno() != null && 
            !tecnica.getHtanoxigeno().equals(0)) {
            mostraroxigeno = true;
        } 
    }

    public void changeOxidoNitroso() {
        mostrarnitroso = false;
        if (tecnica != null && tecnica.getHtanoxidonitro() != null && 
            !tecnica.getHtanoxidonitro().equals(0)) {
            mostrarnitroso = true;
        }
    }


    public void changeAgenteInduccion() {
        if (tecnica != null && tecnica.getHtacinducagent() != null && 
            !tecnica.getHtacinducagent().equals("")) {
            mostrarVolumenInduccion = true;
        } else {
            mostrarVolumenInduccion = false;
        }
    }


    public void changeAgenteMantenimiento() {
        if (tecnica != null && tecnica.getHtacmanteagent() != null && 
            !tecnica.getHtacmanteagent().equals("")) {
            mostrarVolumenMantenimiento = true;
        } else {
            mostrarVolumenMantenimiento = false;
        }
    }


    public void changeCambio() {
        if (tecnica != null && tecnica.getHtaccambiconce() != null && 
            tecnica.getHtaccambiconce().equals("S")) {
            mostrarcambio = true;
        } else {
            mostrarcambio = false;
        }
    }

    //-----------------------------------------------------------------------
    //  Boton Principal 
    //----------------------------------------------------------------------- 

    public String RegistrarTecnicaAnestesia() {
    navegationRule="";
        ChtecnianestPK idTecnica;
        idTecnica = new ChtecnianestPK();
        idTecnica.setHtactiposervi(tipoServicio);
        idTecnica.setHtalnumero(numeroCirugia);
        tecnica.setId(idTecnica);
        tecnica.setHtacoperador(userName());
        tecnica.setHtadfecregistr(new Date());
        tecnica.setHtanclinica(this.getClinica().getCclncodigo());
        if(esAnestesiaGeneral){
            tecnica.setHtacanestgener("G");
        }else if(esAnestesiaLocal){
            tecnica.setHtacanestlocal("L");
        }else if(esAnestesiaRegional){
            tecnica.setHtacanestregio("R");
        }
        
        boolean wexito = true;

        if (tecnica != null) {
            if (tecnica.getHtanconcentrac() != null && 
                tecnica.getHtanconcentrac().compareTo(new BigDecimal(100)) >= 
                0) {
                FacesUtils.addErrorMessage("body:formTecnicaAnestesia:panelTabTecnicaAnestesia:itconcentracion", 
                                           "Error valor incorrecto");
                wexito = false;
            }


            if (tecnica.getHtanmanteconce() != null && 
                tecnica.getHtanmanteconce().compareTo(new BigDecimal(100)) >= 
                0) {
                FacesUtils.addErrorMessage("body:formTecnicaAnestesia:panelTabTecnicaAnestesia:itMantenimientoConcentracion", 
                                           "Error valor incorrecto");
                wexito = false;
            }


            if (tecnica.getHtancambiconce() != null && 
                tecnica.getHtancambiconce().compareTo(new BigDecimal(100)) >= 
                0) {
                FacesUtils.addErrorMessage("body:formTecnicaAnestesia:panelTabTecnicaAnestesia:itPorcentaheCambio", 
                                           "Error valor incorrecto");
                wexito = false;
            }

        }


        if (fechainiciooxigeno != null && horainiciooxigeno != null && 
            minutoiniciooxigeno != null && mostraroxigeno) {
            Calendar fechaaux = Calendar.getInstance();
            fechaaux.setTime(fechainiciooxigeno);
            fechaaux.set(Calendar.HOUR, horainiciooxigeno);
            fechaaux.set(Calendar.MINUTE, minutoiniciooxigeno);
            tecnica.setHtadfechinioxi(fechaaux.getTime());
        }

        if (fechafinoxigeno != null && horafinoxigeno != null && 
            minutofinoxigeno != null && mostraroxigeno) {
            Calendar fechaaux = Calendar.getInstance();
            fechaaux.setTime(fechafinoxigeno);
            fechaaux.set(Calendar.HOUR, horafinoxigeno);
            fechaaux.set(Calendar.MINUTE, minutofinoxigeno);
            tecnica.setHtadfechfinoxi(fechaaux.getTime());
        }


        if (fechainicionitroso != null && horainicionitroso != null && 
            minutoinicionitroso != null && mostrarnitroso) {
            Calendar fechaaux = Calendar.getInstance();
            fechaaux.setTime(fechainicionitroso);
            fechaaux.set(Calendar.HOUR, horainicionitroso);
            fechaaux.set(Calendar.MINUTE, minutoinicionitroso);
            tecnica.setHtadfechininit(fechaaux.getTime());
        }

        if (fechafinnitroso != null && horafinnitroso != null && 
            minutofinnitroso != null && mostrarnitroso) {
            Calendar fechaaux = Calendar.getInstance();
            fechaaux.setTime(fechafinnitroso);
            fechaaux.set(Calendar.HOUR, horafinnitroso);
            fechaaux.set(Calendar.MINUTE, minutofinnitroso);
            tecnica.setHtadfechfinnit(fechaaux.getTime());
        }


        if (fechainicioinhalatorio != null && horainicioinhalatorio != null && 
            minutoinicioinhalatorio != null ) {
            Calendar fechaaux = Calendar.getInstance();
            fechaaux.setTime(fechainicioinhalatorio);
            fechaaux.set(Calendar.HOUR, horainicioinhalatorio);
            fechaaux.set(Calendar.MINUTE, minutoinicioinhalatorio);
            tecnica.setHtadfechiniinh(fechaaux.getTime());
        }

        if (fechafininhalatorio != null && horafininhalatorio != null && 
            minutofininhalatorio != null) {
            Calendar fechaaux = Calendar.getInstance();
            fechaaux.setTime(fechafininhalatorio);
            fechaaux.set(Calendar.HOUR, horafininhalatorio);
            fechaaux.set(Calendar.MINUTE, minutofininhalatorio);
            tecnica.setHtadfechfininh(fechaaux.getTime());
        }


        if (fechacambio != null && horacambio != null && 
            minutocambio != null && mostrarcambio) {
            Calendar fechaaux = Calendar.getInstance();
            fechaaux.setTime(fechacambio);
            fechaaux.set(Calendar.HOUR, horacambio);
            fechaaux.set(Calendar.MINUTE, minutocambio);
            tecnica.setHtadfechacambi(fechaaux.getTime());
        }

        if (wexito) {
            try {
                this.serviceLocator.getClinicoService().saveTecnicaAnestesia(tecnica);
                FacesUtils.addInfoMessage(MSG_ADICION);
                navegationRule ="irCerrarAnestesia";
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(MSG_NO_ADICION);
                e.printStackTrace();
            }
          
        }

        return navegationRule;
    }


    public void setNavegationRule(String navegationRule) {
        this.navegationRule = navegationRule;
    }

    public String getNavegationRule() {
        return navegationRule;
    }

    public void setLtsOxigeno(List ltsOxigeno) {
        this.ltsOxigeno = ltsOxigeno;
    }

    public List getLtsOxigeno() {
        if (ltsOxigeno == null || ltsOxigeno.isEmpty()) {
            ltsOxigeno = new ArrayList();
            ltsOxigeno.add(new SelectItem("","--"));
            ltsOxigeno.add(new SelectItem(new BigDecimal(0.5),"0.5"));
            ltsOxigeno.add(new SelectItem(new BigDecimal(1.0),"1.0"));
            ltsOxigeno.add(new SelectItem(new BigDecimal(1.5),"1.5"));
            ltsOxigeno.add(new SelectItem(new BigDecimal(2.0),"2.0"));
            ltsOxigeno.add(new SelectItem(new BigDecimal(2.5),"2.5"));
            ltsOxigeno.add(new SelectItem(new BigDecimal(3.0),"3.0"));
            ltsOxigeno.add(new SelectItem(new BigDecimal(3.5),"3.5"));
            ltsOxigeno.add(new SelectItem(new BigDecimal(4.0),"4.0"));
            ltsOxigeno.add(new SelectItem(new BigDecimal(4.5),"4.5"));
            ltsOxigeno.add(new SelectItem(new BigDecimal(5.0),"5.0"));
            ltsOxigeno.add(new SelectItem(new BigDecimal(5.5),"5.5"));
            ltsOxigeno.add(new SelectItem(new BigDecimal(6.0),"6.0"));
            ltsOxigeno.add(new SelectItem(new BigDecimal(6.5),"6.5"));
            ltsOxigeno.add(new SelectItem(new BigDecimal(7.0),"7.0"));
            ltsOxigeno.add(new SelectItem(new BigDecimal(7.5),"7.5"));
            ltsOxigeno.add(new SelectItem(new BigDecimal(8.0),"8.0"));
            ltsOxigeno.add(new SelectItem(new BigDecimal(8.5),"8.5"));
            ltsOxigeno.add(new SelectItem(new BigDecimal(9.0),"9.0"));
            ltsOxigeno.add(new SelectItem(new BigDecimal(9.5),"9.5"));
            ltsOxigeno.add(new SelectItem(new BigDecimal(10.0),"10.0"));
            
            
        }
        return ltsOxigeno;
        }


    public void setLtsOxigenoNitroso(List ltsOxigenoNitroso) {
        this.ltsOxigenoNitroso = ltsOxigenoNitroso;
    }

    public List getLtsOxigenoNitroso() {
        if (ltsOxigenoNitroso == null || ltsOxigenoNitroso.isEmpty()) {
            ltsOxigenoNitroso = new ArrayList();
            ltsOxigenoNitroso.add(new SelectItem("","--"));
            ltsOxigenoNitroso.add(new SelectItem(new BigDecimal(0.5),"0.5"));
            ltsOxigenoNitroso.add(new SelectItem(new BigDecimal(1.0),"1.0"));
            ltsOxigenoNitroso.add(new SelectItem(new BigDecimal(1.5),"1.5"));
            ltsOxigenoNitroso.add(new SelectItem(new BigDecimal(2.0),"2.0"));
            ltsOxigenoNitroso.add(new SelectItem(new BigDecimal(2.5),"2.5"));
            ltsOxigenoNitroso.add(new SelectItem(new BigDecimal(3.0),"3.0"));
            ltsOxigenoNitroso.add(new SelectItem(new BigDecimal(3.5),"3.5"));
            ltsOxigenoNitroso.add(new SelectItem(new BigDecimal(4.0),"4.0"));
            ltsOxigenoNitroso.add(new SelectItem(new BigDecimal(4.5),"4.5"));
            ltsOxigenoNitroso.add(new SelectItem(new BigDecimal(5.0),"5.0"));
            ltsOxigenoNitroso.add(new SelectItem(new BigDecimal(5.5),"5.5"));
            ltsOxigenoNitroso.add(new SelectItem(new BigDecimal(6.0),"6.0"));
            ltsOxigenoNitroso.add(new SelectItem(new BigDecimal(6.5),"6.5"));
            ltsOxigenoNitroso.add(new SelectItem(new BigDecimal(7.0),"7.0"));
            ltsOxigenoNitroso.add(new SelectItem(new BigDecimal(7.5),"7.5"));
            ltsOxigenoNitroso.add(new SelectItem(new BigDecimal(8.0),"8.0"));
            ltsOxigenoNitroso.add(new SelectItem(new BigDecimal(8.5),"8.5"));
            ltsOxigenoNitroso.add(new SelectItem(new BigDecimal(9.0),"9.0"));
            ltsOxigenoNitroso.add(new SelectItem(new BigDecimal(9.5),"9.5"));
            ltsOxigenoNitroso.add(new SelectItem(new BigDecimal(10.0),"10.0"));
            
            
        }
        return ltsOxigenoNitroso;
        }

}
