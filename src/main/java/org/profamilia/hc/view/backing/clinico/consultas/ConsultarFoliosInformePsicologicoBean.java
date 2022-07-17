package org.profamilia.hc.view.backing.clinico.consultas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chtipoafilia;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpdepadane;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpocupacio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultorio.RegistrarInformePsicologicoBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class ConsultarFoliosInformePsicologicoBean extends BaseBean {

    private Chusuario usuario;

    /** Almacena el bean de Registrar Folios */

    RegistrarInformePsicologicoBean registrarFolio;


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

    /** Alamacena la consulta seleccionada*/
    private

    Chconsulta consulta;


    /** Almacena la consulta seleccionada*/
    Chconsulta consultaClone;
    
    /** Lista que almacena el tipo de afiliacion  */
    private List<SelectItem> listTipoAfiliacion;
    
    /** Lista que almacena la lista de EPS */
    private List<SelectItem> listEntidadAdm;
    
    /** Lista que almacena la lista de ocupaciones  */
    private List<SelectItem> listOcupaciones;
    
    /** Lista que almacena la lista de  Ciudades */
    private List<SelectItem> listMunicipios;


    public ConsultarFoliosInformePsicologicoBean() {
    }

    public void init() {

        listSexos = new ArrayList<SelectItem>();
        listEstadoCivil = new ArrayList<SelectItem>();
        listTipoIdentificacion = new ArrayList<SelectItem>();
        lstFolios = new ArrayList<Chconsulta>();
        if (usuario == null) {
            usuario = new Chusuario();
        }

    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }


    public void setConsulta(Chconsulta consulta) {
        this.consulta = consulta;
    }

    public Chconsulta getConsulta() {
        return consulta;
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
                        this.getServiceLocator().getClinicoService().getFoliosUsuarioInformePsicologico(usuario.getHuslnumero(),userName());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstFolios == null || lstFolios.isEmpty()) {
                FacesUtils.addErrorMessage(IMsg.MSG_SIN_DATOS);
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

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getEdad() {
        return edad;
    }

    public String registrarInformePsicologico() {
        consulta = (Chconsulta)this.dtFolios.getRowData();
        dtFolios.setFirst(IConstantes.OFFSET_DATATABLE);
        registrarFolio = 
                (RegistrarInformePsicologicoBean)FacesUtils.getManagedBean("registrarInformePsicologicoBean");
        if (consulta != null && registrarFolio != null) {
            registrarFolio.setConsulta(consulta);
            registrarFolio.init();
        }
        return BeanNavegacion.RUTA_REGISTRAR_INFORME_PSICOLOGICO;
    }

    public void setListTipoAfiliacion(List<SelectItem> listTipoAfiliacion) {
        this.listTipoAfiliacion = listTipoAfiliacion;
    }

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

    public void setListEntidadAdm(List<SelectItem> listEntidadAdm) {
        this.listEntidadAdm = listEntidadAdm;
    }

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

    public void setListOcupaciones(List<SelectItem> listOcupaciones) {
        this.listOcupaciones = listOcupaciones;
    }

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


    public void setListMunicipios(List<SelectItem> listMunicipios) {
        this.listMunicipios = listMunicipios;
    }

    public List<SelectItem> getListMunicipios() {
            if (usuario.getHusndepartamen() != null && 
                !usuario.getHusndepartamen().equals("")) {
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
        return listMunicipios;
    }
}
