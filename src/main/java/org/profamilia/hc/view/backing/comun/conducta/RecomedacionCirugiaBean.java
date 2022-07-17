//=======================================================================
// ARCHIVO RecomedacionUsuarioBean.java
// FECHA CREACI�N: 02/08/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes al ingreso de recomedaciones.
//=======================================================================

package org.profamilia.hc.view.backing.comun.conducta;

import java.math.BigDecimal;

import java.net.URL;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chconducta;
import org.profamilia.hc.model.dto.ChconductaPK;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorPlantillaCirugiaBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//==============================================================================
//  CLASE RecomedacionUsuarioBean
//==============================================================================

public class RecomedacionCirugiaBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private boolean tieneIncapacidad;

    private boolean tieneRemision;

    private boolean tieneFormula;

    private boolean tieneCertificado;

    private boolean tieneExamenes;

    private Chconducta conducta;

    private boolean tieneControl;

    private boolean modoconsulta;

    private boolean generoRecomendaciones;

    private Integer tipoHistoria;

    private static int NUMERO_RECOMENDACIONES = 1;

    private int index = -1;

    private boolean mostrarIcono;

    ConsultarFoliosBean folio;

    private boolean esCirugia;

    private Long numeroUsuario;

    private String tipoServicio;

    private Integer consecutivo;
    
    private Integer selectedIndex; 
    
    private boolean renderPlantilla; 
    
    private UIInput itDescripcion; 
    
    private UIInput itPlanManejo;

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

    String DESCRIPCION_RECOMENDACIONES;

    String NOMBRE_USUARIO;
    
   


    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private String menuBean;

    private Long numeroConsulta;
    
    String NOMBRE_PROFESIONAL;
    
    String REGISTRO_MEDICO; 
    
    String TIPOID_PROFESIONAL;
      
    BigDecimal NUMID_PROFESIONAL;
    
    static final int ACTIVAR_APLICACION = 0;

     static final int ACTIVAR_BUSCADOR_PLANTILLAS = 1;



    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //----------------------------------------------------------------------- 

    public RecomedacionCirugiaBean() {
    }

    //ACTIONS  

    public void init() {
        inicializarRecomedaciones();
        modoconsulta = false;
        selectedIndex = 0; 
    }

    public void inicializarRecomedaciones() {
        generoRecomendaciones = false;
        mostrarIcono = false; 
        try {
            if (!esCirugia) {
                if (numeroConsulta != null) {
                    conducta = 
                            this.getServiceLocator().getClinicoService().getConducta(numeroConsulta);
                }

            } else {
                conducta = 
                        this.getServiceLocator().getClinicoService().getConducta(numeroConsulta, 
                                                                                 tipoServicio, 
                                                                                 consecutivo);
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (conducta == null) {
            modoconsulta = false;
            conducta = new Chconducta();

        } else {
            modoconsulta = true;
            mostrarIcono = true;
        }
    }


    //--------------------------------------------------------------------------
    //  Metodo esValido que garantiza que el registro fue guardado exitosamente
    //--------------------------------------------------------------------------
    
    
    
    

    /**
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        Chconducta conductaAux = null;
        if (numeroConsulta != null) {

            try {
                conductaAux = 
                        this.getServiceLocator().getClinicoService().getConducta(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (conductaAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }


    //-----------------------------------------------------------------------
    //  Construir Reporte
    //-----------------------------------------------------------------------


    /**
     * @return
     * @throws JRException
     */
    public boolean next() throws JRException {
        index++;
        return (index < NUMERO_RECOMENDACIONES);
    }


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
        if (fieldName.equals("RECOMENDACIONES")) {
            value = DESCRIPCION_RECOMENDACIONES;
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
            }
        }

        if (conducta.getHcndfecregistr() != null) {
            fecha = conducta.getHcndfecregistr();
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


            String hora = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
            String minuto = String.valueOf(calendar.get(Calendar.MINUTE));
            if (calendar.get(Calendar.HOUR_OF_DAY) < 10) {
                hora = "0" + hora;
            }
            if (calendar.get(Calendar.MINUTE) < 10) {
                minuto = "0" + minuto;
            }


        }

        if (conducta != null) {
            DESCRIPCION_RECOMENDACIONES = conducta.getHcncobservacio();
        }


        if (getUsuarioSystem() != null) {
            NOMBRE_USUARIO = getUsuarioSystem().getCurcnombre();
        }

    }

    public void obtenerDatosReporteCirugia() {

        Chusuario usuarioAux;
        usuarioAux = null;

        if (usuario.getHuslnumero() != null) {

            try {
                usuarioAux = 
                        this.serviceLocator.getClinicoService().getUsuario(usuario.getHuslnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }

        }


        if (usuarioAux != null) {

            if (usuarioAux.getHusdfechanacim() != null) {
                Date fechaNacimiento = usuarioAux.getHusdfechanacim();
                if (fechaNacimiento != null) {
                    int edad = calcularEdad(fechaNacimiento, new Date());
                    EDAD = edad;
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

        }

        if (conducta.getHcndfecregistr() != null) {
            fecha = conducta.getHcndfecregistr();
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


            String hora = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
            String minuto = String.valueOf(calendar.get(Calendar.MINUTE));
            if (calendar.get(Calendar.HOUR_OF_DAY) < 10) {
                hora = "0" + hora;
            }
            if (calendar.get(Calendar.MINUTE) < 10) {
                minuto = "0" + minuto;
            }

        }

        if (conducta != null) {
            DESCRIPCION_RECOMENDACIONES = conducta.getHcncobservacio();
        }

        if (getUsuarioSystem() != null) {
            NOMBRE_USUARIO = getUsuarioSystem().getCurcnombre();
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
            }
        }

    }


    public void generarReporte() {
        index = -1;

        try {
            if (!esCirugia) {
                obtenerDatosReporteConsulta();
            } else {
                obtenerDatosReporteCirugia();
            }

           URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/recomendaciones.jasper");
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
                        JasperRunManager.runReportToPdf(report, parameters, 
                                                        (JRDataSource)this);

                PdfServletUtils.showPdfDocument(bytes, 
                                                "Recomendaciones" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);

                generoRecomendaciones = true;
                modoconsulta = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
    }


    public void generarImpresionFolio() {
        index = -1;
        Chconsulta consul;
        consul = null;

        try {
            if (numeroConsulta != null) {
                consul = 
                        this.getServiceLocator().getClinicoService().getConsultaActual(numeroConsulta);
            }


        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (consul != null) {
            folio = 
                    (ConsultarFoliosBean)FacesUtils.getManagedBean("consultarFoliosBean");

            if (folio != null && usuario != null && conducta != null) {
                folio.setConsultaClone(consul);
                folio.setUsuario(usuario);
                folio.setNumeroConsulta(conducta.getId().getHcnlconsulta());
                folio.ImprimirFolio();
                generoRecomendaciones = true;
            }
        }


    }
    
    //--------------------------------------------------------------------------
    //  AJAX
    //--------------------------------------------------------------------------
    
    
    
    
    public void mostrarBuscadorPlantillaRecomendaciones(){
        FacesUtils.resetManagedBean("buscadorPlantillaCirugiaBean");
        BuscadorPlantillaCirugiaBean buscador = 
            (BuscadorPlantillaCirugiaBean)FacesUtils.getManagedBean("buscadorPlantillaCirugiaBean");
        if (buscador != null) {
            buscador.setNombreBeanAnterior("recomedacionCirugiaBean");
            buscador.setTagRenderizar("panelGridConductaTab");
            buscador.setDescripcion(true);
            buscador.setHallazgos(false);
        }
        renderPlantilla = true;
        selectedIndex = 1;
        }



    public void mostrarBuscadorPlantillaPlanManejo(){
        FacesUtils.resetManagedBean("buscadorPlantillaCirugiaBean");
        BuscadorPlantillaCirugiaBean buscador = 
            (BuscadorPlantillaCirugiaBean)FacesUtils.getManagedBean("buscadorPlantillaCirugiaBean");
        if (buscador != null) {
            buscador.setNombreBeanAnterior("recomedacionCirugiaBean");
            buscador.setTagRenderizar("panelGridConductaTab");
            buscador.setDescripcion(false);
            buscador.setHallazgos(true);
        }
        renderPlantilla = true;
        selectedIndex = 1;
        }

    //--------------------------------------------------------------------------
    //  Bot�n principal
    //--------------------------------------------------------------------------

    public void aceptar() {

        mostrarIcono = false;
        ChconductaPK id = new ChconductaPK();
        conducta.setHcncoperador(userName());

        if (!esCirugia) {
            if (numeroConsulta != null && tipoServicio != null) {
                id.setHcnlconsulta(numeroConsulta);
                id.setHcnctiposervi(tipoServicio);
                id.setHcnnconsecutiv(1);
                conducta.setId(id);

                try {
                    this.serviceLocator.getClinicoService().saveConducta(conducta);
                    mostrarIcono = true;
                    FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                    FacesUtils.resetManagedBean(menuBean);
                } catch (ModelException e) {
                    FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                    mostrarIcono = false;
                    e.printStackTrace();
                }
            }

        } else {
            if (numeroConsulta != null && tipoServicio != null && 
                consecutivo != null) {
                if (conducta != null) {
                    conducta.setHcndfecregistr(new Date());
                }
                id.setHcnlconsulta(numeroConsulta);
                id.setHcnctiposervi(tipoServicio);
                id.setHcnnconsecutiv(consecutivo);
                conducta.setId(id);

                try {
                    this.serviceLocator.getCirugiaService().saveConductaDarAltaMedico(numeroConsulta, getClinica().getCclncodigo(), userName(),conducta, new Date());
                    FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                    mostrarIcono = true;
                } catch (ModelException e) {
                    FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                    mostrarIcono = false;
                    e.printStackTrace();
                }
            }
        }
    }

    // ACCESSORS

  

    //-----------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //-----------------------------------------------------------------------    

    /**
     * @param valueChangeEvent
     */
    public void setTieneIncapacidad(ValueChangeEvent valueChangeEvent) {
        setTieneIncapacidad((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setTieneControl(ValueChangeEvent valueChangeEvent) {
        setTieneControl((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setTieneRemision(ValueChangeEvent valueChangeEvent) {
        setTieneRemision((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setTieneExamenes(ValueChangeEvent valueChangeEvent) {
        setTieneExamenes((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setTieneFormula(ValueChangeEvent valueChangeEvent) {
        setTieneFormula((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setTieneCertificado(ValueChangeEvent valueChangeEvent) {
        setTieneCertificado((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    
    /**
     * @param tieneIncapacidad
     */
    public void setTieneIncapacidad(boolean tieneIncapacidad) {
        this.tieneIncapacidad = tieneIncapacidad;
    }

    /**
     * @return
     */
    public boolean isTieneIncapacidad() {
        return tieneIncapacidad;
    }

    /**
     * @param tieneControl
     */
    public void setTieneControl(boolean tieneControl) {
        this.tieneControl = tieneControl;
    }

    /**
     * @return
     */
    public boolean isTieneControl() {
        return tieneControl;
    }

    /**
     * @param tieneRemision
     */
    public void setTieneRemision(boolean tieneRemision) {
        this.tieneRemision = tieneRemision;
    }

    /**
     * @return
     */
    public boolean isTieneRemision() {
        return tieneRemision;
    }

    /**
     * @param tieneExamenes
     */
    public void setTieneExamenes(boolean tieneExamenes) {
        this.tieneExamenes = tieneExamenes;
    }

    /**
     * @return
     */
    public boolean isTieneExamenes() {
        return tieneExamenes;
    }

    /**
     * @param tieneFormula
     */
    public void setTieneFormula(boolean tieneFormula) {
        this.tieneFormula = tieneFormula;
    }

    /**
     * @return
     */
    public boolean isTieneFormula() {
        return tieneFormula;
    }

    /**
     * @param tieneCertificado
     */
    public void setTieneCertificado(boolean tieneCertificado) {
        this.tieneCertificado = tieneCertificado;
    }

    /**
     * @return
     */
    public boolean isTieneCertificado() {
        return tieneCertificado;
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
     * @param generoRecomendaciones
     */
    public void setGeneroRecomendaciones(boolean generoRecomendaciones) {
        this.generoRecomendaciones = generoRecomendaciones;
    }

    /**
     * @return
     */
    public boolean isGeneroRecomendaciones() {
        return generoRecomendaciones;
    }

    /**
     * @param conducta
     */
    public void setConducta(Chconducta conducta) {
        this.conducta = conducta;
    }

    /**
     * @return
     */
    public Chconducta getConducta() {
        return conducta;
    }

    /**
     * @param mostrarIcono
     */
    public void setMostrarIcono(boolean mostrarIcono) {
        this.mostrarIcono = mostrarIcono;
    }

    /**
     * @return
     */
    public boolean isMostrarIcono() {
        return mostrarIcono;
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
     * @param selectedIndex
     */
    public void setSelectedIndex(Integer selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    /**
     * @return
     */
    public Integer getSelectedIndex() {
        return selectedIndex;
    }

    /**
     * @param renderPlantilla
     */
    public void setRenderPlantilla(boolean renderPlantilla) {
        this.renderPlantilla = renderPlantilla;
    }

    /**
     * @return
     */
    public boolean isRenderPlantilla() {
        return renderPlantilla;
    }

    /**
     * @param itDescripcion
     */
    public void setItDescripcion(UIInput itDescripcion) {
        this.itDescripcion = itDescripcion;
    }

    /**
     * @return
     */
    public UIInput getItDescripcion() {
        return itDescripcion;
    }


    public void setItPlanManejo(UIInput itPlanManejo) {
        this.itPlanManejo = itPlanManejo;
    }

    public UIInput getItPlanManejo() {
        return itPlanManejo;
    }
}

