package org.profamilia.hc.view.backing.comun.consulta;


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

import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import javax.imageio.ImageIO;

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
import org.profamilia.hc.model.dto.Cnconsclin;
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
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosCitologiaBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorUsuariosBean;
import org.profamilia.hc.view.backing.webService.CodigoQRClient;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.ModuleConfig;
import org.profamilia.hc.view.util.PdfServletUtils;

public class ConsultarCopiaVphBean extends BaseBean implements JRDataSource {


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


    private List lstVphUsuario;

    private HtmlDataTable dtCopiaVph;

    private Cncitotoma toma;

    private Cncitolect lectura;

    private Cncitologi citologia;

    private int index = -1;

    private static int NUMERO_COPIAS = 1;

    private boolean esPolicia;

    //Variables Toma
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
    String personaPrivadaLibertad;
    String tipificacion;
    String baseLiquida;
    String convencional;
    Integer numeroBaseLiquida;
    Integer numeroConvencional;
    String esquemaCitologia;
    String otroEsquemaCitologia;
    String resultadoTipificacion;   

    // Variables de Lectura
    Integer NUMERO_TIPIFICACION;
    String HVLCGT16;
    String HVLCGT18;
    String HVLCGT31;
    String HVLCGT45;
    String HVLCGT51;
    String HVLCGT52;
    String HVLCGT3858;
    String HVLCGT353968;
    String HVLCGT565966;
    String LECTURA_NOMBRRE_PROFESIONAL;
    String LECTURA_TARJETA_PROFESIONAL;
    String CONDUCTA;
    String DIA_LECTURA;
    String MES_LECTURA;
    String ANO_LECTURA;
    String DIA_TOMADA;
    String MES_TOMADA;
    String ANO_TOMADA;
    String DIA_RECEP;
    String MES_RECEP;
    String ANO_RECEP;
    String APELLIDOS;
    String NOMBRES;
    Long NUMERO_DOCUMENTO;
    String TIPO_DOCUMENTO;
    String DIRECCION;
    String TELEFONO;
    String CIUDAD;
    String DEPARTAMENTO;
    Integer EDAD;
    String CENTRO;
    String ASEGURADORA;
    String INTERPRETACION;
    String GENOTIPIFICACION;
    // Variables codigo QR
    String NOMBRE;
    String TIPO_IDENTIFICACION;
    String NUMERO_IDENTIFICACION;
    String FECHA_TOMA;
    String NUMERO_CITOLOGIA_VPH;
    String CLINICA;

    private Cncitovphlect lecturaVPH;
    private Chlibrocitol entrega;
    private CodigoQRClient codigoQRClient;
    
    private Integer consecutivoCito;
    
    private Chusuario usuarioConsecutivo;
    

