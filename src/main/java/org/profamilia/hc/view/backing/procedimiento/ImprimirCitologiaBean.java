package org.profamilia.hc.view.backing.procedimiento;

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

import net.sf.jasperreports.engine.JRDataSource;

import net.sf.jasperreports.engine.JRField;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cncitotoma;
import org.profamilia.hc.model.dto.Cndesccito;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

public class ImprimirCitologiaBean extends BaseBean implements JRDataSource {


    private Date fechaActual;

    private List<Chconsulta> lstCitologia;

    private HtmlDataTable dtCitologia;

    private Cncitotoma toma;

    private Cncitologi citologia;

    private int index = -1;

    private static int NUMERO_COPIAS = 1;

    private boolean generoCitologia;
    
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
    String TOMADA;
    Date FECHA_TOMADA;
    String NOMBRE_TOMADA;
    Integer NUMERO_CITOLOGIA;
    Date FECHA_VPH;

    Integer DOSIS_VPH;
    String VPH;
    String OBSERVACIONES_TOMA;
    String OTROS_HALLAZGOS;

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
    String VAPORIZACION;
    Date FECHA_VAPORIZACION;
    String HORMONAL;
    Date FECHA_HORMONAL;
    BigDecimal TIEMPO_METODO;
    String COMPLETO_VPH;
    String LACTANCIA_ACTUAL;
    String OTROS_HALLAZGOS_TOMA;


    public ImprimirCitologiaBean() {
        generoCitologia = false;
    }

    public void init() {
        generoCitologia = false;
    }


