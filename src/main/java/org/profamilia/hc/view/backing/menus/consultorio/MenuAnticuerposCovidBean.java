package org.profamilia.hc.view.backing.menus.consultorio;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.ViewHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.view.backing.comun.conducta.VademecumMedicoBean;
import org.apache.commons.codec.binary.Base64;
import org.apache.myfaces.custom.tree2.TreeNode;
import org.apache.myfaces.custom.tree2.TreeNodeBase;

import org.apache.myfaces.renderkit.html.util.AddResource;
import org.apache.myfaces.renderkit.html.util.AddResourceFactory;

import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosBean;
import org.profamilia.hc.view.backing.comun.AntecedentesGeneralesUsuarioBean;
import org.profamilia.hc.view.backing.comun.AntecedentesUsuarioBean;
import org.profamilia.hc.view.backing.comun.AplicacionDispositivoBean;
import org.profamilia.hc.view.backing.comun.CerrarConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.ControlUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.ExamenFisicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.PausarConsultaBean;
import org.profamilia.hc.view.backing.comun.conducta.AnatomiaPatologicaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.AutorizacionServicioUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.CertAsistenciaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.CertMedicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ControlSinCostoUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ExamElectrofisiologicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ExamImagenUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ExamLaboratorioUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.FormulaMedicaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.HospitalizacionUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.IncapacidadUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.InterConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.OrdenCirugiaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.RecomedacionUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ReferenciaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ReservaSangreUsuarioBean;
import org.profamilia.hc.view.backing.comun.resumen.ResumenHistoriaEspecificaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.ExpandableTreeModel;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.view.backing.cirugia.registro.OtrasOrdenesBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaHospitalizacionBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaLiquidosBean;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;
import org.profamilia.hc.view.backing.comun.PruebasAnticuerposCovidBean;
import org.profamilia.hc.view.backing.comun.RegistrarEscalaValoracionCaidasCEBean;


public class MenuAnticuerposCovidBean extends BaseBean{

    private DatosBasicosUsuarioBean datosBasicosUsuario;

  

    private CerrarConsultaUsuarioBean cerrarConsultaUsuarioBean;

  
    
    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private boolean renderConducta;

    private boolean renderCerrarConsulta;

    private boolean renderControl;

    private ExpandableTreeModel trnhistoria;

    private Long numeroConsulta;

    private String cie10Principal;

    private String cie10Relacionado1;

    private String codigoCups;
    
    private boolean primeraConsulta;
    
    private Chimprdiag impresion; 
    
    private Chmotivocon motivo;
    
    private String javaScriptText;

    private boolean renderPausarConsulta;
    private PausarConsultaBean pausarConsulta;
    private boolean tiempoAtencion;
    
    private boolean renderOrdenesMedicas;
    
   
    
    private boolean renderCovid;
    
    private PruebasAnticuerposCovidBean  pruebasAnticuerposBean;
    private boolean renderEscalaCaidas;
    private boolean renderImprimir;

    
    public void init() {
       
      
        boolean renderMasculino;
        renderMasculino = false;  
        
        renderEscalaCaidas = false;
        

        // DATOS BASICOS USUARIO
        datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_PRUEBA_COVID_ANTICUERPOS);
        datosBasicosUsuario.setMenuBean("menuAnticuerposCovidBean");
        renderCovid = datosBasicosUsuario.esValido();

        if (datosBasicosUsuario != null && 
            datosBasicosUsuario.getConsulta() != null && 
            datosBasicosUsuario.getConsulta().getCconnumero() != null) {
            numeroConsulta = 
                    new Long(datosBasicosUsuario.getConsulta().getCconnumero());
            if (datosBasicosUsuario.getConsulta().getCcocservic() != null) {
                codigoCups = 
                        datosBasicosUsuario.getConsulta().getCcocservic().getCsvccodigo();
            }
        }
        
        
        if (datosBasicosUsuario != null && 
            datosBasicosUsuario.getUsuario() != null && 
            datosBasicosUsuario.getUsuario().getHusesexo() != null) {
           
            if (datosBasicosUsuario.getUsuario().getHusesexo() != null && datosBasicosUsuario.getUsuario().getHusesexo().equals(SEXO_MASCULINO)) {
                renderMasculino = true; 
            }
        }
       PruebasAnticuerposCovidBean  pruebasAnticuerposBean = (PruebasAnticuerposCovidBean)FacesUtils.getManagedBean("pruebasAnticuerposCovidBean");
        pruebasAnticuerposBean.setNumeroConsulta(numeroConsulta);
       
