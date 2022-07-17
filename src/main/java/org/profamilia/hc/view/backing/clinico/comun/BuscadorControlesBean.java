package org.profamilia.hc.view.backing.clinico.comun;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.comun.conducta.ControlSinCostoUsuarioBean;
import org.profamilia.hc.view.util.FacesUtils;


public class BuscadorControlesBean extends BaseBean {

    private Cpservicio servicio;

    private List<Cpservicio> lstControles;

    private HtmlDataTable dtServicios;

    private List<Cpservicio> lstControlSelec;

    private HtmlDataTable dtControlesSelec;

    public BuscadorControlesBean() {
    }

    public void init() {
        servicio = new Cpservicio();
        lstControles = new ArrayList<Cpservicio>();
        //lstControlSelec = new ArrayList<Cpservicio>();
        ControlSinCostoUsuarioBean controlSinCostoUsuarioBean = 
                 (ControlSinCostoUsuarioBean)FacesUtils.getManagedBean("controlSinCostoUsuarioBean");
        lstControlSelec = controlSinCostoUsuarioBean.getLstControles();
    }


    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }

    public void setLstControles(List<Cpservicio> lstControles) {
        this.lstControles = lstControles;
    }

    public List<Cpservicio> getLstControles() {
        return lstControles;
    }

    public void setDtServicios(HtmlDataTable dtServicios) {
        this.dtServicios = dtServicios;
    }

    public HtmlDataTable getDtServicios() {
        return dtServicios;
    }

    public void setDtControlesSelec(HtmlDataTable dtControlesSelec) {
        this.dtControlesSelec = dtControlesSelec;
    }

    public HtmlDataTable getDtControlesSelec() {
        return dtControlesSelec;
    }

    public void consultarControles() {
        dtServicios.setFirst(0);
        try {
            lstControles = 
                    this.serviceLocator.getClinicoService().getControlesPorCriterios(servicio);
            if (lstControles != null && !lstControles.isEmpty()) {
                for (Cpservicio servicio: lstControles) {
                    servicio.setAgregado(false);
                }
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

    public void consultarServiciosTipoConsulta99() {
        //99 -> ValoracionesYControles
        dtServicios.setFirst(0);
        try {
            lstControles = 
                    this.serviceLocator.getClinicoService().getServiciosPorTipoConsulta(99L);
            if (lstControles != null && !lstControles.isEmpty()) {
                for (Cpservicio servicio: lstControles) {
                    servicio.setAgregado(false);
                }
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

    public void agregarServicio() {
        Cpservicio servicioSelect = null;
        servicioSelect = (Cpservicio)this.dtServicios.getRowData();
        boolean controlYaGenerado = false;
        for(Cpservicio servicio : lstControlSelec) {
            if(servicio.getCsvccodigo().equals(servicioSelect.getCsvccodigo())) {
                controlYaGenerado = true;
                break;
            }
        }
        if (servicioSelect != null && ! controlYaGenerado) {
            lstControlSelec.add(servicioSelect);
        }
    }

    public void eliminarServicio() {
        Cpservicio servicioDelete = null;
        servicioDelete = (Cpservicio)dtControlesSelec.getRowData();
        if (!servicioDelete.isAgregado()) {
            //Solo se pueden quitar servicios NO almacenados
            lstControlSelec.remove(servicioDelete);
        }
        
    }


    public void setLstControlSelec(List<Cpservicio> lstControlSelec) {
        this.lstControlSelec = lstControlSelec;
    }

    public List<Cpservicio> getLstControlSelec() {
        return lstControlSelec;
    }
    
}