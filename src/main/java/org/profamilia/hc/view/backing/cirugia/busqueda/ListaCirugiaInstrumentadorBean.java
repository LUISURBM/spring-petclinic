package org.profamilia.hc.view.backing.cirugia.busqueda;

import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.comun.EncabezadoCirugiaProgramadaBean;
import org.profamilia.hc.view.backing.cirugia.instrumental.RegistrarInstrumentalBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioCirugiaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class ListaCirugiaInstrumentadorBean extends BaseBean {


    private List<Chcirugprogr> lstCirugiasIngresadas;

    private HtmlDataTable dtCirugia;

    private Chusuario usuario;

    public ListaCirugiaInstrumentadorBean() {

    }

    public void init() {
        usuario = new Chusuario();
        cargarCirugias();
    }

    public String cargarCirugias() {
        try {
        
             lstCirugiasIngresadas = 
                        this.serviceLocator.getCirugiaService().getCirugiasProgramadasInstrumentador(getClinica().getCclncodigo());    
                   
            
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
    


    public String seleccionarInstrumental() {
        Chcirugprogr cirugia = null;
        Chcirugprogr cirugiaSelect = null; 
        cirugiaSelect = (Chcirugprogr)dtCirugia.getRowData();
        cirugia = cirugiaSelect;
        RegistrarInstrumentalBean instrumentadorBean = null;
        DatosBasicosUsuarioCirugiaBean datosUsuariosBean = 
            (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
        EncabezadoCirugiaProgramadaBean encabezado = 
            (EncabezadoCirugiaProgramadaBean)FacesUtils.getManagedBean("encabezadoCirugiaProgramadaBean");

            
        FacesUtils.resetManagedBean("registrarInstrumentalBean");

        if (datosUsuariosBean != null && cirugiaSelect != null && encabezado != null &&
            cirugiaSelect.getHcplusuario() != null) {
            datosUsuariosBean.setUsuario(cirugiaSelect.getHcplusuario());
            encabezado.setCirugia(cirugia);
            encabezado.inicializarCirugiasProgramadas();
        }

        instrumentadorBean = 
                (RegistrarInstrumentalBean)FacesUtils.getManagedBean("registrarInstrumentalBean");
        if (instrumentadorBean != null && cirugiaSelect != null && 
            cirugiaSelect.getHcplusuario() != null) {
            instrumentadorBean.setUsuario(cirugiaSelect.getHcplusuario());
            instrumentadorBean.setNumeroCirugia(cirugiaSelect.getHcplnumero());
            instrumentadorBean.init();
        }
        return BeanNavegacion.RUTA_REGISTRAR_DETALLE_INSTRUMENTADOR;
    }
}
