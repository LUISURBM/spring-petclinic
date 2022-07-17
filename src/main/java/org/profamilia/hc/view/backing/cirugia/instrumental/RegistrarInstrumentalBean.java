package org.profamilia.hc.view.backing.cirugia.instrumental;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chinstrument;
import org.profamilia.hc.model.dto.Chitemmater;
import org.profamilia.hc.model.dto.Chitempaque;
import org.profamilia.hc.model.dto.Chmaterinstr;
import org.profamilia.hc.model.dto.Chpaqueester;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;


public class RegistrarInstrumentalBean extends BaseBean {


    private List<SelectItem> lstMaterialInstrumental; 
    
    private List<SelectItem> lstPaqueteInstrumental; 
    
    private List<Chitemmater> lstItemMaterial; 
    
    private Chitemmater itemMaterial; 
    
    private Chitempaque itemPaquete; 
    
    private List<Chitempaque> lstItemPaquete; 
    
    private Chinstrument instrumental; 
    
    private List<SelectItem> lstOpciones; 
    
    private boolean renderPaquetes; 
    
    private boolean renderCalorHumedo; 
    
    private List lstTipoEsterilizacion; 
    
    private boolean renderMateriales; 
    
    private Long numeroCirugia; 
    
    private HtmlDataTable dtPaquete; 
    
    private HtmlDataTable dtMaterial; 
    
    private String url; 
    
    private Chusuario usuario; 
    
    