        if(datosBasicosUsuario != null && datosBasicosUsuario.getUsuario() != null && datosBasicosUsuario.getUsuario().getHuslnumero() != null ){
            pruebasAnticuerposBean.setNumeroUsuario(datosBasicosUsuario.getUsuario());
        }
        pruebasAnticuerposBean.setNextAction(BeanNavegacion.RUTA_ACTUAL);
        pruebasAnticuerposBean.setMenuBean("menuAnticuerposCovidBean");
        pruebasAnticuerposBean.setConsclin(datosBasicosUsuario.getConsulta());
        pruebasAnticuerposBean.setBananticuerpos("S");
        pruebasAnticuerposBean.inicalizarAplicacionBean();
        FacesUtils.resetManagedBean("cerrarConsultaUsuarioBean");
        renderImprimir= pruebasAnticuerposBean.esValido();
        
        
        // CERRAR CONSULTA
        cerrarConsultaUsuarioBean = 
                    (CerrarConsultaUsuarioBean)FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
        cerrarConsultaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        cerrarConsultaUsuarioBean.setMenuBean("menuAnticuerposCovidBean");
        cerrarConsultaUsuarioBean.setConsulta(datosBasicosUsuario.getConsulta());
        cerrarConsultaUsuarioBean.setEsVacunacion(false); 
        cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();

        
       
        
        renderPausarConsulta=false;
        if(IConstantes.ACTIVAR_PAUSAR_CONSULTA) {
            renderPausarConsulta = datosBasicosUsuario.esValido();
        }
        
        if(IConstantes.ACTIVAR_PAUSAR_CONSULTA) {
           tiempoAtencion =datosBasicosUsuario.esValido();
           if (tiempoAtencion) {
               
               try {
                   List<Chtiempaten> chtiempatenList = new ArrayList<Chtiempaten>();
                   chtiempatenList = 
                           getServiceLocator().getClinicoService().consultarTiempoAtencionVigentesXconsulta(numeroConsulta);
                   if (chtiempatenList.isEmpty()) {
                       Chtiempaten chtiempatenAux = new Chtiempaten();
                       chtiempatenAux.setCtanconsulta(numeroConsulta);
                       chtiempatenAux.setCtacetapa("AB");
                       chtiempatenAux.setCtacestado("VG");
                       chtiempatenAux.setCtadhora(new Date());
                       chtiempatenAux.setCtadfechregi(new Date());
                       chtiempatenAux.setCtancausa(0);
                       chtiempatenAux.setCtacusuareg(getUsuarioSystem().getCurcusuari());
                       chtiempatenAux.setCtancodmed(Integer.parseInt(getUsuarioSystem().getCurnprofes().toString()));
                       this.getServiceLocator().getClinicoService().saveRegistroTiempoAtencion(chtiempatenAux);
                   }
               } catch (ModelException e) {
                   e.printStackTrace();
               }
           }
        }

