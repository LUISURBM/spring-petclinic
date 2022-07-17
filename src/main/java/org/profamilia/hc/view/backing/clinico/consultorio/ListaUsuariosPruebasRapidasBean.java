 //=======================================================================
 // ARCHIVO ListaUsuariosBean
 // FECHA CREACI�N: 30/10/2008
 // AUTOR: jariano, nliz
 // Descripcion: Permite visualizar la lista de usuarios por medico 
 // para un Usuario de una Historia Clinica 
 //=======================================================================
 package org.profamilia.hc.view.backing.clinico.consultorio;
 //=======================================================================
 //  BIBLIOTECAS REQUERIDAS
 //=======================================================================
 import java.text.SimpleDateFormat;

 import java.util.ArrayList;
 import java.util.Date;
 import java.util.List;

 import java.util.StringTokenizer;

 import javax.faces.component.UIInput;
 import javax.faces.component.html.HtmlDataTable;
 import javax.faces.event.ValueChangeEvent;

import javax.swing.JOptionPane;

import org.profamilia.hc.model.dto.Agendamiento;
import org.profamilia.hc.model.dto.Cfdetaadmision;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chmedicament;
import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.Chusuario;
 import org.profamilia.hc.model.dto.Cnconsclin;
 import org.profamilia.hc.model.dto.Cpservicio;
 import org.profamilia.hc.model.exceptions.ModelException;
 import org.profamilia.hc.view.backing.BaseBean;
 import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.PruebasRapidasBean;
import org.profamilia.hc.view.backing.comun.conducta.VademecumMedicoBean;
 import org.profamilia.hc.view.backing.menus.consultorio.MenuProcedimientoConsultorioBean;
 import org.profamilia.hc.view.backing.menus.consultorio.MenuProcedimientoIveBean;
