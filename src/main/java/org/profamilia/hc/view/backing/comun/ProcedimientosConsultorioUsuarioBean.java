//=======================================================================
// ARCHIVO ProcedimientosConsultorioUsuarioBean.java
// FECHA CREACI�N: 05/05/2010
// AUTOR: Jos� Andr�s Riano Rinc�n 
// Descripci�n: Datos correspondientes a los procedimientos en consultorio
//=======================================================================
package org.profamilia.hc.view.backing.comun;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chproceconsu;
import org.profamilia.hc.model.dto.ChproceconsuPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cractoquir;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.dto.Crfinalcon;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.clinico.comun.Cie10Bean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorPlantillaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  CLASE ProcedimientosConsultorioUsuarioBean
//=======================================================================
public class ProcedimientosConsultorioUsuarioBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chproceconsu procedimiento;

    private Integer selectedIndex;

    private boolean mostrarCie10;

    private List lstAmbito;

    private List lstFinalidad;
    
    private List lstRealizacion; 

    private String diagnosticoPrevio;

    private String diagnosticoPosterior;

    private String procedimientoCups;

    private List lstOpciones;

    private String tieneComplicaciones;

    private String diagnosticoComplicacion;

    private String finalidadSelect;

    private Integer edad;

    private Crdgncie10 diagprin;

    private Crdgncie10 diagpost;

    private Crdgncie10 diagCompl;

    private boolean mostrarComplicaciones;

    private boolean exito;

    static final int ACTIVAR_PROCEDIMIENTOS_CONSULTORIO = 0;

    static final int ACTIVAR_BUSCADOR_DIAGNOSTICO = 1;
    
    static final int ACTIVAR_BUSCADOR_PLANTILLAS = 2;

    private boolean modoconsulta;

    private String menuBean;

    /** Almacena el consulta */
    private Cnconsclin consulta;

    private String navigationRule;

    private String tipoServicio;

    private Chusuario usuario;

    private String nextAction;

    private UIInput itDiagPrevio;

    private UIInput itDiagPosterior;

    private UIInput itDiagComplicacion;
    
    private boolean renderPlantilla; 
    
    private UIInput itDescripcion; 
    
    /** */ 
    private boolean tipoHisto;
    
    /** Render Dolor Cirugia*/
    private boolean renderDolor;
    
    /** Lista que almacena la lista escala de dolor */
    private List<SelectItem> listEscala;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ProcedimientosConsultorioUsuarioBean() {
    }

    public void init() {
        selectedIndex = 0;
        nextAction = "";
        inicializarProcedimiento();
    }

    public void inicializarProcedimiento() {
        tipoHisto = false;
        renderDolor = false;
        if (usuario != null && usuario.getHusdfechanacim() != null) {
            edad = calcularEdad(usuario.getHusdfechanacim(), new Date());
        }

        if (consulta != null) {
            if (consulta.getCcocservic() != null) {
                procedimientoCups = consulta.getCcocservic().getCsvcnombre();
            }

            try {
                procedimiento = 
                        this.serviceLocator.getClinicoService().getProcedimientoConsultorio(consulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if(consulta.getCcocservic().getCsvntiphis().equals(CIRUGIA_PROCEDIMIENTO_CONSULTORIO_IVE)){
                tipoHisto = true;
             }
        }
        
      
        
      


        if (procedimiento == null) {
            procedimiento = new Chproceconsu();
            procedimiento.setHpcnambitproce(1);
        } else {
            if (procedimiento.getHpcnfinalidad() != null) {
                finalidadSelect = procedimiento.getHpcnfinalidad().toString();
            }

            if(procedimiento.getHpccrefierdolor() != null && procedimiento.getHpccrefierdolor().equals("S")){
                renderDolor = true;
            }
            
            if (procedimiento.getHpccdiagprinci() != null && 
                !procedimiento.getHpccdiagprinci().equals("")) {
                try {
                    diagprin = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(procedimiento.getHpccdiagprinci().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagprin != null && diagprin.getCdcccodigo() != null) {
                    diagnosticoPrevio = diagprin.getCdccdescri();
                }
            }

            if (procedimiento.getHpccdiagposter() != null && 
                !procedimiento.getHpccdiagposter().equals("")) {
                try {
                    diagpost = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(procedimiento.getHpccdiagposter().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagpost != null && diagpost.getCdcccodigo() != null) {
                    diagnosticoPosterior = diagpost.getCdccdescri();
                }

            }

            if (procedimiento.getHpccdiagcompli() != null && 
                !procedimiento.getHpccdiagcompli().equals("")) {
                tieneComplicaciones = "S";
                mostrarComplicaciones = true;

                try {
                    diagCompl = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(procedimiento.getHpccdiagcompli().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagCompl != null && diagCompl.getCdcccodigo() != null) {
                    diagnosticoComplicacion = diagCompl.getCdccdescri();
                }

            } else {
                tieneComplicaciones = "N";
                mostrarComplicaciones = false;
            }

        }

    }




    //-----------------------------------------------------------------------
    //   ValueChange
    //-----------------------------------------------------------------------


    /**
     * @param valueChangeEvent
     */
    public void setHpccdiagprinci(ValueChangeEvent valueChangeEvent) {
        procedimiento.setHpccdiagprinci((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHpccdiagposter(ValueChangeEvent valueChangeEvent) {
        procedimiento.setHpccdiagposter((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHpccdiagcompli(ValueChangeEvent valueChangeEvent) {
        procedimiento.setHpccdiagcompli((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setTieneComplicaciones(ValueChangeEvent valueChangeEvent) {
        setTieneComplicaciones((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    //-----------------------------------------------------------------------
    //   // Acciones AJAX
    //-----------------------------------------------------------------------


    public void mostrarDiagnosticoPrevio() {
        Cie10Bean cie10;
        if (procedimiento != null) {
            procedimiento.setHpccdiagprinci(null);
        }

        cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");
        cie10.setDiagnosticoPrincipal(true);
        cie10.setDiagnosticoRelacionado1(false);
        cie10.setDiagnosticoRelacionado2(false);
        cie10.setDiagnosticoRelacionado3(false);
        mostrarCie10 = true;
        selectedIndex = ACTIVAR_BUSCADOR_DIAGNOSTICO;
    }


    public void mostrarDiagnosticoPosterior() {
        Cie10Bean cie10;
        if (procedimiento != null) {
            procedimiento.setHpccdiagposter(null);
        }
        cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");
        cie10.setDiagnosticoPrincipal(false);
        cie10.setDiagnosticoRelacionado1(true);
        cie10.setDiagnosticoRelacionado2(false);
        cie10.setDiagnosticoRelacionado3(false);
        mostrarCie10 = true;
        selectedIndex = ACTIVAR_BUSCADOR_DIAGNOSTICO;
    }

    public void mostrarDiagnosticoComplicacion() {
        Cie10Bean cie10;
        if (procedimiento != null) {
            procedimiento.setHpccdiagcompli(null);
        }

        cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");
        cie10.setDiagnosticoPrincipal(false);
        cie10.setDiagnosticoRelacionado1(false);
        cie10.setDiagnosticoRelacionado2(true);
        cie10.setDiagnosticoRelacionado3(false);
        selectedIndex = ACTIVAR_BUSCADOR_DIAGNOSTICO;
        mostrarCie10 = true;
    }
    
    public void listenDolorCirugia(ValueChangeEvent valueChangeEvent) {
        String value = 
            (String)(((UIInput)valueChangeEvent.getComponent()).getValue());
        if (value.equals("S")) {
            renderDolor = true;
        } else if (value.equals("N")) {
            renderDolor = false;
        }
    }


    public void changeDiagnosticoPrevio() {
        List validacionPrincipal1 = null;
        diagnosticoPrevio = null;


        if (procedimiento != null) {
            if (procedimiento.getHpccdiagprinci() != null && 
                !procedimiento.getHpccdiagprinci().equals("")) {
                try {
                    diagprin = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(procedimiento.getHpccdiagprinci().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagprin != null && diagprin.getCdcccodigo() != null) {
                    diagnosticoPrevio = diagprin.getCdccdescri();
                    validacionPrincipal1 = 
                            this.serviceLocator.getClinicoService().getVerificacionCie10(diagprin, 
                                                                                         usuario.getHusesexo(), 
                                                                                         "1", 
                                                                                         edad, 
                                                                                         "S");

                    if (validacionPrincipal1 != null && 
                        !validacionPrincipal1.isEmpty()) {
                        if (validacionPrincipal1.get(1) != null) {
                            FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_PRINCIPAL + 
                                                       validacionPrincipal1.get(1));
                        }

                    }

                }

                if (diagnosticoPrevio == null || 
                    diagnosticoPrevio.equals("")) {
                    FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_PRINCIPAL_NO_VALIDO);
                }
            } else {
                diagnosticoPrevio = "";
            }
        }
    }

    public void changeDiagnosticoPosterior() {

        diagnosticoPosterior = null;
        List validacionRelacionado1 = null;

        if (procedimiento.getHpccdiagposter() != null && 
            !procedimiento.getHpccdiagposter().equals("")) {
            try {
                diagpost = 
                        this.serviceLocator.getClinicoService().getCIE10PorCodigo(procedimiento.getHpccdiagposter().toUpperCase());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (diagpost != null && diagpost.getCdcccodigo() != null) {
                diagnosticoPosterior = diagpost.getCdccdescri();
                validacionRelacionado1 = 
                        this.serviceLocator.getClinicoService().getVerificacionCie10(diagpost, 
                                                                                     usuario.getHusesexo(), 
                                                                                     "1", 
                                                                                     edad, 
                                                                                     "N");

                if (validacionRelacionado1 != null && 
                    !validacionRelacionado1.isEmpty()) {
                    if (validacionRelacionado1.get(1) != null) {
                        FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_RELACIONADO1 + 
                                                   validacionRelacionado1.get(1));
                    }

                }

            }

            if (diagnosticoPosterior == null || 
                diagnosticoPosterior.equals("")) {
                FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_RELACIONADO1_NO_VALIDO);
            }
        } else {
            diagnosticoPosterior = "";
        }
    }


    public void changeDiagnosticoComplicacion() {

        diagnosticoComplicacion = null;


        if (procedimiento.getHpccdiagcompli() != null && 
            !procedimiento.getHpccdiagcompli().equals("")) {
            try {
                diagCompl = 
                        this.serviceLocator.getClinicoService().getCIE10PorCodigo(procedimiento.getHpccdiagcompli().toUpperCase());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (diagCompl != null && diagCompl.getCdcccodigo() != null) {
                diagnosticoComplicacion = diagCompl.getCdccdescri();

            }

            if (diagnosticoComplicacion == null || 
                diagnosticoComplicacion.equals("")) {
                FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_COMPLICACION_NO_VALIDO);
            }
        } else {
            diagnosticoComplicacion = "";
        }
    }

    public void changeComplicaciones() {
        if (tieneComplicaciones != null && tieneComplicaciones.equals("S")) {
            mostrarComplicaciones = true;
        } else {
            mostrarComplicaciones = false;
            diagnosticoComplicacion = "";
            procedimiento.setHpccdescrcompl(null);
            procedimiento.setHpccdiagcompli(null);
        }
    }

    //-----------------------------------------------------------------------
    //   // Metodo es Valido
    //-----------------------------------------------------------------------

    public boolean esValido() {
        boolean esValido = false;
        Chproceconsu procedimientoAux = null;
        if (consulta != null) {

            try {
                procedimientoAux = 
                        this.getServiceLocator().getClinicoService().getProcedimientoConsultorio(consulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (procedimientoAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }


    public void aceptarDiagnostico() {
        Cie10Bean cie10;
        cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");

        if (cie10 != null && cie10.getCie10Select() != null) {
            if (cie10.isDiagnosticoPrincipal()) {

                procedimiento.setHpccdiagprinci(cie10.getCie10Select().getCdcccodigo());
                itDiagPrevio.setValue(cie10.getCie10Select().getCdcccodigo());
                diagnosticoPrevio = cie10.getCie10Select().getCdccdescri();

            }
            if (cie10.isDiagnosticoRelacionado1()) {
                procedimiento.setHpccdiagposter(cie10.getCie10Select().getCdcccodigo());
                itDiagPosterior.setValue(cie10.getCie10Select().getCdcccodigo());
                diagnosticoPosterior = cie10.getCie10Select().getCdccdescri();
            }
            if (cie10.isDiagnosticoRelacionado2()) {
                procedimiento.setHpccdiagcompli(cie10.getCie10Select().getCdcccodigo());
                itDiagComplicacion.setValue(cie10.getCie10Select().getCdcccodigo());
                diagnosticoComplicacion = 
                        cie10.getCie10Select().getCdccdescri();
            }
        }

        mostrarCie10 = false;
        selectedIndex = ACTIVAR_PROCEDIMIENTOS_CONSULTORIO;
        cie10.clear();

    }
    
    public void aceptarPlantilla() {
        BuscadorPlantillaBean buscador = 
            (BuscadorPlantillaBean)FacesUtils.getManagedBean("buscadorPlantillaBean");
        if (buscador != null && buscador.getPlantillaSelect() != null) {
            itDescripcion.setValue(buscador.getPlantillaSelect().getHplcdescripcio());
           procedimiento.setHpccdescrproce(buscador.getPlantillaSelect().getHplcdescripcio());
        }
        renderPlantilla = false;
        selectedIndex = ACTIVAR_PROCEDIMIENTOS_CONSULTORIO;
        FacesUtils.resetManagedBean("buscadorPlantillaBean");
    }
    
    
    public void mostrarBuscadorPlantilla(){
        selectedIndex = ACTIVAR_BUSCADOR_PLANTILLAS; 
        FacesUtils.resetManagedBean("buscadorPlantillaBean");
        renderPlantilla = true; 
    }


    //-----------------------------------------------------------------------
    //   Boton Principal
    //-----------------------------------------------------------------------

    public String aceptar() {
        exito = true;
        navigationRule = "";
        ChproceconsuPK id = new ChproceconsuPK();

        if (finalidadSelect == null || finalidadSelect.equals("")) {
            FacesUtils.addErrorMessage("body:formProcedimientoConsultorio:panelTabProcedimientoConsultorio:menuFinalidadProcedimiento", 
                                       MSG_CAMPO_OBLIGATORIO);
            exito = false;
        }

        if (procedimiento != null) {
        
            if (procedimiento.getHpcnrealizacio() == null) {
                FacesUtils.addErrorMessage("body:formProcedimientoConsultorio:panelTabProcedimientoConsultorio:mnuRealizacion", 
                                           MSG_CAMPO_OBLIGATORIO);
                exito = false;
            }

        
        
        
            if (procedimiento.getHpccdiagprinci() == null || 
                procedimiento.getHpccdiagprinci().equals("")) {
                FacesUtils.addErrorMessage("body:formProcedimientoConsultorio:panelTabProcedimientoConsultorio:itDiagPrevio", 
                                           MSG_CAMPO_OBLIGATORIO);
                exito = false;
            }

            if (procedimiento.getHpccdiagposter() == null || 
                procedimiento.getHpccdiagposter().equals("")) {
                FacesUtils.addErrorMessage("body:formProcedimientoConsultorio:panelTabProcedimientoConsultorio:itDiagPosterior", 
                                           MSG_CAMPO_OBLIGATORIO);
                exito = false;
            }

            if (procedimiento.getHpccdescrproce() == null || 
                procedimiento.getHpccdescrproce().equals("")) {
                FacesUtils.addErrorMessage("body:formProcedimientoConsultorio:panelTabProcedimientoConsultorio:inputTextAreaDescripcion", 
                                           MSG_CAMPO_OBLIGATORIO);
                exito = false;
            }

            if (tieneComplicaciones == null || 
                tieneComplicaciones.equals("")) {
                FacesUtils.addErrorMessage("body:formProcedimientoConsultorio:panelTabProcedimientoConsultorio:mnuComplicaciones", 
                                           MSG_CAMPO_OBLIGATORIO);
                exito = false;
            }

            if (tieneComplicaciones != null && 
                tieneComplicaciones.equals("S")) {

                if (procedimiento.getHpccdiagcompli() == null || 
                    procedimiento.getHpccdiagcompli().equals("")) {
                    FacesUtils.addErrorMessage("body:formProcedimientoConsultorio:panelTabProcedimientoConsultorio:itDiagComplicacion", 
                                               MSG_CAMPO_OBLIGATORIO);
                    exito = false;
                }

                if (procedimiento.getHpccdescrcompl() == null || 
                    procedimiento.getHpccdescrcompl().equals("")) {
                    FacesUtils.addErrorMessage("body:formProcedimientoConsultorio:panelTabProcedimientoConsultorio:inputTextareaComplicaciones", 
                                               MSG_CAMPO_OBLIGATORIO);
                    exito = false;
                }
            }
        }
 

        if (finalidadSelect != null && !finalidadSelect.equals("")) {
            procedimiento.setHpcnfinalidad(new Integer(finalidadSelect));
        }


        if (consulta != null && consulta.getCconnumero() != null) {
            id.setHpclconsulta(new Long(consulta.getCconnumero()));
            id.setHpcctiposervi(TIPO_CONSULTA);
            procedimiento.setId(id);
        }
        procedimiento.setHpccoperador(userName());
        procedimiento.setHpcdfecregistr(new Date());

        if (exito) {
            try {
                this.getServiceLocator().getClinicoService().saveProcedimientoConsultorio(procedimiento);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                navigationRule = nextAction;
                FacesUtils.resetManagedBean(menuBean);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                navigationRule = null;
                e.printStackTrace();
            }

        }

        return navigationRule;
    }
    
    
    //-----------------------------------------------------------------------
    // GET/SET
    //-----------------------------------------------------------------------

    /**
     * @param finalidadSelect
     */
    public void setFinalidadSelect(String finalidadSelect) {
        this.finalidadSelect = finalidadSelect;
    }

    /**
     * @return
     */
    public String getFinalidadSelect() {
        return finalidadSelect;
    }

    /**
     * @param procedimiento
     */
    public void setProcedimiento(Chproceconsu procedimiento) {
        this.procedimiento = procedimiento;
    }

    /**
     * @return
     */
    public Chproceconsu getProcedimiento() {
        return procedimiento;
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
     * @param mostrarCie10
     */
    public void setMostrarCie10(boolean mostrarCie10) {
        this.mostrarCie10 = mostrarCie10;
    }

    /**
     * @return
     */
    public boolean isMostrarCie10() {
        return mostrarCie10;
    }


    /**
     * @param lstAmbito
     */
    public void setLstAmbito(List lstAmbito) {
        this.lstAmbito = lstAmbito;
    }

    /**
     * @return
     */
    public List getLstAmbito() {
        if (lstAmbito == null || lstAmbito.isEmpty()) {
            lstAmbito = new ArrayList();
            lstAmbito.add(new SelectItem("", "Seleccione una opci�n"));
            lstAmbito.add(new SelectItem(1, "Ambulatorio"));
            lstAmbito.add(new SelectItem(2, "Hospitalario"));
            lstAmbito.add(new SelectItem(3, "En Urgencia"));
        }
        return lstAmbito;
    }

    /**
     * @param lstFinalidad
     */
    public void setLstFinalidad(List lstFinalidad) {
        this.lstFinalidad = lstFinalidad;
    }

    /**
     * @return
     */
    public List getLstFinalidad() {
        if (lstFinalidad == null || lstFinalidad.isEmpty()) {
            lstFinalidad = new ArrayList();
            ArrayList<Crfinalcon> lstFinalidadesAux = null;
            try {
                lstFinalidadesAux = 
                        (ArrayList<Crfinalcon>)this.getServiceLocator().getClinicoService().getFinalidadesConsultaVG(IConstantes.TIPO_PROCEDIMIENTO);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstFinalidadesAux.isEmpty()) {

                lstFinalidad.add(new SelectItem("", 
                                                "Seleccione una opcion ..."));
                Iterator it = lstFinalidadesAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstFinalidad.add(new SelectItem((lstFinalidadesAux.get(i).getId().getCfcncodigo().toString()), 
                                                    lstFinalidadesAux.get(i).getCfccdescri()));
                    i++;
                }
            }
        }
        return lstFinalidad;
    }


    /**
     * @param menuBean
     */
    public void setMenuBean(String menuBean) {
        this.menuBean = menuBean;
    }

    /**
     * @return
     */
    public String getMenuBean() {
        return menuBean;
    }

    /**
     * @param consulta
     */
    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    /**
     * @return
     */
    public Cnconsclin getConsulta() {
        return consulta;
    }


    /**
     * @param tipoServicio
     */
    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * @return
     */
    public String getTipoServicio() {
        return tipoServicio;
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
     * @param modoconsulta
     */
    public void setModoconsulta(boolean modoconsulta) {
        this.modoconsulta = modoconsulta;
    }

    /**
     * @return
     */
    public boolean isModoconsulta() {
        return modoconsulta;
    }


    /**
     * @param diagnosticoPrevio
     */
    public void setDiagnosticoPrevio(String diagnosticoPrevio) {
        this.diagnosticoPrevio = diagnosticoPrevio;
    }

    /**
     * @return
     */
    public String getDiagnosticoPrevio() {
        return diagnosticoPrevio;
    }

    /**
     * @param diagnosticoPosterior
     */
    public void setDiagnosticoPosterior(String diagnosticoPosterior) {
        this.diagnosticoPosterior = diagnosticoPosterior;
    }

    /**
     * @return
     */
    public String getDiagnosticoPosterior() {
        return diagnosticoPosterior;
    }

    /**
     * @param procedimientoCups
     */
    public void setProcedimientoCups(String procedimientoCups) {
        this.procedimientoCups = procedimientoCups;
    }

    /**
     * @return
     */
    public String getProcedimientoCups() {
        return procedimientoCups;
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
        if (lstOpciones == null || lstOpciones.isEmpty()) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
    }

    /**
     * @param tieneComplicaciones
     */
    public void setTieneComplicaciones(String tieneComplicaciones) {
        this.tieneComplicaciones = tieneComplicaciones;
    }

    /**
     * @return
     */
    public String getTieneComplicaciones() {
        return tieneComplicaciones;
    }


    /**
     * @param diagnosticoComplicacion
     */
    public void setDiagnosticoComplicacion(String diagnosticoComplicacion) {
        this.diagnosticoComplicacion = diagnosticoComplicacion;
    }

    /**
     * @return
     */
    public String getDiagnosticoComplicacion() {
        return diagnosticoComplicacion;
    }

    /**
     * @param mostrarComplicaciones
     */
    public void setMostrarComplicaciones(boolean mostrarComplicaciones) {
        this.mostrarComplicaciones = mostrarComplicaciones;
    }

    /**
     * @return
     */
    public boolean isMostrarComplicaciones() {
        return mostrarComplicaciones;
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
     * @param itDiagPrevio
     */
    public void setItDiagPrevio(UIInput itDiagPrevio) {
        this.itDiagPrevio = itDiagPrevio;
    }

    /**
     * @return
     */
    public UIInput getItDiagPrevio() {
        return itDiagPrevio;
    }

    /**
     * @param itDiagPosterior
     */
    public void setItDiagPosterior(UIInput itDiagPosterior) {
        this.itDiagPosterior = itDiagPosterior;
    }

    /**
     * @return
     */
    public UIInput getItDiagPosterior() {
        return itDiagPosterior;
    }

    /**
     * @param itDiagComplicacion
     */
    public void setItDiagComplicacion(UIInput itDiagComplicacion) {
        this.itDiagComplicacion = itDiagComplicacion;
    }

    /**
     * @return
     */
    public UIInput getItDiagComplicacion() {
        return itDiagComplicacion;
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
    
    /**
     * @param lstRealizacion
     */
    public void setLstRealizacion(List lstRealizacion) {
        this.lstRealizacion = lstRealizacion;
    }

    /**
     * @return
     */
    public List getLstRealizacion() {
        if (lstRealizacion == null || lstRealizacion.isEmpty()) {
            lstRealizacion = new ArrayList();
            ArrayList<Cractoquir> lstRealizacionAux = null;
            try {
                lstRealizacionAux = 
                        (ArrayList<Cractoquir>)this.getServiceLocator().getClinicoService().getActoQuirurgico();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstRealizacionAux.isEmpty()) {

                lstRealizacion.add(new SelectItem("", 
                                                "Seleccione una opcion ..."));
                Iterator it = lstRealizacionAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstRealizacion.add(new SelectItem((lstRealizacionAux.get(i).getCaqncodigo()), 
                                                    lstRealizacionAux.get(i).getCaqcdescri()));
                    i++;
                }
            }
        }
        return lstRealizacion;
    }

    public void setTipoHisto(boolean tipoHisto) {
        this.tipoHisto = tipoHisto;
    }

    public boolean isTipoHisto() {
        return tipoHisto;
    }

    public void setListEscala(List<SelectItem> listEscala) {
        this.listEscala = listEscala;
    }

    public List<SelectItem> getListEscala() {

        if (listEscala == null || listEscala.isEmpty()) {
            listEscala = new ArrayList<SelectItem>();

            listEscala.add(new SelectItem(0, "0"));
            listEscala.add(new SelectItem(1, "1"));
            listEscala.add(new SelectItem(2, "2"));
            listEscala.add(new SelectItem(3, "3"));
            listEscala.add(new SelectItem(4, "4"));
            listEscala.add(new SelectItem(5, "5"));
            listEscala.add(new SelectItem(6, "6"));
            listEscala.add(new SelectItem(7, "7"));
            listEscala.add(new SelectItem(8, "8"));
            listEscala.add(new SelectItem(9, "9"));
            listEscala.add(new SelectItem(10, "10"));

        }

        return listEscala;
    }


    public void setRenderDolor(boolean renderDolor) {
        this.renderDolor = renderDolor;
    }

    public boolean isRenderDolor() {
        return renderDolor;
    }
}
