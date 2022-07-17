package org.profamilia.hc.view.backing.cirugia.consulta;

import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.busqueda.ListaCirugiasMedicoBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class CerrarCirugiaUsuarioBean extends BaseBean {


    private boolean generoResumen;

    private int index = -1;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private String menuBean;

    private String nextAction;

    private String navegacionRule;
    
    private Long numeroCirugia; 
    
    private Integer consecutivo; 

    public CerrarCirugiaUsuarioBean() {
    }

    public void init() {
        generoResumen = false;

    }


    public void inicalizarCerrarConsultaBean() {
        generoResumen = false;
        FacesUtils.resetManagedBean("consultarFoliosBean");

        /*   if (consul != null) {
            folio =
                    (ConsultarFoliosBean)FacesUtils.getManagedBean("consultarFoliosBean");

            if (folio != null && usuario != null && consul != null) {
                folio.setConsultaClone(consul);
                folio.setUsuario(usuario);
                folio.setNumeroConsulta(consul.getHcolnumero());
                folio.init();
                folio.visualizarConsulta();

            }
        }*/
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

    /**
     * @param numeroCirugia
     */
    public void setNumeroCirugia(Long numeroCirugia) {
        this.numeroCirugia = numeroCirugia;
    }

    /**
     * @return
     */
    public Long getNumeroCirugia() {
        return numeroCirugia;
    }

    /**
     * @param consecutivo
     */
    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    /**
     * @return
     */
    public Integer getConsecutivo() {
        return consecutivo;
    }


    /**
     * @return
     */
    public String cerrarCirugia() {

        String navegationRule = "";
        
        FacesUtils.resetManagedBean("listaCirugiasMedicoBean");
        ListaCirugiasMedicoBean listaMedico = 
            (ListaCirugiasMedicoBean)FacesUtils.getManagedBean("listaCirugiasMedicoBean");

        if (listaMedico != null) {
            listaMedico.setEsEvolucion(true);
            listaMedico.setEsIngresoMedico(false);
            listaMedico.setEsRegistroAnestesia(false);
         
        }
        


        try {
            this.serviceLocator.getClinicoService().closeEvolucionMedica(numeroCirugia, 
                                                                         consecutivo);
            navegationRule = BeanNavegacion.RUTA_IR_LISTA_CIRUGIAS_MEDICOS;

        } catch (ModelException e) {
            navegationRule = "";
            return capturaError(e,IConstantes.ERROR_CERRAR_CIRUGIA);
        } catch (Exception ex) {
            navegationRule = "";
            return capturaError(ex,IConstantes.ERROR_CERRAR_CIRUGIA);
        }
        FacesUtils.resetManagedBean("listaMisUsuariosBean");
        FacesUtils.resetManagedBean("listaUsuariosBean");
        FacesUtils.addInfoMessage(MSG_ADICION);
        return navegationRule;

    }


}
