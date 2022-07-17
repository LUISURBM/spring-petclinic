//=======================================================================
// ARCHIVO ReferenciaUsuarioBean.java
// FECHA CREACI�N: 02/08/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a la referncia.
//=======================================================================

package org.profamilia.hc.view.backing.comun.conducta;

import java.math.BigDecimal;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chexamfisico;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chreferencia;
import org.profamilia.hc.model.dto.ChreferenciaPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpdepadane;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.clinico.comun.Cie10Bean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorProfesionalBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//==============================================================================
//  CLASE ReferenciaUsuarioBean
//==============================================================================

public class ReferenciaUsuarioBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    private static int NUMERO_REFERENCIAS = 1;

    private int index = -1;

    private boolean generoReferencia;

    private boolean modoconsulta;

    /** Almacena el objeto a perisistir*/
    private Chreferencia referencia;

    private boolean esCirugia;

    private Long numeroUsuario;

    private String tipoServicio;

    private Integer consecutivo;

    private String tensionArterial;

    private Integer frecuenciaCardiaca;

    private Integer frecuenciaRespiratoria;

    private BigDecimal peso;

    private String hallazgos;

    private BigDecimal temperatura;
    
    /** Lista que almacena la lista de  Departamentos  */
    private List<SelectItem> listDepartamentos;

    /** Lista que almacena la lista de  Ciudades */
    private List<SelectItem> listMunicipios;
    
   /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;
    
    private Chimprdiag impresion; 
    
    private List lstOpciones;
    
    private Cnconsclin consultaAux; 
    
   
    private Chexamfisico examenfisico; 
    
    private Chimprdiag impresionDiagnostica; 

    private boolean mostrarCie10;
    
    private int selectedIndex;
    
    private UIInput inputDiagnostico;
    
    private String diagnostico;

    private Crdgncie10 diagrela1;

    static final int ACTIVAR_REFERENCIA = 0;

    static final int ACTIVAR_BUSCADOR = 1;
    
    static final int ACTIVAR_BUSCADOR_PROFESIONAL = 2;

    
    
    Date FECHA_REFERENCIA;
    String ANAMNESIS = "";
    String EVOLUCION = "";

    String HALLAZGOS_EXAMEN_FISICO_REFERENCIA = "";
    String APOYO_DIAGNOSTICO = "";
    String DIAGNOSTICO;
    String COMPLICACIONES;
    String TRATAMIENTOS;
    String MOTIVO;
    String ESPECIALIDAD; 
    String SERVICIO_SOLICITA;
    String LUGAR_PACIENTE;
    String NOMBRE_PROFESIONAL;
    String FIJO_PROFESIONAL;
    String CELULAR_PROFESIONAL;
    String FIJO_RESPONSABLE;
    String CELULAR_RESPONSABLE;
    String DIRECCION_RESPONSABLE;
    String MUNICIPIO_RESPONSABLE;
    String DEPARTAMENTO_RESPONSABLE;
    String TIPO_IDEN_RESPON;
    String NUMERO_IDEN_RESP;
    String NOMBRE_RESPONSABLE;
    String ENTIDAD_PACIENTE;
    String CODIGO_ENTIDAD;
    String REGIMEN_PACIENTE;
    String FIJO_PACIENTE;
    String CELUAR_PACIENTE;
    String CORREO_PACIENTE;
    String DIRECCION_PACIENTE;
    String MUNICIPIO_PACIENTE;
    String DEPARTAMENTO_PACIENTE;
    String TIPO_IDEN_PACIENTE;
    String NUM_IDE_PACIENTE;
    String FECHA_NAC_PACIENTE;
    String NOMBRE_PACIENTE;
    String MAIL_PRESTADOR;
    String MUNICIPIO_PRESTADOR;
    String DPTO_PRESTADOR;
    String TEL_PRESTADOR;
    String CODIGO_PRESTADOR;
    String DIRECCION_PRESTADOR;
    String NOMBRE_PROFESIONAL_COMPLETO;
    String REGISTRO_MEDICO;
    String CORREO_PRESTADOR;
    String PREGUNTA_DILIGENCIA_FORMATO;
    String PREGUNTA_COPIA_HISTORIA;
    String PREGUNTA_RESUL_APOYO;
    String PREGUNTA_CARTA_PAGO;
    
    String EPS = ""; 
    String TIPOID_PROFESIONAL;
    BigDecimal NUMID_PROFESIONAL;

  
    /** Almacena el consulta */
    private Long numeroConsulta;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private String menuBean;
    
    private List lstInformacionClinica;
    
    private boolean renderMorbilidad;
    
    private Cpprofesio profesionalSelect;
    
    private boolean renderProfesional;
    
    static final int ACTIVAR_BEAN = 0;
    
    private BuscadorProfesionalBean buscadorProfesionalBean;
    
    private boolean renderHistoriasValidas;
    
    private Chconsulta consultaClinica;
    
    private Chcirugprogr cirugiaProgramada;
    

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ReferenciaUsuarioBean() {

    }

    //ACTIONS  

    public void init() {

        
        modoconsulta = false;
        inicializarReferencia();
    }

    public void inicializarReferencia() {
        generoReferencia = false;
        renderMorbilidad= false;
        renderProfesional = false;
        renderHistoriasValidas = false;
        profesionalSelect =  new Cpprofesio();
        listMunicipios = new ArrayList<SelectItem>(); 
        lstInformacionClinica = new ArrayList();

        try{
            if(numeroConsulta != null){
             consultaClinica  =  this.getServiceLocator().getClinicoService().getConsultaActual(numeroConsulta);
             
            cirugiaProgramada =  this.getServiceLocator().getCirugiaService().getCirugiaPorId(numeroConsulta);
            }
        
        }catch (ModelException e) {
            e.printStackTrace();
        }  
        if (consultaClinica != null && 
            consultaClinica.getHcocservicio().getCsvntiphis() != null) {
            if (consultaClinica.getHcocservicio().getCsvntiphis().equals(IConstantes.CIRUGIA_IVE) || 
                consultaClinica.getHcocservicio().getCsvntiphis().equals(IConstantes.HISTORIA_PRENATAL) || 
                consultaClinica.getHcocservicio().getCsvntiphis().equals(IConstantes.CIRUGIA_PROCEDIMIENTO_CONSULTORIO_IVE)) {

                renderHistoriasValidas = true;
            }
        }
        
        if(cirugiaProgramada!= null && cirugiaProgramada.getChdetacirpros()!= null && !cirugiaProgramada.getChdetacirpros().isEmpty()){
            Chdetacirpro detalle = null; 
            Iterator it = cirugiaProgramada.getChdetacirpros().iterator(); 
            while(it.hasNext()){
                detalle = (Chdetacirpro)it.next(); 
                
                if(detalle!= null && detalle.getId()!= null && detalle.getId().getHdccservicio() != null){
                    Cpservicio servicio;
                    servicio = null; 
                    try {
                        servicio = this.serviceLocator.getClinicoService().getServicioPorId(detalle.getId().getHdccservicio());
                    } catch (ModelException e) {
                       e.printStackTrace();
                    }
                    if (servicio.getCsvntiphis().equals(IConstantes.CIRUGIA_IVE) || 
                        servicio.getCsvntiphis().equals(IConstantes.HISTORIA_PRENATAL) || 
                        servicio.getCsvntiphis().equals(IConstantes.CIRUGIA_PROCEDIMIENTO_CONSULTORIO_IVE)) {

                        renderHistoriasValidas = true;
                    }
                    
                }
            }
        }

        try {

            referencia = 
                    this.getServiceLocator().getClinicoService().getReferencia(numeroConsulta, 
                                                                               tipoServicio, 
                                                                               consecutivo);
                                                                               
       

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (referencia == null) {
            referencia = new Chreferencia();
            
            if(usuario != null && usuario.getHuslnumero() != null){
                try {
                    examenfisico = serviceLocator.getClinicoService().getUltimoExamenFisicoUsuario(usuario.getHuslnumero());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                
                
                try {
                    impresionDiagnostica = serviceLocator.getClinicoService().getUltimoImpresionDiagnosticaUsuario(usuario.getHuslnumero());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
            
            
            if(examenfisico != null){
            
                
                referencia.setHrecexamfisc(resumenExamenFisico(examenfisico));
            }
            
            if(impresionDiagnostica != null){
                referencia.setHrecdiagnosti(impresionDiagnostica.getHidcdiagprin());
                
                
                if (referencia.getHrecdiagnosti() != null && !referencia.getHrecdiagnosti().equals("")) {
                    try {
                        diagrela1 = 
                                this.serviceLocator.getClinicoService().getCIE10PorCodigo(referencia.getHrecdiagnosti().toUpperCase());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (diagrela1 != null && diagrela1.getCdcccodigo() != null) {
                        diagnostico = diagrela1.getCdccdescri();
                    }
                }
            }
            
            
            
            if(tipoServicio != null  && tipoServicio.equals("C") ){
                referencia.setHrecserviencu("Consulta Externa");
            }else{
                referencia.setHrecserviencu("Cirugia");
            }
            
            modoconsulta = false;
        } else {
            setCiudad();
            
            if (referencia.getHrecdiagnosti() != null && !referencia.getHrecdiagnosti().equals("")) {
                try {
                    diagrela1 = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(referencia.getHrecdiagnosti().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagrela1 != null && diagrela1.getCdcccodigo() != null) {
                    diagnostico = diagrela1.getCdccdescri();
                }
            }
            
            
            modoconsulta = true;
            
            if("S".equals(referencia.getHrecmormatext())) {
                renderMorbilidad= true;
            }
        

        }
    }


    //-----------------------------------------------------------------------
    //  Construir Reporte
    //-----------------------------------------------------------------------

    public void obtenerDatosReporteConsulta() {
     obtenerDatos();
 }
 
 
 private void obtenerDatos(){
     if(referencia != null  && referencia.getHredfecregistr() != null){
         FECHA_REFERENCIA = referencia.getHredfecregistr();
     }
     
     CODIGO_PRESTADOR = " C�DIGO DE PRESTADOR:  "; 
     DIRECCION_PRESTADOR  = " DIRECCI�N:  "; 
     MUNICIPIO_PRESTADOR = " MUNICIPIO:  "; 
     DPTO_PRESTADOR = " DEPARTAMENTO:  "; 
     TEL_PRESTADOR = " TEL�FONO:  "; 
     NOMBRE_PACIENTE = " NOMBRE COMPLETO DEL PACIENTE: "; 
     TIPO_IDEN_PACIENTE = " TIPO IDENTIFICACI�N:  "; 
     NUM_IDE_PACIENTE = " N�MERO DE IDENTIFICACI�N: "; 
     FECHA_NAC_PACIENTE = " FECHA DE NACIMIENTO: "; 
     DIRECCION_PACIENTE = " DIRECCI�N: "; 
     MUNICIPIO_PACIENTE = " MUNICIPIO: "; 
     DEPARTAMENTO_PACIENTE = " DEPARTAMENTO: "; 
     FIJO_PACIENTE = " TEL�FONO FIJO: "; 
     CELUAR_PACIENTE = " TEL�FONO CELULAR: "; 
     CORREO_PACIENTE = " CORREO ELECTR�NICO: ";
     ENTIDAD_PACIENTE = " ENTIDAD RESPONSABLE DEL PAGO:: "; 
     CODIGO_ENTIDAD = "CODIGO";
     REGIMEN_PACIENTE = " C�DIGO: "; 
     NOMBRE_RESPONSABLE = " NOMBRE: "; 
     TIPO_IDEN_RESPON = " TIPO IDENTIFICACI�N: "; 
     NUMERO_IDEN_RESP = " N�MERO DE IDENTIFICACI�N: "; 
     DIRECCION_RESPONSABLE = " DIRECCI�N: "; 
     MUNICIPIO_RESPONSABLE = " MUNICIPIO: "; 
     DEPARTAMENTO_RESPONSABLE = " DEPARTAMENTO: "; 
     FIJO_RESPONSABLE = " TEL�FONO FIJO: "; 
     CELULAR_RESPONSABLE = " TEL�FONO CELULAR: "; 
     NOMBRE_PROFESIONAL = " NOMBRE DEL PROFESIONAL: "; 
     FIJO_PROFESIONAL = " TEL�FONO FIJO: "; 
     CELULAR_PROFESIONAL  = " TEL�FONO CELULAR: ";      
     LUGAR_PACIENTE = ""; 
     SERVICIO_SOLICITA = ""; 
     ANAMNESIS = "ANAMNESIS: "; 
     HALLAZGOS_EXAMEN_FISICO_REFERENCIA  = " EX�MEN F�SICO: "; 
     APOYO_DIAGNOSTICO  = ""; 
     DIAGNOSTICO = " DIAGN�STICO: "; 
     COMPLICACIONES = " COMPLICACIONES: "; 
     TRATAMIENTOS = " TRATAMIENTOS APLICADOS:  "; 
     MOTIVO = " MOTIVO DE REMISI�N: "; 
     ESPECIALIDAD = "";
     NOMBRE_PROFESIONAL_COMPLETO = " NOMBRE COMPLETO Y REGISTRO DEL PROFESIONAL QUE REMITE: "; 
     MAIL_PRESTADOR = " CORREO ELECTR�NICO: "; 
     PREGUNTA_DILIGENCIA_FORMATO = ""; 
     PREGUNTA_COPIA_HISTORIA = ""; 
     PREGUNTA_RESUL_APOYO = ""; 
     PREGUNTA_CARTA_PAGO = ""; 
     TIPOID_PROFESIONAL="";
     NUMID_PROFESIONAL= new BigDecimal(0);
     Crdgncie10 diagprin = null;
     Crdgncie10 diagrela1 = null;
     Crdgncie10 diagrela2 = null;
     Crdgncie10 diagrela3 = null;
     
     
     
     
     CODIGO_PRESTADOR = CODIGO_PRESTADOR + getClinica().getCclccodsgs() ; 
     DIRECCION_PRESTADOR  = DIRECCION_PRESTADOR + getClinica().getCclcdirecc(); 
     MUNICIPIO_PRESTADOR = MUNICIPIO_PRESTADOR + getClinica().getCclcciudad(); 
     TEL_PRESTADOR = TEL_PRESTADOR + getClinica().getCclctelefo(); 
     MAIL_PRESTADOR = MAIL_PRESTADOR + getClinica().getCclccorreo();
     
     FIJO_PROFESIONAL = FIJO_PROFESIONAL + getClinica().getCclctelefo();
     
  
     
     
     if (userName() != null) {
         Cpprofesio profesional;
         profesional = null;
         try {
             if (this.getClinica() != null) {
                 profesional = 
                         serviceLocator.getClinicoService().getProfesionalPorUsuario(userName(), 
                                                                                    getClinica().getCclncodigo());
             }

         } catch (ModelException e) {
             e.printStackTrace();
         }

         if (profesional != null) {
             NOMBRE_PROFESIONAL = NOMBRE_PROFESIONAL + profesional.getCpfcnombre();
             REGISTRO_MEDICO = profesional.getCpfcregmedic();
             NOMBRE_PROFESIONAL_COMPLETO = NOMBRE_PROFESIONAL_COMPLETO  + profesional.getCpfcnombre() + "  RM: " + profesional.getCpfcregmedic();
             ESPECIALIDAD  = ESPECIALIDAD + getNombreTipoEspecialidad(profesional.getCpfntipoespe());
             TIPOID_PROFESIONAL = profesional.getCpfctipide();
             NUMID_PROFESIONAL = profesional.getCpfacedula();
         }
     }
     
     
     if(numeroConsulta != null){


         try {
             impresion = serviceLocator.getClinicoService().getImresionDiagnostica(numeroConsulta,1);
             
              if(referencia.getHrecdiagnosti()!= null){
             
                 
                 DIAGNOSTICO = referencia.getHrecdiagnosti();
                 
             }
             
         } catch (ModelException e) {
             e.printStackTrace();
         }
         
      
         
     }


     if(referencia.getHrecserviencu()!= null){
                LUGAR_PACIENTE = referencia.getHrecserviencu(); 
     }
     
     if(referencia.getHrecservisolic()!= null){
         SERVICIO_SOLICITA = referencia.getHrecservisolic();    
     }
     
     if(referencia.getHrecexamfisc()!= null){
         HALLAZGOS_EXAMEN_FISICO_REFERENCIA = referencia.getHrecexamfisc();    
     }
     
     COMPLICACIONES =  referencia.getHreccomplicaci(); 
     TRATAMIENTOS =  referencia.getHrectrataaplic(); 
     MOTIVO =  referencia.getHrecmotivremis(); 
     


     if (usuario != null) {
      

         if (usuario.getHuscprimernomb() != null) {
             NOMBRE_PACIENTE = NOMBRE_PACIENTE  + usuario.getHuscprimernomb() + " ";
         }
         if (usuario.getHuscsegundnomb() != null && 
             !usuario.getHuscsegundnomb().equals("_")) {
             NOMBRE_PACIENTE = 
                     NOMBRE_PACIENTE + usuario.getHuscsegundnomb() + " ";
         }
         if (usuario.getHuscprimerapel() != null) {
             NOMBRE_PACIENTE = 
                     NOMBRE_PACIENTE + usuario.getHuscprimerapel() + " ";
         }
         if (usuario.getHuscsegundapel() != null && 
             !usuario.getHuscsegundapel().equals("_")) {
             NOMBRE_PACIENTE = 
                     NOMBRE_PACIENTE + usuario.getHuscsegundapel();
         }
         if (usuario.getHusetipoiden() != null) {
             TIPO_IDEN_PACIENTE = TIPO_IDEN_PACIENTE + usuario.getHusetipoiden().toString();
         }
         if (usuario.getHusanumeiden() != 0) {
             NUM_IDE_PACIENTE = NUM_IDE_PACIENTE + usuario.getHusanumeiden().toString();
         }
      
      
         DIRECCION_PACIENTE = DIRECCION_PACIENTE + usuario.getHuscdireccion();
         
        
        if(usuario.getHusdfechanacim() != null) {
            FECHA_NAC_PACIENTE  = FECHA_NAC_PACIENTE + usuario.getHusdfechanacim(); 
        }
       
       
       if(usuario.getHusctelefono() != null){
           FIJO_PACIENTE  = FIJO_PACIENTE  + usuario.getHusctelefono();
       }
         
        if(usuario.getHusccelular() != null) {
            CELUAR_PACIENTE = CELUAR_PACIENTE +  usuario.getHusccelular();
        }
      
        if(usuario.getHusccorreoelec() != null)  {
            CORREO_PACIENTE = CORREO_PACIENTE  + usuario.getHusccorreoelec() ;
        }
        
         if(usuario.getHuscentidadadm() != null){
             try {
                EPS  = serviceLocator.getClinicoService().getDescripcionEntidadByCodigo(usuario.getHuscentidadadm());
             } catch (ModelException e) {
                 e.printStackTrace();
             }
         }
          
     
        
         if(numeroConsulta != null){
             ENTIDAD_PACIENTE = ENTIDAD_PACIENTE + nombrecontratoxconsulta(numeroConsulta);
             CODIGO_ENTIDAD = CODIGO_ENTIDAD + " " + codigocontratoxconsulta(numeroConsulta);
         }
         
         
         if(usuario.getHusetipoafilia() != null){
             if(usuario.getHusetipoafilia().equals("C")){
                 REGIMEN_PACIENTE = REGIMEN_PACIENTE + "CONTRIBUTIVO"; 
             }else if(usuario.getHusetipoafilia().equals("E")){
                 REGIMEN_PACIENTE = REGIMEN_PACIENTE + "ESPECIAL"; 
             }else if(usuario.getHusetipoafilia().equals("R")){
                 REGIMEN_PACIENTE = REGIMEN_PACIENTE + "SUBSIDIO PARCIAL"; 
             }else if(usuario.getHusetipoafilia().equals("S")){
                 REGIMEN_PACIENTE = REGIMEN_PACIENTE + "SUBSIDIADO"; 
             }else if(usuario.getHusetipoafilia().equals("V")){
                 REGIMEN_PACIENTE = REGIMEN_PACIENTE + "VINCULADO"; 
             }else if(usuario.getHusetipoafilia().equals("X")){
                 REGIMEN_PACIENTE = REGIMEN_PACIENTE + "NINGUNO"; 
             }
         }
          
         PREGUNTA_DILIGENCIA_FORMATO = referencia.getHrecdiligforma();
         PREGUNTA_COPIA_HISTORIA = referencia.getHreccopiahisto();
         PREGUNTA_RESUL_APOYO  = referencia.getHrecresulapoyo();
         PREGUNTA_CARTA_PAGO = referencia.getHreccartapago();
         
         
         
         Integer idMunicipio = usuario.getHusnciudad();
         Integer idDpto = usuario.getHusndepartamen();
         Cpmunidane municipio = null;


         try {
             municipio = 
                     this.serviceLocator.getClinicoService().getMunicipio(idMunicipio, 
                                                                          idDpto);
         } catch (ModelException e) {
             e.printStackTrace();
         }

         if (municipio != null) {
             MUNICIPIO_PACIENTE = MUNICIPIO_PACIENTE + municipio.getCmdcnommun();
         }
         
         if(municipio != null && municipio.getCmdcnommun() != null){
             DEPARTAMENTO_PACIENTE = DEPARTAMENTO_PACIENTE + municipio.getCmdcnomdpt();
         }
     }

     if (referencia != null && referencia.getHrecanamnesis() != null) {
         ANAMNESIS = ANAMNESIS + referencia.getHrecanamnesis();
     }
     if (referencia != null && referencia.getHrecapoyodiagn() != null) {
         APOYO_DIAGNOSTICO = APOYO_DIAGNOSTICO + referencia.getHrecapoyodiagn();
     }
     
     if (referencia != null && referencia.getHrecapoyodiagn() != null) {
         EVOLUCION = EVOLUCION + referencia.getHrecjustirefer();
     }


     

     if (referencia != null && referencia.getHrecnombrespon() != null) {
         NOMBRE_RESPONSABLE =  NOMBRE_RESPONSABLE + referencia.getHrecnombrespon();
     }
     if (referencia != null && referencia.getHrecdirecrespo() != null) {
         DIRECCION_RESPONSABLE = DIRECCION_RESPONSABLE + referencia.getHrecdirecrespo();
     }
     if (referencia != null && referencia.getHrectelefrespo() != null) {
      FIJO_RESPONSABLE= FIJO_RESPONSABLE + referencia.getHrectelefrespo();
     }
     
     if (referencia != null && referencia.getHreccelulrespo() != null) {
      CELULAR_RESPONSABLE= CELULAR_RESPONSABLE + referencia.getHreccelulrespo();
     }
     
     
     if(referencia != null && referencia.getHreetipideresp() != null){
         TIPO_IDEN_RESPON = TIPO_IDEN_RESPON + referencia.getHreetipideresp();
     }
     
     if(referencia != null && referencia.getHrectiporefere() != null){
         NUMERO_IDEN_RESP = NUMERO_IDEN_RESP +  referencia.getHreanumideresp();
     }
     
     
     
     Integer idMunicipioResp = referencia.getHrenciudarespo();
     Integer idDptoResp = referencia.getHrendeparrespo();
     Cpmunidane municipioResp = null;


     try {
         municipioResp = 
                 this.serviceLocator.getClinicoService().getMunicipio(idMunicipioResp, 
                                                                      idDptoResp);
     } catch (ModelException e) {
         e.printStackTrace();
     }

     if (municipioResp != null) {
         MUNICIPIO_RESPONSABLE= MUNICIPIO_RESPONSABLE + municipioResp.getCmdcnommun();
     }
     
     if(municipioResp != null && municipioResp.getCmdcnommun() != null){
         DEPARTAMENTO_RESPONSABLE = DEPARTAMENTO_RESPONSABLE + municipioResp.getCmdcnomdpt();
     }

     lstInformacionClinica.add("ANAMNESIS: "+ANAMNESIS + "\n");
     lstInformacionClinica.add("EXAMEN FISICO:  " +HALLAZGOS_EXAMEN_FISICO_REFERENCIA + "\n");
     lstInformacionClinica.add("EX�MENES DE APOYO DIAGN�STICO: " + APOYO_DIAGNOSTICO + "\n");
     lstInformacionClinica.add("EVOLUCI�N: " + EVOLUCION+ "\n");
     lstInformacionClinica.add("DIAGN�STICO: " +DIAGNOSTICO + "\n");
     lstInformacionClinica.add("COMPLICACIONES: " + COMPLICACIONES + "\n");
     lstInformacionClinica.add("TRATAMIENTOS APLICADOS: " +TRATAMIENTOS + "\n");
     lstInformacionClinica.add("MOTIVO DE REMISI�N: "+ MOTIVO + "\n");

    
 }


    public void obtenerDatosReporteCirugia() {
        obtenerDatos();   
    }
    
    

    public Object getFieldValue(JRField jrField) {
        Object value = null;
        String fieldName = jrField.getName();
        if (fieldName.equals("FECHA_REFERENCIA")) {
            value = FECHA_REFERENCIA;
        } else if (fieldName.equals("ANAMNESIS")) {
            value = ANAMNESIS;
        }  else if (fieldName.equals("SERVICIO_SOLICITA")) {
            value = SERVICIO_SOLICITA ;
        } else if (fieldName.equals("LUGAR_PACIENTE")) {
            value =  LUGAR_PACIENTE;
        } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
            value = NOMBRE_PROFESIONAL;
        } else if (fieldName.equals("FIJO_PROFESIONAL")) {
            value = FIJO_PROFESIONAL;
        } else if (fieldName.equals("CELULAR_PROFESIONAL")) {
            value =CELULAR_PROFESIONAL;
        } else if (fieldName.equals("FIJO_RESPONSABLE")) {
            value =  FIJO_RESPONSABLE;
        } else if (fieldName.equals("CELULAR_RESPONSABLE")) {
            value = CELULAR_RESPONSABLE ;
        } else if (fieldName.equals("DIRECCION_RESPONSABLE")) {
            value = DIRECCION_RESPONSABLE;
        } else if (fieldName.equals("MUNICIPIO_RESPONSABLE")) {
            value =MUNICIPIO_RESPONSABLE ;
        } else if (fieldName.equals("DEPARTAMENTO_RESPONSABLE")) {
            value = DEPARTAMENTO_RESPONSABLE ;
        } else if (fieldName.equals("TIPO_IDEN_RESPON")) {
            value = TIPO_IDEN_RESPON ;
        } else if (fieldName.equals("NUMERO_IDEN_RESP")) {
            value = NUMERO_IDEN_RESP;
        } else if (fieldName.equals("NOMBRE_RESPONSABLE")) {
            value =  NOMBRE_RESPONSABLE;
        } else if (fieldName.equals("ENTIDAD_PACIENTE")) {
            value = ENTIDAD_PACIENTE;
        } else if (fieldName.equals("REGIMEN_PACIENTE")) {
            value = REGIMEN_PACIENTE;
        } else if (fieldName.equals("FIJO_PACIENTE")) {
            value = FIJO_PACIENTE ;
        } else if (fieldName.equals("CELUAR_PACIENTE")) {
            value = CELUAR_PACIENTE ;
        } else if (fieldName.equals("CORREO_PACIENTE")) {
            value = CORREO_PACIENTE;
        } else if (fieldName.equals("DIRECCION_PACIENTE")) {
            value = DIRECCION_PACIENTE ;
        } else if (fieldName.equals("MUNICIPIO_PACIENTE")) {
            value = MUNICIPIO_PACIENTE;
        } else if (fieldName.equals("DEPARTAMENTO_PACIENTE")) {
            value = DEPARTAMENTO_PACIENTE;
        } else if (fieldName.equals("TIPO_IDEN_PACIENTE")) {
            value = TIPO_IDEN_PACIENTE;
        } else if (fieldName.equals("NUM_IDE_PACIENTE")) {
            value = NUM_IDE_PACIENTE;
        } else if (fieldName.equals("FECHA_NAC_PACIENTE")) {
            value = FECHA_NAC_PACIENTE ;
        } else if (fieldName.equals("NOMBRE_PACIENTE")) {
            value =  NOMBRE_PACIENTE;
        } else if (fieldName.equals("MAIL_PRESTADOR")) {
            value = MAIL_PRESTADOR ;
        } else if (fieldName.equals("MUNICIPIO_PRESTADOR")) {
            value = MUNICIPIO_PRESTADOR;
        } else if (fieldName.equals("DPTO_PRESTADOR")) {
            value =  DPTO_PRESTADOR;
        } else if (fieldName.equals("TEL_PRESTADOR")) {
            value = TEL_PRESTADOR ;
        } else if (fieldName.equals("CODIGO_PRESTADOR")) {
            value = CODIGO_PRESTADOR;
        } else if (fieldName.equals("DIRECCION_PRESTADOR")) {
            value = DIRECCION_PRESTADOR ;
        } else if (fieldName.equals("NOMBRE_PROFESIONAL_COMPLETO")) {
            value =NOMBRE_PROFESIONAL_COMPLETO ;
        }else if (fieldName.equals("PREGUNTA_DILIGENCIA_FORMATO")) {
            value =PREGUNTA_DILIGENCIA_FORMATO ;
        }else if (fieldName.equals("PREGUNTA_COPIA_HISTORIA")) {
            value =PREGUNTA_COPIA_HISTORIA ;
        }else if (fieldName.equals("PREGUNTA_RESUL_APOYO")) {
            value =PREGUNTA_RESUL_APOYO ;
        }else if (fieldName.equals("PREGUNTA_CARTA_PAGO")) {
            value =PREGUNTA_CARTA_PAGO ;
        }else if (fieldName.equals("INFORMACION_CLINICA")) {
            value =lstInformacionClinica.get(index) ;
        }else if (fieldName.equals("TIPO_INFORMACION")) {
            value =index;
        }else if (fieldName.equals("ESPECIALIDAD")) {
            value =ESPECIALIDAD;
        }else if (fieldName.equals("CODIGO_ENTIDAD")) {
            value =CODIGO_ENTIDAD;
        }else if (fieldName.equals("TIPOID_PROFESIONAL")) {
            value = TIPOID_PROFESIONAL;
            
        }else if (fieldName.equals("NUMID_PROFESIONAL")) {
            value = NUMID_PROFESIONAL;
          
        }
        
        

        
        return value;
    }

    /**
     * @return
     */
    public boolean next() {
    
        index++;
        if (lstInformacionClinica != null)
            return index < lstInformacionClinica.size();
        else
            return false;
        }


    //--------------------------------------------------------------------------
    //  Metodo esValido que garantiza que el registro fue guardado exitosamente
    //--------------------------------------------------------------------------

    public boolean esValido() {
        boolean esValido = false;
        Chreferencia referenciaAux = null;
        if (numeroConsulta != null) {

            try {
                referenciaAux = 
                        this.getServiceLocator().getClinicoService().getReferencia(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (referenciaAux != null) {
                esValido = true;
            } else {
                esValido = false;
            }


        }
        return esValido;
    }
    
    
    //--------------------------------------------------------------------------
    //  Bot�n principal
    //--------------------------------------------------------------------------    
    
    /**
     * @param valueChangeEvent
     */
    public void setDepartamentoSelect(ValueChangeEvent valueChangeEvent) {
        referencia.setHrendeparrespo((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void changeCiudad() {
        if (referencia.getHrendeparrespo() != null && !referencia.getHrendeparrespo() .equals("")) {
            this.listMunicipios = new ArrayList<SelectItem>();
            referencia.setHrenciudarespo(null);
            ArrayList<Cpmunidane> listMunicipiosAux = null;
            try {

                listMunicipiosAux = 
                        (ArrayList<Cpmunidane>)this.serviceLocator.getClinicoService().getMunicipios(referencia.getHrendeparrespo());

            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (listMunicipiosAux != null && !listMunicipiosAux.isEmpty()) {

                Iterator it = listMunicipiosAux.iterator();
                int i = 0;
                listMunicipios.add(new SelectItem("", 
                                                  "Seleccione una opcion ..."));
                while (it.hasNext()) {
                    it.next();
                    listMunicipios.add(new SelectItem(listMunicipiosAux.get(i).getCmdncodmun(), 
                                                      listMunicipiosAux.get(i).getCmdcnommun()));
                    i++;
                }
            }
        } else {
            listMunicipios = new ArrayList<SelectItem>();
            listMunicipios.add(new SelectItem("", 
                                              "Seleccione una opcion ..."));
        }
    }

    //--------------------------------------------------------------------------
    //  Bot�n principal
    //--------------------------------------------------------------------------    

    public void generarReferencia() {
        this.index = -1;

        this.index = -1;

        ChreferenciaPK id = new ChreferenciaPK();

        String serviciosSelect = "";

        

        referencia.setHrecoperador(userName());
        referencia.setHredfecregistr(new Date());
        referencia.setHrectiporefere(serviciosSelect);
        
        if(!esCirugia){
            // Si no es Cirugia el servicio donde se encuentra el paciente es CE Consultas Externa
            referencia.setHreclugarservi("CE");
        }else{
            // Si  es Cirugia el servicio donde se encuentra el paciente es CI Cirugia
        
            referencia.setHreclugarservi("CI");
        }


        if (numeroConsulta != null && tipoServicio != null && 
            consecutivo != null) {
            id.setHrelconsulta(numeroConsulta);
            id.setHrectiposervi(tipoServicio);
            id.setHrenconsecutiv(consecutivo);
            referencia.setId(id);
        }


        try {
            this.getServiceLocator().getClinicoService().saveReferencia(referencia);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
        } catch (ModelException e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
        }
        try {
            if (!esCirugia) {
                obtenerDatosReporteConsulta();
            } else {
                obtenerDatosReporteCirugia();
            }

           URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/Formato_Referencia.jasper");
            URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_NEW); 
            URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL); 
            URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL); 
            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                byte[] bytes;
                
                JasperReport report = (JasperReport) JRLoader.loadObject(url); 

                bytes = 
                        JasperRunManager.runReportToPdf(report, parameters, 
                                                        (JRDataSource)this);

                PdfServletUtils.showPdfDocument(bytes, 
                                                "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);

                generoReferencia = true;
                modoconsulta = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
    }


    // ACCESSORS


    /**
     * @param generoReferencia
     */
    public void setGeneroReferencia(boolean generoReferencia) {
        this.generoReferencia = generoReferencia;
    }

    /**
     * @return
     */
    public boolean isGeneroReferencia() {
        return generoReferencia;
    }

    /**
     * @param modoconsulta
     */
    public void setModoconsulta(boolean modoconsulta) {
        this.modoconsulta = modoconsulta;
    }

    /**
     * @return
     */
    public boolean isModoconsulta() {
        return modoconsulta;
    }


    /**
     * @param esCirugia
     */
    public void setEsCirugia(boolean esCirugia) {
        this.esCirugia = esCirugia;
    }

    /**
     * @return
     */
    public boolean isEsCirugia() {
        return esCirugia;
    }

    /**
     * @param numeroUsuario
     */
    public void setNumeroUsuario(Long numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    /**
     * @return
     */
    public Long getNumeroUsuario() {
        return numeroUsuario;
    }

    /**
     * @param tipoServicio
     */
    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * @return
     */
    public String getTipoServicio() {
        return tipoServicio;
    }

    /**
     * @param consecutivo
     */
    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    /**
     * @return
     */
    public Integer getConsecutivo() {
        return consecutivo;
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
     * @param menuBean
     */
    public void setMenuBean(String menuBean) {
        this.menuBean = menuBean;
    }

    /**
     * @return
     */
    public String getMenuBean() {
        return menuBean;
    }

    /**
     * @param referencia
     */
    public void setReferencia(Chreferencia referencia) {
        this.referencia = referencia;
    }

    /**
     * @return
     */
    public Chreferencia getReferencia() {
        return referencia;
    }



    /**
     * @param tensionArterial
     */
    public void setTensionArterial(String tensionArterial) {
        this.tensionArterial = tensionArterial;
    }

    /**
     * @return
     */
    public String getTensionArterial() {
        return tensionArterial;
    }

    /**
     * @param frecuenciaCardiaca
     */
    public void setFrecuenciaCardiaca(Integer frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    /**
     * @return
     */
    public Integer getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    /**
     * @param frecuenciaRespiratoria
     */
    public void setFrecuenciaRespiratoria(Integer frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }

    /**
     * @return
     */
    public Integer getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    /**
     * @param peso
     */
    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    /**
     * @return
     */
    public BigDecimal getPeso() {
        return peso;
    }

    /**
     * @param hallazgos
     */
    public void setHallazgos(String hallazgos) {
        this.hallazgos = hallazgos;
    }

    /**
     * @return
     */
    public String getHallazgos() {
        return hallazgos;
    }

    /**
     * @param temperatura
     */
    public void setTemperatura(BigDecimal temperatura) {
        this.temperatura = temperatura;
    }

    /**
     * @return
     */
    public BigDecimal getTemperatura() {
        return temperatura;
    }
    
    
    /**
      * @param param
      */
     public void setListDepartamentos(List<SelectItem> param) {
         this.listDepartamentos = param;
     }

     /**
      * @return
      */
     public List<SelectItem> getListDepartamentos() {
         if (listDepartamentos == null || listDepartamentos.isEmpty()) {
             listDepartamentos = new ArrayList<SelectItem>();
             ArrayList<Cpdepadane> listDepartamentosAux = null;
             try {
                 listDepartamentosAux = 
                         (ArrayList<Cpdepadane>)this.serviceLocator.getClinicoService().getDepartamentos();
             } catch (ModelException e) {
                 e.printStackTrace();
             }

             if (!listDepartamentosAux.isEmpty()) {

                 Iterator it = listDepartamentosAux.iterator();
                 int i = 0;
                 listDepartamentos.add(new SelectItem("", 
                                                      "Seleccione una opci�n ..."));
                 while (it.hasNext()) {
                     it.next();
                     listDepartamentos.add(new SelectItem(listDepartamentosAux.get(i).getCddncodigo(), 
                                                          listDepartamentosAux.get(i).getCddcdescri()));
                     i++;
                 }
             }
         }
         return listDepartamentos;
     }
     
     
    /**
       * @param param
       */
      public void setListMunicipios(List<SelectItem> param) {
          this.listMunicipios = param;
      }

      /**
       * @return
       */
      public List<SelectItem> getListMunicipios() {

          return listMunicipios;
      }
      
      
    /**
       * @param 
       */
      public void setCiudad() {
          if (referencia != null && referencia.getHrendeparrespo() != null) {
              this.listMunicipios = new ArrayList<SelectItem>();
              ArrayList<Cpmunidane> listMunicipiosAux = null;
              try {
                  listMunicipiosAux = 
                          (ArrayList<Cpmunidane>)this.serviceLocator.getClinicoService().getMunicipios(referencia.getHrendeparrespo());
              } catch (ModelException e) {
                  e.printStackTrace();
              }

              if (listMunicipiosAux != null && !listMunicipiosAux.isEmpty()) {

                  Iterator it = listMunicipiosAux.iterator();
                  int i = 0;
                  listMunicipios.add(new SelectItem("", 
                                                    "Seleccione una opcion ..."));
                  while (it.hasNext()) {
                      it.next();
                      listMunicipios.add(new SelectItem(listMunicipiosAux.get(i).getCmdncodmun(), 
                                                        listMunicipiosAux.get(i).getCmdcnommun()));
                      i++;
                  }
              }


          }

      }
      
      
    public void setListTipoIdentificacion(List<SelectItem> param) {
        this.listTipoIdentificacion = param;
    }

    public List<SelectItem> getListTipoIdentificacion() {
        if (listTipoIdentificacion == null || 
            listTipoIdentificacion.isEmpty()) {
            listTipoIdentificacion = new ArrayList<SelectItem>();
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


    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    public List getLstOpciones() {
    if(lstOpciones == null || lstOpciones.isEmpty()){
        lstOpciones = new ArrayList();
        lstOpciones.add(new SelectItem("C","Cumple"));
        lstOpciones.add(new SelectItem("N","No Cumple"));
        lstOpciones.add(new SelectItem("X","No Aplica"));
    }
        return lstOpciones;
    }

    public void setConsultaAux(Cnconsclin consultaAux) {
        this.consultaAux = consultaAux;
    }

    public Cnconsclin getConsultaAux() {
        return consultaAux;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setExamenfisico(Chexamfisico examenfisico) {
        this.examenfisico = examenfisico;
    }

    public Chexamfisico getExamenfisico() {
        return examenfisico;
    }


    public String resumenExamenFisico(Chexamfisico examen) {
    
    String examenFisicoreturn = "";

        String PRESION_ARTERIAL = "";
        String TIPO_TEMPERATURA = "";
        String LUGAR_TEMPERATURA = "";
        String FRECUENCIA_CARDIACA = "";
        String FRECUENCIA_RESPIRATORIA = "";
        String TALLA = "";
        String PESO = "";
        String TEMPERATURA = "";
       
        if (examen != null) {
            PRESION_ARTERIAL = "Presion Arterial: " + 
                    formatearCampo(examen.getHefcpresart1()) + "/" + formatearCampo(examen.getHefcpresart2()) + 
                    " mm Hg" +"\n";
            examenFisicoreturn = examenFisicoreturn + PRESION_ARTERIAL;
            FRECUENCIA_CARDIACA =  "Frecuencia Cardiaca: " + 
                    formatearCampo(examen.getHefnfreccard()) + " l.p.m." +"\n";
            examenFisicoreturn = examenFisicoreturn + FRECUENCIA_CARDIACA;
            FRECUENCIA_RESPIRATORIA = "Frecuencia Respiratoria: " + 
                    formatearCampo(examen.getHefnfrecresp()) + " r.p.m" +"\n";
            examenFisicoreturn = examenFisicoreturn +FRECUENCIA_RESPIRATORIA ;
            TALLA = "Talla:" + formatearCampo(examen.getHefatalla()) + " mts" +"\n";
            examenFisicoreturn = examenFisicoreturn + TALLA ;
            PESO = "Peso:" + formatearCampo(examen.getHefapeso()) + " kg" +"\n";
            examenFisicoreturn = examenFisicoreturn + PESO;

            
            examenFisicoreturn =   examenFisicoreturn + HALLAZGOS_EXAMEN_FISICO_REFERENCIA ;
            if (examen.getHefelugartemp() != null) {
                if (examen.getHefelugartemp().equals("A")) {
                    LUGAR_TEMPERATURA = "Axilar";
                } else if (examen.getHefelugartemp().equals("B")) {
                    LUGAR_TEMPERATURA = "Bucal";
                }
                
                LUGAR_TEMPERATURA = "Lugar Temperatura" + LUGAR_TEMPERATURA +"\n";
                examenFisicoreturn = examenFisicoreturn + LUGAR_TEMPERATURA;
            }
            if (examen.getHefetipotemper() != null) {
                if (examen.getHefetipotemper().equals("A")) {
                    TIPO_TEMPERATURA = "Afebril";
                   
                    TEMPERATURA = null;
                } else if (examen.getHefetipotemper().equals("F")) {
                    TIPO_TEMPERATURA = "Febril";
                    TEMPERATURA = 
                            formatearCampo(examen.getHefatemperatu()) + " �C";
                }
                TIPO_TEMPERATURA = "Tipo de Temperatura: " +TIPO_TEMPERATURA;
                LUGAR_TEMPERATURA = "Lugar Temperatura: " + LUGAR_TEMPERATURA;

                examenFisicoreturn = examenFisicoreturn + TIPO_TEMPERATURA + LUGAR_TEMPERATURA ;
            }
        }
        
  
        return examenFisicoreturn; 
    }


    public void setHrecdiagnosti(ValueChangeEvent valueChangeEvent) {
         referencia.setHrecdiagnosti((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }

    
    
         public void mostrarDiagnostico() {
             Cie10Bean cie10;
             if (referencia != null) {
                 referencia.setHrecdiagnosti("");
             }
             cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");
             cie10.setDiagnosticoPrincipal(false);
             cie10.setDiagnosticoRelacionado1(true);
             cie10.setDiagnosticoRelacionado2(false);
             cie10.setDiagnosticoRelacionado3(false);
             mostrarCie10 = true;
             selectedIndex = ACTIVAR_BUSCADOR;
         }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setInputDiagnostico(UIInput inputDiagnostico) {
        this.inputDiagnostico = inputDiagnostico;
    }

    public UIInput getInputDiagnostico() {
        return inputDiagnostico;
    }
    
    
    public void changeDiagnosticoRelacionado1() {

        diagnostico = null;
        List validacionRelacionado1 = null;

        if (referencia.getHrecdiagnosti() != null && 
            !referencia.getHrecdiagnosti().equals("")) {
            try {
                diagrela1 = 
                        this.serviceLocator.getClinicoService().getCIE10PorCodigo(referencia.getHrecdiagnosti().toUpperCase());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            
          

          

            if (diagnostico == null || 
                diagnostico.equals("")) {
                FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_RELACIONADO1_NO_VALIDO);
            }
        } else {
            diagnostico = "";
        }
    }


    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }
    
    
    public void aceptarDiagnostico() {

        Cie10Bean cie10;
        cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");

        if (cie10 != null && cie10.getCie10Select() != null) {

                referencia.setHrecdiagnosti(cie10.getCie10Select().getCdcccodigo());
                inputDiagnostico.setValue(cie10.getCie10Select().getCdcccodigo());
                diagnostico = cie10.getCie10Select().getCdccdescri();
            

        } else {
            if (cie10 != null && cie10.isDiagnosticoRelacionado3())
                inputDiagnostico = null;
           
        }

        mostrarCie10 = false;
        selectedIndex = ACTIVAR_REFERENCIA;
        cie10.clear();
 
    }

    public void setMostrarCie10(boolean mostrarCie10) {
        this.mostrarCie10 = mostrarCie10;
    }

    public boolean isMostrarCie10() {
        return mostrarCie10;
    }
    
    public void changeMorbilidad() {
        renderMorbilidad= false;
       if("S".equals(referencia.getHrecmormatext())) {
           renderMorbilidad= true;
       }else{
           referencia.setHrenmedauttra(null);
       }
    
    }
    /**
     * @return
     */
    public void aceptarProfesional() {
        selectedIndex = ACTIVAR_BEAN;

        profesionalSelect = new Cpprofesio();
        String cargoProfesional= "";

        buscadorProfesionalBean = 
                (BuscadorProfesionalBean)FacesUtils.getManagedBean("buscadorProfesionalBean");
        profesionalSelect = buscadorProfesionalBean.getProfesionalSelect();
        referencia.setHrenmedauttra(profesionalSelect.getCpfncodigo().longValue());
        renderProfesional = false;

    }

    public void mostrarBuscadorProfesional() {
        FacesUtils.resetManagedBean("buscadorProfesionalBean");
        buscadorProfesionalBean = 
                (BuscadorProfesionalBean)FacesUtils.getManagedBean("buscadorProfesionalBean");
        if (consultaClinica != null) {
            buscadorProfesionalBean.setConsulta(consultaClinica);
        } else {
            Chconsulta consulta = new Chconsulta();
            if (cirugiaProgramada != null) {
                consulta.setHconclinica(cirugiaProgramada.getHcpnclinica());
                buscadorProfesionalBean.setConsulta(consulta);
            }
        }
        selectedIndex = ACTIVAR_BUSCADOR_PROFESIONAL;
        renderProfesional = true;
    }
    
    public void setHrecmormatext(ValueChangeEvent valueChangeEvent) {
             referencia.setHrecmormatext((String)valueChangeEvent.getNewValue());
            ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setHrenmedauttra(ValueChangeEvent valueChangeEvent) {
             referencia.setHrenmedauttra((Long)valueChangeEvent.getNewValue());
            ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderMorbilidad(boolean renderMorbilidad) {
        this.renderMorbilidad = renderMorbilidad;
    }

    public boolean isRenderMorbilidad() {
        return renderMorbilidad;
    }

    public void setProfesionalSelect(Cpprofesio profesionalSelect) {
        this.profesionalSelect = profesionalSelect;
    }

    public Cpprofesio getProfesionalSelect() {
        return profesionalSelect;
    }

    public void setRenderProfesional(boolean renderProfesional) {
        this.renderProfesional = renderProfesional;
    }

    public boolean isRenderProfesional() {
        return renderProfesional;
    }

    public void setBuscadorProfesionalBean(BuscadorProfesionalBean buscadorProfesionalBean) {
        this.buscadorProfesionalBean = buscadorProfesionalBean;
    }

    public BuscadorProfesionalBean getBuscadorProfesionalBean() {
        return buscadorProfesionalBean;
    }

    public void setRenderHistoriasValidas(boolean renderHistoriasValidas) {
        this.renderHistoriasValidas = renderHistoriasValidas;
    }

    public boolean isRenderHistoriasValidas() {
        return renderHistoriasValidas;
    }

    public void setConsultaClinica(Chconsulta consultaClinica) {
        this.consultaClinica = consultaClinica;
    }

    public Chconsulta getConsultaClinica() {
        return consultaClinica;
    }

    public void setCirugiaProgramada(Chcirugprogr cirugiaProgramada) {
        this.cirugiaProgramada = cirugiaProgramada;
    }

    public Chcirugprogr getCirugiaProgramada() {
        return cirugiaProgramada;
    }
}

