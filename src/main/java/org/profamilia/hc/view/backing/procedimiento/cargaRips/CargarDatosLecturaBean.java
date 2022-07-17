package org.profamilia.hc.view.backing.procedimiento.cargaRips;

import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.myfaces.custom.fileupload.UploadedFile;



public class CargarDatosLecturaBean extends BaseBean {



    private String nombreArchivo; 
    
    
    public CargarDatosLecturaBean() {
    }


    /**
     * @return
     */
    public String cargarDatos() {
        System.out.println("Hola Mundio" + nombreArchivo);
        FacesUtils.addInfoMessage(IMsg.MSG_ADICION + nombreArchivo);
        return null;
    }

    /**
     * @param nombreArchivo
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * @return
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }
    
    
    
    
    
    
    
}





