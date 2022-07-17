package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chexamediagn;
import org.profamilia.hc.model.dto.ChexamediagnPK;
import org.profamilia.hc.model.dto.Chmetodoplan;
import org.profamilia.hc.model.dto.Chremisilve;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class MetodosAnticoncepcionBean extends BaseBean {

    /** Variable que almacena el examen de apoyo diagnostico*/
    private Chexamediagn diagnostico;

    /** Almacena la lista de los metodos  de planificacion  */
    private List lstMetodo;

    /** Almacenla la lista de opciones 'SI' o 'NO' si requiere examen de apoyo diagnostico */
    private List lstOpciones;

    private Integer tipoHistoria;

    private String menuBean;

    private String navigationRule;

    private String tipoServicio;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private String nextAction;

    private Long numeroConsulta;
    
    private String sexo; 
    
    private List<Cnconsclin> servicioMetodoPaqList;
    
    private boolean renderMetodoPaq;
    
    
    private List lstMetodoPaq;


    public MetodosAnticoncepcionBean() {
    }

    public void init() {
        nextAction = "";
        inicializarMetodo();
    }

    public void inicializarMetodo() {
        renderMetodoPaq = false;
        try {
            if (numeroConsulta != null) {
                diagnostico = 
                        this.getServiceLocator().getClinicoService().getExamenApoyoDiagnostico(numeroConsulta);  
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }
        
        if (diagnostico == null) {
            diagnostico = new Chexamediagn();
           
        }
        
        if(servicioMetodoPaqList  != null && !servicioMetodoPaqList.isEmpty()){
                //diagnostico.setHednmetodopaq(servicioMetodoPaq.getCconnumero().longValue());
                //nombreMetodoPaq = servicioMetodoPaq.getCcocservic().getCsvccodigo()+"-"+servicioMetodoPaq.getCcocservic().getCsvcnombre();
                renderMetodoPaq = true;
        }
    }

    /**
     * @param diagnostico
     */
    public void setDiagnostico(Chexamediagn diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * @return
     */
    public Chexamediagn getDiagnostico() {
        return diagnostico;
    }


    /**
     * @param lstMetodo
     */
    public void setLstMetodo(List lstMetodo) {
        this.lstMetodo = lstMetodo;
    }

    /**
     * @return
     */
    public List getLstMetodo() {
        if (lstMetodo == null || lstMetodo.isEmpty()) {
            lstMetodo = new ArrayList();
            ArrayList<Chmetodoplan> lstMetodoAux = null;
            try {
                lstMetodoAux = 
                        (ArrayList<Chmetodoplan>)this.serviceLocator.getClinicoService().getMetodosPlanificacion(sexo);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstMetodoAux != null && !lstMetodoAux.isEmpty()) {

                Iterator it = lstMetodoAux.iterator();
                int i = 0;
                lstMetodo.add(new SelectItem("", "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstMetodo.add(new SelectItem(lstMetodoAux.get(i).getHmpccodigo(), 
                                                 lstMetodoAux.get(i).getHmpcdescripcio()));
                    i++;
                }
            }
        }

        return lstMetodo;
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
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        Chexamediagn diagnosticoAux = null;
        if (numeroConsulta != null) {
            try {
                diagnosticoAux = 
                        this.getServiceLocator().getClinicoService().getExamenApoyoDiagnostico(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (diagnosticoAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
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
     * @return
     */
    public String aceptar() {
        navigationRule = "";
        ChexamediagnPK id = new ChexamediagnPK();
        if (numeroConsulta != null && tipoServicio != null) {
            id.setHedlconsulta(numeroConsulta);
            id.setHedctiposervi(tipoServicio);
            diagnostico.setId(id);
        }
        if (diagnostico != null) {

            diagnostico.setHedcoperador(userName());

        }


        try {
            this.getServiceLocator().getClinicoService().saveExamenApoyoDiagnostico(diagnostico);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            FacesUtils.resetManagedBean(menuBean);
            navigationRule = nextAction;
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            navigationRule = null;
            e.printStackTrace();
        }

        return navigationRule;
    }


    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setRenderMetodoPaq(boolean renderMetodoPaq) {
        this.renderMetodoPaq = renderMetodoPaq;
    }

    public boolean isRenderMetodoPaq() {
        return renderMetodoPaq;
    }

    public void setServicioMetodoPaqList(List<Cnconsclin> servicioMetodoPaqList) {
        this.servicioMetodoPaqList = servicioMetodoPaqList;
    }

    public List<Cnconsclin> getServicioMetodoPaqList() {
        return servicioMetodoPaqList;
    }

    public void setLstMetodoPaq(List lstMetodoPaq) {
        this.lstMetodoPaq = lstMetodoPaq;
    }

    public List getLstMetodoPaq() {
    
        if (lstMetodoPaq == null || lstMetodoPaq.isEmpty()) {
            lstMetodoPaq = new ArrayList();

            if (servicioMetodoPaqList != null && !servicioMetodoPaqList.isEmpty()) {

                Iterator it = servicioMetodoPaqList.iterator();
                int i = 0;
                lstMetodoPaq.add(new SelectItem("", "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstMetodoPaq.add(new SelectItem(servicioMetodoPaqList.get(i).getCconnumero().longValue(), 
                                                 servicioMetodoPaqList.get(i).getCcocservic().getCsvccodigo()+"-"+servicioMetodoPaqList.get(i).getCcocservic().getCsvcnombre()));
                    i++;
                }
            }
        }
        return lstMetodoPaq;
    }
}
