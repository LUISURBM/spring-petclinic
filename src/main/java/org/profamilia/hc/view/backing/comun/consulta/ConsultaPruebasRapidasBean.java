package org.profamilia.hc.view.backing.comun.consulta;


import java.math.BigDecimal;

import java.net.URL;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;


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
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chlecttuber;
import org.profamilia.hc.model.dto.ChlecttuberPK;
import org.profamilia.hc.model.dto.Chpruecovidanticu;
import org.profamilia.hc.model.dto.Chpruecovidantige;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cncitolect;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cncitotoma;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cnprofxcon;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.dto.PruebasRapidasDTO;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorUsuariosBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

public class ConsultaPruebasRapidasBean extends BaseBean implements JRDataSource {


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
    private int index = -1;

    private static int NUMERO_COPIAS = 1;
    
    Chlecttuber chlecttuber = new Chlecttuber();
    private String nextAction;
    
    private List<Chantecespec> listaTomaTuber= new ArrayList<Chantecespec>();
    private Cnconsclin consclin;
    


    private String navigationRule;
    Cpclinica clinAux= new Cpclinica();
    private List<Cnconsclin> lstConsClin;
    
    
    private List listaChconsulta;
    Object[] consultaAuxT;
    private List<Object[]> lstRegistros;
    private List<Object[]> lstPurebasRapidas;
    private List<Object[]> lstPruebasAnticuerpos;
    private List<Object[]> lstPruebasAntigenos;
    
    private List<PruebasRapidasDTO> lstReporte;
    boolean generoReporte;
    private HtmlDataTable dtPruebaRapida;
    private Object[] registro;
    private Cpprofesio profesionalAct;


/*variables reporte antigenos*/
     protected Date FECHA;
     protected String CLINICA;
     protected String NOMBRES;
     protected String DIRECCION;
     protected String TELEFONO;
     protected Integer EDAD;
     protected String NUMEROID;
     protected String ANTIGENOS;
     protected String ANTICUERPOS;
     protected String CONTACTO;
     protected Date FECHASINTOMAS;
     protected String MARCA;
     protected String LOTE;
     protected String INVIMA;
     protected Date FECHAFABRICACION;
     protected Date FECHAVENCIMIENTO;
     protected String RESULTADO;
     protected String TIPOANTIGENO;
     protected String PROFESIONAL;
    private Long historia;
    protected String TENIDO_SINTOMAS;

    public ConsultaPruebasRapidasBean() {
    }


