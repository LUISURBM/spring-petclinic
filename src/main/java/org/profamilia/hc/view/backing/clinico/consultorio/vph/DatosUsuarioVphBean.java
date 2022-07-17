//=======================================================================
// ARCHIVO DatosUsuarioVphBean
// FECHA CREACI�N: 30/05/2019
// AUTOR: jariano
// Descripcion: Permite registrar los Datos Basicos de un Usuario
//=======================================================================

package org.profamilia.hc.view.backing.clinico.consultorio.vph;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chdatosvph;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chtipoafilia;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chzona;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpdepadane;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpocupacio;
import org.profamilia.hc.model.dto.Cpparametr;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
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
public class DatosUsuarioVphBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------



    /** Almacena true si existe el usuario  */
    boolean existeusuario;

    /** Almacena la lista de los posibles estados civil  */
    private   List<SelectItem> listEstadoCivil;

    /** Variable que almacena la lista de zonas */
    private List<SelectItem> listzona;
    
    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    /** Lista que almacena la lista de Identidades G�neros  */
    private List<SelectItem> listIdentidadGenero;

    /** Lista que almacena la lista de Vulnerabilidad  */
    private List listVulnerabilidad;
    
    private List lstVulnerabilidadSelect;

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

    private Chdatosvph vph;

    private String clinUsuario;

    private Date fecha;

    private Integer tipoHistoria;

    private String nextAction;

    private String menuBean;

    private String navigationRule;

    private boolean renderEPS;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public DatosUsuarioVphBean() {
    }


    public void init() {

        /** Inicializamos las listas */
        listTipoIdentificacion = new ArrayList<SelectItem>();
        listIdentidadGenero = new ArrayList<SelectItem>();
        listVulnerabilidad = new ArrayList();
        lstVulnerabilidadSelect = new ArrayList();
        listDepartamentos = new ArrayList<SelectItem>();
        listMunicipios = new ArrayList<SelectItem>();
        listOcupaciones = new ArrayList<SelectItem>();
        listTipoAfiliacion = new ArrayList<SelectItem>();
        listEntidadAdm = new ArrayList<SelectItem>();
        listSexos = new ArrayList<SelectItem>();
        listzona = new ArrayList<SelectItem>();
        listEstadoCivil = new ArrayList<SelectItem>();
        listOtrosDepartamentos = new ArrayList<SelectItem>();
        listOtrosMunicipios = new ArrayList<SelectItem>();
        fecha = new Date();
        nextAction = "";
        if (usuario == null) {
            usuario = new Chusuario();
        }


    }


    public void inicializarDatosUsuario() {

        try {
            vph = 
                    this.serviceLocator.getClinicoService().getUsuarioVph(consulta);
        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (vph == null) {
            vph = new Chdatosvph();
            vph.setHdvnnumero(0);
        }
        if (vph.getHdvcvulnera() != null && !vph.getHdvcvulnera().equals("")) {
                StringTokenizer st = new StringTokenizer(vph.getHdvcvulnera(), ",");
                while (st.hasMoreTokens()) {
                    lstVulnerabilidadSelect.add(st.nextToken());
                }
        }
        
        clinUsuario = this.getClinica().getCclcnombre();

        if (usuario != null) {
            vph.setHdvctipide(usuario.getHusetipoiden());
            vph.setHdvanumide(usuario.getHusanumeiden());
            vph.setHdvlusuario(usuario);
            vph.setHdvcprinom(usuario.getHuscprimernomb());
            vph.setHdvcsegnom(usuario.getHuscsegundnomb());
            vph.setHdvcpriape(usuario.getHuscprimerapel());
            vph.setHdvcsegape(usuario.getHuscsegundapel());
            vph.setHdvcdirecc(usuario.getHuscdireccion());
            vph.setHdvctelefo(usuario.getHusctelefono());
            vph.setHdvcasegur(usuario.getHuscentidadadm());
            vph.setHdvctipafi(usuario.getHusetipoafilia());
            if (usuario.getHusnciudad() != null) {
                ciudadSelect = usuario.getHusnciudad().toString();
                setCiudad(ciudadSelect);
            }
            if (usuario.getHusndepartamen() != null) {
                departamentoSelect = usuario.getHusndepartamen().toString();
            }
            if (vph.getHdvnotrdep() != null) {
                departamentoOtroSelect = vph.getHdvnotrdep().toString();
            }
            if (vph.getHdvnotrmun() != null) {
                ciudadOtraSelect = vph.getHdvnotrmun().toString();
                setOtraCiudad(ciudadOtraSelect);
            }

            if (usuario.getHusetipoafilia() != null && 
                usuario.getHusetipoafilia().equals("X")) {
                renderEPS = true;
            }

        }
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

    public void setHdvctipafi(ValueChangeEvent valueChangeEvent) {
        vph.setHdvctipafi((String)valueChangeEvent.getNewValue());
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
     * @param vph
     */
    public void setVph(Chdatosvph vph) {
        this.vph = vph;
    }

    /**
     * @return
     */
    public Chdatosvph getVph() {
        return vph;
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
        if (vph != null && vph.getHdvctipafi() != null && 
            vph.getHdvctipafi().equals("X")) {
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
        Chdatosvph vphAux = null;

        try {
            vphAux = 
                    this.serviceLocator.getClinicoService().getUsuarioVph(consulta);
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (vphAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }


    /** Botones  */
    public String guardarUsuario() {

        navigationRule = "";
        boolean wexito = true; 
        
        
        String vulnerabilidad = "";
        wexito = true;

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
        }

        String url = "body:formDatosUsuarios:panelTabDatosUsuario:";

        if (usuario != null) {
            
            vph.setHdvcvulnera(vulnerabilidad);
            
            if (vph.getHdvctipide() == null || 
                vph.getHdvctipide().equals("")) {
                FacesUtils.addErrorMessage(url + "tipoIde", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            if (vph.getHdvnnumero() == null) {
                FacesUtils.addErrorMessage(url + "inputNumeroVph", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            if (vph.getHdvanumide() == null) {
                FacesUtils.addErrorMessage(url + "idtipo", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            
            if (vph.getHdvcprinom() == null || 
                vph.getHdvcprinom().equals("")) {
                FacesUtils.addErrorMessage(url + "primerNombre", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            if (vph.getHdvcpriape() == null || 
                vph.getHdvcpriape().equals("")) {
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
            
            
            if (vph.getHdvcdirecc() == null || 
                vph.getHdvcdirecc().equals("")) {
                FacesUtils.addErrorMessage(url + "Direccion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            if (vph.getHdvctelefo() == null || 
                vph.getHdvctelefo().equals("")) {
                FacesUtils.addErrorMessage(url + "Telefono", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            if (fechaNacimiento == null ) {
                FacesUtils.addErrorMessage(url + "fechaNacimiento", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            
            if (vph.getHdvctipafi() == null || 
                vph.getHdvctipafi().equals("")) {
                FacesUtils.addErrorMessage(url + "menuAfiliacion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            
            if(vph.getHdvctipafi()!= null 
            && !vph.getHdvctipafi().equals("X")){
                if (vph.getHdvcasegur() == null || 
                    vph.getHdvcasegur().equals("")) {
                    FacesUtils.addErrorMessage(url + "menuEps", 
                                               MSG_CAMPO_OBLIGATORIO);
                    wexito = false;
                }
            }
           
            
            if (vph.getHdvcotrdir() == null || 
                vph.getHdvcotrdir().equals("")) {
                FacesUtils.addErrorMessage(url + "otraDireccion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            if (vph.getHdvcotrtel() == null || 
                vph.getHdvcotrtel().equals("")) {
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

        }
        
        if(wexito){
            TomaVphBean tomaVphBean = 
                (TomaVphBean)FacesUtils.getManagedBean("tomaVphBean");

            
            if (departamentoSelect != null && !departamentoSelect.equals("")) {
                vph.setHdvndepart(new Integer(departamentoSelect));
            }
            if (ciudadSelect != null && !ciudadSelect.equals("")) {
                vph.setHdvnmunici(new Integer(ciudadSelect));
            }

            if (departamentoOtroSelect != null && 
                !departamentoOtroSelect.equals("")) {
                vph.setHdvnotrdep(new Integer(departamentoOtroSelect));
            }
            if (ciudadOtraSelect != null && !ciudadOtraSelect.equals("")) {
                vph.setHdvnotrmun(new Integer(ciudadOtraSelect));
            }
            if (this.getClinica() != null && 
                this.getClinica().getCclncodigo() != null) {
                vph.setHdvnclinic(getClinica().getCclncodigo());
            }
            if (edad != null) {
                vph.setHdvnedad(edad);
            }
            vph.setHdvcusureg(userName());
            vph.setHdvdfecreg(new Date());

            vph.setHdvntipdoc(0);
            if (consulta != null && consulta.getCconnumero() != null) {
                vph.setHdvlconcli(new Long(consulta.getCconnumero()));
            }
            if (consulta != null && consulta.getCcontipdoc() != null && 
                consulta.getCcontipdoc().getCtdnnumero() != null) {
                vph.setHdvntipdoc(consulta.getCcontipdoc().getCtdnnumero());
            }
            if (consulta != null && consulta.getCconnumdoc() != null) {
                vph.setHdvnnumdoc(consulta.getCconnumdoc());
            }

            vph.setHdvdfecdvt(new Date());
            vph.setHdvthorreg(new Date());
            vph.setHdvcentreg("N");


            vph.setHdvnestado(0);
            if (usuario != null) {
                vph.setHdvlusuario(usuario);
            }

            if (vph != null && vph.getHdvctipafi() != null && 
                vph.getHdvctipafi().equals("X")) {
                vph.setHdvcasegur(null);
            }
            try {
                this.getServiceLocator().getClinicoService().saveUsuarioVph(usuario, 
                                                                                  consulta, 
                                                                                  vph, 
                                                                                  userName());
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                navigationRule = nextAction;
                if (vph != null && vph.getHdvnconsec() != null) {
                    tomaVphBean.setConsecCitologia(vph.getHdvnconsec());
                }
                FacesUtils.resetManagedBean(menuBean);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                navigationRule = "";
                FacesUtils.addErrorMessage("ERROR " + e.getMessage());
                e.printStackTrace();
            }
        }
        
        
        return navigationRule;

    }


}
