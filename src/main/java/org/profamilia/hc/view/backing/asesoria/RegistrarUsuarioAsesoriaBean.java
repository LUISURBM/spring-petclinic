//=======================================================================
// ARCHIVO Registrar Usuario Asesoria 
// FECHA CREACI�N: 15/01/2012
// AUTOR: Jos� Andres Riano Rinc�n
// Descripci�n: Registro de Usuario para asesoria.
//=======================================================================

package org.profamilia.hc.view.backing.asesoria;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chaseavise;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chtipoafilia;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chzona;
import org.profamilia.hc.model.dto.Cpdepadane;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpocupacio;
import org.profamilia.hc.model.dto.Cppais;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  CLASE RegistrarUsuarioAsesoriaBean
//=======================================================================
public class RegistrarUsuarioAsesoriaBean extends BaseBean {

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

    /** Lista que almacena la lista de EPS */
    private List<SelectItem> listPaises;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    /** Almacena la edad del usuario*/
    private Integer edad;

    private String nextAction;

    private String navegationRule;

    private String menuBean;

    private boolean renderUsuario;

    private boolean renderRegistrar;

    private List<Chusuario> lstUsuarios;


    private Chaseavise asesoria;

    private boolean renderSeguimiento;

    private int selectedIndex;

    static final int ACTIVAR_DATOS_USUARIO = 0;

    static final int ACTIVAR_MENSAJE = 1;

    static final int ACTIVAR_SELECCIONAR_USUARIOS = 2;

    private String msg_existe_asesoria;

    private List lstOpcionesSeguimiento;

    private String opcionSelect;

    private Date fechaConsulta;

    private boolean navegarAsesoria;

    private boolean navegarSeguimiento;

    private boolean renderSelecionarUsuario;

    private HtmlDataTable dtConsultaUsuario;

    private UIInput calendarFechaNacimiento;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public RegistrarUsuarioAsesoriaBean() {

    }


    // ACTIONS

