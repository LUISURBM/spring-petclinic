<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridPlanTratamientoTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPanePlanTratamiento" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabPlanTratamiento" label="Plan de Tratamiento">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="tableContentTabsPlanTratamiento" styleClass="tabContainer">
        <s:fieldset legend="Plan de Tratamiento" id="fieldPlanTratamiento" styleClass="fieldset">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelPlanTratamiento"
                       rowClasses="labelText,labelTextInfo">
                   <h:outputText value = "Tipo de intervención " styleClass="labelTextOblig"/>    
                   <h:outputText value = ""/>
                   <h:outputText value = "Número de sesiones" styleClass="labelTextOblig"/>
                   <h:outputText value = ""/>
                   
         <h:selectManyCheckbox id="mnuTipoDeIntervencion" style="border-style:none;"  required="true"  layout="pageDirection"
                          value="#{planTratamientoUsuarioBean.lstIntervencionSelect}">
              <f:selectItems value="#{planTratamientoUsuarioBean.lstTipoIntervencion}"/>
                </h:selectManyCheckbox>
                
                 <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuTipoDeIntervencion" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
            <h:inputText id = "itNumeroDeSesiones" required="true" style="width:50px" maxlength="1"
                value = "#{planTratamientoUsuarioBean.plan.hptnnumersesio}"/>
                   
             <a4j:outputPanel ajaxRendered="true">
              <t:message for="itNumeroDeSesiones" styleClass="errorMessage"/>
            </a4j:outputPanel>
        </h:panelGrid>
        
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelCompromisos"
                       rowClasses="labelText,labelTextInfo">
                            
                   <h:outputText value = "Compromisos" styleClass="labelTextOblig"/>
                   <h:outputText/>
                   
                   <h:inputTextarea id = "itCompromisos" required="true" style="width:600px"
                    value = "#{planTratamientoUsuarioBean.plan.hptccompromiso}"/>
                    
                                 <a4j:outputPanel ajaxRendered="true">
              <t:message for="itCompromisos" styleClass="errorMessage"/>
            </a4j:outputPanel>
                       
                </h:panelGrid>
        
        </s:fieldset>
        <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMensajesPlanTratamiento" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInfPlanTratamiento" showSummary="true" errorClass="error" globalOnly="true"
                          layout="table" infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="panelBotonGuardarPlanTratamiento" columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Guardar" styleClass="boton_fieldset"
                         action="#{planTratamientoUsuarioBean.guardarPlanTratamiento}">
          <a4j:support event="onclick" status="statusButton"/>
        </h:commandButton>
      </h:panelGroup>
    </h:panelGrid>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>