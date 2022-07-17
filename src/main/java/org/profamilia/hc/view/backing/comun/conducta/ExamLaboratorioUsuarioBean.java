 //=======================================================================
 // ARCHIVO ExamLaboratorioUsuarioBean.java
 // FECHA CREACI�N: 02/08/2010
 // AUTOR: Jos� Andr�s Riano
 // Descripci�n: Datos correspondientes al examen de laboratorio.
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

 import javax.faces.component.html.HtmlDataTable;

 import net.sf.jasperreports.engine.JRDataSource;
 import net.sf.jasperreports.engine.JRException;
 import net.sf.jasperreports.engine.JRField;
 import net.sf.jasperreports.engine.JasperReport;
 import net.sf.jasperreports.engine.JasperRunManager;
 import net.sf.jasperreports.engine.util.JRLoader;

 import org.profamilia.hc.model.dto.Cfadmision;
 import org.profamilia.hc.model.dto.Cfdetafactura;
 import org.profamilia.hc.model.dto.CfdetafacturaPK;
 import org.profamilia.hc.model.dto.Chexamelabor;
 import org.profamilia.hc.model.dto.Chimprdiag;
 import org.profamilia.hc.model.dto.Chremision;
 import org.profamilia.hc.model.dto.Chtipointerc;
 import org.profamilia.hc.model.dto.Chusuario;
 import org.profamilia.hc.model.dto.Cnconsclin;
 import org.profamilia.hc.model.dto.Cpprofesio;
 import org.profamilia.hc.model.dto.Cpservicio;
 import org.profamilia.hc.model.dto.Cptipodocu;
 import org.profamilia.hc.model.dto.Crdgncie10;
 import org.profamilia.hc.model.exceptions.ModelException;
 import org.profamilia.hc.view.backing.BaseBean;
 import org.profamilia.hc.view.constantes.IConstantes;
 import org.profamilia.hc.view.constantes.IMsg;
 import org.profamilia.hc.view.util.FacesUtils;
 import org.profamilia.hc.view.util.PdfServletUtils;


 //=======================================================================
 //  BIBLIOTECAS REQUERIDAS
 //=======================================================================


 //==============================================================================
 //  CLASE ExamLaboratorioUsuarioBean
 //==============================================================================

 public class ExamLaboratorioUsuarioBean extends BaseBean implements JRDataSource {

     //-----------------------------------------------------------------------
     //  ATRIBUTOS DE INSTANCIA
     //-----------------------------------------------------------------------

     private int index = -1;

     private boolean generoDocPDF;

     private boolean modoConsulta;

     private String descripcionRemision;

     private List lstExamenesLaboratorios;

     private HtmlDataTable dtServicios;

     /** Lista que almacena las remisiones que se le ordenaron al usuario */
     private List<Chexamelabor> lstRemision;
     private List<Chexamelabor> lstRemisionImp;

     /** Almacena la tabla de las remisiones  */
     private HtmlDataTable dtRemision;

     /** Almacena la remision a eliminar del data table  */
     private Chexamelabor remisionClon;

     /** Variable que almacena el laboratorio que se desea buscar */
     private Cpservicio servicio;

     private Integer tipoHistoria;

     private boolean esCirugia;

     private String tipoServicio;

     private Integer consecutivo;

     private Chimprdiag impresionDiagnostica;

     String NOMBRES;

     String PRIMER_APELLIDO;

     String SEGUNDO_APELLIDO;

     String TIPO_DOCUMENTO;

     Long NUMERO_DOCUMENTO;

     String DIAGNOSTICO_PRINCIPAL;

     String DIAGNOSTICO_SECUNDARIO;

     String CODIGO_CIE10;

     String TIPO_USUARIO;

     String ANO;

     String MES;

     String DIA;

     Integer EDAD;
     
     String NOMBRE_PROFESIONAL;
     
     String REGISTRO_MEDICO; 
     
     String TIPOID_PROFESIONAL;
     
     BigDecimal NUMID_PROFESIONAL;
     
     String ESPECIALIDAD; 

     Date fecha;

     String CODIGO_CIE10_PRINCIPAL;
     String TIPO_REMISION;

     /** Almacena el consulta */
     private Long numeroConsulta;

     /** Almacena el usuario que se desea guardar */
     private Chusuario usuario;

     private String menuBean;

     private String cie10Principal;
     
     private Long numeroAdmision;
     private List<Cfdetafactura> cfdetafacturaList;
     private HtmlDataTable tableLaboratorioAdmision;
     private Cfdetafactura cfdetafactura;
     private List<Object[]> resultList;
     private Cfadmision admision;
     private Cnconsclin consulta;


     //-----------------------------------------------------------------------
     //  METODO CONSTRUCTOR
     //-----------------------------------------------------------------------    

     public ExamLaboratorioUsuarioBean() {
     }

     //ACTIONS 

     public void init() {

         generoDocPDF = false;
         modoConsulta = false;
         servicio = new Cpservicio();
         lstExamenesLaboratorios = new ArrayList();
         numeroAdmision= null;
         cfdetafactura = new Cfdetafactura();
         cfdetafacturaList = new ArrayList();
         resultList = new ArrayList();
         tableLaboratorioAdmision = new HtmlDataTable();
         admision = new Cfadmision();
         lstRemisionImp = new ArrayList();
         inicializarExamLaboratorio();
     }

     public void inicializarExamLaboratorio() {
         generoDocPDF = false;
         lstRemisionImp = new ArrayList();
         try {
             lstRemision = 
                     this.serviceLocator.getClinicoService().getExamenesLaboratorios(numeroConsulta, 
                                                                                     tipoServicio, 
                                                                                     consecutivo);

         } catch (ModelException e) {
             e.printStackTrace();
         }

         if (lstRemision == null || lstRemision.isEmpty()) {
             modoConsulta = false;
             lstRemision = new ArrayList<Chexamelabor>();
         } else {
             descripcionRemision = (lstRemision.get(0)).getHelcobservacio();
             modoConsulta = true;
         }
         
         busquedaDetalleFactura();

     }


     //--------------------------------------------------------------------------
     //  Metodo esValido que garantiza que el registro fue guardado exitosamente
     //--------------------------------------------------------------------------

      private void busquedaDetalleFactura() {
          try {
              if (numeroAdmision != null) {
                  resultList = 
                          getServiceLocator().getClinicoService().getListaLaboratorioFacturados(numeroAdmision);

                  if (resultList != null && !resultList.isEmpty()) {
                      cfdetafacturaList = new ArrayList<Cfdetafactura>();

                      for (Object[] objeto: resultList) {

                          if (objeto[17] == null) {
                              cfdetafactura.setComp_id(new CfdetafacturaPK(validarLong(objeto[0]), 
                                                                           validarLong(objeto[1])));

                              cfdetafactura.setCdfcservicio(validarString(objeto[2]));
                              cfdetafactura.setCdfnorden(validarLong(objeto[3]));
                              cfdetafactura.setCdfcobserv(validarString(objeto[4]));
                              cfdetafactura.setCdfclote(validarString(objeto[5]));
                              cfdetafactura.setCdfndescuento(validarDouble(objeto[6]));
                              cfdetafactura.setCdfniva(validarDouble(objeto[7]));
                              cfdetafactura.setCdfncliente(validarLong(objeto[8]));
                              cfdetafactura.setCdfnestado(validarString(objeto[9]));
                              cfdetafactura.setCdfcpaquet(validarString(objeto[10]));
                              cfdetafactura.setCdfctipdscto(validarString(objeto[11]));
                              cfdetafactura.setCdfnvalsrv(validarDouble(objeto[12]));
                              cfdetafactura.setCdfncantidad(validarLong(objeto[13]));
                              cfdetafactura.setCdfcetapa(validarString(objeto[14]));
                              cfdetafactura.setCdfcusuamodi(validarString(objeto[15]));
                              cfdetafactura.setCdfdfechmodi((Date)(objeto[16]));
                              cfdetafactura.setCdfnconsuclin(validarLong(objeto[17]));
                              cfdetafactura.setCdfcswitpaq(validarString(objeto[18]));
                              cfdetafactura.setNombreServicio(validarString(objeto[19]));
                              if (cfdetafactura.getCdfnconsuclin() != null) {
                                  cfdetafactura.setValidacionConsultaClinica(true);
                              } else {
                                  cfdetafactura.setValidacionConsultaClinica(false);
                              }
                              cfdetafacturaList.add(cfdetafactura);
                              cfdetafactura = new Cfdetafactura();
                          }
                      }
                  }
                  
                  validacionLiberacionServicios();
              }
          } catch (ModelException e) {
              e.printStackTrace();
          }
      }

     private void validacionLiberacionServicios() {
         if ((lstRemision != null && !lstRemision.isEmpty()) && 
             (resultList != null && !resultList.isEmpty())) {
             for (Chexamelabor remision: lstRemision) {
                 for (Object[] objeto: resultList) {
                     if (remision.getCpservicio().getCsvccodigo().equals(objeto[2])) {
                         remision.setServicioLiberado("Si");
                     }
                     if(remision.getServicioLiberado() == null){
                         remision.setServicioLiberado("No");
                     }
                 }
             }
         }
     }

     public boolean esValido() {
         boolean esValido = false;
         List<Chexamelabor> lstRemisionAux = null;
         if (numeroConsulta != null) {
             try {
                 lstRemisionAux = 
                         this.serviceLocator.getClinicoService().getExamenesLaboratoriosConsulta(numeroConsulta);
             } catch (ModelException e) {
                 e.printStackTrace();
             }

             if (lstRemisionAux == null || lstRemisionAux.isEmpty()) {
                 esValido = false;
             } else {
                 esValido = true;
             }
         }
         return esValido;
     }

     //-----------------------------------------------------------------------
     //  Ajax y/o Botonoes secundarios
     //-----------------------------------------------------------------------    

     public void agregarRemision() {
         Chexamelabor remision;
         Object[] servicioSelect = null;
         Cpservicio servicioObject = null;
         if (dtServicios != null) {
             servicioSelect = (Object[])this.dtServicios.getRowData();


             try {
                 if (servicioSelect != null && 
                     servicioSelect[0] != null) {
                     servicioObject = 
                             this.serviceLocator.getClinicoService().getServicioPorId(servicioSelect[0].toString());
                 }

             } catch (ModelException e) {
                 e.printStackTrace();
             }
         }

         remision = new Chexamelabor();
         if (servicioObject != null) {

             remision.setCpservicio(servicioObject);
             remision.setHeldfecregistr(new Date());
             remision.setHelcoperador(userName());

             lstRemision.add(remision);
             servicio = new Cpservicio();
             
             for (Cfdetafactura fact: cfdetafacturaList) {
                 if (fact.getCdfcservicio().equals(servicioObject.getCsvccodigo())) {
                     fact.setValidacionConsultaClinica(true);
                     FacesUtils.addInfoMessage("El laboratorio seleccionado, se encuentra dentro de los servicios de la admisi�n.");
                 }
             }
             
             validacionLiberacionServicios();
         } else {
             FacesUtils.addErrorMessage("Debe Registrar todos los datos");
         }

         
     }

     public void eliminarRemision() {
         this.remisionClon = (Chexamelabor)this.dtRemision.getRowData();
         this.lstRemision.remove(remisionClon);
         for (Cfdetafactura fact: cfdetafacturaList) {
             if (fact.getCdfcservicio().equals(remisionClon.getCpservicio())) {
                 fact.setValidacionConsultaClinica(false);
             }
         }
         FacesUtils.addInfoMessage(IMsg.MSG_ELIMINACION);
     }


     public void consultarLaboratorios() {
         dtServicios.setFirst(0);
         try {
         if(numeroAdmision != null){
             lstExamenesLaboratorios = 
                     this.serviceLocator.getClinicoService().getExamenesLaboratorioPorCriterios(servicio,numeroAdmision);
         }else{
             lstExamenesLaboratorios = 
                     this.serviceLocator.getClinicoService().getExamenesLaboratorioPorCriterios(servicio,0L);
         }
         } catch (ModelException e) {
             e.printStackTrace();
         }
     }
     
     public void aceptarLaboratorioPropuesto() {
         Chexamelabor remision;
         Cfdetafactura servicioSelect = null;
         Cpservicio servicioObject = null;
         if (tableLaboratorioAdmision != null) {
             servicioSelect = (Cfdetafactura)this.tableLaboratorioAdmision.getRowData();


             try {
                 if (servicioSelect != null && 
                     servicioSelect.getCdfcservicio()!= null) {
                     servicioObject = 
                             this.serviceLocator.getClinicoService().getServicioPorId(servicioSelect.getCdfcservicio());
                 }

             } catch (ModelException e) {
                 e.printStackTrace();
             }
         }

         remision = new Chexamelabor();
         if (servicioObject != null) {

             remision.setCpservicio(servicioObject);
             remision.setHeldfecregistr(new Date());
             remision.setHelcoperador(userName());

             lstRemision.add(remision);
             servicio = new Cpservicio();

         } else {
             FacesUtils.addErrorMessage("Debe Registrar todos los datos");
         }
     }

     //-----------------------------------------------------------------------
     //  Construir Reporte
     //-----------------------------------------------------------------------

     /**
      * @param jrField
      * @return
      */
     public Object getFieldValue(JRField jrField) {

         Object value = null;
         String fieldName = jrField.getName();

         if (fieldName.equals("APELLIDO1")) {
             value = PRIMER_APELLIDO;
             return value;
         }

         if (fieldName.equals("APELLIDO2")) {
             value = SEGUNDO_APELLIDO;
             return value;
         }
         if (fieldName.equals("NOMBRES")) {
             value = NOMBRES;
             return value;
         }
         if (fieldName.equals("NUMERO_DOCUMENTO")) {
             value = NUMERO_DOCUMENTO;
             return value;
         }
         if (fieldName.equals("DIA")) {
             value = DIA;
             return value;
         }
         if (fieldName.equals("MES")) {
             value = MES;
             return value;
         }
         if (fieldName.equals("ANO")) {
             value = ANO;
             return value;
         }
         if (fieldName.equals("TIPO_REMISION")) {
             value = TIPO_REMISION;
             return value;
         }
         
 /*        if (fieldName.equals("TIPO_REMISION")) {
         
         if(lstRemision.get(index).getCpservicio().getCsvccodcups() != null && !lstRemision.get(index).getCpservicio().getCsvccodcups() .equals("")){
             value = lstRemision.get(index).getCpservicio().getCsvccodcups() + " "+lstRemision.get(index).getCpservicio().getCsvcnombre();
         }else{
             value = lstRemision.get(index).getCpservicio().getCsvccodigo() + " "+lstRemision.get(index).getCpservicio().getCsvcnombre();
         }
             
             return value;
         }
 */
         if (fieldName.equals("DESCRIPCION_REMISION")) {
             value = descripcionRemision;
             return value;
         }

         if (fieldName.equals("EDAD")) {
             value = EDAD;
             return value;
         }
         if (fieldName.equals("DIAGNOSTICO_PRINCIPAL")) {
             value = DIAGNOSTICO_PRINCIPAL;
             return value;
         }

         if (fieldName.equals("NOMBRE_PROFESIONAL")) {
             value = NOMBRE_PROFESIONAL;
             return value;
         }
         if (fieldName.equals("REGISTRO_MEDICO")) {
             value = REGISTRO_MEDICO;
             return value;
         }
         
         
          if (fieldName.equals("TIPOID_PROFESIONAL")) {
               value = TIPOID_PROFESIONAL;
              return value;
          }
          if (fieldName.equals("NUMID_PROFESIONAL")) {
               value = NUMID_PROFESIONAL;
             return value;
         }
         


         if (fieldName.equals("ESPECIALIDAD")) {
             value = ESPECIALIDAD;
             return value;
         }

         return null;

     }

     public boolean next() throws JRException {
         index++;
         return (index < lstRemisionImp.size());
     }

     public byte[] generarReporteLaboratorios(Long numConsulta, Integer consecutivo, String tipoServicio) {
        byte[] bytes = null;
        try {
             Cnconsclin consulta = this.serviceLocator.getClinicoService().getConsultaClinicaPorId(numConsulta.toString());
             Chusuario usuario = this.serviceLocator.getClinicoService().getUsuario(consulta.getCcolusuario().getHuslnumero());
             List<Chexamelabor> lstRemisionAux = null;
             lstRemisionAux =  this.serviceLocator.getClinicoService().getExamenesLaboratorios(numConsulta, tipoServicio, consecutivo);

             lstRemisionImp = new ArrayList<Chexamelabor>();

             if (lstRemisionAux != null && !lstRemisionAux.isEmpty()) {
                Chexamelabor examlabo = null;
                Iterator it = lstRemisionAux.iterator();
                TIPO_REMISION = "";
                while (it.hasNext()) {
                   examlabo = (Chexamelabor)it.next();

                    if(examlabo.getCpservicio().getCsvccodcups() != null && !examlabo.getCpservicio().getCsvccodcups() .equals("")){
                       TIPO_REMISION = TIPO_REMISION + examlabo.getCpservicio().getCsvccodcups() + " " + examlabo.getCpservicio().getCsvcnombre() + "\n";
                    }else{
                       TIPO_REMISION = TIPO_REMISION + examlabo.getCpservicio().getCsvccodigo() + " " + examlabo.getCpservicio().getCsvcnombre() + "\n";
                    }
                }

                if (examlabo != null) {
                   lstRemisionImp.add(examlabo);
                   Chimprdiag imprdiag;
                   imprdiag = this.serviceLocator.getClinicoService().getImresionDiagnostica(numConsulta, consecutivo);
                   Crdgncie10 diagprin = null;
             
                   if (imprdiag != null && imprdiag.getHidcdiagprin() != null) {
                      CODIGO_CIE10_PRINCIPAL = imprdiag.getHidcdiagprin();
                      DIAGNOSTICO_PRINCIPAL = imprdiag.getHidcdiagprin();
                      diagprin = this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10_PRINCIPAL);
                      if (diagprin != null) {
                        DIAGNOSTICO_PRINCIPAL = diagprin.getCdcccodigo()+ " " + diagprin.getCdccdescri() ;
                      }
                   }

                   if (usuario.getHusdfechanacim() != null) {
                      Date fechaNacimiento = usuario.getHusdfechanacim();
                      if (fechaNacimiento != null) {
                         int edad = calcularEdad(fechaNacimiento, new Date());
                         EDAD = edad;
                      }
                   }
                   if (usuario.getHuscprimernomb() != null) {
                      NOMBRES = usuario.getHuscprimernomb() + " ";
                   }
                   if (usuario.getHuscsegundnomb() != null && !usuario.getHuscsegundnomb().equals("_")) {
                      NOMBRES = NOMBRES + usuario.getHuscsegundnomb();
                   }
                   if (usuario.getHuscprimerapel() != null) {
                      PRIMER_APELLIDO = usuario.getHuscprimerapel() + " ";
                   }
                   if (usuario.getHuscsegundapel() != null && !usuario.getHuscsegundapel().equals("_")) {
                      SEGUNDO_APELLIDO = usuario.getHuscsegundapel();
                   }
                   if (usuario.getHusetipoiden() != null) {
                      TIPO_DOCUMENTO = usuario.getHusetipoiden().toString();
                   }
                   if (usuario.getHusanumeiden() != 0) {
                      NUMERO_DOCUMENTO = usuario.getHusanumeiden();
                   }
                   if ("C".equals(usuario.getHusetipoafilia())) {
                      TIPO_USUARIO = "CONTRIBUTIVO";
                   } else if ("E".equals(usuario.getHusetipoafilia())) {
                      TIPO_USUARIO = "ESPECIAL";
                   } else if ("R".equals(usuario.getHusetipoafilia())) {
                      TIPO_USUARIO = "SUBSIDIO PARCIAL";
                   } else if ("S".equals(usuario.getHusetipoafilia())) {
                      TIPO_USUARIO = "SUBSIDIADO";
                   } else if ("V".equals(usuario.getHusetipoafilia())) {
                      TIPO_USUARIO = "VINCULADO";
                   } else if ("X".equals(usuario.getHusetipoafilia())) {
                      TIPO_USUARIO = "NINGUNO";
                   }

                   if (examlabo.getHelcoperador() != null && consulta != null && consulta.getCconclinic() != null) {
                      Cpprofesio profesional = this.serviceLocator.getClinicoService().getProfesionalPorUsuario(examlabo.getHelcoperador().toLowerCase(), 
                                                                                                  consulta.getCconclinic());
                      if (profesional != null) {
                         NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                         REGISTRO_MEDICO = profesional.getCpfcregmedic();
                         ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                         TIPOID_PROFESIONAL = profesional.getCpfctipide();
                         NUMID_PROFESIONAL = profesional.getCpfacedula();
                      }
                   }
                   fecha = new Date();
                   Calendar calendar = Calendar.getInstance();
                   calendar.setTime(fecha);
                   Integer diaact = calendar.get(Calendar.DAY_OF_MONTH);
                   Integer mesact = calendar.get(Calendar.MONTH) + 1;
                   Integer anoact = calendar.get(calendar.YEAR);

                   if (diaact.compareTo(10) < 0) {
                      DIA = "0" + diaact.toString();
                   } else {
                      DIA = diaact.toString();
                   }

                   if (mesact.compareTo(10) < 0) {
                      MES = "0" + mesact.toString();
                   } else {
                      MES = mesact.toString();
                   }

                   ANO = anoact.toString();
                }
            }

            URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/FO-GSCE-04.jasper");
            URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
            URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
            URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
            if (url != null) {
               Map parameters = new HashMap();
               parameters.put("IMAGE_PROFAMILIA", url_profamilia);
               parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
               parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);

               JasperReport report = (JasperReport)JRLoader.loadObject(url);
               bytes = JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + e.getMessage());
        }
        return bytes;
    }


 /*    public void obtenerDatosReporteCirugia() {

         Chusuario usuarioAux;
         usuarioAux = null;

         if (usuario != null) {
             usuarioAux = usuario;

         }

         if (usuarioAux != null) {

             if (usuarioAux.getHusdfechanacim() != null) {
                 Date fechaNacimiento = usuarioAux.getHusdfechanacim();
                 if (fechaNacimiento != null) {
                     int edad = calcularEdad(fechaNacimiento, new Date());
                     EDAD = edad;
                 }

             }
             if (impresionDiagnostica != null && 
                 impresionDiagnostica.getHidcdiagprin() != null) {
                 Crdgncie10 diagprin = null;

                 CODIGO_CIE10_PRINCIPAL = 
                         impresionDiagnostica.getHidcdiagprin().toUpperCase();

                 try {
                     diagprin = 
                             this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10_PRINCIPAL);
                 } catch (ModelException e) {
                     e.printStackTrace();
                 }

                 if (diagprin != null) {
                     DIAGNOSTICO_PRINCIPAL = 
                             CODIGO_CIE10_PRINCIPAL + " " + diagprin.getCdccdescri();
                 }
             }

             if (usuarioAux.getHuscprimernomb() != null) {
                 NOMBRES = usuarioAux.getHuscprimernomb() + " ";
             }
             if (usuarioAux.getHuscsegundnomb() != null && 
                 !usuarioAux.getHuscsegundnomb().equals("_")) {
                 NOMBRES = NOMBRES + usuarioAux.getHuscsegundnomb();
             }
             if (usuarioAux.getHuscprimerapel() != null) {
                 PRIMER_APELLIDO = usuarioAux.getHuscprimerapel() + " ";
             }
             if (usuarioAux.getHuscsegundapel() != null && 
                 !usuarioAux.getHuscsegundapel().equals("_")) {
                 SEGUNDO_APELLIDO = usuarioAux.getHuscsegundapel();
             }
             if (usuarioAux.getHusetipoiden() != null) {
                 TIPO_DOCUMENTO = usuarioAux.getHusetipoiden().toString();
             }
             if (usuarioAux.getHusanumeiden() != 0) {
                 NUMERO_DOCUMENTO = usuarioAux.getHusanumeiden();
             }
             if (usuarioAux.getHusetipoafilia() != null) {

                 if (usuarioAux.getHusetipoafilia().equals("C")) {
                     TIPO_USUARIO = "CONTRIBUTIVO";
                 }
                 if (usuarioAux.getHusetipoafilia().equals("E")) {
                     TIPO_USUARIO = "ESPECIAL";
                 }
                 if (usuarioAux.getHusetipoafilia().equals("R")) {
                     TIPO_USUARIO = "SUBSIDIO PARCIAL";
                 }
                 if (usuarioAux.getHusetipoafilia().equals("S")) {
                     TIPO_USUARIO = "SUBSIDIADO";
                 }
                 if (usuarioAux.getHusetipoafilia().equals("V")) {
                     TIPO_USUARIO = "VINCULADO";
                 }
                 if (usuarioAux.getHusetipoafilia().equals("X")) {
                     TIPO_USUARIO = "NINGUNO";
                 }


             }

         }


         fecha = new Date();
         Calendar calendar = Calendar.getInstance();
         calendar.setTime(fecha);
         Integer diaact = calendar.get(Calendar.DAY_OF_MONTH);
         Integer mesact = calendar.get(Calendar.MONTH) + 1;
         Integer anoact = calendar.get(calendar.YEAR);

         if (diaact.compareTo(10) < 0) {
             DIA = "0" + diaact.toString();
         } else {
             DIA = diaact.toString();
         }

         if (mesact.compareTo(10) < 0) {
             MES = "0" + mesact.toString();
         } else {
             MES = mesact.toString();
         }

         ANO = anoact.toString();

     }
 */    


     //--------------------------------------------------------------------------
     //  Bot�n principal
     //--------------------------------------------------------------------------

     public void generarRemision() {
         this.index = -1;

         if (lstRemision.size() != 0) {

             try {
             
                 List<Cnconsclin> listadeConsultasClinicas = new ArrayList();
                 Cptipodocu tipodocu = new Cptipodocu();
                 Cpservicio servicio = new Cpservicio();


                 admision = 
                         getServiceLocator().getClinicoService().getAdmision(numeroAdmision);
                 for (Chexamelabor remision: lstRemision) {
                     for (Cfdetafactura detalle: cfdetafacturaList) {
                         if (detalle.getCdfnconsuclin() == null && 
                             detalle.getCdfcservicio().equals(remision.getCpservicio().getCsvccodigo())) {
                             tipodocu = 
                                     this.serviceLocator.getCirugiaService().getTipoDocuPorId(100);

                             servicio = 
                                     this.serviceLocator.getClinicoService().getServicioPorId(detalle.getCdfcservicio());

                             Cnconsclin consclin = new Cnconsclin();
                             consclin.setCconclinic(admision.getCanclinic().intValue());
                             consclin.setCconsalesp(0);
                             consclin.setCconconsul(0);
                             consclin.setCcontconcl(servicio.getCsvntipcon());
                             consclin.setCcodfecreg(admision.getCadfecreg());
                             consclin.setCconhistor(0);
                             consclin.setCcoctipide(admision.getCactipide());
                             consclin.setCcoanumide(new BigDecimal(admision.getCannumide()));
                             consclin.setCcocprinom(usuario.getHuscprimernomb());
                             consclin.setCcocsegnom(usuario.getHuscsegundnomb());
                             consclin.setCcocpriape(usuario.getHuscprimerapel());
                             consclin.setCcocsegape(usuario.getHuscsegundapel());
                             consclin.setCconclidoc(admision.getCanclinic().intValue());
                             consclin.setCcontipdoc(tipodocu);
                             consclin.setCconnumdoc(new BigDecimal(admision.getCannumero()));
                             consclin.setCconprogra(admision.getCanprogra().intValue());
                             consclin.setCconcontra(admision.getCancontra().intValue());
                             consclin.setCcocservic(servicio);
                             consclin.setCconcantid(detalle.getCdfncantidad().intValue());
                             consclin.setCcoavalser(new BigDecimal(detalle.getCdfnvalsrv()));
                             consclin.setCcodfecreg(new Date());
                             consclin.setCcodfeccon(admision.getCadfecreg());
                             consclin.setCcothorcon(new Date());
                             consclin.setCcocusureg(getUsuarioSystem().getCurcusuari());
                             consclin.setCcocetapa(IConstantes.CEN_SALA);
                             consclin.setCcothorate(new Date());
                             consclin.setCcocusumod(" ");
                             consclin.setCcocestado(IConstantes.ESTADO_VIGENTE);
                             consclin.setCcondonant(new BigDecimal(admision.getCandonante()));
                             consclin.setCcocgenero(usuario.getHusesexo());
                             consclin.setCcolusuario(usuario);
                             consclin.setCcocintext(admision.getCacintext());
                             listadeConsultasClinicas.add(consclin);
                         }
                     }
                 }
                 this.serviceLocator.getClinicoService().saveListExamenesLaboratorioCirugiaLiberacion(lstRemision, 
                                                                                                      numeroConsulta, 
                                                                                                      tipoServicio, 
                                                                                                      consecutivo, 
                                                                                                      descripcionRemision, 
                                                                                                      listadeConsultasClinicas, 
                                                                                                      cfdetafacturaList, 
                                                                                                      numeroAdmision);
                 FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
             } catch (ModelException e) {
                 FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                 e.printStackTrace();
             }
//             try {
//                if (!esCirugia) {
//                     obtenerDatosReporteConsulta(numeroConsulta, consecutivo, tipoServicio);
//                } else {
//                    obtenerDatosReporteCirugia();
//                }
             byte[] bytes = generarReporteLaboratorios(numeroConsulta, consecutivo, tipoServicio);
             if (bytes != null) {
                 PdfServletUtils.showPdfDocument(bytes, 
                                         "Interconsulta" + Calendar.getInstance().getTimeInMillis() + 
                                         ".pdf", false);
                 modoConsulta = true;
                 generoDocPDF = true;
             }
//             } catch (Exception e) {
//                 e.printStackTrace();
//                 FacesUtils.addErrorMessage("No pudo generar el reporte " + 
//                                            e.getMessage());
//             }

         } else {
             FacesUtils.addErrorMessage(IMsg.MSG_NO_EXISTEN_EXAMENES);
         }

     }

     // ACCESSORS

     /**
      * @param generoDocPDF
      */
     public void setGeneroDocPDF(boolean generoDocPDF) {
         this.generoDocPDF = generoDocPDF;
     }

     /**
      * @return
      */
     public boolean isGeneroDocPDF() {
         return generoDocPDF;
     }


     /**
      * @param modoConsulta
      */
     public void setModoConsulta(boolean modoConsulta) {
         this.modoConsulta = modoConsulta;
     }

     /**
      * @return
      */
     public boolean isModoConsulta() {
         return modoConsulta;
     }

     /**
      * @param lstExamenesLaboratorios
      */
     public void setLstExamenesLaboratorios(List lstExamenesLaboratorios) {
         this.lstExamenesLaboratorios = lstExamenesLaboratorios;
     }

     /**
      * @return
      */
     public List getLstExamenesLaboratorios() {
         return lstExamenesLaboratorios;
     }

     /**
      * @param descripcionRemision
      */
     public void setDescripcionRemision(String descripcionRemision) {
         this.descripcionRemision = descripcionRemision;
     }

     /**
      * @return
      */
     public String getDescripcionRemision() {
         return descripcionRemision;
     }

     /**
      * @param lstRemision
      */
     public void setLstRemision(List<Chexamelabor> lstRemision) {
         this.lstRemision = lstRemision;
     }

     /**
      * @return
      */
     public List<Chexamelabor> getLstRemision() {
         return lstRemision;
     }

     /**
      * @param dtRemision
      */
     public void setDtRemision(HtmlDataTable dtRemision) {
         this.dtRemision = dtRemision;
     }

     /**
      * @return
      */
     public HtmlDataTable getDtRemision() {
         return dtRemision;
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
      * @param tipoHistoria
      */
     public void setTipoHistoria(Integer tipoHistoria) {
         this.tipoHistoria = tipoHistoria;
     }

     /**
      * @return
      */
     public Integer getTipoHistoria() {
         return tipoHistoria;
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
      * @param dtServicios
      */
     public void setDtServicios(HtmlDataTable dtServicios) {
         this.dtServicios = dtServicios;
     }

     /**
      * @return
      */
     public HtmlDataTable getDtServicios() {
         return dtServicios;
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
      * @param impresionDiagnostica
      */
     public void setImpresionDiagnostica(Chimprdiag impresionDiagnostica) {
         this.impresionDiagnostica = impresionDiagnostica;
     }

     /**
      * @return
      */
     public Chimprdiag getImpresionDiagnostica() {
         return impresionDiagnostica;
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
      * @param numeroConsulta
      */
     public void setNumeroConsulta(Long numeroConsulta) {
         this.numeroConsulta = numeroConsulta;
     }

     /**
      * @return
      */
     public Long getNumeroConsulta() {
         return numeroConsulta;
     }

     /**
      * @param cie10Principal
      */
     public void setCie10Principal(String cie10Principal) {
         this.cie10Principal = cie10Principal;
     }

     /**
      * @return
      */
     public String getCie10Principal() {
         return cie10Principal;
     }

     public void setNumeroAdmision(Long numeroAdmision) {
         this.numeroAdmision = numeroAdmision;
     }

     public Long getNumeroAdmision() {
         return numeroAdmision;
     }

     public void setCfdetafacturaList(List<Cfdetafactura> cfdetafacturaList) {
         this.cfdetafacturaList = cfdetafacturaList;
     }

     public List<Cfdetafactura> getCfdetafacturaList() {
         return cfdetafacturaList;
     }

     public void setTableLaboratorioAdmision(HtmlDataTable tableServiciosAdmision) {
         this.tableLaboratorioAdmision = tableServiciosAdmision;
     }

     public HtmlDataTable getTableLaboratorioAdmision() {
         return tableLaboratorioAdmision;
     }

     public void setCfdetafactura(Cfdetafactura cfdetafactura) {
         this.cfdetafactura = cfdetafactura;
     }

     public Cfdetafactura getCfdetafactura() {
         return cfdetafactura;
     }

     public void setResultList(List<Object[]> resultList) {
         this.resultList = resultList;
     }

     public List<Object[]> getResultList() {
         return resultList;
     }

     public void setAdmision(Cfadmision admision) {
         this.admision = admision;
     }

     public Cfadmision getAdmision() {
         return admision;
     }

     public void setConsulta(Cnconsclin consulta) {
         this.consulta = consulta;
     }

     public Cnconsclin getConsulta() {
         return consulta;
     }
     
     public Long validarLong(Object valor) {
         return valor == null ? null : Long.parseLong(valor.toString());
     }

     public Double validarDouble(Object valor) {
         return valor == null ? null : Double.parseDouble(valor.toString());
     }

     public String validarString(Object valor) {
         return valor == null ? null : valor.toString();
     }
 }
