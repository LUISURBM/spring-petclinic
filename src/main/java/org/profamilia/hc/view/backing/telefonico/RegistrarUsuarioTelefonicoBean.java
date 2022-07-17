//=======================================================================
// ARCHIVO Registrar Usuario Asesoria 
// FECHA CREACI�N: 15/01/2012
// AUTOR: Jos� Andres Riano Rinc�n
// Descripci�n: Registro de Usuario para asesoria.
//=======================================================================

package org.profamilia.hc.view.backing.telefonico;

import java.net.URL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chregitelf;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chtipoafilia;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chzona;
import org.profamilia.hc.model.dto.Cpdepadane;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpocupacio;
import org.profamilia.hc.model.dto.Cppais;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE RegistrarUsuarioTelefonicoBean
//=======================================================================
public class RegistrarUsuarioTelefonicoBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    /** Almacena la lista de los posibles estados civil  */
    private List<SelectItem> listEstadoCivil;

    /** Variable que almacena la lista de zonas */
    private List<SelectItem> listzona;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    /** Lista que almacena la lista de  Departamentos  */
    private List<SelectItem> listPaises;

    /** Lista que almacena la lista de  Departamentos  */
    private List<SelectItem> listDepartamentos;

    /** Lista que almacena la lista de  Ciudades */
    private List<SelectItem> listMunicipios;

    /** Lista que almacena la lista de ocupaciones  */
    private List<SelectItem> listOcupaciones;

    /** Lista que almacena el tipo de afiliacion  */
    private List<SelectItem> listTipoAfiliacion;

    /** Lista de sexos */
    private List<SelectItem> listSexos;

    /** Lista de Estratos */
    private List<SelectItem> listEstrato;

    /** Lista que almacena la lista de EPS */
    private List<SelectItem> listEntidadAdm;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    /** Almacena la edad del usuario*/
    private Integer edad;

    private String nextAction;

    private String navegationRule;

    private String menuBean;

    private boolean renderUsuario;

    private boolean renderRegistrar;

    private boolean renderVerReporte;

    private List<Chusuario> lstUsuarios;

    private Chregitelf registroTelefonico;
    
    private Chregitelf regiTelfAnterior;

    private Long numeroRegiTelfAnterior;

    private String registroRegiTelfAnterior;
    
    private List lstRegiTelfAnteriores;
    
    private List<Chregitelf> auxLstRegiTelfAnteriores;

    private boolean renderSelecionarUsuario;


    private int selectedIndex;

    static final int ACTIVAR_DATOS_USUARIO = 0;


    static final int ACTIVAR_SELECCIONAR_USUARIOS = 1;


    private HtmlDataTable dtConsultaUsuario;

    private UIInput calendarFechaNacimiento;
    
    private int index = -1;
    private boolean generoReporte;
    
    /** Fiels Requeridos en el Reporte */
    //private Date FECHA;
    private String NOMBRE;
    private Date FECHA_NACIMIENTO;
    private Integer EDAD;
    private String SEXO;
    private String DIRECCION;
    private String TELEFONO;
    
    private String CELULAR;
    private String CIUDAD;
    private String OCUPACION;
    private String RESPONSABLE;
    private String ESTADO_CIVIL;
    private String TELEFONO_RESPONSABLE;
    private String TIPO_DOCUMENTO;
    private Long NUMERO_DOCUMENTO;
    private String FECHA_REGISTRO;
    private String NOMBRE_PROFESIONAL;
    private String EPS;
    private String REGISTRO;
    private Long NUMERO_REGISTRO;
    
    
    
    private List lstOpciones;
    
    private boolean renderCovid;
    
    private List<String> lstPreguntasCovidSelect;
    
    private List lstPreguntasCovid;
    
    private boolean renderTos;
    
    private boolean renderFiebre;
    
    private boolean renderDolorGarganta;
    
    private boolean renderCongestionNasal;
    
    private boolean renderDificultadRespirar;
    
    private boolean renderFatiga;
    
    private boolean renderEscalosfrio;
    
    private UIInput numDiasTos;
    
    private UIInput numDiasFiebre;
    
    private UIInput numDiasDolorGarganta;
    
    private UIInput numDiasCongestionNasal;
    
    private UIInput numDiasDificultadRespirar;
    
    private UIInput numDiasFatiga;
    
    private UIInput numDiasEscalosfrio;
    
    private List<String> lstPreguntasCovidSelectAnt;
    
    private boolean renderCovidAnt;
    
    private boolean renderPreguntaCovidAnt;
    
    
    

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public RegistrarUsuarioTelefonicoBean() {

    }


    // ACTIONS

    public void init() {
        usuario = new Chusuario();

        this.listMunicipios = new ArrayList<SelectItem>();

        selectedIndex = ACTIVAR_DATOS_USUARIO;
        
        renderCovid= false;
        renderTos = false;
        renderFiebre = false;
        renderDolorGarganta = false;
        renderCongestionNasal = false;
        renderDificultadRespirar = false;
        renderFatiga = false;
        renderEscalosfrio = false;
        renderCovidAnt = false;
        renderPreguntaCovidAnt = false;
        
        lstPreguntasCovidSelect = new ArrayList<String>();
        lstPreguntasCovidSelectAnt = new ArrayList<String>();
        lstPreguntasCovid = new ArrayList();
    }


    //-----------------------------------------------------------------------
    //  AJAX
    //-----------------------------------------------------------------------


    public void changeCiudad() {
        if (usuario.getHusndepartamen() != null) {
            this.listMunicipios = new ArrayList<SelectItem>();
            usuario.setHusnciudad(null);
            ArrayList<Cpmunidane> listMunicipiosAux = null;
            try {

                listMunicipiosAux = 
                        (ArrayList<Cpmunidane>)this.serviceLocator.getClinicoService().getMunicipios(usuario.getHusndepartamen());

            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (listMunicipiosAux != null && !listMunicipiosAux.isEmpty()) {

                Iterator it = listMunicipiosAux.iterator();
                int i = 0;
                listMunicipios.add(new SelectItem("", 
                                                  "Seleccione una opcion ..."));
                while (it.hasNext()) {
                    it.next();
                    listMunicipios.add(new SelectItem(listMunicipiosAux.get(i).getCmdncodmun(), 
                                                      listMunicipiosAux.get(i).getCmdcnommun()));
                    i++;
                }
            }
        } else {
            listMunicipios = new ArrayList<SelectItem>();
            listMunicipios.add(new SelectItem("", 
                                              "Seleccione una opcion ..."));
        }
    }


    public void changeEdad() {
        if (usuario != null && usuario.getHusdfechanacim() != null) {
            setEdad(calcularEdad(usuario.getHusdfechanacim(), new Date()));
        }
    }

    /**
     * @param valueChangeEvent
     */
    public void setDepartamentoSelect(ValueChangeEvent valueChangeEvent) {
        usuario.setHusndepartamen((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setFechaNacimiento(ValueChangeEvent valueChangeEvent) {
        usuario.setHusdfechanacim((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHusdfechanacim(ValueChangeEvent valueChangeEvent) {
        usuario.setHusdfechanacim((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void buscadorUsuario() {
        renderUsuario = false;
        renderRegistrar = false;
        lstUsuarios = new ArrayList<Chusuario>();
        boolean wexito = true;
        String url = "body:formDatosUsuarios:panelTabDatosUsuario:";

        if (usuario.getHusetipoiden() == null || 
            usuario.getHusetipoiden().equals("")) {
            FacesUtils.addErrorMessage(url + "tipoIde", MSG_CAMPO_OBLIGATORIO);
            wexito = false;
        }


        if (usuario.getHusanumeiden() == null) {
            FacesUtils.addErrorMessage(url + "itNumeroIdentificacion", 
                                       MSG_CAMPO_OBLIGATORIO);
            wexito = false;
        }

        if (wexito) {
            if (usuario != null) {

                try {
                    lstUsuarios = 
                            this.serviceLocator.getClinicoService().getUsuarios(usuario.getHusetipoiden(), 
                                                                                usuario.getHusanumeiden());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (lstUsuarios != null && !lstUsuarios.isEmpty()) {

                    if (lstUsuarios.size() == 1) {
                        usuario = lstUsuarios.get(0);
                        renderUsuario = true;


                        if (usuario.getHusnciudad() != null) {
                            this.setCiudad();
                        }


                    } else if (lstUsuarios.size() > 1) {

                        renderSelecionarUsuario = true;
                        selectedIndex = ACTIVAR_SELECCIONAR_USUARIOS;
                    }

                } else {
                    usuario.setHuslnumero(null);
                    usuario.setHuscprimernomb("");
                    usuario.setHuscsegundnomb("");
                    usuario.setHuscprimerapel("");
                    usuario.setHuscsegundapel("");
                    renderRegistrar = true;
                }

            }
        }


    }


    public void resetDatos() {
        FacesUtils.resetManagedBean("registrarUsuarioTelefonicoBean");
        usuario = new Chusuario();
        edad = null;
        renderUsuario = false;
        renderRegistrar = false;
    }


    //-----------------------------------------------------------------------
    //  GET/SET
    //-----------------------------------------------------------------------


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
                listTipoIdentificacion.add(new SelectItem("",  "Seleccione una opci�n ..."));
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
     * @param param
     */
    public void setListDepartamentos(List<SelectItem> param) {
        this.listDepartamentos = param;
    }

    /**
     * @return
     */
    public List<SelectItem> getListDepartamentos() {
        if (listDepartamentos == null || listDepartamentos.isEmpty()) {
            listDepartamentos = new ArrayList<SelectItem>();
            ArrayList<Cpdepadane> listDepartamentosAux = null;
            try {
                listDepartamentosAux = 
                        (ArrayList<Cpdepadane>)this.serviceLocator.getClinicoService().getDepartamentos();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listDepartamentosAux.isEmpty()) {

                Iterator it = listDepartamentosAux.iterator();
                int i = 0;
                listDepartamentos.add(new SelectItem("",  "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listDepartamentos.add(new SelectItem(listDepartamentosAux.get(i).getCddncodigo(), 
                                                         listDepartamentosAux.get(i).getCddcdescri()));
                    i++;
                }
            }
        }
        return listDepartamentos;
    }


    /**
     * @param param
     */
    public void setListMunicipios(List<SelectItem> param) {
        this.listMunicipios = param;
    }

    /**
     * @return
     */
    public List<SelectItem> getListMunicipios() {

        return listMunicipios;
    }

    /**
     * @param param
     */
    public void setListOcupaciones(List<SelectItem> param) {
        this.listOcupaciones = param;
    }

    /**
     * @return
     */
    public List<SelectItem> getListOcupaciones() {
        if (listOcupaciones == null || listOcupaciones.isEmpty()) {
            listOcupaciones = new ArrayList<SelectItem>();
            ArrayList<Cpocupacio> listOcpuacionesAux = null;
            try {
                listOcpuacionesAux = 
                        (ArrayList<Cpocupacio>)this.serviceLocator.getClinicoService().getOcupaciones();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listOcpuacionesAux.isEmpty()) {
                listOcupaciones.add(new SelectItem("", 
                                                   "Seleccione una opcion..."));
                Iterator it = listOcpuacionesAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listOcupaciones.add(new SelectItem(listOcpuacionesAux.get(i).getCocncodigo(), 
                                                       listOcpuacionesAux.get(i).getCoccdescri()));

                    i++;
                }
            }
        }
        return listOcupaciones;
    }

    /**
     * @param param
     */
    public void setListTipoAfiliacion(List<SelectItem> param) {
        this.listTipoAfiliacion = param;
    }

    /**
     * @return
     */
    public List<SelectItem> getListTipoAfiliacion() {
        if (listTipoAfiliacion == null || listTipoAfiliacion.isEmpty()) {
            listTipoAfiliacion = new ArrayList<SelectItem>();
            ArrayList<Chtipoafilia> listTipoAfiliacionAux = null;
            try {
                listTipoAfiliacionAux = 
                        (ArrayList<Chtipoafilia>)this.getServiceLocator().getClinicoService().getTipoafiliado();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listTipoAfiliacionAux.isEmpty()) {

                listTipoAfiliacion.add(new SelectItem("", 
                                                      "Seleccione una opcion ..."));
                Iterator it = listTipoAfiliacionAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listTipoAfiliacion.add(new SelectItem((listTipoAfiliacionAux.get(i).getCtaecodigo().toString()), 
                                                          listTipoAfiliacionAux.get(i).getCtacdescripcio()));
                    i++;
                }
            }
        }
        return listTipoAfiliacion;
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
     * @param listzona
     */
    public void setListzona(List<SelectItem> listzona) {
        this.listzona = listzona;
    }

    /**
     * @return
     */
    public List<SelectItem> getListzona() {
        if (listzona == null || listzona.isEmpty()) {
            listzona = new ArrayList<SelectItem>();
            ArrayList<Chzona> zonaList;
            zonaList = null;


            try {
                zonaList = 
                        (ArrayList<Chzona>)serviceLocator.getClinicoService().getZona();
            } catch (ModelException e) {
                e.printStackTrace();
            }
            Iterator it = zonaList.iterator();
            int i = 0;
            while (it.hasNext()) {
                it.next();
                listzona.add(new SelectItem(zonaList.get(i).getId(), 
                                            zonaList.get(i).getDescripcion()));
                i++;
            }

        }
        return listzona;
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
                        (ArrayList<Chestadociv>)this.getServiceLocator().getClinicoService().getEstadoCivilFemenino();
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
     * @param listEntidadAdm
     */
    public void setListEntidadAdm(List<SelectItem> listEntidadAdm) {
        this.listEntidadAdm = listEntidadAdm;
    }

    /**
     * @return
     */
    public List<SelectItem> getListEntidadAdm() {
        if (listEntidadAdm == null || listEntidadAdm.isEmpty()) {
            listEntidadAdm = new ArrayList<SelectItem>();
            ArrayList<Cpentidadadm> listEntidadAdmAux = null;
            try {
                listEntidadAdmAux = 
                        (ArrayList<Cpentidadadm>)this.serviceLocator.getClinicoService().getEntidadAdm();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listEntidadAdmAux.isEmpty()) {

                Iterator it = listEntidadAdmAux.iterator();
                int i = 0;
                listEntidadAdm.add(new SelectItem("", 
                                                  "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listEntidadAdm.add(new SelectItem(listEntidadAdmAux.get(i).getCeaccodigo(), 
                                                      listEntidadAdmAux.get(i).getCeacnombre()));
                    i++;
                }
            }
        }
        return listEntidadAdm;
    }

    /**
     * @param 
     */
    public void setCiudad() {
        if (usuario.getHusndepartamen() != null) {
            this.listMunicipios = new ArrayList<SelectItem>();
            ArrayList<Cpmunidane> listMunicipiosAux = null;
            try {
                listMunicipiosAux = 
                        (ArrayList<Cpmunidane>)this.serviceLocator.getClinicoService().getMunicipios(usuario.getHusndepartamen());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (listMunicipiosAux != null && !listMunicipiosAux.isEmpty()) {

                Iterator it = listMunicipiosAux.iterator();
                int i = 0;
                listMunicipios.add(new SelectItem("", 
                                                  "Seleccione una opcion ..."));
                while (it.hasNext()) {
                    it.next();
                    listMunicipios.add(new SelectItem(listMunicipiosAux.get(i).getCmdncodmun(), 
                                                      listMunicipiosAux.get(i).getCmdcnommun()));
                    i++;
                }
            }


        }

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
     * @param renderUsuario
     */
    public void setRenderUsuario(boolean renderUsuario) {
        this.renderUsuario = renderUsuario;
    }

    /**
     * @return
     */
    public boolean isRenderUsuario() {
        return renderUsuario;
    }


    public boolean isRenderVerReporte() {
        return renderVerReporte;
    }

    /**
     * @param lstUsuarios
     */
    public void setLstUsuarios(List<Chusuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    /**
     * @return
     */
    public List<Chusuario> getLstUsuarios() {
        return lstUsuarios;
    }

    /**
     * @param renderRegistrar
     */
    public void setRenderRegistrar(boolean renderRegistrar) {
        this.renderRegistrar = renderRegistrar;
    }

    /**
     * @return
     */
    public boolean isRenderRegistrar() {
        return renderRegistrar;
    }

    /**
     * @param navegationRule
     */
    public void setNavegationRule(String navegationRule) {
        this.navegationRule = navegationRule;
    }

    /**
     * @return
     */
    public String getNavegationRule() {
        return navegationRule;
    }

    public void setRenderSelecionarUsuario(boolean renderSelecionarUsuario) {
        this.renderSelecionarUsuario = renderSelecionarUsuario;
    }

    public boolean isRenderSelecionarUsuario() {
        return renderSelecionarUsuario;
    }

    public void setCalendarFechaNacimiento(UIInput calendarFechaNacimiento) {
        this.calendarFechaNacimiento = calendarFechaNacimiento;
    }

    public UIInput getCalendarFechaNacimiento() {
        return calendarFechaNacimiento;
    }


    /**
     * @param listEstrato
     */
    public void setListEstrato(List<SelectItem> listEstrato) {
        this.listEstrato = listEstrato;
    }

    /**
     * @return
     */
    public List<SelectItem> getListEstrato() {
        if (listEstrato == null || listEstrato.isEmpty()) {
            listEstrato = new ArrayList<SelectItem>();
            listEstrato.add(new SelectItem("", "--"));
            listEstrato.add(new SelectItem(1, "1"));
            listEstrato.add(new SelectItem(2, "2"));
            listEstrato.add(new SelectItem(3, "3"));
            listEstrato.add(new SelectItem(4, "4"));
            listEstrato.add(new SelectItem(5, "5"));
            listEstrato.add(new SelectItem(6, "6"));
        }
        return listEstrato;
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
     * @param dtConsultaUsuario
     */
    public void setDtConsultaUsuario(HtmlDataTable dtConsultaUsuario) {
        this.dtConsultaUsuario = dtConsultaUsuario;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtConsultaUsuario() {
        return dtConsultaUsuario;
    }


    //-----------------------------------------------------------------------
    //  Bot�n Principal
    //-----------------------------------------------------------------------


    public void agregarUsuario() {
        usuario = (Chusuario)dtConsultaUsuario.getRowData();


        if (usuario.getHusnciudad() != null) {
            this.setCiudad();
        }

    }


    public String seleccionarUsuario() {
        renderSelecionarUsuario = false;
        renderUsuario = true;
        selectedIndex = ACTIVAR_DATOS_USUARIO;
        return BeanNavegacion.RUTA_ACTUAL;

    }

    /**
     * @return
     */
    public String guardarUsuario() {
        navegationRule = "";
        boolean wexito = true;
        String url = "body:formDatosUsuarios:panelTabDatosUsuario:";

        if (usuario != null) {


            if (usuario.getHusetipoiden() == null || 
                usuario.getHusetipoiden().equals("")) {
                FacesUtils.addErrorMessage(url + "tipoIde", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHusanumeiden() == null) {
                FacesUtils.addErrorMessage(url + "itNumeroIdentificacion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

            if (usuario.getHuscprimernomb() == null || 
                usuario.getHuscprimernomb().equals("")) {
                FacesUtils.addErrorMessage(url + "primerNombre", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHuscprimerapel() == null || 
                usuario.getHuscprimerapel().equals("")) {
                FacesUtils.addErrorMessage(url + "primerApellido", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHusdfechanacim() == null) {
                FacesUtils.addErrorMessage(url + "fechaNacimiento", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

            if (usuario.getHusesexo() == null || 
                usuario.getHusesexo().equals("")) {
                FacesUtils.addErrorMessage(url + "radioSexo", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

            if (usuario.getHusnniveledu() == null) {
                FacesUtils.addErrorMessage(url + "itNivelEducativo", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

            if (usuario.getHusnestrato() == null) {
                FacesUtils.addErrorMessage(url + "mnuEstrato", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHuseestadcivil() == null || 
                usuario.getHuseestadcivil().equals("")) {
                FacesUtils.addErrorMessage(url + "radioEstadoCivil", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHuscdireccion() == null || 
                usuario.getHuscdireccion().equals("")) {
                FacesUtils.addErrorMessage(url + "Direccion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHuscbarrio() == null || 
                usuario.getHuscbarrio().equals("")) {
                FacesUtils.addErrorMessage(url + "itBarrio", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

            if (usuario.getHusctelefono() == null || 
                usuario.getHusctelefono().equals("")) {
                FacesUtils.addErrorMessage(url + "Telefono", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

            if (usuario.getHusezonareside() == null || 
                usuario.getHusezonareside().equals("")) {
                FacesUtils.addErrorMessage(url + "radioZona", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHusnciudad() == null) {
                FacesUtils.addErrorMessage(url + "menuCiudad", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHusetipoafilia() == null || 
                usuario.getHusetipoafilia().equals("")) {
                FacesUtils.addErrorMessage(url + "menuAfiliacion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

            if (usuario.getHuscentidadadm() == null || 
                usuario.getHuscentidadadm().equals("")) {
                FacesUtils.addErrorMessage(url + "menuEps", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHusnocupacion() == null) {
                FacesUtils.addErrorMessage(url + "menuOcupacion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

        }

        if (wexito) {
            if (usuario != null) {
                // Verificamos si el usuario tiene Registro Telefonico anteriores
                try {
                    auxLstRegiTelfAnteriores = 
                            this.serviceLocator.getClinicoService().getRegistroTelefonicoUsuario(usuario);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                renderVerReporte = false;
                if (auxLstRegiTelfAnteriores != null) {
                    renderVerReporte = auxLstRegiTelfAnteriores.size() > 0;
                }
                navegationRule = BeanNavegacion.RUTA_IR_REGISTRAR_TELEFONICO;
                // Guardamos el usuario 
                try {
                    this.serviceLocator.getClinicoService().saveUsuarioRegistroTelefonico(usuario, 
                                                                                userName());

                    if (registroTelefonico == null) {
                        registroTelefonico = new Chregitelf();
                        registroTelefonico.setHrtlnumusu(usuario.getHuslnumero());
                        registroTelefonico.setHrtcusureg(userName());
                        registroTelefonico.setHrtdfecreg(new Date());
                    }
                    FacesUtils.addInfoMessage(MSG_ADICION);
                } catch (ModelException e) {
                    FacesUtils.addErrorMessage(MSG_NO_ADICION + 
                                               e.getMessage());
                    navegationRule = BeanNavegacion.RUTA_ACTUAL;
                    e.printStackTrace();
                }
            }
        }

        return navegationRule;
    }


    public void setRegistroTelefonico(Chregitelf registroTelefonico) {
        this.registroTelefonico = registroTelefonico;
    }

    public Chregitelf getRegistroTelefonico() {
        return registroTelefonico;
    }
    
    

        /**
         * @return
         */
        public String guardarTelefonico() {
            boolean wexito = true;
            String nextAction = "";

            String url = "body:formAsesoriaAvise:panelTabDatosUsuario:";
    
            if (registroTelefonico == null) {
                wexito = false;
            }
            
            if (registroTelefonico!= null && 
                    (registroTelefonico.getHrtcregistro() == null || registroTelefonico.getHrtcregistro().length() == 0)) {
                wexito = false;
                FacesUtils.addErrorMessage("No se ha agregado informaci�n en el Registro");
            }
            
            if (wexito) {
                try {
                    registroTelefonico.setHrtcusumod(userName());
                    registroTelefonico.setHrtdfecmod(new Date());
                    this.serviceLocator.getClinicoService().saveRegistroTelefonico(registroTelefonico);
                    resetDatos();
                    nextAction = BeanNavegacion.RUTA_IR_REGISTRO_USUARIO_TELEFONICO;
                    FacesUtils.addInfoMessage(MSG_ADICION);
                } catch (ModelException e) {
                    FacesUtils.addErrorMessage(MSG_NO_ADICION);
                    e.printStackTrace();
                }
            }
            return nextAction;
        }

    public void setLstRegiTelfAnteriores(List lstRegiTelfAnteriores) {
        this.lstRegiTelfAnteriores = lstRegiTelfAnteriores;
    }

    public List getLstRegiTelfAnteriores() {
        lstRegiTelfAnteriores = new ArrayList();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if (auxLstRegiTelfAnteriores != null && !auxLstRegiTelfAnteriores.isEmpty()) {
            Iterator it = auxLstRegiTelfAnteriores.iterator();
            int i = 0;
            lstRegiTelfAnteriores.add(new SelectItem("","Seleccione una opci�n ..."));
            while (it.hasNext()) {
                it.next();
                lstRegiTelfAnteriores.add(
                    new SelectItem(auxLstRegiTelfAnteriores.get(i).getHrtlnumero(),
                        dateFormat.format(auxLstRegiTelfAnteriores.get(i).getHrtdfecreg())
                ));
                i++;
            }
        }
        return lstRegiTelfAnteriores;
    }
    
    public void setNumeroRegiTelfAnterior(Long numeroRegiTelfAnterior) {
        registroRegiTelfAnterior = "";
        renderPreguntaCovidAnt = false;
        renderCovidAnt = false;
        this.numeroRegiTelfAnterior = numeroRegiTelfAnterior;
        regiTelfAnterior = new Chregitelf();
        if (auxLstRegiTelfAnteriores != null && !auxLstRegiTelfAnteriores.isEmpty()) {
            for(Chregitelf chregitelf : auxLstRegiTelfAnteriores) {
                if(chregitelf.getHrtlnumero().equals(numeroRegiTelfAnterior)) {
                    regiTelfAnterior = chregitelf;
                    registroRegiTelfAnterior = regiTelfAnterior.getHrtcregistro();
                    renderPreguntaCovidAnt = true;
                    if("S".equals(regiTelfAnterior.getHrtcproqui())){ 
                    lstPreguntasCovidSelectAnt = new ArrayList<String>();
                            if ("S".equals(regiTelfAnterior.getHrtctos())){
                                lstPreguntasCovidSelectAnt.add("TO");
                            }        
                            if ("S".equals(regiTelfAnterior.getHrtcfiebre())){
                                lstPreguntasCovidSelectAnt.add("FI");
                            }
                            if ("S".equals(regiTelfAnterior.getHrtcdolgar())){
                                lstPreguntasCovidSelectAnt.add("DG");
                            }
                            if ("S".equals(regiTelfAnterior.getHrtcconnal())){
                                lstPreguntasCovidSelectAnt.add("CN");
                            }
                            if ("S".equals(regiTelfAnterior.getHrtcdifres())){
                                lstPreguntasCovidSelectAnt.add("DR");
                            }
                            if ("S".equals(regiTelfAnterior.getHrtcfatiga())){
                                lstPreguntasCovidSelectAnt.add("FA");
                            }
                            if ("S".equals(regiTelfAnterior.getHrtcescalofrio())){
                                lstPreguntasCovidSelectAnt.add("ES");
                            }
                            
                            if ("S".equals(regiTelfAnterior.getHrtcninguna())){
                                lstPreguntasCovidSelectAnt.add("NA");
                            }
                            renderCovidAnt = true;
                    }
                    break;
                }
            }
        }
    }

    /**
     * @param valueChangeEvent
     */
    public void setRegistroChange(ValueChangeEvent valueChangeEvent) {
        setNumeroRegiTelfAnterior((Long)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public Long getNumeroRegiTelfAnterior() {
        return numeroRegiTelfAnterior;
    }

    public Chregitelf getRegiTelfAnterior() {
        return regiTelfAnterior;
    }

    public String getRegistroRegiTelfAnterior() {
        return registroRegiTelfAnterior;
    }
    

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
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
            
            if (usuario.getHuscprimernomb() != null) {
                NOMBRE = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null
                    && !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                NOMBRE = NOMBRE + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null
                    && !usuario.getHuscsegundapel().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundapel();
            }
            if (usuario.getHusanumeiden() != null
                    && usuario.getHusanumeiden() != 0) {
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

            SEXO = usuario.getHusesexo();
            DIRECCION = usuario.getHuscdireccion();
            TELEFONO = usuario.getHusctelefono();
            CELULAR =  usuario.getHusccelular();
            Integer idCiudad = usuario.getHusnciudad();
            Integer idDepartamento = usuario.getHusndepartamen();
            Cpmunidane ciudadObject = null;

            try {
                ciudadObject = this.serviceLocator.getClinicoService().getMunicipio(idCiudad, idDepartamento);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (ciudadObject != null) {
                CIUDAD = ciudadObject.getCmdcnommun();
            }

            Integer ocupacion = usuario.getHusnocupacion();

            try {
                OCUPACION = serviceLocator.getClinicoService().getDescripcionOcupacion(ocupacion);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            ESTADO_CIVIL = usuario.getHuseestadcivil();
            RESPONSABLE = usuario.getHuscnomacompana();
            TELEFONO_RESPONSABLE = usuario.getHusctelacompana();
            

        }
    }

    public void generarReporte() {
        this.index = -1;
        try {
            obtenerDatosReporte();
            URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteRegistro.jasper");
            URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_PRINCIPAL);
            URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
            URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                
                JasperReport report = (JasperReport) JRLoader.loadObject(url);

                byte[] bytes = JasperRunManager.runReportToPdf(report, parameters, (JRDataSource) this);
                PdfServletUtils.showPdfDocument(bytes, "Resumen_ReporteRegistroTelefonico" + ".pdf", false);
                this.generoReporte = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No se pudo generar el reporte " + e.getMessage());
        }

    }

    public boolean next() {
        index++;
        return index < auxLstRegiTelfAnteriores.size();
    }
    
    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("TITULO_REPORTE")) {
            value = "REPORTE REGISTRO TELEF�NICO";
        } else if (fieldName.equals("FECHA")) {
            value = Calendar.getInstance().getTime();//new Date();
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
        } else if (fieldName.equals("CELULAR")) {
            value = CELULAR;
        }else if (fieldName.equals("CIUDAD")) {
            value = CIUDAD;
        } else if (fieldName.equals("OCUPACION")) {
            value = OCUPACION;
        } else if (fieldName.equals("RESPONSABLE")) {
            value = RESPONSABLE;
        } else if (fieldName.equals("ESTADO_CIVIL")) {
            value = ESTADO_CIVIL;
        } else if (fieldName.equals("TELEFONO_RESPONSABLE")) {
            value = TELEFONO_RESPONSABLE;
        } else if (fieldName.equals("TIPO_DOCUMENTO")) {
            value = TIPO_DOCUMENTO;
        } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = NUMERO_DOCUMENTO;
        } else if (fieldName.equals("FECHA_REGISTRO")) {
            value = auxLstRegiTelfAnteriores.get(index).getHrtdfecreg();
        } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
            value = NOMBRE_PROFESIONAL;
        } else if (fieldName.equals("EPS")) {
            value = EPS;
        } else if (fieldName.equals("REGISTRO")) {
            value = auxLstRegiTelfAnteriores.get(index).getHrtcregistro();
        } else if (fieldName.equals("NUMERO_REGISTRO")) {
            value = auxLstRegiTelfAnteriores.get(index).getHrtlnumero();
        } else if (fieldName.equals("NOMBRE_FUNCIONARIO")) {
            Cpusuario funcionario = null;
            try {
               funcionario  = this.serviceLocator.getClinicoService().getUsuarioPorId(
                    auxLstRegiTelfAnteriores.get(index).getHrtcusureg().toUpperCase());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (funcionario != null) {
                value = funcionario.getCurcnombre();
            }
        } else if (fieldName.equals("DESCRIPCION_TIPO_ESPECIALIDAD")) {
            Cpprofesio profesional = null;
            Integer wclinic = null;
            String wdesclinic = "";
            if(auxLstRegiTelfAnteriores.get(index).getHrtcusureg()!= null){
                try {
                    wclinic = serviceLocator.getClinicoService().getClinicaActiva(auxLstRegiTelfAnteriores.get(index).getHrtcusureg().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                //wdesclinic = auxLstRegiTelfAnteriores.get(index).getHrtcusureg().substring(2,4);
                
                /*
                if(wdesclinic != null && !wdesclinic.equals("")){
                    wclinic = Integer.parseInt(wdesclinic);
                }
                */
            }
            
            
            try {
                if (wclinic != null) {
                    profesional = serviceLocator.getClinicoService().getProfesionalPorUsuario(
                            auxLstRegiTelfAnteriores.get(index).getHrtcusureg(),wclinic);
                }

            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (profesional != null) {
                try {
                    value = serviceLocator.getClinicoService().getDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
        } else if (fieldName.equals("REGISTRO_MEDICO")) {
        
        
            Cpprofesio profesional = null;
            
            Integer wclinic = null;
            String wdesclinic = "";
            if(auxLstRegiTelfAnteriores.get(index).getHrtcusureg()!= null){
                try {
                    wclinic = serviceLocator.getClinicoService().getClinicaActiva(auxLstRegiTelfAnteriores.get(index).getHrtcusureg().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
            try {
                if (wclinic != null) {
                    profesional = serviceLocator.getClinicoService().getProfesionalPorUsuario(
                            auxLstRegiTelfAnteriores.get(index).getHrtcusureg().toUpperCase(),wclinic);
                }

            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (profesional != null) {
                value = profesional.getCpfcregmedic();
            }
        }
        
        if("S".equals(auxLstRegiTelfAnteriores.get(index).getHrtcproqui())){
            if (fieldName.equals("PROCEDIMIENTO_QUIRURGICO")) {
                value = "SI";
            }
        }else {
            if (fieldName.equals("PROCEDIMIENTO_QUIRURGICO")) {
                value = "NO";
            }
        }
            
            if (fieldName.equals("TOS")) {
                if("S".equals(auxLstRegiTelfAnteriores.get(index).getHrtctos())){
                    value = "SI";
                }else {
                    value = "NO";
                }
            }else if (fieldName.equals("FIEBRE")) {
                if("S".equals(auxLstRegiTelfAnteriores.get(index).getHrtcfiebre())){
                    value = "SI";
                }else {
                    value = "NO";
                }
            }else if (fieldName.equals("DOLOR_GARGANTA")) {
                if("S".equals(auxLstRegiTelfAnteriores.get(index).getHrtcdolgar())){
                    value = "SI";
                }else {
                    value = "NO";
                }
            }else if (fieldName.equals("CONGESTION_NASAL")) {
                if("S".equals(auxLstRegiTelfAnteriores.get(index).getHrtcconnal())){
                    value = "SI";
                }else {
                    value = "NO";
                }
            }else if (fieldName.equals("DIFICULTAD_PARA_RESPIRAR")) {
                if("S".equals(auxLstRegiTelfAnteriores.get(index).getHrtcdifres())){
                    value = "SI";
                }else {
                    value = "NO";
                }
            }else if (fieldName.equals("FATIGA")) {
                if("S".equals(auxLstRegiTelfAnteriores.get(index).getHrtcfatiga())){
                    value = "SI";
                }else {
                    value = "NO";
                }
            }else if (fieldName.equals("ESCALOFRIO")) {
                if("S".equals(auxLstRegiTelfAnteriores.get(index).getHrtcescalofrio())){
                    value = "SI";
                }else {
                    value = "NO";
                }
            }else if (fieldName.equals("NINGUN_DE_LOS_ANTERIORES")) {
                if("S".equals(auxLstRegiTelfAnteriores.get(index).getHrtcninguna())){
                    value = "SI";
                }else {
                    value = "NO";
                }
            }else if (fieldName.equals("NUM_DIAS_TOS")) {
                if(auxLstRegiTelfAnteriores.get(index).getHrtnnumdiatos() != null){
                    value = auxLstRegiTelfAnteriores.get(index).getHrtnnumdiatos().toString();
                }else {
                    value = "0";
                }
            }else if (fieldName.equals("NUM_DIAS_FIEBRE")) {
                if(auxLstRegiTelfAnteriores.get(index).getHrtnnumdiafie()!= null){
                    value = auxLstRegiTelfAnteriores.get(index).getHrtnnumdiafie().toString();
                }else {
                    value = "0";
                }
            }else if (fieldName.equals("NUM_DIAS_DOLOR_GARGANTA")) {
                if(auxLstRegiTelfAnteriores.get(index).getHrtnnudidoga()!= null){
                    value = auxLstRegiTelfAnteriores.get(index).getHrtnnudidoga().toString();
                }else {
                    value = "0";
                }
            }else if (fieldName.equals("NUM_DIAS_CONGESTION_NASAL")) {
                if(auxLstRegiTelfAnteriores.get(index).getHrtnnudicona()!= null){
                    value = auxLstRegiTelfAnteriores.get(index).getHrtnnudicona().toString();
                }else {
                    value = "0";
                }
            }else if (fieldName.equals("NUM_DIAS_DIFICULTAD_PARA_RESPIRAR")) {
                if(auxLstRegiTelfAnteriores.get(index).getHrtnnudidire()!= null){
                    value = auxLstRegiTelfAnteriores.get(index).getHrtnnudidire().toString();
                }else {
                    value = "0";
                }
            }else if (fieldName.equals("NUM_DIAS_FATIGA")) {
                if(auxLstRegiTelfAnteriores.get(index).getHrtnnumdiafat() != null){
                    value = auxLstRegiTelfAnteriores.get(index).getHrtnnumdiafat().toString();
                }else {
                    value = "0";
                }
            }else if (fieldName.equals("NUM_DIAS_ESCALOFRIO")) {
                if(auxLstRegiTelfAnteriores.get(index).getHrtnnumdiaesc() != null){
                    value = auxLstRegiTelfAnteriores.get(index).getHrtnnumdiaesc().toString();
                }else {
                    value = "0";
                }
            }

        return value;
    }

    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    public List getLstOpciones() {
        if (lstOpciones == null || lstOpciones.isEmpty()) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));

        }
        return lstOpciones;
    }
    
    public void changePreguntasCovid(){
        if("S".equals(registroTelefonico.getHrtcproqui())){
            renderCovid =true;
        }else{
            lstPreguntasCovidSelect = new ArrayList<String>();
            registroTelefonico.setHrtctos(null);
            registroTelefonico.setHrtnnumdiatos(null);
            registroTelefonico.setHrtcfiebre(null);
            registroTelefonico.setHrtnnumdiafie(null);
            registroTelefonico.setHrtcdolgar(null);
            registroTelefonico.setHrtnnudidoga(null);
            registroTelefonico.setHrtcconnal(null);
            registroTelefonico.setHrtnnudicona(null);
            registroTelefonico.setHrtcdifres(null);
            registroTelefonico.setHrtnnudidire(null);
            registroTelefonico.setHrtcfatiga(null);
            registroTelefonico.setHrtnnumdiafat(null);
            registroTelefonico.setHrtcescalofrio(null);
            registroTelefonico.setHrtnnumdiaesc(null);
            registroTelefonico.setHrtcninguna(null);
            renderCovid= false;
            renderTos = false;
            renderFiebre = false;
            renderDolorGarganta = false;
            renderCongestionNasal = false;
            renderDificultadRespirar = false;
            renderFatiga = false;
            renderEscalosfrio = false;
            renderCovid = false;
        }
    }

    public void setRenderCovid(boolean renderCovid) {
        this.renderCovid = renderCovid;
    }

    public boolean isRenderCovid() {
        return renderCovid;
    }

    public void setLstPreguntasCovidSelect(List<String> lstPreguntasCovidSelect) {
        this.lstPreguntasCovidSelect = lstPreguntasCovidSelect;
    }

    public List<String> getLstPreguntasCovidSelect() {
        return lstPreguntasCovidSelect;
    }
    
    public void setPreguntasCovidSelect(ValueChangeEvent valueChangeEvent) {
        setLstPreguntasCovidSelect((List<String>)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setLstPreguntasCovid(List lstPreguntasCovid) {
        this.lstPreguntasCovid = lstPreguntasCovid;
    }

    public List getLstPreguntasCovid() {
    
        if (lstPreguntasCovid == null || lstPreguntasCovid.isEmpty()) {
            lstPreguntasCovid = new ArrayList();
            lstPreguntasCovid.add(new SelectItem("TO", "Tos"));
            lstPreguntasCovid.add(new SelectItem("FI", "Fiebre"));
            lstPreguntasCovid.add(new SelectItem("DG", "Dolor Garganta"));
            lstPreguntasCovid.add(new SelectItem("CN", "Congesti�n Nasal"));
            lstPreguntasCovid.add(new SelectItem("DR", "Dificultad para respirar"));
            lstPreguntasCovid.add(new SelectItem("FA", "F�tiga"));
            lstPreguntasCovid.add(new SelectItem("ES", "Escalofrio"));
            lstPreguntasCovid.add(new SelectItem("NA", "Ningun de los anteriores"));

        }
        return lstPreguntasCovid;
    }
    
    public void changeListaPreguntasCovid() {
    
        renderTos = false;
        renderFiebre = false;
        renderDolorGarganta = false;
        renderCongestionNasal = false;
        renderDificultadRespirar = false;
        renderFatiga = false;
        renderEscalosfrio = false;
        
        registroTelefonico.setHrtctos(null);
        registroTelefonico.setHrtcfiebre(null);
        registroTelefonico.setHrtcdolgar(null);
        registroTelefonico.setHrtcconnal(null);
        registroTelefonico.setHrtcdifres(null);
        registroTelefonico.setHrtcfatiga(null);
        registroTelefonico.setHrtcescalofrio(null);
        registroTelefonico.setHrtcninguna(null);
        
        if (lstPreguntasCovidSelect != null && 
            !lstPreguntasCovidSelect.isEmpty()) {
            for (Iterator iterator = lstPreguntasCovidSelect.iterator(); 
                 iterator.hasNext(); ) {
                String codigo = (String)iterator.next();
                if (codigo.equals("TO")){
                    registroTelefonico.setHrtctos("S");
                    renderTos = true;
                }else if (codigo.equals("FI")){
                    registroTelefonico.setHrtcfiebre("S");
                    renderFiebre = true;
                }else if (codigo.equals("DG")){
                    registroTelefonico.setHrtcdolgar("S");
                    renderDolorGarganta = true;
                }else if (codigo.equals("CN")){
                    registroTelefonico.setHrtcconnal("S");
                    renderCongestionNasal = true;
                }else if (codigo.equals("DR")){
                    registroTelefonico.setHrtcdifres("S");
                    renderDificultadRespirar = true;
                }else if (codigo.equals("FA")){
                    registroTelefonico.setHrtcfatiga("S");
                    renderFatiga = true;
                }else if (codigo.equals("ES")){
                    registroTelefonico.setHrtcescalofrio("S");
                    renderEscalosfrio = true;
                }else if (codigo.equals("NA")){
                    registroTelefonico.setHrtcninguna("S");
                    renderTos = false;
                    renderFiebre = false;
                    renderDolorGarganta = false;
                    renderCongestionNasal = false;
                    renderDificultadRespirar = false;
                    renderFatiga = false;
                    renderEscalosfrio = false;
                    
                    registroTelefonico.setHrtctos(null);
                    registroTelefonico.setHrtcfiebre(null);
                    registroTelefonico.setHrtcdolgar(null);
                    registroTelefonico.setHrtcconnal(null);
                    registroTelefonico.setHrtcdifres(null);
                    registroTelefonico.setHrtcfatiga(null);
                    registroTelefonico.setHrtcescalofrio(null);
                    
                    registroTelefonico.setHrtnnumdiatos(null);
                    registroTelefonico.setHrtnnumdiafie(null);
                    registroTelefonico.setHrtnnudidoga(null);
                    registroTelefonico.setHrtnnudicona(null);
                    registroTelefonico.setHrtnnudidire(null);
                    registroTelefonico.setHrtnnumdiafat(null);
                    registroTelefonico.setHrtnnumdiaesc(null);
                    
                }
            }

        }
    }

    public void changeNumDiasSintomas() {
        
        if (registroTelefonico.getHrtnnumdiatos() != null) {
            numDiasTos.setValue(registroTelefonico.getHrtnnumdiatos());
        }else{
            numDiasTos.setValue(null);    
        } 
        
        if (registroTelefonico.getHrtnnumdiafie() != null) {
            numDiasFiebre.setValue(registroTelefonico.getHrtnnumdiafie());
        } else{
            numDiasFiebre.setValue(null);
        } 
        
        if (registroTelefonico.getHrtnnudidoga() != null) {
            numDiasDolorGarganta.setValue(registroTelefonico.getHrtnnudidoga());
        } else {
            numDiasDolorGarganta.setValue(null);
        }
        
        if (registroTelefonico.getHrtnnudicona() != null) {
            numDiasCongestionNasal.setValue(registroTelefonico.getHrtnnudicona());
        } else {
            numDiasCongestionNasal.setValue(null);
        } 
        
        if (registroTelefonico.getHrtnnudidire()!= null) {
            numDiasDificultadRespirar.setValue(registroTelefonico.getHrtnnudidire());
        } else {
            numDiasDificultadRespirar.setValue(null);
        } 
        
        if (registroTelefonico.getHrtnnumdiafat() != null) {
            numDiasFatiga.setValue(registroTelefonico.getHrtnnumdiafat());
        } else{
            numDiasFatiga.setValue(null);
        } 
        
        if (registroTelefonico.getHrtnnumdiaesc() != null) {
            numDiasEscalosfrio.setValue(registroTelefonico.getHrtnnumdiaesc());
        }else{
            numDiasEscalosfrio.setValue(null);
        }

    }
    
    /**
     * @param valueChangeEvent
     */
    public void setDiasTosSelect(ValueChangeEvent valueChangeEvent) {
        registroTelefonico.setHrtnnumdiatos((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setDiasFiebreSelect(ValueChangeEvent valueChangeEvent) {
        registroTelefonico.setHrtnnumdiafie((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    /**
     * @param valueChangeEvent
     */
    public void setDiasDolorGargantaSelect(ValueChangeEvent valueChangeEvent) {
        registroTelefonico.setHrtnnudidoga((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    /**
     * @param valueChangeEvent
     */
    public void setDiasCongestionNasalSelect(ValueChangeEvent valueChangeEvent) {
        registroTelefonico.setHrtnnudicona((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    /**
     * @param valueChangeEvent
     */
    public void setDiasDificultadRespirarSelect(ValueChangeEvent valueChangeEvent) {
        registroTelefonico.setHrtnnudidire((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    /**
     * @param valueChangeEvent
     */
    public void setDiasFatigaSelect(ValueChangeEvent valueChangeEvent) {
        registroTelefonico.setHrtnnumdiafat((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    /**
     * @param valueChangeEvent
     */
    public void setDiasEscalosfrioSelect(ValueChangeEvent valueChangeEvent) {
        registroTelefonico.setHrtnnumdiaesc((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderTos(boolean renderTos) {
        this.renderTos = renderTos;
    }

    public boolean isRenderTos() {
        return renderTos;
    }

    public void setRenderFiebre(boolean renderFiebre) {
        this.renderFiebre = renderFiebre;
    }

    public boolean isRenderFiebre() {
        return renderFiebre;
    }

    public void setRenderDolorGarganta(boolean renderDolorGarganta) {
        this.renderDolorGarganta = renderDolorGarganta;
    }

    public boolean isRenderDolorGarganta() {
        return renderDolorGarganta;
    }

    public void setRenderCongestionNasal(boolean renderCongestionNasal) {
        this.renderCongestionNasal = renderCongestionNasal;
    }

    public boolean isRenderCongestionNasal() {
        return renderCongestionNasal;
    }

    public void setRenderDificultadRespirar(boolean renderDificultadRespirar) {
        this.renderDificultadRespirar = renderDificultadRespirar;
    }

    public boolean isRenderDificultadRespirar() {
        return renderDificultadRespirar;
    }

    public void setRenderFatiga(boolean renderFatiga) {
        this.renderFatiga = renderFatiga;
    }

    public boolean isRenderFatiga() {
        return renderFatiga;
    }

    public void setRenderEscalosfrio(boolean renderEscalosfrio) {
        this.renderEscalosfrio = renderEscalosfrio;
    }

    public boolean isRenderEscalosfrio() {
        return renderEscalosfrio;
    }

    public void setNumDiasTos(UIInput numDiasTos) {
        this.numDiasTos = numDiasTos;
    }

    public UIInput getNumDiasTos() {
        return numDiasTos;
    }

    public void setNumDiasFiebre(UIInput numDiasFiebre) {
        this.numDiasFiebre = numDiasFiebre;
    }

    public UIInput getNumDiasFiebre() {
        return numDiasFiebre;
    }

    public void setNumDiasDolorGarganta(UIInput numDiasDolorGarganta) {
        this.numDiasDolorGarganta = numDiasDolorGarganta;
    }

    public UIInput getNumDiasDolorGarganta() {
        return numDiasDolorGarganta;
    }

    public void setNumDiasCongestionNasal(UIInput numDiasCongestionNasal) {
        this.numDiasCongestionNasal = numDiasCongestionNasal;
    }

    public UIInput getNumDiasCongestionNasal() {
        return numDiasCongestionNasal;
    }

    public void setNumDiasDificultadRespirar(UIInput numDiasDificultadRespirar) {
        this.numDiasDificultadRespirar = numDiasDificultadRespirar;
    }

    public UIInput getNumDiasDificultadRespirar() {
        return numDiasDificultadRespirar;
    }

    public void setNumDiasFatiga(UIInput numDiasFatiga) {
        this.numDiasFatiga = numDiasFatiga;
    }

    public UIInput getNumDiasFatiga() {
        return numDiasFatiga;
    }

    public void setNumDiasEscalosfrio(UIInput numDiasEscalosfrio) {
        this.numDiasEscalosfrio = numDiasEscalosfrio;
    }

    public UIInput getNumDiasEscalosfrio() {
        return numDiasEscalosfrio;
    }

    public void setLstPreguntasCovidSelectAnt(List<String> lstPreguntasCovidSelectAnt) {
        this.lstPreguntasCovidSelectAnt = lstPreguntasCovidSelectAnt;
    }

    public List<String> getLstPreguntasCovidSelectAnt() {
        return lstPreguntasCovidSelectAnt;
    }

    public void setRenderCovidAnt(boolean renderCovidAnt) {
        this.renderCovidAnt = renderCovidAnt;
    }

    public boolean isRenderCovidAnt() {
        return renderCovidAnt;
    }

    public void setRenderPreguntaCovidAnt(boolean renderPreguntaCovidAnt) {
        this.renderPreguntaCovidAnt = renderPreguntaCovidAnt;
    }

    public boolean isRenderPreguntaCovidAnt() {
        return renderPreguntaCovidAnt;
    }
    
    /**
     * @param param
     */
    public void setListPaises(List<SelectItem> param) {
        this.listPaises = param;
    }

    /**
     * @return
     */
    public List<SelectItem> getListPaises() {
        if (listPaises == null || listPaises.isEmpty()) {
            listPaises = new ArrayList<SelectItem>();
            ArrayList<Cppais> listPaisesAux = null;
            try {
                listPaisesAux = (ArrayList<Cppais>)this.serviceLocator.getClinicoService().getPaises();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listPaisesAux.isEmpty()) {
                Iterator it = listPaisesAux.iterator();
                int i = 0;
                listPaises.add(new SelectItem("", "No Seleccionado ..."));
                while (it.hasNext()) {
                    it.next();
                    listPaises.add(new SelectItem(listPaisesAux.get(i).getCpacodalfa3(), 
                                                         listPaisesAux.get(i).getCpacnombre()));
                    i++;
                }
            }
        }
        return listPaises;
    }
}
