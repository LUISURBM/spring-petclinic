//======================================================================================================================
// ARCHIVO TomaCitologiaBean
// FECHA CREACI�N: 
// AUTOR: jariano, nlis
// Descripcion: 
//======================================================================================================================
package org.profamilia.hc.view.backing.procedimiento;
//======================================================================================================================
//  BIBLIOTECAS REQUERIDAS
//======================================================================================================================

import java.math.BigDecimal;

import java.net.URL;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cncitotoma;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cndesccito;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.webService.CodigoQRClient;
import org.profamilia.hc.view.backing.webService.RegistraEpicienterResult;
import org.profamilia.hc.view.backing.webService.TomaVphWS;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.ModuleConfig;
import org.profamilia.hc.view.util.PdfServletUtils;


//======================================================================================================================
//  CLASE EntregaCitologiaBean
//======================================================================================================================

public class TomaCitologiaBean extends BaseBean implements JRDataSource {

    //------------------------------------------------------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //------------------------------------------------------------------------------------------------------------------
    private Cncitotoma toma;

    private List lstEsquema;

    private List lstOpciones;

    private List lstOpcionesvph;

    private List lstMetodos;

    private List lstResultado;

    private List lstOpcionesInvertido;

    private List lstTomada;
    
    private List lstTipoUsuario; 

    private boolean esCeroGestaciones;

    private boolean esCeroPartos;

    private boolean mostrarResultado;

    private boolean mostrarFechaCauterizacion;

    private boolean mostrarFechaHisterectomia;

    private boolean mostrarFechaConizacion;

    private boolean mostrarFechaBiopsia;

    private boolean mostrarFechaCrioterapia;

    private boolean mostrarFechaRadioterapia;

    private boolean mostrarFechaATA;

    private boolean mostrarFechaOtro;

    private boolean mostrarFechaVaporizacion;

    private boolean mostrarFechaHormonal;

    private boolean mostrarProcedimiento;

    private boolean modoConsulta;

    private boolean mostrarhallazgos;

    private boolean mostrarotrometodo;

    private boolean renderTiempoUso;

    private Cncitologi citologia;

    private List lstAspecto;

    private List lstAspectoSelect;

    private int index = -1;


    private boolean generoCitologia;

    private static int NUMERO_COPIAS = 1;


    private boolean temporal;

    private boolean mostrarvph;

    private Integer consecCitologia;

    private UIInput mnuCauterizacion;
    private UIInput mnuHistectomia;

    private UIInput mnuVaporizacion;
    private UIInput mnuHormonal;

    private UIInput mnuConizacion;
    private UIInput mnuRadioterapia;
    private UIInput mnuBiopsia;
    private UIInput mnuCrioterapia;
    private UIInput mnuATA;
    private UIInput mnuOtro;
    private UIInput mnuResultado;
    private UIInput mnuColpos;
    private UIInput itNumPartos;
    


    private Integer tipoHistoria;

    private String nextAction;

    private String menuBean;

    private String navigationRule;

    private Cnconsclin consulta;

    private String tipoServicio;

    private Chusuario usuario;
    
    private boolean esPolicia;


    String APELLIDOS;
    String NOMBRES;
    Long NUMERO_DOCUMENTO;
    String TIPO_DOCUMENTO;
    String DIRECCION;
    String TELEFONO;
    String CIUDAD;
    String DEPARTAMENTO;
    String OTRA_DIRECCION;
    String OTRO_TELEFONO;
    String OTRA_CIUDAD;
    String OTRO_DEPARTAMENTO;
    Integer EDAD;
    Date FECHA_REGLA;
    String DIA_REGLA;
    String MES_REGLA;
    String ANNO_REGLA;

    Integer GESTACIONES;
    Integer PARTOS;
    Integer ABORTOS;
    String TIPO_AFILIACION;
    String ASEGURADORA;
    String ESQUEMA_CITOLOGIA;
    String APECTO_CUELLO;

    Date FECHA_PARTO;
    String DIA_PARTO;
    String MES_PARTO;
    String ANNO_PARTO;

    String ESTA_EMBARAZADA;
    Integer EDAD_RELACIONES;
    String METODO_PLANIFICACION;
    Date FECHA_CITOLOGIA;
    String DIA_CITOLOGIA;
    String MES_CITOLOGIA;
    String ANNO_CITOLOGIA;
    String RESULTADO_CITOLOGIA;

    Date FECHA_CAUTERIZACION;
    Date FECHA_HISTERECTOMIA;
    Date FECHA_CONIZACION;
    Date FECHA_RADIOTERAPIA;
    Date FECHA_BIOPSA;
    Date FECHA_CRIOTERAPIA;
    Date FECHA_ATA;
    Date FECHA_OTRO;
    Date FECHA_COLPOSCOPIA;
    String OTRO_CUAL;
    String NINGUNO;
    String CAUTERIZACION;
    String HISTERECTOMIA;
    String CONIZACION;
    String RADIOTERAPIA;
    String BIOPSIA;
    String CRIOTERAPIA;
    String ATA;
    String OTRO;
    String COLPOSCOPIA;
    String TOMADA;
    Date FECHA_TOMADA;
    String NOMBRE_TOMADA;
    Integer NUMERO_CITOLOGIA;
    Date FECHA_VPH;

    Integer DOSIS_VPH;
    String VPH;
    String OBSERVACIONES_TOMA;
    String OTROS_HALLAZGOS;

    String OTRO_METODO;

    String ES_SANO;
    String ES_AUSENTE;
    String ES_EROSIONADO;
    String ES_CONGESTIVO;
    String ES_ATROFICO;
    String ES_ULCERADO;
    String ES_SANGRANTE;
    String ES_LESION_VISIBLE;
    String ES_POLIPO;
    String CENTRO;
    String NUMERO_FAC;
    String VAPORIZACION;
    Date FECHA_VAPORIZACION;
    String HORMONAL;
    Date FECHA_HORMONAL;
    BigDecimal TIEMPO_METODO;
    String COMPLETO_VPH;
    String LACTANCIA_ACTUAL;
    String OTROS_HALLAZGOS_TOMA;
    private TomaVphWS tomaVphWS;
    private boolean mostrarOtroEsquema;
    private boolean mostrarNumDosisAdmini;
    private List lstResultTipificacion;
    private boolean mostrarResultTipificacion;
    private boolean mostrarFechaColpos;
    
    //Variables VPH
    Integer numeroTipificacion;
    String centro;
    String apellidos;
    String nombres;
    String tipoDocumento;
    Long numeroDocumento;
    Integer edad;
    String aseguradora;
    String direccion;
    String telefono;
    String ciudad;
    String departamento;
    String otraDireccion;
    String otroTelefono;
    String otraCiudad;
    String otroDepartamento;
    String identidadGenero;
    String vulnerabilidad;
    String esquemaVph;
    String esquemaVphCualOtro;
    Integer gestaciones;
    Integer partos;
    Integer abortos;
    String estaEmbarazada;
    String planeaEmbarazoAntesAnho;
    Integer edadRelaciones;
    String metodoPlanificacion;
    String otroMetodoPlanificacion;
    String resultadoCitologia;
    String otroResultadoCitologia;
    String completoVph;
    String lactanciaActual;
    String cauterizacion;
    String histerectomia;
    String conizacion;
    String radioterapia;
    String biopsia;
    String crioterapia;
    String ata;
    String colposcopia;
    String vaporizacion;
    String tratamientoHormonal;
    String otroProcedimiento;
    String cualOtroProcedimiento;
    String ningunProcedimiento;
    String cuelloSano;
    String cuelloAusente;
    String cuelloErosionado;
    String cuelloCongestivo;
    String cuelloAtrofico;
    String cuelloUlcerado;
    String cuelloSangrante;
    String cuelloLesionVisible;
    String cuelloPolipo;
    String tomaObservaciones;
    String tomaTipoProfesional;
    String tomaNombreProfesional;
    String tomaTarjetaProfesional;
    String lecturaTipoProfesional;
    String lecturaNombreProfesional;
    String lecturaTarjetaProfesional;
    String conducta;
    String diaRegla;
    String mesRegla;
    String anoRegla;
    Integer dosisVph;
    String diaVph;
    String mesVph;
    String anoVph;
    String diaParto;
    String mesParto;
    String anoParto;
    String diaCitologia;
    String mesCitologia;
    String anoCitologia;
    String diaCauterizacion;
    String mesCauterizacion;
    String anoCauterizacion;
    String diaHisterectomia;
    String mesHisterectomia;
    String anoHisterectomia;
    String diaConizacion;
    String mesConizacion;
    String anoConizacion;
    String diaRadioterapia;
    String mesRadioterapia;
    String anoRadioterapia;
    String diaBiopsia;
    String mesBiopsia;
    String anoBiopsia;
    String diaCrioterapia;
    String mesCrioterapia;
    String anoCrioterapia;
    String diaAta;
    String mesAta;
    String anoAta;
    String diaOtro;
    String mesOtro;
    String anoOtro;
    String diaTomada;
    String mesTomada;
    String anoTomada;
    String diaColpo;
    String mesColpo;
    String anoColpo;
    String diaVaporizacion;
    String mesVaporizacion;
    String anoVaporizacion;
    String diaTratamientoHormonal;
    String mesTratamientoHormonal;
    String anoTratamientoHormonal;
    String ninguna;
    String habitanteCalle;
    String desmovilizado;
    String inmigrante;
    String poblacionInfantilCargoICBF;
    String poblacionAfectadasConflictoArmado;
    String madreComunitaria;
    String trabajadoresSexuales;
    String personadiscapacidad;
    String  personaPrivadaLibertad;
    String tipificacion;
    String baseLiquida;
    String convencional;
    Integer numeroBaseLiquida;
    Integer numeroConvencional;
    String esquemaCitologia;
    String otroEsquemaCitologia;
    String resultadoTipificacion;
    
    // Variables codigo QR
    String NOMBRE;
    String TIPO_IDENTIFICACION;
    String NUMERO_IDENTIFICACION;
    String NUMERO_CITOLOGIA_VPH;
    String FECHA_TOMA;
    String CLINICA;
    
    private CodigoQRClient codigoQRClient;
    
    private boolean imprimirCodigoQRvph;
    
    private List lstEsquemaVph;
    
    private boolean mostrarOtroEsquemaVph;


    //------------------------------------------------------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //------------------------------------------------------------------------------------------------------------------

    public TomaCitologiaBean() {


    }

    public void init() {


        toma = new Cncitotoma();
        lstAspecto = new ArrayList();
        lstEsquema = new ArrayList();
        lstEsquemaVph = new ArrayList();
        lstOpciones = new ArrayList();
        lstMetodos = new ArrayList();
        lstResultado = new ArrayList();
        lstOpcionesInvertido = new ArrayList();
        lstTomada = new ArrayList();
        lstOpcionesvph = new ArrayList();
        lstAspectoSelect = new ArrayList();
        lstTipoUsuario = new ArrayList();
        lstResultTipificacion = new ArrayList();
        inicializarTomaCitologia();
    }

