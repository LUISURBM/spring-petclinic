<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formResulCitol">
  <a4j:region id="regionResulCitol" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionResulCitol">
      <f:facet name="start">
        <t:div id="chargingResulCitol" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="2" id="tableBodyGeneral" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
      <h:panelGroup id="tableGroupContent">
        <h:panelGrid columns="1" id="tableInfoUbication" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="td_ubicador">
          <h:outputText value="HISTORIAS CLINICAS >> Patologias >> Confirmación Patologias " id="infoUbication"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridResulCitolTab" styleClass="tabContainer">
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMensajesResulCitol" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInfResulCitol" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                          warnClass="advertencia"/>
              <t:htmlTag value="br"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneResulCitol" styleClass="tabbedPane"
                             activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                             tabContentStyleClass="tabContent">
            <t:panelTab id="panelTabResulCitol_Imp" label="Registrar Confirmación de Otras Patologias">
              <a4j:region renderRegionOnly="false">
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridResulCitol_Imp">
                  <s:fieldset legend="Datos Busqueda " id="fieldResulCitol_Imp" styleClass="fieldset">
                    <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosResulCitol_Imp" rowClasses="labelText,labelTextInfo">
                      <h:outputText value="No. Listado " styleClass="labelTextOblig"/>
                      <h:outputText value=" "/>
                      <h:inputText id="itListadoLectura11" required="true" maxlength="30" value="#{resultadoPatologiaBean.idListado}"/>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itListadoLectura11" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGrid>
                  </s:fieldset>
                  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesResulCitol_Imp" columnClasses="panelGridBotones">
                    <a4j:commandButton value="Buscar Lista" styleClass="boton_fieldset" reRender="panelGridResulCitol_Imp" action="#{resultadoPatologiaBean.generarListadoPatologias}"/>
                  </h:panelGrid>
                  <s:fieldset legend="Resultados Consulta" id="fieldSetConsultar_mod" styleClass="fieldset_dataTable">
                    <h:panelGrid columns="1" id="panelGridConsultar1" rendered="#{empty resultadoPatologiaBean.listadoPatologias}">
                      <h:outputText value="#{msg.msg_sin_consultar}"/>
                    </h:panelGrid>
                    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsConsultar1" rendered="#{not empty resultadoPatologiaBean.listadoPatologias}"
                                 styleClass="tabContainer">
                      <h:dataTable var="item" border="0" cellpadding="0" cellspacing="2" binding="#{resultadoPatologiaBean.dtlistadoPatologias}" value="#{resultadoPatologiaBean.listadoPatologias}"
                                   styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtBucarUsuarios1">
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="# Patologia"/>
                          </f:facet>
                          <h:outputText value="#{item.comp_id.hepnpatologia}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Documento"/>
                          </f:facet>
                          <h:outputText value="#{item.chotraspatolog.chopntipodoc} #{item.chotraspatolog.chopnnumdoc}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Clinica Origen"/>
                          </f:facet>
                          <h:outputText value="#{item.chotraspatolog.chopnclinorig}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Etapa"/>
                          </f:facet>
                          <h:outputText value="#{item.descEtapa}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Resultado"/>
                          </f:facet>
                          <h:outputText value="#{item.descPatologia}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Confirmación"/>
                          </f:facet>
                          <h:selectOneMenu id="comboColumnasCon1" value="#{item.hepcrecibido}">
                            <f:selectItem itemLabel="Seleccionar ..." itemValue=""/>
                            <f:selectItem itemLabel="Recibido" itemValue="SR"/>
                            <f:selectItem itemLabel="No Recibido" itemValue="NR"/>
                          </h:selectOneMenu>
                          <a4j:outputPanel ajaxRendered="true">
                            <t:message for="comboColumnasCon1" styleClass="errorMessage"/>
                          </a4j:outputPanel>
                        </h:column>
                      </h:dataTable>
                      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonResulCitol_Imp" columnClasses="panelGridBotones">
                        <a4j:commandButton value="Guardar Resultados" styleClass="boton_fieldset" reRender="fieldSetConsultar_mod" action="#{resultadoPatologiaBean.guardarlistadoPatologias}"/>
                      </h:panelGrid>
                    </h:panelGrid>
                  </s:fieldset>
                </h:panelGrid>
              </a4j:region>
            </t:panelTab>
          </t:panelTabbedPane>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                          warnClass="advertencia"/>
              <t:htmlTag value="br"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>