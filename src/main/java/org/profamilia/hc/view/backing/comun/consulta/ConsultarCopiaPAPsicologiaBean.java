package org.profamilia.hc.view.backing.comun.consulta;

import java.awt.Color;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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

import org.profamilia.hc.model.dto.Chantecespec;
import org.profamilia.hc.model.dto.Chantecfarma;
import org.profamilia.hc.model.dto.Chantecpatol;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chlecttuber;
import org.profamilia.hc.model.dto.ChlecttuberPK;
import org.profamilia.hc.model.dto.Chlibrocitol;
import org.profamilia.hc.model.dto.Chpapsicologico;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cncitolect;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cncitotoma;
import org.profamilia.hc.model.dto.Cncitovphlect;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cndesccito;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorUsuariosBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

public class ConsultarCopiaPAPsicologiaBean extends BaseBean implements JRDataSource {


    private int selectedIndex;

    private boolean renderBuscador;

    private boolean generoHistoria;

    private Chusuario usuario;

    private String nombreUsuario;

    BuscadorUsuariosBean buscador;

    private Long numeroUsuario;

    private boolean renderInformacionUsuario;

    private UIInput itNumeroUsuario;

    static final int ACTIVAR_BEAN = 0;

    static final int ACTIVAR_BUSCADOR = 1;

    private List<SelectItem> listSexos;

    /** Almacena la lista de los posibles estados civil  */
    private List<SelectItem> listEstadoCivil;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;


    private List lstPapsicologicoUsuario;

    private HtmlDataTable dtCopiaCitologia;

    private Cncitotoma toma;

    private Cncitolect lectura;

    private Cncitologi citologia;

    private int index = -1;

    private static int NUMERO_COPIAS = 1;

    Chlecttuber chlecttuber = new Chlecttuber();
    private String nextAction;

    private List<Chantecespec> listaTomaTuber = new ArrayList<Chantecespec>();

    Chantecespec antecespec = new Chantecespec();
    Chantecpatol antepatol = new Chantecpatol();
    Chantecfarma antefarma = new Chantecfarma();
    Cpusuario usu = new Cpusuario();
    ChlecttuberPK chChlecttuberId = new ChlecttuberPK();
    private boolean generoCopia;

    private boolean esPolicia;
    /*reporte tuberculina*/

    private String navigationRule;
    Cpclinica clinAux = new Cpclinica();
    private List<Cnconsclin> lstConsClin;
    protected Date FECHA;
    protected String CLINICA;
    protected String NOMBRES;
    protected String IDENTIFICACION;
    protected Date FECHANTO;
    protected String DESEOLLAMAR;
    protected String SEXO;
    protected String GENERO;
    protected String DIRECCION;
    protected String TELEFONO;
    protected String CIUDAD;
    protected String ZONA;
    protected String ESTADOCIVIL;
    protected String OCUPACION;
    protected String AFILIACION;
    protected String ASEGURADORA;
    protected String EDAD;
    protected String RESPONSABLE;
    protected String TELCONTACTO;
    protected String PARENTESCO;
    protected String OBSERVACION;
    protected String DOCUMENTO_PROFESIONAL;
    protected String NOMBRE_PROFESIONAL;

    private List listaChconsulta;
    Object[] consultaAuxT;
    private DatosBasicosUsuarioBean datosUsuario;

    /** Almacena la nota medica a persistir*/
    private Chpapsicologico nota;


    public ConsultarCopiaPAPsicologiaBean() {
    }