    public void init() {
        generoHistoria = false;
        listSexos = new ArrayList<SelectItem>();
        listEstadoCivil = new ArrayList<SelectItem>();
        listTipoIdentificacion = new ArrayList<SelectItem>();
        lstReporte = new ArrayList<PruebasRapidasDTO>();


        
        
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
        if(historia==58){
            return (index < NUMERO_COPIAS);
        }else if(historia==59){
            return (index < NUMERO_COPIAS);
        }else{
             return (index < lstReporte.size());
        }
    }

  
    
    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();
        if(historia==57){
        Date date = lstReporte.get(index).getFechaRegistro();

        if (fieldName.equals("nombrePrueba")) {        
          value = lstReporte.get(index).getNombrePrueba();
            return value;
        }
       else if (fieldName.equals("marca")) {        
          value = lstReporte.get(index).getMarca();
            return value;
        }
       else if (fieldName.equals("lote")) {        
          value = lstReporte.get(index).getLote();
            return value;
       }
       else if (fieldName.equals("registroInvima")) {        
          value = lstReporte.get(index).getRegistroInvima();
            return value;
        }
      else  if (fieldName.equals("fechaVencimiento")) {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                   Date fechaDate = null;
                   try {
                       fechaDate = formato.parse(lstReporte.get(index).getFechaVencimiento());
          value = fechaDate;
          
            return value;
        } catch (ParseException e) {
                value = lstReporte.get(index).getFechaVencimiento();
                 return value;
            }
      }
            else  if (fieldName.equals("nombrePersona")) {        
            value = lstReporte.get(index).getNombrePersona();
              return value;
          }
        else  if (fieldName.equals("numIdentificacion")) {        
            value = lstReporte.get(index).getNumIdentificacion();
              return value;
          }
        else  if (fieldName.equals("resultado1")) {        
            value = lstReporte.get(index).getResultado1();
              return value;
          }
        else  if (fieldName.equals("resultado2")) {        
            value = lstReporte.get(index).getResultado2();
              return value;
          }
        else  if (fieldName.equals("valorRes1")) {        
            value = lstReporte.get(index).getValorRes1();
              return value;
          }
        else  if (fieldName.equals("valorRes2")) {        
            value = lstReporte.get(index).getValorRes2();
              return value;
          }
        else  if (fieldName.equals("responsable")) {        
            value = lstReporte.get(index).getResponsable();
              return value;
          }
        else  if (fieldName.equals("CLINICA")) {        
            value = getClinica().getCclcnombre();
              return value;
          }
        else  if (fieldName.equals("MM")) {        
                SimpleDateFormat mes = new SimpleDateFormat("MM");
                String mesActual = mes.format(date);
                value = mesActual;
                return value;
          }
        else  if (fieldName.equals("DD")) {        
                SimpleDateFormat dia = new SimpleDateFormat("dd");
                String diaActual = dia.format(date);
                value = diaActual;
                return value;
          }
        else  if (fieldName.equals("YYYY")) {        
                SimpleDateFormat anio = new SimpleDateFormat("yyyy");
                String anioActual = anio.format(date);
                value = anioActual;
                return value;
          }
        }else if(historia==58 ||  historia==59){
                if (fieldName.equals("FECHA")) 
                 value= FECHA;  
                 else if (fieldName.equals("CLINICA")) 
                 value=CLINICA ;  
                 else if (fieldName.equals("NOMBRES")) 
                 value= NOMBRES;  
                 else if (fieldName.equals("DIRECCION")) 
                 value= DIRECCION;  
                 else if (fieldName.equals("TELEFONO")) 
                 value= TELEFONO;  
                 else if (fieldName.equals("EDAD")) 
                 value= EDAD;  
                 else if (fieldName.equals("NUMEROID")) 
                 value= NUMEROID;  
                 else if (fieldName.equals("ANTIGENOS")) 
                 value= ANTIGENOS;  
                 else if (fieldName.equals("ANTICUERPOS")) 
                 value= ANTICUERPOS;  
                 else if (fieldName.equals("CONTACTO")) 
                 value= CONTACTO;  
                 else if (fieldName.equals("FECHASINTOMAS")) 
                 value= FECHASINTOMAS;  
                 else if (fieldName.equals("MARCA")) 
                 value= MARCA;  
                 else if (fieldName.equals("LOTE")) 
                 value= LOTE;  
                 else if (fieldName.equals("INVIMA")) 
                 value= INVIMA;  
                 else if (fieldName.equals("FECHAFABRICACION")) 
                 value= FECHAFABRICACION;  
                 else if (fieldName.equals("FECHAVENCIMIENTO")) 
                 value= FECHAVENCIMIENTO;  
                 else if (fieldName.equals("RESULTADO")) 
                 value= RESULTADO;  
                 else if (fieldName.equals("TIPOANTIGENO")) 
                 value= TIPOANTIGENO;  
                 else if (fieldName.equals("PROFESIONAL")) 
                 value= PROFESIONAL;  
            else if (fieldName.equals("ANTIGENOS")) 
            value= ANTIGENOS;  
            else if(fieldName.equals("TENIDO_SINTOMAS")){
                value = TENIDO_SINTOMAS;
            }
        }
       
