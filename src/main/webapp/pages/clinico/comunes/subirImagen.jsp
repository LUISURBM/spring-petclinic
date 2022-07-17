<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formCargarDatosLectura" enctype="multipart/form-data">
  <a4j:region id="regionLecturaCitologia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionLecturaCitologia">
      <f:facet name="start">
        <t:div id="chargingLecturaCitologia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridLecturaCitologiaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPanelLecturaCitologia"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabLecturaCitologia" label="Cargar Datos">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridLecturaCitologia1"
                       styleClass="tabContainer">
            <s:fieldset legend="Cargar Datos" id="fieldLectura"
                        styleClass="fieldset">
              <h:panelGrid border="1" columns="2">
                    <h:outputText value="ID"></h:outputText>
                    <h:outputText value="File upload"></h:outputText>
                    <t:inputFileUpload id="file" value="#{subirImagenBean.upload}" required="false" size="40" />
                    <h:commandButton action="#{subirImagenBean.uploadFile}"  value="Add Files"></h:commandButton>
               </h:panelGrid>
            </s:fieldset>
          </h:panelGrid>
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelBotonAceptarLectura"
                       columnClasses="panelGridBotones"></h:panelGrid>
          <h:panelGrid>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionMsgLecturaCito"
                               ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgLecturaCito" showSummary="true"
                            errorClass="error" globalOnly="true" layout="table"
                            infoClass="informacion"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>