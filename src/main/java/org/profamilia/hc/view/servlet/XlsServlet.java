package org.profamilia.hc.view.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


// Fecha: 10-jul-2006
// Hora: 16:56:55

/**
 * <Descripci�n>
 *
 * @author mnewball
 */
public class XlsServlet extends HttpServlet {

    private static final long serialVersionUID = 535308571557297372L;
    public static final String DOCUMENT_CONTENTS_ATTRIBUTE_NAME = "document";
    public static final String DOCUMENT_NAME_ATTRIBUTE_NAME = 
        "nombreDocumento";

    protected void doGet(HttpServletRequest httpServletRequest, 
                         HttpServletResponse httpServletResponse) throws ServletException, 
                                                                         IOException {
        HttpSession session = httpServletRequest.getSession();
        // Se obtiene el contenido del documento
        byte[] documentArray = 
            (byte[])session.getAttribute(DOCUMENT_CONTENTS_ATTRIBUTE_NAME);
        String documentName = 
            (String)session.getAttribute(DOCUMENT_NAME_ATTRIBUTE_NAME);
        httpServletResponse.setContentType("application/octet-stream");
        httpServletResponse.setContentLength(documentArray.length);
        httpServletResponse.setHeader("Content-disposition", 
                                      "inline; filename=\"" + documentName + 
                                      "\"");
        httpServletResponse.getOutputStream().write(documentArray);
    }

    protected void doPost(HttpServletRequest httpServletRequest, 
                          HttpServletResponse httpServletResponse) throws ServletException, 
                                                                          IOException {

        doGet(httpServletRequest, httpServletResponse);
    }
}
