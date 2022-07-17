 package org.profamilia.hc.view.backing.cirugia.busqueda;

import java.io.File;

import java.math.BigDecimal;

import java.net.URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperRunManager;

import org.apache.myfaces.component.html.ext.HtmlDataTable;

import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chdescrquiru;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chdetaldescr;
import org.profamilia.hc.model.dto.Chhallahistero;
import org.profamilia.hc.model.dto.Chhisteroscopia;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.registro.DescripcionQuirurgicaBean;
import org.profamilia.hc.view.backing.cirugia.resumen.GenerarFoliosCirugiaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


public class DetalleDescripcionQuirurgicaBean extends BaseBean implements JRDataSource {

    private boolean generoReporte;
    
    private Chcirugprogr cirugiaObject;
    
    private Chusuario usuario;
    
    private List<Chdetacirpro> lstCirugiasIngresadas;
    
    private List<Chdetacirpro> lstCirugiasRealizadas; 
    
    private List<Chdetacirpro> lstCirugiasSelect; 
    
    private HtmlDataTable dtCirugia; 
    
    private HtmlDataTable dtCirugias; 
    
     private HtmlDataTable dtCirugiaRealizada;
    
    private boolean wexito; 
      
    private Long numeroConsulta; 
    
    private int index;
    
    private List<Object[]> lstDescDetalle;
    
    private Object[] detalleDesc;
    
    private Chdescrquiru descripcion;
    
    private Chantegineco antecedentes;
    
    private Chdetacirpro detalle;
    
    private UIInput checkSeleccion;
    
    String DIAGNOSTICO;
    
    private Chdetaldescr detalleDescr;
    private Crdgncie10 diagprin = null;
    
    private Chhisteroscopia histeroscopia;
    
    private Chhallahistero hallazgoHis;
    
    String NOMBRE_PROFESIONAL;
    String REGISTRO_MEDICO;
    BigDecimal NUMID_PROFESIONAL;
    String TIPOID_PROFESIONAL;

    public DetalleDescripcionQuirurgicaBean() {
    }
    
    public void init(){
        dtCirugia = new HtmlDataTable(); 
        dtCirugias = new HtmlDataTable(); 
        dtCirugiaRealizada = new HtmlDataTable(); 
    
    }
    
