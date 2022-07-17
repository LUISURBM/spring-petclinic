package org.profamilia.hc.view.backing.clinico.consultorio;


import java.net.URL;

import java.text.SimpleDateFormat;

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

import org.profamilia.hc.model.dto.Chantecespec;
import org.profamilia.hc.model.dto.Chantecfarma;
import org.profamilia.hc.model.dto.Chantecpatol;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chlecttuber;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.dto.Chnotamedica;
import org.profamilia.hc.model.dto.ChnotamedicaPK;
import org.profamilia.hc.model.dto.Chpapsicologico;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosPAPsicologiaBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.menus.consultorio.MenuNotaAclaratoriaBean;
import org.profamilia.hc.view.backing.menus.consultorio.MenuPAPsicologiaBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


public class RegistrarPAPsicologiaBean extends BaseBean implements JRDataSource{

    /** Almacena la descripcion de la nota Medica*/
    private String observacion;

    /** Alamcena la consulta a la cual se le esta haciendo la nota medica */
    private Chconsulta consulta;

    /** Almacena la nota medica a persistir*/
    private Chpapsicologico nota;
    
    /** Almacena el bean de navegacion*/
    private String nextAction;

    private ConsultarFoliosPAPsicologiaBean datosPsicologia;
    
    private MenuPAPsicologiaBean menuNotaAclaratoriaBean;

    
    private boolean notaRealizada;
    protected int index = -1;
    private boolean generoPapsicologia;

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
    protected String AFILACION;
    protected String ASEGURADORA;
    protected Integer EDAD;
    protected String RESPONSABLE;
    protected String TELCONTACTO;
    protected String PARENTESCO;
    protected String OBSERVACION;
    
    private ConsultarFoliosPAPsicologiaBean usuario;
    
    private RegistrarPAPsicologiaBean registrarpapBean;
    

    private static int NUMERO_COPIAS = 1;
    
    /** Alamcena la consulta a la cual se le esta haciendo la nota medica */
    private Cnconsclin consclin;
    
    public RegistrarPAPsicologiaBean() {
    }


    public void init() {
        if (nota == null) {
            nota = new Chpapsicologico();
        } else {
            observacion = nota.getHppcobservacion();
        }
       
        notaRealizada = false;
        nextAction="";
        observacion= "";
        usuario = (ConsultarFoliosPAPsicologiaBean)FacesUtils.getManagedBean("consultarFoliosPAPsicologiaBean");
       }

   
    /**
     * @param consulta
     */
    public void setConsulta(Chconsulta consulta) {
        this.consulta = consulta;
    }

