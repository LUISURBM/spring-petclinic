<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridSeguimientoPsicologiaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneSeguimientoPsicologia" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabSeguimientoPsicologia" label="Seguimiento">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridSeguimiento">
      
      
          <s:fieldset legend="Compromisos " id="fieldSetCompromisosAnteriores" styleClass="fieldset" rendered = "#{seguimientoPsicologiaBean.renderCompromisos}">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosCompromisosAnteriores"
                       rowClasses="labelText,labelTextInfo">
                  <h:outputText value = "Compromisos"/>     
                  <h:outputText value = "#{seguimientoPsicologiaBean.compromisos}"/>
                       
           </h:panelGrid>            
      </s:fieldset>
      
      
        <s:fieldset legend="Seguimiento " id="fieldSetSeguimiento" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosSeguimiento"
                       rowClasses="labelText,labelTextInfo">
            
            <h:outputText value="Revisión de tareas y Avances " styleClass="labelTextOblig"/>
            <h:outputText value=""/>
            <h:inputTextarea id="itRevisionTareas" style="width:500px;height:70px" required="true"
                             value="#{seguimientoPsicologiaBean.seguimiento.hspcrevistarea}">
              <f:validateLength maximum="2000"/>
            </h:inputTextarea>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itRevisionTareas" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Observaciones Generales  (descripción del profesional frente  a la sesión)"
                          styleClass="labelTextOblig"/>
            <h:outputText value=""/>
            <h:inputTextarea id="itObserGener" style="width:500px;height:70px" required="true"
                             value="#{seguimientoPsicologiaBean.seguimiento.hspcobsergener}">
              <f:validateLength maximum="2000"/>
            </h:inputTextarea>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itObserGener" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
        </s:fieldset>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionSeguimientoMsg" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationSeguimientoMsg" showSummary="false" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonesSeguimiento"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Aceptar" styleClass="boton_fieldset" action="#{seguimientoPsicologiaBean.aceptar}">
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