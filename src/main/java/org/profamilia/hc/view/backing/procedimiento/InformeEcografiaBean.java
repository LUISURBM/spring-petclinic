//=======================================================================
// ARCHIVO InformeEcografiaBean.java
// FECHA CREACI�N: 09/06/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes al Informe de Ecografia
//=======================================================================
package org.profamilia.hc.view.backing.procedimiento;

import java.util.Date;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;

import org.profamilia.hc.model.dto.Chinfomamogr;
import org.profamilia.hc.model.dto.ChinfomamogrPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarInformeEcografiasBean;
import org.profamilia.hc.view.backing.comun.CerrarInformeEcografiaBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorPlantillaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE InformeEcografiaBean
//=======================================================================

public class InformeEcografiaBean extends BaseBean{

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chinfomamogr informe;

    /** Almacena el consulta */
    private Cnconsclin consulta;

    private String navigationRule;

    private String tipoServicio;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private String nextAction;

    /**  */
    private String menuBean;

    private boolean renderBuscador;

    private UIInput itInforme;

    private int selectIndex;

    private boolean wexito;

    static int ACTIVAR_INFORME = 0;

    static int ACTIVAR_BUSCADOR = 1;
    
    private boolean esCeroGestaciones; 
    
    private UIInput itNumGesta; 
    private UIInput itNumPartos; 
    private UIInput itNumAbortos; 
    private UIInput itNumcesareas; 
    private UIInput itNumEctopicos; 
    private UIInput calendarUltimaRegla; 


    


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public InformeEcografiaBean() {
    }

    public void init() {
        inicializarEcografia();
     }

