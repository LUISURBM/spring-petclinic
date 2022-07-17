<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridMotivoConsultaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneExamenFisicoPediatria"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabExamenFisicoPediatria" label="Examen Fisico Pediatria ">

<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="tableContentTabsExamenPediatria"
                     styleClass="tabContainer">
      <s:fieldset legend="Composición Familiar" id="fieldExamenPediatria"
                  styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelcomposicionFamiliar"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Composición Familiar"
                        styleClass="labelTextOblig"/>
          <h:panelGroup>
            <h:inputTextarea id="itcomposicionFamiliar" required="true"  
                             style="width:600px"
                             value="#{examenFisicoExamenPediatriaBean.examen.hpeccompofamil}"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itcomposicionFamiliar" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Estado  " id="fieldExamen" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelexamenFamiliar"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Estado General" styleClass="labelTextOblig"/>
          <h:outputText value="Estado Respiratorio Dificultad"
                        styleClass="labelTextOblig"/>
          <h:panelGroup>
            <h:selectOneRadio id="radioEstadoGeneral" required="true"  onkeydown="return blockEnter(event);"
                              value="#{examenFisicoExamenPediatriaBean.examen.hpeeestadogene}">
              <f:selectItems value="#{examenFisicoExamenPediatriaBean.lstEstadoGeneral}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioEstadoGeneral" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="radioEstadoRespiratorio" required="true"  onkeydown="return blockEnter(event);"
                              value="#{examenFisicoExamenPediatriaBean.examen.hpeeestadoresp}">
              <f:selectItems value="#{examenFisicoExamenPediatriaBean.lstEstadoRespiratorio}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioEstadoRespiratorio"
                         styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="Estado de Hidratación "
                        styleClass="labelTextOblig"/>
          <h:outputText value="Estado de Conciencia"
                        styleClass="labelTextOblig"/>
          <h:panelGroup>
            <h:selectOneRadio id="radioEstadoHidratacion" required="true"  onkeydown="return blockEnter(event);"
                              value="#{examenFisicoExamenPediatriaBean.examen.hpeeestadohidr}">
              <f:selectItems value="#{examenFisicoExamenPediatriaBean.lstEstadoHidratacion}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioEstadoHidratacion"
                         styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="radioEstadoConciencia" required="true"  onkeydown="return blockEnter(event);"
                              value="#{examenFisicoExamenPediatriaBean.examen.hpeeestadoconc}">
              <f:selectItems value="#{examenFisicoExamenPediatriaBean.lstEstadoConciencia}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioEstadoConciencia"
                         styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="Observaciones" styleClass="labelTextOblig"/>
          <h:outputText/>
          <h:panelGroup>
            <h:inputTextarea id="itObservacionesExamenPediatria" required="true"  
                             style="width:600px"
                             value="#{examenFisicoExamenPediatriaBean.examen.hpecobservacio}"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itObservacionesExamenPediatria" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                   width="100%" id="panelBotonExamenPediatria"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar" styleClass="boton_fieldset"
                             action="#{examenFisicoExamenPediatriaBean.guardarExamenPediatria}">
                  <a4j:support event="onclick" status="statusButton"/>           
            </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </h:panelGrid><h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMessagesExamenPediatria"
                         ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgExamenPediatria" showSummary="true"
                      errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
</t:panelTab>
</t:panelTabbedPane>
    <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>