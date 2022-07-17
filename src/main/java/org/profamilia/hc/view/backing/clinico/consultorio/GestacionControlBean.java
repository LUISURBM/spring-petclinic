package org.profamilia.hc.view.backing.clinico.consultorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chgestacion;
import org.profamilia.hc.model.dto.ChgestacionPK;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class GestacionControlBean extends BaseBean {


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

    /** Almacena el Bean de Datos de Usuario*/
    DatosBasicosUsuarioBean datosUsuario;

    private boolean mostrarLabelFecha1;

    private boolean mostrarLabelFecha2;

    private Long codigoHistoriaPrincipal;

    private Date fup;

    private Integer tipoHistoria;


    public GestacionControlBean() {
    }


    public void init() {

        lstOpciones = new ArrayList();
        lstGrupo = new ArrayList();
        lstRH = new ArrayList();

        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

        try {
            gestacion = 
                    this.serviceLocator.getClinicoService().getGestacionActual(datosUsuario.getConsulta());
        } catch (ModelException e) {
            e.printStackTrace();
        }

        try {
            codigoHistoriaPrincipal = 
                    this.serviceLocator.getClinicoService().getConsultaPrenatalPrincipal(datosUsuario.getUsuario().getHuslnumero());
            if (codigoHistoriaPrincipal != null) {
                fup = 
this.serviceLocator.getClinicoService().getFechaUltimoPeriodo(codigoHistoriaPrincipal);
                Integer semana = calcularSemana(fup);
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }


        if (gestacion == null) {
            try {
                if (datosUsuario != null && 
                    datosUsuario.getUsuario() != null && 
                    datosUsuario.getUsuario().getHuslnumero() != null) {
                    gestacion = 
                            this.serviceLocator.getClinicoService().getGestacionControlPrenatal(datosUsuario.getUsuario().getHuslnumero());
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


    public void setGestacion(Chgestacion gestacion) {
        this.gestacion = gestacion;
    }

    public Chgestacion getGestacion() {
        return gestacion;
    }


    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    public List getLstOpciones() {
        if (lstOpciones.size() == 0) {
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));

        }

        return lstOpciones;
    }


    public void setLstGrupo(List lstGrupo) {
        this.lstGrupo = lstGrupo;
    }

    public List getLstGrupo() {
        if (lstGrupo.size() == 0) {
            lstGrupo.add(new SelectItem("", "--"));
            lstGrupo.add(new SelectItem("O", "O"));
            lstGrupo.add(new SelectItem("A", "A"));
            lstGrupo.add(new SelectItem("B", "B"));
            lstGrupo.add(new SelectItem("AB", "AB"));

        }

        return lstGrupo;
    }

    public void setLstRH(List lstRH) {
        this.lstRH = lstRH;
    }

    public List getLstRH() {
        if (lstRH.size() == 0) {
            lstRH.add(new SelectItem("", "--"));
            lstRH.add(new SelectItem("+", "POS"));
            lstRH.add(new SelectItem("-", "NEG"));
        }
        return lstRH;
    }

    public void setMostrarFechaAntitetanica(boolean mostrarFechaAntitetanica) {
        this.mostrarFechaAntitetanica = mostrarFechaAntitetanica;
    }

    public boolean isMostrarFechaAntitetanica() {
        return mostrarFechaAntitetanica;
    }

    public void setMostrarFechaAntitetanica2(boolean mostrarFechaAntitetanica2) {
        this.mostrarFechaAntitetanica2 = mostrarFechaAntitetanica2;
    }

    public boolean isMostrarFechaAntitetanica2() {
        return mostrarFechaAntitetanica2;
    }

    public void setMostrarAntirubeola(boolean mostrarAntirubeola) {
        this.mostrarAntirubeola = mostrarAntirubeola;
    }

    public boolean isMostrarAntirubeola() {
        return mostrarAntirubeola;
    }

    public void setDesAntitetanicaPrevia(boolean desAntitetanicaPrevia) {
        this.desAntitetanicaPrevia = desAntitetanicaPrevia;
    }

    public boolean isDesAntitetanicaPrevia() {
        return desAntitetanicaPrevia;
    }

    public void setDesAntitetanicaActual1(boolean desAntitetanicaActual1) {
        this.desAntitetanicaActual1 = desAntitetanicaActual1;
    }

    public boolean isDesAntitetanicaActual1() {
        return desAntitetanicaActual1;
    }

    public void setDesAntitetanicaActual2(boolean desAntitetanicaActual2) {
        this.desAntitetanicaActual2 = desAntitetanicaActual2;
    }

    public boolean isDesAntitetanicaActual2() {
        return desAntitetanicaActual2;
    }

    public void setDesAntirubeolaPrevia(boolean desAntirubeolaPrevia) {
        this.desAntirubeolaPrevia = desAntirubeolaPrevia;
    }

    public boolean isDesAntirubeolaPrevia() {
        return desAntirubeolaPrevia;
    }

    public void setDesAntirubeolaActual(boolean desAntirubeolaActual) {
        this.desAntirubeolaActual = desAntirubeolaActual;
    }

    public boolean isDesAntirubeolaActual() {
        return desAntirubeolaActual;
    }


    public void setDesGrupoPaciente(boolean desGrupoPaciente) {
        this.desGrupoPaciente = desGrupoPaciente;
    }

    public boolean isDesGrupoPaciente() {
        return desGrupoPaciente;
    }

    public void setDesRHPaciente(boolean desRHPaciente) {
        this.desRHPaciente = desRHPaciente;
    }

    public boolean isDesRHPaciente() {
        return desRHPaciente;
    }

    public void setDesGrupoEsposo(boolean desGrupoEsposo) {
        this.desGrupoEsposo = desGrupoEsposo;
    }

    public boolean isDesGrupoEsposo() {
        return desGrupoEsposo;
    }

    public void setDesRHEsposo(boolean desRHEsposo) {
        this.desRHEsposo = desRHEsposo;
    }

    public boolean isDesRHEsposo() {
        return desRHEsposo;
    }

    public void setDesSensibilizacion(boolean desSensibilizacion) {
        this.desSensibilizacion = desSensibilizacion;
    }

    public boolean isDesSensibilizacion() {
        return desSensibilizacion;
    }

    public void setDesSolicitoVIH(boolean desSolicitoVIH) {
        this.desSolicitoVIH = desSolicitoVIH;
    }

    public boolean isDesSolicitoVIH() {
        return desSolicitoVIH;
    }

    public void setDesRealizoVIH(boolean desRealizoVIH) {
        this.desRealizoVIH = desRealizoVIH;
    }

    public boolean isDesRealizoVIH() {
        return desRealizoVIH;
    }


    public void setAntitetanicaActual(ValueChangeEvent valueChangeEvent) {
        gestacion.setHgeeantidosis1((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setAntitetanicaActual2(ValueChangeEvent valueChangeEvent) {
        gestacion.setHgeeantidosis2((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

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
        if (datosUsuario != null && datosUsuario.getConsulta() != null) {
            try {
                gestacionAux = 
                        this.serviceLocator.getClinicoService().getGestacionActual(datosUsuario.getConsulta());
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


    }

   
    public void aceptar() {
        ChgestacionPK id = new ChgestacionPK();
        if (datosUsuario != null && datosUsuario.getConsulta() != null && 
            datosUsuario.getConsulta().getCconnumero() != null) {
            id.setHgelconsulta(new Long(datosUsuario.getConsulta().getCconnumero()));
            id.setHgectiposervi(TIPO_CONSULTA);
            gestacion.setId(id);
        }

        gestacion.setHgedfecregistr(new Date());
        gestacion.setHgecoperador(userName());
        if (codigoHistoriaPrincipal != null) {
            gestacion.setHgelconsulprin(codigoHistoriaPrincipal);
        }

        try {
            this.serviceLocator.getClinicoService().saveGestacionActual(gestacion);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            e.printStackTrace();
        }
    }


    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    public Integer getTipoHistoria() {
        return tipoHistoria;
    }
}


