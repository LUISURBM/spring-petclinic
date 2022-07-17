package org.profamilia.hc.view.backing.cirugia.resumen;

import java.io.ByteArrayOutputStream;
import java.io.File;

import java.math.BigDecimal;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import java.util.Set;
import java.util.StringTokenizer;

import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

import org.profamilia.hc.model.dto.Chaldrete;
import org.profamilia.hc.model.dto.Chanatopatol;
import org.profamilia.hc.model.dto.Chanestesia;
import org.profamilia.hc.model.dto.Chcanalivena;
import org.profamilia.hc.model.dto.Chcertmedico;
import org.profamilia.hc.model.dto.Chcierreanest;
import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chconducta;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chcontmedane;
import org.profamilia.hc.model.dto.Chcontrmedic;
import org.profamilia.hc.model.dto.Chcontroliqu;
import org.profamilia.hc.model.dto.Chcontroorden;
import org.profamilia.hc.model.dto.Chdescrquiru;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chdetaldescr;
import org.profamilia.hc.model.dto.Chepicrisi;
import org.profamilia.hc.model.dto.Chescvalcai;
import org.profamilia.hc.model.dto.Chevolucion;
import org.profamilia.hc.model.dto.Chevoluconsu;
import org.profamilia.hc.model.dto.Chexameelect;
import org.profamilia.hc.model.dto.Chexameimage;
import org.profamilia.hc.model.dto.Chexamelabor;
import org.profamilia.hc.model.dto.Chexameparac;
import org.profamilia.hc.model.dto.Chexamfisico;
import org.profamilia.hc.model.dto.Chformulahos;
import org.profamilia.hc.model.dto.Chformulaliq;
import org.profamilia.hc.model.dto.Chformulamed;
import org.profamilia.hc.model.dto.Chhallahistero;
import org.profamilia.hc.model.dto.Chhisteroscopia;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chincapacida;
import org.profamilia.hc.model.dto.Chinfomamogr;
import org.profamilia.hc.model.dto.Chingresoenf;
import org.profamilia.hc.model.dto.Chlogimpresi;
import org.profamilia.hc.model.dto.Chmonitoria;
import org.profamilia.hc.model.dto.Chnotaenferm;
import org.profamilia.hc.model.dto.Chnotamedica;
import org.profamilia.hc.model.dto.Chordecirugi;
import org.profamilia.hc.model.dto.Chposicanest;
import org.profamilia.hc.model.dto.Chrefepaci;
import org.profamilia.hc.model.dto.Chreferencia;
import org.profamilia.hc.model.dto.Chregisexame;
import org.profamilia.hc.model.dto.Chremihospit;
import org.profamilia.hc.model.dto.Chremision;
import org.profamilia.hc.model.dto.Chreporte;
import org.profamilia.hc.model.dto.Chsignovital;
import org.profamilia.hc.model.dto.Chtecnianest;
import org.profamilia.hc.model.dto.Chtipointerc;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chventiaerea;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.dto.Cvcontrato;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.ConverterTextoNumero;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.JasperLstReportPDF;
import org.profamilia.hc.view.util.PDFMerger;
import org.profamilia.hc.view.util.PdfServletUtils;


public class GenerarFoliosCirugiaBean extends BaseBean implements JRDataSource{

    private boolean renderDescripcion;

    private boolean renderNotasEnfermeria;

    private boolean renderEpicrisis;

    private boolean renderEvolucionMedica;

    private boolean renderControlLiquidos;

    private boolean renderControlMedicamentos;

    private boolean renderSignosVitales;

    private boolean renderCirugiaCompleta;

    private boolean renderCanalizacion;

    private boolean renderAnestesia;

    private boolean renderIngreso;

    private boolean wexito;

    private boolean generoHistoria;

    protected String NO_HISTORIA;

    protected String NOMBRES;

    protected String PER_APELLIDO;

    protected String SDO_APELLIDO;

    protected String NOMBRE;
    
    protected String ZONA;
    protected Integer ESTRATO;
    protected String NIVELEDUCATIVO;
    protected String ETNIA;
    protected String BARRIO;
    

    protected String TIPO_DOCUMENTO;

    protected String NOMBRE_PROFESIONAL;

    protected Long NUMERO_DOCUMENTO;

    protected Date FECHA_NACIMIENTO;

    protected String DIRECCION;

    protected String OCUPACION;

    protected String RESPONSABLE;

    protected Integer EDAD;

    protected String TELEFONO;

    protected String ESTADO_CIVIL;

    protected String PARENTESCO_RESPONSABLE;

    protected String SEXO;

    protected String CIUDAD;

    protected String TELEFONO_RESPONSABLE;

    protected String IMPRIMIO;

    protected String REGISTRO_MEDICO;

    protected String EPS;

    protected String MOTIVO;

    protected String ESTADO_INGRESO;

    protected String ENFERMEDAD_ACTUAL;

    protected String ANTECEDENTES;
    
    protected String CONTRATO;

    protected String RXS;

    protected String HALLAZGOS;

    protected String DIAGNOSTICO;

    protected String CONDUCTA;

    protected String EVOLUCION;

    protected String EXAMEN;

    protected String CONDICIONES_PACIENTE;

    protected Date FECHA_ING;

    protected Date FECHA_EGR;
    
    protected String TIPO_USUARIO;
    
    protected String CLINICA;

    protected Integer pagact_pdf;

    protected Chconsulta consulta;

    protected String origen;
    
    private boolean renderEscalaValoracionCaidas;

    // Orden de Impresion
    static Integer imp_datos_cirugia = 1;
    static Integer imp_ingreso_enfermeria = 2;
    static Integer imp_nota_enfermeria = 2;
    static Integer imp_canalizacion = 2;
    static Integer imp_escaladolor = 2;
    static Integer imp_signos_vitales = 2;
    static Integer imp_medicamentos = 2;
    static Integer imp_control_liquidos = 2;
    static Integer imp_evolucion = 2;
    static Integer imp_recomendaciones = 2;
    static Integer imp_descripcion_quirurgica = 2;
    static Integer imp_epicirisis = 2;
    static Integer imp_registro_anestesia = 2;
    static Integer imp_conducta = 42;
    static Integer imp_incapacidad = 43;
    static Integer imp_orden_cirugia = 44;
    static Integer imp_examenes_paraclinicos = 45;
    static Integer imp_referencia = 46;
    static Integer imp_anatomia_patologica = 47;
    static Integer imp_prescripcion_medica = 48;
    static Integer imp_control_sin_costo = 49;
    static Integer imp_examenes_imagenes = 50;
    static Integer imp_examenes_electrofisiologicos = 51;
    static Integer imp_examenes_laboratorios = 52;
    static Integer imp_interconsulta = 53;
    static Integer imp_certificado_medico = 54;
    static Integer imp_certificado_asistencia = 55;
    static Integer imp_remision_hospitalizacion = 56;
    static Integer imp_registro_examenes = 98;
    static Integer imp_nota_medica = 99;
    static Integer imp_anestesia_signos = 21;
    static Integer imp_anestesia_medicamentos = 22;
    static Integer imp_anestesia_monitoria = 23;
    static Integer imp_anestesia_ventilacion = 24;
    static Integer imp_anestesia_tecnica = 25;
    static Integer imp_anestesia_posicion = 26;
    static Integer imp_anestesia_liquidos = 27;
    static Integer imp_anestesia_cierre = 28;
    static Integer imp_escala_valoracion_caidas= 29;
    static Integer imp_referencia_paciente = 30;

    // Datos 

    protected String CENTRO;
    
    private Date FECHAHISTERO;
    private String HISTORIACLINICA;  
    private String PRIMERAPELLIDO;  
    private String SEGUNDOAPELLIDO;  
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
    private Integer edad;
    private String DIAGNOSTICO_PRESUNTIVO_EGRESO;
    private String DIAGNOSTICO_RELACIONADO_EGRESO;
    private String DIAGNOSTICO_CONFIRMADO_EGRESO;
    private String INTERPRETACION_RESULTADOS;
    private String JUSTIFICACIONES_TERAPEUTICAS;
    private String PLAN_MANEJO_AMBULATORIO;
    private String SERVICIO_INGRESO;
    private int index;


    public GenerarFoliosCirugiaBean() {
    }

    public void init() {
        renderDescripcion = false;
        renderNotasEnfermeria = false;
        renderEvolucionMedica = false;
        renderControlLiquidos = false;
        renderControlMedicamentos = false;
        renderSignosVitales = false;
        renderCirugiaCompleta = false;
        renderCanalizacion = false;
        renderIngreso = false;
        renderAnestesia = false;
        renderEscalaValoracionCaidas=false;

        pagact_pdf = 0;
    }

    /**
     * @return
     */
    public String volverConsulta() {
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
        FacesUtils.resetManagedBean("generarFoliosCirugiaBean");
        if (origen == null || !origen.equals("Imprimir")) {
            return BeanNavegacion.RUTA_IR_CONSULTAR_USUARIO_FOLIOS_CIRUGIA;
        } else {
            return BeanNavegacion.RUTA_IR_IMPRIMIR_FOLIOS;
        }
    }


    /**
     * @param renderDescripcion
     */
    public void setRenderDescripcion(boolean renderDescripcion) {
        this.renderDescripcion = renderDescripcion;
    }

    /**
     * @return
     */
    public boolean isRenderDescripcion() {
        return renderDescripcion;
    }

    /**
     * @param consulta
     */
    public void setConsulta(Chconsulta consulta) {
        this.consulta = consulta;
    }

    /**
     * @return
     */
    public Chconsulta getConsulta() {
        return consulta;
    }

    /**
     * @param origen
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param renderNotasEnfermeria
     */
    public void setRenderNotasEnfermeria(boolean renderNotasEnfermeria) {
        this.renderNotasEnfermeria = renderNotasEnfermeria;
    }

    /**
     * @return
     */
    public boolean isRenderNotasEnfermeria() {
        return renderNotasEnfermeria;
    }

    /**
     * @param renderEvolucionMedica
     */
    public void setRenderEvolucionMedica(boolean renderEvolucionMedica) {
        this.renderEvolucionMedica = renderEvolucionMedica;
    }

    /**
     * @return
     */
    public boolean isRenderEvolucionMedica() {
        return renderEvolucionMedica;
    }

    /**
     * @param renderControlLiquidos
     */
    public void setRenderControlLiquidos(boolean renderControlLiquidos) {
        this.renderControlLiquidos = renderControlLiquidos;
    }

    /**
     * @return
     */
    public boolean isRenderControlLiquidos() {
        return renderControlLiquidos;
    }

    /**
     * @param generoHistoria
     */
    public void setGeneroHistoria(boolean generoHistoria) {
        this.generoHistoria = generoHistoria;
    }

    /**
     * @return
     */
    public boolean isGeneroHistoria() {
        return generoHistoria;
    }

    /**
     * @param renderCanalizacion
     */
    public void setRenderCanalizacion(boolean renderCanalizacion) {
        this.renderCanalizacion = renderCanalizacion;
    }

    /**
     * @return
     */
    public boolean isRenderCanalizacion() {
        return renderCanalizacion;
    }


    /**
     * @param renderAnestesia
     */
    public void setRenderAnestesia(boolean renderAnestesia) {
        this.renderAnestesia = renderAnestesia;
    }

    /**
     * @return
     */
    public boolean isRenderAnestesia() {
        return renderAnestesia;
    }

    /**
     * @param renderControlMedicamentos
     */
    public void setRenderControlMedicamentos(boolean renderControlMedicamentos) {
        this.renderControlMedicamentos = renderControlMedicamentos;
    }

    /**
     * @return
     */
    public boolean isRenderControlMedicamentos() {
        return renderControlMedicamentos;
    }

    /**
     * @param renderSignosVitales
     */
    public void setRenderSignosVitales(boolean renderSignosVitales) {
        this.renderSignosVitales = renderSignosVitales;
    }

    /**
     * @return
     */
    public boolean isRenderSignosVitales() {
        return renderSignosVitales;
    }

    /**
     * @param renderCirugiaCompleta
     */
    public void setRenderCirugiaCompleta(boolean renderCirugiaCompleta) {
        this.renderCirugiaCompleta = renderCirugiaCompleta;
    }

    /**
     * @return
     */
    public boolean isRenderCirugiaCompleta() {
        return renderCirugiaCompleta;
    }


