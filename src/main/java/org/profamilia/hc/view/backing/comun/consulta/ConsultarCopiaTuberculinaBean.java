package org.profamilia.hc.view.backing.comun.consulta;


import com.lowagie.text.Document;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.Barcode39;
import com.lowagie.text.pdf.PdfWriter;

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
import org.profamilia.hc.view.backing.comun.buscador.BuscadorUsuariosBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

public class ConsultarCopiaTuberculinaBean extends BaseBean implements JRDataSource {


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


    private List lstCitologiaUsuario;

    private HtmlDataTable dtCopiaCitologia;

    private Cncitotoma toma;

    private Cncitolect lectura;

    private Cncitologi citologia;

    private int index = -1;

    private static int NUMERO_COPIAS = 1;
    
    Chlecttuber chlecttuber = new Chlecttuber();
    private String nextAction;
    
    private List<Chantecespec> listaTomaTuber= new ArrayList<Chantecespec>();
    
    Chantecespec antecespec = new Chantecespec();
    Chantecpatol antepatol = new Chantecpatol();
    Chantecfarma antefarma = new Chantecfarma();
    Cpusuario usu= new Cpusuario();
    ChlecttuberPK chChlecttuberId= new ChlecttuberPK();
    private boolean generoTuberculina;

    private boolean esPolicia;
    /*reporte tuberculina*/
    protected String HISTORIACLINICA;
    protected String CLINICA;
    protected Date FECHA;
    protected String NOMBRECOMPLETO;
    protected String DOCUMENTO;
    protected String DESEALLAMAR;
    protected String SEXO;
    protected String EDAD;
    protected Date FECHANACIMIENTO;
    protected String CIUDAD;
    protected String EPS;
    protected String DIRECCION;
    protected String TELEFONO;
    protected String OCUPACION;
    protected String ESTADOCIVIL;
    protected String RESPONSABLE;
    protected String PARENTESCORES;
    protected String TELEFONORES;
    protected String ACOMPANANTE;
    protected String PARENTESCOACOM;
    protected String TELEFONOACOM;
    protected Date FECHAPLICA;
    protected String PESO;
    protected String TALLA;
    protected String PRESENTATUBER;
    protected String CUANDOPRESENTA;
    protected String TRATAMIENTO;
    protected String CUANTOTIEMPO;
    protected String CONTACTOTUBER;
    protected String QUIENCONTACTO;
    protected String VIVECONEL;
    protected String TIEMPOCONEL;
    protected String VIH;
    protected String DIABETESMELL;
    protected String ARTRITISREU;
    protected String ESCLEROMUL;
    protected String CANCER;
    protected String ESCLEROAMIO;
    protected String NEFROPATIA;
    protected String MIGRANA;
    protected String FIBROMIALGIA;
    protected String OTRA;
    protected String CUAL;
    protected String AINES;
    protected String CUALAINES;
    protected String FRECUEAINES;
    protected String ANTIA;
    protected String ANTIACUAL;
    protected String FRECUEANTIA;
    protected String ANTICOAGULANTE;
    protected String ANTICOCUAL;
    protected String FRECUEANTICOA;
    protected String APLICAMEDI;
    protected String CUALMEDI;
    protected String APLICAVACU;
    protected String CUALVACU;
    protected String DIASVACU;
    protected Date FECHALECTURA;
    protected String RESULTADO;
    protected String OBSERVACIONES;
    protected String NOMBRETOMA;
    protected String PROFESIONTOMA;
    protected String ENTIDADTOMA;
    protected String NOMBRELECT;
    protected String PROFESIONLECT;
    protected String ENTIDADLECT;
    private String navigationRule;
    Cpclinica clinAux= new Cpclinica();
    private List<Cnconsclin> lstConsClin;
    
    
    private List listaChconsulta;
    Object[] consultaAuxT;


