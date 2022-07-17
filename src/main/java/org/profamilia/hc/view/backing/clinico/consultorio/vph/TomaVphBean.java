//======================================================================================================================
// ARCHIVO TomaVphBean
// FECHA CREACI�N: 
// AUTOR: jariano, nlis
// Descripcion:  
//======================================================================================================================
package org.profamilia.hc.view.backing.clinico.consultorio.vph;
//======================================================================================================================
//  BIBLIOTECAS REQUERIDAS
//======================================================================================================================

import java.math.BigDecimal;

import java.net.URL;

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

import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chdatosvph;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chvphtoma;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cndesccito;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

//======================================================================================================================
//  CLASE EntregaCitologiaBean
//======================================================================================================================
public class TomaVphBean extends BaseBean implements JRDataSource {

    //------------------------------------------------------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //------------------------------------------------------------------------------------------------------------------
    private Chvphtoma toma;

    private List lstEsquema;

    private List lstOpciones;

    private List lstOpcionesvph;

    private List lstMetodos;

    private List lstResultado;

    private List lstOpcionesInvertido;

    private List lstVphResultado;

    private List lstTomada;

    private List lstTipoUsuario;

    private boolean esCeroGestaciones;

    private boolean esCeroPartos;

    private boolean mostrarResultado;

    private boolean mostrarVphResultado;

    private boolean mostrarFechaCauterizacion;

    private boolean mostrarFechaHisterectomia;

    private boolean mostrarFechaConizacion;

    private boolean mostrarFechaBiopsia;

    private boolean mostrarFechaCrioterapia;

    private boolean mostrarFechaRadioterapia;

    private boolean mostrarFechaATA;

    private boolean mostrarFechaOtro;

    private boolean mostrarFechaColposcopia;

    private boolean mostrarFechaVaporizacion;

    private boolean mostrarFechaHormonal;

    private boolean mostrarProcedimiento;

    private boolean modoConsulta;

    private boolean mostrarhallazgos;

    private boolean mostrarotrometodo;

    private boolean renderTiempoUso;

    private Chdatosvph tipivph;

    private List lstAspecto;

    private List lstAspectoSelect;

    private int index = -1;

    private boolean generoVph;

    private static int NUMERO_COPIAS = 1;

    private boolean temporal;

    private boolean mostrarvph;

    private Integer consecCitologia;

    private UIInput mnuCauterizacion;
    private UIInput mnuHistectomia;

    private UIInput mnuColposcopia;
    private UIInput mnuVaporizacion;
    private UIInput mnuHormonal;

    private UIInput mnuConizacion;
    private UIInput mnuRadioterapia;
    private UIInput mnuBiopsia;
    private UIInput mnuCrioterapia;
    private UIInput mnuATA;
    private UIInput mnuOtro;
    private UIInput mnuResultado;

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

    Integer GESTACIONES;
    Integer PARTOS;
    Integer ABORTOS;
    String TIPO_AFILIACION;
    String ASEGURADORA;
    String APECTO_CUELLO;

    Date FECHA_PARTO;

    String ESTA_EMBARAZADA;
    Integer EDAD_RELACIONES;
    String METODO_PLANIFICACION;
    Date FECHA_CITOLOGIA;
    String RESULTADO_CITOLOGIA;

    Date FECHA_CAUTERIZACION;
    Date FECHA_HISTERECTOMIA;
    Date FECHA_CONIZACION;
    Date FECHA_RADIOTERAPIA;
    Date FECHA_BIOPSA;
    Date FECHA_CRIOTERAPIA;
    Date FECHA_ATA;
    Date FECHA_VAPORIZACION;
    Date FECHA_HORMONAL;
    Date FECHA_COLPOSCOPIA;
    Date FECHA_OTRO;

    String NINGUNO;
    String CAUTERIZACION;
    String HISTERECTOMIA;
    String CONIZACION;
    String RADIOTERAPIA;
    String BIOPSIA;
    String CRIOTERAPIA;
    String ATA;
    String VAPORIZACION;
    String HORMONAL;
    String COLPOSCOPIA;
    String OTRO;
    String OTRO_CUAL;

    String TOMADA;
    Date FECHA_TOMADA;
    String NOMBRE_TOMADA;
    String TARJETA_PROFESIONAL_TOMA;
    String OBSERVACIONES_TOMA;

    Integer NUMERO_TIPIFICACION;
    Date FECHA_TIPIFICACION;
    String VPH;
    Date FECHA_VPH;
    Integer DOSIS_VPH;

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
    BigDecimal TIEMPO_METODO;

    String COMPLETO_VPH;
    String LACTANCIA_ACTUAL;
    String PLANEA_EMABARAZO_ANTES_1ANHO;

    String IDENTIDAD_GENERO;
    String VULNERABILIDAD;
    String ESQUEMA_VPH;
    String ESQUEMA_VPH_CUAL_OTRO;

    String GENOTIPIFICACION_NEG;
    String GENOTIPIFICACION;
    String TARJETA_PROFESIONAL_LECTURA;

    //------------------------------------------------------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //------------------------------------------------------------------------------------------------------------------
    public TomaVphBean() {

    }

    public void init() {
        toma = new Chvphtoma();
        lstAspecto = new ArrayList();
        lstEsquema = new ArrayList();
        lstOpciones = new ArrayList();
        lstMetodos = new ArrayList();
        lstResultado = new ArrayList();
        lstOpcionesInvertido = new ArrayList();
        lstTomada = new ArrayList();
        lstOpcionesvph = new ArrayList();
        lstVphResultado = new ArrayList();
        lstAspectoSelect = new ArrayList();
        lstTipoUsuario = new ArrayList();
        inicializarTomaVph();
    }

