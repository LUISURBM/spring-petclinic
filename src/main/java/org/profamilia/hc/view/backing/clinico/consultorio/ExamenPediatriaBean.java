package org.profamilia.hc.view.backing.clinico.consultorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chpediexamen;
import org.profamilia.hc.model.dto.ChpediexamenPK;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.util.FacesUtils;


public class ExamenPediatriaBean extends BaseBean {

    private Chpediexamen examen;

    /** Almacena el Bean de Datos de Usuario*/
    DatosBasicosUsuarioBean datosUsuario;

    private List<SelectItem> lstEstadoGeneral;

    private List<SelectItem> lstEstadoRespiratorio;

    private List<SelectItem> lstEstadoHidratacion;

    private List<SelectItem> lstEstadoConciencia;

    private Integer tipoHistoria;


    public ExamenPediatriaBean() {

    }

    public void init() {

        lstEstadoGeneral = new ArrayList<SelectItem>();
        lstEstadoRespiratorio = new ArrayList<SelectItem>();
        lstEstadoHidratacion = new ArrayList<SelectItem>();
        lstEstadoConciencia = new ArrayList<SelectItem>();

        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

        try {
            examen = 
                    serviceLocator.getClinicoService().getExamenPediatria(datosUsuario.getConsulta());
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (examen == null) {
            examen = new Chpediexamen();
        }
    }


    public void setExamen(Chpediexamen examen) {
        this.examen = examen;
    }

    public Chpediexamen getExamen() {
        return examen;
    }


    public void setLstEstadoGeneral(List<SelectItem> lstEstadoGeneral) {
        this.lstEstadoGeneral = lstEstadoGeneral;
    }

    public List<SelectItem> getLstEstadoGeneral() {
        if (lstEstadoGeneral.size() == 0) {
            lstEstadoGeneral.add(new SelectItem("B", "Bueno"));
            lstEstadoGeneral.add(new SelectItem("R", "Regular"));
            lstEstadoGeneral.add(new SelectItem("M", "Malo"));
        }
        return lstEstadoGeneral;
    }

    public void setLstEstadoRespiratorio(List<SelectItem> lstEstadoRespiratorio) {
        this.lstEstadoRespiratorio = lstEstadoRespiratorio;
    }

    public List<SelectItem> getLstEstadoRespiratorio() {
        if (lstEstadoRespiratorio.size() == 0) {
            lstEstadoRespiratorio.add(new SelectItem("S", "Si"));
            lstEstadoRespiratorio.add(new SelectItem("N", "No"));
        }
        return lstEstadoRespiratorio;
    }

    public void setLstEstadoHidratacion(List<SelectItem> lstEstadoHidratacion) {
        this.lstEstadoHidratacion = lstEstadoHidratacion;
    }

    public List<SelectItem> getLstEstadoHidratacion() {
        if (lstEstadoHidratacion.size() == 0) {
            lstEstadoHidratacion.add(new SelectItem("H", "Hidratado"));
            lstEstadoHidratacion.add(new SelectItem("D", "Deshidratado"));

        }
        return lstEstadoHidratacion;
    }

    public void setLstEstadoConciencia(List<SelectItem> lstEstadoConciencia) {
        this.lstEstadoConciencia = lstEstadoConciencia;
    }

    public List<SelectItem> getLstEstadoConciencia() {
        if (lstEstadoConciencia.size() == 0) {
            lstEstadoConciencia.add(new SelectItem("N", "Normal"));
            lstEstadoConciencia.add(new SelectItem("A", "Alterado"));
        }
        return lstEstadoConciencia;
    }

    public boolean esValido() {
        boolean esvalido = false;
        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

        try {
            examen = 
                    serviceLocator.getClinicoService().getExamenPediatria(datosUsuario.getConsulta());
        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (examen != null) {
            esvalido = true;
        }
        return esvalido;
    }

    public void guardarExamenPediatria() {
        ChpediexamenPK id = new ChpediexamenPK();
        if (datosUsuario != null && datosUsuario.getConsulta() != null && 
            datosUsuario.getConsulta().getCconnumero() != null) {
            id.setHpelconsulta(new Long(datosUsuario.getConsulta().getCconnumero()));
            id.setHpectiposervi(TIPO_CONSULTA);
            examen.setId(id);
        }

        examen.setHpecoperador(userName());
        examen.setHpedfecregistr(new Date());


        try {
            this.serviceLocator.getClinicoService().saveExamenPediatria(examen);
            FacesUtils.addInfoMessage(MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ADICION);
            e.printStackTrace();
        }
    }

    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    public Integer getTipoHistoria() {
        return tipoHistoria;
    }
}