    public void inicializarCirugiasDescripcionQuirurgica(){
      histeroscopia= new Chhisteroscopia();
        hallazgoHis=new Chhallahistero();
        generoReporte = false;
        if(cirugiaObject!= null && cirugiaObject.getHcplnumero()!= null){
            List<Object[]> lstCirugiasIngresadasAux = null; 
            List<Object[]> lstCirugiasRealizadasAux = null; 
            
            try {
                // TRAE LAS CIRUGIAS PENDIENTES DE REGISTRO
                lstCirugiasIngresadasAux = this.serviceLocator.getClinicoService().getDetalleCirugiasProgramadasBasico(cirugiaObject.getHcplnumero(),true);
                // TRAE LAS CIRUGIAS QUE YA SE REGISTRARON PARA IMPRIMIR LA DESCRIPCION QUIRURGICA Y/O ANATOMIA PATOLOGICA
                 lstCirugiasRealizadasAux = this.serviceLocator.getClinicoService().getDetalleCirugiasProgramadasBasico(cirugiaObject.getHcplnumero(),false);
            } catch (ModelException e) {
               e.printStackTrace();
            }
            
            if(lstCirugiasIngresadasAux!= null && !lstCirugiasIngresadasAux.isEmpty()){
                lstCirugiasIngresadas = new ArrayList<Chdetacirpro>(); 
                for(Object[] cirugiaAux :lstCirugiasIngresadasAux){
                    Chdetacirpro detalleAux = null; 
                    detalleAux = new Chdetacirpro(); 
                    Long consultaPrincipal = ((BigDecimal)cirugiaAux[0]).longValue(); 
                    String servicioAux = (String)cirugiaAux[1];  
                    String descripcionServicio = (String)cirugiaAux[2]; 
                    String tieneDescripcion = (String)cirugiaAux[3]; 
                    Long usuario = ((BigDecimal)cirugiaAux[5]).longValue(); 
                    Integer clinica = ((BigDecimal)cirugiaAux[6]).intValue();
                    
                    detalleAux.getId().setHdclconsuprinc(consultaPrincipal);
                    detalleAux.getId().setHdccservicio(servicioAux);
                    detalleAux.setHdccdescrservi(descripcionServicio);
                    detalleAux.setHdccdescrquiru(tieneDescripcion);
                    detalleAux.setHdclusuario(usuario);
                    detalleAux.setHdcnclinica(clinica);
                    boolean tieneAna  = tieneAnatomiaPatologica(detalleAux);
                    detalleAux.setRenderAnatomia(tieneAna);
                    
                    lstCirugiasIngresadas.add(detalleAux);
                    
                }
            }
            
            if(lstCirugiasRealizadasAux!= null && !lstCirugiasRealizadasAux.isEmpty()){
                lstCirugiasRealizadas = new ArrayList<Chdetacirpro>(); 
                for(Object[] cirugiaAux :lstCirugiasRealizadasAux){
                    Chdetacirpro detalleAux = null; 
                    detalleAux = new Chdetacirpro(); 
                    Long consultaPrincipal = ((BigDecimal)cirugiaAux[0]).longValue(); 
                    String servicioAux = (String)cirugiaAux[1];  
                    String descripcionServicio = (String)cirugiaAux[2]; 
                    String tieneDescripcion = (String)cirugiaAux[3]; 
                    Long usuario = ((BigDecimal)cirugiaAux[5]).longValue();
                    Integer clinica = ((BigDecimal)cirugiaAux[6]).intValue();
                    
                    detalleAux.getId().setHdclconsuprinc(consultaPrincipal);
                    detalleAux.getId().setHdccservicio(servicioAux);
                    detalleAux.setHdccdescrservi(descripcionServicio);
                    detalleAux.setHdccdescrquiru(tieneDescripcion);
                    detalleAux.setHdclusuario(usuario);
                    detalleAux.setHdcnclinica(clinica);
                    boolean tieneAna  = tieneAnatomiaPatologica(detalleAux);
                    detalleAux.setRenderAnatomia(tieneAna);
                    
                    lstCirugiasRealizadas.add(detalleAux);
                }
            }
        }
    }

    /**
     * @param cirugiaObject
     */
    public void setCirugiaObject(Chcirugprogr cirugiaObject) {
        this.cirugiaObject = cirugiaObject;
    }

