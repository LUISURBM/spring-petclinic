package org.profamilia.hc.view.backing.comun.resumen;

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

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chactividad;
import org.profamilia.hc.model.dto.Chanatopatol;
import org.profamilia.hc.model.dto.Chantecegene;
import org.profamilia.hc.model.dto.Chantecemama;
import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chcertmedico;
import org.profamilia.hc.model.dto.Chconducta;
import org.profamilia.hc.model.dto.Chconsprogra;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chcontrolcon;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chexafismama;
import org.profamilia.hc.model.dto.Chexamediagn;
import org.profamilia.hc.model.dto.Chexameelect;
import org.profamilia.hc.model.dto.Chexameimage;
import org.profamilia.hc.model.dto.Chexamelabor;
import org.profamilia.hc.model.dto.Chexamfisico;
import org.profamilia.hc.model.dto.Chformulamed;
import org.profamilia.hc.model.dto.Chhistoimpre;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chincapacida;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.dto.Chnotamedica;
import org.profamilia.hc.model.dto.Chordecirugi;
import org.profamilia.hc.model.dto.Chpediexamen;
import org.profamilia.hc.model.dto.Chreferencia;
import org.profamilia.hc.model.dto.Chremihospit;
import org.profamilia.hc.model.dto.Chremision;
import org.profamilia.hc.model.dto.Chreporte;
import org.profamilia.hc.model.dto.Chresersangr;
import org.profamilia.hc.model.dto.Chriesgomama;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chviolencia;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.dto.Crcausaext;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.dto.Crfinalcon;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


public class ResumenHistoriaEspecificaBean extends BaseBean implements JRDataSource {


    private Chusuario usuario;

    private Chmotivocon motivo;

    private List<Chantecegene> lstAntecedentes;

    private Chantegineco antecedenteGinecologico;

    private Chantecemama antecedenteMama;

    private Chviolencia encuesta;

    private Chriesgomama riesgo;

    private Chexafismama examenMama;

    /** Almacena el examen fisico */
    private Chexamfisico examen;

    private Chpediexamen examenPediatria;

    private Chimprdiag impresion;

    private Chexamediagn examenDiagnostico;

    private Chincapacida incapacidad;

    /** Almacena la conducta */
    private Chconducta conducta;

    private List<Chreporte> lstReporte;

    /** Almacena el objeto de Cirug�as y procedimientos */
    private Chordecirugi orden;

    /** Almacena el objeto de referencia*/
    private Chreferencia referencia;

    /** Almacena la remisi�n a Hospitalizaci�n  */
    private Chremihospit hospitalizacion;

    /** Almacena los examenes paraclinicos */
    private List<Chexameimage> lstExamenesImagenes;

    /** Almacena los examenes paraclinicos */
    private List<Chexamelabor> lstExamenesLaboratorios;

    /** Almacena los examenes paraclinicos */
    private List<Chexameelect> lstExamenesElectrofisiologicos;

    /** Almacena las Inteconsultas que se le remitieron al paciente en la consulta */
    private List<Chremision> lstInterconsulta;


    /** Almacena el certificado m�dico */
    private Chcertmedico certificadoMedico;


    /** Almacena el certificado Asistencia */
    private Chcertmedico certificadoAsistencia;


    /** Almacena la Reserva de Sangre */
    private

    Chresersangr reserva;

    StringBuffer sbuffer = new StringBuffer();


    /** Almacena la anatomia patologica */
    private

    Chanatopatol anatomia;

    /** Almacena la lista de lar prescripciones Medicas*/
    private

    List<Chformulamed> lstFormula;

    /** Almacena el objeto de control sin costo  */
    private

    Chconsprogra control;

    /** Almacena el objeto de las notas medicas*/
    private

    List<Chnotamedica> lstnotaMedica;

    /** Lista de sexos */
    private List<SelectItem> listSexos;

    /** Almacena la lista de los posibles estados civil  */
    private List<SelectItem> listEstadoCivil;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    /** Lista que almacena las consultas de un Usuario */
    private List<Chconsulta> lstFolios;

    private HtmlDataTable dtFolios;

    private Integer edad;

    /** Almacena el objeto de impresion */
    Chhistoimpre objetoImpresion;

    /** Almacena el numero de la consulta*/
    private Long numeroConsulta;


    /** Almacena true si genero el folio seleccionado */
    private

    boolean generoHistoria;

    /** Almacena la consulta seleccionada*/
    private Chconsulta consultaClone;


    private Chcontrolcon controlConsulta;

    private boolean esResumen;

    private List lstTipoConsultaSalusSexual;

    private List lstTipoConsultaMama;

    private List lstTipoConsultaAnticoncepcion;

    private List lstTipoConsultaControl;

    private List lstTipoConsultaPrenatal;

    private List lstTipoConsultaPediatria;


    /** Almacenan los datos de la historia clinica */
    private String IMPRIMIO;
    private String NOMBRE;
    private String TIPO_DOCUMENTO;
    private Long NUMERO_DOCUMENTO;
    private Date FECHA_NACIMIENTO;
    private Integer EDAD;
    private String SEXO;
    private String DIRECCION;
    private String TELEFONO;
    private String CIUDAD;
    private String OCUPACION;
    private String ESTADO_CIVIL;
    private String RESPONSABLE;
    private String PARENTESCO_RESPONSABLE;
    private String TELEFONO_RESPONSABLE;
    private String FECHA_CONSULTA;
    private String NOMBRE_PROFESIONAL;
    private String CENTRO;
    private String CONSULTA_ACTUAL;
    private String DES_MOTIVO_CONSULTA;
    private String MOTIVO_CONSULTA;
    private String TIPO_CONTACTO;
    private String CUAL_CONTACTO;
    private String FINALIDAD;
    private String ENFERMEDAD_ACTUAL;
    private String NOMBRE_ACOMPANANTE;
    private String TELEFONO_ACOMPANANTE;


    private String SIN_ANTECEDENTES = "";
    private String ANTECEDENTE_ALERGICOS = "";
    private String ANTECEDENTES_FAMILIARES = "";
    private String ANTECEDENTES_ITS = "";
    private String ANTECEDENTES_PATOLOGICOS = "";
    private String ANTECEDENTES_QUIRURGICOS = "";
    private String ANTECEDENTES_TOXICOS = "";
    private String ANTECEDENTES_TRANSFUNCIONALES = "";
    private String ANTECEDENTES_TRAUMATICOS = "";
    private String ANTECEDENTES_FARMACOLOGICOS = "";
    private String ANTECEDENTES_MEDICACION = "";
    private String ANTECEDENTES_PARTO = "";
    private String ANTECEDENTES_COMPLICACIONES = "";
    private String ANTECEDENTES_INMUNIZACIONES = "";
    private String ANTECEDENTES_SICOMOTOR = "";
    private String ANTECEDENTES_ALIMENTACION = "";
    private String ANTECEDENTES_HOSPITALIZACIONES = "";


    private String HA_SUFRIDO_VIOLENCIA = "";
    private String VIOLENCIA_FISICA = "";
    private String VIOLENCIA_PSICOLOGICA = "";
    private String VIOLENCIA_SEXUAL = "";
    private String RIESGO_PERSONA_MALTRATA = "";
    private String ASESORIA_HABLAR = "";
    private String OBSERVACIONES_VIOLENCIA = "";
    private String PRESION_ARTERIAL = "";
    private String TIPO_TEMPERATURA = "";
    private String LUGAR_TEMPERATURA = "";
    private Integer FRECUENCIA_CARDIACA = null;
    private Integer FRECUENCIA_RESPIRATORIA = null;
    private BigDecimal TALLA = null;
    private BigDecimal PESO = null;
    private BigDecimal TEMPERATURA = null;
    private String HALLAZGOS_EXAMEN_FISICO = "";
    private String DIAGNOSTICO_PRINCIPAL = "";
    private String DIAGNOSTICO_RELACIONADO1 = "";
    private String DIAGNOSTICO_RELACIONADO2 = "";
    private String DIAGNOSTICO_RELACIONADO3 = "";
    private String RECOMENDACIONES_CONDUCTA = "";
    private String RECOMENDACIONES_PLANMANEJO = "";
    private String FECHA_INICIAL_INCAPACIDAD = "";
    private String FECHA_FINAL_INCAPACIDAD = "";
    private String TIPO_INCAPACIDAD = "";
    private String ORIGEN_INCAPACIDAD = "";
    private Integer DIAS_INCAPACIDAD = null;

    // Atributos  examenes paraclinicos
    private String FISIOLOGICOS = "";
    private String IMAGENES = "";
    private String LABORATORIOS = "";

    // Atributos referencia

    private String TIPO_SERVICIO = "";
    private String NOMBRE_RESPONSABLE_REFERENCIA = "";
    private String DIRECCION_RESPONSABLE_REFERENCIA = "";
    private String TELEFONO_RESPONSABLE_REFERENCIA = "";
    private String ANAMNESIS = "";
    private String APOYO_DIAGNOSTICO = "";
    private String JUSTIFICACION_REFERENCIA = "";

    // Atributos ANATOMIA PATOLOGICA
    private String ORIGEN_PIEZA = "";

    // Atributos de control

    private String FECHA_PROXIMO_CONTROL = "";
    private String HORA_PROXIMO_CONTROL = "";
    // Atributo de nota medica
    private String NOTA_MEDICA = "";

    String titulo = "";
    int total = 0;

    private int index = -1;

    List<String> datos = new ArrayList<String>();


    public ResumenHistoriaEspecificaBean() {
    }

    public void init() {
        resetDatos();
        lstFolios = new ArrayList<Chconsulta>();
        lstReporte = new ArrayList<Chreporte>();
        generoHistoria = false;
        lstTipoConsultaSalusSexual = new ArrayList();
        lstTipoConsultaAnticoncepcion = new ArrayList();
        lstTipoConsultaControl = new ArrayList();
        lstTipoConsultaMama = new ArrayList();
        lstTipoConsultaPediatria = new ArrayList();
        lstTipoConsultaPrenatal = new ArrayList();
        if (usuario == null) {
            usuario = new Chusuario();
        }

    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    /**
     * @param param
     */
    public void setListSexos(List<SelectItem> param) {
        this.listSexos = param;
    }

    /**
     * @return La lista de los sexos que existen
     */
    public List<SelectItem> getListSexos() {
        if (listSexos == null || listSexos.isEmpty()) {
            listSexos = new ArrayList<SelectItem>();
            ArrayList<Chsexo> listSexoAux = null;
            try {
                listSexoAux = 
                        (ArrayList<Chsexo>)this.getServiceLocator().getClinicoService().getSexo();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listSexoAux.isEmpty()) {

                Iterator it = listSexoAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listSexos.add(new SelectItem(listSexoAux.get(i).getCsxecodigo(), 
                                                 listSexoAux.get(i).getCsxcdescripcio()));
                    i++;

                }
            }
        }
        return listSexos;
    }

    /**
     * @param listEstadoCivil
     */
    public void setListEstadoCivil(List<SelectItem> listEstadoCivil) {
        this.listEstadoCivil = listEstadoCivil;
    }

