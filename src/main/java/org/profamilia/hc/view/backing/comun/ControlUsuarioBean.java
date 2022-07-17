//=======================================================================
// ARCHIVO ControlUsuarioBean.java
// FECHA CREACI�N: 09/06/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a las consultas de control sin costo 
// patologica.
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;

import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chcontrolcon;
import org.profamilia.hc.model.dto.ChcontrolconPK;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.ChimprdiagPK;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.dto.ChmotivoconPK;
import org.profamilia.hc.model.dto.Chtipodiagno;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Crcausaext;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.dto.Crfinalcon;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.clinico.comun.Cie10Bean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE ControlUsuarioBean
//=======================================================================

public class ControlUsuarioBean extends BaseBean {


    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    private Chcontrolcon control;
    
    private Chimprdiag impresion;

    private Integer tipoHistoria;
    
    private Integer consecutivo; 

    private String menuBean;

    private String navigationRule;

    private String nextAction;

    private Chusuario usuario;
    
    private boolean motivoOpcional; 
    
    private boolean enfermedadOpcional;
    
    /** Almacena la lista de causas para el codigo del motivo de consulta */
    private List<SelectItem> lstCausa;
    
    /** Almacena la lista de finalidades  */
    private List<SelectItem> lstFinalidades;
    
    /** Almacena el motivo de consulta el cual se va a persistir*/
    private Chmotivocon motivo;
    
    private Long numeroConsulta; 
    
    private String tipoServicio; 
    
    private boolean mostrarCie10; 
    
    private int selectedIndex;
    
    private UIInput inputDiagPrincipal;

    private UIInput inputDiagRelacionado1;

    private UIInput inputDiagRelacionado2;

    private UIInput inputDiagRelacionado3;
    
    private String diagnosticoPrincipal;

    private String diagnosticoRelacionado1;

    private String diagnosticoRelacionado2;

    private String diagnosticoRelacionado3;
    
    private Crdgncie10 diagprin;

    private Crdgncie10 diagrela1;

    private Crdgncie10 diagrela2;

    private Crdgncie10 diagrela3;
    
    private Integer edad;
    
    private List lstTipoImpresion; 
    
    static final int ACTIVAR_IMPRESION_DIAGNOSTICA = 0;

    static final int ACTIVAR_BUSCADOR = 1;
    
    private String codigoDiagnostico;
    
    private String codigoRelacionado1;
    
    private String codigoRelacionado2;
    
    private String codigoRelacionado3;
    
    private boolean requiredRel1; 
    
    private boolean requiredRel2; 
    
    private boolean requiredRel3; 
    
    private boolean disableRel1; 
    
    private boolean disableRel2; 
    
    private boolean disableRel3;
    
    private boolean controlrender;
    
    private List<SelectItem> lstPatologias;
    
    private List<SelectItem>lstOpciones;
    
    private List<SelectItem>lstResPatols;
    
    private List<SelectItem>lstBiopsia;
    
    private boolean renderTipoPatologia;
    
    private boolean renderPatologiaCual;
    
    private boolean renderDescripcionResultados;
    
    private boolean rendeGineco;
    
    private boolean renderResultado;
    
    private List<SelectItem>lstClasificacionHistol;
    
    private List<SelectItem>lstGradoTumor;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ControlUsuarioBean() {
    
    }

    public void init() {
        inicializarControl();
        nextAction = "";
        motivoOpcional = false;
        controlrender =true;
        renderDescripcionResultados = false;
        renderPatologiaCual = false;
        renderTipoPatologia = false;
        rendeGineco=false;
        renderResultado=false;
    }

