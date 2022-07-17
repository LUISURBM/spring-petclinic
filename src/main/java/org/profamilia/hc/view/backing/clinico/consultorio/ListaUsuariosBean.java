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
import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.Chusuario;
 import org.profamilia.hc.model.dto.Cnconsclin;
 import org.profamilia.hc.model.dto.Cpservicio;
 import org.profamilia.hc.model.exceptions.ModelException;
 import org.profamilia.hc.view.backing.BaseBean;
 import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.PruebasAnticuerposCovidBean;
import org.profamilia.hc.view.backing.comun.conducta.VademecumMedicoBean;
import org.profamilia.hc.view.backing.menus.consultorio.MenuAnticuerposCovidBean;
import org.profamilia.hc.view.backing.menus.consultorio.MenuControlBean;
import org.profamilia.hc.view.backing.menus.consultorio.MenuProcedimientoConsultorioBean;
 import org.profamilia.hc.view.backing.menus.consultorio.MenuProcedimientoIveBean;
import org.profamilia.hc.view.backing.procedimiento.AntecedentesColposcopiaBean;
import org.profamilia.hc.view.backing.procedimiento.DatosUsuarioCitologiaBean;
 import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;

 //=======================================================================
 //  CLASE
 //=======================================================================

 public class ListaUsuariosBean extends BaseBean {

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
     
    private boolean existeProgramacion;

     
    private List<Cnconsclin> lstCovidAnticuerpos;
    
    private List<Cnconsclin> lstCovidAntigenos;
    
    private HtmlDataTable dtCovidAnticuerpos;
    
    private HtmlDataTable dtCovidAntigenos;

     //-----------------------------------------------------------------------
     //  METODO CONSTRUCTOR
     //-----------------------------------------------------------------------

     public ListaUsuariosBean() {
     }

     public void init() {
         lstUsuarios = new ArrayList<Cnconsclin>();
         dtConsultas = new HtmlDataTable();
         dtMisConsultas = new HtmlDataTable();
         dtlstMisConsultasAgendadas = new HtmlDataTable();
         msg_sin_registros = IConstantes.MSG_SIN_CONSULTAR;
         numeroIdentificacion = null;
         busquedaXCedula=false;
         dtCovidAnticuerpos = new HtmlDataTable();
         lstCovidAnticuerpos = new ArrayList<Cnconsclin>();
         lstCovidAntigenos= new ArrayList<Cnconsclin>();
         dtCovidAntigenos = new HtmlDataTable();
     }


     // ACTIONS BEAN

     /**
      * @return
      */
     public String atenderMisConsultas() {
         Long codigoAgenda = null;
         datosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

         this.consultaClone = (Cnconsclin)this.dtMisConsultas.getRowData();
         Chusuario usuario;
         usuario = null;
         
             
             if(consultaClone != null && consultaClone.getCconnumero() != null){
                 try {
                     existeProgramacion = serviceLocator.getCirugiaService().verificarProgramacionCirugia(consultaClone.getCconnumero().longValue());
                 } catch (ModelException e) {
                     e.printStackTrace();
                 }
             }
             

         try {
             usuario = 
                     this.getServiceLocator().getClinicoService().getUsuario(consultaClone.getCcolusuario().getHuslnumero());
         } catch (ModelException e) {
             return capturaError(e,IConstantes.ERROR_COSNULTA);
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
         

        if (IConstantes.ACTIVAR_PAUSAR_CONSULTA) {
            Boolean existe = false;
            List<Chtiempaten> chtiempatenList = 
                validacionConsultasAbiertasDelDiaXMedico();
            Long contador = 0L;
            for (Chtiempaten chtiempaten: chtiempatenList) {
                for (Cnconsclin cnconsclinAux: lstMisConsultas) {
                    if (cnconsclinAux.getCconnumero().intValue() == 
                        chtiempaten.getCtanconsulta().intValue()) {
                        contador++;
                    }
                }

            }

            if (contador > 1) {
                existe = true;
            }

            if (existe) {
                rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
                FacesUtils.addErrorMessage("Tiene consultas abiertas, cierrelas o pause las consultas");
            } else {
                navegacionAtenderMisConsultas(usuario, codigoAgenda);
            }
        } else {
        
        if(!existeProgramacion){
            
        
            boolean validacion = false;
            if(IConstantes.HISTORIA_INTERRUPCION.equals(servicio.getCsvntiphis())){
                try {
                    validacion = 
                            this.getServiceLocator().getClinicoService().getConsultaClinicaIVEXUsuario(consultaClone,true);
                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_COSNULTA);
                }
                if(validacion){
                    FacesUtils.addInfoMessage("Usuario ya cuenta con consulta de IVE atendida, proceder con la atenci�n de la consulta de planificaci�n");
                    rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
                }else {
                    navegacionAtenderMisConsultas(usuario, codigoAgenda);
                }
            }else{
            
                boolean valdacionIVE = false;
                boolean valdacionIVEAdmision = false;
                try {
                    valdacionIVEAdmision =  
                            this.getServiceLocator().getClinicoService().getDetalleAdmisionXTipoHistoria(consultaClone.getCconnumdoc().longValue(),IConstantes.HISTORIA_INTERRUPCION);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                
                if(servicio != null && servicio.getCsvngrupo() ==61 && (servicio.getCsvnsubgru() == 5 || servicio.getCsvnsubgru() == 4 || servicio.getCsvnsubgru() == 1) && valdacionIVEAdmision){

                    try {
                        valdacionIVE = 
                                this.getServiceLocator().getClinicoService().getConsultaClinicaIVEXUsuario(consultaClone,false);
                    } catch (ModelException e) {
                        return capturaError(e,IConstantes.ERROR_COSNULTA);
                    }
                    
                    if(valdacionIVE){
                        navegacionAtenderMisConsultas(usuario, codigoAgenda);
                    }else {
                        FacesUtils.addInfoMessage("Usuario no cuenta con consulta de IVE atendida, proceder con la atenci�n de la consulta IVE");
                        rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
                    }
                } else {
                    navegacionAtenderMisConsultas(usuario, codigoAgenda);
                 }
            }
            
        }else{
            FacesUtils.addErrorMessage("Existe una programaci�n de cirug�a, si tiene que realiza por este m�dulo, cancele la programaci�n para realizar por esta opci�n (Procedimientos)");
            return BeanNavegacion.RUTA_ACTUAL;     
        }
            
        }

         return rutaNavegacion;
        
         }

    private String navegacionAtenderMisConsultas(Chusuario usuario, Long codigoAgenda) {
         if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_QUIRURGICA_FEMENINA)) {
             FacesUtils.resetManagedBean("menuProcesosEsterilizacionBean");
             resetEsterilizacionFemenina();
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ESTERILIZACION;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_SALUD_SEXUAL)) {
             resetSaludSexual();
             FacesUtils.resetManagedBean("menuHistoriaSaludSexualBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
                 datosBasicosUsuario.setServicio(consultaClone.getCcocservic());
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_SALUD_SEXUAL;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_GINECOLOGIA)) {
             resetSaludSexual();
             FacesUtils.resetManagedBean("menuHistoriaGinecologiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
                 datosBasicosUsuario.setServicio(consultaClone.getCcocservic());
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_GINECOLOGIA;
         }else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_UROLOGIA)) {
             resetSaludSexual();
             FacesUtils.resetManagedBean("menuHistoriaUrologiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
                 datosBasicosUsuario.setServicio(consultaClone.getCcocservic());
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_UROLOGIA;
         }else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_EFECTO_JOVEN)) {
             resetSaludSexual();
             FacesUtils.resetManagedBean("menuHistoriaSaludSexualBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_SALUD_SEXUAL;
         }          else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_FERTILIDAD)) {
             resetControlFertilidad();
             FacesUtils.resetManagedBean("menuControlFertilidadBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");


             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }


             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL_FERTILIDAD;

         }

         
         
         
         else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_FERTILIDAD)) {
             resetFertilidad();
             FacesUtils.resetManagedBean("menuFertilidadBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_USUARIO_FERTILIDAD;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_VASECTOMIA)) {
             resetVasectomia();
             FacesUtils.resetManagedBean("menuVasectomiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_VASECTOMIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_TEMPORAL)) {
             resetAnticoncepcionTemporal();
             FacesUtils.resetManagedBean("menuHistoriaAnticoncepcionTemporalBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ANTICONCEPCION;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_ANTICONCEPCION_TEMPORAL)) {
             resetAnticoncepcionTemporal();
             FacesUtils.resetManagedBean("menuHistoriaControlAnticoncepcionBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = 
                     BeanNavegacion.RUTA_IR_DATOS_CONTROL_ANTICONCEPCION;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_EXAMEN_MAMA)) {
             resetExamenMama();
             FacesUtils.resetManagedBean("menuHistoriaMama");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_MAMA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PEDIATRIA)) {
             resetExamenPediatria();
             FacesUtils.resetManagedBean("menuHistoriaPediatria");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_PEDIATRIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PRENATAL)) {
             resetExamenPrenatal();
             FacesUtils.resetManagedBean("menuHistoriaNuevoPrenatalBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_NUEVO_PRENATAL;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_PRENATAL)) {
             resetExamenPrenatal();
             FacesUtils.resetManagedBean("menuHistoriaControlPrenatal");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL_PRENATAL;
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

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_EXAMEN_MAMA)) {
             resetControl();
             FacesUtils.resetManagedBean("menuControlExamenMamaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL_EXAMEN_MAMA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_DERMATOLOGIA)) {
             resetControl();
             FacesUtils.resetManagedBean("menuControlDermatologiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL_DERMATOLOGIA;
         }else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PROCEDIMIENTOS_CONSULTORIO)) {
             resetProcedimientoConsultorio();
             FacesUtils.resetManagedBean("menuProcedimientoConsultorioBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = 
                     BeanNavegacion.RUTA_IR_DATOS_PROCEDIMIENTO_CONSULTORIO;
         } else if (servicio.getCsvntiphis().equals(IConstantes.APOYO_INFORME_CITOPUNCION)) {
             resetInformeCitopuncion();
             FacesUtils.resetManagedBean("menuInformeCitopuncionBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CITOPUNCION;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_INSERCION)) {
             resetAnticoncepcionTemporal();
             FacesUtils.resetManagedBean("menuHistoriaAnticoncepcionInsercion");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = 
                     BeanNavegacion.RUTA_IR_DATOS_ANTICONCEPCION_INSERCION;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_RETIRO)) {
            resetAnticoncepcionTemporal();
            FacesUtils.resetManagedBean("menuHistoriaAnticoncepcionRetiro");
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
                        BeanNavegacion.RUTA_IR_DATOS_ANTICONCEPCION_RETIRO;
            } else {
                FacesUtils.addInfoMessage("Por favor realizar el registro por el servicio de consulta o inserci�n.");
            }
        } else if (servicio.getCsvntiphis().equals(IConstantes.APOYO_INFORME_ECOGRAFIA)) {
             resetInformeEcografia();
             FacesUtils.resetManagedBean("menuInformeEcografiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ECOGRAFIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.APOYO_INFORME_HISTEROSONOGRAFIA)) {
             resetInformeHisterosonografia();
             FacesUtils.resetManagedBean("menuInformeHisterosonografiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_HISTEROSONOGRAFIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.APOYO_INFORME_MAMOGRAFIA)) {
             resetInformeMamografia();
             FacesUtils.resetManagedBean("MenuInformeMamografiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_MAMOGRAFIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.APOYO_INFORME_MARCACION_SENO)) {
             resetInformeMarcacionSeno();
             FacesUtils.resetManagedBean("menuInformeMarcacionSenoBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_MARCACION_SENO;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA)) {
             resetProcedimientoCitologia();
             FacesUtils.resetManagedBean("menuTomaCitologiaBean");
             DatosUsuarioCitologiaBean datosBasicosUsuario = 
                 (DatosUsuarioCitologiaBean)FacesUtils.getManagedBean("datosUsuarioCitologiaBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarDatosUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CITOLOGIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PREANESTESIA)) {
             resetHistoriaPreanestesia();
             FacesUtils.resetManagedBean("menuHistoriaPreanestesiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setRenderContacto(false);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_PREANESTESIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_GINECOLOGIA)) {
             resetSaludSexual();
             FacesUtils.resetManagedBean("menuControlGinecologiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setRenderContacto(false);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL_GINECOLOGIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_UROLOGIA)) {
             resetSaludSexual();
             FacesUtils.resetManagedBean("menuControlUrologiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setRenderContacto(false);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL_UROLOGIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PSICOLOGICA)) {
             resetHistoriaPsicologia();
             FacesUtils.resetManagedBean("menuHistoriaPsicologicaBean");

             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setRenderContacto(false);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }
             
             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_PSICOLOGIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CERVIX)) {
             resetHistoriaCervix();
             FacesUtils.resetManagedBean("menuHistoriaCervixBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setRenderContacto(true);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }
             
             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CERVIX;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PSICOLOGICA_CONTROL)) {
             resetHistoriaPsicologia();
             FacesUtils.resetManagedBean("menuHistoriaPsicologicaControlBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.setRenderContacto(false);
                 datosBasicosUsuario.inicializarUsuario();
             }
             
             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_PSICOLOGIA_CONTROL;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CERVIX_VACUNACION)) {
             resetHistoriaCervix();
             FacesUtils.resetManagedBean("menuHistoriaVacunacionCervixBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_VACUNACION_CERVIX;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ESTERILIZACION_MASCULINA)) {
             resetEsterilizacionMasculina();
             FacesUtils.resetManagedBean("menuHistoriaEsterilizacionMasculina");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ESTERILIZACION_MASCULINA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_INTERRUPCION)) {
             resetInterrupcion();
             FacesUtils.resetManagedBean("menuHistoriaInterrupcionBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_INTERRUPCION;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_INTERRUPCION)) {
             resetInterrupcion();
             FacesUtils.resetManagedBean("menuControlIlveBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL_ILVE;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_OTRAS_ESPECIALIDADES)) {
             resetDermatologia();
             FacesUtils.resetManagedBean("menuHistoriaDermatologicaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_OTRAS_ESPECIALIDADES;
         } else if (servicio.getCsvntiphis().equals(IConstantes.CIRUGIA_PROCEDIMIENTO_CONSULTORIO_IVE)) {
             resetDermatologia();
             FacesUtils.resetManagedBean("menuProcedimientoIveBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }
             //                      rutaNavegacion = BeanNavegacion.RUTA_IR_PROCEDIMIENTO_IVE;
             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_PROCEDIMIENTO_IVE;
         }else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PROCEDIMIENTO_COLPOSCOPIA)) {
             resetColposcopia();
             resetConducta();
             FacesUtils.resetManagedBean("menuProcedimientoColposcopiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                 datosBasicosUsuario.inicializarUsuario();
             }
             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_COLPOSCOPIA;
         }

        else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_MANUAL) || 
                 servicio.getCsvntiphis().equals(IConstantes.HISTORIA_LABORATORIOS)) {
            resetConfirmacionHistoria();
            FacesUtils.resetManagedBean("menuHistoriaConfirmacionBean");
            DatosBasicosUsuarioBean datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");


            if (usuario != null) {
                datosBasicosUsuario.setUsuario(usuario);
                datosBasicosUsuario.setConsulta(consultaClone);
                datosBasicosUsuario.setCodigoAgenda(codigoAgenda);
                datosBasicosUsuario.inicializarUsuario();
            }

            rutaNavegacion = BeanNavegacion.RUTA_IR_CONFIRMACION_PRESTACION;

        } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ENTREGA_RESULTADO)) {
            resetControl();
            FacesUtils.resetManagedBean("menuControlEntregaResultadoBean");
            DatosBasicosUsuarioBean datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

            if (usuario != null) {
                datosBasicosUsuario.setUsuario(usuario);
                datosBasicosUsuario.setConsulta(consultaClone);
                datosBasicosUsuario.inicializarUsuario();
            }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL_ENTREGA_RESULTADO;
        } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICUERPOS_COVID)) {
            resetHistoriaCovidAnticuerpos();
            FacesUtils.resetManagedBean("menuAnticuerposCovidBean");
            DatosBasicosUsuarioBean datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

            if (usuario != null) {
                datosBasicosUsuario.setUsuario(usuario);
                datosBasicosUsuario.setConsulta(consultaClone);
                datosBasicosUsuario.inicializarUsuario();
            }

            rutaNavegacion = 
                    BeanNavegacion.RUTA_DATOS_USUARIO_COVID_ANTICUERPOS;
        } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTIGENOS_COVID)) {
            resetHistoriaCovidAntigenos();
           
            DatosBasicosUsuarioBean datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

            if (usuario != null) {
                datosBasicosUsuario.setUsuario(usuario);
                datosBasicosUsuario.setConsulta(consultaClone);
                datosBasicosUsuario.inicializarUsuario();
            }

            rutaNavegacion = 
                    BeanNavegacion.RUTA_DATOS_USUARIO_COVID_ANTIGENOS;
            } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PROCEDIMIENTO_ASOCIADO)) {
                 resetAnticoncepcionTemporal();
                 FacesUtils.resetManagedBean("menuHistoriaAnticoncepcionInsercion");
                 DatosBasicosUsuarioBean datosBasicosUsuario = 
                     (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

                 if (usuario != null) {
                     datosBasicosUsuario.setUsuario(usuario);
                     datosBasicosUsuario.setConsulta(consultaClone);
                     datosBasicosUsuario.inicializarUsuario();
                 }

                 rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ANTICONCEPCION_INSERCION;
           } else {
             rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
             FacesUtils.addErrorMessage(ERROR_SERICIO_NO_ASOCIADO);
         }
         return null;
    }

     // atender mis consultas agendadas
     
     /**
      * @return
      */
     public String atenderMisConsultasAgendadas() {
         datosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

         this.agendaClone = 
                 (Agendamiento)this.dtlstMisConsultasAgendadas.getRowData();
                 
         
         if(consultaClone != null && consultaClone.getCconnumero() != null){
             try {
                 existeProgramacion = serviceLocator.getCirugiaService().verificarProgramacionCirugia(consultaClone.getCconnumero().longValue());
             } catch (ModelException e) {
                 e.printStackTrace();
             }
         }
         
         Chusuario usuario;
         usuario = null;
         Long codigoAgenda = agendaClone.getId().longValue();
         
         try {
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
             usuario = 
                     this.getServiceLocator().getClinicoService().getUsuario(agendaClone.getId_paciente().getHuslnumero());
         } catch (ModelException e) {
             return capturaError(e,IConstantes.ERROR_COSNULTA);
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
        if (IConstantes.ACTIVAR_PAUSAR_CONSULTA) {
            Boolean existe = false;
            List<Chtiempaten> chtiempatenList = 
                validacionConsultasAbiertasDelDiaXMedico();
            if (!chtiempatenList.isEmpty()) {
                existe = true;
            }
            if (existe) {
                rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
                FacesUtils.addErrorMessage("Tiene consultas abiertas, cierrelas o pause las consultas");
            } else {
                navegacionAtenderMisConsultas(usuario,codigoAgenda);
            }

        } else {
        
            boolean validacion = false;
            if(IConstantes.HISTORIA_INTERRUPCION.equals(servicio.getCsvntiphis())){
                try {
                    validacion = 
                            this.getServiceLocator().getClinicoService().getConsultaClinicaIVEXUsuario(consultaClone,true);
                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_COSNULTA);
                }
                if(validacion){
                    FacesUtils.addInfoMessage("Usuario ya cuenta con consulta de IVE atendida, proceder con la atenci�n de la consulta de planificaci�n");
                    rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
                }else {
                    navegacionAtenderMisConsultas(usuario, codigoAgenda);
                }
            }else{
                boolean valdacionIVE = false;
                boolean valdacionIVEAdmision = false;
                try {
                    valdacionIVEAdmision =  
                            this.getServiceLocator().getClinicoService().getDetalleAdmisionXTipoHistoria(consultaClone.getCconnumdoc().longValue(),IConstantes.HISTORIA_INTERRUPCION);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                
                if(servicio != null && servicio.getCsvngrupo() ==61 && (servicio.getCsvnsubgru() == 5 || servicio.getCsvnsubgru() == 4 || servicio.getCsvnsubgru() == 1) && valdacionIVEAdmision){
                    try {
                        valdacionIVE = 
                                this.getServiceLocator().getClinicoService().getConsultaClinicaIVEXUsuario(consultaClone,false);
                    } catch (ModelException e) {
                        return capturaError(e,IConstantes.ERROR_COSNULTA);
                    }
                    
                    if(valdacionIVE){
                        navegacionAtenderMisConsultas(usuario, codigoAgenda);
                    }else {
                        FacesUtils.addInfoMessage("Usuario no cuenta con consulta de IVE atendida, proceder con la atenci�n de la consulta IVE");
                        rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
                    }
                } else {
                    navegacionAtenderMisConsultas(usuario, codigoAgenda);
                 }
            }
            
        }
       
         return rutaNavegacion;
     }

     public String atenderUsuario() {
         Long codigoAgenda = null;
         datosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

         this.consultaClone = (Cnconsclin)this.dtConsultas.getRowData();
         Chusuario usuario;
         usuario = null;
         
         if(consultaClone != null && consultaClone.getCconnumero() != null){
             try {
                 existeProgramacion = serviceLocator.getCirugiaService().verificarProgramacionCirugia(consultaClone.getCconnumero().longValue());
             } catch (ModelException e) {
                 e.printStackTrace();
             }
         }
         
         try {
             usuario = 
                     this.getServiceLocator().getClinicoService().getUsuario(consultaClone.getCcolusuario().getHuslnumero());

         } catch (ModelException e) {
             return capturaError(e,IConstantes.ERROR_COSNULTA);
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
         
         if (IConstantes.ACTIVAR_PAUSAR_CONSULTA) {
            Boolean existe = false;
            List<Chtiempaten> chtiempatenList = 
                validacionConsultasAbiertasDelDiaXMedico();
            if (!chtiempatenList.isEmpty()) {
                existe = true;
            }
            if (existe) {
                rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
                FacesUtils.addErrorMessage("Tiene consultas abiertas, cierrelas o pause las consultas");
            } else {
                navegacionAtenderUsuario(usuario);
            }
        }else{
        if(!existeProgramacion){
            boolean validacion = false;
            if(IConstantes.HISTORIA_INTERRUPCION.equals(servicio.getCsvntiphis())){
                try {
                    validacion = 
                            this.getServiceLocator().getClinicoService().getConsultaClinicaIVEXUsuario(consultaClone,true);
                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_COSNULTA);
                }
                if(validacion){
                    FacesUtils.addInfoMessage("Usuario ya cuenta con consulta de IVE atendida, proceder con la atenci�n de la consulta de planificaci�n");
                    rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
                }else {
                    navegacionAtenderUsuario(usuario);
                }
            }else{
            
                boolean valdacionIVE = false;
                boolean valdacionIVEAdmision = false;
                try {
                    valdacionIVEAdmision =  
                            this.getServiceLocator().getClinicoService().getDetalleAdmisionXTipoHistoria(consultaClone.getCconnumdoc().longValue(),IConstantes.HISTORIA_INTERRUPCION);
                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_COSNULTA);
                }
                
                if(servicio != null && servicio.getCsvngrupo() ==61 && (servicio.getCsvnsubgru() == 5 || servicio.getCsvnsubgru() == 4 || servicio.getCsvnsubgru() == 1) && valdacionIVEAdmision){
                    try {   
                        valdacionIVE = 
                                this.getServiceLocator().getClinicoService().getConsultaClinicaIVEXUsuario(consultaClone,false);
                    } catch (ModelException e) {
                        return capturaError(e,IConstantes.ERROR_COSNULTA);
                    }
                    
                    if(valdacionIVE){
                        navegacionAtenderUsuario(usuario);
                    }else {
                        FacesUtils.addInfoMessage("Usuario no cuenta con consulta de IVE atendida, proceder con la atenci�n de la consulta IVE");
                        rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
                    }
                }else {
                    navegacionAtenderUsuario(usuario);
                 }
            }
            
        } else{
            FacesUtils.addErrorMessage("Existe una programaci�n de cirug�a, si tiene que realiza por este m�dulo, cancele la programaci�n para realizar por esta opci�n (Procedimientos)");
            return BeanNavegacion.RUTA_ACTUAL;     
        }
           
           
        }
         
         return rutaNavegacion;
     }

    private String navegacionAtenderUsuario(Chusuario usuario) {
         if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_QUIRURGICA_FEMENINA)) {
             FacesUtils.resetManagedBean("menuProcesosEsterilizacionBean");
             resetEsterilizacionFemenina();
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ESTERILIZACION;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_SALUD_SEXUAL)) {
             resetSaludSexual();
             FacesUtils.resetManagedBean("menuHistoriaSaludSexualBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_SALUD_SEXUAL;
         }else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_GINECOLOGIA)) {
             resetSaludSexual();
             FacesUtils.resetManagedBean("menuHistoriaGinecologiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_GINECOLOGIA;
         }else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_UROLOGIA)) {
             resetSaludSexual();
             FacesUtils.resetManagedBean("menuHistoriaUrologiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_UROLOGIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_EFECTO_JOVEN)) {
             resetSaludSexual();
             FacesUtils.resetManagedBean("menuHistoriaSaludSexualBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_SALUD_SEXUAL;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_FERTILIDAD)) {
             resetFertilidad();
             FacesUtils.resetManagedBean("menuFertilidadBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_USUARIO_FERTILIDAD;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_TEMPORAL)) {
             resetAnticoncepcionTemporal();
             FacesUtils.resetManagedBean("menuHistoriaAnticoncepcionTemporalBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ANTICONCEPCION;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_ANTICONCEPCION_TEMPORAL)) {
             resetAnticoncepcionTemporal();
             FacesUtils.resetManagedBean("menuHistoriaControlAnticoncepcionBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL_ANTICONCEPCION;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_EXAMEN_MAMA)) {
             resetExamenMama();
             FacesUtils.resetManagedBean("menuHistoriaMama");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_MAMA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PEDIATRIA)) {
             resetExamenPediatria();
             FacesUtils.resetManagedBean("menuHistoriaPediatria");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_PEDIATRIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PRENATAL)) {
             resetExamenPrenatal();
             FacesUtils.resetManagedBean("menuHistoriaNuevoPrenatalBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_NUEVO_PRENATAL;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_PRENATAL)) {
             resetExamenPrenatal();
             FacesUtils.resetManagedBean("menuHistoriaControlPrenatal");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL_PRENATAL;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL)) {
             resetControl();
             FacesUtils.resetManagedBean("menuControlBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");


             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL;
         }else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_EXAMEN_MAMA)) {
             resetControl();
             FacesUtils.resetManagedBean("menuControlExamenMamaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL_EXAMEN_MAMA;
         }else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_DERMATOLOGIA)) {
             resetControl();
             FacesUtils.resetManagedBean("menuControlDermatologiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL_DERMATOLOGIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PROCEDIMIENTOS_CONSULTORIO)) {
             resetProcedimientoConsultorio();
             FacesUtils.resetManagedBean("menuProcedimientoConsultorioBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_PROCEDIMIENTO_CONSULTORIO;
         } else if (servicio.getCsvntiphis().equals(IConstantes.APOYO_INFORME_CITOPUNCION)) {
             resetInformeCitopuncion();
             FacesUtils.resetManagedBean("menuInformeCitopuncionBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CITOPUNCION;
         } else if (servicio.getCsvntiphis().equals(IConstantes.APOYO_INFORME_ECOGRAFIA)) {
             resetInformeEcografia();
             FacesUtils.resetManagedBean("menuInformeEcografiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ECOGRAFIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.APOYO_INFORME_HISTEROSONOGRAFIA)) {
             resetInformeHisterosonografia();
             FacesUtils.resetManagedBean("menuInformeHisterosonografiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_HISTEROSONOGRAFIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.APOYO_INFORME_MAMOGRAFIA)) {
             resetInformeMamografia();
             FacesUtils.resetManagedBean("MenuInformeMamografiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_MAMOGRAFIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.APOYO_INFORME_MARCACION_SENO)) {
             resetInformeMarcacionSeno();
             FacesUtils.resetManagedBean("menuInformeMarcacionSenoBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_MARCACION_SENO;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA)) {
             resetProcedimientoCitologia();
             FacesUtils.resetManagedBean("menuTomaCitologiaBean");
             DatosUsuarioCitologiaBean datosBasicosUsuario = 
                 (DatosUsuarioCitologiaBean)FacesUtils.getManagedBean("datosUsuarioCitologiaBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarDatosUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CITOLOGIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PREANESTESIA)) {
             resetHistoriaPreanestesia();
             FacesUtils.resetManagedBean("menuHistoriaPreanestesiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setRenderContacto(false);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_PREANESTESIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_PREANESTESIA)) {
             resetHistoriaPreanestesia();
             FacesUtils.resetManagedBean("menuHistoriaControlPreanestesiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setRenderContacto(false);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL_PREANESTESIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_GINECOLOGIA)) {
             resetSaludSexual();
             FacesUtils.resetManagedBean("menuControlGinecologiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setRenderContacto(false);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL_GINECOLOGIA;
         }else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_UROLOGIA)) {
             resetSaludSexual();
             FacesUtils.resetManagedBean("menuControlUrologiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setRenderContacto(false);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL_UROLOGIA;
         }else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PSICOLOGICA)) {
             resetHistoriaPsicologia();
             FacesUtils.resetManagedBean("menuHistoriaPsicologicaBean");

             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setRenderContacto(false);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }
             
             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_PSICOLOGIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CERVIX)) {
             resetHistoriaCervix();
             FacesUtils.resetManagedBean("menuHistoriaCervixBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setRenderContacto(true);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }
             
             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CERVIX;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PSICOLOGICA_CONTROL)) {
             resetHistoriaPsicologia();
             FacesUtils.resetManagedBean("menuHistoriaPsicologicaControlBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.setRenderContacto(false);
                 datosBasicosUsuario.inicializarUsuario();
             }
             
             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_PSICOLOGIA_CONTROL;
         }

         else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CERVIX_VACUNACION)) {
             resetHistoriaCervix();
             FacesUtils.resetManagedBean("menuHistoriaVacunacionCervixBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_VACUNACION_CERVIX;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ESTERILIZACION_MASCULINA)) {
             resetEsterilizacionMasculina();
             FacesUtils.resetManagedBean("menuHistoriaEsterilizacionMasculina");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ESTERILIZACION_MASCULINA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_INTERRUPCION)) {
             resetInterrupcion();
             FacesUtils.resetManagedBean("menuHistoriaInterrupcionBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_INTERRUPCION;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_INTERRUPCION)) {
             resetInterrupcion();
             FacesUtils.resetManagedBean("menuControlIlveBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL_ILVE;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_INSERCION)) {
             resetAnticoncepcionTemporal();
             FacesUtils.resetManagedBean("menuHistoriaAnticoncepcionInsercion");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ANTICONCEPCION_INSERCION;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_RETIRO)) {
            resetAnticoncepcionTemporal();
            FacesUtils.resetManagedBean("menuHistoriaAnticoncepcionRetiro");
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
                        BeanNavegacion.RUTA_IR_DATOS_ANTICONCEPCION_RETIRO;
            } else {
                FacesUtils.addInfoMessage("Por favor realizar el registro por el servicio de consulta o inserci�n.");
            }
        } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_VASECTOMIA)) {
             resetVasectomia();
             FacesUtils.resetManagedBean("menuVasectomiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_VASECTOMIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_OTRAS_ESPECIALIDADES)) {
             resetDermatologia();
             FacesUtils.resetManagedBean("menuHistoriaDermatologicaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_OTRAS_ESPECIALIDADES;
         } else if (servicio.getCsvntiphis().equals(IConstantes.CIRUGIA_PROCEDIMIENTO_CONSULTORIO_IVE)) {
             resetDermatologia();
             FacesUtils.resetManagedBean("menuProcedimientoIveBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_PROCEDIMIENTO_IVE;
         }else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PROCEDIMIENTO_COLPOSCOPIA)) {
             resetColposcopia();
             resetConducta();
             FacesUtils.resetManagedBean("menuProcedimientoColposcopiaBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_COLPOSCOPIA;
         } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PROCEDIMIENTO_COLPOSCOPIA)) {
            resetConducta();
            resetColposcopia();
            FacesUtils.resetManagedBean("menuProcedimientoColposcopiaBean");
            DatosBasicosUsuarioBean datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

            if (usuario != null) {
                datosBasicosUsuario.setUsuario(usuario);
                datosBasicosUsuario.setConsulta(consultaClone);
                datosBasicosUsuario.inicializarUsuario();
            }

            if ("pruebahis".equals(userName())) {
                rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_COLPOSCOPIA;
            } else {
                rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
                FacesUtils.addErrorMessage("No se encuentra disponible este servicio para atender");
            }
        }


        else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_MANUAL) || 
                 servicio.getCsvntiphis().equals(IConstantes.HISTORIA_LABORATORIOS)) {
            resetConfirmacionHistoria();
            FacesUtils.resetManagedBean("menuHistoriaConfirmacionBean");
            DatosBasicosUsuarioBean datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");


            if (usuario != null) {
                datosBasicosUsuario.setUsuario(usuario);
                datosBasicosUsuario.setConsulta(consultaClone);
                datosBasicosUsuario.inicializarUsuario();
            }

            rutaNavegacion = BeanNavegacion.RUTA_IR_CONFIRMACION_PRESTACION;

        } else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ENTREGA_RESULTADO)) {
            resetControl();
            FacesUtils.resetManagedBean("menuControlEntregaResultadoBean");
            DatosBasicosUsuarioBean datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

            if (usuario != null) {
                datosBasicosUsuario.setUsuario(usuario);
                datosBasicosUsuario.setConsulta(consultaClone);
                datosBasicosUsuario.inicializarUsuario();
            }

            rutaNavegacion = 
                    BeanNavegacion.RUTA_IR_DATOS_CONTROL_ENTREGA_RESULTADO;
        }  else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PROCEDIMIENTO_ASOCIADO)) {
             resetAnticoncepcionTemporal();
             FacesUtils.resetManagedBean("menuHistoriaAnticoncepcionInsercion");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ANTICONCEPCION_INSERCION;
         } else {
            rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
            FacesUtils.addErrorMessage(ERROR_SERICIO_NO_ASOCIADO);
        }
        return null;
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
                 this.lstUsuarios = 
                         this.serviceLocator.getClinicoService().getConsultasDia(fechaActual, 
                                                                                 getClinica().getCclncodigo(), 
                                                                                 getUsuarioSystem().getCurnprofes());
                 lstMisConsultas = 
                         this.serviceLocator.getClinicoService().getMisConsultasDia(fechaActual, 
                                                                                    getClinica().getCclncodigo(), 
                                                                                    getUsuarioSystem().getCurnprofes());
                                                                                    
                 lstCovidAnticuerpos=  this.serviceLocator.getClinicoService().getMisConsultasCovidAnticuerpos(fechaActual, 
                                                                                    getClinica().getCclncodigo(), 
                                                                                    getUsuarioSystem().getCurnprofes());
                                                                                    
                 lstCovidAntigenos=  this.serviceLocator.getClinicoService().getMisConsultasCovidAntigenos(fechaActual, 
                                                                                    getClinica().getCclncodigo(), 
                                                                                    getUsuarioSystem().getCurnprofes());

             }else{
                 this.lstUsuarios = 
                         this.serviceLocator.getClinicoService().getConsultasDiaXNumIden(getClinica().getCclncodigo(), 
                                                                                 getUsuarioSystem().getCurnprofes(),numeroIdentificacion);
                                                                                 
                 lstMisConsultas = 
                         this.serviceLocator.getClinicoService().getMisConsultasDiaXNumIden(getClinica().getCclncodigo(), 
                                                                                    getUsuarioSystem().getCurnprofes(),numeroIdentificacion);                                                        
                
                 lstCovidAnticuerpos = 
                         this.serviceLocator.getClinicoService().getMisConsultasDiaXNumIden(getClinica().getCclncodigo(), 
                                                                                    getUsuarioSystem().getCurnprofes(),numeroIdentificacion); 
                                                                                    
                 lstCovidAntigenos= this.serviceLocator.getClinicoService().getMisConsultasDiaXNumIden(getClinica().getCclncodigo(), 
                                                                                    getUsuarioSystem().getCurnprofes(),numeroIdentificacion); 
                 numeroIdentificacion=null;
             }
             
                 lstMisConsultasAgendadas = 
                         this.serviceLocator.getClinicoService().getMisConsultasDiaAgenda(fechaActual, 
                                                                                          getClinica().getCclncodigo(), 
                                                                                          getUsuarioSystem().getCurnprofes());     

                 if (lstMisConsultasAgendadas != null && !lstMisConsultasAgendadas.isEmpty()) {
                     consultaAgenda = new Cnconsclin();
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
     
     private void resetConfirmacionHistoria(){
//         FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
     }


     private void resetSaludSexual() {
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
     }
     
    private void resetControlFertilidad() {
        resetConducta();
        FacesUtils.resetManagedBean("antecedentesGeneralesUsuarioBean");
        FacesUtils.resetManagedBean("antecedentesUsuarioBean");
        FacesUtils.resetManagedBean("cerrarConsultaUsuarioBean");
        FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
        FacesUtils.resetManagedBean("examenFisicoUsuarioBean");
        FacesUtils.resetManagedBean("impresionDiagnosticaUsuarioBean");
        FacesUtils.resetManagedBean("motivoBean");
        FacesUtils.resetManagedBean("controlUsuarioBean");
        FacesUtils.resetManagedBean("datosEcografiaFertilidadBean");
        
        
    }


     private void resetFertilidad() {
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
     }

     private void resetVasectomia() {
         FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
     }

     private void resetDermatologia() {
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
     }
     
    private void resetColposcopia() {
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
        FacesUtils.resetManagedBean("colposcopiaBean");
        FacesUtils.resetManagedBean("antecedentesColposcopiaBean");
    }

     private void resetInterrupcion() {
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
         FacesUtils.resetManagedBean("remisionIlveBean");
         FacesUtils.resetManagedBean("estadoPsicoemocionalBean");
         FacesUtils.resetManagedBean("formulaHospitalizacionBean");
     }

     private void resetHistoriaCervix() {
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
         FacesUtils.resetManagedBean("cuestionarioCervixUsuarioBean");

     }

     private void resetEsterilizacionMasculina() {
         resetConducta();
         FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
         FacesUtils.resetManagedBean("motivoBean");
         FacesUtils.resetManagedBean("esterilizacionMasculinaBean");
         FacesUtils.resetManagedBean("antecedentesUsuarioBean");
         FacesUtils.resetManagedBean("antecedentesGeneralesUsuarioBean");
         FacesUtils.resetManagedBean("encuestaViolenciaUsuarioBean");
         FacesUtils.resetManagedBean("examenFisicoUsuarioBean");
         FacesUtils.resetManagedBean("impresionDiagnosticaUsuarioBean");
         FacesUtils.resetManagedBean("metodosAnticoncepcionBean");
         FacesUtils.resetManagedBean("recomedacionUsuarioBean");
         FacesUtils.resetManagedBean("resumenHistoriaEspecificaBean");
     }

     private void resetEsterilizacionFemenina() {
         resetConducta();
         FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
         FacesUtils.resetManagedBean("motivoBean");
         FacesUtils.resetManagedBean("antecedentesUsuarioBean");
         FacesUtils.resetManagedBean("antecedentesGeneralesUsuarioBean");
         FacesUtils.resetManagedBean("esterFemeninaBean");
         FacesUtils.resetManagedBean("antecedentesGinecologicosUsuarioBean");
         FacesUtils.resetManagedBean("encuestaViolenciaUsuarioBean");
         FacesUtils.resetManagedBean("examenFisicoUsuarioBean");
         FacesUtils.resetManagedBean("impresionDiagnosticaUsuarioBean");
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
     }


     private void resetExamenMama() {
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
         FacesUtils.resetManagedBean("examenFisicoMamaUsuarioBean");
         FacesUtils.resetManagedBean("riesgoMamaUsuarioBean");
     }

     private void resetExamenPediatria() {
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
         FacesUtils.resetManagedBean("examenFisicoExamenPediatriaBean");
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
     }

     private void resetHistoriaPreanestesia() {
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
         FacesUtils.resetManagedBean("resultadosParaclinicosUsuarioBean ");
         FacesUtils.resetManagedBean("valoracionPreanestesiaUsuarioBean");
         FacesUtils.resetManagedBean("cuestionarioPreanestesiaUsuarioBean");
         FacesUtils.resetManagedBean("examenFisicoAnestesiaUsuarioBean");
     }

     private void resetProcedimientoConsultorio() {
         resetConducta();
         FacesUtils.resetManagedBean("procedimientosConsultorioUsuarioBean");
         FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
     }

     private void resetInformeCitopuncion() {
         FacesUtils.resetManagedBean("cuestionarioCovidBean");
         FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
         FacesUtils.resetManagedBean("informeCitopuncionSenoBean");
         FacesUtils.resetManagedBean("cerrarConsultaUsuarioBean");
         FacesUtils.resetManagedBean("resumenHistoriaEspecificaBean");
         FacesUtils.resetManagedBean("menuInformeCitopuncionBean");
     }

     private void resetInformeEcografia() {
         FacesUtils.resetManagedBean("cuestionarioCovidBean");
         FacesUtils.resetManagedBean("cerrarConsultaUsuarioBean");
         FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
         FacesUtils.resetManagedBean("resumenHistoriaEspecificaBean");
         FacesUtils.resetManagedBean("informeEcografiaBean");
         FacesUtils.resetManagedBean("menuInformeEcografiaBean");
     }

     private void resetInformeHisterosonografia() {
         FacesUtils.resetManagedBean("cuestionarioCovidBean");
         FacesUtils.resetManagedBean("cerrarConsultaUsuarioBean");
         FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
         FacesUtils.resetManagedBean("resumenHistoriaEspecificaBean");
         FacesUtils.resetManagedBean("informeHisterosonografiaBean");
         FacesUtils.resetManagedBean("menuInformeHisterosonografiaBean");
     }

     private void resetInformeMamografia() {
         FacesUtils.resetManagedBean("cuestionarioCovidBean");
         FacesUtils.resetManagedBean("cerrarConsultaUsuarioBean");
         FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
         FacesUtils.resetManagedBean("resumenHistoriaEspecificaBean");
         FacesUtils.resetManagedBean("informeMamografiaBean");
         FacesUtils.resetManagedBean("menuInformeMamografiaBean");
     }

     private void resetInformeMarcacionSeno() {
         FacesUtils.resetManagedBean("cuestionarioCovidBean");
         FacesUtils.resetManagedBean("cerrarConsultaUsuarioBean");
         FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
         FacesUtils.resetManagedBean("resumenHistoriaEspecificaBean");
         FacesUtils.resetManagedBean("informeMarcacionSenoBean");
         FacesUtils.resetManagedBean("menuInformeMarcacionSenoBean");
     }

     private void resetProcedimientoCitologia() {
         FacesUtils.resetManagedBean("cuestionarioCovidBean");
         FacesUtils.resetManagedBean("cerrarConsultaUsuarioBean");
         FacesUtils.resetManagedBean("datosUsuarioCitologiaBean");
         FacesUtils.resetManagedBean("tomaCitologiaBean");
         FacesUtils.resetManagedBean("menuTomaCitologiaBean");
     }

     private void resetHistoriaPsicologia() {
         FacesUtils.resetManagedBean("cuestionarioCovidBean");
         FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
         FacesUtils.resetManagedBean("motivoBean");
         FacesUtils.resetManagedBean("antecedentePsicologiaBean");
         FacesUtils.resetManagedBean("evaluacionGeneralBean");
         FacesUtils.resetManagedBean("impresionDiagnosticaUsuarioBean");
         FacesUtils.resetManagedBean("planTratamientoUsuarioBean");
         FacesUtils.resetManagedBean("cerrarConsultaUsuarioBean");
         FacesUtils.resetManagedBean("menuHistoriaPsicologicaBean");
         FacesUtils.resetManagedBean("interConsultaUsuarioBean");
         FacesUtils.resetManagedBean("certAsistenciaUsuarioBean");
         FacesUtils.resetManagedBean("certMedicoUsuarioBean");
         FacesUtils.resetManagedBean("recomedacionUsuarioBean");
     }
     
    private void resetHistoriaCovidAnticuerpos() {
         FacesUtils.resetManagedBean("listaUsuariosBean");   
        FacesUtils.resetManagedBean("pruebasAnticuerposCovidBean");         
    }
    
    private void resetHistoriaCovidAntigenos() {
         FacesUtils.resetManagedBean("listaUsuariosBean");   
        FacesUtils.resetManagedBean("pruebasAntigenosCovidBean");         
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

    public void setLstCovidAnticuerpos(List<Cnconsclin> lstCovidAnticuerpos) {
        this.lstCovidAnticuerpos = lstCovidAnticuerpos;
    }

    public List<Cnconsclin> getLstCovidAnticuerpos() {
        return lstCovidAnticuerpos;
    }

    public void setDtCovidAnticuerpos(HtmlDataTable dtCovidAnticuerpos) {
        this.dtCovidAnticuerpos = dtCovidAnticuerpos;
    }

    public HtmlDataTable getDtCovidAnticuerpos() {
        return dtCovidAnticuerpos;
    }
    
    public String atenderMisConsultasAnticuerpos() {
        Long codigoAgenda = null;
        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

        this.consultaClone = (Cnconsclin)this.dtCovidAnticuerpos.getRowData();
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
        

       if (IConstantes.ACTIVAR_PAUSAR_CONSULTA) {
           Boolean existe = false;
           List<Chtiempaten> chtiempatenList = 
               validacionConsultasAbiertasDelDiaXMedico();
           Long contador = 0L;
           for (Chtiempaten chtiempaten: chtiempatenList) {
               for (Cnconsclin cnconsclinAux: lstMisConsultas) {
                   if (cnconsclinAux.getCconnumero().intValue() == 
                       chtiempaten.getCtanconsulta().intValue()) {
                       contador++;
                   }
               }

           }

           if (contador > 1) {
               existe = true;
           }

           if (existe) {
               rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
               FacesUtils.addErrorMessage("Tiene consultas abiertas, cierrelas o pause las consultas");
           } else {
               navegacionAtenderMisConsultas(usuario, codigoAgenda);
           }
       } else {
           navegacionAtenderMisConsultas(usuario, codigoAgenda);
       }

        return rutaNavegacion;
       
        }
        
    public String atenderMisConsultasAntigenos() {
        Long codigoAgenda = null;
        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

        this.consultaClone = (Cnconsclin)this.dtCovidAntigenos.getRowData();
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
        

       if (IConstantes.ACTIVAR_PAUSAR_CONSULTA) {
           Boolean existe = false;
           List<Chtiempaten> chtiempatenList = 
               validacionConsultasAbiertasDelDiaXMedico();
           Long contador = 0L;
           for (Chtiempaten chtiempaten: chtiempatenList) {
               for (Cnconsclin cnconsclinAux: lstMisConsultas) {
                   if (cnconsclinAux.getCconnumero().intValue() == 
                       chtiempaten.getCtanconsulta().intValue()) {
                       contador++;
                   }
               }

           }

           if (contador > 1) {
               existe = true;
           }

           if (existe) {
               rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
               FacesUtils.addErrorMessage("Tiene consultas abiertas, cierrelas o pause las consultas");
           } else {
               navegacionAtenderMisConsultas(usuario, codigoAgenda);
           }
       } else {
           navegacionAtenderMisConsultas(usuario, codigoAgenda);
       }

        return rutaNavegacion;
       
        }

    public void setLstCovidAntigenos(List<Cnconsclin> lstCovidAntigenos) {
        this.lstCovidAntigenos = lstCovidAntigenos;
    }

    public List<Cnconsclin> getLstCovidAntigenos() {
        return lstCovidAntigenos;
    }

    public void setDtCovidAntigenos(HtmlDataTable dtCovidAntigenos) {
        this.dtCovidAntigenos = dtCovidAntigenos;
    }

    public HtmlDataTable getDtCovidAntigenos() {
        return dtCovidAntigenos;
    }
}
