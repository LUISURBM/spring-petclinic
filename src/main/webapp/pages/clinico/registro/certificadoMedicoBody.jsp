<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formCertificadoMedico">
 <a4j:region id="regionCertificadoMedico" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionCertificadoMedico">
      <f:facet name="start">
        <t:div id="chargingCertificadoMedico" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>


  

  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridCertificadoMedicoTab"
               styleClass="tabContainer">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneCertificadoMedico"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabCertificadoMedico" label="Certificado M�dico">

  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridCertificadoMedico" 
               rowClasses="labelText,labelTextInfo">
    <h:outputText value="Certificado M�dico " styleClass="labelTextOblig"/>
    
     <h:panelGroup>
      <h:inputTextarea id="textCertificadoMedico"
      value="#{certificadoMedicoBean.certificado.hcmccertifica}" 
      disabled="#{certificadoMedicoBean.modoconsulta}"
      required = "true"
                       style="width:600px"/>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="textCertificadoMedico" styleClass="errorMessage"/>
      </a4j:outputPanel>
    </h:panelGroup>
   
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelBotonesCertificadoMedico"
                 columnClasses="panelGridBotones">
      <h:panelGroup>
        <a4j:commandButton value="Generar Certificado Medico" styleClass="boton_fieldset"
                           disabled="#{certificadoMedicoBean.modoconsulta}"
                           reRender="panelGridCertificadoMedico"
                           action="#{certificadoMedicoBean.generarCertificado}"/>
      </h:panelGroup>
    </h:panelGrid>
    <h:panelGrid></h:panelGrid>
       <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionCertificadoMedicoMsg"
                                 ajaxRendered="true">
                  <t:messages id="msgInformationCertificadoMedicoMsg" showSummary="true"
                              errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
    
    <f:subview id="generarCertificadoMedico" rendered="#{certificadoMedicoBean.generoCertificado}">
      <f:verbatim>
        <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
      </f:verbatim>
    </f:subview>
    
  </h:panelGrid>
</t:panelTab>
</t:panelTabbedPane>
</h:panelGrid>
</a4j:region>
</a4j:form>