    public void inicializarTomaVph() {
        generoVph = false;
        mostrarResultado = false;
        mostrarVphResultado = false;
        esCeroPartos = false;

        try {
            if (consulta != null) {
                tipivph
                        = this.serviceLocator.getClinicoService().getUsuarioVph(consulta);
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (tipivph != null) {
            consecCitologia = tipivph.getHdvnconsec();
            try {
                toma = this.serviceLocator.getClinicoService().getTomaVph(tipivph.getHdvnconsec());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (toma == null) {
            toma = new Chvphtoma();
        } else {
            if (toma.getHvtdultcit() != null) {
                mostrarResultado = true;
            } else {
                mostrarResultado = false;
                mostrarhallazgos = false;
            }
            if (toma.getHvtdtipifi() != null) {
                mostrarVphResultado = true;
            } else {
                mostrarVphResultado = false;
            }

            if (toma.getHvtcultres() != null
                    && toma.getHvtcultres().equals("2.2")) {
                mostrarhallazgos = true;
            } else {
                mostrarhallazgos = false;
            }

            if (toma.getHvtcaspcue() != null
                    && !toma.getHvtcaspcue().equals("NA")) {
                modoConsulta = true;
            } else {
                modoConsulta = false;
            }

            if (toma.getHvtcaspcue() != null
                    && !toma.getHvtcaspcue().equals("")) {
                StringTokenizer st
                        = new StringTokenizer(toma.getHvtcaspcue(), ",");
                while (st.hasMoreTokens()) {
                    String aspec = st.nextToken();
                    lstAspectoSelect.add(aspec);
                }
            }

            if (toma.getHvtngestac() != null
                    && toma.getHvtngestac().compareTo(0) == 0) {
                esCeroGestaciones = true;
            } else {
                esCeroGestaciones = false;
            }

            if (toma.getHvtcpningu() != null
                    && toma.getHvtcpningu().equals("N")) {
                mostrarProcedimiento = true;

            } else {
                mostrarProcedimiento = false;
            }

            if (toma.getHvtcpcaute() != null && toma.getHvtcpcaute() != null
                    && toma.getHvtcpcaute().equals("S")) {
                mostrarFechaCauterizacion = true;
            } else {
                mostrarFechaCauterizacion = false;
            }

            if (toma.getHvtcphiste() != null && toma.getHvtcphiste() != null
                    && toma.getHvtcphiste().equals("S")) {
                mostrarFechaHisterectomia = true;
            } else {
                mostrarFechaHisterectomia = false;
            }

            if (toma.getHvtcpconiz() != null && toma.getHvtcpconiz() != null
                    && toma.getHvtcpconiz().equals("S")) {
                mostrarFechaConizacion = true;
            } else {
                mostrarFechaConizacion = false;
            }

            if (toma.getHvtcpbiops() != null && toma.getHvtcpbiops() != null
                    && toma.getHvtcpbiops().equals("S")) {
                mostrarFechaBiopsia = true;
            } else {
                mostrarFechaBiopsia = false;
            }
            if (toma.getHvtcpcriot() != null && toma.getHvtcpcriot() != null
                    && toma.getHvtcpcriot().equals("S")) {
                mostrarFechaCrioterapia = true;
            } else {
                mostrarFechaCrioterapia = false;
            }

            if (toma.getHvtcpata() != null && toma.getHvtcpata() != null
                    && toma.getHvtcpata().equals("S")) {
                mostrarFechaATA = true;
            } else {
                mostrarFechaATA = false;
            }
            if (toma.getHvtcpotro() != null && toma.getHvtcpotro() != null
                    && toma.getHvtcpotro().equals("S")) {
                mostrarFechaOtro = true;
            } else {
                mostrarFechaOtro = false;
            }

            if (toma.getHvtcpradio() != null && toma.getHvtcpradio() != null
                    && toma.getHvtcpradio().equals("S")) {
                mostrarFechaRadioterapia = true;
            } else {
                mostrarFechaRadioterapia = false;
            }

            if (toma.getHvtcpcolpo() != null
                    && toma.getHvtcpcolpo().equals("S")) {
                mostrarFechaColposcopia = true;
            } else {
                mostrarFechaColposcopia = false;
            }

            if (toma.getHvtcpvapor() != null
                    && toma.getHvtcpvapor().equals("S")) {
                mostrarFechaVaporizacion = true;
            } else {
                mostrarFechaVaporizacion = false;
            }

            if (toma.getHvtcphormo() != null
                    && toma.getHvtcphormo().equals("S")) {
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
                lstTomaAux
                        = (ArrayList<Cndesccito>) this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cnvphtoma",
                                "ctmcvphesq");
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
    public void setToma(Chvphtoma toma) {
        this.toma = toma;
    }

    /**
     * @return
     */
    public Chvphtoma getToma() {
        return toma;
    }

    public Chdatosvph getTipivph() {
        return tipivph;
    }

    public void setTipivph(Chdatosvph tipivph) {
        this.tipivph = tipivph;
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
                lstTomaAux
                        = (ArrayList<Cndesccito>) this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitotoma",
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
                lstMetodosAux
                        = (ArrayList<Cndesccito>) this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitotoma",
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
                            lstMetodosAux.get(i).getCdicvalor()
                            + "  "
                            + lstMetodosAux.get(i).getCdicdescri()));
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
                lstMetodosAux
                        = (ArrayList<Cndesccito>) this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitotoma",
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
                            lstMetodosAux.get(i).getCdicvalor()
                            + "  "
                            + lstMetodosAux.get(i).getCdicdescri()));
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
     * @return
     */
    public List getLstVphResultado() {
        if (lstVphResultado.size() == 0) {
            lstVphResultado.add(new SelectItem("N", "Negativo"));
            lstVphResultado.add(new SelectItem("S", "Positivo"));
            lstVphResultado.add(new SelectItem("X", "No Sabe"));
        }
        return lstVphResultado;
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
     * @param generoVph
     */
    public void setGeneroVph(boolean generoVph) {
        this.generoVph = generoVph;
    }

    /**
     * @return
     */
    public boolean isGeneroVph() {
        return generoVph;
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

    public boolean isMostrarVphResultado() {
        return mostrarVphResultado;
    }

    public void setMostrarVphResultado(boolean mostrarVphResultado) {
        this.mostrarVphResultado = mostrarVphResultado;
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
                lstTomadaAux
                        = (ArrayList<Cndesccito>) this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitotoma",
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
                            lstTomadaAux.get(i).getCdicvalor()
                            + "  "
                            + lstTomadaAux.get(i).getCdicdescri()));
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
                lstMetodosAux
                        = (ArrayList<Cndesccito>) this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitotoma",
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
        toma.setHvtngestac((Integer) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHvtnpartos(ValueChangeEvent valueChangeEvent) {
        toma.setHvtnpartos((Integer) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHvtcpningu(ValueChangeEvent valueChangeEvent) {
        toma.setHvtcpningu((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHvtcpcaute(ValueChangeEvent valueChangeEvent) {
        toma.setHvtcpcaute((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHvtcphiste(ValueChangeEvent valueChangeEvent) {
        toma.setHvtcphiste((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHvtcpconiz(ValueChangeEvent valueChangeEvent) {
        toma.setHvtcpconiz((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHvtcpradio(ValueChangeEvent valueChangeEvent) {
        toma.setHvtcpradio((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHvtcpbiops(ValueChangeEvent valueChangeEvent) {
        toma.setHvtcpbiops((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHvtcpcriot(ValueChangeEvent valueChangeEvent) {
        toma.setHvtcpcriot((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHvtcpata(ValueChangeEvent valueChangeEvent) {
        toma.setHvtcpata((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHvtcpotro(ValueChangeEvent valueChangeEvent) {
        toma.setHvtcpotro((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHvtdultcit(ValueChangeEvent valueChangeEvent) {
        toma.setHvtdultcit((Date) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHvtdtipifi(ValueChangeEvent valueChangeEvent) {
        toma.setHvtdtipifi((Date) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHvtcultres(ValueChangeEvent valueChangeEvent) {
        toma.setHvtcultres((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHvtcmetpla(ValueChangeEvent valueChangeEvent) {
        toma.setHvtcmetpla((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHvtcpcolpo(ValueChangeEvent valueChangeEvent) {
        toma.setHvtcpcolpo((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHvtcpvapor(ValueChangeEvent valueChangeEvent) {
        toma.setHvtcpvapor((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHvtcphormo(ValueChangeEvent valueChangeEvent) {
        toma.setHvtcphormo((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void changeNumeroGestaciones() {
        esCeroPartos = false;
        if (toma != null && toma.getHvtngestac().compareTo(0) == 0) {
            toma.setHvtngestac(0);
            toma.setHvtnaborto(0);
            toma.setHvtnpartos(0);
            toma.setHvtdultpar(null);
            esCeroGestaciones = true;
            esCeroPartos = true;
        } else {

            toma.setHvtnaborto(null);
            toma.setHvtnpartos(null);
            toma.setHvtdultpar(null);
            esCeroGestaciones = false;
        }
    }

    public void changeNumeroPartos() {
        esCeroPartos = false;
        if (toma != null && toma.getHvtnpartos() != null
                && toma.getHvtnpartos().compareTo(0) == 0) {
            toma.setHvtdultpar(null);
            esCeroPartos = true;
        } else {
            toma.setHvtdultpar(null);
        }
    }

    public void cargarDatos() {
        Chantegineco antecedentes;
        antecedentes = null;

        try {
            if (usuario != null && usuario.getHuslnumero() != null) {
                antecedentes
                        = serviceLocator.getClinicoService().getUltimoAntecedentesGinecologicos(usuario.getHuslnumero());
            }

            if (antecedentes != null) {
                if (antecedentes.getHagdfuc() != null) {
                    toma.setHvtdultcit(antecedentes.getHagdfuc());
                    mostrarResultado = true;
                }

                if (antecedentes.getHagdfur() != null) {
                    toma.setHvtdultmen(antecedentes.getHagdfur());
                }

                if (antecedentes.getHagdfup() != null) {
                    toma.setHvtdultpar(antecedentes.getHagdfup());

                }

                if (antecedentes.getHagnnumgesta() != null) {
                    toma.setHvtngestac(antecedentes.getHagnnumgesta());

                }
                if (antecedentes.getHagnnumparto() != null) {
                    toma.setHvtnpartos(antecedentes.getHagnnumparto());
                    if (antecedentes.getHagnnumparto().equals(0)) {
                        esCeroPartos = true;
                    } else {
                        esCeroPartos = false;
                    }
                }

                if (antecedentes.getHagnnumaborto() != null) {
                    toma.setHvtnaborto(antecedentes.getHagnnumaborto());
                }

                if (antecedentes.getHagnedadrelac() != null) {
                    toma.setHvtnedarel(antecedentes.getHagnedadrelac());
                }
            } else {
                FacesUtils.addErrorMessage(MSG_NO_DATOS_CITOLOGIA);
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

    public void changeProcedimiento() {
        if (toma != null && toma.getHvtcpningu().equals("N")) {
            mostrarProcedimiento = true;

            mnuCauterizacion.setValue("N");
            mnuHistectomia.setValue("N");
            mnuConizacion.setValue("N");
            mnuRadioterapia.setValue("N");
            mnuBiopsia.setValue("N");
            mnuCrioterapia.setValue("N");
            mnuATA.setValue("N");
            mnuOtro.setValue("N");
            mnuColposcopia.setValue("N");
            mnuVaporizacion.setValue("N");
            mnuHormonal.setValue("N");

            toma.setHvtcpcaute("N");
            toma.setHvtcphiste("N");
            toma.setHvtcpconiz("N");
            toma.setHvtcpradio("N");
            toma.setHvtcpbiops("N");
            toma.setHvtcpcriot("N");
            toma.setHvtcpcolpo("N");
            toma.setHvtcpvapor("N");
            toma.setHvtcphormo("N");

        } else {
            toma.setHvtcpcaute(null);
            toma.setHvtdpcaute(null);
            toma.setHvtcphiste(null);
            toma.setHvtdphiste(null);
            toma.setHvtcpconiz(null);
            toma.setHvtdpconiz(null);
            toma.setHvtcpradio(null);
            toma.setHvtdpradio(null);
            toma.setHvtcpbiops(null);
            toma.setHvtdpbiops(null);
            toma.setHvtcpcriot(null);
            toma.setHvtdpcriot(null);
            toma.setHvtcpata(null);
            toma.setHvtdpata(null);
            toma.setHvtcpotro(null);
            toma.setHvtdpotro(null);
            toma.setHvtcpdotro(null);
            toma.setHvtcpcolpo(null);
            toma.setHvtdpcolpo(null);
            toma.setHvtcpvapor(null);
            toma.setHvtdpvapor(null);
            toma.setHvtcphormo(null);
            toma.setHvtdphormo(null);

            mnuCauterizacion.setValue(null);
            mnuHistectomia.setValue(null);
            mnuConizacion.setValue(null);
            mnuRadioterapia.setValue(null);
            mnuBiopsia.setValue(null);
            mnuCrioterapia.setValue(null);
            mnuATA.setValue(null);
            mnuOtro.setValue(null);
            mostrarFechaATA = false;
            mostrarFechaBiopsia = false;
            mostrarFechaCauterizacion = false;
            mostrarFechaConizacion = false;
            mostrarFechaCrioterapia = false;
            mostrarFechaHisterectomia = false;
            mostrarFechaOtro = false;
            mostrarFechaRadioterapia = false;
            mostrarProcedimiento = false;
            mostrarFechaColposcopia = false;
            mostrarFechaVaporizacion = false;
            mostrarFechaHormonal = false;
        }
    }

    public void changeCauterizacion() {
        if (toma != null && toma.getHvtcpcaute() != null
                && toma.getHvtcpcaute().equals("S")) {
            mostrarFechaCauterizacion = true;
        } else {
            mostrarFechaCauterizacion = false;
            toma.setHvtdpcaute(null);

        }
    }

    public void changeHisterectomia() {
        if (toma != null && toma.getHvtcphiste() != null
                && toma.getHvtcphiste().equals("S")) {
            mostrarFechaHisterectomia = true;
        } else {
            toma.setHvtdphiste(null);
            mostrarFechaHisterectomia = false;
        }
    }

    public void changeConizacion() {
        if (toma != null && toma.getHvtcpconiz() != null
                && toma.getHvtcpconiz().equals("S")) {
            mostrarFechaConizacion = true;
        } else {
            toma.setHvtdpconiz(null);
            mostrarFechaConizacion = false;
        }
    }

    public void changeBiopsia() {
        if (toma != null && toma.getHvtcpbiops() != null
                && toma.getHvtcpbiops().equals("S")) {
            mostrarFechaBiopsia = true;
        } else {
            toma.setHvtdpbiops(null);
            mostrarFechaBiopsia = false;
        }
    }

    public void changeCrioterapia() {
        if (toma != null && toma.getHvtcpcriot() != null
                && toma.getHvtcpcriot().equals("S")) {
            mostrarFechaCrioterapia = true;
        } else {
            toma.setHvtdpcriot(null);
            mostrarFechaCrioterapia = false;
        }
    }

    public void changeATA() {
        if (toma != null && toma.getHvtcpata() != null
                && toma.getHvtcpata().equals("S")) {
            mostrarFechaATA = true;
        } else {
            toma.setHvtdpata(null);
            mostrarFechaATA = false;
        }
    }

    public void changeColposcopia() {
        if (toma != null && toma.getHvtcpcolpo() != null
                && toma.getHvtcpcolpo().equals("S")) {
            mostrarFechaColposcopia = true;
        } else {
            toma.setHvtdpcolpo(null);
            mostrarFechaColposcopia = false;
        }
    }

    public void changeVaporizacion() {
        if (toma != null && toma.getHvtcpvapor() != null
                && toma.getHvtcpvapor().equals("S")) {
            mostrarFechaVaporizacion = true;
        } else {
            toma.setHvtdpvapor(null);
            mostrarFechaVaporizacion = false;
        }
    }

    public void changeHormonal() {
        if (toma != null && toma.getHvtcphormo() != null
                && toma.getHvtcphormo().equals("S")) {
            mostrarFechaHormonal = true;
        } else {
            toma.setHvtdphormo(null);
            mostrarFechaHormonal = false;
        }
    }

    public void changeOtroProcedimiento() {
        if (toma != null && toma.getHvtcpotro() != null
                && toma.getHvtcpotro().equals("S")) {
            mostrarFechaOtro = true;
        } else {
            toma.setHvtdpotro(null);
            toma.setHvtcpdotro(null);
            mostrarFechaOtro = false;
        }
    }

    public void changeRadioterapia() {
        if (toma != null && toma.getHvtcpradio() != null
                && toma.getHvtcpradio().equals("S")) {
            mostrarFechaRadioterapia = true;
        } else {
            toma.setHvtdpradio(null);
            mostrarFechaRadioterapia = false;
        }
    }

    public void ChangeFechaCitologia() {
        if (toma.getHvtdultcit() != null) {
            mostrarResultado = true;
        } else {
            toma.setHvtcultres(null);
            mostrarResultado = false;
            mostrarhallazgos = false;
            mnuResultado.setValue(null);
            toma.setHvtcotrhal(null);
        }
    }

    public void ChangeFechaTipificacion() {
        if (toma.getHvtdtipifi() != null) {
            mostrarVphResultado = true;
        } else {
            mostrarVphResultado = false;
        }
    }

    public void changeResultado() {
        if (toma.getHvtcultres() != null
                && toma.getHvtcultres().equals("2.2")) {
            mostrarhallazgos = true;
        } else {
            mostrarhallazgos = false;
            toma.setHvtcotrhal(null);
        }
    }

    public void changeMetodo() {
        if (toma.getHvtcmetpla() != null
                && toma.getHvtcmetpla().equals("1.7")) {
            mostrarotrometodo = true;
        } else {
            mostrarotrometodo = false;
        }

        if (toma.getHvtcmetpla() != null
                && toma.getHvtcmetpla().equals("1.1")) {
            renderTiempoUso = false;
            toma.setHvtntiemet(null);
        } else {
            renderTiempoUso = true;
        }
    }

    /**
     * @return
     */
    public String volverConsulta() {
        generoVph = false;
        FacesUtils.resetManagedBean("listaCitologiasBean");
        FacesUtils.resetManagedBean("datosUsuarioCitologiaBean");
        FacesUtils.resetManagedBean("tomaCitologiaBean");
        return BeanNavegacion.RUTA_LISTA_CITOLOGIAS_PROGRAMADAS;
    }

    public void changeVph() {
        if (toma != null && toma.getHvtcvph() != null
                && toma.getHvtcvph().equals("S")) {
            mostrarvph = true;
        } else {
            mostrarvph = false;
        }
    }

    public void setHvtcvph(ValueChangeEvent valueChangeEvent) {
        toma.setHvtcvph((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
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
        obtenerDatosReporte();
        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("APELLIDOS")) {
            value = APELLIDOS;
        } else if (fieldName.equals("NOMBRES")) {
            value = NOMBRES;
        } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = NUMERO_DOCUMENTO;
        } else if (fieldName.equals("TIPO_DOCUMENTO")) {
            value = TIPO_DOCUMENTO;
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
        } else if (fieldName.equals("FECHA_REGLA")) {
            value = FECHA_REGLA;
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
        } else if (fieldName.equals("FECHA_PARTO")) {
            value = FECHA_PARTO;
        } else if (fieldName.equals("EDAD_RELACIONES")) {
            value = EDAD_RELACIONES;
        } else if (fieldName.equals("METODO_PLANIFICACION")) {
            value = METODO_PLANIFICACION;
        } else if (fieldName.equals("FECHA_CITOLOGIA")) {
            value = FECHA_CITOLOGIA;
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
        } else if (fieldName.equals("TOMADA")) {
            value = TOMADA;
        } else if (fieldName.equals("FECHA_TOMADA")) {
            value = FECHA_TOMADA;
        } else if (fieldName.equals("NOMBRE_TOMADA")) {
            value = NOMBRE_TOMADA;
        } else if (fieldName.equals("NUMERO_TIPIFICACION")) {
            value = NUMERO_TIPIFICACION;
        } else if (fieldName.equals("FECHA_VPH")) {
            value = FECHA_VPH;
        } else if (fieldName.equals("DOSIS_VPH")) {
            value = DOSIS_VPH;
        } else if (fieldName.equals("VPH")) {
            value = VPH;
        } else if (fieldName.equals("OBSERVACIONES_TOMA")) {
            value = OBSERVACIONES_TOMA;
        } else if (fieldName.equals("OTRO_METODO")) {
            value = OTRO_METODO;
        } else if (fieldName.equals("ES_SANO")) {
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
        } else if (fieldName.equals("ES_LESION_VISIBLE")) {
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
        } else if (fieldName.equals("PLANEA_EMABARAZO_ANTES_1ANHO") && (PLANEA_EMABARAZO_ANTES_1ANHO != null)) {
            value = PLANEA_EMABARAZO_ANTES_1ANHO.equals("N") ? "No" : (PLANEA_EMABARAZO_ANTES_1ANHO.equals("S") ? "Si" : PLANEA_EMABARAZO_ANTES_1ANHO);
        } else if (fieldName.equals("COLPOSCOPIA")) {
            value = COLPOSCOPIA;
        } else if (fieldName.equals("FECHA_COLPOSCOPIA")) {
            value = FECHA_COLPOSCOPIA;
        } else if (fieldName.equals("FECHA_TIPIFICACION")) {
            value = FECHA_TIPIFICACION;
        } else if (fieldName.equals("IDENTIDAD_GENERO")) {
            value = IDENTIDAD_GENERO;
        } else if (fieldName.equals("VULNERABILIDAD")) {
            value = VULNERABILIDAD;
        } else if (fieldName.equals("ESQUEMA_VPH")) {
            value = ESQUEMA_VPH;
        } else if (fieldName.equals("ESQUEMA_VPH_CUAL_OTRO")) {
            value = ESQUEMA_VPH_CUAL_OTRO;
        } else if (fieldName.equals("GENOTIPIFICACION_NEG")) {
            value = GENOTIPIFICACION_NEG;
        } else if (fieldName.equals("GENOTIPIFICACION")) {
            value = GENOTIPIFICACION;
        } else if (fieldName.equals("TARJETA_PROFESIONAL_TOMA")) {
            value = TARJETA_PROFESIONAL_TOMA;
        } else if (fieldName.equals("TARJETA_PROFESIONAL_LECTURA")) {
            value = TARJETA_PROFESIONAL_LECTURA;
        }
        return value;
    }

    public void obtenerDatosReporte() {

        if (tipivph != null) {

            if (tipivph.getHdvnnumdoc() != null) {
                NUMERO_FAC = tipivph.getHdvnnumdoc().toString();

                if (NUMERO_FAC != null && NUMERO_FAC.length() > 6) {
                    NUMERO_FAC
                            = NUMERO_FAC.substring(NUMERO_FAC.length() - 6, NUMERO_FAC.length());
                }

            }

            if (tipivph.getHdvnconsec() != null) {
                NUMERO_TIPIFICACION = tipivph.getHdvnconsec();
            }
            if (tipivph.getHdvcprinom() != null) {
                NOMBRES = tipivph.getHdvcprinom() + " ";
            }
            if (tipivph.getHdvcsegnom() != null
                    && !tipivph.getHdvcsegnom().equals("_")) {
                NOMBRES = NOMBRES + tipivph.getHdvcsegnom();
            }
            if (tipivph.getHdvcpriape() != null) {
                APELLIDOS = tipivph.getHdvcpriape() + " ";
            }
            if (tipivph.getHdvcsegape() != null
                    && !tipivph.getHdvcsegape().equals("_")) {
                APELLIDOS = APELLIDOS + tipivph.getHdvcsegape();
            }
            if (tipivph.getHdvctipide() != null) {
                TIPO_DOCUMENTO = tipivph.getHdvctipide();
            }
            if (tipivph.getHdvanumide() != 0) {
                NUMERO_DOCUMENTO = tipivph.getHdvanumide();
            }
            if (tipivph.getHdvcdirecc() != null) {
                DIRECCION = tipivph.getHdvcdirecc();
            }
            if (tipivph.getHdvctelefo() != null) {
                TELEFONO = tipivph.getHdvctelefo();
            }
            Integer idCiudad = null;
            Integer idDepartamento = null;
            Cpmunidane ciudadObject = null;
            if (tipivph.getHdvnmunici() != null
                    && tipivph.getHdvndepart() != null) {
                idCiudad = tipivph.getHdvnmunici();
                idDepartamento = tipivph.getHdvndepart();
            }

            try {
                ciudadObject
                        = this.serviceLocator.getClinicoService().getMunicipio(idCiudad,
                                idDepartamento);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (ciudadObject != null) {
                CIUDAD = ciudadObject.getCmdcnommun();
                DEPARTAMENTO = ciudadObject.getCmdcnomdpt();
            }

            if (tipivph.getHdvcotrdir() != null) {
                OTRA_DIRECCION = tipivph.getHdvcotrdir();
            }
            if (tipivph.getHdvcotrtel() != null) {
                OTRO_TELEFONO = tipivph.getHdvcotrtel();
            }

            Integer idOtraCiudad = null;
            Integer idOtroDepartamento = null;
            Cpmunidane ciudadOtraObject = null;
            if (tipivph.getHdvnotrmun() != null
                    && tipivph.getHdvnotrdep() != null) {
                idOtraCiudad = tipivph.getHdvnotrmun();
                idOtroDepartamento = tipivph.getHdvnotrdep();
            }
            if (tipivph.getHdvnedad() != null) {
                EDAD = tipivph.getHdvnedad();
            }

            try {
                ciudadOtraObject
                        = this.serviceLocator.getClinicoService().getMunicipio(idOtraCiudad,
                                idOtroDepartamento);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (ciudadOtraObject != null) {
                OTRA_CIUDAD = ciudadOtraObject.getCmdcnommun();
                OTRO_DEPARTAMENTO = ciudadOtraObject.getCmdcnomdpt();
            }

            if (tipivph.getHdvctipafi() != null) {
                if (tipivph.getHdvctipafi().equals("C")) {
                    TIPO_AFILIACION = "CONTRIBUTIVO";
                }
                if (tipivph.getHdvctipafi().equals("E")) {
                    TIPO_AFILIACION = "ESPECIAL";
                }
                if (tipivph.getHdvctipafi().equals("R")) {
                    TIPO_AFILIACION = "SUBSIDIO PARCIAL";
                }
                if (tipivph.getHdvctipafi().equals("S")) {
                    TIPO_AFILIACION = "SUBSIDIADO";
                }
                if (tipivph.getHdvctipafi().equals("V")) {
                    TIPO_AFILIACION = "VINCULADO";
                }
                if (tipivph.getHdvctipafi().equals("X")) {
                    TIPO_AFILIACION = "NINGUNO";
                }

            }

            if (tipivph.getHdvcasegur() != null) {
                Cpentidadadm aseguradora;
                aseguradora = null;

                try {
                    aseguradora
                            = serviceLocator.getClinicoService().getAseguradoraPorCodigo(tipivph.getHdvcasegur());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (aseguradora != null) {
                    ASEGURADORA = aseguradora.getCeacnombre();
                }

            }

        }

        if (toma != null) {

            if (toma.getHvtcotrmet() != null) {
                OTRO_METODO = toma.getHvtcotrmet();
            }

            if (toma.getHvtcobstom() != null) {
                OBSERVACIONES_TOMA = toma.getHvtcobstom();
            }
            if (toma.getHvtdultmen() != null) {
                FECHA_REGLA = toma.getHvtdultmen();
            }

            if (toma.getHvtcvph() != null) {
                if (toma.getHvtcvph().equals("S")) {
                    VPH = "Si";
                }
                if (toma.getHvtcvph().equals("N")) {
                    VPH = "No";
                }
            }

            if (toma.getHvtdvph() != null) {
                FECHA_VPH = toma.getHvtdvph();
            }

            if (toma.getHvtnvph() != null) {
                DOSIS_VPH = toma.getHvtnvph();
            }

            if (toma.getHvtdultpar() != null) {
                FECHA_PARTO = toma.getHvtdultpar();
            }

            if (toma.getHvtnedarel() != null) {
                EDAD_RELACIONES = toma.getHvtnedarel();
            }

            if (toma.getHvtcembara() != null) {
                Cndesccito embarazades;
                embarazades = null;
                try {
                    embarazades
                            = serviceLocator.getClinicoService().getDescripcionesCitologia("cncitotoma",
                                    "ctmcembara",
                                    toma.getHvtcembara());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (embarazades != null) {
                    ESTA_EMBARAZADA = embarazades.getCdicdescri();
                }

            }

            if (toma.getHvtngestac() != null) {
                GESTACIONES = toma.getHvtngestac();
            }

            if (toma.getHvtnpartos() != null) {
                PARTOS = toma.getHvtnpartos();
            }
            if (toma.getHvtnaborto() != null) {
                ABORTOS = toma.getHvtnaborto();
            }

            if (toma.getHvtcmetpla() != null) {
                METODO_PLANIFICACION = toma.getHvtcmetpla();
            }

            if (toma.getHvtcultres() != null) {
                RESULTADO_CITOLOGIA = toma.getHvtcultres();
            }

            if (toma.getHvtcplaemb() != null) {
                PLANEA_EMABARAZO_ANTES_1ANHO = toma.getHvtcplaemb();
            }

            if (toma.getHvtdtipifi() != null) {
                FECHA_TIPIFICACION = toma.getHvtdtipifi();
            }

            if (tipivph.getHdvcidengen() != null) {
                IDENTIDAD_GENERO = tipivph.getHdvcidengen();
            }

            if (tipivph.getHdvcvulnera() != null) {
                VULNERABILIDAD = tipivph.getHdvcvulnera();
            }

            if (toma.getHvtcesquem() != null) {
                ESQUEMA_VPH = toma.getHvtcesquem();
            }

            if (toma.getHvtcotroesq() != null) {
                ESQUEMA_VPH_CUAL_OTRO = toma.getHvtcotroesq();
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
                    idAspecto = (String) it.next();

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

            }

            if (toma.getHvtdultcit() != null) {
                FECHA_CITOLOGIA = toma.getHvtdultcit();
            }
            if (toma.getHvtcpningu() != null) {
                NINGUNO = toma.getHvtcpningu();
            }
            if (toma.getHvtdpcaute() != null) {
                FECHA_CAUTERIZACION = toma.getHvtdpcaute();
            }
            if (toma.getHvtdphiste() != null) {
                FECHA_HISTERECTOMIA = toma.getHvtdphiste();
            }
            if (toma.getHvtdpconiz() != null) {
                FECHA_CONIZACION = toma.getHvtdpconiz();
            }
            if (toma.getHvtdpradio() != null) {
                FECHA_RADIOTERAPIA = toma.getHvtdpradio();
            }
            if (toma.getHvtdpbiops() != null) {
                FECHA_BIOPSA = toma.getHvtdpbiops();
            }
            if (toma.getHvtdpcriot() != null) {
                FECHA_CRIOTERAPIA = toma.getHvtdpcriot();
            }
            if (toma.getHvtdpata() != null) {
                FECHA_ATA = toma.getHvtdpata();
            }
            if (toma.getHvtdpcolpo() != null) {
                FECHA_COLPOSCOPIA = toma.getHvtdpcolpo();
            }
            if (toma.getHvtdpvapor() != null) {
                FECHA_VAPORIZACION = toma.getHvtdpvapor();
            }
            if (toma.getHvtdphormo() != null) {
                FECHA_HORMONAL = toma.getHvtdphormo();
            }
            if (toma.getHvtdpotro() != null) {
                FECHA_OTRO = toma.getHvtdpotro();
            }
            if (toma.getHvtcpcaute() != null) {
                CAUTERIZACION = toma.getHvtcpcaute();
            }
            if (toma.getHvtcphiste() != null) {
                HISTERECTOMIA = toma.getHvtcphiste();
            }
            if (toma.getHvtcpconiz() != null) {
                CONIZACION = toma.getHvtcpconiz();
            }
            if (toma.getHvtcpradio() != null) {
                RADIOTERAPIA = toma.getHvtcpradio();
            }
            if (toma.getHvtcpbiops() != null) {
                BIOPSIA = toma.getHvtcpbiops();
            }
            if (toma.getHvtcpcriot() != null) {
                CRIOTERAPIA = toma.getHvtcpcriot();
            }
            if (toma.getHvtcpata() != null) {
                ATA = toma.getHvtcpata();
            }
            if (toma.getHvtcpcolpo() != null) {
                COLPOSCOPIA = toma.getHvtcpcolpo();
            }
            if (toma.getHvtcpvapor() != null) {
                VAPORIZACION = toma.getHvtcpvapor();
            }
            if (toma.getHvtcphormo() != null) {
                HORMONAL = toma.getHvtcphormo();
            }
            if (toma.getHvtcpotro() != null) {
                OTRO = toma.getHvtcpotro();
            }
            if (toma.getHvtcpdotro() != null) {
                OTRO_CUAL = toma.getHvtcpdotro();
            }
            if (toma.getHvtntiemet() != null) {
                TIEMPO_METODO = toma.getHvtntiemet();
            }
            if (toma.getHvtccomvph() != null) {
                COMPLETO_VPH = formatearCampo(toma.getHvtccomvph());
            }
            if (toma.getHvtclactan() != null) {
                LACTANCIA_ACTUAL = formatearCampo(toma.getHvtclactan());
            }
            if (toma.getHvtctomada() != null) {
                TOMADA = toma.getHvtctomada();
            }
            if (toma.getHvtdfecreg() != null) {
                FECHA_TOMADA = toma.getHvtdfecreg();
            }
            if (toma.getHvtcnomtom() != null) {
                NOMBRE_TOMADA = toma.getHvtcnomtom();
            }

            if (getClinica() != null) {
                CENTRO = getClinica().getCclcnombre();
            }

            if (userName() != null) {
                Cpprofesio profesional;
                profesional = null;
                try {
                    if (this.getClinica() != null) {
                        profesional = serviceLocator.getClinicoService().getProfesionalPorUsuario(userName(),
                                getClinica().getCclncodigo());
                    }

                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (profesional != null) {
                    TARJETA_PROFESIONAL_TOMA = profesional.getCpfcregmedic();
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
        GESTACIONES = null;
        PARTOS = null;
        ABORTOS = null;
        TIPO_AFILIACION = "";
        ASEGURADORA = "";
        FECHA_PARTO = null;
        EDAD_RELACIONES = null;
        METODO_PLANIFICACION = "";
        FECHA_CITOLOGIA = null;
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
        TOMADA = "";
        FECHA_TOMADA = null;
        NOMBRE_TOMADA = "";
        NUMERO_TIPIFICACION = null;
        FECHA_VPH = null;
        VPH = "";
        DOSIS_VPH = null;
        OBSERVACIONES_TOMA = null;
        NUMERO_FAC = null;
        VAPORIZACION = "";
        FECHA_VAPORIZACION = null;
        HORMONAL = "";
        FECHA_HORMONAL = null;
        TIEMPO_METODO = null;
        COMPLETO_VPH = null;
        LACTANCIA_ACTUAL = null;

        COLPOSCOPIA = "";
        FECHA_COLPOSCOPIA = null;
        PLANEA_EMABARAZO_ANTES_1ANHO = null;
        FECHA_TIPIFICACION = null;
        IDENTIDAD_GENERO = "";
        VULNERABILIDAD = "";
        ESQUEMA_VPH = "";
        ESQUEMA_VPH_CUAL_OTRO = "";
        GENOTIPIFICACION_NEG = "";
        GENOTIPIFICACION = "";
        TARJETA_PROFESIONAL_TOMA = "";
        TARJETA_PROFESIONAL_LECTURA = "";

    }

    public String generarPDF() {
        if (!temporal) {
            try {
                index = -1;
                URL url = null;
                URL url_profamilia = null;
                if (esPolicia) {
                    url
                            = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/tomaCitologiaPolicia.jasper");
                    url_profamilia
                            = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_POLICIA);
                } else {
                    url
                            = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteTipificacionVPH FO_GS_AD-020.jasper");

                    url_profamilia
                            = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_PRINCIPAL);
                }

                URL url_super_horizontal
                        = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
                URL url_super_vertical
                        = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
                if (url != null) {
                    Map parameters = new HashMap();
                    parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                    parameters.put("IMAGE_SUPER_HORIZONTAL",
                            url_super_horizontal);
                    parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                    byte[] bytes;

                    JasperReport report
                            = (JasperReport) JRLoader.loadObject(url);

                    bytes
                            = JasperRunManager.runReportToPdf(report, parameters, (JRDataSource) this);
                    PdfServletUtils.showPdfDocument(bytes,
                            "tomaCitologia" + Calendar.getInstance().getTimeInMillis()
                            + ".pdf", false);
                    generoVph = true;
                    modoConsulta = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte "
                        + e.getMessage());
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
                aspectoCuello
                        = aspectoCuello.substring(1, aspectoCuello.length());
            }
        }

        if (toma != null) {
            if (toma.getHvtngestac() != null
                    && toma.getHvtngestac().equals(0)) {
                toma.setHvtnaborto(0);
                toma.setHvtnpartos(0);
            }

            if (userName() != null) {
                Cpprofesio profesional;
                profesional = null;
                try {
                    if (this.getClinica() != null) {
                        profesional = serviceLocator.getClinicoService().getProfesionalPorUsuario(userName(),
                                getClinica().getCclncodigo());
                    }

                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (profesional != null && profesional.getCpfntippro() != null) {
                    int tipoProf = profesional.getCpfntippro();
                    switch (tipoProf) {//Codigos seg�n Cptipoespe
                        case 1: //MEDICO GENERAL
                        case 2: //ESPECIALISTA GINECOLOGO
                        case 3: //ESPECIALISTA UROLOGO
                            toma.setHvtctomada("11.1");
                            break;
                        case 5: //ENFERMERA
                            toma.setHvtctomada("11.2");
                            break;
                        case 13: //AUXILIAR
                            toma.setHvtctomada("11.3");
                            break;
                    }
                }
                if (toma.getHvtctomada() == null) {
                    toma.setHvtctomada("11.2");
                    //wexito = false;
                    FacesUtils.addErrorMessage("El tipo de profesional no es permitido realizar toma, se asume profesional de enfermer�a");
                }
            }

            if (toma.getHvtcpningu() != null
                    && toma.getHvtcpningu().equals("N")) {

                if ((toma.getHvtcpcaute() == null
                        || toma.getHvtcpcaute().equals("N"))
                        && (toma.getHvtcphiste() == null
                        || toma.getHvtcphiste().equals("N"))
                        && (toma.getHvtcpconiz() == null
                        || toma.getHvtcpconiz().equals("N"))
                        && (toma.getHvtcpradio() == null
                        || toma.getHvtcpradio().equals("N"))
                        && (toma.getHvtcpbiops() == null
                        || toma.getHvtcpbiops().equals("N"))
                        && (toma.getHvtcpcriot() == null
                        || toma.getHvtcpcriot().equals("N"))
                        && (toma.getHvtcpata() == null
                        || toma.getHvtcpata().equals("N"))
                        && (toma.getHvtcpvapor() == null
                        || toma.getHvtcpvapor().equals("N"))
                        && (toma.getHvtcphormo() == null
                        || toma.getHvtcphormo().equals("N"))
                        && (toma.getHvtcpotro() == null
                        || toma.getHvtcpotro().equals("N"))) {

                    wexito = false;

                }

            }

        }

        generoVph = false;
        clearReporte();
        modoConsulta = false;
        if (tipivph != null) {
            toma.setHvtnconsec(tipivph.getHdvnconsec());
            toma.setHvtnnumero(tipivph.getHdvnnumero());
        }

        toma.setHvtnclinic(this.getClinica().getCclncodigo());
        toma.setHvtdfectom(new Date());
        toma.setHvtdfecreg(new Date());
        toma.setHvtcnomtom(getUsuarioSystem().getCurcnombre());
        toma.setHvtcusureg(userName());
        toma.setHvtcaspcue(aspectoCuello);
        if (temporal) {
            toma.setHvtcaspcue("NA");
        }

        if (wexito) {
            try {
                if (consulta != null) {

                    this.getServiceLocator().getClinicoService().closeTomaVph(toma,
                            consulta,
                            userName(),
                            temporal);
                    modoConsulta = true;

                    FacesUtils.addInfoMessage(IMsg.MSG_ADICION);

                }
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + ": "
                        + e.getMessage());
                e.printStackTrace();

            } catch (Exception e1) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + ": "
                        + e1.getMessage());
                e1.printStackTrace();

            }
        } else {
            FacesUtils.addErrorMessage(MSG_SELECCIONE_PROCEDIMIENTO_CUELLO_UTERINO);
        }

    }

    public boolean isMostrarFechaColposcopia() {
        return mostrarFechaColposcopia;
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

    public UIInput getMnuColposcopia() {
        return mnuColposcopia;
    }

    public void setMnuColposcopia(UIInput mnuColposcopia) {
        this.mnuColposcopia = mnuColposcopia;
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

        if (lstTipoUsuario == null || lstTipoUsuario.isEmpty()) {
            lstTipoUsuario = new ArrayList();

            lstTipoUsuario.add(new SelectItem("", ""));
            lstTipoUsuario.add(new SelectItem("AC", "Activo"));
            lstTipoUsuario.add(new SelectItem("BE", "Beneficiario"));
            lstTipoUsuario.add(new SelectItem("PE", "Pensionado"));

        }

        return lstTipoUsuario;
    }
}
