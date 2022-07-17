<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="ReimprimirDocumentosForm">
  <a4j:region id="bodyRegionReimprimirDocumentos">
    <a4j:status  id = "statusButton" for="bodyRegionReimprimirDocumentos">
      <f:facet name="start">
        <t:div id="chargindReimprimirDocumentos" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="tableContentTabsReimprimirDocumentos"
                     styleClass="tabContainerReimprimirDocumentos">
      <t:htmlTag value="br"/>
      <s:fieldset legend="ReImprimir Documentos " id="fieldReimprimirDocumentos"
                  styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelReimprimirDocumentos"
                     rowClasses="labelText">
         <h:outputText value="Documento" styleClass="labelTextOblig"/>
          <h:outputText/>
          <h:panelGroup>
          <h:selectOneMenu id="tipoDocumento" required="true" 
                           value="#{reimprimirDocumentosBean.documentoSelect}">
            <f:selectItems value="#{reimprimirDocumentosBean.listTipoDocumento}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="tipoDocumento" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGroup>
          
          <h:panelGroup/>
           
    
        
        </h:panelGrid>
      </s:fieldset>
      
       <f:subview id="generarAnatomia" rendered="#{reimprimirDocumentosBean.generoDocumento}">
      <f:verbatim>
        <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
      </f:verbatim>
    </f:subview>
    </h:panelGrid>
    
       
    
     <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelBotonReimprimirDocumentos"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <a4j:commandButton value="Generar" styleClass="boton_fieldset"
                 action="#{reimprimirDocumentosBean.reImprimirDocumento}"
                 reRender="tableContentTabsReimprimirDocumentos">
                 
         </a4j:commandButton>
          </h:panelGroup>
        </h:panelGrid>
       
    
    <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrors1" showSummary="true"
                      errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
 
  </a4j:region>
</a4j:form>