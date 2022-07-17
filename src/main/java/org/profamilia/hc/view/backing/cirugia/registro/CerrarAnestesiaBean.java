package org.profamilia.hc.view.backing.cirugia.registro;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;

import org.profamilia.hc.model.dto.Chanestesia;
import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.busqueda.ListaCirugiasMedicoBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.model.dto.Chcierreanest;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorPlantillaCirugiaBean;
import org.profamilia.hc.view.constantes.IConstantes;

public class CerrarAnestesiaBean  extends BaseBean {


    private Chcierreanest cierreanestesia;

    private Chanestesia anestesia;

    private Chcirugprogr cirugia;
    
    private Long numeroCirugia;

    private String tipoServicio;
    
    private boolean renderComplicaciones;
    
    private List lstOpciones;
    
    private String servicioDetalle;
    
    private Cpservicio servicio;
    
    static final int ACTIVAR_BUSCADOR_PLANTILLAS = 1;
    
    static final int ACTIVAR_APLICACION = 0;
    
    private boolean renderPlantilla;
    
    private UIInput itDescripcion;
    
    private int selectedIndex;

    public CerrarAnestesiaBean() {
    }
    
    
    
    public void init(){
        renderComplicaciones = false;
        cierreanestesia = new Chcierreanest();
    }
    
    public void cargarDatos(){
        
    }

    /**
     * @param anestesia
     */
    public void setAnestesia(Chanestesia anestesia) {
        this.anestesia = anestesia;
    }

    /**
     * @return
     */
    public Chanestesia getAnestesia() {
        return anestesia;
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
     * @return
     */
    public String cerrarAnestesia(){
    String nextAction = ""; 
        if(numeroCirugia != null){
            ListaCirugiasMedicoBean listaMedico = 
                (ListaCirugiasMedicoBean)FacesUtils.getManagedBean("listaCirugiasMedicoBean");
            Chcirugprogr cirugiaa = null;
            Chdetacirpro detaciru = null;
            boolean wexito = true;
            try {
            cirugiaa =
            serviceLocator.getCirugiaService().getCirugiaPorId(numeroCirugia);
            
            if(cirugiaa != null){
                detaciru = 
                serviceLocator.getCirugiaService().getServicioDetalle(cirugiaa.getHcplnumero());
            }
                servicioDetalle = detaciru.getId().getHdccservicio();
                try {
                    servicio = 
                            this.serviceLocator.getClinicoService().getServicioPorId(servicioDetalle);
                } catch (ModelException e) {
                    e.printStackTrace();
                }


                
            
            
       
            if(wexito){
                cierreanestesia.setHcilnumero(numeroCirugia);
                cierreanestesia.setHcidfecregistr(new Date());
                cierreanestesia.setHcicoperador(userName());
                serviceLocator.getCirugiaService().closeAnestesia(numeroCirugia,getClinica().getCclncodigo(), cierreanestesia);
                FacesUtils.addInfoMessage(MSG_ADICION);
                nextAction = BeanNavegacion.RUTA_IR_LISTA_CIRUGIAS_MEDICOS; 
                
                if (listaMedico != null) {
                    listaMedico.setEsRegistroAnestesia(true);
                    listaMedico.setEsEvolucion(false);
                    listaMedico.setEsIngresoMedico(false);
                    listaMedico.cargarCirugias();
                }
            }
                
                
            } catch (ModelException e) {
                nextAction = ""; 
                FacesUtils.addErrorMessage("Error :: "  + e.getMessage());
                e.printStackTrace();
            }    
        }
        return nextAction; 
    }

    public void mostrarBuscadorPlantilla() {
        FacesUtils.resetManagedBean("buscadorPlantillaCirugiaBean");
        BuscadorPlantillaCirugiaBean buscador = (BuscadorPlantillaCirugiaBean)FacesUtils.getManagedBean("buscadorPlantillaCirugiaBean");
        if(buscador != null){
            buscador.setNombreBeanAnterior("cerrarAnestesiaBean");
            buscador.setTagRenderizar("panelGridCerrarAnestesiaTab");
        }
        selectedIndex = ACTIVAR_BUSCADOR_PLANTILLAS;
        renderPlantilla = true; 
    }
    
    public void aceptarPlantilla() {
        BuscadorPlantillaCirugiaBean buscador = 
            (BuscadorPlantillaCirugiaBean)FacesUtils.getManagedBean("buscadorPlantillaCirugiaBean");
        if (buscador != null && buscador.getPlantillaSelect() != null) {
            itDescripcion.setValue(buscador.getPlantillaSelect().getHplcdescripcio());
            cierreanestesia.setHcicestadsalir(buscador.getPlantillaSelect().getHplcdescripcio());

        }
        renderPlantilla = false; 
        selectedIndex = ACTIVAR_APLICACION;
        FacesUtils.resetManagedBean("buscadorPlantillaCirugiaBean");
    }
    public void setRenderComplicaciones(boolean renderComplicaciones) {
        this.renderComplicaciones = renderComplicaciones;
    }

    public boolean isRenderComplicaciones() {
        return renderComplicaciones;
    }

    public void setCierreanestesia(Chcierreanest cierreanestesia) {
        this.cierreanestesia = cierreanestesia;
    }

    public Chcierreanest getCierreanestesia() {
        return cierreanestesia;
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
     * @param valueChangeEvent
     */
    public void setHciccomplicaci(ValueChangeEvent valueChangeEvent) {
        cierreanestesia.setHciccomplicaci((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    
    public void ChangeComplicacion(){
        if(cierreanestesia.getHciccomplicaci().equals("S")){
            renderComplicaciones = true;
        }else{
            renderComplicaciones = false;
        }
    }

    public void setRenderPlantilla(boolean renderPlantilla) {
        this.renderPlantilla = renderPlantilla;
    }

    public boolean isRenderPlantilla() {
        return renderPlantilla;
    }

    public void setItDescripcion(UIInput itDescripcion) {
        this.itDescripcion = itDescripcion;
    }

    public UIInput getItDescripcion() {
        return itDescripcion;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }
}
