package org.profamilia.hc.view.backing.sap.registro;

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
import org.profamilia.hc.sap.webservice.creacliente.CreaCliReq;
import org.profamilia.hc.sap.webservice.creacliente.CreaCliente_Sync_OutProxy;
import org.profamilia.hc.sap.webservice.creacliente.Resp;
import org.profamilia.hc.sap.webservice.creacliente.Respuesta;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorEPSBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorOcupacionBean;
import org.profamilia.hc.view.util.FacesUtils;

//=======================================================================
// ARCHIVO Registrar Usuario SAP
// FECHA CREACI�N: 13/05/2014
// AUTOR: Jos� Andres Riano Rinc�n y Carlos Andres Vargas Roa
// Descripci�n: Registro de Usuario para SAP.
//=======================================================================

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE RegistarUsuarioSapBean
//=======================================================================
public class RegistarUsuarioSapBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

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

    private boolean renderRegistrar;

    private List<Chusuario> lstUsuariosActivos;
    
    private List<Chusuario> lstUsuariosInactivos;

    private BigDecimal porDescuento;

    private List lstEtnia;

    private List lstNivelEducativo;

    private List lstTipoVinculacion;

    private List lstConoceProfamilia;

    private int selectedIndex;

    static final int ACTIVAR_DATOS_USUARIO = 0;

    static final int ACTIVAR_SELECCIONAR_USUARIOS = 1;

    private boolean renderSelecionarUsuario;

    private HtmlDataTable dtConsultaUsuario;

    private UIInput calendarFechaNacimiento;

    private List<Spservicio> lstSpservicios;

    private List<Chconsutarif> ltsTarifaServicio;

    private boolean renderBuscador;

    private boolean renderBuscadorOcupacion;

    private UIInput itEps;

    private boolean deshabilitarEps;

    private static final int ACTIVAR_BUSCADOR = 2;


    private UIInput itOcupacion;


    private boolean deshabilitarOcupacion;

    private static final int ACTIVAR_BUSCADOR_OCUPACION = 3;

    private String seleccionEps;

    private String seleccionOcupacion;


    /** Lista de TipoCliente */
    private List<SelectItem> listTipoCliente;

    private List<Cprestxcon> lstRestricc;

    private Chconsutarif tarifa;

    private boolean mostrarContrato;
    private boolean mostrarAfiliacion;
    private Cpentidadadm entidad;
    private Integer ocupacio;
    private Cpocupacio ocupacioservix;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public RegistarUsuarioSapBean() {

    }


    // ACTIONS

    public void init() {
        usuario = new Chusuario();
        lstUsuariosActivos = new ArrayList<Chusuario>();
        lstUsuariosInactivos = new ArrayList<Chusuario>();
        this.listMunicipios = new ArrayList<SelectItem>();
        selectedIndex = ACTIVAR_DATOS_USUARIO;
        usuario.setHusetipoiden("CC");
        usuario.setHuscnomacompana("-");
        usuario.setHusctelefono("0");
        usuario.setHusccelular("0");

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
        renderRegistrar = false;
        lstUsuariosActivos = new ArrayList<Chusuario>();
        lstUsuariosInactivos = new ArrayList<Chusuario>();
        mostrarContrato = false;


        boolean wexito = true;
        String url = "body:formDatosSAPUsuarios:panelTabDatosSAPUsuario:";

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
                    lstUsuariosActivos = 
                            this.serviceLocator.getClinicoService().getUsuariosClienteActivo(usuario.getHusetipoiden(), 
                                                                                usuario.getHusanumeiden());
                                                                               
                                                                                
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                
          
          
                try {
                    lstUsuariosInactivos = 
                            this.serviceLocator.getClinicoService().getUsuariosClienteInactivo(usuario.getHusetipoiden(), 
                                                                                usuario.getHusanumeiden());
                                                                               
                                                                                
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                
                
              
                try {
                    for (Chconsutarif tarifa: ltsTarifaServicio) {
                        porDescuento = 
                                this.serviceLocator.getClinicoService().getDescuentoEmpleado(tarifa.getMaterial(), 
                                                                                             usuario.getHusetipoiden(), 
                                                                                             new BigDecimal(usuario.getHusanumeiden()));
                        if (porDescuento != null) {
                            FacesUtils.addErrorMessage("El % de descuentos Activos es: " + 
                                                       porDescuento);
                        }
                        if (porDescuento != null && 
                            porDescuento.floatValue() > 100) {
                            FacesUtils.addErrorMessage("Excede el 100% de los descuentos permitidos ");
                        }
                    }
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                
                if(lstUsuariosInactivos == null){
                    lstUsuariosInactivos  = new ArrayList<Chusuario>(); 
                }
                
                if(lstUsuariosActivos == null){
                    lstUsuariosActivos  = new ArrayList<Chusuario>(); 
                }



                if (lstUsuariosActivos != null && !lstUsuariosActivos.isEmpty()) {

                    if (lstUsuariosActivos.size() == 1 && lstUsuariosInactivos.isEmpty() ) {
                        usuario = lstUsuariosActivos.get(0);
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
                        if (usuario != null && 
                            !usuario.getHusetipoafilia().equals("X")) {
                            mostrarAfiliacion = true;
                        } else {
                            mostrarAfiliacion = false;
                        }
                        if (usuario.getHuscentidadadm() != null && 
                            !usuario.getHuscentidadadm().equals("")) {

                            try {
                                seleccionEps = 
                                        serviceLocator.getClinicoService().getDescripcionEntidadByCodigo(usuario.getHuscentidadadm());
                            } catch (ModelException e) {
                                e.printStackTrace();
                            }
                        }
                        
                        if(usuario.getHuscsegundapel() == null || usuario.getHuscsegundapel().equals("") ){
                            usuario.setHuscsegundapel("-");
                        }


                        renderUsuario = true;


                        if (usuario.getHusnciudad() != null) {
                            this.setCiudad();
                        }


                    } else if ((lstUsuariosActivos.size() + lstUsuariosInactivos.size()) > 1) {

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
        mostrarAfiliacion = false;
        mostrarContrato = false;
        FacesUtils.resetManagedBean("registrarAsesoriaAviseBean");
        FacesUtils.resetManagedBean("registrarSeguimientoAviseBean");
        FacesUtils.resetManagedBean("registrarUsuarioAsesoriaBean");
        FacesUtils.resetManagedBean("mnuAsesoriaBean");

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
                        (ArrayList<Chsexo>)this.getServiceLocator().getClinicoService().getSexoSap();
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
        String url = "body:formDatosSAPUsuarios:panelTabDatosSAPUsuario:";

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

            if (usuario.getHuscsegundapel() == null || 
                usuario.getHuscsegundapel().equals("")) {
                FacesUtils.addErrorMessage(url + "segundoApellido", 
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
     * @return
     */
    public String guardarUsuario() {
        navegationRule = "";
        String tipoVenta = "";
        nextAction = BeanNavegacion.RUTA_IR_INFORMACION_SERVICIO;

        tipoVenta = "ZPOS";

        boolean wexito = true;
        wexito = validarDatos();

        if (wexito) {
            if (usuario != null) {

                // Guardamos el usuario 
                try {
                    this.serviceLocator.getClinicoService().saveUsuarioSap(usuario, 
                                                                           userName(), 
                                                                           ltsTarifaServicio, 
                                                                           getClinica().getCclncodigo(), 
                                                                           tipoVenta);
                    navegationRule = nextAction;
                    FacesUtils.resetManagedBean("informacionServicioBean");
                    FacesUtils.resetManagedBean("registarUsuarioSapBean");
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


    public String volver() {
        return BeanNavegacion.RUTA_IR_INFORMACION_SERVICIO;
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

    public void setRenderBuscador(boolean renderBuscador) {
        this.renderBuscador = renderBuscador;
    }

    public boolean isRenderBuscador() {
        return renderBuscador;
    }

    public void renderEps() {
        renderBuscador = true;
        selectedIndex = ACTIVAR_BUSCADOR;

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
        renderBuscador = false;

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


    /**
     * @return
     */
    public String invokeCreaCLienteWS() {
        lstRestricc = new ArrayList<Cprestxcon>();

        Cprestxcon restric = null;


        try {


            for (Chconsutarif tarifa: ltsTarifaServicio) {
                if (usuario != null && 
                    usuario.getHusetipcliente().equals("C") && 
                    tarifa != null) {
                    lstRestricc = 
                            this.serviceLocator.getClinicoService().getValidarContrato(getClinica().getCclncodigo(), 
                                                                                       usuario.getHusnnumecontr(), 
                                                                                       tarifa.getMaterial());
                                                                                       
                                                                           
                    if (lstRestricc != null && !lstRestricc.isEmpty()) {
                        for (Cprestxcon restricc: lstRestricc) {
                            if (restricc.getCrxnedamin() <= 
                                usuario.getEdad() && 
                                usuario.getEdad() <= restricc.getCrxnedamax()) {
                                FacesUtils.addInfoMessage("No cumple el rango de Edad del Contrato:" + 
                                                           usuario.getHusnnumecontr());
                            } 

                            if (restricc.getCrxcsexo() != null && 
                                !restricc.getCrxcsexo().equals(usuario.getHusesexo())) {
                                FacesUtils.addInfoMessage("No cumple con el Sexo del Contrato:" + 
                                                           usuario.getHusnnumecontr());
                            }

                            if (restricc.getCrxctideex() != null && 
                                !restricc.getCrxctideex().equals(usuario.getHusetipoiden())) {
                                FacesUtils.addInfoMessage("No cumple con el Tipo de Identificaci�n en el Contrato:" + 
                                                           usuario.getHusnnumecontr());

                            }


                        }
                    }

                }
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }


        navegationRule = "";
        String tipoVenta = "";
        nextAction = BeanNavegacion.RUTA_IR_INFORMACION_SERVICIO;

        tipoVenta = "ZPOS";


        boolean wexito = true;
        wexito = validarDatos();

 
        String url = "body:formDatosSAPUsuarios:panelTabDatosSAPUsuario:";
            if (usuario.getHusnocupacion() == null || usuario.getHusnocupacion().equals("") ) {
            
            //TODO: ACA COLOCA EL MENDAJE AL CAMPO, PARA DECIR VALOR REQUERIDO
             FacesUtils.addErrorMessage(url + "itOcupacion", 
                                        MSG_CAMPO_OBLIGATORIO);
                                        
                wexito = false;
            }else{
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
                            wexito = false; 
                                FacesUtils.addErrorMessage(seleccionOcupacion = 
                                                           "Ocupaci�n: " + 
                                                           usuario.getHusnocupacion() + 
                                                           " no Coincide, intente nuevamente");
                            } else {
                                seleccionOcupacion = ocupacioservix.getCoccdescri();
                            }

                        } else {
                        
                        wexito = false; 
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

        
        
        
      
        if (!usuario.getHusetipoafilia().equals("X")) {
            if (usuario.getHuscentidadadm() == null || 
                usuario.getHuscentidadadm().equals("")) {
                
                //TODO: ACA COLOCA EL MENDAJE AL CAMPO, PARA DECIR VALOR REQUERIDO
                FacesUtils.addErrorMessage(url + "itEps", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }else{
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
                        wexito = false;
                            FacesUtils.addErrorMessage(seleccionEps = 
                                                       "EPS: " + usuario.getHuscentidadadm() + 
                                                       " no existe");
                        }

                    } else {
                    wexito = false;
                        FacesUtils.addErrorMessage(seleccionEps = 
                                                   "Por Favor escriba una EPS");
                    }

                }
            }
            
            
            if(usuario.getHuscprimernomb().indexOf('_') != -1 || usuario.getHuscprimernomb().indexOf('|') != -1){
                FacesUtils.addErrorMessage(url + "primerNombre",
                                            MSG_CARACTER_INVALIDO);
                                            wexito = false;
            }
            if(usuario.getHuscsegundnomb().indexOf('_') != -1 || usuario.getHuscsegundnomb().indexOf('|') != -1){
                FacesUtils.addErrorMessage(url + "segundoNombre",
                                            MSG_CARACTER_INVALIDO);
                                            wexito = false;
            }
            if(usuario.getHuscprimerapel().indexOf('_') != -1 || usuario.getHuscprimerapel().indexOf('|') != -1){
                FacesUtils.addErrorMessage(url + "primerApellido",
                                            MSG_CARACTER_INVALIDO);
                                            wexito = false;
            }
            if(usuario.getHuscsegundapel().indexOf('_') != -1 || usuario.getHuscsegundapel().indexOf('|') != -1){
                FacesUtils.addErrorMessage(url + "segundoApellido",
                                            MSG_CARACTER_INVALIDO);
                                            wexito = false;
            }
            
            if(usuario.getHusctelefono().indexOf('_') != -1 || usuario.getHusctelefono().indexOf('|') != -1){
                FacesUtils.addErrorMessage(url + "Telefono", 
                                           MSG_CARACTER_INVALIDO);
                                           wexito = false;
            }
            
            if(usuario.getHusccelular().indexOf('_') != -1 || usuario.getHusccelular().indexOf('|') != -1){
                FacesUtils.addErrorMessage(url + "TelefonoMovil", 
                                           MSG_CARACTER_INVALIDO);
                                           wexito = false;
            }
            
            if(usuario.getHuscbarrio().indexOf('_') != -1 || usuario.getHuscbarrio().indexOf('|') != -1){
                FacesUtils.addErrorMessage(url + "itBarrio",
                                            MSG_CARACTER_INVALIDO);
                                            wexito = false;                
            }
            if(usuario.getHuscdireccion().indexOf('_') != -1 || usuario.getHuscdireccion().indexOf('|') != -1){
                FacesUtils.addErrorMessage(url + "Direccion",
                                            MSG_CARACTER_INVALIDO);    
                                            wexito = false; 
            }
            if(usuario.getHuscnomacompana().indexOf('_') != -1 || usuario.getHuscnomacompana().indexOf('|') != -1){
                FacesUtils.addErrorMessage(url + "itAcom",
                                            MSG_CARACTER_INVALIDO);
                                            wexito = false;
            }
            if(usuario.getHusctelacompana().indexOf('_') != -1 || usuario.getHusctelacompana().indexOf('|') != -1){
                FacesUtils.addErrorMessage(url + "telAcomp",
                                            MSG_CARACTER_INVALIDO);
                                            wexito = false;
            }          
            if(usuario.getHuscnomacompana().indexOf('_') != -1 || usuario.getHuscnomacompana().indexOf('|') != -1){
                FacesUtils.addErrorMessage(url + "resAcomp",
                                            MSG_CARACTER_INVALIDO);
                                            wexito = false;
            }
            
            
            
           
            
            if (usuario.getHuscnumafiliac() == null) {
            
                //TODO: ACA COLOCA EL MENDAJE AL CAMPO, PARA DECIR VALOR REQUERIDO
                FacesUtils.addErrorMessage(url + "itNumeroAfiliacion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            if (usuario.getHusetipvincula() == null) {
            
                //TODO: ACA COLOCA EL MENDAJE AL CAMPO, PARA DECIR VALOR REQUERIDO
                FacesUtils.addErrorMessage(url + "radioVinculacion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

        }

        if (wexito) {
            if (usuario != null) {


                // Guardamos el usuario 
                try {
                    this.serviceLocator.getClinicoService().saveUsuarioSap(usuario, 
                                                                           userName(), 
                                                                           ltsTarifaServicio, 
                                                                           getClinica().getCclncodigo(), 
                                                                           tipoVenta);
                    navegationRule = nextAction;
                    FacesUtils.resetManagedBean("registarUsuarioSapBean");
                    FacesUtils.resetManagedBean("informacionServicioBean");
                    FacesUtils.addInfoMessage(MSG_ADICION);

                } catch (ModelException e) {
                    FacesUtils.addErrorMessage(MSG_NO_ADICION + 
                                               e.getMessage());
                    navegationRule = BeanNavegacion.RUTA_ACTUAL;
                    e.printStackTrace();
                }

            }


            try {
                CreaCliente_Sync_OutProxy service = 
                    new CreaCliente_Sync_OutProxy();


                Respuesta result;

                CreaCliReq creaclient = new CreaCliReq();
                creaclient.setNombre1(usuario.getHuscprimernomb());
                creaclient.setNombre2(usuario.getHuscsegundnomb());
                creaclient.setNombre3(usuario.getHuscprimerapel());
                if(usuario.getHuscsegundapel() == null || usuario.getHuscsegundapel().equals("")){
                    creaclient.setNombre4("-"); 
                }else{
                    creaclient.setNombre4(usuario.getHuscsegundapel()); 
                }
                
                
                if(usuario.getHuscsegundnomb() == null || usuario.getHuscsegundnomb().equals("")){
                    creaclient.setNombre2("-"); 
                }else{
                    creaclient.setNombre2(usuario.getHuscsegundnomb()); 
                }
               
                creaclient.setCampoClasific(usuario.getHusanumeiden().toString());
                if (usuario.getHusetipcliente() != null && 
                    usuario.getHusetipcliente().equals("0")) {
                    creaclient.setGrupoCtasDeudor("ZPAR");
                } else if (usuario.getHusetipcliente() != null && 
                           usuario.getHusetipcliente().equals("30")) {
                    creaclient.setGrupoCtasDeudor("ZEMP");
                } else if (usuario.getHusetipcliente() != null && 
                           usuario.getHusetipcliente().equals("30")) {
                    creaclient.setGrupoCtasDeudor("ZEMP");
                } else if (usuario.getHusetipcliente() != null && 
                           usuario.getHusetipcliente().equals("C")) {
                    creaclient.setGrupoCtasDeudor("ZPAR");
                    ;
                }

                if (usuario.getHusesexo() != null && 
                    usuario.getHusesexo().equals("F")) {
                    creaclient.setTratamiento("SE�ORA");
                } else if (usuario.getHusesexo() != null && 
                           usuario.getHusesexo().equals("M")) {
                    creaclient.setTratamiento("SE�OR");
                } else if (usuario.getHusesexo() != null && 
                           usuario.getHusesexo().equals("I")) {
                    creaclient.setTratamiento("SE�OR Y SE�ORA");
                }
                creaclient.setCallenum(usuario.getHuscdireccion());

                Cpmunidane auxMuni = null;
                auxMuni = 
                        this.serviceLocator.getClinicoService().getMunicipiosSap(usuario.getHusndepartamen(), 
                                                                                 usuario.getHusnciudad());

                if (usuario.getHusndepartamen() != null && 
                    usuario.getHusndepartamen().equals(11)) {
                    creaclient.setPoblacion("BOGOTA");
                } else {
                    creaclient.setPoblacion(auxMuni.getCmdcnommun());
                }

                creaclient.setClavePais(DATOS_GENERAL_CLAVE_PAIS);
                creaclient.setRegion(usuario.getHusndepartamen().toString());
                creaclient.setTel(usuario.getHusctelefono());
                creaclient.setTelMovil(usuario.getHusccelular());
                creaclient.setFax("0");
                if (usuario.getHusetipcliente() != null && 
                    usuario.getHusetipcliente().equals("F")) {
                    creaclient.setRamoIndust("Z002");
                } else {
                    creaclient.setRamoIndust("");
                }
                creaclient.setNumFiscal(usuario.getHusanumeiden().toString());

                if (usuario.getHusetipoiden() != null && 
                    usuario.getHusetipoiden().equals("CC")) {
                    creaclient.setTipoNumFiscal("13");
                } else if (usuario.getHusetipoiden() != null && 
                           usuario.getHusetipoiden().equals("TI")) {
                    creaclient.setTipoNumFiscal("12");
                } else if (usuario.getHusetipoiden() != null && 
                           usuario.getHusetipoiden().equals("RC")) {
                    creaclient.setTipoNumFiscal("11");
                } else if (usuario.getHusetipoiden() != null && 
                           usuario.getHusetipoiden().equals("CE")) {
                    creaclient.setTipoNumFiscal("22");
                } else if (usuario.getHusetipoiden() != null && 
                           usuario.getHusetipoiden().equals("AS")) {
                    creaclient.setTipoNumFiscal("51");
                } else if (usuario.getHusetipoiden() != null && 
                           usuario.getHusetipoiden().equals("PA")) {
                    creaclient.setTipoNumFiscal("41");
                } else if (usuario.getHusetipoiden() != null && 
                           usuario.getHusetipoiden().equals("MS")) {
                    creaclient.setTipoNumFiscal("52");
                } else if (usuario.getHusetipoiden() != null && 
                           usuario.getHusetipoiden().equals("NI")) {
                    creaclient.setTipoNumFiscal("31");
                }

                creaclient.setLIS(DATOS_LIS);
                creaclient.setPerFisica(DATOS_GENERAL_PERSONA_FISICA);
                creaclient.setClasificacionDeudor(DATOS_GENERAL_CLASIFICACION_DEUDOR);
                creaclient.setSociedad(DATOS_SOCIEDAD_SOCIEDAD);
                creaclient.setCuentaAsoc(DATOS_SOCIEDAD_CUENTA_ASOCIADA);
                creaclient.setClaveAsig(DATOS_SOCIEDAD_CLAVE_ASIG);
                creaclient.setGrupTesorera(DATOS_SOCIEDAD_GRUPO_TESORERIA);
                creaclient.setClaveCondPago(DATOS_SOCIEDAD_CLAVE_COND_PAGO);
                creaclient.setOrgVentas(DATOS_COMERCIAL_ORG_VENTAS);
                creaclient.setCanalDist(DATOS_COMERCIAL_CANALDIST);
                creaclient.setSector(DATOS_COMERCIAL_SECTOR);
                creaclient.setGrupoClientes(DATOS_COMERCIAL_GRUPO_CLIENTES);
                creaclient.setClaveMoneda(DATOS_COMERCIAL_CLAVE_MONEDA);
                creaclient.setEsqCliente(DATOS_COMERCIAL_ESQUEMA_CLIENTE);
                creaclient.setCondExped(DATOS_COMERCIAL_COND_EXPEDICION);
                creaclient.setClaveCondPago(DATOS_COMERCIAL_CLAVE_COND_PAGO);
                creaclient.setGrupImputClient(DATOS_COMERCIAL_GRUP_IMPUT_CLIENTE);


                if (usuario.getHuscnomacompana() == null || 
                    usuario.getHuscnomacompana().equals("")) {
                    creaclient.setNombreCompl("-");
                } else {
                    creaclient.setNombreCompl(usuario.getHuscnomacompana());
                }

                creaclient.setFechaNacim((usuario.getHusdfechanacim()));
                creaclient.setFuncionPersona(CLIENTE_CONTACTO_FUNCION_CONTACTO);

                if (usuario.getHusesexo() != null && 
                    usuario.getHusesexo().equals("M")) {
                    creaclient.setGenero("1");
                } else if (usuario.getHusesexo() != null && 
                           usuario.getHusesexo().equals("F")) {
                    creaclient.setGenero("2");
                } else if (usuario.getHusesexo() != null && 
                           usuario.getHusesexo().equals("I")) {
                    creaclient.setGenero("0");
                }

                if (creaclient.getFechaNacim() != null) {


                    Respuesta respuesta = 
                        service.creaCliente_Sync_Out(creaclient);
                    result = respuesta;

                    System.out.println("entro" + respuesta.getResp());
                    Resp[] resp;
                    resp = respuesta.getResp();

                    for (Resp auxi: resp) {
                        System.out.println("" + auxi.getMessage());
                        FacesUtils.addInfoMessage(auxi.getMessage());
                        
                    }
                } else {
                    FacesUtils.addErrorMessage("Verifique la fecha de nacimiento e intente nuevamente");
                    navegationRule = null;
                }


            } catch (RemoteException e) {
                navegationRule = null; 
                FacesUtils.addErrorMessage("ERROR " + e.getMessage() );
                System.out.println(e.getMessage());
            } catch (ModelException e) {
                navegationRule = null; 
                FacesUtils.addErrorMessage("ERROR " + e.getMessage() );
                System.out.println(e.getMessage());
                

            }
        }


        return navegationRule;

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

        if (usuario != null && !usuario.getHusetipoafilia().equals("X")) {
            mostrarAfiliacion = true;
        } else {
            usuario.setHuscentidadadm(null);
            usuario.setHuscnumafiliac(null);
            usuario.setHusetipvincula(null);
            mostrarAfiliacion = false;
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

    public void setLstUsuariosActivos(List<Chusuario> lstUsuariosActivos) {
        this.lstUsuariosActivos = lstUsuariosActivos;
    }

    public List<Chusuario> getLstUsuariosActivos() {
        return lstUsuariosActivos;
    }

    public void setLstUsuariosInactivos(List<Chusuario> lstUsuariosInactivos) {
        this.lstUsuariosInactivos = lstUsuariosInactivos;
    }

    public List<Chusuario> getLstUsuariosInactivos() {
        return lstUsuariosInactivos;
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

