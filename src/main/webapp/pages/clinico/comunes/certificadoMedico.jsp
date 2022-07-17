<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridCertificadoMedicoTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneCertificadoMedico" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabCertificadoMedico" label="Certificado M�dico">
      <s:fieldset legend="Datos Basicos" id="fieldCertificadoMedico" styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridCertificadoMedico"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Certificado M�dico " styleClass="labelTextOblig"/>
          <h:panelGroup>
            <h:inputTextarea id="textCertificadoMedico" value="#{certMedicoUsuarioBean.certificado.hcmccertifica}"
                             disabled="#{certMedicoUsuarioBean.modoconsulta}"
                             required="true" style="width:600px"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textCertificadoMedico" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionCertificadoMedicoMsg" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationCertificadoMedicoMsg" showSummary="false" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
          <t:htmlTag value="br"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesControl"
                   columnClasses="panelGridBotones">
        <a4j:commandButton value="Generar Certificado Medico" styleClass="btn btn btn-success"
                           reRender="panelGridCertificadoMedicoTab"
                           action="#{certMedicoUsuarioBean.generarCertificado}"/>
      </h:panelGrid>
      <f:subview id="generarCertificadoMedico" rendered="#{certMedicoUsuarioBean.generoCertificado}">
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