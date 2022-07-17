<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<a4j:form id="porcentajeManualForm">
  <a4j:region id="bodyRegionReportePorcentajeManual">
    <a4j:status for="bodyRegionReportePorcentajeManual">
      <f:facet name="start">
        <t:div id="chargindReportePorcentajeManual" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridReportePorcentajeManualTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneReportePorcentajeManual"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabReportePorcentajeManual" label="Reporte Porcentaje Sistema Nacional">
          <h:panelGrid id="panelDatosReportePorcentajeManual" columns="1" border="0"
                       cellpadding="0" cellspacing="0" width="100%"
                       styleClass="tabContainer">
            <s:fieldset legend="Reporte Porcentaje Sistema" id="fieldSetInfoReportePorcentajeManual"
                        styleClass="fieldset">
              <h:panelGrid columns="6" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelDatosGridReportePorcentajeManual"
                           rowClasses="labelText,labelTextInfo2">
                           
                            <h:outputText value="Clinica " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value="" />
                <h:outputText value=" "/>
                <h:outputText value="" />
                <h:outputText value=" "/>
                
                <h:selectOneMenu id ="mnuClinica" required="true"
                    value="#{reportePorcentajeSistemaNacionalBean.wcodclin}">
                <f:selectItems value = "#{reportePorcentajeSistemaNacionalBean.lstClinicas}"/>
                 </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuClinica" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="" />
                <h:outputText value=" "/>
                <h:outputText value="" />
                <h:outputText value=" "/>
                           
                <h:outputText value="Fecha Inicial " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value="Fecha Final " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
                <t:inputCalendar id="fechaInicialReporteOportunidad" title="Formato: dd/mm/yyyy"
                                 monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                 currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" 
                                 renderAsPopup="true"
                                 value="#{reportePorcentajeSistemaNacionalBean.fechaInicial}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaInicialReporteOportunidad" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <t:inputCalendar id="fechaFinalReporteOportunidad" monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{reportePorcentajeSistemaNacionalBean.fechaFinal}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaFinalReporteOportunidad" styleClass="errorMessage"/>
                </a4j:outputPanel>  
                <h:outputText value=" "/>
                <h:outputText value=" "/>
                
                <h:outputText value="Tipo Reporte"/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
                
                
                <h:selectOneRadio id="mnuTipoReporteManual" required="true"
                    value = "#{reportePorcentajeSistemaNacionalBean.tipoSelect}">
                <f:selectItems value = "#{reportePorcentajeSistemaNacionalBean.lstTipoReporte}"/>
                
                </h:selectOneRadio>
                
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuTipoReporteManual" styleClass="errorMessage"/>
                </a4j:outputPanel>  
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
             
              </h:panelGrid>
            </s:fieldset>
           </h:panelGrid>
       </t:panelTab>
      </t:panelTabbedPane>
      
        <f:subview id="generarReporte" rendered="#{reportePorcentajeSistemaNacionalBean.generoReporte}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript"> 
            function enviar(){
                window.location="<%=request.getSession().getAttribute(XlsServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>";
            }
            </script>
          <a href="javascript:enviar()"><img src="../../../../comun/imagenes/xls.png" height="100" width="100" alt="Descargue"><br/>Descargar Archivo</a>
        </f:verbatim>
      </f:subview>
      
       
      
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                   width="100%" id="panelBotonReportePorcentajeManual"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <a4j:commandButton value="Generar" styleClass="boton_fieldset" 
                           reRender="panelGridReportePorcentajeManualTab" 
                           action="#{reportePorcentajeSistemaNacionalBean.generarReporte}">
            <a4j:support event="onclick" status="statusButton"/>
          </a4j:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </h:panelGrid>
    <h:panelGrid>
      <h:panelGroup id="msgModificarReportePorcentajeManual">
        <a4j:outputPanel id="ajaxRegionMessagesReportePorcentajeManual" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsReportePorcentajeManual" showSummary="true"
                      errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
 
</a4j:form>