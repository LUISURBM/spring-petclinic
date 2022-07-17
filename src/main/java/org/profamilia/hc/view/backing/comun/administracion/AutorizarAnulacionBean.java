//=======================================================================
// ARCHIVO AutorizarAnulacionBean.java
// FECHA CREACI�N: 26/05/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a la Autorizacion de Anulacion de una consulta.
//=======================================================================
package org.profamilia.hc.view.backing.comun.administracion;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chsolicanula;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  CLASE AutorizarAnulacionBean
//=======================================================================
public class AutorizarAnulacionBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private List<Chsolicanula> lstSolicitudes;

    private Chsolicanula solicitudSelect;

    private HtmlDataTable dtSolicitudAnulacion;

    private boolean renderAnulacion;
    
    private List lstOpciones; 

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public AutorizarAnulacionBean() {
    }


    public void init() {


        try {
            lstSolicitudes = 
                    this.serviceLocator.getClinicoService().getSolicitudesAnulacionClinica(this.getClinica().getCclncodigo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaci�n fue ingresada correctamente en la base de datos
    //------------------------------------------------------------------------------------------------


    //-----------------------------------------------------------------------
    //  Reporte Jasper
    //-----------------------------------------------------------------------


    //-----------------------------------------------------------------------
    //  Ajax
    //-----------------------------------------------------------------------


    //-----------------------------------------------------------------------
    //  Boton Principal
    //-----------------------------------------------------------------------

    public String actualizarSolicitud() {

        solicitudSelect.setHsacoperamodif(userName());
        solicitudSelect.setHsadfechamodif(new Date());
        solicitudSelect.setHsacetapa(ETAPA_ATENDIDO);

        try {
            this.serviceLocator.getClinicoService().updateSolicitudAnulacion(solicitudSelect);
            FacesUtils.addInfoMessage(MSG_ACTUALIZACION);
            return BeanNavegacion.RUTA_HOME;
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addInfoMessage(MSG_NO_ACTUALIZACION);
            return BeanNavegacion.RUTA_ACTUAL;
        }

    }


    //-----------------------------------------------------------------------
    //  Boton Secundarios
    //-----------------------------------------------------------------------


    public String volverConsulta() {
        return BeanNavegacion.RUTA_HOME;
    }

    public void seleccionarSolicitud() {
        solicitudSelect = (Chsolicanula)this.dtSolicitudAnulacion.getRowData();

    }

    //-----------------------------------------------------------------------
    //  ACCESORIOS
    //-----------------------------------------------------------------------

    /**
     * @param lstSolicitudes
     */
    public void setLstSolicitudes(List<Chsolicanula> lstSolicitudes) {
        this.lstSolicitudes = lstSolicitudes;
    }

    /**
     * @return
     */
    public List<Chsolicanula> getLstSolicitudes() {
        return lstSolicitudes;
    }


    /**
     * @param solicitudSelect
     */
    public void setSolicitudSelect(Chsolicanula solicitudSelect) {
        this.solicitudSelect = solicitudSelect;
    }

    /**
     * @return
     */
    public Chsolicanula getSolicitudSelect() {
        return solicitudSelect;
    }

    /**
     * @param dtSolicitudAnulacion
     */
    public void setDtSolicitudAnulacion(HtmlDataTable dtSolicitudAnulacion) {
        this.dtSolicitudAnulacion = dtSolicitudAnulacion;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtSolicitudAnulacion() {
        return dtSolicitudAnulacion;
    }

    /**
     * @param renderAnulacion
     */
    public void setRenderAnulacion(boolean renderAnulacion) {
        this.renderAnulacion = renderAnulacion;
    }

    /**
     * @return
     */
    public boolean isRenderAnulacion() {
        renderAnulacion = true;
        if (solicitudSelect == null) {
            renderAnulacion = false;
        }
        return renderAnulacion;
    }

    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    public List getLstOpciones() {
      if(lstOpciones== null || lstOpciones.isEmpty()){
          lstOpciones = new ArrayList(); 
          lstOpciones.add(new SelectItem("S","SI"));
          lstOpciones.add(new SelectItem("N","NO"));
      }
        return lstOpciones;
    }

 
}
