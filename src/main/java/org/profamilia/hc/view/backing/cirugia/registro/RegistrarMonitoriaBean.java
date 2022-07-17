//=======================================================================
// ARCHIVO RegistrarMonitoriaBean
// FECHA CREACI�N: 
// AUTOR: jariano, nlis
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.cirugia.registro;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chmonitoria;
import org.profamilia.hc.model.dto.ChmonitoriaPK;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//====================================================================


//=================================================================
//  CLASE RegistrarMonitoriaBean
//=======================================================================
public class RegistrarMonitoriaBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chmonitoria monitoria;

    private List lstOpciones;

    private List lstFonendoscopio;

    private List lstDerivacion;

    private List lstTipoPresionArterial;

    private List lstPresionArterialNoInvasiva;

    private List lstCapnografia;

    private List lstTipoCapnografia;

    private boolean mostrarfonendoscopio;

    private boolean mostrarotroelectro;

    private boolean mostrarinvasiva;

    private boolean mostrarnoinvasiva;

    private boolean mostrarrelajacion;

    private boolean mostartemperatura;

    private boolean mostrarotrosmonitores;
    
    private boolean renderOximetria;

    private List<String> lstPresionSelect;

    private boolean mostrartipocapnografia;

    private Long numeroCirugia;

    private String tipoServicio;
    
    private String navigationRule;
    
    private boolean renderOtrasCirugias; 
    
    private boolean ligadura;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public RegistrarMonitoriaBean() {
    }

    public void init() {
        monitoria = new Chmonitoria();
        lstOpciones = new ArrayList();
        lstFonendoscopio = new ArrayList();
        lstDerivacion = new ArrayList();
        lstPresionArterialNoInvasiva = new ArrayList();
        lstCapnografia = new ArrayList();
        lstTipoPresionArterial = new ArrayList();
        lstPresionSelect = new ArrayList<String>();
        lstTipoCapnografia = new ArrayList();
        renderOximetria = true;
        


    }

    public void cargarDatos() {
        renderOximetria = true;
        try {
            monitoria = 
                    this.serviceLocator.getClinicoService().getMonitoriaAnestesia(numeroCirugia);
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (monitoria == null) {
            monitoria = new Chmonitoria();
            monitoria.setHmocelectderiv("DII");
            monitoria.setHmocoximepulso("S");
        } else {
            if (monitoria.getHmocfonendosco() != null && 
                !monitoria.getHmocfonendosco().equals("")) {
                mostrarfonendoscopio = true;
            } else {
                mostrarfonendoscopio = false;
            }

            if (monitoria != null && monitoria.getHmocelectderiv() != null && 
                monitoria.getHmocelectderiv().equals("OTRA")) {
                mostrarotroelectro = true;
            } else {
                mostrarotroelectro = false;
            }
        }

        if (monitoria.getHmocpresiarter() != null) {
            if (monitoria.getHmocpresiarter().equals("I")) {
                mostrarinvasiva = true;
            } else {
                mostrarinvasiva = false;
            }

            if (monitoria.getHmocpresiarter().equals("N")) {
                mostrarnoinvasiva = true;
            } else {
                mostrarnoinvasiva = false;
            }
        }

        if (monitoria.getHmoccapnografi() != null && 
            monitoria.getHmoccapnografi().equals("S")) {
            mostrartipocapnografia = true;
        } else {
            mostrartipocapnografia = false;
        }

        if (monitoria.getHmocotromonito() != null && 
            monitoria.getHmocotromonito().equals("S")) {
            mostrarotrosmonitores = true;
        } else {
            mostrarotrosmonitores = false;
        }


        if (monitoria.getHmocmonittempe() != null && 
            monitoria.getHmocmonittempe().equals("S")) {
            mostartemperatura = true;
        } else {
            mostartemperatura = false;
        }

        if (monitoria.getHmocrelajmuscu() != null && 
            monitoria.getHmocrelajmuscu().equals("S")) {
            mostrarrelajacion = true;
        } else {
            mostrarrelajacion = false;
        }


        if (monitoria.getHmoctipopresio() != null && 
            !monitoria.getHmoctipopresio().equals("")) {
            StringTokenizer st = 
                new StringTokenizer(monitoria.getHmoctipopresio(), ",");

            while (st.hasMoreTokens()) {
                String idtipopresion = st.nextToken();


                if (idtipopresion != null) {
                    lstPresionSelect.add(idtipopresion);
                }

            }
        }

    }

    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------

    /**
     * @param monitoria
     */
    public void setMonitoria(Chmonitoria monitoria) {
        this.monitoria = monitoria;
    }

    /**
     * @return
     */
    public Chmonitoria getMonitoria() {
        return monitoria;
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
        if (lstOpciones.size() == 0) {
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
    }

    /**
     * @param lstFonendoscopio
     */
    public void setLstFonendoscopio(List lstFonendoscopio) {
        this.lstFonendoscopio = lstFonendoscopio;
    }

    /**
     * @return
     */
    public List getLstFonendoscopio() {
        if (lstFonendoscopio.size() == 0) {
            lstFonendoscopio.add(new SelectItem("P", "Precordial"));
            lstFonendoscopio.add(new SelectItem("E", "Esof�gico"));
        }
        return lstFonendoscopio;
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
     * @param numeroCirugia
     */
    public void setNumeroCirugia(Long numeroCirugia) {
        this.numeroCirugia = numeroCirugia;
    }

    /**
     * @return
     */
    public Long getNumeroCirugia() {
        return numeroCirugia;
    }

    /**
     * @param lstDerivacion
     */
    public void setLstDerivacion(List lstDerivacion) {
        this.lstDerivacion = lstDerivacion;
    }

    /**
     * @return
     */
    public List getLstDerivacion() {
        if (lstDerivacion.size() == 0) {
//            lstDerivacion.add(new SelectItem("", "Seleccione una opci�n"));
            lstDerivacion.add(new SelectItem("DI", "DI"));
            lstDerivacion.add(new SelectItem("DII", "DII"));
            lstDerivacion.add(new SelectItem("DIII", "DIII"));
            lstDerivacion.add(new SelectItem("OTRA", "Otra"));

        }
        return lstDerivacion;
    }

    /**
     * @param lstPresionArterial
     */
    public void setLstPresionArterialNoInvasiva(List lstPresionArterial) {
        this.lstPresionArterialNoInvasiva = lstPresionArterial;
    }

    /**
     * @return
     */
    public List getLstPresionArterialNoInvasiva() {
        if (lstPresionArterialNoInvasiva.size() == 0) {
            lstPresionArterialNoInvasiva.add(new SelectItem("MSD", 
                                                            "Miembro superior derecho"));
            lstPresionArterialNoInvasiva.add(new SelectItem("MSI", 
                                                            "Miembro superior izquierdo"));
            lstPresionArterialNoInvasiva.add(new SelectItem("MID", 
                                                            "Miembro inferior derecho"));
            lstPresionArterialNoInvasiva.add(new SelectItem("MII", 
                                                            "Miembro inferior izquierdo"));
        }
        return lstPresionArterialNoInvasiva;
    }

    /**
     * @param lstCapnografia
     */
    public void setLstCapnografia(List lstCapnografia) {
        this.lstCapnografia = lstCapnografia;
    }

    /**
     * @return
     */
    public List getLstCapnografia() {
        if (lstCapnografia.size() == 0) {
            lstCapnografia.add(new SelectItem("A", "Aspiraci�n"));
            lstCapnografia.add(new SelectItem("F", "Flujo"));
        }
        return lstCapnografia;
    }

    /**
     * @param mostrarfonendoscopio
     */
    public void setMostrarfonendoscopio(boolean mostrarfonendoscopio) {
        this.mostrarfonendoscopio = mostrarfonendoscopio;
    }

    /**
     * @return
     */
    public boolean isMostrarfonendoscopio() {
        return mostrarfonendoscopio;
    }

    /**
     * @param mostrarotroelectro
     */
    public void setMostrarotroelectro(boolean mostrarotroelectro) {
        this.mostrarotroelectro = mostrarotroelectro;
    }

    /**
     * @return
     */
    public boolean isMostrarotroelectro() {
        return mostrarotroelectro;
    }

    /**
     * @param lstTipoPresionArterial
     */
    public void setLstTipoPresionArterial(List lstTipoPresionArterial) {
        this.lstTipoPresionArterial = lstTipoPresionArterial;
    }

    /**
     * @return
     */
    public List getLstTipoPresionArterial() {
        if (lstTipoPresionArterial.size() == 0) {
            lstTipoPresionArterial.add(new SelectItem("N", "No invasiva"));
            lstTipoPresionArterial.add(new SelectItem("I", "Invasiva"));
        }
        return lstTipoPresionArterial;
    }

    /**
     * @param mostrarinvasiva
     */
    public void setMostrarinvasiva(boolean mostrarinvasiva) {
        this.mostrarinvasiva = mostrarinvasiva;
    }

    /**
     * @return
     */
    public boolean isMostrarinvasiva() {
        return mostrarinvasiva;
    }

    /**
     * @param mostrarnoinvasiva
     */
    public void setMostrarnoinvasiva(boolean mostrarnoinvasiva) {
        this.mostrarnoinvasiva = mostrarnoinvasiva;
    }

    /**
     * @return
     */
    public boolean isMostrarnoinvasiva() {
        return mostrarnoinvasiva;
    }

    /**
     * @param lstPresionSelect
     */
    public void setLstPresionSelect(List<String> lstPresionSelect) {
        this.lstPresionSelect = lstPresionSelect;
    }

    /**
     * @return
     */
    public List<String> getLstPresionSelect() {
        return lstPresionSelect;
    }

    /**
     * @param mostrartipocapnografia
     */
    public void setMostrartipocapnografia(boolean mostrartipocapnografia) {
        this.mostrartipocapnografia = mostrartipocapnografia;
    }

    /**
     * @return
     */
    public boolean isMostrartipocapnografia() {
        return mostrartipocapnografia;
    }

    /**
     * @param lstTipoCapnografia
     */
    public void setLstTipoCapnografia(List lstTipoCapnografia) {
        this.lstTipoCapnografia = lstTipoCapnografia;
    }

    /**
     * @return
     */
    public List getLstTipoCapnografia() {
        if (lstTipoCapnografia.size() == 0) {
            lstTipoCapnografia.add(new SelectItem("A", 
                                                  "Aspiraci�n. (side stream)"));
            lstTipoCapnografia.add(new SelectItem("F", "Flujo (mainstream)."));
        }
        return lstTipoCapnografia;
    }

    /**
     * @param mostrarrelajacion
     */
    public void setMostrarrelajacion(boolean mostrarrelajacion) {
        this.mostrarrelajacion = mostrarrelajacion;
    }

    /**
     * @return
     */
    public boolean isMostrarrelajacion() {
        return mostrarrelajacion;
    }

    /**
     * @param mostartemperatura
     */
    public void setMostartemperatura(boolean mostartemperatura) {
        this.mostartemperatura = mostartemperatura;
    }

    /**
     * @return
     */
    public boolean isMostartemperatura() {
        return mostartemperatura;
    }

    /**
     * @param mostrarotrosmonitores
     */
    public void setMostrarotrosmonitores(boolean mostrarotrosmonitores) {
        this.mostrarotrosmonitores = mostrarotrosmonitores;
    }

    /**
     * @return
     */
    public boolean isMostrarotrosmonitores() {
        return mostrarotrosmonitores;
    }
 

    //-----------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //-----------------------------------------------------------------------

    public void changeFonendoscopio() {
        if (monitoria != null && monitoria.getHmocfonendosco() != null && 
            !monitoria.getHmocfonendosco().equals("")) {
            mostrarfonendoscopio = true;
        } else {
            mostrarfonendoscopio = false;
            monitoria.setHmocsitiofonen(null);
        }
    }

    public void changeElectrocardiografia() {
        if (monitoria != null && monitoria.getHmocelectderiv() != null && 
            monitoria.getHmocelectderiv().equals("OTRA")) {
            mostrarotroelectro = true;
        } else {
            mostrarotroelectro = false;
            monitoria.setHmocotraderiva(null);
        }
    }

    public void changePresionArterial() {
        if (monitoria != null && monitoria.getHmocpresiarter() != null) {
            if (monitoria.getHmocpresiarter().equals("I")) {
                mostrarinvasiva = true;
            } else {
                monitoria.setHmoccanuaarter(null);
                mostrarinvasiva = false;
            }

            if (monitoria.getHmocpresiarter().equals("N")) {
                mostrarnoinvasiva = true;
            } else {
                lstPresionSelect = new ArrayList<String>();
                mostrarnoinvasiva = false;

            }
        }
    }

    public void changeCapnografia() {
        if (monitoria != null && monitoria.getHmoccapnografi() != null && 
            monitoria.getHmoccapnografi().equals("S")) {
            mostrartipocapnografia = true;
        } else {
            monitoria.setHmoctipocapnog(null);
            monitoria.setHmocobsercapno(null);
            mostrartipocapnografia = false;
        }
    }

    public void changeRelajacion() {
        if (monitoria != null && monitoria.getHmocrelajmuscu() != null && 
            monitoria.getHmocrelajmuscu().equals("S")) {
            mostrarrelajacion = true;
        } else {
            monitoria.setHmocobserrelaj(null);
            mostrarrelajacion = false;
        }
    }

    public void changeTemperatura() {
        if (monitoria != null && monitoria.getHmocmonittempe() != null && 
            monitoria.getHmocmonittempe().equals("S")) {
            mostartemperatura = true;
        } else {
            monitoria.setHmocsitiotempe(null);
            mostartemperatura = false;
        }
    }

    public void changeOtrosMonitores() {
        if (monitoria != null && monitoria.getHmocotromonito() != null && 
            monitoria.getHmocotromonito().equals("S")) {
            mostrarotrosmonitores = true;
        } else {
            monitoria.setHmoccualmonito(null);
            mostrarotrosmonitores = false;
        }
    }


    /**
     * @param valueChangeEvent
     */
    public void setHmocfonendosco(ValueChangeEvent valueChangeEvent) {
        monitoria.setHmocfonendosco((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHmocelectderiv(ValueChangeEvent valueChangeEvent) {
        monitoria.setHmocelectderiv((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHmocpresiarter(ValueChangeEvent valueChangeEvent) {
        monitoria.setHmocpresiarter((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHmoccapnografi(ValueChangeEvent valueChangeEvent) {
        monitoria.setHmoccapnografi((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHmocrelajmuscu(ValueChangeEvent valueChangeEvent) {
        monitoria.setHmocrelajmuscu((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHmocmonittempe(ValueChangeEvent valueChangeEvent) {
        monitoria.setHmocmonittempe((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHmocotromonito(ValueChangeEvent valueChangeEvent) {
        monitoria.setHmocotromonito((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    //-----------------------------------------------------------------------
    //  Boton Principal 
    //-----------------------------------------------------------------------  

    public String registrarMonitores() {
        navigationRule = "";
        ChmonitoriaPK idMonitoria = new ChmonitoriaPK();
        idMonitoria.setHmolnumero(numeroCirugia);
        idMonitoria.setHmoctiposervi(TIPO_HOSPITALIZACION);
        monitoria.setId(idMonitoria);
        monitoria.setHmocoperador(userName());
        monitoria.setHmodfecregistr(new Date());
        monitoria.setHmonclinica(this.getClinica().getCclncodigo());
        

        if (lstPresionSelect != null && !lstPresionSelect.isEmpty()) {
            String presion = "";
            String presionSelect = "";


            Iterator it = lstPresionSelect.iterator();
            while (it.hasNext()) {
                presion = (String)it.next();
                if (presion != null) {
                    presionSelect = presionSelect + presion + ",";
                }
            }

            presionSelect = 
                    presionSelect.substring(0, presionSelect.length() - 1);

            if (presionSelect != null) {
                monitoria.setHmoctipopresio(presionSelect);
            }
        }

        try {
            this.serviceLocator.getClinicoService().saveMonitorAnestesia(monitoria);
            FacesUtils.addInfoMessage(MSG_ADICION);
            
            navigationRule= BeanNavegacion.RUTA_IR_REGISTRAR_BALANCE_LIQUIDOS_ANESTESIA;
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ADICION);
            e.printStackTrace();
        }
        return navigationRule;
    }


    public void setRenderOtrasCirugias(boolean renderOtrasCirugias) {
        this.renderOtrasCirugias = renderOtrasCirugias;
    }

    public boolean isRenderOtrasCirugias() {
        return renderOtrasCirugias;
    }

    public void setLigadura(boolean ligadura) {
        this.ligadura = ligadura;
    }

    public boolean isLigadura() {
        return ligadura;
    }

    public void setRenderOximetria(boolean renderOximetria) {
        this.renderOximetria = renderOximetria;
    }

    public boolean isRenderOximetria() {
        return renderOximetria;
    }
}
