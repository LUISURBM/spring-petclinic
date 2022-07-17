//=======================================================================
// ARCHIVO ParaclinicosUsuarioBean.java
// FECHA CREACI�N: 
// AUTOR: CARLOS ANDRES VARGAS ROA
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
import org.profamilia.hc.model.dto.Chexamelabor;
import org.profamilia.hc.model.dto.Chparacgener;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class ParaclinicosUsuarioBean extends BaseBean {

    private List lstHistoricoParaclinico;
    private Chusuario usuario;
    private Long numeroConsulta;
    List<Chparacgener> lstParaclinicosConsulta;
    private boolean mostrarParaclinicos;
    private String nuevosParaclinicos;
    private Cpservicio servicio;
    private String paraclinico;
    private List lstOpciones;
    private String tipoServicio;
    private String tipoHistoria;
    private String nextAction;
    private String menuBean;
    private String codigoParaclinico;
    private HtmlDataTable dtParaclinico;
    private Chparacgener paraclinicoClone;
    private String navigationRule;
    



    public ParaclinicosUsuarioBean() {
    }
    
    public void init(){
        lstHistoricoParaclinico = new ArrayList();
        inicializarParaclinicos();
        servicio = new Cpservicio();
        nextAction = "";
        mostrarParaclinicos = false;
    }
    
    public void inicializarParaclinicos(){
        
        
        // Obtiene el tipo de historia del usuario
        try {
            if(usuario != null && usuario.getHuslnumero() != null )
            lstHistoricoParaclinico = 
                                 this.serviceLocator.getClinicoService().getParaclinicosUsuario(usuario.getHuslnumero());
          
            
        }catch(ModelException e){
            e.printStackTrace();
        }
        
        
        try{
            if(numeroConsulta != null)
            lstParaclinicosConsulta = 
                            this.serviceLocator.getClinicoService().getParaclinicosGeneral(numeroConsulta);
                            
                }catch(ModelException e){
                    e.printStackTrace();
                }
            if (lstParaclinicosConsulta == null || 
                lstParaclinicosConsulta.isEmpty()) {
                lstParaclinicosConsulta = new ArrayList<Chparacgener>();
            } else {
                Chparacgener paraclinicSelect;
                paraclinicSelect = lstParaclinicosConsulta.get(0);
                if (paraclinicSelect != null ) {
                  
                        mostrarParaclinicos = false;
                        nuevosParaclinicos = "N";
                       
                    } else {
                        lstHistoricoParaclinico = new ArrayList<Chparacgener>();
                        mostrarParaclinicos = true;
                        nuevosParaclinicos = "S";
                       
                    }
                }
            } 
           
        

    public void setMostrarParaclinicos(boolean mostrarParaclinicos) {
        this.mostrarParaclinicos = mostrarParaclinicos;
    }

    public boolean isMostrarParaclinicos() {
        return mostrarParaclinicos;
    }


    public void setNuevosParaclinicos(String nuevosParaclinicos) {
        this.nuevosParaclinicos = nuevosParaclinicos;
    }

    public String getNuevosParaclinicos() {
        return nuevosParaclinicos;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setNuevosParaclinicos(ValueChangeEvent valueChangeEvent) {
        setNuevosParaclinicos((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

 

 
    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }

      
    public void changeParaclinicos() {
        if (nuevosParaclinicos.equals("S")) {
            mostrarParaclinicos = true;
        } else {
            lstParaclinicosConsulta = new ArrayList<Chparacgener>();
            mostrarParaclinicos = false;
        }
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

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoHistoria(String tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    public String getTipoHistoria() {
        return tipoHistoria;
    }

    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    public String getNextAction() {
        return nextAction;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setMenuBean(String menuBean) {
        this.menuBean = menuBean;
    }

    public String getMenuBean() {
        return menuBean;
    }
    
    
    public boolean esValido() {
        boolean esValido = false;
        List<Chparacgener> lstParaclinicosConsulta = null;
        if (numeroConsulta != null) {

            try {
                lstParaclinicosConsulta = 
                        this.serviceLocator.getClinicoService().getParaclinicosGeneral(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (lstParaclinicosConsulta != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }


      
    /**
     * @return
     */
    public String agregarParaclinico() {

        Chparacgener paracli;
        paracli = new Chparacgener();
        


        if (codigoParaclinico != null && !codigoParaclinico.equals("") && 
            paraclinico != null && !paraclinico.equals("")) {
            paracli.setHpgcnombpara(codigoParaclinico);
            paracli.setHpgtdescripcio(paraclinico);
            paracli.setHpgcoperador(userName());
            paracli.setHpgdfecregistr(new Date());

            lstParaclinicosConsulta.add(paracli);
            codigoParaclinico = "";
            paraclinico = "";
        } else {
            FacesUtils.addErrorMessage("Debe Registrar el tipo de paraclinico y su descripcion(Resultado)");
        }


        return null;

    }

    public void setCodigoParaclinico(String codigoParaclinico) {
        this.codigoParaclinico = codigoParaclinico;
    }

    public String getCodigoParaclinico() {
        return codigoParaclinico;
    }

    public void setParaclinico(String paraclinico) {
        this.paraclinico = paraclinico;
    }

    public String getParaclinico() {
        return paraclinico;
    }

   
    
    /**
     * Backing bean action para eliminar una tarjeta.
     * 
     * @return the navigation result
     */
    public String eliminarParaclinico() {
        this.paraclinicoClone = (Chparacgener)this.dtParaclinico.getRowData();
        this.lstParaclinicosConsulta.remove(paraclinicoClone);
        FacesUtils.addInfoMessage("Se elimino correctamente ");
        return BeanNavegacion.SUCCESS;
    }

    public void setDtParaclinico(HtmlDataTable dtParaclinico) {
        this.dtParaclinico = dtParaclinico;
    }

    public HtmlDataTable getDtParaclinico() {
        return dtParaclinico;
    }


    public void setLstHistoricoParaclinico(List lstHistoricoParaclinico) {
        this.lstHistoricoParaclinico = lstHistoricoParaclinico;
    }

    public List getLstHistoricoParaclinico() {
        return lstHistoricoParaclinico;
    }

    public void setLstParaclinicosConsulta(List<Chparacgener> lstParaclinicosConsulta) {
        this.lstParaclinicosConsulta = lstParaclinicosConsulta;
    }

    public List<Chparacgener> getLstParaclinicosConsulta() {
        return lstParaclinicosConsulta;
    }

    public void setParaclinicoClone(Chparacgener paraclinicoClone) {
        this.paraclinicoClone = paraclinicoClone;
    }

    public Chparacgener getParaclinicoClone() {
        return paraclinicoClone;
    }
    
    
    public String aceptar(){
        navigationRule = "";
       
            
            if (!mostrarParaclinicos && lstParaclinicosConsulta.size() == 0) {
                     Chparacgener paraclinicAux = new Chparacgener();
                     paraclinicAux.setHpgcnombpara("NINGUNO");
                     paraclinicAux.setHpgtdescripcio("NINGUNO");
                     paraclinicAux.setHpgdfecregistr(new Date());
                     lstParaclinicosConsulta.add(paraclinicAux);
                 }

        if (lstParaclinicosConsulta != null && 
            !lstParaclinicosConsulta.isEmpty()) {
            try {
                this.getServiceLocator().getClinicoService().saveParaclinicosGeneral(lstParaclinicosConsulta, 
                                                                              numeroConsulta);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                FacesUtils.resetManagedBean(menuBean);
                navigationRule = nextAction;
            } catch (ModelException e) {
                navigationRule = "";
                return capturaError(e,IConstantes.ERROR_GUARDADO);
             
            }
        } else {
            FacesUtils.addErrorMessage(IMsg.MSG_VALIDACION_ANTECEDENTES);
        }

        return navigationRule;

        }
      
   
}

