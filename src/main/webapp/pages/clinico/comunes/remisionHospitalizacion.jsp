<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridRemisionHospitalizacionTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneRemisionHospitalizacion" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabRemisionHospitalizacion" label="Hospitalizaci�n">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridHospitalizacion" rowClasses="labelText,labelTextInfo">
        <h:outputText value="Motivo de la Hospitalizaci�n " styleClass="labelTextOblig"/>
        <h:panelGroup>
          <h:inputTextarea id="textHospitalizacion" onkeydown="return blockEnter(event);"
                           disabled="#{hospitalizacionUsuarioBean.modoconsulta}" 
                           value="#{hospitalizacionUsuarioBean.hospitalizacion.hrhcmotivhospi}" 
                           required="true"
                           style="width:600px"/>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="textHospitalizacion" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:outputText value="Plan de Manejo" styleClass="labelTextOblig"/>
        <h:panelGroup>
          <h:inputTextarea id="textPlanManejo" onkeydown="return blockEnter(event);"
                           disabled="#{hospitalizacionUsuarioBean.modoconsulta}" 
                           value="#{hospitalizacionUsuarioBean.hospitalizacion.hrhcplanmanejo}" 
                           required="true"
                           style="width:600px"/>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="textPlanManejo" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGroup>
      </h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionHospitalizacionMsg" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationHospitalizacionMsg" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                      warnClass="advertencia"/>
          <t:htmlTag value="br"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonesRemisionHospitalizacion" columnClasses="panelGridBotones">
        <h:panelGroup>
          <a4j:commandButton value="Generar Hospitalizacion" styleClass="btn btn btn-success"  reRender="panelGridRemisionHospitalizacionTab"
                             action="#{hospitalizacionUsuarioBean.generarHospitalizacion}"/>
        </h:panelGroup>
        <f:subview id="generarHospitalizacion" rendered="#{hospitalizacionUsuarioBean.generoHospitalizacion}">
          <f:verbatim>
            <script type="text/javascript" language="JavaScript">
                window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
            </script>
          </f:verbatim>
        </f:subview>
      </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
   <script language="javascript" type="text/javascript">
        document.forms[1].elements[5].focus()
</script>
</h:panelGrid>