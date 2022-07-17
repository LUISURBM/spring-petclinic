package org.profamilia.hc.view.backing;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;


import org.profamilia.hc.view.util.FacesUtils;
import org.acegisecurity.ui.AbstractProcessingFilter;


public class LoginBacking extends BaseBean {

    // properties
    private String userId;
    private String password;

    private String prueba;

    private String direccionIP;
    
    private int contador =0;
    
    private String sesionAnterior;
    
    private String sessionActual;

    /**
     * default empty constructor
     */
    public LoginBacking() {

        Exception ex = 
            (Exception)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(null/*AbstractAuthenticationProcessingFilter.ACEGI_SECURITY_LAST_EXCEPTION_KEY*/);

        if (ex != null) {
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                          ex.getMessage(), 
                                                                          ex.getMessage()));
        }

    }

    /**
     * Method that is backed to a submit button of a form.
     */
    public String send() {
        return ("success");
    }

    public String getPassword() {

        inicializarApp();
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void inicializarApp() {
        FacesUtils.resetManagedBean("MenuBean");

    }

    /**
     * @param prueba
     */
    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }

    /**
     * @return
     */
    public String getPrueba() {
        return prueba;
    }

    /**
     * @param direccionIP
     */
    public void setDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }

    /**
     * @return
     */
    public String getDireccionIP() {
        return direccionIP;
    }
    
    public boolean validarSession(){
        boolean validacion = true;
        HttpServletRequest request = 
            (HttpServletRequest)FacesUtils.getHttpServletRequest();
        HttpServletResponse response = FacesUtils.getHttpServletResponse();
        sessionActual = request.getSession().getId();
        if(sesionAnterior == null || sesionAnterior.equals("")){
            sesionAnterior = request.getSession().getId();
        }else{
        
            if(sessionActual.equals(sesionAnterior)){
                validacion= false;
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/historiasroot/j_acegi_security_logout.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                validacion= true;
            }   
        }
            return validacion;  
    }
    
    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }
}
