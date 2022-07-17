package org.profamilia.hc.view.backing.cirugia.consulta;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chconocprofa;
import org.profamilia.hc.model.dto.Chconsutarif;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chetnia;
import org.profamilia.hc.model.dto.Chniveleduca;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chtipoafilia;
import org.profamilia.hc.model.dto.Chtipovincu;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chzona;
import org.profamilia.hc.model.dto.Cpdepadane;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpocupacio;
import org.profamilia.hc.model.dto.Cppais;
import org.profamilia.hc.model.dto.Cprestxcon;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.dto.Spservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarCirugiaSinFacturaBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorEPSBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorOcupacionBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class ConsultarUsuarioCirugiaSinFacturaBean extends BaseBean {


    /** Almacena la lista de los posibles estados civil  */
    private List<SelectItem> listEstadoCivil;

    /** Variable que almacena la lista de zonas */
    private List<SelectItem> listzona;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    /** Lista que almacena la lista de Paises  */
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


    private boolean renderUsuario;

    private boolean renderModificar;

    private List<Chusuario> lstUsuarios;

    private List lstEtnia;

    private List lstNivelEducativo;

    private List lstTipoVinculacion;

    private List lstConoceProfamilia;

    private int selectedIndex;

    static final int ACTIVAR_DATOS_USUARIO = 0;

    static final int ACTIVAR_SELECCIONAR_USUARIO = 1;

    private boolean renderSelecionarUsuario;

    private HtmlDataTable dtConsultaUsuario;

    private UIInput calendarFechaNacimiento;

    private List<Spservicio> lstSpservicios;

    private List<Chconsutarif> ltsTarifaServicio;

    private boolean renderBuscadorEPS;

    private boolean renderBuscadorOcupacion;

    private UIInput itEps;

    private boolean deshabilitarEps;

    private static final int ACTIVAR_BUSCADOR = 2;


    private UIInput itOcupacion;


    private boolean deshabilitarOcupacion;

    private static final int ACTIVAR_BUSCADOR_OCUPACION = 3;

    private static final int BEAN_USUARIO_CIRUGIA = 1;
    
    private static final int BEAN_USUARIO_CONSULTA = 2;


    private String seleccionEps;

    private String seleccionOcupacion;


    /** Lista de TipoCliente */
    private List<SelectItem> listTipoCliente;

    private boolean mostrarContrato;
    private boolean mostrarAfiliacion;
    private Cpentidadadm entidad;
    private Integer ocupacio;
    private Cpocupacio ocupacioservix;


    /**Almacena el bean de consultar folios  */

    RegistrarCirugiaSinFacturaBean registrarCirugia;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ConsultarUsuarioCirugiaSinFacturaBean() {

    }


    // ACTIONS

    public void init() {
        usuario = new Chusuario();
        lstUsuarios = new ArrayList<Chusuario>();
        renderUsuario = false;
        renderModificar = false;
        renderSelecionarUsuario = false;
        this.listMunicipios = new ArrayList<SelectItem>();
        selectedIndex = ACTIVAR_DATOS_USUARIO;
        usuario.setHusetipoiden("CC");
        usuario.setHuscnomacompana("-");
        usuario.setHusctelefono("0");
        usuario.setHusccelular("0");
        itEps = new UIInput();
        itOcupacion = new UIInput();


        if (usuario.getHusnnumecontr() != null && 
            usuario.getHusnnumecontr().equals("C")) {
            mostrarContrato = true;
        }
        if (usuario.getHusetipoafilia() != null && 
            !usuario.getHusetipoafilia().equals("X")) {
            mostrarAfiliacion = true;
        }

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


    public void changeSeleccionEps() {
        seleccionEps = null;

        if (usuario.getHuscentidadadm() != null) {
            if (usuario.getHuscentidadadm() != null && 
                !usuario.getHuscentidadadm().equals("")) {
                try {
                    entidad = 
                            (Cpentidadadm)this.serviceLocator.getClinicoService().getAseguradoraPorCodigo(usuario.getHuscentidadadm().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (entidad != null && entidad.getCeaccodigo() != null && 
                    entidad.getCeaccodigo().equals(usuario.getHuscentidadadm())) {
                    seleccionEps = entidad.getCeacnombre();
                } else {
                    FacesUtils.addErrorMessage(seleccionEps = 
                                               "EPS: " + usuario.getHuscentidadadm() + 
                                               " no existe");
                }

            } else {
                FacesUtils.addErrorMessage(seleccionEps = 
                                           "Por Favor escriba una EPS");
            }

        }
    }

    public void changeSeleccionOcupacion() {
        seleccionOcupacion = null;

        if (usuario.getHusnocupacion() != null) {
            if (usuario.getHusnocupacion() != null) {
                try {
                    ocupacioservix = 
                            (Cpocupacio)this.serviceLocator.getClinicoService().getOcupacionPorCodigo(usuario.getHusnocupacion());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (ocupacioservix != null && 
                    ocupacioservix.getCocncodigo() != null) {

                    if (!ocupacioservix.getCocncodigo().equals(usuario.getHusnocupacion())) {
                        FacesUtils.addErrorMessage(seleccionOcupacion = 
                                                   "Ocupaci�n: " + 
                                                   usuario.getHusnocupacion() + 
                                                   " no Coincide, intente nuevamente");
                    } else {
                        seleccionOcupacion = ocupacioservix.getCoccdescri();
                    }

                } else {
                    FacesUtils.addErrorMessage(seleccionOcupacion = 
                                               "Ocupaci�n: " + 
                                               usuario.getHusnocupacion() + 
                                               " no existe, intente nuevamente");
                }

            } else {
                FacesUtils.addErrorMessage(seleccionEps = 
                                           "Por Favor escriba una Ocupaci�n");
            }

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
        renderModificar = false;
        lstUsuarios = new ArrayList<Chusuario>();
        mostrarContrato = false;
        renderSelecionarUsuario = false;

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

                if (lstUsuarios == null) {
                    lstUsuarios = new ArrayList<Chusuario>();
                }

                if (lstUsuarios != null && !lstUsuarios.isEmpty()) {
                    if (lstUsuarios.size() == 1) {
                        usuario = lstUsuarios.get(0);
                        if (usuario.getHusetipcliente() != null && 
                            usuario.getHusetipcliente().equals("C")) {
                            mostrarContrato = true;
                        }
                        if (usuario.getHusnocupacion() != null) {
                            try {
                                seleccionOcupacion = 
                                        serviceLocator.getClinicoService().getDescripcionOcupacion(usuario.getHusnocupacion());
                            } catch (ModelException e) {
                                e.printStackTrace();
                            }
                        }
                        if (usuario != null && !usuario.getHusetipoafilia().equals("X")) {
                            mostrarAfiliacion = true;
                        } else {
                            mostrarAfiliacion = false;
                        }
                        if (usuario.getHuscentidadadm() != null && !usuario.getHuscentidadadm().equals("")) {
                            try {
                                seleccionEps = 
                                        serviceLocator.getClinicoService().getDescripcionEntidadByCodigo(usuario.getHuscentidadadm());
                            } catch (ModelException e) {
                                e.printStackTrace();
                            }
                        }

                        if (usuario.getHuscsegundapel() == null || usuario.getHuscsegundapel().equals("")) {
                            usuario.setHuscsegundapel("-");
                        }
                        renderUsuario = true;
                        if (usuario.getHusnciudad() != null) {
                            this.setCiudad();
                        }
                        renderSelecionarUsuario = false;
                        renderUsuario = true;
                        selectedIndex = ACTIVAR_DATOS_USUARIO;
                        renderModificar = true;
                    }

                    if (lstUsuarios.size() > 1) {
                        renderSelecionarUsuario = true;
                        renderUsuario = false;
                        selectedIndex = ACTIVAR_SELECCIONAR_USUARIO;
                    }
                } else {
                    usuario.setHuslnumero(null);
                    usuario.setHuscprimernomb("");
                    usuario.setHuscsegundnomb("");
                    usuario.setHuscprimerapel("");
                    usuario.setHuscsegundapel("");
                    renderModificar = true;
                    renderSelecionarUsuario = false;
                    renderUsuario = true;
                    selectedIndex = ACTIVAR_DATOS_USUARIO;
                }
            }
        }

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
     * @param usuario
     */
    public void setusuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return
     */
    public Chusuario getusuario() {
        return usuario;
    }

    /**
     * @param renderUsuario
     */
    public void setrenderUsuario(boolean renderUsuario) {
        this.renderUsuario = renderUsuario;
    }

    /**
     * @return
     */
    public boolean isrenderUsuario() {
        return renderUsuario;
    }


    /**
     * @param renderModificar
     */
    public void setRenderModificar(boolean renderModificar) {
        this.renderModificar = renderModificar;
    }

    /**
     * @return
     */
    public boolean isRenderModificar() {
        return renderModificar;
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
    public void setdtConsultaUsuario(HtmlDataTable dtConsultaUsuario) {
        this.dtConsultaUsuario = dtConsultaUsuario;
    }

    /**
     * @return
     */
    public HtmlDataTable getdtConsultaUsuario() {
        return dtConsultaUsuario;
    }


    /**
     * @param renderSelecionarUsuario
     */
    public void setrenderSelecionarUsuario(boolean renderSelecionarUsuario) {
        this.renderSelecionarUsuario = renderSelecionarUsuario;
    }

    /**
     * @return
     */
    public boolean isrenderSelecionarUsuario() {
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


    /**
     * @param lstEtnia
     */
    public void setLstEtnia(List lstEtnia) {
        this.lstEtnia = lstEtnia;
    }

    /**
     * @return
     */
    public List getLstEtnia() {
        if (lstEtnia == null || lstEtnia.isEmpty()) {
            lstEtnia = new ArrayList<SelectItem>();
            ArrayList<Chetnia> listEtniaAux = null;
            try {
                listEtniaAux = 
                        (ArrayList<Chetnia>)this.serviceLocator.getClinicoService().getListaEtnia();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listEtniaAux.isEmpty()) {

                Iterator it = listEtniaAux.iterator();
                int i = 0;
                lstEtnia.add(new SelectItem("", "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstEtnia.add(new SelectItem(listEtniaAux.get(i).getCetecodigo(), 
                                                listEtniaAux.get(i).getCetcdescripcio()));
                    i++;
                }
            }
        }
        return lstEtnia;
    }

    /**
     * @param lstNivelEducativo
     */
    public void setLstNivelEducativo(List lstNivelEducativo) {
        this.lstNivelEducativo = lstNivelEducativo;
    }

    /**
     * @return
     */
    public List getLstNivelEducativo() {
        if (lstNivelEducativo == null || lstNivelEducativo.isEmpty()) {
            lstNivelEducativo = new ArrayList<SelectItem>();
            ArrayList<Chniveleduca> listNivelEducativoAux = null;
            try {
                listNivelEducativoAux = 
                        (ArrayList<Chniveleduca>)this.serviceLocator.getClinicoService().getListaNivelEducativo();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listNivelEducativoAux.isEmpty()) {

                Iterator it = listNivelEducativoAux.iterator();
                int i = 0;
                lstNivelEducativo.add(new SelectItem("", 
                                                     "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstNivelEducativo.add(new SelectItem(listNivelEducativoAux.get(i).getCneecodigo(), 
                                                         listNivelEducativoAux.get(i).getCnecdescripcio()));
                    i++;
                }
            }
        }
        return lstNivelEducativo;
    }

    /**
     * @param lstTipoVinculacion
     */
    public void setLstTipoVinculacion(List lstTipoVinculacion) {
        this.lstTipoVinculacion = lstTipoVinculacion;
    }

    /**
     * @return
     */
    public List getLstTipoVinculacion() {
        if (lstTipoVinculacion == null || lstTipoVinculacion.isEmpty()) {
            lstTipoVinculacion = new ArrayList<SelectItem>();
            ArrayList<Chtipovincu> listTipoVinculacionAux = null;
            try {
                listTipoVinculacionAux = 
                        (ArrayList<Chtipovincu>)this.serviceLocator.getClinicoService().getTipoVinculacion();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listTipoVinculacionAux.isEmpty()) {

                Iterator it = listTipoVinculacionAux.iterator();
                int i = 0;

                while (it.hasNext()) {
                    it.next();
                    lstTipoVinculacion.add(new SelectItem(listTipoVinculacionAux.get(i).getCtvecodigo(), 
                                                          listTipoVinculacionAux.get(i).getCtvcdescripcio()));
                    i++;
                }
            }
        }
        return lstTipoVinculacion;
    }


    /**
     * @param lstSpservicios
     */
    public void setLstSpservicios(List<Spservicio> lstSpservicios) {
        this.lstSpservicios = lstSpservicios;
    }

    /**
     * @return
     */
    public List<Spservicio> getLstSpservicios() {
        return lstSpservicios;
    }

    /**
     * @param lstConoceProfamilia
     */
    public void setLstConoceProfamilia(List lstConoceProfamilia) {
        this.lstConoceProfamilia = lstConoceProfamilia;
    }

    /**
     * @return
     */
    public List getLstConoceProfamilia() {
        if (lstConoceProfamilia == null || lstConoceProfamilia.isEmpty()) {
            lstConoceProfamilia = new ArrayList<SelectItem>();
            ArrayList<Chconocprofa> listConoceProfamiliaAux = null;
            try {
                listConoceProfamiliaAux = 
                        (ArrayList<Chconocprofa>)this.serviceLocator.getClinicoService().getListaConoceProfamilia();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listConoceProfamiliaAux.isEmpty()) {

                Iterator it = listConoceProfamiliaAux.iterator();
                int i = 0;
                lstConoceProfamilia.add(new SelectItem("", 
                                                       "Seleccione una opci�n ..."));

                while (it.hasNext()) {
                    it.next();
                    lstConoceProfamilia.add(new SelectItem(listConoceProfamiliaAux.get(i).getCcpecodigo(), 
                                                           listConoceProfamiliaAux.get(i).getCcpcdescripcio()));
                    i++;
                }
            }
        }
        return lstConoceProfamilia;
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


    public boolean validarDatos() {

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
            
            if(usuario.getHuscetnia() == null ||
                usuario.getHuscetnia().equals("")){
                FacesUtils.addErrorMessage(url + "radioEtnia",
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

            if (usuario.getHusccelular() == null || 
                usuario.getHusccelular().equals("")) {
                FacesUtils.addErrorMessage(url + "TelefonoMovil", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

            if (usuario.getHusezonareside() == null || 
                usuario.getHusezonareside().equals("")) {
                FacesUtils.addErrorMessage(url + "radioZona", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

            if (usuario.getHusndepartamen() == null) {
                FacesUtils.addErrorMessage(url + "menuDepartamentos", 
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

            if (usuario.getHusnocupacion() == null) {
                FacesUtils.addErrorMessage(url + "itOcupacion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

            if (usuario.getHusetipcliente() == null || 
                usuario.getHusetipcliente().equals("")) {
                FacesUtils.addErrorMessage(url + "menuCliente", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

            if (usuario.getHuscnomacompana() == null || 
                usuario.getHuscnomacompana().equals("")) {
                FacesUtils.addErrorMessage(url + "itAcom", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

            if (usuario.getHusetipoafilia() != null && 
                !usuario.getHusetipoafilia().equals("X")) {
                if (usuario.getHuscentidadadm() == null || 
                    usuario.getHuscentidadadm().equals("")) {
                    FacesUtils.addErrorMessage(url + "itEps", 
                                               MSG_CAMPO_OBLIGATORIO);
                    wexito = false;
                }
                if (usuario.getHuscnumafiliac() == null) {
                    FacesUtils.addErrorMessage(url + "itNumeroAfiliacion", 
                                               MSG_CAMPO_OBLIGATORIO);
                    wexito = false;
                }
                if (usuario.getHusetipvincula() == null) {
                    FacesUtils.addErrorMessage(url + "radioVinculacion", 
                                               MSG_CAMPO_OBLIGATORIO);
                    wexito = false;
                }
            }
        }

        return wexito;
    }

    /**
     * @param deshabilitarEps
     */
    public void setDeshabilitarEps(boolean deshabilitarEps) {
        this.deshabilitarEps = deshabilitarEps;
    }

    /**
     * @return
     */
    public boolean isDeshabilitarEps() {
        return deshabilitarEps;
    }


    public void setItEps(UIInput itEps) {
        this.itEps = itEps;
    }

    public UIInput getItEps() {
        return itEps;
    }

    public void setRenderBuscadorEPS(boolean renderBuscadorEPS) {
        this.renderBuscadorEPS = renderBuscadorEPS;
    }

    public boolean isRenderBuscadorEPS() {
        return renderBuscadorEPS;
    }

    public void renderEps() {
        renderBuscadorEPS = true;
        selectedIndex = ACTIVAR_BUSCADOR;
        BuscadorEPSBean buscador = 
            (BuscadorEPSBean)FacesUtils.getManagedBean("buscadorEPSBean");
        buscador.setBeanAnterior(BEAN_USUARIO_CONSULTA);

    }


    public void aceptarEps() {

        BuscadorEPSBean epsAux = 
            (BuscadorEPSBean)FacesUtils.getManagedBean("buscadorEPSBean");


        if (epsAux != null && epsAux.getEpsSelect() != null) {
            itEps.setValue(epsAux.getEpsSelect().getCeaccodigo());
            seleccionEps = epsAux.getEpsSelect().getCeacnombre();

            usuario.setHuscentidadadm(epsAux.getEpsSelect().getCeaccodigo());
            deshabilitarEps = true;

        }
        selectedIndex = ACTIVAR_DATOS_USUARIO;
        renderBuscadorEPS = false;

        FacesUtils.resetManagedBean("buscadorEPSBean");
    }


    /**
     * @param valueChangeEvent
     */
    public void setEps(ValueChangeEvent valueChangeEvent) {
        usuario.setHuscentidadadm((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void renderOcupacion() {
        FacesUtils.resetManagedBean("buscadorOcupacionBean");
        renderBuscadorOcupacion = true;
        selectedIndex = ACTIVAR_BUSCADOR_OCUPACION;

        BuscadorOcupacionBean buscador = 
            (BuscadorOcupacionBean)FacesUtils.getManagedBean("buscadorOcupacionBean");
        buscador.setBeanAnterior(BEAN_USUARIO_CIRUGIA);

    }

    public void aceptarOcupacion() {

        BuscadorOcupacionBean ocupacionAux = 
            (BuscadorOcupacionBean)FacesUtils.getManagedBean("buscadorOcupacionBean");


        if (ocupacionAux != null && 
            ocupacionAux.getOcupacionSelect() != null) {
            itOcupacion.setValue(ocupacionAux.getOcupacionSelect().getCocncodigo());
            seleccionOcupacion = 
                    ocupacionAux.getOcupacionSelect().getCoccdescri();


            usuario.setHusnocupacion(ocupacionAux.getOcupacionSelect().getCocncodigo());
            deshabilitarOcupacion = true;

        }
        selectedIndex = ACTIVAR_DATOS_USUARIO;
        renderBuscadorOcupacion = false;

        FacesUtils.resetManagedBean("buscadorOcupacionBean");
    }

    /**
     * @param valueChangeEvent
     */
    public void setOcupacion(ValueChangeEvent valueChangeEvent) {
        usuario.setHusnocupacion((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setRenderBuscadorOcupacion(boolean renderBuscadorOcupacion) {
        this.renderBuscadorOcupacion = renderBuscadorOcupacion;
    }

    public boolean isRenderBuscadorOcupacion() {
        return renderBuscadorOcupacion;
    }

    public void setItOcupacion(UIInput itOcupacion) {
        this.itOcupacion = itOcupacion;
    }

    public UIInput getItOcupacion() {
        return itOcupacion;
    }

    public void setDeshabilitarOcupacion(boolean deshabilitarOcupacion) {
        this.deshabilitarOcupacion = deshabilitarOcupacion;
    }

    public boolean isDeshabilitarOcupacion() {
        return deshabilitarOcupacion;
    }

    public void setSeleccionEps(String seleccionEps) {
        this.seleccionEps = seleccionEps;
    }

    public String getSeleccionEps() {
        return seleccionEps;
    }

    public void setSeleccionOcupacion(String seleccionOcupacion) {
        this.seleccionOcupacion = seleccionOcupacion;
    }

    public String getSeleccionOcupacion() {
        return seleccionOcupacion;
    }

    public void setListTipoCliente(List<SelectItem> listTipoCliente) {
        this.listTipoCliente = listTipoCliente;
    }

    public List<SelectItem> getListTipoCliente() {

        if (listTipoCliente == null || listTipoCliente.isEmpty()) {
            listTipoCliente = new ArrayList<SelectItem>();
            listTipoCliente.add(new SelectItem("0", "Particular"));
            listTipoCliente.add(new SelectItem("30", "Empleado"));
            listTipoCliente.add(new SelectItem("30", "Familiar"));
            listTipoCliente.add(new SelectItem("C", "Credito"));

        }


        return listTipoCliente;
    }

    public void changeContrato() {

        if (usuario != null && usuario.getHusetipcliente().equals("C")) {
            mostrarContrato = true;
        } else {
            usuario.setHusnnumecontr(null);
            mostrarContrato = false;
        }
    }


    public void changeAfiliacion() {

        if (usuario != null && usuario.getHusetipoafilia().equals("X")) {
            mostrarAfiliacion = false;
        }else if(usuario != null && usuario.getHusetipoafilia().equals("C")){
            mostrarAfiliacion = true;
            usuario.setHuscentidadadm(null);
            usuario.setHuscnumafiliac(null);
            usuario.setHusetipvincula(null);
        }else{
            mostrarAfiliacion = true;
        }
        
    
    }

    /**
     * @param valueChangeEvent
     */
    public void setHusetipcliente(ValueChangeEvent valueChangeEvent) {
        usuario.setHusetipcliente((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHusetipoafilia(ValueChangeEvent valueChangeEvent) {
        usuario.setHusetipoafilia((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setLtsTarifaServicio(List<Chconsutarif> ltsTarifaServicio) {
        this.ltsTarifaServicio = ltsTarifaServicio;
    }

    public List<Chconsutarif> getLtsTarifaServicio() {
        return ltsTarifaServicio;
    }

    public void setMostrarContrato(boolean mostrarContrato) {
        this.mostrarContrato = mostrarContrato;
    }

    public boolean isMostrarContrato() {
        return mostrarContrato;
    }

    public void setMostrarAfiliacion(boolean mostrarAfiliacion) {
        this.mostrarAfiliacion = mostrarAfiliacion;
    }

    public boolean isMostrarAfiliacion() {
        return mostrarAfiliacion;
    }


    public void setOcupacio(Integer ocupacio) {
        this.ocupacio = ocupacio;
    }

    public Integer getOcupacio() {
        return ocupacio;
    }

    public void setOcupacioservix(Cpocupacio ocupacioservix) {
        this.ocupacioservix = ocupacioservix;
    }

    public Cpocupacio getOcupacioservix() {
        return ocupacioservix;
    }

    public void setlstUsuarios(List<Chusuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    public List<Chusuario> getlstUsuarios() {
        return lstUsuarios;
    }

    public String registrarCirugiaSinFactura() {
        // Obtenemos el usuario seleccionado 
        navegationRule = "";
        boolean wexito = true;

        wexito = validarDatos();

        if (wexito && usuario != null) {
            /* salva la informaci�n del usuario en la base de datos */

            try {
                this.serviceLocator.getClinicoService().saveUsuarioAsesoria(usuario, 
                                                                            userName());

                registrarCirugia = 
                        (RegistrarCirugiaSinFacturaBean)FacesUtils.getManagedBean("registrarCirugiaSinFacturaBean");

                if (registrarCirugia != null) {
                    registrarCirugia.setUsuario(usuario);
                 
                    registrarCirugia.cargarConsultas();
                    navegationRule = 
                            BeanNavegacion.RUTA_IR_REGISTRAR_CIRUGIA_SIN_FACTURA;
                }
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(MSG_NO_ADICION + e.getMessage());
                navegationRule = BeanNavegacion.RUTA_ACTUAL;
                e.printStackTrace();
            }
        }
        return navegationRule;
    }
    
    public void resetDatos() {
        usuario = new Chusuario();
        edad = null;
        renderUsuario = false;
        renderModificar = false;
        mostrarAfiliacion = false;
        mostrarContrato = false;
        FacesUtils.resetManagedBean("registrarAsesoriaAviseBean");
        FacesUtils.resetManagedBean("registrarSeguimientoAviseBean");
        FacesUtils.resetManagedBean("registrarUsuarioAsesoriaBean");
        FacesUtils.resetManagedBean("mnuAsesoriaBean");

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
