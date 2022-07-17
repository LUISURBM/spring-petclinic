//=======================================================================
// ARCHIVO ConsultarFoliosBean.java
// FECHA CREACI�N: 26/05/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Creacion de Reporte de consultar folios.
//=======================================================================
package org.profamilia.hc.view.backing.clinico.consultas;

import java.math.BigDecimal;

import java.net.URL;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlDataTable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chinfomamogr;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE SolicitarAnulacionBean
//=======================================================================

public class ConsultarInformeEcografiasBean extends BaseBean implements JRDataSource {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    
     private boolean modoconsulta;

     private boolean generoInforme;
     
    private Chinfomamogr informe;
     
    /** Almacena el consulta */
    private Cnconsclin consulta;

  

     private static int NUMERO_COPIAS = 1;

     private int index = -1;

    private Chusuario usuario;

    private Date fechaFinal;

    private Date fechaInicial;

    /** Almacena true si genero el folio seleccionado */
    private boolean generoHistoria;

    private boolean renderInformacionUsuario;
    
    private boolean renderFolio; 


    StringBuffer sbuffer = new StringBuffer();

    private boolean mostrarReporte;

    private Long numeroUsuario;

    /** Almacena el numero de la consulta*/
    private Long numeroConsulta;

    /** Almacena la consulta seleccionada*/
    private Chconsulta consultaClone;

    private HtmlDataTable dtFolios;

    /** Lista que almacena las consultas de un Usuario */
    private List<Chconsulta> lstFolios;

    private int selectedIndex;
    
    private boolean generoResumen; 


    
    // Datos Reporte

    String CIUDAD;
    Date FECHA;
    String NOMBRES;
    Integer NUMERO_ESTUDIO;
    Integer EDAD;
    String INFORMACION_CLINICA;
    String INFORME;
    String CONCLUSION;
    Long NUMERO_IDENTIFICACION;
    String NOMBRE_MEDICO;
    String NOMBRE_USUARIO;
    String REGISTRO_MEDICO;
    String TRANSDUCTOR;
    String DESCRIPCION_CUPS;
    
    Integer ECTOPICOS; 
    Integer CESAREAS; 
    Integer ABORTOS; 
    Integer PARTOS;
    Integer GESTACIONES; 
    BigDecimal EDAD_GESTACIONAL; 
    Date FUR; 
    String TIPO_DOCUMENTO; 
    String DESCRIPCION_SERVICIO; 
    Integer DIAS_EMBARAZO; 
    Date FECHA_ECOGRAFIA;  

  


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ConsultarInformeEcografiasBean() {
    }

    public void init() {


        generoResumen = false; 
       
        if (usuario == null) {
            usuario = new Chusuario();
        }


    }

    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaci�n fue ingresada correctamente en la base de datos
    //------------------------------------------------------------------------------------------------


    //-----------------------------------------------------------------------
    //  Reporte Jasper
    //-----------------------------------------------------------------------