import org.profamilia.hc.view.backing.procedimiento.AntecedentesColposcopiaBean;
import org.profamilia.hc.view.backing.procedimiento.DatosUsuarioCitologiaBean;
 import org.profamilia.hc.view.constantes.IConstantes;
 import org.profamilia.hc.view.util.FacesUtils;

 //=======================================================================
 //  CLASE
 //=======================================================================

 public class ListaUsuariosPruebasRapidasBean extends BaseBean {

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

     /**Variable que almacena el tipo de servicio de la consulta */
     private Cpservicio servicio;

     /** Clone de Consulta */
     private Cnconsclin consultaClone;

     /**Clone de agendaClone    */
     private Agendamiento agendaClone;

     /** Almacena la edad del usuario*/
     private Integer edad;

     /** Almacena el mensaje si no encuentra registros**/
     private String msg_sin_registros;

     /** Menu de Administracion*/
     private List menuAdmin;

     /** Menu de Historias */

     /** Ruta de Navegaci�n */
     private String rutaNavegacion;

     private HtmlDataTable dtMisConsultas;

     private HtmlDataTable dtlstMisConsultasAgendadas;

     private List<Cnconsclin> lstMisConsultas;

     private List<Agendamiento> lstMisConsultasAgendadas;

     private boolean tieneConsulta = false;

     /** Consulta para agendamiento */
     private Cnconsclin consultaAgenda;
     
     private String numeroIdentificacion;
     
     private boolean busquedaXCedula;
     
     private PruebasRapidasBean pruebasRapidasBean;

    private Chusuario usuario;
    
    private List<Cnconsclin>lstPruebasRapidas; 
    
    private HtmlDataTable dtLstServicios;
    
    private List<Cfdetaadmision> listaSeleccionados;

     //-----------------------------------------------------------------------
     //  METODO CONSTRUCTOR
     //-----------------------------------------------------------------------

     public ListaUsuariosPruebasRapidasBean() {
     }

     public void init() {
         lstUsuarios = new ArrayList<Cnconsclin>();
         lstMisConsultas = new ArrayList<Cnconsclin>();
         dtConsultas = new HtmlDataTable();
         dtMisConsultas = new HtmlDataTable();
         dtlstMisConsultasAgendadas = new HtmlDataTable();
         msg_sin_registros = IConstantes.MSG_SIN_CONSULTAR;
         numeroIdentificacion = null;
         busquedaXCedula=false;
     }


     // ACTIONS BEAN

     /**
     * @return
     */
    public String atenderMisConsultas() {
       
            FacesUtils.resetManagedBean("pruebasRapidasBean");
            FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
            FacesUtils.resetManagedBean("menuPruebasRapidasBean");
        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

        this.consultaClone = (Cnconsclin)this.dtlstMisConsultasAgendadas.getRowData();
        usuario = null;

        try {
            usuario = 
                    this.getServiceLocator().getClinicoService().getUsuario(consultaClone.getCcolusuario().getHuslnumero());
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }

        if (consultaClone.getCcocservic() != null) {
            servicio = consultaClone.getCcocservic();
            
        }
        
        lstPruebasRapidas = null;
        if(consultaClone != null && consultaClone.getCcontipdoc() != null && consultaClone.getCcontipdoc().getCtdnnumero()!= null && consultaClone.getCconnumdoc()!= null ){
           try {
              lstPruebasRapidas = serviceLocator.getClinicoService().getConsultasPruebasRapidasXFactura(consultaClone.getCcontipdoc().getCtdnnumero(), consultaClone.getCconnumdoc());
           } catch (ModelException e) {
              return capturaError(e,IConstantes.ERROR_COSNULTA);
           }
        }
        
        if (usuario != null) {
            if(datosUsuario !=null){
                List<Cnconsclin> lstPruebasAux = new ArrayList<Cnconsclin>();
                for (Cnconsclin cons : lstPruebasRapidas) {
                    if (cons.isItemSelect()) {
                        lstPruebasAux.add(cons);
                    }
                }
                datosUsuario.setLstConsultas(lstPruebasAux);
            }
            
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
        
        return navegacionAtenderMisConsultas(usuario);
//           navegacionAtenderMisConsultas(usuario);
//        return rutaNavegacion;
        
        }
    
    public String atenderUsuario() {
        FacesUtils.resetManagedBean("pruebasRapidasBean");
        FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
        FacesUtils.resetManagedBean("menuPruebasRapidasBean");
        this.consultaClone = (Cnconsclin)this.dtConsultas.getRowData();

        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

        usuario = null;
        try {
            usuario = 
                    this.getServiceLocator().getClinicoService().getUsuario(consultaClone.getCcolusuario().getHuslnumero());
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }
        
        lstPruebasRapidas = null;
        if(consultaClone != null && consultaClone.getCcontipdoc() != null && consultaClone.getCcontipdoc().getCtdnnumero()!= null && consultaClone.getCconnumdoc()!= null ){
            try {
                lstPruebasRapidas = serviceLocator.getClinicoService().getConsultasPruebasRapidasXFactura(consultaClone.getCcontipdoc().getCtdnnumero(), consultaClone.getCconnumdoc());
            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }
        }
        if(usuario != null){
            datosUsuario.setUsuario(usuario);
            datosUsuario.setConsulta(consultaClone);
            List<Cnconsclin> lstPruebasAux = new ArrayList<Cnconsclin>();
            for (Cnconsclin cons : lstPruebasRapidas) {
                if (cons.isItemSelect()) {
                    lstPruebasAux.add(cons);
                }
            }
            
            datosUsuario.setLstConsultas(lstPruebasAux);
            if (usuario.getHusdfechanacim() != null) {
                edad = calcularEdad(usuario.getHusdfechanacim(), new Date());
                datosUsuario.setEdad(edad);
            }
        }

        if (servicio != null) {
            datosUsuario.setServicio(servicio);
        }

        if (consultaClone.getCcocservic() != null) {
            servicio = consultaClone.getCcocservic();
        }
        datosUsuario.inicializarUsuario();
        
//        return BeanNavegacion.RUTA_IR_DATOS_USUARIO_PRUEBAS_RAPIDAS;

        return BeanNavegacion.RUTA_IR_DATOS_PRUEBAS_RAPIDAS_SELECCION;

    }

    private String navegacionAtenderMisConsultas(Chusuario usuario) {

        List<Cnconsclin>lstPruebasRapidas = null;
        if(consultaClone != null && consultaClone.getCcontipdoc() != null && consultaClone.getCcontipdoc().getCtdnnumero()!= null && consultaClone.getCconnumdoc()!= null ){
            try {
                lstPruebasRapidas = serviceLocator.getClinicoService().getConsultasPruebasRapidasXFactura(consultaClone.getCcontipdoc().getCtdnnumero(), consultaClone.getCconnumdoc());
            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }
        }
        if(lstPruebasRapidas !=null && !lstPruebasRapidas.isEmpty()){
            consultaClone = lstPruebasRapidas.get(0);
        }
     
        DatosBasicosUsuarioBean datosBasicosUsuario = 
            (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

        if (usuario != null) {
            datosBasicosUsuario.setUsuario(usuario);
            datosBasicosUsuario.setConsulta(consultaClone);
            List<Cnconsclin> lstPruebasAux = new ArrayList<Cnconsclin>();
            for (Cnconsclin cons : lstPruebasRapidas) {
                if (cons.isItemSelect()) {
                    lstPruebasAux.add(cons);
                }
            }
            datosBasicosUsuario.setLstConsultas(lstPruebasAux);
            datosBasicosUsuario.inicializarUsuario();
        }
            
         FacesUtils.resetManagedBean("menuPruebasRapidasBean");
//        rutaNavegacion =BeanNavegacion.RUTA_IR_DATOS_USUARIO_PRUEBAS_RAPIDAS;
        return BeanNavegacion.RUTA_IR_DATOS_PRUEBAS_RAPIDAS_SELECCION;

    }

     public String atenderUsuario2() {
         this.consultaClone = (Cnconsclin)this.dtConsultas.getRowData();
         usuario = null;
         try {
             usuario = 
                     this.getServiceLocator().getClinicoService().getUsuario(consultaClone.getCcolusuario().getHuslnumero());
         } catch (ModelException e) {
             return capturaError(e,IConstantes.ERROR_COSNULTA);
         }

         FacesUtils.resetManagedBean("pruebasRapidasBean");
         pruebasRapidasBean = 
                 (PruebasRapidasBean)FacesUtils.getManagedBean("pruebasRapidasBean");
                 
         pruebasRapidasBean.setConsulta(consultaClone);
         pruebasRapidasBean.setUsuario(usuario);
         pruebasRapidasBean.init();

         rutaNavegacion = BeanNavegacion.RUTA_IR_PRUEBAS_RAPIDAS;
         
         return rutaNavegacion;
     }

    private void navegacionAtenderUsuario(Chusuario usuario) {
            FacesUtils.resetManagedBean("pruebasRapidasBean");
            pruebasRapidasBean = 
                    (PruebasRapidasBean)FacesUtils.getManagedBean("pruebasRapidasBean");
                    
            pruebasRapidasBean.setConsulta(consultaClone);        
            pruebasRapidasBean.init();

            rutaNavegacion = BeanNavegacion.RUTA_IR_PRUEBAS_RAPIDAS;

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


    public List<Chtiempaten> validacionConsultasAbiertasDelDiaXMedico(){
        List<Chtiempaten> chtiempatenList = new ArrayList<Chtiempaten>();
        try {
            chtiempatenList = getServiceLocator().getClinicoService().validacionConsultasAbiertasDelDiaXMedico(Integer.parseInt(getUsuarioSystem().getCurnprofes().toString()));
        } catch (ModelException e) {
            e.printStackTrace();
        }     
        return chtiempatenList;   
    }
    
     public String changeConsultas() {
         if (fechaActual != null && getClinica() != null) {
             busquedaXCedula=true;
             if("".equals(numeroIdentificacion)){
                 numeroIdentificacion=null;
             }
             try {
             if(numeroIdentificacion == null){
                 //this.lstUsuarios = 
                         //this.serviceLocator.getClinicoService().getConsultasDiaPruebasRapidas(fechaActual, 
                                                                                 //getClinica().getCclncodigo(), 
                                                                                 //getUsuarioSystem().getCurnprofes(),null);
                 this.lstUsuarios = 
                         this.serviceLocator.getClinicoService().getConsultasDiaPruebasRapidas(fechaActual, 
                                                                                 getClinica().getCclncodigo(), 
                                                                                 getUsuarioSystem().getCurnprofes(),null);
                 this.lstMisConsultas = 
                         this.serviceLocator.getClinicoService().getMisConsultasDiaPruebasRapidas(fechaActual, 
                                                                                 getClinica().getCclncodigo(), 
                                                                                 getUsuarioSystem().getCurnprofes(),null);

             }else{
                 this.lstUsuarios = 
                         this.serviceLocator.getClinicoService().getConsultasDiaPruebasRapidas(fechaActual,getClinica().getCclncodigo(), 
                                                                                 getUsuarioSystem().getCurnprofes(),numeroIdentificacion); 
                                                                                 
                 this.lstMisConsultas = 
                         this.serviceLocator.getClinicoService().getMisConsultasDiaPruebasRapidas(fechaActual,getClinica().getCclncodigo(), 
                                                                                 getUsuarioSystem().getCurnprofes(),numeroIdentificacion);                                                                                                                                
                 numeroIdentificacion=null;
             }
             
            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }
         }
         return null;
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


     /**
      * @param dtMisConsultas
      */
     public void setDtMisConsultas(HtmlDataTable dtMisConsultas) {
         this.dtMisConsultas = dtMisConsultas;
     }

     /**
      * @return
      */
     public HtmlDataTable getDtMisConsultas() {
         return dtMisConsultas;
     }

     /**
      * @param lstMisConsultas
      */
     public void setLstMisConsultas(List<Cnconsclin> lstMisConsultas) {
         this.lstMisConsultas = lstMisConsultas;
     }

     /**
      * @return
      */
     public List<Cnconsclin> getLstMisConsultas() {
         return lstMisConsultas;
     }

     public void setDtlstMisConsultasAgendadas(HtmlDataTable dtlstMisConsultasAgendadas) {
         this.dtlstMisConsultasAgendadas = dtlstMisConsultasAgendadas;
     }

     public HtmlDataTable getDtlstMisConsultasAgendadas() {
         return dtlstMisConsultasAgendadas;
     }

     public void setLstMisConsultasAgendadas(List<Agendamiento> lstMisConsultasAgendadas) {
         this.lstMisConsultasAgendadas = lstMisConsultasAgendadas;
     }

     public List<Agendamiento> getLstMisConsultasAgendadas() {
         return lstMisConsultasAgendadas;
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
    
    public String siguienteSeleccion() {
        if (lstPruebasRapidas != null) {
            FacesUtils.resetManagedBean("menuPruebasRapidasBean");
            DatosBasicosUsuarioBean datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
            List<Cnconsclin> lstPruebasAux = new ArrayList<Cnconsclin>();
            for (Cnconsclin cons : lstPruebasRapidas) {
                if (cons.isItemSelect()) {
                    lstPruebasAux.add(cons);
                }
            }
            if (usuario != null) {
                datosBasicosUsuario.setUsuario(usuario);
                datosBasicosUsuario.setConsulta(consultaClone);
                datosBasicosUsuario.setLstConsultas(lstPruebasAux);
                datosBasicosUsuario.inicializarUsuario();
            }

            FacesUtils.resetManagedBean("pruebasRapidasBean");
            pruebasRapidasBean = 
                    (PruebasRapidasBean)FacesUtils.getManagedBean("pruebasRapidasBean");
            pruebasRapidasBean.setConsulta(consultaClone);
            pruebasRapidasBean.setUsuario(usuario);
            pruebasRapidasBean.init();
            pruebasRapidasBean.setLstPruebasRapidas(lstPruebasAux);

            rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_USUARIO_PRUEBAS_RAPIDAS;
        }

        return rutaNavegacion;
    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }


    public void setLstPruebasRapidas(List<Cnconsclin> lstPruebasRapidas) {
        this.lstPruebasRapidas = lstPruebasRapidas;
    }

    public List<Cnconsclin> getLstPruebasRapidas() {
        return lstPruebasRapidas;
    }
    
    public void setDtLstServicios(HtmlDataTable dtLstServicios) {
        this.dtLstServicios = dtLstServicios;
    }

    public HtmlDataTable getDtLstServicios() {
        return dtLstServicios;
    }


    public void setListaSeleccionados(List<Cfdetaadmision> listaSeleccionados) {
        this.listaSeleccionados = listaSeleccionados;
    }

    public List<Cfdetaadmision> getListaSeleccionados() {
        return listaSeleccionados;
    }

}