    /**
     * @return
     */
    public Chconsulta getConsulta() {
        return consulta;
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
     * @return
     */
    public void aceptar() {

        if (nota != null) {

            nextAction = "";
            if (null != nota.getHppnconsulta()) {
                if (observacion != null && observacion.length() <= 1000) {
                    nota.setHppcobservacion(observacion);
                    try {
                        this.serviceLocator.getClinicoService().savePAPsicologia(nota, usuario.getUsuario(), consclin);
                        notaRealizada = false;
                        imprimirResumen();
                        nextAction = 
                        BeanNavegacion.RUTA_REGISTRAR_PAPSICOLOGIA;
                        FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                    } catch (ModelException e) {
                        FacesUtils.addErrorMessage(MSG_NO_ADICION);
                        nextAction = BeanNavegacion.RUTA_ACTUAL;
                        e.printStackTrace();
                    }
                }
                else{
                    FacesUtils.addErrorMessage("La cantidad de caracteres se excede, la cantidad son de 1000 caracteres, por favor verifique.");
                    FacesUtils.addErrorMessage(MSG_NO_ADICION);
                    nextAction = BeanNavegacion.RUTA_ACTUAL;
                }
            } else {
                nota.setHppnconsulta(new Long(consclin.getCconnumero()));
                nota.setHppnpaciente(consclin.getCcolusuario().getHuslnumero());
                nota.setHppcusuario(userName());
                nota.setHppdfecreg(new Date());
                if (observacion != null && observacion.length() <= 1000) {
                    nota.setHppcobservacion(observacion);

                    try {
                        this.serviceLocator.getClinicoService().savePAPsicologia(nota, usuario.getUsuario(), consclin);
                        notaRealizada = false;
                        imprimirResumen();
                        nextAction = 
                                BeanNavegacion.RUTA_IR_PRIMEROSAUX_PSICOLOGIA;
                        FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                    } catch (ModelException e) {
                        FacesUtils.addErrorMessage(MSG_NO_ADICION);
                        nextAction = BeanNavegacion.RUTA_ACTUAL;
                        e.printStackTrace();
                    }
                }else{
                    FacesUtils.addErrorMessage("La cantidad de caracteres se excede, la cantidad son de 1000 caracteres, por favor verifique.");
                    FacesUtils.addErrorMessage(MSG_NO_ADICION);
                    nextAction = BeanNavegacion.RUTA_ACTUAL;
                }
            }


        } else {
            FacesUtils.addErrorMessage(MSG_NO_ADICION);
            nextAction = BeanNavegacion.RUTA_ACTUAL;
        }


    }

        public String volverPrincipal(){
            FacesUtils.resetManagedBean("consultarUsuarioPAPsicologiaBean");
            FacesUtils.resetManagedBean("consultarFoliosPAPsicologiaBean");
            FacesUtils.resetManagedBean("registrarPAPsicologiaBean");
            notaRealizada=false;
          
            return BeanNavegacion.RUTA_IR_PRIMEROSAUX_PSICOLOGIA;
            
        }

    public void imprimirResumen() {
        this.index = -1;
       
            try {
            
                generoPapsicologia=false;
                generarReporte();
                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reportePAuxPsicologia.jasper");
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
                                                    "PrimerosAuxiliosPsicologia" + ".pdf", 
                                                    false);
                    notaRealizada = true;
                             
                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
            
        }
        
    
    }
    public void generarReporte() throws ModelException {
       
          obtenerDatosReporte(nota);
      
    }
    public void obtenerDatosReporte(Chpapsicologico nota) throws ModelException {
        // Obtenemos los datos del usuario 
        resetDatos();
        Cpclinica clinAux= new Cpclinica();

        int edadUsu = consclin.getCcolusuario().calcularEdad(consclin.getCcolusuario().getHusdfechanacim());
        clinAux = this.serviceLocator.getClinicoService().getClinica(consclin.getCconclinic());
        String nombre1;
        String nombre2;
        String ape1;
        String ape2;
        FECHA = new Date();
       
        CLINICA = clinAux.getCclcnombre();
        
        
        if (consclin.getCcolusuario() != null && consclin.getCcolusuario().getHuscprimernomb() != null) {
            nombre1 = (consclin.getCcolusuario().getHuscprimernomb() != null) ? consclin.getCcolusuario().getHuscprimernomb() : " ";
            nombre2 = (consclin.getCcolusuario().getHuscsegundnomb() != null) ? consclin.getCcolusuario().getHuscsegundnomb() : " ";
            ape1 = (consclin.getCcolusuario().getHuscprimerapel() != null) ? consclin.getCcolusuario().getHuscprimerapel() : " ";
            ape2 = (consclin.getCcolusuario().getHuscsegundapel() != null) ? consclin.getCcolusuario().getHuscsegundapel() : " ";
    
            NOMBRES = nombre1 +" "+nombre2+" "+ape1+" "+ape2;
                   
        }
        if (consclin.getCcolusuario() != null && consclin.getCcolusuario().getHusetipoiden() != null) {
            IDENTIFICACION =  consclin.getCcolusuario().getHusetipoiden() + " " + consclin.getCcolusuario().getHusanumeiden();
        }
        if (consclin.getCcolusuario() != null && consclin.getCcolusuario().getHuscnombralter() != null) {
            DESEOLLAMAR = consclin.getCcolusuario().getHuscnombralter();
        }
        if (consclin.getCcolusuario() != null && consclin.getCcolusuario().getHusesexo() != null) {
        
            SEXO = formatearCampoSexo(consclin.getCcolusuario().getHusesexo());
        }
        
        if (consclin.getCcolusuario() != null && consclin.getCcolusuario().getHuscidengene() != null) {
        
            GENERO = consclin.getCcolusuario().getHuscidengene();
        }
        if (consclin.getCcolusuario() != null && consclin.getCcolusuario().getHusezonareside() != null) {
        
            ZONA =consclin.getCcolusuario().getHusezonareside();
        }
        
            EDAD = edadUsu;
        
        if (consclin.getCcolusuario() != null && consclin.getCcolusuario().getHusdfechanacim() != null) {
            FECHANTO = consclin.getCcolusuario().getHusdfechanacim();
        }
        if (consclin.getCcolusuario() != null && consclin.getCcolusuario().getHusnciudad() != null) {
        Cpmunidane n= new Cpmunidane();
        n= this.getServiceLocator().getClinicoService().getMunicipio(consclin.getCcolusuario().getHusnciudad(),consclin.getCcolusuario().getHusndepartamen());
            CIUDAD = n.getCmdcnomdpt();
        }
        if (consclin.getCcolusuario() != null && consclin.getCcolusuario().getHuscdireccion() != null) {
            DIRECCION = consclin.getCcolusuario().getHuscdireccion();
        }
        if (consclin.getCcolusuario() != null && consclin.getCcolusuario().getHusctelefono() != null) {
            TELEFONO = consclin.getCcolusuario().getHusctelefono();
        }
        if (consclin.getCcolusuario() != null && consclin.getCcolusuario().getHusnocupacion() != null) {
            OCUPACION = this.getServiceLocator().getClinicoService().getDescripcionOcupacion(consclin.getCcolusuario().getHusnocupacion());
        }
        if (consclin.getCcolusuario() != null && consclin.getCcolusuario().getHuseestadcivil() != null) {
            ESTADOCIVIL = formatearEstadoCivil(consclin.getCcolusuario().getHuseestadcivil());
        }
        if (consclin.getCcolusuario() != null && consclin.getCcolusuario().getHuscnomresponsa() != null) {
            RESPONSABLE = consclin.getCcolusuario().getHuscnomresponsa();
        }
        if (consclin.getCcolusuario() != null && consclin.getCcolusuario().getHusetipoafilia() != null) {
           
            if(consclin.getCcolusuario().getHusetipoafilia().equals("C")){
             AFILACION = "CONTRIBUTIVO";
            }
            if(consclin.getCcolusuario().getHusetipoafilia().equals("S")){
             AFILACION = "SUBSIDIADO";
            }
            if(consclin.getCcolusuario().getHusetipoafilia().equals("E")){
             AFILACION = "ESPECIAL";
            }
            if(consclin.getCcolusuario().getHusetipoafilia().equals("X")){
             AFILACION = "NINGUNO";
            }
            if(consclin.getCcolusuario().getHusetipoafilia().equals("R")){
             AFILACION = "SUBSIDIO PARCIAL";
            }
            if(consclin.getCcolusuario().getHusetipoafilia().equals("V")){
             AFILACION = "VINCULADO";
            }
        }
        if (consclin.getCcolusuario() != null && consclin.getCcolusuario().getHuscentidadadm() != null) {
            ASEGURADORA = consclin.getCcolusuario().getHuscentidadadm();
        }
        if (consclin.getCcolusuario() != null && consclin.getCcolusuario().getHusctelacompana() != null) {
            TELCONTACTO = consclin.getCcolusuario().getHusctelacompana();
        }
        if (consclin.getCcolusuario() != null && consclin.getCcolusuario().getHuscparresponsa() != null) {
            PARENTESCO = consclin.getCcolusuario().getHuscparresponsa();
        }
        if (observacion != null) {
            OBSERVACION =observacion;
        }
    }
    
