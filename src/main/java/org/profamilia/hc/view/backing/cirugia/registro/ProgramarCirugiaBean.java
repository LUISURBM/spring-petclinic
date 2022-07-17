package org.profamilia.hc.view.backing.cirugia.registro;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chconsultori;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.buscador.BuscadorFacturasBean;
import org.profamilia.hc.view.util.FacesUtils;


public class ProgramarCirugiaBean extends BaseBean {


    private Chusuario usuario;

    private int selectedIndex;

    static int ACTIVAR_MODIFICAR_CIRUGIA = 0;

    static int ACTIVAR_BUSCADOR = 1;

    static int ACTIVAR_BUSCADOR_FACTURAS = 2;

    private BigDecimal numerodocumento;

    private String idTipoDocumento;

    private List<Cnconsclin> lstCirugiasFactura;

    private List<Cnconsclin> lstCirugiasSeleccionada;

    private List<Chcirugprogr> lstCirugiasPendientes;
    
    private HtmlDataTable dtFacturasCirugia;

    private HtmlDataTable dtFacturasProgramadas;

    private HtmlDataTable dtCirugiasPendientes;
    
    private Chcirugprogr programacion;

    private List lstSalasCirugia;

    /** Variable que almacena la hora de la consulta seleccionada*/
    private String horaSelect;

    /** Almacena la lista de las horas habiles para una consulta*/
    private List<SelectItem> listHora;

    /** Almacena la lista de los tipo de hemocomponente para sangre*/
    private List<SelectItem> listTipoHemo;

    /** Almacena la lista de las horas habiles para una consulta*/
    private List<SelectItem> listHoraDuracion;

    /** Variable que almacena los minutos de la consulta seleccionada*/
    private String minutoSelect;

    /** Almacena la lista de los minutos habiles para una consulta*/
    private List<SelectItem> lstMinutos;

    /** Almacena la lista de los minutos habiles para una consulta*/
    private List<SelectItem> lstMinutosDuracion;


    /** Almacena lel tiempo de aproximado de la cirugia*/
    private String tiempoSelect;

    /**Almacena la lista de los posibles minutos que se puede demorar la cirugia */
    private List lstDuracion;

    private boolean renderDisponibilidad;

    /** Almacena true si el tipo de estancia es hospitalaria*/
    private boolean esHospitalaria;

    /** Almacena true si el tipo de estancia es hospitalaria*/
    private UIInput mnuAnestesia;

    /** Almacena la lista de los tipos de anestesia  */
    private List lstTipoAnestesia;


    /** Almacena la lista de los tipos de Sedaci�n  */
    private List lstTipoSedacion;

    /**
     * 
     * */
    private List ltsAyudantia;

    /** */
    private boolean mostrarAnestesiologo;

    private boolean mostrarSedacion;

    private List<Cpprofesio> lstAnestesiologosSelect;

    private boolean mostrarProfesionales;
    
    private boolean mostrarRessangre;

    private List<Cpprofesio> lstProfesionalesSelect;

    private UIInput mnuAyudantia;

    private UIInput mnuSangre;

    private UIInput mnuEstancia;

    private UIInput inputDias;

    private UIInput inputUnidades;

    /** Almacena el tipo de estancia */
    private List lstEstancia;

    /** Almacena la lista de opciones 'SI' o 'NO' */
    private List lstOpciones;

    private String anestesiologoSelect;

    private String sedacionSelect;

    private String profesionalSelect;

    private List lstProfesionales;

    private List lstProfesionales2;

    private List lstAnestesiologos;

    private List lstMedicosEspecialistas;

    private HtmlDataTable dtAnestesiologo;

    private HtmlDataTable dtProfesional;

    private String navegationRule;

    private boolean renderFacturas;

    private List<Cnconsclin> lstExamenesCirugias;

    private Date fechaFinal;

    private HtmlDataTable dtServicios;

    private Cnconsclin consultaObject;

    private List<Cnconsclin> lstCirugiasSelect;
    
    private boolean renderResidente;


    public ProgramarCirugiaBean() {
    }

    public void init() {
        lstExamenesCirugias = new ArrayList<Cnconsclin>();
        cargarConsultas();
        lstCirugiasSeleccionada = new ArrayList<Cnconsclin>();
        lstAnestesiologosSelect = new ArrayList<Cpprofesio>();
        lstProfesionalesSelect = new ArrayList<Cpprofesio>();
        programacion = new Chcirugprogr();
        renderResidente = false;


        cargarConsultas();

    }

