package org.profamilia.hc.view.backing.cirugia.registro;

import java.io.File;

import java.net.URL;

import java.sql.Timestamp;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.myfaces.component.html.ext.HtmlDataTable;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chcontroliqu;
import org.profamilia.hc.model.dto.Chcontroorden;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chformulaliq;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

public class OtrasOrdenesPendientesBean extends BaseBean {

    private Chcirugprogr cirugia;

    private boolean esIngreso;

    private List lstCirugias;

    private HtmlDataTable dtCirugias;

    private Chusuario usuario;

    private Chdetacirpro detalleCirugia;

    private Cpservicio servicio;

    private String usuarioSystem;
    
    private List<Chcontroorden> lstOtrasOrdenes;
    
    private HtmlDataTable dtOtrasOrdenes;
    
    private List<Chcontroorden> lstOtrasOrdenesRealizadas;
    
    private HtmlDataTable dtOtrasOrdenesRealizadas;
    
    private List<Chcontroorden> lstOrdenSelect;
    
    private String navegationRule;

    private boolean renderedOxigeno;
    
    private List lstOpciones;
    
    private boolean rendereNodOxigeno;
    
    private String noOxigeno;
    
    private String descripoOxigeno;
    
    private Boolean renderedOxigenoSuspender;
    
    private String suspenderOxigeno;
    
   private Boolean renderOxigenoCriterio; 
   
   private Chcontroorden formulaAdd;
   
   private int minutosAdmOxigeno;
   
    private List<Chcontroorden> lstOtrasOrdenesCE;
    
    private HtmlDataTable dtOtrasOrdenesCE;
    
    private List<Chcontroorden> lstOtrasOrdenesRealizadasCE;
    
    private List<Cnconsclin> lstConsclin;

    public OtrasOrdenesPendientesBean() {
    }

