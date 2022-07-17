package org.profamilia.hc.view.backing.procedimiento.carga;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;


import org.apache.myfaces.custom.fileupload.UploadedFile;

import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Cncitolect;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.StringTokenizerStrict;

/**
 * Esta clase representa la p�gina de alta de documentos
 * @author Bea
 *
 */
public class UploadBean extends BaseBean {
   /** Fichero binario */
   private UploadedFile docDocumento;
   /** Descripci�n del documento */
   private String descripcion;
   /** Content-type del documento */
   private String contentType;   
      
   private List<Cncitolect> lstCitologia; 
      
   private Chconsulta consulta;
    
   private Cncitologi citologia;
    
   /** Almacena la tabla de citologias */
   private HtmlDataTable dtBucarEpicrisis;
      
   public void init(){
      try {
          if (consulta != null) {
             citologia = 
                   this.serviceLocator.getClinicoService().getUsuarioCitologia(consulta);
          }
      } catch (ModelException e) {
          e.printStackTrace();
      }
   }
      
   public UploadBean(){}

   public String getContentType() {
      return contentType;
   }

   public void setContentType(String contentType) {
      this.contentType = contentType;
   }

   public String getDescripcion() {
      return descripcion;
   }
   
   public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
   }
   
   public UploadedFile getDocDocumento() {
      return docDocumento;
   }

   public void setDocDocumento(UploadedFile docDocumento) {
      this.docDocumento = docDocumento;
   }
   
   /**
   *  Efect�a el upload del fichero
   */
   public String upload() throws IOException {
      try {
         FacesContext facesContext = FacesContext.getCurrentInstance();
         facesContext.getExternalContext().getApplicationMap().put("fileupload_bytes",
                                                                   docDocumento.getBytes());
         facesContext.getExternalContext().getApplicationMap().put("fileupload_type",     
                                                                   docDocumento.getContentType());
         facesContext.getExternalContext().getApplicationMap().put("fileupload_name",
                                                                   docDocumento.getName());
         ByteArrayInputStream inStream = new ByteArrayInputStream(docDocumento.getBytes());
         ByteArrayOutputStream theBOS = new ByteArrayOutputStream();
        
         byte buf[] = docDocumento.getBytes();
         theBOS.write(buf);
         Cncitolect citolect = null; 
        
         lstCitologia = new ArrayList<Cncitolect>();
         Scanner scanner = new Scanner(inStream);
         while(scanner.hasNextLine()){
            citolect = new Cncitolect();
              
            Integer clcnclinic = null; 
            Integer clcnnumero = null;
            Date clcdprilec = null;
            String clccprilec = null;
            String clccnompri = null;
            Date clcdseglec = null;
            String clccseglec = null;
            String clccnomseg = null;
            String clcccalmue = null;
            String clccmicorg = null;
            String clccotrmic = null;
            String clcccatego = null;
            String clccotrhal = null;
            String clccanoesc = null;
            String clccanogla = null;
            String clccotrneo = null;
            String clccobserv = null;
            Integer clcnconsec = null;
            String clccnumpri = null;
            String clccnumseg = null;
            StringTokenizerStrict stk = 
                  new StringTokenizerStrict(scanner.nextLine(), ",");
                       
            int i = 0;
            boolean o;
            o = false;
              
            String token;
            while (stk.hasMoreTokens()) {
                token = (String)stk.nextElement();
                i++; 
                if(i == 1 && token != null && !token.equals("")){
                    try{
                        o = true;
                        clcnclinic = new Integer(token);  
                    }catch(Exception e){
                        FacesUtils.addErrorMessage(MSG_INVALIDO_DATO_EN_clcnclinic  +  e.getMessage());
                    }
                }              
                if(i == 2 && token != null && !token.equals("")){
                    try{
                        o = true;
                        clcnnumero = new Integer(token);
                    }catch(Exception e){
                        FacesUtils.addErrorMessage(MSG_INVALIDO_DATO_EN_clcnnumero  +  e.getMessage());
                    }
                }
                if(i == 3 && token != null && !token.equals("")){
                    try{            
                        clcdprilec = formatearCampoStringToDate(token);
                        citolect.setClcdprilec(clcdprilec);
                    }catch(Exception e){
                        FacesUtils.addErrorMessage(MSG_INVALIDO_DATO_EN_clcdprilec + e.getMessage());
                    }
                }
                if(i == 4 && token != null && !token.equals("")){
                    try{
                        clccprilec = new String(token);
                    } catch(Exception e) {
                        FacesUtils.addErrorMessage(MSG_INVALIDO_DATO_EN_clccprilec  +  e.getMessage());
                    }
                }
                if(i == 5 && token != null && !token.equals("")){
                    try{
                        clccnompri = new String(token);
                    }catch(Exception e){
                        FacesUtils.addErrorMessage(MSG_INVALIDO_DATO_EN_clccnompri + e.getMessage());
                    }
                }
                if(i == 6 && !token.equals("") && token!= null) {
                    try{
                        clcdseglec = formatearCampoStringToDate(token);
                        citolect.setClcdseglec(clcdseglec);
                    }catch(Exception e){
                        FacesUtils.addErrorMessage(MSG_INVALIDO_DATO_EN_clcdseglec + e.getMessage());
                    }
                }
                if(i == 7 && token != null && !token.equals("") && !token.trim().equals("null")){
                    try{
                        clccseglec = new String(token);
                    } catch(Exception e) {
                        FacesUtils.addErrorMessage(MSG_INVALIDO_DATO_EN_clccseglec + e.getMessage());
                    }
                }
                if(i == 8 && token != null && !token.equals("") && !token.trim().equals("null")){
                    try {
                        clccnomseg = new String(token);
                    } catch(Exception e) {
                        FacesUtils.addErrorMessage(MSG_INVALIDO_DATO_EN_clccnomseg + e.getMessage());
                    }
                }
                if(i == 9 && token != null && !token.equals("")){
                    try {
                        clcccalmue = new String(token);
                    } catch(Exception e) {
                        FacesUtils.addErrorMessage(MSG_INVALIDO_DATO_EN_clcccalmue + e.getMessage());
                    }
                }
                if(i == 10 && token != null && !token.equals("")){
                    try {
                        clccmicorg= new String(token);
                    } catch(Exception e) {
                        FacesUtils.addErrorMessage(MSG_INVALIDO_DATO_EN_clccmicorg + e.getMessage());
                    }
                }
                if(i == 11 && token != null && !token.equals("")  && !token.trim().equals("null")){
                    try {
                        clccotrmic =  new String(token);   
                    } catch(Exception e) {
                        FacesUtils.addErrorMessage(MSG_INVALIDO_DATO_EN_clccotrmic + e.getMessage());
                    }
                }
                if(i == 12 && token != null && !token.equals("")){
                    try {
                        clcccatego = new String(token);
                    } catch(Exception e) {
                        FacesUtils.addErrorMessage(MSG_INVALIDO_DATO_EN_clcccatego + e.getMessage());
                    }
                }
                if(i == 13 && token != null && !token.equals("") && !token.trim().equals("null")){
                    try {
                        clccotrhal = new String(token);
                    } catch(Exception e) {
                        FacesUtils.addErrorMessage(MSG_INVALIDO_DATO_EN_clcccatego + e.getMessage());
                    }
                }
                if(i == 14 && token != null && !token.equals("")){
                    try {
                        clccanoesc = new String(token);
                    } catch(Exception e) {
                        FacesUtils.addErrorMessage(MSG_INVALIDO_DATO_EN_clccanoesc + e.getMessage());
                    }
                }
                if(i == 15 && token != null && !token.equals("")){
                    try {
                        clccanogla = new String(token);
                    } catch(Exception e) {
                        FacesUtils.addErrorMessage(MSG_INVALIDO_DATO_EN_clccanogla + e.getMessage());
                    }
                }
                if(i == 16 && token != null && !token.equals("")  && !token.trim().equals("null")){
                    try {
                        clccotrneo = new String(token);
                    } catch(Exception e) {
                        FacesUtils.addErrorMessage(MSG_INVALIDO_DATO_EN_clccotrneo + e.getMessage());
                    }
                }
                if(i == 17 && token != null && !token.equals("") && !token.trim().equals("null")){
                    try {
                        clccobserv = new String(token);
                    } catch(Exception e) {
                        FacesUtils.addErrorMessage(MSG_INVALIDO_DATO_EN_clccobserv + e.getMessage());
                    }
                }
                if(i == 18 && token != null && !token.equals("")){
                    try{
                        o = true;
                        clcnconsec = new Integer(token);
                    }catch(Exception e){
                        FacesUtils.addErrorMessage(MSG_INVALIDO_DATO_EN_clcnconsec + e.getMessage());
                    }
                }
                if(i == 19 && token !=null && !token.equals("")){
                    try{
                        o = true;
                        clccnumpri = new String(token);
                    }catch(Exception e){
                        FacesUtils.addErrorMessage(MSG_INVALIDO_DATO_EN_clccnumpri + e.getMessage());
                    }
                }
                if(i == 20 && token != null && !token.equals("") && !token.trim().equals("null")){
                    try{
                        o = true;
                        clccnumseg = new String(token);
                    }catch(Exception e){
                        FacesUtils.addErrorMessage(MSG_INVALIDO_DATO_EN_clccnumseg + e.getMessage());
                    }
                }
            }
              
            citolect.setClcnclinic(clcnclinic);
            citolect.setClcnnumero(clcnnumero);
            citolect.setClcdprilec(clcdprilec); 
            citolect.setClccprilec(clccprilec);
            citolect.setClccnompri(clccnompri);
            citolect.setClcdseglec(clcdseglec);
            citolect.setClccseglec(clccseglec);
            citolect.setClccnomseg(clccnomseg);
            citolect.setClcccalmue(clcccalmue);
            citolect.setClccmicorg(clccmicorg);
            citolect.setClccotrmic(clccotrmic);
            citolect.setClcccatego(clcccatego);
            citolect.setClccotrhal(clccotrhal);
            citolect.setClccanoesc(clccanoesc);
            citolect.setClccanogla(clccanogla);
            citolect.setClccotrneo(clccotrneo);
            citolect.setClccobserv(clccobserv);
            citolect.setClccusureg(userName());           
            citolect.setClcdfecreg(new Date());
            citolect.setClcnconsec(clcnconsec);
            citolect.setClccnumpri(clccnumpri);
            citolect.setClccnumseg(clccnumseg);

            lstCitologia.add(citolect);
         } 
         scanner.close();
       
         serviceLocator.getClinicoService().savelstCitologia(lstCitologia);
         this.serviceLocator.getClinicoService().closeLecturaCitologia(consulta);
       
         FacesUtils.addInfoMessage(MSG_CARGA_VALIDA);
         return null;
      } catch(Exception ex) {
          ex.printStackTrace();
          FacesUtils.addErrorMessage((MSG_CARGA_NO_VALIDA + ex.getMessage()));
          return null;
      }
    }

    public void setLstCitologia(List<Cncitolect> lstCitologia) {
        this.lstCitologia = lstCitologia;
    }

    public List<Cncitolect> getLstCitologia() {
        return lstCitologia;
    }

    public void setDtBucarEpicrisis(HtmlDataTable dtBucarEpicrisis) {
        this.dtBucarEpicrisis = dtBucarEpicrisis;
    }

    public HtmlDataTable getDtBucarEpicrisis() {
        return dtBucarEpicrisis;
    }
}
