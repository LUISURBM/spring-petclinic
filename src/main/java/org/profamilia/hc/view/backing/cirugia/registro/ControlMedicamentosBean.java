//=======================================================================
// ARCHIVO ControlMedicamentosBean
// FECHA CREACI�N: 
// AUTOR: jariano, nlis
// Descripcion: 
//=======================================================================

package org.profamilia.hc.view.backing.cirugia.registro;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chcontrmedic;
import org.profamilia.hc.model.dto.ChcontrmedicPK;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chformulahos;
import org.profamilia.hc.model.dto.Chnotaenferm;
import org.profamilia.hc.model.dto.ChnotaenfermPK;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.dto.Ctwsdetsolent;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorPlantillaCirugiaBean;
import org.profamilia.hc.view.util.FacesUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//====================================================================


//=================================================================
//  CLASE ControlMedicamentosBean
//=======================================================================
public class ControlMedicamentosBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    private Chformulahos formula;
    
    private Chnotaenferm nota;

    private Chcontrmedic control;

    private List lstOpciones;

    private Date fechaAdministracion;

    private String administroSelect;

    private String esHoraActual;

    private boolean mostrarMedicamento;

    private boolean renderHoraActual;

    private Chcirugprogr cirugia;

    private boolean wexito;

    private Chusuario usuario;

    private List listTipoIdentificacion;

    private List listSexos;

    private List listEstadoCivil;
    
    private Integer tiempoAdministracion;
    
    private String navegationRule; 
    
    private String nextAction; 
    
    private String labelText;
    
    private boolean esIngreso;
    
    private Integer selectedIndex;

    static final int ACTIVAR_APLICACION = 0;

    static final int ACTIVAR_BUSCADOR_PLANTILLAS = 1;
    
    private boolean renderPlantilla;
    
    private UIInput itDescripcion;
    
    private String tipoServicio;
    
    private List listdetsolent;
    
    private List listLote;
    
    private String loteSelect;
    
    private Date fechaVencSelect;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ControlMedicamentosBean() {
    }

    public void init() {
       
        lstOpciones = new ArrayList();
        control = new Chcontrmedic();
        selectedIndex = 0;
        listTipoIdentificacion = new ArrayList();
        listSexos = new ArrayList();
        listEstadoCivil = new ArrayList();
        
        nota = new Chnotaenferm(); 
        
        labelText = "Nota Enfermeria";
        listdetsolent = new ArrayList();
        listLote = new ArrayList();
    }

    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------

    /**
     * @param formula
     */
    public void setFormula(Chformulahos formula) {
        this.formula = formula;
    }

    /**
     * @return
     */
    public Chformulahos getFormula() {
        return formula;
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
     * @param fechaAdministracion
     */
    public void setFechaAdministracion(Date fechaAdministracion) {
        this.fechaAdministracion = fechaAdministracion;
    }

    /**
     * @return
     */
    public Date getFechaAdministracion() {
        return fechaAdministracion;
    }

    /**
     * @param renderHoraActual
     */
    public void setRenderHoraActual(boolean renderHoraActual) {
        this.renderHoraActual = renderHoraActual;
    }

    /**
     * @return
     */
    public boolean isRenderHoraActual() {
        return renderHoraActual;
    }
   

    /**
     * @param administroSelect
     */
    public void setAdministroSelect(String administroSelect) {
        this.administroSelect = administroSelect;
    }

    /**
     * @return
     */
    public String getAdministroSelect() {
        return administroSelect;
    }

    /**
     * @param param
     */
    public void setListTipoIdentificacion(List param) {
        this.listTipoIdentificacion = param;
    }

    /**
     * @return
     */
    public List getListTipoIdentificacion() {
        if (listTipoIdentificacion.size() == 0) {
            ArrayList<Cptipoiden> listTipoIdentificacionAux = null;
            try {
                listTipoIdentificacionAux = 
                        (ArrayList<Cptipoiden>)this.serviceLocator.getClinicoService().getTipoIdentificacion();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listTipoIdentificacionAux.isEmpty()) {

                Iterator it = listTipoIdentificacionAux.iterator();
                int i = 0;
                listTipoIdentificacion.add(new SelectItem("", 
                                                          "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listTipoIdentificacion.add(new SelectItem(listTipoIdentificacionAux.get(i).getCticcodigo(), 
                                                              listTipoIdentificacionAux.get(i).getCticdescri()));
                    i++;
                }
            }
        }

        return listTipoIdentificacion;
    }


    /**
     * @param param
     */
    public void setListSexos(List param) {
        this.listSexos = param;
    }

    /**
     * @return La lista de los sexos que existen
     */
    public List getListSexos() {
        if (listSexos.size() == 0) {
            ArrayList<Chsexo> listSexoAux = null;
            try {
                listSexoAux = 
                        (ArrayList<Chsexo>)this.getServiceLocator().getClinicoService().getSexo();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listSexoAux.isEmpty()) {

                Iterator it = listSexoAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listSexos.add(new SelectItem(listSexoAux.get(i).getCsxecodigo(), 
                                                 listSexoAux.get(i).getCsxcdescripcio()));
                    i++;

                }
            }
        }
        return listSexos;
    }


    /**
     * @param listEstadoCivil
     */
    public void setListEstadoCivil(List listEstadoCivil) {
        this.listEstadoCivil = listEstadoCivil;
    }

    /**
     * @return
     */
    public List getListEstadoCivil() {
        if (listEstadoCivil.size() == 0) {
            ArrayList<Chestadociv> listEstadoCivilAux = null;
            try {
                listEstadoCivilAux = 
                        (ArrayList<Chestadociv>)this.getServiceLocator().getClinicoService().getEstadoCivil();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listEstadoCivilAux.isEmpty()) {

                Iterator it = listEstadoCivilAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listEstadoCivil.add(new SelectItem(listEstadoCivilAux.get(i).getCececodigo(), 
                                                       listEstadoCivilAux.get(i).getCeccdescripcio()));
                    i++;
                }
            }
        }
        return listEstadoCivil;
    }


    /**
     * @param mostrarMedicamento
     */
    public void setMostrarMedicamento(boolean mostrarMedicamento) {
        this.mostrarMedicamento = mostrarMedicamento;
    }

    /**
     * @return
     */
    public boolean isMostrarMedicamento() {
        return mostrarMedicamento;
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
     * @param esHoraActual
     */
    public void setEsHoraActual(String esHoraActual) {
        this.esHoraActual = esHoraActual;
    }

    /**
     * @return
     */
    public String getEsHoraActual() {
        return esHoraActual;
    }


   

    /**
     * @param usuario
     */
    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return
     */
    public Chusuario getUsuario() {
        return usuario;
    }

    /**
     * @param tiempoAdministracion
     */
    public void setTiempoAdministracion(Integer tiempoAdministracion) {
        this.tiempoAdministracion = tiempoAdministracion;
    }

    /**
     * @return
     */
    public Integer getTiempoAdministracion() {
        return tiempoAdministracion;
    }

    /**
     * @param navegationRule
     */
    public void setNavegationRule(String navegationRule) {
        this.navegationRule = navegationRule;
    }

    /**
     * @return
     */
    public String getNavegationRule() {
        return navegationRule;
    }

    /**
     * @param nextAction
     */
    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    /**
     * @return
     */
    public String getNextAction() {
        return nextAction;
    }

    /**
     * @param nota
     */
    public void setNota(Chnotaenferm nota) {
        this.nota = nota;
    }

    /**
     * @return
     */
    public Chnotaenferm getNota() {
        return nota;
    }


    //-----------------------------------------------------------------------
    //  Ajax
    //-----------------------------------------------------------------------

    public void ChangeMedicamento() {
        if (administroSelect != null && administroSelect.equals("S")) {
            mostrarMedicamento = true;
        } else {
            mostrarMedicamento = false;
            renderHoraActual = false;
        }
    }
    
    public void ChangeLote(){
        if(loteSelect != null){
            for(int i=0; i<listLote.size(); i++){
                System.out.println(listLote.get(i));
            }
        }
    }
    
    public void ChangeEsHoraActual() {
        if (esHoraActual != null && esHoraActual.equals("N")) {
            renderHoraActual = true;
        } else {
            renderHoraActual = false;
        }
    }

    /**
     * @param valueChangeEvent
     */
    public void setAdministroSelect(ValueChangeEvent valueChangeEvent) {
        setAdministroSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setEsHoraActual(ValueChangeEvent valueChangeEvent) {
        setEsHoraActual((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

 
    //-----------------------------------------------------------------------
    //  Boton Principal 
    //-----------------------------------------------------------------------  

    /**
     * @return
     */
    public String registrarContolMedicamentos() {
        wexito = true;
        Calendar fechaCalendarAdmin;
        fechaCalendarAdmin = null; 
        nextAction = ""; 
        ChnotaenfermPK idNota;
        idNota = new ChnotaenfermPK();
        String wetapaNota = null; 
        
        if (administroSelect != null && administroSelect.equals("S")) {
         

                if (esHoraActual != null && esHoraActual.equals("N") && tiempoAdministracion != null) {
                     fechaCalendarAdmin = Calendar.getInstance();
                     fechaCalendarAdmin.setTime(new Date());
                     fechaCalendarAdmin.add(Calendar.MINUTE, (tiempoAdministracion * -1));
                     control.setHcmdfechaanota(fechaCalendarAdmin.getTime());
                     nota.setHnedfechanotac(fechaCalendarAdmin.getTime()); 
                     
                }else{
                    fechaCalendarAdmin = Calendar.getInstance();
                    fechaCalendarAdmin.setTime(new Date());
                    control.setHcmdfechaanota(fechaCalendarAdmin.getTime());
                    nota.setHnedfechanotac(fechaCalendarAdmin.getTime()); 
                }
                
            if (nota.getId() == null && cirugia != null) {
                idNota.setHnelnumero(cirugia.getHcplnumero());
                idNota.setHnectiposervi(TIPO_HOSPITALIZACION);
                nota.setId(idNota);
            }
            nota.setHnenclinica(this.getClinica().getCclncodigo());
            nota.setHnelusuario(cirugia.getHcplusuario().getHuslnumero());
            nota.setHnecestado(ESTADO_VIGENTE);
            nota.setHnecoperador(userName());
            nota.setHnedfecregistr(new Date());
            if (tipoServicio != null) {
                nota.getId().setHnectiposervi(tipoServicio);
            }


            try {
                wetapaNota = serviceLocator.getClinicoService().getEtapaActualNotaEnfermeria(cirugia.getHcplnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            
            if(wetapaNota != null && !wetapaNota.equals("")){
                nota.setHnecetapa(wetapaNota);    
            }
            
                
            if (formula != null) {
                formula.setHfhcetapa(ETAPA_ATENDIDO);
                formula.setHfhdfechamodif(new Date());
                formula.setHfhcoperamodif(userName());
                if(fechaCalendarAdmin != null){
                    formula.setHfhdhorasumin(fechaCalendarAdmin.getTime());    
                }
            }

            if (wexito) {
                ChcontrmedicPK idcontrol = new ChcontrmedicPK();
                idcontrol.setHcmlconsulta(cirugia.getHcplnumero());
                idcontrol.setHcmnconsecut(formula.getId().getHfhnconsecut());
                idcontrol.setHcmnevoluconse(formula.getId().getHfhnevoluconse());
               
                control.setId(idcontrol);
                control.setHcmctiposerv(formula.getHfhctiposerv());
                control.setHcmcadosis(formula.getHfhcadosis());
                control.setHcmcetapa(formula.getHfhcetapa());
                control.setHcmcformaadmin(formula.getHfhcformaadmin());
                control.setHcmnfrecuadmin(formula.getHfhnfrecuadmin());
                control.setHcmcmedicament(formula.getHfhcmedicament());
                control.setHcmcoperador(userName());
                control.setHcmcpresentaci(formula.getHfhcpresentaci());
                control.setHcmcviadministr(formula.getHfhcviadministr());
                control.setHcmcunidad(formula.getHfhcunidad());
                control.setHcmdfecregistr(new Date());
                try {
                    fechaVencSelect = this.serviceLocator.getCostosService().getFechaByLote(loteSelect, formula.getHfhccodsap());
                } catch (ModelException e) {
                    // TODO
                }
                try {
                
                
                
                    this.serviceLocator.getClinicoService().saveControlMedicamentoNota(formula, 
                                                                                   control, nota);
                    nextAction = navegationRule; 
                } catch (ModelException e) {
                    nextAction = ""; 
                    e.printStackTrace();
                }
                
                
              
                
            } 
        }
        
        if(esIngreso){
            RegistrarMedicamentosIngresoBean medicamentoBean = null;
            medicamentoBean = 
                    (RegistrarMedicamentosIngresoBean)FacesUtils.getManagedBean("registrarMedicamentosIngresoBean");
            if (medicamentoBean != null) {
                medicamentoBean.setCirugia(cirugia);
                medicamentoBean.init();
            }
            FacesUtils.resetManagedBean("controlMedicamentosBean");
            nextAction = BeanNavegacion.RUTA_IR_INGRESO_MEDICAMENTOS; 
        }else{
        
            RegistrarMedicamentosBean medicamentoBean = null;
            medicamentoBean = 
                    (RegistrarMedicamentosBean)FacesUtils.getManagedBean("registrarMedicamentosBean");
            if (medicamentoBean != null) {
                medicamentoBean.setCirugia(cirugia);
                medicamentoBean.init();
            }
            FacesUtils.resetManagedBean("controlMedicamentosBean");
            nextAction = BeanNavegacion.RUTA_IR_REGISTRO_MEDICAMENTOS;     
        }
        
        return nextAction;
    }

    public void mostrarBuscadorPlantilla() {
        FacesUtils.resetManagedBean("buscadorPlantillaCirugiaBean");
        BuscadorPlantillaCirugiaBean buscador = (BuscadorPlantillaCirugiaBean)FacesUtils.getManagedBean("buscadorPlantillaCirugiaBean");
        if(buscador != null){
            buscador.setNombreBeanAnterior("controlMedicamentosBean");
            buscador.setTagRenderizar("panelGridControlMedicamentosTab");
        }
        selectedIndex = ACTIVAR_BUSCADOR_PLANTILLAS;
        renderPlantilla = true; 
    }
    
    public void aceptarPlantilla() {
        BuscadorPlantillaCirugiaBean buscador = 
            (BuscadorPlantillaCirugiaBean)FacesUtils.getManagedBean("buscadorPlantillaCirugiaBean");
        if (buscador != null && buscador.getPlantillaSelect() != null) {
            itDescripcion.setValue(buscador.getPlantillaSelect().getHplcdescripcio());
            nota.setHnecnotaenferm(buscador.getPlantillaSelect().getHplcdescripcio());

        }
        renderPlantilla = false; 
        selectedIndex = ACTIVAR_APLICACION;
        FacesUtils.resetManagedBean("buscadorPlantillaBean");
    }

    public void setEsIngreso(boolean esIngreso) {
        this.esIngreso = esIngreso;
    }

    public boolean isEsIngreso() {
        return esIngreso;
    }
    
    /**
     * @param selectedIndex
     */
    public void setSelectedIndex(Integer selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    /**
     * @return
     */
    public Integer getSelectedIndex() {
        return selectedIndex;
    }
    
    /**
     * @param renderPlantilla
     */
    public void setRenderPlantilla(boolean renderPlantilla) {
        this.renderPlantilla = renderPlantilla;
    }

    /**
     * @return
     */
    public boolean isRenderPlantilla() {
        return renderPlantilla;
    }
    
    /**
     * @param itDescripcion
     */
    public void setItDescripcion(UIInput itDescripcion) {
        this.itDescripcion = itDescripcion;
    }

    /**
     * @return
     */
    public UIInput getItDescripcion() {
        return itDescripcion;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }


    public void setListLote(List listLote) {
        this.listLote = listLote;
    }

    public List getListLote() {
    if(listLote.size() == 0){
        ArrayList<Ctwsdetsolent> listLoteAux = null;
        try{
            listLoteAux = (ArrayList<Ctwsdetsolent>)this.getServiceLocator().getCostosService().geLstLotesByCodigoDto(formula.getHfhccodsap());
        }catch(ModelException e){
            e.printStackTrace();
        }
        
        if(!listLoteAux.isEmpty()){
            Iterator it = listLoteAux.iterator();
            int i=0;
            while(it.hasNext()){
                it.next();
                listLote.add(new SelectItem(listLoteAux.get(i).getComp_id().getCdsenitem(), listLoteAux.get(i).getCdseclote()+"   "+listLoteAux.get(i).getCdsedfecvenc()));
                i++;
            }
        }
    }
        return listLote;
    }


    public void setLoteSelect(String loteSelect) {
        this.loteSelect = loteSelect;
    }

    public String getLoteSelect() {
        return loteSelect;
    }

    public void setLoteSelect(ValueChangeEvent valueChangeEvent) {
         setLoteSelect((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setFechaVencSelect(Date fechaVencSelect) {
        this.fechaVencSelect = fechaVencSelect;
    }

    public Date getFechaVencSelect() {
        return fechaVencSelect;
    }
}

