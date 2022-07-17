//=======================================================================
// ARCHIVO AutorizacionServicioUsuarioBean.java
// FECHA CREACI�N: 16/07/2015
// AUTOR: Carlos Andres Vargas Roa
// Descripci�n: Datos correspondientes Autorizacion de servicios.
//=======================================================================

package org.profamilia.hc.view.backing.comun.conducta;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chautoriserv;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chdetaldescr;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chserviautor;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpempresa;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptipconcl;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.dto.Cvcontrato;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.clinico.comun.Cie10Bean;
import org.profamilia.hc.view.backing.clinico.consultorio.ReimprimirDocumentosBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorServicioBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//==============================================================================
//  CLASE ReferenciaUsuarioBean
//==============================================================================

public class AutorizacionServicioUsuarioBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    private static final int ACTIVAR_SERVICIO_MEDICO = 0;

    private Map lstCie10;

    private boolean renderBuscador;

    private int selectedIndex;

    private UIInput itServicios;

    private UIInput itCodigo;

    /** Almacena la formula que se desea eliminar de la base de datos */
    private Chserviautor servicioClon;

    /** */
    private boolean deshabilitarServicios;

    private boolean deshabilitarCodigo;
    
    private boolean deshabilitaBoton;

    /** Variable que almacena El nombre del servicio */
    private String servicios;

    /** Variable que almacena la descripcion del servicio */
    private String servicioss;

    /** Variable que almacena la cantidad de servicios  */
    private Integer cantidad;

    /** Variable que almacena el codigo cups  */
    private String cupsCodigo;

    /**Almacena la lista de servicios  */
    private List<Chserviautor> lstServicioss;

    private static final int ACTIVAR_BUSCADOR = 1;

    /** Almacena el objeto a persistir*/
    private Chautoriserv autoriserv;

    private boolean esCirugia;

    private Long numeroUsuario;

    private String tipoServicio;

    private String tensionArterial;

    private Integer frecuenciaCardiaca;

    private Integer frecuenciaRespiratoria;

    private BigDecimal peso;

    private String hallazgos;

    private BigDecimal temperatura;

    private boolean modo_consulta;
    
    private boolean temporal;


    /** Almacena el consulta */
    private Long numeroConsulta;

    /** boolena para generoAutorizacion */
    private boolean generoAutorizacion;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private String menuBean;

    private String origenAtencion;

    private List lstPrioridad;

    private List lstCobertura;
    
    private List lstOriAtencion;

    private List lstTipoSrv;
    
    private List lstUbicacion;

    private String prioridad;

    /** Almacena el servicio que se desea guardar */
    private Cpservicio servicio;

    private String codigoCups;

    private String descripServicio;

    private String codigoServicio;

    private Integer tipoDiagnostico;

    private UIInput inputDiagnostico;

    private UIInput inputDiagnostico1;

    private UIInput inputDiagnostico2;

    private String codigoDiagnostico;

    private String codigoDiagnostico1;

    private String codigoDiagnostico2;

    private String descDiagnostico;

    private String descDiagnostico1;

    private String descDiagnostico2;

    private Crdgncie10 diagPrincipal;

    private Crdgncie10 diagRelacio1;

    private Crdgncie10 diagRelacio2;

    private String descTipoConsulta;

    private Cptipconcl tipoConsulta;

    private Integer tipoHistoria;

    /** Almacena si es consulta de ilve */
    private boolean esIlve = false;

    private String descOrigenAtencion;

    private Integer EmprePromilia;

    /** Almacena la tabla de la formulaci�n */
    private HtmlDataTable dtServicio;

    /** Lista que almacena la lista de Entidades */
    private List<SelectItem> listEntidadAdm;

    private boolean renderUbicacion;

    private boolean renderEntidadC;
    private boolean renderEntidadS;
    private boolean renderEntidadO;
    
    private Cvcontrato contrato;
    
    private Cnconsclin consclin;
    
    private Chimprdiag imprdiag;
    
    private Chdetaldescr detaldesc;
    
    private Cpempresa empresa;

    private boolean mostrarCie10;

    private boolean desHabilitarDiagnosticoPrincipal; 

    private boolean disableRel1; 
    
    private boolean disableRel2; 

    private Integer edad;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public AutorizacionServicioUsuarioBean() {

    }

    //ACTIONS  

    public void init() {
        lstServicioss = new ArrayList<Chserviautor>();
        inicializarAutorizacionServicio();
    }

    public void inicializarAutorizacionServicio() {

        generoAutorizacion = false;
        EmprePromilia = 1;
        deshabilitaBoton = false;
        modo_consulta = false;

        if (usuario != null && usuario.getHusdfechanacim() != null) {
            edad = calcularEdad(usuario.getHusdfechanacim(), new Date());
        }

        try {
            if (numeroConsulta != null) {
                empresa = 
                        this.serviceLocator.getClinicoService().getEmpresa(1);

                autoriserv = 
                        this.getServiceLocator().getClinicoService().getAutorizacion(numeroConsulta);
                        
                consclin = 
                        this.getServiceLocator().getClinicoService().getConsinfacByNumero(numeroConsulta);
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }

        try {
            lstServicioss = 
                    this.getServiceLocator().getClinicoService().getListServicioss(numeroConsulta);
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (lstServicioss == null || lstServicioss.isEmpty()) {
            lstServicioss = new ArrayList<Chserviautor>();
        }
        
        if (autoriserv == null) {
            autoriserv = new Chautoriserv();
            

            autoriserv.setHaulconsulta(numeroConsulta);
            if (consclin != null) {
                try {
                    contrato = 
                        this.getServiceLocator().getClinicoService().getCvcontratoClinica(consclin.getCconclinic(),consclin.getCconcontra());
                    imprdiag = 
                        this.getServiceLocator().getClinicoService().getImresionDiagnostica(numeroConsulta,1);
                    detaldesc = 
                        this.getServiceLocator().getCirugiaService().getDetalleDescripcion(numeroConsulta);
                
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
            
            if (contrato != null && contrato.getCcnccodsgs() != null) {
                autoriserv.setHaucentidad(contrato.getCcnccodsgs());
            }

            if (autoriserv.getHaucentidad() != null && autoriserv.getHaucentidad().length() > 3 && autoriserv.getHaucentidad().substring(0,3).equals("ESS")) {
                autoriserv.setHauecobersalud("S");
                renderEntidadS = true;
                renderEntidadC = false;
                renderEntidadO = false;
            } else if (autoriserv.getHaucentidad() != null && autoriserv.getHaucentidad().length() > 3 && autoriserv.getHaucentidad().substring(0,3).equals("EPS")) {
                autoriserv.setHauecobersalud("C");
                renderEntidadS = false;
                renderEntidadC = true;
                renderEntidadO = false;
            } else {
                autoriserv.setHauecobersalud("O");
                renderEntidadS = false;
                renderEntidadC = false;
                renderEntidadO = true;
            }
            
            autoriserv.setHaucorigeatenc("13");
            autoriserv.setHauctiposervi("Servicios electivos");
            if (imprdiag != null) {
                autoriserv.setHaucdiagnprinc(imprdiag.getHidcdiagprin());
                autoriserv.setHaucdiagrelac1(imprdiag.getHidcdiagrela1());
                autoriserv.setHaucdiagrelac2(imprdiag.getHidcdiagrela2());
            } else {
                if (detaldesc != null) {
                    autoriserv.setHaucdiagnprinc(detaldesc.getHddcdiagnprinc());
                    autoriserv.setHaucdiagrelac1(detaldesc.getHddcdiagnrelac());
                    autoriserv.setHaucdiagrelac2(null);
                }
            }
        } else {
        
            codigoDiagnostico = autoriserv.getHaucdiagnprinc();
            codigoDiagnostico1 = autoriserv.getHaucdiagrelac1();
            codigoDiagnostico2 = autoriserv.getHaucdiagrelac2();
        
            deshabilitaBoton = true;
            modo_consulta = true;
           
        }
        
        

        if (codigoCups != null) {
            try {
                servicio = 
                        this.serviceLocator.getClinicoService().getDescripcionCupsCompleto(codigoCups);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (servicio != null && servicio.getCsvccodcups() != null) {
                descripServicio = servicio.getCsvcnombre();
            }
        }

        if (servicio != null) {
            try {
                tipoConsulta = 
                        this.serviceLocator.getClinicoService().getDescripcionTipoConsulta(servicio.getCsvntipcon());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (tipoConsulta != null) {
                descTipoConsulta = tipoConsulta.getCtlcdescri();
            }
        }

        if (codigoDiagnostico != null) {
            try {
                diagPrincipal = 
                        this.serviceLocator.getClinicoService().getCIE10PorCodigo(codigoDiagnostico.toUpperCase());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (diagPrincipal != null && 
                diagPrincipal.getCdcccodigo() != null) {
                descDiagnostico = diagPrincipal.getCdccdescri();
            }
        }

        if (codigoDiagnostico1 != null) {
            try {
                diagRelacio1 = 
                        this.serviceLocator.getClinicoService().getCIE10PorCodigo(codigoDiagnostico1.toUpperCase());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (diagRelacio1 != null && 
                diagPrincipal.getCdcccodigo() != null) {
                descDiagnostico1 = diagRelacio1.getCdccdescri();
            }
        }

        if (codigoDiagnostico2 != null) {
            try {
                diagRelacio2 = 
                        this.serviceLocator.getClinicoService().getCIE10PorCodigo(codigoDiagnostico2.toUpperCase());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (diagRelacio2 != null && diagRelacio2.getCdcccodigo() != null) {
                descDiagnostico2 = diagRelacio2.getCdccdescri();
            }
        }

        if (origenAtencion != null) {
            if (origenAtencion.equals("13")) {
                descOrigenAtencion = "ENFERMEDAD GENERAL";
            } else if (origenAtencion.equals("10")) {
                descOrigenAtencion = "SOSPECHA ABUSO SEXUAL";
            } else if (origenAtencion.equals("11")) {
                descOrigenAtencion = "SOSPECHA VIOLENCIA SEXUAL";
            } else {

            }
        }
    }

    //--------------------------------------------------------------------------
    //  Metodo esValido que garantiza que el registro fue guardado exitosamente
    //--------------------------------------------------------------------------

    public boolean esValido() {
        boolean esValido = false;
        Chautoriserv autoriservAux = null;
        if (numeroConsulta != null) {

            try {
                autoriservAux = 
                        this.getServiceLocator().getClinicoService().getAutorizacion(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (autoriservAux != null) {
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

    public void generarAutorizacion() {
        autoriserv.setHaucoperador(userName());
        autoriserv.setHaudfecharegis(new Date());
        autoriserv.setHauctiposervi(tipoServicio);
        autoriserv.setHaunclinica(this.getClinica().getCclncodigo());

        if (lstServicioss == null || lstServicioss.isEmpty()) {
            FacesUtils.addErrorMessage("Error. Debe registrar al menos un Servicio");
        } else {
            try {
                this.getServiceLocator().getClinicoService().saveAutorizacion(autoriserv, 
                                                                          lstServicioss);
                generoAutorizacion = true;
                deshabilitaBoton = true;
                modo_consulta = true;
                generarPDF();
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            } catch (ModelException e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            }
        }
    }

    public void generarPDF() {
       Chconsulta consultaaux = new Chconsulta();
       ReimprimirDocumentosBean bean = (ReimprimirDocumentosBean)FacesUtils.getManagedBean("reimprimirDocumentosBean");
       byte[] result = null;
       Chusuario usuario = null;
       try {
           consultaaux = 
                  this.getServiceLocator().getClinicoService().getConsultaActual(numeroConsulta);
           usuario = 
                  this.getServiceLocator().getClinicoService().getUsuario(consultaaux.getHcolusuario().getHuslnumero());
       } catch (ModelException e) {
           e.printStackTrace();
       }

       if (bean != null && consultaaux != null && usuario != null) {       
           bean.setDocumentoSelect(CONDUCTA_AUTORIZACION_SERVICIO);
           bean.setUsuario(usuario);
           bean.setConsulta(consultaaux);
           result = bean.generarPdfAutorizacionServicio();
       }
       if (result != null) {
           generoAutorizacion = true;
           PdfServletUtils.showPdfDocument(result,"AutorizacionServicios.pdf", false);
       } else {
           FacesUtils.addErrorMessage("No pudo generar el reporte ");
       }
    }

    public void renderServicios() {
        renderBuscador = true;
        selectedIndex = ACTIVAR_BUSCADOR;
    }

    /**
     * @param valueChangeEvent
     */
    public void setServicios(ValueChangeEvent valueChangeEvent) {
        setServicios((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void eliminarServicios() {
        this.servicioClon = (Chserviautor)this.dtServicio.getRowData();
        this.lstServicioss.remove(servicioClon);
        FacesUtils.addInfoMessage("Se elimino correctamente ");
    }

    public void aceptarServicio() {
        BuscadorServicioBean servicioAux = 
            (BuscadorServicioBean)FacesUtils.getManagedBean("buscadorServicioBean");


        if (servicioAux != null && servicioAux.getServicioSelect() != null) {
            itServicios.setValue(servicioAux.getServicioSelect().getCsvcnombre());
            itCodigo.setValue(servicioAux.getServicioSelect().getCsvccodcups());

            servicioss = servicioAux.getServicioSelect().getCsvccodigo();
            deshabilitarServicios = true;
            deshabilitarCodigo = true;

        }
        selectedIndex = ACTIVAR_SERVICIO_MEDICO;
        renderBuscador = false;
        FacesUtils.resetManagedBean("buscadorServicioBean");
    }

    public void agregarAutorizacion() {
        Chserviautor serviau;

        generoAutorizacion = false;
        serviau = new Chserviautor();
        if (servicioss != null && !servicioss.equals("") && cantidad != null && 
            !cantidad.equals("0") && cupsCodigo != null && !cupsCodigo.equals("")) {
            serviau.getId().setHselconsulta(numeroConsulta);
            serviau.setHsecnombreserv(servicioss);
            serviau.setHsencantiservi(cantidad);
            serviau.setHsencodigocups(cupsCodigo);

            lstServicioss.add(serviau);
            servicioss = "";
            cantidad = null;
            cupsCodigo = null;
            deshabilitarServicios = false;
        } else {
            FacesUtils.addErrorMessage("Debe Registrar todos los datos");
        }
    }

    public void editarServicios() {
        this.servicioClon = (Chserviautor)this.dtServicio.getRowData();
        servicioss = servicioClon.getHsecnombreserv();
        cupsCodigo = servicioClon.getHsencodigocups();

        cantidad = servicioClon.getHsencantiservi();

        deshabilitarServicios = false;
        this.lstServicioss.remove(servicioClon);
        FacesUtils.addInfoMessage("Se elimino correctamente ");
    }


    // ACCESSORS


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
     * @param tensionArterial
     */
    public void setTensionArterial(String tensionArterial) {
        this.tensionArterial = tensionArterial;
    }

    /**
     * @return
     */
    public String getTensionArterial() {
        return tensionArterial;
    }

    /**
     * @param frecuenciaCardiaca
     */
    public void setFrecuenciaCardiaca(Integer frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    /**
     * @return
     */
    public Integer getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    /**
     * @param frecuenciaRespiratoria
     */
    public void setFrecuenciaRespiratoria(Integer frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }

    /**
     * @return
     */
    public Integer getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    /**
     * @param peso
     */
    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    /**
     * @return
     */
    public BigDecimal getPeso() {
        return peso;
    }

    /**
     * @param hallazgos
     */
    public void setHallazgos(String hallazgos) {
        this.hallazgos = hallazgos;
    }

    /**
     * @return
     */
    public String getHallazgos() {
        return hallazgos;
    }

    /**
     * @param temperatura
     */
    public void setTemperatura(BigDecimal temperatura) {
        this.temperatura = temperatura;
    }

    /**
     * @return
     */
    public BigDecimal getTemperatura() {
        return temperatura;
    }

    public void setOrigenAtencion(String origenAtencion) {
        this.origenAtencion = origenAtencion;
    }

    public String getOrigenAtencion() {
        return origenAtencion;
    }

    public void setLstPrioridad(List lstPrioridad) {
        this.lstPrioridad = lstPrioridad;
    }

    public List getLstPrioridad() {
        if (lstPrioridad == null) {
            lstPrioridad = new ArrayList();
            lstPrioridad.add(new SelectItem("PR", "Prioritaria"));
            lstPrioridad.add(new SelectItem("NP", "No Prioritaria"));

        }

        return lstPrioridad;
    }

    public void setLstCobertura(List lstCobertura) {
        this.lstCobertura = lstCobertura;
    }

    public List getLstCobertura() {
        if (lstCobertura == null) {
            lstCobertura = new ArrayList();
            lstCobertura.add(new SelectItem("C", "Regimen Contributivo"));
            lstCobertura.add(new SelectItem("S", "Regimen Subsidiado - total"));
            lstCobertura.add(new SelectItem("R", "Regimen Subsidiado - parcial"));
            lstCobertura.add(new SelectItem("P", "Poblaci�n pobre No asegurada con SISBEN"));
            lstCobertura.add(new SelectItem("X", "Poblaci�n Pobre no asegurada sin SISBEN"));
            lstCobertura.add(new SelectItem("D", "Desplazado"));
            lstCobertura.add(new SelectItem("A", "Plan adicional de salud"));
            lstCobertura.add(new SelectItem("O", "Otro"));
        }
        return lstCobertura;
    }

    public void setLstOriAtencion(List lstOriAtencion) {
        this.lstOriAtencion = lstOriAtencion;
    }

    public List getLstOriAtencion() {
        if (lstOriAtencion == null) {
            lstOriAtencion = new ArrayList();
            lstOriAtencion.add(new SelectItem(13, "Enfermedad General"));
            lstOriAtencion.add(new SelectItem(14, "Enfermedad Profesional"));
            lstOriAtencion.add(new SelectItem(1, "Accidente de trabajo"));
            lstOriAtencion.add(new SelectItem(2, "Accidente de tr�nsito"));
            lstOriAtencion.add(new SelectItem(6, "Evento Catastr�fico"));
        }
        return lstOriAtencion;
    }

    public void setLstTipoSrv(List lstTipoSrv) {
        this.lstTipoSrv = lstTipoSrv;
    }

    public List getLstTipoSrv() {
        if (lstTipoSrv == null) {
            lstTipoSrv = new ArrayList();
            lstTipoSrv.add(new SelectItem("Servicios electivos", "Servicios electivos"));
            lstTipoSrv.add(new SelectItem("Posterior a la atenci�n inicial de urgencias", "Posterior a la atenci�n inicial de urgencias"));
        }
        return lstTipoSrv;
    }

    public void setLstUbicacion(List lstUbicacion) {
        this.lstUbicacion = lstUbicacion;
    }

    public List getLstUbicacion() {
        if (lstUbicacion == null) {
            lstUbicacion = new ArrayList();
            lstUbicacion.add(new SelectItem("C", "Consulta Externa"));
            lstUbicacion.add(new SelectItem("U", "Urgencias"));
            lstUbicacion.add(new SelectItem("H", "Hospitalizaci�n"));
        }
        return lstUbicacion;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getPrioridad() {
        return prioridad;
    }


    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }

    public void setCodigoCups(String codigoCups) {
        this.codigoCups = codigoCups;
    }

    public String getCodigoCups() {
        return codigoCups;
    }

    public void setDescripServicio(String descripServicio) {
        this.descripServicio = descripServicio;
    }

    public String getDescripServicio() {
        return descripServicio;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setTipoDiagnostico(Integer tipoDiagnostico) {
        this.tipoDiagnostico = tipoDiagnostico;
    }

    public Integer getTipoDiagnostico() {
        return tipoDiagnostico;
    }

    public void setCodigoDiagnostico(String codigoDiagnostico) {
        this.codigoDiagnostico = codigoDiagnostico;
    }

    public String getCodigoDiagnostico() {
        return codigoDiagnostico;
    }

    public void setCodigoDiagnostico1(String codigoDiagnostico1) {
        this.codigoDiagnostico1 = codigoDiagnostico1;
    }

    public String getCodigoDiagnostico1() {
        return codigoDiagnostico1;
    }

    public void setCodigoDiagnostico2(String codigoDiagnostico2) {
        this.codigoDiagnostico2 = codigoDiagnostico2;
    }

    public String getCodigoDiagnostico2() {
        return codigoDiagnostico2;
    }


    public void setDiagPrincipal(Crdgncie10 diagPrincipal) {
        this.diagPrincipal = diagPrincipal;
    }

    public Crdgncie10 getDiagPrincipal() {
        return diagPrincipal;
    }

    public void setDescDiagnostico(String descDiagnostico) {
        this.descDiagnostico = descDiagnostico;
    }

    public String getDescDiagnostico() {
        return descDiagnostico;
    }

    public void setDescDiagnostico1(String descDiagnostico1) {
        this.descDiagnostico1 = descDiagnostico1;
    }

    public String getDescDiagnostico1() {
        return descDiagnostico1;
    }

    public void setDescDiagnostico2(String descDiagnostico2) {
        this.descDiagnostico2 = descDiagnostico2;
    }

    public String getDescDiagnostico2() {
        return descDiagnostico2;
    }

    public void setDiagRelacio1(Crdgncie10 diagRelacio1) {
        this.diagRelacio1 = diagRelacio1;
    }

    public Crdgncie10 getDiagRelacio1() {
        return diagRelacio1;
    }

    public void setDiagRelacio2(Crdgncie10 diagRelacio2) {
        this.diagRelacio2 = diagRelacio2;
    }

    public Crdgncie10 getDiagRelacio2() {
        return diagRelacio2;
    }

    public void setDescTipoConsulta(String descTipoConsulta) {
        this.descTipoConsulta = descTipoConsulta;
    }

    public String getDescTipoConsulta() {
        return descTipoConsulta;
    }

    public void setTipoConsulta(Cptipconcl tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public Cptipconcl getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    public Integer getTipoHistoria() {
        return tipoHistoria;
    }

    public void setEsIlve(boolean esIlve) {
        this.esIlve = esIlve;
    }

    public boolean isEsIlve() {
        return esIlve;
    }

    public void setDescOrigenAtencion(String descOrigenAtencion) {
        this.descOrigenAtencion = descOrigenAtencion;
    }

    public String getDescOrigenAtencion() {
        return descOrigenAtencion;
    }

    public void setAutoriserv(Chautoriserv autoriserv) {
        this.autoriserv = autoriserv;
    }

    public Chautoriserv getAutoriserv() {
        return autoriserv;
    }

    public void setGeneroAutorizacion(boolean generoAutorizacion) {
        this.generoAutorizacion = generoAutorizacion;
    }

    public boolean isGeneroAutorizacion() {
        return generoAutorizacion;
    }

    public void setEmprePromilia(Integer emprePromilia) {
        this.EmprePromilia = emprePromilia;
    }

    public Integer getEmprePromilia() {
        return EmprePromilia;
    }

    public void setRenderBuscador(boolean renderBuscador) {
        this.renderBuscador = renderBuscador;
    }

    public boolean isRenderBuscador() {
        return renderBuscador;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public String getServicios() {
        return servicios;
    }

    public void setItServicios(UIInput itServicios) {
        this.itServicios = itServicios;
    }

    public UIInput getItServicios() {
        return itServicios;
    }

    public void setDeshabilitarServicios(boolean deshabilitarServicios) {
        this.deshabilitarServicios = deshabilitarServicios;
    }

    public boolean isDeshabilitarServicios() {
        return deshabilitarServicios;
    }

    public void setDtServicio(HtmlDataTable dtServicio) {
        this.dtServicio = dtServicio;
    }

    public HtmlDataTable getDtServicio() {
        return dtServicio;
    }


    public void setServicioss(String servicioss) {
        this.servicioss = servicioss;
    }

    public String getServicioss() {
        return servicioss;
    }

    public void setItCodigo(UIInput itCodigo) {
        this.itCodigo = itCodigo;
    }

    public UIInput getItCodigo() {
        return itCodigo;
    }

    public void setDeshabilitarCodigo(boolean deshabilitarCodigo) {
        this.deshabilitarCodigo = deshabilitarCodigo;
    }

    public boolean isDeshabilitarCodigo() {
        return deshabilitarCodigo;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCupsCodigo(String cupsCodigo) {
        this.cupsCodigo = cupsCodigo;
    }

    public String getCupsCodigo() {
        return cupsCodigo;
    }

    public void setLstServicioss(List<Chserviautor> lstServicioss) {
        this.lstServicioss = lstServicioss;
    }

    public List<Chserviautor> getLstServicioss() {
        return lstServicioss;
    }

    public void setDeshabilitaBoton(boolean deshabilitaBoton) {
        this.deshabilitaBoton = deshabilitaBoton;
    }

    public boolean isDeshabilitaBoton() {
        return deshabilitaBoton;
    }

    public void setModo_consulta(boolean modo_consulta) {
        this.modo_consulta = modo_consulta;
    }

    public boolean isModo_consulta() {
        return modo_consulta;
    }

    public void setTemporal(boolean temporal) {
        this.temporal = temporal;
    }

    public boolean isTemporal() {
        return temporal;
    }
    
    public void setListEntidadAdm(List<SelectItem> listEntidadAdm) {
        this.listEntidadAdm = listEntidadAdm;
    }

    public List<SelectItem> getListEntidadAdm() {
        if (listEntidadAdm == null || listEntidadAdm.isEmpty()) {
            listEntidadAdm = new ArrayList<SelectItem>();
            ArrayList<Cpentidadadm> listEntidadAdmAux = null;
            try {
                listEntidadAdmAux = 
                        (ArrayList<Cpentidadadm>)this.serviceLocator.getClinicoService().getEntidadAdm();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listEntidadAdmAux.isEmpty()) {

                Iterator it = listEntidadAdmAux.iterator();
                int i = 0;
                listEntidadAdm.add(new SelectItem("", 
                                                  "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listEntidadAdm.add(new SelectItem(listEntidadAdmAux.get(i).getCeaccodigo(), 
                                                      "(" + listEntidadAdmAux.get(i).getCeaccodigo() + ") " + listEntidadAdmAux.get(i).getCeacnombre()));
                    i++;
                }
            }
        }
        return listEntidadAdm;
    }

    public void changeUbicacion() {
        if (autoriserv.getHaueubicapacie() != null && autoriserv.getHaueubicapacie().equals("H")) {
            renderUbicacion = true;
        } else {
            renderUbicacion = false;
            autoriserv.setHaucservhospi(null);
            autoriserv.setHauncamahospi(null);
        }
    }

    /**
     * @param renderUbicacion
     */
    public void setRenderUbicacion(boolean renderUbicacion) {
        this.renderUbicacion = renderUbicacion;
    }

    /**
     * @return
     */
    public boolean isRenderUbicacion() {
        return renderUbicacion;
    }

    /**
     * @param renderEntidadC
     */
    public void setRenderEntidadC(boolean renderEntidadC) {
        this.renderEntidadC = renderEntidadC;
    }

    /**
     * @return
     */
    public boolean isRenderEntidadC() {
        return renderEntidadC;
    }

    /**
     * @param renderEntidadS
     */
    public void setRenderEntidadS(boolean renderEntidadS) {
        this.renderEntidadS = renderEntidadS;
    }

    /**
     * @return
     */
    public boolean isRenderEntidadS() {
        return renderEntidadS;
    }

    /**
     * @param renderEntidadO
     */
    public void setRenderEntidadO(boolean renderEntidadO) {
        this.renderEntidadO = renderEntidadO;
    }

    /**
     * @return
     */
    public boolean isRenderEntidadO() {
        return renderEntidadO;
    }

    /**
     * @param valueChangeEvent
     */
    public void setUbicacionSelect(ValueChangeEvent valueChangeEvent) {
        autoriserv.setHaueubicapacie((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setEntidadSelect(ValueChangeEvent valueChangeEvent) {
        autoriserv.setHaucentidad((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void mostrarDiagnosticoPrincipal() {
        Cie10Bean cie10;
        if (autoriserv != null) {
            autoriserv.setHaucdiagnprinc("");
        }

        cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");
        cie10.setDiagnosticoPrincipal(true);
        cie10.setDiagnosticoRelacionado1(false);
        cie10.setDiagnosticoRelacionado2(false);
        cie10.setDiagnosticoRelacionado3(false);
        mostrarCie10 = true;
        selectedIndex = ACTIVAR_BUSCADOR;
    }

    public void mostrarDiagnosticoRelacionado1() {
        Cie10Bean cie10;
        if (autoriserv != null) {
            autoriserv.setHaucdiagrelac1("");
        }
        cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");
        cie10.setDiagnosticoPrincipal(false);
        cie10.setDiagnosticoRelacionado1(true);
        cie10.setDiagnosticoRelacionado2(false);
        cie10.setDiagnosticoRelacionado3(false);
        mostrarCie10 = true;
        selectedIndex = ACTIVAR_BUSCADOR;
    }

    public void mostrarDiagnosticoRelacionado2() {
        Cie10Bean cie10;
        if (autoriserv != null) {
            autoriserv.setHaucdiagrelac2("");
        }

        cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");
        cie10.setDiagnosticoPrincipal(false);
        cie10.setDiagnosticoRelacionado1(false);
        cie10.setDiagnosticoRelacionado2(true);
        cie10.setDiagnosticoRelacionado3(false);
        selectedIndex = ACTIVAR_BUSCADOR;
        mostrarCie10 = true;
    }

    public void aceptarDiagnostico() {

        Cie10Bean cie10;
        cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");

        if (cie10 != null && cie10.getCie10Select() != null) {

            if (cie10.isDiagnosticoPrincipal()) {
                autoriserv.setHaucdiagnprinc(cie10.getCie10Select().getCdcccodigo());
                inputDiagnostico.setValue(cie10.getCie10Select().getCdcccodigo());
                descDiagnostico = cie10.getCie10Select().getCdccdescri();
            }

            if (cie10.isDiagnosticoRelacionado1()) {
                autoriserv.setHaucdiagrelac1(cie10.getCie10Select().getCdcccodigo());
                inputDiagnostico1.setValue(cie10.getCie10Select().getCdcccodigo());
                descDiagnostico1 = 
                        cie10.getCie10Select().getCdccdescri();
            }

            if (cie10.isDiagnosticoRelacionado2()) {
                autoriserv.setHaucdiagrelac2(cie10.getCie10Select().getCdcccodigo());
                inputDiagnostico2.setValue(cie10.getCie10Select().getCdcccodigo());
                descDiagnostico2 = 
                        cie10.getCie10Select().getCdccdescri();
            }

        } else {

            if (cie10 != null && cie10.isDiagnosticoPrincipal())
                descDiagnostico = null;

            if (cie10 != null && cie10.isDiagnosticoRelacionado1())
                descDiagnostico1 = null;

            if (cie10 != null && cie10.isDiagnosticoRelacionado2())
                descDiagnostico2 = null;

        }

        mostrarCie10 = false;
        selectedIndex = ACTIVAR_SERVICIO_MEDICO;
        cie10.clear();

    }

    public void changeEntidad() {
        if (autoriserv.getHaucentidad() != null && autoriserv.getHaucentidad().length() > 3 && autoriserv.getHaucentidad().substring(0,3).equals("ESS")) {
            autoriserv.setHauecobersalud("S");
            renderEntidadS = true;
            renderEntidadC = false;
            renderEntidadO = false;
        } else if (autoriserv.getHaucentidad() != null && autoriserv.getHaucentidad().length() > 3 && autoriserv.getHaucentidad().substring(0,3).equals("EPS")) {
            autoriserv.setHauecobersalud("C");
            renderEntidadS = false;
            renderEntidadC = true;
            renderEntidadO = false;
        } else {
            autoriserv.setHauecobersalud("O");
            renderEntidadS = false;
            renderEntidadC = false;
            renderEntidadO = true;
        }
    }


    public void changeDiagnosticoPrincipal() {

        List validacionPrincipal1 = null;
        descDiagnostico = null;
        if (autoriserv != null) {
            if (autoriserv.getHaucdiagnprinc() != null && 
                !autoriserv.getHaucdiagnprinc().equals("")) {
                try {
                    diagPrincipal = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(autoriserv.getHaucdiagnprinc().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagPrincipal != null && diagPrincipal.getCdcccodigo() != null) {
                    descDiagnostico = diagPrincipal.getCdccdescri();
                    validacionPrincipal1 = 
                            this.serviceLocator.getClinicoService().getVerificacionCie10(diagPrincipal, 
                                                                                         usuario.getHusesexo(), 
                                                                                         "1", 
                                                                                         edad, 
                                                                                         "S");

                    if (validacionPrincipal1 != null && 
                        !validacionPrincipal1.isEmpty()) {
                        if (validacionPrincipal1.get(1) != null) {
                            FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_PRINCIPAL + 
                                                       validacionPrincipal1.get(1));
                        }
                    }
                }

                if (descDiagnostico == null || 
                    descDiagnostico.equals("")) {
                    FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_PRINCIPAL_NO_VALIDO);
                }
            } else {
                descDiagnostico = "";
            }
        }
    }


    public void changeDiagnosticoRelacionado1() {

        descDiagnostico1 = null;
        List validacionRelacionado1 = null;

        if (autoriserv != null && autoriserv.getHaucdiagrelac1() != null && 
                !autoriserv.getHaucdiagrelac1().equals("")) {
           try {
              diagRelacio1 = 
                       this.serviceLocator.getClinicoService().getCIE10PorCodigo(autoriserv.getHaucdiagrelac1().toUpperCase());
           } catch (ModelException e) {
              e.printStackTrace();
           }

           if (diagRelacio1 != null && diagRelacio1.getCdcccodigo() != null) {
                descDiagnostico1 = diagRelacio1.getCdccdescri();
               validacionRelacionado1 = 
                        this.serviceLocator.getClinicoService().getVerificacionCie10(diagRelacio1, 
                                                                                     usuario.getHusesexo(), 
                                                                                     "1", 
                                                                                     edad, 
                                                                                     "N");

           if (validacionRelacionado1 != null && 
                    !validacionRelacionado1.isEmpty()) {
               if (validacionRelacionado1.get(1) != null) {
                    FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_RELACIONADO1 + 
                                              validacionRelacionado1.get(1));
               }
           }
        }
          

        if (descDiagnostico1 == null || 
             descDiagnostico1.equals("")) {
             FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_RELACIONADO1_NO_VALIDO);
        }
     } else {
            descDiagnostico1 = "";
     }
   }

    public void changeDiagnosticoRelacionado2() {

        descDiagnostico2 = "";
        List validacionRelacionado2 = null;

        if (autoriserv != null && autoriserv.getHaucdiagrelac2() != null && 
                !autoriserv.getHaucdiagrelac2().equals("")) {
            try {
                diagRelacio2 = 
                        this.serviceLocator.getClinicoService().getCIE10PorCodigo(autoriserv.getHaucdiagrelac2().toUpperCase());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (diagRelacio2 != null && diagRelacio2.getCdcccodigo() != null) {
                descDiagnostico2 = diagRelacio2.getCdccdescri();
                validacionRelacionado2 = 
                        this.serviceLocator.getClinicoService().getVerificacionCie10(diagRelacio2, 
                                                                                     usuario.getHusesexo(), 
                                                                                     "1", 
                                                                                     edad, 
                                                                                     "N");
            if (validacionRelacionado2 != null && 
                !validacionRelacionado2.isEmpty()) {
                if (validacionRelacionado2.get(1) != null) {
                     FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_RELACIONADO2 + 
                                                validacionRelacionado2.get(1));
                }
            }
         }

         if (descDiagnostico2 == null || 
                descDiagnostico2.equals("")) {
                FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_RELACIONADO2_NO_VALIDO);
            }
        } else {
            descDiagnostico2 = "";
        }
    }


    public void setInputDiagnostico(UIInput inputDiagnostico) {
        this.inputDiagnostico = inputDiagnostico;
    }

    public UIInput getInputDiagnostico() {
        return inputDiagnostico;
    }

    public void setInputDiagnostico1(UIInput inputDiagnostico1) {
        this.inputDiagnostico1 = inputDiagnostico1;
    }

    public UIInput getInputDiagnostico1() {
        return inputDiagnostico1;
    }

    public void setInputDiagnostico2(UIInput inputDiagnostico2) {
        this.inputDiagnostico2 = inputDiagnostico2;
    }

    public UIInput getInputDiagnostico2() {
        return inputDiagnostico2;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHaucdiagnprinc(ValueChangeEvent valueChangeEvent) {
        autoriserv.setHaucdiagnprinc((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHauecobersalud(ValueChangeEvent valueChangeEvent) {
        autoriserv.setHauecobersalud((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHaucdiagrelac1(ValueChangeEvent valueChangeEvent) {
        autoriserv.setHaucdiagrelac1((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHaucdiagrelac2(ValueChangeEvent valueChangeEvent) {
        autoriserv.setHaucdiagrelac2((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param desHabilitarDiagnosticoPrincipal
     */
    public void setDesHabilitarDiagnosticoPrincipal(boolean desHabilitarDiagnosticoPrincipal) {
        this.desHabilitarDiagnosticoPrincipal = desHabilitarDiagnosticoPrincipal;
    }

    /**
     * @return
     */
    public boolean isDesHabilitarDiagnosticoPrincipal() {
        return desHabilitarDiagnosticoPrincipal;
    }

    public void setDisableRel1(boolean disableRel1) {
        this.disableRel1 = disableRel1;
    }

    public boolean isDisableRel1() {
        return disableRel1;
    }

    public void setDisableRel2(boolean disableRel2) {
        this.disableRel2 = disableRel2;
    }

    public boolean isDisableRel2() {
        return disableRel2;
    }

    /**
     * @param mostrarCie10
     */
    public void setMostrarCie10(boolean mostrarCie10) {
        this.mostrarCie10 = mostrarCie10;
    }

    /**
     * @return
     */
    public boolean isMostrarCie10() {
        return mostrarCie10;
    }

    /**
     * @param lstCie10
     */
    public void setLstCie10(HashMap lstCie10) {
        this.lstCie10 = lstCie10;
    }

    /**
     * @return
     */
    public Map getLstCie10() {
        if (lstCie10 == null || lstCie10.isEmpty()) {
            lstCie10 = new HashMap();
            ArrayList<Crdgncie10> lstCie10Aux = null;
            try {
                lstCie10Aux = 
                        (ArrayList<Crdgncie10>)this.serviceLocator.getClinicoService().getCie10();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstCie10Aux.isEmpty()) {

                Iterator it = lstCie10Aux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstCie10.put(lstCie10Aux.get(i).getCdcccodigo().toString(), 
                                 lstCie10Aux.get(i).getCdccdescri());
                    i++;
                }
            }
        }
        return lstCie10;
    }


    public void setEmpresa(Cpempresa empresa) {
        this.empresa = empresa;
    }

    public Cpempresa getEmpresa() {
        return empresa;
    }
}

