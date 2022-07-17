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

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;

import org.profamilia.hc.model.dto.Agendamiento;
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
//  CLASE
//=======================================================================

public class ListaUsuariosEnfermeriaBean extends BaseBean {

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

    /** Almacena el Bean de Datos de Usuario*/
    DatosUsuarioCitologiaBean datosUsuarioCitologia;
    
    private List<Cnconsclin> lstMisConsultas; 

    /** Almacena true si existen consultas para el dia */
    boolean existeConsulta;

    /** Almacena el componente tabla  */
    private HtmlDataTable dtConsultas;
    
    private HtmlDataTable dtMisConsultas; 

    private HtmlDataTable dtlstMisConsultasAgendadas;

    private List<Agendamiento> lstMisConsultasAgendadas;

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

    private boolean tieneConsulta = false;

    private boolean busquedaXCedula; 
    
    private String numeroIdentificacion;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ListaUsuariosEnfermeriaBean() {
    }

    public void init() {
        lstUsuarios = new ArrayList<Cnconsclin>();
        msg_sin_registros = IConstantes.MSG_SIN_CONSULTAR;
        dtMisConsultas = new HtmlDataTable(); 
        dtlstMisConsultasAgendadas = new HtmlDataTable();
        busquedaXCedula=false;
    }

    // ACTIONS BEAN
    
    public String atenderMisConsultas() {
         Long codigoAgenda = null;
         datosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
         datosUsuarioCitologia = 
                 (DatosUsuarioCitologiaBean)FacesUtils.getManagedBean("datosUsuarioCitologiaBean");
         this.consultaClone = (Cnconsclin)this.dtMisConsultas.getRowData();
         Chusuario usuario;
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

         try {
            Agendamiento agendaUsuario = 
                   this.getServiceLocator().getClinicoService().getPrimerAgendaUsuarioServicioFecha(fechaActual, 
                        consultaClone.getCconclinic(), servicio.getCsvntipage(),usuario.getHuslnumero());
             
            if (agendaUsuario != null && agendaUsuario.getId() != null) {
                agendaUsuario.setConsulta_cln(consultaClone.getCconnumero().longValue());
                this.serviceLocator.getClinicoService().updateConsultaClinicaAgendamiento(agendaUsuario);
                codigoAgenda = agendaUsuario.getId().longValue();
            }
                   
         } catch (ModelException e) {
             return capturaError(e,IConstantes.ERROR_COSNULTA);
         }
         navegacionAtenderMisConsultas(usuario, codigoAgenda);
         return rutaNavegacion;
    }


