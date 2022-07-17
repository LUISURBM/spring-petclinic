<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formEntregaCitol">
  <a4j:region id="regionEntregaCitol" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionEntregaCitol">
      <f:facet name="start">
        <t:div id="chargingEntregaCitol" styleClass="loading">
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
          <h:outputText value="HISTORIAS CLINICAS >> Patologias >> Seguimiento y Control para Entrega de Otras Patologias " id="infoUbication"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEntregaCitolTab" styleClass="tabContainer">
          <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneEntregaCitol" styleClass="tabbedPane"
                             activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                             tabContentStyleClass="tabContent">
            <t:panelTab id="panelTabEntregaCitol" label="Lista Envio de Patologias">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEntregaCitol">
                <s:fieldset legend="Datos Busqueda" id="fieldEntregaCitol" styleClass="fieldset">
                  <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosEntregaCitol" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Fecha Inicial " styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <h:outputText value="Fecha Final " styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <t:inputCalendar id="fechaInicialEntregaCitol" title="Formato: dd/mm/yyyy" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                     popupDateFormat="dd/MM/yyyy" renderAsPopup="true" value="#{envioOtrasPatologiasBean.fechaInicial}" popupTodayString="Hoy" popupWeekString="Semana"
                                     popupButtonString="Fecha" readonly="false" maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                                     align="top" required="true"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaInicialEntregaCitol" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <t:inputCalendar id="fechaFinalEntregaCitol" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                     renderAsPopup="true" value="#{envioOtrasPatologiasBean.fechaFinal}" popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha" readonly="false"
                                     maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true" align="top" required="true"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaFinalEntregaCitol" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:outputText value="Clinica Origen" styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <h:outputText value="Patologos" styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <h:selectOneMenu id="cltlncodtilla" value="#{envioOtrasPatologiasBean.idCentro}" required="true" immediate="true" valueChangeListener="#{envioOtrasPatologiasBean.setIdCentro}"
                                     disabled="true">
                      <f:selectItem itemLabel="Seleccione una opci�n..." itemValue=""/>
                      <f:selectItems value="#{envioOtrasPatologiasBean.listCentros}"/>
                      <a4j:support id="support1" action="#{envioOtrasPatologiasBean.changeCentros}" event="onchange" immediate="true" reRender="panelTabEntregaCitol">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="cltlncodtilla" errorClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:selectOneMenu id="idPatologos" value="#{envioOtrasPatologiasBean.idPatologos}" required="true">
                      <f:selectItems value="#{envioOtrasPatologiasBean.listPatologos}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="idPatologos" errorClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:outputText value="Fecha de Envio " styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <h:outputText value=" "/>
                    <h:outputText value=" "/>
                    <t:inputCalendar id="fechaEntregaCitol" title="Formato: dd/mm/yyyy" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                     popupDateFormat="dd/MM/yyyy" renderAsPopup="true" value="#{envioOtrasPatologiasBean.fechaEnvio}" popupTodayString="Hoy" popupWeekString="Semana"
                                     popupButtonString="Fecha" readonly="false" maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                                     align="top" required="true"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaEntregaCitol" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:outputText value=" "/>
                    <h:outputText value=" "/>
                  </h:panelGrid>
                </s:fieldset>
                <h:panelGroup>
                  <a4j:outputPanel id="ajaxRegionMensajesEntregaCitol" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInfEntregaCitol" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                                warnClass="advertencia"/>
                    <t:htmlTag value="br"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesEntregaCitol" columnClasses="panelGridBotones">
                  <a4j:commandButton value="Generar Lista de Entrega" styleClass="boton_fieldset" reRender="panelGridEntregaCitolTab" action="#{envioOtrasPatologiasBean.generarListaEntrega}"/>
                </h:panelGrid>
                <f:subview id="generarReporte" rendered="#{envioOtrasPatologiasBean.generoReporte}">
                  <f:verbatim>
                    <script type="text/javascript" language="JavaScript">
                        window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
                    </script>
                  </f:verbatim>
                </f:subview>
              </h:panelGrid>
            </t:panelTab>
          </t:panelTabbedPane>
        </h:panelGrid>
      </h:panelGroup>
    </h:panelGrid>
  
  </a4j:region>
</a4j:form>