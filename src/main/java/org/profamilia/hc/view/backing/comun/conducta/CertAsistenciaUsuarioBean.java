//=======================================================================
// ARCHIVO CertAsistenciaUsuarioBean.java
// FECHA CREACI�N: 02/08/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes al certificado de Asistencia.
//=======================================================================

package org.profamilia.hc.view.backing.comun.conducta;

import java.math.BigDecimal;

import java.net.URL;

import java.text.DateFormat;

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
//  CLASE CertAsistenciaUsuarioBean
//==============================================================================

public class CertAsistenciaUsuarioBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private boolean modoconsulta;

    private boolean generoCertificado;

    private static int NUMERO_CERTIFICADOS = 1;

    private int index = -1;

    private Chcertmedico certificado;

    private List lstDirigido;

    private String dirigidoSelect;

    private boolean esCirugia;


    private String tipoServicio;

    private Integer consecutivo;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    private boolean mostrarAcomp;

    String NOMBRES;

    String PRIMER_APELLIDO;

    String SEGUNDO_APELLIDO;

    String TIPO_DOCUMENTO;

    Long NUMERO_DOCUMENTO;

    String DIAGNOSTICO_SECUNDARIO;

    String CODIGO_CIE10;

    String TIPO_USUARIO;

    String ANO;

    String MES;

    String DIA;

    Integer EDAD;

    String DESCRIPCION_CERTIFICADO;

    String NOMBRE_USUARIO;

    String DESCRIPCION_FECHA;

    String DESCRIPCION_HORA;

    String DESC_SERVICIO;

    String NOMBRE_ACOMPANANTE;

    String TIPO_DOCUMENTO_ACOMPANANTE;

    Long NUMERO_DOCUMENTO_ACOMPANANTE;
    
    String NOMBRE_PROFESIONAL;
    
    String REGISTRO_MEDICO; 
    
    String ESPECIALIDAD = null;
    
    String TIPOID_PROFESIONAL;
    
    BigDecimal NUMID_PROFESIONAL;

    /** Almacena el consulta */
    private Long numeroConsulta;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private String menuBean;

    private String codigoCups;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //----------------------------------------------------------------------- 

    public CertAsistenciaUsuarioBean() {
    }

    //ACTIONS 

    public void init() {
        inicializarCertificadoAsistencia();
    }

    public void inicializarCertificadoAsistencia() {
        generoCertificado = false;
        modoconsulta = false;
        try {

            certificado = 
                    this.getServiceLocator().getClinicoService().getCertificado(numeroConsulta, 
                                                                                tipoServicio, 
                                                                                consecutivo, 
                                                                                CERTIFICADO_ASISTENCIA);

        } catch (ModelException e) {
            e.printStackTrace();
        }


        if (certificado == null) {
            certificado = new Chcertmedico();
            modoconsulta = false;
        } else {
            modoconsulta = true;
            if (certificado.getHcmcnombreacom() != null) {
                dirigidoSelect = "A";
                mostrarAcomp = true;
            } else {
                dirigidoSelect = "P";
                mostrarAcomp = false;
            }
        }

    }

    //--------------------------------------------------------------------------
    //  Metodo esValido que garantiza que el registro fue guardado exitosamente
    //-------------------------------------------------------------------------- 

    public boolean esValido() {
        boolean esValido = false;
        return esValido;
    }

    //-----------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //-----------------------------------------------------------------------    

    public void changeSolicita() {
        if (dirigidoSelect != null && dirigidoSelect.equals("A")) {
            mostrarAcomp = true;
        } else {
            certificado.setHcmanumideacom(null);
            certificado.setHcmcnombreacom(null);
            certificado.setHcmetipoideaco(null);
            mostrarAcomp = false;
        }
    }

    public void setDirigidoSelect(ValueChangeEvent valueChangeEvent) {
        setDirigidoSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    //-----------------------------------------------------------------------
    //  Construir Reporte
    //-----------------------------------------------------------------------

    public boolean next() throws JRException {
        index++;
        return (index < NUMERO_CERTIFICADOS);
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

        if (fieldName.equals("NOMBRE_PROFESIONAL")) {
            value = this.getUsuarioSystem().getCurcnombre();
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
        if (fieldName.equals("DESCRIPCION_FECHA")) {
            value = DESCRIPCION_FECHA;
            return value;
        }
        if (fieldName.equals("DESC_SERVICIO")) {
            value = DESC_SERVICIO;
            return value;
        }
        if (fieldName.equals("DESCRIPCION_HORA")) {
            value = DESCRIPCION_HORA;
            return value;
        }

        if (fieldName.equals("NOMBRE_ACOMPANANTE")) {
            value = NOMBRE_ACOMPANANTE;
            return value;
        }
        if (fieldName.equals("TIPO_DOCUMENTO_ACOMPANANTE")) {
            value = TIPO_DOCUMENTO_ACOMPANANTE;
            return value;
        }
        if (fieldName.equals("NUMERO_DOCUMENTO_ACOMPANANTE")) {
            value = NUMERO_DOCUMENTO_ACOMPANANTE;
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

        if (certificado.getHcmdfechareg() != null) {
           
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(certificado.getHcmdfechareg());
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

         DESCRIPCION_HORA = formatearCampoHoraSimple(certificado.getHcmdfechareg());
            

                        DESCRIPCION_FECHA = 
                                DateFormat.getDateInstance(DateFormat.LONG).format(certificado.getHcmdfechareg().getTime());

        }


        if (certificado != null) {
            if (certificado.getHcmccertifica() != null) {
                DESCRIPCION_CERTIFICADO = certificado.getHcmccertifica();
            }

            if (certificado.getHcmcnombreacom() != null && 
                !certificado.getHcmcnombreacom().equals("")) {
                NOMBRE_ACOMPANANTE = certificado.getHcmcnombreacom();
            } else {
                NOMBRE_ACOMPANANTE = null;
            }

            if (certificado.getHcmetipoideaco() != null && 
                !certificado.getHcmetipoideaco().equals("")) {
                TIPO_DOCUMENTO_ACOMPANANTE = certificado.getHcmetipoideaco();
            } else {
                TIPO_DOCUMENTO_ACOMPANANTE = null;
            }

            if (certificado.getHcmanumideacom() != null) {
                NUMERO_DOCUMENTO_ACOMPANANTE = certificado.getHcmanumideacom();
            } else {
                NUMERO_DOCUMENTO_ACOMPANANTE = null;
            }


        }

        if (getUsuarioSystem() != null) {
            NOMBRE_USUARIO = getUsuarioSystem().getCurcnombre();
        }

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


            if (codigoCups != null) {
                String CODIGO_CUPS;
                CODIGO_CUPS = null;
                CODIGO_CUPS = codigoCups;
                try {
                    DESC_SERVICIO = 
                            this.serviceLocator.getClinicoService().getDescripcionCups(CODIGO_CUPS);
                } catch (ModelException e) {
                    e.printStackTrace();
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
                REGISTRO_MEDICO = profesional.getCpfcregmedic();
                ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                TIPOID_PROFESIONAL = profesional.getCpfctipide();
                NUMID_PROFESIONAL = profesional.getCpfacedula();

            }
        }

        if (certificado.getHcmdfechareg() != null) {
            
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(certificado.getHcmdfechareg());
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


           
            DESCRIPCION_HORA = formatearCampoHoraSimple(certificado.getHcmdfechareg());
            
            DESCRIPCION_FECHA = 
                    DateFormat.getDateInstance(DateFormat.LONG).format(certificado.getHcmdfechareg().getTime());



        }


        if (certificado != null) {
            if (certificado.getHcmccertifica() != null) {
                DESCRIPCION_CERTIFICADO = certificado.getHcmccertifica();
            }

            if (certificado.getHcmcnombreacom() != null && 
                !certificado.getHcmcnombreacom().equals("")) {
                NOMBRE_ACOMPANANTE = certificado.getHcmcnombreacom();
            } else {
                NOMBRE_ACOMPANANTE = null;
            }

            if (certificado.getHcmetipoideaco() != null && 
                !certificado.getHcmetipoideaco().equals("")) {
                TIPO_DOCUMENTO_ACOMPANANTE = certificado.getHcmetipoideaco();
            } else {
                TIPO_DOCUMENTO_ACOMPANANTE = null;
            }

            if (certificado.getHcmanumideacom() != null) {
                NUMERO_DOCUMENTO_ACOMPANANTE = certificado.getHcmanumideacom();
            } else {
                NUMERO_DOCUMENTO_ACOMPANANTE = null;
            }


        }

        if (getUsuarioSystem() != null) {
            NOMBRE_USUARIO = getUsuarioSystem().getCurcnombre();
        }

    }


    //--------------------------------------------------------------------------
    //  Bot�n principal
    //--------------------------------------------------------------------------


    public void generarCertificado() {

        ChcertmedicoPK id;
        id = new ChcertmedicoPK();
        this.index = -1;

        id.setHcmlconsulta(numeroConsulta);
        id.setHcmctipocert(IConstantes.CERTIFICADO_ASISTENCIA);
        id.setHcmctiposervi(tipoServicio);
        id.setHcmnconsecutiv(consecutivo);
        certificado.setId(id);


        certificado.setHcmcoperador(userName());
        certificado.setHcmdfechareg(new Date());


        try {
            this.serviceLocator.getClinicoService().saveCertificado(certificado);

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

           URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/certificadoAsistencia.jasper");
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
                                                "CertificadoAsistencia" + 
                                                Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);

                generoCertificado = true;
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
     * @param lstDirigido
     */
    public void setLstDirigido(List lstDirigido) {
        this.lstDirigido = lstDirigido;
    }

    /**
     * @return
     */
    public List getLstDirigido() {
        if (lstDirigido == null || lstDirigido.isEmpty()) {
            lstDirigido = new ArrayList();
            lstDirigido.add(new SelectItem("P", "Paciente"));
            lstDirigido.add(new SelectItem("A", "Acompa�ante y/o Paciente"));

        }
        return lstDirigido;
    }

    /**
     * @param dirigidoSelect
     */
    public void setDirigidoSelect(String dirigidoSelect) {
        this.dirigidoSelect = dirigidoSelect;
    }

    /**
     * @return
     */
    public String getDirigidoSelect() {
        return dirigidoSelect;
    }

    /**
     * @param mostrarAcomp
     */
    public void setMostrarAcomp(boolean mostrarAcomp) {
        this.mostrarAcomp = mostrarAcomp;
    }

    /**
     * @return
     */
    public boolean isMostrarAcomp() {
        return mostrarAcomp;
    }

    /**
     * @param certificado
     */
    public void setCertificado(Chcertmedico certificado) {
        this.certificado = certificado;
    }

    /**
     * @return
     */
    public Chcertmedico getCertificado() {
        return certificado;
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
}


