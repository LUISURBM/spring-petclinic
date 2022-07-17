//=======================================================================
// ARCHIVO HospitalizacionUsuarioBean.java
// FECHA CREACI�N: 15/06/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a la conducta de Hospitalizacion.
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

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chremihospit;
import org.profamilia.hc.model.dto.ChremihospitPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE HospitalizacionUsuarioBean
//=======================================================================

public class HospitalizacionUsuarioBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chremihospit hospitalizacion;

    private boolean modoconsulta;

    private boolean generoHospitalizacion;

    private List lstText;

    private List lstLabel;

    private int index = -1;

    private boolean esCirugia;

    String NOMBRES;

    String PRIMER_APELLIDO;

    String SEGUNDO_APELLIDO;

    String TIPO_DOCUMENTO;

    Long NUMERO_DOCUMENTO;

    String DIAGNOSTICO_PRINCIPAL;

    String DIAGNOSTICO_SECUNDARIO;

    String CODIGO_CIE10;

    String TIPO_USUARIO;

    String ANNO;

    String MES;

    String DIA;

    Integer EDAD;

    Date fecha;

    String CODIGO_CIE10_PRINCIPAL;

    String DESCRIPCION_LABEL;

    String DESCRIPCION_TEXTO;
    
    String NOMBRE_PROFESIONAL;
    
    String TIPOID_PROFESIONAL;
      
    BigDecimal NUMID_PROFESIONAL;
    
    String REGISTRO_MEDICO; 
    
    String ESPECIALIDAD = null;

    /** Almacena el numero de la consulta */
    private Long numeroConsulta;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private String tipoServicio;

    private String menuBean;

    private Integer consecutivo;

    private String ciel0Principal;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //----------------------------------------------------------------------- 

    public HospitalizacionUsuarioBean() {
    }

    //ACTIONS  


    public void init() {
        modoconsulta = false;
        generoHospitalizacion = false;
        lstLabel = new ArrayList();
        lstText = new ArrayList();
        inicializarHospitalizacion();

    }

    public void inicializarHospitalizacion() {
        generoHospitalizacion = false;

        try {

            hospitalizacion = 
                    this.getServiceLocator().getClinicoService().getRemisionHospitalizacion(numeroConsulta, 
                                                                                            tipoServicio, 
                                                                                            consecutivo);
        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (hospitalizacion == null) {
            hospitalizacion = new Chremihospit();
        } else {
            modoconsulta = true;
        }
    }

    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------

    /**
     * @param hospitalizacion
     */
    public void setHospitalizacion(Chremihospit hospitalizacion) {
        this.hospitalizacion = hospitalizacion;
    }

    /**
     * @return
     */
    public Chremihospit getHospitalizacion() {
        return hospitalizacion;
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
     * @param generoHospitalizacion
     */
    public void setGeneroHospitalizacion(boolean generoHospitalizacion) {
        this.generoHospitalizacion = generoHospitalizacion;
    }

    /**
     * @return
     */
    public boolean isGeneroHospitalizacion() {
        return generoHospitalizacion;
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
     * @param ciel0Principal
     */
    public void setCiel0Principal(String ciel0Principal) {
        this.ciel0Principal = ciel0Principal;
    }

    /**
     * @return
     */
    public String getCiel0Principal() {
        return ciel0Principal;
    }


    //-----------------------------------------------------------------------
    //  Construir Reporte
    //-----------------------------------------------------------------------


    public boolean next() throws JRException {
        index++;
        return (index < lstLabel.size());
    }

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
            value = ANNO;
            return value;
        }
        if (fieldName.equals("TIPO_CONSULTA")) {

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
        if (fieldName.equals("DESCRIPCION_LABEL")) {
            value = lstLabel.get(index);
            return value;
        }

        if (fieldName.equals("DESCRIPCION_TEXTO")) {
            value = lstText.get(index);
            return value;
        }
        
         if (fieldName.equals("NOMBRE_PROFESIONAL")) {
                    value = NOMBRE_PROFESIONAL;
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
                
        if (fieldName.equals("REGISTRO_MEDICO")) {
                    value = REGISTRO_MEDICO;
                    return value;
                }
                
        if (fieldName.equals("ESPECIALIDAD")) {
                   value = ESPECIALIDAD;
                   return value;
               }


        return null;

    }

    public void obtenerDatosReporteConsulta() {

        if (usuario != null) {

            if (usuario.getHusdfechanacim() != null) {
                Date fechaNacimiento = usuario.getHusdfechanacim();
                if (fechaNacimiento != null) {
                    int edad = calcularEdad(fechaNacimiento, new Date());
                    EDAD = edad;
                }
            }

            if (ciel0Principal != null) {

                Crdgncie10 diagprin = null;
                CODIGO_CIE10_PRINCIPAL = ciel0Principal.toUpperCase();
                DIAGNOSTICO_PRINCIPAL = ciel0Principal.toUpperCase();

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

            if (usuario.getHuscprimernomb() != null) {
                NOMBRES = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRES = NOMBRES + usuario.getHuscsegundnomb();
            }
            if (usuario.getHuscprimerapel() != null) {
                PRIMER_APELLIDO = usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                SEGUNDO_APELLIDO = usuario.getHuscsegundapel();
            }
            if (usuario.getHusetipoiden() != null) {
                TIPO_DOCUMENTO = usuario.getHusetipoiden().toString();
            }
            if (usuario.getHusanumeiden() != 0) {
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }
            if (usuario.getHusetipoafilia() != null) {

                if (usuario.getHusetipoafilia().equals("C")) {
                    TIPO_USUARIO = "CONTRIBUTIVO";
                }
                if (usuario.getHusetipoafilia().equals("E")) {
                    TIPO_USUARIO = "ESPECIAL";
                }
                if (usuario.getHusetipoafilia().equals("R")) {
                    TIPO_USUARIO = "SUBSIDIO PARCIAL";
                }
                if (usuario.getHusetipoafilia().equals("S")) {
                    TIPO_USUARIO = "SUBSIDIADO";
                }
                if (usuario.getHusetipoafilia().equals("V")) {
                    TIPO_USUARIO = "VINCULADO";
                }
                if (usuario.getHusetipoafilia().equals("X")) {
                    TIPO_USUARIO = "NINGUNO";
                }
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

        ANNO = anoact.toString();
        lstLabel.add("Motivo de Hospitalizaci�n:");
        lstLabel.add("Plan de Manejo:");
        lstText.add(hospitalizacion.getHrhcmotivhospi());
        lstText.add(hospitalizacion.getHrhcplanmanejo());

    }

    public void obtenerDatosReporteCirugia() {

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

            if (ciel0Principal != null) {
                Crdgncie10 diagprin = null;

                CODIGO_CIE10_PRINCIPAL = ciel0Principal.toUpperCase();
                DIAGNOSTICO_PRINCIPAL = ciel0Principal.toUpperCase();

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
        Integer annoact = calendar.get(calendar.YEAR);

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

        ANNO = annoact.toString();
        lstLabel.add("Motivo de Hospitalizaci�n:");
        lstLabel.add("Plan de Manejo:");
        lstText.add(hospitalizacion.getHrhcmotivhospi());
        lstText.add(hospitalizacion.getHrhcplanmanejo());

    }


    //--------------------------------------------------------------------------
    //  Bot�n principal
    //--------------------------------------------------------------------------

    public void generarHospitalizacion() {
        hospitalizacion.setHrhdfecregistr(new Date());
        hospitalizacion.setHrhcoperador(userName());
        ChremihospitPK id = new ChremihospitPK();

        if (numeroConsulta != null && tipoServicio != null && 
            consecutivo != null) {
            id.setHrhlconsulta(numeroConsulta);
            id.setHrhctiposervi(tipoServicio);
            id.setHrhnconsecutiv(consecutivo);
            hospitalizacion.setId(id);
        }

        try {
            this.serviceLocator.getClinicoService().saveRemisionHospitalizacion(hospitalizacion);
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

           URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/RemisionHospitalizacion.jasper");
            URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA); 
            URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL); 
            URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL); 
            if (url != null){
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
                                                "Hospitalizacion" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);
                generoHospitalizacion = true;
                modoconsulta = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }


    }


}
