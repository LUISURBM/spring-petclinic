//=======================================================================
// ARCHIVO AnatomiaPatologicaUsuarioBean.java
// FECHA CREACI�N: 09/06/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a la conducta de anatomia 
// patologica.
//=======================================================================
package org.profamilia.hc.view.backing.comun.conducta;

import java.io.File;

import java.math.BigDecimal;

import java.net.URL;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chanatopatol;
import org.profamilia.hc.model.dto.ChanatopatolPK;
import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//====================================================================


//=================================================================
//  CLASE AnatomiaPatologicaBean
//=======================================================================
public class AnatomiaPatologicaUsuarioBean extends BaseBean implements JRDataSource {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private boolean modoconsulta;

    private boolean generoAnatomia;

    private static int NUMERO_PATOLOGIAS = 1;

    private int index = -1;

    private Chanatopatol anatomia;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private Long numeroUsuario;

    private Long numeroConsulta;

    private String tipoServicio;

    private Integer consecutivo;

    private String menuBean;

    private Chantegineco antecedente;

    private boolean esCirugia;


    String CLINICA;
    String CIUDAD;
    Date FECHA;
    String NOMBRE;
    Integer EDAD;
    Long NUMERO_DOCUMENTO;
    Integer GESTACIONES;
    Integer PARTOS;
    Integer ABORTOS;
    Integer CESAREAS;
    Integer VIVOS;
    Date FECHA_REGLA;
    Date FECHA_PARTO;
    String ORIGEN_PIEZA;
    String NOMBRE_PROFESIONAL;
    String REGISTRO_MEDICO;
    String DIAGNOSTICO;
    BigDecimal NUMID_PROFESIONAL;
    String TIPOID_PROFESIONAL;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public AnatomiaPatologicaUsuarioBean() {
    }

    public void init() {
        generoAnatomia = false;
    }


