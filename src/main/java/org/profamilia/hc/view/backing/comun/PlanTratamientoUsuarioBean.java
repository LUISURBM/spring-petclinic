package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chpladetrat;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class PlanTratamientoUsuarioBean extends BaseBean{

    private String tipoServicio; 
    
    private String navigationRule; 
    
    private Long numeroConsulta; 
    
    private Integer tipoHistoria; 
    
    private Chusuario usuario; 
    
    private String nextAction; 
    
    private String menuBean; 
    
    private Chpladetrat plan; 
    
    private List lstTipoIntervencion; 
    
    private List<String> lstIntervencionSelect; 

    public PlanTratamientoUsuarioBean() {
    }
    
    
    public void init(){
        lstIntervencionSelect = new ArrayList<String>();
    }
    
    public void inicializarPlanTratamiento(){
        if (numeroConsulta != null) {

            try {
                plan = 
                        this.getServiceLocator().getClinicoService().getPlanTratamiento(numeroConsulta, 
                                                                                          TIPO_CONSULTA);

            } catch (ModelException e) {
                e.printStackTrace();
            }

        }

        if (plan == null) {
            plan = new Chpladetrat(); 
        }else{
            if (plan.getHptctipointer() != null && 
                !plan.getHptctipointer().equals("")) {
                StringTokenizer stk = 
                    new StringTokenizer(plan.getHptctipointer(), ",");
                String tipoInterAux = null;

                while (stk.hasMoreTokens()) {
                    tipoInterAux = "";
                    tipoInterAux = stk.nextToken();
                    if (tipoInterAux != null) {
                        lstIntervencionSelect.add(tipoInterAux);
                    }
                }

            }
        }
    }
    


    public String guardarPlanTratamiento() {
        navigationRule = "";
        String tipoIntervencion; 
        tipoIntervencion = ""; 
        
        
            if (lstIntervencionSelect != null && 
                !lstIntervencionSelect.isEmpty()) {
                for (String interven: lstIntervencionSelect) {
                    tipoIntervencion = tipoIntervencion + interven + ",";
                }
                if (tipoIntervencion != null && tipoIntervencion.length() > 2) {
                    tipoIntervencion = 
                            tipoIntervencion.substring(0, tipoIntervencion.length() - 1);
                    plan.setHptctipointer(tipoIntervencion);
                }
            }
            
      

        if (numeroConsulta != null) {
            plan.getId().setHptctiposervi(tipoServicio);
            plan.getId().setHptlconsulta(numeroConsulta);
            plan.setHptcoperador(userName());
            plan.setHptdfecregistr(new Date());
        }

        try {

            this.serviceLocator.getClinicoService().savePlanTratamiento(plan);
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

    /**
     * @return
     */
    public boolean esValido() {

        Chpladetrat planAux = null;

        if (numeroConsulta != null) {
            try {
                planAux = 
                        this.getServiceLocator().getClinicoService().getPlanTratamiento(numeroConsulta, 
                                                                                          TIPO_CONSULTA);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (planAux != null) {
            return true;
        }

        return false;
    }

    //-----------------------------------------------------------------------------------------------
    //  Jasper
    //------------------------------------------------------------------------------------------------


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
     * @param plan
     */
    public void setPlan(Chpladetrat plan) {
        this.plan = plan;
    }

    /**
     * @return
     */
    public Chpladetrat getPlan() {
        return plan;
    }

    /**
     * @param lstTipoIntervencion
     */
    public void setLstTipoIntervencion(List lstTipoIntervencion) {
        this.lstTipoIntervencion = lstTipoIntervencion;
    }

    /**
     * @return
     */
    public List getLstTipoIntervencion() {
    if(lstTipoIntervencion== null || lstTipoIntervencion.isEmpty()){
        lstTipoIntervencion = new ArrayList();
        lstTipoIntervencion.add(new SelectItem("CI","Consulta Individual"));
        lstTipoIntervencion.add(new SelectItem("CP","Consulta Pareja "));
        lstTipoIntervencion.add(new SelectItem("CF","Consulta de Familia "));
        lstTipoIntervencion.add(new SelectItem("CG","Consulta de Grupal "));
    }
        return lstTipoIntervencion;
    }

    /**
     * @param lstIntervencionSelect
     */
    public void setLstIntervencionSelect(List<String> lstIntervencionSelect) {
        this.lstIntervencionSelect = lstIntervencionSelect;
    }

    /**
     * @return
     */
    public List<String>  getLstIntervencionSelect() {
        return lstIntervencionSelect;
    }
}
