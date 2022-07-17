
package org.profamilia.hc.view.backing.laboratorio;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Cfadmision;
import org.profamilia.hc.model.dto.Cfdetaadmision;
import org.profamilia.hc.model.dto.Cfnoveadmi;
import org.profamilia.hc.model.dto.Cfnovedeta;
import org.profamilia.hc.model.dto.Chconfiservi;
import org.profamilia.hc.model.dto.Chgeslabor;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================

//=================================================================
//  CLASE AplicacionVacunaCervixBean
//=======================================================================
public class GestionLaboratorioBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Cpprofesio profesional;
    private List<Cpprofesio> listaProfesionales;
    private List<SelectItem> listaItemsProfesionales;
    private BigDecimal codigoLaboratorio;
    private Cpclinica cpclinica;
    private String nombreClinica;
    private Chgeslabor chgeslabor;
    private Chgeslabor chgeslaborAux;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public GestionLaboratorioBean() {
    }

    public void init() {
        inicilizarGestionLaboratorioBean();

    }
    //ACTIONS

    public void inicilizarGestionLaboratorioBean() {
        try {
            listaProfesionales = 
                    serviceLocator.getClinicoService().getProfesionalXClinica(getUsuarioSystem().getCurnclinic().longValue());

            listaItemsProfesionales = new ArrayList<SelectItem>();
            cpclinica = 
                    serviceLocator.getClinicoService().getClinica(getUsuarioSystem().getCurnclinic());

            if (cpclinica != null || cpclinica.getCclncodigo() != null) {
                nombreClinica = cpclinica.getCclcnombre();
            }
            chgeslaborAux = 
                    serviceLocator.getClinicoService().getLaboratorioXClinica(getUsuarioSystem().getCurnclinic().longValue());

            if (chgeslaborAux != null) {
                codigoLaboratorio = 
                        BigDecimal.valueOf(chgeslaborAux.getHglncodprof());
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }


    }

    public void guardar() throws ModelException {
        try {
            String inactivo = "XX";
            String vigente = "VG";
            if (chgeslaborAux != null) {
                if (chgeslaborAux.getHglncodprof() != 
                    codigoLaboratorio.longValue()) {
                    chgeslaborAux.setHglcestado(inactivo);
                    this.serviceLocator.getClinicoService().saveLaboratorio(chgeslaborAux);

                    chgeslabor = new Chgeslabor();
                    chgeslabor.setHglnclinica(getUsuarioSystem().getCurnclinic().longValue());
                    chgeslabor.setHglncodprof(codigoLaboratorio.longValue());
                    chgeslabor.setHgldfechreg(new Date());
                    chgeslabor.setHglcusuareg(getUsuarioSystem().getCurcusuari());
                    chgeslabor.setHglcestado(vigente);
                    this.serviceLocator.getClinicoService().saveLaboratorio(chgeslabor);
                    FacesUtils.addInfoMessage("Se guardo correctamente el laboratorio");
                    
                    chgeslaborAux = 
                            serviceLocator.getClinicoService().getLaboratorioXClinica(getUsuarioSystem().getCurnclinic().longValue());

                    if (chgeslaborAux != null) {
                        codigoLaboratorio = 
                                BigDecimal.valueOf(chgeslaborAux.getHglncodprof());
                    }
                }
            } else {
                chgeslabor = new Chgeslabor();
                chgeslabor.setHglnclinica(getUsuarioSystem().getCurnclinic().longValue());
                chgeslabor.setHglncodprof(codigoLaboratorio.longValue());
                chgeslabor.setHgldfechreg(new Date());
                chgeslabor.setHglcusuareg(getUsuarioSystem().getCurcusuari());
                chgeslabor.setHglcestado(vigente);
                this.serviceLocator.getClinicoService().saveLaboratorio(chgeslabor);
                FacesUtils.addInfoMessage("Se guardo correctamente el laboratorio");
                
                chgeslaborAux = 
                        serviceLocator.getClinicoService().getLaboratorioXClinica(getUsuarioSystem().getCurnclinic().longValue());

                if (chgeslaborAux != null) {
                    codigoLaboratorio = 
                            BigDecimal.valueOf(chgeslaborAux.getHglncodprof());
                }
            }
        } catch (ModelException e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No se logro guardar");
        }
    }

    public void guardarNuevoRegistro() {
        try {
            String vigente = "VG";
            this.serviceLocator.getClinicoService().saveLaboratorio(chgeslaborAux);
            chgeslabor = new Chgeslabor();
            chgeslabor.setHglnclinica(getUsuarioSystem().getCurnclinic().longValue());
            chgeslabor.setHglncodprof(codigoLaboratorio.longValue());
            chgeslabor.setHgldfechreg(new Date());
            chgeslabor.setHglcusuareg(getUsuarioSystem().getCurcusuari());
            chgeslabor.setHglcestado(vigente);
            this.serviceLocator.getClinicoService().saveLaboratorio(chgeslabor);
        } catch (ModelException e) {
            e.printStackTrace();
        }

    }

    public void inhabilitarRegistro() {
        try {
            String inactivo = "XX";
            chgeslaborAux.setHglcestado(inactivo);
            this.serviceLocator.getClinicoService().saveLaboratorio(chgeslaborAux);
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

    public void setProfesional(Cpprofesio profesional) {
        this.profesional = profesional;
    }

    public Cpprofesio getProfesional() {
        return profesional;
    }

    public void setListaProfesionales(List<Cpprofesio> listaProfesionales) {
        this.listaProfesionales = listaProfesionales;
    }

    public List<Cpprofesio> getListaProfesionales() {
        return listaProfesionales;
    }

    public void setListaItemsProfesionales(List<SelectItem> listaItemsProfesionales) {
        this.listaItemsProfesionales = listaItemsProfesionales;
    }

    public List<SelectItem> getListaItemsProfesionales() {
        if (listaProfesionales != null || !listaItemsProfesionales.isEmpty()) {
            listaItemsProfesionales = new ArrayList();
            for (Cpprofesio profesional: listaProfesionales) {
                listaItemsProfesionales.add(new SelectItem(profesional.getCpfncodigo(), 
                                                           profesional.getCpfcnombre()));
            }
        }
        return listaItemsProfesionales;
    }

    public void setCpclinica(Cpclinica cpclinica) {
        this.cpclinica = cpclinica;
    }

    public Cpclinica getCpclinica() {
        return cpclinica;
    }

    public void setNombreClinica(String nombreClinica) {
        this.nombreClinica = nombreClinica;
    }

    public String getNombreClinica() {
        return nombreClinica;
    }

    public void setChgeslabor(Chgeslabor chgeslabor) {
        this.chgeslabor = chgeslabor;
    }

    public Chgeslabor getChgeslabor() {
        return chgeslabor;
    }

    public void setChgeslaborAux(Chgeslabor chgeslaborAux) {
        this.chgeslaborAux = chgeslaborAux;
    }

    public Chgeslabor getChgeslaborAux() {
        return chgeslaborAux;
    }

    public void setCodigoLaboratorio(BigDecimal codigoLaboratorio) {
        this.codigoLaboratorio = codigoLaboratorio;
    }

    public BigDecimal getCodigoLaboratorio() {
        return codigoLaboratorio;
    }
}
