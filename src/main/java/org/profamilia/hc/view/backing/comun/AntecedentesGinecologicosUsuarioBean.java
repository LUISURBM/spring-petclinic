 //=======================================================================
 // ARCHIVO AntecedenteGinecologicoBean.java
 // FECHA CREACI�N: 30/10/2008
 // AUTOR: jariano, andres.vargas
 // Descripcion: permite registrar antecedentes ginecologicos 
 // para un Usuario de una Histroia Clinica 
 //=======================================================================
 package org.profamilia.hc.view.backing.comun;

 import java.math.BigDecimal;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
 import java.util.Calendar;
 import java.util.Date;
 import java.util.Iterator;
 import java.util.List;

 import javax.faces.component.UIInput;
import javax.faces.component.UISelectOne;
import javax.faces.event.ValueChangeEvent;
 import javax.faces.model.SelectItem;

 import org.profamilia.hc.model.dto.Chantegineco;
 import org.profamilia.hc.model.dto.ChanteginecoPK;
 import org.profamilia.hc.model.dto.Chconsulta;
 import org.profamilia.hc.model.dto.Chcuestester;
 import org.profamilia.hc.model.dto.Chfertdato;
 import org.profamilia.hc.model.dto.Chidentiriesgo;
 import org.profamilia.hc.model.dto.Chmetodoplan;
 import org.profamilia.hc.model.dto.Chusuario;
 import org.profamilia.hc.model.dto.Cndesccito;
 import org.profamilia.hc.model.dto.Cnregferti;
 import org.profamilia.hc.model.dto.CnregfertiPK;
 import org.profamilia.hc.model.exceptions.ModelException;
 import org.profamilia.hc.view.backing.BaseBean;
 import org.profamilia.hc.view.backing.clinico.consultorio.GestacionBean;
 import org.profamilia.hc.view.constantes.IConstantes;
 import org.profamilia.hc.view.util.FacesUtils;
 //=======================================================================
 //  BIBLIOTECAS REQUERIDAS
 //=======================================================================


 //=======================================================================
 //  CLASE AntecedenteGinecologicoBean
 //=======================================================================
 public class AntecedentesGinecologicosUsuarioBean extends BaseBean {
     //-----------------------------------------------------------------------
     //  ATRIBUTOS DE INSTANCIA
     //-----------------------------------------------------------------------
     private Chantegineco antecedente;

     /** Almacena el tipo de ciclo  */
     private String tipoCiclo;

     /** Almacena true si el ciclo es regular */
     private boolean cicloiregular;

     /** Almacena la lista de los tipos de ciclos regular e irregular */
     private List<SelectItem> lstTipoCiclo;

     /** Almacena la lista de las fechas de ultima citologia */
     private List<SelectItem> lstUltimaCitologia;

     /** Almacena true si los campos del caso de uso son obligatorios para el tipo de historia*/
     private boolean camposRequeridos;

     /** Almacena true si el numero de gestaciones es cero */
     private boolean esCeroGestaciones;

     /** Almacena true si el numero de gestaciones es cero */
     private boolean esCeroPartos;

     /** Almacena true si el numero de abortos es cero */
     private boolean esCeroAbortos;

     private Integer semanaEmbarazo;

     /** Almacena true si los datos ingresados son correctos*/
     private boolean wexito;

     private boolean mostrarMensajeEmbarazo;

     private GestacionBean gestacion;

     private boolean tieneCiclo;

     private boolean renderMenarquia;

     private Integer tipoHistoria;

     private boolean mostrarReporte;

     private List lstMetodo;

     private boolean mostrarMetodo;

     private boolean mostrarInyectable;

     private boolean mostrarPildoras;

     private boolean mostrarPildorasSi;

     private boolean renderPlaneaEmbarazo;

     private String navigationRule;

     private String tipoServicio;

     /** Almacena el usuario que se desea guardar */
     private Chusuario usuario;

     private Chconsulta consulta;

     /**  */
     private String menuBean;

     private boolean renderEctopicos;

     private boolean renderMortinatos;

     private boolean renderMolas;

     private boolean renderCiclos;

     private String nextAction;

     private UIInput itFechaParto;

     private UIInput itFechaRegla;

     private UIInput itPenFechaRegla;

     private UIInput itAntFechaRegla;

     private UIInput itNumGesta;

     private UIInput itNumPartos;

     private UIInput itNumAbortos;

     private UIInput itNumcesareas;

     private UIInput itNumHijosVivos;

     private UIInput itNumNacidosVivos;

     private UIInput itNumEctopicos;

     private UIInput itNumHijosMortinatos;

     private UIInput itNumHijosMuertos;

     private UIInput mnuResultado;

     private UIInput mnuUltima;

     private Long numeroConsulta;

     private boolean ocultarmensaje;

     private Date fur;

     private Date fup;

     private boolean renderResultado;

     private boolean renderOtroResultado;

     private List lstResultado;

     private List lstOpciones;

     /** Almacena si es consulta de ilve */
     private boolean esIlve = false;

     /** Almacena si es consulta de Fertilidad */
     private boolean esFertilidad = false;

    /** Almacena si es consulta de Anticoncepci�n */
    private boolean esAnticoncepcionTemporal = false;

     /** Almacena el cuestionario de esterilizaci�n para obtener datos */
     private Chcuestester cuestionarioEster;

     private List<Chcuestester> lstCuestEster;

     /** Almacena el No aplica fecha  */
     private String noAplica;

     private boolean mostrarFechaFUP;

     private String msgplaneaembarazo;

     private boolean metodoevitaEmbarazo;

     private boolean renderedMetodo;

     private boolean renderedUsoCorrectoMetodoIve;

     private boolean renderedaclaracion;

     private UIInput itFechaAbortoParto;

     private boolean renderedAbortsprevios;
     private UIInput itAbortosPrevios;
     private boolean renderedAbortspreviosTres;
     private boolean renderedfechaAbortparto;
     private boolean renderedInterrupcion;
     private boolean mostrarFechaInyectable;

     private boolean renderIve;
     
     private Chidentiriesgo identi;
     
     // campos agregados
        
    private List lstUniMedFertilidad;
    private String UniMedFertilidad;
    private Boolean renderConocefun;
    private boolean renderPruebaEmbarazo;
    private List lstOpcionesEmbarazo;
    private UISelectOne pruebaEmb;
    private String pruebaEmbarazo;
    private boolean mostrarPruebaEmb;
    private Date fechaActual;


     //-----------------------------------------------------------------------
     //  METODO CONSTRUCTOR
     //-----------------------------------------------------------------------

     public AntecedentesGinecologicosUsuarioBean() {
     }

     public void init() {
         camposRequeridos = true;
         mostrarPildoras = false;
         mostrarPildorasSi = false;
         mostrarInyectable = false;
         inicializarAntecedentesGinecologicos();
         renderEctopicos = true;
         renderMortinatos = true;
         renderMolas = true;
         renderCiclos = true;
         nextAction = "";
         mostrarFechaFUP = false;
         renderPlaneaEmbarazo = true;

         msgplaneaembarazo = "";
         metodoevitaEmbarazo = false;
         renderedMetodo = false;
         renderedUsoCorrectoMetodoIve = false;
         renderedaclaracion = false;
         renderedAbortsprevios = false;
         renderedAbortspreviosTres = false;
         renderedfechaAbortparto = false;
         ocultarmensaje = false;
         mostrarFechaInyectable=false;
         identi= new Chidentiriesgo();
         renderConocefun=false;

     }

     public String inicializarAntecedentesGinecologicos() {
        String resultadoPruebEmb = null;
        Date fechaPruemb = null;
         if (tipoHistoria != null && 
             IConstantes.HISTORIA_INTERRUPCION == tipoHistoria) {
             renderedInterrupcion = true;
         } else {
             renderedInterrupcion = false;
         }
         renderPruebaEmbarazo = false;
        if(IConstantes.HISTORIA_ANTICONCEPCION_TEMPORAL.equals(tipoHistoria) || IConstantes.HISTORIA_ANTICONCEPCION_INSERCION.equals(tipoHistoria)){
            renderPruebaEmbarazo = true;           
        }
        gestacion = (GestacionBean)FacesUtils.getManagedBean("gestacionBean");

         renderPlaneaEmbarazo = true;
         msgplaneaembarazo = "";

         try {
             if (numeroConsulta != null) {
                 antecedente = 
                         this.getServiceLocator().getClinicoService().getAntecedentesGinecologicos(numeroConsulta);

                 consulta = 
                         this.getServiceLocator().getClinicoService().getConsultaActual(numeroConsulta);
                         
                 identi= this.getServiceLocator().getClinicoService().getIdentificacionRiesgos(numeroConsulta);
             }

         } catch (ModelException e) {
             e.printStackTrace();
         }
         if(IConstantes.HISTORIA_ANTICONCEPCION_TEMPORAL.equals(tipoHistoria) || IConstantes.HISTORIA_ANTICONCEPCION_INSERCION.equals(tipoHistoria)){
          
         
             if(consulta !=null && antecedente == null){
         try {
         
             List<Object[]>aux;

             aux = serviceLocator.getClinicoService().getPruebaDeEmbarazoDia(consulta.getHcolusuario().getHuslnumero(),consulta.getHcodfecregistr(),new Date());
             if(aux!=null && !aux.isEmpty()){
                 resultadoPruebEmb=((String)aux.get(0)[0]);
                 fechaPruemb=((Date)aux.get(0)[1]);
                 if(fechaPruemb !=null){
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    String fechaConv=df.format(fechaPruemb);
                    fechaPruemb = new Date();

                        try {
                            fechaPruemb = df.parse(fechaConv);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    if(("NE".equals(resultadoPruebEmb))){
                     resultadoPruebEmb = "N";
                 }
                 else if("PO".equals(resultadoPruebEmb)){
                     resultadoPruebEmb ="S";
                 }
             }
         } catch (ModelException e) {
             FacesUtils.addErrorMessage(e.getMessage());
         }
         }
         }
         if (antecedente == null) {
             if (numeroConsulta != null) {
                 try {
                     lstCuestEster = 
                             this.getServiceLocator().getClinicoService().getCuestionarioEsterilizacion(numeroConsulta);

                 } catch (ModelException e) {
                     e.printStackTrace();
                 }

             }
             antecedente = new Chantegineco();

             if (lstCuestEster != null && !lstCuestEster.isEmpty()) {
                 cuestionarioEster = lstCuestEster.get(0);

                 antecedente.setHagdfup(cuestionarioEster.getHcedfechaparto());
                 antecedente.setHagdfur(cuestionarioEster.getHcedfechultmes());
             }

             Chantegineco antecedenteAux = null;

             try {
                 if (usuario != null) {
                     antecedenteAux = 
                             this.serviceLocator.getClinicoService().getUltimoAntecedentesGinecologicos(usuario.getHuslnumero());
                 }

                 if (antecedenteAux != null) {

                     if (antecedenteAux.getHagnnumgesta() != null) {
                         antecedente.setHagnnumgesta(antecedenteAux.getHagnnumgesta());
                     }
                     if (antecedenteAux.getHagnectopico() != null) {
                         antecedente.setHagnectopico(antecedenteAux.getHagnectopico());
                     }
                     if (antecedenteAux.getHagnmortina() != null) {
                         antecedente.setHagnmortina(antecedenteAux.getHagnmortina());

                     }
                     if (antecedenteAux.getHagnmuerto() != null) {
                         antecedente.setHagnmuerto(antecedenteAux.getHagnmuerto());

                     }
                     if (antecedenteAux.getHagnnumaborto() != null) {
                         antecedente.setHagnnumaborto(antecedenteAux.getHagnnumaborto());

                         if (antecedente != null &&  antecedente.getHagnnumaborto() != null) {
                             if (antecedente != null && 
                                 antecedente.getHagnnumaborto() != null) {
                                 if (antecedente.getHagnnumaborto().compareTo(0) ==  0) {
                                     renderedAbortsprevios = false;
                                     renderedAbortspreviosTres = false;
                                     renderedfechaAbortparto = false;
                                 } else {
                                     if (antecedente.getHagnnumaborto() >= 3) {
                                         renderedAbortsprevios = true;
                                         renderedAbortspreviosTres = true;
                                         renderedfechaAbortparto = true;

                                     } else {

                                         renderedfechaAbortparto = true;
                                         renderedAbortspreviosTres = false;
                                         renderedfechaAbortparto = true;

                                     }
                                 }
                             }
                         }
                     }

                     if (antecedenteAux.getHagnnumcesare() != null) {
                         antecedente.setHagnnumcesare(antecedenteAux.getHagnnumcesare());
                     }
                     if (antecedenteAux.getHagnnumparto() != null) {
                         antecedente.setHagnnumparto(antecedenteAux.getHagnnumparto());
                     }
                     if (antecedenteAux.getHagnnumvivo() != null) {
                         antecedente.setHagnnumvivo(antecedenteAux.getHagnnumvivo());

                     }
                     if (antecedente != null && 
                         antecedenteAux.getHagnmenarquia() != null) {
                         antecedente.setHagnmenarquia(antecedenteAux.getHagnmenarquia());

                     }
                     if (antecedente != null && 
                         antecedenteAux.getHagnedadrelac() != null) {
                         antecedente.setHagnedadrelac(antecedenteAux.getHagnedadrelac());
                     }
                     if (antecedente != null && 
                         antecedente.getHagdfup() == null && 
                         antecedenteAux.getHagdfup() != null) {
                         antecedente.setHagdfup(antecedenteAux.getHagdfup());
                     }


                     if (antecedente != null && 
                         antecedenteAux.getHagcultcitolo() != null) {
                         antecedente.setHagcultcitolo(antecedenteAux.getHagcultcitolo());
                         if (antecedenteAux.getHagcresulcitol() != null) {
                             antecedente.setHagcresulcitol(antecedenteAux.getHagcresulcitol());
                         }

                         if (antecedenteAux.getHagcotroresul() != null) {
                             antecedente.setHagcotroresul(antecedenteAux.getHagcotroresul());
                         }

                         renderResultado = true;
                         if (antecedente.getHagcresulcitol() != null && 
                             antecedente.getHagcresulcitol().equals("2.2")) {
                             renderOtroResultado = true;
                         }
                     }
                 }

                 if (fup != null) {
                     antecedente.setHagdfup(fup);
                 }

                 if (fur != null) {
                     antecedente.setHagdfur(fur);
                 }
                 if (antecedente != null && 
                     antecedente.getHagcconoceufm() != null) {
                     antecedente.setHagcconoceufm(antecedenteAux.getHagcconoceufm());
                    renderConocefun=true;
                 }

             } catch (ModelException e) {
                 capturaError(e,IConstantes.ERROR_COSNULTA);
             }
             antecedente.setHagcrespruemb(resultadoPruebEmb);
             antecedente.setHagdfecpruemb(fechaPruemb);
             if(antecedente.getHagdfecpruemb()!=null){
                 mostrarPruebaEmb = true;
                 pruebaEmbarazo = "S";
                 }
             
             else{
                 mostrarPruebaEmb = false;
                 pruebaEmbarazo = "N";
             }


         } else {
            if(antecedente.getHagdfecpruemb()!=null){
                mostrarPruebaEmb = true;
                pruebaEmbarazo = "S";
            }
            else{
                mostrarPruebaEmb = false;
                pruebaEmbarazo = "N";
            }

             if (antecedente.getHagcplanemba() != null && 
                 antecedente.getHagcplanemba().equals("S")) {
                 msgplaneaembarazo = 
                         "Recuerde orientar a la usuaria a valoraci�n preconcepcional";


             }
             tipoCiclo = antecedente.getHagetipciclo();

             if (tipoCiclo != null && tipoCiclo.equals("I")) {
                 cicloiregular = true;
                 tieneCiclo = true;
                 renderConocefun=true;
                 if("S".equals(antecedente.getHagcconoceufm())){
                     renderMenarquia = true;
                 }
                 else{
                     renderMenarquia = false;
                 }
             } else {
                 cicloiregular = false;
                 renderConocefun=false;
             }

             if (tipoCiclo != null && !tipoCiclo.equals("N")) {
                 tieneCiclo = true;
             }

             if (tipoCiclo != null && tipoCiclo.equals("A")) {
                 tieneCiclo = false;
                 renderMenarquia = true;
             }

             if (antecedente.getHagnnumgesta() != null && 
                 antecedente.getHagnnumgesta().equals(new Integer(0))) {
                 esCeroGestaciones = true;
                 esCeroPartos = true;
             }

             if (antecedente.getHagnnumparto() != null && 
                 antecedente.getHagnnumparto().equals(new Integer(0))) {
                 esCeroPartos = true;
             }

             if (antecedente.getHagnnumaborto() != null && 
                 antecedente.getHagnnumaborto().equals(new Integer(0))) {
                 esCeroAbortos = true;
             }

             if (antecedente.getHagcultcitolo() != null && 
                 !antecedente.getHagcultcitolo().equals("NO")) {
                 renderResultado = true;
                 if (antecedente.getHagcresulcitol() != null && 
                     antecedente.getHagcresulcitol().equals("2.2")) {
                     renderOtroResultado = true;
                 }
             }

             if (antecedente.getHagcmetodoplan() != null && 
                 antecedente.getHagcmetodoplan().equals("0")) {
                 mostrarMetodo = true;
             }

             if (antecedente.getHagcmetodoplan() != null && 
                 antecedente.getHagcmetodoplan().equals("890201.1")) {
                 mostrarInyectable = true;
             }

             if (antecedente.getHagcmetodoplan() != null && 
                 antecedente.getHagcmetodoplan().equals("890201.4")) {
                 mostrarPildoras = true;
                 if (antecedente.getHagcpildouso() != null && 
                     antecedente.getHagcpildouso().equals("S")) {
                     mostrarPildorasSi = true;
                 } else {
                     mostrarPildorasSi = false;
                 }
             }

             if (antecedente.getHagcnoaplica() != null) {
                 if (antecedente.getHagcnoaplica().equals("S")) {
                     mostrarFechaFUP = true;
                 } else {
                     mostrarFechaFUP = false;
                 }
             }
             if (null == antecedente.getHagcevitemba()) {
                 metodoevitaEmbarazo = false;
             } else if (antecedente.getHagcevitemba() != null && 
                        antecedente.getHagcevitemba().equals("S")) {
                 metodoevitaEmbarazo = true;
             } else {
                 metodoevitaEmbarazo = false;
                 renderedUsoCorrectoMetodoIve = false;

             }
             if (null == antecedente.getHagceviembusomet()) {
                 renderedaclaracion = false;
             } else {
                 if (antecedente.getHagceviembusomet().equals("S")) {
                     renderedaclaracion = true;
                 } else {
                     renderedaclaracion = false;
                 }
             }
             if (null == antecedente.getHagcmetoevitemba()) {
                 renderedMetodo = false;
                 renderedUsoCorrectoMetodoIve = false;
                 mostrarFechaInyectable=false;
             } else if (antecedente != null && 
                 antecedente.getHagcmetoevitemba().equals("0")) {
                 renderedMetodo = true;
                 renderedUsoCorrectoMetodoIve = false;
             } else if( antecedente.getHagcmetoevitemba().equals("890201.1") || antecedente.getHagcmetoevitemba().equals("890201.2")) {
                     mostrarFechaInyectable = true;
                     renderedUsoCorrectoMetodoIve = true;
                     renderedMetodo=false;
                 }else if (antecedente != null && 
                        (antecedente.getHagcmetoevitemba().equals("2") || 
                         antecedente.getHagcmetoevitemba().equals("3"))) {
                 renderedMetodo = false;
                 renderedUsoCorrectoMetodoIve = false;
                 mostrarFechaInyectable=false;
             } else {
                 renderedMetodo = false;
                 renderedUsoCorrectoMetodoIve = true;
                 mostrarFechaInyectable=false;
             }
         }


         if (antecedente.getHagcfeabopar() == null || antecedente.getHagcfeabopar().equals("N") ) {
             renderedfechaAbortparto = false;
         } else {
             renderedfechaAbortparto = true;
         }
         
         return null;

     }


     /**
      * @param tipoCiclo
      */
     public void setTipoCiclo(String tipoCiclo) {
         this.tipoCiclo = tipoCiclo;
     }

     /**
      * @param valueChangeEvent
      */
     public void setTipoCiclo(ValueChangeEvent valueChangeEvent) {
         setTipoCiclo((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

     public void setHagcplanemba(ValueChangeEvent valueChangeEvent) {
         antecedente.setHagcplanemba((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }


     /**
      * @param valueChangeEvent
      */
     public void setHagcnoaplica(ValueChangeEvent valueChangeEvent) {
         antecedente.setHagcnoaplica((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

    /**
     * @param valueChangeEvent
     */
    public void setHagcconoceufm(ValueChangeEvent valueChangeEvent) {
        antecedente.setHagcconoceufm((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
     /**
      * @param valueChangeEvent
      */
     public void setHagcresulcitol(ValueChangeEvent valueChangeEvent) {
         antecedente.setHagcresulcitol((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }


     public void setHagcultcitolo(ValueChangeEvent valueChangeEvent) {
         antecedente.setHagcultcitolo((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }
     
     /**
         * @param valueChangeEvent
         */
        public void setTipoUniMedFertilidad(ValueChangeEvent valueChangeEvent) {
            setUniMedFertilidad((String)valueChangeEvent.getNewValue());
            ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }


     /**
      * @param valueChangeEvent
      */
     public void setHagcmetodoplan(ValueChangeEvent valueChangeEvent) {
         antecedente.setHagcmetodoplan((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

     /**
      * @param valueChangeEvent
      */
     public void setHagcpildouso(ValueChangeEvent valueChangeEvent) {
         antecedente.setHagcpildouso((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

     public void setHagnnumparto(ValueChangeEvent valueChangeEvent) {
         antecedente.setHagnnumparto((Integer)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

     /**
      * @return
      */
     public String getTipoCiclo() {
         return tipoCiclo;
     }


     /**
      * @param antecedente
      */
     public void setAntecedente(Chantegineco antecedente) {
         this.antecedente = antecedente;
     }

     /**
      * @return
      */
     public Chantegineco getAntecedente() {
         return antecedente;
     }

     /**
      * @param lstResultado
      */
     public void setLstResultado(List lstResultado) {
         this.lstResultado = lstResultado;
     }

     /**
      * @return
      */
     public List getLstResultado() {
         if (lstResultado == null || lstResultado.isEmpty()) {
             lstResultado = new ArrayList();
             ArrayList<Cndesccito> lstMetodosAux = null;
             try {
                 lstMetodosAux = 
                         (ArrayList<Cndesccito>)this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitotoma", 
                                                                                                                            "ctmcultres");
             } catch (ModelException e) {
                 e.printStackTrace();
             }

             if (!lstMetodosAux.isEmpty()) {

                 lstResultado.add(new SelectItem("", 
                                                 "Seleccione una opcion ..."));
                 Iterator it = lstMetodosAux.iterator();
                 int i = 0;
                 while (it.hasNext()) {
                     it.next();
                     //                                                    lstMetodosAux.get(i).getCdicvalor() + 
                         //                                                    "  " + 
                         lstResultado.add(new SelectItem((lstMetodosAux.get(i).getCdicvalor()), 
                                                         lstMetodosAux.get(i).getCdicdescri()));
                     i++;
                 }
             }
         }
         return lstResultado;
     }


     public void changeResultado() {
         if (antecedente.getHagcresulcitol() != null && 
             antecedente.getHagcresulcitol().equals("2.2")) {
             renderOtroResultado = true;
         } else {
             renderOtroResultado = false;
             antecedente.setHagcotroresul(null);
         }
     }


     /**
      * @param itFechaParto
      */
     public void setItFechaParto(UIInput itFechaParto) {
         this.itFechaParto = itFechaParto;
     }

     /**
      * @return
      */
     public UIInput getItFechaParto() {
         return itFechaParto;
     }

     /**
      * @param itFechaRegla
      */
     public void setItFechaRegla(UIInput itFechaRegla) {
         this.itFechaRegla = itFechaRegla;
     }

     /**
      * @return
      */
     public UIInput getItFechaRegla() {
         return itFechaRegla;
     }

     /**
      * @param itPenFechaRegla
      */
     public void setItPenFechaRegla(UIInput itPenFechaRegla) {
         this.itPenFechaRegla = itPenFechaRegla;
     }

     /**
      * @return
      */
     public UIInput getItPenFechaRegla() {
         return itPenFechaRegla;
     }

     /**
      * @param itAntFechaRegla
      */
     public void setItAntFechaRegla(UIInput itAntFechaRegla) {
         this.itAntFechaRegla = itAntFechaRegla;
     }

     /**
      * @return
      */
     public UIInput getItAntFechaRegla() {
         return itAntFechaRegla;
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
                 if (tipoHistoria != null && 
                     IConstantes.HISTORIA_INTERRUPCION == tipoHistoria) {
                     lstMetodoAux = 
                             (ArrayList<Chmetodoplan>)this.serviceLocator.getClinicoService().getMetodosPlanificacionIve(SEXO_FEMENINO);
                 } else {
                     lstMetodoAux = 
                             (ArrayList<Chmetodoplan>)this.serviceLocator.getClinicoService().getMetodosPlanificacion(SEXO_FEMENINO);
                 }
             } catch (ModelException e) {
                 e.printStackTrace();
             }

             if (!lstMetodoAux.isEmpty()) {

                 Iterator it = lstMetodoAux.iterator();
                 int i = 0;
                 lstMetodo.add(new SelectItem("", "Seleccione una opci�n ..."));
                 while (it.hasNext()) {
                     it.next();
                     lstMetodo.add(new SelectItem(lstMetodoAux.get(i).getHmpccodigo(), 
                                                  lstMetodoAux.get(i).getHmpcdescripcio()));
                     i++;
                 }
             }
         }

         return lstMetodo;
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
      * @param consulta
      */
     public void setConsulta(Chconsulta consulta) {
         this.consulta = consulta;
     }

     /**
      * @return
      */
     public Chconsulta getConsulta() {
         return consulta;
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
      * @param lstTipoCiclo
      */
     public void setLstTipoCiclo(List<SelectItem> lstTipoCiclo) {
         this.lstTipoCiclo = lstTipoCiclo;
     }

     public List<SelectItem> getLstTipoCiclo() {
         if (lstTipoCiclo == null || lstTipoCiclo.isEmpty()) {
             lstTipoCiclo = new ArrayList<SelectItem>();
             lstTipoCiclo.add(new SelectItem("", "Seleccione una opci�n "));
             lstTipoCiclo.add(new SelectItem("I", "Irregular"));
             lstTipoCiclo.add(new SelectItem("R", "Regular"));
             lstTipoCiclo.add(new SelectItem("N", "No ha Tenido Menarquia"));
             lstTipoCiclo.add(new SelectItem("A", "Amenorrea"));
         }
         return lstTipoCiclo;
     }

     /**
      * @param lstUltimaCitologia
      */
     public void setLstUltimaCitologia(List<SelectItem> lstUltimaCitologia) {
         this.lstUltimaCitologia = lstUltimaCitologia;
     }

     public List<SelectItem> getLstUltimaCitologia() {
         if (lstUltimaCitologia == null || lstUltimaCitologia.isEmpty()) {
             lstUltimaCitologia = new ArrayList<SelectItem>();
             lstUltimaCitologia.add(new SelectItem("", 
                                                   "Seleccione una opci�n "));
             lstUltimaCitologia.add(new SelectItem("NO", "Nunca"));
             lstUltimaCitologia.add(new SelectItem("-1", 
                                                   "Hace menos de un ano"));
             lstUltimaCitologia.add(new SelectItem("+1", "Hace mas de un ano"));
             lstUltimaCitologia.add(new SelectItem("NR", "No recuerda"));
         }
         return lstUltimaCitologia;
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
      * @param mostrarReporte
      */
     public void setMostrarReporte(boolean mostrarReporte) {
         this.mostrarReporte = mostrarReporte;
     }

     /**
      * @return
      */
     public boolean isMostrarReporte() {
         return mostrarReporte;
     }

     /**
      * @param mostrarMetodo
      */
     public void setMostrarMetodo(boolean mostrarMetodo) {
         this.mostrarMetodo = mostrarMetodo;
     }

     /**
      * @return
      */
     public boolean isMostrarMetodo() {
         return mostrarMetodo;
     }

     /**
      * @param ocultarmensaje
      */
     public void setOcultarmensaje(boolean ocultarmensaje) {
         this.ocultarmensaje = ocultarmensaje;
     }

     /**
      * @return
      */
     public boolean isOcultarmensaje() {
         return ocultarmensaje;
     }

     /**
      * @param renderMenarquia
      */
     public void setRenderMenarquia(boolean renderMenarquia) {
         this.renderMenarquia = renderMenarquia;
     }

     /**
      * @return
      */
     public boolean isRenderMenarquia() {
         return renderMenarquia;
     }


     public void changeTipo() {
         if (tipoCiclo != null) {
             if (tipoCiclo.equals("N")) {
                 tieneCiclo = false;
                 renderMenarquia = false;
                 renderConocefun=false;
             }
             if (tipoCiclo.equals("A")) {
                 tieneCiclo = false;
                 renderMenarquia = true;
                 renderConocefun=false;
             }

             if (tipoCiclo.equals("R")) {
                 tieneCiclo = true;
                 renderMenarquia = true;
                 renderConocefun=true;
             }

             if (tipoCiclo.equals("I")) {
                 cicloiregular = true;
                
                 tieneCiclo = true;
                 renderConocefun=true;
                 if(antecedente.getHagcconoceufm()!=null && antecedente.getHagcconoceufm().equals("S")){
                     renderMenarquia = true;
                 }
                 else{
                     renderMenarquia = false;
                 }

             } else {
                 Integer num = null;
                 antecedente.setHagnfrefincicl(num);
                 antecedente.setHagndurfincicl(num);
                 cicloiregular = false;
                 renderConocefun=false;
             }
         }
     }

     public void changeFecha() {
         if (antecedente.getHagcnoaplica() != null) {
             if (antecedente.getHagcnoaplica().equals("S")) {
                 mostrarFechaFUP = true;
             } else {
                 mostrarFechaFUP = false;
             }
         }
     }

    public void changeConoceFUM() {
        if (antecedente.getHagcconoceufm() != null) {
            if (antecedente.getHagcconoceufm().equals("S")) {
                renderMenarquia = true;
            } else {
                renderMenarquia = false;
                antecedente.setHagdfur(null);
            }
        }
    }

     /**
      * @param camposRequeridos
      */
     public void setCamposRequeridos(boolean camposRequeridos) {
         this.camposRequeridos = camposRequeridos;
     }

     /**
      * @return
      */
     public boolean isCamposRequeridos() {
         return camposRequeridos;
     }

     /**
      * @param semanaEmbarazo
      */
     public void setSemanaEmbarazo(Integer semanaEmbarazo) {
         this.semanaEmbarazo = semanaEmbarazo;
     }

     /**
      * @return
      */
     public Integer getSemanaEmbarazo() {
         return semanaEmbarazo;
     }

     /**
      * @param valueChangeEvent
      */
     public void setNumeroGestaciones(ValueChangeEvent valueChangeEvent) {
         antecedente.setHagnnumgesta((Integer)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

     /**
      * @param valueChangeEvent
      */
     public void setNumeroAbortos(ValueChangeEvent valueChangeEvent) {
         antecedente.setHagnnumaborto((Integer)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

     /**
      * @param valueChangeEvent
      */
     public void setNumeroCesarias(ValueChangeEvent valueChangeEvent) {
         antecedente.setHagnnumcesare((Integer)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

     /**
      * @param valueChangeEvent
      */
     public void setNumeroMortinatos(ValueChangeEvent valueChangeEvent) {
         antecedente.setHagnmortina((Integer)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

     /**
      * @param valueChangeEvent
      */
     public void setNumeroMolas(ValueChangeEvent valueChangeEvent) {
         antecedente.setHagnmuerto((Integer)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

     /**
      * @param valueChangeEvent
      */
     public void setNumeroEctopicos(ValueChangeEvent valueChangeEvent) {
         antecedente.setHagnectopico((Integer)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

     /**
      * @param valueChangeEvent
      */
     public void setHagnedadrelac(ValueChangeEvent valueChangeEvent) {
         antecedente.setHagnedadrelac((Integer)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }


     /**
      * @param esCeroGestaciones
      */
     public void setEsCeroGestaciones(boolean esCeroGestaciones) {
         this.esCeroGestaciones = esCeroGestaciones;
     }

     /**
      * @return
      */
     public boolean isEsCeroGestaciones() {
         return esCeroGestaciones;
     }

     /**
      * @param cicloiregular
      */
     public void setCicloiregular(boolean cicloiregular) {
         this.cicloiregular = cicloiregular;
     }

     /**
      * @return
      */
     public boolean isCicloiregular() {
         return cicloiregular;
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
      * @param tieneCiclo
      */
     public void setTieneCiclo(boolean tieneCiclo) {
         this.tieneCiclo = tieneCiclo;
     }

     /**
      * @return
      */
     public boolean isTieneCiclo() {
         return tieneCiclo;
     }


     /**
      * @param renderEctopicos
      */
     public void setRenderEctopicos(boolean renderEctopicos) {
         this.renderEctopicos = renderEctopicos;
     }

     /**
      * @return
      */
     public boolean isRenderEctopicos() {
         return renderEctopicos;
     }

     /**
      * @param renderMortinatos
      */
     public void setRenderMortinatos(boolean renderMortinatos) {
         this.renderMortinatos = renderMortinatos;
     }

     /**
      * @return
      */
     public boolean isRenderMortinatos() {
         return renderMortinatos;
     }

     /**
      * @param renderMolas
      */
     public void setRenderMolas(boolean renderMolas) {
         this.renderMolas = !renderMolas;
     }

     /**
      * @param itNumGesta
      */
     public void setItNumGesta(UIInput itNumGesta) {
         this.itNumGesta = itNumGesta;
     }

     /**
      * @return
      */
     public UIInput getItNumGesta() {
         return itNumGesta;
     }

     /**
      * @param itNumPartos
      */
     public void setItNumPartos(UIInput itNumPartos) {
         this.itNumPartos = itNumPartos;
     }

     /**
      * @return
      */
     public UIInput getItNumPartos() {
         return itNumPartos;
     }

     /**
      * @param itNumAbortos
      */
     public void setItNumAbortos(UIInput itNumAbortos) {
         this.itNumAbortos = itNumAbortos;
     }

     /**
      * @return
      */
     public UIInput getItNumAbortos() {
         return itNumAbortos;
     }

     /**
      * @param itNumcesareas
      */
     public void setItNumcesareas(UIInput itNumcesareas) {
         this.itNumcesareas = itNumcesareas;
     }

     /**
      * @return
      */
     public UIInput getItNumcesareas() {
         return itNumcesareas;
     }

     /**
      * @param itNumHijosVivos
      */
     public void setItNumHijosVivos(UIInput itNumHijosVivos) {
         this.itNumHijosVivos = itNumHijosVivos;
     }

     /**
      * @return
      */
     public UIInput getItNumHijosVivos() {
         return itNumHijosVivos;
     }

     /**
      * @param itNumEctopicos
      */
     public void setItNumEctopicos(UIInput itNumEctopicos) {
         this.itNumEctopicos = itNumEctopicos;
     }

     /**
      * @return
      */
     public UIInput getItNumEctopicos() {
         return itNumEctopicos;
     }

     /**
      * @param itNumHijosMortinatos
      */
     public void setItNumHijosMortinatos(UIInput itNumHijosMortinatos) {
         this.itNumHijosMortinatos = itNumHijosMortinatos;
     }

     /**
      * @return
      */
     public UIInput getItNumHijosMortinatos() {
         return itNumHijosMortinatos;
     }

     /**
      * @param itNumHijosMuertos
      */
     public void setItNumHijosMuertos(UIInput itNumHijosMuertos) {
         this.itNumHijosMuertos = itNumHijosMuertos;
     }

     /**
      * @return
      */
     public UIInput getItNumHijosMuertos() {
         return itNumHijosMuertos;
     }

     /**
      * @param fur
      */
     public void setFur(Date fur) {
         this.fur = fur;
     }

     /**
      * @return
      */
     public Date getFur() {
         return fur;
     }

     /**
      * @param fup
      */
     public void setFup(Date fup) {
         this.fup = fup;
     }

     /**
      * @return
      */
     public Date getFup() {
         return fup;
     }

     /**
      * @param renderOtroResultado
      */
     public void setRenderOtroResultado(boolean renderOtroResultado) {
         this.renderOtroResultado = renderOtroResultado;
     }

     /**
      * @return
      */
     public boolean isRenderOtroResultado() {
         return renderOtroResultado;
     }

     /**
      * @param mnuResultado
      */
     public void setMnuResultado(UIInput mnuResultado) {
         this.mnuResultado = mnuResultado;
     }

     /**
      * @return
      */
     public UIInput getMnuResultado() {
         return mnuResultado;
     }

     /**
      * @param mnuUltima
      */
     public void setMnuUltima(UIInput mnuUltima) {
         this.mnuUltima = mnuUltima;
     }

     /**
      * @return
      */
     public UIInput getMnuUltima() {
         return mnuUltima;
     }

     /**
      * @return
      */
     public boolean isRenderMolas() {
         return renderMolas;
     }

     /**
      * @param renderCiclos
      */
     public void setRenderCiclos(boolean renderCiclos) {
         this.renderCiclos = renderCiclos;
     }

     /**
      * @return
      */
     public boolean isRenderCiclos() {
         return renderCiclos;
     }

     /**
      * @param renderResultado
      */
     public void setRenderResultado(boolean renderResultado) {
         this.renderResultado = renderResultado;
     }

     /**
      * @return
      */
     public boolean isRenderResultado() {
         return renderResultado;
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

     public void setEsIlve(boolean esIlve) {
         this.esIlve = esIlve;
     }

     public boolean isEsIlve() {
         return esIlve;
     }

     public void setEsFertilidad(boolean esFertilidad) {
         this.esFertilidad = esFertilidad;
     }

     public boolean isEsFertilidad() {
         return esFertilidad;
     }

    public void setEsAnticoncepcionTemporal(boolean esAnticoncepcionTemporal) {
        this.esAnticoncepcionTemporal = esAnticoncepcionTemporal;
    }

    public boolean isEsAnticoncepcionTemporal() {
        return esAnticoncepcionTemporal;
    }


     public void setEsCeroPartos(boolean esCeroPartos) {
         this.esCeroPartos = esCeroPartos;
     }

     public boolean isEsCeroPartos() {
         return esCeroPartos;
     }

     public void setEsCeroAbortos(boolean esCeroAbortos) {
         this.esCeroAbortos = esCeroAbortos;
     }

     public boolean isEsCeroAbortos() {
         return esCeroAbortos;
     }


     public void setNoAplica(String noAplica) {
         this.noAplica = noAplica;
     }

     public String getNoAplica() {
         return noAplica;
     }

     public void setMostrarFechaFUP(boolean mostrarFechaFUP) {
         this.mostrarFechaFUP = mostrarFechaFUP;
     }

     public boolean isMostrarFechaFUP() {
         return mostrarFechaFUP;
     }

     public void setMostrarInyectable(boolean mostrarInyectable) {
         this.mostrarInyectable = mostrarInyectable;
     }

     public boolean isMostrarInyectable() {
         return mostrarInyectable;
     }

     public void setMostrarPildoras(boolean mostrarPildoras) {
         this.mostrarPildoras = mostrarPildoras;
     }

     public boolean isMostrarPildoras() {
         return mostrarPildoras;
     }

     public void setMostrarPildorasSi(boolean mostrarPildorasSi) {
         this.mostrarPildorasSi = mostrarPildorasSi;
     }

     public boolean isMostrarPildorasSi() {
         return mostrarPildorasSi;
     }

     public void setItNumNacidosVivos(UIInput itNumNacidosVivos) {
         this.itNumNacidosVivos = itNumNacidosVivos;
     }

     public UIInput getItNumNacidosVivos() {
         return itNumNacidosVivos;
     }

     public boolean esValido() {
         Chantegineco antecedenteAux = null;
         boolean esValido = false;
         boolean esValidoObstetricos = true;
         if (numeroConsulta != null) {
             try {
                 antecedenteAux = 
                         this.getServiceLocator().getClinicoService().getAntecedentesGinecologicos(numeroConsulta);
             } catch (ModelException e) {
                 e.printStackTrace();
             }
         }

         if (antecedenteAux != null) {
             esValido = true;
         } else {
             esValido = false;
         }
         if (!esValidoObstetricos) {
             esValido = false;
         }
         return esValido;
     }

     public void ChangePildoras() {
         if (antecedente != null && antecedente.getHagcpildouso() != null && 
             antecedente.getHagcpildouso().equals("S")) {
             mostrarPildorasSi = true;
         } else {
             mostrarPildorasSi = false;
             antecedente.setHagcpildoobser(null);
         }
     }


     public void ChangeMetodo() {

         if (antecedente != null && 
             antecedente.getHagcmetodoplan().equals("0")) {
             mostrarMetodo = true;
             mostrarInyectable = false;
             antecedente.setHagdfeultiapl(null);
             mostrarPildoras = false;
             mostrarPildorasSi = false;
             antecedente.setHagcpildoobser(null);
             antecedente.setHagcpildouso(null);
         } else if (antecedente != null && 
                    antecedente.getHagcmetodoplan().equals("890201.1")) {
             mostrarMetodo = false;
             antecedente.setHagcotrometodo(null);
             mostrarInyectable = true;
             mostrarPildoras = false;
             mostrarPildorasSi = false;
             antecedente.setHagcpildoobser(null);
             antecedente.setHagcpildouso(null);
         } else if (antecedente != null && 
                    antecedente.getHagcmetodoplan().equals("890201.2")) {
             mostrarMetodo = false;
             antecedente.setHagcotrometodo(null);
             mostrarInyectable = true;
             antecedente.setHagdfeultiapl(null);
             mostrarPildoras = false;
             mostrarPildorasSi = false;
             antecedente.setHagcpildoobser(null);
             antecedente.setHagcpildouso(null);
         } else if (antecedente != null && 
                    antecedente.getHagcmetodoplan().equals("890201.4")) {
             mostrarMetodo = false;
             antecedente.setHagcotrometodo(null);
             mostrarInyectable = false;
             antecedente.setHagdfeultiapl(null);
             mostrarPildoras = true;
             if (antecedente.getHagcpildouso() != null && 
                 antecedente.getHagcpildouso().equals("S")) {
                 mostrarPildorasSi = true;
             } else {
                 mostrarPildorasSi = false;
             }
         } else {
             mostrarMetodo = false;
             antecedente.setHagcotrometodo(null);
             mostrarInyectable = false;
             antecedente.setHagdfeultiapl(null);
             mostrarPildoras = false;
             mostrarPildorasSi = false;
             antecedente.setHagcpildoobser(null);
             antecedente.setHagcpildouso(null);
         }
     }


     public void changeNumeroGestaciones() {

         if (antecedente != null && antecedente.getHagnnumgesta() != null) {
             // Verificamos si el numero de gestaciones es cero los campos de partos, abortos, cesareas
             // vivos, ectopicos, mortinatos e hijos muertos es cero.
             if (antecedente.getHagnnumgesta().compareTo(0) == 0) {
                 antecedente.setHagnectopico(0);
                 antecedente.setHagnmortina(0);
                 antecedente.setHagnmuerto(0);
                 antecedente.setHagnnumaborto(0);
                 antecedente.setHagnnumcesare(0);
                 antecedente.setHagnnumparto(0);
                 antecedente.setHagnnumvivo(0);
                 antecedente.setHagnnacivivo(0);


                 itNumPartos.setValue(0);
                 itNumAbortos.setValue(0);
                 itNumcesareas.setValue(0);
                 itNumHijosVivos.setValue(0);
                 itNumNacidosVivos.setValue(0);
                 itNumEctopicos.setValue(0);
                 itNumHijosMortinatos.setValue(0);
                 itNumHijosMuertos.setValue(0);


                 esCeroGestaciones = true;
                 esCeroPartos = true;
                 esCeroAbortos = true;
             } else {
                 Integer numero = null;
                 esCeroGestaciones = false;
                 esCeroPartos = false;
                 esCeroAbortos = false;
                 antecedente.setHagnectopico(numero);
                 antecedente.setHagnmortina(numero);
                 antecedente.setHagnmuerto(numero);
                 antecedente.setHagnnumaborto(numero);
                 antecedente.setHagnnumcesare(numero);
                 antecedente.setHagnnumparto(numero);
                 antecedente.setHagnnumvivo(numero);
                 antecedente.setHagnnacivivo(numero);


                 itNumPartos.setValue(numero);
                 itNumAbortos.setValue(numero);
                 itNumcesareas.setValue(numero);
                 itNumHijosVivos.setValue(numero);
                 itNumEctopicos.setValue(numero);
                 itNumHijosMortinatos.setValue(numero);
                 itNumHijosMuertos.setValue(numero);
                 itNumNacidosVivos.setValue(0);
                 itFechaParto.setValue(null);
             }
         }
     }


     public void changeNumeroParto() {

         if (antecedente != null && antecedente.getHagnnumparto() != null) {
             // Verificamos si el numero de gestaciones es cero los campos de partos, abortos, cesareas
             // vivos, ectopicos, mortinatos e hijos muertos es cero.
             changeValidacionItemsEmbarazos();
             if (antecedente.getHagnnumparto().compareTo(0) == 0) {


                 esCeroPartos = true;
             } else {
                 esCeroPartos = false;
                 itFechaParto.setValue(null);
             }
         }
     }

     public void changeNumeroAbortos() {
         if (antecedente != null && antecedente.getHagnnumaborto() != null) {
             changeValidacionItemsEmbarazos();
             if (antecedente.getHagnnumaborto().compareTo(0) == 0) {
                 esCeroAbortos = true;
             } else {
                 esCeroAbortos = false;
             }
         }
     }

     public boolean changeValidacionItemsEmbarazos() {
         if (antecedente != null && antecedente.getHagnnumgesta() != null) {
             if (antecedente.getHagnnumgesta().compareTo(0) != 0) {
                 int gestaciones = antecedente.getHagnnumgesta();
                 int suma = 0;

                 if (antecedente.getHagnectopico() != null) {
                     suma = suma + antecedente.getHagnectopico();
                 }
                 if (antecedente.getHagnmortina() != null) {
                     suma = suma + antecedente.getHagnmortina();
                 }
                 if (antecedente.getHagnmuerto() != null) {
                     suma = suma + antecedente.getHagnmuerto();
                 }
                 if (antecedente.getHagnnumaborto() != null) {
                     suma = suma + antecedente.getHagnnumaborto();
                 }
                 if (antecedente.getHagnnumcesare() != null) {
                     suma = suma + antecedente.getHagnnumcesare();
                 }
                 if (antecedente.getHagnnumparto() != null) {
                     suma = suma + antecedente.getHagnnumparto();
                 }

                 if (gestaciones < suma) {
                     if (!renderedInterrupcion) {
                         FacesUtils.addErrorMessage("Cerciorese de los datos de la formula obstetrica");
                     }
                     return false;
                 } else {
                     return true;
                 }
             }
         }
         return true;

     }

     public void changeNumeroCesarias() {
         if (antecedente != null && antecedente.getHagnnumcesare() != null) {
             changeValidacionItemsEmbarazos();

         }
     }

     public void changeNumeroMortinatos() {
         if (antecedente != null && antecedente.getHagnmortina() != null) {
             changeValidacionItemsEmbarazos();
         }
     }

     public void changeNumeroMolas() {
         if (antecedente != null && antecedente.getHagnmuerto() != null) {
             changeValidacionItemsEmbarazos();
         }
     }

     public void changeNumeroEctopicos() {
         if (antecedente != null && antecedente.getHagnectopico() != null) {
             changeValidacionItemsEmbarazos();
         }
     }

     public void changeEdadPrimeraRelacion() {
         if (antecedente != null && antecedente.getHagnedadrelac() != null) {
             int resultado = antecedente.getHagnedadrelac().compareTo(14);
             if (resultado < 0 || resultado == 0) {
                 FacesUtils.addErrorMessage("Esto corresponde a un acto delictivo por favor verificar informaci�n.");
             }
         }
     }


     public void calcularSemana() {
         Date fechaHoy = new Date();
         semanaEmbarazo = 0;
         Date fechaUltimaRegla = null;
         if (antecedente != null && antecedente.getHagdfur() != null) {
             fechaUltimaRegla = antecedente.getHagdfur();
         }

         if (fechaUltimaRegla != null && fechaHoy != null) {
             double time = 0;
             int numero = 0;
             time = fechaHoy.getTime() - fechaUltimaRegla.getTime();
             numero = (int)java.lang.Math.ceil((time / (3600 * 24 * 1000)));
             semanaEmbarazo = numero / 7;
         }

     }


     public void changeUltimaCitologia() {
         if (!antecedente.getHagcultcitolo().equals("NO")) {
             renderResultado = true;
         } else {
             antecedente.setHagcresulcitol(null);
             renderResultado = false;
             renderOtroResultado = false;
             mnuResultado.setValue(null);
             antecedente.setHagcotroresul(null);
         }
     }

     public String aceptar() {

         navigationRule = "";
         wexito = true;
         mostrarMensajeEmbarazo = false;
         mostrarReporte = false;
         ChanteginecoPK id = new ChanteginecoPK();
         String urlAux = 
             "body:formAntecedentesGinecologicos:panelTabAntecedentesGinecologicos:";


         if (wexito) {

             if (!renderResultado) {
                 antecedente.setHagcresulcitol(null);
                 antecedente.setHagcotroresul(null);
             }

             if (!renderOtroResultado) {
                 antecedente.setHagcotroresul(null);
             }

             if (antecedente != null) {

                 if (antecedente.getHagcultcitolo() != null && 
                     !antecedente.getHagcultcitolo().equals("NO")) {
                     if (antecedente.getHagcresulcitol() == null || 
                         antecedente.getHagcresulcitol().equals("")) {
                         wexito = false;
                         FacesUtils.addErrorMessage(urlAux + 
                                                    "mnuResultadoGineco", 
                                                    MSG_CAMPO_OBLIGATORIO);
                     }

                     if (antecedente.getHagcresulcitol() != null && 
                         antecedente.getHagcresulcitol().equals("2.2")) {
                         if (antecedente.getHagcotroresul() == null || 
                             antecedente.getHagcotroresul().equals("")) {
                             wexito = false;
                             FacesUtils.addErrorMessage(urlAux + 
                                                        "itOtrosHallazgos", 
                                                        MSG_CAMPO_OBLIGATORIO);
                         }

                     }

                 }

                 changeValidacionItemsEmbarazos();
                 if (antecedente.getHagnnumcesare() != null && antecedente.getHagnnumcesare() != 0) {
                     if (identi != null && antecedente.getHagnnumcesare() != null && antecedente.getHagnnumcesare() == 1) {
                         identi.setHidecunceananin("S");
                     } else if (identi != null && antecedente.getHagnnumcesare() != null && antecedente.getHagnnumcesare() >= 2) {
                         identi.setHidecdosmasces("S");
                     }

                 }
                 if (antecedente.getHagclactaexclu() == null || 
                     antecedente.getHagclactaexclu().equals("")) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "mnuLactancia", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }

                 if (antecedente.getHagcmetodanter() == null || 
                     antecedente.getHagcmetodanter().equals("")) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + 
                                                "mnuMetodoPlanificacionAnterior", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }


                 if (!esIlve && 
                     (antecedente.getHagcrelacsexua() == null || antecedente.getHagcrelacsexua().equals(""))) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + 
                                                "mnuRelacionesSexuales", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }


                 if (antecedente.getHagnnumgesta() == null) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "itNumGesta", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }

                 if (antecedente.getHagnnumparto() == null) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "itNumPartos", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }
                 else{
                     wexito = true;
                 }

                 if (antecedente.getHagnnumaborto() == null) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "itNumAbortos", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }

                 if (antecedente.getHagnnumcesare() == null) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "itNumcesareas", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }

                 if (antecedente.getHagnnumvivo() == null) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "itNumHijosVivos", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }


                 if (antecedente.getHagnnacivivo() == null) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "itNumHijoNacidoVivo", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }

                 if (antecedente.getHagnectopico() == null) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "itNumEctopicos", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }

                 if (antecedente.getHagnmortina() == null) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "itNumHijosMortinatos", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }

                 if (antecedente.getHagnmuerto() == null) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "itNumHijosMuertos", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }

                 if (antecedente.getHagnnumparto() != null && 
                     antecedente.getHagnnumparto() > 0 && !esIlve) {
                     if (antecedente.getHagdfup() == null) {
                         wexito = false;
                         FacesUtils.addErrorMessage(urlAux + 
                                                    "calendarUltimoParto", 
                                                    MSG_CAMPO_OBLIGATORIO);
                     }
                 }


                 if (antecedente != null && 
                     antecedente.getHagcmetodoplan() != null && 
                     antecedente.getHagcmetodoplan().equals("0")) {
                     if (antecedente.getHagcotrometodo() == null || 
                         antecedente.getHagcotrometodo().equals("")) {
                         wexito = false;
                         FacesUtils.addErrorMessage(urlAux + "inputOtroMetodo", 
                                                    MSG_CAMPO_OBLIGATORIO);
                     }

                 }

                 if (tipoCiclo == null || tipoCiclo.equals("")) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "radioTipoCiclo", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }

                 if (tipoCiclo != null) {
                     if (tipoCiclo.equals("I")) {

                         if (antecedente != null) {
                         
                            if(!esIlve){
                                if (antecedente.getHagnfreciclo() == null) {
                                    wexito = false;
                                    FacesUtils.addErrorMessage(urlAux + 
                                                               "itFrecuencia", 
                                                               MSG_CAMPO_OBLIGATORIO);
                                }

                                if (antecedente.getHagnfrefincicl() == null) {
                                    wexito = false;
                                    FacesUtils.addErrorMessage(urlAux + 
                                                               "itFrecuenciaFinal", 
                                                               MSG_CAMPO_OBLIGATORIO);
                                }
    
                            }
                            
                             if (antecedente.getHagndurciclo() == null) {
                                 wexito = false;
                                 FacesUtils.addErrorMessage(urlAux + 
                                                            "itDuracion", 
                                                            MSG_CAMPO_OBLIGATORIO);
                             }

                             if (antecedente.getHagnmenarquia() == null) {
                                 wexito = false;
                                 FacesUtils.addErrorMessage(urlAux + 
                                                            "itEdadMenarquia", 
                                                            MSG_CAMPO_OBLIGATORIO);
                             }
                             

                             if (antecedente.getHagdfur() == null) {
                                 wexito = false;
                                 FacesUtils.addErrorMessage(urlAux + 
                                                            "calendarUltimaRegla", 
                                                            MSG_CAMPO_OBLIGATORIO);
                             }
                         }

                     }


                     if (tipoCiclo.equals("R")) {
                         antecedente.setHagnfrefincicl(null);
                         antecedente.setHagndurfincicl(null);

                         if (antecedente.getHagnfreciclo() == null) {
                             wexito = false;
                             FacesUtils.addErrorMessage(urlAux + "itFrecuencia", 
                                                        MSG_CAMPO_OBLIGATORIO);
                         }


                         if (antecedente.getHagndurciclo() == null) {
                             wexito = false;
                             FacesUtils.addErrorMessage(urlAux + "itDuracion", 
                                                        MSG_CAMPO_OBLIGATORIO);
                         }


                         if (antecedente.getHagnmenarquia() == null) {
                             wexito = false;
                             FacesUtils.addErrorMessage(urlAux + 
                                                        "itEdadMenarquia", 
                                                        MSG_CAMPO_OBLIGATORIO);
                         }

                         if (antecedente.getHagdfur() == null) {
                             wexito = false;
                             FacesUtils.addErrorMessage(urlAux + 
                                                        "calendarUltimaRegla", 
                                                        MSG_CAMPO_OBLIGATORIO);
                         }

                     }


                     if (tipoCiclo.equals("A")) {

                         antecedente.setHagnfrefincicl(null);
                         antecedente.setHagndurfincicl(null);
                         antecedente.setHagnfreciclo(null);
                         antecedente.setHagndurciclo(null);

                         if (antecedente.getHagnmenarquia() == null) {
                             wexito = false;
                             FacesUtils.addErrorMessage(urlAux + 
                                                        "itEdadMenarquia", 
                                                        MSG_CAMPO_OBLIGATORIO);
                         }

                         if (antecedente.getHagdfur() == null) {
                             wexito = false;
                             FacesUtils.addErrorMessage(urlAux + 
                                                        "calendarUltimaRegla", 
                                                        MSG_CAMPO_OBLIGATORIO);
                         }

                     }

                     if (tipoCiclo.equals("N")) {
                         antecedente.setHagnfrefincicl(null);
                         antecedente.setHagndurfincicl(null);
                         antecedente.setHagnfreciclo(null);
                         antecedente.setHagndurciclo(null);
                         antecedente.setHagnmenarquia(null);

                     }

                 }

             }


         }


         if (tipoCiclo != null && tipoCiclo.equals("N")) {
             tieneCiclo = false;
             renderMenarquia = false;
             antecedente.setHagnfreciclo(null);
             antecedente.setHagnfrefincicl(null);
             antecedente.setHagndurciclo(null);
             antecedente.setHagndurfincicl(null);
             antecedente.setHagnmenarquia(null);
             antecedente.setHagdfur(null);

             antecedente.setHagcultcitolo("NO");

         }

         if (tipoCiclo != null && tipoCiclo.equals("A")) {
             tieneCiclo = false;
             renderMenarquia = true;
             antecedente.setHagnfreciclo(null);
             antecedente.setHagnfrefincicl(null);
             antecedente.setHagndurciclo(null);
             antecedente.setHagndurfincicl(null);
         }

         if (numeroConsulta != null) {
             id.setHaglconsulta(numeroConsulta);
             id.setHagctiposervi(tipoServicio);
             antecedente.setId(id);
         }

         antecedente.setHagdfecregistr(new Date());
         antecedente.setHagcoperador(userName());


         if (tipoCiclo != null) {
             antecedente.setHagetipciclo(tipoCiclo);

             if (tipoCiclo.equals("R")) {
                 antecedente.setHagnfrefincicl(null);
                 antecedente.setHagndurfincicl(null);
             }

             if (wexito && tipoCiclo.equals("I") && !ocultarmensaje) {
                 mostrarMensajeEmbarazo = true;
                 FacesUtils.addErrorMessage(MSG_EMBARAZO);
             }
         }

         if (antecedente != null) {
             if (antecedente.getHagdfur() != null) {
                 java.util.Date fechaUltimaRegla = 
                     new Date(antecedente.getHagdfur().getTime());
                 Calendar fechaAuxUR = Calendar.getInstance();
                 fechaAuxUR.setTime(fechaUltimaRegla);
                 fechaAuxUR.add(Calendar.DAY_OF_YEAR, 30);
                 Date fechacomp = new Date();

                 if (fechaUltimaRegla.compareTo(fechacomp) > 0) {
                     wexito = false;
                     FacesUtils.addErrorMessage(MSG_FECHA_ULTIMA_REGLA_NO_VALIDA);
                 }

                 if (fechaAuxUR.getTime().compareTo(fechacomp) < 0 && 
                     !mostrarMensajeEmbarazo && !ocultarmensaje) {
                     FacesUtils.addErrorMessage(MSG_EMBARAZO);
                 }
             }

             Date fechacomp = new Date();
             if (antecedente.getHagdfup() != null) {
                 Date fechaUltimoParto = 
                     new Date(antecedente.getHagdfup().getTime());
                 if (fechaUltimoParto.compareTo(fechacomp) > 0) {
                     wexito = false;
                     FacesUtils.addErrorMessage(MSG_FECHA_ULTIMO_PARTO_NO_VALIDA);
                 }
             }

         }
         
         if(renderedInterrupcion){
         wexito=true;
             if (!renderResultado) {
                 antecedente.setHagcresulcitol(null);
                 antecedente.setHagcotroresul(null);
             }

             if (!renderOtroResultado) {
                 antecedente.setHagcotroresul(null);
             }

             if (antecedente != null) {

                 if (antecedente.getHagcultcitolo() != null && 
                     !antecedente.getHagcultcitolo().equals("NO")) {
                     if (antecedente.getHagcresulcitol() == null || 
                         antecedente.getHagcresulcitol().equals("")) {
                         wexito = false;
                         FacesUtils.addErrorMessage(urlAux + 
                                                    "mnuResultadoGineco", 
                                                    MSG_CAMPO_OBLIGATORIO);
                     }

                     if (antecedente.getHagcresulcitol() != null && 
                         antecedente.getHagcresulcitol().equals("2.2")) {
                         if (antecedente.getHagcotroresul() == null || 
                             antecedente.getHagcotroresul().equals("")) {
                             wexito = false;
                             FacesUtils.addErrorMessage(urlAux + 
                                                        "itOtrosHallazgos", 
                                                        MSG_CAMPO_OBLIGATORIO);
                         }

                     }

                 }

                 changeValidacionItemsEmbarazos();
                 if (antecedente.getHagnnumcesare() != null && antecedente.getHagnnumcesare() != 0) {
                     if (antecedente.getHagnnumcesare() == 1) {
                         identi.setHidecunceananin("S");
                     } else if (antecedente.getHagnnumcesare() >= 2) {
                         identi.setHidecdosmasces("S");
                     }

                 }
                 if (antecedente.getHagclactaexclu() == null || 
                     antecedente.getHagclactaexclu().equals("")) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "mnuLactancia", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }

           

                 if (antecedente.getHagnnumgesta() == null) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "itNumGesta", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }

                 if (antecedente.getHagnnumparto() == null) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "itNumPartos", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }
               

                 if (antecedente.getHagnnumaborto() == null) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "itNumAbortos", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }

                 if (antecedente.getHagnnumcesare() == null) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "itNumcesareas", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }

                 if (antecedente.getHagnnumvivo() == null) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "itNumHijosVivos", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }


                 if (antecedente.getHagnnacivivo() == null) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "itNumHijoNacidoVivo", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }

                 if (antecedente.getHagnectopico() == null) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "itNumEctopicos", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }

                 if (antecedente.getHagnmortina() == null) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "itNumHijosMortinatos", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }

                 if (antecedente.getHagnmuerto() == null) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "itNumHijosMuertos", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }

                 if (antecedente.getHagnnumparto() != null && 
                     antecedente.getHagnnumparto() > 0 && !esIlve) {
                     if (antecedente.getHagdfup() == null) {
                         wexito = false;
                         FacesUtils.addErrorMessage(urlAux + 
                                                    "calendarUltimoParto", 
                                                    MSG_CAMPO_OBLIGATORIO);
                     }
                 }


                 if (tipoCiclo == null || tipoCiclo.equals("")) {
                     wexito = false;
                     FacesUtils.addErrorMessage(urlAux + "radioTipoCiclo", 
                                                MSG_CAMPO_OBLIGATORIO);
                 }

                 if (tipoCiclo != null) {
                     if (tipoCiclo.equals("I")) {

                         if (antecedente != null && !esIlve) {
                             if (antecedente.getHagnfreciclo() == null) {
                                 wexito = false;
                                 FacesUtils.addErrorMessage(urlAux + 
                                                            "itFrecuencia", 
                                                            MSG_CAMPO_OBLIGATORIO);
                             }

                           
                             if (antecedente.getHagndurciclo() == null) {
                                 wexito = false;
                                 FacesUtils.addErrorMessage(urlAux + 
                                                            "itDuracion", 
                                                            MSG_CAMPO_OBLIGATORIO);
                             }

                            
                             if (antecedente.getHagnmenarquia() == null) {
                                 wexito = false;
                                 FacesUtils.addErrorMessage(urlAux + 
                                                            "itEdadMenarquia", 
                                                            MSG_CAMPO_OBLIGATORIO);
                             }
                             

                             if (antecedente.getHagdfur() == null) {
                                 wexito = false;
                                 FacesUtils.addErrorMessage(urlAux + 
                                                            "calendarUltimaRegla", 
                                                            MSG_CAMPO_OBLIGATORIO);
                             }
                         }

                     }


                     if (tipoCiclo.equals("R")) {
                         antecedente.setHagnfrefincicl(null);
                         antecedente.setHagndurfincicl(null);

                         if (antecedente.getHagnfreciclo() == null) {
                             wexito = false;
                             FacesUtils.addErrorMessage(urlAux + "itFrecuencia", 
                                                        MSG_CAMPO_OBLIGATORIO);
                         }


                         if (antecedente.getHagndurciclo() == null) {
                             wexito = false;
                             FacesUtils.addErrorMessage(urlAux + "itDuracion", 
                                                        MSG_CAMPO_OBLIGATORIO);
                         }


                         if (antecedente.getHagnmenarquia() == null) {
                             wexito = false;
                             FacesUtils.addErrorMessage(urlAux + 
                                                        "itEdadMenarquia", 
                                                        MSG_CAMPO_OBLIGATORIO);
                         }

                         if (antecedente.getHagdfur() == null) {
                             wexito = false;
                             FacesUtils.addErrorMessage(urlAux + 
                                                        "calendarUltimaRegla", 
                                                        MSG_CAMPO_OBLIGATORIO);
                         }

                     }


                     if (tipoCiclo.equals("A")) {

                         antecedente.setHagnfrefincicl(null);
                         antecedente.setHagndurfincicl(null);
                         antecedente.setHagnfreciclo(null);
                         antecedente.setHagndurciclo(null);

                         if (antecedente.getHagnmenarquia() == null) {
                             wexito = false;
                             FacesUtils.addErrorMessage(urlAux + 
                                                        "itEdadMenarquia", 
                                                        MSG_CAMPO_OBLIGATORIO);
                         }

                         if (antecedente.getHagdfur() == null) {
                             wexito = false;
                             FacesUtils.addErrorMessage(urlAux + 
                                                        "calendarUltimaRegla", 
                                                        MSG_CAMPO_OBLIGATORIO);
                         }

                     }

                     if (tipoCiclo.equals("N")) {
                         antecedente.setHagnfrefincicl(null);
                         antecedente.setHagndurfincicl(null);
                         antecedente.setHagnfreciclo(null);
                         antecedente.setHagndurciclo(null);
                         antecedente.setHagnmenarquia(null);

                     }

                 }

             }


             }


             if (tipoCiclo != null && tipoCiclo.equals("N")) {
             tieneCiclo = false;
             renderMenarquia = false;
             antecedente.setHagnfreciclo(null);
             antecedente.setHagnfrefincicl(null);
             antecedente.setHagndurciclo(null);
             antecedente.setHagndurfincicl(null);
             antecedente.setHagnmenarquia(null);
             antecedente.setHagdfur(null);

             antecedente.setHagcultcitolo("NO");

             }

             if (tipoCiclo != null && tipoCiclo.equals("A")) {
             tieneCiclo = false;
             renderMenarquia = true;
             antecedente.setHagnfreciclo(null);
             antecedente.setHagnfrefincicl(null);
             antecedente.setHagndurciclo(null);
             antecedente.setHagndurfincicl(null);
             }

             if (numeroConsulta != null) {
             id.setHaglconsulta(numeroConsulta);
             id.setHagctiposervi(tipoServicio);
             antecedente.setId(id);
             }

             antecedente.setHagdfecregistr(new Date());
             antecedente.setHagcoperador(userName());


             if (tipoCiclo != null) {
             antecedente.setHagetipciclo(tipoCiclo);

             if (tipoCiclo.equals("R")) {
                 antecedente.setHagnfrefincicl(null);
                 antecedente.setHagndurfincicl(null);
             }

             if (wexito && tipoCiclo.equals("I") && !ocultarmensaje) {
                 mostrarMensajeEmbarazo = true;
                 FacesUtils.addErrorMessage(MSG_EMBARAZO);
             }
             }

             if (antecedente != null) {
             if (antecedente.getHagdfur() != null) {
                 java.util.Date fechaUltimaRegla = 
                     new Date(antecedente.getHagdfur().getTime());
                 Calendar fechaAuxUR = Calendar.getInstance();
                 fechaAuxUR.setTime(fechaUltimaRegla);
                 fechaAuxUR.add(Calendar.DAY_OF_YEAR, 30);
                 Date fechacomp = new Date();

                 if (fechaUltimaRegla.compareTo(fechacomp) > 0) {
                     wexito = false;
                     FacesUtils.addErrorMessage(MSG_FECHA_ULTIMA_REGLA_NO_VALIDA);
                 }

                 if (fechaAuxUR.getTime().compareTo(fechacomp) < 0 && 
                     !mostrarMensajeEmbarazo && !ocultarmensaje) {
                     FacesUtils.addErrorMessage(MSG_EMBARAZO);
                 }
             }

             Date fechacomp = new Date();
             if (antecedente.getHagdfup() != null) {
                 Date fechaUltimoParto = 
                     new Date(antecedente.getHagdfup().getTime());
                 if (fechaUltimoParto.compareTo(fechacomp) > 0) {
                     wexito = false;
                     FacesUtils.addErrorMessage(MSG_FECHA_ULTIMO_PARTO_NO_VALIDA);
                 }
             }

             
         
         }


         if (wexito) {

             try {
                 if(esFertilidad){
                                antecedente.setHagcrelacsexua(null);
                                antecedente.setHagclactaexclu(null);
                                antecedente.setHagcplanemba(null);
                            }
                 if (esAnticoncepcionTemporal){
                     antecedente.setHagcrelacsexua(null);
                 }
                 antecedente.setHagcfeabopar("N");
                if(antecedente.getHagdfecultabopar()!=null){
                    antecedente.setHagcfeabopar("S");
                }
                 this.getServiceLocator().getClinicoService().saveAntecedenteGineco(antecedente);
                 if(identi!=null){
                 this.getServiceLocator().getClinicoService().saveIdentificaRiesgo(identi);
                 }
                 FacesUtils.addInfoMessage(MSG_ADICION);

                 if (esFertilidad) {
                     Chfertdato fertdato = new Chfertdato();
                     Cnregferti regferti = new Cnregferti();
                     CnregfertiPK regfertiId = new CnregfertiPK();
                     String nombre = "";

                     fertdato = this.getServiceLocator().getClinicoService().getFertilidadDatos(numeroConsulta);
                     regferti = this.getServiceLocator().getHistoriaService().getRegistroFertilidad(consulta.getHconclinica(),
                            usuario.getHusetipoiden(), usuario.getHusanumeiden());
                     if (regferti == null) {
                         regferti = new Cnregferti();
                         regfertiId = new CnregfertiPK();
                         regfertiId.setCrfnclinic(consulta.getHconclinica());
                         regfertiId.setCrfctipide(usuario.getHusetipoiden());
                         regfertiId.setCrfanumide(new BigDecimal(usuario.getHusanumeiden()));
                         regferti.setId(regfertiId);
                     }
//                     if (fertdato != null && fertdato.getHfdanumide()!=null) {
                       if (fertdato != null) {
                         if(fertdato.getHfdanumide()!=null) {
                            regferti.setCrfanihomb(fertdato.getHfdanumide());
                         } else {
                             regferti.setCrfanihomb(new BigDecimal("0")); 
                         }
                         regferti.setCrfctihomb(fertdato.getHfdctipide());
                         regferti.setCrfcestdon(fertdato.getHfdcdonant());
                         if (fertdato.getHfdcprinom() != null) {
                             nombre = fertdato.getHfdcprinom();
                         }
                         if (fertdato.getHfdcsegnom() != null) {
                             nombre = nombre + " " + fertdato.getHfdcsegnom();
                         }
                         if (fertdato.getHfdcpriape() != null) {
                             nombre = nombre + " " + fertdato.getHfdcpriape();
                         }
                         if (fertdato.getHfdcsegape() != null) {
                             nombre = nombre + " " + fertdato.getHfdcsegape();
                         }
                         if (nombre.length() > 50) {
                             nombre = nombre.substring(0, 50);
                         }
                         regferti.setCrfcnomhom(nombre);
                         if (fertdato.getHfdncoddon() != null) {
                             regferti.setCrfccoddon(fertdato.getHfdncoddon().toString());
                         }
                         if (fertdato.getHfdcocupac() != null) {
                             regferti.setCrfcocuhom(fertdato.getHfdcocupac());
                         }
                         if (fertdato.getHfddfecnac() != null) {
                             regferti.setCrfdnachom(fertdato.getHfddfecnac());
                         }
                     
                     regferti.setCrfdfecfer(consulta.getHcodfecinicio());
                     regferti.setCrfxmotivo("");
                     if (antecedente.getHagnmenarquia() == null) {
                         regferti.setCrfnmenarq(0);
                     } else {
                         regferti.setCrfnmenarq(antecedente.getHagnmenarquia());
                     }
                     regferti.setCrfnciclos(antecedente.getHagcciclos());
                     regferti.setCrfdfecfum(antecedente.getHagdfur());
                     regferti.setCrfdfecfpm(antecedente.getHagdfpur());
                     regferti.setCrfdfecapm(antecedente.getHagdfaur());
                     regferti.setCrfngestac(antecedente.getHagnnumgesta());
                     regferti.setCrfnpartos(antecedente.getHagnnumparto());
                     regferti.setCrfnaborto(antecedente.getHagnnumaborto());
                     regferti.setCrfncesare(antecedente.getHagnnumcesare());
                     regferti.setCrfnvivos(antecedente.getHagnnumvivo());
                     regferti.setCrfnectopi(antecedente.getHagnectopico());
                     regferti.setCrfnmortin(antecedente.getHagnmortina());
                     regferti.setCrfnmuerto(antecedente.getHagnmuerto());
                     regferti.setCrfndiacic(antecedente.getHagndiacic());
                     regferti.setCrfdfulpar(antecedente.getHagdfup());
                     regferti.setCrfcultccv("");
                     regferti.setCrfcaborto(antecedente.getHagcobsaborto());
                     regferti.setCrfcplanif("");
                     regferti.setCrfcdismen("");
                     regferti.setCrfcdismen("");
                     regferti.setCrfcrelsem(antecedente.getHagcrelsem());
                     regferti.setCrfdfecreg(new Date());
                     regferti.setCrfcusuari(userName());
                     regferti.setCrfcocumuj("");
                     regferti.setCrfnanoinf(antecedente.getHagnanoinf());
                     regferti.setCrflusuario(consulta.getHcolusuario().getHuslnumero());
                    try{
                     this.getServiceLocator().getClinicoService().saveRegistroFertilidad(regferti);
                     FacesUtils.addInfoMessage(MSG_ADICION);
                    }
                    catch(Exception e){
                        return capturaError(e,IConstantes.ERROR_GUARDADO);
                    }
                     
                     }
                 }

                 // Se recarga el menu 
                 FacesUtils.resetManagedBean(menuBean);
                 navigationRule = nextAction;


             } catch (ModelException e) {
                 navigationRule = "";
                 return capturaError(e,IConstantes.ERROR_GUARDADO);
                
             }

         }

         return navigationRule;

     }

     public void ChangeEvitaEmbarazo() {
         if (antecedente != null && antecedente.getHagcevitemba() != null && 
             antecedente.getHagcevitemba().equals("S")) {
             metodoevitaEmbarazo = true;
             renderedMetodo = false;
             mostrarFechaInyectable=false;

         } else {
             metodoevitaEmbarazo = false;
             renderedUsoCorrectoMetodoIve = false;
             renderedaclaracion = false;
             renderedMetodo = false;
             mostrarFechaInyectable=false;
             antecedente.setHagcmetoevitemba(null);
             antecedente.setHagceviembusomet(null);


         }
     }

     public void setRenderPlaneaEmbarazo(boolean renderPlaneaEmbarazo) {
         this.renderPlaneaEmbarazo = renderPlaneaEmbarazo;
     }

     public boolean isRenderPlaneaEmbarazo() {
         return renderPlaneaEmbarazo;
     }

     public void setMsgplaneaembarazo(String msgplaneaembarazo) {
         this.msgplaneaembarazo = msgplaneaembarazo;
     }

     public String getMsgplaneaembarazo() {
         return msgplaneaembarazo;
     }

     public void changePlaneaEmbarazo() {
         msgplaneaembarazo = "";
         if (antecedente.getHagcplanemba() != null && 
             antecedente.getHagcplanemba().equals("S")) {
             msgplaneaembarazo = 
                     "Recuerde orientar a la usuaria a valoraci�n preconcepcional";
         }
     }


     public void setMetodoevitaEmbarazo(boolean metodoevitaEmbarazo) {
         this.metodoevitaEmbarazo = metodoevitaEmbarazo;
     }

     public boolean isMetodoevitaEmbarazo() {
         return metodoevitaEmbarazo;
     }


     /**
      * @param valueChangeEvent
      */
     public void setHagcevitemba(ValueChangeEvent valueChangeEvent) {
         antecedente.setHagcevitemba((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

     /**
      * @param valueChangeEvent
      */
     public void setHagcmetoevitemba(ValueChangeEvent valueChangeEvent) {
         antecedente.setHagcmetoevitemba((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

     public void ChangeMetodoIve() {

         if (antecedente != null && 
             antecedente.getHagcmetoevitemba().equals("0")) {
             renderedMetodo = true;
             renderedUsoCorrectoMetodoIve = false;
         } else if( antecedente.getHagcmetoevitemba().equals("890201.1") || antecedente.getHagcmetoevitemba().equals("890201.2")) {
                 mostrarFechaInyectable = true;
                 renderedUsoCorrectoMetodoIve = true;
                 renderedMetodo=false;
             }else if (antecedente != null && 
                    (antecedente.getHagcmetoevitemba().equals("2") || 
                     antecedente.getHagcmetoevitemba().equals("3"))) {
             renderedMetodo = false;
             renderedUsoCorrectoMetodoIve = false;
             mostrarFechaInyectable=false;
         } else {
             renderedMetodo = false;
             renderedUsoCorrectoMetodoIve = true;
             mostrarFechaInyectable=false;
         }
     }
     
    public void changePruebaEmb() {
        if (antecedente != null && pruebaEmbarazo != null && pruebaEmbarazo.equals("S")) {
            mostrarPruebaEmb = true;
        } else {
            mostrarPruebaEmb = false;
            antecedente.setHagdfecpruemb(null);
            antecedente.setHagcrespruemb(null);
        }
    }


     public void setRenderedMetodo(boolean renderedMetodo) {
         this.renderedMetodo = renderedMetodo;
     }

     public boolean isRenderedMetodo() {
         return renderedMetodo;
     }

     public void setRenderedUsoCorrectoMetodoIve(boolean renderedUsoCorrectoMetodoIve) {
         this.renderedUsoCorrectoMetodoIve = renderedUsoCorrectoMetodoIve;
     }

     public boolean isRenderedUsoCorrectoMetodoIve() {
         return renderedUsoCorrectoMetodoIve;
     }

     /**
      * @param valueChangeEvent
      */
     public void setHagceviembusomet(ValueChangeEvent valueChangeEvent) {
         antecedente.setHagceviembusomet((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

     public void ChangeVerificacion() {
         if (antecedente != null && antecedente.getHagceviembusomet() != null && 
             antecedente.getHagceviembusomet().equals("S")) {
             renderedaclaracion = true;
         } else {
             renderedaclaracion = false;
             antecedente.setHagcbusometobs(null);
         }
     }
     
    /**
     * @param valueChangeEvent
     */
    public void setFechaActual(ValueChangeEvent valueChangeEvent) {
        setFechaActual((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

     public void setRenderedaclaracion(boolean renderedaclaracion) {
         this.renderedaclaracion = renderedaclaracion;
     }

     public boolean isRenderedaclaracion() {
         return renderedaclaracion;
     }

     public void setItFechaAbortoParto(UIInput itFechaAbortoParto) {
         this.itFechaAbortoParto = itFechaAbortoParto;
     }

     public UIInput getItFechaAbortoParto() {
         return itFechaAbortoParto;
     }

     public void setRenderedAbortsprevios(boolean renderedAbortsprevios) {
         this.renderedAbortsprevios = renderedAbortsprevios;
     }

     public boolean isRenderedAbortsprevios() {
         return renderedAbortsprevios;
     }

     /**
      * @param valueChangeEvent
      */
     public void setAbortosPrevios(ValueChangeEvent valueChangeEvent) {
         antecedente.setHagnnumaborto((Integer)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }
     
    /**
     * @param valueChangeEvent
     */
    public void setHiecresulpruemb(ValueChangeEvent valueChangeEvent) {
        antecedente.setHagcrespruemb((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setPruebaEmbarazo(ValueChangeEvent valueChangeEvent) {
        pruebaEmbarazo = ((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


     public void changeNumeroAbortoPrevios() {

         if (antecedente != null && antecedente.getHagnnumaborto() != null) {
             if (antecedente != null &&  antecedente.getHagnnumaborto() != null) {
                 if (antecedente != null && 
                     antecedente.getHagnnumaborto() != null) {
                     if (antecedente.getHagnnumaborto().intValue() ==  0) {
                         renderedAbortsprevios = false;
                         renderedAbortspreviosTres = false;
                         renderedfechaAbortparto = false;
                       
                     } else {
                         if (antecedente.getHagnnumaborto().intValue() >= 3) {
                             renderedAbortsprevios = true;
                             renderedAbortspreviosTres = true;
                             renderedfechaAbortparto = true;

                         } else {
                             renderedAbortsprevios = true;
                             renderedfechaAbortparto = true;
                             renderedAbortspreviosTres = false;
                             renderedfechaAbortparto = true;

                         }
                     }
                 }
             }
             
         if (antecedente != null &&  antecedente.getHagnnumparto() != null && antecedente.getHagnnumparto().intValue() > 0 ) {
             renderedfechaAbortparto = true;

         }
         else{
             antecedente.setHagdfecultabopar(null);
         }
     }
     }
     
     public void changeNumeroPartos() {

     
             if (antecedente != null &&  antecedente.getHagnnumparto() != null) {
                 if (antecedente != null && 
                     antecedente.getHagnnumparto() != null) {
                     if (antecedente.getHagnnumparto().intValue() ==  0) {
                         renderedAbortsprevios = false;
                         renderedAbortspreviosTres = false;
                         renderedfechaAbortparto = false;
                       
                     } else {
                             renderedAbortsprevios = true;
                             renderedAbortspreviosTres = true;
                             renderedfechaAbortparto = true;
                     }
                 }
             }
             
             if (antecedente != null &&  antecedente.getHagnnumaborto() != null && antecedente.getHagnnumaborto().intValue()>0) {
                 renderedfechaAbortparto = true;
             }
             else{
                 antecedente.setHagdfecultabopar(null);
             }
         }


     public void setRenderedAbortspreviosTres(boolean renderedAbortspreviosTres) {
         this.renderedAbortspreviosTres = renderedAbortspreviosTres;
     }

     public boolean isRenderedAbortspreviosTres() {
         return renderedAbortspreviosTres;
     }

     /**
      * @param valueChangeEvent
      */
     public void setHagcfechaabopar(ValueChangeEvent valueChangeEvent) {
         antecedente.setHagcfeabopar((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

     public void ChangeFechaAborParto() {
         if (antecedente != null && antecedente.getHagcfeabopar() != null && 
             antecedente.getHagcfeabopar().equals("S")) {
             renderedfechaAbortparto = true;
         } else {
             renderedfechaAbortparto = false;
             antecedente.setHagdfecultabopar(null);
             antecedente.setHagcpesorn(null);
         }
     }

     public void setRenderedfechaAbortparto(boolean renderedfechaAbortparto) {
         this.renderedfechaAbortparto = renderedfechaAbortparto;
     }

     public boolean isRenderedfechaAbortparto() {
         return renderedfechaAbortparto;
     }

     public void setRenderedInterrupcion(boolean renderedInterrupcion) {
         this.renderedInterrupcion = renderedInterrupcion;
     }

     public boolean isRenderedInterrupcion() {
         return renderedInterrupcion;
     }

     public void setItAbortosPrevios(UIInput itAbortosPrevios) {
         this.itAbortosPrevios = itAbortosPrevios;
     }

     public UIInput getItAbortosPrevios() {
         return itAbortosPrevios;
     }

     public void setRenderIve(boolean renderIve) {
         this.renderIve = renderIve;
     }

     public boolean isRenderIve() {
         return renderIve;
     }

     public void setMostrarFechaInyectable(boolean mostrarFechaInyectable) {
         this.mostrarFechaInyectable = mostrarFechaInyectable;
     }

     public boolean isMostrarFechaInyectable() {
         return mostrarFechaInyectable;
     }

     public void setIdenti(Chidentiriesgo identi) {
         this.identi = identi;
     }

     public Chidentiriesgo getIdenti() {
         return identi;
     }
     
     public void setLstUniMedFertilidad(List lstUniMedFertilidad) {
           this.lstUniMedFertilidad = lstUniMedFertilidad;
       }

       public List getLstUniMedFertilidad() {
           if (lstUniMedFertilidad == null || lstUniMedFertilidad.isEmpty()) {
               lstUniMedFertilidad = new ArrayList<SelectItem>();
               lstUniMedFertilidad.add(new SelectItem("", 
                                                     "Seleccione una opci�n "));
               lstUniMedFertilidad.add(new SelectItem("M", "Meses"));
               lstUniMedFertilidad.add(new SelectItem("A", 
                                                     "A�os"));
            
           }
           return lstUniMedFertilidad;
       }

       public void setUniMedFertilidad(String uniMedFertilidad) {
           this.UniMedFertilidad = uniMedFertilidad;
       }

       public String getUniMedFertilidad() {
           return UniMedFertilidad;
       }

    public void setRenderConocefun(Boolean renderConocefun) {
        this.renderConocefun = renderConocefun;
    }

    public Boolean getRenderConocefun() {
        return renderConocefun;
    }
    
    public void setLstOpcionesEmbarazo(List lstOpcionesEmbarazo) {
        this.lstOpcionesEmbarazo = lstOpcionesEmbarazo;
    }

    public List getLstOpcionesEmbarazo()       {
        if (lstOpcionesEmbarazo == null || lstOpcionesEmbarazo.isEmpty()) {
            lstOpcionesEmbarazo = new ArrayList();
            lstOpcionesEmbarazo.add(new SelectItem("S", "Positiva"));
            lstOpcionesEmbarazo.add(new SelectItem("N", "Negativa"));
        }
        return lstOpcionesEmbarazo;
    }

    public void setRenderPruebaEmbarazo(boolean renderPruebaEmbarazo) {
        this.renderPruebaEmbarazo = renderPruebaEmbarazo;
    }

    public boolean isRenderPruebaEmbarazo() {
        return renderPruebaEmbarazo;
    }

    public void setPruebaEmb(UISelectOne pruebaEmb) {
        this.pruebaEmb = pruebaEmb;
    }

    public UISelectOne getPruebaEmb() {
        return pruebaEmb;
    }

    public void setPruebaEmbarazo(String pruebaEmbarazo) {
        this.pruebaEmbarazo = pruebaEmbarazo;
    }

    public String getPruebaEmbarazo() {
        return pruebaEmbarazo;
    }

    public void setMostrarPruebaEmb(boolean mostrarPruebaEmb) {
        this.mostrarPruebaEmb = mostrarPruebaEmb;
    }

    public boolean isMostrarPruebaEmb() {
        return mostrarPruebaEmb;
    }
}
