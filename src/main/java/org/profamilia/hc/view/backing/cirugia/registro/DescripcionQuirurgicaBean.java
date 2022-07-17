//=======================================================================
// ARCHIVO DescripcionQuirurgicaBean
// FECHA CREACI�N: 
// AUTOR: jariano, andres.vargas
// Descripcion: 
//=======================================================================
// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 29/09/2016 10:18:15 p. m.
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   DescripcionQuirurgicaBean.java

package org.profamilia.hc.view.backing.cirugia.registro;

import java.io.File;

import java.math.BigDecimal;

import java.net.URL;

import java.util.ArrayList;
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

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chambitproce;
import org.profamilia.hc.model.dto.Chantecolpo;
import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chaspectodiu;
import org.profamilia.hc.model.dto.Chcirdetdesc;
import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chcolposcopia;
import org.profamilia.hc.model.dto.Chconducta;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chconsultori;
import org.profamilia.hc.model.dto.Chcontabor;
import org.profamilia.hc.model.dto.Chdescrquiru;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chdetaldescr;
import org.profamilia.hc.model.dto.Chgradodiure;
import org.profamilia.hc.model.dto.Chhallahistero;
import org.profamilia.hc.model.dto.Chhisteroscopia;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.dto.Chregisabort;
import org.profamilia.hc.model.dto.Chtipoaneste;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chusuarioabor;
import org.profamilia.hc.model.dto.Chviolencia;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpocupacio;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cractoquir;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.dto.Crfinalcon;
import org.profamilia.hc.model.dto.Ctacumcosto;
import org.profamilia.hc.model.dto.FichaTecnicaCostosDTO;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.cirugia.busqueda.ListaCirugiaDescripcionQuirurgicaBean;
import org.profamilia.hc.view.backing.cirugia.resumen.GenerarFoliosCirugiaBean;
import org.profamilia.hc.view.backing.clinico.comun.BuscadorCie10Bean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorPlantillaCirugiaBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorServicioBean;
import org.profamilia.hc.view.backing.menus.cirugia.MenuDescripcionBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


public class DescripcionQuirurgicaBean extends BaseBean implements JRDataSource {


    static final int ACTIVAR_MODIFICAR_CIRUGIA = 0;
    static final int ACTIVAR_BUSCADOR_CIRUGIAS = 1;
    private List lstDetalleCirugias;
    private List lstDetalleCirugia;
    private int selectedIndex;
    private Long numeroConsulta;
    private Long numeroUsuario;
    private Chusuario usuario;
    private Chdescrquiru descripcion;
    private Chdetaldescr detalleDescripcion;
    private List lstAmbitoProcedimiento;
    private List lstFinalidad;
    private List lstFormaProcedimiento;
    private List lstHora;
    private List lstMinutos;
    private List lstTipoAnestesia;
    private List lstProfesionales;
    private List lstProfesionalesIntervencion;
    private List lstAnestesiologo;
    private String anestesiologoSelect;
    private String ayudantiaSelect;
    private List lstAnestesiologosSelect;
    private List lstAyudantiaSelect;
    private HtmlDataTable dtAnestesiologo;
    private HtmlDataTable dtAyudantia;
    private boolean renderPlantilla;
    private boolean mostrarCie10;
    private String diagnosticoPreoperatorio;
    private String diagnosticoPosoperatorio;
    private String diagnosticoComplicacion;
    private UIInput itDiagPreoperatorio;
    private UIInput itDiagPostoperatorio;
    private UIInput itDiagComplicacion;
    private UIInput itDescripcion;
    private UIInput itHallazgos;
    private boolean mostrarComplicaciones;
    private String msgComplicaciones;
    private List lstOpciones;
    private Crdgncie10 diagprin;
    private Crdgncie10 diagpost;
    private Crdgncie10 diagCompl;
    private Integer edad;
    private boolean mostrarSangrado;
    private List lstAspectos;
    private List lstGradoHematurica;
    private boolean mostrarDiuresis;
    private boolean mostrarAnatomiaPatologica;
    private boolean renderGrado;
    private BigDecimal codigoMedico;
    private List lstInstrumentador;
    private List lstAyudante;
    private List lstSalasCirugia;
    static final int ACTIVAR_DESCRIPCION_QUIRURGICA = 0;
    static final int ACTIVAR_DESCRIPCION_QUIRURGICA2 = 3;
    static final int ACTIVAR_BUSCADOR_DIAGNOSTICO = 1;
    static final int ACTIVAR_BUSCADOR_PLANTILLAS = 2;
    private int index;
    private List lstHistorialLiquidosEliminados;
    private List lstLiquidosAdministrados;
    private List lstLiquidosParciales;
    private boolean generoReporte;
    private boolean renderBuscadorServicio;
    private String seleccionServicio;
    private List lstCirugias;
    private Cpservicio servicio;
    private boolean deshabilitarServicio;
    private boolean registrarCirugia;
    private Chcirdetdesc regcirpro;
    private HtmlDataTable dtServicios;
    private HtmlDataTable dtServiciosPracticados;
    private List lstImpresion;
    private String diagPre;
    private Crdgncie10 diagprincipal;
    private Crdgncie10 diagrelaciona;
    private HtmlDataTable dtCirugias;
    private List lstDescDetalle;
    private Object detalleDesc[];
    private Chantegineco antecedentes;
    private Chdetacirpro detaciru;
    private Chcirugprogr cirugiaProgra;
    private String servicioDetalle;
    private String etapaCirugia;
    private String residente;
    private boolean renderInstrumentador;
    private MenuDescripcionBean menuDescripcion;
    private boolean renderResidente;
    private List lstCirculante;
    private String labelEncabezado;
    private String labelfielSet; 
    private String labelSala;
    private String labelfielSet2; 
    private String labeltiempo; 
    private String labelInstrumentacion; 
    private String labelDescripcion; 
    private String labelProcedimientoPracticado; 
    private String labelfielSet3; 
    private String labelHallazgos; 
    private String labelIntervecionesPropuestas;
    private String labelIntervecionesPracticadas;
    private Chconsulta chconsulta= new Chconsulta();
    
    private boolean renderAyudante1;
    
    private boolean renderAyudante2;
    
    private boolean modoConsulta;
    
    private Chhisteroscopia histeroscopia;
    
    private Chhallahistero hallazgoHis;
    
    private List lstMedioDistencion;
    
    private boolean renderObliIntrumentador;
    
    private boolean mostrarHallazgos;
    
    private UIInput itCantRecolectada;
    
    private UIInput itCantIrrigada;
    private String msgElectrolitros;


    /** Fiels Requeridos en el Reporte */
    private Date FECHAHISTERO;
    private String HISTORIACLINICA;  
    private String PRIMERAPELLIDO;  
    private String SEGUNDOAPELLIDO;  
    private String NOMBRE;  
    private String CLINICAHISTERO;  
    private String SALA;  
    private String EDADHISTERO;  
    private String CIRUJANO;  
    private String TIEMPOQUIRURGICO;  
    private String ANESTESIOLOGO;  
    private String TIPOANESTESIA;  
    private String AYUDANTE;  
    private String AYUDANTE2;  
    private String INSTRUMENTACION;  
    private String CIRCULANTE;  
    private String DIAGPRINCIPAL;  
    private String DIAGRELACIONADO;  
    private String INTERVENCIONPROPUESTA;  
    private String MEDIODISTENCION;  
    private String CANTIDADIRRIGADA;  
    private String CANTIDADRECOLECTADA;  
    private String BALANCE;  
    private String POSITIVONEGATIVO;  
    private String HALLAZGOS;  
    private String VAGINOSCOPIA;  
    private String CANALENDOCERVICAL;  
    private String ASPECTOENDOMETRIO;  
    private String OSTIUMSTUBARICO;  
    private String MASAINTRACAVITARIA;  
    private String OTROSHOISTERO;  
    private String DESCRIPCIONPROCED;  
    private String PATOLOGIA;  
    private String SANGRADOHISTERO;  
    private String CUANTIFICADO;  
    private String CANTIDAD;  
    private String COMPLICACION;  
    private String DIAGCOMPLICACION;  
    private String DESCRIPCOMPLIC;  
    private String NOMBREPORFESIONAL;  
    private String REGISTROPROFESIONAL;
    private String INTERVENCIONPRACTICADA;  
    private Boolean anestOblig;
    private boolean mostrarSangradoCuanti;
    private boolean mostrarDiureCuanti;
    
    //campos agregados CJET
    private boolean renderAnestesiologo;
    private UIInput mnuTipoAnestesia;
    private List lstAnestesiologosSelectAux;
    private Cpservicio ser;
    private List<FichaTecnicaCostosDTO>lstServicios;
    private boolean flagCostos;
    private HtmlDataTable dtServiciosCostos;
        
        
    public DescripcionQuirurgicaBean() {
        anestOblig=false;
        lstAnestesiologosSelectAux = new ArrayList();
    if(detalleDescripcion == null){
        detalleDescripcion = new Chdetaldescr();
    }
        
        lstAnestesiologosSelect = new ArrayList();
        lstAyudantiaSelect = new ArrayList();
        dtAnestesiologo = new HtmlDataTable();
        dtAyudantia = new HtmlDataTable();
        renderResidente = false;

    }

