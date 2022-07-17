//=======================================================================
// ARCHIVO ConsultarFoliosBean.java
// FECHA CREACINN: 26/05/2010
// AUTOR: JosN AndrNs RiaNo
// DescripciNn: Creacion de Reporte de consultar folios.
//=======================================================================
package org.profamilia.hc.view.backing.clinico.consultas;

import java.io.File;
import java.io.IOException;

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

import javax.faces.application.ViewHandler;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
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
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.codec.binary.Base64;


import org.apache.myfaces.renderkit.html.util.AddResource;

import org.apache.myfaces.renderkit.html.util.AddResourceFactory;

import org.profamilia.hc.model.dto.AntecedentesGeneralesDTO;
import org.profamilia.hc.model.dto.Chanatopatol;
import org.profamilia.hc.model.dto.Chantalerg;
import org.profamilia.hc.model.dto.Chantecegene;
import org.profamilia.hc.model.dto.Chanteceobst;
import org.profamilia.hc.model.dto.Chantecprena;
import org.profamilia.hc.model.dto.Chantecpsico;
import org.profamilia.hc.model.dto.Chantecvasec;
import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chantfami;
import org.profamilia.hc.model.dto.Chantfarma;
import org.profamilia.hc.model.dto.Chantit;
import org.profamilia.hc.model.dto.Chantox;
import org.profamilia.hc.model.dto.Chantpatol;
import org.profamilia.hc.model.dto.Chantquir;
import org.profamilia.hc.model.dto.Chanttrans;
import org.profamilia.hc.model.dto.Chanttrauma;
import org.profamilia.hc.model.dto.Chaseavise;
import org.profamilia.hc.model.dto.Chasesoria;
import org.profamilia.hc.model.dto.Chcancecervi;
import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chconducta;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chcontrolpre;
import org.profamilia.hc.model.dto.Chcuestester;
import org.profamilia.hc.model.dto.Chdispoaplic;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chestadpsico;
import org.profamilia.hc.model.dto.Chestermascu;
import org.profamilia.hc.model.dto.Chevalugener;
import org.profamilia.hc.model.dto.Chevoluconsu;
import org.profamilia.hc.model.dto.Chexafisane;
import org.profamilia.hc.model.dto.Chexameparac;
import org.profamilia.hc.model.dto.Chexamfisico;
import org.profamilia.hc.model.dto.Chgestacion;
import org.profamilia.hc.model.dto.Chidentiriesgo;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chincapacida;
import org.profamilia.hc.model.dto.Chinfomamogr;
import org.profamilia.hc.model.dto.Chlogimpresi;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.dto.Chnotamedica;
import org.profamilia.hc.model.dto.Chordecirugi;
import org.profamilia.hc.model.dto.Chpapsicologico;
import org.profamilia.hc.model.dto.Chpladetrat;
import org.profamilia.hc.model.dto.Chproceconsu;
import org.profamilia.hc.model.dto.Chpsicoantec;
import org.profamilia.hc.model.dto.Chrefepaci;
import org.profamilia.hc.model.dto.Chreferencia;
import org.profamilia.hc.model.dto.Chregisexame;
import org.profamilia.hc.model.dto.Chremisilve;
import org.profamilia.hc.model.dto.Chreporte;
import org.profamilia.hc.model.dto.Chresulparac;
import org.profamilia.hc.model.dto.Chrevissiste;
import org.profamilia.hc.model.dto.Chseguavis;
import org.profamilia.hc.model.dto.Chsegutelefo;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chtamizalapr;
import org.profamilia.hc.model.dto.Chtipoafilia;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chvalorprean;
import org.profamilia.hc.model.dto.Chviolencia;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpcontrato;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.dto.Crcausaext;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.dto.Crfinalcon;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.resumen.GenerarFoliosCirugiaBean;
import org.profamilia.hc.view.backing.comun.CerrarConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioCirugiaBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorUsuariosBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE SolicitarAnulacionBean
//=======================================================================

public class ConsultarFoliosBean extends DatosHistoriaBean implements JRDataSource {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chusuario usuario;

    private Date fechaFinal;

    private Date fechaInicial;

    /** Lista de sexos */
    private List<SelectItem> listSexos;

    /** Almacena la lista de los posibles estados civil  */
    private List<SelectItem> listEstadoCivil;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    private Integer edad;

    /** Almacena true si genero el folio seleccionado */
    private boolean generoHistoria;

    private boolean renderInformacionUsuario;

    private boolean renderFolio;

    private boolean wexito;

    private List<Chconsulta> lstResumen;

    StringBuffer sbuffer = new StringBuffer();

    private boolean mostrarReporte;

    private Long numeroUsuario;

    /** Almacena el numero de la consulta*/
    private Long numeroConsulta;

    /** Almacena la consulta seleccionada*/
    private Chconsulta consultaClone;

    private HtmlDataTable dtFolios;

    /** Lista que almacena las consultas de un Usuario */
    private List<Chconsulta> lstFolios;

    private int selectedIndex;

    private boolean renderBuscador;

    private UIInput itNumeroUsuario;

    private String nombreUsuario;

    private String javaScriptText;

    BuscadorUsuariosBean buscador;

    private String urlString;

    private HttpServletRequest request;

    private ServletContext servletContext;

    private boolean renderConsulta;

    // Control Ive
    private String tipoControl;
    private String causaExterna;
    private String finalidadIve;
    private Cpservicio servicio;
    private String toleranText;
    private String presePosteri;
    private String cantisang;
    private String tipo_maniobras;
    private String tipo_interrupcion;
    private List<Crcausaext> ltscausaExternaa;
    private List<Crfinalcon> lstfinalidad;
    private byte[] registrosEnfermeriaByte;
    private boolean renderRegistrosEnf;
    //Otras Asesoria
    private List lstOtrasAsesoria;
    private HtmlDataTable dtConsultaOtrasAsesoria;
    private String OBSERVACIONES;
    private String TIPO_ASESORIA;
    //Asesoria
    private List<Chaseavise> lstAsesoria;
    private HtmlDataTable dtAsesoria;
    //Viniso
     private List<Chsegutelefo> lstViniso;
     private HtmlDataTable dtViniso;
    private List<Object[]>lstVinisoObj;
    private String nombreProfesional;
    private String cargoProfesional;
    private String codigoProfesional;
    private String regProfesional;
    private boolean generoViniso;
    private Date fechaViniso;
    //DATOS ASESOR
    String FECHA_ASESORIA; 
    String FECHA_REGISTRO; 
    String NOMBRE_ASESOR; 
    String CLINICA_ASESORIA; 
    String NOMBRE_ACOMPANANTE;
    String TELEFONO_ACOMPANANTE;
    String DISCRASIA_SANGUNNEA;
    
    private String INTERVENCION_ASESORIA;
    private String AREA_SOMATICA;
    private String AREA_RELACIONAL;
    private String DOCUMENTOS_PRESENTADOS;
    private String DOCUMENTOS_REMISION_INSTITUCION;
    private String DOCUMENTO_OTRO;
    private String HALLAZGOS;
    private String CONDUCTA;
    private String SEGUIMIENTO;
    private String CUAL_CONOCIMIENTO;
    private String CONOCIMIENTO_PROGRAMA;
    private String CONCEPTO_PSICOLOGICO;
    private String INTERVENCION_CRISIS;
    String AGRESOR_CONOCIDO;
    String LUGAR_HECHOS;
    String CUAL_LUGAR;
    String TIEMPO_OCURRENCIA;
    String RELACION_AGRESOR; 
    String PARENTESCO_AGRESOR; 
    String CUAL_PARENTESCO;
    String OTRO_TIEMPO;
    String ACCIONES_PREVIAS;
    String CUAL_ACCION_PREVIA;
    String AFILIACION;
    
    

    
    // Orden de Impresion
    
    static Integer imp_datos_asesoria = 1;
    
    static Integer imp_conocimiento_programa = 2;
    
    static Integer imp_intervencion_asesoria = 3;

    static Integer imp_estado_psicoemocional = 4;

    static Integer imp_documentos_presentados = 5;

    static Integer imp_hallazgos = 6;
    
    static Integer imp_concepto_psicologico = 7;


    static Integer imp_conducta_a_seguir = 8;

    static Integer imp_seguimiento = 9;
    
    boolean visualizarAsesorias;
    
    boolean reporteOtraAsesoria;
    
    private CerrarConsultaUsuarioBean cerrarConsultaUsuarioBean;
    
    /** Lista de motivos de impresion */
    private List<SelectItem> listMotivoImpresion;
    
    private Chlogimpresi logimpresionAux;
    
    private boolean renderValidacionClinicaImpresion;
    
    private String motivoImpresion;
    
    private String motivoImpresionOtraAsesoria;

     
    //parametros reporte primeros Auxilios Psicologia
     protected Date FECHA;
     protected String CLINICA;
     protected String NOMBRES;
     protected String IDENTIFICACION;
     protected Date FECHANTO;
     protected String DESEOLLAMAR;
     protected String SEXO;
     protected String GENERO;
     protected String DIRECCION;
     protected String TELEFONO;
     protected String CIUDAD;
     protected String ZONA;
     protected String ESTADOCIVIL;
     protected String OCUPACION;
     protected String AFILACION;
     protected String ASEGURADORA;
     //protected String EDAD;
     protected String RESPONSABLE;
     protected String TELCONTACTO;
     protected String PARENTESCO;
     protected String OBSERVACION;
    boolean reportePAPsicologia;
    
    


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ConsultarFoliosBean() {
    }

    public void init() {
        sbuffer = new StringBuffer();
        generoHistoria = false;
        print = true;
        renderFolio = false;
        mostrarReporte = false;
        urlString = "";
        javaScriptText = null;
        generoViniso = false;
        lstFolios = new ArrayList<Chconsulta>();
        ltscausaExternaa = new ArrayList<Crcausaext>();
        lstfinalidad = new ArrayList<Crfinalcon>();

        listSexos = new ArrayList<SelectItem>();
        listEstadoCivil = new ArrayList<SelectItem>();
        listTipoIdentificacion = new ArrayList<SelectItem>();
        lstReporte = new ArrayList<Chreporte>();
        if (usuario == null) {
            usuario = new Chusuario();
        }
        renderConsulta = false;
        
        registrosEnfermeriaByte= null;
        
        renderRegistrosEnf= false;
        
        visualizarAsesorias=false;
        
        reporteOtraAsesoria=false;
        
        logimpresionAux = new Chlogimpresi();
        listMotivoImpresion = new ArrayList<SelectItem>();
        
        renderValidacionClinicaImpresion = false;
        
        motivoImpresion= "";
        
        motivoImpresionOtraAsesoria="";
        
    }

    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaciNn fue ingresada correctamente en la base de datos
    //------------------------------------------------------------------------------------------------


    //-----------------------------------------------------------------------
    //  Reporte Jasper
    //-----------------------------------------------------------------------

    /**
     * @return
     */
    public boolean next() {
        index++;
        if (!reporteOtraAsesoria && !reportePAPsicologia &&!generoViniso) {
            return (index < lstReporte.size());
        } else {
            return (index < 1);
        }
    }

    public Object getFieldValue(JRField jrField) {
    
        Object value = null;
        String fieldName = jrField.getName();
    if(generoViniso){
        Object[] b = new Object[lstVinisoObj.size()];
        b = lstVinisoObj.get(index);
        
        if (fieldName.equals("CLINICA")) {        
          value = (String)b[0];
            return value;
        }
        
        else  if (fieldName.equals("NOMBRES")) {        
                if(b[2]!=null){
                    value = (String)b[1]+" "+(String)b[2];
                }
                else{
                    value = (String)b[1];
                }
                return value;
          }
        else if (fieldName.equals("NO_HISTORIA")) {        
            value =(String)b[50]+" "+ ((BigDecimal)b[51]).toString();
            return value;
        }
        else if (fieldName.equals("FECHA")) {        
          value = fechaViniso;
            return value;
        }
        else if (fieldName.equals("PRIM_APELLIDO")) {        
          value = (String)b[3];
            return value;
        }
        else if (fieldName.equals("SEG_APELLIDO")) {        
          value = (String)b[4];
            return value;
        }
        else if (fieldName.equals("LLAMADA")) { 
        value ="N";
        if(b[9]!=null){
            value ="S";
        }
            return value;
        }
        else if (fieldName.equals("OBS_LLAMADAS")) {        
          value = (String)b[9];
            return value;
        }
        else if (fieldName.equals("PH1")) {        
          value = (String)b[17];
            return value;
        }
        else if (fieldName.equals("PH2")) {        
          value = (String)b[18];
            return value;
        }
        else if (fieldName.equals("PH3")) {        
          value = (String)b[19];
            return value;
        }
        else if (fieldName.equals("PH4")) {        
          value = (String)b[20];
            return value;
        }
        else if (fieldName.equals("PH5")) {        
          value = (String)b[21];
            return value;
        }
        else if (fieldName.equals("PH6")) {        
          value = (String)b[22];
            return value;
        }
        else if (fieldName.equals("PH7")) {        
          value = (String)b[23];
            return value;
        }
        else if (fieldName.equals("PH8")) {        
          value = (String)b[24];
            return value;
        }
        else if (fieldName.equals("PHM")) {        
          value = (String)b[25];
            return value;
        }
        else if (fieldName.equals("PHO")) {        
          value = (String)b[26];
            return value;
        }
        else if (fieldName.equals("PHOD")) {        
          value = (String)b[28];
            return value;
        }
        else if (fieldName.equals("PF1")) {        
          value = (String)b[29];
            return value;
        }
        else if (fieldName.equals("PF2")) {        
          value = (String)b[30];
            return value;
        }
        else if (fieldName.equals("PF3")) {        
          value = (String)b[31];
            return value;
        }
        
        else if (fieldName.equals("PF4")) {        
          value = (String)b[32];
            return value;
        }
        else if (fieldName.equals("PFM")) {        
          value = (String)b[33];
            return value;
        }
        else if (fieldName.equals("PFO")) {        
          value = (String)b[34];
            return value;
        }
        else if (fieldName.equals("PFOA")) {        
          value = (String)b[36];
            return value;
        }
        else if (fieldName.equals("PO1")) {        
          value = (String)b[37];
            return value;
        }
        else if (fieldName.equals("PO2")) {        
          value = (String)b[38];
            return value;
        }
        else if (fieldName.equals("PO3")) {        
          value = (String)b[39];
            return value;
        }
        else if (fieldName.equals("PO_CUAL3")) {        
          value = (String)b[40];
            return value;
        }
        else if (fieldName.equals("PO4")) {        
          value = (String)b[41];
            return value;
        }
        else if (fieldName.equals("PO5")) {        
          value = (String)b[42];
            return value;
        }
        else if (fieldName.equals("PO6")) {        
          value = (String)b[44];
            return value;
        }
        else if (fieldName.equals("PO_CUAL6")) {        
          value = (String)b[45];
            return value;
        }
        else if (fieldName.equals("PO7")) {        
          value = (String)b[46];
          if(value !=null && value.equals("S")){
              value ="Sano";
          }
          else if(value !=null && value.equals("E")){
              value = "Enfermo";
          }
            else if(value !=null && value.equals("NA")){
                value = "No Aplica";
            }
            return value;
        }
        else if (fieldName.equals("RECOMENDACIONES")) {        
          value = (String)b[48];
            return value;
        }
        else if (fieldName.equals("NOMBRE_PROFESIONAL")) {        
          value = nombreProfesional;
            return value;
        }
        else if (fieldName.equals("REGISTRO_MEDICO")) {        
          value = regProfesional;
            return value;
        }
        else if (fieldName.equals("CODIGO_MEDICO")) {        
          value = codigoProfesional;
            return value;
        }
        else if (fieldName.equals("CARGO_MEDICO")) {        
          value = cargoProfesional;
            return value;
        }
    }
    else{
        if (fieldName.equals("NOMBRE")) {
            value = NOMBRE;
        } else if (fieldName.equals("TIPO_DOCUMENTO")) {
            value = TIPO_DOCUMENTO;
        } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
            value = NOMBRE_PROFESIONAL;
        } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = NUMERO_DOCUMENTO;
        } else if (fieldName.equals("FECHA_NACIMIENTO")) {
            value = FECHA_NACIMIENTO;
        } else if (fieldName.equals("DIRECCION")) {
            value = DIRECCION;
        } else if (fieldName.equals("ZONA")) {
            value = ZONA;
        }else if (fieldName.equals("ESTRATO")) {
            value = ESTRATO;
        }else if (fieldName.equals("NIVELEDUCATIVO")) {
            value = NIVELEDUCATIVO;
        }else if (fieldName.equals("ETNIA")) {
            value = ETNIA;
        }else if (fieldName.equals("OCUPACION")) {
            value = OCUPACION;
            
        } else if (fieldName.equals("CONTRATO")) {
            value = CONTRATO;
            
        } 
       else if (fieldName.equals("RESPONSABLE")) {
            value = RESPONSABLE;
        } else if (fieldName.equals("NOMBRE_ACOMPANANTE")) {
            value = NOMBRE_ACOMPANANTE;
        } else if (fieldName.equals("TELEFONO_ACOMPANANTE")) {
            value = TELEFONO_ACOMPANANTE;
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
        } else if (fieldName.equals("EPS")) {
            value = EPS;
        } else if (fieldName.equals("TIPO_AFILIACION")) {
            value = TIPO_AFILIACION;
        }else if (fieldName.equals("FECHA_INICIAL")) {
            value = fechaInicial;
        } else if (fieldName.equals("FECHA_FINAL")) {
            value = fechaFinal;
        } else if (fieldName.equals("REGISTRO_MEDICO")) {
            value = REGISTRO_MEDICO;
        } else if (fieldName.equals("BARRIO")) {
            value = BARRIO;
        }else if (fieldName.equals("OBSERVACIONES")) {
            value = OBSERVACIONES;
        }else if (fieldName.equals("TIPO_ASESORIA")) {
            value = TIPO_ASESORIA;
        }

        if (lstReporte != null && !lstReporte.isEmpty()) {
            if (fieldName.equals("TIPO")) {
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
            } else if (fieldName.equals("NUMERO_CONSULTA")) {
                value = lstReporte.get(index).getHrenconsulta();
            } else if (fieldName.equals("FECHA_REGISTRO")) {
                value = lstReporte.get(index).getHredfecharegis();
            }
        }


        if (fieldName.equals("OBSERVACIONES")) {
            value = OBSERVACIONES;
        }

