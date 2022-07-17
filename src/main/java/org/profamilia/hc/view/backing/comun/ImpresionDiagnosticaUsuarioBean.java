//=======================================================================
// ARCHIVO ImpresionDiagnosticaUsuarioBean.java
// FECHA CREACI�N: 26/05/2010
// AUTOR: Andres Riano
// Descripci�n: Datos correspondientes a la encuesta de violencia.
//=======================================================================

package org.profamilia.hc.view.backing.comun;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.ChimprdiagPK;
import org.profamilia.hc.model.dto.Chtipodiagno;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.dto.Ctacumcosto;
import org.profamilia.hc.model.dto.FichaTecnicaCostosDTO;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.clinico.comun.Cie10Bean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;




//=======================================================================
//  CLASE ImpresionDiagnosticaUsuarioBean
//=======================================================================

public class ImpresionDiagnosticaUsuarioBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    private Chimprdiag impresion;

    private List lstTipoImpresion;

    private Map lstCie10;

    private boolean mostrarCie10;

    public boolean generoDocPDF;

    public int index;

    private Crdgncie10 diagprin;

    private Crdgncie10 diagrela1;

    private Crdgncie10 diagrela2;

    private Crdgncie10 diagrela3;

    private boolean exito;

    private Integer edad;

    private String diagnosticoPrincipal;

    private String diagnosticoRelacionado1;

    private String diagnosticoRelacionado2;

    private String diagnosticoRelacionado3;

    private int selectedIndex;

    static final int ACTIVAR_IMPRESION_DIAGNOSTICA = 0;

    static final int ACTIVAR_BUSCADOR = 1;

    private UIInput mnuTipoDiagnostico;

    private String nextAction;
    
    private String nextAction2;

    private String menuBean;

    private boolean mostrarAsa;

    private String navigationRule;

    private String tipoServicio;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private UIInput inputDiagPrincipal;

    private UIInput inputDiagRelacionado1;

    private UIInput inputDiagRelacionado2;

    private UIInput inputDiagRelacionado3;

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

    private List lstGradoASA;

    private boolean esurgencia;

    private Integer tipoDiagnostico;

    private Long numeroConsulta;
    
    private boolean renderSemanas; 
    
    private List lstOpciones; 
    
    private Double semanaEmbarazo; 
    
    private boolean renderConfirmacion;
    
    private boolean renderHistoriaIlve; 
    
    private boolean desHabilitarDiagnosticoPrincipal; 
    
    private List lstConfirmaPor; 
    
    private Integer consecutivo; 
    
    private boolean renderColposcopia; 
    
    private List<String> lstImpresionSelect; 
    
    private List lstImpresion;

    private boolean renderOtraImpresion; 
    
    private boolean flagCostos;
    
    private List<FichaTecnicaCostosDTO>lstServicios;

    private HtmlDataTable dtServiciosCostos;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ImpresionDiagnosticaUsuarioBean() {
    }

    public void init() {
         inicializarImpresion();
        renderSemanas = false; 
        flagCostos = activarFuncionalidadCostos();
       
    }

    //ACTIONS

    public void inicializarImpresion() {
       
       lstImpresionSelect = new ArrayList<String>();
        
        if (usuario != null && usuario.getHusdfechanacim() != null) {
            edad = calcularEdad(usuario.getHusdfechanacim(), new Date());
        }

        try {
            if (numeroConsulta != null && consecutivo!= null) {
                impresion = 
                        this.getServiceLocator().getClinicoService().getImresionDiagnostica(numeroConsulta, consecutivo);
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

            if (tipoDiagnostico != null) {
                impresion.setHidntipodiagn(tipoDiagnostico);
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

            if (tipoDiagnostico != null) {
                impresion.setHidntipodiagn(tipoDiagnostico);
            }
          
            

        } else {
        
            renderOtraImpresion = false;
            if (lstImpresionSelect != null) {


                if (impresion.getHidcimprenorma() != null &&  impresion.getHidcimprenorma().equals("S")) {
                    lstImpresionSelect.add("NO");
                }

                if (impresion.getHidcimpresuges() != null &&  impresion.getHidcimpresuges().equals("S")) {
                     lstImpresionSelect.add("SV");
                }

                if (impresion.getHidcimpreinfla() != null &&  impresion.getHidcimpreinfla().equals("S")) {
                    lstImpresionSelect.add("IN");
                }

                if (impresion.getHidcimpreleyba() != null &&  impresion.getHidcimpreleyba().equals("S")) {
                     lstImpresionSelect.add("BG");
                }


                if (impresion.getHidcimpreatrof() != null &&  impresion.getHidcimpreatrof().equals("S")) {
                     lstImpresionSelect.add("AT");
                }


                if (impresion.getHidcimpreleyal() != null &&  impresion.getHidcimpreleyal().equals("S")) {
                   lstImpresionSelect.add("AG");
                }

                if (impresion.getHidcimprecarci() != null &&  impresion.getHidcimprecarci().equals("S")) {
                    lstImpresionSelect.add("CI");
                }


                if (impresion.getHidcimpreotro() != null &&  impresion.getHidcimpreotro().equals("S")) {
                    renderOtraImpresion = true;
                    lstImpresionSelect.add("OT");
                }

            }
        
        
      
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
            
            
            if(diagprin != null && diagprin.getCdcccodigo()!= null && diagprin.getCdcccodigo().equals(CODIGO_PRINCIPAL_ABORTO_MEDICO)){
                renderSemanas = true; 
            }
        }
        
        if(impresion != null && renderHistoriaIlve && semanaEmbarazo!= null){
            impresion.setHidnsemanameno(semanaEmbarazo);  
       }
       
        if(renderHistoriaIlve){
            if(impresion != null 
                && impresion.getHidcconfiseman()!= null && impresion.getHidcconfiseman().equals("N")){
                 renderConfirmacion = true; 
            }else{
                renderConfirmacion = false; 
            }
            
            if(impresion != null && impresion.getHidcdiagprin()!= null && !impresion.getHidcdiagprin().equals(CODIGO_PRINCIPAL_ABORTO_MEDICO)){
                renderConfirmacion = false; 
                renderSemanas = false; 
            }
        }
        if(flagCostos){
            try {
            if(numeroConsulta!=null){
                Cnconsclin consultaAux = serviceLocator.getClinicoService().getConsultaClinicaPorId(numeroConsulta.toString());
                if(consultaAux!=null && consultaAux.getCcocservic()!=null){
                    lstServicios = serviceLocator.getCostosService().getServiciosByInsumo(consultaAux.getCcocservic().getCsvccodigo());
                }          
            }
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(e.getMessage());
            }
        }

    }

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
        renderSemanas = false; 


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
                
                    if(diagprin != null && diagprin.getCdcccodigo()!= null && diagprin.getCdcccodigo().equals(CODIGO_PRINCIPAL_ABORTO_MEDICO)){
                        renderSemanas = true; 
                    }
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
    
    
    public void changeConfirmacion(){
        if(impresion != null 
            && impresion.getHidcconfiseman()!= null && impresion.getHidcconfiseman().equals("N")){
             renderConfirmacion = true; 
        }else{
            renderConfirmacion = false; 
        }
    }

    public boolean esValido() {
        boolean esValido = false;
        Chimprdiag impresionAux = null;
        if (numeroConsulta != null) {

            try {
                impresionAux = 
                        this.getServiceLocator().getClinicoService().getImresionDiagnostica(numeroConsulta, consecutivo);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (impresionAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }


    public String guardarImpresion() {

        navigationRule = "";

        diagnosticoPrincipal = "";
        diagnosticoRelacionado1 = "";
        diagnosticoRelacionado2 = "";
        diagnosticoRelacionado3 = "";
        List validacionPrincipal1 = null;
        List validacionRelacionado1 = null;
        List validacionRelacionado2 = null;
        List validacionRelacionado3 = null;
        impresion.setHidcimprenorma(null);
        impresion.setHidcimpresuges(null);
        impresion.setHidcimpreinfla(null);
        impresion.setHidcimpreleyba(null);
        impresion.setHidcimpreatrof(null);
        impresion.setHidcimpreleyal(null);
        impresion.setHidcimprecarci(null);
        impresion.setHidcimpreotro(null);
        
        
        

        ChimprdiagPK id = new ChimprdiagPK();
        exito = true;
        
        if(!renderSemanas){
            impresion.setHidcconfiseman(null);
            impresion.setHidnsemanameno(null);
            impresion.setHidnsemanembar(null);
        }
        
        
        
        if(diagprin != null && diagprin.getCdcccodigo()!= null && !diagprin.getCdcccodigo().equals(CODIGO_PRINCIPAL_ABORTO_MEDICO)){
            impresion.setHidcconfiseman(null);
            impresion.setHidnsemanameno(null);
            impresion.setHidnsemanembar(null);
        }
        
        if(renderHistoriaIlve && renderSemanas &&  impresion.getHidnsemanameno() == null ){
            FacesUtils.addErrorMessage("body:formImpresionDiagnostica:panelTabImpresionDiagnostica:itSemanas", 
                                       "El campo es obligatorio");
            exito = false;
        }
        


        if (impresion == null || impresion.getHidcdiagprin() == null || 
            impresion.getHidcdiagprin().equals("")) {
            FacesUtils.addErrorMessage("body:formImpresionDiagnostica:panelTabImpresionDiagnostica:itDiagPrin", 
                                       "El campo es obligatorio");
            exito = false;
        }

        if (impresion.getHidntipodiagn() == null) {
            FacesUtils.addErrorMessage("body:formImpresionDiagnostica:panelTabImpresionDiagnostica:tipoDiagnostico", 
                                       "El campo es obligatorio");
            exito = false;
        }
        
        if(renderSemanas && !renderConfirmacion){
            if(impresion != null 
                && impresion.getHidcconfiseman()!= null && impresion.getHidcconfiseman().equals("S")){
                   impresion.setHidnsemanembar(impresion.getHidnsemanameno());
             }
            
        }
        
        if(renderSemanas){
            if(renderHistoriaIlve && impresion.getHidcconfiseman() == null){
                exito = false;
                FacesUtils.addErrorMessage("body:formImpresionDiagnostica:panelTabImpresionDiagnostica:mnuConfirmaEmbarazo",MSG_CAMPO_OBLIGATORIO);
            }
            
            if(renderHistoriaIlve && impresion.getHidcconfiseman() != null && impresion.getHidcconfiseman().equals("N")){
                if(impresion.getHidnsemanembar() == null){
                    exito = false;
                    FacesUtils.addErrorMessage("body:formImpresionDiagnostica:panelTabImpresionDiagnostica:itSemanasEmbarazo",MSG_CAMPO_OBLIGATORIO);
                }
                
                if(impresion.getHidnsemanembar() != null && impresion.getHidnsemanembar().intValue() > 44  ){
                    FacesUtils.addErrorMessage("body:formImpresionDiagnostica:panelTabImpresionDiagnostica:itSemanasEmbarazo", 
                                               "El numero de semanas esta mal, favor verifique");
                    exito = false;
                }
                
                
                if(impresion.getHidcmotivconfi() == null || impresion.getHidcmotivconfi().equals("") ){
                    exito = false;
                    FacesUtils.addErrorMessage("body:formImpresionDiagnostica:panelTabImpresionDiagnostica:mnuMotivoConfirma",MSG_CAMPO_OBLIGATORIO);
                }
            }
        }
        
             
        

        if (numeroConsulta != null && tipoServicio != null) {
            id.setHidlconsulta(numeroConsulta);
            id.setHidctiposervi(tipoServicio);
            id.setHidnconsecutiv(consecutivo);
            impresion.setId(id);
        }
    if(usuario != null &&usuario.getHusdfechanacim() != null){
        edad = calcularEdad(usuario.getHusdfechanacim(), new Date());
    }
        
        impresion.setHidcoperador(userName());
        impresion.setHiddfecregistr(new Date());
        
        
        
         


        if (impresion != null) {
        
        if(impresion.getHidcimpreotro()!= null && impresion.getHidcimpreotro().equals("N")){
            impresion.setHidcimprecual(null);
        }
        
            if (lstImpresionSelect!= null && 
                !lstImpresionSelect.isEmpty()) {
               
                impresion.setHidcimprenorma("N");
                impresion.setHidcimpresuges("N");
                impresion.setHidcimpreinfla("N");
                impresion.setHidcimpreleyba("N");
                impresion.setHidcimpreatrof("N");
                impresion.setHidcimpreleyal("N");
                impresion.setHidcimprecarci("N");
                impresion.setHidcimpreotro("N");
                
                
                for (Iterator iterator = 
                     lstImpresionSelect.iterator(); 
                     iterator.hasNext(); ) {
                    String codigo = (String)iterator.next();
                    if (codigo.equals("NO")) {
                        impresion.setHidcimprenorma("S");
                    }
                    if (codigo.equals("SV")) {
                        impresion.setHidcimpresuges("S");
                    }

                    if (codigo.equals("IN")) {
                        impresion.setHidcimpreinfla("S");
                    }

                    if (codigo.equals("BG")) {
                        impresion.setHidcimpreleyba("S");
                    }


                    if (codigo.equals("AT")) {
                        impresion.setHidcimpreatrof("S");
                    }


                    if (codigo.equals("AG")) {
                        impresion.setHidcimpreleyal("S");
                    }

                    if (codigo.equals("CI")) {
                        impresion.setHidcimprecarci("S");
                    }


                    if (codigo.equals("OT")) {
                        impresion.setHidcimpreotro("S");
                    }
                }

            }
        
        
        
        
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

        if (exito) {

            if (esurgencia) {
                impresion.setHidcurgencia("S");
            }
            try {
                if(flagCostos){
                    saveAcumuladorCostos();
                }
                this.getServiceLocator().getClinicoService().saveImpresion(impresion);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);

                // Se recarga el menu 
                if(menuBean!= null && !menuBean.equals("")){
                    FacesUtils.resetManagedBean(menuBean);    
                }
                
                
                 navigationRule = nextAction;
                 
                 if(nextAction2 != null && !nextAction2.equals("")){
                    if(impresion!= null && impresion.getHidcdiagprin()!= null && !impresion.getHidcdiagprin().toUpperCase().equals(CODIGO_PRINCIPAL_ABORTO_MEDICO)){
                        navigationRule = nextAction2; 
                    }
                     
                 }

            } catch (ModelException e) {
                navigationRule = "";
                return capturaError(e,IConstantes.ERROR_GUARDADO);
            }
        }

        // Se establece la siguiente accion de navegacion
        return navigationRule;

    }


    // ACCESSORS

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
                                                    "Seleccione una opci�n..."));
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
    
    public void setUtilizo(ValueChangeEvent valueChangeEvent) {
        int indiceLista=dtServiciosCostos.getRowIndex();
         lstServicios.get(indiceLista).setUtilizo(((String)valueChangeEvent.getNewValue()));
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setLote(ValueChangeEvent valueChangeEvent) {
        int indiceLista=dtServiciosCostos.getRowIndex();
         lstServicios.get(indiceLista).setLote(((String)valueChangeEvent.getNewValue()));
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
      
      public String changeListaServicio(){
        
          int indiceLista=dtServiciosCostos.getRowIndex();
          if(lstServicios.get(indiceLista).getLstLotes()==null){
            lstServicios.get(indiceLista).setLstLotes(new ArrayList<SelectItem>());
          }
          lstServicios.get(indiceLista).getLstLotes().clear();
          lstServicios.get(indiceLista).setFechaVencimiento(null);
          lstServicios.get(indiceLista).setRenderFecha(false);
          if(("S").equals(lstServicios.get(indiceLista).getTrazador()) && ("S") .equals(lstServicios.get(indiceLista).getUtilizo()) ){
            List<String>aux;
            try {
                aux = serviceLocator.getCostosService().geLstLotesByCodigo(lstServicios.get(indiceLista).getCodigoServicio());
                if(aux !=null){
                    List<SelectItem>lotes = new ArrayList<SelectItem>();
                for(int i = 0;i<aux.size();i++){
                   lotes.add(new SelectItem(aux.get(i),aux.get(i)));                  
                }
                    lstServicios.get(indiceLista).setLstLotes(lotes);
                }
            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }
       
          }
          return null;
      }
    public String changeFechaLote(){
      
        int indiceLista=dtServiciosCostos.getRowIndex();
        lstServicios.get(indiceLista).setFechaVencimiento(null);
        lstServicios.get(indiceLista).setRenderFecha(false);
          try {
             Date aux = serviceLocator.getCostosService().getFechaByLote(lstServicios.get(indiceLista).getLote());
              if(aux !=null){
                  lstServicios.get(indiceLista).setFechaVencimiento(aux);
                  lstServicios.get(indiceLista).setRenderFecha(true);
                  
              }
          } catch (ModelException e) {
              return capturaError(e,IConstantes.ERROR_COSNULTA);
          }
     
        
        return null;
    }
    
    public String saveAcumuladorCostos(){
       
        if(lstServicios!=null){
            List<Ctacumcosto>listaAcumulador = new ArrayList<Ctacumcosto>();
            Cnconsclin consultaAux;
            try {
                consultaAux = serviceLocator.getClinicoService().getConsultaClinicaPorId(numeroConsulta.toString());
            } catch (Exception e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }
            for(int i = 0;i<lstServicios.size();i++){
                Ctacumcosto aux = new Ctacumcosto();
                aux.setCacnclinica(new Long(getClinica().getCclncodigo()));
                if(consultaAux !=null){
                    aux.setCacnadmision(consultaAux.getCconnumdoc().longValue());
                    aux.setCacnconsclin(consultaAux.getCconnumero().longValue());
                }
                aux.setCacccargpaci(lstServicios.get(i).getCargo());
                aux.setCacctipocost("INS");
                aux.setCaccestado("VG");
                aux.setCaccinsumo(lstServicios.get(i).getCodigoServicio());
                aux.setCacclote(lstServicios.get(i).getLote());
                aux.setCaccservicio(lstServicios.get(i).getCodigoInsumo());
                aux.setCacncantidad(lstServicios.get(i).getCantidad());
                aux.setCaccunidmedi(lstServicios.get(i).getUnidadUso());
                aux.setCaccetapa("VG");
                aux.setCacdfecmov(new Date());
                aux.setCacdfecreg(new Date());
                aux.setCaccusureg(userName());
                listaAcumulador.add(aux);
            }
            try {
                serviceLocator.getCostosService().savelstCtacumcosto(listaAcumulador);
            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_GUARDADO);
            }
        }
        return null;
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
     * @param lstCie10
     */
    public void setLstCie10(HashMap lstCie10) {
        this.lstCie10 = lstCie10;
    }

    /**
     * @return
     */
    public Map getLstCie10() {
        if (lstCie10 == null || lstCie10.isEmpty()) {
            lstCie10 = new HashMap();
            ArrayList<Crdgncie10> lstCie10Aux = null;
            try {
                lstCie10Aux = 
                        (ArrayList<Crdgncie10>)this.serviceLocator.getClinicoService().getCie10();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstCie10Aux.isEmpty()) {

                Iterator it = lstCie10Aux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstCie10.put(lstCie10Aux.get(i).getCdcccodigo().toString(), 
                                 lstCie10Aux.get(i).getCdccdescri());
                    i++;
                }
            }
        }
        return lstCie10;
    }

    /**
     * @param valueChangeEvent
     */
    public void setHidcdiagprin(ValueChangeEvent valueChangeEvent) {
        impresion.setHidcdiagprin((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHidcconfiseman(ValueChangeEvent valueChangeEvent) {
        impresion.setHidcconfiseman((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setHidcdiagrela1(ValueChangeEvent valueChangeEvent) {
        impresion.setHidcdiagrela1((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHidcdiagrela2(ValueChangeEvent valueChangeEvent) {
        impresion.setHidcdiagrela2((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHidcdiagrela3(ValueChangeEvent valueChangeEvent) {
        impresion.setHidcdiagrela3((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
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
     * @param exito
     */
    public void setExito(boolean exito) {
        this.exito = exito;
    }

    /**
     * @return
     */
    public boolean isExito() {
        return exito;
    }

    /**
     * @param mnuTipoDiagnostico
     */
    public void setMnuTipoDiagnostico(UIInput mnuTipoDiagnostico) {
        this.mnuTipoDiagnostico = mnuTipoDiagnostico;
    }

    /**
     * @return
     */
    public UIInput getMnuTipoDiagnostico() {
        return mnuTipoDiagnostico;
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
     * @param mostrarAsa
     */
    public void setMostrarAsa(boolean mostrarAsa) {
        this.mostrarAsa = mostrarAsa;
    }

    /**
     * @return
     */
    public boolean isMostrarAsa() {
        return mostrarAsa;
    }

    /**
     * @param codigoDiagnostico
     */
    public void setCodigoDiagnostico(String codigoDiagnostico) {
        this.codigoDiagnostico = codigoDiagnostico;
    }

    /**
     * @return
     */
    public String getCodigoDiagnostico() {
        return codigoDiagnostico;
    }

    /**
     * @param esurgencia
     */
    public void setEsurgencia(boolean esurgencia) {
        this.esurgencia = esurgencia;
    }

    /**
     * @return
     */
    public boolean isEsurgencia() {
        return esurgencia;
    }

    /**
     * @param lstGradoASA
     */
    public void setLstGradoASA(List lstGradoASA) {
        this.lstGradoASA = lstGradoASA;
    }

    /**
     * @return
     */
    public List getLstGradoASA() {
        if (lstGradoASA == null || lstGradoASA.isEmpty()) {
            lstGradoASA = new ArrayList();
            lstGradoASA.add(new SelectItem(1, "1"));
            lstGradoASA.add(new SelectItem(2, "2"));
            lstGradoASA.add(new SelectItem(3, "3"));
            lstGradoASA.add(new SelectItem(4, "4"));
            lstGradoASA.add(new SelectItem(5, "5"));
        }
        return lstGradoASA;
    }


    /**
     * @param tipoDiagnostico
     */
    public void setTipoDiagnostico(Integer tipoDiagnostico) {
        this.tipoDiagnostico = tipoDiagnostico;
    }

    /**
     * @return
     */
    public Integer getTipoDiagnostico() {
        return tipoDiagnostico;
    }


    /**
     * @param renderSemanas
     */
    public void setRenderSemanas(boolean renderSemanas) {
        this.renderSemanas = renderSemanas;
    }

    /**
     * @return
     */
    public boolean isRenderSemanas() {
        return renderSemanas;
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
    if(lstOpciones == null){
        lstOpciones = new ArrayList();
        lstOpciones.add(new SelectItem("S","Si"));
        lstOpciones.add(new SelectItem("N","No"));
    }
        return lstOpciones;
    }

    /**
     * @param semanaEmbarazo
     */
    public void setSemanaEmbarazo(Double semanaEmbarazo) {
        this.semanaEmbarazo = semanaEmbarazo;
    }

    /**
     * @return
     */
    public Double getSemanaEmbarazo() {
        return semanaEmbarazo;
    }

    /**
     * @param renderConfirmacion
     */
    public void setRenderConfirmacion(boolean renderConfirmacion) {
        this.renderConfirmacion = renderConfirmacion;
    }

    /**
     * @return
     */
    public boolean isRenderConfirmacion() {
        return renderConfirmacion;
    }


    /**
     * @param nextAction2
     */
    public void setNextAction2(String nextAction2) {
        this.nextAction2 = nextAction2;
    }

    /**
     * @return
     */
    public String getNextAction2() {
        return nextAction2;
    }

    /**
     * @param renderHistoriaIlve
     */
    public void setRenderHistoriaIlve(boolean renderHistoriaIlve) {
        this.renderHistoriaIlve = renderHistoriaIlve;
    }

    /**
     * @return
     */
    public boolean isRenderHistoriaIlve() {
        return renderHistoriaIlve;
    }

    public void setLstConfirmaPor(List lstConfirmaPor) {
        this.lstConfirmaPor = lstConfirmaPor;
    }

    public List getLstConfirmaPor() {
    if(lstConfirmaPor == null || lstConfirmaPor.isEmpty()){
        lstConfirmaPor = new ArrayList(); 
        lstConfirmaPor.add(new SelectItem("","Seleccione ...")); 
        lstConfirmaPor.add(new SelectItem("AMEN","Amenorrea")); 
        lstConfirmaPor.add(new SelectItem("ECOG","Ecografia")); 
        lstConfirmaPor.add(new SelectItem("EDCO","Edad Concepcional")); 
        
    }
        return lstConfirmaPor;
    }

    /**
     * @param desHabilitarDiagnosticoPrincipal
     */
    public void setDesHabilitarDiagnosticoPrincipal(boolean desHabilitarDiagnosticoPrincipal) {
        this.desHabilitarDiagnosticoPrincipal = desHabilitarDiagnosticoPrincipal;
    }

    /**
     * @return
     */
    public boolean isDesHabilitarDiagnosticoPrincipal() {
        return desHabilitarDiagnosticoPrincipal;
    }

    /**
     * @param consecutivo
     */
    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    /**
     * @return
     */
    public Integer getConsecutivo() {
        return consecutivo;
    }

    /**
     * @param codigoRelacionado1
     */
    public void setCodigoRelacionado1(String codigoRelacionado1) {
        this.codigoRelacionado1 = codigoRelacionado1;
    }

    /**
     * @return
     */
    public String getCodigoRelacionado1() {
        return codigoRelacionado1;
    }

    /**
     * @param codigoRelacionado2
     */
    public void setCodigoRelacionado2(String codigoRelacionado2) {
        this.codigoRelacionado2 = codigoRelacionado2;
    }

    /**
     * @return
     */
    public String getCodigoRelacionado2() {
        return codigoRelacionado2;
    }

    /**
     * @param codigoRelacionado3
     */
    public void setCodigoRelacionado3(String codigoRelacionado3) {
        this.codigoRelacionado3 = codigoRelacionado3;
    }

    /**
     * @return
     */
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

    public void setRenderColposcopia(boolean renderColposcopia) {
        this.renderColposcopia = renderColposcopia;
    }

    public boolean isRenderColposcopia() {
        return renderColposcopia;
    }

    public void setLstImpresionSelect(List<String> lstImpresionSelect) {
        this.lstImpresionSelect = lstImpresionSelect;
    }

    public List<String> getLstImpresionSelect() {
        return lstImpresionSelect;
    }

    public void setLstImpresion(List lstImpresion) {
        this.lstImpresion = lstImpresion;
    }

    public List getLstImpresion() {
        if (lstImpresion == null || lstImpresion.isEmpty()) {
            lstImpresion = new ArrayList();
            lstImpresion.add(new SelectItem("NO", "Normal"));
            lstImpresion.add(new SelectItem("SV", "Sugestiva de VPH"));
            lstImpresion.add(new SelectItem("IN", "Inflamatoria"));
            lstImpresion.add(new SelectItem("BG", "LEI de bajo grado"));
            lstImpresion.add(new SelectItem("AT", "Atr�fica"));
            lstImpresion.add(new SelectItem("AG", "LEI de alto grado "));
            lstImpresion.add(new SelectItem("CI", "Carcinoma invasivo"));
            lstImpresion.add(new SelectItem("OT", "Otros"));

        }

        return lstImpresion;
    }


   

    public void setRenderOtraImpresion(boolean renderOtraImpresion) {
        this.renderOtraImpresion = renderOtraImpresion;
    }

    public boolean isRenderOtraImpresion() {
        return renderOtraImpresion;
    }
    
    public void setLstImpresionSelect(ValueChangeEvent valueChangeEvent) {
        setLstImpresionSelect((List<String>)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
    
    public void changeImpresion(){
        renderOtraImpresion = false;
        if (lstImpresionSelect != null && 
            !lstImpresionSelect.isEmpty()) {
            for (Iterator iterator = lstImpresionSelect.iterator(); 
                 iterator.hasNext(); ) {
                String codigo = (String)iterator.next();
                if (codigo.equals("OT"))
                    renderOtraImpresion = true;
            }

        }
        }


    public void setFlagCostos(boolean flagCostos) {
        this.flagCostos = flagCostos;
    }

    public boolean isFlagCostos() {
        return flagCostos;
    }

    public void setLstServicios(List<FichaTecnicaCostosDTO> lstServicios) {
        this.lstServicios = lstServicios;
    }

    public List<FichaTecnicaCostosDTO> getLstServicios() {
        return lstServicios;
    }

    public void setDtServiciosCostos(HtmlDataTable dtServiciosCostos) {
        this.dtServiciosCostos = dtServiciosCostos;
    }

    public HtmlDataTable getDtServiciosCostos() {
        return dtServiciosCostos;
    }
}

