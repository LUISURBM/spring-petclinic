package org.profamilia.hc.view.backing.procedimiento.consulta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chdatosvph;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosCitologiaBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosVphBean;
import org.profamilia.hc.view.backing.procedimiento.EntregaCitologiaBean;
import org.profamilia.hc.view.backing.procedimiento.EntregaVphBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class ConsultarEntregaVphsBean extends BaseBean {


    private HtmlDataTable dtConsultaVph;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    private boolean existenCriterios;

    ConsultarFoliosVphBean consultaVph;

    private List<Chdatosvph> lstVph;

    private Chdatosvph vph;

    EntregaVphBean entrega;


    public ConsultarEntregaVphsBean() {
    }

    public void init() {

        listTipoIdentificacion = new ArrayList<SelectItem>();
        lstVph = new ArrayList<Chdatosvph>();
        vph = new Chdatosvph();

    }

    /**
     * @param param
     */
    public void setListTipoIdentificacion(List<SelectItem> param) {
        this.listTipoIdentificacion = param;
    }

    /**
     * @return
     */
    public List<SelectItem> getListTipoIdentificacion() {
        if (listTipoIdentificacion.size() == 0) {
            ArrayList<Cptipoiden> listTipoIdentificacionAux = null;
            try {
                listTipoIdentificacionAux = 
                        (ArrayList<Cptipoiden>)this.serviceLocator.getClinicoService().getTipoIdentificacion();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listTipoIdentificacionAux.isEmpty()) {

                Iterator it = listTipoIdentificacionAux.iterator();
                int i = 0;
                listTipoIdentificacion.add(new SelectItem("", 
                                                          "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listTipoIdentificacion.add(new SelectItem(listTipoIdentificacionAux.get(i).getCticcodigo(), 
                                                              listTipoIdentificacionAux.get(i).getCticdescri()));
                    i++;
                }
            }
        }

        return listTipoIdentificacion;
    }

    public void setDtConsultaVph(HtmlDataTable dtConsultaVph) {
        this.dtConsultaVph = dtConsultaVph;
    }

    public HtmlDataTable getDtConsultaVph() {
        return dtConsultaVph;
    }

    public void setExistenCriterios(boolean existenCriterios) {
        this.existenCriterios = existenCriterios;
    }

    public boolean isExistenCriterios() {
        return existenCriterios;
    }


    public void setLstVph(List<Chdatosvph> lstVph) {
        this.lstVph = lstVph;
    }

    public List<Chdatosvph> getLstVph() {
        return lstVph;
    }

    public void setVph(Chdatosvph vph) {
        this.vph = vph;
    }

    public Chdatosvph getVph() {
        return vph;
    }


    /**
     * @return
     */
    public void consultarVph() {
        existenCriterios = true;
        dtConsultaVph.setFirst(0);
        if (vph == null) {
            existenCriterios = false;
        } else {
            if (vph.getHdvanumide() == null && 
                vph.getHdvnconsec() == null) {
                existenCriterios = false;
            }
        }

        if (existenCriterios) {
            try {
                lstVph = 
                        serviceLocator.getClinicoService().getVphsParaEntregar(vph);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        } else {
            lstVph = new ArrayList<Chdatosvph>();
            FacesUtils.addErrorMessage(IConstantes.MSG_CONSULTA_POR_FILTROS);
        }


    }

    /**
     * @return
     */
    public String consultar() {
        Chdatosvph vphAux;
        vphAux = null;
        vphAux = (Chdatosvph)dtConsultaVph.getRowData();
        entrega = 
                (EntregaVphBean)FacesUtils.getManagedBean("entregaVphBean");
        if (entrega != null && vphAux != null) {
            entrega.setVph(vphAux);
            return BeanNavegacion.RUTA_IR_REGISTRAR_ENTREGA_VPH;
        } else {
            return BeanNavegacion.RUTA_ACTUAL;
        }

    }

}
