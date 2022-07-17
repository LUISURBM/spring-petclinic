//=======================================================================
// ARCHIVO MedidadApoyoBean
// AUTOR: jariano, nlis
// Descripcion: Permite registrar los Datos de la Medida de Apoyo 
//=======================================================================

package org.profamilia.hc.view.backing.clinico.conducta;

import java.util.Date;

import org.profamilia.hc.model.dto.Chmedidapoyo;
import org.profamilia.hc.model.dto.ChmedidapoyoPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//====================================================================


//=================================================================
//  CLASE MedidadApoyoBean
//=======================================================================
public class MedidadApoyoBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chmedidapoyo medida;

    ChmedidapoyoPK id;


    private Long numeroUsuario;

    private Long numeroCirugia;

    private String tipoServicio;

    private Integer consecutivo;

    private Chusuario usuario;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public MedidadApoyoBean() {
    }

    public void init() {


        try {
            medida = 
                    serviceLocator.getClinicoService().getMedidasApoyo(numeroCirugia, 
                                                                       tipoServicio, 
                                                                       consecutivo);
        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (medida == null) {
            medida = new Chmedidapoyo();
        }
    }
    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------

    /**
     * @param medida
     */
    public void setMedida(Chmedidapoyo medida) {
        this.medida = medida;
    }

    /**
     * @return
     */
    public Chmedidapoyo getMedida() {
        return medida;
    }

    /**
     * @param id
     */
    public void setId(ChmedidapoyoPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChmedidapoyoPK getId() {
        return id;
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

    //-----------------------------------------------------------------------
    //  Boton Principal
    //-----------------------------------------------------------------------

    public void generarMedidaApoyo() {
        if (id == null) {
            id = new ChmedidapoyoPK();
        }

        if (numeroCirugia != null && tipoServicio != null && 
            consecutivo != null) {
            id.setHmactiposervi(tipoServicio);
            id.setHmalconsulta(numeroCirugia);
            id.setHmanconsecutiv(consecutivo);
        }
        medida.setId(id);
        medida.setHmacoperador(userName());
        medida.setHmadfecregistr(new Date());


        try {
            this.serviceLocator.getClinicoService().saveMedidaApoyo(medida);
            FacesUtils.addInfoMessage(MSG_ADICION);
        } catch (ModelException e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage(MSG_NO_ADICION);
        }
    }


}
