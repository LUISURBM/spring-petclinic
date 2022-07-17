<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="net.sf.jasperreports.engine.JasperPrint,net.sf.jasperreports.engine.JRExporterParameter,net.sf.jasperreports.engine.JRExporter"%>
<%@ page import="net.sf.jasperreports.engine.export.JRHtmlExporter,net.sf.jasperreports.engine.export.JRHtmlExporterParameter,net.sf.jasperreports.engine.export.JRPdfExporter"%>
<%@ page import="net.sf.jasperreports.j2ee.servlets.ImageServlet,net.sf.jasperreports.j2ee.servlets.BaseHttpServlet,java.io.PrintWriter,java.io.OutputStream,java.util.HashMap,java.util.Map"%>
<f:view>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/estilos.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/estilos2.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.min.css"/>
    <script language="javascript" src="<%=request.getContextPath()%>/comun/js/common.js" type="text/javascript"></script>
    <script language="javascript" src="<%=request.getContextPath()%>/comun/js/effects.js" type="text/javascript"></script>
             
    <script language="javascript" type="text/javascript">
      <script>
       //Ejecuta una acción
  function execute(form,page_)
  {   
    document.formConsultarAntecedentes.pagina.value=page_;
    document.formConsultarAntecedentes.submit();
   } 
  
</script>
      <title>
        ${msg.title}
      </title>
    </head>

    <a4j:form id="formConsultarAntecedentes">
        <input type="hidden" name="pagina"/>
        <input type="hidden" name="accion"/>
        <h:panelGrid columns="1" cellpadding="0" border="0" cellspacing="2" id="tableUser1" style="text-align:left;"
             width="100%" styleClass="td_footer_login">
   <h:outputText value="Usuario: #{MenuBean.nombUsuario}" id="idUsuario"/>
   <h:outputText value="Clinica: #{MenuBean.clinUsuario}" id="IdClinica"/>
