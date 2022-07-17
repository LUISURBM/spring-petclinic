<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formAgregarCirugia">
  <a4j:region id="regionAgregarCirugia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionAgregarCirugia">
      <f:facet name="start">
        <t:div id="chargingAgregarCirugia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableInfoUbication" border="0" cellpadding="0" cellspacing="0" width="100%"
                 columnClasses="td_ubicador">
      <h:outputText value="HISTORIAS CLINICAS >> Cirugia >> Adicionar Cirugias "
                    id="infoUbicationModificarProgramacion"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAgregarCirugiaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneAgregarCirugia" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabAgregarCirugia" label="Agregar Cirugia(s)">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridAgregarCirugia" styleClass="tabContainer">
            <s:fieldset legend="Información Paciente" id="fieldInformacionPacienteModificar" styleClass="fieldset">
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                           rowClasses="labelText,labelTextInfo" id="tableFechasCirugiaModificar">
                <h:outputText value="Tipo Documento"/>
                <h:outputText value="Número Documento"/>
                <h:outputText value="Nombre del Paciente"/>
                <h:outputText value="#{adicionarCirugiaBean.programacion.hcplusuario.husetipoiden}"/>
                <h:outputText value="#{adicionarCirugiaBean.programacion.hcplusuario.husanumeiden}"/>
                <h:outputText value="#{adicionarCirugiaBean.programacion.hcplusuario.huscprimernomb} #{adicionarCirugiaBean.programacion.hcplusuario.huscprimerapel}"/>
                <h:outputText value="Entidad"/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value="#{adicionarCirugiaBean.entidad}"/>
                <h:outputText value=""/>
                <h:outputText value=""/>
              </h:panelGrid>
            </s:fieldset>
            
            
            <jsp:include page="/pages/clinico/cirugia/comun/mantenimientoCirugias.jsp" flush="true"/>
       
         
         
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonesModificar"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Aceptar"
                                 onclick="if (!confirm(\'¿Realmente desea Modificar la Programación de la Cirugia \')) return false"
                                 styleClass="btn btn btn-success" action="#{adicionarCirugiaBean.agregarCirugia}"/>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid></h:panelGrid>
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionAgregarCirugiaMsg" ajaxRendered="true">
                  <t:messages id="msgAgregarCirugiaMsg" showSummary="true" errorClass="error" globalOnly="true"
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