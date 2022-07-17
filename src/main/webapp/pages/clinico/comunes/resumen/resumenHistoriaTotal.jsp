<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page import="net.sf.jasperreports.engine.JasperPrint,net.sf.jasperreports.engine.JRExporterParameter,net.sf.jasperreports.engine.JRExporter"%>
<%@ page import="net.sf.jasperreports.engine.export.JRHtmlExporter,net.sf.jasperreports.engine.export.JRHtmlExporterParameter,net.sf.jasperreports.engine.export.JRPdfExporter"%>
<%@ page import="net.sf.jasperreports.j2ee.servlets.ImageServlet,net.sf.jasperreports.j2ee.servlets.BaseHttpServlet,java.io.PrintWriter,java.io.OutputStream,java.util.HashMap,java.util.Map"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridresumenConsultaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneresumenConsulta" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabresumenConsulta" label="Resumen Historia">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="tableContentTabsresumenConsulta" styleClass="tabContainer">
        <s:fieldset legend="Datos Registrados" id="fieldresumenConsulta" styleClass="fieldset_report">
                  <%
          JasperPrint jasperPrint = (JasperPrint)session.getAttribute("jasperPrint");
          String mostarReporte  = (String)session.getAttribute("mostarReporte");
          boolean mostrarExport=false;
          StringBuffer sbuffer = new StringBuffer();
          int pageIndex     = 0;
          int lastPageIndex = 0;
          
          if(jasperPrint!= null){
          
           if (jasperPrint.getPages() != null) {
              lastPageIndex = jasperPrint.getPages().size() - 1;
            
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
          
          
          if(jasperPrint!= null){
          
            JRHtmlExporter exporter = new JRHtmlExporter();  
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);            
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
            <h:panelGrid id="vwPrevisualizacion" width="100%" border="0">
              <%
            
         if(mostrarExport == true) {
          %>
              <f:verbatim>
                <table width="100%" cellpadding="0" cellspacing="0" border="0" align="center">
                  <tr>
                    <td width="50%">&nbsp;</td>
                    <td align="left">
                      <hr size="1" color="#000000"></hr>
                      <table width="100%" cellpadding="0" cellspacing="0" border="0">
                        <tr>
                          <td>&nbsp;</td>
                          <td>&nbsp;&nbsp;&nbsp;</td>
                          <%  if (pageIndex > 0)    {   %>
                          <td>
                            <a href="javascript: execute(document.forms[0],'0'); ">
                              <img src="<%= request.getContextPath() %>/comun/imagenes/first.gif" border="0"></img>
                            </a>
                          </td>
                          <td>
                            <a href="javascript: execute(document.forms[0],'<%=pageIndex - 1%>');">
                              <img src="<%= request.getContextPath() %>/comun/imagenes/previous.gif" border="0"></img>
                            </a>
                          </td>
                          <%  }  else   {  %>
                          <td>
                            <img src="<%= request.getContextPath() %>/comun/imagenes/first_grey.gif" border="0"></img>
                          </td>
                          <td>
                            <img src="<%= request.getContextPath() %>/comun/imagenes/previous_grey.gif" border="0"></img>
                          </td>
                          <%  } 
                  if (pageIndex < lastPageIndex)  {  %>
                          <td>
                            <a href="javascript: execute(document.forms[0],'<%=pageIndex + 1%>');">
                              <img src="<%= request.getContextPath() %>/comun/imagenes/next.gif" border="0"></img>
                            </a>
                          </td>
                          <td>
                            <a href="javascript: execute(document.forms[0],'<%=lastPageIndex%>');">
                              <img src="<%= request.getContextPath() %>/comun/imagenes/last.gif" border="0"></img>
                            </a>
                          </td>
                          <% } else {  %>
                          <td>
                            <img src="<%= request.getContextPath() %>/comun/imagenes/next_grey.gif" border="0"></img>
                          </td>
                          <td>
                            <img src="<%= request.getContextPath() %>/comun/imagenes/last_grey.gif" border="0"></img>
                          </td>
                          <% }  %>
                          <td width="100%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        </tr>
                      </table>
                      <hr size="1" color="#000000"></hr>
                    </td>
                    <td width="50%">&nbsp;</td>
                  </tr>
                  <tr>
                    <td width="50%">&nbsp;</td>
                    <td align="left">
                      <%=sbuffer.toString()%>
                    </td>
                    <td width="50%">&nbsp;</td>
                  </tr>
                </table>
              </f:verbatim>
              <% }%>
            </h:panelGrid>
          </a4j:region>
        </s:fieldset>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrors1" showSummary="false" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
     </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>