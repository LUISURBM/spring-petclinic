package org.profamilia.hc.view.backing.cirugia.comun;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.cirugia.buscador.BuscadorFacturasBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class MantenimientoCirugiasBean extends BaseBean {


    private List<Chdetacirpro> lstCirugiasProgramadas;

    private HtmlDataTable dtCirugiasProgramadas;

    private List lstProfesionales;

    private Long numeroCirugia;

    private boolean renderAdicionarCirugia;

    private int selectedIndex;

    private List lstOpciones;

    private boolean deshabilitarMedicos;

    private String tieneFactura;

    private String idTipoDocumento;

    private BigDecimal numerodocumento;

    private List<Cnconsclin> lstCirugiasFactura;

    private Chusuario usuario;
    
    private HtmlDataTable dtFacturasCirugia; 
    
    private boolean renderFacturada; 
    
    private boolean renderSinFactura; 
    
    private Cpservicio servicio; 
    
    private HtmlDataTable dtServicios;

    private List lstExamenesCirugias;
    
    private boolean renderFacturas; 
    
    private boolean renderIconEliminar; 
    
    static int ACTIVAR_MODIFICAR_CIRUGIA = 1;
    
    static int ACTIVAR_BUSCADOR_FACTURAS = 2;
    


    public MantenimientoCirugiasBean() {
    }

    public void init() {
        servicio = new Cpservicio(); 
        cargarConsultas();
    }

    public void inicializarBean() {
        idTipoDocumento = "";
        numerodocumento = null;
    }


    /**
     * @param lstProfesionales
     */
    public void setLstProfesionales(List lstProfesionales) {
        this.lstProfesionales = lstProfesionales;
    }

    /**
     * @return
     */
    public List getLstProfesionales() {
        if (lstProfesionales == null || lstProfesionales.isEmpty()) {
            lstProfesionales = new ArrayList();
            ArrayList<Cpprofesio> listProfesionalesAux = null;
            try {
                listProfesionalesAux = 
                        (ArrayList<Cpprofesio>)this.serviceLocator.getCirugiaService().getListaMedicosClinica(getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listProfesionalesAux.isEmpty()) {

                Iterator it = listProfesionalesAux.iterator();
                int i = 0;
                lstProfesionales.add(new SelectItem("", 
                                                    "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstProfesionales.add(new SelectItem(listProfesionalesAux.get(i).getId().getCpfncodigo(), 
                                                        listProfesionalesAux.get(i).getCpfcnombre()));
                    i++;
                }
            }
        }

        return lstProfesionales;
    }

    /**
     * @param lstCirugiasProgramadas
     */
    public void setLstCirugiasProgramadas(List<Chdetacirpro> lstCirugiasProgramadas) {
        this.lstCirugiasProgramadas = lstCirugiasProgramadas;
    }

    /**
     * @return
     */
    public List<Chdetacirpro> getLstCirugiasProgramadas() {
        return lstCirugiasProgramadas;
    }

    /**
     * @param dtCirugiasProgramadas
     */
    public void setDtCirugiasProgramadas(HtmlDataTable dtCirugiasProgramadas) {
        this.dtCirugiasProgramadas = dtCirugiasProgramadas;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCirugiasProgramadas() {
        return dtCirugiasProgramadas;
    }

    /**
     * @param numeroCirugia
     */
    public void setNumeroCirugia(Long numeroCirugia) {
        this.numeroCirugia = numeroCirugia;
    }

    /**
     * @return
     */
    public Long getNumeroCirugia() {
        return numeroCirugia;
    }


    /**
     * @param renderAdicionarCirugia
     */
    public void setRenderAdicionarCirugia(boolean renderAdicionarCirugia) {
        this.renderAdicionarCirugia = renderAdicionarCirugia;
    }

    /**
     * @return
     */
    public boolean isRenderAdicionarCirugia() {
        return renderAdicionarCirugia;
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
     * @param lstOpciones
     */
    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    /**
     * @return
     */
    public List getLstOpciones() {
        if (lstOpciones == null) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));

        }
        return lstOpciones;
    }

    /**
     * @param deshabilitarMedicos
     */
    public void setDeshabilitarMedicos(boolean deshabilitarMedicos) {
        this.deshabilitarMedicos = deshabilitarMedicos;
    }

    /**
     * @return
     */
    public boolean isDeshabilitarMedicos() {
        return deshabilitarMedicos;
    }

    /**
     * @param tieneFactura
     */
    public void setTieneFactura(String tieneFactura) {
        this.tieneFactura = tieneFactura;
    }

    /**
     * @return
     */
    public String getTieneFactura() {
        return tieneFactura;
    }


    /**
     * @param idTipoDocumento
     */
    public void setIdTipoDocumento(String idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    /**
     * @return
     */
    public String getIdTipoDocumento() {
        return idTipoDocumento;
    }

    /**
     * @param numerodocumento
     */
    public void setNumerodocumento(BigDecimal numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    /**
     * @return
     */
    public BigDecimal getNumerodocumento() {
        return numerodocumento;
    }

    /**
     * @param lstCirugiasFactura
     */
    public void setLstCirugiasFactura(List<Cnconsclin> lstCirugiasFactura) {
        this.lstCirugiasFactura = lstCirugiasFactura;
    }

    /**
     * @return
     */
    public List<Cnconsclin> getLstCirugiasFactura() {
        return lstCirugiasFactura;
    }

    /**
     * @param dtFacturasCirugia
     */
    public void setDtFacturasCirugia(HtmlDataTable dtFacturasCirugia) {
        this.dtFacturasCirugia = dtFacturasCirugia;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtFacturasCirugia() {
        return dtFacturasCirugia;
    }


    public void volverConsulta() {
        selectedIndex = 0;
        renderAdicionarCirugia = false;
    }

    public void adicionarCirugias() {
        selectedIndex = 1;
        renderAdicionarCirugia = true;
    }

    public String buscadorDoc() {
        Integer idTipoDoc = null;
        boolean wexito = true;
        if (idTipoDocumento != null && !idTipoDocumento.equals("")) {
            idTipoDoc = Integer.parseInt(idTipoDocumento);
        }


        if (idTipoDocumento == null || idTipoDocumento.equals("")) {
            FacesUtils.addErrorMessage(MSG_CAMPO_OBLIGATORIO_TIPO_DOCUMENTO);
            wexito = false;
        }

        if (numerodocumento == null) {
            FacesUtils.addErrorMessage(MSG_CAMPO_OBLIGATORIO_NUMERO_DOCUMENTO);
            wexito = false;
        }


        if (wexito) {
            try {
                lstCirugiasFactura = 
                        this.serviceLocator.getCirugiaService().getConsultasCirugia(idTipoDoc, 
                                                                                    numerodocumento, 
                                                                                    usuario);
            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }

            if (lstCirugiasFactura == null || lstCirugiasFactura.isEmpty()) {
                FacesUtils.addErrorMessage(MSG_CIRUGIA_NO_EXISTE);
            }

        }

        return null;
    }

    public String cargarConsultas() {
        List<Object[]> lstCirugiasAux = null;
        lstCirugiasProgramadas = new ArrayList<Chdetacirpro>();
        try {
            if (numeroCirugia != null) {
                lstCirugiasAux = 
                        this.serviceLocator.getClinicoService().getListaDetalleCirugiasProgramadas(numeroCirugia);

                if (lstCirugiasAux != null && !lstCirugiasAux.isEmpty()) {
                    for (Object[] cirugiAux: lstCirugiasAux) {
                        BigDecimal codigoPrincipalBig = 
                            (BigDecimal)cirugiAux[0];

                        Long codigoPrincipal = null;
                        if (codigoPrincipalBig != null) {
                            codigoPrincipal = codigoPrincipalBig.longValue();
                        }

                        String codigoServicio = (String)cirugiAux[1];
                        String nombreServicio = (String)cirugiAux[2];
                        Chdetacirpro detalleObject = null;

                        detalleObject = 
                                this.serviceLocator.getClinicoService().getCirugiaDetallada(codigoPrincipal, 
                                                                                            codigoServicio);

                        if (detalleObject != null) {
                            detalleObject.setHdccdescrservi(nombreServicio);
                            lstCirugiasProgramadas.add(detalleObject);
                        }
                    }
                }


            }


        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }

        return null;
    }
    
    
 
    /**
     * @param renderFacturada
     */
    public void setRenderFacturada(boolean renderFacturada) {
        this.renderFacturada = renderFacturada;
    }

    /**
     * @return
     */
    public boolean isRenderFacturada() {
        return renderFacturada;
    }

    /**
     * @param renderFacturas
     */
    public void setRenderFacturas(boolean renderFacturas) {
        this.renderFacturas = renderFacturas;
    }

    /**
     * @param renderIconEliminar
     */
    public void setRenderIconEliminar(boolean renderIconEliminar) {
        this.renderIconEliminar = renderIconEliminar;
    }

    /**
     * @return
     */
    public boolean isRenderIconEliminar() {
        return renderIconEliminar;
    }

    /**
     * @return
     */
    public boolean isRenderFacturas() {
        return renderFacturas;
    }

    /**
     * @param renderSinFactura
     */
    public void setRenderSinFactura(boolean renderSinFactura) {
        this.renderSinFactura = renderSinFactura;
    }

    /**
     * @return
     */
    public boolean isRenderSinFactura() {
        return renderSinFactura;
    }

    /**
     * @param servicio
     */
    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    /**
     * @return
     */
    public Cpservicio getServicio() {
        return servicio;
    }

    /**
     * @param dtServicios
     */
    public void setDtServicios(HtmlDataTable dtServicios) {
        this.dtServicios = dtServicios;
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
     * @return
     */
    public HtmlDataTable getDtServicios() {
        return dtServicios;
    }

    public void setTieneFactura(ValueChangeEvent valueChangeEvent) {
        setTieneFactura((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void changeFactura(){
    renderFacturada = false; 
    renderSinFactura = false; 
        if(tieneFactura!= null){
            if(tieneFactura.equals("S")){
                renderFacturada = true; 
            }else if (tieneFactura.equals("N")){
                renderSinFactura = true; 
            }
            
        }
    }
    
    
    public void consultarCirugias() {
    boolean wexitocirugia = true; 
    
    if(servicio == null || (servicio.getCsvccodigo()== null||servicio.getCsvccodigo().equals(""))
    &&(servicio.getCsvcnombre()== null || servicio.getCsvcnombre().equals(""))
    &&(servicio.getCsvcnombre2()== null || servicio.getCsvcnombre2().equals(""))
    &&(servicio.getCsvcnombre3()== null || servicio.getCsvcnombre3().equals(""))){
        wexitocirugia = false; 
    }
    
    if(wexitocirugia){
        dtServicios.setFirst(0);
        try {
            lstExamenesCirugias = 
                    this.serviceLocator.getClinicoService().getCirugiasPorCriterios(servicio);
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }else{
        lstExamenesCirugias = new ArrayList(); 
        FacesUtils.addErrorMessage(MSG_CRITERIOS_BUSQUEDA);
    }
    
        if(lstExamenesCirugias == null || lstExamenesCirugias.isEmpty()){
            FacesUtils.addErrorMessage(MSG_SIN_DATOS);
        }
        
    }
    
    public void eliminarCirugia(){
        Chdetacirpro detalle = null; 
        detalle = (Chdetacirpro)dtCirugiasProgramadas.getRowData(); 
        lstCirugiasProgramadas.remove(detalle); 
    }
    
    public void agregarServicio(){
        Cpservicio servicioAux = (Cpservicio)dtServicios.getRowData();
        boolean wexiste = false;
        
        if(lstCirugiasProgramadas!= null){
            for(Chdetacirpro detalle: lstCirugiasProgramadas){
                if(detalle.getId().getHdccservicio().equals(servicioAux.getCsvccodigo())){
                    wexiste = true; 
                }
            }
        }
        
        lstExamenesCirugias.remove(servicioAux);
        Chdetacirpro detaCirugiaObject = null; 
        if(!wexiste){
            detaCirugiaObject = new Chdetacirpro(); 
            detaCirugiaObject.setHdccestado(ESTADO_VIGENTE);
            detaCirugiaObject.setHdccoperaregis(userName());
            detaCirugiaObject.setHdcdfecharegis(new Date());
            detaCirugiaObject.setHdclconsuasoci(0L);
            detaCirugiaObject.setHdclusuario(usuario.getHuslnumero());
            detaCirugiaObject.setHdcnclinica(this.getClinica().getCclncodigo());
            detaCirugiaObject.setHdccdescrservi(servicioAux.getCsvcnombre());
            detaCirugiaObject.getId().setHdccservicio(servicioAux.getCsvccodigo());
            lstCirugiasProgramadas.add(detaCirugiaObject); 
        }else{
            FacesUtils.addErrorMessage(MSG_CIRUGIA_EXISTE);
        }
        

        if(lstCirugiasFactura == null || lstCirugiasFactura.isEmpty()){
           selectedIndex = 0;
           renderAdicionarCirugia = false;
        }

        }
        
        
    public String aceptarFacturas(){
        BuscadorFacturasBean buscador = (BuscadorFacturasBean)FacesUtils.getManagedBean("buscadorFacturasBean"); 
        Cnconsclin consultaObject = buscador.getConsultaObject(); 
        
        try {
        if(consultaObject != null && consultaObject.getCcontipdoc()!= null && consultaObject.getCcontipdoc().getCtdnnumero()!= null  && consultaObject.getCconnumdoc()!= null)
            lstCirugiasFactura = 
                    this.serviceLocator.getCirugiaService().getConsultasCirugia(consultaObject.getCcontipdoc().getCtdnnumero(), 
                                                                                consultaObject.getCconnumdoc(), 
                                                                                usuario);
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }
        
        selectedIndex = ACTIVAR_MODIFICAR_CIRUGIA;
        renderFacturas = false;
        return null;
    }
    
    public void mostrarBuscadorFacturas() {
        FacesUtils.resetManagedBean("buscadorFacturasBean");
        BuscadorFacturasBean buscador = (BuscadorFacturasBean)FacesUtils.getManagedBean("buscadorFacturasBean"); 
        buscador.setUsuario(usuario);
         selectedIndex = ACTIVAR_BUSCADOR_FACTURAS;
         renderFacturas = true;
    }
    
    
    public void agregarCirugia() {
        Cnconsclin consulAux = (Cnconsclin)dtFacturasCirugia.getRowData();
        boolean wexiste = false;
        
        if(lstCirugiasProgramadas!= null){
            for(Chdetacirpro detalle: lstCirugiasProgramadas){
                if(detalle.getId().getHdccservicio().equals(consulAux.getCcocservic().getCsvccodigo())){
                    wexiste = true; 
                }
            }
        }
        
        lstCirugiasFactura.remove(consulAux);
        Chdetacirpro detaCirugiaObject = null; 
        if(!wexiste){
            detaCirugiaObject = new Chdetacirpro(); 
            detaCirugiaObject.setHdccestado(ESTADO_VIGENTE);
            detaCirugiaObject.setHdccoperaregis(userName());
            detaCirugiaObject.setHdcdfecharegis(new Date());
            detaCirugiaObject.setHdclconsuasoci(new Long(consulAux.getCconnumero()));
            detaCirugiaObject.setHdclusuario(consulAux.getCcolusuario().getHuslnumero());
            detaCirugiaObject.setHdcnclinica(this.getClinica().getCclncodigo());
            detaCirugiaObject.setHdccdescrservi(consulAux.getCcocservic().getCsvcnombre());
            detaCirugiaObject.getId().setHdccservicio(consulAux.getCcocservic().getCsvccodigo());
            lstCirugiasProgramadas.add(detaCirugiaObject); 
        }else{
            FacesUtils.addErrorMessage(MSG_CIRUGIA_EXISTE);
        }
        

       if(lstCirugiasFactura == null || lstCirugiasFactura.isEmpty()){
           selectedIndex = 0;
           renderAdicionarCirugia = false;
       }

    }


   

    public void setACTIVAR_MODIFICAR_CIRUGIA(int aCTIVAR_MODIFICAR_CIRUGIA) {
        this.ACTIVAR_MODIFICAR_CIRUGIA = aCTIVAR_MODIFICAR_CIRUGIA;
    }

    public int getACTIVAR_MODIFICAR_CIRUGIA() {
        return ACTIVAR_MODIFICAR_CIRUGIA;
    }

    public void setACTIVAR_BUSCADOR_FACTURAS(int aCTIVAR_BUSCADOR_FACTURAS) {
        this.ACTIVAR_BUSCADOR_FACTURAS = aCTIVAR_BUSCADOR_FACTURAS;
    }

    public int getACTIVAR_BUSCADOR_FACTURAS() {
        return ACTIVAR_BUSCADOR_FACTURAS;
    }
}
