package org.profamilia.hc.view.backing.clinico.consultorio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.SelectItem;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;

/**
 * La clase InformacionClinicaBean es usada para registrar informacion de una clinica.
 * @version v001 10/11/2008
 * @author <a href="mailto: jariano@profamilia.org.co">Jos� Andr�s Riano</a>
 */
public class InformacionUsuarioClinicaBean extends BaseBean {

    /** Objeto clinica */
    private Cpclinica infoClinica;
    
    /** Objeto usuario */
    private Cpusuario usuario;
    
    /** Objeto codigo clinica */
    private Integer clinselec; 
    
    /** Lista Clinica Usuario*/
    private List lstClinicaUsuario; 

    /** default constructor */
    public InformacionUsuarioClinicaBean() {
    }

    /**
     * Initializes UsuarioBean.
     * @see BaseBean#init()
     */
    protected void init() {
        infoClinica = new Cpclinica();
        List lstClinicaUsuarioAux = null;
        usuario = this.getUsuarioSystem();
        if (lstClinicaUsuario == null || lstClinicaUsuario.isEmpty()) {
          
            lstClinicaUsuario = new ArrayList();
            if (userName() != null) {
                try {
                    lstClinicaUsuarioAux = 
                            this.serviceLocator.getClinicoService().getClinicasUsuario(userName());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (lstClinicaUsuarioAux != null && 
                    !lstClinicaUsuarioAux.isEmpty()) {
                    Iterator iter = lstClinicaUsuarioAux.iterator();
                    lstClinicaUsuario.add(new SelectItem("", "Seleccione..."));
                    while (iter.hasNext()) {
                        Object[] a = (Object[])iter.next();
                        BigDecimal codigoclin = (BigDecimal)a[0]; 
                        String nomclin = a[1].toString(); 
                        lstClinicaUsuario.add(new SelectItem(codigoclin.intValue(), 
                                                             nomclin));

                    }
                }
            }
        }
            // Si es una unica clinica
        
        if(lstClinicaUsuarioAux!= null && lstClinicaUsuarioAux.size() == 1){
          
               Object[] b = (Object[])lstClinicaUsuarioAux.get(0);
                BigDecimal codigoclin = (BigDecimal)b[0]; 
                if(codigoclin!= null){
                    clinselec = codigoclin.intValue();     
                } 
        }
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
     * @param clinselec
     */
    public void setClinselec(Integer clinselec) {
        this.clinselec = clinselec;
    }

    /**
     * @return
     */
    public Integer getClinselec() {
        return clinselec;
    }

    /**
     * @param lstClinicaUsuario
     */
    public void setLstClinicaUsuario(List lstClinicaUsuario) {
        this.lstClinicaUsuario = lstClinicaUsuario;
    }


    /**
     * @return
     */
    public List getLstClinicaUsuario() {
          return lstClinicaUsuario;
    }

    /**
     * @return
     */
    public String continuar(){
        
      return BeanNavegacion.RUTA_HOME; 
    }

    public String cambiarClinica() {
        try {
            this.serviceLocator.getClinicoService().updateClinicaUsuario(clinselec,userName());
        } catch (ModelException e) {
         e.printStackTrace();
        }
        FacesUtils.resetManagedBean("MenuBean");
        FacesUtils.resetManagedBean("informacionUsuarioBean");
        
        return BeanNavegacion.RUTA_SALIR_CLINICA;
    }
}
