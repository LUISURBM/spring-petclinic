//=======================================================================
// ARCHIVO ListaVacunacionBean
// FECHA CREACI�N: 30/10/2008
// AUTOR: jariano, nliz
// Descripcion: Permite visualizar la lista de usuarios para vacunacion 
// para un Usuario de una Historia Clinica 
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
import org.profamilia.hc.view.constantes.IConstantes;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================
 import org.profamilia.hc.view.util.FacesUtils;

//=======================================================================
//  CLASE ListaVacunacionBean.java
//=======================================================================
public class ListaVacunacionBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    /** Fecha presente */
    private Date fechaActual;


    /** Lista de Usuarios */
    private List<Cnconsclin> lstUsuarios;

    /** Almacena el usuario  */
    private String usuarioSelect;

    /** Almacena el Bean de Datos de Usuario*/
    DatosBasicosUsuarioBean datosUsuario;
    
    /** Almacena true si existen consultas para el dia */
    private boolean existeConsulta;

    /** Almacena el componente tabla  */
    private HtmlDataTable dtConsultas;


    /**Variable que almacena el tipo de servicio de la consulta */
    private Cpservicio servicio;
    
    /** Clone de Consulta */
    private Cnconsclin consultaClone;

    /** Almacena la edad del usuario*/
    private Integer edad;

    /** Almacena el mensaje si no encuentra registros**/
    private String msg_sin_registros;

    /** Menu de Administracion*/
    private List menuAdmin;

    /** Menu de Historias */

    /** Ruta de Navegaci�n */
    private String rutaNavegacion;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------


    // ACTIONS BEAN

    public ListaVacunacionBean() {
    }
    
    public void init(){
        lstUsuarios = new ArrayList<Cnconsclin>();
        msg_sin_registros = IConstantes.MSG_SIN_CONSULTAR;
    }
    
    // ACTIONS BEAN

    public String atenderUsuario() {


        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
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

 

            if (usuario != null) {
                datosUsuario.setUsuario(usuario);
                
                datosUsuario.setConsulta(consultaClone);

                if (usuario.getHusdfechanacim() != null) {
                    edad = calcularEdad(usuario.getHusdfechanacim(), new Date());
                    datosUsuario.setEdad(edad);
                 
                }

                if (servicio != null) {
                    datosUsuario.setServicio(servicio);
                }

                
            }
            
        DatosBasicosUsuarioBean datosBasicosUsuario = 
            (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        
         if (usuario != null) {
            datosBasicosUsuario.setUsuario(usuario);
            datosBasicosUsuario.setConsulta(consultaClone);
            datosBasicosUsuario.setServicio(servicio);
            datosBasicosUsuario.inicializarUsuario();
        }

       


        if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CERVIX_VACUNACION)) {

            FacesUtils.resetManagedBean("menuHistoriaVacunacionCervixBean");
            rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_VACUNACION_CERVIX;
        } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_VACUNACION)) {

            FacesUtils.resetManagedBean("menuHistoriaVacunacionBean");
          

            rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_VACUNACION_NORMAL;
        }



        else {
            rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
            FacesUtils.addErrorMessage(ERROR_SERICIO_NO_ASOCIADO);
        }


        return rutaNavegacion;

    }
    
    public void changeConsultas() {
        if (fechaActual != null && getClinica() != null) {
            try {
                this.lstUsuarios = 
                        this.serviceLocator.getClinicoService().getConsultasVacunacionDia(fechaActual, 
                                                                                getClinica().getCclncodigo(), 
                                                                                getUsuarioSystem().getCurnprofes());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
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
    public void setLstUsuarios(List<Cnconsclin> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    /**
     * @return
     */
    public List<Cnconsclin> getLstUsuarios() {
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
     * @param dtConsultas
     */
    public void setDtConsultas(HtmlDataTable dtConsultas) {
        this.dtConsultas = dtConsultas;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtConsultas() {
        return dtConsultas;
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
     * @param consultaClone
     */
    public void setConsultaClone(Cnconsclin consultaClone) {
        this.consultaClone = consultaClone;
    }

    /**
     * @return
     */
    public Cnconsclin getConsultaClone() {
        return consultaClone;
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
     * @param rutaNavegacion
     */
    public void setRutaNavegacion(String rutaNavegacion) {
        this.rutaNavegacion = rutaNavegacion;
    }

    /**
     * @return
     */
    public String getRutaNavegacion() {
        return rutaNavegacion;
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
                        IConstantes.NO_EXISTEN_CONSULTAS_PARA_LA_FECHA + 
                        fechaCons;
            }
        }
        return existeConsulta;
        }
}
