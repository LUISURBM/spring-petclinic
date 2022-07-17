package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;


public class CirugiasProgramadasUsuarioBean extends BaseBean {

    private List lstCirugias;

    private Integer tipoDocumento;

    private Integer numeroDocumento;

    private List<Cnconsclin> lstConsclin;


    public CirugiasProgramadasUsuarioBean() {
    }


    public void init() {
        lstCirugias = new ArrayList();
        cargarDatos();
    }


    /**
     * @param lstCirugias
     */
    public void setLstCirugias(List lstCirugias) {
        this.lstCirugias = lstCirugias;
    }

    /**
     * @return
     */
    public List getLstCirugias() {
        return lstCirugias;
    }

    /**
     * @param tipoDocumento
     */
    public void setTipoDocumento(Integer tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return
     */
    public Integer getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param numeroDocumento
     */
    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * @return
     */
    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void cargarDatos() {
        lstCirugias = new ArrayList();
        if (tipoDocumento != null && numeroDocumento != null) {
            try {
                lstConsclin = 
                        this.serviceLocator.getCirugiaService().getCirugiasPorFactura(numeroDocumento, 
                                                                                      tipoDocumento);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            // Cargamos las cirugias programadas
            if (lstConsclin != null && !lstConsclin.isEmpty()) {
                Iterator it = lstConsclin.iterator();
                Cnconsclin conclin;

                while (it.hasNext()) {
                    conclin = (Cnconsclin)it.next();
                    lstCirugias.add(conclin.getCcocservic());
                }
            }
        }
    }


}