    public RegistrarInstrumentalBean() {
    }
    
    
    public void init(){
    
        url = "body:listaDetalleRegistrarInstrumentalForm:panelTabListaDetalleRegistrarInstrumental:"; 
      
        itemMaterial = new Chitemmater(); 
        itemPaquete = new Chitempaque(); 
        
       
      
        
        if(numeroCirugia!= null){

            try {
                instrumental = serviceLocator.getCirugiaService().getInstrumentalByCirugia(numeroCirugia);
                lstItemMaterial = serviceLocator.getCirugiaService().getListaItemMaterialInstrumentalByCirugia(numeroCirugia);
                lstItemPaquete = serviceLocator.getCirugiaService().getListaItemPaqueteInstrumentalByCirugia(numeroCirugia);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        
        
        if(instrumental == null){
            instrumental = new Chinstrument(); 
        }else{
            if(instrumental.getHincpaqueester()!= null && instrumental.getHincpaqueester().equals("S")){
                renderPaquetes = true;
            }
            
            if(instrumental.getHincrealiconte()!= null && instrumental.getHincrealiconte().equals("S") ){
                 renderMateriales = true;
             }
        }
        
        if(lstItemMaterial == null || lstItemMaterial.isEmpty()){
            lstItemMaterial = new ArrayList<Chitemmater>(); 
        }
        
        if(lstItemPaquete == null || lstItemPaquete.isEmpty()){
            lstItemPaquete = new ArrayList<Chitempaque>();
        }
        
    }


    public String volver() {
        FacesUtils.resetManagedBean("registrarInstrumentalBean");
       return BeanNavegacion.RUTA_IR_INSTRUMENTADOR;
    }


    /**
     * @param lstMaterialInstrumental
     */
    public void setLstMaterialInstrumental(List<SelectItem> lstMaterialInstrumental) {
        this.lstMaterialInstrumental = lstMaterialInstrumental;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstMaterialInstrumental() {
        if (lstMaterialInstrumental == null || lstMaterialInstrumental.isEmpty() ) {
            lstMaterialInstrumental = new ArrayList<SelectItem>(); 
            ArrayList<Chmaterinstr> listMaterialAux = null;
            try {
                listMaterialAux = 
                        (ArrayList<Chmaterinstr>)this.serviceLocator.getCirugiaService().getListaMaterialInstrumentalByEstado(ESTADO_ACTIVO);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (listMaterialAux != null && !listMaterialAux.isEmpty()) {

                Iterator it = listMaterialAux.iterator();
                int i = 0;
                lstMaterialInstrumental.add(new SelectItem("", 
                                                  "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstMaterialInstrumental.add(new SelectItem(listMaterialAux.get(i).getHmincodigo(), 
                                                      listMaterialAux.get(i).getHmicdescripcio()));
                    i++;
                }
            }
        }
        return lstMaterialInstrumental;
        }


    /**
     * @param lstPaqueteInstrumental
     */
    public void setLstPaqueteInstrumental(List<SelectItem> lstPaqueteInstrumental) {
        this.lstPaqueteInstrumental = lstPaqueteInstrumental;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstPaqueteInstrumental() {
        if (lstPaqueteInstrumental == null || lstPaqueteInstrumental.isEmpty() ) {
            lstPaqueteInstrumental = new ArrayList<SelectItem>(); 
            ArrayList<Chpaqueester> listPaqueteAux = null;
            try {
                listPaqueteAux = 
                        (ArrayList<Chpaqueester>)this.serviceLocator.getCirugiaService().getListaPaqueteInstrumentalByEstado(ESTADO_ACTIVO);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (listPaqueteAux != null && !listPaqueteAux.isEmpty()) {

                Iterator it = listPaqueteAux.iterator();
                int i = 0;
                lstPaqueteInstrumental.add(new SelectItem("", 
                                                  "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstPaqueteInstrumental.add(new SelectItem(listPaqueteAux.get(i).getHpencodigo(), 
                                                      listPaqueteAux.get(i).getHpecdescripcio() ));
                    i++;
                }
            }
        }
        return lstPaqueteInstrumental;
        }


    /**
     * @param lstItemMaterial
     */
    public void setLstItemMaterial(List<Chitemmater> lstItemMaterial) {
        this.lstItemMaterial = lstItemMaterial;
    }

    /**
     * @return
     */
    public List<Chitemmater> getLstItemMaterial() {
        return lstItemMaterial;
    }

    /**
     * @param lstItemPaquete
     */
    public void setLstItemPaquete(List<Chitempaque> lstItemPaquete) {
        this.lstItemPaquete = lstItemPaquete;
    }

    /**
     * @return
     */
    public List<Chitempaque> getLstItemPaquete() {
        return lstItemPaquete;
    }

    /**
     * @param instrumental
     */
    public void setInstrumental(Chinstrument instrumental) {
        this.instrumental = instrumental;
    }

    /**
     * @return
     */
    public Chinstrument getInstrumental() {
        return instrumental;
    }

    /**
     * @param lstOpciones
     */
    public void setLstOpciones(List<SelectItem> lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstOpciones() {
     if(lstOpciones == null || lstOpciones.isEmpty()){
         lstOpciones = new ArrayList<SelectItem>();
         lstOpciones.add(new SelectItem("S","Si"));
         lstOpciones.add(new SelectItem("N","No"));
     }
        return lstOpciones;
    }

    /**
     * @param itemMaterial
     */
    public void setItemMaterial(Chitemmater itemMaterial) {
        this.itemMaterial = itemMaterial;
    }

    /**
     * @return
     */
    public Chitemmater getItemMaterial() {
        return itemMaterial;
    }

    /**
     * @param itemPaquete
     */
    public void setItemPaquete(Chitempaque itemPaquete) {
        this.itemPaquete = itemPaquete;
    }

    /**
     * @return
     */
    public Chitempaque getItemPaquete() {
        return itemPaquete;
    }

    /**
     * @param renderPaquetes
     */
    public void setRenderPaquetes(boolean renderPaquetes) {
        this.renderPaquetes = renderPaquetes;
    }

    /**
     * @return
     */
    public boolean isRenderPaquetes() {
        return renderPaquetes;
    }

    /**
     * @param renderCalorHumedo
     */
    public void setRenderCalorHumedo(boolean renderCalorHumedo) {
        this.renderCalorHumedo = renderCalorHumedo;
    }

    /**
     * @return
     */
    public boolean isRenderCalorHumedo() {
        return renderCalorHumedo;
    }

    /**
     * @param lstTipoEsterilizacion
     */
    public void setLstTipoEsterilizacion(List lstTipoEsterilizacion) {
        this.lstTipoEsterilizacion = lstTipoEsterilizacion;
    }

    /**
     * @return
     */
    public List getLstTipoEsterilizacion() {
        if(lstTipoEsterilizacion == null || lstTipoEsterilizacion.isEmpty()){
            lstTipoEsterilizacion = new ArrayList(); 
            lstTipoEsterilizacion.add(new SelectItem("","Seleccione una opci�n "));
            lstTipoEsterilizacion.add(new SelectItem("1","calor h�medo"));
            lstTipoEsterilizacion.add(new SelectItem("2","glutaraldeh�do"));
            lstTipoEsterilizacion.add(new SelectItem("3","�xido de etileno"));
        }
    
        return lstTipoEsterilizacion;
    }

    /**
     * @param renderMateriales
     */
    public void setRenderMateriales(boolean renderMateriales) {
        this.renderMateriales = renderMateriales;
    }

    /**
     * @return
     */
    public boolean isRenderMateriales() {
        return renderMateriales;
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
    
    
    public void adicionarMaterial(){
    
        boolean wexitoMaterial;
        boolean wexisteMaterial; 
        wexisteMaterial = false; 
        wexitoMaterial = true;
        
        if(itemMaterial== null ||itemMaterial.getId() == null || itemMaterial.getId().getHimncodigmater() == null){
            FacesUtils.addErrorMessage(url+"mnuMaterial", MSG_CAMPO_OBLIGATORIO);
            wexitoMaterial = false;
        }
        
        
        if(itemMaterial== null  || itemMaterial.getHimnprimeconte() == null){
            FacesUtils.addErrorMessage(url+"itConteoInicial", MSG_CAMPO_OBLIGATORIO);
            wexitoMaterial = false;
        }else if (itemMaterial.getHimnprimeconte()!= null 
               && ( itemMaterial.getHimnprimeconte().intValue() <= 0 ||  itemMaterial.getHimnprimeconte().intValue() > 100)){
                FacesUtils.addErrorMessage(url+"itConteoInicial", MSG_RANGO_CONTEO_INSTRUMENTAL);
                wexitoMaterial = false;
            }
        
        
        if(itemMaterial== null  || itemMaterial.getHimnadiciones() == null){
            FacesUtils.addErrorMessage(url+"itAdiciones", MSG_CAMPO_OBLIGATORIO);
            wexitoMaterial = false;
        }else if (itemMaterial.getHimnadiciones()!= null 
               && ( itemMaterial.getHimnadiciones().intValue() <= 0 ||  itemMaterial.getHimnadiciones().intValue() > 100)){
                FacesUtils.addErrorMessage(url+"itAdiciones", MSG_RANGO_CONTEO_INSTRUMENTAL);
                wexitoMaterial = false;
            }
        
        if(itemMaterial== null  || itemMaterial.getHimnsegunconte() == null){
            FacesUtils.addErrorMessage(url+"itConteoFinal", MSG_CAMPO_OBLIGATORIO);
            wexitoMaterial = false;
        }else if (itemMaterial.getHimnsegunconte()!= null 
               && ( itemMaterial.getHimnsegunconte().intValue() <= 0 ||  itemMaterial.getHimnsegunconte().intValue() > 100)){
                FacesUtils.addErrorMessage(url+"itConteoFinal", MSG_RANGO_CONTEO_INSTRUMENTAL);
                wexitoMaterial = false;
            }
        
        
        if(itemMaterial== null  || itemMaterial.getHimcobservacio() == null){
            FacesUtils.addErrorMessage(url+"itObservacionesConteoMaterial", MSG_CAMPO_OBLIGATORIO);
            wexitoMaterial = false;
        }
        
        
        if(itemMaterial!= null && itemMaterial.getId()!= null && itemMaterial.getId().getHimncodigmater() != null ){
            wexisteMaterial = verificarMaterial(itemMaterial.getId().getHimncodigmater());
            if(wexisteMaterial){
                FacesUtils.addErrorMessage(MSG_EXISTE_MATERIAL_INSTRUMENTAL);
                wexitoMaterial = false; 
            }
        }
        
        
        if(wexitoMaterial){
            itemMaterial.getId().setHimlcodiginstr(numeroCirugia);
            itemMaterial.setHimcestado(ESTADO_VIGENTE);
            itemMaterial.setHimcoperador(userName());
            itemMaterial.setHimdfecregistr(new Date());
            
            lstItemMaterial.add(itemMaterial);
            itemMaterial = new Chitemmater();    
        }
        
        
    }
    
    
    public void adicionarPaquete(){
        boolean wexitoPaquete;
        wexitoPaquete = true;
        boolean wexistePaquete; 
        wexistePaquete = true; 
        
        
        if(itemPaquete== null ||itemPaquete.getId() == null || itemPaquete.getId().getHipncodigpaque() == null){
            FacesUtils.addErrorMessage(url+"mnuContenido", MSG_CAMPO_OBLIGATORIO);
            wexitoPaquete = false;
        }
        
        
        if(itemPaquete== null ||itemPaquete.getHipctipoester()== null || itemPaquete.getHipctipoester().equals("")){
            FacesUtils.addErrorMessage(url+"mnuTipoEsterelizacion", MSG_CAMPO_OBLIGATORIO);
            wexitoPaquete = false;
        }
        
        if(itemPaquete== null ||itemPaquete.getHipdfechaester() == null){
            FacesUtils.addErrorMessage(url+"fechaEsterilizacion", MSG_CAMPO_OBLIGATORIO);
            wexitoPaquete = false;
        }
        
        if(itemPaquete== null ||itemPaquete.getHipdfechavenci() == null){
            FacesUtils.addErrorMessage(url+"fechaVencimiento", MSG_CAMPO_OBLIGATORIO);
            wexitoPaquete = false;
        }
        
        if(renderCalorHumedo){
            if(itemPaquete== null ||itemPaquete.getHipnnumercarga() == null){
                FacesUtils.addErrorMessage(url+"itNumeroCarga", MSG_CAMPO_OBLIGATORIO);
                wexitoPaquete = false;
            }else if (itemPaquete.getHipnnumercarga()!= null 
               && ( itemPaquete.getHipnnumercarga().intValue() <= 0 ||  itemPaquete.getHipnnumercarga().intValue() > 10)){
                FacesUtils.addErrorMessage(url+"itNumeroCarga", MSG_RANGO_NUMERO_CARGA);
                wexitoPaquete = false;
            }
            
            
            
            
            
            if(itemPaquete== null ||itemPaquete.getHipnnumerauto() == null){
                FacesUtils.addErrorMessage(url+"itNumeroAutoclave", MSG_CAMPO_OBLIGATORIO);
                wexitoPaquete = false;
            }else if (itemPaquete.getHipnnumerauto()!= null 
               && ( itemPaquete.getHipnnumerauto().intValue() <= 0 ||  itemPaquete.getHipnnumerauto().intValue() > 5)){
                FacesUtils.addErrorMessage(url+"itNumeroAutoclave", MSG_RANGO_NUMERO_AUTOCLAVE);
                wexitoPaquete = false;
            }
            
            
            
            
            if(itemPaquete== null ||itemPaquete.getHipcindicquimi() == null || itemPaquete.getHipcindicquimi().equals("")){
                FacesUtils.addErrorMessage(url+"mnuIndicadorQuimico", MSG_CAMPO_OBLIGATORIO);
                wexitoPaquete = false;
            }
            
        }else{
            itemPaquete.setHipnnumercarga(null); 
            itemPaquete.setHipnnumerauto(null); 
            itemPaquete.setHipcindicquimi(null); 
            
        }
        
        if(itemPaquete!= null && itemPaquete.getId()!= null && itemPaquete.getId().getHipncodigpaque()!= null ){
            wexistePaquete = verificarPaquete(itemPaquete.getId().getHipncodigpaque());
            if(wexistePaquete){
                FacesUtils.addErrorMessage(MSG_EXISTE_PAQUETE_INSTRUMENTAL);
                wexitoPaquete = false; 
            }
        }
        

     
    
        if(wexitoPaquete)    {
            itemPaquete.getId().setHiplcodiginstr(numeroCirugia);
            itemPaquete.setHipcestado(ESTADO_VIGENTE);
            itemPaquete.setHipcoperador(userName());
            itemPaquete.setHipdfecregistr(new Date());
            
            lstItemPaquete.add(itemPaquete);
            itemPaquete = new Chitempaque();
            renderCalorHumedo = false; 
        }
    
        
      
    }
    
    
    public boolean verificarPaquete(Integer codigoPaquete){
        boolean wexiste = false; 
        
        if(lstItemPaquete != null && !lstItemPaquete.isEmpty()){
            for(Chitempaque itemPaq: lstItemPaquete){
                if(itemPaq.getId().getHipncodigpaque().equals(codigoPaquete) && !wexiste){
                    wexiste = true; 
                }
            }
        }
        return wexiste; 
    }


    /**
     * @param codigoMaterial
     * @return
     */
    public boolean verificarMaterial(Integer codigoMaterial){
        boolean wexiste = false; 
        
        if(lstItemMaterial != null && !lstItemMaterial.isEmpty()){
            for(Chitemmater itemMat: lstItemMaterial){
                if(itemMat.getId().getHimncodigmater().equals(codigoMaterial) && !wexiste){
                    wexiste = true; 
                }
            }
        }
        return wexiste; 
    }
    
    public void editarPaquete(){
        renderCalorHumedo = false; 
        Chitempaque paqueteUpdate = (Chitempaque)dtPaquete.getRowData();
         if(paqueteUpdate!= null){
            lstItemPaquete.remove(paqueteUpdate);
            itemPaquete = paqueteUpdate; 
            if(paqueteUpdate.getHipctipoester()!= null && paqueteUpdate.getHipctipoester().equals("1")){
                renderCalorHumedo = true; 
            }
        }
    }
    
    public void eliminarPaquete(){
        Chitempaque paqueteDelete = (Chitempaque)dtPaquete.getRowData(); 
        if(paqueteDelete!= null){
            lstItemPaquete.remove(paqueteDelete);
        }
    }
    
    
    public void editarMaterial(){
        Chitemmater materialUpdate = (Chitemmater)dtMaterial.getRowData();
         if(materialUpdate!= null){
            lstItemMaterial.remove(materialUpdate);
            itemMaterial = materialUpdate; 
        }
    }
    
    public void eliminarMaterial(){
    
        Chitemmater materiaDelete = (Chitemmater)dtMaterial.getRowData(); 
        if(materiaDelete!= null){
            lstItemMaterial.remove(materiaDelete);
        }
    }


    /**
     * @param dtPaquete
     */
    public void setDtPaquete(HtmlDataTable dtPaquete) {
        this.dtPaquete = dtPaquete;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtPaquete() {
        return dtPaquete;
    }

    /**
     * @param dtMaterial
     */
    public void setDtMaterial(HtmlDataTable dtMaterial) {
        this.dtMaterial = dtMaterial;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtMaterial() {
        return dtMaterial;
    }

    public String guardarInstrumental() {
      
        
        instrumental.setHinlcirugia(numeroCirugia);
        instrumental.setHincestado(ESTADO_VIGENTE);
        instrumental.setHincoperador(userName());
        instrumental.setHindfecregistr(new Date());
        
        if(instrumental.getHincpaqueester()!= null && instrumental.getHincpaqueester().equals("N") ){
            instrumental.setHincrealiconte(null);
            lstItemMaterial = new ArrayList<Chitemmater>(); 
            lstItemPaquete = new ArrayList<Chitempaque>();
        }
        
        if(instrumental.getHincrealiconte() != null && instrumental.getHincrealiconte().equals("N") ){
            lstItemMaterial = new ArrayList<Chitemmater>(); 
        }


        try {
            serviceLocator.getCirugiaService().saveInstrumental(instrumental, lstItemMaterial, lstItemPaquete);
            FacesUtils.addInfoMessage(MSG_ADICION);
            return BeanNavegacion.RUTA_IR_INSTRUMENTADOR; 
        } catch (ModelException e) {
            FacesUtils.addErrorMessage("ERROR " + e.getMessage());
            e.printStackTrace();
           return BeanNavegacion.RUTA_ACTUAL; 
        }
       
    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    /**
     * @param valueChangeEvent
     */
    public void setHincpaqueester(ValueChangeEvent valueChangeEvent) {
        instrumental.setHincpaqueester((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
    
         
    
    public void changeUtilizaronPaquetes(){
     renderPaquetes = false; 
        if(instrumental != null){
            if(instrumental.getHincpaqueester()!= null && instrumental.getHincpaqueester().equals("S") ){
                renderPaquetes = true;
            }
        }
    }
    
    
    public void changeConteoMateriales(){
        renderMateriales = false; 
           if(instrumental != null){
               if(instrumental.getHincrealiconte()!= null && instrumental.getHincrealiconte().equals("S") ){
                   renderMateriales = true;
               }
           }
        }

    /**
     * @param valueChangeEvent
     */
    public void setHincrealiconte(ValueChangeEvent valueChangeEvent) {
        instrumental.setHincrealiconte((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setHipctipoester(ValueChangeEvent valueChangeEvent) {
        itemPaquete.setHipctipoester((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
    
    
    
    
    public void changeTipoEsterilizacion(){
        renderCalorHumedo = false; 
           if(itemPaquete != null){
               if(itemPaquete.getHipctipoester()!= null && itemPaquete.getHipctipoester().equals("1") ){
                   renderCalorHumedo = true;
               }
           }
        }
    
}
