package org.profamilia.hc.view.backing.cirugia.consulta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chingresoenf;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.registro.DescripcionQuirurgicaBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.util.FacesUtils;


public class ConsultarUsuariosIngresadosMedicoBean extends BaseBean {

    private List<Chingresoenf> lstUsuariosIngresados;

    private List<SelectItem> listTipoIdentificacion;

    private HtmlDataTable dtConsultaUsuario;

    private Chusuario usuario;

    private Chingresoenf ingresoSelect;

    private String nombreLabel;

    public ConsultarUsuariosIngresadosMedicoBean() {

    }

    public void init() {
        lstUsuariosIngresados = new ArrayList<Chingresoenf>();
        listTipoIdentificacion = new ArrayList<SelectItem>();
        usuario = new Chusuario();
        nombreLabel = "Descripci�n Quirurgica";
    }

    /**
     * @param nombreLabel
     */
    public void setNombreLabel(String nombreLabel) {
        this.nombreLabel = nombreLabel;
    }

    /**
     * @return
     */
    public String getNombreLabel() {
        return nombreLabel;
    }

    /**
     * @param lstUsuariosIngresados
     */
    public void setLstUsuariosIngresados(List<Chingresoenf> lstUsuariosIngresados) {
        this.lstUsuariosIngresados = lstUsuariosIngresados;
    }

    /**
     * @return
     */
    public List<Chingresoenf> getLstUsuariosIngresados() {
        return lstUsuariosIngresados;
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
     * @param ingresoSelect
     */
    public void setIngresoSelect(Chingresoenf ingresoSelect) {
        this.ingresoSelect = ingresoSelect;
    }

    /**
     * @return
     */
    public Chingresoenf getIngresoSelect() {
        return ingresoSelect;
    }


    

    public void buscarPacientesIngresados() {

        try {
            lstUsuariosIngresados = 
                    this.serviceLocator.getCirugiaService().getPacientesIngresados(usuario);
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }


}