    public void inicializarAnatomiaPatol() {
        generoAnatomia = false;
        modoconsulta = false;
        try {
            if (numeroConsulta != null && tipoServicio != null && 
                consecutivo != null) {
                anatomia = 
                        this.getServiceLocator().getClinicoService().getAnatomiaPatologica(numeroConsulta, 
                                                                                           tipoServicio, 
                                                                                           consecutivo);
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (anatomia == null || anatomia.getId() == null) {
            anatomia = new Chanatopatol();
            modoconsulta = false;
        } else {
            modoconsulta = true;
        }

    }


    //-----------------------------------------------------------------------
    //  Bot�n Principal 
    //----------------------------------------------------------------------- 


    public void generarAnatomia() {
        this.index = -1;
        this.index = -1;
        ChanatopatolPK id;
        id = new ChanatopatolPK();


        anatomia.setHapdfecregistr(new Date());
        anatomia.setHapcoperador(userName());

        if (numeroConsulta != null && tipoServicio != null && 
            consecutivo != null) {
            id.setHaplconsulta(numeroConsulta);
            id.setHapctiposervi(tipoServicio);
            id.setHapnconsecutiv(consecutivo);
            anatomia.setId(id);
        }


        try {
            serviceLocator.getClinicoService().saveAnatomiaPatologica(anatomia);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
        } catch (ModelException e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
        }
        
        Chimprdiag impresion = null;
        Crdgncie10 diagprin = null;
        
        try {
            impresion = 
                        this.serviceLocator.getClinicoService().getImresionDiagnostica(numeroConsulta,1);
        
        
             if (impresion !=null && impresion.getHidcdiagprin() != null) {
                diagprin = 
                        this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagprin().toUpperCase());
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (diagprin != null && 
            impresion.getHidcdiagprin() != null) {
            DIAGNOSTICO = 
                    impresion.getHidcdiagprin().toUpperCase() + 
                    " " + diagprin.getCdccdescri();
        }
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
            NUMID_PROFESIONAL= profesional.getCpfacedula();
            TIPOID_PROFESIONAL= profesional.getCpfctipide();
        }
        
        
        
        try {
            if (!esCirugia) {
                obtenerDatosReporteConsulta();
            } else {
                obtenerDatosReporteCirugia();
            }
            Cpentidadadm entidad;
            entidad=null;
            entidad= this.getServiceLocator().getClinicoService().getAseguradoraPorCodigo(usuario.getHuscentidadadm());

            File reportFile = new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/anatomiaPatologica.jasper"));

            if (reportFile.exists()) {
               Map parameters = new HashMap();
               byte[] bytes = null;
               URL imagen =  FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/profamilia_negro.gif");

               parameters.put("IMAGEN", imagen);
               parameters.put("FECHA", anatomia.getHapdfecregistr());
               parameters.put("NO_HISTORIA", usuario.getHusanumeiden().toString());
               parameters.put("APELLIDOS",usuario.getHuscprimerapel() + " " + usuario.getHuscsegundapel());
               parameters.put("NOMBRES",usuario.getHuscprimernomb() + " " + usuario.getHuscsegundnomb() +" "+usuario.getHuscprimerapel() + " " + usuario.getHuscsegundapel());
               parameters.put("EDAD",usuario.getEdad());
               parameters.put("ORIGEN_PIEZA",ORIGEN_PIEZA);                    
               parameters.put("CLINICA",CLINICA);    
               parameters.put("NOMBRE_PROFESIONAL",profesional.getCpfcnombre());  
                parameters.put("NUMID_PROFESIONAL",profesional.getCpfacedula());  
                parameters.put("TIPOID_PROFESIONAL",profesional.getCpfctipide()); 
                parameters.put("REGISTRO_MEDICO",profesional.getCpfcregmedic()); 
                parameters.put("TIPOID_PACIENTE",usuario.getHusetipoiden());
                if(entidad!=null){
                parameters.put("EPS",entidad.getCeacnombre());
                }else{
                parameters.put("EPS",usuario.getHuscentidadadm());
                }
               parameters.put("G",GESTACIONES);
               parameters.put("P",PARTOS);
               parameters.put("A",ABORTOS);
               parameters.put("C",CESAREAS);
               parameters.put("V",VIVOS);
               parameters.put("FUR",FECHA_REGLA);
               parameters.put("FUP",FECHA_PARTO);
                if(impresion != null){
               parameters.put("DIAGNOSTICO",DIAGNOSTICO);
               }
               bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, (JRDataSource)this);
               PdfServletUtils.showPdfDocument(bytes, 
                                           "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                           ".pdf", false);

               generoAnatomia = true;
               modoconsulta = true;

            }
        } catch (JRException ex) {
            ex.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar Reporte Anatomia Patologica. " +
                                       ex.getMessage());
            generoAnatomia = false;
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar reporte Anatomia Patologica. " +
                                       ex.getMessage());
            generoAnatomia = false;
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

        if (fieldName.equals("CLINICA")) {
            value = CLINICA;
        } else if (fieldName.equals("CIUDAD")) {
            value = CIUDAD;
        } else if (fieldName.equals("FECHA")) {
            value = new Date();
        } else if (fieldName.equals("NOMBRE")) {
            value = NOMBRE;
        } else if (fieldName.equals("EDAD")) {
            value = EDAD;
        } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = NUMERO_DOCUMENTO;
        } else if (fieldName.equals("GESTACIONES")) {
            value = GESTACIONES;
        } else if (fieldName.equals("PARTOS")) {
            value = PARTOS;
        } else if (fieldName.equals("ABORTOS")) {
            value = ABORTOS;
        } else if (fieldName.equals("CESAREAS")) {
            value = CESAREAS;
        } else if (fieldName.equals("VIVOS")) {
            value = VIVOS;
        } else if (fieldName.equals("FECHA_REGLA")) {
            value = FECHA_REGLA;
        } else if (fieldName.equals("FECHA_PARTO")) {
            value = FECHA_PARTO;
        } else if (fieldName.equals("ORIGEN_PIEZA")) {
            value = ORIGEN_PIEZA;
        } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
            value = NOMBRE_PROFESIONAL;
        } else if (fieldName.equals("REGISTRO_MEDICO")) {
            value = REGISTRO_MEDICO;
        } else if (fieldName.equals("DIAGNOSTICO")) {
            value = DIAGNOSTICO;
        }else if (fieldName.equals("NUMID_PROFESIONAL")) {
            value = NUMID_PROFESIONAL;
        }else if (fieldName.equals("TIPOID_PROFESIONAL")) {
            value = TIPOID_PROFESIONAL;
        }


