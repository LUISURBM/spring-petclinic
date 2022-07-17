//=======================================================================
// ARCHIVO ExamenFisicoPrenatalUsuarioBean.java
// FECHA CREACI�N: 
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes al examen f�sico de la Historia Prenatal
//=======================================================================
package org.profamilia.hc.view.backing.comun;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================
import java.math.BigDecimal;

import java.text.NumberFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import org.profamilia.hc.model.dto.Chcontrolpre;
import org.profamilia.hc.model.dto.ChcontrolprePK;
import org.profamilia.hc.model.dto.Chexamfisico;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;

//=======================================================================
//  CLASE ExamenFisicoPrenatalUsuarioBean
//=======================================================================

public class ExamenFisicoPrenatalUsuarioBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chcontrolpre control;

    private List lstNormal;

    private List lstOpciones;

    private List lstResultado;

    private boolean habilitarAlturaUterina;

    private boolean habilitarFCF;

    private boolean habilitarmovimientoFetal;

    private boolean habilitarpresentacionFetal;

    private boolean existeParcial;


    /** Almacena true si la temperatura es Febril*/
    private boolean esFebril;

    private List lstTemperatura;

    Date fechaUltimaRegla;

    private Double semanaGestacion;

    private Integer tipoHistoria;
    
    private String tipoServicio; 
    
    private Long numeroConsulta; 
    
    private String nextAction; 
    
    private String menuBean; 
    
    private Chusuario usuario; 
    
    private String navigationRule; 
    
    // Variables que muestra los antecedentes 
    
    private boolean renderorl; 
    
    private boolean renderext; 
    
    private boolean rendercar; 
    
    private boolean rendersis; 
    
    private HtmlDataTable dtControl;
    
    private List<Chcontrolpre> lstControlPrenatal;
    
    /** Almacena el codigo de la consulta principal*/
    private Long codigoHistoriaPrincipal;
    
    private List lstEstadoNutricional;
    
    private boolean renderGeni; 
    
    private boolean renderGastro;
    
    private boolean renderExamenFisico; 
    
    private BigDecimal imc; 
 

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ExamenFisicoPrenatalUsuarioBean() {
  
    }

    public void init() {
        control = new Chcontrolpre();
        lstNormal = new ArrayList();
        lstOpciones = new ArrayList();
        lstResultado = new ArrayList();
        lstTemperatura = new ArrayList();
        lstEstadoNutricional = new ArrayList();
        renderExamenFisico=false;
        inicializarExamen();
        imc = new BigDecimal(0);
        
        


        
    }
    
    
    public void inicializarExamen(){
        Chexamfisico  exafis = null;
            if(codigoHistoriaPrincipal != null){
            try {
                lstControlPrenatal =
                                           this.getServiceLocator().getClinicoService().getExamenFisicoControlPrenatal(codigoHistoriaPrincipal);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

           if (semanaGestacion != null) {
               // Si estamos en la semana 15 o superior se pide la alturauterina
               if (semanaGestacion >= 15) {
                   habilitarAlturaUterina = true;
               } else {
                   habilitarAlturaUterina = false;
               }
               // Si estamos en la semana 18 o superior pedimos la frecuencia cardiaca fetal
               if (semanaGestacion >= 18) {
                   habilitarFCF = true;
               } else {
                   habilitarFCF = false;
               }
               // Si estamos en la semana 20 o superior pedimos el movimiento fetal
               if (semanaGestacion >= 20) {
                   habilitarmovimientoFetal = true;
               } else {
                   habilitarmovimientoFetal = false;
               }

               // Si estamos en la semana 32 o superior pedimos la presentaci�n fetal
               if (semanaGestacion >= 32) {
                   habilitarpresentacionFetal = true;
               } else {
                   habilitarpresentacionFetal = false;
               }

           }

          
               try {
                   control = 
                           this.serviceLocator.getClinicoService().getControlPrenatal(numeroConsulta);
               } catch (ModelException e) {
                   e.printStackTrace();
               }

          

           if (control == null) {
               control = new Chcontrolpre();
           }else{
               if(control.getHcpctienhalorl()!= null && control.getHcpctienhalorl().equals("S")){
                   renderorl = true; 
               }
               
               if(control.getHcpctienhalext()!= null && control.getHcpctienhalext().equals("S")){
                   renderext = true; 
               }
               
               if(control.getHcpctienhalcar()!= null && control.getHcpctienhalcar().equals("S")){
                   rendercar = true; 
               }
               
               if(control.getHcpctienhalsis()!= null && control.getHcpctienhalsis().equals("S")){
                   rendersis = true; 
               }
               
               if(control.getHcpcgenituri() != null && control.getHcpcgenituri().equals("S")){
                   renderGeni = true; 
               }
               
               if(control.getHcpcgastroin()!= null && control.getHcpcgastroin().equals("S")){
                   renderGastro = true; 
               }
  
    
           }
    }
    
    //-----------------------------------------------------------------------
    //  GET/SET
    //-----------------------------------------------------------------------

         /**
          * @param control
          */
         public void setControl(Chcontrolpre control) {
             this.control = control;
         }

         /**
          * @return
          */
         public Chcontrolpre getControl() {
             return control;
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
          * @param lstNormal
          */
         public void setLstNormal(List lstNormal) {
             this.lstNormal = lstNormal;
         }

         /**
          * @return
          */
         public List getLstNormal() {
             if (lstNormal.size() == 0) {
                 lstNormal.add(new SelectItem("N", "Normal"));
                 lstNormal.add(new SelectItem("A", "Anormal"));

             }

             return lstNormal;
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
        if (lstOpciones.size() == 0) {
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));

        }

        return lstOpciones;
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
     * @param lstResultado
     */
    public void setLstResultado(List lstResultado) {
        this.lstResultado = lstResultado;
    }

    /**
     * @return
     */
    public List getLstResultado() {
        if (lstResultado.size() == 0) {
            lstResultado.add(new SelectItem("+", "+"));
            lstResultado.add(new SelectItem("-", "-"));

        }

        return lstResultado;
    }


    /**
     * @param navigationRule
     */
    public void setNavigationRule(String navigationRule) {
            this.navigationRule = navigationRule;
        }

    /**
     * @return
     */
    public String getNavigationRule() {
            return navigationRule;
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
     * @param existeParcial
     */
    public void setExisteParcial(boolean existeParcial) {
        this.existeParcial = existeParcial;
    }

    /**
     * @return
     */
    public boolean isExisteParcial() {
        return existeParcial;
    }

    /**
     * @param habilitarAlturaUterina
     */
    public void setHabilitarAlturaUterina(boolean habilitarAlturaUterina) {
        this.habilitarAlturaUterina = habilitarAlturaUterina;
    }

    /**
     * @return
     */
    public boolean isHabilitarAlturaUterina() {
        return habilitarAlturaUterina;
    }

    /**
     * @param habilitarFCF
     */
    public void setHabilitarFCF(boolean habilitarFCF) {
        this.habilitarFCF = habilitarFCF;
    }

    /**
     * @return
     */
    public boolean isHabilitarFCF() {
        return habilitarFCF;
    }

    /**
     * @param habilitarmovimientoFetal
     */
    public void setHabilitarmovimientoFetal(boolean habilitarmovimientoFetal) {
        this.habilitarmovimientoFetal = habilitarmovimientoFetal;
    }

    /**
     * @return
     */
    public boolean isHabilitarmovimientoFetal() {
        return habilitarmovimientoFetal;
    }

    /**
     * @param habilitarpresentacionFetal
     */
    public void setHabilitarpresentacionFetal(boolean habilitarpresentacionFetal) {
        this.habilitarpresentacionFetal = habilitarpresentacionFetal;
    }

    /**
     * @return
     */
    public boolean isHabilitarpresentacionFetal() {
        return habilitarpresentacionFetal;
    }


    /**
     * @param semanaGestacion
     */
    public void setSemanaGestacion(Double semanaGestacion) {
        this.semanaGestacion = semanaGestacion;
    }

    /**
     * @return
     */
    public Double getSemanaGestacion() {
        return semanaGestacion;
    }
    
    
    /**
    * @param lstTemperatura
    */
    public void setLstTemperatura(List lstTemperatura) {
      this.lstTemperatura = lstTemperatura;
    }

    /**
    * @return
    */
    public List getLstTemperatura() {
      if (lstTemperatura.size() == 0) {
          lstTemperatura.add(new SelectItem("", "Seleccione una opci�n"));
          lstTemperatura.add(new SelectItem("A", "Afebril"));
          lstTemperatura.add(new SelectItem("F", "Febril"));
      }
      return lstTemperatura;
    }


    /**
     * @param fechaUltimaRegla
     */
    public void setFechaUltimaRegla(Date fechaUltimaRegla) {
            this.fechaUltimaRegla = fechaUltimaRegla;
        }

    /**
     * @return
     */
    public Date getFechaUltimaRegla() {
            return fechaUltimaRegla;
        }

    /**
     * @param renderorl
     */
    public void setRenderorl(boolean renderorl) {
            this.renderorl = renderorl;
        }

    /**
     * @return
     */
    public boolean isRenderorl() {
            return renderorl;
        }

    /**
     * @param renderext
     */
    public void setRenderext(boolean renderext) {
            this.renderext = renderext;
        }

    /**
     * @return
     */
    public boolean isRenderext() {
            return renderext;
        }

    /**
     * @param rendercar
     */
    public void setRendercar(boolean rendercar) {
            this.rendercar = rendercar;
        }

    /**
     * @return
     */
    public boolean isRendercar() {
            return rendercar;
        }

    /**
     * @param rendersis
     */
    public void setRendersis(boolean rendersis) {
            this.rendersis = rendersis;
        }

    /**
     * @return
     */
    public boolean isRendersis() {
            return rendersis;
        }

    /**
     * @param dtControl
     */
    public void setDtControl(HtmlDataTable dtControl) {
        this.dtControl = dtControl;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtControl() {
        return dtControl;
    }

    /**
     * @param lstControlPrenatal
     */
    public void setLstControlPrenatal(List<Chcontrolpre> lstControlPrenatal) {
        this.lstControlPrenatal = lstControlPrenatal;
    }

    /**
     * @return
     */
    public List<Chcontrolpre> getLstControlPrenatal() {
        return lstControlPrenatal;
    }

    /**
     * @param codigoHistoriaPrincipal
     */
    public void setCodigoHistoriaPrincipal(Long codigoHistoriaPrincipal) {
        this.codigoHistoriaPrincipal = codigoHistoriaPrincipal;
    }

    /**
     * @return
     */
    public Long getCodigoHistoriaPrincipal() {
        return codigoHistoriaPrincipal;
    }

    
     //-----------------------------------------------------------------------
     //  AJAX
     //-----------------------------------------------------------------------

    /**
     * @param valueChangeEvent
     */
    public void setTalla(ValueChangeEvent valueChangeEvent) {
          control.setHcpatalla((BigDecimal)valueChangeEvent.getNewValue());
          ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
      }


    /**
     * @param valueChangeEvent
     */
    public void setHcpapeso(ValueChangeEvent valueChangeEvent) {
        control.setHcpapeso((BigDecimal)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
    /**
     * @param valueChangeEvent
     */
    public void setTipoTempSelect(ValueChangeEvent valueChangeEvent) {
          control.setHcpetipotemper((String)valueChangeEvent.getNewValue());
          ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
      }
      
    public void calcularIMC() {

        String imcStr = null;
        String masacor = null; 
        double imc = 0;
        if (control.getHcpatalla() != null && control.getHcpapeso() != null) {
            if (control.getHcpatalla().doubleValue() != 0 && control.getHcpapeso().doubleValue() != 0) {
                imc = 
    control.getHcpapeso().doubleValue() / ((control.getHcpatalla().doubleValue()) * (control.getHcpatalla().doubleValue()));
            }

            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(2);
            imcStr = nf.format(imc);
            if (imcStr != null && !imcStr.equals("")) {
                masacor = imcStr.replace(",", ".");
            } else {
                masacor = null;
            }
            
            if(masacor != null && !masacor.equals("")){
                control.setHcpaimc(new BigDecimal(masacor));    
            }
            

        }

    }
      
    public void changeTemperatura() {
        if (control != null && control.getHcpetipotemper().equals("F")) {
            esFebril = true;
        } else {
            esFebril = false;
        }
    }

    /**
     * @param valueChangeEvent
     */
    public void setRenderorl(ValueChangeEvent valueChangeEvent) {
        setRenderorl((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setRendercar(ValueChangeEvent valueChangeEvent) {
         setRendercar((Boolean)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }

    /**
     * @param valueChangeEvent
     */
    public void setRenderext(ValueChangeEvent valueChangeEvent) {
        setRenderext((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setRendersis(ValueChangeEvent valueChangeEvent) {
        setRendersis((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        
    /**
     * @param valueChangeEvent
     */
    public void setRenderGeni1(ValueChangeEvent valueChangeEvent) {
        setRenderGeni((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setRenderGastro1(ValueChangeEvent valueChangeEvent) {
        setRenderGastro((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }  
        
        
    public void changeOrl(){
        
    }
    
    public void changeCardio(){
        
    }
    
    public void changeExtremidades(){
        
    }
    
    public void changeSistema(){
        
    }
    
    public void changeGeniturinario(){
        
    }
    
    public void changeGastrointestinal(){
        
    }


    //-----------------------------------------------------------------------
    //  METODO ESVALIDO 
    //-----------------------------------------------------------------------
     
     /**
      * @return
      */
     public boolean esValido() {
         boolean esValido = false;
         Chcontrolpre controlAux = null;
         if (numeroConsulta != null) {
             try {
                 controlAux = 
                         this.serviceLocator.getClinicoService().getControlPrenatal(numeroConsulta);
             } catch (ModelException e) {
                 e.printStackTrace();
             }
         }
         if (controlAux != null) {
             esValido = true;
         } else {
             esValido = false;
         }
         return esValido;
     }
     
     
     
      //-----------------------------------------------------------------------
      //  BOTON PRINCIPAL
      //-----------------------------------------------------------------------


    /**
     * @return
     */
    public String aceptar() {
    
        if(!renderorl){
            control.setHcpthallaorl(null);
            control.setHcpctienhalorl("N");
        }else{
            control.setHcpctienhalorl("S");
        }
        
         if(!renderext){
             control.setHcpthallaextre(null);
             control.setHcpctienhalext("N");
         }else{
             control.setHcpctienhalext("S");
         }
        
         if(!rendercar){
             control.setHcpthallcarpul(null);
             control.setHcpctienhalcar("N");
         }else{
             control.setHcpctienhalcar("S");
         }
        
         if(!rendersis){
             control.setHcpthallsisner(null);
             control.setHcpctienhalsis("N");
         }else{
             control.setHcpctienhalsis("S");
         }
         
        if(!renderGeni){
            control.setHcpcdescgeni(null);
            control.setHcpcgenituri("N");
        }else{
            control.setHcpcgenituri("S");
        }
        
        if(!renderGastro){
            control.setHcpcdescgast(null);
            control.setHcpcgastroin("N");
        }else{
            control.setHcpcgastroin("S");
        }
         
         

        ChcontrolprePK id = new ChcontrolprePK();
        navigationRule = ""; 

        if (numeroConsulta != null) {
            Long idConsulta = numeroConsulta; 
            id.setHcplconsulta(idConsulta);
            id.setHcpctiposervi(TIPO_CONSULTA);
            control.setId(id);
            
            if(codigoHistoriaPrincipal!= null){
                control.setHcplconsulprin(codigoHistoriaPrincipal);    
            }else{
                control.setHcplconsulprin(idConsulta);
            }
        }
        control.setHcpdfecharegis(new Date());
        control.setHcpcoperador(userName());
        try {
            this.serviceLocator.getClinicoService().saveControlPrenatal(control);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            FacesUtils.resetManagedBean(menuBean);
            navigationRule = nextAction; 
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            navigationRule = ""; 
            e.printStackTrace();
        }
        return navigationRule; 
    }


    public void setLstEstadoNutricional(List lstEstadoNutricional) {
        this.lstEstadoNutricional = lstEstadoNutricional;
    }

    public List getLstEstadoNutricional() {
        if (lstEstadoNutricional.size() == 0) {
            lstEstadoNutricional.add(new SelectItem("", "Seleccione una opcion ..."));
            lstEstadoNutricional.add(new SelectItem("OB", "Obesidad para la edad gestional"));
            lstEstadoNutricional.add(new SelectItem("SO", "Sobrepeso para la edad gestional"));
            lstEstadoNutricional.add(new SelectItem("IM", "IMC adecuado para la edad gestional"));
            lstEstadoNutricional.add(new SelectItem("BA", "Bajo peso para la edad gestional"));
        }
        return lstEstadoNutricional;
    }

    public void setRenderGeni(boolean renderGeni) {
        this.renderGeni = renderGeni;
    }

    public boolean isRenderGeni() {
        return renderGeni;
    }

    public void setRenderGastro(boolean renderGastro) {
        this.renderGastro = renderGastro;
    }

    public boolean isRenderGastro() {
        return renderGastro;
    }

    public void setRenderExamenFisico(boolean renderExamenFisico) {
        this.renderExamenFisico = renderExamenFisico;
    }

    public boolean isRenderExamenFisico() {
        return renderExamenFisico;
    }

    public void setImc(BigDecimal imc) {
        this.imc = imc;
    }

    public BigDecimal getImc() {
        return imc;
    }
}
