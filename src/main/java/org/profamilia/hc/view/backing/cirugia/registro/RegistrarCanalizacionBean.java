package org.profamilia.hc.view.backing.cirugia.registro;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chcanalivena;
import org.profamilia.hc.model.dto.ChcanalivenaPK;
import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class RegistrarCanalizacionBean extends BaseBean {

    private List lstOpciones;

    private Chcanalivena canalizacion;

    private List lstMiembroSuperior;

    private List lstLocalizacion;

    private List lstTipoCateter;

    private boolean mostrarCanalizacion;

    private boolean mostrarCalibre;

    private Chcirugprogr cirugia;

    private boolean esIngreso;

    private List lstCirugias;

    private HtmlDataTable dtCirugias;

    private List<Cnconsclin> lstConsclin;
    
    private String tipoServicio;
    
    private boolean notaEnfeProce;
    
    private String legendServicio;


    public RegistrarCanalizacionBean() {
    }

    public void init() {
        lstOpciones = new ArrayList();
        lstMiembroSuperior = new ArrayList();
        lstLocalizacion = new ArrayList();
        lstTipoCateter = new ArrayList();
        lstCirugias = new ArrayList();
        dtCirugias = new HtmlDataTable();


        lstCirugias = new ArrayList();
        dtCirugias = new HtmlDataTable();
        legendServicio="Cirugia(s) Programada(s)";

        if (cirugia != null) {
            if(notaEnfeProce){
                legendServicio="Procedimiento(s)";
                try {
                    lstConsclin = 
                            this.serviceLocator.getClinicoService().getConsultaClinica(cirugia.getHcplnumero().longValue());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                // Cargamos los procedimientos
                if (lstConsclin != null && !lstConsclin.isEmpty()) {
                    Iterator it = lstConsclin.iterator();
                    Cnconsclin conclin;

                    while (it.hasNext()) {
                        conclin = (Cnconsclin)it.next();
                        lstCirugias.add(conclin.getCcocservic());
                    }
                }
            }
        
        
            try {
                lstConsclin = 
                        this.serviceLocator.getCirugiaService().getCirugiasPorFactura(cirugia);
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

        /*  if(cirugia!= null && esIngreso){
        try {

            canalizacion = this.serviceLocator.getClinicoService().getIngresoCanalizacion(cirugia.getHcplnumero());
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }*/
        if (canalizacion == null) {
            canalizacion = new Chcanalivena();
        } else {
            if (canalizacion.getHcvecanalizaci() != null && 
                canalizacion.getHcvecanalizaci().equals("S")) {
                mostrarCanalizacion = true;
            } else {
                mostrarCanalizacion = false;
            }

            if (canalizacion.getHcvctipocatete() != null && 
                canalizacion.getHcvctipocatete().equals("C")) {
                mostrarCalibre = true;
            } else {
                mostrarCalibre = false;
            }
        }

    }

    /**
     * @param lstOpciones
     */
    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    /**
     * @return
     */
    public List getLstOpciones() {
        if (lstOpciones.size() == 0) {
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
    }

    /**
     * @param canalizacion
     */
    public void setCanalizacion(Chcanalivena canalizacion) {
        this.canalizacion = canalizacion;
    }

    /**
     * @return
     */
    public Chcanalivena getCanalizacion() {
        return canalizacion;
    }

    public void changeCanalizacion() {
        if (canalizacion != null && canalizacion.getHcvecanalizaci() != null && 
            canalizacion.getHcvecanalizaci().equals("S")) {
            mostrarCanalizacion = true;
        } else {
            mostrarCanalizacion = false;
        }

    }

    /**
     * @param valueChangeEvent
     */
    public void setCanaliza(ValueChangeEvent valueChangeEvent) {
        canalizacion.setHcvecanalizaci((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHcveasepsia(ValueChangeEvent valueChangeEvent) {
        canalizacion.setHcveasepsia((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void changeCateter() {
        if (canalizacion != null && canalizacion.getHcvctipocatete() != null && 
            canalizacion.getHcvctipocatete().equals("C")) {
            mostrarCalibre = true;
        } else {
            mostrarCalibre = false;
        }

    }


    public void changeAsepsia() {

    }

    /**
     * @param lstMiembroSuperior
     */
    public void setLstMiembroSuperior(List lstMiembroSuperior) {
        this.lstMiembroSuperior = lstMiembroSuperior;
    }

    /**
     * @return
     */
    public List getLstMiembroSuperior() {
        if (lstMiembroSuperior.size() == 0) {
            lstMiembroSuperior.add(new SelectItem("B", "Brazo"));
            lstMiembroSuperior.add(new SelectItem("A", "Antebrazo"));
            lstMiembroSuperior.add(new SelectItem("M", "Mano"));

        }
        return lstMiembroSuperior;
    }

    /**
     * @param lstLocalizacion
     */
    public void setLstLocalizacion(List lstLocalizacion) {
        this.lstLocalizacion = lstLocalizacion;
    }

    /**
     * @return
     */
    public List getLstLocalizacion() {
        if (lstLocalizacion.size() == 0) {
            lstLocalizacion.add(new SelectItem("D", "Derecho"));
            lstLocalizacion.add(new SelectItem("I", "Izquierdo"));
        }
        return lstLocalizacion;
    }

    /**
     * @param lstTipoCateter
     */
    public void setLstTipoCateter(List lstTipoCateter) {
        this.lstTipoCateter = lstTipoCateter;
    }

    /**
     * @return
     */
    public List getLstTipoCateter() {
        if (lstTipoCateter.size() == 0) {
            lstTipoCateter.add(new SelectItem("P", "Pericraneal"));
            lstTipoCateter.add(new SelectItem("C", 
                                              "Cat�ter por fuera de aguja"));
        }
        return lstTipoCateter;
    }


    /**
     * @param mostrarCanalizacion
     */
    public void setMostrarCanalizacion(boolean mostrarCanalizacion) {
        this.mostrarCanalizacion = mostrarCanalizacion;
    }

    /**
     * @return
     */
    public boolean isMostrarCanalizacion() {
        return mostrarCanalizacion;
    }

    /**
     * @param mostrarCalibre
     */
    public void setMostrarCalibre(boolean mostrarCalibre) {
        this.mostrarCalibre = mostrarCalibre;
    }

    /**
     * @return
     */
    public boolean isMostrarCalibre() {
        return mostrarCalibre;
    }

    /**
     * @param valueChangeEvent
     */
    public void setHcvctipocatete(ValueChangeEvent valueChangeEvent) {
        canalizacion.setHcvctipocatete((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param cirugia
     */
    public void setCirugia(Chcirugprogr cirugia) {
        this.cirugia = cirugia;
    }

    /**
     * @return
     */
    public Chcirugprogr getCirugia() {
        return cirugia;
    }

    /**
     * @param esIngreso
     */
    public void setEsIngreso(boolean esIngreso) {
        this.esIngreso = esIngreso;
    }

    /**
     * @return
     */
    public boolean isEsIngreso() {
        return esIngreso;
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
     * @param dtCirugias
     */
    public void setDtCirugias(HtmlDataTable dtCirugias) {
        this.dtCirugias = dtCirugias;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCirugias() {
        return dtCirugias;
    }

    /**
     * @return
     */
    public String registrarCanalizacion() {
        ChcanalivenaPK id;
        id = new ChcanalivenaPK();
        Integer consecutivo;
        consecutivo = null;
        try {
            consecutivo = 
                    this.serviceLocator.getClinicoService().getConsecutivoCanalizacion(cirugia.getHcplnumero());
        } catch (ModelException e) {
            e.printStackTrace();
        }
        canalizacion.setHcvcestado(ESTADO_VIGENTE);
        canalizacion.setHcvcoperador(userName());
        canalizacion.setHcvdfecregistr(new Date());
        canalizacion.setHcvnclinica(this.getClinica().getCclncodigo());
        id.setHcvlconsecutiv(consecutivo);
        id.setHcvlnumero(cirugia.getHcplnumero());
        id.setHcvctiposervi(TIPO_HOSPITALIZACION);
        canalizacion.setId(id);
        try {
            if (tipoServicio != null) {
                canalizacion.getId().setHcvctiposervi(tipoServicio);
            }
            this.serviceLocator.getClinicoService().saveCanalizacion(canalizacion);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
        } catch (ModelException e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
        }

        if (esIngreso) {
            return BeanNavegacion.RUTA_ACTUAL;
        } else {
            return BeanNavegacion.RUTA_IR_LISTA_NOTAS_ENFERMERIA;
        }

    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setLstConsclin(List<Cnconsclin> lstConsclin) {
        this.lstConsclin = lstConsclin;
    }

    public List<Cnconsclin> getLstConsclin() {
        return lstConsclin;
    }

    public void setNotaEnfeProce(Boolean notaEnfeProce) {
        this.notaEnfeProce = notaEnfeProce;
    }

    public Boolean getNotaEnfeProce() {
        return notaEnfeProce;
    }

    public void setLegendServicio(String legendServicio) {
        this.legendServicio = legendServicio;
    }

    public String getLegendServicio() {
        return legendServicio;
    }
}
