//=======================================================================
// ARCHIVO TamizajePrenatalUsuarioBean.java
// FECHA CREACI�N: 09/06/2010
// AUTOR: Jos� Andr�s Riano Rinc�n jariano@profamilia.org.co
// Descripci�n: Datos correspondientes a la Gestaci�n Prenatal
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chgestacion;
import org.profamilia.hc.model.dto.ChgestacionPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE TamizajePrenatalUsuarioBean
//=======================================================================

public class GestacionPrenatalUsuarioBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    private Chgestacion gestacion;

    /** Almacena la lista de opciones */
    private List lstOpciones;

    private List lstGrupo;

    private List<SelectItem> lstRH;

    private boolean mostrarFechaAntitetanica;

    private boolean mostrarFechaAntitetanica2;

    private boolean mostrarAntirubeola;

    private boolean desAntitetanicaPrevia;
    private boolean desAntitetanicaActual1;
    private boolean desAntitetanicaActual2;
    private boolean desAntirubeolaPrevia;
    private boolean desAntirubeolaActual;
    private boolean desGrupoPaciente;
    private boolean desRHPaciente;
    private boolean desGrupoEsposo;
    private boolean desRHEsposo;
    private boolean desSensibilizacion;
    private boolean desSolicitoVIH;
    private boolean desRealizoVIH;

    private Integer tipoHistoria;

    private boolean mostrarLabelFecha1;

    private boolean mostrarLabelFecha2;

    /** Almacena el consulta */
    private Cnconsclin consulta;

    private String navigationRule;

    private String tipoServicio;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    /**  */
    private String menuBean;

    private String nextAction;
    
    private UIInput mnuAntitetanicaPrevia; 
    
    private UIInput mnuAntitetanicaActual2; 
    
    private UIInput mnuAntirubeolaActual;
    
    private Double semanaEmbarazo;
    
    private boolean habilitarpresentacionFetal;
    
    private boolean habilitarAlturaUterina;
    
    private boolean habilitarFCF;
    
    private boolean habilitarmovimientoFetal;
    
    private List lstOpcionesSemanas;
    
    private Date fechaultimaregla;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public GestacionPrenatalUsuarioBean() {
    }


    public void init() {
        inicializarGestacion();
    }

    public void inicializarGestacion() {

        try {
            gestacion = 
                    this.serviceLocator.getClinicoService().getGestacionActual(consulta);
        } catch (ModelException e) {
            e.printStackTrace();
        }
        semanaEmbarazo= null;
        habilitarpresentacionFetal= false;

        if (gestacion == null) {
            gestacion = new Chgestacion();
            inicializarCampos(gestacion);
        } else {
            inicializarCampos(gestacion);
        }
    }


    //-----------------------------------------------------------------------
    //  GET/SET
    //-----------------------------------------------------------------------

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
     * @param gestacion
     */
    public void setGestacion(Chgestacion gestacion) {
        this.gestacion = gestacion;
    }

    /**
     * @return
     */
    public Chgestacion getGestacion() {
        return gestacion;
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
     * @param lstGrupo
     */
    public void setLstGrupo(List lstGrupo) {
        this.lstGrupo = lstGrupo;
    }

    /**
     * @return
     */
    public List getLstGrupo() {
        if (lstGrupo == null || lstGrupo.isEmpty()) {
            lstGrupo = new ArrayList();
            lstGrupo.add(new SelectItem("", "--"));
            lstGrupo.add(new SelectItem("O", "O"));
            lstGrupo.add(new SelectItem("A", "A"));
            lstGrupo.add(new SelectItem("B", "B"));
            lstGrupo.add(new SelectItem("AB", "AB"));

        }

        return lstGrupo;
    }

    /**
     * @param lstRH
     */
    public void setLstRH(List<SelectItem> lstRH) {
        this.lstRH = lstRH;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstRH() {
        if (lstRH == null || lstRH.isEmpty()) {
            lstRH = new ArrayList<SelectItem>();
            lstRH.add(new SelectItem("", "--"));
            lstRH.add(new SelectItem("+", "POS"));
            lstRH.add(new SelectItem("-", "NEG"));
        }
        return lstRH;
    }

    /**
     * @param mostrarFechaAntitetanica
     */
    public void setMostrarFechaAntitetanica(boolean mostrarFechaAntitetanica) {
        this.mostrarFechaAntitetanica = mostrarFechaAntitetanica;
    }

    /**
     * @return
     */
    public boolean isMostrarFechaAntitetanica() {
        return mostrarFechaAntitetanica;
    }

    /**
     * @param mostrarFechaAntitetanica2
     */
    public void setMostrarFechaAntitetanica2(boolean mostrarFechaAntitetanica2) {
        this.mostrarFechaAntitetanica2 = mostrarFechaAntitetanica2;
    }

    /**
     * @return
     */
    public boolean isMostrarFechaAntitetanica2() {
        return mostrarFechaAntitetanica2;
    }

    /**
     * @param mostrarAntirubeola
     */
    public void setMostrarAntirubeola(boolean mostrarAntirubeola) {
        this.mostrarAntirubeola = mostrarAntirubeola;
    }

    /**
     * @return
     */
    public boolean isMostrarAntirubeola() {
        return mostrarAntirubeola;
    }

    /**
     * @param mostrarLabelFecha1
     */
    public void setMostrarLabelFecha1(boolean mostrarLabelFecha1) {
        this.mostrarLabelFecha1 = mostrarLabelFecha1;
    }

    /**
     * @return
     */
    public boolean isMostrarLabelFecha1() {
        return mostrarLabelFecha1;
    }

    /**
     * @param mostrarLabelFecha2
     */
    public void setMostrarLabelFecha2(boolean mostrarLabelFecha2) {
        this.mostrarLabelFecha2 = mostrarLabelFecha2;
    }

    /**
     * @return
     */
    public boolean isMostrarLabelFecha2() {
        return mostrarLabelFecha2;
    }

    /**
     * @param desAntitetanicaPrevia
     */
    public void setDesAntitetanicaPrevia(boolean desAntitetanicaPrevia) {
        this.desAntitetanicaPrevia = desAntitetanicaPrevia;
    }

    /**
     * @return
     */
    public boolean isDesAntitetanicaPrevia() {
        return desAntitetanicaPrevia;
    }

    /**
     * @param desAntitetanicaActual1
     */
    public void setDesAntitetanicaActual1(boolean desAntitetanicaActual1) {
        this.desAntitetanicaActual1 = desAntitetanicaActual1;
    }

    /**
     * @return
     */
    public boolean isDesAntitetanicaActual1() {
        return desAntitetanicaActual1;
    }

    /**
     * @param desAntitetanicaActual2
     */
    public void setDesAntitetanicaActual2(boolean desAntitetanicaActual2) {
        this.desAntitetanicaActual2 = desAntitetanicaActual2;
    }

    /**
     * @return
     */
    public boolean isDesAntitetanicaActual2() {
        return desAntitetanicaActual2;
    }

    /**
     * @param desAntirubeolaPrevia
     */
    public void setDesAntirubeolaPrevia(boolean desAntirubeolaPrevia) {
        this.desAntirubeolaPrevia = desAntirubeolaPrevia;
    }

    /**
     * @return
     */
    public boolean isDesAntirubeolaPrevia() {
        return desAntirubeolaPrevia;
    }

    /**
     * @param desAntirubeolaActual
     */
    public void setDesAntirubeolaActual(boolean desAntirubeolaActual) {
        this.desAntirubeolaActual = desAntirubeolaActual;
    }

    /**
     * @return
     */
    public boolean isDesAntirubeolaActual() {
        return desAntirubeolaActual;
    }


    /**
     * @param desGrupoPaciente
     */
    public void setDesGrupoPaciente(boolean desGrupoPaciente) {
        this.desGrupoPaciente = desGrupoPaciente;
    }

    /**
     * @return
     */
    public boolean isDesGrupoPaciente() {
        return desGrupoPaciente;
    }

    /**
     * @param desRHPaciente
     */
    public void setDesRHPaciente(boolean desRHPaciente) {
        this.desRHPaciente = desRHPaciente;
    }

    /**
     * @return
     */
    public boolean isDesRHPaciente() {
        return desRHPaciente;
    }

    /**
     * @param desGrupoEsposo
     */
    public void setDesGrupoEsposo(boolean desGrupoEsposo) {
        this.desGrupoEsposo = desGrupoEsposo;
    }

    /**
     * @return
     */
    public boolean isDesGrupoEsposo() {
        return desGrupoEsposo;
    }

    /**
     * @param desRHEsposo
     */
    public void setDesRHEsposo(boolean desRHEsposo) {
        this.desRHEsposo = desRHEsposo;
    }

    /**
     * @return
     */
    public boolean isDesRHEsposo() {
        return desRHEsposo;
    }

    /**
     * @param desSensibilizacion
     */
    public void setDesSensibilizacion(boolean desSensibilizacion) {
        this.desSensibilizacion = desSensibilizacion;
    }

    /**
     * @return
     */
    public boolean isDesSensibilizacion() {
        return desSensibilizacion;
    }

    /**
     * @param desSolicitoVIH
     */
    public void setDesSolicitoVIH(boolean desSolicitoVIH) {
        this.desSolicitoVIH = desSolicitoVIH;
    }

    /**
     * @return
     */
    public boolean isDesSolicitoVIH() {
        return desSolicitoVIH;
    }

    /**
     * @param desRealizoVIH
     */
    public void setDesRealizoVIH(boolean desRealizoVIH) {
        this.desRealizoVIH = desRealizoVIH;
    }

    /**
     * @return
     */
    public boolean isDesRealizoVIH() {
        return desRealizoVIH;
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
     * @param mnuAntitetanicaPrevia
     */
    public void setMnuAntitetanicaPrevia(UIInput mnuAntitetanicaPrevia) {
        this.mnuAntitetanicaPrevia = mnuAntitetanicaPrevia;
    }

    /**
     * @return
     */
    public UIInput getMnuAntitetanicaPrevia() {
        return mnuAntitetanicaPrevia;
    }

    /**
     * @param mnuAntitetanicaActual2
     */
    public void setMnuAntitetanicaActual2(UIInput mnuAntitetanicaActual2) {
        this.mnuAntitetanicaActual2 = mnuAntitetanicaActual2;
    }

    /**
     * @return
     */
    public UIInput getMnuAntitetanicaActual2() {
        return mnuAntitetanicaActual2;
    }

    /**
     * @param mnuAntirubeolaActual
     */
    public void setMnuAntirubeolaActual(UIInput mnuAntirubeolaActual) {
        this.mnuAntirubeolaActual = mnuAntirubeolaActual;
    }

    public UIInput getMnuAntirubeolaActual() {
        return mnuAntirubeolaActual;
    }


    //-----------------------------------------------------------------------
    //  AJAX
    //-----------------------------------------------------------------------


    /**
     * @param valueChangeEvent
     */
    public void setAntitetanicaActual(ValueChangeEvent valueChangeEvent) {
        gestacion.setHgeeantidosis1((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setAntitetanicaActual2(ValueChangeEvent valueChangeEvent) {
        gestacion.setHgeeantidosis2((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setAntirubeola(ValueChangeEvent valueChangeEvent) {
        gestacion.setHgeeactantrube((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void ChangeAntitetanica() {

        if (gestacion != null && gestacion.getHgeeantidosis1() != null && 
            gestacion.getHgeeantidosis1().equals("S")) {
            mostrarFechaAntitetanica = true;
        } else {
            gestacion.setHgedfecantdos1(null);
            mostrarFechaAntitetanica = false;
        }
    }

    public void ChangeAntitetanica2() {
        if (gestacion != null && gestacion.getHgeeantidosis2() != null && 
            gestacion.getHgeeantidosis2().equals("S")) {
            mostrarFechaAntitetanica2 = true;
        } else {
            gestacion.setHgedfecantdos2(null);
            mostrarFechaAntitetanica2 = false;
        }
    }

    public void ChangeAntirubeola() {
        if (gestacion != null && gestacion.getHgeeactantrube() != null && 
            gestacion.getHgeeactantrube().equals("S")) {
            mostrarAntirubeola = true;
        } else {
            gestacion.setHgedfecantrube(null);
            mostrarAntirubeola = false;
        }
    }


    public boolean esValido() {
        boolean esValido = false;
        Chgestacion gestacionAux = null;
        if (consulta != null) {
            try {
                gestacionAux = 
                        this.serviceLocator.getClinicoService().getGestacionActual(consulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (gestacionAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }

    /**
     * @param gestacionActual
     */
    public void desHabilitarCampos(Chgestacion gestacionActual) {
        if (gestacionActual != null) {
            if (gestacionActual.getHgecgrupoespos() != null) {
                desGrupoEsposo = true;
            }
            if (gestacionActual.getHgecgrupopacie() != null) {
                desGrupoPaciente = true;
            }
            if (gestacionActual.getHgecrhesposo() != null) {
                desRHEsposo = true;
            }
            if (gestacionActual.getHgecrhpaciente() != null) {
                desRHPaciente = true;
            }
            if (gestacionActual.getHgecsensibilid() != null) {
                desSensibilizacion = true;
            }
            if (gestacionActual.getHgeeactantrube() != null) {
                desAntirubeolaActual = true;
            }
            if (gestacionActual.getHgeeantidosis1() != null) {
                desAntitetanicaActual1 = true;
            }
            if (gestacionActual.getHgeeantidosis2() != null) {
                desAntitetanicaActual2 = true;
            }
            if (gestacionActual.getHgeepreantrube() != null) {
                desAntirubeolaPrevia = true;
            }
            if (gestacionActual.getHgeeprevantite() != null) {
                desAntitetanicaPrevia = true;
            }
            if (gestacionActual.getHgeerealizvih1() != null) {
                desRealizoVIH = true;
            }


            if (gestacionActual.getHgeesolicivih1() != null) {
                desSolicitoVIH = true;
            }

        }

    }

    /**
     * @param gestacionActual
     */
    public void inicializarCampos(Chgestacion gestacionActual) {
        if (gestacionActual.getHgeeantidosis1() != null && 
            gestacionActual.getHgeeantidosis1().equals("S")) {
            mostrarFechaAntitetanica = true;
        } else {
            mostrarFechaAntitetanica = false;
        }
        if (gestacionActual.getHgeeantidosis2() != null && 
            gestacionActual.getHgeeantidosis2().equals("S")) {
            mostrarFechaAntitetanica2 = true;
        } else {
            mostrarFechaAntitetanica2 = false;
        }
        if (gestacionActual.getHgeeactantrube() != null && 
            gestacionActual.getHgeeactantrube().equals("S")) {
            mostrarAntirubeola = true;
        } else {
            mostrarAntirubeola = false;
        }
        if(fechaultimaregla != null){
            validacionSemanas(fechaultimaregla);
        }

    }
    
    public void validacionSemanas(Date fecha){
    
        semanaEmbarazo = calcularSemanasEmbarazo(fecha);
        if (semanaEmbarazo != null) {
            // Si estamos en la semana 15 o superior se pide la alturauterina
            if (semanaEmbarazo >= 15) {
                habilitarAlturaUterina = true;
            } else {
                habilitarAlturaUterina = false;
            }
            // Si estamos en la semana 18 o superior pedimos la frecuencia cardiaca fetal
            if (semanaEmbarazo >= 18) {
                habilitarFCF = true;
            } else {
                habilitarFCF = false;
            }
            // Si estamos en la semana 14 o superior pedimos el movimiento fetal
            if (semanaEmbarazo >= 14) {
                habilitarmovimientoFetal = true;
            } else {
                habilitarmovimientoFetal = false;
            }

            // Si estamos en la semana 32 o superior pedimos la presentaci�n fetal
            if (semanaEmbarazo >= 32) {
                habilitarpresentacionFetal = true;
            } else {
                habilitarpresentacionFetal = false;
            }

        }
    
    
    }
   /* 
    public void onchangeFechaUltimaCitologia(){
        if(gestacion.getHgecfecultmes() != null){
            validacionSemanas(gestacion.getHgecfecultmes());
        }
    }
    */
    

        /**
         * @param valueChangeEvent
         */
    /*
        public void setHgecfecultmes(ValueChangeEvent valueChangeEvent) {
            gestacion.setHgecfecultmes((Date)valueChangeEvent.getNewValue());
            ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
*/


    public void changeTodosSi() {
        mostrarFechaAntitetanica = true;
        mostrarFechaAntitetanica2 = true;
        mostrarAntirubeola = true;
        inicializarPreguntas("S");

    }

    public void changeTodosNo() {
        mostrarFechaAntitetanica = false;
        mostrarFechaAntitetanica2 = false;
        mostrarAntirubeola = false;
        inicializarPreguntas("N");

    }

    public void changeNinguno() {
        mostrarFechaAntitetanica = false;
        mostrarFechaAntitetanica2 = false;
        mostrarAntirubeola = false;
        inicializarPreguntas(null);
    }


    public void inicializarPreguntas(String opcion) {
        if (gestacion != null) {
            gestacion.setHgeeprevantite(opcion);
            gestacion.setHgeeantidosis1(opcion);
            gestacion.setHgeeantidosis2(opcion);
            gestacion.setHgeepreantrube(opcion);
            gestacion.setHgeeactantrube(opcion);
            gestacion.setHgecsensibilid(opcion);
            gestacion.setHgeesolicivih1(opcion);
            gestacion.setHgeerealizvih1(opcion);

            mnuAntitetanicaPrevia.setValue(opcion);
            mnuAntitetanicaActual2.setValue(opcion);
            mnuAntirubeolaActual.setValue(opcion);

        }
    }


    //-----------------------------------------------------------------------
    //  Bot�n Principal
    //-----------------------------------------------------------------------

    /**
     * @return
     */
    public String aceptar() {
        navigationRule = "";
        ChgestacionPK id = new ChgestacionPK();
     if(gestacion!= null){
        if (consulta != null && consulta.getCconnumero() != null) {
            id.setHgelconsulta(new Long(consulta.getCconnumero()));
            id.setHgectiposervi(TIPO_CONSULTA);
            gestacion.setId(id);
            gestacion.setHgelconsulprin(new Long(consulta.getCconnumero()));
        }
       
            if(gestacion.getHgeeantidosis1() == null || gestacion.getHgeeantidosis1().equals("N")){
                gestacion.setHgedfecantdos1(null);
            }
            
            if(gestacion.getHgeeantidosis2() == null || gestacion.getHgeeantidosis2().equals("N")){
               gestacion.setHgedfecantdos2(null); 
            }
            
            if(gestacion.getHgeeactantrube() == null || gestacion.getHgeeactantrube().equals("N")){
                gestacion.setHgedfecantrube(null);
            }
            if(!habilitarmovimientoFetal){
                gestacion.setHgecmovimfetal(null);
            }
            
            
            gestacion.setHgedfecregistr(new Date());
            gestacion.setHgecoperador(userName());
            
            try {
                this.serviceLocator.getClinicoService().saveGestacionActual(gestacion);
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


    public void setSemanaEmbarazo(Double semanaEmbarazo) {
        this.semanaEmbarazo = semanaEmbarazo;
    }

    public Double getSemanaEmbarazo() {
        return semanaEmbarazo;
    }
    
    public double calcularSemanasEmbarazo(Date fechaultimaregla) {
        //Creo las dos instancias de fecha
        int semanaAux = 0;
        Integer residuo = 0;
        double semana = 0;
        Double dias = new Double(0);
        String imcStr = "";
        if (fechaultimaregla != null) {

            Calendar calendarconsulta = Calendar.getInstance();
            Calendar calendarUltimaRegla = Calendar.getInstance();
            calendarUltimaRegla.setTime(fechaultimaregla);
            //Realizo la operaci�n
            long time = 
                calendarconsulta.getTimeInMillis() - calendarUltimaRegla.getTimeInMillis();
            //Muestro el resultado en d�as
            dias = new Double((time / (3600 * 24 * 1000)));
            semanaAux = (dias.intValue() / 7);
            residuo = dias.intValue() % 7;

            semana = semanaAux + residuo.doubleValue() / 10;


            if (semana < 0) {
                semana = 0;
            }

            if (semana >= 43) {
                semana = 0;
            } 
        }
        return semana;
    }

    public void setHabilitarpresentacionFetal(boolean habilitarpresentacionFetal) {
        this.habilitarpresentacionFetal = habilitarpresentacionFetal;
    }

    public boolean isHabilitarpresentacionFetal() {
        return habilitarpresentacionFetal;
    }

    public void setHabilitarAlturaUterina(boolean habilitarAlturaUterina) {
        this.habilitarAlturaUterina = habilitarAlturaUterina;
    }

    public boolean isHabilitarAlturaUterina() {
        return habilitarAlturaUterina;
    }

    public void setHabilitarFCF(boolean habilitarFCF) {
        this.habilitarFCF = habilitarFCF;
    }

    public boolean isHabilitarFCF() {
        return habilitarFCF;
    }

    public void setHabilitarmovimientoFetal(boolean habilitarmovimientoFetal) {
        this.habilitarmovimientoFetal = habilitarmovimientoFetal;
    }

    public boolean isHabilitarmovimientoFetal() {
        return habilitarmovimientoFetal;
    }

    public void setLstOpcionesSemanas(List lstOpcionesSemanas) {
        this.lstOpcionesSemanas = lstOpcionesSemanas;
    }

    public List getLstOpcionesSemanas() {
        if (lstOpcionesSemanas == null || lstOpcionesSemanas.isEmpty()) {
            lstOpcionesSemanas = new ArrayList();
            lstOpcionesSemanas.add(new SelectItem("", "Seleccione una opcion ..."));
            lstOpcionesSemanas.add(new SelectItem("FE", "Fecha de la �ltima menstruaci�n"));
            lstOpcionesSemanas.add(new SelectItem("AU", "Altura Uterina"));
            lstOpcionesSemanas.add(new SelectItem("EO", "Ecograf�a Obst�trica"));
        }
        return lstOpcionesSemanas;
    }

    public void setFechaultimaregla(Date fechaultimaregla) {
        this.fechaultimaregla = fechaultimaregla;
    }

    public Date getFechaultimaregla() {
        return fechaultimaregla;
    }
}


