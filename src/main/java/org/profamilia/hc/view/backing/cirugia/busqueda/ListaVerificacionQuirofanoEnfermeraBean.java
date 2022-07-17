package org.profamilia.hc.view.backing.cirugia.busqueda;

import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.comun.EncabezadoCirugiaProgramadaBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarEpicrisisBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarVerificacionQuirofanoEnfermeraBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioCirugiaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class ListaVerificacionQuirofanoEnfermeraBean extends BaseBean {

    private List<Chcirugprogr> lstCirugiasIngresadas;

    private HtmlDataTable dtCirugia;

    private Chusuario usuario;


    public ListaVerificacionQuirofanoEnfermeraBean() {

    }

    public void init() {
        usuario = new Chusuario();
        cargarCirugias();
    }

    public String cargarCirugias() {
        try {
        
             lstCirugiasIngresadas = 
                        this.serviceLocator.getClinicoService().getCirugiasProgramadasActivas(getClinica().getCclncodigo(), null, null,null,getUsuarioSystem().getCurnprofes());    
                   
            
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }
        return null;
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
     * @param lstCirugiasIngresadas
     */
    public void setLstCirugiasIngresadas(List<Chcirugprogr> lstCirugiasIngresadas) {
        this.lstCirugiasIngresadas = lstCirugiasIngresadas;
    }

    /**
     * @return
     */
    public List<Chcirugprogr> getLstCirugiasIngresadas() {
        return lstCirugiasIngresadas;
    }

    /**
     * @param dtCirugia
     */
    public void setDtCirugia(HtmlDataTable dtCirugia) {
        this.dtCirugia = dtCirugia;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCirugia() {
        return dtCirugia;
    }


    public String registrarVerificacionQuirofano() {
        Chcirugprogr cirugiaSelect = null; 
        Chcirugprogr cirugia = null;
      
        DatosBasicosUsuarioCirugiaBean datosBasicosAux = 
            (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
        EncabezadoCirugiaProgramadaBean encabezado = 
            (EncabezadoCirugiaProgramadaBean)FacesUtils.getManagedBean("encabezadoCirugiaProgramadaBean");
        FacesUtils.resetManagedBean("registrarVerificacionQuirofanoEnfermeraBean");
        cirugiaSelect = (Chcirugprogr)dtCirugia.getRowData();
        cirugia = cirugiaSelect;
        Long numerocirugia = null;

        if (cirugiaSelect != null) {
            numerocirugia = cirugiaSelect.getHcplnumero();
        }

        RegistrarVerificacionQuirofanoEnfermeraBean verificacionQuirofanoBean = null;
        verificacionQuirofanoBean = 
                (RegistrarVerificacionQuirofanoEnfermeraBean)FacesUtils.getManagedBean("registrarVerificacionQuirofanoEnfermeraBean");

        if (verificacionQuirofanoBean != null && cirugiaSelect != null) {
            verificacionQuirofanoBean.setCirugiaSelect(cirugiaSelect);
            verificacionQuirofanoBean.setNumerocirugia(numerocirugia);
            verificacionQuirofanoBean.setUsuarioRegistra("E"); /* Registra Enfermera */
            verificacionQuirofanoBean.cargarDatos();
        }


        if (datosBasicosAux != null && cirugiaSelect != null && encabezado != null) {
            datosBasicosAux.setUsuario(cirugiaSelect.getHcplusuario());
            encabezado.setCirugia(cirugia);
            encabezado.inicializarCirugiasProgramadas();
        }

        return BeanNavegacion.RUTA_IR_REGISTRAR_VERIFICACION_QUIROFANO_ENFERMERA;
    }
}
