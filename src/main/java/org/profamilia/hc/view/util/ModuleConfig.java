package org.profamilia.hc.view.util;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import org.jboss.logging.Logger;


/**
 * Manages the configuration properties.
 * @author lsierra.
 *
 */
public class ModuleConfig {
    /**
     * This is the logger.
     */
    private static Logger logger = Logger.getLogger(ModuleConfig.class);
    /**
     * Properties configuration map.
     */
    private static Properties properties = null;
    /**
     * the reports classes package.
     */
    private static String direccionCodigoQR = null;
    /**
     * the reports classes package.
     */
    private static String ubicacionCodigoQR = null;
    
    private static String direccionCodigoQRLista = null;
    
    private static String direccionWebServiceSaludTotal = null;
    
    private static String direccionArchivosTmp = null;
    
    
    
    /**
     * Par�metros para configuraci�n de correo
     */
    private static String smtpHost = null;
    private static String smtpPort = null;
    private static String smtpSource = null;
 

    /**
     * loads the configuration file.
     */
    private static ModuleConfig config = new ModuleConfig();
    public ModuleConfig() {
        if (properties == null) {
            loadConfig();
        }
    }

    private void loadConfig() {
        properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("modules.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        direccionCodigoQR = properties.getProperty("direccion.codigoQR");
        direccionCodigoQRLista = properties.getProperty("direccion.codigoQRLista");
        ubicacionCodigoQR = properties.getProperty("ubicacion.codigoQR");
        direccionWebServiceSaludTotal = properties.getProperty("direccion.webServiceSaludTotal");
        direccionArchivosTmp = properties.getProperty("archivos.temporales");
        
        //Configuraci�n JavaMail
        smtpHost = properties.getProperty("javamail.smtp.host");
        smtpPort = properties.getProperty("javamail.smtp.port");
        smtpSource = properties.getProperty("javamail.smtp.source");
        
    }
	/**
     * the test.
     * @param args the arguments.
     */
    public static void main(String args[]) {
    	new ModuleConfig();
    }


    public void setDireccionCodigoQR(String direccionCodigoQR) {
        this.direccionCodigoQR = direccionCodigoQR;
    }

    public String getDireccionCodigoQR() {
        if (direccionCodigoQR == null) {
            direccionCodigoQR = "";
        }   
        return direccionCodigoQR;
    }

    public void setUbicacionCodigoQR(String ubicacionCodigoQR) {
        this.ubicacionCodigoQR = ubicacionCodigoQR;
    }

    public String getUbicacionCodigoQR() {
        if (ubicacionCodigoQR == null) {
            ubicacionCodigoQR = "";
        }   
        return ubicacionCodigoQR;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpSource(String smtpSource) {
        this.smtpSource = smtpSource;
    }

    public String getSmtpSource() {
        return smtpSource;
    }

    public void setDireccionCodigoQRLista(String direccionCodigoQRLista) {
        this.direccionCodigoQRLista = direccionCodigoQRLista;
    }

    public String getDireccionCodigoQRLista() {
        return direccionCodigoQRLista;
    }

    public void setDireccionWebServiceSaludTotal(String direccionWebServiceSaludTotal) {
        this.direccionWebServiceSaludTotal = direccionWebServiceSaludTotal;
    }

    public String getDireccionWebServiceSaludTotal() {
        return direccionWebServiceSaludTotal;
    }

    public void setDireccionArchivosTmp(String direccionArchivosTmp) {
        this.direccionArchivosTmp = direccionArchivosTmp;
    }

    public String getDireccionArchivosTmp() {
        return direccionArchivosTmp;
    }
}