</h:panelGrid>

                     <h:panelGrid columns="1" id="tableInfoUbication" border="0"
                     cellpadding="0" cellspacing="0" width="100%"
                     styleClass="td_ubicador">
          <h:outputText value="Consultar Antecedentes " id="infoUbication"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="88%" id="tableContentTabs"
                     styleClass="tabContainer">
        
          <h:panelGrid>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionMessagesatributo1"
                               ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInformationAndErrors1" showSummary="true"
                            errorClass="error" globalOnly="true" layout="table"
                            infoClass="informacion"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </h:panelGrid>
        
            <s:fieldset legend="Datos Usuario" id="fieldSetInfoAntecedentes"
                  styleClass="fieldset">
        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelRegionAntecedentes"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Tipo Identificación"/>
          <h:outputText value=" Numero Identificación"/>
          <h:outputText value="Número Usuario"/>
          <h:panelGroup>
            <h:selectOneMenu id="tipoIdeAntecedentes" required="true"
                             disabled="true"
                             value="#{consultarAntecedentesBean.usuario.husetipoiden}">
              <f:selectItems value="#{consultarAntecedentesBean.listTipoIdentificacion}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="tipoIdeAntecedentes" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="#{consultarAntecedentesBean.usuario.husanumeiden}"/>
          <h:outputText id="itNumeroUsuarioAntecedentes"
                        value="#{consultarAntecedentesBean.usuario.huslnumero}"/>
          <t:htmlTag value="br"/>
        </h:panelGrid>
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelDatosNombreAntecedentes"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Primer Nombre"/>
          <h:outputText value="Segundo Nombre"/>
          <h:outputText value="Primer Apellido"/>
          <h:outputText value="Segundo Apellido"/>
          <h:panelGroup>
            <h:outputText value="#{consultarAntecedentesBean.usuario.huscprimernomb}"/>
          </h:panelGroup>
          <h:outputText value="#{consultarAntecedentesBean.usuario.huscsegundnomb}"/>
          <h:panelGroup>
            <h:outputText id="primerApellido"
                          value="#{consultarAntecedentesBean.usuario.huscprimerapel}"/>
          </h:panelGroup>
          <h:outputText value="#{consultarAntecedentesBean.usuario.huscsegundapel}"/>
          <h:outputText value="Fecha Nacimiento"/>
          <h:outputText value="Edad"/>
          <h:outputText value="Sexo"/>
          <h:outputText value="Estado Civil"/>
          <h:panelGroup>
            <h:outputText value="#{consultarAntecedentesBean.usuario.husdfechanacim}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="#{consultarAntecedentesBean.edad}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneMenu id="radioSexo" disabled="true"
                             value="#{consultarAntecedentesBean.usuario.husesexo}">
              <f:selectItems value="#{consultarAntecedentesBean.listSexos}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioSexo" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneMenu id="radioEstadoCivil" disabled="true"
                             value="#{consultarAntecedentesBean.usuario.huseestadcivil}">
              <f:selectItems value="#{consultarAntecedentesBean.listEstadoCivil}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioEstadoCivil" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelBotonConsultarAntecedentes"
                     columnClasses="columnaBotonesCentrados">
          <h:panelGroup>
          <h:commandButton value = "Consultar" action = "#{consultarAntecedentesBean.consultarAntecedente}"/>
          
            <a4j:outputPanel id="ajaxRegionAntecedentes" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:message for="idButtonBuscarHistoria"
                         id="msgInformationConsultarHistoria" errorClass="error"
                         infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <t:htmlTag value="br"/>
        </h:panelGrid>
            </s:fieldset>
      
      
       <f:verbatim>
       
        <h:panelGrid id="vwPrevisualizacion"  >
         
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
                exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image?image=");
                exporter.setParameter(JRExporterParameter.PAGE_INDEX, new Integer(pageIndex));
                exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                exporter.setParameter(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                exporter.setParameter(JRHtmlExporterParameter.CHARACTER_ENCODING, "ISO-8859-9");
                exporter.exportReport();
              mostrarExport=true;
              
            
            }
            
            }
            
         if(mostrarExport==true) {
          %>
            <table width="100%" cellpadding="0" cellspacing="0" border="0">
              <tr>
                <td width="50%">&nbsp;</td>
                <td align="left">
                  <hr size="1" color="#000000"></hr>
                  <table width="100%" cellpadding="0" cellspacing="0"
                         border="0">
                    <tr>
                      <td>&nbsp;</td>
                      <td>&nbsp;&nbsp;&nbsp;</td>
                      <%  if (pageIndex > 0)    {   %>
                      <td>
                        <a href="javascript: execute(document.forms[0],'0'); ">
                          <img src="<%= request.getContextPath() %>/comun/imagenes/first.gif"
                               border="0"></img>
                        </a>
                      </td>
                      <td>
                        <a href="javascript: execute(document.forms[0],'<%=pageIndex - 1%>');">
                          <img src="<%= request.getContextPath() %>/comun/imagenes/previous.gif"
                               border="0"></img>
                        </a>
                      </td>
                      <%  }  else   {  %>
                      <td>
                        <img src="<%= request.getContextPath() %>/comun/imagenes/first_grey.gif"
                             border="0"></img>
                      </td>
                      <td>
                        <img src="<%= request.getContextPath() %>/comun/imagenes/previous_grey.gif"
                             border="0"></img>
                      </td>
                      <%  } 
                  if (pageIndex < lastPageIndex)  {  %>
                      <td>
                        <a href="javascript: execute(document.forms[0],'<%=pageIndex + 1%>');">
                          <img src="<%= request.getContextPath() %>/comun/imagenes/next.gif"
                               border="0"></img>
                        </a>
                      </td>
                      <td>
                        <a href="javascript: execute(document.forms[0],'<%=lastPageIndex%>');">
                          <img src="<%= request.getContextPath() %>/comun/imagenes/last.gif"
                               border="0"></img>
                        </a>
                      </td>
                      <% } else {  %>
                      <td>
                        <img src="<%= request.getContextPath() %>/comun/imagenes/next_grey.gif"
                             border="0"></img>
                      </td>
                      <td>
                        <img src="<%= request.getContextPath() %>/comun/imagenes/last_grey.gif"
                             border="0"></img>
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
            <% }%>
          </h:panelGrid>
       </f:verbatim>
          <h:panelGrid>
        <h:commandLink action="#{consultarAntecedentesBean.volverConsulta}" immediate="true">
          <t:graphicImage  alt="" border="0" url="/comun/imagenes/volver.gif"/>
        </h:commandLink>
      </h:panelGrid>

      </a4j:form>
  </html>
</f:view>