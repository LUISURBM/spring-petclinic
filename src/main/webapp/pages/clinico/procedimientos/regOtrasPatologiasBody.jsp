<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="infoClinicaForm">
  <a4j:region id="bodyRegionCU">
    <a4j:status id="statusButton" for="bodyRegionCU">
      <f:facet name="start">
        <t:div id="chargindDiv2" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableInfoUbication" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="td_ubicador">
      <h:outputText value="Historias Clinicas >> Registro de Patologias" id="infoUbication"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabs" styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="tabbedPaneParametro" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabInfoGenral" label="Otras Patologias" rendered="true">
          <t:htmlTag value="br"/>
          <s:fieldset legend="Datos Basicos" id="fieldSetInfoBasica" styleClass="fieldset">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoConsulta" rowClasses="labelText,labelTextInfo">
              <h:outputLabel value="Fecha"/>
              <h:outputText value=" "/>
              <h:outputLabel value="Clinica Origen" for="chopnclinorig" styleClass="labelTextOblig"/>
              <h:outputText value=" "/>
              <h:outputLabel value="#{otrasPatologiasBean.chotraspatolog.chopdfechareg}">
                <f:convertDateTime dateStyle="full" type="date"/>
              </h:outputLabel>
              <h:outputText value=" "/>
              <h:selectOneMenu id="chopnclinorig" value="#{otrasPatologiasBean.idCentro}" required="true" disabled="true">    
                <f:selectItems value="#{otrasPatologiasBean.listCentros}"/>
              </h:selectOneMenu>
              <t:message for="chopnclinorig" errorClass="errorMessage"/>
              <h:outputLabel value="Tipo de Documento" for="chopntipodoc" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:outputLabel value="Número Documento" for="chopnnumdoc" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:selectOneMenu id="chopntipodoc" value="#{otrasPatologiasBean.idTipoDocumento}" required="true" disabled="#{otrasPatologiasBean.mostrarFactura}">
                <f:selectItem itemLabel="Seleccione una opción..." itemValue=""/>
                <f:selectItem itemLabel="FACTURA DE SERVICIOS" itemValue="2"/>
                <f:selectItem itemLabel="FACTURA DE VENTA" itemValue="51"/>
                <f:selectItem itemLabel="COMPROBANTE MANUAL" itemValue="20"/>
              </h:selectOneMenu>
              <t:message for="chopntipodoc" errorClass="errorMessage"/>
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
                <a4j:commandButton value="Buscar" action="#{otrasPatologiasBean.buscadorDoc}" reRender="tableContentTabs" image="/comun/imagenes/lupa.gif"/>
                <h:inputText id="chopnnumdoc" value="#{otrasPatologiasBean.chotraspatolog.chopnnumdoc}" size="12" required="true" disabled="#{otrasPatologiasBean.mostrarFactura}"/>
              </h:panelGrid>
              <t:message for="chopnnumdoc" styleClass="errorMessage"/>
            </h:panelGrid>
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionFactura" rowClasses="labelText,labelTextInfo"
                         rendered="#{otrasPatologiasBean.mostrarFactura}">
              <h:outputLabel value="Identificación"/>
              <h:outputText value=""/>
              <h:outputLabel value="Usuario(a)"/>
              <h:outputText value=""/>
              <h:outputLabel value="#{otrasPatologiasBean.tipoIden} #{otrasPatologiasBean.numIden}"/>
              <h:outputText value=""/>
              <h:outputLabel value="#{otrasPatologiasBean.nombUsuario}"/>
              <h:outputText value=""/>
              <h:outputLabel value="Servicio" for="chopccodiserv" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0">
                <h:selectOneMenu id="chopccodiserv" value="#{otrasPatologiasBean.servicioSelected}" immediate="true" valueChangeListener="#{otrasPatologiasBean.setServicioSelected}">
                  <f:selectItem itemLabel="Seleccione una opción..." itemValue=""/>
                  <f:selectItems value="#{otrasPatologiasBean.listServiciosFact}"/>
                  <a4j:support id="supportServ" action="#{otrasPatologiasBean.changeServicio}" event="onchange" immediate="true" reRender="tableContentTabs">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
                <h:outputText value=" "/>
                <h:outputLabel value=" #{otrasPatologiasBean.servicio}"/>
              </h:panelGrid>
              <t:message for="chopccodiserv" errorClass="errorMessage"/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputLabel value="Origen de la Pieza" for="chopcobspatol"/>
              <h:outputText value=" "/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:inputTextarea id="chopcobspatol" value="#{otrasPatologiasBean.chotraspatolog.chopcobspatol}" rows="4" cols="60"/>
              <t:message for="chopcobspatol" styleClass="errorMessage"/>
              <h:outputText value=""/>
              <h:outputText value=""/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonConsulta" columnClasses="columnaBotonesCentrados">
              <a4j:outputPanel id="ajaxRegionMessages" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                <t:htmlTag value="br"/>
              </a4j:outputPanel>
              <h:panelGroup>
                <a4j:commandButton value="Registar" action="#{otrasPatologiasBean.guardar}" reRender="tableContentTabs" styleClass="boton_fieldset" disabled="#{otrasPatologiasBean.registrado}"/>
                <a4j:commandButton value="Nueva Patologia" action="#{otrasPatologiasBean.inicializarBean}" reRender="tableContentTabs" styleClass="boton_fieldset"/>
              </h:panelGroup>
            </h:panelGrid>
          </s:fieldset>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form> 