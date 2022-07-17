//=======================================================================
// ARCHIVO ResultadoLecturaUnoBean.java
// FECHA CREACI�N: 16/09/2010
// AUTOR: Jhon Carranza Silva
// Descripci�n: Registro de los resultados de la primera lectura.
//=======================================================================

package org.profamilia.hc.view.backing.procedimiento;



import java.util.ArrayList;

import java.util.Date;

import java.util.List;



import javax.faces.component.html.HtmlDataTable;

import javax.faces.model.SelectItem;
import org.profamilia.hc.model.dto.Chdetaentcito;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.dto.Cncitolect;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cncitovphlect;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IConstantes;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE ResultadoLecturaUnoBean
//=======================================================================
public class ReprocesoWSSaludTotalBean extends BaseBean  {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    List<Chdetaentcito> listadoCitologias = new ArrayList<Chdetaentcito>();

    List<Chdetaentcito> listadoCitologias_mod = new ArrayList<Chdetaentcito>();

    List<Chdetaentcito> listadoCitologias_sel = new ArrayList<Chdetaentcito>();

    private String imprimeListado;

    private List<Cnconsclin>lstCnconsclin;
    
    private Date fechaInicio;
    private Date fechaFin;
    private Integer numDocPac;
    private List<SelectItem>lstBusquedas;
    private String busquedaSelected;
    private HtmlDataTable dtlstCnconsclin;




    public ReprocesoWSSaludTotalBean() {
    }

    public void init() {
    
        listadoCitologias = new ArrayList<Chdetaentcito>();
        listadoCitologias_mod = new ArrayList<Chdetaentcito>();
        listadoCitologias_sel = new ArrayList<Chdetaentcito>();
        imprimeListado = "N";

    }
    public String generarConsultas(){
        try {
            lstCnconsclin = serviceLocator.getClinicoService().getConsultasSaludTotal(fechaInicio,fechaFin,getClinica().getCclncodigo()
            ,numDocPac,IConstantes.NUM_CONTRATO_SALUDTOTAL1,IConstantes.NUM_CONTRATO_SALUDTOTAL2,busquedaSelected);
          
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }
        return null;
    }
    
