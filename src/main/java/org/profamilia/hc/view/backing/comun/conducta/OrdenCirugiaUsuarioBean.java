//=======================================================================
// ARCHIVO OrdenCirugiaBean.java
// FECHA CREACI�N: 
// AUTOR: jariano, nlis
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.comun.conducta;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//====================================================================
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
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Cfadmision;
import org.profamilia.hc.model.dto.Cfdetaadmision;
import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.model.dto.CfdetafacturaPK;
import org.profamilia.hc.model.dto.Chconfiservi;
import org.profamilia.hc.model.dto.Chordecirugi;
import org.profamilia.hc.model.dto.ChordecirugiPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptipodocu;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.clinico.comun.BuscadorCirugiasBean;
import org.profamilia.hc.view.backing.comun.ConfirmarServicioBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

//==============================================================================
//  CLASE OrdenCirugiaBean
//==============================================================================

public class OrdenCirugiaUsuarioBean extends BaseBean implements JRDataSource {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    private boolean modoconsulta;

    private boolean generoOrden;

    /**Almacena la lista de los posibles minutos que se puede demorar la cirugia */
    private List lstDuracion;

    /** Almacena la lista de los tipos de anestesia  */
    private List lstTipoAnestesia;

    /** Almacena la lista de opciones 'SI' o 'NO' */
    private List lstOpciones;

    /** Almacena el tipo de estancia */
    private List lstEstancia;

    private List lstPatologia;

    private List lstLugar;

    private String tienePatologia;

    /** Almacena la cirugias que se desean buscar */
    private Cpservicio servicio;

    private int index = -1;

    private static int NUMERO_ORDENES = 1;

    /** Almacena true si el usuario tiene patologia */
    private boolean mostrarpatologia;

    /** Almacena true si el usuario selecciono otra patologia */
    private boolean otraPatologia;

    /** Almacena true si el usuario selecciono biopsa por congelaci�n */
    private boolean biopsaCongelacion;

    /** Almacena true si el tipo de estancia es hospitalaria*/
    private boolean esHospitalaria;

    /** Almacena true si necesita reserva de sangre  */
    private boolean necesitaReserva;

    private boolean renderDiu;

    private boolean renderVasectomia;

    /** Almacena la orden de la cirugia que se va a persistir*/
    private Chordecirugi orden;

    /** Almacena lel tiempo de aproximado de la cirugia*/
    private String tiempoSelect;


    private List<Cpservicio> lstExamenesCirugias;

    private HtmlDataTable dtServicios;

    BuscadorCirugiasBean buscadorCirugias;

    private boolean mostrarCirugias;

    private int selectedIndex;

    private boolean mostrarLugar;

    private boolean mostrarProgramacion;

    private UIInput mnuAcepta;

    private UIInput mnuTiempo;

    private UIInput mnuLugar;


    private UIInput mnuAnestesia;

    private UIInput mnuAyudantia;

    private UIInput mnuEstancia;

    private UIInput inputDias;

    private UIInput mnuReserva;

    private UIInput inputUnidades;

    private UIInput mnuPatologia;

    private UIInput mnuAnestesiologo;

    private UIInput inputCongelacion;

    private UIInput inputCualOtro;

    private UIInput mnuTienePatologia;

    private boolean esValoracionPreanestesica;


    static final int ACTIVAR_ORDEN_CIRUGIA = 0;
    static final int ACTIVAR_BUSCADOR_CIRUGIAS = 1;

    private boolean esCirugia;

    private boolean esLigadura;


    private List lstPreferenciaAnestesia;

    private boolean mostrarRazones;

    private boolean mostrarAcepta;

    private Long numeroUsuario;

    private String tipoServicio;

    private Integer consecutivo;

    private Integer tipoHistoria;


    /** Almacena el consulta */
    private Long numeroConsulta;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private String menuBean;

    private List listViasAcceso;

    String DIA;
    String MES;
    String ANO;
    String HORA_SISTEMA;
    String INTERVENCION;
    Integer TIEMPO_CIRUGIA;
    String ANESTESIA_SOLICITADA;
    String ESTANCIA;
    String DIAS;
    Integer DIAS_ESTANCIA;
    String AYUDANTIA;
    String RESERVA_SANGRE;
    Integer NUMERO_UNIDADES;
    String PATOLOGIA;
    String NOMBRES_PACIENTE;
    String NOMBRE_CIRUJANO;
    Integer EDAD;
    String PROGRAMAR;
    Long NUMERO_DOCUMENTO;
    String NOMBRE_PROFESIONAL;
    String TIPOID_PROFESIONAL;
    BigDecimal NUMID_PROFESIONAL;
    String REGISTRO_MEDICO;
    String ESPECIALIDAD = null;
    String PATOLOGIA_CONGELA;
    String PATOLOGIA_OTRO;
    String VIA_ACCESO;
    String PARTICULAR;
    String TIPO_USUARIO;
    String HEMOCOMPONENTE;
    String OBSERVACION;
    String INTERVENCION1;
    String INTERVENCION2;
    String INTERVENCION3;
    Date HORA_SISTEMA_DATE;


    private Long numeroAdmision;
    private List<Cfdetafactura> cfdetafacturaList;
    private HtmlDataTable tableServiciosAdmision;
    private Cfdetafactura cfdetafactura;
    private List<Object[]> resultList;
    private Cfadmision admision;
    private Cnconsclin consulta;
    private Long consecutivoFactura;
    private InterConsultaUsuarioBean interConsultaUsuarioBean;
    // CAMPOS AGREGADOS POR CJET
    private List<SelectItem> lsthemocomponentes;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public OrdenCirugiaUsuarioBean() {
    }

    public void init() {
        lstExamenesCirugias = new ArrayList<Cpservicio>();
        servicio = new Cpservicio();
        modoconsulta = false;
        esLigadura = false;
        numeroAdmision = null;
        cfdetafactura = new Cfdetafactura();
        cfdetafacturaList = new ArrayList();
        resultList = new ArrayList();
        tableServiciosAdmision = new HtmlDataTable();
        admision = new Cfadmision();
        consecutivoFactura = null;
        inicializarOrdenCirugia();
    }


