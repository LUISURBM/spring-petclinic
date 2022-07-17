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
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpcontrato;
import org.profamilia.hc.model.dto.CpcontratoId;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.dto.PruebasRapidasDTO;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorContratosBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorUsuariosBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

public class ConsultaPruebasCovidBean extends BaseBean implements JRDataSource {


    private int selectedIndex;

    private boolean renderBuscador;

    private boolean generoHistoria;

    private Chusuario usuario;

    private String nombreUsuario;

    private Long numeroUsuario;

    private boolean renderInformacionUsuario;

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

    
    private List<PruebasRapidasDTO> lstReporte;
    boolean generoReporte;
    private HtmlDataTable dtPruebaRapida;
    private Object[] registro;
    private Cpprofesio profesionalAct;
    private List<Object[]> listaRegistros;
    private Integer numeroContrato;
    private Date fechaInicial;
    private Date fechaFinal;
    private boolean existeInformacion;
    private Cpcontrato contrato;
    private String descripcion;
    private UIInput IDescripcion;
    static final int ACTIVAR_PARAMETRIZACION = 0;
    private Long historia;
    private String tipoPrueba;
    private List<SelectItem>lstTipoPrueba;

    public ConsultaPruebasCovidBean() {
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
    
    public void changeDescripcion() {
        descripcion = "";
        contrato = new Cpcontrato();
        CpcontratoId id = new CpcontratoId();
       
        List <Cpcontrato>auxContratos = new ArrayList<Cpcontrato>();
            if (numeroContrato != null ) {
                id.setCcnnclinic(this.getClinica().getCclncodigo());
                id.setCcnnnumero(numeroContrato);
                contrato.setId(id);
                contrato.setCcncdescri(descripcion);
                try {
                    auxContratos = 
                            this.serviceLocator.getClinicoService().getCriteriosContratoByClinica(contrato,true,this.getClinica().getCclncodigo());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (auxContratos != null  && !auxContratos.isEmpty()) {
                    descripcion = auxContratos.get(0).getCcncdescri();
                }
                else{
                    descripcion = null;
                    numeroContrato = null;
                }

              if(descripcion == null){
                    numeroContrato =null;
                    IDescripcion.setValue(null);
                    FacesUtils.addErrorMessage("Contrato no existe");
                }
          
        }
    }
    

    public String consultarRegistros() {
        try {
            generoReporte = false;
          if(descripcion == null || descripcion.equals("")){
              FacesUtils.addErrorMessage("El Contrato no puede estar vac�o o no existe");
          }
          else{
                listaRegistros = 
                        this.serviceLocator.getClinicoService().getRegistrosPruebasCovid(new Long(getClinica().getCclncodigo()),new Long(numeroContrato),fechaInicial,fechaFinal,tipoPrueba);
                                                                                        
            
            if (listaRegistros != null && !listaRegistros.isEmpty()) {
                try {
                    profesionalAct =
                        serviceLocator.getClinicoService().getProfesionalPorUsuario(userName(),
                                                                                    this.getClinica().getCclncodigo());
                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_REPORTES);
                }
                existeInformacion = true;
            } else {
                FacesUtils.addErrorMessage("No existen datos");
                existeInformacion = false;
            }
              
          }
          
        } catch (ModelException de) {
            
            existeInformacion = false;
            return capturaError(de,IConstantes.ERROR_COSNULTA);
        } catch (Exception e) {
            existeInformacion = false;
            return capturaError(e,IConstantes.ERROR_COSNULTA);
           
        }
        return null;

    }

    /**
     * @return
     */
    public boolean next() {
        index++;  
        return (index < listaRegistros.size());
    }

  
    
    public Object getFieldValue(JRField jrField) {
        Object value = null;
        String fieldName = jrField.getName();
        Object[] b = new Object[listaRegistros.size()];
        b = listaRegistros.get(index);
        if(fieldName.equals("CONSULTA")){
            value = b[1].toString();
        }
        if (fieldName.equals("FECHA")) 
                 value= (Date)b[22];  
                 else if (fieldName.equals("CLINICA")) 
                 value=getClinica().getCclcnombre() ;  
                 else if (fieldName.equals("NOMBRES")){
                     String primerNombre = "";
                     String primerApellido ="" ;
                     String segundoNombre="";
                     String segundoApellido = "";
                 primerNombre = (b[3] != null) ? b[3].toString() : " ";
                 segundoNombre = (b[5] != null) ? b[5].toString() : " ";
                 primerApellido = (b[4] != null) ? b[4].toString() : " ";
                 segundoApellido = (b[6] != null) ? b[6].toString() : " ";
                 value= primerNombre + " "+segundoNombre+" "+primerApellido+" "+segundoApellido;
                 }
                 else if (fieldName.equals("DIRECCION")){
                 if(b[7]!=null){
                    value= b[7]; 
                 }
                 }
                 else if (fieldName.equals("TELEFONO")){ 
                     if(b[8]!=null){
                        value= b[8]; 
                     }
                 }
                 else if (fieldName.equals("EDAD")){
                 BigDecimal edad = (BigDecimal)b[9];
                    String edadTxt = edad.toString();
                    int edadFinal = Integer.parseInt(edadTxt);
                    value = edadFinal;
                 }
                 else if (fieldName.equals("NUMEROID")) 
                    value= b[10].toString() +" "+b[11].toString();  
                 else if (fieldName.equals("ANTIGENOS")){
                    if(b[0].toString().equals("58")){
                        value= "X";
                    }
                 }
                 else if (fieldName.equals("ANTICUERPOS")) {
                     if(b[0].toString().equals("59")){                      
                         value= "X";
                     }
                 }
                 else if (fieldName.equals("CONTACTO")){ 
                     if(b[12]!=null){
                        value= b[12]; 
                     }
                 }
                 else if (fieldName.equals("FECHASINTOMAS")){ 
                     if(b[13]!=null){
                        value= (Date)b[13]; 
                     }
                 }
                 else if (fieldName.equals("MARCA")){ 
                     if(b[14]!=null){
                        value= b[14]; 
                     }
                 }
                 else if (fieldName.equals("LOTE")) {
                     if(b[15]!=null){
                        value= b[15]; 
                     } 
                 }
                 else if (fieldName.equals("INVIMA")) {
                     if(b[16]!=null){
                        value= b[16]; 
                     }
                 }
                 else if (fieldName.equals("FECHAFABRICACION")){ 
                     if(b[17]!=null){
                        value= (Date)b[17]; 
                     }
                 }
                 else if (fieldName.equals("FECHAVENCIMIENTO")){ 
                     if(b[18]!=null){
                        value= (Date)b[18]; 
                     }
                 }
                 else if (fieldName.equals("RESULTADO")){ 
                    if(b[19]!=null){
                        value= b[19]; 
                    }
                 }
                 else if (fieldName.equals("TIPOANTIGENO")){ 
                     if(b[20]!=null){
                        String valor = b[20].toString(); 
                        if(!valor.equals("NA")){
                            value= valor; 
                        }
                         
                     }
                 }
        else if (fieldName.equals("TENIDO_SINTOMAS")){ 
            if(b[21]!=null){
               String valor = b[21].toString(); 
                   value= valor; 
            }
        }
                 else if (fieldName.equals("PROFESIONAL")){ 
                 if(profesionalAct!=null){
                     value = profesionalAct.getCpfcnombre();
                 }
                } 
    return value;
    }
   
    
    public String generarArchivoPdf() throws ModelException {
        lstReporte = new ArrayList<PruebasRapidasDTO>();
        index = -1;
        generoReporte = false;
        if (descripcion ==null || listaRegistros == null || listaRegistros.isEmpty()) {
            FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
        } else {
            try {
           
                        this.index = -1;
                            try {
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
                                                                "PruebasCovid" + 
                                                                ".pdf", false);
                                generoReporte = true;
                                navigationRule = nextAction;
                            }
                        } catch (Exception e) {
                          return capturaError(e,IConstantes.ERROR_ARCHIVOS);

                        }
            } catch (Exception e) {
               return capturaError(e,IConstantes.ERROR_ARCHIVOS);
            }
        }
        return null;
    }
    

    public void aceptarContrato() {
        BuscadorContratosBean contratoBus;
        contratoBus = (BuscadorContratosBean)FacesUtils.getManagedBean("buscadorContratosBean");

        if (contratoBus != null && contratoBus.getContratoSelect() != null) {
           IDescripcion.setValue(contratoBus.getContratoSelect().getId().getCcnnnumero());
           //dto.setCstnadmisi(((BigDecimal)aux[0]).longValue());
           descripcion = contratoBus.getContratoSelect().getCcncdescri();
       
       }
        renderBuscador = false;
        selectedIndex = ACTIVAR_PARAMETRIZACION;
    }
    
    public void mostrarBuscadorContratos() {
        FacesUtils.resetManagedBean("buscadorContratosBean");
        BuscadorContratosBean contratoBus;
        contratoBus = (BuscadorContratosBean)FacesUtils.getManagedBean("buscadorContratosBean");
        contratoBus.setFiltroClinica(true);
        selectedIndex = ACTIVAR_BUSCADOR;
        renderBuscador = true;
        generoHistoria = false;

    }

    

  
    
    public void mostrarBuscadorUsuarios() {
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        selectedIndex = ACTIVAR_BUSCADOR;
        renderBuscador = true;
        generoHistoria = false;
        lstCitologiaUsuario = new ArrayList();

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
    public void setNumeroContrato(ValueChangeEvent valueChangeEvent) {
        setNumeroContrato((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
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

   

  

    
    public void setIDescripcion(UIInput iDescripcion) {
        this.IDescripcion = iDescripcion;
    }

    public UIInput getIDescripcion() {
        return IDescripcion;
    }

    public void setNumeroContrato(Integer numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public Integer getNumeroContrato() {
        return numeroContrato;
    }

    public void setListaRegistros(List<Object[]> listaRegistros) {
        this.listaRegistros = listaRegistros;
    }

    public List<Object[]> getListaRegistros() {
        return listaRegistros;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setExisteInformacion(boolean existeInformacion) {
        this.existeInformacion = existeInformacion;
    }

    public boolean isExisteInformacion() {
        return existeInformacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public List<SelectItem> getLstTipoPrueba() {
        if(lstTipoPrueba == null || lstTipoPrueba.isEmpty()){
            lstTipoPrueba = new ArrayList<SelectItem>();         
            lstTipoPrueba.add(new SelectItem("antigenos","Detecci�n Ant�genos COVID � 19"));
            lstTipoPrueba.add(new SelectItem("anticuerpos","Detecci�n Anticuerpos COVID � 19"));
            lstTipoPrueba.add(new SelectItem("ambas","Detecci�n Anticuerpos / Ant�genos COVID � 19"));   
        }
        return lstTipoPrueba;
    }

    public void setTipoPrueba(String tipoPrueba) {
        this.tipoPrueba = tipoPrueba;
    }

    public String getTipoPrueba() {
        return tipoPrueba;
    }
}

