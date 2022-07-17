<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="registrarNotaAclaratoriaForm">
  <a4j:region id="bodyRegionRegistrarNotaAclaratoria">
    <a4j:status id="statusButton" for="bodyRegionRegistrarNotaAclaratoria">
      <f:facet name="start">
        <t:div id="chargindRegistrarNotaAclaratoria" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="tableContentTabsRegistrarNotaAclaratoria" styleClass="tabContainerRegistrarNotaAclaratoria">
      <t:htmlTag value="br"/>
      <s:fieldset legend="Registrar Nota Aclaratoria" id="fieldRegistrarNotaAclaratoria" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelRegistrarNotaAclaratoria" rowClasses="labelText">
          <h:outputText value="Nota Aclaratoria" styleClass="labelTextOblig"/>
          <h:outputText/>
          <h:panelGroup>
            <h:inputTextarea id="textNotaAclaratoria" required="true" value="#{registrarNotaMedicaBean.nota.hnmcdescripc}" 
                             style="width:500px;height:70px"/>
          </h:panelGroup>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="textNotaAclaratoria" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAntecedentes"
                   rowClasses="labelText,labelTextInfo">
        <h:outputText value="Requiere visualizar el menú conducta" rendered="#{registrarNotaMedicaBean.renderOpcionConducta}"  styleClass="labelTextOblig"/>
        <a4j:region renderRegionOnly="false">
          <h:selectOneRadio id="mnuConducta" immediate="true" required="true"
                            onkeydown="return blockEnter(event);"
                            value="#{registrarNotaMedicaBean.opcionConducta}"
                            valueChangeListener="#{registrarNotaMedicaBean.setMenuConductaEvent}"
                            rendered="#{registrarNotaMedicaBean.renderOpcionConducta}">
            <f:selectItems value="#{registrarNotaMedicaBean.lstOpciones}"/>
            <a4j:support id="supportmnuConducta" event="onclick"
                         action="#{registrarNotaMedicaBean.changeMenuConducta}">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuConducta" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:selectOneRadio>
        </a4j:region>
      </h:panelGrid>
      </s:fieldset>
    </h:panelGrid>
     
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="panelBotonRegistrarNotaAclaratoria" columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Guardar" styleClass="boton_fieldset"
                         action="#{registrarNotaMedicaBean.aceptar}">
          <a4j:support event="onclick" status="statusButton"/>
        </h:commandButton>
      </h:panelGroup>
    </h:panelGrid>
    <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrors1" showSummary="true" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>