    public void init() {
    
        if(usuario == null){
            usuario = new Chusuario();
        }
       

        this.listMunicipios = new ArrayList<SelectItem>();
        renderSeguimiento = false;
        selectedIndex = ACTIVAR_DATOS_USUARIO;
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
        usuario = new Chusuario();
        edad = null;
        renderUsuario = false;
        renderRegistrar = false;
        navegarAsesoria = false;
        navegarSeguimiento = false;
        FacesUtils.resetManagedBean("registrarAsesoriaAviseBean");
        FacesUtils.resetManagedBean("registrarSeguimientoAviseBean");
        FacesUtils.resetManagedBean("registrarUsuarioAsesoriaBean");
        FacesUtils.resetManagedBean("mnuAsesoriaBean");
        FacesUtils.resetManagedBean("registroUsuarioNuevaAsesoriaBean");
        FacesUtils.resetManagedBean("mnuNuevaAsesoriaBean");
        

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
                listDepartamentos.add(new SelectItem("", 
                                                     "Seleccione una opci�n ..."));
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
                        (ArrayList<Chsexo>)this.getServiceLocator().getClinicoService().getSexoNew();
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


    /**
     * @param msg_existe_asesoria
     */
    public void setMsg_existe_asesoria(String msg_existe_asesoria) {
        this.msg_existe_asesoria = msg_existe_asesoria;
    }

    /**
     * @return
     */
    public String getMsg_existe_asesoria() {
        return msg_existe_asesoria;
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
     * @param asesoria
     */
    public void setAsesoria(Chaseavise asesoria) {
        this.asesoria = asesoria;
    }

    /**
     * @return
     */
    public Chaseavise getAsesoria() {
        return asesoria;
    }

    /**
     * @param renderSeguimiento
     */
    public void setRenderSeguimiento(boolean renderSeguimiento) {
        this.renderSeguimiento = renderSeguimiento;
    }

    /**
     * @return
     */
    public boolean isRenderSeguimiento() {
        return renderSeguimiento;
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

    /**
     * @param lstOpcionesSeguimiento
     */
    public void setLstOpcionesSeguimiento(List lstOpcionesSeguimiento) {
        this.lstOpcionesSeguimiento = lstOpcionesSeguimiento;
    }

    /**
     * @return
     */
    public List getLstOpcionesSeguimiento() {
        if (lstOpcionesSeguimiento == null || 
            lstOpcionesSeguimiento.isEmpty()) {
            lstOpcionesSeguimiento = new ArrayList();
            lstOpcionesSeguimiento.add(new SelectItem("A", "Asesor�a Nueva"));
            lstOpcionesSeguimiento.add(new SelectItem("S", "Seguimiento"));
        }
        return lstOpcionesSeguimiento;
    }


    /**
     * @param opcionSelect
     */
    public void setOpcionSelect(String opcionSelect) {
        this.opcionSelect = opcionSelect;
    }

    /**
     * @return
     */
    public String getOpcionSelect() {
        return opcionSelect;
    }

    /**
     * @param fechaConsulta
     */
    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    /**
     * @return
     */
    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    /**
     * @param navegarAsesoria
     */
    public void setNavegarAsesoria(boolean navegarAsesoria) {
        this.navegarAsesoria = navegarAsesoria;
    }

    /**
     * @return
     */
    public boolean isNavegarAsesoria() {
        return navegarAsesoria;
    }

    /**
     * @param navegarSeguimiento
     */
    public void setNavegarSeguimiento(boolean navegarSeguimiento) {
        this.navegarSeguimiento = navegarSeguimiento;
    }

    /**
     * @return
     */
    public boolean isNavegarSeguimiento() {
        return navegarSeguimiento;
    }

    /**
     * @param renderSelecionarUsuario
     */
    public void setRenderSelecionarUsuario(boolean renderSelecionarUsuario) {
        this.renderSelecionarUsuario = renderSelecionarUsuario;
    }

    /**
     * @return
     */
    public boolean isRenderSelecionarUsuario() {
        return renderSelecionarUsuario;
    }

    /**
     * @param calendarFechaNacimiento
     */
    public void setCalendarFechaNacimiento(UIInput calendarFechaNacimiento) {
        this.calendarFechaNacimiento = calendarFechaNacimiento;
    }

    /**
     * @return
     */
    public UIInput getCalendarFechaNacimiento() {
        return calendarFechaNacimiento;
    }

    //-----------------------------------------------------------------------
    //  Bot�n Principal
    //-----------------------------------------------------------------------


    /**
     * @return
     */
    public String continuarRegistro() {
        String navegacion = "";
        if (opcionSelect != null) {
            // VERIFICAMOS SI ES ASESORIA 
            if (opcionSelect.equals("A")) {
                navegacion = BeanNavegacion.RUTA_REGISTRAR_ASESORIA_AVISE;
                navegarAsesoria = true;
                navegarSeguimiento = false;
                fechaConsulta = new Date();
                FacesUtils.resetManagedBean(menuBean);
            } else if (opcionSelect.equals("S")) {
                // VERIFICAMOS SI ES SEGUIMIENTO 
                navegarAsesoria = false;
                navegarSeguimiento = true;
                FacesUtils.resetManagedBean(menuBean);
                navegacion = BeanNavegacion.RUTA_REGISTRAR_SEGUIMIENTO_AVISE;
            }
        }

        return navegacion;
    }

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
        renderSeguimiento = false;
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


                // Verificamos si el usuario tiene asesoria anteriores 

                try {
                    asesoria = 
                            this.serviceLocator.getClinicoService().getAsesoriaUsuario(usuario);
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (asesoria == null) {
                    navegarAsesoria = true;
                    navegarSeguimiento = false;
                    navegationRule = 
                            BeanNavegacion.RUTA_REGISTRAR_ASESORIA_AVISE;
                    fechaConsulta = new Date();
                } else {

                    fechaConsulta = asesoria.getId().getHavdfecase();
                    // Si la asesoria principal es del mismos d�a solo se puede adicionar seguimiento
                    if (esElMismoDia(fechaConsulta)) {
                        navegarAsesoria = true;
                        navegarSeguimiento = false;
                        navegationRule = 
                                BeanNavegacion.RUTA_REGISTRAR_SEGUIMIENTO_AVISE;
                        renderSeguimiento = false;
                        selectedIndex = ACTIVAR_DATOS_USUARIO;
                    } else {
                        // Si la asesoria es de otro dia el usuario escoge si desea registrar una asesoria nueva o un seguimiento
                        msg_existe_asesoria = 
                                "Usuario ya tiene un registro del d�a " + 
                               formatearCampo(asesoria.getId().getHavdfecase()) + 
                                " Continuar registrando: ";
                        renderSeguimiento = true;
                        selectedIndex = ACTIVAR_MENSAJE;
                        navegationRule = BeanNavegacion.RUTA_ACTUAL;
                    }

                }

                // Guardamos el usuario 
                try {
                    this.serviceLocator.getClinicoService().saveUsuarioAsesoria(usuario, 
                                                                                userName());

                    FacesUtils.resetManagedBean("mnuAsesoriaBean");
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
