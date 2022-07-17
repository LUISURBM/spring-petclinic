    package org.profamilia.hc.view.backing.cirugia.registro;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

import org.profamilia.hc.model.dto.Chaldrete;
import org.profamilia.hc.model.dto.Chcalibcatet;
import org.profamilia.hc.model.dto.Chcanalivena;
import org.profamilia.hc.model.dto.ChcanalivenaPK;
import org.profamilia.hc.model.dto.Chciruganula;
import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chcontmedane;
import org.profamilia.hc.model.dto.Chcontrmedic;
import org.profamilia.hc.model.dto.Chcontroliqu;
import org.profamilia.hc.model.dto.Chcontroorden;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chformulaliq;
import org.profamilia.hc.model.dto.Chingresoenf;
import org.profamilia.hc.model.dto.Chliquiparen;
import org.profamilia.hc.model.dto.Chnotaenferm;
import org.profamilia.hc.model.dto.ChnotaenfermPK;
import org.profamilia.hc.model.dto.Chrefepaci;
import org.profamilia.hc.model.dto.ChrefepaciPK;
import org.profamilia.hc.model.dto.Chregicirpro;
import org.profamilia.hc.model.dto.Chsignovital;
import org.profamilia.hc.model.dto.ChsignovitalPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.comun.AdicionarCirugiaBean;
import org.profamilia.hc.view.backing.cirugia.comun.MantenimientoCirugiasBean;
import org.profamilia.hc.view.backing.cirugia.resumen.GenerarFoliosCirugiaBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorPlantillaCirugiaBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperRunManager;


public class RegistrarNotaEnfermeriaBean extends BaseBean implements JRDataSource {

    private Chnotaenferm nota;

    private Chcirugprogr cirugia;

    private Chdetacirpro detalleCirugia;

    private Chingresoenf ingreso;

    private UIInput itDescripcion;

    private boolean esIngreso;

    private List lstCirugias;

    private List lstEscala;

    private HtmlDataTable dtCirugias;

    private String menuBean;

    private boolean esFebril;

    private List lstTemperatura;

    private boolean esSalida;

    private String labelText;

    private boolean esHospitalizacion;

    private boolean mostrarHoraActual;

    private String esHoraActual;

    private List lstOpciones;

    private Date fechaAdministracion;

    // Canalizacion de la vena

    private Chcanalivena canalizacion;

    private boolean mostrarCanalizacion;

    private boolean mostrarAsepsia;

    private boolean mostrarCalibre;

    private List lstMiembroSuperior;

    private List lstLocalizacion;

    private List lstTipoCateter;

    private List<Chcanalivena> lstCanalizacionSelect;

    private HtmlDataTable dtCanalizacion;

    private List<Chcanalivena> lstHistorialCanalizacion;

    private List<Chcanalivena> lstCanalizacionSuspender;

    private HtmlDataTable dtHistorialCanalizacion;

    private Integer tiempoAdministracion;

    private boolean renderPlantilla;

    private Integer selectedIndex;

    static final int ACTIVAR_APLICACION = 0;

    static final int ACTIVAR_BUSCADOR_PLANTILLAS = 1;

    private int index;

    private boolean generoReporte;

    private String navegationRule;

    private String nextAction;

    /** Lista de Calibres Cateter */
    private List listCalibre;

    private String desAldrobrom;

    private String salePreoperatorio;

    private String saleTransoperatoria;

    private String salePostoperatorio;

    private String etapaActual;

    private String wreporte;

    /** Matrix object. */
    private ArrayList registros;

    private Cpservicio servicio;

    /** Render Cancelacion de Cirugia */
    private boolean renderCancelar;

    /** Render Dolor Cirugia*/
    private boolean renderDolor;

    private String radioCancelar;

    private String radioDolor;

    private Chregicirpro regicipro;

    private Chciruganula ciruanula;

    /** Render Cancelacion de Cirugia */
    private boolean renderNuevoRegistro;

    private List<Chdetacirpro> lstCirugiasProgramadas;

    MantenimientoCirugiasBean mantenimiento;

    Chusuario usuario;

    private String msgNotaEnfermeriaTransoperatoria;

    private String msgNotaEnfermeriaAnestesia;

    private String msgNotaEnfermeriaDescripcion;

    private boolean renderTieneDIU;

    private boolean renderMensajeTieneDIU;

    private boolean renderPruebaEmbarazo;

    private Date fechaEmbarazo;

    private String hiecresulpruemb;

    private boolean renderLigadura;

    private List lstOpcionesEmbarazo;

    /** Lista que almacena la lista escala de dolor */
    private List<SelectItem> listEscala;
    
    private String tipoServicio;
    
    private boolean notaEnfeProce;
    
    private String legendServicio;
    
    private List<Cnconsclin> lstConsclin;
    
    private String legendTablaServicio;
    
    private List<Chcontroorden> lstcontrolOrden;
    
    /*Reporte oxigeno*/
    
    private String HORAINICIOOXIGENO;
    private String SISTEMAOXIGENO;
    private String LITROSOXIGENO;
    private String MINUTOOXIGENO;
    private String HORATERMINACIONOXIGENO;
    
    private Chrefepaci referenciaPaciente;
    
    private boolean renderReferencia;
    
    /** Almacena la lista de las horas habiles para una consulta*/
    private List<SelectItem> listHora;
    
    /** Almacena la lista de los minutos habiles para una consulta*/
    private List<SelectItem> lstMinutos;
    
    private List<SelectItem> listTipoAmbulancia;
    
    
    public RegistrarNotaEnfermeriaBean() {
    }

    public void init() {
        radioCancelar = "N";
        radioDolor = "N";
        renderNuevoRegistro = false;
        wreporte = "";
        selectedIndex = 0;
        setGeneroReporte(false);
        renderTieneDIU = true;
        renderMensajeTieneDIU = false;
        renderLigadura = false;
        lstCirugias = new ArrayList();
        dtCirugias = new HtmlDataTable();
        mostrarCanalizacion = false;
        canalizacion = new Chcanalivena();
        lstCanalizacionSelect = new ArrayList<Chcanalivena>();
        lstCanalizacionSuspender = new ArrayList<Chcanalivena>();
        usuario = new Chusuario();
        lstcontrolOrden= new ArrayList<Chcontroorden>();
        inicializarNotaEnfermeria();
    }