    public void inicializarOrdenCirugia() {
        generoOrden = false;
        try {

            orden = 
                    serviceLocator.getClinicoService().getOrdenCirugia(numeroConsulta, 
                                                                       tipoServicio, 
                                                                       consecutivo);

        } catch (ModelException e) {
            e.printStackTrace();
        }


        if (orden == null) {
            orden = new Chordecirugi();
            modoconsulta = false;
            if (esLigadura) {

                Cpservicio servaux = new Cpservicio();
                try {
                    servaux = 
                            serviceLocator.getClinicoService().getServicioPorId("S662200.0");
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (servaux != null) {
                    lstExamenesCirugias.add(servaux);
                }
                orden.setHoccobservacio("OBSERVACIONES");
                orden.setHoccpaciacepta("S");
                mostrarLugar = true;
                orden.setHocclugarinter("S");
                mostrarProgramacion = true;
                orden.setHocntiempointe(10);
                tiempoSelect = String.valueOf(orden.getHocntiempointe());
                orden.setHocctipoaneste("2");
                orden.setHoceayudantia("N");
                orden.setHocctipoestanc("A");
                orden.setHoceresesangre("N");
                orden.setHocctipopatolo("");
                tienePatologia = "N";
                orden.setHoccprogramar("S");

            }
        } else {

            if (orden.getHocctipopatolo() != null && 
                !orden.getHocctipopatolo().equals("")) {
                tienePatologia = "S";
                mostrarpatologia = true;
            } else {
                mostrarpatologia = false;
                tienePatologia = "N";
            }

            if (orden.getHoccprogrcirug() != null && 
                orden.getHoccprogrcirug().equals("N")) {
                mostrarRazones = true;

            } else if (orden.getHoccprogrcirug() != null && 
                       orden.getHoccprogrcirug().equals("S")) {
                mostrarLugar = true;
            }


            if (orden.getHocdfecprocir1() != null) {
                Calendar fechaaux1 = Calendar.getInstance();
                fechaaux1.setTime(orden.getHocdfecprocir1());
                Integer hora1;
                Integer minuto1;
                hora1 = (fechaaux1.get(Calendar.HOUR_OF_DAY));
                minuto1 = (fechaaux1.get(Calendar.MINUTE));

            }

            if (orden.getHoccpaciacepta() != null && 
                orden.getHoccpaciacepta().equals("S")) {
                mostrarLugar = true;
            } else {
                mostrarLugar = false;

            }

            if (orden.getHocclugarinter() != null && 
                (orden.getHocclugarinter().equals("S") || 
                 orden.getHocclugarinter().equals("P"))) {
                mostrarProgramacion = true;
            } else {
                mostrarProgramacion = false;
            }

            if (orden.getHocntiempointe() != null) {
                tiempoSelect = String.valueOf(orden.getHocntiempointe());
            }

            if (orden.getHocdfecprocir2() != null) {
                Calendar fechaaux2 = Calendar.getInstance();
                Integer hora2;
                Integer minuto2;
                fechaaux2.setTime(orden.getHocdfecprocir2());
                hora2 = (fechaaux2.get(Calendar.HOUR_OF_DAY));
                minuto2 = (fechaaux2.get(Calendar.MINUTE));

            }

            if (orden.getHocctipoestanc() != null && 
                orden.getHocctipoestanc().equals("H")) {
                esHospitalaria = true;
            } else {
                esHospitalaria = false;
            }

            if (orden.getHoceresesangre() != null && 
                orden.getHoceresesangre().equals("S")) {
                necesitaReserva = true;
            } else {
                necesitaReserva = false;
            }
            if (orden.getHocctipopatolo() != null) {
                if (orden.getHocctipopatolo().equals("BC")) {
                    biopsaCongelacion = true;
                } else {
                    biopsaCongelacion = false;
                }
                if (orden.getHocctipopatolo().equals("OT")) {
                    otraPatologia = true;
                } else {
                    otraPatologia = false;
                }
            }

            if (orden.getHoccintervenci() != null) {
                StringTokenizer st = 
                    new StringTokenizer(orden.getHoccintervenci(), ",");
                Cpservicio servicioAux = null;
                while (st.hasMoreTokens()) {
                    String idservicio = st.nextToken();

                    try {
                        servicioAux = 
                                this.serviceLocator.getClinicoService().getServicioPorId(idservicio);
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    if (servicioAux != null) {
                        lstExamenesCirugias.add(servicioAux);
                    }
                }


                modoconsulta = true;
            }


            if (lstExamenesCirugias != null && 
                !lstExamenesCirugias.isEmpty()) {
                for (Cpservicio servicio: lstExamenesCirugias) {
                    String codigoServicio = servicio.getCsvccodigo();
                    if (codigoServicio != null && 
                        lstExamenesCirugias.size() == 1) {
                        if (codigoServicio.equals("637300")) {
                            renderVasectomia = true;
                        }
                        StringTokenizer st = 
                            new StringTokenizer(codigoServicio, ".");
                        codigoServicio = st.nextToken();
                        if (codigoServicio != null && 
                            codigoServicio.equals("662200")) {
                            renderDiu = true;
                        }
                    }
                }

            }
        }


        //busquedaDetalleFactura();
    }

    private void busquedaDetalleFactura() {

        try {
            if (numeroAdmision != null) {
                resultList = 
                        getServiceLocator().getClinicoService().getListaServiciosXAdmision(numeroAdmision, 
                                                                                           IConstantes.OPCIONCIRUGIAYPROCEDIMIENTO);

                if (resultList != null && !resultList.isEmpty()) {
                    cfdetafacturaList = new ArrayList<Cfdetafactura>();

                    for (Object[] objeto: resultList) {

                        if (objeto[17] == null) {
                            cfdetafactura.setComp_id(new CfdetafacturaPK(validarLong(objeto[0]), 
                                                                         validarLong(objeto[1])));
                            consecutivoFactura = 
                                    cfdetafactura.getComp_id().getCdfnconsfact();
                            cfdetafactura.setCdfcservicio(validarString(objeto[2]));
                            cfdetafactura.setCdfnorden(validarLong(objeto[3]));
                            cfdetafactura.setCdfcobserv(validarString(objeto[4]));
                            cfdetafactura.setCdfclote(validarString(objeto[5]));
                            cfdetafactura.setCdfndescuento(validarDouble(objeto[6]));
                            cfdetafactura.setCdfniva(validarDouble(objeto[7]));
                            cfdetafactura.setCdfncliente(validarLong(objeto[8]));
                            cfdetafactura.setCdfnestado(validarString(objeto[9]));
                            cfdetafactura.setCdfcpaquet(validarString(objeto[10]));
                            cfdetafactura.setCdfctipdscto(validarString(objeto[11]));
                            cfdetafactura.setCdfnvalsrv(validarDouble(objeto[12]));
                            cfdetafactura.setCdfncantidad(validarLong(objeto[13]));
                            cfdetafactura.setCdfcetapa(validarString(objeto[14]));
                            cfdetafactura.setCdfcusuamodi(validarString(objeto[15]));
                            cfdetafactura.setCdfdfechmodi((Date)(objeto[16]));
                            cfdetafactura.setCdfnconsuclin(validarLong(objeto[17]));
                            cfdetafactura.setCdfcswitpaq(validarString(objeto[18]));
                            cfdetafactura.setNombreServicio(validarString(objeto[19]));
                            if (cfdetafactura.getCdfnconsuclin() != null) {
                                cfdetafactura.setValidacionConsultaClinica(true);
                            } else {
                                cfdetafactura.setValidacionConsultaClinica(false);
                            }
                            cfdetafacturaList.add(cfdetafactura);
                            cfdetafactura = new Cfdetafactura();
                        }
                    }
                }
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }
    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------


    /**
     * @param mostrarProgramacion
     */
    public void setMostrarProgramacion(boolean mostrarProgramacion) {
        this.mostrarProgramacion = mostrarProgramacion;
    }

    /**
     * @return
     */
    public boolean isMostrarProgramacion() {
        return mostrarProgramacion;
    }

    /**
     * @param tienePatologia
     */
    public void setTienePatologia(String tienePatologia) {
        this.tienePatologia = tienePatologia;
    }

    /**
     * @return
     */
    public String getTienePatologia() {
        return tienePatologia;
    }

    /**
     * @param mostrarpatologia
     */
    public void setMostrarpatologia(boolean mostrarpatologia) {
        this.mostrarpatologia = mostrarpatologia;
    }

    /**
     * @return
     */
    public boolean isMostrarpatologia() {
        return mostrarpatologia;
    }

    /**
     * @param mnuLugar
     */
    public void setMnuLugar(UIInput mnuLugar) {
        this.mnuLugar = mnuLugar;
    }

    /**
     * @param mostrarAcepta
     */
    public void setMostrarAcepta(boolean mostrarAcepta) {
        this.mostrarAcepta = mostrarAcepta;
    }

    /**
     * @return
     */
    public boolean isMostrarAcepta() {
        return mostrarAcepta;
    }

    /**
     * @return
     */
    public UIInput getMnuLugar() {
        return mnuLugar;
    }


    /**
     * @param renderDiu
     */
    public void setRenderDiu(boolean renderDiu) {
        this.renderDiu = renderDiu;
    }

    /**
     * @return
     */
    public boolean isRenderDiu() {
        return renderDiu;
    }


    /**
     * @param esValoracionPreanestesica
     */
    public void setEsValoracionPreanestesica(boolean esValoracionPreanestesica) {
        this.esValoracionPreanestesica = esValoracionPreanestesica;
    }

    /**
     * @return
     */
    public boolean isEsValoracionPreanestesica() {
        return esValoracionPreanestesica;
    }

    /**
     * @param mostrarRazones
     */
    public void setMostrarRazones(boolean mostrarRazones) {
        this.mostrarRazones = mostrarRazones;
    }

    /**
     * @return
     */
    public boolean isMostrarRazones() {
        return mostrarRazones;
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
     * @param mnuTiempo
     */
    public void setMnuTiempo(UIInput mnuTiempo) {
        this.mnuTiempo = mnuTiempo;
    }

    /**
     * @return
     */
    public UIInput getMnuTiempo() {
        return mnuTiempo;
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
     * @param mnuReserva
     */
    public void setMnuReserva(UIInput mnuReserva) {
        this.mnuReserva = mnuReserva;
    }

    /**
     * @return
     */
    public UIInput getMnuReserva() {
        return mnuReserva;
    }

    /**
     * @param inputUnidades
     */
    public void setInputUnidades(UIInput inputUnidades) {
        this.inputUnidades = inputUnidades;
    }

    /**
     * @return
     */
    public UIInput getInputUnidades() {
        return inputUnidades;
    }

    /**
     * @param mnuAcepta
     */
    public void setMnuAcepta(UIInput mnuAcepta) {
        this.mnuAcepta = mnuAcepta;
    }

    /**
     * @return
     */
    public UIInput getMnuAcepta() {
        return mnuAcepta;
    }

    /**
     * @param mnuPatologia
     */
    public void setMnuPatologia(UIInput mnuPatologia) {
        this.mnuPatologia = mnuPatologia;
    }

    /**
     * @return
     */
    public UIInput getMnuPatologia() {
        return mnuPatologia;
    }

    /**
     * @param mnuAnestesiologo
     */
    public void setMnuAnestesiologo(UIInput mnuAnestesiologo) {
        this.mnuAnestesiologo = mnuAnestesiologo;
    }

    /**
     * @return
     */
    public UIInput getMnuAnestesiologo() {
        return mnuAnestesiologo;
    }

    /**
     * @param inputCongelacion
     */
    public void setInputCongelacion(UIInput inputCongelacion) {
        this.inputCongelacion = inputCongelacion;
    }

    /**
     * @return
     */
    public UIInput getInputCongelacion() {
        return inputCongelacion;
    }

    /**
     * @param inputCualOtro
     */
    public void setInputCualOtro(UIInput inputCualOtro) {
        this.inputCualOtro = inputCualOtro;
    }

    /**
     * @return
     */
    public UIInput getInputCualOtro() {
        return inputCualOtro;
    }


    /**
     * @param generoOrden
     */
    public void setGeneroOrden(boolean generoOrden) {
        this.generoOrden = generoOrden;
    }

    /**
     * @return
     */
    public boolean isGeneroOrden() {
        return generoOrden;
    }


    /**
     * @param modoconsulta
     */
    public void setModoconsulta(boolean modoconsulta) {
        this.modoconsulta = modoconsulta;
    }

    /**
     * @return
     */
    public boolean isModoconsulta() {
        return modoconsulta;
    }


    /**
     * @param lstExamenesCirugias
     */
    public void setLstExamenesCirugias(List<Cpservicio> lstExamenesCirugias) {
        this.lstExamenesCirugias = lstExamenesCirugias;
    }

    /**
     * @return
     */
    public List<Cpservicio> getLstExamenesCirugias() {
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
     * @param lstTipoAnestesia
     */
    public void setLstTipoAnestesia(List lstTipoAnestesia) {
        this.lstTipoAnestesia = lstTipoAnestesia;
    }

    /**
     * @return
     */
    public List getLstTipoAnestesia() {
        if (lstTipoAnestesia == null || lstTipoAnestesia.isEmpty()) {
            lstTipoAnestesia = new ArrayList();
            lstTipoAnestesia.add(new SelectItem("", 
                                                "Seleccione una opcion ..."));
            lstTipoAnestesia.add(new SelectItem("2", "General"));
            lstTipoAnestesia.add(new SelectItem("4", "Regional"));
            lstTipoAnestesia.add(new SelectItem("5", "Sedaci�n"));
            lstTipoAnestesia.add(new SelectItem("6", "Local Controlada"));
            lstTipoAnestesia.add(new SelectItem("8", "Sin Anestesia"));

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
            lstEstancia.add(new SelectItem("A", "Ambulatoria"));
            lstEstancia.add(new SelectItem("H", "Hospitalizaci�n"));
        }
        return lstEstancia;
    }

    /**
     * @param lstPatologia
     */
    public void setLstPatologia(List lstPatologia) {
        this.lstPatologia = lstPatologia;
    }

    /**
     * @return
     */
    public List getLstPatologia() {
        if (lstPatologia == null || lstPatologia.isEmpty()) {
            lstPatologia = new ArrayList();
            lstPatologia.add(new SelectItem("", "Seleccione una opci�n"));
            lstPatologia.add(new SelectItem("BI", "Biopsia"));
            lstPatologia.add(new SelectItem("BC", "Biopsa por Congelaci�n"));
            lstPatologia.add(new SelectItem("CO", "Cono"));
            lstPatologia.add(new SelectItem("OT", "Otro"));
            lstPatologia.add(new SelectItem("PQ", "Pieza Qx"));

        }
        return lstPatologia;
    }

    /**
     * @param orden
     */
    public void setOrden(Chordecirugi orden) {
        this.orden = orden;
    }

    /**
     * @return
     */
    public Chordecirugi getOrden() {
        return orden;
    }


    /**
     * @param otraPatologia
     */
    public void setOtraPatologia(boolean otraPatologia) {
        this.otraPatologia = otraPatologia;
    }

    /**
     * @return
     */
    public boolean isOtraPatologia() {
        return otraPatologia;
    }

    /**
     * @param biopsaCongelacion
     */
    public void setBiopsaCongelacion(boolean biopsaCongelacion) {
        this.biopsaCongelacion = biopsaCongelacion;
    }

    /**
     * @return
     */
    public boolean isBiopsaCongelacion() {
        return biopsaCongelacion;
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
     * @param numeroConsulta
     */
    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    /**
     * @return
     */
    public Long getNumeroConsulta() {
        return numeroConsulta;
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
     * @param necesitaReserva
     */
    public void setNecesitaReserva(boolean necesitaReserva) {
        this.necesitaReserva = necesitaReserva;
    }

    /**
     * @return
     */
    public boolean isNecesitaReserva() {
        return necesitaReserva;
    }

    /**
     * @param renderVasectomia
     */
    public void setRenderVasectomia(boolean renderVasectomia) {
        this.renderVasectomia = renderVasectomia;
    }

    /**
     * @return
     */
    public boolean isRenderVasectomia() {
        return renderVasectomia;
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
     * @param esCirugia
     */
    public void setEsCirugia(boolean esCirugia) {
        this.esCirugia = esCirugia;
    }


    /**
     * @return
     */
    public boolean isEsCirugia() {
        return esCirugia;
    }


    /**
     * @param mostrarLugar
     */
    public void setMostrarLugar(boolean mostrarLugar) {
        this.mostrarLugar = mostrarLugar;
    }


    /**
     * @return
     */
    public boolean isMostrarLugar() {
        return mostrarLugar;
    }


    /**
     * @param mostrarCirugias
     */
    public void setMostrarCirugias(boolean mostrarCirugias) {
        this.mostrarCirugias = mostrarCirugias;
    }

    /**
     * @return
     */
    public boolean isMostrarCirugias() {
        return mostrarCirugias;
    }

    /**
     * @param lstLugar
     */
    public void setLstLugar(List lstLugar) {
        this.lstLugar = lstLugar;
    }


    /**
     * @return
     */
    public List getLstLugar() {
        if (lstLugar == null || lstLugar.isEmpty()) {
            lstLugar = new ArrayList();
            lstLugar.add(new SelectItem("", "Seleccione una opci�n"));
            lstLugar.add(new SelectItem("S", "Salas de Cirugia"));
            lstLugar.add(new SelectItem("P", "Salas de Procedimientos"));
            lstLugar.add(new SelectItem("C", "Consultorio"));

        }
        return lstLugar;
    }

    /**
     * @param lstPreferenciaAnestesia
     */
    public void setLstPreferenciaAnestesia(List lstPreferenciaAnestesia) {
        this.lstPreferenciaAnestesia = lstPreferenciaAnestesia;
    }

    /**
     * @return
     */
    public List getLstPreferenciaAnestesia() {
        if (lstPreferenciaAnestesia == null || 
            lstPreferenciaAnestesia.isEmpty()) {
            lstPreferenciaAnestesia = new ArrayList();
            lstPreferenciaAnestesia.add(new SelectItem("P", "Prefiere"));
            lstPreferenciaAnestesia.add(new SelectItem("A", "Acepta"));
            lstPreferenciaAnestesia.add(new SelectItem("R", "Rechaza"));
        }
        return lstPreferenciaAnestesia;
    }


    /**
     * @param numeroUsuario
     */
    public void setNumeroUsuario(Long numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    /**
     * @return
     */
    public Long getNumeroUsuario() {
        return numeroUsuario;
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

    /**
     * @param consecutivo
     */
    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    /**
     * @return
     */
    public Integer getConsecutivo() {
        return consecutivo;
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
     * @param servicio
     */
    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    /**
     * @return
     */
    public Cpservicio getServicio() {
        return servicio;
    }


    /**
     * @param mnuTienePatologia
     */
    public void setMnuTienePatologia(UIInput mnuTienePatologia) {
        this.mnuTienePatologia = mnuTienePatologia;
    }

    /**
     * @return
     */
    public UIInput getMnuTienePatologia() {
        return mnuTienePatologia;
    }


    //-----------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //-----------------------------------------------------------------------    

    public void consultarCirugias() {
        FacesUtils.resetManagedBean("buscadorCirugiasBean");
        BuscadorCirugiasBean cirugias;
        cirugias = 
                (BuscadorCirugiasBean)FacesUtils.getManagedBean("buscadorCirugiasBean");
        if (cirugias != null) {
            cirugias.init();
        }
        selectedIndex = ACTIVAR_BUSCADOR_CIRUGIAS;
        mostrarCirugias = true;

    }


    public void eliminarCirugia() {
        Cpservicio servicioSelec;
        servicioSelec = (Cpservicio)dtServicios.getRowData();
        lstExamenesCirugias.remove(servicioSelec);
        renderDiu = false;
        renderVasectomia = false;
        if (lstExamenesCirugias != null && !lstExamenesCirugias.isEmpty()) {
            for (Cpservicio servicio: lstExamenesCirugias) {
                String codigoServicio = servicio.getCsvccodigo();
                if (codigoServicio != null && 
                    lstExamenesCirugias.size() == 1) {
                    if (codigoServicio.equals("637300")) {
                        renderVasectomia = true;
                    }
                    StringTokenizer st = 
                        new StringTokenizer(codigoServicio, ".");
                    codigoServicio = st.nextToken();
                    if (codigoServicio != null && 
                        codigoServicio.equals("662200")) {
                        renderDiu = true;
                    }
                }
            }

        }
        for (Cfdetafactura fact: cfdetafacturaList) {
            if (fact.getCdfcservicio().equals(servicioSelec.getCsvccodigo())) {
                fact.setValidacionConsultaClinica(false);
            }
        }

    }

    public void changePatologia() {
        if (orden.getHocctipopatolo().equals("BC")) {
            biopsaCongelacion = true;
        } else {
            biopsaCongelacion = false;
        }
        if (orden.getHocctipopatolo().equals("OT")) {
            otraPatologia = true;
        } else {
            otraPatologia = false;
        }

    }


    public void changeEstancia() {
        if (orden != null && orden.getHocctipoestanc() != null && 
            orden.getHocctipoestanc().equals("H")) {
            esHospitalaria = true;
        } else {
            esHospitalaria = false;
        }
    }

    public void changeReserva() {
        if (orden != null && orden.getHoceresesangre() != null && 
            orden.getHoceresesangre().equals("S")) {
            necesitaReserva = true;
        } else {
            necesitaReserva = false;
        }
    }

    public void changeTienePatologia() {
        if (tienePatologia != null && tienePatologia.equals("S")) {
            mostrarpatologia = true;
        } else {
            mostrarpatologia = false;
            otraPatologia = false;
            biopsaCongelacion = false;
            mnuPatologia.setValue(null);
            inputCualOtro.setValue(null);
            orden.setHoccotrapatolo(null);
            orden.setHocctipopatolo(null);
        }
    }


    /**
     * @param valueChangeEvent
     */
    public void setTienePatologia(ValueChangeEvent valueChangeEvent) {
        setTienePatologia((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setEstanciaSelect(ValueChangeEvent valueChangeEvent) {
        orden.setHocctipoestanc((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setReservaSelect(ValueChangeEvent valueChangeEvent) {
        orden.setHoceresesangre((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setPatologiaSelect(ValueChangeEvent valueChangeEvent) {
        orden.setHocctipopatolo((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    private void resetProgramar() {
        mnuTiempo.setValue("");
        mnuAnestesia.setValue("");
        mnuAyudantia.setValue("");
        orden.setHocctipoestanc(null);
        mnuEstancia.setValue("");
        inputDias.setValue("");
        orden.setHoceresesangre(null);
        mnuReserva.setValue("");
        inputUnidades.setValue("");
        mnuPatologia.setValue("");
        mnuAnestesiologo.setValue("");
        inputCongelacion.setValue("");
        inputCualOtro.setValue("");
        mnuTienePatologia.setValue(null);
        mostrarpatologia = false;
        otraPatologia = false;
        biopsaCongelacion = false;
        mnuPatologia.setValue(null);
        inputCualOtro.setValue(null);
        orden.setHoccotrapatolo(null);
        orden.setHocctipopatolo(null);
        orden.setHocctipopatolo(null);
        mostrarProgramacion = false;
        biopsaCongelacion = false;
        esHospitalaria = false;
        necesitaReserva = false;
        otraPatologia = false;
    }


    //-----------------------------------------------------------------------
    //  Construir Reporte
    //-----------------------------------------------------------------------


    /**
     * @param jrField
     * @return
     */
    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("DIA")) {
            value = DIA;
        } else if (fieldName.equals("MES")) {
            value = MES;
        } else if (fieldName.equals("ANO")) {
            value = ANO;
        } else if (fieldName.equals("INTERVENCION")) {
            value = INTERVENCION;
        } else if (fieldName.equals("TIEMPO_CIRUGIA")) {
            value = TIEMPO_CIRUGIA;
        } else if (fieldName.equals("ANESTESIA_SOLICITADA")) {
            value = ANESTESIA_SOLICITADA;
        } else if (fieldName.equals("ESTANCIA")) {
            value = ESTANCIA;
        } else if (fieldName.equals("DIAS")) {
            value = DIAS;
        } else if (fieldName.equals("DIAS_ESTANCIA")) {
            value = DIAS_ESTANCIA;
        } else if (fieldName.equals("AYUDANTIA")) {
            value = AYUDANTIA;
        } else if (fieldName.equals("RESERVA_SANGRE")) {
            value = RESERVA_SANGRE;
        } else if (fieldName.equals("NUMERO_UNIDADES")) {
            value = NUMERO_UNIDADES;
        } else if (fieldName.equals("PATOLOGIA")) {
            value = PATOLOGIA;
        } else if (fieldName.equals("NOMBRES_PACIENTE")) {
            value = NOMBRES_PACIENTE;
        } else if (fieldName.equals("NOMBRE_CIRUJANO")) {
            value = NOMBRE_CIRUJANO;
        } else if (fieldName.equals("EDAD")) {
            value = EDAD;
        } else if (fieldName.equals("PROGRAMAR")) {
            value = PROGRAMAR;
        } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = NUMERO_DOCUMENTO;
        } else if (fieldName.equals("HORA_SISTEMA")) {
            value = HORA_SISTEMA;
        } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
            value = NOMBRE_PROFESIONAL;
        } else if (fieldName.equals("TIPOID_PROFESIONAL")) {
            value = TIPOID_PROFESIONAL;
        } else if (fieldName.equals("NUMID_PROFESIONAL")) {
            value = NUMID_PROFESIONAL;
        } else if (fieldName.equals("REGISTRO_MEDICO")) {
            value = REGISTRO_MEDICO;
        }
        if (fieldName.equals("ESPECIALIDAD")) {
            value = ESPECIALIDAD;
            return value;
        }
        if (fieldName.equals("PATOLOGIA_CONGELA")) {
            value = PATOLOGIA_CONGELA;
        }
        if (fieldName.equals("PATOLOGIA_OTRO")) {
            value = PATOLOGIA_OTRO;
        }
        if (fieldName.equals("VIA_ACCESO")) {
            value = VIA_ACCESO;
        }
        if (fieldName.equals("PARTICULAR")) {
            value = PARTICULAR;
        }
        if (fieldName.equals("TIPO_USUARIO")) {
            value = TIPO_USUARIO;
        }

        if (fieldName.equals("HEMOCOMPONENTE")) {
            value = HEMOCOMPONENTE;
        }

        if (fieldName.equals("OBSERVACION")) {
            value = OBSERVACION;
        }
        if (fieldName.equals("INTERVENCION1")) {
            value = INTERVENCION1;
        }
        if (fieldName.equals("INTERVENCION2")) {
            value = INTERVENCION2;
        }
        if (fieldName.equals("INTERVENCION3")) {
            value = INTERVENCION3;
        }
        if (fieldName.equals("HORA_SISTEMA_DATE")) {
            value = HORA_SISTEMA_DATE;
        }
        

        return value;
    }


    /**
     * Metodo que obtiene los datos para generar Cirug�as y procedimientos 
     */
    public void obtenerDatosReporteConsulta() throws ModelException {
        Cfadmision admi;
        admi = null;
        if (numeroAdmision != null) {
            admision = 
                    getServiceLocator().getClinicoService().getAdmision(numeroAdmision);
        }
        INTERVENCION = "";
        INTERVENCION1="";
        INTERVENCION2="";
        INTERVENCION3="";
        Iterator it = lstExamenesCirugias.iterator();
        Cpservicio servicioAux = null;
        while (it.hasNext()) {
            servicioAux = (Cpservicio)it.next();
            if (servicioAux != null) {
                INTERVENCION = 
                        INTERVENCION + ", " + servicioAux.getCsvccodigo() + 
                        " " + servicioAux.getCsvcnombre();
            }
        }
        if (INTERVENCION != null && INTERVENCION.length() > 2) {
            INTERVENCION = INTERVENCION.substring(1, INTERVENCION.length());
            INTERVENCION1=INTERVENCION.substring(1, INTERVENCION.length());
        }
        if(lstExamenesCirugias.size()<=3){
        for(int i=0; i<lstExamenesCirugias.size();i++){
        String s="INTERVENCION"+i;
            if(s.equals("INTERVENCION0")){
                INTERVENCION1=lstExamenesCirugias.get(i).getCsvccodigo() +" "+lstExamenesCirugias.get(i).getCsvcnombre();
            }else if(s.equals("INTERVENCION1")){
                INTERVENCION2=lstExamenesCirugias.get(i).getCsvccodigo() +" "+lstExamenesCirugias.get(i).getCsvcnombre();
            }else if(s.equals("INTERVENCION2")){
                INTERVENCION3=lstExamenesCirugias.get(i).getCsvccodigo() +" "+lstExamenesCirugias.get(i).getCsvcnombre();
            } 
        }
        }
     
        if (admision != null && admision.getCannumero() != null) {
            admi = admision;
        }

        if (usuario != null) {
            if (usuario.getHusdfechanacim() != null) {
                Date fechaNacimiento = usuario.getHusdfechanacim();
                if (fechaNacimiento != null) {
                    int edad = calcularEdad(fechaNacimiento, new Date());
                    EDAD = edad;
                }

            }

            if (usuario.getHuscprimernomb() != null) {
                NOMBRES_PACIENTE = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRES_PACIENTE = 
                        NOMBRES_PACIENTE + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                NOMBRES_PACIENTE = 
                        NOMBRES_PACIENTE + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                NOMBRES_PACIENTE = 
                        NOMBRES_PACIENTE + usuario.getHuscsegundapel();
            }
            if (usuario.getHusanumeiden() != 0) {
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }

        }

        if (userName() != null) {
            Cpprofesio profesional;
            profesional = null;
            try {
                if (this.getClinica() != null) {
                    profesional = 
                            serviceLocator.getClinicoService().getProfesionalPorUsuario(userName(), 
                                                                                        getClinica().getCclncodigo());
                }

            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (profesional != null) {
                NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                TIPOID_PROFESIONAL = profesional.getCpfctipide();
                NUMID_PROFESIONAL = profesional.getCpfacedula();
                REGISTRO_MEDICO = profesional.getCpfcregmedic();
                ESPECIALIDAD = 
                        obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
            }
        }

        Date fecha;
        fecha = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        Integer diaact = calendar.get(Calendar.DAY_OF_MONTH);
        Integer mesact = calendar.get(Calendar.MONTH) + 1;
        Integer anoact = calendar.get(calendar.YEAR);
        Integer horaact = calendar.get(Calendar.HOUR_OF_DAY);
        Integer minact = calendar.get(Calendar.MINUTE);

        if (diaact.compareTo(10) < 0) {
            DIA = "0" + diaact.toString();
        } else {
            DIA = diaact.toString();
        }

        if (mesact.compareTo(10) < 0) {
            MES = "0" + mesact.toString();
        } else {
            MES = mesact.toString();
        }
        if (horaact != null && minact != null) {
            HORA_SISTEMA = horaact.toString() + ":" + minact.toString();
        }
        HORA_SISTEMA_DATE= new Date();

        ANO = anoact.toString();
        


        if (orden != null && orden.getHocctipoaneste() != null) {
                if (orden.getHocctipoaneste().equals("1")) {
                    ANESTESIA_SOLICITADA = "Controlada";
                }
                if (orden.getHocctipoaneste().equals("2")) {
                    ANESTESIA_SOLICITADA = "General";
                }
                if (orden.getHocctipoaneste().equals("3")) {
                    ANESTESIA_SOLICITADA = "Local";
                }
                if (orden.getHocctipoaneste().equals("4")) {
                    ANESTESIA_SOLICITADA = "Regional";
                }
                if (orden.getHocctipoaneste().equals("5")) {
                    ANESTESIA_SOLICITADA = "Sedacion";
                }
                if (orden.getHocctipoaneste().equals("6")) {
                    ANESTESIA_SOLICITADA = "Local Controlada";
                }
                if (orden.getHocctipoaneste().equals("8")) {
                    ANESTESIA_SOLICITADA = "Sin Anestesia";
                }
        }

        if (orden.getHocctipoestanc() != null && 
            !orden.getHocctipoestanc().equals("")) {
            if (orden.getHocctipoestanc().equals("A")) {
                ESTANCIA = "Ambulatoria";
            }
            if (orden.getHocctipoestanc().equals("H")) {
                ESTANCIA = "Hospitalizaci�n";
            }

        }

        if (orden != null && orden.getHocntiempointe() != null) {
            TIEMPO_CIRUGIA = orden.getHocntiempointe();
        }

        if (orden != null && orden.getHocndiasestanc() != null) {
            DIAS_ESTANCIA = orden.getHocndiasestanc();
        }

        if (orden != null && orden.getHoceayudantia() != null) {
            if (orden.getHoceayudantia().equals("S")) {
                AYUDANTIA = "SI";
            } else {
                AYUDANTIA = "NO";
            }


        }

        if (orden.getHoceresesangre() != null && 
            orden.getHoceresesangre().equals("S")) {
            RESERVA_SANGRE = "SI";
        }

        if (orden.getHoceresesangre() != null && 
            orden.getHoceresesangre().equals("N")) {
            RESERVA_SANGRE = "NO";
        }

        if (orden != null && orden.getHocnunidadsang() != null) {
            NUMERO_UNIDADES = orden.getHocnunidadsang();
        }
        if (orden.getHocctipopatolo() != null && 
            !orden.getHocctipopatolo().equals("")) {
            if (orden.getHocctipopatolo().equals("BI")) {
                PATOLOGIA = "Biopsia";
            }
            if (orden != null && orden.getHoccbiopsacong() != null && 
                orden.getHocctipopatolo().equals("BC")) {
                PATOLOGIA = 
                        "Biopsa por Congelaci�n: " + orden.getHoccbiopsacong();
                PATOLOGIA_CONGELA = orden.getHoccbiopsacong();
            }
            if (orden.getHocctipopatolo().equals("CO")) {
                PATOLOGIA = "Cono";
            }
            if (orden != null && orden.getHoccotrapatolo() != null && 
                orden.getHocctipopatolo().equals("OT")) {
                PATOLOGIA = "OTRO: " + orden.getHoccotrapatolo();
                PATOLOGIA_OTRO = orden.getHoccotrapatolo();
            }
            if (orden.getHocctipopatolo().equals("PQ")) {
                PATOLOGIA = "Pieza Qx";
            }
           
        }
        if (orden.getHoccviaacceso().equals("LC")) {
            VIA_ACCESO = "LC";
        } else if (orden.getHoccviaacceso().equals("VA")) {
            VIA_ACCESO = "VA";
        } else {
            VIA_ACCESO = "LT";
        }

        if (orden.getHocchemocomp() != null) {
            HEMOCOMPONENTE = orden.getHocchemocomp();
        }

        if (orden.getHoccobservacio() != null) {
            OBSERVACION = orden.getHoccobservacio();
        }
        if (admi != null) {
            if (admi.getCancontra().equals(1)) {
                PARTICULAR = "S";
            } else {
                String ent;

                PARTICULAR = "N";
                if (null != usuario.getHuscentidadadm()) {
                    ent = 
serviceLocator.getClinicoService().getDescripcionEntidadByCodigo(usuario.getHuscentidadadm());
                    TIPO_USUARIO = ent;
                }

            }
        }
        if (getUsuarioSystem() != null && 
            getUsuarioSystem().getCurcnombre() != null) {
            NOMBRE_CIRUJANO = this.getUsuarioSystem().getCurcnombre();
        }


    }


    /**
     * Metodo que obtiene los datos para generar Cirug�as y procedimientos
     */
    public void obtenerDatosReporteCirugia() throws ModelException {

        Chusuario usuarioAux;
        usuarioAux = null;
        Cfadmision admi;
        admi = null;

        if (numeroAdmision != null) {
            admision = 
                    getServiceLocator().getClinicoService().getAdmision(numeroAdmision);
        }
        INTERVENCION = "";
        Iterator it = lstExamenesCirugias.iterator();
        Cpservicio servicioAux = null;
        while (it.hasNext()) {
            servicioAux = (Cpservicio)it.next();
            if (servicioAux != null) {
                INTERVENCION = 
                        INTERVENCION + ", " + servicioAux.getCsvcnombre();
            }
        }
        if (INTERVENCION != null && INTERVENCION.length() > 2) {
            INTERVENCION = INTERVENCION.substring(1, INTERVENCION.length());
        }

        if (usuario != null) {
            usuarioAux = usuario;
        }
        if (admision != null) {
            admi = admision;
        }


        if (usuarioAux != null) {
            if (usuarioAux.getHusdfechanacim() != null) {
                Date fechaNacimiento = usuarioAux.getHusdfechanacim();
                if (fechaNacimiento != null) {
                    int edad = calcularEdad(fechaNacimiento, new Date());
                    EDAD = edad;
                }

            }

            if (usuarioAux.getHuscprimernomb() != null) {
                NOMBRES_PACIENTE = usuarioAux.getHuscprimernomb() + " ";
            }
            if (usuarioAux.getHuscsegundnomb() != null && 
                !usuarioAux.getHuscsegundnomb().equals("_")) {
                NOMBRES_PACIENTE = 
                        NOMBRES_PACIENTE + usuarioAux.getHuscsegundnomb() + 
                        " ";
            }
            if (usuarioAux.getHuscprimerapel() != null) {
                NOMBRES_PACIENTE = 
                        NOMBRES_PACIENTE + usuarioAux.getHuscprimerapel() + 
                        " ";
            }
            if (usuarioAux.getHuscsegundapel() != null && 
                !usuarioAux.getHuscsegundapel().equals("_")) {
                NOMBRES_PACIENTE = 
                        NOMBRES_PACIENTE + usuarioAux.getHuscsegundapel();
            }
            if (usuarioAux.getHusanumeiden() != 0) {
                NUMERO_DOCUMENTO = usuarioAux.getHusanumeiden();
            }
            if (usuarioAux.getHuscentidadadm() != null) {
                NUMERO_DOCUMENTO = usuarioAux.getHusanumeiden();
            }
        }
        Date fecha;
        fecha = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        Integer diaact = calendar.get(Calendar.DAY_OF_MONTH);
        Integer mesact = calendar.get(Calendar.MONTH) + 1;
        Integer anoact = calendar.get(calendar.YEAR);
        Integer horaact = calendar.get(Calendar.HOUR_OF_DAY);
        Integer minact = calendar.get(Calendar.MINUTE);

        if (diaact.compareTo(10) < 0) {
            DIA = "0" + diaact.toString();
        } else {
            DIA = diaact.toString();
        }

        if (mesact.compareTo(10) < 0) {
            MES = "0" + mesact.toString();
        } else {
            MES = mesact.toString();
        }
        if (horaact != null && minact != null) {
            HORA_SISTEMA = horaact.toString() + ":" + minact.toString();
        }

        ANO = anoact.toString();


        if (orden != null && orden.getHocctipoaneste() != null) {
            if (orden.getHocctipoaneste().equals("1")) {
                ANESTESIA_SOLICITADA = "Controlada";
            }
            if (orden.getHocctipoaneste().equals("2")) {
                ANESTESIA_SOLICITADA = "General";
            }
            if (orden.getHocctipoaneste().equals("3")) {
                ANESTESIA_SOLICITADA = "Local";
            }
            if (orden.getHocctipoaneste().equals("4")) {
                ANESTESIA_SOLICITADA = "Regional";
            }
            if (orden.getHocctipoaneste().equals("5")) {
                ANESTESIA_SOLICITADA = "Sedacion";
            }
            if (orden.getHocctipoaneste().equals("6")) {
                ANESTESIA_SOLICITADA = "Local Controlada";
            }
            if (orden.getHocctipoaneste().equals("8")) {
                ANESTESIA_SOLICITADA = "Sin Anestesia";
            }
           
        }

        if (orden.getHocctipoestanc() != null && 
            !orden.getHocctipoestanc().equals("")) {
            if (orden.getHocctipoestanc().equals("A")) {
                ESTANCIA = "Ambulatoria";
            }
            if (orden.getHocctipoestanc().equals("H")) {
                ESTANCIA = "Hospitalizaci�n";
            }

        }

        if (orden != null && orden.getHocntiempointe() != null) {
            TIEMPO_CIRUGIA = orden.getHocntiempointe();
        }

        if (orden != null && orden.getHocndiasestanc() != null) {
            DIAS_ESTANCIA = orden.getHocndiasestanc();
        }

        if (orden != null && orden.getHoceayudantia() != null) {
            if (orden.getHoceayudantia().equals("S")) {
                AYUDANTIA = "SI";
            } else {
                AYUDANTIA = "NO";
            }


        }

        if (orden.getHoceresesangre() != null && 
            orden.getHoceresesangre().equals("S")) {
            RESERVA_SANGRE = "SI";
        }

        if (orden.getHoceresesangre() != null && 
            orden.getHoceresesangre().equals("N")) {
            RESERVA_SANGRE = "NO";
        }

        if (orden != null && orden.getHocnunidadsang() != null) {
            NUMERO_UNIDADES = orden.getHocnunidadsang();
        }
        if (orden.getHocctipopatolo() != null && 
            !orden.getHocctipopatolo().equals("")) {
            if (orden.getHocctipopatolo().equals("BI")) {
                PATOLOGIA = "Biopsia";
            }
            if (orden != null && orden.getHoccbiopsacong() != null && 
                orden.getHocctipopatolo().equals("BC")) {
                PATOLOGIA = 
                        "Biopsa por Congelaci�n: " + orden.getHoccbiopsacong();
                PATOLOGIA_CONGELA = orden.getHoccbiopsacong();
            }
            if (orden.getHocctipopatolo().equals("CO")) {
                PATOLOGIA = "Cono";
            }
            if (orden != null && orden.getHoccotrapatolo() != null && 
                orden.getHocctipopatolo().equals("OT")) {
                PATOLOGIA = "OTRO: " + orden.getHoccotrapatolo();
                PATOLOGIA_OTRO = orden.getHoccotrapatolo();
            }
            if (orden.getHocctipopatolo().equals("PQ")) {
                PATOLOGIA = "Pieza Qx";
            }
            if (orden.getHoccviaacceso().equals("LC")) {
                VIA_ACCESO = "LC";
            } else if (orden.getHoccviaacceso().equals("VA")) {
                VIA_ACCESO = "VA";
            } else {
                VIA_ACCESO = "LT";
            }
        }
        if (admi != null) {
            if (admi.getCancontra() == 1) {
                PARTICULAR = "S";
            } else {
                PARTICULAR = "N";
                TIPO_USUARIO = usuarioAux.getHuscentidadadm();
            }
        }
        if (orden.getHocchemocomp() != null) {
            HEMOCOMPONENTE = orden.getHocchemocomp();
        }

        if (orden.getHoccobservacio() != null) {
            OBSERVACION = orden.getHoccobservacio();
        }
        if (orden != null && orden.getHoccprogramar() != null) {
            if (orden.getHoccprogramar().equals("S")) {
                PROGRAMAR = "SI";
            }
            if (orden.getHoccprogramar().equals("N")) {
                PROGRAMAR = "NO";
            }
        }
        if (getUsuarioSystem() != null && 
            getUsuarioSystem().getCurcnombre() != null) {
            NOMBRE_CIRUJANO = this.getUsuarioSystem().getCurcnombre();
            NUMID_PROFESIONAL = this.getUsuarioSystem().getCuracedula();
            TIPOID_PROFESIONAL = "CC";
        }


    }


    /**
     * @return
     */
    public boolean next() {
        index++;
        return (index < NUMERO_ORDENES);
    }

    public void aceptarCirugia() {
        renderDiu = false;
        renderVasectomia = false;
        buscadorCirugias = 
                (BuscadorCirugiasBean)FacesUtils.getManagedBean("buscadorCirugiasBean");
        if (buscadorCirugias != null) {
            if (lstExamenesCirugias != null && 
                !lstExamenesCirugias.isEmpty()) {
                lstExamenesCirugias.addAll(buscadorCirugias.getLstCirugiaSelec());
            } else {
                lstExamenesCirugias = buscadorCirugias.getLstCirugiaSelec();
            }
            if (lstExamenesCirugias != null && 
                !lstExamenesCirugias.isEmpty()) {
                for (Cpservicio servicio: lstExamenesCirugias) {
                    String codigoServicio = servicio.getCsvccodigo();
                    if (codigoServicio != null && 
                        lstExamenesCirugias.size() == 1) {
                        if (codigoServicio.equals("637300")) {
                            renderVasectomia = true;
                        }
                        StringTokenizer st = 
                            new StringTokenizer(codigoServicio, ".");
                        codigoServicio = st.nextToken();
                        if (codigoServicio != null && 
                            codigoServicio.equals("662200")) {
                            renderDiu = true;
                        }
                    }
                }
            }
            mostrarCirugias = false;
            selectedIndex = ACTIVAR_ORDEN_CIRUGIA;
        }
    }

    public void aceptarServicioPropuesto() {
        renderDiu = false;
        renderVasectomia = false;
        Cfdetafactura factura = 
            (Cfdetafactura)tableServiciosAdmision.getRowData();
        try {
            servicio = 
                    serviceLocator.getClinicoService().getServicioPorId(factura.getCdfcservicio());
        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (servicio != null) {
            lstExamenesCirugias.add(servicio);
            if (lstExamenesCirugias != null && 
                !lstExamenesCirugias.isEmpty()) {
                for (Cpservicio servicio: lstExamenesCirugias) {
                    String codigoServicio = servicio.getCsvccodigo();
                    if (codigoServicio != null && 
                        lstExamenesCirugias.size() == 1) {
                        if (codigoServicio.equals("637300")) {
                            renderVasectomia = true;
                        }
                        StringTokenizer st = 
                            new StringTokenizer(codigoServicio, ".");
                        codigoServicio = st.nextToken();
                        if (codigoServicio != null && 
                            codigoServicio.equals("662200")) {
                            renderDiu = true;
                        }
                    }
                }
            }
            mostrarCirugias = false;
            for (Cfdetafactura fact: cfdetafacturaList) {
                if (fact.getCdfcservicio().equals(factura.getCdfcservicio())) {
                    fact.setValidacionConsultaClinica(true);
                }
            }
        }
    }

    /**
     * @param valueChangeEvent
     */
    public void setHoccpaciacepta(ValueChangeEvent valueChangeEvent) {
        orden.setHoccpaciacepta((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void changeAcepta() {
        if (orden != null && orden.getHoccpaciacepta() != null && 
            orden.getHoccpaciacepta().equals("S")) {
            mostrarLugar = true;
        } else {
            resetProgramar();
            mnuLugar.setValue("");
            orden.setHocclugarinter("");
            mostrarLugar = false;
            mostrarProgramacion = false;

        }
    }


    /**
     * @param valueChangeEvent
     */
    public void setHocclugarinter(ValueChangeEvent valueChangeEvent) {
        orden.setHocclugarinter((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void changeLugar() {
        if (orden != null && orden.getHocclugarinter() != null && 
            (orden.getHocclugarinter().equals("S") || 
             orden.getHocclugarinter().equals("P"))) {
            mostrarProgramacion = true;

            lstTipoAnestesia = new ArrayList();
            lstTipoAnestesia.add(new SelectItem("", 
                                                "Seleccione una opcion ..."));
            lstTipoAnestesia.add(new SelectItem("2", "General"));
            lstTipoAnestesia.add(new SelectItem("4", "Regional"));
            lstTipoAnestesia.add(new SelectItem("5", "Sedaci�n"));
            lstTipoAnestesia.add(new SelectItem("6", "Local Controlada"));
            lstTipoAnestesia.add(new SelectItem("8", "Sin Anestesia"));


            if (orden.getHocclugarinter().equals("P")) {

                lstTipoAnestesia = new ArrayList();
                lstTipoAnestesia.add(new SelectItem("", 
                                                    "Seleccione una opcion ..."));


                lstTipoAnestesia.add(new SelectItem("5", "Sedaci�n"));
                lstTipoAnestesia.add(new SelectItem("6", "Local Controlada"));
                lstTipoAnestesia.add(new SelectItem("8", "Sin Anestesia"));
            }

        } else {
            resetProgramar();

        }


        if (esValoracionPreanestesica) {
            mostrarProgramacion = false;
        }
    }


    public void changeProgramarCirugia() {
        if (orden.getHoccprogrcirug() != null && 
            orden.getHoccprogrcirug().equals("N")) {

            resetProgramar();
            mnuLugar.setValue("");
            orden.setHocclugarinter("");
            mnuAcepta.setValue(null);
            orden.setHoccpaciacepta(null);

            mostrarRazones = true;
            mostrarAcepta = false;
            mostrarLugar = false;
            mostrarProgramacion = false;


        } else {
            mostrarRazones = false;
            mostrarAcepta = true;
        }
    }


    /**
     * @param valueChangeEvent
     */
    public void setHoccprogrcirug(ValueChangeEvent valueChangeEvent) {
        orden.setHoccprogrcirug((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    //--------------------------------------------------------------------------
    //  Metodo esValido que garantiza que el registro fue guardado exitosamente
    //--------------------------------------------------------------------------

    public boolean esValido() {
        boolean esValido = false;
        Chordecirugi ordenAux = null;
        if (numeroConsulta != null) {

            try {
                ordenAux = 
                        serviceLocator.getClinicoService().getOrdenCirugia(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }


            if (ordenAux != null) {
                esValido = true;
            } else {
                esValido = false;
            }


        }
        return esValido;
    }

    //--------------------------------------------------------------------------
    //  Bot�n principal
    //--------------------------------------------------------------------------

    public void generarOrdenCirugia() {
        this.index = -1;
        boolean wexito;
        String codigosCirugias = "";
        String urlReporte = "";

        wexito = true;

        ChordecirugiPK id = new ChordecirugiPK();


        if (lstExamenesCirugias != null && !lstExamenesCirugias.isEmpty()) {

            codigosCirugias = "";
            Cpservicio servicioAux;
            servicioAux = null;
            Iterator it = lstExamenesCirugias.iterator();
            while (it.hasNext()) {
                servicioAux = (Cpservicio)it.next();
                if (servicioAux != null) {
                    codigosCirugias = 
                            codigosCirugias + servicioAux.getCsvccodigo() + 
                            ",";
                }
            }

            codigosCirugias = 
                    codigosCirugias.substring(0, codigosCirugias.length() - 1);
        } else {
            wexito = false;
        }

        if (wexito) {
            orden.setHoccoperador(userName());
            orden.setHoccintervenci(codigosCirugias);
            orden.setHocdfecregistr(new Date());
            if (tiempoSelect != null && !tiempoSelect.equals("")) {
                orden.setHocntiempointe(new Integer(tiempoSelect));
            }

            if (numeroConsulta != null && tipoServicio != null && 
                consecutivo != null) {
                id.setHoclconsulta(numeroConsulta);
                id.setHocctiposervi(tipoServicio);
                id.setHocnconsecutiv(consecutivo);
                orden.setId(id);
            }
            if (orden.getHocclugarinter() == null) {
                orden.setHocclugarinter("");
            }


            if (!modoconsulta) {
                try {
                    List<Cnconsclin> listadeConsultasClinicas = 
                        new ArrayList();
                    Cptipodocu tipodocu = new Cptipodocu();
                    Cpservicio servicio = new Cpservicio();


                    admision = 
                            getServiceLocator().getClinicoService().getAdmision(numeroAdmision);
                    /*
                    for (Cpservicio extamencir: lstExamenesCirugias) {
                        for (Cfdetafactura detalle: cfdetafacturaList) {
                            if (detalle.getCdfnconsuclin() == null &&
                                detalle.getCdfcservicio().equals(extamencir.getCsvccodigo())) {
                                tipodocu =
                                        this.serviceLocator.getCirugiaService().getTipoDocuPorId(100);

                                servicio =
                                        this.serviceLocator.getClinicoService().getServicioPorId(detalle.getCdfcservicio());

                                Cnconsclin consclin = new Cnconsclin();
                                consclin.setCconclinic(admision.getCanclinic().intValue());
                                consclin.setCconsalesp(0);
                                consclin.setCconconsul(0);
                                consclin.setCcontconcl(servicio.getCsvntipcon());
                                consclin.setCcodfecreg(admision.getCadfecreg());
                                consclin.setCconhistor(0);
                                consclin.setCcoctipide(admision.getCactipide());
                                consclin.setCcoanumide(new BigDecimal(admision.getCannumide()));
                                consclin.setCcocprinom(usuario.getHuscprimernomb());
                                consclin.setCcocsegnom(usuario.getHuscsegundnomb());
                                consclin.setCcocpriape(usuario.getHuscprimerapel());
                                consclin.setCcocsegape(usuario.getHuscsegundapel());
                                consclin.setCconclidoc(admision.getCanclinic().intValue());
                                consclin.setCcontipdoc(tipodocu);
                                consclin.setCconnumdoc(new BigDecimal(admision.getCannumero()));
                                consclin.setCconprogra(admision.getCanprogra().intValue());
                                consclin.setCconcontra(admision.getCancontra().intValue());
                                consclin.setCcocservic(servicio);
                                consclin.setCconcantid(detalle.getCdfncantidad().intValue());
                                consclin.setCcoavalser(new BigDecimal(detalle.getCdfnvalsrv()));
                                consclin.setCcodfecreg(new Date());
                                consclin.setCcodfeccon(admision.getCadfecreg());
                                consclin.setCcothorcon(new Date());
                                consclin.setCcocusureg(getUsuarioSystem().getCurcusuari());
                                consclin.setCcocetapa(IConstantes.CEN_SALA);
                                consclin.setCcothorate(new Date());
                                consclin.setCcocusumod(" ");
                                consclin.setCcocestado(IConstantes.ESTADO_VIGENTE);
                                consclin.setCcondonant(new BigDecimal(admision.getCandonante()));
                                consclin.setCcocgenero(usuario.getHusesexo());
                                consclin.setCcolusuario(usuario);
                                consclin.setCcocintext(admision.getCacintext());
                                listadeConsultasClinicas.add(consclin);
                            }
                        }
                    }
                    */
                    serviceLocator.getClinicoService().saveOrdenCirugiaLiberacion(listadeConsultasClinicas, 
                                                                                  cfdetafacturaList, 
                                                                                  numeroAdmision, 
                                                                                  orden);
                    //busquedaDetalleFactura();
                    interConsultaUsuarioBean = 
                            (InterConsultaUsuarioBean)FacesUtils.getManagedBean("interConsultaUsuarioBean");
                    interConsultaUsuarioBean.inicializarInterConsulta();
                    FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                } catch (ModelException e) {
                    FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                    e.printStackTrace();
                }

            }
            try {
                if (!esCirugia) {
                    obtenerDatosReporteConsulta();
                } else {
                    obtenerDatosReporteCirugia();
                }

                if (orden != null && orden.getHocclugarinter() != null) {
                    if (orden.getHocclugarinter().equals("S") || 
                        orden.getHocclugarinter().equals("P")) {
                        //urlReporte = "/reports/ordenCirugia3.jasper";
                        urlReporte = "/reports/reporteOrdenCirugia.jasper";
                    } else {
                        urlReporte = "/reports/ordenCirugiaConsultorio.jasper";
                    }
                    if (renderDiu || renderVasectomia) {
                        urlReporte = "/reports/ordenCirugiaConsultorio.jasper";
                    }
                }

                if (orden != null && orden.getHocclugarinter() != null && 
                    !esValoracionPreanestesica) {
                    URL url = 
                        FacesUtils.getFacesContext().getExternalContext().getResource(urlReporte);
                    URL url_profamilia = 
                        FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
                    URL url_super_horizontal = 
                        FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
                    URL url_super_vertical = 
                        FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
                    if (url != null) {
                        Map parameters = new HashMap();
                        parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                        parameters.put("IMAGE_SUPER_HORIZONTAL", 
                                       url_super_horizontal);
                        parameters.put("IMAGE_SUPER_VERTICAL", 
                                       url_super_vertical);
                        byte[] bytes;

                        JasperReport report = 
                            (JasperReport)JRLoader.loadObject(url);

                        bytes = 
                                JasperRunManager.runReportToPdf(report, parameters, 
                                                                (JRDataSource)this);

                        PdfServletUtils.showPdfDocument(bytes, 
                                                        "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                                        ".pdf", false);

                        generoOrden = true;
                    }
                }

                modoconsulta = true;
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
            }
        } else {
            FacesUtils.addErrorMessage("body:formOrdenCirugia:panelTabOrdenCirugia:imagelupa", 
                                       "Debe Seleccionar por lo menos una cirugia");
        }
    }


    public void setEsLigadura(boolean esLigadura) {
        this.esLigadura = esLigadura;
    }

    public boolean isEsLigadura() {
        return esLigadura;
    }


    public void setNumeroAdmision(Long numeroAdmision) {
        this.numeroAdmision = numeroAdmision;
    }

    public Long getNumeroAdmision() {
        return numeroAdmision;
    }

    public void setCfdetafacturaList(List<Cfdetafactura> cfdetafacturaList) {
        this.cfdetafacturaList = cfdetafacturaList;
    }

    public List<Cfdetafactura> getCfdetafacturaList() {
        return cfdetafacturaList;
    }

    public void setTableServiciosAdmision(HtmlDataTable tableServiciosAdmision) {
        this.tableServiciosAdmision = tableServiciosAdmision;
    }

    public HtmlDataTable getTableServiciosAdmision() {
        return tableServiciosAdmision;
    }

    public void setCfdetafactura(Cfdetafactura cfdetafactura) {
        this.cfdetafactura = cfdetafactura;
    }

    public Cfdetafactura getCfdetafactura() {
        return cfdetafactura;
    }

    public void setResultList(List<Object[]> resultList) {
        this.resultList = resultList;
    }

    public List<Object[]> getResultList() {
        return resultList;
    }

    public void setAdmision(Cfadmision admision) {
        this.admision = admision;
    }

    public Cfadmision getAdmision() {
        return admision;
    }

    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    public Cnconsclin getConsulta() {
        return consulta;
    }

    public void setConsecutivoFactura(Long consecutivoFactura) {
        this.consecutivoFactura = consecutivoFactura;
    }

    public Long getConsecutivoFactura() {
        return consecutivoFactura;
    }

    public Long validarLong(Object valor) {
        return valor == null ? null : Long.parseLong(valor.toString());
    }

    public Double validarDouble(Object valor) {
        return valor == null ? null : Double.parseDouble(valor.toString());
    }

    public String validarString(Object valor) {
        return valor == null ? null : valor.toString();
    }

    public void setInterConsultaUsuarioBean(InterConsultaUsuarioBean interConsultaUsuarioBean) {
        this.interConsultaUsuarioBean = interConsultaUsuarioBean;
    }

    public InterConsultaUsuarioBean getInterConsultaUsuarioBean() {
        return interConsultaUsuarioBean;
    }

    public void setListViasAcceso(List listViasAcceso) {
        this.listViasAcceso = listViasAcceso;
    }

    public List getListViasAcceso() {
        if (listViasAcceso == null || listViasAcceso.isEmpty()) {
            listViasAcceso = new ArrayList();
            listViasAcceso.add(new SelectItem("LC", "Laparoscopia"));
            listViasAcceso.add(new SelectItem("LT", "Laparotomia"));
            listViasAcceso.add(new SelectItem("VA", "Vaginal"));
        }
        return listViasAcceso;
    }

    public void setLsthemocomponentes(List<SelectItem> lsthemocomponentes) {
        this.lsthemocomponentes = lsthemocomponentes;
    }

    public List<SelectItem> getLsthemocomponentes() {
        if (lsthemocomponentes == null || lsthemocomponentes.isEmpty()) {
            lsthemocomponentes = new ArrayList<SelectItem>();
            lsthemocomponentes.add(new SelectItem("", "Seleccione ..."));
            lsthemocomponentes.add(new SelectItem("GR", "Globulos Rojos"));
            lsthemocomponentes.add(new SelectItem("PQ", "Plaquetas"));
            lsthemocomponentes.add(new SelectItem("PL", "Plasma"));
            lsthemocomponentes.add(new SelectItem("SC", "Sangre Completa"));
        }
        return lsthemocomponentes;
    }

    public void setPATOLOGIA_CONGELA(String pATOLOGIA_CONGELA) {
        this.PATOLOGIA_CONGELA = pATOLOGIA_CONGELA;
    }

    public String getPATOLOGIA_CONGELA() {
        return PATOLOGIA_CONGELA;
    }

    public void setPATOLOGIA_OTRO(String pATOLOGIA_OTRO) {
        this.PATOLOGIA_OTRO = pATOLOGIA_OTRO;
    }

    public String getPATOLOGIA_OTRO() {
        return PATOLOGIA_OTRO;
    }

    public void setVIA_ACCESO(String vIA_ACCESO) {
        this.VIA_ACCESO = vIA_ACCESO;
    }

    public String getVIA_ACCESO() {
        return VIA_ACCESO;
    }

    public void setPARTICULAR(String pARTICULAR) {
        this.PARTICULAR = pARTICULAR;
    }

    public String getPARTICULAR() {
        return PARTICULAR;
    }

    public void setTIPO_USUARIO(String tIPO_USUARIO) {
        this.TIPO_USUARIO = tIPO_USUARIO;
    }

    public String getTIPO_USUARIO() {
        return TIPO_USUARIO;
    }

    public void setHEMOCOMPONENTE(String hEMOCOMPONENTE) {
        this.HEMOCOMPONENTE = hEMOCOMPONENTE;
    }

    public String getHEMOCOMPONENTE() {
        return HEMOCOMPONENTE;
    }

    public void setOBSERVACION(String oBSERVACION) {
        this.OBSERVACION = oBSERVACION;
    }

    public String getOBSERVACION() {
        return OBSERVACION;
    }

    public void setHORA_SISTEMA_DATE(Date hORA_SISTEMA_DATE) {
        this.HORA_SISTEMA_DATE = hORA_SISTEMA_DATE;
    }

    public Date getHORA_SISTEMA_DATE() {
        return HORA_SISTEMA_DATE;
    }
}
