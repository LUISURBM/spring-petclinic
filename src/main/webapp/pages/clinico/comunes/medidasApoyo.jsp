<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridMedidadApoyoTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneMedidasApoyo" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabMedidasApoyo" label="Medidas de Apoyo">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridMedidaApoyo"
                   rowClasses="labelText,labelTextInfo">
        <h:outputText value="Medida de apoyo" styleClass="labelTextOblig"/>
        <h:panelGroup>
          <h:inputTextarea id="textMedida" value="#{medidadApoyoBean.medida.hmatdescripcio}" required="true"
                           style="width:600px"/>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="textMedidaApoyo" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonesMedidaApoyo"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <a4j:commandButton value="Generar Medida Apoyo" styleClass="boton_fieldset" reRender="panelGridMedidaApoyo"
                               action="#{medidadApoyoBean.generarMedidaApoyo}"/>
          </h:panelGroup>
        </h:panelGrid>
        <h:panelGrid></h:panelGrid>
        <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMedidaApoyoMsg" ajaxRendered="true">
              <t:messages id="msgInformationMedidaApoyoMsg" showSummary="true" errorClass="error" globalOnly="true"
                          layout="table" infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
</h:panelGrid>