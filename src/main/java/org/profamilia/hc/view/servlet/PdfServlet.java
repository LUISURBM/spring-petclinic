package org.profamilia.hc.view.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class PdfServlet extends HttpServlet {

    private static final long serialVersionUID = -6073020605076394429L;
    public static final String DOCUMENT_CONTENTS_ATTRIBUTE_NAME = "document";
    public static final String DOCUMENT_NAME_ATTRIBUTE_NAME = 
        "nombreDocumento";

    protected void doGet(HttpServletRequest httpServletRequest, 
                         HttpServletResponse httpServletResponse) throws ServletException {
        HttpSession session = httpServletRequest.getSession();
        // Se obtiene el contenido del documento
        byte[] documentArray = 
            (byte[])session.getAttribute(DOCUMENT_CONTENTS_ATTRIBUTE_NAME);
        String documentName = 
            (String)session.getAttribute(DOCUMENT_NAME_ATTRIBUTE_NAME);
        httpServletResponse.setContentType("application/pdf");
        if (documentArray != null) {
            httpServletResponse.setContentLength(documentArray.length);
            httpServletResponse.setHeader("Content-disposition", 
                                          "inline; filename=\"" + 
                                          documentName + "\"");
            try {
                httpServletResponse.getOutputStream().write(documentArray);
                httpServletResponse.getOutputStream().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest httpServletRequest, 
                          HttpServletResponse httpServletResponse) throws ServletException, 
                                                                          IOException {

        doGet(httpServletRequest, httpServletResponse);
    }
}