    /**
     * @return
     */
    public List<SelectItem> getListEstadoCivil() {
        if (listEstadoCivil == null || listEstadoCivil.isEmpty()) {
            listEstadoCivil = new ArrayList<SelectItem>();
            ArrayList<Chestadociv> listEstadoCivilAux = null;
            try {
                listEstadoCivilAux = 
                        (ArrayList<Chestadociv>)this.getServiceLocator().getClinicoService().getEstadoCivil();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listEstadoCivilAux.isEmpty()) {

                Iterator it = listEstadoCivilAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listEstadoCivil.add(new SelectItem(listEstadoCivilAux.get(i).getCececodigo(), 
                                                       listEstadoCivilAux.get(i).getCeccdescripcio()));
                    i++;
                }
            }
        }
        return listEstadoCivil;
    }

    /**
     * @param param
     */
    public void setListTipoIdentificacion(List<SelectItem> param) {
        this.listTipoIdentificacion = param;
    }

    /**
     * @return
     */
    public List<SelectItem> getListTipoIdentificacion() {
        if (listTipoIdentificacion == null || 
            listTipoIdentificacion.isEmpty()) {
            listTipoIdentificacion = new ArrayList<SelectItem>();
            ArrayList<Cptipoiden> listTipoIdentificacionAux = null;
            try {
                listTipoIdentificacionAux = 
                        (ArrayList<Cptipoiden>)this.serviceLocator.getClinicoService().getTipoIdentificacion();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listTipoIdentificacionAux.isEmpty()) {

                Iterator it = listTipoIdentificacionAux.iterator();
                int i = 0;
                listTipoIdentificacion.add(new SelectItem("", 
                                                          "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listTipoIdentificacion.add(new SelectItem(listTipoIdentificacionAux.get(i).getCticcodigo(), 
                                                              listTipoIdentificacionAux.get(i).getCticdescri()));
                    i++;
                }
            }
        }

        return listTipoIdentificacion;
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
     * @param consultaClone
     */
    public void setConsultaClone(Chconsulta consultaClone) {
        this.consultaClone = consultaClone;
    }

    /**
     * @return
     */
    public Chconsulta getConsultaClone() {
        return consultaClone;
    }

    /**
     * @param lstTipoConsultaSalusSexual
     */
    public void setLstTipoConsultaSalusSexual(List lstTipoConsultaSalusSexual) {
        this.lstTipoConsultaSalusSexual = lstTipoConsultaSalusSexual;
    }

    /**
     * @return
     */
    public List getLstTipoConsultaSalusSexual() {
        return lstTipoConsultaSalusSexual;
    }

    /**
     * @param lstTipoConsultaAnticoncepcion
     */
    public void setLstTipoConsultaAnticoncepcion(List lstTipoConsultaAnticoncepcion) {
        this.lstTipoConsultaAnticoncepcion = lstTipoConsultaAnticoncepcion;
    }

    /**
     * @return
     */
    public List getLstTipoConsultaAnticoncepcion() {
        return lstTipoConsultaAnticoncepcion;
    }


    /**
     * @param lstTipoConsultaControl
     */
    public void setLstTipoConsultaControl(List lstTipoConsultaControl) {
        this.lstTipoConsultaControl = lstTipoConsultaControl;
    }

    /**
     * @return
     */
    public List getLstTipoConsultaControl() {
        return lstTipoConsultaControl;
    }


    public void consultarFoliosUsuario() {
        dtFolios.setFirst(0);
        if (usuario.getHuslnumero() != null) {
            try {
                lstFolios = 
                        this.getServiceLocator().getClinicoService().getFoliosUsuario(usuario.getHuslnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (lstFolios == null || lstFolios.isEmpty()) {
            FacesUtils.addErrorMessage(IConstantes.MSG_SIN_DATOS);
        }


    }

    public void consultarFoliosUsuarioSaludSexual() {
        dtFolios.setFirst(0);
        lstFolios = null;


        if (lstTipoConsultaSalusSexual != null && 
            !lstTipoConsultaSalusSexual.isEmpty()) {
            if (usuario.getHuslnumero() != null) {
                try {
                    lstFolios = 
                            this.getServiceLocator().getClinicoService().getFoliosUsuarioTipoHistoria(usuario.getHuslnumero(), 
                                                                                                      lstTipoConsultaSalusSexual);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }

            if (lstFolios == null || lstFolios.isEmpty()) {
                FacesUtils.addErrorMessage(IConstantes.MSG_SIN_DATOS);
            }
        } else {
            FacesUtils.addInfoMessage("Seleccione al menos un tipo de consulta");
        }


    }


    public void consultarFoliosUsuarioAnticoncepcion() {
        dtFolios.setFirst(0);
        lstFolios = null;

        if (lstTipoConsultaAnticoncepcion != null && 
            !lstTipoConsultaAnticoncepcion.isEmpty()) {
            if (usuario.getHuslnumero() != null) {
                try {
                    lstFolios = 
                            this.getServiceLocator().getClinicoService().getFoliosUsuarioTipoHistoria(usuario.getHuslnumero(), 
                                                                                                      lstTipoConsultaAnticoncepcion);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
            if (lstFolios == null || lstFolios.isEmpty()) {
                FacesUtils.addErrorMessage(IConstantes.MSG_SIN_DATOS);
            }

        } else {
            FacesUtils.addInfoMessage("Seleccione al menos un tipo de consulta");
        }


    }


    public void consultarFoliosUsuarioMama() {
        dtFolios.setFirst(0);
        lstFolios = null;

        if (lstTipoConsultaMama != null && !lstTipoConsultaMama.isEmpty()) {
            if (usuario.getHuslnumero() != null) {
                try {
                    lstFolios = 
                            this.getServiceLocator().getClinicoService().getFoliosUsuarioTipoHistoria(usuario.getHuslnumero(), 
                                                                                                      lstTipoConsultaMama);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
            if (lstFolios == null || lstFolios.isEmpty()) {
                FacesUtils.addErrorMessage(IConstantes.MSG_SIN_DATOS);
            }

        } else {
            FacesUtils.addInfoMessage("Seleccione al menos un tipo de consulta");
        }


    }


    public void consultarFoliosUsuarioPrenatal() {
        dtFolios.setFirst(0);
        lstFolios = null;

        if (lstTipoConsultaPrenatal != null && 
            !lstTipoConsultaPrenatal.isEmpty()) {
            if (usuario.getHuslnumero() != null) {
                try {
                    lstFolios = 
                            this.getServiceLocator().getClinicoService().getFoliosUsuarioTipoHistoria(usuario.getHuslnumero(), 
                                                                                                      lstTipoConsultaPrenatal);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
            if (lstFolios == null || lstFolios.isEmpty()) {
                FacesUtils.addErrorMessage(IConstantes.MSG_SIN_DATOS);
            }

        } else {
            FacesUtils.addInfoMessage("Seleccione al menos un tipo de consulta");
        }


    }


    public void consultarFoliosUsuarioPediatria() {
        dtFolios.setFirst(0);
        lstFolios = null;

        if (lstTipoConsultaPediatria != null && 
            !lstTipoConsultaPediatria.isEmpty()) {
            if (usuario.getHuslnumero() != null) {
                try {
                    lstFolios = 
                            this.getServiceLocator().getClinicoService().getFoliosUsuarioTipoHistoria(usuario.getHuslnumero(), 
                                                                                                      lstTipoConsultaPediatria);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
            if (lstFolios == null || lstFolios.isEmpty()) {
                FacesUtils.addErrorMessage(IConstantes.MSG_SIN_DATOS);
            }

        } else {
            FacesUtils.addInfoMessage("Seleccione al menos un tipo de consulta");
        }


    }


    public void consultarFoliosUsuarioControl() {
        dtFolios.setFirst(0);
        lstFolios = null;

        if (lstTipoConsultaControl != null && 
            !lstTipoConsultaControl.isEmpty()) {
            if (usuario.getHuslnumero() != null) {
                try {
                    lstFolios = 
                            this.getServiceLocator().getClinicoService().getFoliosUsuarioTipoHistoria(usuario.getHuslnumero(), 
                                                                                                      lstTipoConsultaControl);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
            if (lstFolios == null || lstFolios.isEmpty()) {
                FacesUtils.addErrorMessage(IConstantes.MSG_SIN_DATOS);
            }

        } else {
            FacesUtils.addInfoMessage("Seleccione al menos un tipo de consulta");
        }


    }


    public void setDtFolios(HtmlDataTable dtFolios) {
        this.dtFolios = dtFolios;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtFolios() {
        return dtFolios;
    }

    /**
     * @param lstFolios
     */
    public void setLstFolios(List<Chconsulta> lstFolios) {
        this.lstFolios = lstFolios;
    }

    /**
     * @return
     */
    public List<Chconsulta> getLstFolios() {
        return lstFolios;
    }

    /**
     * @param edad
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * @return
     */
    public Integer getEdad() {
        return edad;
    }


    /**
     * @param lstTipoConsultaMama
     */
    public void setLstTipoConsultaMama(List lstTipoConsultaMama) {
        this.lstTipoConsultaMama = lstTipoConsultaMama;
    }

    /**
     * @return
     */
    public List getLstTipoConsultaMama() {
        return lstTipoConsultaMama;
    }


    /**
     * @param lstTipoConsultaPrenatal
     */
    public void setLstTipoConsultaPrenatal(List lstTipoConsultaPrenatal) {
        this.lstTipoConsultaPrenatal = lstTipoConsultaPrenatal;
    }

    /**
     * @return
     */
    public List getLstTipoConsultaPrenatal() {
        return lstTipoConsultaPrenatal;
    }

    /**
     * @param lstTipoConsultaPediatria
     */
    public void setLstTipoConsultaPediatria(List lstTipoConsultaPediatria) {
        this.lstTipoConsultaPediatria = lstTipoConsultaPediatria;
    }

    /**
     * @return
     */
    public List getLstTipoConsultaPediatria() {
        return lstTipoConsultaPediatria;
    }

    /**
     * @return
     */
    public boolean next() {
        index++;
        return (index < lstReporte.size());
    }

    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();


        if (fieldName.equals("NOMBRE")) {
            value = NOMBRE;
        } else if (fieldName.equals("FECHA_NACIMIENTO")) {
            value = FECHA_NACIMIENTO;
        } else if (fieldName.equals("TIPO_DOCUMENTO")) {
            value = TIPO_DOCUMENTO;
        } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = NUMERO_DOCUMENTO;
        } else if (fieldName.equals("DIRECCION")) {
            value = DIRECCION;
        } else if (fieldName.equals("OCUPACION")) {
            value = OCUPACION;
        } else if (fieldName.equals("RESPONSABLE")) {
            value = RESPONSABLE;
        } else if (fieldName.equals("EDAD")) {
            value = EDAD;
        } else if (fieldName.equals("TELEFONO")) {
            value = TELEFONO;
        } else if (fieldName.equals("ESTADO_CIVIL")) {
            value = ESTADO_CIVIL;
        } else if (fieldName.equals("PARENTESCO_RESPONSABLE")) {
            value = PARENTESCO_RESPONSABLE;
        } else if (fieldName.equals("SEXO")) {
            value = SEXO;
        } else if (fieldName.equals("CIUDAD")) {
            value = CIUDAD;
        } else if (fieldName.equals("TELEFONO_RESPONSABLE")) {
            value = TELEFONO_RESPONSABLE;
        } else if (fieldName.equals("FECHA")) {
            value = new Date();
        } else if (fieldName.equals("IMPRIMIO")) {
            value = IMPRIMIO;
        } else if (fieldName.equals("TIPO")) {
            value = lstReporte.get(index).getHrencodigo();
        } else if (fieldName.equals("DESCRIPCION")) {
            value = lstReporte.get(index).getHrecdescripcio();
        } else if (fieldName.equals("DESCRIPCION2")) {
            value = lstReporte.get(index).getHrecdescripcio2();
        } else if (fieldName.equals("DESCRIPCION3")) {
            value = lstReporte.get(index).getHrecdescripcio3();
        } else if (fieldName.equals("DESCRIPCION4")) {
            value = lstReporte.get(index).getHrecdescripcio4();
        } else if (fieldName.equals("DESCRIPCION5")) {
            value = lstReporte.get(index).getHrecdescripcio5();
        } else if (fieldName.equals("TIPO_DES")) {
            value = lstReporte.get(index).getHrectipodescri();
        } else if (fieldName.equals("TIPO_IMPRESION")) {
            value = lstReporte.get(index).getHrentipoimpres();
        }
        return value;
    }

    /**
     * Metodo que obtiene los datos para generar la Cirug�as y procedimientos 
     */
    public void obtenerDatosReporte() {
        cargarObjetos();
        // Obtenemos los datos del usuario 
        if (usuario != null) {
            if (usuario.getHusdfechanacim() != null) {
                FECHA_NACIMIENTO = usuario.getHusdfechanacim();
                if (FECHA_NACIMIENTO != null) {
                    int edad = calcularEdad(FECHA_NACIMIENTO, new Date());
                    EDAD = edad;
                }

            }


            if (getUsuarioSystem() != null) {
                IMPRIMIO = this.getUsuarioSystem().getCurcnombre();
            }
            if (getClinica() != null) {
                CENTRO = this.getClinica().getCclcnombre();
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
            if (usuario.getHusanumeiden() != 0) {
                TIPO_DOCUMENTO = usuario.getHusetipoiden();
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
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
            if (usuario.getHusdfecregistr() != null) {
                FECHA_CONSULTA = usuario.getHusdfecregistr().toString();
            }
        }

        if (motivo != null) {


            try {
                NOMBRE_PROFESIONAL = 
                        this.serviceLocator.getClinicoService().getNombreUsuarioPorId(motivo.getHmccoperador());
            } catch (ModelException e) {
                e.printStackTrace();
            }


            Integer causa = this.motivo.getHmcncausaexte();
            Crcausaext causaObject = null;
            try {
                causaObject = 
                        getServiceLocator().getClinicoService().getCausaExternaPorId(causa);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (causaObject != null) {
                DES_MOTIVO_CONSULTA = causaObject.getCcacdescri();

            }
            MOTIVO_CONSULTA = motivo.getHmctdescripcio();
            ENFERMEDAD_ACTUAL = motivo.getHmctenferactal();
            Integer idFinalidad = null;
            idFinalidad = motivo.getHmcnfinalidad();
            Crfinalcon finalidadObject = null;
            try {
                finalidadObject = 
                        serviceLocator.getClinicoService().getFinalidadPorId(idFinalidad, 
                                                                             "C");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (finalidadObject != null) {
                FINALIDAD = finalidadObject.getCfccdescri();

            }

            if (motivo.getHmcctipoconta() == null || motivo.getHmcctipoconta().trim().equals("")) {
                TIPO_CONTACTO = "X";
            } else if (motivo.getHmcctipoconta().equals("I")) {
                TIPO_CONTACTO = "Interno";
            } else if (motivo.getHmcctipoconta().equals("E")) {
                TIPO_CONTACTO = "Externo";
            } else {
                TIPO_CONTACTO = "X";
            }
            
            if (motivo.getHmcccualconta() == null || motivo.getHmcccualconta().trim().equals("")) {
                CUAL_CONTACTO = " ";
            } else if (motivo.getHmcccualconta().equals("ASES")) {
                CUAL_CONTACTO = "Asesor�a";
            } else if (motivo.getHmcccualconta().equals("ASEG")) {
                CUAL_CONTACTO = "Aseguradora";
            } else if (motivo.getHmcccualconta().equals("CDPS")) {
                CUAL_CONTACTO = "Consulta de Psicolog�a";
            } else if (motivo.getHmcccualconta().equals("COME")) {
                CUAL_CONTACTO = "Consulta M�dica";
            } else if (motivo.getHmcccualconta().equals("CONO")) {
                CUAL_CONTACTO = "Conocido";
            } else if (motivo.getHmcccualconta().equals("IDSA")) {
                CUAL_CONTACTO = "Instituci�n de Salud";
            } else if (motivo.getHmcccualconta().equals("PRSA")) {
                CUAL_CONTACTO = "Direccionamiento de un Profesional de Salud";
            } else if (motivo.getHmcccualconta().equals("SPEM")) {
                CUAL_CONTACTO = "Servicio de prueba de embarazo";
            } else if (motivo.getHmcccualconta().equals("DEPS")) {
                CUAL_CONTACTO = "Direccionamiento de una EPS";
            } else if (motivo.getHmcccualconta().equals("DIPS")) {
                CUAL_CONTACTO = "Direccionamiento de una IPS";
            }  else if (motivo.getHmcccualconta().equals("PAWE")) {
                CUAL_CONTACTO = "Pagina Web";
            } else if (motivo.getHmcccualconta().equals("CEEX")) {
                CUAL_CONTACTO = "Centro de experiencia";
            } else if (motivo.getHmcccualconta().equals("REPE")) {
                CUAL_CONTACTO = "Por recomendaci�n de otra persona";
            }else {
                CUAL_CONTACTO = " ";
            }
        }

        if (lstAntecedentes != null && !lstAntecedentes.isEmpty()) {
            ANTECEDENTE_ALERGICOS = "";
            ANTECEDENTES_FAMILIARES = "";
            ANTECEDENTES_ITS = "";
            ANTECEDENTES_PATOLOGICOS = "";
            ANTECEDENTES_QUIRURGICOS = "";
            ANTECEDENTES_TOXICOS = "";
            ANTECEDENTES_TRANSFUNCIONALES = "";
            ANTECEDENTES_TRAUMATICOS = "";
            ANTECEDENTES_FARMACOLOGICOS = "";
            ANTECEDENTES_MEDICACION = "";
            ANTECEDENTES_PARTO = "";
            ANTECEDENTES_COMPLICACIONES = "";
            ANTECEDENTES_INMUNIZACIONES = "";
            ANTECEDENTES_SICOMOTOR = "";
            ANTECEDENTES_ALIMENTACION = "";
            ANTECEDENTES_HOSPITALIZACIONES = "";

            Iterator it = lstAntecedentes.iterator();
            while (it.hasNext()) {

                Chantecegene antecedente = (Chantecegene)it.next();
                if (antecedente != null && 
                    antecedente.getHanntipoante() != null) {
                    if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_SIN_ANTECEDENTES)) {
                        SIN_ANTECEDENTES = antecedente.getHantdescripcio();
                    }
                    if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_ALERGICOS)) {
                        ANTECEDENTE_ALERGICOS = 
                                ANTECEDENTE_ALERGICOS + antecedente.getHantdescripcio() + 
                                "\n";
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_FAMILIARES)) {
                        ANTECEDENTES_FAMILIARES = 
                                ANTECEDENTES_FAMILIARES + antecedente.getHantdescripcio() + 
                                "\n";
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_ITS)) {
                        ANTECEDENTES_ITS = 
                                ANTECEDENTES_ITS + antecedente.getHantdescripcio() + 
                                "\n";
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_PATOLOGICOS)) {
                        ANTECEDENTES_PATOLOGICOS = 
                                ANTECEDENTES_PATOLOGICOS + antecedente.getHantdescripcio() + 
                                "\n";
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_QUIRURGICOS)) {
                        ANTECEDENTES_QUIRURGICOS = 
                                ANTECEDENTES_QUIRURGICOS + antecedente.getHantdescripcio() + 
                                "\n";
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_TOXICOS)) {
                        ANTECEDENTES_TOXICOS = 
                                ANTECEDENTES_TOXICOS + antecedente.getHantdescripcio() + 
                                "\n ";
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_TRASNFUSIONALES)) {
                        ANTECEDENTES_TRANSFUNCIONALES = 
                                ANTECEDENTES_TRANSFUNCIONALES + 
                                antecedente.getHantdescripcio() + "\n";
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_TRAUMATICOS)) {
                        ANTECEDENTES_TRAUMATICOS = 
                                ANTECEDENTES_TRAUMATICOS + antecedente.getHantdescripcio() + 
                                "\n";
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_FARMACOLOGICO)) {
                        ANTECEDENTES_FARMACOLOGICOS = 
                                ANTECEDENTES_FARMACOLOGICOS + 
                                antecedente.getHantdescripcio() + "\n";
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_MEDICACION_EMBARAZO)) {
                        ANTECEDENTES_MEDICACION = 
                                ANTECEDENTES_MEDICACION + antecedente.getHantdescripcio() + 
                                "\n";
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_PARTO)) {
                        ANTECEDENTES_PARTO = 
                                ANTECEDENTES_PARTO + antecedente.getHantdescripcio() + 
                                "\n";
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_PERINATALES)) {
                        ANTECEDENTES_COMPLICACIONES = 
                                ANTECEDENTES_COMPLICACIONES + 
                                antecedente.getHantdescripcio() + "\n";
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_INMUNIZACIONES)) {
                        ANTECEDENTES_INMUNIZACIONES = 
                                ANTECEDENTES_INMUNIZACIONES + 
                                antecedente.getHantdescripcio() + "\n";
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_SICOMOTOR)) {
                        ANTECEDENTES_SICOMOTOR = 
                                ANTECEDENTES_SICOMOTOR + antecedente.getHantdescripcio() + 
                                "\n";
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_ALIMENTACION)) {
                        ANTECEDENTES_ALIMENTACION = 
                                ANTECEDENTES_ALIMENTACION + antecedente.getHantdescripcio() + 
                                "\n";
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_HOSPITALIZACIONES)) {
                        ANTECEDENTES_HOSPITALIZACIONES = 
                                ANTECEDENTES_HOSPITALIZACIONES + 
                                antecedente.getHantdescripcio() + "\n";
                    }
                }
            }

        }


        if (encuesta != null) {
            HA_SUFRIDO_VIOLENCIA = encuesta.getHviesufreviol();
            VIOLENCIA_FISICA = encuesta.getHvicfisiquien();
            VIOLENCIA_PSICOLOGICA = encuesta.getHvicpsicquien();
            VIOLENCIA_SEXUAL = encuesta.getHvicsexuquien();
            RIESGO_PERSONA_MALTRATA = encuesta.getHvieriesgo();
            ASESORIA_HABLAR = encuesta.getHviehabla();
            OBSERVACIONES_VIOLENCIA = encuesta.getHvitobserva();
        }

        if (examen != null) {
            PRESION_ARTERIAL = 
                    examen.getHefcpresart1() + "/" + examen.getHefcpresart2();
            FRECUENCIA_CARDIACA = examen.getHefnfreccard();
            FRECUENCIA_RESPIRATORIA = examen.getHefnfrecresp();
            TALLA = examen.getHefatalla();
            PESO = examen.getHefapeso();

            HALLAZGOS_EXAMEN_FISICO = examen.getHefthallazgo();
            if (examen.getHefelugartemp() != null) {
                if (examen.getHefelugartemp().equals("A")) {
                    LUGAR_TEMPERATURA = "Axilar";
                } else if (examen.getHefelugartemp().equals("B")) {
                    LUGAR_TEMPERATURA = "Bucal";
                }
            }
            if (examen.getHefetipotemper() != null) {
                if (examen.getHefetipotemper().equals("A")) {
                    TIPO_TEMPERATURA = "Afebril";
                    TEMPERATURA = null;
                } else if (examen.equals("F")) {
                    TIPO_TEMPERATURA = "Febril";
                    TEMPERATURA = examen.getHefatemperatu();
                }


            }

        }

        if (impresion != null) {

            Crdgncie10 diagprin = null;
            Crdgncie10 diagrela1 = null;
            Crdgncie10 diagrela2 = null;
            Crdgncie10 diagrela3 = null;
            try {
                if (impresion != null && impresion.getHidcdiagprin() != null) {
                    diagprin = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagprin().toUpperCase());
                }
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (diagprin != null) {
                DIAGNOSTICO_PRINCIPAL = 
                        diagprin.getCdcccodigo() + " " + diagprin.getCdccdescri();
            } else {
                DIAGNOSTICO_PRINCIPAL = null;
            }

            try {
                if (impresion != null && 
                    impresion.getHidcdiagrela1() != null) {
                    diagrela1 = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagrela1().toUpperCase());
                }
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (diagrela1 != null && impresion.getHidcdiagrela1() != null) {
                DIAGNOSTICO_RELACIONADO1 = 
                        diagrela1.getCdcccodigo() + " " + diagrela1.getCdccdescri();
            } else {
                DIAGNOSTICO_RELACIONADO1 = null;
            }


            try {
                if (impresion != null && 
                    impresion.getHidcdiagrela2() != null) {
                    diagrela2 = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagrela2().toUpperCase());
                }

            } catch (ModelException e) {
                e.printStackTrace();
            }


            if (diagrela2 != null) {
                DIAGNOSTICO_RELACIONADO2 = 
                        diagrela2.getCdcccodigo() + " " + diagrela2.getCdccdescri();
            } else {
                DIAGNOSTICO_RELACIONADO2 = null;
            }

            try {
                if (impresion != null && 
                    impresion.getHidcdiagrela3() != null) {
                    diagrela3 = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagrela3().toUpperCase());
                }
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (diagrela3 != null) {
                DIAGNOSTICO_RELACIONADO3 = 
                        diagrela3 + " " + diagrela3.getCdccdescri();
            } else {
                DIAGNOSTICO_RELACIONADO3 = null;
            }
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

                FECHA_INICIAL_INCAPACIDAD = formatearCampo(fechaInicial);
            }

            DIAS_INCAPACIDAD = incapacidad.getHidndias();
            if (incapacidad.getHindfecinicia() != null && 
                DIAS_INCAPACIDAD != null) {
                Calendar fechaFinalAux = Calendar.getInstance();
                fechaFinalAux.setTime(incapacidad.getHindfecinicia());
                fechaFinalAux.add(Calendar.DAY_OF_MONTH, DIAS_INCAPACIDAD);
                FECHA_FINAL_INCAPACIDAD = 
                        formatearCampo(fechaFinalAux.getTime());
            }
        }

        if (conducta != null) {
            RECOMENDACIONES_CONDUCTA = conducta.getHcncobservacio();
        }
        if(conducta != null) {
            RECOMENDACIONES_PLANMANEJO = conducta.getHcncplanmanejo();
            
        }
      

        if (referencia != null) {
            TIPO_SERVICIO = "";
            StringTokenizer st = 
                new StringTokenizer(referencia.getHrectiporefere(), ",");
            while (st.hasMoreTokens()) {
                String tipo = st.nextToken();
                if (tipo.equals("IC")) {
                    TIPO_SERVICIO = TIPO_SERVICIO + "Interconsulta, ";
                }
                if (tipo.equals("AT")) {
                    TIPO_SERVICIO = TIPO_SERVICIO + "Apoyo Tecnologico, ";
                }
                if (tipo.equals("RE")) {
                    TIPO_SERVICIO = TIPO_SERVICIO + "Remisi�n, ";
                }
                if (tipo.equals("OS")) {
                    TIPO_SERVICIO = TIPO_SERVICIO + "Orden de Servicio, ";
                }
                if (tipo.equals("OR")) {
                    TIPO_SERVICIO = TIPO_SERVICIO + "Ordinario, ";
                }
                if (tipo.equals("PR")) {
                    TIPO_SERVICIO = TIPO_SERVICIO + "Prioritario, ";
                }
                if (tipo.equals("UR")) {
                    TIPO_SERVICIO = TIPO_SERVICIO + "Urgencia, ";
                }

            }
            if (TIPO_SERVICIO != null && !TIPO_SERVICIO.equals("")) {
                TIPO_SERVICIO = 
                        TIPO_SERVICIO.substring(0, TIPO_SERVICIO.length() - 2);
            }


            NOMBRE_RESPONSABLE_REFERENCIA = 
                    formatearCampo(referencia.getHrecnombrespon());
            DIRECCION_RESPONSABLE_REFERENCIA = 
                    formatearCampo(referencia.getHrecdirecrespo());
            TELEFONO_RESPONSABLE_REFERENCIA = 
                    formatearCampo(referencia.getHrectelefrespo());
            ANAMNESIS = formatearCampo(referencia.getHrecanamnesis());
            APOYO_DIAGNOSTICO = formatearCampo(referencia.getHrecapoyodiagn());
            JUSTIFICACION_REFERENCIA = 
                    formatearCampo(referencia.getHrecjustirefer());
        }

        if (anatomia != null) {
            ORIGEN_PIEZA = formatearCampo(anatomia.getHapcorigepieza());
        }

        if (control != null) {
            Date fechaAux = control.getHcpdfechprocon();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaAux);
            FECHA_PROXIMO_CONTROL = formatearCampo(fechaAux);


            String hora = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
            String minuto = String.valueOf(calendar.get(Calendar.MINUTE));
            if (calendar.get(Calendar.HOUR_OF_DAY) < 10) {
                hora = "0" + hora;
            }
            if (calendar.get(Calendar.MINUTE) < 10) {
                minuto = "0" + minuto;
            }

            HORA_PROXIMO_CONTROL = hora + ":" + minuto;
        }


        if (lstnotaMedica != null && !lstnotaMedica.isEmpty()) {

            Iterator it = lstnotaMedica.iterator();
            NOTA_MEDICA = "";

            while (it.hasNext()) {
                Chnotamedica nota = (Chnotamedica)it.next();
                Integer idActividad = nota.getHnmnactividad();
                Chactividad actividad = null;
                String descActividad = "";


                try {
                    actividad = 
                            this.serviceLocator.getClinicoService().getActividadPorId(idActividad);
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (actividad != null) {
                    descActividad = actividad.getHaccdescripcio();
                }

                NOTA_MEDICA = 
                        NOTA_MEDICA + "Fecha de la Nota Medica: " + formatearCampo(nota.getHnmdfecregistr()) + 
                        "\n" + descActividad + ":" + nota.getHnmcdescripc() + 
                        "\n";
            }
        }


        setDatos();
    }


    public void cargarObjetos() {
        if (dtFolios != null && dtFolios.getRowData() != null) {
            consultaClone = (Chconsulta)this.dtFolios.getRowData();
        }


        String idConsulta = null;

        if (consultaClone != null) {
            NOMBRE_ACOMPANANTE = consultaClone.getHcocnombacompa();
            TELEFONO_ACOMPANANTE = consultaClone.getHcocteleacompa();
            idConsulta = consultaClone.getHcocservicio().getCsvccodigo();
            try {
                CONSULTA_ACTUAL = 
                        this.serviceLocator.getClinicoService().getDescripcionCups(idConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (consultaClone != null) {
            numeroConsulta = consultaClone.getHcolnumero();
        }
        if (numeroConsulta != null) {
            try {
                motivo = 
                        serviceLocator.getClinicoService().getMotivoConsulta(numeroConsulta);

            } catch (ModelException e) {
                e.printStackTrace();
            }


            try {
                antecedenteMama = 
                        serviceLocator.getClinicoService().getAntecedentesMama(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            try {
                riesgo = 
                        serviceLocator.getClinicoService().getRiesgoMama(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            try {
                examenMama = 
                        serviceLocator.getClinicoService().getExamenFisicoMama(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            try {
                examenPediatria = 
                        serviceLocator.getClinicoService().getExamenPediatria(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            try {
                examenDiagnostico = 
                        serviceLocator.getClinicoService().getExamenApoyoDiagnostico(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            try {
                lstAntecedentes = 
                        serviceLocator.getClinicoService().getAntecedentesGenerales(numeroConsulta);

            } catch (ModelException e) {
                e.printStackTrace();
            }

            try {
                antecedenteGinecologico = 
                        serviceLocator.getClinicoService().getAntecedentesGinecologicos(numeroConsulta);

            } catch (ModelException e) {
                e.printStackTrace();
            }

            try {
                examen = 
                        serviceLocator.getClinicoService().getExamenFisico(numeroConsulta, Integer.parseInt("1"));

            } catch (ModelException e) {
                e.printStackTrace();
            }

            try {
                encuesta = 
                        serviceLocator.getClinicoService().getEncuestaViolencia(numeroConsulta);

            } catch (ModelException e) {
                e.printStackTrace();
            }

            try {
                impresion = 
                        serviceLocator.getClinicoService().getImresionDiagnostica(numeroConsulta, Integer.parseInt("1"));

            } catch (ModelException e) {
                e.printStackTrace();
            }


            try {
                conducta = 
                        serviceLocator.getClinicoService().getConducta(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            try {
                incapacidad = 
                        serviceLocator.getClinicoService().getIncapacidad(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }


            try {
                orden = 
                        serviceLocator.getClinicoService().getOrdenCirugia(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            try {
                lstExamenesImagenes = 
                        serviceLocator.getClinicoService().getExamenesImagenesConsulta(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            try {
                lstExamenesLaboratorios = 
                        serviceLocator.getClinicoService().getExamenesLaboratoriosConsulta(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            try {
                lstExamenesElectrofisiologicos = 
                        serviceLocator.getClinicoService().getExamenesElectrofisiologicosConsulta(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }


            try {
                referencia = 
                        serviceLocator.getClinicoService().getReferencia(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            try {
                anatomia = 
                        serviceLocator.getClinicoService().getAnatomiaPatologica(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            try {
                lstFormula = 
                        serviceLocator.getClinicoService().getPrescripcionMedica(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            try {
                control = 
                        serviceLocator.getClinicoService().getControl(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            try {
                lstnotaMedica = 
                        serviceLocator.getClinicoService().getListNotasMedicas(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }


            try {
                lstInterconsulta = 
                    serviceLocator.getClinicoService().getRemisionConsulta(numeroConsulta, IConstantes.TIPO_CONSULTA);
            } catch (ModelException e) {
                e.printStackTrace();
            }


            try {
                certificadoMedico = 
                        serviceLocator.getClinicoService().getCertificado(numeroConsulta, 
                                                                          IConstantes.CERTIFICADO_MEDICO);
            } catch (ModelException e) {
                e.printStackTrace();
            }


            try {
                certificadoAsistencia = 
                        serviceLocator.getClinicoService().getCertificado(numeroConsulta, 
                                                                          IConstantes.CERTIFICADO_ASISTENCIA);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            try {
                hospitalizacion = 
                        serviceLocator.getClinicoService().getRemisionHospitalizacion(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            try {
                reserva = 
                        serviceLocator.getClinicoService().getReservaSangre(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }


            try {
                controlConsulta = 
                        serviceLocator.getClinicoService().getControlConsulta(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
    }


    public void setGeneroHistoria(boolean generoHistoria) {
        this.generoHistoria = generoHistoria;
    }

    public boolean isGeneroHistoria() {
        return generoHistoria;
    }


    public void setDatos() {

        Chreporte report1 = new Chreporte();
        report1 = new Chreporte();
        report1.setHrecdescripcio("");
        report1.setHrectipodescri("");
        report1.setHrencodigo(1);
        report1.setHrentipoimpres(1);
        lstReporte.add(report1);

        if ((motivo != null)) {
            Chreporte report = new Chreporte();

            NOMBRE_PROFESIONAL = formatearCampo(NOMBRE_PROFESIONAL);
            CENTRO = formatearCampo(CENTRO);
            DES_MOTIVO_CONSULTA = formatearCampo(DES_MOTIVO_CONSULTA);
            MOTIVO_CONSULTA = formatearCampo(MOTIVO_CONSULTA);
            TIPO_CONTACTO = formatearCampo(TIPO_CONTACTO);
            CUAL_CONTACTO = formatearCampo(CUAL_CONTACTO);
            FINALIDAD = formatearCampo(FINALIDAD);
            ENFERMEDAD_ACTUAL = formatearCampo(ENFERMEDAD_ACTUAL);
            NOMBRE_ACOMPANANTE = formatearCampo(NOMBRE_ACOMPANANTE);
            TELEFONO_ACOMPANANTE = formatearCampo(TELEFONO_ACOMPANANTE);

            String s = "";
            String s2 = "";

            s = "";
            s = "Consulta: " + CONSULTA_ACTUAL;
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrectipodescri("Motivo de Consulta");
            report.setHrencodigo(1);
            report.setHrentipoimpres(1);
            lstReporte.add(report);

            report.setHrecdescripcio(s);
            report.setHrectipodescri("Motivo de Consulta");
            report.setHrencodigo(1);
            lstReporte.add(report);
            s = "";
            s2 = "";
            s = "Nombre del profesional:         " + NOMBRE_PROFESIONAL;
            s2 = "Centro: " + CENTRO;
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Motivo de Consulta");
            report.setHrencodigo(1);
            lstReporte.add(report);


            s = "";
            s = "Causa Externa:             " + DES_MOTIVO_CONSULTA;
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrectipodescri("Motivo de Consulta");
            report.setHrencodigo(1);
            report.setHrentipoimpres(1);
            lstReporte.add(report);

            s = "";
            s2 = "";
            s = "Causa que genera la consulta :  " + MOTIVO_CONSULTA;
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrectipodescri("Motivo de Consulta");
            report.setHrentipoimpres(1);
            report.setHrencodigo(1);
            lstReporte.add(report);
            s = "";
            s2 = "";
            s = "Finalidad de la Consulta:       " + FINALIDAD;
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrectipodescri("Motivo de Consulta");
            report.setHrencodigo(1);
            report.setHrentipoimpres(1);
            lstReporte.add(report);

            if (!TIPO_CONTACTO.equals("X")) {
                s = "";
                s2 = "";
                s = "Ingresa a Profamilia por:  " + TIPO_CONTACTO;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrectipodescri("Motivo de Consulta");
                report.setHrencodigo(1);
                report.setHrentipoimpres(1);
                lstReporte.add(report);

                s = "";
                s2 = "";
                s = "Cual?       " + CUAL_CONTACTO;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrectipodescri("Motivo de Consulta");
                report.setHrencodigo(1);
                report.setHrentipoimpres(1);
                lstReporte.add(report);
    
            }
            
            s = "";
            s2 = "";
            s = "Enfermedad Actual:              " + ENFERMEDAD_ACTUAL;
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrectipodescri("Motivo de Consulta");
            report.setHrencodigo(1);
            report.setHrentipoimpres(1);
            lstReporte.add(report);

            s = "";
            s2 = "";
            s = "Nombre Acompa�ante:             " + NOMBRE_ACOMPANANTE;
            s2 = "T�lefono Acompa�ante: " + TELEFONO_ACOMPANANTE;
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrectipodescri("Motivo de Consulta");
            report.setHrencodigo(1);
            report.setHrentipoimpres(2);
            lstReporte.add(report);

            if (motivo.getHmccrevisistem() != null && 
                !motivo.getHmccrevisistem().equals("")) {
                s = "";
                s = "Revision por Sistemas:             " + motivo.getHmccrevisistem();
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrectipodescri("Motivo de Consulta");
                report.setHrencodigo(1);
                report.setHrentipoimpres(1);
                lstReporte.add(report);
            }


        }


        if (lstAntecedentes != null) {

            Chreporte report = new Chreporte();

            if (SIN_ANTECEDENTES != null && !SIN_ANTECEDENTES.equals("")) {
                report = new Chreporte();
                report.setHrectipodescri("Antecedentes");
                report.setHrecdescripcio(SIN_ANTECEDENTES);
                report.setHrencodigo(2);
                report.setHrentipoimpres(1);
                lstReporte.add(report);
            }


            if (ANTECEDENTE_ALERGICOS != null && 
                !ANTECEDENTE_ALERGICOS.equals("")) {
                report = new Chreporte();
                report.setHrectipodescri("Antecedentes");
                report.setHrecdescripcio("Antecedentes Alergicos ");
                report.setHrecdescripcio2(ANTECEDENTE_ALERGICOS);
                report.setHrencodigo(2);
                report.setHrentipoimpres(3);
                lstReporte.add(report);
            }

            if (ANTECEDENTES_FAMILIARES != null && 
                !ANTECEDENTES_FAMILIARES.equals("")) {
                report = new Chreporte();
                report.setHrectipodescri("Antecedentes");
                report.setHrecdescripcio("Antecedentes Familiares");
                report.setHrecdescripcio2(ANTECEDENTES_FAMILIARES);
                report.setHrencodigo(2);
                report.setHrentipoimpres(3);
                lstReporte.add(report);
            }

            if (ANTECEDENTES_ITS != null && !ANTECEDENTES_ITS.equals("")) {

                report = new Chreporte();
                report.setHrectipodescri("Antecedentes");
                report.setHrecdescripcio("Antecedentes ITS");
                report.setHrecdescripcio2(ANTECEDENTES_ITS);
                report.setHrencodigo(2);
                report.setHrentipoimpres(3);
                lstReporte.add(report);
            }

            if (ANTECEDENTES_PATOLOGICOS != null && 
                !ANTECEDENTES_PATOLOGICOS.equals("")) {
                report = new Chreporte();
                report.setHrectipodescri("Antecedentes");
                report.setHrecdescripcio("Antecedentes Patologicos");
                report.setHrecdescripcio2(ANTECEDENTES_PATOLOGICOS);
                report.setHrencodigo(2);
                report.setHrentipoimpres(3);
                lstReporte.add(report);
            }

            if (ANTECEDENTES_QUIRURGICOS != null && 
                !ANTECEDENTES_QUIRURGICOS.equals("")) {
                report = new Chreporte();
                report.setHrectipodescri("Antecedentes");
                report.setHrecdescripcio("Antecedentes Quirurgicos ");
                report.setHrecdescripcio2(ANTECEDENTES_QUIRURGICOS);
                report.setHrencodigo(2);
                report.setHrentipoimpres(3);
                lstReporte.add(report);

            }
            if (ANTECEDENTES_TOXICOS != null && 
                !ANTECEDENTES_TOXICOS.equals("")) {
                report = new Chreporte();
                report.setHrectipodescri("Antecedentes");
                report.setHrecdescripcio("Antecedentes Toxicos");
                report.setHrecdescripcio2(ANTECEDENTES_TOXICOS);
                report.setHrencodigo(2);
                report.setHrentipoimpres(3);
                lstReporte.add(report);
            }

            if (ANTECEDENTES_TRANSFUNCIONALES != null && 
                !ANTECEDENTES_TRANSFUNCIONALES.equals("")) {
                report = new Chreporte();
                report.setHrectipodescri("Antecedentes");
                report.setHrecdescripcio("Antecedentes Tranfusionales");
                report.setHrecdescripcio2(ANTECEDENTES_TRANSFUNCIONALES);
                report.setHrencodigo(2);
                report.setHrentipoimpres(3);
                lstReporte.add(report);
            }
            if (ANTECEDENTES_TRAUMATICOS != null && 
                !ANTECEDENTES_TRAUMATICOS.equals("")) {
                report = new Chreporte();
                report.setHrectipodescri("Antecedentes");
                report.setHrecdescripcio2(ANTECEDENTES_TRAUMATICOS);
                report.setHrecdescripcio("Antecedentes Traumaticos ");
                report.setHrencodigo(2);
                report.setHrentipoimpres(3);
                lstReporte.add(report);
            }

            if (ANTECEDENTES_FARMACOLOGICOS != null && 
                !ANTECEDENTES_FARMACOLOGICOS.equals("")) {
                report = new Chreporte();
                report.setHrectipodescri("Antecedentes");
                report.setHrecdescripcio("Antecedentes Farmacologicos: ");
                report.setHrecdescripcio2(ANTECEDENTES_FARMACOLOGICOS);
                report.setHrencodigo(2);
                report.setHrentipoimpres(3);
                lstReporte.add(report);
            }


            if (ANTECEDENTES_MEDICACION != null && 
                !ANTECEDENTES_MEDICACION.equals("")) {
                report = new Chreporte();
                report.setHrectipodescri("Antecedentes");
                report.setHrecdescripcio("Antecedentes Medicaci�n Embarazo:");
                report.setHrecdescripcio2(ANTECEDENTES_MEDICACION);
                report.setHrencodigo(2);
                report.setHrentipoimpres(3);
                lstReporte.add(report);
            }

            if (ANTECEDENTES_PARTO != null && !ANTECEDENTES_PARTO.equals("")) {
                report = new Chreporte();
                report.setHrectipodescri("Antecedentes");
                report.setHrecdescripcio("Antecedentes parto:");
                report.setHrecdescripcio2(ANTECEDENTES_PARTO);
                report.setHrencodigo(2);
                report.setHrentipoimpres(3);
                lstReporte.add(report);
            }

            if (ANTECEDENTES_COMPLICACIONES != null && 
                !ANTECEDENTES_COMPLICACIONES.equals("")) {
                report = new Chreporte();
                report.setHrectipodescri("Antecedentes");
                report.setHrecdescripcio("Antecedentes complicaciones perinatales:");
                report.setHrecdescripcio2(ANTECEDENTES_COMPLICACIONES);
                report.setHrencodigo(2);
                report.setHrentipoimpres(3);
                lstReporte.add(report);
            }

            if (ANTECEDENTES_INMUNIZACIONES != null && 
                !ANTECEDENTES_INMUNIZACIONES.equals("")) {
                report = new Chreporte();
                report.setHrectipodescri("Antecedentes");
                report.setHrecdescripcio("Antecedentes Inmunizacion:");
                report.setHrecdescripcio2(ANTECEDENTES_INMUNIZACIONES);
                report.setHrencodigo(2);
                report.setHrentipoimpres(3);
                lstReporte.add(report);
            }

            if (ANTECEDENTES_SICOMOTOR != null && 
                !ANTECEDENTES_SICOMOTOR.equals("")) {
                report = new Chreporte();
                report.setHrectipodescri("Antecedentes");
                report.setHrecdescripcio("Antecedentes Desarrollo Sicomotor:");
                report.setHrecdescripcio2(ANTECEDENTES_SICOMOTOR);
                report.setHrencodigo(2);
                report.setHrentipoimpres(3);
                lstReporte.add(report);
            }

            if (ANTECEDENTES_ALIMENTACION != null && 
                !ANTECEDENTES_ALIMENTACION.equals("")) {
                report = new Chreporte();
                report.setHrectipodescri("Antecedentes");
                report.setHrecdescripcio("Antecedentes Alimentacion:");
                report.setHrecdescripcio2(ANTECEDENTES_ALIMENTACION);
                report.setHrencodigo(2);
                report.setHrentipoimpres(3);
                lstReporte.add(report);
            }

            if (ANTECEDENTES_HOSPITALIZACIONES != null && 
                !ANTECEDENTES_HOSPITALIZACIONES.equals("")) {
                report = new Chreporte();
                report.setHrectipodescri("Antecedentes");
                report.setHrecdescripcio("Antecedentes Hospitalizacion:");
                report.setHrecdescripcio2(ANTECEDENTES_HOSPITALIZACIONES);
                report.setHrencodigo(2);
                report.setHrentipoimpres(3);
                lstReporte.add(report);
            }


        }


        if (antecedenteGinecologico != null) {

            Chreporte report = new Chreporte();
            report = new Chreporte();
            report.setHrecdescripcio("Gestaciones:  " + 
                                     antecedenteGinecologico.getHagnnumgesta());
            report.setHrecdescripcio2("Partos:  " + 
                                      antecedenteGinecologico.getHagnnumparto());
            report.setHrecdescripcio3("Abortos:  " + 
                                      antecedenteGinecologico.getHagnnumaborto());
            report.setHrecdescripcio4("Cesareas:  " + 
                                      antecedenteGinecologico.getHagnnumcesare());
            report.setHrectipodescri("Antecedentes Ginecologicos");
            report.setHrentipoimpres(4);
            report.setHrencodigo(3);
            lstReporte.add(report);

            report = new Chreporte();
            report.setHrecdescripcio("Hijos Vivos:  " + 
                                     antecedenteGinecologico.getHagnnumvivo());
            report.setHrecdescripcio2("Ectopicos: " + 
                                      antecedenteGinecologico.getHagnectopico());
            report.setHrecdescripcio3("Hijos Muertos: " + 
                                      antecedenteGinecologico.getHagnmuerto());
            report.setHrecdescripcio4("Mortinatos: " + 
                                      antecedenteGinecologico.getHagnmortina());
            report.setHrectipodescri("Antecedentes Ginecologicos");
            report.setHrencodigo(3);
            report.setHrentipoimpres(4);

            lstReporte.add(report);


            report = new Chreporte();
            String descripcionTipoCiclo;
            descripcionTipoCiclo = "";
            if (antecedenteGinecologico.getHagetipciclo() != null && 
                antecedenteGinecologico.getHagetipciclo().equals("I")) {
                descripcionTipoCiclo = "Irregular";
            } else if (antecedenteGinecologico.getHagetipciclo() != null && 
                       antecedenteGinecologico.getHagetipciclo().equals("R")) {
                descripcionTipoCiclo = "Regular";
            } else if (antecedenteGinecologico.getHagetipciclo() != null && 
                       antecedenteGinecologico.getHagetipciclo().equals("N")) {
                descripcionTipoCiclo = "No Tiene Ciclos";
            }
            report.setHrecdescripcio("CICLOS: ");
            report.setHrecdescripcio2("Tipo: " + descripcionTipoCiclo);
            if (antecedenteGinecologico.getHagetipciclo() != null && 
                !antecedenteGinecologico.getHagetipciclo().equals("N")) {
                if (antecedenteGinecologico.getHagnfreciclo() != null) {
                    report.setHrecdescripcio3("Frecuencia: " + 
                                              formatearCampo(antecedenteGinecologico.getHagnfreciclo()) + 
                                              " - " + 
                                              formatearCampo(antecedenteGinecologico.getHagnfrefincicl()));
                }
                if (antecedenteGinecologico.getHagndurciclo() != null) {
                    report.setHrecdescripcio4("Duraci�n:  " + 
                                              formatearCampo(antecedenteGinecologico.getHagndurciclo()) + 
                                              " - " + 
                                              formatearCampo(antecedenteGinecologico.getHagndurfincicl()));
                }
            }
            report.setHrectipodescri("Antecedentes Ginecologicos");
            report.setHrencodigo(3);
            report.setHrentipoimpres(4);
            lstReporte.add(report);

            if (antecedenteGinecologico.getHagetipciclo() != null && 
                !antecedenteGinecologico.getHagetipciclo().equals("N")) {
                report = new Chreporte();
                report.setHrecdescripcio("Menarquia:  " + 
                                         antecedenteGinecologico.getHagnmenarquia());
                report.setHrecdescripcio2("Edad primera relaci�n : " + 
                                          antecedenteGinecologico.getHagnedadrelac());
                report.setHrecdescripcio3("");
                report.setHrecdescripcio4("");
                report.setHrectipodescri("Antecedentes Ginecologicos");
                report.setHrencodigo(3);
                report.setHrentipoimpres(4);
                lstReporte.add(report);

                String ultimaCitologia = "";
                if (antecedenteGinecologico.getHagcultcitolo() != null && 
                    antecedenteGinecologico.getHagcultcitolo().equals("NO")) {
                        ultimaCitologia = "Nunca";
                } else if (antecedenteGinecologico.getHagcultcitolo() != null && 
                           antecedenteGinecologico.getHagcultcitolo().equals("-1")) {
                    ultimaCitologia = "Hace menos de un ano";               
                } else if (antecedenteGinecologico.getHagcultcitolo() != null && 
                           antecedenteGinecologico.getHagcultcitolo().equals("+1")) {
                    ultimaCitologia = "Hace mas de un ano";               
                } else if (antecedenteGinecologico.getHagcultcitolo() != null && 
                           antecedenteGinecologico.getHagcultcitolo().equals("NR")) {
                    ultimaCitologia = "No recuerda";               
                }

                report = new Chreporte();
                if (antecedenteGinecologico.getHagdfur() != null) {
                    report.setHrecdescripcio("FUR:  " + 
                                             formatearCampo(antecedenteGinecologico.getHagdfur()));
                }
                if (antecedenteGinecologico.getHagdfup() != null) {
                    report.setHrecdescripcio2("FUP : " + 
                                              formatearCampo(antecedenteGinecologico.getHagdfup()));
                }
                if (antecedenteGinecologico.getHagdfuc() != null) {
                    report.setHrecdescripcio3("FUC : " + 
                                              formatearCampo(antecedenteGinecologico.getHagdfuc()));
                }
                if (antecedenteGinecologico.getHagcultcitolo() != null) {
                    report.setHrecdescripcio3("FUC : " + ultimaCitologia);
                }
                report.setHrecdescripcio4("");
                report.setHrectipodescri("Antecedentes Ginecologicos");
                report.setHrencodigo(3);
                report.setHrentipoimpres(4);
                lstReporte.add(report);


            }
            if (antecedenteGinecologico.getHagcmetodoplan() != null) {
                report = new Chreporte();
                String metodo = "";

                try {
                    metodo = 
                            serviceLocator.getClinicoService().getDescripcionMetodo(antecedenteGinecologico.getHagcmetodoplan());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (antecedenteGinecologico.getHagcmetodoplan().equals("0")) {
                    metodo = 
                            "OTRO: " + antecedenteGinecologico.getHagcotrometodo();
                }


                report.setHrecdescripcio("M�todo Planificaci�n:  " + 
                                         formatearCampo(metodo));
                report.setHrecdescripcio4("");
                report.setHrectipodescri("Antecedentes Ginecologicos");
                report.setHrencodigo(3);
                report.setHrentipoimpres(1);
                lstReporte.add(report);

                if (antecedenteGinecologico.getHagdfeultiapl() != null) {
                    report = new Chreporte();
                    report.setHrecdescripcio("Fecha de la �ltima aplicaci�n:  " + 
                                             formatearCampo(antecedenteGinecologico.getHagdfeultiapl()));
                    report.setHrecdescripcio4("");
                    report.setHrectipodescri("Antecedentes Ginecologicos");
                    report.setHrencodigo(3);
                    report.setHrentipoimpres(1);
                    lstReporte.add(report);
                }
            }

        }


        if ((antecedenteMama != null)) {

            boolean mostrarValoracion = false;

            Chreporte report = new Chreporte();
            if (antecedenteMama.getHamevalorant() != null && 
                antecedenteMama.getHamevalorant().equals("S")) {
                mostrarValoracion = true;
                report.setHrecdescripcio("Valoracion Clinica Anterior: Si ");
                if (antecedenteMama.getHamdfecvalant() != null) {
                    report.setHrecdescripcio2("Fecha Valoracion Anterior: " + 
                                              formatearCampo(antecedenteMama.getHamdfecvalant()));
                }

            } else {
                report.setHrecdescripcio("Valoracion Clinica Anterior: No ");
                report.setHrecdescripcio2("");
            }
            report.setHrectipodescri("Antecedentes Mama");
            report.setHrentipoimpres(6);
            report.setHrencodigo(4);
            lstReporte.add(report);

            if (mostrarValoracion) {
                report = new Chreporte();
                report.setHrecdescripcio("Resultado:  ");
                report.setHrecdescripcio2(antecedenteMama.getHamcresultado());
                report.setHrectipodescri("Antecedentes Mama");
                report.setHrentipoimpres(4);
                report.setHrencodigo(4);
                lstReporte.add(report);
            }
            // TODO: Traer la descripcion del Metodo de planificacion 
            boolean mostrarOtro = false;
            String metodo = "";
            String lactancia = "";
            if (antecedenteMama.getHamcmetodo() != null && 
                antecedenteMama.getHamcmetodo().equals("0")) {
                mostrarOtro = true;
                try {
                    metodo = 
                            serviceLocator.getClinicoService().getDescripcionMetodo(antecedenteMama.getHamcmetodo());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
            if (antecedenteMama.getHamnlactacum() != null) {
                if (antecedenteMama.getHamnlactacum().equals(1)) {
                    lactancia = " 1 a 5 meses ";
                }
                if (antecedenteMama.getHamnlactacum().equals(2)) {
                    lactancia = "6 a 11 meses";
                }
                if (antecedenteMama.getHamnlactacum().equals(3)) {
                    lactancia = " 1 a 2 anos";
                }
                if (antecedenteMama.getHamnlactacum().equals(4)) {
                    lactancia = ">2 anos";
                }
                if (antecedenteMama.getHamnlactacum().equals(5)) {
                    lactancia = " N/A";
                }
            }

            report = new Chreporte();
            report.setHrecdescripcio("Metodo:  " + metodo);
            report.setHrecdescripcio2("Lactancia Acumulada: " + lactancia);
            report.setHrectipodescri("Antecedentes Mama");
            report.setHrentipoimpres(6);
            report.setHrencodigo(4);
            lstReporte.add(report);

            if (mostrarOtro) {
                report = new Chreporte();
                report.setHrecdescripcio("Otro:  " + 
                                         antecedenteMama.getHamcotrometod());
                report.setHrecdescripcio2("");
                report.setHrectipodescri("Antecedentes Mama");
                report.setHrentipoimpres(6);
                report.setHrencodigo(4);
                lstReporte.add(report);
            }


        }


        if (encuesta != null) {
            Chreporte report = new Chreporte();

            String s = "";

            s = "Ha sufrido de violencia:  " + HA_SUFRIDO_VIOLENCIA;
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrectipodescri("Encuesta Violencia");
            report.setHrencodigo(5);
            report.setHrentipoimpres(1);
            lstReporte.add(report);

            if (HA_SUFRIDO_VIOLENCIA != null && 
                HA_SUFRIDO_VIOLENCIA.equals("S")) {
                VIOLENCIA_FISICA = formatearCampo(VIOLENCIA_FISICA);
                VIOLENCIA_PSICOLOGICA = formatearCampo(VIOLENCIA_PSICOLOGICA);
                VIOLENCIA_SEXUAL = formatearCampo(VIOLENCIA_SEXUAL);
                RIESGO_PERSONA_MALTRATA = 
                        formatearCampo(RIESGO_PERSONA_MALTRATA);
                ASESORIA_HABLAR = formatearCampo(ASESORIA_HABLAR);
                OBSERVACIONES_VIOLENCIA = 
                        formatearCampo(OBSERVACIONES_VIOLENCIA);


                report = new Chreporte();
                if (VIOLENCIA_FISICA != null && !VIOLENCIA_FISICA.equals("")) {
                    report.setHrecdescripcio("Fisica:  " + VIOLENCIA_FISICA);
                }
                if (VIOLENCIA_PSICOLOGICA != null && 
                    !VIOLENCIA_PSICOLOGICA.equals("")) {
                    report.setHrecdescripcio2("Psicologica: " + 
                                              VIOLENCIA_PSICOLOGICA);
                }
                if (VIOLENCIA_SEXUAL != null && !VIOLENCIA_SEXUAL.equals("")) {
                    report.setHrecdescripcio3("Sexual: " + VIOLENCIA_SEXUAL);
                }

                report.setHrectipodescri("Encuesta Violencia");
                report.setHrencodigo(5);
                report.setHrentipoimpres(4);
                lstReporte.add(report);

                s = 
  "�Se Siente en riesgo por la persona que lo maltrata :  " + RIESGO_PERSONA_MALTRATA;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrectipodescri("Encuesta Violencia");
                report.setHrencodigo(5);
                report.setHrentipoimpres(1);
                lstReporte.add(report);

                if (encuesta.getHvicrsgxquien() != null) {
                    s = "�Por Quien :  " + encuesta.getHvicrsgxquien();
                    report = new Chreporte();
                    report.setHrecdescripcio(s);
                    report.setHrectipodescri("Encuesta Violencia");
                    report.setHrencodigo(5);
                    report.setHrentipoimpres(1);
                    lstReporte.add(report);

                }


                s = 
  "�Desea asesor�a para hablar mas sobre el ausnto  :  " + ASESORIA_HABLAR;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrectipodescri("Encuesta Violencia");
                report.setHrencodigo(5);
                report.setHrentipoimpres(1);
                lstReporte.add(report);

                if (encuesta != null && encuesta.getHvilcualremisi() != null) {
                    report = new Chreporte();
                    report.setHrecdescripcio("Remitido a: " + 
                                             encuesta.getHvilcualremisi());
                    report.setHrectipodescri("Encuesta Violencia");
                    report.setHrencodigo(5);
                    report.setHrentipoimpres(1);
                    lstReporte.add(report);
                }
                if (encuesta != null && encuesta.getHvicremitidoa() != null && 
                    !encuesta.getHvicremitidoa().equals("0")) {
                    String remision;
                    remision = "";
                    try {
                        remision = 
                                this.getServiceLocator().getClinicoService().getDescripcionRemisionViolencia(encuesta.getHvicremitidoa());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    report = new Chreporte();
                    report.setHrecdescripcio("Remitido a: " + remision);
                    report.setHrectipodescri("Encuesta Violencia");
                    report.setHrencodigo(5);
                    report.setHrentipoimpres(1);
                    lstReporte.add(report);
                }

                s = "Observaciones  :  " + OBSERVACIONES_VIOLENCIA;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrectipodescri("Encuesta Violencia");
                report.setHrencodigo(5);
                report.setHrentipoimpres(1);
                lstReporte.add(report);

            }


        }


        if (riesgo != null) {
            Chreporte report = new Chreporte();
            report.setHrecdescripcio("Menarquia antes de los 12 anos:  " + 
                                     formatearCampo(riesgo.getHrmemenarantes()));
            report.setHrectipodescri("Riesgo de Mama");
            report.setHrencodigo(6);
            report.setHrentipoimpres(1);
            lstReporte.add(report);


            report = new Chreporte();
            report.setHrecdescripcio("Menopausia despues de los 50 anos:  " + 
                                     formatearCampo(riesgo.getHrmemenopadesp()));
            report.setHrectipodescri("Riesgo de Mama");
            report.setHrencodigo(6);
            report.setHrentipoimpres(1);
            lstReporte.add(report);


            report = new Chreporte();
            report.setHrecdescripcio("Primer Embarazo despues de los 30 anos:   " + 
                                     formatearCampo(riesgo.getHrmeembaradesp()));
            report.setHrectipodescri("Riesgo de Mama");
            report.setHrencodigo(6);
            report.setHrentipoimpres(1);
            lstReporte.add(report);


            report = new Chreporte();
            report.setHrecdescripcio("Terapia de reemplazo hormonal:    " + 
                                     formatearCampo(riesgo.getHrmeterahormon()));
            if (riesgo.getHrmeterahormon() != null && 
                riesgo.getHrmeterahormon().equals("S")) {
                report.setHrecdescripcio2("Cu�ntos A�os?:   " + 
                                          riesgo.getHrmnanosterap());
            } else {
                report.setHrecdescripcio2("");
            }
            report.setHrectipodescri("Riesgo de Mama");
            report.setHrencodigo(6);
            report.setHrentipoimpres(6);
            lstReporte.add(report);

            report = new Chreporte();
            report.setHrecdescripcio(".");
            report.setHrectipodescri("Riesgo de Mama");
            report.setHrencodigo(6);
            report.setHrentipoimpres(6);
            lstReporte.add(report);


            report = new Chreporte();
            report.setHrecdescripcio("Antecedente personal de cancer:    " + 
                                     formatearCampo(riesgo.getHrmeantecancer()));
            if (riesgo.getHrmccancerpers() != null && 
                riesgo.getHrmccancerpers().equals("S")) {
                report.setHrecdescripcio2("Tipo Cancer:    " + 
                                          formatearCampo(riesgo.getHrmccancerpers()));

            }
            report.setHrectipodescri("Riesgo de Mama");
            report.setHrencodigo(6);
            report.setHrentipoimpres(5);
            lstReporte.add(report);


            report = new Chreporte();
            report.setHrecdescripcio("Familiar con CA de mama:    " + 
                                     formatearCampo(riesgo.getHrmefamicancer()));
            if (riesgo.getHrmefamicancer() != null && 
                riesgo.getHrmefamicancer().equals("S")) {
                report.setHrecdescripcio2("Cual(es):    " + 
                                          formatearCampo(riesgo.getHrmccancerfami()));

            }
            report.setHrectipodescri("Riesgo de Mama");
            report.setHrencodigo(6);
            report.setHrentipoimpres(5);
            lstReporte.add(report);


            report.setHrectipodescri("Riesgo de Mama");
            report.setHrencodigo(6);
            report.setHrentipoimpres(4);
            lstReporte.add(report);


            report = new Chreporte();
            boolean mostrarAntecedenteBiopsa = false;
            String tieneAntecedenteBiopsa;
            String naturalezaBiopsa = "";
            if (riesgo.getHrmnantebiopma() != null) {
                tieneAntecedenteBiopsa = "S";
                mostrarAntecedenteBiopsa = true;
                if (riesgo.getHrmnantebiopma().equals(1)) {
                    naturalezaBiopsa = "Benigno";
                }
                if (riesgo.getHrmnantebiopma().equals(2)) {
                    naturalezaBiopsa = "CDIS";
                }
                if (riesgo.getHrmnantebiopma().equals(3)) {
                    naturalezaBiopsa = "CLIS";
                }
                if (riesgo.getHrmnantebiopma().equals(4)) {
                    naturalezaBiopsa = "Maligno";
                }
                if (riesgo.getHrmnantebiopma().equals(5)) {
                    naturalezaBiopsa = "Hiperplasia ductal o lobulillar";
                }

                if (riesgo.getHrmnantebiopma().equals(6)) {
                    naturalezaBiopsa = "No recuerda";
                }

            } else {
                tieneAntecedenteBiopsa = "N";
            }
            report.setHrecdescripcio("Antecedentes biopsa de mama: " + 
                                     formatearCampo(tieneAntecedenteBiopsa));
            if (mostrarAntecedenteBiopsa) {
                report.setHrecdescripcio2("Naturaleza Biopsa:  " + 
                                          formatearCampo(naturalezaBiopsa));
            }
            report.setHrectipodescri("Riesgo de Mama");
            report.setHrencodigo(6);
            report.setHrentipoimpres(6);
            lstReporte.add(report);


            if (riesgo.getHrmnlactacum() != null) {
                report = new Chreporte();
                String lactanciaAcumulada;
                lactanciaAcumulada = "";
                if (riesgo.getHrmnlactacum().equals(1)) {
                    lactanciaAcumulada = " 1 a 5 meses ";
                }
                if (riesgo.getHrmnlactacum().equals(2)) {
                    lactanciaAcumulada = " 6 a 11 meses ";
                }
                if (riesgo.getHrmnlactacum().equals(3)) {
                    lactanciaAcumulada = " 1 a 2 anos ";
                }
                if (riesgo.getHrmnlactacum().equals(4)) {
                    lactanciaAcumulada = " >2 anos ";
                }
                if (riesgo.getHrmnlactacum().equals(5)) {
                    lactanciaAcumulada = " N/A ";
                }

                report.setHrecdescripcio("Lactancia Acumulada: " + 
                                         lactanciaAcumulada);
                report.setHrectipodescri("Riesgo de Mama");
                report.setHrencodigo(6);
                report.setHrentipoimpres(1);
                lstReporte.add(report);
            }


        }

        // Examen Fisico Mama
        if (examenMama != null) {
            boolean mostrarAnormalDerecha = false;
            boolean mostrarAnormalIzquierda = false;
            Chreporte report = new Chreporte();
            String examenMamaDer = "";
            report.setHrectipodescri("Examen Mama");
            if (examenMama.getHemeexamamader() != null) {
                if (examenMama.getHemeexamamader().equals("A")) {
                    examenMamaDer = "Anormal";
                    mostrarAnormalDerecha = true;
                } else if (examenMama.getHemeexamamader().equals("N")) {
                    mostrarAnormalDerecha = false;
                    examenMamaDer = "Normal";
                }
            }
            report.setHrecdescripcio("Examen de Mama Derecha:  " + 
                                     examenMamaDer);
            report.setHrencodigo(7);
            report.setHrentipoimpres(1);
            lstReporte.add(report);


            if (mostrarAnormalDerecha) {

                report = new Chreporte();
                boolean mostrarPezonDerecho = false;
                boolean mostrarAxilaDerecha = false;
                if (examenMama.getHemelespezonde() != null && 
                    examenMama.getHemelespezonde().equals("S")) {
                    mostrarPezonDerecho = true;
                }

                if (examenMama.getHemelesionaxde() != null && 
                    examenMama.getHemelesionaxde().equals("S")) {
                    mostrarAxilaDerecha = true;
                }

                report.setHrectipodescri("Examen Mama");
                report.setHrecdescripcio("Pez�n:  " + 
                                         formatearCampo(examenMama.getHemelespezonde()));
                report.setHrencodigo(7);
                report.setHrentipoimpres(1);
                lstReporte.add(report);

                if (mostrarPezonDerecho) {
                    report = new Chreporte();
                    report.setHrectipodescri("Examen Mama");
                    report.setHrecdescripcio("Tipo Lesi�n Pez�n:  " + 
                                             formatearCampo(examenMama.getHemctipolepede()));
                    report.setHrencodigo(7);
                    report.setHrentipoimpres(1);
                    lstReporte.add(report);
                }


                report = new Chreporte();
                report.setHrectipodescri("Examen Mama");
                report.setHrecdescripcio("Mama:  " + 
                                         formatearCampo(examenMama.getHemelesimamade()));
                report.setHrencodigo(7);
                report.setHrentipoimpres(1);
                lstReporte.add(report);

                report = new Chreporte();
                report.setHrectipodescri("Examen Mama");
                report.setHrecdescripcio("Axila:  " + 
                                         formatearCampo(examenMama.getHemelesionaxde()));
                report.setHrencodigo(7);
                report.setHrentipoimpres(1);
                lstReporte.add(report);

                if (mostrarAxilaDerecha) {
                    report = new Chreporte();
                    report.setHrectipodescri("Examen Mama");
                    report.setHrecdescripcio("Tipo Lesi�n Axila:  " + 
                                             formatearCampo(examenMama.getHemctipolesaxde()));
                    report.setHrencodigo(7);
                    report.setHrentipoimpres(1);
                    lstReporte.add(report);
                }


                report = new Chreporte();
                String lesionpielDerecha = "";
                report.setHrectipodescri("Examen Mama");
                report.setHrecdescripcio("Lesi�n en piel:  " + 
                                         formatearCampo(examenMama.getHemelesipielde()));
                if (examenMama.getHemelesipielde() != null && 
                    examenMama.getHemelesipielde().equals("S")) {
                    if (examenMama.getHemetipolepide() != null && 
                        !examenMama.getHemetipolepide().equals("")) {
                        if (examenMama.getHemetipolepide().equals("E")) {
                            lesionpielDerecha = "Edema";
                        }
                        if (examenMama.getHemetipolepide().equals("R")) {
                            lesionpielDerecha = "Retracci�n";
                        }
                        if (examenMama.getHemetipolepide().equals("U")) {
                            lesionpielDerecha = "Ulcera";
                        }
                        report.setHrecdescripcio2("Tipo Lesi�n : " + 
                                                  lesionpielDerecha);
                    }
                }
                report.setHrencodigo(7);
                report.setHrentipoimpres(6);
                lstReporte.add(report);

                report = new Chreporte();
                String secrecionDerecha = "";
                String tipoSecrecionDerecha = "";
                report.setHrectipodescri("Examen Mama");
                if (examenMama.getHemesecreciode() != null) {
                    report.setHrecdescripcio("Tiene Secreci�n: Si ");
                    if (examenMama.getHemesecreciode().equals("P")) {
                        secrecionDerecha = "Presi�n";
                    }
                    if (examenMama.getHemesecreciode().equals("E")) {
                        secrecionDerecha = "Espontanea";
                    }

                    if (examenMama.getHemetiposecrde().equals("C")) {
                        tipoSecrecionDerecha = "Cristalina";
                    }
                    if (examenMama.getHemetiposecrde().equals("A")) {
                        tipoSecrecionDerecha = "Amarillenta";
                    }
                    if (examenMama.getHemetiposecrde().equals("S")) {
                        tipoSecrecionDerecha = "Sanguinolenta";
                    }
                    if (examenMama.getHemetiposecrde().equals("V")) {
                        tipoSecrecionDerecha = "Verdosa";
                    }
                    report.setHrecdescripcio2("Secreci�n:  " + 
                                              secrecionDerecha);
                    report.setHrecdescripcio3("Tipo Secreci�n:  " + 
                                              tipoSecrecionDerecha);
                } else {
                    report.setHrecdescripcio("Tiene Secreci�n: No");
                }
                report.setHrencodigo(7);
                report.setHrentipoimpres(5);
                lstReporte.add(report);


                report = new Chreporte();
                report.setHrectipodescri("Examen Mama");
                report.setHrecdescripcio("Masa:  " + 
                                         formatearCampo(examenMama.getHememasaderech()));
                if (examenMama.getHememasaderech() != null && 
                    examenMama.getHememasaderech().equals("S")) {
                    report.setHrecdescripcio2("Diametro apx en cm : " + 
                                              examenMama.getHemndiammasade());
                }
                report.setHrencodigo(7);
                report.setHrentipoimpres(6);
                lstReporte.add(report);

                report = new Chreporte();
                report.setHrectipodescri("Examen Mama");
                report.setHrecdescripcio("Dolorosa:  " + 
                                         formatearCampo(examenMama.getHemedolorosade()));
                report.setHrencodigo(7);
                report.setHrentipoimpres(1);
                lstReporte.add(report);

                if (examenMama.getHemedolorosade() != null && 
                    examenMama.getHemedolorosade().equals("S")) {

                    report = new Chreporte();
                    report.setHrectipodescri("Examen Mama");
                    report.setHrecdescripcio("Tipo Dolor:  " + 
                                             formatearCampo(examenMama.getHemctipodolode()));
                    report.setHrencodigo(7);
                    report.setHrentipoimpres(1);
                    lstReporte.add(report);

                }


            }

            report = new Chreporte();
            String examenMamaIzq = "";
            report.setHrectipodescri("Examen Mama");
            if (examenMama.getHemeexamamaizq() != null) {
                if (examenMama.getHemeexamamaizq().equals("A")) {
                    examenMamaIzq = "Anormal";
                    mostrarAnormalIzquierda = true;
                } else if (examenMama.getHemeexamamaizq().equals("N")) {
                    examenMamaIzq = "Normal";
                    mostrarAnormalIzquierda = false;
                }
            }
            report.setHrecdescripcio("Examen de Mama Izquierda:  " + 
                                     examenMamaIzq);
            report.setHrencodigo(7);
            report.setHrentipoimpres(1);
            lstReporte.add(report);

            if (mostrarAnormalIzquierda) {

                report = new Chreporte();
                boolean mostrarPezonIzquierdo = false;
                boolean mostrarAxilaIzquierda = false;
                if (examenMama.getHemelespezoniz() != null && 
                    examenMama.getHemelespezoniz().equals("S")) {
                    mostrarPezonIzquierdo = true;
                }

                if (examenMama.getHemelesionaxiz() != null && 
                    examenMama.getHemelesionaxiz().equals("S")) {
                    mostrarAxilaIzquierda = true;
                }

                report.setHrectipodescri("Examen Mama");
                report.setHrecdescripcio("Pez�n:  " + 
                                         formatearCampo(examenMama.getHemelespezoniz()));
                report.setHrencodigo(7);
                report.setHrentipoimpres(1);
                lstReporte.add(report);

                if (mostrarPezonIzquierdo) {
                    report = new Chreporte();
                    report.setHrectipodescri("Examen Mama");
                    report.setHrecdescripcio("Tipo Lesi�n Pez�n:  " + 
                                             formatearCampo(examenMama.getHemctipolepeiz()));
                    report.setHrencodigo(7);
                    report.setHrentipoimpres(1);
                    lstReporte.add(report);
                }


                report = new Chreporte();
                report.setHrectipodescri("Examen Mama");
                report.setHrecdescripcio("Mama:  " + 
                                         formatearCampo(examenMama.getHemelesimamaiz()));
                report.setHrencodigo(7);
                report.setHrentipoimpres(1);
                lstReporte.add(report);

                report = new Chreporte();
                report.setHrectipodescri("Examen Mama");
                report.setHrecdescripcio("Axila:  " + 
                                         formatearCampo(examenMama.getHemelesionaxiz()));
                report.setHrencodigo(7);
                report.setHrentipoimpres(1);
                lstReporte.add(report);

                if (mostrarAxilaIzquierda) {
                    report = new Chreporte();
                    report.setHrectipodescri("Examen Mama");
                    report.setHrecdescripcio("Tipo Lesi�n Axila:  " + 
                                             formatearCampo(examenMama.getHemctipolesaxiz()));
                    report.setHrencodigo(7);
                    report.setHrentipoimpres(1);
                    lstReporte.add(report);
                }


                report = new Chreporte();
                String lesionpielIzquierda = "";
                report.setHrectipodescri("Examen Mama");
                report.setHrecdescripcio("Lesi�n en piel:  " + 
                                         formatearCampo(examenMama.getHemelesipieliz()));
                if (examenMama.getHemelesipieliz() != null && 
                    examenMama.getHemelesipieliz().equals("S")) {
                    if (examenMama.getHemetipolepiiz() != null && 
                        !examenMama.getHemetipolepiiz().equals("")) {
                        if (examenMama.getHemetipolepiiz().equals("E")) {
                            lesionpielIzquierda = "Edema";
                        }
                        if (examenMama.getHemetipolepiiz().equals("R")) {
                            lesionpielIzquierda = "Retracci�n";
                        }
                        if (examenMama.getHemetipolepiiz().equals("U")) {
                            lesionpielIzquierda = "Ulcera";
                        }
                        report.setHrecdescripcio2("Tipo Lesi�n : " + 
                                                  lesionpielIzquierda);
                    }
                }
                report.setHrencodigo(7);
                report.setHrentipoimpres(6);
                lstReporte.add(report);

                report = new Chreporte();
                String secrecionIzquierda = "";
                String tipoSecrecionIzquierda = "";
                report.setHrectipodescri("Examen Mama");
                if (examenMama.getHemesecrecioiz() != null) {
                    report.setHrecdescripcio("Tiene Secreci�n: Si ");
                    if (examenMama.getHemesecrecioiz().equals("P")) {
                        secrecionIzquierda = "Presi�n";
                    }
                    if (examenMama.getHemesecrecioiz().equals("E")) {
                        secrecionIzquierda = "Espontanea";
                    }

                    if (examenMama.getHemetiposecriz().equals("C")) {
                        tipoSecrecionIzquierda = "Cristalina";
                    }
                    if (examenMama.getHemetiposecriz().equals("A")) {
                        tipoSecrecionIzquierda = "Amarillenta";
                    }
                    if (examenMama.getHemetiposecriz().equals("S")) {
                        tipoSecrecionIzquierda = "Sanguinolenta";
                    }
                    if (examenMama.getHemetiposecriz().equals("V")) {
                        tipoSecrecionIzquierda = "Verdosa";
                    }
                    report.setHrecdescripcio2("Secreci�n:  " + 
                                              secrecionIzquierda);
                    report.setHrecdescripcio3("Tipo Secreci�n:  " + 
                                              tipoSecrecionIzquierda);
                } else {
                    report.setHrecdescripcio("Tiene Secreci�n: No");
                }
                report.setHrencodigo(7);
                report.setHrentipoimpres(5);
                lstReporte.add(report);


                report = new Chreporte();
                report.setHrectipodescri("Examen Mama");
                report.setHrecdescripcio("Masa:  " + 
                                         formatearCampo(examenMama.getHememasaizquie()));
                if (examenMama.getHememasaizquie() != null && 
                    examenMama.getHememasaizquie().equals("S")) {
                    report.setHrecdescripcio2("Diametro apx en cm : " + 
                                              examenMama.getHemndiammasaiz());
                }
                report.setHrencodigo(7);
                report.setHrentipoimpres(6);
                lstReporte.add(report);

                report = new Chreporte();
                report.setHrectipodescri("Examen Mama");
                report.setHrecdescripcio("Dolorosa:  " + 
                                         formatearCampo(examenMama.getHemedolorosaiz()));
                report.setHrencodigo(7);
                report.setHrentipoimpres(1);
                lstReporte.add(report);

                if (examenMama.getHemedolorosaiz() != null && 
                    examenMama.getHemedolorosaiz().equals("S")) {

                    report = new Chreporte();
                    report.setHrectipodescri("Examen Mama");
                    report.setHrecdescripcio("Tipo Dolor:  " + 
                                             formatearCampo(examenMama.getHemctipodoloiz()));
                    report.setHrencodigo(7);
                    report.setHrentipoimpres(1);
                    lstReporte.add(report);

                }
            }

        }

        //Datos Examen Fisico

        if (examen != null) {
            Chreporte report = new Chreporte();
            report.setHrectipodescri("Examen Fisico");
            report.setHrecdescripcio("Presi�n Arterial:  " + PRESION_ARTERIAL);
            report.setHrecdescripcio2("Frecuencia Cardiaca: " + 
                                      FRECUENCIA_CARDIACA);
            report.setHrecdescripcio3("Frecuencia Respiratoria: " + 
                                      FRECUENCIA_RESPIRATORIA);
            report.setHrencodigo(8);
            report.setHrentipoimpres(5);
            lstReporte.add(report);

            report = new Chreporte();
            report.setHrectipodescri("Examen Fisico");
            report.setHrecdescripcio("Peso:  " + PESO);
            report.setHrecdescripcio2("Talla : " + TALLA);
            report.setHrecdescripcio3("IMC: " + examen.getHefaimc());
            report.setHrencodigo(8);
            report.setHrentipoimpres(5);
            lstReporte.add(report);


            report = new Chreporte();
            report.setHrectipodescri("Examen Fisico");
            if (LUGAR_TEMPERATURA != null) {
                report.setHrecdescripcio("Tipo Temperatura: " + 
                                     formatearCampo(LUGAR_TEMPERATURA));
                report.setHrecdescripcio2("Resultado: " + 
                                     formatearCampo(TIPO_TEMPERATURA));
                if (TEMPERATURA != null) {
                    report.setHrecdescripcio3("Temperatura : " + TEMPERATURA);
                } else {
                    report.setHrecdescripcio3("");
                }
                
            } else {
                report.setHrecdescripcio("Tipo Temperatura: " + 
                                     formatearCampo(TIPO_TEMPERATURA));
                if (TEMPERATURA != null) {
                    report.setHrecdescripcio2("Temperatura : " + TEMPERATURA);
                } else {
                    report.setHrecdescripcio2("");
                }
            }
            report.setHrencodigo(8);
            report.setHrentipoimpres(5);
            lstReporte.add(report);


            report = new Chreporte();
            report.setHrectipodescri("Examen Fisico");
            report.setHrecdescripcio("Hallazgos del Examen Fisico");
            report.setHrecdescripcio2(HALLAZGOS_EXAMEN_FISICO);
            report.setHrencodigo(8);
            report.setHrentipoimpres(3);
            lstReporte.add(report);


        }

        // Datos Examen Fisico Pediatria

        if (examenPediatria != null) {
            Chreporte report = new Chreporte();
            report.setHrectipodescri("Examen Pediatria");
            report.setHrecdescripcio("Composici�n Familiar:  " + 
                                     examenPediatria.getHpeccompofamil());
            report.setHrencodigo(9);
            report.setHrentipoimpres(1);
            lstReporte.add(report);


            report = new Chreporte();
            String estadoGeneral = "";
            if (examenPediatria.getHpeeestadogene() != null) {
                if (examenPediatria.getHpeeestadogene().equals("B")) {
                    estadoGeneral = "Bueno";
                }
                if (examenPediatria.getHpeeestadogene().equals("R")) {
                    estadoGeneral = "Regular";
                }
                if (examenPediatria.getHpeeestadogene().equals("M")) {
                    estadoGeneral = "Malo";
                }
            }
            report.setHrectipodescri("Examen Pediatria");
            report.setHrecdescripcio("Estado General:  " + estadoGeneral);
            report.setHrecdescripcio2("Estado Respiratorio Dificultad:  " + 
                                      formatearCampo(examenPediatria.getHpeeestadoresp()));
            report.setHrencodigo(9);
            report.setHrentipoimpres(6);
            lstReporte.add(report);

            report = new Chreporte();
            String estadoHidratacion = "";
            String estadoConciencia = "";
            if (examenPediatria.getHpeeestadohidr() != null) {
                if (examenPediatria.getHpeeestadohidr().equals("H")) {
                    estadoHidratacion = "Hidratado";
                }
                if (examenPediatria.getHpeeestadohidr().equals("D")) {
                    estadoHidratacion = "Deshidratado";
                }
            }

            if (examenPediatria.getHpeeestadoconc() != null) {
                if (examenPediatria.getHpeeestadoconc().equals("N")) {
                    estadoConciencia = "Normal";
                }
                if (examenPediatria.getHpeeestadoconc().equals("A")) {
                    estadoConciencia = "Alterado";
                }
            }
            report.setHrectipodescri("Examen Pediatria");
            report.setHrecdescripcio("Estado de Hidrataci�n:  " + 
                                     estadoHidratacion);
            report.setHrecdescripcio2("Estado de Conciencia:  " + 
                                      estadoConciencia);
            report.setHrencodigo(9);
            report.setHrentipoimpres(6);
            lstReporte.add(report);

            report = new Chreporte();
            report.setHrectipodescri("Examen Pediatria");
            report.setHrecdescripcio("Observaciones:  " + 
                                     examenPediatria.getHpecobservacio());
            report.setHrencodigo(9);
            report.setHrentipoimpres(1);
            lstReporte.add(report);

        }


        // Datos Impresi�n Diagnostica

        if (impresion != null) {

            Chreporte report = new Chreporte();

            String s = "";
            String descripcionTipo = "";
            if (impresion.getHidntipodiagn() != null && 
                impresion.getHidntipodiagn().equals(1)) {
                descripcionTipo = "Impresi�n Diagnostica";
            } else if (impresion.getHidntipodiagn() != null && 
                       impresion.getHidntipodiagn().equals(2)) {
                descripcionTipo = "Confirmado Nuevo";
            } else if (impresion.getHidntipodiagn() != null && 
                       impresion.getHidntipodiagn().equals(3)) {
                descripcionTipo = "Confirmado repetido";
            }

            s = "Tipo de Diagnostico:  " + descripcionTipo;
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrectipodescri("Impresi�n Diagnostica");
            report.setHrencodigo(10);
            report.setHrentipoimpres(1);
            lstReporte.add(report);

            s = "Diagnostico Principal:  " + DIAGNOSTICO_PRINCIPAL;
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrectipodescri("Impresi�n Diagnostica");
            report.setHrencodigo(10);
            report.setHrentipoimpres(1);
            lstReporte.add(report);

            if (DIAGNOSTICO_RELACIONADO1 != null && 
                !DIAGNOSTICO_RELACIONADO1.equals("")) {
                s = "Diagnostico Relacionado 1:  " + DIAGNOSTICO_RELACIONADO1;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrectipodescri("Impresi�n Diagnostica");
                report.setHrencodigo(10);
                report.setHrentipoimpres(1);
                lstReporte.add(report);
            }

            if (DIAGNOSTICO_RELACIONADO2 != null && 
                !DIAGNOSTICO_RELACIONADO2.equals("")) {
                s = "Diagnostico Relacionado 2:  " + DIAGNOSTICO_RELACIONADO2;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrectipodescri("Impresi�n Diagnostica");
                report.setHrencodigo(10);
                report.setHrentipoimpres(1);
                lstReporte.add(report);
            }

            if (DIAGNOSTICO_RELACIONADO3 != null && 
                !DIAGNOSTICO_RELACIONADO3.equals("")) {
                s = "Diagnostico Relacionado 3:  " + DIAGNOSTICO_RELACIONADO3;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrectipodescri("Impresi�n Diagnostica");
                report.setHrencodigo(10);
                report.setHrentipoimpres(1);
                lstReporte.add(report);

            }

            if (impresion.getHidtrecomen() != null) {
                s = "Observaciones:  " + impresion.getHidtrecomen();
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrectipodescri("Impresi�n Diagnostica");
                report.setHrencodigo(10);
                report.setHrentipoimpres(1);
                lstReporte.add(report);
            }
        }

        if (examenDiagnostico != null) {
            Chreporte report = new Chreporte();

            String metodoPaciente = "";
            String metodoSugerido = "";
            String metodoAUsar = "";
            try {
                metodoPaciente = 
                        serviceLocator.getClinicoService().getDescripcionMetodo(examenDiagnostico.getHedcmetodopaci());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            try {
                metodoSugerido = 
                        serviceLocator.getClinicoService().getDescripcionMetodo(examenDiagnostico.getHedcmetodosuge());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            try {
                metodoAUsar = 
                        serviceLocator.getClinicoService().getDescripcionMetodo(examenDiagnostico.getHedcmetodosoli());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (metodoPaciente != null && !metodoPaciente.equals("")) {
                report = new Chreporte();
                report.setHrecdescripcio("Metodo que el Paciente desea usar: " + 
                                         metodoPaciente);
                report.setHrectipodescri("Apoyo Diagnostico ");
                report.setHrencodigo(11);
                report.setHrentipoimpres(1);
                lstReporte.add(report);
            }


            if (examenDiagnostico.getHedccontraindi() != null) {
                report = new Chreporte();
                report.setHrecdescripcio("Contraindicaciones a M�todos Anticonceptivos -Especificar: " + 
                                         examenDiagnostico.getHedccontraindi());
                report.setHrectipodescri("Apoyo Diagnostico ");
                report.setHrencodigo(11);
                report.setHrentipoimpres(1);
                lstReporte.add(report);

            }

            report = new Chreporte();
            report.setHrecdescripcio("Metodo sugerido: " + metodoSugerido);
            report.setHrectipodescri("Apoyo Diagnostico ");
            report.setHrencodigo(11);
            report.setHrentipoimpres(1);
            lstReporte.add(report);


            report = new Chreporte();

            report.setHrecdescripcio("Dentro de los metodos anticonceptivos no contraindicados la paciente escoge libremente: " + 
                                     metodoAUsar);
            report.setHrencodigo(11);
            report.setHrentipoimpres(1);
            lstReporte.add(report);

        }


        if (controlConsulta != null) {
            Chreporte report = new Chreporte();
            report = new Chreporte();
            report.setHrecdescripcio("Control: " + 
                                     controlConsulta.getHcccdescripcio());
            report.setHrectipodescri("Consulta de Control");
            report.setHrencodigo(12);
            report.setHrentipoimpres(1);
            lstReporte.add(report);
        }

        // Datos Conducta

        if (conducta != null) {
            Chreporte report = new Chreporte();
            RECOMENDACIONES_CONDUCTA = 
                    formatearCampo(RECOMENDACIONES_CONDUCTA);
            report = new Chreporte();
            report.setHrecdescripcio("Recomendaciones Conducta: " + 
                                     RECOMENDACIONES_CONDUCTA);
           
            report.setHrectipodescri("Recomendaciones Conducta ");
            report.setHrencodigo(13);
            report.setHrentipoimpres(1);
            lstReporte.add(report);
        }

        if (incapacidad != null) {
            Chreporte report = new Chreporte();
            report = new Chreporte();
            report.setHrecdescripcio("Fecha Inicial: " + 
                                     FECHA_INICIAL_INCAPACIDAD);
            report.setHrecdescripcio2("Fecha Final: " + 
                                      FECHA_FINAL_INCAPACIDAD);
            report.setHrectipodescri("Incapacidad ");
            report.setHrencodigo(14);
            report.setHrentipoimpres(6);
            lstReporte.add(report);

            report = new Chreporte();
            report = new Chreporte();
            report.setHrecdescripcio("Tipo Incapacidad: " + TIPO_INCAPACIDAD);
            report.setHrecdescripcio2("Origen Incapacidad: " + 
                                      ORIGEN_INCAPACIDAD);
            report.setHrectipodescri("Incapacidad ");
            report.setHrencodigo(14);
            report.setHrentipoimpres(6);
            lstReporte.add(report);


        }

        // Datos Orden Cirugia

        if (orden != null) {

            Chreporte report = new Chreporte();
            report = new Chreporte();
            report.setHrecdescripcio("Intervenciones Propuestas : ");
            report.setHrectipodescri("Cirug�as y procedimientos ");
            report.setHrencodigo(15);
            report.setHrentipoimpres(1);
            lstReporte.add(report);

            StringTokenizer st = null;
            if (orden.getHoccintervenci() != null) {
                st = new StringTokenizer(orden.getHoccintervenci(), ",");
            }

            while (st.hasMoreTokens()) {
                String idCirugia = st.nextToken();
                String descirugia = null;
                try {
                    descirugia = 
                            this.serviceLocator.getClinicoService().getDescripcionCups(idCirugia);
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                report = new Chreporte();
                report.setHrecdescripcio(descirugia);
                report.setHrectipodescri("Cirug�as y procedimientos ");
                report.setHrencodigo(15);
                report.setHrentipoimpres(1);
                lstReporte.add(report);

            }


            report = new Chreporte();
            report.setHrecdescripcio("Observaciones: " + 
                                     orden.getHoccobservacio());
            report.setHrectipodescri("Cirug�as y procedimientos ");
            report.setHrencodigo(15);
            report.setHrentipoimpres(1);
            lstReporte.add(report);


            report = new Chreporte();
            String lugar = null;
            if (orden.getHocclugarinter() != null && 
                orden.getHocclugarinter().equals("C")) {
                lugar = "Consultorio";
            }
            if (orden.getHocclugarinter() != null && 
                orden.getHocclugarinter().equals("S")) {
                lugar = "Salas de Cirugia";
            }
            report.setHrecdescripcio("La Paciente acepta y entiende el procedimiento: " + 
                                     formatearCampo(orden.getHoccpaciacepta()));
            if (orden.getHoccpaciacepta() != null && 
                orden.getHoccpaciacepta().equals("S")) {
                report.setHrecdescripcio2("Lugar de realzaci�n del procedimiento: " + 
                                          lugar);
            } else {
                report.setHrecdescripcio2("");
            }

            report.setHrectipodescri("Cirug�as y procedimientos ");
            report.setHrencodigo(15);
            report.setHrentipoimpres(6);
            lstReporte.add(report);


            if (orden.getHocclugarinter() != null && 
                orden.getHocclugarinter().equals("S") && 
                orden.getHocntiempointe() != null) {

                report = new Chreporte();
                report.setHrecdescripcio("Tiempo Qx : " + 
                                         formatearCampo(orden.getHocntiempointe()) + 
                                         " Minutos");
                report.setHrectipodescri("Cirug�as y procedimientos ");
                report.setHrencodigo(15);
                report.setHrentipoimpres(1);
                lstReporte.add(report);


                report = new Chreporte();
                report.setHrecdescripcio("Fecha probable de cirugia: " + 
                                         formatearCampo(orden.getHocdfecprocir1()));
                report.setHrecdescripcio2("Hora: " + 
                                          getHoraFecha(orden.getHocdfecprocir1()));
                report.setHrectipodescri("Cirug�as y procedimientos ");
                report.setHrencodigo(15);
                report.setHrentipoimpres(6);
                lstReporte.add(report);


                report = new Chreporte();
                report.setHrecdescripcio("Fecha probable 2 de cirugia : " + 
                                         formatearCampo(orden.getHocdfecprocir2()));
                report.setHrecdescripcio2("Hora: " + 
                                          getHoraFecha(orden.getHocdfecprocir2()));
                report.setHrectipodescri("Cirug�as y procedimientos ");
                report.setHrencodigo(15);
                report.setHrentipoimpres(6);
                lstReporte.add(report);

                report = new Chreporte();
                String descripcionAnestesia;
                descripcionAnestesia = "";
                if (orden.getHocctipoaneste() != null && 
                    orden.getHocctipoaneste().equals("1")) {
                    descripcionAnestesia = "Controlada";
                } else if (orden.getHocctipoaneste() != null && 
                           orden.getHocctipoaneste().equals("2")) {
                    descripcionAnestesia = "General";
                } else if (orden.getHocctipoaneste() != null && 
                           orden.getHocctipoaneste().equals("3")) {
                    descripcionAnestesia = "Local";
                }
                report.setHrecdescripcio("Anestesia Solicitada : " + 
                                         descripcionAnestesia);
                report.setHrecdescripcio2("Ayudantia: " + 
                                          formatearCampo(orden.getHoceayudantia()));
                report.setHrectipodescri("Cirug�as y procedimientos ");
                report.setHrencodigo(15);
                report.setHrentipoimpres(6);
                lstReporte.add(report);


                report = new Chreporte();
                String descripcionEstancia;
                descripcionEstancia = "";
                if (orden.getHocctipoestanc() != null && 
                    orden.getHocctipoestanc().equals("A")) {
                    descripcionEstancia = "Ambulatoria";
                } else if (orden.getHocctipoestanc() != null && 
                           orden.getHocctipoestanc().equals("H")) {
                    descripcionEstancia = "Hospitalizaci�n";
                }
                report.setHrecdescripcio("Estancia  : " + descripcionEstancia);
                if (orden.getHocctipoestanc() != null && 
                    orden.getHocctipoestanc().equals("H")) {
                    report.setHrecdescripcio2("Dias: " + 
                                              orden.getHocndiasestanc());
                } else {
                    report.setHrecdescripcio2("");
                }

                report.setHrectipodescri("Cirug�as y procedimientos ");
                report.setHrencodigo(15);
                report.setHrentipoimpres(6);
                lstReporte.add(report);


                report = new Chreporte();
                report.setHrecdescripcio("Reserva de Sangre  : " + 
                                         formatearCampo(orden.getHoceresesangre()));
                if (orden.getHoceresesangre() != null && 
                    orden.getHoceresesangre().equals("S")) {
                    report.setHrecdescripcio2("Unidades: " + 
                                              orden.getHocnunidadsang());
                } else {
                    report.setHrecdescripcio2("");
                }
                report.setHrectipodescri("Cirug�as y procedimientos ");
                report.setHrencodigo(15);
                report.setHrentipoimpres(6);
                lstReporte.add(report);


                report = new Chreporte();
                String descripcionPatologia = "";
                if (orden.getHocctipopatolo() != null && 
                    orden.getHocctipopatolo().equals("BI")) {
                    descripcionPatologia = "Biopsia";
                } else if (orden.getHocctipopatolo() != null && 
                           orden.getHocctipopatolo().equals("BC")) {
                    descripcionPatologia = "Biopsa por Congelaci�n";
                } else if (orden.getHocctipopatolo() != null && 
                           orden.getHocctipopatolo().equals("CO")) {
                    descripcionPatologia = "Cono";
                } else if (orden.getHocctipopatolo() != null && 
                           orden.getHocctipopatolo().equals("OT")) {
                    descripcionPatologia = "Otro";
                } else if (orden.getHocctipopatolo() != null && 
                           orden.getHocctipopatolo().equals("PQ")) {
                    descripcionPatologia = "Pieza Qx";
                }
                report.setHrecdescripcio("Patologia  : " + 
                                         descripcionPatologia);
                if (orden.getHocctipopatolo() != null && 
                    orden.getHocctipopatolo().equals("BC")) {
                    report.setHrecdescripcio2("Descripci�n Biopsa: " + 
                                              orden.getHoccbiopsacong());
                } else if (orden.getHocctipopatolo() != null && 
                           orden.getHocctipopatolo().equals("OT")) {
                    report.setHrecdescripcio2("Cual: " + 
                                              formatearCampo(orden.getHoccotrapatolo()));
                } else {
                    report.setHrecdescripcio2("");
                }


                report.setHrectipodescri("Cirug�as y procedimientos ");
                report.setHrencodigo(15);
                report.setHrentipoimpres(6);
                lstReporte.add(report);


                report = new Chreporte();
                report.setHrecdescripcio("Programar Anestesiologo " + 
                                         formatearCampo(orden.getHoccprogramar()));
                report.setHrectipodescri("Cirug�as y procedimientos ");
                report.setHrencodigo(15);
                report.setHrentipoimpres(1);
                lstReporte.add(report);
            }


        }

        // Datos examenes Paraclinicos
        if (lstExamenesImagenes != null && !lstExamenesImagenes.isEmpty()) {

            Chreporte report = new Chreporte();

            if (FISIOLOGICOS != null && !FISIOLOGICOS.equals("")) {
                report = new Chreporte();
                report.setHrectipodescri("Examenes Paraclinicos");
                report.setHrecdescripcio("Electrofisiologicos:");
                report.setHrecdescripcio2(FISIOLOGICOS);
                report.setHrencodigo(16);
                report.setHrentipoimpres(3);
                lstReporte.add(report);
            }

            if (IMAGENES != null && !IMAGENES.equals("")) {
                report = new Chreporte();
                report.setHrectipodescri("Examenes Paraclinicos");
                report.setHrecdescripcio("Imagenes:");
                report.setHrecdescripcio2(IMAGENES);
                report.setHrencodigo(16);
                report.setHrentipoimpres(3);
                lstReporte.add(report);
            }

            if (LABORATORIOS != null && !LABORATORIOS.equals("")) {
                report = new Chreporte();
                report.setHrectipodescri("Examenes Paraclinicos");
                report.setHrecdescripcio("Laboratorios:");
                report.setHrecdescripcio2(LABORATORIOS);
                report.setHrencodigo(16);
                report.setHrentipoimpres(3);
                lstReporte.add(report);
            }


        }

        // Datos Referencia

        if (referencia != null) {
            Chreporte report = new Chreporte();
            report = new Chreporte();
            report.setHrectipodescri("Referencia");
            report.setHrecdescripcio("Tipo de Servicio: " + TIPO_SERVICIO);
            report.setHrencodigo(17);
            report.setHrentipoimpres(1);
            lstReporte.add(report);

            report = new Chreporte();
            report.setHrectipodescri("Referencia");
            report.setHrecdescripcio("Justificaci�n de la referencia  : " + 
                                     JUSTIFICACION_REFERENCIA);
            report.setHrencodigo(17);
            report.setHrentipoimpres(1);
            lstReporte.add(report);
        }

        // Datos Anatomia Patologica

        if (anatomia != null) {
            Chreporte report = new Chreporte();
            report = new Chreporte();
            report.setHrectipodescri("Anatomia Patologica");
            report.setHrecdescripcio("Origen de la pieza : " + ORIGEN_PIEZA);
            report.setHrencodigo(18);
            report.setHrentipoimpres(1);
            lstReporte.add(report);

        }

        // Datos Formula Medica

        if (lstFormula != null && !lstFormula.isEmpty()) {

            Iterator it = lstFormula.iterator();

            while (it.hasNext()) {
                Chformulamed formula = (Chformulamed)it.next();

                Chreporte report = new Chreporte();
                report = new Chreporte();
                report.setHrectipodescri("Prescripci�n M�dica");
                report.setHrecdescripcio("" + formula.getHfocmedicament());
                report.setHrencodigo(19);
                report.setHrentipoimpres(1);
                lstReporte.add(report);


                report = new Chreporte();
                report.setHrectipodescri("Prescripci�n M�dica");
                report.setHrecdescripcio("" + formula.getHfoctratramien());
                report.setHrencodigo(19);
                report.setHrentipoimpres(1);
                lstReporte.add(report);

                report = new Chreporte();
                report.setHrectipodescri("Prescripci�n M�dica");
                report.setHrecdescripcio("" + formula.getHfocviadministr());
                report.setHrecdescripcio2("Cantidad Requerida : " + 
                                          formula.getHfocadosis());
                report.setHrencodigo(19);
                report.setHrentipoimpres(6);
                lstReporte.add(report);

                report = new Chreporte();
                report.setHrectipodescri("Prescripci�n M�dica");
                report.setHrecdescripcio("Contraindicaciones/Observaciones : " + 
                                         formula.getHfoccontraindi());
                report.setHrencodigo(19);
                report.setHrentipoimpres(1);
                lstReporte.add(report);

            }

        }

        if (control != null) {
            Chreporte report = new Chreporte();
            report = new Chreporte();
            report.setHrectipodescri("Control");
            report.setHrecdescripcio("Fecha proximo Control: " + 
                                     FECHA_PROXIMO_CONTROL);
            report.setHrecdescripcio2("Hora proximo Control: " + 
                                      HORA_PROXIMO_CONTROL);
            report.setHrencodigo(20);
            report.setHrentipoimpres(6);
            lstReporte.add(report);
        }

        // Datos Notas Medicas

        if (lstnotaMedica != null && !lstnotaMedica.isEmpty()) {

            Chreporte report = new Chreporte();
            report = new Chreporte();
            report.setHrectipodescri("Nota M�dica");
            report.setHrecdescripcio("Notas Medicas : " + NOTA_MEDICA);
            report.setHrencodigo(21);
            report.setHrentipoimpres(1);
            lstReporte.add(report);
        }


        if (lstExamenesImagenes != null && !lstExamenesImagenes.isEmpty()) {
            Chexameimage imagenes = null;
            String observaciones = null;
            Iterator it = lstExamenesImagenes.iterator();

            while (it.hasNext()) {
                imagenes = (Chexameimage)it.next();
                observaciones = imagenes.getHeicobservacio();
                Chreporte report = new Chreporte();
                report = new Chreporte();
                report.setHrectipodescri("Examenes Imagenes");
                report.setHrecdescripcio(" " + 
                                         imagenes.getCpservicio().getCsvcnombre());
                report.setHrencodigo(22);
                report.setHrentipoimpres(1);
                lstReporte.add(report);
            }

            if (observaciones != null) {
                Chreporte report = new Chreporte();
                report = new Chreporte();
                report.setHrectipodescri("Examenes Imagenes");
                report.setHrecdescripcio("Observaciones: " + observaciones);
                report.setHrencodigo(22);
                report.setHrentipoimpres(1);
                lstReporte.add(report);
            }

        }

        if (lstExamenesElectrofisiologicos != null && 
            !lstExamenesElectrofisiologicos.isEmpty()) {
            Chexameelect electrofisiologicos = null;
            String observaciones = null;
            Iterator it = lstExamenesElectrofisiologicos.iterator();

            while (it.hasNext()) {
                electrofisiologicos = (Chexameelect)it.next();
                observaciones = electrofisiologicos.getHeecobservacio();
                Chreporte report = new Chreporte();
                report = new Chreporte();
                report.setHrectipodescri("Examenes Electrofisiologicos");
                report.setHrecdescripcio(" " + 
                                         electrofisiologicos.getCpservicio().getCsvcnombre());
                report.setHrencodigo(23);
                report.setHrentipoimpres(1);
                lstReporte.add(report);
            }

            if (observaciones != null) {
                Chreporte report = new Chreporte();
                report = new Chreporte();
                report.setHrectipodescri("Examenes Electrofisiologicos");
                report.setHrecdescripcio("Observaciones: " + observaciones);
                report.setHrencodigo(23);
                report.setHrentipoimpres(1);
                lstReporte.add(report);
            }

        }


        if (lstExamenesLaboratorios != null && 
            !lstExamenesLaboratorios.isEmpty()) {
            Chexamelabor laboratorios = null;
            String observaciones = null;
            Iterator it = lstExamenesLaboratorios.iterator();

            while (it.hasNext()) {
                laboratorios = (Chexamelabor)it.next();
                observaciones = laboratorios.getHelcobservacio();
                Chreporte report = new Chreporte();
                report = new Chreporte();
                report.setHrectipodescri("Examenes Laboratorios");
                report.setHrecdescripcio(" " + 
                                         laboratorios.getCpservicio().getCsvcnombre());
                report.setHrencodigo(24);
                report.setHrentipoimpres(1);
                lstReporte.add(report);
            }

            if (observaciones != null) {
                Chreporte report = new Chreporte();
                report = new Chreporte();
                report.setHrectipodescri("Examenes Laboratorios");
                report.setHrecdescripcio("Observaciones: " + observaciones);
                report.setHrencodigo(24);
                report.setHrentipoimpres(1);
                lstReporte.add(report);
            }

        }


        if (lstInterconsulta != null && !lstInterconsulta.isEmpty()) {
            Chremision interconsulta = null;

            Iterator it = lstInterconsulta.iterator();

            while (it.hasNext()) {
                interconsulta = (Chremision)it.next();
                Chreporte report = new Chreporte();
                String tipoRemision = null;
                try {
                    tipoRemision = 
                            this.getServiceLocator().getClinicoService().getDescripcionCups(interconsulta.getHrecservicio());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (tipoRemision == null) {
                    tipoRemision = "Servicio no encontrado";
                }
                report = new Chreporte();
                report.setHrectipodescri("Examenes Laboratorios");
                report.setHrecdescripcio("Tipo: " + tipoRemision);
                report.setHrecdescripcio2("Descripcion: " + 
                                          interconsulta.getHrecdescripcio());
                report.setHrencodigo(25);
                report.setHrentipoimpres(6);
                lstReporte.add(report);
            }


        }

        if (certificadoMedico != null) {
            Chreporte report = new Chreporte();
            report = new Chreporte();
            report.setHrectipodescri("Certificado M�dico");
            report.setHrecdescripcio("Se expidio certificado m�dico");
            report.setHrencodigo(26);
            report.setHrentipoimpres(1);
            lstReporte.add(report);
        }


        if (certificadoAsistencia != null) {
            Chreporte report = new Chreporte();
            report = new Chreporte();
            report.setHrectipodescri("Certificado Asistencia");
            report.setHrecdescripcio("Se expidio certificado de Asistencia");
            report.setHrencodigo(27);
            report.setHrentipoimpres(1);
            lstReporte.add(report);
        }

        if (hospitalizacion != null) {
            Chreporte report = new Chreporte();
            report = new Chreporte();
            report.setHrectipodescri("Remisi�n Hospitalizaci�n");
            report.setHrecdescripcio("Motivo de la Hospitalizaci�n: " + 
                                     hospitalizacion.getHrhcmotivhospi());
            report.setHrencodigo(28);
            report.setHrentipoimpres(1);
            lstReporte.add(report);

            report = new Chreporte();
            report.setHrectipodescri("Remisi�n Hospitalizaci�n");
            report.setHrecdescripcio("Plan de Manejo: " + 
                                     hospitalizacion.getHrhcplanmanejo());
            report.setHrencodigo(28);
            report.setHrentipoimpres(1);
            lstReporte.add(report);
        }

        if (reserva != null) {
            Chreporte report = new Chreporte();
            report = new Chreporte();


            report = new Chreporte();
            String tipoReserva;
            tipoReserva = null;
            if (reserva.getHrsetiporeserv() != null && 
                reserva.getHrsetiporeserv().equals("A")) {
                tipoReserva = "Autodonaci�n";
            }
            if (reserva.getHrsetiporeserv() != null && 
                reserva.getHrsetiporeserv().equals("H")) {
                tipoReserva = "Homologa";
            }
            report.setHrectipodescri("Reserva de Sangre");
            report.setHrecdescripcio("Tipo de Reserva: " + 
                                     formatearCampo(tipoReserva));
            report.setHrecdescripcio2("Componente a Reservar: " + 
                                      formatearCampo(reserva.getHrsecompreserv()));
            report.setHrecdescripcio3("Unidades: " + 
                                      reserva.getHrsncantidadre());
            report.setHrencodigo(29);
            report.setHrentipoimpres(5);
            lstReporte.add(report);


            report = new Chreporte();
            report.setHrectipodescri("Reserva de Sangre");
            report.setHrecdescripcio("Otros Componentes Sanguineos: " + 
                                     formatearCampo(reserva.getHrseotrcompsan()));
            if (reserva.getHrseotrcompsan() != null && 
                reserva.getHrseotrcompsan().equals("S")) {
                report.setHrecdescripcio2("Cuales: " + 
                                          formatearCampo(reserva.getHrsccuales()));
            }
            report.setHrecdescripcio3("Solicitud al Banco de Sangre: " + 
                                      reserva.getHrscsolbancsan());
            report.setHrencodigo(29);
            report.setHrentipoimpres(5);
            lstReporte.add(report);
        }

    }


    public void ImprimirFolio() {
        lstReporte = new ArrayList<Chreporte>();
        lstAntecedentes = new ArrayList<Chantecegene>();
        obtenerDatosReporte();
        this.index = -1;
        try {
            URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/consultarFolios.jasper");
            URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA); 
            URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL); 
            URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL); 
            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                byte[] bytes;
                
                JasperReport report = (JasperReport) JRLoader.loadObject(url); 

                bytes = 
                        JasperRunManager.runReportToPdf(report, parameters, 
                                                        (JRDataSource)this);


                PdfServletUtils.showPdfDocument(bytes, 
                                                "HistoriaClinica" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);

                generoHistoria = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }

    }


    /**
     * @return
     */
    public void visualizarConsulta() {

        JasperPrint jasperPrint;
        jasperPrint = null;
        lstReporte = new ArrayList<Chreporte>();
        lstAntecedentes = new ArrayList<Chantecegene>();
        obtenerDatosReporte();
        this.index = -1;

        try {

             URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/consultarFolios.jasper");
            ExternalContext externalContext = 
                FacesContext.getCurrentInstance().getExternalContext();
            HttpServletRequest request = 
                (HttpServletRequest)externalContext.getRequest();

            if (url != null) {

                Map parameters = new HashMap();
                JRHtmlExporter exporter = new JRHtmlExporter();
                JasperReport report = (JasperReport) JRLoader.loadObject(url); 
                
                jasperPrint = 
                        JasperFillManager.fillReport(report, parameters, 
                                                     (JRDataSource)this);
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, 
                                      jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_STRING_BUFFER, 
                                      sbuffer);


                exporter.setParameter(JRHtmlExporterParameter.IMAGES_MAP, 
                                      parameters);
                exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, 
                                      request.getContextPath() + 
                                      "/comun/imagenes?image=");

                exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, 
                                      Boolean.FALSE);
                exporter.setParameter(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, 
                                      Boolean.TRUE);
                exporter.setParameter(JRHtmlExporterParameter.CHARACTER_ENCODING, 
                                      "ISO-8859-9");
                exporter.setParameter(JRHtmlExporterParameter.HTML_FOOTER, "");
                exporter.setParameter(JRHtmlExporterParameter.HTML_HEADER, "");

                request.getSession().setAttribute("jasperPrint", jasperPrint);

            }
        } catch (Exception e) {

            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());

        }
    }

    public void setEsResumen(boolean esResumen) {
        this.esResumen = esResumen;
    }

    public boolean isEsResumen() {
        return esResumen;
    }


    public void resetDatos() {

        IMPRIMIO = "";
        NOMBRE = "";
        TIPO_DOCUMENTO = "";
        NUMERO_DOCUMENTO = null;
        FECHA_NACIMIENTO = null;
        EDAD = null;
        SEXO = "";
        DIRECCION = "";
        TELEFONO = "";
        CIUDAD = "";
        OCUPACION = "";
        ESTADO_CIVIL = "";
        RESPONSABLE = "";
        PARENTESCO_RESPONSABLE = "";
        TELEFONO_RESPONSABLE = "";
        FECHA_CONSULTA = "";
        NOMBRE_PROFESIONAL = "";
        CENTRO = "";
        CONSULTA_ACTUAL = "";
        DES_MOTIVO_CONSULTA = "";
        MOTIVO_CONSULTA = "";
        FINALIDAD = "";
        ENFERMEDAD_ACTUAL = "";
        NOMBRE_ACOMPANANTE = "";
        TELEFONO_ACOMPANANTE = "";


        SIN_ANTECEDENTES = "";
        ANTECEDENTE_ALERGICOS = "";
        ANTECEDENTES_FAMILIARES = "";
        ANTECEDENTES_ITS = "";
        ANTECEDENTES_PATOLOGICOS = "";
        ANTECEDENTES_QUIRURGICOS = "";
        ANTECEDENTES_TOXICOS = "";
        ANTECEDENTES_TRANSFUNCIONALES = "";
        ANTECEDENTES_TRAUMATICOS = "";
        ANTECEDENTES_FARMACOLOGICOS = "";
        ANTECEDENTES_MEDICACION = "";
        ANTECEDENTES_PARTO = "";
        ANTECEDENTES_COMPLICACIONES = "";
        ANTECEDENTES_INMUNIZACIONES = "";
        ANTECEDENTES_SICOMOTOR = "";
        ANTECEDENTES_ALIMENTACION = "";
        ANTECEDENTES_HOSPITALIZACIONES = "";


        HA_SUFRIDO_VIOLENCIA = "";
        VIOLENCIA_FISICA = "";
        VIOLENCIA_PSICOLOGICA = "";
        VIOLENCIA_SEXUAL = "";
        RIESGO_PERSONA_MALTRATA = "";
        ASESORIA_HABLAR = "";
        OBSERVACIONES_VIOLENCIA = "";
        PRESION_ARTERIAL = "";
        LUGAR_TEMPERATURA = null;
        TIPO_TEMPERATURA = "";
        FRECUENCIA_CARDIACA = null;
        FRECUENCIA_RESPIRATORIA = null;
        TALLA = null;
        PESO = null;
        TEMPERATURA = null;
        HALLAZGOS_EXAMEN_FISICO = "";
        DIAGNOSTICO_PRINCIPAL = "";
        DIAGNOSTICO_RELACIONADO1 = "";
        DIAGNOSTICO_RELACIONADO2 = "";
        DIAGNOSTICO_RELACIONADO3 = "";
        RECOMENDACIONES_CONDUCTA = "";
        FECHA_INICIAL_INCAPACIDAD = "";
        FECHA_FINAL_INCAPACIDAD = "";
        TIPO_INCAPACIDAD = "";
        ORIGEN_INCAPACIDAD = "";
        DIAS_INCAPACIDAD = null;

        // Atributos  examenes paraclinicos
        FISIOLOGICOS = "";
        IMAGENES = "";
        LABORATORIOS = "";

        // Atributos referencia

        TIPO_SERVICIO = "";
        NOMBRE_RESPONSABLE_REFERENCIA = "";
        DIRECCION_RESPONSABLE_REFERENCIA = "";
        TELEFONO_RESPONSABLE_REFERENCIA = "";
        ANAMNESIS = "";
        APOYO_DIAGNOSTICO = "";
        JUSTIFICACION_REFERENCIA = "";

        // Atributos ANATOMIA PATOLOGICA
        ORIGEN_PIEZA = "";

        // Atributos de control

        FECHA_PROXIMO_CONTROL = "";
        HORA_PROXIMO_CONTROL = "";
        // Atributo de nota medica
        NOTA_MEDICA = "";
        total = 0;
        index = -1;


    }


}
