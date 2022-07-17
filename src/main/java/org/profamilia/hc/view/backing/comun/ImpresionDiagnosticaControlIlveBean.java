 //=======================================================================
 // ARCHIVO ImpresionDiagnosticaControlIlveBean.java
 // FECHA CREACI�N: 10/06/2015
 // AUTOR: CARLOS ANDRES VARGAS
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

import java.util.StringTokenizer;

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
 import org.profamilia.hc.model.dto.Crdgncie10;
 import org.profamilia.hc.model.exceptions.ModelException;
 import org.profamilia.hc.view.backing.BaseBean;
 import org.profamilia.hc.view.backing.clinico.comun.Cie10Bean;
 import org.profamilia.hc.view.constantes.IMsg;
 import org.profamilia.hc.view.util.FacesUtils;




 //=======================================================================
 //  CLASE ImpresionDiagnosticaControlIlveBean
 //=======================================================================

 public class ImpresionDiagnosticaControlIlveBean extends BaseBean {

     //-----------------------------------------------------------------------
     //  ATRIBUTOS DE INSTANCIA
     //-----------------------------------------------------------------------
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

      private boolean mostrarEspulsion;

      private List lstDiagnosticoPrincipal;

      private List lstDiagnosticoRelacionado1;

      private List lstDiagnosticoRelacionado2;

      private List lstDiagnosticoRelacionado3;

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

     //-----------------------------------------------------------------------
     //  METODO CONSTRUCTOR
     //-----------------------------------------------------------------------

     public ImpresionDiagnosticaControlIlveBean() {
     }
     
    public void init() {
         inicializarImpresion();
        
    }

     public void inicializarImpresion() {


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
         
         if (motivo.getHmccpreseexpu() != null && 
             !motivo.getHmccpreseexpu().equals("S")) {
             mostrarEspulsion = false;
         } else {
             mostrarEspulsion = true;
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
     
     
     public String aceptar() {
     boolean exito;
      


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

         // validaciones por tipo de control


        if (impresion == null || impresion.getHidcdiagprin() == null || 
             impresion.getHidcdiagprin().equals("")) {
             FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:itDiagPrinConsultaControl", 
                                        "El campo es obligatorio");
             exito = false;
         }

         if (impresion == null || impresion.getHidntipodiagn() == null) {
             FacesUtils.addErrorMessage("body:formRegistrarControl:panelTabConsultaControl:tipoDiagnosticoConsultaControl", 
                                        "El campo es obligatorio");
             exito = false;
         }

       

         if (numeroConsulta != null && tipoServicio != null && 
             consecutivo != null) {
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


         if (exito) {
             try {
                 this.serviceLocator.getClinicoService().saveImpresionIlveConsulta(impresion);
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




        /**
         * @param valueChangeEvent
         */
        public void setHidcdiagrela3(ValueChangeEvent valueChangeEvent) {
            impresion.setHidcdiagrela3((String)valueChangeEvent.getNewValue());
            ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
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


    public void setControl(Chcontrolcon control) {
        this.control = control;
    }

    public Chcontrolcon getControl() {
        return control;
    }

    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    public Integer getTipoHistoria() {
        return tipoHistoria;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setMenuBean(String menuBean) {
        this.menuBean = menuBean;
    }

    public String getMenuBean() {
        return menuBean;
    }

    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public String getNavigationRule() {
        return navigationRule;
    }

    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    public String getNextAction() {
        return nextAction;
    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setMotivoOpcional(boolean motivoOpcional) {
        this.motivoOpcional = motivoOpcional;
    }

    public boolean isMotivoOpcional() {
        return motivoOpcional;
    }

    public void setEnfermedadOpcional(boolean enfermedadOpcional) {
        this.enfermedadOpcional = enfermedadOpcional;
    }

    public boolean isEnfermedadOpcional() {
        return enfermedadOpcional;
    }

    public void setLstCausa(List<SelectItem> lstCausa) {
        this.lstCausa = lstCausa;
    }

    public List<SelectItem> getLstCausa() {
        return lstCausa;
    }

    public void setLstTipoControl(List<SelectItem> lstTipoControl) {
        this.lstTipoControl = lstTipoControl;
    }

    public List<SelectItem> getLstTipoControl() {
        return lstTipoControl;
    }

    public void setLstFinalidades(List<SelectItem> lstFinalidades) {
        this.lstFinalidades = lstFinalidades;
    }

    public List<SelectItem> getLstFinalidades() {
        return lstFinalidades;
    }

    public void setMotivo(Chmotivocon motivo) {
        this.motivo = motivo;
    }

    public Chmotivocon getMotivo() {
        return motivo;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
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

    public void setDiagprin(Crdgncie10 diagprin) {
        this.diagprin = diagprin;
    }

    public Crdgncie10 getDiagprin() {
        return diagprin;
    }

    public void setDiagrela1(Crdgncie10 diagrela1) {
        this.diagrela1 = diagrela1;
    }

    public Crdgncie10 getDiagrela1() {
        return diagrela1;
    }

    public void setDiagrela2(Crdgncie10 diagrela2) {
        this.diagrela2 = diagrela2;
    }

    public Crdgncie10 getDiagrela2() {
        return diagrela2;
    }

    public void setDiagrela3(Crdgncie10 diagrela3) {
        this.diagrela3 = diagrela3;
    }

    public Crdgncie10 getDiagrela3() {
        return diagrela3;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setMostrarFarmacologico(boolean mostrarFarmacologico) {
        this.mostrarFarmacologico = mostrarFarmacologico;
    }

    public boolean isMostrarFarmacologico() {
        return mostrarFarmacologico;
    }

    public void setMostrarQuirurgico(boolean mostrarQuirurgico) {
        this.mostrarQuirurgico = mostrarQuirurgico;
    }

    public boolean isMostrarQuirurgico() {
        return mostrarQuirurgico;
    }

    public void setMostrarEcografias(boolean mostrarEcografias) {
        this.mostrarEcografias = mostrarEcografias;
    }

    public boolean isMostrarEcografias() {
        return mostrarEcografias;
    }

    public void setMostrarDoppler(boolean mostrarDoppler) {
        this.mostrarDoppler = mostrarDoppler;
    }

    public boolean isMostrarDoppler() {
        return mostrarDoppler;
    }

    public void setMostrarSangro(boolean mostrarSangro) {
        this.mostrarSangro = mostrarSangro;
    }

    public boolean isMostrarSangro() {
        return mostrarSangro;
    }

    public void setMostrarEspulsion(boolean mostrarEspulsion) {
        this.mostrarEspulsion = mostrarEspulsion;
    }

    public boolean isMostrarEspulsion() {
        return mostrarEspulsion;
    }

    public void setLstComplicaciones(List lstComplicaciones) {
        this.lstComplicaciones = lstComplicaciones;
    }

    public List getLstComplicaciones() {
        return lstComplicaciones;
    }

    public void setLstEfectoSecunda(List lstEfectoSecunda) {
        this.lstEfectoSecunda = lstEfectoSecunda;
    }

    public List getLstEfectoSecunda() {
        return lstEfectoSecunda;
    }

    public void setListEscala(List<SelectItem> listEscala) {
        this.listEscala = listEscala;
    }

    public List<SelectItem> getListEscala() {
        return listEscala;
    }

    public void setListDuraDolor(List<SelectItem> listDuraDolor) {
        this.listDuraDolor = listDuraDolor;
    }

    public List<SelectItem> getListDuraDolor() {
        return listDuraDolor;
    }

    public void setListConsuMedico(List<SelectItem> listConsuMedico) {
        this.listConsuMedico = listConsuMedico;
    }

    public List<SelectItem> getListConsuMedico() {
        return listConsuMedico;
    }

    public void setListOpciones(List<SelectItem> listOpciones) {
        this.listOpciones = listOpciones;
    }

    public List<SelectItem> getListOpciones() {
        return listOpciones;
    }

    public void setLstDoppler(List<SelectItem> lstDoppler) {
        this.lstDoppler = lstDoppler;
    }

    public List<SelectItem> getLstDoppler() {
        return lstDoppler;
    }

    public void setListSangrado(List<SelectItem> listSangrado) {
        this.listSangrado = listSangrado;
    }

    public List<SelectItem> getListSangrado() {
        return listSangrado;
    }

    public void setListExpulsion(List<SelectItem> listExpulsion) {
        this.listExpulsion = listExpulsion;
    }

    public List<SelectItem> getListExpulsion() {
        return listExpulsion;
    }

    public void setListTrasla(List<SelectItem> listTrasla) {
        this.listTrasla = listTrasla;
    }

    public List<SelectItem> getListTrasla() {
        return listTrasla;
    }

    public void setListCantSangra(List<SelectItem> listCantSangra) {
        this.listCantSangra = listCantSangra;
    }

    public List<SelectItem> getListCantSangra() {
        return listCantSangra;
    }

    public void setLstEfectoSecundaSelect(List lstEfectoSecundaSelect) {
        this.lstEfectoSecundaSelect = lstEfectoSecundaSelect;
    }

    public List getLstEfectoSecundaSelect() {
        return lstEfectoSecundaSelect;
    }

    public void setLstComplicacionesSelect(List lstComplicacionesSelect) {
        this.lstComplicacionesSelect = lstComplicacionesSelect;
    }

    public List getLstComplicacionesSelect() {
        return lstComplicacionesSelect;
    }
}
