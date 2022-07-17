package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.component.UIInput;
import javax.faces.model.SelectItem;
import org.profamilia.hc.model.dto.Chasesoriaive;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;


public class AsesoriaIveBean extends BaseBean {

    private Chasesoriaive asesoria;
    private String tipoServicio;
    private Long numeroConsulta;
    private Integer tipoHistoria;
    private Chusuario usuario;
    private String nextAction;
    private String menuBean;
    private String navigationRule;
    private List lstOpciones;
    private UIInput itDescripcion;

    public AsesoriaIveBean() {

    }

    public void init() {
        asesoria = new Chasesoriaive();
        inicializarasesoria();
    }

    public void inicializarasesoria(){
        if (numeroConsulta != null){
            try {
                asesoria = 
                        getServiceLocator().getClinicoService().getAsesoriaIve(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        if (asesoria == null) {
            asesoria = new Chasesoriaive();
        }
        }
    }

    public String guardarAsesorialve() {
        navigationRule = "";
        boolean wexito = true;

            if (wexito){
                try {
                    asesoria.setHailconsulta(numeroConsulta);
                    asesoria.setHaidfecregistr(new Date());
                    asesoria.setHaicoperador(userName());
                    
                    serviceLocator.getClinicoService().saveAsesoriaIve(asesoria);
                    FacesUtils.addInfoMessage("Se ingreso la informaci�n satisfactoriamente.");
                    FacesUtils.resetManagedBean(menuBean);
                    navigationRule = nextAction;
                } catch (ModelException e) {
                    e.printStackTrace();
                    navigationRule = "";
                    FacesUtils.addErrorMessage("Adicion no realizada");
                }
            }
                
        

        return navigationRule;
    }

    /**
     * @return
     */
    public boolean esValido() {
        Chasesoriaive asesoriaAux = null;
        if (numeroConsulta != null)
            try {
                asesoriaAux = 
                        getServiceLocator().getClinicoService().getAsesoriaIve(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        return asesoriaAux != null;
    }


    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    public List getLstOpciones() {
    
        if (lstOpciones == null || lstOpciones.isEmpty()) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "Si"));
            lstOpciones.add(new SelectItem("N", "No"));
        }
        return lstOpciones;
    }

    public void setAsesoria(Chasesoriaive asesoria) {
        this.asesoria = asesoria;
    }

    public Chasesoriaive getAsesoria() {
        return asesoria;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    public Integer getTipoHistoria() {
        return tipoHistoria;
    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

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

    public void setItDescripcion(UIInput itDescripcion) {
        this.itDescripcion = itDescripcion;
    }

    public UIInput getItDescripcion() {
        return itDescripcion;
    }
    
    }
    
