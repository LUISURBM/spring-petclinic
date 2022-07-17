//=======================================================================
// ARCHIVO DatosUsuarioCitologiaBean
// FECHA CREACI�N: 30/10/2008
// AUTOR: jariano, nlis
// Descripcion: Permite registrar los Datos Basicos de un Usuario
//=======================================================================

package org.profamilia.hc.view.backing.procedimiento;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import java.util.StringTokenizer;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.model.dto.Chconinfxcon;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chplanconsinfo;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chtipoafilia;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chzona;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cncitotoma;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpdepadane;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpocupacio;
import org.profamilia.hc.model.dto.Cpparametr;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.sap.webservice.usuariosSapWSService.UsuarioWsSap;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorConsentimientoBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//====================================================================


//=================================================================
//  CLASE DatosUsuarioBean
//=======================================================================

/**
 * DatosUsuarioBean: Permite registrar los Datos Basicos de un Usuario
 * @author jariano
 * @author nlis
 */
public class DatosUsuarioCitologiaBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------



    /** Almacena true si existe el usuario  */
    boolean existeusuario;

    /** Almacena la lista de los posibles estados civil  */
    private   List<SelectItem> listEstadoCivil;

    /** Variable que almacena la lista de zonas */
    private

    List<SelectItem> listzona;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    /** Lista que almacena la lista de  Departamentos  */
    private List<SelectItem> listDepartamentos;

    /** Lista que almacena la lista de  Ciudades */
    private List<SelectItem> listMunicipios;

    /** Lista que almacena la lista de  Departamentos  */
    private List<SelectItem> listOtrosDepartamentos;

    /** Lista que almacena la lista de  Ciudades */
    private List<SelectItem> listOtrosMunicipios;

    /** Lista que almacena la lista de ocupaciones  */
    private List<SelectItem> listOcupaciones;

    /** Lista que almacena el tipo de afiliacion  */
    private List<SelectItem> listTipoAfiliacion;

    /** Lista de sexos */
    private List<SelectItem> listSexos;

    /** Lista que almacena la lista de EPS */
    private List<SelectItem> listEntidadAdm;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;
    
    /** Almacena los datos de usuario incial */
    private Chusuario usuarioTemp;

    /** Almacena el codigo del departamento */
    private String departamentoSelect;

    /** Almacena el codigo de la ciudad */
    private String ciudadSelect;

    /** Almacena el codigo del departamento */
    private String departamentoOtroSelect;

    /** Almacena el codigo de la ciudad */
    private String ciudadOtraSelect;

    /** Almacena la ocupacion de la persona */
    private String ocupacionSelect;

    /** Almacena la cosnulta X clinica */
    private Cnconsclin consulta;

    /** Almacena la edad del usuario*/
    private Integer edad;

    /** Almacena la fecha de nacimiento*/
    private Date fechaNacimiento;

    /**Variable que almacena el tipo de servicio de la consulta */
    private Cpservicio servicio;

    private Cncitologi citologia;

    private String clinUsuario;

    private Date fecha;

    private Integer tipoHistoria;

    private String nextAction;

    private String menuBean;

    private String navigationRule;

    private boolean renderEPS;
    
    private Long codigoAgenda;
    
    private UsuarioWsSap usuarioWsSap;
    
    private List lstVulnerabilidadSelect;
    
    /** Lista que almacena la lista de Identidades G�neros  */
    private List<SelectItem> listIdentidadGenero;
    
    /** Lista que almacena la lista de Vulnerabilidad  */
    private List listVulnerabilidad;
    
    private boolean renderConsentimiento;
    
    private boolean renderRealizaConsentimiento;
    
    private List lstOpciones;
    
    static final int ACTIVAR_BUSCADOR_CONSENTIMIENTO = 1;
    
    private boolean mostrarConsentimiento;
    
    private int selectedIndex;
    
    private static final int ACTIVAR_DATOS_USUARIO = 0;
    
    private List<Chplanconsinfo> lstConsentimientoAceptados;
    
    private HtmlDataTable dtConsentimiento;
    
    private List<Chconinfxcon> listaChconinfxcon;
    
    private List<Chplanconsinfo> lstConsentimientoInformado;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public DatosUsuarioCitologiaBean() {
    }


    public void init() {

        /** Inicializamos las listas */
        listTipoIdentificacion = new ArrayList<SelectItem>();
        listDepartamentos = new ArrayList<SelectItem>();
        listMunicipios = new ArrayList<SelectItem>();
        listOcupaciones = new ArrayList<SelectItem>();
        listTipoAfiliacion = new ArrayList<SelectItem>();
        listEntidadAdm = new ArrayList<SelectItem>();
        listSexos = new ArrayList<SelectItem>();
        listzona = new ArrayList<SelectItem>();
        listEstadoCivil = new ArrayList<SelectItem>();
        listOtrosDepartamentos = new ArrayList<SelectItem>();
        listIdentidadGenero = new ArrayList<SelectItem>();
        listOtrosMunicipios = new ArrayList<SelectItem>();
        lstVulnerabilidadSelect = new ArrayList();
        listVulnerabilidad = new ArrayList();
        fecha = new Date();
        nextAction = "";
        if (usuario == null) {
            usuario = new Chusuario();
        }
        selectedIndex = ACTIVAR_DATOS_USUARIO;

    }


    public String inicializarDatosUsuario() {
        renderConsentimiento = false;
        
        renderRealizaConsentimiento = false;
        
        try {
            citologia = 
                    this.serviceLocator.getClinicoService().getUsuarioCitologia(consulta);
        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (citologia == null) {
            citologia = new Cncitologi();
            citologia.setCcinnumero(0);
        }else{
                usuario.setHcocreaconinf(citologia.getCcicreaconinf());
                usuario.setHcoccuacondil(citologia.getCciccuacondil());
                usuario.setHcocautusodat(citologia.getCcicautusodat());   
        }
        if (citologia.getCcicvulnera() != null && !citologia.getCcicvulnera().equals("")) {
                StringTokenizer st = new StringTokenizer(citologia.getCcicvulnera(), ",");
                while (st.hasMoreTokens()) {
                    lstVulnerabilidadSelect.add(st.nextToken());
                }
        }
        clinUsuario = this.getClinica().getCclcnombre();

        if (usuario != null) {
            if ("S".equals(usuario.getHcocreaconinf())) {
                renderRealizaConsentimiento = true;
            }
            citologia.setCcictipide(usuario.getHusetipoiden());
            citologia.setCcianumide(usuario.getHusanumeiden());
            citologia.setCcilusuario(usuario);
            citologia.setCcicprinom(usuario.getHuscprimernomb());
            citologia.setCcicsegnom(usuario.getHuscsegundnomb());
            citologia.setCcicpriape(usuario.getHuscprimerapel());
            citologia.setCcicsegape(usuario.getHuscsegundapel());
            citologia.setCcicdirecc(usuario.getHuscdireccion());
            citologia.setCcictelefo(usuario.getHusctelefono());
            citologia.setCcicasegur(usuario.getHuscentidadadm());
            citologia.setCcictipafi(usuario.getHusetipoafilia());
            if (usuario.getHusnciudad() != null) {
                ciudadSelect = usuario.getHusnciudad().toString();
                setCiudad(ciudadSelect);
            }
            if (usuario.getHusndepartamen() != null) {
                departamentoSelect = usuario.getHusndepartamen().toString();
            }
            if (citologia.getCcinotrdep() != null) {
                departamentoOtroSelect = citologia.getCcinotrdep().toString();
            }
            if (citologia.getCcinotrmun() != null) {
                ciudadOtraSelect = citologia.getCcinotrmun().toString();
                setOtraCiudad(ciudadOtraSelect);
            }

            if (usuario.getHusetipoafilia() != null && 
                usuario.getHusetipoafilia().equals("X")) {
                renderEPS = true;
            }

        }
        
        if(consulta != null && consulta.getCcocservic() != null ){
            renderConsentimiento = false;
            if(consulta.getCcocservic().getCsvcaplicons() != null && "S".equals(consulta.getCcocservic().getCsvcaplicons())){
                renderConsentimiento = true;
            }
        }
        try {
            lstConsentimientoInformado = 
                    this.serviceLocator.getClinicoService().getConsentimientoInformado();
        } catch (ModelException e) {
            e.printStackTrace();
        }
        if(consulta != null && consulta.getCconnumero() != null){
            try {
                listaChconinfxcon = 
                        this.serviceLocator.getClinicoService().getConsentimientoXConsulta(consulta.getCconnumero().longValue());       

            } catch (ModelException e) {
               return capturaError(e,IConstantes.ERROR_COSNULTA);
            }
        
            
        if (listaChconinfxcon != null && !listaChconinfxcon.isEmpty() && lstConsentimientoInformado != null && !lstConsentimientoInformado.isEmpty()) {
            if(lstConsentimientoAceptados == null){
                lstConsentimientoAceptados = new ArrayList();
            }
            for(Chconinfxcon consent :listaChconinfxcon){
                for(Chplanconsinfo plancon :lstConsentimientoInformado){
                        if(plancon.getHpcinconsec().equals(consent.getHcicnnucoin().getHpcinconsec())){
                            plancon.setModoconsulta(true);
                            lstConsentimientoAceptados.add(plancon);
                        }
                }
            }
                
        }
        }
        return null;
    }


    /** Definimos los Gets y Set de la aplicacion */
    public

    void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return
     */
    public Chusuario getUsuario() {
        return usuario;
    }

    /**
     * @param param
     */
    public void setExisteusuario(boolean param) {
        this.existeusuario = param;
    }

    /**
     * @return
     */
    public boolean isExisteusuario() {
        return existeusuario;
    }


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
        if (listDepartamentos.size() == 0) {
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
                    listDepartamentos.add(new SelectItem(listDepartamentosAux.get(i).getCddncodigo().toString(), 
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
        if (listOcupaciones.size() == 0) {
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
                    listOcupaciones.add(new SelectItem(listOcpuacionesAux.get(i).getCocncodigo().toString(), 
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
        if (listTipoAfiliacion.size() == 0) {
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


    public void setListzona(List<SelectItem> listzona) {
        this.listzona = listzona;
    }

    public List<SelectItem> getListzona() {
        if (listzona.size() == 0) {
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

    public void setDepartamentoOtroSelect(String departamentoOtroSelect) {
        this.departamentoOtroSelect = departamentoOtroSelect;
    }

    public String getDepartamentoOtroSelect() {
        return departamentoOtroSelect;
    }

    public void setDepartamentoOtroSelect(ValueChangeEvent valueChangeEvent) {
        setDepartamentoOtroSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setCcictipafi(ValueChangeEvent valueChangeEvent) {
        citologia.setCcictipafi((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param ciudadOtraSelect
     */
    public void setCiudadOtraSelect(String ciudadOtraSelect) {
        this.ciudadOtraSelect = ciudadOtraSelect;
    }

    /**
     * @return
     */
    public String getCiudadOtraSelect() {
        return ciudadOtraSelect;
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
     * @param navigationRule
     */
    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    /**
     * @return
     */
    public String getNavigationRule() {
        return navigationRule;
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
        if (listEntidadAdm.size() == 0) {
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
     * @param listOtrosDepartamentos
     */
    public void setListOtrosDepartamentos(List<SelectItem> listOtrosDepartamentos) {
        this.listOtrosDepartamentos = listOtrosDepartamentos;
    }

    /**
     * @return
     */
    public List<SelectItem> getListOtrosDepartamentos() {
        if (listOtrosDepartamentos.size() == 0) {
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
                listOtrosDepartamentos.add(new SelectItem("", 
                                                          "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listOtrosDepartamentos.add(new SelectItem(listDepartamentosAux.get(i).getCddncodigo().toString(), 
                                                              listDepartamentosAux.get(i).getCddcdescri()));
                    i++;
                }
            }
        }
        return listOtrosDepartamentos;
    }


    /**
     * @param listOtrosMunicipios
     */
    public void setListOtrosMunicipios(List<SelectItem> listOtrosMunicipios) {
        this.listOtrosMunicipios = listOtrosMunicipios;
    }

    /**
     * @return
     */
    public List<SelectItem> getListOtrosMunicipios() {
        return listOtrosMunicipios;
    }


    /**
     * @param valueChangeEvent
     */
    public void setDepartamentoSelect(ValueChangeEvent valueChangeEvent) {
        setDepartamentoSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param departamentoSelect
     */
    public void setDepartamentoSelect(String departamentoSelect) {
        this.departamentoSelect = departamentoSelect;
    }

    /**
     * @return
     */
    public String getDepartamentoSelect() {
        return departamentoSelect;
    }

    /**
     * @param ciudadSelect
     */
    public void setCiudadSelect(String ciudadSelect) {
        this.ciudadSelect = ciudadSelect;
    }

    /**
     * @return
     */
    public String getCiudadSelect() {
        return ciudadSelect;
    }

    /**
     * @param ocupacionSelect
     */
    public void setOcupacionSelect(String ocupacionSelect) {
        this.ocupacionSelect = ocupacionSelect;
    }

    /**
     * @return
     */
    public String getOcupacionSelect() {
        return ocupacionSelect;
    }

    /**
     * @param consulta
     */
    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    /**
     * @return
     */
    public Cnconsclin getConsulta() {
        return consulta;
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
     * @param clinUsuario
     */
    public void setClinUsuario(String clinUsuario) {
        this.clinUsuario = clinUsuario;
    }

    /**
     * @return
     */
    public String getClinUsuario() {
        return clinUsuario;
    }

    /**
     * @param renderEPS
     */
    public void setRenderEPS(boolean renderEPS) {
        this.renderEPS = renderEPS;
    }

    /**
     * @return
     */
    public boolean isRenderEPS() {
        return renderEPS;
    }


    /**
     * @param servicio
     */
    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    /**
     * @return
     */
    public Cpservicio getServicio() {
        return servicio;
    }

    /**
     * @param citologia
     */
    public void setCitologia(Cncitologi citologia) {
        this.citologia = citologia;
    }

    /**
     * @return
     */
    public Cncitologi getCitologia() {
        return citologia;
    }

    /**
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return
     */
    public Date getFecha() {
        return fecha;
    }


    /**
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @param valueChangeEvent
     */
    public void setFechaNacimiento(ValueChangeEvent valueChangeEvent) {
        setFechaNacimiento((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }


    public void changeCiudad() {
        if (departamentoSelect != null && !departamentoSelect.equals("")) {
            this.listMunicipios = new ArrayList<SelectItem>();
            ciudadSelect = "";
            ArrayList<Cpmunidane> listMunicipiosAux = null;

            try {

                listMunicipiosAux = 
                        (ArrayList<Cpmunidane>)this.serviceLocator.getClinicoService().getMunicipios(new Integer(departamentoSelect));
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
                    listMunicipios.add(new SelectItem(listMunicipiosAux.get(i).getCmdncodmun().toString(), 
                                                      listMunicipiosAux.get(i).getCmdcnommun()));
                    i++;
                }
            }


        } else {
            listMunicipios = new ArrayList<SelectItem>();
        }


    }


    public void changeOtraCiudad() {
        if (departamentoOtroSelect != null && 
            !departamentoOtroSelect.equals("")) {
            this.listOtrosMunicipios = new ArrayList<SelectItem>();
            ciudadOtraSelect = "";
            ArrayList<Cpmunidane> listMunicipiosAux = null;
            try {

                listMunicipiosAux = 
                        (ArrayList<Cpmunidane>)this.serviceLocator.getClinicoService().getMunicipios(new Integer(departamentoOtroSelect));
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (listMunicipiosAux != null && !listMunicipiosAux.isEmpty()) {

                Iterator it = listMunicipiosAux.iterator();
                int i = 0;
                listOtrosMunicipios.add(new SelectItem("", 
                                                       "Seleccione una opcion ..."));
                while (it.hasNext()) {
                    it.next();
                    listOtrosMunicipios.add(new SelectItem(listMunicipiosAux.get(i).getCmdncodmun().toString(), 
                                                           listMunicipiosAux.get(i).getCmdcnommun()));
                    i++;
                }
            }


        } else {
            listOtrosMunicipios = new ArrayList<SelectItem>();
        }


    }

    public void changeEdad() {
        if (fechaNacimiento != null) {
            setEdad(calcularEdad(fechaNacimiento, new Date()));
        }
    }


    public void changeAfiliacion() {
        if (citologia != null && citologia.getCcictipafi() != null && 
            citologia.getCcictipafi().equals("X")) {
            renderEPS = true;

        } else {
            renderEPS = false;

        }
    }


    /**
     * @param ciudadSelect
     */
    public void setCiudad(String ciudadSelect) {
        if (departamentoSelect!= null && !departamentoSelect.equals("")) {
            this.listMunicipios = new ArrayList<SelectItem>();
            ArrayList<Cpmunidane> listMunicipiosAux = null;
            try {

                listMunicipiosAux = 
                        (ArrayList<Cpmunidane>)this.serviceLocator.getClinicoService().getMunicipios(new Integer(departamentoSelect));
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
                    listMunicipios.add(new SelectItem(listMunicipiosAux.get(i).getCmdncodmun().toString(), 
                                                      listMunicipiosAux.get(i).getCmdcnommun()));
                    i++;
                }
            }


        }
        this.ciudadSelect = ciudadSelect;
    }


    /**
     * @param ciudadSelect
     */
    public void setOtraCiudad(String ciudadSelect) {
        if (!departamentoOtroSelect.equals("")) {
            this.listOtrosMunicipios = new ArrayList<SelectItem>();
            ArrayList<Cpmunidane> listMunicipiosAux = null;
            try {

                listMunicipiosAux = 
                        (ArrayList<Cpmunidane>)this.serviceLocator.getClinicoService().getMunicipios(new Integer(departamentoOtroSelect));
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (listMunicipiosAux != null && !listMunicipiosAux.isEmpty()) {

                Iterator it = listMunicipiosAux.iterator();
                int i = 0;
                listOtrosMunicipios.add(new SelectItem("", 
                                                       "Seleccione una opcion ..."));
                while (it.hasNext()) {
                    it.next();
                    listOtrosMunicipios.add(new SelectItem(listMunicipiosAux.get(i).getCmdncodmun().toString(), 
                                                           listMunicipiosAux.get(i).getCmdcnommun()));
                    i++;
                }
            }


        }
        this.ciudadOtraSelect = ciudadSelect;
    }


    /**
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        Cncitologi citologiaAux = null;

        try {
            citologiaAux = 
                    this.serviceLocator.getClinicoService().getUsuarioCitologia(consulta);
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (citologiaAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }


    /** Botones  */
    public String guardarUsuario() throws Exception {

        navigationRule = "";
        boolean existeCitologia = false;
        boolean wexito = true; 
        String vulnerabilidad = "";
        

        String url = "body:formDatosUsuarios:panelTabDatosUsuario:";

        if (usuario != null) {


            if (citologia.getCcictipide() == null || 
                citologia.getCcictipide().equals("")) {
                FacesUtils.addErrorMessage(url + "tipoIde", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            if (citologia.getCcinnumero() == null) {
                FacesUtils.addErrorMessage(url + "inputNumeroCitologia", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            if (citologia.getCcianumide() == null) {
                FacesUtils.addErrorMessage(url + "idtipo", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            
            if (citologia.getCcicprinom() == null || 
                citologia.getCcicprinom().equals("")) {
                FacesUtils.addErrorMessage(url + "primerNombre", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            if (citologia.getCcicpriape() == null || 
                citologia.getCcicpriape().equals("")) {
                FacesUtils.addErrorMessage(url + "primerApellido", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            if (ciudadSelect == null || 
                ciudadSelect.equals("")) {
                FacesUtils.addErrorMessage(url + "menuCiudad", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            
            if (citologia.getCcicdirecc() == null || 
                citologia.getCcicdirecc().equals("")) {
                FacesUtils.addErrorMessage(url + "Direccion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            /*if (citologia.getCcictelefo() == null || 
                citologia.getCcictelefo().equals("")) {
                FacesUtils.addErrorMessage(url + "Telefono", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            */
            
            if (fechaNacimiento == null ) {
                FacesUtils.addErrorMessage(url + "fechaNacimiento", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            
            if (citologia.getCcictipafi() == null || 
                citologia.getCcictipafi().equals("")) {
                FacesUtils.addErrorMessage(url + "menuAfiliacion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            
            if(citologia.getCcictipafi()!= null 
            && !citologia.getCcictipafi().equals("X")){
                if (citologia.getCcicasegur() == null || 
                    citologia.getCcicasegur().equals("")) {
                    FacesUtils.addErrorMessage(url + "menuEps", 
                                               MSG_CAMPO_OBLIGATORIO);
                    wexito = false;
                }
            }
           
            
            if (citologia.getCcicotrdir() == null || 
                citologia.getCcicotrdir().equals("")) {
                FacesUtils.addErrorMessage(url + "otraDireccion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            if (citologia.getCcicotrtel() == null || 
                citologia.getCcicotrtel().equals("")) {
                FacesUtils.addErrorMessage(url + "otroTelefono", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            if (departamentoOtroSelect == null || 
                departamentoOtroSelect.equals("")) {
                FacesUtils.addErrorMessage(url + "menuOtroDepartamentos", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            if (ciudadOtraSelect == null || 
                ciudadOtraSelect.equals("")) {
                FacesUtils.addErrorMessage(url + "menuOtraCiudad", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            if (lstVulnerabilidadSelect != null && !lstVulnerabilidadSelect.isEmpty()) {
                Iterator it = lstVulnerabilidadSelect.iterator();
                int i = 0;
                while (it.hasNext()) {
                    vulnerabilidad = vulnerabilidad + "," + lstVulnerabilidadSelect.get(i);
                    it.next();
                    i++;
                }
                
                if (vulnerabilidad != null && vulnerabilidad.length() > 2) {
                    vulnerabilidad = 
                            vulnerabilidad.substring(1, vulnerabilidad.length());
                }
                
                citologia.setCcicvulnera(vulnerabilidad);
            }

        }
        
        if(wexito){
            /*String resultadoCreaUsuario = null;
            String resultadoModUsuario = null;
            String codigoSAP = null;
            usuarioWsSap= new UsuarioWsSap();
            */
            TomaCitologiaBean tomaBean = 
                (TomaCitologiaBean)FacesUtils.getManagedBean("tomaCitologiaBean");

            if (citologia.getCcinnumero() != null && 
                !citologia.getCcinnumero().equals(0)) {

                try {
                    existeCitologia = 
                            this.serviceLocator.getClinicoService().verificarCitologia(citologia.getCcinnumero());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (existeCitologia) {
                FacesUtils.addErrorMessage("El n�mero de la citologia ya existe");
            }

            if (departamentoSelect != null && !departamentoSelect.equals("")) {
                citologia.setCcindepart(new Integer(departamentoSelect));
            }
            if (ciudadSelect != null && !ciudadSelect.equals("")) {
                citologia.setCcinmunici(new Integer(ciudadSelect));
            }

            if (departamentoOtroSelect != null && 
                !departamentoOtroSelect.equals("")) {
                citologia.setCcinotrdep(new Integer(departamentoOtroSelect));
            }
            if (ciudadOtraSelect != null && !ciudadOtraSelect.equals("")) {
                citologia.setCcinotrmun(new Integer(ciudadOtraSelect));
            }
            if (this.getClinica() != null && 
                this.getClinica().getCclncodigo() != null) {
                citologia.setCcinclinic(getClinica().getCclncodigo());
            }
            if (edad != null) {
                citologia.setCcinedad(edad);
            }
            citologia.setCcicusureg(userName());
            citologia.setCcidfecreg(new Date());

            citologia.setCcintipdoc(0);
            if (consulta != null && consulta.getCconnumero() != null) {
                citologia.setCcilconcli(new Long(consulta.getCconnumero()));
                citologia.setCcintiphis(consulta.getCcocservic().getCsvntiphis());
            }
            if (consulta != null && consulta.getCcontipdoc() != null && 
                consulta.getCcontipdoc().getCtdnnumero() != null) {
                citologia.setCcintipdoc(consulta.getCcontipdoc().getCtdnnumero());
            }
            if (consulta != null && consulta.getCconnumdoc() != null) {
                citologia.setCcinnumdoc(consulta.getCconnumdoc());
            }

            citologia.setCcidfeccit(new Date());
            citologia.setCcithorreg(new Date());
            citologia.setCcicentreg("N");


            citologia.setCcinestado(0);
            if (usuario != null) {
                citologia.setCcilusuario(usuario);
            }

            if (citologia != null && citologia.getCcictipafi() != null && 
                citologia.getCcictipafi().equals("X")) {
                citologia.setCcicasegur(null);
            }
            citologia.setCcicreaconinf(usuario.getHcocreaconinf());
            citologia.setCciccuacondil(usuario.getHcoccuacondil());
            citologia.setCcicautusodat(usuario.getHcocautusodat());
            
            try {
               /* usuarioTemp = 
                        this.getServiceLocator().getClinicoService().getUsuario(usuario.getHuslnumero());
*/
//                List<Cfdetafactura> listaDetafactura = this.getServiceLocator().getClinicoService().validacionTomaPaquete(consulta.getCconnumero());
                List<Cfdetafactura> listaDetafactura = this.getServiceLocator().getClinicoService().validacionTomaPaquete(consulta.getCconnumdoc().longValue(), consulta.getCcocservic().getCsvccodigo(), consulta.getCconnumero().longValue());
                if(listaDetafactura != null && listaDetafactura.isEmpty()){
                    this.getServiceLocator().getClinicoService().saveUsuarioCitologia(usuario, consulta, citologia, userName(),codigoAgenda);
                } else if(listaDetafactura!= null && listaDetafactura.size()==1){
                    this.getServiceLocator().getClinicoService().saveUsuarioCitologia(usuario, consulta, citologia, userName(),codigoAgenda);
                                                                                      
                    Cnconsclin consulta2 = this.getServiceLocator().getClinicoService().getConsultaClinicaPorId(listaDetafactura.get(0).getCdfnconsuclin().toString());
                    Cncitologi citologiaAux = null;
                    try {
                        if (consulta2 != null) {
                            citologiaAux = this.serviceLocator.getClinicoService().getUsuarioCitologia(consulta2);
                        }
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (citologiaAux == null) {
                        Cncitologi citologia2 = new Cncitologi();
                        citologia2.setCcilconcli(new Long(consulta2.getCconnumero()));
                        citologia2.setCcintiphis(consulta2.getCcocservic().getCsvntiphis());
                        citologia2.setCcinnumdoc(consulta2.getCconnumdoc());
                        citologia2.setCcinconsec(null);
                        citologia2.setCcintipdoc(citologia.getCcintipdoc());
                        citologia2.setCcinnumero(citologia.getCcinnumero());
                        citologia2.setCcinclinic(citologia.getCcinclinic());
                        citologia2.setCcictipide(citologia.getCcictipide());
                        citologia2.setCcianumide(citologia.getCcianumide());
                        citologia2.setCcicprinom(citologia.getCcicprinom());
                        citologia2.setCcicsegnom(citologia.getCcicsegnom());
                        citologia2.setCcicpriape(citologia.getCcicpriape());
                        citologia2.setCcicsegape(citologia.getCcicsegape());
                        citologia2.setCcicdirecc(citologia.getCcicdirecc());
                        citologia2.setCcictelefo(citologia.getCcictelefo());
                        citologia2.setCcindepart(citologia.getCcindepart());
                        citologia2.setCcinmunici(citologia.getCcinmunici());
                        citologia2.setCcicotrdir(citologia.getCcicotrdir());
                        citologia2.setCcicotrtel(citologia.getCcicotrtel());
                        citologia2.setCcinotrdep(citologia.getCcinotrdep());
                        citologia2.setCcinotrmun(citologia.getCcinotrmun());
                        citologia2.setCcinedad(citologia.getCcinedad());
                        citologia2.setCcictipafi(citologia.getCcictipafi());
                        citologia2.setCcicasegur(citologia.getCcicasegur());
                        citologia2.setCcicusureg(citologia.getCcicusureg());
                        citologia2.setCcidfecreg(citologia.getCcidfecreg());
                        citologia2.setCcithorreg(citologia.getCcithorreg());
                        citologia2.setCcidfeccit(citologia.getCcidfeccit());
                        citologia2.setCcicentreg(citologia.getCcicentreg());
                        citologia2.setCcidfecent(citologia.getCcidfecent());
                        citologia2.setCcinestado(citologia.getCcinestado());
                        citologia2.setCcilusuario(citologia.getCcilusuario());
                        citologia2.setCcicidengen(citologia.getCcicidengen());
                        citologia2.setCcicvulnera(citologia.getCcicvulnera());
                        
                        this.getServiceLocator().getClinicoService().saveUsuarioCitologia(usuario, consulta2, citologia2, userName(),null);
                    } else {
                        Cncitologi citologia2 = citologiaAux;
                        citologia2.setCcinclinic(citologia.getCcinclinic());
                        citologia2.setCcictipide(citologia.getCcictipide());
                        citologia2.setCcianumide(citologia.getCcianumide());
                        citologia2.setCcicprinom(citologia.getCcicprinom());
                        citologia2.setCcicsegnom(citologia.getCcicsegnom());
                        citologia2.setCcicpriape(citologia.getCcicpriape());
                        citologia2.setCcicsegape(citologia.getCcicsegape());
                        citologia2.setCcicdirecc(citologia.getCcicdirecc());
                        citologia2.setCcictelefo(citologia.getCcictelefo());
                        citologia2.setCcindepart(citologia.getCcindepart());
                        citologia2.setCcinmunici(citologia.getCcinmunici());
                        citologia2.setCcicotrdir(citologia.getCcicotrdir());
                        citologia2.setCcicotrtel(citologia.getCcicotrtel());
                        citologia2.setCcinotrdep(citologia.getCcinotrdep());
                        citologia2.setCcinotrmun(citologia.getCcinotrmun());
                        citologia2.setCcinedad(citologia.getCcinedad());
                        citologia2.setCcictipafi(citologia.getCcictipafi());
                        citologia2.setCcicasegur(citologia.getCcicasegur());
                        citologia2.setCcicusureg(citologia.getCcicusureg());
                        citologia2.setCcidfecreg(citologia.getCcidfecreg());
                        citologia2.setCcithorreg(citologia.getCcithorreg());
                        citologia2.setCcidfeccit(citologia.getCcidfeccit());
                        citologia2.setCcicentreg(citologia.getCcicentreg());
                        citologia2.setCcidfecent(citologia.getCcidfecent());
                        citologia2.setCcinestado(citologia.getCcinestado());
                        citologia2.setCcilusuario(citologia.getCcilusuario());
                        citologia2.setCcicidengen(citologia.getCcicidengen());
                        citologia2.setCcicvulnera(citologia.getCcicvulnera());
                        this.getServiceLocator().getClinicoService().saveUsuarioCitologia(usuario, consulta2, citologia2, userName(),null);
                    }
                }
                else {
                    FacesUtils.addErrorMessage("NO selecciono detalle de admision");
                }
                /*
                Cpmunidane auxMuni = null;
                auxMuni = 
                        this.serviceLocator.getClinicoService().getMunicipiosSap(usuario.getHusndepartamen(), 
                                                                                 usuario.getHusnciudad());

                if (usuario.getHusccodsap() != null) {
                    Boolean diferente = false;
                    if (compararString(usuario.getHuscprimernomb(),usuarioTemp.getHuscprimernomb()) || 
                        compararString(usuario.getHuscsegundnomb(),usuarioTemp.getHuscsegundnomb()) || 
                        compararString(usuario.getHuscprimerapel(),usuarioTemp.getHuscprimerapel()) || 
                        compararString(usuario.getHuscsegundapel(),usuarioTemp.getHuscsegundapel()) || 
                        usuario.getHusanumeiden()!= usuarioTemp.getHusanumeiden() || 
                        compararString(usuario.getHusesexo(),usuarioTemp.getHusesexo()) || 
                        compararString(usuario.getHuscdireccion(),usuarioTemp.getHuscdireccion()) || 
                        usuario.getHusndepartamen()!= usuarioTemp.getHusndepartamen() || 
                        usuario.getHusnciudad() != usuarioTemp.getHusnciudad() || 
                        compararString(usuario.getHusctelefono(),usuarioTemp.getHusctelefono()) || 
                        compararString(usuario.getHusccelular(),usuarioTemp.getHusccelular()) || 
                        compararString(usuario.getHusetipcliente(),usuarioTemp.getHusetipcliente()) || 
                        compararString(usuario.getHusetipoiden(),usuarioTemp.getHusetipoiden()) || 
                        compararString(usuario.getHuscnomacompana(),usuarioTemp.getHuscnomacompana()) || 
                        compararDate(usuario.getHusdfechanacim(),usuarioTemp.getHusdfechanacim())) {
                        diferente = true;
                    }
                    if (diferente) {
                        resultadoModUsuario = 
                                usuarioWsSap.modificarUsuarioSap(usuario, 
                                                                 usuarioTemp.getHusanumeiden().longValue(), 
                                                                 auxMuni);
                    }
                } else {
                    resultadoCreaUsuario = 
                            usuarioWsSap.saveUsuarioSap(usuario, auxMuni);
                    String[] parts = resultadoCreaUsuario.split("\\|");
                    String respuesta = parts[0];
                    String[] contieneCodigoArray = respuesta.split(" ");
                    String validacion = contieneCodigoArray[0];
                    if ("Nuevo".equals(validacion)) {
                        codigoSAP = contieneCodigoArray[2];
                    } else {
                        codigoSAP = contieneCodigoArray[3];
                        if (usuarioTemp.getHuslnumero() == null) {
                            try {
                                usuarioTemp = 
                                        this.getServiceLocator().getClinicoService().getUsuario(usuario.getHuslnumero());

                            } catch (ModelException e) {
                                e.printStackTrace();
                            }
                        }
                        resultadoModUsuario = 
                                usuarioWsSap.modificarUsuarioSap(usuario, 
                                                                 usuarioTemp.getHusanumeiden().longValue(), 
                                                                 auxMuni);
                    }
                }
                if (codigoSAP != null) {
                    usuario.setHusccodsap(codigoSAP);
                    this.serviceLocator.getClinicoService().updateUsuario(usuario);
                }*/         
               
                if (lstConsentimientoAceptados != null && !lstConsentimientoAceptados.isEmpty()) {
                   if(listaChconinfxcon  == null ){
                       listaChconinfxcon = new ArrayList();
                   }
                        for(Chplanconsinfo plancon :lstConsentimientoAceptados){
                               Chconinfxcon coninfxcon = new Chconinfxcon();
                               if(!plancon.isModoconsulta()){
                                   coninfxcon.setHciccusuaregi(userName());
                                   coninfxcon.setHcicdfechregi( new Date());
                                   coninfxcon.setHcicnnucoin(plancon);
                                   coninfxcon.setHcicnconsulta(consulta.getCconnumero().longValue());
                                   listaChconinfxcon.add(coninfxcon);
                               }
                    }
                        
                }
                 if(listaChconinfxcon != null && !listaChconinfxcon.isEmpty()){
                    this.serviceLocator.getClinicoService().saveConsentimientoInformadoXconsulta(listaChconinfxcon);
                 }
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                navigationRule = nextAction;
                if (citologia != null && citologia.getCcinconsec() != null) {
                    tomaBean.setConsecCitologia(citologia.getCcinconsec());
                    tomaBean.setTipoHistoria(citologia.getCcintiphis());
                    
                }
                FacesUtils.resetManagedBean(menuBean);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                navigationRule = "";
                FacesUtils.addErrorMessage("ERROR " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            navigationRule = BeanNavegacion.RUTA_ACTUAL;
        }
        
        
        return navigationRule;

    }

    public void consultarConsentimientos() {
        FacesUtils.resetManagedBean("buscadorConsentimientoBean");
        BuscadorConsentimientoBean consentimientos;
        consentimientos = 
                (BuscadorConsentimientoBean)FacesUtils.getManagedBean("buscadorConsentimientoBean");
        if (consentimientos != null) {
            consentimientos.init();
        }
        if(citologia !=null){
            
        }
        selectedIndex = ACTIVAR_BUSCADOR_CONSENTIMIENTO;
        mostrarConsentimiento = true;

    }
    
    public void aceptarConsentimientos() {
        BuscadorConsentimientoBean buscadorConsentimientos;
        buscadorConsentimientos = 
                (BuscadorConsentimientoBean)FacesUtils.getManagedBean("buscadorConsentimientoBean");
        if (buscadorConsentimientos != null) {
            if (lstConsentimientoAceptados != null && 
                !lstConsentimientoAceptados.isEmpty()) {
                lstConsentimientoAceptados.addAll(buscadorConsentimientos.getLstConsentimientoSelec());
            } else {
                lstConsentimientoAceptados = buscadorConsentimientos.getLstConsentimientoSelec();
            }
        }
        selectedIndex = ACTIVAR_DATOS_USUARIO;
        mostrarConsentimiento = false;

        FacesUtils.resetManagedBean("buscadorConsentimientoBean");
    }
    
    public void eliminarConsentimiento() {
        Chplanconsinfo consentimientoSelec;
        consentimientoSelec = (Chplanconsinfo)dtConsentimiento.getRowData();
        lstConsentimientoAceptados.remove(consentimientoSelec);

    }
    public void setCodigoAgenda(Long codigoAgenda) {
        this.codigoAgenda = codigoAgenda;
    }

    public Long getCodigoAgenda() {
        return codigoAgenda;
    }

    public void setUsuarioTemp(Chusuario usuarioTemp) {
        this.usuarioTemp = usuarioTemp;
    }

    public Chusuario getUsuarioTemp() {
        return usuarioTemp;
    }

    public void setUsuarioWsSap(UsuarioWsSap usuarioWsSap) {
        this.usuarioWsSap = usuarioWsSap;
    }

    public UsuarioWsSap getUsuarioWsSap() {
        return usuarioWsSap;
    }
    
    /**
     * @param lstVulnerabilidadSelect
     */
    public void setLstVulnerabilidadSelect(List lstVulnerabilidadSelect) {
        this.lstVulnerabilidadSelect = lstVulnerabilidadSelect;
    }

    /**
     * @return
     */
    public List getLstVulnerabilidadSelect() {
        return lstVulnerabilidadSelect;
    }
    
    public List getListVulnerabilidad() {
        if (listVulnerabilidad.size() == 0) {
            ArrayList<Cpparametr> listAux = null;
            try {
                listAux = 
                        (ArrayList<Cpparametr>)this.serviceLocator.getClinicoService().getListaDescripcionesParametro("vulnerabilid");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listAux.isEmpty()) {

                Iterator it = listAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listVulnerabilidad.add(new SelectItem(listAux.get(i).getCpcvalor(), 
                                                              listAux.get(i).getCpcdescrip()));
                    i++;
                }
            }
        }
        return listVulnerabilidad;
    }

    public void setListVulnerabilidad(List listVulnerabilidad) {
        this.listVulnerabilidad = listVulnerabilidad;
    }
    
    public List<SelectItem> getListIdentidadGenero() {
        if (listIdentidadGenero.size() == 0) {
            ArrayList<Cpparametr> listIdentidadGeneroAux = null;
            try {
                listIdentidadGeneroAux = 
                        (ArrayList<Cpparametr>)this.serviceLocator.getClinicoService().getListaDescripcionesParametro("identidadgen");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listIdentidadGeneroAux.isEmpty()) {

                Iterator it = listIdentidadGeneroAux.iterator();
                int i = 0;
                listIdentidadGenero.add(new SelectItem("", 
                                                          "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listIdentidadGenero.add(new SelectItem(listIdentidadGeneroAux.get(i).getCpcvalor(), 
                                                              listIdentidadGeneroAux.get(i).getCpcdescrip()));
                    i++;
                }
            }
        }
        return listIdentidadGenero;
    }

    public void setListIdentidadGenero(List<SelectItem> listIdentidadGenero) {
        this.listIdentidadGenero = listIdentidadGenero;
    }


    
    public Boolean compararString(String dato1, String dato2) {

        if (dato1 != null && dato2 != null) {
            if (!dato1.equals(dato2)) {
                return true;
            } else {
                return false;
            }
        } else if ((dato1 == null && dato2 != null) || 
                   (dato1 != null && dato2 == null)) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean compararDate(Date date1, Date date2) {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        String fecha1 = sd.format(date1);
        String fecha2 = sd.format(date2);
        if (fecha1 != null && fecha2 != null) {
            if (!fecha1.equals(fecha2)) {
                return true;
            } else {
                return false;
            }
        } else if ((fecha1 == null && fecha2 != null) || 
                   (fecha1 != null && fecha2 == null)) {
            return true;
        } else {
            return false;
        }
    }

    public void setRenderConsentimiento(boolean renderConsentimiento) {
        this.renderConsentimiento = renderConsentimiento;
    }

    public boolean isRenderConsentimiento() {
        return renderConsentimiento;
    }

    public void setRenderRealizaConsentimiento(boolean renderRealizaConsentimiento) {
        this.renderRealizaConsentimiento = renderRealizaConsentimiento;
    }

    public boolean isRenderRealizaConsentimiento() {
        return renderRealizaConsentimiento;
    }
    
    public void setHcocreaconinf(ValueChangeEvent valueChangeEvent) {
        usuario.setHcocreaconinf((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void changeConsentimiento() {
        renderRealizaConsentimiento = false;
        if (usuario != null) {
            if ("S".equals(usuario.getHcocreaconinf())) {
                renderRealizaConsentimiento = true;
            }else{
                usuario.setHcoccuacondil(null);
                usuario.setHcocautusodat(null);
            }
        }
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

    public void setMostrarConsentimiento(boolean mostrarConsentimiento) {
        this.mostrarConsentimiento = mostrarConsentimiento;
    }

    public boolean isMostrarConsentimiento() {
        return mostrarConsentimiento;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setLstConsentimientoAceptados(List<Chplanconsinfo> lstConsentimientoAceptados) {
        this.lstConsentimientoAceptados = lstConsentimientoAceptados;
    }

    public List<Chplanconsinfo> getLstConsentimientoAceptados() {
        return lstConsentimientoAceptados;
    }

    public void setDtConsentimiento(HtmlDataTable dtConsentimiento) {
        this.dtConsentimiento = dtConsentimiento;
    }

    public HtmlDataTable getDtConsentimiento() {
        return dtConsentimiento;
    }

    public void setListaChconinfxcon(List<Chconinfxcon> listaChconinfxcon) {
        this.listaChconinfxcon = listaChconinfxcon;
    }

    public List<Chconinfxcon> getListaChconinfxcon() {
        return listaChconinfxcon;
    }

    public void setLstConsentimientoInformado(List<Chplanconsinfo> lstConsentimientoInformado) {
        this.lstConsentimientoInformado = lstConsentimientoInformado;
    }

    public List<Chplanconsinfo> getLstConsentimientoInformado() {
        return lstConsentimientoInformado;
    }
}