     public Object getFieldValue(JRField jrField) {

         Object value = null;
         String fieldName = jrField.getName();

         if (fieldName.equals("CIUDAD")) {
             value = CIUDAD;
         } else if (fieldName.equals("FECHA")) {
             value = FECHA;
         } else if (fieldName.equals("NOMBRES")) {
             value = NOMBRES;
         } else if (fieldName.equals("NUMERO_ESTUDIO")) {
             value = NUMERO_ESTUDIO;
         } else if (fieldName.equals("EDAD")) {
             value = EDAD;
         } else if (fieldName.equals("INFORMACION_CLINICA")) {
             value = INFORMACION_CLINICA;
         } else if (fieldName.equals("INFORME")) {
             value = INFORME;
         } else if (fieldName.equals("CONCLUSION")) {
             value = CONCLUSION;
         } else if (fieldName.equals("NUMERO_IDENTIFICACION")) {
             value = NUMERO_IDENTIFICACION;
         } else if (fieldName.equals("NOMBRE_MEDICO")) {
             value = NOMBRE_MEDICO;
         } else if (fieldName.equals("NOMBRE_USUARIO")) {
             value = NOMBRE_USUARIO;
         } else if (fieldName.equals("REGISTRO_MEDICO")) {
             value = REGISTRO_MEDICO;
         } else if (fieldName.equals("TRANSDUCTOR")) {
             value = TRANSDUCTOR;
         } else if (fieldName.equals("DESCRIPCION_CUPS")) {
             value = DESCRIPCION_CUPS;
         }
         
         else if (fieldName.equals("ECTOPICOS")) {
                     value = ECTOPICOS;
                 }
         else if (fieldName.equals("CESAREAS")) {
                     value = CESAREAS;
                 }
         else if (fieldName.equals("ABORTOS")) {
                     value = ABORTOS;
                 }
         else if (fieldName.equals("PARTOS")) {
                     value = PARTOS;
                 }
         else if (fieldName.equals("GESTACIONES")) {
                     value = GESTACIONES;
                 }
         else if (fieldName.equals("EDAD_GESTACIONAL")) {
                     value = EDAD_GESTACIONAL;
         }    
         else if (fieldName.equals("FUR")) {
                     value = FUR;
                 }
         else if (fieldName.equals("TIPO_DOCUMENTO")) {
                     value = TIPO_DOCUMENTO;
                 }
         else if (fieldName.equals("DESCRIPCION_SERVICIO")) {
                     value = DESCRIPCION_SERVICIO;
                 }
         else if (fieldName.equals("DIAS_EMBARAZO")) {
                     value = DIAS_EMBARAZO;
                 }  
                 
         else if (fieldName.equals("FECHA_ECOGRAFIA")) {
                     value = FECHA_ECOGRAFIA;
                 } 
                 
                 
        
             return value;
     }

    public boolean next() {
        index++;
        return (index < NUMERO_COPIAS);
    }


    //-----------------------------------------------------------------------
    //  Ajax
    //-----------------------------------------------------------------------

  



    //-----------------------------------------------------------------------
    //  Boton Principal
    //-----------------------------------------------------------------------

    public void imprimirEcografia() {
    
        try {
                index= -1; 
                   obtenerDatosReporte();
                  URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/informeEcografia.jasper");
                   URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA); 
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
                                                       "InformeEcografia" + Calendar.getInstance().getTimeInMillis() + 
                                                       ".pdf", false);