    /**
     * @return
     */
    public Chcirugprogr getCirugiaObject() {
        return cirugiaObject;
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
     * @param lstCirugiasIngresadas
     */
    public void setLstCirugiasIngresadas(List<Chdetacirpro> lstCirugiasIngresadas) {
        this.lstCirugiasIngresadas = lstCirugiasIngresadas;
    }

    /**
     * @return
     */
    public List<Chdetacirpro> getLstCirugiasIngresadas() {
        return lstCirugiasIngresadas;
    }

    /**
     * @param dtCirugia
     */
    public void setDtCirugia(HtmlDataTable dtCirugia) {
        this.dtCirugia = dtCirugia;
    }

    /**
     * @param lstCirugiasSelect
     */
    public void setLstCirugiasSelect(List<Chdetacirpro> lstCirugiasSelect) {
        this.lstCirugiasSelect = lstCirugiasSelect;
    }

    /**
     * @return
     */
    public List<Chdetacirpro> getLstCirugiasSelect() {
        return lstCirugiasSelect;
    }

    /**
     * @param wexito
     */
    public void setWexito(boolean wexito) {
        this.wexito = wexito;
    }

    /**
     * @return
     */
    public boolean isWexito() {
        return wexito;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCirugia() {
        return dtCirugia;
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
     * @return
     */
    public String registrarDescripcion() {
        // Add event code here...
        return null;
    }

    public String volver() {
        FacesUtils.resetManagedBean("detalleDescripcionQuirurgicaBean");
       return BeanNavegacion.RUTA_IR_LISTA_CIRUGIAS_DESCRIPCION_QUIRURGICA;
    }

    public String continuarRegistro() throws ModelException {
        FacesUtils.resetManagedBean("descripcionQuirurgicaBean");
        String navegationRule="";
        
        Chconsulta consulta= new Chconsulta();
        consulta= this.serviceLocator.getClinicoService().getConsultaActualHisteroscopia(cirugiaObject.getHcplnumero()); 
        if(null != consulta){
        Cpservicio ser= new Cpservicio();
        Chhisteroscopia his= new Chhisteroscopia();
        Chhallahistero hall= new Chhallahistero();
        
        ser= this.serviceLocator.getClinicoService().getServicioClinico(consulta.getHcocservicio());
            if (null != ser) {
                if (ser.getCsvntiphis()==56) {
                    his= this.serviceLocator.getClinicoService().getConsultaRegistroHisteroscopia(cirugiaObject.getHcplnumero()); 
                    hall =  this.serviceLocator.getClinicoService().getConsultaHallazgoHisteroscopia(cirugiaObject.getHcplnumero()); 
                    
                    if(null==histeroscopia){
                        histeroscopia= new Chhisteroscopia();
                    }
                    if(null==hallazgoHis){
                        hallazgoHis= new Chhallahistero();
                    }
                    navegationRule = BeanNavegacion.RUTA_REGISTRAR_DESCRIPCION_QUIRURGICA_HISTE;
                } else {
                   navegationRule = 
                        BeanNavegacion.RUTA_REGISTRAR_DESCRIPCION_QUIRURGICA;
                }

            }
        }else{
            navegationRule = 
                 BeanNavegacion.RUTA_REGISTRAR_DESCRIPCION_QUIRURGICA;
        }
       
        wexito = true; 
        Cpprofesio profesional = null;
        lstCirugiasSelect = new ArrayList<Chdetacirpro>(); 
        if(lstCirugiasIngresadas!= null){
            for(Chdetacirpro ciruselec:lstCirugiasIngresadas){
                 if(ciruselec.isSeleccionado()){
                     try {
                         profesional = this.serviceLocator.getClinicoService().getProfesionalPorUsuario(userName(), this.getClinica().getCclncodigo()); 
                     }
                     catch (ModelException e) {
                         return capturaError(e,IConstantes.ERROR_COSNULTA);
                     }
                     if(profesional!= null){
                         ciruselec.setHdcnmedicatien(profesional.getCpfncodigo());
                     }else{
                         wexito = false; 
                         FacesUtils.addErrorMessage(PROFESIONAL_NO_TIENE_CODIGO);
                     }
                     lstCirugiasSelect.add(ciruselec);
                 }
            }
        }
        
        if(lstCirugiasSelect == null || lstCirugiasSelect.isEmpty()){
            wexito = false; 
            navegationRule = BeanNavegacion.RUTA_ACTUAL; 
            FacesUtils.addErrorMessage(MSG_SELECCIONE_CIRUGIAS_DQX);
        }
      
      if(wexito){
          DescripcionQuirurgicaBean descripcionBean = null;
          descripcionBean = 
                  (DescripcionQuirurgicaBean)FacesUtils.getManagedBean("descripcionQuirurgicaBean");
          if (descripcionBean != null) {
              descripcionBean.setLstDetalleCirugias(lstCirugiasSelect);
              descripcionBean.setNumeroUsuario(usuario.getHuslnumero());
              descripcionBean.setUsuario(usuario);
              if(profesional!=null && profesional.getCpfncodigo()!=null){
                  descripcionBean.setCodigoMedico(profesional.getCpfncodigo());     
              }
              
              descripcionBean.setNumeroConsulta(cirugiaObject.getHcplnumero());
              descripcionBean.init();
          }
      }
        return navegationRule;
    }
   
    
    public String imprimirDescripcion() {
        Chdetacirpro detaCir =  (Chdetacirpro)dtCirugiaRealizada.getRowData();
        GenerarFoliosCirugiaBean bean = (GenerarFoliosCirugiaBean)FacesUtils.getManagedBean("generarFoliosCirugiaBean");
        byte[] result = null;
        Chcirugprogr cirugiaAux = null;
        Chusuario usuario = null;
        try {
            cirugiaAux = this.serviceLocator.getCirugiaService().getFolioCirugiaCompleto(detaCir.getId().getHdclconsuprinc());
            usuario = this.serviceLocator.getClinicoService().getUsuario(detaCir.getHdclusuario());
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }

        if (bean != null && cirugiaAux != null && usuario != null) {       
            result = bean.generarDescripcionQuirurgica(usuario, cirugiaAux, -1);
        }
        if (result != null) {
            PdfServletUtils.showPdfDocument(result,"DescripcionQuirurgica.pdf", false);
            setGeneroReporte(true);
        } else {
            FacesUtils.addErrorMessage("No pudo generar Reporte Descripci�n Quirurgica. ");
            setGeneroReporte(false);
       }
        return null;
    }
    
    public String buscaDatosAnatomiaPatologica(){   
        Chdetacirpro detacir =  (Chdetacirpro)dtCirugiaRealizada.getRowData();
        try {        
            lstDescDetalle = this.serviceLocator.getCirugiaService().getListaDescripcionQuirurgicaByUsuario(detacir.getId().getHdclconsuprinc());
            usuario = this.serviceLocator.getClinicoService().getUsuario(detacir.getHdclusuario());
            
            for(Object[] o :lstDescDetalle){
            BigDecimal codigo = (BigDecimal)o[0];
            String servicio = (String)o[3];
            if( codigo.longValue() == detacir.getId().getHdclconsuprinc() && 
                servicio.equals(detacir.getId().getHdccservicio())){
                detalleDesc = o;                    
                    generar();
                    break;
                }
            }
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }
        
        if(detalleDesc == null)
            FacesUtils.addErrorMessage("No se encontro la informaci�n necesaria para el reporte.");            
            return null;
        
    }
    
    
    public boolean tieneAnatomiaPatologica(Chdetacirpro detacir){
        boolean tiene = false;
        try {        
            if(detacir != null && detacir.getId() != null && detacir.getId().getHdclconsuprinc() != null){
                Chdetaldescr detalleAux = serviceLocator.getCirugiaService().getDetalleDescripcion(detacir.getId().getHdclconsuprinc());
            
            
            if(detalleAux != null && detalleAux.getHddcpiezapatol() != null){
                tiene = true;
            }
        }
        } catch (ModelException e) {
            e.printStackTrace();
        }
        
        return  tiene;         
        
        }
        
    
    
    public String generar() throws ModelException {
        index  = -1;
        Cpclinica clinica = new Cpclinica();
        Cpprofesio profesional;
        profesional = null;
        
        try {        
            descripcion = this.serviceLocator.getCirugiaService().getDescripcionQuirurgica(((BigDecimal)detalleDesc[0]).longValue());
            
            if(descripcion.getHdqnclinica() != null)
               clinica = this.serviceLocator.getClinicoService().getClinica(descripcion.getHdqnclinica());
                
            if(usuario.getHusesexo().equals("F"))
                antecedentes = this.serviceLocator.getClinicoService().getUltimoAntecedentesGinecologicos(usuario.getHuslnumero());
            
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }
        
        Cpentidadadm entidad;
        entidad=null;
        entidad= this.getServiceLocator().getClinicoService().getAseguradoraPorCodigo(usuario.getHuscentidadadm());

        try {
            detalleDescr = 
                        this.serviceLocator.getCirugiaService().getDetalleDescripcion(descripcion.getHdqlnumero());
        
        
            if (detalleDescr.getHddcdiagnprinc() != null) {
                diagprin = 
                        this.serviceLocator.getClinicoService().getCIE10PorCodigo(detalleDescr.getHddcdiagnprinc().toUpperCase());
            }

        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }
        if (diagprin != null && 
            detalleDescr.getHddcdiagnprinc() != null) {
            DIAGNOSTICO = 
                    detalleDescr.getHddcdiagnprinc().toUpperCase() + 
                    " " + diagprin.getCdccdescri();
        }
        
        if (userName() != null) {
            
            try {
                if (this.getClinica() != null) {
                    profesional = 
                            serviceLocator.getClinicoService().getProfesionalPorUsuario(userName(), 
                                                                                        getClinica().getCclncodigo());
                }

            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }

                if (profesional != null) {
                    NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                    REGISTRO_MEDICO = profesional.getCpfcregmedic();
                    NUMID_PROFESIONAL= profesional.getCpfacedula();
                    TIPOID_PROFESIONAL= profesional.getCpfctipide();
                }
        }
        
        if(detalleDesc[15] != null && !detalleDesc[15].equals("")){
            File reportFile = new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/anatomiaPatologica.jasper"));

                if (reportFile.exists()) {
                    Map parameters = new HashMap();
                    byte[] bytes = null;
                    try {
                        URL imagen =  FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/profamilia_negro.gif");

                        parameters.put("IMAGEN", imagen);
                        parameters.put("FECHA", descripcion.getHdqdfechaproce());
                        parameters.put("NO_HISTORIA", usuario.getHusanumeiden().toString());
                        parameters.put("APELLIDOS",usuario.getHuscprimerapel() + " " + usuario.getHuscsegundapel());
                        parameters.put("NOMBRES",usuario.getHuscprimernomb() + " " + usuario.getHuscsegundnomb()+" "+usuario.getHuscprimerapel() + " " + usuario.getHuscsegundapel());
                        parameters.put("EDAD",usuario.getEdad());
                        parameters.put("ORIGEN_PIEZA",detalleDesc[15]);                    
                        parameters.put("CLINICA",clinica.getCclcnombre());
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
                        if(antecedentes!= null){
                            parameters.put("G",antecedentes.getHagnnumgesta());
                            parameters.put("P",antecedentes.getHagnnumparto());
                            parameters.put("A",antecedentes.getHagnnumaborto());
                            parameters.put("C",antecedentes.getHagnnumcesare());
                            parameters.put("V",antecedentes.getHagnnumvivo());
                            parameters.put("FUR",antecedentes.getHagdfur());
                            parameters.put("FUP",antecedentes.getHagdfup());
                        }        
                        
                        

                        
                        if(DIAGNOSTICO != null){
                        parameters.put("DIAGNOSTICO",DIAGNOSTICO);
                        }

                        bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, (JRDataSource)this);
                        PdfServletUtils.showPdfDocument(bytes,"AnatomiaPatologica.pdf", false);
                        setGeneroReporte(true);

                    } catch (JRException ex) {
                        setGeneroReporte(false);
                        return capturaError(ex,IConstantes.ERROR_REPORTES);
                    } catch (Exception ex) {
                        setGeneroReporte(false);
                        return capturaError(ex,IConstantes.ERROR_REPORTES);
                    }
                }else{
                    FacesUtils.addInfoMessage("En esta descripcion quirurgica no envio patologia");
                }
        }

        return null;
    }
    
    public String generarAnato() throws ModelException {
        index  = -1;
        Cpclinica clinica = new Cpclinica();
        Cpprofesio profesional;
        profesional = null;
        
        try {        
            descripcion = this.serviceLocator.getCirugiaService().getDescripcionQuirurgica(((BigDecimal)detalleDesc[0]).longValue());
            
            if(descripcion.getHdqnclinica() != null)
               clinica = this.serviceLocator.getClinicoService().getClinica(descripcion.getHdqnclinica());
                
            if(usuario.getHusesexo().equals("F"))
                antecedentes = this.serviceLocator.getClinicoService().getUltimoAntecedentesGinecologicos(usuario.getHuslnumero());
            
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }
        if (userName() != null) {
            
            try {
                if (this.getClinica() != null) {
                    profesional = 
                            serviceLocator.getClinicoService().getProfesionalPorUsuario(userName(), 
                                                                                        getClinica().getCclncodigo());
                }

            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }

            if (profesional != null) {
                NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                REGISTRO_MEDICO = profesional.getCpfcregmedic();
            }
        }
        Cpentidadadm entidad;
        entidad=null;
        entidad= this.getServiceLocator().getClinicoService().getAseguradoraPorCodigo(usuario.getHuscentidadadm());
        File reportFile = new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/anatomiaPatologica.jasper"));

        if (reportFile.exists()) {
            Map parameters = new HashMap();
            byte[] bytes = null;
            try {
                URL imagen =  FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/profamilia_negro.gif");

                parameters.put("IMAGEN", imagen);
                parameters.put("FECHA", descripcion.getHdqdfechaproce());
                parameters.put("NO_HISTORIA", usuario.getHusanumeiden().toString());
                parameters.put("APELLIDOS",usuario.getHuscprimerapel() + " " + usuario.getHuscsegundapel());
                parameters.put("NOMBRES",usuario.getHuscprimernomb() + " " + usuario.getHuscsegundnomb()+" "+usuario.getHuscprimerapel() + " " + usuario.getHuscsegundapel());
                parameters.put("EDAD",usuario.getEdad());
                parameters.put("ORIGEN_PIEZA",detalleDesc[16]);                    
                parameters.put("CLINICA",clinica.getCclcnombre()); 
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
                    
                if(antecedentes!= null){
                    parameters.put("G",antecedentes.getHagnnumgesta());
                    parameters.put("P",antecedentes.getHagnnumparto());
                    parameters.put("A",antecedentes.getHagnnumaborto());
                    parameters.put("C",antecedentes.getHagnnumcesare());
                    parameters.put("V",antecedentes.getHagnnumvivo());
                    parameters.put("FUR",antecedentes.getHagdfur());
                    parameters.put("FUP",antecedentes.getHagdfup());
                }         

                
                 if(DIAGNOSTICO != null){
                 parameters.put("DIAGNOSTICO",DIAGNOSTICO);
                 }

                bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, (JRDataSource)this);
                PdfServletUtils.showPdfDocument(bytes,"AnatomiaPatologica.pdf", false);
                setGeneroReporte(true);
             } catch (JRException ex) {
                setGeneroReporte(false);
                 return capturaError(ex,IConstantes.ERROR_REPORTES);
             } catch (Exception ex) {
                setGeneroReporte(false);
                 return capturaError(ex,IConstantes.ERROR_REPORTES);
             }
        }
        return null;
    }
    
    public boolean next() {
        index++;
        return (index < 1);
    }

    public Object getFieldValue(JRField jrField) {
        return null;
    }

    public void setLstDescDetalle(List<Object[]> lstDescDetalle) {
        this.lstDescDetalle = lstDescDetalle;
    }

    public List<Object[]> getLstDescDetalle() {
        return lstDescDetalle;
    }

    public void setDetalleDesc(Object[] detalleDesc) {
        this.detalleDesc = detalleDesc;
    }

    public Object[] getDetalleDesc() {
        return detalleDesc;
    }

    public void setDescripcion(Chdescrquiru descripcion) {
        this.descripcion = descripcion;
    }

    public Chdescrquiru getDescripcion() {
        return descripcion;
    }

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }

    public void setDtCirugias(HtmlDataTable dtCirugias) {
        this.dtCirugias = dtCirugias;
    }

    public HtmlDataTable getDtCirugias() {
        return dtCirugias;
    }

    public void setLstCirugiasRealizadas(List<Chdetacirpro> lstCirugiasRealizadas) {
        this.lstCirugiasRealizadas = lstCirugiasRealizadas;
    }

    public List<Chdetacirpro> getLstCirugiasRealizadas() {
        return lstCirugiasRealizadas;
    }

    public void setDtCirugiaRealizada(HtmlDataTable dtCirugiaRealizada) {
        this.dtCirugiaRealizada = dtCirugiaRealizada;
    }

    public HtmlDataTable getDtCirugiaRealizada() {
        return dtCirugiaRealizada;
    }

    public void setCheckSeleccion(UIInput checkSeleccion) {
        this.checkSeleccion = checkSeleccion;
    }

    public UIInput getCheckSeleccion() {
        return checkSeleccion;
    }

    public void setHisteroscopia(Chhisteroscopia histeroscopia) {
        this.histeroscopia = histeroscopia;
    }

    public Chhisteroscopia getHisteroscopia() {
        return histeroscopia;
    }

    public void setHallazgoHis(Chhallahistero hallazgoHis) {
        this.hallazgoHis = hallazgoHis;
    }

    public Chhallahistero getHallazgoHis() {
        return hallazgoHis;
    }
}