    public void inicializarNotaEnfermeria() {
        Integer numeroCama = null;
        
        renderReferencia = false;
        legendServicio="Cirugia(s) Programada(s)";
        
        legendTablaServicio ="Intervenci�n(es)";


        renderPruebaEmbarazo = false;
        canalizacion.setHcvecanalizaci("N");
        if (canalizacion.getHcvecanalizaci() != null && canalizacion.getHcvecanalizaci().equals("S")) {
            mostrarCanalizacion = true;
        }
        canalizacion.setHcvctipocatete("C");
        if (canalizacion.getHcvctipocatete()!= null && canalizacion.getHcvctipocatete().equals("C")) {
            mostrarCalibre = true;
        }
        canalizacion.setHcvncalibre(20);
        canalizacion.setHcvczonacanali("D");

        if (esSalida) {
            labelText = "Salida Enfermeria";
        } else {
            labelText = "Nota Enfermeria";
        }

        if (cirugia != null && esIngreso) {
            renderPruebaEmbarazo = false;

            try {
                detalleCirugia = 
                        this.serviceLocator.getCirugiaService().getServicioDetalle(cirugia.getHcplnumero());
                if (detalleCirugia != null && detalleCirugia.getId() != null && 
                    detalleCirugia.getId().getHdccservicio() != null) {
                    servicio = 
                            this.serviceLocator.getClinicoService().getServicioPorId(detalleCirugia.getId().getHdccservicio());
                    if (servicio != null && 
                        (servicio.getCsvntiphis() == 20 || servicio.getCsvntiphis() == 
                         31 || servicio.getCsvntiphis() == 44)) {
                        renderTieneDIU = false;
                    }
                    ingreso = 
                            this.serviceLocator.getClinicoService().getIngresoEnfermeria(cirugia.getHcplnumero());
                    if (ingreso != null && ingreso.getHiectienediu() != null && 
                        ingreso.getHiectienediu().equals("S")) {
                        renderMensajeTieneDIU = true;
                    }
                }
            } catch (ModelException e) {
                e.printStackTrace();
            }
            try {
                lstCirugiasProgramadas = 
                        this.serviceLocator.getClinicoService().getDetalleCirugiasProgramadas(cirugia.getHcplnumero());

            } catch (ModelException e) {
                e.printStackTrace();
            }

            try {
                nota = 
this.serviceLocator.getCirugiaService().getNotaEnfermeriaIngreso(cirugia.getHcplnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (nota != null) {
                try {
                    lstCanalizacionSelect = 
                            this.getServiceLocator().getClinicoService().getIngresoCanalizacion(nota);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }

            /*       if (nota != null) {
                if (nota.getHnedfechanotac() != null) {
                    mostrarHoraActual = true;
                    Calendar fechaaux1 = Calendar.getInstance();
                    fechaaux1.setTime(nota.getHnedfechanotac());
                    Integer hora1;
                    Integer minuto1;
                    hora1 = (fechaaux1.get(Calendar.HOUR_OF_DAY));
                    minuto1 = (fechaaux1.get(Calendar.MINUTE));

                    fechaAdministracion = nota.getHnedfechanotac();
                    esHoraActual = "N";

                } else {
                    mostrarHoraActual = false;
                    esHoraActual = "S";
                }
            }*/

        }

        radioCancelar = "N";
        if (nota == null) {
            nota = new Chnotaenferm();
            radioCancelar = "N";
            nota.setHnecrefiedolor("N");
        }

        if (cirugia != null) {


            try {

                ingreso = 
                        this.serviceLocator.getClinicoService().getIngresoEnfermeria(cirugia.getHcplnumero());
                lstHistorialCanalizacion = 
                        this.serviceLocator.getCirugiaService().getLstCanalizacion(cirugia.getHcplnumero(), 
                                                                                   TIPO_HOSPITALIZACION, 
                                                                                   null);
                etapaActual = 
                        serviceLocator.getCirugiaService().getEtapaNotaEnfermeria(cirugia.getHcplnumero());

                if (lstHistorialCanalizacion != null && 
                    !lstHistorialCanalizacion.isEmpty() && 
                    lstHistorialCanalizacion.size() > 0) {
                    canalizacion.setHcvecanalizaci("N");
                    mostrarCanalizacion = false;
                }

                Chdetacirpro detalleServ = null;
                String wcodser = null;
                Cpservicio servicioPE = null;
                if (cirugia != null && cirugia.getChdetacirpros() != null && 
                    cirugia.getChdetacirpros().size() == 1) {
                    Iterator it = cirugia.getChdetacirpros().iterator();
                    if (it.hasNext()) {
                        detalleServ = (Chdetacirpro)it.next();

                        if (detalleServ != null && 
                            detalleServ.getId() != null && 
                            detalleServ.getId().getHdccservicio() != null) {
                            wcodser = detalleServ.getId().getHdccservicio();
                        }

                        if (wcodser != null && !wcodser.equals("")) {
                            servicioPE = 
                                    this.serviceLocator.getClinicoService().getServicioPorId(wcodser);
                        }

                    }


                    if (servicioPE != null && 
                        servicioPE.getCsvntiphis() != null && 
                        servicioPE.getCsvntiphis().equals(CIRUGIA_LIGADURA_POR_BIPOLAR)) {
                        renderLigadura = true;


                    } else if (servicioPE != null && 
                               servicioPE.getCsvntiphis() != null && 
                               servicioPE.getCsvntiphis().equals(CIRUGIA_IVE)) {

                        renderLigadura = true;

                    } else {
                        renderLigadura = false;

                    }
                }


                if (ingreso != null && ingreso.getHiedfechapremb() == null && 
                    renderLigadura) {
                    renderPruebaEmbarazo = true;
                }
                if(notaEnfeProce){
                    legendServicio="Procedimiento(s)";
                    legendTablaServicio ="Procedimiento(s)"; 
                    try {
                        lstConsclin = 
                                this.serviceLocator.getClinicoService().getConsultaClinica(cirugia.getHcplnumero().longValue());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    // Cargamos los procedimientos
                    if (lstConsclin != null && !lstConsclin.isEmpty()) {
                        Iterator it = lstConsclin.iterator();
                        Cnconsclin conclin;

                        while (it.hasNext()) {
                            conclin = (Cnconsclin)it.next();
                            lstCirugias.add(conclin.getCcocservic());
                        }
                    }
                }

                if (cirugia.getChdetacirpros() != null && 
                    !cirugia.getChdetacirpros().isEmpty()) {
                    Chdetacirpro detalle = null;
                    Iterator it = cirugia.getChdetacirpros().iterator();
                    while (it.hasNext()) {
                        detalle = (Chdetacirpro)it.next();

                        if (detalle != null && 
                            detalle.getId().getHdccservicio() != null) {
                            Cpservicio servicio = 
                                this.serviceLocator.getClinicoService().getServicioPorId(detalle.getId().getHdccservicio());
                            lstCirugias.add(servicio);
                        }
                    }
                }
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (cirugia != null && cirugia.getHcplnumero() != null) {
            try {
                numeroCama = 
                        this.serviceLocator.getCirugiaService().getCamaUsuario(cirugia.getHcplnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (numeroCama != null) {
                nota.setHnencama(numeroCama);
            }

            if ("3".equals(cirugia.getHcpctipoaneste())) {
                desAldrobrom = "Se realizo Bromage?";
            } else {
                desAldrobrom = "Se realizo Aldrete?";
            }
            
            /*try {
                referenciaPaciente = 
            this.serviceLocator.getCirugiaService().getReferenciaPaciente(cirugia.getHcplnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }
             if (referenciaPaciente == null) {
                 referenciaPaciente = new Chrefepaci();
                 renderReferencia = false;
                 referenciaPaciente.setHrpcrefepaci("N");
             }else{
                 renderReferencia = true;
             }
            
            */
            
             referenciaPaciente = new Chrefepaci();
             renderReferencia = false;
             referenciaPaciente.setHrpcrefepaci("N");
            
           
        }
        
      
        
        


    }

    public void resetDatos() {
        nota = new Chnotaenferm();
        nota.setHnecrefiedolor("N");
        itDescripcion.setValue(null);
        init();
    }

    public boolean esValido() {
        boolean esValido = false;
        Chnotaenferm notaAux = null;
        try {
            if (cirugia != null) {
                if (tipoServicio == null) {
                    notaAux = 
                            this.serviceLocator.getCirugiaService().getNotaEnfermeriaIngreso(cirugia.getHcplnumero());
                } else {
                        List<Chnotaenferm> notaAuxList = 
                        this.serviceLocator.getCirugiaService().getNotasEnfermeriaIngresoProcedimientos(cirugia.getHcplnumero());
                    if (notaAuxList != null && !notaAuxList.isEmpty()) {
                        notaAux = notaAuxList.get(0);
                    } else {
                        notaAux = null;
                    }
                }
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (notaAux != null) {
            esValido = true;
        }

        return esValido;
    }


    /**
     * @param esSalida
     */
    public void setEsSalida(boolean esSalida) {
        this.esSalida = esSalida;
    }

    /**
     * @return
     */
    public boolean isEsSalida() {
        return esSalida;
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

    /**
     * @param labelText
     */
    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    /**
     * @return
     */
    public String getLabelText() {
        return labelText;
    }

    /**
     * @param lstCanalizacionSelect
     */
    public void setLstCanalizacionSelect(List<Chcanalivena> lstCanalizacionSelect) {
        this.lstCanalizacionSelect = lstCanalizacionSelect;
    }

    /**
     * @return
     */
    public List<Chcanalivena> getLstCanalizacionSelect() {
        return lstCanalizacionSelect;
    }

    /**
     * @param dtCanalizacion
     */
    public void setDtCanalizacion(HtmlDataTable dtCanalizacion) {
        this.dtCanalizacion = dtCanalizacion;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCanalizacion() {
        return dtCanalizacion;
    }

    /**
     * @param esHoraActual
     */
    public void setEsHoraActual(String esHoraActual) {
        this.esHoraActual = esHoraActual;
    }

    /**
     * @return
     */
    public String getEsHoraActual() {
        return esHoraActual;
    }

    /**
     * @param nota
     */
    public void setNota(Chnotaenferm nota) {
        this.nota = nota;
    }

    /**
     * @return
     */
    public Chnotaenferm getNota() {
        return nota;
    }

    /**
     * @param menuBean
     */
    public void setMenuBean(String menuBean) {
        this.menuBean = menuBean;
    }

    /**
     * @return
     */
    public String getMenuBean() {
        return menuBean;
    }

    /**
     * @param mostrarHoraActual
     */
    public void setMostrarHoraActual(boolean mostrarHoraActual) {
        this.mostrarHoraActual = mostrarHoraActual;
    }

    /**
     * @return
     */
    public boolean isMostrarHoraActual() {
        return mostrarHoraActual;
    }

    /**
     * @param cirugia
     */
    public void setCirugia(Chcirugprogr cirugia) {
        this.cirugia = cirugia;
    }

    /**
     * @return
     */
    public Chcirugprogr getCirugia() {
        return cirugia;
    }

    /**
     * @param itDescripcion
     */
    public void setItDescripcion(UIInput itDescripcion) {
        this.itDescripcion = itDescripcion;
    }

    /**
     * @return
     */
    public UIInput getItDescripcion() {
        return itDescripcion;
    }

    /**
     * @param renderPlantilla
     */
    public void setRenderPlantilla(boolean renderPlantilla) {
        this.renderPlantilla = renderPlantilla;
    }

    /**
     * @return
     */
    public boolean isRenderPlantilla() {
        return renderPlantilla;
    }

    /**
     * @param esIngreso
     */
    public void setEsIngreso(boolean esIngreso) {
        this.esIngreso = esIngreso;
    }

    /**
     * @return
     */
    public boolean isEsIngreso() {
        return esIngreso;
    }

    /**
     * @param lstCirugias
     */
    public void setLstCirugias(List lstCirugias) {
        this.lstCirugias = lstCirugias;
    }

    /**
     * @return
     */
    public List getLstCirugias() {
        return lstCirugias;
    }

    /**
     * @param dtCirugias
     */
    public void setDtCirugias(HtmlDataTable dtCirugias) {
        this.dtCirugias = dtCirugias;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCirugias() {
        return dtCirugias;
    }

    /**
     * @param esHospitalizacion
     */
    public void setEsHospitalizacion(boolean esHospitalizacion) {
        this.esHospitalizacion = esHospitalizacion;
    }

    /**
     * @return
     */
    public boolean isEsHospitalizacion() {
        if (cirugia != null && cirugia.getHcpctipoestanc() != null && 
            cirugia.getHcpctipoestanc().equals("H")) {
            esHospitalizacion = true;
        } else {
            esHospitalizacion = false;
        }
        return esHospitalizacion;
    }

    /**
     * @param lstEscala
     */
    public void setLstEscala(List lstEscala) {
        this.lstEscala = lstEscala;
    }

    /**
     * @return
     */
    public List getLstEscala() {
        if (lstEscala == null) {
            lstEscala = new ArrayList();
            lstEscala.add(new SelectItem("", "--"));
            lstEscala.add(new SelectItem(1, "1"));
            lstEscala.add(new SelectItem(2, "2"));
            lstEscala.add(new SelectItem(3, "3"));
            lstEscala.add(new SelectItem(4, "4"));
            lstEscala.add(new SelectItem(5, "5"));
            lstEscala.add(new SelectItem(6, "6"));
            lstEscala.add(new SelectItem(7, "7"));
            lstEscala.add(new SelectItem(8, "8"));
            lstEscala.add(new SelectItem(9, "9"));
            lstEscala.add(new SelectItem(10, "10"));
        }
        return lstEscala;
    }

    /**
     * @param lstCanalizacionSuspender
     */
    public void setLstCanalizacionSuspender(List<Chcanalivena> lstCanalizacionSuspender) {
        this.lstCanalizacionSuspender = lstCanalizacionSuspender;
    }

    /**
     * @return
     */
    public List<Chcanalivena> getLstCanalizacionSuspender() {
        return lstCanalizacionSuspender;
    }

    /**
     * @param esFebril
     */
    public void setEsFebril(boolean esFebril) {
        this.esFebril = esFebril;
    }

    /**
     * @return
     */
    public boolean isEsFebril() {
        return esFebril;
    }

    /**
     * @param tiempoAdministracion
     */
    public void setTiempoAdministracion(Integer tiempoAdministracion) {
        this.tiempoAdministracion = tiempoAdministracion;
    }

    /**
     * @return
     */
    public Integer getTiempoAdministracion() {
        return tiempoAdministracion;
    }

    /**
     * @param lstTemperatura
     */
    public void setLstTemperatura(List lstTemperatura) {
        this.lstTemperatura = lstTemperatura;
    }

    /**
     * @return
     */
    public List getLstTemperatura() {
        if (lstTemperatura == null) {
            lstTemperatura = new ArrayList();
            lstTemperatura.add(new SelectItem("", "Seleccione una opcion"));
            lstTemperatura.add(new SelectItem("A", "Afebril"));
            lstTemperatura.add(new SelectItem("F", "Febril"));
        }
        return lstTemperatura;
    }

    /**
     * @param canalizacion
     */
    public void setCanalizacion(Chcanalivena canalizacion) {
        this.canalizacion = canalizacion;
    }

    /**
     * @return
     */
    public Chcanalivena getCanalizacion() {
        return canalizacion;
    }

    /**
     * @param lstHistorialCanalizacion
     */
    public void setLstHistorialCanalizacion(List<Chcanalivena> lstHistorialCanalizacion) {
        this.lstHistorialCanalizacion = lstHistorialCanalizacion;
    }

    /**
     * @return
     */
    public List<Chcanalivena> getLstHistorialCanalizacion() {
        return lstHistorialCanalizacion;
    }

    /**
     * @param dtHistorialCanalizacion
     */
    public void setDtHistorialCanalizacion(HtmlDataTable dtHistorialCanalizacion) {
        this.dtHistorialCanalizacion = dtHistorialCanalizacion;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtHistorialCanalizacion() {
        return dtHistorialCanalizacion;
    }

    /**
     * @param mostrarCanalizacion
     */
    public void setMostrarCanalizacion(boolean mostrarCanalizacion) {
        this.mostrarCanalizacion = mostrarCanalizacion;
    }

    /**
     * @return
     */
    public boolean isMostrarCanalizacion() {
        return mostrarCanalizacion;
    }

    /**
     * @param mostrarCalibre
     */
    public void setMostrarCalibre(boolean mostrarCalibre) {
        this.mostrarCalibre = mostrarCalibre;
    }

    /**
     * @return
     */
    public boolean isMostrarCalibre() {
        return mostrarCalibre;
    }

    /**
     * @param lstMiembroSuperior
     */
    public void setLstMiembroSuperior(List lstMiembroSuperior) {
        this.lstMiembroSuperior = lstMiembroSuperior;
    }

    /**
     * @return
     */
    public List getLstMiembroSuperior() {
        if (lstMiembroSuperior == null) {
            lstMiembroSuperior = new ArrayList();
            lstMiembroSuperior.add(new SelectItem("B", "Brazo"));
            lstMiembroSuperior.add(new SelectItem("A", "Antebrazo"));
            lstMiembroSuperior.add(new SelectItem("M", "Mano"));

        }
        return lstMiembroSuperior;
    }


    /**
     * @param lstLocalizacion
     */
    public void setLstLocalizacion(List lstLocalizacion) {
        this.lstLocalizacion = lstLocalizacion;
    }

    /**
     * @return
     */
    public List getLstLocalizacion() {
        if (lstLocalizacion == null) {
            lstLocalizacion = new ArrayList();
            lstLocalizacion.add(new SelectItem("D", "Derecho"));
            lstLocalizacion.add(new SelectItem("I", "Izquierdo"));
        }
        return lstLocalizacion;
    }

    /**
     * @param lstTipoCateter
     */
    public void setLstTipoCateter(List lstTipoCateter) {
        this.lstTipoCateter = lstTipoCateter;
    }

    /**
     * @return
     */
    public List getLstTipoCateter() {
        if (lstTipoCateter == null) {
            lstTipoCateter = new ArrayList();
            //   lstTipoCateter.add(new SelectItem("P", "Pericraneal"));
            lstTipoCateter.add(new SelectItem("C", 
                                              "Cat�ter perif�rico "));
        }
        return lstTipoCateter;
    }

    /**
     * @param param
     */
    public void setListCalibre(List<SelectItem> param) {
        this.listCalibre = param;
    }

    /**
     * @return La lista de los calibres que existen
     */
    public List getListCalibre() {
        if (listCalibre == null || listCalibre.isEmpty()) {
            listCalibre = new ArrayList<SelectItem>();
            ArrayList<Chcalibcatet> listCalibreAux = null;
            try {
                listCalibreAux = 
                        (ArrayList<Chcalibcatet>)this.getServiceLocator().getCirugiaService().getListaCalibreCateter();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listCalibreAux.isEmpty()) {

                Iterator it = listCalibreAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listCalibre.add(new SelectItem(listCalibreAux.get(i).getCccecodigo(), 
                                                   listCalibreAux.get(i).getCccccalibre()));
                    i++;
                }
            }
        }
        return listCalibre;
    }

    /**
     * @param selectedIndex
     */
    public void setSelectedIndex(Integer selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    /**
     * @return
     */
    public Integer getSelectedIndex() {
        return selectedIndex;
    }

    /**
     * @param fechaAdministracion
     */
    public void setFechaAdministracion(Date fechaAdministracion) {
        this.fechaAdministracion = fechaAdministracion;
    }

    /**
     * @return
     */
    public Date getFechaAdministracion() {
        return fechaAdministracion;
    }

    public void setLstOpcionesEmbarazo(List lstOpcionesEmbarazo) {
        this.lstOpcionesEmbarazo = lstOpcionesEmbarazo;
    }

    public List getLstOpcionesEmbarazo() {
        if (lstOpcionesEmbarazo == null || lstOpcionesEmbarazo.isEmpty()) {
            lstOpcionesEmbarazo = new ArrayList();
            lstOpcionesEmbarazo.add(new SelectItem("S", "Positiva"));
            lstOpcionesEmbarazo.add(new SelectItem("N", "Negativa"));
        }
        return lstOpcionesEmbarazo;
    }

    /**
     * @param valueChangeEvent
     */
    public void setCanaliza(ValueChangeEvent valueChangeEvent) {
        canalizacion.setHcvecanalizaci((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setFechaActual(ValueChangeEvent valueChangeEvent) {
        setFechaEmbarazo((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHiecresulpruemb(ValueChangeEvent valueChangeEvent) {
        setHiecresulpruemb((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setSaleTransoperatoria(ValueChangeEvent valueChangeEvent) {
        setSaleTransoperatoria((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHcveasepsia(ValueChangeEvent valueChangeEvent) {
        canalizacion.setHcveasepsia((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHcvctipocatete(ValueChangeEvent valueChangeEvent) {
        canalizacion.setHcvctipocatete((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void changeCanalizacion() {
        if (canalizacion != null && canalizacion.getHcvecanalizaci() != null && 
            canalizacion.getHcvecanalizaci().equals("S")) {
            mostrarCanalizacion = true;
        } else {
            mostrarCanalizacion = false;
        }
    }

    public void changeAsepsia() {
        if (canalizacion != null && canalizacion.getHcveasepsia() != null && 
            canalizacion.getHcveasepsia().equals("N")) {
            mostrarAsepsia = true;
        } else {
            mostrarAsepsia = false;
        }
    }

    public void changeCateter() {
        if (canalizacion != null && canalizacion.getHcvctipocatete() != null && 
            canalizacion.getHcvctipocatete().equals("C")) {
            mostrarCalibre = true;
        } else {
            mostrarCalibre = false;
        }
    }

    /**
     * @param valueChangeEvent
     */
    public void setEsHoraActual(ValueChangeEvent valueChangeEvent) {
        setEsHoraActual((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeEsHoraActual() {
        if (esHoraActual != null && esHoraActual.equals("N")) {
            mostrarHoraActual = true;
        } else {
            mostrarHoraActual = false;
        }
    }

    /*
 *  Botones Secundarios
 */

    public void agregarCanalizacion() {
        boolean wexito = true;
        nextAction = "";
        ChcanalivenaPK id;
        id = new ChcanalivenaPK();

        if (lstCanalizacionSelect == null) {
            lstCanalizacionSelect = new ArrayList<Chcanalivena>();
        }
        wexito = true;
        canalizacion.setHcvcestado(ESTADO_VIGENTE);
        canalizacion.setHcvcoperador(userName());
        canalizacion.setHcvnclinica(this.getClinica().getCclncodigo());
        canalizacion.setHcvlusuario(cirugia.getHcplusuario().getHuslnumero());
        if (!canalizacion.getHcveasepsia().equals("S")) {
            FacesUtils.addErrorMessage("Debe realizar asepsia");
            wexito = false;
        }

        if (canalizacion.getId() == null || canalizacion.getId().getHcvlnumero() == null) {
            id.setHcvlnumero(cirugia.getHcplnumero());
            id.setHcvctiposervi(TIPO_HOSPITALIZACION);
            canalizacion.setId(id);

        }
        if (wexito) {
            lstCanalizacionSelect.add(canalizacion);
            canalizacion = new Chcanalivena();
            mostrarCanalizacion = false;

        } else {
            nextAction = "";
        }
    }

    public void eliminarCanalizacion() {
        Chcanalivena canalizaAux = null;
        canalizaAux = (Chcanalivena)this.dtCanalizacion.getRowData();
        lstCanalizacionSelect.remove(canalizaAux);
    }

    public void suspenderCanalizacion() {

    }

    public void changeTransoperatorio() {
        msgNotaEnfermeriaTransoperatoria = "";
        msgNotaEnfermeriaAnestesia = "";
        msgNotaEnfermeriaDescripcion = "";
        if (saleTransoperatoria != null && saleTransoperatoria.equals("S")) {
            msgNotaEnfermeriaTransoperatoria = 
                    IMsg.MSG_TERMINA_ETAPA_TRANSOPERATORIA;
            Chcirugprogr cirAux = null;
            List<Chdetacirpro> lstDetalle = null;
            try {
                cirAux = 
                        serviceLocator.getClinicoService().getProgramarCirugia(cirugia.getHcplnumero());
                lstDetalle = 
                        serviceLocator.getClinicoService().getDetalleCirugiasProgramadas(cirugia.getHcplnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (cirAux != null) {
                if (cirAux.getHcpcregisanest() == null || 
                    cirAux.getHcpcregisanest().equals("N")) {
                    msgNotaEnfermeriaAnestesia = 
                            IMsg.MSG_TRANS_FALTA_RECORD_ANESTESIA;
                }
            }

            if (lstDetalle != null && !lstDetalle.isEmpty()) {
                for (Chdetacirpro aux: lstDetalle) {
                    if (aux == null && aux.getHdccdescrquiru().equals("N")) {
                        msgNotaEnfermeriaDescripcion = 
                                msgNotaEnfermeriaDescripcion + 
                                " El servicio:  " + 
                                aux.getId().getHdccservicio() + 
                                " No tiene la Descripcion Quirurgica";
                    }
                }
            }
        }
    }

    /*
  *  Botones Principales
  */

    public String darAlta() {
        ChnotaenfermPK idNota;
        idNota = new ChnotaenfermPK();
        boolean wexito;
        wexito = true;
        ChsignovitalPK idSigno;
        idSigno = new ChsignovitalPK();
        Date fechaSalida = null;
        setGeneroReporte(false);

        if (cirugia != null) {
            if (esHoraActual != null && esHoraActual.equals("N") && 
                tiempoAdministracion != null) {

                Calendar fechaCalendarAdmin;
                fechaCalendarAdmin = Calendar.getInstance();
                fechaCalendarAdmin.setTime(new Date());
                fechaCalendarAdmin.add(Calendar.MINUTE, 
                                       (tiempoAdministracion * -1));
                nota.setHnedfechanotac(fechaCalendarAdmin.getTime());
                fechaSalida = fechaCalendarAdmin.getTime();
                nota.setHnedfechanotac(fechaSalida);
            } else {
                fechaSalida = new Date();
                nota.setHnedfechanotac(new Date());
            }
        }

        // Se verifican que no esten venas canalizadas y liquidos en administraci�n o por administrar
        if (cirugia != null) {
            List<Chcanalivena> lstVenaCanalizada = 
                new ArrayList<Chcanalivena>();
            try {
                lstVenaCanalizada = 
                        this.getServiceLocator().getCirugiaService().getLstVenaCanalizada(cirugia.getHcplnumero(), 
                                                                                          TIPO_HOSPITALIZACION);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstVenaCanalizada != null && 
                (!lstVenaCanalizada.isEmpty() || lstVenaCanalizada.size() != 
                 0)) {
                wexito = false;
                FacesUtils.addErrorMessage(IMsg.MSG_VENA_CANALIZADA);
            }

            List<Chcontroliqu> lstControlLiquido = 
                new ArrayList<Chcontroliqu>();
            try {
                lstControlLiquido = 
                        this.getServiceLocator().getCirugiaService().getLstLiquidosPorAdministrar(cirugia.getHcplnumero(), 
                                                                                                  TIPO_HOSPITALIZACION);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstControlLiquido != null && 
                (!lstControlLiquido.isEmpty() || lstControlLiquido.size() != 
                 0)) {
                wexito = false;
                FacesUtils.addErrorMessage(IMsg.MSG_LIQUIDOS_POR_ADMINISTRAR);
            }

            List<Chformulaliq> lstFormulaliq = new ArrayList<Chformulaliq>();
            try {
                lstFormulaliq = 
                        this.getServiceLocator().getCirugiaService().getLstLiquidosFormuladosPorAdministrar(cirugia.getHcplnumero(), 
                                                                                                            TIPO_HOSPITALIZACION);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstFormulaliq != null && 
                (!lstFormulaliq.isEmpty() || lstFormulaliq.size() != 0)) {
                wexito = false;
                FacesUtils.addErrorMessage(IMsg.MSG_LIQUIDOS_FORMULADOS_POR_ADMINISTRAR);
            }
        }

        if (cirugia != null && wexito) {
            // Se Guarda los Signos Vitales 
            nota.setHnecestado(ESTADO_VIGENTE);
            nota.setHnecoperador(userName());
            if (cirugia.getHcplusuario() != null) {
                nota.setHnelusuario(cirugia.getHcplusuario().getHuslnumero());
            }
            if (nota.getId() == null) {
                idNota.setHnelnumero(cirugia.getHcplnumero());
                idNota.setHnectiposervi(TIPO_HOSPITALIZACION);
                nota.setId(idNota);
            }
            nota.setHnenclinica(this.getClinica().getCclncodigo());

            try {
                this.serviceLocator.getCirugiaService().saveDarAltaEnfermeria(nota, 
                                                                              null, 
                                                                              cirugia, 
                                                                              fechaSalida, lstCirugiasProgramadas);
                FacesUtils.resetManagedBean("consultarListaNotasEnfermeria");
                FacesUtils.resetManagedBean("registrarNotaEnfermeriaBean");
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            } catch (ModelException e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            }
        }

        if (!wexito) {
            return BeanNavegacion.RUTA_ACTUAL;
        }

        if (!esIngreso) {
            FacesUtils.resetManagedBean("registrarNotaEnfermeriaBean");
            return BeanNavegacion.RUTA_IR_LISTA_NOTAS_ENFERMERIA;
        } else {
            FacesUtils.resetManagedBean("registrarNotaEnfermeriaBean");
            return BeanNavegacion.RUTA_IR_LISTA_NOTAS_ENFERMERIA;
        }
    }

    public void mostrarBuscadorPlantilla() {
        FacesUtils.resetManagedBean("buscadorPlantillaCirugiaBean");
        BuscadorPlantillaCirugiaBean buscador = 
            (BuscadorPlantillaCirugiaBean)FacesUtils.getManagedBean("buscadorPlantillaCirugiaBean");
        if (buscador != null) {
            buscador.setNombreBeanAnterior("registrarNotaEnfermeriaBean");
            buscador.setTagRenderizar("panelGridIngresoCirugiaTab");
        }
        selectedIndex = ACTIVAR_BUSCADOR_PLANTILLAS;
        renderPlantilla = true;
        generoReporte = false;
    }


    public void aceptarPlantilla() {
        BuscadorPlantillaCirugiaBean buscador = 
            (BuscadorPlantillaCirugiaBean)FacesUtils.getManagedBean("buscadorPlantillaCirugiaBean");
        if (buscador != null && buscador.getPlantillaSelect() != null) {
            itDescripcion.setValue(buscador.getPlantillaSelect().getHplcdescripcio());
            nota.setHnecnotaenferm(buscador.getPlantillaSelect().getHplcdescripcio());
        }
        renderPlantilla = false;
        selectedIndex = ACTIVAR_APLICACION;
        FacesUtils.resetManagedBean("buscadorPlantillaBean");
    }


    /**
     * @return
     */
    public String aceptar() {
        boolean wexito;
        wexito = true;
        generoReporte = false;
        nextAction = "";

        ChsignovitalPK idSigno;
        idSigno = new ChsignovitalPK();
        ChnotaenfermPK idNota;
        idNota = new ChnotaenfermPK();
        setGeneroReporte(false);

        if (hiecresulpruemb != null && !hiecresulpruemb.equals("")) {
            nota.setResultadoPrueba(hiecresulpruemb);
        }

        if (fechaEmbarazo != null) {
            nota.setFechaEmbarazo(fechaEmbarazo);
        }

        if (lstHistorialCanalizacion != null && 
            !lstHistorialCanalizacion.isEmpty()) {
            for (Chcanalivena canalizacion: lstHistorialCanalizacion) {
                if (canalizacion != null && canalizacion.isHcvbsuspender()) {
                    canalizacion.setHcvcestado(ESTADO_SUSPENDER);
                    canalizacion.setHcvdfechamodif(new Date());
                    canalizacion.setHcvcoperamodif(userName());
                    lstCanalizacionSuspender.add(canalizacion);
                }
            }
        }

        if (nota != null) {
            if (esHoraActual != null && esHoraActual.equals("N") && 
                tiempoAdministracion != null) {

                Calendar fechaCalendarAdmin;
                fechaCalendarAdmin = Calendar.getInstance();
                fechaCalendarAdmin.setTime(new Date());
                fechaCalendarAdmin.add(Calendar.MINUTE, 
                                       (tiempoAdministracion * -1));
                nota.setHnedfechanotac(fechaCalendarAdmin.getTime());
            } else {
                nota.setHnedfechanotac(new Date());
            }
        }
        if (referenciaPaciente != null && cirugia != null) {    
            if("N".equals(referenciaPaciente.getHrpcrefepaci())){
                referenciaPaciente = new Chrefepaci();
                referenciaPaciente.setHrpcrefepaci("N");
            }
            ChrefepaciPK referenciaPK = new ChrefepaciPK();
            referenciaPK.setHrplconsulta(cirugia.getHcplnumero());
            referenciaPaciente.setId(referenciaPK);
            referenciaPaciente.setHrpdfecreg(new Date());
            referenciaPaciente.setHrpcusureg(userName());
        }
        
        if (cirugia != null && wexito) {
            nota.setHnecestado(ESTADO_VIGENTE);
            nota.setHnecoperador(userName());

            if (cirugia.getHcplusuario() != null) {
                nota.setHnelusuario(cirugia.getHcplusuario().getHuslnumero());
            }
              if (nota.getId() == null) {
                idNota.setHnelnumero(cirugia.getHcplnumero());
                idNota.setHnectiposervi(TIPO_HOSPITALIZACION);
                nota.setId(idNota);
            }
            nota.setHnenclinica(this.getClinica().getCclncodigo());

            try {
                if (tipoServicio != null) {
                    nota.getId().setHnectiposervi(tipoServicio);
                }
                this.serviceLocator.getCirugiaService().saveSignosNotaCanalizacionEnfermeria(nota, 
                                                                                             null, 
                                                                                             lstCanalizacionSelect, 
                                                                                             lstCanalizacionSuspender,
                                                                                             referenciaPaciente);
                nextAction = navegationRule;
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            } catch (ModelException e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            }
        }

        if (!wexito) {
            return BeanNavegacion.RUTA_ACTUAL;
        }

        if (!esIngreso) {
            return BeanNavegacion.RUTA_ACTUAL;
        } else {
            FacesUtils.resetManagedBean(menuBean);
            return nextAction;
        }
    }

    public void generarReporte() {
        Chusuario usuario = null;
        GenerarFoliosCirugiaBean bean = 
            (GenerarFoliosCirugiaBean)FacesUtils.getManagedBean("generarFoliosCirugiaBean");
        byte[] result = null;
        try {
            usuario = 
                    this.serviceLocator.getClinicoService().getUsuario(cirugia.getHcplusuario().getHuslnumero());
        } catch (ModelException e) {
            e.printStackTrace();
        }
        
        if(tipoServicio != null){
            try {
                lstConsclin = 
                        this.serviceLocator.getClinicoService().getConsultaClinica(cirugia.getHcplnumero().longValue());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (bean != null && cirugia != null && usuario != null) {
            if (lstConsclin!=null && !lstConsclin.isEmpty()) {
            result = bean.generarNotasEnfermeria(usuario, cirugia, -1,lstConsclin.get(0));
            }else{
                result = bean.generarNotasEnfermeria(usuario, cirugia, -1,null);
            }
        }
        if (result != null) {
            PdfServletUtils.showPdfDocument(result, "NotasdeEnfermeria.pdf", 
                                            false);
            setGeneroReporte(true);
        } else {
            FacesUtils.addErrorMessage("No pudo generar Reporte Notas de Enfermeria. ");
            setGeneroReporte(false);
        }
    }

    /**
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param generoReporte
     */
    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    /**
     * @return
     */
    public boolean isGeneroReporte() {
        return generoReporte;
    }

    /**
     * @param navegationRule
     */
    public void setNavegationRule(String navegationRule) {
        this.navegationRule = navegationRule;
    }

    /**
     * @return
     */
    public String getNavegationRule() {
        return navegationRule;
    }

    /**
     * @param nextAction
     */
    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    /**
     * @return
     */
    public String getNextAction() {
        return nextAction;
    }

    /**
     * @param salePreoperatorio
     */
    public void setSalePreoperatorio(String salePreoperatorio) {
        this.salePreoperatorio = salePreoperatorio;
    }

    /**
     * @return
     */
    public String getSalePreoperatorio() {
        return salePreoperatorio;
    }

    /**
     * @param saleTransoperatoria
     */
    public void setSaleTransoperatoria(String saleTransoperatoria) {
        this.saleTransoperatoria = saleTransoperatoria;
    }

    /**
     * @return
     */
    public String getSaleTransoperatoria() {
        return saleTransoperatoria;
    }

    /**
     * @param desAldrobrom
     */
    public void setDesAldrobrom(String desAldrobrom) {
        this.desAldrobrom = desAldrobrom;
    }

    /**
     * @return
     */
    public String getDesAldrobrom() {
        return desAldrobrom;
    }

    public void setSalePostoperatorio(String salePostoperatorio) {
        this.salePostoperatorio = salePostoperatorio;
    }

    public String getSalePostoperatorio() {
        return salePostoperatorio;
    }

    public void generarControl() {
        index = -1;
        wreporte = "CONTROL";
        Chusuario usuario = null;
        List<Chsignovital> signos = null;
        List<Chcontroliqu> liqadm = null;
        List<Chcontroliqu> liqeli = null;

        List<Chcontmedane> medane = null;
        List<Chcontrmedic> medica = null;
        List<Chaldrete> aldre = null;
        ArrayList<Chliquiparen> listliquidosAux = null;
        List<Chcontroorden> controlOrden = null;

        String siglasLiquidoParentales = "Tipo L�quidos Administrados: ";

        registros = new ArrayList();
        /** Matrix object. */
        Map linea = new HashMap();

        try {
            signos = 
                    this.serviceLocator.getCirugiaService().getSignosVitalesTomados(cirugia.getHcplnumero());
            liqadm = 
                    this.serviceLocator.getClinicoService().getLstLiquidosAdministrados(cirugia.getHcplnumero());
            liqeli = 
                    this.serviceLocator.getClinicoService().getLstLiquidosAdministradoEliminados(cirugia.getHcplnumero());
            medane = 
                    this.serviceLocator.getCirugiaService().getControlMedicamentosAnestesia(cirugia.getHcplnumero());
            medica = 
                    this.serviceLocator.getCirugiaService().getFormulaMedicamentosCirugiaSuministrados(cirugia.getHcplnumero());
            aldre = 
                    this.serviceLocator.getCirugiaService().getAldrete(cirugia.getHcplnumero());
            usuario = 
                    this.serviceLocator.getClinicoService().getUsuario(cirugia.getHcplusuario().getHuslnumero());
            listliquidosAux = 
                    (ArrayList<Chliquiparen>)this.serviceLocator.getClinicoService().getLiquidoParenterales();
                    
            lstcontrolOrden= this.serviceLocator.getCirugiaService().getOxigenoSuministrados(cirugia.getHcplnumero());
            
        } catch (ModelException e) {
            e.printStackTrace();
        }

        /* Para adicionar las siglas de liquidos Parentales como un parametro del reporte */
        if (!listliquidosAux.isEmpty()) {
            Iterator it = listliquidosAux.iterator();
            int i = 0;
            while (it.hasNext()) {
                it.next();
                siglasLiquidoParentales = 
                        siglasLiquidoParentales + " " + listliquidosAux.get(i).getHlpccodigo() + 
                        ": " + listliquidosAux.get(i).getHlpcdescripcio() + 
                        " ";
                i++;
            }
        }

        /* Signos vitales */
        if (signos != null && !signos.isEmpty()) {
            Iterator it = signos.iterator();
            while (it.hasNext()) {
                Chsignovital signoAux = (Chsignovital)it.next();
                String ta = 
                    signoAux.getHsvnpresart1().toString() + "-" + signoAux.getHsvnpresart2().toString();
                linea = new HashMap();
                linea.put(1, signoAux.getHsvdfechaactiv()); /* 1 Hora*/
                linea.put(2, ta); /* 2 T.A.*/
                if (signoAux.getHsvnfreccard() != null) {
                    linea.put(3, 
                              signoAux.getHsvnfreccard().toString()); /* 3 F.C.*/
                }
                if (signoAux.getHsvnsatuoxihe() != null) {
                    linea.put(4, signoAux.getHsvnsatuoxihe().toString());
                }

                if (signoAux.getHsvnfrecresp() != null) {
                    linea.put(5, 
                              signoAux.getHsvnfrecresp().toString()); /* 5 F.R*/
                } else {
                    linea.put(5, " "); /* 4 SpO2*/
                }
                if (signoAux.getHsvatemperatu() != null) {
                    linea.put(6, 
                              signoAux.getHsvatemperatu().toString()); /* 6 T�*/
                } else {
                    linea.put(6, " "); /* 6 T�*/
                }
                linea.put(7, new BigDecimal(0)); /* 7 Cantidad*/
                linea.put(8, " "); /* 8 Via*/
                linea.put(9, " "); /* 9 Tipo*/
                linea.put(10, new BigDecimal(0)); /* 10 Cantidad*/
                linea.put(11, " "); /* 11 Via*/
                linea.put(12, " "); /* 12 Nombre Generico*/
                linea.put(13, " "); /* 13 Dosis*/
                linea.put(14, " "); /* 14 Via*/
                linea.put(15, " "); /* 15 Actividad*/
                linea.put(16, " "); /* 16 Respiracion */
                linea.put(17, " "); /* 17 Circulacion*/
                linea.put(18, " "); /* 18 Conciencia*/
                linea.put(19, " "); /* 19 Saturacion*/
                linea.put(20, " "); /* 20 Ambulacion*/
                linea.put(21, " "); /* 21 Dolor*/
                linea.put(22, " "); /* 22 Sangrado Posquirurgico*/
                linea.put(23, " "); /* 23 Tolerancia a liquidos*/
                linea.put(24, " "); /* 24 Eliminacion Urinaria*/
                linea.put(25, " "); /* 25 Anestesia regional */
                linea.put(26, " "); /* 26 */
                linea.put(27, null); /* 27 Hora inicio oxigeno*/
                linea.put(28, " "); /* 28Sistema de oxigenacion*/
                linea.put(29, null); /* 29  Litros por minuto*/
                linea.put(30, null); /* 30 Hora terminacion*/
                linea.put(31, 
                          getNombreOperadorXUsuario(signoAux.getHsvcoperador())); /* 26 Operador */
                linea.put(32, null); /* 30 mimutos x litro*/
                registros.add(linea);
            }
        }
        /* Liquidos administrados*/
        if (liqadm != null && !liqadm.isEmpty()) {
            Iterator it1 = liqadm.iterator();
            while (it1.hasNext()) {
                Chcontroliqu liqadmAux = (Chcontroliqu)it1.next();
                linea = new HashMap();
                linea.put(1, liqadmAux.getHcldfechactivi());
                linea.put(2, " ");
                linea.put(3, " ");
                linea.put(4, " ");
                linea.put(5, " ");
                linea.put(6, " ");
                linea.put(7, new BigDecimal(liqadmAux.getHclncantisumin()));
                linea.put(8, liqadmAux.getHclcvialiquido());
                linea.put(9, liqadmAux.getHclctipoliquid());
                linea.put(10, new BigDecimal(0));
                linea.put(11, " "); /* 11 Via*/
                linea.put(12, " "); /* 12 Nombre Generico*/
                linea.put(13, " "); /* 13 Dosis*/
                linea.put(14, " "); /* 14 Via*/
                linea.put(15, " "); /* 15 Actividad*/
                linea.put(16, " "); /* 16 Respiracion */
                linea.put(17, " "); /* 17 Circulacion*/
                linea.put(18, " "); /* 18 Conciencia*/
                linea.put(19, " "); /* 19 Saturacion*/
                linea.put(20, " "); /* 20 Ambulacion*/
                linea.put(21, " "); /* 21 Dolor*/
                linea.put(22, " "); /* 22 Sangrado Posquirurgico*/
                linea.put(23, " "); /* 23 Tolerancia a liquidos*/
                linea.put(24, " "); /* 24 Eliminacion Urinaria*/
                linea.put(25, " "); /* 25 Anestesia regional */
                linea.put(26, " "); /* 26*/
                linea.put(27, null); /* 27 Hora inicio oxigeno*/
                linea.put(28, " "); /* 28Sistema de oxigenacion*/
                linea.put(29, null); /* 29  Litros por minuto*/
                linea.put(30, null); /* 30 Hora terminacion*/
                linea.put(31, 
                          getNombreOperadorXUsuario(liqadmAux.getHclcoperador()));
                linea.put(32, null); /* 30 mimutos x litro*/
                registros.add(linea);
            }
        }

        /* Liquidos Eliminados*/
        if (liqeli != null && !liqeli.isEmpty()) {
            Iterator itel = liqeli.iterator();
            while (itel.hasNext()) {
                Chcontroliqu liqeliAux = (Chcontroliqu)itel.next();
                linea = new HashMap();
                linea.put(1, liqeliAux.getHcldfechactivi());
                linea.put(2, " ");
                linea.put(3, " ");
                linea.put(4, " ");
                linea.put(5, " ");
                linea.put(6, " ");
                linea.put(7, new BigDecimal(0));
                linea.put(8, " ");
                linea.put(9, " ");
                if (liqeliAux.getHclndrenaje() != null) {
                    linea.put(10, new BigDecimal(liqeliAux.getHclndrenaje()));
                }
                linea.put(10, new BigDecimal(0));
                linea.put(11, liqeliAux.getHclctipoliquid());
                linea.put(12, " "); /* 12 Nombre Generico*/
                linea.put(13, " "); /* 13 Dosis*/
                linea.put(14, " "); /* 14 Via*/
                linea.put(15, " "); /* 15 Actividad*/
                linea.put(16, " "); /* 16 Respiracion */
                linea.put(17, " "); /* 17 Circulacion*/
                linea.put(18, " "); /* 18 Conciencia*/
                linea.put(19, " "); /* 19 Saturacion*/
                linea.put(20, " "); /* 20 Ambulacion*/
                linea.put(21, " "); /* 21 Dolor*/
                linea.put(22, " "); /* 22 Sangrado Posquirurgico*/
                linea.put(23, " "); /* 23 Tolerancia a liquidos*/
                linea.put(24, " "); /* 24 Eliminacion Urinaria*/
                linea.put(25, " "); /* 25 Anestesia regional */
                linea.put(26, " "); /* 26 */
                 linea.put(27, null); /* 27 Hora inicio oxigeno*/
                 linea.put(28, " "); /* 28Sistema de oxigenacion*/
                 linea.put(29, null); /* 29  Litros por minuto*/
                  linea.put(30, null); /* 30 Hora terminacion*/
                linea.put(31, 
                          getNombreOperadorXUsuario(liqeliAux.getHclcoperador()));
                linea.put(32, null); /* 30 mimutos x litro*/
                registros.add(linea);
            }
        }
        /* Medicamentos de anestesia */
        if (medane != null && !medane.isEmpty()) {
            Iterator itm = medane.iterator();
            while (itm.hasNext()) {
                Chcontmedane medaneAux = (Chcontmedane)itm.next();
                linea = new HashMap();
                linea.put(1, medaneAux.getHmadfecregistr());
                linea.put(2, " ");
                linea.put(3, " ");
                linea.put(4, " ");
                linea.put(5, " ");
                linea.put(6, " ");
                linea.put(7, new BigDecimal(0));
                linea.put(8, " ");
                linea.put(9, " ");
                linea.put(10, new BigDecimal(0));
                linea.put(11, " ");
                linea.put(12, medaneAux.getHmacmedicament());
                if (medaneAux.getHmaninduccion() == null) {
                    linea.put(13, " ");
                } else {
                    linea.put(13, medaneAux.getHmaninduccion().toString());
                }
                linea.put(14, " "); /* 14 Via*/
                linea.put(15, " "); /* 15 Actividad*/
                linea.put(16, " "); /* 16 Respiracion */
                linea.put(17, " "); /* 17 Circulacion*/
                linea.put(18, " "); /* 18 Conciencia*/
                linea.put(19, " "); /* 19 Saturacion*/
                linea.put(20, " "); /* 20 Ambulacion*/
                linea.put(21, " "); /* 21 Dolor*/
                linea.put(22, " "); /* 22 Sangrado Posquirurgico*/
                linea.put(23, " "); /* 23 Tolerancia a liquidos*/
                linea.put(24, " "); /* 24 Eliminacion Urinaria*/
                linea.put(25, " "); /* 25 Anestesia regional */
                linea.put(26, " "); /* 26 */
                 linea.put(27, null); /* 27 Hora inicio oxigeno*/
                 linea.put(28, " "); /* 28Sistema de oxigenacion*/
                 linea.put(29, null); /* 29  Litros por minuto*/
                  linea.put(30, null); /* 30 Hora terminacion*/
                linea.put(31, 
                          getNombreOperadorXUsuario(medaneAux.getHmacoperador()));
                linea.put(32, null); /* 30 mimutos x litro*/
                registros.add(linea);
            }
        }
        /* Otros medicamentos */
        if (medica != null && !medica.isEmpty()) {
            Iterator ito = medica.iterator();
            while (ito.hasNext()) {
                Chcontrmedic medicaAux = (Chcontrmedic)ito.next();
                linea = new HashMap();
                linea.put(1, medicaAux.getHcmdfechaanota());
                linea.put(2, " ");
                linea.put(3, " ");
                linea.put(4, " ");
                linea.put(5, " ");
                linea.put(6, " ");
                linea.put(7, new BigDecimal(0));
                linea.put(8, " ");
                linea.put(9, " ");
                linea.put(10, new BigDecimal(0));
                linea.put(11, " ");
                linea.put(12, medicaAux.getHcmcmedicament());
                linea.put(13, medicaAux.getHcmcadosis().toString());
                linea.put(14, medicaAux.getHcmcviadministr());
                linea.put(15, " "); /* 15 Actividad*/
                linea.put(16, " "); /* 16 Respiracion */
                linea.put(17, " "); /* 17 Circulacion*/
                linea.put(18, " "); /* 18 Conciencia*/
                linea.put(19, " "); /* 19 Saturacion*/
                linea.put(20, " "); /* 20 Ambulacion*/
                linea.put(21, " "); /* 21 Dolor*/
                linea.put(22, " "); /* 22 Sangrado Posquirurgico*/
                linea.put(23, " "); /* 23 Tolerancia a liquidos*/
                linea.put(24, " "); /* 24 Eliminacion Urinaria*/
                linea.put(25, " "); /* 25 Anestesia regional */
                linea.put(26, " "); /* 26 */
                linea.put(27, null); /* 27 */
                linea.put(28, " "); /* 28Sistema de oxigenacion*/
                linea.put(29, null); /* 29  Litros por minuto*/
                 linea.put(30, null); /* 30 Hora terminacion*/
                linea.put(31, 
                          getNombreOperadorXUsuario(medicaAux.getHcmcoperador()));
                linea.put(32, null); /* 30 mimutos x litro*/
                registros.add(linea);
            }
        }
        /* Aldrete */
        if (aldre != null && !aldre.isEmpty()) {
            Iterator ital = aldre.iterator();
            while (ital.hasNext()) {
                Chaldrete aldreAux = (Chaldrete)ital.next();
                linea = new HashMap();
                linea.put(1, aldreAux.getHaldfechaactiv());
                linea.put(2, " ");
                linea.put(3, " ");
                linea.put(4, " ");
                linea.put(5, " ");
                linea.put(6, " ");
                linea.put(7, new BigDecimal(0));
                linea.put(8, " ");
                linea.put(9, " ");
                linea.put(10, new BigDecimal(0));
                linea.put(11, " ");
                linea.put(12, " ");
                linea.put(13, " ");
                linea.put(14, " ");
                if (cirugia.getHcpctipoaneste().equals("2")) {
                    if (aldreAux.getHalnactividad() == null) {
                        linea.put(15, " ");
                    } else {
                        linea.put(15, aldreAux.getHalnactividad().toString());
                    }
                    if (aldreAux.getHalnrespiracio() == null) {
                        linea.put(16," ");
                    } else {
                        linea.put(16, aldreAux.getHalnrespiracio().toString());
                    }
                    if (aldreAux.getHalncirculacio() == null) {
                        linea.put(17, " ");
                    } else {
                        linea.put(17, aldreAux.getHalncirculacio().toString());
                    }
                    if (aldreAux.getHalnestadconci() == null) {
                        linea.put(18, " ");
                    } else {
                        linea.put(18, aldreAux.getHalnestadconci().toString());
                    }
                    if (aldreAux.getHalnsaturoxige() == null) {
                        linea.put(19, " ");
                    } else {
                        linea.put(19, aldreAux.getHalnsaturoxige().toString());
                    }
                    linea.put(20, " ");
                    linea.put(21, " ");
                    linea.put(22, " ");
                    linea.put(23, " ");
                    linea.put(24, " ");
                } else {
                    linea.put(15, " ");
                    linea.put(16, " ");
                    linea.put(17, " ");
                    linea.put(18, " ");
                    linea.put(19, " ");
                    if (aldreAux.getHalnambulacion() != null) {
                        linea.put(20, aldreAux.getHalnambulacion().toString());
                    } else {
                        linea.put(20, "");
                    }

                    if (aldreAux.getHalndolor() != null) {
                        linea.put(21, aldreAux.getHalndolor().toString());
                    } else {
                        linea.put(21, "");
                    }


                    if (aldreAux.getHalnsangrposqu() != null) {
                        linea.put(22, aldreAux.getHalnsangrposqu().toString());
                    } else {
                        linea.put(22, "");
                    }

                    if (aldreAux.getHalntolerliqui() != null) {
                        linea.put(23, aldreAux.getHalntolerliqui().toString());
                    } else {
                        linea.put(23, "");
                    }

                    if (aldreAux.getHalnelimiurina() != null) {
                        linea.put(24, aldreAux.getHalnelimiurina().toString());
                    } else {
                        linea.put(24, "");
                    }
                }
                linea.put(25, cirugia.getHcpctipoaneste());
                linea.put(26, " "); /* 26 */
                linea.put(27, null); /* 27 Hora inicio oxigeno*/
                linea.put(28, " "); /* 28Sistema de oxigenacion*/
                linea.put(29, null); /* 29  Litros por minuto*/
                 linea.put(30,null); /* 30 Hora terminacion*/
                linea.put(31, 
                          getNombreOperadorXUsuario(aldreAux.getHalcoperador()));
                linea.put(32, null); /* 30 mimutos x litro*/
                registros.add(linea);
            }
        }
        
        /* Oxigeno */
        if (lstcontrolOrden != null && !lstcontrolOrden.isEmpty()) {
            Iterator it = lstcontrolOrden.iterator();
            while (it.hasNext()) {
                Chcontroorden ordenAux = (Chcontroorden)it.next();
                String ta = ordenAux.getId().getHcolnumero().toString();
                linea = new HashMap();
                linea.put(1, ordenAux.getHcocdfechadminis()); /* 1 Hora*/
                linea.put(2, ta); /* 2 T.A.*/
                linea.put(3, " "); /* 3 F.C.*/
                linea.put(4, " ");
                linea.put(5, " "); /* 5 F.R*/
                linea.put(6, " "); /* 6 T�*/
                linea.put(7, new BigDecimal(0)); /* 7 Cantidad*/
                linea.put(8, " "); /* 8 Via*/
                linea.put(9, " "); /* 9 Tipo*/
                linea.put(10, new BigDecimal(0)); /* 10 Cantidad*/
                linea.put(11, " "); /* 11 Via*/
                linea.put(12, " "); /* 12 Nombre Generico*/
                linea.put(13, " "); /* 13 Dosis*/
                linea.put(14, " "); /* 14 Via*/
                linea.put(15, " "); /* 15 Actividad*/
                linea.put(16, " "); /* 16 Respiracion */
                linea.put(17, " "); /* 17 Circulacion*/
                linea.put(18, " "); /* 18 Conciencia*/
                linea.put(19, " "); /* 19 Saturacion*/
                linea.put(20, " "); /* 20 Ambulacion*/
                linea.put(21, " "); /* 21 Dolor*/
                linea.put(22, " "); /* 22 Sangrado Posquirurgico*/
                linea.put(23, " "); /* 23 Tolerancia a liquidos*/
                linea.put(24, " "); /* 24 Eliminacion Urinaria*/
                linea.put(25, " "); /* 25 Anestesia regional */
                linea.put(27, ordenAux.getHcodhorainioxi()); /* 26 Hora inicio oxigeno*/
                linea.put(28, ordenAux.getHcocsistoxige()); /* 27 Sistema de oxigenacion*/
                linea.put(29, new Long(ordenAux.getHcoccantlitros())); /* 28 Litros por minuto*/
                linea.put(30, ordenAux.getHcodhorafinoxi()); /* 29 Hora terminacion*/
                linea.put(31,ordenAux.getHcocoperaadmi()); /* 30 Operador */
                linea.put(32, ordenAux.getHcoccantminutos()); /* 30 mimutos x litro*/
                registros.add(linea);
            }
        }

        File reportFile = 
            new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/ControlEnfermeraCirugia.jasper"));

        if (reportFile.exists()) {
            Map parameters = new HashMap();
            byte[] bytes = null;
            try {
                URL imagen = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/profamilia_negro.gif");

                String cirugias = "";
                if (lstCirugias != null && !lstCirugias.isEmpty()) {
                    Iterator it = lstCirugias.iterator();
                    while (it.hasNext()) {
                        Cpservicio servic = (Cpservicio)it.next();
                        cirugias = " " + servic.getCsvcnombre();
                    }
                }
                parameters.put("IMAGEN", imagen);
                parameters.put("FECHA", new Date());
                parameters.put("NO_HISTORIA", 
                               usuario.getHusanumeiden().toString());
                parameters.put("PER_APELLIDO", usuario.getHuscprimerapel());
                parameters.put("SDO_APELLIDO", usuario.getHuscsegundapel());
                parameters.put("NOMBRES", 
                               usuario.getHuscprimernomb() + " " + usuario.getHuscsegundnomb());
                parameters.put("PROCEDIMIENTO", cirugias);
                parameters.put("FECHA_ATENCION", cirugia.getHcpdfechacirug());
                parameters.put("SIGLAS_LIQUIDOS", siglasLiquidoParentales);
                if(notaEnfeProce){
                    parameters.put("TITULO", "CONTROL DE ENFERMER�A PROCEDIMIENTOS");
                }else{
                    parameters.put("TITULO", "CONTROL DE ENFERMER�A CIRUGIA");
                }

                bytes = 
                        JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, 
                                                        this);
                PdfServletUtils.showPdfDocument(bytes, 
                                                "ControlEnfermeriaCirugia.pdf", 
                                                false);
                setGeneroReporte(true);
                wreporte = "";
            } catch (Exception ex) {
                ex.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar reporte Control de Enfermeria en Cirugia. " + 
                                           ex.getMessage());
                setGeneroReporte(false);
            }
        }
    }
    

    
    
    public void setRegistros(ArrayList registros) {
        this.registros = registros;
    }

    public ArrayList getRegistros() {
        return registros;
    }

    public boolean next() {
        index++;
        return (index < registros.size());
    }

    public Object getFieldValue(JRField jrField) {
        String fieldName = jrField.getName();
        if (wreporte.equals("CONTROL")) {
            if (fieldName.equalsIgnoreCase("hora")) {
                return (Date)((Map)registros.get(index)).get(1);
            }
            if (fieldName.equalsIgnoreCase("ta")) {
                return (String)((Map)registros.get(index)).get(2);
            }
            if (fieldName.equalsIgnoreCase("fc")) {
                return (String)((Map)registros.get(index)).get(3);
            }
            if (fieldName.equalsIgnoreCase("spo2")) {
                return (String)((Map)registros.get(index)).get(4);
            }
            if (fieldName.equalsIgnoreCase("rf")) {
                return (String)((Map)registros.get(index)).get(5);
            }
            if (fieldName.equalsIgnoreCase("to")) {
                return (String)((Map)registros.get(index)).get(6);
            }
            if (fieldName.equalsIgnoreCase("canadm")) {
                return (BigDecimal)((Map)registros.get(index)).get(7);
            }
            if (fieldName.equalsIgnoreCase("viaadm")) {
                return (String)((Map)registros.get(index)).get(8);
            }
            if (fieldName.equalsIgnoreCase("tipoadm")) {
                return (String)((Map)registros.get(index)).get(9);
            }
            if (fieldName.equalsIgnoreCase("caneli")) {
                return (BigDecimal)((Map)registros.get(index)).get(10);
            }
            if (fieldName.equalsIgnoreCase("tipoeli")) {
                return (String)((Map)registros.get(index)).get(11);
            }
            if (fieldName.equalsIgnoreCase("nombre")) {
                return (String)((Map)registros.get(index)).get(12);
            }
            if (fieldName.equalsIgnoreCase("dosis")) {
                return (String)((Map)registros.get(index)).get(13);
            }
            if (fieldName.equalsIgnoreCase("viamed")) {
                return (String)((Map)registros.get(index)).get(14);
            }
            if (fieldName.equalsIgnoreCase("activ")) {
                return (String)((Map)registros.get(index)).get(15);
            }
            if (fieldName.equalsIgnoreCase("respi")) {
                return (String)((Map)registros.get(index)).get(16);
            }
            if (fieldName.equalsIgnoreCase("circula")) {
                return (String)((Map)registros.get(index)).get(17);
            }
            if (fieldName.equalsIgnoreCase("concien")) {
                return (String)((Map)registros.get(index)).get(18);
            }
            if (fieldName.equalsIgnoreCase("satura")) {
                return (String)((Map)registros.get(index)).get(19);
            }
            if (fieldName.equalsIgnoreCase("ambula")) {
                return (String)((Map)registros.get(index)).get(20);
            }
            if (fieldName.equalsIgnoreCase("dolor")) {
                return (String)((Map)registros.get(index)).get(21);
            }
            if (fieldName.equalsIgnoreCase("sangra")) {
                return (String)((Map)registros.get(index)).get(22);
            }
            if (fieldName.equalsIgnoreCase("tolera")) {
                return (String)((Map)registros.get(index)).get(23);
            }
            if (fieldName.equalsIgnoreCase("eliuri")) {
                return (String)((Map)registros.get(index)).get(24);
            }
            if (fieldName.equalsIgnoreCase("aneste")) {
                return (String)((Map)registros.get(index)).get(25);
            }
            if (fieldName.equalsIgnoreCase("enfer")) {
                String wnomenf = (String)((Map)registros.get(index)).get(26);
                wnomenf = getNombreOperadorXUsuario(wnomenf);
                return wnomenf;
            }
            if (null != lstcontrolOrden && !lstcontrolOrden.isEmpty()) {
                if (fieldName.equalsIgnoreCase("horainiciooxigeno")) {
                    if (null == ((Map)registros.get(index)).get(27)) {
                        return null;
                    } else {
                        return (Timestamp)((Map)registros.get(index)).get(27);
                    }
                }
                if (fieldName.equalsIgnoreCase("sistemaoxigeno")) {
                    return (String)((Map)registros.get(index)).get(28);
                }
                if (fieldName.equalsIgnoreCase("litrosoxigeno")) {
                    return (Long)((Map)registros.get(index)).get(29);
                }
                if (fieldName.equalsIgnoreCase("minutooxigeno")) {
                    return (Long)((Map)registros.get(index)).get(32);
                }
                if (fieldName.equalsIgnoreCase("horaterminacionoxigeno")) {
                    return (Timestamp)((Map)registros.get(index)).get(30);
                }

            }
    }
        return null;
}

    public void listenCancelaCirugia(ValueChangeEvent valueChangeEvent) {
        String value = 
            (String)(((UIInput)valueChangeEvent.getComponent()).getValue());
        if (value.equals("S")) {
            renderCancelar = true;
        } else if (value.equals("N")) {
            renderCancelar = false;
        }
    }


    public void listenDolorCirugia(ValueChangeEvent valueChangeEvent) {
        String value = 
            (String)(((UIInput)valueChangeEvent.getComponent()).getValue());
        if (value.equals("S")) {
            renderDolor = true;
        } else if (value.equals("N")) {
            renderDolor = false;
        }
    }


    public void changeEmbarazo() {
        if (hiecresulpruemb != null && hiecresulpruemb.equals("S")) {
            FacesUtils.addErrorMessage("Recuerde Cancelar la cirug�a la prueba de Embarazo sali� positiva.");
        }
    }

    public String cancelarCirugia() {
        cirugia.setHcpcestado("XX");
        cirugia.setHcpcoperaanula(userName());
        cirugia.setHcpdfechaanula(new Date());
        try {
            regicipro = 
                    this.serviceLocator.getCirugiaService().getCirsinfacNumero(cirugia.getHcplnumero());
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (regicipro != null && !regicipro.equals("")) {
            regicipro.setHrccestado("XX");
        }

        ciruanula = new Chciruganula();
        ciruanula.getId().setHcalnumero(cirugia.getHcplnumero());
        ciruanula.setHcadfechaciran(cirugia.getHcpdfechaanula());
        ciruanula.setHcadfechaanula(cirugia.getHcpdfechacirug());
        ciruanula.setHcacoperanula(cirugia.getHcpcoperaanula());
        ciruanula.setHcacobseranula(cirugia.getHcpcobseranula());
        ciruanula.setHcacmotivanula(cirugia.getHcpcmotivanula());

        try {
            serviceLocator.getCirugiaService().updateChcirugprogr(cirugia, 
                                                                  regicipro, 
                                                                  ciruanula);
            FacesUtils.addInfoMessage("MSG_CANCELACION_CIRUGIA");
            renderCancelar = false;
        } catch (ModelException e) {
            e.printStackTrace();
        }
        FacesUtils.resetManagedBean("consultarListaNotasEnfermeria");
        return BeanNavegacion.RUTA_IR_LISTA_NOTAS_ENFERMERIA;
    }


    /**
     * @return
     */
    public String registrarNuevaProceso() {
        Long numeroCirugia = null;
        FacesUtils.resetManagedBean("adicionarCirugiaBean");
        FacesUtils.resetManagedBean("regsitrarNotaEnfermeriaBean");
        AdicionarCirugiaBean adicionarCirugia;
        adicionarCirugia = 
                (AdicionarCirugiaBean)FacesUtils.getManagedBean("adicionarCirugiaBean");

        MantenimientoCirugiasBean mantenimientoCirugia = 
            (MantenimientoCirugiasBean)FacesUtils.getManagedBean("mantenimientoCirugiasBean");
        if (adicionarCirugia != null && cirugia != null) {
            adicionarCirugia.setProgramacion(cirugia);
            usuario = cirugia.getHcplusuario();
            numeroCirugia = cirugia.getHcplnumero();
            adicionarCirugia.init();
        }

        if (mantenimientoCirugia != null && cirugia != null) {
            mantenimientoCirugia.setNumeroCirugia(numeroCirugia);
            mantenimientoCirugia.setUsuario(usuario);
            mantenimientoCirugia.setRenderIconEliminar(true);
            mantenimientoCirugia.cargarConsultas();
        }

        return BeanNavegacion.RUTA_IR_ADICIONAR_CIRUGIA;
    }


    public void muestraCancelar() {
    }

    public void setMostrarAsepsia(boolean mostrarAsepsia) {
        this.mostrarAsepsia = mostrarAsepsia;
    }

    public boolean isMostrarAsepsia() {
        return mostrarAsepsia;
    }

    public void setDetalleCirugia(Chdetacirpro detalleCirugia) {
        this.detalleCirugia = detalleCirugia;
    }

    public Chdetacirpro getDetalleCirugia() {
        return detalleCirugia;
    }

    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }

    public void setRenderCancelar(boolean renderCancelar) {
        this.renderCancelar = renderCancelar;
    }

    public boolean isRenderCancelar() {
        return renderCancelar;
    }

    public void setRadioCancelar(String radioCancelar) {
        this.radioCancelar = radioCancelar;
    }

    public String getRadioCancelar() {
        return radioCancelar;
    }

    public void setRegicipro(Chregicirpro regicipro) {
        this.regicipro = regicipro;
    }

    public Chregicirpro getRegicipro() {
        return regicipro;
    }

    public void setCiruanula(Chciruganula ciruanula) {
        this.ciruanula = ciruanula;
    }

    public Chciruganula getCiruanula() {
        return ciruanula;
    }

    public void setRenderNuevoRegistro(boolean renderNuevoRegistro) {
        this.renderNuevoRegistro = renderNuevoRegistro;
    }

    public boolean isRenderNuevoRegistro() {
        return renderNuevoRegistro;
    }

    public void setLstCirugiasProgramadas(List<Chdetacirpro> lstCirugiasProgramadas) {
        this.lstCirugiasProgramadas = lstCirugiasProgramadas;
    }

    public List<Chdetacirpro> getLstCirugiasProgramadas() {
        return lstCirugiasProgramadas;
    }

    public void setMsgNotaEnfermeriaTransoperatoria(String msgNotaEnfermeriaTransoperatoria) {
        this.msgNotaEnfermeriaTransoperatoria = 
                msgNotaEnfermeriaTransoperatoria;
    }

    public String getMsgNotaEnfermeriaTransoperatoria() {
        return msgNotaEnfermeriaTransoperatoria;
    }

    public void setMsgNotaEnfermeriaAnestesia(String msgNotaEnfermeriaAnestesia) {
        this.msgNotaEnfermeriaAnestesia = msgNotaEnfermeriaAnestesia;
    }

    public String getMsgNotaEnfermeriaAnestesia() {
        return msgNotaEnfermeriaAnestesia;
    }

    public void setMsgNotaEnfermeriaDescripcion(String msgNotaEnfermeriaDescripcion) {
        this.msgNotaEnfermeriaDescripcion = msgNotaEnfermeriaDescripcion;
    }

    public String getMsgNotaEnfermeriaDescripcion() {
        return msgNotaEnfermeriaDescripcion;
    }

    /**
     * @param renderTieneDIU
     */
    public void setRenderTieneDIU(boolean renderTieneDIU) {
        this.renderTieneDIU = renderTieneDIU;
    }

    /**
     * @return
     */
    public boolean isRenderTieneDIU() {
        return renderTieneDIU;
    }

    public void setIngreso(Chingresoenf ingreso) {
        this.ingreso = ingreso;
    }

    public Chingresoenf getIngreso() {
        return ingreso;
    }

    public void setRenderMensajeTieneDIU(boolean renderMensajeTieneDIU) {
        this.renderMensajeTieneDIU = renderMensajeTieneDIU;
    }

    public boolean isRenderMensajeTieneDIU() {
        return renderMensajeTieneDIU;
    }

    public void setRenderPruebaEmbarazo(boolean renderPruebaEmbarazo) {
        this.renderPruebaEmbarazo = renderPruebaEmbarazo;
    }

    public boolean isRenderPruebaEmbarazo() {
        return renderPruebaEmbarazo;
    }

    public void setFechaEmbarazo(Date fechaEmbarazo) {
        this.fechaEmbarazo = fechaEmbarazo;
    }

    public Date getFechaEmbarazo() {
        return fechaEmbarazo;
    }

    public void setHiecresulpruemb(String hiecresulpruemb) {
        this.hiecresulpruemb = hiecresulpruemb;
    }

    public String getHiecresulpruemb() {
        return hiecresulpruemb;
    }

    public void setRenderLigadura(boolean renderLigadura) {
        this.renderLigadura = renderLigadura;
    }

    public boolean isRenderLigadura() {
        return renderLigadura;
    }

    public void setListEscala(List<SelectItem> listEscala) {
        this.listEscala = listEscala;
    }

    public List<SelectItem> getListEscala() {

        if (listEscala == null || listEscala.isEmpty()) {
            listEscala = new ArrayList<SelectItem>();

            listEscala.add(new SelectItem(0, "0"));
            listEscala.add(new SelectItem(1, "1"));
            listEscala.add(new SelectItem(2, "2"));
            listEscala.add(new SelectItem(3, "3"));
            listEscala.add(new SelectItem(4, "4"));
            listEscala.add(new SelectItem(5, "5"));
            listEscala.add(new SelectItem(6, "6"));
            listEscala.add(new SelectItem(7, "7"));
            listEscala.add(new SelectItem(8, "8"));
            listEscala.add(new SelectItem(9, "9"));
            listEscala.add(new SelectItem(10, "10"));

        }

        return listEscala;
    }

    public void setRadioDolor(String radioDolor) {
        this.radioDolor = radioDolor;
    }

    public String getRadioDolor() {
        return radioDolor;
    }

    public void setRenderDolor(boolean renderDolor) {
        this.renderDolor = renderDolor;
    }

    public boolean isRenderDolor() {
        return renderDolor;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setNotaEnfeProce(Boolean notaEnfeProce) {
        this.notaEnfeProce = notaEnfeProce;
    }

    public Boolean getNotaEnfeProce() {
        return notaEnfeProce;
    }

    public void setLegendServicio(String legendServicio) {
        this.legendServicio = legendServicio;
    }

    public String getLegendServicio() {
        return legendServicio;
    }

    public void setLstConsclin(List<Cnconsclin> lstConsclin) {
        this.lstConsclin = lstConsclin;
    }

    public List<Cnconsclin> getLstConsclin() {
        return lstConsclin;
    }

    public void setLegendTablaServicio(String legendTablaServicio) {
        this.legendTablaServicio = legendTablaServicio;
    }

    public String getLegendTablaServicio() {
        return legendTablaServicio;
    }

    public void setLstcontrolOrden(List<Chcontroorden> lstcontrolOrden) {
        this.lstcontrolOrden = lstcontrolOrden;
    }

    public List<Chcontroorden> getLstcontrolOrden() {
        return lstcontrolOrden;
    }

    public void setReferenciaPaciente(Chrefepaci referenciaPaciente) {
        this.referenciaPaciente = referenciaPaciente;
    }

    public Chrefepaci getReferenciaPaciente() {
        return referenciaPaciente;
    }
    
    public void setHrpcrefepaci(ValueChangeEvent valueChangeEvent) {
             referenciaPaciente.setHrpcrefepaci((String)valueChangeEvent.getNewValue());
            ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void changeReferenciaPaciente() {
        renderReferencia = false;
           if("S".equals(referenciaPaciente.getHrpcrefepaci())){
               renderReferencia = true;
           }
    }

    public void setRenderReferencia(boolean renderReferencia) {
        this.renderReferencia = renderReferencia;
    }

    public boolean isRenderReferencia() {
        return renderReferencia;
    }

    public void setListHora(List<SelectItem> listHora) {
        this.listHora = listHora;
    }

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
            listHora.add(new SelectItem("21", "21"));
            listHora.add(new SelectItem("22", "22"));
            listHora.add(new SelectItem("23", "23"));

        }
        return listHora;
    }

    public void setLstMinutos(List<SelectItem> lstMinutos) {
        this.lstMinutos = lstMinutos;
    }

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
            lstMinutos.add(new SelectItem("55", "55|"));
        }
        return lstMinutos;
    }

    public void setListTipoAmbulancia(List<SelectItem> listTipoAmbulancia) {
        this.listTipoAmbulancia = listTipoAmbulancia;
    }

    public List<SelectItem> getListTipoAmbulancia() {
        if (listHora == null) {
            listHora = new ArrayList<SelectItem>();
            listHora.add(new SelectItem("", "Seleccione una opcion"));
            listHora.add(new SelectItem("BA", "B�sica"));
            listHora.add(new SelectItem("ME", "Medicalizada"));
        }
        return listTipoAmbulancia;
    }
}
