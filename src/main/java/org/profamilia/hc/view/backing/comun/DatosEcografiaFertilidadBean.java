//=======================================================================
// ARCHIVO MotivoBean.java
// FECHA CREACI�N: 05/05/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a motivo de consulta
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chfertecog;
import org.profamilia.hc.model.dto.Chfertdato;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE MotivoBean
//=======================================================================

public class DatosEcografiaFertilidadBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chfertecog ecografia;

    private String nextAction;

    private String menuBean;

    private String navigationRule;

    private Long numeroConsulta;

    private String tipoServicio;

    private String totalFoliculosAntrales;

    private List lstOpciones;

    private List lstOvarioDerecho;

    private List lstOvarioIzquierdo;

    private boolean renderEcografia;
    
    // campos agregados
    
    private boolean renderOvarios;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public DatosEcografiaFertilidadBean() {
    }

    public void init() {

        nextAction = "";
        inicializarDatosEcografia();
        totalFoliculosAntrales = "";

    }


    // ACTIONS

    public void inicializarDatosEcografia() {

        renderOvarios = false;
        renderEcografia = false;
        if (numeroConsulta != null)
            try {
                ecografia = 
                        getServiceLocator().getClinicoService().getDatosEcografia(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

        if (ecografia == null) {
            ecografia = new Chfertecog();
        } else {

            if (ecografia.getHfectomaecog() != null && 
                ecografia.getHfectomaecog().equals("S")) {
                renderEcografia = true;
                if(ecografia.getHfecmultifol() !=null && ecografia.getHfecmultifol().equals("N")){
                    renderOvarios = true;
                }
            }

        }


    }

    /**
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        Chfertecog ecografiaAux = null;
        if (numeroConsulta != null)
            try {
                ecografiaAux = 
                        getServiceLocator().getClinicoService().getDatosEcografia(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        if (ecografiaAux != null)
            esValido = true;
        else
            esValido = false;
        return esValido;
    }


    //-----------------------------------------------------------------------
    //  GET /SET
    //-----------------------------------------------------------------------

    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    public String getNextAction() {
        return nextAction;
    }

    public void setMenuBean(String menuBean) {
        this.menuBean = menuBean;
    }

    public String getMenuBean() {
        return menuBean;
    }

    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public String getNavigationRule() {
        return navigationRule;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setEcografia(Chfertecog ecografia) {
        this.ecografia = ecografia;
    }

    public Chfertecog getEcografia() {
        return ecografia;
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


    //-----------------------------------------------------------------------
    //  AJAX
    //-----------------------------------------------------------------------

    public void setTomaEcografia(ValueChangeEvent valueChangeEvent) {
        ecografia.setHfectomaecog((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setMultifolicular(ValueChangeEvent valueChangeEvent) {
        ecografia.setHfecmultifol((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHfecovarioizq(ValueChangeEvent valueChangeEvent) {
        ecografia.setHfecovarioizq((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public void setHfecovarioder(ValueChangeEvent valueChangeEvent) {
        ecografia.setHfecovarioder((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void changeEcografia() {
        renderEcografia = false;

        if (ecografia != null) {
            if (ecografia.getHfectomaecog() != null && 
                ecografia.getHfectomaecog().equals("S")) {
                renderEcografia = true;
            }
        }

    }
    
    public void changeOvarios() {
        renderOvarios = false;

        if (ecografia != null) {
            if (ecografia.getHfecmultifol() != null && 
                ecografia.getHfecmultifol().equals("N")) {
                renderOvarios = true;
            }
        }

    }

    //-----------------------------------------------------------------------
    //  BOTON PRINCIPAL
    //-----------------------------------------------------------------------

    public String guardar() {
        String navigationRule = "";

        boolean exito = true;
        ecografia.setHfelconsulta(numeroConsulta);

        if (!renderEcografia) {
            ecografia.setHfecanexos(null);
            ecografia.setHfecendometrio(null);
            ecografia.setHfecutero(null);
            ecografia.setHfexutero(null);
            ecografia.setHfecovarioder(null);
            ecografia.setHfecovarioizq(null);
            ecografia.setHfecmultifol(null);
            ecografia.setHfecobservac("");
        } else {
            if (ecografia.getHfecanexos() == null || ecografia.getHfecanexos().equals("") || 
                ecografia.getHfecendometrio() == null || ecografia.getHfecendometrio().equals("") ||
                ecografia.getHfexutero() == null || ecografia.getHfexutero().equals("") ) {
                exito = false;        
            }
        }
        if(!renderOvarios){
            ecografia.setHfecovarioder(null);
            ecografia.setHfecovarioizq(null);
          
        }
        else{
            if(ecografia.getHfecovarioder() == null ||    ecografia.getHfecovarioizq() == null ){
                exito = false;
            }  
        }

        if (exito) {
            try {
              this.serviceLocator.getClinicoService().saveDatosEcografiaFertilidad(ecografia);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);

                // Se recarga el menu 
             FacesUtils.resetManagedBean(menuBean);
             navigationRule = nextAction;

            } catch (ModelException e) {
                FacesUtils.addErrorMessage(null, e.getMessage(), 
                                       IMsg.MSG_NO_ADICION);
                e.printStackTrace();
                navigationRule = "";
            }
        } else {
            FacesUtils.addErrorMessage(IMsg.MSG_FALTAN_DATOS_ECO_FERTILIDAD);
            navigationRule = "";
        }

        // Se establece la siguiente accion de navegacion
        return navigationRule;
    }


    public void setRenderEcografia(boolean renderEcografia) {
        this.renderEcografia = renderEcografia;
    }

    public boolean isRenderEcografia() {
        return renderEcografia;
    }


    public void setLstOvarioDerecho(List lstOvarioDerecho) {
        this.lstOvarioDerecho = lstOvarioDerecho;
    }

    public List getLstOvarioDerecho() {
        if (lstOvarioDerecho == null || lstOvarioDerecho.isEmpty()) {
            lstOvarioDerecho = new ArrayList();
            lstOvarioDerecho.add(new SelectItem("Seleccione ..."));
            lstOvarioDerecho.add(new SelectItem(0, "0"));
            lstOvarioDerecho.add(new SelectItem(1, "1"));
            lstOvarioDerecho.add(new SelectItem(2, "2"));
            lstOvarioDerecho.add(new SelectItem(3, "3"));
            lstOvarioDerecho.add(new SelectItem(4, "4"));
            lstOvarioDerecho.add(new SelectItem(5, "5"));
            lstOvarioDerecho.add(new SelectItem(6, "6"));
            lstOvarioDerecho.add(new SelectItem(7, "7"));
            lstOvarioDerecho.add(new SelectItem(8, "8"));
            lstOvarioDerecho.add(new SelectItem(9, "9"));
            lstOvarioDerecho.add(new SelectItem(10, "10"));
            lstOvarioDerecho.add(new SelectItem(11, "11"));
            lstOvarioDerecho.add(new SelectItem(12, "12"));
           
        }

        return lstOvarioDerecho;
    }

    public void setLstOvarioIzquierdo(List lstOvarioIzquierdo) {
        this.lstOvarioIzquierdo = lstOvarioIzquierdo;
    }

    public List getLstOvarioIzquierdo() {

        if (lstOvarioIzquierdo == null || lstOvarioIzquierdo.isEmpty()) {
            lstOvarioIzquierdo = new ArrayList();
            lstOvarioIzquierdo.add(new SelectItem("Seleccione ..."));
            lstOvarioIzquierdo.add(new SelectItem(0, "0"));
            lstOvarioIzquierdo.add(new SelectItem(1, "1"));
            lstOvarioIzquierdo.add(new SelectItem(2, "2"));
            lstOvarioIzquierdo.add(new SelectItem(3, "3"));
            lstOvarioIzquierdo.add(new SelectItem(4, "4"));
            lstOvarioIzquierdo.add(new SelectItem(5, "5"));
            lstOvarioIzquierdo.add(new SelectItem(6, "6"));
            lstOvarioIzquierdo.add(new SelectItem(7, "7"));
            lstOvarioIzquierdo.add(new SelectItem(8, "8"));
            lstOvarioIzquierdo.add(new SelectItem(9, "9"));
            lstOvarioIzquierdo.add(new SelectItem(10, "10"));
            lstOvarioIzquierdo.add(new SelectItem(11, "11"));
            lstOvarioIzquierdo.add(new SelectItem(12, "12"));
          


        }
        return lstOvarioIzquierdo;
    }

    public void calcularTotal() {

        Integer calculoFoliculos;
        calculoFoliculos = 0;

        if (ecografia.getHfecovarioder() != null && 
            ecografia.getHfecovarioizq() != null) {


            calculoFoliculos = 
                    ecografia.getHfecovarioder() +ecografia.getHfecovarioizq();


            totalFoliculosAntrales = 
                    "Total de Fol�culos Antrales: " + calculoFoliculos;

        }
        if (ecografia.getHfecovarioder() == null && 
            ecografia.getHfecovarioizq() == null) {

            totalFoliculosAntrales = "Total de Fol�culos Antrales: " + "0";

        }
    }

    public void setTotalFoliculosAntrales(String totalFoliculosAntrales) {
        this.totalFoliculosAntrales = totalFoliculosAntrales;
    }

    public String getTotalFoliculosAntrales() {
        return totalFoliculosAntrales;
    }


    public void setRenderOvarios(boolean renderOvarios) {
        this.renderOvarios = renderOvarios;
    }

    public boolean isRenderOvarios() {
        return renderOvarios;
    }
}