        return value;
    }


    /**
     * @return
     */
    public boolean next() {
        index++;
        return (index < NUMERO_PATOLOGIAS);
    }


    public void obtenerDatosReporteCirugia() {
        Chusuario usuarioAux;
        usuarioAux = null;

        if (usuario != null) {
            usuarioAux = usuario;
        }
        if (getUsuarioSystem() != null) {
            NOMBRE_PROFESIONAL = getUsuarioSystem().getCurcnombre();
        }
        if (anatomia != null) {
            ORIGEN_PIEZA = anatomia.getHapcorigepieza();
        }

        if (this.getClinica() != null) {
            CLINICA = this.getClinica().getCclcnombre();
            CIUDAD = this.getClinica().getCclcciudad();
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
                NOMBRE = usuarioAux.getHuscprimernomb() + " ";
            }
            if (usuarioAux.getHuscsegundnomb() != null && 
                !usuarioAux.getHuscsegundnomb().equals("_")) {
                NOMBRE = NOMBRE + usuarioAux.getHuscsegundnomb() + " ";
            }
            if (usuarioAux.getHuscprimerapel() != null) {
                NOMBRE = NOMBRE + usuarioAux.getHuscprimerapel() + " ";
            }
            if (usuarioAux.getHuscsegundapel() != null && 
                !usuarioAux.getHuscsegundapel().equals("_")) {
                NOMBRE = NOMBRE + usuarioAux.getHuscsegundapel();
            }

            if (usuarioAux.getHusanumeiden() != null && 
                usuarioAux.getHusanumeiden() != 0) {
                NUMERO_DOCUMENTO = usuarioAux.getHusanumeiden();
            }

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
                NOMBRE = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                NOMBRE = NOMBRE + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundapel();
            }
            if (usuario.getHusanumeiden() != null && 
                usuario.getHusanumeiden() != 0) {
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }
        }

        if (this.getClinica() != null) {
            CLINICA = this.getClinica().getCclcnombre();
            CIUDAD = this.getClinica().getCclcciudad();
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
            }
        }

        if (antecedente != null) {

            GESTACIONES = antecedente.getHagnnumgesta();
            PARTOS = antecedente.getHagnnumparto();
            ABORTOS = antecedente.getHagnnumaborto();
            CESAREAS = antecedente.getHagnnumcesare();
            VIVOS = antecedente.getHagnnumvivo();
            FECHA_REGLA = antecedente.getHagdfur();
            FECHA_PARTO = antecedente.getHagdfup();

        }
        if (getUsuarioSystem() != null) {
            NOMBRE_PROFESIONAL = getUsuarioSystem().getCurcnombre();
        }
        if (anatomia != null) {
            ORIGEN_PIEZA = anatomia.getHapcorigepieza();
        }
    }

    //-----------------------------------------------------------------------
    //  EsValido
    //----------------------------------------------------------------------- 

    public boolean esValido() {

        boolean esValido = false;
        Chanatopatol anatomiaAux = null;
        if (numeroConsulta != null) {
            try {
                anatomiaAux = 
                        this.getServiceLocator().getClinicoService().getAnatomiaPatologica(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (anatomiaAux != null) {
                esValido = true;
            } else {
                esValido = false;
            }
        }
        return esValido;
    }


    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------


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
     * @param generoAnatomia
     */
    public void setGeneroAnatomia(boolean generoAnatomia) {
        this.generoAnatomia = generoAnatomia;
    }

    /**
     * @return
     */
    public boolean isGeneroAnatomia() {
        return generoAnatomia;
    }


    /**
     * @param anatomia
     */
    public void setAnatomia(Chanatopatol anatomia) {
        this.anatomia = anatomia;
    }

    /**
     * @return
     */
    public Chanatopatol getAnatomia() {
        return anatomia;
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
     * @param antecedente
     */
    public void setAntecedente(Chantegineco antecedente) {
        this.antecedente = antecedente;
    }

    /**
     * @return
     */
    public Chantegineco getAntecedente() {
        return antecedente;
    }
}
