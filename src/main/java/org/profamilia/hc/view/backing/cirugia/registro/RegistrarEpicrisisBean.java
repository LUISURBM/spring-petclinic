package org.profamilia.hc.view.backing.cirugia.registro;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import java.util.StringTokenizer;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chconducta;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chdetaldescr;
import org.profamilia.hc.model.dto.Chepicrisi;
import org.profamilia.hc.model.dto.ChepicrisiPK;
import org.profamilia.hc.model.dto.Chevolucion;
import org.profamilia.hc.model.dto.Chexamfisico;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chincapacida;
import org.profamilia.hc.model.dto.Chingresoenf;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.dto.Chnotaenferm;
import org.profamilia.hc.model.dto.Chtipousuari;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.busqueda.ListaCirugiaEpicrisisBean;
import org.profamilia.hc.view.backing.cirugia.consulta.ConsultarUsuariosEpicrisisBean;
import org.profamilia.hc.view.backing.clinico.comun.Cie10Bean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class RegistrarEpicrisisBean extends BaseBean {

    private Chepicrisi epicrisis;

    private Long numerocirugia;

    private Chcirugprogr cirugiaSelect;

    private Chcirugprogr cirugia;


    private Chingresoenf ingresoenf;

    private String diagnosticoPrincipalIngreso;
    private String diagnosticoConfirmado;

    
    private String diagnosticoPrincipalEgreso;
    private String diagnosticoRelacionadoUEgreso;
    private String diagnosticoRelacionadoDEgreso;
    private String diagnosticoRelacionadoTEgreso;
    
    private String diagnosticoRelacionadoUIngreso;
    private String diagnosticoRelacionadoDIngreso;
    private String diagnosticoRelacionadoTIngreso;

    private boolean mostrarCie10;


    private int selectedIndex;

    static final int ACTIVAR_REGISTRAR_EPICRISIS = 0;
    static final int ACTIVAR_BUSCADOR = 1;

    private Crdgncie10 diagpresu;

    private Crdgncie10 diagconfir;

    private Crdgncie10 diagrela;

    private UIInput itDiagPresI;

    private UIInput itDiagconf;

    private UIInput itDiagrelacUI;
    
    private UIInput itDiagrelacDI;
    
    private UIInput itDiagrelacTI;
    
    private UIInput itDiagrelacUE;
    
    private UIInput itDiagrelacDE;
    
    private UIInput itDiagrelacTE;
    
    private UIInput itDiagPresE;

    private List lstTipoUsuario;

    private long numeroHoras;

    private List<Object[]> lstCirugiasEgreso;

    private List<Cpservicio> lstCirugiasIngreso;

    private Cnconsclin consclin;

    private Chmotivocon motivocon;

    private Chexamfisico examfisico;

    private String antegeneral;

    private String revision;

    private Chimprdiag imprdiag;

    private Chconducta conducta;

    private Chevolucion evolucion;

    private Chconsulta consultaExterna;

    private Cpservicio servicioString;

    private Chdetaldescr detalleDescrip;
    
    private List<SelectItem>lstServicioIngreso;
    
    private boolean historiaAceptada;
    
    private Chincapacida incapacidad;
    
    private boolean esingreso;
    
    private boolean esConfirmado;
    
    private Chusuario usuario;
    
    private Cpprofesio profesionalAct;
    
    private String sexo;

    public RegistrarEpicrisisBean() {
    }

    public void init() {
        epicrisis = new Chepicrisi();
        epicrisis.setHepcserviegres("Cirug�a");
        lstTipoUsuario = new ArrayList();
        cargarDatos();
    }

    public void cargarDatos() {

        String cirugiaEgresoString = "";

        lstCirugiasIngreso = new ArrayList();
        if (numerocirugia != null) {
            try {

                lstCirugiasEgreso = 
                        this.serviceLocator.getClinicoService().getDetalleCirugiasProgramadasBasico(numerocirugia,true);

                ingresoenf = 
                        this.serviceLocator.getClinicoService().getIngresoEnfermeria(numerocirugia);

                cirugia = 
                        this.serviceLocator.getClinicoService().getProgramarCirugia(numerocirugia);
                if(cirugia !=null){
                usuario = 
                        this.getServiceLocator().getClinicoService().getUsuario(cirugia.getHcplusuario().getHuslnumero());
                        if(usuario!=null){
                            setSexo(usuario.getHusesexo());
                        }
                }
                profesionalAct = 
                        serviceLocator.getClinicoService().getProfesionalPorUsuario(userName(), 
                                                                                    this.getClinica().getCclncodigo());

            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (cirugia != null) {
            epicrisis.setHepdfechaingre(cirugia.getHcpdfechingenf());
            epicrisis.setHepdfechaegres(cirugia.getHcpdfechsalenf());


            if (cirugia.getHcpdfechingenf() != null && 
                cirugia.getHcpdfechsalenf() != null) {
                // Crear 2 instancias de Calendar  
                numeroHoras = 0;

                Calendar cal1 = Calendar.getInstance();

                Calendar cal2 = Calendar.getInstance();


                cal1.setTime(cirugia.getHcpdfechingenf());
                cal2.setTime(cirugia.getHcpdfechsalenf());

                long milis1 = cal1.getTimeInMillis();

                long milis2 = cal2.getTimeInMillis();


                long diff = milis2 - milis1;

                // calcular la diferencia en horas

                numeroHoras = diff / (60 * 60 * 1000);

            }

            /* Modificaiones NLS,CAVR para alimentar la epicrisis automaticamente */

            try {
         
                                      consultaExterna =    this.serviceLocator.getClinicoService().getUltimaConsultaExternaUsuario(cirugia.getHcplusuario().getHuslnumero());

                consclin = 
                        this.serviceLocator.getClinicoService().getConsultaClinicaPorId(numerocirugia.toString());
                
                historiaAceptada = this.serviceLocator.getCirugiaService().getAplicaTipoHistoria(consclin.getCcocservic().getCsvccodigo());
   
            if(historiaAceptada){
               
                detalleDescrip = 
                        this.serviceLocator.getCirugiaService().getDiagnosticosEgrEpicrisis(numerocirugia);
                evolucion = 
                        this.serviceLocator.getCirugiaService().getEvolucionEpicrisis(numerocirugia);
                incapacidad = this.serviceLocator.getCirugiaService().getIncapacidadEpicrisis(numerocirugia);

            }

                if (cirugia.getHcplusuario() != null) {
                    Object[] lstImpresionaux = null;
                    //try {

                        //lstImpresionaux = 
                                //(Object[])this.serviceLocator.getCirugiaService().getUltimaValoracionPreUsuarioMotivo(cirugia.getHcplusuario().getHuslnumero());

                    //} catch (ModelException e) {
                        //e.printStackTrace();
                    //}

                    if (lstImpresionaux == null) {
                        //FacesUtils.addInfoMessage(MSG_NO_TIENE_VALORACION_PREOPERATORIA);
                    }

                 
                }
             
            
                if (consultaExterna != null) {
                    historiaAceptada = this.serviceLocator.getCirugiaService().getAplicaTipoHistoria(consultaExterna.getHcocservicio().getCsvccodigo());
                    if(historiaAceptada){
                    motivocon = 
                            this.serviceLocator.getCirugiaService().getMotivoConsultaEpicrisis(consultaExterna.getHcolnumero());

                    antegeneral = 
                            this.serviceLocator.getCirugiaService().getAntecedentesGeneralesEpicrisis(consultaExterna.getHcolnumero());

                    revision = 
                            this.serviceLocator.getCirugiaService().getRevisionSistemasEpicrisis(consultaExterna.getHcolnumero());

                    //antegineco = 
                            //this.serviceLocator.getCirugiaService().getAntecedentesGinecoEpicrisis(consultaExterna.getHcolnumero());
                    
                        imprdiag = 
                                this.serviceLocator.getCirugiaService().getDiagnosticosIngEpicrisis(consultaExterna.getHcolnumero());
                        conducta = 
                                this.serviceLocator.getCirugiaService().getConductaEpicrisis(consultaExterna.getHcolnumero());
                        examfisico = 
                                this.serviceLocator.getCirugiaService().getExamenFisicoEpicrisis(consultaExterna.getHcolnumero());
                    }
                
                }


       


            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (consclin != null && consclin.getCconcontra() == 1) {
                epicrisis.setHepctipousuari("P"); /* Usuario Particular */
            } else {
                epicrisis.setHepctipousuari("C"); /* Usuario Convenios */
            }

            if (motivocon != null) {
                epicrisis.setHepcmotivocons(motivocon.getHmctdescripcio());
                epicrisis.setHepcenfeactual(motivocon.getHmctenferactal());
            }

        

            if (antegeneral != null) {
                epicrisis.setHepcantecedent(antegeneral);
            }
            
            //TODO: se debe concatenar los antecedentes 
            //if (antegineco != null) {
                //epicrisis.setHepcantecedent(antegineco.getHagcobservacio());
            //}

            if (revision != null) {
                epicrisis.setHepcrevisistem(revision);
            }

            if (examfisico != null) {
                epicrisis.setHepchallaexafi(examfisico.getHefthallazgo());
            }

            if (imprdiag != null) {
                epicrisis.setHepcdiagingnpresu(imprdiag.getHidcdiagprin());
                epicrisis.setHepcdiagingrelacd(imprdiag.getHidcdiagrela2());
                epicrisis.setHepcdiagingnrelacu(imprdiag.getHidcdiagrela1());
                epicrisis.setHepcdiagingrelact(imprdiag.getHidcdiagrela3());
                epicrisis.setHepcdiagegrpresu(imprdiag.getHidcdiagprin());

                changeDiagnosticoPrincipalI();
                changeDiagnosticoRelacionadoUI();
                changeDiagnosticoRelacionadoDI();
                changeDiagnosticoRelacionadoTI();
                changeDiagnosticoPrincipalE();

            }
            
            if(detalleDescrip !=null){
              epicrisis.setHepcdiagnconfi(detalleDescrip.getHddcdiagnprinc());
                epicrisis.setHepcdiagegrrelacu(detalleDescrip.getHddcdiagnrelac());
              Chdetaldescr masDescipcionByDia = null;
                try {
                if(detalleDescrip.getHddlusuario()!=null)
                    masDescipcionByDia = 
                            this.serviceLocator.getCirugiaService().getMasDescripcionQuirByUsuario(detalleDescrip.getHddlusuario().getHuslnumero(),detalleDescrip.getHdddfecregistr());
                            if(masDescipcionByDia !=null){
                                epicrisis.setHepcdiagegrrelacd(masDescipcionByDia.getHddcdiagnprinc());
                                epicrisis.setHepcdiagegrrelact(masDescipcionByDia.getHddcdiagnrelac());
                            }
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                changeDiagnosticoRelacionadoDE();
                changeDiagnosticoRelacionadoUE();
                changeDiagnosticoRelacionadoUTE();
                changeDiagnosticoConfirmado();
            }
            
            if(incapacidad !=null){
                epicrisis.setHepccondegres("d�as de incapacidad:"+incapacidad.getHidndias()+" d�as");
            }

            if (lstCirugiasEgreso != null && !lstCirugiasEgreso.isEmpty()) {
                for (Object[] cirugiaEgreso: lstCirugiasEgreso) {
                    cirugiaEgresoString = 
                            cirugiaEgresoString + cirugiaEgreso[1] + ",";
                }
            }

            if (cirugiaEgresoString != null && 
                !cirugiaEgresoString.equals("")) {
                cirugiaEgresoString = 
                        cirugiaEgresoString.substring(0, cirugiaEgresoString.length() - 
                                                      1);
                //epicrisis.setHepcserviegres(cirugiaEgresoString);
            }


            try {
                servicioString = 
                        this.serviceLocator.getClinicoService().getServicioPorId(cirugiaEgresoString);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            String planManejo = null;
            String recomendaciones = null;
            String descripcionProcedimiento = null;
            String hallazgos = null;
            String intervencionPracticada = null;
            String piezaPatologica = null;
            if (conducta != null && examfisico != null && 
                servicioString != null) {
                if (conducta == null) {
                    planManejo = " ";
                } else {
                    planManejo = conducta.getHcncplanmanejo();
                }
                if (conducta == null) {
                    recomendaciones = " ";
                } else {
                    recomendaciones = conducta.getHcncobservacio();
                }
                if (detalleDescrip == null) {
                    descripcionProcedimiento = "";
                    piezaPatologica =" ";
                } else {
                    descripcionProcedimiento = 
                            detalleDescrip.getHddcdescripcio();
                    piezaPatologica = detalleDescrip.getHddcpiezapatol();
                }
                if (examfisico == null) {
                    hallazgos = " ";
                } else {
                    hallazgos = examfisico.getHefthallazgo();
                }
                if (servicioString.getCsvcnombre() == null) {
                    intervencionPracticada = " ";
                } else {
                    intervencionPracticada = servicioString.getCsvcnombre();
                }
                
              
            }

            if (evolucion != null) {
                epicrisis.setHepcevolucion(evolucion.getHevcnotapacien());
            }
            if(conducta!=null){
            epicrisis.setHepcconducta(conducta.getHcncplanmanejo());
            }


        }

        if (ingresoenf != null) {


            if (ingresoenf != null && ingresoenf.getHiecinterinici() != null) {
                StringTokenizer st = 
                    new StringTokenizer(ingresoenf.getHiecinterinici(), ",");
                Cpservicio servicioAux = null;
                while (st.hasMoreTokens()) {
                    String idservicio = st.nextToken();

                    try {
                        servicioAux = 
                                this.serviceLocator.getClinicoService().getServicioPorId(idservicio);
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    if (servicioAux != null) {
                        lstCirugiasIngreso.add(servicioAux);
                    }
                }
            }
        }
    }


    public void mostrarDiagnosticoPrincipalI() {
        esingreso = true;
        esConfirmado = false;
        Cie10Bean cie10;
        if (epicrisis != null) {
            epicrisis.setHepcdiagingnpresu("");
            cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");
            cie10.setDiagnosticoPrincipal(true);
            cie10.setDiagnosticoRelacionado1(false);
            cie10.setDiagnosticoRelacionado2(false);
            cie10.setDiagnosticoRelacionado3(false);
            mostrarCie10 = true;
            selectedIndex = ACTIVAR_BUSCADOR;
        }


    }
    public void mostrarDiagnosticoPrincipalE() {
        esingreso = false;
        esConfirmado = false;
        Cie10Bean cie10;
        if (epicrisis != null) {
            epicrisis.setHepcdiagegrpresu("");
            cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");
            cie10.setDiagnosticoPrincipal(true);
            cie10.setDiagnosticoRelacionado1(false);
            cie10.setDiagnosticoRelacionado2(false);
            cie10.setDiagnosticoRelacionado3(false);
            mostrarCie10 = true;
            selectedIndex = ACTIVAR_BUSCADOR;
        }


    }

    public void mostrarDiagnosticoConfirmado() {
        Cie10Bean cie10;
        esConfirmado = true;
        if (epicrisis != null) {
            epicrisis.setHepcdiagnconfi("");

            cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");
            cie10.setDiagnosticoPrincipal(false);
            cie10.setDiagnosticoRelacionado1(true);
            cie10.setDiagnosticoRelacionado2(false);
            cie10.setDiagnosticoRelacionado3(false);
            mostrarCie10 = true;
            selectedIndex = ACTIVAR_BUSCADOR;
        }

    }

    public void mostrarDiagnosticoRelacionadoUI() {
        esingreso = true;
        esConfirmado = false;
        Cie10Bean cie10;
        if (epicrisis != null) {
            epicrisis.setHepcdiagingnrelacu("");
            cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");
            cie10.setDiagnosticoPrincipal(false);
            cie10.setDiagnosticoRelacionado1(true);
            cie10.setDiagnosticoRelacionado2(false);
            cie10.setDiagnosticoRelacionado3(false);
            selectedIndex = ACTIVAR_BUSCADOR;
            mostrarCie10 = true;
        }

    }
    public void mostrarDiagnosticoRelacionadoDI() {
        esingreso = true;
        esConfirmado = false;
        Cie10Bean cie10;
        if (epicrisis != null) {
            epicrisis.setHepcdiagingrelacd("");
            cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");
            cie10.setDiagnosticoPrincipal(false);
            cie10.setDiagnosticoRelacionado1(false);
            cie10.setDiagnosticoRelacionado2(true);
            cie10.setDiagnosticoRelacionado3(false);
            selectedIndex = ACTIVAR_BUSCADOR;
            mostrarCie10 = true;
        }

    }
    public void mostrarDiagnosticoRelacionadoTI() {
        esingreso = true;
        esConfirmado = false;
        Cie10Bean cie10;
        if (epicrisis != null) {
            epicrisis.setHepcdiagingrelact("");
            cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");
            cie10.setDiagnosticoPrincipal(false);
            cie10.setDiagnosticoRelacionado1(false);
            cie10.setDiagnosticoRelacionado2(false);
            cie10.setDiagnosticoRelacionado3(true);
            selectedIndex = ACTIVAR_BUSCADOR;
            mostrarCie10 = true;
        }

    }
    public void mostrarDiagnosticoRelacionadoUE() {
        esingreso = false;
        esConfirmado = false;
        Cie10Bean cie10;
        if (epicrisis != null) {
            epicrisis.setHepcdiagegrrelacu("");
            cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");
            cie10.setDiagnosticoPrincipal(false);
            cie10.setDiagnosticoRelacionado1(true);
            cie10.setDiagnosticoRelacionado2(false);
            cie10.setDiagnosticoRelacionado3(false);
            selectedIndex = ACTIVAR_BUSCADOR;
            mostrarCie10 = true;
        }

    }
    public void mostrarDiagnosticoRelacionadoDE() {
        esingreso = false;
        esConfirmado = false;
        Cie10Bean cie10;
        if (epicrisis != null) {
            epicrisis.setHepcdiagegrrelacd("");
            cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");
            cie10.setDiagnosticoPrincipal(false);
            cie10.setDiagnosticoRelacionado1(false);
            cie10.setDiagnosticoRelacionado2(true);
            cie10.setDiagnosticoRelacionado3(false);
            selectedIndex = ACTIVAR_BUSCADOR;
            mostrarCie10 = true;
        }

    }
    public void mostrarDiagnosticoRelacionadoTE() {
        esingreso = false;
        esConfirmado = false;
        Cie10Bean cie10;
        if (epicrisis != null) {
            epicrisis.setHepcdiagegrrelact("");
            cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");
            cie10.setDiagnosticoPrincipal(false);
            cie10.setDiagnosticoRelacionado1(false);
            cie10.setDiagnosticoRelacionado2(false);
            cie10.setDiagnosticoRelacionado3(true);
            selectedIndex = ACTIVAR_BUSCADOR;
            mostrarCie10 = true;
        }

    }

    /**
     * @param valueChangeEvent
     */
    public void setHepcdiagingnpresu(ValueChangeEvent valueChangeEvent) {
        epicrisis.setHepcdiagingnpresu((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHepcdiagegrnpresu(ValueChangeEvent valueChangeEvent) {
        epicrisis.setHepcdiagegrpresu((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHepcdiagnconfi(ValueChangeEvent valueChangeEvent) {
        epicrisis.setHepcdiagnconfi((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHepcdiagingrelacu(ValueChangeEvent valueChangeEvent) {
        epicrisis.setHepcdiagingnrelacu((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHepcdiagingrelacd(ValueChangeEvent valueChangeEvent) {
        epicrisis.setHepcdiagingrelacd((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHepcdiagingrelact(ValueChangeEvent valueChangeEvent) {
        epicrisis.setHepcdiagingrelact((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHepcdiagegrrelacu(ValueChangeEvent valueChangeEvent) {
        epicrisis.setHepcdiagegrrelacu((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHepcdiagegrrelacd(ValueChangeEvent valueChangeEvent) {
        epicrisis.setHepcdiagegrrelacd((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHepcdiagegrrelact(ValueChangeEvent valueChangeEvent) {
        epicrisis.setHepcdiagegrrelact((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void changeDiagnosticoPrincipalI() {
        diagnosticoPrincipalIngreso = null;
        if (epicrisis != null) {
            if (epicrisis.getHepcdiagingnpresu() != null && 
                !epicrisis.getHepcdiagingnpresu().equals("")) {
                try {
                    diagpresu = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(epicrisis.getHepcdiagingnpresu().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagpresu != null && diagpresu.getCdcccodigo() != null) {
                    diagnosticoPrincipalIngreso = diagpresu.getCdccdescri();

                }

                if (diagnosticoPrincipalIngreso == null || 
                    diagnosticoPrincipalIngreso.equals("")) {
                    FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_PRINCIPAL_NO_VALIDO);
                }
            } else {
                diagnosticoPrincipalIngreso = "";
            }
        }
    }
    
    public void changeDiagnosticoPrincipalE() {
        diagnosticoPrincipalEgreso = null;
        if (epicrisis != null) {
            if (epicrisis.getHepcdiagegrpresu() != null && 
                !epicrisis.getHepcdiagegrpresu().equals("")) {
                try {
                    diagpresu = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(epicrisis.getHepcdiagegrpresu().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagpresu != null && diagpresu.getCdcccodigo() != null) {
                    diagnosticoPrincipalEgreso = diagpresu.getCdccdescri();

                }

                if (diagnosticoPrincipalEgreso == null || 
                    diagnosticoPrincipalEgreso.equals("")) {
                    FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_PRINCIPAL_NO_VALIDO);
                }
            } else {
                diagnosticoPrincipalEgreso = "";
            }
        }
    }


    public void changeDiagnosticoConfirmado() {
        diagnosticoConfirmado = null;
        if (epicrisis != null) {
            if (epicrisis.getHepcdiagnconfi() != null && 
                !epicrisis.getHepcdiagnconfi().equals("")) {
                try {
                    diagconfir = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(epicrisis.getHepcdiagnconfi().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagconfir != null && diagconfir.getCdcccodigo() != null) {
                    diagnosticoConfirmado = diagconfir.getCdccdescri();

                }

                if (diagnosticoConfirmado == null || 
                    diagnosticoConfirmado.equals("")) {
                    FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_PRINCIPAL_NO_VALIDO);
                }
            } else {
                diagnosticoConfirmado = "";
            }
        }
    }


    public void changeDiagnosticoRelacionadoUI() {
        diagnosticoRelacionadoUIngreso = null;
        if (epicrisis != null) {
            if (epicrisis.getHepcdiagingnrelacu() != null && 
                !epicrisis.getHepcdiagingnrelacu().equals("")) {
                try {
                    diagrela = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(epicrisis.getHepcdiagingnrelacu().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagrela != null && diagrela.getCdcccodigo() != null) {
                    diagnosticoRelacionadoUIngreso = diagrela.getCdccdescri();

                }

                if (diagnosticoRelacionadoUIngreso == null || 
                    diagnosticoRelacionadoUIngreso.equals("")) {
                    FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_PRINCIPAL_NO_VALIDO);
                }
            } else {
                diagnosticoRelacionadoUIngreso = "";
            }
        }
    }
    
    public void changeDiagnosticoRelacionadoDI() {
        diagnosticoRelacionadoDIngreso = null;
        if (epicrisis != null) {
            if (epicrisis.getHepcdiagingrelacd() != null && 
                !epicrisis.getHepcdiagingrelacd().equals("")) {
                try {
                    diagrela = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(epicrisis.getHepcdiagingrelacd().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagrela != null && diagrela.getCdcccodigo() != null) {
                    diagnosticoRelacionadoDIngreso = diagrela.getCdccdescri();

                }

                if (diagnosticoRelacionadoDIngreso == null || 
                    diagnosticoRelacionadoDIngreso.equals("")) {
                    FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_PRINCIPAL_NO_VALIDO);
                }
            } else {
                diagnosticoRelacionadoDIngreso = "";
            }
        }
    }
    
    public void changeDiagnosticoRelacionadoTI() {
        diagnosticoRelacionadoTIngreso = null;
        if (epicrisis != null) {
            if (epicrisis.getHepcdiagingrelact() != null && 
                !epicrisis.getHepcdiagingrelact().equals("")) {
                try {
                    diagrela = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(epicrisis.getHepcdiagingrelact().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagrela != null && diagrela.getCdcccodigo() != null) {
                    diagnosticoRelacionadoTIngreso = diagrela.getCdccdescri();

                }

                if (diagnosticoRelacionadoTIngreso == null || 
                    diagnosticoRelacionadoTIngreso.equals("")) {
                    FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_PRINCIPAL_NO_VALIDO);
                }
            } else {
                diagnosticoRelacionadoTIngreso = "";
            }
        }
    }
    
    
    
    public void changeDiagnosticoRelacionadoUE() {
        diagnosticoRelacionadoUEgreso = null;
        if (epicrisis != null) {
            if (epicrisis.getHepcdiagegrrelacu() != null && 
                !epicrisis.getHepcdiagegrrelacu().equals("")) {
                try {
                    diagrela = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(epicrisis.getHepcdiagegrrelacu().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagrela != null && diagrela.getCdcccodigo() != null) {
                    diagnosticoRelacionadoUEgreso = diagrela.getCdccdescri();

                }

                if (diagnosticoRelacionadoUEgreso == null || 
                    diagnosticoRelacionadoUEgreso.equals("")) {
                    FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_PRINCIPAL_NO_VALIDO);
                }
            } else {
                diagnosticoRelacionadoUEgreso = "";
            }
        }
    }
    public void changeDiagnosticoRelacionadoDE() {
        diagnosticoRelacionadoDEgreso = null;
        if (epicrisis != null) {
            if (epicrisis.getHepcdiagegrrelacd() != null && 
                !epicrisis.getHepcdiagegrrelacd().equals("")) {
                try {
                    diagrela = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(epicrisis.getHepcdiagegrrelacd().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagrela != null && diagrela.getCdcccodigo() != null) {
                    diagnosticoRelacionadoDEgreso = diagrela.getCdccdescri();

                }

                if (diagnosticoRelacionadoDEgreso == null || 
                    diagnosticoRelacionadoDEgreso.equals("")) {
                    FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_PRINCIPAL_NO_VALIDO);
                }
            } else {
                diagnosticoRelacionadoDEgreso = "";
            }
        }
    }
    public void changeDiagnosticoRelacionadoUTE() {
        diagnosticoRelacionadoTEgreso = null;
        if (epicrisis != null) {
            if (epicrisis.getHepcdiagegrrelact() != null && 
                !epicrisis.getHepcdiagegrrelact().equals("")) {
                try {
                    diagrela = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(epicrisis.getHepcdiagegrrelact().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagrela != null && diagrela.getCdcccodigo() != null) {
                    diagnosticoRelacionadoTEgreso = diagrela.getCdccdescri();

                }

                if (diagnosticoRelacionadoTEgreso == null || 
                    diagnosticoRelacionadoTEgreso.equals("")) {
                    FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_PRINCIPAL_NO_VALIDO);
                }
            } else {
                diagnosticoRelacionadoTEgreso = "";
            }
        }
    }

    public void aceptarDiagnostico() {
        Cie10Bean cie10;
        cie10 = (Cie10Bean)FacesUtils.getManagedBean("buscadorCie10");

        if (cie10 != null && cie10.getCie10Select() != null) {
            if (cie10.isDiagnosticoPrincipal()) {
            if(esingreso){
                itDiagPresI.setValue(cie10.getCie10Select().getCdcccodigo());
                epicrisis.setHepcdiagingnpresu(cie10.getCie10Select().getCdcccodigo());
                diagnosticoPrincipalIngreso = cie10.getCie10Select().getCdccdescri();
            }
            else{
                itDiagPresE.setValue(cie10.getCie10Select().getCdcccodigo());
                epicrisis.setHepcdiagegrpresu(cie10.getCie10Select().getCdcccodigo());
                diagnosticoPrincipalEgreso = cie10.getCie10Select().getCdccdescri();
            }
            }
            if (cie10.isDiagnosticoRelacionado1()) {
            if(esingreso){
                itDiagrelacUI.setValue(cie10.getCie10Select().getCdcccodigo());
                epicrisis.setHepcdiagingnrelacu(cie10.getCie10Select().getCdcccodigo());
                diagnosticoRelacionadoUIngreso = cie10.getCie10Select().getCdccdescri();
            }
            else{
                itDiagrelacUE.setValue(cie10.getCie10Select().getCdcccodigo());
                epicrisis.setHepcdiagegrrelacu(cie10.getCie10Select().getCdcccodigo());
                diagnosticoRelacionadoUEgreso = cie10.getCie10Select().getCdccdescri();
            }
            }
            if (cie10.isDiagnosticoRelacionado2()) {
                if(esingreso){
                itDiagrelacDI.setValue(cie10.getCie10Select().getCdcccodigo());
                epicrisis.setHepcdiagingrelacd(cie10.getCie10Select().getCdcccodigo());
                diagnosticoRelacionadoDIngreso = cie10.getCie10Select().getCdccdescri();
                }
                else{
                    itDiagrelacDE.setValue(cie10.getCie10Select().getCdcccodigo());
                    epicrisis.setHepcdiagegrrelacd(cie10.getCie10Select().getCdcccodigo());
                    diagnosticoRelacionadoDEgreso = cie10.getCie10Select().getCdccdescri();
                }
            }
            if (cie10.isDiagnosticoRelacionado3()) {
                if(esingreso){
                itDiagrelacTI.setValue(cie10.getCie10Select().getCdcccodigo());
                epicrisis.setHepcdiagingrelact(cie10.getCie10Select().getCdcccodigo());
                diagnosticoRelacionadoTIngreso = cie10.getCie10Select().getCdccdescri();
                }
                else{
                    itDiagrelacTE.setValue(cie10.getCie10Select().getCdcccodigo());
                    epicrisis.setHepcdiagegrrelact(cie10.getCie10Select().getCdcccodigo());
                    diagnosticoRelacionadoTEgreso = cie10.getCie10Select().getCdccdescri();
                }
            }
            else{
                if(esConfirmado){
                    itDiagconf.setValue(cie10.getCie10Select().getCdcccodigo());
                    epicrisis.setHepcdiagnconfi(cie10.getCie10Select().getCdcccodigo());
                    diagnosticoConfirmado = cie10.getCie10Select().getCdccdescri();
                }
            }
        }

        mostrarCie10 = false;
        selectedIndex = ACTIVAR_REGISTRAR_EPICRISIS;
        cie10.clear();

    }

    /**
     * @param epicrisis
     */
    public void setEpicrisis(Chepicrisi epicrisis) {
        this.epicrisis = epicrisis;
    }

    /**
     * @return
     */
    public Chepicrisi getEpicrisis() {
        return epicrisis;
    }


  
    /**
     * @param diagnosticoConfirmado
     */
    public void setDiagnosticoConfirmado(String diagnosticoConfirmado) {
        this.diagnosticoConfirmado = diagnosticoConfirmado;
    }

    /**
     * @return
     */
    public String getDiagnosticoConfirmado() {
        return diagnosticoConfirmado;
    }

    /**
  

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
     * @param itDiagconf
     */
    public void setItDiagconf(UIInput itDiagconf) {
        this.itDiagconf = itDiagconf;
    }

    /**
     * @return
     */
    public UIInput getItDiagconf() {
        return itDiagconf;
    }

 

  

    /**
     * @param lstTipoUsuario
     */
    public void setLstTipoUsuario(List lstTipoUsuario) {
        this.lstTipoUsuario = lstTipoUsuario;
    }

    /**
     * @return
     */
    public List getLstTipoUsuario() {
        if (lstTipoUsuario.size() == 0) {
            ArrayList<Chtipousuari> listTipoUsuarioAux = null;
            try {
                listTipoUsuarioAux = 
                        (ArrayList<Chtipousuari>)this.getServiceLocator().getClinicoService().getTipoUsuario();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listTipoUsuarioAux.isEmpty()) {
                lstTipoUsuario.add(new SelectItem("", 
                                                  "Seleccione una opci�n"));
                Iterator it = listTipoUsuarioAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstTipoUsuario.add(new SelectItem(listTipoUsuarioAux.get(i).getHtuccodigo(), 
                                                      listTipoUsuarioAux.get(i).getHtucdescripcio()));
                    i++;
                }
            }
        }
        return lstTipoUsuario;
    }

    /**
     * @param numeroHoras
     */
    public void setNumeroHoras(long numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    /**
     * @return
     */
    public long getNumeroHoras() {
        return numeroHoras;
    }

    /**
     * @param cirugiaSelect
     */
    public void setCirugiaSelect(Chcirugprogr cirugiaSelect) {
        this.cirugiaSelect = cirugiaSelect;
    }

    /**
     * @return
     */
    public Chcirugprogr getCirugiaSelect() {
        return cirugiaSelect;
    }

    /**
     * @param ingresoenf
     */
    public void setIngresoenf(Chingresoenf ingresoenf) {
        this.ingresoenf = ingresoenf;
    }

    /**
     * @return
     */
    public Chingresoenf getIngresoenf() {
        return ingresoenf;
    }

    /**
     * @param numerocirugia
     */
    public void setNumerocirugia(Long numerocirugia) {
        this.numerocirugia = numerocirugia;
    }

    /**
     * @return
     */
    public Long getNumerocirugia() {
        return numerocirugia;
    }

    /**
     * @param lstCirugiasEgreso
     */
    public void setLstCirugiasEgreso(List<Object[]> lstCirugiasEgreso) {
        this.lstCirugiasEgreso = lstCirugiasEgreso;
    }

    /**
     * @return
     */
    public List<Object[]> getLstCirugiasEgreso() {
        return lstCirugiasEgreso;
    }

    /**
     * @param lstCirugiasIngreso
     */
    public void setLstCirugiasIngreso(List<Cpservicio> lstCirugiasIngreso) {
        this.lstCirugiasIngreso = lstCirugiasIngreso;
    }

    /**
     * @return
     */
    public List<Cpservicio> getLstCirugiasIngreso() {
        return lstCirugiasIngreso;
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
     * @return
     */
    public boolean validarCampos() {
        boolean esValido = true;
        String url = "body:formRegistrarEpicrisis:panelTabRegistrarEpicrisis:";

        if (epicrisis.getHepctipousuari() == null || 
            epicrisis.getHepctipousuari().equals("")) {
            esValido = false;
            FacesUtils.addErrorMessage(url + "mnuTipoUsuario", 
                                       MSG_CAMPO_OBLIGATORIO);
        }

        if (epicrisis.getHepcmotivocons() == null || 
            epicrisis.getHepcmotivocons().equals("")) {
            esValido = false;
            FacesUtils.addErrorMessage(url + "itMotivoConsulta", 
                                       MSG_CAMPO_OBLIGATORIO);
        }

     


        if (epicrisis.getHepcenfeactual() == null || 
            epicrisis.getHepcenfeactual().equals("")) {
            esValido = false;
            FacesUtils.addErrorMessage(url + "itEnfermedadActual", 
                                       MSG_CAMPO_OBLIGATORIO);
        }

        if (epicrisis.getHepcantecedent() == null || 
            epicrisis.getHepcantecedent().equals("")) {
            esValido = false;
            FacesUtils.addErrorMessage(url + "itAntecedentes", 
                                       MSG_CAMPO_OBLIGATORIO);
        }


        if (epicrisis.getHepcrevisistem() == null || 
            epicrisis.getHepcrevisistem().equals("")) {
            esValido = false;
            FacesUtils.addErrorMessage(url + "itRevisionSistemas", 
                                       MSG_CAMPO_OBLIGATORIO);
        }

    
        if (epicrisis.getHepcdiagingnpresu() == null || 
            epicrisis.getHepcdiagingnpresu().equals("")) {
            esValido = false;
            FacesUtils.addErrorMessage(url + "itDiagPrin", 
                                       MSG_CAMPO_OBLIGATORIO);
        }
     
     
        if (epicrisis.getHepcconducta() == null || 
            epicrisis.getHepcconducta().equals("")) {
            esValido = false;
            FacesUtils.addErrorMessage(url + "itConducta", 
                                       MSG_CAMPO_OBLIGATORIO);
        }
        if (epicrisis.getHepcevolucion() == null || 
            epicrisis.getHepcevolucion().equals("")) {
            esValido = false;
            FacesUtils.addErrorMessage(url + "itEvolucion", 
                                       MSG_CAMPO_OBLIGATORIO);
        }

        return esValido;

    }
    



    /**
     * @return
     */
    public String RegistrarEpicrisis() {

        ChepicrisiPK idEpicrisis;
        idEpicrisis = new ChepicrisiPK();
        String cirugiaEgresoString = "";
        String cirugiaIngresoString = "";
        String navetionRule = "";

        if (validarCampos()) {
            if (cirugiaSelect != null && ingresoenf != null) {
                idEpicrisis.setHeplnumero(cirugiaSelect.getHcplnumero());
                epicrisis.setHeplusuario(cirugiaSelect.getHcplusuario().getHuslnumero());
                epicrisis.setHepnclinica(this.getClinica().getCclncodigo());
                epicrisis.setHepcestado(ESTADO_VIGENTE);
                epicrisis.setId(idEpicrisis);
                epicrisis.setHepcoperador(userName());
                epicrisis.setHepdfecregistr(new Date());


                if (lstCirugiasEgreso != null && 
                    !lstCirugiasEgreso.isEmpty()) {
                    for (Object[] cirugiaEgreso: lstCirugiasEgreso) {
                        cirugiaEgresoString = 
                                cirugiaEgresoString + cirugiaEgreso[1] + ",";
                    }
                }

                if (cirugiaEgresoString != null && 
                    !cirugiaEgresoString.equals("")) {
                    cirugiaEgresoString = 
                            cirugiaEgresoString.substring(0, cirugiaEgresoString.length() - 
                                                          1);
                    //epicrisis.setHepcserviegres(cirugiaEgresoString);
                }


                if (lstCirugiasIngreso != null && 
                    !lstCirugiasIngreso.isEmpty()) {
                    for (Cpservicio cirugiaIngreso: lstCirugiasIngreso) {
                        cirugiaIngresoString = 
                                cirugiaIngresoString + cirugiaIngreso.getCsvccodigo() + 
                                ",";
                    }
                }

                if (cirugiaIngresoString != null && 
                    !cirugiaIngresoString.equals("")) {
                    cirugiaIngresoString = 
                            cirugiaIngresoString.substring(0, cirugiaIngresoString.length() - 
                                                           1);
                    //epicrisis.setHepcserviingre(cirugiaIngresoString);
                }
                epicrisis.setHepcserviegres("CI");

                try {
                    this.serviceLocator.getCirugiaService().saveEpicrisis(epicrisis);
                    FacesUtils.addInfoMessage(MSG_ADICION);

                    ListaCirugiaEpicrisisBean consultarEpicrisis = 
                        (ListaCirugiaEpicrisisBean)FacesUtils.getManagedBean("listaCirugiaEpicrisisBean");
                    consultarEpicrisis.cargarCirugias();
                    navetionRule = 
                            BeanNavegacion.RUTA_IR_LISTA_CIRUGIAS_EPICRISIS;
                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_EPICRISIS);
                } catch (Exception ex) {
                    return capturaError(ex,IConstantes.ERROR_EPICRISIS);
                }
            }
        }


        return navetionRule;

    }


    public void setLstServicioIngreso(List<SelectItem> lstServicioIngreso) {       
        this.lstServicioIngreso = lstServicioIngreso;
    }

    public List<SelectItem> getLstServicioIngreso() {
        if(lstServicioIngreso == null || lstServicioIngreso.isEmpty()){
            lstServicioIngreso = new ArrayList<SelectItem>();
            lstServicioIngreso.add(new SelectItem("CP","Cirug�a Programada"));
            lstServicioIngreso.add(new SelectItem("CE","Consulta Externa"));
            lstServicioIngreso.add(new SelectItem("UR","Urgencia"));
        }
        return lstServicioIngreso;
    }

    public void setDiagnosticoPrincipalIngreso(String diagnosticoPrincipalIngreso) {
        this.diagnosticoPrincipalIngreso = diagnosticoPrincipalIngreso;
    }

    public String getDiagnosticoPrincipalIngreso() {
        return diagnosticoPrincipalIngreso;
    }

    public void setDiagnosticoPrincipalEgreso(String diagnosticoPrincipalEgreso) {
        this.diagnosticoPrincipalEgreso = diagnosticoPrincipalEgreso;
    }

    public String getDiagnosticoPrincipalEgreso() {
        return diagnosticoPrincipalEgreso;
    }

    public void setDiagnosticoRelacionadoUEgreso(String diagnosticoRelacionadoUEgreso) {
        this.diagnosticoRelacionadoUEgreso = diagnosticoRelacionadoUEgreso;
    }

    public String getDiagnosticoRelacionadoUEgreso() {
        return diagnosticoRelacionadoUEgreso;
    }

    public void setDiagnosticoRelacionadoDEgreso(String diagnosticoRelacionadoDEgreso) {
        this.diagnosticoRelacionadoDEgreso = diagnosticoRelacionadoDEgreso;
    }

    public String getDiagnosticoRelacionadoDEgreso() {
        return diagnosticoRelacionadoDEgreso;
    }

    public void setDiagnosticoRelacionadoTEgreso(String diagnosticoRelacionadoTEgreso) {
        this.diagnosticoRelacionadoTEgreso = diagnosticoRelacionadoTEgreso;
    }

    public String getDiagnosticoRelacionadoTEgreso() {
        return diagnosticoRelacionadoTEgreso;
    }

    public void setDiagnosticoRelacionadoUIngreso(String diagnosticoRelacionadoUIngreso) {
        this.diagnosticoRelacionadoUIngreso = diagnosticoRelacionadoUIngreso;
    }

    public String getDiagnosticoRelacionadoUIngreso() {
        return diagnosticoRelacionadoUIngreso;
    }

    public void setDiagnosticoRelacionadoDIngreso(String diagnosticoRelacionadoDIngreso) {
        this.diagnosticoRelacionadoDIngreso = diagnosticoRelacionadoDIngreso;
    }

    public String getDiagnosticoRelacionadoDIngreso() {
        return diagnosticoRelacionadoDIngreso;
    }

    public void setDiagnosticoRelacionadoTIngreso(String diagnosticoRelacionadoTIngreso) {
        this.diagnosticoRelacionadoTIngreso = diagnosticoRelacionadoTIngreso;
    }

    public String getDiagnosticoRelacionadoTIngreso() {
        return diagnosticoRelacionadoTIngreso;
    }

    public void setDiagpresu(Crdgncie10 diagpresu) {
        this.diagpresu = diagpresu;
    }

    public Crdgncie10 getDiagpresu() {
        return diagpresu;
    }

    public void setDiagconfir(Crdgncie10 diagconfir) {
        this.diagconfir = diagconfir;
    }

    public Crdgncie10 getDiagconfir() {
        return diagconfir;
    }

    public void setDiagrela(Crdgncie10 diagrela) {
        this.diagrela = diagrela;
    }

    public Crdgncie10 getDiagrela() {
        return diagrela;
    }

    public void setItDiagPresI(UIInput itDiagPresI) {
        this.itDiagPresI = itDiagPresI;
    }

    public UIInput getItDiagPresI() {
        return itDiagPresI;
    }

    public void setItDiagrelacUI(UIInput itDiagrelacUI) {
        this.itDiagrelacUI = itDiagrelacUI;
    }

    public UIInput getItDiagrelacUI() {
        return itDiagrelacUI;
    }

    public void setItDiagrelacDI(UIInput itDiagrelacDI) {
        this.itDiagrelacDI = itDiagrelacDI;
    }

    public UIInput getItDiagrelacDI() {
        return itDiagrelacDI;
    }

    public void setItDiagrelacTI(UIInput itDiagrelacTI) {
        this.itDiagrelacTI = itDiagrelacTI;
    }

    public UIInput getItDiagrelacTI() {
        return itDiagrelacTI;
    }

    public void setItDiagrelacUE(UIInput itDiagrelacUE) {
        this.itDiagrelacUE = itDiagrelacUE;
    }

    public UIInput getItDiagrelacUE() {
        return itDiagrelacUE;
    }

    public void setItDiagrelacDE(UIInput itDiagrelacDE) {
        this.itDiagrelacDE = itDiagrelacDE;
    }

    public UIInput getItDiagrelacDE() {
        return itDiagrelacDE;
    }

    public void setItDiagrelacTE(UIInput itDiagrelacTE) {
        this.itDiagrelacTE = itDiagrelacTE;
    }

    public UIInput getItDiagrelacTE() {
        return itDiagrelacTE;
    }

    public void setItDiagPresE(UIInput itDiagPresE) {
        this.itDiagPresE = itDiagPresE;
    }

    public UIInput getItDiagPresE() {
        return itDiagPresE;
    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setProfesionalAct(Cpprofesio profesionalAct) {
        this.profesionalAct = profesionalAct;
    }

    public Cpprofesio getProfesionalAct() {
        return profesionalAct;
    }

    public void setSexo(String sexo) {
    if(sexo !=null){
    if(sexo.equals("M")){
        sexo ="Hombre";
    }
    else if(sexo.equals("F")){
        sexo ="Mujer";
    }
    else{
        sexo ="Indeterminado";
    }
    }
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }
}


