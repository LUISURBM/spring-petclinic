<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridFragmentacionEspermaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneFragmentacionEsperma" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabFragmentacionEsperma"
                label="TEST DE FRAGMENTACIÓN ESPERMÁTICA (POR DISPERSIÓN DE LA CROMATINA HALOSPERM)">
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionfragmentacionMsg" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationFragmentacionMsg" showSummary="false" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
          <t:htmlTag value="br"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="tableContentTabsFragmentacionEsperma" styleClass="tabContainer">
        <s:fieldset legend="Datos del examen" id="fieldAntecedentes" styleClass="fieldset">
          <h:panelGrid columns="1">
            <h:panelGrid columns="2">
              <h:outputText value="No. De examen: "/>
              <h:panelGroup>
                <h:inputText id="numex" value="#{testFragmentacionEspermaBean.chfragespe.cfelnumexam}" required="true"
                             maxlength="6" title="Solo numeros"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="numex" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Tipo de muestra: "/>
              <h:panelGroup>
                <h:inputTextarea id="tipom" value="#{testFragmentacionEspermaBean.chfragespe.cfectipomuest}"
                                 required="true" title="Maximo 30 caracteres">
                  <f:validateLength minimum="0" maximum="30"/>
                </h:inputTextarea>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="tipom" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Fecha de toma de la muestra: "/>
              <h:panelGroup id="panelTextDateMuestra">
                <t:inputCalendar id="calendarTomaMuestra" title="Formato: dd/mm/yyyy"
                                 onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader" required="true" currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{testFragmentacionEspermaBean.chfragespe.cfedfechtoma}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top"></t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="calendarTomaMuestra" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Fecha de informe: "/>
              <h:panelGroup id="panelTextDateInforme">
                <t:inputCalendar id="calendarInforme" title="Formato: dd/mm/yyyy" onkeydown="return blockEnter(event);"
                                 monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                 currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{testFragmentacionEspermaBean.chfragespe.cfedfechinfor}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="true"></t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="calendarInforme" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Médico remitente: "/>
              <h:panelGroup>
                <h:inputTextarea id="medi" value="#{testFragmentacionEspermaBean.chfragespe.cfecmediremi}"
                                 title="solo 100 caracteres">
                  <f:validateLength maximum="100"/>
                </h:inputTextarea>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="medi" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Resultado" id="fieldResultado" styleClass="fieldset">
          <h:panelGrid columns="1">
            <h:panelGroup>
              <h:panelGrid columns="2">
                <h:outputText value="Número de espermatozoides sin fragmentación: "/>
                <h:panelGroup>
                  <h:inputText id="sfrag" value="#{testFragmentacionEspermaBean.chfragespe.cfelnesinfrag}" maxlength="5"
                               title="Solo numeros enteros" required="true"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="sfrag" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Número de espermatozoides con fragmentación/degradación: "/>
                <h:panelGroup>
                  <h:inputText id="cfrag" value="#{testFragmentacionEspermaBean.chfragespe.cfelneconfrag}" maxlength="5"
                               title="Solo numeros enteros" required="true"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="cfrag" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="IDF"/>
                <h:panelGroup>
                  <h:inputText id="idf" value="#{testFragmentacionEspermaBean.chfragespe.cfenidf}" maxlength="4"
                               title="##.# dos enteros y un decimal" required="true"></h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="idf" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Observaciones" id="fieldObservaciones" styleClass="fieldset">
          <h:panelGrid columns="1">
            <h:panelGroup>
              <h:panelGrid columns="2">
                <h:outputText value="Se observa un porcentaje de: "/>
                <h:panelGroup>
                  <h:inputText id="porc" value="#{testFragmentacionEspermaBean.chfragespe.cfenporcentaje}" maxlength="4"
                               title="##.# dos enteros y un decimal" required="true"></h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="porc" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Por lo cual se considera: "/>
                <h:panelGroup>
                  <h:inputTextarea id="consid" value="#{testFragmentacionEspermaBean.chfragespe.cfecconsidera}"
                                   title="solo 30 caracteres" required="true">
                    <f:validateLength maximum="30"/>
                  </h:inputTextarea>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="consid" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Nombre Profesional: "/>
                <h:outputText value="#{testFragmentacionEspermaBean.usuarioSystem.curcnombre}"/>
                <h:outputText value="Registro Profesional: "/>
                <h:outputText value="#{testFragmentacionEspermaBean.usuarioSystem.curnprofes}"/>
              </h:panelGrid>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
      </h:panelGrid>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="panelBotonGuardarAntecedenteFragmentacionEsperma" columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar" styleClass="boton_fieldset" action="#{testFragmentacionEspermaBean.aceptar}">
            <a4j:support event="onclick" status="statusButton" reRender="panelTabFragmentacionEsperma"/>
          </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionfragmentacio2nMsg" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationFragmentacio2nMsg" showSummary="false" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
          <t:htmlTag value="br"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>