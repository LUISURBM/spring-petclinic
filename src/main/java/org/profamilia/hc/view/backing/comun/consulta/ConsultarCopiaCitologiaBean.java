package org.profamilia.hc.view.backing.comun.consulta;


import com.lowagie.text.Document;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.Barcode39;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Color;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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

import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chlibrocitol;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cncitolect;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cncitotoma;
import org.profamilia.hc.model.dto.Cncitovphlect;
import org.profamilia.hc.model.dto.Cndesccito;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorUsuariosBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

public class ConsultarCopiaCitologiaBean extends BaseBean implements JRDataSource {


    private int selectedIndex;

    private boolean renderBuscador;

    private boolean generoHistoria;

    private Chusuario usuario;

    private String nombreUsuario;

    BuscadorUsuariosBean buscador;

    private Long numeroUsuario;

    private boolean renderInformacionUsuario;

    private UIInput itNumeroUsuario;

    static final int ACTIVAR_BEAN = 0;

    static final int ACTIVAR_BUSCADOR = 1;

    private List<SelectItem> listSexos;

    /** Almacena la lista de los posibles estados civil  */
    private List<SelectItem> listEstadoCivil;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;


    private List lstCitologiaUsuario;

    private HtmlDataTable dtCopiaCitologia;

    private Cncitotoma toma;

    private Cncitolect lectura;

    private Cncitologi citologia;

    private int index = -1;

    private static int NUMERO_COPIAS = 1;
    
    private boolean esPolicia;

    //Variables Citologia
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

    String OTROS_HALLAZGOS_TOMA;

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


    // Variables de Lectura

    String CALIDAD_MUESTRA;
    String MICROORGANISMOS;
    String OTROS_MICRO;
    String CATEGORIZACION;
    String ANORMAL_ESCA;
    String ANORMAL_GLANDU;
    String OTRAS_NEOPLACITAS;
    String OBSERVACIONES;

    String DIA_PRIMERA_LECTURA;
    String MES_PRIMERA_LECTURA;
    String ANO_PRIMERA_LECTURA;
    String DIA_SEGUNDA_LECTURA;
    String MES_SEGUNDA_LECTURA;
    String ANO_SEGUNDA_LECTURA;
    String NOMBRE_PRIMERA_LECTURA;
    String NOMBRE_SEGUNDA_LECTURA;
    String PRIMERA_LEIDA;
    String SEGUNDA_LEIDA;
    String NUMERO_PRIMERA_LECTURA;
    String NUMERO_SEGUNDA_LECTURA;

    String DIA_VPH;
    String MES_VPH;
    String ANO_VPH;

    String DESCRIPCION_CONDUCTA;
    Date FECHA_PRIMERA_LECTURA;
    Date FECHA_SEGUNDA_LECTURA;
    String NUMERO_FAC;
    String CONDUCTA;

    //Variables Toma Base Liquida
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

    // FECHA ENTREGA CITOLOGIA

    Date FECHA_ENTREGA;
  private Chlibrocitol entrega;

    public ConsultarCopiaCitologiaBean() {
    }


    public void init() {
        generoHistoria = false;
    }


