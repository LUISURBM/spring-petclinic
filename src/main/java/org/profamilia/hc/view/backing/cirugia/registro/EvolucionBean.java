package org.profamilia.hc.view.backing.cirugia.registro;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.apache.myfaces.component.html.ext.HtmlDataTable;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chevolucion;
import org.profamilia.hc.model.dto.ChevolucionPK;
import org.profamilia.hc.model.dto.Chtipodiagno;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorPlantillaCirugiaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class EvolucionBean extends BaseBean {

    private Chevolucion evolucion;

    private Chcirugprogr cirugia;

    private boolean esFebril;

    private boolean esPediatria;

    private List lstTemperatura;

    private List lstTipoImpresion;

    private String diagnosticoPrincipal;

    private String diagnosticoRelacionado1;

    private String diagnosticoRelacionado2;

    private String diagnosticoRelacionado3;

    private boolean mostrarCie10;

    static final int ACTIVAR_IMPRESION_DIAGNOSTICA = 0;

    static final int ACTIVAR_BUSCADOR = 1;

    private int selectedIndex;

    private boolean esValido;

    private String menuBean;

    private String tipoServicio;

    private List lstCirugias;

    private HtmlDataTable dtCirugias;
    
    private boolean renderPlantilla;
    
    private UIInput itEvolucion;
    
    /** Render Dolor Cirugia*/
    private boolean renderDolor;
    
    private List lstOpciones;
    
    /** Lista que almacena la lista escala de dolor */
    private List<SelectItem> listEscala;


    public EvolucionBean() {
    }

    public void init() {

        inicializarEvolucion();
    }


    public void inicializarEvolucion() {
        lstTemperatura = new ArrayList<SelectItem>();
        lstTipoImpresion = new ArrayList();
        lstCirugias = new ArrayList(); 
        esValido = false;
        dtCirugias = new HtmlDataTable(); 
        
        
        if(cirugia!= null && cirugia.getChdetacirpros()!= null && !cirugia.getChdetacirpros().isEmpty()){
            Chdetacirpro detalle = null; 
            Iterator it = cirugia.getChdetacirpros().iterator(); 
            while(it.hasNext()){
                detalle = (Chdetacirpro)it.next(); 
                
                if(detalle!= null && detalle.getId()!= null && detalle.getId().getHdccservicio() != null){
                    Cpservicio servicio;
                    servicio = null; 
                    try {
                        servicio = this.serviceLocator.getClinicoService().getServicioPorId(detalle.getId().getHdccservicio());
                    } catch (ModelException e) {
                       e.printStackTrace();
                    }
                    lstCirugias.add(servicio); 
                }
            }
        }
        
        
        
        
        
        if (evolucion == null) {
            evolucion = new Chevolucion();
            evolucion.setHevcrefiedolor("N");
        }
        

    }

    /**
     * @param evolucion
     */
    public void setEvolucion(Chevolucion evolucion) {
        this.evolucion = evolucion;
    }

    /**
     * @return
     */
    public Chevolucion getEvolucion() {
        return evolucion;
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
     * @param esFebril
     */
    public void setEsFebril(boolean esFebril) {
        this.esFebril = esFebril;
    }

    /**
     * @return
     */
    public boolean isEsFebril() {
        return esFebril;
    }

    /**
     * @param esPediatria
     */
    public void setEsPediatria(boolean esPediatria) {
        this.esPediatria = esPediatria;
    }

    /**
     * @return
     */
    public boolean isEsPediatria() {
        return esPediatria;
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
     * @return
     */
    public boolean esValido() {
        return esValido;
    }

    /**
     * @param esValido
     */
    public void setEsValido(boolean esValido) {
        this.esValido = esValido;
    }

    /**
     * @return
     */
    public boolean isEsValido() {
        return esValido;
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
     * @param lstCirugias
     */
    public void setLstCirugias(List lstCirugias) {
        this.lstCirugias = lstCirugias;
    }

    /**
     * @return
     */
    public List getLstCirugias() {
        return lstCirugias;
    }

    /**
     * @param dtCirugias
     */
    public void setDtCirugias(HtmlDataTable dtCirugias) {
        this.dtCirugias = dtCirugias;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCirugias() {
        return dtCirugias;
    }

    /**
     * @param lstTemperatura
     */
    public void setLstTemperatura(List lstTemperatura) {
        this.lstTemperatura = lstTemperatura;
    }

    /**
     * @return
     */
    public List getLstTemperatura() {
        if (lstTemperatura.size() == 0) {
            lstTemperatura.add(new SelectItem("", "Seleccione una opci�n"));
            lstTemperatura.add(new SelectItem("A", "Afebril"));
            lstTemperatura.add(new SelectItem("F", "Febril"));
        }
        return lstTemperatura;
    }
    
    
    public void listenDolorCirugia(ValueChangeEvent valueChangeEvent) {
        String value = 
            (String)(((UIInput)valueChangeEvent.getComponent()).getValue());
        if (value.equals("S")) {
            renderDolor = true;
        } else if (value.equals("N")) {
            renderDolor = false;
        }
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
     * @param lstTipoImpresion
     */
    public void setLstTipoImpresion(List lstTipoImpresion) {
        this.lstTipoImpresion = lstTipoImpresion;
    }

    /**
     * @return
     */
    public List getLstTipoImpresion() {
        if (lstTipoImpresion.size() == 0) {
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


    // ACCIONES ValueChangeEvent
    
     public void mostrarBuscadorPlantilla(){
         FacesUtils.resetManagedBean("buscadorPlantillaCirugiaBean");
         BuscadorPlantillaCirugiaBean buscador = 
             (BuscadorPlantillaCirugiaBean)FacesUtils.getManagedBean("buscadorPlantillaCirugiaBean");
         if (buscador != null) {
             buscador.setNombreBeanAnterior("evolucionBean");
             buscador.setTagRenderizar("panelGridEvolucionTab");
             buscador.setDescripcion(true);
             buscador.setHallazgos(false);
         }
         renderPlantilla = true;
         selectedIndex = 1;
         }


    // BOTON PRINCIPAL, BOTON PARA MODIFICAR   

    public void aceptar() {

        ChevolucionPK id = new ChevolucionPK();

        if (cirugia != null) {
        
         if(evolucion.getId() == null || evolucion.getId().getHevlnumero() == null){
             id.setHevctiposervi(IConstantes.TIPO_HOSPITALIZACION);
             id.setHevlnumero(cirugia.getHcplnumero());
             evolucion.setId(id);
             evolucion.setHevcestado(ESTADO_REGISTRO);
         }
           
            evolucion.setHevcoperador(userName());
            evolucion.setHevdfecevoluci(new Date());
            evolucion.setHevdfecregistr(new Date());
            evolucion.setHevlusuario(cirugia.getHcplusuario().getHuslnumero());

            try {
                this.serviceLocator.getClinicoService().saveEvolucion(evolucion);
                esValido = true;
                FacesUtils.resetManagedBean(menuBean);
                FacesUtils.addInfoMessage(MSG_ADICION);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage("ERROR:::: " + e.getMessage());
                e.printStackTrace();

            }catch (Exception ex) {
                FacesUtils.addErrorMessage("ERROR:::: " + ex.getMessage());
                ex.printStackTrace();

            }
        }
    }


    public void setRenderPlantilla(boolean renderPlantilla) {
        this.renderPlantilla = renderPlantilla;
    }

    public boolean isRenderPlantilla() {
        return renderPlantilla;
    }

    public void setItEvolucion(UIInput itEvolucion) {
        this.itEvolucion = itEvolucion;
    }

    public UIInput getItEvolucion() {
        return itEvolucion;
    }

    public void setRenderDolor(boolean renderDolor) {
        this.renderDolor = renderDolor;
    }

    public boolean isRenderDolor() {
        return renderDolor;
    }

    public void setListEscala(List<SelectItem> listEscala) {
        this.listEscala = listEscala;
    }

    public List<SelectItem> getListEscala() {

        if (listEscala == null || listEscala.isEmpty()) {
            listEscala = new ArrayList<SelectItem>();

            listEscala.add(new SelectItem(0, "0"));
            listEscala.add(new SelectItem(1, "1"));
            listEscala.add(new SelectItem(2, "2"));
            listEscala.add(new SelectItem(3, "3"));
            listEscala.add(new SelectItem(4, "4"));
            listEscala.add(new SelectItem(5, "5"));
            listEscala.add(new SelectItem(6, "6"));
            listEscala.add(new SelectItem(7, "7"));
            listEscala.add(new SelectItem(8, "8"));
            listEscala.add(new SelectItem(9, "9"));
            listEscala.add(new SelectItem(10, "10"));

        }

        return listEscala;
    }

}
