<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<%@ page import="org.profamilia.hc.view.servlet.CsvServlet"%>
<a4j:form id="formReporteViniso">
  <a4j:region id="regionReporteViniso" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionReporteViniso">
      <f:facet name="start">
        <t:div id="chargingEtiqVphso" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="2" id="tableBodyGeneral" border="0" cellpadding="0" cellspacing="0" width="100%"
                 columnClasses="verticalaligntop,td_fondoBarraH">
      <h:panelGroup id="tableGroupContent">
        <h:panelGrid columns="1" id="tableInfoUbication" border="0" cellpadding="0" cellspacing="0" width="100%"
                     columnClasses="td_ubicador">
          <h:outputText value="HISTORIAS CLINICAS >> Consulta >> Consulta Etiqueta Vph "
                        id="infoUbication"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEtiqVphTab"
                     styleClass="tabContainer">
          <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                             activePanelTabVar="true" width="100%" id="panelTabbedPaneEtiquetaVph"
                             styleClass="tabbedPane" activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                             disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                             inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
            <t:panelTab id="panelTabReporViniso" label="Consulta Etiqueta Vph">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridReporVini">
                <s:fieldset legend="Datos Busqueda" id="fieldEtiquetaVph" styleClass="fieldset">
                  <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%"
                               id="panelDatosReporteViniso" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Fecha Inicial " styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <h:outputText value="Fecha Final " styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <h:outputText value="Lista Clinicas " styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <t:inputCalendar id="fechaInicia" title="Formato: dd/mm/yyyy" monthYearRowClass="yearMonthHeader"
                                     weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                     popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                     value="#{consultaEtiquetaVphBean.fecha}" popupTodayString="Hoy"
                                     popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                     size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                     renderPopupButtonAsImage="true" align="top" required="true"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaInicia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                     <t:inputCalendar id="fechaFin" title="Formato: dd/mm/yyyy" monthYearRowClass="yearMonthHeader"
                                     weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                     popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                     value="#{consultaEtiquetaVphBean.fecha2}" popupTodayString="Hoy"
                                     popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                     size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                     renderPopupButtonAsImage="true" align="top" required="true"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaFin" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:panelGroup>
                      <h:selectOneMenu id="listaClinicas" value="#{consultaEtiquetaVphBean.clinicaSelect}"
                                       required="true">
                        <f:selectItems value="#{consultaEtiquetaVphBean.listaClinicas}"/>
                      </h:selectOneMenu>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="listaClinicas" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </h:panelGrid>
                </s:fieldset>
                <h:panelGroup>
                  <a4j:outputPanel id="ajaxRegionMensajesEtiqVph" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInfEtiqVph" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                                warnClass="advertencia"/>
                    <t:htmlTag value="br"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelBotonBotonesEtiqVph" columnClasses="panelGridBotones">
                  <a4j:commandButton value="Generar Etiquetas" styleClass="btn btn btn-success"
                                     reRender="panelGridEtiqVphTab,panelBotonBotonesEtiqVph"
                                     action="#{consultaEtiquetaVphBean.generarReporteCodigoQR}"/>
                  <t:htmlTag value="br"/>
                </h:panelGrid>
                
                <f:subview id="generarStikers" rendered="#{consultaEtiquetaVphBean.generoReporte}">
                  <f:subview id="generarReporteContLiq" rendered="#{consultaEtiquetaVphBean.generoReporte}">
                    <f:verbatim>
                      <script type="text/javascript" language="JavaScript">
                    window.open("<%=request.getSession().getAttribute(XlsServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=1200,height=900");
                </script>
                    </f:verbatim>
                  </f:subview>
                </f:subview>
                
              </h:panelGrid>
            </t:panelTab>
          </t:panelTabbedPane>
        </h:panelGrid>
      </h:panelGroup>
    </h:panelGrid>
    <f:verbatim>
      <input id="pagina" type="hidden" name="pagina"/>
    </f:verbatim>
  </a4j:region>
</a4j:form>