    private String navegacionAtenderMisConsultas(Chusuario usuario, Long codigoAgenda) {
         if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA)) {
             datosUsuarioCitologia.setDepartamentoSelect(usuario.getHusndepartamen().toString());
             datosUsuarioCitologia.setCiudad(usuario.getHusnciudad().toString());
             datosUsuarioCitologia.setConsulta(consultaClone);
             datosUsuarioCitologia.setCodigoAgenda(codigoAgenda);
             datosUsuarioCitologia.setUsuario(usuario);
             datosUsuarioCitologia.init();
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

         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PRENATAL)) {
             resetExamenPrenatal();
             FacesUtils.resetManagedBean("menuHistoriaNuevoPrenatalEnfermeriaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_NUEVO_PRENATAL_ENFERMERIA;
         } else {
             if (usuario != null) {
                 datosUsuario.setUsuario(usuario);
                 datosUsuario.setConsulta(consultaClone);
                 datosUsuario.setCodigoAgenda(codigoAgenda);

                 if (usuario.getHusdfechanacim() != null) {
                     edad = calcularEdad(usuario.getHusdfechanacim(), new Date());
                     datosUsuario.setEdad(edad);
                 }

                 if (servicio != null) {
                     datosUsuario.setServicio(servicio);
                 }
             }
         }

         if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_TEMPORAL)) {
               resetAnticoncepcionTemporal();
               FacesUtils.resetManagedBean("menuHistoriaAnticoncepcionEnfermeriaBean");
               DatosBasicosUsuarioBean datosBasicosUsuario = 
                   (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

               if (usuario != null) {
                   datosBasicosUsuario.setUsuario(usuario);
                   datosBasicosUsuario.setConsulta(consultaClone);
                   datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                   datosBasicosUsuario.inicializarUsuario();
               }

               rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ANTICONCEPCION_ENFERMERIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_ANTICONCEPCION_TEMPORAL)) {
             resetAnticoncepcionTemporal();
             FacesUtils.resetManagedBean("menuHistoriaControlAnticoncepcionEnfermeriaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = 
                     BeanNavegacion.RUTA_IR_DATOS_CONTROL_ANTICONCEPCION_ENFERMERIA;
         }else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PRENATAL)) {
             resetExamenPrenatal();
             FacesUtils.resetManagedBean("menuHistoriaNuevoPrenatalEnfermeriaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_NUEVO_PRENATAL_ENFERMERIA;
         } else if(servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_INSERCION)){
             resetAnticoncepcionTemporal(); 
             FacesUtils.resetManagedBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
                      
             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ANTICONCEPCION_ENFERMERIA_INSERCION;
         } else if(servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ENTREGA_RESULTADO)){
             resetAnticoncepcionTemporal(); 
             FacesUtils.resetManagedBean("menuHistoriaEntregaResultadosEnfermeriaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
                      
             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ENTREGA_RESULTADOS_ENFERMERIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_RETIRO)) {
            resetAnticoncepcionTemporal();
            FacesUtils.resetManagedBean("menuHistoriaAnticoncepcionEnfermeriaRetiro");
            DatosBasicosUsuarioBean datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

            List<Object[]> resultList = null;

            if (usuario != null) {
                datosBasicosUsuario.setUsuario(usuario);
                datosBasicosUsuario.setConsulta(consultaClone);
                datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                datosBasicosUsuario.inicializarUsuario();
                try {
                    resultList = 
                            getServiceLocator().getClinicoService().getListaServiciosValidacionRetiro(consultaClone.getCconnumdoc().longValue(), 
                                                                                                         consultaClone.getCcocservic().getCsvccodigo());
                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_COSNULTA);
                }
            }
            if (resultList == null || resultList.isEmpty()) {
                rutaNavegacion = 
                        BeanNavegacion.RUTA_IR_DATOS_ANTICONCEPCION_ENFERMERIA_RETIRO;
            } else {
                FacesUtils.addInfoMessage("Por favor realizar el registro por el servicio de consulta o inserci�n.");
            }
        } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL)) {
             resetControl();
             FacesUtils.resetManagedBean("menuControlBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL_ENFERMERIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_EFECTO_JOVEN)) {
             resetControl();
             FacesUtils.resetManagedBean("menuHistoriaEfectoJoven");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_EFECTO_JOVEN;
         } else {
             rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
             FacesUtils.addErrorMessage(ERROR_SERICIO_NO_HABILITADO);
         }
         return null;
//         return rutaNavegacion;
     }

    public String atenderMisConsultasAgendadas() {
        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        datosUsuarioCitologia = 
                (DatosUsuarioCitologiaBean)FacesUtils.getManagedBean("datosUsuarioCitologiaBean");

        this.agendaClone = 
                (Agendamiento)this.dtlstMisConsultasAgendadas.getRowData();
        Chusuario usuario;
        usuario = null;
        Long codigoAgenda = agendaClone.getId().longValue();
        
        try {
/*            consultaAgenda = 
                    this.serviceLocator.getClinicoService().getConsultaFechaUsuario(agendaClone.getFecha_agenda(), 
                                                                                  agendaClone.getId_sede().intValue(), 
                                                                                  agendaClone.getEspecialidad().getCsvccodigo(), 
                                                                                  agendaClone.getId_paciente().getHuslnumero());
*/
            this.consultaClone = this.serviceLocator.getClinicoService().getConsultaFechaUsuario(agendaClone.getFecha_agenda(), 
                                                                        agendaClone.getId_sede().intValue(), 
                                                                        agendaClone.getEspecialidad().getCsvccodigo(), 
                                                                         agendaClone.getId_paciente().getHuslnumero());
                                                                         
            if (consultaClone.getCconnumero() != null) {
                agendaClone.setConsulta_cln(consultaClone.getCconnumero().longValue());
                this.serviceLocator.getClinicoService().updateConsultaClinicaAgendamiento(agendaClone);
            }
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }

        try {
        if(consultaClone != null && consultaClone.getCcolusuario() != null && consultaClone.getCcolusuario().getHuslnumero() != null ){
            usuario = 
                    this.getServiceLocator().getClinicoService().getUsuario(consultaClone.getCcolusuario().getHuslnumero());
        }
            
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }

        if (agendaClone.getEspecialidad() != null) {
            servicio = agendaClone.getEspecialidad();
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

/*        if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA)) {
            datosUsuarioCitologia.setDepartamentoSelect(usuario.getHusndepartamen().toString());
            datosUsuarioCitologia.setCiudad(usuario.getHusnciudad().toString());
            datosUsuarioCitologia.setConsulta(consultaAgenda);
            datosUsuarioCitologia.setUsuario(usuario);
            datosUsuarioCitologia.init();
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

        } else {
            if (usuario != null) {
                datosUsuario.setUsuario(usuario);
                datosUsuario.setConsulta(consultaAgenda);

                if (usuario.getHusdfechanacim() != null) {
                    edad = calcularEdad(usuario.getHusdfechanacim(), new Date());
                    datosUsuario.setEdad(edad);
                }

                if (servicio != null) {
                    datosUsuario.setServicio(servicio);
                }
            }
        }

        if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_TEMPORAL)) {
              resetAnticoncepcionTemporal();
              FacesUtils.resetManagedBean("menuHistoriaAnticoncepcionEnfermeriaBean");
              DatosBasicosUsuarioBean datosBasicosUsuario = 
                  (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

              if (usuario != null) {
                  datosBasicosUsuario.setUsuario(usuario);
                  datosBasicosUsuario.setConsulta(consultaAgenda);
                  datosBasicosUsuario.inicializarUsuario();
              }

              rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ANTICONCEPCION_ENFERMERIA;
        } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_ANTICONCEPCION_TEMPORAL)) {
            resetAnticoncepcionTemporal();
            FacesUtils.resetManagedBean("menuHistoriaControlAnticoncepcionEnfermeriaBean");
            DatosBasicosUsuarioBean datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
            if (usuario != null) {
                datosBasicosUsuario.setUsuario(usuario);
                datosBasicosUsuario.setConsulta(consultaAgenda);
                datosBasicosUsuario.inicializarUsuario();
            }

            rutaNavegacion = 
                    BeanNavegacion.RUTA_IR_DATOS_CONTROL_ANTICONCEPCION_ENFERMERIA;
        } else if(servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_INSERCION)){
            resetAnticoncepcionTemporal(); 
            FacesUtils.resetManagedBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
            DatosBasicosUsuarioBean datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
                     
            if (usuario != null) {
                datosBasicosUsuario.setUsuario(usuario);
                datosBasicosUsuario.setConsulta(consultaAgenda);
                datosBasicosUsuario.inicializarUsuario();
            }

            rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ANTICONCEPCION_ENFERMERIA_INSERCION;
        } else if(servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_RETIRO)){
            resetAnticoncepcionTemporal(); 
            FacesUtils.resetManagedBean("menuHistoriaAnticoncepcionEnfermeriaRetiro");
            DatosBasicosUsuarioBean datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
                     
            if (usuario != null) {
                datosBasicosUsuario.setUsuario(usuario);
                datosBasicosUsuario.setConsulta(consultaAgenda);
                datosBasicosUsuario.inicializarUsuario();
            }

            rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ANTICONCEPCION_ENFERMERIA_RETIRO;
        } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL)) {
            resetControl();
            FacesUtils.resetManagedBean("menuControlBean");
            DatosBasicosUsuarioBean datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

            if (usuario != null) {
                datosBasicosUsuario.setUsuario(usuario);
                datosBasicosUsuario.setConsulta(consultaAgenda);
                datosBasicosUsuario.inicializarUsuario();
            }

            rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL_ENFERMERIA;
        } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_EFECTO_JOVEN)) {
            resetControl();
            FacesUtils.resetManagedBean("menuHistoriaEfectoJoven");
            DatosBasicosUsuarioBean datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

            if (usuario != null) {
                datosBasicosUsuario.setUsuario(usuario);
                datosBasicosUsuario.setConsulta(consultaAgenda);
                datosBasicosUsuario.inicializarUsuario();
            }

            rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_EFECTO_JOVEN;
        } else {
            rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
            FacesUtils.addErrorMessage(ERROR_SERICIO_NO_HABILITADO);
        }
*/

        navegacionAtenderMisConsultas(usuario,codigoAgenda);
        return rutaNavegacion;
    }

    public String atenderUsuario() {
        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        datosUsuarioCitologia = 
                (DatosUsuarioCitologiaBean)FacesUtils.getManagedBean("datosUsuarioCitologiaBean");
        this.consultaClone = (Cnconsclin)this.dtConsultas.getRowData();
        Chusuario usuario;
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

        if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA)) {
            datosUsuarioCitologia.setDepartamentoSelect(usuario.getHusndepartamen().toString());
            datosUsuarioCitologia.setCiudad(usuario.getHusnciudad().toString());
            datosUsuarioCitologia.setConsulta(consultaClone);
            datosUsuarioCitologia.setUsuario(usuario);
            datosUsuarioCitologia.init();
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
        } else {
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
        }

        if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_TEMPORAL)) {
            resetAnticoncepcionTemporal();
            FacesUtils.resetManagedBean("menuHistoriaAnticoncepcionEnfermeriaBean");
            DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

            if (usuario != null) {
                datosBasicosUsuario.setUsuario(usuario);
                datosBasicosUsuario.setConsulta(consultaClone);
                datosBasicosUsuario.inicializarUsuario();
            }

            rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ANTICONCEPCION_ENFERMERIA;
        } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_ANTICONCEPCION_TEMPORAL)) {
            resetAnticoncepcionTemporal();
            FacesUtils.resetManagedBean("menuHistoriaControlAnticoncepcionEnfermeriaBean");
            DatosBasicosUsuarioBean datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

            if (usuario != null) {
                datosBasicosUsuario.setUsuario(usuario);
                datosBasicosUsuario.setConsulta(consultaClone);
                datosBasicosUsuario.inicializarUsuario();
            }

            rutaNavegacion = 
                    BeanNavegacion.RUTA_IR_DATOS_CONTROL_ANTICONCEPCION_ENFERMERIA;
        } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_EFECTO_JOVEN)) {
            resetControl();
            FacesUtils.resetManagedBean("menuHistoriaEfectoJoven");
            DatosBasicosUsuarioBean datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

            if (usuario != null) {
                datosBasicosUsuario.setUsuario(usuario);
                datosBasicosUsuario.setConsulta(consultaClone);
                datosBasicosUsuario.inicializarUsuario();
            }

            rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_EFECTO_JOVEN;
        } else if(servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_INSERCION)){
            resetAnticoncepcionTemporal(); 
            FacesUtils.resetManagedBean("menuHistoriaAnticoncepcionEnfermeriaInsercion");
            DatosBasicosUsuarioBean datosBasicosUsuario = 
               (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
                     
            if (usuario != null) {
               datosBasicosUsuario.setUsuario(usuario);
               datosBasicosUsuario.setConsulta(consultaClone);
               datosBasicosUsuario.inicializarUsuario();
            }

            rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ANTICONCEPCION_ENFERMERIA_INSERCION;
        } else if(servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ENTREGA_RESULTADO)){
             resetAnticoncepcionTemporal(); 
             FacesUtils.resetManagedBean("menuHistoriaEntregaResultadosEnfermeriaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
  
             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ENTREGA_RESULTADOS_ENFERMERIA;
         }else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_RETIRO)) {
            resetAnticoncepcionTemporal();
            FacesUtils.resetManagedBean("menuHistoriaAnticoncepcionEnfermeriaRetiro");
            DatosBasicosUsuarioBean datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

            List<Object[]> resultList = null;

            if (usuario != null) {
                datosBasicosUsuario.setUsuario(usuario);
                datosBasicosUsuario.setConsulta(consultaClone);
                datosBasicosUsuario.inicializarUsuario();
                try {
                    resultList = 
                            getServiceLocator().getClinicoService().getListaServiciosValidacionRetiro(consultaClone.getCconnumdoc().longValue(), 
                                                                                                         consultaClone.getCcocservic().getCsvccodigo());
                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_COSNULTA);
                }
            }
            if (resultList == null || resultList.isEmpty()) {
                rutaNavegacion = 
                        BeanNavegacion.RUTA_IR_DATOS_ANTICONCEPCION_ENFERMERIA_RETIRO;
            } else {
                FacesUtils.addInfoMessage("Por favor realizar el registro por el servicio de consulta o inserci�n.");
            }
        } //TODO:
         else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PRENATAL)) {
             resetExamenPrenatal();
             FacesUtils.resetManagedBean("menuHistoriaNuevoPrenatalEnfermeriaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }
             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_NUEVO_PRENATAL_ENFERMERIA;
         } 
        
        else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL)) {
            resetControl();
            FacesUtils.resetManagedBean("menuControlBean");
            DatosBasicosUsuarioBean datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

            if (usuario != null) {
                datosBasicosUsuario.setUsuario(usuario);
                datosBasicosUsuario.setConsulta(consultaClone);
                datosBasicosUsuario.inicializarUsuario();
            }
            rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL_ENFERMERIA;
        } else {
            rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
            FacesUtils.addErrorMessage(ERROR_SERICIO_NO_HABILITADO);
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
            busquedaXCedula=true;
            if("".equals(numeroIdentificacion)){
                numeroIdentificacion=null;
            }
        
            try {
                this.lstUsuarios = 
                        this.serviceLocator.getClinicoService().getConsultasDiaEnfermeria(fechaActual, 
                                                                                getClinica().getCclncodigo(), 
                                                                                getUsuarioSystem().getCurnprofes(),numeroIdentificacion);
                                                                                
                lstMisConsultas = 
                        this.serviceLocator.getClinicoService().getMisConsultasDia(fechaActual, 
                                                                                getClinica().getCclncodigo(), 
                                                                                getUsuarioSystem().getCurnprofes());
                                                                                
                lstMisConsultasAgendadas = 
                        this.serviceLocator.getClinicoService().getMisConsultasDiaAgenda(fechaActual, 
                                                                                         getClinica().getCclncodigo(), 
                                                                                         getUsuarioSystem().getCurnprofes());
                                                                                         
                if(numeroIdentificacion != null){
                    lstMisConsultas = 
                            this.serviceLocator.getClinicoService().getMisConsultasDiaXNumIden(getClinica().getCclncodigo(), 
                                                                                       getUsuarioSystem().getCurnprofes(),numeroIdentificacion);  
                }
                
                                                                                        
                if (lstMisConsultasAgendadas != null && !lstMisConsultasAgendadas.isEmpty()) {
                    Cnconsclin consultaAgenda = new Cnconsclin();
                    for (Agendamiento agendas: lstMisConsultasAgendadas) {
                        try {
                            consultaAgenda = 
                                    this.serviceLocator.getClinicoService().getConsultaFechaUsuario(agendas.getFecha_agenda(), 
                                                                                                  agendas.getId_sede().intValue(), 
                                                                                                  agendas.getEspecialidad().getCsvccodigo(), 
                                                                                                  agendas.getId_paciente().getHuslnumero());

                            if (consultaAgenda != null && consultaAgenda.getCcocestado() != null && consultaAgenda.getCcocestado().equals("VG")) {
                                if (consultaAgenda.getCcocetapa() != null && consultaAgenda.getCcocetapa().equals("AT")) {
                                    agendas.setTieneConsulta(false);
                                    agendas.setDesConsulta("Atendida");
                                } else {
                                    agendas.setTieneConsulta(true);
                                    agendas.setDesConsulta(" ");
                                }
                            } else {
                                agendas.setTieneConsulta(false);
                                agendas.setDesConsulta("No tiene Pago");
                            }
                        } catch (ModelException e) {
                            return capturaError(e,IConstantes.ERROR_COSNULTA);
                        }
                    }
                }
                                                                                
            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }
        }
        return null;
    }

    private void resetConducta() {
        FacesUtils.resetManagedBean("anatomiaPatolUsuarioBean");
        FacesUtils.resetManagedBean("recomedacionUsuarioBean");
        FacesUtils.resetManagedBean("referenciaUsuarioBean");
        FacesUtils.resetManagedBean("certAsistenciaUsuarioBean");
        FacesUtils.resetManagedBean("certMedicoUsuarioBean");
        FacesUtils.resetManagedBean("controlSinCostoUsuarioBean");
        FacesUtils.resetManagedBean("examElectrofisioUsuarioBean");
        FacesUtils.resetManagedBean("examImagenUsuarioBean");
        FacesUtils.resetManagedBean("examLaboratorioUsuarioBean");
        FacesUtils.resetManagedBean("formulaMedicaUsuarioBean");
        FacesUtils.resetManagedBean("vademecumMedicoBean");
        FacesUtils.resetManagedBean("hospitalizacionUsuarioBean");
        FacesUtils.resetManagedBean("incapacidadUsuarioBean");
        FacesUtils.resetManagedBean("interConsultaUsuarioBean");
        FacesUtils.resetManagedBean("ordenCirugiaUsuarioBean");
        FacesUtils.resetManagedBean("reservaSangreUsuarioBean");
        FacesUtils.resetManagedBean("buscadorMedicamentoBean");
        FacesUtils.resetManagedBean("buscadorPlantillaBean");
        FacesUtils.resetManagedBean("buscadorCie10");
        FacesUtils.resetManagedBean("buscadorCirugiasReservaBean");
        FacesUtils.resetManagedBean("buscadorCirugiasBean");
        FacesUtils.resetManagedBean("formulaHospitalizacionBean");
        FacesUtils.resetManagedBean("cuestionarioCovidBean");

    }
    
    private void resetAnticoncepcionTemporal() {
        resetConducta();
        FacesUtils.resetManagedBean("antecedentesGeneralesUsuarioBean");
        FacesUtils.resetManagedBean("antecedentesGinecologicosUsuarioBean");
        FacesUtils.resetManagedBean("antecedentesUsuarioBean");
        FacesUtils.resetManagedBean("cerrarConsultaUsuarioBean");
        FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
        FacesUtils.resetManagedBean("encuestaViolenciaUsuarioBean");
        FacesUtils.resetManagedBean("examenFisicoUsuarioBean");
        FacesUtils.resetManagedBean("impresionDiagnosticaUsuarioBean");
        FacesUtils.resetManagedBean("motivoBean");
        FacesUtils.resetManagedBean("antecedentesTemporalesUsuario");
        FacesUtils.resetManagedBean("aplicacionDispositivoBean");
        FacesUtils.resetManagedBean("metodosAnticoncepcionBean");
        FacesUtils.resetManagedBean("cuestionarioCovidBean");
    }
    
    private void resetControl() {
        resetConducta();
        FacesUtils.resetManagedBean("antecedentesGeneralesUsuarioBean");
        FacesUtils.resetManagedBean("antecedentesGinecologicosUsuarioBean");
        FacesUtils.resetManagedBean("antecedentesUsuarioBean");
        FacesUtils.resetManagedBean("cerrarConsultaUsuarioBean");
        FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
        FacesUtils.resetManagedBean("encuestaViolenciaUsuarioBean");
        FacesUtils.resetManagedBean("examenFisicoUsuarioBean");
        FacesUtils.resetManagedBean("impresionDiagnosticaUsuarioBean");
        FacesUtils.resetManagedBean("motivoBean");
        FacesUtils.resetManagedBean("controlUsuarioBean");
        FacesUtils.resetManagedBean("cuestionarioCovidBean");
    }
     
    private void resetExamenPrenatal() {
        resetConducta();
        FacesUtils.resetManagedBean("antecedentesGeneralesUsuarioBean");
        FacesUtils.resetManagedBean("antecedentesGinecologicosUsuarioBean");
        FacesUtils.resetManagedBean("antecedentesUsuarioBean");
        FacesUtils.resetManagedBean("cerrarConsultaUsuarioBean");
        FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
        FacesUtils.resetManagedBean("encuestaViolenciaUsuarioBean");
        FacesUtils.resetManagedBean("examenFisicoPrenatalUsuarioBean");
        FacesUtils.resetManagedBean("impresionDiagnosticaUsuarioBean");
        FacesUtils.resetManagedBean("motivoBean");
        FacesUtils.resetManagedBean("antecedentePrenatalUsuarioBean");
        FacesUtils.resetManagedBean("gestacionControlPranatalUsuarioBean");
        FacesUtils.resetManagedBean("gestacionPrenatalUsuarioBean");
        FacesUtils.resetManagedBean("tamizajeControlPrenatalUsuarioBean");
        FacesUtils.resetManagedBean("tamizajePrenatalUsuarioBean");
        FacesUtils.resetManagedBean("antecedentesGinecoObstetricosBean");
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
                        IConstantes.NO_EXISTEN_CONSULTAS_PARA_LA_FECHA + fechaCons;
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
