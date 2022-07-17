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
    <t:panelTab id="panelTabMotivoConsulta" label="Motivo Consulta">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="tableContentTabsMotivoConsulta" styleClass="tabContainer">
        <s:fieldset legend="Remisión " id="fieldContactoProfamilia" styleClass="fieldset"
                    rendered="#{motivoBean.renderConocioProfamilia}">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelDatosContactoProfamilia" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Ingresa a Profamilia por:" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:panelGroup id="panelOutputContacto">
              <h:outputText value="Cual? " styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:outputText value=" "/>
            <h:panelGroup id="panelRemision">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuTipoContacto" immediate="true" required="true"
                                  value="#{motivoBean.motivo.hmcctipoconta}" onkeydown="return blockEnter(event);"
                                  valueChangeListener="#{motivoBean.setHmcctipoconta}">
                  <f:selectItems value="#{motivoBean.lstTipoContacto}"/>
                  <a4j:support id="supportTipoContacto" event="onclick" action="#{motivoBean.changeContacto}"
                               reRender="panelOutputContacto,panelInputContacto">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuTipoContacto" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelInputContacto">
              <h:selectOneMenu id="mnuCualContacto" required="true" onkeydown="return blockEnter(event);"
                               value="#{motivoBean.motivo.hmcccualconta}">
                <f:selectItems value="#{motivoBean.lstContacto}"/>
              </h:selectOneMenu>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuCualContacto" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Motivo de la Consulta " id="fieldMotivo1" styleClass="fieldset">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelMotivoConsulta"
                       rowClasses="labelText,labelTextInfo">
            <h:panelGroup>
              <h:outputText value="Motivo de Consulta" styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:outputText value=" "/>
            <h:outputText value=" "/>
            <h:outputText value=" "/>
            <h:panelGroup>
              <h:panelGroup>
                <h:inputTextarea id="textMotivoConsulta" required="#{!motivoBean.motivoOpcional}"
                                 value="#{motivoBean.motivo.hmctdescripcio}" style="width:300px"/>
              </h:panelGroup>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textMotivoConsulta" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value=" "/>
            <h:outputText value=" "/>
            <h:outputText value="Finalidad" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:outputText value=" "/>
            <h:outputText value=" "/>
            <h:selectOneMenu id="menuFinalidad" onkeydown="return blockEnter(event);" required="true"
                             disabled="true"
                             value="#{motivoBean.finalidadSelect}">
              <f:selectItems value="#{motivoBean.lstFinalidadesProcedimiento}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuFinalidad" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value=" "/>
            <h:outputText value=" "/>
          </h:panelGrid>
        </s:fieldset>
        <!-- ***** -->
        <!-- ***** -->
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        styleClass="alert alert-success" warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                             action="#{motivoBean.guardarMotivoProcedimiento}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
</h:panelGrid>