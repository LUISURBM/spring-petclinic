//=======================================================================
// ARCHIVO AntecedentesBean.java
// FECHA CREACI�N: 
// AUTOR: jariano, nliz
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chantecegene;
import org.profamilia.hc.model.dto.Chfragesperma;
import org.profamilia.hc.model.dto.Chmedicament;
import org.profamilia.hc.model.dto.ChmedicamentId;
import org.profamilia.hc.model.dto.Chtipoantece;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================
//=======================================================================
//  CLASE AntecedentesBean
//=======================================================================
public class TestFragmentacionEspermaBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------


    /** Almacena el tipo de historia*/
    private Integer tipoHistoria;


    private String sexo;

    private String navigationRule;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    /**  */
    private String menuBean;

    private String nextAction;

    private Long numeroConsulta;

    private boolean renderReacciones;

    private Integer consecutivo;

    private Chfragesperma chfragespe;

    Cpprofesio prot = new Cpprofesio();

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public TestFragmentacionEspermaBean() {
    }

    public void init() {
        nextAction = "";
        chfragespe=new Chfragesperma();
        inicializarFragmentacion();

    }

    public void inicializarFragmentacion() {
       chfragespe = new Chfragesperma();

        consecutivo = 1;
        try {
            if (numeroConsulta != null) {
                chfragespe = this.serviceLocator.getClinicoService().getFragmentEsperma(numeroConsulta);
                if(chfragespe==null){
                    chfragespe=new Chfragesperma();
                }
            }

            prot = this.getServiceLocator().getClinicoService().getProfesionalPorCodigo(this.getUsuarioSystem().getCurnprofes(), this.getUsuarioSystem().getCurnclinic());

        } catch (ModelException e) {
            e.printStackTrace();
        }
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
     * @return
     */
    public boolean esValido() {

        boolean esValido = false;
        Chfragesperma chfragespex= new Chfragesperma();
        try {
            if (numeroConsulta != null) {
               chfragespex = 
                        this.serviceLocator.getClinicoService().getFragmentEsperma(numeroConsulta);
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (chfragespex != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }


    public String aceptar() throws ModelException {
        Chfragesperma esp = new Chfragesperma();
        prot=new Cpprofesio();

        navigationRule = "";
            try {

                esp = this.serviceLocator.getClinicoService().getFragmentEsperma(numeroConsulta);
                prot = this.getServiceLocator().getClinicoService().getProfesionalPorCodigo(this.getUsuarioSystem().getCurnprofes(), this.getUsuarioSystem().getCurnclinic());
                if (esp == null) {
                    chfragespe.setCfelconsulta(numeroConsulta);
                }
                if(prot != null){
                    chfragespe.setCfecusuaprofes(prot.getCpfncodigo().toString());
                }
                chfragespe.setCfelnumepaci(usuario.getHuslnumero());
                chfragespe.setCfecusuaregi(userName());
                chfragespe.setCfetfechregi(new Date());
               
                this.getServiceLocator().getClinicoService().saveFragmentacionEspermatica(chfragespe);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                //navigationRule = nextAction;
                FacesUtils.resetManagedBean(menuBean);
             

            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                navigationRule = "";
                  FacesUtils.addErrorMessage("No se logro guardar el test de fragmentacion espermatica");
              }
  
           
        

        return navigationRule;

    }


    public boolean validar() {

        if (chfragespe != null) {

        }
        return renderReacciones = true;

    }


    public boolean isRenderReacciones() {
        return renderReacciones;
    }


    public void setChfragespe(Chfragesperma fragEsperma) {
        this.chfragespe = fragEsperma;
    }

    public Chfragesperma getChfragespe() {
        return chfragespe;
    }


    public void setProt(Cpprofesio prot) {
        this.prot = prot;
    }

    public Cpprofesio getProt() {
        return prot;
    }
}