    public ConsultarCopiaVphBean() {
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
        if (fieldName.equals("NUMERO_TIPIFICACION")) {
            value = NUMERO_TIPIFICACION;
        } else if (fieldName.equals("CENTRO")) {
            value = CENTRO;
        } else if (fieldName.equals("APELLIDOS")) {
            value = APELLIDOS;
        } else if (fieldName.equals("NOMBRES")) {
            value = NOMBRES;
        } else if (fieldName.equals("TIPO_DOCUMENTO")) {
            value = TIPO_DOCUMENTO;
        } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = NUMERO_DOCUMENTO;
        } else if (fieldName.equals("EDAD")) {
            value = EDAD;
        } else if (fieldName.equals("ASEGURADORA")) {
            value = ASEGURADORA;
        } else if (fieldName.equals("TELEFONO")) {
            value = TELEFONO;
        } else if (fieldName.equals("CIUDAD")) {
            value = CIUDAD;
        } else if (fieldName.equals("DEPARTAMENTO")) {
            value = DEPARTAMENTO;
        } else if (fieldName.equals("HVLCGT16")) {
            value = HVLCGT16;
        } else if (fieldName.equals("HVLCGT18")) {
            value = HVLCGT18;
        } else if (fieldName.equals("HVLCGT31")) {
            value = HVLCGT31;
        } else if (fieldName.equals("HVLCGT45")) {
            value = HVLCGT45;
        } else if (fieldName.equals("HVLCGT51")) {
            value = HVLCGT51;
        } else if (fieldName.equals("HVLCGT52")) {
            value = HVLCGT52;
        } else if (fieldName.equals("HVLCGT3858")) {
            value = HVLCGT3858;
        } else if (fieldName.equals("HVLCGT353968")) {
            value = HVLCGT353968;
        } else if (fieldName.equals("HVLCGT565966")) {
            value = HVLCGT565966;
        } else if (fieldName.equals("LECTURA_NOMBRRE_PROFESIONAL")) {
            value = LECTURA_NOMBRRE_PROFESIONAL;
        } else if (fieldName.equals("LECTURA_TARJETA_PROFESIONAL")) {
            value = LECTURA_TARJETA_PROFESIONAL;
        } else if (fieldName.equals("CONDUCTA")) {
            value = CONDUCTA;
        } else if (fieldName.equals("DIA_TOMADA")) {
            value = DIA_TOMADA;
        } else if (fieldName.equals("MES_TOMADA")) {
            value = MES_TOMADA;
        } else if (fieldName.equals("ANO_TOMADA")) {
            value = ANO_TOMADA;
        } else if (fieldName.equals("DIA_LECTURA")) {
            value = DIA_LECTURA;
        } else if (fieldName.equals("MES_LECTURA")) {
            value = MES_LECTURA;
        } else if (fieldName.equals("ANO_LECTURA")) {
            value = ANO_LECTURA;
        } else if (fieldName.equals("DIA_RECEP_TOMA")) {
            value = DIA_RECEP;
        } else if (fieldName.equals("MES_RECEP_TOMA")) {
            value = MES_RECEP;
        } else if (fieldName.equals("ANO_RECEP_TOMA")) {
            value = ANO_RECEP;
        }else if (fieldName.equals("INTERPRETACION")) {
                value = INTERPRETACION;  
        }else if (fieldName.equals("GENOTIPIFICACION")) {
                value = GENOTIPIFICACION;  
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
        }else if (fieldName.equals("otroResultadoCitologia")) {
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
        } else if (fieldName.equals("diaColpo")) {
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
        } else if (fieldName.equals("diaTratamientoHormonal")) {
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


    public void obtenerDatosReporteVPHLectura() {

        if (entrega != null && entrega.getHlccconducta() != null) {
            Cndesccito conductades;
            conductades = null;
            try {
                conductades = 
                        serviceLocator.getClinicoService().getDescripcionesCitologia("chlibrocitol", 
                                                                                     "conductavph", 
                                                                                     entrega.getHlccconducta());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (conductades != null) {
                CONDUCTA = conductades.getCdicvalor();
            }
        }

        //  if (entrega != null && entrega.getHlcdfecregistr() != null) {
        //     FECHA_ENTREGA = entrega.getHlcdfecregistr();
        //}

        if (citologia != null) {
            if (citologia.getCcinconsec() != null) {
                NUMERO_TIPIFICACION = citologia.getCcinconsec();
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
            if (citologia.getCcicasegur() != null) {
                Cpentidadadm aseguradoraAux;
                aseguradoraAux = null;

                try {
                    aseguradoraAux = 
                            serviceLocator.getClinicoService().getAseguradoraPorCodigo(citologia.getCcicasegur());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (aseguradoraAux != null) {
                    ASEGURADORA = aseguradoraAux.getCeacnombre();
                }

            }
            if (citologia.getCcinedad() != null) {
                EDAD = citologia.getCcinedad();
            }
        }


        if (toma != null) {
            if (toma.getCtmdfecreg() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(toma.getCtmdfecreg());
                Integer diareg = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mesreg = calendar.get(Calendar.MONTH) + 1;
                Integer anoreg = calendar.get(calendar.YEAR);

                if (diareg.compareTo(10) < 0) {
                    DIA_TOMADA = "0" + diareg.toString();
                } else {
                    DIA_TOMADA = diareg.toString();
                }

                if (mesreg.compareTo(10) < 0) {
                    MES_TOMADA = "0" + mesreg.toString();
                } else {
                    MES_TOMADA = mesreg.toString();
                }

                ANO_TOMADA = anoreg.toString();
            }
            if (toma.getCtmnclinic() != null) {
            try {
                Cpclinica clinica = 
                    this.serviceLocator.getClinicoService().getClinica(toma.getCtmnclinic());
                CENTRO = clinica.getCclcnombre();
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        }

        if (lecturaVPH != null) {
            if (lecturaVPH.getCcvcusureg() != null) {
                try {
                    Cpprofesio profesional = 
                        this.serviceLocator.getClinicoService().getProfesionalPorUsuario(lecturaVPH.getCcvcusureg(), 
                                                                                         lecturaVPH.getCcvnclinic());
                    LECTURA_TARJETA_PROFESIONAL = 
                            profesional.getCpfcregmedic();
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
            if (lecturaVPH.getCcvcgenoneg() != null) {
                GENOTIPIFICACION = lecturaVPH.getCcvcgenoneg();
            } 
            if (lecturaVPH.getCcvcgt16() != null) {
                HVLCGT16 = lecturaVPH.getCcvcgt16();
            }
            if (lecturaVPH.getCcvcgt18() != null) {
                HVLCGT18 = lecturaVPH.getCcvcgt18();
            }
            if (lecturaVPH.getCcvcgt31() != null) {
                HVLCGT31 = lecturaVPH.getCcvcgt31();
            }
            if (lecturaVPH.getCcvcgt45() != null) {
                HVLCGT45 = lecturaVPH.getCcvcgt45();
            }
            if (lecturaVPH.getCcvcgt51() != null) {
                HVLCGT51 = lecturaVPH.getCcvcgt51();
            }
            if (lecturaVPH.getCcvcgt52() != null) {
                HVLCGT52 = lecturaVPH.getCcvcgt52();
            }
            if (lecturaVPH.getCcvcgt3858() != null) {
                HVLCGT3858 = lecturaVPH.getCcvcgt3858();
            }
            if (lecturaVPH.getCcvcgt353968() != null) {
                HVLCGT353968 = lecturaVPH.getCcvcgt353968();
            }
            if (lecturaVPH.getCcvcgt565966() != null) {
                HVLCGT565966 = lecturaVPH.getCcvcgt565966();
            }

            if (lecturaVPH.getCcvcnomlec() != null) {
                LECTURA_NOMBRRE_PROFESIONAL = lecturaVPH.getCcvcnomlec();
            }

            if (lecturaVPH.getCcvdfeclec() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(lecturaVPH.getCcvdfeclec());
                Integer dialec1 = calendar.get(Calendar.DAY_OF_MONTH);
                Integer meslec1 = calendar.get(Calendar.MONTH) + 1;
                Integer anolec1 = calendar.get(calendar.YEAR);

                if (dialec1.compareTo(10) < 0) {
                    DIA_LECTURA = "0" + dialec1.toString();
                } else {
                    DIA_LECTURA = dialec1.toString();
                }

                if (meslec1.compareTo(10) < 0) {
                    MES_LECTURA = "0" + meslec1.toString();
                } else {
                    MES_LECTURA = meslec1.toString();
                }

                ANO_LECTURA = anolec1.toString();
            }
            
            if (lecturaVPH.getCcvdfecrecep() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(lecturaVPH.getCcvdfecrecep());
                Integer dialec1 = calendar.get(Calendar.DAY_OF_MONTH);
                Integer meslec1 = calendar.get(Calendar.MONTH) + 1;
                Integer anolec1 = calendar.get(calendar.YEAR);

                if (dialec1.compareTo(10) < 0) {
                    DIA_RECEP= "0" + dialec1.toString();
                } else {
                    DIA_RECEP = dialec1.toString();
                }

                if (meslec1.compareTo(10) < 0) {
                    MES_RECEP = "0" + meslec1.toString();
                } else {
                    MES_RECEP = meslec1.toString();
                }

                ANO_RECEP = anolec1.toString();
            }
            
            if(lecturaVPH.getCcvcinterpre() != null){
                INTERPRETACION =lecturaVPH.getCcvcinterpre();
            }

        }
    }
    
    public void obtenerDatosReporteQR() {
        SimpleDateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        NOMBRE=citologia.getCcicprinom()+" "+citologia.getCcicpriape();
        TIPO_IDENTIFICACION = citologia.getCcictipide();
        NUMERO_IDENTIFICACION = citologia.getCcianumide().toString();
        FECHA_TOMA = df.format(toma.getCtmdfecreg());
        NUMERO_CITOLOGIA_VPH = citologia.getCcinconsec().toString();
        if (toma.getCtmnclinic()  != null) {
            try {
                Cpclinica clinica = 
                    this.serviceLocator.getClinicoService().getClinica(toma.getCtmnclinic());
                CLINICA = clinica.getCclcnombre();
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
    
    }

    public void mostrarBuscadorUsuarios() {
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        selectedIndex = ACTIVAR_BUSCADOR;
        renderBuscador = true;
        generoHistoria = false;
        lstVphUsuario = new ArrayList();

    }


    public void consultarVphsUsuario() {
        try {
            consecutivoCito = null;
            lstVphUsuario = 
                    this.serviceLocator.getClinicoService().getCopiaVph(numeroUsuario);
        } catch (ModelException e) {
            e.printStackTrace();
        }

    }
    
    
    /**
     * @return
     */
    public String consultarConsecutivoCitologia() {
        Cncitologi cito = null;

        try {
            if (consecutivoCito != null) {
                cito = serviceLocator.getClinicoService().getEncabezadoCitologia(consecutivoCito);
                if (cito != null && cito.getCcinconsec() != null) {
                    numeroUsuario = cito.getCcilusuario().getHuslnumero();
                    lstVphUsuario = 
                            this.serviceLocator.getClinicoService().getCopiaVphXconsecutivo(numeroUsuario,consecutivoCito);
                    usuario= serviceLocator.getClinicoService().getUsuarioPorPk(numeroUsuario);
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
                } else {
                    FacesUtils.addErrorMessage("No se encontro citologia relacionada con el numero de consecutivo.");
                }
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }
        return BeanNavegacion.RUTA_ACTUAL;
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
    public void setLstVphUsuario(List lstCitologiaUsuario) {
        this.lstVphUsuario = lstCitologiaUsuario;
    }

    /**
     * @return
     */
    public List getLstVphUsuario() {
        return lstVphUsuario;
    }

    /**
     * @param dtCopiaCitologia
     */
    public void setDtCopiaVph(HtmlDataTable dtCopiaCitologia) {
        this.dtCopiaVph = dtCopiaCitologia;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCopiaVph() {
        return dtCopiaVph;
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


    public void clearFormularioVphLectura() {
        NUMERO_TIPIFICACION = null;
        CENTRO = "";
        HVLCGT16 = "";
        HVLCGT18 = "";
        HVLCGT31 = "";
        HVLCGT45 = "";
        HVLCGT51 = "";
        HVLCGT52 = "";
        HVLCGT3858 = "";
        HVLCGT353968 = "";
        HVLCGT565966 = "";
        LECTURA_NOMBRRE_PROFESIONAL = "";
        LECTURA_TARJETA_PROFESIONAL = "";
        CONDUCTA = "";
        DIA_LECTURA = "";
        MES_LECTURA = "";
        ANO_LECTURA = "";
        DIA_TOMADA = "";
        MES_TOMADA = "";
        ANO_TOMADA = "";
        DIA_RECEP = "";
        MES_RECEP = "";
        ANO_RECEP = "";
        ASEGURADORA = "";
        APELLIDOS = "";
        NOMBRES = "";
        NUMERO_DOCUMENTO = null;
        TIPO_DOCUMENTO = "";
        DIRECCION = "";
        TELEFONO = "";
        CIUDAD = "";
        DEPARTAMENTO = "";
        EDAD = null;
        CENTRO = "";
        ASEGURADORA = "";
        INTERPRETACION = "";
        GENOTIPIFICACION = "";

    }
    
    public void clearFormularioVphToma() {
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
        otroResultadoCitologia = "";
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


    public void clearCodigoQRVPH() {
        NOMBRE="";
        TIPO_IDENTIFICACION="";
        NUMERO_IDENTIFICACION="";
        FECHA_TOMA="";
        NUMERO_CITOLOGIA_VPH="";
        CLINICA="";
    }

    public void generarCopiaLectura() {
        Object[] citologiaAux;
        Integer consecutivo;
        consecutivo = 0;
        index = -1;
        citologiaAux = (Object[])dtCopiaVph.getRowData();

        BigDecimal consecutivoBig = (BigDecimal)citologiaAux[0];
        if (consecutivoBig != null) {

            consecutivo = consecutivoBig.intValue();
        }
        clearFormularioVphLectura();
        clearFormularioVphToma();
        clearCodigoQRVPH();

        toma = null;
        lectura = null;
        lecturaVPH = null;


        if (citologiaAux != null) {
            try {
                citologia = 
                        serviceLocator.getClinicoService().getEncabezadoCitologia(consecutivo);
                toma = serviceLocator.getClinicoService().getTomaCitologia(consecutivo);
                
                lecturaVPH = 
                        serviceLocator.getClinicoService().getLecturaCitologiaVph(citologia.getCcinconsec());
                entrega = 
                        serviceLocator.getClinicoService().getLibroCitologia(citologia.getCcinconsec());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        try {
        
        if(lecturaVPH != null && lecturaVPH.getCcvnconsec()!=null){
            obtenerDatosReporteVPHLectura();
            
            URL url = null;
            URL url_profamilia = null;
            URL url_firma = null;

                if ("NS".equals(lecturaVPH.getCcvcgenoneg())) {
                    url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/EntregaTipificacionVPH_NS_FO_GS_AD-022.jasper");
                } else {
                    url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/EntregaTipificacionVPH FO_GS_AD-022.jasper");
                }
            url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_NEW);
                    
                    if (lecturaVPH.getCcvcusureg().equals("cl01dasg")) {
                        url_firma = 
                                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_FIRMA_DIANA_SALCEDO);
                    } else if (lecturaVPH.getCcvcusureg().equals("cl01lkmm")) {
                        url_firma = 
                                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_FIRMA_KAREN_MARROQUIN);
                    }else if (lecturaVPH.getCcvcusureg().equals("cl01lahm")) {
                        url_firma = 
                                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_FIRMA_LAURA_HERRERA);
                    }else if (lecturaVPH.getCcvcusureg().equals("cl01ksmg")) {
                        url_firma = 
                                 FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_FIRMA_KAREN_MEDINA);
                    }

            URL url_super_horizontal = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
            URL url_super_vertical = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);

            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                parameters.put("IMAGE_FIRMA", url_firma);
                byte[] bytes;

                JasperReport report = (JasperReport)JRLoader.loadObject(url);

                bytes = 
                        JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                PdfServletUtils.showPdfDocument(bytes, 
                                                "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);
                                                
                generoHistoria = true;                                

            }
            }else{
                generoHistoria = false;
                FacesUtils.addErrorMessage("No existe Lectura");
            }

        } catch (Exception e) {
            generoHistoria = false;
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }

    }

    public void generarReporteCodigoQR() {
        Object[] citologiaAux;
        Integer consecutivo;
        consecutivo = 0;
        index = -1;
        ModuleConfig config = new ModuleConfig();
        citologiaAux = (Object[])dtCopiaVph.getRowData();

        BigDecimal consecutivoBig = (BigDecimal)citologiaAux[0];
        if (consecutivoBig != null) {

            consecutivo = consecutivoBig.intValue();
        }
        clearFormularioVphLectura();
        clearFormularioVphToma();
        clearCodigoQRVPH();

        toma = null;
        lectura = null;
        lecturaVPH = null;


        if (citologiaAux != null) {
            try {
                citologia = 
                        serviceLocator.getClinicoService().getEncabezadoCitologia(consecutivo);
                toma = serviceLocator.getClinicoService().getTomaCitologia(consecutivo);

                lecturaVPH = 
                        serviceLocator.getClinicoService().getLecturaCitologiaVph(citologia.getCcinconsec());
                entrega = 
                        serviceLocator.getClinicoService().getLibroCitologia(citologia.getCcinconsec());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        try {
            if (toma != null && toma.getCtmnconsec() != null) {
                obtenerDatosReporteQR();

                codigoQRClient = new CodigoQRClient();
                String respuesta = 
                    codigoQRClient.generarCodigoQR(citologia, toma, CLINICA);

                if (respuesta.equals(IConstantes.OK_REQUEST)) {
                    index = -1;
                    URL url = null;
                    
                    String url_codigo_QR = 
                        config.getUbicacionCodigoQR()+ citologia.getCcinconsec().toString() + 
                            ".png";

                    url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/CodigoQRCitologiaVPH.jasper");

                    if (url != null) {
                        Map parameters = new HashMap();
                        parameters.put("CODIGO_QR", url_codigo_QR);
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
                } else {
                    generoHistoria = false;
                    FacesUtils.addErrorMessage("No se puedo generar codigo QR-Respuesta:" + 
                                               respuesta);
                }
            } else {
                generoHistoria = false;
                FacesUtils.addErrorMessage("No existe Toma");
            }
        } catch (Exception e) {
            generoHistoria = false;
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
    }
    public void generarCopiaToma() {
        Object[] citologiaAux;
        Integer consecutivo;
        consecutivo = 0;
        index = -1;
        citologiaAux = (Object[])dtCopiaVph.getRowData();

        BigDecimal consecutivoBig = (BigDecimal)citologiaAux[0];
        if (consecutivoBig != null) {

            consecutivo = consecutivoBig.intValue();
        }
        clearFormularioVphLectura();
        clearFormularioVphToma();
        clearCodigoQRVPH();

        toma = null;
        lectura = null;
        lecturaVPH = null;


        if (citologiaAux != null) {
            try {
                citologia = 
                        serviceLocator.getClinicoService().getEncabezadoCitologia(consecutivo);
                toma = serviceLocator.getClinicoService().getTomaCitologia(consecutivo);
                lecturaVPH = 
                        serviceLocator.getClinicoService().getLecturaCitologiaVph(citologia.getCcinconsec());
                entrega = 
                        serviceLocator.getClinicoService().getLibroCitologia(citologia.getCcinconsec());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        try {
        if(toma != null && toma.getCtmnconsec()!= null){
            obtenerDatosReporteVPHToma();

            URL url = null;
            URL url_profamilia = null;
            URL url_firma = null;

            url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/TomaTipificacionVPH FO_GS_AD-020.jasper");
            url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_NEW);

            URL url_super_horizontal = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
            URL url_super_vertical = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);

            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                byte[] bytes;

                JasperReport report = (JasperReport)JRLoader.loadObject(url);

                bytes = 
                        JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                PdfServletUtils.showPdfDocument(bytes, 
                                                "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);

                generoHistoria = true;
            }
            }else{
                generoHistoria = false;
                FacesUtils.addErrorMessage("No existe Toma");
            }
        } catch (Exception e) {
            generoHistoria = false;
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }

    }

    public void setLecturaVPH(Cncitovphlect lecturaVPH) {
        this.lecturaVPH = lecturaVPH;
    }

    public Cncitovphlect getLecturaVPH() {
        return lecturaVPH;
    }

    public void obtenerDatosReporteVPHToma() {

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

                if (aseguradoraAux != null) {
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
            if (toma.getCtmcusureg() != null) {
                try {
                    Cpprofesio profesional = 
                        this.serviceLocator.getClinicoService().getProfesionalPorUsuario(toma.getCtmcusureg(), 
                                                                                         toma.getCtmnclinic());
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
                planeaEmbarazoAntesAnho = "";

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
            if (toma.getCtmccomvph() != null) {
                completoVph = toma.getCtmccomvph();
            }
            if (toma.getCtmclactan() != null) {
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

    public void setCodigoQRClient(CodigoQRClient codigoQRClient) {
        this.codigoQRClient = codigoQRClient;
    }

    public CodigoQRClient getCodigoQRClient() {
        return codigoQRClient;
    }

    public void setConsecutivoCito(Integer consecutivoCito) {
        this.consecutivoCito = consecutivoCito;
    }

    public Integer getConsecutivoCito() {
        return consecutivoCito;
    }
}
