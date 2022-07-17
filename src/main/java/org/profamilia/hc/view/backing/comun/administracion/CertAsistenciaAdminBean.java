package org.profamilia.hc.view.backing.comun.administracion;
//=======================================================================
// ARCHIVO CerAsistenciaAdminBean.java
// FECHA CREACI�N: 28/04/2020
// AUTOR: Diana Rodriguez
// Descripci�n: Certificado de asistencia Administrativo.
//=======================================================================

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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chcertmedico;
import org.profamilia.hc.model.dto.ChcertmedicoPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cptipoiden;
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
//  CLASE CertMedicoUsuarioBean
//==============================================================================

public class CertAsistenciaAdminBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

   private boolean generoCertificado;


    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;


    String NOMBRES;

    String PRIMER_APELLIDO;

    String SEGUNDO_APELLIDO;

    String TIPO_DOCUMENTO;

    Long NUMERO_DOCUMENTO;

    String ANO;

    String MES;

    String DIA;

    Integer EDAD;

    Date fecha;

    String DESCRIPCION_CERTIFICADO;

    String NOMBRE_USUARIO;
    
    String NOMBRE_PROFESIONAL;
    
    String REGISTRO_MEDICO; 
    
    String ESPECIALIDAD = null;

    /** Almacena el consulta */
    private Long numeroConsulta;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private String menuBean;
    
    private String descrpcionCertificado;
    
    private String tipoId;
    
    private Long numId;
    
    private  String nombres;
    
    private int index= -1;


    //------------------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //------------------------------------------------------------------------------

    public CertAsistenciaAdminBean() {
    }

    //ACTIONS 

    public void init() {
        generoCertificado = false;
        descrpcionCertificado = "";
        tipoId = "";
        numId= null;
        nombres = "";
    }


    /**
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        return esValido;
    }

    //-----------------------------------------------------------------------
    //  Construir Reporte
    //-----------------------------------------------------------------------

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
        if (fieldName.equals("EDAD")) {
            value = EDAD;
            return value;
        }
        if (fieldName.equals("TIPO_DOCUMENTO")) {
            value = TIPO_DOCUMENTO;
            return value;
        }
        if (fieldName.equals("FECHA")) {
            value = new Date();
            return value;
        }
        if (fieldName.equals("DESCRIPCION_CERTIFICADO")) {
            value = DESCRIPCION_CERTIFICADO;
            return value;
        }

        if (fieldName.equals("EDAD")) {
            value = EDAD;
            return value;
        }
        if (fieldName.equals("NOMBRE_USUARIO")) {
            value = NOMBRE_USUARIO;
            return value;
        }
        if (fieldName.equals("NOMBRE_PROFESIONAL")) {
            value = NOMBRE_PROFESIONAL;
            return value;
        } 
        if (fieldName.equals("REGISTRO_MEDICO")) {
            value = REGISTRO_MEDICO;
            return value;
        }  if (fieldName.equals("ESPECIALIDAD")) {
                        value = ESPECIALIDAD;
                        return value;
                    }


        return null;

    }


  

    public void obtenerDatosReporteConsulta() {
    

           /* if (usuario.getHusdfechanacim() != null) {
                Date fechaNacimiento = usuario.getHusdfechanacim();
                if (fechaNacimiento != null) {
                    int edad = calcularEdad(fechaNacimiento, new Date());
                    EDAD = edad;
                }

            }*/

          
                NOMBRES =nombres;
                
                 TIPO_DOCUMENTO = tipoId;
      
                NUMERO_DOCUMENTO =numId;
     
            fecha = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fecha);
            Integer diaact = calendar.get(Calendar.DAY_OF_MONTH);
            Integer mesact = calendar.get(Calendar.MONTH) + 1;
            Integer ANOact = calendar.get(calendar.YEAR);

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

            ANO = ANOact.toString();

         DESCRIPCION_CERTIFICADO =descrpcionCertificado;
  

        if (getUsuarioSystem() != null) {
            NOMBRE_USUARIO = getUsuarioSystem().getCurcnombre();
        }

    }


    //--------------------------------------------------------------------------
    //  Bot�n principal
    //--------------------------------------------------------------------------    


    public void generarCertificado() {

        fecha = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        Integer diaact = calendar.get(Calendar.DAY_OF_MONTH);
        Integer mesact = calendar.get(Calendar.MONTH) + 1;
        Integer ANOact = calendar.get(calendar.YEAR);
        String dia="";
        String mes="";
        String ANO="";
        String usuarioRegistra="";

        if (diaact.compareTo(10) < 0) {
            dia = "0" + diaact.toString();
        } else {
            dia = diaact.toString();
        }

        if (mesact.compareTo(10) < 0) {
            mes = "0" + mesact.toString();
        } else {
            mes = mesact.toString();
        }

        ANO = ANOact.toString();

        if (getUsuarioSystem() != null) {
          usuarioRegistra = getUsuarioSystem().getCurcnombre();
        }
        try {
           
           URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/certificadoAdministrador.jasper");
            URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA); 
            URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL); 
            URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL); 
            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                parameters.put("NOMBRES",nombres);
                parameters.put("TIPO_DOCUMENTO",tipoId);
                parameters.put("NUMERO_DOCUMENTO",numId);
                parameters.put("DIA",dia);
                parameters.put("MES",mes);
                parameters.put("ANO",ANO);
                parameters.put("DESCRIPCION_CERTIFICADO",descrpcionCertificado);
                parameters.put("NOMBRE_USUARIO",usuarioRegistra);
                     
             byte[] bytes;
                JasperReport report = (JasperReport) JRLoader.loadObject(url); 
                bytes = 
                        JasperRunManager.runReportToPdf(report, parameters, 
                                                        (JRDataSource)this);

                PdfServletUtils.showPdfDocument(bytes, 
                                                "certificadoAdministrador" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);

                generoCertificado = true;
     
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
    }

    // ACCESSORS




    /**
     * @param generoCertificado
     */
    public void setGeneroCertificado(boolean generoCertificado) {
        this.generoCertificado = generoCertificado;
    }

    /**
     * @return
     */
    public boolean isGeneroCertificado() {
        return generoCertificado;
    }

    /**
     * @param param
     */
    public void setListTipoIdentificacion(List<SelectItem> param) {
        this.listTipoIdentificacion = param;
    }

    /**
     * @return
     */
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

    public void setDescrpcionCertificado(String descrpcionCertificado) {
        this.descrpcionCertificado = descrpcionCertificado;
    }

    public String getDescrpcionCertificado() {
        return descrpcionCertificado;
    }

    public boolean next() throws JRException {
        index++;
        return (index < 1);
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setNumId(Long numId) {
        this.numId = numId;
    }

    public Long getNumId() {
        return numId;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNombres() {
        return nombres;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}


