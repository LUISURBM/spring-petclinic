package org.profamilia.hc.view.backing.clinico.consultorio;

import java.io.File;

import java.math.BigDecimal;

import java.net.URL;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chanatopatol;
import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chautoriserv;
import org.profamilia.hc.model.dto.Chcertmedico;
import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chconducta;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chcontrvasec;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chdetaldescr;
import org.profamilia.hc.model.dto.Chexameelect;
import org.profamilia.hc.model.dto.Chexameimage;
import org.profamilia.hc.model.dto.Chexamelabor;
import org.profamilia.hc.model.dto.Chexamfisico;
import org.profamilia.hc.model.dto.Chformulamed;
import org.profamilia.hc.model.dto.Chformulahos;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chincapacida;
import org.profamilia.hc.model.dto.Chordecirugi;
import org.profamilia.hc.model.dto.Chreferencia;
import org.profamilia.hc.model.dto.Chremision;
import org.profamilia.hc.model.dto.Chserviautor;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpempresa;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptipoespe;
import org.profamilia.hc.model.dto.Cptipoprof;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ExamLaboratorioUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.InterConsultaUsuarioBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.ConverterTextoNumero;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


public class ReimprimirDocumentosBean extends BaseBean implements JRDataSource {


    /** Alamcena la consulta a la cual se va a reimprimir los documentos*/
    private Chconsulta consulta;

    /** Almacen la lista de documentos que se pueden re Imprimir*/
    private List listTipoDocumento;

    /** Almacena el documento que se desea reimprimr*/
    private String documentoSelect;

    /** Almacena el usuario al cual pertenece la consulta seleccionada */
    private Chusuario usuario;

    /** Almacena true si hay algun documento por realizar */
    private boolean generoDocumento;

    /** */
    private int index = -1;

    private static int NUMERO_PATOLOGIAS = 1;
    
    private Chautoriserv autoserv;

    /**Almacena la lista de prescripci�n  */
    private List<Chformulamed> lstPrescripciones;
    
    /** Alamcena la lista de prescripci�n de Cirugia */
    private List<Chformulahos> lstPrescipcionesCiru;

    /** Lista que almacena las remisiones de Examenes de Laboratorio que se le ordenaron al usuario */
    private List<Chexamelabor> lstExamenesLaboratorio;

    /** Lista que almacena las remisiones de Examenes de Imagenes que se le ordenaron al usuario */
    private List<Chexameimage> lstExamenesImagenes;

    /** Lista que almacena las remisiones de Examenes Electrofisiologicos que se le ordenaron al usuario */
    private List<Chexameelect> lstExamenesElectrofisiologicos;

    /** Lista que almacena las remisiones de Interconsulta que se le ordenaron al usuario en la consulta seleccionada */
    private List<Chremision> lstInterconsulta;

    /** Lista que almacena los servicios solicitados para autorizaci�n */
    private List<Chserviautor> lstServiciosAutorizacion;
    
    private   String ESPECIALIDAD = null;
    
    private List lstInformacionClinica;


    /* Anatomia Patologica*/
    String CLINICA;
    String CIUDAD;
    Date FECHA;
    String NOMBRE;
    Integer EDAD;
    Long NUMERO_DOCUMENTO;
    Integer GESTACIONES;
    Integer PARTOS;
    Integer ABORTOS;
    Integer CESAREAS;
    Integer VIVOS;
    Date FECHA_REGLA;
    Date FECHA_PARTO;
    String ORIGEN_PIEZA;
    String NOMBRE_PROFESIONAL;
    String TIPOID_PROFESIONAL;
    BigDecimal NUMID_PROFESIONAL;

    /* Referencia Y ContraReferencia*/

     private String hallazgos;
    /** Almacena el objeto a perisistir*/
    private Chreferencia referencia;
    private Chimprdiag impresion; 

    String DIA;
    String MES;
    String ANO;
    String HORA;
    String TIPO_SERVICIO;
    String MINUTO;
    String ESTADO_CIVIL;
    String SEXO;
    String DIRECCION_USUARIO;
    String MUNICIPIO_USUARIO;
    String RESPONSABLE;
    String DIRECCION_RESPONSABLE;
    String TELEFONO_RESPONSABLE;
    String ANAMNESIS;
    String TENSION_ARTERIAL;
    Integer FRECUENCIA_CARDIACA;
    Integer FRECUENCIA_RESPIRATORIA;
    BigDecimal PESO;
    BigDecimal TEMPERATURA;
    String HALLAZGOS_EXAMEN_FISICO;
    String APOYO_DIAGNOSTICO;
    String JUSTIFICACION;
    String TIPO_DOCUMENTO;
    String DIAGNOSTICO_REFERENCIA;
    String COMPLICACIONES;
    String TRATAMIENTOS;
    String MOTIVO;
    String SERVICIO_SOLICITA;
    String LUGAR_PACIENTE;
    String FIJO_PROFESIONAL;
    String CELULAR_PROFESIONAL;
    String FIJO_RESPONSABLE;
    String CELULAR_RESPONSABLE;
    String MUNICIPIO_RESPONSABLE;
    String DEPARTAMENTO_RESPONSABLE;
    String TIPO_IDEN_RESPON;
    String NUMERO_IDEN_RESP;
    String NOMBRE_RESPONSABLE;
    String ENTIDAD_PACIENTE;
    String REGIMEN_PACIENTE;
    String FIJO_PACIENTE;
    String CELUAR_PACIENTE;
    String CORREO_PACIENTE;
    String DIRECCION_PACIENTE;
    String MUNICIPIO_PACIENTE;
    String DEPARTAMENTO_PACIENTE;
    String TIPO_IDEN_PACIENTE;
    String NUM_IDE_PACIENTE;
    String FECHA_NAC_PACIENTE;
    String NOMBRE_PACIENTE;
    String MAIL_PRESTADOR;
    String MUNICIPIO_PRESTADOR;
    String DPTO_PRESTADOR;
    String TEL_PRESTADOR;
    String CODIGO_PRESTADOR;
    String DIRECCION_PRESTADOR;
    String NOMBRE_PROFESIONAL_COMPLETO;
    String CORREO_PRESTADOR;
    String PREGUNTA_DILIGENCIA_FORMATO;
    String PREGUNTA_COPIA_HISTORIA;
    String PREGUNTA_RESUL_APOYO;
    String PREGUNTA_CARTA_PAGO;
    Date FECHA_REFERENCIA = null;
    String EPS = ""; 
    String EVOLUCION = "";

    

    // Cirug�as y procedimientos


    String HORA_SISTEMA;
    String INTERVENCION;
    Integer TIEMPO_CIRUGIA;
    String HORA_CIRUGIA1;
    String HORA_CIRUGIA2;
    String DIA_CIRUGIA1;
    String DIA_CIRUGIA2;
    String MES_CIRUGIA1;
    String MES_CIRUGIA2;
    String ANO_CIRUGIA1;
    String ANO_CIRUGIA2;
    String ANESTESIA_SOLICITADA;
    String ESTANCIA;
    String DIAS;
    Integer DIAS_ESTANCIA;
    String AYUDANTIA;
    String RESERVA_SANGRE;
    Integer NUMERO_UNIDADES;
    String PATOLOGIA;
    String NOMBRE_CIRUJANO;
    String PROGRAMAR;
    String RESULTADO_ESPERMOGRAMA;

    // Formulaci�n Medica

    String NOMBRES;
    String APELLIDOS;
    String DIAGNOSTICO_PRINCIPAL;
    String DIAGNOSTICO_SECUNDARIO;
    String CODIGO_CIE10;
    String TIPO_USUARIO;
    Date fecha;
    String CONTRAINDICACIONES = "";
    String REGISTRO_MEDICO = "";

    // Incapacidad

    String CODIGO_CIE10_PRINCIPAL;
    String CODIGO_CIE10_SECUNDARIO;
    String DESC_SERVICIO;
    String CODIGO_CUPS;
    int DURACION;
    String TIPO_INCAPACIDAD;
    String ORIGEN_INCAPACIDAD;
    Date FECHA_INICIAL_INCAPACIDAD;
    Date FECHA_FINAL_INCAPACIDAD;

    // Examenes de Laboratorio, Imagenes, Electrofisiologicos

    String PRIMER_APELLIDO;
    String SEGUNDO_APELLIDO;
    String OBSERVACIONES_EXAMENES;

    // Control Sin Costo

    String HORA_CONTROL;
    String MINUTO_CONTROL;
    
    // CERTIFICADO DE ASISTENCIA
    
     String DESCRIPCION_CERTIFICADO;

     String NOMBRE_USUARIO;

     String DESCRIPCION_FECHA;

     String DESCRIPCION_HORA;

     String NOMBRE_ACOMPANANTE;

     String TIPO_DOCUMENTO_ACOMPANANTE;

     Long NUMERO_DOCUMENTO_ACOMPANANTE;
     
     // RECOMENDACIONES
     
    String DESCRIPCION_RECOMENDACIONES;

    // AUTORIZACION DE SERVICIOS
     Integer CONSECUTIVO;
     String NOMBRE1;
     String NOMBRE2;
     String APELLIDO1;
     String APELLIDO2;
     String NOMBRE_SOLICITANTE;
     String NIT_SOLICITANTE;
     String CODMUNICIPIO_PRESTADOR;
     String DEPARTAMENTO_PRESTADOR;
     String ENTIDAD_PAGO;
     String CODENTIDAD_PAGO;
     String TIPO_IDENTI;
     Date FECHA_NACIMIENTO;
     String DEPARTAMENTO;
     String CODCIUDAD;
     String TELEFONO_USUARIO;
     String CELULAR;
     String COBERTURA_SALUD;
     String ORIGEN_ATENCION;
     String TIPO_SERVICIOS;
     String PRIORIDAD_ATENCION;
     String UBICACION;
     String SERVICIO_HOS;
     Integer CAMA_HOS;
     String MANEJO_INTEGRAL;
     String SERVICIO_ACTUAL;
     String DESCRIPCION_SERVICIO;
     String CANTIDAD_SERVICIO;
     String JUSTIFICACION_CLINICA;
     String DIAGNOSTICO_RELACIONA1;
     String DIAGNOSTICO_RELACIONA2;
     String DESCRIPCION_PRINCIPAL;
     String DESCRIPCION_RELACIONA1;
     String DESCRIPCION_RELACIONA2;
     String CARGO_SOLICITASERV;
     String TEL_INFORMA;
     String EXT_INFORMA;
     String CEL_INFORMA;
    Integer CODIGO_ORIGEN;



    public ReimprimirDocumentosBean() {
    }


