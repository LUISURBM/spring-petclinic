//=======================================================================
// ARCHIVO GestacionControlPranatalUsuarioBean.java
// FECHA CREACI�N: 09/06/2010
// AUTOR: Jos� Andr�s Riano jariano@profamilia.org.co
// Descripci�n: Datos correspondientes a la gestacion del control prenatal 
// patologica.
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
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
//  CLASE GestacionControlPranatalUsuarioBean
//=======================================================================

public class GestacionControlPranatalUsuarioBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chgestacion gestacion;

    /** Almacena la lista de opciones */
    private List lstOpciones;

    private List lstGrupo;

    private List lstRH;

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


    private Long codigoHistoriaPrincipal;

    private Date fup;

    private Integer tipoHistoria;

    private String menuBean;

    /** Almacena el consulta */
    private Cnconsclin consulta;

    private String navigationRule;

    private String nextAction;

    private String tipoServicio;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;
    
    private UIInput mnuAntitetanicaPrevia; 
    
    private UIInput mnuAntitetanicaActual2;
    
    private UIInput mnuAntirubeolaActual; 

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public GestacionControlPranatalUsuarioBean() {
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
        if (usuario != null && usuario.getHuslnumero() != null) {
            try {
                codigoHistoriaPrincipal = 
                        this.serviceLocator.getClinicoService().getConsultaPrenatalPrincipal(usuario.getHuslnumero());
                if (codigoHistoriaPrincipal != null) {
                    fup = 
this.serviceLocator.getClinicoService().getFechaUltimoPeriodo(codigoHistoriaPrincipal);
                    Integer semana;
                    semana = calcularSemana(fup);
                }
            } catch (ModelException e) {
                e.printStackTrace();
            }

        }


        if (gestacion == null) {
            try {
                if (usuario != null && usuario.getHuslnumero() != null) {
                    gestacion = 
                            this.serviceLocator.getClinicoService().getGestacionControlPrenatal(usuario.getHuslnumero());
                }

            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (gestacion == null) {
                gestacion = new Chgestacion();
            } else {
                inicializarCampos(gestacion);
                desHabilitarCampos(gestacion);
            }


        } else {

            inicializarCampos(gestacion);
            desHabilitarCampos(gestacion);

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


    }


    //-----------------------------------------------------------------------
    //  GET/SET
    //-----------------------------------------------------------------------


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
    public void setLstRH(List lstRH) {
        this.lstRH = lstRH;
    }

    /**
     * @return
     */
    public List getLstRH() {
        if (lstRH == null || lstRH.isEmpty()) {
            lstRH = new ArrayList();
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

    /**
     * @return
     */
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


    //-----------------------------------------------------------------------
    // METODO ESVALIDO
    //-----------------------------------------------------------------------


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
            if(!desAntitetanicaPrevia){
                gestacion.setHgeeprevantite(opcion);    
                mnuAntitetanicaPrevia.setValue(opcion);
            }
            
            if(!desAntitetanicaActual1){
                gestacion.setHgeeantidosis1(opcion);    
                mnuAntitetanicaActual2.setValue(opcion);
            }
            
            if(!desAntitetanicaActual2){
                gestacion.setHgeeantidosis2(opcion);    
            }
            
            if(!desAntirubeolaPrevia){
                gestacion.setHgeepreantrube(opcion);    
            }
            
            if(!desAntirubeolaActual){
                gestacion.setHgeeactantrube(opcion);    
                mnuAntirubeolaActual.setValue(opcion);
            }
            
            if(!desSensibilizacion){
                gestacion.setHgecsensibilid(opcion);    
            }
            if(!desSolicitoVIH){
                gestacion.setHgeesolicivih1(opcion);    
            }
            if(!desRealizoVIH){
                gestacion.setHgeerealizvih1(opcion);
            }
            

        }
    }




 

    //-----------------------------------------------------------------------
    //  BOT�N PRINCIPAL
    //-----------------------------------------------------------------------

    public String aceptar() {
        ChgestacionPK id = new ChgestacionPK();
        navigationRule = "";
        if (consulta != null && consulta.getCconnumero() != null) {
            id.setHgelconsulta(new Long(consulta.getCconnumero()));
            id.setHgectiposervi(TIPO_CONSULTA);
            gestacion.setId(id);
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

        gestacion.setHgedfecregistr(new Date());
        gestacion.setHgecoperador(userName());
        if (codigoHistoriaPrincipal != null) {
            gestacion.setHgelconsulprin(codigoHistoriaPrincipal);
        }

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

        return navigationRule;
    }



}


