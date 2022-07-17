package org.profamilia.hc.view.util;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.profamilia.hc.view.servlet.XlsServlet;


public class XlsServletUtils {

    /**
     * Despliega el documento XLS contenido en un arreglo de <code>byte</code>
     * en un ambiente JSF. El nombre del archivo desplegado es el nombre por
     * defecto "documento.XLS".
     * 
     * @param document
     *            El contenido del archivo XLS.
     * @param dispatch
     *            Indica si se debe redirigir al servlet o no
     */
    public static void showXlsDocument(byte[] document, boolean dispatch) {

        showXlsDocument(document, "documento.xls", dispatch);
    }

    /**
     * Despliega el documento XLS contenido en un arreglo de <code>byte</code>
     * en un ambiente JSF. El nombre del archivo ser� el nombre suministrado.
     * 
     * @param document
     *            El contenido del archivo XLS.
     * @param nombreDocumento
     *            El nombre que adquirir� el archivo XLS al ser descargado.
     * @param dispatch
     *            Indica si se debe redirigir al servlet o no
     */
    public static void showXlsDocument(byte[] document, String nombreDocumento, 
                                       boolean dispatch) {

        // Preparar el servlet para imprimir el XLS
        prepareXlsServlet(FacesUtils.getHttpSession(), document, 
                          nombreDocumento);
        if (dispatch) {
            // Se redirige al servlet de generaci?n de documentos
            try {
                FacesUtils.getFacesContext().getExternalContext().dispatch(nombreDocumento);
            } catch (IOException ioException) {
                throw new RuntimeException("El documento (documento.xls) no puede ser desplegado", 
                                           ioException);
            }

            FacesUtils.getFacesContext().responseComplete();
        }
    }

    /**
     * Prepara el servlet para que este pueda obtener el contenido del archivo
     * XLS en el momento de desplegar sus contenidos.
     * 
     * @param session
     *            La sesi�n actual del usuario al cual se desplegar� el archivo
     *            XLS.
     * @param document
     *            El contenido del documento XLS.
     */
    private static void prepareXlsServlet(HttpSession session, byte[] document, 
                                          String nombreDocumento) {

        session.setAttribute(XlsServlet.DOCUMENT_CONTENTS_ATTRIBUTE_NAME, 
                             document);
        session.setAttribute(XlsServlet.DOCUMENT_NAME_ATTRIBUTE_NAME, 
                             nombreDocumento);
    }
}
