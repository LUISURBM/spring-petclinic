 //======================================================================================================================
// ARCHIVO LecturaVPHBean
// FECHA CREACI�N: 
// AUTOR: jariano, nlis
// Descripcion: 
//======================================================================================================================
package org.profamilia.hc.view.backing.procedimiento;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.OutputStream;

import java.math.BigDecimal;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRField;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Cfadmision;
import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chcorreo;
import org.profamilia.hc.model.dto.Chreporte;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cncitotoma;
import org.profamilia.hc.model.dto.Cncitovphlect;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cndesccito;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpcontrato;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptipodocu;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.webService.ConsultaEpicenterResult;
import org.profamilia.hc.view.backing.webService.TomaVphWS;
import org.profamilia.hc.view.backing.webService.saludTotal.dto.response.ResultadosLCResponse;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.AlertaEmail;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.ModuleConfig;
import org.profamilia.hc.view.util.PdfServletUtils;


//======================================================================================================================
//  BIBLIOTECAS REQUERIDAS
//======================================================================================================================
//======================================================================================================================
//  CLASE LecturaVPHBean
//======================================================================================================================
public class LecturaVphBean extends BaseBean implements JRDataSource {

    //------------------------------------------------------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //------------------------------------------------------------------------------------------------------------------
    private Cncitovphlect lectura;

    private List lstPrimeraLectura;

    private boolean mostrarEpiteliales;

    private boolean mostrarGenotipificacion;

    private boolean renderLectura;

    private Cnconsclin consulta;
    
    private List lstConducta;
    
    private Cncitologi citologia;
    
    private TomaVphWS resultadoVphWS;
    
    private List<ConsultaEpicenterResult> listconsultaEpicenterResult;
    
    private Cncitotoma toma;
    
    private int index = -1;
    
    private boolean generoLectura;
    
    private String nombreArchivo;
    
    private static int NUMERO_COPIAS = 1;
    
    StringBuffer sbuffer;
    StringBuffer sbErrorres;
    
    JasperPrint jasperPrint;

    
    //Variables VPH
     String APELLIDOS;
     String NOMBRES;
     Long NUMERO_DOCUMENTO;
     String TIPO_DOCUMENTO;
     String DIRECCION;
     String TELEFONO;
     String CIUDAD;
     String DEPARTAMENTO;
     Integer EDAD;
     String CENTRO;
     String ASEGURADORA;
     Integer NUMERO_TIPIFICACION;
     String HVLCGT16;
     String HVLCGT18;
     String HVLCGT31;
     String HVLCGT45;
     String HVLCGT51;
     String HVLCGT52;
     String HVLCGT3858;
     String HVLCGT353968;
     String HVLCGT565966;
     String LECTURA_NOMBRRE_PROFESIONAL;
     String LECTURA_TARJETA_PROFESIONAL;
     String CONDUCTA;
     String DIA_LECTURA;
     String MES_LECTURA;
     String ANO_LECTURA;
     String DIA_TOMADA;
     String MES_TOMADA;
     String ANO_TOMADA;
     String DIA_RECEP;
     String MES_RECEP;
     String ANO_RECEP;
     String INTERPRETACION;
     String GENOTIPIFICACION;
     
    private String detectable;
    
    

    //------------------------------------------------------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //------------------------------------------------------------------------------------------------------------------
    public LecturaVphBean() {

    }

