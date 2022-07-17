package org.profamilia.hc.view.backing.cirugia.comun;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IConstantes;

public class EncabezadoCirugiaProgramadaBean extends BaseBean {


    private List<Chcirugprogr> lstCirugias;

    private Chcirugprogr cirugia;

    private String nombreServicios;

    private Long numeroCirugia;

    private List<Chdetacirpro> detaciru;

    private Cpservicio servicio;

    public EncabezadoCirugiaProgramadaBean() {
        lstCirugias = new ArrayList<Chcirugprogr>();
    }

    public void init() {

    }

    public String inicializarCirugiasProgramadas() {
        lstCirugias = new ArrayList<Chcirugprogr>();
		if (cirugia != null && !cirugia.getChdetacirpros().isEmpty()) {
		    numeroCirugia = cirugia.getHcplnumero();
		    try {
		        detaciru = 
		                this.getServiceLocator().getCirugiaService().getServicioDetalleLista(numeroCirugia);
		    } catch (ModelException e) {
		        return capturaError(e,IConstantes.ERROR_COSNULTA);
		    }

		    if (detaciru != null) {
		        String nombreServicio1 = "";
		        for (Chdetacirpro detalle: detaciru) {
		            try {
		                servicio = 
		                        this.getServiceLocator().getClinicoService().getServicioPorId(detalle.getId().getHdccservicio());
		            } catch (ModelException e) {
		                return capturaError(e,IConstantes.ERROR_COSNULTA);
		            }
		            if (servicio != null && !servicio.equals("")) {
		                nombreServicio1 = 
		                        nombreServicio1 + " - " + servicio.getCsvcnombre();

		            }
		            cirugia.setNombreServicio(nombreServicio1);

		            
		        }


		    }
		        lstCirugias.add(cirugia);

		}
        return null;
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

    public void setNombreServicios(String nombreServicios) {
        this.nombreServicios = nombreServicios;
    }

    public String getNombreServicios() {
        return nombreServicios;
    }


    public void setNumeroCirugia(Long numeroCirugia) {
        this.numeroCirugia = numeroCirugia;
    }

    public Long getNumeroCirugia() {
        return numeroCirugia;
    }

    public void setDetaciru(List<Chdetacirpro> detaciru) {
        this.detaciru = detaciru;
    }

    public List<Chdetacirpro> getDetaciru() {
        return detaciru;
    }

    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }

    public void setLstCirugias(List<Chcirugprogr> lstCirugias) {
        this.lstCirugias = lstCirugias;
    }

    public List<Chcirugprogr> getLstCirugias() {
        return lstCirugias;
    }
}
