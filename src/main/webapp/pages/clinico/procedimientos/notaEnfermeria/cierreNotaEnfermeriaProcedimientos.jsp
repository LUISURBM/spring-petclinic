

<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<%@ page import="org.profamilia.hc.view.servlet.CsvServlet"%>
<a4j:form id="formCierreNotaEnfermeria">
  <a4j:region id="regionCierreNotaEnfermeria" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionCierreNotaEnfermeria">
      <f:facet name="start">
        <t:div id="chargingCierreNotaEnfermeria" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="2" id="tableBodyGeneral" border="0" cellpadding="0" cellspacing="0" width="100%"
                 columnClasses="verticalaligntop,td_fondoBarraH">
      <h:panelGroup id="tableGroupContent">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridCierreNotaEnf"
                     styleClass="tabContainer">
          <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                             activePanelTabVar="true" width="100%" id="panelTabbedPaneCierreNotaEnf"
                             styleClass="tabbedPane" activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                             disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                             inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
            <t:panelTab id="panelTabCierreNotaEnfe" label="Cierre Nota de Enfermeria">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelGridCierreNotaEnfe">
                <s:fieldset legend="Cierre Nota" id="fieldReportViniso" styleClass="fieldset">
                  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                               id="panelDatosCierreNotaEnf" rowClasses="labelText,labelTextInfo">
                    <a4j:commandButton value="Cerrar Nota" styleClass="btn btn btn-success"
                                     reRender="panelGridCierreNotaEnf"
                                     onclick="if (!confirm(\'�Realmente desea Cerrar la Nota de Enfermeria\')) return false"
                                     action="#{cierreNotaEnfemeriaProcedimientoBean.cierreNotaEnfermeria}"/>
                    </h:panelGrid>                 
                </s:fieldset>
                <h:panelGroup>
                  <a4j:outputPanel id="ajaxRegionMensajes" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInfCierreNotaEnf" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                                warnClass="advertencia"/>
                    <t:htmlTag value="br"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
            </t:panelTab>
          </t:panelTabbedPane>
        </h:panelGrid>
      </h:panelGroup>
    </h:panelGrid>
    <f:verbatim>
      <input id="pagina" type="hidden" name="pagina"/>
    </f:verbatim>
  </a4j:region>
</a4j:form>