    public ConsultarCopiaTuberculinaBean() {
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
        nextAction = "";
        Chlecttuber chlecttuber = new Chlecttuber();
        ChlecttuberPK chChlecttuberId= new ChlecttuberPK();
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

        if (fieldName.equals("HISTORIACLINICA")) {
            value = HISTORIACLINICA;
        }
        if (fieldName.equals("CLINICA")) {
            value = CLINICA;
        }
        if (fieldName.equals("FECHA")) {
            value = FECHA;
        }
        if (fieldName.equals("NOMBRECOMPLETO")) {
            value = NOMBRECOMPLETO;
        }
        if (fieldName.equals("DOCUMENTO")) {
            value = DOCUMENTO;
        }
        if (fieldName.equals("DESEALLAMAR")) {
            value = DESEALLAMAR;
        }
        if (fieldName.equals("SEXO")) {
            value = SEXO;
        }
        if (fieldName.equals("EDAD")) {
            value = EDAD;
        }
        if (fieldName.equals("FECHANACIMIENTO")) {
            value = FECHANACIMIENTO;
        }
        if (fieldName.equals("CIUDAD")) {
            value = CIUDAD;
        }
        if (fieldName.equals("EPS")) {
            value = EPS;
        }
        if (fieldName.equals("DIRECCION")) {
            value = DIRECCION;
        }
        if (fieldName.equals("TELEFONO")) {
            value = TELEFONO;
        }
        if (fieldName.equals("OCUPACION")) {
            value = OCUPACION;
        }
        if (fieldName.equals("ESTADOCIVIL")) {
            value = ESTADOCIVIL;
        }
        if (fieldName.equals("RESPONSABLE")) {
            value = RESPONSABLE;
        }
        if (fieldName.equals("PARENTESCORES")) {
            value = PARENTESCORES;
        }
        if (fieldName.equals("TELEFONORES")) {
            value = TELEFONORES;
        }
        if (fieldName.equals("ACOMPANANTE")) {
            value = ACOMPANANTE;
        }
        if (fieldName.equals("PARENTESCOACOM")) {
            value = PARENTESCOACOM;
        }
        if (fieldName.equals("TELEFONOACOM")) {
            value = TELEFONOACOM;
        }
        if (fieldName.equals("FECHAPLICA")) {
            value = FECHAPLICA;
        }
        if (fieldName.equals("PESO")) {
            value = PESO;
        }
        if (fieldName.equals("TALLA")) {
            value = TALLA;
        }
        if (fieldName.equals("PRESENTATUBER")) {
            value = PRESENTATUBER;
        }
        if (fieldName.equals("CUANDOPRESENTA")) {
            value = CUANDOPRESENTA;
        }
        if (fieldName.equals("TRATAMIENTO")) {
            value = TRATAMIENTO;
        }
        if (fieldName.equals("CUANTOTIEMPO")) {
            value = CUANTOTIEMPO;
        }
        if (fieldName.equals("CONTACTOTUBER")) {
            value = CONTACTOTUBER;
        }
        if (fieldName.equals("QUIENCONTACTO")) {
            value = QUIENCONTACTO;
        }
        if (fieldName.equals("VIVECONEL")) {
            value = VIVECONEL;
        }
        if (fieldName.equals("TIEMPOCONEL")) {
            value = TIEMPOCONEL;
        }
        if (fieldName.equals("VIH")) {
            value = VIH;
        }
        if (fieldName.equals("DIABETESMELL")) {
            value = DIABETESMELL;
        }
        if (fieldName.equals("ARTRITISREU")) {
            value = ARTRITISREU;
        }
        if (fieldName.equals("ESCLEROMUL")) {
            value = ESCLEROMUL;
        }
        if (fieldName.equals("CANCER")) {
            value = CANCER;
        }
        if (fieldName.equals("ESCLEROAMIO")) {
            value = ESCLEROAMIO;
        }
        if (fieldName.equals("NEFROPATIA")) {
            value = NEFROPATIA;
        }
        if (fieldName.equals("MIGRANA")) {
            value = MIGRANA;
        }
        if (fieldName.equals("FIBROMIALGIA")) {
            value = FIBROMIALGIA;
        }
        if (fieldName.equals("OTRA")) {
            value = OTRA;
        }
        if (fieldName.equals("CUAL")) {
            value = CUAL;
        }
        if (fieldName.equals("AINES")) {
            value = AINES;
        }
        if (fieldName.equals("CUALAINES")) {
            value = CUALAINES;
        }
        if (fieldName.equals("FRECUEAINES")) {
            value = FRECUEAINES;
        }
        if (fieldName.equals("ANTIA")) {
            value = ANTIA;
        }
        if (fieldName.equals("ANTIACUAL")) {
            value = ANTIACUAL;
        }
        if (fieldName.equals("FRECUEANTIA")) {
            value = FRECUEANTIA;
        }
        if (fieldName.equals("ANTICOAGULANTE")) {
            value = ANTICOAGULANTE;
        }
        if (fieldName.equals("ANTICOCUAL")) {
            value = ANTICOCUAL;
        }
        if (fieldName.equals("FRECUEANTICOA")) {
            value = FRECUEANTICOA;
        }
        if (fieldName.equals("APLICAMEDI")) {
            value = APLICAMEDI;
        }
        if (fieldName.equals("CUALMEDI")) {
            value = CUALMEDI;
        }
        if (fieldName.equals("APLICAVACU")) {
            value = APLICAVACU;
        }
        if (fieldName.equals("CUALVACU")) {
            value = CUALVACU;
        }
        if (fieldName.equals("DIASVACU")) {
            value = DIASVACU;
        }
        if (fieldName.equals("FECHALECTURA")) {
            value = FECHALECTURA;
        }
        if (fieldName.equals("RESULTADO")) {
            value = RESULTADO;
        }
        if (fieldName.equals("OBSERVACIONES")) {
            value = OBSERVACIONES;
        }
        if (fieldName.equals("NOMBRETOMA")) {
            value = NOMBRETOMA;
        }
        if (fieldName.equals("PROFESIONTOMA")) {
            value = PROFESIONTOMA;
        }
        if (fieldName.equals("ENTIDADTOMA")) {
            value = ENTIDADTOMA;
        }
        if (fieldName.equals("NOMBRELECT")) {
            value = NOMBRELECT;
        }
        if (fieldName.equals("PROFESIONLECT")) {
            value = PROFESIONLECT;
        }
        if (fieldName.equals("ENTIDADLECT")) {
            value = ENTIDADLECT;
        }

        return value;
    }