    public boolean next() {
        index++;
        return (index < NUMERO_COPIAS);
    }

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
        }else if (fieldName.equals("MES_PARTO")) {
                value = MES_PARTO;
        }else if (fieldName.equals("ANNO_PARTO")) {
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
        }  else if (fieldName.equals("OTRO_CUAL")) {
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
        } else if (fieldName.equals("OTROS_HALLAZGOS_TOMA")) {
            value = OTROS_HALLAZGOS_TOMA;
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
        } else if (fieldName.equals("CALIDAD_MUESTRA")) {
            value = CALIDAD_MUESTRA;
        } else if (fieldName.equals("MICROORGANISMOS")) {
            value = MICROORGANISMOS;
        } else if (fieldName.equals("OTROS_MICRO")) {
            value = OTROS_MICRO;
        } else if (fieldName.equals("CATEGORIZACION")) {
            value = CATEGORIZACION;
        } else if (fieldName.equals("OTROS_HALLAZGOS")) {
            value = OTROS_HALLAZGOS;
        } else if (fieldName.equals("ANORMAL_ESCA")) {
            value = ANORMAL_ESCA;
        } else if (fieldName.equals("ANORMAL_GLANDU")) {
            value = ANORMAL_GLANDU;
        } else if (fieldName.equals("OTRAS_NEOPLACITAS")) {
            value = OTRAS_NEOPLACITAS;
        } else if (fieldName.equals("OBSERVACIONES")) {
            value = OBSERVACIONES;
        } else if (fieldName.equals("DIA_PRIMERA_LECTURA")) {
            value = DIA_PRIMERA_LECTURA;
        } else if (fieldName.equals("MES_PRIMERA_LECTURA")) {
            value = MES_PRIMERA_LECTURA;
        } else if (fieldName.equals("ANO_PRIMERA_LECTURA")) {
            value = ANO_PRIMERA_LECTURA;
        } else if (fieldName.equals("DIA_SEGUNDA_LECTURA")) {
            value = DIA_SEGUNDA_LECTURA;
        } else if (fieldName.equals("MES_SEGUNDA_LECTURA")) {
            value = MES_SEGUNDA_LECTURA;
        } else if (fieldName.equals("ANO_SEGUNDA_LECTURA")) {
            value = ANO_SEGUNDA_LECTURA;
        } else if (fieldName.equals("NOMBRE_PRIMERA_LECTURA")) {
            value = NOMBRE_PRIMERA_LECTURA;
        } else if (fieldName.equals("NOMBRE_SEGUNDA_LECTURA")) {
            value = NOMBRE_SEGUNDA_LECTURA;
        } else if (fieldName.equals("PRIMERA_LEIDA")) {
            value = PRIMERA_LEIDA;
        } else if (fieldName.equals("SEGUNDA_LEIDA")) {
            value = SEGUNDA_LEIDA;
        } else if (fieldName.equals("FECHA_PRIMERA_LECTURA")) {
            value = FECHA_PRIMERA_LECTURA;
        } else if (fieldName.equals("FECHA_SEGUNDA_LECTURA")) {
            value = FECHA_SEGUNDA_LECTURA;
        } else if (fieldName.equals("NUMERO_PRIMERA_LECTURA")) {
            value = NUMERO_PRIMERA_LECTURA;
        } else if (fieldName.equals("NUMERO_SEGUNDA_LECTURA")) {
            value = NUMERO_SEGUNDA_LECTURA;
        } else if (fieldName.equals("NUMERO_FAC")) {
            value = NUMERO_FAC;
        }else if (fieldName.equals("CONDUCTA")) {
                value = CONDUCTA;
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

        return value;
    }


    public void obtenerDatosReporte(Integer numeroconsec) {
        List lstAspectoSelect = null;
        lstAspectoSelect = new ArrayList();

        if (numeroconsec != null) {
            try {
                citologia = 
                        this.serviceLocator.getClinicoService().getEncabezadoCitologia(numeroconsec);
                if (citologia != null) {
                    toma = 
serviceLocator.getClinicoService().getTomaCitologia(numeroconsec);
                }


            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        
        if (entrega != null && entrega.getHlccconducta() != null) {
           Cndesccito conductades;
            conductades = null;
            try {
                conductades = 
                        serviceLocator.getClinicoService().getDescripcionesCitologia("chlibrocitol", 
                                                                                     "hlccconducta", 
                                                                                      entrega.getHlccconducta());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (conductades != null) {
                CONDUCTA = conductades.getCdicvalor();
            }
        }

        if (citologia != null && toma != null) {
        
            if (citologia.getCcinnumdoc() != null) {
                NUMERO_FAC = citologia.getCcinnumdoc().toString();

                if (NUMERO_FAC != null && NUMERO_FAC.length() > 6) {
                    NUMERO_FAC = 
                            NUMERO_FAC.substring(NUMERO_FAC.length() - 6, NUMERO_FAC.length());
                }

            }


            if (citologia != null) {
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
                
                
                if (citologia.getCcinclinic() != null) {
                 Cpclinica clinica = null;


                    try {
                        clinica = serviceLocator.getClinicoService().getClinica(citologia.getCcinclinic());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    CENTRO = clinica.getCclcnombre();
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
                    OTROS_HALLAZGOS_TOMA = toma.getCtmcotrhal();
                }

                if (toma.getCtmcotrmet() != null) {
                    OTRO_METODO = toma.getCtmcotrmet();
                }


                if (toma.getCtmcobstom() != null) {
                    OBSERVACIONES_TOMA = toma.getCtmcobstom();
                }
                if (toma.getCtmdultmen() != null) {

                    FECHA_REGLA = toma.getCtmdultmen();
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
                        ESQUEMA_CITOLOGIA = formatearCampoNulo(esquemades.getCdicdescri());
                    }

                }

                if (toma.getCtmcmetpla() != null) {
                    METODO_PLANIFICACION = formatearCampoNulo(toma.getCtmcmetpla());

                }


                if (toma.getCtmcultres() != null) {

                    RESULTADO_CITOLOGIA = formatearCampoNulo(toma.getCtmcultres());

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
                        OTRO_CUAL = formatearCampoNulo(toma.getCtmcpdotro());
                    }
                    if (toma.getCtmcpningu() != null) {
                        NINGUNO = formatearCampoNulo(toma.getCtmcpningu());
                    }

                    if (toma.getCtmcpcaute() != null) {
                        CAUTERIZACION = formatearCampoNulo(toma.getCtmcpcaute());
                    }
                    if (toma.getCtmcphiste() != null) {
                        HISTERECTOMIA = formatearCampoNulo(toma.getCtmcphiste());
                    }
                    if (toma.getCtmcpconiz() != null) {
                        CONIZACION = formatearCampoNulo(toma.getCtmcpconiz());
                    }
                    if (toma.getCtmcpradio() != null) {
                        RADIOTERAPIA = formatearCampoNulo(toma.getCtmcpradio());
                    }
                    if (toma.getCtmcpbiops() != null) {
                        BIOPSIA = formatearCampoNulo(toma.getCtmcpbiops());
                    }
                    if (toma.getCtmcpcriot() != null) {
                        CRIOTERAPIA = formatearCampoNulo(toma.getCtmcpcriot());
                    }
                    if (toma.getCtmcpata() != null) {
                        ATA = formatearCampoNulo(toma.getCtmcpata());
                    }
                    if (toma.getCtmcpotro() != null) {
                        OTRO = formatearCampoNulo(toma.getCtmcpotro());
                    }
                    if (toma.getCtmcpcolpo() != null) {
                        COLPOSCOPIA = toma.getCtmcpcolpo();
                    }
                    
                    if (toma.getCtmctomada() != null) {
                        TOMADA = formatearCampoNulo(toma.getCtmctomada());
                    }

                    if (toma.getCtmdfecreg() != null) {

                        FECHA_TOMADA = toma.getCtmdfecreg();
                    }

                    if (toma.getCtmcnomtom() != null) {
                        NOMBRE_TOMADA = formatearCampoNulo(toma.getCtmcnomtom());
                    }


                 


                }

            }


        }


        if (lectura != null) {
            if (lectura.getClcccalmue() != null) {
                CALIDAD_MUESTRA = formatearCampoNulo(lectura.getClcccalmue());
            }
            if (lectura.getClccmicorg() != null) {
                MICROORGANISMOS = formatearCampoNulo(lectura.getClccmicorg());
            }
            if (lectura.getClccotrmic() != null) {
                OTROS_MICRO = formatearCampoNulo(lectura.getClccotrmic());
            }
            if (lectura.getClcccatego() != null) {
                CATEGORIZACION = formatearCampoNulo(lectura.getClcccatego());
            }
            if (lectura.getClccotrhal() != null) {
                OTROS_HALLAZGOS = formatearCampoNulo(lectura.getClccotrhal());
            }

            if (lectura.getClcdprilec() != null) {
                FECHA_PRIMERA_LECTURA = lectura.getClcdprilec();
            }

            if (lectura.getClcdseglec() != null) {
                FECHA_SEGUNDA_LECTURA = lectura.getClcdseglec();
            }

            if (lectura.getClccanoesc() != null) {
                ANORMAL_ESCA = formatearCampoNulo(lectura.getClccanoesc());
            }
            if (lectura.getClccanogla() != null) {
                ANORMAL_GLANDU = formatearCampoNulo(lectura.getClccanogla());
            }
            if (lectura.getClccotrneo() != null) {
                OTRAS_NEOPLACITAS = formatearCampoNulo(lectura.getClccotrneo());
            }

            if (lectura.getClccobserv() != null) {
                OBSERVACIONES = formatearCampoNulo(lectura.getClccobserv());
            }

            if (lectura.getClcdprilec() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(lectura.getClcdprilec());
                Integer dialec1 = calendar.get(Calendar.DAY_OF_MONTH);
                Integer meslec1 = calendar.get(Calendar.MONTH) + 1;
                Integer anolec1 = calendar.get(calendar.YEAR);

                if (dialec1.compareTo(10) < 0) {
                    DIA_PRIMERA_LECTURA = "0" + dialec1.toString();
                } else {
                    DIA_PRIMERA_LECTURA = dialec1.toString();
                }

                if (meslec1.compareTo(10) < 0) {
                    MES_PRIMERA_LECTURA = "0" + meslec1.toString();
                } else {
                    MES_PRIMERA_LECTURA = meslec1.toString();
                }

                ANO_PRIMERA_LECTURA = anolec1.toString();
            }


            if (lectura.getClcdseglec() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(lectura.getClcdseglec());
                Integer dialec2 = calendar.get(Calendar.DAY_OF_MONTH);
                Integer meslec2 = calendar.get(Calendar.MONTH) + 1;
                Integer anolec2 = calendar.get(calendar.YEAR);

                if (dialec2.compareTo(10) < 0) {
                    DIA_SEGUNDA_LECTURA = "0" + dialec2.toString();
                } else {
                    DIA_SEGUNDA_LECTURA = dialec2.toString();
                }

                if (meslec2.compareTo(10) < 0) {
                    MES_SEGUNDA_LECTURA = "0" + meslec2.toString();
                } else {
                    MES_SEGUNDA_LECTURA = meslec2.toString();
                }

                ANO_SEGUNDA_LECTURA = anolec2.toString();
            }

            if (lectura.getClccnompri() != null) {
                NOMBRE_PRIMERA_LECTURA = formatearCampoNulo(lectura.getClccnompri());
            }
            if (lectura.getClccnomseg() != null) {
                NOMBRE_SEGUNDA_LECTURA = formatearCampoNulo(lectura.getClccnomseg());
            }
            if (lectura.getClccprilec() != null) {
                PRIMERA_LEIDA = formatearCampoNulo(lectura.getClccprilec());
            }
            if (lectura.getClccseglec() != null) {
                SEGUNDA_LEIDA = formatearCampoNulo(lectura.getClccseglec()) ;
            }
            if (lectura.getClccnumpri() != null) {
                NUMERO_PRIMERA_LECTURA = formatearCampoNulo(lectura.getClccnumpri()) ;
            }
            if (lectura.getClccnumseg() != null) {
                NUMERO_SEGUNDA_LECTURA = formatearCampoNulo(lectura.getClccnumseg()) ;
            }

        }
        ;

    }
    
        public void obtenerDatosReporteVphYBaseLiquida() {

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
    
    public void mostrarBuscadorUsuarios() {
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        selectedIndex = ACTIVAR_BUSCADOR;
        renderBuscador = true;
        generoHistoria = false;
        lstCitologiaUsuario = new ArrayList();

    }


    public void consultarCitologiasUsuario() {


        try {
            lstCitologiaUsuario = 
                    this.serviceLocator.getClinicoService().getCopiaCitologia(numeroUsuario);
        } catch (ModelException e) {
            e.printStackTrace();
        }

    }


    public void changeUsuario() {
        Chusuario usuarioAux = null;
        generoHistoria = false;
        nombreUsuario = "";
        usuario = new Chusuario();
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


    /**
     * @param valueChangeEvent
     */
    public void setNumeroUsuario(ValueChangeEvent valueChangeEvent) {
        setNumeroUsuario((Long)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void aceptarUsuario() {
        selectedIndex = ACTIVAR_BEAN;

        usuario = new Chusuario();
        nombreUsuario = "";


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

    public void setListSexos(List<SelectItem> listSexos) {
        this.listSexos = listSexos;
    }

    public List getListSexos() {
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

    public void setListEstadoCivil(List<SelectItem> listEstadoCivil) {
        this.listEstadoCivil = listEstadoCivil;
    }

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

    public void setListTipoIdentificacion(List<SelectItem> listTipoIdentificacion) {
        this.listTipoIdentificacion = listTipoIdentificacion;
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
     * @param lstCitologiaUsuario
     */
    public void setLstCitologiaUsuario(List lstCitologiaUsuario) {
        this.lstCitologiaUsuario = lstCitologiaUsuario;
    }

    /**
     * @return
     */
    public List getLstCitologiaUsuario() {
        return lstCitologiaUsuario;
    }

    /**
     * @param dtCopiaCitologia
     */
    public void setDtCopiaCitologia(HtmlDataTable dtCopiaCitologia) {
        this.dtCopiaCitologia = dtCopiaCitologia;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCopiaCitologia() {
        return dtCopiaCitologia;
    }

    /**
     * @return
     */
    public String volverConsulta() {

        FacesUtils.resetManagedBean("consultarCopiaCitologiaBean");
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        generoHistoria = false;
        return BeanNavegacion.RUTA_IR_INICIO;
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
        OTROS_HALLAZGOS_TOMA = "";

        CALIDAD_MUESTRA = "";
        MICROORGANISMOS = "";
        OTROS_MICRO = "";
        CATEGORIZACION = "";
        OTROS_HALLAZGOS = "";
        ANORMAL_ESCA = "";
        ANORMAL_GLANDU = "";
        OTRAS_NEOPLACITAS = "";
        OBSERVACIONES = "";

        DIA_PRIMERA_LECTURA = "";
        MES_PRIMERA_LECTURA = "";
        ANO_PRIMERA_LECTURA = "";
        DIA_SEGUNDA_LECTURA = "";
        MES_SEGUNDA_LECTURA = "";
        ANO_SEGUNDA_LECTURA = "";
        NOMBRE_PRIMERA_LECTURA = "";
        NOMBRE_SEGUNDA_LECTURA = "";
        PRIMERA_LEIDA = "";
        SEGUNDA_LEIDA = "";

        DIA_VPH = "";
        MES_VPH = "";
        ANO_VPH = "";

    }

    public void clearFormularioVphYBaseLiquida() {
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

    public void generarCopiaLectura() {
        Object[] citologiaAux;
        Integer consecutivo;
        consecutivo = 0;
        index = -1;
        citologiaAux = (Object[])dtCopiaCitologia.getRowData();

        BigDecimal consecutivoBig = (BigDecimal)citologiaAux[0];
        if (consecutivoBig != null) {

            consecutivo = consecutivoBig.intValue();
        }

        clearReporte();
        clearFormularioVphYBaseLiquida();
    

        toma = null;
        lectura = null;
        entrega = null;
        
   

        if (citologiaAux != null) {
            try {
                citologia = 
                        serviceLocator.getClinicoService().getEncabezadoCitologia(consecutivo);
                toma = serviceLocator.getClinicoService().getTomaCitologia(consecutivo);
                lectura = 
                        serviceLocator.getClinicoService().getLecturaCitologia(consecutivo);
                entrega = serviceLocator.getClinicoService().getLibroCitologia(citologia.getCcinconsec());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        try {
            if (lectura != null) {
                URL url = null;
                URL url_profamilia = null;

                if (citologia != null && citologia.getCcilconcli() != null) {
                    try {
                        esPolicia = 
                                serviceLocator.getClinicoService().esPoliciaNacional(citologia.getCcilconcli().intValue());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (esPolicia) {
                        url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/tomaCitologiaPolicia.jasper");
                        url_profamilia = 
                                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_POLICIA);
                        obtenerDatosReporte(consecutivo);
                    } else {
                        url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/tomaCitologia.jasper");

                        url_profamilia = 
                                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_NEW);
                        obtenerDatosReporte(consecutivo);
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
                        generoHistoria = true;
                    }
                }
            }else{
                generoHistoria = false;
                FacesUtils.addErrorMessage("No existe Lectura");
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }

    }
    
    public void generarCopiaTomaBaseLiquida() {
        Object[] citologiaAux;
        Integer consecutivo;
        consecutivo = 0;
        index = -1;
        citologiaAux = (Object[])dtCopiaCitologia.getRowData();

        BigDecimal consecutivoBig = (BigDecimal)citologiaAux[0];
        if (consecutivoBig != null) {

            consecutivo = consecutivoBig.intValue();
        }

        clearReporte();
        clearFormularioVphYBaseLiquida();

        toma = null;
        lectura = null;
        entrega = null;
        
    

        if (citologiaAux != null) {
            try {
                citologia = 
                        serviceLocator.getClinicoService().getEncabezadoCitologia(consecutivo);
                toma = serviceLocator.getClinicoService().getTomaCitologia(consecutivo);
                lectura = 
                        serviceLocator.getClinicoService().getLecturaCitologia(consecutivo);
                entrega = serviceLocator.getClinicoService().getLibroCitologia(citologia.getCcinconsec());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        try {

            URL url = null;
            URL url_profamilia = null;

            if (citologia != null && citologia.getCcilconcli() != null) {
                try {
                    esPolicia = 
                            serviceLocator.getClinicoService().esPoliciaNacional(citologia.getCcilconcli().intValue());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if ((citologia.getCcintiphis() != null && 
                     citologia.getCcintiphis().equals(HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA_BASELIQUIDA))) {
                    url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/TomaTipificacionVPH FO_GS_AD-020.jasper");
                    url_profamilia = 
                            FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_NEW);
                    obtenerDatosReporteVphYBaseLiquida();
                } else {
                    if (esPolicia) {
                        url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/tomaCitologiaPolicia.jasper");
                        url_profamilia = 
                                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_POLICIA);
                        obtenerDatosReporte(consecutivo);
                    } else {
                        url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/tomaCitologia.jasper");

                        url_profamilia = 
                                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_NEW);
                        obtenerDatosReporte(consecutivo);
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
                                                    "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                                    ".pdf", false);
                    generoHistoria = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }

    }
 
}
