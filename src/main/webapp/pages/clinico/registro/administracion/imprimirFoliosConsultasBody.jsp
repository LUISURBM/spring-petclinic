<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="imprimirFoliosConsultasForm">
         <script language="JavaScript" type="text/javascript">
window.onbeforeunload = function (event) {
  var message = '�Nos vas a abandonar?';
  if ( typeof event == 'undefined' ) {
    console.log('1');
    event = window.event;
  }
  if ( event ) {
    console.log('Me ejecuto - ');
    console.log(event);
    event.returnValue = message;
  }
  return message;
}         </script>         

    <a4j:region id="bodyRegionImprimirFolios">
        <a4j:status id="statusButton" for="bodyRegionImprimirFolios">
            <f:facet name="start">
                <t:div id="chargindImprimirFoliosConsultas" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
        <h:panelGrid columns="1" id="tableImprimirFoliosConsultas" border="0" cellpadding="0" cellspacing="0"
                     width="100%" styleClass="td_ubicador">
            <h:outputText value="Imprimir Folios Consultas " id="infoUbicationAdministrador"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableimprimirFoliosConsultasTabs" styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaximprimirFoliosConsultas" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgimprimirFoliosConsultas" showSummary="false" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion" showDetail="true"
                                tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabimprimirFoliosConsultas"
                               styleClass="tabbedPane" activeTabStyleClass="activeTab"
                               inactiveTabStyleClass="inactiveTab" selectedIndex="#{imprimirFoliosConsultasBean.selectedIndex}"
                               disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                               inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                <t:panelTab id="panelimprimirFoliosConsultas" label="Imprimir Folios"
                            rendered="#{!imprimirFoliosConsultasBean.renderBuscador}">
                    <t:htmlTag value="br"/>
                    <h:panelGrid>
                    <h:commandLink id="generar" action="#{imprimirFoliosConsultasBean.ImprimirFolios}">
                         <t:graphicImage alt="" border="0" url="/comun/imagenes/pdf.gif"/>
                    </h:commandLink>
                    </h:panelGrid>
                </t:panelTab>
            </t:panelTabbedPane>
        </h:panelGrid>
        <h:panelGrid>
            <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMsgImprimirFoliosConsultas" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationMsgImprimirFoliosConsultas" showSummary="true" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
            </h:panelGroup>
        </h:panelGrid>
        <f:subview id="generarImprimirFoliosConsultas" rendered="#{imprimirFoliosConsultasBean.generoHistoria}">
            <f:verbatim>
                <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
            </f:verbatim>
        </f:subview>
    </a4j:region>
</a4j:form>