        // PAUSAR CONSULTA
         if(IConstantes.ACTIVAR_PAUSAR_CONSULTA){
             if(renderPausarConsulta){
             pausarConsulta = 
                     (PausarConsultaBean)FacesUtils.getManagedBean("pausarConsultaBean");
                  pausarConsulta.setNumeroConsulta(numeroConsulta);
                  if(numeroConsulta != null){
                      pausarConsulta.init();
                      pausarConsulta.getCausasPausarConsultas();
                  }
              }
         }
                
        


    }
    
    public String irPausarConsultaControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_PAUSAR_CONSULTA_CONTROL;
    }
    
    public String irCuestionarioCovidControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_CONTROL;
        }


    /**
     * @return
     */
    public String irDatosUsuarioCovid() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_DATOS_USUARIO_COVID_ANTICUERPOS;
    }

    /**
     * @return
     */
    public String irpruebaAnticuerposCovid() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_PRUEBA_COVID_ANTICUERPOS;
    }

    /**
     * @return
     */
    public String irImprimirCovidAnticuerpos() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IMPRIMIR_COVID_ANTICUERPOS;
    }

    /**
     * @return
     */
    public String irMotivoControl() {
        inicializarUsuario();

        return BeanNavegacion.RUTA_IR_MOTIVO_CONTROL;
    }
    
    
  
    /**
     * @return
     */
    public String irAntecedentesGeneralesControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_GENERALES_CONTROL; 
    }


    /**
     * @return
     */
    public String irAntecedentesControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_CONTROL;
    }



    /**
     * @return
     */
    public String irExamenFisicoControl() {

        inicializarUsuario();

        return BeanNavegacion.RUTA_IR_EXAMEN_FISICO_CONTROL;
    }

    /**
     * @return
     */
    public String irImpDiagnosticaControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_CONTROL;
    }


    public String irControlUsuario() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CONTROL_USUARIO;
    }


    /**
     * @return
     */
    public String irAnatPatologicaControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANATOMIAPATOLOGICA_CONTROL;
    }

    /**
     * @return
     */
    public String irAplicacionRetiro() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_APLICACION_RETITO_CONTROL;
    }

    /**
     * @return
     */
    public String irControlSinCostoControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CONTOLSINCOSTO_CONTROL;
    }


    /**
     * @return
     */
    public String irFormulaMedicaControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FORMULAMEDICA_CONTROL;
    }
    

        /**
         * @return
         */
        public String irVademecumMedicoControl() {
            inicializarUsuario();
            return BeanNavegacion.RUTA_IR_VADEMCUM_CONTROL;
        }

    /**
     * @return
     */
    public String irRemHospitalizacionControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_HOSPITALZACION_CONTROL;
    }
    
    /**
     * @return
     */
     public String irAutorizacionServicioControl(){
         inicializarUsuario();
         return BeanNavegacion.RUTA_IR_AUTORIZACION_SERVICIOS_CONTROL;
     }


    /**
     * @return
     */
    public String irIncapacidadControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INCAPACIDAD_CONTROL;
    }


    /**
     * @return
     */
    public String irInterConsultaControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INTERCONSULTA_CONTROL;
    }


    /**
     * @return
     */
    public String irOrdenCirugiaControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ORDENCIRUGIA_CONTROL;
    }


    /**
     * @return
     */
    public String irReferenciaControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_REFERENCIA_CONTROL;
    }

    /**
     * @return
     */
    public String irReservaSangreControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESERVA_SANGRE_CONTROL;
    }


    /**
     * @return
     */
    public String irRecomedacionControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RECOMENDACIONES_CONTROL;
    }


    /**
     * @return
     */
    public String irCertMedicoControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADOMEDICO_CONTROL;
    }

    /**
     * @return
     */
    public String irCertAsistenciaControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADO_ASISTENCIA_CONTROL;
    }

    /**
     * @return
     */
    public String irExamElectrofisiologicoControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ELECTROFISIOLOGICO_CONTROL;
    }

    /**
     * @return
     */
    public String irExamImagenControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMAGENES_CONTROL;
    }

    /**
     * @return
     */
    public String irExamLaboratorioControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_LABORATORIO_CONTROL;
    }


    public String irCerrarConsultaControl() {
        if (cerrarConsultaUsuarioBean != null) {
            cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
        }
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERRAR_CONTROL;
    }

    /**
     * @return
     */
    public String irResumenHistoriaEspecificaControl() {
        inicializarUsuario();


                CerrarConsultaUsuarioBean cerrarConsulta = 
                    (CerrarConsultaUsuarioBean)FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
                cerrarConsulta.inicalizarCerrarConsultaBean();

                FacesUtils.resetManagedBean("consultarFoliosBean");

                ConsultarFoliosBean generarResumen = 
                    (ConsultarFoliosBean)FacesUtils.getManagedBean("consultarFoliosBean");
                if (generarResumen != null) {
                    generarResumen.init();
                    generarResumen.setEncabezado(true);
                    generarResumen.setUsuario(datosBasicosUsuario.getUsuario());
                    generarResumen.consultarFoliosUsuario();

                }
              
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_CONTROL;
    }


    /**
     * @return
     */
    public String irResumenHistoriaControl() {
        inicializarUsuario();

        FacesUtils.resetManagedBean("consultarFoliosBean");

        ConsultarFoliosBean generarResumen = 
            (ConsultarFoliosBean)FacesUtils.getManagedBean("consultarFoliosBean");
        if (generarResumen != null) {
            generarResumen.init();
            generarResumen.setEncabezado(true);
            generarResumen.setUsuario(datosBasicosUsuario.getUsuario());
            generarResumen.consultarFoliosUsuario();

        }
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_CONTROL;
    }


    public void inicializarUsuario() {

        if (datosBasicosUsuario.getUsuario() != null)
            this.setUsuario(datosBasicosUsuario.getUsuario());
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
     * @param renderConducta
     */
    public void setRenderConducta(boolean renderConducta) {
        this.renderConducta = renderConducta;
    }

    /**
     * @return
     */
    public boolean isRenderConducta() {
        return renderConducta;
    }



    /**
     * @param renderCerrarConsulta
     */
    public void setRenderCerrarConsulta(boolean renderCerrarConsulta) {
        this.renderCerrarConsulta = renderCerrarConsulta;
    }

    /**
     * @return
     */
    public boolean isRenderCerrarConsulta() {
        return renderCerrarConsulta;
    }


    /**
     * @param renderControl
     */
    public void setRenderControl(boolean renderControl) {
        this.renderControl = renderControl;
    }
    
    /**
     * @param primeraConsulta
     */
    public void setPrimeraConsulta(boolean primeraConsulta) {
        this.primeraConsulta = primeraConsulta;
    }

    /**
     * @return
     */
    public boolean isPrimeraConsulta() {
        return primeraConsulta;
    }

    /**
     * @return
     */
    public boolean isRenderControl() {
        return renderControl;
    }

    /**
     * @param trnhistoria
     */
    public void setTrnhistoria(ExpandableTreeModel trnhistoria) {
        this.trnhistoria = trnhistoria;
    }

    /**
     * @return
     */
    public ExpandableTreeModel getTrnhistoria() {
        TreeNode treeData = new TreeNodeBase("raiz", "Conducta", false);

        TreeNodeBase itemNode1 = 
            new TreeNodeBase("itemNode1", "Anatomia Patologica", false);
        TreeNodeBase itemNode2 = 
            new TreeNodeBase("itemNode2", "Control", false);
        TreeNodeBase itemNode3 = 
            new TreeNodeBase("itemNode3", "Formula Medica", false);
        TreeNodeBase itemNode4 = 
            new TreeNodeBase("itemNode4", "Remisi�n Hospitalizaci�n", false);
        TreeNodeBase itemNode5 = 
            new TreeNodeBase("itemNode5", "Incapacidad", false);
        TreeNodeBase itemNode6 = 
            new TreeNodeBase("itemNode6", "Inter Consulta", false);
        TreeNodeBase itemNode7 = 
            new TreeNodeBase("itemNode7", "Cirug�as y procedimientos", false);
        TreeNodeBase itemNode8 = 
            new TreeNodeBase("itemNode8", "Recomendaciones", false);
        TreeNodeBase itemNode9 = 
            new TreeNodeBase("itemNode9", "Referencia", false);
        TreeNodeBase itemNode10 = 
            new TreeNodeBase("itemNode10", "Reserva de Sangre", false);

        TreeNodeBase itemNode11 = 
            new TreeNodeBase("raiz", "Certificados", false);
        itemNode11.getChildren().add(new TreeNodeBase("itemNode11_1", "Medico", 
                                                      true));
        itemNode11.getChildren().add(new TreeNodeBase("itemNode11_2", 
                                                      "De Asistencia", true));

        TreeNodeBase itemNode12 = 
            new TreeNodeBase("raiz", "Ex�menes Clinicos", false);
        itemNode12.getChildren().add(new TreeNodeBase("itemNode12_1", 
                                                      "ElectroFisiologicos", 
                                                      true));
        itemNode12.getChildren().add(new TreeNodeBase("itemNode12_2", "Imagen", 
                                                      true));
        itemNode12.getChildren().add(new TreeNodeBase("itemNode12_3", 
                                                      "Laboratorio", true));


        treeData.getChildren().add(itemNode1);
        treeData.getChildren().add(itemNode2);
        treeData.getChildren().add(itemNode3);
        treeData.getChildren().add(itemNode4);
        treeData.getChildren().add(itemNode5);
        treeData.getChildren().add(itemNode6);
        treeData.getChildren().add(itemNode7);
        treeData.getChildren().add(itemNode8);
        treeData.getChildren().add(itemNode9);
        treeData.getChildren().add(itemNode10);
        treeData.getChildren().add(itemNode11);
        treeData.getChildren().add(itemNode12);

        ExpandableTreeModel treeDataExtended = 
            new ExpandableTreeModel(treeData);

        treeDataExtended.setExpanded(treeData, true);
        treeDataExtended.setExpanded(itemNode11, true);
        treeDataExtended.setExpanded(itemNode12, true);

        return treeDataExtended;
    }
    
    public void openPopupClicked(ActionEvent event) {
        javaScriptText = "";
        Long numeroUsuario = null;
        String encodedText = "";
        String cod = "";
        
        numeroUsuario = datosBasicosUsuario.getUsuario().getHusanumeiden();
        
        if(numeroUsuario != null){
            cod = "[N_MERO_ID_] = " + numeroUsuario.toString(); 
        }
        
        String urlString = "/apolo:80/DocuWare/"; 
        
        String encodedAuten;

        // Base64
        System.out.println("Numero Usuario String "+numeroUsuario.toString());
        encodedText = new String(Base64.encodeBase64(cod.getBytes()));
        // encodedAuten = new String(Base64.encodeBase64(autenticacion.getBytes()));
        
        
         urlString = urlString + encodedText ; 
         System.out.println(urlString);
        
        FacesContext facesContext = FacesContext.getCurrentInstance();

        // This is the proper way to get the view's url
        ViewHandler viewHandler = facesContext.getApplication().getViewHandler();
        String actionUrl = urlString;
            
        
        javaScriptText = "window.open('http://wgesdoc/DocuWare/Platform/WebClient/1/Integration?p=RLV&fc=0ee1c783-c5e9-4232-b6cc-b651dd62bd02&q=" + encodedText + "' );";
        
        // Add the Javascript to the rendered page's header for immediate execution
        AddResource addResource = AddResourceFactory.getInstance(facesContext);
        
        addResource.addInlineScriptAtPosition(null, AddResource.HEADER_BEGIN, javaScriptText); 
     
    }


   

    public void setRenderOrdenesMedicas(boolean renderOrdenesMedicas) {
        this.renderOrdenesMedicas = renderOrdenesMedicas;
    }

    public boolean isRenderOrdenesMedicas() {
        return renderOrdenesMedicas;
    }

    public void setRenderPausarConsulta(boolean renderPausarConsulta) {
        this.renderPausarConsulta = renderPausarConsulta;
    }

    public boolean isRenderPausarConsulta() {
        return renderPausarConsulta;
    }

    public void setPausarConsulta(PausarConsultaBean pausarConsulta) {
        this.pausarConsulta = pausarConsulta;
    }

    public PausarConsultaBean getPausarConsulta() {
        return pausarConsulta;
    }
	
	public String irServiciosAdmisionControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_SERVICIOS_ADMISION_CONTROL;
    }

   
    public String irOrdenLiquidosControl() {
        return BeanNavegacion.RUTA_IR_ORDEN_LIQUIDOS_CONTROL;
    }
    
    public String irRegistrarOtrasOrdenesControl() {
        return BeanNavegacion.RUTA_IR_OTRAS_ORDENES_CONTROL;
    }
    
    public String irOrdenMedicamentosControl() {
        return BeanNavegacion.RUTA_IR_ORDEN_MEDICAMENTOS_CONTROL;
    }

    public void setRenderCovid(boolean renderCovid) {
        this.renderCovid = renderCovid;
    }

    public boolean isRenderCovid() {
        return renderCovid;
    }
    public String irRegistrarOtrasOrdenesControlAneste() {
        return BeanNavegacion.RUTA_IR_OTRAS_ORDENES_CONTROL_ANESTE;
    }
    
    /**
     * @return
     */
    public String irEscalaValoracionCaidasControl() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_CONTROL;
    }

    public void setRenderEscalaCaidas(boolean renderEscalaCaidas) {
        this.renderEscalaCaidas = renderEscalaCaidas;
    }

    public boolean isRenderEscalaCaidas() {
        return renderEscalaCaidas;
    }

    public void setRenderImprimir(boolean renderImprimir) {
        this.renderImprimir = renderImprimir;
    }

    public boolean isRenderImprimir() {
        return renderImprimir;
    }
}
