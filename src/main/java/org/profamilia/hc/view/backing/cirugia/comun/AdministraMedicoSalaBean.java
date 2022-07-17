package org.profamilia.hc.view.backing.cirugia.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chconsultori;
import org.profamilia.hc.model.dto.Chsalaxprofe;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;


public class AdministraMedicoSalaBean extends BaseBean {


    private Chsalaxprofe programacion;

    private List lstSalasCirugia;


    /** */
    private List<Chsalaxprofe> lstAnestesiologosSelect;




    private List lstAnestesiologos;


    private HtmlDataTable dtAnestesiologo;


    private String navegationRule;
    


    public AdministraMedicoSalaBean() {

    }

    public void init() {


        

        programacion = new Chsalaxprofe();
        String nombresala = null;


        try {
            lstAnestesiologosSelect = this.serviceLocator.getCirugiaService().getListaSalasXProfesional(getUsuarioSystem().getCurnprofes(), getClinica().getCclncodigo());
        } catch (ModelException e) {
            e.printStackTrace();
        }
        
        if(lstAnestesiologosSelect == null || lstAnestesiologosSelect.isEmpty()){
            lstAnestesiologosSelect = new ArrayList<Chsalaxprofe>();    
        }else{
            for(Chsalaxprofe salaprof: lstAnestesiologosSelect){
                try {
                    nombresala = serviceLocator.getCirugiaService().getNombreSalaXCodigo(salaprof.getId().getHspnclinica(),salaprof.getId().getHspnsala() );
                    salaprof.setHspcdescsala(nombresala);
                    
                } catch (ModelException e) {
                   e.printStackTrace();
                }
            }
        }
        


    }


   


    public void setDtAnestesiologo(HtmlDataTable dtAnestesiologo) {
        this.dtAnestesiologo = dtAnestesiologo;
    }

    public HtmlDataTable getDtAnestesiologo() {
        return dtAnestesiologo;
    }

   

    /**
     * @param lstAnestesiologos
     */
    public void setLstAnestesiologos(List lstAnestesiologos) {
        this.lstAnestesiologos = lstAnestesiologos;
    }

    /**
     * @return
     */
    public List getLstAnestesiologos() {
        if (lstAnestesiologos == null || lstAnestesiologos.isEmpty()) {
            lstAnestesiologos = new ArrayList();
            ArrayList<Cpprofesio> listProfesionalesAux = null;
            try {
                listProfesionalesAux = 
                        (ArrayList<Cpprofesio>)this.serviceLocator.getClinicoService().getProfesionalXCodigoII(getUsuarioSystem().getCurnprofes().toString(),getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (listProfesionalesAux != null && 
                !listProfesionalesAux.isEmpty()) {

                Iterator it = listProfesionalesAux.iterator();
                int i = 0;
               
                while (it.hasNext()) {
                    it.next();
                    lstAnestesiologos.add(new SelectItem(listProfesionalesAux.get(i).getId().getCpfncodigo(), 
                                                         listProfesionalesAux.get(i).getCpfcnombre()));
                    i++;
                }
            }
        }

        return lstAnestesiologos;
    }


    /**
     * @param lstSalasCirugia
     */
    public void setLstSalasCirugia(List lstSalasCirugia) {
        this.lstSalasCirugia = lstSalasCirugia;
    }

    /**
     * @return
     */
    public List getLstSalasCirugia() {
        if (lstSalasCirugia == null) {
            lstSalasCirugia = new ArrayList();
            ArrayList<Chconsultori> lstSalasAux = null;
            Integer tipoSala = 2;
            try {
                lstSalasAux = 
                        (ArrayList<Chconsultori>)this.getServiceLocator().getCirugiaService().getConsultoriosXClinica(tipoSala, 
                                                                                                                      this.getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstSalasAux != null && !lstSalasAux.isEmpty()) {

                lstSalasCirugia.add(new SelectItem("", "Seleccione ...."));
                Iterator it = lstSalasAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstSalasCirugia.add(new SelectItem((lstSalasAux.get(i).getId().getHconnumero()), 
                                                       lstSalasAux.get(i).getHcocdescripcio()));
                    i++;
                }
            }
        }
        return lstSalasCirugia;
    }
    
    
    public void setProgramacion(Chsalaxprofe programacion) {
        this.programacion = programacion;
    }

    public Chsalaxprofe getProgramacion() {
        return programacion;
    }

    public void setLstAnestesiologosSelect(List<Chsalaxprofe> lstAnestesiologosSelect) {
        this.lstAnestesiologosSelect = lstAnestesiologosSelect;
    }

    public List<Chsalaxprofe> getLstAnestesiologosSelect() {
        return lstAnestesiologosSelect;
    }

    
    
    public void eliminarAnestesiologo() {
        Chsalaxprofe anestesiologoDelete = null;
        anestesiologoDelete = (Chsalaxprofe)dtAnestesiologo.getRowData();
        lstAnestesiologosSelect.remove(anestesiologoDelete);


        try {
            serviceLocator.getCirugiaService().deleteSalaXProfesional(anestesiologoDelete);
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

  
    
  
    public String aceptarMedico() {
        boolean wexito = true;
        navegationRule = "";
        Chsalaxprofe programacionAux = null;

        if (programacion == null ||  programacion.getId() == null || programacion.getId().getHspnsala() == null) {
            FacesUtils.addErrorMessage("body:formProgramarCirugia:panelTabProgramarCirugia:mnuSala", 
                                       MSG_CAMPO_OBLIGATORIO);
            wexito = false;
        }

        if (programacion == null ||  programacion.getId() == null || programacion.getId().getHspnnumero() == null) {
            FacesUtils.addErrorMessage("body:formAdministrarMedicos:panelTabAgregarCirugia:mnuAnestesiologos", 
                                       MSG_CAMPO_OBLIGATORIO);
            wexito = false;
        }
        
        
        if(wexito){


            try {
                programacionAux = this.serviceLocator.getCirugiaService().getSalaXProfesional(getUsuarioSystem().getCurnprofes(), getClinica().getCclncodigo(), programacion.getId().getHspnsala());
            } catch (ModelException e) {
            e.printStackTrace();
            }
            
            if(programacionAux != null && programacionAux.getId()!= null){
                wexito = false; 
                FacesUtils.addErrorMessage("body:formAdministrarMedicos:panelTabAgregarCirugia:mnuSala", 
                                           "La sala que desea adicionar ya esta seleccionada");
            }
        }

    


        if (wexito) {
        

            programacion.getId().setHspnclinica(getClinica().getCclncodigo());
            programacion.setHspdfechareg(new Date());
            programacion.setHspcoperador(getUsuarioSystem().getCurcusuari());
            


            try {
                this.serviceLocator.getCirugiaService().saveSalaXProfesional(programacion);
                FacesUtils.addInfoMessage(MSG_ADICION);
                FacesUtils.resetManagedBean("administrarMedicoSalaBean");
                lstAnestesiologosSelect.clear();
                lstAnestesiologosSelect = this.serviceLocator.getCirugiaService().getListaSalasXProfesional(getUsuarioSystem().getCurnprofes(), getClinica().getCclncodigo());
                init();
                programacion = new Chsalaxprofe();
                navegationRule = BeanNavegacion.RUTA_ACTUAL;
            } catch (ModelException e) {
                navegationRule = "";
                FacesUtils.addErrorMessage(MSG_NO_ADICION + ":  " + 
                                           e.getMessage());

            } catch (Exception e1) {
                navegationRule = "";
                FacesUtils.addErrorMessage(MSG_NO_ADICION + e1.getMessage());

            }


        }
        return navegationRule;
    }

   

  
}
