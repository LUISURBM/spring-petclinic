//=======================================================================
// ARCHIVO ReservaSangreUsuarioBean.java
// FECHA CREACI�N: 02/08/2010
// AUTOR: Jhon Carranza
// Descripci�n: Datos correspondientes a la solicitud de sangre.
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
import java.util.StringTokenizer;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chresersangr;
import org.profamilia.hc.model.dto.ChresersangrPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.clinico.comun.BuscadorCirugiasReservaBean;
import org.profamilia.hc.view.backing.clinico.comun.Cie10Bean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//==============================================================================
//  CLASE ReservaSangreUsuarioBean
//==============================================================================

public class ReservaSangreUsuarioBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chresersangr reserva;

    private boolean generoReserva;

    private String diagnosticoPrincipal;

    private boolean mostrarCie10;

    private int selectedIndex;

    private UIInput itDiagnostico;

    private List lstExamenesCirugias;

    private boolean modoconsulta;

    BuscadorCirugiasReservaBean buscadorCirugias;

    private List lstOpciones;

    private List lstTipoReserva;

    private List lstComponente;

    private boolean mostrarComponentes;

    private HtmlDataTable dtCirugia;

    static final int ACTIVAR_RESERVA_SANGRE = 0;

    static final int ACTIVAR_BUSCADOR_CIE10 = 1;

    static final int ACTIVAR_BUSCADOR_CIRUGIAS = 2;

    private int index = -1;

    private static int NUMERO_SOLICITUDES = 1;

    private boolean wexito;

    private boolean mostrarCirugias;

    private boolean esCirugia;

    private Long numeroUsuario;

    private String tipoServicio;

    private Integer consecutivo;

    // DATOS REPORTE

    String NOMBRE;

    Integer EDAD;

    Long NUMERO_DOCUMENTO;

    String TELEFONO;

    String DIAGNOSTICO;

    String AUTOTRANSFUSION;

    String PROBLEMAS_AUTOTRANSFUSION;

    String NOMBRE_MEDICO;

    String TELEFONO_CLINICA;

    String TIPO_CIRUGIA;

    Date FECHA_PROGRAMADA;

    String TIPO_RESERVA;

    Integer CANTIDAD;

    String SANGRE_TOTAL;

    String OTROS_COMPONENTES;

    Date FECHA_SOLICITUD;

    String BANCO_SANGRE;

    Integer CANTIDAD_OTROS;
    
    String NOMBRE_PROFESIONAL;
    
    String REGISTRO_MEDICO; 
    
    String TIPOID_PROFESIONAL;
    
    BigDecimal NUMID_PROFESIONAL;
    
    String HEMOCOMPONENTE;
    
    String TIPO_RESERVA_DONANTE;
    
    String TIPO_RESERVA_TRANSFUSIOIN;
    
    String VIA_ACCESO;
    
    String OTRA_VIA_ACCESO;
    
    private boolean renderCondicionAl;

    /** Almacena el consulta */
    private Long numeroConsulta;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private String menuBean;
    
    private List lstViasAcceso;
    
    private boolean mostrarOtraVia;
    


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ReservaSangreUsuarioBean() {
    }

    //ACTIONS  

    public void init() {
        modoconsulta = false;
        inicializarReservaSangre();
        renderCondicionAl=false;

    }

    public void inicializarReservaSangre() {
        generoReserva = false;
        mostrarOtraVia = false;
        try {

            reserva = 
                    serviceLocator.getClinicoService().getReservaSangre(numeroConsulta, 
                                                                        tipoServicio, 
                                                                        consecutivo);

        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (reserva == null) {
            reserva = new Chresersangr();
            modoconsulta = false;
        } else {
            modoconsulta = true;
            Crdgncie10 diagprin = null;
            if (reserva.getHrscdiagprin() != null && 
                !reserva.getHrscdiagprin().equals("")) {
                try {
                    diagprin = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(reserva.getHrscdiagprin().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagprin != null && diagprin.getCdcccodigo() != null) {
                    diagnosticoPrincipal = diagprin.getCdccdescri();
                }
            }

            if (reserva.getHrseotrcompsan() != null) {
                if (reserva.getHrseotrcompsan().equals("S")) {
                    mostrarComponentes = true;
                } else {
                    mostrarComponentes = false;
                }
            }


            if (reserva.getHrsccirugiapro() != null) {
                lstExamenesCirugias = new ArrayList();
                StringTokenizer st = 
                    new StringTokenizer(reserva.getHrsccirugiapro(), ",");
                Cpservicio servicioAux = null;
                while (st.hasMoreTokens()) {
                    String idservicio = st.nextToken();

                    try {
                        servicioAux = 
                                this.serviceLocator.getClinicoService().getServicioPorId(idservicio);
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    if (servicioAux != null) {
                        lstExamenesCirugias.add(servicioAux);
                    }

                }

            }           
            if (reserva.getHrscviaacceso() != null) {
                if ("OT".equals(reserva.getHrscviaacceso())) {
                    mostrarOtraVia = true;
                } else {
                    mostrarOtraVia = false;
                }
            }
        }
    }

    //-----------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //-----------------------------------------------------------------------   

    /**
     * @param valueChangeEvent
     */
    public void setHrseotrcompsan(ValueChangeEvent valueChangeEvent) {
        reserva.setHrseotrcompsan((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHrscdiagprin(ValueChangeEvent valueChangeEvent) {
        reserva.setHrscdiagprin((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHrscviaacceso(ValueChangeEvent valueChangeEvent) {
        reserva.setHrscviaacceso((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void changeDiagnostico() {

        diagnosticoPrincipal = null;
        itDiagnostico.setLocalValueSet(true);


        if (reserva != null) {
            if (reserva.getHrscdiagprin() != null && 
                !reserva.getHrscdiagprin().equals("")) {
                Crdgncie10 diagprin = null;
                try {
                    diagprin = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(reserva.getHrscdiagprin().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagprin != null && diagprin.getCdcccodigo() != null) {
                    diagnosticoPrincipal = diagprin.getCdccdescri();

                }

                if (diagnosticoPrincipal == null || 
                    diagnosticoPrincipal.equals("")) {
                    FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_PRINCIPAL_NO_VALIDO);
                }
            } else {
                diagnosticoPrincipal = "";
            }
        }
    }

    public void changeComponentes() {

        if (reserva != null && reserva.getHrseotrcompsan().equals("S")) {
            mostrarComponentes = true;
        } else {
            reserva.setHrsccuales(null);
            reserva.setHrsncantiotros(null);
            mostrarComponentes = false;
        }
    }


    public void mostrarDiagnostico() {
        Cie10Bean cie10;

        cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");
        cie10.setDiagnosticoPrincipal(true);
        cie10.setDiagnosticoRelacionado1(false);
        cie10.setDiagnosticoRelacionado2(false);
        cie10.setDiagnosticoRelacionado3(false);

        mostrarCie10 = true;
        selectedIndex = ACTIVAR_BUSCADOR_CIE10;
    }


    public void aceptarDiagnostico() {

        Cie10Bean cie10;
        cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");

        if (cie10 != null && cie10.getCie10Select() != null) {

            reserva.setHrscdiagprin(cie10.getCie10Select().getCdcccodigo());
            itDiagnostico.setValue(cie10.getCie10Select().getCdcccodigo());
            diagnosticoPrincipal = cie10.getCie10Select().getCdccdescri();

        }

        mostrarCie10 = false;
        selectedIndex = ACTIVAR_RESERVA_SANGRE;
        cie10.clear();

    }


    public void aceptarCirugia() {
        BuscadorCirugiasReservaBean cirugias;
        cirugias = 
                (BuscadorCirugiasReservaBean)FacesUtils.getManagedBean("buscadorCirugiasReservaBean");
        if (cirugias != null) {
            lstExamenesCirugias = cirugias.getLstCirugiaSelec();
        }
        mostrarCirugias = false;
        selectedIndex = ACTIVAR_RESERVA_SANGRE;

    }

    public void consultarCirugias() {
        FacesUtils.resetManagedBean("buscadorCirugiasReservaBean");
        BuscadorCirugiasReservaBean cirugias;
        cirugias = 
                (BuscadorCirugiasReservaBean)FacesUtils.getManagedBean("buscadorCirugiasReservaBean");
        if (cirugias != null) {
            cirugias.init();
        }
        mostrarCirugias = true;
        selectedIndex = ACTIVAR_BUSCADOR_CIRUGIAS;

    }


    public void eliminarCirugia() {
        Cpservicio servicioSelec;
        servicioSelec = (Cpservicio)dtCirugia.getRowData();
        lstExamenesCirugias.remove(servicioSelec);
    }
    
    public void changeViaAcceso() {

        if (reserva != null && "OT".equals(reserva.getHrscviaacceso())) {
            mostrarOtraVia = true;
        } else {
            reserva.setHrsccualviaacceso(null);
            mostrarOtraVia = false;
        }
    }

    //-----------------------------------------------------------------------
    //  Construir Reporte
    //-----------------------------------------------------------------------

    /**
     * @return
     */
    public boolean next() {
        index++;
        return (index < NUMERO_SOLICITUDES);
    }

    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("NOMBRE")) {
            value = NOMBRE;
        }
        if (fieldName.equals("EDAD")) {
            value = EDAD;
        }
        if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = NUMERO_DOCUMENTO;
        }
        if (fieldName.equals("TELEFONO")) {
            value = TELEFONO;
        }
        if (fieldName.equals("DIAGNOSTICO")) {
            value = DIAGNOSTICO;
        }
        if (fieldName.equals("AUTOTRANSFUSION")) {
            value = AUTOTRANSFUSION;
        }
        if (fieldName.equals("PROBLEMAS_AUTOTRANSFUSION")) {
            value = PROBLEMAS_AUTOTRANSFUSION;
        }
        if (fieldName.equals("NOMBRE_MEDICO")) {
            value = NOMBRE_MEDICO;
        }
      
        if (fieldName.equals("TELEFONO_CLINICA")) {
            value = TELEFONO_CLINICA;
        }
        if (fieldName.equals("TIPO_CIRUGIA")) {
            value = TIPO_CIRUGIA;
        }
        if (fieldName.equals("FECHA_PROGRAMADA")) {
            value = FECHA_PROGRAMADA;
        }
        if (fieldName.equals("TIPO_RESERVA")) {
            value = TIPO_RESERVA;
        }
        if (fieldName.equals("CANTIDAD")) {
            value = CANTIDAD;
        }
        if (fieldName.equals("SANGRE_TOTAL")) {
            value = SANGRE_TOTAL;
        }
        if (fieldName.equals("OTROS_COMPONENTES")) {
            value = OTROS_COMPONENTES;
        }
        if (fieldName.equals("FECHA_SOLICITUD")) {
            value = FECHA_SOLICITUD;
        }
        if (fieldName.equals("BANCO_SANGRE")) {
            value = BANCO_SANGRE;
        }
        if (fieldName.equals("CANTIDAD_OTROS")) {
            value = CANTIDAD_OTROS;
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
        if (fieldName.equals("TIPO_RESERVA_DONANTE")) {
            value = TIPO_RESERVA_DONANTE;
        }
         
        if (fieldName.equals("TIPO_RESERVA_TRANSFUSIOIN")) {
            value = TIPO_RESERVA_TRANSFUSIOIN;
        }
        
        if (fieldName.equals("HEMOCOMPONENTE")) {
             value = HEMOCOMPONENTE;
        }
        
        if (fieldName.equals("VIA_ACCESO")) {
             value = VIA_ACCESO;
        }
        
        if (fieldName.equals("OTRA_VIA_ACCESO")) {
             value = OTRA_VIA_ACCESO;
        }

        return value;
    }


    public void obtenerDatosReporteConsulta() {
        if (usuario != null) {
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

            if (usuario.getHusanumeiden() != 0) {
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }

            if (usuario.getHusdfechanacim() != null) {
                Date fechaNacimiento = usuario.getHusdfechanacim();
                if (fechaNacimiento != null) {
                    int edad = calcularEdad(fechaNacimiento, new Date());
                    EDAD = edad;
                }

                if (usuario.getHusctelefono() != null) {
                    TELEFONO = usuario.getHusctelefono();
                }

            }

        }
        if (numeroConsulta != null) {

            Cpclinica clin;
            clin = null;

            clin = this.getClinica();

            if (clin != null) {
                TELEFONO_CLINICA = clin.getCclctelefo();
            }
        }

        if (reserva != null) {

            if (reserva.getHrsncantiotros() != null) {
                CANTIDAD_OTROS = reserva.getHrsncantiotros();
            }

            if (reserva.getHrscdiagprin() != null) {
                Crdgncie10 diagprin = null;


                try {
                    if (reserva.getHrscdiagprin() != null) {
                        diagprin = 
                                this.serviceLocator.getClinicoService().getCIE10PorCodigo(reserva.getHrscdiagprin().toUpperCase());
                    }

                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagprin != null) {
                    DIAGNOSTICO = diagprin.getCdccdescri();
                }
            }

            if (reserva.getHrseconmedalta() != null) {
                if (reserva.getHrseconmedalta().equals("S")) {
                    PROBLEMAS_AUTOTRANSFUSION = "Si";
                } else {
                    PROBLEMAS_AUTOTRANSFUSION = "No";
                }
            }

            if (reserva.getHrscoperador() != null) {
                Cpprofesio profesional;
                profesional = null;
                try {
                    profesional = 
                            serviceLocator.getClinicoService().getProfesionalPorUsuario(reserva.getHrscoperador(), 
                                                                                       this.getClinica().getCclncodigo());


                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (profesional != null) {
                    NOMBRE_MEDICO = profesional.getCpfcnombre();
                    REGISTRO_MEDICO = profesional.getCpfcregmedic();
                }
            }

            if (reserva.getHrsetiporeserv() != null && 
                !reserva.getHrsetiporeserv().equals("")) {
                if(reserva.getHrsetiporeserv().equals("H")){
                      TIPO_RESERVA_DONANTE="Si";
                 }else{
                     TIPO_RESERVA_TRANSFUSIOIN = "Si";
                }
                    
                   
            }

            if (reserva.getHrscsolbancsan() != null) {
                BANCO_SANGRE = reserva.getHrscsolbancsan();
            }

            if (reserva.getHrsccuales() != null) {
                OTROS_COMPONENTES = reserva.getHrsccuales();
            }

            if (reserva.getHrsecompreserv() != null) {

                SANGRE_TOTAL = reserva.getHrsecompreserv();
            }

            if (reserva.getHrsncantidadre() != null) {
                CANTIDAD = reserva.getHrsncantidadre();
            }

            if (reserva.getHrsdfecregistr() != null) {
                FECHA_SOLICITUD = reserva.getHrsdfecregistr();
            }
            if (reserva.getHrsecompreserv() != null) {
             if(reserva.getHrsecompreserv().equals("S")){
                HEMOCOMPONENTE ="Sangre Total";
                }
                else{
                    HEMOCOMPONENTE = "Globulos Rojos";
                }
            }
            
            if (reserva.getHrscviaacceso() != null) {
                if ("OT".equals(reserva.getHrscviaacceso())) {
                    OTRA_VIA_ACCESO= reserva.getHrsccualviaacceso();
                } else {
                    VIA_ACCESO = reserva.getHrscviaacceso();
                }
            }
        }

        if (reserva != null && reserva.getHrsdcirugiapro() != null) {
            FECHA_PROGRAMADA = reserva.getHrsdcirugiapro();
        }
        TIPO_CIRUGIA = "";

        if (reserva != null && reserva.getHrsccirugiapro() != null) {

            StringTokenizer st = 
                new StringTokenizer(reserva.getHrsccirugiapro(), ",");

            Cpservicio servicioAux = null;

            while (st.hasMoreTokens()) {

                String idservicio = st.nextToken();

                try {
                    servicioAux = 
                            this.serviceLocator.getClinicoService().getServicioPorId(idservicio);

                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (servicioAux != null) {
                    TIPO_CIRUGIA = 
                            TIPO_CIRUGIA + servicioAux.getCsvcnombre() + ",";
                }
            }
            if (TIPO_CIRUGIA != null) {
                TIPO_CIRUGIA = 
                        TIPO_CIRUGIA.substring(0, TIPO_CIRUGIA.length() - 1);
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
            }
        }
    }


    public void obtenerDatosReporteCirugia() {

        Chusuario usuarioAux;
        usuarioAux = null;

        if (usuario != null) {
            usuarioAux = usuario;
        }

        if (usuarioAux != null) {
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

            if (usuarioAux.getHusanumeiden() != 0) {
                NUMERO_DOCUMENTO = usuarioAux.getHusanumeiden();
            }

            if (usuarioAux.getHusdfechanacim() != null) {
                Date fechaNacimiento = usuarioAux.getHusdfechanacim();
                if (fechaNacimiento != null) {
                    int edad = calcularEdad(fechaNacimiento, new Date());
                    EDAD = edad;
                }

                if (usuarioAux.getHusctelefono() != null) {
                    TELEFONO = usuarioAux.getHusctelefono();
                }
            }
        }

        if (reserva != null) {


            if (reserva.getHrsncantiotros() != null) {
                CANTIDAD_OTROS = reserva.getHrsncantiotros();
            }

            if (reserva.getHrscdiagprin() != null) {
                Crdgncie10 diagprin = null;

                try {
                    if (reserva.getHrscdiagprin() != null) {
                        diagprin = 
                                this.serviceLocator.getClinicoService().getCIE10PorCodigo(reserva.getHrscdiagprin().toUpperCase());
                    }

                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagprin != null) {
                    DIAGNOSTICO = diagprin.getCdccdescri();
                }
            }

            if (reserva.getHrseconmedalta() != null) {
                if (reserva.getHrseconmedalta().equals("S")) {
                    PROBLEMAS_AUTOTRANSFUSION = "Si";
                } else {
                    PROBLEMAS_AUTOTRANSFUSION = "No";
                }
            }

            if (reserva.getHrsetiporeserv() != null && 
                !reserva.getHrsetiporeserv().equals("")) {
                TIPO_RESERVA = reserva.getHrsetiporeserv();
            }

            if (reserva.getHrscsolbancsan() != null) {
                BANCO_SANGRE = reserva.getHrscsolbancsan();
            }

            if (reserva.getHrsccuales() != null) {
                OTROS_COMPONENTES = reserva.getHrsccuales();
            }

            if (reserva.getHrsecompreserv() != null) {

                SANGRE_TOTAL = reserva.getHrsecompreserv();
            }

            if (reserva.getHrsncantidadre() != null) {
                CANTIDAD = reserva.getHrsncantidadre();
            }

            if (reserva.getHrsdfecregistr() != null) {
                FECHA_SOLICITUD = reserva.getHrsdfecregistr();
            }
        }

        if (reserva != null && reserva.getHrsdcirugiapro() != null) {
            FECHA_PROGRAMADA = reserva.getHrsdcirugiapro();
        }
        TIPO_CIRUGIA = "";
        if (reserva != null && reserva.getHrsccirugiapro() != null) {

            StringTokenizer st = 
                new StringTokenizer(reserva.getHrsccirugiapro(), ",");
            Cpservicio servicioAux = null;
            while (st.hasMoreTokens()) {
                String idservicio = st.nextToken();

                try {
                    servicioAux = 
                            this.serviceLocator.getClinicoService().getServicioPorId(idservicio);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (servicioAux != null) {
                    TIPO_CIRUGIA = 
                            TIPO_CIRUGIA + servicioAux.getCsvcnombre() + ",";
                }

            }

            if (TIPO_CIRUGIA != null) {
                TIPO_CIRUGIA = 
                        TIPO_CIRUGIA.substring(0, TIPO_CIRUGIA.length() - 1);
            }
        }
    }

    //--------------------------------------------------------------------------
    //  Bot�n principal
    //--------------------------------------------------------------------------

    public void aceptar() {
        wexito = true;
        generoReserva = false;
        modoconsulta = false;
        ChresersangrPK id = new ChresersangrPK();

        if (reserva == null || reserva.getHrscdiagprin() == null || 
            reserva.getHrscdiagprin().equals("")) {
            FacesUtils.addErrorMessage("body:formReservaSangre:panelTabReservaSangre:itDiagPrin", 
                                       "El campo es obligatorio");
            wexito = false;
        }

        if (reserva == null || reserva.getHrseconmedalta() == null || 
            reserva.getHrseconmedalta().equals("")) {
            FacesUtils.addErrorMessage("body:formReservaSangre:panelTabReservaSangre:mnuCondicionesAlteran", 
                                       "El campo es obligatorio");
            wexito = false;
        }

        if (reserva == null || reserva.getHrsetiporeserv() == null || 
            reserva.getHrsetiporeserv().equals("")) {
            FacesUtils.addErrorMessage("body:formReservaSangre:panelTabReservaSangre:mnuTipoReserva", 
                                       "El campo es obligatorio");
            wexito = false;
        }
        if (reserva == null || reserva.getHrsecompreserv() == null || 
            reserva.getHrsecompreserv().equals("")) {
            FacesUtils.addErrorMessage("body:formReservaSangre:panelTabReservaSangre:mnuComponenteReserva", 
                                       "El campo es obligatorio");
            wexito = false;
        }

        if (reserva == null || reserva.getHrsncantidadre() == null || 
            reserva.getHrsncantidadre().equals("")) {
            FacesUtils.addErrorMessage("body:formReservaSangre:panelTabReservaSangre:itCantidad", 
                                       "El campo es obligatorio");
            wexito = false;
        }

        if (reserva == null || reserva.getHrseotrcompsan() == null || 
            reserva.getHrseotrcompsan().equals("")) {
            FacesUtils.addErrorMessage("body:formReservaSangre:panelTabReservaSangre:mnuOtrosComponentes", 
                                       "El campo es obligatorio");
            wexito = false;
        }
        if (reserva != null && reserva.getHrseotrcompsan() != null && 
            reserva.getHrseotrcompsan().equals("S")) {
            if (reserva == null || reserva.getHrsccuales() == null || 
                reserva.getHrsccuales().equals("")) {
                FacesUtils.addErrorMessage("body:formReservaSangre:panelTabReservaSangre:itCuales", 
                                           "El campo es obligatorio");
                wexito = false;
            }

            if (reserva == null || reserva.getHrsncantiotros() == null || 
                reserva.getHrsncantiotros().equals("")) {
                FacesUtils.addErrorMessage("body:formReservaSangre:panelTabReservaSangre:panelInputCantidadOtros", 
                                           "El campo es obligatorio");
                wexito = false;
            }
        }


        if (reserva == null || reserva.getHrscsolbancsan() == null || 
            reserva.getHrscsolbancsan().equals("")) {
            FacesUtils.addErrorMessage("body:formReservaSangre:panelTabReservaSangre:itSolicitudBanco", 
                                       "El campo es obligatorio");
            wexito = false;
        }
        if (lstExamenesCirugias == null || lstExamenesCirugias.isEmpty()) {
            FacesUtils.addErrorMessage("body:formReservaSangre:panelTabReservaSangre:imagelupa", 
                                        "El campo es obligatorio");
            wexito = false;
        }
        
        if (reserva == null || reserva.getHrscviaacceso() == null) {
            FacesUtils.addErrorMessage("body:formReservaSangre:panelTabReservaSangre:mnuViaAcceso", 
                                       "El campo es obligatorio");
            wexito = false;
        }
        
        if(reserva == null || "OT".equals(reserva.getHrscviaacceso())){
            if(reserva.getHrsccualviaacceso() == null || "".equals(reserva.getHrsccualviaacceso())){
                FacesUtils.addErrorMessage("body:formReservaSangre:panelTabReservaSangre:itCualVia", 
                                           "El campo es obligatorio");
                wexito = false;
            }
        
        }

        if (lstExamenesCirugias != null && !lstExamenesCirugias.isEmpty()) {
            String codigosCirugias;
            codigosCirugias = "";
            Cpservicio servicioAux;
            servicioAux = null;
            Iterator it = lstExamenesCirugias.iterator();
            while (it.hasNext()) {
                servicioAux = (Cpservicio)it.next();
                if (servicioAux != null) {
                    codigosCirugias = 
                            codigosCirugias + servicioAux.getCsvccodigo() + 
                            ",";
                }
            }

            codigosCirugias = 
                    codigosCirugias.substring(0, codigosCirugias.length() - 1);

            if (codigosCirugias != null) {
                reserva.setHrsccirugiapro(codigosCirugias);
            }
        }

        index = -1;

        if (wexito) {


            if (numeroConsulta != null && tipoServicio != null && 
                consecutivo != null) {
                id.setHrslconsulta(numeroConsulta);
                id.setHrsctiposervi(tipoServicio);
                id.setHrscconsecutiv(consecutivo);
                reserva.setId(id);
            }


            reserva.setHrscoperador(userName());
            reserva.setHrsdfecregistr(new Date());


            try {
                this.serviceLocator.getClinicoService().saveReservaSangre(reserva);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                e.printStackTrace();
            }


            try {
                if (!esCirugia) {
                    obtenerDatosReporteConsulta();
                } else {
                    obtenerDatosReporteCirugia();
                }

                URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reservaSangre.jasper");
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
                                                    "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                                    ".pdf", false);

                    generoReserva = true;
                    modoconsulta = true;

                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
            }
        }
    }
    
    public void changeCondicionAl() {
        if (reserva != null && reserva.getHrseconmedalta() != null && 
           reserva.getHrseconmedalta().equals("S")) {
            renderCondicionAl = true;
            
        } else {
            renderCondicionAl = false;
             }
    }


    // ACCESSORS

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
     * @param reserva
     */
    public void setReserva(Chresersangr reserva) {
        this.reserva = reserva;
    }

    /**
     * @return
     */
    public Chresersangr getReserva() {
        return reserva;
    }

    /**
     * @param dtCirugia
     */
    public void setDtCirugia(HtmlDataTable dtCirugia) {
        this.dtCirugia = dtCirugia;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCirugia() {
        return dtCirugia;
    }

    /**
     * @param generoReserva
     */
    public void setGeneroReserva(boolean generoReserva) {
        this.generoReserva = generoReserva;
    }

    /**
     * @return
     */
    public boolean isGeneroReserva() {
        return generoReserva;
    }


    /**
     * @param diagnosticoPrincipal
     */
    public void setDiagnosticoPrincipal(String diagnosticoPrincipal) {
        this.diagnosticoPrincipal = diagnosticoPrincipal;
    }

    /**
     * @return
     */
    public String getDiagnosticoPrincipal() {
        return diagnosticoPrincipal;
    }

    /**
     * @param mostrarCirugias
     */
    public void setMostrarCirugias(boolean mostrarCirugias) {
        this.mostrarCirugias = mostrarCirugias;
    }

    /**
     * @return
     */
    public boolean isMostrarCirugias() {
        return mostrarCirugias;
    }

    /**
     * @param mostrarCie10
     */
    public void setMostrarCie10(boolean mostrarCie10) {
        this.mostrarCie10 = mostrarCie10;
    }

    /**
     * @return
     */
    public boolean isMostrarCie10() {
        return mostrarCie10;
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
     * @param mostrarComponentes
     */
    public void setMostrarComponentes(boolean mostrarComponentes) {
        this.mostrarComponentes = mostrarComponentes;
    }

    /**
     * @return
     */
    public boolean isMostrarComponentes() {
        return mostrarComponentes;
    }

    /**
     * @param itDiagnostico
     */
    public void setItDiagnostico(UIInput itDiagnostico) {
        this.itDiagnostico = itDiagnostico;
    }

    /**
     * @return
     */
    public UIInput getItDiagnostico() {
        return itDiagnostico;
    }

    /**
     * @param lstExamenesCirugias
     */
    public void setLstExamenesCirugias(List lstExamenesCirugias) {
        this.lstExamenesCirugias = lstExamenesCirugias;
    }

    /**
     * @return
     */
    public List getLstExamenesCirugias() {
        return lstExamenesCirugias;
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
     * @param lstOpciones
     */
    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    /**
     * @return
     */
    public List getLstOpciones() {
        if (lstOpciones == null || lstOpciones.isEmpty()) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
    }

    /**
     * @param lstTipoReserva
     */
    public void setLstTipoReserva(List lstTipoReserva) {
        this.lstTipoReserva = lstTipoReserva;
    }

    /**
     * @return
     */
    public List getLstTipoReserva() {
        if (lstTipoReserva == null || lstTipoReserva.isEmpty()) {
            lstTipoReserva = new ArrayList();
            lstTipoReserva.add(new SelectItem("A", "Autoconservaci�n"));
            lstTipoReserva.add(new SelectItem("H", "Donaci�n"));
        }
        return lstTipoReserva;
    }

    /**
     * @param lstComponente
     */
    public void setLstComponente(List lstComponente) {
        this.lstComponente = lstComponente;
    }

    /**
     * @return
     */
    public List getLstComponente() {
        if (lstComponente == null || lstComponente.isEmpty()) {
            lstComponente = new ArrayList();
            lstComponente.add(new SelectItem("S", "Sangre Total"));
            lstComponente.add(new SelectItem("G", "Globulos Rojos"));
        }
        return lstComponente;
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


    public void setRenderCondicionAl(boolean renderCondicionAl) {
        this.renderCondicionAl = renderCondicionAl;
    }

    public boolean isRenderCondicionAl() {
        return renderCondicionAl;
    }

    public void setTIPO_RESERVA(String tIPO_RESERVA) {
        this.TIPO_RESERVA = tIPO_RESERVA;
    }

    public String getTIPO_RESERVA() {
        return TIPO_RESERVA;
    }

    public void setHEMOCOMPONENTE(String hEMOCOMPONENTE) {
        this.HEMOCOMPONENTE = hEMOCOMPONENTE;
    }

    public String getHEMOCOMPONENTE() {
        return HEMOCOMPONENTE;
    }

    public void setLstViasAcceso(List lstViasAcceso) {
        this.lstViasAcceso = lstViasAcceso;
    }

    public List getLstViasAcceso() {
        if (lstViasAcceso == null || lstViasAcceso.isEmpty()) {
            lstViasAcceso = new ArrayList();
            lstViasAcceso.add(new SelectItem("LT", "Laparotom�a"));
            lstViasAcceso.add(new SelectItem("LC", "Laparoscopia"));
            lstViasAcceso.add(new SelectItem("VG", "Vaginal"));
            lstViasAcceso.add(new SelectItem("OT", "Otra"));
        }
        return lstViasAcceso;
    }

    public void setMostrarOtraVia(boolean mostrarOtraVia) {
        this.mostrarOtraVia = mostrarOtraVia;
    }

    public boolean isMostrarOtraVia() {
        return mostrarOtraVia;
    }
}