    public void init() {

        lstCirugias = new ArrayList();
        dtCirugias = new HtmlDataTable();
        dtOtrasOrdenes = new HtmlDataTable();
        dtOtrasOrdenesCE = new HtmlDataTable();
        lstOtrasOrdenes = new ArrayList<Chcontroorden>();
        lstOtrasOrdenesCE = new ArrayList<Chcontroorden>();
        dtOtrasOrdenesRealizadas = new HtmlDataTable();
        lstOtrasOrdenesRealizadas  = new ArrayList<Chcontroorden>();
        lstOtrasOrdenesRealizadasCE = new ArrayList<Chcontroorden>();
        renderedOxigeno=false;
        rendereNodOxigeno=false;
        renderedOxigenoSuspender= false;
        descripoOxigeno="";
        noOxigeno="";
        suspenderOxigeno="";
        renderOxigenoCriterio=false;
        formulaAdd= new Chcontroorden();
        
        if (cirugia != null) {

            if (cirugia != null) {
                
                try {
                    lstOtrasOrdenes = this.serviceLocator.getCirugiaService().getOtrasOrdenesPendientes(cirugia.getHcplnumero());
                    if(null !=lstOtrasOrdenes && !lstOtrasOrdenes.isEmpty()){
                     
                        for(int i=0; i<lstOtrasOrdenes.size();i++){
                             if(lstOtrasOrdenes.get(i).getHcoccestadoadminox()!= null){
                                  renderedOxigenoSuspender=true;
                             }
                            
                    }
                   
                    }
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                
                try {
                    lstOtrasOrdenesCE = this.serviceLocator.getCirugiaService().getOtrasOrdenesPendientesCE(cirugia.getHcplnumero(),cirugia.getHcplusuario().getHuslnumero());
                    if(null !=lstOtrasOrdenesCE && !lstOtrasOrdenesCE.isEmpty()){
                     
                        for(int i=0; i<lstOtrasOrdenesCE.size();i++){
                             if(lstOtrasOrdenesCE.get(i).getHcoccestadoadminox()!= null){
                                  renderedOxigenoSuspender=true;
                             }
                            
                    }
                   
                    }
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                
                try {
                    lstOtrasOrdenesRealizadas = this.serviceLocator.getCirugiaService().getOtrasOrdenesPendientesRealizadas(cirugia.getHcplnumero());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                
                try {
                    lstOtrasOrdenesRealizadasCE = this.serviceLocator.getCirugiaService().getOtrasOrdenesPendientesRealizadasCE(cirugia.getHcplnumero(),cirugia.getHcplusuario().getHuslnumero());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                
                lstConsclin = null;
                try {
                    lstConsclin = 
                            this.serviceLocator.getClinicoService().getConsultaClinica(cirugia.getHcplnumero().longValue());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                
                try {
                    detalleCirugia = 
                            this.serviceLocator.getCirugiaService().getServicioDetalle(cirugia.getHcplnumero());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                try {
                    if (cirugia.getChdetacirpros() != null && 
                        !cirugia.getChdetacirpros().isEmpty()) {
                        Chdetacirpro detalle = null;
                        Iterator it = cirugia.getChdetacirpros().iterator();
                        while (it.hasNext()) {
                            detalle = (Chdetacirpro)it.next();

                            if (detalle != null && detalle.getId() != null && 
                                detalle.getId().getHdccservicio() != null) {
                                Cpservicio servicio = 
                                    this.serviceLocator.getClinicoService().getServicioPorId(detalle.getId().getHdccservicio());
                                lstCirugias.add(servicio);
                            }
                        }
                    } else if (lstConsclin != null && !lstConsclin.isEmpty()) {
                        Iterator it = lstConsclin.iterator();
                        Cnconsclin conclin;

                        while (it.hasNext()) {
                            conclin = (Cnconsclin)it.next();
                            lstCirugias.add(conclin.getCcocservic());
                        }

                    }

                } catch (ModelException e) {
                    e.printStackTrace();
                }

            }

        }
    }
    
    public String administrarOrdenPendiente() {
        Chcontroorden formulaAdd;
        formulaAdd = (Chcontroorden)this.dtOtrasOrdenes.getRowData();
        lstOtrasOrdenes.remove(formulaAdd);
        Integer consecutivo = formulaAdd.getId().getHconconsecutiv();

        lstOrdenSelect = new ArrayList<Chcontroorden>();

        if (formulaAdd != null) {
            Chcontroorden ordenAux;
            ordenAux = new Chcontroorden();
            ordenAux.getId().setHcolnumero(cirugia.getHcplnumero());
            ordenAux.getId().setHconconsecutiv(formulaAdd.getId().getHconconsecutiv());
            ordenAux.setHcocestado(formulaAdd.getHcocestado());
            ordenAux.setHcocetapa(ETAPA_ADMINISTRADO);
            ordenAux.setHcocoperaadmi(userName());
        
            ordenAux.setHcocobserva(formulaAdd.getHcocobserva());
            ordenAux.setHcodfechaadmi(new Date());
            if (formulaAdd.getHcocnombreord().equals("OX")) {
            if (null == suspenderOxigeno) {
                    if (noOxigeno.equals("N")) {
                        ordenAux.setHcoccestadoadminox("VG");
                        Calendar fechaCalendarAdmin;
                        fechaCalendarAdmin = Calendar.getInstance();
                        fechaCalendarAdmin.setTime(new Date());
                        fechaCalendarAdmin.add(Calendar.MINUTE, (minutosAdmOxigeno * -1));
                        ordenAux.setHcodhorainioxi(fechaCalendarAdmin.getTime());
                        ordenAux.setHcodhorafinoxi(null);
                    }
                } else if (null != suspenderOxigeno || 
                           !suspenderOxigeno.equals("")) {
                    if (noOxigeno.equals("S")) {
                        ordenAux.setHcodhorainioxi((new Date()));
                        ordenAux.setHcodhorafinoxi(null);
                        ordenAux.setHcoccestadoadminox("VG");
                    }
                    else{
                        ordenAux.setHcoccestadoadminox("XX");
                        Calendar fechaCalendarAdmin;
                        fechaCalendarAdmin = Calendar.getInstance();
                        fechaCalendarAdmin.setTime(new Date());
                        fechaCalendarAdmin.add(Calendar.MINUTE, (minutosAdmOxigeno * -1));
                        ordenAux.setHcodhorainioxi(fechaCalendarAdmin.getTime());
                        ordenAux.setHcodhorafinoxi(new Date());
                    }

                } else {
                    ordenAux.setHcoccestadoadminox("XX");
                    ordenAux.setHcodhorafinoxi(new Date());
                }
                ordenAux.setHcoccadminisoxig("S");
                ordenAux.setHcocdfechadminis(new Date());
                if (noOxigeno.equals("N")) {
                    ordenAux.setHcoccadminoxigdesc(descripoOxigeno);
                } else {
                    ordenAux.setHcoccadminoxigdesc(formulaAdd.getHcocobserva());
                }
                if (ordenAux.getHcocobserva() == null) {
                    ordenAux.setHcocobserva(descripoOxigeno);
                }

            }
            lstOrdenSelect.add(ordenAux);
            
                try {

                    this.serviceLocator.getClinicoService().saveLstRegistroOrden(lstOrdenSelect, 
                                                                                    cirugia.getHcplnumero(), 
                                                                                    consecutivo);
                    FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                    
                } catch (ModelException e) {
                    FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + 
                                               e.getMessage());
                    e.printStackTrace();
                } catch (Exception ex) {
                    FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + 
                                               ex.getMessage());
                    ex.printStackTrace();
                }
                init();  
           
        
        }
        return navegationRule;
        
    }
    
    public String administrarOrdenPendienteCE() {
        Chcontroorden formulaAdd;
        formulaAdd = (Chcontroorden)this.dtOtrasOrdenesCE.getRowData();
        lstOtrasOrdenesCE.remove(formulaAdd);
        Integer consecutivo = formulaAdd.getId().getHconconsecutiv();

        lstOrdenSelect = new ArrayList<Chcontroorden>();

        if (formulaAdd != null) {
            Chcontroorden ordenAux;
            ordenAux = new Chcontroorden();
            ordenAux.getId().setHcolnumero(formulaAdd.getId().getHcolnumero());
            ordenAux.getId().setHconconsecutiv(formulaAdd.getId().getHconconsecutiv());
            ordenAux.setHcocestado(formulaAdd.getHcocestado());
            ordenAux.setHcocetapa(ETAPA_ADMINISTRADO);
            ordenAux.setHcocoperaadmi(userName());
        
            ordenAux.setHcocobserva(formulaAdd.getHcocobserva());
            ordenAux.setHcodfechaadmi(new Date());
            if (formulaAdd.getHcocnombreord().equals("OX")) {
            if (null == suspenderOxigeno) {
                    if (noOxigeno.equals("N")) {
                        ordenAux.setHcoccestadoadminox("VG");
                        Calendar fechaCalendarAdmin;
                        fechaCalendarAdmin = Calendar.getInstance();
                        fechaCalendarAdmin.setTime(new Date());
                        fechaCalendarAdmin.add(Calendar.MINUTE, (minutosAdmOxigeno * -1));
                        ordenAux.setHcodhorainioxi(fechaCalendarAdmin.getTime());
                        ordenAux.setHcodhorafinoxi(null);
                    }
                } else if (null != suspenderOxigeno || 
                           !suspenderOxigeno.equals("")) {
                    if (noOxigeno.equals("S")) {
                        ordenAux.setHcodhorainioxi((new Date()));
                        ordenAux.setHcodhorafinoxi(null);
                        ordenAux.setHcoccestadoadminox("VG");
                    }
                    else{
                        ordenAux.setHcoccestadoadminox("XX");
                        Calendar fechaCalendarAdmin;
                        fechaCalendarAdmin = Calendar.getInstance();
                        fechaCalendarAdmin.setTime(new Date());
                        fechaCalendarAdmin.add(Calendar.MINUTE, (minutosAdmOxigeno * -1));
                        ordenAux.setHcodhorainioxi(fechaCalendarAdmin.getTime());
                        ordenAux.setHcodhorafinoxi(new Date());
                    }

                } else {
                    ordenAux.setHcoccestadoadminox("XX");
                    ordenAux.setHcodhorafinoxi(new Date());
                }
                ordenAux.setHcoccadminisoxig("S");
                ordenAux.setHcocdfechadminis(new Date());
                if (noOxigeno.equals("N")) {
                    ordenAux.setHcoccadminoxigdesc(descripoOxigeno);
                } else {
                    ordenAux.setHcoccadminoxigdesc(formulaAdd.getHcocobserva());
                }
                if (ordenAux.getHcocobserva() == null) {
                    ordenAux.setHcocobserva(descripoOxigeno);
                }

            }
            lstOrdenSelect.add(ordenAux);
            
                try {

                    this.serviceLocator.getClinicoService().saveLstRegistroOrdenCE(lstOrdenSelect);
                    FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                    
                } catch (ModelException e) {
                    FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + 
                                               e.getMessage());
                    e.printStackTrace();
                } catch (Exception ex) {
                    FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + 
                                               ex.getMessage());
                    ex.printStackTrace();
                }
                init();  
           
        
        }
        return navegationRule;
        
    }

    public void changeNoOxigeno() {
        Chcontroorden formulaAdd = null;
            formulaAdd = (Chcontroorden)this.dtOtrasOrdenes.getRowData();
        if (formulaAdd.getHcoccadminisoxig().equals("N")) {
            rendereNodOxigeno = true;
            descripoOxigeno = "";
            suspenderOxigeno = "";
        } else {
            rendereNodOxigeno = false;
            descripoOxigeno = "";
            suspenderOxigeno = "";
        }
    }
    
    public void changeNoOxigenoCE() {
        Chcontroorden formulaAdd = null;
            formulaAdd = (Chcontroorden)this.dtOtrasOrdenesCE.getRowData();
        if (formulaAdd.getHcoccadminisoxig().equals("N")) {
            rendereNodOxigeno = true;
            descripoOxigeno = "";
            suspenderOxigeno = "";
        } else {
            rendereNodOxigeno = false;
            descripoOxigeno = "";
            suspenderOxigeno = "";
        }
    }
    /**
     * @param valueChangeEvent
     */
    public void setOxigeno(ValueChangeEvent valueChangeEvent) {
        Chcontroorden formulaAdd = null;
            formulaAdd = (Chcontroorden)this.dtOtrasOrdenes.getRowData();
        setNoOxigeno((String)valueChangeEvent.getNewValue());
        formulaAdd.setHcoccadminisoxig((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setOxigenoCE(ValueChangeEvent valueChangeEvent) {
        Chcontroorden formulaAdd = null;
            formulaAdd = (Chcontroorden)this.dtOtrasOrdenesCE.getRowData();
        setNoOxigeno((String)valueChangeEvent.getNewValue());
        formulaAdd.setHcoccadminisoxig((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void changeNoOxigenoSuspender() {
       
    }
    /**
     * @param cirugia
     */
    public void setCirugia(Chcirugprogr cirugia) {
        this.cirugia = cirugia;
    }

    /**
     * @return
     */
    public Chcirugprogr getCirugia() {
        return cirugia;
    }

    /**
     * @param esIngreso
     */
    public void setEsIngreso(boolean esIngreso) {
        this.esIngreso = esIngreso;
    }

    /**
     * @return
     */
    public boolean isEsIngreso() {
        return esIngreso;
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
     * @return
     */
    public String siguiente() {
        return BeanNavegacion.RUTA_IR_INGRESO_MEDICAMENTOS;
    }


    public void setDetalleCirugia(Chdetacirpro detalleCirugia) {
        this.detalleCirugia = detalleCirugia;
    }

    public Chdetacirpro getDetalleCirugia() {
        return detalleCirugia;
    }

    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }


    public void setUsuarioSystem(String usuarioSystem) {
        this.usuarioSystem = usuarioSystem;
    }

    public String get_usuarioSystem() {
        return usuarioSystem;
    }


    public void setLstCirugias(List lstCirugias) {
        this.lstCirugias = lstCirugias;
    }

    public List getLstCirugias() {
        return lstCirugias;
    }

    public void setDtCirugias(HtmlDataTable dtCirugias) {
        this.dtCirugias = dtCirugias;
    }

    public HtmlDataTable getDtCirugias() {
        return dtCirugias;
    }

    public void setLstOtrasOrdenes(List<Chcontroorden> lstOtrasOrdenes) {
        this.lstOtrasOrdenes = lstOtrasOrdenes;
    }

    public List<Chcontroorden> getLstOtrasOrdenes() {
        return lstOtrasOrdenes;
    }

    public void setDtOtrasOrdenes(HtmlDataTable dtOtrasOrdenes) {
        this.dtOtrasOrdenes = dtOtrasOrdenes;
    }

    public HtmlDataTable getDtOtrasOrdenes() {
        return dtOtrasOrdenes;
    }

    public void setLstOrdenSelect(List<Chcontroorden> lstOrdenSelect) {
        this.lstOrdenSelect = lstOrdenSelect;
    }

    public List<Chcontroorden> getLstOrdenSelect() {
        return lstOrdenSelect;
    }
    
    /**
     * @param navegationRule
     */
    public void setNavegationRule(String navegationRule) {
        this.navegationRule = navegationRule;
    }

    public void setLstOtrasOrdenesRealizadas(List<Chcontroorden> lstOtrasOrdenesRealizadas) {
        this.lstOtrasOrdenesRealizadas = lstOtrasOrdenesRealizadas;
    }

    public List<Chcontroorden> getLstOtrasOrdenesRealizadas() {
        return lstOtrasOrdenesRealizadas;
    }

    public void setDtOtrasOrdenesRealizadas(HtmlDataTable dtOtrasOrdenesRealizadas) {
        this.dtOtrasOrdenesRealizadas = dtOtrasOrdenesRealizadas;
    }

    public HtmlDataTable getDtOtrasOrdenesRealizadas() {
        return dtOtrasOrdenesRealizadas;
    }

    public void setRenderedOxigeno(boolean renderedOxigeno) {
        this.renderedOxigeno = renderedOxigeno;
    }

    public boolean isRenderedOxigeno() {
        return renderedOxigeno;
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

    public void setRendereNodOxigeno(boolean rendereNodOxigeno) {
        this.rendereNodOxigeno = rendereNodOxigeno;
    }

    public boolean isRendereNodOxigeno() {
        return rendereNodOxigeno;
    }


    public void setNoOxigeno(String noOxigeno) {
        this.noOxigeno = noOxigeno;
    }

    public String getNoOxigeno() {
        return noOxigeno;
    }

    public void setDescripoOxigeno(String descripoOxigeno) {
        this.descripoOxigeno = descripoOxigeno;
    }

    public String getDescripoOxigeno() {
        return descripoOxigeno;
    }


    public void setRenderedOxigenoSuspender(Boolean renderedOxigenoSuspender) {
        this.renderedOxigenoSuspender = renderedOxigenoSuspender;
    }

    public Boolean getRenderedOxigenoSuspender() {
        return renderedOxigenoSuspender;
    }

    public void setSuspenderOxigeno(String suspenderOxigeno) {
        this.suspenderOxigeno = suspenderOxigeno;
    }

    public String getSuspenderOxigeno() {
        return suspenderOxigeno;
    }

    public void setRenderOxigenoCriterio(Boolean renderOxigenoCriterio) {
        this.renderOxigenoCriterio = renderOxigenoCriterio;
    }

    public Boolean getRenderOxigenoCriterio() {
        return renderOxigenoCriterio;
    }

    public void setFormulaAdd(Chcontroorden formulaAdd) {
        this.formulaAdd = formulaAdd;
    }

    public Chcontroorden getFormulaAdd() {
        return formulaAdd;
    }

    public void setMinutosAdmOxigeno(int minutosAdmOxigeno) {
        this.minutosAdmOxigeno = minutosAdmOxigeno;
    }

    public int getMinutosAdmOxigeno() {
        return minutosAdmOxigeno;
    }

    public void setLstOtrasOrdenesCE(List<Chcontroorden> lstOtrasOrdenesCE) {
        this.lstOtrasOrdenesCE = lstOtrasOrdenesCE;
    }

    public List<Chcontroorden> getLstOtrasOrdenesCE() {
        return lstOtrasOrdenesCE;
    }

    public void setDtOtrasOrdenesCE(HtmlDataTable dtOtrasOrdenesCE) {
        this.dtOtrasOrdenesCE = dtOtrasOrdenesCE;
    }

    public HtmlDataTable getDtOtrasOrdenesCE() {
        return dtOtrasOrdenesCE;
    }

    public void setLstOtrasOrdenesRealizadasCE(List<Chcontroorden> lstOtrasOrdenesRealizadasCE) {
        this.lstOtrasOrdenesRealizadasCE = lstOtrasOrdenesRealizadasCE;
    }

    public List<Chcontroorden> getLstOtrasOrdenesRealizadasCE() {
        return lstOtrasOrdenesRealizadasCE;
    }

    public void setLstConsclin(List<Cnconsclin> lstConsclin) {
        this.lstConsclin = lstConsclin;
    }

    public List<Cnconsclin> getLstConsclin() {
        return lstConsclin;
    }
}
