package org.profamilia.hc.view.util;
 
import java.io.*;    
import org.apache.commons.net.ftp.*;

/**
 * Clase que gestiona la conexi�n a un servidor y la de sus ficheros.
 *
 */
public class Ftp {
    // Variables de clase.
    private static String dirActual;
    private static FTPClient cliente = new FTPClient();

    // M�todos: 
    /**
     * Nos conecta a un servidor mediante usuario y contrase�a.
     * @param server Servidor al que nos queremos conectar.
     * @param user Usuario para poder acceder.
     * @param pwd Contrase�a para poder acceder.
     * @return True, si la conexi�n se estableci�.<br>
     * False, es caso contrario.
     */
    public static boolean conectar(String server, String user, String pwd){     
        try {
            // Conectarse e identificarse.
            cliente.setDefaultTimeout(1000*60);
            cliente.connect(server);
            // Activar recibir/enviar cualquier tipo de archivo
            cliente.setFileType(FTP.BINARY_FILE_TYPE);
            if(cliente.login(user, pwd)){
                // Entrando a modo pasivo
                cliente.enterLocalPassiveMode();

                // Obtener respuesta del servidor y acceder.
                int respuesta = cliente.getReplyCode();
                if (FTPReply.isPositiveCompletion(respuesta) == true) {
                    return true;
                }else{
                    return false;
                }
            }else{
               cliente.logout();
               System.out.println("Usuario o contrase�a incorrectos.");
                return false;
            }
        } catch (IOException e) {
            System.out.println("Host del servidor incorrecto: "+server);
            e.printStackTrace();
            return false;
        }           
    }

    /**
     * Cierra sesi�n del usuario y se desconecta del servidor.
     * @return True, si se ha desconectado correctamente.<br>
     * False, en caso contrario.
     */
    public static boolean desconectar() {
        try {
            // Cerrar sesion y desconectar.
            cliente.logout();
            cliente.disconnect();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Cambia de directorio dentro de un servidor.
     * @param dirCarpeta Direcci�n completa de la carpeta a la cual queremos acceder
     * dentro del servidor.
     * @return True, si ha cambiado de directorio.<br>
     * False, en caso contrario.
     */ 
    public static boolean cambiarDirectorio(String dirCarpeta) {        
        try {
            // Ubicarse en directorio: ftp          
            cliente.changeWorkingDirectory(dirCarpeta);
            dirActual =  cliente.printWorkingDirectory();

            if(dirCarpeta.compareTo(dirActual) == 0){
                // Ha cambiado de forma satisfactoria.
                return true;
            }else{
                return false;
            }

        } catch (IOException e) {
            System.out.println("Error al cambiar de directorio.");
            e.printStackTrace();
            return false;
        }       
    }

    /**
     * Descarga un archivo del servidor y lo almacena en una ruta espec�fica.
     * @param nomArch Nombre del archivo a descargar.
     * @param destino Direcci�n donde se quiere almacenar el archivo.
     * @return True, si la descarga y almacenamiento ha sido correcto.<br>
     * False, en caso contrario.
     */
    public static boolean descargaArchivo(String nomArch, String destino){
        String ext = ".csv";// El archivo de extensi�n que tu desees.
        OutputStream os;
        boolean archDescargado = false;

        // Asegurarse que es ".csv".
        if(nomArch.length() < 4){
            return false;
        }       
        String extension = nomArch.substring(nomArch.length() - 4, nomArch.length());
        extension = extension.toUpperCase();

        if (extension.compareTo(ext) == 0) {
            try {
                os = new BufferedOutputStream(new FileOutputStream(destino +"/"+ nomArch));
                archDescargado = cliente.retrieveFile(nomArch, os);
                os.close();
            } catch (IOException e) {
                System.out.println("No ha sido posible encontrar la carpeta: "+destino);
                e.printStackTrace();
            }
        }

        return archDescargado;      
    }

    /**
     * Borra un archivo csv de la ubicaci�n actual del servidor.
     * @param nomArch Nombre del archivo csv a borrar.
     * @return True, si se ha borrado del servidor.<br>
     * False, en caso contrario.
     */
    public static boolean borrarArchivoCsv(String nomArch){
        boolean borrado = false;
        String ext = ".csv";

        try {
            String extension = nomArch.substring(nomArch.length() - 4, nomArch.length());
            extension = extension.toUpperCase();
            if (extension.compareTo(ext) == 0) {
                borrado = cliente.deleteFile(nomArch);
            }           

        } catch (IOException e) {
            e.printStackTrace();
        }
        return borrado;
    }

    /**
     * Sube un archivo al servidor en la ubicaci�n actual.
     * @param pathArch Direcci�n del archivo, incluido el archivo. Ejm: /carpeta/archivo.csv
     * @param arch Nombre del archivo y su extensi�n. Ejm: archivo.csv
     * @return True, si ha subido de forma satisfactoria el archivo.<br>
     * False, en caso contrario.
     */
    public static boolean subirArchivo(String pathArch, String arch){
        InputStream is;
        boolean archSubido = false;

        try {           
            // Capturar el fichero de su ruta.
            is = new BufferedInputStream(new FileInputStream(pathArch));

            // Subir el fichero en s�.
            archSubido = cliente.storeFile(arch, is);           
            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return archSubido;
    }

    /**
     * Sube un archivo al servidor en la ubicaci�n actual.
     * @param bytearch archivo en bytes
     * @param arch Nombre del archivo y su extensi�n. Ejm: archivo.csv
     * @return True, si ha subido de forma satisfactoria el archivo.<br>
     * False, en caso contrario.
     */
    public static boolean subirArchivo(byte[] bytearch, String arch){
        ByteArrayInputStream is; 
        boolean archSubido = false;

        try {           
            // Capturar el fichero de su ruta.
            is = new ByteArrayInputStream(bytearch);

            // Subir el fichero en s�.
            archSubido = cliente.storeFile(arch, is);           
            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return archSubido;
    }


    // Getters y setters:
    /**
     * Nos dice en que ubicaci�n del servidor estamos actualmente.
     * @return Un String que contiene el path de ubicaci�n actual.
     */
    public static String dameDirActual() {
        return dirActual;
    }

}