    public void changeCitologias() {
        try {
            lstCitologia = 
                    this.serviceLocator.getClinicoService().getCitologiasImpresionUsuario(userName(), 
                                                                                          this.getClinica().getCclncodigo(), 
                                                                                          fechaActual);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * @param fechaActual
     */
    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    /**
     * @return
     */
    public Date getFechaActual() {
        return fechaActual;
    }


    /**
     * @param valueChangeEvent
     */
    public void setFechaActual(ValueChangeEvent valueChangeEvent) {
        setFechaActual((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param lstCitologia
     */
    public void setLstCitologia(List<Chconsulta> lstCitologia) {
        this.lstCitologia = lstCitologia;
    }

    /**
     * @return
     */
    public List<Chconsulta> getLstCitologia() {
        return lstCitologia;
    }

    /**
     * @param dtCitologia
     */
    public void setDtCitologia(HtmlDataTable dtCitologia) {
        this.dtCitologia = dtCitologia;
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
        } else if (fieldName.equals("MES_PARTO")) {
                value = MES_PARTO;
        } else if (fieldName.equals("ANNO_PARTO")) {
                value = ANNO_PARTO;
        }  else if (fieldName.equals("EDAD_RELACIONES")) {
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
        } else if (fieldName.equals("OTROS_HALLAZGOS")) {
            value = OTROS_HALLAZGOS;
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
        } else if (fieldName.equals("OTROS_HALLAZGOS_TOMA")) {
            value = OTROS_HALLAZGOS_TOMA;
        }


        return value;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCitologia() {
        return dtCitologia;
    }

    public String ImprimirCitologia() {

        Chconsulta consultacito = null;
        consultacito = (Chconsulta)dtCitologia.getRowData();
        clean();
        obtenerDatosReporte(consultacito);

        if(consultacito!= null && consultacito.getHcolnumero() != null )
        try {
            esPolicia = serviceLocator.getClinicoService().esPoliciaNacional(consultacito.getHcolnumero().intValue()) ;
        } catch (ModelException e) {
           e.printStackTrace();
        }
        try {
            index = -1;
            
            URL url = null;
            URL url_profamilia = null;
            if(esPolicia){
                 url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/tomaCitologiaPolicia.jasper");    
                 url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_POLICIA);
            }else{
                 url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/tomaCitologia.jasper");    
                    
                url_profamilia = 
                   FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
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
                byte[] bytes;

                JasperReport report = (JasperReport)JRLoader.loadObject(url);

                bytes = 
                        JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                PdfServletUtils.showPdfDocument(bytes, 
                                                "Citologia" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);
                generoCitologia = true;
            }
        } catch (Exception e) {
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
            e.printStackTrace();

        }
        return null;
    }


    public void obtenerDatosReporte(Chconsulta consulcito) {
        List lstAspectoSelect = null;
        lstAspectoSelect = new ArrayList();

        if (consulcito != null && consulcito.getHcolnumero() != null) {
            try {
                citologia = 
                        this.serviceLocator.getClinicoService().getUsuarioCitologia(consulcito);
                        
             
                        
                if (citologia != null) {
                    toma = 
serviceLocator.getClinicoService().getTomaCitologia(citologia.getCcinconsec());
                }


            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (citologia != null && toma != null) {

            if (citologia.getCcinnumdoc() != null) {
                NUMERO_FAC = citologia.getCcinnumdoc().toString();

                if (NUMERO_FAC != null && NUMERO_FAC.length() > 7) {
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
                    OTROS_HALLAZGOS = toma.getCtmcotrhal();
                    OTROS_HALLAZGOS_TOMA = toma.getCtmcotrhal();
                }

                if (toma.getCtmcotrmet() != null) {
                    OTRO_METODO = toma.getCtmcotrmet();
                }


                if (toma.getCtmcobstom() != null) {
                    OBSERVACIONES_TOMA = toma.getCtmcobstom();
                }
                if (toma.getCtmdultmen() != null) {

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
                        ESQUEMA_CITOLOGIA = esquemades.getCdicdescri();
                    }

                }

                if (toma.getCtmcmetpla() != null) {
                    METODO_PLANIFICACION = toma.getCtmcmetpla();

                }


                if (toma.getCtmcultres() != null) {

                    RESULTADO_CITOLOGIA = toma.getCtmcultres();

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

                    if (toma.getCtmcpdotro() != null) {
                        OTRO_CUAL = toma.getCtmcpdotro();
                    }
                    if (toma.getCtmcpningu() != null) {
                        NINGUNO = toma.getCtmcpningu();
                    }

                    if (toma.getCtmcpcaute() != null) {
                        CAUTERIZACION = toma.getCtmcpcaute();
                    }
                    if (toma.getCtmcphiste() != null) {
                        HISTERECTOMIA = toma.getCtmcphiste();
                    }
                    if (toma.getCtmcpconiz() != null) {
                        CONIZACION = toma.getCtmcpconiz();
                    }
                    if (toma.getCtmcpradio() != null) {
                        RADIOTERAPIA = toma.getCtmcpradio();
                    }
                    if (toma.getCtmcpbiops() != null) {
                        BIOPSIA = toma.getCtmcpbiops();
                    }
                    if (toma.getCtmcpcriot() != null) {
                        CRIOTERAPIA = toma.getCtmcpcriot();
                    }
                    if (toma.getCtmcpata() != null) {
                        ATA = toma.getCtmcpata();
                    }
                    if (toma.getCtmcpotro() != null) {
                        OTRO = toma.getCtmcpotro();
                    }

                    if (toma.getCtmctomada() != null) {
                        TOMADA = toma.getCtmctomada();
                    }

                    if (toma.getCtmcpvapor() != null) {
                        VAPORIZACION = toma.getCtmcpvapor();
                    }

                    if (toma.getCtmdpvapor() != null) {
                        FECHA_VAPORIZACION = toma.getCtmdpvapor();
                    }


                    if (toma.getCtmcphormo() != null) {
                        HORMONAL = toma.getCtmcphormo();
                    }

                    if (toma.getCtmdphormo() != null) {
                        FECHA_HORMONAL = toma.getCtmdphormo();
                    }

                    if (toma.getCtmntiemet() != null) {
                        TIEMPO_METODO = toma.getCtmntiemet();
                    }


                    if (toma.getCtmccomvph() != null) {
                        COMPLETO_VPH = formatearCampo(toma.getCtmccomvph());
                    }

                    if (toma.getCtmclactan() != null) {
                        LACTANCIA_ACTUAL = 
                                formatearCampo(toma.getCtmclactan());
                    }

                    if (toma.getCtmdfecreg() != null) {

                        FECHA_TOMADA = toma.getCtmdfecreg();
                    }

                    if (toma.getCtmcnomtom() != null) {
                        NOMBRE_TOMADA = toma.getCtmcnomtom();
                    }


                    if (getClinica() != null) {
                        CENTRO = getClinica().getCclcnombre();
                    }


                }

            }


        }


    }


    /**
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param generoCitologia
     */
    public void setGeneroCitologia(boolean generoCitologia) {
        this.generoCitologia = generoCitologia;
    }

    /**
     * @return
     */
    public boolean isGeneroCitologia() {
        return generoCitologia;
    }


    public void clean() {
        APELLIDOS = null;
        NOMBRES = null;
        NUMERO_DOCUMENTO = null;
        TIPO_DOCUMENTO = null;
        DIRECCION = null;
        TELEFONO = null;
        CIUDAD = null;
        DEPARTAMENTO = null;
        OTRA_DIRECCION = null;
        OTRO_TELEFONO = null;
        OTRA_CIUDAD = null;
        OTRO_DEPARTAMENTO = null;
        EDAD = null;
        FECHA_REGLA = null;
        DIA_REGLA = "";
        MES_REGLA = "";
        ANNO_REGLA = "";

        GESTACIONES = null;
        PARTOS = null;
        ABORTOS = null;
        TIPO_AFILIACION = null;
        ASEGURADORA = null;
        ESQUEMA_CITOLOGIA = null;
        APECTO_CUELLO = null;

        FECHA_PARTO = null;
        DIA_PARTO = "";
        MES_PARTO = "";
        ANNO_PARTO = "";

        ESTA_EMBARAZADA = null;
        EDAD_RELACIONES = null;
        METODO_PLANIFICACION = null;
        FECHA_CITOLOGIA = null;
        DIA_CITOLOGIA = "";
        MES_CITOLOGIA = "";
        ANNO_CITOLOGIA = "";
        RESULTADO_CITOLOGIA = null;

        FECHA_CAUTERIZACION = null;
        FECHA_HISTERECTOMIA = null;
        FECHA_CONIZACION = null;
        FECHA_RADIOTERAPIA = null;
        FECHA_BIOPSA = null;
        FECHA_CRIOTERAPIA = null;
        FECHA_ATA = null;
        FECHA_OTRO = null;
        OTRO_CUAL = null;
        NINGUNO = null;
        CAUTERIZACION = null;
        HISTERECTOMIA = null;
        CONIZACION = null;
        RADIOTERAPIA = null;
        BIOPSIA = null;
        CRIOTERAPIA = null;
        ATA = null;
        OTRO = null;
        TOMADA = null;
        FECHA_TOMADA = null;
        NOMBRE_TOMADA = null;
        NUMERO_CITOLOGIA = null;
        FECHA_VPH = null;

        DOSIS_VPH = null;
        VPH = null;
        OBSERVACIONES_TOMA = null;
        OTROS_HALLAZGOS = null;

        OTRO_METODO = null;

        ES_SANO = null;
        ES_AUSENTE = null;
        ES_EROSIONADO = null;
        ES_CONGESTIVO = null;
        ES_ATROFICO = null;
        ES_ULCERADO = null;
        ES_SANGRANTE = null;
        ES_LESION_VISIBLE = null;
        ES_POLIPO = null;

        CENTRO = null;
        NUMERO_FAC = null;
        VAPORIZACION = "";
        FECHA_VAPORIZACION = null;
        HORMONAL = "";
        FECHA_HORMONAL = null;

        TIEMPO_METODO = null;
        COMPLETO_VPH = null;
        LACTANCIA_ACTUAL = null;
    }

}
