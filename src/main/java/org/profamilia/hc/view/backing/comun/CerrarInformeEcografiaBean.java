package org.profamilia.hc.view.backing.comun;

import org.profamilia.hc.model.dto.Chinfomamogr;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarInformeEcografiasBean;
import org.profamilia.hc.view.util.FacesUtils;




public class CerrarInformeEcografiaBean extends BaseBean {

    ConsultarInformeEcografiasBean folio;

    private boolean generoResumen;

    private int index = -1;

    /** Almacena el consulta */
    private Cnconsclin consulta;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private String menuBean;

    private boolean esVacunacion;

    private String nextAction;

    private String navegacionRule;
    
    private Chinfomamogr informe;

    public CerrarInformeEcografiaBean() {
    }

    public void init() {
        generoResumen = false;
        esVacunacion = false;
    }


    public void inicalizarCerrarConsultaBean() {
        generoResumen = false;
        FacesUtils.resetManagedBean("consultarInformeEcografiasBean");

        if (informe != null) {
            folio = 
                    (ConsultarInformeEcografiasBean)FacesUtils.getManagedBean("consultarInformeEcografiasBean");

            if (folio != null && usuario != null && informe != null && informe.getId()!= null) {
                folio.setInforme(informe);
                folio.setUsuario(usuario);
                folio.setConsulta(consulta);
                folio.setNumeroConsulta(informe.getId().getHimlconsulta());
                folio.init();
                folio.visualizarConsulta();

            }
        }
    }


    /**
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return
     */
    public int getIndex() {
        return index;
    }

   

    public String cerrarInforme() {

        if (consulta != null) {
            try {
                this.serviceLocator.getClinicoService().closeProcedimiento(consulta, 
                                                                           userName());

            } catch (ModelException e) {
                e.printStackTrace();
                return null;
            }
            FacesUtils.resetManagedBean("listaUsuariosBean");
            return BeanNavegacion.RUTA_LISTA;
        }

        return BeanNavegacion.RUTA_ACTUAL;


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
     * @param generoResumen
     */
    public void setGeneroResumen(boolean generoResumen) {
        this.generoResumen = generoResumen;
    }

    /**
     * @return
     */
    public boolean isGeneroResumen() {
        return generoResumen;
    }

    /**
     * @param esVacunacion
     */
    public void setEsVacunacion(boolean esVacunacion) {
        this.esVacunacion = esVacunacion;
    }

    /**
     * @return
     */
    public boolean isEsVacunacion() {
        return esVacunacion;
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
     * @param navegacionRule
     */
    public void setNavegacionRule(String navegacionRule) {
        this.navegacionRule = navegacionRule;
    }

    /**
     * @return
     */
    public String getNavegacionRule() {
        return navegacionRule;
    }

    public void setInforme(Chinfomamogr informe) {
        this.informe = informe;
    }

    public Chinfomamogr getInforme() {
        return informe;
    }
}