    return value;
    }
    public void consultarRegistros() {
        try {
            generoReporte = false;
           
                lstRegistros = 
                        this.serviceLocator.getClinicoService().getPruebasRapidas(numeroUsuario);
            

            if (lstRegistros == null || lstRegistros.isEmpty()) {
                FacesUtils.addErrorMessage("No existen datos");
            }
        } catch (ModelException de) {
            FacesUtils.addErrorMessage(null, de.getMessage());
            de.printStackTrace();

        } catch (Exception e) {
            FacesUtils.addErrorMessage(null, e.getMessage(), MSG_NO_CONSULTA);
        }

    }
    
    public void generarArchivoPdf() throws ModelException {
        lstReporte = new ArrayList<PruebasRapidasDTO>();
        consultarPruebaRapida();
        index = -1;
        generoReporte = false;
        if (lstPurebasRapidas == null || lstPurebasRapidas.isEmpty()) {
            FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
        } else {
            try {
            historia= new Long(lstPurebasRapidas.get(0)[0].toString());
            if(historia==57){
                llenarListaReporte();
                String nombreArchivo = "Reporte_PruebasRapidas";
                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/impresionPruebasRapidas.jasper");
                URL url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);

                if (url != null) {
                    Map parameters = new HashMap();
                    parameters.put("PROFAMILIA_IMAGE",url_profamilia);

                    byte[] bytes;

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);
                    bytes = 
                            JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                    PdfServletUtils.showPdfDocument(bytes, 
                    nombreArchivo + 
                    Calendar.getInstance().getTimeInMillis() + ".pdf", 
                                                    false);
                    generoReporte = true;
                    navigationRule = nextAction;

                }

                }else if(historia==58){
                        this.index = -1;
                            try {
                            generarReporte();
                            URL url = 
                                FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteCovidAnticuerpos.jasper");
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
                                                                "CovidAntigenos" + 
                                                                ".pdf", false);
                                generoReporte = true;
                                navigationRule = nextAction;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                                       e.getMessage());

                        }


                    
            }else if(historia==59){
                this.index = -1;

                try {

                   generarReporteAnticuerpos();
                    URL url = 
                        FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteCovidAnticuerpos.jasper");
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
                                                        "CovidAnticuerpos" + 
                                                        ".pdf", false);
                        generoReporte = true;

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                               e.getMessage());

                }
            
            }
                
            } catch (Exception e) {
                //generoReporte = false;
                e.printStackTrace();
                FacesUtils.addErrorMessage("No se genero el archivo " + 
                                           e.getMessage());
            }
        }
    }
    
    public void generarReporte() throws ModelException {

        Chpruecovidantige covidAntigeno;
        covidAntigeno= serviceLocator.getClinicoService().getpruebaAntigenos(new Long(lstPurebasRapidas.get(0)[6].toString()));
        obtenerDatosReporte(covidAntigeno);

    }
    public void generarReporteAnticuerpos() throws ModelException {

        Chpruecovidanticu covidAnticuerpo;
        covidAnticuerpo= serviceLocator.getClinicoService().getpruebaAnticuerpos(new Long(lstPurebasRapidas.get(0)[6].toString()));
        obtenerDatosReporteAnticuerpos(covidAnticuerpo);

    }

    public void obtenerDatosReporte(Chpruecovidantige covidAntigeno) throws ModelException {
    
        resetDatos();
        Cpclinica clinAux = new Cpclinica();
        consclin =  this.serviceLocator.getClinicoService().getConsultaClinicaPorId(covidAntigeno.getHpgnconsulta().toString());
        int edadUsu =  consclin.getCcolusuario().calcularEdad(consclin.getCcolusuario().getHusdfechanacim());
        clinAux =  this.serviceLocator.getClinicoService().getClinica(consclin.getCconclinic());
        String nombre1;
        String nombre2;
        String ape1;
        String ape2;
        FECHA = covidAntigeno.getHpgdfechreg();
        CLINICA = clinAux.getCclcnombre();
        if (consclin.getCcolusuario() != null && 
            consclin.getCcolusuario().getHuscprimernomb() != null) {
            nombre1 = (consclin.getCcolusuario().getHuscprimernomb() != null) ? consclin.getCcolusuario().getHuscprimernomb() : " ";
            nombre2 = (consclin.getCcolusuario().getHuscsegundnomb() != null) ? consclin.getCcolusuario().getHuscsegundnomb() : " ";
            ape1 = (consclin.getCcolusuario().getHuscprimerapel() != null) ? consclin.getCcolusuario().getHuscprimerapel() : " ";
            ape2 = (consclin.getCcolusuario().getHuscsegundapel() != null) ? consclin.getCcolusuario().getHuscsegundapel() : " ";

            NOMBRES = nombre1 + " " + nombre2 + " " + ape1 + " " + ape2;

        }
        if (consclin.getCcolusuario() != null && 
            consclin.getCcolusuario().getHusetipoiden() != null) {
            NUMEROID = 
                    consclin.getCcolusuario().getHusetipoiden() + " " + consclin.getCcolusuario().getHusanumeiden();
        }

        EDAD = edadUsu;

        if (consclin.getCcolusuario() != null && 
            consclin.getCcolusuario().getHuscdireccion() != null) {
            DIRECCION = consclin.getCcolusuario().getHuscdireccion();
        }
        if (consclin.getCcolusuario() != null && 
            consclin.getCcolusuario().getHusctelefono() != null) {
            TELEFONO = consclin.getCcolusuario().getHusctelefono();
        }
        if (covidAntigeno != null) {

            if (covidAntigeno.getHpgccontadias() != null) {
                CONTACTO = covidAntigeno.getHpgccontadias();
            }
            if (covidAntigeno.getHpgdfecsinto() != null) {
                FECHASINTOMAS = covidAntigeno.getHpgdfecsinto();
            }


            if (covidAntigeno.getHpgcmarca() != null) {
                MARCA = covidAntigeno.getHpgcmarca();
            }
            if (covidAntigeno.getHpgclote() != null) {
                LOTE = covidAntigeno.getHpgclote();
            }
            if (covidAntigeno.getHpgcreginvim() != null) {
                INVIMA = covidAntigeno.getHpgcreginvim();
            }
            if (covidAntigeno.getHpgdfechfabr() != null) {
                FECHAFABRICACION = covidAntigeno.getHpgdfechfabr();
            }
            if (covidAntigeno.getHpgdfechvenci() != null) {
                FECHAVENCIMIENTO = covidAntigeno.getHpgdfechvenci();
            }
            if (covidAntigeno.getHpgcresultado() != null) {
                RESULTADO = covidAntigeno.getHpgcresultado();
            }
            if(covidAntigeno.getHpgcsintopaci()!=null){
                TENIDO_SINTOMAS = covidAntigeno.getHpgcsintopaci();
            }

            if (covidAntigeno.getHpgusuareg() != null) {
                try {
                    profesionalAct =
                        serviceLocator.getClinicoService().getProfesionalPorUsuario(covidAntigeno.getHpgusuareg(),
                                                                                    this.getClinica().getCclncodigo());
                } catch (ModelException e) {
                   e.printStackTrace();
                }
                if(profesionalAct!=null){
                PROFESIONAL = profesionalAct.getCpfcnombre() + " - " + profesionalAct.getCpfcregmedic();
                }
                else{
                    PROFESIONAL="";
                }
            }

            ANTIGENOS = "X";
         }

    }
    
    public void obtenerDatosReporteAnticuerpos(Chpruecovidanticu covidAnticuerpo) throws ModelException {
        // Obtenemos los datos del usuario 
        resetDatos();
        Cpclinica clinAux = new Cpclinica();
         Chconsulta consul= this.serviceLocator.getClinicoService().getConsultaActual(covidAnticuerpo.getHpanconsulta()); 
          consclin= this.serviceLocator.getClinicoService().getConsultaClinicaPorId(covidAnticuerpo.getHpanconsulta().toString());
        int edadUsu = 
        consclin.getCcolusuario().calcularEdad(consclin.getCcolusuario().getHusdfechanacim());
       
        clinAux = 
                this.serviceLocator.getClinicoService().getClinica(consclin.getCconclinic());
        String nombre1;
        String nombre2;
        String ape1;
        String ape2;
        FECHA = covidAnticuerpo.getHpadfechreg();

        CLINICA = clinAux.getCclcnombre();


        if (consclin.getCcolusuario() != null && 
            consclin.getCcolusuario().getHuscprimernomb() != null) {
            nombre1 = 
                    (consclin.getCcolusuario().getHuscprimernomb() != null) ? consclin.getCcolusuario().getHuscprimernomb() : 
                    " ";
            nombre2 = 
                    (consclin.getCcolusuario().getHuscsegundnomb() != null) ? consclin.getCcolusuario().getHuscsegundnomb() : 
                    " ";
            ape1 = 
    (consclin.getCcolusuario().getHuscprimerapel() != null) ? consclin.getCcolusuario().getHuscprimerapel() :
    " ";
            ape2 = 
    (consclin.getCcolusuario().getHuscsegundapel() != null) ? consclin.getCcolusuario().getHuscsegundapel() :
    " ";

            NOMBRES = nombre1 + " " + nombre2 + " " + ape1 + " " + ape2;

        }
        if (consclin.getCcolusuario() != null && 
            consclin.getCcolusuario().getHusetipoiden() != null) {
            NUMEROID = 
                    consclin.getCcolusuario().getHusetipoiden() + " " + consclin.getCcolusuario().getHusanumeiden();
        }

        EDAD = edadUsu;

        if (consclin.getCcolusuario() != null && 
            consclin.getCcolusuario().getHuscdireccion() != null) {
            DIRECCION = consclin.getCcolusuario().getHuscdireccion();
        }
        if (consclin.getCcolusuario() != null && 
            consclin.getCcolusuario().getHusctelefono() != null) {
            TELEFONO = consclin.getCcolusuario().getHusctelefono();
        }
        if (covidAnticuerpo != null) {

            if (covidAnticuerpo.getHpaccontadias() != null) {
                CONTACTO = covidAnticuerpo.getHpaccontadias();
            }
            if (covidAnticuerpo.getHpadfecsinto() != null) {
                FECHASINTOMAS = covidAnticuerpo.getHpadfecsinto();
            }

         
            if (covidAnticuerpo.getHpacmarca() != null) {
                MARCA = covidAnticuerpo.getHpacmarca();
            }
            if (covidAnticuerpo.getHpaclote() != null) {
                LOTE = covidAnticuerpo.getHpaclote();
            }
            if (covidAnticuerpo.getHpacreginvim() != null) {
                INVIMA = covidAnticuerpo.getHpacreginvim();
            }
            if (covidAnticuerpo.getHpadfechfabr() != null) {
                FECHAFABRICACION = covidAnticuerpo.getHpadfechfabr();
            }
            if (covidAnticuerpo.getHpadfechvenci() != null) {
                FECHAVENCIMIENTO = covidAnticuerpo.getHpadfechvenci();
            }
            if (covidAnticuerpo.getHpacresultado() != null) {
                RESULTADO = covidAnticuerpo.getHpacresultado();
            }
            if (covidAnticuerpo.getHpactipoantig() != null) {
                TIPOANTIGENO = covidAnticuerpo.getHpactipoantig();
            }
            if(covidAnticuerpo.getHpacsintopaci()!=null){
                TENIDO_SINTOMAS = covidAnticuerpo.getHpacsintopaci();
            }
            if(covidAnticuerpo.getHpausuareg() != null){
               try {
                        profesionalAct = serviceLocator.getClinicoService().getProfesionalPorUsuario(covidAnticuerpo.getHpausuareg(),
                                                                                        this.getClinica().getCclncodigo());
                    } catch (ModelException e) {
                       e.printStackTrace();
                    }
                    if(profesionalAct!=null){
                    PROFESIONAL = profesionalAct.getCpfcnombre()+ " - " + profesionalAct.getCpfcregmedic();
                    }
                    else{
                        PROFESIONAL="";
                    }
            }
            ANTICUERPOS ="X";

            }
           }


    

    public void resetDatos() {
        FECHA = new Date();
        CLINICA = "";
        NOMBRES = "";
        DIRECCION = "";
        TELEFONO = "";
        EDAD = 0;
        NUMEROID = "";
        ANTIGENOS = "";
        ANTICUERPOS = "";
        CONTACTO = "";
        FECHASINTOMAS = new Date();
        MARCA = "";
        LOTE = "";
        INVIMA = "";
        FECHAFABRICACION = new Date();
        FECHAVENCIMIENTO = new Date();
        RESULTADO = "";
        TIPOANTIGENO = "";
        PROFESIONAL = "";
        TENIDO_SINTOMAS ="";
    }
    
    public void llenarListaReporte(){
        // validar vih
        String primerNombre;
        String primerApellido ;
        String segundoNombre="";
        String segundoApellido = "";
        Object[]o  = lstPurebasRapidas.get(0);
        try {
            Cnprofxcon  profesionalByConsulta =
                  serviceLocator.getClinicoService().getProfesionalByConsulta(new Long(registro[0].toString()));
            if(profesionalByConsulta!=null){      
            profesionalAct =
                serviceLocator.getClinicoService().getProfesionalPorCodigo(profesionalByConsulta.getCpnnprofes(),this.getClinica().getCclncodigo());
            }
        } catch (ModelException e) {
           e.printStackTrace();
        }
        String responsable="";
        if(profesionalAct!=null){
            responsable=profesionalAct.getCpfcnombre();
        }
        if(o[10]!=null){
        PruebasRapidasDTO aux = new PruebasRapidasDTO();
        aux.setNombrePrueba("VIH");
        aux.setResultado1("Reactiva");
        aux.setResultado2("No reactiva");
        aux.setFechaRegistro((Date)o[32]);
        aux.setResponsable(responsable);
        if(o[30]!=null){
            if(o[30].equals("RE")){
                aux.setValorRes1("X");
            }
            else{
                aux.setValorRes2("X");
            }
        }
        if(o[1]!=null){
            aux.setNumIdentificacion(o[1].toString());
        }
        primerNombre = o[2].toString();
        primerApellido = o[3].toString();
        if(o[4]!=null){
            segundoNombre = o[4].toString();
        }
        if(o[5]!=null){
            segundoApellido = o[5].toString();
        }
        aux.setNombrePersona(primerNombre+" "+segundoNombre+" "+primerApellido+" "+segundoApellido);
        aux.setMarca(o[15].toString());
        aux.setLote(o[10].toString());
        aux.setRegistroInvima(o[20].toString());
        aux.setFechaVencimiento(o[25].toString());
        lstReporte.add(aux);
    }
        if(o[9]!=null){
            PruebasRapidasDTO aux = new PruebasRapidasDTO();
            aux.setNombrePrueba("S�FILIS");
            aux.setResultado1("Positiva");
            aux.setResultado2("Negativa");
            aux.setResponsable(responsable);
            aux.setFechaRegistro((Date)o[32]);
            if(o[29]!=null){
                if(o[29].equals("PO")){
                    aux.setValorRes1("X");
                }
                else{
                    aux.setValorRes2("X");
                }
            }
            if(o[1]!=null){
                aux.setNumIdentificacion(o[1].toString());
            }
            primerNombre = o[2].toString();
            primerApellido = o[3].toString();
            if(o[4]!=null){
                segundoNombre = o[4].toString();
            }
            if(o[5]!=null){
                segundoApellido = o[5].toString();
            }
            aux.setNombrePersona(primerNombre+" "+segundoNombre+" "+primerApellido+" "+segundoApellido);
            aux.setMarca(o[14].toString());
            aux.setLote(o[9].toString());
            aux.setRegistroInvima(o[19].toString());
            aux.setFechaVencimiento(o[24].toString());
            lstReporte.add(aux);
        }
        if(o[8]!=null){
            PruebasRapidasDTO aux = new PruebasRapidasDTO();
            aux.setNombrePrueba("EMBARAZO");
            aux.setResultado1("Positiva");
            aux.setResultado2("Negativa");
            aux.setResponsable(responsable);
            aux.setFechaRegistro((Date)o[32]);
            if(o[28]!=null){
                if(o[28].equals("PO")){
                    aux.setValorRes1("X");
                }
                else{
                    aux.setValorRes2("X");
                }
            }
            if(o[1]!=null){
                aux.setNumIdentificacion(o[1].toString());
            }
            primerNombre = o[2].toString();
            primerApellido = o[3].toString();
            if(o[4]!=null){
                segundoNombre = o[4].toString();
            }
            if(o[5]!=null){
                segundoApellido = o[5].toString();
            }
            aux.setNombrePersona(primerNombre+" "+segundoNombre+" "+primerApellido+" "+segundoApellido);
            aux.setMarca(o[13].toString());
            aux.setLote(o[8].toString());
            aux.setRegistroInvima(o[18].toString());
            aux.setFechaVencimiento(o[23].toString());
            lstReporte.add(aux);
        }
        if(o[7]!=null){
            PruebasRapidasDTO aux = new PruebasRapidasDTO();
            aux.setNombrePrueba("HEPATITIS C");
            aux.setResultado1("Reactiva");
            aux.setResultado2("No Reactiva");
            aux.setResponsable(responsable);
            aux.setFechaRegistro((Date)o[32]);
            if(o[27]!=null){
                if(o[27].equals("RE")){
                    aux.setValorRes1("X");
                }
                else{
                    aux.setValorRes2("X");
                }
            }
            if(o[1]!=null){
                aux.setNumIdentificacion(o[1].toString());
            }
            primerNombre = o[2].toString();
            primerApellido = o[3].toString();
            if(o[4]!=null){
                segundoNombre = o[4].toString();
            }
            if(o[5]!=null){
                segundoApellido = o[5].toString();
            }
            aux.setNombrePersona(primerNombre+" "+segundoNombre+" "+primerApellido+" "+segundoApellido);
            aux.setMarca(o[12].toString());
            aux.setLote(o[7].toString());
            aux.setRegistroInvima(o[17].toString());
            aux.setFechaVencimiento(o[22].toString());
            lstReporte.add(aux);
        }
        if(o[6]!=null){
            PruebasRapidasDTO aux = new PruebasRapidasDTO();
            aux.setNombrePrueba("HEPATITIS B");
            aux.setResultado1("Reactiva");
            aux.setResultado2("No reactiva");
            aux.setResponsable(responsable);
            aux.setFechaRegistro((Date)o[32]);
            if(o[26]!=null){
                if(o[26].equals("RE")){
                    aux.setValorRes1("X");
                }
                else{
                    aux.setValorRes2("X");
                }
            }
            if(o[1]!=null){
                aux.setNumIdentificacion(o[1].toString());
            }
            primerNombre = o[2].toString();
            primerApellido = o[3].toString();
            if(o[4]!=null){
                segundoNombre = o[4].toString();
            }
            if(o[5]!=null){
                segundoApellido = o[5].toString();
            }
            aux.setNombrePersona(primerNombre+" "+segundoNombre+" "+primerApellido+" "+segundoApellido);
            aux.setMarca(o[11].toString());
            aux.setLote(o[6].toString());
            aux.setRegistroInvima(o[16].toString());
            aux.setFechaVencimiento(o[21].toString());
            lstReporte.add(aux);
        }
       
       
    }


    public void mostrarBuscadorUsuarios() {
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        selectedIndex = ACTIVAR_BUSCADOR;
        renderBuscador = true;
        generoHistoria = false;
        generoReporte = false;
        lstCitologiaUsuario = new ArrayList();

    }
    
    public void consultarPruebaRapida() throws ModelException {
      
        registro= (Object[])dtPruebaRapida.getRowData();

       try {
       if(new Long(registro[10].toString())==57){//pruebas rapidas
            lstPurebasRapidas =
                this.getServiceLocator().getClinicoService().getPruebasRapidasByConsulta(new Long(registro[0].toString()));
       }else if(new Long(registro[10].toString())==58){//antigenos
        lstPurebasRapidas =
           this.getServiceLocator().getClinicoService().getPruebasAntigenosByConsulta(new Long(registro[0].toString()));
       }else if(new Long(registro[10].toString())==59){//anticuerpos
        lstPurebasRapidas =
        this.getServiceLocator().getClinicoService().getPruebasAnticuerposByConsulta(new Long(registro[0].toString()));
       }
        } catch (ModelException e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage(e.getMessage());
        }
    }
    
   


    public void changeUsuario() {
        lstRegistros = new ArrayList<Object[]>();
        Chusuario usuarioAux = null;
        generoHistoria = false;
        generoReporte = false;
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
        lstRegistros = new ArrayList<Object[]>();
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

    public void setLstRegistros(List<Object[]> lstRegistros) {
        this.lstRegistros = lstRegistros;
    }

    public List<Object[]> getLstRegistros() {
        return lstRegistros;
    }

    public void setLstPurebasRapidas(List<Object[]> lstPurebasRapidas) {
        this.lstPurebasRapidas = lstPurebasRapidas;
    }

    public List<Object[]> getLstPurebasRapidas() {
        return lstPurebasRapidas;
    }

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }

    public void setDtPruebaRapida(HtmlDataTable dtPruebaRapida) {
        this.dtPruebaRapida = dtPruebaRapida;
    }

    public HtmlDataTable getDtPruebaRapida() {
        return dtPruebaRapida;
    }

    public void setRegistro(Object[] registro) {
        this.registro = registro;
    }

    public Object[] getRegistro() {
        return registro;
    }


    public void setLstPruebasAnticuerpos(List<Object[]> lstPruebasAnticuerpos) {
        this.lstPruebasAnticuerpos = lstPruebasAnticuerpos;
    }

    public List<Object[]> getLstPruebasAnticuerpos() {
        return lstPruebasAnticuerpos;
    }

    public void setLstPruebasAntigenos(List<Object[]> lstPruebasAntigenos) {
        this.lstPruebasAntigenos = lstPruebasAntigenos;
    }

    public List<Object[]> getLstPruebasAntigenos() {
        return lstPruebasAntigenos;
    }

    public void setConsclin(Cnconsclin consclin) {
        this.consclin = consclin;
    }

    public Cnconsclin getConsclin() {
        return consclin;
    }

    public void setHistoria(Long historia) {
        this.historia = historia;
    }

    public Long getHistoria() {
        return historia;
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

    public void setEDAD(Integer eDAD) {
        this.EDAD = eDAD;
    }

    public Integer getEDAD() {
        return EDAD;
    }

    public void setNUMEROID(String nUMEROID) {
        this.NUMEROID = nUMEROID;
    }

    public String getNUMEROID() {
        return NUMEROID;
    }

    public void setANTIGENOS(String aNTIGENOS) {
        this.ANTIGENOS = aNTIGENOS;
    }

    public String getANTIGENOS() {
        return ANTIGENOS;
    }

    public void setANTICUERPOS(String aNTICUERPOS) {
        this.ANTICUERPOS = aNTICUERPOS;
    }

    public String getANTICUERPOS() {
        return ANTICUERPOS;
    }

    public void setCONTACTO(String cONTACTO) {
        this.CONTACTO = cONTACTO;
    }

    public String getCONTACTO() {
        return CONTACTO;
    }

    public void setFECHASINTOMAS(Date fECHASINTOMAS) {
        this.FECHASINTOMAS = fECHASINTOMAS;
    }

    public Date getFECHASINTOMAS() {
        return FECHASINTOMAS;
    }

    public void setMARCA(String mARCA) {
        this.MARCA = mARCA;
    }

    public String getMARCA() {
        return MARCA;
    }

    public void setLOTE(String lOTE) {
        this.LOTE = lOTE;
    }

    public String getLOTE() {
        return LOTE;
    }

    public void setINVIMA(String iNVIMA) {
        this.INVIMA = iNVIMA;
    }

    public String getINVIMA() {
        return INVIMA;
    }

    public void setFECHAFABRICACION(Date fECHAFABRICACION) {
        this.FECHAFABRICACION = fECHAFABRICACION;
    }

    public Date getFECHAFABRICACION() {
        return FECHAFABRICACION;
    }

    public void setFECHAVENCIMIENTO(Date fECHAVENCIMIENTO) {
        this.FECHAVENCIMIENTO = fECHAVENCIMIENTO;
    }

    public Date getFECHAVENCIMIENTO() {
        return FECHAVENCIMIENTO;
    }

    public void setRESULTADO(String rESULTADO) {
        this.RESULTADO = rESULTADO;
    }

    public String getRESULTADO() {
        return RESULTADO;
    }

    public void setTIPOANTIGENO(String tIPOANTIGENO) {
        this.TIPOANTIGENO = tIPOANTIGENO;
    }

    public String getTIPOANTIGENO() {
        return TIPOANTIGENO;
    }

    public void setPROFESIONAL(String pROFESIONAL) {
        this.PROFESIONAL = pROFESIONAL;
    }

    public String getPROFESIONAL() {
        return PROFESIONAL;
    }

    public void setNUMERO_COPIAS(int nUMERO_COPIAS) {
        this.NUMERO_COPIAS = nUMERO_COPIAS;
    }

    public int getNUMERO_COPIAS() {
        return NUMERO_COPIAS;
    }

    public void setTENIDO_SINTOMAS(String tENIDO_SINTOMAS) {
        this.TENIDO_SINTOMAS = tENIDO_SINTOMAS;
    }

    public String getTENIDO_SINTOMAS() {
        return TENIDO_SINTOMAS;
    }
}
