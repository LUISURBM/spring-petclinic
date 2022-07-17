package org.profamilia.hc.view.servlet;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


// Fecha: 15-nov-2013
// Hora: 15:56:55

/**
 * <Descripci�n>
 *
 * @author cavargas
 */
public class CsvServlet extends HttpServlet {

        private static final long serialVersionUID = 1L;
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
                    httpServletResponse.setContentType("text/csv");
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
