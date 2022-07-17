<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridMotivoConsultaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneMotivoConsulta" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabPausarConsulta" label="Pausar Consulta">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsPausa"
                   styleClass="tabContainer">
        <s:fieldset legend="Pausar Consulta" id="fieldPausar" styleClass="fieldset">
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelPausarConsulta"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="¿Desea pausar la consulta? " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuPausar" immediate="true" required="true"
                                value="#{pausarConsultaBean.pausarConsulta}"
                                valueChangeListener="#{pausarConsultaBean.setPausarConsulta}">
                <f:selectItems value="#{pausarConsultaBean.listaPausar}"/>
                <a4j:support id="supportmnuPausar" event="onclick" immediate="true"
                             action="#{pausarConsultaBean.onChangeAutorizacion}" reRender="tableContentTabsPausa">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuPausar" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:selectOneRadio>
            </a4j:region>
            <t:htmlTag value="br"/>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Lista de motivos de pausa" id="pausCons" styleClass="fieldset"
                    rendered="#{pausarConsultaBean.renderMostrarLista}">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabs">
            <h:outputText value="Motivos" styleClass="labelTextOblig"/>
            <h:outputText value=""/>
            <h:selectOneMenu id="listaCausas" value="#{pausarConsultaBean.codigoCausaPausa}">
              <f:selectItems value="#{pausarConsultaBean.listaCausasPausas}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="listaCausas" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
        </s:fieldset>
        <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                                warnClass="advertencia"/>
                    <t:htmlTag value="br"/>
                </a4j:outputPanel>
            </h:panelGroup>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonGuardar"
                     columnClasses="panelGridBotones" rendered="#{pausarConsultaBean.renderMostrarLista}">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="boton_fieldset"
                             onclick="if (!confirm(\'¿Realmente desea Pausar la Consulta?\')) return false"
                             action="#{pausarConsultaBean.guardar}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
      <h:panelGrid></h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
</h:panelGrid>