package org.profamilia.hc.view.backing.comun.buscador;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Crcup;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;


public class BuscadorCupsBean extends BaseBean {

    private Crcup crcups;

    private List<Crcup> lstCrcups;

    private HtmlDataTable dtCups;

    private List<Crcup> lstCrcupsSelec;

    private HtmlDataTable dtCupsSelec;
    
    private Crcup crcupsBusqueda;
    
    private String capituloSeleccionado;
    
    private List<SelectItem>lstCapitulos;
    

    public BuscadorCupsBean() {
    }

    public void init() {
    
        crcups = new Crcup();
        lstCrcups = new ArrayList();
        lstCrcupsSelec = new ArrayList<Crcup>();
        crcupsBusqueda = new Crcup();
    
    }


    public void consultarCups() {
        try {
            lstCrcups = 
                    this.serviceLocator.getHistoriaService().getCupsXCriterios(crcupsBusqueda,capituloSeleccionado);
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }
    

    public void agregarCups() {
        Crcup aux = null;
        aux = (Crcup)this.dtCups.getRowData();
        
        if (aux != null) {
            if(aux.isServicioSeleccionado()){
                lstCrcupsSelec.add(aux);
            }
            else{
                lstCrcupsSelec.remove(aux);
            }          
        }

    }


    public void eliminarCups() {
        Crcup aux = null;
        aux = (Crcup)dtCupsSelec.getRowData();
        lstCrcupsSelec.remove(aux);
    }


    public void setCrcups(Crcup crcups) {
        this.crcups = crcups;
    }

    public Crcup getCrcups() {
        return crcups;
    }

   
    public void setDtCups(HtmlDataTable dtCups) {
        this.dtCups = dtCups;
    }

    public HtmlDataTable getDtCups() {
        return dtCups;
    }

    public void setLstCrcupsSelec(List<Crcup> lstCrcupsSelec) {
        this.lstCrcupsSelec = lstCrcupsSelec;
    }

    public List<Crcup> getLstCrcupsSelec() {
        return lstCrcupsSelec;
    }

    public void setDtCupsSelec(HtmlDataTable dtCupsSelec) {
        this.dtCupsSelec = dtCupsSelec;
    }

    public HtmlDataTable getDtCupsSelec() {
        return dtCupsSelec;
    }

    public void setCrcupsBusqueda(Crcup crcupsBusqueda) {
        this.crcupsBusqueda = crcupsBusqueda;
    }

    public Crcup getCrcupsBusqueda() {
        return crcupsBusqueda;
    }

    public void setCapituloSeleccionado(String capituloSeleccionado) {
        this.capituloSeleccionado = capituloSeleccionado;
    }

    public String getCapituloSeleccionado() {
        return capituloSeleccionado;
    }

    public void setLstCapitulos(List<SelectItem> lstCapitulos) {
        this.lstCapitulos = lstCapitulos;
    }

    public List<SelectItem> getLstCapitulos() {
    if(lstCapitulos == null || lstCapitulos.isEmpty()){
        lstCapitulos = new ArrayList<SelectItem>();
        List<String>aux;
            try {
                aux = this.serviceLocator.getHistoriaService().getCapitulosCups();
                if(aux!=null){
                    for(int i = 0;i<aux.size();i++){
                        lstCapitulos.add(new SelectItem(aux.get(i),aux.get(i)));
                    }
                }
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        return lstCapitulos;
    }

    public void setLstCrcups(List<Crcup> lstCrcups) {
        this.lstCrcups = lstCrcups;
    }

    public List<Crcup> getLstCrcups() {
        return lstCrcups;
    }
}