    public void init() {
        dtCirugias = new HtmlDataTable();
        lstCirugias = new ArrayList();
        ser = new Cpservicio();

        renderObliIntrumentador = false;
        modoConsulta = false; 
        mostrarHallazgos=false;
        anestOblig=false;
       
  
        labelEncabezado = "Registrar Descripci�n Quir�rgica";
        labelfielSet = "Cirug�a(s) Programada(s)"; 
        labelSala = "Sala de Cirug�a";
        labelfielSet2 = "Descripci�n Quir�rgica"; 
        labeltiempo = "Tiempo Quir�rgico"; 
        labelInstrumentacion = "Instrumentador"; 
        labelDescripcion = "Descripci�n de la Cirug�a"; 
        labelProcedimientoPracticado= "Intervenci�n(es) practicadas(s)"; 
        labelHallazgos= "Hallazgos Quir�rgicos"; 
        labelfielSet3 = "Datos de la cirug�a";
        labelIntervecionesPropuestas = "Intervenci�n(es) Propuesta(s)	";
        labelIntervecionesPracticadas = "Intervenci�n(es) Practicada(s)	";

  
        if (lstDetalleCirugias != null && lstDetalleCirugias.size() == 1) {

            Chdetacirpro detaciru = (Chdetacirpro)lstDetalleCirugias.get(0);
            Cpservicio servicioIni = null;

            servicioDetalle = detaciru.getId().getHdccservicio();
            try {
                servicioIni = 
                        this.serviceLocator.getClinicoService().getServicioPorId(servicioDetalle);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            
        if(servicioIni != null && servicioIni.getCsvntiphis() != null && servicioIni.getCsvntiphis().equals(44)){
            labelEncabezado = "Registrar Descripci�n Procedimiento";
            labelfielSet = "Procedimiento programado"; 
            labelSala = "Sala de Procedimientos";
            labelfielSet2 = "Descripci�n del Procedimiento"; 
            labeltiempo = "Tiempo de Procedimiento"; 
            labelInstrumentacion = "Instrumentaci�n"; 
            labelDescripcion = "Descripci�n del Procedimiento"; 
            labelProcedimientoPracticado= "Procedimiento(s) practicados(s)"; 
            labelHallazgos= "Hallazgos procedimiento"; 
            labelfielSet3 = "Datos del procedimiento";
            labelIntervecionesPropuestas = "Procedimiento(s) Propuesto(s)   ";
            labelIntervecionesPracticadas = "Procedimiento(es) Practicado(s) ";

        }
        if(servicioIni != null){
            lstCirugias.add(servicioIni);
        }
        
            if(servicioIni != null && servicioIni.getCsvntiphis() != null && !servicioIni.getCsvntiphis().equals(CIRUGIA_VASECTOMIA)){
                renderObliIntrumentador = true;
            }
            System.out.println("El estado de la variable es: " + renderObliIntrumentador );

        }
        
             
        registrarCirugia = true;
        
        renderInstrumentador = false;
        etapaCirugia = ETAPA_CIRUGIA_EN_RECUPERACION;
        if (usuario != null && usuario.getHusdfechanacim() != null)
            edad = Integer.valueOf(calcularEdad(usuario.getHusdfechanacim(), new Date()));
        if (numeroConsulta != null) {
            try {
                descripcion = 
                        serviceLocator.getCirugiaService().getDescripcionQuirurgica(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            try {
                cirugiaProgra = 
                        serviceLocator.getClinicoService().getProgramarCirugia(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

       
        if (usuario != null) {
            Object lstImpresionaux[] = null;
            try {
                lstImpresionaux = 
                        serviceLocator.getCirugiaService().getUltimaValoracionPreUsuario(usuario.getHuslnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (lstImpresionaux == null)
                FacesUtils.addInfoMessage("Este usuario no tiene valoraci�n preoperatoria");
            if (lstImpresionaux != null) {

                detalleDescripcion.setHddcdiagnprinc((String)lstImpresionaux[0]);
                detalleDescripcion.setHddcdiagnrelac((String)lstImpresionaux[1]);
                if (detalleDescripcion != null && 
                    !detalleDescripcion.equals("") || 
                    !detalleDescripcion.getHddcdiagnprinc().equals("Z000") && 
                    !detalleDescripcion.getHddcdiagnrelac().equals("Z000") || 
                    !detalleDescripcion.getHddcdiagnprinc().equals("") && 
                    !detalleDescripcion.getHddcdiagnrelac().equals("")) {
                    try {
                        if (detalleDescripcion.getHddcdiagnprinc() != null) {
                            diagprincipal = 
                                    serviceLocator.getClinicoService().getCIE10PorCodigo(detalleDescripcion.getHddcdiagnprinc().toUpperCase());
                        }
                        if (detalleDescripcion.getHddcdiagnrelac() != null) {
                            diagrelaciona = 
                                    serviceLocator.getClinicoService().getCIE10PorCodigo(detalleDescripcion.getHddcdiagnrelac().toUpperCase());
                        }
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }


                    if (diagprincipal != null && 
                        diagprincipal.getCdcccodigo() != null)
                        diagnosticoPreoperatorio = 
                                diagprincipal.getCdccdescri();

                    if (diagrelaciona != null && 
                        diagrelaciona.getCdcccodigo() != null) {
                        diagnosticoPosoperatorio = 
                                diagrelaciona.getCdccdescri();
                    } else {
                        diagnosticoPosoperatorio = " ";
                    }
                }


            }
        }
        if (descripcion == null) {
            descripcion = new Chdescrquiru();
            descripcion.setHdqnambito(Integer.valueOf(1));
            detalleDescripcion.setHddctienepiepa("N");
            detalleDescripcion.setHddctienesangr("N");
            detalleDescripcion.setHddcanotardiur("N");
            detalleDescripcion.setHddctienecompl("N");
            detalleDescripcion.setHddntiempohora(0);
            detalleDescripcion.setHddntiempominu(0);
            detalleDescripcion.setHddcmediayud1(new BigDecimal(-1));
            detalleDescripcion.setHddcmediayud2(new BigDecimal(-1));
            if (lstDetalleCirugias != null) {
                for (Iterator iterator = lstDetalleCirugias.iterator(); 
                     iterator.hasNext(); ) {
                    Chdetacirpro ciru = (Chdetacirpro)iterator.next();
                    if (ciru.getId().getHdccservicio() != null && 
                        ciru.getId().getHdccservicio().equals("S662200.0") || 
                        ciru.getId().getHdccservicio().equals("S662200") || 
                        ciru.getId().getHdccservicio().equals("662200.0") || 
                        ciru.getId().getHdccservicio().equals("662202") || 
                        ciru.getId().getHdccservicio().equals("S662202") || 
                        ciru.getId().getHdccservicio().equals("S637300") || 
                        ciru.getId().getHdccservicio().equals("637300")) {
                        detalleDescripcion.setHddnfinalidad(Integer.valueOf(3));
                        detalleDescripcion.setHddcdiagnprinc("Z302");
                        detalleDescripcion.setHddcdiagnrelac("Z302");
                        detalleDescripcion.setHddntiempohora(0);
                        detalleDescripcion.setHddntiempominu(10);
                        try {
                            diagprincipal =  serviceLocator.getClinicoService().getCIE10PorCodigo("Z302");
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }
                        if (diagprincipal != null && 
                            diagprincipal.getCdcccodigo() != null)
                            diagnosticoPreoperatorio = 
                                    diagprincipal.getCdccdescri();
                        diagnosticoPosoperatorio = diagprincipal.getCdccdescri();
                        descripcion.setHdqnformareali(Integer.valueOf(3));
                    }
                }

            }
            if (cirugiaProgra != null) {

                descripcion.setHdqnsalacirugi(cirugiaProgra.getHcpnsalainterv());
                descripcion.setHdqdfechaproce(cirugiaProgra.getHcpdfechacirug());
                detalleDescripcion.setHddctipoaneste(cirugiaProgra.getHcpctipoaneste());
                detalleDescripcion.setHddcanestesiol(cirugiaProgra.getHcpcanestesiol());
                detalleDescripcion.setHddcayudante1(cirugiaProgra.getHcpcprofeayuda());
                anestesiologoSelect = detalleDescripcion.getHddcanestesiol();
                residente = cirugiaProgra.getHcpcnomresiden();
                if (anestesiologoSelect != null)
                    agregarAnestesiologo();

                ayudantiaSelect = detalleDescripcion.getHddcayudante1();
                if (ayudantiaSelect != null)
                    agregarAyudantia();
            }
        }else{
            
            modoConsulta = true; 
        }
        
       

        if (lstDetalleCirugias != null && lstDetalleCirugias.size() == 1) {

            Chdetacirpro detaciru = (Chdetacirpro)lstDetalleCirugias.get(0);

            servicioDetalle = detaciru.getId().getHdccservicio();
            try {
                servicio = 
                        this.serviceLocator.getClinicoService().getServicioPorId(servicioDetalle);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (servicio.getCsvntiphis().equals(IConstantes.CIRUGIA_IVE)) {
                renderInstrumentador = true;
            }

        }
        
        if(null==histeroscopia){
            histeroscopia= new Chhisteroscopia();
        }
        if(hallazgoHis == null){
            hallazgoHis= new Chhallahistero();
        }
        
        changeHallazgo();
        changeBalance();
        flagCostos = activarFuncionalidadCostos();
        if(flagCostos){
            try {
            if(servicio !=null){
                lstServicios = serviceLocator.getCostosService().getServiciosByInsumo(servicio.getCsvccodigo());
            }
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(e.getMessage());
            }
        }
    }

    public String imprimirDescripcion() {
        Chdetacirpro detaCir =  (Chdetacirpro)dtCirugias.getRowData();
        GenerarFoliosCirugiaBean bean = (GenerarFoliosCirugiaBean)FacesUtils.getManagedBean("generarFoliosCirugiaBean");
        byte[] result = null;
        Chcirugprogr cirugiaAux = null;
        Chusuario usuario = null;
        try {
            cirugiaAux = this.serviceLocator.getCirugiaService().getFolioCirugiaCompleto(detaCir.getId().getHdclconsuprinc());
            usuario = this.serviceLocator.getClinicoService().getUsuario(detaCir.getHdclusuario());
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (bean != null && cirugiaAux != null && usuario != null) {       
            result = bean.generarDescripcionQuirurgica(usuario, cirugiaAux, -1);
        }
        if (result != null) {
            PdfServletUtils.showPdfDocument(result,"DescripcionQuirurgica.pdf", false);
            setGeneroReporte(true);
        } else {
            FacesUtils.addErrorMessage("No pudo generar Reporte Descripci�n Quirurgica. ");
            setGeneroReporte(false);
       }
        return null;
    }




    public void renderServicio() {
        renderBuscadorServicio = true;
        selectedIndex = 3;
        BuscadorServicioBean buscador = 
            (BuscadorServicioBean)FacesUtils.getManagedBean("buscadorServicioBean");
    }

    public void aceptarServicio() {
        BuscadorServicioBean servicioAux = 
            (BuscadorServicioBean)FacesUtils.getManagedBean("buscadorServicioBean");
        lstCirugias = new ArrayList();
        if (servicioAux != null && servicioAux.getServicioSelect() != null) {
            lstCirugias.add(servicioAux.getServicioSelect());
            seleccionServicio = 
                    servicioAux.getServicioSelect().getCsvcnombre();
            deshabilitarServicio = true;
        }
        selectedIndex = 0;
        renderBuscadorServicio = false;
        FacesUtils.resetManagedBean("buscadorServicioBean");
    }
    
    
    
    
    /*Aceptar a tabla de servicios */
   
    
    

    public void eliminarCirugia() {
        Cpservicio servicioSelec = (Cpservicio)dtServicios.getRowData();
        lstCirugias.remove(servicioSelec);
        if (lstCirugias != null && !lstCirugias.isEmpty()) {
            for (Iterator iterator = lstCirugias.iterator(); 
                 iterator.hasNext(); ) {
                Cpservicio servicio = (Cpservicio)iterator.next();
                String codigoServicio = servicio.getCsvccodigo();
            }

        }
    }
    
    
    
  

    public void setLstDetalleCirugias(List lstDetalleCirugias) {
        this.lstDetalleCirugias = lstDetalleCirugias;
    }

    public List getLstDetalleCirugias() {
        return lstDetalleCirugias;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setDescripcion(Chdescrquiru descripcion) {
        this.descripcion = descripcion;
    }

    public Chdescrquiru getDescripcion() {
        return descripcion;
    }

    public void setMostrarDiuresis(boolean mostrarDiuresis) {
        this.mostrarDiuresis = mostrarDiuresis;
    }

    public boolean isMostrarDiuresis() {
        return mostrarDiuresis;
    }

    public void setRenderGrado(boolean renderGrado) {
        this.renderGrado = renderGrado;
    }

    public boolean isRenderGrado() {
        return renderGrado;
    }

    public void setLstAmbitoProcedimiento(List lstAmbitoProcedimiento) {
        this.lstAmbitoProcedimiento = lstAmbitoProcedimiento;
    }

    public List getLstAmbitoProcedimiento() throws ModelException {
        if (lstAmbitoProcedimiento == null || 
            lstAmbitoProcedimiento.isEmpty()) {
            lstAmbitoProcedimiento = new ArrayList();
            ArrayList lstAmbitoAux = null;
            try {
                lstAmbitoAux = 
                        (ArrayList)getServiceLocator().getClinicoService().getAmbitoProcedimiento();
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (!lstAmbitoAux.isEmpty()) {
                lstAmbitoProcedimiento.add(new SelectItem("", 
                                                          "Seleccione una opcion ..."));
                Iterator it = lstAmbitoAux.iterator();
                for (int i = 0; it.hasNext(); i++) {
                    it.next();
                    lstAmbitoProcedimiento.add(new SelectItem(((Chambitproce)lstAmbitoAux.get(i)).getHabccodigo(), 
                                                              ((Chambitproce)lstAmbitoAux.get(i)).getHabcdescripcio()));
                }

            }
        }
        return lstAmbitoProcedimiento;
    }

    public void setLstAspectos(List lstAspectos) {
        this.lstAspectos = lstAspectos;
    }

    public List getLstAspectos() {
        if (lstAspectos == null || lstAspectos.isEmpty()) {
            lstAspectos = new ArrayList();
            ArrayList lstAspectosAux = null;
            try {
                lstAspectosAux = 
                        (ArrayList)getServiceLocator().getClinicoService().getAspectosDiuresis();
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (!lstAspectosAux.isEmpty()) {
                Iterator it = lstAspectosAux.iterator();
                for (int i = 0; it.hasNext(); i++) {
                    it.next();
                    lstAspectos.add(new SelectItem(((Chaspectodiu)lstAspectosAux.get(i)).getHadccodigo(), 
                                                   ((Chaspectodiu)lstAspectosAux.get(i)).getHadcdescripcio()));
                }

            }
        }
        return lstAspectos;
    }

    public void setLstGradoHematurica(List lstGradoHematurica) {
        this.lstGradoHematurica = lstGradoHematurica;
    }

    public List getLstGradoHematurica() {
        if (lstGradoHematurica == null || lstGradoHematurica.isEmpty()) {
            lstGradoHematurica = new ArrayList();
            ArrayList lstGradoAux = null;
            try {
                lstGradoAux = 
                        (ArrayList)getServiceLocator().getClinicoService().getGradoDiuresis();
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (!lstGradoAux.isEmpty()) {
                lstGradoHematurica.add(new SelectItem("", 
                                                      "Seleccione una opcion ..."));
                Iterator it = lstGradoAux.iterator();
                for (int i = 0; it.hasNext(); i++) {
                    it.next();
                    lstGradoHematurica.add(new SelectItem(((Chgradodiure)lstGradoAux.get(i)).getHgdccodigo(), 
                                                          ((Chgradodiure)lstGradoAux.get(i)).getHgdcdescripcio()));
                }

            }
        }
        return lstGradoHematurica;
    }

    public void setLstFinalidad(List lstFinalidad) {
        this.lstFinalidad = lstFinalidad;
    }

    public List getLstFinalidad() {
        if (lstFinalidad == null || lstFinalidad.isEmpty()) {
            lstFinalidad = new ArrayList();
            ArrayList lstFinalidadesAux = null;
            try {
                lstFinalidadesAux = 
                        (ArrayList)getServiceLocator().getClinicoService().getFinalidadesConsultaVG("P");
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (!lstFinalidadesAux.isEmpty()) {
                lstFinalidad.add(new SelectItem("", 
                                                "Seleccione una opcion ..."));
                Iterator it = lstFinalidadesAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    if (!((Crfinalcon)lstFinalidadesAux.get(i)).getId().getCfcncodigo().equals(Integer.valueOf(20))) {
                        lstFinalidad.add(new SelectItem(((Crfinalcon)lstFinalidadesAux.get(i)).getId().getCfcncodigo(), 
                                                        ((Crfinalcon)lstFinalidadesAux.get(i)).getCfccdescri()));
                        i++;
                    }
                }
            }
        }
        return lstFinalidad;
    }

    public void setLstFormaProcedimiento(List lstFormaProcedimiento) {
        this.lstFormaProcedimiento = lstFormaProcedimiento;
    }

    public List getLstFormaProcedimiento() {
        if (lstFormaProcedimiento == null || lstFormaProcedimiento.isEmpty()) {
            lstFormaProcedimiento = new ArrayList();
            ArrayList lstActosAux = null;
            try {
                lstActosAux = 
                        (ArrayList)getServiceLocator().getClinicoService().getActoQuirurgico();
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (!lstActosAux.isEmpty()) {
                lstFormaProcedimiento.add(new SelectItem("", 
                                                         "Seleccione una opcion ..."));
                Iterator it = lstActosAux.iterator();
                for (int i = 0; it.hasNext(); i++) {
                    it.next();
                    lstFormaProcedimiento.add(new SelectItem(((Cractoquir)lstActosAux.get(i)).getCaqncodigo(), 
                                                             ((Cractoquir)lstActosAux.get(i)).getCaqcdescri()));
                }

            }
        }
        return lstFormaProcedimiento;
    }

    public void setLstHora(List lstHora) {
        this.lstHora = lstHora;
    }

    public List getLstHora() {
        if (lstHora == null || lstHora.isEmpty()) {
            lstHora = new ArrayList();
            lstHora.add(new SelectItem("", "--"));
            lstHora.add(new SelectItem(Integer.valueOf(0), "0"));
            lstHora.add(new SelectItem(Integer.valueOf(1), "1"));
            lstHora.add(new SelectItem(Integer.valueOf(2), "2"));
            lstHora.add(new SelectItem(Integer.valueOf(3), "3"));
            lstHora.add(new SelectItem(Integer.valueOf(4), "4"));
            lstHora.add(new SelectItem(Integer.valueOf(5), "5"));
            lstHora.add(new SelectItem(Integer.valueOf(6), "6"));
            lstHora.add(new SelectItem(Integer.valueOf(7), "7"));
            lstHora.add(new SelectItem(Integer.valueOf(8), "8"));
            lstHora.add(new SelectItem(Integer.valueOf(9), "9"));
        }
        return lstHora;
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

    public void setLstMinutos(List lstMinutos) {
        this.lstMinutos = lstMinutos;
    }

    public List getLstMinutos() {
        if (lstMinutos == null || lstMinutos.isEmpty()) {
            lstMinutos = new ArrayList();
            lstMinutos.add(new SelectItem("", "--"));
            lstMinutos.add(new SelectItem(Integer.valueOf(0), "00"));
            lstMinutos.add(new SelectItem(Integer.valueOf(5), "05"));
            lstMinutos.add(new SelectItem(Integer.valueOf(10), "10"));
            lstMinutos.add(new SelectItem(Integer.valueOf(15), "15"));
            lstMinutos.add(new SelectItem(Integer.valueOf(20), "20"));
            lstMinutos.add(new SelectItem(Integer.valueOf(25), "25"));
            lstMinutos.add(new SelectItem(Integer.valueOf(30), "30"));
            lstMinutos.add(new SelectItem(Integer.valueOf(35), "35"));
            lstMinutos.add(new SelectItem(Integer.valueOf(40), "40"));
            lstMinutos.add(new SelectItem(Integer.valueOf(45), "45"));
            lstMinutos.add(new SelectItem(Integer.valueOf(50), "50"));
            lstMinutos.add(new SelectItem(Integer.valueOf(55), "55"));
        }
        return lstMinutos;
    }

    public void setLstTipoAnestesia(List lstTipoAnestesia) {
        this.lstTipoAnestesia = lstTipoAnestesia;
    }

    public List getLstTipoAnestesia() {
        if (lstTipoAnestesia == null || lstTipoAnestesia.isEmpty()) {
            lstTipoAnestesia = new ArrayList();
            ArrayList lstAnestesiaAux = null;
            try {
                lstAnestesiaAux = 
                        (ArrayList)getServiceLocator().getClinicoService().getTipoAnestesia();
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (!lstAnestesiaAux.isEmpty()) {
                lstTipoAnestesia.add(new SelectItem("", 
                                                    "Seleccione una opcion ..."));
                Iterator it = lstAnestesiaAux.iterator();
                for (int i = 0; it.hasNext(); i++) {
                    it.next();
                    lstTipoAnestesia.add(new SelectItem(((Chtipoaneste)lstAnestesiaAux.get(i)).getHtaccodigo(), 
                                                        ((Chtipoaneste)lstAnestesiaAux.get(i)).getHtacdescripcio()));
                }

            }
        }
        return lstTipoAnestesia;
    }

    public void setLstProfesionales(List lstProfesionales) {
        this.lstProfesionales = lstProfesionales;
    }

    public List getLstProfesionales() {
        if (lstProfesionales == null || lstProfesionales.isEmpty()) {
            lstProfesionales = new ArrayList();
            ArrayList listProfesionalesAux = null;
            try {
                listProfesionalesAux = 
                        (ArrayList)serviceLocator.getCirugiaService().getListaMedicosClinica(getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (!listProfesionalesAux.isEmpty()) {
                Iterator it = listProfesionalesAux.iterator();
                int i = 0;
                lstProfesionales.add(new SelectItem("", 
                                                    "Seleccione una opci\363n ..."));
                                                    
                lstProfesionales.add(new SelectItem(new BigDecimal(-1), 
                                                    "No Aplica"));
                while (it.hasNext()) {
                    it.next();
                    lstProfesionales.add(new SelectItem(((Cpprofesio)listProfesionalesAux.get(i)).getId().getCpfncodigo(), 
                                                        ((Cpprofesio)listProfesionalesAux.get(i)).getCpfcnombre()));
                    i++;
                }
            }
        }
        return lstProfesionales;
    }


    public void setLstProfesionalesIntervencion(List lstProfesionalesIntervencion) {
        this.lstProfesionalesIntervencion = lstProfesionalesIntervencion;
    }

    public List getLstProfesionalesIntervencion() {
        if (lstProfesionalesIntervencion == null || 
            lstProfesionalesIntervencion.isEmpty()) {
            lstProfesionalesIntervencion = new ArrayList();
            ArrayList listProfesionalesAux = null;
            try {
                listProfesionalesAux = 
                        (ArrayList)serviceLocator.getCirugiaService().getListaMedicosClinica(getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (!listProfesionalesAux.isEmpty()) {
                Iterator it = listProfesionalesAux.iterator();
                int i = 0;
                lstProfesionalesIntervencion.add(new SelectItem("", 
                                                                "Seleccione una opci\363n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstProfesionalesIntervencion.add(new SelectItem(((Cpprofesio)listProfesionalesAux.get(i)).getId().getCpfncodigo(), 
                                                                    ((Cpprofesio)listProfesionalesAux.get(i)).getCpfcnombre()));
                    i++;
                }
            }
        }
        return lstProfesionalesIntervencion;
    }


    public void setLstInstrumentador(List lstInstrumentador) {
        this.lstInstrumentador = lstInstrumentador;
    }

    public List getLstInstrumentador() {
        if (lstInstrumentador == null || lstInstrumentador.isEmpty()) {
            lstInstrumentador = new ArrayList();
            ArrayList listInstrumentadorAux = null;
            try {
                listInstrumentadorAux = 
                        (ArrayList)serviceLocator.getClinicoService().getListaMedicoXEspecialidad(getClinica().getCclncodigo(), 
                                                                                                  ESPECIALIDAD_INSTRUMENTADOR);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            
            lstInstrumentador.add(new SelectItem("", 
                                                 "Seleccione una opci�n ..."));
            lstInstrumentador.add(new SelectItem(new BigDecimal(-1), 
                                                 "No Aplica"));
            
            if (listInstrumentadorAux != null && !listInstrumentadorAux.isEmpty()) {
                Iterator it = listInstrumentadorAux.iterator();
                int i = 0;
                
                while (it.hasNext()) {
                    it.next();
                    lstInstrumentador.add(new SelectItem(((Cpprofesio)listInstrumentadorAux.get(i)).getId().getCpfncodigo(), 
                                                         ((Cpprofesio)listInstrumentadorAux.get(i)).getCpfcnombre()));
                    i++;
                }
            }
        }
        return lstInstrumentador;
    }

    public void setAnestesiologoSelect(String anestesiologoSelect) {
        this.anestesiologoSelect = anestesiologoSelect;
    }

    public String getAnestesiologoSelect() {
        return anestesiologoSelect;
    }

    public void setLstAnestesiologosSelect(List lstAnestesiologosSelect) {
        this.lstAnestesiologosSelect = lstAnestesiologosSelect;
    }

    public List getLstAnestesiologosSelect() {
        return lstAnestesiologosSelect;
    }

    public void setDtAnestesiologo(HtmlDataTable dtAnestesiologo) {
        this.dtAnestesiologo = dtAnestesiologo;
    }

    public HtmlDataTable getDtAnestesiologo() {
        return dtAnestesiologo;
    }

    public void setLstAnestesiologo(List lstAnestesiologo) {
        this.lstAnestesiologo = lstAnestesiologo;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setNumeroUsuario(Long numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    public void setDetalleDescripcion(Chdetaldescr detalleDescripcion) {
        this.detalleDescripcion = detalleDescripcion;
    }

    public Chdetaldescr getDetalleDescripcion() {
        return detalleDescripcion;
    }

    public void setCodigoMedico(BigDecimal codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    public BigDecimal getCodigoMedico() {
        return codigoMedico;
    }

    public void setMsgComplicaciones(String msgComplicaciones) {
        this.msgComplicaciones = msgComplicaciones;
    }

    public String getMsgComplicaciones() {
        return msgComplicaciones;
    }

    public void setRenderPlantilla(boolean renderPlantilla) {
        this.renderPlantilla = renderPlantilla;
    }

    public boolean isRenderPlantilla() {
        return renderPlantilla;
    }

    public void setMostrarCie10(boolean mostrarCie10) {
        this.mostrarCie10 = mostrarCie10;
    }

    public boolean isMostrarCie10() {
        return mostrarCie10;
    }

    public void setDiagnosticoPosoperatorio(String diagnosticoPosoperatorio) {
        this.diagnosticoPosoperatorio = diagnosticoPosoperatorio;
    }

    public String getDiagnosticoPosoperatorio() {
        return diagnosticoPosoperatorio;
    }

    public Long getNumeroUsuario() {
        return numeroUsuario;
    }

    public void setDiagnosticoPreoperatorio(String diagnosticoPreoperatorio) {
        this.diagnosticoPreoperatorio = diagnosticoPreoperatorio;
    }

    public String getDiagnosticoPreoperatorio() {
        return diagnosticoPreoperatorio;
    }

    public void setDiagnosticoComplicacion(String diagnosticoComplicacion) {
        this.diagnosticoComplicacion = diagnosticoComplicacion;
    }

    public String getDiagnosticoComplicacion() {
        return diagnosticoComplicacion;
    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setMostrarSangrado(boolean mostrarSangrado) {
        this.mostrarSangrado = mostrarSangrado;
    }

    public boolean isMostrarSangrado() {
        return mostrarSangrado;
    }

    public void setLstSalasCirugia(List lstSalasCirugia) {
        this.lstSalasCirugia = lstSalasCirugia;
    }

    public List getLstSalasCirugia() {
        if (lstSalasCirugia == null) {
            lstSalasCirugia = new ArrayList();
            ArrayList lstSalasAux = null;
            Integer tipoSala = Integer.valueOf(2);
            try {
                lstSalasAux = 
                        (ArrayList)getServiceLocator().getCirugiaService().getConsultoriosXClinica(tipoSala, 
                                                                                                   getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }


            if (lstSalasAux != null && !lstSalasAux.isEmpty()) {
                lstSalasCirugia.add(new SelectItem("", 
                                                   "Seleccione una opcion ..."));
                Iterator it = lstSalasAux.iterator();
                for (int i = 0; it.hasNext(); i++) {
                    it.next();
                    lstSalasCirugia.add(new SelectItem(((Chconsultori)lstSalasAux.get(i)).getId().getHconnumero(), 
                                                       ((Chconsultori)lstSalasAux.get(i)).getHcocdescripcio()));
                }

            }
        }
        return lstSalasCirugia;
    }

    public void setItDiagPreoperatorio(UIInput itDiagPreoperatorio) {
        this.itDiagPreoperatorio = itDiagPreoperatorio;
    }

    public UIInput getItDiagPreoperatorio() {
        return itDiagPreoperatorio;
    }

    public void setItDiagPostoperatorio(UIInput itDiagPostoperatorio) {
        this.itDiagPostoperatorio = itDiagPostoperatorio;
    }

    public UIInput getItDiagPostoperatorio() {
        return itDiagPostoperatorio;
    }

    public void setItDiagComplicacion(UIInput itDiagComplicacion) {
        this.itDiagComplicacion = itDiagComplicacion;
    }

    public UIInput getItDiagComplicacion() {
        return itDiagComplicacion;
    }

    public void setItDescripcion(UIInput itDescripcion) {
        this.itDescripcion = itDescripcion;
    }

    public UIInput getItDescripcion() {
        return itDescripcion;
    }

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }

    public void setMostrarAnatomiaPatologica(boolean mostrarAnatomiaPatologica) {
        this.mostrarAnatomiaPatologica = mostrarAnatomiaPatologica;
    }

    public boolean isMostrarAnatomiaPatologica() {
        return mostrarAnatomiaPatologica;
    }

    public void setMostrarComplicaciones(boolean mostrarComplicaciones) {
        this.mostrarComplicaciones = mostrarComplicaciones;
    }

    public boolean isMostrarComplicaciones() {
        return mostrarComplicaciones;
    }

    public List getLstAnestesiologo() {
        if (lstAnestesiologo == null || lstAnestesiologo.isEmpty()) {
            lstAnestesiologo = new ArrayList();
            ArrayList listProfesionalesAux = null;
            try {
                listProfesionalesAux = 
                        (ArrayList)serviceLocator.getClinicoService().getListaAnestesiologoClinica(getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            
            lstAnestesiologo.add(new SelectItem("", 
                                                "Seleccione una opci�n ..."));
                                                
            lstAnestesiologo.add(new SelectItem(new BigDecimal(-1), 
                                                 "No Aplica"));
            if (listProfesionalesAux != null && !listProfesionalesAux.isEmpty()) {
                Iterator it = listProfesionalesAux.iterator();
                int i = 0;
               
                while (it.hasNext()) {
                    it.next();
                    lstAnestesiologo.add(new SelectItem(((Cpprofesio)listProfesionalesAux.get(i)).getId().getCpfncodigo().toString(), 
                                                        ((Cpprofesio)listProfesionalesAux.get(i)).getCpfcnombre()));
                    i++;
                }
            }
        }
        return lstAnestesiologo;
    }

    public void setLstAyudante(List lstAyudante) {
        this.lstAyudante = lstAyudante;
    }

    public List getLstAyudante() {
        if (lstAyudante == null || lstAyudante.isEmpty()) {
            lstAyudante = new ArrayList();
            ArrayList listAyudanteAux = null;
            try {
                listAyudanteAux = 
                        (ArrayList)serviceLocator.getCirugiaService().getListaMedicosClinica(getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (!listAyudanteAux.isEmpty()) {
                Iterator it = listAyudanteAux.iterator();
                int i = 0;
                lstAyudante.add(new SelectItem("", 
                                               "Seleccione una opci�n..."));
                                               
                lstAyudante.add(new SelectItem(new BigDecimal(-1), 
                                               "No Aplica"));
                
               
                while (it.hasNext()) {
                    it.next();
                    lstAyudante.add(new SelectItem(((Cpprofesio)listAyudanteAux.get(i)).getId().getCpfncodigo(), 
                                                   ((Cpprofesio)listAyudanteAux.get(i)).getCpfcnombre()));
                    i++;
                }
            }
        }
        return lstAyudante;
    }

    public void setHddcaspectodiu(ValueChangeEvent valueChangeEvent) {
        detalleDescripcion.setHddcaspectodiu((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHddcanotardiur(ValueChangeEvent valueChangeEvent) {
        detalleDescripcion.setHddcanotardiur((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHddctienesangr(ValueChangeEvent valueChangeEvent) {
        detalleDescripcion.setHddctienesangr((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHddctienepiepa(ValueChangeEvent valueChangeEvent) {
        System.out.println("setHddctienepiepa");
        detalleDescripcion.setHddctienepiepa((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHddcdiagncompl(ValueChangeEvent valueChangeEvent) {
        detalleDescripcion.setHddcdiagncompl((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHddcdiagnrelac(ValueChangeEvent valueChangeEvent) {
        detalleDescripcion.setHddcdiagnrelac((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHddcdiagnprinc(ValueChangeEvent valueChangeEvent) {
        detalleDescripcion.setHddcdiagnprinc((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHddchallazgos(ValueChangeEvent valueChangeEvent) {
        detalleDescripcion.setHddchallazgos((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHddcdescripcio(ValueChangeEvent valueChangeEvent) {
        detalleDescripcion.setHddcdescripcio((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHddctienecompl(ValueChangeEvent valueChangeEvent) {
        detalleDescripcion.setHddctienecompl((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setHddcmediayud1(ValueChangeEvent valueChangeEvent) {
        detalleDescripcion.setHddcmediayud1((BigDecimal)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public void setHddcmediayud2(ValueChangeEvent valueChangeEvent) {
        detalleDescripcion.setHddcmediayud2((BigDecimal)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        
    public void setHanestesiologoSelect(ValueChangeEvent valueChangeEvent) {
        detalleDescripcion.setHddcanestesiol((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
    
    public void setHddctipoaneste(ValueChangeEvent valueChangeEvent) {
        detalleDescripcion.setHddctipoaneste((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
    

    public void agregarAnestesiologo() {
        Cpprofesio anestesiologoObject = null;
        if (anestesiologoSelect != null && !anestesiologoSelect.equals("")) {
            String antesiologoArray[] = anestesiologoSelect.split(",");
            for (String anestesiologoSelect: antesiologoArray) {


                try {
                    anestesiologoObject = 
                            serviceLocator.getClinicoService().getProfesionalXCodigo(anestesiologoSelect, 
                                                                                     getClinica().getCclncodigo());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (anestesiologoObject != null) {
                    lstAnestesiologosSelect.add(anestesiologoObject);
                    anestesiologoSelect = "";
                }
            }
        }
    }

    public void agregarAyudantia() {
        Cpprofesio agregarAyudantiaObject = null;

        if (ayudantiaSelect != null && !ayudantiaSelect.equals("")) {
            if (residente != null && lstAyudantiaSelect.size() < 1) {
                renderResidente = true;
                String nomResiden[] = residente.split(",");
                String ayudantiaArray[] = ayudantiaSelect.split(",");
                for (String residentee: nomResiden) {
                    for (String ayudantiaSelect: ayudantiaArray) {


                        try {
                            agregarAyudantiaObject = 
                                    serviceLocator.getClinicoService().getProfesionalXCodigo(ayudantiaSelect, 
                                                                                             getClinica().getCclncodigo());
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }


                    }
                    agregarAyudantiaObject.setNombreResidente(residentee);
                    lstAyudantiaSelect.add(agregarAyudantiaObject);
                    ayudantiaSelect = "";
                    residentee = "";
                }
            } else {
                try {

                    agregarAyudantiaObject = 
                            serviceLocator.getClinicoService().getProfesionalXCodigo(ayudantiaSelect, 
                                                                                     getClinica().getCclncodigo());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                renderResidente = true;
                lstAyudantiaSelect.add(agregarAyudantiaObject);
                ayudantiaSelect = "";
            }
        }
    }

    
    public void eliminarAnestesiologo() {
           Cpprofesio anestesiologoDelete = null;
           anestesiologoDelete = (Cpprofesio)dtAnestesiologo.getRowData();
           lstAnestesiologosSelect.remove(anestesiologoDelete);
           anestesiologoSelect = null;
       }

    public void eliminarAyudantia() {
        Cpprofesio ayudantiaDelete = null;
        ayudantiaDelete = (Cpprofesio)dtAyudantia.getRowData();
        lstAyudantiaSelect.remove(ayudantiaDelete);
    }

    public void aceptarPlantilla() {
        BuscadorPlantillaCirugiaBean buscador = 
            (BuscadorPlantillaCirugiaBean)FacesUtils.getManagedBean("buscadorPlantillaCirugiaBean");
        if (buscador != null && buscador.getPlantillaSelect() != null) {
            if (buscador.isDescripcion()) {
                itDescripcion.setValue(buscador.getPlantillaSelect().getHplcdescripcio());
                detalleDescripcion.setHddcdescripcio(buscador.getPlantillaSelect().getHplcdescripcio());
            }
            if (buscador.isHallazgos()) {
                itHallazgos.setValue(buscador.getPlantillaSelect().getHplcdescripcio());
                detalleDescripcion.setHddcdescripcio(buscador.getPlantillaSelect().getHplcdescripcio());
            }
        }
        renderPlantilla = false;
        selectedIndex = 0;
        FacesUtils.resetManagedBean("buscadorPlantillaProcedimientoBean");
    }

    public void aceptarDiagnostico() {
        BuscadorCie10Bean cie10 = 
            (BuscadorCie10Bean)FacesUtils.getManagedBean("buscadorCie10Bean");
        if (cie10 != null && cie10.getCie10Select() != null) {
            if (cie10.isDiagnosticoPrincipal()) {
                detalleDescripcion.setHddcdiagnprinc(cie10.getCie10Select().getCdcccodigo());
                itDiagPreoperatorio.setValue(cie10.getCie10Select().getCdcccodigo());
                diagnosticoPreoperatorio = 
                        cie10.getCie10Select().getCdccdescri();
            }
            if (cie10.isDiagnosticoRelacionado1()) {
                detalleDescripcion.setHddcdiagnrelac(cie10.getCie10Select().getCdcccodigo());
                itDiagPostoperatorio.setValue(cie10.getCie10Select().getCdcccodigo());
                diagnosticoPosoperatorio = 
                        cie10.getCie10Select().getCdccdescri();
            }
            if (cie10.isDiagnosticoRelacionado2()) {
                detalleDescripcion.setHddcdiagncompl(cie10.getCie10Select().getCdcccodigo());
                itDiagComplicacion.setValue(cie10.getCie10Select().getCdcccodigo());
                diagnosticoComplicacion = 
                        cie10.getCie10Select().getCdccdescri();
            }
        }
        mostrarCie10 = false;
        selectedIndex = 0;
        cie10.clear();
    }

    public void mostrarDiagnosticoComplicacion() {
        if (detalleDescripcion != null)
            detalleDescripcion.setHddcdiagncompl(null);
        BuscadorCie10Bean cie10 = 
            (BuscadorCie10Bean)FacesUtils.getManagedBean("buscadorCie10Bean");
        cie10.setDiagnosticoPrincipal(false);
        cie10.setDiagnosticoRelacionado1(false);
        cie10.setDiagnosticoRelacionado2(true);
        cie10.setDiagnosticoRelacionado3(false);
        selectedIndex = 1;
        mostrarCie10 = true;
    }

    public void mostrarDiagnosticoPreoperatorio() {
        if (detalleDescripcion != null)
            detalleDescripcion.setHddcdiagnprinc(null);
        BuscadorCie10Bean cie10 = 
            (BuscadorCie10Bean)FacesUtils.getManagedBean("buscadorCie10Bean");
        cie10.setDiagnosticoPrincipal(true);
        cie10.setDiagnosticoRelacionado1(false);
        cie10.setDiagnosticoRelacionado2(false);
        cie10.setDiagnosticoRelacionado3(false);
        mostrarCie10 = true;
        selectedIndex = 1;
    }

    public void mostrarDiagnosticoPosoperatorio() {
        if (detalleDescripcion != null)
            detalleDescripcion.setHddcdiagnrelac(null);
        BuscadorCie10Bean cie10 = 
            (BuscadorCie10Bean)FacesUtils.getManagedBean("buscadorCie10Bean");
        cie10.setDiagnosticoPrincipal(false);
        cie10.setDiagnosticoRelacionado1(true);
        cie10.setDiagnosticoRelacionado2(false);
        cie10.setDiagnosticoRelacionado3(false);
        mostrarCie10 = true;
        selectedIndex = 1;
    }

    public void mostrarBuscadorPlantillaDescripcion() {
        FacesUtils.resetManagedBean("buscadorPlantillaCirugiaBean");
        BuscadorPlantillaCirugiaBean buscador = 
            (BuscadorPlantillaCirugiaBean)FacesUtils.getManagedBean("buscadorPlantillaCirugiaBean");
        if (buscador != null) {
            buscador.setNombreBeanAnterior("descripcionQuirurgicaBean");
            buscador.setTagRenderizar("panelGridDescripcionQuirurgicaTab");
            buscador.setDescripcion(true);
            buscador.setHallazgos(false);
        }
        renderPlantilla = true;
        selectedIndex = 2;
    }

    public void mostrarBuscadorPlantillaHallazgos() {
        FacesUtils.resetManagedBean("buscadorPlantillaCirugiaBean");
        BuscadorPlantillaCirugiaBean buscador = 
            (BuscadorPlantillaCirugiaBean)FacesUtils.getManagedBean("buscadorPlantillaCirugiaBean");
        if (buscador != null) {
            buscador.setNombreBeanAnterior("descripcionQuirurgicaBean");
            buscador.setTagRenderizar("panelGridDescripcionQuirurgicaTab");
            buscador.setHallazgos(true);
            buscador.setDescripcion(false);
        }
        renderPlantilla = true;
        selectedIndex = 2;
    }

    public void changeDiuresis() {
        if (detalleDescripcion.getHddcanotardiur() != null && 
            detalleDescripcion.getHddcanotardiur().equals("S")){
            mostrarDiuresis = true;
            changeCuantiDiuresis();
            }
        else{
            mostrarDiuresis = false;
            mostrarDiureCuanti = false;
        }
    }
    public void changeCuantiDiuresis() {
        if (detalleDescripcion.getHddccuantidiure() != null && 
            detalleDescripcion.getHddccuantidiure().equals("S"))
            mostrarDiureCuanti = true;
        else
            mostrarDiureCuanti = false;
    }

    public boolean validarCamposRequeridos() throws ModelException {
        String url = "body:formDescripcion:panelTabDescripcionQuirurgica:";
        boolean wexito = true;
        
        chconsulta = serviceLocator.getClinicoService().getConsultaActualHisteroscopia(numeroConsulta);
        
        if(chconsulta!=null){
            if(chconsulta.getHcocservicio()!=null){
                ser = serviceLocator.getClinicoService().getServicioPorId(chconsulta.getHcocservicio().getCsvccodigo());
            }
        }
        if (descripcion != null) {
            if (descripcion.getHdqnambito() == null) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAmbito").toString(), 
                                           "El campo es obligatorio");
            }
            if (descripcion.getHdqnformareali() == null) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuFormaProcedimiento").toString(), 
                                           "El campo es obligatorio");
            }
            if (descripcion.getHdqdfechaproce() == null) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("fechaProcedimiento").toString(), 
                                           "El campo es obligatorio");
            }
            if (descripcion.getHdqnsalacirugi() == null) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("idSalaCirugia").toString(), 
                                           "El campo es obligatorio");
            }
        }
        if (detalleDescripcion != null) {

            if (detalleDescripcion.getHddctipoaneste() == null || 
                detalleDescripcion.getHddctipoaneste().equals("")) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuTipoAnestesia").toString(), 
                                           "El campo es obligatorio");
            }
            if(lstAnestesiologosSelect == null || lstAnestesiologosSelect.isEmpty()){
                if (!detalleDescripcion.getHddctipoaneste().equals("6") && !detalleDescripcion.getHddctipoaneste().equals("8")) {
                    if (detalleDescripcion.getHddcanestesiol() == null || 
                        detalleDescripcion.getHddcanestesiol().equals("")) {
                        wexito = false;
                        FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAnestesiologo").toString(), 
                                               "El campo es obligatorio");}
                }
            }
            if (detalleDescripcion.getHddnfinalidad() == null) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuFinalidad").toString(), 
                                           "El campo es obligatorio");
            }
            if (detalleDescripcion.getHddntiempohora() == null) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuTiempoHora").toString(), 
                                           "El campo es obligatorio");
            }
            if (detalleDescripcion.getHddntiempominu() == null) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuTiempoMinuto").toString(), 
                                           "El campo es obligatorio");
            }
            if (detalleDescripcion.getHddcdiagnprinc() == null || 
                detalleDescripcion.getHddcdiagnprinc().equals("")) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("itDiagPrevioCirugia").toString(), 
                                           "El campo es obligatorio");
            }

            if (detalleDescripcion.getHddcdiagnrelac() == null || 
                detalleDescripcion.getHddcdiagnrelac().equals("")) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("itDiagPosteriorCirugia").toString(), 
                                           "El campo es obligatorio");
            }

            if (detalleDescripcion.getHddchallazgos() == null || 
                detalleDescripcion.getHddchallazgos().equals("")) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("idHallazgosDescrip").toString(), 
                                           "El campo es obligatorio");
            }

            if (detalleDescripcion.getHddcdescripcio() == null || 
                detalleDescripcion.getHddcdescripcio().equals("")) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("textDescripcion").toString(), 
                                           "El campo es obligatorio");
            }


            if (detalleDescripcion.getHddcdescripcio() == null || 
                detalleDescripcion.getHddcdescripcio().equals("")) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("textDescripcion").toString(), 
                                           "El campo es obligatorio");
            }
            if (detalleDescripcion.getHddctienecompl() == null || 
                detalleDescripcion.getHddctienecompl().equals("")) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuComplicaciones").toString(), 
                                           "El campo es obligatorio");
            }
            if (mostrarComplicaciones) {
                if (detalleDescripcion.getHddcdiagncompl() == null || 
                    detalleDescripcion.getHddcdiagncompl().equals("")) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("itDiagComplicacion").toString(), 
                                               "El campo es obligatorio");
                }
                if (detalleDescripcion.getHddcdescrcompl() == null || 
                    detalleDescripcion.getHddcdescrcompl().equals("")) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("inputTextareaComplicaciones").toString(), 
                                               "El campo es obligatorio");
                }
            }
            if (mostrarAnatomiaPatologica && 
                (detalleDescripcion.getHddcpiezapatol() == null || 
                 detalleDescripcion.getHddcpiezapatol().equals(""))) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("idPiezas").toString(), 
                                           "El campo es obligatorio");
            }
            /*   if(detalleDescripcion.getHddchallazgos() == null || detalleDescripcion.getHddchallazgos().equals(""))
            {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("idHallazgos").toString(), "El campo es obligatorio");
            }*/
            if (detalleDescripcion.getHddctienesangr() == null || 
                detalleDescripcion.getHddctienesangr().equals("")) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuSangrado").toString(), 
                                           "El campo es obligatorio");
            }
            if (mostrarSangrado && 
                detalleDescripcion.getHddnsangraprox() == null) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("idCantidadSangrado").toString(), 
                                           "El campo es obligatorio");
            }
            if (detalleDescripcion.getHddcanotardiur() == null || 
                detalleDescripcion.getHddcanotardiur().equals("")) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuDiuresis").toString(), 
                                           "El campo es obligatorio");
            }
            if (mostrarDiuresis) {
                if (detalleDescripcion.getHddncantidadiu() == null) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("idCantidadDiuresis").toString(), 
                                               "El campo es obligatorio");
                }
                if (detalleDescripcion.getHddcaspectodiu() == null || 
                    detalleDescripcion.getHddcaspectodiu().equals("")) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAspectos").toString(), 
                                               "El campo es obligatorio");
                }
                if (renderGrado && 
                    (detalleDescripcion.getHddcgradohemar() == null || 
                     detalleDescripcion.getHddcgradohemar().equals(""))) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuGrado").toString(), 
                                               "El campo es obligatorio");
                }

                if (detalleDescripcion.getHddctienesangr().equals("S")) {
                    if (detalleDescripcion.getHddccuantifi() == null || 
                        detalleDescripcion.getHddccuantifi().equals("")) {
                        wexito = false;
                        FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuCuantificado").toString(), 
                                                   "El campo es obligatorio");
                    }
                }
                if (ser != null && ser.getCsvntiphis()!= null && ser.getCsvntiphis() != 56) {
                    if (detalleDescripcion.getHddccuantidiure() == null || 
                        detalleDescripcion.getHddccuantidiure().equals("")) {
                        wexito = false;
                        FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuCuantificadoDiur").toString(), 
                                                   "El campo es obligatorio");
                    }
                }
                if (detalleDescripcion.getHddctipoaneste() == null || 
                    detalleDescripcion.getHddctipoaneste().equals("")) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("itDiagPosteriorCirugia").toString(), 
                                               "El campo es obligatorio");
                }
            }
            if (histeroscopia !=  null  && histeroscopia.getHhtctiposerv() !=null) {

                if (histeroscopia.getHhtcintpro() == null || 
                    histeroscopia.getHhtcintpro().equals("")) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("textInterHisteroscopia").toString(), 
                                               "El campo es obligatorio");
                }

                if (histeroscopia.getHhtcmedidist() == null || 
                    histeroscopia.getHhtcmedidist().equals(" ")) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("idMedioDistencion").toString(), 
                                               "El campo es obligatorio");
                }

                if (histeroscopia.getHhtlcantirri() == null) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("textCantidadIrr").toString(), 
                                               "El campo es obligatorio");
                }

                if (histeroscopia.getHttlcantreco() == null) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("textCantidadRec").toString(), 
                                               "El campo es obligatorio");
                }

            }

            if (hallazgoHis!= null && hallazgoHis.getHhhctiposerv()!= null) {
                if (hallazgoHis.getHhhchallazgo() == null || 
                    hallazgoHis.getHhhchallazgo().equals(" ")) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuHallazgosHiste").toString(), 
                                               "El campo es obligatorio");
                }
                if (hallazgoHis.getHhhchallazgo() != null &&
                    hallazgoHis.getHhhchallazgo().equals("S")) {
                    if (hallazgoHis.getHhhcvaginosc() == null || 
                        hallazgoHis.getHhhcvaginosc().equals("")) {
                        wexito = false;
                        FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("textHallazVaginoscopia").toString(), 
                                                   "El campo es obligatorio");
                    }
                    if (hallazgoHis.getHhhccancervi() == null || 
                        hallazgoHis.getHhhccancervi().equals("")) {
                        wexito = false;
                        FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("textHallazCanEndoce").toString(), 
                                                   "El campo es obligatorio");
                    }
                    if (hallazgoHis.getHhhcaspeendo() == null || 
                        hallazgoHis.getHhhcaspeendo().equals("")) {
                        wexito = false;
                        FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("textHallazAspeEndo").toString(), 
                                                   "El campo es obligatorio");
                    }
                    if (hallazgoHis.getHhhcostituba() == null || 
                        hallazgoHis.getHhhcostituba().equals("")) {
                        wexito = false;
                        FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("textHallazOstiuTuba").toString(), 
                                                   "El campo es obligatorio");
                    }
                    if (hallazgoHis.getHhhcmasaintr() == null || 
                        hallazgoHis.getHhhcmasaintr().equals("")) {
                        wexito = false;
                        FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("textHallazMaIntra").toString(), 
                                                   "El campo es obligatorio");
                    }
                    if (hallazgoHis.getHhhcotros() == null || 
                        hallazgoHis.getHhhcotros().equals("")) {
                        wexito = false;
                        FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("textHallazOtros").toString(), 
                                                   "El campo es obligatorio");
                    }

                }
            }
        
        }
        return wexito;
    }

    public void changeAspectos() {
        if (detalleDescripcion.getHddcaspectodiu() != null && 
            detalleDescripcion.getHddcaspectodiu().equals("H"))
            renderGrado = true;
        else
            renderGrado = false;
    }
    
    
    public void changeAyudante1() {
            renderAyudante1 = false;
        if (detalleDescripcion.getHddcmediayud1() != null && 
            detalleDescripcion.getHddcmediayud1().equals(new BigDecimal(0)))
            renderAyudante1 = true;
        
            
        }
        
    public void anestesiologoOblgatorio() {
            anestOblig = false;
        if (detalleDescripcion.getHddctipoaneste() != null && detalleDescripcion.getHddctipoaneste().equals("6")){
            anestOblig = false;
            }
            else{
                anestOblig = true;
            }
            
        }

    
    public void changeAyudante2() {
        renderAyudante2 = false;
        if (detalleDescripcion.getHddcmediayud2() != null && 
            detalleDescripcion.getHddcmediayud2().equals(new BigDecimal(0)))
            renderAyudante2 = true;           
    }

    public void changeDiagnosticoPreoperatorio() {
        diagnosticoPreoperatorio = null;
        List validacionRelacionado1 = null;
        if (detalleDescripcion.getHddcdiagnprinc() != null && 
            !detalleDescripcion.getHddcdiagnprinc().equals("")) {
            try {
                diagprin = 
                        serviceLocator.getClinicoService().getCIE10PorCodigo(detalleDescripcion.getHddcdiagnprinc().toUpperCase());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (diagprin != null && diagprin.getCdcccodigo() != null) {
                diagnosticoPreoperatorio = diagprin.getCdccdescri();
                validacionRelacionado1 = 
                        serviceLocator.getClinicoService().getVerificacionCie10(diagprin, 
                                                                                usuario.getHusesexo(), 
                                                                                "1", 
                                                                                edad, 
                                                                                "N");
                if (validacionRelacionado1 != null && 
                    !validacionRelacionado1.isEmpty() && 
                    validacionRelacionado1.get(1) != null)
                    FacesUtils.addErrorMessage((new StringBuilder()).append("Diagnostico Preoperatorio :  ").append(validacionRelacionado1.get(1)).toString());
            }
            if (diagnosticoPreoperatorio == null || 
                diagnosticoPreoperatorio.equals(""))
                FacesUtils.addErrorMessage("Error el codigo del diagnostico preoperatorio no es reconocido ");
        } else {
            diagnosticoPreoperatorio = "";
        }
    }

    public void changeDiagnosticoPostoperatorio() {
        diagnosticoPosoperatorio = null;
        List validacionPostoperatorio = null;
        if (detalleDescripcion.getHddcdiagnrelac() != null && 
            !detalleDescripcion.getHddcdiagnrelac().equals("")) {
            try {
                diagpost = 
                        serviceLocator.getClinicoService().getCIE10PorCodigo(detalleDescripcion.getHddcdiagnrelac().toUpperCase());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (diagpost != null && diagpost.getCdcccodigo() != null) {
                diagnosticoPosoperatorio = diagpost.getCdccdescri();
                validacionPostoperatorio = 
                        serviceLocator.getClinicoService().getVerificacionCie10(diagpost, 
                                                                                usuario.getHusesexo(), 
                                                                                "1", 
                                                                                edad, 
                                                                                "N");
                if (validacionPostoperatorio != null && 
                    !validacionPostoperatorio.isEmpty() && 
                    validacionPostoperatorio.get(1) != null)
                    FacesUtils.addErrorMessage((new StringBuilder()).append("Diagnostico Postoperatorio :  ").append(validacionPostoperatorio.get(1)).toString());
            }
            if (diagnosticoPosoperatorio == null || 
                diagnosticoPosoperatorio.equals(""))
                FacesUtils.addErrorMessage("Error el codigo del diagnostico postoperatorio no es reconocido ");
        } else {
            diagnosticoPosoperatorio = "";
        }
    }

    public void changeDiagnosticoComplicacion() {
        diagnosticoComplicacion = null;
        List validacionComplicaciones = null;
        if (detalleDescripcion.getHddcdiagncompl() != null && 
            !detalleDescripcion.getHddcdiagncompl().equals("")) {
            try {
                diagCompl = 
                        serviceLocator.getClinicoService().getCIE10PorCodigo(detalleDescripcion.getHddcdiagncompl().toUpperCase());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (diagCompl != null && diagCompl.getCdcccodigo() != null) {
                diagnosticoComplicacion = diagCompl.getCdccdescri();
                validacionComplicaciones = 
                        serviceLocator.getClinicoService().getVerificacionCie10(diagCompl, 
                                                                                usuario.getHusesexo(), 
                                                                                "1", 
                                                                                edad, 
                                                                                "N");
                if (validacionComplicaciones != null && 
                    !validacionComplicaciones.isEmpty() && 
                    validacionComplicaciones.get(1) != null)
                    FacesUtils.addErrorMessage((new StringBuilder()).append("Diagnostico Complicaci�n :  ").append(validacionComplicaciones.get(1)).toString());
            }
            if (diagnosticoComplicacion == null || 
                diagnosticoComplicacion.equals(""))
                FacesUtils.addErrorMessage("Error el codigo del diagnostico preoperatorio no es reconocido ");
        } else {
            diagnosticoComplicacion = "";
        }
    }

    public void changePiezasPatologia() {
        if (detalleDescripcion.getHddctienepiepa() != null && 
            detalleDescripcion.getHddctienepiepa().equals("S")) {
            mostrarAnatomiaPatologica = true;
        } else {
            mostrarAnatomiaPatologica = false;
            detalleDescripcion.setHddcpiezapatol(null);
        }
        System.out.println((new StringBuilder()).append("changePiezasPatologia() ").append(mostrarAnatomiaPatologica).toString());
    }

    public void changeComplicaciones() {
        msgComplicaciones = "";
        if (detalleDescripcion.getHddctienecompl() != null && 
            detalleDescripcion.getHddctienecompl().equals("S")) {
            mostrarComplicaciones = true;
            msgComplicaciones = 
                    "Recuerde generar el reporte de eventos adversos";
        } else {
            mostrarComplicaciones = false;
            diagnosticoComplicacion = "";
            detalleDescripcion.setHddcdescrcompl(null);
            detalleDescripcion.setHddcdiagncompl(null);
        }
    }

    public void changeSangrado() {
        if (detalleDescripcion.getHddctienesangr() != null && 
            detalleDescripcion.getHddctienesangr().equals("S")){
            mostrarSangrado = true;
            changeCuantSangrado();
            }
        else{
            mostrarSangrado = false;
            mostrarSangradoCuanti = false;
        }
    }
    
    public void changeCuantSangrado() {
        if (detalleDescripcion.getHddccuantifi() != null && 
            detalleDescripcion.getHddccuantifi().equals("S"))
            mostrarSangradoCuanti = true;
        else
            mostrarSangradoCuanti = false;
    }

    public void generarReporteLiquidos() {
        index = -1;
        try {
            detaciru = 
                    serviceLocator.getCirugiaService().getServicioDetalle(numeroConsulta);
        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (detaciru != null)
            try {
                servicio = 
                        serviceLocator.getClinicoService().getDescripcionCupsCompleto(detaciru.getId().getHdccservicio());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        try {
            lstLiquidosAdministrados = 
                    serviceLocator.getClinicoService().getLstLiquidosAdministrados(numeroConsulta);
            lstLiquidosParciales = 
                    serviceLocator.getClinicoService().getLstLiquidosAdministradoParcial(numeroConsulta);
            lstHistorialLiquidosEliminados = 
                    serviceLocator.getClinicoService().getLstLiquidosAdministradoEliminados(numeroConsulta);
        } catch (ModelException e) {
            e.printStackTrace();
        }
        List historialLiquidos = new ArrayList();
        if (lstHistorialLiquidosEliminados != null)
            historialLiquidos.addAll(lstHistorialLiquidosEliminados);
        if (lstLiquidosAdministrados != null)
            historialLiquidos.addAll(lstLiquidosAdministrados);
        if (lstLiquidosParciales != null)
            historialLiquidos.addAll(lstLiquidosParciales);
        if (historialLiquidos != null && !historialLiquidos.isEmpty()) {
            JRBeanCollectionDataSource dataSource = 
                new JRBeanCollectionDataSource(historialLiquidos);
            try {
                usuario = 
                        serviceLocator.getClinicoService().getUsuario(usuario.getHuslnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            File reportFile = 
                new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/ControlLiquidos.jasper"));
            if (reportFile.exists()) {
                Map parameters = new HashMap();
                byte bytes[] = null;
                try {
                    java.net.URL imagen = 
                        FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/profamilia_negro.gif");
                    parameters.put("IMAGEN", imagen);
                    parameters.put("FECHA", new Date());
                    parameters.put("NO_HISTORIA", 
                                   usuario.getHusanumeiden().toString());
                    parameters.put("PER_APELLIDO", 
                                   usuario.getHuscprimerapel());
                    parameters.put("SDO_APELLIDO", 
                                   usuario.getHuscsegundapel());
                    parameters.put("NOMBRES", 
                                   (new StringBuilder()).append(usuario.getHuscprimernomb()).append(" ").append(usuario.getHuscsegundnomb()).toString());
                    parameters.put("PROCEDIMIENTO", servicio.getCsvcnombre());
                    bytes = 
                            JasperRunManager.runReportToPdf(reportFile.getPath(), 
                                                            parameters, 
                                                            dataSource);
                    PdfServletUtils.showPdfDocument(bytes, 
                                                    "ControlLiquidos.pdf", 
                                                    false);
                    setGeneroReporte(true);
                } catch (JRException ex) {
                    ex.printStackTrace();
                    FacesUtils.addErrorMessage((new StringBuilder()).append("No pudo generar Reporte Control Liquidos. ").append(ex.getMessage()).toString());
                    setGeneroReporte(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    FacesUtils.addErrorMessage((new StringBuilder()).append("No pudo generar reporte Control Liquidos. ").append(ex.getMessage()).toString());
                    setGeneroReporte(false);
                }
            }
        } else {
            FacesUtils.addErrorMessage("No existen registros");
        }
    }
    
    public void changeAnestesia() {
           renderAnestesiologo = false;
           if(!lstAnestesiologosSelectAux.isEmpty()){
               lstAnestesiologosSelect = lstAnestesiologosSelectAux;
           }
           if(detalleDescripcion != null && detalleDescripcion.getHddctipoaneste() != null && 
               (detalleDescripcion.getHddctipoaneste().equals("6") || detalleDescripcion.getHddctipoaneste().equals("8")) ){
                   lstAnestesiologosSelectAux = lstAnestesiologosSelect;
                   lstAnestesiologosSelect=new ArrayList();
            }
           if (detalleDescripcion != null && detalleDescripcion.getHddctipoaneste() != null && 
               detalleDescripcion.getHddctipoaneste().equals("2")) {
               renderAnestesiologo = true;
           }
               else if (detalleDescripcion != null && detalleDescripcion.getHddctipoaneste() != null && 
                   detalleDescripcion.getHddctipoaneste().equals("4")) {
                   renderAnestesiologo = true;
               } 
              else if (detalleDescripcion != null && detalleDescripcion.getHddctipoaneste() != null && 
                   detalleDescripcion.getHddctipoaneste().equals("5")) {
                   renderAnestesiologo = true;
               } 
               else if (detalleDescripcion != null && detalleDescripcion.getHddctipoaneste() != null && 
                    detalleDescripcion.getHddctipoaneste().equals("7")) {
                    renderAnestesiologo = true;
                } 


          
       }

    public boolean next() {
        index++;
        return index < 1;
    }

    public Object getFieldValue(JRField jrField) {
        String fieldName = jrField.getName();
        Object value = null;

        if (fieldName.equals("FECHAHISTERO")) { 
        value = FECHAHISTERO;
        }
        if (fieldName.equals("HISTORIACLINICA")) {
        value=HISTORIACLINICA;
        }
        if (fieldName.equals("PRIMERAPELLIDO")) {
        value=PRIMERAPELLIDO;
        }
        if (fieldName.equals("SEGUNDOAPELLIDO")) {
        value=SEGUNDOAPELLIDO;
        }
        if (fieldName.equals("NOMBRE")) {
        value=NOMBRE;
        }
        if (fieldName.equals("CLINICAHISTERO")) {
        value=CLINICAHISTERO;
        }
        if (fieldName.equals("SALA")) {
        value=SALA;
        }
        if (fieldName.equals("EDADHISTERO")) {
        value=EDADHISTERO ;
        }
        if (fieldName.equals("CIRUJANO")) {
        value=CIRUJANO;
        }
        if (fieldName.equals("TIEMPOQUIRURGICO")) {
        value=TIEMPOQUIRURGICO;
        }
        if (fieldName.equals("ANESTESIOLOGO")) {
        value=ANESTESIOLOGO;
        }
        if (fieldName.equals("TIPOANESTESIA")) {
        value=TIPOANESTESIA;
        }
        if (fieldName.equals("AYUDANTE")) {
        value=AYUDANTE;
        }
        if (fieldName.equals("AYUDANTE2")) {
        value=AYUDANTE2;
        }
        if (fieldName.equals("INSTRUMENTACION")) {
        value=INSTRUMENTACION;
        }
        if (fieldName.equals("CIRCULANTE")) {
        value=CIRCULANTE;
        }
        if (fieldName.equals("DIAGPRINCIPAL")) {
        value=DIAGPRINCIPAL ;
        }
        if (fieldName.equals("DIAGRELACIONADO")) {
        value=DIAGRELACIONADO;
        }
        if (fieldName.equals("INTERVENCIONPROPUESTA")) {
        value=INTERVENCIONPROPUESTA;
        }
        if (fieldName.equals("MEDIODISTENCION")) {
        value=MEDIODISTENCION;
        }
        if (fieldName.equals("CANTIDADIRRIGADA")) {
        value=CANTIDADIRRIGADA;
        }
        if (fieldName.equals("CANTIDADRECOLECTADA")) {
        value=CANTIDADRECOLECTADA;
        }
        if (fieldName.equals("BALANCE")) {
        value=BALANCE  ;
        }
        if (fieldName.equals("POSITIVONEGATIVO")) {
        value=POSITIVONEGATIVO;
        }
        if (fieldName.equals("HALLAZGOS")) {
        value=HALLAZGOS;
        }
        if (fieldName.equals("VAGINOSCOPIA")) {
        value=VAGINOSCOPIA  ;
        }
        if (fieldName.equals("CANALENDOCERVICAL")) {
        value=CANALENDOCERVICAL ;
        }
        if (fieldName.equals("ASPECTOENDOMETRIO")) {
        value=ASPECTOENDOMETRIO ;
        }
        if (fieldName.equals("OSTIUMSTUBARICO")) {
        value=OSTIUMSTUBARICO ;
        }
        if (fieldName.equals("MASAINTRACAVITARIA")) {
        value=MASAINTRACAVITARIA ;
        }
        if (fieldName.equals("OTROSHOISTERO")) {
        value=OTROSHOISTERO  ;
        }
        if (fieldName.equals("DESCRIPCIONPROCED")) {
        value=DESCRIPCIONPROCED;
        }
        if (fieldName.equals("PATOLOGIA")) {
        value=PATOLOGIA ;
        }
        if (fieldName.equals("SANGRADOHISTERO")) {
        value=SANGRADOHISTERO  ;
        }
        if (fieldName.equals("CUANTIFICADO")) {
        value=CUANTIFICADO ;
        }
        if (fieldName.equals("CANTIDAD")) {
        value=CANTIDAD ;
        }
        if (fieldName.equals("COMPLICACION")) {
        value=COMPLICACION  ;
        }
        if (fieldName.equals("DIAGCOMPLICACION")) {
        value=DIAGCOMPLICACION;
        }
        if (fieldName.equals("DESCRIPCOMPLIC")) {
        value=DESCRIPCOMPLIC  ;
        }
        if (fieldName.equals("NOMBREPORFESIONAL")) {
        value=NOMBREPORFESIONAL ;
        }
        if (fieldName.equals("REGISTROPROFESIONAL")) {
        value=REGISTROPROFESIONAL;
        }
        if (fieldName.equals("INTERVENCIONPRACTICADA")) {
        value=INTERVENCIONPRACTICADA;
        }
        return value;
    }

    public String guardarDescripcion() throws ModelException {
        String navegationRule = "";
        Chcirugprogr cirugia = null;

        if (validarCamposRequeridos()){
            try {
                if (numeroConsulta != null) {
                    descripcion.setHdqlnumero(numeroConsulta);
                    detalleDescripcion.getId().setHddlnumero(numeroConsulta);
                    histeroscopia.setHhtlnumero(numeroConsulta);
                    hallazgoHis.setHhhlconsulta(numeroConsulta);
                }
                if (usuario != null && usuario.getHuslnumero() != null) {
                    descripcion.setHdqlusuario(usuario);
                    detalleDescripcion.setHddlusuario(usuario);
                    histeroscopia.setHhtlnumusu(usuario.getHuslnumero());
                    hallazgoHis.setHhhlnumeusua(usuario.getHuslnumero());
                }
                if(null != histeroscopia){
                histeroscopia.setHhtctiposerv("H");
               histeroscopia.setHhtdfecreg(new Date());
                histeroscopia.setHhtcusureg(userName());
                
                }
                if(null != hallazgoHis){
                hallazgoHis.setHhhctiposerv("H");
                hallazgoHis.setHhhdfechregi(new Date());
                hallazgoHis.setHhhcusuaregi(userName());
                
                }
                descripcion.setHdqcestado("VG");
                descripcion.setHdqcoperador(userName());
                descripcion.setHdqdfecregistr(new Date());
                descripcion.setHdqnclinica(getClinica().getCclncodigo());
                detalleDescripcion.setHddccirujano(codigoMedico);
                detalleDescripcion.setHddcoperador(userName());
                detalleDescripcion.setHdddfecregistr(new Date());
                detalleDescripcion.setHddcestado("VG");
                if (detalleDescripcion.getHddcdiagnrelac() == null)
                    detalleDescripcion.setHddcdiagnrelac(" ");
                if (lstAnestesiologosSelect != null && 
                    !lstAnestesiologosSelect.isEmpty()) {
                    String codigosAnestesiologo = "";
                    Cpprofesio anesAux = null;
                    for (Iterator it = lstAnestesiologosSelect.iterator(); 
                         it.hasNext(); ) {
                        anesAux = (Cpprofesio)it.next();
                        if (anesAux != null)
                            codigosAnestesiologo = 
                                    (new StringBuilder()).append(codigosAnestesiologo).append(anesAux.getId().getCpfncodigo()).append(",").toString();
                    }

                    codigosAnestesiologo = 
                            codigosAnestesiologo.substring(0, codigosAnestesiologo.length() - 
                                                           1);
                    if (codigosAnestesiologo != null) {
                        detalleDescripcion.setHddcanestesiol(codigosAnestesiologo);
                    } 
                }else {
                        detalleDescripcion.setHddcanestesiol(null);
                    }


                if (lstAyudantiaSelect != null && 
                    !lstAyudantiaSelect.isEmpty()) {
                    String codigosAyudantia = "";
                    String nombresAyudantia = "";
                    Cpprofesio anesAux = null;
                    for (Iterator it = lstAyudantiaSelect.iterator(); 
                         it.hasNext(); ) {
                        anesAux = (Cpprofesio)it.next();
                        if (anesAux != null)
                            codigosAyudantia = 
                                    (new StringBuilder()).append(codigosAyudantia).append(anesAux.getId().getCpfncodigo()).append(",").toString();
                        nombresAyudantia = 
                                (new StringBuilder()).append(nombresAyudantia).append(anesAux.getNombreResidente()).append(",").toString();
                    }

                    codigosAyudantia = 
                            codigosAyudantia.substring(0, codigosAyudantia.length() - 
                                                       1);
                    nombresAyudantia = 
                            nombresAyudantia.substring(0, nombresAyudantia.length() - 
                                                       1);
                    if (codigosAyudantia != null)
                        detalleDescripcion.setHddcayudante1(codigosAyudantia);

                    if (nombresAyudantia != null)
                        detalleDescripcion.setHddcayudante2(nombresAyudantia);
                }
               if(flagCostos){
                saveAcumuladorCostos();
               }

                serviceLocator.getCirugiaService().saveDescripcionQuirurgica(descripcion, 
                                                                             detalleDescripcion, 
                                                                             lstDetalleCirugias, 
                                                                             lstCirugias, 
                                                                             userName(), 
                                                                             etapaCirugia, 
                                                                             numeroConsulta);
                if(ser !=null &&  ser.getCsvntiphis()!= null && ser.getCsvntiphis().equals(IConstantes.CIRUGIA_PROCEDIMIENTO_CONSULTORIO_IVE)){
                                   guardarSeguimientoIVE();  
                               }  
               
        
                if(ser != null && ser.getCsvntiphis()!= null && ser.getCsvntiphis()==56){
                    serviceLocator.getCirugiaService().saveDescripcionQuirurgicaHisteroscopia(histeroscopia);
                    serviceLocator.getCirugiaService().saveDescripcionQuirurgicaHallazgoHistero(hallazgoHis);
                }                                                         
               
                
                modoConsulta = true; 
                ListaCirugiaDescripcionQuirurgicaBean lista = 
                    (ListaCirugiaDescripcionQuirurgicaBean)FacesUtils.getManagedBean("listaCirugiaDescripcionQuirurgicaBean");
                if (lista != null) {
                    lista.init();
                }
                MenuDescripcionBean menu = 
                    (MenuDescripcionBean)FacesUtils.getManagedBean("menuDescripcionBean");
                if (menu != null) {
                    menu.init();
                }

                navegationRule = "irFormulaMedicadescripcionMedico";
                if(mostrarAnatomiaPatologica){
                    FacesUtils.addInfoMessage((new StringBuilder()).append("Se Genero Satisfactoriamente la ANATOMIA PATOLOGIA para el usuarios con Documento: ").append(usuario.getHusanumeiden()).toString());    
                }
                
              
                
            } catch (ModelException e) {
                navegationRule = "";
                FacesUtils.addErrorMessage((new StringBuilder()).append("Error !!! ").append(e.getMessage()).toString());
                e.printStackTrace();
            } catch (Exception ex) {
                navegationRule = "";
                FacesUtils.addErrorMessage((new StringBuilder()).append("Error !!! ").append(ex.getMessage()).toString());
                ex.printStackTrace();
            }
            
        if(ser != null && ser.getCsvntiphis()!= null &&  ser.getCsvntiphis()==56){
             imprimirHisteroscopia();
        }  
    }
            return navegationRule;
        }
    

    /**
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        Chdescrquiru descripcion = null;
        if (numeroConsulta != null)
            try {
                descripcion = 
                        getServiceLocator().getCirugiaService().getDescripcionQuirurgica(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        if (descripcion != null)
            esValido = true;
        else
            esValido = false;
        return esValido;
    }

    public void guardarSeguimientoIVE(){
      
        
              Chusuarioabor usuarioAborto;
              try {
                
                  if (usuario != null) {
                      Chusuario usuarioAux = 
                               this.serviceLocator.getClinicoService().getUsuario(usuario.getHuslnumero());
                               if(usuarioAux !=null){
                      usuarioAborto = 
                          serviceLocator.getClinicoService().findOneUsuarioAbort(usuarioAux.getHusanumeiden(),usuarioAux.getHusetipoiden());
                          if(usuarioAborto !=null){
                              Chregisabort registroAborto = serviceLocator.getClinicoService().findOneRegistroUsuarioAbort(usuarioAborto.getHualnumero());
                              if (registroAborto !=null){
                                String  nombreProfesional = formatearCampoNombreUsuario(userName(),getClinica().getCclncodigo());
                                  Chcontabor seguimientoUsuario = new Chcontabor();
                                      seguimientoUsuario.setHcacobserva(nombreProfesional+", Se realiza un procedimiento para el servicio: "+servicio.getCsvccodigo()+" "+servicio.getCsvcnombre());
                                      seguimientoUsuario.setHcactipocont("PR");
                                      registroAborto.setHracproced("S");                     
                                  registroAborto.setHracseguim("S");
                                 seguimientoUsuario.setHcadfechobse(new Date());
                                  seguimientoUsuario.setHcancodclin(getClinica().getCclncodigo());
                                  seguimientoUsuario.setHcacusuareg(userName());
                                  seguimientoUsuario.setHcalnumeusua(registroAborto.getHralnumero());
                                  seguimientoUsuario.setHcannumcons(numeroConsulta);                             
                                  serviceLocator.getClinicoService().saveSeguimientoUsuarioAbort(seguimientoUsuario);
                                  serviceLocator.getClinicoService().saveRegistroUsuarioAbort(registroAborto);
                               
                              
                              }
                          }
                               }
                  
                  }
              } catch (ModelException e) {
                  FacesUtils.addErrorMessage(e.getMessage());
              }    
              
      }
      
    public void setUtilizo(ValueChangeEvent valueChangeEvent) {
        int indiceLista=dtServiciosCostos.getRowIndex();
         lstServicios.get(indiceLista).setUtilizo(((String)valueChangeEvent.getNewValue()));
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setLote(ValueChangeEvent valueChangeEvent) {
        int indiceLista=dtServiciosCostos.getRowIndex();
         lstServicios.get(indiceLista).setLote(((String)valueChangeEvent.getNewValue()));
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
      
      public String changeListaServicio(){
        
          int indiceLista=dtServiciosCostos.getRowIndex();
          if(lstServicios.get(indiceLista).getLstLotes()==null){
            lstServicios.get(indiceLista).setLstLotes(new ArrayList<SelectItem>());
          }
          lstServicios.get(indiceLista).getLstLotes().clear();
          lstServicios.get(indiceLista).setFechaVencimiento(null);
          lstServicios.get(indiceLista).setRenderFecha(false);
          if(("S").equals(lstServicios.get(indiceLista).getTrazador()) && ("S") .equals(lstServicios.get(indiceLista).getUtilizo()) ){
            List<String>aux;
            try {
                aux = serviceLocator.getCostosService().geLstLotesByCodigo(lstServicios.get(indiceLista).getCodigoServicio());
                if(aux !=null){
                    List<SelectItem>lotes = new ArrayList<SelectItem>();
                for(int i = 0;i<aux.size();i++){
                   lotes.add(new SelectItem(aux.get(i),aux.get(i)));                  
                }
                    lstServicios.get(indiceLista).setLstLotes(lotes);
                }
            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }
       
          }
          return null;
      }
    public String changeFechaLote(){
      
        int indiceLista=dtServiciosCostos.getRowIndex();
        lstServicios.get(indiceLista).setFechaVencimiento(null);
        lstServicios.get(indiceLista).setRenderFecha(false);
          try {
             Date aux = serviceLocator.getCostosService().getFechaByLote(lstServicios.get(indiceLista).getLote());
              if(aux !=null){
                  lstServicios.get(indiceLista).setFechaVencimiento(aux);
                  lstServicios.get(indiceLista).setRenderFecha(true);
                  
              }
          } catch (ModelException e) {
              return capturaError(e,IConstantes.ERROR_COSNULTA);
          }
     
        
        return null;
    }
    public void setRenderBuscadorServicio(boolean renderBuscadorServicio) {
        this.renderBuscadorServicio = renderBuscadorServicio;
    }

    public boolean isRenderBuscadorServicio() {
        return renderBuscadorServicio;
    }

    public void setSeleccionServicio(String seleccionServicio) {
        this.seleccionServicio = seleccionServicio;
    }

    public String getSeleccionServicio() {
        return seleccionServicio;
    }

    public void setLstCirugias(List lstCirugias) {
        this.lstCirugias = lstCirugias;
    }

    public List getLstCirugias() {
        return lstCirugias;
    }

    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }

    public void setDeshabilitarServicio(boolean deshabilitarServicio) {
        this.deshabilitarServicio = deshabilitarServicio;
    }

    public boolean isDeshabilitarServicio() {
        return deshabilitarServicio;
    }

    public void setRegistrarCirugia(boolean registrarCirugia) {
        this.registrarCirugia = registrarCirugia;
    }

    public boolean isRegistrarCirugia() {
        return registrarCirugia;
    }

    public void setDtServicios(HtmlDataTable dtServicios) {
        this.dtServicios = dtServicios;
    }

    public HtmlDataTable getDtServicios() {
        return dtServicios;
    }

    public void setLstImpresion(List lstImpresion) {
        this.lstImpresion = lstImpresion;
    }

    public List getLstImpresion() {
        return lstImpresion;
    }

    public void setDiagPre(String diagPre) {
        this.diagPre = diagPre;
    }

    public String getDiagPre() {
        return diagPre;
    }

    public void setDtCirugias(HtmlDataTable dtCirugias) {
        this.dtCirugias = dtCirugias;
    }

    public HtmlDataTable getDtCirugias() {
        return dtCirugias;
    }

    public void setLstDescDetalle(List lstDescDetalle) {
        this.lstDescDetalle = lstDescDetalle;
    }

    public List getLstDescDetalle() {
        return lstDescDetalle;
    }

    public void setDetalleDesc(Object[] detalleDesc) {
        this.detalleDesc = detalleDesc;
    }

    public Object[] getDetalleDesc() {
        return detalleDesc;
    }

    public void setAntecedentes(Chantegineco antecedentes) {
        this.antecedentes = antecedentes;
    }

    public Chantegineco getAntecedentes() {
        return antecedentes;
    }

    public void setLstDetalleCirugia(List lstDetalleCirugia) {
        this.lstDetalleCirugia = lstDetalleCirugia;
    }

    public List getLstDetalleCirugia() {
        return lstDetalleCirugia;
    }

    
    public void setDetaciru(Chdetacirpro detaciru) {
        this.detaciru = detaciru;
    }

    public Chdetacirpro getDetaciru() {
        return detaciru;
    }

    public void setCirugiaProgra(Chcirugprogr cirugiaProgra) {
        this.cirugiaProgra = cirugiaProgra;
    }

    public Chcirugprogr getCirugiaProgra() {
        return cirugiaProgra;
    }

    public void setItHallazgos(UIInput itHallazgos) {
        this.itHallazgos = itHallazgos;
    }

    public UIInput getItHallazgos() {
        return itHallazgos;
    }


    public void setRenderInstrumentador(boolean renderInstrumentador) {
        this.renderInstrumentador = renderInstrumentador;
    }

    public boolean isRenderInstrumentador() {
        return renderInstrumentador;
    }

    public void setAyudantiaSelect(String ayudantiaSelect) {
        this.ayudantiaSelect = ayudantiaSelect;
    }

    public String getAyudantiaSelect() {
        return ayudantiaSelect;
    }

    public void setDtAyudantia(HtmlDataTable dtAyudantia) {
        this.dtAyudantia = dtAyudantia;
    }

    public HtmlDataTable getDtAyudantia() {
        return dtAyudantia;
    }

    public void setLstAyudantiaSelect(List lstAyudantiaSelect) {
        this.lstAyudantiaSelect = lstAyudantiaSelect;
    }

    public List getLstAyudantiaSelect() {
        return lstAyudantiaSelect;
    }


    public void setRenderResidente(boolean renderResidente) {
        this.renderResidente = renderResidente;
    }

    public boolean isRenderResidente() {
        return renderResidente;
    }

    public void setDtServiciosPracticados(HtmlDataTable dtServiciosPracticados) {
        this.dtServiciosPracticados = dtServiciosPracticados;
    }

    public HtmlDataTable getDtServiciosPracticados() {
        return dtServiciosPracticados;
    }

    public void setLstCirculante(List lstCirculante) {
        this.lstCirculante = lstCirculante;
    }

    public List getLstCirculante() {
        if (lstCirculante == null || lstCirculante.isEmpty()) {
            lstCirculante = new ArrayList();
            ArrayList listCirculanteAux = null;
            try {
                listCirculanteAux = 
                        (ArrayList)serviceLocator.getClinicoService().getListaMedicoXEspecialidad(getClinica().getCclncodigo(), 
                                                                                                  TIPO_PROFESIONAL_AUXILIARES);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (!listCirculanteAux.isEmpty()) {
                Iterator it = listCirculanteAux.iterator();
                int i = 0;
                lstCirculante.add(new SelectItem("", 
                                                     "Seleccione una opci\363n ..."));
                
                while (it.hasNext()) {
                    it.next();
                    lstCirculante.add(new SelectItem(((Cpprofesio)listCirculanteAux.get(i)).getId().getCpfncodigo(), 
                                                         ((Cpprofesio)listCirculanteAux.get(i)).getCpfcnombre()));
                    i++;
                }
            }
        }
        return lstCirculante;
    }

    public void setLabelEncabezado(String labelEncabezado) {
        this.labelEncabezado = labelEncabezado;
    }

    public String getLabelEncabezado() {
        return labelEncabezado;
    }

    public void setLabelfielSet(String labelfielSet) {
        this.labelfielSet = labelfielSet;
    }

    public String getLabelfielSet() {
        return labelfielSet;
    }

    public void setLabelSala(String labelSala) {
        this.labelSala = labelSala;
    }

    public String getLabelSala() {
        return labelSala;
    }

    public void setLabelfielSet2(String labelfielSet2) {
        this.labelfielSet2 = labelfielSet2;
    }

    public String getLabelfielSet2() {
        return labelfielSet2;
    }

    public void setLabeltiempo(String labeltiempo) {
        this.labeltiempo = labeltiempo;
    }

    public String getLabeltiempo() {
        return labeltiempo;
    }

    public void setLabelInstrumentacion(String labelInstrumentacion) {
        this.labelInstrumentacion = labelInstrumentacion;
    }

    public String getLabelInstrumentacion() {
        return labelInstrumentacion;
    }

    public void setLabelDescripcion(String labelDescripcion) {
        this.labelDescripcion = labelDescripcion;
    }

    public String getLabelDescripcion() {
        return labelDescripcion;
    }

    public void setLabelProcedimientoPracticado(String labelProcedimientoPracticado) {
        this.labelProcedimientoPracticado = labelProcedimientoPracticado;
    }

    public String getLabelProcedimientoPracticado() {
        return labelProcedimientoPracticado;
    }

    public void setLabelfielSet3(String labelfielSet3) {
        this.labelfielSet3 = labelfielSet3;
    }

    public String getLabelfielSet3() {
        return labelfielSet3;
    }

    public void setLabelHallazgos(String labelHallazgos) {
        this.labelHallazgos = labelHallazgos;
    }

    public String getLabelHallazgos() {
        return labelHallazgos;
    }

    public void setLabelIntervecionesPropuestas(String labelIntervecionesPropuestas) {
        this.labelIntervecionesPropuestas = labelIntervecionesPropuestas;
    }

    public String getLabelIntervecionesPropuestas() {
        return labelIntervecionesPropuestas;
    }

    public void setLabelIntervecionesPracticadas(String labelIntervecionesPracticadas) {
        this.labelIntervecionesPracticadas = labelIntervecionesPracticadas;
    }

    public String getLabelIntervecionesPracticadas() {
        return labelIntervecionesPracticadas;
    }

    public void setRenderAyudante1(boolean renderAyudante1) {
        this.renderAyudante1 = renderAyudante1;
    }

    public boolean isRenderAyudante1() {
        return renderAyudante1;
    }

    public void setRenderAyudante2(boolean renderAyudante2) {
        this.renderAyudante2 = renderAyudante2;
    }

    public boolean isRenderAyudante2() {
        return renderAyudante2;
    }


    public void setModoConsulta(boolean modoConsulta) {
        this.modoConsulta = modoConsulta;
    }

    public boolean isModoConsulta() {
        return modoConsulta;
    }

    public void setChconsulta(Chconsulta chconsulta) {
        this.chconsulta = chconsulta;
    }

    public Chconsulta getChconsulta() {
        return chconsulta;
    }

    public void setHisteroscopia(Chhisteroscopia histeroscopia) {
        this.histeroscopia = histeroscopia;
    }

    public Chhisteroscopia getHisteroscopia() {
        return histeroscopia;
    }

    public void setHallazgoHis(Chhallahistero hallazgoHis) {
        this.hallazgoHis = hallazgoHis;
    }

    public Chhallahistero getHallazgoHis() {
        return hallazgoHis;
    }

    public void setLstMedioDistencion(List lstMedioDistencion) {
        this.lstMedioDistencion = lstMedioDistencion;
    }

    public List getLstMedioDistencion() {
        if (lstMedioDistencion == null || lstMedioDistencion.isEmpty()) {
            lstMedioDistencion = new ArrayList();
            lstMedioDistencion.add(new SelectItem(" ", "Seleccione.."));
            lstMedioDistencion.add(new SelectItem("SS", "Soluci�n Salina Normal"));
            lstMedioDistencion.add(new SelectItem("GL", "Glicina"));
        }
        return lstMedioDistencion;
    }

    public void setRenderObliIntrumentador(boolean renderObliIntrumentador) {
        this.renderObliIntrumentador = renderObliIntrumentador;
    }

    public boolean isRenderObliIntrumentador() {
        return renderObliIntrumentador;
    }
    
    public void setHhhchallazgo(ValueChangeEvent valueChangeEvent) {
        hallazgoHis.setHhhchallazgo((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void changeHallazgo() {
    if(null !=hallazgoHis){
        if (hallazgoHis.getHhhchallazgo() != null && 
            hallazgoHis.getHhhchallazgo().equals("S")) {
            mostrarHallazgos = true;
           
        } else {
            mostrarHallazgos = false;
         
            hallazgoHis.setHhhchallazgo(null);
            hallazgoHis.setHhhcvaginosc(null); 
            hallazgoHis.setHhhccancervi(null);
            hallazgoHis.setHhhcaspeendo(null);
            hallazgoHis.setHhhcostituba(null);
            hallazgoHis.setHhhcmasaintr(null);
            hallazgoHis.setHhhcotros(null);
        }
    }
        else {
                    mostrarHallazgos = false;
                 hallazgoHis= new Chhallahistero();
             }
    }

    public void setMostrarHallazgos(boolean mostrarHallazgos) {
        this.mostrarHallazgos = mostrarHallazgos;
    }

    public boolean isMostrarHallazgos() {
        return mostrarHallazgos;
    }

    public void setItCantRecolectada(UIInput itCantRecolectada) {
        this.itCantRecolectada = itCantRecolectada;
    }

    public UIInput getItCantRecolectada() {
        return itCantRecolectada;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setCantRecolectada(ValueChangeEvent valueChangeEvent) {
        histeroscopia.setHttlcantreco((Long)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        changeBalance();
    }


    
    /**
     * @param valueChangeEvent
     */
    public void setCantIrrigada(ValueChangeEvent valueChangeEvent) {
        histeroscopia.setHhtlcantirri((Long)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setHddccuantifi(ValueChangeEvent valueChangeEvent) {
        detalleDescripcion.setHddccuantifi((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setHddccuantidiure(ValueChangeEvent valueChangeEvent) {
        detalleDescripcion.setHddccuantidiure((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
  
    public void changeBalance() {
        Long balance = new Long(0);
        if (null != histeroscopia) {
            if (histeroscopia.getHhtlcantirri() != null && 
                histeroscopia.getHttlcantreco() != null) {

                balance =  histeroscopia.getHhtlcantirri() - histeroscopia.getHttlcantreco();
                if(balance>0){
                    histeroscopia.setHttlbalance(balance);
                    histeroscopia.setHttlbalposneg("Positivo");
                    if(null != histeroscopia.getHhtcmedidist()){
                        if (balance >= 750 && histeroscopia.getHhtcmedidist().equals("GL")) {
                            msgElectrolitros =  "Valorar a la paciente o considerar solicitar electrolitos";
                        } else {
                            msgElectrolitros = "";
                        }
                    }
                }
                else if(balance < 0){
                balance= balance * -1;
                    histeroscopia.setHttlbalance(balance);
                    histeroscopia.setHttlbalposneg("Negativo");
                }else{
                
                    histeroscopia.setHttlbalance(balance);
                    histeroscopia.setHttlbalposneg("");
                }


            }
        }
    }
    
    public void changeMedioDistincion() {
       
        if (histeroscopia.getHhtcmedidist() != null && histeroscopia.getHhtcmedidist().equals("GL")){
            changeBalance();
        }
                  
    }
    
    public void changeCantidadIrrig(){
        if (histeroscopia.getHhtlcantirri() != null &&  histeroscopia.getHttlcantreco()!=null){
            changeBalance();    
        }
    }
    
    public void obtenerDatosReporte() {
    
    Chcirugprogr cirugiaAux;
    cirugiaAux = null;
    Chusuario usuario;
    usuario = null;
    Cpprofesio profesionalanes;
    profesionalanes= null;
    Cpprofesio profesionalciru;
    profesionalciru= null;  
    Cpservicio servicio;
    servicio= null;
    Cpclinica clinica;
    clinica= null;
    
    resetReporteHisteroscopia();
        try {
            chconsulta= serviceLocator.getClinicoService().getConsultaActualHisteroscopia(numeroConsulta);
            servicio= this.serviceLocator.getClinicoService().getServicioPorId(chconsulta.getHcocservicio().getCsvccodigo());
            usuario=  this.serviceLocator.getClinicoService().getUsuarioPorPk(chconsulta.getHcolusuario().getHuslnumero());
            if(detalleDescripcion.getHddcanestesiol()!=null){
                profesionalanes = this.serviceLocator.getClinicoService().getProfesionalXCodigo(detalleDescripcion.getHddcanestesiol(),getClinica().getCclncodigo());  
            }
          
            profesionalciru = this.serviceLocator.getClinicoService().getProfesionalXCodigo(detalleDescripcion.getHddccirujano().toString(), getClinica().getCclncodigo());
            clinica = this.serviceLocator.getClinicoService().getClinica( descripcion.getHdqnclinica()); 
            if (detalleDescripcion != null) {
                if (detalleDescripcion != null && 
                    detalleDescripcion.getHdddfecregistr() != null) {
                    FECHAHISTERO = detalleDescripcion.getHdddfecregistr();
                }

                if (usuario != null &&  usuario.getHusanumeiden()!=  null) {
                    HISTORIACLINICA =  usuario.getHusanumeiden().toString();
                }
                if (usuario != null && usuario.getHuscprimerapel() !=  null) {
                    PRIMERAPELLIDO =  usuario.getHuscprimerapel();
                }
                if (usuario != null &&  usuario.getHuscsegundapel() !=  null) {
                    SEGUNDOAPELLIDO =  usuario.getHuscsegundapel();
                }
                if (usuario != null &&  usuario.getHuscprimernomb() !=  null) {
                if(usuario.getHuscsegundnomb()==null){
                    NOMBRE = usuario.getHuscprimernomb();
                }
                else{
                    NOMBRE = usuario.getHuscprimernomb() + " " +usuario.getHuscsegundnomb();
                }
                }
                if(edad!=  null){
                    EDADHISTERO= edad.toString();
                }
                if (detalleDescripcion != null &&  detalleDescripcion.getHddccirujano().toString() !=  null) {
                    CIRUJANO =  profesionalciru.getCpfcnombre();
                }
                if (detalleDescripcion != null &&  detalleDescripcion.getHddccirujano().toString() !=  null) {
                    TIEMPOQUIRURGICO =  detalleDescripcion.getHddntiempohora() +" : "+ detalleDescripcion.getHddntiempominu();
                }
                if (detalleDescripcion != null &&  detalleDescripcion.getHddcmediayud1()!=  null) {
                Cpprofesio ayudan= null;
                    ayudan = this.serviceLocator.getClinicoService().getProfesionalXCodigo(detalleDescripcion.getHddcmediayud1().toString(), getClinica().getCclncodigo()); 
                    if (null != ayudan) {
                        AYUDANTE =   ayudan.getCpfcnombre();
                    } else {
                        AYUDANTE = "";
                    }
                }
                if (detalleDescripcion != null &&  detalleDescripcion.getHddcmediayud2() !=  null) {
                    Cpprofesio ayudan2= null;
                    ayudan2 = this.serviceLocator.getClinicoService().getProfesionalXCodigo(detalleDescripcion.getHddcmediayud2().toString(), getClinica().getCclncodigo()); 
                    if (null != ayudan2) {
                        AYUDANTE2 =ayudan2.getCpfcnombre();
                    } else {
                        AYUDANTE2 = "";
                    }
                }
                if (detalleDescripcion != null &&  detalleDescripcion.getHddninstrument() !=  null) {
                    Cpprofesio instrumentador= null;
                    instrumentador = this.serviceLocator.getClinicoService().getProfesionalXCodigo(detalleDescripcion.getHddninstrument().toString(), getClinica().getCclncodigo()); 
                  if (null != instrumentador) {
                        INSTRUMENTACION =   instrumentador.getCpfcnombre();
                    } else {
                        INSTRUMENTACION = "";
                    }
                }
                if (detalleDescripcion != null &&  detalleDescripcion.getHddninstrument() !=  null) {
                    Cpprofesio anestesiologo= null;
                    if(null != detalleDescripcion.getHddcanestesiol()){
                    anestesiologo = this.serviceLocator.getClinicoService().getProfesionalXCodigo(detalleDescripcion.getHddcanestesiol(), getClinica().getCclncodigo()); 
                    ANESTESIOLOGO =   anestesiologo.getCpfcnombre();
                    }
                    else{
                        ANESTESIOLOGO =   "";
                    }
                }
                if (detalleDescripcion != null &&  detalleDescripcion.getHddctipoaneste() !=  null) {
                    if (detalleDescripcion.getHddctipoaneste().equals("2")) {
                        TIPOANESTESIA = "General";
                    }
                    if (detalleDescripcion.getHddctipoaneste().equals("3")) {
                        TIPOANESTESIA = "Local";
                    }
                    
                    if (detalleDescripcion.getHddctipoaneste().equals("4")) {
                        TIPOANESTESIA = "Regional";
                    }
                    
                    if (detalleDescripcion.getHddctipoaneste().equals("5")) {
                        TIPOANESTESIA = "Sedaci�n";
                    }
                    
                    if (detalleDescripcion.getHddctipoaneste().equals("6")) {
                        TIPOANESTESIA = "Local";
                    }
                    
                    
                    if (detalleDescripcion.getHddctipoaneste().equals("7")) {
                        TIPOANESTESIA = "Local Controlada";
                    }
                    
                    if (detalleDescripcion.getHddctipoaneste().equals("8")) {
                        TIPOANESTESIA = "Sin Anestesia";
                    }
                    
                }
                if (detalleDescripcion != null &&  detalleDescripcion.getHddncirculante() !=  null) {
                    Cpprofesio circulante= null;
                    circulante = this.serviceLocator.getClinicoService().getProfesionalXCodigo(detalleDescripcion.getHddncirculante().toString(), getClinica().getCclncodigo());
                    if (null != circulante) {
                        CIRCULANTE = circulante.getCpfcnombre();
                    } else {
                        CIRCULANTE = "";
                    }
                }
                if(detalleDescripcion != null &&  detalleDescripcion.getHddcdiagnprinc() !=  null){
                    DIAGPRINCIPAL= diagnosticoPreoperatorio;
                }
                if(detalleDescripcion != null &&  detalleDescripcion.getHddcdiagnrelac() !=  null){
                    DIAGRELACIONADO= diagnosticoPosoperatorio;
                }
                
                if(detalleDescripcion != null &&  detalleDescripcion.getHddcdescripcio() !=  null){
                    DESCRIPCIONPROCED= detalleDescripcion.getHddcdescripcio();
                }
                if(detalleDescripcion != null &&  detalleDescripcion.getHddctienepiepa() !=  null){
                    PATOLOGIA= detalleDescripcion.getHddctienepiepa();
                }
                if(detalleDescripcion != null &&  detalleDescripcion.getHddctienesangr() !=  null){
                    SANGRADOHISTERO= detalleDescripcion.getHddctienesangr();
                }
                if(detalleDescripcion != null &&  detalleDescripcion.getHddccuantifi() !=  null){
                    CUANTIFICADO= detalleDescripcion.getHddccuantifi();
                }
                if(detalleDescripcion != null &&  detalleDescripcion.getHddnsangraprox() !=  null){
                    CANTIDAD= detalleDescripcion.getHddnsangraprox().toString();
                }
                if(detalleDescripcion != null &&   detalleDescripcion.getHddctienecompl() !=  null){
                    COMPLICACION= detalleDescripcion.getHddctienecompl();
                }
                
                if(detalleDescripcion != null &&   detalleDescripcion.getHddcdiagncompl() !=  null){
                    DIAGCOMPLICACION= detalleDescripcion.getHddcdiagncompl() +" - "+ diagnosticoComplicacion;
                }
                if(detalleDescripcion != null &&   detalleDescripcion.getHddcdiagncompl() !=  null){
                    DESCRIPCOMPLIC= detalleDescripcion.getHddcdescrcompl();
                }
              
            }
            
           
                if (clinica != null && clinica.getCclncodigo() !=  null) {
                    CLINICAHISTERO =  clinica.getCclcnombre();
                }
                if(descripcion!=null){
              
                if (descripcion != null && descripcion.getHdqnsalacirugi() !=  null) {
                    SALA =  descripcion.getHdqnsalacirugi().toString();
                }
              
            }
            if(histeroscopia!=null){
                if (histeroscopia != null && histeroscopia.getHhtcintpro() != null) {
                    INTERVENCIONPROPUESTA = histeroscopia.getHhtcintpro();
                }
                if (histeroscopia != null && histeroscopia.getHhtcmedidist() != null) {
                if(histeroscopia.getHhtcmedidist().equals("GL")){
                    MEDIODISTENCION = "Glicina";
                }
                else if(histeroscopia.getHhtcmedidist().equals("SS")){
                    MEDIODISTENCION = "Solucion Salina Normal";
                    }
                }
                if (histeroscopia != null && histeroscopia.getHhtlcantirri() != null) {
                    CANTIDADIRRIGADA = histeroscopia.getHhtlcantirri().toString();
                }
                if (histeroscopia != null && histeroscopia.getHttlcantreco() != null) {
                    CANTIDADRECOLECTADA = histeroscopia.getHttlcantreco().toString();
                }
                if (histeroscopia != null && histeroscopia.getHttlbalance() != null) {
                    BALANCE = histeroscopia.getHttlbalance().toString();
                }
                if (histeroscopia != null && histeroscopia.getHttlbalposneg() != null) {
                    POSITIVONEGATIVO = histeroscopia.getHttlbalposneg();
                }
            }
        
            if (servicio != null) {
                if (servicio != null && servicio.getCsvccodigo() != null) {
                    INTERVENCIONPRACTICADA = servicio.getCsvcnombre();
                }
            }
            if (hallazgoHis != null) {
                if (hallazgoHis != null && hallazgoHis.getHhhchallazgo() != null) {
                    HALLAZGOS = hallazgoHis.getHhhchallazgo();
                  }
                if (hallazgoHis != null && hallazgoHis.getHhhcvaginosc() != null) {
                    VAGINOSCOPIA = hallazgoHis.getHhhcvaginosc();
                  }  
                if (hallazgoHis != null && hallazgoHis.getHhhccancervi() != null) {
                    CANALENDOCERVICAL = hallazgoHis.getHhhccancervi();
                  } 
                if (hallazgoHis != null && hallazgoHis.getHhhcaspeendo() != null) {
                    ASPECTOENDOMETRIO = hallazgoHis.getHhhcaspeendo();
                  }
                if (hallazgoHis != null && hallazgoHis.getHhhcostituba() != null) {
                    OSTIUMSTUBARICO = hallazgoHis.getHhhcostituba();
                  }
                if(hallazgoHis != null && hallazgoHis.getHhhcmasaintr() != null){
                    MASAINTRACAVITARIA = hallazgoHis.getHhhcmasaintr();
                }
                
                if(hallazgoHis != null && hallazgoHis.getHhhcotros() != null){
                    OTROSHOISTERO = hallazgoHis.getHhhcotros();
                }
            }
            
            if(profesionalciru !=null && profesionalciru.getCpfcnombre()!=null){
                 NOMBREPORFESIONAL=profesionalciru.getCpfcnombre();
            }
            if(profesionalciru !=null && profesionalciru.getCpfcnombre()!=null){
                 REGISTROPROFESIONAL=profesionalciru.getCpfcregmedic();
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No se pudo generar el reporte " + 
                                       e.getMessage());
        }
    }

    public void imprimirHisteroscopia() {
        this.index = -1;
        try {
            obtenerDatosReporte();
            URL url = 
                FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteHisteroscopia.jasper");
            URL url_profamilia = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_PRINCIPAL);
            
            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);

                JasperReport report = (JasperReport)JRLoader.loadObject(url);

                byte[] bytes = 
                    JasperRunManager.runReportToPdf(report, parameters, 
                                                    (JRDataSource)this);
                PdfServletUtils.showPdfDocument(bytes, 
                                                "FormatoHisteroscopia" + ".pdf", 
                                                false);
                this.generoReporte = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No se pudo generar el reporte " + 
                                       e.getMessage());
        }

        
    }
    
    public String saveAcumuladorCostos(){
       
        if(lstServicios!=null){
            List<Ctacumcosto>listaAcumulador = new ArrayList<Ctacumcosto>();
            Cnconsclin consultaAux;
            try {
                consultaAux = serviceLocator.getClinicoService().getConsultaClinicaPorId(numeroConsulta.toString());
            } catch (Exception e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }
            for(int i = 0;i<lstServicios.size();i++){
                Ctacumcosto aux = new Ctacumcosto();
                aux.setCacnclinica(new Long(getClinica().getCclncodigo()));
                if(consultaAux !=null){
                    aux.setCacnadmision(consultaAux.getCconnumdoc().longValue());
                    aux.setCacnconsclin(consultaAux.getCconnumero().longValue());
                }
                aux.setCacccargpaci(lstServicios.get(i).getCargo());
                aux.setCacctipocost("INS");
                aux.setCaccestado("VG");
                aux.setCaccinsumo(lstServicios.get(i).getCodigoServicio());
                aux.setCacclote(lstServicios.get(i).getLote());
                aux.setCaccservicio(lstServicios.get(i).getCodigoInsumo());
                aux.setCacncantidad(lstServicios.get(i).getCantidad());
                aux.setCaccunidmedi(lstServicios.get(i).getUnidadUso());
                aux.setCaccetapa("VG");
                aux.setCacdfecmov(new Date());
                aux.setCacdfecreg(new Date());
                aux.setCaccusureg(userName());
                listaAcumulador.add(aux);
            }
            try {
                serviceLocator.getCostosService().savelstCtacumcosto(listaAcumulador);
            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_GUARDADO);
            }
        }
        return null;
    }
    
    public void resetReporteHisteroscopia(){
        FECHAHISTERO= null;  
        HISTORIACLINICA= null;  
        PRIMERAPELLIDO= null;  
        SEGUNDOAPELLIDO= null;  
        NOMBRE= null;  
        CLINICAHISTERO= null;  
        SALA= null;  
        EDADHISTERO= null;  
        CIRUJANO= null;  
        TIEMPOQUIRURGICO= null;  
        ANESTESIOLOGO= null;  
        TIPOANESTESIA= null;  
        AYUDANTE= null;  
        AYUDANTE2= null;  
        INSTRUMENTACION= null;  
        CIRCULANTE= null;  
        DIAGPRINCIPAL= null;  
        DIAGRELACIONADO= null;  
        INTERVENCIONPROPUESTA= null;  
        MEDIODISTENCION= null;  
        CANTIDADIRRIGADA= null;  
        CANTIDADRECOLECTADA= null;  
        BALANCE= null;  
        POSITIVONEGATIVO= null;  
        HALLAZGOS= null;  
        VAGINOSCOPIA= null;  
        CANALENDOCERVICAL= null;  
        ASPECTOENDOMETRIO= null;  
        OSTIUMSTUBARICO= null;  
        MASAINTRACAVITARIA= null;  
        OTROSHOISTERO= null;  
        DESCRIPCIONPROCED= null;  
        PATOLOGIA= null;  
        SANGRADOHISTERO= null;  
        CUANTIFICADO= null;  
        CANTIDAD= null;  
        COMPLICACION= null;  
        DIAGCOMPLICACION= null;  
        DESCRIPCOMPLIC= null;  
        NOMBREPORFESIONAL= null;  
        REGISTROPROFESIONAL=null;
        INTERVENCIONPRACTICADA=null;
            
    }

    
    public void setHhtcmedidist(ValueChangeEvent valueChangeEvent) {
        histeroscopia.setHhtcmedidist((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public void setItCantIrrigada(UIInput itCantIrrigada) {
        this.itCantIrrigada = itCantIrrigada;
    }

    public UIInput getItCantIrrigada() {
        return itCantIrrigada;
    }

    public void setMsgElectrolitros(String msgElectrolitros) {
        this.msgElectrolitros = msgElectrolitros;
    }

    public String getMsgElectrolitros() {
        return msgElectrolitros;
    }


    public void setFECHAHISTERO(Date fECHAHISTERO) {
        this.FECHAHISTERO = fECHAHISTERO;
    }

    public Date getFECHAHISTERO() {
        return FECHAHISTERO;
    }

    public void setHISTORIACLINICA(String hISTORIACLINICA) {
        this.HISTORIACLINICA = hISTORIACLINICA;
    }

    public String getHISTORIACLINICA() {
        return HISTORIACLINICA;
    }

    public void setPRIMERAPELLIDO(String pRIMERAPELLIDO) {
        this.PRIMERAPELLIDO = pRIMERAPELLIDO;
    }

    public String getPRIMERAPELLIDO() {
        return PRIMERAPELLIDO;
    }

    public void setSEGUNDOAPELLIDO(String sEGUNDOAPELLIDO) {
        this.SEGUNDOAPELLIDO = sEGUNDOAPELLIDO;
    }

    public String getSEGUNDOAPELLIDO() {
        return SEGUNDOAPELLIDO;
    }

    public void setNOMBRE(String nOMBRE) {
        this.NOMBRE = nOMBRE;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setCLINICAHISTERO(String cLINICAHISTERO) {
        this.CLINICAHISTERO = cLINICAHISTERO;
    }

    public String getCLINICAHISTERO() {
        return CLINICAHISTERO;
    }

    public void setSALA(String sALA) {
        this.SALA = sALA;
    }

    public String getSALA() {
        return SALA;
    }

    public void setEDADHISTERO(String eDADHISTERO) {
        this.EDADHISTERO = eDADHISTERO;
    }

    public String getEDADHISTERO() {
        return EDADHISTERO;
    }

    public void setCIRUJANO(String cIRUJANO) {
        this.CIRUJANO = cIRUJANO;
    }

    public String getCIRUJANO() {
        return CIRUJANO;
    }

    public void setTIEMPOQUIRURGICO(String tIEMPOQUIRURGICO) {
        this.TIEMPOQUIRURGICO = tIEMPOQUIRURGICO;
    }

    public String getTIEMPOQUIRURGICO() {
        return TIEMPOQUIRURGICO;
    }

    public void setANESTESIOLOGO(String aNESTESIOLOGO) {
        this.ANESTESIOLOGO = aNESTESIOLOGO;
    }

    public String getANESTESIOLOGO() {
        return ANESTESIOLOGO;
    }

    public void setTIPOANESTESIA(String tIPOANESTESIA) {
        this.TIPOANESTESIA = tIPOANESTESIA;
    }

    public String getTIPOANESTESIA() {
        return TIPOANESTESIA;
    }

    public void setAYUDANTE(String aYUDANTE) {
        this.AYUDANTE = aYUDANTE;
    }

    public String getAYUDANTE() {
        return AYUDANTE;
    }

    public void setAYUDANTE2(String aYUDANTE2) {
        this.AYUDANTE2 = aYUDANTE2;
    }

    public String getAYUDANTE2() {
        return AYUDANTE2;
    }

    public void setINSTRUMENTACION(String iNSTRUMENTACION) {
        this.INSTRUMENTACION = iNSTRUMENTACION;
    }

    public String getINSTRUMENTACION() {
        return INSTRUMENTACION;
    }

    public void setCIRCULANTE(String cIRCULANTE) {
        this.CIRCULANTE = cIRCULANTE;
    }

    public String getCIRCULANTE() {
        return CIRCULANTE;
    }

    public void setDIAGPRINCIPAL(String dIAGPRINCIPAL) {
        this.DIAGPRINCIPAL = dIAGPRINCIPAL;
    }

    public String getDIAGPRINCIPAL() {
        return DIAGPRINCIPAL;
    }

    public void setDIAGRELACIONADO(String dIAGRELACIONADO) {
        this.DIAGRELACIONADO = dIAGRELACIONADO;
    }

    public String getDIAGRELACIONADO() {
        return DIAGRELACIONADO;
    }

    public void setINTERVENCIONPROPUESTA(String iNTERVENCIONPROPUESTA) {
        this.INTERVENCIONPROPUESTA = iNTERVENCIONPROPUESTA;
    }

    public String getINTERVENCIONPROPUESTA() {
        return INTERVENCIONPROPUESTA;
    }

    public void setMEDIODISTENCION(String mEDIODISTENCION) {
        this.MEDIODISTENCION = mEDIODISTENCION;
    }

    public String getMEDIODISTENCION() {
        return MEDIODISTENCION;
    }

    public void setCANTIDADIRRIGADA(String cANTIDADIRRIGADA) {
        this.CANTIDADIRRIGADA = cANTIDADIRRIGADA;
    }

    public String getCANTIDADIRRIGADA() {
        return CANTIDADIRRIGADA;
    }

    public void setCANTIDADRECOLECTADA(String cANTIDADRECOLECTADA) {
        this.CANTIDADRECOLECTADA = cANTIDADRECOLECTADA;
    }

    public String getCANTIDADRECOLECTADA() {
        return CANTIDADRECOLECTADA;
    }

    public void setBALANCE(String bALANCE) {
        this.BALANCE = bALANCE;
    }

    public String getBALANCE() {
        return BALANCE;
    }

    public void setPOSITIVONEGATIVO(String pOSITIVONEGATIVO) {
        this.POSITIVONEGATIVO = pOSITIVONEGATIVO;
    }

    public String getPOSITIVONEGATIVO() {
        return POSITIVONEGATIVO;
    }

    public void setHALLAZGOS(String hALLAZGOS) {
        this.HALLAZGOS = hALLAZGOS;
    }

    public String getHALLAZGOS() {
        return HALLAZGOS;
    }

    public void setVAGINOSCOPIA(String vAGINOSCOPIA) {
        this.VAGINOSCOPIA = vAGINOSCOPIA;
    }

    public String getVAGINOSCOPIA() {
        return VAGINOSCOPIA;
    }

    public void setCANALENDOCERVICAL(String cANALENDOCERVICAL) {
        this.CANALENDOCERVICAL = cANALENDOCERVICAL;
    }

    public String getCANALENDOCERVICAL() {
        return CANALENDOCERVICAL;
    }

    public void setASPECTOENDOMETRIO(String aSPECTOENDOMETRIO) {
        this.ASPECTOENDOMETRIO = aSPECTOENDOMETRIO;
    }

    public String getASPECTOENDOMETRIO() {
        return ASPECTOENDOMETRIO;
    }

    public void setOSTIUMSTUBARICO(String oSTIUMSTUBARICO) {
        this.OSTIUMSTUBARICO = oSTIUMSTUBARICO;
    }

    public String getOSTIUMSTUBARICO() {
        return OSTIUMSTUBARICO;
    }

    public void setMASAINTRACAVITARIA(String mASAINTRACAVITARIA) {
        this.MASAINTRACAVITARIA = mASAINTRACAVITARIA;
    }

    public String getMASAINTRACAVITARIA() {
        return MASAINTRACAVITARIA;
    }

    public void setOTROSHOISTERO(String oTROSHOISTERO) {
        this.OTROSHOISTERO = oTROSHOISTERO;
    }

    public String getOTROSHOISTERO() {
        return OTROSHOISTERO;
    }

    public void setDESCRIPCIONPROCED(String dESCRIPCIONPROCED) {
        this.DESCRIPCIONPROCED = dESCRIPCIONPROCED;
    }

    public String getDESCRIPCIONPROCED() {
        return DESCRIPCIONPROCED;
    }

    public void setPATOLOGIA(String pATOLOGIA) {
        this.PATOLOGIA = pATOLOGIA;
    }

    public String getPATOLOGIA() {
        return PATOLOGIA;
    }

    public void setSANGRADOHISTERO(String sANGRADOHISTERO) {
        this.SANGRADOHISTERO = sANGRADOHISTERO;
    }

    public String getSANGRADOHISTERO() {
        return SANGRADOHISTERO;
    }

    public void setCUANTIFICADO(String cUANTIFICADO) {
        this.CUANTIFICADO = cUANTIFICADO;
    }

    public String getCUANTIFICADO() {
        return CUANTIFICADO;
    }

    public void setCANTIDAD(String cANTIDAD) {
        this.CANTIDAD = cANTIDAD;
    }

    public String getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCOMPLICACION(String cOMPLICACION) {
        this.COMPLICACION = cOMPLICACION;
    }

    public String getCOMPLICACION() {
        return COMPLICACION;
    }

    public void setDIAGCOMPLICACION(String dIAGCOMPLICACION) {
        this.DIAGCOMPLICACION = dIAGCOMPLICACION;
    }

    public String getDIAGCOMPLICACION() {
        return DIAGCOMPLICACION;
    }

    public void setDESCRIPCOMPLIC(String dESCRIPCOMPLIC) {
        this.DESCRIPCOMPLIC = dESCRIPCOMPLIC;
    }

    public String getDESCRIPCOMPLIC() {
        return DESCRIPCOMPLIC;
    }

    public void setNOMBREPORFESIONAL(String nOMBREPORFESIONAL) {
        this.NOMBREPORFESIONAL = nOMBREPORFESIONAL;
    }

    public String getNOMBREPORFESIONAL() {
        return NOMBREPORFESIONAL;
    }

    public void setREGISTROPROFESIONAL(String rEGISTROPROFESIONAL) {
        this.REGISTROPROFESIONAL = rEGISTROPROFESIONAL;
    }

    public String getREGISTROPROFESIONAL() {
        return REGISTROPROFESIONAL;
    }

    public void setINTERVENCIONPRACTICADA(String iNTERVENCIONPRACTICADA) {
        this.INTERVENCIONPRACTICADA = iNTERVENCIONPRACTICADA;
    }

    public String getINTERVENCIONPRACTICADA() {
        return INTERVENCIONPRACTICADA;
    }

    public void setAnestOblig(Boolean anestOblig) {
        this.anestOblig = anestOblig;
    }

    public Boolean getAnestOblig() {
        return anestOblig;
    }

    public void setMostrarSangradoCuanti(boolean mostrarSangradoCuanti) {
        this.mostrarSangradoCuanti = mostrarSangradoCuanti;
    }

    public boolean isMostrarSangradoCuanti() {
        return mostrarSangradoCuanti;
    }

    public void setMostrarDiureCuanti(boolean mostrarDiureCuanti) {
        this.mostrarDiureCuanti = mostrarDiureCuanti;
    }

    public boolean isMostrarDiureCuanti() {
        return mostrarDiureCuanti;
    }
    

    public void setRenderAnestesiologo(boolean renderAnestesiologo) {
        this.renderAnestesiologo = renderAnestesiologo;
    }

    public boolean isRenderAnestesiologo() {
        return renderAnestesiologo;
    }

    public void setMnuTipoAnestesia(UIInput mnuTipoAnestesia) {
        this.mnuTipoAnestesia = mnuTipoAnestesia;
    }

    public UIInput getMnuTipoAnestesia() {
        return mnuTipoAnestesia;
    }

    public void setSer(Cpservicio ser) {
        this.ser = ser;
    }

    public Cpservicio getSer() {
        return ser;
    }

  

    public void setFlagCostos(boolean flagCostos) {
        this.flagCostos = flagCostos;
    }

    public boolean isFlagCostos() {
        return flagCostos;
    }

    public void setDtServiciosCostos(HtmlDataTable dtServiciosCostos) {
        this.dtServiciosCostos = dtServiciosCostos;
    }

    public HtmlDataTable getDtServiciosCostos() {
        return dtServiciosCostos;
    }

    public void setLstServicios(List<FichaTecnicaCostosDTO> lstServicios) {
        this.lstServicios = lstServicios;
    }

    public List<FichaTecnicaCostosDTO> getLstServicios() {
        return lstServicios;
    }
}