    public void init() {
        generoHistoria = false;
        listSexos = new ArrayList<SelectItem>();
        listEstadoCivil = new ArrayList<SelectItem>();
        listTipoIdentificacion = new ArrayList<SelectItem>();
        //        lstFolios = new ArrayList<Chconsulta>();
        lstConsClin = new ArrayList<Cnconsclin>();
        listaChconsulta = new ArrayList();
        if (usuario == null) {
            usuario = new Chusuario();
        }
        datosUsuario= (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        nextAction = "";
        Chlecttuber chlecttuber = new Chlecttuber();
        ChlecttuberPK chChlecttuberId = new ChlecttuberPK();
    }


    /**
     * @return
     */
    public boolean next() {
        index++;
        return (index < NUMERO_COPIAS);
    }

    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("FECHA")) {
            value = FECHA;
        }
        if (fieldName.equals("CLINICA")) {
            value = CLINICA;
        }
        if (fieldName.equals("NOMBRES")) {
            value = NOMBRES;
        }
        if (fieldName.equals("IDENTIFICACION")) {
            value = IDENTIFICACION;
        }
        if (fieldName.equals("FECHANTO")) {
            value = FECHANTO;
        }
        if (fieldName.equals("DESEOLLAMAR")) {
            value = DESEOLLAMAR;
        }
        if (fieldName.equals("SEXO")) {
            value = SEXO;
        }
        if (fieldName.equals("GENERO")) {
            value = GENERO;
        }
        if (fieldName.equals("DIRECCION")) {
            value = DIRECCION;
        }
        if (fieldName.equals("TELEFONO")) {
            value = TELEFONO;
        }
        if (fieldName.equals("CIUDAD")) {
            value = CIUDAD;
        }
        if (fieldName.equals("ZONA")) {
            value = ZONA;
        }
        if (fieldName.equals("ESTADOCIVIL")) {
            value = ESTADOCIVIL;
        }
        if (fieldName.equals("OCUPACION")) {
            value = OCUPACION;
        }
        if (fieldName.equals("AFILIACION")) {
            value = AFILIACION;
        }
        if (fieldName.equals("ASEGURADORA")) {
            value = ASEGURADORA;
        }
        if (fieldName.equals("EDAD")) {
            value = EDAD;
        }
        if (fieldName.equals("RESPONSABLE")) {
            value = RESPONSABLE;
        }
        if (fieldName.equals("TELCONTACTO")) {
            value = TELCONTACTO;
        }
        if (fieldName.equals("OBSERVACION")) {
            value = OBSERVACION;
        }

