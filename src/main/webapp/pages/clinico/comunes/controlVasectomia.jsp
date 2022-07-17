<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
id="panelGridControlVasectomiaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
    <t:panelTabbedPane  border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" 
                        activePanelTabVar="true" 
                         width="100%" id="panelTabbedPaneControlVasectomia" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabControlVasectomia" label="Espermograma">
          <a4j:region id="bodyRegionControlVasectomia">
            <a4j:status id="statusButton" for="bodyRegionControlVasectomia">
              <f:facet name="start">
                <t:div id="chargindControlVasectomia" styleClass="loading">
                  <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                    <h:outputText value="Procesando..."/>
                    <h:outputText value="Por favor espere."/>
                  </h:panelGrid>
                </t:div>
              </f:facet>
              <f:facet name="stop"/>
            </a4j:status>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="tableContentTabsControlVasectomia" styleClass="tabContainerControl">
              <s:fieldset legend="Entrega Espermograma" id="fieldControlEspermograma" styleClass="fieldset">
              <t:htmlTag value="br"/>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
                    id="panelControlVasectomia" rowClasses="labelText">
                <h:outputText value="Observaciones Entrega Espermograma" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:inputTextarea id="textControlVasectomia"  required="true"
                                   value="#{controlVasectomiaBean.vasectomia.hcvcdescripcio}"
                                   style="width:500px;height:70px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="textControlVasectomia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
              </s:fieldset>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelBotonRegistrarControlVasectomia" columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Entregar Espermograma" styleClass="btn btn btn-success" 
                action="#{controlVasectomiaBean.aceptar}">
                  <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>        
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMessageControlVasectomia" ajaxRendered="true">
                  <t:htmlTag value="br"/>
                  <t:messages id="msgInformationControlVasectomia" showSummary="true" errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </a4j:region>
        </t:panelTab>
      </t:panelTabbedPane>
</h:panelGrid>