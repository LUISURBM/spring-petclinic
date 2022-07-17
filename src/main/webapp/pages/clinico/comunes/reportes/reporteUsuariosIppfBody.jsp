<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<a4j:form id="reporteUsuariosIppfForm">
  <a4j:region id="bodyRegionReporteUsuariosIppf">
    <a4j:status for="bodyRegionReporteUsuariosIppf">
      <f:facet name="start">
        <t:div id="chargindReporteUsuariosIppf" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridReporteUsuariosIppf"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneReporteUsuariosIppf"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabReporteUsuariosIppf" label="Reporte Usuarios IPPF">
          <h:panelGrid id="panelDatosReporteUsuariosIppf" columns="1" border="0"
                       cellpadding="0" cellspacing="0" width="100%"
                       styleClass="tabContainer">
            <s:fieldset legend="Reporte Usuarios IPPF" id="fieldSetInfoReporteUsuariosIppf"
                        styleClass="fieldset">
              <h:panelGrid columns="6" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelDatosGridReporteUsuariosIppf"
                           rowClasses="labelText,labelTextInfo2">
                           
                <h:outputText value="Fecha Inicial " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value="Fecha Final " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value="Periodo"/>
                <h:outputText value=" "/>
                <t:inputCalendar id="fechaInicialReporteUsuariosIppf" title="Formato: dd/mm/yyyy"
                                 monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                 currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" 
                                 renderAsPopup="true"
                                 value="#{reporteUsuariosIPPFBean.fechaInicial}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaInicialReporteUsuariosIppf" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <t:inputCalendar id="fechaFinalReporteUsuariosIppf" monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{reporteUsuariosIPPFBean.fechaFinal}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaFinalReporteUsuariosIppf" styleClass="errorMessage"/>
                </a4j:outputPanel>  
                <h:selectOneRadio id="radioPeriodo" value="#{reporteUsuariosIPPFBean.periodo}" immediate="true">
                    <f:selectItem itemValue="M" itemLabel="Mensual"/>
                    <f:selectItem itemValue="A" itemLabel="Anual"/>
                </h:selectOneRadio>

              </h:panelGrid>
            </s:fieldset>
           </h:panelGrid>
       </t:panelTab>
      </t:panelTabbedPane>
      
    
      
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                   width="100%" id="panelBotonReporteUsuariosIppf"
                   columnClasses="panelGridBotones">
                <h:outputText value=" "/>
          <h:commandButton value="Generar Detallado" styleClass="btn btn btn-success" disabled="#{reporteUsuariosIPPFBean.generoDetallado}"
                                              action="#{reporteUsuariosIPPFBean.generarReporteDet}">
          </h:commandButton>
                <h:outputText value=" "/>
          <h:commandButton value="Generar IPPF" styleClass="btn btn btn-success" disabled="#{!reporteUsuariosIPPFBean.generoDetallado}"
                                              action="#{reporteUsuariosIPPFBean.generarReporte}">
          </h:commandButton>
      </h:panelGrid>
    </h:panelGrid>
    <h:panelGrid>
      <h:panelGroup id="msgModificarReporteUsuariosIppf">
        <a4j:outputPanel id="ajaxRegionMessagesReporteUsuariosIppf" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsReporteUsuariosIppf" showSummary="true"
                      errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
  
   <f:subview id="generarReporteRadicacion" rendered="#{reporteUsuariosIPPFBean.generoReporte}">
                 <f:verbatim>
            <script type="text/javascript" language="JavaScript">
            function enviar(){
           window.location="<%=request.getSession().getAttribute(XlsServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>";
           }
        </script>
            <a href="javascript:enviar()">
              <img src="../../../../comun/imagenes/csv.png" height="100" width="100" alt="Descargue"></img>
              <br/>
            <h:outputText value="#{reporteUsuariosIPPFBean.nombSalida}"/>
            </a>
          </f:verbatim>
            </f:subview>
 
</a4j:form>