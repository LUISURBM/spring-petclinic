package org.profamilia.hc.view.util;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.profamilia.hc.view.servlet.PdfServlet;


/**
 * Clase que proporciona m�todos para desplegar documentos PDF en una aplicaci�n
 * web, dado que utiliza el servlet PdfServlet.
 * 
 * @author jariano
 */
public class PdfServletUtils {

    /**
     * Despliega el documento PDF contenido en un arreglo de <code>byte</code>
     * en un ambiente JSF. El nombre del archivo desplegado es el nombre por
     * defecto "documento.pdf".
     * 
     * @param document
     *            El contenido del archivo PDF.
     * @param dispatch
     *            Indica si se debe redirigir al servlet o no
     */
    public static void showPdfDocument(byte[] document, boolean dispatch) {

        showPdfDocument(document, "documento.pdf", dispatch);
    }

    /**
     * Despliega el documento PDF contenido en un arreglo de <code>byte</code>
     * en un ambiente JSF. El nombre del archivo ser� el nombre suministrado.
     * 
     * @param document
     *            El contenido del archivo PDF.
     * @param nombreDocumento
     *            El nombre que adquirir� el archivo PDf al ser descargado.
     * @param dispatch
     *            Indica si se debe redirigir al servlet o no
     */
    public static void showPdfDocument(byte[] document, String nombreDocumento, 
                                       boolean dispatch) {

        // Preparar el servlet para imprimir el PDF
        preparePdfServlet(FacesUtils.getHttpSession(), document, 
                          nombreDocumento);

        if (dispatch) {
            // Se redirige al servlet de generaci?n de documentos
            try {
                FacesUtils.getFacesContext().getExternalContext().dispatch(nombreDocumento);
            } catch (IOException ioException) {
                throw new RuntimeException("El documento (documento.pdf) no puede ser desplegado", 
                                           ioException);
            }

            FacesUtils.getFacesContext().responseComplete();
        }
    }

    /**
     * Prepara el servlet para que este pueda obtener el contenido del archivo
     * PDF en el momento de desplegar sus contenidos.
     * 
     * @param session
     *            La sesi�n actual del usuario al cual se desplegar� el archivo
     *            PDF.
     * @param document
     *            El contenido del documento PDF.
     */
    private static void preparePdfServlet(HttpSession session, byte[] document, 
                                          String nombreDocumento) {

        session.setAttribute(PdfServlet.DOCUMENT_CONTENTS_ATTRIBUTE_NAME, 
                             document);
        session.setAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME, 
                             nombreDocumento);
    }
}
