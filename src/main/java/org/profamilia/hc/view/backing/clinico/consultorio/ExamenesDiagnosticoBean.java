package org.profamilia.hc.view.backing.clinico.consultorio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chexamediagn;
import org.profamilia.hc.model.dto.ChexamediagnPK;
import org.profamilia.hc.model.dto.Chmetodoplan;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class ExamenesDiagnosticoBean extends BaseBean {

    /** Variable que almacena el examen de apoyo diagnostico*/
    private Chexamediagn diagnostico;

    /** Almacena la lista de los metodos  de planificacion  */
    private List lstMetodo;

    /** Almacenla la lista de opciones 'SI' o 'NO' si requiere examen de apoyo diagnostico */
    private List lstOpciones;


    /** Almacena el Bean de Datos de Usuario*/
    DatosBasicosUsuarioBean datosUsuario;

    private Integer tipoHistoria;


    public ExamenesDiagnosticoBean() {
    }

    public void init() {

        lstOpciones = new ArrayList();
        lstMetodo = new ArrayList();
        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");


        try {
            diagnostico = 
                    this.getServiceLocator().getClinicoService().getExamenApoyoDiagnostico(datosUsuario.getConsulta());
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (diagnostico == null) {
            diagnostico = new Chexamediagn();
        }
    }

    public void setDiagnostico(Chexamediagn diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Chexamediagn getDiagnostico() {
        return diagnostico;
    }


    public void setLstMetodo(List lstMetodo) {
        this.lstMetodo = lstMetodo;
    }

    public List getLstMetodo() {
        if (lstMetodo.size() == 0) {
            ArrayList<Chmetodoplan> lstMetodoAux = null;
            try {
                lstMetodoAux = 
                        (ArrayList<Chmetodoplan>)this.serviceLocator.getClinicoService().getMetodosPlanificacion(SEXO_FEMENINO);
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


    /**
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        Chexamediagn diagnosticoAux = null;
        if (datosUsuario != null && datosUsuario.getConsulta() != null) {
            try {
                diagnosticoAux = 
                        this.getServiceLocator().getClinicoService().getExamenApoyoDiagnostico(datosUsuario.getConsulta());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (diagnosticoAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }


    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    public Integer getTipoHistoria() {
        return tipoHistoria;
    }

    public String aceptar() {
        ChexamediagnPK id = new ChexamediagnPK();
        if (datosUsuario != null && datosUsuario.getConsulta() != null && 
            datosUsuario.getConsulta().getCconnumero() != null) {
            id.setHedlconsulta(new Long(datosUsuario.getConsulta().getCconnumero()));
            id.setHedctiposervi(TIPO_CONSULTA);
            diagnostico.setId(id);
        }
        if (diagnostico != null) {

            diagnostico.setHedcoperador(userName());

        }


        try {
            this.getServiceLocator().getClinicoService().saveExamenApoyoDiagnostico(diagnostico);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            e.printStackTrace();
        }

        return BeanNavegacion.RUTA_IR_CONDUCTA;
    }

}