    public void obtenerDatosReporte(Chantecespec antecespec, 
                                    Chantecpatol antepatol, 
                                    Chantecfarma antefarma, Cpusuario usu, 
                                    Chlecttuber chlecttuber, 
                                    Cpclinica clinAux) throws ModelException {
        // Obtenemos los datos del usuario 
        resetDatos();

        int edadUsu = usuario.calcularEdad(usuario.getHusdfechanacim());
        String nombre1;
        String nombre2;
        String ape1;
        String ape2;
        FECHA = new Date();
        HISTORIACLINICA = usuario.getHusanumeiden().toString();
        CLINICA = clinAux.getCclcnombre();

        if (usuario != null && usuario.getHuscprimernomb() != null) {
            nombre1 = 
                    (usuario.getHuscprimernomb() != null) ? usuario.getHuscprimernomb() : 
                    " ";
            nombre2 = 
                    (usuario.getHuscsegundnomb() != null) ? usuario.getHuscsegundnomb() : 
                    " ";
            ape1 = 
(usuario.getHuscprimerapel() != null) ? usuario.getHuscprimerapel() : " ";
            ape2 = 
(usuario.getHuscsegundapel() != null) ? usuario.getHuscsegundapel() : " ";

            NOMBRECOMPLETO = nombre1 + " " + nombre2 + " " + ape1 + " " + ape2;

        }
        if (usuario != null && usuario.getHusetipoiden() != null) {
            DOCUMENTO = 
                    usuario.getHusetipoiden() + " " + usuario.getHusanumeiden();
        }
        if (usuario != null && usuario.getHuscnombralter() != null) {
            DESEALLAMAR = usuario.getHuscnombralter();
        }
        if (usuario != null && usuario.getHusesexo() != null) {

            SEXO = formatearCampoSexo(usuario.getHusesexo());
        }

        EDAD = edadUsu + "";

        if (usuario != null && usuario.getHusdfechanacim() != null) {
            FECHANACIMIENTO = usuario.getHusdfechanacim();
        }
        if (usuario != null && usuario.getHusnciudad() != null) {
            Cpmunidane n = new Cpmunidane();
            n = 
  this.getServiceLocator().getClinicoService().getMunicipio(usuario.getHusnciudad(), 
                                                            usuario.getHusndepartamen());
            CIUDAD = n.getCmdcnomdpt();
        }
        if (usuario != null && usuario.getHuscentidadadm() != null) {
            EPS = obtenerNombreEps(usuario.getHuscentidadadm());
        }
        if (usuario != null && usuario.getHuscdireccion() != null) {
            DIRECCION = usuario.getHuscdireccion();
        }
        if (usuario != null && usuario.getHusctelefono() != null) {
            TELEFONO = usuario.getHusctelefono();
        }
        if (usuario != null && usuario.getHusnocupacion() != null) {
            OCUPACION = 
                    this.getServiceLocator().getClinicoService().getDescripcionOcupacion(usuario.getHusnocupacion());
        }
        if (usuario != null && usuario.getHuseestadcivil() != null) {
            ESTADOCIVIL = formatearEstadoCivil(usuario.getHuseestadcivil());
        }
        if (usuario != null && usuario.getHuscnomresponsa() != null) {
            RESPONSABLE = usuario.getHuscnomresponsa();
        }
        if (usuario != null && usuario.getHuscparresponsa() != null) {
            PARENTESCORES = usuario.getHuscparresponsa();
        }
        if (usuario != null && usuario.getHusctelresponsa() != null) {
            TELEFONORES = usuario.getHusctelresponsa();
        }
        if (usuario != null && usuario.getHuscnomacompana() != null) {
            ACOMPANANTE = usuario.getHuscnomacompana();
        }
        if (usuario != null && usuario.getHuscparresponsa() != null) {
            PARENTESCOACOM = usuario.getHuscparresponsa();
        }
        if (usuario != null && usuario.getHusctelacompana() != null) {
            TELEFONOACOM = usuario.getHusctelacompana();
        }

        if (antecespec != null && antecespec.getHaedfechaplic() != null) {
            FECHAPLICA = antecespec.getHaedfechaplic();
        }

        if (antecespec != null && antecespec.getHaenpeso() != null) {
            PESO = antecespec.getHaenpeso().toString();
        }
        if (antecespec != null && antecespec.getHaentalla() != null) {
            TALLA = antecespec.getHaentalla();
        }
        if (antecespec != null && antecespec.getHaecprestuber() != null) {
            PRESENTATUBER = antecespec.getHaecprestuber();
        }
        if (antecespec != null && antecespec.getHaeccuantuber() != null) {
            CUANDOPRESENTA = antecespec.getHaeccuantuber();
        }
        if (antecespec != null && antecespec.getHaecrecibtrata() != null) {
            TRATAMIENTO = antecespec.getHaecrecibtrata();
        }
        if (antecespec != null && antecespec.getHaectiemptrata() != null) {
            CUANTOTIEMPO = antecespec.getHaectiemptrata();
        }
        if (antecespec != null && antecespec.getHaeccontactubercu() != null) {
            CONTACTOTUBER = antecespec.getHaeccontactubercu();
        }
        if (antecespec != null && antecespec.getHaecquiencontac() != null) {
            QUIENCONTACTO = antecespec.getHaecquiencontac();
        }
        if (antecespec != null && antecespec.getHaecviveconel() != null) {
            VIVECONEL = antecespec.getHaecviveconel();
        }
        if (antecespec != null && antecespec.getHaectiempocompart() != null) {
            TIEMPOCONEL = antecespec.getHaectiempocompart();
        }

        if (antepatol != null && antepatol.getHapcvih() != null) {
            VIH = antepatol.getHapcvih();
        }
        if (antepatol != null && antepatol.getHapcdiabmelli() != null) {
            DIABETESMELL = antepatol.getHapcdiabmelli();
        }
        if (antepatol != null && antepatol.getHapcartrireuma() != null) {
            ARTRITISREU = antepatol.getHapcartrireuma();
        }
        if (antepatol != null && antepatol.getHapcesclmult() != null) {
            ESCLEROMUL = antepatol.getHapcesclmult();
        }
        if (antepatol != null && antepatol.getHapccancer() != null) {
            CANCER = antepatol.getHapccancer();
        }
        if (antepatol != null && antepatol.getHapcescllatamio() != null) {
            ESCLEROAMIO = antepatol.getHapcescllatamio();
        }
        if (antepatol != null && antepatol.getHapcnefropa() != null) {
            NEFROPATIA = antepatol.getHapcnefropa();
        }
        if (antepatol != null && antepatol.getHapcmigrana() != null) {
            MIGRANA = antepatol.getHapcmigrana();
        }
        if (antepatol != null && antepatol.getHapcfibromi() != null) {
            FIBROMIALGIA = antepatol.getHapcfibromi();
        }
        if (antepatol != null && antepatol.getHapcotra() != null) {
            OTRA = antepatol.getHapcotra();
        }
        if (antepatol != null && antepatol.getHapccual() != null) {
            CUAL = antepatol.getHapccual();
        }

        if (antefarma != null && antefarma.getHafcaines() != null) {
            AINES = antefarma.getHafcaines();
        }
        if (antefarma != null && antefarma.getHafcainecual() != null) {
            CUALAINES = antefarma.getHafcainecual();
        }
        if (antefarma != null && antefarma.getHafcainefrecu() != null) {
            FRECUEAINES = antefarma.getHafcainefrecu();
        }
        if (antefarma != null && antefarma.getHafcantiagre() != null) {
            ANTIA = antefarma.getHafcantiagre();
        }
        if (antefarma != null && antefarma.getHafcaagrecual() != null) {
            ANTIACUAL = antefarma.getHafcaagrecual();
        }
        if (antefarma != null && antefarma.getHafcaagrefrecu() != null) {
            FRECUEANTIA = antefarma.getHafcaagrefrecu();
        }
        if (antefarma != null && antefarma.getHafcanticoag() != null) {
            ANTICOAGULANTE = antefarma.getHafcanticoag();
        }
        if (antefarma != null && antefarma.getHafcacoagcual() != null) {
            ANTICOCUAL = antefarma.getHafcacoagcual();
        }
        if (antefarma != null && antefarma.getHafcacoagfrec() != null) {
            FRECUEANTICOA = antefarma.getHafcacoagfrec();
        }
        if (antefarma != null && antefarma.getHafcaplimedic() != null) {
            APLICAMEDI = antefarma.getHafcaplimedic();
        }
        if (antefarma != null && antefarma.getHafcaplmedcual() != null) {
            CUALMEDI = antefarma.getHafcaplmedcual();
        }
        if (antefarma != null && antefarma.getHafcaplivacu() != null) {
            APLICAVACU = antefarma.getHafcaplivacu();
        }
        if (antefarma != null && antefarma.getHafcapvacucual() != null) {
            CUALVACU = antefarma.getHafcapvacucual();
        }
        if (antefarma != null && antefarma.getHaflapvacudias() != null) {
            DIASVACU = antefarma.getHaflapvacudias().toString();
        }

        FECHALECTURA = new Date();

        if (chlecttuber != null && chlecttuber.getHltcresultado() != null) {
            RESULTADO = chlecttuber.getHltcresultado();
        }
        if (chlecttuber != null && chlecttuber.getHltcobservac() != null) {
            OBSERVACIONES = chlecttuber.getHltcobservac();
        }
        if (chlecttuber != null && chlecttuber.getHltcusunombt() != null) {
            NOMBRETOMA = chlecttuber.getHltcusunombt();
        }
        if (chlecttuber != null && chlecttuber.getHltcusuprofet() != null) {
            Cpprofesio prot = new Cpprofesio();
            prot = 
this.getServiceLocator().getClinicoService().getProfesionalPorCodigo(this.getUsuarioSystem().getCurnprofes(), 
                                                                     this.getUsuarioSystem().getCurnclinic());
            if (null != prot && prot.getCpfntipoespe() != null) {
                PROFESIONTOMA = prot.getCpfntipoespe().toString();
            } else {
                PROFESIONTOMA = "";
            }
        }
        if (chlecttuber != null && chlecttuber.getHltcentilectt() != null) {
            Cpclinica clinicaToma;
            clinicaToma = 
                    this.getServiceLocator().getClinicoService().getClinica(Integer.parseInt(chlecttuber.getHltcentilectt()));
            ENTIDADTOMA = clinicaToma.getCclcnombre();
        }
        if (chlecttuber != null && chlecttuber.getHltcusunombl() != null) {
            NOMBRELECT = chlecttuber.getHltcusunombl();
        }
        if (chlecttuber != null && chlecttuber.getHltcusuprofel() != null) {
            Cpprofesio prol = new Cpprofesio();
            prol = 
this.getServiceLocator().getClinicoService().getProfesionalPorCodigo(this.getUsuarioSystem().getCurnprofes(), 
                                                                     this.getUsuarioSystem().getCurnclinic());

            if (null != prol && prol.getCpfntipoespe() != null) {
                PROFESIONLECT = prol.getCpfntipoespe().toString();
            } else {
                PROFESIONLECT = "";
            }

        }
        if (chlecttuber != null && chlecttuber.getHltcentilectl() != null) {
            Cpclinica clinicaToma;
            clinicaToma = 
                    this.getServiceLocator().getClinicoService().getClinica(Integer.parseInt(chlecttuber.getHltcentilectl()));
            ENTIDADLECT = clinicaToma.getCclcnombre();


        }


    }
    public void resetDatos() {
        HISTORIACLINICA="";
        CLINICA="";
        FECHA=new Date();
        NOMBRECOMPLETO="";
        DOCUMENTO="";
        DESEALLAMAR="";
        SEXO="";
        EDAD="";
        FECHANACIMIENTO=null;
        CIUDAD="";
        EPS="";
        DIRECCION="";
        TELEFONO="";
        OCUPACION="";
        ESTADOCIVIL="";
        RESPONSABLE="";
        PARENTESCORES="";
        TELEFONORES="";
        ACOMPANANTE="";
        PARENTESCOACOM="";
        TELEFONOACOM="";
        FECHAPLICA=null;
        PESO="";
        TALLA="";
        PRESENTATUBER="";
        CUANDOPRESENTA="";
        TRATAMIENTO="";
        CUANTOTIEMPO="";
        CONTACTOTUBER="";
        QUIENCONTACTO="";
        VIVECONEL="";
        TIEMPOCONEL="";
        VIH="";
        DIABETESMELL="";
        ARTRITISREU="";
        ESCLEROMUL="";
        CANCER="";
        ESCLEROAMIO="";
        NEFROPATIA="";
        MIGRANA="";
        FIBROMIALGIA="";
        OTRA="";
        CUAL="";
        AINES="";
        CUALAINES="";
        FRECUEAINES="";
        ANTIA="";
        ANTIACUAL="";
        FRECUEANTIA="";
        ANTICOAGULANTE="";
        ANTICOCUAL="";
        FRECUEANTICOA="";
        APLICAMEDI="";
        CUALMEDI="";
        APLICAVACU="";
        CUALVACU="";
        DIASVACU="";
        FECHALECTURA=null;
        RESULTADO="";
        OBSERVACIONES="";
        NOMBRETOMA="";
        PROFESIONTOMA="";
        ENTIDADTOMA="";
        NOMBRELECT="";
        PROFESIONLECT="";
        ENTIDADLECT="";
    }
    