    public void resetDatos() {
        FECHA=new Date();
        CLINICA="";
        NOMBRES="";
        IDENTIFICACION="";
        FECHANTO=new Date();
        DESEOLLAMAR="";
        SEXO="";
        GENERO="";
        DIRECCION="";
        TELEFONO="";
        CIUDAD="";
        ZONA="";
        ESTADOCIVIL="";
        OCUPACION="";
        AFILACION="";
        ASEGURADORA="";
        EDAD=0;
        RESPONSABLE="";
        TELCONTACTO="";
        PARENTESCO="";
        OBSERVACION="";
    }
    
  
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setNota(Chpapsicologico nota) {
        this.nota = nota;
    }

    public Chpapsicologico getNota() {
        return nota;
    }

    public void setMenuNotaAclaratoriaBean(MenuPAPsicologiaBean menuNotaAclaratoriaBean) {
        this.menuNotaAclaratoriaBean = menuNotaAclaratoriaBean;
    }

    public MenuPAPsicologiaBean getMenuNotaAclaratoriaBean() {
        return menuNotaAclaratoriaBean;
    }

    public void setNotaRealizada(boolean notaRealizada) {
        this.notaRealizada = notaRealizada;
    }

    public boolean isNotaRealizada() {
        return notaRealizada;
    }

