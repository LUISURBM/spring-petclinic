<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridasesoriailveTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsasesoriailve"
                   styleClass="tabContainer">
        <s:fieldset legend="Asesoria" id="fieldAreaasesoria" styleClass="fieldset">
         
        <s:fieldset legend="Se informa sobre:" id="fieldAreaSeInforma" styleClass="fieldset">
         <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAreaSeInforma"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Derechos" styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Respeto de su decisión" styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Autonomía de su decisión" styleClass="labelTextOblig"/>
            <h:outputText/>
              <h:selectOneRadio id="mnuDerechos" required="true" immediate="true"
                                value="#{asesoriaIveBean.asesoria.haicderecho}">
                <f:selectItems value="#{asesoriaIveBean.lstOpciones}"/>
              </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuDerechos" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
             <h:selectOneRadio id="mnuRespetoDecision" required="true" immediate="true"
                                value="#{asesoriaIveBean.asesoria.haicrespdeci}">
                <f:selectItems value="#{asesoriaIveBean.lstOpciones}"/>
              </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuRespetoDecision" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
             <h:selectOneRadio id="mnuAutonomiaDecision" required="true" immediate="true"
                                value="#{asesoriaIveBean.asesoria.haicautodeci}">
                <f:selectItems value="#{asesoriaIveBean.lstOpciones}"/>
              </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuAutonomiaDecision" styleClass="errorMessage"/>
            </a4j:outputPanel>
            </h:panelGrid>
            </s:fieldset>
         <s:fieldset legend="Observación:" id="fieldAreaObservacion" styleClass="fieldset">
          <h:inputTextarea id="itObservacion" onkeydown="return blockEnter(event);" immediate="true"
                               value="#{asesoriaIveBean.asesoria.haicobservacion}" style="width:500px;height:60px"/>
         </s:fieldset>
    </s:fieldset>
        <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMensajesasesoriailve" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInfasesoriailve" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                          infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonGuardarasesoriailve"
                 columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                         action="#{asesoriaIveBean.guardarAsesorialve}">
          <a4j:support event="onclick" status="statusButton"/>
        </h:commandButton>
      </h:panelGroup>
    </h:panelGrid>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>