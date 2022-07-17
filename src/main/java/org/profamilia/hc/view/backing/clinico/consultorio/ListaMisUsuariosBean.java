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
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.menus.consultorio.MenuControlIlveBean;
import org.profamilia.hc.view.backing.procedimiento.DatosUsuarioCitologiaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE
//=======================================================================

public class ListaMisUsuariosBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    /** */
    private Date fechaActual;

    /** */
    private List<Cnconsclin> lstUsuarios;

    /** Almacena el usuario  */
    private String usuarioSelect;

    /** Almacena el Bean de Datos de Usuario*/
    DatosBasicosUsuarioBean datosUsuario;

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
    
    private boolean existeProgramacion;

    /** Almacena la edad del usuario*/
    private Integer edad;

    /** Almacena el mensaje si no encuentra registros**/
    private String msg_sin_registros;

    private List menuAdmin;

    private Integer numeroSala;

    private List<SelectItem> lstSala;

    /** Ruta de Navegaci�n */
    private String rutaNavegacion;

    /** Almacena la lista de las consultas que estan en proceso */
    private List lstConsultasProceso;

    private HtmlDataTable dtConsultasProceso;

    private String estadoConsulta;

    private List lstEstado;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ListaMisUsuariosBean() {

    }


    public void init() {
        lstUsuarios = new ArrayList<Cnconsclin>();
        estadoConsulta = "N";

    
        try {
            if(getClinica()!= null && getClinica().getCclncodigo()!= null && getUsuarioSystem()!= null && getUsuarioSystem().getCurnprofes()!= null ){
                numeroSala = this.serviceLocator.getClinicoService().getSalaXservicioProfesional(this.getClinica().getCclncodigo(),userName());    
            }
            
        } catch (ModelException e) {
            e.printStackTrace();
        }
        inicializarLista();
    }

    public void inicializarLista() {
        try {
            lstConsultasProceso = 
                    this.getServiceLocator().getClinicoService().getConsultasProceso(new Date(), 
                                                                                     this.getClinica().getCclncodigo(), 
                                                                                     getUsuarioSystem().getCurnprofes(), 
                                                                                     userName());
        } catch (ModelException e) {
            e.printStackTrace();
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
     * @param lstConsultasProceso
     */
    public void setLstConsultasProceso(List lstConsultasProceso) {
        this.lstConsultasProceso = lstConsultasProceso;
    }

    /**
     * @return
     */
    public List getLstConsultasProceso() {
        return lstConsultasProceso;
    }

    /**
     * @param dtConsultasProceso
     */
    public void setDtConsultasProceso(HtmlDataTable dtConsultasProceso) {
        this.dtConsultasProceso = dtConsultasProceso;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtConsultasProceso() {
        return dtConsultasProceso;
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
     * @param numeroSala
     */
    public void setNumeroSala(Integer numeroSala) {
        this.numeroSala = numeroSala;
    }

    /**
     * @return
     */
    public Integer getNumeroSala() {
        return numeroSala;
    }

    /**
     * @param lstSala
     */
    public void setLstSala(List<SelectItem> lstSala) {
        this.lstSala = lstSala;
    }

    /**
     * @param estadoConsulta
     */
    public void setEstadoConsulta(String estadoConsulta) {
        this.estadoConsulta = estadoConsulta;
    }

    /**
     * @return
     */
    public String getEstadoConsulta() {
        return estadoConsulta;
    }

    /**
     * @param lstEstado
     */
    public void setLstEstado(List lstEstado) {
        this.lstEstado = lstEstado;
    }

    /**
     * @return
     */
    public List getLstEstado() {
        if (lstEstado == null) {
            lstEstado = new ArrayList();
            lstEstado.add(new SelectItem("N", "Nueva"));
            lstEstado.add(new SelectItem("A", "Ausente"));
        }
        return lstEstado;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstSala() {
        List listSalaAux;
        listSalaAux = null;
        
     

        if (lstSala == null || lstSala.isEmpty()) {
            lstSala = new ArrayList<SelectItem>();
          
            try {
                listSalaAux = 
                        this.getServiceLocator().getClinicoService().getSalasEspera(this.getClinica().getCclncodigo(), userName());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            
            lstSala.add(new SelectItem("","--"));
            
            
            if (listSalaAux != null && 
                           !listSalaAux.isEmpty()) {
                           Iterator iter = listSalaAux.iterator();

                           while (iter.hasNext()) {
                               Object[] a = (Object[])iter.next();
                               Integer codigosala = new Integer (a[0].toString());
                               String descrisala = a[1].toString(); 
                               lstSala.add(new SelectItem(codigosala,descrisala ));
                             
                           }
                       }
            
        }
        return lstSala;
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
            if (numeroSala != null) {
                Date fechaActualAux = new Date();

                String DATE_FORMAT = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                String fechaCons = sdf.format(fechaActualAux);

                msg_sin_registros = 
                        IConstantes.NO_EXISTEN_CONSULTAS_PARA_LA_FECHA + 
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


    public String atenderUsuarioProceso() {

        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        datosUsuarioCitologia = 
                (DatosUsuarioCitologiaBean)FacesUtils.getManagedBean("datosUsuarioCitologiaBean");
        existeProgramacion = false;
                  
        this.consultaClone = (Cnconsclin)this.dtConsultasProceso.getRowData();
        Chusuario usuario;
        
        
        if(consultaClone != null && consultaClone.getCconnumero() != null){
            try {
                existeProgramacion = serviceLocator.getCirugiaService().verificarProgramacionCirugia(consultaClone.getCconnumero().longValue());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        
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
        boolean continuar = false;
        boolean validacion = false;
        if(IConstantes.HISTORIA_INTERRUPCION.equals(servicio.getCsvntiphis())){
            try {
                validacion = 
                        this.getServiceLocator().getClinicoService().getConsultaClinicaIVEXUsuario(consultaClone,true);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if(validacion){
                FacesUtils.addInfoMessage("Usuario ya cuenta con consulta de IVE atendida, proceder con la atenci�n de la consulta de planificaci�n");
                rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
            }else {
                continuar = true;
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
                    e.printStackTrace();
                }
                
                if(valdacionIVE){
                    continuar = true;
                }else {
                    FacesUtils.addInfoMessage("Usuario no cuenta con consulta de IVE atendida, proceder con la atenci�n de la consulta IVE");
                    rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
                }
            }else {
                 continuar = true;
             }
        }
        
        
        
        
    if(continuar && !existeProgramacion){
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

    }
    
        else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_FERTILIDAD)) {
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

                 }
                 
        else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_VASECTOMIA)) {
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

                 }

        else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ESPERMOGRAMA_FERTILIDAD)) {
                     resetEspermogramaFertilidad();
                     FacesUtils.resetManagedBean("menuEspermogramaFertilidadBean");
                     DatosBasicosUsuarioBean datosBasicosUsuario = 
                         (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");


                     if (usuario != null) {
                         datosBasicosUsuario.setUsuario(usuario);
                         datosBasicosUsuario.setConsulta(consultaClone);
                         datosBasicosUsuario.inicializarUsuario();
                     }

                     rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ESPERMOGRAMA_FERTILIDAD;

                 }
                 
        else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_MANUAL)) {
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

                 }  


    else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_TEMPORAL)) {
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

    }


    else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_ANTICONCEPCION_TEMPORAL)) {
        resetAnticoncepcionTemporal();
        FacesUtils.resetManagedBean("menuHistoriaControlAnticoncepcionBean");
        DatosBasicosUsuarioBean datosBasicosUsuario = 
            (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");


        if (usuario != null) {
            datosBasicosUsuario.setUsuario(usuario);
            datosBasicosUsuario.setConsulta(consultaClone);
            datosBasicosUsuario.inicializarUsuario();
        }


        rutaNavegacion = 
                BeanNavegacion.RUTA_IR_DATOS_CONTROL_ANTICONCEPCION;

    }

    else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_EXAMEN_MAMA)) {
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

    }

    else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PEDIATRIA)) {
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

    }

    else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PRENATAL)) {

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

    }


    else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_PRENATAL)) {

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


        rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL;

    }
    
    
        else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_FERTILIDAD)) {
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

    else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PROCEDIMIENTOS_CONSULTORIO)) {
        resetProcedimientoConsultorio();
        FacesUtils.resetManagedBean("menuProcedimientoConsultorioBean");
        DatosBasicosUsuarioBean datosBasicosUsuario = 
            (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");


        if (usuario != null) {
            datosBasicosUsuario.setUsuario(usuario);
            datosBasicosUsuario.setConsulta(consultaClone);
            datosBasicosUsuario.inicializarUsuario();
        }


        rutaNavegacion = 
                BeanNavegacion.RUTA_IR_DATOS_PROCEDIMIENTO_CONSULTORIO;

    }


    else if (servicio.getCsvntiphis().equals(IConstantes.APOYO_INFORME_CITOPUNCION)) {
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

    }

    else if (servicio.getCsvntiphis().equals(IConstantes.APOYO_INFORME_ECOGRAFIA)) {
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

    }

    else if (servicio.getCsvntiphis().equals(IConstantes.APOYO_INFORME_HISTEROSONOGRAFIA)) {
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

    }

    else if (servicio.getCsvntiphis().equals(IConstantes.APOYO_INFORME_MAMOGRAFIA)) {
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

    }

    else if (servicio.getCsvntiphis().equals(IConstantes.APOYO_INFORME_MARCACION_SENO)) {
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

    }

    else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA)) {
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

    }

    else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PREANESTESIA)) {
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

    }

    else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_PREANESTESIA)) {
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

    }
    else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PSICOLOGICA)) {
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
    
    }
    
    else if(servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CERVIX)) {
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
    }
    
    
    else if(servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PSICOLOGICA_CONTROL)) {
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
    }
    
    else if(servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ESTERILIZACION_MASCULINA)){
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
                 
             }
             
             
             
    else if(servicio.getCsvntiphis().equals(IConstantes.HISTORIA_INTERRUPCION)){
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
                 
             }
             
             
        else if(servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_INTERRUPCION)){
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
                     
                 }
    
    
    
    else if(servicio.getCsvntiphis().equals(IConstantes.HISTORIA_OTRAS_ESPECIALIDADES)){
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
                 
             }
             
    else if(servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_INSERCION)){
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
                 
             }

        else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_RETIRO)) {
            resetAnticoncepcionTemporal();
            FacesUtils.resetManagedBean("menuHistoriaAnticoncepcionRetiro");
            DatosBasicosUsuarioBean datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

            if (usuario != null) {
                datosBasicosUsuario.setUsuario(usuario);
                datosBasicosUsuario.setConsulta(consultaClone);
                datosBasicosUsuario.inicializarUsuario();
            }

            rutaNavegacion = 
                    BeanNavegacion.RUTA_IR_DATOS_ANTICONCEPCION_RETIRO;

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
        }else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PROCEDIMIENTO_ASOCIADO)) {
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
    }else{
        FacesUtils.addErrorMessage("Existe una programaci�n de cirug�a, si tiene que realiza por este m�dulo, cancele la programaci�n para realizar por esta opci�n (Procedimientos)");
        return BeanNavegacion.RUTA_ACTUAL;     
    }


    return rutaNavegacion;

    }




    /**
     * @return
     */
     public String atenderUsuario() {


         datosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
         datosUsuarioCitologia = 
                 (DatosUsuarioCitologiaBean)FacesUtils.getManagedBean("datosUsuarioCitologiaBean");
         this.consultaClone = (Cnconsclin)this.dtConsultas.getRowData();
         Chusuario usuario;
         usuario = null;
         
         existeProgramacion = false; 
         
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
             e.printStackTrace();
         }

         if (consultaClone.getCcocservic() != null) {
             servicio = consultaClone.getCcocservic();
         }
         
         boolean continuar = false;
         boolean validacion = false;
         if(IConstantes.HISTORIA_INTERRUPCION.equals(servicio.getCsvntiphis())){
             try {
                 validacion = 
                         this.getServiceLocator().getClinicoService().getConsultaClinicaIVEXUsuario(consultaClone,true);
             } catch (ModelException e) {
                 e.printStackTrace();
             }
             if(validacion){
                 FacesUtils.addInfoMessage("Usuario ya cuenta con consulta de IVE atendida, proceder con la atenci�n de la consulta de planificaci�n");
                 rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
             }else {
                 continuar = true;
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
                     e.printStackTrace();
                 }
                 
                 if(valdacionIVE){
                     continuar = true;
                 }else {
                     FacesUtils.addInfoMessage("Usuario no cuenta con consulta de IVE atendida, proceder con la atenci�n de la consulta IVE");
                     rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
                 }
             }else {
                  continuar = true;
              }
         }
         
         
         
         
         if(continuar && !existeProgramacion){
         
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


         if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_QUIRURGICA_FEMENINA)) {

             FacesUtils.resetManagedBean("menuProcesosEsterilizacionBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
             FacesUtils.resetManagedBean("esterFemeninaBean");

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

         }
         
         else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_FERTILIDAD)) {
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

                  }
                  
         else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_FERTILIDAD)) {
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



         else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ANTICONCEPCION_TEMPORAL)) {
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

         }


         else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_ANTICONCEPCION_TEMPORAL)) {
             resetAnticoncepcionTemporal();
             FacesUtils.resetManagedBean("menuHistoriaControlAnticoncepcionBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");


             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }


             rutaNavegacion = 
                     BeanNavegacion.RUTA_IR_DATOS_CONTROL_ANTICONCEPCION;

         }

         else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_EXAMEN_MAMA)) {
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

         }

         else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PEDIATRIA)) {
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

         }

         else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PRENATAL)) {

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

         }


         else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_PRENATAL)) {

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


             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_CONTROL;

         }
         
         else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_FERTILIDAD)) {
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
         
         else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PROCEDIMIENTOS_CONSULTORIO)) {
             resetProcedimientoConsultorio();
             FacesUtils.resetManagedBean("menuProcedimientoConsultorioBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");


             if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }


             rutaNavegacion = 
                     BeanNavegacion.RUTA_IR_DATOS_PROCEDIMIENTO_CONSULTORIO;

         }


         else if (servicio.getCsvntiphis().equals(IConstantes.APOYO_INFORME_CITOPUNCION)) {
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

         }

         else if (servicio.getCsvntiphis().equals(IConstantes.APOYO_INFORME_ECOGRAFIA)) {
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

         }

         else if (servicio.getCsvntiphis().equals(IConstantes.APOYO_INFORME_HISTEROSONOGRAFIA)) {
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

         }

         else if (servicio.getCsvntiphis().equals(IConstantes.APOYO_INFORME_MAMOGRAFIA)) {
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

         }

         else if (servicio.getCsvntiphis().equals(IConstantes.APOYO_INFORME_MARCACION_SENO)) {
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

         }

         else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA)) {
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

         }

         else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PREANESTESIA)) {
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

         }

         else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_PREANESTESIA)) {
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

         }
         else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PSICOLOGICA)) {
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
         
         }
         
         else if(servicio.getCsvntiphis().equals(IConstantes.HISTORIA_CERVIX)) {
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
         }
         
         
         else if(servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PSICOLOGICA_CONTROL)) {
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

             FacesUtils.resetManagedBean("menuHistoriaVacunacionCervixBean");
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
            
              if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_VACUNACION_CERVIX;
         } else if(servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ESTERILIZACION_MASCULINA)){
             FacesUtils.resetManagedBean("menuHistoriaEsterilizacionMasculina");
             resetEsterilizacionMasculina();
             DatosBasicosUsuarioBean datosBasicosUsuario = 
                 (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
             
              if (usuario != null) {
                 datosBasicosUsuario.setUsuario(usuario);
                 datosBasicosUsuario.setConsulta(consultaClone);
                 datosBasicosUsuario.inicializarUsuario();
             }

             rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ESTERILIZACION_MASCULINA;
             
         }
         else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_ESPERMOGRAMA_FERTILIDAD)) {
                      resetEspermogramaFertilidad();
                      FacesUtils.resetManagedBean("menuEspermogramaFertilidadBean");
                      DatosBasicosUsuarioBean datosBasicosUsuario = 
                          (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");


                      if (usuario != null) {
                          datosBasicosUsuario.setUsuario(usuario);
                          datosBasicosUsuario.setConsulta(consultaClone);
                          datosBasicosUsuario.inicializarUsuario();
                      }

                      rutaNavegacion = BeanNavegacion.RUTA_IR_DATOS_ESPERMOGRAMA_FERTILIDAD;

                  }


        else if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_MANUAL)) {
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
         }else {
            rutaNavegacion = BeanNavegacion.RUTA_ACTUAL;
            FacesUtils.addErrorMessage(ERROR_SERICIO_NO_ASOCIADO);
        }
      }else{
        FacesUtils.addErrorMessage("Existe una programaci�n de cirug�a, si tiene que realiza por este m�dulo, cancele la programaci�n para realizar por esta opci�n (Procedimientos)");
        return BeanNavegacion.RUTA_ACTUAL;     
    }



         return rutaNavegacion;

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

    }
    
    private void resetConfirmacionHistoria(){
        FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
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
    
    private void resetHistoriaCervix(){
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
        FacesUtils.resetManagedBean("examenFisicoUsuarioBean");
        FacesUtils.resetManagedBean("impresionDiagnosticaUsuarioBean");
        FacesUtils.resetManagedBean("motivoBean");

        FacesUtils.resetManagedBean("antecedentePrenatalUsuarioBean");
        FacesUtils.resetManagedBean("gestacionControlPranatalUsuarioBean");
        FacesUtils.resetManagedBean("gestacionPrenatalUsuarioBean");
        FacesUtils.resetManagedBean("tamizajeControlPrenatalUsuarioBean");
        FacesUtils.resetManagedBean("tamizajePrenatalUsuarioBean");

    }

    private void resetControl() {
        resetConducta();
        FacesUtils.resetManagedBean("antecedentesGeneralesUsuarioBean");
        FacesUtils.resetManagedBean("antecedentesUsuarioBean");
        FacesUtils.resetManagedBean("cerrarConsultaUsuarioBean");
        FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
        FacesUtils.resetManagedBean("examenFisicoUsuarioBean");
        FacesUtils.resetManagedBean("impresionDiagnosticaUsuarioBean");
        FacesUtils.resetManagedBean("motivoBean");
        FacesUtils.resetManagedBean("controlUsuarioBean");
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
        FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
        FacesUtils.resetManagedBean("informeCitopuncionSenoBean");
        FacesUtils.resetManagedBean("cerrarConsultaUsuarioBean");
        FacesUtils.resetManagedBean("resumenHistoriaEspecificaBean");
        FacesUtils.resetManagedBean("menuInformeCitopuncionBean");
    }

    private void resetInformeEcografia() {
        FacesUtils.resetManagedBean("cerrarConsultaUsuarioBean");
        FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
        FacesUtils.resetManagedBean("resumenHistoriaEspecificaBean");
        FacesUtils.resetManagedBean("informeEcografiaBean");
        FacesUtils.resetManagedBean("menuInformeEcografiaBean");
    }

    private void resetInformeHisterosonografia() {
        FacesUtils.resetManagedBean("cerrarConsultaUsuarioBean");
        FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
        FacesUtils.resetManagedBean("resumenHistoriaEspecificaBean");
        FacesUtils.resetManagedBean("informeHisterosonografiaBean");
        FacesUtils.resetManagedBean("menuInformeHisterosonografiaBean");
    }

    private void resetInformeMamografia() {
        FacesUtils.resetManagedBean("cerrarConsultaUsuarioBean");
        FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
        FacesUtils.resetManagedBean("resumenHistoriaEspecificaBean");
        FacesUtils.resetManagedBean("informeMamografiaBean");
        FacesUtils.resetManagedBean("menuInformeMamografiaBean");
    }

    private void resetInformeMarcacionSeno() {
        FacesUtils.resetManagedBean("cerrarConsultaUsuarioBean");
        FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
        FacesUtils.resetManagedBean("resumenHistoriaEspecificaBean");
        FacesUtils.resetManagedBean("informeMarcacionSenoBean");
        FacesUtils.resetManagedBean("menuInformeMarcacionSenoBean");
    }

    private void resetProcedimientoCitologia() {
        FacesUtils.resetManagedBean("cerrarConsultaUsuarioBean");
        FacesUtils.resetManagedBean("datosUsuarioCitologiaBean");
        FacesUtils.resetManagedBean("tomaCitologiaBean");
        FacesUtils.resetManagedBean("menuTomaCitologiaBean");
    }

    private void resetHistoriaPsicologia() {

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
    
    
    private void resetDermatologia(){
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
    
    
    private void resetInterrupcion(){
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
        
    }
    
    
    private void resetEsterilizacionMasculina(){
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
    
    private void resetEsterilizacionFemenina(){
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

    private void resetEspermogramaFertilidad() {
        FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
        FacesUtils.resetManagedBean("espermogramaFertilidadBean");

    }


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
        if (fechaActual != null && getClinica() != null) {

            try {
                this.lstUsuarios = 
                        this.serviceLocator.getClinicoService().getConsultasDiaProfesional(fechaActual, 
                                                                                           getUsuarioSystem().getCurnprofes(), 
                                                                                           getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
                ;
            }
        }
    }
    
    

    public void obtenerConsulta() {
        // Si la consulta que se esta buscando es la nueva
        if (estadoConsulta != null && estadoConsulta.equals("N")) {
            try {
                this.lstUsuarios = 
                        this.serviceLocator.getClinicoService().getConsultasProfesionalBySala(new Date(), 
                                                                                        getUsuarioSystem().getCurnprofes(), 
                                                                                        getClinica().getCclncodigo(), 
                                                                                        numeroSala);
            } catch (ModelException e) {
                e.printStackTrace();
            }

        } 
            // Si la consulta que se esta buscando es ausente
            else if (estadoConsulta != null && estadoConsulta.equals("A")) {

            try {
                this.lstUsuarios = 
                        this.serviceLocator.getClinicoService().getConsultasAusentes(new Date(), 
                                                                                     this.getClinica().getCclncodigo(), 
                                                                                     getUsuarioSystem().getCurnprofes(), 
                                                                                     userName(),numeroSala);
            } catch (ModelException e) {
                e.printStackTrace();
            }

        }


    }

}