    public void setGeneroPapsicologia(boolean generoPapsicologia) {
        this.generoPapsicologia = generoPapsicologia;
    }

    public boolean isGeneroPapsicologia() {
        return generoPapsicologia;
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



    public void setASEGURADORA(String aSEGURADORA) {
        this.ASEGURADORA = aSEGURADORA;
    }

    public String getASEGURADORA() {
        return ASEGURADORA;
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

    /**
     * @return
     */
     public boolean next() {
         index++;
         return (index < NUMERO_COPIAS);
     }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setNUMERO_COPIAS(int nUMERO_COPIAS) {
        this.NUMERO_COPIAS = nUMERO_COPIAS;
    }

    public int getNUMERO_COPIAS() {
        return NUMERO_COPIAS;
    }

    public void setDatosPsicologia(ConsultarFoliosPAPsicologiaBean datosPsicologia) {
        this.datosPsicologia = datosPsicologia;
    }

    public ConsultarFoliosPAPsicologiaBean getDatosPsicologia() {
        return datosPsicologia;
    }

    public void setUsuario(ConsultarFoliosPAPsicologiaBean usuario) {
        this.usuario = usuario;
    }

    public ConsultarFoliosPAPsicologiaBean getUsuario() {
        return usuario;
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
        if (fieldName.equals("AFILACION")) {
            value = AFILACION;
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
        if (fieldName.equals("PARENTESCO")) {
            value = PARENTESCO;
        }
        if (fieldName.equals("OBSERVACION")) {
            value = OBSERVACION;
        }
                
        return value;
    }

    public void setRegistrarpapBean(RegistrarPAPsicologiaBean registrarpapBean) {
        this.registrarpapBean = registrarpapBean;
    }

    public RegistrarPAPsicologiaBean getRegistrarpapBean() {
        return registrarpapBean;
    }

    public void setConsclin(Cnconsclin consclin) {
        this.consclin = consclin;
    }

    public Cnconsclin getConsclin() {
        return consclin;
    }


    public void setAFILACION(String aFILACION) {
        this.AFILACION = aFILACION;
    }

    public String getAFILACION() {
        return AFILACION;
    }

    public void setEDAD(Integer eDAD) {
        this.EDAD = eDAD;
    }

    public Integer getEDAD() {
        return EDAD;
    }
}
