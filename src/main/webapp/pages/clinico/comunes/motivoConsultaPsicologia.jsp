<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridMotivoConsultaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneMotivoConsulta" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabMotivoConsulta" label="Motivo Consulta">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsMotivoConsulta" styleClass="tabContainer">
  
        <s:fieldset legend="Motivo de la Consulta " id="fieldMotivo1" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelMotivoConsulta" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Causa Externa" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
           
            <h:selectOneMenu id="menuMotivoConsulta" required="true" onkeydown="return blockEnter(event);"
                disabled="#{motivoBean.modoconsulta}" value="#{motivoBean.causaSelect}">
              <f:selectItems value="#{motivoBean.lstCausa}"/>
            </h:selectOneMenu>
            
            
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuMotivoConsulta" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
             <h:outputText value="Tipo Consulta" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
           
            <h:selectOneMenu id="menuTipoConsulta" required="true" onkeydown="return blockEnter(event);"
                disabled="#{motivoBean.modoconsulta}" value="#{motivoBean.motivo.hmcctipoconps}">
              <f:selectItems value="#{motivoBean.lstTipoConsultaPsicologia}"/>
            </h:selectOneMenu>
            
            
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuTipoConsulta" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
             <h:panelGroup>
            <h:outputText value="Motivo de Consulta" styleClass="#{(motivoBean.motivoOpcional) ? '' : 'labelTextOblig'}" rendered="#{!motivoBean.esValoracionPreanestesica}"/>
            </h:panelGroup>
            <h:outputText value=" "/>
            
            <h:panelGroup>
            <h:inputTextarea id="textMotivoConsulta" 
                required="#{!motivoBean.motivoOpcional}" 
                value="#{motivoBean.motivo.hmctdescripcio}" style="width:600px;height:100px"   
                rendered="#{!motivoBean.esValoracionPreanestesica}"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textMotivoConsulta" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup rendered="#{motivoBean.renderEnferOpc}">
             <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelMotivoConsulta1" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Factores relacionados o asociados con la situación actual" styleClass="labelTextOblig" />
                <h:outputText value=" "/>
                <h:panelGroup>
                <h:inputTextarea id="textEnfermedaActual"  required="#{!motivoBean.enfermedadOpcional}" 
                value="#{motivoBean.motivo.hmctenferactal}" style="width:600px;height:100px"
                    rendered="#{!motivoBean.esValoracionPreanestesica}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="textEnfermedaActual" styleClass="errorMessage"/>
                </a4j:outputPanel>
            </h:panelGrid>
            </h:panelGroup>
          </h:panelGrid>
           <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"   width="40%" id="panelMotivoPHQ9" rowClasses="labelText,labelTextInfo">
           <h:outputText value="Resultado encuesta salud PHQ9" styleClass="labelTextOblig" rendered="#{motivoBean.renderPHQ9}"/>
            <h:panelGroup id = "panelInputPHQ9">
                <h:inputText id="itInputPHQ9" onkeydown="return blockEnter(event);"
                             value="#{motivoBean.motivo.hmnencuestaphq9}" style="width:50px" maxlength="2" required="true" rendered="#{motivoBean.renderPHQ9}"/>
                   <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itInputPHQ9" styleClass="errorMessage"/>
                </a4j:outputPanel>          
            </h:panelGroup>
                
        </h:panelGrid>
        </s:fieldset>
      
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar" columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="boton_fieldset" action="#{motivoBean.guardarMotivoConsulta}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
      <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>