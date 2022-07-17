package org.profamilia.hc.view.backing.clinico.consultas;

import java.net.URL;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import net.sf.jasperreports.engine.export.JRHtmlExporter;

import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chantecegene;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chhistoimpre;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chtipoantece;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class ConsultarAntecedentesBean extends BaseBean implements JRDataSource {

    private Chusuario usuario;


    /**Almacena los tipos de antecedentes  */
    private List<SelectItem> lstTipoAntecedentes;

    /** Almacena los codigos de los antecedentes seleccionados */
    private

    List<String> lstTipoAntecedenteSelect;

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

    public boolean wexito;

    /** Almacena el objeto de impresion */
    Chhistoimpre objetoImpresion;

    /** Almacena la consulta seleccionada*/
    Chconsulta consultaClone;

    /** Almacena la fecha inicial del reporte*/
    private Date fechaInicial;

    /** Almacena la fecha final del reporte*/
    private Date fechaFinal;

    /** Almacena true si se genero el reporte  */
    private boolean generoAntecedentes;

    /** Almacena la listas de las consultas asociadas al usuario */
    private

    List<Chconsulta> lstConsultas;

    StringBuffer sbuffer = new StringBuffer();
    
    private Integer tipoHistoria; 


    /** Almacenan los datos de la historia clinica */
    static String NOMBRE;
    static Long NUMERO_CONSULTA;
    static Date FECHA_NACIMIENTO;
    static Integer EDAD;
    static String SEXO;
    static String DIRECCION;
    static String TELEFONO;
    static String CIUDAD;
    static Date FECHA_CONSULTA;
    static String ANTECEDENTE_ALERGICOS = "";
    static String ANTECEDENTES_FAMILIARES = "";
    static String ANTECEDENTES_ITS = "";
    static String ANTECEDENTES_PATOLOGICOS = "";
    static String ANTECEDENTES_QUIRURGICOS = "";
    static String ANTECEDENTES_TOXICOS = "";
    static String ANTECEDENTES_TRANSFUNCIONALES = "";
    static String ANTECEDENTES_TRAUMATICOS = "";
    static String ANTECEDENTES_FARMACOLOGICOS = "";

    private int index = -1;


    public ConsultarAntecedentesBean() {
    }

    public void init() {

        listSexos = new ArrayList<SelectItem>();
        listEstadoCivil = new ArrayList<SelectItem>();
        listTipoIdentificacion = new ArrayList<SelectItem>();
        lstFolios = new ArrayList<Chconsulta>();
        generoAntecedentes = false;
        if (usuario == null) {
            usuario = new Chusuario();
        }

        lstTipoAntecedentes = new ArrayList<SelectItem>();
        lstTipoAntecedenteSelect = new ArrayList<String>();

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

    public void consultarFoliosUsuario() {
        if (usuario.getHuslnumero() != null) {
            try {
                lstFolios = 
                        this.getServiceLocator().getClinicoService().getFoliosUsuario(usuario.getHuslnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }


    }


    public void setDtFolios(HtmlDataTable dtFolios) {
        this.dtFolios = dtFolios;
    }

    public HtmlDataTable getDtFolios() {
        return dtFolios;
    }

    public void setLstFolios(List<Chconsulta> lstFolios) {
        this.lstFolios = lstFolios;
    }

    public List<Chconsulta> getLstFolios() {
        return lstFolios;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setGeneroAntecedentes(boolean generoAntecedentes) {
        this.generoAntecedentes = generoAntecedentes;
    }

    public boolean isGeneroAntecedentes() {
        return generoAntecedentes;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getEdad() {
        return edad;
    }

    /**
     * @return
     */
    public boolean next() {
        index++;
        return (index < lstConsultas.size());
    }

    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();
        Set<Chantecegene> hashAntecedentes = 
            (Set<Chantecegene>)lstConsultas.get(index).getChantecegenes();


        if (hashAntecedentes != null) {
            if (hashAntecedentes != null && !hashAntecedentes.isEmpty()) {
                Iterator it = hashAntecedentes.iterator();


                int i = 0;
                ANTECEDENTE_ALERGICOS = "";
                ANTECEDENTES_FAMILIARES = "";
                ANTECEDENTES_ITS = "";
                ANTECEDENTES_PATOLOGICOS = "";
                ANTECEDENTES_QUIRURGICOS = "";
                ANTECEDENTES_TOXICOS = "";
                ANTECEDENTES_TRANSFUNCIONALES = "";
                ANTECEDENTES_TRAUMATICOS = "";
                ANTECEDENTES_FARMACOLOGICOS = "";
                while (it.hasNext()) {

                    Chantecegene antecedente = (Chantecegene)it.next();
                    i++;
                    if (antecedente != null) {
                        if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_ALERGICOS)) {
                            ANTECEDENTE_ALERGICOS = 
                                    ANTECEDENTE_ALERGICOS + antecedente.getHantdescripcio() + 
                                    "\n ";
                        } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_FAMILIARES)) {
                            ANTECEDENTES_FAMILIARES = 
                                    ANTECEDENTES_FAMILIARES + antecedente.getHantdescripcio() + 
                                    "\n ";
                        } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_ITS)) {
                            ANTECEDENTES_ITS = 
                                    ANTECEDENTES_ITS + antecedente.getHantdescripcio() + 
                                    " \n ";
                        } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_PATOLOGICOS)) {
                            ANTECEDENTES_PATOLOGICOS = 
                                    ANTECEDENTES_PATOLOGICOS + 
                                    antecedente.getHantdescripcio() + "\n ";
                        } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_QUIRURGICOS)) {
                            ANTECEDENTES_QUIRURGICOS = 
                                    ANTECEDENTES_QUIRURGICOS + 
                                    antecedente.getHantdescripcio() + " \n";
                        } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_TOXICOS)) {
                            ANTECEDENTES_TOXICOS = 
                                    ANTECEDENTES_TOXICOS + antecedente.getHantdescripcio() + 
                                    " ";
                        } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_TRASNFUSIONALES)) {
                            ANTECEDENTES_TRANSFUNCIONALES = 
                                    ANTECEDENTES_TRANSFUNCIONALES + 
                                    antecedente.getHantdescripcio() + " \n";
                        } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_TRAUMATICOS)) {
                            ANTECEDENTES_TRAUMATICOS = 
                                    ANTECEDENTES_TRAUMATICOS + 
                                    antecedente.getHantdescripcio() + "\n ";
                        } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_FARMACOLOGICO)) {
                            ANTECEDENTES_FARMACOLOGICOS = 
                                    ANTECEDENTES_FARMACOLOGICOS + 
                                    antecedente.getHantdescripcio() + "\n ";
                        }
                    }
                }

            }

        }
        if (lstConsultas != null && !lstConsultas.isEmpty()) {
            if (fieldName.equals("FECHA")) {
                value = new Date();
            } else if (fieldName.equals("NOMBRE")) {
                value = NOMBRE;
            } else if (fieldName.equals("FECHA_NACIMIENTO")) {
                value = FECHA_NACIMIENTO;
            } else if (fieldName.equals("EDAD")) {
                value = EDAD;
            } else if (fieldName.equals("SEXO")) {
                value = SEXO;
            } else if (fieldName.equals("DIRECCION")) {
                value = DIRECCION;
            } else if (fieldName.equals("TELEFONO")) {
                value = TELEFONO;
            } else if (fieldName.equals("CIUDAD")) {
                value = CIUDAD;
            } else if (fieldName.equals("FECHA_CONSULTA")) {
                if (lstConsultas.get(index) != null)
                    FECHA_CONSULTA = 
                            lstConsultas.get(index).getHcodfecregistr();
                value = FECHA_CONSULTA;
            } else if (fieldName.equals("ANTECEDENTE_ALERGICOS")) {
                value = ANTECEDENTE_ALERGICOS;
            } else if (fieldName.equals("ANTECEDENTES_FAMILIARES")) {
                value = ANTECEDENTES_FAMILIARES;
            } else if (fieldName.equals("ANTECEDENTES_ITS")) {
                value = ANTECEDENTES_ITS;
            } else if (fieldName.equals("ANTECEDENTES_PATOLOGICOS")) {
                value = ANTECEDENTES_PATOLOGICOS;
            } else if (fieldName.equals("ANTECEDENTES_QUIRURGICOS")) {
                value = ANTECEDENTES_QUIRURGICOS;
            } else if (fieldName.equals("ANTECEDENTES_TOXICOS")) {
                value = ANTECEDENTES_TOXICOS;
            } else if (fieldName.equals("ANTECEDENTES_TRANSFUNCIONALES")) {
                value = ANTECEDENTES_TRANSFUNCIONALES;
            } else if (fieldName.equals("ANTECEDENTES_TRAUMATICOS")) {
                value = ANTECEDENTES_TRAUMATICOS;
            } else if (fieldName.equals("ANTECEDENTES_REVISION_POR_SISTEMAS")) {
                value = ANTECEDENTES_FARMACOLOGICOS;
            }

        }


        return value;
    }


    /**
     * Metodo que obtiene los datos para generar la Cirug�as y procedimientos 
     */
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


        }


    }

    public void cargarObjetos() {
        if (usuario != null && usuario.getHuslnumero() != null) {
            try {
                lstConsultas = 
                        serviceLocator.getClinicoService().getConsultaPorId(usuario.getHuslnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

    }

    public String consultarAntecedente() {
        this.index = -1;
        cargarObjetos();
        obtenerDatosReporte();
        int pageIndex;
        pageIndex = 0;
        int lastPageIndex;
        lastPageIndex = 0;

        if (lstConsultas != null && !lstConsultas.isEmpty()) {
            wexito = true;
            try {

                 URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/consultarAntecedentes.jasper");
                ExternalContext externalContext = 
                    FacesContext.getCurrentInstance().getExternalContext();
                HttpServletRequest request = 
                    (HttpServletRequest)externalContext.getRequest();

                if (url != null) {
                    Map parameters = new HashMap();

                    JRHtmlExporter exporter = new JRHtmlExporter();
                    JasperPrint jasperPrint = null;
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
        } else {
            wexito = false;
            FacesUtils.addErrorMessage(IConstantes.MSG_SIN_DATOS);
        }


        return BeanNavegacion.RUTA_MOSTRAR_ANTECEDENTES;
    }


    public Object volverConsulta() {
        FacesUtils.resetManagedBean("consultarUsuarioAntecedenteBean");
        FacesUtils.resetManagedBean("consultarAntecedentesBean");
        return BeanNavegacion.RUTA_VOLVER_CONSULTA_ANTECEDENTES;
    }


    public void setLstTipoAntecedentes(List<SelectItem> lstTipoAntecedentes) {
        this.lstTipoAntecedentes = lstTipoAntecedentes;
    }

    public List<SelectItem> getLstTipoAntecedentes() {
        if (lstTipoAntecedentes.size() == 0) {
            ArrayList<Chtipoantece> lstTipoAntecedentesAux;
            lstTipoAntecedentesAux = new ArrayList<Chtipoantece>();

            try {
                lstTipoAntecedentesAux = 
                        (ArrayList<Chtipoantece>)this.getServiceLocator().getClinicoService().getTipoAntecedente(tipoHistoria);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            Iterator it = lstTipoAntecedentesAux.iterator();
            int i = 0;
            while (it.hasNext()) {
                it.next();
                lstTipoAntecedentes.add(new SelectItem(lstTipoAntecedentesAux.get(i).getHtancodigo().toString(), 
                                                       lstTipoAntecedentesAux.get(i).getHtacdescripcio()));
                i++;
            }

        }

        return lstTipoAntecedentes;
    }

    /**
     * @param lstTipoAntecedenteSelect
     */
    public void setLstTipoAntecedenteSelect(List<String> lstTipoAntecedenteSelect) {
        this.lstTipoAntecedenteSelect = lstTipoAntecedenteSelect;
    }

    /**
     * @return
     */
    public List<String> getLstTipoAntecedenteSelect() {
        return lstTipoAntecedenteSelect;
    }

    /**
     * @param wexito
     */
    public void setWexito(boolean wexito) {
        this.wexito = wexito;
    }

    /**
     * @return
     */
    public boolean isWexito() {
        return wexito;
    }

    /**
     * @param tipoHistoria
     */
    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    /**
     * @return
     */
    public Integer getTipoHistoria() {
        return tipoHistoria;
    }
}