                       generoInforme = true;
                   //    modoconsulta = true;

                   }
               } catch (Exception e) {
                   e.printStackTrace();
                   FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                              e.getMessage());
               }
    }





    //-----------------------------------------------------------------------
    //  Boton Secundarios
    //-----------------------------------------------------------------------

    public void resetDatos() {
         CIUDAD = null;
         FECHA = null;
         NOMBRES = null;
         NUMERO_ESTUDIO = null;
         EDAD= null;
         INFORMACION_CLINICA= null;
         INFORME= null;
         CONCLUSION= null;
         NUMERO_IDENTIFICACION= null;
         NOMBRE_MEDICO= null;
         NOMBRE_USUARIO= null;
         REGISTRO_MEDICO= null;
         TRANSDUCTOR= null;
         DESCRIPCION_CUPS= null;
        
         ECTOPICOS= null;
         CESAREAS= null;
         ABORTOS= null;
         PARTOS= null;
         GESTACIONES= null;
         EDAD_GESTACIONAL= null;
         FUR= null;
         TIPO_DOCUMENTO= null;
         DESCRIPCION_SERVICIO= null; 
         DIAS_EMBARAZO = null; 
         FECHA_ECOGRAFIA = null; 
     
    }
    
    


  
    
    
    
    



   
   
    public void obtenerDatosReporte() {

        resetDatos();
            if (this.getClinica() != null) {
                CIUDAD = this.getClinica().getCclcciudad();
            }

            if (informe != null) {
                DESCRIPCION_SERVICIO = informe.getHimcdescrinfor(); 
                if (informe.getHimcoperador() != null) {
                    Cpprofesio profesional;
                    profesional = null;
                    try {
                        if (consulta != null) {
                            profesional = 
                                    serviceLocator.getClinicoService().getProfesionalPorUsuario(informe.getHimcoperador(), 
                                                                                               consulta.getCconclinic());
                        }

                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (profesional != null) {
                        NOMBRE_MEDICO = profesional.getCpfcnombre();
                        REGISTRO_MEDICO = profesional.getCpfcregmedic();
                        
                    }
                }

                


                if (usuario != null) {
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
                    if (usuario.getHuscsegundnomb() != null && 
                        !usuario.getHuscsegundnomb().equals("_")) {
                        NOMBRES = NOMBRES + usuario.getHuscsegundnomb() + " ";
                    }
                    if (usuario.getHuscprimerapel() != null) {
                        NOMBRES = NOMBRES + usuario.getHuscprimerapel() + " ";
                    }
                    if (usuario.getHuscsegundapel() != null && 
                        !usuario.getHuscsegundapel().equals("_")) {
                        NOMBRES = NOMBRES + usuario.getHuscsegundapel();
                    }

                    if (usuario.getHusanumeiden() != 0) {
                        NUMERO_IDENTIFICACION = usuario.getHusanumeiden();
                    }
                    TIPO_DOCUMENTO = usuario.getHusetipoiden(); 

                }


                FECHA = informe.getHimdfecregistr();

                if (informe.getHimnnumero() != null) {
                    NUMERO_ESTUDIO = informe.getHimnnumero();
                }

                if (informe.getHimcdatosclire() != null) {
                    INFORMACION_CLINICA = informe.getHimcdatosclire();
                }

                if (informe.getHimcinformamog() != null) {
                    INFORME = informe.getHimcinformamog();
                }

                if (informe.getHimcopinion() != null) {
                    CONCLUSION =formatearCampoCLOB(informe.getHimcopinion());
                }
                if (informe.getHimctransducto() != null) {
                    TRANSDUCTOR = informe.getHimctransducto();
                }
                
                GESTACIONES = informe.getHimnnumgesta();
                PARTOS = informe.getHimnnumparto();
                ABORTOS = informe.getHimnnumaborto();
                CESAREAS = informe.getHimnnumcesare();
                ECTOPICOS = informe.getHimnectopico();
                EDAD_GESTACIONAL = informe.getHimnedadgesmes(); 
                DIAS_EMBARAZO = informe.getHimndiasgestac(); 
                FUR = informe.getHimdfur(); 
                FECHA_ECOGRAFIA = informe.getHimdfecregistr(); 
            }
        }
        
    public void generarImpresionFolio() {
        obtenerDatosReporte();
        index = -1; 
                   try {
                              
                             URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/informeEcografia.jasper");
                              URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA); 
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
                                                                  "InformeEcografia" + Calendar.getInstance().getTimeInMillis() + 
                                                                  ".pdf", false);

                                  generoInforme = true;
                              //    modoconsulta = true;

                              }
                          } catch (Exception e) {
                              e.printStackTrace();
                              FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                                         e.getMessage());
                          }

            

    }

        
    public void visualizarConsulta() {

        JasperPrint jasperPrint;
        jasperPrint = null;
        this.index = -1;
              
        obtenerDatosReporte();


        try {

            URL url = 
                FacesUtils.getFacesContext().getExternalContext().getResource("/reports/informeEcografia.jasper");
            ExternalContext externalContext = 
                FacesContext.getCurrentInstance().getExternalContext();
            HttpServletRequest request = 
                (HttpServletRequest)externalContext.getRequest();

            if (url != null) {

                Map parameters = new HashMap();
                JRHtmlExporter exporter = new JRHtmlExporter();

                JasperReport report = (JasperReport)JRLoader.loadObject(url);
                jasperPrint = 
                        JasperFillManager.fillReport(report, parameters, (JRDataSource)this);
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, 
                                      jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_STRING_BUFFER, 
                                      sbuffer);


                exporter.setParameter(JRHtmlExporterParameter.IMAGES_MAP, 
                                      parameters);
                exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, 
                                      request.getContextPath() + 
                                      "/comun/imagenes?image=");

                exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, 
                                      Boolean.FALSE);
                exporter.setParameter(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, 
                                      Boolean.TRUE);
                exporter.setParameter(JRHtmlExporterParameter.CHARACTER_ENCODING, 
                                      "ISO-8859-9");
                exporter.setParameter(JRHtmlExporterParameter.HTML_FOOTER, "");
                exporter.setParameter(JRHtmlExporterParameter.HTML_HEADER, "");

                request.getSession().setAttribute("jasperPrint", jasperPrint);

            }
        } catch (Exception e) {

            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());

        }
    }


  


 



    //-----------------------------------------------------------------------
    //  ACCESORIOS
    //-----------------------------------------------------------------------

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
     * @param consultaClone
     */
    public void setConsultaClone(Chconsulta consultaClone) {
        this.consultaClone = consultaClone;
    }

    /**
     * @return
     */
    public Chconsulta getConsultaClone() {
        return consultaClone;
    }

    /**
     * @param dtFolios
     */
    public void setDtFolios(HtmlDataTable dtFolios) {
        this.dtFolios = dtFolios;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtFolios() {
        return dtFolios;
    }

    /**
     * @param lstFolios
     */
    public void setLstFolios(List<Chconsulta> lstFolios) {
        this.lstFolios = lstFolios;
    }

    /**
     * @return
     */
    public List<Chconsulta> getLstFolios() {
        return lstFolios;
    }


    /**
     * @param fechaFinal
     */
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * @return
     */
    public Date getFechaFinal() {
        return fechaFinal;
    }

    /**
     * @param fechaInicial
     */
    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    /**
     * @return
     */
    public Date getFechaInicial() {
        return fechaInicial;
    }




    /**
     * @param mostrarReporte
     */
    public void setMostrarReporte(boolean mostrarReporte) {
        this.mostrarReporte = mostrarReporte;
    }

    /**
     * @return
     */
    public boolean isMostrarReporte() {
        return mostrarReporte;
    }


    /**
     * @param generoHistoria
     */
    public void setGeneroHistoria(boolean generoHistoria) {
        this.generoHistoria = generoHistoria;
    }

    /**
     * @return
     */
    public boolean isGeneroHistoria() {
        return generoHistoria;
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
     * @param selectedIndex
     */
    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    /**
     * @return
     */
    public int getSelectedIndex() {
        return selectedIndex;
    }

   

  

    /**
     * @param renderInformacionUsuario
     */
    public void setRenderInformacionUsuario(boolean renderInformacionUsuario) {
        this.renderInformacionUsuario = renderInformacionUsuario;
    }

    /**
     * @return
     */
    public boolean isRenderInformacionUsuario() {
        renderInformacionUsuario = false;
        if (usuario != null && usuario.getHuslnumero() != null) {
            renderInformacionUsuario = true;
        }
        return renderInformacionUsuario;
    }

    /**
     * @param renderFolio
     */
    public void setRenderFolio(boolean renderFolio) {
        this.renderFolio = renderFolio;
    }

    /**
     * @return
     */
    public boolean isRenderFolio() {
        return renderFolio;
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
     * @param generoInforme
     */
    public void setGeneroInforme(boolean generoInforme) {
        this.generoInforme = generoInforme;
    }

    /**
     * @return
     */
    public boolean isGeneroInforme() {
        return generoInforme;
    }

    /**
     * @param consulta
     */
    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    /**
     * @return
     */
    public Cnconsclin getConsulta() {
        return consulta;
    }

    /**
     * @param generoResumen
     */
    public void setGeneroResumen(boolean generoResumen) {
        this.generoResumen = generoResumen;
    }

    /**
     * @return
     */
    public boolean isGeneroResumen() {
        return generoResumen;
    }

    public void setInforme(Chinfomamogr informe) {
        this.informe = informe;
    }

    public Chinfomamogr getInforme() {
        return informe;
    }
}


