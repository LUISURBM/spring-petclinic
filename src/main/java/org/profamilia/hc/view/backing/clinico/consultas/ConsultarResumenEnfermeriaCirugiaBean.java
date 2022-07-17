package org.profamilia.hc.view.backing.clinico.consultas;

import java.math.BigDecimal;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chcanalivena;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chnotaenferm;
import org.profamilia.hc.model.dto.Chreporte;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chsignovital;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


public class ConsultarResumenEnfermeriaCirugiaBean extends BaseBean implements JRDataSource {


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

    private Long codigoCirugia;


    /** Almacena true si genero el folio seleccionado */
    private

    boolean generoHistoria;

    private List<Chreporte> lstReporte;

    private boolean wexito;

    private List<Chconsulta> lstResumen;

    StringBuffer sbuffer = new StringBuffer();

    private boolean mostrarReporte;

    String titulo = "";
    int total = 0;

    private int index = -1;

    List<String> datos = new ArrayList<String>();

    private boolean print;

    private boolean encabezado;

    Date FECHA_NACIMIENTO;
    Integer EDAD;
    Long NUMERO_DOCUMENTO;
    String IMPRIMIO;
    String NOMBRE;
    String CENTRO;
    String SEXO;
    String DIRECCION;
    String TELEFONO;
    String CIUDAD;
    String OCUPACION;
    String ESTADO_CIVIL;
    String RESPONSABLE;
    String PARENTESCO_RESPONSABLE;
    String TELEFONO_RESPONSABLE;


    public ConsultarResumenEnfermeriaCirugiaBean() {
    }

    public void init() {
        sbuffer = new StringBuffer();
        generoHistoria = false;
        print = true; 
        listSexos = new ArrayList<SelectItem>();
        listEstadoCivil = new ArrayList<SelectItem>();
        listTipoIdentificacion = new ArrayList<SelectItem>();
        lstReporte = new ArrayList<Chreporte>();
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

    public void setEncabezado(boolean encabezado) {
        this.encabezado = encabezado;
    }

    public boolean isEncabezado() {
        return encabezado;
    }

    public void setPrint(boolean print) {
        this.print = print;
    }

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

    public void setListTipoIdentificacion(List<SelectItem> param) {
        this.listTipoIdentificacion = param;
    }

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


    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setCodigoCirugia(Long codigoCirugia) {
        this.codigoCirugia = codigoCirugia;
    }

    public Long getCodigoCirugia() {
        return codigoCirugia;
    }


    public void setMostrarReporte(boolean mostrarReporte) {
        this.mostrarReporte = mostrarReporte;
    }

    public boolean isMostrarReporte() {
        return mostrarReporte;
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

        if (fieldName.equals("FECHA")) {
            value = new Date();
        } else if (fieldName.equals("FECHA_NACIMIENTO")) {
            value = FECHA_NACIMIENTO;
        } else if (fieldName.equals("EDAD")) {
            value = EDAD;
        } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = NUMERO_DOCUMENTO;
        } else if (fieldName.equals("IMPRIMIO")) {
            value = IMPRIMIO;
        } else if (fieldName.equals("NOMBRE")) {
            value = NOMBRE;
        } else if (fieldName.equals("CENTRO")) {
            value = CENTRO;
        } else if (fieldName.equals("SEXO")) {
            value = SEXO;
        } else if (fieldName.equals("DIRECCION")) {
            value = DIRECCION;
        } else if (fieldName.equals("TELEFONO")) {
            value = TELEFONO;
        } else if (fieldName.equals("CIUDAD")) {
            value = CIUDAD;
        } else if (fieldName.equals("OCUPACION")) {
            value = OCUPACION;
        } else if (fieldName.equals("ESTADO_CIVIL")) {
            value = ESTADO_CIVIL;
        } else if (fieldName.equals("RESPONSABLE")) {
            value = RESPONSABLE;
        } else if (fieldName.equals("PARENTESCO_RESPONSABLE")) {
            value = PARENTESCO_RESPONSABLE;
        } else if (fieldName.equals("TELEFONO_RESPONSABLE")) {
            value = TELEFONO_RESPONSABLE;
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
        } else if (fieldName.equals("NUMERO_CONSULTA")) {
            value = lstReporte.get(index).getHrenconsulta();
        } else if (fieldName.equals("FECHA_REGISTRO")) {
            value = lstReporte.get(index).getHredfecharegis();
        } else if (fieldName.equals("FECHA_INICIAL")) {
            value = fechaInicial;
        } else if (fieldName.equals("FECHA_FINAL")) {
            value = fechaFinal;
        }
        return value;
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


    public void setDatos(Chconsulta consulta) {

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
        }


    }


    public String volverConsulta() {
        FacesUtils.resetManagedBean("consultarUsuarioResumenBean");
        FacesUtils.resetManagedBean("consultarFoliosBean");
        mostrarReporte = false;
        generoHistoria = false;
        return BeanNavegacion.RUTA_IR_INICIO;
    }


    public void consultarResumen() {

        this.index = -1;
        mostrarReporte = false;
        wexito = true;
        JasperPrint jasperPrint = null;
        lstReporte = new ArrayList<Chreporte>();

        try {
            lstResumen = 
                    this.getServiceLocator().getClinicoService().getResumenEnfermeriaCirugiaActual(codigoCirugia);


        } catch (ModelException e) {
            e.printStackTrace();
        }


        if (lstResumen == null || lstResumen.isEmpty()) {
            generarReporteVacio();
            FacesUtils.addErrorMessage(IConstantes.MSG_SIN_DATOS);
        }
        if (wexito) {
            mostrarReporte = true;
            try {
                generarReporte();
                URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/Resumen_Enfermeria.jasper");
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

                    request.getSession().setAttribute("jasperPrint", 
                                                      jasperPrint);


                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
            }
        }


    }


    public void imprimirResumen() {
        this.index = -1;
        wexito = true;
        lstReporte = new ArrayList<Chreporte>();

        try {

            lstResumen = 
                    this.getServiceLocator().getClinicoService().getResumenEnfermeriaCirugiaActual(codigoCirugia);


        } catch (ModelException e) {
            e.printStackTrace();
        }


        if (lstResumen == null || lstResumen.isEmpty()) {
            wexito = false;
            generoHistoria = false;
        }
        if (wexito) {
            try {
                generarReporte();
               URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/Resumen_Enfermeria.jasper");
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
                            JasperRunManager.runReportToPdf(report, 
                                                            parameters, 
                                                            (JRDataSource)this);


                    PdfServletUtils.showPdfDocument(bytes, 
                                                    "HistoriaClinica" + Calendar.getInstance().getTimeInMillis() + 
                                                    ".pdf", true);

                    generoHistoria = true;

                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
            }

        }

    }

    public void generarReporte() {
        if (lstResumen != null && !lstResumen.isEmpty()) {
            Iterator it = lstResumen.iterator();
            while (it.hasNext()) {
                Chconsulta consul = (Chconsulta)it.next();
                setDatos(consul);
            }

        }
    }


    public void generarReporteVacio() {
        setDatos(null);
    }


}


