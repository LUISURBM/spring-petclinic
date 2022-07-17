<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="ReporteDatosRipsForm">
  <a4j:region id="bodyRegionReporteDatosRips">
    <a4j:status id="statusButton" for="bodyRegionReporteDatosRips">
      <f:facet name="start">
        <t:div id="charginReporteDatosRips" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridReporteDatosRipsTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneReporteDatosRips" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabReporteDatosRips" label="Reporte Datos para Generar Rips ">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridReporteDatosRips">
            <s:fieldset legend="Datos Busqueda" id="fieldReporteDatosRips" styleClass="fieldset">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosReporteDatosRips" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Fecha Inicial " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value="Fecha Final " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <t:inputCalendar id="fechaInicialReporteDatosRips" title="Formato: dd/mm/yyyy"
                                 monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                 currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{reporteDatosRipsBean.fechaInicial}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaInicialReporteDatosRips" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <t:inputCalendar id="fechaFinalReporteDatosRips" monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{reporteDatosRipsBean.fechaFinal}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" 
                                 maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaFinalReporteDatosRips" styleClass="errorMessage"/>
                </a4j:outputPanel>
                
                <h:outputText value="Tipo Usuario" />
                <h:outputText value=""/>
                <h:outputText value="Servicio"/>
                <h:outputText value=""/>
                
                <h:selectOneMenu id = "mnuTipoUsuario" value = "#{reporteDatosRipsBean.tipoUsuarioSelect}">
                <f:selectItems value = "#{reporteDatosRipsBean.lstTipoUsuario}"/>
                </h:selectOneMenu>
                 <h:outputText value=""/>
                 <h:inputText id = "itServicio" value="#{reporteDatosRipsBean.codservicio}" maxlength="12"/>
                 <h:outputText value=""/>
                
                
              </h:panelGrid>
            </s:fieldset>
            
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionReporteDatosRips" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInfReporteDatosRips" showSummary="false" errorClass="error" globalOnly="true"
                            layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                            warnClass="advertencia"/>
                <t:htmlTag value="br"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
             <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonReporteDatosRips" columnClasses="panelGridBotones">
              <h:commandButton value="Generar Reporte" styleClass="boton_fieldset" 
                   action="#{reporteDatosRipsBean.generarReporte}"/>
                     <a4j:support event="onclick" status="statusButton"/>
            </h:panelGrid>
          </h:panelGrid>
        </t:panelTab>
        <h:commandLink action="home" immediate="true">
          <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif" align="Volver"/>
        </h:commandLink>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
      <f:subview id="generarReporteDatosRips" rendered="#{reporteDatosRipsBean.generoReporte}">
              <f:verbatim>
                <script type="text/javascript" language="JavaScript">
                        window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
                    </script>
              </f:verbatim>
            </f:subview>
</a4j:form>