    public String reprocesarWS(){
        try {       
            if(lstCnconsclin !=null &&!lstCnconsclin.isEmpty()){
                for(int i = 0;i<lstCnconsclin.size();i++){
                    //BIOPSIAS
                if(lstCnconsclin.get(i).isItemSelect()){
                    if(busquedaSelected.equals("BIO")){
                     Chmotivocon motivo =
                         this.serviceLocator.getClinicoService().getMotivoConsulta(new Long(lstCnconsclin.get(i).getCconnumero()));
                         if(motivo!=null && motivo.getHmcctrapatol() != null && motivo.getHmcctrapatol().equals("S") && "CX".equals(motivo.getHmcctippatol())){
                             //ENVIAR WS PARA BIOPSIAS
                         }
                    }
                    //COLPOSCOPIAS
                     if(busquedaSelected.equals("COL")){
                     Chimprdiag impresion= 
                             this.serviceLocator.getClinicoService().getImresionDiagnostica(new Long(lstCnconsclin.get(i).getCconnumero()), 
                                                                                            1);
                        if(impresion !=null){
                            //ENVIAR WS PARA COLPOSCOPIAS
                        }
                         
                     }
                     //CBL
                      if(busquedaSelected.equals("CBL")){
                         Cncitologi citologia = 
                                  this.serviceLocator.getClinicoService().getCitologiaByAdmisionAndTipoHistoria(lstCnconsclin.get(i), 
                                                                                                              IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA);
                          if (citologia == null) {
                              citologia = 
                                      this.serviceLocator.getClinicoService().getCitologiaByAdmisionAndTipoHistoria(lstCnconsclin.get(i), 
                                                                                                                  IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA_BASELIQUIDA);
                          }
                              
                              if(citologia == null){
                                  citologia = 
                                          this.serviceLocator.getClinicoService().getCitologiaByAdmisionAndTipoHistoria(lstCnconsclin.get(i), 
                                                                                                                        IConstantes.HISTORIA_PROCEDIMIENTO_VPH_TOMA);
                              }       
                          if(citologia ==null){
                            citologia = this.serviceLocator.getClinicoService().getUsuarioCitologia(lstCnconsclin.get(i));
                          }
                           if(citologia!=null) {                                                                                  
                                Cncitolect lectura = 
                                    this.serviceLocator.getClinicoService().getLecturaCitologia(citologia.getCcinconsec());
                                    if(lectura!=null){
                                        //ENVIAR WS PARA CBL
                                        
                                    }
                           }   
                      }
                      //VPH
                      else{
                         Cncitologi citologia = 
                                  this.serviceLocator.getClinicoService().getCitologiaByAdmisionAndTipoHistoria(lstCnconsclin.get(i), 
                                                                                                                IConstantes.HISTORIA_PROCEDIMIENTO_VPH_TOMA);
                        if(citologia ==null){
                          citologia = 
                                  this.serviceLocator.getClinicoService().getCitologiaByAdmisionAndTipoHistoria(lstCnconsclin.get(i), 
                                                                                                                IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA_BASELIQUIDA);
                        }
                        if(citologia ==null){
                          citologia = this.serviceLocator.getClinicoService().getUsuarioCitologia(lstCnconsclin.get(i));
                        }
                          if(citologia!=null) {                                                                                  
                              Cncitovphlect lectura = this.serviceLocator.getClinicoService().getLecturaCitologiaVph(citologia.getCcinconsec());
                                   if(lectura!=null){
                                       serviceLocator.getClinicoService().envioResultadosVphSaludTotal(lstCnconsclin.get(i).getCcolusuario(),lstCnconsclin.get(i),lectura);                                
                                   }
                          }  
                          
                          
                      }
                    }
                }
            }
                
            
            
            
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_GUARDADO);
        }
        return null;
     
    }
    public void activarTodos(){
        for(int i = 0;i<lstCnconsclin.size();i++){
            lstCnconsclin.get(i).setItemSelect(true);
        }
    }
    public void desactivarTodos(){
        for(int i = 0;i<lstCnconsclin.size();i++){
            lstCnconsclin.get(i).setItemSelect(false);
        }        
    }

    public void setLstBusquedas(List<SelectItem> lstBusquedas) {
        this.lstBusquedas = lstBusquedas;
    }

    public List<SelectItem> getLstBusquedas() {
        if(lstBusquedas == null || lstBusquedas.isEmpty()){
            lstBusquedas = new ArrayList<SelectItem>();
            lstBusquedas.add(new SelectItem("CBL","Citologia en base l�quida "));
            lstBusquedas.add(new SelectItem("VPH","VPH"));
            lstBusquedas.add(new SelectItem("COL","Colposcopia"));
            lstBusquedas.add(new SelectItem("BIO","Biopsia"));
           
        }
        return lstBusquedas;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setNumDocPac(Integer numDocPac) {
        this.numDocPac = numDocPac;
    }

    public Integer getNumDocPac() {
        return numDocPac;
    }

    public void setBusquedaSelected(String busquedaSelected) {
        this.busquedaSelected = busquedaSelected;
    }

    public String getBusquedaSelected() {
        return busquedaSelected;
    }

    public void setLstCnconsclin(List<Cnconsclin> lstCnconsclin) {
        this.lstCnconsclin = lstCnconsclin;
    }

    public List<Cnconsclin> getLstCnconsclin() {
        return lstCnconsclin;
    }

    public void setDtlstCnconsclin(HtmlDataTable dtlstCnconsclin) {
        this.dtlstCnconsclin = dtlstCnconsclin;
    }

    public HtmlDataTable getDtlstCnconsclin() {
        return dtlstCnconsclin;
    }
}

