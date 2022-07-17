//=======================================================================
// ARCHIVO AplicacionMedicamentoBean.java
// FECHA CREACI�N: 16/12/2015
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a la aplicacion de Medicamentos
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.net.URL;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chpruecovidantige;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;
import org.profamilia.hc.model.dto.Cpprofesio;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================

//=================================================================
//  CLASE AplicacionVacunaCervixBean
//=======================================================================
public class PruebasAntigenosCovidBean extends BaseBean implements JRDataSource {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chusuario usuario;
    private Chpruecovidantige covidAntigeno;

    /** Fecha presente */
    private Date fechaActual;
    private Date fechaSintomas;
    private Date fechaFabricacion;
    private Date fechaVencimiento;
    private String lugarToma;
    private String lugarProc;
    private List lstOpciones;
    private List lstLugarToma;
    private List lstResultado;
    private String resultado;
    private List lstAntigeno;
    private String antigeno;
    private Chusuario numeroUsuario;
    private String nombreProfesional;
    private boolean renderResultado;
    private boolean pruebaRealizada;
    protected int index = -1;
    private static int NUMERO_COPIAS = 1;
    private boolean generoPrueba;
    private Cnconsclin consclin;
    private String banAntigenos;
    private String banantigenos;

    private String nextAction;
    private String menuBean;
    private Long numeroConsulta;
    private String navigationRule;

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
    private boolean sintomas;
    private Double diasSinto;
    private String TENIDO_SINTOMAS;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public PruebasAntigenosCovidBean() {
    }

    public void init() {
        covidAntigeno = new Chpruecovidantige();
        Cpprofesio profesional = null;
        try {
            profesional = 
                    serviceLocator.getClinicoService().getProfesionalPorUsuario(userName(), this.getClinica().getCclncodigo());
        } catch (ModelException e) {
            e.printStackTrace();
        }
        nombreProfesional = "";
        if(profesional !=null){
            nombreProfesional = 
                    profesional.getCpfcnombre() + " - " + profesional.getCpfcregmedic();
        }
       
        pruebaRealizada=false;
        inicalizarAplicacionBean();
        sintomas=false;
    }
    //ACTIONS

