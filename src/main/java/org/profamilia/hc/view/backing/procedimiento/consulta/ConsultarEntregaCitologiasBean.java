package org.profamilia.hc.view.backing.procedimiento.consulta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosCitologiaBean;
import org.profamilia.hc.view.backing.procedimiento.EntregaCitologiaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class ConsultarEntregaCitologiasBean extends BaseBean {


    private HtmlDataTable dtConsultaCitologia;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    private boolean existenCriterios;

    ConsultarFoliosCitologiaBean consultaCitologia;

    private List<Cncitologi> lstCitologia;

    private Cncitologi citologia;

    EntregaCitologiaBean entrega;


    public ConsultarEntregaCitologiasBean() {
    }

    public void init() {

        listTipoIdentificacion = new ArrayList<SelectItem>();
        lstCitologia = new ArrayList<Cncitologi>();
        citologia = new Cncitologi();

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

    public void setDtConsultaCitologia(HtmlDataTable dtConsultaCitologia) {
        this.dtConsultaCitologia = dtConsultaCitologia;
    }

    public HtmlDataTable getDtConsultaCitologia() {
        return dtConsultaCitologia;
    }

    public void setExistenCriterios(boolean existenCriterios) {
        this.existenCriterios = existenCriterios;
    }

    public boolean isExistenCriterios() {
        return existenCriterios;
    }


    public void setLstCitologia(List<Cncitologi> lstCitologia) {
        this.lstCitologia = lstCitologia;
    }

    public List<Cncitologi> getLstCitologia() {
        return lstCitologia;
    }

    public void setCitologia(Cncitologi citologia) {
        this.citologia = citologia;
    }

    public Cncitologi getCitologia() {
        return citologia;
    }


    /**
     * @return
     */
    public void consultarCitologia() {
        existenCriterios = true;
        dtConsultaCitologia.setFirst(0);
        if (citologia == null) {
            existenCriterios = false;
        } else {
            if (citologia.getCcianumide() == null && 
                citologia.getCcinconsec() == null) {
                existenCriterios = false;
            }
        }

        if (existenCriterios) {
            try {
                lstCitologia = 
                        serviceLocator.getClinicoService().getCitologiasParaEntregar(citologia);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        } else {
            lstCitologia = new ArrayList<Cncitologi>();
            FacesUtils.addErrorMessage(IConstantes.MSG_CONSULTA_POR_FILTROS);
        }


    }

    /**
     * @return
     */
    public String consultar() {
        Cncitologi citologiaAux;
        citologiaAux = null;
        citologiaAux = (Cncitologi)dtConsultaCitologia.getRowData();
        entrega = 
                (EntregaCitologiaBean)FacesUtils.getManagedBean("entregaCitologiaBean");
        if (entrega != null && citologiaAux != null) {
            entrega.setCitologia(citologiaAux);
            return BeanNavegacion.RUTA_IR_REGISTRAR_ENTREGA_CITOLOGIA;
        } else {
            return BeanNavegacion.RUTA_ACTUAL;
        }

    }

}