    public void inicializarControl() {
    

                if (usuario != null && usuario.getHusdfechanacim() != null) {
                    edad = calcularEdad(usuario.getHusdfechanacim(), new Date());
                }
    
        try {
            if (numeroConsulta != null) {
                motivo = 
                        this.getServiceLocator().getClinicoService().getMotivoConsulta(numeroConsulta);
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (motivo == null) {
            motivo = new Chmotivocon();

        }
        
        
        try {
            if (numeroConsulta != null) {
                impresion = 
                        this.getServiceLocator().getClinicoService().getImresionDiagnostica(numeroConsulta,consecutivo );
            }


        } catch (ModelException e) {
            e.printStackTrace();
        }


        if (impresion == null) {

            impresion = new Chimprdiag();
            impresion.setHidcdiagprin("");
            impresion.setHidcdiagrela1("");
            impresion.setHidcdiagrela2("");
            impresion.setHidcdiagrela3("");
            
            
            if (codigoDiagnostico != null && !codigoDiagnostico.equals("")) {
                try {
                    diagprin = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(codigoDiagnostico.toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagprin != null && diagprin.getCdcccodigo() != null) {
                    diagnosticoPrincipal = diagprin.getCdccdescri();
                }

                impresion.setHidcdiagprin(codigoDiagnostico);
            }

          
            
            if (codigoRelacionado1 != null && !codigoRelacionado1.equals("")) {
                try {
                    diagrela1 = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(codigoRelacionado1.toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagrela1 != null && diagrela1.getCdcccodigo() != null) {
                    diagnosticoRelacionado1 = diagrela1.getCdccdescri();
                }

                impresion.setHidcdiagrela1(codigoRelacionado1);
            }
            
            
            
            if (codigoRelacionado2 != null && !codigoRelacionado2.equals("")) {
                try {
                    diagrela2 = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(codigoRelacionado2.toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagrela2 != null && diagrela2.getCdcccodigo() != null) {
                    diagnosticoRelacionado2 = diagrela2.getCdccdescri();
                }

                impresion.setHidcdiagrela2(codigoRelacionado2);
            }
            
            
            if (codigoRelacionado3 != null && !codigoRelacionado3.equals("")) {
                try {
                    diagrela3 = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(codigoRelacionado3.toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagrela3 != null && diagrela3.getCdcccodigo() != null) {
                    diagnosticoRelacionado3 = diagrela3.getCdccdescri();
                }

                impresion.setHidcdiagrela3(codigoRelacionado3);
            }

        } else {

            if (impresion.getHidcdiagprin() != null && 
                !impresion.getHidcdiagprin().equals("")) {
                try {
                    diagprin = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagprin().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagprin != null && diagprin.getCdcccodigo() != null) {
                    diagnosticoPrincipal = diagprin.getCdccdescri();
                }
            }

            if (impresion.getHidcdiagrela1() != null && 
                !impresion.getHidcdiagrela1().equals("")) {
                try {
                    diagrela1 = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagrela1().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagrela1 != null && diagrela1.getCdcccodigo() != null) {
                    diagnosticoRelacionado1 = diagrela1.getCdccdescri();
                }

            }

            if (impresion.getHidcdiagrela2() != null && 
                !impresion.getHidcdiagrela2().equals("")) {
                try {
                    diagrela2 = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagrela2().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagrela2 != null && diagrela2.getCdcccodigo() != null) {
                    diagnosticoRelacionado2 = diagrela2.getCdccdescri();
                }

            }

            if (impresion.getHidcdiagrela3() != null && 
                !impresion.getHidcdiagrela3().equals("")) {
                try {
                    diagrela3 = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagrela3().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagrela3 != null && diagrela3.getCdcccodigo() != null) {
                    diagnosticoRelacionado3 = diagrela3.getCdccdescri();
                }

            }
        }


    
        try {
            if (numeroConsulta != null) {
            control = 
                    serviceLocator.getClinicoService().getControlConsulta(numeroConsulta);
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (control == null) {
            control = new Chcontrolcon();
        }
        if(lstPatologias !=null && !lstPatologias.isEmpty()){
            changeTraePatologia();
            changePatologia();
        }
     
        if(tipoHistoria==HISTORIA_GINECOLOGIA || tipoHistoria==HISTORIA_CONTROL_GINECOLOGIA){
            rendeGineco= true;
            changeResultados();
        }
       
    }


    //-----------------------------------------------------------------------
    //  GET/SET
    //-----------------------------------------------------------------------

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
     * @param control
     */
    public void setControl(Chcontrolcon control) {
        this.control = control;
    }

    /**
     * @return
     */
    public Chcontrolcon getControl() {
        return control;
    }

    /**
     * @param tipoHistoria
     */
    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    /**
     * @return
     */
    public Integer getTipoHistoria() {
        return tipoHistoria;
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
     * @param motivoOpcional
     */
    public void setMotivoOpcional(boolean motivoOpcional) {
        this.motivoOpcional = motivoOpcional;
    }

    /**
     * @return
     */
    public boolean isMotivoOpcional() {
        return motivoOpcional;
    }
    
    /**
     * @param lstCausa
     */
    public void setLstCausa(List<SelectItem> lstCausa) {
        this.lstCausa = lstCausa;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstCausa() {
        if (lstCausa == null || lstCausa.isEmpty()) {
            lstCausa = new ArrayList<SelectItem>();
            ArrayList<Crcausaext> lstCausaAux = null;
            try {
                lstCausaAux = 
                        (ArrayList<Crcausaext>)this.getServiceLocator().getClinicoService().getCausaExternaVG(tipoHistoria);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstCausaAux.isEmpty()) {

                lstCausa.add(new SelectItem("", "Seleccione una opcion ..."));
                Iterator it = lstCausaAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstCausa.add(new SelectItem((lstCausaAux.get(i).getCcancodigo()), 
                                                lstCausaAux.get(i).getCcacdescri()));
                    i++;
                }
            }
        }
        return lstCausa;
    }
    
    /**
     * @param lstFinalidades
     */
    public void setLstFinalidades(List<SelectItem> lstFinalidades) {
        this.lstFinalidades = lstFinalidades;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstFinalidades() {
        if (lstFinalidades == null || lstFinalidades.isEmpty()) {
            lstFinalidades = new ArrayList<SelectItem>();
            ArrayList<Crfinalcon> lstFinalidadesAux = null;
            try {
                lstFinalidadesAux = 
                        (ArrayList<Crfinalcon>)this.getServiceLocator().getClinicoService().getFinalidadesConsultaVG(tipoServicio);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstFinalidadesAux.isEmpty()) {

                lstFinalidades.add(new SelectItem("", 
                                                  "Seleccione una opcion ..."));
                Iterator it = lstFinalidadesAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstFinalidades.add(new SelectItem((lstFinalidadesAux.get(i).getId().getCfcncodigo()), 
                                                      lstFinalidadesAux.get(i).getCfccdescri()));
                    i++;
                }
            }
        }
        return lstFinalidades;
    }


    /**
     * @param enfermedadOpcional
     */
    public void setEnfermedadOpcional(boolean enfermedadOpcional) {
        this.enfermedadOpcional = enfermedadOpcional;
    }

    /**
     * @return
     */
    public boolean isEnfermedadOpcional() {
        return enfermedadOpcional;
    }

    /**
     * @param motivo
     */
    public void setMotivo(Chmotivocon motivo) {
        this.motivo = motivo;
    }

    /**
     * @return
     */
    public Chmotivocon getMotivo() {
        return motivo;
    }

    /**
     * @param numeroConsulta
     */
    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    /**
     * @return
     */
    public Long getNumeroConsulta() {
        return numeroConsulta;
    }


    /**
     * @param impresion
     */
    public void setImpresion(Chimprdiag impresion) {
        this.impresion = impresion;
    }

    /**
     * @return
     */
    public Chimprdiag getImpresion() {
        return impresion;
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
     * @param selectedIndex
     */
    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    /**
     * @return
     */
    public int getSelectedIndex() {
        return selectedIndex;
    }

    /**
     * @param inputDiagPrincipal
     */
    public void setInputDiagPrincipal(UIInput inputDiagPrincipal) {
        this.inputDiagPrincipal = inputDiagPrincipal;
    }

    /**
     * @return
     */
    public UIInput getInputDiagPrincipal() {
        return inputDiagPrincipal;
    }

    /**
     * @param inputDiagRelacionado1
     */
    public void setInputDiagRelacionado1(UIInput inputDiagRelacionado1) {
        this.inputDiagRelacionado1 = inputDiagRelacionado1;
    }

    /**
     * @return
     */
    public UIInput getInputDiagRelacionado1() {
        return inputDiagRelacionado1;
    }

    /**
     * @param inputDiagRelacionado2
     */
    public void setInputDiagRelacionado2(UIInput inputDiagRelacionado2) {
        this.inputDiagRelacionado2 = inputDiagRelacionado2;
    }

    /**
     * @return
     */
    public UIInput getInputDiagRelacionado2() {
        return inputDiagRelacionado2;
    }

    /**
     * @param inputDiagRelacionado3
     */
    public void setInputDiagRelacionado3(UIInput inputDiagRelacionado3) {
        this.inputDiagRelacionado3 = inputDiagRelacionado3;
    }

    /**
     * @return
     */
    public UIInput getInputDiagRelacionado3() {
        return inputDiagRelacionado3;
    }

    /**
     * @param diagnosticoPrincipal
     */
    public void setDiagnosticoPrincipal(String diagnosticoPrincipal) {
        this.diagnosticoPrincipal = diagnosticoPrincipal;
    }

    /**
     * @return
     */
    public String getDiagnosticoPrincipal() {
        return diagnosticoPrincipal;
    }

    /**
     * @param diagnosticoRelacionado1
     */
    public void setDiagnosticoRelacionado1(String diagnosticoRelacionado1) {
        this.diagnosticoRelacionado1 = diagnosticoRelacionado1;
    }

    /**
     * @return
     */
    public String getDiagnosticoRelacionado1() {
        return diagnosticoRelacionado1;
    }

    /**
     * @param diagnosticoRelacionado2
     */
    public void setDiagnosticoRelacionado2(String diagnosticoRelacionado2) {
        this.diagnosticoRelacionado2 = diagnosticoRelacionado2;
    }

    /**
     * @return
     */
    public String getDiagnosticoRelacionado2() {
        return diagnosticoRelacionado2;
    }

    /**
     * @param diagnosticoRelacionado3
     */
    public void setDiagnosticoRelacionado3(String diagnosticoRelacionado3) {
        this.diagnosticoRelacionado3 = diagnosticoRelacionado3;
    }

    /**
     * @return
     */
    public String getDiagnosticoRelacionado3() {
        return diagnosticoRelacionado3;
    }

    /**
     * @param lstTipoImpresion
     */
    public void setLstTipoImpresion(List lstTipoImpresion) {
        this.lstTipoImpresion = lstTipoImpresion;
    }

    /**
     * @return
     */
    public List getLstTipoImpresion() {
        if (lstTipoImpresion == null || lstTipoImpresion.isEmpty()) {
            lstTipoImpresion = new ArrayList();
            ArrayList<Chtipodiagno> lstTipoImpresionAux = null;
            try {
                lstTipoImpresionAux = 
                        (ArrayList<Chtipodiagno>)this.serviceLocator.getClinicoService().getTiposDiagnosticos();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstTipoImpresionAux.isEmpty()) {
                lstTipoImpresion.add(new SelectItem("", 
                                                    "Seleccione una opcion..."));
                Iterator it = lstTipoImpresionAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstTipoImpresion.add(new SelectItem(lstTipoImpresionAux.get(i).getHtdccodigo(), 
                                                        lstTipoImpresionAux.get(i).getHtdcdescripcio()));

                    i++;
                }
            }
        }
        return lstTipoImpresion;
    }


    //-----------------------------------------------------------------------
    //  Metodo esValido
    //-----------------------------------------------------------------------

    /**
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        /** Almacena el motivo de consulta el cual se va a persistir*/
        Chcontrolcon controlAux = null;
        if (numeroConsulta != null) {
            try {
                controlAux = 
                        this.getServiceLocator().getClinicoService().getControlConsulta(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (controlAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }
    
    

        //-----------------------------------------------------------------------
        //  AJAX
        //-----------------------------------------------------------------------
    
    
    
    
    public void mostrarDiagnosticoPrincipal() {
        Cie10Bean cie10;
        if (impresion != null) {
            impresion.setHidcdiagprin("");
        }

        cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");
        cie10.setDiagnosticoPrincipal(true);
        cie10.setDiagnosticoRelacionado1(false);
        cie10.setDiagnosticoRelacionado2(false);
        cie10.setDiagnosticoRelacionado3(false);
        mostrarCie10 = true;
        selectedIndex = ACTIVAR_BUSCADOR;
    }

    public void mostrarDiagnosticoRelacionado1() {
        Cie10Bean cie10;
        if (impresion != null) {
            impresion.setHidcdiagrela1("");
        }
        cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");
        cie10.setDiagnosticoPrincipal(false);
        cie10.setDiagnosticoRelacionado1(true);
        cie10.setDiagnosticoRelacionado2(false);
        cie10.setDiagnosticoRelacionado3(false);
        mostrarCie10 = true;
        selectedIndex = ACTIVAR_BUSCADOR;
    }

    public void mostrarDiagnosticoRelacionado2() {
        Cie10Bean cie10;
        if (impresion != null) {
            impresion.setHidcdiagrela2("");
        }

        cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");
        cie10.setDiagnosticoPrincipal(false);
        cie10.setDiagnosticoRelacionado1(false);
        cie10.setDiagnosticoRelacionado2(true);
        cie10.setDiagnosticoRelacionado3(false);
        selectedIndex = ACTIVAR_BUSCADOR;
        mostrarCie10 = true;
    }

    public void mostrarDiagnosticoRelacionado3() {
        Cie10Bean cie10;
        if (impresion != null) {
            impresion.setHidcdiagrela3("");
        }

        cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");
        cie10.setDiagnosticoPrincipal(false);
        cie10.setDiagnosticoRelacionado1(false);
        cie10.setDiagnosticoRelacionado2(false);
        cie10.setDiagnosticoRelacionado3(true);
        selectedIndex = ACTIVAR_BUSCADOR;
        mostrarCie10 = true;
    }


    public void aceptarDiagnostico() {

        Cie10Bean cie10;
        cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");

        if (cie10 != null && cie10.getCie10Select() != null) {

            if (cie10.isDiagnosticoPrincipal()) {
                impresion.setHidcdiagprin(cie10.getCie10Select().getCdcccodigo());
                inputDiagPrincipal.setValue(cie10.getCie10Select().getCdcccodigo());
                diagnosticoPrincipal = cie10.getCie10Select().getCdccdescri();
            }

            if (cie10.isDiagnosticoRelacionado1()) {
                impresion.setHidcdiagrela1(cie10.getCie10Select().getCdcccodigo());
                inputDiagRelacionado1.setValue(cie10.getCie10Select().getCdcccodigo());
                diagnosticoRelacionado1 = 
                        cie10.getCie10Select().getCdccdescri();
            }

            if (cie10.isDiagnosticoRelacionado2()) {
                impresion.setHidcdiagrela2(cie10.getCie10Select().getCdcccodigo());
                inputDiagRelacionado2.setValue(cie10.getCie10Select().getCdcccodigo());
                diagnosticoRelacionado2 = 
                        cie10.getCie10Select().getCdccdescri();
            }

            if (cie10.isDiagnosticoRelacionado3()) {
                impresion.setHidcdiagrela3(cie10.getCie10Select().getCdcccodigo());
                inputDiagRelacionado3.setValue(cie10.getCie10Select().getCdcccodigo());
                diagnosticoRelacionado3 = 
                        cie10.getCie10Select().getCdccdescri();
            }
        } else {

            if (cie10 != null && cie10.isDiagnosticoPrincipal())
                diagnosticoPrincipal = null;

            if (cie10 != null && cie10.isDiagnosticoRelacionado1())
                diagnosticoRelacionado1 = null;

            if (cie10 != null && cie10.isDiagnosticoRelacionado2())
                diagnosticoRelacionado2 = null;

            if (cie10 != null && cie10.isDiagnosticoRelacionado3())
                diagnosticoRelacionado3 = null;

        }

        mostrarCie10 = false;
        selectedIndex = ACTIVAR_IMPRESION_DIAGNOSTICA;
        cie10.clear();

    }


    public void changeDiagnosticoPrincipal() {

        List validacionPrincipal1 = null;
        diagnosticoPrincipal = null;


        if (impresion != null) {
            if (impresion.getHidcdiagprin() != null && 
                !impresion.getHidcdiagprin().equals("")) {
                try {
                    diagprin = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagprin().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagprin != null && diagprin.getCdcccodigo() != null) {
                    diagnosticoPrincipal = diagprin.getCdccdescri();
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

                if (diagnosticoPrincipal == null || 
                    diagnosticoPrincipal.equals("")) {
                    FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_PRINCIPAL_NO_VALIDO);
                }
            } else {
                diagnosticoPrincipal = "";
            }
        }
    }


    public void changeDiagnosticoRelacionado1() {

        diagnosticoRelacionado1 = null;
        List validacionRelacionado1 = null;

        if (impresion.getHidcdiagrela1() != null && 
            !impresion.getHidcdiagrela1().equals("")) {
            try {
                diagrela1 = 
                        this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagrela1().toUpperCase());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (diagrela1 != null && diagrela1.getCdcccodigo() != null) {
                diagnosticoRelacionado1 = diagrela1.getCdccdescri();

                validacionRelacionado1 = 
                        this.serviceLocator.getClinicoService().getVerificacionCie10(diagrela1, 
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

            if (diagnosticoRelacionado1 == null || 
                diagnosticoRelacionado1.equals("")) {
                FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_RELACIONADO1_NO_VALIDO);
            }
        } else {
            diagnosticoRelacionado1 = "";
        }
    }

    public void changeDiagnosticoRelacionado2() {

        diagnosticoRelacionado2 = "";
        List validacionRelacionado2 = null;

        if (impresion.getHidcdiagrela2() != null && 
            !impresion.getHidcdiagrela2().equals("")) {
            try {
                diagrela2 = 
                        this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagrela2().toUpperCase());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (diagrela2 != null && diagrela2.getCdcccodigo() != null) {
                diagnosticoRelacionado2 = diagrela2.getCdccdescri();
                validacionRelacionado2 = 
                        this.serviceLocator.getClinicoService().getVerificacionCie10(diagrela2, 
                                                                                     usuario.getHusesexo(), 
                                                                                     "1", 
                                                                                     edad, 
                                                                                     "N");

                if (validacionRelacionado2 != null && 
                    !validacionRelacionado2.isEmpty()) {
                    if (validacionRelacionado2.get(1) != null) {
                        FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_RELACIONADO2 + 
                                                   validacionRelacionado2.get(1));
                    }
                }
            }

            if (diagnosticoRelacionado2 == null || 
                diagnosticoRelacionado2.equals("")) {
                FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_RELACIONADO2_NO_VALIDO);
            }
        } else {
            diagnosticoRelacionado2 = "";
        }
    }


    public void changeDiagnosticoRelacionado3() {

        diagnosticoRelacionado3 = null;
        List validacionRelacionado3 = null;

        if (impresion.getHidcdiagrela3() != null && 
            !impresion.getHidcdiagrela3().equals("")) {
            try {
                diagrela3 = 
                        this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagrela3().toUpperCase());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (diagrela3 != null && diagrela3.getCdcccodigo() != null) {
                diagnosticoRelacionado3 = diagrela3.getCdccdescri();
                validacionRelacionado3 = 
                        this.serviceLocator.getClinicoService().getVerificacionCie10(diagrela3, 
                                                                                     usuario.getHusesexo(), 
                                                                                     "1", 
                                                                                     edad, 
                                                                                     "N");

                if (validacionRelacionado3 != null && 
                    !validacionRelacionado3.isEmpty()) {
                    if (validacionRelacionado3.get(1) != null) {
                        FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_RELACIONADO3 + 
                                                   validacionRelacionado3.get(1));
                    }
                }
            }

            if (diagnosticoRelacionado3 == null || 
                diagnosticoRelacionado3.equals("")) {
                FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_RELACIONADO3_NO_VALIDO);
            }
        } else {
            diagnosticoRelacionado3 = "";
        }
    }
    
    
    public void setHidcdiagprin(ValueChangeEvent valueChangeEvent) {
        impresion.setHidcdiagprin((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHidcdiagrela1(ValueChangeEvent valueChangeEvent) {
        impresion.setHidcdiagrela1((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHidcdiagrela2(ValueChangeEvent valueChangeEvent) {
        impresion.setHidcdiagrela2((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHidcdiagrela3(ValueChangeEvent valueChangeEvent) {
        impresion.setHidcdiagrela3((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setHmcctrapatol(ValueChangeEvent valueChangeEvent) {
        motivo.setHmcctrapatol((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setHmcctippatolt(ValueChangeEvent valueChangeEvent) {
        motivo.setHmcctippatol((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
   
    
    public void changeTraePatologia(){
        renderTipoPatologia = false;
        if(("S").equals(motivo.getHmcctrapatol())){
            renderTipoPatologia = true;
        }
        else{
            lstBiopsia = new ArrayList<SelectItem>();
            renderPatologiaCual = false;
            renderDescripcionResultados = false;
            motivo.setHmccdesres(null);
            motivo.setHmccresbiop(null);
            motivo.setHmccrespatol(null);
            motivo.setHmcccualpat(null);
            motivo.setHmcctippatol(null);
            motivo.setHmcctrapatol("N");
        }
    }
    
    public void changePatologia(){
        renderPatologiaCual = false;
        renderDescripcionResultados = false;
        lstBiopsia = new ArrayList<SelectItem>();
       if("OT".equals(motivo.getHmcctippatol())){
            motivo.setHmccresbiop(null);
            renderPatologiaCual = true;
            renderDescripcionResultados = true;
        }
        else if("CX".equals(motivo.getHmcctippatol())){
            motivo.setHmcccualpat(null);
            motivo.setHmccdesres(null);
            lstBiopsia.add(new SelectItem("NN","Negativo para neoplasia"));
            lstBiopsia.add(new SelectItem("DI","Displasia"));
            lstBiopsia.add(new SelectItem("NB","NIC de bajo grado (NIC I)"));
            lstBiopsia.add(new SelectItem("NA","NIC de alto grado: (NIC II - NIC III)"));
            lstBiopsia.add(new SelectItem("NM","Neoplasia micro infiltrante: escamocelular o adenocarcinoma"));
            lstBiopsia.add(new SelectItem("NI","Neoplasia Infiltrante: escamocelular o adenocarcinoma"));
            
        }
        else if("MA".equals(motivo.getHmcctippatol())){
            motivo.setHmcccualpat(null);
            motivo.setHmccdesres(null);
            lstBiopsia.add(new SelectItem("BE","Benigna"));
            lstBiopsia.add(new SelectItem("AT","At�pica (Indeterminada)"));
            lstBiopsia.add(new SelectItem("MS","Malignidad sospechosa/probable"));
            lstBiopsia.add(new SelectItem("MA","Maligna"));
            lstBiopsia.add(new SelectItem("NS","No satisfactoria"));
            
        }
        else{
        if("S".equals(motivo.getHmcctrapatol())){
            renderDescripcionResultados = true;
            motivo.setHmcccualpat(null);
        }
           
        }
    }




   

    //-----------------------------------------------------------------------
    //  BOTON ACEPTAR
    //-----------------------------------------------------------------------


    public String aceptar() {
        ChcontrolconPK idContol = new ChcontrolconPK();
        boolean exito = true; 
        navigationRule = "";
        // Guardamos el Control
        control.setHcccoperador(userName());
        control.setHccdfecregistr(new Date());
        if (numeroConsulta != null) {
            idContol.setHcclconsulta(numeroConsulta);
            idContol.setHccctiposervi(TIPO_CONSULTA);
            control.setId(idContol);
        }
         // Guardamos el motivo de Consulta
        ChmotivoconPK idMotivo = new ChmotivoconPK();
        motivo.setHmccoperador(userName());
        motivo.setHmcdfecregistr(new Date());
        

                if (numeroConsulta != null) {
                    idMotivo.setHmclconsulta(numeroConsulta);
                    idMotivo.setHmcctiposervi(tipoServicio);
                    motivo.setId(idMotivo);
                }
        
        // Guardamos la Impresi�n Diagnostica
        
         diagnosticoPrincipal = "";
         diagnosticoRelacionado1 = "";
         diagnosticoRelacionado2 = "";
         diagnosticoRelacionado3 = "";
         List validacionPrincipal1 = null;
         List validacionRelacionado1 = null;
         List validacionRelacionado2 = null;
         List validacionRelacionado3 = null;

         ChimprdiagPK idImpresion = new ChimprdiagPK();
         exito = true;

         if (impresion == null || impresion.getHidcdiagprin() == null || 
             impresion.getHidcdiagprin().equals("")) {
             FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:itDiagPrinConsultaControl", 
                                        "El campo es obligatorio");
             exito = false;
         }
         
        if (motivo == null || motivo.getHmcncausaexte() == null) {
            FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:menuMotivoConsultaControl", 
                                       "El campo es obligatorio");
            exito = false;
        }
        
        if (motivo == null || motivo.getHmcnfinalidad() == null) {
            FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:menuFinalidadControl", 
                                       "El campo es obligatorio");
            exito = false;
        }
        
        
        if (impresion == null || impresion.getHidntipodiagn() == null) {
            FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:tipoDiagnosticoConsultaControl", 
                                       "El campo es obligatorio");
            exito = false;
        }
        
        if(controlrender){
        if (control == null || control.getHcccdescripcio() == null || 
             control.getHcccdescripcio().equals("")) {
            FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:textNotaConsultaControl", 
                                       "El campo es obligatorio");
            exito = false;
        }
        }

         if (numeroConsulta != null && tipoServicio != null && consecutivo!= null) {
             idImpresion.setHidlconsulta(numeroConsulta);
             idImpresion.setHidctiposervi(tipoServicio);
             idImpresion.setHidnconsecutiv(consecutivo);
             impresion.setId(idImpresion);
         }

         edad = calcularEdad(usuario.getHusdfechanacim(), new Date());
         impresion.setHidcoperador(userName());
         impresion.setHiddfecregistr(new Date());

         if (impresion != null) {
             if (impresion.getHidcdiagprin() != null && 
                 !impresion.getHidcdiagprin().equals("")) {
                 try {
                     diagprin = 
                             this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagprin().toUpperCase());
                 } catch (ModelException e) {
                     e.printStackTrace();
                 }

                 if (diagprin != null) {
                     validacionPrincipal1 = 
                             this.serviceLocator.getClinicoService().getVerificacionCie10(diagprin, 
                                                                                          usuario.getHusesexo(), 
                                                                                          "1", 
                                                                                          edad, 
                                                                                          "S");
                     if (exito) {
                         if (validacionPrincipal1 != null && 
                             !validacionPrincipal1.isEmpty()) {
                             exito = (Boolean)validacionPrincipal1.get(0);
                             if (validacionPrincipal1.get(1) != null) {
                                 FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_PRINCIPAL + 
                                                            validacionPrincipal1.get(1));
                             }

                         }
                     }
                 }


                 if (diagprin != null && diagprin.getCdcccodigo() != null) {
                     diagnosticoPrincipal = diagprin.getCdccdescri();
                 }

                 if (diagnosticoPrincipal == null || 
                     diagnosticoPrincipal.equals("")) {
                     exito = false;
                     FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_PRINCIPAL_NO_VALIDO);
                 }
             }


             if (impresion.getHidcdiagrela1() != null && 
                 !impresion.getHidcdiagrela1().equals("")) {
                 try {
                     diagrela1 = 
                             this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagrela1().toUpperCase());
                 } catch (ModelException e) {
                     e.printStackTrace();
                 }

                 if (diagrela1 != null) {
                     validacionRelacionado1 = 
                             this.serviceLocator.getClinicoService().getVerificacionCie10(diagrela1, 
                                                                                          usuario.getHusesexo(), 
                                                                                          "1", 
                                                                                          edad, 
                                                                                          "N");
                     if (exito) {
                         if (validacionRelacionado1 != null && 
                             !validacionRelacionado1.isEmpty()) {
                             exito = (Boolean)validacionRelacionado1.get(0);
                             if (validacionRelacionado1.get(1) != null) {
                                 FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_RELACIONADO1 + 
                                                            validacionRelacionado1.get(1));
                             }

                         }
                     }
                 }

                 if (diagrela1 != null && diagrela1.getCdcccodigo() != null) {
                     diagnosticoRelacionado1 = diagrela1.getCdccdescri();
                 }

                 if (diagnosticoRelacionado1 == null || 
                     diagnosticoRelacionado1.equals("")) {
                     exito = false;
                     FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_RELACIONADO1_NO_VALIDO);
                 }
             }


             if (impresion.getHidcdiagrela2() != null && 
                 !impresion.getHidcdiagrela2().equals("")) {
                 try {
                     diagrela2 = 
                             this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagrela2().toUpperCase());
                 } catch (ModelException e) {
                     e.printStackTrace();
                 }

                 if (diagrela2 != null) {
                     validacionRelacionado2 = 
                             this.serviceLocator.getClinicoService().getVerificacionCie10(diagrela2, 
                                                                                          usuario.getHusesexo(), 
                                                                                          "1", 
                                                                                          edad, 
                                                                                          "N");
                     if (exito) {
                         if (validacionRelacionado2 != null && 
                             !validacionRelacionado2.isEmpty()) {
                             exito = (Boolean)validacionRelacionado2.get(0);
                             if (validacionRelacionado2.get(1) != null) {
                                 FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_RELACIONADO2 + 
                                                            validacionRelacionado2.get(1));
                             }
                         }
                     }
                 }

                 if (diagrela2 != null && diagrela2.getCdcccodigo() != null) {
                     diagnosticoRelacionado2 = diagrela2.getCdccdescri();
                 }

                 if (diagnosticoRelacionado2 == null || 
                     diagnosticoRelacionado2.equals("")) {
                     exito = false;
                     FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_RELACIONADO2_NO_VALIDO);
                 }
             }

             if (impresion.getHidcdiagrela3() != null && 
                 !impresion.getHidcdiagrela3().equals("")) {
                 try {
                     diagrela3 = 
                             this.serviceLocator.getClinicoService().getCIE10PorCodigo(impresion.getHidcdiagrela3().toUpperCase());
                 } catch (ModelException e) {
                     e.printStackTrace();
                 }

                 if (diagrela3 != null) {
                     validacionRelacionado3 = 
                             this.serviceLocator.getClinicoService().getVerificacionCie10(diagrela3, 
                                                                                          usuario.getHusesexo(), 
                                                                                          "1", 
                                                                                          edad, 
                                                                                          "N");
                     if (exito) {
                         if (validacionRelacionado3 != null && 
                             !validacionRelacionado3.isEmpty()) {
                             exito = (Boolean)validacionRelacionado3.get(0);
                             if (validacionRelacionado3.get(1) != null) {
                                 FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_RELACIONADO3 + 
                                                            validacionRelacionado3.get(1));
                             }

                         }
                     }
                 }

                 if (diagrela3 != null && diagrela3.getCdcccodigo() != null) {
                     diagnosticoRelacionado3 = diagrela3.getCdccdescri();
                 }

                 if (diagnosticoRelacionado3 == null || 
                     diagnosticoRelacionado3.equals("")) {
                     exito = false;
                     FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_RELACIONADO3_NO_VALIDO);
                 }
             }
         }


       if(exito){
        try {
            this.serviceLocator.getClinicoService().saveControlConsultaCompleta(control,impresion,motivo);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            FacesUtils.resetManagedBean(menuBean);
            navigationRule = nextAction;

        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            e.printStackTrace();
            navigationRule = null;
        }
       }else{
           navigationRule = ""; 
       }
        return navigationRule;

    }


    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setCodigoDiagnostico(String codigoDiagnostico) {
        this.codigoDiagnostico = codigoDiagnostico;
    }

    public String getCodigoDiagnostico() {
        return codigoDiagnostico;
    }

    public void setCodigoRelacionado1(String codigoRelacionado1) {
        this.codigoRelacionado1 = codigoRelacionado1;
    }

    public String getCodigoRelacionado1() {
        return codigoRelacionado1;
    }

    public void setCodigoRelacionado2(String codigoRelacionado2) {
        this.codigoRelacionado2 = codigoRelacionado2;
    }

    public String getCodigoRelacionado2() {
        return codigoRelacionado2;
    }

    public void setCodigoRelacionado3(String codigoRelacionado3) {
        this.codigoRelacionado3 = codigoRelacionado3;
    }

    public String getCodigoRelacionado3() {
        return codigoRelacionado3;
    }

    public void setRequiredRel1(boolean requiredRel1) {
        this.requiredRel1 = requiredRel1;
    }

    public boolean isRequiredRel1() {
        return requiredRel1;
    }

    public void setRequiredRel2(boolean requiredRel2) {
        this.requiredRel2 = requiredRel2;
    }

    public boolean isRequiredRel2() {
        return requiredRel2;
    }

    public void setRequiredRel3(boolean requiredRel3) {
        this.requiredRel3 = requiredRel3;
    }

    public boolean isRequiredRel3() {
        return requiredRel3;
    }

    public void setDisableRel1(boolean disableRel1) {
        this.disableRel1 = disableRel1;
    }

    public boolean isDisableRel1() {
        return disableRel1;
    }

    public void setDisableRel2(boolean disableRel2) {
        this.disableRel2 = disableRel2;
    }

    public boolean isDisableRel2() {
        return disableRel2;
    }

    public void setDisableRel3(boolean disableRel3) {
        this.disableRel3 = disableRel3;
    }

    public boolean isDisableRel3() {
        return disableRel3;
    }

    public void setControlrender(boolean controlrender) {
        this.controlrender = controlrender;
    }

    public boolean isControlrender() {
        return controlrender;
    }

    public void setLstPatologias(List<SelectItem> lstPatologias) {
        this.lstPatologias = lstPatologias;
    }

    public List<SelectItem> getLstPatologias() {
        return lstPatologias;
    }
    public void setLstOpciones(List<SelectItem> lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    public List getLstOpciones() {

        if (lstOpciones == null || lstOpciones.isEmpty()) {
            lstOpciones = new ArrayList<SelectItem>();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
    }

    public void setLstResPatols(List<SelectItem> lstResPatols) {
        this.lstResPatols = lstResPatols;
    }

    public List<SelectItem> getLstResPatols() {
        if(lstResPatols == null || lstResPatols.isEmpty()){
            lstResPatols = new ArrayList<SelectItem>();
            lstResPatols.add(new SelectItem("P","Maligno"));
            lstResPatols.add(new SelectItem("N","Benigno"));
        }
        return lstResPatols;
    }

    public void setLstBiopsia(List<SelectItem> lstBiopsia) {
        this.lstBiopsia = lstBiopsia;
    }

    public List<SelectItem> getLstBiopsia() {
        return lstBiopsia;
    }

    public void setRenderTipoPatologia(boolean renderTipoPatologia) {
        this.renderTipoPatologia = renderTipoPatologia;
    }

    public boolean isRenderTipoPatologia() {
        return renderTipoPatologia;
    }

    public void setRenderPatologiaCual(boolean renderPatologiaCual) {
        this.renderPatologiaCual = renderPatologiaCual;
    }

    public boolean isRenderPatologiaCual() {
        return renderPatologiaCual;
    }

    public void setRenderDescripcionResultados(boolean renderDescripcionResultados) {
        this.renderDescripcionResultados = renderDescripcionResultados;
    }

    public boolean isRenderDescripcionResultados() {
        return renderDescripcionResultados;
    }

    public void setRendeGineco(boolean rendeGineco) {
        this.rendeGineco = rendeGineco;
    }

    public boolean isRendeGineco() {
        return rendeGineco;
    }

    public void setRenderResultado(boolean renderResultado) {
        this.renderResultado = renderResultado;
    }

    public boolean isRenderResultado() {
        return renderResultado;
    }

    public void setLstClasificacionHistol(List<SelectItem> lstClasificacionHistol) {
        this.lstClasificacionHistol = lstClasificacionHistol;
    }

    public List<SelectItem> getLstClasificacionHistol() {
        if(lstClasificacionHistol == null || lstClasificacionHistol.isEmpty()){
            lstClasificacionHistol = new ArrayList<SelectItem>();
            lstClasificacionHistol.add(new SelectItem(0,"Seleccione..."));
            lstClasificacionHistol.add(new SelectItem(1,"1= Adenocarcinoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(2,"2= Carcinoma escamocelular (epidermoide), con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(3,"3= Carcinoma de c�lulas basales (basocelular)"));
            lstClasificacionHistol.add(new SelectItem(4,"4=Carcinoma, con o sin otra especificaci�n diferentes a las anteriores"));
            lstClasificacionHistol.add(new SelectItem(5,"5= Oligodendroglioma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(6,"6= Astrocitoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(7,"7= Ependimoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(8,"8= Neuroblastoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(9,"9= Meduloblastoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(10,"10= Hepatoblastoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(11,"11= Rabdomiosarcoma, con o sin otra especificaci�"));
            lstClasificacionHistol.add(new SelectItem(12,"12= Leiomiosarcoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(12,"13= Osteosarcoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(14,"14= Fibrosarcoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(15,"15= Angiosarcoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(16,"16= Condrosarcoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(17,"17= Otros sarcomas, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(18,"18= Pancreatoblastoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(19,"19= Blastoma pleuropulmonar, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(20,"20= Otros tipos histol�gicos no mencionados"));
            lstClasificacionHistol.add(new SelectItem(21,"23= Melanoma"));
            lstClasificacionHistol.add(new SelectItem(22,"24= Carcinoma papilar de tiroides"));
        }
        return lstClasificacionHistol;
    }

    public void setLstGradoTumor(List<SelectItem> lstGradoTumor) {
        this.lstGradoTumor = lstGradoTumor;
    }

    public List<SelectItem> getLstGradoTumor() {
        if(lstGradoTumor == null || lstGradoTumor.isEmpty()){
            lstGradoTumor = new ArrayList<SelectItem>();
            lstGradoTumor.add(new SelectItem(0,"Seleccione.."));
            lstGradoTumor.add(new SelectItem(1,"1= Bien diferenciado (grado1-GRADO BAJO)"));
            lstGradoTumor.add(new SelectItem(2,"2= Moderadamente diferenciado (grado 2 GRADO INTERMEDIO)"));
            lstGradoTumor.add(new SelectItem(3,"3= Mal diferenciado (grado 3 GRADO ALTO)"));
            lstGradoTumor.add(new SelectItem(4,"4= Anapl�sico o indiferenciado (grado 4)"));

        }
        return lstGradoTumor;
    }
    
    public void setHmccrespatol(ValueChangeEvent valueChangeEvent) {
        motivo.setHmccrespatol((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void changeResultados() {
        renderResultado = false;
        if (motivo.getHmccrespatol() != null && 
            motivo.getHmccrespatol().equals("P")) {
            renderResultado = true;
        } else {
            renderResultado=false;
            motivo.setHmnclashisto(null);
            motivo.setHmngradtumor(null);
        }
    }
    
   
}
