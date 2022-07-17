//=======================================================================
// ARCHIVO SeguimientoPsicologiaBean.java
// FECHA CREACI�N: 20/05/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes al seguimiento de Psicologia
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.util.Date;

import org.profamilia.hc.model.dto.Chseguipsico;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================

//=================================================================
//  CLASE SeguimientoPsicologiaBean
//=======================================================================

 /**
  * SeguimientoPsicologiaBean: Permite registrar el seguimiento al tratamiento de Psicologia
  * @author Jos� Andr�s Riano jariano@profamilia.org.co
  * 
  */
public class SeguimientoPsicologiaBean extends BaseBean{


    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    
    private Chseguipsico seguimiento;
    
    private String tipoServicio; 
    
    private Long numeroConsulta; 
    
    private Integer tipoHistoria; 
    
    private Chusuario usuario; 
    
    private String nextAction; 
    
    private String menuBean; 
    
    private String navigationRule; 
    
    private String compromisos; 
    
    private boolean renderCompromisos; 
    
    
    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    
    public SeguimientoPsicologiaBean() {
    }
    
    
    //ACTIONS
    
     public void inicializarSegumiento(){
         if (numeroConsulta != null) {
         
             compromisos = ""; 
             renderCompromisos = false; 
             
             if(usuario != null && usuario.getHuslnumero()!= null){
                try {
                    compromisos  = this.serviceLocator.getClinicoService().getCompromisosPsicologiaByUsuario(usuario.getHuslnumero());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
            
            if(compromisos !=null  && !compromisos.equals("")){
                renderCompromisos = true; 
            }
             
             

             try {
                 seguimiento = 
                         this.getServiceLocator().getClinicoService().getSeguimientoPsicologia(numeroConsulta, 
                                                                                               TIPO_CONSULTA);

             } catch (ModelException e) {
                 e.printStackTrace();
             }

         }

         if (seguimiento == null) {
             seguimiento = new Chseguipsico();
         } 
         }
     
    //-----------------------------------------------------------------------------------------------
    //  Bot�n Principal
    //------------------------------------------------------------------------------------------------    

    public String aceptar() {

                navigationRule = "";

               if (numeroConsulta != null) {
                    seguimiento.getId().setHspctiposervi(tipoServicio);
                    seguimiento.getId().setHsplconsulta(numeroConsulta);
                    seguimiento.setHspcoperador(userName());
                    seguimiento.setHspdfecregistr(new Date());
                }

                try {

                    this.serviceLocator.getClinicoService().saveSeguimientoPsicologia(seguimiento);
                    FacesUtils.addInfoMessage(IMsg.MSG_ADICION);

                    // Se recarga el menu 
                    FacesUtils.resetManagedBean(menuBean);
                    navigationRule = nextAction;

                } catch (ModelException e) {
                    e.printStackTrace();
                    navigationRule = "";
                    FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                }

                return navigationRule;
            }

    
    
    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaci�n fue ingresada correctamente en la base de datos
    //------------------------------------------------------------------------------------------------
    
    public boolean esValido(){
        Long numero;
        numero = null;
        Chseguipsico seguimientoAux = null;

        if (numeroConsulta != null) {
            numero = numeroConsulta;
        }

        if (numero != null) {
            try {
                seguimientoAux = 
                        this.getServiceLocator().getClinicoService().getSeguimientoPsicologia(numero, 
                                                                                              TIPO_CONSULTA);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (seguimientoAux != null) {
            return true;
        }

        return false;
        }

    
    
    //-----------------------------------------------------------------------------------------------
    //  Jasper
    //------------------------------------------------------------------------------------------------
        
        // NO TIENE

    //-----------------------------------------------------------------------
    //  Ajax
    //-----------------------------------------------------------------------

     // NO TIENE

     //-----------------------------------------------------------------------
     //  Accesorios
     //-----------------------------------------------------------------------

    /**
     * @param seguimiento
     */
    public void setSeguimiento(Chseguipsico seguimiento) {
        this.seguimiento = seguimiento;
    }

    /**
     * @return
     */
    public Chseguipsico getSeguimiento() {
        return seguimiento;
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
     * @param compromisos
     */
    public void setCompromisos(String compromisos) {
        this.compromisos = compromisos;
    }

    /**
     * @return
     */
    public String getCompromisos() {
        return compromisos;
    }

    /**
     * @param renderCompromisos
     */
    public void setRenderCompromisos(boolean renderCompromisos) {
        this.renderCompromisos = renderCompromisos;
    }

    /**
     * @return
     */
    public boolean isRenderCompromisos() {
        return renderCompromisos;
    }
}
