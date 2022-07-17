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

import org.profamilia.hc.model.dto.Chasesoria;
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
public class RegistroUsuarioNuevaAsesoriaBean extends BaseBean {

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

    private List<Chusuario> lstUsuarios;
    

    private int selectedIndex;

    static final int ACTIVAR_DATOS_USUARIO = 0;

    static final int ACTIVAR_SELECCIONAR_USUARIOS = 1;

    private String msg_existe_asesoria;

    private String opcionSelect;

    private Date fechaConsulta;

    private boolean navegarAsesoria;

    private boolean renderSelecionarUsuario;

    private HtmlDataTable dtConsultaUsuario;

    private UIInput calendarFechaNacimiento;

    private Chasesoria asesoria;

    private List lstResultadoEmbarazo;

    private String msgError;
    private boolean renderOtro;
    private boolean renderEnviaGeneral;
    private boolean renderEnviaEspecial;
    private boolean renderEnviaLaboratorio;
    private boolean renderEnviaProductos;
    private boolean renderPsicologia;
    private boolean renderViolencia;
    private boolean renderConsejeriaPadresCuidadores;
    private boolean renderSexualidadPlacer;
    private boolean renderVIHPre;
    private boolean renderVIHPos;
    private boolean renderIntCris;
    private boolean renderEnviaAborto;
    private boolean renderEnviaAnticoncepcion;
    private boolean renderEnviaUnidadFertilidad;
    private boolean renderEnviaOtro;
    private boolean renderEnviaConducta;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public RegistroUsuarioNuevaAsesoriaBean() {

    }


    // ACTIONS

