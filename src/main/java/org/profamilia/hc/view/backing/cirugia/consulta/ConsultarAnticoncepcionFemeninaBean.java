package org.profamilia.hc.view.backing.cirugia.consulta;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class ConsultarAnticoncepcionFemeninaBean extends BaseBean {

    private List<Chingresoenf> lstUsuariosIngresados;
    private List<SelectItem> listTipoIdentificacion;
    private HtmlDataTable dtConsultaUsuario;
    private Chusuario usuario;
    private Chingresoenf ingresoSelect;
    private DatosBasicosUsuarioBean datosUsuario;


    /** Almacena la edad del usuario*/
    private Integer edad;

    public ConsultarAnticoncepcionFemeninaBean() {
    }

    public void init() {
        lstUsuariosIngresados = new ArrayList<Chingresoenf>();
        listTipoIdentificacion = new ArrayList<SelectItem>();
        usuario = new Chusuario();
        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
    }

    /**
     * @return
     */
    public String registrarAnticoncepcionFemenina() {

        ingresoSelect = (Chingresoenf)dtConsultaUsuario.getRowData();
        Chusuario usuario = null;
        try {
            usuario = 
                    this.getServiceLocator().getClinicoService().getUsuario(ingresoSelect.getHielusuario().getHuslnumero());
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }

        if (usuario != null) {
            datosUsuario.setUsuario(usuario);
             

            if (usuario.getHusdfechanacim() != null) {
                edad = calcularEdad(usuario.getHusdfechanacim());
                datosUsuario.setEdad(edad);
              
            }

           

        }
        return BeanNavegacion.RUTA_IR_ANTICONCEPCION_FEMENINA;
    }


    public String buscarPacientesIngresados() {

        try {
            lstUsuariosIngresados = 
                    this.serviceLocator.getCirugiaService().getPacientesIngresados(usuario);
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }
        return null;
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


    public static int calcularEdad(Date fecha) {

        Calendar birth = new GregorianCalendar();
        Calendar today = new GregorianCalendar();
        int age = 0;
        int factor = 0;
        Date birthDate = fecha;
        Date currentDate;
        currentDate = new Date(); //current date
        birth.setTime(birthDate);
        today.setTime(currentDate);
        if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
            if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
                if (today.get(Calendar.DATE) < birth.get(Calendar.DATE)) {
                    factor = -1; //Aun no celebra su cumpleanos
                }
            } else {
                factor = -1; //Aun no celebra su cumpleanos
            }
        }
        age = (today.get(Calendar.YEAR) - birth.get(Calendar.YEAR)) + factor;
        return age;
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

}

