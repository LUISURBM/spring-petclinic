 //=======================================================================
 // ARCHIVO ExamenFisicoUsuarioBean.java
 // FECHA CREACI�N: 19/05/2010
 // AUTOR: Jos� Andr�s Riano Rinc�n, Carlos Andr�s Vargas Roa
 // Descripci�n: Datos correspondientes al ex�men fisico
 //=======================================================================
 package org.profamilia.hc.view.backing.comun;

 import java.math.BigDecimal;

 import java.text.NumberFormat;

 import java.util.ArrayList;
 import java.util.Date;
 import java.util.List;

 import javax.faces.component.UIInput;
 import javax.faces.event.ValueChangeEvent;
 import javax.faces.model.SelectItem;

 import org.profamilia.hc.model.dto.Chexamfisico;
 import org.profamilia.hc.model.dto.ChexamfisicoPK;
 import org.profamilia.hc.model.dto.Chusuario;
 import org.profamilia.hc.model.exceptions.ModelException;
 import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
 import org.profamilia.hc.view.util.FacesUtils;

 //=======================================================================
 //  BIBLIOTECAS REQUERIDAS
 //=======================================================================


 //=======================================================================
 //  CLASE ExamenFisicoUsuarioBean
 //=======================================================================
 public class ExamenFisicoUsuarioBean extends BaseBean {

     //-----------------------------------------------------------------------
     //  ATRIBUTOS DE INSTANCIA
     //-----------------------------------------------------------------------

     /** Almacena el examen fisico que se va a guardar  */
     private Chexamfisico examen;

     /** Almacena el indice de masa corporal */
     private String masacor;

     /** Almacena el peso **/
     private BigDecimal peso;

     /** Almacena la talla */
     private BigDecimal talla;

     /** Almacena true si los datos ingresados son correctos*/
     private boolean exito;

     /** Almacena true si la historia es de pediatria  */
     private boolean esPediatria;

     /** Almacena el tipo de temperatura seleccionada*/
     private String tipoTempSelect;

     /** Almacena el lugar de temperatura seleccionada*/
     private String lugarTempSelect;

     /** Almacena la lista de los tipos de temperaturas*/
     private List<SelectItem> lstTemperatura;

     /** Almacena la lista de los tipos de temperaturas*/
     private List<SelectItem> lstLugarTemperatura;
     
     /** Almacena la lista de Tipos de Discapacidad*/
     private List<SelectItem> lstDiscapacidad;

     /** Almacena true si la temperatura es Febril*/
     private boolean esFebril;

     private Integer tipoHistoria;

     private String nextAction;
     
    private String nextAction2; 

    private String menuBean;

     private String navigationRule;

     private String tipoServicio;

     private Chusuario usuario;

     private boolean campoopcional;

     private Long numeroConsulta;
     
     private Integer consecutivo; 
     
     private boolean renderPiel; 
     
     private boolean renderCraneo; 
     
     private boolean renderOjos; 
     
     private boolean renderOidos; 
     
     private boolean renderNariz; 
     
     private boolean renderBoca; 
     
     private boolean renderCuello; 
     
     private boolean renderTorax; 
     
     private boolean renderCorazon; 
     
     private boolean renderSenos; 
     
     private boolean renderAbdomen; 
     
     private boolean renderGenitales; 
     
     private boolean renderTacto; 
     
     private boolean renderExtremidades; 
     
     private boolean renderNeuromuscular; 
     
     private boolean renderMaculino; 
     
     private List lstAlteraciones; 
     
     private UIInput mnuPiel; 
     
     private UIInput mnuCraneo; 
     
     private UIInput mnuOjos; 
     
     private UIInput mnuOidos; 
     
     private UIInput mnuNariz; 
     
     private UIInput mnuBoca; 
     
     private UIInput mnuCuello; 
     
     private UIInput mnuTorax; 
     
     private UIInput mnuCorazon; 
     
     private UIInput mnuSenos; 
     
     private UIInput mnuAbdomen; 
     
     private UIInput mnuGenitales; 
     
     private UIInput mnuTacto; 
     
     private UIInput mnuExtremidades; 
     
     private UIInput mnuNeuromuscular; 
     
     private Integer presionArterial1; 

     private Integer presionArterial2; 
     
     private List lstOpciones;
     
     private boolean renderDiscapacidad;
     
     private boolean renderIve; 
     
     /** Lista que almacena la lista escala de dolor */
      private List<SelectItem> listEscala;
      
     private boolean renderedhallazgoCuello;
     
    private boolean renderedEcoEsp;
    
    private boolean renderedInterrupcion;
    
    private boolean obligatoriaTemperatura;
    
    private boolean renderEscala; 
    
    private boolean renderExamenPelvico; 
    
    private List<SelectItem> lstEcografia;
    
    private boolean rastreoEco; 
    
    private boolean NoEco; 
    
    private boolean ecgrafiaoEco; 
    
    private boolean renerConfEmba;
    
    private UIInput mnuConfemb;
    
    private boolean renderedSpo2;
     

     //-----------------------------------------------------------------------
     //  METODO CONSTRUCTOR
     //-----------------------------------------------------------------------

     public ExamenFisicoUsuarioBean() {
     }

     public void init() {
         nextAction = "";
         campoopcional = false;
         renderIve = false; 
         renderEscala = false; 
         inicializarExamen();
         renderedEcoEsp=false;
         obligatoriaTemperatura = false; 
        rastreoEco=false; 
        NoEco=false;
        ecgrafiaoEco=false;
         renerConfEmba=false;
     }


     public String inicializarExamen() {
         renerConfEmba=false;
         renderedSpo2= false;
         if(tipoHistoria != null && (IConstantes.HISTORIA_INTERRUPCION == tipoHistoria || IConstantes.HISTORIA_CONTROL_INTERRUPCION  == tipoHistoria)){
             renderedInterrupcion= true;
         }
         else{
             renderedInterrupcion=false;
         }
         
         renderDiscapacidad = false;
         try {
             if (numeroConsulta != null && consecutivo!= null) {
                 examen = 
                         this.getServiceLocator().getClinicoService().getExamenFisico(numeroConsulta,consecutivo);
             }


         } catch (ModelException e) {
             return capturaError(e,IConstantes.ERROR_COSNULTA);
         }

         if (examen == null) {
             Chexamfisico examenAux;
             examenAux = null;
             examen = new Chexamfisico();

             try {
                 if (usuario != null) {
                     examenAux = 
                             this.serviceLocator.getClinicoService().getUltimoExamenFisicoUsuario(usuario.getHuslnumero());
                 }

             } catch (ModelException e) {
                 return capturaError(e,IConstantes.ERROR_COSNULTA);
             }

             if (examenAux != null && examenAux.getHefatalla() != null) {
                 talla = examenAux.getHefatalla();
             }

         } else {
         
             changeExamenPelvico();
             if (examen.getHefaimc() != null) {
                 masacor = examen.getHefaimc().toString();

             }
             if (examen.getHefapeso() != null) {
                 peso = examen.getHefapeso();
             }
             if(examen.getHefcdiscapadid() != null && examen.getHefcdiscapadid().equals("S")){
                 renderDiscapacidad = true;
             }
             if (examen.getHefatalla() != null) {
                 talla = examen.getHefatalla();
             }
             if (examen.getHefetipotemper() != null) {
                 tipoTempSelect = examen.getHefetipotemper();
                 if (tipoTempSelect != null && tipoTempSelect.equals("F")) {
                     esFebril = true;
                 } else {
                     esFebril = false;
                 }
             }
             if (examen.getHefelugartemp() != null) {
                 lugarTempSelect = examen.getHefelugartemp();
             }
             
             
             if(examen.getHefcpresart1()!= null && !examen.getHefcpresart1().equals("")){
                 presionArterial1 = new Integer(examen.getHefcpresart1()); 
             }
             
             
             if(examen.getHefcpresart2()!= null && !examen.getHefcpresart2().equals("")){
                 presionArterial2 = new Integer(examen.getHefcpresart2()); 
             }
             
             
             if(examen.getHeferefiepiel()!= null && examen.getHeferefiepiel().equals("H")){
                     renderPiel = true; 
             }
             
             if(examen.getHeferefiecrane()!= null && examen.getHeferefiecrane().equals("H")){
                 renderCraneo = true; 
             }
             
             if(examen.getHeferefieojos()!= null && examen.getHeferefieojos().equals("H")){
                  renderOjos = true; 
             }
             
             if(examen.getHeferefieoidos()!= null && examen.getHeferefieoidos().equals("H")){
                  renderOidos = true; 
             }
             
             if(examen.getHeferefienariz()!= null && examen.getHeferefienariz().equals("H")){
                  renderNariz = true;  
             }
             
             
             if(examen.getHeferefieboca()!= null && examen.getHeferefieboca().equals("H")){
                   renderBoca = true; 
             }
             
             
             if(examen.getHeferefiecuell()!= null && examen.getHeferefiecuell().equals("H")){
                  renderCuello = true; 
                 
             }
             
             if(examen.getHeferefietorax()!= null && examen.getHeferefietorax().equals("H")){
                  renderTorax = true; 
             }
             
             
             if(examen.getHeferefiecoraz()!= null && examen.getHeferefiecoraz().equals("H")){
                  renderCorazon = true; 
             }
             
             if(examen.getHeferefiesenos()!= null && examen.getHeferefiesenos().equals("H")){
                 renderSenos = true; 
             }
             
             if(examen.getHeferefieabdom()!= null && examen.getHeferefieabdom().equals("H")){
                 renderAbdomen = true; 
             }
             
             
             if(examen.getHeferefiegenit()!= null && examen.getHeferefiegenit().equals("H")){
                 renderGenitales = true; 
             }
             
             
             if(examen.getHeferefietacto()!= null && examen.getHeferefietacto().equals("H")){
                 renderTacto = true; 
             }   
             
             if(examen.getHeferefieextre()!= null && examen.getHeferefieextre().equals("H")){
                 renderExtremidades = true; 
              }
     
             if(examen.getHeferefieneuro()!= null && examen.getHeferefieneuro().equals("H")){
                 renderNeuromuscular= true; 
             } 
             
         }
         
         if (examen.getHefccuellocerra() == null) {
                renderedhallazgoCuello = false;
         } else if (examen.getHefccuellocerra().equals("N")){
             renderedhallazgoCuello = true;
             }
             else{
                 renderedhallazgoCuello = false;
             }
        
        if(examen.getHefcecoespecialis() == null){
            renderedEcoEsp = false;
            rastreoEco= false;
            NoEco=false;
            ecgrafiaoEco=false;
        }     
        else  if(examen !=null && examen.getHefcecoespecialis().equals("R")){
            rastreoEco= true;
            NoEco=false;
            ecgrafiaoEco=false;
         }else if(examen !=null && examen.getHefcecoespecialis().equals("E")){
             rastreoEco= true;
             NoEco=false;
             ecgrafiaoEco=true;
             }
         else if(examen !=null && examen.getHefcecoespecialis().equals("N")){
             rastreoEco= true;
             NoEco=false;
             ecgrafiaoEco=true;
         }
         
         changeTipoHallazgo();

        if (examen != null && examen.getHefcconfiembar()!=null) {
            if (examen.getHefcconfiembar().equals("S")) {
                renerConfEmba = true;
            }

            else {
                renerConfEmba = false;
            }
        } else {
            renerConfEmba = false;
        }
        
         if(tipoHistoria != null && (IConstantes.HISTORIA_SALUD_SEXUAL == tipoHistoria || IConstantes.HISTORIA_PREANESTESIA  == tipoHistoria)){
             renderedSpo2 = true;
         }
        return null;
     }

     public void calcularIMC() {

         String imcStr = null;
         double imc = 0;
         if (talla != null && peso != null) {
             if (talla.doubleValue() != 0 && peso.doubleValue() != 0) {
                 imc = 
 peso.doubleValue() / ((talla.doubleValue()) * (talla.doubleValue()));
             }

             NumberFormat nf = NumberFormat.getInstance();
             nf.setMaximumFractionDigits(2);
             imcStr = nf.format(imc);
             if (imcStr != null && !imcStr.equals("")) {
                 masacor = imcStr.replace(",", ".");
             } else {
                 masacor = null;
             }

         }

     }

     public void changeTemperatura() {
         if (tipoTempSelect != null && tipoTempSelect.equals("F")) {
             esFebril = true;
         } else {
             esFebril = false;
         }
     }

     /**
      * @return
      */
     public boolean esValido() {
         boolean esValido = false;
         Chexamfisico examenAux = null;
         if (numeroConsulta != null && consecutivo != null) {
             try {
                 examenAux = 
                         this.getServiceLocator().getClinicoService().getExamenFisico(numeroConsulta, consecutivo);
             } catch (ModelException e) {
                 e.printStackTrace();
             }
         }
         if (examenAux != null) {
             esValido = true;
         } else {
             esValido = false;
         }
         return esValido;
     }
     
    /**
     * @return
     */
    public boolean confirmaEmbarazo() {
        boolean esValido = false;
        Chexamfisico examenAux = null;
        if (numeroConsulta != null && consecutivo != null) {
            try {
                examenAux = 
                        this.getServiceLocator().getClinicoService().getExamenFisico(numeroConsulta, consecutivo);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (examenAux != null && examen.getHefcconfiembar() != null && examen.getHefcconfiembar().equals("S") ) {
            esValido = true;
        } 
        return esValido;
    }

     /**
      * @return
      */
     public String guardarExamen() {
         navigationRule = "";
         ChexamfisicoPK id = new ChexamfisicoPK();

         exito = true;
         BigDecimal tallamaxcomp = new BigDecimal("3.00");
         BigDecimal pesomaxcomp = new BigDecimal("400");
         BigDecimal tallamincomp = new BigDecimal("0.20");
         BigDecimal pesomincomp = new BigDecimal("0");
         BigDecimal tempcomp = new BigDecimal("45");
         Integer preartcomp1 = new Integer("40");
         Integer preartcomp2 = new Integer("300");
         Integer frecucomp1 = new Integer("40");
         Integer frecucomp2 = new Integer("120");
         Integer frecrespi1 = new Integer("8");
         Integer frecrespi2 = new Integer("24");
         Integer spo2maxcomp = new Integer("100");


         calcularIMC();
         
         if (examen.getHefcecoespecialis() != null && 
             !examen.getHefcecoespecialis().equals("")) {
             
                if("R".equals(examen.getHefcecoespecialis())){
                    examen.setHefntamauterocm(null);
                    examen.setHefntamauterocm(null);
                }
                
                 
                 if("N".equals(examen.getHefcecoespecialis())){
                     examen.setHefntamauterocm(null);
                     examen.setHefntamauterocm(null);
                     examen.setHefnedadsem(null);
                     examen.setHefnedaddia(null);
                     examen.setHefcobsereco(null);
                 }
                  
             
             }
         
         
         if(!renderedInterrupcion){
             examen.setHefcposiutero(null);
             examen.setHefcdesviautero(null);
             examen.setHefccuellocerra(null);
             examen.setHefcobscuecerra(null);
             examen.setHefcdolormovcuello(null);
             examen.setHefcsangrado(null);
             examen.setHefcecoespecialis(null);
             examen.setHefnedadsem(null);
             examen.setHefnedaddia(null);
             examen.setHefntamauterocm(null);
             examen.setHefntamauteroml(null);
         }
         
        if(presionArterial1!= null){
            examen.setHefcpresart1(presionArterial1.toString());
        }
        
         if(presionArterial2!= null){
             examen.setHefcpresart2(presionArterial2.toString());
         }
         
         if(!renderPiel){
             examen.setHefcrefiepiel(null);
             
         }
         
         if(!renderCraneo){
             examen.setHefcrefiecrane(null);
             
         }
         
         if(!renderOjos){
             examen.setHefcrefieojos(null);
         }
         
         if(!renderOidos){
             examen.setHefcrefieoidos(null);
         }
         
         if(!renderNariz){
            examen.setHefcrefienariz(null);
         }
         
         
         if(!renderBoca){
             examen.setHefcrefieboca(null);
         }
         
         
         if(!renderCuello){
             examen.setHefcrefiecuell(null);
         }
         
         
         if(!renderTorax){
             examen.setHefcrefietorax(null);
         }
         
         
         if(!renderCorazon){
            examen.setHefcrefiecoraz(null);
         }
         
         if(!renderSenos){
             examen.setHefcrefiesenos(null);
         }
         
         if(!renderAbdomen){
             examen.setHefcrefieabdom(null);
         }
         
         
         if(!renderGenitales){
             examen.setHefcrefiegenit(null);
         }
         
         
         if(!renderTacto){
             examen.setHefcrefietacto(null);
         }
         
         
         if(!renderExtremidades){
             examen.setHefcrefieextre(null);
         }
         
         if(!renderNeuromuscular){
             examen.setHefcrefieneuro(null);
         }
         
         if(renderMaculino){
             examen.setHefcrefietacto(null);
             examen.setHeferefietacto(null);
         }
        

        


         if (examen != null && examen.getHefnfreccard() != null) {
             if (examen.getHefnfreccard().compareTo(frecucomp1) < 0 || 
                 examen.getHefnfreccard().compareTo(frecucomp2) > 0) {
                 FacesUtils.addWarnMessage(IMsg.MSG_FRECUENCIA_CARDIACA_NO_VALIDA);
             }
         }

         if (examen != null && examen.getHefnfrecresp() != null) {
             if (examen.getHefnfrecresp().compareTo(frecrespi1) < 0 || 
                 examen.getHefnfrecresp().compareTo(frecrespi2) > 0) {
                 FacesUtils.addWarnMessage(IMsg.MSG_FRECUENCIA_RESPIRATORIA_NO_VALIDA);
             }
         }

         if (talla == null || talla.compareTo(tallamincomp) < 0) {
             exito = false;
             FacesUtils.addWarnMessage(IMsg.MSG_TALLA_MIN_NO_VALIDA);
         }
         if (peso == null || peso.compareTo(pesomincomp) < 0) {
             exito = false;
             FacesUtils.addWarnMessage(IMsg.MSG_PESO_MIN_NO_VALIDO);
         }
         if (talla != null && talla.compareTo(tallamaxcomp) > 0) {
             exito = false;
             FacesUtils.addWarnMessage(IMsg.MSG_TALLA_MAX_NO_VALIDA);
         }
         if (peso != null && peso.compareTo(pesomaxcomp) > 0) {
             exito = false;
             FacesUtils.addWarnMessage(IMsg.MSG_PESO_MAX_NO_VALIDO);
         }

         if (examen != null && examen.getHefatemperatu() != null && 
             examen.getHefatemperatu().compareTo(tempcomp) > 0) {
             exito = false;
             FacesUtils.addWarnMessage(IMsg.MSG_TEMPERATURA_NO_VALIDA);
         }
         if (presionArterial1 != null) {
             if (presionArterial1.compareTo(preartcomp1) < 0 || 
                 presionArterial1.compareTo(preartcomp2) > 0) {
                 exito = false;
                 FacesUtils.addWarnMessage(IMsg.MSG_PRESION_ARTERIAL_MENOR);
             }
         }

         if (presionArterial2 != null) {
             if (presionArterial2.compareTo(preartcomp1) < 0 || 
                 presionArterial2.compareTo(preartcomp2) > 0) {
                 FacesUtils.addWarnMessage(IMsg.MSG_PRESION_ARTERIAL_MENOR);
             }
         }
         if (examen != null && examen.getHefnspo2() != null && 
             examen.getHefnspo2().compareTo(spo2maxcomp) > 100) {
             exito = false;
             FacesUtils.addWarnMessage(IMsg.MSG_SPO2_NO_VALIDA);
         }



         if (exito) {

             if (numeroConsulta != null) {
                 id.setHeflconsulta(numeroConsulta);
                 id.setHefctiposervi(tipoServicio);
                 id.setHefnconsecutiv(consecutivo);
                 examen.setId(id);
             }

             examen.setHefcoperador(userName());
             examen.setHefdfecregistr(new Date());
             examen.setHefapeso(peso);
             examen.setHefatalla(talla);

             if (tipoTempSelect != null && tipoTempSelect.equals("A")) {
                 examen.setHefatemperatu(null);
                 examen.setHefelugartemp(null);
             } else {
                 examen.setHefelugartemp(lugarTempSelect);
             }
             examen.setHefetipotemper(tipoTempSelect);

             if (masacor != null && !masacor.equals("")) {

                 BigDecimal masaAux = new BigDecimal(masacor);
                 if (masaAux != null) {
                     examen.setHefaimc(masaAux);
                 }
             }

             try {
                 this.getServiceLocator().getClinicoService().saveExamenFisico(examen);
                 FacesUtils.addInfoMessage(IMsg.MSG_ADICION);

                 // Se recarga el menu 
                 if(menuBean!= null){
                     FacesUtils.resetManagedBean(menuBean);    
                 }
                 
                 navigationRule = nextAction;
                 
                 if(renderIve && examen != null && examen.getHefcconfiembar() != null &&  
                    examen.getHefcconfiembar().equals("N")){
                     navigationRule = nextAction2;
                 }

             } catch (ModelException e) {
                
                 navigationRule = "";
                 return capturaError(e,IConstantes.ERROR_GUARDADO);
             }
         }

         // Se establece la siguiente accion de navegacion
         return navigationRule;
     }


     /**
      * @param examen
      */
     public void setExamen(Chexamfisico examen) {
         this.examen = examen;
     }

     /**
      * @return
      */
     public Chexamfisico getExamen() {
         return examen;
     }


     /**
      * @param masacor
      */
     public void setMasacor(String masacor) {
         this.masacor = masacor;
     }

     /**
      * @return
      */
     public String getMasacor() {
         return masacor;
     }

     /**
      * @param peso
      */
     public void setPeso(BigDecimal peso) {
         this.peso = peso;
     }

     /**
      * @param valueChangeEvent
      */
     public void setPeso(ValueChangeEvent valueChangeEvent) {
         setPeso((BigDecimal)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

     /**
      * @param valueChangeEvent
      */
     public void setHeferefiepiel(ValueChangeEvent valueChangeEvent) {
         examen.setHeferefiepiel((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }


     /**
      * @param valueChangeEvent
      */
     public void setHeferefiecrane(ValueChangeEvent valueChangeEvent) {
         examen.setHeferefiecrane((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }

     /**
      * @param valueChangeEvent
      */
     public void setHeferefieojos(ValueChangeEvent valueChangeEvent) {
         examen.setHeferefieojos((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }


     /**
      * @param valueChangeEvent
      */
     public void setHeferefieoidos(ValueChangeEvent valueChangeEvent) {
         examen.setHeferefieoidos((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }

     /**
      * @param valueChangeEvent
      */
     public void setHeferefienariz(ValueChangeEvent valueChangeEvent) {
         examen.setHeferefienariz((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }

     /**
      * @param valueChangeEvent
      */
     public void setHeferefieboca(ValueChangeEvent valueChangeEvent) {
          examen.setHeferefieboca((String)valueChangeEvent.getNewValue());
          ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
          }

     /**
      * @param valueChangeEvent
      */
     public void setHeferefiecuell(ValueChangeEvent valueChangeEvent) {
         examen.setHeferefiecuell((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }

     /**
      * @param valueChangeEvent
      */
     public void setHeferefietorax(ValueChangeEvent valueChangeEvent) {
         examen.setHeferefietorax((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }

     /**
      * @param valueChangeEvent
      */
     public void setHeferefiecoraz(ValueChangeEvent valueChangeEvent) {
         examen.setHeferefiecoraz((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }

     /**
      * @param valueChangeEvent
      */
     public void setHeferefiesenos(ValueChangeEvent valueChangeEvent) {
          examen.setHeferefiesenos((String)valueChangeEvent.getNewValue());
          ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
          }

     /**
      * @param valueChangeEvent
      */
     public void setHeferefieabdom(ValueChangeEvent valueChangeEvent) {
         examen.setHeferefieabdom((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }

     /**
      * @param valueChangeEvent
      */
     public void setHeferefiegenit(ValueChangeEvent valueChangeEvent) {
         examen.setHeferefiegenit((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }

     /**
      * @param valueChangeEvent
      */
     public void setHeferefietacto(ValueChangeEvent valueChangeEvent) {
         examen.setHeferefietacto((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }

     /**
      * @param valueChangeEvent
      */
     public void setHeferefieextre(ValueChangeEvent valueChangeEvent) {
         examen.setHeferefieextre((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }

     /**
      * @param valueChangeEvent
      */
     public void setHeferefieneuro(ValueChangeEvent valueChangeEvent) {
         examen.setHeferefieneuro((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }

     /**
      * @return
      */
     public BigDecimal getPeso() {
         return peso;
     }

     /**
      * @param talla
      */
     public void setTalla(BigDecimal talla) {
         this.talla = talla;
     }

     /**
      * @param valueChangeEvent
      */
     public void setTalla(ValueChangeEvent valueChangeEvent) {
         setTalla((BigDecimal)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

     /**
      * @return
      */
     public BigDecimal getTalla() {
         return talla;
     }

     /**
      * @param esPediatria
      */
     public void setEsPediatria(boolean esPediatria) {
         this.esPediatria = esPediatria;
     }

     /**
      * @return
      */
     public boolean isEsPediatria() {
         return esPediatria;
     }


     /**
      * @param tipoTempSelect
      */
     public void setTipoTempSelect(String tipoTempSelect) {
         this.tipoTempSelect = tipoTempSelect;
     }

     /**
      * @param valueChangeEvent
      */
     public void setTipoTempSelect(ValueChangeEvent valueChangeEvent) {
         setTipoTempSelect((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

     /**
      * @return
      */
     public String getTipoTempSelect() {
         return tipoTempSelect;
     }

     /**
      * @param tipoTempSelect
      */
     public void setLugarTempSelect(String lugarTempSelect) {
         this.lugarTempSelect = lugarTempSelect;
     }

     /**
      * @param valueChangeEvent
      */
     public void setLugarTempSelect(ValueChangeEvent valueChangeEvent) {
         setLugarTempSelect((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

     /**
      * @return
      */
     public String getLugarTempSelect() {
         return lugarTempSelect;
     }

     /**
      * @param lstTemperatura
      */
     public void setLstTemperatura(List<SelectItem> lstTemperatura) {
         this.lstTemperatura = lstTemperatura;
     }

     /**
      * @return
      */
     public List<SelectItem> getLstTemperatura() {
         if (lstTemperatura == null || lstTemperatura.isEmpty()) {
             lstTemperatura = new ArrayList<SelectItem>();
             lstTemperatura.add(new SelectItem("", "Seleccione una opci�n"));
             lstTemperatura.add(new SelectItem("A", "Afebril"));
             lstTemperatura.add(new SelectItem("F", "Febril"));
         }
         return lstTemperatura;
     }

     /**
      * @param lstLugarTemperatura
      */
     public void setLstLugarTemperatura(List<SelectItem> lstLugarTemperatura) {
         this.lstLugarTemperatura = lstLugarTemperatura;
     }

     /**
      * @return
      */
     public List<SelectItem> getLstLugarTemperatura() {
         if (lstLugarTemperatura == null || lstLugarTemperatura.isEmpty()) {
             lstLugarTemperatura = new ArrayList<SelectItem>();
             lstLugarTemperatura.add(new SelectItem("", "Seleccione una opci�n"));
             lstLugarTemperatura.add(new SelectItem("A", "Axilar"));
             lstLugarTemperatura.add(new SelectItem("B", "Bucal"));
         }
         return lstLugarTemperatura;
     }
   
   
     public void setLstDiscapacidad(List<SelectItem> lstDiscapacidad) {
         this.lstDiscapacidad = lstDiscapacidad;
     }

     public List<SelectItem> getLstDiscapacidad() {
         if (lstDiscapacidad == null || lstDiscapacidad.isEmpty()) {
             lstDiscapacidad = new ArrayList<SelectItem>();
             lstDiscapacidad.add(new SelectItem("", "Seleccione una opci�n"));
             lstDiscapacidad.add(new SelectItem("FI", "Discapacidad f�sica"));
             lstDiscapacidad.add(new SelectItem("VI", "Discapacidad visual"));
             lstDiscapacidad.add(new SelectItem("AU", "Discapacidad auditiva"));
             lstDiscapacidad.add(new SelectItem("IN", "Discapacidad intelectual"));
             lstDiscapacidad.add(new SelectItem("ME", "Discapacidad sicosocial (mental)"));
             lstDiscapacidad.add(new SelectItem("SO", "Discapacidad Sordoceguera"));
             lstDiscapacidad.add(new SelectItem("MU", "Discapacidad m�ltiple"));
            
         }
         return lstDiscapacidad;
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
         if (lstOpciones == null || lstOpciones.isEmpty()) {
             lstOpciones = new ArrayList();
             lstOpciones.add(new SelectItem("S", "SI"));
             lstOpciones.add(new SelectItem("N", "NO"));
         }
         return lstOpciones;
     }


     /**
      * @param esFebril
      */
     public void setEsFebril(boolean esFebril) {
         this.esFebril = esFebril;
     }

     /**
      * @return
      */
     public boolean isEsFebril() {
         return esFebril;
     }

     /**
      * @param tipoHistoria
      */
     public void setTipoHistoria(Integer tipoHistoria) {
         this.tipoHistoria = tipoHistoria;
     }

     /**
      * @return
      */
     public Integer getTipoHistoria() {
         return tipoHistoria;
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
      * @param tipoServicio
      */
     public void setTipoServicio(String tipoServicio) {
         this.tipoServicio = tipoServicio;
     }

     /**
      * @return
      */
     public String getTipoServicio() {
         return tipoServicio;
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
      * @param campoopcional
      */
     public void setCampoopcional(boolean campoopcional) {
         this.campoopcional = campoopcional;
     }

     /**
      * @return
      */
     public boolean isCampoopcional() {
         return campoopcional;
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
      * @param consecutivo
      */
     public void setConsecutivo(Integer consecutivo) {
         this.consecutivo = consecutivo;
     }

     /**
      * @return
      */
     public Integer getConsecutivo() {
         return consecutivo;
     }

     /**
      * @param renderPiel
      */
     public void setRenderPiel(boolean renderPiel) {
         this.renderPiel = renderPiel;
     }

     /**
      * @return
      */
     public boolean isRenderPiel() {
         return renderPiel;
     }

     /**
      * @param renderCraneo
      */
     public void setRenderCraneo(boolean renderCraneo) {
         this.renderCraneo = renderCraneo;
     }

     /**
      * @return
      */
     public boolean isRenderCraneo() {
         return renderCraneo;
     }

     /**
      * @param renderOjos
      */
     public void setRenderOjos(boolean renderOjos) {
         this.renderOjos = renderOjos;
     }

     /**
      * @return
      */
     public boolean isRenderOjos() {
         return renderOjos;
     }

     /**
      * @param renderOidos
      */
     public void setRenderOidos(boolean renderOidos) {
         this.renderOidos = renderOidos;
     }

     /**
      * @return
      */
     public boolean isRenderOidos() {
         return renderOidos;
     }

     /**
      * @param renderNariz
      */
     public void setRenderNariz(boolean renderNariz) {
         this.renderNariz = renderNariz;
     }

     /**
      * @return
      */
     public boolean isRenderNariz() {
         return renderNariz;
     }

     /**
      * @param renderBoca
      */
     public void setRenderBoca(boolean renderBoca) {
         this.renderBoca = renderBoca;
     }

     /**
      * @return
      */
     public boolean isRenderBoca() {
         return renderBoca;
     }

     /**
      * @param renderCuello
      */
     public void setRenderCuello(boolean renderCuello) {
         this.renderCuello = renderCuello;
     }

     /**
      * @return
      */
     public boolean isRenderCuello() {
         return renderCuello;
     }

     /**
      * @param renderTorax
      */
     public void setRenderTorax(boolean renderTorax) {
         this.renderTorax = renderTorax;
     }

     /**
      * @return
      */
     public boolean isRenderTorax() {
         return renderTorax;
     }

     /**
      * @param renderCorazon
      */
     public void setRenderCorazon(boolean renderCorazon) {
         this.renderCorazon = renderCorazon;
     }

     /**
      * @return
      */
     public boolean isRenderCorazon() {
         return renderCorazon;
     }

     /**
      * @param renderSenos
      */
     public void setRenderSenos(boolean renderSenos) {
         this.renderSenos = renderSenos;
     }

     /**
      * @return
      */
     public boolean isRenderSenos() {
         return renderSenos;
     }

     /**
      * @param renderAbdomen
      */
     public void setRenderAbdomen(boolean renderAbdomen) {
         this.renderAbdomen = renderAbdomen;
     }

     /**
      * @return
      */
     public boolean isRenderAbdomen() {
         return renderAbdomen;
     }

     /**
      * @param renderGenitales
      */
     public void setRenderGenitales(boolean renderGenitales) {
         this.renderGenitales = renderGenitales;
     }

     /**
      * @return
      */
     public boolean isRenderGenitales() {
         return renderGenitales;
     }

     /**
      * @param renderTacto
      */
     public void setRenderTacto(boolean renderTacto) {
         this.renderTacto = renderTacto;
     }

     /**
      * @return
      */
     public boolean isRenderTacto() {
         return renderTacto;
     }

     /**
      * @param renderExtremidades
      */
     public void setRenderExtremidades(boolean renderExtremidades) {
         this.renderExtremidades = renderExtremidades;
     }

     /**
      * @return
      */
     public boolean isRenderExtremidades() {
         return renderExtremidades;
     }

     /**
      * @param renderNeuromuscular
      */
     public void setRenderNeuromuscular(boolean renderNeuromuscular) {
         this.renderNeuromuscular = renderNeuromuscular;
     }

     /**
      * @return
      */
     public boolean isRenderNeuromuscular() {
         return renderNeuromuscular;
     }


     /**
      * @param presionArterial1
      */
     public void setPresionArterial1(Integer presionArterial1) {
             this.presionArterial1 = presionArterial1;
         }

     /**
      * @return
      */
     public Integer getPresionArterial1() {
             return presionArterial1;
         }

     /**
      * @param presionArterial2
      */
     public void setPresionArterial2(Integer presionArterial2) {
             this.presionArterial2 = presionArterial2;
         }

     /**
      * @return
      */
     public Integer getPresionArterial2() {
             return presionArterial2;
         }


     /**
      * @param lstAlteraciones
      */
     public void setLstAlteraciones(List lstAlteraciones) {
         this.lstAlteraciones = lstAlteraciones;
     }

     /**
      * @return
      */
     public List getLstAlteraciones() {
     if(lstAlteraciones == null || lstAlteraciones.isEmpty()){
         lstAlteraciones = new ArrayList(); 
         lstAlteraciones.add(new SelectItem("H","Hallazgo Relevante")); 
         // Esta opci�n se deshabilito y se cambio por 'N' No evaluado, esto con el fin de conservar el historico
         lstAlteraciones.add(new SelectItem("S","Sin Alteraciones aparentes")); 
         lstAlteraciones.add(new SelectItem("E","Evaluado - Sin hallazgo aparente")); 
         lstAlteraciones.add(new SelectItem("N","No evaluado")); 
     }
         return lstAlteraciones;
     }


     /**
      * @param mnuPiel
      */
     public void setMnuPiel(UIInput mnuPiel) {
         this.mnuPiel = mnuPiel;
     }

     /**
      * @return
      */
     public UIInput getMnuPiel() {
         return mnuPiel;
     }


     /**
      * @param mnuCraneo
      */
     public void setMnuCraneo(UIInput mnuCraneo) {
         this.mnuCraneo = mnuCraneo;
     }

     /**
      * @return
      */
     public UIInput getMnuCraneo() {
         return mnuCraneo;
     }

     /**
      * @param mnuOjos
      */
     public void setMnuOjos(UIInput mnuOjos) {
         this.mnuOjos = mnuOjos;
     }

     /**
      * @return
      */
     public UIInput getMnuOjos() {
         return mnuOjos;
     }

     /**
      * @param mnuOidos
      */
     public void setMnuOidos(UIInput mnuOidos) {
         this.mnuOidos = mnuOidos;
     }

     /**
      * @return
      */
     public UIInput getMnuOidos() {
         return mnuOidos;
     }

     /**
      * @param renderMaculino
      */
     public void setRenderMaculino(boolean renderMaculino) {
         this.renderMaculino = renderMaculino;
     }

     /**
      * @return
      */
     public boolean isRenderMaculino() {
         return renderMaculino;
     }

     /**
      * @param mnuNariz
      */
     public void setMnuNariz(UIInput mnuNariz) {
         this.mnuNariz = mnuNariz;
     }

     /**
      * @return
      */
     public UIInput getMnuNariz() {
         return mnuNariz;
     }

     /**
      * @param mnuBoca
      */
     public void setMnuBoca(UIInput mnuBoca) {
         this.mnuBoca = mnuBoca;
     }

     /**
      * @return
      */
     public UIInput getMnuBoca() {
         return mnuBoca;
     }

     /**
      * @param mnuCuello
      */
     public void setMnuCuello(UIInput mnuCuello) {
         this.mnuCuello = mnuCuello;
     }

     /**
      * @return
      */
     public UIInput getMnuCuello() {
         return mnuCuello;
     }

     /**
      * @param mnuTorax
      */
     public void setMnuTorax(UIInput mnuTorax) {
         this.mnuTorax = mnuTorax;
     }

     /**
      * @return
      */
     public UIInput getMnuTorax() {
         return mnuTorax;
     }

     /**
      * @param mnuCorazon
      */
     public void setMnuCorazon(UIInput mnuCorazon) {
         this.mnuCorazon = mnuCorazon;
     }

     /**
      * @return
      */
     public UIInput getMnuCorazon() {
         return mnuCorazon;
     }

     /**
      * @param mnuSenos
      */
     public void setMnuSenos(UIInput mnuSenos) {
         this.mnuSenos = mnuSenos;
     }

     /**
      * @return
      */
     public UIInput getMnuSenos() {
         return mnuSenos;
     }

     /**
      * @param mnuAbdomen
      */
     public void setMnuAbdomen(UIInput mnuAbdomen) {
         this.mnuAbdomen = mnuAbdomen;
     }

     /**
      * @return
      */
     public UIInput getMnuAbdomen() {
         return mnuAbdomen;
     }

     /**
      * @param mnuGenitales
      */
     public void setMnuGenitales(UIInput mnuGenitales) {
         this.mnuGenitales = mnuGenitales;
     }

     /**
      * @return
      */
     public UIInput getMnuGenitales() {
         return mnuGenitales;
     }

     /**
      * @param mnuTacto
      */
     public void setMnuTacto(UIInput mnuTacto) {
         this.mnuTacto = mnuTacto;
     }

     /**
      * @return
      */
     public UIInput getMnuTacto() {
         return mnuTacto;
     }

     /**
      * @param mnuExtremidades
      */
     public void setMnuExtremidades(UIInput mnuExtremidades) {
         this.mnuExtremidades = mnuExtremidades;
     }

     /**
      * @return
      */
     public UIInput getMnuExtremidades() {
         return mnuExtremidades;
     }

     /**
      * @param mnuNeuromuscular
      */
     public void setMnuNeuromuscular(UIInput mnuNeuromuscular) {
         this.mnuNeuromuscular = mnuNeuromuscular;
     }

     /**
      * @return
      */
     public UIInput getMnuNeuromuscular() {
         return mnuNeuromuscular;
     }
     
     public void changePiel(){
         renderPiel = false; 
         if(examen!= null && examen.getHeferefiepiel()!= null &&
         examen.getHeferefiepiel().equals("H")){
             renderPiel = true; 
         }
     }
     
     public void changeDiscapacidad(){
         renderDiscapacidad = false;
         if(examen != null && examen.getHefcdiscapadid() != null && examen.getHefcdiscapadid().equals("S")){
             renderDiscapacidad = true;
         }
     }
     
     
     
     public void changeCraneo(){
         renderCraneo = false; 
         if(examen!= null && examen.getHeferefiecrane()!= null &&
         examen.getHeferefiecrane().equals("H")){
             renderCraneo = true; 
         }
     }
     
     public void changeOjos(){
         renderOjos= false; 
         if(examen!= null && examen.getHeferefieojos()!= null &&
         examen.getHeferefieojos().equals("H")){
             renderOjos = true; 
         }
     }
     
     public void changeOidos(){
         renderOidos = false; 
         if(examen!= null && examen.getHeferefieoidos()!= null &&
         examen.getHeferefieoidos().equals("H")){
             renderOidos = true; 
         }
     }
     
     public void changeNariz(){
         renderNariz = false; 
         if(examen!= null && examen.getHeferefienariz()!= null &&
         examen.getHeferefienariz().equals("H")){
             renderNariz = true; 
         }
     }
     
     public void changeBoca(){
         renderBoca = false; 
         if(examen!= null && examen.getHeferefieboca()!= null &&
         examen.getHeferefieboca().equals("H")){
             renderBoca = true; 
         }
     }
     
     public void changeCuello(){
         renderCuello = false; 
         if(examen!= null && examen.getHeferefiecuell()!= null &&
         examen.getHeferefiecuell().equals("H")){
             renderCuello = true; 
         }
     }
     
     public void changeTorax(){
         renderTorax = false; 
         if(examen!= null && examen.getHeferefietorax()!= null &&
         examen.getHeferefietorax().equals("H")){
             renderTorax = true; 
         }
     }
     
     public void changeCorazon(){
         renderCorazon = false; 
         if(examen!= null && examen.getHeferefiecoraz()!= null &&
         examen.getHeferefiecoraz().equals("H")){
             renderCorazon = true; 
         }
     }
     
     public void changeSenos(){
         renderSenos = false; 
         if(examen!= null && examen.getHeferefiesenos()!= null &&
         examen.getHeferefiesenos().equals("H")){
             renderSenos = true; 
         }
     }
     
     public void changeAbdomen(){
         renderAbdomen = false; 
         if(examen!= null && examen.getHeferefieabdom()!= null &&
         examen.getHeferefieabdom().equals("H")){
             renderAbdomen = true; 
         }
     }
     
     public void changeGenitales(){
         renderGenitales = false; 
         if(examen!= null && examen.getHeferefiegenit()!= null &&
         examen.getHeferefiegenit().equals("H")){
             renderGenitales = true; 
         }
     }
     
     public void changeTacto(){
         renderTacto = false; 
         if(examen!= null && examen.getHeferefietacto()!= null &&
         examen.getHeferefietacto().equals("H")){
             renderTacto = true; 
         }
     }
     
     public void changeExtremidades(){
         renderExtremidades = false; 
         if(examen!= null && examen.getHeferefieextre()!= null &&
         examen.getHeferefieextre().equals("H")){
             renderExtremidades = true; 
         }
     }
     
     public void changeNeuromuscular(){
         renderNeuromuscular = false; 
         if(examen!= null && examen.getHeferefieneuro()!= null &&
         examen.getHeferefieneuro().equals("H")){
             renderNeuromuscular = true; 
         }
     }
     
     
     public void changeTodosNo() {
         renderPiel = false; 
         renderCraneo = false; 
         renderOjos = false; 
         renderOidos = false;
         renderNariz = false;
         renderBoca = false;
         renderCuello = false;
         renderTorax = false; 
         renderCorazon = false;
         renderSenos = false;
         renderAbdomen = false;
         renderGenitales = false;
         renderTacto = false; 
         renderExtremidades = false;
         renderNeuromuscular = false;
         inicializarPreguntas("N");
     }

     public void changeTodosSi() {
       
         renderPiel = true; 
         renderCraneo = true; 
         renderOjos = true; 
         renderOidos = true;
         renderNariz = true;
         renderBoca = true;
         renderCuello = true;
         renderTorax = true; 
         renderCorazon = true;
         renderSenos = true;
         renderAbdomen = true;
         renderGenitales = true;
         renderTacto = true; 
         renderExtremidades = true;
         renderNeuromuscular = true;
         inicializarPreguntas("H");

         
     }
     public void changeTodosSinAL() {
         renderPiel = false; 
         renderCraneo = false; 
         renderOjos = false; 
         renderOidos = false;
         renderNariz = false;
         renderBoca = false;
         renderCuello = false;
         renderTorax = false; 
         renderCorazon = false;
         renderSenos = false;
         renderAbdomen = false;
         renderGenitales = false;
         renderTacto = false; 
         renderExtremidades = false;
         renderNeuromuscular = false;
         inicializarPreguntas("S");
     }

     public void changeTodosEvaluado() {
         renderPiel = false; 
         renderCraneo = false; 
         renderOjos = false; 
         renderOidos = false;
         renderNariz = false;
         renderBoca = false;
         renderCuello = false;
         renderTorax = false; 
         renderCorazon = false;
         renderSenos = false;
         renderAbdomen = false;
         renderGenitales = false;
         renderTacto = false; 
         renderExtremidades = false;
         renderNeuromuscular = false;
         inicializarPreguntas("E");
     }

     public void changeNinguno() {
         renderPiel = false; 
         renderCraneo = false; 
         renderOjos = false; 
         renderOidos = false;
         renderNariz = false;
         renderBoca = false;
         renderCuello = false;
         renderTorax = false; 
         renderCorazon = false;
         renderSenos = false;
         renderAbdomen = false;
         renderGenitales = false;
         renderTacto = false; 
         renderExtremidades = false;
         renderNeuromuscular = false;

         inicializarPreguntas(null);


     }
     
     
     public void inicializarPreguntas(String opcion) {

         if (examen != null) {


                 examen.setHeferefiepiel(opcion);
                 examen.setHeferefiecrane(opcion);
                 examen.setHeferefieojos(opcion);
                 examen.setHeferefieoidos(opcion);
                 examen.setHeferefienariz(opcion);
                 examen.setHeferefieboca(opcion);
                 examen.setHeferefiecuell(opcion);
                 examen.setHeferefietorax(opcion);
                 examen.setHeferefiecoraz(opcion);
                 examen.setHeferefiesenos(opcion);
                 examen.setHeferefieabdom(opcion);
                 examen.setHeferefiegenit(opcion);
                 examen.setHeferefieextre(opcion);
                 examen.setHeferefieneuro(opcion);
                 examen.setHeferefietacto(opcion);


             mnuPiel.setValue(opcion);
             mnuCraneo.setValue(opcion);
             mnuOjos.setValue(opcion);
             mnuOidos.setValue(opcion);
             mnuNariz.setValue(opcion);
             mnuBoca.setValue(opcion);
             mnuCuello.setValue(opcion);
             mnuTorax.setValue(opcion);
             mnuCorazon.setValue(opcion);
             mnuSenos.setValue(opcion);
             mnuAbdomen.setValue(opcion);
             mnuGenitales.setValue(opcion);
             mnuTacto.setValue(opcion);
             mnuExtremidades.setValue(opcion);
             mnuNeuromuscular.setValue(opcion);


         }

     }


     public void setRenderDiscapacidad(boolean renderDiscapacidad) {
         this.renderDiscapacidad = renderDiscapacidad;
     }

     public boolean isRenderDiscapacidad() {
         return renderDiscapacidad;
     }



     
    public void setRenderedhallazgoCuello(boolean renderedhallazgoCuello) {
        this.renderedhallazgoCuello = renderedhallazgoCuello;
    }

    public boolean isRenderedhallazgoCuello() {
        return renderedhallazgoCuello;
    }
    
    public void setListEscala(List<SelectItem> listEscala) {
        this.listEscala = listEscala;
    }

    public List<SelectItem> getListEscala() {

        if (listEscala == null || listEscala.isEmpty()) {
            listEscala = new ArrayList<SelectItem>();

            listEscala.add(new SelectItem(0, "0"));
            listEscala.add(new SelectItem(1, "1"));
            listEscala.add(new SelectItem(2, "2"));
            listEscala.add(new SelectItem(3, "3"));
            listEscala.add(new SelectItem(4, "4"));
            listEscala.add(new SelectItem(5, "5"));
            listEscala.add(new SelectItem(6, "6"));
            listEscala.add(new SelectItem(7, "7"));
            listEscala.add(new SelectItem(8, "8"));
            listEscala.add(new SelectItem(9, "9"));
            listEscala.add(new SelectItem(10, "10"));

        }

        return listEscala;
    }


 
    
    public void setCuelloCerrado(ValueChangeEvent valueChangeEvent) {
        examen.setHefcdolormovcuello((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void ChangeHallazgoCuello() {
        if (examen != null && examen.getHefcdolormovcuello() != null 
           && examen.getHefcdolormovcuello().equals("N")) {
               renderedhallazgoCuello = true;
        } else {
            renderedhallazgoCuello = false;
            examen.setHefcobscuecerra(null);
        }
    }
    
    public void setEcografiaEsp(ValueChangeEvent valueChangeEvent) {
        examen.setHefcecoespecialis((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void ChangeEcoEsp() {
        if (examen != null && examen.getHefcecoespecialis() != null 
           && examen.getHefcecoespecialis().equals("S")) {
               renderedEcoEsp = true;
        } else {
            renderedEcoEsp = false;
            examen.setHefnedadsem(null);
            examen.setHefnedaddia(null);
            examen.setHefntamauterocm(null);
            examen.setHefntamauteroml(null);
        
        }
    }

    public void setRenderedEcoEsp(boolean renderedEcoEsp) {
        this.renderedEcoEsp = renderedEcoEsp;
    }

    public boolean isRenderedEcoEsp() {
        return renderedEcoEsp;
    }

    public void setRenderedInterrupcion(boolean renderedInterrupcion) {
        this.renderedInterrupcion = renderedInterrupcion;
    }

    public boolean isRenderedInterrupcion() {
        return renderedInterrupcion;
    }

    public void setObligatoriaTemperatura(boolean obligatoriaTemperatura) {
        this.obligatoriaTemperatura = obligatoriaTemperatura;
    }

    public boolean isObligatoriaTemperatura() {
        return obligatoriaTemperatura;
    }

    public void setRenderEscala(boolean renderEscala) {
        this.renderEscala = renderEscala;
    }

    public boolean isRenderEscala() {
        return renderEscala;
    }

    public void setRenderIve(boolean renderIve) {
        this.renderIve = renderIve;
    }

    public boolean isRenderIve() {
        return renderIve;
    }

    public void setHefcevalupelvi(ValueChangeEvent valueChangeEvent) {
        examen.setHefcevalupelvi((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
    public void changeExamenPelvico(){
        renderExamenPelvico = false; 
        
        if(examen.getHefcevalupelvi() != null && examen.getHefcevalupelvi().equals("S")){
            renderExamenPelvico = true; 
        }
        
    }

    public void setRenderExamenPelvico(boolean renderExamenPelvico) {
        this.renderExamenPelvico = renderExamenPelvico;
    }

    public boolean isRenderExamenPelvico() {
        return renderExamenPelvico;
    }

    public void setNextAction2(String nextAction2) {
        this.nextAction2 = nextAction2;
    }

    public String getNextAction2() {
        return nextAction2;
    }

    public void setLstEcografia(List<SelectItem> lstEcografia) {
        this.lstEcografia = lstEcografia;
    }

    public List<SelectItem> getLstEcografia() {
        if (lstEcografia == null || lstEcografia.isEmpty()) {
            lstEcografia = new ArrayList<SelectItem>();
            lstEcografia.add(new SelectItem("", "Seleccione una opci�n "));
            lstEcografia.add(new SelectItem("R", "Rastreo"));
            lstEcografia.add(new SelectItem("E", "Ecograf�a especializada"));
            lstEcografia.add(new SelectItem("N", "No se realiza ecograf�a o rastreo"));
        }
        return lstEcografia;
    }
    
    public void changeTipoHallazgo(){
     
    if(examen !=null && examen.getHefcecoespecialis() != null && examen.getHefcecoespecialis().equals("R")){
       rastreoEco= true;
       NoEco=false;
       ecgrafiaoEco=false;
    }else if(examen !=null  && examen.getHefcecoespecialis() != null && examen.getHefcecoespecialis().equals("E")){
        rastreoEco= true;
        NoEco=false;
        ecgrafiaoEco=true;
        }
    else if(examen !=null &&  examen.getHefcecoespecialis() != null && examen.getHefcecoespecialis().equals("N")){
        rastreoEco= false;
        NoEco=false;
        ecgrafiaoEco=false;
    }else{
        rastreoEco= false;
        NoEco=false;
        ecgrafiaoEco=false;
    }
    
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHefcconfiembar(ValueChangeEvent valueChangeEvent) {
        examen.setHefcconfiembar((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }


    public void changeConfirmEmbarazo(){
        renerConfEmba = false; 
        if(examen!= null && examen.getHefcconfiembar()!= null && examen.getHefcconfiembar().equals("S")){
            renerConfEmba = true; 
        }
    }
    public void setRastreoEco(boolean rastreoEco) {
        this.rastreoEco = rastreoEco;
    }

    public boolean isRastreoEco() {
        return rastreoEco;
    }

    public void setNoEco(boolean noEco) {
        this.NoEco = noEco;
    }

    public boolean isNoEco() {
        return NoEco;
    }

    public void setEcgrafiaoEco(boolean ecgrafiaoEco) {
        this.ecgrafiaoEco = ecgrafiaoEco;
    }

    public boolean isEcgrafiaoEco() {
        return ecgrafiaoEco;
    }

    public void setRenerConfEmba(boolean renerConfEmba) {
        this.renerConfEmba = renerConfEmba;
    }

    public boolean isRenerConfEmba() {
        return renerConfEmba;
    }

    public void setMnuConfemb(UIInput mnuConfemb) {
        this.mnuConfemb = mnuConfemb;
    }

    public UIInput getMnuConfemb() {
        return mnuConfemb;
    }

    public void setRenderedSpo2(boolean renderedSpo2) {
        this.renderedSpo2 = renderedSpo2;
    }

    public boolean isRenderedSpo2() {
        return renderedSpo2;
    }
}