        if (fieldName.equals("TIPO_ASESORIA")) {
            value = TIPO_ASESORIA;
        }
        
        
        if (fieldName.equals("FECHA")) {
            value = FECHA;
        }
        if (fieldName.equals("CLINICA")) {
            value = CLINICA;
        }
        if (fieldName.equals("NOMBRES")) {
            value = NOMBRES;
        }
        if (fieldName.equals("IDENTIFICACION")) {
            value = IDENTIFICACION;
        }
        if (fieldName.equals("FECHANTO")) {
            value = FECHANTO;
        }
        if (fieldName.equals("DESEOLLAMAR")) {
            value = DESEOLLAMAR;
        }
        if (fieldName.equals("SEXO")) {
            value = SEXO;
        }
        if (fieldName.equals("GENERO")) {
            value = GENERO;
        }
        if (fieldName.equals("DIRECCION")) {
            value = DIRECCION;
        }
        if (fieldName.equals("TELEFONO")) {
            value = TELEFONO;
        }
        if (fieldName.equals("CIUDAD")) {
            value = CIUDAD;
        }
        if (fieldName.equals("ZONA")) {
            value = ZONA;
        }
        if (fieldName.equals("ESTADOCIVIL")) {
            value = ESTADOCIVIL;
        }
        if (fieldName.equals("OCUPACION")) {
            value = OCUPACION;
        }
        if (fieldName.equals("AFILACION")) {
            value = AFILACION;
        }
        if (fieldName.equals("ASEGURADORA")) {
            value = ASEGURADORA;
        }
        if (fieldName.equals("EDAD")) {
            value = EDAD;
        }
        if (fieldName.equals("RESPONSABLE")) {
            value = RESPONSABLE;
        }
        if (fieldName.equals("PARENTESCO")) {
            value = PARENTESCO;
        }
        if (fieldName.equals("TELCONTACTO")) {
            value = TELCONTACTO;
        }
        if (fieldName.equals("OBSERVACION")) {
            value = OBSERVACION;
        }
    }
        return value;
    }

    /**
     * Metodo que obtiene los datos para generar la CirugNas y procedimientos 
     */
    public void obtenerDatosReporte(Chconsulta consulta) {
        // Obtenemos los datos del usuario 
        resetDatos();
        

        
        if(consulta != null  && consulta .getHcolnumero()!= null ){{
               CONTRATO = nombrecontratoxconsulta(consulta .getHcolnumero()) ;   
            }
            
        }

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
                    EPS = serviceLocator.getClinicoService().getDescripcionEntidadByCodigo(usuario.getHuscentidadadm());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }

            if (usuario.getHusetipoafilia() != null) {

                    ArrayList<Chtipoafilia> listTipoAfiliacionAux = null;
                    try {
                        listTipoAfiliacionAux = 
                                (ArrayList<Chtipoafilia>)this.getServiceLocator().getClinicoService().getTipoafiliado();
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (!listTipoAfiliacionAux.isEmpty()) {

                        Iterator it = listTipoAfiliacionAux.iterator();
                        int i = 0;
                        while (it.hasNext()) {
                            it.next();
                            if (usuario.getHusetipoafilia().equals(listTipoAfiliacionAux.get(i).getCtaecodigo().toString())) {
                                TIPO_AFILIACION = 
                                        listTipoAfiliacionAux.get(i).getCtacdescripcio();
                            }
                            i++;
                        }
                    }
            }


            SEXO = formatearCampoSexo(usuario.getHusesexo());
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
            

                 ZONA = formatearCampoZona(usuario.getHusezonareside());
                 ESTRATO = usuario.getHusnestrato();
                 BARRIO = usuario.getHuscbarrio();
                 NIVELEDUCATIVO = formatearCampoNivelEducativo(usuario.getHusnniveledu());
                 ETNIA = formatearCampoEtnia(usuario.getHuscetnia());
            
            
            ESTADO_CIVIL = formatearEstadoCivil(usuario.getHuseestadcivil());
            RESPONSABLE = usuario.getHuscnomresponsa();
            NOMBRE_ACOMPANANTE = usuario.getHuscnomacompana();
            TELEFONO_ACOMPANANTE = usuario.getHusctelacompana();
            PARENTESCO_RESPONSABLE = usuario.getHuscparresponsa();
            TELEFONO_RESPONSABLE = usuario.getHusctelresponsa();
            if (usuario.getHusdfecregistr() != null) {
                FECHA_CONSULTA = usuario.getHusdfecregistr().toString();
            }
        }

        if (consulta != null) {
            if (consulta.getHcocoperador() != null) {
                Cpprofesio profesional;
                profesional = null;
                try {
                    if (this.getClinica() != null) {
                        profesional = 
                                serviceLocator.getClinicoService().getProfesionalPorUsuario(consulta.getHcocoperador(), 
                                                                                            consulta.getHconclinica());
                    }
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (profesional != null) {
                    NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                    REGISTRO_MEDICO = profesional.getCpfcregmedic();
                    TIPOID_PROFESIONAL = profesional.getCpfctipide();
                    NUMID_PROFESIONAL = profesional.getCpfacedula();
                    try {
                        PROFESION = 
                                this.serviceLocator.getClinicoService().getDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                }
            }

            if (consulta.getChvalorprean() != null && 
                !consulta.getChvalorprean().isEmpty()) {
                Chvalorprean valorprean = null;
                Iterator it = consulta.getChvalorprean().iterator();
                if (it.hasNext()) {
                    valorprean = (Chvalorprean)it.next();
                }

                if (valorprean != null && 
                    valorprean.getHvpcintervenci() != null && 
                    valorprean.getHvpccirujano() != null) {
                    INTERVENCION_PREANESTESIA = "";
                    StringTokenizer st = 
                        new StringTokenizer(valorprean.getHvpcintervenci(), 
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
                            INTERVENCION_PREANESTESIA = 
                                    INTERVENCION_PREANESTESIA + ", " + 
                                    servicioAux.getCsvccodigo() + " " + 
                                    servicioAux.getCsvcnombre();
                        }
                    }

                    if (INTERVENCION_PREANESTESIA != null && 
                        INTERVENCION_PREANESTESIA.length() > 2) {
                        INTERVENCION_PREANESTESIA = 
                                INTERVENCION_PREANESTESIA.substring(1, 
                                                                    INTERVENCION_PREANESTESIA.length());
                    }

                    MEDICOS_ANESTESIA = "";

                    StringTokenizer st1 = 
                        new StringTokenizer(valorprean.getHvpccirujano(), ",");

                    Cpprofesio profesional = null;

                    while (st1.hasMoreTokens()) {
                        String idMedico = st1.nextToken();

                        try {
                            if (idMedico != null) {
                                profesional = 
                                        this.serviceLocator.getClinicoService().getProfesionalPorCodigo(new BigDecimal(idMedico), 
                                                                                                        consulta.getHconclinica());
                            }
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }
                        if (profesional != null) {
                            MEDICOS_ANESTESIA = 
                                    MEDICOS_ANESTESIA + ", " + profesional.getCpfncodigo() + 
                                    " " + profesional.getCpfcnombre();
                            profesional.getCpfntipoespe();
                        }
                    }
                }
            }

            if (consulta.getChcancecervi() != null && 
                !consulta.getChcancecervi().isEmpty()) {
                Chcancecervi cancerCervix = null;
                Iterator it = consulta.getChcancecervi().iterator();
                if (it.hasNext()) {
                    cancerCervix = (Chcancecervi)it.next();
                }

                if (cancerCervix != null) {
                    ASESOCANCE = 
                            formatearCampo(cancerCervix.getHcccasesocance());
                    RECOMPREVE = 
                            formatearCampo(cancerCervix.getHcccrecompreve());
                    VPHCOMPPRE = 
                            formatearCampo(cancerCervix.getHcccvphcomppre());
                    OTROSTIPOS = 
                            formatearCampo(cancerCervix.getHcccotrostipos());
                    CIENVIRUS = 
                            formatearCampo(cancerCervix.getHccccienvirus());
                    DOSVACUCOL = 
                            formatearCampo(cancerCervix.getHcccdosvacucol());
                    VPHCAUSANT = 
                            formatearCampo(cancerCervix.getHcccvphcausant());
                    TRESDOSIS = 
                            formatearCampo(cancerCervix.getHccctresdosis());
                    INFOCERVA = 
                            formatearCampo(cancerCervix.getHcccinfocerva());
                    ANORMCITOL = 
                            formatearCampo(cancerCervix.getHcccanormcitol());
                    ANTECALERG = 
                            formatearCampo(cancerCervix.getHcccantecalerg());
                    REACIVACUN = 
                            formatearCampo(cancerCervix.getHcccreacivacun());
                    ENFERGRIPA = 
                            formatearCampo(cancerCervix.getHcccenfergripa());
                    ESTAEMBAR = 
                            formatearCampo(cancerCervix.getHcccestaembar());
                    AMAMANTAND = 
                            formatearCampo(cancerCervix.getHcccamamantand());
                    MESTRNORMA = 
                            formatearCampo(cancerCervix.getHcccmestrnorma());
                    TIENEPARTO = 
                            formatearCampo(cancerCervix.getHccctieneparto());
                    METODPLANI = 
                            formatearCampo(cancerCervix.getHcccmetodplani());
                    PIENSEMBAR = 
                            formatearCampo(cancerCervix.getHcccpiensembar());
                    MEDIAHORA = 
                            formatearCampo(cancerCervix.getHcccmediahora());
                    INFORCONSE = 
                            formatearCampo(cancerCervix.getHcccinforconse());
                    CONSUPROFA = 
                            formatearCampo(cancerCervix.getHcccconsuprofa());
                    CUALANORMALIDAD = 
                            formatearCampo(cancerCervix.getHccccualresul());
                    INFORGARDA = 
                            formatearCampo(cancerCervix.getHcccinforgarda());
                    FUR_CERVIX = 
                            formatearCampo(cancerCervix.getHccdfecharegla());
                    FUP_CERVIX = 
                            formatearCampo(cancerCervix.getHccdfechaparto());
                }
            }

            if (consulta.getChmotivocons() != null && 
                !consulta.getChmotivocons().isEmpty()) {
                Chmotivocon motivo = null;
                String doopler_hm = null;

                Iterator it = consulta.getChmotivocons().iterator();
                if (it.hasNext()) {
                    motivo = (Chmotivocon)it.next();
                }

                if (motivo != null) {
                    Integer causa = motivo.getHmcncausaexte();
                    Crcausaext causaObject = null;
                    try {
                    
                    if(causa != null){
                        causaObject = 
                                getServiceLocator().getClinicoService().getCausaExternaPorId(causa);
                    }
                        
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    if (causaObject != null) {
                        DES_MOTIVO_CONSULTA = causaObject.getCcacdescri();

                    }
                    MOTIVO_CONSULTA = 
                            formatearCampo(motivo.getHmctdescripcio());
                    ENFERMEDAD_ACTUAL = 
                            formatearCampo(motivo.getHmctenferactal());

                    if (motivo.getHmccmanioprev() != null) {
                        if (motivo.getHmccmanioprev().equals("S")) {
                            tipo_maniobras = "";
                            if (motivo.getHmccmaniofarma() != null && motivo.getHmccmaniofarma().equals("S")) {
                                tipo_maniobras = 
                                        tipo_maniobras + " IntervenciNn farmacolNgica ";
                            }
                            if (motivo.getHmccmanioinstru() != null && motivo.getHmccmanioinstru().equals("S")) {
                                tipo_maniobras = 
                                        tipo_maniobras + " IntervenciNn instrumentada ";
                            }
                            if (motivo.getHmccmaniootro() != null && motivo.getHmccmaniootro().equals("S")) {
                                tipo_maniobras = 
                                        tipo_maniobras + " Otra: Cual:  " + motivo.getHmccmaniootrodesc();
                            }
                            MANIOBRAS = formatearCampo(tipo_maniobras);
                            if (motivo.getHmccmanioobser() != null) {
                                OBSMANIOBRAS = 
                                        formatearCampo(motivo.getHmccmanioobser());
                            }else{
                                OBSMANIOBRAS = "Ninguna";
                            }
                        }else if (motivo.getHmccmanioprev().equals("N")){
                            MANIOBRAS = "NO";
                        }

                    }

                    if (motivo.getHmccinteractua() != null) {
                        if (motivo.getHmccinteractua().equals("S")) {
                            tipo_interrupcion = "";
                            if (motivo.getHmccinteroprof() != null && 
                                motivo.getHmccinteroprof().equals("S")) {
                                tipo_interrupcion = 
                                        tipo_interrupcion + " Consulta a otro profesional ";
                            }
                            if (motivo.getHmccinterasegu() != null && 
                                motivo.getHmccinterasegu().equals("S")) {
                                tipo_interrupcion = 
                                        tipo_interrupcion + " Solicitud de atenciNn a asegurador ";
                            }
                            INTERRUPCION = formatearCampo(tipo_interrupcion);
                            if (motivo.getHmccinterobser() != null) {
                                OBSINTERRUPCION = 
                                        formatearCampo(motivo.getHmccinterobser());
                            }else{
                                OBSINTERRUPCION = "Ninguna";
                            }
                        }else{
                            INTERRUPCION = "NO";
                        }

                    }

                    if (motivo.getHmcctipocontr() != null && 
                        !motivo.getHmcctipocontr().equals("")) {
                        if (motivo.getHmcctipocontr() != null && 
                            motivo.getHmcctipocontr().equals("IM")) {
                            tipoControl = "IVE FarmacolNgico";
                        }
                        if (motivo.getHmcctipocontr() != null && 
                            motivo.getHmcctipocontr().equals("QL")) {
                            tipoControl = "IVE QuirNrgico por Bloqueo";
                        }
                        if (motivo.getHmcctipocontr() != null && 
                            motivo.getHmcctipocontr().equals("QG")) {
                            tipoControl = 
                                    "IVE QuirNrgico por Anestesia General";
                        }
                        TIPO_CONTROL = formatearCampo(tipoControl);
                    }
                    if (motivo.getHmcncausaexte() != null) {
                        try {
                            ltscausaExternaa = 
                                    this.serviceLocator.getCirugiaService().getCausaExterna();
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }
                        if (ltscausaExternaa != null && 
                            !ltscausaExternaa.isEmpty()) {
                            for (Crcausaext causas: ltscausaExternaa) {
                                if (motivo.getHmcncausaexte().equals(causas.getCcancodigo())) {
                                    causaExterna = causas.getCcacdescri();
                                }
                            }
                        }
                        CAUSA_EXTERNA = formatearCampo(causaExterna);
                    }
                    if (motivo.getHmcnfinalidad() != null) {
                    String tipoFinalidad = "C";
                        if(motivo != null && motivo.getHmcctipoproce() != null){
                            tipoFinalidad = motivo.getHmcctipoproce();
                        }
                        
                    
                        try {
                            lstfinalidad = 
                                    this.serviceLocator.getClinicoService().getFinalidadesConsultaVG(tipoFinalidad);
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }

                        if (lstfinalidad != null && !lstfinalidad.isEmpty()) {
                            for (Crfinalcon fina: lstfinalidad) {
                                if (motivo.getHmcnfinalidad().equals(fina.getCfcncodigo())) {
                                    finalidadIve = fina.getCfccdescri();
                                }
                            }
                        }
                        FINALIDAD_IVE = formatearCampo(finalidadIve);
                    }


                    if (motivo.getHmccefecsecun() != null && 
                        !motivo.getHmccefecsecun().equals("")) {
                        StringTokenizer stk = 
                            new StringTokenizer(motivo.getHmccefecsecun(), 
                                                ",");
                        String efectoAux = "";
                        String efectoSecundaText = "";
                        EFECTOS_SECUNDARIOS = "";

                        while (stk.hasMoreTokens()) {
                            efectoAux = stk.nextToken();
                            if (efectoAux.equals("NI")) {
                                efectoSecundaText = "Ninguna";
                            }
                            if (efectoAux.equals("NA")) {
                                efectoSecundaText = "Nauseas";
                            }
                            if (efectoAux.equals("ES")) {
                                efectoSecundaText = "EscalofrNos";
                            }
                            if (efectoAux.equals("VO")) {
                                efectoSecundaText = "VNmito";
                            }
                            if (efectoAux.equals("FI")) {
                                efectoSecundaText = "Fiebre";
                            }
                            if (efectoAux.equals("DI")) {
                                efectoSecundaText = "Diarrea";
                            }
                            if (efectoAux.equals("CE")) {
                                efectoSecundaText = "Cefalea";
                            }
                            EFECTOS_SECUNDARIOS = 
                                    EFECTOS_SECUNDARIOS + formatearCampo(efectoSecundaText) + 
                                    ",";
                        }
                    }

                    if (motivo.getHmcnescadolor() != null && 
                        !motivo.getHmcnescadolor().equals("")) {
                        ESCALA_DOLOR = 
                                formatearCampo(motivo.getHmcnescadolor());
                        DURACION_DOLOR = 
                                formatearCampo(motivo.getHmcnduradolor()) + 
                                " " + "Hora(s)";
                        DOLOR_MEDICO = 
                                formatearCampo(motivo.getHmccconsumedi());
                    }

                    if (motivo.getHmcctipocontr() != null) {
                        if (motivo.getHmcctipocontr().equals("QL") || 
                            motivo.getHmcctipocontr().equals("QG")) {
                            if (motivo.getHmcccantisang() != null && 
                                !motivo.getHmcccantisang().equals("")) {
                                if (motivo.getHmcccantisang().equals("MA")) {
                                    cantisang = "Mayor";
                                }
                                if (motivo.getHmcccantisang().equals("ME")) {
                                    cantisang = "Menor";
                                }
                                if (motivo.getHmcccantisang().equals("IG")) {
                                    cantisang = "Igual";
                                }
                                SANGRADO_MESTRU = formatearCampo(cantisang);
                            }
                            DURACION_SANGRADO = 
                                    formatearCampo(motivo.getHmcndurasangr()) + 
                                    "DNa(s)";
                            SANGRADO_MEDICO = 
                                    formatearCampo(motivo.getHmccoblimedic());
                        }
                    }

                    if (motivo.getHmcctipocontr() != null && 
                        motivo.getHmcctipocontr().equals("IM")) {
                        SANGRO = formatearCampo(motivo.getHmccpresangro());
                        if (motivo.getHmcninicisang() != null && 
                            !motivo.getHmcninicisang().equals("")) {
                            TIEMPO_SANGRO = 
                                    formatearCampo(motivo.getHmcninicisang()) + 
                                    " " + "Hora(s)";
                        }
                        SANGRO_MEDICO = 
                                formatearCampo(motivo.getHmccoblimedic());
                        PRESENTO_EXPULSION = 
                                formatearCampo(motivo.getHmccpreseexpu());
                        if (motivo.getHmccexpultran() != null && 
                            !motivo.getHmccexpultran().equals("")) {
                            if (motivo.getHmccexpultran().equals("P")) {
                                presePosteri = "Primera DNsis";
                            }
                            if (motivo.getHmccexpultran().equals("S")) {
                                presePosteri = "Segunda DNsis";
                            }
                            if (motivo.getHmccexpultran().equals("S")) {
                                presePosteri = "Tercera DNsis";
                            }
                            PRESENTO_POSTERIOR = formatearCampo(presePosteri);
                        }
                        HORAS_EXPULSION = 
                                formatearCampo(motivo.getHmcnprimexpul());
                    }

                    if (motivo.getHmccrepoecogr() != null && 
                        !motivo.getHmccrepoecogr().equals("")) {
                        REPORTE_ECOGRAFIA = 
                                formatearCampo(motivo.getHmccrepoecogr());
                        GROSOR_ENDOMETRIAL = 
                                formatearCampo(motivo.getHmcngrosendom()) + 
                                "mm";
                        DOPPLER = formatearCampo(motivo.getHmccdopplerva());

                        if (motivo.getHmccdoppcardn() != null && 
                            !motivo.getHmccdoppcardn().equals("")) {
                            if (motivo.getHmccdoppcardn().equals("PO")) {
                                doopler_hm = "POSITIVO";
                                DOPPLER_PN = formatearCampo(doopler_hm);
                            } else {
                                doopler_hm = "NEGATIVO";
                                DOPPLER_PN = formatearCampo(doopler_hm);
                            }
                        }
                    }

                    if (motivo.getHmcccompmulti() != null && 
                        !motivo.getHmcccompmulti().equals("")) {
                        StringTokenizer stk1 = 
                            new StringTokenizer(motivo.getHmcccompmulti(), 
                                                ",");
                        String complicaAux = "";
                        String complicacionesText = "";
                        COMPLICACIONES = "";

                        while (stk1.hasMoreTokens()) {
                            complicaAux = "";
                            complicacionesText = "";
                            complicaAux = stk1.nextToken();
                            if (complicaAux.equals("NI")) {
                                complicacionesText = "Ninguna";
                            }
                            if (complicaAux.equals("AI")) {
                                complicacionesText = "Aborto Incompleto";
                            }
                            if (complicaAux.equals("AF")) {
                                complicacionesText = "Aborto Fallido";
                            }
                            if (complicaAux.equals("PU")) {
                                complicacionesText = "PerforaciNn Uterina";
                            }
                            if (complicaAux.equals("LC")) {
                                complicacionesText = "LaceraciNn Cervical";
                            }
                            if (complicaAux.equals("HE")) {
                                complicacionesText = "Hemorragia";
                            }
                            if (complicaAux.equals("IN")) {
                                complicacionesText = "InfecciNn";
                            }
                            COMPLICACIONES = 
                                    COMPLICACIONES + formatearCampo(complicacionesText) + 
                                    ",";
                        }
                    }

                    PLANIFICACION = formatearCampo(motivo.getHmccanticonce());
                    if (motivo.getHmccanticonce() != null && 
                        !motivo.getHmccanticonce().equals("")) {
                        if (motivo.getHmccanticonce().equals("N")) {
                            INICIAR_PLANI = 
                                    formatearCampo(motivo.getHmccinicimetod());
                            if (motivo.getHmccinicimetod() != null && motivo.getHmccinicimetod().equals("S")) {
                                if (motivo.getHmccmetodantn() != null) {
                                    try {
                                        servicio = 
                                                this.serviceLocator.getClinicoService().getServicioPorId(motivo.getHmccmetodantn());
                                    } catch (ModelException e) {
                                        e.printStackTrace();
                                    }
                                    METODO_ANTICO = 
                                            formatearCampo(servicio.getCsvcnombre());
                                }

                            }

                        } else {
                            if (motivo.getHmccmetoantic() != null && 
                                !motivo.getHmccmetoantic().equals("")) {
                                try {
                                    servicio = 
                                            this.serviceLocator.getClinicoService().getServicioPorId(motivo.getHmccmetoantic());
                                } catch (ModelException e) {
                                    e.printStackTrace();
                                }
                                if (servicio != null && 
                                    servicio.getCsvcnombre() != null) {
                                    METODO_ANTICONCEPTIVO = 
                                            formatearCampo(servicio.getCsvcnombre());
                                }

                            }
                            if (motivo.getHmcctolemetod() != null && 
                                !motivo.getHmcctolemetod().equals("")) {
                                if (motivo.getHmcctolemetod().equals("B")) {
                                    toleranText = "Buena";
                                }
                                if (motivo.getHmcctolemetod().equals("R")) {
                                    toleranText = "Regular";
                                }
                                if (motivo.getHmcctolemetod().equals("M")) {
                                    toleranText = "Mala";
                                }
                                TOLERANCIA_METODO = 
                                        formatearCampo(toleranText);
                            }

                        }

                    }

                    Integer idFinalidad = null;
                    idFinalidad = motivo.getHmcnfinalidad();
                    Crfinalcon finalidadObject = null;
                    String tipoFinalidad = "C";
                    
                    if(motivo != null && motivo.getHmcctipoproce() != null){
                        tipoFinalidad = motivo.getHmcctipoproce();
                    }
                    
                    try {
                        finalidadObject = 
                                serviceLocator.getClinicoService().getFinalidadPorId(idFinalidad, 
                                                                                     tipoFinalidad);
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (finalidadObject != null) {
                        FINALIDAD = 
                                formatearCampo(finalidadObject.getCfccdescri());

                    }

                }


            }


            if (consulta.getChrevissiste() != null && 
                !consulta.getChrevissiste().isEmpty()) {
                Chrevissiste revision = null;
                Iterator it = consulta.getChrevissiste().iterator();
                if (it.hasNext()) {
                    revision = (Chrevissiste)it.next();
                }

                if (revision != null) {


                    REVISION_CABEZA_DES = 
                            formatearCampoRevision(revision.getHrscrefiecabez());
                    REVISION_OJOS_DES = 
                            formatearCampoRevision(revision.getHrscrefieojos());
                    REVISION_OIDOS_DES = 
                            formatearCampoRevision(revision.getHrscrefieoidos());
                    REVISION_NARIZ_DES = 
                            formatearCampoRevision(revision.getHrscrefienariz());
                    REVISION_BOCA_DES = 
                            formatearCampoRevision(revision.getHrscrefieboca());
                    REVISION_GARGANTA_DES = 
                            formatearCampoRevision(revision.getHrscrefiegarga());
                    REVISION_CUELLO_DES = 
                            formatearCampoRevision(revision.getHrscrefiecuell());
                    REVISION_CARDIO_DES = 
                            formatearCampoRevision(revision.getHrscrefiecardi());
                    REVISION_MAMAS_DES = 
                            formatearCampoRevision(revision.getHrscrefiemamas());
                    REVISION_GASTRO_DES = 
                            formatearCampoRevision(revision.getHrscrefiegastr());
                    REVISION_GENITO_DES = 
                            formatearCampoRevision(revision.getHrscrefiegenit());
                    REVISION_VENEREOS_DES = 
                            formatearCampoRevision(revision.getHrscrefievener());
                    REVISION_ENDOCRINO_DES = 
                            formatearCampoRevision(revision.getHrscrefieendoc());
                    REVISION_LOCOMOTOR_DES = 
                            formatearCampoRevision(revision.getHrscrefielocom());
                    REVISION_NEUROMUSCULAR_DES = 
                            formatearCampoRevision(revision.getHrscrefieneuro());
                    REVISION_NEUROMUSCULAR_D = 
                            formatearCampoRevision(revision.getHrscrefieneumu());
                    REVISION_NEUROSIQUIATRICO_DES = 
                            formatearCampoRevision(revision.getHrscrefieneups());
                    REVISION_PIEL_DES = 
                            formatearCampoRevision(revision.getHrscrefiepiel());
                }
            }


            if (consulta.getChanteceobst() != null && 
                !consulta.getChanteceobst().isEmpty()) {
                Chanteceobst obstetricos = null;
                Iterator it = consulta.getChanteceobst().iterator();
                if (it.hasNext()) {
                    obstetricos = (Chanteceobst)it.next();
                }

                if (obstetricos != null) {
                    LEUCORREAS = 
                            formatearCampo(obstetricos.getHaocleucorreas());
                    ITS = formatearCampo(obstetricos.getHaocets());
                    CITOLOGIA = formatearCampo(obstetricos.getHaoccitologia());
                    COLPOSCOPIA = 
                            formatearCampo(obstetricos.getHaoccolposcopi());
                    PERIODO_INTERGENESICO = 
                            formatearCampo(obstetricos.getHaonperiodoint());
                    HISTORIA_INFERTILIDAD = 
                            formatearCampo(obstetricos.getHaochistoriain());
                    RPM = formatearCampo(obstetricos.getHaocruppremenb());
                    RCIU = formatearCampo(obstetricos.getHaocrciu());
                    TRATAMIENTOS_RECIBIDOS = 
                            formatearCampo(obstetricos.getHaocttosrecibi());
                    CUAL_TRATAMIENTO = 
                            formatearCampo(obstetricos.getHaoccualesttos());

                    AMENAZA_PARTO = 
                            formatearCampo(obstetricos.getHaocamenzparto());
                    PARTO_PREMATURO = 
                            formatearCampo(obstetricos.getHaocpartoprema());
                    GEMELAR = formatearCampo(obstetricos.getHaocgemelar());
                    POLHIDRAMNIOS = 
                            formatearCampo(obstetricos.getHaocpolhidramn());
                    OLIGOHIDRAMNIOS = 
                            formatearCampo(obstetricos.getHaocoligohidra());
                    MALFORMACIONES = 
                            formatearCampo(obstetricos.getHaocmalformaci());
                    CUAL_MALFORMACION = 
                            formatearCampo(obstetricos.getHaocmalforcual());
                    EMBARAZO_PROLONGADO = 
                            formatearCampo(obstetricos.getHaocembarprolo());
                    AMENAZA_ABORTO = 
                            formatearCampo(obstetricos.getHaocamenaabort());
                    CUALES_OBSTETRICOS = 
                            formatearCampo(obstetricos.getHaocotrosobste());
                    if (obstetricos.getHaocotrosobste() != null && 
                        obstetricos.getHaocotrosobste().equals("S")) {
                        OTROS_OBSTETRICOS = "Si";
                    } else {
                        OTROS_OBSTETRICOS = "No";
                    }

                }
            }


            if (consulta.getChgestacion() != null && 
                !consulta.getChgestacion().isEmpty()) {
                Chgestacion gestacion = null;
                Iterator it = consulta.getChgestacion().iterator();
                if (it.hasNext()) {
                    gestacion = (Chgestacion)it.next();
                }

                if (gestacion != null) {
                    ANTITETANICA_PREVIA = 
                            formatearCampo(gestacion.getHgeeprevantite());
                    ANTITETANICA_ACTUAL_PRIMERA_DOSIS = 
                            formatearCampo(gestacion.getHgeeantidosis1());
                    FECHA_ANTITETANICA_PRIMERA_DOSIS = 
                            formatearCampo(gestacion.getHgedfecantdos1());
                    ANTITETANICA_ACTUAL_SEGUNDA_DOSIS = 
                            formatearCampo(gestacion.getHgeeantidosis2());
                    FECHA_ANTITETANICA_SEGUNDA_DOSIS = 
                            formatearCampo(gestacion.getHgedfecantdos2());
                    ANTIRUBEOLA_PREVIA = 
                            formatearCampo(gestacion.getHgeepreantrube());
                    ANTIRUBEOLA_ACTUAL = 
                            formatearCampo(gestacion.getHgeeactantrube());
                    FECHA_ANTIRUBEOLA_ACTUAL = 
                            formatearCampo(gestacion.getHgedfecantrube());
                    if (gestacion.getHgecrhpaciente() != null && 
                        gestacion.getHgecgrupopacie() != null) {
                        GRUPO_RH_PACIENTE = 
                                formatearCampo(gestacion.getHgecgrupopacie()) + 
                                " " + 
                                formatearCampoRh(gestacion.getHgecrhpaciente());
                    } else {
                        GRUPO_RH_PACIENTE = "";
                    }

                    if (gestacion.getHgecrhesposo() != null && 
                        gestacion.getHgecgrupoespos() != null) {
                        GRUPO_RH_ESPOSO = 
                                formatearCampo(gestacion.getHgecgrupoespos()) + 
                                " " + 
                                formatearCampoRh(gestacion.getHgecrhesposo());
                    } else {
                        GRUPO_RH_ESPOSO = "";
                    }

                    SENSIBILIZACION = 
                            formatearCampo(gestacion.getHgecsensibilid());
                    SOLICITO_VIH = 
                            formatearCampo(gestacion.getHgeesolicivih1());
                    REALIZO_VIH = 
                            formatearCampo(gestacion.getHgeerealizvih1());
                            
                    ESTADO_GESTION_PROBABLE = formatearCampoNulo(gestacion.getHgecedadgest());
                    if(gestacion.getHgecconedages() != null){
                        if("FE".equals(gestacion.getHgecconedages())){
                            METODO_CONFIRMACION_EDAD_GESTIONAL = "Fecha de la Nltima menstruaciNn";
                        }else if("AU".equals(gestacion.getHgecconedages())){
                            METODO_CONFIRMACION_EDAD_GESTIONAL = "Altura Uterina";
                        }else if("EO".equals(gestacion.getHgecconedages())){
                            METODO_CONFIRMACION_EDAD_GESTIONAL = "EcografNa ObstNtrica";
                        }
                    }
                    
                    SIGNOS_SNTOMAS_GESTACION = formatearCampoNulo(gestacion.getHgecsignosinto());

                }
            }


            if (consulta.getChcontrolpre() != null && 
                !consulta.getChcontrolpre().isEmpty()) {
                Chcontrolpre controlprenatal = null;
                Iterator it = consulta.getChcontrolpre().iterator();
                if (it.hasNext()) {
                    controlprenatal = (Chcontrolpre)it.next();
                }

                if (controlprenatal != null) {

                    PRESION_ARTERIAL_PRENATAL = 
                            formatearCampo(controlprenatal.getHcpcpresart1()) + 
                            "/" + 
                            formatearCampo(controlprenatal.getHcpcpresart2()) + 
                            " mm Hg";
                    FRECUENCIA_CARDIACA_PRENATAL = 
                            formatearCampo(controlprenatal.getHcpnfreccard()) + 
                            " l.p.m.";
                    FRECUENCIA_RESPIRATORIA_PRENATAL = 
                            formatearCampo(controlprenatal.getHcpnfrecresp()) + 
                            " r.p.m";
                    TALLA_PRENATAL = 
                            formatearCampo(controlprenatal.getHcpatalla()) + 
                            " mts";
                    PESO_PRENATAL = 
                            formatearCampo(controlprenatal.getHcpapeso()) + 
                            " kg";


                    if (controlprenatal.getHcpetipotemper() != null) {
                        if (controlprenatal.getHcpetipotemper().equals("A")) {
                            TIPO_TEMPERATURA_PRENATAL = "Afebril";
                            TEMPERATURA_PRENATAL = null;
                        } else if (controlprenatal.getHcpetipotemper().equals("F")) {
                            TIPO_TEMPERATURA_PRENATAL = "Febril";
                            TEMPERATURA_PRENATAL = 
                                    formatearCampo(controlprenatal.getHcpatemperatu()) + 
                                    " NC";
                        }


                    }

                    EXAMEN_CLINICO_PRENATAL = 
                            formatearCampoEFPrenatal(controlprenatal.getHcpeexaclinico());
                    EXAMEN_MAMAS_PRENATAL = 
                            formatearCampoEFPrenatal(controlprenatal.getHcpeexamemamas());
                    EXAMEN_ODONTOLOGICO_PRENATAL = 
                            formatearCampoEFPrenatal(controlprenatal.getHcpeexaodontol());
                    PELVIS_PRENATAL = 
                            formatearCampoEFPrenatal(controlprenatal.getHcpeexamepelvi());
                    CITOLOGIA_PRENATAL = 
                            formatearCampoEFPrenatal(controlprenatal.getHcpeexacitolog());
                    CERVIX_PRENATAL = 
                            formatearCampoEFPrenatal(controlprenatal.getHcpeexamcervix());
                    ALTURA_UTERINA = 
                            formatearCampo(controlprenatal.getHcpnaltuterina());
                    FRECUENCIA_CARDIACA_FETAL = 
                            formatearCampo(controlprenatal.getHcpnfcf());
                    MOVIMIENTO_FETAL = 
                            formatearCampo(controlprenatal.getHcpcmovimfetal());
                    PRESENTACION_FETAL = 
                            formatearCampo(controlprenatal.getHcpcpresefetal());
                    EDEMAS_PRENATAL = 
                            formatearCampo(controlprenatal.getHcpeedemas());
                    VALORACION_CUELLO_UTERINO = 
                            formatearCampo(controlprenatal.getHcpevalcueuter());
                    ORL_PRENATAL = 
                            formatearCampo(controlprenatal.getHcpctienhalorl());
                    CARDIO_PULMONAR_PRENATAL = 
                            formatearCampo(controlprenatal.getHcpctienhalcar());
                    EXTREMIDADES_PRENATAL = 
                            formatearCampo(controlprenatal.getHcpctienhalext());
                    SISTEMA_NERVIOSO_PRENATAL = 
                            formatearCampo(controlprenatal.getHcpctienhalsis());
                    DESCRIPCION_ORL_PRENATAL = 
                            formatearCampo(controlprenatal.getHcpthallaorl());
                    DESCRIPCION_CARDIO_PULMONAR_PRENATAL = 
                            formatearCampo(controlprenatal.getHcpthallcarpul());
                    DESCRIPCION_EXTREMIDADES_PRENATAL = 
                            formatearCampo(controlprenatal.getHcpthallaextre());
                    DESCRIPCION_SISTEMA_NERVIOSO_PRENATAL = 
                            formatearCampo(controlprenatal.getHcpthallsisner());
                    GENITURINARIO_PRENATAL = 
                            formatearCampo(controlprenatal.getHcpcgenituri());
                    DESCRIPCION_GENITURINARIO_PRENATAL = 
                            formatearCampo(controlprenatal.getHcpcdescgeni());
                    GASTROINTESTINAL_PRENATAL = 
                            formatearCampo(controlprenatal.getHcpcgastroin());
                    DESCRIPCION_GASTROINTESTINAL_PRENATAL = 
                            formatearCampo(controlprenatal.getHcpcdescgast());
                    if (controlprenatal.getHcpcestanutri() != null) {
                        if ("OB".equals(controlprenatal.getHcpcestanutri())) {
                            ESTADO_NUTRICIONAL_PRENATAL = 
                                    "Obesidad para la edad gestional";
                        } else if ("SO".equals(controlprenatal.getHcpcestanutri())) {
                            ESTADO_NUTRICIONAL_PRENATAL = 
                                    "Sobrepeso para la edad gestional";
                        } else if ("IM".equals(controlprenatal.getHcpcestanutri())) {
                            ESTADO_NUTRICIONAL_PRENATAL = 
                                    "IMC adecuado para la edad gestional";
                        } else if ("BA".equals(controlprenatal.getHcpcestanutri())) {
                            ESTADO_NUTRICIONAL_PRENATAL = 
                                    "Bajo peso para la edad gestional";
                        }
                    }

                }
            }


            if (consulta.getChtamizalapr() != null && 
                !consulta.getChtamizalapr().isEmpty()) {
                Chtamizalapr tamizaje = null;
                Iterator it = consulta.getChtamizalapr().iterator();
                if (it.hasNext()) {
                    tamizaje = (Chtamizalapr)it.next();
                }

                if (tamizaje != null) {
                    TOXOPLASMA_IGG = 
                            formatearCampo(tamizaje.getHtletoxoplaigg());
                    RESULTADO_IGG = 
                            formatearCampoRh(tamizaje.getHtlcresutoxigg());
                    FECHA_IGG = formatearCampo(tamizaje.getHtldfechtoxigg());
                    TOXOPLASMA_IGM = 
                            formatearCampo(tamizaje.getHtletoxoplaigm());
                    RESULTADO_IGM = 
                            formatearCampoRh(tamizaje.getHtlcresutoxigm());
                    FECHA_IGM = formatearCampo(tamizaje.getHtldfechtoxigm());
                    TEST_SULLIVAN = 
                            formatearCampo(tamizaje.getHtletestsulliv());
                    RESULTADO_TEST_SULLIVAN = 
                            formatearCampo(tamizaje.getHtlnrestestsul());
                    FECHA_TEST_SULLIVAN = 
                            formatearCampo(tamizaje.getHtldfectestsul());
                    HEMOGLOBINA = formatearCampo(tamizaje.getHtlehemoglobin());
                    RESULTADO_HEMOGLOBINA = 
                            formatearCampo(tamizaje.getHtlnreshemoglo());
                    FECHA_HEMOGLOBINA = 
                            formatearCampo(tamizaje.getHtldfechemoglo());
                    GLUCOSA = formatearCampo(tamizaje.getHtleglucosa());
                    RESULTADO_GLUCOSA = 
                            formatearCampo(tamizaje.getHtlnresglucosa());
                    FECHA_GLUCOSA = 
                            formatearCampo(tamizaje.getHtldfecglucosa());
                    SEROLOGIA = formatearCampo(tamizaje.getHtleserologia());
                    RESULTADO_SEROLOGIA = 
                            formatearCampoRh(tamizaje.getHtleresuserolo());
                    FECHA_SEROLOGIA = 
                            formatearCampo(tamizaje.getHtldfecserolog());

                    DESCRIPCION_ECOGRAFIA = 
                            formatearCampo(tamizaje.getHtlcecografia());
                    if (tamizaje.getHtlcecografia() != null && 
                        !tamizaje.getHtlcecografia().equals("")) {
                        ECOGRAFIA = "Si";
                    } else {
                        ECOGRAFIA = "No";
                    }

                    MICRONUTRIENTES = 
                            formatearCampo(tamizaje.getHtlemicronutri());
                    PARCIAL_ORINA = 
                            formatearCampoEFPrenatal(tamizaje.getHtleparciorina());
                    BACTERIURIA = 
                            formatearCampoRh(tamizaje.getHtlebacteriuri());
                    PROTEINURIA = 
                            formatearCampoRh(tamizaje.getHtleproteinuri());
                    HEMATIES = formatearCampoRh(tamizaje.getHtlehematies());
                    LEUCOCITOS = 
                            formatearCampoRh(tamizaje.getHtleleucocitos());
                }
            }


            if (consulta.getChproceconsu() != null && 
                !consulta.getChproceconsu().isEmpty()) {

                Chproceconsu procedimiento = null;

                Iterator it = consulta.getChproceconsu().iterator();
                if (it.hasNext()) {
                    procedimiento = (Chproceconsu)it.next();
                }


                if (procedimiento != null) {
                    if (procedimiento.getHpcnambitproce() != null) {
                        if (procedimiento.getHpcnambitproce().equals(1)) {
                            AMBITO_PROCEDIMIENTO = "Ambulatorio";
                        }
                        if (procedimiento.getHpcnambitproce().equals(2)) {
                            AMBITO_PROCEDIMIENTO = "Hospitalario";
                        }
                        if (procedimiento.getHpcnambitproce().equals(3)) {
                            AMBITO_PROCEDIMIENTO = "En Urgencia";
                        }
                    }

                    Integer idFinal = null;
                    idFinal = procedimiento.getHpcnfinalidad();
                    Crfinalcon finalidadObject = null;
                    try {
                        finalidadObject = 
                                serviceLocator.getClinicoService().getFinalidadPorId(idFinal, 
                                                                                     "P");
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (finalidadObject != null) {
                        FINALIDAD_PROCEDIMIENTO = 
                                formatearCampo(finalidadObject.getCfccdescri());

                    }

                    Crdgncie10 diagprevio = null;
                    Crdgncie10 diagposter = null;
                    Crdgncie10 diagcompli = null;

                    try {
                        if (procedimiento.getHpccdiagprinci() != null) {
                            diagprevio = 
                                    this.serviceLocator.getClinicoService().getCIE10PorCodigo(procedimiento.getHpccdiagprinci().toUpperCase());
                        }

                    } catch (ModelException e) {
                        e.printStackTrace();
                    }


                    if (diagprevio != null && 
                        procedimiento.getHpccdiagprinci() != null) {
                        DIAGNOSTICO_PREVIO = 
                                procedimiento.getHpccdiagprinci().toUpperCase() + 
                                " " + diagprevio.getCdccdescri();
                    }


                    try {
                        if (procedimiento.getHpccdiagposter() != null) {
                            diagposter = 
                                    this.serviceLocator.getClinicoService().getCIE10PorCodigo(procedimiento.getHpccdiagposter().toUpperCase());
                        }

                    } catch (ModelException e) {
                        e.printStackTrace();
                    }


                    if (diagposter != null && 
                        procedimiento.getHpccdiagposter() != null) {
                        DIAGNOSTICO_POSTERIOR = 
                                procedimiento.getHpccdiagposter().toUpperCase() + 
                                " " + diagposter.getCdccdescri();
                    }


                    try {
                        if (procedimiento.getHpccdiagcompli() != null) {
                            diagcompli = 
                                    this.serviceLocator.getClinicoService().getCIE10PorCodigo(procedimiento.getHpccdiagcompli().toUpperCase());
                        }

                    } catch (ModelException e) {
                        e.printStackTrace();
                    }


                    if (diagcompli != null && 
                        procedimiento.getHpccdiagcompli() != null) {
                        DIAGNOSTICO_COMPLICACION = 
                                procedimiento.getHpccdiagcompli().toUpperCase() + 
                                " " + diagcompli.getCdccdescri();
                    }


                    DESCRIPCION_PROCEDIMIENTO = 
                            formatearCampo(procedimiento.getHpccdescrproce());
                    NOMBRE_PROCEDIMIENTO = "";
                    if (procedimiento.getHpccdiagcompli() != null && 
                        !procedimiento.getHpccdiagcompli().equals("")) {
                        TIENE_COMPLICACIONES = "SI";
                    } else {
                        TIENE_COMPLICACIONES = "NO";
                    }

                    DESCRIPCION_COMPLICACION = 
                            formatearCampo(procedimiento.getHpccdescrcompl());
                    REALIZACION_PROCEDIMIENTO = "";
                    if (procedimiento.getHpcnrealizacio() != null) {
                        try {
                            REALIZACION_PROCEDIMIENTO = 
                                    this.serviceLocator.getClinicoService().getDescripcionActoQuirurgico(procedimiento.getHpcnrealizacio());
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }
                    }


                }

            }


            if (consulta.getChcuestester() != null && 
                !consulta.getChcuestester().isEmpty()) {

                Chcuestester cuestEsterilizacion = null;
                Iterator it = consulta.getChcuestester().iterator();
                if (it.hasNext()) {
                    cuestEsterilizacion = (Chcuestester)it.next();
                }

                if (cuestEsterilizacion != null) {

                    HCECOBSERV = 
                            formatearCampo(cuestEsterilizacion.getHcecobserv());
                    HCECENFERMO = 
                            formatearCampo(cuestEsterilizacion.getHcecenfermo());
                    HCECENFERGRAV = 
                            formatearCampo(cuestEsterilizacion.getHcecenfergrav());
                    HCECOPERADO = 
                            formatearCampo(cuestEsterilizacion.getHcecoperado());
                    HCECTRANSFUSION = 
                            formatearCampo(cuestEsterilizacion.getHcectransfusion());
                    HCECPRESIONALTA = 
                            formatearCampo(cuestEsterilizacion.getHcecpresionalta());
                    HCECEJERCICIO = 
                            formatearCampo(cuestEsterilizacion.getHcecejercicio());
                    HCECPALPITACION = 
                            formatearCampo(cuestEsterilizacion.getHcecpalpitacion());
                    HCECSOPLO = 
                            formatearCampo(cuestEsterilizacion.getHcecsoplo());
                    HCECASMA = 
                            formatearCampo(cuestEsterilizacion.getHcecasma());
                    HCECTOS = formatearCampo(cuestEsterilizacion.getHcectos());
                    HCECGRIPA = 
                            formatearCampo(cuestEsterilizacion.getHcecgripa());
                    HCECFUMA = 
                            formatearCampo(cuestEsterilizacion.getHcecfuma());
                    HCECPROBANESTESIA = 
                            formatearCampo(cuestEsterilizacion.getHcecprobanestesia());
                    HCECALERGIA = 
                            formatearCampo(cuestEsterilizacion.getHcecalergia());
                    HCECDROGAS = 
                            formatearCampo(cuestEsterilizacion.getHcecdrogas());
                    HCECCONVULSION = 
                            formatearCampo(cuestEsterilizacion.getHcecconvulsion());
                    HCECENFERMENTAL = 
                            formatearCampo(cuestEsterilizacion.getHcecenfermental());
                    HCECDIABETES = 
                            formatearCampo(cuestEsterilizacion.getHcecdiabetes());
                    HCECHEPATITIS = 
                            formatearCampo(cuestEsterilizacion.getHcechepatitis());
                    HCECOTRAENFER = 
                            formatearCampo(cuestEsterilizacion.getHcecotraenfer());
                    HCECEMBARAZO = 
                            formatearCampo(cuestEsterilizacion.getHcecembarazo());
                    HCEDFECHULTMES = 
                            formatearCampo(cuestEsterilizacion.getHcedfechultmes());
                    HCECUTILMETPLAN = 
                            formatearCampo(cuestEsterilizacion.getHcecutilmetplan());
                    HCEDFECHAPARTO = 
                            formatearCampo(cuestEsterilizacion.getHcedfechaparto());
                    HCECINFOMET = 
                            formatearCampo(cuestEsterilizacion.getHcecinfomet());
                    HCECMETDEF = 
                            formatearCampo(cuestEsterilizacion.getHcecmetdef());
                    HCECLIGFALLA = 
                            formatearCampo(cuestEsterilizacion.getHcecligfalla());
                    HCECINSESTER = 
                            formatearCampo(cuestEsterilizacion.getHcecinsester());

                    HCECANENFERMO = 
                            formatearCampo(cuestEsterilizacion.getHcecanenfermo());
                    HCECANENFERGRAV = 
                            formatearCampo(cuestEsterilizacion.getHcecanenfergrav());
                    HCECANOPERADO = 
                            formatearCampo(cuestEsterilizacion.getHcecanoperado());
                    HCECANTRANSFUSION = 
                            formatearCampo(cuestEsterilizacion.getHcecantransfusion());
                    HCECANPRESIONALTA = 
                            formatearCampo(cuestEsterilizacion.getHcecanpresionalta());
                    HCECANEJERCICIO = 
                            formatearCampo(cuestEsterilizacion.getHcecanejercicio());
                    HCECANPALPITACION = 
                            formatearCampo(cuestEsterilizacion.getHcecanpalpitacion());
                    HCECANSOPLO = 
                            formatearCampo(cuestEsterilizacion.getHcecansoplo());
                    HCECANASMA = 
                            formatearCampo(cuestEsterilizacion.getHcecanasma());
                    HCECANTOS = 
                            formatearCampo(cuestEsterilizacion.getHcecantos());
                    HCECANGRIPA = 
                            formatearCampo(cuestEsterilizacion.getHcecangripa());
                    HCECANFUMA = 
                            formatearCampo(cuestEsterilizacion.getHcecanfuma());

                    FUMA_DIA_FEMENINA = 
                            formatearCampo(cuestEsterilizacion.getHcecnocigarrillo());

                    HCECANPROBANESTESIA = 
                            formatearCampo(cuestEsterilizacion.getHcecanprobanestesia());
                    HCECANALERGIA = 
                            formatearCampo(cuestEsterilizacion.getHcecanalergia());
                    HCECANDROGAS = 
                            formatearCampo(cuestEsterilizacion.getHcecandrogas());
                    HCECANCONVULSION = 
                            formatearCampo(cuestEsterilizacion.getHcecanconvulsion());
                    HCECANENFERMENTAL = 
                            formatearCampo(cuestEsterilizacion.getHcecanenfermental());
                    HCECANDIABETES = 
                            formatearCampo(cuestEsterilizacion.getHcecandiabetes());
                    HCECANHEPATITIS = 
                            formatearCampo(cuestEsterilizacion.getHcecanhepatitis());
                    HCECANOTRAENFER = 
                            formatearCampo(cuestEsterilizacion.getHcecanotraenfer());
                    HCECANEMBARAZO = 
                            formatearCampo(cuestEsterilizacion.getHcecanembarazo());
                    HCECANMESNORM = 
                            formatearCampo(cuestEsterilizacion.getHcecanmesnorm());
                    HCECANMETPLAN = 
                            formatearCampo(cuestEsterilizacion.getHcecanmetplan());
                    HCECANINFOMET = 
                            formatearCampo(cuestEsterilizacion.getHcecaninfomet());
                    HCECANMETDEF = 
                            formatearCampo(cuestEsterilizacion.getHcecanmetdef());
                    HCECANLIGFALLA = 
                            formatearCampo(cuestEsterilizacion.getHcecanligfalla());
                    HCECANINSESTER = 
                            formatearCampo(cuestEsterilizacion.getHcecaninsester());
                    HCECMESNORM = 
                            formatearCampo(cuestEsterilizacion.getHcecmesnorm());

                    if (cuestEsterilizacion != null && 
                        cuestEsterilizacion.getHcecesparto() != null) {
                        if (cuestEsterilizacion.getHcecesparto().equals("P")) {
                            HCECESPARTO = "Parto";
                        } else if (cuestEsterilizacion.getHcecesparto().equals("A")) {
                            HCECESPARTO = "Aborto";
                        } else if (cuestEsterilizacion.getHcecesparto().equals("X")) {
                            HCECESPARTO = "Ninguno";
                        }
                    }

                    if (cuestEsterilizacion != null && 
                        cuestEsterilizacion.getHcecmetplan() != null) {
                        try {
                            HCECMETPLAN = 
                                    this.serviceLocator.getClinicoService().getDescripcionMetodo(cuestEsterilizacion.getHcecmetplan());
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }
                    } else {
                        HCECMETPLAN = "";
                    }

                    if (HCECMETPLAN != null) {
                        HCECMETPLAN = HCECMETPLAN.trim();
                    } else {
                        HCECMETPLAN = "";
                    }

                }

            }


            if (consulta.getChestermascu() != null && 
                !consulta.getChestermascu().isEmpty()) {

                Chestermascu esterilizacion = null;
                Iterator it = consulta.getChestermascu().iterator();
                if (it.hasNext()) {
                    esterilizacion = (Chestermascu)it.next();
                }

                if (esterilizacion != null) {

                    HEMCINFORMETOD = 
                            formatearCampo(esterilizacion.getHemcinformetod());
                    HEMCVASECDEFIN = 
                            formatearCampo(esterilizacion.getHemcvasecdefin());
                    HEMCVASECFALLA = 
                            formatearCampo(esterilizacion.getHemcvasecfalla());
                    HEMCVASECFALLANUEVO = 
                             formatearCampo(esterilizacion.getHemcvasecfalnue());
                    HEMCACLARFALLANUEVO = 
                            formatearCampo(esterilizacion.getHemcaclarfalnue());
                    HEMCEXITOESPER = 
                            formatearCampo(esterilizacion.getHemcexitoesper());
                    HEMCINFORSUFIC = 
                            formatearCampo(esterilizacion.getHemcinforsufic());

                    HEMCACLARINFOR = 
                            formatearCampo(esterilizacion.getHemcaclarinfor());
                    HEMCACLARDEFIN = 
                            formatearCampo(esterilizacion.getHemcaclardefin());
                    HEMCACLARFALLA = 
                            formatearCampo(esterilizacion.getHemcaclarfalla());
                    HEMCACLAREXITO = 
                            formatearCampo(esterilizacion.getHemcaclarexito());
                    HEMCACLARSUFIC = 
                            formatearCampo(esterilizacion.getHemcaclarsufic());
                }
            }


            if (consulta.getHconclinica() != null) {
                Cpclinica clinicaAux = null;
                try {
                    clinicaAux = 
                            this.serviceLocator.getClinicoService().getClinica(consulta.getHconclinica());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (clinicaAux != null) {
                    CENTRO = clinicaAux.getCclcnombre();
                }
            }


            if (consulta.getHcocnombacompa() != null) {
                NOMBRE_ACOMPANANTE = 
                        consulta.getHcocnombacompa().toUpperCase();
            }

            if (consulta.getHcocteleacompa() != null) {
                TELEFONO_ACOMPANANTE = consulta.getHcocteleacompa();
            }

            if (consulta.getChantecpsico() != null && 
                !consulta.getChantecpsico().isEmpty()) {
                Chantecpsico antecpsico = null;
                SE_SIENTE_ENFERMO = "";
                DESCRIPCION_ENFERMO = "";
                ALTERACION_FISICA = "";
                CUAL_ALTERACION = "";
                NUNCA_FISICA = "";
                OCASIONALMENTE_FISICA = "";
                TRES_ALIMENTOS = "";
                MAS_ALIMENTOS = "";
                TIPO_ALIMENTOS_CONSUME = "";
                MEDICAMENTOS_FORMULADOS = "";
                CUAL_MEDICAMENTO = "";
                HABITOS_SALUD = "";
                CUAL_HABITO = "";
                ORIENTACION_SEXUAL = "";
                CUAL_ORIENTACION = "";
                TIENE_PAREJA = "";
                TIPO_VINCULO = "";
                VIDA_SEXUAL = "";
                RELACIONES_SATISFACTORIAS = "";
                DIFICULTADES_RELACIONES = "";
                CUALES_DIFICULTADES = "";
                TRASTORNOS_PSIQUICOS = "";
                CUAL_TRASTORNO = "";
                TIPO_FAMILIA = "";
                COMPOSICION_FAMILIAR = "";
                TIPO_VINCULO_FAMILIAR = "";
                RELACION_FAMILIA = "";

                Iterator it = consulta.getChantecpsico().iterator();
                if (it.hasNext()) {
                    antecpsico = (Chantecpsico)it.next();
                }

                if (antecpsico != null) {
                    SE_SIENTE_ENFERMO = 
                            formatearCampo(antecpsico.getHapcsientenfer());
                    DESCRIPCION_ENFERMO = 
                            formatearCampo(antecpsico.getHapcdescrenfer());
                    ALTERACION_FISICA = 
                            formatearCampo(antecpsico.getHapcalterfisic());
                    CUAL_ALTERACION = 
                            formatearCampo(antecpsico.getHapccualalter());
                    NUNCA_FISICA = 
                            formatearCampo(antecpsico.getHapcnuncafisic());
                    OCASIONALMENTE_FISICA = 
                            formatearCampo(antecpsico.getHapcocasifisic());
                    TRES_ALIMENTOS = 
                            formatearCampo(antecpsico.getHapcalimtredia());
                    MAS_ALIMENTOS = 
                            formatearCampo(antecpsico.getHapcalimmasdia());
                    TIPO_ALIMENTOS_CONSUME = 
                            formatearCampo(antecpsico.getHapctipoalime());
                    MEDICAMENTOS_FORMULADOS = 
                            formatearCampo(antecpsico.getHapcmedicformu());
                    CUAL_MEDICAMENTO = 
                            formatearCampo(antecpsico.getHapccualmedic());
                    HABITOS_SALUD = 
                            formatearCampo(antecpsico.getHapchabitsalud());
                    CUAL_HABITO = 
                            formatearCampo(antecpsico.getHapccualhabit());
                    if (antecpsico.getHapcoriensexua() != null) {
                        if (antecpsico.getHapcoriensexua().equals("BI")) {
                            ORIENTACION_SEXUAL = "Bisexual";
                        }
                        if (antecpsico.getHapcoriensexua().equals("HO")) {
                            ORIENTACION_SEXUAL = "Homosexual";
                        }
                        if (antecpsico.getHapcoriensexua().equals("HE")) {
                            ORIENTACION_SEXUAL = "Heterosexual";
                        }
                        if (antecpsico.getHapcoriensexua().equals("OT")) {
                            ORIENTACION_SEXUAL = "Otro";
                        }
                    }

                    CUAL_ORIENTACION = 
                            formatearCampo(antecpsico.getHapccualorien());
                    TIENE_PAREJA = 
                            formatearCampo(antecpsico.getHapcactuaparej());
                    if (antecpsico.getHapctipovincu() != null) {
                        if (antecpsico.getHapctipovincu().equals("DE")) {
                            TIPO_VINCULO = "Dependiente";
                        }
                        if (antecpsico.getHapctipovincu().equals("DM")) {
                            TIPO_VINCULO = "DemocrNtica";
                        }
                        if (antecpsico.getHapctipovincu().equals("EV")) {
                            TIPO_VINCULO = "Evitadora";
                        }
                        if (antecpsico.getHapctipovincu().equals("DI")) {
                            TIPO_VINCULO = "Disfuncional";
                        }


                    }

                    VIDA_SEXUAL = 
                            formatearCampo(antecpsico.getHapcsexuaactiv());
                    RELACIONES_SATISFACTORIAS = 
                            formatearCampo(antecpsico.getHapcsexuasatis());
                    DIFICULTADES_RELACIONES = 
                            formatearCampo(antecpsico.getHapcsexuadific());
                    CUALES_DIFICULTADES = 
                            formatearCampo(antecpsico.getHapccualdific());
                    TRASTORNOS_PSIQUICOS = 
                            formatearCampo(antecpsico.getHapctrastpsiqu());
                    CUAL_TRASTORNO = 
                            formatearCampo(antecpsico.getHapccualtrast());

                    if (antecpsico.getHapctipofamil() != null) {
                        if (antecpsico.getHapctipofamil().equals("NU")) {
                            TIPO_FAMILIA = "Nuclear";
                        }
                        if (antecpsico.getHapctipofamil().equals("EX")) {
                            TIPO_FAMILIA = "Extensa";
                        }

                        if (antecpsico.getHapctipofamil().equals("MO")) {
                            TIPO_FAMILIA = "Monoparental";
                        }

                        if (antecpsico.getHapctipofamil().equals("NE")) {
                            TIPO_FAMILIA = "Neofamiliar";
                        }
                    }

                    COMPOSICION_FAMILIAR = 
                            formatearCampo(antecpsico.getHapccompofamil());
                    if (antecpsico.getHapcvincufamil() != null) {
                        if (antecpsico.getHapcvincufamil().equals("RI")) {
                            TIPO_VINCULO_FAMILIAR = "RNgida";
                        }
                        if (antecpsico.getHapcvincufamil().equals("SO")) {
                            TIPO_VINCULO_FAMILIAR = "Sobreprotectora";
                        }
                        if (antecpsico.getHapcvincufamil().equals("AM")) {
                            TIPO_VINCULO_FAMILIAR = "Amalgamada";
                        }
                        if (antecpsico.getHapcvincufamil().equals("CE")) {
                            TIPO_VINCULO_FAMILIAR = "Centrada";
                        }
                        if (antecpsico.getHapcvincufamil().equals("EV")) {
                            TIPO_VINCULO_FAMILIAR = "Evitadora";
                        }
                        if (antecpsico.getHapcvincufamil().equals("SE")) {
                            TIPO_VINCULO_FAMILIAR = "Seudodemocratica";
                        }
                        if (antecpsico.getHapcvincufamil().equals("NA")) {
                            TIPO_VINCULO_FAMILIAR = "No aplica";
                        }
                    }

                    RELACION_FAMILIA = 
                            formatearCampo(antecpsico.getHapcrelacfamil());

                }


            }


            if (consulta.getChantecprena() != null && 
                !consulta.getChantecprena().isEmpty()) {

                Chantecprena anteceprena = null;

                Iterator it = consulta.getChantecprena().iterator();
                if (it.hasNext()) {
                    anteceprena = (Chantecprena)it.next();
                }

                if (anteceprena != null) {

                    TIENE_HTA_FAMILIAR = 
                            formatearCampo(anteceprena.getHapchtacrofami());
                    TIENE_DIABETES_FAMILIAR = 
                            formatearCampo(anteceprena.getHapcdiabetfami());
                    TIENE_PREECLAMPSIA_FAMILIAR = 
                            formatearCampo(anteceprena.getHapcpreeclfami());
                    TIENE_ECLAMPSIA_FAMILIAR = 
                            formatearCampo(anteceprena.getHapceclampfami());
                    TIENE_GEMELARES_FAMILIAR = 
                            formatearCampo(anteceprena.getHapcgemelafami());
                    TIENE_CARDIOPATIA_FAMILIAR = 
                            formatearCampo(anteceprena.getHapccardiofami());
                    TIENE_TUBERCULOSIS_FAMILIAR = 
                            formatearCampo(anteceprena.getHapctbcfamilia());
                    TIENE_OTROS_FAMILIAR = 
                            formatearCampo(anteceprena.getHapcotrofamili());

                    HTA_FAMILIAR = 
                            formatearCampo(anteceprena.getHapcdeshtacrof());
                    DIABETES_FAMILIAR = 
                            formatearCampo(anteceprena.getHapcdesdiabetf());
                    PREECLAMPSIA_FAMILIAR = 
                            formatearCampo(anteceprena.getHapcdespreeclf());
                    ECLAMPSIA_FAMILIAR = 
                            formatearCampo(anteceprena.getHapcdeseclampf());
                    GEMELARES_FAMILIAR = 
                            formatearCampo(anteceprena.getHapcdesgemelaf());
                    CARDIOPATIA_FAMILIAR = 
                            formatearCampo(anteceprena.getHapcdescardiof());
                    TUBERCULOSIS_FAMILIAR = 
                            formatearCampo(anteceprena.getHapcdestbcfami());
                    OTROS_FAMILIAR = 
                            formatearCampo(anteceprena.getHapccualotrfam());


                    TIENE_HTA_PERSONAL = 
                            formatearCampo(anteceprena.getHapchtacropers());
                    TIENE_DIABETES_PERSONAL = 
                            formatearCampo(anteceprena.getHapcdiabeperso());
                    TIENE_PREECLAMPSIA_PERSONAL = 
                            formatearCampo(anteceprena.getHapcpreeclpers());
                    TIENE_ECLAMPSIA_PERSONAL = 
                            formatearCampo(anteceprena.getHapceclamppers());
                    TIENE_GEMELARES_PERSONAL = 
                            formatearCampo(anteceprena.getHapcgemelapers());
                    TIENE_CARDIOPATIA_PERSONAL = 
                            formatearCampo(anteceprena.getHapccardiopers());
                    TIENE_TUBERCULOSIS_PERSONAL = 
                            formatearCampo(anteceprena.getHapctuberperso());
                    TIENE_CIRUGIA_PELVICO_PERSONAL = 
                            formatearCampo(anteceprena.getHapccirpeutepe());
                    TIENE_ALERGICOS_PERSONAL = 
                            formatearCampo(anteceprena.getHapcalergipers());
                    TIENE_TABAQUISMO_PERSONAL = 
                            formatearCampo(anteceprena.getHapctabaqupers());
                    TIENE_ANTITETANICA_PERSONAL = 
                            formatearCampo(anteceprena.getHapcantitepers());
                    TIENE_OTROS_PERSONAL = 
                            formatearCampo(anteceprena.getHapcotrosperso());

                    HTA_PERSONAL = 
                            formatearCampo(anteceprena.getHapcdeshtacrop());
                    DIABETES_PERSONAL = 
                            formatearCampo(anteceprena.getHapcdesdiabepe());
                    PREECLAMPSIA_PERSONAL = 
                            formatearCampo(anteceprena.getHapcdespreeclp());
                    ECLAMPSIA_PERSONAL = 
                            formatearCampo(anteceprena.getHapcdeseclampp());
                    GEMELARES_PERSONAL = 
                            formatearCampo(anteceprena.getHapcdesgemelap());
                    CARDIOPATIA_PERSONAL = 
                            formatearCampo(anteceprena.getHapcdescardiop());
                    TUBERCULOSIS_PERSONAL = 
                            formatearCampo(anteceprena.getHapcdestuberpe());
                    CIRUGIA_PELVICO_PERSONAL = 
                            formatearCampo(anteceprena.getHapcdescirugpe());
                    ALERGICOS_PERSONAL = 
                            formatearCampo(anteceprena.getHapcdesalergip());
                    TABAQUISMO_PERSONAL = 
                            formatearCampo(anteceprena.getHapcdestabaqup());
                    ANTITETANICA_PERSONAL = 
                            formatearCampo(anteceprena.getHapcdesantitep());
                    OTROS_PERSONAL = 
                            formatearCampo(anteceprena.getHapccualotrper());

                }

            }


            if (consulta.getChevalugener() != null && 
                !consulta.getChevalugener().isEmpty()) {
                Chevalugener evaluacion = null;
                AREA_COGNITIVA = "";
                AREA_AFECTIVA = "";
                APOYO_FAMILIAR = "";
                CUAL_APOYO = "";
                CANALES_COMUNICACION = "";
                CUAL_CANAL = "";
                LABORAL_ESTUDIOS = "";
                SERVICIOS_APOYO = "";
                RELACIONES_FAMILIARES = "";
                COMPOSICIONDINA_FAMILIAR="";
                DESARROLLO_SESION="";

                Iterator it = consulta.getChevalugener().iterator();
                if (it.hasNext()) {
                    evaluacion = (Chevalugener)it.next();
                }
                if (evaluacion != null) {


                    AREA_COGNITIVA = "";
                    AREA_AFECTIVA = "";

                    if (evaluacion.getHegcareacogni() != null && 
                        !evaluacion.getHegcareacogni().equals("")) {
                        StringTokenizer stk = 
                            new StringTokenizer(evaluacion.getHegcareacogni(), 
                                                ",");
                        String areacogniAux = "";
                        String descareacogni = "";

                        while (stk.hasMoreTokens()) {
                            areacogniAux = "";
                            descareacogni = "";
                            areacogniAux = stk.nextToken();
                            if (areacogniAux != null) {
                                if (areacogniAux.equals("DI")) {
                                    descareacogni = "Dispersa";
                                }
                                if (areacogniAux.equals("OR")) {
                                    descareacogni = "Orientada";
                                }

                                if (areacogniAux.equals("PC")) {
                                    descareacogni = "Pensamientos Claros";
                                }

                                if (areacogniAux.equals("TP")) {
                                    descareacogni = 
                                            "Trastornos del Pensamiento";
                                }

                                if (areacogniAux.equals("LC")) {
                                    descareacogni = "Lenguaje Claro";
                                }

                                if (areacogniAux.equals("IS")) {
                                    descareacogni = "IdeaciNn Suicida";
                                }

                                if (areacogniAux.equals("TS")) {
                                    descareacogni = "Trastornos en el sueNo";
                                }


                                AREA_COGNITIVA = 
                                        AREA_COGNITIVA + descareacogni + ",";
                            }
                        }

                        if (AREA_COGNITIVA != null && 
                            AREA_COGNITIVA.length() > 2) {
                            AREA_COGNITIVA = 
                                    AREA_COGNITIVA.substring(0, AREA_COGNITIVA.length() - 
                                                             1);
                        }

                    }


                    if (evaluacion.getHegcareaafect() != null && 
                        !evaluacion.getHegcareaafect().equals("")) {
                        StringTokenizer stk = 
                            new StringTokenizer(evaluacion.getHegcareaafect(), 
                                                ",");
                        String areaafectAux = null;
                        String descareaafect = "";

                        while (stk.hasMoreTokens()) {
                            areaafectAux = "";
                            descareaafect = "";
                            areaafectAux = stk.nextToken();
                            if (areaafectAux != null) {
                                if (areaafectAux.equals("TRA")) {
                                    descareaafect = "Tranquila";
                                }
                                if (areaafectAux.equals("ANS")) {
                                    descareaafect = "Ansiosa";
                                }
                                if (areaafectAux.equals("SDD")) {
                                    descareaafect = 
                                            "Sentimientos de desesperanza";
                                }
                                if (areaafectAux.equals("ANG")) {
                                    descareaafect = "Angustiada";
                                }
                                if (areaafectAux.equals("TRI")) {
                                    descareaafect = "Triste";
                                }
                                if (areaafectAux.equals("CON")) {
                                    descareaafect = "Confundida";
                                }
                                if (areaafectAux.equals("DES")) {
                                    descareaafect = "Desorientada";
                                }
                                if (areaafectAux.equals("TEM")) {
                                    descareaafect = "Temerosa/o";
                                }
                                if (areaafectAux.equals("EXP")) {
                                    descareaafect = "Explosivo";
                                }
                                if (areaafectAux.equals("APL")) {
                                    descareaafect = "Afecto Plano";
                                }
                                AREA_AFECTIVA = 
                                        AREA_AFECTIVA + descareaafect + ",";

                            }
                        }
                        if (AREA_AFECTIVA != null && 
                            AREA_AFECTIVA.length() > 2) {
                            AREA_AFECTIVA = 
                                    AREA_AFECTIVA.substring(0, AREA_AFECTIVA.length() - 
                                                            1);
                        }

                    }


                    APOYO_FAMILIAR = 
                            formatearCampo(evaluacion.getHegcapoyofamil());
                    CUAL_APOYO = formatearCampo(evaluacion.getHegccualapoyo());
                    CANALES_COMUNICACION = 
                            formatearCampo(evaluacion.getHegccanalcomun());
                    CUAL_CANAL = formatearCampo(evaluacion.getHegccualcanal());
                    LABORAL_ESTUDIOS = 
                            formatearCampo(evaluacion.getHegcproblestud());
                    SERVICIOS_APOYO = 
                            formatearCampo(evaluacion.getHegcrelacapoyo());
                    RELACIONES_FAMILIARES = 
                            formatearCampo(evaluacion.getHegcrelacfamil());
                    CUAL_PROBLEMA = 
                            formatearCampo(evaluacion.getHegccualprobl());
                    CUAL_RELACION = 
                            formatearCampo(evaluacion.getHegccualrelac());
                 
                    COMPOSICIONDINA_FAMILIAR=evaluacion.getHegccompfami();
                    
                    DESARROLLO_SESION=evaluacion.getHegcdesasesion();   

                }


            }


            if (consulta.getChestadpsico() != null && 
                !consulta.getChestadpsico().isEmpty()) {
                Chestadpsico estado = null;
                AREA_AFECTIVA_INTERRUPCION = "";
                AREA_COGNITIVA_INTERRUPCION = "";
                AREA_SOMATICA_INTERRUPCION = "";
                AREA_RELACIONAL_INTERRUPCION = "";
                OBSERVACIONES_INTERRUPCION = "";
                OTRO_SOMATICO = "";
                OTRO_RELACIONAL = "";
                OTRO_COGNITIVO = "";
                Iterator it = consulta.getChestadpsico().iterator();
                if (it.hasNext())
                    estado = (Chestadpsico)it.next();
                if (estado != null) {
                    if (estado.getHepcareacogni() != null && 
                        !estado.getHepcareacogni().equals("")) {
                        StringTokenizer stk = 
                            new StringTokenizer(estado.getHepcareacogni(), 
                                                ",");
                        String areacogniAux = "";
                        String descareacogni = "";
                        while (stk.hasMoreTokens()) {
                            areacogniAux = "";
                            descareacogni = "";
                            areacogniAux = stk.nextToken();
                            if (areacogniAux != null) {
                                if (areacogniAux.equals("SA"))
                                    descareacogni = "Sin AlteraciNn";
                                if (areacogniAux.equals("DI"))
                                    descareacogni = "Dispersa";
                                if (areacogniAux.equals("PN"))
                                    descareacogni = 
                                            "Pensamientos negativos frecuentes";
                                if (areacogniAux.equals("DP"))
                                    descareacogni = 
                                            "Dificultad para resolver problemas";
                                if (areacogniAux.equals("IP"))
                                    descareacogni = "Ideas de persecuciNn";
                                if (areacogniAux.equals("IM"))
                                    descareacogni = "Incapacidad Mental";
                                if (areacogniAux.equals("DC"))
                                    descareacogni = 
                                            "Dificultad para la concentraciNn y producciNn intelectual";
                                if (areacogniAux.equals("OT"))
                                    descareacogni = "Otro";
                                AREA_COGNITIVA_INTERRUPCION = 
                                        (new StringBuilder()).append(AREA_COGNITIVA_INTERRUPCION).append(descareacogni).append(",").toString();
                            }
                        }
                        if (AREA_COGNITIVA_INTERRUPCION != null && 
                            AREA_COGNITIVA_INTERRUPCION.length() > 2)
                            AREA_COGNITIVA_INTERRUPCION = 
                                    AREA_COGNITIVA_INTERRUPCION.substring(0, 
                                                                          AREA_COGNITIVA_INTERRUPCION.length() - 
                                                                          1);
                    }
                    if (estado.getHepcareaafect() != null && 
                        !estado.getHepcareaafect().equals("")) {
                        StringTokenizer stk = 
                            new StringTokenizer(estado.getHepcareaafect(), 
                                                ",");
                        String areaafectAux = null;
                        String descareaafect = "";
                        while (stk.hasMoreTokens()) {
                            areaafectAux = "";
                            descareaafect = "";
                            areaafectAux = stk.nextToken();
                            if (areaafectAux != null) {
                                if (areaafectAux.equals("SAL"))
                                    descareaafect = "Sin AlteraciNn";
                                if (areaafectAux.equals("ANG"))
                                    descareaafect = "Angustiada";
                                if (areaafectAux.equals("DEP"))
                                    descareaafect = "Deprimida";
                                if (areaafectAux.equals("CON"))
                                    descareaafect = "Confundida";
                                if (areaafectAux.equals("APA"))
                                    descareaafect = "ApNtica";
                                if (areaafectAux.equals("ANS"))
                                    descareaafect = "Ansiosa";
                                if (areaafectAux.equals("SDD"))
                                    descareaafect = 
                                            "Sentimientos de desesperanza";
                                if (areaafectAux.equals("IMP"))
                                    descareaafect = "Impotencia";

                                AREA_AFECTIVA_INTERRUPCION = 
                                        (new StringBuilder()).append(AREA_AFECTIVA_INTERRUPCION).append(descareaafect).append(",").toString();
                            }
                        }
                        if (AREA_AFECTIVA_INTERRUPCION != null && 
                            AREA_AFECTIVA_INTERRUPCION.length() > 2)
                            AREA_AFECTIVA_INTERRUPCION = 
                                    AREA_AFECTIVA_INTERRUPCION.substring(0, 
                                                                         AREA_AFECTIVA_INTERRUPCION.length() - 
                                                                         1);
                    }
                    if (estado.getHepcareasomat() != null && 
                        !estado.getHepcareasomat().equals("")) {
                        StringTokenizer stk = 
                            new StringTokenizer(estado.getHepcareasomat(), 
                                                ",");
                        String areasomaticaAux = null;
                        String descareasomatica = "";
                        while (stk.hasMoreTokens()) {
                            areasomaticaAux = "";
                            descareasomatica = "";
                            areasomaticaAux = stk.nextToken();
                            if (areasomaticaAux != null) {
                                if (areasomaticaAux.equals("SA"))
                                    descareasomatica = "Sin AlteraciNn";
                                if (areasomaticaAux.equals("AG"))
                                    descareasomatica = "Agotamiento";
                                if (areasomaticaAux.equals("IM"))
                                    descareasomatica = "Imsomnio";
                                if (areasomaticaAux.equals("AS"))
                                    descareasomatica = 
                                            "Alteraciones en el sueNo";
                                if (areasomaticaAux.equals("IN"))
                                    descareasomatica = "Inapetecia";
                                if (areasomaticaAux.equals("DE"))
                                    descareasomatica = "Debilidad";
                                if (areasomaticaAux.equals("AH"))
                                    descareasomatica = "Ahogo";
                                if (areasomaticaAux.equals("PA"))
                                    descareasomatica = "Palpitaciones";
                                if (areasomaticaAux.equals("OT"))
                                    descareasomatica = "Otro";
                                AREA_SOMATICA_INTERRUPCION = 
                                        (new StringBuilder()).append(AREA_SOMATICA_INTERRUPCION).append(descareasomatica).append(",").toString();
                            }
                        }
                        if (AREA_SOMATICA_INTERRUPCION != null && 
                            AREA_SOMATICA_INTERRUPCION.length() > 2)
                            AREA_SOMATICA_INTERRUPCION = 
                                    AREA_SOMATICA_INTERRUPCION.substring(0, 
                                                                         AREA_SOMATICA_INTERRUPCION.length() - 
                                                                         1);
                    }
                    if (estado.getHepcarearelac() != null && 
                        !estado.getHepcarearelac().equals("")) {
                        StringTokenizer stk = 
                            new StringTokenizer(estado.getHepcarearelac(), 
                                                ",");
                        String arearelacionalAux = null;
                        String descarearelacional = "";
                        while (stk.hasMoreTokens()) {
                            arearelacionalAux = "";
                            descarearelacional = "";
                            arearelacionalAux = stk.nextToken();
                            if (arearelacionalAux != null) {
                                if (arearelacionalAux.equals("SA"))
                                    descarearelacional = "Sin AlteraciNn";
                                if (arearelacionalAux.equals("AG"))
                                    descarearelacional = "Agresividad";
                                if (arearelacionalAux.equals("AI"))
                                    descarearelacional = "Aislamiento";
                                if (arearelacionalAux.equals("PA"))
                                    descarearelacional = "Pasmada";
                                if (arearelacionalAux.equals("FO"))
                                    descarearelacional = "Fobia";
                                if (arearelacionalAux.equals("OT"))
                                    descarearelacional = "Otro";
                                AREA_RELACIONAL_INTERRUPCION = 
                                        (new StringBuilder()).append(AREA_RELACIONAL_INTERRUPCION).append(descarearelacional).append(",").toString();
                            }
                        }
                        if (AREA_RELACIONAL_INTERRUPCION != null && 
                            AREA_RELACIONAL_INTERRUPCION.length() > 2)
                            AREA_RELACIONAL_INTERRUPCION = 
                                    AREA_RELACIONAL_INTERRUPCION.substring(0, 
                                                                           AREA_RELACIONAL_INTERRUPCION.length() - 
                                                                           1);
                    }
                    OBSERVACIONES_INTERRUPCION = 
                            formatearCampo(estado.getHepcobservacio());
                    OTRO_COGNITIVO = formatearCampo(estado.getHepcotrocogni());
                    OTRO_RELACIONAL = 
                            formatearCampo(estado.getHepcotrorelac());
                    OTRO_SOMATICO = formatearCampo(estado.getHepcotrosomat());
                    CUAL_FOBIA = formatearCampo(estado.getHepccualfobia());
                }
            }


            if (consulta.getChpladetrat() != null && 
                !consulta.getChpladetrat().isEmpty()) {

                Chpladetrat plan = null;
                TIPO_INTERVENCION_PSICO = "";
                NUMERO_SESIONES = "";
                COMPROMISOS_PSCIO = "";


                Iterator it = consulta.getChpladetrat().iterator();
                if (it.hasNext()) {
                    plan = (Chpladetrat)it.next();
                }
                if (plan != null) {

                    if (plan.getHptctipointer() != null && 
                        !plan.getHptctipointer().equals("")) {
                        StringTokenizer stk = 
                            new StringTokenizer(plan.getHptctipointer(), ",");
                        String tipoInterAux = null;
                        String descInter = "";

                        while (stk.hasMoreTokens()) {
                            tipoInterAux = "";
                            descInter = "";
                            tipoInterAux = stk.nextToken();
                            if (tipoInterAux != null) {
                                if (tipoInterAux.equals("CI")) {
                                    descInter = "Consulta Individual";
                                }
                                if (tipoInterAux.equals("CP")) {
                                    descInter = "Consulta Pareja";
                                }
                                if (tipoInterAux.equals("CF")) {
                                    descInter = "Consulta de Familia";
                                }

                                TIPO_INTERVENCION_PSICO = 
                                        TIPO_INTERVENCION_PSICO + descInter + 
                                        ",";

                            }
                        }
                        if (TIPO_INTERVENCION_PSICO != null && 
                            TIPO_INTERVENCION_PSICO.length() > 2) {
                            TIPO_INTERVENCION_PSICO = 
                                    TIPO_INTERVENCION_PSICO.substring(0, 
                                                                      TIPO_INTERVENCION_PSICO.length() - 
                                                                      1);
                        }

                    }

                    NUMERO_SESIONES = formatearCampo(plan.getHptnnumersesio());
                    COMPROMISOS_PSCIO = plan.getHptccompromiso();

                }


            }
            List lstHistoricoAntecedente = null;
            List lstHistoricoAntecedenteHoy = null;
            List<Chconsulta> aux1 = null;
            
            
            lstHistoricoAntecedente = new ArrayList();
            
            if (usuario != null && usuario.getHuslnumero() != null) {
                try {
                
                        lstHistoricoAntecedenteHoy =   this.serviceLocator.getClinicoService().getAntecedentesUsuarioActualConsulta(consulta.getHcolnumero());
                        aux1 = this.serviceLocator.getHistoriaService().getConsultasHistoricoAntecedentes(usuario.getHuslnumero(),false);
                
                    lstHistoricoAntecedente =
                        this.serviceLocator.getClinicoService().getAntecedentesUsuarioAnterioresXFecha(usuario.getHuslnumero(), consulta.getHcodfecregistr());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    
                   
            }


            if (lstHistoricoAntecedente != null && 
                !lstHistoricoAntecedente.isEmpty()) {
                ANTECEDENTE_ALERGICOS = "";
                SIN_ANTECEDENTES = "";
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
                SIN_ANTECEDENTES = "";
               
                if(lstHistoricoAntecedenteHoy != null && !lstHistoricoAntecedenteHoy.isEmpty() ){
                    Chantecegene antecedenteAux = (Chantecegene)lstHistoricoAntecedenteHoy.get(0);
                    SIN_ANTECEDENTES =   formatearCampo(antecedenteAux.getHantdescripcio()) + 
                            " Fecha Registro:  " + antecedenteAux.getHandfecregistr() + " \n" ; 
                }
                
                
                Iterator it = lstHistoricoAntecedente.iterator();
                while (it.hasNext()) {

                    Chantecegene antecedente = (Chantecegene)it.next();
                    if (antecedente != null) {
                        if (antecedente.getHanntipoante() != null && 
                            antecedente.getHanntipoante().equals(IConstantes.CODIGO_SIN_ANTECEDENTES)) {
                            SIN_ANTECEDENTES = 
                                    SIN_ANTECEDENTES + antecedente.getHantdescripcio() + 
                                    " Fecha Registro:  " + antecedente.getHandfecregistr() + " \n" ;
                        } else if (antecedente.getHanntipoante() != null && 
                                   antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_ALERGICOS)) {
                            ANTECEDENTE_ALERGICOS = 
                                    ANTECEDENTE_ALERGICOS + formatearCampo(antecedente.getHantdescripcio()) + 
                                     " Fecha Registro:  " + antecedente.getHandfecregistr() + " \n" ;
                        } else if (antecedente.getHanntipoante() != null && 
                                   antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_FAMILIARES)) {
                            ANTECEDENTES_FAMILIARES = 
                                    ANTECEDENTES_FAMILIARES + formatearCampo(antecedente.getHantdescripcio()) + 
                                     " Fecha Registro:  " + antecedente.getHandfecregistr() + " \n" ;
                        } else if (antecedente.getHanntipoante() != null && 
                                   antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_ITS)) {
                            ANTECEDENTES_ITS = 
                                    ANTECEDENTES_ITS + formatearCampo(antecedente.getHantdescripcio()) + 
                                     " Fecha Registro:  " + antecedente.getHandfecregistr() + " \n" ;
                        } else if (antecedente.getHanntipoante() != null && 
                                   antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_PATOLOGICOS)) {
                            ANTECEDENTES_PATOLOGICOS = 
                                    ANTECEDENTES_PATOLOGICOS + 
                                    formatearCampo(antecedente.getHantdescripcio()) + 
                                     " Fecha Registro:  " + antecedente.getHandfecregistr() + " \n" ;
                        } else if (antecedente.getHanntipoante() != null && 
                                   antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_QUIRURGICOS)) {
                            ANTECEDENTES_QUIRURGICOS = 
                                    ANTECEDENTES_QUIRURGICOS + 
                                    formatearCampo(antecedente.getHantdescripcio()) + 
                            " Fecha Registro:  " + antecedente.getHandfecregistr() + " \n" ;
                        } else if (antecedente.getHanntipoante() != null && 
                                   antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_TOXICOS)) {
                            ANTECEDENTES_TOXICOS = 
                                    ANTECEDENTES_TOXICOS + formatearCampo(antecedente.getHantdescripcio()) + 
                            " Fecha Registro:  " + antecedente.getHandfecregistr() + " \n" ;
                        } else if (antecedente.getHanntipoante() != null && 
                                   antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_TRASNFUSIONALES)) {
                            ANTECEDENTES_TRANSFUNCIONALES = 
                                    ANTECEDENTES_TRANSFUNCIONALES + 
                                    antecedente.getHantdescripcio() + " Fecha Registro:  " + antecedente.getHandfecregistr() + " \n" ;
                        } else if (antecedente.getHanntipoante() != null && 
                                   antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_TRAUMATICOS)) {
                            ANTECEDENTES_TRAUMATICOS = 
                                    ANTECEDENTES_TRAUMATICOS + 
                                    formatearCampo(antecedente.getHantdescripcio()) + 
                                     " Fecha Registro:  " + antecedente.getHandfecregistr() + " \n" ;
                        } else if (antecedente.getHanntipoante() != null && 
                                   antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_FARMACOLOGICO)) {
                            ANTECEDENTES_FARMACOLOGICOS = 
                                    ANTECEDENTES_FARMACOLOGICOS + 
                                    formatearCampo(antecedente.getHantdescripcio()) + 
                            " Fecha Registro:  " + antecedente.getHandfecregistr() + " \n" ;
                        } else if (antecedente.getHanntipoante() != null && 
                                   antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_MEDICACION_EMBARAZO)) {
                            ANTECEDENTES_MEDICACION = 
                                    ANTECEDENTES_MEDICACION + formatearCampo(antecedente.getHantdescripcio()) + 
                            " Fecha Registro:  " + antecedente.getHandfecregistr() + " \n" ;
                        } else if (antecedente.getHanntipoante() != null && 
                                   antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_PARTO)) {
                            ANTECEDENTES_PARTO = 
                                    ANTECEDENTES_PARTO + formatearCampo(antecedente.getHantdescripcio()) + 
                            " Fecha Registro:  " + antecedente.getHandfecregistr() + " \n" ;
                        } else if (antecedente.getHanntipoante() != null && 
                                   antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_PERINATALES)) {
                            ANTECEDENTES_COMPLICACIONES = 
                                    ANTECEDENTES_COMPLICACIONES + 
                                    formatearCampo(antecedente.getHantdescripcio()) + 
                                     " Fecha Registro:  " + antecedente.getHandfecregistr() + " \n" ;
                        } else if (antecedente.getHanntipoante() != null && 
                                   antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_INMUNIZACIONES)) {
                            ANTECEDENTES_INMUNIZACIONES = 
                                    ANTECEDENTES_INMUNIZACIONES + 
                                    formatearCampo(antecedente.getHantdescripcio()) + 
                            " Fecha Registro:  " + antecedente.getHandfecregistr() + " \n" ;
                        } else if (antecedente.getHanntipoante() != null && 
                                   antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_SICOMOTOR)) {
                            ANTECEDENTES_SICOMOTOR = 
                                    ANTECEDENTES_SICOMOTOR + formatearCampo(antecedente.getHantdescripcio()) + 
                            " Fecha Registro:  " + antecedente.getHandfecregistr() + " \n" ;
                        } else if (antecedente.getHanntipoante() != null && 
                                   antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_ALIMENTACION)) {
                            ANTECEDENTES_ALIMENTACION = 
                                    ANTECEDENTES_ALIMENTACION + 
                                    formatearCampo(antecedente.getHantdescripcio()) + 
                            " Fecha Registro:  " + antecedente.getHandfecregistr() + " \n" ;
                        } else if (antecedente.getHanntipoante() != null && 
                                   antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_HOSPITALIZACIONES)) {
                            ANTECEDENTES_HOSPITALIZACIONES = 
                                    ANTECEDENTES_HOSPITALIZACIONES + 
                                    formatearCampo(antecedente.getHantdescripcio()) + 
                            " Fecha Registro:  " + antecedente.getHandfecregistr() + " \n" ;
                        }
                    }
                }

            }else{
                SIN_ANTECEDENTES = "El Usuario no refiere antecdentes";
            }
            if(aux1 !=null && !aux1.isEmpty()){
                ANTECEDENTE_ALERGICOS = "";
                SIN_ANTECEDENTES = "";
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
                SIN_ANTECEDENTES = "";
                CUALES_MEDICAMENTOS ="";
                CUALES_ALIMENTOS ="";
                CUALES_SAMBIENTE ="";
                CUALES_SPIEL ="";
                CUALES_PINSECTO="";
                CUALES_OTRA ="";
                if(lstHistoricoAntecedenteHoy != null && !lstHistoricoAntecedenteHoy.isEmpty() ){
                    Chantecegene antecedenteAux = (Chantecegene)lstHistoricoAntecedenteHoy.get(0);
                    SIN_ANTECEDENTES =   formatearCampo(antecedenteAux.getHantdescripcio()) + 
                            " Fecha Registro:  " + antecedenteAux.getHandfecregistr() + " \n" ; 
                }
                
                Iterator it ;
                for(int i =0;i<aux1.size();i++){
                    AntecedentesGeneralesDTO objeto = new AntecedentesGeneralesDTO();
                    Chantox toxicos;
                    Chantfami familiares;
                    Chantalerg alergicos;
                    Chantfarma farmacologicos;
                    Chantit its;
                    Chanttrans transfusionales;
                    Chantpatol patologicos;
                    Chantquir quirurgicos;
                    Chanttrauma traumacologicos;
                    if(aux1.get(i).getChantox()!=null){
                        it = aux1.get(i).getChantox().iterator();
                        while(it.hasNext()){
                        toxicos = (Chantox)it.next();
                        if(("S").equals(toxicos.getHantcrefiere())){
                            ANTECEDENTES_TOXICOS = 
                                    ANTECEDENTES_TOXICOS + formatearCampo(toxicos.getHantcdesc()) + 
                                     " Fecha Registro:  " + toxicos.getHantdfecreg() + " \n" ;
                        }
                      

                        }
                        
                    }
                  
                    if(aux1.get(i).getChantalerg()!=null){
                        it = aux1.get(i).getChantalerg().iterator();
                        while(it.hasNext()){
                            alergicos = (Chantalerg)it.next();
                            if(("S").equals(alergicos.getHanacrefiere())){
                            ANTECEDENTE_ALERGICOS = 
                                    ANTECEDENTE_ALERGICOS + formatearCampo(alergicos.getHanacdesc()) + 
                                     " Fecha Registro:  " + alergicos.getHanadfecreg() + " \n" ;
                            if(alergicos.getHanacmedcual()!=null){
                                CUALES_MEDICAMENTOS = CUALES_MEDICAMENTOS + formatearCampo(alergicos.getHanacmedcual()) +
                                " Fecha Registro: " + alergicos.getHanadfecreg();
                            }
                            if(alergicos.getHanacalicual()!=null){
                                CUALES_ALIMENTOS =  CUALES_ALIMENTOS + formatearCampo(alergicos.getHanacalicual()) +
                                " Fecha Registro: " + alergicos.getHanadfecreg();
                            }
                            if(alergicos.getHanacsusambcual()!=null){
                                CUALES_SAMBIENTE =  CUALES_SAMBIENTE + formatearCampo(alergicos.getHanacsusambcual()) +
                                " Fecha Registro: " + alergicos.getHanadfecreg();
                            }
                            if(alergicos.getHanacsuspielcual()!=null){
                                CUALES_SPIEL =  CUALES_SPIEL + formatearCampo(alergicos.getHanacsuspielcual()) +
                                " Fecha Registro: " + alergicos.getHanadfecreg();
                            }
                            if(alergicos.getHanacpicadcual()!=null){
                                CUALES_PINSECTO =  CUALES_PINSECTO + formatearCampo(alergicos.getHanacpicadcual()) +
                                " Fecha Registro: " + alergicos.getHanadfecreg();
                            }
                            if(alergicos.getHanacotracual()!=null){
                                CUALES_OTRA =  CUALES_OTRA + formatearCampo(alergicos.getHanacotracual()) +
                                " Fecha Registro: " + alergicos.getHanadfecreg();
                            }
                            }
                           
                        }
                    }
                   
                    if(aux1.get(i).getChantfami()!=null){
                        it = aux1.get(i).getChantfami().iterator();
                        while(it.hasNext()){
                            familiares = (Chantfami)it.next();
                            if(("S").equals(familiares.getHanfcrefiere())){
                            ANTECEDENTES_FAMILIARES = 
                                    ANTECEDENTES_FAMILIARES + formatearCampo(familiares.getHanfcdesc()) + 
                                     " Fecha Registro:  " + familiares.getHanfdfecreg() + " \n" ;
                            }
                         
                            
                        }
                    }
                   
                    if(aux1.get(i).getChantquir()!=null){
                        it = aux1.get(i).getChantquir().iterator();
                        while(it.hasNext()){
                            quirurgicos = (Chantquir)it.next();
                            if(("S").equals(quirurgicos.getHanqcrefiere())){
                            ANTECEDENTES_QUIRURGICOS = 
                                    ANTECEDENTES_QUIRURGICOS + formatearCampo(quirurgicos.getHanqcdesc()) + 
                                     " Fecha Registro:  " + quirurgicos.getHanqdfecreg() + " \n" ;
                            }
                         
                      
                        }
                    }
                 
                    if(aux1.get(i).getChantpatol()!=null){
                        it = aux1.get(i).getChantpatol().iterator();
                        while(it.hasNext()){
                            patologicos = (Chantpatol)it.next();
                            if(("S").equals(patologicos.getHagcrefiere())){
                            ANTECEDENTES_PATOLOGICOS = 
                                    ANTECEDENTES_PATOLOGICOS + formatearCampo(patologicos.getHagcdescri()) + 
                                     " Fecha Registro:  " + patologicos.getHagdfecreg() + " \n" ;
                            }
                         
                                                            
                        }
                    }
                  
                    if(aux1.get(i).getChantfarma()!=null){
                        it = aux1.get(i).getChantfarma().iterator();
                        while(it.hasNext()){
                            farmacologicos = (Chantfarma)it.next();
                            if(("S").equals(farmacologicos.getHanfcrefiere())){
                            ANTECEDENTES_FARMACOLOGICOS = 
                                    ANTECEDENTES_FARMACOLOGICOS + formatearCampo(farmacologicos.getHanfcdesc()) + 
                                     " Fecha Registro:  " + farmacologicos.getHanfdfecreg() + " \n" ;
                            }
                           
                          
                        }
                    }
                   
                    if(aux1.get(i).getChanttrauma()!=null){
                        it = aux1.get(i).getChanttrauma().iterator();
                        while(it.hasNext()){
                            traumacologicos = (Chanttrauma)it.next();
                            if(("S").equals(traumacologicos.getHantcrefiere())){
                            ANTECEDENTES_TRAUMATICOS = 
                                    ANTECEDENTES_TRAUMATICOS + formatearCampo(traumacologicos.getHantcdesc()) + 
                                     " Fecha Registro:  " + traumacologicos.getHantdfecreg() + " \n" ;
                            }
                         
                        }
                    }
                   
                    if(aux1.get(i).getChantit()!=null){
                        it = aux1.get(i).getChantit().iterator();
                        while(it.hasNext()){
                            its = (Chantit)it.next();
                            if(("S").equals(its.getHanicrefiere())){
                            ANTECEDENTES_ITS = 
                                    ANTECEDENTES_ITS + formatearCampo(its.getHanicdesc()) + 
                                     " Fecha Registro:  " + its.getHanidfecreg() + " \n" ;
                            }
                        
                           
                        }
                    }
                   
                    if(aux1.get(i).getChanttrans()!=null){
                        it = aux1.get(i).getChanttrans().iterator();
                        while(it.hasNext()){
                            transfusionales = (Chanttrans)it.next();
                            if(("S").equals(transfusionales.getHantcrefiere())){
                            ANTECEDENTES_TRANSFUNCIONALES = 
                                    ANTECEDENTES_TRANSFUNCIONALES + formatearCampo(transfusionales.getHantcdesc()) + 
                                     " Fecha Registro:  " + transfusionales.getHantdfecreg() + " \n" ;
                            }
                          
                        }
                    }
                   
                }
            }
            else{
                SIN_ANTECEDENTES = "El Usuario no refiere antecdentes";
            }

            
            if (consulta.getChantecvasec() != null && 
                !consulta.getChantecvasec().isEmpty()) {

                HIJOS_BIOLOGICOS_JUNTOS = null;
                HIJOS_BIOLOGICOS_PACIENTE = null;
                HIJOS_BIOLOGICOS_PAREJA = null;
                METODOS_PLANIFICACION = "";

                Iterator itVasec = (consulta.getChantecvasec()).iterator();
                while (itVasec.hasNext()) {

                    Chantecvasec antecedenteVasec = 
                        (Chantecvasec)itVasec.next();
                    if (antecedenteVasec != null) {
                        if (antecedenteVasec.getHavnbiolpaci() != null) {
                            HIJOS_BIOLOGICOS_PACIENTE = 
                                    antecedenteVasec.getHavnbiolpaci();
                        }

                        if (antecedenteVasec.getHavnbiolpare() != null) {
                            HIJOS_BIOLOGICOS_PAREJA = 
                                    antecedenteVasec.getHavnbiolpare();
                        }

                        if (antecedenteVasec.getHavnbioljunt() != null) {
                            HIJOS_BIOLOGICOS_JUNTOS = 
                                    antecedenteVasec.getHavnbioljunt();
                        }

                        if (antecedenteVasec.getHavcmetoplan() != null) {
                            String metodosPlanificacion = 
                                    antecedenteVasec.getHavcmetoplan();
                                    
                            if (metodosPlanificacion != null) {
                                if (metodosPlanificacion.equals("PR")) {
                                    METODOS_PLANIFICACION = "Preservativo";
                                } else if (metodosPlanificacion.equals("OR")) {
                                    METODOS_PLANIFICACION = "Oral";
                                } else if (metodosPlanificacion.equals("IN")) {
                                    METODOS_PLANIFICACION = "Inyectable";
                                } else if (metodosPlanificacion.equals("IS")) {
                                    METODOS_PLANIFICACION = "ISD";
                                } else if (metodosPlanificacion.equals("DI")) {
                                    METODOS_PLANIFICACION = "DIU";
                                } else if (metodosPlanificacion.equals("OT")) {
                                    METODOS_PLANIFICACION = antecedenteVasec.getHavcotrometo();
                                }
                        }
                    }
                }
            }
        }


            if (consulta.getChanteginecos() != null && 
                !consulta.getChanteginecos().isEmpty()) {

                Chantegineco antecedente = null;
                Iterator it = consulta.getChanteginecos().iterator();
                if (it.hasNext()) {
                    antecedente = (Chantegineco)it.next();
                }

                if (antecedente != null) {
                    String tipoCiclo = "";
                    String ultimaCitologia = "";
                    GESTACIONES = antecedente.getHagnnumgesta();
                    PARTOS = antecedente.getHagnnumparto();
                    ABORTOS = antecedente.getHagnnumaborto();
                    CESAREAS = antecedente.getHagnnumcesare();
                    HIJOS_VIVOS = antecedente.getHagnnumvivo();
                    HIJOS_ECTOPICOS = antecedente.getHagnectopico();
                    HIJOS_MUERTOS = antecedente.getHagnmuerto();
                    MORTINATOS = antecedente.getHagnmortina();
                    HIJOS_NACIDOS_VIVOS = antecedente.getHagnnacivivo();
                    tipoCiclo = antecedente.getHagetipciclo();
                    ultimaCitologia = antecedente.getHagcultcitolo();
                    if (tipoCiclo != null) {
                        if (tipoCiclo.equals("I")) {
                            TIPO_CICLO = "Irregular";
                        } else if (tipoCiclo.equals("R")) {
                            TIPO_CICLO = "Regular";
                        } else if (tipoCiclo.equals("N")) {
                            TIPO_CICLO = "No ha Tenido Menarquia";
                        } else if (tipoCiclo.equals("A")) {
                            TIPO_CICLO = "Amenorrea";
                        }

                    }

                    if (ultimaCitologia != null) {
                        if (ultimaCitologia.equals("NO")) {
                            ULTIMA_CITOLOGIA = "Nunca";
                        } else if (ultimaCitologia.equals("-1")) {
                            ULTIMA_CITOLOGIA = "Hace menos de un aNo";
                        } else if (ultimaCitologia.equals("+1")) {
                            ULTIMA_CITOLOGIA = "Hace mas de un aNo";
                        } else if (ultimaCitologia.equals("NR")) {
                            ULTIMA_CITOLOGIA = "No recuerda";
                        }
                    }
                    
                    if(tipoCiclo!= null && tipoCiclo.equals("I")){
                    
                        FRECUENCIA_CICLO = antecedente.getHagnfreciclo() + " - " + antecedente.getHagnfrefincicl()  ;
                        DURACION_CICLO = formatearCampo(antecedente.getHagndurciclo()) + " - " +  formatearCampo(antecedente.getHagndurfincicl()) ; 
                       
                    }else{
                        FRECUENCIA_CICLO = formatearCampo(antecedente.getHagnfreciclo());
                        DURACION_CICLO = formatearCampo(antecedente.getHagndurciclo());    
                    }

                    
                    MENARQUIA = antecedente.getHagnmenarquia();
                    EDAD_PRIMERA_RELACION = antecedente.getHagnedadrelac();
                    FUR = formatearCampo(antecedente.getHagdfur());
                    FUP = formatearCampo(antecedente.getHagdfup());
                    FUC = formatearCampo(antecedente.getHagdfuc());
                }

            }


            if (consulta.getChviolencias() != null && 
                !consulta.getChviolencias().isEmpty()) {

                Chviolencia violencia = null;
                Iterator it = consulta.getChviolencias().iterator();
                if (it.hasNext()) {
                    violencia = (Chviolencia)it.next();
                }

                if (violencia != null) {
                    HA_SUFRIDO_VIOLENCIA = violencia.getHviesufreviol();
                    VIOLENCIA_FISICA = violencia.getHvicfisiquien();
                    VIOLENCIA_PSICOLOGICA = violencia.getHvicpsicquien();
                    VIOLENCIA_SEXUAL = violencia.getHvicsexuquien();
                    RIESGO_PERSONA_MALTRATA = violencia.getHvieriesgo();

                    ASESORIA_HABLAR = violencia.getHviehabla();
                    OBSERVACIONES_VIOLENCIA = violencia.getHvitobserva();
                }


            }

            if (consulta.getChidentiriesgo() != null && 
                !consulta.getChidentiriesgo().isEmpty()) {

                Chidentiriesgo identiriesgo = null;
                Iterator it = consulta.getChidentiriesgo().iterator();
                if (it.hasNext()) {
                    identiriesgo = (Chidentiriesgo)it.next();
                }

                if (identiriesgo != null) {
                    if (identiriesgo.getHidecdiscrasi() == null) {
                        DISCRASIA_SANGUNNEA = null;
                    } else if (identiriesgo.getHidecdisobser() != null) {
                        DISCRASIA_SANGUNNEA = identiriesgo.getHidecdisobser();
                    } else {
                        DISCRASIA_SANGUNNEA = "No";
                    }
                    if (identiriesgo.getHidecanticua() == null) {
                        MANEJO_CON_ANTICOAGULANTES = null;
                    } else if (identiriesgo.getHidecantcuag() != null) {
                        MANEJO_CON_ANTICOAGULANTES = identiriesgo.getHidecantcuag();
                    } else {
                        MANEJO_CON_ANTICOAGULANTES = "No";
                    }
                    if (identiriesgo.getHidecpatolog() == null) {
                        PATOLOGIAS_DESCOMPENSADAS = null;
                    } else if (identiriesgo.getHidecpatoobs() != null) {
                        PATOLOGIAS_DESCOMPENSADAS = identiriesgo.getHidecpatoobs();
                    } else {
                        PATOLOGIAS_DESCOMPENSADAS = "No";
                    }
                    if (identiriesgo.getHidecacretis() == null) {
                        PACIENTE_CON_ACRETISMO = null;
                    } else if (identiriesgo.getHidecacreobs() != null) {
                        PACIENTE_CON_ACRETISMO = identiriesgo.getHidecacreobs();
                    } else {
                        PACIENTE_CON_ACRETISMO = "No";
                    }
                    if (identiriesgo.getHidecsospech() == null) {
                        SOSPECHA_DE_CORIOAMNIONITIS = null;
                    } else if (identiriesgo.getHidecsosobse() != null) {
                        SOSPECHA_DE_CORIOAMNIONITIS = identiriesgo.getHidecsosobse();
                    } else {
                        SOSPECHA_DE_CORIOAMNIONITIS = "No";
                    }
                    if (identiriesgo.getHidecpacices() == null) {
                        PACIENTE_CON_UNA_CESAREA = null;
                    } else if (identiriesgo.getHideccesaobs() != null) {
                        PACIENTE_CON_UNA_CESAREA = identiriesgo.getHideccesaobs();
                    } else {
                        PACIENTE_CON_UNA_CESAREA = "No";
                    }
                    if (identiriesgo.getHiceccesados() == null) {
                        PACIENTE_CON_DOS_CESAREAS = null;
                    } else if (identiriesgo.getHiceccedosob() != null) {
                        PACIENTE_CON_DOS_CESAREAS = identiriesgo.getHiceccedosob();
                    } else {
                        PACIENTE_CON_DOS_CESAREAS = "No";
                    }
                    if (identiriesgo.getHicecalterac() == null) {
                        PACIENTE_CON_ALTERACIONES_ANATOMICAS = null;
                    } else if (identiriesgo.getHicecalteobs() != null) {
                        PACIENTE_CON_ALTERACIONES_ANATOMICAS = identiriesgo.getHicecalteobs();
                    } else {
                        PACIENTE_CON_ALTERACIONES_ANATOMICAS = "No";
                    }
                    if (identiriesgo.getHicecmalfom() == null) {
                        PRESENCIA_DE_UNA_MALFORMACION = null;
                    } else if (identiriesgo.getHicecmalobse() != null) {
                        PRESENCIA_DE_UNA_MALFORMACION = identiriesgo.getHicecmalobse();
                    } else {
                        PRESENCIA_DE_UNA_MALFORMACION = "No";
                    }
                    if (identiriesgo.getHicecplacent() == null) {
                        PLACENTA_PREVIA = null;
                    } else if (identiriesgo.getHicecplaobse() != null) {
                        PLACENTA_PREVIA = identiriesgo.getHicecplaobse();
                    } else {
                        PLACENTA_PREVIA = "No";
                    }
                    if (identiriesgo.getHicecanemia() == null) {
                        PACIENTE_CON_ANEMIA = null;
                    } else if (identiriesgo.getHicecaneobse() != null) {
                        PACIENTE_CON_ANEMIA = identiriesgo.getHicecaneobse();
                    } else {
                        PACIENTE_CON_ANEMIA = "No";
                    }

                    if (identiriesgo.getHidecriehemo() == null) {
                        RIESGO_HEMORRAGIA = null;
                        RIESGO_HEMORRAGIA_VAL = null;
                        RIESGO_HEMORRAGIA_OBS = null;
                    } else if (identiriesgo.getHidecriehemo().equals("S")) {
                        RIESGO_HEMORRAGIA = "SI";
                        RIESGO_HEMORRAGIA_OBS = identiriesgo.getHidecriheobs();
                        
                        RIESGO_HEMORRAGIA_VAL = "";
                        if (identiriesgo.getHidecriheval() != null && !identiriesgo.getHidecriheval().equals("")) {
                            StringTokenizer stk = new StringTokenizer(identiriesgo.getHidecriheval(), ",");
                            String hemorragiaAux = null;
                            String deschemorragia = "";
                            while (stk.hasMoreTokens()) {
                                hemorragiaAux = "";
                                deschemorragia = "";
                                hemorragiaAux = stk.nextToken();
                                if (hemorragiaAux != null) {
                                    if (hemorragiaAux.equals("DS"))
                                        deschemorragia = "Discrasia sanguNnea";
                                    if (hemorragiaAux.equals("AC"))
                                        deschemorragia = "AnticoagulaciNn";
                                    if (hemorragiaAux.equals("PA"))
                                        deschemorragia = "PlacentaciNn anormal";
                                    if (hemorragiaAux.equals("CA"))
                                        deschemorragia = "CesNreas anteriores";
                                    if (hemorragiaAux.equals("CR"))
                                        deschemorragia = "Antecedente de cNdigo rojo";

                                    RIESGO_HEMORRAGIA_VAL = 
                                            (new StringBuilder()).append(RIESGO_HEMORRAGIA_VAL).append(deschemorragia).append(",").toString();
                                }
                            }
                            if (RIESGO_HEMORRAGIA_VAL == null) {
                                RIESGO_HEMORRAGIA_VAL = "";
                            } else if (RIESGO_HEMORRAGIA_VAL.length() > 2) {
                                RIESGO_HEMORRAGIA_VAL = 
                                        RIESGO_HEMORRAGIA_VAL.substring(0, RIESGO_HEMORRAGIA_VAL.length() - 1);
                            }
                        }
                    } else {
                        RIESGO_HEMORRAGIA = "NO";
                        RIESGO_HEMORRAGIA_VAL = null;
                        RIESGO_HEMORRAGIA_OBS = null;
                    }

                    if (identiriesgo.getHidecpatcron() == null) {
                        PATOLOGIA_CRONICA = null;
                    } else if (identiriesgo.getHidecpatcron().equals("S")) {
                        PATOLOGIA_CRONICA = "SI";
                    } else {
                        PATOLOGIA_CRONICA = "NO";
                    }

                    if (identiriesgo.getHidecinfactu() == null) {
                        INFECCION_ACTUAL = null;
                        INFECCION_ACTUAL_VAL = null;
                        INFECCION_ACTUAL_OBS = null;
                    } else if (identiriesgo.getHidecinfactu().equals("S")) {
                        INFECCION_ACTUAL = "SI";
                        INFECCION_ACTUAL_OBS = identiriesgo.getHidecinacobs();
                        
                        INFECCION_ACTUAL_VAL = "";    
                        if (identiriesgo.getHidecinacval() != null && !identiriesgo.getHidecinacval().equals("")) {
                            StringTokenizer stk = new StringTokenizer(identiriesgo.getHidecinacval(), ",");
                            String infeccionAux = null;
                            String descinfeccion = "";
                            while (stk.hasMoreTokens()) {
                                infeccionAux = "";
                                descinfeccion = "";
                                infeccionAux = stk.nextToken();
                                if (infeccionAux != null) {
                                    if (infeccionAux.equals("CA"))
                                        descinfeccion = "Corioamnionitis";
                                    if (infeccionAux.equals("VG"))
                                        descinfeccion = "Vaginosis / Vaginitis";
                                    if (infeccionAux.equals("CV"))
                                        descinfeccion = "Cervicitis";
                                    if (infeccionAux.equals("OT"))
                                        descinfeccion = "Otro";

                                    INFECCION_ACTUAL_VAL = 
                                            (new StringBuilder()).append(INFECCION_ACTUAL_VAL).append(descinfeccion).append(",").toString();
                                }
                            }
                            if (INFECCION_ACTUAL_VAL == null) {
                                INFECCION_ACTUAL_VAL = "";
                            } else if (INFECCION_ACTUAL_VAL.length() > 2) {
                                INFECCION_ACTUAL_VAL = 
                                        INFECCION_ACTUAL_VAL.substring(0, INFECCION_ACTUAL_VAL.length() - 1);
                            }
                        }
                    } else {
                        INFECCION_ACTUAL = "NO";
                        INFECCION_ACTUAL_VAL = null;
                        INFECCION_ACTUAL_OBS = null;
                    }

                    if (identiriesgo.getHidecantmull() == null) {
                        MALFORMACION_MULLERIANA = null;
                    } else if (identiriesgo.getHidecantmull().equals("S")) {
                        MALFORMACION_MULLERIANA = "SI";
                        MALFORMACION_MULLERIANA_OBS = identiriesgo.getHidecanmuobs();
                    } else {
                        MALFORMACION_MULLERIANA = "NO";
                        MALFORMACION_MULLERIANA_OBS = null;
                    }

                    if (identiriesgo.getHidecserovih() == null) {
                        SEROLOGIA_VIH = null;
                    } else if (identiriesgo.getHidecserovih().equals("S")) {
                        SEROLOGIA_VIH = "SI";
                        SEROLOGIA_VIH_OBS = identiriesgo.getHidecseviobs();
                    } else {
                        SEROLOGIA_VIH = "NO";
                        SEROLOGIA_VIH_OBS = null;
                    }
                    
                    if (identiriesgo.getHidecvih() == null) {
                        VIH_RECIENTE = null;
                    } else if (identiriesgo.getHidecvih().equals("S")) {
                        VIH_RECIENTE = "SI";
                        VIH_RECIENTE_OBS = identiriesgo.getHidecvihobs();
                    } else {
                        VIH_RECIENTE = "NO";
                        VIH_RECIENTE_OBS = null;
                    }
                    

                    if (identiriesgo.getHidecsosanem() == null) {
                        SOSPECHA_ANEMIA = null;
                    } else if (identiriesgo.getHidecsosanem().equals("S")) {
                        SOSPECHA_ANEMIA = "SI";
                    } else {
                        SOSPECHA_ANEMIA = "NO";
                    }

                }
            }


            if (consulta.getChdispoaplic() != null && 
                !consulta.getChdispoaplic().isEmpty()) {

                Chdispoaplic dispositivo = null;
                Iterator it = consulta.getChdispoaplic().iterator();
                if (it.hasNext()) {
                    dispositivo = (Chdispoaplic)it.next();
                }

                if (dispositivo != null) {


                    DESCRIPCION_PROCEDIMIENTO_PF = 
                            dispositivo.getHdacdescrproce();

                    if (dispositivo.getHdanambitproce() != null) {
                        if (dispositivo.getHdanambitproce().equals(1)) {
                            AMBITO_PF = "Ambulatorio";
                        }
                        if (dispositivo.getHdanambitproce().equals(2)) {
                            AMBITO_PF = "Hospitalario";
                        }
                        if (dispositivo.getHdanambitproce().equals(3)) {
                            AMBITO_PF = "En Urgencia";
                        }
                    }

                    Integer idFinal = null;
                    idFinal = dispositivo.getHdanfinalidad();
                    Crfinalcon finalidadObject = null;
                    try {
                        finalidadObject = 
                                serviceLocator.getClinicoService().getFinalidadPorId(idFinal, 
                                                                                     "P");
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (finalidadObject != null) {
                        FINALIDAD_PF = 
                                formatearCampo(finalidadObject.getCfccdescri());

                    }

                    Crdgncie10 diagprevio = null;
                    Crdgncie10 diagposter = null;
                    Crdgncie10 diagcompli = null;


                    try {
                        if (dispositivo.getHdacdiagposter() != null) {
                            diagposter = 
                                    this.serviceLocator.getClinicoService().getCIE10PorCodigo(dispositivo.getHdacdiagposter().toUpperCase());
                        }

                    } catch (ModelException e) {
                        e.printStackTrace();
                    }


                    if (diagposter != null && 
                        dispositivo.getHdacdiagposter() != null) {
                        DIAGNOSTICO_POSTERIOR_PF = 
                                dispositivo.getHdacdiagposter().toUpperCase() + 
                                " " + diagposter.getCdccdescri();
                    }


                    try {
                        if (dispositivo.getHdacdiagcompli() != null) {
                            diagcompli = 
                                    this.serviceLocator.getClinicoService().getCIE10PorCodigo(dispositivo.getHdacdiagcompli().toUpperCase());
                        }

                    } catch (ModelException e) {
                        e.printStackTrace();
                    }


                    if (diagcompli != null && 
                        dispositivo.getHdacdiagcompli() != null) {
                        DIAGNOSTICO_COMPLICACION_PF = 
                                dispositivo.getHdacdiagcompli().toUpperCase() + 
                                " " + diagcompli.getCdccdescri();
                    }


                    DESCRIPCION_PROCEDIMIENTO_PF = 
                            formatearCampo(dispositivo.getHdacdescrproce());

                    if (dispositivo.getHdacdiagcompli() != null && 
                        !dispositivo.getHdacdiagcompli().equals("")) {
                        TIENE_COMPLICACIONES_PF = "SI";
                    } else {
                        TIENE_COMPLICACIONES_PF = "NO";
                    }

                    DESCRIPCION_COMPLICACION_PF = 
                            formatearCampo(dispositivo.getHdacdescrcompl());
                    REALIZACION_PROCEDIMIENTO_PF = "";
                    if (dispositivo.getHdanrealizacio() != null) {
                        try {
                            REALIZACION_PROCEDIMIENTO_PF = 
                                    this.serviceLocator.getClinicoService().getDescripcionActoQuirurgico(dispositivo.getHdanrealizacio());
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }
                    }
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
                    PRESION_ARTERIAL = 
                            formatearCampo(examen.getHefcpresart1()) + "/" + 
                            formatearCampo(examen.getHefcpresart2()) + 
                            " mm Hg";
                    FRECUENCIA_CARDIACA = 
                            formatearCampo(examen.getHefnfreccard()) + 
                            " l.p.m.";
                    FRECUENCIA_RESPIRATORIA = 
                            formatearCampo(examen.getHefnfrecresp()) + 
                            " r.p.m";
                    TALLA = formatearCampo(examen.getHefatalla()) + " mts";
                    PESO = formatearCampo(examen.getHefapeso()) + " kg";

                    HALLAZGOS_EXAMEN_FISICO = examen.getHefthallazgo();
                    if (examen.getHefelugartemp() != null) {
                        if (examen.getHefelugartemp().equals("A")) {
                            LUGAR_TEMPERATURA = "Axilar";
                        } else if (examen.getHefelugartemp().equals("B")) {
                            LUGAR_TEMPERATURA = "Bucal";
                        }
                    }
                    if(examen != null && examen.getHefatemperatu() != null){
                        TEMPERATURA = 
                                formatearCampo(examen.getHefatemperatu()) + 
                                " NC";
                    }
                   
                    
                    if (examen.getHefetipotemper() != null) {
                        if (examen.getHefetipotemper().equals("A")) {
                            TIPO_TEMPERATURA = "Afebril";
                            TEMPERATURA = formatearCampo(examen.getHefatemperatu()) + 
                                    " NC";

                        } else if (examen.getHefetipotemper().equals("F")) {
                            TIPO_TEMPERATURA = "Febril";
                            TEMPERATURA = 
                                    formatearCampo(examen.getHefatemperatu()) + 
                                    " NC";
                        }


                    }
                    
                    if (examen.getHefcconfiembar() != null && 
                        !examen.getHefcconfiembar().equals("")) {
                        CONFIRMA_EMBARAZO = examen.getHefcconfiembar();
                        }
                }


            }


            if (consulta.getChexafisane() != null && 
                !consulta.getChexafisane().isEmpty()) {

                Chexafisane examen = null;
                Iterator it = consulta.getChexafisane().iterator();
                if (it.hasNext()) {
                    examen = (Chexafisane)it.next();
                }

                if (examen != null) {


                    APERTURA_ORAL_PREANESTESIA = 
                            examen.getHeanapertoral() + " cm";

                    DISTANCIA_MENTOTIROIDEA = 
                            formatearCampo(examen.getHeandistametri()) + " cm";

                    MOVILIDAD_MANDIBULA = "";

                    if (examen.getHeacmovilanter() != null && 
                        !examen.getHeacmovilanter().equals("")) {
                        if (examen.getHeacmovilanter().equals("A")) {
                            MOVILIDAD_MANDIBULA = 
                                    "Dientes inferiores pasan mNs adelante que los dientes superiores";
                        } else if (examen.getHeacmovilanter().equals("B")) {
                            MOVILIDAD_MANDIBULA = 
                                    "Dientes superiores e inferiores se encuentran a la misma altura";
                        } else if (examen.getHeacmovilanter().equals("C")) {
                            MOVILIDAD_MANDIBULA = 
                                    "Los dientes inferiores no pasan los superiores";
                        }
                    }

                    MOVILIDAD_ATLANTO_OCCIPITAL = "";

                    if (examen.getHeacmovilatlan() != null && 
                        !examen.getHeacmovilatlan().equals("")) {
                        if (examen.getHeacmovilatlan().equals("1")) {
                            MOVILIDAD_ATLANTO_OCCIPITAL = 
                                    "Normal. Dedo Nndice izquierdo mNs alto que el derecho";
                        } else if (examen.getHeacmovilatlan().equals("2")) {
                            MOVILIDAD_ATLANTO_OCCIPITAL = 
                                    "LimitaciNn. Dedos a la misma altura";
                        } else if (examen.getHeacmovilatlan().equals("3")) {
                            MOVILIDAD_ATLANTO_OCCIPITAL = 
                                    "Severa limitaciNn. Izquierdo mNs bajo que derecho";
                        }
                    }

                    EVALUACION_GLOBAL_VIA_AEREA = "";

                    if (examen.getHeacevalugloba() != null && 
                        !examen.getHeacevalugloba().equals("")) {
                        if (examen.getHeacevalugloba().equals("F")) {
                            EVALUACION_GLOBAL_VIA_AEREA = "FNcil";
                        }
                        if (examen.getHeacevalugloba().equals("D")) {
                            EVALUACION_GLOBAL_VIA_AEREA = "DifNcil";
                        }
                    }


                    PROTESIS_DENTAL = 
                            formatearCampo(examen.getHeactieneprote());
                    PROTESIS_INFERIOR = 
                            formatearCampo(examen.getHeactieneproin());
                    PROTESIS_SUPERIOR = 
                            formatearCampo(examen.getHeactieneprosu());
                    GRADO_PROTESIS_SUPERIOR = "";
                    GRADO_PROTESIS_INFERIOR = "";
                    MOVILIDAD_PROTESIS_INFERIOR = "";
                    MOVILIDAD_PROTESIS_SUPERIOR = "";

                    if (examen.getHeacgradoproin() != null && 
                        !examen.getHeacgradoproin().equals("")) {
                        if (examen.getHeacgradoproin().equals("P")) {
                            GRADO_PROTESIS_INFERIOR = "Parcial";
                        } else if (examen.getHeacgradoproin().equals("T")) {
                            GRADO_PROTESIS_INFERIOR = "Total";
                        }
                    }


                    if (examen.getHeacgradoprosu() != null && 
                        !examen.getHeacgradoprosu().equals("")) {
                        if (examen.getHeacgradoprosu().equals("P")) {
                            GRADO_PROTESIS_SUPERIOR = "Parcial";
                        } else if (examen.getHeacgradoprosu().equals("T")) {
                            GRADO_PROTESIS_SUPERIOR = "Total";
                        }
                    }


                    if (examen.getHeacmovilproin() != null && 
                        !examen.getHeacmovilproin().equals("")) {
                        if (examen.getHeacmovilproin().equals("M")) {
                            MOVILIDAD_PROTESIS_INFERIOR = "Movil";
                        } else if (examen.getHeacmovilproin().equals("F")) {
                            MOVILIDAD_PROTESIS_INFERIOR = "Fija";
                        }
                    }


                    if (examen.getHeacmovilprosu() != null && 
                        !examen.getHeacmovilprosu().equals("")) {
                        if (examen.getHeacmovilprosu().equals("M")) {
                            MOVILIDAD_PROTESIS_SUPERIOR = "Movil";
                        } else if (examen.getHeacmovilprosu().equals("F")) {
                            MOVILIDAD_PROTESIS_SUPERIOR = "Fija";
                        }
                    }


                    if (examen.getHeacmallampati() != null && 
                        !examen.getHeacmallampati().equals("")) {

                        if (examen.getHeacmallampati().equals("I")) {
                            MALLAMPATI_PREANESTESIA = "Grado I";
                        } else if (examen.getHeacmallampati().equals("II")) {
                            MALLAMPATI_PREANESTESIA = "Grado II";
                        } else if (examen.getHeacmallampati().equals("III")) {
                            MALLAMPATI_PREANESTESIA = "Grado III";
                        } else if (examen.getHeacmallampati().equals("IV")) {
                            MALLAMPATI_PREANESTESIA = "Grado IV";
                        }

                    }


                }


            }


            if (consulta.getChresulparac() != null && 
                !consulta.getChresulparac().isEmpty()) {

                Chresulparac resultado = null;
                Iterator it = consulta.getChresulparac().iterator();
                if (it.hasNext()) {
                    resultado = (Chresulparac)it.next();
                }

                if (resultado != null) {
                    HEMOGLOBINA_PREANESTESIA = 
                            formatearCampo(resultado.getHrpnhemoglobin());
                    HEMATOCRITO_PREANESTESIA = 
                            formatearCampo(resultado.getHrpnhematocrit());
                    LEUCOCITOS_PREANESTESIA = 
                            formatearCampo(resultado.getHrpnleucocitos());
                    PT_PREANESTESIA = formatearCampo(resultado.getHrpnpt());
                    INR_PREANESTESIA = formatearCampo(resultado.getHrpninr());
                    PTT_PREANESTESIA = formatearCampo(resultado.getHrpnptt());
                    PLAQUETAS_PREANESTESIA = 
                            formatearCampo(resultado.getHrpnplaquetas());
                    PARCIAL_ORINA_PREANESTESIA = 
                            formatearCampo(resultado.getHrpcparciorina());
                    GLICEMIA_PRE_PREANESTESIA = 
                            formatearCampo(resultado.getHrpnglicemipre());
                    GLICEMIA_POST_PREANESTESIA = 
                            formatearCampo(resultado.getHrpnglicemipos());
                    NITROGENO_PREANESTESIA = 
                            formatearCampo(resultado.getHrpnnitroureic());
                    CREATININA_PREANESTESIA = 
                            formatearCampo(resultado.getHrpnncreatinin());
                    ELECTROCARDIOGRAMA_PREANESTESIA = 
                            formatearCampo(resultado.getHrpcelectrocar());
                    RAYOS_X_PREANESTESIA = 
                            formatearCampo(resultado.getHrpcrayosxtora());
                    ECOGRAFIAS_PREANESTESIA = 
                            formatearCampo(resultado.getHrpcecografias());
                    OTROS_RESULTADOS_PREANESTESIA = 
                            formatearCampo(resultado.getHrpcotrosresul());
                }
            }


            if (consulta.getChremisilve() != null && 
                !consulta.getChremisilve().isEmpty()&&(CONFIRMA_EMBARAZO == null || "S".equals(CONFIRMA_EMBARAZO))) {
                Chremisilve remilve = null;
                TIPO_REMISION_ILVE = "";
                CUAL_REMISION_ILVE = "";
                CERTIFICACION_MEDICA_ILVE = "";
                ESCOGE_VOLUNTARIAMENTE = "";
                DESCRIPCION_ESCOGE_VOLUNTARIAMENTE ="";
                PSICOSOCIAL = "";
                DESCRIPCION_PSICOSOCIAL="";
                ANTECEDENTES_MEDICOS ="";
                DESCRIPCION_ANTECEDENTES_MEDICOS="";
                
                Iterator it = consulta.getChremisilve().iterator();
                if (it.hasNext())
                    remilve = (Chremisilve)it.next();
                if (remilve != null) {
                    if (remilve.getHrictiporemis() != null) {
                        if (remilve.getHrictiporemis().equals("FA"))
                            TIPO_REMISION_ILVE = "Aborto FarmacolNgico";
                        if (remilve.getHrictiporemis().equals("AG"))
                            TIPO_REMISION_ILVE = "Aborto por aspiraciNn Bajo anestesia general";
                        if (remilve.getHrictiporemis().equals("AB"))
                            TIPO_REMISION_ILVE = "Aborto por aspiraciNn bajo Bloqueo";
                        if (remilve.getHrictiporemis().equals("DE"))
                            TIPO_REMISION_ILVE = "Aborto por dilataciNn y evacuaciNn";
                        if (remilve.getHrictiporemis().equals("AF"))
                            TIPO_REMISION_ILVE = "InterrupciNn voluntaria del embarazo por asistolia fetal";
                    }
                    
                    CUAL_REMISION_ILVE = 
                            formatearCampo(remilve.getHricotroremis());
                    if (remilve.getHriccertimedic() == null) {        
                        CERTIFICACION_MEDICA_ILVE = "";
                    } else {
                        CERTIFICACION_MEDICA_ILVE = 
                            remilve.getHriccertimedic() + "\n";
                    }
                    if (remilve.getHricescogvolun() != null) {
                        if ("CG".equals(remilve.getHricescogvolun())) {
                            ESCOGE_VOLUNTARIAMENTE = "Continuar gestaciNn";
                        
                        }
                        
                        if ("AD".equals(remilve.getHricescogvolun())) {
                            ESCOGE_VOLUNTARIAMENTE = "AdopciNn";
                        
                        }
                        
                        if ("IV".equals(remilve.getHricescogvolun())) {
                            ESCOGE_VOLUNTARIAMENTE = "InterrupciNn voluntaria del embarazo";
                        
                        }
                        
                    }
                    
                    if (remilve.getHricdesinvoem() != null) {
                        DESCRIPCION_ESCOGE_VOLUNTARIAMENTE =remilve.getHricdesinvoem();
                    }
                    
                    if (remilve.getHricpsicosocial() != null) {
                        PSICOSOCIAL =remilve.getHricpsicosocial();
                    }
                    
                    if (remilve.getHricdescrpsico() != null) {
                        DESCRIPCION_PSICOSOCIAL =remilve.getHricdescrpsico();
                    }
                    
                    if (remilve.getHricantemedi() != null) {
                        ANTECEDENTES_MEDICOS =remilve.getHricantemedi();
                    }
                    
                    if (remilve.getHricdesantmed() != null) {
                        DESCRIPCION_ANTECEDENTES_MEDICOS =remilve.getHricdesantmed();
                    }
                    
                    
                    
                }
            }


            if (consulta.getChremisilve() != null && 
                !consulta.getChremisilve().isEmpty() && (CONFIRMA_EMBARAZO == null || "S".equals(CONFIRMA_EMBARAZO))) {
                Chremisilve remilve = null;
                Chreporte report = new Chreporte();
                String s = "";
                Iterator it = consulta.getChremisilve().iterator();
                if (it.hasNext())
                    remilve = (Chremisilve)it.next();
                if (remilve != null) {
                  String aceptaTecnica = "";
                  /*if (remilve.getHricaceptpacie().equals("S")) {
                      aceptaTecnica = "SI";
                  } else if (remilve.getHricaceptpacie().equals("N")) {
                      aceptaTecnica = "NO";
                  }
                  
                  report = new Chreporte();
                  report.setHrecdescripcio((new StringBuilder()).append("La paciente acepta tNcnica sugerida: ").append(aceptaTecnica).toString());
                  report.setHrectipodescri("Remision y Certificado IVE");
                  report.setHrencodigo(imp_remision_ilve);
                  report.setHrentipoimpres(Integer.valueOf(1));
                  report.setHrenconsulta(consulta.getHcolnumero());
                  report.setHredfecharegis(consulta.getHcodfecregistr());
                  lstReporte.add(report);
                  
                if(remilve.getHricaceptpacie().equals("S")){
                  */
                   if (ESCOGE_VOLUNTARIAMENTE != null && 
                       !ESCOGE_VOLUNTARIAMENTE.equals("")) {
                       report = new Chreporte();
                       report.setHrecdescripcio((new StringBuilder()).append("Paciente escoge voluntariamente: ").append(ESCOGE_VOLUNTARIAMENTE).toString());
                       if (DESCRIPCION_ESCOGE_VOLUNTARIAMENTE != null && 
                           !DESCRIPCION_ESCOGE_VOLUNTARIAMENTE.equals("")) {
                           report.setHrecdescripcio2((new StringBuilder()).append("DescripciNn: ").append(DESCRIPCION_ESCOGE_VOLUNTARIAMENTE).toString());
                       }else{
                           report.setHrecdescripcio2("");
                       }
                       report.setHrectipodescri("Remision y Certificado IVE");
                       report.setHrencodigo(imp_remision_ilve);
                       report.setHrentipoimpres(Integer.valueOf(2));
                       report.setHrenconsulta(consulta.getHcolnumero());
                       report.setHredfecharegis(consulta.getHcodfecregistr());
                       lstReporte.add(report);
                   }


                    if (remilve.getHriccausailve() != null) {
                        report = new Chreporte();
                        String causal = "";
                        if ("CS".equals(remilve.getHriccausailve())) {
                            causal = "Salud";
                        } else if ("VS".equals(remilve.getHriccausailve())) {
                            causal = "Violencia Sexual";
                        } else if ("MC".equals(remilve.getHriccausailve())) {
                            causal = "MalformaciNn Congenita";
                        }

                        report.setHrecdescripcio("Causal principal:" + causal);
                        report.setHrencodigo(imp_remision_ilve);
                        report.setHrectipodescri("RemisiNn y Certificado IVE");
                        report.setHrentipoimpres(Integer.valueOf(1));
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        lstReporte.add(report);

                    }
                    
                    

                                      if (remilve.getHriccausailve2() != null) {
                                          report = new Chreporte();
                                          String causal = "";
                                          if ("CS".equals(remilve.getHriccausailve2())) {
                                              causal = "Salud";
                                          } else if ("VS".equals(remilve.getHriccausailve2())) {
                                              causal = "Violencia Sexual";
                                          } else if ("MC".equals(remilve.getHriccausailve2())) {
                                              causal = "MalformaciNn Congenita";
                                          }

                                          report.setHrecdescripcio("Causal secundaria:" + causal);
                                          report.setHrencodigo(imp_remision_ilve);
                                          report.setHrectipodescri("RemisiNn y Certificado IVE");
                                          report.setHrentipoimpres(Integer.valueOf(1));
                                          report.setHrenconsulta(consulta.getHcolnumero());
                                          report.setHredfecharegis(consulta.getHcodfecregistr());
                                          lstReporte.add(report);

                                      }
                                      
                  if (remilve.getHriccausailve3() != null) {
                      report = new Chreporte();
                      String causal = "";
                      if ("CS".equals(remilve.getHriccausailve3())) {
                          causal = "Salud";
                      } else if ("VS".equals(remilve.getHriccausailve3())) {
                          causal = "Violencia Sexual";
                      } else if ("MC".equals(remilve.getHriccausailve3())) {
                          causal = "MalformaciNn Congenita";
                      }

                      report.setHrecdescripcio("Causal terciaria:" + causal);
                      report.setHrencodigo(imp_remision_ilve);
                      report.setHrectipodescri("RemisiNn y Certificado IVE");
                      report.setHrentipoimpres(Integer.valueOf(1));
                      report.setHrenconsulta(consulta.getHcolnumero());
                      report.setHredfecharegis(consulta.getHcodfecregistr());
                      lstReporte.add(report);

                  }


                    
                   if (PSICOSOCIAL != null && 
                       !PSICOSOCIAL.equals("")) {
                       report = new Chreporte();
                       report.setHrecdescripcio((new StringBuilder()).append("Hallazgo Psicosocial: ").append(formatearCampo(PSICOSOCIAL)).toString());
                       if (DESCRIPCION_PSICOSOCIAL != null && 
                           !DESCRIPCION_PSICOSOCIAL.equals("")) {
                           report.setHrecdescripcio2((new StringBuilder()).append("DescripciNn: ").append(DESCRIPCION_PSICOSOCIAL).toString());
                       }else{
                           report.setHrecdescripcio2("");
                       }
                       report.setHrectipodescri("Remision y Certificado IVE");
                       report.setHrencodigo(imp_remision_ilve);
                       report.setHrentipoimpres(Integer.valueOf(2));
                       report.setHrenconsulta(consulta.getHcolnumero());
                       report.setHredfecharegis(consulta.getHcodfecregistr());
                       lstReporte.add(report);
                   }
                   
                   
                  if (ANTECEDENTES_MEDICOS != null && 
                      !ANTECEDENTES_MEDICOS.equals("")) {
                      report = new Chreporte();
                      report.setHrecdescripcio((new StringBuilder()).append("Hallazgo Antecedentes Medicos: ").append(formatearCampo(ANTECEDENTES_MEDICOS)).toString());
                      if (DESCRIPCION_ANTECEDENTES_MEDICOS != null && 
                          !DESCRIPCION_ANTECEDENTES_MEDICOS.equals("")) {
                          report.setHrecdescripcio2((new StringBuilder()).append("DescripciNn: ").append(DESCRIPCION_ANTECEDENTES_MEDICOS).toString());
                      }else{
                          report.setHrecdescripcio2("");
                      }
                      report.setHrectipodescri("Remision y Certificado IVE");
                      report.setHrencodigo(imp_remision_ilve);
                      report.setHrentipoimpres(Integer.valueOf(2));
                      report.setHrenconsulta(consulta.getHcolnumero());
                      report.setHredfecharegis(consulta.getHcodfecregistr());
                      lstReporte.add(report);
                  }
                  
                    s = 
  (new StringBuilder()).append("Tipo de Conducta:  ").append(TIPO_REMISION_ILVE).toString();
                    report = new Chreporte();
                    report.setHrecdescripcio(s);
                    if (CUAL_REMISION_ILVE != null && 
                        !CUAL_REMISION_ILVE.equals(""))
                        report.setHrecdescripcio2((new StringBuilder()).append("Cual:  ").append(CUAL_REMISION_ILVE).toString());
                    else
                        report.setHrecdescripcio2(null);
                    report.setHrencodigo(imp_remision_ilve);
                    report.setHrectipodescri("RemisiNn y Certificado IVE");
                    report.setHrentipoimpres(Integer.valueOf(2));
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);
                    
                    
                    if (CERTIFICACION_MEDICA_ILVE != null && 
                        !CERTIFICACION_MEDICA_ILVE.equals("")) {
                        report = new Chreporte();
                        report.setHrecdescripcio((new StringBuilder()).append("Certificacion Medica: ").append(CERTIFICACION_MEDICA_ILVE).toString());
                        report.setHrectipodescri("Remision y Certificado IVE");
                        report.setHrencodigo(imp_remision_ilve);
                        report.setHrentipoimpres(Integer.valueOf(1));
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        lstReporte.add(report);
                    }

                    
                  if (remilve.getHricdeseaplan() != null && 
                      !remilve.getHricdeseaplan().equals("")) {
                      String deseaPlanificar = "";
                      if (remilve.getHricdeseaplan().equals("S")) {
                          deseaPlanificar = "SI";
                      } else if (remilve.getHricdeseaplan().equals("N")) {
                          deseaPlanificar = "NO";
                          INICIA_METODO_HOY = "N";
                      }
                      report = new Chreporte();
                      report.setHrecdescripcio((new StringBuilder()).append("Desea Planificar: ").append(deseaPlanificar).toString());
                      report.setHrectipodescri("Remision y Certificado IVE");
                      report.setHrencodigo(imp_remision_ilve);
                      report.setHrentipoimpres(Integer.valueOf(2));
                      report.setHrenconsulta(consulta.getHcolnumero());
                      report.setHredfecharegis(consulta.getHcodfecregistr());
                      lstReporte.add(report);
                  }
                  
                  if (remilve.getHricobserplan()!= null && 
                      !remilve.getHricobserplan().equals("")) {
                      String observacion = "";
                    
                      if (remilve.getHricdeseaplan().equals("N")) {
                          observacion = remilve.getHricobserplan();
                          report = new Chreporte();
                          report.setHrecdescripcio((new StringBuilder()).append("Aclaracion:  ").append(observacion).toString());
                          report.setHrectipodescri("Remision y Certificado IVE");
                          report.setHrencodigo(imp_remision_ilve);
                          report.setHrentipoimpres(Integer.valueOf(2));
                          report.setHrenconsulta(consulta.getHcolnumero());
                          report.setHredfecharegis(consulta.getHcodfecregistr());
                          lstReporte.add(report);
                      }
                     
                  }
                  
                    
                    if (remilve.getHricdeseaplan() != null && remilve.getHricdeseaplan().equals("S")){
                    report = new Chreporte();
                    report.setHrecdescripcio("");
                    report.setHrecdescripcio((new StringBuilder()).append("MNtodo de PlanificaciNn: ").append(obtenerMetodoPlanificacion(remilve.getHricmetodplani())).toString());
                    report.setHrectipodescri("Remision y Certificado IVE");
                    if (remilve.getHricotrometod() != null && 
                        !remilve.getHricotrometod().equals("")) {
                        report.setHrecdescripcio2(remilve.getHricotrometod());
                    } else if (remilve.getHricmotivrecha() != null && "N".equals(remilve.getHricmotivrecha())) {
                        report.setHrecdescripcio2("Por quN? " + 
                                                  obtenerMotivoRechazoIlve(remilve.getHricmotivrecha()));
                    } else {
                        report.setHrecdescripcio2("");
                    }
                    report.setHrencodigo(imp_remision_ilve);
                    report.setHrentipoimpres(Integer.valueOf(3));
                    report.setHrenconsulta(consulta.getHcolnumero());
                    report.setHredfecharegis(consulta.getHcodfecregistr());
                    lstReporte.add(report);

                    if (remilve.getHricsumiprofa() != null && 
                        !remilve.getHricsumiprofa().equals("")) {
                        String suministraProfamilia = "";
                        if (remilve.getHricsumiprofa().equals("S")) {
                            suministraProfamilia = "SI";
                        } else if (remilve.getHricsumiprofa().equals("N")) {
                            suministraProfamilia = "NO";
                        }
                        report = new Chreporte();
                        report.setHrecdescripcio((new StringBuilder()).append("SerN suministrado por Profamilia?: ").append(suministraProfamilia).toString());
                        report.setHrectipodescri("Remision y Certificado IVE");
                        if (remilve.getHricsumiprofno() != null && 
                            !remilve.getHricsumiprofno().equals("") && remilve.getHricsumiprofa().equals("N")) {
                            String noSuministra = "";
                            INICIA_METODO_HOY = "N";
                            if (remilve.getHricsumiprofno().equals("SE")) {
                                noSuministra = "Lo solicitarN en su EPS";
                            } else if (remilve.getHricsumiprofno().equals("ND")) {
                                noSuministra = "Marca comercial no disponible";
                            } else if (remilve.getHricsumiprofno().equals("OT")) {
                                noSuministra = "Otro";
                            }
                            report.setHrecdescripcio2((new StringBuilder()).append("Por quN? ").append(noSuministra).toString());
                        }else{
                                if (remilve.getHricinicimetod() != null) {
                                    if (remilve.getHricinicimetod().equals("S")) {
                                        INICIA_METODO_HOY = "SI";
                                    } else if (remilve.getHricinicimetod().equals("N")) {
                                        INICIA_METODO_HOY = "NO";
                                    }
                                    report.setHrecdescripcio2((new StringBuilder()).append("NInicia mNtodo de planificaciNn hoy? ").append(INICIA_METODO_HOY).toString());
                                } else {
                                    report.setHrecdescripcio2("");
                                }
                        }
                        if (remilve.getHricsumiotro() != null && 
                            !remilve.getHricsumiotro().equals("")) {
                            report.setHrecdescripcio3((new StringBuilder()).append("Cual ").append(remilve.getHricsumiotro()).toString());
                        }
                        report.setHrencodigo(imp_remision_ilve);
                        report.setHrentipoimpres(Integer.valueOf(4));
                        report.setHrenconsulta(consulta.getHcolnumero());
                        report.setHredfecharegis(consulta.getHcodfecregistr());
                        lstReporte.add(report);
                    }
                  }
                /*}*/
              }
            }

            if (consulta.getChimprdiags() != null && 
                !consulta.getChimprdiags().isEmpty()) {
                Crdgncie10 diagprin = null;
                Crdgncie10 diagrela1 = null;
                Crdgncie10 diagrela2 = null;
                Crdgncie10 diagrela3 = null;
                Chimprdiag impresion = null;

                TIPO_DIAGNOSTICO = "";
                RECOMENDACIONES_IMPRESION = "";
                DIAGNOSTICO_PRINCIPAL = "";
                DIAGNOSTICO_RELACIONADO1 = "";
                DIAGNOSTICO_RELACIONADO2 = "";
                DIAGNOSTICO_RELACIONADO3 = "";
                GRADO_EXAMEN_ASA = null;
                IMPRESION_DIAG_COLPOS="";
                OTRO_DIAG_COLPOS = "";


                Iterator it = consulta.getChimprdiags().iterator();
                if (it.hasNext()) {
                    impresion = (Chimprdiag)it.next();
                }

                if (impresion != null) {
                
                    if(impresion.getHidngradoasa() != null){
                        GRADO_EXAMEN_ASA = impresion.getHidngradoasa();
                    }

                    if (impresion.getHidntipodiagn() != null) {

                        if (impresion.getHidntipodiagn() != null && 
                            impresion.getHidntipodiagn().equals(1)) {
                            TIPO_DIAGNOSTICO = "ImpresiNn Diagnostica";
                        } else if (impresion.getHidntipodiagn() != null && 
                                   impresion.getHidntipodiagn().equals(2)) {
                            TIPO_DIAGNOSTICO = "Confirmado Nuevo";
                        } else if (impresion.getHidntipodiagn() != null && 
                                   impresion.getHidntipodiagn().equals(3)) {
                            TIPO_DIAGNOSTICO = "Confirmado repetido";
                        }

                    }

                    if (impresion.getHidtrecomen() != null) {
                        RECOMENDACIONES_IMPRESION = impresion.getHidtrecomen();
                    }

                    try {
                        if (impresion.getHidcdiagprin() != null) {
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
                    
                    

                    try {
                        if (impresion.getHidcdiagrela1() != null) {
                            diagrela1 = 
                                    this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagrela1().toUpperCase());
                        }

                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    if (diagrela1 != null && 
                        impresion.getHidcdiagrela1() != null) {
                        DIAGNOSTICO_RELACIONADO1 = 
                                impresion.getHidcdiagrela1().toUpperCase() + 
                                " " + diagrela1.getCdccdescri();
                    }

                    try {
                        if (impresion.getHidcdiagrela2() != null) {
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
                        if (impresion.getHidcdiagrela3() != null) {
                            diagrela3 = 
                                    this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagrela3().toUpperCase());
                        }

                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    if (diagrela3 != null && 
                        impresion.getHidcdiagrela3() != null) {
                        DIAGNOSTICO_RELACIONADO3 = 
                                impresion.getHidcdiagrela3().toUpperCase() + 
                                " " + diagrela3.getCdccdescri();
                    }

                    if (impresion.getHidnsemanembar() != null) {
                        SEMANAS_EMBARAZO = impresion.getHidnsemanembar();
                    }


                    if (impresion.getHidnsemanameno() != null) {
                        SEMANAS_EMBARAZO_GESTACIONAL = 
                                impresion.getHidnsemanameno();
                    }

                    if (impresion.getHidcconfiseman() != null && 
                        !impresion.getHidcconfiseman().equals("")) {
                        CONFIRMA_SEMANAS_EMBARAZO = 
                                formatearCampo(impresion.getHidcconfiseman());
                    }
                    
                    
                    
                    if (impresion.getHidcimprenorma() != null &&  impresion.getHidcimprenorma().equals("S")) {
                        IMPRESION_DIAG_COLPOS = IMPRESION_DIAG_COLPOS +" Normal - ";
                    }

                    if (impresion.getHidcimpresuges() != null &&  impresion.getHidcimpresuges().equals("S")) {
                        IMPRESION_DIAG_COLPOS = IMPRESION_DIAG_COLPOS +" Sugestiva de VPH - ";

                    }

                    if (impresion.getHidcimpreinfla() != null &&  impresion.getHidcimpreinfla().equals("S")) {
                        IMPRESION_DIAG_COLPOS = IMPRESION_DIAG_COLPOS +" Inflamatoria - ";
                    }

                    if (impresion.getHidcimpreleyba() != null &&  impresion.getHidcimpreleyba().equals("S")) {
                        IMPRESION_DIAG_COLPOS = IMPRESION_DIAG_COLPOS +" LEI de bajo grado - ";
                    }


                    if (impresion.getHidcimpreatrof() != null &&  impresion.getHidcimpreatrof().equals("S")) {
                        IMPRESION_DIAG_COLPOS = IMPRESION_DIAG_COLPOS +" AtrNfica - ";
                    }


                    if (impresion.getHidcimpreleyal() != null &&  impresion.getHidcimpreleyal().equals("S")) {
                        IMPRESION_DIAG_COLPOS = IMPRESION_DIAG_COLPOS +" LEI de alto grado - ";
                    }

                    if (impresion.getHidcimprecarci() != null &&  impresion.getHidcimprecarci().equals("S")) {
                        IMPRESION_DIAG_COLPOS = IMPRESION_DIAG_COLPOS +" Carcinoma invasivo - ";
                    }


                    if (impresion.getHidcimpreotro() != null &&  impresion.getHidcimpreotro().equals("S")) {
                        IMPRESION_DIAG_COLPOS = IMPRESION_DIAG_COLPOS +" Otros - ";
                        OTRO_DIAG_COLPOS = impresion.getHidcimprecual();
                        
                    }
                }
            }


            if (consulta.getChinfomamogrs() != null && 
                !consulta.getChinfomamogrs().isEmpty()) {

                Chinfomamogr informe = null;
                Iterator it = consulta.getChinfomamogrs().iterator();
                if (it.hasNext()) {
                    informe = (Chinfomamogr)it.next();
                }


                if (informe != null) {
                    INDICACION_EXAMEN_ECOGRAFIA = 
                            formatearCampo(informe.getHimcdatosclire());
                    TRASNDUCTOR_UTILIZADO_ECOGRAFIA = 
                            formatearCampo(informe.getHimctransducto());
                    INFORME_ECOGRAFIA = 
                            formatearCampo(informe.getHimcinformamog());
                    CONCLUSION_ECOGRAFIA = 
                            formatearCampo(informe.getHimcopinion());

                    GESTACIONES_ECOGRAFIA = informe.getHimnnumgesta();
                    PARTOS_ECOGRAFIA = informe.getHimnnumparto();
                    ABORTOS_ECOGRAFIA = informe.getHimnnumaborto();
                    CESAREAS_ECOGRAFIA = informe.getHimnnumcesare();
                    HIJOS_ECTOPICOS_ECOGRAFIA = informe.getHimnectopico();
                    EDAD_GESTACIONAL_MENSTRUAL = informe.getHimnedadgesmes();
                    DIAS_EDAD_GESTACIONAL = informe.getHimndiasgestac();
                    FUR_ECOGRAFIA = informe.getHimdfur();

                    NUMERO_MAMOGRAFIA = 
                            formatearCampo(informe.getHimnnumero());
                    MEDICO_REMITE = 
                            formatearCampo(informe.getHimcmedicoremi());
                    DATOS_CLINICOS_RELEVANTES = 
                            formatearCampo(informe.getHimcdatosclire());
                    INFORME_MAMOGRAFICO = 
                            formatearCampo(informe.getHimcinformamog());
                    DOSIS_SUPERFICIE = 
                            formatearCampo(informe.getHimndosisentra());
                    INFORME_COMO_TAL_MAMOGRAFIA = 
                            formatearCampo(informe.getHimcinformetal());
                    OPINION_MAMOGRAFIA = 
                            formatearCampo(informe.getHimcopinion());

                    if (informe.getHimctipobirads() != null) {
                        if (informe.getHimctipobirads().equals("0")) {
                            TIPO_BIRADS = "Estudio incompleto.";
                        }
                        if (informe.getHimctipobirads().equals("1")) {
                            TIPO_BIRADS = "Negativa";
                        }
                        if (informe.getHimctipobirads().equals("2")) {
                            TIPO_BIRADS = "Negativa con hallazgos benignos";
                        }
                        if (informe.getHimctipobirads().equals("3")) {
                            TIPO_BIRADS = "Hallazgo probablemente benigno";
                        }
                        if (informe.getHimctipobirads().equals("4")) {
                            TIPO_BIRADS = "Hallazgo sospechoso";
                        }
                        if (informe.getHimctipobirads().equals("5")) {
                            TIPO_BIRADS = "Alta probabilidad de malignidad";
                        }
                    }

                    RECOMENDACIONES_MAMOGRAFIA = 
                            formatearCampo(informe.getHimcrecomendac());

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


            }

            if (consulta.getChconductas() != null && 
                !consulta.getChconductas().isEmpty()) {
                Chconducta conducta = null;
                Iterator it = consulta.getChconductas().iterator();
                if (it.hasNext()) {
                    conducta = (Chconducta)it.next();
                }
                if (conducta != null) {
                    RECOMENDACIONES_CONDUCTA = conducta.getHcncobservacio();
                }


            }
            if (consulta.getChconductas() != null && 
                !consulta.getChconductas().isEmpty()) {
                Chconducta conducta = null;
                Iterator it = consulta.getChconductas().iterator();
                if (it.hasNext()) {
                    conducta = (Chconducta)it.next();
                }
                if (conducta != null) {
                    RECOMENDACIONES_PLANMANEJO = conducta.getHcncplanmanejo();
                }


            }


            if (consulta.getChordecirugis() != null && 
                !consulta.getChordecirugis().isEmpty()) {
                Chordecirugi ordenCirugia = null;
                Iterator it = consulta.getChordecirugis().iterator();
                if (it.hasNext()) {
                    ordenCirugia = (Chordecirugi)it.next();
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
                            ESTANCIA = "HospitalizaciNn";
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
                                    "Biopsa por CongelaciNn: " + formatearCampo(ordenCirugia.getHoccbiopsacong());

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
                }


            }


            if (consulta.getChexameparacs() != null && 
                !consulta.getChexameparacs().isEmpty()) {
                FISIOLOGICOS = "";
                IMAGENES = "";
                LABORATORIOS = "";


                Iterator it = (consulta.getChexameparacs()).iterator();
                while (it.hasNext()) {

                    Chexameparac examenParaclinico = (Chexameparac)it.next();

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
                }
            }

            if (consulta.getChreferencias() != null && 
                !consulta.getChreferencias().isEmpty()) {

                Chreferencia referencia = null;
                Iterator it = consulta.getChreferencias().iterator();
                if (it.hasNext()) {
                    referencia = (Chreferencia)it.next();
                }

                if (referencia != null) {
                    TIPO_SERVICIO = "";

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
                                TIPO_SERVICIO = TIPO_SERVICIO + "RemisiNn, ";
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
                    ANAMNESIS = formatearCampo(referencia.getHrecanamnesis());
                    APOYO_DIAGNOSTICO = 
                            formatearCampo(referencia.getHrecapoyodiagn());
                    JUSTIFICACION_REFERENCIA = 
                            formatearCampo(referencia.getHrecjustirefer());
                }


            }

            if (consulta.getChanatopatols() != null && 
                !consulta.getChanatopatols().isEmpty()) {

                Chanatopatol anatomia = null;
                Iterator it = consulta.getChanatopatols().iterator();
                if (it.hasNext()) {
                    anatomia = (Chanatopatol)it.next();
                }

                if (anatomia != null) {
                    ORIGEN_PIEZA = 
                            formatearCampo(anatomia.getHapcorigepieza());
                }


            }

            /*
          if (control != null) {
              Date fechaAux = control.getHcpdfechprocon();
              Calendar calendar = Calendar.getInstance();
              calendar.setTime(fechaAux);
              FECHA_PROXIMO_CONTROL = formatearCampo(fechaAux);


              String hora = String.valueOf(calendar.get(Calendar.HOUR));
              String minuto = String.valueOf(calendar.get(Calendar.MINUTE));
              if (calendar.get(Calendar.HOUR) < 10) {
                  hora = "0" + hora;
              }
              if (calendar.get(Calendar.MINUTE) < 10) {
                  minuto = "0" + minuto;
              }

              HORA_PROXIMO_CONTROL = hora + ":" + minuto;
          }*/


            if (consulta.getChnotamedicas() != null && 
                !consulta.getChnotamedicas().isEmpty()) {

                Iterator it = consulta.getChnotamedicas().iterator();
                NOTA_ACLARATORIA = "";

                while (it.hasNext()) {
                    Chnotamedica nota = (Chnotamedica)it.next();
                    String usuario_nota = "";
                    usuario_nota = 
                            formatearCampoNombreUsuario(nota.getHnmcoperador(), 
                                                        consulta.getHconclinica());

                    NOTA_ACLARATORIA = 
                            NOTA_ACLARATORIA + "Usuario que realiza la nota: " + 
                            usuario_nota + "\n" + 
                            "Fecha de la Nota Aclaratoria: " + 
                            formatearCampo(nota.getHnmdfecregistr()) + "\n" + 
                            "" + nota.getHnmcdescripc() + "\n";
                }
            }


            if (consulta.getChevoluconsu() != null && 
                !consulta.getChevoluconsu().isEmpty()) {

                Iterator it = consulta.getChevoluconsu().iterator();
                EVOLUCION = "";

                while (it.hasNext()) {
                    Chevoluconsu evolucion = (Chevoluconsu)it.next();

                    EVOLUCION = 
                            EVOLUCION + "Fecha de la EvoluciNn: " + formatearCampo(evolucion.getHecdfecregistr()) + 
                            "\n" + " Usuario Registro: " + 
                            obtenerUsuario(evolucion.getHeccoperador()) + 
                            "\n" + "" + evolucion.getHeccdescripc() + "\n";
                }
            }
            //Antecedente Colposcopia
            if (consulta.getChantecolpo() != null && 
                !consulta.getChantecolpo().isEmpty()) {

                Chantegineco antecedente = null;
                Iterator it = consulta.getChanteginecos().iterator();
                if (it.hasNext()) {
                    antecedente = (Chantegineco)it.next();
                }

                if (antecedente != null) {
                    String tipoCiclo = "";
                    String ultimaCitologia = "";
                    GESTACIONES = antecedente.getHagnnumgesta();
                    PARTOS = antecedente.getHagnnumparto();
                    ABORTOS = antecedente.getHagnnumaborto();
                    CESAREAS = antecedente.getHagnnumcesare();
                    HIJOS_VIVOS = antecedente.getHagnnumvivo();
                    HIJOS_ECTOPICOS = antecedente.getHagnectopico();
                    HIJOS_MUERTOS = antecedente.getHagnmuerto();
                    MORTINATOS = antecedente.getHagnmortina();
                    HIJOS_NACIDOS_VIVOS = antecedente.getHagnnacivivo();
                    tipoCiclo = antecedente.getHagetipciclo();
                    ultimaCitologia = antecedente.getHagcultcitolo();
                    if (tipoCiclo != null) {
                        if (tipoCiclo.equals("I")) {
                            TIPO_CICLO = "Irregular";
                        } else if (tipoCiclo.equals("R")) {
                            TIPO_CICLO = "Regular";
                        } else if (tipoCiclo.equals("N")) {
                            TIPO_CICLO = "No ha Tenido Menarquia";
                        } else if (tipoCiclo.equals("A")) {
                            TIPO_CICLO = "Amenorrea";
                        }

                    }

                    if (ultimaCitologia != null) {
                        if (ultimaCitologia.equals("NO")) {
                            ULTIMA_CITOLOGIA = "Nunca";
                        } else if (ultimaCitologia.equals("-1")) {
                            ULTIMA_CITOLOGIA = "Hace menos de un aNo";
                        } else if (ultimaCitologia.equals("+1")) {
                            ULTIMA_CITOLOGIA = "Hace mas de un aNo";
                        } else if (ultimaCitologia.equals("NR")) {
                            ULTIMA_CITOLOGIA = "No recuerda";
                        }
                    }
                    
                    if(tipoCiclo!= null && tipoCiclo.equals("I")){
                    
                        FRECUENCIA_CICLO = antecedente.getHagnfreciclo() + " - " + antecedente.getHagnfrefincicl()  ;
                        DURACION_CICLO = antecedente.getHagndurciclo() + " - " +  antecedente.getHagndurfincicl() ; 
                       
                    }else{
                        FRECUENCIA_CICLO = formatearCampo(antecedente.getHagnfreciclo());
                        DURACION_CICLO = formatearCampo(antecedente.getHagndurciclo());    
                    }

                    
                    MENARQUIA = antecedente.getHagnmenarquia();
                    EDAD_PRIMERA_RELACION = antecedente.getHagnedadrelac();
                    FUR = formatearCampo(antecedente.getHagdfur());
                    FUP = formatearCampo(antecedente.getHagdfup());
                    FUC = formatearCampo(antecedente.getHagdfuc());
                }

            }

            if (consulta.getChpsicoantec() != null && 
                !consulta.getChpsicoantec().isEmpty()) {
                Chpsicoantec psicoantec = null;
                
                PRESENTA_DISCAPACIDAD="";
                CUAL_DISCAPACIDAD="";
                TOMA_MEDICAMENTO="";
                CUAL_MEDICAMENT="";
                TRASTORNO_MENTAL="";
                CUAL_TRASTOR="";
                ENFERME_DIAG="";
                CUAL_ENFERDIAG="";
                VIDA_SEXACTIVA="";
                TIENE_RELASEXUALES="";
                HABITO_SALUDABLE="";
                CUALES_HABITOS="";
                INTENTO_QUITARSEVIDA="";
                MANERAS_QUITARSEVIDA="";
                TIPO_VIOLENCIA_SEXUAL="";
                TIPO_VIOLENCIA_FISICA="";
                TIPO_VIOLENCIA_ECONOMICA="";
                TIPO_VIOLENCIA_PSICOLOGICA="";
                SUSTANCIA_PSICOACTIVA="";
                CUAL_SUSTANCIA="";
                VICTIMA_CONFARMADO="";
                EDAD_HABLO="";
                EDAD_GATEO="";
                EDAD_CAMINO="";
                HORAS_DUERME="";
                DIFICULTAD_APRENDE="";
                CUALES_DISFICULTAD="";
                SOCIALIZA="";
                OBSERVACIONES_SOCIALIZA="";
                RUTINA="";
                CUAL_RUTINA="";
                TEMPERAMENTO="";
                OBSE_TEMPERAMENTO="";
                

                Iterator it = consulta.getChpsicoantec().iterator();
                if (it.hasNext()) {
                    psicoantec = (Chpsicoantec)it.next();
                }

                if (psicoantec != null) {
                if(null!=psicoantec.getHpacpresedisca()){
                    PRESENTA_DISCAPACIDAD= formatearCampo(psicoantec.getHpacpresedisca());
                    }
                    if(null!=psicoantec.getHpaccualdisca()){
                
                    CUAL_DISCAPACIDAD= psicoantec.getHpaccualdisca();
                    }
                    if(null!=psicoantec.getHpactomamedi()){
                    TOMA_MEDICAMENTO= formatearCampo(psicoantec.getHpactomamedi());
                    }
                    if(null!=psicoantec.getHpaccualmedi()){
                    CUAL_MEDICAMENT= psicoantec.getHpaccualmedi();
                    }
                    if(null!=psicoantec.getHpactrastmenta()){
                    TRASTORNO_MENTAL= formatearCampo(psicoantec.getHpactrastmenta());
                    }
                    if(null!=psicoantec.getHpaccualtrast()){
                    CUAL_TRASTOR=psicoantec.getHpaccualtrast();
                    }
                    if(null!=psicoantec.getHpacenfediag()){
                    ENFERME_DIAG= formatearCampo(psicoantec.getHpacenfediag());
                    }
                    if(null!=psicoantec.getHpaccualenfe()){
                    CUAL_ENFERDIAG= psicoantec.getHpaccualenfe();
                    }
                    if(null!=psicoantec.getHpacvidasexac()){
                    VIDA_SEXACTIVA= formatearCampo(psicoantec.getHpacvidasexac());
                    }
                    if(null!=psicoantec.getHpacrelacsatis()){
                    TIENE_RELASEXUALES= formatearCampo(psicoantec.getHpacrelacsatis());
                    }
                    if(null!=psicoantec.getHpachabitsalud()){
                    HABITO_SALUDABLE= formatearCampo(psicoantec.getHpachabitsalud());
                    }
                    if(null!=psicoantec.getHpaccualhabit()){
                    CUALES_HABITOS= psicoantec.getHpaccualhabit();
                    }
                    if(null!=psicoantec.getHpacquitavida()){
                    INTENTO_QUITARSEVIDA= formatearCampo(psicoantec.getHpacquitavida());
                    }
                    if(null!=psicoantec.getHpacmanequit()){
                    MANERAS_QUITARSEVIDA= psicoantec.getHpacmanequit();
                    }
                    if(null!=psicoantec.getHpacsustapsico()){
                    SUSTANCIA_PSICOACTIVA= formatearCampo(psicoantec.getHpacsustapsico());
                    }
                    if(null!=psicoantec.getHpaccualsusta()){
                    CUAL_SUSTANCIA= psicoantec.getHpaccualsusta();
                    }
                    if(null!=psicoantec.getHpacvicconfarm()){
                    VICTIMA_CONFARMADO= formatearCampo(psicoantec.getHpacvicconfarm());
                    }
                    if(null!=psicoantec.getHpanedadhabla()){
                    EDAD_HABLO= psicoantec.getHpanedadhabla().toString();
                    }
                    if(null!=psicoantec.getHpanedadgateo()){
                    EDAD_GATEO=psicoantec.getHpanedadgateo().toString();
                    }
                    if(null!=psicoantec.getHpanedadcamino()){
                    EDAD_CAMINO= psicoantec.getHpanedadcamino().toString();
                    }
                    if(null!=psicoantec.getHpanhorasduerm()){
                    HORAS_DUERME= psicoantec.getHpanhorasduerm().toString();
                    }
                    if(null!=psicoantec.getHpacdificapren()){
                    DIFICULTAD_APRENDE= formatearCampo(psicoantec.getHpacdificapren());
                    }
                    if(null!=psicoantec.getHpaccualdific()){
                    CUALES_DISFICULTAD= psicoantec.getHpaccualdific();
                    }
                    if(null!=psicoantec.getHpacsociapare()){
                    SOCIALIZA= formatearCampo(psicoantec.getHpacsociapare());
                    }
                    if(null!=psicoantec.getHpacobssoci()){
                    OBSERVACIONES_SOCIALIZA=psicoantec.getHpacobssoci();
                    }
                    if(null!=psicoantec.getHpacrutiesta()){
                    RUTINA= formatearCampo(psicoantec.getHpacrutiesta());
                    }
                    if(null!=psicoantec.getHpacualruti()){
                    CUAL_RUTINA=psicoantec.getHpacualruti();
                    }
                    if(null!=psicoantec.getHpactemppred()){
                    TEMPERAMENTO= formatearCampo(psicoantec.getHpactemppred());
                    }
                    if(null!=psicoantec.getHpacobstemp()){
                    OBSE_TEMPERAMENTO= psicoantec.getHpacobstemp();
                    }
                    if(null!=psicoantec.getHpacviolesexual()){
                    TIPO_VIOLENCIA_SEXUAL=psicoantec.getHpacviolesexual();
                    }
                if(null!=psicoantec.getHpacviolefisic()){
                    TIPO_VIOLENCIA_FISICA= psicoantec.getHpacviolefisic();
                    }
                    if(null!=psicoantec.getHpacvioleecono()){
                    TIPO_VIOLENCIA_ECONOMICA= psicoantec.getHpacvioleecono();
                    }
                    if(null!=psicoantec.getHpacviolepsico()){
                    TIPO_VIOLENCIA_PSICOLOGICA= psicoantec.getHpacviolepsico();
                    }

                }


            }

        }
        
        try {
            Cnconsclin consultaClinica = 
                getServiceLocator().getClinicoService().getConsultaClinicaPorId(consulta.getHcolnumero().toString());
            if (consultaClinica != null) {
                tipoHistoria = consultaClinica.getCcocservic().getCsvntiphis();
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }


        setDatos(consulta);
    }

    public void obtenerDatosReporteChpsicologia(Chconsulta consultaFolio, Chpapsicologico nota) throws ModelException {
        // Obtenemos los datos del usuario 
        resetDatosPsicologia();
        Cpclinica clinAux= new Cpclinica();

        int edadUsu = usuario.calcularEdad(usuario.getHusdfechanacim());
        clinAux = this.serviceLocator.getClinicoService().getClinica(consultaFolio.getHconclinica());
        String nombre1;
        String nombre2;
        String ape1;
        String ape2;
        FECHA = nota.getHppdfecreg();
       
        CLINICA = clinAux.getCclcnombre();
        
        
        if (usuario != null && usuario.getHuscprimernomb() != null) {
            nombre1 = (usuario.getHuscprimernomb() != null) ? usuario.getHuscprimernomb() : " ";
            nombre2 = (usuario.getHuscsegundnomb() != null) ? usuario.getHuscsegundnomb() : " ";
            ape1 = (usuario.getHuscprimerapel() != null) ? usuario.getHuscprimerapel() : " ";
            ape2 = (usuario.getHuscsegundapel() != null) ? usuario.getHuscsegundapel() : " ";
    
            NOMBRES = nombre1 +" "+nombre2+" "+ape1+" "+ape2;
                   
        }
        if (usuario != null && usuario.getHusetipoiden() != null) {
            IDENTIFICACION =  usuario.getHusetipoiden() + " " + usuario.getHusanumeiden();
        }
        if (usuario != null && usuario.getHuscnombralter() != null) {
            DESEOLLAMAR = usuario.getHuscnombralter();
        }
        if (usuario != null && usuario.getHusesexo() != null) {
        
            SEXO = formatearCampoSexo(usuario.getHusesexo());
        }
        
        if (usuario != null && usuario.getHuscidengene() != null) {
        
            GENERO = usuario.getHuscidengene();
        }
        if (usuario != null && usuario.getHusezonareside() != null) {
        
            ZONA =usuario.getHusezonareside();
        }
        
            EDAD = edadUsu;
        
        if (usuario != null && usuario.getHusdfechanacim() != null) {
            FECHANTO = usuario.getHusdfechanacim();
        }
        if (usuario != null && usuario.getHusnciudad() != null) {
        Cpmunidane n= new Cpmunidane();
        n= this.getServiceLocator().getClinicoService().getMunicipio(usuario.getHusnciudad(),usuario.getHusndepartamen());
            CIUDAD = n.getCmdcnomdpt();
        }
        if (usuario != null && usuario.getHuscdireccion() != null) {
            DIRECCION = usuario.getHuscdireccion();
        }
        if (usuario != null && usuario.getHusctelefono() != null) {
            TELEFONO = usuario.getHusctelefono();
        }
        if (usuario != null && usuario.getHusnocupacion() != null) {
            OCUPACION = this.getServiceLocator().getClinicoService().getDescripcionOcupacion(usuario.getHusnocupacion());
        }
        if (usuario != null && usuario.getHuseestadcivil() != null) {
            ESTADOCIVIL = formatearEstadoCivil(usuario.getHuseestadcivil());
        }
        if (usuario != null && usuario.getHuscnomresponsa() != null) {
            RESPONSABLE = usuario.getHuscnomresponsa();
        }
        if (usuario != null && usuario.getHusetipoafilia() != null) {
           
            if(usuario.getHusetipoafilia().equals("C")){
             AFILACION = "CONTRIBUTIVO";
            }
            if(usuario.getHusetipoafilia().equals("S")){
             AFILACION = "SUBSIDIADO";
            }
            if(usuario.getHusetipoafilia().equals("E")){
             AFILACION = "ESPECIAL";
            }
            if(usuario.getHusetipoafilia().equals("X")){
             AFILACION = "NINGUNO";
            }
            if(usuario.getHusetipoafilia().equals("R")){
             AFILACION = "SUBSIDIO PARCIAL";
            }
            if(usuario.getHusetipoafilia().equals("V")){
             AFILACION = "VINCULADO";
            }
        }
        if (usuario != null && usuario.getHuscentidadadm() != null) {
            ASEGURADORA =  this.getServiceLocator().getClinicoService().getDescripcionEntidadByCodigo(usuario.getHuscentidadadm());
        }
        if (usuario != null && usuario.getHusctelacompana() != null) {
            TELCONTACTO = usuario.getHusctelacompana();
        }
        if (usuario != null && usuario.getHuscparresponsa() != null) {
            PARENTESCO = usuario.getHuscparresponsa();
        }
        if (nota != null && nota.getHppcobservacion()!=null) {
            OBSERVACION =nota.getHppcobservacion();
        }
    }
    
    public void resetDatosPsicologia() {
        FECHA=new Date();
        CLINICA="";
        NOMBRES="";
        IDENTIFICACION="";
        FECHANTO=new Date();
        DESEOLLAMAR="";
        SEXO="";
        GENERO="";
        DIRECCION="";
        TELEFONO="";
        CIUDAD="";
        ZONA="";
        ESTADOCIVIL="";
        OCUPACION="";
        AFILACION="";
        ASEGURADORA="";
        EDAD=0;
        RESPONSABLE="";
        TELCONTACTO="";
        PARENTESCO="";
        OBSERVACION="";
    }
    
    //-----------------------------------------------------------------------
    //  Ajax
    //-----------------------------------------------------------------------

    public void mostrarBuscadorUsuarios() {
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        FacesUtils.resetManagedBean("mostrarBuscadorUsuarios");
        selectedIndex = ACTIVAR_BUSCADOR;
        renderBuscador = true;
        generoHistoria = false;
        javaScriptText = null;
    }

    /**
     * @param valueChangeEvent
     */
    public void setNumeroUsuario(ValueChangeEvent valueChangeEvent) {
        setNumeroUsuario((Long)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    //-----------------------------------------------------------------------
    //  Boton Principal
    //-----------------------------------------------------------------------

    public void imprimirResumen() {
        this.index = -1;
        wexito = true;
        lstReporte = new ArrayList<Chreporte>();
        if (fechaInicial.compareTo(fechaFinal) > 0) {
            wexito = false;
        }

        if (wexito) {
            try {
                lstResumen = 
                        this.getServiceLocator().getClinicoService().getResumenHistoria(fechaInicial, 
                                                                                        fechaFinal, 
                                                                                        usuario.getHuslnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        } else {
            FacesUtils.addErrorMessage(IConstantes.MSG_VALIDACION_FECHA_MENOR);
        }

        if (lstResumen == null || lstResumen.isEmpty()) {
            wexito = false;
            generoHistoria = false;
        }
        if (wexito) {
            try {
                generarReporte();
                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/consultarFolios.jasper");
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
                    parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                    byte[] bytes;

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);
                    bytes = 
                            JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                    PdfServletUtils.showPdfDocument(bytes, 
                                                    "Resumen_Historia" + ".pdf", 
                                                    false);
                    generoHistoria = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
            }
        }
    }


    public String ImprimirFolio() {
        lstReporte = new ArrayList<Chreporte>();
        Chconsulta consultaFolio;
        BigDecimal numeroFactura = null;
        Chconsulta consultaAux;
        Chcirugprogr cirugProg;
        consultaAux = null;
        consultaFolio = null;
        cirugProg = null;
        Chlogimpresi logimpresion;

        logimpresion = new Chlogimpresi();

        this.index = -1;
        if (dtFolios != null && dtFolios.getRowData() != null) {
            consultaAux = (Chconsulta)this.dtFolios.getRowData();
        }

        if (consultaAux != null && consultaAux.getHcolnumero() != null && 
            consultaAux.getHcoctiposervi() != null) {
            try {
                consultaFolio = 
                        this.getServiceLocator().getClinicoService().getConsultaCompleta(consultaAux.getHcolnumero(), 
                                                                                         consultaAux.getHcoctiposervi());
                cirugProg = 
                        this.serviceLocator.getCirugiaService().getCirugiaPorId(consultaAux.getHcolnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (consultaAux != null && consultaAux.getHcolnumero() != null) {
            try {
                numeroFactura = 
                        this.serviceLocator.getClinicoService().getNumeroFactura(consultaAux.getHcolnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (consultaFolio != null) {
            if (cirugProg != null && cirugProg.getHcpcestado() != null) {
                DatosBasicosUsuarioCirugiaBean datosUsuario = 
                    (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
                if (datosUsuario != null && usuario != null) {
                    datosUsuario.setUsuario(usuario);
                    datosUsuario.inicializarUsuario();
                }

                FacesUtils.resetManagedBean("generarFoliosCirugiaBean");
                GenerarFoliosCirugiaBean generarFolios = 
                    (GenerarFoliosCirugiaBean)FacesUtils.getManagedBean("generarFoliosCirugiaBean");

                if (generarFolios != null && consultaFolio != null) {
                    generarFolios.setConsulta(consultaFolio);
                    generarFolios.setOrigen("Imprimir");
                    generarFolios.setGeneroHistoria(false);
                }
                generoHistoria = false;
                return BeanNavegacion.RUTA_IR_GENERAR_FOLIOS_CIRUGIA;
            } else {
                    logimpresion = new Chlogimpresi();
                logimpresion.setHlicimpreconsu(IMPRIMIO_RESUMEN_HISTORIA);
                logimpresion.setHlicoperador(userName());
                logimpresion.setHlidfecharegis(new Date());
                logimpresion.setHlinclinica(this.getClinica().getCclncodigo());
                logimpresion.setHlilusuario(consultaFolio.getHcolusuario().getHuslnumero());

                        try {
                    this.serviceLocator.getClinicoService().saveLogImpresionHistorias(logimpresion);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                obtenerDatosReporte(consultaFolio);
                
                try {
                    URL url = 
                        FacesUtils.getFacesContext().getExternalContext().getResource("/reports/consultarFolios.jasper");
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

                        JasperReport report = 
                            (JasperReport)JRLoader.loadObject(url);
                        byte[] bytes;

                        bytes = 
                                JasperRunManager.runReportToPdf(report, parameters, 
                                                                (JRDataSource)this);
                        if (numeroFactura == null) {
                            numeroFactura = new BigDecimal(0);
                        }

                        PdfServletUtils.showPdfDocument(bytes, 
                                                        "NIT_860013779_" + 
                                                        numeroFactura + "_HC" + 
                                                        ".pdf", false);
                        generoHistoria = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                               e.getMessage());
                }
            }
        }
        return BeanNavegacion.RUTA_ACTUAL;

    }

    /**
     * @return
     */
    public String consultarResumen() {

        this.index = -1;
        mostrarReporte = false;
        wexito = true;
        JasperPrint jasperPrint = null;
        lstReporte = new ArrayList<Chreporte>();
        if (fechaInicial != null && fechaFinal != null) {
            if (fechaInicial.compareTo(fechaFinal) > 0) {
                wexito = false;
            }
        }

        if (wexito) {
            try {
                lstResumen = 
                        this.getServiceLocator().getClinicoService().getResumenHistoria(fechaInicial, 
                                                                                        fechaFinal, 
                                                                                        usuario.getHuslnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        } else {
            FacesUtils.addErrorMessage(IConstantes.MSG_VALIDACION_FECHA_MENOR);
        }

        if (lstResumen == null || lstResumen.isEmpty()) {
            generarReporteVacio();
            FacesUtils.addErrorMessage(IConstantes.MSG_SIN_DATOS);
        }
        if (wexito) {
            mostrarReporte = true;
            try {
                generarReporte();
                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/consultarFolios.jasper");
                ExternalContext externalContext = 
                    FacesContext.getCurrentInstance().getExternalContext();
                HttpServletRequest request = 
                    (HttpServletRequest)externalContext.getRequest();

                if (url != null) {
                    Map parameters = new HashMap();
                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);
                    JRHtmlExporter exporter = new JRHtmlExporter();
                    jasperPrint = 
                            JasperFillManager.fillReport(report, parameters, 
                                                         (JRDataSource)this);
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, 
                                          jasperPrint);
                    exporter.setParameter(JRExporterParameter.OUTPUT_STRING_BUFFER, 
                                          sbuffer);
                    request.getSession().setAttribute("jasperPrint", 
                                                      jasperPrint);
                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
            }
        }

        if (wexito) {
            return BeanNavegacion.RUTA_MOSTRAR_RESUMEN_HISTORIA;
        } else {
            if (encabezado) {
                FacesUtils.addErrorMessage(IConstantes.MSG_NO_RESUMEN_ENCABEZADO);
            } else {
                FacesUtils.addErrorMessage(IConstantes.MSG_NO_RESUMEN);
            }
            return BeanNavegacion.RUTA_ACTUAL;
        }
    }

    /**
     * @return
     */
    public void visualizarConsulta() {

        JasperPrint jasperPrint;
        jasperPrint = null;
        this.index = -1;
        lstReporte = new ArrayList<Chreporte>();
        obtenerDatosReporte(consultaClone);
        try {

            URL url = 
                FacesUtils.getFacesContext().getExternalContext().getResource("/reports/consultarFolios.jasper");
            ExternalContext externalContext = 
                FacesContext.getCurrentInstance().getExternalContext();
            HttpServletRequest request = 
                (HttpServletRequest)externalContext.getRequest();

            if (url != null) {
                Map parameters = new HashMap();
                JRHtmlExporter exporter = new JRHtmlExporter();

                JasperReport report = (JasperReport)JRLoader.loadObject(url);
                jasperPrint = 
                        JasperFillManager.fillReport(report, parameters, (JRDataSource)this);
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


    /**
     * @return
     */
    public void visualizarConsultaFolio() {

        lstReporte = new ArrayList<Chreporte>();
        Chconsulta consultaFolio;
        Chconsulta consultaAux;
        Chcirugprogr cirugProg = null;
        consultaAux = null;
        consultaFolio = null;
        this.index = -1;
        JasperPrint jasperPrint;
        jasperPrint = null;
        renderFolio = false;
        mostrarReporte = false;
        generoHistoria = false;
        renderRegistrosEnf = false;
        Chlogimpresi logimpresion;

        logimpresion = new Chlogimpresi();


        if (dtFolios != null && dtFolios.getRowData() != null) {
            consultaAux = (Chconsulta)this.dtFolios.getRowData();
        }

        if (consultaAux != null && consultaAux.getHcolnumero() != null && 
            consultaAux.getHcoctiposervi() != null) {
            try {
                consultaFolio = 
                        this.getServiceLocator().getClinicoService().getConsultaCompleta(consultaAux.getHcolnumero(), 
                                                                                         consultaAux.getHcoctiposervi());

                cirugProg = 
                        this.serviceLocator.getCirugiaService().getCirugiaPorId(consultaAux.getHcolnumero());

            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (numeroConsulta != null && consultaFolio == null) {

            try {
                consultaFolio = 
                        this.serviceLocator.getClinicoService().getConsultaCompleta(numeroConsulta, 
                                                                                    TIPO_CONSULTA);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

            if (cirugProg != null) {
            renderFolio = false;
            FacesUtils.addErrorMessage("Folio de CirugNa, consultelo por opcion CONSULTAR E IMPRIMIR HISTORIAS");
        } else {

            obtenerDatosReporte(consultaFolio);

            if (consultaFolio != null) {
                logimpresion = new Chlogimpresi();
                logimpresion.setHlicimpreconsu(GENERO_RESUMEN_HISTORIA);
                logimpresion.setHlicoperador(userName());
                logimpresion.setHlidfecharegis(new Date());
                logimpresion.setHlinclinica(this.getClinica().getCclncodigo());
                logimpresion.setHlilusuario(consultaFolio.getHcolusuario().getHuslnumero());

                  try {
                    this.serviceLocator.getClinicoService().saveLogImpresionHistorias(logimpresion);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            try {

                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/consultarFolios.jasper");
                ExternalContext externalContext = 
                    FacesContext.getCurrentInstance().getExternalContext();
                HttpServletRequest request = 
                    (HttpServletRequest)externalContext.getRequest();

                if (url != null) {

                    Map parameters = new HashMap();
                    JRHtmlExporter exporter = new JRHtmlExporter();

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);
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
                    exporter.setParameter(JRHtmlExporterParameter.HTML_FOOTER, 
                                          "");
                    exporter.setParameter(JRHtmlExporterParameter.HTML_HEADER, 
                                          "");

                    request.getSession().setAttribute("jasperPrint", 
                                                      jasperPrint);
                    renderFolio = true;
                    
                    GenerarFoliosCirugiaBean generarFolios = (GenerarFoliosCirugiaBean)FacesUtils.getManagedBean("generarFoliosCirugiaBean");
                    if(consultaFolio!= null ){
                        generarFolios.setConsulta(consultaFolio);
                        generarFolios.setGeneroHistoria(false);
                    }
                    
                    registrosEnfermeriaByte = generarFolios.consultarRegistrosEnfermeria();
                    if(registrosEnfermeriaByte != null){
                        renderRegistrosEnf = true;
                    }else{
                        renderRegistrosEnf = false;
                    }
                    FacesUtils.resetManagedBean("generarFoliosCirugiaBean");

                }
            } catch (Exception e) {
                renderFolio = false;
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
                e.printStackTrace();
            }


        }
    }


    //-----------------------------------------------------------------------
    //  Boton Secundarios
    //-----------------------------------------------------------------------

    public void resetDatos() {
        LEUCORREAS = "";
        ITS = "";
        CITOLOGIA = "";
        COLPOSCOPIA = "";
        PERIODO_INTERGENESICO = "";
        HISTORIA_INFERTILIDAD = "";
        RPM = "";
        RCIU = "";
        TRATAMIENTOS_RECIBIDOS = "";
        CUAL_TRATAMIENTO = "";
        AMENAZA_PARTO = "";
        PARTO_PREMATURO = "";
        GEMELAR = "";
        POLHIDRAMNIOS = "";
        OLIGOHIDRAMNIOS = "";
        MALFORMACIONES = "";
        CUAL_MALFORMACION = "";
        EMBARAZO_PROLONGADO = "";
        AMENAZA_ABORTO = "";
        OTROS_OBSTETRICOS = "";
        CUALES_OBSTETRICOS = "";

        ANTITETANICA_PREVIA = "";
        ANTITETANICA_ACTUAL_PRIMERA_DOSIS = "";
        FECHA_ANTITETANICA_PRIMERA_DOSIS = "";
        ANTITETANICA_ACTUAL_SEGUNDA_DOSIS = "";
        FECHA_ANTITETANICA_SEGUNDA_DOSIS = "";
        ANTIRUBEOLA_PREVIA = "";
        ANTIRUBEOLA_ACTUAL = "";
        FECHA_ANTIRUBEOLA_ACTUAL = "";
        GRUPO_RH_PACIENTE = "";
        GRUPO_RH_ESPOSO = "";
        SENSIBILIZACION = "";
        SOLICITO_VIH = "";
        REALIZO_VIH = "";
        ESTADO_GESTION_PROBABLE = "";
        METODO_CONFIRMACION_EDAD_GESTIONAL = "";
        SIGNOS_SNTOMAS_GESTACION = "";

        PRESION_ARTERIAL_PRENATAL = "";
        TIPO_TEMPERATURA_PRENATAL = "";
        FRECUENCIA_CARDIACA_PRENATAL = "";
        FRECUENCIA_RESPIRATORIA_PRENATAL = "";
        TALLA_PRENATAL = "";
        PESO_PRENATAL = "";
        TEMPERATURA_PRENATAL = "";
        EXAMEN_CLINICO_PRENATAL = "";
        EXAMEN_MAMAS_PRENATAL = "";
        EXAMEN_ODONTOLOGICO_PRENATAL = "";
        PELVIS_PRENATAL = "";
        CITOLOGIA_PRENATAL = "";
        CERVIX_PRENATAL = "";
        ALTURA_UTERINA = "";
        FRECUENCIA_CARDIACA_FETAL = "";
        MOVIMIENTO_FETAL = "";
        PRESENTACION_FETAL = "";
        EDEMAS_PRENATAL = "";
        VALORACION_CUELLO_UTERINO = "";
        ORL_PRENATAL = "";
        CARDIO_PULMONAR_PRENATAL = "";
        EXTREMIDADES_PRENATAL = "";
        SISTEMA_NERVIOSO_PRENATAL = "";
        DESCRIPCION_ORL_PRENATAL = "";
        DESCRIPCION_CARDIO_PULMONAR_PRENATAL = "";
        DESCRIPCION_EXTREMIDADES_PRENATAL = "";
        DESCRIPCION_SISTEMA_NERVIOSO_PRENATAL = "";
        GENITURINARIO_PRENATAL ="";
        DESCRIPCION_GENITURINARIO_PRENATAL ="";
        GASTROINTESTINAL_PRENATAL ="";
        DESCRIPCION_GASTROINTESTINAL_PRENATAL ="";

        TOXOPLASMA_IGG = "";
        RESULTADO_IGG = "";
        FECHA_IGG = "";
        TOXOPLASMA_IGM = "";
        RESULTADO_IGM = "";
        FECHA_IGM = "";
        TEST_SULLIVAN = "";
        RESULTADO_TEST_SULLIVAN = "";
        FECHA_TEST_SULLIVAN = "";
        HEMOGLOBINA = "";
        RESULTADO_HEMOGLOBINA = "";
        FECHA_HEMOGLOBINA = "";
        GLUCOSA = "";
        RESULTADO_GLUCOSA = "";
        FECHA_GLUCOSA = "";
        SEROLOGIA = "";
        RESULTADO_SEROLOGIA = "";
        FECHA_SEROLOGIA = "";
        ECOGRAFIA = "";
        DESCRIPCION_ECOGRAFIA = "";
        MICRONUTRIENTES = "";
        PARCIAL_ORINA = "";
        BACTERIURIA = "";
        PROTEINURIA = "";
        HEMATIES = "";
        LEUCOCITOS = "";


        TIENE_HTA_FAMILIAR = "";
        TIENE_DIABETES_FAMILIAR = "";
        TIENE_PREECLAMPSIA_FAMILIAR = "";
        TIENE_ECLAMPSIA_FAMILIAR = "";
        TIENE_GEMELARES_FAMILIAR = "";
        TIENE_CARDIOPATIA_FAMILIAR = "";
        TIENE_TUBERCULOSIS_FAMILIAR = "";
        TIENE_OTROS_FAMILIAR = "";

        HTA_FAMILIAR = "";
        DIABETES_FAMILIAR = "";
        PREECLAMPSIA_FAMILIAR = "";
        ECLAMPSIA_FAMILIAR = "";
        GEMELARES_FAMILIAR = "";
        CARDIOPATIA_FAMILIAR = "";
        TUBERCULOSIS_FAMILIAR = "";
        OTROS_FAMILIAR = "";


        TIENE_HTA_PERSONAL = "";
        TIENE_DIABETES_PERSONAL = "";
        TIENE_PREECLAMPSIA_PERSONAL = "";
        TIENE_ECLAMPSIA_PERSONAL = "";
        TIENE_GEMELARES_PERSONAL = "";
        TIENE_CARDIOPATIA_PERSONAL = "";
        TIENE_TUBERCULOSIS_PERSONAL = "";
        TIENE_CIRUGIA_PELVICO_PERSONAL = "";
        TIENE_ALERGICOS_PERSONAL = "";
        TIENE_TABAQUISMO_PERSONAL = "";
        TIENE_ANTITETANICA_PERSONAL = "";
        TIENE_OTROS_PERSONAL = "";

        HTA_PERSONAL = "";
        DIABETES_PERSONAL = "";
        PREECLAMPSIA_PERSONAL = "";
        ECLAMPSIA_PERSONAL = "";
        GEMELARES_PERSONAL = "";
        CARDIOPATIA_PERSONAL = "";
        TUBERCULOSIS_PERSONAL = "";
        CIRUGIA_PELVICO_PERSONAL = "";
        ALERGICOS_PERSONAL = "";
        TABAQUISMO_PERSONAL = "";
        ANTITETANICA_PERSONAL = "";
        OTROS_PERSONAL = "";


        AREA_AFECTIVA_INTERRUPCION = "";
        AREA_COGNITIVA_INTERRUPCION = "";
        AREA_SOMATICA_INTERRUPCION = "";
        AREA_RELACIONAL_INTERRUPCION = "";
        OBSERVACIONES_INTERRUPCION = "";
        OTRO_SOMATICO = "";
        OTRO_RELACIONAL = "";
        OTRO_COGNITIVO = "";
        TIPO_REMISION_ILVE = "";
        CUAL_REMISION_ILVE = "";
        CERTIFICACION_MEDICA_ILVE = "";
        CUAL_FOBIA = "";

        REALIZACION_PROCEDIMIENTO = "";

        /** Almacenan los datos de la historia clinica */
        TIPO_DOCUMENTO = "";
        NUMERO_DOCUMENTO = null;
        IMPRIMIO = "";
        NOMBRE = "";
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
        DES_MOTIVO_CONSULTA = "";
        MOTIVO_CONSULTA = "";
        MANIOBRAS = "";
        OBSMANIOBRAS = "";
        INTERRUPCION = "";
        OBSINTERRUPCION = "";
        FINALIDAD = "";
        ENFERMEDAD_ACTUAL = "";
        TIPO_CONTROL = "";
        NOMBRE_ACOMPANANTE = "";
        TELEFONO_ACOMPANANTE = "";
        TIPO_AFILIACION = "";
        /* Procedimientos IVE */
        CAUSA_EXTERNA = "";
        FINALIDAD_IVE = "";
        EFECTOS_SECUNDARIOS = "";
        ESCALA_DOLOR = "";
        DURACION_DOLOR = null;
        DOLOR_MEDICO = "";
        SANGRADO_MESTRU = "";
        DURACION_SANGRADO = null;
        SANGRADO_MEDICO = "";
        SANGRO = "";
        TIEMPO_SANGRO = null;
        SANGRO_MEDICO = "";
        PRESENTO_EXPULSION = "";
        PRESENTO_POSTERIOR = "";
        HORAS_EXPULSION = null;
        REPORTE_ECOGRAFIA = "";
        GROSOR_ENDOMETRIAL = null;
        DOPPLER = "";
        DOPPLER_PN = "";
        COMPLICACIONES = "";
        PLANIFICACION = "";
        INICIAR_PLANI = "";
        METODO_ANTICO = "";
        METODO_ANTICONCEPTIVO = "";
        TOLERANCIA_METODO = "";

        /* Despositivo aplicado */
        DESCRIPCION_PROCEDIMIENTO_PF = "";
        AMBITO_PF = "";
        FINALIDAD_PF = "";
        DIAGNOSTICO_POSTERIOR_PF = "";
        DIAGNOSTICO_COMPLICACION_PF = "";
        TIENE_COMPLICACIONES_PF = "";
        DESCRIPCION_COMPLICACION_PF = "";
        REALIZACION_PROCEDIMIENTO_PF = "";

        ANTECEDENTE_ALERGICOS = "";
        SIN_ANTECEDENTES = "";
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

        GESTACIONES = null;
        PARTOS = null;
        ABORTOS = null;
        CESAREAS = null;
        HIJOS_VIVOS = null;
        HIJOS_ECTOPICOS = null;
        HIJOS_MUERTOS = null;
        MORTINATOS = null;
        HIJOS_NACIDOS_VIVOS = null;
        TIPO_CICLO = null;
        FRECUENCIA_CICLO = null;
        DURACION_CICLO = null;
        MENARQUIA = null;
        EDAD_PRIMERA_RELACION = null;
        FUR = null;
        ;
        FUP = null;
        ;
        FUC = null;
        ;
        ULTIMA_CITOLOGIA = null;
        HA_SUFRIDO_VIOLENCIA = null;
        VIOLENCIA_FISICA = null;
        VIOLENCIA_PSICOLOGICA = null;
        VIOLENCIA_SEXUAL = null;
        RIESGO_PERSONA_MALTRATA = null;
        ASESORIA_HABLAR = null;
        OBSERVACIONES_VIOLENCIA = null;
        PRESION_ARTERIAL = null;
        TIPO_TEMPERATURA = null;
        LUGAR_TEMPERATURA = null;
        FRECUENCIA_CARDIACA = null;
        FRECUENCIA_RESPIRATORIA = null;
        TALLA = null;
        PESO = null;
        TEMPERATURA = null;
        HALLAZGOS_EXAMEN_FISICO = null;
        RECOMENDACIONES_IMPRESION = null;
        TIPO_DIAGNOSTICO = null;
        DIAGNOSTICO_PRINCIPAL = null;
        DIAGNOSTICO_RELACIONADO1 = null;
        DIAGNOSTICO_RELACIONADO2 = null;
        DIAGNOSTICO_RELACIONADO3 = null;
        RECOMENDACIONES_CONDUCTA = null;
        RECOMENDACIONES_PLANMANEJO = null;
        FECHA_INICIAL_INCAPACIDAD = null;
        FECHA_FINAL_INCAPACIDAD = null;
        TIPO_INCAPACIDAD = null;
        ORIGEN_INCAPACIDAD = null;
        DIAS_INCAPACIDAD = null;
        FECHA_CIRUGIA1 = null;
        HORA_CIRUGIA1 = null;
        FECHA_CIRUGIA2 = null;
        HORA_CIRUGIA2 = null;
        ANESTESIA_SOLICITADA = null;
        INTERVENCIONES_PROPUESTAS = null;
        AYUDANTIA = null;
        ESTANCIA = null;
        NUMERO_DIAS_ESTANCIA = null;
        RESERVA_SANGRE = null;
        UNIDADES_SANGRE = null;
        PATOLOGIA = null;
        PROGRAMAR_ANESTESIOLOGO = null;
        // Atributos  examenes paraclinicos
        FISIOLOGICOS = null;
        IMAGENES = null;
        LABORATORIOS = null;

        // HISTORIA PSICOLOGIA
        // Atributos para los Antecedentes Psicologicos 

        SE_SIENTE_ENFERMO = null;
        DESCRIPCION_ENFERMO = null;
        ALTERACION_FISICA = null;
        CUAL_ALTERACION = null;
        NUNCA_FISICA = null;
        OCASIONALMENTE_FISICA = null;
        TRES_ALIMENTOS = null;
        MAS_ALIMENTOS = null;
        TIPO_ALIMENTOS_CONSUME = null;
        MEDICAMENTOS_FORMULADOS = null;
        CUAL_MEDICAMENTO = null;
        HABITOS_SALUD = null;
        CUAL_HABITO = null;
        ORIENTACION_SEXUAL = null;
        CUAL_ORIENTACION = null;
        TIENE_PAREJA = null;
        TIPO_VINCULO = null;
        VIDA_SEXUAL = null;
        RELACIONES_SATISFACTORIAS = null;
        DIFICULTADES_RELACIONES = null;
        CUALES_DIFICULTADES = null;
        TRASTORNOS_PSIQUICOS = null;
        CUAL_TRASTORNO = null;
        TIPO_FAMILIA = null;
        COMPOSICION_FAMILIAR = null;
        TIPO_VINCULO_FAMILIAR = null;
        RELACION_FAMILIA = null;

        // Atributos para EvaluaciNn General (Psicologia)

        AREA_COGNITIVA = null;
        AREA_AFECTIVA = null;
        APOYO_FAMILIAR = null;
        CUAL_APOYO = null;
        CANALES_COMUNICACION = null;
        CUAL_CANAL = null;
        LABORAL_ESTUDIOS = null;
        SERVICIOS_APOYO = null;
        RELACIONES_FAMILIARES = null;
        CUAL_PROBLEMA = null;
        CUAL_RELACION = null;
        RELACION_SOCIAL=null;
        COMPOSICIONDINA_FAMILIAR=null;
        DESARROLLO_SESION=null;


        // Atributos para Plan de Tratamiento (Psicologia)

        TIPO_INTERVENCION_PSICO = null;
        NUMERO_SESIONES = null;
        COMPROMISOS_PSCIO = null;


        // Atributos referencia

        TIPO_SERVICIO = null;
        NOMBRE_RESPONSABLE_REFERENCIA = null;
        DIRECCION_RESPONSABLE_REFERENCIA = null;
        TELEFONO_RESPONSABLE_REFERENCIA = null;
        ANAMNESIS = null;
        APOYO_DIAGNOSTICO = null;
        JUSTIFICACION_REFERENCIA = null;


        // Atributos de VacunaciNn de CNrvix


        FECHA_VACUNACION = null;
        NUMERO_DOSIS = null;
        OBSERVACIONES_VACUNA = null;

        // Atributos ANATOMIA PATOLOGICA
        ORIGEN_PIEZA = null;

        // Atributos de control


        NOTA_ACLARATORIA = null;


        HCECENFERMO = null;
        HCECENFERGRAV = null;
        HCECOPERADO = null;
        HCECTRANSFUSION = null;
        HCECPRESIONALTA = null;
        HCECEJERCICIO = null;
        HCECPALPITACION = null;
        HCECSOPLO = null;
        HCECASMA = null;
        HCECTOS = null;
        HCECGRIPA = null;
        HCECFUMA = null;
        HCECPROBANESTESIA = null;
        HCECALERGIA = null;
        HCECDROGAS = null;
        HCECCONVULSION = null;
        HCECENFERMENTAL = null;
        HCECDIABETES = null;
        HCECHEPATITIS = null;
        HCECOTRAENFER = null;
        HCECEMBARAZO = null;
        HCEDFECHULTMES = null;
        HCECUTILMETPLAN = null;
        HCEDFECHAPARTO = null;
        HCECINFOMET = null;
        HCECMETDEF = null;
        HCECLIGFALLA = null;
        HCECINSESTER = null;

        HCECANENFERMO = null;
        HCECANENFERGRAV = null;
        HCECANOPERADO = null;
        HCECANTRANSFUSION = null;
        HCECANPRESIONALTA = null;
        HCECANEJERCICIO = null;
        HCECANPALPITACION = null;
        HCECANSOPLO = null;
        HCECANASMA = null;
        HCECANTOS = null;
        HCECANGRIPA = null;
        FUMA_DIA_FEMENINA = null;
        HCECANFUMA = null;
        HCECANPROBANESTESIA = null;
        HCECANALERGIA = null;
        HCECANDROGAS = null;
        HCECANCONVULSION = null;
        HCECANENFERMENTAL = null;
        HCECANDIABETES = null;
        HCECANHEPATITIS = null;
        HCECANOTRAENFER = null;
        HCECANEMBARAZO = null;
        HCECANMESNORM = null;
        HCECANMETPLAN = null;
        HCECANINFOMET = null;
        HCECANMETDEF = null;
        HCECANLIGFALLA = null;
        HCECANINSESTER = null;
        HCECMESNORM = null;
        HCECESPARTO = null;
        HCECMETPLAN = null;
        HCECOBSERV = null;

        // Datos del Reporte Esterilizacion Masculina

        HEMCINFORMETOD = null;
        HEMCVASECDEFIN = null;
        HEMCVASECFALLA = null;
        HEMCVASECFALLANUEVO = null;
        HEMCACLARFALLANUEVO = null;
        HEMCEXITOESPER = null;
        HEMCINFORSUFIC = null;
        HEMCACLARINFOR = null;
        HEMCACLARDEFIN = null;
        HEMCACLARFALLA = null;
        HEMCACLAREXITO = null;
        HEMCACLARSUFIC = null;


        AMBITO_PROCEDIMIENTO = null;
        FINALIDAD_PROCEDIMIENTO = null;
        DIAGNOSTICO_PREVIO = null;
        DESCRIPCION_PROCEDIMIENTO = null;
        NOMBRE_PROCEDIMIENTO = null;
        TIENE_COMPLICACIONES = null;
        DIAGNOSTICO_COMPLICACION = null;
        DESCRIPCION_COMPLICACION = null;
        DIAGNOSTICO_POSTERIOR = null;


        INDICACION_EXAMEN_ECOGRAFIA = null;
        TRASNDUCTOR_UTILIZADO_ECOGRAFIA = null;
        INFORME_ECOGRAFIA = null;
        CONCLUSION_ECOGRAFIA = null;
        NUMERO_MAMOGRAFIA = null;
        MEDICO_REMITE = null;
        DATOS_CLINICOS_RELEVANTES = null;
        INFORME_MAMOGRAFICO = null;
        DOSIS_SUPERFICIE = null;
        INFORME_COMO_TAL_MAMOGRAFIA = null;
        OPINION_MAMOGRAFIA = null;
        TIPO_BIRADS = null;
        RECOMENDACIONES_MAMOGRAFIA = null;

        GESTACIONES_ECOGRAFIA = null;
        PARTOS_ECOGRAFIA = null;
        ABORTOS_ECOGRAFIA = null;
        CESAREAS_ECOGRAFIA = null;
        HIJOS_ECTOPICOS_ECOGRAFIA = null;
        EDAD_GESTACIONAL_MENSTRUAL = null;
        DIAS_EDAD_GESTACIONAL = null;
        FUR_ECOGRAFIA = null;


        SEMANAS_EMBARAZO_GESTACIONAL = null;
        SEMANAS_EMBARAZO = null;
        CONFIRMA_SEMANAS_EMBARAZO = null;


        AREA_AFECTIVA_INTERRUPCION = null;
        AREA_COGNITIVA_INTERRUPCION = null;
        AREA_SOMATICA_INTERRUPCION = null;
        AREA_RELACIONAL_INTERRUPCION = null;
        OBSERVACIONES_INTERRUPCION = null;
        OTRO_SOMATICO = null;
        OTRO_RELACIONAL = null;
        OTRO_COGNITIVO = null;
        TIPO_REMISION_ILVE = null;
        CUAL_REMISION_ILVE = null;
        CERTIFICACION_MEDICA_ILVE = null;
        CUAL_FOBIA = null;


        ASESOCANCE = null;
        RECOMPREVE = null;
        VPHCOMPPRE = null;
        OTROSTIPOS = null;
        CIENVIRUS = null;
        DOSVACUCOL = null;
        VPHCAUSANT = null;
        TRESDOSIS = null;
        INFOCERVA = null;
        ANORMCITOL = null;
        ANTECALERG = null;
        REACIVACUN = null;
        ENFERGRIPA = null;
        ESTAEMBAR = null;
        AMAMANTAND = null;
        MESTRNORMA = null;
        TIENEPARTO = null;
        METODPLANI = null;
        PIENSEMBAR = null;
        MEDIAHORA = null;
        INFORCONSE = null;
        CONSUPROFA = null;
        FUR_CERVIX = null;
        FUP_CERVIX = null;
        CUALANORMALIDAD = null;
        INFORGARDA = null;

        APERTURA_ORAL_PREANESTESIA = null;
        MALLAMPATI_PREANESTESIA = null;
        DISTANCIA_MENTOTIROIDEA = null;
        MOVILIDAD_MANDIBULA = null;
        MOVILIDAD_ATLANTO_OCCIPITAL = null;
        EVALUACION_GLOBAL_VIA_AEREA = null;
        PROTESIS_DENTAL = null;
        PROTESIS_INFERIOR = null;
        GRADO_PROTESIS_INFERIOR = null;
        MOVILIDAD_PROTESIS_INFERIOR = null;
        PROTESIS_SUPERIOR = null;
        GRADO_PROTESIS_SUPERIOR = null;
        MOVILIDAD_PROTESIS_SUPERIOR = null;
        HALLAZGOS_EXAMEN_FISICO_PREANESTESIA = null;

        HEMOGLOBINA_PREANESTESIA = null;
        HEMATOCRITO_PREANESTESIA = null;
        LEUCOCITOS_PREANESTESIA = null;
        PT_PREANESTESIA = null;
        INR_PREANESTESIA = null;
        PTT_PREANESTESIA = null;
        PLAQUETAS_PREANESTESIA = null;
        PARCIAL_ORINA_PREANESTESIA = null;
        GLICEMIA_PRE_PREANESTESIA = null;
        GLICEMIA_POST_PREANESTESIA = null;
        NITROGENO_PREANESTESIA = null;
        CREATININA_PREANESTESIA = null;
        ELECTROCARDIOGRAMA_PREANESTESIA = null;
        RAYOS_X_PREANESTESIA = null;
        ECOGRAFIAS_PREANESTESIA = null;
        OTROS_RESULTADOS_PREANESTESIA = null;

        PROFESION = null;
        REGISTRO_MEDICO = null;


        EXAMEN_APOYO_DIAGNOSTICO = null;
        EXAMEN_LABORATORIO_CLINICO = null;
        EXAMEN_IMAGENES = null;
        EXAMEN_ESTUDIO_PATOLOGIA = null;
        EXAMEN_PRUEBA_EMBARAZO = null;
        EXAMEN_CITOLOGIA = null;
        EXAMEN_COLPOSCOPIA = null;
        EXAMEN_OTROS_EXAMENES = null;


        TIENE_LABORATORIO_CLINICO = null;
        TIENE_IMAGENES = null;
        TIENE_ESTUDIO_PATOLOGIA = null;
        TIENE_PRUEBA_EMBARAZO = null;
        TIENE_CITOLOGIA = null;
        TIENE_COLPOSCOPIA = null;
        TIENE_OTROS_EXAMENES = null;


        REVISION_CABEZA_DES = null;
        REVISION_OJOS_DES = null;
        REVISION_OIDOS_DES = null;
        REVISION_NARIZ_DES = null;
        REVISION_BOCA_DES = null;
        REVISION_GARGANTA_DES = null;
        REVISION_CUELLO_DES = null;
        REVISION_CARDIO_DES = null;
        REVISION_MAMAS_DES = null;
        REVISION_GASTRO_DES = null;
        REVISION_GENITO_DES = null;
        REVISION_VENEREOS_DES = null;
        REVISION_ENDOCRINO_DES = null;
        REVISION_LOCOMOTOR_DES = null;
        REVISION_NEUROMUSCULAR_DES = null;
        REVISION_PIEL_DES = null;
        //ANTECEDENTES VASECTOMIA
        HIJOS_BIOLOGICOS_JUNTOS = null;
        HIJOS_BIOLOGICOS_PACIENTE = null;
        HIJOS_BIOLOGICOS_PAREJA = null;
        METODOS_PLANIFICACION = "";

    }

    public void consultarFoliosUsuario() {

        if (usuario != null && usuario.getHuslnumero() != null) {
            lstFolios = new ArrayList<Chconsulta>();
            try {
                    lstFolios = 
                        this.getServiceLocator().getClinicoService().getFoliosUsuario(usuario.getHuslnumero());
                        
                Chusuario usuarioAsesoria = new Chusuario();
                usuarioAsesoria.setHusanumeiden(usuario.getHusanumeiden());
                usuarioAsesoria.setHusetipoiden(usuario.getHusetipoiden());
                
                lstOtrasAsesoria = 
                        serviceLocator.getClinicoService().getOtrasAsesoria(usuarioAsesoria);
                if (lstOtrasAsesoria != null && lstOtrasAsesoria.isEmpty()) {
                    dtConsultaOtrasAsesoria.setFirst(IConstantes.OFFSET_DATATABLE);
                }
                
                lstAsesoria = 
                        this.serviceLocator.getClinicoService().getListAsesoriaUsuario(usuario);
                
                lstViniso = this.serviceLocator.getClinicoService().getListVinisoUsuario(usuario);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (lstFolios == null || lstFolios.isEmpty()) {
            FacesUtils.addErrorMessage(IConstantes.MSG_SIN_DATOS);
        }
    }


    public void ConsultarFoliosIncompletos() {
        if (usuario.getHuslnumero() != null) {
            lstFolios = new ArrayList<Chconsulta>();
            try {
                lstFolios = 
                        this.getServiceLocator().getClinicoService().getFoliosUsuarioIncompleto(usuario.getHuslnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (lstFolios == null || lstFolios.isEmpty()) {
            FacesUtils.addErrorMessage(IConstantes.MSG_SIN_DATOS);
        }
    }


    /**
     * @return
     */
    public String volverConsulta() {
        FacesUtils.resetManagedBean("consultarUsuarioResumenBean");
        FacesUtils.resetManagedBean("consultarFoliosBean");
        FacesUtils.resetManagedBean("mostrarBuscadorUsuarios");

        renderFolio = false;
        mostrarReporte = false;
        generoHistoria = false;
        return BeanNavegacion.RUTA_IR_INICIO;
    }
    public void generarReportePsiclogia(Chconsulta consultaFolio,Chpapsicologico primauxpsicologicos) throws ModelException {
       
          obtenerDatosReporteChpsicologia(consultaFolio,primauxpsicologicos);
      
    }
    public void generarReporte() {
        if (lstResumen != null && !lstResumen.isEmpty()) {
            Iterator it = lstResumen.iterator();
            while (it.hasNext()) {
                Chconsulta consul = (Chconsulta)it.next();
                obtenerDatosReporte(consul);
            }
        }
    }


    public void changeUsuario() {
        Chusuario usuarioAux = null;
        generoHistoria = false;
        renderFolio = false;
        mostrarReporte = false;
        nombreUsuario = "";
        usuario = new Chusuario();
        lstFolios = new ArrayList<Chconsulta>();
        if (numeroUsuario != null)
            try {
                usuarioAux = 
                        this.serviceLocator.getClinicoService().getUsuario(numeroUsuario);
            } catch (ModelException e) {
                e.printStackTrace();
            }

        if (usuarioAux != null) {
            if (usuarioAux.getHuscprimernomb() != null) {
                nombreUsuario = usuarioAux.getHuscprimernomb() + " ";
            }
            if (usuarioAux.getHuscsegundnomb() != null && 
                !usuarioAux.getHuscsegundnomb().equals("_")) {
                nombreUsuario = 
                        nombreUsuario + usuarioAux.getHuscsegundnomb() + " ";
            }
            if (usuarioAux.getHuscprimerapel() != null) {
                nombreUsuario = 
                        nombreUsuario + usuarioAux.getHuscprimerapel() + " ";
            }
            if (usuarioAux.getHuscsegundapel() != null && 
                !usuarioAux.getHuscsegundapel().equals("_")) {
                nombreUsuario = nombreUsuario + usuarioAux.getHuscsegundapel();
            }
            usuario = usuarioAux;
        }
    }

    public void generarReporteVacio() {
        obtenerDatosReporte(null);
    }

    /**
     * @return
     */
    public void aceptarUsuario() {
        selectedIndex = ACTIVAR_BEAN;
        renderFolio = false;
        mostrarReporte = false;
        usuario = new Chusuario();
        nombreUsuario = "";
        lstFolios = new ArrayList<Chconsulta>();
        renderConsulta = true;

        buscador = 
                (BuscadorUsuariosBean)FacesUtils.getManagedBean("buscadorUsuariosBean");
        usuario = buscador.getUsuarioSelect();
        if (usuario != null) {
            numeroUsuario = usuario.getHuslnumero();
            if (usuario.getHuscprimernomb() != null) {
                nombreUsuario = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                nombreUsuario = 
                        nombreUsuario + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                nombreUsuario = 
                        nombreUsuario + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                nombreUsuario = nombreUsuario + usuario.getHuscsegundapel();
            }
            itNumeroUsuario.setValue(usuario.getHuslnumero());
        }
        renderBuscador = false;
    }

    public void changeMotivoImpresion() {
        Chconsulta consultaAux;
        consultaAux = null;

        if (dtFolios != null && dtFolios.getRowData() != null) {
            consultaAux = (Chconsulta)this.dtFolios.getRowData();
            consultaAux.setRenderMotivoEPS(false);
            consultaAux.setRenderMotivoOtro(false);
            if (consultaAux != null && 
                "SE".equals(consultaAux.getHlicmotiimpr())) {
                consultaAux.setRenderMotivoEPS(true);
            } else {
                consultaAux.setHlicmotivoeps(null);
            }

            if (consultaAux != null && 
                "OR".equals(consultaAux.getHlicmotiimpr())) {
                consultaAux.setRenderMotivoOtro(true);
            } else {
                consultaAux.setHlicmotivootro(null);
            }
        }

    }
    
    public void changeMotivoOtraAsesoria() {
        Chasesoria asesoriaSelect = null;
        
        if (dtConsultaOtrasAsesoria != null && dtConsultaOtrasAsesoria.getRowData() != null) {
            asesoriaSelect = (Chasesoria)dtConsultaOtrasAsesoria.getRowData();
            asesoriaSelect.setRenderMotivoEPS(false);
            asesoriaSelect.setRenderMotivoOtro(false);
            if (asesoriaSelect != null && 
                "SE".equals(asesoriaSelect.getHlicmotiimpr())) {
                asesoriaSelect.setRenderMotivoEPS(true);
            } else {
                asesoriaSelect.setHlicmotivoeps(null);
            }

            if (asesoriaSelect != null && 
                "OR".equals(asesoriaSelect.getHlicmotiimpr())) {
                asesoriaSelect.setRenderMotivoOtro(true);
            } else {
                asesoriaSelect.setHlicmotivootro(null);
            }
        }

    }

    //-----------------------------------------------------------------------
    //  ACCESORIOS
    //-----------------------------------------------------------------------

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
     * @param dtFolios
     */
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
     * @param encabezado
     */
    public void setEncabezado(boolean encabezado) {
        this.encabezado = encabezado;
    }

    /**
     * @return
     */
    public boolean isEncabezado() {
        return encabezado;
    }

    /**
     * @param print
     */
    public void setPrint(boolean print) {
        this.print = print;
    }

    /**
     * @return
     */
    public boolean isPrint() {
        return print;
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
    public List getListSexos() {
        if (listSexos.size() == 0) {
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

    public void setListEstadoCivil(List<SelectItem> listEstadoCivil) {
        this.listEstadoCivil = listEstadoCivil;
    }

    /**
     * @return
     */
    public List<SelectItem> getListEstadoCivil() {
        if (listEstadoCivil.size() == 0) {
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
        if (listTipoIdentificacion.size() == 0) {
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
                                                          "Seleccione una opciNn ..."));
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
     * @param fechaFinal
     */
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * @return
     */
    public Date getFechaFinal() {
        return fechaFinal;
    }

    /**
     * @param fechaInicial
     */
    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    /**
     * @return
     */
    public Date getFechaInicial() {
        return fechaInicial;
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
     * @param mostrarReporte
     */
    public void setMostrarReporte(boolean mostrarReporte) {
        this.mostrarReporte = mostrarReporte;
    }

    /**
     * @return
     */
    public boolean isMostrarReporte() {
        return mostrarReporte;
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
     * @param renderBuscador
     */
    public void setRenderBuscador(boolean renderBuscador) {
        this.renderBuscador = renderBuscador;
    }

    /**
     * @return
     */
    public boolean isRenderBuscador() {
        return renderBuscador;
    }

    /**
     * @param itNumeroUsuario
     */
    public void setItNumeroUsuario(UIInput itNumeroUsuario) {
        this.itNumeroUsuario = itNumeroUsuario;
    }

    /**
     * @return
     */
    public UIInput getItNumeroUsuario() {
        return itNumeroUsuario;
    }

    /**
     * @param nombreUsuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param renderInformacionUsuario
     */
    public void setRenderInformacionUsuario(boolean renderInformacionUsuario) {
        this.renderInformacionUsuario = renderInformacionUsuario;
    }

    /**
     * @return
     */
    public boolean isRenderInformacionUsuario() {
        renderInformacionUsuario = false;
        if (usuario != null && usuario.getHuslnumero() != null) {
            renderInformacionUsuario = true;
        }
        return renderInformacionUsuario;
    }

    /**
     * @param renderFolio
     */
    public void setRenderFolio(boolean renderFolio) {
        this.renderFolio = renderFolio;
    }

    /**
     * @return
     */
    public boolean isRenderFolio() {
        return renderFolio;
    }


    public void openPopupClicked(ActionEvent event) {
        javaScriptText = "";
        Long numeroUsuario = null;
        String encodedText = "";
        String cod = "";
        
        numeroUsuario = usuario.getHusanumeiden();
        
        if(numeroUsuario != null){
            String cod1 = "[N_MERO_ID_]=\"";
            String cod2 =numeroUsuario.toString()+"\"";
            cod = cod1+cod2;
        String encodedAuten;

        // Base64
        System.out.println("Numero Usuario String "+numeroUsuario.toString());
        encodedText = new String(Base64.encodeBase64(cod.getBytes()));
        // encodedAuten = new String(Base64.encodeBase64(autenticacion.getBytes()));
        
        
         urlString = urlString + encodedText ; 
         System.out.println(urlString);
        
        FacesContext facesContext = FacesContext.getCurrentInstance();

        // This is the proper way to get the view's url
        ViewHandler viewHandler = facesContext.getApplication().getViewHandler();
        String actionUrl = urlString;
            
                                    // http://wgesdoc/DocuWare/Platform/WebClient/1/Integration?p=V&fc=0ee1c783-c5e9-4232-b6cc-b651dd62bd02&q=W05fTUVST19JRF9dID0gNTIzNDU2Nzg1
                                    //http://wgesdoc/DocuWare/Platform/WebClient/1/Integration?p=RLV&fc=0ee1c783-c5e9-4232-b6cc-b651dd62bd02&q=W05fTUVST19JRF9dID0gNTIzNDU2Nzg1
        javaScriptText = "window.open('http://wgesdoc/DocuWare/Platform/WebClient/1/Integration?&ep=PoZHjy6JIM8QUP2hJVrpuvDZAPH2a8JE_mOz5Vhib23L8oUTv9EFWMDkgUEIqBcGgyAjHVpdIDZl9hgsjkvJ4Tk1DKNW_z68bvR6xP2lXTo1&q=" + encodedText + "' );";
        
        // Add the Javascript to the rendered page's header for immediate execution
        AddResource addResource = AddResourceFactory.getInstance(facesContext);
        
        addResource.addInlineScriptAtPosition(null, AddResource.HEADER_BEGIN, javaScriptText); 
        }else{
            FacesUtils.addErrorMessage("Se debe seleccionar un usuario para la busqueda");
        }

    }


    public void openPopupClicked1(ActionEvent event) {
        // View's id in the same form as used in the navigation rules in faces-config.xml
        // This value could be passed as parameter (using <f:param>)
        javaScriptText = "";
        Chconsulta consultaAux = null;
        Long numeroUsuario = null;
        String encodedText = "";
        String cod = "";

        if (dtFolios != null && dtFolios.getRowData() != null) {
            consultaAux = (Chconsulta)this.dtFolios.getRowData();
        }

        if (consultaAux != null && consultaAux.getHcolusuario() != null && 
            consultaAux.getHcolusuario().getHuslnumero() != null) {
            numeroUsuario = consultaAux.getHcolusuario().getHusanumeiden();
        }

        if (numeroUsuario != null) {
            cod = "[N_MERO_ID_] = " + numeroUsuario.toString();
        }

        String urlString = "/apolo:80/DocuWare/";

        String encodedAuten;

        encodedText = new String(Base64.encodeBase64(cod.getBytes()));
        // encodedAuten = new String(Base64.encodeBase64(autenticacion.getBytes()));

        urlString = urlString + encodedText;

        FacesContext facesContext = FacesContext.getCurrentInstance();

        // This is the proper way to get the view's url
        ViewHandler viewHandler = 
            facesContext.getApplication().getViewHandler();
        String actionUrl = urlString;

        javaScriptText = 
                "window.open('http://apolo:80/DocuWare/Platform/WebClient/1/Integration?lc=VXNlcj1tZWRpY29cblB3ZD1wcnVlYmFzMjAxNQ2&p=RLV&fc=1fa343c5-94db-44e1-a4ce-80d56a68bdf0&q=" + 
                encodedText + "' );";

        // Add the Javascript to the rendered page's header for immediate execution
        AddResource addResource = AddResourceFactory.getInstance(facesContext);

        addResource.addInlineScriptAtPosition(null, AddResource.HEADER_BEGIN, 
                                              javaScriptText);
    }
    
    public String ImprimirFolios() throws ModelException {
        lstReporte = new ArrayList<Chreporte>();
        Chconsulta consultaFolio;
        BigDecimal numeroFactura = null;
        Chconsulta consultaAux;
        Chcirugprogr cirugProg;
        consultaAux = null;
        consultaFolio = null;
        cirugProg = null;
        Chlogimpresi logimpresion;
        generoHistoria = false;
        renderValidacionClinicaImpresion = false;
        boolean exiteMotivo = false;
        Chcirugprogr  cirugiaProgramada = null;
        Chpapsicologico primauxpsicologicos;
        primauxpsicologicos= null;
        logimpresion = new Chlogimpresi();

        this.index = -1;
        if (dtFolios != null && dtFolios.getRowData() != null) {
            consultaAux = (Chconsulta)this.dtFolios.getRowData();
        }
            if (consultaAux != null && consultaAux.getHcolnumero() != null && consultaAux.getHlicmotiimpr() != null){
                try {
                    cirugiaProgramada = this.getServiceLocator().getClinicoService().getProgramarCirugia(consultaAux.getHcolnumero());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (consultaAux.getHconclinica().intValue() ==  this.getClinica().getCclncodigo().intValue()) {
                    renderValidacionClinicaImpresion = true;
                } else if (cirugiaProgramada != null && 
                           cirugiaProgramada.getHcpnclinica().intValue() ==  this.getClinica().getCclncodigo().intValue()) {
                    renderValidacionClinicaImpresion = true;
                } else {
                    if (consultaAux != null && 
                        ("SP".equals(consultaAux.getHlicmotiimpr()) || "RAA".equals(consultaAux.getHlicmotiimpr()))) {
                        renderValidacionClinicaImpresion = true;
                    }
                }
            }else {
                exiteMotivo = true;
            }
        
        if(renderValidacionClinicaImpresion){

        if (consultaAux != null && consultaAux.getHcolnumero() != null && 
            consultaAux.getHcoctiposervi() != null) {
            try {
                consultaFolio = 
                        this.getServiceLocator().getClinicoService().getConsultaCompleta(consultaAux.getHcolnumero(), 
                                                                                         consultaAux.getHcoctiposervi());
                                                                                         
             if (IConstantes.TIPO_HOSPITALIZACION.equals(consultaAux.getHcoctiposervi())) {                                                                           
                cirugProg = 
                        this.serviceLocator.getCirugiaService().getCirugiaPorId(consultaAux.getHcolnumero());
                }
            else if(consultaAux.getChpapsicologico()!=null){
            
               primauxpsicologicos=  this.serviceLocator.getClinicoService().getPapsicologicosUser(consultaAux.getHcolnumero());
            }
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (consultaAux != null && consultaAux.getHcolnumero() != null) {
            try {
                numeroFactura = 
                        this.serviceLocator.getClinicoService().getNumeroFactura(consultaAux.getHcolnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (consultaFolio != null) {
            if (cirugProg != null && cirugProg.getHcpcestado() != null) {
                DatosBasicosUsuarioCirugiaBean datosUsuario = 
                    (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
                if (datosUsuario != null && usuario != null) {
                    datosUsuario.setUsuario(usuario);
                    datosUsuario.inicializarUsuario();
                }

                FacesUtils.resetManagedBean("generarFoliosCirugiaBean");
                GenerarFoliosCirugiaBean generarFolios = 
                    (GenerarFoliosCirugiaBean)FacesUtils.getManagedBean("generarFoliosCirugiaBean");

                if (generarFolios != null && consultaFolio != null) {
                    generarFolios.setConsulta(consultaFolio);
                    generarFolios.setOrigen("Imprimir");
                    generarFolios.setGeneroHistoria(false);
                }
                generoHistoria = false;
                return BeanNavegacion.RUTA_IR_GENERAR_FOLIOS_CIRUGIA;
            } else {
                    logimpresion = new Chlogimpresi();
                logimpresion.setHlicimpreconsu(IMPRIMIO_RESUMEN_HISTORIA);
                logimpresion.setHlicoperador(userName());
                logimpresion.setHlidfecharegis(new Date());
                logimpresion.setHlinclinica(this.getClinica().getCclncodigo());
                logimpresion.setHlilusuario(consultaFolio.getHcolusuario().getHuslnumero());
                logimpresion.setHlicmotiimpr(consultaAux.getHlicmotiimpr());
                logimpresion.setHlicmotivoeps(consultaAux.getHlicmotivoeps());
                logimpresion.setHlicmotivootro(consultaAux.getHlicmotivootro());
                logimpresion.setHlilconsulta(consultaAux.getHcolnumero());

                        try {
                    this.serviceLocator.getClinicoService().saveLogImpresionHistorias(logimpresion);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (primauxpsicologicos != null) {
                        reportePAPsicologia=true;       
                        generarResumenPsicologia(consultaFolio,primauxpsicologicos);
                        
                    } else {
                        obtenerDatosReporte(consultaFolio);
                        try {
                            URL url = 
                                FacesUtils.getFacesContext().getExternalContext().getResource("/reports/consultarFolios.jasper");
                            URL url_profamilia = 
                                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
                            URL url_super_horizontal = 
                                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
                            URL url_super_vertical = 
                                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
                            if (url != null) {
                                Map parameters = new HashMap();
                                parameters.put("IMAGE_PROFAMILIA", 
                                               url_profamilia);
                                parameters.put("IMAGE_SUPER_HORIZONTAL", 
                                               url_super_horizontal);
                                parameters.put("IMAGE_SUPER_VERTICAL", 
                                               url_super_vertical);

                                JasperReport report = 
                                    (JasperReport)JRLoader.loadObject(url);
                                byte[] bytes;

                                bytes = 
                                        JasperRunManager.runReportToPdf(report, parameters, 
                                                                        (JRDataSource)this);
                                FacesUtils.resetManagedBean("generarFoliosCirugiaBean");

                                GenerarFoliosCirugiaBean generarFolios = 
                                    (GenerarFoliosCirugiaBean)FacesUtils.getManagedBean("generarFoliosCirugiaBean");
                                if (generarFolios != null && 
                                    consultaFolio != null) {
                                    generarFolios.setConsulta(consultaFolio);
                                    generarFolios.setGeneroHistoria(false);
                                }


                                FacesUtils.resetManagedBean("cerrarConsultaUsuarioBean");
                                cerrarConsultaUsuarioBean = 
                                        (CerrarConsultaUsuarioBean)FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
                                byte[] bytesColpospia = null;
                                cerrarConsultaUsuarioBean.setNumeroConsulta(consultaAux.getHcolnumero());
                                cerrarConsultaUsuarioBean.setUsuario(usuario);
                                bytesColpospia = 
                                        cerrarConsultaUsuarioBean.generarColposcopia();
                                generoHistoria = 
                                        generarFolios.consultarProcedimiento(bytes, 
                                                                             bytesColpospia);
                                FacesUtils.resetManagedBean("generarFoliosCirugiaBean");
                                motivoImpresion = "";
                                consultarFoliosUsuario();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                                       e.getMessage());
                        }
                    }
                }
        }
        }else{

            if (exiteMotivo) {
                FacesUtils.addErrorMessage("Se debe seleccionar por quN requiere imprimir la historia");
            } else {
                FacesUtils.addErrorMessage("No esta permitido imprimir la historia, ya que pertenece a otra clinica");
            }
        }
        return BeanNavegacion.RUTA_ACTUAL;

    }
    
    
    public String generarRegistrosEnfermeria() {
        PdfServletUtils.showPdfDocument(registrosEnfermeriaByte,"registrosEnfermeria.pdf",false);
        generoHistoria=true;
    return BeanNavegacion.RUTA_ACTUAL;
    }
    
    public String imprimirOtraAsesoria() {
        visualizarAsesorias = false;  
        Chasesoria asesoriaSelect = null;
        asesoriaSelect = (Chasesoria)dtConsultaOtrasAsesoria.getRowData();

        if (asesoriaSelect != null) {
            generarResumenOtraAsesoria(asesoriaSelect);
        }

        return null;
    }
    
    public String visualizarOtraAsesoria() {
        visualizarAsesorias = true;  
        Chasesoria asesoriaSelect = null;
        asesoriaSelect = (Chasesoria)dtConsultaOtrasAsesoria.getRowData();

        if (asesoriaSelect != null) {
            generarResumenOtraAsesoria(asesoriaSelect);
        }

        return null;
    }
    
    public void generarResumenOtraAsesoria(Chasesoria asesoriaAux) {
        generoHistoria = false;
        this.index = -1;
        JasperPrint jasperPrint;
        jasperPrint = null;
        renderFolio = false;
        reporteOtraAsesoria=false;
        try {
            reporteOtraAsesoria = true;
            obtenerDatosReporteOtraAsesoria(asesoriaAux);
            URL url = 
                FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteOtraAsesoria.jasper");
            URL url_profamilia = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
            URL url_super_horizontal = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
            URL url_super_vertical = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
                
            ExternalContext externalContext = 
                FacesContext.getCurrentInstance().getExternalContext();
            HttpServletRequest request = 
                (HttpServletRequest)externalContext.getRequest();
            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                if (!visualizarAsesorias) {
                    byte[] bytes;

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);

                    bytes = 
                            JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);

                    PdfServletUtils.showPdfDocument(bytes, 
                                                    "Resumen_Otra_Asesoria" + 
                                                    ".pdf", false);
                    generoHistoria = true;
                } else {
                    JRHtmlExporter exporter = new JRHtmlExporter();

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);
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
                    exporter.setParameter(JRHtmlExporterParameter.HTML_FOOTER, 
                                          "");
                    exporter.setParameter(JRHtmlExporterParameter.HTML_HEADER, 
                                          "");

                    request.getSession().setAttribute("jasperPrint", 
                                                      jasperPrint);
                    renderFolio = true;

                }

            }
            reporteOtraAsesoria = false;
        } catch (Exception e) {
            reporteOtraAsesoria = false;
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }


    }
    public void imprimirViniso() {
        index = -1;
        generoViniso = true;
        generoHistoria = false;
         Chsegutelefo vinisoSelect = (Chsegutelefo)dtViniso.getRowData();
        fechaViniso  = vinisoSelect.getHstdfecregistr();
        try {
            lstVinisoObj = serviceLocator.getCirugiaService().getRegistroSegTelefonico(vinisoSelect.getId().getHstlnumero(),vinisoSelect.getId().getHstlconsecutiv());
        } catch (ModelException e) {
            // TODO
        }
        if (lstVinisoObj == null || lstVinisoObj.isEmpty()) {
            FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
        } else {
            try {
                try {         
                   Cpprofesio profesionalAct = 
                            serviceLocator.getClinicoService().getProfesionalPorUsuario(vinisoSelect.getHstcoperador(),
                                                                                    this.getClinica().getCclncodigo());
                    if(profesionalAct!=null){
                    nombreProfesional = profesionalAct.getCpfcnombre();
                    codigoProfesional = ""+profesionalAct.getCpfncodigo();
                    regProfesional = profesionalAct.getCpfcregmedic();
                     cargoProfesional = 
                            serviceLocator.getClinicoService().getDescripcionTipoEspecialidad(profesionalAct.getCpfntipoespe());
                    }
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                String nombreArchivo = "Impresion_Viniso";
                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/FO-GS-VE-004.jasper");
                URL url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);

                if (url != null) {
                    Map parameters = new HashMap();
                    parameters.put("IMAGEN",url_profamilia);

                    byte[] bytes;

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);
                    bytes = 
                            JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                    PdfServletUtils.showPdfDocument(bytes, 
                    nombreArchivo + 
                    Calendar.getInstance().getTimeInMillis() + ".pdf", 
                                                    false);
                    generoHistoria = true;
                    generoViniso = false;


                   

                }
            } catch (Exception e) {
                //generoReporte = false;
                e.printStackTrace();
                FacesUtils.addErrorMessage("No se genero el archivo " + 
                                           e.getMessage());
            }
        }
    }
    
    public void obtenerDatosReporteOtraAsesoria(Chasesoria asesoriaAux) {
        // Obtenemos los datos del usuario 
        resetDatosOtraAsesoria();

        if (asesoriaAux != null) {
            if (asesoriaAux.getHasdfechanacim() != null) {
                FECHA_NACIMIENTO = asesoriaAux.getHasdfechanacim();
            }

            if (asesoriaAux.getHasnedad() != null) {
                EDAD = asesoriaAux.getHasnedad();
            }

            if (getUsuarioSystem() != null) {
                IMPRIMIO = this.getUsuarioSystem().getCurcnombre();
            }

            if (asesoriaAux.getHascprimernomb() != null) {
                NOMBRE = asesoriaAux.getHascprimernomb() + " ";
            }
            if (asesoriaAux.getHascsegundnomb() != null && 
                !asesoriaAux.getHascsegundnomb().equals("_")) {
                NOMBRE = NOMBRE + asesoriaAux.getHascsegundnomb() + " ";
            }
            if (asesoriaAux.getHascprimerapel() != null) {
                NOMBRE = NOMBRE + asesoriaAux.getHascprimerapel() + " ";
            }
            if (asesoriaAux.getHascsegundapel() != null && 
                !asesoriaAux.getHascsegundapel().equals("_")) {
                NOMBRE = NOMBRE + asesoriaAux.getHascsegundapel();
            }
            if (asesoriaAux.getHasanumeiden() != null && 
                asesoriaAux.getHasanumeiden() != 0) {
                TIPO_DOCUMENTO = asesoriaAux.getHasetipoiden();
                NUMERO_DOCUMENTO = asesoriaAux.getHasanumeiden();
            }


            SEXO = asesoriaAux.getHasesexo();

            OBSERVACIONES = asesoriaAux.getHascobservacio();
            TIPO_ASESORIA = "";

            if (asesoriaAux != null) {
                if (asesoriaAux.getHaseplanitempo() != null && 
                    asesoriaAux.getHaseplanitempo().equals("S")) {
                    TIPO_ASESORIA = 
                            TIPO_ASESORIA + "PlanificaciNn Temporal" + "\n";
                }

                if (asesoriaAux.getHaseplanidefin() != null && 
                    asesoriaAux.getHaseplanidefin().equals("S")) {
                    TIPO_ASESORIA = 
                            TIPO_ASESORIA + "PlanificaciNn Definitiva " + "\n";
                }


                if (asesoriaAux.getHaseilve() != null && 
                    asesoriaAux.getHaseilve().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "ILVE " + "\n";
                }

                if (asesoriaAux.getHasediversexua() != null && 
                    asesoriaAux.getHasediversexua().equals("S")) {
                    TIPO_ASESORIA = 
                            TIPO_ASESORIA + "GNnero y diversidad sexual " + 
                            "\n";
                }


                if (asesoriaAux.getHasesexuaejerc() != null && 
                    asesoriaAux.getHasesexuaejerc().equals("S")) {
                    TIPO_ASESORIA = 
                            TIPO_ASESORIA + "Sexualidad y alteraciones relacionadas con el ejercicio " + 
                            "\n";
                }

                if (asesoriaAux.getHasevih() != null && 
                    asesoriaAux.getHasevih().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Pre y Pos VIH " + "\n";
                }


                if (asesoriaAux.getHaseits() != null && 
                    asesoriaAux.getHaseits().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "ITS " + "\n";
                }

                if (asesoriaAux.getHasevacunacion() != null && 
                    asesoriaAux.getHasevacunacion().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "VacunaciNn " + "\n";
                }

                if ((asesoriaAux.getHasepruebembar() != null && 
                     asesoriaAux.getHasepruebembar().equals("S")) || 
                    asesoriaAux.getHaseresulembar() != null) {
                    String resultado = "";

                    if (asesoriaAux.getHaseresulembar().equals("N")) {
                        resultado = " Negativo";
                    }

                    if (asesoriaAux.getHaseresulembar().equals("P")) {
                        resultado = " Positivo";
                    }

                    TIPO_ASESORIA = 
                            TIPO_ASESORIA + "Prueba de Embarazo (resultado) " + resultado + "\n";
                }

                if (asesoriaAux.getHascviolefisic() != null && 
                        asesoriaAux.getHascviolefisic().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Violencia Fisica " + "\n";
                }

                if (asesoriaAux.getHascviolepsico() != null && 
                    asesoriaAux.getHascviolepsico().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Violencia Psicologica " + "\n";
                }

                if (asesoriaAux.getHascviolesexua() != null && 
                    asesoriaAux.getHascviolesexua().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Violencia Sexual " + "\n";
                }

                if (asesoriaAux.getHaseotro() != null && 
                    asesoriaAux.getHaseotro().equals("S")) {
                    String cualOtro = "";

                    if (asesoriaAux.getHasccualotro() != null) {
                        cualOtro = asesoriaAux.getHasccualotro();
                    }

                    TIPO_ASESORIA = 
                            TIPO_ASESORIA + "Otro " + "Cual? " + cualOtro + 
                            "\n";
                    if (asesoriaAux.getHascoperador() != null) {
                        Cpprofesio profesional;
                        profesional = null;
                        try {
                            if (this.getClinica() != null) {
                                profesional = 
                                        serviceLocator.getClinicoService().getProfesionalPorUsuario(asesoriaAux.getHascoperador(), 
                                                                                                    asesoriaAux.getHasnclinic());
                            }

                        } catch (ModelException e) {
                            e.printStackTrace();
                        }

                        if (profesional != null) {
                            NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                            REGISTRO_MEDICO = profesional.getCpfcregmedic();
                            TIPOID_PROFESIONAL = profesional.getCpfctipide();
                            NUMID_PROFESIONAL = profesional.getCpfacedula();


                        }
                    }
                }

                TIPO_ASESORIA = TIPO_ASESORIA + "Se envia a: " + "\n";

                if (asesoriaAux.getHascenvplntem() != null && 
                    asesoriaAux.getHascenvplntem().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "AnticoncepciNn temporal " + "\n";
                }

                if (asesoriaAux.getHascenvplndef() != null && 
                    asesoriaAux.getHascenvplndef().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "AnticoncepciNn definitiva " + "\n";
                }

                if (asesoriaAux.getHascenvmedgen() != null && 
                    asesoriaAux.getHascenvmedgen().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Medicina general " + "\n";
                }

                if (asesoriaAux.getHascenvmedesp() != null && 
                    asesoriaAux.getHascenvmedesp().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Medicina especializada " + "\n";
                }

                if (asesoriaAux.getHascenvlabcli() != null && 
                    asesoriaAux.getHascenvlabcli().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Laboratorio clNnico " + "\n";
                }

                if (asesoriaAux.getHascenvproduc() != null && 
                    asesoriaAux.getHascenvproduc().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Productos " + "\n";
                }

            }


        }
    }
    
    private void resetDatosOtraAsesoria() {
        TIPO_DOCUMENTO = null;
        NUMERO_DOCUMENTO = null;
        IMPRIMIO = null;
        NOMBRE = null;
        FECHA_NACIMIENTO = null;
        EDAD = null;
        SEXO = null;
        OBSERVACIONES = null;
        TIPO_ASESORIA = null;
        NOMBRE_PROFESIONAL = null;
        REGISTRO_MEDICO = null;
    }
    
    
    public void imprimirAsesoria() {
        visualizarAsesorias = false;
        Chaseavise aseSelect;
        aseSelect = (Chaseavise)this.dtAsesoria.getRowData();
        if (aseSelect != null) {
            generarResumenAsesoria(aseSelect);
        }
    }
    
    public void visualizarAsesoria() {
        visualizarAsesorias = true;   
        Chaseavise aseSelect;
        aseSelect = (Chaseavise)this.dtAsesoria.getRowData();
        if (aseSelect != null) {
            generarResumenAsesoria(aseSelect);
        }
    }


    public void generarResumenAsesoria(Chaseavise asesoriaAux) {
        this.index = -1;
        lstReporte = new ArrayList<Chreporte>();
        JasperPrint jasperPrint;
        jasperPrint = null;
        renderFolio = false;
        generoHistoria = false;

        try {
            obtenerDatosReporteAsesoria(asesoriaAux);
            URL url = 
                FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteAsesoria.jasper");
            URL url_profamilia = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
            URL url_super_horizontal = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
            URL url_super_vertical = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
            ExternalContext externalContext = 
                FacesContext.getCurrentInstance().getExternalContext();
            HttpServletRequest request = 
                (HttpServletRequest)externalContext.getRequest();
                
            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                if (!visualizarAsesorias) {
                    byte[] bytes;

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);

                    bytes = 
                            JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);

                    PdfServletUtils.showPdfDocument(bytes, 
                                                    "Resumen_Asesoria" + ".pdf", 
                                                    false);
                    generoHistoria = true;
                } else {
                    JRHtmlExporter exporter = new JRHtmlExporter();

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);
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
                    exporter.setParameter(JRHtmlExporterParameter.HTML_FOOTER, 
                                          "");
                    exporter.setParameter(JRHtmlExporterParameter.HTML_HEADER, 
                                          "");

                    request.getSession().setAttribute("jasperPrint", 
                                                      jasperPrint);
                    renderFolio = true;

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }


    }
    
    public void obtenerDatosReporteAsesoria(Chaseavise asesoriaAux) {
        // Obtenemos los datos del usuario 
        resetDatos();

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
            RESPONSABLE = usuario.getHuscnomacompana();
            PARENTESCO_RESPONSABLE = usuario.getHuscparresponsa();
            TELEFONO_RESPONSABLE = usuario.getHusctelacompana();
            

        }


        if (asesoriaAux != null) {
        
            if(asesoriaAux.getHavnconavs()!= null){
                try {
                    CONOCIMIENTO_PROGRAMA = this.serviceLocator.getClinicoService().getDescripcionConocimientoAvise(asesoriaAux.getHavnconavs());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                
                if(asesoriaAux.getHavnconavs().equals(6)){
                    CUAL_CONOCIMIENTO = asesoriaAux.getHavcotrcon(); 
                }
            }


            if (asesoriaAux.getHavcusureg() != null) {
                Cpprofesio profesional;
                profesional = null;
                try {
                    if (this.getClinica() != null) {
                        profesional = 
                                serviceLocator.getClinicoService().getProfesionalPorUsuario(asesoriaAux.getHavcusureg(), 
                                                                                           asesoriaAux.getHavnclinic());
                    }

                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (profesional != null) {
                    NOMBRE_ASESOR = profesional.getCpfcnombre();
                    REGISTRO_MEDICO = profesional.getCpfcregmedic();
                    TIPOID_PROFESIONAL = profesional.getCpfctipide();
                    NUMID_PROFESIONAL = profesional.getCpfacedula();
                }
            }
            
            if(asesoriaAux.getId()!= null && asesoriaAux.getId().getHavdfecase()!= null){
                FECHA_ASESORIA = formatearCampo(asesoriaAux.getId().getHavdfecase()); 
            }
            
            if(asesoriaAux.getHavdfecreg() != null){
                FECHA_REGISTRO = formatearCampo(asesoriaAux.getHavdfecreg()); 
            }
            
            if(asesoriaAux.getHavnclinic() != null){
            Cpclinica clinAux  = null;
                try {
                    clinAux = this.serviceLocator.getClinicoService().getClinica(asesoriaAux.getHavnclinic());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                
                if(clinAux!= null){
                    CLINICA_ASESORIA = clinAux.getCclncodigo()+" "+clinAux.getCclcnombre(); 
                }
            }
            

            if (asesoriaAux != null) {
                if (asesoriaAux.getHavnintase() != null) {
                    try {
                        INTERVENCION_ASESORIA = 
                                serviceLocator.getClinicoService().getDescripcionIntervencionAsesoriaXid(asesoriaAux.getHavnintase());
                    } catch (ModelException e) {
                        e.printStackTrace();
                        ;
                    }
                }


                try {
                    if (asesoriaAux.getHavndetint() != null) {
                        TIPO_ASESORIA = 
                                serviceLocator.getClinicoService().getDescripcionIntervencionAsesoriaXid(asesoriaAux.getHavndetint());
                    }
                } catch (ModelException e) {
                    e.printStackTrace();
                }


                if (asesoriaAux.getHavcagrcon() != null && 
                    !asesoriaAux.getHavcagrcon().equals("")) {
                    AGRESOR_CONOCIDO = 
                            formatearCampo(asesoriaAux.getHavcagrcon());
                }
                
                if(asesoriaAux.getHavnrelagr()!= null){
                    try {
                        RELACION_AGRESOR =  this.serviceLocator.getClinicoService().getDescripcionRelacionFamiliarAvise(asesoriaAux.getHavnrelagr());
                    } catch (ModelException e) {
                       e.printStackTrace();
                    }
                    
                
                    if(asesoriaAux.getHavnparagr()!= null){
                            try {
                                PARENTESCO_AGRESOR = this.serviceLocator.getClinicoService().getDescripcionParentescoFamiliarAvise(asesoriaAux.getHavnparagr());
                            } catch (ModelException e) {
                                e.printStackTrace();
                            }
                        }
                        
                    if(asesoriaAux.getHavcotrrel()!= null){
                        CUAL_RELACION = formatearCampo(asesoriaAux.getHavcotrrel());
                    }
                    
                    if(asesoriaAux.getHavcotrpar() != null){
                        CUAL_PARENTESCO = formatearCampo(asesoriaAux.getHavcotrpar()); 
                    }
    
                }

              

                AREA_AFECTIVA = "";

                // AREA AFECTIVA 
                if (asesoriaAux.getHavetranqu() != null && 
                    asesoriaAux.getHavetranqu().equals("S")) {
                    AREA_AFECTIVA = "Tranquila" + ", ";
                }
                if (asesoriaAux.getHaveangust() != null && 
                    asesoriaAux.getHaveangust().equals("S")) {
                    AREA_AFECTIVA = AREA_AFECTIVA + "Angustiada" + ", ";
                }
                if (asesoriaAux.getHavetriste() != null && 
                    asesoriaAux.getHavetriste().equals("S")) {
                    AREA_AFECTIVA = AREA_AFECTIVA + "Triste" + ", ";
                }
                if (asesoriaAux.getHaveconfun() != null && 
                    asesoriaAux.getHaveconfun().equals("S")) {
                    AREA_AFECTIVA = AREA_AFECTIVA + "Confundida" + ", ";
                }


                if (asesoriaAux.getHavedesori() != null && 
                    asesoriaAux.getHavedesori().equals("S")) {
                    AREA_AFECTIVA = AREA_AFECTIVA + "Desorientada" + ", ";
                }

                if (asesoriaAux.getHaveansios() != null && 
                    asesoriaAux.getHaveansios().equals("S")) {
                    AREA_AFECTIVA = AREA_AFECTIVA + "Ansiosa" + ", ";
                }
                
                if (asesoriaAux.getHaveagotad() != null && 
                    asesoriaAux.getHaveagotad().equals("S")) {
                    AREA_AFECTIVA = AREA_AFECTIVA + "Agotada /cansada" + ", ";
                }

                if (asesoriaAux.getHavehostil() != null && 
                    asesoriaAux.getHavehostil().equals("S")) {
                    AREA_AFECTIVA = AREA_AFECTIVA + "Hostil" + ", ";
                }

                if (asesoriaAux.getHavedesesp() != null && 
                    asesoriaAux.getHavedesesp().equals("S")) {
                    AREA_AFECTIVA = AREA_AFECTIVA + "Desesperada" + ", ";
                }

                if (asesoriaAux.getHavedisfru() != null && 
                    asesoriaAux.getHavedisfru().equals("S")) {
                    AREA_AFECTIVA = 
                            AREA_AFECTIVA + "Anedonia" + ", ";
                }

                if (asesoriaAux.getHavesendes() != null && 
                    asesoriaAux.getHavesendes().equals("S")) {
                    AREA_AFECTIVA = 
                            AREA_AFECTIVA + "Sentimientos de desesperanza" + 
                            ", ";
                }
                if (asesoriaAux.getHaveimpote() != null && 
                    asesoriaAux.getHaveimpote().equals("S")) {
                    AREA_AFECTIVA = AREA_AFECTIVA + "Impotencia" + ", ";
                }

              

                if (AREA_AFECTIVA != null && !AREA_AFECTIVA.equals("")) {
                    AREA_AFECTIVA = 
                            AREA_AFECTIVA.substring(0, AREA_AFECTIVA.length() - 
                                                    2);
                } else {
                    AREA_AFECTIVA = "Sin Alteraciones Aparentes";
                }


                AREA_SOMATICA = "";

                // AREA SOMATICA
                if (asesoriaAux.getHavedolor() != null && 
                    asesoriaAux.getHavedolor().equals("S")) {
                    AREA_SOMATICA = "Dolor" + ", ";
                }

                if (asesoriaAux.getHavehemato() != null && 
                    asesoriaAux.getHavehemato().equals("S")) {
                    AREA_SOMATICA = AREA_SOMATICA + "Hematoma / equimosis" + ", ";
                }


                if (asesoriaAux.getHavefractu() != null && 
                    asesoriaAux.getHavefractu().equals("S")) {
                    AREA_SOMATICA = AREA_SOMATICA + "Fractura" + ", ";
                }

                if (asesoriaAux.getHaveinsomn() != null && 
                    asesoriaAux.getHaveinsomn().equals("S")) {
                    AREA_SOMATICA = 
                            AREA_SOMATICA + "AlteraciNn del sueNo" + ", ";
                }

                if (asesoriaAux.getHaveinapet() != null && 
                    asesoriaAux.getHaveinapet().equals("S")) {
                    AREA_SOMATICA = 
                            AREA_SOMATICA + "AlteraciNn del apetito" + ", ";
                }

                if (asesoriaAux.getHavesendeb() != null && 
                    asesoriaAux.getHavesendeb().equals("S")) {
                    AREA_SOMATICA = AREA_SOMATICA + "Debilidad" + ", ";
                }


                if (asesoriaAux.getHavemareo() != null && 
                    asesoriaAux.getHavemareo().equals("S")) {
                    AREA_SOMATICA = AREA_SOMATICA + "Mareos" + ", ";
                }

                if (asesoriaAux.getHavehipera() != null && 
                    asesoriaAux.getHavehipera().equals("S")) {
                    AREA_SOMATICA = AREA_SOMATICA + "Hiperactividad" + ", ";
                }

                if (asesoriaAux.getHaveahogo() != null && 
                    asesoriaAux.getHaveahogo().equals("S")) {
                    AREA_SOMATICA = 
                            AREA_SOMATICA + "Ahogo/falta de aire" + ", ";
                }

                if (asesoriaAux.getHavepalpi() != null && 
                    asesoriaAux.getHavepalpi().equals("S")) {
                    AREA_SOMATICA = AREA_SOMATICA + "Palpitaciones" + ", ";
                }

                if (AREA_SOMATICA != null && !AREA_SOMATICA.equals("")) {
                    AREA_SOMATICA = 
                            AREA_SOMATICA.substring(0, AREA_SOMATICA.length() - 
                                                    2);
                } else {
                    AREA_SOMATICA = "Sin Alteraciones Aparentes";
                }


                AREA_RELACIONAL = "";

                // AREA AREA_RELACIONAL
                if (asesoriaAux.getHaveagresi() != null && 
                    asesoriaAux.getHaveagresi().equals("S")) {
                    AREA_RELACIONAL = "Agresividad" + ", ";
                }

                if (asesoriaAux.getHaveaislam() != null && 
                    asesoriaAux.getHaveaislam().equals("S")) {
                    AREA_RELACIONAL = AREA_RELACIONAL + "Aislamiento" + ", ";
                }

                if (asesoriaAux.getHavepasmad() != null && 
                    asesoriaAux.getHavepasmad().equals("S")) {
                    AREA_RELACIONAL = AREA_RELACIONAL + "Pasmada " + ", ";
                }

                if (asesoriaAux.getHavereftem() != null && 
                    asesoriaAux.getHavereftem().equals("S")) {
                    AREA_RELACIONAL = AREA_RELACIONAL + "Fobia " + ", ";
                }


                if (asesoriaAux.getHavepareja() != null && 
                    asesoriaAux.getHavepareja().equals("S")) {
                    AREA_RELACIONAL = 
                            AREA_RELACIONAL + "Conflicto con la pareja " + ", ";
                }
                if (asesoriaAux.getHavefamili() != null && 
                    asesoriaAux.getHavefamili().equals("S")) {
                    AREA_RELACIONAL = 
                            AREA_RELACIONAL + "Conflicto con la familia " + 
                            ", ";
                }
                if (asesoriaAux.getHavedesamp() != null && 
                    asesoriaAux.getHavedesamp().equals("S")) {
                    AREA_RELACIONAL = AREA_RELACIONAL + "Desamparo " + ", ";
                }
                if (asesoriaAux.getHavepobrez() != null && 
                    asesoriaAux.getHavepobrez().equals("S")) {
                    AREA_RELACIONAL = AREA_RELACIONAL + "Pobreza " + ", ";
                }
                if (asesoriaAux.getHaveviolen() != null && 
                    asesoriaAux.getHaveviolen().equals("S")) {
                    AREA_RELACIONAL = AREA_RELACIONAL + "Violencia " + ", ";
                }
                if (asesoriaAux.getHavedesemp() != null && 
                    asesoriaAux.getHavedesemp().equals("S")) {
                    AREA_RELACIONAL = AREA_RELACIONAL + "Desempleo " + ", ";
                }

                if (AREA_RELACIONAL != null && !AREA_RELACIONAL.equals("")) {
                    AREA_RELACIONAL = 
                            AREA_RELACIONAL.substring(0, AREA_RELACIONAL.length() - 
                                                      2);
                } else {
                    AREA_RELACIONAL = "Sin Alteraciones Aparentes";
                }


                AREA_COGNITIVA = "";

                // AREA AREA_COGNITIVA
                if (asesoriaAux.getHavedisper() != null && 
                    asesoriaAux.getHavedisper().equals("S")) {
                    AREA_COGNITIVA = "Dispersa / desorientada" + ", ";
                }

                if (asesoriaAux.getHavepenneg() != null && 
                    asesoriaAux.getHavepenneg().equals("S")) {
                    AREA_COGNITIVA = 
                            AREA_COGNITIVA + "Pensamientos negativos frecuentes" + 
                            ", ";
                }

                if (asesoriaAux.getHavedifpro() != null && 
                    asesoriaAux.getHavedifpro().equals("S")) {
                    AREA_COGNITIVA = 
                            AREA_COGNITIVA + "Dificultad para resolver problemas" + 
                            ", ";
                }


                if (asesoriaAux.getHaveideper() != null && 
                    asesoriaAux.getHaveideper().equals("S")) {
                    AREA_COGNITIVA = 
                            AREA_COGNITIVA + "Ideas de persecuciNn" + ", ";
                }

                if (asesoriaAux.getHaveincme() != null && 
                    asesoriaAux.getHaveincme().equals("S")) {
                    AREA_COGNITIVA = 
                            AREA_COGNITIVA + "Incapacidad mental" + ", ";
                }


                if (asesoriaAux.getHavedificu() != null && 
                    asesoriaAux.getHavedificu().equals("S")) {
                    AREA_COGNITIVA = 
                            AREA_COGNITIVA + "Dificultad para tomar decisiones" + 
                            ", ";
                }
                if (asesoriaAux.getHaveconcen() != null && 
                    asesoriaAux.getHaveconcen().equals("S")) {
                    AREA_COGNITIVA = 
                            AREA_COGNITIVA + "Falta de concentraciNn " + ", ";
                }
                if (asesoriaAux.getHavesuicid() != null && 
                    asesoriaAux.getHavesuicid().equals("S")) {
                    AREA_COGNITIVA = AREA_COGNITIVA + "ideaciNn suicida" + ", ";
                }

                if (asesoriaAux.getHaveotro() != null && 
                    asesoriaAux.getHaveotro().equals("S")) {
                    AREA_COGNITIVA = AREA_COGNITIVA + " Otro" + ", ";
                }

                if (AREA_COGNITIVA != null && !AREA_COGNITIVA.equals("")) {
                    AREA_COGNITIVA = 
                            AREA_COGNITIVA.substring(0, AREA_COGNITIVA.length() - 
                                                    2);
                } else {
                    AREA_COGNITIVA = "Sin AlteraciNn Aparentes";
                }

                DOCUMENTOS_PRESENTADOS = "";
                DOCUMENTO_OTRO = "";
                DOCUMENTOS_REMISION_INSTITUCION = "";

                if (asesoriaAux.getHavcnindoc() != null && 
                    asesoriaAux.getHavcnindoc().equals("S")) {
                    DOCUMENTOS_PRESENTADOS = "Ninguno";
                }

                if (asesoriaAux.getHavedocden() != null && 
                    asesoriaAux.getHavedocden().equals("S")) {
                    DOCUMENTOS_PRESENTADOS = "Denuncia" + ",";
                }

                if (asesoriaAux.getHavepruemb() != null && 
                    asesoriaAux.getHavepruemb().equals("S")) {
                    DOCUMENTOS_PRESENTADOS = 
                            DOCUMENTOS_PRESENTADOS + "Prueba de Embarazo" + 
                            ",";
                }

                if (asesoriaAux.getHavevalps() != null && 
                    asesoriaAux.getHavevalps().equals("S")) {
                    DOCUMENTOS_PRESENTADOS = 
                            DOCUMENTOS_PRESENTADOS + "ValoraciNn PsicolNgica" + 
                            ",";
                }

                if (asesoriaAux.getHavecerme() != null && 
                    asesoriaAux.getHavecerme().equals("S")) {
                    DOCUMENTOS_PRESENTADOS = 
                            DOCUMENTOS_PRESENTADOS + "Certificado MNdico" + 
                            ",";
                }

                if (asesoriaAux.getHavedoceco() != null && 
                    asesoriaAux.getHavedoceco().equals("S")) {
                    DOCUMENTOS_PRESENTADOS = 
                            DOCUMENTOS_PRESENTADOS + "EcografNa" + ",";
                }

                if (asesoriaAux.getHavcrecotr() != null && 
                    asesoriaAux.getHavcrecotr().equals("S")) {
                    DOCUMENTOS_REMISION_INSTITUCION = 
                            "RemisiNn de otra instituciNn: " + 
                            formatearCampo(asesoriaAux.getHavcrecnom());
                }

                if (asesoriaAux.getHaveotrdoc() != null && 
                    asesoriaAux.getHaveotrdoc().equals("S")) {
                    DOCUMENTO_OTRO = 
                            "Otro: " + formatearCampo(asesoriaAux.getHavcnomdoc());
                }

                HALLAZGOS = "";

                if (asesoriaAux.getHavcconclu() != null && 
                    !asesoriaAux.getHavcconclu().equals("")) {
                    HALLAZGOS = formatearCampo(asesoriaAux.getHavcconclu());
                }
                
                CONCEPTO_PSICOLOGICO =""; 
                
                if (asesoriaAux.getHavcconpsi() != null && 
                    !asesoriaAux.getHavcconpsi().equals("")) {
                    CONCEPTO_PSICOLOGICO = formatearCampo(asesoriaAux.getHavcconpsi());
                }
                
                
                INTERVENCION_CRISIS = formatearCampo(asesoriaAux.getHavcintcri()); 

                CONDUCTA = "";

               if (asesoriaAux.getHavcremilv() != null && 
                    asesoriaAux.getHavcremilv().equals("S")) {
                    CONDUCTA = CONDUCTA + "Opta ILVE Institucional" + ",";
                }


                

                if (asesoriaAux.getHavcremind() != null && 
                    asesoriaAux.getHavcremind().equals("S")) {
                    CONDUCTA = CONDUCTA + "IndecisiNn" + ",";
                }

                if (asesoriaAux.getHavcremcos() != null && 
                    asesoriaAux.getHavcremcos().equals("S")) {
                    CONDUCTA = CONDUCTA + "Capacidad de pago limitada" + ",";
                }

                if (asesoriaAux.getHavcremeps() != null && 
                    asesoriaAux.getHavcremeps().equals("S")) {
                    CONDUCTA = CONDUCTA + "Va a usar EPS" + ",";
                }

                if (asesoriaAux.getHavcremips() != null && 
                    asesoriaAux.getHavcremips().equals("S")) {
                    CONDUCTA = CONDUCTA + "Va a usar otra I.P.S" + ",";
                }

                if (asesoriaAux.getHavcremcau() != null && 
                    asesoriaAux.getHavcremcau().equals("S")) {
                    CONDUCTA = CONDUCTA + "No aplica causal" + ",";
                }

                if (asesoriaAux.getHavcremmay() != null && 
                    asesoriaAux.getHavcremmay().equals("S")) {
                    CONDUCTA = CONDUCTA + "RemisiNn por edad gestacional" + ",";
                    
                    if(asesoriaAux.getHavnedages()!= null){
                        CONDUCTA = CONDUCTA + "CuNntas semanas: "+formatearCampo(asesoriaAux.getHavnedages())+ ",";
                    }
                }

                if (asesoriaAux.getHavcremcon() != null && 
                    asesoriaAux.getHavcremcon().equals("S")) {
                    CONDUCTA = CONDUCTA + "Desea continuar embarazo" + ",";
                }

                if (asesoriaAux.getHavcremotr() != null && 
                    asesoriaAux.getHavcremotr().equals("S")) {
                    CONDUCTA = CONDUCTA + "Otro" + ",";
                    if(asesoriaAux.getHavcnmbotr()!= null){
                        CONDUCTA = CONDUCTA + " Cual? "+formatearCampo(asesoriaAux.getHavcnmbotr())+ ",";
                    }
                }
                
                
                if (asesoriaAux.getHavcremapl() != null && 
                    asesoriaAux.getHavcremapl().equals("S")) {
                    CONDUCTA = CONDUCTA + "   Aplaza la decisiNn" + ",";
                    if(asesoriaAux.getHavcremmot()!= null){
                        CONDUCTA = CONDUCTA + "Motivo? "+formatearCampo(asesoriaAux.getHavcremmot())+ ",";
                    }
                }


                if (CONDUCTA != null && !CONDUCTA.equals("")) {
                    CONDUCTA = CONDUCTA.substring(0, CONDUCTA.length() - 1);
                } else {
                    CONDUCTA = "Ninguna";
                }
              
            
          

               

                if (asesoriaAux.getHnseguavis() != null && 
                    !asesoriaAux.getHnseguavis().isEmpty()) {

                    Iterator it = asesoriaAux.getHnseguavis().iterator();
                    SEGUIMIENTO = "";

                    while (it.hasNext()) {
                        Chseguavis seguiAux = (Chseguavis)it.next();

        
                                
                           StringBuffer sb = new StringBuffer(); 
                        sb.append("Fecha del seguimiento: " + formatearCampo(seguiAux.getHsadfecreg()) ); 
                        sb.append("\n" + "Asesor: " + seguiAux.getHsacasesor());     
                        if(seguiAux.getHsansemest() != null){
                            sb.append("\n" + "Semanas estimadas: " + formatearCampo(seguiAux.getHsansemest()));     
                        }
                        
                        if(seguiAux.getHsadfececo() != null){
                            sb.append("\n" + "Fecha Ecografia: " + formatearCampo(seguiAux.getHsadfececo())); 
                        }
                        
                        if(seguiAux.getHsansemeco() != null){
                            sb.append("\n" + "Semanas Ecografia: " + formatearCampo(seguiAux.getHsansemeco())); 
                        }
                        
                        if(seguiAux.getHsacmetant() != null){
                            sb.append("\n" + "Metodo de AnticoncepciNn: " + formatearCampo(seguiAux.getHsacmetant())); 
                        }
                        
                        if(seguiAux.getHsaccousan() != null && seguiAux.getHsaccousan().equals("N")){
                            sb.append("\n" + "Confirma Procedimiento Institucional: " + formatearCampo(seguiAux.getHsaccousan())); 
                            if(seguiAux.getHsacotrins() != null){
                                sb.append("     Cual InstituciNn: ").append( seguiAux.getHsacotrins());    
                            }
                            
                            
                        }
                        
                        
                        if(seguiAux.getHsaccousan() != null && seguiAux.getHsaccousan().equals("S")){
                            sb.append("\n" + "Confirma Procedimiento Institucional: " + formatearCampo(seguiAux.getHsaccousan())  ); 
                        }
                        
                        if(seguiAux.getHsacseguim() != null){
                            sb.append("\n" +"Seguimiento: " + seguiAux.getHsacseguim()); 
                        }
                            sb.append("\n" + "AcciNn: " + obtenerAccion(seguiAux) + "\n"); 
                        
                        
                        sb.append("\n"); 

                                
                        SEGUIMIENTO = 
                                SEGUIMIENTO + sb.toString(); 
                    }
                }


                if (asesoriaAux.getHavnlugech() != null) {
                    try {
                        LUGAR_HECHOS = 
                                this.serviceLocator.getClinicoService().getDescripcionLugarHechosAvise(asesoriaAux.getHavnlugech());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                }

                if (asesoriaAux.getHavcotrlug() != null && 
                    !asesoriaAux.getHavcotrlug().equals("")) {
                    CUAL_LUGAR = formatearCampo(asesoriaAux.getHavcotrlug());
                }

                if (asesoriaAux.getHavntieocu() != null) {
                    try {
                        TIEMPO_OCURRENCIA = 
                                this.serviceLocator.getClinicoService().getDescripcionTiempoHechosAvise(asesoriaAux.getHavntieocu());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    
                    if(asesoriaAux.getHavndiaeve() != null){
                        OTRO_TIEMPO = formatearCampo(asesoriaAux.getHavndiaeve()); 
                    }
                }
                ACCIONES_PREVIAS = "";
                if (asesoriaAux.getHavcaccnin() != null && 
                    asesoriaAux.getHavcaccnin().equals("S")) {
                    ACCIONES_PREVIAS = "Ninguna" + ",";
                }

                if (asesoriaAux.getHavcaccden() != null && 
                    asesoriaAux.getHavcaccden().equals("S")) {
                    ACCIONES_PREVIAS = 
                            ACCIONES_PREVIAS + " Denuncia Penal " + ",";
                }

                if (asesoriaAux.getHavcaccate() != null && 
                    asesoriaAux.getHavcaccate().equals("S")) {
                    ACCIONES_PREVIAS = 
                            ACCIONES_PREVIAS + " Busco atenciNn mNdica " + ",";
                }
                
                
                if (asesoriaAux.getHaveantem() != null && 
                    asesoriaAux.getHaveantem().equals("S")) {
                    ACCIONES_PREVIAS = 
                            ACCIONES_PREVIAS + " UsN anticoncepciNn de emergencia " + ",";
                }

                if (asesoriaAux.getHavcaccapo() != null && 
                    asesoriaAux.getHavcaccapo().equals("S")) {
                    ACCIONES_PREVIAS = 
                            ACCIONES_PREVIAS + " Busco apoyo de otra persona " + 
                            ",";
                }

              

                if (asesoriaAux.getHaveaccot() != null && 
                    asesoriaAux.getHaveaccot().equals("S")) {
                    ACCIONES_PREVIAS = ACCIONES_PREVIAS + " Otro ";
                    
                    CUAL_ACCION_PREVIA = "Cual: " +  formatearCampo(asesoriaAux.getHavcotracc()); 
                    
                    ACCIONES_PREVIAS = ACCIONES_PREVIAS + CUAL_ACCION_PREVIA + ","; 
                }

                if (ACCIONES_PREVIAS != null && !ACCIONES_PREVIAS.equals("")) {
                    ACCIONES_PREVIAS = 
                            ACCIONES_PREVIAS.substring(0, ACCIONES_PREVIAS.length() - 
                                                       1);
                }


            }


        }

        setDatos(asesoriaAux);

    }
    
    public void resetDatosAsesoria() {
    
        FECHA_ASESORIA = null; 
        FECHA_REGISTRO = null; 
        NOMBRE_ASESOR = null; 
        CLINICA_ASESORIA = null; 
        TIPO_DOCUMENTO = null;
        NUMERO_DOCUMENTO = null;
        IMPRIMIO = null;
        NOMBRE = null;
        FECHA_NACIMIENTO = null;
        EDAD = null;
        SEXO = null;
        DIRECCION = null;
        TELEFONO = null;
        CIUDAD = null;
        OCUPACION = null;
        ESTADO_CIVIL = null;
        RESPONSABLE = null;
        PARENTESCO_RESPONSABLE = null;
        TELEFONO_RESPONSABLE = null;
        FECHA_CONSULTA = null;
        NOMBRE_PROFESIONAL = null;
        REGISTRO_MEDICO = null;
        CENTRO = null;
        EPS = null;

        INTERVENCION_ASESORIA = null;
        AREA_AFECTIVA = null;
        AREA_SOMATICA = null;
        AREA_RELACIONAL = null;
        AREA_COGNITIVA = null;

        DOCUMENTOS_PRESENTADOS = null;
        DOCUMENTOS_REMISION_INSTITUCION = null;
        DOCUMENTO_OTRO = null;
        HALLAZGOS = null;
        INTERVENCION_CRISIS = null; 
        CONDUCTA = null;

    
        SEGUIMIENTO = null;
        AGRESOR_CONOCIDO = null;

        LUGAR_HECHOS = null;
        CUAL_LUGAR = null;
        TIEMPO_OCURRENCIA = null;

        TIPO_ASESORIA = null;
        
        CUAL_CONOCIMIENTO = null; 
        CONOCIMIENTO_PROGRAMA = null; 
        
        AGRESOR_CONOCIDO = null;
        RELACION_AGRESOR = null; 
        PARENTESCO_AGRESOR = null; 
        CUAL_PARENTESCO = null; 
        CUAL_RELACION = null; 
        OTRO_TIEMPO = null; 
    }
    
    public void setDatos(Chaseavise asesoriaAux) {

        if (asesoriaAux != null) {
        
        
            String s = "Asesor: " +  NOMBRE_ASESOR;
            String s2 = "ClNnica:  " + CLINICA_ASESORIA;
            
            String s3 = "";
            String s4 = ""; 

            Chreporte report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Datos AsesorNa");
            report.setHrenconsulta(new Long(0));
            report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
            report.setHrencodigo(imp_datos_asesoria);
            lstReporte.add(report);
            
            
            s = "Fecha AsesorNa: " + FECHA_ASESORIA;
            s2 = "Fecha Registro: " + FECHA_REGISTRO;
            s3 = "";
            s4 = ""; 
            
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Datos AsesorNa");
            report.setHrenconsulta(new Long(0));
            report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
            report.setHrencodigo(imp_datos_asesoria);
            lstReporte.add(report);
            
            
        
             s = "Conocimiento del programa:  " + CONOCIMIENTO_PROGRAMA;
             s2 = "CNal? " + CUAL_CONOCIMIENTO;
             s3 = "";
             s4 = ""; 

             report = new Chreporte();
            report.setHrecdescripcio(s);
            if (CUAL_CONOCIMIENTO != null && !CUAL_CONOCIMIENTO.equals("")) {
                report.setHrecdescripcio2(s2);
            }

            report.setHrentipoimpres(2);
            report.setHrectipodescri("Conocimiento del Programa");
            report.setHrenconsulta(new Long(0));
            report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
            report.setHrencodigo(imp_conocimiento_programa);
            lstReporte.add(report);

             s = "IntervenciNn AsesorNa:  " + INTERVENCION_ASESORIA;
            

            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrentipoimpres(1);
            report.setHrectipodescri("IntervenciNn AsesorNa");
            report.setHrenconsulta(new Long(0));
            report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
            report.setHrencodigo(imp_intervencion_asesoria);
            lstReporte.add(report);
            
            
          
            s = "Tipo de Intervencion: " + TIPO_ASESORIA;
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrentipoimpres(1);
            report.setHrectipodescri("IntervenciNn AsesorNa");
            report.setHrenconsulta(new Long(0));
            report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
            report.setHrencodigo(imp_intervencion_asesoria);
            lstReporte.add(report);


            if (AGRESOR_CONOCIDO != null && !AGRESOR_CONOCIDO.equals("")) {
                report = new Chreporte();
                s = "Agresor/a Conocido:  " + AGRESOR_CONOCIDO;
                s2 = "RelaciNn: " +RELACION_AGRESOR; 
                
                if(PARENTESCO_AGRESOR!= null && !PARENTESCO_AGRESOR.equals("")){
                    s3 = "Parentesco: " + PARENTESCO_AGRESOR; 
                }else if(CUAL_RELACION != null && !CUAL_RELACION.equals("")){
                    s3 = "Cual RelaciNn? " + CUAL_RELACION; 
                }
               
                s4 = "Cual? " + CUAL_PARENTESCO; 
              
                report = new Chreporte();
                report.setHrentipoimpres(4);
                report.setHrecdescripcio(s);
                if(RELACION_AGRESOR!= null && !RELACION_AGRESOR.equals("")){
                    report.setHrecdescripcio2(s2);    
                }
               
                if((PARENTESCO_AGRESOR!= null && !PARENTESCO_AGRESOR.equals("")) ||(CUAL_RELACION!= null && !CUAL_RELACION.equals("")) ){
                    report.setHrecdescripcio3(s3);
                }
                if(CUAL_PARENTESCO!= null && !CUAL_PARENTESCO.equals("")){
                    report.setHrecdescripcio4(s4);
                }
                
                report.setHrectipodescri("IntervenciNn AsesorNa");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_intervencion_asesoria);
                lstReporte.add(report);
            }


            if (LUGAR_HECHOS != null && !LUGAR_HECHOS.equals("")) {
                report = new Chreporte();
                s = "Lugar de los hechos:  " + LUGAR_HECHOS;
                s2 = "CuNl? " + CUAL_LUGAR;
                report.setHrecdescripcio(s);
                if (CUAL_LUGAR != null && !CUAL_LUGAR.equals("")) {
                    report.setHrecdescripcio2(s2);
                }

                report.setHrentipoimpres(2);
                report.setHrectipodescri("IntervenciNn AsesorNa");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_intervencion_asesoria);
                lstReporte.add(report);
            }

            if (TIEMPO_OCURRENCIA != null && !TIEMPO_OCURRENCIA.equals("")) {
                report = new Chreporte();
                s = "Tiempo de Ocurrencia:  " + TIEMPO_OCURRENCIA;
                s2 = "Cuantos (dNas) : "+ OTRO_TIEMPO; 
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(2);
                if(OTRO_TIEMPO!= null && !OTRO_TIEMPO.equals("")){
                    report.setHrecdescripcio2(s2);    
                }
                report.setHrectipodescri("IntervenciNn AsesorNa");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_intervencion_asesoria);
                lstReporte.add(report);
            }

            if (ACCIONES_PREVIAS != null && !ACCIONES_PREVIAS.equals("")) {
                report = new Chreporte();
                s = "Acciones previas:  " + ACCIONES_PREVIAS;
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(1);
                report.setHrectipodescri("IntervenciNn AsesorNa");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_intervencion_asesoria);
                lstReporte.add(report);
            }


            report = new Chreporte();
            s = "Area Afectiva:  " + AREA_AFECTIVA;
            report.setHrecdescripcio(s);
            report.setHrentipoimpres(1);
            report.setHrectipodescri("ValoraciNn estado psicoemocional de la usuaria por esferas");
            report.setHrenconsulta(new Long(0));
            report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
            report.setHrencodigo(imp_estado_psicoemocional);
            lstReporte.add(report);

            report = new Chreporte();
            s = "Area SomNtica:  " + AREA_SOMATICA;
            report.setHrecdescripcio(s);
            report.setHrentipoimpres(1);
            report.setHrectipodescri("ValoraciNn estado psicoemocional de la usuaria por esferas");
            report.setHrenconsulta(new Long(0));
            report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
            report.setHrencodigo(imp_estado_psicoemocional);
            lstReporte.add(report);

            report = new Chreporte();
            s = "Area Relacional/Social:  " + AREA_RELACIONAL;
            report.setHrecdescripcio(s);
            report.setHrentipoimpres(1);
            report.setHrectipodescri("ValoraciNn estado psicoemocional de la usuaria por esferas");
            report.setHrenconsulta(new Long(0));
            report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
            report.setHrencodigo(imp_estado_psicoemocional);
            lstReporte.add(report);

            report = new Chreporte();
            s = "Area Cognitiva:  " + AREA_COGNITIVA;
            report.setHrecdescripcio(s);
            report.setHrentipoimpres(1);
            report.setHrectipodescri("ValoraciNn estado psicoemocional de la usuaria por esferas");
            report.setHrenconsulta(new Long(0));
            report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
            report.setHrencodigo(imp_estado_psicoemocional);
            lstReporte.add(report);


            if (DOCUMENTOS_PRESENTADOS != null && 
                !DOCUMENTOS_PRESENTADOS.equals("")) {
                s = DOCUMENTOS_PRESENTADOS;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(1);
                report.setHrectipodescri("Documentos Presentados");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_documentos_presentados);
                lstReporte.add(report);
            }

            if (DOCUMENTOS_REMISION_INSTITUCION != null && 
                !DOCUMENTOS_REMISION_INSTITUCION.equals("")) {
                s = DOCUMENTOS_REMISION_INSTITUCION;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(1);
                report.setHrectipodescri("Documentos Presentados");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_documentos_presentados);
                lstReporte.add(report);
            }

            if (DOCUMENTO_OTRO != null && !DOCUMENTO_OTRO.equals("")) {
                s = DOCUMENTO_OTRO;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(1);
                report.setHrectipodescri("Documentos Presentados");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_documentos_presentados);
                lstReporte.add(report);
            }

            if (HALLAZGOS != null && !HALLAZGOS.equals("")) {
                s = HALLAZGOS;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(1);
                report.setHrectipodescri("Hallazgos");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_hallazgos);
                lstReporte.add(report);
            }
            
            if (CONCEPTO_PSICOLOGICO != null && !CONCEPTO_PSICOLOGICO.equals("")) {
                s = CONCEPTO_PSICOLOGICO;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(1);
                report.setHrectipodescri("Concepto Psicologico");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_concepto_psicologico);
                lstReporte.add(report);
            }
            
            if(INTERVENCION_CRISIS!= null && !INTERVENCION_CRISIS.equals("")){
               s = "Se realizo intervenciNn en crisis:  "  + INTERVENCION_CRISIS; 
               
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(1);
                report.setHrectipodescri("Hallazgos");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_hallazgos);
                lstReporte.add(report);
            }

            if (CONDUCTA != null && !CONDUCTA.equals("")) {


                s = "Remisiones: " + CONDUCTA;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(1);
                report.setHrectipodescri("Conducta");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_conducta_a_seguir);
                lstReporte.add(report);
            }




            if (SEGUIMIENTO != null && !SEGUIMIENTO.equals("")) {
                s = SEGUIMIENTO;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(1);
                report.setHrectipodescri("Seguimiento");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_seguimiento);
                lstReporte.add(report);
            }


        } else {
            Chreporte report = new Chreporte();
            String s = "No se encontrarNn folios ";

            report.setHrecdescripcio(s);
            report.setHrencodigo(0);
            lstReporte.add(report);
        }

    }
    
    private String obtenerAccion(Chseguavis seguiAux){
        String accion = "";

        if (seguiAux.getHsacremilv() != null &&
            seguiAux.getHsacremilv().equals("S")) {
            accion = accion + "Opta ILVE Institucional" + ",";
        }


        

        if (seguiAux.getHsacremind() != null && 
            seguiAux.getHsacremind().equals("S")) {
            accion = accion + "IndecisiNn" + ",";
        }

        if (seguiAux.getHsacremcos() != null && 
            seguiAux.getHsacremcos().equals("S")) {
            accion = accion + "Capacidad de pago limitada" + ",";
        }

        if (seguiAux.getHsacremeps() != null && 
            seguiAux.getHsacremeps().equals("S")) {
            accion = accion + "Va a usar EPS" + ",";
        }

        if (seguiAux.getHsacremips() != null && 
            seguiAux.getHsacremips().equals("S")) {
            accion = accion + "Va a usar otra I.P.S" + ",";
        }

        if (seguiAux.getHsacremcau() != null && 
            seguiAux.getHsacremcau().equals("S")) {
            accion = accion + "No aplica causal" + ",";
        }

        if (seguiAux.getHsacremmay() != null && 
            seguiAux.getHsacremmay().equals("S")) {
            accion = accion + "RemisiNn por edad gestacional" + ",";
            
            if(seguiAux.getHsanedages()!= null){
                accion = accion + "CuNntas semanas: "+formatearCampo(seguiAux.getHsanedages())+ ",";
            }
        }

        if (seguiAux.getHsacremcon() != null && 
            seguiAux.getHsacremcon().equals("S")) {
            accion = accion + "Desea continuar embarazo" + ",";
        }

        if (seguiAux.getHsacremotr() != null && 
            seguiAux.getHsacremotr().equals("S")) {
            accion = accion + "Otro" + ",";
            if(seguiAux.getHsacnmbotr()!= null){
                accion = accion + " Cual? "+formatearCampo(seguiAux.getHsacnmbotr())+ ",";
            }
        }
        
        
        if (seguiAux.getHsacremapl() != null && 
            seguiAux.getHsacremapl().equals("S")) {
            accion = accion + "   Aplaza la decisiNn" + ",";
            if(seguiAux.getHsacremmot()!= null){
                accion = accion + "Motivo? "+formatearCampo(seguiAux.getHsacremmot())+ ",";
            }
        }


        if (accion  != null && !accion.equals("")) {
            accion = accion.substring(0, accion.length() - 1);
        } else {
            accion = "Ninguna";
        }
        
        return accion; 
    }

    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }

    public String getUrlString() {
        return urlString;
    }

    public void setRenderConsulta(boolean renderConsulta) {
        this.renderConsulta = renderConsulta;
    }

    public boolean isRenderConsulta() {
        return renderConsulta;
    }

    public void setCausaExterna(String causaExterna) {
        this.causaExterna = causaExterna;
    }

    public String getCausaExterna() {
        return causaExterna;
    }

    public void setFinalidadIve(String finalidadIve) {
        this.finalidadIve = finalidadIve;
    }

    public String getFinalidadIve() {
        return finalidadIve;
    }

    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }

    public void setToleranText(String toleranText) {
        this.toleranText = toleranText;
    }

    public String getToleranText() {
        return toleranText;
    }

    public void setPresePosteri(String presePosteri) {
        this.presePosteri = presePosteri;
    }

    public String getPresePosteri() {
        return presePosteri;
    }

    public void setCantisang(String cantisang) {
        this.cantisang = cantisang;
    }

    public String getCantisang() {
        return cantisang;
    }


    public void setLtscausaExternaa(List<Crcausaext> ltscausaExternaa) {
        this.ltscausaExternaa = ltscausaExternaa;
    }

    public List<Crcausaext> getLtscausaExternaa() {
        return ltscausaExternaa;
    }

    public void setLstfinalidad(List<Crfinalcon> lstfinalidad) {
        this.lstfinalidad = lstfinalidad;
    }

    public List<Crfinalcon> getLstfinalidad() {
        return lstfinalidad;
    }

    public void setRegistrosEnfermeriaByte(byte[] registrosEnfermeriaByte) {
        this.registrosEnfermeriaByte = registrosEnfermeriaByte;
    }

    public byte[] getRegistrosEnfermeriaByte() {
        return registrosEnfermeriaByte;
    }

    public void setRenderRegistrosEnf(boolean renderRegistrosEnf) {
        this.renderRegistrosEnf = renderRegistrosEnf;
    }

    public boolean isRenderRegistrosEnf() {
        return renderRegistrosEnf;
    }

    public void setLstOtrasAsesoria(List lstOtrasAsesoria) {
        this.lstOtrasAsesoria = lstOtrasAsesoria;
    }

    public List getLstOtrasAsesoria() {
        return lstOtrasAsesoria;
    }

    public void setDtConsultaOtrasAsesoria(HtmlDataTable dtConsultaOtrasAsesoria) {
        this.dtConsultaOtrasAsesoria = dtConsultaOtrasAsesoria;
    }

    public HtmlDataTable getDtConsultaOtrasAsesoria() {
        return dtConsultaOtrasAsesoria;
    }

    public void setLstAsesoria(List<Chaseavise> lstAsesoria) {
        this.lstAsesoria = lstAsesoria;
    }

    public List<Chaseavise> getLstAsesoria() {
        return lstAsesoria;
    }

    public void setDtAsesoria(HtmlDataTable dtAsesoria) {
        this.dtAsesoria = dtAsesoria;
    }

    public HtmlDataTable getDtAsesoria() {
        return dtAsesoria;
    }

    public void setListMotivoImpresion(List<SelectItem> listMotivoImpresion) {
        this.listMotivoImpresion = listMotivoImpresion;
    }

    public List<SelectItem> getListMotivoImpresion() {
        if (listMotivoImpresion.isEmpty()) {
            listMotivoImpresion.add(new SelectItem("", 
                                                      "Seleccione una opciNn ..."));
            listMotivoImpresion.add(new SelectItem("SFA","Para soporte de la factura al asegurador"));
            listMotivoImpresion.add(new SelectItem("SP","Por solicitud del paciente"));
            listMotivoImpresion.add(new SelectItem("TOE","Para trascripciNn de Nrdenes en EPS"));
            listMotivoImpresion.add(new SelectItem("EHI","Para enviar la historia a otra IPS"));
            listMotivoImpresion.add(new SelectItem("SE","Por solicitud de la EPS"));
            listMotivoImpresion.add(new SelectItem("RAA","RevisiNn administrativa o auditorNa"));
            listMotivoImpresion.add(new SelectItem("OR","Otra razNn"));

        }
        return listMotivoImpresion;
    }

    public void setLogimpresionAux(Chlogimpresi logimpresionAux) {
        this.logimpresionAux = logimpresionAux;
    }

    public Chlogimpresi getLogimpresionAux() {
        return logimpresionAux;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHlicmotiimpr(ValueChangeEvent valueChangeEvent) {
        Chconsulta consultaAux = null;
            consultaAux = (Chconsulta)this.dtFolios.getRowData();
            setMotivoImpresion((String)valueChangeEvent.getNewValue());
            consultaAux.setHlicmotiimpr((String)valueChangeEvent.getNewValue());
            ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHlicmotiimprOtraAsesoria(ValueChangeEvent valueChangeEvent) {
        Chasesoria asesoriaSelect = null;
            asesoriaSelect = (Chasesoria)dtConsultaOtrasAsesoria.getRowData();
            setMotivoImpresionOtraAsesoria((String)valueChangeEvent.getNewValue());
            asesoriaSelect.setHlicmotiimpr((String)valueChangeEvent.getNewValue());
            ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        
    }


    public void setMotivoImpresion(String motivoImpresion) {
        this.motivoImpresion = motivoImpresion;
    }

    public String getMotivoImpresion() {
        return motivoImpresion;
    }

    public void setMotivoImpresionOtraAsesoria(String motivoImpresionOtraAsesoria) {
        this.motivoImpresionOtraAsesoria = motivoImpresionOtraAsesoria;
    }

    public String getMotivoImpresionOtraAsesoria() {
        return motivoImpresionOtraAsesoria;
    }
    
    public void consultarFoliosUsuarioNotaAclaratoria() {

        if (usuario != null && usuario.getHuslnumero() != null) {
            lstFolios = new ArrayList<Chconsulta>();
            try {
                    lstFolios = 
                        this.getServiceLocator().getClinicoService().getFoliosUsuarioXnumConsulta(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (lstFolios == null || lstFolios.isEmpty()) {
            FacesUtils.addErrorMessage(IConstantes.MSG_SIN_DATOS);
        }
    }


    public void setFECHA(Date fECHA) {
        this.FECHA = fECHA;
    }

    public Date getFECHA() {
        return FECHA;
    }

    public void setCLINICA(String cLINICA) {
        this.CLINICA = cLINICA;
    }

    public String getCLINICA() {
        return CLINICA;
    }

    public void setNOMBRES(String nOMBRES) {
        this.NOMBRES = nOMBRES;
    }

    public String getNOMBRES() {
        return NOMBRES;
    }

    public void setIDENTIFICACION(String iDENTIFICACION) {
        this.IDENTIFICACION = iDENTIFICACION;
    }

    public String getIDENTIFICACION() {
        return IDENTIFICACION;
    }

    public void setFECHANTO(Date fECHANTO) {
        this.FECHANTO = fECHANTO;
    }

    public Date getFECHANTO() {
        return FECHANTO;
    }

    public void setDESEOLLAMAR(String dESEOLLAMAR) {
        this.DESEOLLAMAR = dESEOLLAMAR;
    }

    public String getDESEOLLAMAR() {
        return DESEOLLAMAR;
    }

    public void setSEXO(String sEXO) {
        this.SEXO = sEXO;
    }

    public String getSEXO() {
        return SEXO;
    }

    public void setGENERO(String gENERO) {
        this.GENERO = gENERO;
    }

    public String getGENERO() {
        return GENERO;
    }

    public void setDIRECCION(String dIRECCION) {
        this.DIRECCION = dIRECCION;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setTELEFONO(String tELEFONO) {
        this.TELEFONO = tELEFONO;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setCIUDAD(String cIUDAD) {
        this.CIUDAD = cIUDAD;
    }

    public String getCIUDAD() {
        return CIUDAD;
    }

    public void setZONA(String zONA) {
        this.ZONA = zONA;
    }

    public String getZONA() {
        return ZONA;
    }

    public void setESTADOCIVIL(String eSTADOCIVIL) {
        this.ESTADOCIVIL = eSTADOCIVIL;
    }

    public String getESTADOCIVIL() {
        return ESTADOCIVIL;
    }

    public void setOCUPACION(String oCUPACION) {
        this.OCUPACION = oCUPACION;
    }

    public String getOCUPACION() {
        return OCUPACION;
    }

    public void setAFILACION(String aFILACION) {
        this.AFILACION = aFILACION;
    }

    public String getAFILACION() {
        return AFILACION;
    }

    public void setASEGURADORA(String aSEGURADORA) {
        this.ASEGURADORA = aSEGURADORA;
    }

    public String getASEGURADORA() {
        return ASEGURADORA;
    }


    public void setRESPONSABLE(String rESPONSABLE) {
        this.RESPONSABLE = rESPONSABLE;
    }

    public String getRESPONSABLE() {
        return RESPONSABLE;
    }

    public void setTELCONTACTO(String tELCONTACTO) {
        this.TELCONTACTO = tELCONTACTO;
    }

    public String getTELCONTACTO() {
        return TELCONTACTO;
    }

    public void setPARENTESCO(String pARENTESCO) {
        this.PARENTESCO = pARENTESCO;
    }

    public String getPARENTESCO() {
        return PARENTESCO;
    }

    public void setOBSERVACION(String oBSERVACION) {
        this.OBSERVACION = oBSERVACION;
    }

    public String getOBSERVACION() {
        return OBSERVACION;
    }
    
    public void generarResumenPsicologia(Chconsulta consulta ,Chpapsicologico nota) {
        generoHistoria = false;
        this.index = -1;
        JasperPrint jasperPrint;
        jasperPrint = null;
        renderFolio = false;
        try {
            obtenerDatosReporteChpsicologia(consulta,nota);
            URL url = 
                FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reportePAuxPsicologia.jasper");
            URL url_profamilia = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
            
            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                
                byte[] bytes;

                JasperReport report = 
                    (JasperReport)JRLoader.loadObject(url);
                bytes = 
                        JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                PdfServletUtils.showPdfDocument(bytes, 
                                                "PrimerosAuxiliosPsicologia" + ".pdf", 
                                                false);
                generoHistoria = true;
                         
            }
            } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
            
            }

    }

    public void setLstViniso(List<Chsegutelefo> lstViniso) {
        this.lstViniso = lstViniso;
    }

    public List<Chsegutelefo> getLstViniso() {
        return lstViniso;
    }

    public void setDtViniso(HtmlDataTable dtViniso) {
        this.dtViniso = dtViniso;
    }

    public HtmlDataTable getDtViniso() {
        return dtViniso;
    }
}