    public void cargarConsultas() {
        fechaFinal = new Date();
        Calendar fechaIni = Calendar.getInstance();
        fechaIni.add(Calendar.MONTH, -3);
        Date fechaInicial = (Date)fechaIni.getTime().clone();


        if (usuario != null && usuario.getHuslnumero() != null) {
            try {
                lstExamenesCirugias = 
                        this.serviceLocator.getClinicoService().getBuscadorFacturas(usuario, 
                                                                                    fechaInicial, 
                                                                                    fechaFinal);
                lstCirugiasPendientes = this.serviceLocator.getCirugiaService().getCirugiasPendientes(usuario);

            } catch (ModelException e) {
                FacesUtils.addErrorMessage("ERROR:::: " + e.getMessage());
            } catch (Exception ex) {
                FacesUtils.addErrorMessage("ERROR:::: " + ex.getMessage());
            }

            if (lstExamenesCirugias == null || lstExamenesCirugias.isEmpty()) {
                FacesUtils.addErrorMessage(MSG_SIN_DATOS);
            }

        }


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
     * @param usuario
     */
    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return
     */
    public Chusuario getUsuario() {
        return usuario;
    }

    /**
     * @param numerodocumento
     */
    public void setNumerodocumento(BigDecimal numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    /**
     * @return
     */
    public BigDecimal getNumerodocumento() {
        return numerodocumento;
    }

    /**
     * @param idTipoDocumento
     */
    public void setIdTipoDocumento(String idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    /**
     * @return
     */
    public String getIdTipoDocumento() {
        return idTipoDocumento;
    }

    /**
     * @param lstCirugiasFactura
     */
    public void setLstCirugiasFactura(List<Cnconsclin> lstCirugiasFactura) {
        this.lstCirugiasFactura = lstCirugiasFactura;
    }

    /**
     * @return
     */
    public List<Cnconsclin> getLstCirugiasFactura() {
        return lstCirugiasFactura;
    }

    /**
     * @param dtFacturasCirugia
     */
    public void setDtFacturasCirugia(HtmlDataTable dtFacturasCirugia) {
        this.dtFacturasCirugia = dtFacturasCirugia;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtFacturasCirugia() {
        return dtFacturasCirugia;
    }

    /**
     * @param dtCirugiasPendientes
     */
    public void setDtCirugiasPendientes(HtmlDataTable dtCirugiasPendientes) {
        this.dtCirugiasPendientes = dtCirugiasPendientes;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCirugiasPendientes() {
        return dtCirugiasPendientes;
    }


    /**
     * @param lstCirugiasSeleccionada
     */
    public void setLstCirugiasSeleccionada(List<Cnconsclin> lstCirugiasSeleccionada) {
        this.lstCirugiasSeleccionada = lstCirugiasSeleccionada;
    }

    /**
     * @return
     */
    public List<Cnconsclin> getLstCirugiasSeleccionada() {
        return lstCirugiasSeleccionada;
    }

    /**
     * @param dtFacturasProgramadas
     */
    public void setDtFacturasProgramadas(HtmlDataTable dtFacturasProgramadas) {
        this.dtFacturasProgramadas = dtFacturasProgramadas;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtFacturasProgramadas() {
        return dtFacturasProgramadas;
    }


    public void aceptarFactura() {
        consultaObject = (Cnconsclin)this.dtServicios.getRowData();
    }

    public void buscadorDoc() {
        Integer idTipoDoc = null;
        boolean wexito = true;
        if (idTipoDocumento != null && !idTipoDocumento.equals("")) {
            idTipoDoc = Integer.parseInt(idTipoDocumento);
        }


        if (idTipoDocumento == null || idTipoDocumento.equals("")) {
            FacesUtils.addErrorMessage("body:formProgramarCirugia:panelTabProgramarCirugia:mnuTipDoc", 
                                       MSG_CAMPO_OBLIGATORIO);
            wexito = false;
        }

        if (numerodocumento == null) {
            FacesUtils.addErrorMessage("body:formProgramarCirugia:panelTabProgramarCirugia:itNumDoc", 
                                       MSG_CAMPO_OBLIGATORIO);
            wexito = false;
        }


        if (wexito) {
            try {
                lstExamenesCirugias = 
                        this.serviceLocator.getCirugiaService().getConsultasCirugia(idTipoDoc, 
                                                                                    numerodocumento, 
                                                                                    usuario);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstExamenesCirugias == null || lstExamenesCirugias.isEmpty()) {
                FacesUtils.addErrorMessage(MSG_CIRUGIA_NO_EXISTE);
            }

        }


    }

    public void eliminarCirugiaRegistro() {
        Cnconsclin consultaAux = (Cnconsclin)dtFacturasCirugia.getRowData();
        lstExamenesCirugias.remove(consultaAux);

    }

    public void agregarCirugia() {

        boolean wexiste = false;


        if (lstExamenesCirugias != null && !lstExamenesCirugias.isEmpty()) {
            lstCirugiasSelect = new ArrayList<Cnconsclin>();
            for (Cnconsclin consultaAux: lstExamenesCirugias) {
                if (consultaAux.isSeleccionado()) {
                    lstCirugiasSeleccionada.add(consultaAux);
                }
            }
        }
        if (!wexiste) {


            for (Cnconsclin consultaAux: lstCirugiasSeleccionada) {
                if (consultaAux.isSeleccionado()) {
                    if (consultaAux.getCcocservic().getCsvccodigo().equals("S662200.0") || 
                        consultaAux.getCcocservic().getCsvccodigo().equals("S662200") || 
                        consultaAux.getCcocservic().getCsvccodigo().equals("S662202") || 
                        consultaAux.getCcocservic().getCsvccodigo().equals("662202") || 
                        consultaAux.getCcocservic().getCsvccodigo().equals("662200.0")) {
                        programacion.setHcpctipoaneste("2");
                        if (programacion.getHcpctipoaneste().equals("2")) {
                            mostrarAnestesiologo = true;
                        } else if (programacion.getHcpctipoaneste().equals("5")) {
                            mostrarSedacion = true;
                            mostrarAnestesiologo = true;
                        }
                        programacion.setHcpctipoaneste("2");
                        programacion.setHcpctipoayudan("N");
                        programacion.setHcpcressangre("N");
                        programacion.setHcpctipoestanc("N");
                    } else if (consultaAux.getCcocservic().getCsvccodigo().equals("S637300") || 
                               consultaAux.getCcocservic().getCsvccodigo().equals("637300")) {
                        programacion.setHcpctipoaneste("6");
                        programacion.setHcpctipoayudan("N");
                        programacion.setHcpcressangre("N");
                        programacion.setHcpctipoestanc("N");
                    }
                }
            }

        } else {
            FacesUtils.addErrorMessage(MSG_CIRUGIA_EXISTE);
        }
        lstExamenesCirugias.clear();
        
    }


    public void eliminarCirugia() {
        Cnconsclin consultaAux = 
            (Cnconsclin)dtFacturasProgramadas.getRowData();
        lstCirugiasSeleccionada.remove(consultaAux);

    }

    /**
     * @param valueChangeEvent
     */
    public void setHcpctipoaneste(ValueChangeEvent valueChangeEvent) {
        programacion.setHcpctipoaneste((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setProfesionalSelect(ValueChangeEvent valueChangeEvent) {
        setProfesionalSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    


    /**
     * @param valueChangeEvent
     */
    public void setHcpctipoayudan(ValueChangeEvent valueChangeEvent) {
        programacion.setHcpctipoayudan((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHcpcressangre(ValueChangeEvent valueChangeEvent) {
        programacion.setHcpcressangre((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setEstanciaSelect(ValueChangeEvent valueChangeEvent) {
        programacion.setHcpctipoestanc((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setProgramacion(Chcirugprogr programacion) {
        this.programacion = programacion;
    }

    public Chcirugprogr getProgramacion() {
        return programacion;
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

            if (lstSalasAux != null && !lstSalasAux.isEmpty()) {

                lstSalasCirugia.add(new SelectItem("", "Seleccione ...."));
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

    public void setHoraSelect(String horaSelect) {
        this.horaSelect = horaSelect;
    }

    public String getHoraSelect() {
        return horaSelect;
    }

    public void setListHora(List<SelectItem> listHora) {
        this.listHora = listHora;
    }

    /**
     * @return
     */
    public List<SelectItem> getListHora() {
        if (listHora == null || listHora.isEmpty()) {
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

    public void setMinutoSelect(String minutoSelect) {
        this.minutoSelect = minutoSelect;
    }

    public String getMinutoSelect() {
        return minutoSelect;
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
        if (lstMinutos == null || !lstMinutos.isEmpty()) {
            lstMinutos = new ArrayList<SelectItem>();
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

    public void setTiempoSelect(String tiempoSelect) {
        this.tiempoSelect = tiempoSelect;
    }

    public String getTiempoSelect() {
        return tiempoSelect;
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
     * @param lstDuracion
     */
    public void setLstDuracion(List lstDuracion) {
        this.lstDuracion = lstDuracion;
    }

    /**
     * @return
     */
    public List getLstDuracion() {

        if (lstDuracion == null || lstDuracion.isEmpty()) {
            lstDuracion = new ArrayList();
            lstDuracion.add(new SelectItem("00", "00"));
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

    public void mostrarBuscador() {
        FacesUtils.resetManagedBean("buscadorDisponibilidadSalaBean");
        selectedIndex = ACTIVAR_BUSCADOR;
        renderDisponibilidad = true;
        renderFacturas = false;
    }


    public void mostrarBuscadorFacturas() {
        FacesUtils.resetManagedBean("buscadorFacturasBean");
        BuscadorFacturasBean buscador = 
            (BuscadorFacturasBean)FacesUtils.getManagedBean("buscadorFacturasBean");
        buscador.setUsuario(usuario);
        selectedIndex = ACTIVAR_BUSCADOR_FACTURAS;
        renderDisponibilidad = false;
        renderFacturas = true;
    }

    public void setEsHospitalaria(boolean esHospitalaria) {
        this.esHospitalaria = esHospitalaria;
    }

    public boolean isEsHospitalaria() {
        return esHospitalaria;
    }

    public void setMnuAnestesia(UIInput mnuAnestesia) {
        this.mnuAnestesia = mnuAnestesia;
    }

    public UIInput getMnuAnestesia() {
        return mnuAnestesia;
    }

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
            //por revisar
            lstTipoAnestesia.add(new SelectItem("8", "Sin Anestesia"));


        }
        return lstTipoAnestesia;
    }

    public void changeAnestesia() {
        if (programacion != null && programacion.getHcpctipoaneste() != null && 
            programacion.getHcpctipoaneste().equals("2")) {
            mostrarAnestesiologo = true;
            mostrarSedacion = false;
        } else if (programacion != null && 
                   programacion.getHcpctipoaneste() != null && 
                   programacion.getHcpctipoaneste().equals("4")) {
            mostrarAnestesiologo = true;
            mostrarSedacion = false;
        } else if (programacion != null && 
                   programacion.getHcpctipoaneste() != null && 
                   programacion.getHcpctipoaneste().equals("5")) {
            mostrarSedacion = true;
            mostrarAnestesiologo = true;


        }
         else if (programacion != null && 
                   programacion.getHcpctipoaneste() != null && 
                   programacion.getHcpctipoaneste().equals("7")) {
            mostrarSedacion = false;
            mostrarAnestesiologo = true;
        }
        else {
            mostrarAnestesiologo = false;
            mostrarSedacion = false;
            lstAnestesiologosSelect = new ArrayList<Cpprofesio>();
        }
    }

    public void changeRessangre() {
        if (programacion != null && programacion.getHcpcressangre() != null && 
            programacion.getHcpcressangre().equals("S")) {
            mostrarRessangre = true;
        } else {
            mostrarRessangre = false;
            programacion.setHcpctipohemoco(null);
            programacion.setHcpnnumerounid(null);
        }
    }
    
    
    public void changeProfesional() {
       if(profesionalSelect != null){
          
       }
    }
    
    
    
    
    
    
    /** */
    public void setMnuAyudantia(UIInput mnuAyudantia) {
        this.mnuAyudantia = mnuAyudantia;
    }

    public UIInput getMnuAyudantia() {
        return mnuAyudantia;
    }

    /** */
    public void setMnuSangre(UIInput mnuSangre) {
        this.mnuSangre = mnuSangre;
    }

    public UIInput getMnuSangre() {
        return mnuSangre;
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
        if (programacion != null && programacion.getHcpctipoayudan() != null && 
            programacion.getHcpctipoayudan().equals("S")) {
            mostrarProfesionales = true;
        } else {
            mostrarProfesionales = false;
            lstProfesionalesSelect = new ArrayList<Cpprofesio>();
        }
    }

    public void changeSangre() {
        if (programacion != null && programacion.getHcpcressangre() != null && 
            programacion.getHcpcressangre().equals("S")) {
            mostrarRessangre = true;
        } else {
            mostrarRessangre = false;
        }
    }

    public void setMostrarAnestesiologo(boolean mostrarAnestesiologo) {
        this.mostrarAnestesiologo = mostrarAnestesiologo;
    }

    public boolean isMostrarAnestesiologo() {
        return mostrarAnestesiologo;
    }

    public void setLstAnestesiologosSelect(List<Cpprofesio> lstAnestesiologosSelect) {
        this.lstAnestesiologosSelect = lstAnestesiologosSelect;
    }

    public List<Cpprofesio> getLstAnestesiologosSelect() {
        return lstAnestesiologosSelect;
    }

    public void setLstProfesionalesSelect(List<Cpprofesio> lstProfesionalesSelect) {
        this.lstProfesionalesSelect = lstProfesionalesSelect;
    }

    public List<Cpprofesio> getLstProfesionalesSelect() {
        return lstProfesionalesSelect;
    }


    /**
     * @param lstAnestesiologos
     */
    public void setLstAnestesiologos(List lstAnestesiologos) {
        this.lstAnestesiologos = lstAnestesiologos;
    }

    /**
     * @return
     */
    public List getLstAnestesiologos() {
        if (lstAnestesiologos == null || lstAnestesiologos.isEmpty()) {
            lstAnestesiologos = new ArrayList();
            ArrayList<Cpprofesio> listProfesionalesAux = null;
            try {
                listProfesionalesAux = 
                        (ArrayList<Cpprofesio>)this.serviceLocator.getClinicoService().getListaAnestesiologoClinica(getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (listProfesionalesAux != null && 
                !listProfesionalesAux.isEmpty()) {

                Iterator it = listProfesionalesAux.iterator();
                int i = 0;
                lstAnestesiologos.add(new SelectItem("", 
                                                     "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstAnestesiologos.add(new SelectItem(listProfesionalesAux.get(i).getId().getCpfncodigo().toString(), 
                                                         listProfesionalesAux.get(i).getCpfcnombre()));
                    i++;
                }
            }
        }

        return lstAnestesiologos;
    }

    public void setMnuEstancia(UIInput mnuEstancia) {
        this.mnuEstancia = mnuEstancia;
    }

    public UIInput getMnuEstancia() {
        return mnuEstancia;
    }

    public void setInputDias(UIInput inputDias) {
        this.inputDias = inputDias;
    }

    public UIInput getInputDias() {
        return inputDias;
    }

    public void setInputUnidades(UIInput inputUnidades) {
        this.inputUnidades = inputUnidades;
    }

    public UIInput getInputUnidades() {
        return inputUnidades;
    }

    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    public List getLstOpciones() {
        if (lstOpciones == null || lstOpciones.isEmpty()) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
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
        if (lstEstancia == null || lstEstancia.isEmpty()) {
            lstEstancia = new ArrayList();
            lstEstancia.add(new SelectItem("S", "Si"));
            lstEstancia.add(new SelectItem("N", "No"));
        }
        return lstEstancia;
    }

    /*    public void changeEstancia() {
           if (programacion != null && programacion.getHcpctipoestanc() != null &&
               programacion.getHcpctipoestanc().equals("H")) {
               esHospitalaria = true;
           } else {
               esHospitalaria = false;
           }
       }*/

    public void volver() {
        FacesUtils.resetManagedBean("buscadorDisponibilidadSalaBean");
        selectedIndex = ACTIVAR_MODIFICAR_CIRUGIA;
        renderDisponibilidad = false;
        renderFacturas = false;
    }

    public void aceptarFacturas() {
        BuscadorFacturasBean buscador = 
            (BuscadorFacturasBean)FacesUtils.getManagedBean("buscadorFacturasBean");
        Cnconsclin consultaObject = buscador.getConsultaObject();

        try {
            if (consultaObject != null && 
                consultaObject.getCcontipdoc() != null && 
                consultaObject.getCcontipdoc().getCtdnnumero() != null && 
                consultaObject.getCconnumdoc() != null)
                lstCirugiasFactura = 
                        this.serviceLocator.getCirugiaService().getConsultasCirugia(consultaObject.getCcontipdoc().getCtdnnumero(), 
                                                                                    consultaObject.getCconnumdoc(), 
                                                                                    usuario);
        } catch (ModelException e) {
            e.printStackTrace();
        }

        selectedIndex = ACTIVAR_MODIFICAR_CIRUGIA;
        renderDisponibilidad = false;
        renderFacturas = false;
    }

    public void setAnestesiologoSelect(String anestesiologoSelect) {
        this.anestesiologoSelect = anestesiologoSelect;
    }

    public String getAnestesiologoSelect() {
        return anestesiologoSelect;
    }

    public void setProfesionalSelect(String profesionalSelect) {
        this.profesionalSelect = profesionalSelect;
    }

    public String getProfesionalSelect() {
        return profesionalSelect;
    }

    /**
     * @param renderFacturas
     */
    public void setRenderFacturas(boolean renderFacturas) {
        this.renderFacturas = renderFacturas;
    }

    /**
     * @return
     */
    public boolean isRenderFacturas() {
        return renderFacturas;
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


    /**
     * @return
     */
    public List getLstProfesionales2() {
        if (lstProfesionales2 == null || lstProfesionales2.isEmpty()) {
            lstProfesionales2 = new ArrayList();
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
                lstProfesionales2.add(new SelectItem("", 
                                                     "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstProfesionales2.add(new SelectItem(listProfesionalesAux.get(i).getId().getCpfncodigo(), 
                                                         listProfesionalesAux.get(i).getCpfcnombre()));
                    i++;
                }
            }
        }

        return lstProfesionales2;
    }


    public void setNavegationRule(String navegationRule) {
        this.navegationRule = navegationRule;
    }

    public String getNavegationRule() {
        return navegationRule;
    }

    public void setLstMedicosEspecialistas(List lstMedicosEspecialistas) {
        this.lstMedicosEspecialistas = lstMedicosEspecialistas;
    }

    public List getLstMedicosEspecialistas() {
        if (lstMedicosEspecialistas == null || 
            lstMedicosEspecialistas.isEmpty()) {
            lstMedicosEspecialistas = new ArrayList();
            ArrayList<Cpprofesio> listMedicosAux = null;
            try {
                listMedicosAux = 
                        (ArrayList<Cpprofesio>)this.serviceLocator.getClinicoService().getListaEspecialistasClinica(getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listMedicosAux.isEmpty()) {

                Iterator it = listMedicosAux.iterator();
                int i = 0;
                lstMedicosEspecialistas.add(new SelectItem("", 
                                                           "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstMedicosEspecialistas.add(new SelectItem(listMedicosAux.get(i).getId().getCpfncodigo(), 
                                                               listMedicosAux.get(i).getCpfcnombre()));
                    i++;
                }
            }
        }

        return lstMedicosEspecialistas;
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
                    int res;
                    BigDecimal compare = new BigDecimal(0);
                    res = profeObject.getCpfncodigo().compareTo(compare);
                        if(res == 0){
                           renderResidente = true;
                        }else{
                            renderResidente = false;
                        }
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

    public void eliminarAnestesiologo() {
        Cpprofesio anestesiologoDelete = null;
        anestesiologoDelete = (Cpprofesio)dtAnestesiologo.getRowData();
        lstAnestesiologosSelect.remove(anestesiologoDelete);
    }


    public void setDtAnestesiologo(HtmlDataTable dtAnestesiologo) {
        this.dtAnestesiologo = dtAnestesiologo;
    }

    public HtmlDataTable getDtAnestesiologo() {
        return dtAnestesiologo;
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

    public void inicializarBean() {
        idTipoDocumento = "";
        numerodocumento = null;
    }


    /**
     * @return
     */
    public String programarCirugia() {
        boolean wexito = true;
        navegationRule = "";


        if (programacion == null || programacion.getHcpnsalainterv() == null) {
            FacesUtils.addErrorMessage("body:formProgramarCirugia:panelTabProgramarCirugia:mnuSala", 
                                       MSG_CAMPO_OBLIGATORIO);
            wexito = false;
        }

        if (programacion == null || programacion.getHcpdfechacirug() == null) {
            FacesUtils.addErrorMessage("body:formProgramarCirugia:panelTabProgramarCirugia:fechaCirugia", 
                                       MSG_CAMPO_OBLIGATORIO);
            wexito = false;
        }


        if (horaSelect == null || horaSelect.equals("")) {
            FacesUtils.addErrorMessage("body:formProgramarCirugia:panelTabProgramarCirugia:mnuHoraCirugia1", 
                                       MSG_CAMPO_OBLIGATORIO);
            wexito = false;
        }


        if (minutoSelect == null || minutoSelect.equals("")) {
            FacesUtils.addErrorMessage("body:formProgramarCirugia:panelTabProgramarCirugia:mnuMinutosCirugia1", 
                                       MSG_CAMPO_OBLIGATORIO);
            wexito = false;
        }

        /*    if (tiempoSelect == null || tiempoSelect.equals("")) {
                FacesUtils.addErrorMessage("body:formProgramarCirugia:panelTabProgramarCirugia:mnuTiempo",
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }*/


        if (programacion == null || programacion.getHcpctipoaneste() == null) {
            FacesUtils.addErrorMessage("body:formProgramarCirugia:panelTabProgramarCirugia:mnuAnestesia", 
                                       MSG_CAMPO_OBLIGATORIO);
            wexito = false;
        }

        if (programacion == null || programacion.getHcpcressangre() == null) {
            FacesUtils.addErrorMessage("body:formProgramarCirugia:panelTabProgramarCirugia:mnuSangre", 
                                       MSG_CAMPO_OBLIGATORIO);
            wexito = false;
        }

        /**if (programacion == null || programacion.getHcpeayudantia() == null || programacion.getHcpeayudantia().equals("") ) {
                FacesUtils.addErrorMessage("body:formProgramarCirugia:panelTabProgramarCirugia:mnuAyudantia",
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }*/

        if (programacion == null || programacion.getHcpctipoestanc() == null || 
            programacion.getHcpctipoestanc().equals("")) {
            FacesUtils.addErrorMessage("body:formProgramarCirugia:panelTabProgramarCirugia:mnuEstancia", 
                                       MSG_CAMPO_OBLIGATORIO);
            wexito = false;
        }


        if (programacion != null && programacion.getHcpctipoestanc() != null && 
            programacion.getHcpctipoestanc().equals("H")) {
            if (programacion == null || 
                programacion.getHcpndiasestanc() == null) {
                FacesUtils.addErrorMessage("body:formProgramarCirugia:panelTabProgramarCirugia:itDiasEstancia", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
        }

        if (programacion != null && programacion.getHcpctipoaneste() != null && 
            (programacion.getHcpctipoaneste().equals("2") || programacion.getHcpctipoaneste().equals("5"))) {
            if (lstAnestesiologosSelect == null || 
                lstAnestesiologosSelect.isEmpty()) {
                FacesUtils.addErrorMessage("body:formProgramarCirugia:panelTabProgramarCirugia:mnuAnestesiologos", 
                                           MSG_ANESTESIOLOGO_OBLIGATORIO);
                wexito = false;
            }

            if (programacion != null && 
                programacion.getHcpctipoayudan() != null && 
                programacion.getHcpctipoayudan().equals("S")) {
                if (lstProfesionalesSelect == null || 
                    lstProfesionalesSelect.isEmpty()) {
                    FacesUtils.addErrorMessage("body:formProgramarCirugia:panelTabProgramarCirugia:mnuProfesionales", 
                                               MSG_ANESTESIOLOGO_OBLIGATORIO);
                    wexito = false;
                }
            }
        }

        tiempoSelect = "10";


        if (programacion.getHcpctipoaneste() != null && 
            (programacion.getHcpctipoaneste().equals("2")|| programacion.getHcpctipoaneste().equals("4") || programacion.getHcpctipoaneste().equals("5")|| programacion.getHcpctipoaneste().equals("7"))) {
            if (lstAnestesiologosSelect != null && !lstAnestesiologosSelect.isEmpty()) {
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
                    programacion.setHcpcanestesiol(codigosAneste);
                }
            } else {
                FacesUtils.addErrorMessage("body:formProgramarCirugia:panelTabProgramarCirugia:mnuAnestesiologos", 
                                           MSG_VALIDACION_REQUERIDO);
                wexito = false;
            }
        }
        if (programacion.getHcpctipoayudan() != null && 
            programacion.getHcpctipoayudan().equals("S")) {
            if (lstProfesionalesSelect != null && 
                !lstProfesionalesSelect.isEmpty()) {
                String codigosProfes = "";
                String nombreResidente = "";
                Cpprofesio profAux;
                profAux = null;
                Iterator it = lstProfesionalesSelect.iterator();
                while (it.hasNext()) {
                    profAux = (Cpprofesio)it.next();
                    if (profAux != null) {
                        codigosProfes = 
                                codigosProfes + profAux.getId().getCpfncodigo() + 
                                ",";
                        if(profAux.getId().getCpfncodigo().equals(new BigDecimal(0))){
                            nombreResidente = nombreResidente + profAux.getNombreResidente() +
                            ",";
                        }
                    }
                }
                codigosProfes = 
                        codigosProfes.substring(0, codigosProfes.length() - 1);
                if (codigosProfes != null) {
                    programacion.setHcpcprofeayuda(codigosProfes);
                }if(nombreResidente != null){
                    programacion.setHcpcnomresiden(nombreResidente);
                
                }else {
                    FacesUtils.addErrorMessage("body:formProgramarCirugia:panelTabProgramarCirugia:mnuProfesionales", 
                                               MSG_VALIDACION_REQUERIDO);
                    wexito = false;
                }
            }

        }

        if (wexito) {
            programacion.setHcpcestado(ESTADO_VIGENTE);
            programacion.setHcpcoperador(userName());
            programacion.setHcpdfecregistr(new Date());
            programacion.setHcpcingreenfer("N");
            programacion.setHcpcingremedic("N");
            programacion.setHcpcsalidenfer("N");
            programacion.setHcpcsalidmedic("N");
            programacion.setHcpnclinica(getClinica().getCclncodigo());
            if (tiempoSelect != null) {
                programacion.setHcpntiempointe(new Integer(tiempoSelect));
            }
            if (minutoSelect != null) {
                programacion.setHcpcminutdurac(minutoSelect);
                ;
            }
            if (horaSelect != null) {
                programacion.setHcpchoradurac(horaSelect);
            }
            if (sedacionSelect != null) {
                programacion.setHcpctiposedacio(sedacionSelect);
            }

            programacion.setHcplusuario(usuario);
            programacion.setHcpcentidadadm(usuario.getHuscentidadadm());

            if (programacion.getHcpdfechacirug() != null && 
                programacion.getHcpntiempointe() != null && 
                horaSelect != null && !horaSelect.equals("") && 
                minutoSelect != null && !minutoSelect.equals("")) {
                Calendar fechaapx1 = Calendar.getInstance();
                fechaapx1.setTime(programacion.getHcpdfechacirug());
                fechaapx1.set(Calendar.HOUR_OF_DAY, new Integer(horaSelect));
                fechaapx1.set(Calendar.MINUTE, new Integer(minutoSelect));
                programacion.setHcpdfechacirug(fechaapx1.getTime());
                programacion.setHcpcetapa(ETAPA_ESPERA);

                fechaapx1.add(Calendar.MINUTE, 
                              programacion.getHcpntiempointe());
                programacion.setHcpdfechfincir(fechaapx1.getTime());
            }

        }


        if (wexito) {


            try {
                wexito = 
                        serviceLocator.getCirugiaService().verificarDisponibilidadSala(getClinica().getCclncodigo(), 
                                                                                       programacion.getHcpnsalainterv(), 
                                                                                       programacion.getHcpdfechacirug(), 
                                                                                       programacion.getHcpntiempointe(), 
                                                                                       programacion.getHcplnumero());
            } catch (ModelException e) {
                wexito = false;
                FacesUtils.addErrorMessage(e.getMessage());
                e.printStackTrace();
            }

            if (!wexito) {
                FacesUtils.addErrorMessage("No hay Disponibilidad en la sala seleccionada, por favor intente nuevamente");
            }
        }


        if (wexito) {
            try {
                this.serviceLocator.getCirugiaService().saveProgramarCirugia(programacion, 
                                                                             lstCirugiasSeleccionada, 
                                                                             userName(), 
                                                                             usuario);
                FacesUtils.addInfoMessage(MSG_ADICION);
                FacesUtils.resetManagedBean("programarCirugiaBean");
                FacesUtils.resetManagedBean("consultarCirugiasProgramarBean");
                navegationRule = 
                        BeanNavegacion.RUTA_IR_CONSULTAR_USUARIO_PROGRAMACION_CIRUGIA;
            } catch (ModelException e) {
                navegationRule = "";
                FacesUtils.addErrorMessage(MSG_NO_ADICION + ":  " + 
                                           e.getMessage());

            } catch (Exception e1) {
                navegationRule = "";
                FacesUtils.addErrorMessage(MSG_NO_ADICION + e1.getMessage());

            }
        }


        return navegationRule;

    }


    public void setMostrarProfesionales(boolean mostrarProfesionales) {
        this.mostrarProfesionales = mostrarProfesionales;
    }

    public boolean isMostrarProfesionales() {
        return mostrarProfesionales;
    }

    public void setMostrarRessangre(boolean mostrarRessangre) {
        this.mostrarRessangre = mostrarRessangre;
    }

    public boolean isMostrarRessangre() {
        return mostrarRessangre;
    }

    public void setLstProfesionales2(List lstProfesionales2) {
        this.lstProfesionales2 = lstProfesionales2;
    }

    public List get_lstProfesionales2() {
        return lstProfesionales2;
    }

    public void setDtServicios(HtmlDataTable dtServicios) {
        this.dtServicios = dtServicios;
    }

    public HtmlDataTable getDtServicios() {
        return dtServicios;
    }

    public void setLstExamenesCirugias(List<Cnconsclin> lstExamenesCirugias) {
        this.lstExamenesCirugias = lstExamenesCirugias;
    }

    public List<Cnconsclin> getLstExamenesCirugias() {
        return lstExamenesCirugias;
    }

    public void setConsultaObject(Cnconsclin consultaObject) {
        this.consultaObject = consultaObject;
    }

    public Cnconsclin getConsultaObject() {
        return consultaObject;
    }

    public void setListHoraDuracion(List<SelectItem> listHoraDuracion) {
        this.listHoraDuracion = listHoraDuracion;
    }

    public List<SelectItem> getListHoraDuracion() {
        if (listHoraDuracion == null || listHoraDuracion.isEmpty()) {
            listHoraDuracion = new ArrayList<SelectItem>();
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

    public void setLstMinutosDuracion(List<SelectItem> lstMinutosDuracion) {
        this.lstMinutosDuracion = lstMinutosDuracion;
    }

    public List<SelectItem> getLstMinutosDuracion() {
        return lstMinutosDuracion;
    }

    public void setMostrarSedacion(boolean mostrarSedacion) {
        this.mostrarSedacion = mostrarSedacion;
    }

    public boolean isMostrarSedacion() {
        return mostrarSedacion;
    }

    public void setLstTipoSedacion(List lstTipoSedacion) {
        this.lstTipoSedacion = lstTipoSedacion;
    }

    public List getLstTipoSedacion() {
        if (lstTipoSedacion == null || lstTipoSedacion.isEmpty()) {
            lstTipoSedacion = new ArrayList();
            lstTipoSedacion.add(new SelectItem("", "Seleccione .."));
            lstTipoSedacion.add(new SelectItem("1", "Ansiol�sis"));
            lstTipoSedacion.add(new SelectItem("2", "Sedaci�n Consciente"));
            lstTipoSedacion.add(new SelectItem("3", 
                                               "Sedaci�n Profunda/Analgesica"));


        }
        return lstTipoSedacion;
    }


    public void setSedacionSelect(String sedacionSelect) {
        this.sedacionSelect = sedacionSelect;
    }

    public String getSedacionSelect() {
        return sedacionSelect;
    }

    public void setLstCirugiasSelect(List<Cnconsclin> lstCirugiasSelect) {
        this.lstCirugiasSelect = lstCirugiasSelect;
    }

    public List<Cnconsclin> getLstCirugiasSelect() {
        return lstCirugiasSelect;
    }

    public void setRenderResidente(boolean renderResidente) {
        this.renderResidente = renderResidente;
    }

    public boolean isRenderResidente() {
        return renderResidente;
    }


    public void setLstCirugiasPendientes(List<Chcirugprogr> lstCirugiasPendientes) {
        this.lstCirugiasPendientes = lstCirugiasPendientes;
    }

    public List<Chcirugprogr> getLstCirugiasPendientes() {
        return lstCirugiasPendientes;
    }
}


