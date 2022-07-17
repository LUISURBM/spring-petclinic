//=======================================================================
// ARCHIVO ControlUsuarioBean.java
// FECHA CREACI�N: 09/06/2010
// AUTOR: Jos� Andr�s Riano, Carlos Andres Vargas Roa
// Descripci�n: Datos correspondientes a las consultas de control sin costo 
// patologica.
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;

import java.util.Iterator;
import java.util.List;

import java.util.StringTokenizer;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chcontrolcon;
import org.profamilia.hc.model.dto.ChcontrolconPK;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.ChimprdiagPK;
import org.profamilia.hc.model.dto.Chmetodoplan;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.dto.ChmotivoconPK;
import org.profamilia.hc.model.dto.Chtipocontro;
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

public class ControlUsuarioIlveBean extends BaseBean {


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

    /** Almacena la lista de tipos de control  */
    private List<SelectItem> lstTipoControl;

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

    private UIInput mnuDoppler;

    private UIInput selectSangroo;

    private UIInput selectExpulsion;
    
    private UIInput radioInicioAnticon;
    
    private UIInput radioMetodoAnticon;
    
    private UIInput mnuTolerancia;
    
    private UIInput mnuMetodoAntico;

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

    private boolean mostrarFarmacologico;

    private boolean mostrarQuirurgico;

    private boolean mostrarEcografias;

    private boolean mostrarDoppler;

    private boolean mostrarSangro;

    private boolean mostrarAnticoncepcion;
    
    private boolean mostrarMetodo;
    
    private boolean mostrarMetodoAnticoncepcion;
    
    private boolean mostrarAnticoncepcionNo;

    private List lstDiagnosticoPrincipal;

    private List lstDiagnosticoRelacionado1;

    private List lstDiagnosticoRelacionado2;

    private List lstDiagnosticoRelacionado3;
    
    private List lstMetodo;
    

    /** Almacena las complicaciones  */
    private List lstComplicaciones;

    /**Almacena los efectos secundarios */
    private List lstEfectoSecunda;

    /** Lista que almacena la lista escala de dolor */
    private List<SelectItem> listEscala;

    /**Lista de duracion de dolor */
    private List<SelectItem> listDuraDolor;

    /**Variable consultar medico */
    private List<SelectItem> listConsuMedico;

    /** Variable lista Opciones */
    private List<SelectItem> listOpciones;
    
    /** Variable lista tolerancia */
    private List<SelectItem> listTolerancia;


    /** Variable lista doppler */
    private List<SelectItem> lstDoppler;

    /**Variable sangrado */
    private List<SelectItem> listSangrado;

    /** Variable de expulsion */
    private List<SelectItem> listExpulsion;

    /**Variable de expulsi�n se presento transla */
    private List<SelectItem> listTrasla;

    /** Variable para cantidad de sangrado */
    private List<SelectItem> listCantSangra;

    /** Almacena los efectos secundarios seleccionados en la consulta*/
    private List lstEfectoSecundaSelect;

    /** Almacena las complicaciones seleccionadas en la consulta */
    private List lstComplicacionesSelect;
    
    private boolean renderDolor;
    
    private boolean renderObservaciones;
    
    private boolean renderCual;
    
    private boolean renderConfirmaEnbarazo;
    
    private Date FUR;
    
    private double semanaEmbarazo;
    
    private boolean renderConsultaPrevia;
    
    


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ControlUsuarioIlveBean() {

    }

    public void init() {
        renderCual = false;
        renderObservaciones = false;
        lstEfectoSecundaSelect = new ArrayList();
        lstComplicacionesSelect = new ArrayList();
        inicializarControl();
        nextAction = "";
        motivoOpcional = false;
        renderConfirmaEnbarazo = false;
        semanaEmbarazo=0.0;
        renderConsultaPrevia = false;


    }

    public void inicializarControl() {

        renderConfirmaEnbarazo = false;
        semanaEmbarazo=0.0;
        renderConsultaPrevia = false;
        
        if (usuario != null && usuario.getHuslnumero() != null) {

        }

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
            motivo.setHmcnfinalidad(10);


        } else {
            if(motivo.getHmccantiobservac()!=null){
                renderObservaciones = true;
            }
            if(motivo.getHmccanticual()!=null){
                renderCual = true;
            }
            lstEfectoSecundaSelect = new ArrayList();
            if (motivo.getHmccefecsecun() != null) {
                StringTokenizer st = 
                    new StringTokenizer(motivo.getHmccefecsecun(), ",");
                while (st.hasMoreTokens()) {
                    String tipo = st.nextToken();
                    lstEfectoSecundaSelect.add(tipo);
                }

            }

            lstComplicacionesSelect = new ArrayList();
            if (motivo.getHmcccompmulti() != null) {
                StringTokenizer st = 
                    new StringTokenizer(motivo.getHmcccompmulti(), ",");
                while (st.hasMoreTokens()) {
                    String tipo = st.nextToken();
                    lstComplicacionesSelect.add(tipo);

                }
            }

        }
        motivo.setHmcnfinalidad(10);


