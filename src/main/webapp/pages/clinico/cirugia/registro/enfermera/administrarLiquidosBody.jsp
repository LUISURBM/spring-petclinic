<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formAdministrarLiquidos">
  <a4j:region id="regionadministracionLiquidos" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionadministracionLiquidos">
      <f:facet name="start">
        <t:div id="chargingadministracionLiquidos" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid id="verHistoriaClinica" columns="1" border="0" cellpadding="0" cellspacing="0" width="100%">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentInfoLab"></h:panelGrid>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="panelGridadministracionLiquidosTab" styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneadministracionLiquidos" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabadministracionLiquidos" label="Administrar Liquidos">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="tableContentTabsadministracionLiquidos" styleClass="tabContainer">
            <s:fieldset legend="Datos Usuario" id="fieldSetInfoConsultarUsuarioLiquidos" styleClass="fieldset">
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelRegionInfoConsulta" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Tipo Identificación"/>
                <h:outputText value=" Numero Identificación"/>
                <h:outputText value="Número Usuario"/>
                <h:panelGroup>
                  <h:selectOneMenu id="tipoIde" required="true" disabled="true"
                                   value="#{administracionLiquidosBean.cirugia.hcplusuario.husetipoiden}">
                    <f:selectItems value="#{administracionLiquidosBean.listTipoIdentificacion}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="tipoIde" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="#{administracionLiquidosBean.cirugia.hcplusuario.husanumeiden}"/>
                <h:outputText id="itNumeroUsuario"
                              value="#{administracionLiquidosBean.cirugia.hcplusuario.huslnumero}"/>
                <t:htmlTag value="br"/>
              </h:panelGrid>
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosNombre"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Primer Nombre"/>
                <h:outputText value="Segundo Nombre"/>
                <h:outputText value="Primer Apellido"/>
                <h:outputText value="Segundo Apellido"/>
                <h:panelGroup>
                  <h:outputText value="#{administracionLiquidosBean.cirugia.hcplusuario.huscprimernomb}"/>
                </h:panelGroup>
                <h:outputText value="#{administracionLiquidosBean.cirugia.hcplusuario.huscsegundnomb}"/>
                <h:panelGroup>
                  <h:outputText id="primerApellido"
                                value="#{administracionLiquidosBean.cirugia.hcplusuario.huscprimerapel}"/>
                </h:panelGroup>
                <h:outputText value="#{administracionLiquidosBean.cirugia.hcplusuario.huscsegundapel}"/>
                <h:outputText value="Fecha Nacimiento"/>
                <h:outputText value="Edad"/>
                <h:outputText value="Sexo"/>
                <h:outputText value="Estado Civil"/>
                <h:panelGroup>
                  <h:outputText value="#{administracionLiquidosBean.cirugia.hcplusuario.husdfechanacim}"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value=""/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="radioSexo" disabled="true"
                                   value="#{administracionLiquidosBean.cirugia.hcplusuario.husesexo}">
                    <f:selectItems value="#{administracionLiquidosBean.listSexos}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="radioSexo" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="radioEstadoCivil" disabled="true"
                                   value="#{administracionLiquidosBean.cirugia.hcplusuario.huseestadcivil}">
                    <f:selectItems value="#{administracionLiquidosBean.listEstadoCivil}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="radioEstadoCivil" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Control Liquidos" id="fieldControlLiquidos" styleClass="fieldset">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelGridControlLiquidos" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Tipo de Liquido " styleClass="labelTextOblig"/>
                <h:outputText value="Cantidad (mililitros)" styleClass="labelTextOblig"/>
                <h:outputText value="Fecha Inicio Administracion " styleClass="labelTextOblig"/>
                <h:outputText value="Hora Inicio Administracion " styleClass="labelTextOblig"/>
                <h:outputText value="#{administracionLiquidosBean.liquidos.hclcdesctipoli}"/>
                <h:outputText value="#{administracionLiquidosBean.liquidos.hclncantidad}"/>
                <h:outputText value="#{administracionLiquidosBean.liquidos.hcldfechactivi}"/>
                <h:outputText value="#{administracionLiquidosBean.liquidos.hcldhoraactivi}"/>
              </h:panelGrid>
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelGridAdministrarSuspenderLiquidos" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Liquido" styleClass="labelTextOblig"/>
                <h:panelGroup id="panelTextCantidad">
                  <h:outputText value="Cantidad administrada (ml) " styleClass="labelTextOblig"
                                rendered="#{administracionLiquidosBean.esSuspencion}"/>
                </h:panelGroup>
                <h:outputText value=""/>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuLiquido" required="true" immediate="true"
                                      value="#{administracionLiquidosBean.opcionLiquido}"
                                      valueChangeListener="#{administracionLiquidosBean.setOpcionLiquido}"
                                      styleClass="labelRadio">
                      <f:selectItems value="#{administracionLiquidosBean.lstOpcionesLiquidos}"/>
                      <a4j:support id="supportmnuLiquido" event="onclick" immediate="true"
                                   action="#{administracionLiquidosBean.ChangeOpcionLiquido}"
                                   reRender="panelTextCantidad,panelInputCantidad">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuLiquido" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputCantidad">
                  <h:inputText id="itCantidadTotal" maxlength="4" style="width:50px"
                               rendered="#{administracionLiquidosBean.esSuspencion}" required="true"
                               value="#{administracionLiquidosBean.liquidos.hclncantisumin}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itCantidadTotal" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=""/>
              </h:panelGrid>
            </s:fieldset>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                         columnClasses="panelGridBotones">
              <t:htmlTag value="br"/>
              <h:panelGroup id="panelGroupCirugiaBotones1">
                <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                                 action="#{administracionLiquidosBean.AdministrarLiquidos}"></h:commandButton>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionadministracionLiquidosMsg" ajaxRendered="true">
                  <t:messages id="msgInformationadministracionLiquidosSSMsg" showSummary="true" errorClass="error"
                              globalOnly="true" layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>