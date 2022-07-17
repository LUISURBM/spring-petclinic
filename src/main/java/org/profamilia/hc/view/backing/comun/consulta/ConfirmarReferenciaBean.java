//=======================================================================
// ARCHIVO ConfirmarReferenciaBean.java
// FECHA CREACI�N: 25/05/2015
// AUTOR: Norbey Lis Salda�a
// Descripci�n: Confirma la referencia.
//=======================================================================

package org.profamilia.hc.view.backing.comun.consulta;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chreferencia;
import org.profamilia.hc.model.dto.ChreferenciaPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//==============================================================================
//  CLASE ConfirmarReferenciaBean
//==============================================================================

public class ConfirmarReferenciaBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    /** Almacena los tipos de servicios que existen  */
    private List lstTiposServicios;

    /** Almacena los tipos de servicios seleccionados en la consulta*/
    private List lstServiciosSelect;

    /** Almacena el objeto a perisistir*/
    private Chreferencia referencia;

    private boolean esCirugia;

    private Long numeroUsuario;

    private String tipoServicio;

    private Integer consecutivo;

    /** Almacena el consulta */
    private Long numeroConsulta;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private String menuBean;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ConfirmarReferenciaBean() {

    }

    //ACTIONS  

    public void init() {

        lstServiciosSelect = new ArrayList();
        inicializarReferencia();
    }

    public void inicializarReferencia() {
        try {

            referencia = 
                    this.getServiceLocator().getClinicoService().getReferencia(numeroConsulta);

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (referencia != null) {
            lstServiciosSelect = new ArrayList();
            if (referencia.getHrectiporefere() != null) {
                StringTokenizer st = 
                    new StringTokenizer(referencia.getHrectiporefere(), ",");
                while (st.hasMoreTokens()) {
                    String tipo = st.nextToken();
                    lstServiciosSelect.add(tipo);
                }
            }

        }
    }


    //--------------------------------------------------------------------------
    //  Bot�n principal
    //--------------------------------------------------------------------------    

    public String confirmarReferencia() {
        ChreferenciaPK id = new ChreferenciaPK();

        String serviciosSelect = "";

        if (lstServiciosSelect != null && !lstServiciosSelect.isEmpty()) {
            Iterator it = lstServiciosSelect.iterator();
            int i = 0;
            while (it.hasNext()) {
                it.next();
                serviciosSelect = 
                        serviciosSelect + lstServiciosSelect.get(i) + ",";
                i++;
            }

            serviciosSelect = 
                    serviciosSelect.substring(0, serviciosSelect.length() - 1);
        }

        referencia.setHrecoperconf(userName());
        referencia.setHredfecconf(new Date());
        referencia.setHrecetapa(ETAPA_CONFIRMADA);

        if (numeroConsulta != null && tipoServicio != null && 
            consecutivo != null) {
            id.setHrelconsulta(numeroConsulta);
            id.setHrectiposervi(tipoServicio);
            id.setHrenconsecutiv(consecutivo);
            referencia.setId(id);
        }


        try {
            this.getServiceLocator().getClinicoService().saveReferencia(referencia);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            FacesUtils.resetManagedBean("confirmarReferenciaBean");
            FacesUtils.resetManagedBean("listaReferenciaPorConfirmarBean");
            return BeanNavegacion.RUTA_IR_LISTA_CONFIRMAR_REFERENCIA;

        } catch (ModelException e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
        }
        return BeanNavegacion.RUTA_ACTUAL;

    }


    // ACCESSORS


    /**
     * @param lstTiposServicios
     */
    public void setLstTiposServicios(List lstTiposServicios) {
        this.lstTiposServicios = lstTiposServicios;
    }

    /**
     * @return
     */
    public List getLstTiposServicios() {
        if (lstTiposServicios == null || lstTiposServicios.isEmpty()) {
            lstTiposServicios = new ArrayList();
            lstTiposServicios.add(new SelectItem("IC", "Interconsulta"));
            lstTiposServicios.add(new SelectItem("AT", "Apoyo Tecnologico"));
            lstTiposServicios.add(new SelectItem("RE", "Remisi�n"));
            lstTiposServicios.add(new SelectItem("OS", "Orden de Servicio"));
            lstTiposServicios.add(new SelectItem("OR", "Ordinario"));
            lstTiposServicios.add(new SelectItem("PR", "Prioritario"));
            lstTiposServicios.add(new SelectItem("UR", "Urgencia"));
        }
        return lstTiposServicios;
    }

    /**
     * @param lstServiciosSelect
     */
    public void setLstServiciosSelect(List lstServiciosSelect) {
        this.lstServiciosSelect = lstServiciosSelect;
    }

    /**
     * @return
     */
    public List getLstServiciosSelect() {
        return lstServiciosSelect;
    }


    /**
     * @param numeroUsuario
     */
    public void setNumeroUsuario(Long numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    /**
     * @return
     */
    public Long getNumeroUsuario() {
        return numeroUsuario;
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
     * @param referencia
     */
    public void setReferencia(Chreferencia referencia) {
        this.referencia = referencia;
    }

    /**
     * @return
     */
    public Chreferencia getReferencia() {
        return referencia;
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

}

