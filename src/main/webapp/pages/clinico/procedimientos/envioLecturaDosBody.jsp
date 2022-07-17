<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formEntCitolDos">
  <a4j:region id="regionEntCitolDos" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionEntCitolDos">
      <f:facet name="start">
        <t:div id="chargingEntCitolDos" styleClass="loading">
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
          <h:outputText value="HISTORIAS CLINICAS >> Citologias >> Envio de Citologias Segunda Lectura" id="infoUbication"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEntCitolDosTab" styleClass="tabContainer">
          <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneEntCitolDos" styleClass="tabbedPane"
                             activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                             tabContentStyleClass="tabContent">
            <t:panelTab id="panelTabEntCitolDos" label="Lista Entrega de Citologias">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEntCitolDos">
                <s:fieldset legend="Datos Busqueda " id="fieldResulCitol" styleClass="fieldset">
                  <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosResulCitol" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="No. Listado " styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <h:outputText value="Fecha de Envio " styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <h:inputText id="itListadoLectura1" required="true" maxlength="30" value="#{repCitologiaLecturaDosBean.idListado}"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itListadoLectura1" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <t:inputCalendar id="fechaEntregaCitol" title="Formato: dd/mm/yyyy" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                     popupDateFormat="dd/MM/yyyy" renderAsPopup="true" value="#{repCitologiaLecturaDosBean.fechaEnvio}" popupTodayString="Hoy" popupWeekString="Semana"
                                     popupButtonString="Fecha" readonly="false" maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                                     align="top" required="true"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaEntregaCitol" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGrid>
                </s:fieldset>
                <h:panelGroup>
                  <a4j:outputPanel id="ajaxRegionMensajesEntCitolDos" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInfEntCitolDos" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                                warnClass="advertencia"/>
                    <t:htmlTag value="br"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesEntCitolDos" columnClasses="panelGridBotones">
                  <a4j:commandButton value="Generar Lista de Entrega" styleClass="boton_fieldset" reRender="panelGridEntCitolDosTab" action="#{repCitologiaLecturaDosBean.generarListaEntrega}"/>
                </h:panelGrid>
                <f:subview id="generarReporte" rendered="#{repCitologiaLecturaDosBean.generoReporte}">
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