    public void init() {
        sbuffer = new StringBuffer();
        sbErrorres = new StringBuffer();
        mostrarGenotipificacion = false;
        lstPrimeraLectura = new ArrayList();
        lstConducta = new ArrayList();
        generoLectura = false;
        jasperPrint=null;
      
        
        try {
            if (citologia != null) {
                //citologia = this.serviceLocator.getClinicoService().getUsuarioCitologia(consulta);  
                toma = serviceLocator.getClinicoService().getTomaCitologia(citologia.getCcinconsec());        
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (lectura == null) {
            lectura = new Cncitovphlect();
        } else {
            if (lectura.getCcvcgenoneg() != null && lectura.getCcvcgenoneg().equals("N")) {
                mostrarGenotipificacion = true;
            } else {
                mostrarGenotipificacion = false;
            }
        }
        
        if (citologia != null) {
            try {
                resultadoVphWS = new TomaVphWS();
                listconsultaEpicenterResult = 
                        resultadoVphWS.consultaTomaVph(citologia);  
            if(listconsultaEpicenterResult != null && !listconsultaEpicenterResult.isEmpty()){
                for (ConsultaEpicenterResult resultado: listconsultaEpicenterResult) {
                    if (resultado.getCodigoRespuesta() == 0) {
                    if(resultado.getVPH()!= null && resultado.getVPH().equals("Positivo")){
                        lectura.setCcvcgenoneg("N");
                        mostrarGenotipificacion = true;
                        if(resultado.getVPH16()!= null && resultado.getVPH16().equals("Positivo")){
                            lectura.setCcvcgt16("S");
                        }else if(resultado.getVPH16()!= null && resultado.getVPH16().equals("Negativo")){
                            lectura.setCcvcgt16("N");
                        }
                        
                        if(resultado.getVPH18()!= null && resultado.getVPH18().equals("Positivo")){
                            lectura.setCcvcgt18("S");
                        }else if(resultado.getVPH18()!= null && resultado.getVPH18().equals("Negativo")){
                            lectura.setCcvcgt18("N");
                        }                        
                        
                        if(resultado.getVPH31()!= null && resultado.getVPH31().equals("Positivo")){
                            lectura.setCcvcgt31("S");
                        }else if(resultado.getVPH31()!= null && resultado.getVPH31().equals("Negativo")){
                            lectura.setCcvcgt31("N");
                        }                        
                        
                        if(resultado.getVPH45()!= null && resultado.getVPH45().equals("Positivo")){
                            lectura.setCcvcgt45("S");
                        }else if(resultado.getVPH45()!= null && resultado.getVPH45().equals("Negativo")){
                            lectura.setCcvcgt45("N");
                        }                        
                        
                        if(resultado.getVPH51()!= null && resultado.getVPH51().equals("Positivo")){
                            lectura.setCcvcgt51("S");
                        }else if(resultado.getVPH51()!= null && resultado.getVPH51().equals("Negativo")){
                            lectura.setCcvcgt51("N");
                        }                        
                        
                        if(resultado.getVPH52()!= null && resultado.getVPH52().equals("Positivo")){
                            lectura.setCcvcgt52("S");
                        }else if(resultado.getVPH52()!= null && resultado.getVPH52().equals("Negativo")){
                            lectura.setCcvcgt52("N");
                        }                      
                        
                        if(resultado.getVPH33_58()!= null && resultado.getVPH33_58().equals("Positivo")){
                            lectura.setCcvcgt3858("S");
                        }else if(resultado.getVPH33_58()!= null && resultado.getVPH33_58().equals("Negativo")){
                            lectura.setCcvcgt3858("N");
                        }                        
                        
                        if(resultado.getVPH35_39_68()!= null && resultado.getVPH35_39_68().equals("Positivo")){
                            lectura.setCcvcgt353968("S");
                        }else if(resultado.getVPH35_39_68()!= null && resultado.getVPH35_39_68().equals("Negativo")){
                            lectura.setCcvcgt353968("N");
                        }                        
                        
                        if(resultado.getVPH56_59_66()!= null && resultado.getVPH56_59_66().equals("Positivo")){
                            lectura.setCcvcgt565966("S");
                        }else if(resultado.getVPH56_59_66()!= null && resultado.getVPH56_59_66().equals("Negativo")){
                            lectura.setCcvcgt565966("N");
                        }
                        changeAdicionDetectable();
                        
                    }else if(resultado.getVPH()!= null && resultado.getVPH().equals("Negativo")){
                        lectura.setCcvcgenoneg("S");
                        mostrarGenotipificacion = true;
                        lectura.setCcvcgt16("N");
                        lectura.setCcvcgt18("N");
                        lectura.setCcvcgt31("N");
                        lectura.setCcvcgt45("N");
                        lectura.setCcvcgt51("N");
                        lectura.setCcvcgt52("N");
                        lectura.setCcvcgt3858("N");
                        lectura.setCcvcgt353968("N");
                        lectura.setCcvcgt565966("N");
                        lectura.setCcvcinterpre("No se detectaron Genotipos para VPH");
                    }
                  }
                }
             }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

    //------------------------------------------------------------------------------------------------------------------
    //  Get/Set
    //------------------------------------------------------------------------------------------------------------------
    /**
     * @param lectura
     */
    public void setLectura(Cncitovphlect lectura) {
        this.lectura = lectura;
    }

    /**
     * @return
     */
    public Cncitovphlect getLectura() {
        return lectura;
    }

   

    public List getLstConducta() {
        if (lstConducta.size() == 0) {
            ArrayList<Cndesccito> lstAux = null;
            try {
                lstAux
                        = (ArrayList<Cndesccito>) this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("chlibrovph",
                                "ctmcvphcond");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstAux.isEmpty()) {
                Iterator it = lstAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstConducta.add(new SelectItem((lstAux.get(i).getCdicvalor()),
                            lstAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstConducta;
    }

    public void setLstConducta(List lstConducta) {
        this.lstConducta = lstConducta;
    }
    


    
    public boolean isMostrarGenotipificacion() {
        return mostrarGenotipificacion;
    }

    public void setMostrarGenotipificacion(boolean mostrarGenotipificacion) {
        this.mostrarGenotipificacion = mostrarGenotipificacion;
    }

    /**
     * @param renderLectura
     */
    public void setRenderLectura(boolean renderLectura) {
        this.renderLectura = renderLectura;
    }

    /**
     * @return
     */
    public boolean isRenderLectura() {
        return renderLectura;
    }

    /**
     * @param valueChangeEvent
     */
    public void setCcvcgenoneg(ValueChangeEvent valueChangeEvent) {
        lectura.setCcvcgenoneg((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void setCcvcgt16(ValueChangeEvent valueChangeEvent) {
        lectura.setCcvcgt16((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void setCcvcgt18(ValueChangeEvent valueChangeEvent) {
        lectura.setCcvcgt18((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void setCcvcgt31(ValueChangeEvent valueChangeEvent) {
        lectura.setCcvcgt31((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void setCcvcgt45(ValueChangeEvent valueChangeEvent) {
        lectura.setCcvcgt45((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void setCcvcgt51(ValueChangeEvent valueChangeEvent) {
        lectura.setCcvcgt51((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void setCcvcgt52(ValueChangeEvent valueChangeEvent) {
        lectura.setCcvcgt52((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void setCcvcgt3858(ValueChangeEvent valueChangeEvent) {
        lectura.setCcvcgt3858((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void setCcvcgt353968(ValueChangeEvent valueChangeEvent) {
        lectura.setCcvcgt353968((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void setCcvcgt565966(ValueChangeEvent valueChangeEvent) {
        lectura.setCcvcgt565966((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param mostrarEpiteliales
     */
    public void setMostrarEpiteliales(boolean mostrarEpiteliales) {
        this.mostrarEpiteliales = mostrarEpiteliales;
    }

    /**
     * @return
     */
    public boolean isMostrarEpiteliales() {
        return mostrarEpiteliales;
    }

    /**
     * @param lstPrimeraLectura
     */
    public void setLstPrimeraLectura(List lstPrimeraLectura) {
        this.lstPrimeraLectura = lstPrimeraLectura;
    }

    /**
     * @return
     */
    public List getLstPrimeraLectura() {
        if (lstPrimeraLectura.size() == 0) {
            ArrayList<Cndesccito> lstLecturaAux = null;
            try {
                lstLecturaAux
                        = (ArrayList<Cndesccito>) this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitolect",
                                "clccprilec");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstLecturaAux.isEmpty()) {

                lstPrimeraLectura.add(new SelectItem("",
                        "Seleccione una opcion ..."));
                Iterator it = lstLecturaAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstPrimeraLectura.add(new SelectItem((lstLecturaAux.get(i).getCdicvalor()),
                            lstLecturaAux.get(i).getCdicvalor()
                            + "  "
                            + lstLecturaAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstPrimeraLectura;
    }

    //------------------------------------------------------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //------------------------------------------------------------------------------------------------------------------
    // ValueChangeEvent
    public void changeGenotipificacion() {
        detectable="Se detectaron los Genotipos ";
        if (lectura.getCcvcgenoneg() != null
                && lectura.getCcvcgenoneg().equals("N")) {
            mostrarGenotipificacion = true;
            lectura.setCcvcgt16("N");
            lectura.setCcvcgt18("N");
            lectura.setCcvcgt31("N");
            lectura.setCcvcgt45("N");
            lectura.setCcvcgt51("N");
            lectura.setCcvcgt52("N");
            lectura.setCcvcgt3858("N");
            lectura.setCcvcgt353968("N");
            lectura.setCcvcgt565966("N");
            lectura.setCcvcinterpre(detectable);
        } else if (lectura.getCcvcgenoneg() != null
                && lectura.getCcvcgenoneg().equals("S")) {
            mostrarGenotipificacion = false;
            lectura.setCcvcgt16("N");
            lectura.setCcvcgt18("N");
            lectura.setCcvcgt31("N");
            lectura.setCcvcgt45("N");
            lectura.setCcvcgt51("N");
            lectura.setCcvcgt52("N");
            
            lectura.setCcvcgt3858("N");
            lectura.setCcvcgt353968("N");
            lectura.setCcvcgt565966("N");
            lectura.setCcvcinterpre("No se detectaron Genotipos para VPH");
        }else if (lectura.getCcvcgenoneg() != null
                && lectura.getCcvcgenoneg().equals("NS")) {
        
            mostrarGenotipificacion = false;
            lectura.setCcvcgt16(null);
            lectura.setCcvcgt18(null);
            lectura.setCcvcgt31(null);
            lectura.setCcvcgt45(null);
            lectura.setCcvcgt51(null);
            lectura.setCcvcgt52(null);
            
            lectura.setCcvcgt3858(null);
            lectura.setCcvcgt353968(null);
            lectura.setCcvcgt565966(null);
            lectura.setCcvcinterpre(null);
        
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //  Boton Principal 
    //------------------------------------------------------------------------------------------------------------------

    /**
     * @return
     */
    public Boolean validacion() {
        boolean wexito = true;

        String genoPos = "";

        if (lectura != null && citologia!= null) {
            lectura.setCcvdfeclec(new Date());
            lectura.setCcvdfecreg(new Date());
            lectura.setCcvcusureg(userName());
            lectura.setCcvnconsec(citologia.getCcinconsec());
            lectura.setCcvnclinic(this.getClinica().getCclncodigo());
            lectura.setCcvnnumero(citologia.getCcinnumero());
            
            
            if (userName() != null) {
                Cpprofesio profesional;
                profesional = null;
                try {
                    if (this.getClinica() != null) {
                        profesional = serviceLocator.getClinicoService().getProfesionalPorUsuario(userName(),
                                        getClinica().getCclncodigo());
                    }

                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (profesional != null && profesional.getCpfntippro() != null) {
                    int tipoProf = profesional.getCpfntippro();
                    switch (tipoProf) {//Codigos seg�n Cptipoespe
                        case 15: //BACTERIOLOGO
                            lectura.setCcvclectur("15");
                            break;
                        default:
                        lectura.setCcvclectur("15");  //REMOVER ESTA LINEA
                        sbErrorres.append("La lectura se debe realizar por un Bacteri�logo.");
                    }
                }

                if (lectura.getCcvclectur() == null) {
                    lectura.setCcvclectur("15");
                    //wexito = false;
                    sbErrorres.append("La lectura se debe realizar por un Bacteri�logo.");
                }
                
                if (lectura.getCcvcgenoneg() == null) {
                    lectura.setCcvcgenoneg("S");
                }
                if ("N".equals(lectura.getCcvcgenoneg())) {
                    if ("N".equals(lectura.getCcvcgt16()) && "N".equals(lectura.getCcvcgt18())
                        && "N".equals(lectura.getCcvcgt31()) && "N".equals(lectura.getCcvcgt45())
                        && "N".equals(lectura.getCcvcgt51()) && "N".equals(lectura.getCcvcgt52())
                        && "N".equals(lectura.getCcvcgt3858()) && "N".equals(lectura.getCcvcgt353968())
                        && "N".equals(lectura.getCcvcgt565966())
                        ) {
                            wexito = false;
                            if (sbErrorres.toString().length() > 0) {
                                sbErrorres.append(", ");
                            }
                            sbErrorres.append("Si el Resultado de la Genotipificaci�n es positivo, al menos una opci�n debe ser positiva.");
                        }
                }
            }
            lectura.setCcvcnomlec(getUsuarioSystem().getCurcnombre());
            

        } else {
            wexito = false;
        }
     return wexito;
    }
    
    public String aceptar() {
    if(lectura.getCcvdfecrecep()==null){
        sbErrorres.append("");
        FacesUtils.addErrorMessage("No se ha registrado la Fecha de Recepcion de la Toma, por favor ingrese una fecha.");
        return "";
    } else {
        boolean wexito = validacion();
        Cptipodocu tipodocu = new Cptipodocu();
        Cpservicio servicio = new Cpservicio();
        Cfadmision admision = new Cfadmision();
        String nomContrato = "";
        if (wexito) {
           try {
                Cfdetafactura detafactura = new Cfdetafactura();
                detafactura = this.serviceLocator.getClinicoService().validacionServicioEntregaResultado(consulta.getCconnumero());
                admision = this.serviceLocator.getClinicoService().getAdmision(consulta.getCconnumdoc().longValue());
                nomContrato = admision.getCancontra().toString() + " " + 
                    this.serviceLocator.getCirugiaService().getNombreContrato(admision.getCancontra().toString()); 
                if("N".equals(lectura.getCcvcgenoneg()) && detafactura != null && detafactura.getCdfnconsuclin() == null){
                    tipodocu = this.serviceLocator.getCirugiaService().getTipoDocuPorId(100);
                    servicio = this.serviceLocator.getClinicoService().getServicioPorId(detafactura.getCdfcservicio());

                    Cnconsclin consclin = new Cnconsclin();
                    consclin.setCconclinic(admision.getCanclinic().intValue());
                    consclin.setCconsalesp(0);
                    consclin.setCconconsul(0);
                    consclin.setCcontconcl(servicio.getCsvntipcon());
                    consclin.setCcodfecreg(new Date());
                    consclin.setCconhistor(0);
                    consclin.setCcoctipide(admision.getCactipide());
                    consclin.setCcoanumide(new BigDecimal(admision.getCannumide()));
                    consclin.setCcocprinom(consulta.getCcolusuario().getHuscprimernomb());
                    consclin.setCcocsegnom(consulta.getCcolusuario().getHuscsegundnomb());
                    consclin.setCcocpriape(consulta.getCcolusuario().getHuscprimerapel());
                    consclin.setCcocsegape(consulta.getCcolusuario().getHuscsegundapel());
                    consclin.setCconclidoc(admision.getCanclinic().intValue());
                    consclin.setCcontipdoc(tipodocu);
                    consclin.setCconnumdoc(new BigDecimal(admision.getCannumero()));
                    consclin.setCconprogra(admision.getCanprogra().intValue());
                    consclin.setCconcontra(admision.getCancontra().intValue());
                    consclin.setCcocservic(servicio);
                    consclin.setCconcantid(detafactura.getCdfncantidad().intValue());
                    consclin.setCcoavalser(new BigDecimal(detafactura.getCdfnvalsrv()));
                    consclin.setCcodfecreg(new Date());
                    consclin.setCcodfeccon(admision.getCadfecreg());
                    consclin.setCcothorcon(new Date());
                    consclin.setCcocusureg(getUsuarioSystem().getCurcusuari());
                    consclin.setCcocetapa(IConstantes.CEN_SALA);
                    consclin.setCcothorate(new Date());
                    consclin.setCcocusumod(" ");
                    consclin.setCcocestado(IConstantes.ESTADO_VIGENTE);
                    consclin.setCcondonant(new BigDecimal(admision.getCandonante()));
                    consclin.setCcocgenero(consulta.getCcolusuario().getHusesexo());
                    consclin.setCcolusuario(consulta.getCcolusuario());
                    consclin.setCcocintext(admision.getCacintext());
                    consclin = this.serviceLocator.getClinicoService().generarConsultaClinica(consclin);
                        
                    if(consclin!= null && consclin.getCconnumero() != null){
                        detafactura.setCdfnconsuclin(consclin.getCconnumero().longValue());
                        this.serviceLocator.getClinicoService().saveDetalleFactura(detafactura);
                    }        
                }
                this.serviceLocator.getClinicoService().saveLecturaVph(lectura,consulta,userName(),null);
                if(citologia!=null){
                    List <Chcorreo>lstCorreo = new ArrayList<Chcorreo>();
                    lstCorreo= this.serviceLocator.getClinicoService().getCorreosByParam(citologia.getCcinnumdoc().longValue());
                    if(lstCorreo !=null && !lstCorreo.isEmpty()){
                        guardarPDF(citologia);
                        AlertaEmail email = new AlertaEmail();
                        for ( int i = 0;i<lstCorreo.size();i++){
                            email.sendCorreosParametrizados(citologia,lstCorreo.get(i).getHcccorreo(),nomContrato,nombreArchivo);
                        }
                    }
                }
                //this.serviceLocator.getClinicoService().closeLecturaVph(consulta);
                    /* if (consulta != null && consulta.getCconcontra() != null && (consulta.getCconcontra().equals(IConstantes.NUM_CONTRATO_SALUDTOTAL1) || consulta.getCconcontra().equals(IConstantes.NUM_CONTRATO_SALUDTOTAL2))) {
                 ResultadosLCResponse resultadosLCResponse = new ResultadosLCResponse();
                 resultadosLCResponse = this.serviceLocator.getClinicoService().envioResultadosVphSaludTotal(consulta.getCcolusuario(),consulta,lectura);
                     if (resultadosLCResponse.getData().getError().equals("0")) {
                         FacesUtils.addInfoMessage(IMsg.MSG_ADICION + 
                                                   "Respuesta WS: " + 
                                                   resultadosLCResponse.getNotification().getMessage() + 
                                                   " Estado: " + 
                                                   resultadosLCResponse.getNotification().getStatus());
                     } else {
                         FacesUtils.addInfoMessage(IMsg.MSG_ADICION + 
                                                   "Respuesta WS:" + "Error: " + 
                                                   resultadosLCResponse.getData().getError() + 
                                                   " " + "Descripcion:  " + 
                                                   resultadosLCResponse.getData().getDescripcion() + 
                                                   " " + "Resultado LC: " + 
                                                   resultadosLCResponse.getData().getResultadoLC());
                     }
                 }*/
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                FacesUtils.resetManagedBean("lecturaVphBean");
                FacesUtils.resetManagedBean("consultarFoliosVphBean");
                FacesUtils.resetManagedBean("consultarUsuarioBean");
                jasperPrint = null;
                return BeanNavegacion.RUTA_IR_INICIO;
            } catch (Exception e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                e.printStackTrace();
                return BeanNavegacion.RUTA_ACTUAL;
            }
        }
        if (sbErrorres.toString().length() > 0) {
            FacesUtils.addErrorMessage(sbErrorres.toString());
        }
         
        return BeanNavegacion.RUTA_ACTUAL;
    }
    }
    
    
    public String preVisualizarLectura() {
        boolean wexito = validacion();

        if (wexito) {
          try {
                visualizarConsulta();
            } catch (Exception e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                e.printStackTrace();
                return BeanNavegacion.RUTA_ACTUAL;
            }
        } 
        return BeanNavegacion.RUTA_ACTUAL;
    }
    
    public void obtenerDatosReporteVPH() {

        if (citologia != null) {
            if (citologia.getCcinconsec() != null) {
                NUMERO_TIPIFICACION = citologia.getCcinconsec();
            }

            if (citologia.getCcicprinom() != null) {
                NOMBRES = citologia.getCcicprinom() + " ";
            }
            if (citologia.getCcicsegnom() != null && 
                !citologia.getCcicsegnom().equals("_")) {
                NOMBRES = NOMBRES + citologia.getCcicsegnom();
            }
            if (citologia.getCcicpriape() != null) {
                APELLIDOS = citologia.getCcicpriape() + " ";
            }
            if (citologia.getCcicsegape() != null && 
                !citologia.getCcicsegape().equals("_")) {
                APELLIDOS = APELLIDOS + citologia.getCcicsegape();
            }
            if (citologia.getCcictipide() != null) {
                TIPO_DOCUMENTO = citologia.getCcictipide();
            }
            if (citologia.getCcianumide() != 0) {
                NUMERO_DOCUMENTO = citologia.getCcianumide();
            }
            if (citologia.getCcictelefo() != null) {
                TELEFONO = citologia.getCcictelefo();
            }
            Integer idCiudad = null;
            Integer idDepartamento = null;
            Cpmunidane ciudadObject = null;
            if (citologia.getCcinmunici() != null && 
                citologia.getCcindepart() != null) {
                idCiudad = citologia.getCcinmunici();
                idDepartamento = citologia.getCcindepart();
            }


            try {
                ciudadObject = 
                        this.serviceLocator.getClinicoService().getMunicipio(idCiudad, 
                                                                             idDepartamento);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (ciudadObject != null) {
                CIUDAD = ciudadObject.getCmdcnommun();
                DEPARTAMENTO = ciudadObject.getCmdcnomdpt();
            }
            if (citologia.getCcicasegur() != null) {
                Cpentidadadm aseguradoraAux;
                aseguradoraAux = null;

                try {
                    aseguradoraAux = 
                            serviceLocator.getClinicoService().getAseguradoraPorCodigo(citologia.getCcicasegur());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (ASEGURADORA != null && aseguradoraAux != null ) {
                    ASEGURADORA = aseguradoraAux.getCeacnombre();
                }
            }
            if (citologia.getCcinedad() != null) {
                EDAD = citologia.getCcinedad();
            }
        }


        if (toma != null) {    
            if (toma.getCtmdfecreg() != null) {
            
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(toma.getCtmdfecreg());
                Integer diareg = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mesreg = calendar.get(Calendar.MONTH) + 1;
                Integer anoreg = calendar.get(calendar.YEAR);

                if (diareg.compareTo(10) < 0) {
                    DIA_TOMADA = "0" + diareg.toString();
                } else {
                    DIA_TOMADA = diareg.toString();
                }

                if (mesreg.compareTo(10) < 0) {
                    MES_TOMADA = "0" + mesreg.toString();
                } else {
                    MES_TOMADA = mesreg.toString();
                }

                ANO_TOMADA = anoreg.toString();
            }
            
            if (toma.getCtmnclinic() != null) {
                try {
                    Cpclinica clinica = 
                        this.serviceLocator.getClinicoService().getClinica(toma.getCtmnclinic());
                    CENTRO = clinica.getCclcnombre();
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
        }

        if (lectura != null) {
            if(lectura.getCcvcusureg() != null){
                try {
                    Cpprofesio profesional = this.serviceLocator.getClinicoService().getProfesionalPorUsuario(lectura.getCcvcusureg(),lectura.getCcvnclinic());
                    LECTURA_TARJETA_PROFESIONAL = profesional.getCpfcregmedic();
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
            if (lectura.getCcvcgenoneg() != null) {
                GENOTIPIFICACION = lectura.getCcvcgenoneg();
            } 
            
            if (lectura.getCcvcgt16() != null) {
                HVLCGT16 = lectura.getCcvcgt16();
            }
            if (lectura.getCcvcgt18() != null) {
                HVLCGT18 = lectura.getCcvcgt18();
            }
            if (lectura.getCcvcgt31() != null) {
                HVLCGT31 = lectura.getCcvcgt31();
            }
            if (lectura.getCcvcgt45() != null) {
                HVLCGT45 = lectura.getCcvcgt45();
            }
            if (lectura.getCcvcgt51() != null) {
                HVLCGT51 = lectura.getCcvcgt51();
            }
            if (lectura.getCcvcgt52() != null) {
                HVLCGT52 = lectura.getCcvcgt52();
            }
            if (lectura.getCcvcgt3858() != null) {
                HVLCGT3858 = lectura.getCcvcgt3858();
            }
            if (lectura.getCcvcgt353968() != null) {
                HVLCGT353968 = lectura.getCcvcgt353968();
            }
            if (lectura.getCcvcgt565966() != null) {
                HVLCGT565966 = lectura.getCcvcgt565966();
            }
            
            if(lectura.getCcvcnomlec()!= null){
                LECTURA_NOMBRRE_PROFESIONAL=lectura.getCcvcnomlec();
            }

            if (lectura.getCcvdfeclec() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(lectura.getCcvdfeclec());
                Integer dialec1 = calendar.get(Calendar.DAY_OF_MONTH);
                Integer meslec1 = calendar.get(Calendar.MONTH) + 1;
                Integer anolec1 = calendar.get(calendar.YEAR);

                if (dialec1.compareTo(10) < 0) {
                    DIA_LECTURA = "0" + dialec1.toString();
                } else {
                    DIA_LECTURA = dialec1.toString();
                }

                if (meslec1.compareTo(10) < 0) {
                    MES_LECTURA = "0" + meslec1.toString();
                } else {
                    MES_LECTURA = meslec1.toString();
                }

                ANO_LECTURA = anolec1.toString();
            }
            if (lectura.getCcvdfecrecep() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(lectura.getCcvdfecrecep());
                Integer dialec1 = calendar.get(Calendar.DAY_OF_MONTH);
                Integer meslec1 = calendar.get(Calendar.MONTH) + 1;
                Integer anolec1 = calendar.get(calendar.YEAR);

                if (dialec1.compareTo(10) < 0) {
                    DIA_RECEP= "0" + dialec1.toString();
                } else {
                    DIA_RECEP = dialec1.toString();
                }

                if (meslec1.compareTo(10) < 0) {
                    MES_RECEP = "0" + meslec1.toString();
                } else {
                    MES_RECEP = meslec1.toString();
                }

                ANO_RECEP = anolec1.toString();
            }
            
            if(lectura.getCcvcinterpre() != null){
                INTERPRETACION =lectura.getCcvcinterpre();
            }
        }
    }
    
  /* public void generarCopiaLectura() {
        
        index = -1;
        clearFormularioVphLectura();

        try {
        
        if(lectura != null && lectura.getCcvnconsec()!=null){
            obtenerDatosReporteVPH();
            
            URL url = null;
            URL url_profamilia = null;
            URL url_firma = null;

            url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/EntregaTipificacionVPH FO_GS_AD-022.jasper");
            url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_NEW);
                if (lectura.getCcvcusureg().equals("cl01dasg")) {
                    url_firma = 
                            FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_FIRMA_DIANA_SALCEDO);
                } else {
                    url_firma = 
                            FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_FIRMA_KAREN_MARROQUIN);
                }

            URL url_super_horizontal = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
            URL url_super_vertical = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);

            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                parameters.put("IMAGE_FIRMA", url_firma);
                byte[] bytes;

                JasperReport report = (JasperReport)JRLoader.loadObject(url);

                bytes = 
                        JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                PdfServletUtils.showPdfDocument(bytes, 
                                                "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);
                                                
                generoLectura = true;                                

            }
            }else{
                generoLectura = false;
                FacesUtils.addErrorMessage("No existe Lectura");
            }

        } catch (Exception e) {
            generoLectura = false;
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }

    }
*/
    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("NUMERO_TIPIFICACION")) {
            value = NUMERO_TIPIFICACION;
        } else if (fieldName.equals("CENTRO")) {
            value = CENTRO;
        } else if (fieldName.equals("APELLIDOS")) {
            value = APELLIDOS;
        } else if (fieldName.equals("NOMBRES")) {
            value = NOMBRES;
        } else if (fieldName.equals("TIPO_DOCUMENTO")) {
            value = TIPO_DOCUMENTO;
        } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = NUMERO_DOCUMENTO;
        } else if (fieldName.equals("EDAD")) {
            value = EDAD;
        } else if (fieldName.equals("ASEGURADORA")) {
            value = ASEGURADORA;
        } else if (fieldName.equals("TELEFONO")) {
            value = TELEFONO;
        } else if (fieldName.equals("CIUDAD")) {
            value = CIUDAD;
        } else if (fieldName.equals("DEPARTAMENTO")) {
            value = DEPARTAMENTO;
        } else if (fieldName.equals("HVLCGT16")) {
            value = HVLCGT16;
        } else if (fieldName.equals("HVLCGT18")) {
            value = HVLCGT18;
        } else if (fieldName.equals("HVLCGT31")) {
            value = HVLCGT31;
        } else if (fieldName.equals("HVLCGT45")) {
            value = HVLCGT45;
        } else if (fieldName.equals("HVLCGT51")) {
            value = HVLCGT51;
        } else if (fieldName.equals("HVLCGT52")) {
            value = HVLCGT52;
        } else if (fieldName.equals("HVLCGT3858")) {
            value = HVLCGT3858;
        } else if (fieldName.equals("HVLCGT353968")) {
            value = HVLCGT353968;
        } else if (fieldName.equals("HVLCGT565966")) {
            value = HVLCGT565966;
        } else if (fieldName.equals("LECTURA_NOMBRRE_PROFESIONAL")) {
            value = LECTURA_NOMBRRE_PROFESIONAL;
        } else if (fieldName.equals("LECTURA_TARJETA_PROFESIONAL")) {
            value = LECTURA_TARJETA_PROFESIONAL;
        } else if (fieldName.equals("CONDUCTA")) {
            value = CONDUCTA;
        } else if (fieldName.equals("DIA_TOMADA")) {
            value = DIA_TOMADA;
        } else if (fieldName.equals("MES_TOMADA")) {
            value = MES_TOMADA;
        } else if (fieldName.equals("ANO_TOMADA")) {
            value = ANO_TOMADA;
        } else if (fieldName.equals("DIA_LECTURA")) {
            value = DIA_LECTURA;
        } else if (fieldName.equals("MES_LECTURA")) {
            value = MES_LECTURA;
        } else if (fieldName.equals("ANO_LECTURA")) {
            value = ANO_LECTURA;
        } else if (fieldName.equals("DIA_RECEP_TOMA")) {
            value = DIA_RECEP;
        } else if (fieldName.equals("MES_RECEP_TOMA")) {
            value = MES_RECEP;
        } else if (fieldName.equals("ANO_RECEP_TOMA")) {
            value = ANO_RECEP;
        } else if (fieldName.equals("INTERPRETACION")) {
            value = INTERPRETACION;
        }else if (fieldName.equals("GENOTIPIFICACION")) {
                value = GENOTIPIFICACION;  
        }

        return value;
    }
    
    public void clearFormularioVphLectura() {
        APELLIDOS = "";
        NOMBRES = "";
        NUMERO_DOCUMENTO = 0L;
        TIPO_DOCUMENTO = "";
        DIRECCION = "";
        TELEFONO = "";
        CIUDAD = "";
        DEPARTAMENTO = "";
        EDAD = 0;
        CENTRO = "";
        ASEGURADORA = "";
        NUMERO_TIPIFICACION = null;
        CENTRO = "";
        HVLCGT16 = "";
        HVLCGT18 = "";
        HVLCGT31 = "";
        HVLCGT45 = "";
        HVLCGT51 = "";
        HVLCGT52 = "";
        HVLCGT3858 = "";
        HVLCGT353968 = "";
        HVLCGT565966 = "";
        LECTURA_NOMBRRE_PROFESIONAL = "";
        LECTURA_TARJETA_PROFESIONAL = "";
        CONDUCTA = "";
        DIA_LECTURA = "";
        MES_LECTURA = "";
        ANO_LECTURA = "";
        DIA_TOMADA = "";
        MES_TOMADA = "";
        ANO_TOMADA = "";
        DIA_RECEP = "";
        MES_RECEP = "";
        ANO_RECEP = "";
        ASEGURADORA = "";
        APELLIDOS = "";
        NOMBRES = "";
        NUMERO_DOCUMENTO = null;
        TIPO_DOCUMENTO = "";
        DIRECCION = "";
        TELEFONO = "";
        CIUDAD = "";
        DEPARTAMENTO = "";
        EDAD = null;
        CENTRO = "";
        ASEGURADORA = "";
        INTERPRETACION = "";
        GENOTIPIFICACION = "";
    }
    
    public boolean next() {
        index++;
        return (index < NUMERO_COPIAS);
    }
    
    
    public void visualizarConsulta() {

        JasperPrint jasperPrint;
        jasperPrint = null;
        this.index = -1;
        
        clearFormularioVphLectura();

        try {
        
            if(lectura != null && lectura.getCcvnconsec()!=null){
                obtenerDatosReporteVPH(); 
            
            URL url = null;
            URL url_profamilia = null;
            URL url_firma = null;
            if("NS".equals(lectura.getCcvcgenoneg())){
                    url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/EntregaTipificacionVPH_NS_FO_GS_AD-022.jasper");
            }else{
                url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/EntregaTipificacionVPH FO_GS_AD-022.jasper");
            }
            url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_NEW);
                if (lectura.getCcvcusureg().equals("cl01dasg")) {
                    url_firma = 
                            FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_FIRMA_DIANA_SALCEDO);
                } else if (lectura.getCcvcusureg().equals("cl01lkmm")) {
                    url_firma = 
                            FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_FIRMA_KAREN_MARROQUIN);
                }else if (lectura.getCcvcusureg().equals("cl01lahm")) {
                    url_firma = 
                            FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_FIRMA_LAURA_HERRERA);
                }else if (lectura.getCcvcusureg().equals("cl01ksmg")) {
                    url_firma = 
                            FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_FIRMA_KAREN_MEDINA);
                }

            URL url_super_horizontal = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
            URL url_super_vertical = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);

            ExternalContext externalContext = 
                FacesContext.getCurrentInstance().getExternalContext();
            HttpServletRequest request = 
                (HttpServletRequest)externalContext.getRequest();

            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                parameters.put("IMAGE_FIRMA", url_firma);
                
                JRHtmlExporter exporter = new JRHtmlExporter();

                JasperReport report = (JasperReport)JRLoader.loadObject(url);
                jasperPrint = 
                        JasperFillManager.fillReport(report, parameters, (JRDataSource)this);
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, 
                                      jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_STRING_BUFFER, 
                                      sbuffer);
                exporter.setParameter(JRHtmlExporterParameter.IMAGES_MAP, 
                                      parameters);
                exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, 
                                      request.getContextPath() + 
                                      "/comun/imagenes?image=");
                exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, 
                                      Boolean.FALSE);
                exporter.setParameter(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, 
                                      Boolean.TRUE);
                exporter.setParameter(JRHtmlExporterParameter.CHARACTER_ENCODING, 
                                      "ISO-8859-9");
                exporter.setParameter(JRHtmlExporterParameter.HTML_FOOTER, "");
                exporter.setParameter(JRHtmlExporterParameter.HTML_HEADER, "");
                request.getSession().setAttribute("jasperPrint", jasperPrint);
                
                generoLectura =true;
            }            
            
            }else{
                generoLectura = false;
                FacesUtils.addErrorMessage("No existe Lectura");
            }
        } catch (Exception e) {
            generoLectura =false;
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
    }
    
    
    public void changeAdicionDetectable() {

        if (lectura != null && lectura.getCcvcgt16() != null) {
            detectable = "Se detectaron los Genotipos ";
            if (lectura.getCcvcgt16().equals("S")) {
                detectable = detectable + "16 ,";
                lectura.setCcvcinterpre(detectable);
            } else {
                if (lectura.getCcvcinterpre() != null && lectura.getCcvcinterpre().contains("16 ,")) {
                    detectable = "Se detectaron los Genotipos ";
                    lectura.setCcvcinterpre(detectable);
                }
            }
        }

        if (lectura != null && lectura.getCcvcgt18() != null) {
            if (lectura.getCcvcgt18().equals("S")) {
                detectable = detectable + "18 ,";
                lectura.setCcvcinterpre(detectable);
            } else {
                if (lectura.getCcvcinterpre() != null && lectura.getCcvcinterpre().contains("18 ,")) {
                    detectable = "Se detectaron los Genotipos ";
                    lectura.setCcvcinterpre(detectable);
                }
            }

        }
        if (lectura != null && lectura.getCcvcgt31() != null) {
            if (lectura.getCcvcgt31().equals("S")) {
                detectable = detectable + "31 ,";
                lectura.setCcvcinterpre(detectable);
            } else {
                if (lectura.getCcvcinterpre() != null && lectura.getCcvcinterpre().contains("31 ,")) {
                    detectable = "Se detectaron los Genotipos ";
                    lectura.setCcvcinterpre(detectable);
                }
            }

        }
        if (lectura != null && lectura.getCcvcgt45() != null) {
            if (lectura.getCcvcgt45().equals("S")) {
                detectable = detectable + "45 ,";
                lectura.setCcvcinterpre(detectable);
            } else {
                if (lectura.getCcvcinterpre() != null && lectura.getCcvcinterpre().contains("45 ,")) {
                    detectable = "Se detectaron los Genotipos ";
                    lectura.setCcvcinterpre(detectable);
                }
            }

        }
        if (lectura != null && lectura.getCcvcgt51() != null) {
            if (lectura.getCcvcgt51().equals("S")) {
                detectable = detectable + "51 ,";
                lectura.setCcvcinterpre(detectable);
            } else {
                if (lectura.getCcvcinterpre() != null && lectura.getCcvcinterpre().contains("51 ,")) {
                    detectable = "Se detectaron los Genotipos ";
                    lectura.setCcvcinterpre(detectable);
                }
            }

        }
        if (lectura != null && lectura.getCcvcgt52() != null) {
            if (lectura.getCcvcgt52().equals("S")) {
                detectable = detectable + "52 ,";
                lectura.setCcvcinterpre(detectable);
            } else {
                if (lectura.getCcvcinterpre() != null && lectura.getCcvcinterpre().contains("52 ,")) {
                    detectable = "Se detectaron los Genotipos ";
                    lectura.setCcvcinterpre(detectable);
                }
            }

        }
        if (lectura != null && lectura.getCcvcgt3858() != null) {
            if (lectura.getCcvcgt3858().equals("S")) {
                detectable = detectable + "Grupo1(33,58) ,";
                lectura.setCcvcinterpre(detectable);
            } else {
                if (lectura.getCcvcinterpre() != null && lectura.getCcvcinterpre().contains("Grupo1(33,58) ,")) {
                    detectable = "Se detectaron los Genotipos ";
                    lectura.setCcvcinterpre(detectable);
                }
            }

        }
        if (lectura != null && lectura.getCcvcgt565966() != null) {
            if (lectura.getCcvcgt565966().equals("S")) {
                detectable = detectable + "Grupo 2(56,59,66) ,";
                lectura.setCcvcinterpre(detectable);
            } else {
                if (lectura.getCcvcinterpre() != null && lectura.getCcvcinterpre().contains("Grupo 2(56,59,66) ,")) {
                    detectable = "Se detectaron los Genotipos ";
                    lectura.setCcvcinterpre(detectable);
                }
            }

        }
        if (lectura != null && lectura.getCcvcgt353968() != null) {
            if (lectura.getCcvcgt353968().equals("S")) {
                detectable = detectable + "Grupo 3(35,39,68) ,";
                lectura.setCcvcinterpre(detectable);
            } else {
                if (lectura.getCcvcinterpre() != null && lectura.getCcvcinterpre().contains("Grupo 3(35,39,68) ,")) {
                    detectable = "Se detectaron los Genotipos ";
                    lectura.setCcvcinterpre(detectable);
                }
            }

        }
    }
    
    public void guardarPDF(Cncitologi citologia) {

        JasperPrint jasperPrint;
        jasperPrint = null;
        this.index = -1;
        
        clearFormularioVphLectura();

        try {
        
            if(lectura != null && lectura.getCcvnconsec()!=null){
                obtenerDatosReporteVPH(); 
            
            URL url = null;
            URL url_profamilia = null;
            URL url_firma = null;
            if("NS".equals(lectura.getCcvcgenoneg())){
                    url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/EntregaTipificacionVPH_NS_FO_GS_AD-022.jasper");
            }else{
                url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/EntregaTipificacionVPH FO_GS_AD-022.jasper");
            }
            url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_NEW);
                if (lectura.getCcvcusureg().equals("cl01dasg")) {
                    url_firma = 
                            FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_FIRMA_DIANA_SALCEDO);
                } else if (lectura.getCcvcusureg().equals("cl01lkmm")) {
                    url_firma = 
                            FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_FIRMA_KAREN_MARROQUIN);
                }else if (lectura.getCcvcusureg().equals("cl01lahm")) {
                    url_firma = 
                            FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_FIRMA_LAURA_HERRERA);
                }else if (lectura.getCcvcusureg().equals("cl01ksmg")) {
                    url_firma = 
                            FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_FIRMA_KAREN_MEDINA);
                }

            URL url_super_horizontal = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
            URL url_super_vertical = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);

            ExternalContext externalContext = 
                FacesContext.getCurrentInstance().getExternalContext();
            HttpServletRequest request = 
                (HttpServletRequest)externalContext.getRequest();

            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                parameters.put("IMAGE_FIRMA", url_firma);
                
                JRHtmlExporter exporter = new JRHtmlExporter();

                JasperReport report = (JasperReport)JRLoader.loadObject(url);
                jasperPrint = 
                        JasperFillManager.fillReport(report, parameters, (JRDataSource)this);
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, 
                                      jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_STRING_BUFFER, 
                                      sbuffer);
                exporter.setParameter(JRHtmlExporterParameter.IMAGES_MAP, 
                                      parameters);
                exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, 
                                      request.getContextPath() + 
                                      "/comun/imagenes?image=");
                exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, 
                                      Boolean.FALSE);
                exporter.setParameter(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, 
                                      Boolean.TRUE);
                exporter.setParameter(JRHtmlExporterParameter.CHARACTER_ENCODING, 
                                      "ISO-8859-9");
              
                exporter.setParameter(JRHtmlExporterParameter.HTML_FOOTER, "");
                exporter.setParameter(JRHtmlExporterParameter.HTML_HEADER, "");
                JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                //String ruta = FacesUtils.getFacesContext().getExternalContext().getRequestContextPath();
                ModuleConfig config = new ModuleConfig();
                String ruta = config.getDireccionArchivosTmp();
                nombreArchivo =ruta+"lecturaVPH_"+citologia.getCcictipide()+"_"+citologia.getCcianumide()+"_"+citologia.getCcidfecreg()+".pdf";               
                File file = new File(nombreArchivo);
                OutputStream os = new FileOutputStream(file);   
                JasperExportManager.exportReportToPdfStream(jasperPrint, os);
                //JasperExportManager.exportReportToPdfFile( jasperPrint, "C:\\ProyectosJava\\HistoriasClinicas\\public_html\\reports\\cjet.pdf");
            }            
            
            }else{
                generoLectura = false;
                FacesUtils.addErrorMessage("No existe Lectura");
            }
        } catch (Exception e) {
            generoLectura =false;
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
    }


    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    public Cnconsclin getConsulta() {
        return consulta;
    }

    public void setCitologia(Cncitologi citologia) {
        this.citologia = citologia;
    }

    public Cncitologi getCitologia() {
        return citologia;
    }

    public void setResultadoVphWS(TomaVphWS resultadoVphWS) {
        this.resultadoVphWS = resultadoVphWS;
    }

    public TomaVphWS getResultadoVphWS() {
        return resultadoVphWS;
    }

    public void setListconsultaEpicenterResult(List<ConsultaEpicenterResult> listconsultaEpicenterResult) {
        this.listconsultaEpicenterResult = listconsultaEpicenterResult;
    }

    public List<ConsultaEpicenterResult> getListconsultaEpicenterResult() {
        return listconsultaEpicenterResult;
    }

    public void setToma(Cncitotoma toma) {
        this.toma = toma;
    }

    public Cncitotoma getToma() {
        return toma;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setGeneroLectura(boolean generoLectura) {
        this.generoLectura = generoLectura;
    }

    public boolean isGeneroLectura() {
        return generoLectura;
    }

    public void setDetectable(String detectable) {
        this.detectable = detectable;
    }

    public String getDetectable() {
        return detectable;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }
}
