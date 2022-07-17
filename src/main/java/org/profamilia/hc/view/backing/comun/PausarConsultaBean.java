package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chcauspaus;
import org.profamilia.hc.model.dto.Chreginsumo;
import org.profamilia.hc.model.dto.ChreginsumoPK;
import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.confirmarInsumoDTO;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;

public class PausarConsultaBean extends BaseBean {

    private Long numeroConsulta;
    private List<Chcauspaus> chcauspausList;
    private Integer codigoCausaPausa;
    private Boolean renderMostrarLista;
    private Chtiempaten chtiempaten;

    /** Lista de Motivos */
    private List<SelectItem> listaCausasPausas;

    private List<SelectItem> listaPausar;

    private String pausarConsulta;

    public PausarConsultaBean() {
    }

    public void init() {

        chcauspausList = new ArrayList();
        listaCausasPausas = new ArrayList<SelectItem>();
        renderMostrarLista = false;
        pausarConsulta = "N";
        codigoCausaPausa = null;
        
        Chtiempaten chtiempaten = new Chtiempaten();
        
        if(numeroConsulta != null){
            try {

                chtiempaten = 
                        getServiceLocator().getClinicoService().consultarTiempoAtencionVigenteXconsulta(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (chtiempaten != null) {
                if ("PD".equals(chtiempaten.getCtacetapa())) {
                    pausarConsulta = "S";
                    renderMostrarLista = true;
                    codigoCausaPausa = chtiempaten.getCtancausa();
                }
            }
        }
    }

    public void getCausasPausarConsultas() {

        try {
            chcauspausList = 
                    getServiceLocator().getClinicoService().getListaCausasPausarConsulta();

            if (!chcauspausList.isEmpty()) {
                listaCausasPausas = new ArrayList<SelectItem>();
                listaCausasPausas.add(new SelectItem("","Seleccione una Opci�n"));
                for (Chcauspaus chcauspaus: chcauspausList) {
                    listaCausasPausas.add(new SelectItem(chcauspaus.getCcpnconsec(), 
                                                         chcauspaus.getCcpcdescrip()));
                }

            }

        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

    public void onChangeAutorizacion() {

        if (pausarConsulta.equals("S")) {
            renderMostrarLista = true;
        } else {
            renderMostrarLista = false;
        }

    }

    public void guardar() {
    
       Chtiempaten chtiempatenAnt = new Chtiempaten();
       chtiempaten = new Chtiempaten();
       
        try {
            chtiempatenAnt = getServiceLocator().getClinicoService().consultarTiempoAtencionAbiertaXConsulta(numeroConsulta);
            
            if(chtiempatenAnt != null){
                chtiempatenAnt.setCtacestado("XX");
                this.getServiceLocator().getClinicoService().saveRegistroTiempoAtencion(chtiempatenAnt);
                
                chtiempaten.setCtanconsulta(numeroConsulta);
                chtiempaten.setCtacetapa("PD");
                chtiempaten.setCtacestado("VG");
                chtiempaten.setCtadhora(new Date());
                chtiempaten.setCtadfechregi(new Date());
                if (pausarConsulta.equals("S")) {
                    chtiempaten.setCtancausa(codigoCausaPausa);
                } else {
                    chtiempaten.setCtancausa(0);
                }
                chtiempaten.setCtacusuareg(getUsuarioSystem().getCurcusuari());
                chtiempaten.setCtancodmed(Integer.parseInt(getUsuarioSystem().getCurnprofes().toString()));
                
                this.getServiceLocator().getClinicoService().saveRegistroTiempoAtencion(chtiempaten);
                FacesUtils.addInfoMessage("Se pauso correctamente la consulta");
            }
            
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

    public void cerrarPausa(Long numConsulta) {
        Chtiempaten chtiempaten = new Chtiempaten();
        try {
            chtiempaten = 
                    getServiceLocator().getClinicoService().consultarTiempoAtencionAbiertaXConsulta(numConsulta);

            if (chtiempaten != null) {
                chtiempaten.setCtacestado("CR");
                this.getServiceLocator().getClinicoService().saveRegistroTiempoAtencion(chtiempaten);
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

    public Long validarLong(Object valor) {
        return valor == null ? null : Long.parseLong(valor.toString());
    }

    public Double validarDouble(Object valor) {
        return valor == null ? null : Double.parseDouble(valor.toString());
    }

    public String validarString(Object valor) {
        return valor == null ? null : valor.toString();
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setChcauspausList(List<Chcauspaus> chcauspausList) {
        this.chcauspausList = chcauspausList;
    }

    public List<Chcauspaus> getChcauspausList() {
        return chcauspausList;
    }

    public void setCodigoCausaPausa(Integer codigoCausaPausa) {
        this.codigoCausaPausa = codigoCausaPausa;
    }

    public Integer getCodigoCausaPausa() {
        return codigoCausaPausa;
    }

    public void setListaCausasPausas(List<SelectItem> listaCausasPausas) {
        this.listaCausasPausas = listaCausasPausas;
    }

    public List<SelectItem> getListaCausasPausas() {
        return listaCausasPausas;
    }

    public void setRenderMostrarLista(Boolean renderMostrarLista) {
        this.renderMostrarLista = renderMostrarLista;
    }

    public Boolean getRenderMostrarLista() {
        return renderMostrarLista;
    }

    public void setListaPausar(List<SelectItem> listaPausar) {
        this.listaPausar = listaPausar;
    }

    public List<SelectItem> getListaPausar() {
        if (listaPausar == null || listaPausar.isEmpty()) {
            listaPausar = new ArrayList();
            listaPausar.add(new SelectItem("S", "SI"));
            listaPausar.add(new SelectItem("N", "NO"));
        }
        return listaPausar;
    }

    public void setPausarConsulta(String pausarConsulta) {
        this.pausarConsulta = pausarConsulta;
    }

    public void setPausarConsulta(ValueChangeEvent valueChangeEvent) {
        setPausarConsulta((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public String getPausarConsulta() {
        return pausarConsulta;
    }
}
