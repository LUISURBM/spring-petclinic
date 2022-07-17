<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ page import="net.sf.jasperreports.engine.JasperPrint,net.sf.jasperreports.engine.JRExporterParameter,net.sf.jasperreports.engine.JRExporter"%>
<%@ page import="net.sf.jasperreports.engine.export.JRHtmlExporter,net.sf.jasperreports.engine.export.JRHtmlExporterParameter,net.sf.jasperreports.engine.export.JRPdfExporter"%>
<%@ page import="net.sf.jasperreports.j2ee.servlets.ImageServlet,net.sf.jasperreports.j2ee.servlets.BaseHttpServlet,java.io.PrintWriter,java.io.OutputStream,java.util.HashMap,java.util.Map"%>
<%
JasperPrint jasperPrint1 = (JasperPrint)session.getAttribute("jasperPrint");
boolean mostrarExport=false;
StringBuffer sbuffer = new StringBuffer();
int pageIndex     = 0;
int lastPageIndex = 0;

if(jasperPrint1!= null){

   if (jasperPrint1.getPages() != null) {
      lastPageIndex = jasperPrint1.getPages().size() - 1;
      
    }
  
    String pageStr = request.getParameter("pagina");
    

    try	{
      pageIndex = Integer.parseInt(pageStr);
      
    }catch(Exception e){}	
    if (pageIndex < 0) {
      pageIndex = 0;
    }
    if (pageIndex > lastPageIndex) {
      pageIndex = lastPageIndex;
    }	    
  
 
if(jasperPrint1!= null){

    JRHtmlExporter exporter = new JRHtmlExporter();  
    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint1);            
    exporter.setParameter(JRExporterParameter.OUTPUT_STRING_BUFFER, sbuffer);
    Map imagesMap = new HashMap();
    exporter.setParameter(JRHtmlExporterParameter.IMAGES_MAP, imagesMap);
    exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, request.getContextPath() + "/comun/imagenes?image=");          
    exporter.setParameter(JRExporterParameter.PAGE_INDEX, new Integer(pageIndex));
    exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
    exporter.setParameter(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
    exporter.setParameter(JRHtmlExporterParameter.CHARACTER_ENCODING, "ISO-8859-9");
    exporter.setParameter(JRHtmlExporterParameter.HTML_FOOTER, "");
    exporter.setParameter(JRHtmlExporterParameter.HTML_HEADER, "");
    exporter.exportReport();
    mostrarExport = true;


}

}

%>
<a4j:region renderRegionOnly="false">
  <h:panelGrid id="vwPrevisualizacionLectura" width="100%" border="0">
    <%
            
         if(mostrarExport == true) {
          %>
    <f:verbatim>
      <div class="consulta" align="center">
        <div>
          <div class="consulta1">&nbsp;</div>
          <div align="center">
          
           
            <hr size="1" color="#000000"></hr>
          </div>
          <div class="consulta1">&nbsp;</div>
        </div>
        <tr>
          <td width="50%">&nbsp;</td>
          <td align="left">
            <%=sbuffer.toString()%>
          </td>
          <td width="50%">&nbsp;</td>
        </tr>
      </div>
    </f:verbatim>
    <% }%>
  </h:panelGrid>
</a4j:region>