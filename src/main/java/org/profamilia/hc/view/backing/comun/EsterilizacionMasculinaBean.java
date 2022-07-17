//=======================================================================
// ARCHIVO EsterilizacionFemeninaBean.java
// FECHA CREACI�N: 12/08/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes cuestionaro sobre esterilizacion Masculina.
//=======================================================================
package org.profamilia.hc.view.backing.comun;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================
import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;

import net.sf.jasperreports.engine.JRField;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chestermascu;
import org.profamilia.hc.model.dto.Chreporte;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;
//=======================================================================
//  CLASE EsterilizacionMasculinaBean
//=======================================================================
public class EsterilizacionMasculinaBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    private Chestermascu esterilizacion;

    private List lstOpciones;

    private String menuBean;

    private String nextAction;

    private Long numeroConsulta;

    private String tipoServicio;

    private boolean generoConsentimiento;

    private String navigationRule;

    private int index = -1;

    private List<Chreporte> lstReporte;

    private Chusuario usuario;


    // Datos del Reporte

    String NOMBRE;
    Date FECHA_NACIMIENTO;
    String DIRECCION;
    String OCUPACION;
    String RESPONSABLE;
    Integer EDAD;
    String TELEFONO;
    String ESTADO_CIVIL;
    String PARENTESCO_RESPONSABLE;
    String SEXO;
    String CIUDAD;
    String TELEFONO_RESPONSABLE;
    String IMPRIMIO;
    String TIPO_DOCUMENTO;
    Long NUMERO_DOCUMENTO;
    String CENTRO;

    // DATOS REPORTE DE ESTERILIZACION 

    String HEMCINFORMETOD;
    String HEMCVASECDEFIN;
    String HEMCVASECFALLA;
    String HEMCVASECFALLANUEVO;
    String HEMCEXITOESPER;
    String HEMCINFORSUFIC;
    String HEMCACLARINFOR;
    String HEMCACLARDEFIN;
    String HEMCACLARFALLA;
    String HEMCACLARFALLANUEVO;
    String HEMCACLAREXITO;
    String HEMCACLARSUFIC;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public EsterilizacionMasculinaBean() {
    }

    public void init() {

        lstReporte = new ArrayList<Chreporte>();
    }

    public void inicializarEsterilizacion() {
        generoConsentimiento = false;

        if (numeroConsulta != null) {

            try {
                esterilizacion = 
                        this.getServiceLocator().getClinicoService().getEsterilizacionMasculina(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

        }

        if (esterilizacion == null) {
            esterilizacion = new Chestermascu();
        }

    }


    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaci�n fue ingresada correctamente en la base de datos
    //------------------------------------------------------------------------------------------------

    /**
     * @return
     */
    public boolean esValido() {

        Chestermascu esterilizacionAux;
        esterilizacionAux = null;

        if (numeroConsulta != null) {
            try {
                esterilizacionAux = 
                        this.getServiceLocator().getClinicoService().getEsterilizacionMasculina(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (esterilizacionAux != null) {
            return true;
        }

        return false;
    }


    //-----------------------------------------------------------------------
    //  Ajax
    //-----------------------------------------------------------------------

    public void changeTodosSi() {
        inicializarPreguntas("S");
    }

    public void changeTodosNo() {
        inicializarPreguntas("N");
    }


    public void changeNinguno() {
        inicializarPreguntas(null);
    }


    public void inicializarPreguntas(String opcion) {


        esterilizacion.setHemcexitoesper(opcion);
        esterilizacion.setHemcinformetod(opcion);
        esterilizacion.setHemcinforsufic(opcion);
        esterilizacion.setHemcvasecdefin(opcion);
        esterilizacion.setHemcvasecfalnue(opcion);


    }


    //-----------------------------------------------------------------------
    //  Boton Principal
    //-----------------------------------------------------------------------

    /**
     * @return
     */
    public String guardarCuestionario() {

        navigationRule = "";


        if (numeroConsulta != null) {
            esterilizacion.getId().setHemctiposerv(TIPO_CONSULTA);
            esterilizacion.getId().setHemlconsulta(numeroConsulta);
            esterilizacion.setHemcoperador(userName());
            esterilizacion.setHemdfecreg(new Date());
        }

        try {

            this.serviceLocator.getClinicoService().saveEsterilizacionMasculina(esterilizacion);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            // Se recarga el menu 
            FacesUtils.resetManagedBean(menuBean);
            navigationRule = nextAction;

        } catch (ModelException e) {
            e.printStackTrace();
            navigationRule = "";
        }

        // Se establece la siguiente accion de navegacion
        return navigationRule;

    }


    public String siguiente() {
        if (esValido()) {
            generoConsentimiento = false;
            return nextAction;
        }
        return null;
    }

    //-----------------------------------------------------------------------
    //  Jasper Report
    //-----------------------------------------------------------------------

    public boolean next() {
        index++;
        return (index < lstReporte.size());
    }

    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("NOMBRE")) {
            value = NOMBRE;
        } else if (fieldName.equals("TIPO_DOCUMENTO")) {
            value = TIPO_DOCUMENTO;
        } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = NUMERO_DOCUMENTO;
        } else if (fieldName.equals("FECHA_NACIMIENTO")) {
            value = FECHA_NACIMIENTO;
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
        } else if (fieldName.equals("NUMERO_CONSULTA")) {
            value = lstReporte.get(index).getHrenconsulta();
        } else if (fieldName.equals("FECHA_REGISTRO")) {
            value = lstReporte.get(index).getHredfecharegis();
        }
        return value;
    }

    public void obtenerDatosReporte() {
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
            if (usuario.getHusanumeiden() != null && 
                usuario.getHusanumeiden() != 0) {
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
        }

        if (esterilizacion != null) {

            HEMCINFORMETOD = 
                    formatearCampo(esterilizacion.getHemcinformetod());
            HEMCVASECDEFIN = 
                    formatearCampo(esterilizacion.getHemcvasecdefin());
            HEMCVASECFALLA = 
                    formatearCampo(esterilizacion.getHemcvasecfalla());
            HEMCVASECFALLANUEVO = formatearCampo(esterilizacion.getHemcvasecfalnue());

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
            HEMCACLARFALLANUEVO = 
            formatearCampo(esterilizacion.getHemcaclarfalnue());
            HEMCACLAREXITO = 
                    formatearCampo(esterilizacion.getHemcaclarexito());
            HEMCACLARSUFIC = 
                    formatearCampo(esterilizacion.getHemcaclarsufic());


        }


    }


    public void generarConsentimiento() {
        this.index = -1;
        setDatos();

        try {
            URL url = 
                FacesUtils.getFacesContext().getExternalContext().getResource("/reports/cuestionarioEsterilizacion.jasper");
            URL url_profamilia = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
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
                                                "EsterilizacionMasculina" + 
                                                Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);

                generoConsentimiento = true;


            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
    }

    public void setDatos() {
        obtenerDatosReporte();
        lstReporte = new ArrayList<Chreporte>();

        if (esterilizacion != null) {

            Chreporte report = new Chreporte();
            String s = "";
            String s2 = "";
            String s3 = "";

            s = "";
            s = 
  "1. Recibi� usted informaci�n o asesor�a sobre todos los m�todos temporales de planificaci�n familiar? ";
            s2 = HEMCINFORMETOD;
            s3 = HEMCACLARINFOR;
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizaci�n Masculina");
            report.setHrencodigo(1);
            report.setHrenconsulta(esterilizacion.getId().getHemlconsulta());
            report.setHredfecharegis(esterilizacion.getHemdfecreg());
            lstReporte.add(report);

            s = "";
            s = 
  "2. Sabe usted que la vasectom�a es un m�todo definitivo de planificaci�n familiar para el hombre? ";
            s2 = HEMCVASECDEFIN;
            s3 = HEMCACLARDEFIN;
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizaci�n Masculina");
            report.setHrencodigo(1);
            report.setHrenconsulta(esterilizacion.getId().getHemlconsulta());
            report.setHredfecharegis(esterilizacion.getHemdfecreg());
            lstReporte.add(report);


            s = "";
            s = 
             "3. Sabe usted que la vasectom�a puede fallar, aun anos despu�s, en uno de cada 500 operados?  ";
            s2 = HEMCVASECFALLA;
            s3 = HEMCACLARFALLA;
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizaci�n Masculina");
            report.setHrencodigo(1);
            report.setHrenconsulta(esterilizacion.getId().getHemlconsulta());
            report.setHredfecharegis(esterilizacion.getHemdfecreg());
            if(HEMCVASECFALLA != null && !HEMCVASECFALLA.equals("")){
                lstReporte.add(report);    
            }
            
            
            s = "";
            s = 
             "3. Sabe usted que la vasectom�a puede fallar, aun anos despu�s, entre 1 y 5 de cada 100  ?  ";
            s2 = HEMCVASECFALLANUEVO;
            s3 = HEMCACLARFALLANUEVO;
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizaci�n Masculina");
            report.setHrencodigo(1);
            report.setHrenconsulta(esterilizacion.getId().getHemlconsulta());
            report.setHredfecharegis(esterilizacion.getHemdfecreg());
            if(HEMCVASECFALLANUEVO != null && !HEMCVASECFALLANUEVO.equals("")){
                lstReporte.add(report);    
            }


            s = "";
            s = 
  "4. Sabe usted que es necesario comprobar el �xito de la vasectom�a, realiz�ndose un espermograma de control a los tres meses de operado? ";
            s2 = HEMCEXITOESPER;
            s3 = HEMCACLAREXITO;
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizaci�n Masculina");
            report.setHrencodigo(1);
            report.setHrenconsulta(esterilizacion.getId().getHemlconsulta());
            report.setHredfecharegis(esterilizacion.getHemdfecreg());
            lstReporte.add(report);


            s = "";
            s = 
  "5. Recibi� informaci�n suficiente para suscribir el consentimiento informado para vasectom�a? ";
            s2 = HEMCINFORSUFIC;
            s3 = HEMCACLARSUFIC;
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizaci�n Masculina");
            report.setHrencodigo(1);
            report.setHrenconsulta(esterilizacion.getId().getHemlconsulta());
            report.setHredfecharegis(esterilizacion.getHemdfecreg());
            lstReporte.add(report);


        }


        if (lstReporte == null || lstReporte.isEmpty()) {

            Chreporte report = new Chreporte();
            String s = "No se encontrar�n Registros  ";

            report.setHrecdescripcio(s);
            report.setHrencodigo(0);
            lstReporte.add(report);

        }
    }


    // ACCESSORS


    /**
     * @param lstOpciones
     */
    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    /**
     * @return
     */
    public List getLstOpciones() {
        if (lstOpciones == null || lstOpciones.isEmpty()) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
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
     * @param nextAction
     */
    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    /**
     * @return
     */
    public String getNextAction() {
        return nextAction;
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
     * @param generoConsentimiento
     */
    public void setGeneroConsentimiento(boolean generoConsentimiento) {
        this.generoConsentimiento = generoConsentimiento;
    }

    /**
     * @return
     */
    public boolean isGeneroConsentimiento() {
        return generoConsentimiento;
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
     * @param esterilizacion
     */
    public void setEsterilizacion(Chestermascu esterilizacion) {
        this.esterilizacion = esterilizacion;
    }

    /**
     * @return
     */
    public Chestermascu getEsterilizacion() {
        return esterilizacion;
    }
}