        try {
            if (numeroConsulta != null) {
                impresion = 
                        this.getServiceLocator().getClinicoService().getImresionDiagnostica(numeroConsulta, 
                                                                                            consecutivo);
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

        if (motivo.getHmcctipocontr() != null && 
            motivo.getHmcctipocontr().equals("IM")) {

            mostrarFarmacologico = false;
            mostrarQuirurgico = true;
        }else  if (motivo.getHmcctipocontr() != null && 
            motivo.getHmcctipocontr().equals("CE")) {
            
            List<Chantegineco> listChantegineco = new ArrayList<Chantegineco>();
            
            try {
                listChantegineco = this.getServiceLocator().getClinicoService().getAntecedentesGinecologicosXUsuario(usuario.getHuslnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listChantegineco.isEmpty()) {
                
                Chantegineco antegineco = listChantegineco.get(0);
                
                if (antegineco != null && 
                    antegineco.getHagdfur() != null) {
                    FUR = antegineco.getHagdfur();
                    semanaEmbarazo = 
                            calcularSemanasEmbarazo(antegineco.getHagdfur());
                            
                    renderConsultaPrevia= true;       
                }
            }else{
                renderConsultaPrevia = false;
            }
            renderConfirmaEnbarazo = true;          
        } else if (motivo.getHmcctipocontr() != null && 
                   motivo.getHmcctipocontr().equals("1")) {

            mostrarFarmacologico = false;
            mostrarQuirurgico = false;
          
        } else {

            mostrarFarmacologico = true;
            mostrarQuirurgico = false;
         
        }
        if (motivo.getHmccrepoecogr() != null && 
            motivo.getHmccrepoecogr().equals("S")) {
            mostrarEcografias = true;

        } else {

            mostrarDoppler = false;
        }
        
        if (motivo.getHmccdopplerva() != null && 
            motivo.getHmccdopplerva().equals("S")) {
            mostrarDoppler = true;

        } else {
            mostrarDoppler = false;
        }
        
        if (motivo.getHmccpresangro() != null && 
            !motivo.getHmccpresangro().equals("S")) {
            mostrarSangro = false;

        } else {
            mostrarSangro = true;

        }
        
        try {
            if (numeroConsulta != null) {
                control = 
                        serviceLocator.getClinicoService().getControlConsulta(numeroConsulta);
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }
        
        if(motivo.getHmccanticonce() != null && motivo.getHmccanticonce().equals("S")){
            mostrarAnticoncepcion = true;
            mostrarAnticoncepcionNo = false;
            mostrarMetodoAnticoncepcion = false;
        }else if(motivo.getHmccanticonce() != null && motivo.getHmccanticonce().equals("N")){
          
            mostrarAnticoncepcionNo = true;
            mostrarAnticoncepcion = false;
         
          
        }

        if (control == null) {
            control = new Chcontrolcon();
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

            
            lstFinalidades.add(new SelectItem(10, "No Aplica"));
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

    public void setHmcctipocontr(ValueChangeEvent valueChangeEvent) {
        motivo.setHmcctipocontr((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHmccdopplerva(ValueChangeEvent valueChangeEvent) {
        motivo.setHmccdopplerva((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setHmccrepoecogr(ValueChangeEvent valueChangeEvent) {
        motivo.setHmccrepoecogr((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setHmccanticonce(ValueChangeEvent valueChangeEvent) {
        motivo.setHmccanticonce((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHmccpresangro(ValueChangeEvent valueChangeEvent) {
        motivo.setHmccpresangro((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHmccpreseexpu(ValueChangeEvent valueChangeEvent) {
        motivo.setHmccpreseexpu((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setHmccmetoantic(ValueChangeEvent valueChangeEvent) {
        motivo.setHmccmetoantic((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setHmccinicimetod(ValueChangeEvent valueChangeEvent) {
        motivo.setHmccinicimetod((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setHmccmetodantn(ValueChangeEvent valueChangeEvent) {
        motivo.setHmccmetodantn((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setHmcctolemetod(ValueChangeEvent valueChangeEvent) {
        motivo.setHmcctolemetod((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
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

        String efectosSelect = "";
        String complicacionesSelect = "";

        if (lstEfectoSecundaSelect != null && 
            !lstEfectoSecundaSelect.isEmpty()) {
            Iterator it = lstEfectoSecundaSelect.iterator();
            int i = 0;
            while (it.hasNext()) {
                it.next();
                if(lstEfectoSecundaSelect.size() > 1 && lstEfectoSecundaSelect.get(i).equals("NI")){
                   FacesUtils.addErrorMessage("Verifique Efectos secundarios selecciono Ninguna dentro de la lista"); 
                    exito = false;
                }
                efectosSelect = 
                        efectosSelect + lstEfectoSecundaSelect.get(i) + ",";
                i++;
            }

            efectosSelect = 
                    efectosSelect.substring(0, efectosSelect.length() - 1);
        }

        if (lstComplicacionesSelect != null && 
            !lstComplicacionesSelect.isEmpty()) {
            Iterator it = lstComplicacionesSelect.iterator();
            int i = 0;
            while (it.hasNext()) {
                it.next();
                if(lstComplicacionesSelect.size() > 1 && lstComplicacionesSelect.get(i).equals("NI")){
                   FacesUtils.addErrorMessage("Verifique en complicaciones selecciono Ninguna dentro de la lista"); 
                    exito = false;
                }
                complicacionesSelect = 
                        complicacionesSelect + lstComplicacionesSelect.get(i) + 
                        ",";
               
                i++;
            }
            complicacionesSelect = 
                    complicacionesSelect.substring(0, complicacionesSelect.length() - 
                                                   1);
        }

        motivo.setHmccoperador(userName());
        motivo.setHmcdfecregistr(new Date());
        motivo.setHmccefecsecun(efectosSelect);
        motivo.setHmcccompmulti(complicacionesSelect);


        if (numeroConsulta != null) {
            idMotivo.setHmclconsulta(numeroConsulta);
            idMotivo.setHmcctiposervi(tipoServicio);
            motivo.setId(idMotivo);
        }

        // Guardamos la Impresi�n Diagnostica
/*
        diagnosticoPrincipal = "";
        diagnosticoRelacionado1 = "";
        diagnosticoRelacionado2 = "";
        diagnosticoRelacionado3 = "";
        List validacionPrincipal1 = null;
        List validacionRelacionado1 = null;
        List validacionRelacionado2 = null;
        List validacionRelacionado3 = null;

        ChimprdiagPK idImpresion = new ChimprdiagPK();
        exito = true;*/

        // validaciones por tipo de control


        if (motivo.getHmcctipocontr().equals("IM")
            ) {

            if (motivo.getHmcncausaexte() == null || 
                motivo.getHmcncausaexte().equals("")) {
                FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:menuMotivoConsultaControl", 
                                           "El campo Causa Externa es Obligatorio");
                exito = false;
            }

            if (motivo.getHmcnfinalidad() == null || 
                motivo.getHmcnfinalidad().equals("")) {
                FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:menuFinalidadControl", 
                                           "El campo Finalidad es Obligatorio");
                exito = false;
            }
            if (motivo.getHmctenferactal() == null || 
                motivo.getHmctenferactal().equals("")) {
                FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:textEnfermedaActualControl", 
                                           "El campo Enfermedad Actual es Obligatorio");
                exito = false;
            }
           if (motivo.getHmcnescadolor() == null || 
                motivo.getHmcnescadolor().equals("")) {
                FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:selectEscalaDolor", 
                                           "El campo Escala de Dolor es Obligatorio");
                exito = false;
            }
            if (motivo.getHmcnduradolor() == null || 
                motivo.getHmcnduradolor().equals("")) {
                FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:menuDuraDolor", 
                                           "El campo Duraci�n del Dolor es Obligatorio");
                exito = false;
            }
            //if (motivo.getHmccconsumedi() == null || 
              //  motivo.getHmccconsumedi().equals("")) {
             //   FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:selectConsuMedico", 
              //                             "El campo Dolor Obliga a consultar medico es Obligatorio");
              //  exito = false;

            //}
           // if (motivo.getHmccpresangro() == null || 
             //   motivo.getHmccpresangro().equals("")) {
             //   FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:selectSangroo", 
                                          // "El campo Sangro es Obligatorio");
             //   exito = false;
           // }
            if (motivo.getHmccpresangro() != null && 
                motivo.getHmccpresangro().equals("S")) {
                if (motivo.getHmcninicisang() == null || 
                    motivo.getHmcninicisang().equals("")) {
                    FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:menuIniSangrado", 
                                               "El campo Inicio de Sangrado es Obligatorio");
                    exito = false;
                }
            }
            

        } else if (motivo.getHmcctipocontr().equals("CE")) { 
        
            if (motivo.getHmcncausaexte() == null || 
                motivo.getHmcncausaexte().equals("")) {
                FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:menuCausaExternaControlConfEmb", 
                                           "El campo Causa Externa es Obligatorio");
                exito = false;
            }

            if (motivo.getHmcnfinalidad() == null || 
                motivo.getHmcnfinalidad().equals("")) {
                FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:menuFinalidadControlConfEmb", 
                                           "El campo Finalidad es Obligatorio");
                exito = false;
            }
            
            
            if (motivo.getHmccobsconemb() == null || 
                motivo.getHmccobsconemb().equals("")) {
                FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:textObservacionesConfEmb", 
                                           "El campo Observaciones es Obligatorio");
                exito = false;
            }
        
        }
        else {
            if (motivo.getHmcncausaexte() == null || 
                motivo.getHmcncausaexte().equals("")) {
                FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:menuMotivoConsultaControl", 
                                           "El campo Causa Externa es Obligatorio");
                exito = false;
            }

            if (motivo.getHmcnfinalidad() == null || 
                motivo.getHmcnfinalidad().equals("")) {
                FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:menuFinalidadControl", 
                                           "El campo Finalidad es Obligatorio");
                exito = false;
            }
            if (motivo.getHmctenferactal() == null || 
                motivo.getHmctenferactal().equals("")) {
                FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:textEnfermedaActualControl", 
                                           "El campo Enfermedad Actual es Obligatorio");
                exito = false;
            }
            if (motivo.getHmccefecsecun() == null || 
                motivo.getHmccefecsecun().equals("")) {
                FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:checkEfectoSecundario", 
                                           "Los campos de Efectos Secundarios son Obligatorios");
                exito = false;

            }
            if (motivo.getHmcnescadolor() == null || 
                motivo.getHmcnescadolor().equals("")) {
                FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:selectEscalaDolor", 
                                           "El campo Escala de Dolor es Obligatorio");
                exito = false;
            }
            if (motivo.getHmcnduradolor() == null || 
                motivo.getHmcnduradolor().equals("")) {
                FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:menuDuraDolor", 
                                           "El campo Duraci�n del Dolor es Obligatorio");
                exito = false;
            }
            //if (motivo.getHmccconsumedi() == null || 
             //   motivo.getHmccconsumedi().equals("")) {
             //   FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:selectConsuMedico ", 
              //                             "El campo Dolor Obliga a consultar medico es Obligatorio");
             //   exito = false;

           // }
          
        
            
           
            if (motivo.getHmcccantisang() == null || 
                motivo.getHmcccantisang().equals("")) {
                FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:menuCantidadSangrado", 
                                           "El campo Cantidad ... es Obligatorio");
                exito = false;

            }
            if (motivo.getHmcndurasangr() == null || 
                motivo.getHmcndurasangr().equals("")) {
                FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:menuDuraDolorDias", 
                                           "El campo Duracion... es Obligatorio");
                exito = false;
            }

        }

        if (motivo == null || motivo.getHmcctipocontr().equals("") || 
            motivo.getHmcctipocontr() == null) {
            FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:menuTipoControl", 
                                       "El campo Tipo de de Control es Obligatorio");
            exito = false;
        }

      /*  if (impresion == null || impresion.getHidcdiagprin() == null || 
            impresion.getHidcdiagprin().equals("")) {
            FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:itDiagPrinConsultaControl", 
                                       "El campo es obligatorio");
            exito = false;
        }

        if (impresion == null || impresion.getHidntipodiagn() == null) {
            FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:tipoDiagnosticoConsultaControl", 
                                       "El campo es obligatorio");
            exito = false;
        }*/
        
        if(!renderConfirmaEnbarazo){
            if(motivo.getHmccrepoecogr() == null || motivo.getHmccrepoecogr().equals("")){
                FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:mnuEcografia",
                                            "El campo Reporta Ecograf�a SI() o NO()");
                                            
                                            exito = false;
            }
        }
        

        if (motivo.getHmccrepoecogr() != null && 
            motivo.getHmccrepoecogr().equals("S")) {

            if (motivo.getHmcngrosendom() == null || 
                motivo.getHmcngrosendom().equals("S")) {
                FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:inputGrosorEndo", 
                                           "El campo Grosor Endometrial es Obligatorio");
                exito = false;
            }

            if (motivo.getHmccdopplerva() == null || 
                motivo.getHmccdopplerva().equals("")) {
                FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:mnuDoppler", 
                                           "El campo Doopler es Obligatorio");
                exito = false;
            }

            if (motivo.getHmccdopplerva() != null && 
                motivo.getHmccdopplerva().equals("S")) {
                if (motivo.getHmccdoppcardn() == null || 
                    motivo.getHmccdoppcardn().equals("")) {
                    FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:selectDooplerCard", 
                                               "El campo Doopler es Obligario");
                    exito = false;
                }
            }
         

        }


      /*  if (numeroConsulta != null && tipoServicio != null && 
            consecutivo != null) {
            idImpresion.setHidlconsulta(numeroConsulta);
            idImpresion.setHidctiposervi(tipoServicio);
            idImpresion.setHidnconsecutiv(consecutivo);
            impresion.setId(idImpresion);
        }*/

        edad = calcularEdad(usuario.getHusdfechanacim(), new Date());
        impresion.setHidcoperador(userName());
        impresion.setHiddfecregistr(new Date());

      /*  if (impresion != null) {
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
        }*/


        if (exito) {
            try {
                this.serviceLocator.getClinicoService().saveControlIlveConsulta(control, 
                                                                                    motivo);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                FacesUtils.resetManagedBean(menuBean);
                navigationRule = nextAction;

            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                e.printStackTrace();
                navigationRule = null;
            }
        } else {
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

    public void setLstDiagnosticoPrincipal(List lstDiagnosticoPrincipal) {
        this.lstDiagnosticoPrincipal = lstDiagnosticoPrincipal;
    }

    public List getLstDiagnosticoPrincipal() {
        if (lstDiagnosticoPrincipal == null || 
            lstDiagnosticoPrincipal.isEmpty()) {
            lstDiagnosticoPrincipal = new ArrayList();
            ArrayList<Crdgncie10> lstDiaPrinAux = null;
            try {
                lstDiaPrinAux = 
                        (ArrayList<Crdgncie10>)this.serviceLocator.getClinicoService().getCie10ControlIlve(DIAGNOSTICO_PRINCIPAL, 
                                                                                                           CONTROL_ILVE_GENERAL);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstDiaPrinAux.isEmpty()) {
                lstDiagnosticoPrincipal.add(new SelectItem("", 
                                                           "Seleccione ..."));
                Iterator it = lstDiaPrinAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstDiagnosticoPrincipal.add(new SelectItem(lstDiaPrinAux.get(i).getCdcccodigo(), 
                                                               (lstDiaPrinAux.get(i).getCdcccodigo() + 
                                                                ' ' + 
                                                                lstDiaPrinAux.get(i).getCdccdescri())));

                    i++;
                }
            }
        }
        return lstDiagnosticoPrincipal;
    }

    public void setLstDiagnosticoRelacionado1(List lstDiagnosticoRelacionado1) {
        this.lstDiagnosticoRelacionado1 = lstDiagnosticoRelacionado1;
    }

    public List getLstDiagnosticoRelacionado1() {
        if (lstDiagnosticoRelacionado1 == null || 
            lstDiagnosticoRelacionado1.isEmpty()) {
            lstDiagnosticoRelacionado1 = new ArrayList();
            ArrayList<Crdgncie10> lstDiaRela1Aux = null;
            try {
                lstDiaRela1Aux = 
                        (ArrayList<Crdgncie10>)this.serviceLocator.getClinicoService().getCie10ControlIlve(DIAGNOSTICO_RELACIONADO1, 
                                                                                                           CONTROL_ILVE_GENERAL);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstDiaRela1Aux.isEmpty()) {
                lstDiagnosticoRelacionado1.add(new SelectItem("", 
                                                              "Seleccione ..."));
                Iterator it = lstDiaRela1Aux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstDiagnosticoRelacionado1.add(new SelectItem(lstDiaRela1Aux.get(i).getCdcccodigo(), 
                                                                  (lstDiaRela1Aux.get(i).getCdcccodigo() + 
                                                                   ' ' + 
                                                                   lstDiaRela1Aux.get(i).getCdccdescri())));

                    i++;
                }
            }
        }
        return lstDiagnosticoRelacionado1;
    }

    public void setLstDiagnosticoRelacionado2(List lstDiagnosticoRelacionado2) {
        this.lstDiagnosticoRelacionado2 = lstDiagnosticoRelacionado2;
    }

    public List getLstDiagnosticoRelacionado2() {
        if (lstDiagnosticoRelacionado2 == null || 
            lstDiagnosticoRelacionado2.isEmpty()) {
            lstDiagnosticoRelacionado2 = new ArrayList();
            ArrayList<Crdgncie10> lstDiaRela2Aux = null;
            try {
                lstDiaRela2Aux = 
                        (ArrayList<Crdgncie10>)this.serviceLocator.getClinicoService().getCie10ControlIlve(DIAGNOSTICO_RELACIONADO2, 
                                                                                                           CONTROL_ILVE_GENERAL);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstDiaRela2Aux.isEmpty()) {
                lstDiagnosticoRelacionado2.add(new SelectItem("", 
                                                              "Seleccione ..."));
                Iterator it = lstDiaRela2Aux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstDiagnosticoRelacionado2.add(new SelectItem(lstDiaRela2Aux.get(i).getCdcccodigo(), 
                                                                  (lstDiaRela2Aux.get(i).getCdcccodigo() + 
                                                                   ' ' + 
                                                                   lstDiaRela2Aux.get(i).getCdccdescri())));

                    i++;
                }
            }
        }
        return lstDiagnosticoRelacionado2;
    }

    public void setLstDiagnosticoRelacionado3(List lstDiagnosticoRelacionado3) {
        this.lstDiagnosticoRelacionado3 = lstDiagnosticoRelacionado3;
    }

    public List getLstDiagnosticoRelacionado3() {
        if (lstDiagnosticoRelacionado3 == null || 
            lstDiagnosticoRelacionado3.isEmpty()) {
            lstDiagnosticoRelacionado3 = new ArrayList();
            ArrayList<Crdgncie10> lstDiaRela3Aux = null;
            try {
                lstDiaRela3Aux = 
                        (ArrayList<Crdgncie10>)this.serviceLocator.getClinicoService().getCie10ControlIlve(DIAGNOSTICO_RELACIONADO3, 
                                                                                                           CONTROL_ILVE_GENERAL);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstDiaRela3Aux.isEmpty()) {
                lstDiagnosticoRelacionado3.add(new SelectItem("", 
                                                              "Seleccione ..."));
                Iterator it = lstDiaRela3Aux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstDiagnosticoRelacionado3.add(new SelectItem(lstDiaRela3Aux.get(i).getCdcccodigo(), 
                                                                  (lstDiaRela3Aux.get(i).getCdcccodigo() + 
                                                                   ' ' + 
                                                                   lstDiaRela3Aux.get(i).getCdccdescri())));

                    i++;
                }
            }
        }
        return lstDiagnosticoRelacionado3;
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

            lstCausa.add(new SelectItem("", "Seleccione una opci�n..."));
            lstCausa.add(new SelectItem(10, "Sospecha de Abuso Sexual"));
            lstCausa.add(new SelectItem(11, "Sospecha de Violencia Sexual"));
            lstCausa.add(new SelectItem(13, "Enfermedad General"));

        }
        return lstCausa;
    }

    public void setLstTipoControl(List<SelectItem> lstTipoControl) {
        this.lstTipoControl = lstTipoControl;
    }

    public List<SelectItem> getLstTipoControl() {
        if (lstTipoControl == null || lstTipoControl.isEmpty()) {
            lstTipoControl = new ArrayList<SelectItem>();
            ArrayList<Chtipocontro> lstTipoControlAux = null;
            try {
                lstTipoControlAux = 
                        (ArrayList<Chtipocontro>)this.getServiceLocator().getClinicoService().getTipoControlIlve();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstTipoControlAux.isEmpty()) {

                lstTipoControl.add(new SelectItem("1", 
                                                  "Seleccione una opci�n..."));
                Iterator it = lstTipoControlAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstTipoControl.add(new SelectItem((lstTipoControlAux.get(i).getCtcecodigo()), 
                                                      lstTipoControlAux.get(i).getCtccdescripcio()));

                    i++;
                }
            }

        }

        return lstTipoControl;
    }

    public void setLstEfectoSecunda(List lstEfectoSecunda) {
        this.lstEfectoSecunda = lstEfectoSecunda;
    }

    public List getLstEfectoSecunda() {

        if (lstEfectoSecunda == null || lstEfectoSecunda.isEmpty()) {
            lstEfectoSecunda = new ArrayList<SelectItem>();
            
            lstEfectoSecunda.add(new SelectItem("NI", "Ninguna"));
            lstEfectoSecunda.add(new SelectItem("NA", "Nauseas"));
            lstEfectoSecunda.add(new SelectItem("ES", "Escalofr�os"));
            lstEfectoSecunda.add(new SelectItem("VO", "V�mito"));
            lstEfectoSecunda.add(new SelectItem("FI", "Fiebre"));
            lstEfectoSecunda.add(new SelectItem("DI", "Diarrea"));
            lstEfectoSecunda.add(new SelectItem("CE", "Cefalea"));
        }

        return lstEfectoSecunda;
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

    public void setListDuraDolor(List<SelectItem> listDuraDolor) {
        this.listDuraDolor = listDuraDolor;
    }

    public List<SelectItem> getListDuraDolor() {

        if (listDuraDolor == null || listDuraDolor.isEmpty()) {
            listDuraDolor = new ArrayList<SelectItem>();
            listDuraDolor.add(new SelectItem("", "Seleccione una opci�n..."));
            listDuraDolor.add(new SelectItem(0, "0"));
            listDuraDolor.add(new SelectItem(1, "1"));
            listDuraDolor.add(new SelectItem(2, "2"));
            listDuraDolor.add(new SelectItem(3, "3"));
            listDuraDolor.add(new SelectItem(4, "4"));
            listDuraDolor.add(new SelectItem(5, "5"));
            listDuraDolor.add(new SelectItem(6, "6"));
            listDuraDolor.add(new SelectItem(7, "7"));
            listDuraDolor.add(new SelectItem(8, "8"));
            listDuraDolor.add(new SelectItem(9, "9"));
            listDuraDolor.add(new SelectItem(10, "10"));
            listDuraDolor.add(new SelectItem(11, "> 10"));


        }

        return listDuraDolor;
    }

    public void setListConsuMedico(List<SelectItem> listConsuMedico) {
        this.listConsuMedico = listConsuMedico;
    }

    public List<SelectItem> getListConsuMedico() {

        if (listConsuMedico == null || listConsuMedico.isEmpty()) {
            listConsuMedico = new ArrayList<SelectItem>();

            listConsuMedico.add(new SelectItem("S", "SI"));
            listConsuMedico.add(new SelectItem("N", "NO"));

        }
        return listConsuMedico;
    }

    public void setListSangrado(List<SelectItem> listSangrado) {
        this.listSangrado = listSangrado;
    }

    public List<SelectItem> getListSangrado() {

        if (listSangrado == null || listSangrado.isEmpty()) {
            listSangrado = new ArrayList<SelectItem>();

            listSangrado.add(new SelectItem("S", "SI"));
            listSangrado.add(new SelectItem("N", "NO"));

        }
        return listSangrado;
    }


    public void setListExpulsion(List<SelectItem> listExpulsion) {
        this.listExpulsion = listExpulsion;
    }

    public List<SelectItem> getListExpulsion() {

        if (listExpulsion == null || listExpulsion.isEmpty()) {
            listExpulsion = new ArrayList<SelectItem>();

            listExpulsion.add(new SelectItem("S", "SI"));
            listExpulsion.add(new SelectItem("N", "NO"));

        }
        return listExpulsion;
    }


    public void setListTrasla(List<SelectItem> listTrasla) {
        this.listTrasla = listTrasla;
    }

    public List<SelectItem> getListTrasla() {

        if (listTrasla == null || listTrasla.isEmpty()) {
            listTrasla = new ArrayList<SelectItem>();
            listTrasla.add(new SelectItem("", "Seleccione una opci�n..."));
            listTrasla.add(new SelectItem("S", "Si"));
            listTrasla.add(new SelectItem("N", "No"));
        }

        return listTrasla;
    }

    public void setListCantSangra(List<SelectItem> listCantSangra) {
        this.listCantSangra = listCantSangra;
    }

    public List<SelectItem> getListCantSangra() {

        if (listCantSangra == null || listCantSangra.isEmpty()) {
            listCantSangra = new ArrayList<SelectItem>();
            listCantSangra.add(new SelectItem("", "Seleccione una opci�n..."));
            listCantSangra.add(new SelectItem("MA", "Mayor"));
            listCantSangra.add(new SelectItem("ME", "Menor"));
            listCantSangra.add(new SelectItem("IG", "Igual"));
        }
        return listCantSangra;
    }

    public void changeFarmacologico() {
        renderConfirmaEnbarazo = false;
        semanaEmbarazo=0.0;
        renderConsultaPrevia = false;
        FUR = null;
        if (motivo.getHmcctipocontr() != null && 
            motivo.getHmcctipocontr().equals("IM")) {

            mostrarFarmacologico = false;
            mostrarQuirurgico = true;
            renderConfirmaEnbarazo = false;
            if (motivo.getHmcctipocontr() != null) {
                this.lstCausa = new ArrayList<SelectItem>();
                motivo.setHmcncausaexte(null);
                lstCausa.add(new SelectItem("", "Seleccione una opci�n..."));
                lstCausa.add(new SelectItem(10, "Sospecha de Abuso Sexual"));
                lstCausa.add(new SelectItem(11, 
                                            "Sospecha de Violencia Sexual"));
                lstCausa.add(new SelectItem(13, "Enfermedad General"));

            }


        }else if (motivo.getHmcctipocontr() != null && 
            motivo.getHmcctipocontr().equals("CE")) {
            
            List<Chantegineco> listChantegineco = new ArrayList<Chantegineco>();
            
            try {
                listChantegineco = this.getServiceLocator().getClinicoService().getAntecedentesGinecologicosXUsuario(usuario.getHuslnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listChantegineco.isEmpty()) {
                
                Chantegineco antegineco = listChantegineco.get(0);
                
                if (antegineco != null && 
                    antegineco.getHagdfur() != null) {
                    FUR = antegineco.getHagdfur();
                    semanaEmbarazo = 
                            calcularSemanasEmbarazo(antegineco.getHagdfur());
                            
                    renderConsultaPrevia= true;       
                }
            }else{
                renderConsultaPrevia = false;
            }
            renderConfirmaEnbarazo = true;
            mostrarFarmacologico = false;
            mostrarQuirurgico = false;
            selectSangroo.setValue(null);
//            selectExpulsion.setValue(null);
            motivo.setHmccpresangro("");
            motivo.setHmccpreseexpu("");
            lstEfectoSecundaSelect.clear();
            motivo.setHmcnduradolor(null);
            motivo.setHmctenferactal(null);
            motivo.setHmccconsumedi(null);
            motivo.setHmccexpultran(null);
            motivo.setHmcnprimexpul(null);
            motivo.setHmcnsangmayor(null);
            motivo.setHmcccantisang(null);
            motivo.setHmcndurasangr(null);
            motivo.setHmccoblimedic(null);
            motivo.setHmcnescadolor(null);
            motivo.setHmccecoobservac(null);
            
            
        } else if (motivo.getHmcctipocontr() != null && 
                   motivo.getHmcctipocontr().equals("1")) {

            mostrarFarmacologico = false;
            mostrarQuirurgico = false;
            renderConfirmaEnbarazo = false;
            selectSangroo.setValue(null);
            selectExpulsion.setValue(null);
            motivo.setHmccpresangro("");
            motivo.setHmccpreseexpu("");
            lstEfectoSecundaSelect.clear();
            motivo.setHmcnduradolor(null);
            motivo.setHmctenferactal(null);
            motivo.setHmccconsumedi(null);
            motivo.setHmccexpultran(null);
            motivo.setHmcnprimexpul(null);
            motivo.setHmcnsangmayor(null);
            motivo.setHmcccantisang(null);
            motivo.setHmcndurasangr(null);
            motivo.setHmccoblimedic(null);
            motivo.setHmcnescadolor(null);
            motivo.setHmccobsconemb(null);
        } else {
            mostrarFarmacologico = true;
            renderConfirmaEnbarazo = false;
            mostrarQuirurgico = false;
            selectSangroo.setValue(null);
//            selectExpulsion.setValue(null);
            motivo.setHmccpresangro("");
            motivo.setHmccpreseexpu("");
            lstEfectoSecundaSelect.clear();
            motivo.setHmcnduradolor(null);
            motivo.setHmctenferactal(null);
            motivo.setHmccconsumedi(null);
            motivo.setHmccexpultran(null);
            motivo.setHmcnprimexpul(null);
            motivo.setHmcnsangmayor(null);
            motivo.setHmcccantisang(null);
            motivo.setHmcndurasangr(null);
            motivo.setHmccoblimedic(null);
            motivo.setHmcnescadolor(null);
            motivo.setHmccobsconemb(null);
            if (motivo.getHmcctipocontr() != null) {
                this.lstCausa = new ArrayList<SelectItem>();
                lstCausa.add(new SelectItem("", "Seleccione una opci�n..."));
                lstCausa.add(new SelectItem(10, "Sospecha de Abuso Sexual"));
                lstCausa.add(new SelectItem(11, 
                                            "Sospecha de Violencia Sexual"));
                lstCausa.add(new SelectItem(13, "Enfermedad General"));
            }
        }

    }

    public void changeEcografia() {
        if (motivo.getHmccrepoecogr() != null && 
            motivo.getHmccrepoecogr().equals("S")) {
            mostrarEcografias = true;

        } else {

            mostrarDoppler = false;
            motivo.setHmcngrosendom(null);
            motivo.setHmccdopplerva(null);
            motivo.setHmccdoppcardn(null);
            lstComplicacionesSelect.clear();
            mnuDoppler.setValue(null);
            mostrarEcografias = false;


        }
    }
    
    public void ChangeMetodo() {

        if (motivo != null && 
            motivo.getHmccmetoantic().equals("0")) {
            mostrarMetodo = true;
        } else {
            motivo.setHmccotrometo(null);
            mostrarMetodo = false;
        }
    }



    public void changeAnticoncepcion() {
       
        if (motivo.getHmccanticonce() != null && 
            motivo.getHmccanticonce().equals("S")) {
            motivo.setHmccinicimetod(null);
            motivo.setHmccmetoantic(null);
            motivo.setHmccmetodantn(null);
            mnuMetodoAntico.setValue(null);
            mostrarAnticoncepcion = true;
        
            radioMetodoAnticon.setValue(null);
            mostrarAnticoncepcionNo = false;
            mostrarMetodoAnticoncepcion = false;

        }else if((motivo.getHmccanticonce() != null && 
            motivo.getHmccanticonce().equals("N"))){
            motivo.setHmccinicimetod(null);
            motivo.setHmccmetoantic(null);
            motivo.setHmcctolemetod(null);
            radioInicioAnticon.setValue(null);
            mnuTolerancia.setValue(null);
          
            mostrarAnticoncepcionNo = true;
            mostrarAnticoncepcion = false;
            mostrarMetodo = false;
            
        
        }
        changeAntiObservac();
        changeAntiCual();
         
    }
    
    public void changeIniciaAnticoncepcion(){
        changeAntiObservac();
        if(motivo.getHmccinicimetod() != null &&
            motivo.getHmccinicimetod().equals("S")){
            mostrarMetodoAnticoncepcion = true;
        }else{
            mnuMetodoAntico.setValue(null);
            motivo.setHmccmetodantn(null);
            mostrarMetodoAnticoncepcion = false;
        }
        changeAntiObservac();
        changeAntiCual();
    }

    /**
     * @param lstMetodo
     */
    public void setLstMetodo(List lstMetodo) {
        this.lstMetodo = lstMetodo;
    }

    /**
     * @return
     */
    public List getLstMetodo() {

        if (lstMetodo == null || lstMetodo.isEmpty()) {
            lstMetodo = new ArrayList();
            ArrayList<Chmetodoplan> lstMetodoAux = null;
            try {
                lstMetodoAux = 
                        (ArrayList<Chmetodoplan>)this.serviceLocator.getClinicoService().getMetodosPlanificacion(SEXO_FEMENINO);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstMetodoAux.isEmpty()) {

                Iterator it = lstMetodoAux.iterator();
                int i = 0;
                lstMetodo.add(new SelectItem("", "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    if(!lstMetodoAux.get(i).getHmpccodigo().equals("9999") && !lstMetodoAux.get(i).getHmpccodigo().equals("890201.7") ){
                        lstMetodo.add(new SelectItem(lstMetodoAux.get(i).getHmpccodigo(), 
                                                     lstMetodoAux.get(i).getHmpcdescripcio()));
                    }
                  
                    i++;
                }
            }
        }

        return lstMetodo;
    }



    public void changeDoppler() {
        if (motivo.getHmccdopplerva() != null && 
            motivo.getHmccdopplerva().equals("S")) {
            mostrarDoppler = true;

        } else {
            mostrarDoppler = false;
            motivo.setHmccdoppcardn(null);
        }
    }

    public void changeSangro() {

        if (motivo.getHmccpresangro() != null && 
            !motivo.getHmccpresangro().equals("S")) {
            mostrarSangro = false;

        } else {
            mostrarSangro = true;

        }

    }
    
    public void changeAntiObservac() {
        renderObservaciones = false;
        if(("N").equals(motivo.getHmccanticonce()) && ("N").equals(motivo.getHmccinicimetod())){
            renderObservaciones = true;
        }
        else{
            motivo.setHmccantiobservac(null);
        }

    }
    
    public void changeAntiCual() {
        renderCual = false;
        if(("0".equals(motivo.getHmccmetodantn()))){
            renderCual = true;
        }
        else{
            motivo.setHmccanticual(null);
        }

    }

    public void setMostrarFarmacologico(boolean mostrarFarmacologico) {
        this.mostrarFarmacologico = mostrarFarmacologico;
    }

    public boolean isMostrarFarmacologico() {
        return mostrarFarmacologico;
    }

    public void setLstEfectoSecundaSelect(List lstEfectoSecundaSelect) {
        this.lstEfectoSecundaSelect = lstEfectoSecundaSelect;
    }

    public List getLstEfectoSecundaSelect() {
        return lstEfectoSecundaSelect;
    }


    public void setMostrarQuirurgico(boolean mostrarQuirurgico) {
        this.mostrarQuirurgico = mostrarQuirurgico;
    }

    public boolean isMostrarQuirurgico() {
        return mostrarQuirurgico;
    }


    public void setListOpciones(List<SelectItem> listOpciones) {
        this.listOpciones = listOpciones;
    }

    public List<SelectItem> getListOpciones() {

        if (listOpciones == null || listOpciones.isEmpty()) {
            listOpciones = new ArrayList<SelectItem>();

            listOpciones.add(new SelectItem("S", "SI"));
            listOpciones.add(new SelectItem("N", "NO"));

        }
        return listOpciones;
    }
    
    
    public void setListTolerancia(List<SelectItem> listTolerancia) {
        this.listTolerancia = listTolerancia;
    }

    public List<SelectItem> getListTolerancia() {

        if (listTolerancia == null || listTolerancia.isEmpty()) {
            listTolerancia = new ArrayList<SelectItem>();
            
            listTolerancia.add(new SelectItem("", "Seleccione una Opci�n..."));
            listTolerancia.add(new SelectItem("B", "Buena"));
            listTolerancia.add(new SelectItem("R", "Regular"));
            listTolerancia.add(new SelectItem("M", "Mala"));

        }
        return listTolerancia;
    }
    

    public void setMostrarEcografias(boolean mostrarEcografias) {
        this.mostrarEcografias = mostrarEcografias;
    }

    public boolean isMostrarEcografias() {
        return mostrarEcografias;
    }

    public void setLstDoppler(List<SelectItem> lstDoppler) {
        this.lstDoppler = lstDoppler;
    }

    public List<SelectItem> getLstDoppler() {
        if (lstDoppler == null || lstDoppler.isEmpty()) {
            lstDoppler = new ArrayList<SelectItem>();

            lstDoppler.add(new SelectItem("PO", "POSITIVO"));
            lstDoppler.add(new SelectItem("NE", "NEGATIVO"));

        }
        return lstDoppler;
    }

    public void setMostrarDoppler(boolean mostrarDoppler) {
        this.mostrarDoppler = mostrarDoppler;
    }

    public boolean isMostrarDoppler() {
        return mostrarDoppler;
    }

    public void setLstComplicaciones(List lstComplicaciones) {
        this.lstComplicaciones = lstComplicaciones;
    }

    public List getLstComplicaciones() {

        if (lstComplicaciones == null || lstComplicaciones.isEmpty()) {
            lstComplicaciones = new ArrayList<SelectItem>();

            lstComplicaciones.add(new SelectItem("NI", "Ninguna"));
            lstComplicaciones.add(new SelectItem("AI", "Aborto Incompleto"));
            lstComplicaciones.add(new SelectItem("AF", "Aborto Fallido"));
            lstComplicaciones.add(new SelectItem("PU", "Perforaci�n Uterina"));
            lstComplicaciones.add(new SelectItem("LC", "Laceraci�n Cervical"));
            lstComplicaciones.add(new SelectItem("HE", "Hemorragia"));
            lstComplicaciones.add(new SelectItem("IN", "Infecci�n"));
        }

        return lstComplicaciones;
    }

    public void setLstComplicacionesSelect(List lstComplicacionesSelect) {
        this.lstComplicacionesSelect = lstComplicacionesSelect;
    }

    public List getLstComplicacionesSelect() {
        return lstComplicacionesSelect;
    }

    public void setMostrarSangro(boolean mostrarSangro) {
        this.mostrarSangro = mostrarSangro;
    }

    public boolean isMostrarSangro() {
        return mostrarSangro;
    }

    public void setMnuDoppler(UIInput mnuDoppler) {
        this.mnuDoppler = mnuDoppler;
    }

    public UIInput getMnuDoppler() {
        return mnuDoppler;
    }

    public void setSelectSangroo(UIInput selectSangroo) {
        this.selectSangroo = selectSangroo;
    }

    public UIInput getSelectSangroo() {
        return selectSangroo;
    }

    public void setSelectExpulsion(UIInput selectExpulsion) {
        this.selectExpulsion = selectExpulsion;
    }

    public UIInput getSelectExpulsion() {
        return selectExpulsion;
    }

    public void setMostrarAnticoncepcion(boolean mostrarAnticoncepcion) {
        this.mostrarAnticoncepcion = mostrarAnticoncepcion;
    }

    public boolean isMostrarAnticoncepcion() {
        return mostrarAnticoncepcion;
    }

    public void setMostrarMetodo(boolean mostrarMetodo) {
        this.mostrarMetodo = mostrarMetodo;
    }

    public boolean isMostrarMetodo() {
        return mostrarMetodo;
    }

    public void setMostrarAnticoncepcionNo(boolean mostrarAnticoncepcionNo) {
        this.mostrarAnticoncepcionNo = mostrarAnticoncepcionNo;
    }

    public boolean isMostrarAnticoncepcionNo() {
        return mostrarAnticoncepcionNo;
    }

    public void setMostrarMetodoAnticoncepcion(boolean mostrarMetodoAnticoncepcion) {
        this.mostrarMetodoAnticoncepcion = mostrarMetodoAnticoncepcion;
    }

    public boolean isMostrarMetodoAnticoncepcion() {
        return mostrarMetodoAnticoncepcion;
    }


    public void setRadioInicioAnticon(UIInput radioInicioAnticon) {
        this.radioInicioAnticon = radioInicioAnticon;
    }

    public UIInput getRadioInicioAnticon() {
        return radioInicioAnticon;
    }

    public void setRadioMetodoAnticon(UIInput radioMetodoAnticon) {
        this.radioMetodoAnticon = radioMetodoAnticon;
    }

    public UIInput getRadioMetodoAnticon() {
        return radioMetodoAnticon;
    }

    public void setMnuTolerancia(UIInput mnuTolerancia) {
        this.mnuTolerancia = mnuTolerancia;
    }

    public UIInput getMnuTolerancia() {
        return mnuTolerancia;
    }

    public void setMnuMetodoAntico(UIInput mnuMetodoAntico) {
        this.mnuMetodoAntico = mnuMetodoAntico;
    }

    public UIInput getMnuMetodoAntico() {
        return mnuMetodoAntico;
    }

    public void setRenderDolor(boolean renderDolor) {
        this.renderDolor = renderDolor;
    }

    public boolean isRenderDolor() {
        return renderDolor;
    }


    public void setRenderObservaciones(boolean renderObservaciones) {
        this.renderObservaciones = renderObservaciones;
    }

    public boolean isRenderObservaciones() {
        return renderObservaciones;
    }

    public void setRenderCual(boolean renderCual) {
        this.renderCual = renderCual;
    }

    public boolean isRenderCual() {
        return renderCual;
    }

    public void setRenderConfirmaEnbarazo(boolean renderConfirmaEnbarazo) {
        this.renderConfirmaEnbarazo = renderConfirmaEnbarazo;
    }

    public boolean isRenderConfirmaEnbarazo() {
        return renderConfirmaEnbarazo;
    }

    public void setFUR(Date fUR) {
        this.FUR = fUR;
    }

    public Date getFUR() {
        return FUR;
    }

    public void setSemanaEmbarazo(double semanaEmbarazo) {
        this.semanaEmbarazo = semanaEmbarazo;
    }

    public double getSemanaEmbarazo() {
        return semanaEmbarazo;
    }

    public void setRenderConsultaPrevia(boolean renderConsultaPrevia) {
        this.renderConsultaPrevia = renderConsultaPrevia;
    }

    public boolean isRenderConsultaPrevia() {
        return renderConsultaPrevia;
    }
}