    /**
     * @param valueChangeEvent
     */
    public void setRenderCirugiaCompleta(ValueChangeEvent valueChangeEvent) {
        setRenderCirugiaCompleta((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void changeCirugiaCompleta() {
        if (renderCirugiaCompleta) {
            renderDescripcion = false;
            renderNotasEnfermeria = false;
            renderEvolucionMedica = false;
            renderControlLiquidos = false;
            renderControlMedicamentos = false;
            renderSignosVitales = false;
            renderCanalizacion = false;
            renderIngreso = false;
            renderAnestesia = false;
            renderEscalaValoracionCaidas=false;
        }
    }

    public void consultarCirugia() throws MalformedURLException {
        Chcirugprogr cirugiaAux = null;
        Chlogimpresi logimpresion = new Chlogimpresi();

        wexito = true;

        if (!renderCirugiaCompleta && !renderDescripcion && 
            !renderNotasEnfermeria && !renderEvolucionMedica && 
            !renderCanalizacion && !renderControlLiquidos && 
            !renderControlMedicamentos && !renderSignosVitales && 
            !renderIngreso && !renderAnestesia && !renderEpicrisis && !renderEscalaValoracionCaidas) {
            wexito = false;
        }

        if (wexito) {
            try {
                cirugiaAux = 
                        this.serviceLocator.getCirugiaService().getFolioCirugiaCompleto(consulta.getHcolnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            resetDatos();
            Chusuario usuario = null;
            
            if(cirugiaAux != null){
                usuario = cirugiaAux.getHcplusuario();
            }
            

            if (cirugiaAux == null) {
                wexito = false;
                generoHistoria = false;
            } else {
                /*                logimpresion = new Chlogimpresi();
                logimpresion.setHlicimpreconsu(IMPRIMIO_RESUMEN_HISTORIA);
                logimpresion.setHlicoperador(userName());
                logimpresion.setHlidfecharegis(new Date());
                logimpresion.setHlinclinica(this.getClinica().getCclncodigo());
                logimpresion.setHlilusuario(consulta.getHcolusuario().getHuslnumero());

                 try {
                     this.serviceLocator.getClinicoService().saveLogImpresionHistorias(logimpresion);
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
*/
            }

            if (wexito) {
                List<byte[]> pdfs = new ArrayList<byte[]>();

                pagact_pdf = 0;
                if (renderCirugiaCompleta || renderDescripcion) {
                    byte[] descripcion = null;
                    descripcion = 
                            generarDescripcionQuirurgica(usuario, cirugiaAux, 
                                                         pagact_pdf);
                    if (descripcion != null) {
                        pagact_pdf += PDFMerger.paginasTotalPDF(descripcion);
                        pdfs.add(descripcion);
                    }
                    else{
                        FacesUtils.addErrorMessage("no existe registro de Descripci�n Quir�rgica");
                    }
                }

                if (renderCirugiaCompleta || renderIngreso) {
                    byte[] ingresoEnfermeria = null;
                    ingresoEnfermeria = 
                            generarIngresoEnfermeria(usuario, cirugiaAux, 
                                                     pagact_pdf);
                    if (ingresoEnfermeria != null) {
                        pagact_pdf += 
                                PDFMerger.paginasTotalPDF(ingresoEnfermeria);
                        pdfs.add(ingresoEnfermeria);
                    }
                }

                if (renderCirugiaCompleta || renderEpicrisis) {
                    byte[] epicrisis = null;
                    epicrisis = 
                            generarEpicrisis(usuario, cirugiaAux, pagact_pdf);
                    if (epicrisis != null) {
                        pagact_pdf += PDFMerger.paginasTotalPDF(epicrisis);
                        pdfs.add(epicrisis);
                    }
                }


                if (renderCirugiaCompleta || renderSignosVitales) {
                    byte[] signosVitales = null;
                    signosVitales = 
                            generarSignosVitales(usuario, cirugiaAux, pagact_pdf,null);
                    if (signosVitales != null) {
                        pagact_pdf += PDFMerger.paginasTotalPDF(signosVitales);
                        pdfs.add(signosVitales);
                    }
                }

                if (renderCirugiaCompleta || renderNotasEnfermeria) {
                    byte[] notasEnfermeria = null;
                    notasEnfermeria = 
                            generarNotasEnfermeria(usuario, cirugiaAux, 
                                                   pagact_pdf,null);
                    if (notasEnfermeria != null) {
                        pagact_pdf += 
                                PDFMerger.paginasTotalPDF(notasEnfermeria);
                        pdfs.add(notasEnfermeria);
                    }
                }

                if (renderCirugiaCompleta || renderCanalizacion) {
                    byte[] canalizacion = null;
                    canalizacion = 
                            generarCanalizacion(usuario, cirugiaAux, pagact_pdf);
                    if (canalizacion != null) {
                        pagact_pdf += PDFMerger.paginasTotalPDF(canalizacion);
                        pdfs.add(canalizacion);
                    }
                }
                
                if (renderCirugiaCompleta || renderControlMedicamentos) {
                    byte[] medicamentos = null;
                    medicamentos = 
                            generarMedicamentos(usuario, cirugiaAux, pagact_pdf);
                    if (medicamentos != null) {
                        pagact_pdf += PDFMerger.paginasTotalPDF(medicamentos);
                        pdfs.add(medicamentos);
                    }
                }

                if (renderCirugiaCompleta || renderControlLiquidos) {
                    byte[] controlLiquidos = null;
                    controlLiquidos = 
                            generarControlLiquidos(usuario, cirugiaAux, 
                                                   pagact_pdf,null);
                    if (controlLiquidos != null) {
                        pagact_pdf += 
                                PDFMerger.paginasTotalPDF(controlLiquidos);
                        pdfs.add(controlLiquidos);
                    }
                }

                if (renderCirugiaCompleta || renderEvolucionMedica) {
                    byte[] evolucionMedica = null;
                    evolucionMedica = 
                            generarEvolucionMedica(usuario, cirugiaAux, 
                                                   pagact_pdf);
                    if (evolucionMedica != null) {
                        pagact_pdf += 
                                PDFMerger.paginasTotalPDF(evolucionMedica);
                        pdfs.add(evolucionMedica);
                    }
                }

                if (renderCirugiaCompleta || renderAnestesia) {
                    byte[] anestesia = null;
                    anestesia = 
                            generarAnestesia(usuario, cirugiaAux, pagact_pdf);
                    if (anestesia != null) {
                        pagact_pdf += PDFMerger.paginasTotalPDF(anestesia);
                        pdfs.add(anestesia);
                    }
                }
                
                if (renderCirugiaCompleta || renderEscalaValoracionCaidas) {
                    byte[] escalaValoracionCaidas = null;
                    escalaValoracionCaidas = 
                            generarEscalaValoracionCaidas(usuario, cirugiaAux, pagact_pdf);
                    if (escalaValoracionCaidas != null) {
                        pagact_pdf += PDFMerger.paginasTotalPDF(escalaValoracionCaidas);
                        pdfs.add(escalaValoracionCaidas);
                    }
                }
                if (renderCirugiaCompleta) {
                    byte[] referenciaPaciente = null;
                    referenciaPaciente = 
                            generarReferenciaPaciente(usuario, consulta, 
                                                   pagact_pdf);
                    if (referenciaPaciente != null) {
                        pagact_pdf += 
                                PDFMerger.paginasTotalPDF(referenciaPaciente);
                        pdfs.add(referenciaPaciente);
                    }
                }

                if (pdfs != null && !pdfs.isEmpty()) {
                    byte[] resul;
                    byte[] result;
                    ByteArrayOutputStream output = new ByteArrayOutputStream();
                    resul = PDFMerger.concatBytePDFs(pdfs, output);
                    result = PDFMerger.adicionarPieTotalPaginas(resul, output);

                    PdfServletUtils.showPdfDocument(result, 
                                                    "FolioUsuarioCirugia.pdf", 
                                                    false);

                    generoHistoria = true;
                } else {
                    FacesUtils.addErrorMessage(MSG_NO_REGISTROS_ATENCION);
                    generoHistoria = false;
                }
            }
        } else {
            FacesUtils.addErrorMessage(MSG_CRITERIOS_BUSQUEDA);
        }
    }


    private void resetDatos() {
        NOMBRE = null;
        TIPO_DOCUMENTO = null;
        NOMBRE_PROFESIONAL = null;
        NUMERO_DOCUMENTO = null;
        FECHA_NACIMIENTO = null;
        DIRECCION = null;
        OCUPACION = null;
        RESPONSABLE = null;
        EDAD = null;
        TELEFONO = null;
        ESTADO_CIVIL = null;
        PARENTESCO_RESPONSABLE = null;
        SEXO = null;
        CIUDAD = null;
        TELEFONO_RESPONSABLE = null;
        IMPRIMIO = null;
        REGISTRO_MEDICO = null;
        EPS = null;
    }

    public void setRenderIngreso(boolean renderIngreso) {
        this.renderIngreso = renderIngreso;
    }

    public boolean isRenderIngreso() {
        return renderIngreso;
    }


    public byte[] generarEpicrisis(Chusuario usuario, Chcirugprogr cirugia, 
                                   Integer paginas_ant) {

        byte[] bytes = null;
        List<Chreporte> lstReporte = new ArrayList<Chreporte>();
        Chdescrquiru descripcion = null;
        Chdetaldescr chdetaldescr = null;
        Cpprofesio cirujano = null;

        if (usuario != null) {
            if (usuario.getHusdfechanacim() != null) {
                FECHA_NACIMIENTO = usuario.getHusdfechanacim();
                if (FECHA_NACIMIENTO != null) {
                    int edad = calcularEdad(FECHA_NACIMIENTO,cirugia.getHcpdfecregistr());
                    EDAD = edad;
                }
            }
            if (getUsuarioSystem() != null) {
                IMPRIMIO = this.getUsuarioSystem().getCurcnombre();
            }
            if (usuario.getHuscprimernomb() != null) {
                NOMBRE = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRES = NOMBRE + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                PER_APELLIDO = usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                SDO_APELLIDO = usuario.getHuscsegundapel();
            }
            if (usuario.getHusanumeiden() != null && 
                usuario.getHusanumeiden() != 0) {
                TIPO_DOCUMENTO = usuario.getHusetipoiden();
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }
            SEXO = usuario.getHusesexo();
        }

        if (cirugia != null) {
            NO_HISTORIA = cirugia.getHcplnumero().toString();
        }


        if (cirugia.getChepicrisis() != null && 
            !cirugia.getChepicrisis().isEmpty()) {


            Iterator it = (cirugia.getChepicrisis()).iterator();
            while (it.hasNext()) {
                Chepicrisi epicrisis = (Chepicrisi)it.next();

                if (epicrisis != null) {
                    MOTIVO = epicrisis.getHepcmotivocons();
                    ESTADO_INGRESO = epicrisis.getHepcestaingres();
                    ENFERMEDAD_ACTUAL = epicrisis.getHepcenfeactual();
                    ANTECEDENTES = epicrisis.getHepcantecedent();
                    RXS = epicrisis.getHepcrevisistem();
                    HALLAZGOS = epicrisis.getHepchallaexafi();
                    DIAGNOSTICO = 
                            epicrisis.getHepcdiagingnpresu();
                    if(epicrisis.getHepcdiagingnrelacu()!=null){
                        DIAGNOSTICO +=" "+ epicrisis.getHepcdiagingnrelacu();
                    }
                    if(epicrisis.getHepcdiagingrelacd()!=null){
                        DIAGNOSTICO +=" "+ epicrisis.getHepcdiagingrelacd();
                    }
                    if(epicrisis.getHepcdiagingrelact()!=null){
                        DIAGNOSTICO +=" "+ epicrisis.getHepcdiagingrelact();
                    }
                    CONDUCTA = epicrisis.getHepcconducta();
                    EVOLUCION = epicrisis.getHepcevolucion();
                    EXAMEN = epicrisis.getHepcexamapoyo();
                    CONDICIONES_PACIENTE = epicrisis.getHepccondegres();
                    FECHA_ING = epicrisis.getHepdfechaingre();
                    FECHA_EGR = epicrisis.getHepdfechaegres();
                    DIAGNOSTICO_CONFIRMADO_EGRESO =epicrisis.getHepcdiagnconfi();
                    DIAGNOSTICO_RELACIONADO_EGRESO = epicrisis.getHepcdiagegrrelacu();
                    if(epicrisis.getHepcdiagegrrelacd()!=null){
                        DIAGNOSTICO_RELACIONADO_EGRESO +=" "+ epicrisis.getHepcdiagegrrelacd();
                    }
                    if(epicrisis.getHepcdiagegrrelact()!=null){
                        DIAGNOSTICO_RELACIONADO_EGRESO +=" "+ epicrisis.getHepcdiagegrrelact();
                    }
                    DIAGNOSTICO_PRESUNTIVO_EGRESO=epicrisis.getHepcdiagegrpresu();
                    INTERPRETACION_RESULTADOS=epicrisis.getHepcintres();
                    if(epicrisis.getHepcindterap()==null){
                        JUSTIFICACIONES_TERAPEUTICAS="";
                    }
                    else{
                        JUSTIFICACIONES_TERAPEUTICAS=epicrisis.getHepcindterap();
                    }
                   
                    PLAN_MANEJO_AMBULATORIO=epicrisis.getHepcplaman();
                    if(("CE").equals(epicrisis.getHepcserviingre())){
                        SERVICIO_INGRESO ="Consulta Externa";
                    }
                    else if(("CP").equals(epicrisis.getHepcserviingre())){
                        SERVICIO_INGRESO ="Cirug�a Programada";
                    }
                    else{
                        SERVICIO_INGRESO ="Urgencias";
                    }
                    
                    try {

                        //Obtiene informacion de descripcion quirurgica
                        descripcion =
                            this.serviceLocator.getCirugiaService().getDescripcionQuirurgica((cirugia.getHcplnumero()));
                        
                        
                        //Obtiene informacion de detalle de la descripcion    
                        chdetaldescr = 
                                this.serviceLocator.getCirugiaService().getDetalleDescripcion(cirugia.getHcplnumero() 
                                                                                                );
                                                                                                
                        //Obtiene informacion de cirujano
                        if (descripcion != null && chdetaldescr != null) {
                            cirujano = 
                                this.serviceLocator.getClinicoService().getProfesionalPorCodigo(chdetaldescr.getHddccirujano(), 
                                                                                                descripcion.getHdqnclinica());  
                            NOMBRE_PROFESIONAL = cirujano.getCpfcnombre();
                            REGISTRO_MEDICO = cirujano.getCpfcregmedic();
                            NOMBRE +=" "+PER_APELLIDO+" "+SDO_APELLIDO;
                        } else {
                            cirujano = 
                                this.serviceLocator.getClinicoService().getProfesionalPorUsuario(epicrisis.getHepcoperador(),
                                                                                                cirugia.getHcpnclinica());                    
                            NOMBRE_PROFESIONAL = cirujano.getCpfcnombre();
                            REGISTRO_MEDICO = cirujano.getCpfcregmedic();
                            NOMBRE +=" "+PER_APELLIDO+" "+SDO_APELLIDO;
                        }
                                                                                                
                            
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    Chreporte report = new Chreporte();
                    report = new Chreporte();
                    report.setHrecdescripcio("****************************************************************************************************************************************************************");
                    report.setHrectipodescri("Epicrisis");
                    report.setHrencodigo(imp_epicirisis);
                    report.setHrentipoimpres(1);
                    //      report.setHrenconsulta(cirugiaAux.getHcplnumero());
                    report.setHredfecharegis(epicrisis.getHepdfecregistr());
                    lstReporte.add(report);


                }


            }
            try {
                URL url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_NEW);
                URL url_super_horizontal = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
                URL url_super_vertical = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                parameters.put("NOMBRES", NOMBRE);
                parameters.put("PER_APELLIDO", PER_APELLIDO);
                parameters.put("SDO_APELLIDO", SDO_APELLIDO);
                parameters.put("NO_HISTORIA", NO_HISTORIA);
                parameters.put("TIPO_DOCUMENTO", TIPO_DOCUMENTO);
                parameters.put("DIAGNOSTICO_RELACIONADO_EGRESO", DIAGNOSTICO_RELACIONADO_EGRESO);
                parameters.put("DIAGNOSTICO_PRESUNTIVO_EGRESO", DIAGNOSTICO_PRESUNTIVO_EGRESO);
                parameters.put("DIAGNOSTICO_CONFIRMADO_EGRESO", DIAGNOSTICO_CONFIRMADO_EGRESO);
                parameters.put("INTERPRETACION_RESULTADOS", INTERPRETACION_RESULTADOS);
                parameters.put("JUSTIFICACIONES_TERAPEUTICAS", JUSTIFICACIONES_TERAPEUTICAS);
                parameters.put("PLAN_MANEJO_AMBULATORIO", PLAN_MANEJO_AMBULATORIO);
                parameters.put("NOMBRE_PROFESIONAL", NOMBRE_PROFESIONAL);
                parameters.put("NUMERO_DOCUMENTO", NUMERO_DOCUMENTO);
                parameters.put("SERVICIO_INGRESO", SERVICIO_INGRESO);
                parameters.put("EDAD", EDAD);
                parameters.put("SEXO", SEXO);
                parameters.put("IMPRIMIO", IMPRIMIO);
                parameters.put("REGISTRO_MEDICO", REGISTRO_MEDICO);
                parameters.put("MOTIVO", MOTIVO);
                parameters.put("ESTADO_INGRESO", ESTADO_INGRESO);
                parameters.put("ENFERMEDAD_ACTUAL", ENFERMEDAD_ACTUAL);
                parameters.put("ANTECEDENTES", ANTECEDENTES);
                parameters.put("RXS", RXS);
                parameters.put("HALLAZGOS", HALLAZGOS);
                parameters.put("DIAGNOSTICO", DIAGNOSTICO);
                parameters.put("CONDUCTA", CONDUCTA);
                parameters.put("EVOLUCION", EVOLUCION);
                parameters.put("EXAMEN", EXAMEN);
                parameters.put("CONDICIONES_PACIENTE", CONDICIONES_PACIENTE);
                parameters.put("FECHA_ING", FECHA_ING);
                parameters.put("FECHA_EGR", FECHA_EGR);
                parameters.put("NOMBRE_PROFESIONAL", NOMBRE_PROFESIONAL);
                parameters.put("REGISTRO_MEDICO", REGISTRO_MEDICO);                
                parameters.put("PAGINAS_ANTERIORES", paginas_ant);

                JRBeanCollectionDataSource dataSource = 
                    new JRBeanCollectionDataSource(lstReporte);
                File reportFile = 
                    new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/FO_GS_QX_046.jasper"));
                if (reportFile.exists()) {
                    try {
                        bytes = 
                                JasperRunManager.runReportToPdf(reportFile.getPath(), 
                                                                parameters, 
                                                                dataSource);
                    } catch (JRException ex) {
                        ex.printStackTrace();
                        FacesUtils.addErrorMessage("No pudo generar descripcion epicrisis . " + 
                                                   ex.getMessage());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        FacesUtils.addErrorMessage("No pudo generar descripcion epicrisis . " + 
                                                   ex.getMessage());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
            }
        }
        return bytes;
    }


    public byte[] generarDescripcionQuirurgica(Chusuario usuario, 
                                               Chcirugprogr cirugia, 
                                               Integer paginas_ant) {
        index = -1;
        List<Object[]> lstDescDetalle = null;
        Object[] detalleDesc = null;
        Cnconsclin consclin = null;
        Cpclinica clinica = null;
        Cvcontrato tipusu = null;
        Chdescrquiru descripcion = null;
        Cpprofesio cirujano = null;
        Cpprofesio circulante = null;
        Cpprofesio instrumentador = null;
        Cpprofesio anestesiologo = null;
        Cpprofesio residente1 = null;
        Cpservicio servic = null;
        
        Cpprofesio resident1 = null;
        Cpprofesio resident2 = null;

        String residente2 = null;
        String anestesia = "";
        Map<String, Object> detalle = null;
        List<Map<String, ?>> lstDescri = new ArrayList<Map<String, ?>>();
        Map parameters = new HashMap();
        Map parametersH = new HashMap();
        byte[] bytes = null;
        String intervenciones = "";
        String intervencionespro = "";
        BigDecimal consecAnt = new BigDecimal("0");
        try {
            lstDescDetalle = 
                    this.serviceLocator.getCirugiaService().getListaDescripcionQuirurgicaByUsuario(cirugia.getHcplnumero());
            
            consclin = this.serviceLocator.getClinicoService().getConsultaClinicaPorId(cirugia.getHcplnumero().toString());
            
            clinica = this.serviceLocator.getClinicoService().getClinica(cirugia.getHcpnclinica());
            if(consclin!=null && consclin.getCcocservic()!=null){
                servic= this.serviceLocator.getClinicoService().getServicioPorId(consclin.getCcocservic().getCsvccodigo());
            
                if (consclin.getCconcontra().intValue() != 1) {
                    tipusu = this.serviceLocator.getClinicoService().getCvcontratoClinica(consclin.getCconclinic(), consclin.getCconcontra());
                }
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }
        
        if (lstDescDetalle != null) {
            Iterator it = lstDescDetalle.iterator();
            while (it.hasNext()) {
                detalleDesc = (Object[])it.next();
//                if (((BigDecimal)detalleDesc[1]).compareTo(consecAnt) != 0) {
//                    intervenciones = "";
//                    intervencionespro = "";
//                }
                if (((BigDecimal)detalleDesc[1]).compareTo(consecAnt) != 0) {
                    if (detalle != null)  {
                        lstDescri.add(detalle);
                        detalle = null;
                    }
                    intervenciones = "";
                    intervencionespro = "";
                }
                consecAnt = (BigDecimal)detalleDesc[1];

                Crdgncie10 diagpre = null;
                Crdgncie10 diagpos = null;
                Crdgncie10 diagcom = null;
                try {
                    //Obtiene el encabezado de la descripcion
                    descripcion = 
                            this.serviceLocator.getCirugiaService().getDescripcionQuirurgica(((BigDecimal)detalleDesc[0]).longValue());
                    if(descripcion == null){
                        FacesUtils.addErrorMessage("La hsitoria no genero Descripcion Quirurgica. ");
                        return bytes;
                    }
                    //Obtiene informacion de cirujano
                    cirujano = 
                            this.serviceLocator.getClinicoService().getProfesionalPorCodigo(((BigDecimal)detalleDesc[5]), 
                                                                                            descripcion.getHdqnclinica());
                    // Obtiene la informacion del Instrumentador
                    instrumentador = 
                            this.serviceLocator.getClinicoService().getProfesionalPorCodigo(((BigDecimal)detalleDesc[8]), 
                                                                                            descripcion.getHdqnclinica());
                    // Obtiene la informacion del circulante
                    if (detalleDesc[6] != null) {
                        anestesiologo = 
                                this.serviceLocator.getClinicoService().getEspecialistaXCodigo(((String)detalleDesc[6]), 
                                                                                               descripcion.getHdqnclinica());
                        // Obtiene la informacion del anestesiologo 
                    }
                    if (detalleDesc[21] != null) {
                        residente1 = 
                                this.serviceLocator.getClinicoService().getEspecialistaXCodigo(((String)detalleDesc[21]), 
                                                                                               descripcion.getHdqnclinica());
                        // Obtiene la informacion del residente1 
                    }
                    if (detalleDesc[22] != null) {
                        residente2 = (String)detalleDesc[22];
                        // Obtiene la informacion del residente2 
                    }
                    
                    if(detalleDesc[0] != null){
                        CONTRATO = nombrecontratoxconsulta(((BigDecimal)detalleDesc[0]).longValue()) ;   
                    }
                    
                    
                         if (detalleDesc[31] != null) {
                             resident1 = 
                                     this.serviceLocator.getClinicoService().getEspecialistaXCodigo((detalleDesc[31]).toString(), 
                                                                                                    descripcion.getHdqnclinica());
                                                                                                    
                                    if(detalleDesc[33] != null){
                                        resident1.setCpfcnombre(resident1.getCpfcnombre() + " :" +  detalleDesc[33]); 
                                    }
                                
                             // Obtiene la informacion del residente1 
                         }
                         if (detalleDesc[32] != null) {
                             resident2 = 
                             this.serviceLocator.getClinicoService().getEspecialistaXCodigo((detalleDesc[32]).toString(), 
                                                                                            descripcion.getHdqnclinica());
                                                                                            
                             if(detalleDesc[34] != null){
                                 resident2.setCpfcnombre(resident2.getCpfcnombre() + " :" +  detalleDesc[34]);
                             }
                         }
                    
                    
                    if (detalleDesc[9] != null)
                        circulante = 
                                this.serviceLocator.getClinicoService().getProfesionalPorCodigo(((BigDecimal)detalleDesc[9]), 
                                                                                                descripcion.getHdqnclinica());

                    if (detalleDesc[7] != null && detalleDesc[7].equals("2")) {
                        anestesia = "General";
                    } else if (detalleDesc[7] != null && 
                               detalleDesc[7].equals("4")) {
                        anestesia = "Regional";
                    } else if (detalleDesc[7] != null && 
                               detalleDesc[7].equals("5")) {
                        anestesia = "Sedaci�n";
                    } else if (detalleDesc[7] != null && 
                               detalleDesc[7].equals("6")) {
                        anestesia = "Local";
                    }
                    else if (detalleDesc[7] != null && 
                                                   detalleDesc[7].equals("7")) {
                                            anestesia = "Local Controlada";
                                        }
                    else if (detalleDesc[7] != null && 
                                                   detalleDesc[7].equals("8")) {
                                            anestesia = "Sin Anestesia";
                                        }

                    //Obtiene informacion diagnostico preoperatorio
                    diagpre = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(detalleDesc[13].toString());
                    //Obtiene informacion diagnostico postoperatorio
                    if (detalleDesc[14] != null)
                        diagpos = 
                                this.serviceLocator.getClinicoService().getCIE10PorCodigo(detalleDesc[14].toString());

                    if (((String)detalleDesc[23]).equals("PC")) {
                        intervencionespro += 
                                "(" + detalleDesc[3] + ") " + detalleDesc[4] + 
                                ", ";
                        intervenciones += 
                                "(" + detalleDesc[19] + ") " + obtenerNombreServicio((String)detalleDesc[19]) + 
                                ", ";
                    }

                } catch (ModelException e) {
                    e.printStackTrace();
                }

                detalle = new HashMap<String, Object>();
                detalle.put("consec", detalleDesc[1]);
                detalle.put("hora", descripcion.getHdqdfecregistr());
                detalle.put("sala", descripcion.getHdqnsalacirugi());
                detalle.put("cirujano", cirujano.getCpfcnombre());
               if (detalleDesc[36] != null){
                   BigDecimal edad = (BigDecimal)detalleDesc[36];
                   if(edad != null){
                       detalle.put("edad", edad);  
                
                   }
               }
                
                
                if (cirujano != null && cirujano.getCpfcusuar() != null) {
                    NOMBRE_PROFESIONAL = cirujano.getCpfcnombre();
                    REGISTRO_MEDICO = cirujano.getCpfcregmedic();
                    detalle.put("NOMBRE_PROFESIONAL", NOMBRE_PROFESIONAL);
                    detalle.put("REGISTRO_MEDICO", REGISTRO_MEDICO);
                }

                if (anestesiologo != null) {
                    detalle.put("anestesiologo", 
                                anestesiologo.getCpfcnombre());
                } else {
                    detalle.put("anestesiologo", "");
                }
                if (residente1 != null) {
                    detalle.put("ayudante1", residente1.getCpfcnombre());
                } else if (resident1 != null) {
                    detalle.put("ayudante1", resident1.getCpfcnombre());
                }else{
                    detalle.put("ayudante1", "");
                }
                if (residente2 != null) {
                    detalle.put("ayudante2", residente2);
                } else if(resident2 != null) {
                    detalle.put("ayudante2", resident2.getCpfcnombre());
                }else{
                    detalle.put("ayudante2", "");
                }
                detalle.put("anestesia", anestesia);
                if (instrumentador != null) {
                    detalle.put("instrumentadora", 
                                instrumentador.getCpfcnombre());
                } else {
                    detalle.put("instrumentadora", "");
                }
                if (circulante != null) {
                    detalle.put("circulante", circulante.getCpfcnombre());
                } else {
                    detalle.put("circulante", "");
                }
                detalle.put("intervenciones", intervenciones);
                detalle.put("tiempo_qx", 
                            detalleDesc[11] + " Hora(s) " + detalleDesc[12] + 
                            " Minuto(s)");
                if (diagpre != null) {
                    detalle.put("diagnostico_pre", 
                                diagpre.getCdcccodigo() + " " + 
                                diagpre.getCdccdescri());
                } else {
                    detalle.put("diagnostico_pre", "");
                }
                if (diagpos != null) {
                    detalle.put("diagnostico_pos", 
                                diagpos.getCdcccodigo() + " " + 
                                diagpos.getCdccdescri());
                } else {
                    detalle.put("diagnostico_pos", "");
                }
                if (detalleDesc[15] != null) {
                    detalle.put("piezas", 
                                formatearCampo(detalleDesc[15].toString()));
                } else {
                    detalle.put("piezas", "");
                }
                if (detalleDesc[16] != null) {
                    detalle.put("hallazgos", detalleDesc[16]);
                } else {
                    detalle.put("hallazgos", " ");
                }
                if (detalleDesc[17] != null) {
                    detalle.put("descripcion", detalleDesc[17]);
                } else {
                    detalle.put("descripcion", " ");
                }
                detalle.put("intervencionespro", intervencionespro);
                if (detalleDesc[24] != null) {
                    detalle.put("diuresis", detalleDesc[24]);
                } else {
                    detalle.put("diuresis", "");
                }
                if (detalleDesc[25] != null) {
                    detalle.put("cantdiu", detalleDesc[25].toString());
                } else {
                    detalle.put("cantdiu", "");
                }
                if (detalleDesc[26] != null) {
                    detalle.put("aspectdiu", detalleDesc[26]);
                } else {
                    detalle.put("aspectdiu", "");
                }
                if (detalleDesc[27] != null) {
                    detalle.put("sangra", detalleDesc[27]);
                } else {
                    detalle.put("sangra", "");
                }
                if (detalleDesc[28] != null) {
                    detalle.put("cantsang", detalleDesc[28].toString());
                } else {
                    detalle.put("cantsang", "");
                }
                if (detalleDesc[29] != null) {
                    detalle.put("compli", detalleDesc[29]);
                } else {
                    detalle.put("compli", "");
                }
                if (detalleDesc[30] != null) {
                    detalle.put("dscompli", detalleDesc[30]);
                } else {
                    detalle.put("dscompli", "");
                }
                
                
                if (detalleDesc[37] != null) {


                    try {
                        diagcom =
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(detalleDesc[37].toString());
                    } catch (ModelException e) {
                       e.printStackTrace();
                    }
                    if(diagcom!= null ){
                        detalle.put("diagcomp", diagcom.getCdcccodigo() + " " +diagcom.getCdccdescri());    
                    }
                    
                } else {
                    detalle.put("diagcomp", "");
                }
                
                if(detalleDesc[38] != null){
                    detalle.put("cuantifisang",detalleDesc[38]);
                }
                else{
                    detalle.put("cuantifisang","");
                }
                if(detalleDesc[39] != null){
                    detalle.put("cuantidiure",detalleDesc[39]);
                }
                else{
                    detalle.put("cuantidiure","");
                }
                if (detalleDesc[40] != null) {
                    detalle.put("gradodiure", detalleDesc[40]);
                } else {
                    detalle.put("gradodiure", "");
                }
               
//                lstDescri.add(detalle);
            }

            if (detalle != null)  {
                lstDescri.add(detalle);
                detalle = null;
            }

        }
        if (lstDescri != null && !lstDescri.isEmpty()) {
            parameters = new HashMap();
            try {
                URL imagen = null;
                try {
                    imagen = 
                            FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_NEW);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                parameters.put("IMAGEN", imagen);
                parameters.put("FECHA", descripcion.getHdqdfechaproce());
                parameters.put("NO_HISTORIA", 
                               usuario.getHusanumeiden().toString());
                parameters.put("PER_APELLIDO", usuario.getHuscprimerapel());
                parameters.put("SDO_APELLIDO", usuario.getHuscsegundapel());
                parameters.put("NOMBRES", 
                               usuario.getHuscprimernomb() + " " + usuario.getHuscsegundnomb());
                parameters.put("PAGINAS_ANTERIORES", paginas_ant);
                if(consclin!=null){
                    if (consclin.getCconcontra().intValue() == 1) {
                        TIPO_USUARIO = "";
                    }else if (tipusu == null) {
                        TIPO_USUARIO = consclin.getCconclinic().toString() + "-" + consclin.getCconcontra();
                    } else {
                        if(tipusu!=null){
                            TIPO_USUARIO = tipusu.getCcncdescri();
                        }
                        else{
                            TIPO_USUARIO = ""; 
                        }
                    }
                }
                else{
                    if(tipusu!=null){
                        TIPO_USUARIO = tipusu.getCcncdescri();
                    }
                    else{
                        TIPO_USUARIO = ""; 
                    }
                }
                parameters.put("CLINICA", clinica.getCclcnombre());
                parameters.put("TIPO_USUARIO", TIPO_USUARIO);
               
               //reporte histeroscopia
                Chcirugprogr cirugiaAux= null;
                Cpprofesio profesionalanes= null;
                Cpprofesio profesionalciru= null;  
                Cpservicio servicio= null;
                Chconsulta chconsulta= null;
                Chdetaldescr detalleDescripcion=null;
                Crdgncie10 diagprincipal=null;
                Crdgncie10 diagrelaciona=null;
                Crdgncie10 diagCompl0=null;
                Chhisteroscopia histeroscopia=null;
                Chhallahistero hallazgoHis=null;
                Crdgncie10 diagCompl=null;

                  
                
                chconsulta= serviceLocator.getClinicoService().getConsultaActualHisteroscopia(descripcion.getHdqlnumero());
                if(chconsulta != null){
                    servicio= this.serviceLocator.getClinicoService().getServicioPorId(chconsulta.getHcocservicio().getCsvccodigo());
                } 
                
                if(servicio != null && servicio.getCsvntiphis() != null && servicio.getCsvntiphis()==56){
                        detalleDescripcion= serviceLocator.getCirugiaService().getDetalleDescripcion(descripcion.getHdqlnumero());
                       
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
                            if (usuario != null && usuario.getHusdfechanacim() != null){
                                edad = Integer.valueOf(calcularEdad(usuario.getHusdfechanacim(), new Date()));
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
                                
                                instrumentador = this.serviceLocator.getClinicoService().getProfesionalXCodigo(detalleDescripcion.getHddninstrument().toString(), getClinica().getCclncodigo()); 
                              if (null != instrumentador) {
                                    INSTRUMENTACION =   instrumentador.getCpfcnombre();
                                } else {
                                    INSTRUMENTACION = "";
                                }
                            }
                            if (detalleDescripcion != null &&  detalleDescripcion.getHddninstrument() !=  null) {
                            if (null !=  detalleDescripcion.getHddcanestesiol()) {
                                anestesiologo =  this.serviceLocator.getClinicoService().getProfesionalXCodigo(detalleDescripcion.getHddcanestesiol(),  getClinica().getCclncodigo());
                                ANESTESIOLOGO = anestesiologo.getCpfcnombre();
                            } else {
                                ANESTESIOLOGO = "";
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
                                
                                circulante = this.serviceLocator.getClinicoService().getProfesionalXCodigo(detalleDescripcion.getHddncirculante().toString(), getClinica().getCclncodigo());
                                if (null != circulante) {
                                    CIRCULANTE = circulante.getCpfcnombre();
                                } else {
                                    CIRCULANTE = "";
                                }
                            }
                            if (detalleDescripcion.getHddcdiagnprinc() != null) {
                                diagprincipal = 
                                        serviceLocator.getClinicoService().getCIE10PorCodigo(detalleDescripcion.getHddcdiagnprinc().toUpperCase());
                            }
                            if(detalleDescripcion != null &&  detalleDescripcion.getHddcdiagnprinc() !=  null){
                                DIAGPRINCIPAL= diagprincipal.getCdccdescri();
                            }
                            if (detalleDescripcion.getHddcdiagnrelac() != null) {
                                diagrelaciona = 
                                        serviceLocator.getClinicoService().getCIE10PorCodigo(detalleDescripcion.getHddcdiagnrelac().toUpperCase());
                            }
                            if(detalleDescripcion != null &&  detalleDescripcion.getHddcdiagnrelac() !=  null){
                                DIAGRELACIONADO= diagrelaciona.getCdccdescri();
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
                            if(null != detalleDescripcion.getHddcdiagncompl()){
                            diagCompl = 
                                    serviceLocator.getClinicoService().getCIE10PorCodigo(detalleDescripcion.getHddcdiagncompl().toUpperCase());
                            if(diagCompl != null &&   detalleDescripcion.getHddcdiagncompl() !=  null){
                                DIAGCOMPLICACION= detalleDescripcion.getHddcdiagncompl() +" - "+ diagCompl.getCdccdescri();
                            }
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
                histeroscopia= serviceLocator.getClinicoService().getConsultaRegistroHisteroscopia(descripcion.getHdqlnumero());
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
                    hallazgoHis= serviceLocator.getClinicoService().getConsultaHallazgoHisteroscopia(descripcion.getHdqlnumero());
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
                java.net.URL imagen2 = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/profamilia_negro.gif");
                parametersH.put("IMAGE_PROFAMILIA", imagen2);        
                parametersH.put("FECHAHISTERO",FECHAHISTERO);
                parametersH.put("HISTORIACLINICA",HISTORIACLINICA);
                parametersH.put("PRIMERAPELLIDO",PRIMERAPELLIDO);
                parametersH.put("SEGUNDOAPELLIDO",SEGUNDOAPELLIDO); 
                parametersH.put("NOMBRE",NOMBRE);  
                parametersH.put("EDADHISTERO",EDADHISTERO);  
                parametersH.put("CIRUJANO",CIRUJANO);
                parametersH.put("TIEMPOQUIRURGICO",TIEMPOQUIRURGICO);
                parametersH.put("AYUDANTE",AYUDANTE);
                parametersH.put("AYUDANTE2",AYUDANTE2);
                parametersH.put("INSTRUMENTACION",INSTRUMENTACION);
                parametersH.put("ANESTESIOLOGO",ANESTESIOLOGO);
                parametersH.put("TIPOANESTESIA",TIPOANESTESIA);
                parametersH.put("CIRCULANTE",CIRCULANTE);
                parametersH.put("DIAGPRINCIPAL",DIAGPRINCIPAL);
                parametersH.put("DIAGRELACIONADO",DIAGRELACIONADO);
                parametersH.put("DESCRIPCIONPROCED",DESCRIPCIONPROCED);
                parametersH.put("PATOLOGIA",PATOLOGIA);
                parametersH.put("SANGRADOHISTERO",SANGRADOHISTERO);
                parametersH.put("CUANTIFICADO",CUANTIFICADO);
                parametersH.put("CANTIDAD",CANTIDAD);
                parametersH.put("COMPLICACION",COMPLICACION);
                parametersH.put("DIAGCOMPLICACION",DIAGCOMPLICACION);
                parametersH.put("DESCRIPCOMPLIC",DESCRIPCOMPLIC);
                parametersH.put("CLINICAHISTERO",CLINICAHISTERO);
                parametersH.put("SALA",SALA);
                parametersH.put("INTERVENCIONPROPUESTA",INTERVENCIONPROPUESTA);
                parametersH.put("MEDIODISTENCION",MEDIODISTENCION);
                parametersH.put("CANTIDADIRRIGADA",CANTIDADIRRIGADA);
                parametersH.put("CANTIDADRECOLECTADA",CANTIDADRECOLECTADA);  
                parametersH.put("BALANCE",BALANCE);  
                parametersH.put("POSITIVONEGATIVO",POSITIVONEGATIVO);
                parametersH.put("INTERVENCIONPRACTICADA",INTERVENCIONPRACTICADA);
                parametersH.put("HALLAZGOS",HALLAZGOS);  
                parametersH.put("VAGINOSCOPIA",VAGINOSCOPIA);
                parametersH.put("CANALENDOCERVICAL",CANALENDOCERVICAL); 
                parametersH.put("ASPECTOENDOMETRIO",ASPECTOENDOMETRIO); 
                parametersH.put("OSTIUMSTUBARICO",OSTIUMSTUBARICO);
                parametersH.put("MASAINTRACAVITARIA",MASAINTRACAVITARIA);  
                parametersH.put("OTROSHOISTERO",OTROSHOISTERO);
                parametersH.put("NOMBREPORFESIONAL",NOMBREPORFESIONAL);
                parametersH.put("REGISTROPROFESIONAL",REGISTROPROFESIONAL);
                }
                   
                    
                JRMapCollectionDataSource dataSource = 
                    new JRMapCollectionDataSource(lstDescri);
                File reportFile;
                //File reportFile = 
                    //new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/DescripcionQuirurgica.jasper"));
                if (servic != null && servic.getCsvntiphis() !=null && servic.getCsvntiphis() == 56) {
                    reportFile = 
                        new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/reporteHisteroscopia.jasper"));
                    if (reportFile.exists()) {
                        try {
                            bytes = 
                                    JasperRunManager.runReportToPdf(reportFile.getPath(), 
                                                                    parametersH,  (JRDataSource)this);
                        } catch (JRException ex) {
                            ex.printStackTrace();
                            FacesUtils.addErrorMessage("No pudo generar Descripci�n Quirurgica. " + 
                                                       ex.getMessage());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            FacesUtils.addErrorMessage("No pudo generar Descripci�n Quirurgica. " + 
                                                       ex.getMessage());
                        }
                    }
                } else {
                   reportFile = 
                        new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/FO_GS_QX_04_V01.jasper"));
                    if (reportFile.exists()) {
                        try {
                            bytes = 
                                    JasperRunManager.runReportToPdf(reportFile.getPath(), 
                                                                    parameters, 
                                                                    dataSource);
                        } catch (JRException ex) {
                            ex.printStackTrace();
                            FacesUtils.addErrorMessage("No pudo generar Descripci�n Quirurgica. " + 
                                                       ex.getMessage());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            FacesUtils.addErrorMessage("No pudo generar Descripci�n Quirurgica. " + 
                                                       ex.getMessage());
                        }
                    }
                }
                    
               
                    
            } catch (Exception ex) {
                ex.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar reporte Descripcion Quirurgica. " + 
                                           ex.getMessage());
            }
        }
        return bytes;
    
    }
    


    public byte[] generarIngresoEnfermeria(Chusuario usuario, 
                                           Chcirugprogr cirugia, 
                                           Integer paginas_ant) {
        byte[] bytes = null;
        List<Chreporte> lstReporte = new ArrayList<Chreporte>();

        if (usuario != null) {
            if (usuario.getHusdfechanacim() != null) {
                FECHA_NACIMIENTO = usuario.getHusdfechanacim();
                if (FECHA_NACIMIENTO != null) {
                    int edad = calcularEdad(FECHA_NACIMIENTO, cirugia.getHcpdfecregistr());
                    EDAD = edad;
                }
            }
            if (getUsuarioSystem() != null) {
                IMPRIMIO = this.getUsuarioSystem().getCurcnombre();
            }
            if (usuario.getHuscprimernomb() != null) {
                NOMBRE = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                NOMBRE = NOMBRE + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundapel();
            }
            if (usuario.getHusanumeiden() != null && 
                usuario.getHusanumeiden() != 0) {
                TIPO_DOCUMENTO = usuario.getHusetipoiden();
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }
            if (usuario.getHuscentidadadm() != null) {
                try {
                    EPS = 
serviceLocator.getClinicoService().getDescripcionEntidadByCodigo(usuario.getHuscentidadadm());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }

            SEXO = usuario.getHusesexo();
            DIRECCION = usuario.getHuscdireccion();
            TELEFONO = usuario.getHusctelefono();
            Integer idCiudad = usuario.getHusnciudad();
            Integer idDepartamento = usuario.getHusndepartamen();
            Cpmunidane ciudadObject = null;
            try {
                ciudadObject = 
                        this.serviceLocator.getClinicoService().getMunicipio(idCiudad, 
                                                                             idDepartamento);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (ciudadObject != null) {
                CIUDAD = ciudadObject.getCmdcnommun();
            }

            Integer ocupacion = usuario.getHusnocupacion();
            try {
                OCUPACION = 
                        serviceLocator.getClinicoService().getDescripcionOcupacion(ocupacion);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            ESTADO_CIVIL = usuario.getHuseestadcivil();
            RESPONSABLE = usuario.getHuscnomresponsa();
            PARENTESCO_RESPONSABLE = usuario.getHuscparresponsa();
            TELEFONO_RESPONSABLE = usuario.getHusctelresponsa();
            ZONA = formatearCampoZona(usuario.getHusezonareside());
            ESTRATO = usuario.getHusnestrato();
            NIVELEDUCATIVO = formatearCampoNivelEducativo(usuario.getHusnniveledu());
            ETNIA = formatearCampoEtnia(usuario.getHuscetnia());
            BARRIO = usuario.getHuscbarrio();
            
        }

        if (cirugia.getChingresoenfs() != null && 
            !cirugia.getChingresoenfs().isEmpty()) {
            Iterator it = (cirugia.getChingresoenfs()).iterator();
            while (it.hasNext()) {
                Chingresoenf ingreso = null;
                ingreso = (Chingresoenf)it.next();
                if (ingreso != null) {
                    Chreporte report = new Chreporte();

                    report = new Chreporte();
                    report.setHrecdescripcio("****************************************************************************************************************************************************************");
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Hora de la actividad: " + 
                                             formatearCampoHoraSimple(ingreso.getHiedfecregistr()));
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Usuario que realiza la actividad: " + 
                                             obtenerUsuario(ingreso.getHiecoperador()));
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("El usuario confirma sitio y lado de la cirug�a? " + 
                                             formatearCampo(ingreso.getHiecconficirug()));
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Verifica que el/los consentimiento/s informado/s esten diligenciado/s? " + 
                                             formatearCampo(ingreso.getHiecconsinfor()));
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    if (ingreso.getHiecayunopre() != null) {
                        report = new Chreporte();
                        report.setHrecdescripcio("Verifica ayuno preoperatorio , de cuantas horas, s�lidos y l�quidos? " + 
                                                 formatearCampo(ingreso.getHiecayunopre()));
                        report.setHrencodigo(imp_ingreso_enfermeria);
                        report.setHrectipodescri("Ingreso Enfermer�a");
                        report.setHrentipoimpres(2);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ingreso.getHiedfecregistr());
                        lstReporte.add(report);
                    }

                    report = new Chreporte();
                    report.setHrecdescripcio("Confirma antecedentes patol�gicos? " + 
                                             formatearCampo(ingreso.getHiecantepatol()));
                    if (ingreso.getHieccualpatol() != null) {
                        report.setHrecdescripcio2("Cuales: " + 
                                                  formatearCampo(ingreso.getHieccualpatol()));
                    } else {
                        report.setHrecdescripcio2("");
                    }
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Confirma antecedentes toxicoal�rgicos? " + 
                                             formatearCampo(ingreso.getHiecantetoxic()));
                    if (ingreso.getHieccualtoxic() != null) {
                        report.setHrecdescripcio2("Cuales: " + 
                                                  formatearCampo(ingreso.getHieccualtoxic()));
                    } else {
                        report.setHrecdescripcio2("");
                    }
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Esta tomando en la actualidad alg�n medicamento? " + 
                                             formatearCampo(ingreso.getHiecpremedicac()));
                    if (ingreso.getHieccualpremed() != null) {
                        report.setHrecdescripcio2("Cuales: " + 
                                                  formatearCampo(ingreso.getHieccualpremed()));
                    } else {
                        report.setHrecdescripcio2("");
                    }
                    if (ingreso.getHienhoraspreme() != null) {
                        report.setHrecdescripcio3("Hace cuantas HORAS lo tomo?  " + 
                                                  formatearCampo(ingreso.getHieccualpremed()));
                    } else {
                        report.setHrecdescripcio3("");
                    }
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Se retira, maquillaje, protesis removible, lentes de contacto, anteojos, joyas u objetos de valor? " + 
                                             formatearCampo(ingreso.getHiecobjetvalor()));
                    if (ingreso.getHiecobjetvalor() != null && 
                        ingreso.getHiecobjetvalor().equals("S")) {
                        String wcargo = "";
                        if (ingreso.getHiecentreobjec() != null && 
                            ingreso.getHiecentreobjec().equals("1"))
                            wcargo = "Se entrega a familiar";
                        if (ingreso.getHiecentreobjec() != null && 
                            ingreso.getHiecentreobjec().equals("2"))
                            wcargo = 
                                    "La deja con sus cosas personales en custodia del centro";
                        report.setHrecdescripcio2("a cargo de? " + 
                                                  formatearCampo(wcargo));
                    } else {
                        report.setHrecdescripcio2("");
                        report.setHrecdescripcio3("");
                        report.setHrecdescripcio4("");
                    }
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("La zona a intervenir esta rasurada?    " + 
                                             formatearCampo(ingreso.getHiecarearasur()));
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Requiere profilaxis antitromb�tica? (Medias de compresi�n el�stica y/o Anticoagulantes)?    " + 
                                             formatearCampo(ingreso.getHieccomprelast()));
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Autoriza ser contactada telef�nicamente despu�s de la cirug�a para verificar su evoluci�n?    " + 
                                             formatearCampo(ingreso.getHiecautocntel()));
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    if (ingreso.getHiedfechapremb() != null) {
                        report = new Chreporte();
                        report.setHrecdescripcio("Prueba Embarazo: SI");
                        report.setHrencodigo(imp_ingreso_enfermeria);
                        report.setHrectipodescri("Ingreso Enfermer�a");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ingreso.getHiedfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrecdescripcio("Resultado de la Prueba: " + 
                                                 formatearCampoPruebaEmbarazo(ingreso.getHiecresulpruemb()));
                        report.setHrencodigo(imp_ingreso_enfermeria);
                        report.setHrectipodescri("Ingreso Enfermer�a");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ingreso.getHiedfecregistr());
                        lstReporte.add(report);


                        report = new Chreporte();
                        report.setHrecdescripcio("Fecha la Prueba: " + 
                                                 formatearCampo(ingreso.getHiedfechapremb()));
                        report.setHrencodigo(imp_ingreso_enfermeria);
                        report.setHrectipodescri("Ingreso Enfermer�a");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ingreso.getHiedfecregistr());
                        lstReporte.add(report);


                    }


                }
            }

            try {
                URL url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
                URL url_super_horizontal = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
                URL url_super_vertical = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                parameters.put("NOMBRE", NOMBRE);
                parameters.put("TIPO_DOCUMENTO", TIPO_DOCUMENTO);
                parameters.put("NOMBRE_PROFESIONAL", NOMBRE_PROFESIONAL);
                parameters.put("NUMERO_DOCUMENTO", NUMERO_DOCUMENTO);
                parameters.put("FECHA_NACIMIENTO", FECHA_NACIMIENTO);
                parameters.put("DIRECCION", DIRECCION);
                parameters.put("OCUPACION", OCUPACION);
                parameters.put("RESPONSABLE", RESPONSABLE);
                parameters.put("EDAD", EDAD);
                parameters.put("TELEFONO", TELEFONO);
                parameters.put("ESTADO_CIVIL", ESTADO_CIVIL);
                parameters.put("PARENTESCO_RESPONSABLE", 
                               PARENTESCO_RESPONSABLE);
                parameters.put("SEXO", SEXO);
                parameters.put("CIUDAD", CIUDAD);
                parameters.put("TELEFONO_RESPONSABLE", TELEFONO_RESPONSABLE);
                parameters.put("IMPRIMIO", IMPRIMIO);
                parameters.put("REGISTRO_MEDICO", REGISTRO_MEDICO);
                parameters.put("EPS", EPS);
                parameters.put("PAGINAS_ANTERIORES", paginas_ant);
                

                                
                parameters.put("ZONA", ZONA);
                parameters.put("CONTRATO", CONTRATO);
                parameters.put("ESTRATO", ESTRATO);
                parameters.put("NIVELEDUCATIVO", NIVELEDUCATIVO);
                parameters.put("BARRIO", BARRIO);
                
                parameters.put("ETNIA", ETNIA);

                JRBeanCollectionDataSource dataSource = 
                    new JRBeanCollectionDataSource(lstReporte);
                File reportFile = 
                    new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/consultarFoliosCirugia.jasper"));
                if (reportFile.exists()) {
                    try {
                        bytes = 
                                JasperRunManager.runReportToPdf(reportFile.getPath(), 
                                                                parameters, 
                                                                dataSource);
                    } catch (JRException ex) {
                        ex.printStackTrace();
                        FacesUtils.addErrorMessage("No pudo generar Ingreso enfermeria. " + 
                                                   ex.getMessage());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        FacesUtils.addErrorMessage("No pudo generar Ingreso enfermeria. " + 
                                                   ex.getMessage());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
            }
        }
        return bytes;
    }

    public byte[] generarSignosVitales(Chusuario usuario, Chcirugprogr cirugia, 
                                       Integer paginas_ant,Cnconsclin consulta) {
        List<Chsignovital> lstSignoAux = new ArrayList<Chsignovital>();
        List<Chsignovital> lstSignoVital = new ArrayList<Chsignovital>();
        Chdetacirpro detalleCirugia = new Chdetacirpro();
        Cpservicio servicio = new Cpservicio();
        byte[] bytes = null;

        try {
            detalleCirugia = 
                    this.serviceLocator.getCirugiaService().getServicioDetalle(cirugia.getHcplnumero());
            lstSignoVital = 
                    this.serviceLocator.getCirugiaService().getSignosVitalesTomados(cirugia.getHcplnumero());
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (detalleCirugia != null) {
            try {
                servicio = 
                        this.serviceLocator.getClinicoService().getDescripcionCupsCompleto(detalleCirugia.getId().getHdccservicio());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        } else {
            if (consulta != null) {
                try {
                    servicio = 
                            this.serviceLocator.getClinicoService().getDescripcionCupsCompleto(consulta.getCcocservic().getCsvccodigo());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
        }

        if (lstSignoVital != null && !lstSignoVital.isEmpty()) {
            Iterator it = lstSignoVital.iterator();
            while (it.hasNext()) {
                Chsignovital signoAux = (Chsignovital)it.next();
                signoAux.setHsvcdescropera(getNombreOperadorXUsuario(signoAux.getHsvcoperador()));
                lstSignoAux.add(signoAux);
            }

            JRBeanCollectionDataSource dataSource = 
                new JRBeanCollectionDataSource(lstSignoAux);
            File reportFile = 
                new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/reporteSignosVitales.jasper"));

            if (reportFile.exists()) {
                Map parameters = new HashMap();
                try {
                    URL imagen = 
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
                                   usuario.getHuscprimernomb() + " " + 
                                   usuario.getHuscsegundnomb());
                    parameters.put("PROCEDIMIENTO", servicio.getCsvcnombre());
                    parameters.put("PAGINAS_ANTERIORES", paginas_ant);
                    bytes = 
                            JasperRunManager.runReportToPdf(reportFile.getPath(), 
                                                            parameters, 
                                                            dataSource);
                } catch (JRException ex) {
                    ex.printStackTrace();
                    FacesUtils.addErrorMessage("No pudo generar Reporte Signos Vitales. " + 
                                               ex.getMessage());
                } catch (Exception ex) {
                    ex.printStackTrace();
                    FacesUtils.addErrorMessage("No pudo generar reporte Signos Vitales. " + 
                                               ex.getMessage());
                }
            }
        }
        return bytes;
    }

    public byte[] generarNotasEnfermeria(Chusuario usuario, 
                                         Chcirugprogr cirugia, 
                                         Integer paginas_ant,Cnconsclin consulta) {
        List<Chnotaenferm> notas = null;
        List<Chnotaenferm> notasUsuario = null;
        Cpservicio servicio = null;
        Chdetacirpro detalleCirugia = null;
//        Cpclinica clinica = null;
        notas = new ArrayList<Chnotaenferm>();
        Map parameters = new HashMap();
        byte[] bytes = null;

        try {
            
                notasUsuario = 
                        this.serviceLocator.getCirugiaService().getNotasEnfermeriaIngreso(cirugia.getHcplnumero());
                        
                detalleCirugia = 
                        this.serviceLocator.getCirugiaService().getServicioDetalle(cirugia.getHcplnumero());
            
//            clinica = 
//                    this.serviceLocator.getClinicoService().getClinica(cirugia.getHcpnclinica());
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (detalleCirugia != null) {
            try {
                servicio = 
                        this.serviceLocator.getClinicoService().getDescripcionCupsCompleto(detalleCirugia.getId().getHdccservicio());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            } else {
                if (consulta != null) {
                    try {
                        servicio = 
                                this.serviceLocator.getClinicoService().getDescripcionCupsCompleto(consulta.getCcocservic().getCsvccodigo());
                        //notasUsuario = this.serviceLocator.getCirugiaService().getNotasEnfermeriaIngresoProcedimientos(cirugia.getHcplnumero());       
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                }
            }

        if (notasUsuario != null && !notasUsuario.isEmpty()) {
            Iterator it = notasUsuario.iterator();
            while (it.hasNext()) {
                Chnotaenferm notaAux = (Chnotaenferm)it.next();
                notaAux.setHnecdescropera(getNombreOperadorXUsuario(notaAux.getHnecoperador()));
                notas.add(notaAux);
            }

            JRBeanCollectionDataSource dataSource = 
                new JRBeanCollectionDataSource(notas);
            File reportFile = 
                new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/NotasEnermeria.jasper"));
//            File reportFile = 
//                new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/FO_GS_QX_05_V01.jasper"));

            if (reportFile.exists()) {
                parameters = new HashMap();
                URL imagen = null;
                try {
                    imagen = 
                            FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/profamilia.gif");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                parameters.put("IMAGEN", imagen);
                parameters.put("FECHA", new Date());
//                parameters.put("CLINICA", clinica.getCclcnombre());
                parameters.put("NO_HISTORIA", 
                               usuario.getHusanumeiden().toString());
                parameters.put("PER_APELLIDO", usuario.getHuscprimerapel());
                parameters.put("SDO_APELLIDO", usuario.getHuscsegundapel());
                parameters.put("PROCEDIMIENTO", servicio.getCsvcnombre());
                parameters.put("NOMBRES", 
                               usuario.getHuscprimernomb() + " " + usuario.getHuscsegundnomb());
                parameters.put("PAGINAS_ANTERIORES", paginas_ant);

                try {
                    bytes = 
                            JasperRunManager.runReportToPdf(reportFile.getPath(), 
                                                            parameters, 
                                                            dataSource);
                } catch (JRException ex) {
                    ex.printStackTrace();
                    FacesUtils.addErrorMessage("No pudo generar Reporte Notas de Enfermeria. " + 
                                               ex.getMessage());
                } catch (Exception ex) {
                    ex.printStackTrace();
                    FacesUtils.addErrorMessage("No pudo generar reporte Notas de Enfermeria. " + 
                                               ex.getMessage());
                }
            }
        }
        return bytes;
    }

    public byte[] generarCanalizacion(Chusuario usuario, Chcirugprogr cirugia, 
                                      Integer paginas_ant) {
        byte[] bytes = null;
        List<Chreporte> lstReporte = new ArrayList<Chreporte>();

        if (usuario != null) {
            if (usuario.getHusdfechanacim() != null) {
                FECHA_NACIMIENTO = usuario.getHusdfechanacim();
                if (FECHA_NACIMIENTO != null) {
                    int edad = calcularEdad(FECHA_NACIMIENTO, cirugia.getHcpdfecregistr());
                    EDAD = edad;
                }
            }
            if (getUsuarioSystem() != null) {
                IMPRIMIO = this.getUsuarioSystem().getCurcnombre();
            }
            if (usuario.getHuscprimernomb() != null) {
                NOMBRE = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundnomb() + " ";
            }
            ZONA = formatearCampoZona(usuario.getHusezonareside());
            ESTRATO = usuario.getHusnestrato();
            NIVELEDUCATIVO = formatearCampoNivelEducativo(usuario.getHusnniveledu());
            BARRIO = usuario.getHuscbarrio();
            ETNIA = formatearCampoEtnia(usuario.getHuscetnia());
            
            
            if (usuario.getHuscprimerapel() != null) {
                NOMBRE = NOMBRE + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundapel();
            }
            if (usuario.getHusanumeiden() != null && 
                usuario.getHusanumeiden() != 0) {
                TIPO_DOCUMENTO = usuario.getHusetipoiden();
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }
            if (usuario.getHuscentidadadm() != null) {
                try {
                    EPS = 
serviceLocator.getClinicoService().getDescripcionEntidadByCodigo(usuario.getHuscentidadadm());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }

            SEXO = usuario.getHusesexo();
            DIRECCION = usuario.getHuscdireccion();
            TELEFONO = usuario.getHusctelefono();
            Integer idCiudad = usuario.getHusnciudad();
            Integer idDepartamento = usuario.getHusndepartamen();
            Cpmunidane ciudadObject = null;
            try {
                ciudadObject = 
                        this.serviceLocator.getClinicoService().getMunicipio(idCiudad, 
                                                                             idDepartamento);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (ciudadObject != null) {
                CIUDAD = ciudadObject.getCmdcnommun();
            }

            Integer ocupacion = usuario.getHusnocupacion();
            try {
                OCUPACION = 
                        serviceLocator.getClinicoService().getDescripcionOcupacion(ocupacion);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            ESTADO_CIVIL = usuario.getHuseestadcivil();
            RESPONSABLE = usuario.getHuscnomresponsa();
            PARENTESCO_RESPONSABLE = usuario.getHuscparresponsa();
            TELEFONO_RESPONSABLE = usuario.getHusctelresponsa();
            ZONA = formatearCampoZona(usuario.getHusezonareside());
            
            ESTRATO = usuario.getHusnestrato();
            NIVELEDUCATIVO = formatearCampoNivelEducativo(usuario.getHusnniveledu());
            BARRIO = usuario.getHuscbarrio();
            ETNIA = formatearCampoEtnia(usuario.getHuscetnia());
            
        }

        if (cirugia.getChcanalivenas() != null && 
            !cirugia.getChcanalivenas().isEmpty()) {
            Iterator it = (cirugia.getChcanalivenas()).iterator();
            while (it.hasNext()) {

                Chcanalivena canalizacion;
                canalizacion = null;

                canalizacion = (Chcanalivena)it.next();
                Chreporte report = new Chreporte();

                report = new Chreporte();
                report.setHrecdescripcio("****************************************************************************************************************************************************************");
                report.setHrectipodescri("Canalizaci�n Vena");
                report.setHrencodigo(imp_canalizacion);
                report.setHrentipoimpres(1);
                report.setHrenconsulta(cirugia.getHcplnumero());
                report.setHredfecharegis(canalizacion.getHcvdfecregistr());
                lstReporte.add(report);

                report = new Chreporte();
                report.setHrecdescripcio("Hora de la actividad: " + 
                                         formatearCampoHoraSimple(canalizacion.getHcvdfecregistr()));
                report.setHrencodigo(imp_canalizacion);
                report.setHrectipodescri("Canalizaci�n Vena");
                report.setHrentipoimpres(1);
                report.setHrenconsulta(cirugia.getHcplnumero());
                report.setHredfecharegis(canalizacion.getHcvdfecregistr());
                lstReporte.add(report);

                report = new Chreporte();
                report.setHrecdescripcio("Usuario que realiza la actividad: " + 
                                         obtenerUsuario(canalizacion.getHcvcoperador()));
                report.setHrencodigo(imp_canalizacion);
                report.setHrectipodescri("Canalizaci�n Vena");
                report.setHrentipoimpres(1);
                report.setHrenconsulta(cirugia.getHcplnumero());
                report.setHredfecharegis(canalizacion.getHcvdfecregistr());
                lstReporte.add(report);

                report = new Chreporte();
                report.setHrecdescripcio("Asepsia y antisepsia zona a canalizar: " + 
                                         formatearCampo(canalizacion.getHcveasepsia()));
                report.setHrecdescripcio2("Miembro Superior: " + 
                                          obtenerMiembroSuperior(canalizacion.getHcvcmiembsuper()));
                report.setHrecdescripcio3("Localizaci�n: " + 
                                          obtenerLocalizacion(canalizacion.getHcvczonacanali()));
                report.setHrencodigo(imp_canalizacion);
                report.setHrectipodescri("Canalizaci�n Vena");
                report.setHrentipoimpres(5);
                report.setHrenconsulta(cirugia.getHcplnumero());
                report.setHredfecharegis(canalizacion.getHcvdfecregistr());
                lstReporte.add(report);

                report = new Chreporte();
                report.setHrecdescripcio("Tipo de Cateter: " + 
                                         obtenerTipoCateter(canalizacion.getHcvctipocatete()));
                if (canalizacion.getHcvncalibre() != null) {
                    report.setHrecdescripcio2("Calibre (G) " + 
                                              formatearCampo(canalizacion.getHcvncalibre()));
                } else {
                    report.setHrecdescripcio2("");
                }

                if(canalizacion.getHcvnnumerinten() != null){
                    report.setHrecdescripcio3("N�mero de intentos de venopunci�n: " +
                     formatearCampo(canalizacion.getHcvnnumerinten()));
                     
                }else{
                    report.setHrecdescripcio3(" ");    
                }

                report.setHrencodigo(imp_canalizacion);
                report.setHrectipodescri("Canalizaci�n Vena");
                report.setHrentipoimpres(5);
                report.setHrenconsulta(cirugia.getHcplnumero());
                report.setHredfecharegis(canalizacion.getHcvdfecregistr());
                lstReporte.add(report);
            }
            
            }
            
        if (cirugia.getChnotaenferms() != null && 
            !cirugia.getChnotaenferms().isEmpty()) {
            Iterator it = (cirugia.getChnotaenferms()).iterator();
            while (it.hasNext()) {

                Chnotaenferm nota;
                nota = null;

                nota = (Chnotaenferm)it.next();
                Chreporte report = new Chreporte();

                if(nota.getHnecrefiedolor() != null && !nota.getHnecrefiedolor().equals("") ){
                
                    report = new Chreporte();
                    report.setHrecdescripcio("Hora de la actividad: " + 
                                             formatearCampoHoraSimple(nota.getHnedfecregistr()));
                    report.setHrencodigo(imp_escaladolor);
                    report.setHrectipodescri("Escala del Dolor");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(nota.getHnedfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Usuario que realiza la actividad: " + 
                                             obtenerUsuario(nota.getHnecoperador()));
                    report.setHrencodigo(imp_escaladolor);
                    report.setHrectipodescri("Escala del Dolor");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(nota.getHnedfecregistr());
                    lstReporte.add(report);
                    
                    
                    report = new Chreporte();
                    report.setHrecdescripcio("****************************************************************************************************************************************************************");
                    report.setHrectipodescri("Escala del Dolor");
                    report.setHrencodigo(imp_escaladolor);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(nota.getHnedfecregistr());
                    lstReporte.add(report);
                    
                    report = new Chreporte();
                    report.setHrecdescripcio("Refiere dolor     : " + 
                                             formatearCampo(nota.getHnecrefiedolor()));
                    report.setHrencodigo(imp_escaladolor);
                    report.setHrectipodescri("Escala del Dolor");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(nota.getHnedfecregistr());
                    lstReporte.add(report);
                    
                    report = new Chreporte();
                    report.setHrecdescripcio("Escala de Dolor durante el procedimiento       : " + 
                                             formatearCampo(nota.getHnenescaladolo()));
                    report.setHrencodigo(imp_escaladolor);
                    report.setHrectipodescri("Escala del Dolor");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(nota.getHnedfecregistr());
                    if(nota.getHnecrefiedolor().equals("S")){
                        lstReporte.add(report);    
                    }
                    
                    
                    report = new Chreporte();
                    report.setHrectipodescri("Escala del Dolor");
                    report.setHrecdescripcio("Duraci�n del dolor Intenso: " + (formatearCampo(nota.getHnenduradolor())+ " " + formatearCampoTipoDuracion(nota.getHnecdudointen())));
                    report.setHrencodigo(imp_escaladolor);
                    report.setHrectipodescri("Escala del Dolor");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(nota.getHnedfecregistr());
                    if(nota.getHnecrefiedolor().equals("S")){
                        lstReporte.add(report);    
                    }
                    
                }
               

                

          
            }
            
            }
            

            if((cirugia.getChnotaenferms() != null && 
            !cirugia.getChnotaenferms().isEmpty()) || (cirugia.getChcanalivenas() != null && 
            !cirugia.getChcanalivenas().isEmpty()) ){
                try {
                    URL url_profamilia = 
                        FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
                    URL url_super_horizontal = 
                        FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
                    URL url_super_vertical = 
                        FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
                    Map parameters = new HashMap();
                    parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                    parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                    parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                    parameters.put("NOMBRE", NOMBRE);
                    parameters.put("TIPO_DOCUMENTO", TIPO_DOCUMENTO);
                    parameters.put("NOMBRE_PROFESIONAL", NOMBRE_PROFESIONAL);
                    parameters.put("NUMERO_DOCUMENTO", NUMERO_DOCUMENTO);
                    parameters.put("FECHA_NACIMIENTO", FECHA_NACIMIENTO);
                    parameters.put("DIRECCION", DIRECCION);
                    parameters.put("OCUPACION", OCUPACION);
                    parameters.put("RESPONSABLE", RESPONSABLE);
                    parameters.put("EDAD", EDAD);
                    parameters.put("TELEFONO", TELEFONO);
                    parameters.put("ESTADO_CIVIL", ESTADO_CIVIL);
                    parameters.put("PARENTESCO_RESPONSABLE", 
                                   PARENTESCO_RESPONSABLE);
                    parameters.put("SEXO", SEXO);
                    parameters.put("CIUDAD", CIUDAD);
                    parameters.put("TELEFONO_RESPONSABLE", TELEFONO_RESPONSABLE);
                    parameters.put("IMPRIMIO", IMPRIMIO);
                    parameters.put("REGISTRO_MEDICO", REGISTRO_MEDICO);
                    parameters.put("EPS", EPS);
                    parameters.put("PAGINAS_ANTERIORES", paginas_ant);
                    
                    parameters.put("ZONA", ZONA);
                    parameters.put("CONTRATO", CONTRATO);
                    parameters.put("ESTRATO", ESTRATO);
                    parameters.put("NIVELEDUCATIVO", NIVELEDUCATIVO);
                    parameters.put("BARRIO", BARRIO);
                    parameters.put("ETNIA", ETNIA);

                    JRBeanCollectionDataSource dataSource = 
                        new JRBeanCollectionDataSource(lstReporte);
                    File reportFile = 
                        new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/consultarFoliosCirugia.jasper"));

                    if (reportFile.exists()) {
                        try {
                            bytes = 
                                    JasperRunManager.runReportToPdf(reportFile.getPath(), 
                                                                    parameters, 
                                                                    dataSource);
                        } catch (JRException ex) {
                            ex.printStackTrace();
                            FacesUtils.addErrorMessage("No pudo generar Canalizaci�n. " + 
                                                       ex.getMessage());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            FacesUtils.addErrorMessage("No pudo generar Canalizaci�n. " + 
                                                       ex.getMessage());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                               e.getMessage());
                }
            }
        
        return bytes;
    }
    



    public byte[] generarMedicamentos(Chusuario usuario, Chcirugprogr cirugia, 
                                      Integer paginas_ant) {
        List<Chcontrmedic> medicamentos = new ArrayList<Chcontrmedic>();
        List<Chaldrete> aldre = null;

        byte[] bytes = null;

        try {
            medicamentos = 
                    this.serviceLocator.getCirugiaService().getFormulaMedicamentosCirugiaSuministrados(cirugia.getHcplnumero());
            aldre = 
                    this.serviceLocator.getCirugiaService().getAldrete(cirugia.getHcplnumero());

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (medicamentos != null && !medicamentos.isEmpty()) {
            JRBeanCollectionDataSource dataSource = 
                new JRBeanCollectionDataSource(medicamentos);
            File reportFile = 
                new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/Medicamentos.jasper"));

            if (reportFile.exists()) {
                Map parameters = new HashMap();
                try {
                    URL imagen = 
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
                                   usuario.getHuscprimernomb() + " " + 
                                   usuario.getHuscsegundnomb());
                    parameters.put("PAGINAS_ANTERIORES", paginas_ant);

                    bytes = 
                            JasperRunManager.runReportToPdf(reportFile.getPath(), 
                                                            parameters, 
                                                            dataSource);
                } catch (JRException ex) {
                    ex.printStackTrace();
                    FacesUtils.addErrorMessage("No pudo generar Reporte Control Medicamentos. " + 
                                               ex.getMessage());
                } catch (Exception ex) {
                    ex.printStackTrace();
                    FacesUtils.addErrorMessage("No pudo generar reporte Control Medicamentos. " + 
                                               ex.getMessage());
                }
            }
        }
        return bytes;
    }

    public byte[] generarControlLiquidos(Chusuario usuario, 
                                         Chcirugprogr cirugia, 
                                         Integer paginas_ant,Cnconsclin consulta) {
        byte[] bytes = null;
        Chdetacirpro detalleCirugia = null;
        Cpservicio servicio = null;
        List<Chcontroliqu> lstLiquidosParciales = null;
        List<Chcontroliqu> lstHistorialLiquidosEliminados = null;
        List<Chcontroliqu> lstHistorialLiquidosEliminadosTemp = null;
        List<Chcontroliqu> lstLiquidosAdministradosAnestesia = null;

        Integer totalLiqAdmin = 0;
        Integer totalLiqElim = 0;

        try {
            detalleCirugia = 
                    this.serviceLocator.getCirugiaService().getServicioDetalle(cirugia.getHcplnumero());
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (detalleCirugia != null) {
            try {
                servicio = 
                        this.serviceLocator.getClinicoService().getDescripcionCupsCompleto(detalleCirugia.getId().getHdccservicio());
                lstHistorialLiquidosEliminados = 
                        this.serviceLocator.getClinicoService().getLstLiquidosAdministradoEliminados(cirugia.getHcplnumero());
                lstLiquidosParciales = 
                        this.serviceLocator.getClinicoService().getLstLiquidosAdministradoParcialAnestesiaIni(cirugia.getHcplnumero());
                lstLiquidosAdministradosAnestesia = 
                        this.serviceLocator.getClinicoService().getLstLiquidosAdministradosAnestesia(cirugia.getHcplnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        } else {
                if (consulta != null) {
                    try {
                        servicio = 
                                this.serviceLocator.getClinicoService().getDescripcionCupsCompleto(consulta.getCcocservic().getCsvccodigo());
                        lstHistorialLiquidosEliminados = 
                                this.serviceLocator.getClinicoService().getLstLiquidosAdministradoEliminados(cirugia.getHcplnumero());
                        lstLiquidosParciales = 
                                this.serviceLocator.getClinicoService().getLstLiquidosAdministradoParcialAnestesiaIni(cirugia.getHcplnumero());
                        lstLiquidosAdministradosAnestesia = 
                                this.serviceLocator.getClinicoService().getLstLiquidosAdministradosAnestesia(cirugia.getHcplnumero());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                }
            }

        if (lstLiquidosAdministradosAnestesia == null || 
            lstLiquidosAdministradosAnestesia.isEmpty()) {
            lstLiquidosAdministradosAnestesia = new ArrayList<Chcontroliqu>();
        } else {
            for (Chcontroliqu contrliq: lstLiquidosAdministradosAnestesia) {
                if (contrliq.getHclncantisumin() != null)
                    totalLiqAdmin += contrliq.getHclncantisumin();
            }
        }

        if (lstHistorialLiquidosEliminados == null || 
            lstHistorialLiquidosEliminados.isEmpty()) {
            lstHistorialLiquidosEliminados = new ArrayList<Chcontroliqu>();
        } else {
            lstHistorialLiquidosEliminadosTemp = new ArrayList<Chcontroliqu>();
            for (Chcontroliqu contrliqE: lstHistorialLiquidosEliminados) {
                if (contrliqE.getHclndrenaje() != null) {
                    totalLiqElim += contrliqE.getHclndrenaje();
                    if(contrliqE.getHclccuantdrena() != null){
                        lstHistorialLiquidosEliminadosTemp.add(contrliqE);
                    }
                }
                if (contrliqE.getHclndiuresis() != null) {
                    totalLiqElim += contrliqE.getHclndiuresis();
                    if(contrliqE.getHclccuantdiure() != null){
                        lstHistorialLiquidosEliminadosTemp.add(contrliqE);
                    }
                }
                if (contrliqE.getHclndeposicion() != null) {
                    totalLiqElim += contrliqE.getHclndeposicion();
                    if(contrliqE.getHclccuantdepos() != null){
                        lstHistorialLiquidosEliminadosTemp.add(contrliqE);
                    }
                }
                if (contrliqE.getHclnemecan() != null) {
                    totalLiqElim += contrliqE.getHclnemecan();
                    if(contrliqE.getHclcemecua() != null){
                        lstHistorialLiquidosEliminadosTemp.add(contrliqE);
                    }
                }
            }
            if(lstHistorialLiquidosEliminadosTemp != null && !lstHistorialLiquidosEliminados.isEmpty()){
                lstHistorialLiquidosEliminados = new ArrayList<Chcontroliqu>();
                lstHistorialLiquidosEliminados.addAll(lstHistorialLiquidosEliminadosTemp);
            }
        }

        List<Chcontroliqu> historialLiquidos = new ArrayList<Chcontroliqu>();
        if (lstHistorialLiquidosEliminados != null)
            historialLiquidos.addAll(lstHistorialLiquidosEliminados);
        if (lstLiquidosAdministradosAnestesia != null)
            historialLiquidos.addAll(lstLiquidosAdministradosAnestesia);
        if (lstLiquidosParciales != null) {
            for (Chcontroliqu liqpa: lstLiquidosParciales) {
                if (liqpa.getHclctipoliqpar() != null && 
                    liqpa.getHclctipoliqpar().equals("01"))
                    liqpa.setHclcdesctipoli("Lactato de Ringer");
                if (liqpa.getHclctipoliqpar() != null && 
                    liqpa.getHclctipoliqpar().equals("02"))
                    liqpa.setHclcdesctipoli("Haemacell");
                if (liqpa.getHclctipoliqpar() != null && 
                    liqpa.getHclctipoliqpar().equals("03"))
                    liqpa.setHclcdesctipoli("Dextranes");
                if (liqpa.getHclctipoliqpar() != null && 
                    liqpa.getHclctipoliqpar().equals("04"))
                    liqpa.setHclcdesctipoli("Globulos Rojos");
                if (liqpa.getHclctipoliqpar() != null && 
                    liqpa.getHclctipoliqpar().equals("05"))
                    liqpa.setHclcdesctipoli("Sangre total");
                if (liqpa.getHclctipoliqpar() != null && 
                    liqpa.getHclctipoliqpar().equals("06"))
                    liqpa.setHclcdesctipoli("Plasma");
                if (liqpa.getHclctipoliqpar() != null && 
                    liqpa.getHclctipoliqpar().equals("07"))
                    liqpa.setHclcdesctipoli("Plaquetas");
            }
        }
        if (lstLiquidosParciales != null && !lstLiquidosParciales.isEmpty()) {
            historialLiquidos.addAll(lstLiquidosParciales);
        }

        for (Chcontroliqu list: historialLiquidos) {
            list.setTotalLiqAdmin(totalLiqAdmin);
            list.setTotalLiqElim(totalLiqElim);
        }

        if (historialLiquidos != null && !historialLiquidos.isEmpty()) {
            JRBeanCollectionDataSource dataSource = 
                new JRBeanCollectionDataSource(historialLiquidos);

            File reportFile = 
                new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/ControlLiquidos.jasper"));

            if (reportFile.exists()) {
                Map parameters = new HashMap();
                try {
                    URL imagen = 
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
                                   usuario.getHuscprimernomb() + " " + 
                                   usuario.getHuscsegundnomb());
                    parameters.put("PROCEDIMIENTO", servicio.getCsvcnombre());
                    parameters.put("PAGINAS_ANTERIORES", paginas_ant);

                    bytes = 
                            JasperRunManager.runReportToPdf(reportFile.getPath(), 
                                                            parameters, 
                                                            dataSource);
                } catch (JRException ex) {
                    ex.printStackTrace();
                    FacesUtils.addErrorMessage("No pudo generar Reporte Control Liquidos. " + 
                                               ex.getMessage());
                } catch (Exception ex) {
                    ex.printStackTrace();
                    FacesUtils.addErrorMessage("No pudo generar reporte Control Liquidos. " + 
                                               ex.getMessage());
                }
            }
        }
        return bytes;
    }


    public byte[] generarEvolucionMedica(Chusuario usuario, 
                                         Chcirugprogr cirugia, 
                                         Integer paginas_ant) {
        byte[] bytes = null;
        byte[] resu = null;
        List<byte[]> pdfs = new ArrayList<byte[]>();
        List<Chreporte> lstReporte = new ArrayList<Chreporte>();

        if (usuario != null) {
            if (usuario.getHusdfechanacim() != null) {
                FECHA_NACIMIENTO = usuario.getHusdfechanacim();
                if (FECHA_NACIMIENTO != null) {
                    int edad = calcularEdad(FECHA_NACIMIENTO, cirugia.getHcpdfecregistr());
                    EDAD = edad;
                }
            }
            if (getUsuarioSystem() != null) {
                IMPRIMIO = this.getUsuarioSystem().getCurcnombre();
            }
            if (usuario.getHuscprimernomb() != null) {
                NOMBRE = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                NOMBRE = NOMBRE + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundapel();
            }
            
            ZONA = formatearCampoZona(usuario.getHusezonareside());
            ESTRATO = usuario.getHusnestrato();
            NIVELEDUCATIVO = formatearCampoNivelEducativo(usuario.getHusnniveledu());
            BARRIO = usuario.getHuscbarrio();
            ETNIA = formatearCampoEtnia(usuario.getHuscetnia());
            
            if (usuario.getHusanumeiden() != null && 
                usuario.getHusanumeiden() != 0) {
                TIPO_DOCUMENTO = usuario.getHusetipoiden();
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }
            if (usuario.getHuscentidadadm() != null) {
                try {
                    EPS = 
serviceLocator.getClinicoService().getDescripcionEntidadByCodigo(usuario.getHuscentidadadm());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }

            SEXO = usuario.getHusesexo();
            DIRECCION = usuario.getHuscdireccion();
            TELEFONO = usuario.getHusctelefono();
            Integer idCiudad = usuario.getHusnciudad();
            Integer idDepartamento = usuario.getHusndepartamen();
            Cpmunidane ciudadObject = null;
            try {
                ciudadObject = 
                        this.serviceLocator.getClinicoService().getMunicipio(idCiudad, 
                                                                             idDepartamento);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (ciudadObject != null) {
                CIUDAD = ciudadObject.getCmdcnommun();
            }

            Integer ocupacion = usuario.getHusnocupacion();
            try {
                OCUPACION = 
                        serviceLocator.getClinicoService().getDescripcionOcupacion(ocupacion);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            ESTADO_CIVIL = usuario.getHuseestadcivil();
            RESPONSABLE = usuario.getHuscnomresponsa();
            PARENTESCO_RESPONSABLE = usuario.getHuscparresponsa();
            TELEFONO_RESPONSABLE = usuario.getHusctelresponsa();
            
            ZONA = formatearCampoZona(usuario.getHusezonareside());
            ESTRATO = usuario.getHusnestrato();
            NIVELEDUCATIVO = formatearCampoNivelEducativo(usuario.getHusnniveledu());
            BARRIO = usuario.getHuscbarrio();
            ETNIA = formatearCampoEtnia(usuario.getHuscetnia());
            
        }

        if (cirugia.getChevolucions() != null && 
            !cirugia.getChevolucions().isEmpty()) {
            Iterator it = (cirugia.getChevolucions()).iterator();
            while (it.hasNext()) {
                Chevolucion evolucion = (Chevolucion)it.next();

                if (evolucion != null) {
                    Chreporte report = new Chreporte();

                    report = new Chreporte();
                    report.setHrecdescripcio("****************************************************************************************************************************************************************");
                    report.setHrectipodescri("Evoluci�n");
                    report.setHrencodigo(imp_evolucion);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(evolucion.getHevdfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Fecha y Hora de la actividad: " + formatearCampoFechaLetras(evolucion.getHevdfecevoluci())  +" "+
                                             formatearCampoHoraSimple(evolucion.getHevdfecevoluci()) +"    Numero: " + evolucion.getId().getHevnconsecutiv() );
                    report.setHrencodigo(imp_evolucion);
                    report.setHrectipodescri("Evoluci�n");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(evolucion.getHevdfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Usuario que realiza la actividad: " + 
                                             obtenerUsuario(evolucion.getHevcoperador()));
                    report.setHrencodigo(imp_evolucion);
                    report.setHrectipodescri("Evoluci�n");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(evolucion.getHevdfecregistr());
                    lstReporte.add(report);
                    
                    report = new Chreporte();
                    report.setHrecdescripcio("Refiere dolor: " + 
                                             formatearCampo(evolucion.getHevcrefiedolor()));
                    report.setHrencodigo(imp_evolucion);
                    report.setHrectipodescri("Evoluci�n");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(evolucion.getHevdfecregistr());
                    lstReporte.add(report);
                    if (evolucion.getHevcrefiedolor() != null && 
                        evolucion.getHevcrefiedolor().equals("S")) {
                        report = new Chreporte();
                        report.setHrecdescripcio("Escala del dolor: " + 
                                                 formatearCampo(evolucion.getHevnescaladolo()));
                        report.setHrencodigo(imp_evolucion);
                        report.setHrectipodescri("Evoluci�n");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(evolucion.getHevdfecregistr());
                        lstReporte.add(report);
                        
                        report = new Chreporte();
                        report.setHrectipodescri("Evoluci�n");
                        report.setHrecdescripcio("Duraci�n del dolor Intenso: " + formatearCampo(evolucion.getHevnduradolor())+ " " + formatearCampoTipoDuracion(evolucion.getHevcdudointen()));
                        report.setHrencodigo(imp_evolucion);
                        report.setHrectipodescri("Evoluci�n");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(evolucion.getHevdfecregistr());
                        lstReporte.add(report);
                        
                    }

                    report = new Chreporte();
                    report.setHrecdescripcio("Notas sobre lo que refiere el paciente: " + 
                                             formatearCampo(evolucion.getHevcnotapacien()));
                    report.setHrencodigo(imp_evolucion);
                    report.setHrectipodescri("Evoluci�n");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(evolucion.getHevdfecregistr());
                    lstReporte.add(report);
                    
                    
                    
                    // Nuevo para formulaci�n otras        
                    List<Chcontroorden> lstOtrasOrdenes = 
                        new ArrayList<Chcontroorden>();
                    try {
                        lstOtrasOrdenes = 
                                this.serviceLocator.getCirugiaService().getOtrasOrdenesPorEvolucion(evolucion.getId().getHevlnumero(), 
                                                                                                         evolucion.getId().getHevnconsecutiv().longValue());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (lstOtrasOrdenes != null && 
                        !lstOtrasOrdenes.isEmpty()) {
                        String NOMBRE_OTRA_ORDEN = "";
                        
                        String DESCRIPCION_OTRA_ORDEN = "";
                        report = new Chreporte();
                        report.setHrecdescripcio("Otras Ordenes");
                        report.setHrencodigo(imp_evolucion);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(evolucion.getHevdfecregistr());
                        lstReporte.add(report);

                        Iterator itpr = lstOtrasOrdenes.iterator();
                        while (itpr.hasNext()) {
                            Chcontroorden otraOrden = 
                                (Chcontroorden)itpr.next();
                            NOMBRE_OTRA_ORDEN = 
                                    "Nombre de la orden: " + formatearCampoOtraOrden(otraOrden.getHcocnombreord());
                            
                            DESCRIPCION_OTRA_ORDEN = 
                                    "Descripci�n: " + otraOrden.getHcocordenenvi();
                            report = new Chreporte();
                            report.setHrecdescripcio(formatearCampo(NOMBRE_OTRA_ORDEN));
                            report.setHrencodigo(imp_evolucion);
                            report.setHrentipoimpres(1);
                            report.setHrenconsulta(cirugia.getHcplnumero());
                            report.setHredfecharegis(evolucion.getHevdfecregistr());
                            lstReporte.add(report);
                            
                            report = new Chreporte();
                            report.setHrecdescripcio(formatearCampo(DESCRIPCION_OTRA_ORDEN));
                            report.setHrencodigo(imp_evolucion);
                            report.setHrentipoimpres(1);
                            report.setHrenconsulta(cirugia.getHcplnumero());
                            report.setHredfecharegis(evolucion.getHevdfecregistr());
                            lstReporte.add(report);
                            if(otraOrden != null && otraOrden.getHcodfechaadmi() != null){
                               
                                String OTRAS_ORDENES_APLICA = ""; 
                              
                                
                                String usuario_nota = "";
                                usuario_nota = 
                                        formatearCampoNombreUsuario(otraOrden.getHcocoperaadmi(), 
                                                                    cirugia.getHcpnclinica());

                                OTRAS_ORDENES_APLICA = 
                                        OTRAS_ORDENES_APLICA + "Usuario que realiza la Otra Orden: " + 
                                        usuario_nota + "\n" + 
                                        "Administrado el : " + 
                                        formatearCampoHora(otraOrden.getHcodfechaadmi());
                                
                                report = new Chreporte();
                                report.setHrecdescripcio(OTRAS_ORDENES_APLICA);
                                report.setHrencodigo(imp_evolucion);
                                report.setHrentipoimpres(1);
                                report.setHrenconsulta(cirugia.getHcplnumero());
                                report.setHredfecharegis(evolucion.getHevdfecregistr());
                                lstReporte.add(report);
                                
                                
                                report = new Chreporte();
                                report.setHrecdescripcio("Observaci�n Aplicaci�n"  + otraOrden.getHcocobserva());
                                report.setHrencodigo(imp_evolucion);
                                report.setHrentipoimpres(1);
                                report.setHrenconsulta(cirugia.getHcplnumero());
                                report.setHredfecharegis(evolucion.getHevdfecregistr());
                                lstReporte.add(report);
                             
                            }

                        }
                    }
                    
                    // NUEVO Examen Fisico
                    
                     //Datos Examen Fisico

                     if (evolucion.getId().getHevlnumero() != null && 
                         evolucion.getId().getHevnconsecutiv() != null) {
                         Chexamfisico examen = null;


                        try {
                            examen =  serviceLocator.getClinicoService().getExamenFisico(evolucion.getId().getHevlnumero(),evolucion.getId().getHevnconsecutiv());
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }
                        
                        if(examen != null){
                        
                        
                         report = new Chreporte();
                         report.setHrectipodescri("Examen Fisico");
                         report.setHrecdescripcio("************************************************************************** Examen Fisico ***********************************************");
                         report.setHrencodigo(imp_evolucion);
                         report.setHrentipoimpres(1);
                         report.setHrenconsulta(cirugia.getHcplnumero());
                         report.setHredfecharegis(evolucion.getHevdfecregistr());
                         lstReporte.add(report);
                            
                       
                        report = new Chreporte();
                         report.setHrectipodescri("Examen Fisico");

                         if (examen.getHefcpresart1() != null && 
                             examen.getHefcpresart2() != null) {
                             report.setHrecdescripcio("Presi�n Arterial:  " + 
                             formatearCampo(examen.getHefcpresart1()) + "/" + 
                             formatearCampo(examen.getHefcpresart2()) + 
                             " mm Hg");
                         } else {
                             report.setHrecdescripcio("");
                         }

                         if (examen.getHefnfreccard() != null) {
                             report.setHrecdescripcio2("Frecuencia Cardiaca: " + 
                                                       formatearCampo(examen.getHefnfreccard()) );
                         } else {
                             report.setHrecdescripcio2("");
                         }

                         if (examen.getHefnfrecresp() != null) {
                             report.setHrecdescripcio3("Frecuencia Respiratoria: " + 
                                                       formatearCampo(examen.getHefnfrecresp()));
                         } else {
                             report.setHrecdescripcio3("");
                         }

                         report.setHrencodigo(imp_evolucion);
                         report.setHrentipoimpres(5);
                         report.setHrenconsulta(cirugia.getHcplnumero());
                         report.setHredfecharegis(evolucion.getHevdfecregistr());
                         lstReporte.add(report);

                         if (examen != null) {
                             report = new Chreporte();
                             report.setHrectipodescri("Examen Fisico");
                             if (examen.getHefapeso() != null) {
                                 report.setHrecdescripcio("Peso:  " + 
                                                          formatearCampo(examen.getHefapeso()) + " kg");
                             } else {
                                 report.setHrecdescripcio("");
                             }

                             if (examen.getHefatalla() != null) {
                                 report.setHrecdescripcio2("Talla : " + 
                                                           formatearCampo(examen.getHefatalla()) + " mts");
                             } else {
                                 report.setHrecdescripcio2("");
                             }

                             if (examen.getHefaimc() != null) {
                                 report.setHrecdescripcio3("IMC: " + 
                                                           formatearCampo(examen.getHefaimc()));
                             } else {
                                 report.setHrecdescripcio3("");
                             }

                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(5);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);
                         }


                         report = new Chreporte();
                         String LUGAR_TEMPERATURA = "";
                         String TIPO_TEMPERATURA = "";
                         String TEMPERATURA = "";
                         if (examen.getHefelugartemp() != null) {
                             if (examen.getHefelugartemp().equals("A")) {
                                 LUGAR_TEMPERATURA = "Axilar";
                             } else if (examen.getHefelugartemp().equals("B")) {
                                 LUGAR_TEMPERATURA = "Bucal";
                             }
                         }
                         
                         if(examen != null){
                            TEMPERATURA = formatearCampo(examen.getHefatemperatu()) + 
                             " �C";
                         }
                         
                         if (examen.getHefetipotemper() != null) {
                             if (examen.getHefetipotemper().equals("A")) {
                                 TIPO_TEMPERATURA = "Afebril";
                                 TEMPERATURA =   formatearCampo(examen.getHefatemperatu()) + 
                                         " �C";
                             } else if (examen.getHefetipotemper().equals("F")) {
                                 TIPO_TEMPERATURA = "Febril";
                                 TEMPERATURA = 
                                         formatearCampo(examen.getHefatemperatu()) + 
                                         " �C";
                             }


                         }
                         
                         
                         report.setHrectipodescri("Examen Fisico");
                         if (examen.getHefelugartemp() != null) {
                             report.setHrecdescripcio("Tipo Temperatura: " + 
                                                      formatearCampo(LUGAR_TEMPERATURA));

                             if (examen.getHefetipotemper() != null && 
                                 !examen.getHefetipotemper().equals("")) {
                                 report.setHrecdescripcio2("Resultado: " + 
                                                          formatearCampo(TIPO_TEMPERATURA));
                             } else {
                                 report.setHrecdescripcio2("");
                             }

                             if (examen.getHefatemperatu() != null) {
                                 report.setHrecdescripcio3("Temperatura: " + 
                                                       formatearCampo(TEMPERATURA));
                             } else {
                                 report.setHrecdescripcio3("");
                             }
                             
                         } else {
                             if (examen.getHefetipotemper() != null && 
                                 !examen.getHefetipotemper().equals("")) {
                                 report.setHrecdescripcio("Tipo Temperatura: " + 
                                                          formatearCampo(TIPO_TEMPERATURA));
                             } else {
                                 report.setHrecdescripcio("");
                             }


                             if (examen.getHefatemperatu() != null) {
                                 report.setHrecdescripcio2("Temperatura : " + 
                                                       formatearCampo(TEMPERATURA));
                             } else {
                                 report.setHrecdescripcio2("");
                             }
                         }
                         report.setHrencodigo(imp_evolucion);
                         report.setHrentipoimpres(5);
                         report.setHrenconsulta(cirugia.getHcplnumero());
                         report.setHredfecharegis(evolucion.getHevdfecregistr());
                         lstReporte.add(report);
                         
                         
                         if (examen.getHefcdiscapadid() != null && !examen.getHefcdiscapadid().equals("")) {
                             report = new Chreporte();
                             report.setHrectipodescri("Examen Fisico");
                             if (examen.getHefapeso() != null) {
                                 report.setHrecdescripcio("Condici�n de Discapacidad:  " + 
                                                          formatearCampo(examen.getHefcdiscapadid()));
                             } 

                             if (examen.getHefcdiscapadid().equals("S")) {
                                 report.setHrecdescripcio2("Cual?: " + 
                                                           formatearCampoDiscapacidad(examen.getHefcdiscaselec()));
                             } else {
                                 report.setHrecdescripcio2("");
                             }

                          
                                 report.setHrecdescripcio3("");
                             

                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(5);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);
                         }

                         if (examen.getHefthallazgo() != null && 
                             !examen.getHefthallazgo().equals("")) {
                             report = new Chreporte();
                             report.setHrectipodescri("Examen Fisico");
                             report.setHrecdescripcio("Estado del paciente al ingreso");
                             report.setHrecdescripcio2(formatearCampo(examen.getHefthallazgo()));
                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(3);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);

                         }


                         if (examen.getHeferefiepiel() != null && 
                             !examen.getHeferefiepiel().equals("")) {
                             report = new Chreporte();
                             report.setHrectipodescri("Examen Fisico");
                             report.setHrecdescripcio("Piel y faneras: ");

                             if (examen.getHeferefiepiel().equals("A")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefiepiel().equals("H")) {
                                 report.setHrecdescripcio2(formatearCampo(examen.getHefcrefiepiel()));
                             } else if (examen.getHeferefiepiel().equals("N")) {
                                 report.setHrecdescripcio2("No evaluado");
                             } else if (examen.getHeferefiepiel().equals("S")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefiepiel().equals("E")) {
                                 report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
                             }
                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(3);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);
                         }

                         if (examen.getHeferefiecrane() != null && 
                             !examen.getHeferefiecrane().equals("")) {
                             report = new Chreporte();
                             report.setHrectipodescri("Examen Fisico");
                             report.setHrecdescripcio("Craneo: ");

                             if (examen.getHeferefiecrane().equals("A")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefiecrane().equals("H")) {
                                 report.setHrecdescripcio2(formatearCampo(examen.getHefcrefiecrane()));
                             } else if (examen.getHeferefiecrane().equals("N")) {
                                 report.setHrecdescripcio2("No evaluado");
                             } else if (examen.getHeferefiecrane().equals("S")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefiecrane().equals("E")) {
                                 report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
                             }

                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(3);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);
                         }


                         if (examen.getHeferefieojos() != null && 
                             !examen.getHeferefieojos().equals("")) {
                             report = new Chreporte();
                             report.setHrectipodescri("Examen Fisico");
                             report.setHrecdescripcio("Ojos: ");

                             if (examen.getHeferefieojos().equals("A")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefieojos().equals("H")) {
                                 report.setHrecdescripcio2(formatearCampo(examen.getHefcrefieojos()));
                             } else if (examen.getHeferefieojos().equals("N")) {
                                 report.setHrecdescripcio2("No evaluado");
                             } else if (examen.getHeferefieojos().equals("S")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefieojos().equals("E")) {
                                 report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
                             }

                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(3);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);
                         }


                         if (examen.getHeferefieoidos() != null && 
                             !examen.getHeferefieoidos().equals("")) {
                             report = new Chreporte();
                             report.setHrectipodescri("Examen Fisico");
                             report.setHrecdescripcio("O�dos: ");

                             if (examen.getHeferefieoidos().equals("A")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefieoidos().equals("H")) {
                                 report.setHrecdescripcio2(formatearCampo(examen.getHefcrefieoidos()));
                             } else if (examen.getHeferefieoidos().equals("N")) {
                                 report.setHrecdescripcio2("No evaluado");
                             } else if (examen.getHeferefieoidos().equals("S")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefieoidos().equals("E")) {
                                 report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
                             }

                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(3);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);
                         }

                         if (examen.getHeferefienariz() != null && 
                             !examen.getHeferefienariz().equals("")) {
                             report = new Chreporte();
                             report.setHrectipodescri("Examen Fisico");
                             report.setHrecdescripcio("Nariz: ");

                             if (examen.getHeferefienariz().equals("A")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefienariz().equals("H")) {
                                 report.setHrecdescripcio2(formatearCampo(examen.getHefcrefienariz()));
                             } else if (examen.getHeferefienariz().equals("N")) {
                                 report.setHrecdescripcio2("No evaluado");
                             } else if (examen.getHeferefienariz().equals("S")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefienariz().equals("E")) {
                                 report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
                             }

                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(3);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);
                         }

                         if (examen.getHeferefieboca() != null && 
                             !examen.getHeferefieboca().equals("")) {
                             report = new Chreporte();
                             report.setHrectipodescri("Examen Fisico");
                             report.setHrecdescripcio("Boca: ");

                             if (examen.getHeferefieboca().equals("A")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefieboca().equals("H")) {
                                 report.setHrecdescripcio2(formatearCampo(examen.getHefcrefieboca()));
                             } else if (examen.getHeferefieboca().equals("N")) {
                                 report.setHrecdescripcio2("No evaluado");
                             } else if (examen.getHeferefieboca().equals("S")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefieboca().equals("E")) {
                                 report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
                             }

                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(3);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);
                         }

                         if (examen.getHeferefiecuell() != null && 
                             !examen.getHeferefiecuell().equals("")) {
                             report = new Chreporte();
                             report.setHrectipodescri("Examen Fisico");
                             report.setHrecdescripcio("Cuello: ");

                             if (examen.getHeferefiecuell().equals("A")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefiecuell().equals("H")) {
                                 report.setHrecdescripcio2(formatearCampo(examen.getHefcrefiecuell()));
                             } else if (examen.getHeferefiecuell().equals("N")) {
                                 report.setHrecdescripcio2("No evaluado");
                             } else if (examen.getHeferefiecuell().equals("S")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefiecuell().equals("E")) {
                                 report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
                             }

                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(3);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);
                         }

                         if (examen.getHeferefietorax() != null && 
                             !examen.getHeferefietorax().equals("")) {
                             report = new Chreporte();
                             report.setHrectipodescri("Examen Fisico");
                             report.setHrecdescripcio("T�rax y pulmones: ");

                             if (examen.getHeferefietorax().equals("A")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefietorax().equals("H")) {
                                 report.setHrecdescripcio2(formatearCampo(examen.getHefcrefietorax()));
                             } else if (examen.getHeferefietorax().equals("N")) {
                                 report.setHrecdescripcio2("No evaluado");
                             } else if (examen.getHeferefietorax().equals("S")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefietorax().equals("E")) {
                                 report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
                             }

                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(3);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);
                         }

                         if (examen.getHeferefiecoraz() != null && 
                             !examen.getHeferefiecoraz().equals("")) {
                             report = new Chreporte();
                             report.setHrectipodescri("Examen Fisico");
                             report.setHrecdescripcio("Coraz�n: ");

                             if (examen.getHeferefiecoraz().equals("A")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefiecoraz().equals("H")) {
                                 report.setHrecdescripcio2(formatearCampo(examen.getHefcrefiecoraz()));
                             } else if (examen.getHeferefiecoraz().equals("N")) {
                                 report.setHrecdescripcio2("No evaluado");
                             } else if (examen.getHeferefiecoraz().equals("S")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefiecoraz().equals("E")) {
                                 report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
                             }

                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(3);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);
                         }

                         if (examen.getHeferefiesenos() != null && 
                             !examen.getHeferefiesenos().equals("")) {
                             report = new Chreporte();
                             report.setHrectipodescri("Examen Fisico");
                             report.setHrecdescripcio("Mamas: ");

                             if (examen.getHeferefiesenos().equals("A")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefiesenos().equals("H")) {
                                 report.setHrecdescripcio2(formatearCampo(examen.getHefcrefiesenos()));
                             } else if (examen.getHeferefiesenos().equals("N")) {
                                 report.setHrecdescripcio2("No evaluado");
                             } else if (examen.getHeferefiesenos().equals("S")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefiesenos().equals("E")) {
                                 report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
                             }

                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(3);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);
                             //TODO: CAMBIO 
                         } else if (examen.getHeferefiepiel() != null && 
                                    examen.getHeferefiepiel().equals("S")) {
                             report.setHrecdescripcio2("Sin Alteraciones aparentes");
                         }

                         if (examen.getHeferefieabdom() != null && 
                             !examen.getHeferefieabdom().equals("")) {
                             report = new Chreporte();
                             report.setHrectipodescri("Examen Fisico");
                             report.setHrecdescripcio("Abdomen: ");

                             if (examen.getHeferefieabdom().equals("A")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefieabdom().equals("H")) {
                                 report.setHrecdescripcio2(formatearCampo(examen.getHefcrefieabdom()));
                             } else if (examen.getHeferefieabdom().equals("N")) {
                                 report.setHrecdescripcio2("No evaluado");
                             } else if (examen.getHeferefieabdom().equals("S")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefieabdom().equals("E")) {
                                 report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
                             }

                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(3);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);
                         }

                         if (examen.getHeferefiegenit() != null && 
                             !examen.getHeferefiegenit().equals("")) {
                             report = new Chreporte();
                             report.setHrectipodescri("Examen Fisico");
                             report.setHrecdescripcio("Genitales: ");

                             if (examen.getHeferefiegenit().equals("A")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefiegenit().equals("H")) {
                                 report.setHrecdescripcio2(formatearCampo(examen.getHefcrefiegenit()));
                             } else if (examen.getHeferefiegenit().equals("N")) {
                                 report.setHrecdescripcio2("No evaluado");
                             } else if (examen.getHeferefiegenit().equals("S")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefiegenit().equals("E")) {
                                 report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
                             }

                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(3);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);
                         }

                         if (examen.getHeferefietacto() != null && 
                             !examen.getHeferefietacto().equals("")) {
                             report = new Chreporte();
                             report.setHrectipodescri("Examen Fisico");
                             report.setHrecdescripcio("Tacto vaginal: ");

                             if (examen.getHeferefietacto().equals("A")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefietacto().equals("H")) {
                                 report.setHrecdescripcio2(formatearCampo(examen.getHefcrefietacto()));
                             } else if (examen.getHeferefietacto().equals("N")) {
                                 report.setHrecdescripcio2("No evaluado");
                             } else if (examen.getHeferefietacto().equals("S")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefietacto().equals("E")) {
                                 report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
                             }

                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(3);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);
                         }

                         if (examen.getHeferefieextre() != null && 
                             !examen.getHeferefieextre().equals("")) {
                             report = new Chreporte();
                             report.setHrectipodescri("Examen Fisico");
                             report.setHrecdescripcio("Extremidades: ");

                             if (examen.getHeferefieextre().equals("A")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefieextre().equals("H")) {
                                 report.setHrecdescripcio2(formatearCampo(examen.getHefcrefieextre()));
                             } else if (examen.getHeferefieextre().equals("N")) {
                                 report.setHrecdescripcio2("No evaluado");
                             } else if (examen.getHeferefieextre().equals("S")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefieextre().equals("E")) {
                                 report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
                             }

                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(3);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);
                         }

                         if (examen.getHeferefieneuro() != null && 
                             !examen.getHeferefieneuro().equals("")) {
                             report = new Chreporte();
                             report.setHrectipodescri("Examen Fisico");
                             report.setHrecdescripcio("Neuromuscular: ");

                             if (examen.getHeferefieneuro().equals("A")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefieneuro().equals("H")) {
                                 report.setHrecdescripcio2(formatearCampo(examen.getHefcrefieneuro()));
                             } else if (examen.getHeferefieneuro().equals("N")) {
                                 report.setHrecdescripcio2("No evaluado");
                             } else if (examen.getHeferefieneuro().equals("S")) {
                                 report.setHrecdescripcio2("Sin Alteraciones aparentes");
                             } else if (examen.getHeferefieneuro().equals("E")) {
                                 report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
                             }

                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(3);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);
                         }

                     }
                    
                    }
                    //TODO: Nuevo Impresion Diagnostica
                    
                    
                    
                     // Datos Impresi�n Diagnostica

                      if (evolucion.getId().getHevlnumero() != null && 
                          evolucion.getId().getHevnconsecutiv() != null) {

                          report = new Chreporte();
                          Chimprdiag impresion = null;
                         Crdgncie10 diagprin = null;
                         Crdgncie10 diagrela1 = null;
                         Crdgncie10 diagrela2 = null;
                         Crdgncie10 diagrela3 = null;
                       

                        
                         String RECOMENDACIONES_IMPRESION = "";
                         String DIAGNOSTICO_PRINCIPAL = "";
                          String DIAGNOSTICO_RELACIONADO1 = "";
                         String DIAGNOSTICO_RELACIONADO2 = "";
                          String DIAGNOSTICO_RELACIONADO3 = "";
                         String GRADO_EXAMEN_ASA = null;


                         String s = "";
                         String s2 = "";

                         String s3 = "";


                        try {
                            impresion = serviceLocator.getClinicoService().getImresionDiagnostica(evolucion.getId().getHevlnumero(),evolucion.getId().getHevnconsecutiv());
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }
                        
                         try {
                             if (impresion != null && impresion.getHidcdiagprin() != null && impresion.getHidcdiagprin() != null) {
                                 diagprin = 
                                         this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagprin().toUpperCase());
                             }

                         } catch (ModelException e) {
                             e.printStackTrace();
                         }
                         if (diagprin != null && 
                             impresion.getHidcdiagprin() != null) {
                             DIAGNOSTICO_PRINCIPAL = 
                                     impresion.getHidcdiagprin().toUpperCase() + 
                                     " " + diagprin.getCdccdescri();
                         }
                         
                        
                        String TIPO_DIAGNOSTICO = null;
                        
                         if (impresion != null && impresion.getHidntipodiagn() != null && impresion.getHidntipodiagn() != null && 
                             impresion.getHidntipodiagn().equals(1)) {
                             TIPO_DIAGNOSTICO = "Impresi�n Diagnostica";
                         } else if (impresion != null && impresion.getHidntipodiagn() != null && 
                                    impresion.getHidntipodiagn().equals(2)) {
                             TIPO_DIAGNOSTICO = "Confirmado Nuevo";
                         } else if (impresion != null && impresion.getHidntipodiagn() != null && 
                                    impresion.getHidntipodiagn().equals(3)) {
                             TIPO_DIAGNOSTICO = "Confirmado repetido";
                         }
                         
                         
                        if(impresion != null){
                            report = new Chreporte();
                            report.setHrectipodescri("Impresi�n Diagnostica");
                            report.setHrecdescripcio("************************************************************************** Impresi�n Diagnostica ***************************************************************");
                            report.setHrencodigo(imp_evolucion);
                            report.setHrentipoimpres(1);
                            report.setHrenconsulta(cirugia.getHcplnumero());
                            report.setHredfecharegis(evolucion.getHevdfecregistr());
                            lstReporte.add(report);
                            
                        }
                            
                        
                        if (TIPO_DIAGNOSTICO != null && !TIPO_DIAGNOSTICO.equals("")) {
                             s = "Tipo de Diagnostico:  " + TIPO_DIAGNOSTICO;
                             report = new Chreporte();
                             report.setHrecdescripcio(s);
                             report.setHrectipodescri("Impresi�n Diagnostica");
                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(1);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);
                         }
                         
                         try {
                             if (impresion != null && impresion.getHidcdiagprin() != null) {
                                 diagprin = 
                                         this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagprin().toUpperCase());
                             }

                         } catch (ModelException e) {
                             e.printStackTrace();
                         }
                         if (diagprin != null && 
                             impresion.getHidcdiagprin() != null) {
                             DIAGNOSTICO_PRINCIPAL = 
                                     impresion.getHidcdiagprin().toUpperCase() + 
                                     " " + diagprin.getCdccdescri();
                         }
                         
                         if (diagrela1 != null && 
                             impresion.getHidcdiagrela1() != null) {
                             DIAGNOSTICO_RELACIONADO1 = 
                                     impresion.getHidcdiagrela1().toUpperCase() + 
                                     " " + diagrela1.getCdccdescri();
                         }

                         try {
                             if (impresion != null && impresion.getHidcdiagrela2() != null) {
                                 diagrela2 = 
                                         this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagrela2().toUpperCase());
                             }

                         } catch (ModelException e) {
                             e.printStackTrace();
                         }

                         if (diagrela2 != null && 
                             impresion.getHidcdiagrela2() != null) {
                             DIAGNOSTICO_RELACIONADO2 = 
                                     impresion.getHidcdiagrela2().toUpperCase() + 
                                     " " + diagrela2.getCdccdescri();
                         }

                         try {
                             if (impresion != null && impresion.getHidcdiagrela3() != null) {
                                 diagrela3 = 
                                         this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagrela3().toUpperCase());
                             }

                         } catch (ModelException e) {
                             e.printStackTrace();
                         }
                         if (diagrela3 != null && impresion != null && 
                             impresion.getHidcdiagrela3() != null) {
                             DIAGNOSTICO_RELACIONADO3 = 
                                     impresion.getHidcdiagrela3().toUpperCase() + 
                                     " " + diagrela3.getCdccdescri();
                         }

                         
                        if(impresion != null){

                            s = 
  "Diagnostico Principal:  " + formatearCampo(DIAGNOSTICO_PRINCIPAL);
                            report = new Chreporte();
                            report.setHrecdescripcio(s);
                            report.setHrectipodescri("Impresi�n Diagnostica");
                            report.setHrencodigo(imp_evolucion);
                            report.setHrentipoimpres(1);
                            report.setHrenconsulta(cirugia.getHcplnumero());
                            report.setHredfecharegis(evolucion.getHevdfecregistr());
                            lstReporte.add(report);   
                        }
                         
                    
                       



                         if (DIAGNOSTICO_RELACIONADO1 != null && 
                             !DIAGNOSTICO_RELACIONADO1.equals("")) {
                             s = 
                     "Diagnostico Relacionado 1:  " + formatearCampo(DIAGNOSTICO_RELACIONADO1);
                             report = new Chreporte();
                             report.setHrecdescripcio(s);
                             report.setHrectipodescri("Impresi�n Diagnostica");
                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(1);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);
                         }

                         if (DIAGNOSTICO_RELACIONADO2 != null && 
                             !DIAGNOSTICO_RELACIONADO2.equals("")) {
                             s = 
                     "Diagnostico Relacionado 2:  " + formatearCampo(DIAGNOSTICO_RELACIONADO2);
                             report = new Chreporte();
                             report.setHrecdescripcio(s);
                             report.setHrectipodescri("Impresi�n Diagnostica");
                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(1);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);
                         }

                         if (DIAGNOSTICO_RELACIONADO3 != null && 
                             !DIAGNOSTICO_RELACIONADO3.equals("")) {
                             s = 
                     "Diagnostico Relacionado 3:  " + formatearCampo(DIAGNOSTICO_RELACIONADO3);
                             report = new Chreporte();
                             report.setHrecdescripcio(s);
                             report.setHrectipodescri("Impresi�n Diagnostica");
                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(1);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);

                         }

                         if (RECOMENDACIONES_IMPRESION != null && 
                             !RECOMENDACIONES_IMPRESION.equals("")) {
                             s = "Observaciones:  " + RECOMENDACIONES_IMPRESION;
                             report = new Chreporte();
                             report.setHrecdescripcio(s);
                             report.setHrectipodescri("Impresi�n Diagnostica");
                             report.setHrencodigo(imp_evolucion);
                             report.setHrentipoimpres(1);
                             report.setHrenconsulta(cirugia.getHcplnumero());
                             report.setHredfecharegis(evolucion.getHevdfecregistr());
                             lstReporte.add(report);
                         }

                     }
                    
   
                    
