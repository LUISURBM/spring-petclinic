package org.profamilia.hc.view.backing.comun.consulta;

import java.math.BigDecimal;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chdatosvph;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chlibrovph;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chvphlect;
import org.profamilia.hc.model.dto.Chvphtoma;
import org.profamilia.hc.model.dto.Cndesccito;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorUsuariosBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

public class ConsultarCopiaVphBeanbk extends BaseBean implements JRDataSource {

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

    /**
     * Almacena la lista de los posibles estados civil
     */
    private List<SelectItem> listEstadoCivil;

    /**
     * Lista que almacena la lista de tipos de documentos
     */
    private List<SelectItem> listTipoIdentificacion;

    private Integer edad;

    private List lstVphUsuario;

    private HtmlDataTable dtCopiaVph;

    private Chvphtoma toma;

    private Chvphlect lectura;

    private Chdatosvph vph;

    private int index = -1;

    private static int NUMERO_COPIAS = 1;

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
    String HVLCGT16;
    String HVLCGT18;
    String HVLCGT31;
    String HVLCGT45;
    String HVLCGT51;
    String HVLCGT52;
    String HVLCGT3858;
    String HVLCGT353968;
    String HVLCGT565966;

    String LECTURA;
    Date FECHA_LECTURA;
    String NOMBRE_LECTURA;
    String TARJETA_PROFESIONAL_LECTURA;
    String CONDUCTA;

    public ConsultarCopiaVphBeanbk() {
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
        } else if (fieldName.equals("TARJETA_PROFESIONAL_TOMA")) {
            value = TARJETA_PROFESIONAL_TOMA;
        } else if (fieldName.equals("OBSERVACIONES_TOMA")) {
            value = OBSERVACIONES_TOMA;
        } else if (fieldName.equals("NUMERO_TIPIFICACION")) {
            value = NUMERO_TIPIFICACION;
        } else if (fieldName.equals("FECHA_VPH")) {
            value = FECHA_VPH;
        } else if (fieldName.equals("DOSIS_VPH")) {
            value = DOSIS_VPH;
        } else if (fieldName.equals("VPH")) {
            value = VPH;
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
        } else if (fieldName.equals("LECTURA")) {
            value = LECTURA;
        } else if (fieldName.equals("FECHA_LECTURA")) {
            value = FECHA_LECTURA;
        } else if (fieldName.equals("NOMBRE_LECTURA")) {
            value = NOMBRE_LECTURA;
        } else if (fieldName.equals("TARJETA_PROFESIONAL_LECTURA")) {
            value = TARJETA_PROFESIONAL_LECTURA;
        } else if (fieldName.equals("CONDUCTA")) {
            value = CONDUCTA;
        }

