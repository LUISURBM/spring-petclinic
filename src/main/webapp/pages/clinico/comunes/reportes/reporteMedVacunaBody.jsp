<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<a4j:form id="reporteMedVacForm">
  <a4j:region id="bodyRegionReporteMedVac">
    <a4j:status for="bodyRegionReporteMedVac">
      <f:facet name="start">
        <t:div id="chargindReporteMedVac" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridReporteMedVacTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneReporteMedVac"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabReporteMedVac"
                    label="Reporte Medicamentos y Vacunas">
          <h:panelGrid id="panelDatosReporteMedVac" columns="1"
                       border="0" cellpadding="0" cellspacing="0" width="100%"
                       styleClass="tabContainer">
            <s:fieldset legend="Reporte Medicamentos y Vacunas administrados"
                        id="fieldSetInfoReporteMedVac"
                        styleClass="fieldset">
              <h:panelGrid columns="6" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelDatosGridReporteMedVac"
                           rowClasses="labelText,labelTextInfo2">
                <h:outputText value="Fecha Inicial "
                              styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value="Fecha Final " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
                
                <t:inputCalendar id="fechaInicialReporte"
                                 title="Formato: dd/mm/yyyy"
                                 monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader"
                                 currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy"
                                 renderAsPopup="true"
                                 value="#{reporteMedicamentoVacunaBean.fechaInicial}"
                                 popupTodayString="Hoy" popupWeekString="Semana"
                                 popupButtonString="Fecha" readonly="false"
                                 maxlength="11" size="11"
                                 popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top"
                                 required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaInicialReporte"
                             styleClass="errorMessage"/>
                </a4j:outputPanel>
                <t:inputCalendar id="fechaFinalReporte"
                                 monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader"
                                 currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy"
                                 renderAsPopup="true"
                                 value="#{reporteMedicamentoVacunaBean.fechaFinal}"
                                 popupTodayString="Hoy" popupWeekString="Semana"
                                 popupButtonString="Fecha" readonly="false"
                                 maxlength="11" size="11"
                                 popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top"
                                 required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaFinalReporte"
                             styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
                
                
                <h:outputText value="Clinica " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
   
                <h:selectOneMenu id="mnuClinica" 
                                 required="true" immediate="true"
                                 value="#{reporteMedicamentoVacunaBean.wcodclin}"
                                 valueChangeListener="#{reporteMedicamentoVacunaBean.setWcodclin}"
                                 binding="#{reporteMedicamentoVacunaBean.mnuCodclin}">
                  <f:selectItems value="#{reporteMedicamentoVacunaBean.lstClinicas}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuClinica" styleClass="errorMessage"/>
                </a4j:outputPanel>
              
                <h:outputText value=" "/>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
                
                
              </h:panelGrid>
            </s:fieldset>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                   width="100%" id="panelBotonReporteMedVac"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Generar Reporte"
                           styleClass="btn btn btn-success"
                           action="#{reporteMedicamentoVacunaBean.generarReporte}"></h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </h:panelGrid>
    <h:panelGrid>
      <h:panelGroup id="msgModificarReporteMedVac">
        <a4j:outputPanel id="ajaxRegionMessagesReporteMedVac"
                         ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsReporteMedVac"
                      showSummary="true" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
  <f:subview id="generarReporteMedVac"
             rendered="#{reporteMedicamentoVacunaBean.generoReporte}">
    <f:verbatim>
      <script type="text/javascript" language="JavaScript">
            function enviar(){
           window.location="<%=request.getSession().getAttribute(XlsServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>";
           }
        </script>
      <a href="javascript:enviar()">
        <img src="../../../../comun/imagenes/xls.png" height="100" width="100"
             alt="Descargue"></img>
        <br/>
        Descargar Archivo
      </a>
    </f:verbatim>
  </f:subview>
</a4j:form>