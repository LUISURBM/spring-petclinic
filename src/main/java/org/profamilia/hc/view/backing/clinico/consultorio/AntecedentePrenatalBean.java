package org.profamilia.hc.view.backing.clinico.consultorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chantecprena;
import org.profamilia.hc.model.dto.ChantecprenaPK;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class AntecedentePrenatalBean extends BaseBean {


    private Chantecprena antecedente;

    /** Almacena el Bean de Datos de Usuario*/
    DatosBasicosUsuarioBean datosUsuario;

    /** Almacena la lista de opciones */
    private List lstOpciones;

    private boolean mostrarFamiliar;

    private boolean mostrarPersonal;

    private boolean mostrarHTAper;

    private boolean mostrarHTAfam;

    private boolean mostrarDiaper;

    private boolean mostrarDiafam;

    private boolean mostrarPreEclper;

    private boolean mostrarPreEclfam;

    private boolean mostrarEclper;

    private boolean mostrarEclfam;

    private boolean mostrarGemfam;

    private boolean mostrarCardiopatiafam;

    private boolean mostrarTBCfam;

    private boolean mostrarTBCper;

    private boolean mostrarpelvicoper;

    private boolean mostrarAlergicoper;

    private boolean mostrarTabaquismoper;

    private boolean mostrarAntitetanicaper;

    private Integer tipoHistoria;


    public AntecedentePrenatalBean() {
    }

    public void init() {

        lstOpciones = new ArrayList();

        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

        try {
            antecedente = 
                    this.serviceLocator.getClinicoService().getAntecedentesPrenatales(datosUsuario.getConsulta());
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (antecedente == null) {
            antecedente = new Chantecprena();
        } else {

            if (antecedente.getHapchtacrofami() != null && 
                antecedente.getHapchtacrofami().equals("S")) {
                mostrarHTAfam = true;
            } else {
                mostrarHTAfam = false;
            }
            if (antecedente.getHapchtacropers() != null && 
                antecedente.getHapchtacropers().equals("S")) {
                mostrarHTAper = true;
            } else {
                mostrarHTAper = false;
            }
            if (antecedente.getHapcdiabetfami() != null && 
                antecedente.getHapcdiabetfami().equals("S")) {
                mostrarDiafam = true;
            } else {
                mostrarDiafam = false;
            }
            if (antecedente.getHapcdiabeperso() != null && 
                antecedente.getHapcdiabeperso().equals("S")) {
                mostrarDiaper = true;
            } else {
                mostrarDiaper = false;
            }
            if (antecedente.getHapcpreeclfami() != null && 
                antecedente.getHapcpreeclfami().equals("S")) {
                mostrarPreEclfam = true;
            } else {
                mostrarPreEclfam = false;
            }
            if (antecedente.getHapcpreeclpers() != null && 
                antecedente.getHapcpreeclpers().equals("S")) {
                mostrarPreEclper = true;
            } else {
                mostrarPreEclper = false;
            }
            if (antecedente.getHapceclampfami() != null && 
                antecedente.getHapceclampfami().equals("S")) {
                mostrarEclfam = true;
            } else {
                mostrarEclfam = false;
            }
            if (antecedente.getHapceclamppers() != null && 
                antecedente.getHapceclamppers().equals("S")) {
                mostrarEclper = true;
            } else {
                mostrarEclper = false;
            }

            if (antecedente.getHapcgemelafami() != null && 
                antecedente.getHapcgemelafami().equals("S")) {
                mostrarGemfam = true;
            } else {
                mostrarGemfam = false;
            }
            if (antecedente.getHapccardiofami() != null && 
                antecedente.getHapccardiofami().equals("S")) {
                mostrarCardiopatiafam = true;
            } else {
                mostrarCardiopatiafam = false;
            }
            if (antecedente.getHapctbcfamilia() != null && 
                antecedente.getHapctbcfamilia().equals("S")) {
                mostrarTBCfam = true;
            } else {
                mostrarTBCfam = false;
            }
            if (antecedente.getHapctuberperso() != null && 
                antecedente.getHapctuberperso().equals("S")) {
                mostrarTBCper = true;
            } else {
                mostrarTBCper = false;
            }
            if (antecedente.getHapccirpeutepe() != null && 
                antecedente.getHapccirpeutepe().equals("S")) {
                mostrarpelvicoper = true;
            } else {
                mostrarpelvicoper = false;
            }
            if (antecedente.getHapcalergipers() != null && 
                antecedente.getHapcalergipers().equals("S")) {
                mostrarAlergicoper = true;
            } else {
                mostrarAlergicoper = false;
            }
            if (antecedente.getHapctabaqupers() != null && 
                antecedente.getHapctabaqupers().equals("S")) {
                mostrarTabaquismoper = true;
            } else {
                mostrarTabaquismoper = false;
            }
            if (antecedente.getHapcantitepers() != null && 
                antecedente.getHapcantitepers().equals("S")) {
                mostrarAntitetanicaper = true;
            } else {
                mostrarAntitetanicaper = false;
            }


            if (antecedente.getHapcotrofamili() != null && 
                antecedente.getHapcotrofamili().equals("S")) {
                mostrarFamiliar = true;
            } else {
                mostrarFamiliar = false;
            }

            if (antecedente.getHapcotrosperso() != null && 
                antecedente.getHapcotrosperso().equals("S")) {
                mostrarPersonal = true;
            } else {
                mostrarPersonal = false;
            }

        }
    }

    public void setAntecedente(Chantecprena antecedente) {
        this.antecedente = antecedente;
    }

    public Chantecprena getAntecedente() {
        return antecedente;
    }


    public void setOtroFamiliar(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapcotrofamili((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setOtroPersonal(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapcotrosperso((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setMostrarFamiliar(boolean mostrarFamiliar) {
        this.mostrarFamiliar = mostrarFamiliar;
    }

    public boolean isMostrarFamiliar() {
        return mostrarFamiliar;
    }

    public void setMostrarPersonal(boolean mostrarPersonal) {
        this.mostrarPersonal = mostrarPersonal;
    }

    public boolean isMostrarPersonal() {
        return mostrarPersonal;
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


    public void ChangeOtroFamiliar() {
        if (antecedente.getHapcotrofamili() != null && 
            antecedente.getHapcotrofamili().equals("S")) {
            mostrarFamiliar = true;
        } else {
            antecedente.setHapccualotrfam(null);
            mostrarFamiliar = false;
        }
    }

    public void ChangeOtroPersonal() {
        if (antecedente.getHapcotrosperso() != null && 
            antecedente.getHapcotrosperso().equals("S")) {
            mostrarPersonal = true;
        } else {
            antecedente.setHapccualotrper(null);
            mostrarPersonal = false;
        }
    }

    public boolean esValido() {
        boolean esValido = false;
        Chantecprena antecedenteAux = null;
        if (datosUsuario != null && datosUsuario.getConsulta() != null) {
            try {
                antecedenteAux = 
                        this.serviceLocator.getClinicoService().getAntecedentesPrenatales(datosUsuario.getConsulta());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (antecedenteAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }


    public void setMostrarHTAper(boolean mostrarHTAper) {
        this.mostrarHTAper = mostrarHTAper;
    }

    public boolean isMostrarHTAper() {
        return mostrarHTAper;
    }

    public void setMostrarHTAfam(boolean mostrarHTAfam) {
        this.mostrarHTAfam = mostrarHTAfam;
    }

    public boolean isMostrarHTAfam() {
        return mostrarHTAfam;
    }

    public void setMostrarDiaper(boolean mostrarDiaper) {
        this.mostrarDiaper = mostrarDiaper;
    }

    public boolean isMostrarDiaper() {
        return mostrarDiaper;
    }

    public void setMostrarDiafam(boolean mostrarDiafam) {
        this.mostrarDiafam = mostrarDiafam;
    }

    public boolean isMostrarDiafam() {
        return mostrarDiafam;
    }

    public void setMostrarPreEclper(boolean mostrarPreEclper) {
        this.mostrarPreEclper = mostrarPreEclper;
    }

    public boolean isMostrarPreEclper() {
        return mostrarPreEclper;
    }

    public void setMostrarPreEclfam(boolean mostrarPreEclfam) {
        this.mostrarPreEclfam = mostrarPreEclfam;
    }

    public boolean isMostrarPreEclfam() {
        return mostrarPreEclfam;
    }

    public void setMostrarEclper(boolean mostrarEclper) {
        this.mostrarEclper = mostrarEclper;
    }

    public boolean isMostrarEclper() {
        return mostrarEclper;
    }

    public void setMostrarEclfam(boolean mostrarEclfam) {
        this.mostrarEclfam = mostrarEclfam;
    }

    public boolean isMostrarEclfam() {
        return mostrarEclfam;
    }

    public void setMostrarGemfam(boolean mostrarGemfam) {
        this.mostrarGemfam = mostrarGemfam;
    }

    public boolean isMostrarGemfam() {
        return mostrarGemfam;
    }

    public void setMostrarCardiopatiafam(boolean mostrarCardiopatiafam) {
        this.mostrarCardiopatiafam = mostrarCardiopatiafam;
    }

    public boolean isMostrarCardiopatiafam() {
        return mostrarCardiopatiafam;
    }

    public void setMostrarTBCfam(boolean mostrarTBCfam) {
        this.mostrarTBCfam = mostrarTBCfam;
    }

    public boolean isMostrarTBCfam() {
        return mostrarTBCfam;
    }

    public void setMostrarTBCper(boolean mostrarTBCper) {
        this.mostrarTBCper = mostrarTBCper;
    }

    public boolean isMostrarTBCper() {
        return mostrarTBCper;
    }

    public void setMostrarpelvicoper(boolean mostrarpelvicoper) {
        this.mostrarpelvicoper = mostrarpelvicoper;
    }

    public boolean isMostrarpelvicoper() {
        return mostrarpelvicoper;
    }

    public void setMostrarAlergicoper(boolean mostrarAlergicoper) {
        this.mostrarAlergicoper = mostrarAlergicoper;
    }

    public boolean isMostrarAlergicoper() {
        return mostrarAlergicoper;
    }

    public void setMostrarTabaquismoper(boolean mostrarTabaquismoper) {
        this.mostrarTabaquismoper = mostrarTabaquismoper;
    }

    public boolean isMostrarTabaquismoper() {
        return mostrarTabaquismoper;
    }

    public void setMostrarAntitetanicaper(boolean mostrarAntitetanicaper) {
        this.mostrarAntitetanicaper = mostrarAntitetanicaper;
    }

    public boolean isMostrarAntitetanicaper() {
        return mostrarAntitetanicaper;
    }

    public void setHapchtacrofami(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapchtacrofami((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeHtaFami() {

        if (antecedente.getHapchtacrofami() != null && 
            antecedente.getHapchtacrofami().equals("S")) {
            mostrarHTAfam = true;

        } else {
            antecedente.setHapcdeshtacrof(null);
            mostrarHTAfam = false;
        }
    }

    public void setHapchtacropers(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapchtacropers((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void ChangeHtaPers() {
        if (antecedente.getHapchtacropers() != null && 
            antecedente.getHapchtacropers().equals("S")) {
            mostrarHTAper = true;
        } else {
            antecedente.setHapcdeshtacrop(null);
            mostrarHTAper = false;
        }
    }


    public void setHapcdiabetfami(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapcdiabetfami((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void ChangeDiabetesFamiliar() {
        if (antecedente.getHapcdiabetfami() != null && 
            antecedente.getHapcdiabetfami().equals("S")) {
            mostrarDiafam = true;
        } else {
            antecedente.setHapcdesdiabetf(null);
            mostrarDiafam = false;
        }
    }

    public void setHapcdiabeperso(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapcdiabeperso((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeDiabetesPersonal() {
        if (antecedente.getHapcdiabeperso() != null && 
            antecedente.getHapcdiabeperso().equals("S")) {
            mostrarDiaper = true;
        } else {
            antecedente.setHapcdesdiabepe(null);
            mostrarDiaper = false;
        }
    }

    public void setHapcpreeclfami(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapcpreeclfami((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangePreeclfami() {
        if (antecedente.getHapcpreeclfami() != null && 
            antecedente.getHapcpreeclfami().equals("S")) {
            mostrarPreEclfam = true;
        } else {
            antecedente.setHapcdespreeclf(null);
            mostrarPreEclfam = false;
        }
    }


    public void setHapcpreeclpers(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapcpreeclpers((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangePreeclpers() {
        if (antecedente.getHapcpreeclpers() != null && 
            antecedente.getHapcpreeclpers().equals("S")) {
            mostrarPreEclper = true;
        } else {
            antecedente.setHapcdespreeclp(null);
            mostrarPreEclper = false;
        }
    }


    public void setHapceclampfami(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapceclampfami((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeEclampsiafami() {
        if (antecedente.getHapceclampfami() != null && 
            antecedente.getHapceclampfami().equals("S")) {
            mostrarEclfam = true;
        } else {
            antecedente.setHapcdeseclampf(null);
            mostrarEclfam = false;
        }
    }

    public void setHapceclamppers(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapceclamppers((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeEclampsiapers() {
        if (antecedente.getHapceclamppers() != null && 
            antecedente.getHapceclamppers().equals("S")) {
            mostrarEclper = true;
        } else {
            antecedente.setHapcdeseclampp(null);
            mostrarEclper = false;
        }
    }


    public void setHapcgemelafami(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapcgemelafami((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeGemelaresfami() {
        if (antecedente.getHapcgemelafami() != null && 
            antecedente.getHapcgemelafami().equals("S")) {
            mostrarGemfam = true;
        } else {
            antecedente.setHapcdesgemelaf(null);
            mostrarGemfam = false;
        }
    }


    public void setHapccardiofami(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapccardiofami((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeCardiopatiafami() {
        if (antecedente.getHapccardiofami() != null && 
            antecedente.getHapccardiofami().equals("S")) {
            mostrarCardiopatiafam = true;
        } else {
            antecedente.setHapcdescardiof(null);
            mostrarCardiopatiafam = false;
        }
    }


    public void setHapctbcfamilia(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapctbcfamilia((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void ChangeTBCfami() {
        if (antecedente.getHapctbcfamilia() != null && 
            antecedente.getHapctbcfamilia().equals("S")) {
            mostrarTBCfam = true;
        } else {
            antecedente.setHapcdestbcfami(null);
            mostrarTBCfam = false;
        }
    }

    public void setHapctuberperso(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapctuberperso((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeTBCperso() {
        if (antecedente.getHapctuberperso() != null && 
            antecedente.getHapctuberperso().equals("S")) {
            mostrarTBCper = true;
        } else {
            antecedente.setHapcdestuberpe(null);
            mostrarTBCper = false;
        }
    }


    public void setHapccirpeutepe(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapccirpeutepe((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeCirugiaperso() {
        if (antecedente.getHapccirpeutepe() != null && 
            antecedente.getHapccirpeutepe().equals("S")) {
            mostrarpelvicoper = true;
        } else {
            antecedente.setHapcdescirugpe(null);
            mostrarpelvicoper = false;
        }
    }


    public void setHapcalergipers(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapcalergipers((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void ChangeAlergicospers() {
        if (antecedente.getHapcalergipers() != null && 
            antecedente.getHapcalergipers().equals("S")) {
            mostrarAlergicoper = true;
        } else {
            antecedente.setHapcdesalergip(null);
            mostrarAlergicoper = false;
        }
    }

    public void setHapctabaqupers(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapctabaqupers((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeTabaquismoperso() {
        if (antecedente.getHapctabaqupers() != null && 
            antecedente.getHapctabaqupers().equals("S")) {
            mostrarTabaquismoper = true;
        } else {
            antecedente.setHapcdestabaqup(null);
            mostrarTabaquismoper = false;
        }
    }


    public void setHapcantitepers(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapcantitepers((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeAntitetanicapers() {
        if (antecedente.getHapcantitepers() != null && 
            antecedente.getHapcantitepers().equals("S")) {
            mostrarAntitetanicaper = true;
        } else {
            antecedente.setHapcdesantitep(null);
            mostrarAntitetanicaper = false;
        }
    }

    public void aceptar() {
        ChantecprenaPK id = new ChantecprenaPK();


        if (datosUsuario != null && datosUsuario.getConsulta() != null && 
            datosUsuario.getConsulta().getCconnumero() != null) {
            id.setHaplconsulta(new Long(datosUsuario.getConsulta().getCconnumero()));
            id.setHapctiposervi(TIPO_CONSULTA);
        }
        if (antecedente.getHapcotrofamili() != null && 
            antecedente.getHapcotrofamili().equals("N")) {
            antecedente.setHapccualotrfam(null);
        }


        if (antecedente.getHapcotrosperso() != null && 
            antecedente.getHapcotrosperso().equals("N")) {
            antecedente.setHapccualotrper(null);
        }

        if (antecedente.getHapchtacrofami() != null && 
            antecedente.getHapchtacrofami().equals("N")) {
            antecedente.setHapcdeshtacrof(null);

        }

        if (antecedente.getHapchtacropers() != null && 
            antecedente.getHapchtacropers().equals("N")) {
            antecedente.setHapcdeshtacrop(null);
        }

        if (antecedente.getHapcdiabetfami() != null && 
            antecedente.getHapcdiabetfami().equals("N")) {
            antecedente.setHapcdesdiabetf(null);
        }

        if (antecedente.getHapcdiabeperso() != null && 
            antecedente.getHapcdiabeperso().equals("N")) {
            antecedente.setHapcdesdiabepe(null);
        }

        if (antecedente.getHapcpreeclfami() != null && 
            antecedente.getHapcpreeclfami().equals("N")) {
            antecedente.setHapcdespreeclf(null);
        }

        if (antecedente.getHapcpreeclpers() != null && 
            antecedente.getHapcpreeclpers().equals("N")) {
            antecedente.setHapcdespreeclp(null);
        }

        if (antecedente.getHapceclampfami() != null && 
            antecedente.getHapceclampfami().equals("N")) {
            antecedente.setHapcdeseclampf(null);
        }

        if (antecedente.getHapceclamppers() != null && 
            antecedente.getHapceclamppers().equals("N")) {
            antecedente.setHapcdeseclampp(null);
        }

        if (antecedente.getHapcgemelafami() != null && 
            antecedente.getHapcgemelafami().equals("N")) {
            antecedente.setHapcdesgemelaf(null);
        }
        if (antecedente.getHapccardiofami() != null && 
            antecedente.getHapccardiofami().equals("N")) {
            antecedente.setHapcdescardiof(null);
        }

        if (antecedente.getHapctbcfamilia() != null && 
            antecedente.getHapctbcfamilia().equals("N")) {
            antecedente.setHapcdestbcfami(null);
        }
        if (antecedente.getHapctuberperso() != null && 
            antecedente.getHapctuberperso().equals("N")) {
            antecedente.setHapcdestuberpe(null);
        }

        if (antecedente.getHapccirpeutepe() != null && 
            antecedente.getHapccirpeutepe().equals("N")) {
            antecedente.setHapcdescirugpe(null);
        }
        if (antecedente.getHapcalergipers() != null && 
            antecedente.getHapcalergipers().equals("N")) {
            antecedente.setHapcdesalergip(null);
        }

        if (antecedente.getHapctabaqupers() != null && 
            antecedente.getHapctabaqupers().equals("N")) {
            antecedente.setHapcdestabaqup(null);
        }
        if (antecedente.getHapcantitepers() != null && 
            antecedente.getHapcantitepers().equals("N")) {
            antecedente.setHapcdesantitep(null);
        }

        antecedente.setHapdfecregistr(new Date());
        antecedente.setHapcoperador(userName());

        try {
            serviceLocator.getClinicoService().saveAntecedentesPrenatal(antecedente);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
        } catch (ModelException e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
        }
    }


    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    public Integer getTipoHistoria() {
        return tipoHistoria;
    }
}
