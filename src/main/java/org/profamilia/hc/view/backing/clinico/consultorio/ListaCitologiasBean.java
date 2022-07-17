//=======================================================================
// ARCHIVO ListaUsuariosBean
// FECHA CREACI�N: 30/10/2008
// AUTOR: jariano, nliz
// Descripcion: Permite visualizar la lista de usuarios por medico 
// para un Usuario de una Histroia Clinica 
//=======================================================================
package org.profamilia.hc.view.backing.clinico.consultorio;

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
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.procedimiento.DatosUsuarioCitologiaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE
//=======================================================================

public class ListaCitologiasBean extends BaseBean {

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
    DatosUsuarioCitologiaBean datosUsuarioCitologia;

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
    
    private boolean busquedaXCedula;
    
    private String numeroIdentificacion;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ListaCitologiasBean() {

    }


    public void init() {
        lstUsuarios = new ArrayList();
        busquedaXCedula=false;
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
                        IConstantes.NO_EXISTEN_CITOLOGIAS_PARA_LA_FECHA + 
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


        DatosBasicosUsuarioBean datosBasicosUsuarioBean;

        datosUsuarioCitologia = 
                (DatosUsuarioCitologiaBean)FacesUtils.getManagedBean("datosUsuarioCitologiaBean");

        FacesUtils.resetManagedBean("menuTomaCitologiaBean");
        FacesUtils.resetManagedBean("cuestionarioCovidBean");
       
        this.consultaClone = (Cnconsclin)this.dtConsultas.getRowData();
        
        datosBasicosUsuarioBean = (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

        Chusuario usuario;
        usuario = null;
        try {
            usuario = 
                    this.getServiceLocator().getClinicoService().getUsuario(consultaClone.getCcolusuario().getHuslnumero());

        } catch (ModelException e) {
            e.printStackTrace();
        }
        
        
        if(usuario != null){
            datosBasicosUsuarioBean.setUsuario(usuario);
            datosBasicosUsuarioBean.mensaje();
        }
        

        if (consultaClone.getCcocservic() != null) {
            servicio = consultaClone.getCcocservic();
        }
            datosUsuarioCitologia.setDepartamentoSelect(usuario.getHusndepartamen().toString());
            datosUsuarioCitologia.setCiudad(usuario.getHusnciudad().toString());
            datosUsuarioCitologia.setConsulta(consultaClone);
            datosUsuarioCitologia.setUsuario(usuario);
            if (usuario.getHusdfechanacim() != null) {
                edad = calcularEdad(usuario.getHusdfechanacim(), new Date());
                datosUsuarioCitologia.setEdad(edad);
                datosUsuarioCitologia.setFechaNacimiento(usuario.getHusdfechanacim());
            }


            if (servicio != null) {
                datosUsuarioCitologia.setServicio(servicio);
            }


            if (usuario.getHusnocupacion() != null) {
                datosUsuarioCitologia.setOcupacionSelect(usuario.getHusnocupacion().toString());
            }

            datosUsuarioCitologia.inicializarDatosUsuario();


       

        return BeanNavegacion.RUTA_IR_DATOS_CITOLOGIA;

    }

    /**
     * @return
     */
    public String aceptar() {
        List listServicio = null;

        try {
            listServicio = 
                    this.serviceLocator.getClinicoService().getListServicio();
        } catch (ModelException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void changeConsultas() {
        if ((fechaActual != null || numeroIdentificacion!=null) && getClinica() != null) {
            busquedaXCedula=true;
            if("".equals(numeroIdentificacion)){
                numeroIdentificacion=null;
            }
            
            try {
                this.lstUsuarios = 
                        this.serviceLocator.getClinicoService().getCitologiasDia(fechaActual, 
                                                                                 getClinica().getCclncodigo(),numeroIdentificacion);
            } catch (ModelException e) {
                e.printStackTrace();

            }
        }
    }

    public void setBusquedaXCedula(boolean busquedaXCedula) {
        this.busquedaXCedula = busquedaXCedula;
    }

    public boolean isBusquedaXCedula() {
        return busquedaXCedula;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }
}