        return value;
    }

    public void obtenerDatosReporte(Integer numeroconsec) {
        List lstAspectoSelect = null;
        lstAspectoSelect = new ArrayList();

        if (numeroconsec != null) {
            try {
                vph
                        = this.serviceLocator.getClinicoService().getEncabezadoVph(numeroconsec);
                if (vph != null) {
                    toma
                            = serviceLocator.getClinicoService().getTomaVph(numeroconsec);
                }

            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (vph != null && toma != null) {

            if (vph.getHdvnnumdoc() != null) {
                NUMERO_FAC = vph.getHdvnnumdoc().toString();

                if (NUMERO_FAC != null && NUMERO_FAC.length() > 6) {
                    NUMERO_FAC
                            = NUMERO_FAC.substring(NUMERO_FAC.length() - 6, NUMERO_FAC.length());
                }

            }

            if (vph != null) {
                if (vph.getHdvnconsec() != null) {
                    NUMERO_TIPIFICACION = vph.getHdvnconsec();
                }
                if (vph.getHdvcprinom() != null) {
                    NOMBRES = vph.getHdvcprinom() + " ";
                }
                if (vph.getHdvcsegnom() != null
                        && !vph.getHdvcsegnom().equals("_")) {
                    NOMBRES = NOMBRES + vph.getHdvcsegnom();
                }
                if (vph.getHdvcpriape() != null) {
                    APELLIDOS = vph.getHdvcpriape() + " ";
                }
                if (vph.getHdvcsegape() != null
                        && !vph.getHdvcsegape().equals("_")) {
                    APELLIDOS = APELLIDOS + vph.getHdvcsegape();
                }
                if (vph.getHdvctipide() != null) {
                    TIPO_DOCUMENTO = vph.getHdvctipide();
                }
                if (vph.getHdvanumide() != 0) {
                    NUMERO_DOCUMENTO = vph.getHdvanumide();
                }
                if (vph.getHdvcdirecc() != null) {
                    DIRECCION = vph.getHdvcdirecc();
                }
                if (vph.getHdvctelefo() != null) {
                    TELEFONO = vph.getHdvctelefo();
                }
                Integer idCiudad = null;
                Integer idDepartamento = null;
                Cpmunidane ciudadObject = null;
                if (vph.getHdvnmunici() != null
                        && vph.getHdvndepart() != null) {
                    idCiudad = vph.getHdvnmunici();
                    idDepartamento = vph.getHdvndepart();
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

                if (vph.getHdvcotrdir() != null) {
                    OTRA_DIRECCION = vph.getHdvcotrdir();
                }
                if (vph.getHdvcotrtel() != null) {
                    OTRO_TELEFONO = vph.getHdvcotrtel();
                }

                Integer idOtraCiudad = null;
                Integer idOtroDepartamento = null;
                Cpmunidane ciudadOtraObject = null;
                if (vph.getHdvnotrmun() != null
                        && vph.getHdvnotrdep() != null) {
                    idOtraCiudad = vph.getHdvnotrmun();
                    idOtroDepartamento = vph.getHdvnotrdep();
                }
                if (vph.getHdvnedad() != null) {
                    EDAD = vph.getHdvnedad();
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

                if (vph.getHdvctipafi() != null) {
                    if (vph.getHdvctipafi().equals("C")) {
                        TIPO_AFILIACION = "CONTRIBUTIVO";
                    }
                    if (vph.getHdvctipafi().equals("E")) {
                        TIPO_AFILIACION = "ESPECIAL";
                    }
                    if (vph.getHdvctipafi().equals("R")) {
                        TIPO_AFILIACION = "SUBSIDIO PARCIAL";
                    }
                    if (vph.getHdvctipafi().equals("S")) {
                        TIPO_AFILIACION = "SUBSIDIADO";
                    }
                    if (vph.getHdvctipafi().equals("V")) {
                        TIPO_AFILIACION = "VINCULADO";
                    }
                    if (vph.getHdvctipafi().equals("X")) {
                        TIPO_AFILIACION = "NINGUNO";
                    }

                }

                if (vph.getHdvcasegur() != null) {
                    Cpentidadadm aseguradora;
                    aseguradora = null;

                    try {
                        aseguradora
                                = serviceLocator.getClinicoService().getAseguradoraPorCodigo(vph.getHdvcasegur());
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

                if (vph.getHdvcidengen() != null) {
                    IDENTIDAD_GENERO = vph.getHdvcidengen();
                }

                if (vph.getHdvcvulnera() != null) {
                    VULNERABILIDAD = vph.getHdvcvulnera();
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
                    NINGUNO = formatearCampoNulo(toma.getHvtcpningu());
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
                    CAUTERIZACION = formatearCampoNulo(toma.getHvtcpcaute());
                }
                if (toma.getHvtcphiste() != null) {
                    HISTERECTOMIA = formatearCampoNulo(toma.getHvtcphiste());
                }
                if (toma.getHvtcpconiz() != null) {
                    CONIZACION = formatearCampoNulo(toma.getHvtcpconiz());
                }
                if (toma.getHvtcpradio() != null) {
                    RADIOTERAPIA = formatearCampoNulo(toma.getHvtcpradio());
                }
                if (toma.getHvtcpbiops() != null) {
                    BIOPSIA = formatearCampoNulo(toma.getHvtcpbiops());
                }
                if (toma.getHvtcpcriot() != null) {
                    CRIOTERAPIA = formatearCampoNulo(toma.getHvtcpcriot());
                }
                if (toma.getHvtcpata() != null) {
                    ATA = formatearCampoNulo(toma.getHvtcpata());
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
                    OTRO = formatearCampoNulo(toma.getHvtcpotro());
                }
                if (toma.getHvtcpdotro() != null) {
                    OTRO_CUAL = formatearCampoNulo(toma.getHvtcpdotro());
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
                    TOMADA = formatearCampoNulo(toma.getHvtctomada());
                }
                if (toma.getHvtdfecreg() != null) {
                    FECHA_TOMADA = toma.getHvtdfecreg();
                }
                if (toma.getHvtcnomtom() != null) {
                    NOMBRE_TOMADA = formatearCampoNulo(toma.getHvtcnomtom());
                }

                if (vph.getHdvnclinic() != null) {
                    Cpclinica clinica = null;
                    try {
                        clinica = serviceLocator.getClinicoService().getClinica(vph.getHdvnclinic());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    CENTRO = clinica.getCclcnombre();
                }

                Chlibrovph libro = null;
                try {
                    libro = serviceLocator.getClinicoService().getLibroVph(vph.getHdvnconsec());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (libro != null && libro.getHlvcconducta() != null) {
                    CONDUCTA = libro.getHlvcconducta();
                }

                if (toma.getHvtcusureg() != null) {
                    Cpprofesio profesional;
                    profesional = null;
                    try {
                        if (vph.getHdvnclinic() != null) {
                            profesional = serviceLocator.getClinicoService().getProfesionalPorUsuario(toma.getHvtcusureg(),
                                    vph.getHdvnclinic());
                        }

                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (profesional != null) {
                        TARJETA_PROFESIONAL_TOMA = profesional.getCpfcregmedic();
                    }
                }

            }

            if (lectura != null) {

                if (lectura.getHvlcgenoneg() != null) {
                    GENOTIPIFICACION_NEG = lectura.getHvlcgenoneg();
                }
                if (lectura.getHvlcgt16() != null) {
                    HVLCGT16 = lectura.getHvlcgt16();
                }
                if (lectura.getHvlcgt18() != null) {
                    HVLCGT18 = lectura.getHvlcgt18();
                }
                if (lectura.getHvlcgt31() != null) {
                    HVLCGT31 = lectura.getHvlcgt31();
                }
                if (lectura.getHvlcgt45() != null) {
                    HVLCGT45 = lectura.getHvlcgt45();
                }
                if (lectura.getHvlcgt51() != null) {
                    HVLCGT51 = lectura.getHvlcgt51();
                }
                if (lectura.getHvlcgt52() != null) {
                    HVLCGT52 = lectura.getHvlcgt52();
                }
                if (lectura.getHvlcgt3858() != null) {
                    HVLCGT3858 = lectura.getHvlcgt3858();
                }
                if (lectura.getHvlcgt353968() != null) {
                    HVLCGT353968 = lectura.getHvlcgt353968();
                }
                if (lectura.getHvlcgt565966() != null) {
                    HVLCGT565966 = lectura.getHvlcgt565966();
                }

                if (lectura.getHvlclectur() != null) {
                    LECTURA = lectura.getHvlclectur();
                }
                if (lectura.getHvldfeclec() != null) {
                    FECHA_LECTURA = lectura.getHvldfeclec();
                }
                if (lectura.getHvlcnomlec() != null) {
                    NOMBRE_LECTURA = lectura.getHvlcnomlec();
                }

                if (lectura.getHvlcusureg() != null) {
                    Cpprofesio profesional;
                    profesional = null;
                    try {
                        if (vph.getHdvnclinic() != null) {
                            profesional = serviceLocator.getClinicoService().getProfesionalPorUsuario(lectura.getHvlcusureg(),
                                    lectura.getHvlnclinic());
                        }

                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (profesional != null) {
                        TARJETA_PROFESIONAL_LECTURA = profesional.getCpfcregmedic();
                    }
                }
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
            lstVphUsuario
                    = this.serviceLocator.getClinicoService().getCopiaVph(numeroUsuario);
        } catch (ModelException e) {
            e.printStackTrace();
        }

    }

    public void changeUsuario() {
        Chusuario usuarioAux = null;
        generoHistoria = false;
        nombreUsuario = "";
        usuario = new Chusuario();
        if (numeroUsuario != null) {
            try {
                usuarioAux
                        = this.serviceLocator.getClinicoService().getUsuario(numeroUsuario);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (usuarioAux != null) {
            if (usuarioAux.getHuscprimernomb() != null) {
                nombreUsuario = usuarioAux.getHuscprimernomb() + " ";
            }
            if (usuarioAux.getHuscsegundnomb() != null
                    && !usuarioAux.getHuscsegundnomb().equals("_")) {
                nombreUsuario
                        = nombreUsuario + usuarioAux.getHuscsegundnomb() + " ";
            }
            if (usuarioAux.getHuscprimerapel() != null) {
                nombreUsuario
                        = nombreUsuario + usuarioAux.getHuscprimerapel() + " ";
            }
            if (usuarioAux.getHuscsegundapel() != null
                    && !usuarioAux.getHuscsegundapel().equals("_")) {
                nombreUsuario = nombreUsuario + usuarioAux.getHuscsegundapel();
            }

            usuario = usuarioAux;

        }
    }

    /**
     * @param valueChangeEvent
     */
    public void setNumeroUsuario(ValueChangeEvent valueChangeEvent) {
        setNumeroUsuario((Long) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void aceptarUsuario() {
        selectedIndex = ACTIVAR_BEAN;

        usuario = new Chusuario();
        nombreUsuario = "";

        buscador
                = (BuscadorUsuariosBean) FacesUtils.getManagedBean("buscadorUsuariosBean");
        usuario = buscador.getUsuarioSelect();
        if (usuario != null) {
            numeroUsuario = usuario.getHuslnumero();
            if (usuario.getHuscprimernomb() != null) {
                nombreUsuario = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null
                    && !usuario.getHuscsegundnomb().equals("_")) {
                nombreUsuario
                        = nombreUsuario + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                nombreUsuario
                        = nombreUsuario + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null
                    && !usuario.getHuscsegundapel().equals("_")) {
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
                listSexoAux
                        = (ArrayList<Chsexo>) this.getServiceLocator().getClinicoService().getSexo();
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
                listEstadoCivilAux
                        = (ArrayList<Chestadociv>) this.getServiceLocator().getClinicoService().getEstadoCivil();
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
        if (listTipoIdentificacion == null
                || listTipoIdentificacion.isEmpty()) {
            listTipoIdentificacion = new ArrayList<SelectItem>();
            ArrayList<Cptipoiden> listTipoIdentificacionAux = null;
            try {
                listTipoIdentificacionAux
                        = (ArrayList<Cptipoiden>) this.serviceLocator.getClinicoService().getTipoIdentificacion();
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
    public void setDtCopiaVph(HtmlDataTable dtCopiaVph) {
        this.dtCopiaVph = dtCopiaVph;
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

        FacesUtils.resetManagedBean("consultarCopiaVphBean");
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        generoHistoria = false;
        return BeanNavegacion.RUTA_IR_INICIO;
    }

    public void clearReporte() {
        APELLIDOS = "";
        NOMBRES = "";
        NUMERO_DOCUMENTO = null;
        TIPO_DOCUMENTO = null;
        DIRECCION = "";
        TELEFONO = "";
        CIUDAD = "";
        DEPARTAMENTO = "";
        OTRA_DIRECCION = "";
        OTRO_TELEFONO = "";
        OTRA_CIUDAD = "";
        OTRO_DEPARTAMENTO = "";

        EDAD = null;
        EDAD_RELACIONES = null;
        ESTA_EMBARAZADA = "";
        FECHA_REGLA = null;
        METODO_PLANIFICACION = "";
        GESTACIONES = null;
        PARTOS = null;
        FECHA_PARTO = null;
        ABORTOS = null;
        TIPO_AFILIACION = "";
        ASEGURADORA = "";

        APECTO_CUELLO = "";
        FECHA_CITOLOGIA = null;
        RESULTADO_CITOLOGIA = "";

        FECHA_CAUTERIZACION = null;
        FECHA_HISTERECTOMIA = null;
        FECHA_CONIZACION = null;
        FECHA_RADIOTERAPIA = null;
        FECHA_BIOPSA = null;
        FECHA_CRIOTERAPIA = null;
        FECHA_ATA = null;
        FECHA_VAPORIZACION = null;
        FECHA_HORMONAL = null;
        FECHA_COLPOSCOPIA = null;
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
        VAPORIZACION = "";
        HORMONAL = "";
        COLPOSCOPIA = "";
        OTRO = "";

        TOMADA = "";
        FECHA_TOMADA = null;
        NOMBRE_TOMADA = "";
        TARJETA_PROFESIONAL_TOMA = "";
        OBSERVACIONES_TOMA = null;

        NUMERO_TIPIFICACION = null;
        FECHA_VPH = null;
        DOSIS_VPH = null;
        VPH = "";

        OTRO_METODO = "";
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

        NUMERO_FAC = "";
        TIEMPO_METODO = null;
        COMPLETO_VPH = "";
        LACTANCIA_ACTUAL = "";

        PLANEA_EMABARAZO_ANTES_1ANHO = "";
        FECHA_TIPIFICACION = null;

        IDENTIDAD_GENERO = "";
        VULNERABILIDAD = "";
        ESQUEMA_VPH = "";
        ESQUEMA_VPH_CUAL_OTRO = "";

        GENOTIPIFICACION_NEG = "";
        HVLCGT16 = "";
        HVLCGT18 = "";
        HVLCGT31 = "";
        HVLCGT45 = "";
        HVLCGT51 = "";
        HVLCGT52 = "";
        HVLCGT3858 = "";
        HVLCGT353968 = "";
        HVLCGT565966 = "";

        LECTURA = "";
        FECHA_LECTURA = null;
        NOMBRE_LECTURA = "";
        TARJETA_PROFESIONAL_LECTURA = "";

        CONDUCTA = "";

    }

    public void generarCopia() {
        Object[] vphAux;
        Integer consecutivo;
        consecutivo = 0;
        index = -1;
        vphAux = (Object[]) dtCopiaVph.getRowData();

        BigDecimal consecutivoBig = (BigDecimal) vphAux[0];
        if (consecutivoBig != null) {
            consecutivo = consecutivoBig.intValue();
        }

        clearReporte();

        if (vphAux != null) {
            try {
                vph = serviceLocator.getClinicoService().getEncabezadoVph(consecutivo);
                toma = serviceLocator.getClinicoService().getTomaVph(consecutivo);
                lectura = serviceLocator.getClinicoService().getLecturaVph(consecutivo);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        try {

            obtenerDatosReporte(consecutivo);

            URL url = null;
            URL url_profamilia = null;

            if (vph != null && vph.getHdvlconcli() != null) {
                try {
                    esPolicia = serviceLocator.getClinicoService().esPoliciaNacional(vph.getHdvlconcli().intValue());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }

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
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                byte[] bytes;

                JasperReport report = (JasperReport) JRLoader.loadObject(url);

                bytes
                        = JasperRunManager.runReportToPdf(report, parameters, (JRDataSource) this);
                PdfServletUtils.showPdfDocument(bytes,
                        "Documento" + Calendar.getInstance().getTimeInMillis()
                        + ".pdf", false);
                generoHistoria = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte "
                    + e.getMessage());
        }

    }

}
