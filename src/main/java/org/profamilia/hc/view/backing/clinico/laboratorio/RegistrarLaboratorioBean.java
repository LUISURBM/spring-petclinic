package org.profamilia.hc.view.backing.clinico.laboratorio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;

public class RegistrarLaboratorioBean  extends BaseBean {

    private Cnconsclin consulta; 
    
    private List<Cnconsclin> lstLaboratorios; 
    
    private boolean existeConsulta; 
    
    private String msg_sin_registros = "";
    
    private List<SelectItem> lstOpciones; 

    public RegistrarLaboratorioBean() {
    }
    
    
    public void init (){
        existeConsulta = false; 
        msg_sin_registros = IConstantes.MSG_SIN_CONSULTAR;
        try {
            if(consulta != null && consulta.getCcontipdoc() != null && consulta.getCcontipdoc().getCtdnnumero()!= null && consulta.getCconnumdoc()!= null )
            lstLaboratorios = serviceLocator.getClinicoService().getConsultasLaboratorioXFactura(consulta.getCcontipdoc().getCtdnnumero(), consulta.getCconnumdoc());
            if(lstLaboratorios != null && !lstLaboratorios.isEmpty()){
                existeConsulta = true; 
            }
            
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }


    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    public Cnconsclin getConsulta() {
        return consulta;
    }

    public void setLstLaboratorios(List<Cnconsclin> lstLaboratorios) {
        this.lstLaboratorios = lstLaboratorios;
    }

    public List<Cnconsclin> getLstLaboratorios() {
        return lstLaboratorios;
    }

    public void setExisteConsulta(boolean existeConsulta) {
        this.existeConsulta = existeConsulta;
    }

    public boolean isExisteConsulta() {
        return existeConsulta;
    }

    public void setMsg_sin_registros(String msg_sin_registros) {
        this.msg_sin_registros = msg_sin_registros;
    }

    public String getMsg_sin_registros() {
        return msg_sin_registros;
    }


    public void setLstOpciones(List<SelectItem> lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    public List<SelectItem> getLstOpciones() {
    if(lstOpciones == null || lstOpciones.isEmpty()){
        lstOpciones = new ArrayList<SelectItem>();
        lstOpciones.add(new SelectItem("S","Si"));
        lstOpciones.add(new SelectItem("N","No"));
        
    }
        
        return lstOpciones;
    }

    public String aceptar() {
    String navegacionRule = "";
    
    if(lstLaboratorios != null && !lstLaboratorios.isEmpty()){
            try {
                serviceLocator.getClinicoService().closeLaboratorio(lstLaboratorios,userName());
                navegacionRule = BeanNavegacion.RUTA_LISTA_TODOS_LOS_LABORATORIO;
            } catch (ModelException e) {
                navegacionRule = "";
                e.printStackTrace();
            }
        }
    
    
    
        FacesUtils.resetManagedBean("listaUsuariosLaboratorioBean");
        FacesUtils.resetManagedBean("registrarLaboratorioBean");
        return navegacionRule;
    
    }
}