    public void mostrarBuscadorUsuarios() {
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        selectedIndex = ACTIVAR_BUSCADOR;
        renderBuscador = true;
        generoHistoria = false;
        lstCitologiaUsuario = new ArrayList();

    }
    
    public void consultasTuberculina() throws ModelException {
    
        
        consultaAuxT = (Object[])dtCopiaCitologia.getRowData();
        antecespec = 
                this.getServiceLocator().getClinicoService().getAntecedentesTuberculina(new Long(consultaAuxT[2].toString()));
        antepatol = 
                this.getServiceLocator().getClinicoService().getAntecedentesPatologicosTuberculina(new Long(consultaAuxT[2].toString()));
        antefarma = 
                this.getServiceLocator().getClinicoService().getAntecedentesFarmacologicosTuberculina(new Long(consultaAuxT[2].toString()));
        
        clinAux = this.serviceLocator.getClinicoService().getClinica((this.getUsuarioSystem().getCurnclinic()));
        
        chlecttuber= this.serviceLocator.getClinicoService().getLecturaTuberculina(new Long(consultaAuxT[2].toString()));
    }


    public void consultarCitologiasUsuario() {


        try {
            lstCitologiaUsuario = 
                    this.serviceLocator.getClinicoService().getCopiaTuberculina(numeroUsuario);
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
     * @param lstCitologiaUsuario
     */
    public void setLstCitologiaUsuario(List lstCitologiaUsuario) {
        this.lstCitologiaUsuario = lstCitologiaUsuario;
    }

    /**
     * @return
     */
    public List getLstCitologiaUsuario() {
        return lstCitologiaUsuario;
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


    public String generarCopiaLectura() {
        navigationRule = "";
        Cpusuario u = new Cpusuario();
        try {
            consultasTuberculina();

            usu = 
this.getServiceLocator().getClinicoService().getUsuarioPorOperador((this.getUsuarioSystem().getCurcusuari().toUpperCase()));


            chChlecttuberId.setHltlconsulta(new Long(new Long(consultaAuxT[2].toString())));
            chChlecttuberId.setHltctiposervi("C");
            chlecttuber.setComp_id(chChlecttuberId);
            chlecttuber.setHltdfechlect(new Date());
            chlecttuber.setHltcusuregisl(this.getUsuarioSystem().getCurcusuari());
            chlecttuber.setHltcusunombl(this.getUsuarioSystem().getCurcnombre());
            chlecttuber.setHltcusuprofel(this.getUsuarioSystem().getCurnprofes().toString());
            chlecttuber.setHltcentilectl(this.getUsuarioSystem().getCurnclinic().toString());
            chlecttuber.setHltcusuregist(antecespec.getHaecoperador());
            chlecttuber.setHltcusunombt(usu.getCurcnombre());
            u = 
  this.getServiceLocator().getClinicoService().getUsuarioPorOperador(antecespec.getHaecoperador().toUpperCase());
            chlecttuber.setHltcusuprofet(u.getCurnprofes().toString());
            chlecttuber.setHltcentilectt(usu.getCurnclinic().toString());

           // this.getServiceLocator().getClinicoService().saveLecturaTuberculina(chlecttuber);
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
       
          obtenerDatosReporte(antecespec,antepatol,antefarma ,usu,chlecttuber, clinAux);
      
    }
    
    public void imprimirResumen() {
        this.index = -1;
       
            try {
            
                generoTuberculina=false;
                generarReporte();
                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteTuberculina.jasper");
                URL url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
              
                if (url != null) {
                    Map parameters = new HashMap();
                    parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                    
                    byte[] bytes;

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);
                    bytes = 
                            JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                    PdfServletUtils.showPdfDocument(bytes, 
                                                    "Tuberculina" + ".pdf", 
                                                    false);
                    generoTuberculina=true;
                    navigationRule = nextAction;
            
                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
            
        }
        
    
    }

    public void setHISTORIACLINICA(String hISTORIACLINICA) {
        this.HISTORIACLINICA = hISTORIACLINICA;
    }

    public String getHISTORIACLINICA() {
        return HISTORIACLINICA;
    }

    public void setCLINICA(String cLINICA) {
        this.CLINICA = cLINICA;
    }

    public String getCLINICA() {
        return CLINICA;
    }

    public void setFECHA(Date fECHA) {
        this.FECHA = fECHA;
    }

    public Date getFECHA() {
        return FECHA;
    }

    public void setNOMBRECOMPLETO(String nOMBRECOMPLETO) {
        this.NOMBRECOMPLETO = nOMBRECOMPLETO;
    }

    public String getNOMBRECOMPLETO() {
        return NOMBRECOMPLETO;
    }

    public void setDOCUMENTO(String dOCUMENTO) {
        this.DOCUMENTO = dOCUMENTO;
    }

    public String getDOCUMENTO() {
        return DOCUMENTO;
    }

    public void setDESEALLAMAR(String dESEALLAMAR) {
        this.DESEALLAMAR = dESEALLAMAR;
    }

    public String getDESEALLAMAR() {
        return DESEALLAMAR;
    }

    public void setSEXO(String sEXO) {
        this.SEXO = sEXO;
    }

    public String getSEXO() {
        return SEXO;
    }

    public void setEDAD(String eDAD) {
        this.EDAD = eDAD;
    }

    public String getEDAD() {
        return EDAD;
    }

    public void setFECHANACIMIENTO(Date fECHANACIMIENTO) {
        this.FECHANACIMIENTO = fECHANACIMIENTO;
    }

    public Date getFECHANACIMIENTO() {
        return FECHANACIMIENTO;
    }

    public void setCIUDAD(String cIUDAD) {
        this.CIUDAD = cIUDAD;
    }

    public String getCIUDAD() {
        return CIUDAD;
    }

    public void setEPS(String ePS) {
        this.EPS = ePS;
    }

    public String getEPS() {
        return EPS;
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

    public void setOCUPACION(String oCUPACION) {
        this.OCUPACION = oCUPACION;
    }

    public String getOCUPACION() {
        return OCUPACION;
    }

    public void setESTADOCIVIL(String eSTADOCIVIL) {
        this.ESTADOCIVIL = eSTADOCIVIL;
    }

    public String getESTADOCIVIL() {
        return ESTADOCIVIL;
    }

    public void setRESPONSABLE(String rESPONSABLE) {
        this.RESPONSABLE = rESPONSABLE;
    }

    public String getRESPONSABLE() {
        return RESPONSABLE;
    }

    public void setPARENTESCORES(String pARENTESCORES) {
        this.PARENTESCORES = pARENTESCORES;
    }

    public String getPARENTESCORES() {
        return PARENTESCORES;
    }

    public void setTELEFONORES(String tELEFONORES) {
        this.TELEFONORES = tELEFONORES;
    }

    public String getTELEFONORES() {
        return TELEFONORES;
    }

    public void setACOMPANANTE(String aCOMPANANTE) {
        this.ACOMPANANTE = aCOMPANANTE;
    }

    public String getACOMPANANTE() {
        return ACOMPANANTE;
    }

    public void setPARENTESCOACOM(String pARENTESCOACOM) {
        this.PARENTESCOACOM = pARENTESCOACOM;
    }

    public String getPARENTESCOACOM() {
        return PARENTESCOACOM;
    }

    public void setTELEFONOACOM(String tELEFONOACOM) {
        this.TELEFONOACOM = tELEFONOACOM;
    }

    public String getTELEFONOACOM() {
        return TELEFONOACOM;
    }

    public void setFECHAPLICA(Date fECHAPLICA) {
        this.FECHAPLICA = fECHAPLICA;
    }

    public Date getFECHAPLICA() {
        return FECHAPLICA;
    }

    public void setPESO(String pESO) {
        this.PESO = pESO;
    }

    public String getPESO() {
        return PESO;
    }

    public void setTALLA(String tALLA) {
        this.TALLA = tALLA;
    }

    public String getTALLA() {
        return TALLA;
    }

    public void setPRESENTATUBER(String pRESENTATUBER) {
        this.PRESENTATUBER = pRESENTATUBER;
    }

    public String getPRESENTATUBER() {
        return PRESENTATUBER;
    }

    public void setCUANDOPRESENTA(String cUANDOPRESENTA) {
        this.CUANDOPRESENTA = cUANDOPRESENTA;
    }

    public String getCUANDOPRESENTA() {
        return CUANDOPRESENTA;
    }

    public void setTRATAMIENTO(String tRATAMIENTO) {
        this.TRATAMIENTO = tRATAMIENTO;
    }

    public String getTRATAMIENTO() {
        return TRATAMIENTO;
    }

    public void setCUANTOTIEMPO(String cUANTOTIEMPO) {
        this.CUANTOTIEMPO = cUANTOTIEMPO;
    }

    public String getCUANTOTIEMPO() {
        return CUANTOTIEMPO;
    }

    public void setCONTACTOTUBER(String cONTACTOTUBER) {
        this.CONTACTOTUBER = cONTACTOTUBER;
    }

    public String getCONTACTOTUBER() {
        return CONTACTOTUBER;
    }

    public void setQUIENCONTACTO(String qUIENCONTACTO) {
        this.QUIENCONTACTO = qUIENCONTACTO;
    }

    public String getQUIENCONTACTO() {
        return QUIENCONTACTO;
    }

    public void setVIVECONEL(String vIVECONEL) {
        this.VIVECONEL = vIVECONEL;
    }

    public String getVIVECONEL() {
        return VIVECONEL;
    }

    public void setTIEMPOCONEL(String tIEMPOCONEL) {
        this.TIEMPOCONEL = tIEMPOCONEL;
    }

    public String getTIEMPOCONEL() {
        return TIEMPOCONEL;
    }

    public void setVIH(String vIH) {
        this.VIH = vIH;
    }

    public String getVIH() {
        return VIH;
    }

    public void setDIABETESMELL(String dIABETESMELL) {
        this.DIABETESMELL = dIABETESMELL;
    }

    public String getDIABETESMELL() {
        return DIABETESMELL;
    }

    public void setARTRITISREU(String aRTRITISREU) {
        this.ARTRITISREU = aRTRITISREU;
    }

    public String getARTRITISREU() {
        return ARTRITISREU;
    }

    public void setESCLEROMUL(String eSCLEROMUL) {
        this.ESCLEROMUL = eSCLEROMUL;
    }

    public String getESCLEROMUL() {
        return ESCLEROMUL;
    }

    public void setCANCER(String cANCER) {
        this.CANCER = cANCER;
    }

    public String getCANCER() {
        return CANCER;
    }

    public void setESCLEROAMIO(String eSCLEROAMIO) {
        this.ESCLEROAMIO = eSCLEROAMIO;
    }

    public String getESCLEROAMIO() {
        return ESCLEROAMIO;
    }

    public void setNEFROPATIA(String nEFROPATIA) {
        this.NEFROPATIA = nEFROPATIA;
    }

    public String getNEFROPATIA() {
        return NEFROPATIA;
    }

    public void setMIGRANA(String mIGRANA) {
        this.MIGRANA = mIGRANA;
    }

    public String getMIGRANA() {
        return MIGRANA;
    }

    public void setFIBROMIALGIA(String fIBROMIALGIA) {
        this.FIBROMIALGIA = fIBROMIALGIA;
    }

    public String getFIBROMIALGIA() {
        return FIBROMIALGIA;
    }

    public void setOTRA(String oTRA) {
        this.OTRA = oTRA;
    }

    public String getOTRA() {
        return OTRA;
    }

    public void setCUAL(String cUAL) {
        this.CUAL = cUAL;
    }

    public String getCUAL() {
        return CUAL;
    }

    public void setAINES(String aINES) {
        this.AINES = aINES;
    }

    public String getAINES() {
        return AINES;
    }

    public void setCUALAINES(String cUALAINES) {
        this.CUALAINES = cUALAINES;
    }

    public String getCUALAINES() {
        return CUALAINES;
    }

    public void setFRECUEAINES(String fRECUEAINES) {
        this.FRECUEAINES = fRECUEAINES;
    }

    public String getFRECUEAINES() {
        return FRECUEAINES;
    }

    public void setANTIA(String aNTIA) {
        this.ANTIA = aNTIA;
    }

    public String getANTIA() {
        return ANTIA;
    }

    public void setANTIACUAL(String aNTIACUAL) {
        this.ANTIACUAL = aNTIACUAL;
    }

    public String getANTIACUAL() {
        return ANTIACUAL;
    }

    public void setFRECUEANTIA(String fRECUEANTIA) {
        this.FRECUEANTIA = fRECUEANTIA;
    }

    public String getFRECUEANTIA() {
        return FRECUEANTIA;
    }

    public void setANTICOAGULANTE(String aNTICOAGULANTE) {
        this.ANTICOAGULANTE = aNTICOAGULANTE;
    }

    public String getANTICOAGULANTE() {
        return ANTICOAGULANTE;
    }

    public void setANTICOCUAL(String aNTICOCUAL) {
        this.ANTICOCUAL = aNTICOCUAL;
    }

    public String getANTICOCUAL() {
        return ANTICOCUAL;
    }

    public void setFRECUEANTICOA(String fRECUEANTICOA) {
        this.FRECUEANTICOA = fRECUEANTICOA;
    }

    public String getFRECUEANTICOA() {
        return FRECUEANTICOA;
    }

    public void setAPLICAMEDI(String aPLICAMEDI) {
        this.APLICAMEDI = aPLICAMEDI;
    }

    public String getAPLICAMEDI() {
        return APLICAMEDI;
    }

    public void setCUALMEDI(String cUALMEDI) {
        this.CUALMEDI = cUALMEDI;
    }

    public String getCUALMEDI() {
        return CUALMEDI;
    }

    public void setAPLICAVACU(String aPLICAVACU) {
        this.APLICAVACU = aPLICAVACU;
    }

    public String getAPLICAVACU() {
        return APLICAVACU;
    }

    public void setCUALVACU(String cUALVACU) {
        this.CUALVACU = cUALVACU;
    }

    public String getCUALVACU() {
        return CUALVACU;
    }

    public void setDIASVACU(String dIASVACU) {
        this.DIASVACU = dIASVACU;
    }

    public String getDIASVACU() {
        return DIASVACU;
    }

    public void setFECHALECTURA(Date fECHALECTURA) {
        this.FECHALECTURA = fECHALECTURA;
    }

    public Date getFECHALECTURA() {
        return FECHALECTURA;
    }

    public void setRESULTADO(String rESULTADO) {
        this.RESULTADO = rESULTADO;
    }

    public String getRESULTADO() {
        return RESULTADO;
    }

    public void setOBSERVACIONES(String oBSERVACIONES) {
        this.OBSERVACIONES = oBSERVACIONES;
    }

    public String getOBSERVACIONES() {
        return OBSERVACIONES;
    }

    public void setNOMBRETOMA(String nOMBRETOMA) {
        this.NOMBRETOMA = nOMBRETOMA;
    }

    public String getNOMBRETOMA() {
        return NOMBRETOMA;
    }

    public void setPROFESIONTOMA(String pROFESIONTOMA) {
        this.PROFESIONTOMA = pROFESIONTOMA;
    }

    public String getPROFESIONTOMA() {
        return PROFESIONTOMA;
    }

    public void setENTIDADTOMA(String eNTIDADTOMA) {
        this.ENTIDADTOMA = eNTIDADTOMA;
    }

    public String getENTIDADTOMA() {
        return ENTIDADTOMA;
    }

    public void setNOMBRELECT(String nOMBRELECT) {
        this.NOMBRELECT = nOMBRELECT;
    }

    public String getNOMBRELECT() {
        return NOMBRELECT;
    }

    public void setPROFESIONLECT(String pROFESIONLECT) {
        this.PROFESIONLECT = pROFESIONLECT;
    }

    public String getPROFESIONLECT() {
        return PROFESIONLECT;
    }

    public void setENTIDADLECT(String eNTIDADLECT) {
        this.ENTIDADLECT = eNTIDADLECT;
    }

    public String getENTIDADLECT() {
        return ENTIDADLECT;
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

    public void setGeneroTuberculina(boolean generoTuberculina) {
        this.generoTuberculina = generoTuberculina;
    }

    public boolean isGeneroTuberculina() {
        return generoTuberculina;
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
}