    public void inicializarTomaCitologia() {
        generoCitologia = false;
        mostrarResultado = false;
        esCeroPartos = false;


        try {
            if (consulta != null) {
                citologia = 
                        this.serviceLocator.getClinicoService().getUsuarioCitologia(consulta);
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (citologia != null) {
            consecCitologia = citologia.getCcinconsec();
            if(tipoHistoria == null){
                tipoHistoria = citologia.getCcintiphis();
            }
            try {
                toma = this.serviceLocator.getClinicoService().getTomaCitologia(citologia.getCcinconsec());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (toma == null) {
            toma = new Cncitotoma();


        } else {

            if (toma.getCtmdultcit() != null) {
                mostrarResultado = true;
            } else {
                mostrarResultado = false;
                mostrarhallazgos = false;
            }

            if (toma.getCtmcultres() != null && 
                toma.getCtmcultres().equals("2.2")) {
                mostrarhallazgos = true;
            } else {
                mostrarhallazgos = false;
            }

            if (toma.getCtmcaspcue() != null && 
                !toma.getCtmcaspcue().equals("NA")) {
                modoConsulta = true;
            } else {
                modoConsulta = false;
            }


            if (toma.getCtmcaspcue() != null && 
                !toma.getCtmcaspcue().equals("")) {
                StringTokenizer st = 
                    new StringTokenizer(toma.getCtmcaspcue(), ",");
                while (st.hasMoreTokens()) {
                    String aspec = st.nextToken();
                    lstAspectoSelect.add(aspec);
                }
            }


            if (toma.getCtmngestac() != null && 
                toma.getCtmngestac().compareTo(0) == 0) {
                esCeroGestaciones = true;
            } else {
                esCeroGestaciones = false;
            }

            if (toma.getCtmcpningu() != null && 
                toma.getCtmcpningu().equals("N")) {
                mostrarProcedimiento = true;

            } else {
                mostrarProcedimiento = false;
            }

            if (toma.getCtmcpcaute() != null && toma.getCtmcpcaute() != null && 
                toma.getCtmcpcaute().equals("S")) {
                mostrarFechaCauterizacion = true;
            } else {
                mostrarFechaCauterizacion = false;
            }

            if (toma.getCtmcphiste() != null && toma.getCtmcphiste() != null && 
                toma.getCtmcphiste().equals("S")) {
                mostrarFechaHisterectomia = true;
            } else {
                mostrarFechaHisterectomia = false;
            }

            if (toma.getCtmcpconiz() != null && toma.getCtmcpconiz() != null && 
                toma.getCtmcpconiz().equals("S")) {
                mostrarFechaConizacion = true;
            } else {
                mostrarFechaConizacion = false;
            }

            if (toma.getCtmcpbiops() != null && toma.getCtmcpbiops() != null && 
                toma.getCtmcpbiops().equals("S")) {
                mostrarFechaBiopsia = true;
            } else {
                mostrarFechaBiopsia = false;
            }
            if (toma.getCtmcpcriot() != null && toma.getCtmcpcriot() != null && 
                toma.getCtmcpcriot().equals("S")) {
                mostrarFechaCrioterapia = true;
            } else {
                mostrarFechaCrioterapia = false;
            }

            if (toma.getCtmcpata() != null && toma.getCtmcpata() != null && 
                toma.getCtmcpata().equals("S")) {
                mostrarFechaATA = true;
            } else {
                mostrarFechaATA = false;
            }
            if (toma.getCtmcpotro() != null && toma.getCtmcpotro() != null && 
                toma.getCtmcpotro().equals("S")) {
                mostrarFechaOtro = true;
            } else {
                mostrarFechaOtro = false;
            }

            if (toma.getCtmcpradio() != null && toma.getCtmcpradio() != null && 
                toma.getCtmcpradio().equals("S")) {
                mostrarFechaRadioterapia = true;
            } else {
                mostrarFechaRadioterapia = false;
            }

            if (toma.getCtmcpvapor() != null && 
                toma.getCtmcpvapor().equals("S")) {
                mostrarFechaVaporizacion = true;
            } else {
                mostrarFechaVaporizacion = false;
            }

            if (toma.getCtmcphormo() != null && 
                toma.getCtmcphormo().equals("S")) {
                mostrarFechaHormonal = true;
            } else {
                mostrarFechaHormonal = false;
            }

        }
    }


    //------------------------------------------------------------------------------------------------------------------
    //  Get/Set
    //------------------------------------------------------------------------------------------------------------------

    /**
     * @param lstEsquema
     */
    public void setLstEsquema(List lstEsquema) {
        this.lstEsquema = lstEsquema;
    }

    /**
     * @return
     */
    public List getLstEsquema() {
        if (lstEsquema.size() == 0) {
            ArrayList<Cndesccito> lstTomaAux = null;
            try {

                    lstTomaAux = 
                            (ArrayList<Cndesccito>)this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitotoma", 
                                                                                                                               "ctmcesquem");  
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstTomaAux.isEmpty()) {

                lstEsquema.add(new SelectItem("", 
                                              "Seleccione una opcion ..."));
                Iterator it = lstTomaAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstEsquema.add(new SelectItem((lstTomaAux.get(i).getCdicvalor()), 
                                                  lstTomaAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstEsquema;
    }

    /**
     * @param toma
     */
    public void setToma(Cncitotoma toma) {
        this.toma = toma;
    }

    /**
     * @return
     */
    public Cncitotoma getToma() {
        return toma;
    }

    /**
     * @param citologia
     */
    public void setCitologia(Cncitologi citologia) {
        this.citologia = citologia;
    }

    /**
     * @return
     */
    public Cncitologi getCitologia() {
        return citologia;
    }

    /**
     * @param esCeroGestaciones
     */
    public void setEsCeroGestaciones(boolean esCeroGestaciones) {
        this.esCeroGestaciones = esCeroGestaciones;
    }

    /**
     * @return
     */
    public boolean isEsCeroGestaciones() {
        return esCeroGestaciones;
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
            ArrayList<Cndesccito> lstTomaAux = null;
            try {
                lstTomaAux = 
                        (ArrayList<Cndesccito>)this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitotoma", 
                                                                                                                           "ctmcembara");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstTomaAux.isEmpty()) {
                Iterator it = lstTomaAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstOpciones.add(new SelectItem((lstTomaAux.get(i).getCdicvalor()), 
                                                   lstTomaAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstOpciones;
    }

    /**
     * @param lstMetodos
     */
    public void setLstMetodos(List lstMetodos) {
        this.lstMetodos = lstMetodos;
    }

    /**
     * @return
     */
    public List getLstMetodos() {
        if (lstMetodos.size() == 0) {
            ArrayList<Cndesccito> lstMetodosAux = null;
            try {
                lstMetodosAux = 
                        (ArrayList<Cndesccito>)this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitotoma", 
                                                                                                                           "ctmcmetpla");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstMetodosAux.isEmpty()) {

                lstMetodos.add(new SelectItem("", 
                                              "Seleccione una opcion ..."));
                Iterator it = lstMetodosAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstMetodos.add(new SelectItem((lstMetodosAux.get(i).getCdicvalor()), 
                                                  lstMetodosAux.get(i).getCdicvalor() + 
                                                  "  " + 
                                                  lstMetodosAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstMetodos;
    }

    /**
     * @param lstResultado
     */
    public void setLstResultado(List lstResultado) {
        this.lstResultado = lstResultado;
    }

    /**
     * @return
     */
    public List getLstResultado() {
        if (lstResultado.size() == 0) {
            ArrayList<Cndesccito> lstMetodosAux = null;
            try {
                lstMetodosAux = 
                        (ArrayList<Cndesccito>)this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitotoma", 
                                                                                                                           "ctmcultres");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstMetodosAux.isEmpty()) {

                lstResultado.add(new SelectItem("", 
                                                "Seleccione una opcion ..."));
                Iterator it = lstMetodosAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstResultado.add(new SelectItem((lstMetodosAux.get(i).getCdicvalor()), 
                                                    lstMetodosAux.get(i).getCdicvalor() + 
                                                    "  " + 
                                                    lstMetodosAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstResultado;
    }

    /**
     * @param mostrarvph
     */
    public void setMostrarvph(boolean mostrarvph) {
        this.mostrarvph = mostrarvph;
    }

    /**
     * @return
     */
    public boolean isMostrarvph() {
        return mostrarvph;
    }

    /**
     * @param lstOpcionesProcedimiento
     */
    public void setLstOpcionesInvertido(List lstOpcionesProcedimiento) {
        this.lstOpcionesInvertido = lstOpcionesProcedimiento;
    }

    /**
     * @return
     */
    public List getLstOpcionesInvertido() {
        if (lstOpcionesInvertido.size() == 0) {
            //Se cambio que cuando escoja SI guarde 'N' y cuando escoja NO guarde 'S', 
            // porque se cambio la pregunta En la capa de presentacion, de ninguna  a  Tiene Procedimientos Anteriores
            lstOpcionesInvertido.add(new SelectItem("N", "Si"));
            lstOpcionesInvertido.add(new SelectItem("S", "No"));
        }
        return lstOpcionesInvertido;
    }


    /**
     * @param lstOpcionesvph
     */
    public void setLstOpcionesvph(List lstOpcionesvph) {
        this.lstOpcionesvph = lstOpcionesvph;
    }

    /**
     * @return
     */
    public List getLstOpcionesvph() {
        if (lstOpcionesvph.size() == 0) {
            lstOpcionesvph.add(new SelectItem("S", "Si"));
            lstOpcionesvph.add(new SelectItem("N", "No"));
        }
        return lstOpcionesvph;
    }

    /**
     * @param consecCitologia
     */
    public void setConsecCitologia(Integer consecCitologia) {
        this.consecCitologia = consecCitologia;
    }

    /**
     * @return
     */
    public Integer getConsecCitologia() {
        return consecCitologia;
    }


    /**
     * @param mostrarFechaCauterizacion
     */
    public void setMostrarFechaCauterizacion(boolean mostrarFechaCauterizacion) {
        this.mostrarFechaCauterizacion = mostrarFechaCauterizacion;
    }

    /**
     * @return
     */
    public boolean isMostrarFechaCauterizacion() {
        return mostrarFechaCauterizacion;
    }

    /**
     * @param esCeroPartos
     */
    public void setEsCeroPartos(boolean esCeroPartos) {
        this.esCeroPartos = esCeroPartos;
    }

    /**
     * @return
     */
    public boolean isEsCeroPartos() {
        return esCeroPartos;
    }

    /**
     * @param mostrarFechaHisterectomia
     */
    public void setMostrarFechaHisterectomia(boolean mostrarFechaHisterectomia) {
        this.mostrarFechaHisterectomia = mostrarFechaHisterectomia;
    }

    /**
     * @param temporal
     */
    public void setTemporal(boolean temporal) {
        this.temporal = temporal;
    }

    /**
     * @return
     */
    public boolean isTemporal() {
        return temporal;
    }

    /**
     * @return
     */
    public boolean isMostrarFechaHisterectomia() {
        return mostrarFechaHisterectomia;
    }

    /**
     * @param mostrarFechaConizacion
     */
    public void setMostrarFechaConizacion(boolean mostrarFechaConizacion) {
        this.mostrarFechaConizacion = mostrarFechaConizacion;
    }

    /**
     * @return
     */
    public boolean isMostrarFechaConizacion() {
        return mostrarFechaConizacion;
    }

    /**
     * @param generoCitologia
     */
    public void setGeneroCitologia(boolean generoCitologia) {
        this.generoCitologia = generoCitologia;
    }

    /**
     * @return
     */
    public boolean isGeneroCitologia() {
        return generoCitologia;
    }

    /**
     * @param modoConsulta
     */
    public void setModoConsulta(boolean modoConsulta) {
        this.modoConsulta = modoConsulta;
    }

    /**
     * @return
     */
    public boolean isModoConsulta() {
        return modoConsulta;
    }

    /**
     * @param mostrarResultado
     */
    public void setMostrarResultado(boolean mostrarResultado) {
        this.mostrarResultado = mostrarResultado;
    }

    /**
     * @return
     */
    public boolean isMostrarResultado() {
        return mostrarResultado;
    }

    /**
     * @param mostrarFechaBiopsia
     */
    public void setMostrarFechaBiopsia(boolean mostrarFechaBiopsia) {
        this.mostrarFechaBiopsia = mostrarFechaBiopsia;
    }

    /**
     * @return
     */
    public boolean isMostrarFechaBiopsia() {
        return mostrarFechaBiopsia;
    }

    /**
     * @param mostrarFechaCrioterapia
     */
    public void setMostrarFechaCrioterapia(boolean mostrarFechaCrioterapia) {
        this.mostrarFechaCrioterapia = mostrarFechaCrioterapia;
    }

    /**
     * @return
     */
    public boolean isMostrarFechaCrioterapia() {
        return mostrarFechaCrioterapia;
    }

    /**
     * @param mostrarFechaATA
     */
    public void setMostrarFechaATA(boolean mostrarFechaATA) {
        this.mostrarFechaATA = mostrarFechaATA;
    }

    /**
     * @return
     */
    public boolean isMostrarFechaATA() {
        return mostrarFechaATA;
    }

    /**
     * @param mostrarFechaOtro
     */
    public void setMostrarFechaOtro(boolean mostrarFechaOtro) {
        this.mostrarFechaOtro = mostrarFechaOtro;
    }

    /**
     * @return
     */
    public boolean isMostrarFechaOtro() {
        return mostrarFechaOtro;
    }

    /**
     * @param mostrarProcedimiento
     */
    public void setMostrarProcedimiento(boolean mostrarProcedimiento) {
        this.mostrarProcedimiento = mostrarProcedimiento;
    }

    /**
     * @return
     */
    public boolean isMostrarProcedimiento() {
        return mostrarProcedimiento;
    }

    /**
     * @param mostrarFechaRadioterapia
     */
    public void setMostrarFechaRadioterapia(boolean mostrarFechaRadioterapia) {
        this.mostrarFechaRadioterapia = mostrarFechaRadioterapia;
    }

    /**
     * @return
     */
    public boolean isMostrarFechaRadioterapia() {
        return mostrarFechaRadioterapia;
    }

    /**
     * @param mnuCauterizacion
     */
    public void setMnuCauterizacion(UIInput mnuCauterizacion) {
        this.mnuCauterizacion = mnuCauterizacion;
    }

    /**
     * @return
     */
    public UIInput getMnuCauterizacion() {
        return mnuCauterizacion;
    }

    /**
     * @param mnuHistectomia
     */
    public void setMnuHistectomia(UIInput mnuHistectomia) {
        this.mnuHistectomia = mnuHistectomia;
    }

    /**
     * @return
     */
    public UIInput getMnuHistectomia() {
        return mnuHistectomia;
    }

    /**
     * @param mnuConizacion
     */
    public void setMnuConizacion(UIInput mnuConizacion) {
        this.mnuConizacion = mnuConizacion;
    }

    /**
     * @return
     */
    public UIInput getMnuConizacion() {
        return mnuConizacion;
    }

    /**
     * @param mnuRadioterapia
     */
    public void setMnuRadioterapia(UIInput mnuRadioterapia) {
        this.mnuRadioterapia = mnuRadioterapia;
    }

    /**
     * @return
     */
    public UIInput getMnuRadioterapia() {
        return mnuRadioterapia;
    }

    /**
     * @param mnuBiopsia
     */
    public void setMnuBiopsia(UIInput mnuBiopsia) {
        this.mnuBiopsia = mnuBiopsia;
    }

    /**
     * @return
     */
    public UIInput getMnuBiopsia() {
        return mnuBiopsia;
    }

    /**
     * @param mnuCrioterapia
     */
    public void setMnuCrioterapia(UIInput mnuCrioterapia) {
        this.mnuCrioterapia = mnuCrioterapia;
    }

    /**
     * @return
     */
    public UIInput getMnuCrioterapia() {
        return mnuCrioterapia;
    }

    /**
     * @param mnuATA
     */
    public void setMnuATA(UIInput mnuATA) {
        this.mnuATA = mnuATA;
    }

    /**
     * @return
     */
    public UIInput getMnuATA() {
        return mnuATA;
    }

    /**
     * @param consulta
     */
    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    /**
     * @return
     */
    public Cnconsclin getConsulta() {
        return consulta;
    }

    /**
     * @param mnuOtro
     */
    public void setMnuOtro(UIInput mnuOtro) {
        this.mnuOtro = mnuOtro;
    }

    /**
     * @return
     */
    public UIInput getMnuOtro() {
        return mnuOtro;
    }

    /**
     * @param lstTomada
     */
    public void setLstTomada(List lstTomada) {
        this.lstTomada = lstTomada;
    }

    /**
     * @return
     */
    public List getLstTomada() {
        if (lstTomada.size() == 0) {
            ArrayList<Cndesccito> lstTomadaAux = null;
            try {
                lstTomadaAux = 
                        (ArrayList<Cndesccito>)this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitotoma", 
                                                                                                                           "ctmctomada");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstTomadaAux.isEmpty()) {

                lstTomada.add(new SelectItem("", "Seleccione una opcion ..."));
                Iterator it = lstTomadaAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstTomada.add(new SelectItem((lstTomadaAux.get(i).getCdicvalor()), 
                                                 lstTomadaAux.get(i).getCdicvalor() + 
                                                 "  " + 
                                                 lstTomadaAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstTomada;
    }


    /**
     * @param lstAspecto
     */
    public void setLstAspecto(List lstAspecto) {
        this.lstAspecto = lstAspecto;
    }

    /**
     * @return
     */
    public List getLstAspecto() {
        if (lstAspecto.size() == 0) {
            ArrayList<Cndesccito> lstMetodosAux = null;
            try {
                lstMetodosAux = 
                        (ArrayList<Cndesccito>)this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitotoma", 
                                                                                                                           "ctmcaspcue");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstMetodosAux.isEmpty()) {
                Iterator it = lstMetodosAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstAspecto.add(new SelectItem((lstMetodosAux.get(i).getCdicvalor()), 
                                                  lstMetodosAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstAspecto;
    }

    /**
     * @param mostrarhallazgos
     */
    public void setMostrarhallazgos(boolean mostrarhallazgos) {
        this.mostrarhallazgos = mostrarhallazgos;
    }

    /**
     * @return
     */
    public boolean isMostrarhallazgos() {
        return mostrarhallazgos;
    }


    /**
     * @param mnuResultado
     */
    public void setMnuResultado(UIInput mnuResultado) {
        this.mnuResultado = mnuResultado;
    }

    /**
     * @return
     */
    public UIInput getMnuResultado() {
        return mnuResultado;
    }

    /**
     * @param mostrarotrometodo
     */
    public void setMostrarotrometodo(boolean mostrarotrometodo) {
        this.mostrarotrometodo = mostrarotrometodo;
    }

    /**
     * @return
     */
    public boolean isMostrarotrometodo() {
        return mostrarotrometodo;
    }

    /**
     * @param lstAspectoSelect
     */
    public void setLstAspectoSelect(List lstAspectoSelect) {
        this.lstAspectoSelect = lstAspectoSelect;
    }

    /**
     * @return
     */
    public List getLstAspectoSelect() {
        return lstAspectoSelect;
    }

    /**
     * @param tipoHistoria
     */
    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    /**
     * @return
     */
    public Integer getTipoHistoria() {
        return tipoHistoria;
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
     * @param navigationRule
     */
    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    /**
     * @return
     */
    public String getNavigationRule() {
        return navigationRule;
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


    //------------------------------------------------------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //------------------------------------------------------------------------------------------------------------------

    /**
     * @param valueChangeEvent
     */
    public void setNumeroGestaciones(ValueChangeEvent valueChangeEvent) {
        toma.setCtmngestac((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setCtmnpartos(ValueChangeEvent valueChangeEvent) {
        toma.setCtmnpartos((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setCtmcpningu(ValueChangeEvent valueChangeEvent) {
        toma.setCtmcpningu((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setCtmcpcaute(ValueChangeEvent valueChangeEvent) {
        toma.setCtmcpcaute((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setCtmcphiste(ValueChangeEvent valueChangeEvent) {
        toma.setCtmcphiste((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setCtmcpconiz(ValueChangeEvent valueChangeEvent) {
        toma.setCtmcpconiz((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setCtmcpradio(ValueChangeEvent valueChangeEvent) {
        toma.setCtmcpradio((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setCtmcpbiops(ValueChangeEvent valueChangeEvent) {
        toma.setCtmcpbiops((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setCtmcpcriot(ValueChangeEvent valueChangeEvent) {
        toma.setCtmcpcriot((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setCtmcpata(ValueChangeEvent valueChangeEvent) {
        toma.setCtmcpata((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setCtmcpotro(ValueChangeEvent valueChangeEvent) {
        toma.setCtmcpotro((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setCtmdultcit(ValueChangeEvent valueChangeEvent) {
        toma.setCtmdultcit((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setCtmcultres(ValueChangeEvent valueChangeEvent) {
        toma.setCtmcultres((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setCtmcmetpla(ValueChangeEvent valueChangeEvent) {
        toma.setCtmcmetpla((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setCtmcpvapor(ValueChangeEvent valueChangeEvent) {
        toma.setCtmcpvapor((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setCtmcphormo(ValueChangeEvent valueChangeEvent) {
        toma.setCtmcphormo((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setCtmcpcolpo(ValueChangeEvent valueChangeEvent) {
        toma.setCtmcpcolpo((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void changeNumeroGestaciones() {
        esCeroPartos = false; 
        if (toma != null && toma.getCtmngestac().compareTo(0) == 0) {
            toma.setCtmngestac(0);
            toma.setCtmnaborto(0);
            toma.setCtmnpartos(0);
            toma.setCtmdultpar(null);
            itNumPartos.setValue(0);
            esCeroGestaciones = true;
            esCeroPartos = true; 
        } else {

            toma.setCtmnaborto(null);
            toma.setCtmnpartos(null);
            toma.setCtmdultpar(null);
            esCeroGestaciones = false;
        }
    }


    public void changeNumeroPartos() {
        esCeroPartos = false;
        if (toma != null && toma.getCtmnpartos() != null && 
            toma.getCtmnpartos().compareTo(0) == 0) {
            toma.setCtmdultpar(null);
            esCeroPartos = true;
        } else {
            toma.setCtmdultpar(null);
        }
    }


    public void cargarDatos() {
        Chantegineco antecedentes;
        antecedentes = null;


        try {
            if (usuario != null && usuario.getHuslnumero() != null) {
                antecedentes = 
                        serviceLocator.getClinicoService().getUltimoAntecedentesGinecologicos(usuario.getHuslnumero());
            }


            if (antecedentes != null) {
                if (antecedentes.getHagdfuc() != null) {
                    toma.setCtmdultcit(antecedentes.getHagdfuc());
                    mostrarResultado = true;
                }

                if (antecedentes.getHagdfur() != null) {
                    toma.setCtmdultmen(antecedentes.getHagdfur());
                }

                if (antecedentes.getHagdfup() != null) {
                    toma.setCtmdultpar(antecedentes.getHagdfup());

                }


                if (antecedentes.getHagnnumgesta() != null) {
                    toma.setCtmngestac(antecedentes.getHagnnumgesta());


                }
                if (antecedentes.getHagnnumparto() != null) {
                    toma.setCtmnpartos(antecedentes.getHagnnumparto());
                    if (antecedentes.getHagnnumparto().equals(0)) {
                        esCeroPartos = true;
                    } else {
                        esCeroPartos = false;
                    }
                }

                if (antecedentes.getHagnnumaborto() != null) {
                    toma.setCtmnaborto(antecedentes.getHagnnumaborto());
                }

                if (antecedentes.getHagnedadrelac() != null) {
                    toma.setCtmnedarel(antecedentes.getHagnedadrelac());
                }
            } else {
                FacesUtils.addErrorMessage(MSG_NO_DATOS_CITOLOGIA);
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

    public void changeProcedimiento() {
        if (toma != null && toma.getCtmcpningu().equals("N")) {
            mostrarProcedimiento = true;

            mnuCauterizacion.setValue("N");
            mnuHistectomia.setValue("N");
            mnuConizacion.setValue("N");
            mnuRadioterapia.setValue("N");
            mnuBiopsia.setValue("N");
            mnuCrioterapia.setValue("N");
            mnuATA.setValue("N");
            mnuOtro.setValue("N");
            mnuVaporizacion.setValue("N");
            mnuHormonal.setValue("N");
            mnuColpos.setValue("N");

            toma.setCtmcpcaute("N");
            toma.setCtmcphiste("N");
            toma.setCtmcpconiz("N");
            toma.setCtmcpradio("N");
            toma.setCtmcpbiops("N");
            toma.setCtmcpcriot("N");
            toma.setCtmcpvapor("N");
            toma.setCtmcphormo("N");
            toma.setCtmcpcolpo("N");


        } else {
            toma.setCtmcpcaute(null);
            toma.setCtmdpcaute(null);
            toma.setCtmcphiste(null);
            toma.setCtmdphiste(null);
            toma.setCtmcpconiz(null);
            toma.setCtmdpconiz(null);
            toma.setCtmcpradio(null);
            toma.setCtmdpradio(null);
            toma.setCtmcpbiops(null);
            toma.setCtmdpbiops(null);
            toma.setCtmcpcriot(null);
            toma.setCtmdpcriot(null);
            toma.setCtmcpata(null);
            toma.setCtmdpata(null);
            toma.setCtmcpotro(null);
            toma.setCtmdpotro(null);
            toma.setCtmcpdotro(null);
            toma.setCtmcpvapor(null);
            toma.setCtmdpvapor(null);
            toma.setCtmcphormo(null);
            toma.setCtmdphormo(null);
            toma.setCtmcpcolpo(null);
            toma.setCtmdpcolpo(null);

            mnuCauterizacion.setValue(null);
            mnuHistectomia.setValue(null);
            mnuConizacion.setValue(null);
            mnuRadioterapia.setValue(null);
            mnuBiopsia.setValue(null);
            mnuCrioterapia.setValue(null);
            mnuATA.setValue(null);
            mnuOtro.setValue(null);
            mnuColpos.setValue(null);
            mostrarFechaATA = false;
            mostrarFechaBiopsia = false;
            mostrarFechaCauterizacion = false;
            mostrarFechaConizacion = false;
            mostrarFechaCrioterapia = false;
            mostrarFechaHisterectomia = false;
            mostrarFechaOtro = false;
            mostrarFechaRadioterapia = false;
            mostrarProcedimiento = false;
            mostrarFechaVaporizacion = false;
            mostrarFechaHormonal = false;
            mostrarFechaColpos = false;
        }
    }

    public void changeCauterizacion() {
        if (toma != null && toma.getCtmcpcaute() != null && 
            toma.getCtmcpcaute().equals("S")) {
            mostrarFechaCauterizacion = true;
        } else {
            mostrarFechaCauterizacion = false;
            toma.setCtmdpcaute(null);

        }
    }

    public void changeHisterectomia() {
        if (toma != null && toma.getCtmcphiste() != null && 
            toma.getCtmcphiste().equals("S")) {
            mostrarFechaHisterectomia = true;
        } else {
            toma.setCtmdphiste(null);
            mostrarFechaHisterectomia = false;
        }
    }

    public void changeConizacion() {
        if (toma != null && toma.getCtmcpconiz() != null && 
            toma.getCtmcpconiz().equals("S")) {
            mostrarFechaConizacion = true;
        } else {
            toma.setCtmdpconiz(null);
            mostrarFechaConizacion = false;
        }
    }

    public void changeBiopsia() {
        if (toma != null && toma.getCtmcpbiops() != null && 
            toma.getCtmcpbiops().equals("S")) {
            mostrarFechaBiopsia = true;
        } else {
            toma.setCtmdpbiops(null);
            mostrarFechaBiopsia = false;
        }
    }

    public void changeCrioterapia() {
        if (toma != null && toma.getCtmcpcriot() != null && 
            toma.getCtmcpcriot().equals("S")) {
            mostrarFechaCrioterapia = true;
        } else {
            toma.setCtmdpcriot(null);
            mostrarFechaCrioterapia = false;
        }
    }


    public void changeATA() {
        if (toma != null && toma.getCtmcpata() != null && 
            toma.getCtmcpata().equals("S")) {
            mostrarFechaATA = true;
        } else {
            toma.setCtmdpata(null);
            mostrarFechaATA = false;
        }
    }


    public void changeVaporizacion() {
        if (toma != null && toma.getCtmcpvapor() != null && 
            toma.getCtmcpvapor().equals("S")) {
            mostrarFechaVaporizacion = true;
        } else {
            toma.setCtmdpvapor(null);
            mostrarFechaVaporizacion = false;
        }
    }


    public void changeHormonal() {
        if (toma != null && toma.getCtmcphormo() != null && 
            toma.getCtmcphormo().equals("S")) {
            mostrarFechaHormonal = true;
        } else {
            toma.setCtmdphormo(null);
            mostrarFechaHormonal = false;
        }
    }


    public void changeOtroProcedimiento() {
        if (toma != null && toma.getCtmcpotro() != null && 
            toma.getCtmcpotro().equals("S")) {
            mostrarFechaOtro = true;
        } else {
            toma.setCtmdpotro(null);
            toma.setCtmcpdotro(null);
            mostrarFechaOtro = false;
        }
    }


    public void changeRadioterapia() {
        if (toma != null && toma.getCtmcpradio() != null && 
            toma.getCtmcpradio().equals("S")) {
            mostrarFechaRadioterapia = true;
        } else {
            toma.setCtmdpradio(null);
            mostrarFechaRadioterapia = false;
        }
    }

    public void ChangeFechaCitologia() {
        if (toma.getCtmdultcit() != null) {
            mostrarResultado = true;
        } else {
            toma.setCtmcultres(null);
            mostrarResultado = false;
            mostrarhallazgos = false;
            mnuResultado.setValue(null);
            toma.setCtmcotrhal(null);
        }
    }

    public void changeResultado() {
        if (toma.getCtmcultres() != null && 
            toma.getCtmcultres().equals("2.2")) {
            mostrarhallazgos = true;
        } else {
            mostrarhallazgos = false;
            toma.setCtmcotrhal(null);
        }
    }


    public void changeMetodo() {
        if (toma.getCtmcmetpla() != null && 
            toma.getCtmcmetpla().equals("1.7")) {
            mostrarotrometodo = true;
        } else {
            mostrarotrometodo = false;
        }

        if (toma.getCtmcmetpla() != null && 
            toma.getCtmcmetpla().equals("1.1")) {
            renderTiempoUso = false;
            toma.setCtmntiemet(null);
        } else {
            renderTiempoUso = true;
        }
    }
    
    public void changeEsquema() {
        if (toma.getCtmcesquem() != null && toma.getCtmcesquem().equals("8")) {
            mostrarOtroEsquema = true;
        } else {
            mostrarOtroEsquema = false;
        }
    }
    
    public void changeEsquemaVph() {
        if (toma.getCtmcesqvph() != null && toma.getCtmcesqvph().equals("3")) {
            mostrarOtroEsquemaVph = true;
        } else {
            mostrarOtroEsquemaVph = false;
        }
    }
    
    public void changeVacVph() {
        if (toma.getCtmccomvph() != null && 
            (toma.getCtmccomvph().equals("S")||toma.getCtmccomvph().equals("N"))) {
            mostrarNumDosisAdmini = true;
        } else {
            mostrarNumDosisAdmini = false;
        }
    }
    
    public void changeFechaTipifiacion() {
        if (toma.getCtmdtipifi()!= null) {
            mostrarResultTipificacion = true;
        } else {
            mostrarResultTipificacion = false;
        }
    }

    public void changeFechaColposcopia() {
            if (toma != null && toma.getCtmcpcolpo() != null && 
                toma.getCtmcpcolpo().equals("S")) {
                mostrarFechaColpos = true;
            } else {
                toma.setCtmdpcolpo(null);
                mostrarFechaColpos = false;
            }
    }


    /**
     * @return
     */
    public String volverConsulta() {
        generoCitologia = false;
        FacesUtils.resetManagedBean("listaCitologiasBean");
        FacesUtils.resetManagedBean("datosUsuarioCitologiaBean");
        FacesUtils.resetManagedBean("tomaCitologiaBean");
        return BeanNavegacion.RUTA_LISTA_CITOLOGIAS_PROGRAMADAS;
    }

    public void changeVph() {
        if (toma != null && toma.getCtmcvph() != null && 
            toma.getCtmcvph().equals("S")) {
            mostrarvph = true;
        } else {
            mostrarvph = false;
        }
    }


    public void setCtmcvph(ValueChangeEvent valueChangeEvent) {
        toma.setCtmcvph((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    //------------------------------------------------------------------------------------------------------------------
    //  Reporte
    //------------------------------------------------------------------------------------------------------------------

    /**
     * @return
     */
    public boolean next() {
        index++;
        return (index < NUMERO_COPIAS);
    }

    /**
     * @param jrField
     * @return
     */
    public Object getFieldValue(JRField jrField) {
        Object value = null;
        String fieldName = jrField.getName();

            if (fieldName.equals("APELLIDOS")) {
                value = APELLIDOS;
            } else if (fieldName.equals("NOMBRES")) {
                value = NOMBRES;
            } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
                value = NUMERO_DOCUMENTO;
            } else if (fieldName.equals("DIRECCION")) {
                value = DIRECCION;
            } else if (fieldName.equals("TELEFONO")) {
                value = TELEFONO;
            } else if (fieldName.equals("CIUDAD")) {
                value = CIUDAD;
            } else if (fieldName.equals("DEPARTAMENTO")) {
                value = DEPARTAMENTO;
            } else if (fieldName.equals("OTRA_DIRECCION")) {
                value = OTRA_DIRECCION;
            } else if (fieldName.equals("OTRO_TELEFONO")) {
                value = OTRO_TELEFONO;
            } else if (fieldName.equals("OTRA_CIUDAD")) {
                value = OTRA_CIUDAD;
            } else if (fieldName.equals("OTRO_DEPARTAMENTO")) {
                value = OTRO_DEPARTAMENTO;
            } else if (fieldName.equals("EDAD")) {
                value = EDAD;
            } else if (fieldName.equals("DIA_REGLA")) {
                value = DIA_REGLA;
            } else if (fieldName.equals("MES_REGLA")) {
                value = MES_REGLA;
            } else if (fieldName.equals("ANNO_REGLA")) {
                value = ANNO_REGLA;
            } else if (fieldName.equals("GESTACIONES")) {
                value = GESTACIONES;
            } else if (fieldName.equals("PARTOS")) {
                value = PARTOS;
            } else if (fieldName.equals("ABORTOS")) {
                value = ABORTOS;
            } else if (fieldName.equals("TIPO_AFILIACION")) {
                value = TIPO_AFILIACION;
            } else if (fieldName.equals("ASEGURADORA")) {
                value = ASEGURADORA;
            } else if (fieldName.equals("ESQUEMA_CITOLOGIA")) {
                value = ESQUEMA_CITOLOGIA;
            } else if (fieldName.equals("DIA_PARTO")) {
                value = DIA_PARTO;
            } else if (fieldName.equals("MES_PARTO")) {
                value = MES_PARTO;
            } else if (fieldName.equals("ANNO_PARTO")) {
                value = ANNO_PARTO;
            } else if (fieldName.equals("EDAD_RELACIONES")) {
                value = EDAD_RELACIONES;
            } else if (fieldName.equals("METODO_PLANIFICACION")) {
                value = METODO_PLANIFICACION;
            } else if (fieldName.equals("DIA_CITOLOGIA")) {
                value = DIA_CITOLOGIA;
            } else if (fieldName.equals("MES_CITOLOGIA")) {
                value = MES_CITOLOGIA;
            } else if (fieldName.equals("ANNO_CITOLOGIA")) {
                value = ANNO_CITOLOGIA;
            } else if (fieldName.equals("RESULTADO_CITOLOGIA")) {
                value = RESULTADO_CITOLOGIA;
            } else if (fieldName.equals("ESTA_EMBARAZADA")) {
                value = ESTA_EMBARAZADA;
            } else if (fieldName.equals("APECTO_CUELLO")) {
                value = APECTO_CUELLO;
            } else if (fieldName.equals("FECHA_CAUTERIZACION")) {
                value = FECHA_CAUTERIZACION;
            } else if (fieldName.equals("FECHA_HISTERECTOMIA")) {
                value = FECHA_HISTERECTOMIA;
            } else if (fieldName.equals("FECHA_CONIZACION")) {
                value = FECHA_CONIZACION;
            } else if (fieldName.equals("FECHA_RADIOTERAPIA")) {
                value = FECHA_RADIOTERAPIA;
            } else if (fieldName.equals("FECHA_BIOPSA")) {
                value = FECHA_BIOPSA;
            } else if (fieldName.equals("FECHA_CRIOTERAPIA")) {
                value = FECHA_CRIOTERAPIA;
            } else if (fieldName.equals("FECHA_ATA")) {
                value = FECHA_ATA;
            } else if (fieldName.equals("FECHA_OTRO")) {
                value = FECHA_OTRO;
            }else if (fieldName.equals("FECHA_COLPOSCOPIA")) {
                value = FECHA_COLPOSCOPIA;
            } else if (fieldName.equals("OTRO_CUAL")) {
                value = OTRO_CUAL;
            } else if (fieldName.equals("NINGUNO")) {
                value = NINGUNO;
            } else if (fieldName.equals("CAUTERIZACION")) {
                value = CAUTERIZACION;
            } else if (fieldName.equals("HISTERECTOMIA")) {
                value = HISTERECTOMIA;
            } else if (fieldName.equals("CONIZACION")) {
                value = CONIZACION;
            } else if (fieldName.equals("RADIOTERAPIA")) {
                value = RADIOTERAPIA;
            } else if (fieldName.equals("BIOPSIA")) {
                value = BIOPSIA;
            } else if (fieldName.equals("CRIOTERAPIA")) {
                value = CRIOTERAPIA;
            } else if (fieldName.equals("ATA")) {
                value = ATA;
            } else if (fieldName.equals("OTRO")) {
                value = OTRO;
            }else if (fieldName.equals("COLPOSCOPIA")) {
                value = COLPOSCOPIA;
            } else if (fieldName.equals("TOMADA")) {
                value = TOMADA;
            } else if (fieldName.equals("FECHA_TOMADA")) {
                value = FECHA_TOMADA;
            } else if (fieldName.equals("NOMBRE_TOMADA")) {
                value = NOMBRE_TOMADA;
            } else if (fieldName.equals("NUMERO_CITOLOGIA")) {
                value = NUMERO_CITOLOGIA;
            } else if (fieldName.equals("FECHA_VPH")) {
                value = FECHA_VPH;
            } else if (fieldName.equals("DOSIS_VPH")) {
                value = DOSIS_VPH;
            } else if (fieldName.equals("VPH")) {
                value = VPH;
            } else if (fieldName.equals("OBSERVACIONES_TOMA")) {
                value = OBSERVACIONES_TOMA;
            } else if (fieldName.equals("OTROS_HALLAZGOS")) {
                value = OTROS_HALLAZGOS;
            } else if (fieldName.equals("OTRO_METODO")) {
                value = OTRO_METODO;
            }

            else if (fieldName.equals("ES_SANO")) {
                value = ES_SANO;
            } else if (fieldName.equals("ES_AUSENTE")) {
                value = ES_AUSENTE;
            } else if (fieldName.equals("ES_EROSIONADO")) {
                value = ES_EROSIONADO;
            } else if (fieldName.equals("ES_CONGESTIVO")) {
                value = ES_CONGESTIVO;
            } else if (fieldName.equals("ES_ATROFICO")) {
                value = ES_ATROFICO;
            } else if (fieldName.equals("ES_ULCERADO")) {
                value = ES_ULCERADO;
            } else if (fieldName.equals("ES_SANGRANTE")) {
                value = ES_SANGRANTE;
            }

            else if (fieldName.equals("ES_LESION_VISIBLE")) {
                value = ES_LESION_VISIBLE;
            } else if (fieldName.equals("ES_POLIPO")) {
                value = ES_POLIPO;
            } else if (fieldName.equals("CENTRO")) {
                value = CENTRO;
            } else if (fieldName.equals("NUMERO_FAC")) {
                value = NUMERO_FAC;
            } else if (fieldName.equals("VAPORIZACION")) {
                value = VAPORIZACION;
            } else if (fieldName.equals("FECHA_VAPORIZACION")) {
                value = FECHA_VAPORIZACION;
            } else if (fieldName.equals("HORMONAL")) {
                value = HORMONAL;
            } else if (fieldName.equals("FECHA_HORMONAL")) {
                value = FECHA_HORMONAL;
            } else if (fieldName.equals("TIEMPO_METODO")) {
                value = TIEMPO_METODO;
            } else if (fieldName.equals("COMPLETO_VPH")) {
                value = COMPLETO_VPH;
            } else if (fieldName.equals("LACTANCIA_ACTUAL")) {
                value = LACTANCIA_ACTUAL;
            } else if (fieldName.equals("OTROS_HALLAZGOS_TOMA")) {
                value = OTROS_HALLAZGOS_TOMA;
            }
            
            if (fieldName.equals("numeroTipificacion")) {
                value = numeroTipificacion;
            } else if (fieldName.equals("centro")) {
                value = centro;
            } else if (fieldName.equals("apellidos")) {
                value = apellidos;
            } else if (fieldName.equals("nombres")) {
                value = nombres;
            } else if (fieldName.equals("tipoDocumento")) {
                value = tipoDocumento;
            } else if (fieldName.equals("numeroDocumento")) {
                value = numeroDocumento;
            } else if (fieldName.equals("edad")) {
                value = edad;
            } else if (fieldName.equals("aseguradora")) {
                value = aseguradora;
            } else if (fieldName.equals("direccion")) {
                value = direccion;
            } else if (fieldName.equals("telefono")) {
                value = telefono;
            } else if (fieldName.equals("ciudad")) {
                value = ciudad;
            } else if (fieldName.equals("departamento")) {
                value = departamento;
            } else if (fieldName.equals("otraDireccion")) {
                value = otraDireccion;
            } else if (fieldName.equals("otroTelefono")) {
                value = otroTelefono;
            } else if (fieldName.equals("otraCiudad")) {
                value = otraCiudad;
            } else if (fieldName.equals("otroDepartamento")) {
                value = otroDepartamento;
            } else if (fieldName.equals("identidadGenero")) {
                value = identidadGenero;
            } else if (fieldName.equals("vulnerabilidad")) {
                value = vulnerabilidad;
            } else if (fieldName.equals("esquemaVph")) {
                value = esquemaVph;
            } else if (fieldName.equals("esquemaVphCualOtro")) {
                value = esquemaVphCualOtro;
            } else if (fieldName.equals("gestaciones")) {
                value = gestaciones;
            } else if (fieldName.equals("partos")) {
                value = partos;
            } else if (fieldName.equals("abortos")) {
                value = abortos;
            } else if (fieldName.equals("estaEmbarazada")) {
                value = estaEmbarazada;
            } else if (fieldName.equals("planeaEmbarazoAntesAnho")) {
                value = planeaEmbarazoAntesAnho;
            } else if (fieldName.equals("edadRelaciones")) {
                value = edadRelaciones;
            } else if (fieldName.equals("metodoPlanificacion")) {
                value = metodoPlanificacion;
            } else if (fieldName.equals("otroMetodoPlanificacion")) {
                value = otroMetodoPlanificacion;
            } else if (fieldName.equals("resultadoCitologia")) {
                value = resultadoCitologia;
            } else if (fieldName.equals("otroResultadoCitologia")) {
                value = otroResultadoCitologia;
            } else if (fieldName.equals("completoVph")) {
                value = completoVph;
            } else if (fieldName.equals("lactanciaActual")) {
                value = lactanciaActual;
            } else if (fieldName.equals("cauterizacion")) {
                value = cauterizacion;
            } else if (fieldName.equals("histerectomia")) {
                value = histerectomia;
            } else if (fieldName.equals("conizacion")) {
                value = conizacion;
            } else if (fieldName.equals("radioterapia")) {
                value = radioterapia;
            } else if (fieldName.equals("biopsia")) {
                value = biopsia;
            } else if (fieldName.equals("crioterapia")) {
                value = crioterapia;
            } else if (fieldName.equals("ata")) {
                value = ata;
            } else if (fieldName.equals("colposcopia")) {
                value = colposcopia;
            } else if (fieldName.equals("vaporizacion")) {
                value = vaporizacion;
            } else if (fieldName.equals("tratamientoHormonal")) {
                value = tratamientoHormonal;
            } else if (fieldName.equals("otroProcedimiento")) {
                value = otroProcedimiento;
            } else if (fieldName.equals("cualOtroProcedimiento")) {
                value = cualOtroProcedimiento;
            } else if (fieldName.equals("ningunProcedimiento")) {
                value = ningunProcedimiento;
            } else if (fieldName.equals("cuelloSano")) {
                value = cuelloSano;
            } else if (fieldName.equals("cuelloAusente")) {
                value = cuelloAusente;
            } else if (fieldName.equals("cuelloErosionado")) {
                value = cuelloErosionado;
            } else if (fieldName.equals("cuelloCongestivo")) {
                value = cuelloCongestivo;
            } else if (fieldName.equals("cuelloAtrofico")) {
                value = cuelloAtrofico;
            } else if (fieldName.equals("cuelloUlcerado")) {
                value = cuelloUlcerado;
            } else if (fieldName.equals("cuelloSangrante")) {
                value = cuelloSangrante;
            } else if (fieldName.equals("cuelloLesionVisible")) {
                value = cuelloLesionVisible;
            } else if (fieldName.equals("cuelloPolipo")) {
                value = cuelloPolipo;
            } else if (fieldName.equals("tomaObservaciones")) {
                value = tomaObservaciones;
            } else if (fieldName.equals("tomaTipoProfesional")) {
                value = tomaTipoProfesional;
            } else if (fieldName.equals("tomaNombreProfesional")) {
                value = tomaNombreProfesional;
            } else if (fieldName.equals("tomaTarjetaProfesional")) {
                value = tomaTarjetaProfesional;
            } else if (fieldName.equals("lecturaTipoProfesional")) {
                value = lecturaTipoProfesional;
            } else if (fieldName.equals("lecturaNombreProfesional")) {
                value = lecturaNombreProfesional;
            } else if (fieldName.equals("lecturaTarjetaProfesional")) {
                value = lecturaTarjetaProfesional;
            } else if (fieldName.equals("conducta")) {
                value = conducta;
            } else if (fieldName.equals("dosisVph")) {
                value = dosisVph;
            } else if (fieldName.equals("diaRegla")) {
                value = diaRegla;
            } else if (fieldName.equals("mesRegla")) {
                value = mesRegla;
            } else if (fieldName.equals("anoRegla")) {
                value = anoRegla;
            } else if (fieldName.equals("diaVph")) {
                value = diaVph;
            } else if (fieldName.equals("mesVph")) {
                value = mesVph;
            } else if (fieldName.equals("anoVph")) {
                value = anoVph;
            } else if (fieldName.equals("diaParto")) {
                value = diaParto;
            } else if (fieldName.equals("mesParto")) {
                value = mesParto;
            } else if (fieldName.equals("anoParto")) {
                value = anoParto;
            } else if (fieldName.equals("diaCitologia")) {
                value = diaCitologia;
            } else if (fieldName.equals("mesCitologia")) {
                value = mesCitologia;
            } else if (fieldName.equals("anoCitologia")) {
                value = anoCitologia;
            } else if (fieldName.equals("diaCauterizacion")) {
                value = diaCauterizacion;
            } else if (fieldName.equals("mesCauterizacion")) {
                value = mesCauterizacion;
            } else if (fieldName.equals("anoCauterizacion")) {
                value = anoCauterizacion;
            } else if (fieldName.equals("diaHisterectomia")) {
                value = diaHisterectomia;
            } else if (fieldName.equals("mesHisterectomia")) {
                value = mesHisterectomia;
            } else if (fieldName.equals("anoHisterectomia")) {
                value = anoHisterectomia;
            } else if (fieldName.equals("diaConizacion")) {
                value = diaConizacion;
            } else if (fieldName.equals("mesConizacion")) {
                value = mesConizacion;
            } else if (fieldName.equals("anoConizacion")) {
                value = anoConizacion;
            } else if (fieldName.equals("diaRadioterapia")) {
                value = diaRadioterapia;
            } else if (fieldName.equals("mesRadioterapia")) {
                value = mesRadioterapia;
            } else if (fieldName.equals("anoRadioterapia")) {
                value = anoRadioterapia;
            } else if (fieldName.equals("diaBiopsia")) {
                value = diaBiopsia;
            } else if (fieldName.equals("mesBiopsia")) {
                value = mesBiopsia;
            } else if (fieldName.equals("anoBiopsia")) {
                value = anoBiopsia;
            } else if (fieldName.equals("diaCrioterapia")) {
                value = diaCrioterapia;
            } else if (fieldName.equals("mesCrioterapia")) {
                value = mesCrioterapia;
            } else if (fieldName.equals("anoCrioterapia")) {
                value = anoCrioterapia;
            } else if (fieldName.equals("diaAta")) {
                value = diaAta;
            } else if (fieldName.equals("mesAta")) {
                value = mesAta;
            } else if (fieldName.equals("anoAta")) {
                value = anoAta;
            } else if (fieldName.equals("diaOtro")) {
                value = diaOtro;
            } else if (fieldName.equals("mesOtro")) {
                value = mesOtro;
            } else if (fieldName.equals("anoOtro")) {
                value = anoOtro;
            } else if (fieldName.equals("diaTomada")) {
                value = diaTomada;
            } else if (fieldName.equals("mesTomada")) {
                value = mesTomada;
            } else if (fieldName.equals("anoTomada")) {
                value = anoTomada;
            }else if (fieldName.equals("diaColpo")) {
                value = diaColpo;
            } else if (fieldName.equals("mesColpo")) {
                value = mesColpo;
            } else if (fieldName.equals("anoColpo")) {
                value = anoColpo;
            } else if (fieldName.equals("diaVaporizacion")) {
                value = diaVaporizacion;
            } else if (fieldName.equals("mesVaporizacion")) {
                value = mesVaporizacion;
            } else if (fieldName.equals("anoVaporizacion")) {
                value = anoVaporizacion;
            }else if (fieldName.equals("diaTratamientoHormonal")) {
                value = diaTratamientoHormonal;
            } else if (fieldName.equals("mesTratamientoHormonal")) {
                value = mesTratamientoHormonal;
            } else if (fieldName.equals("anoTratamientoHormonal;")) {
                value = anoTratamientoHormonal;            
            } else if (fieldName.equals("habitanteCalle")) {
                value = habitanteCalle;
            } else if (fieldName.equals("desmovilizado")) {
                value = desmovilizado;
            } else if (fieldName.equals("poblacionInfantilCargoICBF")) {
                value = poblacionInfantilCargoICBF;
            } else if (fieldName.equals("poblacionAfectadasConflictoArmado")) {
                value = poblacionAfectadasConflictoArmado;
            } else if (fieldName.equals("madreComunitaria")) {
                value = madreComunitaria;
            } else if (fieldName.equals("trabajadoresSexuales")) {
                value = trabajadoresSexuales;
            } else if (fieldName.equals("personadiscapacidad")) {
                value = personadiscapacidad;
            } else if (fieldName.equals("personaPrivadaLibertad")) {
                value = personaPrivadaLibertad;
            } else if (fieldName.equals("inmigrante")) {
                value = inmigrante;
            } else if (fieldName.equals("ninguna")) {
                value = ninguna;
            } else if (fieldName.equals("tipificacion")) {
                value = tipificacion;
            } else if (fieldName.equals("baseLiquida")) {
                value = baseLiquida;
            } else if (fieldName.equals("convencional")) {
                value = convencional;
            } else if (fieldName.equals("numeroBaseLiquida")) {
                value = numeroBaseLiquida;
            } else if (fieldName.equals("numeroConvencional")) {
                value = numeroConvencional;
            } else if (fieldName.equals("esquemaCitologia")) {
                value = esquemaCitologia;
            } else if (fieldName.equals("otroEsquemaCitologia")) {
                value = otroEsquemaCitologia;
            } else if (fieldName.equals("resultadoTipificacion")) {
                value = resultadoTipificacion;
            }
            if (fieldName.equals("NOMBRE")) {
               value = NOMBRE;
            }else if (fieldName.equals("TIPO_IDENTIFICACION")) {
               value = TIPO_IDENTIFICACION;
            }else if (fieldName.equals("NUMERO_IDENTIFICACION")) {
               value = NUMERO_IDENTIFICACION;
            }else if (fieldName.equals("FECHA_TOMA")) {
               value = FECHA_TOMA;
            }else if (fieldName.equals("NUMERO_CITOLOGIA_VPH")) {
               value = NUMERO_CITOLOGIA_VPH;
            }else if (fieldName.equals("CLINICA")) {
               value = CLINICA;
            }
        

        return value;
    }


    public void obtenerDatosReporte() {

        if (citologia != null) {

            if (citologia.getCcinnumdoc() != null) {
                NUMERO_FAC = citologia.getCcinnumdoc().toString();

                if (NUMERO_FAC != null && NUMERO_FAC.length() > 6) {
                    NUMERO_FAC = 
                            NUMERO_FAC.substring(NUMERO_FAC.length() - 6, NUMERO_FAC.length());
                }

            }

            if (citologia.getCcinconsec() != null) {
                NUMERO_CITOLOGIA = citologia.getCcinconsec();
            }
            if (citologia.getCcicprinom() != null) {
                NOMBRES = citologia.getCcicprinom() + " ";
            }
            if (citologia.getCcicsegnom() != null && 
                !citologia.getCcicsegnom().equals("_")) {
                NOMBRES = NOMBRES + citologia.getCcicsegnom();
            }
            if (citologia.getCcicpriape() != null) {
                APELLIDOS = citologia.getCcicpriape() + " ";
            }
            if (citologia.getCcicsegape() != null && 
                !citologia.getCcicsegape().equals("_")) {
                APELLIDOS = APELLIDOS + citologia.getCcicsegape();
            }
            if (citologia.getCcictipide() != null) {
                TIPO_DOCUMENTO = citologia.getCcictipide();
            }
            if (citologia.getCcianumide() != 0) {
                NUMERO_DOCUMENTO = citologia.getCcianumide();
            }
            if (citologia.getCcicdirecc() != null) {
                DIRECCION = citologia.getCcicdirecc();
            }
            if (citologia.getCcictelefo() != null) {
                TELEFONO = citologia.getCcictelefo();
            }
            Integer idCiudad = null;
            Integer idDepartamento = null;
            Cpmunidane ciudadObject = null;
            if (citologia.getCcinmunici() != null && 
                citologia.getCcindepart() != null) {
                idCiudad = citologia.getCcinmunici();
                idDepartamento = citologia.getCcindepart();
            }


            try {
                ciudadObject = 
                        this.serviceLocator.getClinicoService().getMunicipio(idCiudad, 
                                                                             idDepartamento);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (ciudadObject != null) {
                CIUDAD = ciudadObject.getCmdcnommun();
                DEPARTAMENTO = ciudadObject.getCmdcnomdpt();
            }

            if (citologia.getCcicotrdir() != null) {
                OTRA_DIRECCION = citologia.getCcicotrdir();
            }
            if (citologia.getCcicotrtel() != null) {
                OTRO_TELEFONO = citologia.getCcicotrtel();
            }


            Integer idOtraCiudad = null;
            Integer idOtroDepartamento = null;
            Cpmunidane ciudadOtraObject = null;
            if (citologia.getCcinotrmun() != null && 
                citologia.getCcinotrdep() != null) {
                idOtraCiudad = citologia.getCcinotrmun();
                idOtroDepartamento = citologia.getCcinotrdep();
            }
            if (citologia.getCcinedad() != null) {
                EDAD = citologia.getCcinedad();
            }


            try {
                ciudadOtraObject = 
                        this.serviceLocator.getClinicoService().getMunicipio(idOtraCiudad, 
                                                                             idOtroDepartamento);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (ciudadOtraObject != null) {
                OTRA_CIUDAD = ciudadOtraObject.getCmdcnommun();
                OTRO_DEPARTAMENTO = ciudadOtraObject.getCmdcnomdpt();
            }


            if (citologia.getCcictipafi() != null) {
                if (citologia.getCcictipafi().equals("C")) {
                    TIPO_AFILIACION = "CONTRIBUTIVO";
                }
                if (citologia.getCcictipafi().equals("E")) {
                    TIPO_AFILIACION = "ESPECIAL";
                }
                if (citologia.getCcictipafi().equals("R")) {
                    TIPO_AFILIACION = "SUBSIDIO PARCIAL";
                }
                if (citologia.getCcictipafi().equals("S")) {
                    TIPO_AFILIACION = "SUBSIDIADO";
                }
                if (citologia.getCcictipafi().equals("V")) {
                    TIPO_AFILIACION = "VINCULADO";
                }
                if (citologia.getCcictipafi().equals("X")) {
                    TIPO_AFILIACION = "NINGUNO";
                }


            }

            if (citologia.getCcicasegur() != null) {
                Cpentidadadm aseguradora;
                aseguradora = null;

                try {
                    aseguradora = 
                            serviceLocator.getClinicoService().getAseguradoraPorCodigo(citologia.getCcicasegur());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (aseguradora != null) {
                    ASEGURADORA = aseguradora.getCeacnombre();
                }

            }


        }


        if (toma != null) {

            if (toma.getCtmcotrhal() != null) {
                OTROS_HALLAZGOS = toma.getCtmcotrhal();
                OTROS_HALLAZGOS_TOMA = toma.getCtmcotrhal();
            }

            if (toma.getCtmcotrmet() != null) {
                OTRO_METODO = toma.getCtmcotrmet();
            }


            if (toma.getCtmcobstom() != null) {
                OBSERVACIONES_TOMA = toma.getCtmcobstom();
                
            }
            if (toma.getCtmdultmen() != null) {
            
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(toma.getCtmdultmen());
                Integer diapar = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mespar = calendar.get(Calendar.MONTH) + 1;
                Integer anopar = calendar.get(calendar.YEAR);

                if (diapar.compareTo(10) < 0) {
                    DIA_REGLA = "0" + diapar.toString();
                } else {
                    DIA_REGLA = diapar.toString();
                }

                if (mespar.compareTo(10) < 0) {
                    MES_REGLA = "0" + mespar.toString();
                } else {
                    MES_REGLA = mespar.toString();
                }

                ANNO_REGLA = anopar.toString();

            }

            if (toma.getCtmcvph() != null) {
                if (toma.getCtmcvph().equals("S")) {
                    VPH = "Si";
                }
                if (toma.getCtmcvph().equals("N")) {
                    VPH = "No";
                }

            }


            if (toma.getCtmdvph() != null) {

                FECHA_VPH = toma.getCtmdvph();
            }

            if (toma.getCtmnvph() != null) {
                DOSIS_VPH = toma.getCtmnvph();
            }


            if (toma.getCtmdultpar() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(toma.getCtmdultpar());
                Integer diapar = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mespar = calendar.get(Calendar.MONTH) + 1;
                Integer anopar = calendar.get(calendar.YEAR);

                if (diapar.compareTo(10) < 0) {
                    DIA_PARTO = "0" + diapar.toString();
                } else {
                    DIA_PARTO = diapar.toString();
                }

                if (mespar.compareTo(10) < 0) {
                    MES_PARTO = "0" + mespar.toString();
                } else {
                    MES_PARTO = mespar.toString();
                }

                ANNO_PARTO = anopar.toString();
                
            }

            if (toma.getCtmnedarel() != null) {
                EDAD_RELACIONES = toma.getCtmnedarel();
            }


            if (toma.getCtmcembara() != null) {
                Cndesccito embarazades;
                embarazades = null;
                try {
                    embarazades = 
                            serviceLocator.getClinicoService().getDescripcionesCitologia("cncitotoma", 
                                                                                         "ctmcembara", 
                                                                                         toma.getCtmcembara());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (embarazades != null) {
                    ESTA_EMBARAZADA = embarazades.getCdicdescri();
                }

            }

            if (toma.getCtmngestac() != null) {
                GESTACIONES = toma.getCtmngestac();
            }

            if (toma.getCtmnpartos() != null) {
                PARTOS = toma.getCtmnpartos();
            }
            if (toma.getCtmnaborto() != null) {
                ABORTOS = toma.getCtmnaborto();
            }

            if (toma.getCtmcesquem() != null) {
                Cndesccito esquemades;
                esquemades = null;
                try {
                    esquemades = 
                            serviceLocator.getClinicoService().getDescripcionesCitologia("cncitotoma", 
                                                                                         "ctmcesquem", 
                                                                                         toma.getCtmcesquem());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (esquemades != null) {
                    ESQUEMA_CITOLOGIA = esquemades.getCdicdescri();
                }

            }

            if (toma.getCtmcmetpla() != null) {
                METODO_PLANIFICACION = toma.getCtmcmetpla();

            }


            if (toma.getCtmcultres() != null) {

                RESULTADO_CITOLOGIA = toma.getCtmcultres();

            }


            if (lstAspectoSelect != null && !lstAspectoSelect.isEmpty()) {
                ES_SANO = "";
                ES_AUSENTE = "";
                ES_EROSIONADO = "";
                ES_CONGESTIVO = "";
                ES_ATROFICO = "";
                ES_ULCERADO = "";
                ES_SANGRANTE = "";
                ES_LESION_VISIBLE = "";
                ES_POLIPO = "";
                CENTRO = "";
                Iterator it = lstAspectoSelect.iterator();
                while (it.hasNext()) {
                    String idAspecto;
                    idAspecto = (String)it.next();


                    if (idAspecto.equals("3.1")) {
                        ES_SANO = "S";
                    }
                    if (idAspecto.equals("3.2")) {
                        ES_AUSENTE = "S";
                    }
                    if (idAspecto.equals("3.3")) {
                        ES_EROSIONADO = "S";
                    }
                    if (idAspecto.equals("3.4")) {
                        ES_CONGESTIVO = "S";
                    }
                    if (idAspecto.equals("3.5")) {
                        ES_ATROFICO = "S";
                    }
                    if (idAspecto.equals("3.6")) {
                        ES_ULCERADO = "S";
                    }
                    if (idAspecto.equals("3.7")) {
                        ES_SANGRANTE = "S";
                    }
                    if (idAspecto.equals("3.8")) {
                        ES_LESION_VISIBLE = "S";
                    }
                    if (idAspecto.equals("3.9")) {
                        ES_POLIPO = "S";
                    }

                }


                if (toma.getCtmdultcit() != null) {

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(toma.getCtmdultcit());
                    Integer diacit = calendar.get(Calendar.DAY_OF_MONTH);
                    Integer mescit = calendar.get(Calendar.MONTH) + 1;
                    Integer anocit = calendar.get(calendar.YEAR);

                    if (diacit.compareTo(10) < 0) {
                        DIA_CITOLOGIA = "0" + diacit.toString();
                    } else {
                        DIA_CITOLOGIA = diacit.toString();
                    }

                    if (mescit.compareTo(10) < 0) {
                        MES_CITOLOGIA = "0" + mescit.toString();
                    } else {
                        MES_CITOLOGIA = mescit.toString();
                    }

                    ANNO_CITOLOGIA = anocit.toString();
                }


                if (toma.getCtmdpcaute() != null) {

                    FECHA_CAUTERIZACION = toma.getCtmdpcaute();
                }

                if (toma.getCtmdphiste() != null) {

                    FECHA_HISTERECTOMIA = toma.getCtmdphiste();
                }

                if (toma.getCtmdpconiz() != null) {

                    FECHA_CONIZACION = toma.getCtmdpconiz();
                }


                if (toma.getCtmdpradio() != null) {

                    FECHA_RADIOTERAPIA = toma.getCtmdpradio();
                }

                if (toma.getCtmdpbiops() != null) {

                    FECHA_BIOPSA = toma.getCtmdpbiops();
                }


                if (toma.getCtmdpcriot() != null) {

                    FECHA_CRIOTERAPIA = toma.getCtmdpcriot();
                }

                if (toma.getCtmdpata() != null) {


                    FECHA_ATA = toma.getCtmdpata();
                }


                if (toma.getCtmdpotro() != null) {

                    FECHA_OTRO = toma.getCtmdpotro();
                }
                
                if (toma.getCtmdpcolpo() != null) {

                    FECHA_COLPOSCOPIA = toma.getCtmdpcolpo();
                }

                if (toma.getCtmcpdotro() != null) {
                    OTRO_CUAL = toma.getCtmcpdotro();
                }
                if (toma.getCtmcpningu() != null) {
                    NINGUNO = toma.getCtmcpningu();
                }

                if (toma.getCtmcpcaute() != null) {
                    CAUTERIZACION = toma.getCtmcpcaute();
                }
                if (toma.getCtmcphiste() != null) {
                    HISTERECTOMIA = toma.getCtmcphiste();
                }
                if (toma.getCtmcpconiz() != null) {
                    CONIZACION = toma.getCtmcpconiz();
                }
                if (toma.getCtmcpradio() != null) {
                    RADIOTERAPIA = toma.getCtmcpradio();
                }
                if (toma.getCtmcpbiops() != null) {
                    BIOPSIA = toma.getCtmcpbiops();
                }
                if (toma.getCtmcpcriot() != null) {
                    CRIOTERAPIA = toma.getCtmcpcriot();
                }
                if (toma.getCtmcpata() != null) {
                    ATA = toma.getCtmcpata();
                }
                if (toma.getCtmcpotro() != null) {
                    OTRO = toma.getCtmcpotro();
                }
                if (toma.getCtmcpcolpo() != null) {
                    COLPOSCOPIA = toma.getCtmcpcolpo();
                }

                if (toma.getCtmctomada() != null) {
                    TOMADA = toma.getCtmctomada();
                }

                if (toma.getCtmcpvapor() != null) {
                    VAPORIZACION = toma.getCtmcpvapor();
                }

                if (toma.getCtmdpvapor() != null) {
                    FECHA_VAPORIZACION = toma.getCtmdpvapor();
                }


                if (toma.getCtmcphormo() != null) {
                    HORMONAL = toma.getCtmcphormo();
                }

                if (toma.getCtmdphormo() != null) {
                    FECHA_HORMONAL = toma.getCtmdphormo();
                }

                if (toma.getCtmntiemet() != null) {
                    TIEMPO_METODO = toma.getCtmntiemet();
                }


                if (toma.getCtmccomvph() != null) {
                    COMPLETO_VPH = formatearCampo(toma.getCtmccomvph());
                }

                if (toma.getCtmclactan() != null) {
                    LACTANCIA_ACTUAL = formatearCampo(toma.getCtmclactan());
                }


                if (toma.getCtmdfecreg() != null) {

                    FECHA_TOMADA = toma.getCtmdfecreg();
                }

                if (toma.getCtmcnomtom() != null) {
                    NOMBRE_TOMADA = toma.getCtmcnomtom();
                }

                if (getClinica() != null) {
                    CENTRO = getClinica().getCclcnombre();
                }


            }

        }
    }
    
    public void obtenerDatosReporteVPH() {

        if (citologia != null) {
            if (citologia.getCcinconsec() != null) {
                    if (citologia.getCcintiphis().equals(HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA)) {
                    convencional = "S";
                    numeroTipificacion = citologia.getCcinconsec();
                } else if (citologia.getCcintiphis().equals(HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA_BASELIQUIDA)) {
                    baseLiquida = "S";
                    numeroBaseLiquida = citologia.getCcinconsec();
                } else if (citologia.getCcintiphis().equals(HISTORIA_PROCEDIMIENTO_VPH_TOMA)) {
                    tipificacion = "S";
                    numeroTipificacion = citologia.getCcinconsec();
                    if("100".equals(citologia.getCcintipdoc())){
                    
                    }
                }
            }
            if (citologia.getCcicprinom() != null) {
                nombres = citologia.getCcicprinom() + " ";
            }
            if (citologia.getCcicsegnom() != null && 
                !citologia.getCcicsegnom().equals("_")) {
                nombres = nombres + citologia.getCcicsegnom();
            }
            if (citologia.getCcicpriape() != null) {
                apellidos = citologia.getCcicpriape() + " ";
            }
            if (citologia.getCcicsegape() != null && 
                !citologia.getCcicsegape().equals("_")) {
                apellidos = apellidos + citologia.getCcicsegape();
            }
            if (citologia.getCcictipide() != null) {
                tipoDocumento = citologia.getCcictipide();
            }
            if (citologia.getCcianumide() != 0) {
                numeroDocumento = citologia.getCcianumide();
            }
            if (citologia.getCcicdirecc() != null) {
                direccion = citologia.getCcicdirecc();
            }
            if (citologia.getCcictelefo() != null) {
                telefono = citologia.getCcictelefo();
            }
            Integer idCiudad = null;
            Integer idDepartamento = null;
            Cpmunidane ciudadObject = null;
            if (citologia.getCcinmunici() != null && 
                citologia.getCcindepart() != null) {
                idCiudad = citologia.getCcinmunici();
                idDepartamento = citologia.getCcindepart();
            }


            try {
                ciudadObject = 
                        this.serviceLocator.getClinicoService().getMunicipio(idCiudad, 
                                                                             idDepartamento);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (ciudadObject != null) {
                ciudad = ciudadObject.getCmdcnommun();
                departamento = ciudadObject.getCmdcnomdpt();
            }

            if (citologia.getCcicotrdir() != null) {
                otraDireccion = citologia.getCcicotrdir();
            }
            if (citologia.getCcicotrtel() != null) {
                otroTelefono = citologia.getCcicotrtel();
            }


            Integer idOtraCiudad = null;
            Integer idOtroDepartamento = null;
            Cpmunidane ciudadOtraObject = null;
            if (citologia.getCcinotrmun() != null && 
                citologia.getCcinotrdep() != null) {
                idOtraCiudad = citologia.getCcinotrmun();
                idOtroDepartamento = citologia.getCcinotrdep();
            }
            if (citologia.getCcinedad() != null) {
                edad = citologia.getCcinedad();
            }


            try {
                ciudadOtraObject = 
                        this.serviceLocator.getClinicoService().getMunicipio(idOtraCiudad, 
                                                                             idOtroDepartamento);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (ciudadOtraObject != null) {
                otraCiudad = ciudadOtraObject.getCmdcnommun();
                otroDepartamento = ciudadOtraObject.getCmdcnomdpt();
            }

            if (citologia.getCcicasegur() != null) {
                Cpentidadadm aseguradoraAux;
                aseguradoraAux = null;

                try {
                    aseguradoraAux = 
                            serviceLocator.getClinicoService().getAseguradoraPorCodigo(citologia.getCcicasegur());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (aseguradora != null) {
                    aseguradora = aseguradoraAux.getCeacnombre();
                }

            }

            if (citologia.getCcicidengen() != null) {
                identidadGenero = citologia.getCcicidengen();
            }
            
            if (citologia.getCcicvulnera() != null) {
                    ninguna = "";
                    habitanteCalle = "";
                    desmovilizado = "";
                    inmigrante = "";
                    poblacionInfantilCargoICBF = "";
                    poblacionAfectadasConflictoArmado = "";
                    madreComunitaria = "";
                    trabajadoresSexuales = "";
                    personadiscapacidad = "";
                    personaPrivadaLibertad = "";
                    
                    StringTokenizer st = 
                        new StringTokenizer(citologia.getCcicvulnera(), ",");
                    while (st.hasMoreTokens()) {
                        String idvulnerabilidad = st.nextToken();

                        if (idvulnerabilidad.equals("V.1")) {
                            ninguna = "S";
                        }
                        if (idvulnerabilidad.equals("V.2")) {
                            habitanteCalle = "S";
                        }
                        if (idvulnerabilidad.equals("V.3")) {
                            desmovilizado = "S";
                        }
                        if (idvulnerabilidad.equals("V.4")) {
                            inmigrante = "S";
                        }
                        if (idvulnerabilidad.equals("V.5")) {
                            poblacionInfantilCargoICBF = "S";
                        }
                        if (idvulnerabilidad.equals("V.6")) {
                            poblacionAfectadasConflictoArmado = "S";
                        }
                        if (idvulnerabilidad.equals("V.7")) {
                            madreComunitaria = "S";
                        }
                        if (idvulnerabilidad.equals("V.8")) {
                            trabajadoresSexuales = "S";
                        }
                        if (idvulnerabilidad.equals("V.9")) {
                            personadiscapacidad = "S";
                        }
                        if (idvulnerabilidad.equals("V.10")) {
                            personaPrivadaLibertad = "S";
                        }
                    }
                }   
        }


        if (toma != null) {
        if(toma.getCtmcusureg()!= null){
            try {
                Cpprofesio profesional = this.serviceLocator.getClinicoService().getProfesionalPorUsuario(toma.getCtmcusureg(),toma.getCtmnclinic());
                tomaTarjetaProfesional = profesional.getCpfcregmedic();
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

            if (toma.getCtmcobstom() != null) {
                tomaObservaciones = toma.getCtmcobstom();
            }
            if(toma.getCtmcpdotro()!= null){
                cualOtroProcedimiento = toma.getCtmcpdotro();
            }

            if (toma.getCtmdtipifi() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(toma.getCtmdtipifi());
                Integer diareg = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mesreg = calendar.get(Calendar.MONTH) + 1;
                Integer anoreg = calendar.get(calendar.YEAR);

                if (diareg.compareTo(10) < 0) {
                    diaVph = "0" + diareg.toString();
                } else {
                    diaVph = diareg.toString();
                }

                if (mesreg.compareTo(10) < 0) {
                    mesVph = "0" + mesreg.toString();
                } else {
                    mesVph = mesreg.toString();
                }

                anoVph = anoreg.toString();
            }

            if (toma.getCtmnnudoad() != null) {
                dosisVph = toma.getCtmnnudoad();
            }

            if (toma.getCtmdultmen() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(toma.getCtmdultmen());
                Integer diareg = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mesreg = calendar.get(Calendar.MONTH) + 1;
                Integer anoreg = calendar.get(calendar.YEAR);

                if (diareg.compareTo(10) < 0) {
                    diaRegla = "0" + diareg.toString();
                } else {
                    diaRegla = diareg.toString();
                }

                if (mesreg.compareTo(10) < 0) {
                    mesRegla = "0" + mesreg.toString();
                } else {
                    mesRegla = mesreg.toString();
                }

                anoRegla = anoreg.toString();
            }

            if (toma.getCtmdultpar() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(toma.getCtmdultpar());
                Integer diapar = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mespar = calendar.get(Calendar.MONTH) + 1;
                Integer anopar = calendar.get(calendar.YEAR);

                if (diapar.compareTo(10) < 0) {
                    diaParto = "0" + diapar.toString();
                } else {
                    diaParto = diapar.toString();
                }

                if (mespar.compareTo(10) < 0) {
                    mesParto = "0" + mespar.toString();
                } else {
                    mesParto = mespar.toString();
                }

                anoParto = anopar.toString();
            }

            if (toma.getCtmnedarel() != null) {
                edadRelaciones = toma.getCtmnedarel();
            }


            if (toma.getCtmcembara() != null) {
                Cndesccito embarazades;
                embarazades = null;
                try {
                    embarazades = 
                            serviceLocator.getClinicoService().getDescripcionesCitologia("cncitotoma", 
                                                                                         "ctmcembara", 
                                                                                         toma.getCtmcembara());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (embarazades != null) {
                    estaEmbarazada = embarazades.getCdicdescri();
                }
                planeaEmbarazoAntesAnho="";

            }

            if (toma.getCtmngestac() != null) {
                gestaciones = toma.getCtmngestac();
            }

            if (toma.getCtmnpartos() != null) {
                partos = toma.getCtmnpartos();
            }
            if (toma.getCtmnaborto() != null) {
                abortos = toma.getCtmnaborto();
            }

            if (toma.getCtmcesquem() != null) {
                Cndesccito esquemades;
                esquemades = null;
                try {
                    esquemades = 
                            serviceLocator.getClinicoService().getDescripcionesCitologia("cncitotoma", 
                                                                                         "ctmcesquem", 
                                                                                         toma.getCtmcesquem());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (esquemades != null) {
                    esquemaCitologia = esquemades.getCdicvalor();
                }

            }
            
            if (toma.getCtmcotresq() != null) {
                otroEsquemaCitologia = toma.getCtmcotresq();
            }
            
            if (toma.getCtmcesqvph() != null) {
                Cndesccito esquemadesvph;
                esquemadesvph = null;
                try {
                    esquemadesvph = 
                            serviceLocator.getClinicoService().getDescripcionesCitologia("cncitotoma", 
                                                                                         "ctmcvphesq", 
                                                                                         toma.getCtmcesqvph());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (esquemadesvph != null) {
                    esquemaVph = esquemadesvph.getCdicvalor();
                }

            }
            
            if (toma.getCtmcotresqvph() != null) {
                esquemaVphCualOtro = toma.getCtmcotresqvph();
            }
            


            if (toma.getCtmcmetpla() != null) {
                Cndesccito metoplandes;
                metoplandes = null;
                try {
                    metoplandes = 
                            serviceLocator.getClinicoService().getDescripcionesCitologia("cncitotoma", 
                                                                                         "ctmcmetpla", 
                                                                                         toma.getCtmcmetpla());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (metoplandes != null) {
                    metodoPlanificacion = metoplandes.getCdicvalor();
                }

                if (toma.getCtmcotrmet() != null) {
                    otroMetodoPlanificacion =  toma.getCtmcotrmet();
                }

            }
            
            if (toma.getCtmctipifi() != null) {
                Cndesccito resultTipificacion;
                resultTipificacion = null;
                try {
                    resultTipificacion = 
                            serviceLocator.getClinicoService().getDescripcionesCitologia("cncitotoma", 
                                                                                         "ctmctipifi", 
                                                                                         toma.getCtmctipifi());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (resultTipificacion != null) {
                     resultadoTipificacion = resultTipificacion.getCdicvalor();
                }

            }


            if (toma.getCtmcultres() != null) {
                Cndesccito rescitodes;
                rescitodes = null;
                try {
                    rescitodes = 
                            serviceLocator.getClinicoService().getDescripcionesCitologia("cncitotoma", 
                                                                                         "ctmcultres", 
                                                                                         toma.getCtmcultres());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (rescitodes != null) {
                    resultadoCitologia = rescitodes.getCdicvalor();
                }

                if (toma.getCtmcotrhal() != null) {
                    {
                        otroResultadoCitologia = toma.getCtmcotrhal();
                    }

                }

            }


            if (toma.getCtmcaspcue() != null && 
                !toma.getCtmcaspcue().equals("")) {
                
                cuelloSano = "";
                cuelloAusente = "";
                cuelloErosionado = "";
                cuelloCongestivo = "";
                cuelloAtrofico = "";
                cuelloUlcerado = "";
                cuelloSangrante = "";
                cuelloLesionVisible = "";
                cuelloPolipo = "";
                
                StringTokenizer st = 
                    new StringTokenizer(toma.getCtmcaspcue(), ",");
                while (st.hasMoreTokens()) {
                    String idAspecto = st.nextToken();
                    
                    if (idAspecto.equals("3.1")) {
                        cuelloSano = "S";
                    }
                    if (idAspecto.equals("3.2")) {
                        cuelloAusente = "S";
                    }
                    if (idAspecto.equals("3.3")) {
                        cuelloErosionado = "S";
                    }
                    if (idAspecto.equals("3.4")) {
                        cuelloCongestivo = "S";
                    }
                    if (idAspecto.equals("3.5")) {
                        cuelloAtrofico = "S";
                    }
                    if (idAspecto.equals("3.6")) {
                        cuelloUlcerado = "S";
                    }
                    if (idAspecto.equals("3.7")) {
                        cuelloSangrante = "S";
                    }
                    if (idAspecto.equals("3.8")) {
                        cuelloLesionVisible = "S";
                    }
                    if (idAspecto.equals("3.9")) {
                        cuelloPolipo = "S";
                    }
                }
            }


            if (toma.getCtmdultcit() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(toma.getCtmdultcit());
                Integer diacit = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mescit = calendar.get(Calendar.MONTH) + 1;
                Integer anocit = calendar.get(calendar.YEAR);

                if (diacit.compareTo(10) < 0) {
                    diaCitologia = "0" + diacit.toString();
                } else {
                    diaCitologia = diacit.toString();
                }

                if (mescit.compareTo(10) < 0) {
                    mesCitologia = "0" + mescit.toString();
                } else {
                    mesCitologia = mescit.toString();
                }

                anoCitologia = anocit.toString();
            }


            if (toma.getCtmdpcaute() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(toma.getCtmdpcaute());
                Integer diacau = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mescau = calendar.get(Calendar.MONTH) + 1;
                Integer anocau = calendar.get(calendar.YEAR);

                if (diacau.compareTo(10) < 0) {
                    diaCauterizacion = "0" + diacau.toString();
                } else {
                    diaCauterizacion = diacau.toString();
                }

                if (mescau.compareTo(10) < 0) {
                    mesCauterizacion = "0" + mescau.toString();
                } else {
                    mesCauterizacion = mescau.toString();
                }

                anoCauterizacion = anocau.toString();
            }

            if (toma.getCtmdphiste() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(toma.getCtmdphiste());
                Integer diahiste = calendar.get(Calendar.DAY_OF_MONTH);
                Integer meshiste = calendar.get(Calendar.MONTH) + 1;
                Integer anohiste = calendar.get(calendar.YEAR);

                if (diahiste.compareTo(10) < 0) {
                    diaHisterectomia = "0" + diahiste.toString();
                } else {
                    diaHisterectomia = diahiste.toString();
                }

                if (meshiste.compareTo(10) < 0) {
                    mesHisterectomia = "0" + meshiste.toString();
                } else {
                    mesHisterectomia = meshiste.toString();
                }

                anoHisterectomia = anohiste.toString();
            }

            if (toma.getCtmdpconiz() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(toma.getCtmdpconiz());
                Integer diaconiz = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mesconiz = calendar.get(Calendar.MONTH) + 1;
                Integer anoconiz = calendar.get(calendar.YEAR);

                if (diaconiz.compareTo(10) < 0) {
                    diaConizacion = "0" + diaconiz.toString();
                } else {
                    diaConizacion = diaconiz.toString();
                }

                if (mesconiz.compareTo(10) < 0) {
                    mesConizacion = "0" + mesconiz.toString();
                } else {
                    mesConizacion = mesconiz.toString();
                }

                anoConizacion = anoconiz.toString();
            }


            if (toma.getCtmdpradio() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(toma.getCtmdpradio());
                Integer diaradio = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mesradio = calendar.get(Calendar.MONTH) + 1;
                Integer anoradio = calendar.get(calendar.YEAR);

                if (diaradio.compareTo(10) < 0) {
                    diaRadioterapia = "0" + diaradio.toString();
                } else {
                    diaRadioterapia = diaradio.toString();
                }

                if (mesradio.compareTo(10) < 0) {
                    mesRadioterapia = "0" + mesradio.toString();
                } else {
                    mesRadioterapia = mesradio.toString();
                }

                anoRadioterapia = anoradio.toString();
            }

            if (toma.getCtmdpbiops() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(toma.getCtmdpbiops());
                Integer diabiopsa = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mesbiopsa = calendar.get(Calendar.MONTH) + 1;
                Integer anobiopsa = calendar.get(calendar.YEAR);

                if (diabiopsa.compareTo(10) < 0) {
                    diaBiopsia = "0" + diabiopsa.toString();
                } else {
                    diaBiopsia = diabiopsa.toString();
                }

                if (mesbiopsa.compareTo(10) < 0) {
                    mesBiopsia = "0" + mesbiopsa.toString();
                } else {
                    mesBiopsia = mesbiopsa.toString();
                }

                anoBiopsia = anobiopsa.toString();
            }


            if (toma.getCtmdpcriot() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(toma.getCtmdpcriot());
                Integer diacrio = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mescrio = calendar.get(Calendar.MONTH) + 1;
                Integer anocrio = calendar.get(calendar.YEAR);

                if (diacrio.compareTo(10) < 0) {
                    diaCrioterapia = "0" + diacrio.toString();
                } else {
                    diaCrioterapia = diacrio.toString();
                }

                if (mescrio.compareTo(10) < 0) {
                    mesCrioterapia = "0" + mescrio.toString();
                } else {
                    mesCrioterapia = mescrio.toString();
                }

                anoCrioterapia = anocrio.toString();
            }

            if (toma.getCtmdpata() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(toma.getCtmdpata());
                Integer diaata = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mesata = calendar.get(Calendar.MONTH) + 1;
                Integer anoata = calendar.get(calendar.YEAR);

                if (diaata.compareTo(10) < 0) {
                    diaAta = "0" + diaata.toString();
                } else {
                    diaAta = diaata.toString();
                }

                if (mesata.compareTo(10) < 0) {
                    mesAta = "0" + mesata.toString();
                } else {
                    mesAta = mesata.toString();
                }

                anoAta = anoata.toString();
            }


            if (toma.getCtmdpotro() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(toma.getCtmdpotro());
                Integer diaotro = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mesotro = calendar.get(Calendar.MONTH) + 1;
                Integer anootro = calendar.get(calendar.YEAR);

                if (diaotro.compareTo(10) < 0) {
                    diaOtro = "0" + diaotro.toString();
                } else {
                    diaOtro = diaotro.toString();
                }

                if (mesotro.compareTo(10) < 0) {
                    mesOtro = "0" + mesotro.toString();
                } else {
                    mesOtro = mesotro.toString();
                }

                anoOtro = anootro.toString();
            }
            
            if (toma.getCtmdphormo() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(toma.getCtmdphormo());
                Integer diaotro = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mesotro = calendar.get(Calendar.MONTH) + 1;
                Integer anootro = calendar.get(calendar.YEAR);

                if (diaotro.compareTo(10) < 0) {
                    diaTratamientoHormonal = "0" + diaotro.toString();
                } else {
                    diaTratamientoHormonal = diaotro.toString();
                }
                
                if (mesotro.compareTo(10) < 0) {
                    mesTratamientoHormonal = "0" + mesotro.toString();
                } else {
                    mesTratamientoHormonal = mesotro.toString();
                }

                    anoTratamientoHormonal = anootro.toString();
            }

            if (toma.getCtmcpdotro() != null) {
                otroProcedimiento = toma.getCtmcpdotro();
            }
            
            if (toma.getCtmcphormo() != null) {
                tratamientoHormonal = toma.getCtmcphormo();
            }
            
            if (toma.getCtmcpningu() != null) {
                ningunProcedimiento = toma.getCtmcpningu();
            }

            if (toma.getCtmcpcaute() != null) {
                 cauterizacion = toma.getCtmcpcaute();
            }
            if (toma.getCtmcphiste() != null) {
                histerectomia = toma.getCtmcphiste();
            }
            if (toma.getCtmcpconiz() != null) {
                conizacion = toma.getCtmcpconiz();
            }
            if (toma.getCtmcpradio() != null) {
                radioterapia = toma.getCtmcpradio();
            }
            if (toma.getCtmcpbiops() != null) {
                biopsia = toma.getCtmcpbiops();
            }
            if (toma.getCtmcpcriot() != null) {
                crioterapia = toma.getCtmcpcriot();
            }
            if (toma.getCtmcpata() != null) {
                ata = toma.getCtmcpata();
            }
            if (toma.getCtmcpotro() != null) {
                otroProcedimiento = toma.getCtmcpotro();
            }

            if (toma.getCtmcpcolpo() != null) {
                colposcopia = toma.getCtmcpcolpo();
            }

            if (toma.getCtmdpcolpo() != null) {
            
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(toma.getCtmdpcolpo());
                Integer diareg = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mesreg = calendar.get(Calendar.MONTH) + 1;
                Integer anoreg = calendar.get(calendar.YEAR);

                if (diareg.compareTo(10) < 0) {
                    diaColpo = "0" + diareg.toString();
                } else {
                    diaColpo = diareg.toString();
                }

                if (mesreg.compareTo(10) < 0) {
                    mesColpo = "0" + mesreg.toString();
                } else {
                    mesColpo = mesreg.toString();
                }

                anoColpo = anoreg.toString();
            }
            
            
            if (toma.getCtmcpvapor() != null) {
                vaporizacion = toma.getCtmcpvapor();
            }

            if (toma.getCtmdpvapor() != null) {
            
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(toma.getCtmdpvapor());
                Integer diareg = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mesreg = calendar.get(Calendar.MONTH) + 1;
                Integer anoreg = calendar.get(calendar.YEAR);

                if (diareg.compareTo(10) < 0) {
                    diaVaporizacion = "0" + diareg.toString();
                } else {
                    diaVaporizacion = diareg.toString();
                }

                if (mesreg.compareTo(10) < 0) {
                    mesVaporizacion = "0" + mesreg.toString();
                } else {
                    mesVaporizacion = mesreg.toString();
                }

                anoVaporizacion = anoreg.toString();
            }
            
            if (toma.getCtmctomada() != null) {
                tomaTipoProfesional = toma.getCtmctomada();
            }

            if (toma.getCtmdfecreg() != null) {
            
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(toma.getCtmdfecreg());
                Integer diareg = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mesreg = calendar.get(Calendar.MONTH) + 1;
                Integer anoreg = calendar.get(calendar.YEAR);

                if (diareg.compareTo(10) < 0) {
                    diaTomada = "0" + diareg.toString();
                } else {
                    diaTomada = diareg.toString();
                }

                if (mesreg.compareTo(10) < 0) {
                    mesTomada = "0" + mesreg.toString();
                } else {
                    mesTomada = mesreg.toString();
                }

                anoTomada = anoreg.toString();
            }

            if (toma.getCtmcnomtom() != null) {
                tomaNombreProfesional = toma.getCtmcnomtom();
            }
            
            if (toma.getCtmcobstom() != null) {
                tomaObservaciones = toma.getCtmcobstom();
            }
            if(toma.getCtmccomvph()!= null){
                completoVph = toma.getCtmccomvph();
            }
            if(toma.getCtmclactan()!= null){
                lactanciaActual = toma.getCtmclactan();
            }
            if (toma.getCtmnclinic() != null) {
                try {
                    Cpclinica clinica = 
                        this.serviceLocator.getClinicoService().getClinica(toma.getCtmnclinic());
                    centro = clinica.getCclcnombre();
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void clearReporte() {
        APELLIDOS = "";
        NOMBRES = "";
        NUMERO_DOCUMENTO = null;
        DIRECCION = "";
        TELEFONO = "";
        CIUDAD = "";
        DEPARTAMENTO = "";
        OTRA_DIRECCION = "";
        OTRO_TELEFONO = "";
        OTRA_CIUDAD = "";
        OTRO_DEPARTAMENTO = "";
        EDAD = null;
        FECHA_REGLA = null;
        DIA_REGLA = "";
        MES_REGLA = "";
        ANNO_REGLA = "";
        GESTACIONES = null;
        PARTOS = null;
        ABORTOS = null;
        TIPO_AFILIACION = "";
        ASEGURADORA = "";
        ESQUEMA_CITOLOGIA = "";
        FECHA_PARTO = null;
        DIA_PARTO = "";
        MES_PARTO = "";
        ANNO_PARTO = "";
        EDAD_RELACIONES = null;
        METODO_PLANIFICACION = "";
        FECHA_CITOLOGIA = null;
        DIA_CITOLOGIA = "";
        MES_CITOLOGIA = "";
        ANNO_CITOLOGIA = "";
        RESULTADO_CITOLOGIA = "";
        ESTA_EMBARAZADA = "";
        APECTO_CUELLO = "";
        FECHA_CAUTERIZACION = null;
        FECHA_HISTERECTOMIA = null;
        FECHA_CONIZACION = null;
        FECHA_RADIOTERAPIA = null;
        FECHA_BIOPSA = null;
        FECHA_CRIOTERAPIA = null;
        FECHA_ATA = null;
        FECHA_OTRO = null;
        FECHA_COLPOSCOPIA = null;
        OTRO_CUAL = "";
        NINGUNO = "";
        CAUTERIZACION = "";
        HISTERECTOMIA = "";
        CONIZACION = "";
        RADIOTERAPIA = "";
        BIOPSIA = "";
        CRIOTERAPIA = "";
        ATA = "";
        OTRO = "";
        COLPOSCOPIA = "";
        TOMADA = "";
        FECHA_TOMADA = null;
        NOMBRE_TOMADA = "";
        NUMERO_CITOLOGIA = null;
        FECHA_VPH = null;
        VPH = "";
        DOSIS_VPH = null;
        OBSERVACIONES_TOMA = null;
        OTROS_HALLAZGOS = "";
        NUMERO_FAC = null;
        VAPORIZACION = "";
        FECHA_VAPORIZACION = null;
        HORMONAL = "";
        FECHA_HORMONAL = null;
        TIEMPO_METODO = null;
        COMPLETO_VPH = null;
        LACTANCIA_ACTUAL = null;


    }

    public void clearFormularioVph() {
        numeroTipificacion = null;
        centro = "";
        apellidos = "";
        nombres = "";
        tipoDocumento = "";
        numeroDocumento = null;
        edad = null;
        aseguradora = "";
        direccion = "";
        telefono = "";
        ciudad = "";
        departamento = "";
        otraDireccion = "";
        otroTelefono = "";
        otraCiudad = "";
        otroDepartamento = "";
        identidadGenero = "";
        vulnerabilidad = "";
        esquemaVph = "";
        esquemaVphCualOtro = "";
        gestaciones = null;
        partos = null;
        abortos = null;
        estaEmbarazada = "";
        planeaEmbarazoAntesAnho = "";
        edadRelaciones = null;
        metodoPlanificacion = "";
        otroMetodoPlanificacion = "";
        resultadoCitologia = "";
        otroResultadoCitologia ="";
        completoVph = "";
        lactanciaActual = "";
        cauterizacion = "";
        histerectomia = "";
        conizacion = "";
        radioterapia = "";
        biopsia = "";
        crioterapia = "";
        ata = "";
        colposcopia = "";
        vaporizacion = "";
        tratamientoHormonal = "";
        otroProcedimiento = "";
        cualOtroProcedimiento = "";
        ningunProcedimiento = "";
        cuelloSano = "";
        cuelloAusente = "";
        cuelloErosionado = "";
        cuelloCongestivo = "";
        cuelloAtrofico = "";
        cuelloUlcerado = "";
        cuelloSangrante = "";
        cuelloLesionVisible = "";
        cuelloPolipo = "";
        tomaObservaciones = "";
        tomaTipoProfesional = "";
        tomaNombreProfesional = "";
        tomaTarjetaProfesional = "";
        lecturaTipoProfesional = "";
        lecturaNombreProfesional = "";
        lecturaTarjetaProfesional = "";
        conducta = "";
        diaRegla = "";
        mesRegla = "";
        anoRegla = "";
        dosisVph = null;
        diaVph = "";
        mesVph = "";
        anoVph = "";
        diaParto = "";
        mesParto = "";
        anoParto = "";
        diaCitologia = "";
        mesCitologia = "";
        anoCitologia = "";
        diaCauterizacion = "";
        mesCauterizacion = "";
        anoCauterizacion = "";
        diaHisterectomia = "";
        mesHisterectomia = "";
        anoHisterectomia = "";
        diaConizacion = "";
        mesConizacion = "";
        anoConizacion = "";
        diaRadioterapia = "";
        mesRadioterapia = "";
        anoRadioterapia = "";
        diaBiopsia = "";
        mesBiopsia = "";
        anoBiopsia = "";
        diaCrioterapia = "";
        mesCrioterapia = "";
        anoCrioterapia = "";
        diaAta = "";
        mesAta = "";
        anoAta = "";
        diaOtro = "";
        mesOtro = "";
        anoOtro = "";
        diaTomada = "";
        mesTomada = "";
        anoTomada = "";
        diaColpo = "";
        mesColpo = "";
        anoColpo = "";
        diaVaporizacion = "";
        mesVaporizacion = "";
        anoVaporizacion = "";
        diaTratamientoHormonal = "";
        mesTratamientoHormonal = "";
        anoTratamientoHormonal = "";
        ninguna = "";
        habitanteCalle = "";
        desmovilizado = "";
        inmigrante = "";
        poblacionInfantilCargoICBF = "";
        poblacionAfectadasConflictoArmado = "";
        madreComunitaria = "";
        trabajadoresSexuales = "";
        personadiscapacidad = "";
        personaPrivadaLibertad = "";
        tipificacion = "";
        baseLiquida = "";
        convencional = "";
        numeroBaseLiquida = null;
        numeroConvencional = null;
        esquemaCitologia = "";
        otroEsquemaCitologia = "";
        resultadoTipificacion = "";
        
    }


    public String generarPDF() {
        if (!temporal) {   
            clearReporte();
            clearFormularioVph();
            clearCodigoQRVPH();
            try {
                index = -1;
                URL url = null;
                URL url_profamilia = null;
                try {
                    toma = serviceLocator.getClinicoService().getTomaCitologia(citologia.getCcinconsec());
        
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                    if ((tipoHistoria != null && 
                        tipoHistoria.equals(HISTORIA_PROCEDIMIENTO_VPH_TOMA))||(tipoHistoria != null && tipoHistoria.equals(HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA_BASELIQUIDA))) {
                    url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/TomaTipificacionVPH FO_GS_AD-020.jasper");
                    url_profamilia = 
                       FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_NEW);
                       obtenerDatosReporteVPH();
                }else{
                if(esPolicia){
                     url = 
                        FacesUtils.getFacesContext().getExternalContext().getResource("/reports/tomaCitologiaPolicia.jasper");    
                     url_profamilia = 
                        FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_POLICIA);
                    obtenerDatosReporte();
                }else{
                     url = 
                        FacesUtils.getFacesContext().getExternalContext().getResource("/reports/tomaCitologia.jasper");    
                        
                    url_profamilia = 
                       FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_NEW);
                    obtenerDatosReporte();
                }
            }
               
                URL url_super_horizontal = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
                URL url_super_vertical = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
                if (url != null) {
                    Map parameters = new HashMap();
                    parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                    parameters.put("IMAGE_SUPER_HORIZONTAL", 
                                   url_super_horizontal);
                    parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                    byte[] bytes;

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);

                    bytes = 
                            JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                    PdfServletUtils.showPdfDocument(bytes, 
                                                    "tomaCitologia" + Calendar.getInstance().getTimeInMillis() + 
                                                    ".pdf", false);
                    generoCitologia = true;
                    modoConsulta = true;
                    //if(toma.getCtmntiphis()!= null && toma.getCtmntiphis().equals(HISTORIA_PROCEDIMIENTO_VPH_TOMA)){
                       // imprimirCodigoQRvph =true;
                      //}
                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
            }
        }
        //   }

        if (temporal) {
            FacesUtils.resetManagedBean("listaCitologiasBean");
            FacesUtils.resetManagedBean("datosUsuarioCitologiaBean");
            FacesUtils.resetManagedBean("tomaCitologiaBean");
            return BeanNavegacion.RUTA_LISTA_CITOLOGIAS_PROGRAMADAS;
        } else {
            return BeanNavegacion.RUTA_ACTUAL;
        }
    }
    
    public void generarReporteCodigoQR() {
        clearReporte();
        clearFormularioVph();
        clearCodigoQRVPH();
        ModuleConfig config = new ModuleConfig();
        toma = null;

            try {
                toma = serviceLocator.getClinicoService().getTomaCitologia(citologia.getCcinconsec());

            } catch (ModelException e) {
                e.printStackTrace();
            }

        try {
            obtenerDatosReporteQR();

            codigoQRClient = new CodigoQRClient();
            String respuesta = codigoQRClient.generarCodigoQR(citologia, toma, CENTRO);
            
            if (respuesta.equals(IConstantes.OK_REQUEST)) {
                index = -1;
                URL url = null;
                String url_codigo_QR = null;

                url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/CodigoQRCitologiaVPH.jasper");
                //url_codigo_QR="C:/Windows/Temp/" + citologia.getCcinconsec().toString() + ".png";
                 url_codigo_QR=config.getUbicacionCodigoQR() + citologia.getCcinconsec().toString() + ".png";

                if (url != null) {
                    Map parameters = new HashMap();
                    parameters.put("CODIGO_QR", url_codigo_QR);
                    byte[] bytes;

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);

                    bytes = 
                            JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                    PdfServletUtils.showPdfDocument(bytes, 
                                                    "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                                    ".pdf", false);


                    generoCitologia = true;
                    modoConsulta = true;
                    imprimirCodigoQRvph=true;
                }
            } else {
                FacesUtils.addErrorMessage("No se puedo generar codigo QR-Respuesta:" + 
                                           respuesta);
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
    }
    
    public void clearCodigoQRVPH() {
        NOMBRE="";
        TIPO_IDENTIFICACION="";
        NUMERO_IDENTIFICACION="";
        FECHA_TOMA="";
        NUMERO_CITOLOGIA_VPH="";
        CLINICA="";
    }
    
    public void obtenerDatosReporteQR() {
        SimpleDateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        NOMBRE=citologia.getCcicprinom()+" "+citologia.getCcicpriape();
        TIPO_IDENTIFICACION = citologia.getCcictipide();
        NUMERO_IDENTIFICACION = citologia.getCcianumide().toString();
        FECHA_TOMA = df.format(toma.getCtmdfecreg());
        NUMERO_CITOLOGIA_VPH = citologia.getCcinconsec().toString();
        if (toma.getCtmnclinic() != null) {
            try {
                Cpclinica clinica = 
                    this.serviceLocator.getClinicoService().getClinica(toma.getCtmnclinic());
                CLINICA = clinica.getCclcnombre();
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
    
    }


    //------------------------------------------------------------------------------------------------------------------
    //  Boton Principal 
    //------------------------------------------------------------------------------------------------------------------

    /**
     * @return
     */
    public void aceptar() {

        String aspectoCuello;
        aspectoCuello = "";
        boolean wexito;
        wexito = true;


        if (lstAspectoSelect != null && !lstAspectoSelect.isEmpty()) {
            Iterator it = lstAspectoSelect.iterator();
            int i = 0;
            while (it.hasNext()) {
                aspectoCuello = aspectoCuello + "," + lstAspectoSelect.get(i);
                it.next();
                i++;
            }

            if (aspectoCuello != null && aspectoCuello.length() > 2) {
                aspectoCuello = 
                        aspectoCuello.substring(1, aspectoCuello.length());
            }
        }

        if (toma != null) {
        
        
            if(toma.getCtmngestac()!= null && toma.getCtmngestac().equals(0)){
                toma.setCtmnaborto(0);
                toma.setCtmnpartos(0);
            }

            if (toma.getCtmcpningu() != null && 
                toma.getCtmcpningu().equals("N")) {


                if ((toma.getCtmcpcaute() == null || 
                     toma.getCtmcpcaute().equals("N")) && 
                    (toma.getCtmcphiste() == null || 
                     toma.getCtmcphiste().equals("N")) && 
                    (toma.getCtmcpconiz() == null || 
                     toma.getCtmcpconiz().equals("N")) && 
                    (toma.getCtmcpradio() == null || 
                     toma.getCtmcpradio().equals("N")) && 
                    (toma.getCtmcpbiops() == null || 
                     toma.getCtmcpbiops().equals("N")) && 
                    (toma.getCtmcpcriot() == null || 
                     toma.getCtmcpcriot().equals("N")) && 
                    (toma.getCtmcpata() == null || 
                     toma.getCtmcpata().equals("N")) && 
                    (toma.getCtmcpvapor() == null || 
                     toma.getCtmcpvapor().equals("N")) && 
                    (toma.getCtmcphormo() == null || 
                     toma.getCtmcphormo().equals("N")) && 
                    (toma.getCtmcpotro() == null || 
                     toma.getCtmcpotro().equals("N"))&& 
                    (toma.getCtmcpcolpo() == null || 
                     toma.getCtmcpcolpo().equals("N"))) {

                    wexito = false;

                }


            }


        }

        generoCitologia = false;
        clearReporte();
        clearCodigoQRVPH();
        clearFormularioVph();
        modoConsulta = false;
        imprimirCodigoQRvph =false;
        if (citologia != null) {
            toma.setCtmnconsec(citologia.getCcinconsec());
            toma.setCtmnnumero(citologia.getCcinnumero());
        }

        toma.setCtmnclinic(this.getClinica().getCclncodigo());
        toma.setCtmdfectom(new Date());
        toma.setCtmdfecreg(new Date());
        toma.setCtmcnomtom(getUsuarioSystem().getCurcnombre());
        toma.setCtmcusureg(userName());
        toma.setCtmcaspcue(aspectoCuello);
        if (temporal) {
            toma.setCtmcaspcue("NA");
        }
        
        if(tipoHistoria != null){
            toma.setCtmntiphis(tipoHistoria);
        }else{
             toma.setCtmntiphis(citologia.getCcintiphis());
        }

        if (wexito) {
            try {
                if (consulta != null) {
                
//                    List<Cfdetafactura> listaDetafactura = this.getServiceLocator().getClinicoService().validacionTomaPaquete(consulta.getCconnumero());
                      List<Cfdetafactura> listaDetafactura = this.getServiceLocator().getClinicoService().validacionTomaPaquete(consulta.getCconnumdoc().longValue(), consulta.getCcocservic().getCsvccodigo(), consulta.getCconnumero().longValue());

                    if(listaDetafactura.isEmpty()){
                        this.getServiceLocator().getClinicoService().closeTomaCitologia(toma, 
                                                                                    consulta, 
                                                                                    userName(), 
                                                                                    temporal);
                    }else if(listaDetafactura.size()==1){
                    
                        this.getServiceLocator().getClinicoService().closeTomaCitologia(toma, 
                                                                                    consulta, 
                                                                                    userName(), 
                                                                                    temporal);
                                                                                    
                        Cnconsclin consulta2 = this.getServiceLocator().getClinicoService().getConsultaClinicaPorId(listaDetafactura.get(0).getCdfnconsuclin().toString());
                        Cncitologi citologia2 = null;
                        try {
                            if (consulta2 != null) {
                                citologia2 = 
                                        this.serviceLocator.getClinicoService().getUsuarioCitologia(consulta2);
                            }
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }
                        
                        if (citologia2 != null) {
                            Cncitotoma toma2 = new  Cncitotoma();
                            toma2.setCtmnconsec(citologia2.getCcinconsec());
                            toma2.setCtmnnumero(citologia2.getCcinnumero());
                            toma2.setCtmntiphis(citologia2.getCcintiphis());
                            toma2.setCtmnclinic(toma.getCtmnclinic());
                            toma2.setCtmdfectom(toma.getCtmdfectom());
                            toma2.setCtmctomada(toma.getCtmctomada());
                            toma2.setCtmcnomtom(toma.getCtmcnomtom());
                            toma2.setCtmcesquem(toma.getCtmcesquem());
                            toma2.setCtmdultmen(toma.getCtmdultmen());
                            toma2.setCtmdultpar(toma.getCtmdultpar());
                            toma2.setCtmngestac(toma.getCtmngestac());
                            toma2.setCtmnpartos(toma.getCtmnpartos());
                            toma2.setCtmnaborto(toma.getCtmnaborto());
                            toma2.setCtmcembara(toma.getCtmcembara());
                            toma2.setCtmnedarel(toma.getCtmnedarel());
                            toma2.setCtmcmetpla(toma.getCtmcmetpla());
                            toma2.setCtmdultcit(toma.getCtmdultcit());
                            toma2.setCtmcultres(toma.getCtmcultres());
                            toma2.setCtmcpningu(toma.getCtmcpningu());
                            toma2.setCtmcpcaute(toma.getCtmcpcaute());
                            toma2.setCtmdpcaute(toma.getCtmdpcaute());
                            toma2.setCtmcphiste(toma.getCtmcphiste());
                            toma2.setCtmdphiste(toma.getCtmdphiste());
                            toma2.setCtmcpconiz(toma.getCtmcpconiz());
                            toma2.setCtmdpconiz(toma.getCtmdpconiz());
                            toma2.setCtmcpradio(toma.getCtmcpradio());
                            toma2.setCtmdpradio(toma.getCtmdpradio());
                            toma2.setCtmcpbiops(toma.getCtmcpbiops());
                            toma2.setCtmdpbiops(toma.getCtmdpbiops());
                            toma2.setCtmcpcriot(toma.getCtmcpcriot());
                            toma2.setCtmdpcriot(toma.getCtmdpcriot());
                            toma2.setCtmcpata(toma.getCtmcpata());
                            toma2.setCtmdpata(toma.getCtmdpata());
                            toma2.setCtmcpotro(toma.getCtmcpotro());
                            toma2.setCtmdpotro(toma.getCtmdpotro());
                            toma2.setCtmcpdotro(toma.getCtmcpdotro());
                            toma2.setCtmcaspcue(toma.getCtmcaspcue());
                            toma2.setCtmcusureg(toma.getCtmcusureg());
                            toma2.setCtmdfecreg(toma.getCtmdfecreg());
                            toma2.setCtmcvph(toma.getCtmcvph());
                            toma2.setCtmnvph(toma.getCtmnvph());
                            toma2.setCtmdvph(toma.getCtmdvph());
                            toma2.setCtmcotrhal(toma.getCtmcotrhal());
                            toma2.setCtmcotrmet(toma.getCtmcotrmet());
                            toma2.setCtmcobstom(toma.getCtmcobstom());
                            toma2.setCtmcpvapor(toma.getCtmcpvapor());
                            toma2.setCtmdpvapor(toma.getCtmdpvapor());
                            toma2.setCtmcphormo(toma.getCtmcphormo());
                            toma2.setCtmdphormo(toma.getCtmdphormo());
                            toma2.setCtmccomvph(toma.getCtmccomvph());
                            toma2.setCtmclactan(toma.getCtmclactan());
                            toma2.setCtmntiemet(toma.getCtmntiemet());
                            toma2.setCtmctipusu(toma.getCtmctipusu());
                            toma2.setCtmcnumrem(toma.getCtmcnumrem());
                            toma2.setCtmcplaemb(toma.getCtmcplaemb());
                            toma2.setCtmcccuconv(toma.getCtmcccuconv());
                            toma2.setCtmcccubl(toma.getCtmcccubl());
                            toma2.setCtmctipifi(toma.getCtmctipifi());
                            toma2.setCtmdtipifi(toma.getCtmdtipifi());
                            toma2.setCtmcpcolpo(toma.getCtmcpcolpo());
                            toma2.setCtmdpcolpo(toma.getCtmdpcolpo());
                            toma2.setCtmcotresq(toma.getCtmcotresq());
                            toma2.setCtmnnudoad(toma.getCtmnnudoad());
                            toma2.setCtmcesqvph(toma.getCtmcesqvph());
                            toma2.setCtmcotresqvph(toma.getCtmcotresqvph());
                            
                            this.getServiceLocator().getClinicoService().closeTomaCitologia(toma2, 
                                                                                            consulta2, 
                                                                                            userName(), 
                                                                                            temporal);
                        }
                    }
                    modoConsulta = true;
                    
                    if(toma.getCtmntiphis()!= null && toma.getCtmntiphis().equals(HISTORIA_PROCEDIMIENTO_VPH_TOMA)){
                        imprimirCodigoQRvph =true;
                    }
                    RegistraEpicienterResult registraEpicienterResult = new RegistraEpicienterResult();
                    if(toma.getCtmntiphis()!= null && toma.getCtmntiphis().equals(HISTORIA_PROCEDIMIENTO_VPH_TOMA)){
                        tomaVphWS = new TomaVphWS();
                        registraEpicienterResult = tomaVphWS.registroTomaVph(citologia,consulta,usuario);
                        FacesUtils.addInfoMessage(IMsg.MSG_ADICION +"Respuesta WS:" + registraEpicienterResult.getGlosaRespuesta());
                    }else{
                        FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                    }
                   //FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                }
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + ": " + 
                                           e.getMessage());
                                           e.printStackTrace();

            } catch (Exception e1) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + ": " + 
                                           e1.getMessage());
                e1.printStackTrace();

            }
        } else {
            FacesUtils.addErrorMessage(MSG_SELECCIONE_PROCEDIMIENTO_CUELLO_UTERINO);
        }


    }


    /**
     * @param mostrarFechaVaporizacion
     */
    public void setMostrarFechaVaporizacion(boolean mostrarFechaVaporizacion) {
        this.mostrarFechaVaporizacion = mostrarFechaVaporizacion;
    }

    /**
     * @return
     */
    public boolean isMostrarFechaVaporizacion() {
        return mostrarFechaVaporizacion;
    }

    /**
     * @param mostrarFechaHormonal
     */
    public void setMostrarFechaHormonal(boolean mostrarFechaHormonal) {
        this.mostrarFechaHormonal = mostrarFechaHormonal;
    }

    /**
     * @return
     */
    public boolean isMostrarFechaHormonal() {
        return mostrarFechaHormonal;
    }

    /**
     * @param mnuVaporizacion
     */
    public void setMnuVaporizacion(UIInput mnuVaporizacion) {
        this.mnuVaporizacion = mnuVaporizacion;
    }

    /**
     * @return
     */
    public UIInput getMnuVaporizacion() {
        return mnuVaporizacion;
    }

    /**
     * @param mnuHormonal
     */
    public void setMnuHormonal(UIInput mnuHormonal) {
        this.mnuHormonal = mnuHormonal;
    }

    /**
     * @return
     */
    public UIInput getMnuHormonal() {
        return mnuHormonal;
    }

    /**
     * @param renderTiempoUso
     */
    public void setRenderTiempoUso(boolean renderTiempoUso) {
        this.renderTiempoUso = renderTiempoUso;
    }

    /**
     * @return
     */
    public boolean isRenderTiempoUso() {
        return renderTiempoUso;
    }


    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setEsPolicia(boolean esPolicia) {
        this.esPolicia = esPolicia;
    }

    public boolean isEsPolicia() {
        return esPolicia;
    }

    public void setLstTipoUsuario(List lstTipoUsuario) {
        this.lstTipoUsuario = lstTipoUsuario;
    }

    public List getLstTipoUsuario() {
    
    if(lstTipoUsuario == null || lstTipoUsuario.isEmpty()){
        lstTipoUsuario = new ArrayList();
        
        lstTipoUsuario.add(new SelectItem("",""));
        lstTipoUsuario.add(new SelectItem("AC","Activo"));
        lstTipoUsuario.add(new SelectItem("BE","Beneficiario"));
        lstTipoUsuario.add(new SelectItem("PE","Pensionado"));
        
        
    }
    
        return lstTipoUsuario;
    }

    public void setTomaVphWS(TomaVphWS tomaVphWS) {
        this.tomaVphWS = tomaVphWS;
    }

    public TomaVphWS getTomaVphWS() {
        return tomaVphWS;
    }

    public void setMostrarOtroEsquema(boolean mostrarOtroEsquema) {
        this.mostrarOtroEsquema = mostrarOtroEsquema;
    }

    public boolean isMostrarOtroEsquema() {
        return mostrarOtroEsquema;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setCtmcesquem(ValueChangeEvent valueChangeEvent) {
        toma.setCtmcesquem((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setCtmcesqVph(ValueChangeEvent valueChangeEvent) {
        toma.setCtmcesqvph((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setCtmccomvph(ValueChangeEvent valueChangeEvent) {
        toma.setCtmccomvph((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setMostrarNumDosisAdmini(boolean mostrarNumDosisAdmini) {
        this.mostrarNumDosisAdmini = mostrarNumDosisAdmini;
    }
    
    public void setCtmdtipifi(ValueChangeEvent valueChangeEvent) {
        toma.setCtmdtipifi((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public boolean isMostrarNumDosisAdmini() {
        return mostrarNumDosisAdmini;
    }

    public void setLstResultTipificacion(List lstResultTipificacion) {
        this.lstResultTipificacion = lstResultTipificacion;
    }

    public List getLstResultTipificacion() {
        if (lstResultTipificacion.size() == 0) {
            ArrayList<Cndesccito> lstTomaAux = null;
            try {
                lstTomaAux = 
                        (ArrayList<Cndesccito>)this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitotoma", 
                                                                                                                               "ctmctipifi");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstTomaAux.isEmpty()) {
                Iterator it = lstTomaAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstResultTipificacion.add(new SelectItem((lstTomaAux.get(i).getCdicvalor()), 
                                                   lstTomaAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstResultTipificacion;
    }

    public void setMostrarResultTipificacion(boolean mostrarResultTipificacion) {
        this.mostrarResultTipificacion = mostrarResultTipificacion;
    }

    public boolean isMostrarResultTipificacion() {
        return mostrarResultTipificacion;
    }

    public void setMnuColpos(UIInput mnuColpos) {
        this.mnuColpos = mnuColpos;
    }

    public UIInput getMnuColpos() {
        return mnuColpos;
    }

    public void setMostrarFechaColpos(boolean mostrarFechaColpos) {
        this.mostrarFechaColpos = mostrarFechaColpos;
    }

    public boolean isMostrarFechaColpos() {
        return mostrarFechaColpos;
    }

    public void setItNumPartos(UIInput itNumPartos) {
        this.itNumPartos = itNumPartos;
    }

    public UIInput getItNumPartos() {
        return itNumPartos;
    }

    public void setImprimirCodigoQRvph(boolean imprimirCodigoQRvph) {
        this.imprimirCodigoQRvph = imprimirCodigoQRvph;
    }

    public boolean isImprimirCodigoQRvph() {
        return imprimirCodigoQRvph;
    }

    public void setLstEsquemaVph(List lstEsquemaVph) {
        this.lstEsquemaVph = lstEsquemaVph;
    }

    public List getLstEsquemaVph() {
    
        if (lstEsquemaVph.size() == 0) {
            ArrayList<Cndesccito> lstEsqueAux = null;
            try {
                    lstEsqueAux = 
                            (ArrayList<Cndesccito>)this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitotoma", 
                                                                                                                               "ctmcvphesq");
               
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstEsqueAux.isEmpty()) {

                lstEsquemaVph.add(new SelectItem("", 
                                              "Seleccione una opcion ..."));
                Iterator it = lstEsqueAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstEsquemaVph.add(new SelectItem((lstEsqueAux.get(i).getCdicvalor()), 
                                                  lstEsqueAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstEsquemaVph;
    }

    public void setMostrarOtroEsquemaVph(boolean mostrarOtroEsquemaVph) {
        this.mostrarOtroEsquemaVph = mostrarOtroEsquemaVph;
    }

    public boolean isMostrarOtroEsquemaVph() {
        return mostrarOtroEsquemaVph;
    }
}