        return value;
    }

    public void obtenerDatosReporte(Chpapsicologico nota) throws ModelException {
        // Obtenemos los datos del usuario 
        resetDatos();
        Cpclinica clinAux = new Cpclinica();
        Cnconsclin cnconsclin= new Cnconsclin();
        cnconsclin=  this.getServiceLocator().getClinicoService().getConsultaClinicaPorId(nota.getHppnconsulta().toString());
        int edadUsu =  usuario.calcularEdad(usuario.getHusdfechanacim());
        clinAux = this.serviceLocator.getClinicoService().getClinica(cnconsclin.getCconclinic());
        String nombre1;
        String nombre2;
        String ape1;
        String ape2;
        FECHA = new Date();

        CLINICA = clinAux.getCclcnombre();


        if (usuario != null && usuario.getHuscprimernomb() != null) {
            nombre1 = (usuario.getHuscprimernomb() != null) ? usuario.getHuscprimernomb() :  " ";
            nombre2 = (usuario.getHuscsegundnomb() != null) ? usuario.getHuscsegundnomb() :  " ";
            ape1 = (usuario.getHuscprimerapel() != null) ? usuario.getHuscprimerapel() : " ";
            ape2 = (usuario.getHuscsegundapel() != null) ? usuario.getHuscsegundapel() : " ";

            NOMBRES = nombre1 + " " + nombre2 + " " + ape1 + " " + ape2;

        }
        if (usuario != null && 
            usuario.getHusetipoiden() != null) {
            IDENTIFICACION = 
                    usuario.getHusetipoiden() + " " + 
                    usuario.getHusanumeiden();
        }
        if (usuario != null && 
            usuario.getHuscnombralter() != null) {
            DESEOLLAMAR = usuario.getHuscnombralter();
        }
        if (usuario != null && 
            usuario.getHusesexo() != null) {

            SEXO = formatearCampoSexo(usuario.getHusesexo());
        }

        if (usuario != null && 
            usuario.getHuscidengene() != null) {

            GENERO = (usuario.getHusesexo());
            usuario.getHuscidengene();
        }
        if (usuario != null && 
            usuario.getHusezonareside() != null) {

            ZONA = usuario.getHusezonareside();
        }

        EDAD = edadUsu + "";

        if (usuario != null && 
            usuario.getHusdfechanacim() != null) {
            FECHANTO = usuario.getHusdfechanacim();
        }
        if (usuario != null && 
            usuario.getHusnciudad() != null) {
            Cpmunidane n = new Cpmunidane();
            n = 
  this.getServiceLocator().getClinicoService().getMunicipio(usuario.getHusnciudad(), 
                                                            usuario.getHusndepartamen());
            CIUDAD = n.getCmdcnomdpt();
        }
        if (usuario != null && 
            usuario.getHuscdireccion() != null) {
            DIRECCION = usuario.getHuscdireccion();
        }
        if (usuario != null && 
            usuario.getHusctelefono() != null) {
            TELEFONO = usuario.getHusctelefono();
        }
        if (usuario != null && 
            usuario.getHusnocupacion() != null) {
            OCUPACION = 
                    this.getServiceLocator().getClinicoService().getDescripcionOcupacion(usuario.getHusnocupacion());
        }
        if (usuario != null && 
            usuario.getHuseestadcivil() != null) {
            ESTADOCIVIL = 
                    formatearEstadoCivil(usuario.getHuseestadcivil());
        }
        if (usuario != null && 
            usuario.getHuscnomresponsa() != null) {
            RESPONSABLE = usuario.getHuscnomresponsa();
        }
        if (usuario != null && 
            usuario.getHusetipoafilia() != null) {
            if(usuario.getHusetipoafilia().equals("C")){
             AFILIACION = "CONTRIBUTIVO";
            }
            if(usuario.getHusetipoafilia().equals("S")){
             AFILIACION = "SUBSIDIADO";
            }
            if(usuario.getHusetipoafilia().equals("E")){
             AFILIACION = "ESPECIAL";
            }
            if(usuario.getHusetipoafilia().equals("X")){
             AFILIACION = "NINGUNO";
            }
            if(usuario.getHusetipoafilia().equals("R")){
             AFILIACION = "SUBSIDIO PARCIAL";
            }
            if(usuario.getHusetipoafilia().equals("V")){
             AFILIACION = "VINCULADO";
            }
           
        }
        if (usuario != null && 
            usuario.getHuscentidadadm() != null) {
            ASEGURADORA = usuario.getHuscentidadadm();
        }
        if (usuario != null && 
            usuario.getHusctelacompana() != null) {
            TELCONTACTO = usuario.getHusctelacompana();
        }
        if (usuario != null && 
            usuario.getHuscparresponsa() != null) {
            PARENTESCO = usuario.getHuscparresponsa();
        }
        if (nota != null) {
            OBSERVACION = nota.getHppcobservacion();
        }
        
       
    }

    public void resetDatos() {
        FECHA = new Date();
        CLINICA = "";
        NOMBRES = "";
        IDENTIFICACION = "";
        FECHANTO = new Date();
        DESEOLLAMAR = "";
        SEXO = "";
        GENERO = "";
        DIRECCION = "";
        TELEFONO = "";
        CIUDAD = "";
        ZONA = "";
        ESTADOCIVIL = "";
        OCUPACION = "";
        AFILIACION = "";
        ASEGURADORA = "";
        EDAD = "";
        RESPONSABLE = "";
        TELCONTACTO = "";
        PARENTESCO = "";
        OBSERVACION = "";
    }


    public void mostrarBuscadorUsuarios() {
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        selectedIndex = ACTIVAR_BUSCADOR;
        renderBuscador = true;
        generoHistoria = false;
        lstPapsicologicoUsuario = new ArrayList();

    }

    public void consultasTuberculina() throws ModelException {

        consultaAuxT = (Object[])dtCopiaCitologia.getRowData();

        nota =this.getServiceLocator().getClinicoService().getPapsicologicosUser(new Long(consultaAuxT[0].toString()));

    }


    public void consultarPapsicologicoUsuario() {


        try {
            lstPapsicologicoUsuario = 
                    this.serviceLocator.getClinicoService().getCopiaPapsicologico(numeroUsuario);
        } catch (ModelException e) {
            e.printStackTrace();
        }

    }


    public void changeUsuario() {
        Chusuario usuarioAux = null;
        generoHistoria = false;
        nombreUsuario = "";
        usuario = new Chusuario();
        if (numeroUsuario != null)
            try {
                usuarioAux = 
                        this.serviceLocator.getClinicoService().getUsuario(numeroUsuario);
            } catch (ModelException e) {
                e.printStackTrace();
            }

        if (usuarioAux != null) {
            if (usuarioAux.getHuscprimernomb() != null) {
                nombreUsuario = usuarioAux.getHuscprimernomb() + " ";
            }
            if (usuarioAux.getHuscsegundnomb() != null && 
                !usuarioAux.getHuscsegundnomb().equals("_")) {
                nombreUsuario = 
                        nombreUsuario + usuarioAux.getHuscsegundnomb() + " ";
            }
            if (usuarioAux.getHuscprimerapel() != null) {
                nombreUsuario = 
                        nombreUsuario + usuarioAux.getHuscprimerapel() + " ";
            }
            if (usuarioAux.getHuscsegundapel() != null && 
                !usuarioAux.getHuscsegundapel().equals("_")) {
                nombreUsuario = nombreUsuario + usuarioAux.getHuscsegundapel();
            }

            usuario = usuarioAux;

        }
    }


    /**
     * @param valueChangeEvent
     */
    public void setNumeroUsuario(ValueChangeEvent valueChangeEvent) {
        setNumeroUsuario((Long)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void aceptarUsuario() {
        selectedIndex = ACTIVAR_BEAN;

        usuario = new Chusuario();
        nombreUsuario = "";


        buscador = 
                (BuscadorUsuariosBean)FacesUtils.getManagedBean("buscadorUsuariosBean");
        usuario = buscador.getUsuarioSelect();
        if (usuario != null) {
            numeroUsuario = usuario.getHuslnumero();
            if (usuario.getHuscprimernomb() != null) {
                nombreUsuario = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                nombreUsuario = 
                        nombreUsuario + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                nombreUsuario = 
                        nombreUsuario + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                nombreUsuario = nombreUsuario + usuario.getHuscsegundapel();
            }
            itNumeroUsuario.setValue(usuario.getHuslnumero());
        }
        renderBuscador = false;

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
     * @param renderBuscador
     */
    public void setRenderBuscador(boolean renderBuscador) {
        this.renderBuscador = renderBuscador;
    }

    /**
     * @return
     */
    public boolean isRenderBuscador() {
        return renderBuscador;
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
     * @param nombreUsuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return
     */
    public String getNombreUsuario() {
        return nombreUsuario;
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
     * @param itNumeroUsuario
     */
    public void setItNumeroUsuario(UIInput itNumeroUsuario) {
        this.itNumeroUsuario = itNumeroUsuario;
    }

    /**
     * @return
     */
    public UIInput getItNumeroUsuario() {
        return itNumeroUsuario;
    }

    public void setListSexos(List<SelectItem> listSexos) {
        this.listSexos = listSexos;
    }

    public List getListSexos() {
        if (listSexos == null || listSexos.isEmpty()) {
            listSexos = new ArrayList<SelectItem>();
            ArrayList<Chsexo> listSexoAux = null;
            try {
                listSexoAux = 
                        (ArrayList<Chsexo>)this.getServiceLocator().getClinicoService().getSexo();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listSexoAux.isEmpty()) {

                Iterator it = listSexoAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listSexos.add(new SelectItem(listSexoAux.get(i).getCsxecodigo(), 
                                                 listSexoAux.get(i).getCsxcdescripcio()));
                    i++;

                }
            }
        }
        return listSexos;
    }

    public void setListEstadoCivil(List<SelectItem> listEstadoCivil) {
        this.listEstadoCivil = listEstadoCivil;
    }

    public List<SelectItem> getListEstadoCivil() {
        if (listEstadoCivil == null || listEstadoCivil.isEmpty()) {
            listEstadoCivil = new ArrayList<SelectItem>();
            ArrayList<Chestadociv> listEstadoCivilAux = null;
            try {
                listEstadoCivilAux = 
                        (ArrayList<Chestadociv>)this.getServiceLocator().getClinicoService().getEstadoCivil();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listEstadoCivilAux.isEmpty()) {

                Iterator it = listEstadoCivilAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listEstadoCivil.add(new SelectItem(listEstadoCivilAux.get(i).getCececodigo(), 
                                                       listEstadoCivilAux.get(i).getCeccdescripcio()));
                    i++;
                }
            }
        }
        return listEstadoCivil;
    }

    public void setListTipoIdentificacion(List<SelectItem> listTipoIdentificacion) {
        this.listTipoIdentificacion = listTipoIdentificacion;
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
     * @param dtCopiaCitologia
     */
    public void setDtCopiaCitologia(HtmlDataTable dtCopiaCitologia) {
        this.dtCopiaCitologia = dtCopiaCitologia;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCopiaCitologia() {
        return dtCopiaCitologia;
    }

    /**
     * @return
     */
    public String volverConsulta() {

        FacesUtils.resetManagedBean("consultarCopiaCitologiaBean");
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        generoHistoria = false;
        return BeanNavegacion.RUTA_IR_INICIO;
    }


    public String generarCopiaCopiaPAPsicologicos() {
        navigationRule = "";
        Cpusuario u = new Cpusuario();
        try {
            consultasTuberculina();

            usu = 
this.getServiceLocator().getClinicoService().getUsuarioPorOperador((this.getUsuarioSystem().getCurcusuari().toUpperCase()));


            imprimirResumen();

            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            FacesUtils.resetManagedBean("listaTuberculinaBean");
            navigationRule = nextAction;

        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + " : " + 
                                       e.getMessage());

            e.printStackTrace();
        }
        return navigationRule;

    }

    public void generarReporte() throws ModelException {
        consultasTuberculina();
        obtenerDatosReporte(nota);

    }


    public void imprimirResumen() {
        this.index = -1;

        try {

            generoCopia = false;
            generarReporte();
            URL url = 
                FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reportePAuxPsicologia.jasper");
            URL url_profamilia = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);

            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);

                byte[] bytes;

                JasperReport report = (JasperReport)JRLoader.loadObject(url);
                bytes = 
                        JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                PdfServletUtils.showPdfDocument(bytes, 
                                                "Primeros Auxilios Psicologia" + 
                                                ".pdf", false);
                generoCopia = true;
                navigationRule = nextAction;

            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());

        }


    }


    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }


    public void setChlecttuber(Chlecttuber chlecttuber) {
        this.chlecttuber = chlecttuber;
    }

    public Chlecttuber getChlecttuber() {
        return chlecttuber;
    }

    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    public String getNextAction() {
        return nextAction;
    }

    public void setListaTomaTuber(List<Chantecespec> listaTomaTuber) {
        this.listaTomaTuber = listaTomaTuber;
    }

    public List<Chantecespec> getListaTomaTuber() {
        return listaTomaTuber;
    }

    public void setAntecespec(Chantecespec antecespec) {
        this.antecespec = antecespec;
    }

    public Chantecespec getAntecespec() {
        return antecespec;
    }

    public void setAntepatol(Chantecpatol antepatol) {
        this.antepatol = antepatol;
    }

    public Chantecpatol getAntepatol() {
        return antepatol;
    }

    public void setAntefarma(Chantecfarma antefarma) {
        this.antefarma = antefarma;
    }

    public Chantecfarma getAntefarma() {
        return antefarma;
    }

    public void setUsu(Cpusuario usu) {
        this.usu = usu;
    }

    public Cpusuario getUsu() {
        return usu;
    }

    public void setChChlecttuberId(ChlecttuberPK chChlecttuberId) {
        this.chChlecttuberId = chChlecttuberId;
    }

    public ChlecttuberPK getChChlecttuberId() {
        return chChlecttuberId;
    }

    public void setGeneroCopia(boolean generoCopia) {
        this.generoCopia = generoCopia;
    }

    public boolean isGeneroCopia() {
        return generoCopia;
    }

    public void setEsPolicia(boolean esPolicia) {
        this.esPolicia = esPolicia;
    }

    public boolean isEsPolicia() {
        return esPolicia;
    }

    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public String getNavigationRule() {
        return navigationRule;
    }

    public void setClinAux(Cpclinica clinAux) {
        this.clinAux = clinAux;
    }

    public Cpclinica getClinAux() {
        return clinAux;
    }

    public void setLstConsClin(List<Cnconsclin> lstConsClin) {
        this.lstConsClin = lstConsClin;
    }

    public List<Cnconsclin> getLstConsClin() {
        return lstConsClin;
    }

    public void setListaChconsulta(List listaChconsulta) {
        this.listaChconsulta = listaChconsulta;
    }

    public List getListaChconsulta() {
        return listaChconsulta;
    }

    public void setConsultaAuxT(Object[] consultaAuxT) {
        this.consultaAuxT = consultaAuxT;
    }

    public Object[] getConsultaAuxT() {
        return consultaAuxT;
    }

    public void setLstPapsicologicoUsuario(List lstPapsicologicoUsuario) {
        this.lstPapsicologicoUsuario = lstPapsicologicoUsuario;
    }

    public List getLstPapsicologicoUsuario() {
        return lstPapsicologicoUsuario;
    }

    public void setDatosUsuario(DatosBasicosUsuarioBean datosUsuario) {
        this.datosUsuario = datosUsuario;
    }

    public DatosBasicosUsuarioBean getDatosUsuario() {
        return datosUsuario;
    }

    public void setNUMERO_COPIAS(int nUMERO_COPIAS) {
        this.NUMERO_COPIAS = nUMERO_COPIAS;
    }

    public int getNUMERO_COPIAS() {
        return NUMERO_COPIAS;
    }

    public void setFECHA(Date fECHA) {
        this.FECHA = fECHA;
    }

    public Date getFECHA() {
        return FECHA;
    }

    public void setCLINICA(String cLINICA) {
        this.CLINICA = cLINICA;
    }

    public String getCLINICA() {
        return CLINICA;
    }

    public void setNOMBRES(String nOMBRES) {
        this.NOMBRES = nOMBRES;
    }

    public String getNOMBRES() {
        return NOMBRES;
    }

    public void setIDENTIFICACION(String iDENTIFICACION) {
        this.IDENTIFICACION = iDENTIFICACION;
    }

    public String getIDENTIFICACION() {
        return IDENTIFICACION;
    }

    public void setFECHANTO(Date fECHANTO) {
        this.FECHANTO = fECHANTO;
    }

    public Date getFECHANTO() {
        return FECHANTO;
    }

    public void setDESEOLLAMAR(String dESEOLLAMAR) {
        this.DESEOLLAMAR = dESEOLLAMAR;
    }

    public String getDESEOLLAMAR() {
        return DESEOLLAMAR;
    }

    public void setSEXO(String sEXO) {
        this.SEXO = sEXO;
    }

    public String getSEXO() {
        return SEXO;
    }

    public void setGENERO(String gENERO) {
        this.GENERO = gENERO;
    }

    public String getGENERO() {
        return GENERO;
    }

    public void setDIRECCION(String dIRECCION) {
        this.DIRECCION = dIRECCION;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setTELEFONO(String tELEFONO) {
        this.TELEFONO = tELEFONO;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setCIUDAD(String cIUDAD) {
        this.CIUDAD = cIUDAD;
    }

    public String getCIUDAD() {
        return CIUDAD;
    }

    public void setZONA(String zONA) {
        this.ZONA = zONA;
    }

    public String getZONA() {
        return ZONA;
    }

    public void setESTADOCIVIL(String eSTADOCIVIL) {
        this.ESTADOCIVIL = eSTADOCIVIL;
    }

    public String getESTADOCIVIL() {
        return ESTADOCIVIL;
    }

    public void setOCUPACION(String oCUPACION) {
        this.OCUPACION = oCUPACION;
    }

    public String getOCUPACION() {
        return OCUPACION;
    }

    public void setAFILIACION(String aFILIACION) {
        this.AFILIACION = aFILIACION;
    }

    public String getAFILIACION() {
        return AFILIACION;
    }

    public void setASEGURADORA(String aSEGURADORA) {
        this.ASEGURADORA = aSEGURADORA;
    }

    public String getASEGURADORA() {
        return ASEGURADORA;
    }

    public void setEDAD(String eDAD) {
        this.EDAD = eDAD;
    }

    public String getEDAD() {
        return EDAD;
    }

    public void setRESPONSABLE(String rESPONSABLE) {
        this.RESPONSABLE = rESPONSABLE;
    }

    public String getRESPONSABLE() {
        return RESPONSABLE;
    }

    public void setTELCONTACTO(String tELCONTACTO) {
        this.TELCONTACTO = tELCONTACTO;
    }

    public String getTELCONTACTO() {
        return TELCONTACTO;
    }

    public void setPARENTESCO(String pARENTESCO) {
        this.PARENTESCO = pARENTESCO;
    }

    public String getPARENTESCO() {
        return PARENTESCO;
    }

    public void setOBSERVACION(String oBSERVACION) {
        this.OBSERVACION = oBSERVACION;
    }

    public String getOBSERVACION() {
        return OBSERVACION;
    }

    public void setNota(Chpapsicologico nota) {
        this.nota = nota;
    }

    public Chpapsicologico getNota() {
        return nota;
    }

    public void setDOCUMENTO_PROFESIONAL(String dOCUMENTO_PROFESIONAL) {
        this.DOCUMENTO_PROFESIONAL = dOCUMENTO_PROFESIONAL;
    }

    public String getDOCUMENTO_PROFESIONAL() {
        return DOCUMENTO_PROFESIONAL;
    }

    public void setNOMBRE_PROFESIONAL(String nOMBRE_PROFESIONAL) {
        this.NOMBRE_PROFESIONAL = nOMBRE_PROFESIONAL;
    }

    public String getNOMBRE_PROFESIONAL() {
        return NOMBRE_PROFESIONAL;
    }
}
