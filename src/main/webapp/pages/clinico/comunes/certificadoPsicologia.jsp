<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridCertificadoPsicologiaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneCertificadoPsicologia" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabCertificadoPsicologia" label="Certificado Psicol�gico">
      <s:fieldset legend="Datos Basicos" id="fieldCertificadoPsicologia" styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridCertificadoPsicologia"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Certificado Psicologia " styleClass="labelTextOblig"/>
          <h:panelGroup>
            <h:inputTextarea id="textCertificadoPsicologia" value="#{certPsicologiaUsuarioBean.certificado.hcmccertifica}"
                             disabled="#{certPsicologiaUsuarioBean.modoconsulta}"
                             required="true" style="width:600px"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textCertificadoPsicologia" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionCertificadoPsicologiaMsg" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationCertificadoPsicologiaMsg" showSummary="false" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
          <t:htmlTag value="br"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesControl"
                   columnClasses="panelGridBotones">
        <a4j:commandButton value="Generar Certificado Psicolog�a" styleClass="btn btn btn-success"
                           reRender="panelGridCertificadoPsicologiaTab"
                           action="#{certPsicologiaUsuarioBean.generarCertificado}"/>
      </h:panelGrid>
      <f:subview id="generarCertificadoPsicologia" rendered="#{certPsicologiaUsuarioBean.generoCertificado}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
        </f:verbatim>
      </f:subview>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>