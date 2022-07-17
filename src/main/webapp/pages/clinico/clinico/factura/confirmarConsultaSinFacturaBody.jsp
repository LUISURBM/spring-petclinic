<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formConfirmarConsulta">
  <a4j:region id="regionConfirmarConsulta" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionConfirmarConsulta">
      <f:facet name="start">
        <t:div id="chargingConfirmarConsulta" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableConsultarFolio" border="0" cellpadding="0" cellspacing="0" width="100%"
                 styleClass="td_ubicador">
      <h:outputText value="Confirmar Consulta sin Factura " id="infoUbication" style="float:center"/>
    </h:panelGrid>
     <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentConsultarFolios"
                 styleClass="tabContainer">
      <s:fieldset legend="Datos Usuario" id="fieldSetInfoConsultarUsuario" styleClass="fieldset">
        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoConsulta"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Tipo Identificación"/>
          <h:outputText value=" Numero Identificación"/>
          <h:outputText value="Número Usuario"/>
          <h:panelGroup>
            <h:selectOneMenu id="tipoIde" required="true" disabled="true"
                             value="#{confirmarConsultaSinFacturaBean.usuario.husetipoiden}">
              <f:selectItems value="#{confirmarConsultaSinFacturaBean.listTipoIdentificacion}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="tipoIde" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="#{confirmarConsultaSinFacturaBean.usuario.husanumeiden}"/>
          <h:outputText id="itNumeroUsuario" value="#{confirmarConsultaSinFacturaBean.usuario.huslnumero}"/>
          <t:htmlTag value="br"/>
        </h:panelGrid>
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosNombre"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Primer Nombre"/>
          <h:outputText value="Segundo Nombre"/>
          <h:outputText value="Primer Apellido"/>
          <h:outputText value="Segundo Apellido"/>
          <h:panelGroup>
            <h:outputText value="#{confirmarConsultaSinFacturaBean.usuario.huscprimernomb}"/>
          </h:panelGroup>
          <h:outputText value="#{confirmarConsultaSinFacturaBean.usuario.huscsegundnomb}"/>
          <h:panelGroup>
            <h:outputText id="primerApellido" value="#{confirmarConsultaSinFacturaBean.usuario.huscprimerapel}"/>
          </h:panelGroup>
          <h:outputText value="#{confirmarConsultaSinFacturaBean.usuario.huscsegundapel}"/>
          <h:outputText value="Fecha Nacimiento"/>
          <h:outputText value="Edad"/>
          <h:outputText value="Sexo"/>
          <h:outputText value="Estado Civil"/>
          <h:panelGroup>
            <h:outputText value="#{confirmarConsultaSinFacturaBean.usuario.husdfechanacim}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="#{confirmarConsultaSinFacturaBean.edad}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneMenu id="radioSexo" disabled="true" value="#{confirmarConsultaSinFacturaBean.usuario.husesexo}">
              <f:selectItems value="#{confirmarConsultaSinFacturaBean.listSexos}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioSexo" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneMenu id="radioEstadoCivil" disabled="true"
                             value="#{confirmarConsultaSinFacturaBean.usuario.huseestadcivil}">
              <f:selectItems value="#{confirmarConsultaSinFacturaBean.listEstadoCivil}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioEstadoCivil" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridRegistrarConsultaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneProgramarConsulta"
                         selectedIndex="#{confirmarConsultaSinFacturaBean.selectedIndex}" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabconfirmarConsulta" label="Confirmación de Consulta Sin Factura">
          <s:fieldset legend="Confirmar Consulta Sin Factura" id="fieldRegistroConsulta" styleClass="fieldset">
            <h:panelGroup id="panelConfirmarConsultas">
              <a4j:region renderRegionOnly="false">
                <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                             rowClasses="labelText,labelTextInfo" id="tableRegistroConsulta">
                  <h:outputText value="No. Registro"/>
                  <h:outputText value="Consulta Inicial"/>
                  <h:outputText value="No. Factura" styleClass="labelTextOblig"/>
                  <h:outputText value="#{confirmarConsultaSinFacturaBean.regcirpro.hrcnnumero}"/>
                  <h:outputText value="#{confirmarConsultaSinFacturaBean.regcirpro.hrcnconini}"/>
                  <h:panelGrid columns="2">
                    <h:panelGroup>
                      <h:inputText id="numeroFactura" required="true"
                                onkeydown="return blockEnter(event);" maxlength="10"
                                   value="#{confirmarConsultaSinFacturaBean.regcirpro.hrcnnumfac}"></h:inputText>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="numeroFactura" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </h:panelGrid>
                  <h:outputText value="Clinica" styleClass="labelTextOblig"/>
                  <h:outputText value="Fecha Consulta" styleClass="labelTextOblig"/>
                  <h:outputText value="Programa" styleClass="labelTextOblig"/>
                  <h:outputText value="#{confirmarConsultaSinFacturaBean.clinica.cclncodigo} #{confirmarConsultaSinFacturaBean.clinica.cclcnombre}"/>
                  <h:panelGrid columns="2">
                    <t:inputCalendar id="fechaConsulta" monthYearRowClass="yearMonthHeader" title="Formato: dd/mm/yyyy"
                                     weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                     popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                     value="#{confirmarConsultaSinFacturaBean.regcirpro.hrcdfeccirpro}"
                                     popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                     readonly="false" maxlength="11" size="11"
                                     popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                     renderPopupButtonAsImage="true" disabled="true" align="top">
                      <f:validator validatorId="dateMayorIgualValidator"/>
                    </t:inputCalendar>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaConsulta" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGrid>
                  <a4j:region renderRegionOnly="false">
                    <h:panelGrid columns="2">
                      <h:panelGroup>
                        <h:selectOneMenu id="mnuProgramas" required="true" disabled="true"
                                         value="#{confirmarConsultaSinFacturaBean.regcirpro.hrcnprogra}">
                          <f:selectItems value="#{confirmarConsultaSinFacturaBean.lstProgramas}"/>
                        </h:selectOneMenu>
                        <a4j:outputPanel ajaxRendered="true">
                          <t:message for="mnuProgramas" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                      </h:panelGroup>
                    </h:panelGrid>
                  </a4j:region>
                  <h:outputText value="Donante" styleClass="labelTextOblig"/>
                  <h:outputText value="Tipo de Usuario" styleClass="labelTextOblig"/>
                  <h:outputText value="Servicio"/>
                  <a4j:region renderRegionOnly="false">
                    <h:panelGrid columns="2">
                      <h:panelGroup>
                        <h:selectOneMenu id="mnuDonantes" required="true" disabled="true"
                                         value="#{confirmarConsultaSinFacturaBean.regcirpro.hrcndonant}">
                          <f:selectItems value="#{confirmarConsultaSinFacturaBean.lstDonantes}"/>
                        </h:selectOneMenu>
                        <a4j:outputPanel ajaxRendered="true">
                          <t:message for="mnuDonantes" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                      </h:panelGroup>
                    </h:panelGrid>
                  </a4j:region>
                  <a4j:region renderRegionOnly="false">
                    <h:panelGrid columns="2">
                      <h:panelGroup>
                        <h:selectOneMenu id="mnuTipoUsu" required="true" disabled="true"
                                         value="#{confirmarConsultaSinFacturaBean.regcirpro.hrcntipusu}">
                          <f:selectItems value="#{confirmarConsultaSinFacturaBean.lstTipoUsuarios}"/>
                        </h:selectOneMenu>
                        <a4j:outputPanel ajaxRendered="true">
                          <t:message for="mnuTipoUsu" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                      </h:panelGroup>
                    </h:panelGrid>
                  </a4j:region>
                  <h:outputText value="#{confirmarConsultaSinFacturaBean.regcirpro.hrccservic.csvccodigo} - #{confirmarConsultaSinFacturaBean.servicio.csvcnombre}"/>
                  <h:panelGroup>
                    <h:commandButton value="Confirmar" styleClass="btn btn btn-success"
                                     action="#{confirmarConsultaSinFacturaBean.confirmarConsulta}"/>
                  </h:panelGroup>
                </h:panelGrid>
              </a4j:region>
            </h:panelGroup>
          </s:fieldset>
        </t:panelTab>
        <a4j:outputPanel id="ajaxRegionMessagesInferior" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsInferior" showSummary="false" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
          <t:htmlTag value="br"/>
        </a4j:outputPanel>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>