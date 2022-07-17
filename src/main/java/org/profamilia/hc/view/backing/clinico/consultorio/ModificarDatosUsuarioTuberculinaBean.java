//=======================================================================
// ARCHIVO Modificar DatosUsuarioBean
// FECHA CREACI�N: 05/08/2009
// AUTOR: jariano, nlis
// Descripcion: Permite Modificar los datos del usuario
//=======================================================================
package org.profamilia.hc.view.backing.clinico.consultorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chtipoafilia;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chzona;
import org.profamilia.hc.model.dto.Cpdepadane;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpocupacio;
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
public class ModificarDatosUsuarioTuberculinaBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    /** Almacena el tipo de afiliacion */
    private String afiliacion;


    /** Almacena true si existe el usuario  */
    boolean existeusuario;

    /** Variable que almacena que no ocurrio ningun error que se modifico correctamente el usuario*/
    boolean esValido;

    /** Almacena la lista de los posibles estados civil  */
    private

    List<SelectItem> listEstadoCivil;

    /** Variable que almacena la lista de zonas */
    private

    List<SelectItem> listzona;

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

    /** Lista que almacena la lista de EPS */
    private List<SelectItem> listEntidadAdm;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    /** Almacena el codigo del departamento */
    private String departamentoSelect;

    /** Almacena el codigo de la ciudad */
    private String ciudadSelect;

    /** Almacena la ocupacion de la persona */
    private String ocupacionSelect;

    /** Almacena la edad del usuario*/
    private Integer edad;

    /** Almacena la fecha de nacimiento*/
    private Date fechaNacimiento;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ModificarDatosUsuarioTuberculinaBean() {
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
        if (usuario == null) {
            usuario = new Chusuario();
        }
    }


    /** Definimos los Gets y Set de la aplicacion */
    public

    void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setExisteusuario(boolean param) {
        this.existeusuario = param;
    }

    public boolean isExisteusuario() {
        return existeusuario;
    }


    public void setEsValido(boolean param) {
        this.esValido = param;
    }

    public boolean isEsValido() {
        return esValido;
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


    public void setListDepartamentos(List<SelectItem> param) {
        this.listDepartamentos = param;
    }

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

    public void setListMunicipios(List<SelectItem> param) {
        this.listMunicipios = param;
    }

    public List<SelectItem> getListMunicipios() {

        return listMunicipios;
    }

    public void setListOcupaciones(List<SelectItem> param) {
        this.listOcupaciones = param;
    }

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

    public void setListTipoAfiliacion(List<SelectItem> param) {
        this.listTipoAfiliacion = param;
    }

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


    public void setAfiliacion(String afiliacion) {
        this.afiliacion = afiliacion;
    }

    public String getAfiliacion() {
        return afiliacion;
    }


    public void setListEntidadAdm(List<SelectItem> listEntidadAdm) {
        this.listEntidadAdm = listEntidadAdm;
    }

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


    public void setDepartamentoSelect(ValueChangeEvent valueChangeEvent) {
        setDepartamentoSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setDepartamentoSelect(String departamentoSelect) {
        this.departamentoSelect = departamentoSelect;
    }

    public String getDepartamentoSelect() {
        return departamentoSelect;
    }

    public void setCiudadSelect(String ciudadSelect) {
        this.ciudadSelect = ciudadSelect;
    }

    public String getCiudadSelect() {
        return ciudadSelect;
    }

    public void setOcupacionSelect(String ocupacionSelect) {
        this.ocupacionSelect = ocupacionSelect;
    }

    public String getOcupacionSelect() {
        return ocupacionSelect;
    }


    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setFechaNacimiento(ValueChangeEvent valueChangeEvent) {
        setFechaNacimiento((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

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

    public void changeEdad() {
        if (fechaNacimiento != null) {
            setEdad(calcularEdad(fechaNacimiento, new Date()));
        }
    }


    public void setCiudad(String ciudadSelect) {
        if (!departamentoSelect.equals("")) {
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


    /** Botones  */
    public String guardarUsuario() {

        usuario.setHuscoperador(userName());
        usuario.setHusetipoafilia(afiliacion);

        if (ciudadSelect != null) {
            usuario.setHusnciudad(new Integer(ciudadSelect));
        }
        if (departamentoSelect != null) {
            usuario.setHusndepartamen(new Integer(departamentoSelect));
        }
        if (ocupacionSelect != null) {
            usuario.setHusnocupacion(new Integer(ocupacionSelect));
        }
        if (fechaNacimiento != null) {
            usuario.setHusdfechanacim(fechaNacimiento);
        }

        try {
            this.serviceLocator.getClinicoService().updateUsuario(usuario);
            esValido = true;
            FacesUtils.addInfoMessage(IMsg.MSG_ACTUALIZACION);

        } catch (ModelException e) {
            FacesUtils.addErrorMessage("Error al Actualizar Usuario");
            e.printStackTrace();
        }


        return null;
    }

}
