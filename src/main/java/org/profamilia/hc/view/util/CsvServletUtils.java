
package org.profamilia.hc.view.util;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.profamilia.hc.view.servlet.CsvServlet;



public class CsvServletUtils {

    /**
     * Despliega el documento CSV contenido en un arreglo de <code>byte</code>
     * en un ambiente JSF. El nombre del archivo desplegado es el nombre por
     * defecto "documento.CSV".
     * 
     * @param document
     *            El contenido del archivo CSV.
     * @param dispatch
     *            Indica si se debe redirigir al servlet o no
     */
    public static void showCsvDocument(byte[] document, boolean dispatch) {

            showCsvDocument(document, "documento.csv", dispatch);
    }

    /**
     * Despliega el documento CSV contenido en un arreglo de <code>byte</code>
     * en un ambiente JSF. El nombre del archivo ser� el nombre suministrado.
     * 
     * @param document
     *            El contenido del archivo CSV.
     * @param nombreDocumento
     *            El nombre que adquirir� el archivo CSV al ser descargado.
     * @param dispatch
     *            Indica si se debe redirigir al servlet o no
     */
    public static void showCsvDocument(byte[] document, String nombreDocumento, 
                                       boolean dispatch) {

        // Preparar el servlet para imprimir el CSV
        prepareCsvServlet(FacesUtils.getHttpSession(), document, 
                          nombreDocumento);
        if (dispatch) {
            // Se redirige al servlet de generaci?n de documentos
            try {
                FacesUtils.getFacesContext().getExternalContext().dispatch(nombreDocumento);
            } catch (IOException ioException) {
                throw new RuntimeException("El documento (documento.csv) no puede ser desplegado", 
                                           ioException);
            }

            FacesUtils.getFacesContext().responseComplete();
        }
    }

    /**
     * Prepara el servlet para que este pueda obtener el contenido del archivo
     * CSV en el momento de desplegar sus contenidos.
     * 
     * @param session
     *            La sesi�n actual del usuario al cual se desplegar� el archivo
     *            CSV.
     * @param document
     *            El contenido del documento CSV.
     */
    private static void prepareCsvServlet(HttpSession session, byte[] document, 
                                          String nombreDocumento) {

        session.setAttribute(CsvServlet.DOCUMENT_CONTENTS_ATTRIBUTE_NAME, 
                             document);
        session.setAttribute(CsvServlet.DOCUMENT_NAME_ATTRIBUTE_NAME, 
                             nombreDocumento);
    }
}
