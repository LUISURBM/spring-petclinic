package org.profamilia.hc.view.backing;

import java.util.Date;


public class ErroresBean extends BaseBean {
    public ErroresBean() {
    }
    
    private Throwable e;
    
    private String mensajeUsuario;
    
    private String mensajeError;
    
    private String causaError;
    
    private StringBuffer textoError;
    
    private String fechaError;

    public void setMensajeUsuario(String mensajeUsuario) {
        this.mensajeUsuario = mensajeUsuario;
    }
    
    private void load(){
        textoError = new StringBuffer();
        causaError = new String();
        
        StackTraceElement[] trace  = e.getStackTrace();
        for (int i=0; i < trace.length; i++)
            textoError.append(trace[i]);


        if(e.getClass() != null)
            causaError  = e.getClass().toString();
        
        if(e.getMessage() != null);
            causaError = causaError + " - " + e.getMessage();
            
        if(e != null)            
            mensajeError = e.toString() ;
        
        if(e.getLocalizedMessage() != null)                
            mensajeError = mensajeError  + " - (" + e.getLocalizedMessage()+")";  

        e.printStackTrace();
    }

    public String getMensajeUsuario() {
        return mensajeUsuario;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setE(Throwable e) {    
        this.e = e;
        load();
    }

    public Throwable getE() {        
        return e;
    }

    public void setCausaError(String causaError) {
        this.causaError = causaError;
    }

    public String getCausaError() {
        return causaError;
    }

    public void setTextoError(StringBuffer texto) {
        this.textoError = texto;
    }

    public StringBuffer getTextoError() {
        return textoError;
    }


    public void setFechaError(String fechaError) {
        this.fechaError = fechaError;
    }

    public String getFechaError() {
        return fechaError;
    }
}
