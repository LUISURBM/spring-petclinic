package org.profamilia.hc.view.backing.clinico.consultorio;

import java.util.Date;
import java.util.List;
import javax.faces.component.html.HtmlDataTable;

import org.profamilia.hc.model.dto.Chnoticia;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;


/**
 * InformacionClinicaBean - CU 001
 * <p>
 * La clase InformacionClinicaBean es usada para registrar informacion de
 * una clinica.
 * @version v001 10/11/2008
 * @author <a href="mailto: jariano@profamilia.org.co">Jos� Andr�s Riano</a>
 */
public class InformacionUsuarioBean extends BaseBean {

    /** Objeto clinica */
    private Cpclinica infoClinica;
    private Cpusuario usuario;
    private boolean renderConsultas; 
    private List lstConsultasAbiertas; 
    private Date fecha; 
    private String msgCerrarConsulta; 
    private HtmlDataTable dtConsultasAbiertas;
    private List<Chnoticia>lstnoticias;



    /** default constructor */
    public InformacionUsuarioBean() {
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
        
        if(fecha != null && userName() != null && this.getClinica() != null && this.getClinica().getCclncodigo() != null ){
            lstConsultasAbiertas = serviceLocator.getClinicoService().getConsultasSinCerrar(userName(),this.getClinica().getCclncodigo(),fecha);  
        }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Lista de Noticias
        try{
        
            lstnoticias = serviceLocator.getNoticiaService().readNoticia();
        }
        catch(ModelException e){
            FacesUtils.addErrorMessage(MSG_NO_CONSULTA +"la lista de noticias");
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

    public void setLstnoticias(List<Chnoticia> lstnoticias) {
        this.lstnoticias = lstnoticias;
    }

    public List<Chnoticia> getLstnoticias() {
        return lstnoticias;
    }
}