    public void inicalizarAplicacionBean() {
        consclin= new Cnconsclin();
        pruebaRealizada=false;


            try {
                covidAntigeno=  this.getServiceLocator().getClinicoService().getpruebaAntigenos(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (covidAntigeno == null && numeroConsulta != null) {
                covidAntigeno = new Chpruecovidantige();
            }
            changeSintomasPaciente();
        
    }

    //-----------------------------------------------------------------------------------------------
    //  Bot�n Principal
    //------------------------------------------------------------------------------------------------ 

    public String guardar() {
        navigationRule = "";


        if (numeroConsulta != null) {

            covidAntigeno.setHpgnconsulta(numeroConsulta);
            covidAntigeno.setHpgdfechreg(new Date());
            covidAntigeno.setHpgusuareg(userName());
            covidAntigeno.setHpgnnumepaci(numeroUsuario.getHuslnumero());
            covidAntigeno.setHpgcmarca("STANDAR Q COVID 19 SD BIOSENSOR INC.");
            covidAntigeno.setHpgcreginvim("INVIMA 2020RD-0006130");
            
        }


        try {
     
                this.serviceLocator.getClinicoService().saveAntigenosCovid(covidAntigeno);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                 FacesUtils.resetManagedBean(menuBean);
                 navigationRule = nextAction;

        } catch (ModelException e) {
            e.printStackTrace();
            navigationRule = "";
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
        }


        return navigationRule;
    }
    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaci�n fue ingresada correctamente en la base de datos
    //------------------------------------------------------------------------------------------------


    public boolean esValido() {
        Long numero;
        numero = null;
        Chpruecovidantige pruebaCovid = null;

        if (numeroConsulta != null) {
            numero = numeroConsulta;
        }

        if (numero != null) {
            try {
                 pruebaCovid=  this.getServiceLocator().getClinicoService().getpruebaAntigenos(numero);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (pruebaCovid != null) {
            return true;
        }

        return false;
    }


    public void changeResultado() {

        renderResultado = false;
        if (covidAntigeno != null) {
            if (covidAntigeno.getHpgcresultado() != null && 
                covidAntigeno.getHpgcresultado().equals("P")) {
                renderResultado = true;
            } else {
                renderResultado = false;
              
            }
        }
        
    }


    //-----------------------------------------------------------------------
    //  Accesorios
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
     * @param nextAction
     */
    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    /**
     * @return
     */
    public String getNextAction() {
        return nextAction;
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


    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    public List getLstOpciones() {
        if (lstOpciones == null || lstOpciones.isEmpty()) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));

        }
        return lstOpciones;
    }


    public void setcovidAntigeno(Chpruecovidantige covidAntigeno) {
        this.covidAntigeno = covidAntigeno;
    }

    public Chpruecovidantige getcovidAntigeno() {
        return covidAntigeno;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(ValueChangeEvent valueChangeEvent) {
        setFechaActual((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setLugarToma(String lugarToma) {
        this.lugarToma = lugarToma;
    }

    public String getLugarToma() {
        return lugarToma;
    }

    /**
     * @param valueChangeEvent
     */
    public void setLugarToma(ValueChangeEvent valueChangeEvent) {
        covidAntigeno.setHpgclugatoma((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setLugarProc(ValueChangeEvent valueChangeEvent) {
        covidAntigeno.setHpgclugaproc((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setLstLugarToma(List lstLugarToma) {
        this.lstLugarToma = lstLugarToma;
    }

    public List getLstLugarToma() {
        if (lstLugarToma == null || lstLugarToma.isEmpty()) {
            lstLugarToma = new ArrayList();
            lstLugarToma.add(new SelectItem("", "Seleccione.."));
            lstLugarToma.add(new SelectItem("CL", "Clinica"));
            lstLugarToma.add(new SelectItem("BE", "Brigada Extramural"));
            lstLugarToma.add(new SelectItem("DP", "Domicilio Paciente"));

        }
        return lstLugarToma;
    }

    public void setLstResultado(List lstResultado) {
        this.lstResultado = lstResultado;
    }

    public List getLstResultado() {
        if (lstResultado == null || lstResultado.isEmpty()) {
            lstResultado = new ArrayList();
            lstResultado.add(new SelectItem("", "Seleccione.."));
            lstResultado.add(new SelectItem("P", "Positivo"));
            lstResultado.add(new SelectItem("N", "Negativo"));
            lstResultado.add(new SelectItem("I", "Inv�lido"));

        }
        return lstResultado;
    }

    /**
     * @param valueChangeEvent
     */
    public void setResultado(ValueChangeEvent valueChangeEvent) {
        covidAntigeno.setHpgcresultado((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setLstAntigeno(List lstAntigeno) {
        this.lstAntigeno = lstAntigeno;
    }

    public List getLstAntigeno() {
        if (lstAntigeno == null || lstAntigeno.isEmpty()) {
            lstAntigeno = new ArrayList();
            lstAntigeno.add(new SelectItem("", "Seleccione.."));
            lstAntigeno.add(new SelectItem("IgG", "IgG"));
            lstAntigeno.add(new SelectItem("IgM", "IgM"));

        }
        return lstAntigeno;
    }

    public void setAntigeno(String antigeno) {
        this.antigeno = antigeno;
    }

    public String getAntigeno() {
        return antigeno;
    }

     
    public void setFechaSintomas(Date fechaSintomas) {
        this.fechaSintomas = fechaSintomas;
    }

    public Date getFechaSintomas() {
        return fechaSintomas;
    }

    public void setFechaSintomas(ValueChangeEvent valueChangeEvent) {
        covidAntigeno.setHpgdfecsinto((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setFechaFabricacion(Date fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public Date getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(ValueChangeEvent valueChangeEvent) {
        covidAntigeno.setHpgdfechfabr((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(ValueChangeEvent valueChangeEvent) {
        covidAntigeno.setHpgdfechvenci((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setNombreProfesional(String nombreProfesional) {
        this.nombreProfesional = nombreProfesional;
    }

    public String getNombreProfesional() {
        return nombreProfesional;
    }

    public void setRenderResultado(boolean renderResultado) {
        this.renderResultado = renderResultado;
    }

    public boolean isRenderResultado() {
        return renderResultado;
    }

    /**
     * @return
     */
    public boolean next() {
        index++;
        return (index < NUMERO_COPIAS);
    }

    public void imprimirResumen() {
        this.index = -1;

        try {

            generoPrueba = false;
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
                pruebaRealizada = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());

        }


    }

    public void generarReporte() throws ModelException {

        obtenerDatosReporte(covidAntigeno);

    }

    public void obtenerDatosReporte(Chpruecovidantige covidAntigeno) throws ModelException {
        // Obtenemos los datos del usuario 
        resetDatos();
        Cpclinica clinAux = new Cpclinica();
         Chconsulta consul= this.serviceLocator.getClinicoService().getConsultaActual(covidAntigeno.getHpgnconsulta()); 
          consclin= this.serviceLocator.getClinicoService().getConsultaClinicaPorId(covidAntigeno.getHpgnconsulta().toString());
        int edadUsu = 
        consclin.getCcolusuario().calcularEdad(consclin.getCcolusuario().getHusdfechanacim());
       
        clinAux = 
                this.serviceLocator.getClinicoService().getClinica(consclin.getCconclinic());
        String nombre1;
        String nombre2;
        String ape1;
        String ape2;
        FECHA = new Date();

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
           
            if(covidAntigeno.getHpgusuareg() != null){
            PROFESIONAL= nombreProfesional;
            }
            if(covidAntigeno.getHpgcsintopaci() != null){
                TENIDO_SINTOMAS= covidAntigeno.getHpgcsintopaci();
            }
            
                ANTIGENOS ="X";
            
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
        TENIDO_SINTOMAS="";
    }

    public void setPruebaRealizada(boolean pruebaRealizada) {
        this.pruebaRealizada = pruebaRealizada;
    }

    public boolean isPruebaRealizada() {
        return pruebaRealizada;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setGeneroPrueba(boolean generoPrueba) {
        this.generoPrueba = generoPrueba;
    }

    public boolean isGeneroPrueba() {
        return generoPrueba;
    }

    public void setConsclin(Cnconsclin consclin) {
        this.consclin = consclin;
    }

    public Cnconsclin getConsclin() {
        return consclin;
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

    public void setNUMEROID(String nUMEROID) {
        this.NUMEROID = nUMEROID;
    }

    public String getNUMEROID() {
        return NUMEROID;
    }


    public void setBanAntigenos(String banAntigenos) {
        this.banAntigenos = banAntigenos;
    }

    public String getBanAntigenos() {
        return banAntigenos;
    }

    public void setBanantigenos(String banantigenos) {
        this.banantigenos = banantigenos;
    }

    public String getBanantigenos() {
        return banantigenos;
    }

    public void setNumeroUsuario(Chusuario numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    public Chusuario getNumeroUsuario() {
        return numeroUsuario;
    }

    public Object getFieldValue(JRField jrField){
        Object value = null;

        String fieldName = jrField.getName();
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
        else if (fieldName.equals("TENIDO_SINTOMAS")) 
        value= TENIDO_SINTOMAS; 
             

        return value;
        
    }

    public void setLugarProc(String lugarProc) {
        this.lugarProc = lugarProc;
    }

    public String getLugarProc() {
        return lugarProc;
    }

    public String cerrarAntigenos() throws ModelException {
            imprimirResumen();
          if (consclin != null) {
       
            try {
                this.serviceLocator.getClinicoService().closeProcedimiento(consclin, 
                                                                           userName());
            } catch (ModelException e) {
                e.printStackTrace();
                return null;
            }

              FacesUtils.resetManagedBean("listaUsuariosBean");
            return BeanNavegacion.RUTA_USUARIOS_COVD_ANTIGENOS;
        }
        return BeanNavegacion.RUTA_ACTUAL;
        }
        
    
        public void setHpgcsintopaci(ValueChangeEvent valueChangeEvent) {
            covidAntigeno.setHpgcsintopaci((String)valueChangeEvent.getNewValue());
            ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public void changeSintomasPaciente() {
        sintomas = false;
        if (covidAntigeno != null) {
            if (null != covidAntigeno.getHpgcsintopaci()) {
                if (("S").equals(covidAntigeno.getHpgcsintopaci())) {
                    sintomas = true;
                } else {
                    sintomas = false;
                    covidAntigeno.setHpgdfecsinto(null);
                    covidAntigeno.setHpgccontadias(null);

                }
            }
        }
    }

    public void setSintomas(boolean sintomas) {
        this.sintomas = sintomas;
    }

    public boolean isSintomas() {
        return sintomas;
    }
    
    public void changeFechaSintomas() {
        if (covidAntigeno.getHpgdfecsinto() != null) {
        
            diasSinto = 
                    calcularDiasEmbarazo(covidAntigeno.getHpgdfecsinto());
            int d= diasSinto.intValue();
            covidAntigeno.setHpgnnumesinto(d);
            
        }
    }

    public void setDiasSinto(Double diasSinto) {
        this.diasSinto = diasSinto;
    }

    public Double getDiasSinto() {
        return diasSinto;
    }

    public void setTENIDO_SINTOMAS(String tENIDO_SINTOMAS) {
        this.TENIDO_SINTOMAS = tENIDO_SINTOMAS;
    }

    public String getTENIDO_SINTOMAS() {
        return TENIDO_SINTOMAS;
    }
}


