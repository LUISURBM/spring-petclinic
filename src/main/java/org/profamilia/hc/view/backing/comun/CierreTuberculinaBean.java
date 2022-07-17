//=======================================================================
// ARCHIVO AntecedentesGeneralesUsuarioBean.java
// FECHA CREACI�N: 
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos Antecedentes del paciente
//=======================================================================

package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import org.apache.myfaces.component.html.ext.HtmlDataTable;

import org.profamilia.hc.model.dto.Chantecespec;
import org.profamilia.hc.model.dto.Chantecfarma;
import org.profamilia.hc.model.dto.Chantecfarma;
import org.profamilia.hc.model.dto.ChantecfarmaPK;
import org.profamilia.hc.model.dto.Chantecfarma;
import org.profamilia.hc.model.dto.ChantecfarmaPK;
import org.profamilia.hc.model.dto.Chantecpatol;
import org.profamilia.hc.model.dto.Chtipoantece;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.clinico.consultorio.ListaTuberculinaBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================

//=======================================================================
//  CLASE AntecedentesGeneralesBean
//=======================================================================
public class CierreTuberculinaBean extends BaseBean {


    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    /**Almacena los tipos de antecedentes  */
    private Chantecfarma antecedfarmacologicos;

    /**Almacena los tipos de antecedentes  */
    private Chantecespec antecedespec;

    /**Almacena los tipos de antecedentes  */
    private Chantecpatol antecedpatol;

    /**Almacena consulta */
    private Cnconsclin consclin;

    /** Almacena el tipo de historia*/
    private Integer tipoHistoria;

    private String navigationRule;

    private String tipoServicio;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    /**  */
    private String menuBean;

    private String nextAction;

    private Long numeroConsulta;


    public CierreTuberculinaBean() {

    }


    public void init() {
        inicializarAntecedentes();
        nextAction = "";

    }

    public void inicializarAntecedentes() {
        try {
        
             if (numeroConsulta != null) {
                consclin=  this.serviceLocator.getClinicoService().getConsinfacByNumero(numeroConsulta);
                antecedfarmacologicos = 
                        this.serviceLocator.getClinicoService().getAntecedentesFarmacologicosTuberculina(numeroConsulta);
                antecedespec = 
                        this.serviceLocator.getClinicoService().getAntecedentesTuberculina(numeroConsulta);
                antecedpatol = 
                        this.serviceLocator.getClinicoService().getAntecedentesPatologicosTuberculina(numeroConsulta);
              
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }
        
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


    public String aceptar() {
        navigationRule = "";

        try {

           consclin.setCcocetapa("AT");
           this.getServiceLocator().getClinicoService().saveChconsulta(consclin,"VG",this.getUsuarioSystem().getCurcusuari());

            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            FacesUtils.resetManagedBean("listaTuberculinaBean");
            navigationRule = nextAction;

        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + " : " + 
                                       e.getMessage());
            navigationRule = "";
            e.printStackTrace();
        }
        return navigationRule;

    }


    public void setAntecedfarmacologicos(Chantecfarma antecedfarmacologicos) {
        this.antecedfarmacologicos = antecedfarmacologicos;
    }

    public Chantecfarma getAntecedfarmacologicos() {
        return antecedfarmacologicos;
    }

    public void setAntecedespec(Chantecespec antecedespec) {
        this.antecedespec = antecedespec;
    }

    public Chantecespec getAntecedespec() {
        return antecedespec;
    }

    public void setAntecedpatol(Chantecpatol antecedpatol) {
        this.antecedpatol = antecedpatol;
    }

    public Chantecpatol getAntecedpatol() {
        return antecedpatol;
    }

    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    public Integer getTipoHistoria() {
        return tipoHistoria;
    }

    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public String getNavigationRule() {
        return navigationRule;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setConsclin(Cnconsclin consclin) {
        this.consclin = consclin;
    }

    public Cnconsclin getConsclin() {
        return consclin;
    }
    
   
}