    public void inicializarEcografia() {
        
        esCeroGestaciones = false; 
        try {
            if (consulta != null) {
                informe = 
                        serviceLocator.getClinicoService().getInformeMamografia(consulta, 
                                                                                IConstantes.INFORME_ECOGRAFIA);
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (informe == null) {
            informe = new Chinfomamogr();
            String servicioAux = null;
            if(consulta!= null && consulta.getCcocservic()!= null && consulta.getCcocservic().getCsvcnombre()!= null)
            servicioAux = consulta.getCcocservic().getCsvcnombre();
            if(servicioAux!= null && servicioAux.length() > 80){
                servicioAux = servicioAux.substring(0,79); 
            }
            informe.setHimcdescrinfor(servicioAux);
   
        } else {
            if (informe.getHimnnumgesta()!= null && 
                informe.getHimnnumgesta().compareTo(0) == 0) {
                esCeroGestaciones = true; 
            
            }
   
        }
    }

    //-----------------------------------------------------------------------
    //  GET/SET
    //-----------------------------------------------------------------------

  
    /**
     * @param informe
     */
    public void setInforme(Chinfomamogr informe) {
        this.informe = informe;
    }

    /**
     * @return
     */
    public Chinfomamogr getInforme() {
        return informe;
    }


    /**
     * @param consulta
     */
    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    /**
     * @return
     */
    public Cnconsclin getConsulta() {
        return consulta;
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
     * @param itInforme
     */
    public void setItInforme(UIInput itInforme) {
        this.itInforme = itInforme;
    }

    /**
     * @return
     */
    public UIInput getItInforme() {
        return itInforme;
    }

    /**
     * @param selectIndex
     */
    public void setSelectIndex(int selectIndex) {
        this.selectIndex = selectIndex;
    }

    /**
     * @return
     */
    public int getSelectIndex() {
        return selectIndex;
    }

    /**
     * @param esCeroGestaciones
     */
    public void setEsCeroGestaciones(boolean esCeroGestaciones) {
        this.esCeroGestaciones = esCeroGestaciones;
    }

    /**
     * @return
     */
    public boolean isEsCeroGestaciones() {
        return esCeroGestaciones;
    }

    /**
     * @param itNumGesta
     */
    public void setItNumGesta(UIInput itNumGesta) {
        this.itNumGesta = itNumGesta;
    }

    /**
     * @return
     */
    public UIInput getItNumGesta() {
        return itNumGesta;
    }

    /**
     * @param itNumPartos
     */
    public void setItNumPartos(UIInput itNumPartos) {
        this.itNumPartos = itNumPartos;
    }

    /**
     * @return
     */
    public UIInput getItNumPartos() {
        return itNumPartos;
    }

    /**
     * @param itNumAbortos
     */
    public void setItNumAbortos(UIInput itNumAbortos) {
        this.itNumAbortos = itNumAbortos;
    }

    /**
     * @return
     */
    public UIInput getItNumAbortos() {
        return itNumAbortos;
    }

    /**
     * @param itNumcesareas
     */
    public void setItNumcesareas(UIInput itNumcesareas) {
        this.itNumcesareas = itNumcesareas;
    }

    /**
     * @return
     */
    public UIInput getItNumcesareas() {
        return itNumcesareas;
    }

   

    /**
     * @param itNumEctopicos
     */
    public void setItNumEctopicos(UIInput itNumEctopicos) {
        this.itNumEctopicos = itNumEctopicos;
    }

    /**
     * @return
     */
    public UIInput getItNumEctopicos() {
        return itNumEctopicos;
    }


    /**
     * @param calendarUltimaRegla
     */
    public void setCalendarUltimaRegla(UIInput calendarUltimaRegla) {
        this.calendarUltimaRegla = calendarUltimaRegla;
    }

    /**
     * @return
     */
    public UIInput getCalendarUltimaRegla() {
        return calendarUltimaRegla;
    }


    //-----------------------------------------------------------------------
    //  ESVALIDO
    //-----------------------------------------------------------------------

    /**
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        /** Almacena el motivo de consulta el cual se va a persistir*/
        Chinfomamogr informeAux = null;
        if (consulta != null) {
            try {
                informeAux = 
                        this.getServiceLocator().getClinicoService().getInformeMamografia(consulta, 
                                                                                          IConstantes.INFORME_ECOGRAFIA);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (informeAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }



  

    //-----------------------------------------------------------------------
    //  BOTONES SECUNDARIOS
    //-----------------------------------------------------------------------
    
    
     public void changeNumeroGestaciones() {

         if (informe != null && informe.getHimnnumgesta() != null) {
             // Verificamos si el numero de gestaciones es cero los campos de partos, abortos, cesareas
             // vivos, ectopicos, mortinatos e hijos muertos es cero.
             if (informe.getHimnnumgesta().compareTo(0) == 0) {
                 informe.setHimnectopico(0);
                 informe.setHimnnumaborto(0);
                 informe.setHimnnumcesare(0);
                 informe.setHimnnumparto(0);
                 
                 
                 itNumPartos.setValue(0);
                 itNumAbortos.setValue(0);
                 itNumcesareas.setValue(0);
                 itNumEctopicos.setValue(0);
                 calendarUltimaRegla.setValue(null);
                 
                 esCeroGestaciones = true;
             } else {
                 Integer numero = null;
                 esCeroGestaciones = false;
                 informe.setHimnectopico(numero);
                
                 informe.setHimnnumaborto(numero);
                 informe.setHimnnumcesare(numero);
                 informe.setHimnnumparto(numero);
               
                 
                 itNumPartos.setValue(numero);
                 itNumAbortos.setValue(numero);
                 itNumcesareas.setValue(numero);
                 itNumEctopicos.setValue(numero);
               
             }

         }

     }
    
    

    public void aceptarPlantilla() {
        BuscadorPlantillaBean buscador = 
            (BuscadorPlantillaBean)FacesUtils.getManagedBean("buscadorPlantillaBean");
        if (buscador != null && buscador.getPlantillaSelect() != null) {
            informe.setHimcinformamog(buscador.getPlantillaSelect().getHplcdescripcio());
            itInforme.setValue(buscador.getPlantillaSelect().getHplcdescripcio());
        }
        renderBuscador = false;
        selectIndex = ACTIVAR_INFORME;
        FacesUtils.resetManagedBean("buscadorPlantillaBean");

    }


    public void mostrarBuscadorPlantilla() {
      //  if (!modoconsulta) {
            selectIndex = ACTIVAR_BUSCADOR;
            FacesUtils.resetManagedBean("buscadorPlantillaBean");
            renderBuscador = true;
      //  }

    }


    /**
     * @param valueChangeEvent
     */
    public void setHimnnumgesta(ValueChangeEvent valueChangeEvent) {
           informe.setHimnnumgesta((Integer)valueChangeEvent.getNewValue());
           ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
           }


    //-----------------------------------------------------------------------
    //  BOTON PRINCIPAL
    //-----------------------------------------------------------------------

    public String generarEcografia() {
        informe.setHimcoperador(userName());
        informe.setHimdfecregistr(new Date());
        navigationRule = "";
        // No aplica N�mero 
        informe.setHimnnumero(0);
        wexito = true;

        if (consulta != null && consulta.getCconnumero() != null) {
            ChinfomamogrPK id = new ChinfomamogrPK();
            id.setHimlconsulta(new Long(consulta.getCconnumero()));
            id.setHimctipoinform(IConstantes.INFORME_ECOGRAFIA);
            id.setHimctiposervi(tipoServicio);
            informe.setId(id);
        }

        if (informe == null || informe.getHimcinformamog() == null || 
            informe.getHimcinformamog().equals("")) {
            wexito = false;
            navigationRule = "";
            FacesUtils.addErrorMessage("body:formInformeEcografia:panelTabInformeEcografia:itInformeEcografia", 
                                       MSG_CAMPO_OBLIGATORIO);
        }
        
        if (informe.getHimnnumgesta()!= null 
        && informe.getHimnnumgesta().compareTo(0) == 0) {
            informe.setHimnectopico(0);
            informe.setHimnnumaborto(0);
            informe.setHimnnumcesare(0);
            informe.setHimnnumparto(0);
            esCeroGestaciones = true;
        }
        
        if(informe.getHimnedadgesmes()!= null){
        
            if(informe.getHimndiasgestac() == null){
                informe.setHimndiasgestac(0); 
            }
            
        }


        if (wexito) {
            try {
                this.serviceLocator.getClinicoService().saveInformeMamografia(informe);
           //     modoconsulta = true;
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                if (informe != null) {
                
                    
                
                    ConsultarInformeEcografiasBean folio;
                    folio = 
                            (ConsultarInformeEcografiasBean)FacesUtils.getManagedBean("consultarInformeEcografiasBean");

                    if (folio != null && usuario != null && informe != null && informe.getId()!= null) {
                        folio.setInforme(informe);
                        folio.setUsuario(usuario);
                        folio.setConsulta(consulta);
                        folio.setNumeroConsulta(informe.getId().getHimlconsulta());
                        folio.setGeneroInforme(false);
                        folio.init();
                        folio.visualizarConsulta();

                    }
                }
                navigationRule = nextAction;
                FacesUtils.resetManagedBean(menuBean);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                navigationRule = "";
                e.printStackTrace();
            }

     
        }
        
            

        return navigationRule;

    }


  
}
