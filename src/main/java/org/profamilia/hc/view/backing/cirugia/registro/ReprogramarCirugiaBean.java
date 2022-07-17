package org.profamilia.hc.view.backing.cirugia.registro;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chciruganula;
import org.profamilia.hc.model.dto.ChciruganulaPK;
import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chconsultori;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chregicirpro;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.comun.CambiarCirugiaBean;
import org.profamilia.hc.view.backing.cirugia.comun.MantenimientoCirugiasBean;
import org.profamilia.hc.view.backing.clinico.comun.BuscadorCirugiasBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class ReprogramarCirugiaBean extends BaseBean {

    private List lstExamenesCirugias;

    private HtmlDataTable dtServicios;

    private HtmlDataTable dtCirugiasNoProgramadas;

    private HtmlDataTable dtCirujanos;

    private HtmlDataTable dtAnestesiologo;

    private HtmlDataTable dtProfesional;
    
    private HtmlDataTable dtFacturasCirugia;
    
    private Chusuario usuario;


    private Chcirugprogr reprogramar;

    private Chciruganula ciruanula;

    private ChciruganulaPK ciruanulaPK;

    private Chregicirpro regicipro;

    private String entidad;

    private String cirujanoSelect;

    private String anestesiologoSelect;

    private String profesionalesSelect;

    private String profesionalSelect;
    
    private List<Chcirugprogr> lstCirugiasPendientes;



    /**Almacena la lista de los posibles minutos que se puede demorar la cirugia */
    private List lstDuracion;

    /** Almacena lel tiempo de aproximado de la cirugia*/
    private String tiempoSelect;

    /** Almacena la lista de las horas habiles para una consulta*/
    private List<SelectItem> listHora;

    /** Almacena la lista de los tipo de hemocomponente para sangre*/
    private List<SelectItem> listTipoHemo;

    /** Almacena la lista de los minutos habiles para una consulta*/
    private List<SelectItem> lstMinutos;

    /** Variable que almacena la hora de la consulta seleccionada*/
    private String horaSelect;

    /** Variable que almacena los minutos de la consulta seleccionada*/
    private String minutoSelect;

    /** Almacena las Salas de Cirugia*/
    private List lstSalasCirugia;

    Cpentidadadm entidadObject;

    private List<Cpprofesio> lstAnestesiologosSelect;

    private List lstAnestesiologo;

    private boolean wexito;

    private boolean renderDisponibilidad;

    private int selectedIndex;

    static int ACTIVAR_MODIFICAR_CIRUGIA = 0;

    static int ACTIVAR_BUSCADOR = 1;

    BuscadorCirugiasBean buscadorCirugias;

    private UIInput mnuAnestesia;

    private UIInput mnuAyudantia;

    private UIInput mnuEstancia;

    private UIInput inputDias;

    private UIInput mnuSangre;

    private UIInput inputUnidades;

    /** Almacena la lista de los tipos de anestesia  */
    private List lstTipoAnestesia;

    /** Almacena la lista de opciones 'SI' o 'NO' */
    private List lstOpciones;

    /** Almacena el tipo de estancia */
    private List lstEstancia;

    /** Almacena el tipo de Ayudantia*/
    private List ltsAyudantia;

    private boolean mostrarProfesionales;

    private List<Cpprofesio> lstProfesionalesSelect;

    private List lstProfesionales;

    /** Almacena true si el tipo de estancia es hospitalaria*/
    private boolean esHospitalaria;

    private boolean mostrarAnestesiologo;

    private boolean mostrarRessangre;

    private boolean renderCancelar;

    private boolean renderReprogramar;

    private boolean renderButton;
    
    private boolean renderCambiarCirugia; 

    private String radioReprogramar;
    
    private String cambiar; 
    
    


    /** Almacena la lista de las horas habiles para una consulta*/
    private List<SelectItem> listHoraDuracion;


    private String radioCancelar;

    private List<Chdetacirpro> lstCirugiasProgramadas;

    MantenimientoCirugiasBean mantenimiento;
    
    CambiarCirugiaBean cambiarCirugia;

    private boolean wmodifica;


    public ReprogramarCirugiaBean() {
    }

    public void init() {

        cargarConsultas();
        
        cambiar  = "N";
        
        renderCambiarCirugia = false; 
        
        lstAnestesiologosSelect = new ArrayList<Cpprofesio>();
        lstProfesionalesSelect = new ArrayList<Cpprofesio>();

        mantenimiento = 
                (MantenimientoCirugiasBean)FacesUtils.getManagedBean("mantenimientoCirugiasBean");
        mantenimiento.setRenderIconEliminar(false);
        mantenimiento.init();
       
        
        
        cambiarCirugia = (CambiarCirugiaBean)FacesUtils.getManagedBean("cambiarCirugiaBean");
        cambiarCirugia.init();
        
    }
    



    public void cargarConsultas() {
        lstExamenesCirugias = new ArrayList();
        radioCancelar = "N";
        radioReprogramar = "N";
        renderReprogramar = false;
        renderCancelar = false;
        renderButton = false;
        cambiar  = "N";
        
      


        if (reprogramar != null && reprogramar.getHcplusuario() != null) {

            if (reprogramar.getHcpctipoestanc() != null && 
                reprogramar.getHcpctipoestanc().equals("H")) {
                esHospitalaria = true;
            } else {
                esHospitalaria = false;
            }

            try {
                entidadObject = 
                        this.serviceLocator.getClinicoService().getDescripcionEntidad(reprogramar.getHcplusuario().getHuslnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (entidadObject != null) {
                entidad = entidadObject.getCeacnombre();
            }




            if (reprogramar.getHcpdfechacirug() != null) {

                Calendar fechaaux1 = Calendar.getInstance();
                fechaaux1.setTime(reprogramar.getHcpdfechacirug());
                Integer hora1;
                Integer minuto1;
                hora1 = (fechaaux1.get(Calendar.HOUR_OF_DAY));
                minuto1 = (fechaaux1.get(Calendar.MINUTE));

                if (hora1 != null && hora1.intValue() < 10) {
                    horaSelect = "0" + hora1;
                } else {
                    horaSelect = hora1 + "";
                }

                if (minuto1 != null && minuto1.intValue() < 10) {
                    minutoSelect = "0" + minuto1;
                } else {
                    minutoSelect = minuto1 + "";
                }


            }

            if (reprogramar.getHcpntiempointe() != null) {
                tiempoSelect = reprogramar.getHcpntiempointe().toString();
            }

            if (reprogramar.getHcpcressangre() != null && 
                reprogramar.getHcpcressangre().equals("S")) {
                mostrarRessangre = true;
            }

            if (reprogramar.getHcpcprofeayuda() != null && 
                !reprogramar.getHcpcprofeayuda().equals("")) {
                mostrarProfesionales = true;
                StringTokenizer stk = 
                    new StringTokenizer(reprogramar.getHcpcprofeayuda(), ",");
                Cpprofesio profesionalAux = null;
                while (stk.hasMoreTokens()) {
                    String idprofesional = stk.nextToken();

                    try {
                        if (idprofesional != null && 
                            reprogramar.getHcpnclinica() != null)
                            profesionalAux = 
                                    this.serviceLocator.getClinicoService().getProfesionalXCodigo(idprofesional, 
                                                                                                  reprogramar.getHcpnclinica());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    if (profesionalAux != null) {
                        lstProfesionalesSelect.add(profesionalAux);
                    }

                }

            } else {
                mostrarProfesionales = false;

            }
        }


        if (reprogramar != null && reprogramar.getHcpcanestesiol() != null && 
            !reprogramar.getHcpcanestesiol().equals("")) {
            mostrarAnestesiologo = true;
            StringTokenizer stk = 
                new StringTokenizer(reprogramar.getHcpcanestesiol(), ",");
            Cpprofesio anestesiologoAux = null;
            while (stk.hasMoreTokens()) {
                String idanestesiologo = stk.nextToken();

                try {
                    if (idanestesiologo != null && 
                        reprogramar.getHcpnclinica() != null)
                        anestesiologoAux = 
                                this.serviceLocator.getClinicoService().getProfesionalXCodigo(idanestesiologo, 
                                                                                              reprogramar.getHcpnclinica());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (anestesiologoAux != null) {
                    lstAnestesiologosSelect.add(anestesiologoAux);
                }

            }
        } else {
            mostrarAnestesiologo = false;
        }


    }

    /**
     * @param valueChangeEvent
     */
    public void setHcpcressangre(ValueChangeEvent valueChangeEvent) {
        reprogramar.setHcpcressangre((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setListTipoHemo(List<SelectItem> listTipoHemo) {
        this.listTipoHemo = listTipoHemo;
    }

    /**
     * @return
     */
    public List<SelectItem> getListTipoHemo() {
        if (listTipoHemo == null || listTipoHemo.isEmpty()) {
            listTipoHemo = new ArrayList<SelectItem>();
            listTipoHemo.add(new SelectItem("", "Seleccione ...."));
            listTipoHemo.add(new SelectItem("GR", "Globulos Rojos"));
            listTipoHemo.add(new SelectItem("PQ", "Plaquetas"));
            listTipoHemo.add(new SelectItem("PL", "Plasma"));
            listTipoHemo.add(new SelectItem("SC", "Sangre Completa"));
        }
        return listTipoHemo;
    }

    /**
     * @param lstSalasCirugia
     */
    public void setLstSalasCirugia(List lstSalasCirugia) {
        this.lstSalasCirugia = lstSalasCirugia;
    }

    /**
     * @return
     */
    public List getLstSalasCirugia() {
        if (lstSalasCirugia == null) {
            lstSalasCirugia = new ArrayList();
            ArrayList<Chconsultori> lstSalasAux = null;
            Integer tipoSala = 2;

            try {
                lstSalasAux = 
                        (ArrayList<Chconsultori>)this.getServiceLocator().getCirugiaService().getConsultoriosXClinica(tipoSala, 
                                                                                                                      this.getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstSalasAux.isEmpty()) {

                lstSalasCirugia.add(new SelectItem("", 
                                                   "Seleccione una opcion ..."));
                Iterator it = lstSalasAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstSalasCirugia.add(new SelectItem((lstSalasAux.get(i).getId().getHconnumero()), 
                                                       lstSalasAux.get(i).getHcocdescripcio()));
                    i++;
                }
            }
        }
        return lstSalasCirugia;
    }


    /**
     * @param lstTipoAnestesia
     */
    public void setLstTipoAnestesia(List lstTipoAnestesia) {
        this.lstTipoAnestesia = lstTipoAnestesia;
    }

    public List getLstTipoAnestesia() {
        if (lstTipoAnestesia == null || lstTipoAnestesia.isEmpty()) {
            lstTipoAnestesia = new ArrayList();
            lstTipoAnestesia.add(new SelectItem("2", "General"));
            lstTipoAnestesia.add(new SelectItem("4", "Regional"));
            lstTipoAnestesia.add(new SelectItem("5", "Sedaci�n"));
            lstTipoAnestesia.add(new SelectItem("6", "Local"));
            lstTipoAnestesia.add(new SelectItem("7", "Local Controlada"));
        }
        return lstTipoAnestesia;
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
        if (lstOpciones == null) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
    }

    public void setProfesionalSelect(String profesionalSelect) {
        this.profesionalSelect = profesionalSelect;
    }

    public String getProfesionalSelect() {
        return profesionalSelect;
    }

    /**
     * @param esHospitalaria
     */
    public void setEsHospitalaria(boolean esHospitalaria) {
        this.esHospitalaria = esHospitalaria;
    }

    /**
     * @return
     */
    public boolean isEsHospitalaria() {
        return esHospitalaria;
    }

    /**
     * @param mnuAnestesia
     */
    public void setMnuAnestesia(UIInput mnuAnestesia) {
        this.mnuAnestesia = mnuAnestesia;
    }

    /**
     * @return
     */
    public UIInput getMnuAnestesia() {
        return mnuAnestesia;
    }

    /**
     * @param mnuAyudantia
     */
    public void setMnuAyudantia(UIInput mnuAyudantia) {
        this.mnuAyudantia = mnuAyudantia;
    }

    /**
     * @return
     */
    public UIInput getMnuAyudantia() {
        return mnuAyudantia;
    }

    /**
     * @param mnuEstancia
     */
    public void setMnuEstancia(UIInput mnuEstancia) {
        this.mnuEstancia = mnuEstancia;
    }

    /**
     * @return
     */
    public UIInput getMnuEstancia() {
        return mnuEstancia;
    }

    /**
     * @param inputDias
     */
    public void setInputDias(UIInput inputDias) {
        this.inputDias = inputDias;
    }

    /**
     * @return
     */
    public UIInput getInputDias() {
        return inputDias;
    }


    /**
     * @param lstEstancia
     */
    public void setLstEstancia(List lstEstancia) {
        this.lstEstancia = lstEstancia;
    }

    /**
     * @return
     */
    public List getLstEstancia() {
        if (lstEstancia == null) {
            lstEstancia = new ArrayList();
            lstEstancia.add(new SelectItem("S", "Si"));
            lstEstancia.add(new SelectItem("N", "No"));
        }
        return lstEstancia;
    }

    /**
     * @param valueChangeEvent
     */
    public void setHcpctipoayudan(ValueChangeEvent valueChangeEvent) {
        reprogramar.setHcpctipoayudan((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param lstExamenesCirugias
     */
    public void setLstExamenesCirugias(List lstExamenesCirugias) {
        this.lstExamenesCirugias = lstExamenesCirugias;
    }

    /**
     * @return
     */
    public List getLstExamenesCirugias() {
        return lstExamenesCirugias;
    }

    /**
     * @param dtServicios
     */
    public void setDtServicios(HtmlDataTable dtServicios) {
        this.dtServicios = dtServicios;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtServicios() {
        return dtServicios;
    }

    /**
     * @param dtCirugiasNoProgramadas
     */
    public void setDtCirugiasNoProgramadas(HtmlDataTable dtCirugiasNoProgramadas) {
        this.dtCirugiasNoProgramadas = dtCirugiasNoProgramadas;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCirugiasNoProgramadas() {
        return dtCirugiasNoProgramadas;
    }

    /**
     * @param reprogramar
     */
    public void setreprogramar(Chcirugprogr reprogramar) {
        this.reprogramar = reprogramar;
    }

    /**
     * @return
     */
    public Chcirugprogr getreprogramar() {
        return reprogramar;
    }

    /**
     * @param entidad
     */
    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    /**
     * @return
     */
    public String getEntidad() {
        return entidad;
    }

    /**
     * @param lstDuracion
     */
    public void setLstDuracion(List lstDuracion) {
        this.lstDuracion = lstDuracion;
    }

    /**
     * @return
     */
    public List getLstDuracion() {
        if (lstDuracion == null) {
            lstDuracion = new ArrayList();
            lstDuracion.add(new SelectItem("", "--"));
            lstDuracion.add(new SelectItem("10", "10"));
            lstDuracion.add(new SelectItem("20", "20"));
            lstDuracion.add(new SelectItem("30", "30"));
            lstDuracion.add(new SelectItem("40", "40"));
            lstDuracion.add(new SelectItem("50", "50"));
            lstDuracion.add(new SelectItem("60", "60"));
            lstDuracion.add(new SelectItem("70", "70"));
            lstDuracion.add(new SelectItem("80", "80"));
            lstDuracion.add(new SelectItem("90", "90"));
            lstDuracion.add(new SelectItem("100", "100"));
            lstDuracion.add(new SelectItem("110", "110"));
            lstDuracion.add(new SelectItem("120", "120"));
            lstDuracion.add(new SelectItem("130", "130"));
            lstDuracion.add(new SelectItem("140", "140"));
            lstDuracion.add(new SelectItem("150", "150"));
            lstDuracion.add(new SelectItem("160", "160"));
            lstDuracion.add(new SelectItem("170", "170"));
            lstDuracion.add(new SelectItem("180", "180"));
            lstDuracion.add(new SelectItem("190", "190"));
            lstDuracion.add(new SelectItem("200", "200"));
            lstDuracion.add(new SelectItem("210", "210"));
            lstDuracion.add(new SelectItem("220", "220"));
            lstDuracion.add(new SelectItem("230", "230"));
            lstDuracion.add(new SelectItem("240", "240"));
            lstDuracion.add(new SelectItem("250", "250"));
            lstDuracion.add(new SelectItem("260", "260"));
            lstDuracion.add(new SelectItem("270", "270"));
            lstDuracion.add(new SelectItem("280", "280"));
            lstDuracion.add(new SelectItem("290", "290"));
            lstDuracion.add(new SelectItem("300", "300"));
            lstDuracion.add(new SelectItem("310", "310"));
            lstDuracion.add(new SelectItem("320", "320"));
            lstDuracion.add(new SelectItem("330", "330"));
            lstDuracion.add(new SelectItem("340", "340"));
            lstDuracion.add(new SelectItem("350", "350"));
            lstDuracion.add(new SelectItem("360", "360"));
            lstDuracion.add(new SelectItem("370", "370"));
            lstDuracion.add(new SelectItem("380", "380"));
            lstDuracion.add(new SelectItem("390", "390"));
            lstDuracion.add(new SelectItem("400", "400"));


        }
        return lstDuracion;
    }


    /**
     * @param listHora
     */
    public void setListHora(List<SelectItem> listHora) {
        this.listHora = listHora;
    }

    /**
     * @return
     */
    public List<SelectItem> getListHora() {
        if (listHora == null) {
            listHora = new ArrayList<SelectItem>();
            listHora.add(new SelectItem("", "--"));
            listHora.add(new SelectItem("06", "06"));
            listHora.add(new SelectItem("07", "07"));
            listHora.add(new SelectItem("08", "08"));
            listHora.add(new SelectItem("09", "09"));
            listHora.add(new SelectItem("10", "10"));
            listHora.add(new SelectItem("11", "11"));
            listHora.add(new SelectItem("12", "12"));
            listHora.add(new SelectItem("13", "13"));
            listHora.add(new SelectItem("14", "14"));
            listHora.add(new SelectItem("15", "15"));
            listHora.add(new SelectItem("16", "16"));
            listHora.add(new SelectItem("17", "17"));
            listHora.add(new SelectItem("18", "18"));
            listHora.add(new SelectItem("19", "19"));
            listHora.add(new SelectItem("20", "20"));

        }
        return listHora;
    }

    /**
     * @param lstMinutos
     */
    public void setLstMinutos(List<SelectItem> lstMinutos) {
        this.lstMinutos = lstMinutos;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstMinutos() {
        if (lstMinutos == null) {
            lstMinutos = new ArrayList<SelectItem>();
            lstMinutos.add(new SelectItem("", "--"));
            lstMinutos.add(new SelectItem("00", "00"));
            lstMinutos.add(new SelectItem("05", "05"));
            lstMinutos.add(new SelectItem("10", "10"));
            lstMinutos.add(new SelectItem("15", "15"));
            lstMinutos.add(new SelectItem("20", "20"));
            lstMinutos.add(new SelectItem("25", "25"));
            lstMinutos.add(new SelectItem("30", "30"));
            lstMinutos.add(new SelectItem("35", "35"));
            lstMinutos.add(new SelectItem("40", "40"));
            lstMinutos.add(new SelectItem("45", "45"));
            lstMinutos.add(new SelectItem("50", "50"));
            lstMinutos.add(new SelectItem("55", "55"));
        }
        return lstMinutos;
    }

    /**
     * @param horaSelect
     */
    public void setHoraSelect(String horaSelect) {
        this.horaSelect = horaSelect;
    }

    /**
     * @return
     */
    public String getHoraSelect() {
        return horaSelect;
    }

    /**
     * @param minutoSelect
     */
    public void setMinutoSelect(String minutoSelect) {
        this.minutoSelect = minutoSelect;
    }

    /**
     * @return
     */
    public String getMinutoSelect() {
        return minutoSelect;
    }

    /**
     * @param tiempoSelect
     */
    public void setTiempoSelect(String tiempoSelect) {
        this.tiempoSelect = tiempoSelect;
    }

    /**
     * @return
     */
    public String getTiempoSelect() {
        return tiempoSelect;
    }


    /**
     * @param cirujanoSelect
     */
    public void setCirujanoSelect(String cirujanoSelect) {
        this.cirujanoSelect = cirujanoSelect;
    }

    /**
     * @return
     */
    public String getCirujanoSelect() {
        return cirujanoSelect;
    }

    /**
     * @param anestesiologoSelect
     */
    public void setAnestesiologoSelect(String anestesiologoSelect) {
        this.anestesiologoSelect = anestesiologoSelect;
    }

    /**
     * @return
     */
    public String getAnestesiologoSelect() {
        return anestesiologoSelect;
    }


    /**
     * @param dtCirujanos
     */
    public void setDtCirujanos(HtmlDataTable dtCirujanos) {
        this.dtCirujanos = dtCirujanos;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCirujanos() {
        return dtCirujanos;
    }

    /**
     * @param mostrarAnestesiologo
     */
    public void setMostrarAnestesiologo(boolean mostrarAnestesiologo) {
        this.mostrarAnestesiologo = mostrarAnestesiologo;
    }

    /**
     * @return
     */
    public boolean isMostrarAnestesiologo() {
        return mostrarAnestesiologo;
    }

    public void changeRessangre() {
        if (reprogramar != null && reprogramar.getHcpcressangre() != null && 
            reprogramar.getHcpcressangre().equals("S")) {
            mostrarRessangre = true;
        } else {
            mostrarRessangre = false;
            reprogramar.setHcpctipohemoco(null);
            reprogramar.setHcpnnumerounid(null);
        }
    }

    /** */
    public void setMnuSangre(UIInput mnuSangre) {
        this.mnuSangre = mnuSangre;
    }

    public UIInput getMnuSangre() {
        return mnuSangre;
    }

    public void changeSangre() {
        if (reprogramar != null && reprogramar.getHcpcressangre() != null && 
            reprogramar.getHcpcressangre().equals("S")) {
            mostrarRessangre = true;
        } else {
            mostrarRessangre = false;
        }
    }

    /**
     * @param dtAnestesiologo
     */
    public void setDtAnestesiologo(HtmlDataTable dtAnestesiologo) {
        this.dtAnestesiologo = dtAnestesiologo;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtAnestesiologo() {
        return dtAnestesiologo;
    }

    /**
     * @param lstAnestesiologosSelect
     */
    public void setLstAnestesiologosSelect(List<Cpprofesio> lstAnestesiologosSelect) {
        this.lstAnestesiologosSelect = lstAnestesiologosSelect;
    }


    /**
     * @param renderDisponibilidad
     */
    public void setRenderDisponibilidad(boolean renderDisponibilidad) {
        this.renderDisponibilidad = renderDisponibilidad;
    }

    /**
     * @return
     */
    public boolean isRenderDisponibilidad() {
        return renderDisponibilidad;
    }

    /**
     * @return
     */
    public List<Cpprofesio> getLstAnestesiologosSelect() {
        return lstAnestesiologosSelect;
    }

    public void setInputUnidades(UIInput inputUnidades) {
        this.inputUnidades = inputUnidades;
    }

    public UIInput getInputUnidades() {
        return inputUnidades;
    }


    /**
     * @param selectedIndex
     */
    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    /**
     * @return
     */
    public int getSelectedIndex() {
        return selectedIndex;
    }

    /**
     * @param lstCirugiasProgramadas
     */
    public void setLstCirugiasProgramadas(List<Chdetacirpro> lstCirugiasProgramadas) {
        this.lstCirugiasProgramadas = lstCirugiasProgramadas;
    }

    /**
     * @return
     */
    public List<Chdetacirpro> getLstCirugiasProgramadas() {
        return lstCirugiasProgramadas;
    }


    public void eliminarAnestesiologo() {
        Cpprofesio anestesiologoDelete = null;
        anestesiologoDelete = (Cpprofesio)dtAnestesiologo.getRowData();
        lstAnestesiologosSelect.remove(anestesiologoDelete);
    }

    public void adicionarCirugia() {
        Cnconsclin cirugiaAux;
        cirugiaAux = (Cnconsclin)dtCirugiasNoProgramadas.getRowData();
         lstExamenesCirugias.add(cirugiaAux.getCcocservic());

    }


    public void volver() {
        FacesUtils.resetManagedBean("buscadorDisponibilidadSalaBean");
        selectedIndex = ACTIVAR_MODIFICAR_CIRUGIA;
        renderDisponibilidad = false;
    }

    public void mostrarBuscador() {
        FacesUtils.resetManagedBean("buscadorDisponibilidadSalaBean");
        selectedIndex = ACTIVAR_BUSCADOR;
        renderDisponibilidad = true;
    }

    public void changeEstancia() {
        if (reprogramar != null && reprogramar.getHcpctipoestanc() != null && 
            reprogramar.getHcpctipoestanc().equals("H")) {
            esHospitalaria = true;
        } else {
            esHospitalaria = false;
        }
    }

    public void changeAnestesia() {
        if (reprogramar != null && reprogramar.getHcpctipoaneste() != null && 
            reprogramar.getHcpctipoaneste().equals("2")) {
            mostrarAnestesiologo = true;
        } else if (reprogramar != null && 
                   reprogramar.getHcpctipoaneste() != null && 
                   reprogramar.getHcpctipoaneste().equals("4")) {
            mostrarAnestesiologo = true;
        } else {
            mostrarAnestesiologo = false;
            lstAnestesiologosSelect = new ArrayList<Cpprofesio>();
        }
    }

    public void setLtsAyudantia(List ltsAyudantia) {
        this.ltsAyudantia = ltsAyudantia;
    }

    public List getLtsAyudantia() {
        if (ltsAyudantia == null || ltsAyudantia.isEmpty()) {
            ltsAyudantia = new ArrayList();
            ltsAyudantia.add(new SelectItem("S", "SI"));
            ltsAyudantia.add(new SelectItem("N", "NO"));

        }
        return ltsAyudantia;
    }

    public void changeAyudantia() {
        if (reprogramar != null && reprogramar.getHcpctipoayudan() != null && 
            reprogramar.getHcpctipoayudan().equals("S")) {
            mostrarProfesionales = true;
        } else {
            mostrarProfesionales = false;
            lstProfesionalesSelect = new ArrayList<Cpprofesio>();
        }
    }

    public void setLstProfesionalesSelect(List<Cpprofesio> lstProfesionalesSelect) {
        this.lstProfesionalesSelect = lstProfesionalesSelect;
    }

    public List<Cpprofesio> getLstProfesionalesSelect() {
        return lstProfesionalesSelect;
    }

    public void muestraCancelar() {

    }

    public void listenReprogramaCirugia(ValueChangeEvent valueChangeEvent) {
        String value = 
            (String)(((UIInput)valueChangeEvent.getComponent()).getValue());

        if (value.equals("S")) {
            renderReprogramar = true;
            renderButton = false;

        } else if (value.equals("N")) {
            renderReprogramar = false;
            renderButton = true;

        }
    }

    public void listenCancelaCirugia(ValueChangeEvent valueChangeEvent) {
        String value = 
            (String)(((UIInput)valueChangeEvent.getComponent()).getValue());

        if (value.equals("S")) {
            renderCancelar = true;
            renderButton = true;

        } else if (value.equals("N")) {
            renderCancelar = false;
            renderReprogramar = false;
            renderButton = false;

        }
    }


    public void agregarProfesional() {
        Cpprofesio profeObject;
        profeObject = null;
        if (profesionalSelect != null) {
            try {
                profeObject = 
                        this.serviceLocator.getClinicoService().getProfesionalXCodigo(profesionalSelect, 
                                                                                      this.getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (profeObject != null) {
                lstProfesionalesSelect.add(profeObject);
                profesionalSelect = "";
            }
        }
    }


    public void agregarAnestesiologo() {
        Cpprofesio anesObject;
        anesObject = null;
        if (anestesiologoSelect != null) {
            try {
                anesObject = 
                        this.serviceLocator.getClinicoService().getEspecialistaXCodigo(anestesiologoSelect, 
                                                                                       this.getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (anesObject != null) {
                lstAnestesiologosSelect.add(anesObject);
                anestesiologoSelect = "";
            }
        }
    }

    /**
     * @param valueChangeEvent
     */
    public void setEstanciaSelect(ValueChangeEvent valueChangeEvent) {
        reprogramar.setHcpctipoestanc((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHcpctipoaneste(ValueChangeEvent valueChangeEvent) {
        reprogramar.setHcpctipoaneste((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @return
     */
    public String modificarCirugia() {
        wexito = true;
        wmodifica = true;

        if (reprogramar.getHcpcingreenfer() != null && reprogramar.getHcpcingreenfer().equals("S")) {
            FacesUtils.addErrorMessage("Ya tiene ingreso de enfermeria, no puede modificar la Cirugia");
            wexito = false;
        }

        if (wexito) {
            cancelarCirugia();
            reprogramar.setHcpcestado(ESTADO_VIGENTE);
            reprogramar.setHcpcoperamodif(userName());
            reprogramar.setHcpdfechamodif(new Date());
            if (tiempoSelect != null) {
                reprogramar.setHcpntiempointe(new Integer(tiempoSelect));
            }

            if (entidadObject != null) {
                reprogramar.setHcpcentidadadm(entidadObject.getCeaccodigo());
            }

            if (reprogramar.getHcpctipoaneste() != null && 
                reprogramar.getHcpctipoaneste().equals("2")) {
                if (lstAnestesiologosSelect != null && 
                    !lstAnestesiologosSelect.isEmpty()) {
                    String codigosAneste = "";
                    Cpprofesio anesAux;
                    anesAux = null;
                    Iterator it = lstAnestesiologosSelect.iterator();
                    while (it.hasNext()) {
                        anesAux = (Cpprofesio)it.next();
                        if (anesAux != null) {
                            codigosAneste = 
                                codigosAneste + anesAux.getId().getCpfncodigo() + 
                                ",";
                        }
                    }

                    codigosAneste = 
                            codigosAneste.substring(0, codigosAneste.length() - 1);

                    if (codigosAneste != null) {
                        reprogramar.setHcpcanestesiol(codigosAneste);
                    }
                } else {
                    FacesUtils.addErrorMessage("body:formModificarCirugia:panelTabModificarCirugia:otAnestesiologo", 
                                           MSG_VALIDACION_REQUERIDO);
                    wexito = false;
                }

            }
            if (reprogramar.getHcpctipoayudan() != null && 
                reprogramar.getHcpctipoayudan().equals("S")) {
                if (lstProfesionalesSelect != null && 
                    !lstProfesionalesSelect.isEmpty()) {
                    String codigosProfes = "";
                    Cpprofesio profAux;
                    profAux = null;
                    Iterator it = lstProfesionalesSelect.iterator();
                    while (it.hasNext()) {
                        profAux = (Cpprofesio)it.next();
                        if (profAux != null) {
                            codigosProfes = 
                                codigosProfes + profAux.getId().getCpfncodigo() + 
                                ",";
                        }
                    }

                    codigosProfes = 
                        codigosProfes.substring(0, codigosProfes.length() - 1);
                    if (codigosProfes != null) {
                        reprogramar.setHcpcprofeayuda(codigosProfes);
                    }
                } else {
                    FacesUtils.addErrorMessage("body:formModificarCirugia:panelTabModificarCirugia:otProfesionales", 
                                           MSG_VALIDACION_REQUERIDO);
                    wexito = false;
                }
            }
            
            if (reprogramar.getHcpdfechacirug() != null && 
                reprogramar.getHcpntiempointe() != null && horaSelect != null && 
                !horaSelect.equals("") && minutoSelect != null && 
                !minutoSelect.equals("")) {
                Calendar fechaapx1 = Calendar.getInstance();
                fechaapx1.setTime(reprogramar.getHcpdfechacirug());
                fechaapx1.set(Calendar.HOUR_OF_DAY, new Integer(horaSelect));
                fechaapx1.set(Calendar.MINUTE, new Integer(minutoSelect));
                reprogramar.setHcpdfechacirug(fechaapx1.getTime());
                reprogramar.setHcpcetapa(IConstantes.ETAPA_ESPERA);

                fechaapx1.add(Calendar.MINUTE, reprogramar.getHcpntiempointe());
                reprogramar.setHcpdfechfincir(fechaapx1.getTime());
            }
        }

        if (wexito) {
            try {
                wexito = 
                        serviceLocator.getCirugiaService().verificarDisponibilidadSala(getClinica().getCclncodigo(), 
                                                                                       reprogramar.getHcpnsalainterv(), 
                                                                                       reprogramar.getHcpdfechacirug(), 
                                                                                       reprogramar.getHcpntiempointe(), 
                                                                                       reprogramar.getHcplnumero());
            } catch (ModelException e) {
                wexito = false;
                FacesUtils.addErrorMessage(e.getMessage());
                e.printStackTrace();
            }

            if (!wexito) {
                FacesUtils.addErrorMessage("No hay Disponibilidad en la sala seleccionada, porfavor intente nuevamente");
            }
        }
        
        if(cambiar != null){
            lstCirugiasProgramadas = cambiarCirugia.getLstCirugiasProgramadas();    
        }

      

        if (wexito) {
            for (Chdetacirpro detaCirugia: lstCirugiasProgramadas) {
                if (detaCirugia.getHdcnmedicatien() == null) {
                    wexito = false;
                    FacesUtils.addErrorMessage(IMsg.MSG_CIRUGIA_SIN_MEDICO);
                }
            }
        }

        if (wexito) {
            try {
                this.serviceLocator.getCirugiaService().updateProgramarCirugia(reprogramar, 
                                                                               lstCirugiasProgramadas);

                FacesUtils.addInfoMessage("IMsg.MSG_ACTUALIZA_CIRUGIA");
                FacesUtils.resetManagedBean("modificarreprogramarBean");
                FacesUtils.resetManagedBean("consultarCirugiasProgramarBean");
                return BeanNavegacion.RUTA_HOME;

            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                e.printStackTrace();
                return BeanNavegacion.RUTA_ACTUAL;
            }
        }

        return null;
    }

    public void setMostrarProfesionales(boolean mostrarProfesionales) {
        this.mostrarProfesionales = mostrarProfesionales;
    }

    public boolean isMostrarProfesionales() {
        return mostrarProfesionales;
    }

    /**
     * @param lstAnestesiologo
     */
    public void setLstAnestesiologo(List lstAnestesiologo) {
        this.lstAnestesiologo = lstAnestesiologo;
    }

    /**
     * @return
     */
    public List getLstAnestesiologo() {
        if (lstAnestesiologo == null || lstAnestesiologo.isEmpty()) {
            lstAnestesiologo = new ArrayList();
            ArrayList<Cpprofesio> listProfesionalesAux = null;
            try {
                listProfesionalesAux = 
                        (ArrayList<Cpprofesio>)this.serviceLocator.getClinicoService().getListaAnestesiologoClinica(getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listProfesionalesAux.isEmpty()) {

                Iterator it = listProfesionalesAux.iterator();
                int i = 0;
                lstAnestesiologo.add(new SelectItem("", 
                                                    "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstAnestesiologo.add(new SelectItem(listProfesionalesAux.get(i).getId().getCpfncodigo().toString(), 
                                                        listProfesionalesAux.get(i).getCpfcnombre()));
                    i++;
                }
            }
        }

        return lstAnestesiologo;
    }


    /**
     * @param lstProfesionales
     */
    public void setLstProfesionales(List lstProfesionales) {
        this.lstProfesionales = lstProfesionales;
    }

    /**
     * @return
     */
    public List getLstProfesionales() {
        if (lstProfesionales == null || lstProfesionales.isEmpty()) {
            lstProfesionales = new ArrayList();
            ArrayList<Cpprofesio> listProfesionalesAux = null;
            try {
                listProfesionalesAux = 
                        (ArrayList<Cpprofesio>)this.serviceLocator.getCirugiaService().getListaMedicosClinica(getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listProfesionalesAux.isEmpty()) {

                Iterator it = listProfesionalesAux.iterator();
                int i = 0;
                lstProfesionales.add(new SelectItem("", 
                                                    "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstProfesionales.add(new SelectItem(listProfesionalesAux.get(i).getId().getCpfncodigo().toString(), 
                                                        listProfesionalesAux.get(i).getCpfcnombre()));
                    i++;
                }
            }
        }

        return lstProfesionales;
    }

    public String cancelarCirugia() {

        if (reprogramar.getHcpcingreenfer() != null && reprogramar.getHcpcingreenfer().equals("S")) {
            FacesUtils.addErrorMessage("Ya tiene ingreso de enfermeria, no puede modificar la Cirugia");
            wexito = false;
        } else {
            if (!wmodifica) {
                reprogramar.setHcpcestado("XX");
                reprogramar.setHcpcoperaanula(userName());
                reprogramar.setHcpdfechaanula(new Date());
            }

            try {
                regicipro = 
                    this.serviceLocator.getCirugiaService().getCirsinfacNumero(reprogramar.getHcplnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (!wmodifica) {
                if (regicipro != null && !regicipro.equals("")) {
                    regicipro.setHrccestado("XX");
                }
            }
            ciruanula = new Chciruganula();
            ciruanula.getId().setHcalnumero(reprogramar.getHcplnumero());
            ciruanula.setHcadfechaciran(new Date());
            ciruanula.setHcadfechaanula(reprogramar.getHcpdfechacirug());
            ciruanula.setHcacoperanula(userName());
            ciruanula.setHcacobseranula(reprogramar.getHcpcobseranula());
            ciruanula.setHcacmotivanula(reprogramar.getHcpcmotivanula());
        
            if (wmodifica) {
                reprogramar.setHcpcobseranula(null);
                reprogramar.setHcpcmotivanula(null);
            }

            try {
                serviceLocator.getCirugiaService().updateChcirugprogr(reprogramar, 
                                                                  regicipro, 
                                                                  ciruanula);


                FacesUtils.addInfoMessage("MSG_CANCELACION_CIRUGIA");
                renderReprogramar = true;
                renderCancelar = false;
            } catch (ModelException e) {
                e.printStackTrace();
            }
            return BeanNavegacion.RUTA_HOME;
        }

        return null;

    }


    /**
     * @param radioCancelar
     */
    public void setRadioCancelar(String radioCancelar) {
        this.radioCancelar = radioCancelar;
    }

    /**
     * @return
     */
    public String getRadioCancelar() {
        return radioCancelar;
    }


    /**
     * @param renderCancelar
     */
    public void setRenderCancelar(boolean renderCancelar) {
        this.renderCancelar = renderCancelar;
    }

    /**
     * @return
     */
    public boolean isRenderCancelar() {
        return renderCancelar;
    }

    public void eliminarProfesional() {
        Cpprofesio profesionalDelete = null;
        profesionalDelete = (Cpprofesio)dtProfesional.getRowData();
        lstProfesionalesSelect.remove(profesionalDelete);
    }


    public void setDtProfesional(HtmlDataTable dtProfesional) {
        this.dtProfesional = dtProfesional;
    }

    public HtmlDataTable getDtProfesional() {
        return dtProfesional;
    }

    public void setProfesionalesSelect(String profesionalesSelect) {
        this.profesionalesSelect = profesionalesSelect;
    }

    public String getProfesionalesSelect() {
        return profesionalesSelect;
    }

    public void setListHoraDuracion(List<SelectItem> listHoraDuracion) {
        this.listHoraDuracion = listHoraDuracion;
    }

    public List<SelectItem> getListHoraDuracion() {
        if (listHoraDuracion == null || listHoraDuracion.isEmpty()) {
            listHoraDuracion = new ArrayList<SelectItem>();
            listHoraDuracion.add(new SelectItem("", "--"));
            listHoraDuracion.add(new SelectItem("00", "00"));
            listHoraDuracion.add(new SelectItem("01", "01"));
            listHoraDuracion.add(new SelectItem("02", "02"));
            listHoraDuracion.add(new SelectItem("03", "03"));
            listHoraDuracion.add(new SelectItem("04", "04"));
            listHoraDuracion.add(new SelectItem("05", "05"));
            listHoraDuracion.add(new SelectItem("06", "06"));
            listHoraDuracion.add(new SelectItem("07", "07"));
            listHoraDuracion.add(new SelectItem("08", "08"));
            listHoraDuracion.add(new SelectItem("09", "09"));
            listHoraDuracion.add(new SelectItem("10", "10"));
            listHoraDuracion.add(new SelectItem("11", "11"));

        }
        return listHoraDuracion;
    }

    public void setRegicipro(Chregicirpro regicipro) {
        this.regicipro = regicipro;
    }

    public Chregicirpro getRegicipro() {
        return regicipro;
    }

    public void setReprogramar(Chcirugprogr reprogramar) {
        this.reprogramar = reprogramar;
    }

    public Chcirugprogr getReprogramar() {
        return reprogramar;
    }

    public void setRenderReprogramar(boolean renderReprogramar) {
        this.renderReprogramar = renderReprogramar;
    }

    public boolean isRenderReprogramar() {
        return renderReprogramar;
    }

    public void setCiruanula(Chciruganula ciruanula) {
        this.ciruanula = ciruanula;
    }

    public Chciruganula getCiruanula() {
        return ciruanula;
    }

    public void setRadioReprogramar(String radioReprogramar) {
        this.radioReprogramar = radioReprogramar;
    }

    public String isRadioReprogramar() {
        return radioReprogramar;
    }

    public void setRenderButton(boolean renderButton) {
        this.renderButton = renderButton;
    }

    public boolean isRenderButton() {
        return renderButton;
    }

    public String getRadioReprogramar() {
        return radioReprogramar;
    }


    public void setMostrarRessangre(boolean mostrarRessangre) {
        this.mostrarRessangre = mostrarRessangre;
    }

    public boolean isMostrarRessangre() {
        return mostrarRessangre;
    }

    public void setWmodifica(boolean wmodifica) {
        this.wmodifica = wmodifica;
    }

    public boolean isWmodifica() {
        return wmodifica;
    }

    public void setDtFacturasCirugia(HtmlDataTable dtFacturasCirugia) {
        this.dtFacturasCirugia = dtFacturasCirugia;
    }

    public HtmlDataTable getDtFacturasCirugia() {
        return dtFacturasCirugia;
    }
    
    public void eliminarCirugiaRegistro() {
        Cnconsclin consultaAux = (Cnconsclin)dtFacturasCirugia.getRowData();
        lstExamenesCirugias.remove(consultaAux);

    }

    public String agregarCirugia() {
        // Add event code here...
        return null;
    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setLstCirugiasPendientes(List<Chcirugprogr> lstCirugiasPendientes) {
        this.lstCirugiasPendientes = lstCirugiasPendientes;
    }

    public List<Chcirugprogr> getLstCirugiasPendientes() {
        return lstCirugiasPendientes;
    }

    public void setRenderCambiarCirugia(boolean renderCambiarCirugia) {
        this.renderCambiarCirugia = renderCambiarCirugia;
    }

    public boolean isRenderCambiarCirugia() {
        return renderCambiarCirugia;
    }

    public void setCambiar(String cambiar) {
        this.cambiar = cambiar;
    }

    public String getCambiar() {
        return cambiar;
    }

    public void setCambiar(ValueChangeEvent valueChangeEvent) {
        setCambiar((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void changeCirugia(){
        renderCambiarCirugia = false; 
        
        if(cambiar != null && cambiar.equals("S")){
            renderCambiarCirugia = true; 
        }
    }
}