                    // Nuevo para formulaci�n medicamentos        
                    List<Chformulahos> lstPrescripciones = 
                        new ArrayList<Chformulahos>();
                    try {
                        lstPrescripciones = 
                                this.serviceLocator.getCirugiaService().getFormulaMedicamentosEvolucion(evolucion.getId().getHevlnumero(), 
                                                                                                      evolucion.getId().getHevnconsecutiv());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (lstPrescripciones != null && 
                        !lstPrescripciones.isEmpty()) {
                        String MEDICAMENTO = "";
                        String FORMULA = "";
                        report = new Chreporte();
                        report.setHrecdescripcio("Medicamentos Formulados");
                        report.setHrencodigo(imp_evolucion);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(evolucion.getHevdfecregistr());
                        lstReporte.add(report);

                        Iterator itpr = lstPrescripciones.iterator();
                        while (itpr.hasNext()) {
                            Chformulahos formula = (Chformulahos)itpr.next();
                            if (formula != null) {
                                String via = "";
                                if (formula.getHfhcviadministr().equals("VO")) {
                                    via = "Via Oral";
                                } else if (formula.getHfhcviadministr().equals("IV")) {
                                    via = "Via Intravenosa";
                                } else if (formula.getHfhcviadministr().equals("IM")) {
                                    via = "Via Intramuscular";
                                } else if (formula.getHfhcviadministr().equals("VA")) {
                                    via = "Via Intravaginal";
                                } else if (formula.getHfhcviadministr().equals("SC")) {
                                    via = "Subcut�nea";
                                } else {
                                    via = "Otra";
                                }

                                MEDICAMENTO = 
                                        "Medicamento: " + formula.getHfhcmedicament();
                                FORMULA = 
                                        "Presentaci�n: " + formula.getHfhcpresentaci() + 
                                        "  Dosis: " + 
                                        formula.getHfhcadosis().toString() + 
                                        " " + formula.getHfhcunidad() + 
                                        "  Frecuencia (Horas): " + 
                                        formula.getHfhnfrecuadmin() + 
                                        "  V�a Administraci�n: " + via;
                                report = new Chreporte();
                                report.setHrectipodescri("Medicamentos");
                                report.setHrecdescripcio(formatearCampo(MEDICAMENTO));
                                report.setHrencodigo(imp_evolucion);
                                report.setHrentipoimpres(1);
                                report.setHrenconsulta(cirugia.getHcplnumero());
                                report.setHredfecharegis(evolucion.getHevdfecregistr());
                                lstReporte.add(report);

                                report = new Chreporte();
                                report.setHrectipodescri("Medicamentos");
                                report.setHrecdescripcio(formatearCampo(FORMULA));
                                report.setHrencodigo(imp_evolucion);
                                report.setHrentipoimpres(1);
                                report.setHrenconsulta(cirugia.getHcplnumero());
                                report.setHredfecharegis(evolucion.getHevdfecregistr());
                                lstReporte.add(report);
                            }
                        }
                    }


                    // Nuevo para suspensi�n medicamentos        
                    List<Chformulahos> lstSuspensiones = 
                        new ArrayList<Chformulahos>();
                    try {
                        lstSuspensiones = 
                                this.serviceLocator.getCirugiaService().getSuspendeMedicamentosEvolucion(evolucion.getId().getHevlnumero(), 
                                                                                                         evolucion.getId().getHevnconsecutiv());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (lstSuspensiones != null && 
                        !lstSuspensiones.isEmpty()) {
                        String MEDICAMENTO = "";
                        String FORMULA = "";
                        report = new Chreporte();
                        report.setHrecdescripcio("Medicamentos Suspendidos");
                        report.setHrencodigo(imp_evolucion);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(evolucion.getHevdfecregistr());
                        lstReporte.add(report);

                        Iterator itpr = lstSuspensiones.iterator();
                        while (itpr.hasNext()) {
                            Chformulahos suspendido = (Chformulahos)itpr.next();
                            if (suspendido != null) {
                                String via = "";
                                if (suspendido.getHfhcviadministr().equals("VO")) {
                                    via = "Via Oral";
                                } else if (suspendido.getHfhcviadministr().equals("IV")) {
                                    via = "Via Intravenosa";
                                } else if (suspendido.getHfhcviadministr().equals("IM")) {
                                    via = "Via Intramuscular";
                                } else if (suspendido.getHfhcviadministr().equals("VA")) {
                                    via = "Via Intravaginal";
                                } else if (suspendido.getHfhcviadministr().equals("SC")) {
                                    via = "Subcut�nea";
                                } else {
                                    via = "Otra";
                                }

                                MEDICAMENTO = 
                                        "Medicamento: " + suspendido.getHfhcmedicament();
                                FORMULA = 
                                        "Presentaci�n: " + suspendido.getHfhcpresentaci() + 
                                        "  Dosis: " + 
                                        suspendido.getHfhcadosis().toString() + 
                                        " " + suspendido.getHfhcunidad() + 
                                        "  Frecuencia (Horas): " + 
                                        suspendido.getHfhnfrecuadmin() + 
                                        "  V�a Administraci�n: " + via;
                                report = new Chreporte();
                                report.setHrectipodescri("Medicamentos Suspendidos");
                                report.setHrecdescripcio(formatearCampo(MEDICAMENTO));
                                report.setHrencodigo(imp_evolucion);
                                report.setHrentipoimpres(1);
                                report.setHrenconsulta(cirugia.getHcplnumero());
                                report.setHredfecharegis(evolucion.getHevdfecregistr());
                                lstReporte.add(report);

                                report = new Chreporte();
                                report.setHrectipodescri("Medicamentos Suspendidos");
                                report.setHrecdescripcio(formatearCampo(FORMULA));
                                report.setHrencodigo(imp_evolucion);
                                report.setHrentipoimpres(1);
                                report.setHrenconsulta(cirugia.getHcplnumero());
                                report.setHredfecharegis(evolucion.getHevdfecregistr());
                                lstReporte.add(report);
                            }
                        }
                    }



                    // Nuevo para formulaci�n liquidos        
                    List<Chformulaliq> lstLiquidos = 
                        new ArrayList<Chformulaliq>();
                    try {
                        lstLiquidos = 
                                this.serviceLocator.getCirugiaService().getLstLiquidosFormuladosReporte(evolucion.getId().getHevlnumero(), 
                                                                                                 evolucion.getId().getHevctiposervi(), 
                                                                                                 evolucion.getId().getHevnconsecutiv());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    if (lstLiquidos != null && !lstLiquidos.isEmpty()) {
                        String LIQUIDO = "";
                        report = new Chreporte();
                        report.setHrecdescripcio("Liquidos Formulados");
                        report.setHrencodigo(imp_evolucion);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(evolucion.getHevdfecregistr());
                        lstReporte.add(report);

                        Iterator itlq = lstLiquidos.iterator();
                        while (itlq.hasNext()) {
                            Chformulaliq liquido = (Chformulaliq)itlq.next();
                            if (liquido != null) {
                                String liqui = "";

                                if (liquido.getHflcnombreliqu().equals("01")) {
                                    liqui = "Lactato de Ringer";
                                } else if (liquido.getHflcnombreliqu().equals("02")) {
                                    liqui = "Haemacell";
                                } else if (liquido.getHflcnombreliqu().equals("03")) {
                                    liqui = "Dextranes";
                                } else if (liquido.getHflcnombreliqu().equals("04")) {
                                    liqui = "Globulos Rojos";
                                } else if (liquido.getHflcnombreliqu().equals("05")) {
                                    liqui = "Sangre total";
                                } else if (liquido.getHflcnombreliqu().equals("06")) {
                                    liqui = "Plasma";
                                } else if (liquido.getHflcnombreliqu().equals("07")) {
                                    liqui = "Plaquetas";
                                }

                                String via = "";
                                if (liquido.getHflcviadminist() != null) {
                                    if (liquido.getHflcviadminist().equals("IV")) {
                                        via = "Intravenosa";
                                    } else if (liquido.getHflcviadminist().equals("SL")) {
                                        via = "Sublingual";
                                    }
                                }
                                String forma = "";
                                if (liquido.getHflcformadmins() != null) {
                                    if (liquido.getHflcformadmins().equals("L")) {
                                        forma = "En Bolo";
                                    } else if (liquido.getHflcformadmins().equals("I")) {
                                        forma = "En infusi�n";
                                    }
                                }

                                LIQUIDO = 
                                        "Liquido: " + liqui + "  Dosis: " + liquido.getHflncantidad() + 
                                        "  Via: " + via + "  Forma: " + forma + 
                                        "  Velocidad Adm.: " + 
                                        liquido.getHflnvelocidadm();
                                report = new Chreporte();
                                report.setHrecdescripcio(formatearCampo(LIQUIDO));
                                report.setHrencodigo(imp_evolucion);
                                report.setHrentipoimpres(1);
                                report.setHrenconsulta(cirugia.getHcplnumero());
                                report.setHredfecharegis(evolucion.getHevdfecregistr());
                                lstReporte.add(report);

                            }
                        }
                    }
                }
            }

            // Comienza adici�n evoluci�n nuevo
            String RECOMENDACIONES_CONDUCTA = "";
            String RECOMENDACIONES_PLANMANEJO = "";
            String TIPO_INCAPACIDAD = "";
            String ORIGEN_INCAPACIDAD = "";
            String FECHA_INICIAL_INCAPACIDAD = "";
            Integer DIAS_INCAPACIDAD = 0;
            String FECHA_FINAL_INCAPACIDAD = "";
            String HORA_CIRUGIA1 = "";
            String HORA_CIRUGIA2 = "";
            String FECHA_CIRUGIA1 = "";
            String FECHA_CIRUGIA2 = "";
            String ANESTESIA_SOLICITADA = "";
            String INTERVENCIONES_PROPUESTAS = "";
            String OBSERVACIONES_ORDEN = "";
            String PACIENTE_ACEPTA_ORDEN = "";
            String LUGAR_CIRUGIA = "";
            String AYUDANTIA = "";
            String ESTANCIA = "";
            Integer NUMERO_DIAS_ESTANCIA = 0;
            String RESERVA_SANGRE = "";
            Integer UNIDADES_SANGRE = 0;
            String PROGRAMAR_ANESTESIOLOGO = "";
            String PATOLOGIA = "";

            Chconsulta consultaAux = null;
            try {
                consultaAux = 
                        this.serviceLocator.getClinicoService().getConsultaCompleta(cirugia.getHcplnumero(), 
                                                                                    "");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (consultaAux.getChconductas() != null && 
                !consultaAux.getChconductas().isEmpty()) {
                Chconducta conducta = null;
                Iterator itcn = consultaAux.getChconductas().iterator();
                if (itcn.hasNext()) {
                    conducta = (Chconducta)itcn.next();
                }
                if (conducta != null) {
                    RECOMENDACIONES_CONDUCTA = conducta.getHcncobservacio();
                    RECOMENDACIONES_PLANMANEJO = conducta.getHcncplanmanejo();
                }

                Chreporte report = new Chreporte();
                report.setHrecdescripcio("Recomendaciones: " + 
                                         formatearCampo(RECOMENDACIONES_CONDUCTA));
                report.setHrectipodescri("Conducta ");
                report.setHrencodigo(imp_conducta);
                report.setHrentipoimpres(1);
                report.setHrenconsulta(consulta.getHcolnumero());
                report.setHredfecharegis(consulta.getHcodfecregistr());
                lstReporte.add(report);

                if (RECOMENDACIONES_PLANMANEJO != null && 
                    !RECOMENDACIONES_PLANMANEJO.equals("")) {
                    report = new Chreporte();
                    report.setHrecdescripcio("Plan de Manejo: " + 
                                             formatearCampo(RECOMENDACIONES_PLANMANEJO));
                    report.setHrectipodescri("Conducta ");
                    report.setHrencodigo(imp_conducta);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);
                }
            }

            if (consultaAux.getChincapacidas() != null && 
                !consultaAux.getChincapacidas().isEmpty()) {
                Chincapacida incapacidad = null;
                Iterator itin = consultaAux.getChincapacidas().iterator();
                if (itin.hasNext()) {
                    incapacidad = (Chincapacida)itin.next();
                }

                if (incapacidad != null) {
                    TIPO_INCAPACIDAD = "";
                    ORIGEN_INCAPACIDAD = "";
                    Integer tipo = incapacidad.getHidntipoincapa();
                    if (tipo != null && tipo.equals(1)) {
                        TIPO_INCAPACIDAD = "Hospilitaria";
                    } else if (tipo != null && tipo.equals(2)) {
                        TIPO_INCAPACIDAD = "Ambulatoria";
                    } else if (tipo != null && tipo.equals(3)) {
                        TIPO_INCAPACIDAD = "Cirugia Ambulatoria";
                    }

                    Integer origen = incapacidad.getHidnorigeincap();
                    if (origen != null && origen.equals(1)) {
                        ORIGEN_INCAPACIDAD = "Enfermedad general";
                    } else if (origen != null && origen.equals(2)) {
                        ORIGEN_INCAPACIDAD = "Enfermedad profesional";
                    } else if (origen != null && origen.equals(3)) {
                        ORIGEN_INCAPACIDAD = "Licencia de Maternidad ";
                    } else if (origen != null && origen.equals(4)) {
                        ORIGEN_INCAPACIDAD = "Accidente de Trabajo ";
                    } else if (origen != null && origen.equals(5)) {
                        ORIGEN_INCAPACIDAD = "Accidente de Transito ";
                    } else if (origen != null && origen.equals(6)) {
                        ORIGEN_INCAPACIDAD = "Licencia de Paternidad ";
                    }

                    Date fechaInicial = incapacidad.getHindfecinicia();
                    if (fechaInicial != null) {
                        FECHA_INICIAL_INCAPACIDAD = 
                                formatearCampo(fechaInicial);
                    }

                    DIAS_INCAPACIDAD = incapacidad.getHidndias();
                    if (incapacidad.getHindfecinicia() != null && 
                        DIAS_INCAPACIDAD != null) {
                        Calendar fechaFinalAux = Calendar.getInstance();
                        fechaFinalAux.setTime(incapacidad.getHindfecinicia());
                        fechaFinalAux.add(Calendar.DAY_OF_YEAR, 
                                          DIAS_INCAPACIDAD - 1);
                        FECHA_FINAL_INCAPACIDAD = 
                                formatearCampo(fechaFinalAux.getTime());
                    }
                }

                Chreporte report = new Chreporte();
                report = new Chreporte();
                report.setHrecdescripcio("Fecha Inicial: " + 
                                         formatearCampo(FECHA_INICIAL_INCAPACIDAD));
                report.setHrecdescripcio2("Fecha Final: " + 
                                          formatearCampo(FECHA_FINAL_INCAPACIDAD));
                report.setHrectipodescri("Incapacidad ");
                report.setHrencodigo(imp_incapacidad);
                report.setHrentipoimpres(6);
                report.setHrenconsulta(consulta.getHcolnumero());
                report.setHredfecharegis(consulta.getHcodfecregistr());
                lstReporte.add(report);

                report = new Chreporte();
                report.setHrecdescripcio("Tipo Incapacidad: " + 
                                         formatearCampo(TIPO_INCAPACIDAD));
                report.setHrecdescripcio2("Origen Incapacidad: " + 
                                          formatearCampo(ORIGEN_INCAPACIDAD));
                report.setHrectipodescri("Incapacidad ");
                report.setHrencodigo(imp_incapacidad);
                report.setHrentipoimpres(6);
                report.setHrenconsulta(consulta.getHcolnumero());
                report.setHredfecharegis(consulta.getHcodfecregistr());
                lstReporte.add(report);
            }

            // Datos Orden Cirugia
            if (consultaAux.getChordecirugis() != null && 
                !consultaAux.getChordecirugis().isEmpty()) {
                Chordecirugi ordenCirugia = null;
                Iterator itci = consultaAux.getChordecirugis().iterator();
                if (itci.hasNext()) {
                    ordenCirugia = (Chordecirugi)itci.next();
                }

                if (ordenCirugia != null) {
                    Date fecha1 = ordenCirugia.getHocdfecprocir1();
                    Date fecha2 = ordenCirugia.getHocdfecprocir2();

                    Calendar fechaAux1 = null;
                    Calendar fechaAux2 = null;
                    if (fecha1 != null) {
                        fechaAux1 = Calendar.getInstance();
                        fechaAux1.setTime(fecha1);
                        String hora = 
                            String.valueOf(fechaAux1.get(Calendar.HOUR_OF_DAY));
                        String minuto = 
                            String.valueOf(fechaAux1.get(Calendar.MINUTE));
                        if (fechaAux1.get(Calendar.HOUR_OF_DAY) < 10) {
                            hora = "0" + hora;
                        }
                        if (fechaAux1.get(Calendar.MINUTE) < 10) {
                            minuto = "0" + minuto;
                        }
                        HORA_CIRUGIA1 = hora + ":" + minuto;
                    }

                    if (fecha2 != null) {
                        fechaAux2 = Calendar.getInstance();
                        fechaAux2.setTime(fecha2);
                        String hora2 = 
                            String.valueOf(fechaAux2.get(Calendar.HOUR_OF_DAY));
                        String minuto2 = 
                            String.valueOf(fechaAux2.get(Calendar.MINUTE));
                        if (fechaAux2.get(Calendar.HOUR_OF_DAY) < 10) {
                            hora2 = "0" + hora2;
                        }
                        if (fechaAux2.get(Calendar.MINUTE) < 10) {
                            minuto2 = "0" + minuto2;
                        }
                        HORA_CIRUGIA2 = hora2 + ":" + minuto2;
                    }

                    FECHA_CIRUGIA1 = formatearCampo(fecha1);
                    FECHA_CIRUGIA2 = formatearCampo(fecha2);
                    if (ordenCirugia.getHocctipoaneste() != null) {
                        String tipoAnestesia = 
                            ordenCirugia.getHocctipoaneste();
                        if (tipoAnestesia.equals("1")) {
                            ANESTESIA_SOLICITADA = "Controlada";
                        }
                        if (tipoAnestesia.equals("2")) {
                            ANESTESIA_SOLICITADA = "General";
                        }
                        if (tipoAnestesia.equals("3")) {
                            ANESTESIA_SOLICITADA = "Local";
                        }
                    }

                    if (ordenCirugia.getHoccintervenci() != null) {
                        INTERVENCIONES_PROPUESTAS = "";
                        StringTokenizer st = 
                            new StringTokenizer(ordenCirugia.getHoccintervenci(), 
                                                ",");
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
                                INTERVENCIONES_PROPUESTAS = 
                                        INTERVENCIONES_PROPUESTAS + ", " + 
                                        servicioAux.getCsvccodigo() + " " + 
                                        servicioAux.getCsvcnombre();
                            }
                        }

                        if (INTERVENCIONES_PROPUESTAS != null && 
                            INTERVENCIONES_PROPUESTAS.length() > 2) {
                            INTERVENCIONES_PROPUESTAS = 
                                    INTERVENCIONES_PROPUESTAS.substring(1, 
                                                                        INTERVENCIONES_PROPUESTAS.length());
                        }
                    }

                    OBSERVACIONES_ORDEN = 
                            formatearCampo(ordenCirugia.getHoccobservacio());
                    PACIENTE_ACEPTA_ORDEN = 
                            formatearCampo(ordenCirugia.getHoccpaciacepta());

                    if (ordenCirugia.getHocclugarinter() != null) {
                        if (ordenCirugia.getHocclugarinter().equals("S")) {
                            LUGAR_CIRUGIA = "Salas de Cirugia";
                        } else if (ordenCirugia.getHocclugarinter().equals("C")) {
                            LUGAR_CIRUGIA = "Consultorio";
                        } else {
                            LUGAR_CIRUGIA = "Error. Lugar no reconocido";
                        }
                    }

                    if (ordenCirugia.getHoceayudantia() != null) {
                        if (ordenCirugia.getHoceayudantia().equals("S")) {
                            AYUDANTIA = "Si";
                        } else {
                            AYUDANTIA = "No";
                        }
                    }

                    if (ordenCirugia.getHocctipoestanc() != null) {
                        String tipoEstancia = ordenCirugia.getHocctipoestanc();
                        if (tipoEstancia.equals("A")) {
                            ESTANCIA = "Ambulatoria";
                            NUMERO_DIAS_ESTANCIA = 0;
                        }
                        if (tipoEstancia.equals("H")) {
                            ESTANCIA = "Hospitalizaci�n";
                            NUMERO_DIAS_ESTANCIA = 
                                    ordenCirugia.getHocndiasestanc();
                        }
                    }

                    if (ordenCirugia.getHoceresesangre() != null) {
                        if (ordenCirugia.getHoceresesangre().equals("S")) {
                            RESERVA_SANGRE = "Si";
                            UNIDADES_SANGRE = ordenCirugia.getHocnunidadsang();
                        } else {
                            RESERVA_SANGRE = "No";
                            UNIDADES_SANGRE = 0;
                        }
                    }

                    if (ordenCirugia.getHoccprogramar() != null) {
                        if (ordenCirugia.getHoccprogramar().equals("S")) {
                            PROGRAMAR_ANESTESIOLOGO = "Si";
                        } else {
                            PROGRAMAR_ANESTESIOLOGO = "No";
                        }
                    }

                    if (ordenCirugia.getHocctipopatolo() != null) {
                        String tipoPato = ordenCirugia.getHocctipopatolo();
                        if (tipoPato.equals("BI")) {
                            PATOLOGIA = "Biopsia";
                        }
                        if (tipoPato.equals("BC")) {
                            PATOLOGIA = 
                                    "Biopsa por Congelaci�n: " + formatearCampo(ordenCirugia.getHoccbiopsacong());
                        }
                        if (tipoPato.equals("CO")) {
                            PATOLOGIA = "Cono";
                        }
                        if (tipoPato.equals("OT")) {
                            PATOLOGIA = 
                                    "Otro: " + formatearCampo(ordenCirugia.getHoccotrapatolo());
                        }
                        if (tipoPato.equals("PQ")) {
                            PATOLOGIA = "Pieza Qx";
                        }
                    }

                    Chreporte report = new Chreporte();
                    report = new Chreporte();
                    report.setHrecdescripcio("Intervenci�n Propuesta : " + 
                                             formatearCampo(INTERVENCIONES_PROPUESTAS));
                    if (ordenCirugia.getHocntiempointe() != null) {
                        report.setHrecdescripcio2("Tiempo Qx: " + 
                                                  formatearCampo(ordenCirugia.getHocntiempointe()));
                    } else {
                        report.setHrecdescripcio2("");
                    }
                    report.setHrectipodescri("Cirug�as y procedimientos ");
                    report.setHrencodigo(imp_orden_cirugia);
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Observaciones: " + 
                                             OBSERVACIONES_ORDEN);
                    report.setHrectipodescri("Cirug�as y procedimientos ");
                    report.setHrencodigo(imp_orden_cirugia);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("La Paciente acepta y entiende el procedimiento : " + 
                                             formatearCampo(PACIENTE_ACEPTA_ORDEN));
                    report.setHrecdescripcio2("Lugar de realizaci�n del procedimiento: " + 
                                              formatearCampo(LUGAR_CIRUGIA));
                    report.setHrectipodescri("Cirug�as y procedimientos ");
                    report.setHrencodigo(imp_orden_cirugia);
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    if (ANESTESIA_SOLICITADA != null && 
                        !ANESTESIA_SOLICITADA.equals("")) {
                        report.setHrecdescripcio("Anestesia Solicitada : " + 
                                                 formatearCampo(ANESTESIA_SOLICITADA));
                    } else {
                        report.setHrecdescripcio("");
                    }

