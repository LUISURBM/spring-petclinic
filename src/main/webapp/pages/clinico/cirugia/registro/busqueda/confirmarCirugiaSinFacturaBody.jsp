<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formConfirmarCirugia">
  <a4j:region id="regionConfirmarCirugia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionConfirmarCirugia">
      <f:facet name="start">
        <t:div id="chargingConfirmarCirugia" styleClass="loading">
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
      <h:outputText value="Confirmar Cirugia sin Factura " id="infoUbication" style="float:center"/>
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
                             value="#{confirmarCirugiaSinFacturaBean.usuario.husetipoiden}">
              <f:selectItems value="#{confirmarCirugiaSinFacturaBean.listTipoIdentificacion}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="tipoIde" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="#{confirmarCirugiaSinFacturaBean.usuario.husanumeiden}"/>
          <h:outputText id="itNumeroUsuario" value="#{confirmarCirugiaSinFacturaBean.usuario.huslnumero}"/>
          <t:htmlTag value="br"/>
        </h:panelGrid>
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosNombre"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Primer Nombre"/>
          <h:outputText value="Segundo Nombre"/>
          <h:outputText value="Primer Apellido"/>
          <h:outputText value="Segundo Apellido"/>
          <h:panelGroup>
            <h:outputText value="#{confirmarCirugiaSinFacturaBean.usuario.huscprimernomb}"/>
          </h:panelGroup>
          <h:outputText value="#{confirmarCirugiaSinFacturaBean.usuario.huscsegundnomb}"/>
          <h:panelGroup>
            <h:outputText id="primerApellido" value="#{confirmarCirugiaSinFacturaBean.usuario.huscprimerapel}"/>
          </h:panelGroup>
          <h:outputText value="#{confirmarCirugiaSinFacturaBean.usuario.huscsegundapel}"/>
          <h:outputText value="Fecha Nacimiento"/>
          <h:outputText value="Edad"/>
          <h:outputText value="Sexo"/>
          <h:outputText value="Estado Civil"/>
          <h:panelGroup>
            <h:outputText value="#{confirmarCirugiaSinFacturaBean.usuario.husdfechanacim}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="#{confirmarCirugiaSinFacturaBean.edad}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneMenu id="radioSexo" disabled="true" value="#{confirmarCirugiaSinFacturaBean.usuario.husesexo}">
              <f:selectItems value="#{confirmarCirugiaSinFacturaBean.listSexos}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioSexo" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneMenu id="radioEstadoCivil" disabled="true"
                             value="#{confirmarCirugiaSinFacturaBean.usuario.huseestadcivil}">
              <f:selectItems value="#{confirmarCirugiaSinFacturaBean.listEstadoCivil}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioEstadoCivil" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridRegistrarCirugiaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneProgramarCirugia"
                         selectedIndex="#{confirmarCirugiaSinFacturaBean.selectedIndex}" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabconfirmarCirugia" label="Confirmación de Cirugia Sin Factura">
          <s:fieldset legend="Confirmar Cirugia Sin Factura" id="fieldRegistroCirugia" styleClass="fieldset">
            <h:panelGroup id="panelConfirmarCirugias">
              <a4j:region renderRegionOnly="false">
                <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                             rowClasses="labelText,labelTextInfo" id="tableRegistroCirugia">
                  <h:outputText value="No. Registro"/>
                  <h:outputText value="Consulta Inicial"/>
                  <h:outputText value="No. Factura" styleClass="labelTextOblig"/>
                  <h:outputText value="#{confirmarCirugiaSinFacturaBean.regcirpro.hrcnnumero}"/>
                  <h:outputText value="#{confirmarCirugiaSinFacturaBean.regcirpro.hrcnconini}"/>
                  <h:panelGrid columns="2">
                    <h:panelGroup>
                      <h:inputText id="numeroFactura" onkeydown="return blockEnter(event);" maxlength="10"
                                   value="#{confirmarCirugiaSinFacturaBean.regcirpro.hrcnnumfac}"></h:inputText>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="numeroFactura" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </h:panelGrid>
                  <h:outputText value="Clinica" styleClass="labelTextOblig"/>
                  <h:outputText value="Fecha Cirugia" styleClass="labelTextOblig"/>
                  <h:outputText value="Programa" styleClass="labelTextOblig"/>
                  <h:outputText value="#{confirmarCirugiaSinFacturaBean.clinica.cclncodigo} #{confirmarCirugiaSinFacturaBean.clinica.cclcnombre}"/>
                  <h:panelGrid columns="2">
                    <t:inputCalendar id="fechaCirugia" monthYearRowClass="yearMonthHeader" title="Formato: dd/mm/yyyy"
                                     weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                     popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                     value="#{confirmarCirugiaSinFacturaBean.regcirpro.hrcdfeccirpro}"
                                     popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                     readonly="false" maxlength="11" size="11"
                                     popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                     renderPopupButtonAsImage="true" disabled="true" align="top">
                      <f:validator validatorId="dateMayorIgualValidator"/>
                    </t:inputCalendar>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaCirugia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGrid>
                  <a4j:region renderRegionOnly="false">
                    <h:panelGrid columns="2">
                      <h:panelGroup>
                        <h:selectOneMenu id="mnuProgramas" required="true" disabled="true"
                                         value="#{confirmarCirugiaSinFacturaBean.regcirpro.hrcnprogra}">
                          <f:selectItems value="#{confirmarCirugiaSinFacturaBean.lstProgramas}"/>
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
                                         value="#{confirmarCirugiaSinFacturaBean.regcirpro.hrcndonant}">
                          <f:selectItems value="#{confirmarCirugiaSinFacturaBean.lstDonantes}"/>
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
                                         value="#{confirmarCirugiaSinFacturaBean.regcirpro.hrcntipusu}">
                          <f:selectItems value="#{confirmarCirugiaSinFacturaBean.lstTipoUsuarios}"/>
                        </h:selectOneMenu>
                        <a4j:outputPanel ajaxRendered="true">
                          <t:message for="mnuTipoUsu" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                      </h:panelGroup>
                    </h:panelGrid>
                  </a4j:region>
                  <h:outputText value="#{confirmarCirugiaSinFacturaBean.regcirpro.hrccservic.csvccodigo} - #{confirmarCirugiaSinFacturaBean.servicio.csvcnombre}"/>
                  <h:panelGroup>
                    <h:commandButton value="Confirmar" styleClass="btn btn btn-success"
                                     action="#{confirmarCirugiaSinFacturaBean.confirmarCirugia}"/>
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