package org.profamilia.hc.view.backing.clinico.consultorio;


import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chrefepaci;
import org.profamilia.hc.model.dto.ChrefepaciPK;
import org.profamilia.hc.model.dto.Chregcomenf;
import org.profamilia.hc.model.dto.ChregcomenfPK;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class RegistrarNotaComplementariaEnfermeriaBean extends BaseBean {

    /** Almacena la descripcion de la nota Medica*/
    private String notaMedica;

    /** Alamcena la consulta a la cual se le esta haciendo la nota medica */
    private Chconsulta consulta;

    /** Almacena la nota medica a persistir*/
    private Chregcomenf nota;

    /** Almacena el bean de navegacion*/
    private String nextAction;

    private Chrefepaci referenciaPaciente;

    private boolean renderReferencia;

    /** Almacena la lista de las horas habiles para una consulta*/
    private List<SelectItem> listHora;

    /** Almacena la lista de los minutos habiles para una consulta*/
    private List<SelectItem> lstMinutos;

    private List<SelectItem> listTipoAmbulancia;

    private List lstOpciones;


    public RegistrarNotaComplementariaEnfermeriaBean() {
    }


    public void init() {
        nota = new Chregcomenf();
        referenciaPaciente = new Chrefepaci();
        renderReferencia = false;
        referenciaPaciente.setHrpcrefepaci("N");


    }

    /**
     * @param notaMedica
     */
    public void setNotaMedica(String notaMedica) {
        this.notaMedica = notaMedica;
    }

    /**
     * @return
     */
    public String getNotaMedica() {
        return notaMedica;
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
     * @return
     */
    public String aceptar() {

        ChregcomenfPK idNota = new ChregcomenfPK();
        idNota.sethrcelconsulta(consulta.getHcolnumero());
        nextAction = "";
        nota.sethrcecdescripc(notaMedica);
        nota.sethrcecoperador(userName());
        nota.sethrcedfecregistr(new Date());
        nota.setId(idNota);

        if (referenciaPaciente != null && consulta != null) {
            if ("N".equals(referenciaPaciente.getHrpcrefepaci())) {
                referenciaPaciente = new Chrefepaci();
                referenciaPaciente.setHrpcrefepaci("N");
            }
            ChrefepaciPK referenciaPK = new ChrefepaciPK();
            referenciaPK.setHrplconsulta(consulta.getHcolnumero());
            referenciaPaciente.setId(referenciaPK);
            referenciaPaciente.setHrpdfecreg(new Date());
            referenciaPaciente.setHrpcusureg(userName());
        }


        try {
            this.serviceLocator.getClinicoService().saveNotaComplementarioEnfermeria(nota, 
                                                                                     referenciaPaciente);
            nextAction = BeanNavegacion.RUTA_IR_INICIO;
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ADICION);
            nextAction = BeanNavegacion.RUTA_ACTUAL;
            e.printStackTrace();
        }

        FacesUtils.resetManagedBean("registrarNotaComplementariaEnfermeriaBean");
        FacesUtils.resetManagedBean("consultarFoliosNotaComplementariaEnfermeriaBean");
        FacesUtils.resetManagedBean("consultarUsuarioNotaComplementariaEnfermeriaBean");


        return nextAction;
    }


    public void setReferenciaPaciente(Chrefepaci referenciaPaciente) {
        this.referenciaPaciente = referenciaPaciente;
    }

    public Chrefepaci getReferenciaPaciente() {
        return referenciaPaciente;
    }

    public void setHrpcrefepaci(ValueChangeEvent valueChangeEvent) {
        referenciaPaciente.setHrpcrefepaci((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void changeReferenciaPaciente() {
        renderReferencia = false;
        if ("S".equals(referenciaPaciente.getHrpcrefepaci())) {
            renderReferencia = true;
        }
    }

    public void setRenderReferencia(boolean renderReferencia) {
        this.renderReferencia = renderReferencia;
    }

    public boolean isRenderReferencia() {
        return renderReferencia;
    }

    public void setListHora(List<SelectItem> listHora) {
        this.listHora = listHora;
    }

    public List<SelectItem> getListHora() {
        if (listHora == null) {
            listHora = new ArrayList<SelectItem>();
            listHora.add(new SelectItem("", "--"));
            listHora.add(new SelectItem("06", "06"));
            listHora.add(new SelectItem("07", "07"));
            listHora.add(new SelectItem("08", "08"));
            listHora.add(new SelectItem("09", "09"));
            listHora.add(new SelectItem("10", "10"));
            listHora.add(new SelectItem("11", "11"));
            listHora.add(new SelectItem("12", "12"));
            listHora.add(new SelectItem("13", "13"));
            listHora.add(new SelectItem("14", "14"));
            listHora.add(new SelectItem("15", "15"));
            listHora.add(new SelectItem("16", "16"));
            listHora.add(new SelectItem("17", "17"));
            listHora.add(new SelectItem("18", "18"));
            listHora.add(new SelectItem("19", "19"));
            listHora.add(new SelectItem("20", "20"));
            listHora.add(new SelectItem("21", "21"));
            listHora.add(new SelectItem("22", "22"));
            listHora.add(new SelectItem("23", "23"));

        }
        return listHora;
    }

    public void setLstMinutos(List<SelectItem> lstMinutos) {
        this.lstMinutos = lstMinutos;
    }

    public List<SelectItem> getLstMinutos() {
        if (lstMinutos == null) {
            lstMinutos = new ArrayList<SelectItem>();
            lstMinutos.add(new SelectItem("", "--"));
            lstMinutos.add(new SelectItem("00", "00"));
            lstMinutos.add(new SelectItem("05", "05"));
            lstMinutos.add(new SelectItem("10", "10"));
            lstMinutos.add(new SelectItem("15", "15"));
            lstMinutos.add(new SelectItem("20", "20"));
            lstMinutos.add(new SelectItem("25", "25"));
            lstMinutos.add(new SelectItem("30", "30"));
            lstMinutos.add(new SelectItem("35", "35"));
            lstMinutos.add(new SelectItem("40", "40"));
            lstMinutos.add(new SelectItem("45", "45"));
            lstMinutos.add(new SelectItem("50", "50"));
            lstMinutos.add(new SelectItem("55", "55|"));
        }
        return lstMinutos;
    }

    public void setListTipoAmbulancia(List<SelectItem> listTipoAmbulancia) {
        this.listTipoAmbulancia = listTipoAmbulancia;
    }

    public List<SelectItem> getListTipoAmbulancia() {
        if (listHora == null) {
            listHora = new ArrayList<SelectItem>();
            listHora.add(new SelectItem("", "Seleccione una opcion"));
            listHora.add(new SelectItem("BA", "B�sica"));
            listHora.add(new SelectItem("ME", "Medicalizada"));
        }
        return listTipoAmbulancia;
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
        if (lstOpciones == null) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
    }
}
