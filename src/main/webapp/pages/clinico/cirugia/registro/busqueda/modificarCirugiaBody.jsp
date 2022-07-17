<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formModificarCirugia">
  <a4j:region id="regionModificarCirugia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionModificarCirugia">
      <f:facet name="start">
        <t:div id="chargingModificarCirugia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableInfoUbicationModificacion" border="0" cellpadding="0" cellspacing="0" width="100%"
                 columnClasses="td_ubicador">
      <h:outputText value="HISTORIAS CLINICAS >> Cirugia >> Modificar Programación "
                    id="infoUbicationModificarProgramacion"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridModificarCirugiaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneModificarCirugia" styleClass="tabbedPane"
                         selectedIndex="#{modificarProgramacionBean.selectedIndex}" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabModificarCirugia" label="Modificación Programación de Cirugia(s)"
                    disabled="#{modificarProgramacionBean.renderDisponibilidad}">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridModificarCirugia" styleClass="tabContainer">
            <s:fieldset legend="Información Paciente" id="fieldInformacionPacienteModificar" styleClass="fieldset">
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                           rowClasses="labelText,labelTextInfo" id="tableFechasCirugiaModificar">
                <h:outputText value="Tipo Documento"/>
                <h:outputText value="Número Documento"/>
                <h:outputText value="Nombre del Paciente"/>
                <h:outputText value="#{modificarProgramacionBean.programacion.hcplusuario.husetipoiden}"/>
                <h:outputText value="#{modificarProgramacionBean.programacion.hcplusuario.husanumeiden}"/>
                <h:outputText value="#{modificarProgramacionBean.programacion.hcplusuario.huscprimernomb} #{modificarProgramacionBean.programacion.hcplusuario.huscprimerapel}"/>
                <h:outputText value="Entidad"/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value="#{modificarProgramacionBean.entidad}"/>
                <h:outputText value=""/>
                <h:outputText value=""/>
              </h:panelGrid>
            </s:fieldset>
            
            <jsp:include page="/pages/clinico/cirugia/comun/mantenimientoCirugias.jsp" flush="true"/>
       
         
         
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonesModificar"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Modificar"
                                 onclick="if (!confirm(\'¿Realmente desea Modificar la Programación de la Cirugia \')) return false"
                                 styleClass="btn btn btn-success" action="#{modificarProgramacionBean.modificarCirugia}"/>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid></h:panelGrid>
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionModificarCirugiaMsg" ajaxRendered="true">
                  <t:messages id="msgModificarCirugiaMsg" showSummary="true" errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
        </t:panelTab>
      
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>