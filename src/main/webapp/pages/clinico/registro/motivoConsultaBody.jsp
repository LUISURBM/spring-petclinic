<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formMotivoConsulta">
 <a4j:region id="regionMotivoConsulta" renderRegionOnly="false">
    <a4j:status  id = "statusButton" for="regionMotivoConsulta">
      <f:facet name="start">
        <t:div id="chargingMotivoConsulta" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>


  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridMotivoConsultaTab"
               styleClass="tabContainer">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneMotivoConsulta"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabMotivoConsulta" label="Motivo Consulta">
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="tableContentTabsMotivoConsulta"
                     styleClass="tabContainer">
 
      <s:fieldset legend="MOTIVO DE CONSULTA" id="fieldMotivo1"
                  styleClass="fieldset">
        <t:htmlTag value="br"/>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelMotivoConsulta"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Causa Externa"
                        styleClass="labelTextOblig"/>
         <h:panelGroup>
          <h:outputText value="Motivo de Consulta" styleClass="labelTextOblig" rendered="#{!motivoConsultaBean.esValoracionPreanestesica}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneMenu id="menuMotivoConsulta" required="true" disabled="#{motivoConsultaBean.modoconsulta}"
                             value="#{motivoConsultaBean.causaSelect}">
              <f:selectItems value="#{motivoConsultaBean.lstCausa}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuMotivoConsulta" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:inputTextarea id="textMotivoConsulta" required="true"
                            rendered="#{!motivoConsultaBean.esValoracionPreanestesica}"
                             value="#{motivoConsultaBean.motivo.hmctdescripcio}"
                             style="width:300px"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textMotivoConsulta" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
         <h:outputText value = "Finalidad" styleClass="labelTextOblig"/>
         <h:panelGroup>
          <h:outputText value="Enfermedad Actual" styleClass="labelTextOblig" rendered="#{!motivoConsultaBean.esValoracionPreanestesica}"/>
          </h:panelGroup>
          
            <h:panelGroup>
            <h:selectOneMenu id="menuFinalidad" required="true" disabled="#{motivoConsultaBean.modoconsulta}"
                             value="#{motivoConsultaBean.finalidadSelect}">
              <f:selectItems value="#{motivoConsultaBean.lstFinalidades}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuFinalidad" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
       
          <h:panelGroup>
            <h:inputTextarea id="textEnfermedaActual" required="true"
                            rendered="#{!motivoConsultaBean.esValoracionPreanestesica}"
                             value="#{motivoConsultaBean.motivo.hmctenferactal}"
                             style="width:500px"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textEnfermedaActual" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
        <s:fieldset legend="REVISION POR SISTEMAS" id="fieldRevisionPorSistemas"
                  styleClass="fieldset" rendered="#{!motivoConsultaBean.esValoracionPreanestesica}">
        <t:htmlTag value="br"/>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelRevisionPorSistemas"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Revisión por sistemas"
                        styleClass="labelTextOblig"/>
                        
          <h:panelGroup>
            <h:inputTextarea id="textRevisionPorSistemas" required="true"
                             value="#{motivoConsultaBean.motivo.hmccrevisistem}"
                             style="width:600px;height:80px"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textRevisionPorSistemas" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                   width="100%" id="panelBotonModificar"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar"   styleClass="boton_fieldset"
                             action="#{motivoConsultaBean.aceptar}">
            <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </h:panelGrid><h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrors1" showSummary="true"
                      errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
</t:panelTab>
</t:panelTabbedPane>
</h:panelGrid>
</a4j:region>
<script>
  document.forms['body:formMotivoConsulta'].elements[5].focus(); 
</script>
</a4j:form>