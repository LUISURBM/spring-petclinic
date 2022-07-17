package org.profamilia.hc.view.backing.clinico.consultorio;

import java.util.Date;
import java.util.List;
import org.profamilia.hc.view.backing.BaseBean;



/**
 * InformacionClinicaBean - CU 001
 * <p>
 * La clase InformacionClinicaBean es usada para registrar informacion de
 * una clinica.
 * @version v001 10/11/2008
 * @author <a href="mailto: jariano@profamilia.org.co">Jos� Andr�s Riano</a>
 */
public class InfoConsultasPendientesBean extends BaseBean {


    private boolean renderConsultas; 
    private List lstConsultasAbiertas; 
    private Date fecha; 
    private String msgCerrarConsulta; 



    /** default constructor */
    public InfoConsultasPendientesBean() {
    }

    /**
     * Initializes UsuarioBean.
     * @see BaseBean#init()
     */
    protected void init() {
     
        cargarDatos();
    }

    public void cargarDatos() {
       fecha = new Date();
        

/*        try {
            lstConsultasAbiertas = serviceLocator.getClinicoService().getConsultasSinCerrar(userName(),this.getClinica().getCclncodigo(),fecha); 
        } catch (Exception e) {
            e.printStackTrace();
        }*/
     
        msgCerrarConsulta = MSG_CONSULTAS_ABIERTAS_HOY; 

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

    public String getMsgCerrarConsulta() {
        return msgCerrarConsulta;
    }
}