                    if (AYUDANTIA != null && !AYUDANTIA.equals("")) {
                        report.setHrecdescripcio2("Ayudantia :" + 
                                                  formatearCampo(AYUDANTIA));
                    } else {
                        report.setHrecdescripcio2("");
                    }
                    report.setHrectipodescri("Cirug�as y procedimientos ");
                    report.setHrencodigo(imp_orden_cirugia);
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    if (ESTANCIA != null && !ESTANCIA.equals("")) {
                        report.setHrecdescripcio("Estancia : " + 
                                                 formatearCampo(ESTANCIA));
                    } else {
                        report.setHrecdescripcio("");
                    }

                    if (NUMERO_DIAS_ESTANCIA != null) {
                        report.setHrecdescripcio2("Numero de Dias :" + 
                                                  formatearCampo(NUMERO_DIAS_ESTANCIA));
                    } else {
                        report.setHrecdescripcio2("");
                    }
                    report.setHrectipodescri("Cirug�as y procedimientos ");
                    report.setHrencodigo(imp_orden_cirugia);
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    if (RESERVA_SANGRE != null && !RESERVA_SANGRE.equals("")) {
                        report.setHrecdescripcio("Reserva de sangre : " + 
                                                 formatearCampo(RESERVA_SANGRE));
                    } else {
                        report.setHrecdescripcio("");
                    }
                    if (UNIDADES_SANGRE != null) {
                        report.setHrecdescripcio2("Unidades :" + 
                                                  formatearCampo(UNIDADES_SANGRE));
                    } else {
                        report.setHrecdescripcio2("");
                    }
                    report.setHrectipodescri("Cirug�as y procedimientos ");
                    report.setHrencodigo(imp_orden_cirugia);
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    if (PATOLOGIA != null && !PATOLOGIA.equals("")) {
                        report.setHrecdescripcio("Patologia : " + 
                                                 formatearCampo(PATOLOGIA));
                    } else {
                        report.setHrecdescripcio("");
                    }
                    if (PROGRAMAR_ANESTESIOLOGO != null && 
                        !PROGRAMAR_ANESTESIOLOGO.equals("")) {
                        report.setHrecdescripcio2("Programar Anestesiologo :" + 
                                                  formatearCampo(PROGRAMAR_ANESTESIOLOGO));
                    } else {
                        report.setHrecdescripcio2("");
                    }
                    report.setHrectipodescri("Cirug�as y procedimientos ");
                    report.setHrencodigo(imp_orden_cirugia);
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);
                }
            }

            // Datos examenes Paraclinicos
            if (consultaAux.getChexameparacs() != null && 
                !consultaAux.getChexameparacs().isEmpty()) {
                String FISIOLOGICOS = "";
                String IMAGENES = "";
                String LABORATORIOS = "";

                Iterator itex = (consultaAux.getChexameparacs()).iterator();
                while (itex.hasNext()) {
                    Chexameparac examenParaclinico = (Chexameparac)itex.next();
                    if (examenParaclinico != null) {
                        if (examenParaclinico.getHepntipoexam().equals(IConstantes.CODIGO_EXAMEN_ELECTROFISIOLOGICO)) {
                            FISIOLOGICOS = 
                                    FISIOLOGICOS + examenParaclinico.getHepcdescripc() + 
                                    "\n";
                        } else if (examenParaclinico.getHepntipoexam().equals(IConstantes.CODIGO_EXAMEN_IMAGENES)) {
                            IMAGENES = 
                                    IMAGENES + examenParaclinico.getHepcdescripc() + 
                                    "\n";
                        } else if (examenParaclinico.getHepntipoexam().equals(IConstantes.CODIGO_EXAMEN_LABORATORIOS)) {
                            LABORATORIOS = 
                                    LABORATORIOS + examenParaclinico.getHepcdescripc() + 
                                    "\n";
                        }
                    }

                    Chreporte report = new Chreporte();
                    if (FISIOLOGICOS != null && !FISIOLOGICOS.equals("")) {
                        report = new Chreporte();
                        report.setHrectipodescri("Examenes Paraclinicos");
                        report.setHrecdescripcio("Electrofisiologicos:");
                        report.setHrecdescripcio2(formatearCampo(FISIOLOGICOS));
                        report.setHrencodigo(imp_examenes_paraclinicos);
                        report.setHrentipoimpres(3);
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        lstReporte.add(report);
                    }

                    if (IMAGENES != null && !IMAGENES.equals("")) {
                        report = new Chreporte();
                        report.setHrectipodescri("Examenes Paraclinicos");
                        report.setHrecdescripcio("Imagenes:");
                        report.setHrecdescripcio2(formatearCampo(IMAGENES));
                        report.setHrencodigo(imp_examenes_paraclinicos);
                        report.setHrentipoimpres(3);
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        lstReporte.add(report);
                    }

                    if (LABORATORIOS != null && !LABORATORIOS.equals("")) {
                        report = new Chreporte();
                        report.setHrectipodescri("Examenes Paraclinicos");
                        report.setHrecdescripcio("Laboratorios:");
                        report.setHrecdescripcio2(formatearCampo(LABORATORIOS));
                        report.setHrencodigo(imp_examenes_paraclinicos);
                        report.setHrentipoimpres(3);
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        lstReporte.add(report);
                    }
                }
            }

            // Datos Referencia
            if (consultaAux.getChreferencias() != null && 
                !consultaAux.getChreferencias().isEmpty()) {
                Chreferencia referencia = null;
                Iterator itrf = consultaAux.getChreferencias().iterator();
                if (itrf.hasNext()) {
                    referencia = (Chreferencia)itrf.next();
                }

                if (referencia != null) {
                    String TIPO_SERVICIO = "";
                    String NOMBRE_RESPONSABLE_REFERENCIA = "";
                    String DIRECCION_RESPONSABLE_REFERENCIA = "";
                    String TELEFONO_RESPONSABLE_REFERENCIA = "";
                    String ANAMNESIS = "";
                    String APOYO_DIAGNOSTICO = "";
                    String JUSTIFICACION_REFERENCIA = "";

                    if (referencia.getHrectiporefere() != null) {
                        StringTokenizer st = 
                            new StringTokenizer(referencia.getHrectiporefere(), 
                                                ",");
                        while (st.hasMoreTokens()) {
                            String tipo = st.nextToken();
                            if (tipo.equals("IC")) {
                                TIPO_SERVICIO = 
                                        TIPO_SERVICIO + "Interconsulta, ";
                            }
                            if (tipo.equals("AT")) {
                                TIPO_SERVICIO = 
                                        TIPO_SERVICIO + "Apoyo Tecnologico, ";
                            }
                            if (tipo.equals("RE")) {
                                TIPO_SERVICIO = TIPO_SERVICIO + "Remisi�n, ";
                            }
                            if (tipo.equals("OS")) {
                                TIPO_SERVICIO = 
                                        TIPO_SERVICIO + "Orden de Servicio, ";
                            }
                            if (tipo.equals("OR")) {
                                TIPO_SERVICIO = TIPO_SERVICIO + "Ordinario, ";
                            }
                            if (tipo.equals("PR")) {
                                TIPO_SERVICIO = 
                                        TIPO_SERVICIO + "Prioritario, ";
                            }
                            if (tipo.equals("UR")) {
                                TIPO_SERVICIO = TIPO_SERVICIO + "Urgencia, ";
                            }
                            if (TIPO_SERVICIO != null && 
                                !TIPO_SERVICIO.equals("")) {
                                TIPO_SERVICIO = 
                                        TIPO_SERVICIO.substring(0, TIPO_SERVICIO.length() - 
                                                                2);
                            }
                        }

                        NOMBRE_RESPONSABLE_REFERENCIA = 
                                formatearCampo(referencia.getHrecnombrespon());
                        DIRECCION_RESPONSABLE_REFERENCIA = 
                                formatearCampo(referencia.getHrecdirecrespo());
                        TELEFONO_RESPONSABLE_REFERENCIA = 
                                formatearCampo(referencia.getHrectelefrespo());
                        ANAMNESIS = 
                                formatearCampo(referencia.getHrecanamnesis());
                        APOYO_DIAGNOSTICO = 
                                formatearCampo(referencia.getHrecapoyodiagn());
                        JUSTIFICACION_REFERENCIA = 
                                formatearCampo(referencia.getHrecjustirefer());
                    }

                    Chreporte report = new Chreporte();
                    report = new Chreporte();
                    report.setHrectipodescri("Referencia");
                    report.setHrecdescripcio("Tipo de Servicio: " + 
                                             formatearCampo(TIPO_SERVICIO));
                    report.setHrencodigo(imp_referencia);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrectipodescri("Referencia");
                    report.setHrecdescripcio("Nombre Responsable: " + 
                                             formatearCampo(NOMBRE_RESPONSABLE_REFERENCIA));
                    report.setHrencodigo(imp_referencia);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrectipodescri("Referencia");
                    report.setHrecdescripcio("Direccion Responsable: " + 
                                             formatearCampo(DIRECCION_RESPONSABLE_REFERENCIA));
                    report.setHrecdescripcio2("Telefono Responsable: " + 
                                              formatearCampo(TELEFONO_RESPONSABLE_REFERENCIA));
                    report.setHrencodigo(imp_referencia);
                    report.setHrentipoimpres(6);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrectipodescri("Referencia");
                    report.setHrecdescripcio("Anamnesis : " + 
                                             formatearCampo(ANAMNESIS));
                    report.setHrencodigo(imp_referencia);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrectipodescri("Referencia");
                    report.setHrecdescripcio("Apoyo Diagnostico : " + 
                                             formatearCampo(APOYO_DIAGNOSTICO));
                    report.setHrencodigo(imp_referencia);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrectipodescri("Referencia");
                    report.setHrecdescripcio("Justificaci�n de la referencia  : " + 
                                             formatearCampo(JUSTIFICACION_REFERENCIA));
                    report.setHrencodigo(imp_referencia);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);
                }
            }

            // Datos Anatomia Patologica

            // Datos Formula Medica
            if (consultaAux.getChformulameds() != null && 
                !consultaAux.getChformulameds().isEmpty()) {
                Iterator itme = consultaAux.getChformulameds().iterator();

                while (itme.hasNext()) {
                    Chformulamed formula = (Chformulamed)itme.next();

                    Chreporte report = new Chreporte();
                    if (formula.getHfonduracion() != null && 
                        !formula.getHfocduracion().equals("")) {

                        report = new Chreporte();
                        report.setHrectipodescri("Prescripci�n M�dica");
                        report.setHrecdescripcio("Nombre Generico del Medicamento: " + 
                                                 obtenerNombreMedicamento(formula));
                        report.setHrencodigo(imp_prescripcion_medica);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrectipodescri("Prescripci�n M�dica");
                        report.setHrecdescripcio("Dosis : " + 
                                                 obtenerNombreTratamiento(formula));
                        report.setHrencodigo(imp_prescripcion_medica);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        Integer cantidad = 0;
                        String cantidadLetras = "";
                        report.setHrectipodescri("Prescripci�n M�dica");
                        report.setHrecdescripcio("Via de administraci�n : " + 
                                                 formatearCampoViaAdministracion(formula.getHfocviadministr()));
                        cantidad = 
                                calcularCantidad(formula.getHfocadosis(), formula.getHfonfrecuenc(), 
                                                 formula.getHfonduracion(), 
                                                 formula.getHfocfrecuenc(), 
                                                 formula.getHfocduracion());
                        ConverterTextoNumero texto = 
                            new ConverterTextoNumero();
                        if (cantidad != null) {
                            cantidadLetras = texto.getStringOfNumber(cantidad);
                        }

                        report.setHrecdescripcio2("Cantidad Requerida : " + 
                                                  cantidad + " " + 
                                                  cantidadLetras);
                        report.setHrencodigo(imp_prescripcion_medica);
                        report.setHrentipoimpres(6);
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrectipodescri("Prescripci�n M�dica");
                        report.setHrecdescripcio("Contraindicaciones/Observaciones : " + 
                                                 formatearCampo(formula.getHfoccontraindi()));
                        report.setHrencodigo(imp_prescripcion_medica);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        lstReporte.add(report);
                    } else {
                        report = new Chreporte();
                        report.setHrectipodescri("Prescripci�n M�dica");
                        report.setHrecdescripcio("Nombre Generico del Medicamento Concentraci�n/ forma farmac�utica : " + 
                                                 formatearCampo(formula.getHfocmedicament()));
                        report.setHrencodigo(imp_prescripcion_medica);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrectipodescri("Prescripci�n M�dica");
                        report.setHrecdescripcio("Dosis, frecuencia de administraci�n y duraci�n del tratamiento : " + 
                                                 formatearCampo(formula.getHfoctratramien()));
                        report.setHrencodigo(imp_prescripcion_medica);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrectipodescri("Prescripci�n M�dica");
                        report.setHrecdescripcio("Via de administraci�n : " + 
                                                 formatearCampo(formula.getHfocviadministr()));
                        report.setHrecdescripcio2("Cantidad Requerida : " + 
                                                  formatearCampo(formula.getHfocadosis()));
                        report.setHrencodigo(imp_prescripcion_medica);
                        report.setHrentipoimpres(6);
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrectipodescri("Prescripci�n M�dica");
                        report.setHrecdescripcio("Contraindicaciones/Observaciones : " + 
                                                 formatearCampo(formula.getHfoccontraindi()));
                        report.setHrencodigo(imp_prescripcion_medica);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        lstReporte.add(report);
                    }
                }
            }

            // Datos Notas Medicas
            if (consultaAux.getChnotamedicas() != null && 
                !consultaAux.getChnotamedicas().isEmpty()) {
                Iterator itnm = consultaAux.getChnotamedicas().iterator();
                String NOTA_ACLARATORIA = "";
                while (itnm.hasNext()) {
                    Chnotamedica nota = (Chnotamedica)itnm.next();

                    NOTA_ACLARATORIA = 
                            NOTA_ACLARATORIA + "Fecha de la Nota Aclaratoria: " + 
                            formatearCampo(nota.getHnmdfecregistr()) + "\n" + 
                            nota.getHnmcdescripc() + "\n";
                }

                Chreporte report = new Chreporte();
                report = new Chreporte();
                report.setHrectipodescri("Nota Aclaratoria");
                report.setHrecdescripcio("Notas Aclaratoria : " + 
                                         formatearCampo(NOTA_ACLARATORIA));
                report.setHrencodigo(imp_nota_medica);
                report.setHrentipoimpres(1);
                report.setHrenconsulta(consulta.getHcolnumero());
                report.setHredfecharegis(consulta.getHcodfecregistr());
                lstReporte.add(report);
            }

            // Datos Evoluciones
            if (consultaAux.getChevoluconsu() != null && 
                !consultaAux.getChevoluconsu().isEmpty()) {
                Iterator itev = consultaAux.getChevoluconsu().iterator();
                String EVOLUCION = "";

                while (itev.hasNext()) {
                    Chevoluconsu evolucion = (Chevoluconsu)itev.next();
                    EVOLUCION = 
                            EVOLUCION + "Fecha de la Evoluci�n: " + formatearCampo(evolucion.getHecdfecregistr()) + 
                            "\n" + " Usuario Registro: " + 
                            obtenerUsuario(evolucion.getHeccoperador()) + 
                            "\n" + evolucion.getHeccdescripc() + "\n";
                }

                Chreporte report = new Chreporte();
                report = new Chreporte();
                report.setHrectipodescri("Evoluci�n Consulta");
                report.setHrecdescripcio("Evolucion : " + 
                                         formatearCampo(EVOLUCION));
                report.setHrencodigo(imp_evolucion);
                report.setHrentipoimpres(1);
                report.setHrenconsulta(consulta.getHcolnumero());
                report.setHredfecharegis(consulta.getHcodfecregistr());
                lstReporte.add(report);
            }

            // MUESTRA EL REGISTRO DE EXAMENES CLINICOS
            if (consultaAux.getChregisexame() != null && 
                !consultaAux.getChregisexame().isEmpty()) {
                String TIENE_LABORATORIO_CLINICO = "";
                String TIENE_IMAGENES = "";
                String TIENE_ESTUDIO_PATOLOGIA = "";
                String TIENE_PRUEBA_EMBARAZO = "";
                String TIENE_CITOLOGIA = "";
                String TIENE_COLPOSCOPIA = "";
                String TIENE_OTROS_EXAMENES = "";

                Iterator itxm = consultaAux.getChregisexame().iterator();
                while (itxm.hasNext()) {
                    Chregisexame registro = (Chregisexame)itxm.next();
                    TIENE_LABORATORIO_CLINICO = 
                            formatearCampo(registro.getHreelaborclini());
                    TIENE_IMAGENES = 
                            formatearCampo(registro.getHreeimagediagn());
                    TIENE_ESTUDIO_PATOLOGIA = 
                            formatearCampo(registro.getHreeestudpatol());
                    TIENE_PRUEBA_EMBARAZO = 
                            formatearCampo(registro.getHreepruebembar());
                    TIENE_CITOLOGIA = 
                            formatearCampo(registro.getHreecitologia());
                    TIENE_COLPOSCOPIA = 
                            formatearCampo(registro.getHreecolposcopi());
                    TIENE_OTROS_EXAMENES = 
                            formatearCampo(registro.getHreecualexame());

                    Chreporte report = new Chreporte();
                    report = new Chreporte();
                    report.setHrectipodescri("Resultado Ex�menes Cl�nicos");
                    report.setHrecdescripcio("Fecha de Registro: " + 
                                             formatearCampo(registro.getHredfecregistr()) + 
                                             "   Hora: " + 
                                             formatearCampoHoraSimple(registro.getHredfecregistr()));
                    report.setHrencodigo(imp_registro_examenes);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    Cpprofesio profesional = null;
                    try {
                        profesional = 
                                serviceLocator.getClinicoService().getProfesionalPorUsuario(registro.getHrecoperador(), 
                                                                                            registro.getHrenclinica());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    report = new Chreporte();
                    report.setHrectipodescri("Resultado Ex�menes Cl�nicos");
                    report.setHrecdescripcio("Usuario que registro: " + 
                                             profesional.getCpfcnombre());
                    report.setHrencodigo(imp_registro_examenes);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrectipodescri("Resultado Ex�menes Cl�nicos");
                    report.setHrecdescripcio(" Laboratorio Cl�nico : " + 
                                             TIENE_LABORATORIO_CLINICO);
                    if (registro.getHreclaborclini() != null && 
                        !registro.getHreclaborclini().equals("")) {
                        report.setHrecdescripcio2(registro.getHreclaborclini());
                    } else {
                        report.setHrecdescripcio2("");
                    }
                    report.setHrencodigo(imp_registro_examenes);
                    report.setHrentipoimpres(3);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrectipodescri("Resultado Ex�menes Cl�nicos");
                    report.setHrecdescripcio(" Imagenes Diagnosticas : " + 
                                             TIENE_IMAGENES);
                    if (registro.getHrecimagediagn() != null && 
                        !registro.getHrecimagediagn().equals("")) {
                        report.setHrecdescripcio2(registro.getHrecimagediagn());
                    } else {
                        report.setHrecdescripcio2("");
                    }
                    report.setHrencodigo(imp_registro_examenes);
                    report.setHrentipoimpres(3);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrectipodescri("Resultado Ex�menes Cl�nicos");
                    report.setHrecdescripcio(" Estudio de patologia : " + 
                                             TIENE_ESTUDIO_PATOLOGIA);
                    if (registro.getHrecestudpatol() != null && 
                        !registro.getHrecestudpatol().equals("")) {
                        report.setHrecdescripcio2(registro.getHrecestudpatol());
                    } else {
                        report.setHrecdescripcio2("");
                    }
                    report.setHrencodigo(imp_registro_examenes);
                    report.setHrentipoimpres(3);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrectipodescri("Resultado Ex�menes Cl�nicos");
                    report.setHrecdescripcio(" Prueba de Embarazo : " + 
                                             TIENE_PRUEBA_EMBARAZO);
                    if (registro.getHrecpruebembar() != null && 
                        !registro.getHrecpruebembar().equals("")) {
                        report.setHrecdescripcio2(registro.getHrecpruebembar());
                    } else {
                        report.setHrecdescripcio2("");
                    }
                    report.setHrencodigo(imp_registro_examenes);
                    report.setHrentipoimpres(3);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrectipodescri("Resultado Ex�menes Cl�nicos");
                    report.setHrecdescripcio(" Citologia : " + 
                                             TIENE_CITOLOGIA);
                    if (registro.getHreccitologia() != null && 
                        !registro.getHreccitologia().equals("")) {
                        report.setHrecdescripcio2(registro.getHreccitologia());
                    } else {
                        report.setHrecdescripcio2("");
                    }
                    report.setHrencodigo(imp_registro_examenes);
                    report.setHrentipoimpres(3);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrectipodescri("Resultado Ex�menes Cl�nicos");
                    report.setHrecdescripcio(" Colposcopia : " + 
                                             TIENE_COLPOSCOPIA);
                    if (registro.getHreccolposcopi() != null && 
                        !registro.getHreccolposcopi().equals("")) {
                        report.setHrecdescripcio2(registro.getHreccolposcopi());
                    } else {
                        report.setHrecdescripcio2("");
                    }
                    report.setHrencodigo(imp_registro_examenes);
                    report.setHrentipoimpres(3);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrectipodescri("Resultado Ex�menes Cl�nicos");
                    report.setHrecdescripcio(" Otros Examenes : " + 
                                             TIENE_OTROS_EXAMENES);
                    if (registro.getHreccualexame() != null && 
                        !registro.getHreccualexame().equals("")) {
                        report.setHrecdescripcio2(registro.getHreccualexame());
                    } else {
                        report.setHrecdescripcio2("");
                    }
                    report.setHrencodigo(imp_registro_examenes);
                    report.setHrentipoimpres(3);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrectipodescri("Resultado Ex�menes Cl�nicos");
                    report.setHrecdescripcio("");
                    report.setHrencodigo(imp_registro_examenes);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrectipodescri("Resultado Ex�menes Cl�nicos");
                    report.setHrecdescripcio("**************************************************************************" + 
                                             "***************************************************************************************************");
                    report.setHrencodigo(imp_registro_examenes);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);
                }
            }

            if (consultaAux.getChexameimages() != null && 
                !consultaAux.getChexameimages().isEmpty()) {
                List<Chexameimage> lstExamenesImagenes;
                lstExamenesImagenes = new ArrayList<Chexameimage>();
                lstExamenesImagenes.addAll(consultaAux.getChexameimages());

                if (lstExamenesImagenes != null && 
                    !lstExamenesImagenes.isEmpty()) {
                    Chexameimage imagenes = null;
                    String observaciones = null;
                    Iterator itim = lstExamenesImagenes.iterator();

                    while (itim.hasNext()) {
                        imagenes = (Chexameimage)itim.next();
                        observaciones = imagenes.getHeicobservacio();
                        Chreporte report = new Chreporte();
                        report = new Chreporte();
                        report.setHrectipodescri("Examenes Imagenes");
                        report.setHrecdescripcio(" " + 
                                                 imagenes.getCpservicio().getCsvcnombre());
                        report.setHrencodigo(imp_examenes_imagenes);
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        report.setHrentipoimpres(1);
                        lstReporte.add(report);
                    }

                    if (observaciones != null) {
                        Chreporte report = new Chreporte();
                        report = new Chreporte();
                        report.setHrectipodescri("Examenes Imagenes");
                        report.setHrecdescripcio("Observaciones: " + 
                                                 observaciones);
                        report.setHrencodigo(imp_examenes_imagenes);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        lstReporte.add(report);
                    }
                }
            }

            if (consultaAux.getChexameelects() != null && 
                !consultaAux.getChexameelects().isEmpty()) {
                List<Chexameelect> lstExamenesElectrofisiologicos;
                lstExamenesElectrofisiologicos = new ArrayList<Chexameelect>();
                lstExamenesElectrofisiologicos.addAll(consultaAux.getChexameelects());

                if (lstExamenesElectrofisiologicos != null && 
                    !lstExamenesElectrofisiologicos.isEmpty()) {
                    Chexameelect electrofisiologicos = null;
                    String observaciones = null;
                    Iterator itfi = lstExamenesElectrofisiologicos.iterator();
                    while (itfi.hasNext()) {
                        electrofisiologicos = (Chexameelect)itfi.next();
                        observaciones = 
                                electrofisiologicos.getHeecobservacio();
                        Chreporte report = new Chreporte();
                        report = new Chreporte();
                        report.setHrectipodescri("Examenes Electrofisiologicos");
                        report.setHrecdescripcio(" " + 
                                                 electrofisiologicos.getCpservicio().getCsvcnombre());
                        report.setHrencodigo(imp_examenes_electrofisiologicos);
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        report.setHrentipoimpres(1);
                        lstReporte.add(report);
                    }

                    if (observaciones != null) {
                        Chreporte report = new Chreporte();
                        report = new Chreporte();
                        report.setHrectipodescri("Examenes Electrofisiologicos");
                        report.setHrecdescripcio("Observaciones: " + 
                                                 observaciones);
                        report.setHrencodigo(imp_examenes_electrofisiologicos);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        lstReporte.add(report);
                    }
                }
            }

            if (consultaAux.getChexamelabors() != null && 
                !consultaAux.getChexamelabors().isEmpty()) {
                List<Chexamelabor> lstExamenesLaboratorios;
                lstExamenesLaboratorios = new ArrayList<Chexamelabor>();
                lstExamenesLaboratorios.addAll(consultaAux.getChexamelabors());

                if (lstExamenesLaboratorios != null && 
                    !lstExamenesLaboratorios.isEmpty()) {
                    Chexamelabor laboratorios = null;
                    String observaciones = null;
                    Iterator itla = lstExamenesLaboratorios.iterator();

                    while (itla.hasNext()) {
                        laboratorios = (Chexamelabor)itla.next();
                        observaciones = laboratorios.getHelcobservacio();
                        Chreporte report = new Chreporte();
                        report = new Chreporte();
                        report.setHrectipodescri("Examenes Laboratorios");
                        report.setHrecdescripcio(" " + 
                                                 laboratorios.getCpservicio().getCsvcnombre());
                        report.setHrencodigo(imp_examenes_laboratorios);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        lstReporte.add(report);
                    }

                    if (observaciones != null) {
                        Chreporte report = new Chreporte();
                        report = new Chreporte();
                        report.setHrectipodescri("Examenes Laboratorios");
                        report.setHrecdescripcio("Observaciones: " + 
                                                 observaciones);
                        report.setHrencodigo(imp_examenes_laboratorios);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        lstReporte.add(report);
                    }
                }
            }

            if (consultaAux.getChremisions() != null && 
                !consultaAux.getChremisions().isEmpty()) {
                List<Chremision> lstInterconsulta;
                lstInterconsulta = new ArrayList<Chremision>();
                lstInterconsulta.addAll(consultaAux.getChremisions());

                if (lstInterconsulta != null && !lstInterconsulta.isEmpty()) {
                    Chremision interconsulta = null;
                    Iterator itrm = lstInterconsulta.iterator();
                    while (itrm.hasNext()) {
                        interconsulta = (Chremision)itrm.next();
                        Chreporte report = new Chreporte();
                        Chtipointerc tipoAux = null;
                        String tipoRemision = null;
                        try {
                            tipoAux = 
                                    this.getServiceLocator().getClinicoService().getInterconsultaPorCriterios(interconsulta.getHrecservicio());
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }
                        if (tipoAux == null || tipoAux.getHticdescripcio() == null) {
                            tipoRemision = "Servicio no encontrado";
                        }else{
                            tipoRemision = tipoAux.getHticdescripcio();
                        }
                        
                        
                        report = new Chreporte();
                        report.setHrectipodescri("Interconsulta");
                        report.setHrecdescripcio("Tipo: " + tipoRemision);
                        report.setHrecdescripcio2("Descripcion: " + 
                                                  interconsulta.getHrecdescripcio());
                        report.setHrencodigo(imp_interconsulta);
                        report.setHrentipoimpres(6);
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        lstReporte.add(report);
                    }
                }
            }

            if (consultaAux.getChcertmedicos() != null && 
                !consultaAux.getChcertmedicos().isEmpty()) {
                for (Chcertmedico certificado: 
                     consultaAux.getChcertmedicos()) {
                    if (certificado != null && certificado.getId() != null) {
                        if (certificado.getId().getHcmctipocert().equals("M")) {
                            Chreporte report = new Chreporte();
                            report = new Chreporte();
                            report.setHrectipodescri("Certificado M�dico");
                            report.setHrecdescripcio("Se expidio certificado m�dico");
                            report.setHrencodigo(imp_certificado_medico);
                            report.setHrentipoimpres(1);
                            report.setHrenconsulta(consulta.getHcolnumero());
                            report.setHredfecharegis(consulta.getHcodfecregistr());
                            lstReporte.add(report);
                        } else if (certificado.getId().getHcmctipocert().equals("A")) {
                            Chreporte report = new Chreporte();
                            report = new Chreporte();
                            report.setHrectipodescri("Certificado Asistencia");
                            report.setHrecdescripcio("Se expidio certificado de Asistencia");
                            report.setHrencodigo(imp_certificado_asistencia);
                            report.setHrentipoimpres(1);
                            report.setHrenconsulta(consulta.getHcolnumero());
                            report.setHredfecharegis(consulta.getHcodfecregistr());
                            lstReporte.add(report);
                        }
                    }
                }
            }

            if (consultaAux.getChremihospits() != null && 
                !consultaAux.getChremihospits().isEmpty()) {
                for (Chremihospit hospitalizacion: 
                     consultaAux.getChremihospits()) {
                    if (hospitalizacion != null) {
                        Chreporte report = new Chreporte();
                        report = new Chreporte();
                        report.setHrectipodescri("Remisi�n Hospitalizaci�n");
                        report.setHrecdescripcio("Motivo de la Hospitalizaci�n: " + 
                                                 hospitalizacion.getHrhcmotivhospi());
                        report.setHrencodigo(imp_remision_hospitalizacion);
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        report.setHrentipoimpres(1);
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrectipodescri("Remisi�n Hospitalizaci�n");
                        report.setHrecdescripcio("Plan de Manejo: " + 
                                                 hospitalizacion.getHrhcplanmanejo());
                        report.setHrencodigo(imp_remision_hospitalizacion);
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        report.setHrentipoimpres(1);
                        lstReporte.add(report);
                    }
                }
            }
            // Termina adici�n evoluci�n nuevo


            if (cirugia.getChepicrisis() != null && 
                !cirugia.getChepicrisis().isEmpty()) {

                while (it.hasNext()) {
                    Chepicrisi epicrisis = (Chepicrisi)it.next();

                    if (epicrisis != null) {
                        Chreporte report = new Chreporte();


                        report = new Chreporte();
                        report.setHrecdescripcio("****************************************************************************************************************************************************************");
                        report.setHrectipodescri("Epicrisis");
                        report.setHrencodigo(imp_epicirisis);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(epicrisis.getHepdfecregistr());
                        lstReporte.add(report);


                        report = new Chreporte();
                        report.setHrecdescripcio("Tipo de Usuario: " + 
                                                 obtenerTipoUsuario(epicrisis.getHepctipousuari()));
                        report.setHrencodigo(imp_epicirisis);
                        report.setHrectipodescri("Epicrisis");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(epicrisis.getHepdfecregistr());
                        lstReporte.add(report);


                        report = new Chreporte();
                        report.setHrecdescripcio("Fecha y hora de Ingreso:  " + 
                                                 epicrisis.getHepdfechaingre());
                        report.setHrecdescripcio2("Fecha y hora de Egreso:  " + 
                                                  epicrisis.getHepdfechaegres());
                        report.setHrencodigo(imp_epicirisis);
                        report.setHrectipodescri("Epicrisis");
                        report.setHrentipoimpres(2);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(epicrisis.getHepdfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrecdescripcio("N�mero de horas en el servicio: " + 
                                                 calculaHorasDiferencia(epicrisis.getHepdfechaingre(), 
                                                                        epicrisis.getHepdfechaegres()));
                        report.setHrencodigo(imp_epicirisis);
                        report.setHrectipodescri("Epicrisis");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(epicrisis.getHepdfecregistr());
                        lstReporte.add(report);


                        report = new Chreporte();
                        report.setHrecdescripcio("Motivo de Consulta: " + 
                                                 formatearCampo(epicrisis.getHepcmotivocons()));
                        report.setHrencodigo(imp_epicirisis);
                        report.setHrectipodescri("Epicrisis");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(epicrisis.getHepdfecregistr());
                        lstReporte.add(report);


                        report = new Chreporte();
                        report.setHrecdescripcio("Estado General al Ingreso: " + 
                                                 formatearCampo(epicrisis.getHepcestaingres()));
                        report.setHrencodigo(imp_epicirisis);
                        report.setHrectipodescri("Epicrisis");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(epicrisis.getHepdfecregistr());
                        lstReporte.add(report);


                        report = new Chreporte();
                        report.setHrecdescripcio("Enfermedad Actual: " + 
                                                 formatearCampo(epicrisis.getHepcenfeactual()));
                        report.setHrencodigo(imp_epicirisis);
                        report.setHrectipodescri("Epicrisis");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(epicrisis.getHepdfecregistr());
                        lstReporte.add(report);


                        report = new Chreporte();
                        report.setHrecdescripcio("Antecedentes: " + 
                                                 formatearCampo(epicrisis.getHepcantecedent()));
                        report.setHrencodigo(imp_epicirisis);
                        report.setHrectipodescri("Epicrisis");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(epicrisis.getHepdfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrecdescripcio("Revisi�n por Sistemas: " + 
                                                 formatearCampo(epicrisis.getHepcrevisistem()));
                        report.setHrencodigo(imp_epicirisis);
                        report.setHrectipodescri("Epicrisis");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(epicrisis.getHepdfecregistr());
                        lstReporte.add(report);


                        report = new Chreporte();
                        report.setHrecdescripcio("Hallazgos al Examen Fisico: " + 
                                                 formatearCampo(epicrisis.getHepchallaexafi()));
                        report.setHrencodigo(imp_epicirisis);
                        report.setHrectipodescri("Epicrisis");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(epicrisis.getHepdfecregistr());
                        lstReporte.add(report);


                        report = new Chreporte();
                        report.setHrecdescripcio("Diagnostico Presuntivo: " + 
                                                 obtenerDescripcionCie10(epicrisis.getHepcdiagingnpresu()));
                        report.setHrencodigo(imp_epicirisis);
                        report.setHrectipodescri("Epicrisis");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(epicrisis.getHepdfecregistr());
                        lstReporte.add(report);


                        report = new Chreporte();
                        report.setHrecdescripcio("Diagnostico Confirmado: " + 
                                                 obtenerDescripcionCie10(epicrisis.getHepcdiagnconfi()));
                        report.setHrencodigo(imp_epicirisis);
                        report.setHrectipodescri("Epicrisis");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(epicrisis.getHepdfecregistr());
                        lstReporte.add(report);


                        report = new Chreporte();
                        report.setHrecdescripcio("Diagnostico Relacionado: " + 
                                                 obtenerDescripcionCie10(epicrisis.getHepcdiagingnrelacu()));
                        report.setHrencodigo(imp_epicirisis);
                        report.setHrectipodescri("Epicrisis");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(epicrisis.getHepdfecregistr());
                        lstReporte.add(report);


                        report = new Chreporte();
                        report.setHrecdescripcio("Conducta: " + 
                                                 formatearCampo(epicrisis.getHepcconducta()));
                        report.setHrencodigo(imp_epicirisis);
                        report.setHrectipodescri("Epicrisis");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(epicrisis.getHepdfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrecdescripcio("Evolucion: " + 
                                                 formatearCampo(epicrisis.getHepcevolucion()));
                        report.setHrencodigo(imp_epicirisis);
                        report.setHrectipodescri("Epicrisis");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(epicrisis.getHepdfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrecdescripcio("Examenes de Apoyo: " + 
                                                 formatearCampo(epicrisis.getHepcexamapoyo()));
                        report.setHrencodigo(imp_epicirisis);
                        report.setHrectipodescri("Epicrisis");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(epicrisis.getHepdfecregistr());
                        lstReporte.add(report);


                        report = new Chreporte();
                        report.setHrecdescripcio("Condiciones del Paciente al Egreso: " + 
                                                 formatearCampo(epicrisis.getHepccondegres()));
                        report.setHrencodigo(imp_epicirisis);
                        report.setHrectipodescri("Epicrisis");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(epicrisis.getHepdfecregistr());
                        lstReporte.add(report);
                    }


                }

            }


            // Datos Conducta
            Iterator it1 = (cirugia.getChconductas()).iterator();
            while (it1.hasNext()) {
                Chconducta conducta = (Chconducta)it1.next();

                if (conducta != null) {
                    Chreporte report = new Chreporte();

                    report = new Chreporte();
                    report.setHrecdescripcio("****************************************************************************************************************************************************************");
                    report.setHrectipodescri("Recomendaciones");
                    report.setHrencodigo(imp_recomendaciones);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(conducta.getHcndfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Hora de la actividad: " + 
                                             formatearCampoHoraSimple(conducta.getHcndfecregistr()));
                    report.setHrencodigo(imp_recomendaciones);
                    report.setHrectipodescri("Recomendaciones");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(conducta.getHcndfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Usuario que realiza la actividad: " + 
                                             obtenerUsuario(conducta.getHcncoperador()));
                    report.setHrencodigo(imp_recomendaciones);
                    report.setHrectipodescri("Recomendaciones");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(conducta.getHcndfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Plan de Manejo: " + 
                                             formatearCampo(conducta.getHcncplanmanejo()));
                    report.setHrencodigo(imp_recomendaciones);
                    report.setHrectipodescri("Recomendaciones");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(conducta.getHcndfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Recomendaciones : " + 
                                             formatearCampo(conducta.getHcncobservacio()));
                    report.setHrencodigo(imp_recomendaciones);
                    report.setHrectipodescri("Recomendaciones");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(conducta.getHcndfecregistr());
                    lstReporte.add(report);
                }
            }

            try {
                URL url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
                URL url_super_horizontal = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
                URL url_super_vertical = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                parameters.put("NOMBRE", NOMBRE);
                parameters.put("TIPO_DOCUMENTO", TIPO_DOCUMENTO);
                parameters.put("NOMBRE_PROFESIONAL", NOMBRE_PROFESIONAL);
                parameters.put("NUMERO_DOCUMENTO", NUMERO_DOCUMENTO);
                parameters.put("FECHA_NACIMIENTO", FECHA_NACIMIENTO);
                parameters.put("DIRECCION", DIRECCION);
                parameters.put("OCUPACION", OCUPACION);
                parameters.put("RESPONSABLE", RESPONSABLE);
                parameters.put("EDAD", EDAD);
                parameters.put("TELEFONO", TELEFONO);
                parameters.put("ESTADO_CIVIL", ESTADO_CIVIL);
                parameters.put("PARENTESCO_RESPONSABLE", 
                               PARENTESCO_RESPONSABLE);
                parameters.put("SEXO", SEXO);
                parameters.put("CIUDAD", CIUDAD);
                parameters.put("TELEFONO_RESPONSABLE", TELEFONO_RESPONSABLE);
                parameters.put("IMPRIMIO", IMPRIMIO);
                parameters.put("REGISTRO_MEDICO", REGISTRO_MEDICO);
                parameters.put("EPS", EPS);
                parameters.put("PAGINAS_ANTERIORES", paginas_ant);
                parameters.put("FECHA", new Date());
                
                parameters.put("ZONA", ZONA);
                parameters.put("CONTRATO", CONTRATO);
                parameters.put("ESTRATO", ESTRATO);
                parameters.put("NIVELEDUCATIVO", NIVELEDUCATIVO);
                parameters.put("BARRIO", BARRIO);
                parameters.put("ETNIA", ETNIA);
                
                
                JRBeanCollectionDataSource dataSource = 
                    new JRBeanCollectionDataSource(lstReporte);
                File reportFile = 
                    new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/consultarFoliosCirugia.jasper"));

                if (reportFile.exists()) {
                    try {
                        bytes = 
                                JasperRunManager.runReportToPdf(reportFile.getPath(), 
                                                                parameters, 
                                                                dataSource);
                    } catch (JRException ex) {
                        ex.printStackTrace();
                        FacesUtils.addErrorMessage("No pudo generar Canalizaci�n. " + 
                                                   ex.getMessage());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        FacesUtils.addErrorMessage("No pudo generar Canalizaci�n. " + 
                                                   ex.getMessage());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
            }
            pdfs.add(bytes);
        }

        if (pdfs != null && !pdfs.isEmpty()) {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            resu = PDFMerger.concatBytePDFs(pdfs, output);
        }
        return resu;
    }


    public byte[] generarAnestesia(Chusuario usuario, Chcirugprogr cirugia, 
                                   Integer paginas_ant) {
        byte[] bytes = null;
        List<Chreporte> lstReporte = new ArrayList<Chreporte>();

        if (usuario != null) {
            if (usuario.getHusdfechanacim() != null) {
                FECHA_NACIMIENTO = usuario.getHusdfechanacim();
                if (FECHA_NACIMIENTO != null) {
                    int edad = calcularEdad(FECHA_NACIMIENTO, cirugia.getHcpdfecregistr());
                    EDAD = edad;
                }
            }
            if (getUsuarioSystem() != null) {
                IMPRIMIO = this.getUsuarioSystem().getCurcnombre();
            }
            if (usuario.getHuscprimernomb() != null) {
                NOMBRE = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                NOMBRE = NOMBRE + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundapel();
            }
            if (usuario.getHusanumeiden() != null && 
                usuario.getHusanumeiden() != 0) {
                TIPO_DOCUMENTO = usuario.getHusetipoiden();
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }
            if (usuario.getHuscentidadadm() != null) {
                try {
                    EPS = 
serviceLocator.getClinicoService().getDescripcionEntidadByCodigo(usuario.getHuscentidadadm());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }

            SEXO = usuario.getHusesexo();
            DIRECCION = usuario.getHuscdireccion();
            TELEFONO = usuario.getHusctelefono();
            Integer idCiudad = usuario.getHusnciudad();
            Integer idDepartamento = usuario.getHusndepartamen();
            Cpmunidane ciudadObject = null;
            try {
                ciudadObject = 
                        this.serviceLocator.getClinicoService().getMunicipio(idCiudad, 
                                                                             idDepartamento);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (ciudadObject != null) {
                CIUDAD = ciudadObject.getCmdcnommun();
            }

            Integer ocupacion = usuario.getHusnocupacion();
            try {
                OCUPACION = 
                        serviceLocator.getClinicoService().getDescripcionOcupacion(ocupacion);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            ESTADO_CIVIL = usuario.getHuseestadcivil();
            RESPONSABLE = usuario.getHuscnomresponsa();
            PARENTESCO_RESPONSABLE = usuario.getHuscparresponsa();
            TELEFONO_RESPONSABLE = usuario.getHusctelresponsa();
        }

        if (cirugia.getChanestesia() != null && 
            !cirugia.getChanestesia().isEmpty()) {
            Iterator it = (cirugia.getChanestesia()).iterator();
            while (it.hasNext()) {
                Chanestesia anestesia = (Chanestesia)it.next();

                if (anestesia != null) {
                    Chreporte report = new Chreporte();

                    report = new Chreporte();
                    report.setHrecdescripcio("****************************************************************************************************************************************************************");
                    report.setHrectipodescri("Anestesia");
                    report.setHrencodigo(imp_registro_anestesia);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(anestesia.getHandfecregistr());
                    lstReporte.add(report);

                    Crdgncie10 diagpri = null;

                    try {
                        diagpri = 
                                this.serviceLocator.getClinicoService().getCIE10PorCodigo(anestesia.getHancdiagprinci());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    report = new Chreporte();
                    if (diagpri == null) {
                        report.setHrecdescripcio("Diagnostico Principal: " + 
                                                 formatearCampo(anestesia.getHancdiagprinci()));
                    } else {
                        report.setHrecdescripcio("Diagnostico Principal: " + 
                                                 formatearCampo(diagpri.getCdcccodigo() + 
                                                                " " + 
                                                                diagpri.getCdccdescri()));
                    }
                    report.setHrectipodescri("Anestesia");
                    report.setHrencodigo(imp_registro_anestesia);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(anestesia.getHandfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Grado Examen ASA: " + 
                                             formatearCampo(anestesia.getHanngradoasa()));
                    report.setHrectipodescri("Anestesia");
                    report.setHrencodigo(imp_registro_anestesia);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(anestesia.getHandfecregistr());
                    lstReporte.add(report);

                    if (anestesia.getHancurgenasa() != null && 
                        anestesia.getHancurgenasa().equals("S")) {
                        report = new Chreporte();
                        report.setHrecdescripcio("Urgencia: " + 
                                                 formatearCampo("Si"));
                        report.setHrectipodescri("Anestesia");
                        report.setHrencodigo(imp_registro_anestesia);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(anestesia.getHandfecregistr());
                        lstReporte.add(report);
                    }

                    report = new Chreporte();
                    report.setHrecdescripcio("Peso del Paciente: " + 
                                             formatearCampo(anestesia.getHannpeso()) + 
                                             "Kg");
                    report.setHrectipodescri("Anestesia");
                    report.setHrencodigo(imp_registro_anestesia);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(anestesia.getHandfecregistr());
                    lstReporte.add(report);

                    String tipoAnestesia = null;
                    if (anestesia.getHanctipoanest().equals("2")) {
                        tipoAnestesia = "General";
                    } else if (anestesia.getHanctipoanest().equals("4")) {
                        tipoAnestesia = "Regional";
                    } else if (anestesia.getHanctipoanest().equals("5")) {
                        tipoAnestesia = "Sedaci�n";
                    } else if (anestesia.getHanctipoanest().equals("6")) {
                        tipoAnestesia = "Local Controlada";
                    } else {
                        tipoAnestesia = anestesia.getHanctipoanest();
                    }

                    report = new Chreporte();
                    report.setHrecdescripcio("Anestesia Solicitada: " + 
                                             formatearCampo(tipoAnestesia));
                    report.setHrectipodescri("Anestesia");
                    report.setHrencodigo(imp_registro_anestesia);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(anestesia.getHandfecregistr());
                    lstReporte.add(report);

                    String estLlegada = null;
                    if (anestesia.getHancestadllega().equals("1")) {
                        estLlegada = "No Ansiosa";
                    } else if (anestesia.getHancestadllega().equals("2")) {
                        estLlegada = "Ansiosa";
                    } else if (anestesia.getHancestadllega().equals("3")) {
                        estLlegada = "Muy ansiosa";
                    } else {
                        estLlegada = anestesia.getHancestadllega();
                    }
                    report = new Chreporte();
                    report.setHrecdescripcio("Estado del paciente al llegar: " + 
                                             formatearCampo(estLlegada));
                    report.setHrectipodescri("Anestesia");
                    report.setHrencodigo(imp_registro_anestesia);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(anestesia.getHandfecregistr());
                    lstReporte.add(report);

                    if (anestesia.getHancobseringre() != null && 
                        !anestesia.getHancobseringre().equals("")) {
                        report = new Chreporte();
                        report.setHrectipodescri("Anestesia");
                        report.setHrecdescripcio("Observaciones Ingreso :  " + 
                                                 formatearCampo(anestesia.getHancobseringre()));
                        report.setHrencodigo(imp_registro_anestesia);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(anestesia.getHandfecregistr());
                        lstReporte.add(report);
                    }
                }
            }
        }

        if (cirugia.getChsignovitals() != null && 
            !cirugia.getChsignovitals().isEmpty()) {
            Iterator it = cirugia.getChsignovitals().iterator();
            while (it.hasNext()) {
                Chsignovital signoVital = null;
                signoVital = (Chsignovital)it.next();

                Chreporte report = new Chreporte();
                if (signoVital != null && 
                    signoVital.getHsvctipoproced().equals("A")) {
                    report = new Chreporte();
                    report.setHrecdescripcio("****************************************************************************************************************************************************************");
                    report.setHrectipodescri("Signos Vitales Anestesia");
                    report.setHrencodigo(imp_anestesia_signos);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(signoVital.getHsvdfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Hora de la actividad: " + 
                                             formatearCampoHoraSimple(signoVital.getHsvdfechaactiv()));
                    report.setHrencodigo(imp_anestesia_signos);
                    report.setHrectipodescri("Signos Vitales Anestesia");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(signoVital.getHsvdfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Usuario que realiza la actividad: " + 
                                             obtenerUsuario(signoVital.getHsvcoperador()));
                    report.setHrencodigo(imp_anestesia_signos);
                    report.setHrectipodescri("Signos Vitales Anestesia");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(signoVital.getHsvdfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    if (signoVital.getHsvnpresart1() != null && 
                        signoVital.getHsvnpresart2() != null) {
                        report.setHrecdescripcio("Presi�n Arterial: " + 
                                                 obtenerPresionArteria(signoVital.getHsvnpresart1().toString(), 
                                                                       signoVital.getHsvnpresart2().toString()));
                        if (signoVital.getHsvnfreccard() != null) {
                            report.setHrecdescripcio2("Frecuencia Cardiaca: " + 
                                                      formatearCampo(signoVital.getHsvnfreccard()) + 
                                                      " lpm");
                        } else {
                            report.setHrecdescripcio2("");
                        }
                        if (signoVital.getHsvnpresioxido() != null) {
                            report.setHrecdescripcio3("Presi�n Di�xido de Carbono: " + 
                                                      formatearCampo(signoVital.getHsvnpresioxido()));
                        } else {
                            report.setHrecdescripcio3("");
                        }
                        report.setHrencodigo(imp_anestesia_signos);
                        report.setHrectipodescri("Signos Vitales Anestesia");
                        report.setHrentipoimpres(5);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(signoVital.getHsvdfecregistr());
                        lstReporte.add(report);
                    }

                    report = new Chreporte();
                    report.setHrecdescripcio("% Saturaci�n de Ox�geno: " + 
                                             formatearCampo(signoVital.getHsvnsatuoxihe()));
                    report.setHrecdescripcio2("");
                    if (signoVital.getHsvctiporespir() != null) {
                        String tipoResp = null;
                        if (signoVital.getHsvctiporespir().equals("E")) {
                            tipoResp = "Espont�nea.";
                        } else if (signoVital.getHsvctiporespir().equals("A")) {
                            tipoResp = "Asistida";
                        } else if (signoVital.getHsvctiporespir().equals("C")) {
                            tipoResp = "Controlada";
                        } else {
                            tipoResp = signoVital.getHsvctiporespir();
                        }

                        report.setHrecdescripcio3("Tipo de Respiraci�n: " + 
                                                  formatearCampo(tipoResp));
                    } else {
                        report.setHrecdescripcio3("");
                    }
                    report.setHrencodigo(imp_anestesia_signos);
                    report.setHrectipodescri("Signos Vitales Anestesia");
                    report.setHrentipoimpres(5);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(signoVital.getHsvdfecregistr());
                    lstReporte.add(report);
                }
            }
        }

        if (cirugia.getChcontmedane() != null && 
            !cirugia.getChcontmedane().isEmpty()) {
            Iterator it = (cirugia.getChcontmedane()).iterator();
            while (it.hasNext()) {
                Chcontmedane medicamento;
                Chreporte report = new Chreporte();

                medicamento = (Chcontmedane)it.next();

                if (medicamento != null && medicamento.getHmaninduccion() != null && 
                ((medicamento.getHmaninduccion() != null && medicamento.getHmaninduccion().intValue() > 0) || 
                (medicamento.getHmanmantenimie() != null && medicamento.getHmanmantenimie().intValue() > 0) ) ) {
                    report = new Chreporte();
                    report.setHrecdescripcio("****************************************************************************************************************************************************************");
                    report.setHrectipodescri("Medicamentos Anestesia");
                    report.setHrencodigo(imp_anestesia_medicamentos);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(medicamento.getHmadfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Medicamento " + 
                                             formatearCampo(medicamento.getHmacmedicament()));
                    if (medicamento.getHmaninduccion() != null) {
                        report.setHrecdescripcio2(" Inducci�n:   " + 
                                                  medicamento.getHmaninduccion()+ " " + medicamento.getHmacdesunidades());
                    } else {
                        report.setHrecdescripcio2("");
                    }

                    if (medicamento.getHmaninduccion() != null) {
                        report.setHrecdescripcio3(" Mantenimiento:   " + 
                                                  medicamento.getHmanmantenimie() + " " + medicamento.getHmacdesunidades() );
                    } else {
                        report.setHrecdescripcio2("");
                    }
                    report.setHrectipodescri("Medicamentos Anestesia");
                    report.setHrencodigo(imp_anestesia_medicamentos);
                    report.setHrentipoimpres(5);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(medicamento.getHmadfecregistr());
                    lstReporte.add(report);
                }
            }
        }

        if (cirugia.getChmonitoria() != null && 
            !cirugia.getChmonitoria().isEmpty()) {
            Iterator it = cirugia.getChmonitoria().iterator();
            while (it.hasNext()) {
                Chmonitoria monitoria = null;
                monitoria = (Chmonitoria)it.next();

                Chreporte report = new Chreporte();
                if (monitoria != null) {
                    report = new Chreporte();
                    report.setHrecdescripcio("****************************************************************************************************************************************************************");
                    report.setHrectipodescri("Monitoria");
                    report.setHrencodigo(imp_anestesia_monitoria);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(monitoria.getHmodfecregistr());
                    lstReporte.add(report);

                    if (monitoria.getHmocfonendosco() != null) {
                        String fonendos = null;
                        if (monitoria.getHmocfonendosco().equals("P")) {
                            fonendos = "Precordial";
                        } else if (monitoria.getHmocfonendosco().equals("E")) {
                            fonendos = "Esof�gico";
                        } else {
                            fonendos = monitoria.getHmocfonendosco();
                        }

                        report = new Chreporte();
                        report.setHrecdescripcio("Fonendoscopio: " + 
                                                 formatearCampo(fonendos));
                        report.setHrectipodescri("Monitoria");
                        report.setHrencodigo(imp_anestesia_monitoria);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(monitoria.getHmodfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrecdescripcio("Sitio de colocaci�n: " + 
                                                 formatearCampo(monitoria.getHmocsitiofonen()));
                        report.setHrectipodescri("Monitoria");
                        report.setHrencodigo(imp_anestesia_monitoria);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(monitoria.getHmodfecregistr());
                        lstReporte.add(report);
                    }

                    report = new Chreporte();
                    report.setHrecdescripcio("Electrocardiograf�a - Derivaci�n: " + 
                                             formatearCampo(monitoria.getHmocelectderiv()));
                    report.setHrectipodescri("Monitoria");
                    report.setHrencodigo(imp_anestesia_monitoria);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(monitoria.getHmodfecregistr());
                    lstReporte.add(report);

                    if (monitoria.getHmocotraderiva() != null) {
                        report = new Chreporte();
                        report.setHrecdescripcio("Cual?: " + 
                                                 formatearCampo(monitoria.getHmocotraderiva()));
                        report.setHrectipodescri("Monitoria");
                        report.setHrencodigo(imp_anestesia_monitoria);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(monitoria.getHmodfecregistr());
                        lstReporte.add(report);
                    }

                    if (monitoria.getHmoccapnografi() != null && 
                        monitoria.getHmoccapnografi().equals("S")) {
                        report = new Chreporte();
                        report.setHrecdescripcio("Capnograf�a: " + 
                                                 formatearCampo("Si"));
                        report.setHrectipodescri("Monitoria");
                        report.setHrencodigo(imp_anestesia_monitoria);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(monitoria.getHmodfecregistr());
                        lstReporte.add(report);

                        String tipcapno = null;
                        if (monitoria.getHmoctipocapnog() == null) {
                            tipcapno = " ";
                        } else if (monitoria.getHmoctipocapnog().equals("A")) {
                            tipcapno = "Aspiraci�n";
                        } else if (monitoria.getHmoctipocapnog().equals("F")) {
                            tipcapno = "Flujo";
                        } else {
                            tipcapno = monitoria.getHmoctipocapnog();
                        }
                        report = new Chreporte();
                        report.setHrecdescripcio("Tipo de Capnograf�a: " + 
                                                 formatearCampo(tipcapno));
                        report.setHrectipodescri("Monitoria");
                        report.setHrencodigo(imp_anestesia_monitoria);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(monitoria.getHmodfecregistr());
                        lstReporte.add(report);
                    } else {
                        report = new Chreporte();
                        report.setHrecdescripcio("Capnograf�a: " + 
                                                 formatearCampo("No"));
                        report.setHrectipodescri("Monitoria");
                        report.setHrencodigo(imp_anestesia_monitoria);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(monitoria.getHmodfecregistr());
                        lstReporte.add(report);
                    }

                    if (monitoria.getHmocpresiarter() != null) {
                        if (monitoria.getHmocpresiarter().equals("N")) {
                            report = new Chreporte();
                            report.setHrecdescripcio("Presi�n Arterial: " + 
                                                     formatearCampo("No invasiva"));
                            report.setHrectipodescri("Monitoria");
                            report.setHrencodigo(imp_anestesia_monitoria);
                            report.setHrentipoimpres(1);
                            report.setHrenconsulta(cirugia.getHcplnumero());
                            report.setHredfecharegis(monitoria.getHmodfecregistr());
                            lstReporte.add(report);

                            if (monitoria.getHmoctipopresio() != null) {
                                report = new Chreporte();
                                report.setHrecdescripcio("Tipo Presion Arterial: " + 
                                                         formatearCampo(monitoria.getHmoctipopresio()));
                                report.setHrectipodescri("Monitoria");
                                report.setHrencodigo(imp_anestesia_monitoria);
                                report.setHrentipoimpres(1);
                                report.setHrenconsulta(cirugia.getHcplnumero());
                                report.setHredfecharegis(monitoria.getHmodfecregistr());
                                lstReporte.add(report);
                            }
                        } else {
                            report = new Chreporte();
                            report.setHrecdescripcio("Presi�n Arterial: " + 
                                                     formatearCampo("Invasiva"));
                            report.setHrectipodescri("Monitoria");
                            report.setHrencodigo(imp_anestesia_monitoria);
                            report.setHrentipoimpres(1);
                            report.setHrenconsulta(cirugia.getHcplnumero());
                            report.setHredfecharegis(monitoria.getHmodfecregistr());
                            lstReporte.add(report);

                            if (monitoria.getHmoccanuaarter() != null) {
                                report = new Chreporte();
                                report.setHrecdescripcio("Procedimiento de canualci�n arterial: " + 
                                                         formatearCampo(monitoria.getHmoccanuaarter()));
                                report.setHrectipodescri("Monitoria");
                                report.setHrencodigo(imp_anestesia_monitoria);
                                report.setHrentipoimpres(1);
                                report.setHrenconsulta(cirugia.getHcplnumero());
                                report.setHredfecharegis(monitoria.getHmodfecregistr());
                                lstReporte.add(report);
                            }
                        }
                    }

                    String oxipul = null;
                    
                    if(monitoria.getHmocoximepulso() != null){
                        if (monitoria.getHmocoximepulso().equals("S")) {
                            oxipul = "Si";
                        } else {
                            oxipul = "No";
                        }
                        report = new Chreporte();
                        report.setHrecdescripcio("Oximetria de pulso: " + 
                                                 formatearCampo(oxipul));
                        report.setHrectipodescri("Monitoria");
                        report.setHrencodigo(imp_anestesia_monitoria);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(monitoria.getHmodfecregistr());
                        lstReporte.add(report);
                    }


                    if (monitoria.getHmocrelajmuscu() != null && 
                        monitoria.getHmocrelajmuscu().equals("S")) {
                        report = new Chreporte();
                        report.setHrecdescripcio("Relajaci�n Muscular: " + 
                                                 formatearCampo("Si"));
                        report.setHrectipodescri("Monitoria");
                        report.setHrencodigo(imp_anestesia_monitoria);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(monitoria.getHmodfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrecdescripcio("Relajaci�n Muscular: " + 
                                                 formatearCampo(monitoria.getHmocobserrelaj()));
                        report.setHrectipodescri("Monitoria");
                        report.setHrencodigo(imp_anestesia_monitoria);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(monitoria.getHmodfecregistr());
                        lstReporte.add(report);
                    } else {
                        report = new Chreporte();
                        report.setHrecdescripcio("Relajaci�n Muscular: " + 
                                                 formatearCampo("No"));
                        report.setHrectipodescri("Monitoria");
                        report.setHrencodigo(imp_anestesia_monitoria);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(monitoria.getHmodfecregistr());
                        lstReporte.add(report);
                    }

                    if (monitoria.getHmocmonittempe() != null && 
                        monitoria.getHmocmonittempe().equals("S")) {
                        report = new Chreporte();
                        report.setHrecdescripcio("Temperatura: " + 
                                                 formatearCampo("Si"));
                        report.setHrectipodescri("Monitoria");
                        report.setHrencodigo(imp_anestesia_monitoria);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(monitoria.getHmodfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrecdescripcio("Sitio de toma de la temperatura: " + 
                                                 formatearCampo(monitoria.getHmocsitiotempe()));
                        report.setHrectipodescri("Monitoria");
                        report.setHrencodigo(imp_anestesia_monitoria);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(monitoria.getHmodfecregistr());
                        lstReporte.add(report);
                    } else {
                        report = new Chreporte();
                        report.setHrecdescripcio("Temperatura: " + 
                                                 formatearCampo("No"));
                        report.setHrectipodescri("Monitoria");
                        report.setHrencodigo(imp_anestesia_monitoria);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(monitoria.getHmodfecregistr());
                        lstReporte.add(report);
                    }
                }
            }
        }

        if (cirugia.getChventiaerea() != null && 
            !cirugia.getChventiaerea().isEmpty()) {
            Iterator it = (cirugia.getChventiaerea()).iterator();
            while (it.hasNext()) {
                Chventiaerea ventiAerea;
                Chreporte report = new Chreporte();

                ventiAerea = (Chventiaerea)it.next();
                if (ventiAerea != null) {
                    report = new Chreporte();
                    report.setHrecdescripcio("****************************************************************************************************************************************************************");
                    report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                    report.setHrencodigo(imp_anestesia_ventilacion);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                    lstReporte.add(report);

                    String tipoVent = null;
                    if (ventiAerea.getHvacmetodcontr() != null) {
                        if (ventiAerea.getHvacmetodcontr().equals("VE")) {
                            tipoVent = "Ventilaci�n espontanea.";
                        } else if (ventiAerea.getHvacmetodcontr().equals("VA")) {
                            tipoVent = "Ventilaci�n asistida/controlada";
                        } else if (ventiAerea.getHvacmetodcontr().equals("MA")) {
                            tipoVent = "Ventilaci�n Manual";
                        } else if (ventiAerea.getHvacmetodcontr().equals("ME")) {
                            tipoVent = "Ventilaci�n Mecanica";
                        } else {
                            tipoVent = ventiAerea.getHvacmetodcontr();
                        }
                    }

                    if (ventiAerea.getHvacmetodcontr() != null) {
                        report = new Chreporte();
                        report.setHrecdescripcio("Tipo Ventilaci�n: " + 
                                                 formatearCampo(tipoVent));
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);
                    }

                    report = new Chreporte();
                    if (ventiAerea.getHvacmascafacia().equals("S")) {
                        report.setHrecdescripcio("M�scara Facial: " + 
                                                 formatearCampo("Si"));
                    } else {
                        report.setHrecdescripcio("M�scara Facial: " + 
                                                 formatearCampo("No"));
                    }
                    report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                    report.setHrencodigo(imp_anestesia_ventilacion);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                    lstReporte.add(report);

                    if (ventiAerea.getHvaccanuorofar() != null && 
                        ventiAerea.getHvaccanuorofar().equals("N")) {
                        report = new Chreporte();
                        report.setHrecdescripcio("C�nula oro far�ngea: " + 
                                                 formatearCampo("No"));
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);
                    } else {
                        report = new Chreporte();
                        report.setHrecdescripcio("C�nula oro far�ngea: " + 
                                                 formatearCampo("Si"));
                        report.setHrecdescripcio2("N�mero: " + 
                                                  formatearCampo(ventiAerea.getHvancanulfarin()));
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(2);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);
                    }

                    report = new Chreporte();
                    if (ventiAerea.getHvaccanunasfar().equals("S")) {
                        report.setHrecdescripcio("C�nula naso far�ngea: " + 
                                                 formatearCampo("Si"));
                    } else {
                        report.setHrecdescripcio("C�nula naso far�ngea: " + 
                                                 formatearCampo("No"));
                    }
                    report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                    report.setHrencodigo(imp_anestesia_ventilacion);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                    lstReporte.add(report);

                    if (ventiAerea.getHvacmascalarin() == null) {
                        /* No imprime nada */
                    } else if (ventiAerea.getHvacmascalarin().equals("N")) {
                        report = new Chreporte();
                        report.setHrecdescripcio("M�scara lar�ngea: " + 
                                                 formatearCampo("No"));
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);
                    } else {
                        report = new Chreporte();
                        report.setHrecdescripcio("M�scara lar�ngea: " + 
                                                 formatearCampo("Si"));
                        if(ventiAerea.getHvancaliblarin() != null){
                            report.setHrecdescripcio2("Calibre: " + 
                                                     formatearCampo(ventiAerea.getHvancaliblarin()));    
                        }else{
                            report.setHrecdescripcio2(""); 
                        }
                        
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(2);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        if(ventiAerea.getHvacmascaclasi()!= null || ventiAerea.getHvacmascaprose() != null ||
                            ventiAerea.getHvacmascafastr() != null || ventiAerea.getHvacmascasupre() != null){
                        report.setHrecdescripcio("Cl�sica: " + 
                                                 formatearCampo(ventiAerea.getHvacmascaclasi()));
                        report.setHrecdescripcio2("Proseal: " + 
                                                  formatearCampo(ventiAerea.getHvacmascaprose()));
                        report.setHrecdescripcio3("Fastrach: " + 
                                                  formatearCampo(ventiAerea.getHvacmascafastr()));
                        report.setHrecdescripcio4("Supreme: " + 
                                                  formatearCampo(ventiAerea.getHvacmascasupre()));
                        }else if(ventiAerea.getHvacmasclarin() != null){
                            report.setHrecdescripcio("Cl�sica: " + 
                                                     formatearCampo("No"));
                            report.setHrecdescripcio2("Proseal: " + 
                                                      formatearCampo("No"));
                            report.setHrecdescripcio3("Fastrach: " + 
                                                      formatearCampo("No"));
                            report.setHrecdescripcio4("Supreme: " + 
                                                      formatearCampo("No"));
                            if (ventiAerea.getHvacmasclarin() != null && ventiAerea.getHvacmasclarin().equals("CL")) {
                                report.setHrecdescripcio("Cl�sica: " + formatearCampo("Si"));
                            } else if (ventiAerea.getHvacmasclarin() != null && ventiAerea.getHvacmasclarin().equals("PR")) {
                                report.setHrecdescripcio2("Proseal: " + formatearCampo("Si"));
                            } else if (ventiAerea.getHvacmasclarin() != null && ventiAerea.getHvacmasclarin().equals("FA")) {
                                report.setHrecdescripcio3("Fastrach: " + formatearCampo("Si"));
                            } else if (ventiAerea.getHvacmasclarin() != null && ventiAerea.getHvacmasclarin().equals("SU")) {
                                report.setHrecdescripcio4("Supreme: " + formatearCampo("Si"));
                            }
                        }
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(8);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrecdescripcio("Fecha colocaci�n: " + 
                                                 formatearCampo(ventiAerea.getHvadhoracolmas()));
                        report.setHrecdescripcio2("Hora de colocaci�n: " + 
                                                  formatearCampoHoraSimple(ventiAerea.getHvadhoracolmas()));
                        report.setHrecdescripcio3("Fecha de retiro: " + 
                                                  formatearCampo(ventiAerea.getHvadhoraretmas()));
                        report.setHrecdescripcio4("Hora de retiro: " + 
                                                  formatearCampoHoraSimple(ventiAerea.getHvadhoraretmas()));
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(8);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);
                    }

                    if (ventiAerea.getHvacotrodisglo() != null && 
                        ventiAerea.getHvacotrodisglo().equals("N")) {
                        report = new Chreporte();
                        report.setHrecdescripcio("Otro dispositivo supra gl�tico: " + 
                                                 formatearCampo("No"));
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);
                    } else {
                        report = new Chreporte();
                        report.setHrecdescripcio("Otro dispositivo supra gl�tico: " + 
                                                 formatearCampo("Si"));
                        report.setHrecdescripcio2("Tipo de dispositivo utilizado: " + 
                                                  formatearCampo(ventiAerea.getHvacotrodispos()));
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(2);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrecdescripcio("Fecha colocaci�n: " + 
                                                 formatearCampo(ventiAerea.getHvadhoracolotr()));
                        report.setHrecdescripcio2("Hora de colocaci�n: " + 
                                                  formatearCampoHoraSimple(ventiAerea.getHvadhoracolotr()));
                        report.setHrecdescripcio3("Fecha de retiro: " + 
                                                  formatearCampo(ventiAerea.getHvadhoraretotr()));
                        report.setHrecdescripcio4("Hora de retiro: " + 
                                                  formatearCampoHoraSimple(ventiAerea.getHvadhoraretotr()));
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(8);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);
                    }

                    if (ventiAerea.getHvacintubacion() != null && 
                        ventiAerea.getHvacintubacion().equals("N")) {
                        report = new Chreporte();
                        report.setHrecdescripcio("Intubaci�n: " + 
                                                 formatearCampo("No"));
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);
                    } else {
                        report = new Chreporte();
                        report.setHrecdescripcio("Intubaci�n: " + 
                                                 formatearCampo("Si"));
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrecdescripcio("Orotraqueal: " + 
                                                 formatearCampo(ventiAerea.getHvanintuborotr()));
                        report.setHrecdescripcio2("Nasotraqueal: " + 
                                                  formatearCampo(ventiAerea.getHvanintubnasot()));
                        report.setHrecdescripcio3("Vista laringoscopica: " + 
                                                  formatearCampo(ventiAerea.getHvacvistalarin()));
                        report.setHrecdescripcio4("");
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(8);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrecdescripcio("Fecha Intubaci�n: " + 
                                                 formatearCampo(ventiAerea.getHvadhoraintuba()));
                        report.setHrecdescripcio2("Hora Intubaci�n: " + 
                                                  formatearCampoHoraSimple(ventiAerea.getHvadhoraintuba()));
                        report.setHrecdescripcio3("Fecha Extubaci�n: " + 
                                                  formatearCampo(ventiAerea.getHvadhoraextuba()));
                        report.setHrecdescripcio4("Hora Extubaci�n: " + 
                                                  formatearCampoHoraSimple(ventiAerea.getHvadhoraextuba()));
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(8);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);
                    }

                    if (ventiAerea.getHvacotro() != null && 
                        ventiAerea.getHvacotro().equals("N")) {
                        report = new Chreporte();
                        report.setHrecdescripcio("Otro: " + 
                                                 formatearCampo("No"));
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);
                    } else {
                        report = new Chreporte();
                        report.setHrecdescripcio("Otro: " + 
                                                 formatearCampo("Si"));
                        report.setHrecdescripcio2("Cu�l?: " + 
                                                  formatearCampo(ventiAerea.getHvacmetoconvia()));
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(2);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);
                    }

                    if (ventiAerea.getHvacmodoventil() != null && 
                        ventiAerea.getHvacmodoventil().equals("M")) {
                        report = new Chreporte();
                        report.setHrecdescripcio("Modo de Ventilaci�n: " + 
                                                 formatearCampo("Manual"));
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);
                    } else {
                        report = new Chreporte();
                        report.setHrecdescripcio("Modo de Ventilaci�n: " + 
                                                 formatearCampo("Mec�nica"));
                        report.setHrecdescripcio2("Frecuencia respiratoria en ventilaciones por minuto: " + 
                                                  formatearCampo(ventiAerea.getHvanmecanfrecu()));
                        report.setHrecdescripcio3("Volumen corriente en mililitros: " + 
                                                  formatearCampo(ventiAerea.getHvanmecanvolum()));
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(5);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrecdescripcio("Ventilador: " + 
                                                 formatearCampo(ventiAerea.getHvacmecanventi()));
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);
                    }


                    String cirAdmon = null;
                    if (ventiAerea.getHvaccircuoxige() != null && 
                        ventiAerea.getHvaccircuoxige().equals("CC")) {
                        cirAdmon = "Circular Cerrado";
                    } else if (ventiAerea.getHvaccircuoxige().equals("CS")) {
                        cirAdmon = "Circular Semicerrado";
                    } else if (ventiAerea.getHvaccircuoxige().equals("BA")) {
                        cirAdmon = "Bain";
                    } else if (ventiAerea.getHvaccircuoxige().equals("JR")) {
                        cirAdmon = "Jackson-Rees";
                    } else if (ventiAerea.getHvaccircuoxige().equals("OD")) {
                        cirAdmon = "Ox�geno directo";
                    } else if (ventiAerea.getHvaccircuoxige().equals("IN")) {
                        cirAdmon = "Intubaci�n ";
                    } else if (ventiAerea.getHvaccircuoxige().equals("OT")) {
                        cirAdmon = "Otro";
                    } else {
                        cirAdmon = ventiAerea.getHvaccircuoxige();
                    }

                    if (ventiAerea.getHvaccircuoxige() != null && 
                        ventiAerea.getHvaccircuoxige().equals("OT")) {
                        report = new Chreporte();
                        report.setHrecdescripcio("Circuito de administraci�n de Ox�geno : " + 
                                                 formatearCampo(cirAdmon));
                        report.setHrecdescripcio2("Cual?: " + 
                                                  formatearCampo(ventiAerea.getHvacotrooxigen()));
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(2);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);
                    } else if (ventiAerea.getHvaccircuoxige().equals("OD")) {
                        report = new Chreporte();
                        report.setHrecdescripcio("Circuito de administraci�n de Ox�geno : " + 
                                                 formatearCampo(cirAdmon));
                        if (ventiAerea.getHvactipooxigen() != null) {
                            if (ventiAerea.getHvactipooxigen().equals("MO")) {
                                report.setHrecdescripcio2("Tipo Oxigeno: " + 
                                                      formatearCampo("M�scara de Oxigeno"));
                                if (ventiAerea.getHvactipomascar() == null) {
                                    // no imprime nada
                                } else if (ventiAerea.getHvactipomascar().equals("CR")) {
                                    report.setHrecdescripcio3("M�scara de Oxigeno: " + 
                                                          formatearCampo("Con reservorio"));
                                } else {
                                    report.setHrecdescripcio3("M�scara de Oxigeno: " + 
                                                          formatearCampo("Sin reservorio"));
                                }
                            } else {
                                report.setHrecdescripcio2("Tipo Oxigeno: " + 
                                                      formatearCampo("C�nula Nasal"));
                                report.setHrecdescripcio3(" ");
                            }
                        }
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(5);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);
                    } else {
                        report = new Chreporte();
                        report.setHrecdescripcio("Circuito de administraci�n de Ox�geno : " + 
                                                 formatearCampo(cirAdmon));
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);
                    }

                    if (ventiAerea.getHvaccontviarea() != null) {
                        report = new Chreporte();
                        if (ventiAerea.getHvaccontviarea().equals("F")) {
                            report.setHrecdescripcio("Control de la v�a a�rea: " + 
                                                     formatearCampo("Facil"));
                            report.setHrecdescripcio2(" ");
                        } else {
                            report.setHrecdescripcio("Control de la v�a a�rea: " + 
                                                     formatearCampo("Dificl"));
                            report.setHrecdescripcio2("Dificultades de control de la v�a a�rea: " + 
                                                      formatearCampo(ventiAerea.getHvacviadificil()));
                        }
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(2);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);
                    }

                    if (ventiAerea.getHvacverifviare() != null) {
                        report = new Chreporte();
                        if (ventiAerea.getHvacverifviare().equals("C")) {
                            report.setHrecdescripcio("Verificaci�n v�a a�rea: " + 
                                                     formatearCampo("Capnograf�a"));
                            report.setHrecdescripcio2(" ");
                        } else if (ventiAerea.getHvacverifviare().equals("A")) {
                            report.setHrecdescripcio("Verificaci�n v�a a�rea: " + 
                                                     formatearCampo("Auscultaci�n"));
                            report.setHrecdescripcio2(" ");
                        } else {
                            report.setHrecdescripcio("Verificaci�n v�a a�rea: " + 
                                                     formatearCampo("Auscultaci�n"));
                            report.setHrecdescripcio2("Otra: " + 
                                                      formatearCampo(ventiAerea.getHvacotraverifi()));
                        }
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(2);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);
                    }

                    if (ventiAerea.getHvacverviarecap() != null || 
                        ventiAerea.getHvacverviareaus() != null || 
                        ventiAerea.getHvacverviareotr() != null) {
                        report = new Chreporte();
                        String verificacion = "";
                        if (ventiAerea.getHvacverviarecap().equals("S")) {
                            verificacion = verificacion + "Capnograf�a -";
                        }
                        if (ventiAerea.getHvacverviareaus().equals("S")) {
                            verificacion = verificacion + "Auscultaci�n -";
                        }
                        if (ventiAerea.getHvacverviareotr().equals("S")) {
                            report.setHrecdescripcio2("Otra: " + 
                                                      formatearCampo(ventiAerea.getHvacotraverifi()));
                        }
                        report.setHrecdescripcio("Verificaci�n v�a a�rea: " + 
                                                 verificacion);
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(2);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);
                    }


                    if (ventiAerea.getHvacobserviare() != null) {
                        report = new Chreporte();
                        report.setHrecdescripcio("Observaciones: " + 
                                                 formatearCampo(ventiAerea.getHvacobserviare()));
                        report.setHrectipodescri("Ventilaci�n y Manejo de V�a A�rea");
                        report.setHrencodigo(imp_anestesia_ventilacion);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(ventiAerea.getHvadfecregistr());
                        lstReporte.add(report);
                    }

                }
            }
        }

        Chtecnianest tecniAnes = null;
        try {
            tecniAnes = 
                    this.serviceLocator.getClinicoService().getTecnicaAnestesia(cirugia.getHcplnumero());
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (tecniAnes != null) {
            Chreporte report = new Chreporte();

            report = new Chreporte();
            report.setHrecdescripcio("****************************************************************************************************************************************************************");
            report.setHrectipodescri("T�cnica Anest�sia");
            report.setHrencodigo(imp_anestesia_tecnica);
            report.setHrentipoimpres(1);
            report.setHrenconsulta(cirugia.getHcplnumero());
            report.setHredfecharegis(tecniAnes.getHtadfecregistr());
            lstReporte.add(report);

            if (tecniAnes.getHtacanestgener() == null || 
                tecniAnes.getHtacanestgener().equals("N")) {
                report = new Chreporte();
                report.setHrecdescripcio("General: " + formatearCampo("No"));
                report.setHrectipodescri("T�cnica Anest�sia");
                report.setHrencodigo(imp_anestesia_tecnica);
                report.setHrentipoimpres(1);
                report.setHrenconsulta(cirugia.getHcplnumero());
                report.setHredfecharegis(tecniAnes.getHtadfecregistr());
                lstReporte.add(report);
            } else {
                report = new Chreporte();
                report.setHrecdescripcio("General: " + formatearCampo("Si"));
                if (tecniAnes.getHtactipoanegen() == null) {
                    report.setHrecdescripcio2("�Forma Administraci�n?: ");
                } else if (tecniAnes.getHtactipoanegen().equals("IH")) {
                    report.setHrecdescripcio2("�Forma Administraci�n?: " + 
                                              formatearCampo("Inhalatoria."));
                } else if (tecniAnes.getHtactipoanegen().equals("IV")) {
                    report.setHrecdescripcio2("�Forma Administraci�n?: " + 
                                              formatearCampo("Intravenosa"));
                } else if (tecniAnes.getHtactipoanegen().equals("BA")) {
                    report.setHrecdescripcio2("�Forma Administraci�n?: " + 
                                              formatearCampo("Balanceada"));
                } else {
                    report.setHrecdescripcio2("�Forma Administraci�n?: " + 
                                              formatearCampo(tecniAnes.getHtactipoanegen()));
                }
                report.setHrectipodescri("T�cnica Anest�sia");
                report.setHrencodigo(imp_anestesia_tecnica);
                report.setHrentipoimpres(2);
                report.setHrenconsulta(cirugia.getHcplnumero());
                report.setHredfecharegis(tecniAnes.getHtadfecregistr());
                lstReporte.add(report);
            }

            if (tecniAnes.getHtacanestregio() == null || 
                tecniAnes.getHtacanestregio().equals("N")) {
                report = new Chreporte();
                report.setHrecdescripcio("Regional: " + formatearCampo("No"));
                report.setHrectipodescri("T�cnica Anest�sia");
                report.setHrencodigo(imp_anestesia_tecnica);
                report.setHrentipoimpres(1);
                report.setHrenconsulta(cirugia.getHcplnumero());
                report.setHredfecharegis(tecniAnes.getHtadfecregistr());
                lstReporte.add(report);
            } else {
                report = new Chreporte();
                report.setHrecdescripcio("Regional: " + formatearCampo("Si"));
                if (tecniAnes.getHtactipoanereg() == null) {
                    report.setHrecdescripcio2("�Forma Administraci�n?: ");
                } else if (tecniAnes.getHtactipoanereg().equals("NE")) {
                    report.setHrecdescripcio2("�Forma Administraci�n?: " + 
                                              formatearCampo("Neuroaxial"));
                    if (tecniAnes.getHtactiponeuroa() != null && tecniAnes.getHtactiponeuroa().equals("P")) {
                        report.setHrecdescripcio3("Tipo Neuroaxial: " + 
                                                  formatearCampo("Peridural"));
                    } else {
                        report.setHrecdescripcio3("Tipo Neuroaxial: " + 
                                                  formatearCampo("Subaracnoidea"));
                    }
                } else if (tecniAnes.getHtactipoanereg().equals("BP")) {
                    report.setHrecdescripcio2("�Forma Administraci�n?: " + 
                                              formatearCampo("Bloqueo plejos"));
                    report.setHrecdescripcio3("");
                } else if (tecniAnes.getHtactipoanereg().equals("BT")) {
                    report.setHrecdescripcio2("�Forma Administraci�n?: " + 
                                              formatearCampo("Bloqueo Troncular"));
                    report.setHrecdescripcio3("");
                } else if (tecniAnes.getHtactipoanereg().equals("OT")) {
                    report.setHrecdescripcio2("�Forma Administraci�n?: " + 
                                              formatearCampo("Otros"));
                    report.setHrecdescripcio3("");
                } else {
                    report.setHrecdescripcio2("�Forma Administraci�n?: " + 
                                              formatearCampo(tecniAnes.getHtactipoanereg()));
                    report.setHrecdescripcio3("");
                }
                report.setHrectipodescri("T�cnica Anest�sia");
                report.setHrencodigo(imp_anestesia_tecnica);
                report.setHrentipoimpres(5);
                report.setHrenconsulta(cirugia.getHcplnumero());
                report.setHredfecharegis(tecniAnes.getHtadfecregistr());
                lstReporte.add(report);
            }

            report = new Chreporte();
            if (tecniAnes.getHtacanestlocal() == null || 
                tecniAnes.getHtacanestlocal().equals("N")) {
                report.setHrecdescripcio("Local controlada: " + 
                                         formatearCampo("No"));
            } else {
                report.setHrecdescripcio("Local controlada: " + 
                                         formatearCampo("Si"));
            }
            report.setHrectipodescri("T�cnica Anest�sia");
            report.setHrencodigo(imp_anestesia_tecnica);
            report.setHrentipoimpres(1);
            report.setHrenconsulta(cirugia.getHcplnumero());
            report.setHredfecharegis(tecniAnes.getHtadfecregistr());
            lstReporte.add(report);

            report = new Chreporte();
            if (tecniAnes.getHtacdescrproce() == null) {
                report.setHrecdescripcio("Descripci�n del procedimiento anest�sico: ");
            } else {
                report.setHrecdescripcio("Descripci�n del procedimiento anest�sico: " + 
                                         formatearCampo(tecniAnes.getHtacdescrproce()));
            }
            report.setHrectipodescri("T�cnica Anest�sia");
            report.setHrencodigo(imp_anestesia_tecnica);
            report.setHrentipoimpres(1);
            report.setHrenconsulta(cirugia.getHcplnumero());
            report.setHredfecharegis(tecniAnes.getHtadfecregistr());
            lstReporte.add(report);

            if (tecniAnes.getHtanoxigeno() != null) {
                report = new Chreporte();
                report.setHrecdescripcio("Oxigeno O2: " + 
                                         formatearCampo(tecniAnes.getHtanoxigeno() + 
                                                        " LPM"));
                report.setHrecdescripcio2("Fecha Inicio: " + 
                                          formatearCampo(tecniAnes.getHtadfechinioxi()));
                report.setHrecdescripcio3("Hora Inicio: " + 
                                          formatearCampoHoraSimple(tecniAnes.getHtadfechinioxi()));
                report.setHrectipodescri("T�cnica Anest�sia");
                report.setHrencodigo(imp_anestesia_tecnica);
                report.setHrentipoimpres(5);
                report.setHrenconsulta(cirugia.getHcplnumero());
                report.setHredfecharegis(tecniAnes.getHtadfecregistr());
                lstReporte.add(report);

                report = new Chreporte();
                report.setHrecdescripcio(" ");
                report.setHrecdescripcio2("Fecha Fin: " + 
                                          formatearCampo(tecniAnes.getHtadfechfinoxi()));
                report.setHrecdescripcio3("Hora Fin: " + 
                                          formatearCampoHoraSimple(tecniAnes.getHtadfechfinoxi()));
                report.setHrectipodescri("T�cnica Anest�sia");
                report.setHrencodigo(imp_anestesia_tecnica);
                report.setHrentipoimpres(5);
                report.setHrenconsulta(cirugia.getHcplnumero());
                report.setHredfecharegis(tecniAnes.getHtadfecregistr());
                lstReporte.add(report);
            }

            if (tecniAnes.getHtanoxidonitro() != null) {
                report = new Chreporte();
                report.setHrecdescripcio("Oxigeno Nitroso: " + 
                                         formatearCampo(tecniAnes.getHtanoxidonitro() + 
                                                        " LPM"));
                report.setHrecdescripcio2("Fecha Inicio: " + 
                                          formatearCampo(tecniAnes.getHtadfechininit()));
                report.setHrecdescripcio3("Hora Inicio: " + 
                                          formatearCampoHoraSimple(tecniAnes.getHtadfechininit()));
                report.setHrectipodescri("T�cnica Anest�sia");
                report.setHrencodigo(imp_anestesia_tecnica);
                report.setHrentipoimpres(5);
                report.setHrenconsulta(cirugia.getHcplnumero());
                report.setHredfecharegis(tecniAnes.getHtadfecregistr());
                lstReporte.add(report);

                report = new Chreporte();
                report.setHrecdescripcio(" ");
                report.setHrecdescripcio2("Fecha Fin: " + 
                                          formatearCampo(tecniAnes.getHtadfechfinnit()));
                report.setHrecdescripcio3("Hora Fin: " + 
                                          formatearCampoHoraSimple(tecniAnes.getHtadfechfinnit()));
                report.setHrectipodescri("T�cnica Anest�sia");
                report.setHrencodigo(imp_anestesia_tecnica);
                report.setHrentipoimpres(5);
                report.setHrenconsulta(cirugia.getHcplnumero());
                report.setHredfecharegis(tecniAnes.getHtadfecregistr());
                lstReporte.add(report);
            }

            report = new Chreporte();
            report.setHrecdescripcio("Agentes Anestesico Inhalatorio: ");
            report.setHrecdescripcio2("Fecha Inicio: " + 
                                      formatearCampo(tecniAnes.getHtadfechiniinh()));
            report.setHrecdescripcio3("Hora Inicio: " + 
                                      formatearCampoHoraSimple(tecniAnes.getHtadfechiniinh()));
            report.setHrectipodescri("T�cnica Anest�sia");
            report.setHrencodigo(imp_anestesia_tecnica);
            report.setHrentipoimpres(5);
            report.setHrenconsulta(cirugia.getHcplnumero());
            report.setHredfecharegis(tecniAnes.getHtadfecregistr());
            lstReporte.add(report);

            String indAgen = null;
            if (tecniAnes.getHtacinducagent() == null) {
                indAgen = " ";
            } else if (tecniAnes.getHtacinducagent().equals("H")) {
                indAgen = "Halotano";
            } else if (tecniAnes.getHtacinducagent().equals("E")) {
                indAgen = "Enflurano";
            } else if (tecniAnes.getHtacinducagent().equals("I")) {
                indAgen = "Isoflurano";
            } else if (tecniAnes.getHtacinducagent().equals("S")) {
                indAgen = "Sevoflurano";
            } else if (tecniAnes.getHtacinducagent().equals("D")) {
                indAgen = "Desflurano";
            } else {
                indAgen = tecniAnes.getHtacinducagent();
            }
            report = new Chreporte();
            report.setHrecdescripcio("Inducci�n Agente: " + 
                                     formatearCampo(indAgen));
            if (tecniAnes.getHtanconcentrac() != null) {
                report.setHrecdescripcio2("Volumen (%): " + 
                                          formatearCampo(tecniAnes.getHtanconcentrac()));
            }
            report.setHrectipodescri("T�cnica Anest�sia");
            report.setHrencodigo(imp_anestesia_tecnica);
            report.setHrentipoimpres(5);
            report.setHrenconsulta(cirugia.getHcplnumero());
            report.setHredfecharegis(tecniAnes.getHtadfecregistr());
            lstReporte.add(report);

            String manAgen = null;
            if (tecniAnes.getHtacmanteagent() == null) {
                manAgen = " ";
            } else if (tecniAnes.getHtacmanteagent().equals("H")) {
                manAgen = "Halotano";
            } else if (tecniAnes.getHtacmanteagent().equals("E")) {
                manAgen = "Enflurano";
            } else if (tecniAnes.getHtacmanteagent().equals("I")) {
                manAgen = "Isoflurano";
            } else if (tecniAnes.getHtacmanteagent().equals("S")) {
                manAgen = "Sevoflurano";
            } else if (tecniAnes.getHtacmanteagent().equals("D")) {
                manAgen = "Desflurano";
            } else {
                manAgen = tecniAnes.getHtacmanteagent();
            }
            report = new Chreporte();
            report.setHrecdescripcio("Mantenimiento Agente: " + 
                                     formatearCampo(manAgen));
            if (tecniAnes.getHtanmanteconce() != null) {
                report.setHrecdescripcio2("Volumen (%): " + 
                                          formatearCampo(tecniAnes.getHtanmanteconce()));
            }
            report.setHrectipodescri("T�cnica Anest�sia");
            report.setHrencodigo(imp_anestesia_tecnica);
            report.setHrentipoimpres(5);
            report.setHrenconsulta(cirugia.getHcplnumero());
            report.setHredfecharegis(tecniAnes.getHtadfecregistr());
            lstReporte.add(report);

            if (tecniAnes.getHtaccambiconce() == null || 
                tecniAnes.getHtaccambiconce().equals("N")) {
                report.setHrecdescripcio("Cambio Concentraci�n: " + 
                                         formatearCampo("No"));
                report.setHrectipodescri("T�cnica Anest�sia");
                report.setHrencodigo(imp_anestesia_tecnica);
                report.setHrentipoimpres(1);
                report.setHrenconsulta(cirugia.getHcplnumero());
                report.setHredfecharegis(tecniAnes.getHtadfecregistr());
                lstReporte.add(report);
            } else {
                report = new Chreporte();
                report.setHrecdescripcio("Cambio Concentraci�n: " + 
                                         formatearCampo("Si"));
                report.setHrecdescripcio2("Porcentaje(%): " + 
                                          formatearCampo(tecniAnes.getHtancambiconce()));
                report.setHrecdescripcio3("Fecha de Cambio: " + 
                                          formatearCampo(tecniAnes.getHtadfechacambi()));
                report.setHrecdescripcio4("Hora de Cambio: " + 
                                          formatearCampoHoraSimple(tecniAnes.getHtadfechacambi()));
                report.setHrectipodescri("T�cnica Anest�sia");
                report.setHrencodigo(imp_anestesia_tecnica);
                report.setHrentipoimpres(8);
                report.setHrenconsulta(cirugia.getHcplnumero());
                report.setHredfecharegis(tecniAnes.getHtadfecregistr());
                lstReporte.add(report);
            }

            report = new Chreporte();
            report.setHrecdescripcio("");
            report.setHrecdescripcio2("Fecha Finalizaci�n: " + 
                                      formatearCampo(tecniAnes.getHtadfechfininh()));
            report.setHrecdescripcio3("Hora Finalizaci�n: " + 
                                      formatearCampoHoraSimple(tecniAnes.getHtadfechfininh()));
            report.setHrectipodescri("T�cnica Anest�sia");
            report.setHrencodigo(imp_anestesia_tecnica);
            report.setHrentipoimpres(5);
            report.setHrenconsulta(cirugia.getHcplnumero());
            report.setHredfecharegis(tecniAnes.getHtadfecregistr());
            lstReporte.add(report);

            if (tecniAnes.getHtacobservacio() != null) {
                report = new Chreporte();
                report.setHrecdescripcio("Observaciones: " + 
                                         formatearCampo(tecniAnes.getHtacobservacio()));
                report.setHrectipodescri("T�cnica Anest�sia");
                report.setHrencodigo(imp_anestesia_tecnica);
                report.setHrentipoimpres(1);
                report.setHrenconsulta(cirugia.getHcplnumero());
                report.setHredfecharegis(tecniAnes.getHtadfecregistr());
                lstReporte.add(report);
            }
        }

        if (cirugia.getChposicanest() != null && 
            !cirugia.getChposicanest().isEmpty()) {
            Iterator it = cirugia.getChposicanest().iterator();
            while (it.hasNext()) {
                Chposicanest posicAnest = null;
                posicAnest = (Chposicanest)it.next();

                if (posicAnest != null) {
                    Chreporte report = new Chreporte();
                    report = new Chreporte();
                    report.setHrecdescripcio("****************************************************************************************************************************************************************");
                    report.setHrectipodescri("Posici�n y otras medidas de protecci�n");
                    report.setHrencodigo(imp_anestesia_posicion);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(posicAnest.getHpadfecregistr());
                    lstReporte.add(report);

                    String posBasica = null;
                    if (posicAnest.getHpacposicbasic().equals("DSU")) {
                        posBasica = "Dec�bito supino";
                    } else if (posicAnest.getHpacposicbasic().equals("DPR")) {
                        posBasica = "Dec�bito prono";
                    } else if (posicAnest.getHpacposicbasic().equals("DLD")) {
                        posBasica = "Dec�bito lateral derecho";
                    } else if (posicAnest.getHpacposicbasic().equals("DLI")) {
                        posBasica = "Dec�bito lateral izquierdo";
                    } else if (posicAnest.getHpacposicbasic().equals("LIT")) {
                        posBasica = "Litotom�a";
                    } else if (posicAnest.getHpacposicbasic().equals("FOW")) {
                        posBasica = "Fowler";
                    }else if (posicAnest.getHpacposicbasic().equals("NEU")) {
                        posBasica = "Neutro";
                    } 
                    
                    else {
                        posBasica = posicAnest.getHpacposicbasic();
                    }
                    report = new Chreporte();
                    report.setHrecdescripcio("Posici�n B�sica: " + 
                                             formatearCampo(posBasica));
                    report.setHrectipodescri("Posici�n y otras medidas de protecci�n");
                    report.setHrencodigo(imp_anestesia_posicion);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(posicAnest.getHpadfecregistr());
                    lstReporte.add(report);

                    String modPosici = null;
                    if (posicAnest.getHpacmodifposic().equals("TRE")) {
                        modPosici = "Trendelemburg";
                    } else if (posicAnest.getHpacmodifposic().equals("FOW")) {
                        modPosici = "Fowler";
                    } else if (posicAnest.getHpacmodifposic().equals("NAV")) {
                        modPosici = "Navaja ";
                    } else if (posicAnest.getHpacmodifposic().equals("TIN")) {
                        modPosici = "Trendelemburg invertido";
                    }else if (posicAnest.getHpacmodifposic().equals("NEU")) {
                        modPosici = "Neutro";
                    }
                    
                    else {
                        modPosici = posicAnest.getHpacmodifposic();
                    }
                    report = new Chreporte();
                    report.setHrecdescripcio("Modificaci�n Posici�n: " + 
                                             formatearCampo(modPosici));
                    report.setHrectipodescri("Posici�n y otras medidas de protecci�n");
                    report.setHrencodigo(imp_anestesia_posicion);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(posicAnest.getHpadfecregistr());
                    lstReporte.add(report);

                    if (posicAnest.getHpadhoracampos() != null) {
                        report = new Chreporte();
                        report.setHrecdescripcio("Fecha Cambio: " + 
                                                 formatearCampo(posicAnest.getHpadhoracampos()));
                        report.setHrencodigo(imp_recomendaciones);
                        report.setHrectipodescri("Recomendaciones");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(posicAnest.getHpadfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrecdescripcio("Hora Cambio: " + 
                                                 formatearCampoHoraSimple(posicAnest.getHpadhoracampos()));
                        report.setHrencodigo(imp_recomendaciones);
                        report.setHrectipodescri("Recomendaciones");
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(posicAnest.getHpadfecregistr());
                        lstReporte.add(report);

                        String nueBasica = null;
                        if (posicAnest != null && 
                            posicAnest.getHpacnuevabasic() != null && 
                            posicAnest.getHpacnuevabasic().equals("DSU")) {
                            nueBasica = "Dec�bito supino";
                        } else if (posicAnest != null && 
                                   posicAnest.getHpacnuevabasic() != null && 
                                   posicAnest.getHpacnuevabasic().equals("DPR")) {
                            nueBasica = "Dec�bito prono";
                        } else if (posicAnest != null && 
                                   posicAnest.getHpacnuevabasic() != null && 
                                   posicAnest.getHpacnuevabasic().equals("DLD")) {
                            nueBasica = "Dec�bito lateral derecho";
                        } else if (posicAnest != null && 
                                   posicAnest.getHpacnuevabasic() != null && 
                                   posicAnest.getHpacnuevabasic().equals("DLI")) {
                            nueBasica = "Dec�bito lateral izquierdo";
                        } else if (posicAnest != null && 
                                   posicAnest.getHpacnuevabasic() != null && 
                                   posicAnest.getHpacnuevabasic().equals("LIT")) {
                            nueBasica = "Litotom�a";
                        } else if (posicAnest != null && 
                                   posicAnest.getHpacnuevabasic() != null && 
                                   posicAnest.getHpacnuevabasic().equals("FOW")) {
                            nueBasica = "Fowler";
                        }else if (posicAnest != null && 
                                   posicAnest.getHpacnuevabasic() != null && 
                                   posicAnest.getHpacnuevabasic().equals("NEU")) {
                            nueBasica = "Neutro";
                        } else if (posicAnest != null && 
                                   posicAnest.getHpacnuevabasic() != null) {
                            nueBasica = posicAnest.getHpacnuevabasic();
                        } else {
                            nueBasica = "";
                        }
                        report = new Chreporte();
                        report.setHrecdescripcio("Posici�n B�sica: " + 
                                                 formatearCampo(nueBasica));
                        report.setHrectipodescri("Posici�n y otras medidas de protecci�n");
                        report.setHrencodigo(imp_anestesia_posicion);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(posicAnest.getHpadfecregistr());
                        lstReporte.add(report);

                        String nueModif = null;
                        if (posicAnest.getHpacnuevamodif().equals("TRE")) {
                            nueModif = "Trendelemburg";
                        } else if (posicAnest.getHpacnuevamodif().equals("FOW")) {
                            nueModif = "Fowler";
                        } else if (posicAnest.getHpacnuevamodif().equals("NAV")) {
                            nueModif = "Navaja ";
                        } else if (posicAnest.getHpacnuevamodif().equals("TIN")) {
                            nueModif = "Trendelemburg invertido";
                        }else if (posicAnest.getHpacnuevamodif().equals("NEU")) {
                            nueModif = "Neutro";
                        } 
                        
                        else {
                            nueModif = posicAnest.getHpacnuevamodif();
                        }
                        report = new Chreporte();
                        report.setHrecdescripcio("Se desea realizar cambio de posici�n: " + 
                                                 formatearCampo(nueModif));
                        report.setHrectipodescri("Posici�n y otras medidas de protecci�n");
                        report.setHrencodigo(imp_anestesia_posicion);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(posicAnest.getHpadfecregistr());
                        lstReporte.add(report);
                    }

                    report = new Chreporte();
                    if (posicAnest.getHpacprotpunpre().equals("S")) {
                        report.setHrecdescripcio("Protecci�n puntos de presi�n: " + 
                                                 formatearCampo("Si"));
                    } else {
                        report.setHrecdescripcio("Protecci�n puntos de presi�n: " + 
                                                 formatearCampo("No"));
                    }
                    report.setHrectipodescri("Posici�n y otras medidas de protecci�n");
                    report.setHrencodigo(imp_anestesia_posicion);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(posicAnest.getHpadfecregistr());
                    lstReporte.add(report);

                    if (posicAnest.getHpacprotocupre() != null && 
                        posicAnest.getHpacprotocupre().equals("S")) {
                        report = new Chreporte();
                        report.setHrecdescripcio("Protecci�n ocular: " + 
                                                 formatearCampo("Si"));
                        report.setHrectipodescri("Posici�n y otras medidas de protecci�n");
                        report.setHrencodigo(imp_anestesia_posicion);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(posicAnest.getHpadfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrecdescripcio("Tipo de Protecci�n: " + 
                                                 formatearCampo(posicAnest.getHpacproteocula()));
                        report.setHrectipodescri("Posici�n y otras medidas de protecci�n");
                        report.setHrencodigo(imp_anestesia_posicion);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(posicAnest.getHpadfecregistr());
                        lstReporte.add(report);
                    } else {
                        report = new Chreporte();
                        report.setHrecdescripcio("Protecci�n ocular: " + 
                                                 formatearCampo("No"));
                        report.setHrectipodescri("Posici�n y otras medidas de protecci�n");
                        report.setHrencodigo(imp_anestesia_posicion);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(posicAnest.getHpadfecregistr());
                        lstReporte.add(report);
                    }

                    report = new Chreporte();
                    if (posicAnest.getHpaccompneuint().equals("S")) {
                        report.setHrecdescripcio("Compresi�n neum�tica intermitente en miembros inferiores: " + 
                                                 formatearCampo("Si"));
                    } else {
                        report.setHrecdescripcio("Compresi�n neum�tica intermitente en miembros inferiores: " + 
                                                 formatearCampo("No"));
                    }
                    report.setHrectipodescri("Posici�n y otras medidas de protecci�n");
                    report.setHrencodigo(imp_anestesia_posicion);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(posicAnest.getHpadfecregistr());
                    lstReporte.add(report);
                }
            }
        }

        if (cirugia.getChcierreanest() != null && 
            !cirugia.getChcierreanest().isEmpty()) {
            Iterator it = (cirugia.getChcierreanest()).iterator();
            while (it.hasNext()) {
                Chcierreanest cierreAnes;
                Chreporte report = new Chreporte();

                cierreAnes = (Chcierreanest)it.next();
                if (cierreAnes != null) {
                    report = new Chreporte();
                    report.setHrecdescripcio("****************************************************************************************************************************************************************");
                    report.setHrectipodescri("Finalizaci�n de Atenci�n Anestesia");
                    report.setHrencodigo(imp_anestesia_cierre);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(cierreAnes.getHcidfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Estado de paciente al egreso del quir�fano: " + 
                                             formatearCampo(cierreAnes.getHcicestadsalir()));
                    report.setHrectipodescri("Finalizaci�n de Atenci�n Anestesia");
                    report.setHrencodigo(imp_anestesia_cierre);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(cierreAnes.getHcidfecregistr());
                    lstReporte.add(report);

                    if (cierreAnes.getHciccomplicaci().equals("S")) {
                        report = new Chreporte();
                        report.setHrecdescripcio("Tiene Complicaciones: " + 
                                                 formatearCampo("Si"));
                        report.setHrectipodescri("Finalizaci�n de Atenci�n Anestesia");
                        report.setHrencodigo(imp_anestesia_cierre);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(cierreAnes.getHcidfecregistr());
                        lstReporte.add(report);

                        report = new Chreporte();
                        report.setHrecdescripcio("Cuales Complicaciones?: " + 
                                                 formatearCampo(cierreAnes.getHcicobsercompl()));
                        report.setHrectipodescri("Finalizaci�n de Atenci�n Anestesia");
                        report.setHrencodigo(imp_anestesia_cierre);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(cierreAnes.getHcidfecregistr());
                        lstReporte.add(report);
                    } else {
                        report = new Chreporte();
                        report.setHrecdescripcio("Tiene Complicaciones: " + 
                                                 formatearCampo("No"));
                        report.setHrectipodescri("Finalizaci�n de Atenci�n Anestesia");
                        report.setHrencodigo(imp_anestesia_cierre);
                        report.setHrentipoimpres(1);
                        report.setHrenconsulta(cirugia.getHcplnumero());
                        report.setHredfecharegis(cierreAnes.getHcidfecregistr());
                        lstReporte.add(report);
                    }

                    report = new Chreporte();
                    report.setHrecdescripcio("Observaciones: " + 
                                             formatearCampo(cierreAnes.getHcicobservacio()));
                    report.setHrectipodescri("Finalizaci�n de Atenci�n Anestesia");
                    report.setHrencodigo(imp_anestesia_cierre);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(cierreAnes.getHcidfecregistr());
                    lstReporte.add(report);
                }
            }
        }
        

        if (lstReporte != null && !lstReporte.isEmpty()) {
            try {
                URL url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
                URL url_super_horizontal = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
                URL url_super_vertical = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                parameters.put("NOMBRE", NOMBRE);
                parameters.put("TIPO_DOCUMENTO", TIPO_DOCUMENTO);
                parameters.put("NOMBRE_PROFESIONAL", NOMBRE_PROFESIONAL);
                parameters.put("NUMERO_DOCUMENTO", NUMERO_DOCUMENTO);
                parameters.put("FECHA_NACIMIENTO", FECHA_NACIMIENTO);
                parameters.put("DIRECCION", DIRECCION);
                parameters.put("OCUPACION", OCUPACION);
                parameters.put("RESPONSABLE", RESPONSABLE);
                parameters.put("EDAD", EDAD);
                parameters.put("TELEFONO", TELEFONO);
                parameters.put("ESTADO_CIVIL", ESTADO_CIVIL);
                parameters.put("PARENTESCO_RESPONSABLE", 
                               PARENTESCO_RESPONSABLE);
                parameters.put("SEXO", SEXO);
                parameters.put("CIUDAD", CIUDAD);
                parameters.put("TELEFONO_RESPONSABLE", TELEFONO_RESPONSABLE);
                parameters.put("IMPRIMIO", IMPRIMIO);
                parameters.put("REGISTRO_MEDICO", REGISTRO_MEDICO);
                parameters.put("EPS", EPS);
                parameters.put("PAGINAS_ANTERIORES", paginas_ant);
                
                
                parameters.put("ZONA", ZONA);
                parameters.put("CONTRATO", CONTRATO);
                parameters.put("ESTRATO", ESTRATO);
                parameters.put("NIVELEDUCATIVO", NIVELEDUCATIVO);
                parameters.put("BARRIO", BARRIO);
                parameters.put("ETNIA", ETNIA);

                JRBeanCollectionDataSource dataSource = 
                    new JRBeanCollectionDataSource(lstReporte);
                File reportFile = 
                    new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/consultarFoliosCirugia.jasper"));

                if (reportFile.exists()) {
                    try {
                        bytes = 
                                JasperRunManager.runReportToPdf(reportFile.getPath(), 
                                                                parameters, 
                                                                dataSource);
                    } catch (JRException ex) {
                        ex.printStackTrace();
                        FacesUtils.addErrorMessage("No pudo generar Anestesia. " + 
                                                   ex.getMessage());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        FacesUtils.addErrorMessage("No pudo generar Anestesia. " + 
                                                   ex.getMessage());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
            }
        }

        return bytes;
    }

    public void setRenderEpicrisis(boolean renderEpicrisis) {
        this.renderEpicrisis = renderEpicrisis;
    }

    public boolean isRenderEpicrisis() {
        return renderEpicrisis;
    }
    
    public boolean consultarProcedimiento(byte[] historia, byte[] colposcopia) throws MalformedURLException {
        Chcirugprogr cirugiaAux = new Chcirugprogr();
        Chusuario usuario = null;
        Cnconsclin consclin = null;


        if (cirugiaAux != null) {
            usuario = consulta.getHcolusuario();
        }
        List<byte[]> pdfs = new ArrayList<byte[]>();
        cirugiaAux.setHcplnumero(consulta.getHcolnumero());
        cirugiaAux.setHcpdfecregistr(consulta.getHcodfecregistr());
        try {
            consclin = 
                    this.serviceLocator.getClinicoService().getConsultaClinicaPorId(cirugiaAux.getHcplnumero().toString());
                       
        } catch (ModelException e) {
            e.printStackTrace();
        }
        pagact_pdf = 0;
        
        if(historia != null){
            pagact_pdf += PDFMerger.paginasTotalPDF(historia);
            pdfs.add(historia);
        }
        
        if(colposcopia  != null){
            pagact_pdf += PDFMerger.paginasTotalPDF(colposcopia);
            pdfs.add(colposcopia);
        }
        
            byte[] ingresoEnfermeria = null;
            ingresoEnfermeria = 
                    generarIngresoEnfermeriaProcedimientos(usuario, consulta, 
                                             pagact_pdf);
            if (ingresoEnfermeria != null) {
                pagact_pdf += 
                        PDFMerger.paginasTotalPDF(ingresoEnfermeria);
                pdfs.add(ingresoEnfermeria);
            }

        byte[] signosVitales = null;
        signosVitales = 
                generarSignosVitales(usuario, cirugiaAux, pagact_pdf, consclin);
        if (signosVitales != null) {
            pagact_pdf += PDFMerger.paginasTotalPDF(signosVitales);
            pdfs.add(signosVitales);
        }

            byte[] notasEnfermeria = null;
            notasEnfermeria = 
                    generarNotasEnfermeria(usuario, cirugiaAux, 
                                           pagact_pdf,consclin);
            if (notasEnfermeria != null) {
                pagact_pdf += 
                        PDFMerger.paginasTotalPDF(notasEnfermeria);
                pdfs.add(notasEnfermeria);
            }

            byte[] canalizacion = null;
            canalizacion = 
                    generarCanalizacionProcedimiento(usuario, cirugiaAux, pagact_pdf);
            if (canalizacion != null) {
                pagact_pdf += PDFMerger.paginasTotalPDF(canalizacion);
                pdfs.add(canalizacion);
            }

            byte[] controlLiquidos = null;
            controlLiquidos = 
                    generarControlLiquidos(usuario, cirugiaAux, 
                                           pagact_pdf,consclin);
            if (controlLiquidos != null) {
                pagact_pdf += 
                        PDFMerger.paginasTotalPDF(controlLiquidos);
                pdfs.add(controlLiquidos);
            }
            
       /* byte[] referenciaPaciente = null;
        referenciaPaciente = 
                generarReferenciaPaciente(usuario, consulta, 
                                       pagact_pdf);
        if (referenciaPaciente != null) {
            pagact_pdf += 
                    PDFMerger.paginasTotalPDF(referenciaPaciente);
            pdfs.add(referenciaPaciente);
        }
        */

        if (pdfs != null && !pdfs.isEmpty()) {
            byte[] resul;
            byte[] result;
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            resul = PDFMerger.concatBytePDFs(pdfs, output);
            result = PDFMerger.adicionarPieTotalPaginas(resul, output);

            PdfServletUtils.showPdfDocument(result, 
                                            "FolioUsuarioCirugia.pdf", 
                                            false);

            generoHistoria = true;
            return generoHistoria;
        } else {
            FacesUtils.addErrorMessage(MSG_NO_REGISTROS_ATENCION);
            generoHistoria = false;
            return generoHistoria;
        }
    }
    
    public byte[] generarIngresoEnfermeriaProcedimientos(Chusuario usuario, 
                                           Chconsulta consulta, 
                                           Integer paginas_ant) {
        byte[] bytes = null;
        List<Chreporte> lstReporte = new ArrayList<Chreporte>();
        Chingresoenf ingreso = new Chingresoenf();
 

        if (usuario != null) {
            if (usuario.getHusdfechanacim() != null) {
                FECHA_NACIMIENTO = usuario.getHusdfechanacim();
                if (FECHA_NACIMIENTO != null) {
                    int edad = calcularEdad(FECHA_NACIMIENTO, consulta.getHcodfecregistr());
                    EDAD = edad;
                }
            }
            if (getUsuarioSystem() != null) {
                IMPRIMIO = this.getUsuarioSystem().getCurcnombre();
            }
            if (usuario.getHuscprimernomb() != null) {
                NOMBRE = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                NOMBRE = NOMBRE + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundapel();
            }
            if (usuario.getHusanumeiden() != null && 
                usuario.getHusanumeiden() != 0) {
                TIPO_DOCUMENTO = usuario.getHusetipoiden();
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }
            if (usuario.getHuscentidadadm() != null) {
                try {
                    EPS = 
    serviceLocator.getClinicoService().getDescripcionEntidadByCodigo(usuario.getHuscentidadadm());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }

            SEXO = usuario.getHusesexo();
            DIRECCION = usuario.getHuscdireccion();
            TELEFONO = usuario.getHusctelefono();
            Integer idCiudad = usuario.getHusnciudad();
            Integer idDepartamento = usuario.getHusndepartamen();
            Cpmunidane ciudadObject = null;
            try {
                ciudadObject = 
                        this.serviceLocator.getClinicoService().getMunicipio(idCiudad, 
                                                                             idDepartamento);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (ciudadObject != null) {
                CIUDAD = ciudadObject.getCmdcnommun();
            }

            Integer ocupacion = usuario.getHusnocupacion();
            try {
                OCUPACION = 
                        serviceLocator.getClinicoService().getDescripcionOcupacion(ocupacion);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            ESTADO_CIVIL = usuario.getHuseestadcivil();
            RESPONSABLE = usuario.getHuscnomresponsa();
            PARENTESCO_RESPONSABLE = usuario.getHuscparresponsa();
            TELEFONO_RESPONSABLE = usuario.getHusctelresponsa();
            ZONA = formatearCampoZona(usuario.getHusezonareside());
            ESTRATO = usuario.getHusnestrato();
            NIVELEDUCATIVO = formatearCampoNivelEducativo(usuario.getHusnniveledu());
            ETNIA = formatearCampoEtnia(usuario.getHuscetnia());
            BARRIO = usuario.getHuscbarrio();
            
        }
        try{
        ingreso = 
                this.serviceLocator.getClinicoService().getIngresoEnfermeriaProcedimiento(consulta.getHcolnumero());
        } catch (ModelException e) {
            e.printStackTrace();
        }

                if (ingreso != null) {
                    Chreporte report = new Chreporte();

                    report = new Chreporte();
                    report.setHrecdescripcio("****************************************************************************************************************************************************************");
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Hora de la actividad: " + 
                                             formatearCampoHoraSimple(ingreso.getHiedfecregistr()));
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Usuario que realiza la actividad: " + 
                                             obtenerUsuario(ingreso.getHiecoperador()));
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("El usuario confirma el procedimiento? " + 
                                             formatearCampo(ingreso.getHiecconfiproce()));
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Verifica que el/los consentimiento/s informado/s esten diligenciado/s? " + 
                                             formatearCampo(ingreso.getHiecconsinfor()));
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Confirma antecedentes patol�gicos? " + 
                                             formatearCampo(ingreso.getHiecantepatol()));
                    if (ingreso.getHieccualpatol() != null) {
                        report.setHrecdescripcio2("Cuales: " + 
                                                  formatearCampo(ingreso.getHieccualpatol()));
                    } else {
                        report.setHrecdescripcio2("");
                    }
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Confirma antecedentes toxicoal�rgicos? " + 
                                             formatearCampo(ingreso.getHiecantetoxic()));
                    if (ingreso.getHieccualtoxic() != null) {
                        report.setHrecdescripcio2("Cuales: " + 
                                                  formatearCampo(ingreso.getHieccualtoxic()));
                    } else {
                        report.setHrecdescripcio2("");
                    }
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Esta tomando en la actualidad alg�n medicamento? " + 
                                             formatearCampo(ingreso.getHiecpremedicac()));
                    if (ingreso.getHieccualpremed() != null) {
                        report.setHrecdescripcio2("Cuales: " + 
                                                  formatearCampo(ingreso.getHieccualpremed()));
                    } else {
                        report.setHrecdescripcio2("");
                    }
                    if (ingreso.getHienhoraspreme() != null) {
                        report.setHrecdescripcio3("Hace cuantas HORAS lo tomo?  " + 
                                                  formatearCampo(ingreso.getHieccualpremed()));
                    } else {
                        report.setHrecdescripcio3("");
                    }
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Se retira, maquillaje, protesis removible, lentes de contacto, anteojos, joyas u objetos de valor? " + 
                                             formatearCampo(ingreso.getHiecobjetvalor()));
                    if (ingreso.getHiecobjetvalor() != null && 
                        ingreso.getHiecobjetvalor().equals("S")) {
                        String wcargo = "";
                        if (ingreso.getHiecentreobjec() != null && 
                            ingreso.getHiecentreobjec().equals("1"))
                            wcargo = "Se entrega a familiar";
                        if (ingreso.getHiecentreobjec() != null && 
                            ingreso.getHiecentreobjec().equals("2"))
                            wcargo = 
                                    "La deja con sus cosas personales en custodia del centro";
                        report.setHrecdescripcio2("a cargo de? " + 
                                                  formatearCampo(wcargo));
                    } else {
                        report.setHrecdescripcio2("");
                        report.setHrecdescripcio3("");
                        report.setHrecdescripcio4("");
                    }
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Autoriza ser contactada telef�nicamente despu�s del procedimiento para verificar su evoluci�n?    " + 
                                             formatearCampo(ingreso.getHiecautocntel()));
                    report.setHrencodigo(imp_ingreso_enfermeria);
                    report.setHrectipodescri("Ingreso Enfermer�a");
                    report.setHrentipoimpres(2);
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(ingreso.getHiedfecregistr());
                    lstReporte.add(report);  

            try {
                URL url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
                URL url_super_horizontal = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
                URL url_super_vertical = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                parameters.put("NOMBRE", NOMBRE);
                parameters.put("TIPO_DOCUMENTO", TIPO_DOCUMENTO);
                parameters.put("NOMBRE_PROFESIONAL", NOMBRE_PROFESIONAL);
                parameters.put("NUMERO_DOCUMENTO", NUMERO_DOCUMENTO);
                parameters.put("FECHA_NACIMIENTO", FECHA_NACIMIENTO);
                parameters.put("DIRECCION", DIRECCION);
                parameters.put("OCUPACION", OCUPACION);
                parameters.put("RESPONSABLE", RESPONSABLE);
                parameters.put("EDAD", EDAD);
                parameters.put("TELEFONO", TELEFONO);
                parameters.put("ESTADO_CIVIL", ESTADO_CIVIL);
                parameters.put("PARENTESCO_RESPONSABLE", 
                               PARENTESCO_RESPONSABLE);
                parameters.put("SEXO", SEXO);
                parameters.put("CIUDAD", CIUDAD);
                parameters.put("TELEFONO_RESPONSABLE", TELEFONO_RESPONSABLE);
                parameters.put("IMPRIMIO", IMPRIMIO);
                parameters.put("REGISTRO_MEDICO", REGISTRO_MEDICO);
                parameters.put("EPS", EPS);
                parameters.put("PAGINAS_ANTERIORES", paginas_ant);
                

                                
                parameters.put("ZONA", ZONA);
                parameters.put("CONTRATO", CONTRATO);
                parameters.put("ESTRATO", ESTRATO);
                parameters.put("NIVELEDUCATIVO", NIVELEDUCATIVO);
                parameters.put("BARRIO", BARRIO);
                
                parameters.put("ETNIA", ETNIA);

                JRBeanCollectionDataSource dataSource = 
                    new JRBeanCollectionDataSource(lstReporte);
                File reportFile = 
                    new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/consultarFoliosCirugia.jasper"));
                if (reportFile.exists()) {
                    try {
                        bytes = 
                                JasperRunManager.runReportToPdf(reportFile.getPath(), 
                                                                parameters, 
                                                                dataSource);
                    } catch (JRException ex) {
                        ex.printStackTrace();
                        FacesUtils.addErrorMessage("No pudo generar Ingreso enfermeria. " + 
                                                   ex.getMessage());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        FacesUtils.addErrorMessage("No pudo generar Ingreso enfermeria. " + 
                                                   ex.getMessage());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
            }
        }
        return bytes;
    }
    
    public byte[] consultarRegistrosEnfermeria() throws MalformedURLException {
        Chcirugprogr cirugiaAux = new Chcirugprogr();
        Chusuario usuario = null;
        Cnconsclin consclin = null;


        if (cirugiaAux != null) {
            usuario = consulta.getHcolusuario();
        }
        List<byte[]> pdfs = new ArrayList<byte[]>();
        cirugiaAux.setHcplnumero(consulta.getHcolnumero());
        cirugiaAux.setHcpdfecregistr(consulta.getHcodfecregistr());
        try {
            consclin = 
                    this.serviceLocator.getClinicoService().getConsultaClinicaPorId(cirugiaAux.getHcplnumero().toString());
                       
        } catch (ModelException e) {
            e.printStackTrace();
        }
        pagact_pdf = 0;
        
            byte[] ingresoEnfermeria = null;
            ingresoEnfermeria = 
                    generarIngresoEnfermeriaProcedimientos(usuario, consulta, 
                                             pagact_pdf);
            if (ingresoEnfermeria != null) {
                pagact_pdf += 
                        PDFMerger.paginasTotalPDF(ingresoEnfermeria);
                pdfs.add(ingresoEnfermeria);
            }

        byte[] signosVitales = null;
        signosVitales = 
                generarSignosVitales(usuario, cirugiaAux, pagact_pdf, consclin);
        if (signosVitales != null) {
            pagact_pdf += PDFMerger.paginasTotalPDF(signosVitales);
            pdfs.add(signosVitales);
        }

            byte[] notasEnfermeria = null;
            notasEnfermeria = 
                    generarNotasEnfermeria(usuario, cirugiaAux, 
                                           pagact_pdf,consclin);
            if (notasEnfermeria != null) {
                pagact_pdf += 
                        PDFMerger.paginasTotalPDF(notasEnfermeria);
                pdfs.add(notasEnfermeria);
            }

            byte[] canalizacion = null;
            canalizacion = 
                    generarCanalizacion(usuario, cirugiaAux, pagact_pdf);
            if (canalizacion != null) {
                pagact_pdf += PDFMerger.paginasTotalPDF(canalizacion);
                pdfs.add(canalizacion);
            }

            byte[] controlLiquidos = null;
            controlLiquidos = 
                    generarControlLiquidos(usuario, cirugiaAux, 
                                           pagact_pdf,consclin);
            if (controlLiquidos != null) {
                pagact_pdf += 
                        PDFMerger.paginasTotalPDF(controlLiquidos);
                pdfs.add(controlLiquidos);
            }

        if (pdfs != null && !pdfs.isEmpty()) {
            byte[] resul;
            byte[] result;
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            resul = PDFMerger.concatBytePDFs(pdfs, output);
            result = PDFMerger.adicionarPieTotalPaginas(resul, output);

            /*PdfServletUtils.showPdfDocument(result, 
                                            "FolioUsuarioCirugia.pdf", 
                                            false);
                                            */

            return result;
        } else {
            return null;
        }
    }
    
    public byte[] generarCanalizacionProcedimiento(Chusuario usuario, Chcirugprogr cirugia, 
                                      Integer paginas_ant) {
        byte[] bytes = null;
        List<Chreporte> lstReporte = new ArrayList<Chreporte>();
        List<Chnotaenferm> notasUsuario = null;
        List<Chcanalivena> canalivena = null;
        

        if (usuario != null) {
            if (usuario.getHusdfechanacim() != null) {
                FECHA_NACIMIENTO = usuario.getHusdfechanacim();
                if (FECHA_NACIMIENTO != null) {
                    int edad = calcularEdad(FECHA_NACIMIENTO, cirugia.getHcpdfecregistr());
                    EDAD = edad;
                }
            }
            if (getUsuarioSystem() != null) {
                IMPRIMIO = this.getUsuarioSystem().getCurcnombre();
            }
            if (usuario.getHuscprimernomb() != null) {
                NOMBRE = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundnomb() + " ";
            }
            ZONA = formatearCampoZona(usuario.getHusezonareside());
            ESTRATO = usuario.getHusnestrato();
            NIVELEDUCATIVO = formatearCampoNivelEducativo(usuario.getHusnniveledu());
            BARRIO = usuario.getHuscbarrio();
            ETNIA = formatearCampoEtnia(usuario.getHuscetnia());
            
            
            if (usuario.getHuscprimerapel() != null) {
                NOMBRE = NOMBRE + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundapel();
            }
            if (usuario.getHusanumeiden() != null && 
                usuario.getHusanumeiden() != 0) {
                TIPO_DOCUMENTO = usuario.getHusetipoiden();
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }
            if (usuario.getHuscentidadadm() != null) {
                try {
                    EPS = 
    serviceLocator.getClinicoService().getDescripcionEntidadByCodigo(usuario.getHuscentidadadm());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }

            SEXO = usuario.getHusesexo();
            DIRECCION = usuario.getHuscdireccion();
            TELEFONO = usuario.getHusctelefono();
            Integer idCiudad = usuario.getHusnciudad();
            Integer idDepartamento = usuario.getHusndepartamen();
            Cpmunidane ciudadObject = null;
            try {
                ciudadObject = 
                        this.serviceLocator.getClinicoService().getMunicipio(idCiudad, 
                                                                             idDepartamento);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (ciudadObject != null) {
                CIUDAD = ciudadObject.getCmdcnommun();
            }

            Integer ocupacion = usuario.getHusnocupacion();
            try {
                OCUPACION = 
                        serviceLocator.getClinicoService().getDescripcionOcupacion(ocupacion);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            ESTADO_CIVIL = usuario.getHuseestadcivil();
            RESPONSABLE = usuario.getHuscnomresponsa();
            PARENTESCO_RESPONSABLE = usuario.getHuscparresponsa();
            TELEFONO_RESPONSABLE = usuario.getHusctelresponsa();
            ZONA = formatearCampoZona(usuario.getHusezonareside());
            
            ESTRATO = usuario.getHusnestrato();
            NIVELEDUCATIVO = formatearCampoNivelEducativo(usuario.getHusnniveledu());
            BARRIO = usuario.getHuscbarrio();
            ETNIA = formatearCampoEtnia(usuario.getHuscetnia());
            
        }

        try {
            notasUsuario = 
                    this.serviceLocator.getCirugiaService().getNotasEnfermeriaIngreso(cirugia.getHcplnumero());
            canalivena = 
                    this.serviceLocator.getCirugiaService().getLstVenaCanalizada(cirugia.getHcplnumero(),IConstantes.TIPO_HOSPITALIZACION);         
                             
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (canalivena != null && 
            !canalivena.isEmpty()) {
            Iterator it = (canalivena).iterator();
            while (it.hasNext()) {

                Chcanalivena canalizacion;
                canalizacion = null;

                canalizacion = (Chcanalivena)it.next();
                Chreporte report = new Chreporte();

                report = new Chreporte();
                report.setHrecdescripcio("****************************************************************************************************************************************************************");
                report.setHrectipodescri("Canalizaci�n Vena");
                report.setHrencodigo(imp_canalizacion);
                report.setHrentipoimpres(1);
                report.setHrenconsulta(cirugia.getHcplnumero());
                report.setHredfecharegis(canalizacion.getHcvdfecregistr());
                lstReporte.add(report);

                report = new Chreporte();
                report.setHrecdescripcio("Hora de la actividad: " + 
                                         formatearCampoHoraSimple(canalizacion.getHcvdfecregistr()));
                report.setHrencodigo(imp_canalizacion);
                report.setHrectipodescri("Canalizaci�n Vena");
                report.setHrentipoimpres(1);
                report.setHrenconsulta(cirugia.getHcplnumero());
                report.setHredfecharegis(canalizacion.getHcvdfecregistr());
                lstReporte.add(report);

                report = new Chreporte();
                report.setHrecdescripcio("Usuario que realiza la actividad: " + 
                                         obtenerUsuario(canalizacion.getHcvcoperador()));
                report.setHrencodigo(imp_canalizacion);
                report.setHrectipodescri("Canalizaci�n Vena");
                report.setHrentipoimpres(1);
                report.setHrenconsulta(cirugia.getHcplnumero());
                report.setHredfecharegis(canalizacion.getHcvdfecregistr());
                lstReporte.add(report);

                report = new Chreporte();
                report.setHrecdescripcio("Asepsia y antisepsia zona a canalizar: " + 
                                         formatearCampo(canalizacion.getHcveasepsia()));
                report.setHrecdescripcio2("Miembro Superior: " + 
                                          obtenerMiembroSuperior(canalizacion.getHcvcmiembsuper()));
                report.setHrecdescripcio3("Localizaci�n: " + 
                                          obtenerLocalizacion(canalizacion.getHcvczonacanali()));
                report.setHrencodigo(imp_canalizacion);
                report.setHrectipodescri("Canalizaci�n Vena");
                report.setHrentipoimpres(5);
                report.setHrenconsulta(cirugia.getHcplnumero());
                report.setHredfecharegis(canalizacion.getHcvdfecregistr());
                lstReporte.add(report);

                report = new Chreporte();
                report.setHrecdescripcio("Tipo de Cateter: " + 
                                         obtenerTipoCateter(canalizacion.getHcvctipocatete()));
                if (canalizacion.getHcvncalibre() != null) {
                    report.setHrecdescripcio2("Calibre (G) " + 
                                              formatearCampo(canalizacion.getHcvncalibre()));
                } else {
                    report.setHrecdescripcio2("");
                }
                
                if(canalizacion.getHcvnnumerinten() != null){
                    report.setHrecdescripcio3("N�mero de intentos de venopunci�n: " +
                     formatearCampo(canalizacion.getHcvnnumerinten()));
                     
                }else{
                    report.setHrecdescripcio3(" ");    
                }

                
                report.setHrencodigo(imp_canalizacion);
                report.setHrectipodescri("Canalizaci�n Vena");
                report.setHrentipoimpres(5);
                report.setHrenconsulta(cirugia.getHcplnumero());
                report.setHredfecharegis(canalizacion.getHcvdfecregistr());
                lstReporte.add(report);
            }
            
            }
            
        if (notasUsuario != null && 
            !notasUsuario.isEmpty()) {
            Iterator it = (notasUsuario).iterator();
            while (it.hasNext()) {

                Chnotaenferm nota;
                nota = null;

                nota = (Chnotaenferm)it.next();
                Chreporte report = new Chreporte();

                if(nota.getHnecrefiedolor() != null && !nota.getHnecrefiedolor().equals("") ){
                
                    report = new Chreporte();
                    report.setHrecdescripcio("Hora de la actividad: " + 
                                             formatearCampoHoraSimple(nota.getHnedfecregistr()));
                    report.setHrencodigo(imp_escaladolor);
                    report.setHrectipodescri("Escala del Dolor");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(nota.getHnedfecregistr());
                    lstReporte.add(report);

                    report = new Chreporte();
                    report.setHrecdescripcio("Usuario que realiza la actividad: " + 
                                             obtenerUsuario(nota.getHnecoperador()));
                    report.setHrencodigo(imp_escaladolor);
                    report.setHrectipodescri("Escala del Dolor");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(nota.getHnedfecregistr());
                    lstReporte.add(report);
                    
                    
                    report = new Chreporte();
                    report.setHrecdescripcio("****************************************************************************************************************************************************************");
                    report.setHrectipodescri("Escala del Dolor");
                    report.setHrencodigo(imp_escaladolor);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(nota.getHnedfecregistr());
                    lstReporte.add(report);
                    
                    report = new Chreporte();
                    report.setHrecdescripcio("Refiere dolor     : " + 
                                             formatearCampo(nota.getHnecrefiedolor()));
                    report.setHrencodigo(imp_escaladolor);
                    report.setHrectipodescri("Escala del Dolor");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(nota.getHnedfecregistr());
                    lstReporte.add(report);
                    
                    report = new Chreporte();
                    report.setHrecdescripcio("Escala de Dolor durante el procedimiento: " + 
                                             formatearCampo(nota.getHnenescaladolo()));
                    report.setHrencodigo(imp_escaladolor);
                    report.setHrectipodescri("Escala del Dolor");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(nota.getHnedfecregistr());
                    if(nota.getHnecrefiedolor().equals("S")){
                        lstReporte.add(report);    
                    }
                    
                    
                    
                    report = new Chreporte();
                    report.setHrectipodescri("Escala del Dolor");
                    report.setHrecdescripcio("Duraci�n del dolor Intenso         " + (formatearCampo(nota.getHnenduradolor())+ " " + formatearCampoTipoDuracion(nota.getHnecdudointen())));
                    report.setHrencodigo(imp_escaladolor);
                    report.setHrectipodescri("Escala del Dolor");
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(nota.getHnedfecregistr());
                    if(nota.getHnecrefiedolor().equals("S")){
                        lstReporte.add(report);    
                    }
                           
                    
                }
               

                

          
            }
            
            }

            if((notasUsuario != null && 
            !notasUsuario.isEmpty()) || (canalivena != null && 
            !canalivena.isEmpty()) ){
                try {
                    URL url_profamilia = 
                        FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
                    URL url_super_horizontal = 
                        FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
                    URL url_super_vertical = 
                        FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
                    Map parameters = new HashMap();
                    parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                    parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                    parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                    parameters.put("NOMBRE", NOMBRE);
                    parameters.put("TIPO_DOCUMENTO", TIPO_DOCUMENTO);
                    parameters.put("NOMBRE_PROFESIONAL", NOMBRE_PROFESIONAL);
                    parameters.put("NUMERO_DOCUMENTO", NUMERO_DOCUMENTO);
                    parameters.put("FECHA_NACIMIENTO", FECHA_NACIMIENTO);
                    parameters.put("DIRECCION", DIRECCION);
                    parameters.put("OCUPACION", OCUPACION);
                    parameters.put("RESPONSABLE", RESPONSABLE);
                    parameters.put("EDAD", EDAD);
                    parameters.put("TELEFONO", TELEFONO);
                    parameters.put("ESTADO_CIVIL", ESTADO_CIVIL);
                    parameters.put("PARENTESCO_RESPONSABLE", 
                                   PARENTESCO_RESPONSABLE);
                    parameters.put("SEXO", SEXO);
                    parameters.put("CIUDAD", CIUDAD);
                    parameters.put("TELEFONO_RESPONSABLE", TELEFONO_RESPONSABLE);
                    parameters.put("IMPRIMIO", IMPRIMIO);
                    parameters.put("REGISTRO_MEDICO", REGISTRO_MEDICO);
                    parameters.put("EPS", EPS);
                    parameters.put("PAGINAS_ANTERIORES", paginas_ant);
                    
                    parameters.put("ZONA", ZONA);
                    parameters.put("CONTRATO", CONTRATO);
                    parameters.put("ESTRATO", ESTRATO);
                    parameters.put("NIVELEDUCATIVO", NIVELEDUCATIVO);
                    parameters.put("BARRIO", BARRIO);
                    parameters.put("ETNIA", ETNIA);

                    JRBeanCollectionDataSource dataSource = 
                        new JRBeanCollectionDataSource(lstReporte);
                    File reportFile = 
                        new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/consultarFoliosCirugia.jasper"));

                    if (reportFile.exists()) {
                        try {
                            bytes = 
                                    JasperRunManager.runReportToPdf(reportFile.getPath(), 
                                                                    parameters, 
                                                                    dataSource);
                        } catch (JRException ex) {
                            ex.printStackTrace();
                            FacesUtils.addErrorMessage("No pudo generar Canalizaci�n. " + 
                                                       ex.getMessage());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            FacesUtils.addErrorMessage("No pudo generar Canalizaci�n. " + 
                                                       ex.getMessage());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                               e.getMessage());
                }
            }

    
        
        return bytes;
    }

    public byte[] generarEscalaValoracionCaidas(Chusuario usuario, 
                                                Chcirugprogr cirugia, 
                                                Integer paginas_ant) {

        byte[] bytes = null;
        List<Chreporte> lstReporte = new ArrayList<Chreporte>();

        if (usuario != null) {
            if (usuario.getHusdfechanacim() != null) {
                FECHA_NACIMIENTO = usuario.getHusdfechanacim();
                if (FECHA_NACIMIENTO != null) {
                    int edad = 
                        calcularEdad(FECHA_NACIMIENTO, cirugia.getHcpdfecregistr());
                    EDAD = edad;
                }
            }
            if (getUsuarioSystem() != null) {
                IMPRIMIO = this.getUsuarioSystem().getCurcnombre();
            }
            if (usuario.getHuscprimernomb() != null) {
                NOMBRE = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundnomb() + " ";
            }
            ZONA = formatearCampoZona(usuario.getHusezonareside());
            ESTRATO = usuario.getHusnestrato();
            NIVELEDUCATIVO = 
                    formatearCampoNivelEducativo(usuario.getHusnniveledu());
            BARRIO = usuario.getHuscbarrio();
            ETNIA = formatearCampoEtnia(usuario.getHuscetnia());


            if (usuario.getHuscprimerapel() != null) {
                NOMBRE = NOMBRE + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundapel();
            }
            if (usuario.getHusanumeiden() != null && 
                usuario.getHusanumeiden() != 0) {
                TIPO_DOCUMENTO = usuario.getHusetipoiden();
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }
            if (usuario.getHuscentidadadm() != null) {
                try {
                    EPS = 
serviceLocator.getClinicoService().getDescripcionEntidadByCodigo(usuario.getHuscentidadadm());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }

            SEXO = usuario.getHusesexo();
            DIRECCION = usuario.getHuscdireccion();
            TELEFONO = usuario.getHusctelefono();
            Integer idCiudad = usuario.getHusnciudad();
            Integer idDepartamento = usuario.getHusndepartamen();
            Cpmunidane ciudadObject = null;
            try {
                ciudadObject = 
                        this.serviceLocator.getClinicoService().getMunicipio(idCiudad, 
                                                                             idDepartamento);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (ciudadObject != null) {
                CIUDAD = ciudadObject.getCmdcnommun();
            }

            Integer ocupacion = usuario.getHusnocupacion();
            try {
                OCUPACION = 
                        serviceLocator.getClinicoService().getDescripcionOcupacion(ocupacion);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            ESTADO_CIVIL = usuario.getHuseestadcivil();
            RESPONSABLE = usuario.getHuscnomresponsa();
            PARENTESCO_RESPONSABLE = usuario.getHuscparresponsa();
            TELEFONO_RESPONSABLE = usuario.getHusctelresponsa();
            ZONA = formatearCampoZona(usuario.getHusezonareside());

            ESTRATO = usuario.getHusnestrato();
            NIVELEDUCATIVO = 
                    formatearCampoNivelEducativo(usuario.getHusnniveledu());
            BARRIO = usuario.getHuscbarrio();
            ETNIA = formatearCampoEtnia(usuario.getHuscetnia());

        }
        




        if (cirugia.getChescvalcai() != null && 
            !cirugia.getChescvalcai().isEmpty()) {

            String caidasPreviasSeleccionados;

            String medicamentosSeleccionados;

            String deficitSensorialSeleccionados;

            String estadoMentalSeleccionados;

            String deambulacionSeleccionados;
            
            Iterator it = cirugia.getChescvalcai().iterator();
            while (it.hasNext()) {
                Chescvalcai escalaValoracionCaidas = null;
                escalaValoracionCaidas = (Chescvalcai)it.next();
                Chreporte report = new Chreporte();

                if (escalaValoracionCaidas != null) {

                    caidasPreviasSeleccionados = "";

                    medicamentosSeleccionados = "";

                    deficitSensorialSeleccionados = "";

                    estadoMentalSeleccionados = "";

                    deambulacionSeleccionados = "";
                    
                    report = new Chreporte();
                    report.setHrecdescripcio("Fecha: " + 
                                             formatearCampoHora(escalaValoracionCaidas.getHevcdfecregistr()));
                    report.setHrectipodescri("Escala de Valoraci�n de Caidas");
                    report.setHrencodigo(imp_escala_valoracion_caidas);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(cirugia.getHcpdfecregistr());
                    lstReporte.add(report);
                    
                    report = new Chreporte();
                    report.setHrecdescripcio("Usuario Registro: " + 
                                             formatearCampo(escalaValoracionCaidas.getHevccoperador()));
                    report.setHrectipodescri("Escala de Valoraci�n de Caidas");
                    report.setHrencodigo(imp_escala_valoracion_caidas);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(cirugia.getHcpdfecregistr());
                    lstReporte.add(report);
                    
                    if (escalaValoracionCaidas.getHevccaidprev() != null) {
                        if ("S".equals(escalaValoracionCaidas.getHevccaidprev())) {
                            caidasPreviasSeleccionados = "Si";
                        } else if ("N".equals(escalaValoracionCaidas.getHevccaidprev())) {
                            caidasPreviasSeleccionados = "No";
                        }

                        if (!"".equals(caidasPreviasSeleccionados)) {
                            report = new Chreporte();
                            report.setHrecdescripcio("Caidas Previas: " + 
                                                     formatearCampo(caidasPreviasSeleccionados));
                            report.setHrectipodescri("Escala de Valoraci�n de Caidas");
                            report.setHrencodigo(imp_escala_valoracion_caidas);
                            report.setHrentipoimpres(1);
                            report.setHrenconsulta(cirugia.getHcplnumero());
                            report.setHredfecharegis(cirugia.getHcpdfecregistr());
                            lstReporte.add(report);
                        }
                    }


                    if (escalaValoracionCaidas.getHevccmedicamen() != null) {

                        StringTokenizer st = 
                            new StringTokenizer(escalaValoracionCaidas.getHevccmedicamen(), 
                                                ",");
                        while (st.hasMoreTokens()) {
                            String medicamento = st.nextToken();

                            if (medicamento.equals("NI")) {
                                medicamentosSeleccionados = 
                                        medicamentosSeleccionados + "Ninguno,";
                            }
                            if (medicamento.equals("DI")) {
                                medicamentosSeleccionados = 
                                        medicamentosSeleccionados + 
                                        "Diur�ticos,";
                            }
                            if (medicamento.equals("AN")) {
                                medicamentosSeleccionados = 
                                        medicamentosSeleccionados + 
                                        "Antiparkinsonianos,";
                            }
                            if (medicamento.equals("TS")) {
                                medicamentosSeleccionados = 
                                        medicamentosSeleccionados + 
                                        "Tranquilizantes, sedantes,";
                            }
                            if (medicamento.equals("HND")) {
                                medicamentosSeleccionados = 
                                        medicamentosSeleccionados + 
                                        "Hipotensores no diur�ticos,";
                            }
                            if (medicamento.equals("AD")) {
                                medicamentosSeleccionados = 
                                        medicamentosSeleccionados + 
                                        "Antidepresivos,";
                            }
                            if (medicamento.equals("AO")) {
                                medicamentosSeleccionados = 
                                        medicamentosSeleccionados + 
                                        "Analg�sicos Opioides,";
                            }
                        }
                        if (!"".equals(medicamentosSeleccionados)) {
                            report = new Chreporte();
                            report.setHrecdescripcio("Medicamentos: " + 
                                                     formatearCampo(medicamentosSeleccionados.substring(0, 
                                                                                                        (medicamentosSeleccionados.length() - 
                                                                                                         1))));
                            report.setHrectipodescri("Escala de Valoraci�n de Caidas");
                            report.setHrencodigo(imp_escala_valoracion_caidas);
                            report.setHrentipoimpres(1);
                            report.setHrenconsulta(cirugia.getHcplnumero());
                            report.setHredfecharegis(cirugia.getHcpdfecregistr());
                            lstReporte.add(report);
                        }
                    }

                    if (escalaValoracionCaidas.getHevccdefisens() != null) {

                        StringTokenizer st = 
                            new StringTokenizer(escalaValoracionCaidas.getHevccdefisens(), 
                                                ",");
                        while (st.hasMoreTokens()) {
                            String medicamento = st.nextToken();

                            if (medicamento.equals("NI")) {
                                deficitSensorialSeleccionados = 
                                        deficitSensorialSeleccionados + 
                                        "Ninguno,";
                            }
                            if (medicamento.equals("AV")) {
                                deficitSensorialSeleccionados = 
                                        deficitSensorialSeleccionados + 
                                        "Alteraciones visuales,";
                            }
                            if (medicamento.equals("AA")) {
                                deficitSensorialSeleccionados = 
                                        deficitSensorialSeleccionados + 
                                        "Alteraciones auditivas,";
                            }
                            if (medicamento.equals("DM")) {
                                deficitSensorialSeleccionados = 
                                        deficitSensorialSeleccionados + 
                                        "D�ficit de miembros,";
                            }
                        }

                        if (!"".equals(deficitSensorialSeleccionados)) {
                            report = new Chreporte();
                            report.setHrecdescripcio("D�ficit sensorial: " + 
                                                     formatearCampo(deficitSensorialSeleccionados.substring(0, 
                                                                                                            (deficitSensorialSeleccionados.length() - 
                                                                                                             1))));
                            report.setHrectipodescri("Escala de Valoraci�n de Caidas");
                            report.setHrencodigo(imp_escala_valoracion_caidas);
                            report.setHrentipoimpres(1);
                            report.setHrenconsulta(cirugia.getHcplnumero());
                            report.setHredfecharegis(cirugia.getHcpdfecregistr());
                            lstReporte.add(report);
                        }
                    }

                    if (escalaValoracionCaidas.getHevccestament() != null) {

                        if ("OR".equals(escalaValoracionCaidas.getHevccestament())) {
                            estadoMentalSeleccionados = "Orientado";
                        } else if ("CO".equals(escalaValoracionCaidas.getHevccestament())) {
                            estadoMentalSeleccionados = "Confuso";
                        }
                        if (!"".equals(estadoMentalSeleccionados)) {
                            report = new Chreporte();
                            report.setHrecdescripcio("Estado Mental: " + 
                                                     formatearCampo(estadoMentalSeleccionados));
                            report.setHrectipodescri("Escala de Valoraci�n de Caidas");
                            report.setHrencodigo(imp_escala_valoracion_caidas);
                            report.setHrentipoimpres(1);
                            report.setHrenconsulta(cirugia.getHcplnumero());
                            report.setHredfecharegis(cirugia.getHcpdfecregistr());
                            lstReporte.add(report);
                        }
                    }

                    if (escalaValoracionCaidas.getHevccdeambula() != null) {

                        StringTokenizer st = 
                            new StringTokenizer(escalaValoracionCaidas.getHevccdeambula(), 
                                                ",");
                        while (st.hasMoreTokens()) {
                            String deambulacion = st.nextToken();

                            if (deambulacion.equals("NO")) {
                                deambulacionSeleccionados = 
                                        deambulacionSeleccionados + "Normal,";
                            }
                            if (deambulacion.equals("SSA")) {
                                deambulacionSeleccionados = 
                                        deambulacionSeleccionados + 
                                        "Segura sin ayuda,";
                            }
                            if (deambulacion.equals("AEA")) {
                                deambulacionSeleccionados = 
                                        deambulacionSeleccionados + 
                                        "Asistida con elementos de apoyo,";
                            }
                            if (deambulacion.equals("RAI")) {
                                deambulacionSeleccionados = 
                                        deambulacionSeleccionados + 
                                        "Reposo absoluto o imposible,";
                            }
                        }

                        if (!"".equals(deambulacionSeleccionados)) {
                            report = new Chreporte();
                            report.setHrecdescripcio2("Deambulaci�n: " + 
                                                      formatearCampo(deambulacionSeleccionados.substring(0, 
                                                                                                         (deambulacionSeleccionados.length() - 
                                                                                                          1))));
                            report.setHrectipodescri("Escala de Valoraci�n de Caidas");
                            report.setHrencodigo(imp_escala_valoracion_caidas);
                            report.setHrentipoimpres(1);
                            report.setHrenconsulta(cirugia.getHcplnumero());
                            report.setHredfecharegis(cirugia.getHcpdfecregistr());
                            lstReporte.add(report);
                        }
                    }
                    
                    report = new Chreporte();
                    report.setHrecdescripcio("Puntos: " + 
                                             formatearCampo(escalaValoracionCaidas.getHevccpuntos()));
                    report.setHrectipodescri("Escala de Valoraci�n de Caidas");
                    report.setHrencodigo(imp_escala_valoracion_caidas);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(cirugia.getHcpdfecregistr());
                    lstReporte.add(report);
                    
                    report = new Chreporte();
                    report.setHrecdescripcio("****************************************************************************************************************************************************************");
                    report.setHrectipodescri("Escala de Valoraci�n de Caidas");
                    report.setHrencodigo(imp_escala_valoracion_caidas);
                    report.setHrentipoimpres(1);
                    report.setHrenconsulta(cirugia.getHcplnumero());
                    report.setHredfecharegis(cirugia.getHcpdfecregistr());
                    lstReporte.add(report);

                }
            }
     
            try {
                URL url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_NEW);
                URL url_super_horizontal = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
                URL url_super_vertical = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                parameters.put("NOMBRE", NOMBRE);
                parameters.put("TIPO_DOCUMENTO", TIPO_DOCUMENTO);
                parameters.put("NOMBRE_PROFESIONAL", NOMBRE_PROFESIONAL);
                parameters.put("NUMERO_DOCUMENTO", NUMERO_DOCUMENTO);
                parameters.put("FECHA_NACIMIENTO", FECHA_NACIMIENTO);
                parameters.put("DIRECCION", DIRECCION);
                parameters.put("OCUPACION", OCUPACION);
                parameters.put("RESPONSABLE", RESPONSABLE);
                parameters.put("EDAD", EDAD);
                parameters.put("TELEFONO", TELEFONO);
                parameters.put("ESTADO_CIVIL", ESTADO_CIVIL);
                parameters.put("PARENTESCO_RESPONSABLE", 
                               PARENTESCO_RESPONSABLE);
                parameters.put("SEXO", SEXO);
                parameters.put("CIUDAD", CIUDAD);
                parameters.put("TELEFONO_RESPONSABLE", TELEFONO_RESPONSABLE);
                parameters.put("IMPRIMIO", IMPRIMIO);
                parameters.put("REGISTRO_MEDICO", REGISTRO_MEDICO);
                parameters.put("EPS", EPS);
                parameters.put("PAGINAS_ANTERIORES", paginas_ant);
                
                parameters.put("ZONA", ZONA);
                parameters.put("CONTRATO", CONTRATO);
                parameters.put("ESTRATO", ESTRATO);
                parameters.put("NIVELEDUCATIVO", NIVELEDUCATIVO);
                parameters.put("BARRIO", BARRIO);
                parameters.put("ETNIA", ETNIA);

                JRBeanCollectionDataSource dataSource = 
                    new JRBeanCollectionDataSource(lstReporte);
                File reportFile = 
                    new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/consultarFoliosCirugia.jasper"));

                if (reportFile.exists()) {
                    try {
                        bytes = 
                                JasperRunManager.runReportToPdf(reportFile.getPath(), 
                                                                parameters, 
                                                                dataSource);
                    } catch (JRException ex) {
                        ex.printStackTrace();
                        FacesUtils.addErrorMessage("No pudo generar Escala de Valoracion Caidas. " + 
                                                   ex.getMessage());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        FacesUtils.addErrorMessage("No pudo generar Escala de Valoracion Caidas. " + 
                                                   ex.getMessage());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
            }
        }
        
        return bytes;


    }

    public void setRenderEscalaValoracionCaidas(boolean renderEscalaValoracionCaidas) {
        this.renderEscalaValoracionCaidas = renderEscalaValoracionCaidas;
    }

    public boolean isRenderEscalaValoracionCaidas() {
        return renderEscalaValoracionCaidas;
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

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getEdad() {
        return edad;
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

    public byte[] generarReferenciaPaciente(Chusuario usuario, 
                                            Chconsulta consulta, 
                                            Integer paginas_ant) {
        byte[] bytes = null;
        List<Chreporte> lstReporte = new ArrayList<Chreporte>();
         List<Chrefepaci> referenciaPacienteList = new ArrayList<Chrefepaci>();


        if (usuario != null) {
            if (usuario.getHusdfechanacim() != null) {
                FECHA_NACIMIENTO = usuario.getHusdfechanacim();
                if (FECHA_NACIMIENTO != null) {
                    int edad = 
                        calcularEdad(FECHA_NACIMIENTO, consulta.getHcodfecregistr());
                    EDAD = edad;
                }
            }
            if (getUsuarioSystem() != null) {
                IMPRIMIO = this.getUsuarioSystem().getCurcnombre();
            }
            if (usuario.getHuscprimernomb() != null) {
                NOMBRE = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                NOMBRE = NOMBRE + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundapel();
            }
            if (usuario.getHusanumeiden() != null && 
                usuario.getHusanumeiden() != 0) {
                TIPO_DOCUMENTO = usuario.getHusetipoiden();
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }
            if (usuario.getHuscentidadadm() != null) {
                try {
                    EPS = 
serviceLocator.getClinicoService().getDescripcionEntidadByCodigo(usuario.getHuscentidadadm());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }

            SEXO = usuario.getHusesexo();
            DIRECCION = usuario.getHuscdireccion();
            TELEFONO = usuario.getHusctelefono();
            Integer idCiudad = usuario.getHusnciudad();
            Integer idDepartamento = usuario.getHusndepartamen();
            Cpmunidane ciudadObject = null;
            try {
                ciudadObject = 
                        this.serviceLocator.getClinicoService().getMunicipio(idCiudad, 
                                                                             idDepartamento);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (ciudadObject != null) {
                CIUDAD = ciudadObject.getCmdcnommun();
            }

            Integer ocupacion = usuario.getHusnocupacion();
            try {
                OCUPACION = 
                        serviceLocator.getClinicoService().getDescripcionOcupacion(ocupacion);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            ESTADO_CIVIL = usuario.getHuseestadcivil();
            RESPONSABLE = usuario.getHuscnomresponsa();
            PARENTESCO_RESPONSABLE = usuario.getHuscparresponsa();
            TELEFONO_RESPONSABLE = usuario.getHusctelresponsa();
            ZONA = formatearCampoZona(usuario.getHusezonareside());
            ESTRATO = usuario.getHusnestrato();
            NIVELEDUCATIVO = 
                    formatearCampoNivelEducativo(usuario.getHusnniveledu());
            ETNIA = formatearCampoEtnia(usuario.getHuscetnia());
            BARRIO = usuario.getHuscbarrio();

        }
        try {
            referenciaPacienteList = 
                    this.serviceLocator.getCirugiaService().getReferenciaPaciente(consulta.getHcolnumero());
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (referenciaPacienteList != null && !referenciaPacienteList.isEmpty() ) {
            Chreporte report = new Chreporte();
            for(Chrefepaci referenciaPaciente :referenciaPacienteList){
            
            
            report = new Chreporte();
            report.setHrecdescripcio("Fecha Registro: " + formatearCampo(referenciaPaciente.getHrpdfecreg()));
            report.setHrencodigo(imp_referencia_paciente);
            report.setHrectipodescri("Referencia Paciente");
            report.setHrentipoimpres(1);
            report.setHrenconsulta(consulta.getHcolnumero());
            report.setHredfecharegis(referenciaPaciente.getHrpdfecreg());
            lstReporte.add(report);
            
            report = new Chreporte();
            report.setHrecdescripcio("Referencia Paciente: " + formatearCampo(referenciaPaciente.getHrpcrefepaci()));
            report.setHrencodigo(imp_referencia_paciente);
            report.setHrectipodescri("Referencia Paciente");
            report.setHrentipoimpres(1);
            report.setHrenconsulta(consulta.getHcolnumero());
            report.setHredfecharegis(referenciaPaciente.getHrpdfecreg());
            lstReporte.add(report);
            
            if("S".equals(referenciaPaciente.getHrpcrefepaci())){
            
            report = new Chreporte();
            report.setHrecdescripcio("Datos de IPS receptora");
            report.setHrencodigo(imp_referencia_paciente);
            report.setHrectipodescri("Referencia Paciente");
            report.setHrentipoimpres(1);
            report.setHrenconsulta(consulta.getHcolnumero());
            report.setHredfecharegis(referenciaPaciente.getHrpdfecreg());
            lstReporte.add(report);

            if (referenciaPaciente.getHrpcinstrece() != null) {
                report = new Chreporte();
                report.setHrecdescripcio("Instituci�n Receptora: " + 
                                         formatearCampo(referenciaPaciente.getHrpcinstrece()));
                report.setHrencodigo(imp_referencia_paciente);
                report.setHrectipodescri("Referencia Paciente");
                report.setHrentipoimpres(1);
                report.setHrenconsulta(consulta.getHcolnumero());
                report.setHredfecharegis(referenciaPaciente.getHrpdfecreg());
                lstReporte.add(report);
            }


            report = new Chreporte();
            report.setHrecdescripcio("Hora de confirmaci�n de la remisi�n: " + 
                                     formatearCampo(referenciaPaciente.getHrpchoraconf()) + 
                                     ":" + 
                                     formatearCampo(referenciaPaciente.getHrpcminuconf()));
            report.setHrencodigo(imp_referencia_paciente);
            report.setHrectipodescri("Ingreso Enfermer�a");
            report.setHrentipoimpres(1);
            report.setHrenconsulta(consulta.getHcolnumero());
            report.setHredfecharegis(referenciaPaciente.getHrpdfecreg());
            lstReporte.add(report);

            report = new Chreporte();
            report.setHrecdescripcio("Datos del trasporte ambulatorio");
            report.setHrencodigo(imp_referencia_paciente);
            report.setHrectipodescri("Referencia Paciente");
            report.setHrentipoimpres(1);
            report.setHrenconsulta(consulta.getHcolnumero());
            report.setHredfecharegis(referenciaPaciente.getHrpdfecreg());
            lstReporte.add(report);

            if (referenciaPaciente.getHrpcpresambu() != null) {
                report = new Chreporte();
                report.setHrecdescripcio("Prestador de ambulancia: " + 
                                         formatearCampo(referenciaPaciente.getHrpcpresambu()));
                report.setHrencodigo(imp_referencia_paciente);
                report.setHrectipodescri("Referencia Paciente");
                report.setHrentipoimpres(1);
                report.setHrenconsulta(consulta.getHcolnumero());
                report.setHredfecharegis(referenciaPaciente.getHrpdfecreg());
                lstReporte.add(report);

            }
            report = new Chreporte();
            String tipoAmbulancia = null;

            if ("BA".equals(referenciaPaciente.getHrpctipoambu())) {
                tipoAmbulancia = "B�sica";
            } else if ("ME".equals(referenciaPaciente.getHrpctipoambu())) {
                tipoAmbulancia = "Medicalizada";
            }
            report.setHrecdescripcio("Tipo de ambulancia: " + 
                                     formatearCampo(tipoAmbulancia));
            report.setHrencodigo(imp_referencia_paciente);
            report.setHrectipodescri("Referencia Paciente");
            report.setHrentipoimpres(1);
            report.setHrenconsulta(consulta.getHcolnumero());
            report.setHredfecharegis(referenciaPaciente.getHrpdfecreg());
            lstReporte.add(report);


            report = new Chreporte();
            report.setHrecdescripcio("Hora de llegada de la ambulancia a Profamilia: " + 
                                     formatearCampo(referenciaPaciente.getHrpchorallega() + 
                                                    ":" + 
                                                    formatearCampo(referenciaPaciente.getHrpcminullega())));
            report.setHrencodigo(imp_referencia_paciente);
            report.setHrectipodescri("Referencia Paciente");
            report.setHrentipoimpres(1);
            report.setHrenconsulta(consulta.getHcolnumero());
            report.setHredfecharegis(referenciaPaciente.getHrpdfecreg());
            lstReporte.add(report);

            if (referenciaPaciente.getHrpctripurecib() != null) {
                report = new Chreporte();
                report.setHrecdescripcio("Tripulante de ambulancia que recibe el paciente: " + 
                                         formatearCampo(referenciaPaciente.getHrpctripurecib()));
                report.setHrencodigo(imp_referencia_paciente);
                report.setHrectipodescri("Referencia Paciente");
                report.setHrentipoimpres(1);
                report.setHrenconsulta(consulta.getHcolnumero());
                report.setHredfecharegis(referenciaPaciente.getHrpdfecreg());
                lstReporte.add(report);

            }

            report = new Chreporte();
            report.setHrecdescripcio("Hora de salida de paciente: " + 
                                     formatearCampo(referenciaPaciente.getHrpchorasali() + 
                                                    ":" + 
                                                    formatearCampo(referenciaPaciente.getHrpcminusali())));
            report.setHrencodigo(imp_referencia_paciente);
            report.setHrectipodescri("Referencia Paciente");
            report.setHrentipoimpres(1);
            report.setHrenconsulta(consulta.getHcolnumero());
            report.setHredfecharegis(referenciaPaciente.getHrpdfecreg());
            lstReporte.add(report);


            report = new Chreporte();
            report.setHrecdescripcio("Seguimiento");
            report.setHrencodigo(imp_referencia_paciente);
            report.setHrectipodescri("Referencia Paciente");
            report.setHrentipoimpres(1);
            report.setHrenconsulta(consulta.getHcolnumero());
            report.setHredfecharegis(referenciaPaciente.getHrpdfecreg());
            lstReporte.add(report);

            report = new Chreporte();
            report.setHrecdescripcio("Hora de ingreso del paciente a la IPS receptora: " + 
                                     formatearCampo(referenciaPaciente.getHrpchorallega() + 
                                                    ":" + 
                                                    formatearCampo(referenciaPaciente.getHrpcminullega())));
            report.setHrencodigo(imp_referencia_paciente);
            report.setHrectipodescri("Referencia Paciente");
            report.setHrentipoimpres(1);
            report.setHrenconsulta(consulta.getHcolnumero());
            report.setHredfecharegis(referenciaPaciente.getHrpdfecreg());
            lstReporte.add(report);

            if (referenciaPaciente.getHrpcnomfunges() != null) {
                report = new Chreporte();
                report.setHrecdescripcio("Nombre del funcionario que gestion� la remisi�n: " + 
                                         formatearCampo(referenciaPaciente.getHrpcnomfunges()));
                report.setHrencodigo(imp_referencia_paciente);
                report.setHrectipodescri("Referencia Paciente");
                report.setHrentipoimpres(1);
                report.setHrenconsulta(consulta.getHcolnumero());
                report.setHredfecharegis(referenciaPaciente.getHrpdfecreg());
                lstReporte.add(report);
            }
            
                report = new Chreporte();
                report.setHrecdescripcio("****************************************************************************************************************************************************************");
                report.setHrencodigo(imp_referencia_paciente);
                report.setHrectipodescri("Referencia Paciente");
                report.setHrentipoimpres(1);
                report.setHrenconsulta(consulta.getHcolnumero());
                report.setHredfecharegis(referenciaPaciente.getHrpdfecreg());
                lstReporte.add(report);
            }
            }

            try {
                URL url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
                URL url_super_horizontal = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
                URL url_super_vertical = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                parameters.put("NOMBRE", NOMBRE);
                parameters.put("TIPO_DOCUMENTO", TIPO_DOCUMENTO);
                parameters.put("NOMBRE_PROFESIONAL", NOMBRE_PROFESIONAL);
                parameters.put("NUMERO_DOCUMENTO", NUMERO_DOCUMENTO);
                parameters.put("FECHA_NACIMIENTO", FECHA_NACIMIENTO);
                parameters.put("DIRECCION", DIRECCION);
                parameters.put("OCUPACION", OCUPACION);
                parameters.put("RESPONSABLE", RESPONSABLE);
                parameters.put("EDAD", EDAD);
                parameters.put("TELEFONO", TELEFONO);
                parameters.put("ESTADO_CIVIL", ESTADO_CIVIL);
                parameters.put("PARENTESCO_RESPONSABLE", 
                               PARENTESCO_RESPONSABLE);
                parameters.put("SEXO", SEXO);
                parameters.put("CIUDAD", CIUDAD);
                parameters.put("TELEFONO_RESPONSABLE", TELEFONO_RESPONSABLE);
                parameters.put("IMPRIMIO", IMPRIMIO);
                parameters.put("REGISTRO_MEDICO", REGISTRO_MEDICO);
                parameters.put("EPS", EPS);
                parameters.put("PAGINAS_ANTERIORES", paginas_ant);


                parameters.put("ZONA", ZONA);
                parameters.put("CONTRATO", CONTRATO);
                parameters.put("ESTRATO", ESTRATO);
                parameters.put("NIVELEDUCATIVO", NIVELEDUCATIVO);
                parameters.put("BARRIO", BARRIO);

                parameters.put("ETNIA", ETNIA);

                JRBeanCollectionDataSource dataSource = 
                    new JRBeanCollectionDataSource(lstReporte);
                File reportFile = 
                    new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/consultarFoliosCirugia.jasper"));
                if (reportFile.exists()) {
                    try {
                        bytes = 
                                JasperRunManager.runReportToPdf(reportFile.getPath(), 
                                                                parameters, 
                                                                dataSource);
                    } catch (JRException ex) {
                        ex.printStackTrace();
                        FacesUtils.addErrorMessage("No pudo generar Ingreso enfermeria. " + 
                                                   ex.getMessage());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        FacesUtils.addErrorMessage("No pudo generar Ingreso enfermeria. " + 
                                                   ex.getMessage());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
            }
        }
        return bytes;
    }

}