    public void init() {
        generoDocumento = false;
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
     * @param listTipoDocumento
     */
    public void setListTipoDocumento(List listTipoDocumento) {
        this.listTipoDocumento = listTipoDocumento;
    }

    /**
     * @return
     */
    public List getListTipoDocumento() {
        if (listTipoDocumento == null || listTipoDocumento.isEmpty() ) {
            listTipoDocumento = new ArrayList(); 
            listTipoDocumento.add(new SelectItem("", "Seleccione una opci�n"));
            if (consulta != null) {
                if (consulta.getChanatopatols() != null && !consulta.getChanatopatols().isEmpty()) {
                    listTipoDocumento.add(new SelectItem(CONDUCTA_ANATOMIA_PATOLOGICA, 
                                                         "Anatomia Patologica"));
                }
                if (consulta.getChreferencias() != null && !consulta.getChreferencias().isEmpty()) {
                    listTipoDocumento.add(new SelectItem(CONDUCTA_REFERENCIA, 
                                                         "Referencia"));
                }
                if (consulta.getChordecirugis() != null && !consulta.getChordecirugis().isEmpty()) {
                    listTipoDocumento.add(new SelectItem(CONDUCTA_ORDEN_CIRUGIA, 
                                                         "Cirug�as y procedimientos"));
                }
                if (consulta.getChformulameds() != null && !consulta.getChformulameds().isEmpty()) {
                    listTipoDocumento.add(new SelectItem(CONDUCTA_FORMULA_MEDICA, 
                                                         "Formula Medica"));
                }
                if(consulta.getChformulahos() != null && !consulta.getChformulahos().isEmpty() ){
                   listTipoDocumento.add(new SelectItem(CONDUCTA_FORMULA_MEDICA_CIRUGIA,
                                                    "Formula Medica Cirugia"));
                }
                if (consulta.getChincapacidas() != null && !consulta.getChincapacidas().isEmpty()) {
                    listTipoDocumento.add(new SelectItem(CONDUCTA_INCAPACIDAD, 
                                                         "Incapacidad"));
                }
                if (consulta.getChexameelects() != null && !consulta.getChexameelects().isEmpty()) {
                    listTipoDocumento.add(new SelectItem(CONDUCTA_EXAMENES_ELECTROFISIOLOGICOS, 
                                                         "Examenes Electrofisiologicos"));
                }
                if (consulta.getChexameimages() != null && !consulta.getChexameimages().isEmpty()) {
                    listTipoDocumento.add(new SelectItem(CONDUCTA_EXAMENES_IMAGENES, 
                                                         "Examenes Imagenes"));
                }
                if (consulta.getChexamelabors() != null && !consulta.getChexamelabors().isEmpty()) {
                    listTipoDocumento.add(new SelectItem(CONDUCTA_EXAMENES_LABORATORIOS, 
                                                         "Examenes Laboratorios"));
                }
                if (consulta.getChremisions() != null && !consulta.getChremisions().isEmpty()) {
                    listTipoDocumento.add(new SelectItem(CONDUCTA_INTERCONSULTA, 
                                                         "Interconsulta"));
                }
                if (consulta.getChcertmedicos() != null && !consulta.getChcertmedicos().isEmpty()) {
                    Iterator it = consulta.getChcertmedicos().iterator(); 
                    Chcertmedico certAux= null; 
                    while(it.hasNext()){
                        certAux = (Chcertmedico)it.next(); 
                        
                        if(certAux!= null && certAux.getId()!= null && 
                            certAux.getId().getHcmctipocert()!= null &&  certAux.getId().getHcmctipocert().equals(CERTIFICADO_MEDICO)){
                                listTipoDocumento.add(new SelectItem(CONDUCTA_CERTIFICADO_MEDICO, 
                                                                    "Certficado M�dico"));
                        }
                    }
                }
                
                if (consulta.getChcertmedicos() != null && !consulta.getChcertmedicos().isEmpty()) {
                    Iterator it = consulta.getChcertmedicos().iterator(); 
                    Chcertmedico certAux= null; 
                    
                    while(it.hasNext()){
                        certAux = (Chcertmedico)it.next(); 
                        if(certAux!= null && certAux.getId()!= null && 
                            certAux.getId().getHcmctipocert()!= null &&  certAux.getId().getHcmctipocert().equals(CERTIFICADO_ASISTENCIA)){
                                listTipoDocumento.add(new SelectItem(CONDUCTA_CERTIFICADO_ASISTENCIA, 
                                                                     "Certficado Asistencia"));
                            }
                    }
                }
                
                if (consulta.getChconductas() != null && !consulta.getChconductas().isEmpty()) {
                    listTipoDocumento.add(new SelectItem(CONDUCTA_RECOMENDACIONES, 
                                                         "Recomendaciones "));
                }
                
                try {
                    autoserv =
                        this.getServiceLocator().getClinicoService().getAutorizacion(consulta.getHcolnumero());
                    if (autoserv != null) {
                        listTipoDocumento.add(new SelectItem(CONDUCTA_AUTORIZACION_SERVICIO, 
                                                             "Autorizaci�n de Servicios"));
                    }
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
        }
        return listTipoDocumento;
    }

    /**
     * @param documentoSelect
     */
    public void setDocumentoSelect(String documentoSelect) {
        this.documentoSelect = documentoSelect;
    }

    /**
     * @return
     */
    public String getDocumentoSelect() {
        return documentoSelect;
    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setGeneroDocumento(boolean generoDocumento) {
        this.generoDocumento = generoDocumento;
    }

    public boolean isGeneroDocumento() {
        return generoDocumento;
    }

    /**
     * @return
     */
    public boolean next() {
        index++;
        if (documentoSelect != null && 
            documentoSelect.equals(CONDUCTA_FORMULA_MEDICA)) {
            return (index < lstPrescripciones.size());
        }
        if (documentoSelect != null && 
            documentoSelect.equals(CONDUCTA_EXAMENES_LABORATORIOS)) {
            return (index < lstExamenesLaboratorio.size());
        }
        if (documentoSelect != null && 
            documentoSelect.equals(CONDUCTA_EXAMENES_IMAGENES)) {
            return (index < lstExamenesImagenes.size());
        }
        if (documentoSelect != null && 
            documentoSelect.equals(CONDUCTA_EXAMENES_ELECTROFISIOLOGICOS)) {
            return (index < lstExamenesElectrofisiologicos.size());
        }
        if (documentoSelect != null && 
            documentoSelect.equals(CONDUCTA_INTERCONSULTA)) {
            return (index < lstInterconsulta.size());
        }
        if (documentoSelect != null &&
            documentoSelect.equals(CONDUCTA_AUTORIZACION_SERVICIO)) {
            return (index < lstServiciosAutorizacion.size());
        }        
        if (documentoSelect != null &&
            documentoSelect.equals(CONDUCTA_REFERENCIA)) {
            return (index < lstInformacionClinica.size());
        }
        
        return (index < NUMERO_PATOLOGIAS);
    }

    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();
        if (documentoSelect != null && documentoSelect.equals(CONDUCTA_ANATOMIA_PATOLOGICA)) {
            if (fieldName.equals("CLINICA")) {
                value = CLINICA;
            } else if (fieldName.equals("CIUDAD")) {
                value = CIUDAD;
            } else if (fieldName.equals("FECHA")) {
                value = new Date();
            } else if (fieldName.equals("NOMBRE")) {
                value = NOMBRE;
            } else if (fieldName.equals("EDAD")) {
                value = EDAD;
            } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
                value = NUMERO_DOCUMENTO;
            } else if (fieldName.equals("GESTACIONES")) {
                value = GESTACIONES;
            } else if (fieldName.equals("PARTOS")) {
                value = PARTOS;
            } else if (fieldName.equals("ABORTOS")) {
                value = ABORTOS;
            } else if (fieldName.equals("CESAREAS")) {
                value = CESAREAS;
            } else if (fieldName.equals("VIVOS")) {
                value = VIVOS;
            } else if (fieldName.equals("FECHA_REGLA")) {
                value = FECHA_REGLA;
            } else if (fieldName.equals("FECHA_PARTO")) {
                value = FECHA_PARTO;
            } else if (fieldName.equals("ORIGEN_PIEZA")) {
                value = ORIGEN_PIEZA;
            } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
                value = NOMBRE_PROFESIONAL;
            } else if (fieldName.equals("REGISTRO_MEDICO")) {
                value = REGISTRO_MEDICO;
            } else if (fieldName.equals("ESPECIALIDAD")) {
                value = ESPECIALIDAD;
            } else if (fieldName.equals("TIPOID_PROFESIONAL")) {
                value = TIPOID_PROFESIONAL;
            }else if (fieldName.equals("NUMID_PROFESIONAL")) {
                value = NUMID_PROFESIONAL;
            }
        }

        if (documentoSelect != null && documentoSelect.equals(CONDUCTA_REFERENCIA)) {
            if (fieldName.equals("FECHA")) {
                value = FECHA;
            } else if (fieldName.equals("ANAMNESIS")) {
                value = ANAMNESIS;
            } else if (fieldName.equals("HALLAZGOS_EXAMEN_FISICO")) {
                value = HALLAZGOS_EXAMEN_FISICO;
            } else if (fieldName.equals("APOYO_DIAGNOSTICO")) {
                value = APOYO_DIAGNOSTICO;
            } else if (fieldName.equals("DIAGNOSTICO")) {
                value = DIAGNOSTICO_REFERENCIA ;
            } else if (fieldName.equals("COMPLICACIONES")) {
                value = COMPLICACIONES ;
            } else if (fieldName.equals("TRATAMIENTOS")) {
                value = TRATAMIENTOS ;
            } else if (fieldName.equals("MOTIVO")) {
                value = MOTIVO ;
            } else if (fieldName.equals("SERVICIO_SOLICITA")) {
                value = SERVICIO_SOLICITA ;
            } 
            else if (fieldName.equals("FECHA_REFERENCIA")) {
                            value = FECHA_REFERENCIA ;
                        } 
            
            else if (fieldName.equals("LUGAR_PACIENTE")) {
                value =  LUGAR_PACIENTE;
            } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
                value = NOMBRE_PROFESIONAL;
            } else if (fieldName.equals("TIPOID_PROFESIONAL")) {
                    value = TIPOID_PROFESIONAL;
            }else if (fieldName.equals("NUMID_PROFESIONAL")) {
                    value = NUMID_PROFESIONAL;
            } else if (fieldName.equals("FIJO_PROFESIONAL")) {
                value = FIJO_PROFESIONAL;
            } else if (fieldName.equals("CELULAR_PROFESIONAL")) {
                value =CELULAR_PROFESIONAL;
            } else if (fieldName.equals("FIJO_RESPONSABLE")) {
                value =  FIJO_RESPONSABLE;
            } else if (fieldName.equals("CELULAR_RESPONSABLE")) {
                value = CELULAR_RESPONSABLE ;
            } else if (fieldName.equals("DIRECCION_RESPONSABLE")) {
                value = DIRECCION_RESPONSABLE;
            } else if (fieldName.equals("MUNICIPIO_RESPONSABLE")) {
                value =MUNICIPIO_RESPONSABLE ;
            } else if (fieldName.equals("DEPARTAMENTO_RESPONSABLE")) {
                value = DEPARTAMENTO_RESPONSABLE ;
            } else if (fieldName.equals("TIPO_IDEN_RESPON")) {
                value = TIPO_IDEN_RESPON ;
            } else if (fieldName.equals("NUMERO_IDEN_RESP")) {
                value = NUMERO_IDEN_RESP;
            } else if (fieldName.equals("NOMBRE_RESPONSABLE")) {
                value =  NOMBRE_RESPONSABLE;
            } else if (fieldName.equals("ENTIDAD_PACIENTE")) {
                value = ENTIDAD_PACIENTE;
            } else if (fieldName.equals("REGIMEN_PACIENTE")) {
                value = REGIMEN_PACIENTE;
            } else if (fieldName.equals("FIJO_PACIENTE")) {
                value = FIJO_PACIENTE ;
            } else if (fieldName.equals("CELUAR_PACIENTE")) {
                value = CELUAR_PACIENTE ;
            } else if (fieldName.equals("CORREO_PACIENTE")) {
                value = CORREO_PACIENTE;
            } else if (fieldName.equals("DIRECCION_PACIENTE")) {
                value = DIRECCION_PACIENTE ;
            } else if (fieldName.equals("MUNICIPIO_PACIENTE")) {
                value = MUNICIPIO_PACIENTE;
            } else if (fieldName.equals("DEPARTAMENTO_PACIENTE")) {
                value = DEPARTAMENTO_PACIENTE;
            } else if (fieldName.equals("TIPO_IDEN_PACIENTE")) {
                value = TIPO_IDEN_PACIENTE;
            } else if (fieldName.equals("NUM_IDE_PACIENTE")) {
                value = NUM_IDE_PACIENTE;
            } else if (fieldName.equals("FECHA_NAC_PACIENTE")) {
                value = FECHA_NAC_PACIENTE ;
            } else if (fieldName.equals("NOMBRE_PACIENTE")) {
                value =  NOMBRE_PACIENTE;
            } else if (fieldName.equals("MAIL_PRESTADOR")) {
                value = MAIL_PRESTADOR ;
            } else if (fieldName.equals("MUNICIPIO_PRESTADOR")) {
                value = MUNICIPIO_PRESTADOR;
            } else if (fieldName.equals("DPTO_PRESTADOR")) {
                value =  DPTO_PRESTADOR;
            } else if (fieldName.equals("TEL_PRESTADOR")) {
                value = TEL_PRESTADOR ;
            } else if (fieldName.equals("CODIGO_PRESTADOR")) {
                value = CODIGO_PRESTADOR;
            } else if (fieldName.equals("DIRECCION_PRESTADOR")) {
                value = DIRECCION_PRESTADOR ;
            } else if (fieldName.equals("NOMBRE_PROFESIONAL_COMPLETO")) {
                value = NOMBRE_PROFESIONAL_COMPLETO ;
            } else if (fieldName.equals("PREGUNTA_DILIGENCIA_FORMATO")) {
                value = PREGUNTA_DILIGENCIA_FORMATO ;
            } else if (fieldName.equals("PREGUNTA_COPIA_HISTORIA")) {
                value = PREGUNTA_COPIA_HISTORIA ;
            } else if (fieldName.equals("PREGUNTA_RESUL_APOYO")) {
                value = PREGUNTA_RESUL_APOYO ;
            } else if (fieldName.equals("PREGUNTA_CARTA_PAGO")) {
                value = PREGUNTA_CARTA_PAGO ;
            }else if (fieldName.equals("INFORMACION_CLINICA")) {
                value =lstInformacionClinica.get(index) ;
            }else if (fieldName.equals("TIPO_INFORMACION")) {
                value = value =index ;
            }
            
        }

        if (documentoSelect != null && documentoSelect.equals(CONDUCTA_ORDEN_CIRUGIA)) {
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
            } else if (fieldName.equals("DIA_CIRUGIA1")) {
                value = DIA_CIRUGIA1;
            } else if (fieldName.equals("DIA_CIRUGIA2")) {
                value = DIA_CIRUGIA2;
            } else if (fieldName.equals("MES_CIRUGIA1")) {
                value = MES_CIRUGIA1;
            } else if (fieldName.equals("MES_CIRUGIA2")) {
                value = MES_CIRUGIA2;
            } else if (fieldName.equals("ANO_CIRUGIA1")) {
                value = ANO_CIRUGIA1;
            } else if (fieldName.equals("ANO_CIRUGIA2")) {
                value = ANO_CIRUGIA2;
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
                value = NOMBRE;
            } else if (fieldName.equals("NOMBRE_CIRUJANO")) {
                value = NOMBRE_CIRUJANO;
            } else if (fieldName.equals("EDAD")) {
                value = EDAD;
            } else if (fieldName.equals("PROGRAMAR")) {
                value = PROGRAMAR;
            } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
                value = NUMERO_DOCUMENTO;
            } else if (fieldName.equals("HORA_CIRUGIA1")) {
                value = HORA_CIRUGIA1;
            } else if (fieldName.equals("HORA_CIRUGIA2")) {
                value = HORA_CIRUGIA2;
            } else if (fieldName.equals("HORA_SISTEMA")) {
                value = HORA_SISTEMA;
            } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
                value = NOMBRE_PROFESIONAL;
            } else if (fieldName.equals("REGISTRO_MEDICO")) {
                value = REGISTRO_MEDICO;
            }else if (fieldName.equals("ESPECIALIDAD")) {
                value = ESPECIALIDAD;
            }else if (fieldName.equals("TIPOID_PROFESIONAL")) {
                value = TIPOID_PROFESIONAL;
            }else if (fieldName.equals("NUMID_PROFESIONAL")) {
                value = NUMID_PROFESIONAL;
            }
        }

        if (documentoSelect != null && documentoSelect.equals(CONDUCTA_FORMULA_MEDICA)) {
            Chformulamed formulaAux = lstPrescripciones.get(index);
            if (fieldName.equals("APELLIDOS")) {
                value = APELLIDOS;
            } else if (fieldName.equals("NOMBRES")) {
                value = NOMBRES;
            } else if (fieldName.equals("TIPO_USUARIO")) {
                value = TIPO_USUARIO;
            } else if (fieldName.equals("FECHA")) {
                value = "FECHA";
            } else if (fieldName.equals("DIA")) {
                value = DIA;
            } else if (fieldName.equals("MES")) {
                value = MES;
            } else if (fieldName.equals("ANO")) {
                value = ANO;
            } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
                value = NUMERO_DOCUMENTO;
            } else if (fieldName.equals("MEDICAMENTO")) {
                value = (index + 1) + obtenerNombreMedicamento(formulaAux);
            } else if (fieldName.equals("TRATAMIENTO")) {
                value = obtenerNombreTratamiento(formulaAux) ;
            } else if (fieldName.equals("VIA_ADMINISTRACION")) {
                value = formatearCampoViaAdministracion(lstPrescripciones.get(index).getHfocviadministr());
            } else if (fieldName.equals("CANTIDAD_REQUERIDAD")) {
                value = calcularCantidad(this.lstPrescripciones.get(index).getHfocadosis(), this.lstPrescripciones.get(index).getHfonfrecuenc(), this.lstPrescripciones.get(index).getHfonduracion(),this.lstPrescripciones.get(index).getHfocfrecuenc(), this.lstPrescripciones.get(index).getHfocduracion());
            } else if (fieldName.equals("CODIGO_CIE10")) {
                value = CODIGO_CIE10;
            } else if (fieldName.equals("CONTRAINDICACIONES")) {
                CONTRAINDICACIONES = ""; 
                if (lstPrescripciones.get(index).getHfoccontraindi() != null && 
                      !lstPrescripciones.get(index).getHfoccontraindi().equals("")) {
                    CONTRAINDICACIONES = lstPrescripciones.get(index).getHfoccontraindi();
                }
                value = CONTRAINDICACIONES;
            } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
                value = NOMBRE_PROFESIONAL;
            } else if (fieldName.equals("REGISTRO_MEDICO")) {
                value = REGISTRO_MEDICO;
            } else if (fieldName.equals("ESPECIALIDAD")) {
                value = ESPECIALIDAD;
            }else if (fieldName.equals("TIPOID_PROFESIONAL")) {
                value = TIPOID_PROFESIONAL;
            }else if (fieldName.equals("NUMID_PROFESIONAL")) {
                value = NUMID_PROFESIONAL;
            }else if (fieldName.equals("CANTIDAD_REQUERIDAD_LETRAS")) {
                int cantidadRequerida = 0; 
                cantidadRequerida = calcularCantidad(this.lstPrescripciones.get(index).getHfocadosis(), this.lstPrescripciones.get(index).getHfonfrecuenc(), this.lstPrescripciones.get(index).getHfonduracion(),this.lstPrescripciones.get(index).getHfocfrecuenc(), this.lstPrescripciones.get(index).getHfocduracion());
                ConverterTextoNumero texto = new ConverterTextoNumero();
                value = texto.getStringOfNumber(cantidadRequerida) ;
            }
        }

        if (documentoSelect != null && documentoSelect.equals(CONDUCTA_INCAPACIDAD)) {
            if (fieldName.equals("Ciudad")) {
                value = CIUDAD;
            } else if (fieldName.equals("FechaExpedicion")) {
                value = FECHA;
            } else if (fieldName.equals("Nombres")) {
                value = NOMBRES;
            } else if (fieldName.equals("Apellidos")) {
                value = APELLIDOS;
            } else if (fieldName.equals("TipoDoc")) {
                value = TIPO_DOCUMENTO;
            } else if (fieldName.equals("NumeroDoc")) {
                value = NUMERO_DOCUMENTO;
            } else if (fieldName.equals("DiagnosticoPrincipal")) {
                value = DIAGNOSTICO_PRINCIPAL;
            } else if (fieldName.equals("CIE10Principal")) {
                value = CODIGO_CIE10_PRINCIPAL;
            } else if (fieldName.equals("DiagnosticoSecundario")) {
                value = DIAGNOSTICO_SECUNDARIO;
            } else if (fieldName.equals("CIE10Secundario")) {
                value = CODIGO_CIE10_SECUNDARIO;
            } else if (fieldName.equals("IntervencionProcedimiento")) {
                value = DESC_SERVICIO;
            } else if (fieldName.equals("CodigoCups")) {
                value = CODIGO_CUPS;
            } else if (fieldName.equals("FechaIni")) {
                value = FECHA_INICIAL_INCAPACIDAD;
            } else if (fieldName.equals("FechaFin")) {
                value = FECHA_FINAL_INCAPACIDAD;
            } else if (fieldName.equals("Duracion")) {
                value = DURACION;
            } else if (fieldName.equals("Prorroga")) {
                value = " ";
            } else if (fieldName.equals("TipoIncapacidad")) {
                value = TIPO_INCAPACIDAD;
            } else if (fieldName.equals("OrigenIncapacidad")) {
                value = ORIGEN_INCAPACIDAD;
            }else if (fieldName.equals("CODIGO_ORIGEN")) {
             value = CODIGO_ORIGEN;
         } 
            
            else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
                value = NOMBRE_PROFESIONAL;
            } else if (fieldName.equals("REGISTRO_MEDICO")) {
                    value = REGISTRO_MEDICO;
            }else if (fieldName.equals("ESPECIALIDAD")) {
                value = ESPECIALIDAD;
            } else if (fieldName.equals("TIPOID_PROFESIONAL")) {
                value = TIPOID_PROFESIONAL;
            }else if (fieldName.equals("NUMID_PROFESIONAL")) {
                value = NUMID_PROFESIONAL;
            }
        }

        if (documentoSelect != null && documentoSelect.equals(CONDUCTA_EXAMENES_LABORATORIOS)){
            if (fieldName.equals("APELLIDO1")) {
                value = PRIMER_APELLIDO;
            } else if (fieldName.equals("APELLIDO2")) {
                value = SEGUNDO_APELLIDO;
            } else if (fieldName.equals("NOMBRES")) {
                value = NOMBRES;
            } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
                value = NUMERO_DOCUMENTO;
            } else if (fieldName.equals("DIA")) {
                value = DIA;
            } else if (fieldName.equals("MES")) {
                value = MES;
            } else if (fieldName.equals("ANO")) {
                value = ANO;
            } else if (fieldName.equals("TIPO_REMISION")) {
                value = lstExamenesLaboratorio.get(index).getCpservicio().getCsvcnombre();
            }else         if (fieldName.equals("TIPO_REMISION")) {
        
        if(lstExamenesLaboratorio.get(index).getCpservicio().getCsvccodcups() != null && !lstExamenesLaboratorio.get(index).getCpservicio().getCsvccodcups() .equals("")){
            value = lstExamenesLaboratorio.get(index).getCpservicio().getCsvccodcups() + " "+lstExamenesLaboratorio.get(index).getCpservicio().getCsvcnombre();
        }else{
            value = lstExamenesLaboratorio.get(index).getCpservicio().getCsvccodigo() + " "+lstExamenesLaboratorio.get(index).getCpservicio().getCsvcnombre();
        }
            
            return value;
        } else if (fieldName.equals("DESCRIPCION_REMISION")) {
                value = OBSERVACIONES_EXAMENES;
            } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
                value = this.NOMBRE_PROFESIONAL;
            } else if (fieldName.equals("EDAD")) {
                value = EDAD;
            } else if (fieldName.equals("DIAGNOSTICO_PRINCIPAL")) {
                value = DIAGNOSTICO_PRINCIPAL;
            } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
                value = NOMBRE_PROFESIONAL;
            } else if (fieldName.equals("REGISTRO_MEDICO")) {
                value = REGISTRO_MEDICO;
            }else if (fieldName.equals("ESPECIALIDAD")) {
                value = ESPECIALIDAD;
            } else if (fieldName.equals("TIPOID_PROFESIONAL")) {
                    value = TIPOID_PROFESIONAL;
            }else if (fieldName.equals("NUMID_PROFESIONAL")) {
                    value = NUMID_PROFESIONAL;
            }
        }

        if (documentoSelect != null && documentoSelect.equals(CONDUCTA_EXAMENES_IMAGENES)) {
            if (fieldName.equals("APELLIDO1")) {
                value = PRIMER_APELLIDO;
            } else if (fieldName.equals("APELLIDO2")) {
                value = SEGUNDO_APELLIDO;
            } else if (fieldName.equals("NOMBRES")) {
                value = NOMBRES;
            } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
                value = NUMERO_DOCUMENTO;
            } else if (fieldName.equals("DIA")) {
                value = DIA;
            } else if (fieldName.equals("MES")) {
                value = MES;
            } else if (fieldName.equals("ANO")) {
                value = ANO;
            } else if (fieldName.equals("TIPO_REMISION")) {
                value = lstExamenesImagenes.get(index).getCpservicio().getCsvcnombre();
            } else if (fieldName.equals("DESCRIPCION_REMISION")) {
                value = OBSERVACIONES_EXAMENES;
            } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
                value = NOMBRE_PROFESIONAL;
            } else if (fieldName.equals("EDAD")) {
                value = EDAD;
            } else if (fieldName.equals("DIAGNOSTICO_PRINCIPAL")) {
                value = DIAGNOSTICO_PRINCIPAL;
            } else if (fieldName.equals("GESTACIONES")) {
                value = GESTACIONES;
            } else if (fieldName.equals("PARTOS")) {
                value = PARTOS;
            } else if (fieldName.equals("ABORTOS")) {
                value = ABORTOS;
            } else if (fieldName.equals("CESAREAS")) {
                value = CESAREAS;
            } else if (fieldName.equals("VIVOS")) {
                value = VIVOS;
            } else if (fieldName.equals("FECHA_REGLA")) {
                value = FECHA_REGLA;
            } else if (fieldName.equals("FECHA_PARTO")) {
                value = FECHA_PARTO;
            } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
                value = NOMBRE_PROFESIONAL;
            } else if (fieldName.equals("REGISTRO_MEDICO")) {
                value = REGISTRO_MEDICO;
            }else if (fieldName.equals("ESPECIALIDAD")) {
                value = ESPECIALIDAD;
            }else if (fieldName.equals("TIPOID_PROFESIONAL")) {
                value = TIPOID_PROFESIONAL;
            }else if (fieldName.equals("NUMID_PROFESIONAL")) {
                value = NUMID_PROFESIONAL;
            }
        }

        if (documentoSelect != null && documentoSelect.equals(CONDUCTA_EXAMENES_ELECTROFISIOLOGICOS)) {
            if (fieldName.equals("APELLIDO1")) {
                value = PRIMER_APELLIDO;
            } else if (fieldName.equals("APELLIDO2")) {
                value = SEGUNDO_APELLIDO;
            } else if (fieldName.equals("NOMBRES")) {
                value = NOMBRES;
            } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
                value = NUMERO_DOCUMENTO;
            } else if (fieldName.equals("DIA")) {
                value = DIA;
            } else if (fieldName.equals("MES")) {
                value = MES;
            } else if (fieldName.equals("ANO")) {
                value = ANO;
            } else if (fieldName.equals("TIPO_REMISION")) {
                value = lstExamenesElectrofisiologicos.get(index).getCpservicio().getCsvcnombre();
            } else if (fieldName.equals("DESCRIPCION_REMISION")) {
                value = OBSERVACIONES_EXAMENES;
            } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
                value = NOMBRE_PROFESIONAL;
            } else if (fieldName.equals("EDAD")) {
                value = EDAD;
            } else if (fieldName.equals("DIAGNOSTICO_PRINCIPAL")) {
                value = DIAGNOSTICO_PRINCIPAL;
            } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
                value = NOMBRE_PROFESIONAL;
            } else if (fieldName.equals("REGISTRO_MEDICO")) {
                value = REGISTRO_MEDICO;
            }else if (fieldName.equals("ESPECIALIDAD")) {
                value = ESPECIALIDAD;
           } else if (fieldName.equals("TIPOID_PROFESIONAL")) {
                    value = TIPOID_PROFESIONAL;
           }else if (fieldName.equals("NUMID_PROFESIONAL")) {
                    value = NUMID_PROFESIONAL;
           }
        }

        if (documentoSelect != null && documentoSelect.equals(CONDUCTA_INTERCONSULTA)) {
            if (fieldName.equals("APELLIDO1")) {
                value = PRIMER_APELLIDO;
            } else if (fieldName.equals("APELLIDO2")) {
                value = SEGUNDO_APELLIDO;
            } else if (fieldName.equals("NOMBRES")) {
                value = NOMBRES;
            } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
                value = NUMERO_DOCUMENTO;
            } else if (fieldName.equals("DIA")) {
                value = DIA;
            } else if (fieldName.equals("MES")) {
                value = MES;
            } else if (fieldName.equals("ANO")) {
                value = ANO;
            } else if (fieldName.equals("TIPO_CONSULTA")) {
                String valueObject = "";
                value = "";
                if (lstInterconsulta.get(index).getHrecservicio() != null) {
                    try {
                        valueObject = 
                                this.serviceLocator.getClinicoService().getDescripcionCups(lstInterconsulta.get(index).getHrecservicio());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                }

                if (valueObject != null && !valueObject.equals("")) {
                    valueObject = 
                            lstInterconsulta.get(index).getHrecservicio() + " " + valueObject;
                }

                value = valueObject;
            } else if (fieldName.equals("DESCRIPCION_CONSULTA")) {
                try {
                    value = 
                            serviceLocator.getClinicoService().getDescripcionCups(lstInterconsulta.get(index).getHrecservicio());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            } else if (fieldName.equals("DESCRIPCION_REMISION")) {
                value = lstInterconsulta.get(index).getHrecdescripcio();
            } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
                value = NOMBRE_PROFESIONAL;
            } else if (fieldName.equals("EDAD")) {
                value = EDAD;
            } else if (fieldName.equals("DIAGNOSTICO_PRINCIPAL")) {
                value = DIAGNOSTICO_PRINCIPAL;
            } else if (fieldName.equals("REGISTRO_MEDICO")) {
                value = REGISTRO_MEDICO;
            }else if (fieldName.equals("ESPECIALIDAD")) {
                value = ESPECIALIDAD;
            } else if (fieldName.equals("TIPOID_PROFESIONAL")) {
                    value = TIPOID_PROFESIONAL;
            }else if (fieldName.equals("NUMID_PROFESIONAL")) {
                    value = NUMID_PROFESIONAL;
            }
        }

        if (documentoSelect != null && documentoSelect.equals(CONDUCTA_CONTROL_SIN_COSTO)) {
            if (fieldName.equals("NUMERO_DOCUMENTO")) {
                value = NUMERO_DOCUMENTO;
            } else if (fieldName.equals("NOMBRE")) {
                value = NOMBRE;
            } else if (fieldName.equals("CODIGO_CUPS")) {
                value = CODIGO_CUPS;
            } else if (fieldName.equals("DIA")) {
                value = DIA;
            } else if (fieldName.equals("MES")) {
                value = MES;
            } else if (fieldName.equals("ANO")) {
                value = ANO;
            } else if (fieldName.equals("HORA")) {
                value = HORA_CONTROL;
            } else if (fieldName.equals("MINUTO")) {
                value = MINUTO_CONTROL;
            }else if (fieldName.equals("TIPOID_PROFESIONAL")) {
                value = TIPOID_PROFESIONAL;
            }else if (fieldName.equals("NUMID_PROFESIONAL")) {
                value = NUMID_PROFESIONAL;
            }
        }
        
        if (documentoSelect != null && documentoSelect.equals(CONDUCTA_CERTIFICADO_ASISTENCIA)) {
            if (fieldName.equals("APELLIDO1")) {
                value = PRIMER_APELLIDO;
            } else if (fieldName.equals("APELLIDO2")) {
                value = SEGUNDO_APELLIDO;
            } else if (fieldName.equals("NOMBRES")) {
                value = NOMBRES;
            } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
                value = NUMERO_DOCUMENTO;
            } else if (fieldName.equals("DIA")) {
                value = DIA;
            } else if (fieldName.equals("MES")) {
                value = MES;
            } else if (fieldName.equals("ANO")) {
                value = ANO;
            } else if (fieldName.equals("EDAD")) {
                value = EDAD;
            } else if (fieldName.equals("TIPO_DOCUMENTO")) {
                value = TIPO_DOCUMENTO;
            } else if (fieldName.equals("FECHA")) {
                value = new Date();
            } else if (fieldName.equals("DESCRIPCION_CERTIFICADO")) {
                value = DESCRIPCION_CERTIFICADO;
            } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
                value = NOMBRE_PROFESIONAL;
            } else if (fieldName.equals("EDAD")) {
                value = EDAD;
            } else if (fieldName.equals("NOMBRE_USUARIO")) {
                value = NOMBRE_USUARIO;
            } else if (fieldName.equals("DESCRIPCION_FECHA")) {
                value = DESCRIPCION_FECHA;
            } else if (fieldName.equals("DESC_SERVICIO")) {
                value = DESC_SERVICIO;
            } else if (fieldName.equals("DESCRIPCION_HORA")) {
                value = DESCRIPCION_HORA;
            } else if (fieldName.equals("NOMBRE_ACOMPANANTE")) {
                value = NOMBRE_ACOMPANANTE;
            } else if (fieldName.equals("TIPO_DOCUMENTO_ACOMPANANTE")) {
                value = TIPO_DOCUMENTO_ACOMPANANTE;
            } else if (fieldName.equals("NUMERO_DOCUMENTO_ACOMPANANTE")) {
                value = NUMERO_DOCUMENTO_ACOMPANANTE;
            } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
                value = NOMBRE_PROFESIONAL;
            } else if (fieldName.equals("REGISTRO_MEDICO")) {
                value = REGISTRO_MEDICO;
            }else if (fieldName.equals("ESPECIALIDAD")) {
                value = ESPECIALIDAD;
            } else if (fieldName.equals("TIPOID_PROFESIONAL")) {
                    value = TIPOID_PROFESIONAL;
            }else if (fieldName.equals("NUMID_PROFESIONAL")) {
                    value = NUMID_PROFESIONAL;
            }
        }
            
        if (documentoSelect != null && documentoSelect.equals(CONDUCTA_CERTIFICADO_MEDICO)) {
            if (fieldName.equals("APELLIDO1")) {
                value = PRIMER_APELLIDO;
            } else if (fieldName.equals("APELLIDO2")) {
                value = SEGUNDO_APELLIDO;
            } else if (fieldName.equals("NOMBRES")) {
                value = NOMBRES;
            } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
                value = NUMERO_DOCUMENTO;
            } else if (fieldName.equals("DIA")) {
                value = DIA;
            } else if (fieldName.equals("MES")) {
                value = MES;
            } else if (fieldName.equals("ANO")) {
                value = ANO;
            } else if (fieldName.equals("EDAD")) {
                value = EDAD;
            } else if (fieldName.equals("TIPO_DOCUMENTO")) {
                value = TIPO_DOCUMENTO;
            } else if (fieldName.equals("FECHA")) {
                value = new Date();
            } else if (fieldName.equals("DESCRIPCION_CERTIFICADO")) {
                value = DESCRIPCION_CERTIFICADO;
            } else if (fieldName.equals("EDAD")) {
                value = EDAD;
            } else if (fieldName.equals("NOMBRE_USUARIO")) {
                value = NOMBRE_USUARIO;
            } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
                value = NOMBRE_PROFESIONAL;
            } else if (fieldName.equals("REGISTRO_MEDICO")) {
                value = REGISTRO_MEDICO;
            }else if (fieldName.equals("ESPECIALIDAD")) {
                value = ESPECIALIDAD;
            } else if (fieldName.equals("TIPOID_PROFESIONAL")) {
                    value = TIPOID_PROFESIONAL;
            }else if (fieldName.equals("NUMID_PROFESIONAL")) {
                    value = NUMID_PROFESIONAL;
             }
       }
            
       if (documentoSelect != null && documentoSelect.equals(CONDUCTA_RECOMENDACIONES)) {
           if (fieldName.equals("APELLIDO1")) {
              value = PRIMER_APELLIDO;
           } else if (fieldName.equals("APELLIDO2")) {
              value = SEGUNDO_APELLIDO;
           } else if (fieldName.equals("NOMBRES")) {
              value = NOMBRES;
           } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
              value = NUMERO_DOCUMENTO;
           } else if (fieldName.equals("DIA")) {
              value = DIA;
           } else if (fieldName.equals("MES")) {
              value = MES;
           } else if (fieldName.equals("ANO")) {
              value = ANO;
           } else if (fieldName.equals("EDAD")) {
              value = EDAD;
           } else if (fieldName.equals("TIPO_DOCUMENTO")) {
              value = TIPO_DOCUMENTO;
           } else if (fieldName.equals("FECHA")) {
              value = new Date();
           } else if (fieldName.equals("RECOMENDACIONES")) {
              value = DESCRIPCION_RECOMENDACIONES;
           } else if (fieldName.equals("EDAD")) {
              value = EDAD;
           } else if (fieldName.equals("NOMBRE_USUARIO")) {
              value = NOMBRE_USUARIO;
           } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
              value = NOMBRE_PROFESIONAL;
           } else if (fieldName.equals("REGISTRO_MEDICO")) {
              value = REGISTRO_MEDICO;
           }else if (fieldName.equals("ESPECIALIDAD")) {
                value = ESPECIALIDAD;
            } else if (fieldName.equals("TIPOID_PROFESIONAL")) {
                    value = TIPOID_PROFESIONAL;
            }else if (fieldName.equals("NUMID_PROFESIONAL")) {
                    value = NUMID_PROFESIONAL;
                }
       }
       
       if (documentoSelect != null && documentoSelect.equals(CONDUCTA_AUTORIZACION_SERVICIO)) {
            if (fieldName.equals("FECHA")) {
                value = FECHA;
            } else if (fieldName.equals("CONSECUTIVO")) {
                value = CONSECUTIVO;
            } else if (fieldName.equals("NOMBRE_SOLICITANTE")) {
                value = NOMBRE_SOLICITANTE;
            } else if (fieldName.equals("NIT_SOLICITANTE")) {
                value = NIT_SOLICITANTE;
            } else if (fieldName.equals("CODIGO_PRESTADOR")) {
                value = CODIGO_PRESTADOR;
            } else if (fieldName.equals("DIRECCION_PRESTADOR")) {
                value = DIRECCION_PRESTADOR;
            } else if (fieldName.equals("TEL_PRESTADOR")) {
                value = TEL_PRESTADOR;
            } else if (fieldName.equals("CODMUNICIPIO_PRESTADOR")) {
                value = CODMUNICIPIO_PRESTADOR;
            } else if (fieldName.equals("DEPARTAMENTO_PRESTADOR")) {
                value = DEPARTAMENTO_PRESTADOR;
            } else if (fieldName.equals("MUNICIPIO_PRESTADOR")) {
                value = MUNICIPIO_PRESTADOR;
            } else if (fieldName.equals("ENTIDAD_PAGO")) {
                value = ENTIDAD_PAGO;
            } else if (fieldName.equals("CODENTIDAD_PAGO")) {
                value = CODENTIDAD_PAGO;
            } else if (fieldName.equals("APELLIDO1")) {
                value = APELLIDO1;
            } else if (fieldName.equals("APELLIDO2")) {
                value = APELLIDO2;
            } else if (fieldName.equals("NOMBRE1")) {
                value = NOMBRE1;
            } else if (fieldName.equals("NOMBRE2")) {
                value = NOMBRE2;
            } else if (fieldName.equals("TIPO_IDENTI")) {
                value = TIPO_IDENTI;
            } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
                value = NUMERO_DOCUMENTO;
            } else if (fieldName.equals("FECHA_NACIMIENTO")) {
                value = FECHA_NACIMIENTO;
            } else if (fieldName.equals("DIRECCION_USUARIO")) {
                value = DIRECCION_USUARIO;
            } else if (fieldName.equals("TELEFONO_USUARIO")) {
                value = TELEFONO_USUARIO;
            } else if (fieldName.equals("CELULAR")) {
                value = CELULAR;
            } else if (fieldName.equals("CORREO_PACIENTE")) {
                value = CORREO_PACIENTE;
            } else if (fieldName.equals("CODCIUDAD")) {
                value = CODCIUDAD;
            } else if (fieldName.equals("CIUDAD")) {
                value = CIUDAD;
            } else if (fieldName.equals("DEPARTAMENTO")) {
                value = DEPARTAMENTO;
            } else if (fieldName.equals("COBERTURA_SALUD")) {
                value = COBERTURA_SALUD;
            } else if (fieldName.equals("ORIGEN_ATENCION")) {
                value = ORIGEN_ATENCION;
            } else if (fieldName.equals("TIPO_SERVICIOS")) {
                value = TIPO_SERVICIOS;
            } else if (fieldName.equals("PRIORIDAD_ATENCION")) {
                value = PRIORIDAD_ATENCION;
            } else if (fieldName.equals("UBICACION")) {
                value = UBICACION;
            } else if (fieldName.equals("SERVICIO_HOS")) {
                value = SERVICIO_HOS;
            } else if (fieldName.equals("CAMA_HOS")) {
                value = CAMA_HOS;
            } else if (fieldName.equals("MANEJO_INTEGRAL")) {
                value = MANEJO_INTEGRAL;
            } else if (fieldName.equals("NUMITE")) {
                value = index + 1;
            } else if (fieldName.equals("CODIGO_CUPS")) {
                value = this.lstServiciosAutorizacion.get(index).getHsencodigocups();
            } else if (fieldName.equals("CANTIDAD_SERVICIO")) {
                value = this.lstServiciosAutorizacion.get(index).getHsencantiservi();
            } else if (fieldName.equals("DESCRIPCION_SERVICIO")) {
                value = this.lstServiciosAutorizacion.get(index).getHsecnombreserv();
            } else if (fieldName.equals("JUSTIFICACION_CLINICA")) {
                value = JUSTIFICACION_CLINICA;
            } else if (fieldName.equals("DIAGNOSTICO_PRINCIPAL")) {
                value = DIAGNOSTICO_PRINCIPAL;
            } else if (fieldName.equals("DESCRIPCION_PRINCIPAL")) {
                value = DESCRIPCION_PRINCIPAL;
            } else if (fieldName.equals("DIAGNOSTICO_RELACIONA1")) {
                value = DIAGNOSTICO_RELACIONA1;
            } else if (fieldName.equals("DESCRIPCION_RELACIONA1")) {
                value = DESCRIPCION_RELACIONA1;
            } else if (fieldName.equals("DIAGNOSTICO_RELACIONA2")) {
                value = DIAGNOSTICO_RELACIONA2;
            } else if (fieldName.equals("DESCRIPCION_RELACIONA2")) {
                value = DESCRIPCION_RELACIONA2;
            } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
                value = NOMBRE_PROFESIONAL;
           } else if (fieldName.equals("TIPOID_PROFESIONAL")) {
                    value = TIPOID_PROFESIONAL;
           }else if (fieldName.equals("NUMID_PROFESIONAL")) {
                    value = NUMID_PROFESIONAL;
            } else if (fieldName.equals("CARGO_SOLICITASERV")) {
                value = CARGO_SOLICITASERV;
            } else if (fieldName.equals("TEL_INFORMA")) {
                value = TEL_INFORMA;
            } else if (fieldName.equals("EXT_INFORMA")) {
                value = EXT_INFORMA;
            } else if (fieldName.equals("CEL_INFORMA")) {
                value = CEL_INFORMA;
            }else if (fieldName.equals("TIPOID_PROFESIONAL")) {
                value = TIPOID_PROFESIONAL;
            }else if (fieldName.equals("NUMID_PROFESIONAL")) {
                value = NUMID_PROFESIONAL;
            }
       }
       return value;
   }

    public void obtenerDatosComunes() {
        if (usuario != null) {
            if (usuario.getHusetipoafilia() != null) {
                if (usuario.getHusetipoafilia().equals("C")) {
                    TIPO_USUARIO = "CONTRIBUTIVO";
                } else if (usuario.getHusetipoafilia().equals("E")) {
                    TIPO_USUARIO = "ESPECIAL";
                } else if (usuario.getHusetipoafilia().equals("R")) {
                    TIPO_USUARIO = "SUBSIDIO PARCIAL";
                } else if (usuario.getHusetipoafilia().equals("S")) {
                    TIPO_USUARIO = "SUBSIDIADO";
                } else if (usuario.getHusetipoafilia().equals("V")) {
                    TIPO_USUARIO = "VINCULADO";
                } else if (usuario.getHusetipoafilia().equals("X")) {
                    TIPO_USUARIO = "NINGUNO";
                }
            }

            if (usuario.getHuscprimerapel() != null) {
                PRIMER_APELLIDO = usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                SEGUNDO_APELLIDO = usuario.getHuscsegundapel();
            }

            if (usuario.getHuscprimernomb() != null) {
                NOMBRES = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRES = NOMBRES + usuario.getHuscsegundnomb();
            }
            if (usuario.getHuscprimerapel() != null) {
                APELLIDOS = usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                APELLIDOS = APELLIDOS + usuario.getHuscsegundapel();
            }

            if (usuario.getHusdfechanacim() != null) {
                Date fechaNacimiento = usuario.getHusdfechanacim();
                if (fechaNacimiento != null) {
                    int edad = calcularEdad(fechaNacimiento, new Date());
                    EDAD = edad;
                }
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
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }

            if (usuario.getHusetipoiden() != null) {
                TIPO_DOCUMENTO = usuario.getHusetipoiden().toString();
            }

            if (usuario.getHuseestadcivil() != null) {
                String estadoCivil = usuario.getHuseestadcivil();
                if (estadoCivil != null) {
                    ESTADO_CIVIL = 
                            this.serviceLocator.getClinicoService().getDescripcionEstadoCivil(estadoCivil);
                }

            }

            if (usuario.getHusesexo() != null) {
                SEXO = usuario.getHusesexo();
            }

            DIRECCION_USUARIO = usuario.getHuscdireccion();

            Integer idMunicipio = usuario.getHusnciudad();
            Integer idDpto = usuario.getHusndepartamen();
            Cpmunidane municipio = null;

            try {
                municipio = 
                        this.serviceLocator.getClinicoService().getMunicipio(idMunicipio, 
                                                                             idDpto);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (municipio != null) {
                MUNICIPIO_USUARIO = municipio.getCmdcnommun();
            }
        }
        if (this.getClinica() != null) {
            CLINICA = this.getClinica().getCclcnombre();
            CIUDAD = this.getClinica().getCclcciudad();
        }
    }


    public void obtenerDatosReporteAnatomiaPatologica() {
        if (consulta.getChanteginecos() != null && !consulta.getChanteginecos().isEmpty()) {
            Chantegineco antecedente = null;
            Iterator it = consulta.getChanteginecos().iterator();
            if (it.hasNext()) {
                antecedente = (Chantegineco)it.next();
            }

            if (antecedente != null) {
                GESTACIONES = antecedente.getHagnnumgesta();
                PARTOS = antecedente.getHagnnumparto();
                ABORTOS = antecedente.getHagnnumaborto();
                CESAREAS = antecedente.getHagnnumcesare();
                VIVOS = antecedente.getHagnnumvivo();
                FECHA_REGLA = antecedente.getHagdfur();
                FECHA_PARTO = antecedente.getHagdfup();
            }
        }

        if (consulta.getChanatopatols() != null && !consulta.getChanatopatols().isEmpty()) {
            Chanatopatol anatomia = null;
            Iterator it = consulta.getChanatopatols().iterator();
            if (it.hasNext()) {
                anatomia = (Chanatopatol)it.next();
            }

            if (anatomia != null) {
                if (anatomia.getHapcoperador() != null) {
                    Cpprofesio profesional;
                    profesional = null;
                    try {
                        if (consulta != null && consulta.getHconclinica() != null) {
                            profesional = serviceLocator.getClinicoService().getProfesionalPorUsuario(anatomia.getHapcoperador().toLowerCase(), 
                                                                           consulta.getHconclinica());
                        }
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (profesional != null) {
                        NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                        REGISTRO_MEDICO = profesional.getCpfcregmedic();
                        ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                        TIPOID_PROFESIONAL = profesional.getCpfctipide();
                        NUMID_PROFESIONAL = profesional.getCpfacedula();
                    }
                }
                ORIGEN_PIEZA = anatomia.getHapcorigepieza();
                FECHA = anatomia.getHapdfecregistr();
            }
        }
    }

    public void generarAnatomia() {
        this.index = -1;
        try {
            File reportFile = new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/anatomiaPatologica.jasper"));

            if (reportFile.exists()) {
               Map parameters = new HashMap();
               byte[] bytes = null;
               URL imagen =  FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/profamilia_negro.gif");

               parameters.put("IMAGEN", imagen);
               parameters.put("FECHA", FECHA);
               parameters.put("NO_HISTORIA", usuario.getHusanumeiden().toString());
               parameters.put("APELLIDOS",usuario.getHuscprimerapel() + " " + usuario.getHuscsegundapel());
               parameters.put("NOMBRES",usuario.getHuscprimernomb() + " " + usuario.getHuscsegundnomb());
               parameters.put("EDAD",usuario.getEdad());
               parameters.put("ORIGEN_PIEZA",ORIGEN_PIEZA);                    
               parameters.put("CLINICA",CLINICA);                    
                        
               parameters.put("G",GESTACIONES);
               parameters.put("P",PARTOS);
               parameters.put("A",ABORTOS);
               parameters.put("C",CESAREAS);
               parameters.put("V",VIVOS);
               parameters.put("FUR",FECHA_REGLA);
               parameters.put("FUP",FECHA_PARTO);
               
               parameters.put("NOMBRE_PROFESIONAL",NOMBRE_PROFESIONAL);
               parameters.put("REGISTRO_MEDICO",REGISTRO_MEDICO);
               parameters.put("ESPECIALIDAD",ESPECIALIDAD);
               parameters.put("TIPOID_PROFESIONAL",TIPOID_PROFESIONAL);
               parameters.put("NUMID_PROFESIONAL",NUMID_PROFESIONAL);

               bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, (JRDataSource)this);
               PdfServletUtils.showPdfDocument(bytes, 
                                           "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                           ".pdf", false);
               generoDocumento = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + e.getMessage());
        }
    }

    public void obtenerDatosReporteReferencia() {

        if (consulta != null && consulta.getChreferencias() != null) {
//            Chreferencia referencia = null;
            Iterator ite = consulta.getChreferencias().iterator();
            if (ite.hasNext()) {
                referencia = (Chreferencia)ite.next();
            }

            if (referencia != null) {
                if (referencia.getHreclugarservi() == null || referencia.getHreclugarservi().equals("CE")) {
                    obtenerDatosReporteConsulta();
                } else {
                    obtenerDatosReporteCirugia();
                }
            }

            if (referencia != null) {

                List lstServiciosSelect;
                lstServiciosSelect = new ArrayList();
                if (referencia.getHrectiporefere() != null) {
                    StringTokenizer st = 
                        new StringTokenizer(referencia.getHrectiporefere(), ",");
                    while (st.hasMoreTokens()) {
                        String tipo = st.nextToken();
                        lstServiciosSelect.add(tipo);
                    }
                }

                if (lstServiciosSelect != null) {
                    Iterator it = lstServiciosSelect.iterator();
                    String idServ;
                    int i = 0;
                    TIPO_SERVICIO = "";
                    while (it.hasNext()) {
                        it.next();
                        idServ = (String)lstServiciosSelect.get(i);
                        if (idServ != null && !idServ.equals("")) {
                            if (idServ.equals("IC")) {
                                TIPO_SERVICIO = 
                                        TIPO_SERVICIO + "Interconsulta,";
                            } else if (idServ.equals("AT")) {
                                TIPO_SERVICIO = 
                                        TIPO_SERVICIO + "Apoyo Tecnologico,";
                            } else if (idServ.equals("RE")) {
                                TIPO_SERVICIO = TIPO_SERVICIO + "Remisi�n,";
                            } else if (idServ.equals("OS")) {
                                TIPO_SERVICIO = 
                                        TIPO_SERVICIO + "Orden de Servicio,";
                            } else if (idServ.equals("OR")) {
                                TIPO_SERVICIO = TIPO_SERVICIO + "Ordinario,";
                            } else if (idServ.equals("PR")) {
                                TIPO_SERVICIO = TIPO_SERVICIO + "Prioritario,";
                            } else if (idServ.equals("UR")) {
                                TIPO_SERVICIO = TIPO_SERVICIO + "Urgencia,";
                            }
                        }
                        i++;
                    }

                    if (TIPO_SERVICIO != null && !TIPO_SERVICIO.equals("")) {
                        TIPO_SERVICIO = 
                                TIPO_SERVICIO.substring(0, TIPO_SERVICIO.length() - 
                                                        1);
                    }
                }

              


                ANAMNESIS = referencia.getHrecanamnesis();
                APOYO_DIAGNOSTICO = referencia.getHrecapoyodiagn();
                JUSTIFICACION = referencia.getHrecjustirefer();
                if (referencia.getHrecnombrespon() != null) {
                    RESPONSABLE = referencia.getHrecnombrespon();
                }
                if (referencia.getHrecdirecrespo() != null) {
                    DIRECCION_RESPONSABLE = referencia.getHrecdirecrespo();
                }
                if (referencia.getHrectelefrespo() != null) {
                    TELEFONO_RESPONSABLE = referencia.getHrectelefrespo();
                }
                
                if (referencia.getHrecoperador() != null) {
                                        Cpprofesio profesional;
                                        profesional = null;
                                        try {
                                            if (consulta != null && consulta.getHconclinica() != null) {
                                                profesional = 
                                                        serviceLocator.getClinicoService().getProfesionalPorUsuario(referencia.getHrecoperador().toLowerCase(), 
                                                                                                                  consulta.getHconclinica());
                                            }

                                        } catch (ModelException e) {
                                            e.printStackTrace();
                                        }

                                        if (profesional != null) {
                                            NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                                            REGISTRO_MEDICO = profesional.getCpfcregmedic();
                                        }
                                    }
                
                

                if (consulta.getChexamfisicos() != null && 
                    !consulta.getChexamfisicos().isEmpty()) {

                    Chexamfisico examen = null;
                    Iterator it = consulta.getChexamfisicos().iterator();
                    if (it.hasNext()) {
                        examen = (Chexamfisico)it.next();
                    }

                    if (examen != null) {
                        TENSION_ARTERIAL = 
                                examen.getHefcpresart1() + "/" + examen.getHefcpresart2();
                        FRECUENCIA_CARDIACA = examen.getHefnfreccard();
                        FRECUENCIA_RESPIRATORIA = examen.getHefnfrecresp();
                        PESO = examen.getHefapeso();
                        TEMPERATURA = examen.getHefatemperatu();
                        HALLAZGOS_EXAMEN_FISICO = examen.getHefthallazgo();
                        
                        
                        

                    }


                }


                Calendar calendar = Calendar.getInstance();
                Integer diaact = null;
                Integer mesact = null;
                Integer ANOact = null;
                Integer horaact = null;
                Integer minutoact = null;
                if (referencia.getHredfecregistr() != null) {
                    calendar.setTime(referencia.getHredfecregistr());

                    diaact = calendar.get(Calendar.DAY_OF_MONTH);
                    mesact = calendar.get(Calendar.MONTH) + 1;
                    ANOact = calendar.get(calendar.YEAR);
                    horaact = calendar.get(Calendar.HOUR_OF_DAY);
                    minutoact = calendar.get(Calendar.MINUTE);
                }


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

                ANO = ANOact.toString();

                if (minutoact.compareTo(10) < 0) {
                    MINUTO = "0" + minutoact.toString();
                } else {
                    MINUTO = minutoact.toString();
                }

                if (horaact.compareTo(10) < 0) {
                    HORA = "0" + horaact.toString();
                } else {
                    HORA = horaact.toString();
                }
            }


        }


    }

    public void generarOrdenCirugia() {
        this.index = -1;
        String urlReporte = ""; 
        Chordecirugi orden = null; 
        String codigoServicio = ""; 
        
        if (consulta != null && consulta.getChordecirugis()!= null) {
            try {
                Iterator it = consulta.getChordecirugis().iterator(); 
                if(it.hasNext()){
                    orden = (Chordecirugi)it.next(); 
                }
        
                if(orden!=null && orden.getHocclugarinter()!= null){
                    if (orden.getHocclugarinter().equals("S")) {
                    urlReporte = "/reports/ordenCirugia.jasper";
                    } else {
                    urlReporte = "/reports/ordenCirugiaConsultorio.jasper";
                    }
                    StringTokenizer st = 
                        new StringTokenizer(orden.getHoccintervenci(), ".");
                    codigoServicio = st.nextToken();
             
                  if(codigoServicio.equals("637300") || codigoServicio.equals("662200") || codigoServicio.equals("662202")){
                      urlReporte = "/reports/ordenCirugiaConsultorio.jasper";
                  }
                }
        
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
                                                "Orden Cirugia" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);
                    generoDocumento = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                   e.getMessage());
            }
        }
    }

    public void obtenerDatosOrdenCirugia() {

        Date fecha;
        fecha = new Date();
        Calendar calendar;
        Integer diaact;
        Integer mesact;
        Integer ANOact;
        Integer horaact;
        Integer minact;
        Date fechacirugia;
        String horaSelect;
        String minutoSelect;
        String horaSelect2;
        String minutoSelect2;

        if (consulta.getChordecirugis() != null && 
            !consulta.getChordecirugis().isEmpty()) {
            Chordecirugi ordenCirugia = null;
            Iterator it = consulta.getChordecirugis().iterator();
            if (it.hasNext()) {
                ordenCirugia = (Chordecirugi)it.next();
            }

            if (ordenCirugia != null) {
                calendar = Calendar.getInstance();
                calendar.setTime(ordenCirugia.getHocdfecregistr());
                diaact = calendar.get(Calendar.DAY_OF_MONTH);
                mesact = calendar.get(Calendar.MONTH) + 1;
                ANOact = calendar.get(calendar.YEAR);
                horaact = calendar.get(Calendar.HOUR_OF_DAY);
                minact = calendar.get(Calendar.MINUTE);
                fechacirugia = null;
                horaSelect = "";
                minutoSelect = "";
                horaSelect2 = "";
                minutoSelect2 = "";
                
                if (ordenCirugia.getHoccoperador() != null) {
                    Cpprofesio profesional;
                    profesional = null;
                    try {
                        if (consulta != null && consulta.getHconclinica() != null) {
                            profesional = 
                                  serviceLocator.getClinicoService().getProfesionalPorUsuario(ordenCirugia.getHoccoperador().toLowerCase(), 
                                                                                              consulta.getHconclinica());
                        }
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (profesional != null) {
                        NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                        REGISTRO_MEDICO = profesional.getCpfcregmedic();
                        ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                        TIPOID_PROFESIONAL = profesional.getCpfctipide();
                        NUMID_PROFESIONAL = profesional.getCpfacedula();
                    }
                }

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
                    HORA_SISTEMA = 
                            horaact.toString() + ":" + minact.toString();
                }

                ANO = ANOact.toString();

                if (ordenCirugia.getHocdfecprocir1() != null) {
                    Calendar fechaciraux = Calendar.getInstance();
                    fechaciraux.setTime(ordenCirugia.getHocdfecprocir1());
                    Integer diaapx = fechaciraux.get(Calendar.DAY_OF_MONTH);
                    Integer mesapx = fechaciraux.get(Calendar.MONTH) + 1;
                    Integer ANOapx = fechaciraux.get(calendar.YEAR);

                    if (diaapx.compareTo(10) < 0) {
                        DIA_CIRUGIA1 = "0" + diaapx.toString();
                    } else {
                        DIA_CIRUGIA1 = diaapx.toString();
                    }

                    if (mesapx.compareTo(10) < 0) {
                        MES_CIRUGIA1 = "0" + mesapx.toString();
                    } else {
                        MES_CIRUGIA1 = mesapx.toString();
                    }
                    if (ordenCirugia.getHocdfecprocir1() != null) {
                        fechacirugia = ordenCirugia.getHocdfecprocir1();
                        Calendar fechaaux1 = Calendar.getInstance();
                        fechaaux1.setTime(ordenCirugia.getHocdfecprocir1());
                        Integer hora1 = null;
                        Integer minuto1 = null;
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

                    if (horaSelect != null && !horaSelect.equals("") && 
                        minutoSelect != null && !minutoSelect.equals("")) {
                        HORA_CIRUGIA1 = horaSelect + ":" + minutoSelect;
                    }
                    ANO_CIRUGIA1 = ANOapx.toString();
                }

                if (ordenCirugia.getHocdfecprocir2() != null) {
                    Calendar fechaciraux2 = Calendar.getInstance();
                    fechaciraux2.setTime(ordenCirugia.getHocdfecprocir2());
                    Integer diaapx2 = fechaciraux2.get(Calendar.DAY_OF_MONTH);
                    Integer mesapx2 = fechaciraux2.get(Calendar.MONTH) + 1;
                    Integer ANOapx2 = fechaciraux2.get(calendar.YEAR);

                    if (diaapx2.compareTo(10) < 0) {
                        DIA_CIRUGIA2 = "0" + diaapx2.toString();
                    } else {
                        DIA_CIRUGIA2 = diaapx2.toString();
                    }

                    if (mesapx2.compareTo(10) < 0) {
                        MES_CIRUGIA2 = "0" + mesapx2.toString();
                    } else {
                        MES_CIRUGIA2 = mesapx2.toString();
                    }

                    ANO_CIRUGIA2 = ANOapx2.toString();

                    if (ordenCirugia.getHocdfecprocir2() != null) {
                        Calendar fechaaux2 = Calendar.getInstance();
                        Integer hora2 = null;
                        Integer minuto2 = null;
                        if (ordenCirugia.getHocdfecprocir2() != null) {
                            fechaaux2.setTime(ordenCirugia.getHocdfecprocir2());
                            hora2 = (fechaaux2.get(Calendar.HOUR_OF_DAY));
                            minuto2 = (fechaaux2.get(Calendar.MINUTE));
                        }

                        if (hora2 != null && hora2.intValue() < 10) {
                            horaSelect2 = "0" + hora2;
                        } else {
                            horaSelect2 = hora2 + "";
                        }

                        if (minuto2 != null && minuto2.intValue() < 10) {
                            minutoSelect2 = "0" + minuto2;
                        } else {
                            minutoSelect2 = minuto2 + "";
                        }
                    }

                    if (horaSelect2 != null && !horaSelect2.equals("") && 
                        minutoSelect2 != null && !minutoSelect2.equals("")) {
                        HORA_CIRUGIA2 = horaSelect2 + ":" + minutoSelect2;
                    }
                }

                if (ordenCirugia != null && 
                    ordenCirugia.getHocctipoaneste() != null) {
                    if (ordenCirugia.getHocctipoaneste().equals("1")) {
                        ANESTESIA_SOLICITADA = "Controlada";
                    } else if (ordenCirugia.getHocctipoaneste().equals("2")) {
                        ANESTESIA_SOLICITADA = "General";
                    } else if (ordenCirugia.getHocctipoaneste().equals("3")) {
                        ANESTESIA_SOLICITADA = "Local";
                    }
                }

                if (ordenCirugia.getHocctipoestanc() != null && 
                    !ordenCirugia.getHocctipoestanc().equals("")) {
                    if (ordenCirugia.getHocctipoestanc().equals("A")) {
                        ESTANCIA = "Ambulatoria";
                    } else if (ordenCirugia.getHocctipoestanc().equals("H")) {
                        ESTANCIA = "Hospitalizaci�n";
                    }
                }

                if (ordenCirugia != null && 
                    ordenCirugia.getHocntiempointe() != null) {
                    TIEMPO_CIRUGIA = ordenCirugia.getHocntiempointe();
                }

                if (ordenCirugia != null && 
                    ordenCirugia.getHocndiasestanc() != null) {
                    DIAS_ESTANCIA = ordenCirugia.getHocndiasestanc();
                }

                if (ordenCirugia != null && 
                    ordenCirugia.getHoceayudantia() != null) {
                    if (ordenCirugia.getHoceayudantia().equals("S")) {
                        AYUDANTIA = "SI";
                    } else {
                        AYUDANTIA = "NO";
                    }


                }

                if (ordenCirugia.getHoceresesangre() != null && 
                    ordenCirugia.getHoceresesangre().equals("S")) {
                    RESERVA_SANGRE = "SI";
                }

                if (ordenCirugia.getHoceresesangre() != null && 
                    ordenCirugia.getHoceresesangre().equals("N")) {
                    RESERVA_SANGRE = "NO";
                }

                if (ordenCirugia != null && 
                    ordenCirugia.getHocnunidadsang() != null) {
                    NUMERO_UNIDADES = ordenCirugia.getHocnunidadsang();
                }
                if (ordenCirugia.getHocctipopatolo() != null && 
                    !ordenCirugia.getHocctipopatolo().equals("")) {
                    if (ordenCirugia.getHocctipopatolo().equals("BI")) {
                        PATOLOGIA = "Biopsia";
                    }
                    if (ordenCirugia != null && 
                        ordenCirugia.getHoccbiopsacong() != null && 
                        ordenCirugia.getHocctipopatolo().equals("BC")) {
                        PATOLOGIA = 
                                "Biopsa por Congelaci�n: " + ordenCirugia.getHoccbiopsacong();
                    }
                    if (ordenCirugia.getHocctipopatolo().equals("CO")) {
                        PATOLOGIA = "Cono";
                    }
                    if (ordenCirugia != null && 
                        ordenCirugia.getHoccotrapatolo() != null && 
                        ordenCirugia.getHocctipopatolo().equals("OT")) {
                        PATOLOGIA = 
                                "OTRO: " + ordenCirugia.getHoccotrapatolo();
                    }
                    if (ordenCirugia.getHoccotrapatolo() != null && 
                        ordenCirugia.getHoccotrapatolo().equals("PQ")) {
                        PATOLOGIA = "Pieza Qx";
                    }
                }

                if (ordenCirugia != null && 
                    ordenCirugia.getHoccprogramar() != null) {
                    if (ordenCirugia.getHoccprogramar().equals("S")) {
                        PROGRAMAR = "SI";
                    }
                    if (ordenCirugia.getHoccprogramar().equals("N")) {
                        PROGRAMAR = "NO";
                    }
                }
            }
        }
        if (consulta.getChordecirugis() != null && 
            !consulta.getChordecirugis().isEmpty()) {
            Chordecirugi ordenCirugia = null;
            Iterator it = consulta.getChordecirugis().iterator();
            if (it.hasNext()) {
                ordenCirugia = (Chordecirugi)it.next();
            }

            if (ordenCirugia.getHoccintervenci() != null) {
                StringTokenizer st = 
                     new StringTokenizer(ordenCirugia.getHoccintervenci(), ",");
                Cpservicio servicioAux = null;
                INTERVENCION = ""; 
                while (st.hasMoreTokens()) {
                   String idservicio = st.nextToken();

                   try {
                       servicioAux = 
                             this.serviceLocator.getClinicoService().getServicioPorId(idservicio);
                   } catch (ModelException e) {
                       e.printStackTrace();
                   }
                   if (servicioAux != null) {
                      INTERVENCION = INTERVENCION + " " + servicioAux.getCsvccodigo() + " " + servicioAux.getCsvcnombre() + " ";
                   }
               }
            }
            
            if (ordenCirugia.getHoccoperador() != null) {
                Cpprofesio profesional;
                profesional = null;
                try {
                    if (consulta != null && consulta.getHconclinica() != null) {
                        profesional = 
                               serviceLocator.getClinicoService().getProfesionalPorUsuario(ordenCirugia.getHoccoperador().toLowerCase(), 
                                                                                           consulta.getHconclinica());
                    }
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (profesional != null) {
                    NOMBRE_CIRUJANO = profesional.getCpfcnombre();
                    REGISTRO_MEDICO = profesional.getCpfcregmedic();
                    ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                }
            }
        }
    }


    public void generarReferencia() {
        this.index = -1;

        try {
//           URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/referencia.jasper");
            URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/Formato_Referencia.jasper");
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
                                                "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);
                generoDocumento = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
    }


    public void obtenerDatosFormulaMedica() {
        lstPrescripciones = new ArrayList<Chformulamed>();

        if (consulta.getHcoctiposervi().equals("H")) {
            Chdetaldescr detaldescr = new Chdetaldescr();
            try{
               detaldescr = 
                this.serviceLocator.getCirugiaService().getDetalleDescripcion(consulta.getHcolnumero());
            }catch(ModelException e){
                e.printStackTrace();
            }
        
            if(detaldescr != null && !detaldescr.equals("")){
                CODIGO_CIE10 = detaldescr.getHddcdiagnprinc().toUpperCase();
            }
        } else {
            if (consulta.getChimprdiags() != null) {
                Chimprdiag impresion = null;
                Iterator it = consulta.getChimprdiags().iterator();
                if (it.hasNext()) {
                    impresion = (Chimprdiag)it.next();
                }
            
                if (impresion != null && impresion.getHidcdiagprin() != null) {
                    CODIGO_CIE10 = impresion.getHidcdiagprin();
                }
            }
        }
        
        if (CODIGO_CIE10 != null) {
            Crdgncie10 diagnosticoPrincipal = null;

            try {
                diagnosticoPrincipal = 
                        this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (diagnosticoPrincipal != null) {
                CODIGO_CIE10 = 
                        CODIGO_CIE10 + " " + diagnosticoPrincipal.getCdccdescri();
            }

        }


        if (consulta.getChformulameds() != null && !consulta.getChformulameds().isEmpty()) {
            Iterator it = consulta.getChformulameds().iterator();
            Chformulamed formula = null;
            while (it.hasNext()) {
                formula = (Chformulamed)it.next();
                if (formula != null) {
                    lstPrescripciones.add(formula);
                }
            }
            if (formula != null) {
                if (formula.getHfocoperador() != null) {
                    Cpprofesio profesional;
                    profesional = null;
                    try {
                        if (consulta != null && consulta.getHconclinica() != null) {
                            profesional = 
                                  serviceLocator.getClinicoService().getProfesionalPorUsuario(formula.getHfocoperador().toLowerCase(), 
                                                                                              consulta.getHconclinica());
                        }
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (profesional != null) {
                        NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                        REGISTRO_MEDICO = profesional.getCpfcregmedic();
                        ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                        TIPOID_PROFESIONAL = profesional.getCpfctipide();
                        NUMID_PROFESIONAL = profesional.getCpfacedula();
                    }
                }

                fecha = new Date();
                Calendar calendar = Calendar.getInstance();
                Integer diaact = null;
                Integer mesact = null;
                Integer ANOact = null;
                if (formula.getHfodfecregistr() != null) {
                    calendar.setTime(formula.getHfodfecregistr());
                    diaact = calendar.get(Calendar.DAY_OF_MONTH);
                    mesact = calendar.get(Calendar.MONTH) + 1;
                    ANOact = calendar.get(calendar.YEAR);
                }

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

                ANO = ANOact.toString();
            }
        }
        
        if (consulta.getChformulahos() != null && !consulta.getChformulahos().isEmpty()) {
            Iterator it = consulta.getChformulahos().iterator();
            Chformulahos formula = null;
            while (it.hasNext()) {
                formula = (Chformulahos)it.next();
                if (formula != null) {
                    lstPrescipcionesCiru.add(formula);
                }
            }
            if (formula != null) {
                if (formula.getHfhcoperador() != null) {
                    Cpprofesio profesional;
                    profesional = null;
                    try {
                        if (consulta != null && consulta.getHconclinica() != null) {
                           profesional = 
                                  serviceLocator.getClinicoService().getProfesionalPorUsuario(formula.getHfhcoperador().toLowerCase(), 
                                                                                              consulta.getHconclinica());
                        }
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (profesional != null) {
                        NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                        REGISTRO_MEDICO = profesional.getCpfcregmedic();
                        ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                        TIPOID_PROFESIONAL = profesional.getCpfctipide();
                       NUMID_PROFESIONAL = profesional.getCpfacedula();
                    }
                }
 
                fecha = new Date();
                Calendar calendar = Calendar.getInstance();
                Integer diaact = null;
                Integer mesact = null;
                Integer ANOact = null;
                if (formula.getHfhdfecregistr() != null) {
                    calendar.setTime(formula.getHfhdfecregistr());
                    diaact = calendar.get(Calendar.DAY_OF_MONTH);
                    mesact = calendar.get(Calendar.MONTH) + 1;
                    ANOact = calendar.get(calendar.YEAR);
                }

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

                ANO = ANOact.toString();
            }
        }
    }

    public void generarFormulaMedica() {
        this.index = -1;

        try {
//           URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/prescripcionVademecumMedica2.jasper");
            URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/FO_GS_GC_CS_08_V01.jasper");
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
                                                "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);

                generoDocumento = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
    }

    public void obtenerDatosIncapacidad() {
    
        CODIGO_ORIGEN = null;

    if(consulta != null && consulta.getHcoctiposervi().equals("C")){
        if (consulta.getChimprdiags() != null) {
            Chimprdiag impresion = null;
            if (consulta.getChimprdiags() != null) {
                Iterator it = consulta.getChimprdiags().iterator();
                if (it.hasNext()) {
                    impresion = (Chimprdiag)it.next();
                }
            }

            if (impresion != null) {
                if (impresion.getHidcdiagprin() != null) {
                    Crdgncie10 diagprin = null;
                    CODIGO_CIE10_PRINCIPAL = impresion.getHidcdiagprin();
                    DIAGNOSTICO_PRINCIPAL = impresion.getHidcdiagprin();

                    try {
                        diagprin = 
                                this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10_PRINCIPAL);
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (diagprin != null) {
                        DIAGNOSTICO_PRINCIPAL = diagprin.getCdccdescri();
                    }
                }
                if (impresion.getHidcdiagrela1() != null) {
                    Crdgncie10 diagrela1 = null;
                    CODIGO_CIE10_SECUNDARIO = impresion.getHidcdiagrela1();
                    try {
                        diagrela1 = 
                                this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10_SECUNDARIO);
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (diagrela1 != null) {
                        DIAGNOSTICO_SECUNDARIO = diagrela1.getCdccdescri();
                    }
                }

            }


        }
    }else{
        if(consulta != null && consulta.getHcolnumero() != null){
            Chdetaldescr detaldescr = null;
            Crdgncie10 diagprin = null;
            Crdgncie10 diagrela = null;

            try{
               detaldescr = 
                this.serviceLocator.getCirugiaService().getDetalleDescripcion(consulta.getHcolnumero());
            }catch(ModelException e){
                e.printStackTrace();
            }
            
            if(detaldescr != null && !detaldescr.equals("")){
            if(detaldescr.getHddcdiagnprinc() != null && !detaldescr.getHddcdiagnprinc().equals("")){
                CODIGO_CIE10_PRINCIPAL = detaldescr.getHddcdiagnprinc().toUpperCase();
                if(detaldescr.getHddcdiagnrelac() != null && !detaldescr.getHddcdiagnrelac().equals("")){
                    CODIGO_CIE10_SECUNDARIO = detaldescr.getHddcdiagnrelac().toUpperCase();
                }
                
                
                try{
                    diagprin = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10_PRINCIPAL);
                            
                        diagrela =  this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10_PRINCIPAL);
                    } catch (ModelException e) {
                    e.printStackTrace();
                    }
                if(diagprin != null && !diagprin.equals("")){
                    DIAGNOSTICO_PRINCIPAL = diagprin.getCdcccodigo() + " " +  diagprin.getCdccdescri();
                    CODIGO_CIE10_PRINCIPAL  = diagprin.getCdcccodigo() + " " +  diagprin.getCdccdescri();
                }
                
                if(diagrela != null && !diagrela.equals("")){
                    CODIGO_CIE10_SECUNDARIO =  diagrela.getCdcccodigo() + " " +  diagrela.getCdccdescri();
                }
            }
           
        
        }
       
        }
    }

        if (consulta.getChincapacidas() != null && 
            !consulta.getChincapacidas().isEmpty()) {
            Chincapacida incapacidad = null;
            Iterator it = consulta.getChincapacidas().iterator();
            if (it.hasNext()) {
                incapacidad = (Chincapacida)it.next();
            }

            if (incapacidad != null) {
                if (incapacidad.getHidcoperador() != null) {
                    Cpprofesio profesional;
                    profesional = null;
                    try {
                        if (consulta!= null && consulta.getHconclinica() != null) {
                            profesional = 
                                   serviceLocator.getClinicoService().getProfesionalPorUsuario(incapacidad.getHidcoperador().toLowerCase(), 
                                                                                               consulta.getHconclinica());
                        }
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (profesional != null) {
                        NOMBRE_PROFESIONAL = profesional.getCpfcnombre() + " " + profesional.getCpfctipide() + " " + profesional.getCpfacedula();
                        REGISTRO_MEDICO = profesional.getCpfcregmedic();
                        ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                        TIPOID_PROFESIONAL = profesional.getCpfctipide();
                        NUMID_PROFESIONAL = profesional.getCpfacedula();
                    }
                }
            
            
                if (incapacidad.getHidndias() != null) {
                    DURACION = incapacidad.getHidndias();
                }

                if (incapacidad.getHindfecinicia() != null) {
                    FECHA_INICIAL_INCAPACIDAD = incapacidad.getHindfecinicia();

                    Calendar fechaaux = Calendar.getInstance();
                    fechaaux.setTime(FECHA_INICIAL_INCAPACIDAD);
                    fechaaux.add(Calendar.DATE, (DURACION - 1));

                    FECHA_FINAL_INCAPACIDAD = fechaaux.getTime();
                }

                if (incapacidad.getHiddfecregistr() != null) {
                    FECHA = incapacidad.getHiddfecregistr();
                }

                if (incapacidad != null) {
                    List<Cnconsclin> lstConsultaClinica = null;
                    Cnconsclin consultaclinica = null;
                    try {
                        lstConsultaClinica = 
                                this.serviceLocator.getClinicoService().getConsultaClinica(incapacidad.getId().getHinlconsulta());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (lstConsultaClinica != null && 
                        !lstConsultaClinica.isEmpty()) {
                        consultaclinica = lstConsultaClinica.get(0);
                    }

                    if (consultaclinica != null && 
                        consultaclinica.getCcocservic() != null && 
                        consultaclinica.getCcocservic().getCsvccodigo() != 
                        null) {
                        CODIGO_CUPS = 
                                consultaclinica.getCcocservic().getCsvccodigo();
                        try {
                            DESC_SERVICIO = 
                                    this.serviceLocator.getClinicoService().getDescripcionCups(CODIGO_CUPS);
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            if (incapacidad.getHidntipoincapa() != null) {
                if (incapacidad.getHidntipoincapa().equals(1)) {
                    TIPO_INCAPACIDAD = "Hospilitaria";
                } else if (incapacidad.getHidntipoincapa().equals(2)) {
                    TIPO_INCAPACIDAD = "Ambulatoria";
                } else if (incapacidad.getHidntipoincapa().equals(3)) {
                    TIPO_INCAPACIDAD = "Cirugia Ambulatoria";
                }
            }

            if (incapacidad.getHidnorigeincap() != null) {
                CODIGO_ORIGEN = incapacidad.getHidnorigeincap();
            
                if (incapacidad.getHidnorigeincap().equals(1)) {
                    ORIGEN_INCAPACIDAD = "No Aplica";
                } else if (incapacidad.getHidnorigeincap().equals(2)) {
                    ORIGEN_INCAPACIDAD = "Enfermedad General";
                } else if (incapacidad.getHidnorigeincap().equals(3)) {
                    ORIGEN_INCAPACIDAD = "Enfermedad Profesional";
                } else if (incapacidad.getHidnorigeincap().equals(4)) {
                    ORIGEN_INCAPACIDAD = "Accidente de Trabajo";
                } else if (incapacidad.getHidnorigeincap().equals(5)) {
                    ORIGEN_INCAPACIDAD = "Accidente de Transito";
                } else if (incapacidad.getHidnorigeincap().equals(6)) {
                    ORIGEN_INCAPACIDAD = "Licencia de Paternidad";
                }
            }
        }
    }


    public void generarIncapacidad() {
        this.index = -1;
        try {
           URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/incapacidad2.jasper");
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
                                                "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);

                generoDocumento = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
    }


    public void obtenerDatosLaboratorio() {

        lstExamenesLaboratorio = new ArrayList<Chexamelabor>();
        Chimprdiag impresion = null;
        if (consulta.getChimprdiags() != null) {
            Iterator it = consulta.getChimprdiags().iterator();
            if (it.hasNext()) {
                impresion = (Chimprdiag)it.next();
            }
        }

        if (impresion != null) {
            if (impresion != null && impresion.getHidcdiagprin() != null) {
                Crdgncie10 diagprin = null;

                CODIGO_CIE10_PRINCIPAL = impresion.getHidcdiagprin();
                DIAGNOSTICO_PRINCIPAL = impresion.getHidcdiagprin();

                try {
                    diagprin = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10_PRINCIPAL);
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagprin != null) {
                    DIAGNOSTICO_PRINCIPAL = diagprin.getCdccdescri();
                }
            }
        }

        Chexamelabor examen;
        examen = null;
        if (consulta.getChexamelabors() != null && 
            !consulta.getChexamelabors().isEmpty()) {
            Iterator it = consulta.getChexamelabors().iterator();
            while (it.hasNext()) {
                examen = (Chexamelabor)it.next();
                lstExamenesLaboratorio.add(examen);
            }

            if (examen != null) {
                if (examen.getHelcoperador() != null) {
                    Cpprofesio profesional;
                    profesional = null;
                    try {
                         if (consulta != null && consulta.getHconclinica() != null) {
                             profesional = 
                                 serviceLocator.getClinicoService().getProfesionalPorUsuario(examen.getHelcoperador().toLowerCase(), 
                                                                                 consulta.getHconclinica());
                         }
                    } catch (ModelException e) {
                         e.printStackTrace();
                    }

                    if (profesional != null) {
                        NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                        REGISTRO_MEDICO = profesional.getCpfcregmedic();
                        ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                        TIPOID_PROFESIONAL = profesional.getCpfctipide();
                        NUMID_PROFESIONAL = profesional.getCpfacedula();
                    }
                }
                                    
                OBSERVACIONES_EXAMENES = examen.getHelcobservacio();
                fecha = new Date();
                Integer diaact = null;
                Integer mesact = null;
                Integer ANOact = null;
                Calendar calendar = Calendar.getInstance();
                if (examen.getHeldfecregistr() != null) {
                    calendar.setTime(examen.getHeldfecregistr());
                    diaact = calendar.get(Calendar.DAY_OF_MONTH);
                    mesact = calendar.get(Calendar.MONTH) + 1;
                    ANOact = calendar.get(calendar.YEAR);
                }

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

                ANO = ANOact.toString();
            }

        }
    }


    public void generarLaboratorio() {
    
        FacesUtils.resetManagedBean("examLaboratorioUsuarioBean");
        try {
            ExamLaboratorioUsuarioBean examLaboratorioUsuario = (ExamLaboratorioUsuarioBean)FacesUtils.getManagedBean("examLaboratorioUsuarioBean");
            Integer consecutivo = 1;
            if ("H".equals(consulta.getHcoctiposervi())) {
                consecutivo = 2;
            }
            if (examLaboratorioUsuario != null) {
                byte[] bytes = examLaboratorioUsuario.generarReporteLaboratorios(consulta.getHcolnumero(), consecutivo, consulta.getHcoctiposervi());
                if (bytes != null) {
                    PdfServletUtils.showPdfDocument(bytes, 
                                            "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                            ".pdf", false);
                    generoDocumento = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
    
/*        this.index = -1;

        try {
            URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/Remision.jasper");
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
                                                "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);
                generoDocumento = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
*/        
    }


    public void obtenerDatosImagenes() {

        lstExamenesImagenes = new ArrayList<Chexameimage>();
        Chimprdiag impresion = null;
        if (consulta.getChimprdiags() != null) {
            Iterator it = consulta.getChimprdiags().iterator();
            if (it.hasNext()) {
                impresion = (Chimprdiag)it.next();
            }
        }

        if (impresion != null) {
            if (impresion != null && impresion.getHidcdiagprin() != null) {
                Crdgncie10 diagprin = null;

                CODIGO_CIE10_PRINCIPAL = impresion.getHidcdiagprin();
                DIAGNOSTICO_PRINCIPAL = impresion.getHidcdiagprin();

                try {
                    diagprin = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10_PRINCIPAL);
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagprin != null) {
                    DIAGNOSTICO_PRINCIPAL = diagprin.getCdccdescri();
                }
            }
        }

        Chexameimage examen;
        examen = null;
        if (consulta.getChexameimages() != null && 
            !consulta.getChexameimages().isEmpty()) {
            Iterator it = consulta.getChexameimages().iterator();
            while (it.hasNext()) {
                examen = (Chexameimage)it.next();
                lstExamenesImagenes.add(examen);
            }

            if (examen != null) {
               if (examen.getHeicoperador() != null) {
                  Cpprofesio profesional;
                  profesional = null;
                  try {
                      if (consulta != null && consulta.getHconclinica() != null) {
                          profesional = 
                               serviceLocator.getClinicoService().getProfesionalPorUsuario(examen.getHeicoperador().toLowerCase(), 
                                                                                                      consulta.getHconclinica());
                      }
                  } catch (ModelException e) {
                      e.printStackTrace();
                  }
                  if (profesional != null) {
                      NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                      REGISTRO_MEDICO = profesional.getCpfcregmedic();
                      ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                      TIPOID_PROFESIONAL = profesional.getCpfctipide();
                      NUMID_PROFESIONAL = profesional.getCpfacedula();
                  }
               }
               OBSERVACIONES_EXAMENES = examen.getHeicobservacio();
               fecha = new Date();
               Integer diaact = null;
               Integer mesact = null;
               Integer ANOact = null;
               Calendar calendar = Calendar.getInstance();
               if (examen.getHeidfecregistr() != null) {
                    calendar.setTime(examen.getHeidfecregistr());
                    diaact = calendar.get(Calendar.DAY_OF_MONTH);
                    mesact = calendar.get(Calendar.MONTH) + 1;
                    ANOact = calendar.get(calendar.YEAR);
                }

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

                if (consulta.getChanteginecos() != null && 
                    !consulta.getChanteginecos().isEmpty()) {

                    Chantegineco antecedente = null;
                    Iterator it1 = consulta.getChanteginecos().iterator();
                    if (it1.hasNext()) {
                        antecedente = (Chantegineco)it1.next();
                    }

                    if (antecedente != null) {
                        GESTACIONES = antecedente.getHagnnumgesta();
                        PARTOS = antecedente.getHagnnumparto();
                        ABORTOS = antecedente.getHagnnumaborto();
                        CESAREAS = antecedente.getHagnnumcesare();
                        VIVOS = antecedente.getHagnnumvivo();
                        FECHA_REGLA = antecedente.getHagdfur();
                        FECHA_PARTO = antecedente.getHagdfup();
                    }

                }

                ANO = ANOact.toString();
            }
        }
    }

    public void generarImagenes() {
        this.index = -1;
        try {
            URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/RemisionImagenes.jasper");
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
                                                "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);
                generoDocumento = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }

    }


    public void obtenerDatosElectrofisiologicos() {
        lstExamenesElectrofisiologicos = new ArrayList<Chexameelect>();
        Chimprdiag impresion = null;
        if (consulta.getChimprdiags() != null) {
            Iterator it = consulta.getChimprdiags().iterator();
            if (it.hasNext()) {
                impresion = (Chimprdiag)it.next();
            }
        }
        if (impresion != null) {
            if (impresion != null && impresion.getHidcdiagprin() != null) {
                Crdgncie10 diagprin = null;

                CODIGO_CIE10_PRINCIPAL = impresion.getHidcdiagprin();
                DIAGNOSTICO_PRINCIPAL = impresion.getHidcdiagprin();

                try {
                    diagprin = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10_PRINCIPAL);
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagprin != null) {
                    DIAGNOSTICO_PRINCIPAL = diagprin.getCdccdescri();
                }
            }
        }

        Chexameelect examen;
        examen = null;
        if (consulta.getChexameelects() != null && 
            !consulta.getChexameelects().isEmpty()) {
            Iterator it = consulta.getChexameelects().iterator();
            while (it.hasNext()) {
                examen = (Chexameelect)it.next();
                lstExamenesElectrofisiologicos.add(examen);
            }

            if (examen != null) {
                if (examen.getHeecoperador() != null) {
                    Cpprofesio profesional;
                    profesional = null;
                    try {
                        if (consulta != null && consulta.getHconclinica() != null) {
                            profesional = 
                                  serviceLocator.getClinicoService().getProfesionalPorUsuario(examen.getHeecoperador().toLowerCase(), 
                                                                                              consulta.getHconclinica());
                        }
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (profesional != null) {
                        NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                        REGISTRO_MEDICO = profesional.getCpfcregmedic();
                        ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                        TIPOID_PROFESIONAL = profesional.getCpfctipide();
                         NUMID_PROFESIONAL = profesional.getCpfacedula();
                    }
                }
            
                OBSERVACIONES_EXAMENES = examen.getHeecobservacio();
                fecha = new Date();
                Integer diaact = null;
                Integer mesact = null;
                Integer ANOact = null;
                Calendar calendar = Calendar.getInstance();
                if (examen.getHeedfecregistr() != null) {
                    calendar.setTime(examen.getHeedfecregistr());
                    diaact = calendar.get(Calendar.DAY_OF_MONTH);
                    mesact = calendar.get(Calendar.MONTH) + 1;
                    ANOact = calendar.get(calendar.YEAR);
                }

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

                ANO = ANOact.toString();
            }
        }
    }


    public void generarElectrofisiologicos() {
        this.index = -1;
        try {
            URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/Remision.jasper");
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
                                                "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);
                generoDocumento = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
    }

    public void obtenerDatosInterconsulta() {

        lstInterconsulta = new ArrayList<Chremision>();
        Chimprdiag impresion = null;

        if (consulta.getChimprdiags() != null) {
            Iterator it = consulta.getChimprdiags().iterator();
            if (it.hasNext()) {
                impresion = (Chimprdiag)it.next();
            }
        }
        if (impresion != null) {
            if (impresion != null && impresion.getHidcdiagprin() != null) {
                Crdgncie10 diagprin = null;

                CODIGO_CIE10_PRINCIPAL = impresion.getHidcdiagprin();
                DIAGNOSTICO_PRINCIPAL = impresion.getHidcdiagprin();

                try {
                    diagprin = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10_PRINCIPAL);
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagprin != null) {
                    DIAGNOSTICO_PRINCIPAL = diagprin.getCdcccodigo()+ " " + diagprin.getCdccdescri() ;
                }
            }
        }

        Chremision remision;
        remision = null;
        if (consulta.getChremisions() != null && 
            !consulta.getChremisions().isEmpty()) {
            Iterator it = consulta.getChremisions().iterator();
            while (it.hasNext()) {
                remision = (Chremision)it.next();
                lstInterconsulta.add(remision);
            }

            if (remision != null) {
                fecha = new Date();
                Integer diaact = null;
                Integer mesact = null;
                Integer ANOact = null;
                Calendar calendar = Calendar.getInstance();
                if (remision.getHredfecregistr() != null) {
                    calendar.setTime(remision.getHredfecregistr());
                    diaact = calendar.get(Calendar.DAY_OF_MONTH);
                    mesact = calendar.get(Calendar.MONTH) + 1;
                    ANOact = calendar.get(calendar.YEAR);
                }
                
                if (remision.getHrecoperador() != null) {
                    Cpprofesio profesional;
                    profesional = null;
                    try {
                        if (consulta != null && consulta.getHconclinica() != null) {
                            profesional = 
                                  serviceLocator.getClinicoService().getProfesionalPorUsuario(remision.getHrecoperador().toLowerCase(), 
                                                                                             consulta.getHconclinica());
                        }
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (profesional != null) {
                        NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                        REGISTRO_MEDICO = profesional.getCpfcregmedic();
                        ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                        TIPOID_PROFESIONAL = profesional.getCpfctipide();
                        NUMID_PROFESIONAL = profesional.getCpfacedula();
                    }
                }

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

                ANO = ANOact.toString();
            }
        }
    }
    
    
    public void obtenerDatosCertificadoAsistencia(){
        Chusuario usuarioAux;
        usuarioAux = null;

        if (usuario != null) {
            usuarioAux = usuario;
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
                NOMBRES = usuarioAux.getHuscprimernomb() + " ";
            }
            if (usuarioAux.getHuscsegundnomb() != null && 
                !usuarioAux.getHuscsegundnomb().equals("_")) {
                NOMBRES = NOMBRES + usuarioAux.getHuscsegundnomb();
            }
            if (usuarioAux.getHuscprimerapel() != null) {
                PRIMER_APELLIDO = usuarioAux.getHuscprimerapel() + " ";
            }
            if (usuarioAux.getHuscsegundapel() != null && 
                !usuarioAux.getHuscsegundapel().equals("_")) {
                SEGUNDO_APELLIDO = usuarioAux.getHuscsegundapel();
            }
            if (usuarioAux.getHusetipoiden() != null) {
                TIPO_DOCUMENTO = usuarioAux.getHusetipoiden().toString();
            }
            if (usuarioAux.getHusanumeiden() != 0) {
                NUMERO_DOCUMENTO = usuarioAux.getHusanumeiden();
            }

        }

        if (consulta.getChcertmedicos()!= null ) {
        
        Iterator it = consulta.getChcertmedicos().iterator(); 
        Chcertmedico certAux= null; 
        Chcertmedico certificado= null; 
        
        while(it.hasNext()){
            certAux = (Chcertmedico)it.next(); 
            
            if(certAux!= null && certAux.getId()!= null && 
                certAux.getId().getHcmctipocert()!= null &&  certAux.getId().getHcmctipocert().equals(CERTIFICADO_ASISTENCIA)){
                    certificado = certAux; 
            }
        }
        
        if(certificado!= null){
            if (certificado.getHcmcoperador() != null) {
                Cpprofesio profesional;
                profesional = null;
                try {
                    if (consulta != null && consulta.getHconclinica() != null) {
                        profesional = 
                               serviceLocator.getClinicoService().getProfesionalPorUsuario(certificado.getHcmcoperador().toLowerCase(), 
                                                                                           consulta.getHconclinica());
                    }
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (profesional != null) {
                    NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                    REGISTRO_MEDICO = profesional.getCpfcregmedic();
                    ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                    TIPOID_PROFESIONAL = profesional.getCpfctipide();
                    NUMID_PROFESIONAL = profesional.getCpfacedula();
                }
            }
                       
            fecha = certificado.getHcmdfechareg();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(certificado.getHcmdfechareg());
            Integer diaact = calendar.get(Calendar.DAY_OF_MONTH);
            Integer mesact = calendar.get(Calendar.MONTH) + 1;
            Integer ANOact = calendar.get(calendar.YEAR);

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

            ANO = ANOact.toString();

            DESCRIPCION_HORA = formatearCampoHoraSimple(certificado.getHcmdfechareg());
            DESCRIPCION_FECHA = DateFormat.getDateInstance(DateFormat.LONG).format(certificado.getHcmdfechareg());
            }

            if (certificado != null) {
            if (certificado.getHcmccertifica() != null) {
                DESCRIPCION_CERTIFICADO = certificado.getHcmccertifica();
            }

            if (certificado.getHcmcnombreacom() != null && 
                !certificado.getHcmcnombreacom().equals("")) {
                NOMBRE_ACOMPANANTE = certificado.getHcmcnombreacom();
            } else {
                NOMBRE_ACOMPANANTE = null;
            }

            if (certificado.getHcmetipoideaco() != null && 
                !certificado.getHcmetipoideaco().equals("")) {
                TIPO_DOCUMENTO_ACOMPANANTE = certificado.getHcmetipoideaco();
            } else {
                TIPO_DOCUMENTO_ACOMPANANTE = null;
            }

            if (certificado.getHcmanumideacom() != null) {
                NUMERO_DOCUMENTO_ACOMPANANTE = certificado.getHcmanumideacom();
            } else {
                NUMERO_DOCUMENTO_ACOMPANANTE = null;
            }
            }

            if (certificado != null) {
                Cpprofesio profesional;
                profesional = null;
                try {
                    if (consulta != null && consulta.getHconclinica() != null) {
                        profesional = 
                                serviceLocator.getClinicoService().getProfesionalPorUsuario(certificado.getHcmcoperador().toLowerCase(), 
                                                                                          consulta.getHconclinica());
                    }

                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (profesional != null) {
                    NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                    REGISTRO_MEDICO = profesional.getCpfcregmedic();
                    ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                    TIPOID_PROFESIONAL = profesional.getCpfctipide();
                    NUMID_PROFESIONAL = profesional.getCpfacedula();
                }
            }
        }
    }
    
    public void obtenerDatosCertificadoMedico(){
        if (usuario != null) {

            if (usuario.getHusdfechanacim() != null) {
                Date fechaNacimiento = usuario.getHusdfechanacim();
                if (fechaNacimiento != null) {
                    int edad = calcularEdad(fechaNacimiento, new Date());
                    EDAD = edad;
                }
            }

            if (usuario.getHuscprimernomb() != null) {
                NOMBRES = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRES = NOMBRES + usuario.getHuscsegundnomb();
            }
            if (usuario.getHuscprimerapel() != null) {
                PRIMER_APELLIDO = usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                SEGUNDO_APELLIDO = usuario.getHuscsegundapel();
            }
            if (usuario.getHusetipoiden() != null) {
                TIPO_DOCUMENTO = usuario.getHusetipoiden().toString();
            }
            if (usuario.getHusanumeiden() != 0) {
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }
        }
        
        if(consulta!= null && consulta.getChcertmedicos()!= null){
            Iterator it = consulta.getChcertmedicos().iterator(); 
            Chcertmedico certAux= null; 
            Chcertmedico certificado= null; 
            
            while(it.hasNext()){
                certAux = (Chcertmedico)it.next(); 
                
                if(certAux!= null && certAux.getId()!= null && 
                    certAux.getId().getHcmctipocert()!= null &&  certAux.getId().getHcmctipocert().equals(CERTIFICADO_MEDICO)){
                        certificado = certAux; 
                    }
            }
            
            if (certificado!= null && certificado.getHcmdfechareg() != null) {
                fecha = certificado.getHcmdfechareg();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fecha);
                Integer diaact = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mesact = calendar.get(Calendar.MONTH) + 1;
                Integer ANOact = calendar.get(calendar.YEAR);

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

                ANO = ANOact.toString();
            }

            if (certificado != null) {
                if (certificado.getHcmccertifica() != null) {
                    DESCRIPCION_CERTIFICADO = certificado.getHcmccertifica();
                }
            }

            if (certificado.getHcmcoperador() != null) {
                Cpprofesio profesional;
                profesional = null;
                try {
                    if (consulta != null && consulta.getHconclinica() != null) {
                        profesional = 
                               serviceLocator.getClinicoService().getProfesionalPorUsuario(certificado.getHcmcoperador().toLowerCase(), 
                                                                                           consulta.getHconclinica());
                    }
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (profesional != null) {
                    NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                    REGISTRO_MEDICO = profesional.getCpfcregmedic();
                    ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                    TIPOID_PROFESIONAL = profesional.getCpfctipide();
                   NUMID_PROFESIONAL = profesional.getCpfacedula();
                }
            }
        }
    }
    
    
    public void obtenerDatosRecomendaciones(){
        if (usuario != null) {
            if (usuario.getHusdfechanacim() != null) {
                Date fechaNacimiento = usuario.getHusdfechanacim();
                if (fechaNacimiento != null) {
                    int edad = calcularEdad(fechaNacimiento, new Date());
                    EDAD = edad;
                }
            }

            if (usuario.getHuscprimernomb() != null) {
                NOMBRES = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRES = NOMBRES + usuario.getHuscsegundnomb();
            }
            if (usuario.getHuscprimerapel() != null) {
                PRIMER_APELLIDO = usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                SEGUNDO_APELLIDO = usuario.getHuscsegundapel();
            }
            if (usuario.getHusetipoiden() != null) {
                TIPO_DOCUMENTO = usuario.getHusetipoiden().toString();
            }
            if (usuario.getHusanumeiden() != 0) {
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }
        }
        
        Chconducta conducta = null; 
        
        if(consulta.getChconductas()!= null && !consulta.getChconductas().isEmpty()){
        
        Iterator it = consulta.getChconductas().iterator(); 
        
        if(it.hasNext()){
            conducta = (Chconducta)it.next(); 
        }
        
        if(conducta!= null){
            if (conducta.getHcndfecregistr() != null) {
                fecha = conducta.getHcndfecregistr();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fecha);
                Integer diaact = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mesact = calendar.get(Calendar.MONTH) + 1;
                Integer ANOact = calendar.get(calendar.YEAR);

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

                ANO = ANOact.toString();

                String hora = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
                String minuto = String.valueOf(calendar.get(Calendar.MINUTE));
                if (calendar.get(Calendar.HOUR_OF_DAY) < 10) {
                    hora = "0" + hora;
                }
                if (calendar.get(Calendar.MINUTE) < 10) {
                    minuto = "0" + minuto;
                }


            }

            if (conducta != null) {
                DESCRIPCION_RECOMENDACIONES = conducta.getHcncobservacio();
            }

            if (conducta.getHcncoperador() != null) {
                Cpprofesio profesional;
                profesional = null;
                try {
                    if (consulta != null && 
                        consulta.getHconclinica() != null) {
                        profesional = 
                                serviceLocator.getClinicoService().getProfesionalPorUsuario(conducta.getHcncoperador().toLowerCase(), 
                                                                                            consulta.getHconclinica());
                    }
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (profesional != null) {
                    NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                    REGISTRO_MEDICO = profesional.getCpfcregmedic();
                    ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                    TIPOID_PROFESIONAL = profesional.getCpfctipide();
                    NUMID_PROFESIONAL = profesional.getCpfacedula();
                }
            }
          }
       }
    }

    public void generarInterconsulta() {
        FacesUtils.resetManagedBean("interConsultaUsuarioBean");
        try {
            InterConsultaUsuarioBean interConsultaUsuario = (InterConsultaUsuarioBean)FacesUtils.getManagedBean("interConsultaUsuarioBean");
    
            if (interConsultaUsuario != null) {
                byte[] bytes = interConsultaUsuario.generarReporteInterConsulta(consulta.getHcolnumero(), 1, consulta.getHcoctiposervi());
                if (bytes != null) {
                    PdfServletUtils.showPdfDocument(bytes, 
                                            "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                            ".pdf", false);
                    generoDocumento = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }

    
/*        this.index = -1;
        try {
           URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/Remision_Interconsulta.jasper");
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
                                                "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);
                generoDocumento = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
*/        
    }


    public void obtenerDatosControlSinCosto() {
        //TODO: VOLVER A REALIZAR LA REIMPRESION DEL CONTROL SIN COSTO
    }

    public void generarControlSinCosto() {
        this.index = -1;
        try {
           URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/FO-GS-CS-EC-064_V02.jasper");
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
                                                "ControlSinCosto" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);
                generoDocumento = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
    }
    
    
    
    public void generarRecomendaciones(){
        this.index = -1;
        try {
            URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/recomendaciones.jasper");
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
                                                "Recomendaciones" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);
                generoDocumento = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
    }
    
    public void generarCertificadoAsistencia(){
        this.index = -1;
        try {
           URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/certificadoAsistencia.jasper");
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
                                                "CertificadoAsistencia" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);
                generoDocumento = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
    }
        
    public void generarCertificadoMedico(){
         this.index = -1;
         try {
             URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/certificadoMedico.jasper");
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
                                                 "CertificadoMedico" + Calendar.getInstance().getTimeInMillis() + 
                                                 ".pdf", false);
                 generoDocumento = true;
             }
         } catch (Exception e) {
             e.printStackTrace();
             FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
         }
    }
            
    public void reImprimirDocumento() {
        generoDocumento = false;
        if (documentoSelect != null && !documentoSelect.equals("")) {
            obtenerDatosComunes();
            if (documentoSelect.equals(CONDUCTA_ANATOMIA_PATOLOGICA)) {
                obtenerDatosReporteAnatomiaPatologica();
                generarAnatomia();
            }
            if (documentoSelect.equals(CONDUCTA_REFERENCIA)) {
                obtenerDatosReporteReferencia();
                generarReferencia();
            }

            if (documentoSelect.equals(CONDUCTA_ORDEN_CIRUGIA)) {
                obtenerDatosOrdenCirugia();
                generarOrdenCirugia();
            }

            if (documentoSelect.equals(CONDUCTA_FORMULA_MEDICA)) {
                obtenerDatosFormulaMedica();
                generarFormulaMedica();
            }

            if (documentoSelect.equals(CONDUCTA_INCAPACIDAD)) {
                obtenerDatosIncapacidad();
                generarIncapacidad();
            }

            if (documentoSelect.equals(CONDUCTA_EXAMENES_LABORATORIOS)) {
//                obtenerDatosLaboratorio();
                generarLaboratorio();
            }

            if (documentoSelect.equals(CONDUCTA_EXAMENES_IMAGENES)) {
                obtenerDatosImagenes();
                generarImagenes();
            }

            if (documentoSelect.equals(CONDUCTA_EXAMENES_ELECTROFISIOLOGICOS)) {
                obtenerDatosElectrofisiologicos();
                generarElectrofisiologicos();
            }

            if (documentoSelect.equals(CONDUCTA_INTERCONSULTA)) {
//                obtenerDatosInterconsulta();
                generarInterconsulta();
            }

            if (documentoSelect.equals(CONDUCTA_CONTROL_SIN_COSTO)) {
                obtenerDatosControlSinCosto();
                generarControlSinCosto();
            }
            
            if (documentoSelect.equals(CONDUCTA_CERTIFICADO_ASISTENCIA)) {
                obtenerDatosCertificadoAsistencia();
                generarCertificadoAsistencia(); 
            }
            
            if (documentoSelect.equals(CONDUCTA_CERTIFICADO_MEDICO)) {
                obtenerDatosCertificadoMedico();
                generarCertificadoMedico(); 
            }
            
            if (documentoSelect.equals(CONDUCTA_RECOMENDACIONES) ){
                obtenerDatosRecomendaciones(); 
                generarRecomendaciones(); 
            }
            
            if (documentoSelect.equals(CONDUCTA_AUTORIZACION_SERVICIO) ){
                generarAutorizacionServicios(); 
            }

        }
    }

    public void obtenerDatosReporteConsulta() {

        if(usuario.getHusdfecregistr() != null){
            FECHA = usuario.getHusdfecregistr();
        }
        
        CODIGO_PRESTADOR = " C�DIGO DE PRESTADOR:  "; 
        DIRECCION_PRESTADOR  = " DIRECCI�N:  "; 
        MUNICIPIO_PRESTADOR = " MUNICIPIO:  "; 
        DPTO_PRESTADOR = " DEPARTAMENTO:  "; 
        TEL_PRESTADOR = " TEL�FONO:  "; 
        NOMBRE_PACIENTE = " NOMBRE COMPLETO DEL PACIENTE: "; 
        TIPO_IDEN_PACIENTE = " TIPO IDENTIFICACI�N:  "; 
        NUM_IDE_PACIENTE = " N�MERO DE IDENTIFICACI�N: "; 
        FECHA_NAC_PACIENTE = " FECHA DE NACIMIENTO: "; 
        DIRECCION_PACIENTE = " DIRECCI�N: "; 
        MUNICIPIO_PACIENTE = " MUNICIPIO: "; 
        DEPARTAMENTO_PACIENTE = " DEPARTAMENTO: "; 
        FIJO_PACIENTE = " TEL�FONO FIJO: "; 
        CELUAR_PACIENTE = " TEL�FONO CELULAR: "; 
        CORREO_PACIENTE = " CORREO ELECTR�NICO: ";
        ENTIDAD_PACIENTE = " ENTIDAD ADMINISTRADORA: "; 
        REGIMEN_PACIENTE = " REGIMEN: "; 
        NOMBRE_RESPONSABLE = " NOMBRE: "; 
        TIPO_IDEN_RESPON = " TIPO IDENTIFICACI�N: "; 
        NUMERO_IDEN_RESP = " N�MERO DE IDENTIFICACI�N: "; 
        DIRECCION_RESPONSABLE = " DIRECCI�N: "; 
        MUNICIPIO_RESPONSABLE = " MUNICIPIO: "; 
        DEPARTAMENTO_RESPONSABLE = " DEPARTAMENTO: "; 
        FIJO_RESPONSABLE = " TEL�FONO FIJO: "; 
        CELULAR_RESPONSABLE = " TEL�FONO CELULAR: "; 
        NOMBRE_PROFESIONAL = " NOMBRE DEL PROFESIONAL: "; 
        FIJO_PROFESIONAL = " TEL�FONO FIJO: "; 
        CELULAR_PROFESIONAL  = " TEL�FONO CELULAR: ";      
        LUGAR_PACIENTE = ""; 
        SERVICIO_SOLICITA = ""; 
        ANAMNESIS = "ANAMNESIS: "; 
        HALLAZGOS_EXAMEN_FISICO  = " EX�MEN F�SICO: "; 
        APOYO_DIAGNOSTICO  = " EX�MENES DE APOYO DIAGN�STICO Y EVOLUCI�N: "; 
        DIAGNOSTICO_REFERENCIA = " DIAGN�STICO: "; 
        COMPLICACIONES = " COMPLICACIONES: "; 
        TRATAMIENTOS = " TRATAMIENTOS APLICADOS:  "; 
        MOTIVO = " MOTIVO DE REMISI�N: "; 
        NOMBRE_PROFESIONAL_COMPLETO = " NOMBRE COMPLETO Y REGISTRO DEL PROFESIONAL QUE REMITE: "; 
        MAIL_PRESTADOR = " CORREO ELECTR�NICO: "; 
        PREGUNTA_DILIGENCIA_FORMATO = ""; 
        PREGUNTA_COPIA_HISTORIA = ""; 
        PREGUNTA_RESUL_APOYO = ""; 
        PREGUNTA_CARTA_PAGO = ""; 
        Crdgncie10 diagprin = null;
        Crdgncie10 diagrela1 = null;
        Crdgncie10 diagrela2 = null;
        Crdgncie10 diagrela3 = null;
        
        String HALLAZGOS_EXAMEN_FISICO_REFERENCIA = "";

        
        CODIGO_PRESTADOR = CODIGO_PRESTADOR + getClinica().getCclccodsgs() ; 
        DIRECCION_PRESTADOR  = DIRECCION_PRESTADOR + getClinica().getCclcdirecc(); 
        MUNICIPIO_PRESTADOR = MUNICIPIO_PRESTADOR + getClinica().getCclcciudad(); 
        TEL_PRESTADOR = TEL_PRESTADOR + getClinica().getCclctelefo(); 
        MAIL_PRESTADOR = MAIL_PRESTADOR + getClinica().getCclccorreo();
        
        FIJO_PROFESIONAL = FIJO_PROFESIONAL + getClinica().getCclctelefo();
        
        if (userName() != null) {
            Cpprofesio profesional = null;
            String especialidad = " ";
            try {
                if (this.getClinica() != null) {
//                    profesional = 
//                            serviceLocator.getClinicoService().getProfesionalPorUsuario(userName(), 
//                                                                                       getClinica().getCclncodigo());
                    profesional = 
                            serviceLocator.getClinicoService().getProfesionalPorUsuario(referencia.getHrecoperador(), 
                                                                                       consulta.getHconclinica());
                }

                if (profesional != null) {
                    especialidad = serviceLocator.getClinicoService().getDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                }
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (profesional != null) {
                NOMBRE_PROFESIONAL = NOMBRE_PROFESIONAL + profesional.getCpfcnombre();
                REGISTRO_MEDICO = profesional.getCpfcregmedic();
                ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                TIPOID_PROFESIONAL = profesional.getCpfctipide();
                NUMID_PROFESIONAL = profesional.getCpfacedula();
                NOMBRE_PROFESIONAL_COMPLETO = NOMBRE_PROFESIONAL_COMPLETO  + profesional.getCpfcnombre() + "  RM: " + profesional.getCpfcregmedic();
                
                if (especialidad != null) {
                    NOMBRE_PROFESIONAL_COMPLETO = NOMBRE_PROFESIONAL_COMPLETO  + " " + especialidad;
                }
            }
        }
        
        
        if(referencia.getId().getHrelconsulta() != null){
            try {
                if(referencia != null){
                    if(referencia.getHrecdiagnosti()!= null){
                         diagprin = 
                                    this.serviceLocator.getClinicoService().getCIE10PorCodigo(referencia.getHrecdiagnosti().toUpperCase());
                            if(diagprin != null){
                                DIAGNOSTICO_REFERENCIA = referencia.getHrecdiagnosti()+ " " + diagprin.getCdccdescri() +"  \n.";        
                            }
                        
                    }
                }
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if(referencia.getHreclugarservi()!= null){
            if(referencia.getHreclugarservi().equals("CE")){
                LUGAR_PACIENTE = "Consulta Externa";
            }else if(referencia.getHreclugarservi().equals("CI")){
                LUGAR_PACIENTE = "Cirugia";
            }
        }
        
        if(referencia.getHrecservisolic()!= null){
            SERVICIO_SOLICITA = referencia.getHrecservisolic();    
        }
        
        if(referencia.getHredfecregistr() != null){
            FECHA_REFERENCIA = referencia.getHredfecregistr();
        }
        
        COMPLICACIONES = COMPLICACIONES + referencia.getHreccomplicaci(); 
        TRATAMIENTOS = TRATAMIENTOS + referencia.getHrectrataaplic(); 
        MOTIVO = MOTIVO + referencia.getHrecmotivremis(); 

        if (usuario != null) {
            if (usuario.getHuscprimernomb() != null) {
                NOMBRE_PACIENTE = NOMBRE_PACIENTE  + usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRE_PACIENTE = 
                        NOMBRE_PACIENTE + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                NOMBRE_PACIENTE = 
                        NOMBRE_PACIENTE + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                NOMBRE_PACIENTE = 
                        NOMBRE_PACIENTE + usuario.getHuscsegundapel();
            }
            if (usuario.getHusetipoiden() != null) {
                TIPO_IDEN_PACIENTE = TIPO_IDEN_PACIENTE + usuario.getHusetipoiden().toString();
            }
            if (usuario.getHusanumeiden() != 0) {
                NUM_IDE_PACIENTE = NUM_IDE_PACIENTE + usuario.getHusanumeiden().toString();
            }
         
            DIRECCION_PACIENTE = DIRECCION_PACIENTE + usuario.getHuscdireccion();
           
           if(usuario.getHusdfechanacim() != null) {
               FECHA_NAC_PACIENTE  = FECHA_NAC_PACIENTE + usuario.getHusdfechanacim(); 
           }
          
           if(usuario.getHusctelefono() != null){
               FIJO_PACIENTE  = FIJO_PACIENTE  + usuario.getHusctelefono();
           }
            
           if(usuario.getHusccelular() != null) {
               CELUAR_PACIENTE = CELUAR_PACIENTE +  usuario.getHusccelular();
           }
         
           if(usuario.getHusccorreoelec() != null)  {
               CORREO_PACIENTE = CORREO_PACIENTE  + usuario.getHusccorreoelec() ;
           }
           
            if(usuario.getHuscentidadadm() != null){
                try {
                   EPS  = serviceLocator.getClinicoService().getDescripcionEntidadByCodigo(usuario.getHuscentidadadm());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
             
           if(EPS != null) {
               ENTIDAD_PACIENTE = ENTIDAD_PACIENTE + EPS;
           }
            
           if(usuario.getHusetipoafilia() != null){
               if(usuario.getHusetipoafilia().equals("C")){
                   REGIMEN_PACIENTE = REGIMEN_PACIENTE + "CONTRIBUTIVO"; 
               }else if(usuario.getHusetipoafilia().equals("E")){
                   REGIMEN_PACIENTE = REGIMEN_PACIENTE + "ESPECIAL"; 
               }else if(usuario.getHusetipoafilia().equals("R")){
                   REGIMEN_PACIENTE = REGIMEN_PACIENTE + "SUBSIDIO PARCIAL"; 
               }else if(usuario.getHusetipoafilia().equals("S")){
                   REGIMEN_PACIENTE = REGIMEN_PACIENTE + "SUBSIDIADO"; 
               }else if(usuario.getHusetipoafilia().equals("V")){
                   REGIMEN_PACIENTE = REGIMEN_PACIENTE + "VINCULADO"; 
               }else if(usuario.getHusetipoafilia().equals("X")){
                   REGIMEN_PACIENTE = REGIMEN_PACIENTE + "NINGUNO"; 
               }
           }
             
           PREGUNTA_DILIGENCIA_FORMATO = referencia.getHrecdiligforma();
           PREGUNTA_COPIA_HISTORIA = referencia.getHreccopiahisto();
           PREGUNTA_RESUL_APOYO  = referencia.getHrecresulapoyo();
           PREGUNTA_CARTA_PAGO = referencia.getHreccartapago();
            
            Integer idMunicipio = usuario.getHusnciudad();
            Integer idDpto = usuario.getHusndepartamen();
            Cpmunidane municipio = null;

            try {
                municipio = 
                        this.serviceLocator.getClinicoService().getMunicipio(idMunicipio, 
                                                                             idDpto);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (municipio != null) {
                MUNICIPIO_PACIENTE = MUNICIPIO_PACIENTE + municipio.getCmdcnommun();
            }
            
            if(municipio != null && municipio.getCmdcnommun() != null){
                DEPARTAMENTO_PACIENTE = DEPARTAMENTO_PACIENTE + municipio.getCmdcnomdpt();
            }
        }

        if (referencia != null && referencia.getHrecanamnesis() != null) {
            ANAMNESIS = ANAMNESIS + referencia.getHrecanamnesis();
        }
        if (referencia != null && referencia.getHrecapoyodiagn() != null) {
            APOYO_DIAGNOSTICO = APOYO_DIAGNOSTICO + referencia.getHrecapoyodiagn();
        }

        if (referencia != null && referencia.getHrecnombrespon() != null) {
            NOMBRE_RESPONSABLE =  NOMBRE_RESPONSABLE + referencia.getHrecnombrespon();
        }
        if (referencia != null && referencia.getHrecdirecrespo() != null) {
            DIRECCION_RESPONSABLE = DIRECCION_RESPONSABLE + referencia.getHrecdirecrespo();
        }
        if (referencia != null && referencia.getHrectelefrespo() != null) {
            FIJO_RESPONSABLE= FIJO_RESPONSABLE + referencia.getHrectelefrespo();
        }
        
        if (referencia != null && referencia.getHreccelulrespo() != null) {
            CELULAR_RESPONSABLE= CELULAR_RESPONSABLE + referencia.getHreccelulrespo();
        }
        if(referencia != null && referencia.getHreetipideresp() != null){
            TIPO_IDEN_RESPON = TIPO_IDEN_RESPON + referencia.getHreetipideresp();
        }
        if(referencia != null && referencia.getHrectiporefere() != null){
            NUMERO_IDEN_RESP = NUMERO_IDEN_RESP +  referencia.getHreanumideresp();
        }
        
        Integer idMunicipioResp = referencia.getHrenciudarespo();
        Integer idDptoResp = referencia.getHrendeparrespo();
        Cpmunidane municipioResp = null;

        try {
            municipioResp = 
                    this.serviceLocator.getClinicoService().getMunicipio(idMunicipioResp, 
                                                                         idDptoResp);
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (municipioResp != null) {
            MUNICIPIO_RESPONSABLE= MUNICIPIO_RESPONSABLE + municipioResp.getCmdcnommun();
        }
        
        if(municipioResp != null && municipioResp.getCmdcnommun() != null){
            DEPARTAMENTO_RESPONSABLE = DEPARTAMENTO_RESPONSABLE + municipioResp.getCmdcnomdpt();
        }
        
        if (referencia != null && referencia.getHrecapoyodiagn() != null) {
            EVOLUCION = EVOLUCION + referencia.getHrecjustirefer();
        }
        
        if (referencia != null && referencia.getHrecapoyodiagn() != null) {
            HALLAZGOS_EXAMEN_FISICO_REFERENCIA = HALLAZGOS_EXAMEN_FISICO_REFERENCIA + referencia.getHrecexamfisc();
        }
        
        

        HALLAZGOS_EXAMEN_FISICO = HALLAZGOS_EXAMEN_FISICO + hallazgos;
        lstInformacionClinica = new ArrayList();
        lstInformacionClinica.add("ANAMNESIS: "+ANAMNESIS + "\n");
        lstInformacionClinica.add("EXAMEN FISICO:  " +HALLAZGOS_EXAMEN_FISICO_REFERENCIA + "\n");
        lstInformacionClinica.add("EX�MENES DE APOYO DIAGN�STICO: " + APOYO_DIAGNOSTICO + "\n");
        lstInformacionClinica.add("EVOLUCI�N: " + EVOLUCION+ "\n");
        lstInformacionClinica.add("DIAGN�STICO: " +DIAGNOSTICO_REFERENCIA + "\n");
        lstInformacionClinica.add("COMPLICACIONES: " + COMPLICACIONES + "\n");
        lstInformacionClinica.add("TRATAMIENTOS APLICADOS: " +TRATAMIENTOS + "\n");
        lstInformacionClinica.add("MOTIVO DE REMISI�N: "+ MOTIVO + "\n");
        
    }

    public void obtenerDatosReporteCirugia() {

        Chusuario usuarioAux;
        usuarioAux = null;

        if (usuario != null) {
            usuarioAux = usuario;
        }
        CODIGO_PRESTADOR = " C�DIGO DE PRESTADOR:  "; 
        DIRECCION_PRESTADOR  = " DIRECCI�N:  "; 
        MUNICIPIO_PRESTADOR = " MUNICIPIO:  "; 
        DPTO_PRESTADOR = " DEPARTAMENTO:  "; 
        TEL_PRESTADOR = " TEL�FONO:  "; 
        NOMBRE_PACIENTE = " NOMBRE COMPLETO DEL PACIENTE: "; 
        TIPO_IDEN_PACIENTE = " TIPO IDENTIFICACI�N:  "; 
        NUM_IDE_PACIENTE = " N�MERO DE IDENTIFICACI�N: "; 
        FECHA_NAC_PACIENTE = " FECHA DE NACIMIENTO: "; 
        DIRECCION_PACIENTE = " DIRECCI�N: "; 
        MUNICIPIO_PACIENTE = " MUNICIPIO: "; 
        DEPARTAMENTO_PACIENTE = " DEPARTAMENTO: "; 
        FIJO_PACIENTE = " TEL�FONO FIJO: "; 
        CELUAR_PACIENTE = " TEL�FONO CELULAR: "; 
        CORREO_PACIENTE = " CORREO ELECTR�NICO: ";
        ENTIDAD_PACIENTE = " ENTIDAD ADMINISTRADORA: "; 
        REGIMEN_PACIENTE = " REGIMEN: "; 
        NOMBRE_RESPONSABLE = " NOMBRE: "; 
        TIPO_IDEN_RESPON = " TIPO IDENTIFICACI�N: "; 
        NUMERO_IDEN_RESP = " N�MERO DE IDENTIFICACI�N: "; 
        DIRECCION_RESPONSABLE = " DIRECCI�N: "; 
        MUNICIPIO_RESPONSABLE = " MUNICIPIO: "; 
        DEPARTAMENTO_RESPONSABLE = " DEPARTAMENTO:"; 
        FIJO_RESPONSABLE = " TEL�FONO FIJO: "; 
        CELULAR_RESPONSABLE = " TEL�FONO CELULAR: "; 
        NOMBRE_PROFESIONAL = " NOMBRE DEL PROFESIONAL: "; 
        FIJO_PROFESIONAL = " TEL�FONO FIJO: "; 
        CELULAR_PROFESIONAL  = " TEL�FONO CELULAR: ";      
        LUGAR_PACIENTE = ""; 
        SERVICIO_SOLICITA = ""; 
        ANAMNESIS = "ANAMNESIS: "; 
        HALLAZGOS_EXAMEN_FISICO  = " EX�MEN F�SICO: "; 
        APOYO_DIAGNOSTICO  = " EX�MENES DE APOYO DIAGN�STICO Y EVOLUCI�N: "; 
        DIAGNOSTICO_REFERENCIA = " DIAGN�STICO: "; 
        COMPLICACIONES = " COMPLICACIONES: "; 
        TRATAMIENTOS = " TRATAMIENTOS APLICADOS:  "; 
        MOTIVO = " MOTIVO DE REMISI�N: "; 
        NOMBRE_PROFESIONAL_COMPLETO = " NOMBRE COMPLETO Y REGISTRO DEL PROFESIONAL QUE REMITE: "; 
        MAIL_PRESTADOR = " CORREO ELECTR�NICO: "; 
        
        CODIGO_PRESTADOR = CODIGO_PRESTADOR + getClinica().getCclccodsgs() ; 
        DIRECCION_PRESTADOR  = DIRECCION_PRESTADOR + getClinica().getCclcdirecc(); 
        MUNICIPIO_PRESTADOR = MUNICIPIO_PRESTADOR + getClinica().getCclcciudad(); 
        TEL_PRESTADOR = TEL_PRESTADOR + getClinica().getCclctelefo(); 
        MAIL_PRESTADOR = MAIL_PRESTADOR + getClinica().getCclccorreo();
        
        if (userName() != null) {
            Cpprofesio profesional = null;
            String especialidad = " ";
            try {
                if (this.getClinica() != null) {
                //                    profesional =
                //                            serviceLocator.getClinicoService().getProfesionalPorUsuario(userName(),
                //                                                                                       getClinica().getCclncodigo());
                    profesional = 
                            serviceLocator.getClinicoService().getProfesionalPorUsuario(referencia.getHrecoperador(), 
                                                                                       getClinica().getCclncodigo());
                }

                if (profesional != null) {
                    especialidad = serviceLocator.getClinicoService().getDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                }
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (profesional != null) {
                NOMBRE_PROFESIONAL = NOMBRE_PROFESIONAL + profesional.getCpfcnombre();
                REGISTRO_MEDICO = profesional.getCpfcregmedic();
                ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                TIPOID_PROFESIONAL = profesional.getCpfctipide();
                NUMID_PROFESIONAL = profesional.getCpfacedula();
                NOMBRE_PROFESIONAL_COMPLETO = NOMBRE_PROFESIONAL_COMPLETO  + profesional.getCpfcnombre() + "  RM: " + profesional.getCpfcregmedic();

                if (especialidad != null) {
                    NOMBRE_PROFESIONAL_COMPLETO = NOMBRE_PROFESIONAL_COMPLETO  + " " + especialidad;
                }
            }
        }

        if (usuario != null) {
            if (usuario.getHuscprimernomb() != null) {
                NOMBRE_PACIENTE = NOMBRE_PACIENTE  + usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRE_PACIENTE = 
                        NOMBRE_PACIENTE + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                NOMBRE_PACIENTE = 
                        NOMBRE_PACIENTE + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                NOMBRE_PACIENTE = 
                        NOMBRE_PACIENTE + usuario.getHuscsegundapel();
            }
            if (usuario.getHusetipoiden() != null) {
                TIPO_IDEN_PACIENTE = TIPO_IDEN_PACIENTE + usuario.getHusetipoiden().toString();
            }
            if (usuario.getHusanumeiden() != 0) {
                NUM_IDE_PACIENTE = NUM_IDE_PACIENTE + usuario.getHusanumeiden().toString();
            }
         
         
            DIRECCION_PACIENTE = DIRECCION_PACIENTE + usuario.getHuscdireccion();
            
           
           if(usuario.getHusdfechanacim() != null) {
               FECHA_NAC_PACIENTE  = FECHA_NAC_PACIENTE + usuario.getHusdfechanacim(); 
           }
          
          
          if(usuario.getHusctelefono() != null){
              FIJO_PACIENTE  = FIJO_PACIENTE  + usuario.getHusctelefono();
          }
            
           if(usuario.getHusccelular() != null) {
               CELUAR_PACIENTE = CELUAR_PACIENTE +  usuario.getHusccelular();
           }
         
           if(usuario.getHusccorreoelec() != null)  {
               CORREO_PACIENTE = CORREO_PACIENTE  + usuario.getHusccorreoelec() ;
           }
           
            if(usuario.getHuscentidadadm() != null){
                try {
                   EPS  = serviceLocator.getClinicoService().getDescripcionEntidadByCodigo(usuario.getHuscentidadadm());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
             
           if(EPS != null) {
               ENTIDAD_PACIENTE = ENTIDAD_PACIENTE + EPS;
           }
            
            if(usuario.getHusetipoafilia() != null){
                if(usuario.getHusetipoafilia().equals("C")){
                    REGIMEN_PACIENTE = REGIMEN_PACIENTE + "CONTRIBUTIVO"; 
                }else if(usuario.getHusetipoafilia().equals("E")){
                    REGIMEN_PACIENTE = REGIMEN_PACIENTE + "ESPECIAL"; 
                }else if(usuario.getHusetipoafilia().equals("R")){
                    REGIMEN_PACIENTE = REGIMEN_PACIENTE + "SUBSIDIO PARCIAL"; 
                }else if(usuario.getHusetipoafilia().equals("S")){
                    REGIMEN_PACIENTE = REGIMEN_PACIENTE + "SUBSIDIADO"; 
                }else if(usuario.getHusetipoafilia().equals("V")){
                    REGIMEN_PACIENTE = REGIMEN_PACIENTE + "VINCULADO"; 
                }else if(usuario.getHusetipoafilia().equals("X")){
                    REGIMEN_PACIENTE = REGIMEN_PACIENTE + "NINGUNO"; 
                }
            }
            
            Integer idMunicipio = usuario.getHusnciudad();
            Integer idDpto = usuario.getHusndepartamen();
            Cpmunidane municipio = null;

            try {
                municipio = 
                        this.serviceLocator.getClinicoService().getMunicipio(idMunicipio, 
                                                                             idDpto);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (municipio != null) {
                MUNICIPIO_PACIENTE = MUNICIPIO_PACIENTE + municipio.getCmdcnommun();
            }
            
            if(municipio != null && municipio.getCmdcnommun() != null){
                DEPARTAMENTO_PACIENTE = DEPARTAMENTO_PACIENTE + municipio.getCmdcnommun();
            }
        }

        if (getUsuarioSystem() != null) {
            NOMBRE_PROFESIONAL = NOMBRE_PROFESIONAL + getUsuarioSystem().getCurcnombre();
        }


        if (referencia != null && referencia.getHrecanamnesis() != null) {
            ANAMNESIS = referencia.getHrecanamnesis();
        }
        if (referencia != null && referencia.getHrecapoyodiagn() != null) {
            APOYO_DIAGNOSTICO = referencia.getHrecapoyodiagn();
        }
       
        if (referencia != null && referencia.getHrecnombrespon() != null) {
            NOMBRE_RESPONSABLE = referencia.getHrecnombrespon();
        }
        if (referencia != null && referencia.getHrecdirecrespo() != null) {
            DIRECCION_RESPONSABLE = referencia.getHrecdirecrespo();
        }
        if (referencia != null && referencia.getHrectelefrespo() != null) {
            FIJO_RESPONSABLE = referencia.getHrectelefrespo();
        }
        
        if(referencia != null && referencia.getHreetipideresp() != null){
            TIPO_IDEN_RESPON = TIPO_IDEN_RESPON + referencia.getHreetipideresp();
        }
        
        if(referencia != null && referencia.getHrectiporefere() != null){
            NUMERO_IDEN_RESP = NUMERO_IDEN_RESP +  referencia.getHreanumideresp();
        }
        
        Integer idMunicipioResp = referencia.getHrenciudarespo();
        Integer idDptoResp = referencia.getHrendeparrespo();
        Cpmunidane municipioResp = null;


        try {
            municipioResp = 
                    this.serviceLocator.getClinicoService().getMunicipio(idMunicipioResp, 
                                                                         idDptoResp);
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (municipioResp != null) {
            MUNICIPIO_RESPONSABLE= MUNICIPIO_RESPONSABLE + municipioResp.getCmdcnommun();
        }
        
        if(municipioResp != null && municipioResp.getCmdcnommun() != null){
            DEPARTAMENTO_RESPONSABLE = DEPARTAMENTO_RESPONSABLE + municipioResp.getCmdcnommun();
        }
        
        HALLAZGOS_EXAMEN_FISICO = hallazgos;
    }


    public byte[] generarPdfAutorizacionServicio() {

        Chautoriserv autoriserv = new Chautoriserv();
        Cpempresa empresa = new Cpempresa();
        Cpclinica clinica = new Cpclinica();
        Cpprofesio profesional = new Cpprofesio();
        Crdgncie10 diagPrin = new Crdgncie10();
        Crdgncie10 diagRel1 = new Crdgncie10();
        Crdgncie10 diagRel2 = new Crdgncie10();
        Cpmunidane munipres = new Cpmunidane();
        Cpmunidane muniusua = new Cpmunidane();
        Cpentidadadm entidadadm = new Cpentidadadm();
        byte[] bytes = null;
        
        try {
            if (consulta != null && consulta.getHcolnumero() != null) {
                autoriserv = 
                        this.getServiceLocator().getClinicoService().getAutorizacion(consulta.getHcolnumero());
                lstServiciosAutorizacion = 
                        this.getServiceLocator().getClinicoService().getListServicioss(consulta.getHcolnumero());
                empresa = 
                        this.serviceLocator.getClinicoService().getEmpresa(1);

            }
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (autoriserv != null && !lstServiciosAutorizacion.isEmpty()) {
            CONSECUTIVO = autoriserv.getHaunconsecutiv();
            FECHA = autoriserv.getHaudfecharegis();
            COBERTURA_SALUD = autoriserv.getHauecobersalud();
            ORIGEN_ATENCION = autoriserv.getHaunorigenate().toString();
            PRIORIDAD_ATENCION = autoriserv.getHaucprioriaten();
            UBICACION = autoriserv.getHaueubicapacie();
            TIPO_SERVICIOS = autoriserv.getHauctipsersoli();
            SERVICIO_HOS = autoriserv.getHaucservhospi();
            CAMA_HOS = autoriserv.getHauncamahospi();
            MANEJO_INTEGRAL = autoriserv.getHaucmansegugui();
            JUSTIFICACION_CLINICA = autoriserv.getHaucjustifclin();
            TEL_INFORMA = autoriserv.getHauctelinform();
            EXT_INFORMA = autoriserv.getHaucextinform();
            CEL_INFORMA = autoriserv.getHauccelinform();
            try {
                clinica =
                    this.getServiceLocator().getClinicoService().getClinica(autoriserv.getHaunclinica());
                profesional = 
                    this.getServiceLocator().getClinicoService().getProfesionalPorUsuario(autoriserv.getHaucoperador(), 
                                                                                    autoriserv.getHaunclinica());
                entidadadm = 
                    this.getServiceLocator().getClinicoService().getEntidadEpsxCodigo(autoriserv.getHaucentidad());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (empresa != null) {
                NOMBRE_SOLICITANTE = empresa.getCemcnombre();
                NIT_SOLICITANTE = empresa.getCemanit().toString() + "-5";
            }

            if (clinica != null) {
                CODIGO_PRESTADOR = clinica.getCclccodsgs() ; 
                DIRECCION_PRESTADOR  = clinica.getCclcdirecc(); 
                CODMUNICIPIO_PRESTADOR = clinica.getCclncoddane(); 
                TEL_PRESTADOR = clinica.getCclctelefo(); 
            
                if (clinica.getCclncoddane() != null) {
                    int coddep = new Integer(clinica.getCclncoddane().substring(0,2));
                    int codmun = new Integer(clinica.getCclncoddane().substring(2));
                    try {
                        munipres =
                          this.getServiceLocator().getClinicoService().getMunicipio(codmun, coddep);
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                }
                if (munipres != null) {
                    DEPARTAMENTO_PRESTADOR = munipres.getCmdcnomdpt();
                    MUNICIPIO_PRESTADOR = munipres.getCmdcnommun();
                }
            }

            if (entidadadm != null) {
                ENTIDAD_PAGO = entidadadm.getCeacnombre();
            }

            if (autoriserv.getHaucentidad() == null) {
                CODENTIDAD_PAGO = " ";
            } else {
                CODENTIDAD_PAGO = autoriserv.getHaucentidad();
            }

            if (usuario != null) {
                APELLIDO1 = usuario.getHuscprimerapel();
                APELLIDO2 = usuario.getHuscsegundapel();
                NOMBRE1 = usuario.getHuscprimernomb();
                NOMBRE2 = usuario.getHuscsegundnomb();
                TIPO_IDENTI = usuario.getHusetipoiden().toString();
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
                DIRECCION_USUARIO = usuario.getHuscdireccion();
                TELEFONO_USUARIO = usuario.getHusctelefono();
                FECHA_NACIMIENTO = usuario.getHusdfechanacim();
                CELULAR = usuario.getHusccelular();
                CORREO_PACIENTE = usuario.getHusccorreoelec();

                try {
                    muniusua =
                          this.getServiceLocator().getClinicoService().getMunicipio(usuario.getHusnciudad(), usuario.getHusndepartamen());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (muniusua != null) {
                    DEPARTAMENTO = muniusua.getCmdcnomdpt();
                    CIUDAD = muniusua.getCmdcnommun();
                    CODCIUDAD = muniusua.getCmdcdane();
                }
            }

            try {
                if (autoriserv.getHaucdiagnprinc() != null) {
                    diagPrin = this.getServiceLocator().getClinicoService().getCIE10PorCodigo(autoriserv.getHaucdiagnprinc());
                    DIAGNOSTICO_PRINCIPAL = autoriserv.getHaucdiagnprinc();
                    DESCRIPCION_PRINCIPAL = diagPrin.getCdccdescri();
                } else {
                    DIAGNOSTICO_PRINCIPAL = "";
                    DESCRIPCION_PRINCIPAL = "";
                }
            
                if (autoriserv.getHaucdiagrelac1() != null) {
                    diagRel1 = this.getServiceLocator().getClinicoService().getCIE10PorCodigo(autoriserv.getHaucdiagrelac1());
                    DIAGNOSTICO_RELACIONA1 = autoriserv.getHaucdiagrelac1();
                    DESCRIPCION_RELACIONA1 = diagRel1.getCdccdescri();
                } else {
                    DIAGNOSTICO_RELACIONA1 = "";
                    DESCRIPCION_RELACIONA1 = "";
                }

                if (autoriserv.getHaucdiagrelac2() != null) {
                    diagRel2 = this.getServiceLocator().getClinicoService().getCIE10PorCodigo(autoriserv.getHaucdiagrelac2());
                    DIAGNOSTICO_RELACIONA2 = autoriserv.getHaucdiagrelac2();
                    DESCRIPCION_RELACIONA2 = diagRel2.getCdccdescri();
                } else {
                    DIAGNOSTICO_RELACIONA2 = "";
                    DESCRIPCION_RELACIONA2 = "";
                }
            
            } catch (ModelException e) {
                e.printStackTrace();
            }


            if (profesional != null) {
                NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                TIPOID_PROFESIONAL = profesional.getCpfctipide();
                NUMID_PROFESIONAL = profesional.getCpfacedula();
                TIPOID_PROFESIONAL = profesional.getCpfctipide();
                NUMID_PROFESIONAL = profesional.getCpfacedula();
                try {
                    CARGO_SOLICITASERV = 
                        this.getServiceLocator().getClinicoService().getDescripcionTipoProfesional(profesional.getCpfntippro());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }

            try {
                index = -1;
            
                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/SolicitudAutorizacionServicios.jasper");
                URL url_escudo = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_ESCUDO_COLOMBIA);
                if (url != null) {
                    Map parameters = new HashMap();
                    parameters.put("IMAGE_ESCUDO_COLOMBIA", url_escudo);

                    JasperReport report = (JasperReport)JRLoader.loadObject(url);

                    bytes = 
                        JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);

                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
            }
        }
        return bytes;
    }        

    public void generarAutorizacionServicios() {
        byte[] result = null;
        if (consulta != null && usuario != null) {       
            result = generarPdfAutorizacionServicio();
        }
        if (result != null) {
            generoDocumento = true;
            PdfServletUtils.showPdfDocument(result,"AutorizacionServicio.pdf", false);
        } else {
            FacesUtils.addErrorMessage("No hay datos de Autorizaci�n de Servicios");
        }
    }
}
