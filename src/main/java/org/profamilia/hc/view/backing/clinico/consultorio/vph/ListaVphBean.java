//=======================================================================
// ARCHIVO ListaVphBean
// FECHA CREACI�N: 30/05/2019
// AUTOR: jariano
// Descripcion: Permite visualizar la lista de usuarios de VPH por medico 
// para un Usuario de una Histroia Clinica 
//=======================================================================
package org.profamilia.hc.view.backing.clinico.consultorio.vph;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;

import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE
//=======================================================================

public class ListaVphBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    /** */
    private Date fechaActual;

    /** */
    private List lstUsuarios;

    /** Almacena el usuario  */
    private String usuarioSelect;

    /** Almacena el Bean de Datos de Usuario*/
    DatosUsuarioVphBean datosUsuarioVph;

    /** Almacena true si existen consultas para el dia */
    boolean existeConsulta;

    /** Almacena el componente tabla  */
    private HtmlDataTable dtConsultas;

    /**Variable que almacena el tipo de servicio de la consulta */
    private Cpservicio servicio;

    /** */
    private Cnconsclin consultaClone;

    /** Almacena la edad del usuario*/
    private Integer edad;

    /** Almacena el mensaje si no encuentra registros**/
    private String msg_sin_registros;

    private List menuAdmin;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ListaVphBean() {

    }


    public void init() {
        lstUsuarios = new ArrayList();
    }


    /**
     * @param fechaActual
     */
    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    /**
     * @param valueChangeEvent
     */
    public void setFechaActual(ValueChangeEvent valueChangeEvent) {
        setFechaActual((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @return
     */
    public Date getFechaActual() {
        return fechaActual;
    }


    /**
     * @param lstUsuarios
     */
    public void setLstUsuarios(List lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    /**
     * @return
     */
    public List getLstUsuarios() {
        return lstUsuarios;
    }

    /**
     * @param usuarioSelect
     */
    public void setUsuarioSelect(String usuarioSelect) {
        this.usuarioSelect = usuarioSelect;
    }

    /**
     * @return
     */
    public String getUsuarioSelect() {
        return usuarioSelect;
    }

    /**
     * @param msg_sin_registros
     */
    public void setMsg_sin_registros(String msg_sin_registros) {
        this.msg_sin_registros = msg_sin_registros;
    }

    /**
     * @return
     */
    public String getMsg_sin_registros() {
        return msg_sin_registros;
    }

    /**
     * @param menuAdmin
     */
    public void setMenuAdmin(List menuAdmin) {
        this.menuAdmin = menuAdmin;
    }

    /**
     * @return
     */
    public List getMenuAdmin() {
        return menuAdmin;
    }

    /**
     * @param existeConsulta
     */
    public void setExisteConsulta(boolean existeConsulta) {
        this.existeConsulta = existeConsulta;
    }

    /**
     * @return
     */
    public boolean isExisteConsulta() {
        if (lstUsuarios.size() > 0) {
            existeConsulta = true;
        } else {
            existeConsulta = false;
            if (fechaActual != null) {

                String DATE_FORMAT = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                String fechaCons = sdf.format(fechaActual);

                msg_sin_registros = 
                        IConstantes.NO_EXISTEN_VPH_PARA_LA_FECHA + 
                        fechaCons;
            }


        }
        return existeConsulta;
    }


    public void setDtConsultas(HtmlDataTable dtConsultas) {
        this.dtConsultas = dtConsultas;
    }

    public HtmlDataTable getDtConsultas() {
        return dtConsultas;
    }


    /**
     * @return
     */
    public String atenderUsuario() {

        datosUsuarioVph = 
                (DatosUsuarioVphBean)FacesUtils.getManagedBean("datosUsuarioVphBean");

        FacesUtils.resetManagedBean("menuTomaVphBean");
       
        this.consultaClone = (Cnconsclin)this.dtConsultas.getRowData();

        Chusuario usuario;
        usuario = null;
        try {
            usuario = 
                    this.getServiceLocator().getClinicoService().getUsuario(consultaClone.getCcolusuario().getHuslnumero());

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (consultaClone.getCcocservic() != null) {
            servicio = consultaClone.getCcocservic();
        }
            datosUsuarioVph.setDepartamentoSelect(usuario.getHusndepartamen().toString());
            datosUsuarioVph.setCiudad(usuario.getHusnciudad().toString());
            datosUsuarioVph.setConsulta(consultaClone);
            datosUsuarioVph.setUsuario(usuario);
            if (usuario.getHusdfechanacim() != null) {
                edad = calcularEdad(usuario.getHusdfechanacim(), new Date());
                datosUsuarioVph.setEdad(edad);
                datosUsuarioVph.setFechaNacimiento(usuario.getHusdfechanacim());
            }


            if (servicio != null) {
                datosUsuarioVph.setServicio(servicio);
            }


            if (usuario.getHusnocupacion() != null) {
                datosUsuarioVph.setOcupacionSelect(usuario.getHusnocupacion().toString());
            }

            datosUsuarioVph.inicializarDatosUsuario();


       

        return BeanNavegacion.RUTA_IR_DATOS_VPH;

    }



    public void changeConsultas() {
        if (fechaActual != null && getClinica() != null) {

            try {
                this.lstUsuarios = 
                        this.serviceLocator.getClinicoService().getVPHDia(fechaActual, 
                                                                                 getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();

            }
        }
    }

}
