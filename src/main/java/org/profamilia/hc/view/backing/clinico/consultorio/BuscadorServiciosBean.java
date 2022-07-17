package org.profamilia.hc.view.backing.clinico.consultorio;

import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;

import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;

import org.profamilia.hc.view.util.FacesUtils;

import org.profamilia.hc.view.backing.comun.buscador.BuscadorServicioBean;

/**
 * 
 * @version v001 08/05/2014
 * @author <a href="mailto: andres.vargas@profamilia.org.co">Carlos Andres Vargas</a>
 */
public class BuscadorServiciosBean extends BaseBean {

    /** Objeto clinica */
    private Cpclinica infoClinica;
    private Cpusuario usuario;
    private boolean renderConsultas; 
    private List lstConsultasAbiertas; 
    private Date fecha; 
    private String msgCerrarConsulta; 
    private HtmlDataTable dtConsultasAbiertas; 
    private boolean renderBuscador;
    private int selectedIndex;
    /** Variable que almacena el Nombre y codigo del servicio */
    private String servicio;
    private static final int ACTIVAR_FORMULA_MEDICA = 0;

    private static final int ACTIVAR_BUSCADOR = 1;
    
    private UIInput itServicio;
    
    private boolean deshabilitarServicio;
    

    /** default constructor */
    public BuscadorServiciosBean() {
    }

    /**
     * Initializes UsuarioBean.
     * @see BaseBean#init()
     */
    protected void init() {
        infoClinica = new Cpclinica();
        cargarDatos();
    }

    public void cargarDatos() {
        try {
         if(this.getClinica()!= null && this.getClinica().getCclncodigo()!= null ){
             infoClinica = 
                     this.serviceLocator.getClinicoService().getClinica(this.getClinica().getCclncodigo());
         }
           
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_CONSULTA);
        }


        try {
            lstConsultasAbiertas = serviceLocator.getClinicoService().getConsultasSinCerrar(userName(),this.getClinica().getCclncodigo(),fecha); 
        } catch (Exception e) {
            e.printStackTrace();
        }
     
        msgCerrarConsulta = MSG_CONSULTAS_ABIERTAS; 
        usuario = this.getUsuarioSystem();

    }

    /**
     * @param infoClinica
     */
    public void setInfoClinica(Cpclinica infoClinica) {
        this.infoClinica = infoClinica;
    }

    /**
     * @return
     */
    public Cpclinica getInfoClinica() {
        return infoClinica;
    }

    /**
     * @param usuario
     */
    public void setUsuario(Cpusuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return
     */
    public Cpusuario getUsuario() {
        return usuario;
    }

    /**
     * @param renderConsultas
     */
    public void setRenderConsultas(boolean renderConsultas) {
        this.renderConsultas = renderConsultas;
    }

    /**
     * @return
     */
    public boolean isRenderConsultas() {
        return renderConsultas;
    }

    /**
     * @param lstConsultasAbiertas
     */
    public void setLstConsultasAbiertas(List lstConsultasAbiertas) {
        this.lstConsultasAbiertas = lstConsultasAbiertas;
    }

    /**
     * @return
     */
    public List getLstConsultasAbiertas() {
        return lstConsultasAbiertas;
    }

    /**
     * @param msgCerrarConsulta
     */
    public void setMsgCerrarConsulta(String msgCerrarConsulta) {
        this.msgCerrarConsulta = msgCerrarConsulta;
    }

    /**
     * @return
     */
    public String getMsgCerrarConsulta() {
        return msgCerrarConsulta;
    }


    /**
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param dtConsultasAbiertas
     */
    public void setDtConsultasAbiertas(HtmlDataTable dtConsultasAbiertas) {
        this.dtConsultasAbiertas = dtConsultasAbiertas;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtConsultasAbiertas() {
        return dtConsultasAbiertas;
    }
    
    //-----------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //-----------------------------------------------------------------------   

    public void renderServicios() {
        renderBuscador = true;
        selectedIndex = ACTIVAR_BUSCADOR;
    }

    /**
     * @param renderBuscador
     */
    public void setRenderBuscador(boolean renderBuscador) {
        this.renderBuscador = renderBuscador;
    }

    /**
     * @return
     */
    public boolean isRenderBuscador() {
        return renderBuscador;
    }
    
    
    /**
     * @param deshabilitarServicio
     */
    public void setDeshabilitarServicio(boolean deshabilitarServicio) {
        this.deshabilitarServicio = deshabilitarServicio;
    }

    /**
     * @return
     */
    public boolean isDeshabilitarServicio() {
        return deshabilitarServicio;
    }
    
    
   public void aceptarServicio() {
        BuscadorServicioBean servicioAux = 
            (BuscadorServicioBean)FacesUtils.getManagedBean("buscadorServicioBean");
            
            
        if (servicioAux != null && 
            servicioAux.getServicioSelect() != null) {
            itServicio.setValue(servicioAux.getServicioSelect().getCsvccodigo() + " " + servicioAux.getServicioSelect().getCsvcnombre() );
         
           servicio = 
                    servicioAux.getServicioSelect().getCsvccodigo();
            deshabilitarServicio = true;

        }
        selectedIndex = ACTIVAR_FORMULA_MEDICA;
        renderBuscador = false;
        FacesUtils.resetManagedBean("buscadorServicioBean");
    }
    
    
    /**
     * @param valueChangeEvent
     */
    public void setServicio(ValueChangeEvent valueChangeEvent) {
        setServicio((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param servicio
     */
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    /**
     * @return
     */
    public String getServicio() {
        return servicio;
    }
    /**
     * @param itServicio
     */
    public void setItServicio(UIInput itServicio) {
        this.itServicio = itServicio;
    }

    /**
     * @return
     */
    public UIInput getItServicio() {
        return itServicio;
    }


    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }
}
