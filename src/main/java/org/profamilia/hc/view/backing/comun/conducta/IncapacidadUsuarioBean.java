 //=======================================================================
 // ARCHIVO IncapacidadUsuarioBean.java
 // FECHA CREACI�N: 15/06/2010 - 27/07/2016
 // AUTOR: J�se Andr�s Riano, Carlos Andres Vargas Roa
 // Descripci�n: Datos correspondientes a la conducta de Incapacidad.
 //=======================================================================
 package org.profamilia.hc.view.backing.comun.conducta;

import java.math.BigDecimal;

import java.net.URL;

 import java.util.ArrayList;
 import java.util.Calendar;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

 import javax.faces.model.SelectItem;

 import net.sf.jasperreports.engine.JRDataSource;
 import net.sf.jasperreports.engine.JRField;
 import net.sf.jasperreports.engine.JasperReport;
 import net.sf.jasperreports.engine.JasperRunManager;
 import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chdetaldescr;
import org.profamilia.hc.model.dto.Chincapacida;
 import org.profamilia.hc.model.dto.ChincapacidaPK;
 import org.profamilia.hc.model.dto.Chusuario;
 import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Crdgncie10;
 import org.profamilia.hc.model.exceptions.ModelException;
 import org.profamilia.hc.view.backing.BaseBean;
 import org.profamilia.hc.view.util.FacesUtils;
 import org.profamilia.hc.view.util.PdfServletUtils;

 //=======================================================================
 //  BIBLIOTECAS REQUERIDAS
 //=======================================================================


 //=======================================================================
 //  CLASE IncapacidadUsuarioBean
 //=======================================================================

 public class IncapacidadUsuarioBean extends BaseBean implements JRDataSource {

     //-----------------------------------------------------------------------
     //  ATRIBUTOS DE INSTANCIA
     //-----------------------------------------------------------------------

     private int index = -1;

     private static int NUMERO_INCAPACIDADES = 1;

     private boolean generoIncapacidad;

     /** Variable que almacena true si ya se genero 
      * la incapacidad por tal motivo queda en modo consulta*/
     private boolean modoconsulta;

     /** Variable que almacena el objeto incapacidad*/
     private Chincapacida incapacidad;

     /** Lista que almacena los tipos de Incapacidad  */
     private List lstTipoIncapacidad;

     /** Lista que almacena los posibles origenes de la Incapcidad*/
     private List lstOrigenIncapacidad;

     private Integer tipoHistoria;

     private boolean esCirugia;

     // Datos Reporte de Incapacidad 
     String NOMBRES;

     String APELLIDOS;

     String TIPO_DOCUMENTO;

     Long NUMERO_DOCUMENTO;

     String DIAGNOSTICO_PRINCIPAL;

     String DIAGNOSTICO_SECUNDARIO;

     String CODIGO_CIE10_PRINCIPAL;

     String CODIGO_CIE10_SECUNDARIO;

     String DESC_SERVICIO;

     String CODIGO_CUPS;
     
     String NOMBRE_PROFESIONAL;
     
    String TIPOID_PROFESIONAL;
    
    BigDecimal NUMID_PROFESIONAL;
     
     String REGISTRO_MEDICO;
     
    String ESPECIALIDAD = null;


     int DURACION;

     String TIPO_INCAPACIDAD;

     String ORIGEN_INCAPACIDAD;
     
     Integer CODIGO_ORIGEN;

     Date FECHA_INICIAL;

     Date FECHA_FINAL;

     /** Almacena el consulta */
     private Long numeroConsulta;

     /** Almacena el usuario que se desea guardar */
     private Chusuario usuario;

     private String tipoServicio;

     private String menuBean;

     private Integer consecutivo;

     private String cie10Principal;

     private String cie10Relacionado1;

     private String codigoCups;
     
     private boolean ligadura;
     
     private boolean vasectomia;
     
     /** Almacena el detalle de la descripcion quirurgica */
     private Chdetaldescr detaldescr;
     
     /** Amacena el CIE10*/
     private Crdgncie10 diagprin;
     
    private Crdgncie10 diagrela;

     
     private Chdetacirpro detalleCirugia;
     
     private Cpservicio servicio;

     //-----------------------------------------------------------------------
     //  METODO CONSTRUCTOR
     //----------------------------------------------------------------------- 

     public IncapacidadUsuarioBean() {
     }

     //ACTIONS  

     public void init() {
         
         modoconsulta = false;
         inicializarIncapacidad();

     }

     public void inicializarIncapacidad() {
         generoIncapacidad = false;
         CODIGO_ORIGEN = null;

         try {

             incapacidad = 
                     this.getServiceLocator().getClinicoService().getIncapcidad(numeroConsulta, 
                                                                                tipoServicio, 
                                                                                consecutivo);

         } catch (ModelException e) {
             e.printStackTrace();
         }

         if (incapacidad == null) {
             incapacidad = new Chincapacida();
             modoconsulta = false;
             if(ligadura || vasectomia){
                 incapacidad.setHidndias(5);
                 incapacidad.setHindfecinicia(new Date());
                 incapacidad.setHidnorigeincap(2);
                 incapacidad.setHidntipoincapa(2);
             }
         } else {
         
             modoconsulta = true;
         }
     }


     //-----------------------------------------------------------------------
     //  Get/Set
     //-----------------------------------------------------------------------

     /**
      * @param incapacidad
      */
     public void setIncapacidad(Chincapacida incapacidad) {
         this.incapacidad = incapacidad;
     }

     /**
      * @return
      */
     public Chincapacida getIncapacidad() {
         return incapacidad;
     }


     /**
      * @param lstTipoIncapacidad
      */
     public void setLstTipoIncapacidad(List lstTipoIncapacidad) {
         this.lstTipoIncapacidad = lstTipoIncapacidad;
     }
 

     /**
      * @return
      */
     public List getLstTipoIncapacidad() {
         if (lstTipoIncapacidad == null) {
             lstTipoIncapacidad = new ArrayList();
             //lstTipoIncapacidad.add(new SelectItem("", 
                                              //     "Seleccione una opci�n..."));
          //   lstTipoIncapacidad.add(new SelectItem(1, "Hospilitaria"));
             lstTipoIncapacidad.add(new SelectItem(2, "Ambulatoria"));
           //  lstTipoIncapacidad.add(new SelectItem(3, "Cirugia Ambulatoria"));
         }
         return lstTipoIncapacidad;
     }

     /**
      * @param lstOrigenIncapacidad
      */
     public void setLstOrigenIncapacidad(List lstOrigenIncapacidad) {
         this.lstOrigenIncapacidad = lstOrigenIncapacidad;
     }

     /**
      * @return
      */
     public List getLstOrigenIncapacidad() {
         if (lstOrigenIncapacidad == null) {
             lstOrigenIncapacidad = new ArrayList();
             lstOrigenIncapacidad.add(new SelectItem("", 
                                                     "Seleccione una opci�n"));
        //     lstOrigenIncapacidad.add(new SelectItem(1, "No Aplica"));
             lstOrigenIncapacidad.add(new SelectItem(2, "Enfermedad General"));
             lstOrigenIncapacidad.add(new SelectItem(3, "Enfermedad Profesional"));
             lstOrigenIncapacidad.add(new SelectItem(4, "Accidente de Trabajo"));
             lstOrigenIncapacidad.add(new SelectItem(5, "Accidente de Transito"));
         //    lstOrigenIncapacidad.add(new SelectItem(6, 
                                                  //   "Licencia de Paternidad"));

         }
         return lstOrigenIncapacidad;
     }


     /**
      * @param generoIncapacidad
      */
     public void setGeneroIncapacidad(boolean generoIncapacidad) {
         this.generoIncapacidad = generoIncapacidad;
     }

     /**
      * @return
      */
     public boolean isGeneroIncapacidad() {
         return generoIncapacidad;
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

     /**
      * @param cie10Relacionado1
      */
     public void setCie10Relacionado1(String cie10Relacionado1) {
         this.cie10Relacionado1 = cie10Relacionado1;
     }

     /**
      * @return
      */
     public String getCie10Relacionado1() {
         return cie10Relacionado1;
     }

     /**
      * @param codigoCups
      */
     public void setCodigoCups(String codigoCups) {
         this.codigoCups = codigoCups;
     }

     /**
      * @return
      */
     public String getCodigoCups() {
         return codigoCups;
     }

     //------------------------------------------------------------------------------
     //  Metodo esValido que garantiza que el registro fue guardado exitosamente
     //------------------------------------------------------------------------------

     public boolean esValido() {
         boolean esValido = false;
         Chincapacida incapacidadAux = null;
         if (numeroConsulta != null) {
             try {
                 incapacidadAux = 
                         this.getServiceLocator().getClinicoService().getIncapcidad(numeroConsulta);
             } catch (ModelException e) {
                 e.printStackTrace();
             }


             if (incapacidadAux != null) {
                 esValido = true;
             } else {
                 esValido = false;
             }

         }
         return esValido;
     }

     //------------------------------------------------------------------------------
     //  Construir Reporte
     //------------------------------------------------------------------------------


     /**
      * @return
      */
     public boolean next() {
         index++;
         return (index < NUMERO_INCAPACIDADES);
     }

     /**
       * @param jrField
       * @return
       */

     /**
      * @param jrField
      * @return
      */
     public Object getFieldValue(JRField jrField) {

         Object value = null;
         String fieldName = jrField.getName();

         if (fieldName.equals("Ciudad")) {
             value = this.getClinica().getCclcciudad();
         } else if (fieldName.equals("FechaExpedicion")) {
             value = new Date();
         } else if (fieldName.equals("Nombres")) {
             value = NOMBRES;
         } else if (fieldName.equals("Apellidos")) {
             value = APELLIDOS;
         } else if (fieldName.equals("TipoDoc")) {
             value = TIPO_DOCUMENTO;
         } else if (fieldName.equals("NumeroDoc")) {
             value = NUMERO_DOCUMENTO;
         } else if (fieldName.equals("DIAGNOSTICO_PRINCIPAL")) {
             value = DIAGNOSTICO_PRINCIPAL;
         } else if (fieldName.equals("CIE10Principal")) {
             value = CODIGO_CIE10_PRINCIPAL;
         } else if (fieldName.equals("DiagnosticoSecundario")) {
             value = DIAGNOSTICO_SECUNDARIO;
         } else if (fieldName.equals("CIE10Secundario")) {
             value = CODIGO_CIE10_SECUNDARIO;
         } else if (fieldName.equals("IntervencionProcedimiento")) {
             value = DESC_SERVICIO;
         } else if (fieldName.equals("CodigoCups")) {
             value = CODIGO_CUPS;
         } else if (fieldName.equals("FechaIni")) {
             value = FECHA_INICIAL;
         } else if (fieldName.equals("FechaFin")) {
             value = FECHA_FINAL;
         } else if (fieldName.equals("Duracion")) {
             value = DURACION;
         } else if (fieldName.equals("Prorroga")) {
             value = " ";
         } else if (fieldName.equals("TipoIncapacidad")) {
             value = TIPO_INCAPACIDAD;
         } else if (fieldName.equals("OrigenIncapacidad")) {
             value = ORIGEN_INCAPACIDAD;
         } else if (fieldName.equals("CODIGO_ORIGEN")) {
             value = CODIGO_ORIGEN;
         } 
         
         
         else if (fieldName.equals("NombreProfesional")) {
             value = this.getUsuarioSystem().getCurcnombre();
         }else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
             value = NOMBRE_PROFESIONAL;
         } 
        else if (fieldName.equals("TIPOID_PROFESIONAL")) {
              value = TIPOID_PROFESIONAL;
         }
        else if (fieldName.equals("NUMID_PROFESIONAL")) {
              value = NUMID_PROFESIONAL;
        }else if (fieldName.equals("REGISTRO_MEDICO")) {
             value = REGISTRO_MEDICO;
         }
         if (fieldName.equals("ESPECIALIDAD")) {
                        value = ESPECIALIDAD;
                        return value;
                    }


         return value;
     }

     public void obtenerDatosReporteCirugia() {

         Chusuario usuarioAux;
         usuarioAux = null;

         if (usuario != null) {
             usuarioAux = usuario;

         }


         if (usuarioAux != null) {
             if (usuarioAux.getHuscprimernomb() != null) {
                 NOMBRES = usuarioAux.getHuscprimernomb() + " ";
             }
             if (usuarioAux.getHuscsegundnomb() != null && 
                 !usuarioAux.getHuscsegundnomb().equals("_")) {
                 NOMBRES = NOMBRES + usuarioAux.getHuscsegundnomb();
             }
             if (usuarioAux.getHuscprimerapel() != null) {
                 APELLIDOS = usuarioAux.getHuscprimerapel() + " ";
             }
             if (usuarioAux.getHuscsegundapel() != null && 
                 !usuarioAux.getHuscsegundapel().equals("_")) {
                 APELLIDOS = APELLIDOS + usuarioAux.getHuscsegundapel();
             }
             if (usuarioAux.getHusetipoiden() != null) {
                 TIPO_DOCUMENTO = usuarioAux.getHusetipoiden().toString();
             }
             if (usuarioAux.getHusanumeiden() != 0) {
                 NUMERO_DOCUMENTO = usuarioAux.getHusanumeiden();
             }
         }
         
         
         if(numeroConsulta != null && !numeroConsulta.equals("")){
             try{
                detaldescr = 
                 this.serviceLocator.getCirugiaService().getDetalleDescripcion(numeroConsulta);
             }catch(ModelException e){
                 e.printStackTrace();
             }
             
             if(detaldescr != null && !detaldescr.equals("")){
             if(detaldescr.getHddcdiagnprinc() != null && !detaldescr.getHddcdiagnprinc().equals("")){
                 CODIGO_CIE10_PRINCIPAL = detaldescr.getHddcdiagnprinc().toUpperCase();
                 try{
                     diagprin = 
                             this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10_PRINCIPAL);
                     } catch (ModelException e) {
                     e.printStackTrace();
                     }
                 if(diagprin != null && !diagprin.equals("")){
                     DIAGNOSTICO_PRINCIPAL = diagprin.getCdccdescri();
                     
                 }
             }
             if(detaldescr.getHddcdiagnrelac() != null && !detaldescr.getHddcdiagnrelac().equals("")){
             
                 CODIGO_CIE10_SECUNDARIO = detaldescr.getHddcdiagnrelac().toUpperCase();
                 try{
                     diagrela = 
                             this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10_SECUNDARIO);
                     } catch (ModelException e) {
                     e.printStackTrace();
                     }
                 if(diagrela != null && !diagrela.equals("")){
                     DIAGNOSTICO_SECUNDARIO = diagrela.getCdccdescri();
                     
                 }
              
             }
              
            
             
         }
         
         try{
             detalleCirugia =
                            this.serviceLocator.getCirugiaService().getServicioDetalle(numeroConsulta);
         }catch(ModelException e){
             e.printStackTrace();
         }
         
         if(detalleCirugia != null){
                try {
                    servicio =
                    this.serviceLocator.getClinicoService().getDescripcionCupsCompleto(detalleCirugia.getId().getHdccservicio());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                
                if(servicio != null){
                    DESC_SERVICIO = servicio.getCsvcnombre();
                    CODIGO_CUPS = servicio.getCsvccodcups();
                }
                
                
            }
         
         }
         


         DURACION = incapacidad.getHidndias();

         if (incapacidad != null && incapacidad.getHidntipoincapa() != null) {
             if (incapacidad.getHidntipoincapa() != null) {
                 if (incapacidad.getHidntipoincapa().equals(1)) {
                     TIPO_INCAPACIDAD = "Hospilitaria";
                 }
                 if (incapacidad.getHidntipoincapa().equals(2)) {
                     TIPO_INCAPACIDAD = "Ambulatoria";
                 }
                 if (incapacidad.getHidntipoincapa().equals(3)) {
                     TIPO_INCAPACIDAD = "Cirugia Ambulatoria";
                 }
             }
         }

         if (incapacidad != null && incapacidad.getHidnorigeincap() != null) {
             if (incapacidad.getHidnorigeincap() != null) {
             
                 CODIGO_ORIGEN = incapacidad.getHidnorigeincap();
                 if (incapacidad.getHidnorigeincap().equals(1)) {
                     ORIGEN_INCAPACIDAD = "No Aplica";
                 }
                 if (incapacidad.getHidnorigeincap().equals(2)) {
                         ORIGEN_INCAPACIDAD = "Enfermedad General";
                 }
                 if (incapacidad.getHidnorigeincap().equals(3)) {
                     ORIGEN_INCAPACIDAD = "Enfermedad Profesional";
                 }
                 if (incapacidad.getHidnorigeincap().equals(4)) {
                     ORIGEN_INCAPACIDAD = "Accidente de Trabajo";
                 }
                 if (incapacidad.getHidnorigeincap().equals(5)) {
                     ORIGEN_INCAPACIDAD = "Accidente de Transito";
                 }
                 /*if (incapacidad.getHidnorigeincap().equals(6)) {
                     ORIGEN_INCAPACIDAD = "Licencia de Paternidad";
                 }*/
             }
         }
         
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
                 NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                 REGISTRO_MEDICO = profesional.getCpfcregmedic();
                 TIPOID_PROFESIONAL = profesional.getCpfctipide();
                 NUMID_PROFESIONAL = profesional.getCpfacedula();
                ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
             }
        

                  }


         if (incapacidad != null && incapacidad.getHindfecinicia() != null && 
             incapacidad.getHidndias() != null) {
             Calendar fechafinalAux;
             fechafinalAux = Calendar.getInstance();
             fechafinalAux.setTime(incapacidad.getHindfecinicia());
             // Se resta el dia actual
             fechafinalAux.add(Calendar.DAY_OF_YEAR, 
                               incapacidad.getHidndias() - 1);
             FECHA_INICIAL = incapacidad.getHindfecinicia();
             FECHA_FINAL = fechafinalAux.getTime();
         }

     }


     public void obtenerDatosReporteConsulta() {
         if (usuario != null) {
             if (usuario.getHuscprimernomb() != null) {
                 NOMBRES = usuario.getHuscprimernomb() + " ";
             }
             if (usuario.getHuscsegundnomb() != null && 
                 !usuario.getHuscsegundnomb().equals("_")) {
                 NOMBRES = NOMBRES + usuario.getHuscsegundnomb();
             }
             if (usuario.getHuscprimerapel() != null) {
                 APELLIDOS = usuario.getHuscprimerapel() + " ";
             }
             if (usuario.getHuscsegundapel() != null && 
                 !usuario.getHuscsegundapel().equals("_")) {
                 APELLIDOS = APELLIDOS + usuario.getHuscsegundapel();
             }
             if (usuario.getHusetipoiden() != null) {
                 TIPO_DOCUMENTO = usuario.getHusetipoiden().toString();
             }
             if (usuario.getHusanumeiden() != 0) {
                 NUMERO_DOCUMENTO = usuario.getHusanumeiden();
             }


             if (codigoCups != null) {
                 CODIGO_CUPS = codigoCups;
                 try {
                     DESC_SERVICIO = 
                             this.serviceLocator.getClinicoService().getDescripcionCups(CODIGO_CUPS);
                 } catch (ModelException e) {
                     e.printStackTrace();
                 }
             }
         }


         if (cie10Principal != null) {
             Crdgncie10 diagprin = null;
             CODIGO_CIE10_PRINCIPAL = cie10Principal.toUpperCase();
             DIAGNOSTICO_PRINCIPAL = cie10Principal;

             try {
                 diagprin = 
                         this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10_PRINCIPAL);
             } catch (ModelException e) {
                 e.printStackTrace();
             }

             if (diagprin != null) {
                 DIAGNOSTICO_PRINCIPAL = diagprin.getCdccdescri();
             }
         }
         if (cie10Relacionado1 != null) {
             Crdgncie10 diagrela1 = null;
             CODIGO_CIE10_SECUNDARIO = cie10Relacionado1.toUpperCase();
             try {
                 diagrela1 = 
                         this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10_SECUNDARIO);
             } catch (ModelException e) {
                 e.printStackTrace();
             }

             if (diagrela1 != null) {
                 DIAGNOSTICO_SECUNDARIO = diagrela1.getCdccdescri();
             }
         }

         DURACION = incapacidad.getHidndias();
         if (incapacidad != null && incapacidad.getHidntipoincapa() != null) {
             if (incapacidad.getHidntipoincapa() != null) {
                 if (incapacidad.getHidntipoincapa().equals(1)) {
                     TIPO_INCAPACIDAD = "Hospilitaria";
                 }
                 if (incapacidad.getHidntipoincapa().equals(2)) {
                     TIPO_INCAPACIDAD = "Ambulatoria";
                 }
                 if (incapacidad.getHidntipoincapa().equals(3)) {
                     TIPO_INCAPACIDAD = "Cirugia Ambulatoria";
                 }
             }
         }

         if (incapacidad != null && incapacidad.getHidnorigeincap() != null) {
             if (incapacidad.getHidnorigeincap() != null) {
                 CODIGO_ORIGEN = incapacidad.getHidnorigeincap();
                 if (incapacidad.getHidnorigeincap().equals(1)) {
                     ORIGEN_INCAPACIDAD = "No Aplica";
                 }
                 if (incapacidad.getHidnorigeincap().equals(2)) {
                     ORIGEN_INCAPACIDAD = "Enfermedad General";
                 }
                 if (incapacidad.getHidnorigeincap().equals(3)) {
                     ORIGEN_INCAPACIDAD = "Enfermedad Profesional";
                 }
                 if (incapacidad.getHidnorigeincap().equals(4)) {
                     ORIGEN_INCAPACIDAD = "Accidente de Trabajo";
                 }
                 if (incapacidad.getHidnorigeincap().equals(5)) {
                     ORIGEN_INCAPACIDAD = "Accidente de Transito";
                 }
                /* if (incapacidad.getHidnorigeincap().equals(6)) {
                     ORIGEN_INCAPACIDAD = "Licencia de Paternidad";
                 }*/
             }
         }
         
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
                 NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                 TIPOID_PROFESIONAL = profesional.getCpfctipide();
                 NUMID_PROFESIONAL = profesional.getCpfacedula();
                 REGISTRO_MEDICO = profesional.getCpfcregmedic();
                 ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
             }
         }

         if (incapacidad != null && incapacidad.getHindfecinicia() != null && 
             incapacidad.getHidndias() != null) {
             Calendar fechafinalAux;
             fechafinalAux = Calendar.getInstance();
             fechafinalAux.setTime(incapacidad.getHindfecinicia());
             // Se resta el dia actual
             fechafinalAux.add(Calendar.DAY_OF_YEAR, 
                               incapacidad.getHidndias() - 1);
             FECHA_INICIAL = incapacidad.getHindfecinicia();
             FECHA_FINAL = fechafinalAux.getTime();
         }


     }


     //--------------------------------------------------------------------------
     //  Bot�n principal
     //--------------------------------------------------------------------------    


     public void generarIncapacidad() {
         this.index = -1;
         ChincapacidaPK id = new ChincapacidaPK();

         if (incapacidad.getHidndias() <= 60) {

             if (incapacidad.getHidndias() > 0) {

                 incapacidad.setHidcoperador(userName());
                 incapacidad.setHiddfecregistr(new Date());


                 if (numeroConsulta != null && tipoServicio != null && 
                     consecutivo != null) {
                     id.setHinlconsulta(numeroConsulta);
                     id.setHinctiposervi(tipoServicio);
                     id.setHinnconsecutiv(consecutivo);
                     incapacidad.setId(id);
                 }


                 try {
                     this.serviceLocator.getClinicoService().saveIncapacidad(incapacidad);
                     FacesUtils.addInfoMessage(MSG_ADICION);

                 } catch (ModelException e) {
                     FacesUtils.addErrorMessage(MSG_NO_ADICION);
                     e.printStackTrace();
                 }
                 try {
                     if (!esCirugia) {
                         obtenerDatosReporteConsulta();
                     } else {
                         obtenerDatosReporteCirugia();
                     }

                    URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/incapacidad2.jasper");
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
                                 JasperRunManager.runReportToPdf(report, 
                                                                 parameters, 
                                                                 (JRDataSource)this);
                         PdfServletUtils.showPdfDocument(bytes, 
                                                         "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                                         ".pdf", false);
                         generoIncapacidad = true;
                         modoconsulta = true;
                        
                        
                     }
                 } catch (Exception e) {
                     e.printStackTrace();
                     FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                                e.getMessage());
                 }
             } else {
                 FacesUtils.addErrorMessage(MSG_VALIDACION_FECHA_MENOR);
             }
         } else {
             FacesUtils.addErrorMessage(MSG_VALIDACION_INCAPACIDA_DIAS);
         }
         

     }


     public void setLigadura(boolean ligadura) {
         this.ligadura = ligadura;
     }

     public boolean isLigadura() {
         return ligadura;
     }

    public void setDetaldescr(Chdetaldescr detaldescr) {
        this.detaldescr = detaldescr;
    }

    public Chdetaldescr getDetaldescr() {
        return detaldescr;
    }

    public void setDiagprin(Crdgncie10 diagprin) {
        this.diagprin = diagprin;
    }

    public Crdgncie10 getDiagprin() {
        return diagprin;
    }

    public void setDetalleCirugia(Chdetacirpro detalleCirugia) {
        this.detalleCirugia = detalleCirugia;
    }

    public Chdetacirpro getDetalleCirugia() {
        return detalleCirugia;
    }

    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }

    public void setVasectomia(boolean vasectomia) {
        this.vasectomia = vasectomia;
    }

    public boolean isVasectomia() {
        return vasectomia;
    }
}