    public void init() {
        asesoria = new Chasesoria();
        selectedIndex = 0;
        RegistrarUsuarioAsesoriaBean encabezado = 
            (RegistrarUsuarioAsesoriaBean)FacesUtils.getManagedBean("registrarUsuarioAsesoriaBean");
        if (encabezado != null) {
            usuario = encabezado.getUsuario();
        }
        //usuario = new Chusuario();

        this.listMunicipios = new ArrayList<SelectItem>();
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

    public void setRenderEnviaOtro(ValueChangeEvent valueChangeEvent) {
        setRenderEnviaOtro(((Boolean)valueChangeEvent.getNewValue()).booleanValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderOtro(ValueChangeEvent valueChangeEvent) {
        setRenderOtro(((Boolean)valueChangeEvent.getNewValue()).booleanValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderVIHPos(ValueChangeEvent valueChangeEvent) {
        setRenderVIHPos(((Boolean)valueChangeEvent.getNewValue()).booleanValue());
        if (!isRenderVIHPos() && !isRenderVIHPre()) {
            setRenderIntCris(false);
        }
        //setRenderIntCris(isRenderIntCris());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderVIHPre(ValueChangeEvent valueChangeEvent) {
        setRenderVIHPre(((Boolean)valueChangeEvent.getNewValue()).booleanValue());
        if (!isRenderVIHPos() && !isRenderVIHPre()) {
            setRenderIntCris(false);
        }
        //setRenderIntCris(isRenderIntCris());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderIntCris(ValueChangeEvent valueChangeEvent) {
        setRenderIntCris(((Boolean)valueChangeEvent.getNewValue()).booleanValue());
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
        asesoria = new Chasesoria();
        renderOtro = false;
        renderEnviaGeneral = false;
        renderEnviaEspecial = false;
        renderEnviaLaboratorio = false;
        renderEnviaProductos = false;
        renderPsicologia = false;
        renderViolencia = false;
        renderConsejeriaPadresCuidadores = false;
        renderSexualidadPlacer = false;
        renderVIHPre = false;
        renderVIHPos = false;
        renderIntCris = false;
        renderEnviaAborto = false;
        renderEnviaAnticoncepcion = false;
        renderEnviaUnidadFertilidad = false;
        renderEnviaOtro = false;
        renderEnviaConducta = false;
        FacesUtils.resetManagedBean("registrarUsuarioAsesoriaBean");//Encabezado
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


    public void setAsesoria(Chasesoria asesoria) {
        this.asesoria = asesoria;
    }

    public Chasesoria getAsesoria() {
        return asesoria;
    }

    public void setLstResultadoEmbarazo(List lstResultadoEmbarazo) {
        this.lstResultadoEmbarazo = lstResultadoEmbarazo;
    }

    public List getLstResultadoEmbarazo() {
        if (lstResultadoEmbarazo == null || lstResultadoEmbarazo.isEmpty()) {
            lstResultadoEmbarazo = new ArrayList();
            lstResultadoEmbarazo.add(new SelectItem("P", "Pos(+)"));
            lstResultadoEmbarazo.add(new SelectItem("N", "Neg(-)"));
        }
        return lstResultadoEmbarazo;
    }

    public List getLstSiNo() {
            List lstSiNo = new ArrayList();
            lstSiNo.add(new SelectItem(false, "No"));
            lstSiNo.add(new SelectItem(true, "S�"));
        return lstSiNo;
    }

    public void setRenderOtro(boolean renderOtro) {
        this.renderOtro = renderOtro;
    }

    public boolean isRenderOtro() {
        return renderOtro;
    }

    public void setRenderEnviaGeneral(boolean renderEnviaGeneral) {
        this.renderEnviaGeneral = renderEnviaGeneral;
    }

    public boolean isRenderEnviaGeneral() {
        return renderEnviaGeneral;
    }

    public void setRenderEnviaEspecial(boolean renderEnviaEspecial) {
        this.renderEnviaEspecial = renderEnviaEspecial;
    }

    public boolean isRenderEnviaEspecial() {
        return renderEnviaEspecial;
    }

    public void setRenderEnviaLaboratorio(boolean renderEnviaLaboratorio) {
        this.renderEnviaLaboratorio = renderEnviaLaboratorio;
    }

    public boolean isRenderEnviaLaboratorio() {
        return renderEnviaLaboratorio;
    }

    public void setRenderEnviaProductos(boolean renderEnviaProductos) {
        this.renderEnviaProductos = renderEnviaProductos;
    }

    public boolean isRenderEnviaProductos() {
        return renderEnviaProductos;
    }

    public void setRenderPsicologia(boolean renderPsicologia) {
        this.renderPsicologia = renderPsicologia;
    }

    public boolean isRenderPsicologia() {
        return renderPsicologia;
    }

    public void setRenderViolencia(boolean renderViolencia) {
        this.renderViolencia = renderViolencia;
    }

    public boolean isRenderViolencia() {
        return renderViolencia;
    }

    public void setRenderConsejeriaPadresCuidadores(boolean renderConsejeriaPadresCuidadores) {
        this.renderConsejeriaPadresCuidadores = 
                renderConsejeriaPadresCuidadores;
    }

    public boolean isRenderConsejeriaPadresCuidadores() {
        return renderConsejeriaPadresCuidadores;
    }

    public void setRenderSexualidadPlacer(boolean renderSexualidadPlacer) {
        this.renderSexualidadPlacer = renderSexualidadPlacer;
    }

    public boolean isRenderSexualidadPlacer() {
        return renderSexualidadPlacer;
    }

    public void setRenderVIHPre(boolean renderVIHPre) {
        this.renderVIHPre = renderVIHPre;
        if (!isRenderVIHPos() && !isRenderVIHPre() ) {
            setRenderIntCris(false);
        }
    }

    public boolean isRenderVIHPre() {
        return renderVIHPre;
    }

    public void setRenderVIHPos(boolean renderVIHPos) {
        this.renderVIHPos = renderVIHPos;
        if (!isRenderVIHPos() && !isRenderVIHPre() ) {
            setRenderIntCris(false);
        }
    }

    public boolean isRenderVIHPos() {
        return renderVIHPos;
    }

    public void setRenderIntCris(boolean renderIntCris) {
        this.renderIntCris = renderIntCris;
    }

    public boolean isRenderIntCris() {
        return renderIntCris;
    }

    public void setRenderEnviaAborto(boolean renderEnviaAborto) {
        this.renderEnviaAborto = renderEnviaAborto;
    }

    public boolean isRenderEnviaAborto() {
        return renderEnviaAborto;
    }

    public void setRenderEnviaAnticoncepcion(boolean renderEnviaAnticoncepcion) {
        this.renderEnviaAnticoncepcion = renderEnviaAnticoncepcion;
    }

    public boolean isRenderEnviaAnticoncepcion() {
        return renderEnviaAnticoncepcion;
    }

    public void setRenderEnviaUnidadFertilidad(boolean renderEnviaUnidadFertilidad) {
        this.renderEnviaUnidadFertilidad = renderEnviaUnidadFertilidad;
    }

    public boolean isRenderEnviaUnidadFertilidad() {
        return renderEnviaUnidadFertilidad;
    }

    public void setRenderEnviaOtro(boolean renderEnviaOtro) {
        this.renderEnviaOtro = renderEnviaOtro;
    }

    public boolean isRenderEnviaOtro() {
        return renderEnviaOtro;
    }

    public void setRenderEnviaConducta(boolean renderEnviaConducta) {
        this.renderEnviaConducta = renderEnviaConducta;
    }

    public boolean isRenderEnviaConducta() {
        return renderEnviaConducta;
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
                // Guardamos el usuario 
                try {
                    this.serviceLocator.getClinicoService().saveUsuarioAsesoria(usuario, 
                                                                                userName());
                    RegistrarUsuarioAsesoriaBean encabezado = 
                        (RegistrarUsuarioAsesoriaBean)FacesUtils.getManagedBean("registrarUsuarioAsesoriaBean");
                    if (encabezado != null && usuario != null) {
                        encabezado.setUsuario(usuario);
                    }
                    FacesUtils.resetManagedBean("mnuNuevaAsesoriaBean");
                    navegationRule = nextAction;
                    navegarAsesoria = true;
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

    public String guardarAsesoria() {
        boolean wexito = true;
        navegationRule = "";
        Chusuario usuarioAux = null;

        try {
            usuarioAux = serviceLocator.getClinicoService().getUsuario(usuario.getHuslnumero());
        } catch (ModelException e) {
            e.printStackTrace();
        }
        
        if (usuario != null && usuario.getHusdfechanacim() != null) {
            setEdad(calcularEdad(usuario.getHusdfechanacim(), new Date()));
        }
        asesoria.setHaslnumusu(usuarioAux.getHuslnumero());
        asesoria.setHasetipoiden(usuarioAux.getHusetipoiden());
        asesoria.setHasanumeiden(usuarioAux.getHusanumeiden());
        asesoria.setHascprimernomb(usuarioAux.getHuscprimernomb() + " " + usuarioAux.getHuscprimerapel());
        asesoria.setHasnedad(edad);
        asesoria.setHasdfechanacim(usuarioAux.getHusdfechanacim());
        asesoria.setHasesexo(usuarioAux.getHusesexo());
        asesoria.setHasdfecregistr(new Date());
        asesoria.setHascoperador(userName());
        asesoria.setHasnclinic(getClinica().getCclncodigo());
        asesoria.setHaseotro(renderOtro ? "S" : "N");
        asesoria.setHascenvmedgen(renderEnviaGeneral ? "S" : "N");
        asesoria.setHascenvmedesp(renderEnviaEspecial ? "S" : "N");
        asesoria.setHascenvlabcli(renderEnviaLaboratorio ? "S" : "N");
        asesoria.setHascenvproduc(renderEnviaProductos ? "S" : "N");
        asesoria.setHascenvpsicolo(renderPsicologia ? "S" : "N");
        asesoria.setHaseestado(ESTADO_VIGENTE);
        asesoria.setHascviolencia(renderViolencia ? "S" : "N");
        asesoria.setHascconspadr(renderConsejeriaPadresCuidadores ? "S" : "N");
        asesoria.setHascconsexpl(renderSexualidadPlacer ? "S" : "N");
        asesoria.setHascvihpre(renderVIHPre ? "S" : "N");
        asesoria.setHascvihpos(renderVIHPos ? "S" : "N");
        if (!renderVIHPre && !renderVIHPos) {
            renderIntCris = false;
        }
        asesoria.setHascintcris(renderIntCris ? "S" : "N");
        
        asesoria.setHascenvabort(renderEnviaAborto ? "S" : "N");
        asesoria.setHascenvantic(renderEnviaAnticoncepcion ? "S" : "N");
        asesoria.setHascenvunifer(renderEnviaUnidadFertilidad ? "S" : "N");
        asesoria.setHascenvotro(renderEnviaOtro ? "S" : "N");
        
        if(!renderConsejeriaPadresCuidadores && !renderSexualidadPlacer && !renderVIHPre && !renderVIHPos &&
                !renderViolencia && !renderOtro)
        {
            wexito = false;
            msgError = " Debe registrar el tipo de asesor\355a";
        }
        if (renderIntCris && !(asesoria.getHascintcrisdet().length() > 10)) {
            wexito = false;
            msgError = " Debe Detallar la Intervenci�n en Crisis (Minimo 10 cararcteres)";
        }
        if(!renderEnviaAnticoncepcion && !renderEnviaGeneral && !renderEnviaEspecial && !renderEnviaAborto && 
                !renderEnviaLaboratorio && !renderEnviaProductos && !renderPsicologia && !renderEnviaUnidadFertilidad && !renderEnviaOtro)
        {
            wexito = false;
            msgError = " Debe registrar a donde se envia";
        }
        if(wexito)
            try
            {
                serviceLocator.getClinicoService().saveOtraAsesoria(asesoria);
                navegationRule = "irRegistrarUsuarioNuevaAsesoria";
                resetDatos();
                FacesUtils.addInfoMessage("Se ingreso la informaci\363n satisfactoriamente.");
            }
            catch(ModelException e)
            {
                navegationRule = "actual";
                FacesUtils.addErrorMessage((new StringBuilder()).append("Adicion no realizada ").append(e.getMessage()).toString());
            }
        else
            FacesUtils.addErrorMessage(msgError);
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
