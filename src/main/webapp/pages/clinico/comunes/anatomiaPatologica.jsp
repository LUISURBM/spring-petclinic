<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAnatomiaPatologicaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneAnatomiaPatologica" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabAnatomiaPatologica" label="Anatomia Patologica">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAnatomia">
        <s:fieldset legend="Datos Origen " id="fieldSetOrigen" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosOrigen" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Origen de la pieza " styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:inputTextarea id="textAnatomia" 
            value="#{anatomiaPatolUsuarioBean.anatomia.hapcorigepieza}" disabled="#{anatomiaPatolUsuarioBean.modoconsulta}" required="true" style="width:500px"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textAnatomia" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
        </s:fieldset>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionAnatomiaMsg" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAnatomiaMsg" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonesAnatomia" columnClasses="panelGridBotones">
          <h:panelGroup>
            <a4j:commandButton value="Generar Anatomia" styleClass="btn btn btn-success" reRender="panelTabAnatomiaPatologica"
                               action="#{anatomiaPatolUsuarioBean.generarAnatomia}"/>
          </h:panelGroup>
        </h:panelGrid>
        <f:subview id="generarAnatomia" rendered="#{anatomiaPatolUsuarioBean.generoAnatomia}">
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
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>