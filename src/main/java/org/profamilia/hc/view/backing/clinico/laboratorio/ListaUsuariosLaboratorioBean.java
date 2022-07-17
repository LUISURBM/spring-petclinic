//=======================================================================
// ARCHIVO ListaUsuariosLaboratorioBean
// FECHA CREACI�N: 30/03/2020
// AUTOR: jariano
// Descripcion: Permite visualizar la lista de usuarios por laboratorio  
//=======================================================================
package org.profamilia.hc.view.backing.clinico.laboratorio;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;

import org.profamilia.hc.model.dto.Agendamiento;
import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE
//=======================================================================

public class ListaUsuariosLaboratorioBean extends BaseBean {

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
    boolean existeConsulta;

    /** Almacena el componente tabla  */
    private HtmlDataTable dtConsultas;

    /** Clone de Consulta */
    private Cnconsclin consultaClone;


    /** Almacena el mensaje si no encuentra registros**/
    private String msg_sin_registros;

    /** Menu de Administracion*/
    private List menuAdmin;

    /** Menu de Historias */

    /** Ruta de Navegaci�n */
    private String rutaNavegacion;



    private String numeroIdentificacion;

    private boolean busquedaXCedula;
    

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ListaUsuariosLaboratorioBean() {
    }

    public void init() {
        lstUsuarios = new ArrayList<Cnconsclin>();
        dtConsultas = new HtmlDataTable();
        
        msg_sin_registros = IConstantes.MSG_SIN_CONSULTAR;
        numeroIdentificacion = null;
        busquedaXCedula = false;
    }


    // ACTIONS BEAN


    public String atenderUsuario() {
        rutaNavegacion = "";
        
        Integer edad = 0;

        this.consultaClone = (Cnconsclin)this.dtConsultas.getRowData();
        
        datosUsuario = 
                         (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
                         
        Chusuario usuario;
                 usuario = null;
                 
                 try {
                     usuario = 
                             this.getServiceLocator().getClinicoService().getUsuario(consultaClone.getCcolusuario().getHuslnumero());

                 } catch (ModelException e) {
                     return capturaError(e,IConstantes.ERROR_COSNULTA);
                 }
                 
        if (usuario != null) {
                   datosUsuario.setUsuario(usuario);
                   datosUsuario.setConsulta(consultaClone);

                   if (usuario.getHusdfechanacim() != null) {
                       edad = calcularEdad(usuario.getHusdfechanacim(), new Date());
                       datosUsuario.setEdad(edad);

                   }

               }
        
        RegistrarLaboratorioBean laboratorio = (RegistrarLaboratorioBean)FacesUtils.getManagedBean("registrarLaboratorioBean");
        
        if(laboratorio != null){
            laboratorio.setConsulta(consultaClone);
            laboratorio.init();
            rutaNavegacion = BeanNavegacion.RUTA_REGISTRAR_LABORATORIO;
        }
              
        return rutaNavegacion;
    }

 
    public String aceptar() {
        List listServicio = null;
        try {
            listServicio = 
                    this.serviceLocator.getClinicoService().getListServicio();
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }
        return null;
    }


    public String changeConsultas() {
        if (fechaActual != null && getClinica() != null) {
            busquedaXCedula = true;
           
            
            numeroIdentificacion = null;
            lstUsuarios  = new ArrayList<Cnconsclin>();
           
            try {
              
                    this.lstUsuarios = 
                            this.serviceLocator.getClinicoService().getConsultasDiaLaboratorio(fechaActual, 
                                                                                    getClinica().getCclncodigo(), 
                                                                                    getUsuarioSystem().getCurnprofes(),null);

                


            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }
        }
        return null;
    }
    
    
    
    public String changeConsultasNumeroIdentificacion() {
        if (fechaActual != null && getClinica() != null) {
            busquedaXCedula = true;
           
            if("".equals(numeroIdentificacion)){
                numeroIdentificacion=null;
            }
            
            lstUsuarios  = new ArrayList<Cnconsclin>();
           
            try {
              
                    this.lstUsuarios = 
                            this.serviceLocator.getClinicoService().getConsultasDiaLaboratorio(fechaActual, 
                                                                                    getClinica().getCclncodigo(), 
                                                                                    getUsuarioSystem().getCurnprofes(),numeroIdentificacion);

                


            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }
        }
        return null;
    }


    private void resetLaboratorios() {
        FacesUtils.resetManagedBean("datosBasicosUsuarioBean");

    }


    // ACCESSORS BEAN

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
                        IConstantes.NO_EXISTEN_CONSULTAS_PARA_LA_FECHA + 
                        fechaCons;
            }
        }
        return existeConsulta;
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


    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setBusquedaXCedula(boolean busquedaXCedula) {
        this.busquedaXCedula = busquedaXCedula;
    }

    public boolean isBusquedaXCedula() {
        return busquedaXCedula;
    }

}
