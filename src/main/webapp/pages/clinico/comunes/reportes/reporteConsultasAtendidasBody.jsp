<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="consultasAtendidasForm">
  <a4j:region id="bodyRegionReporteConsultasAtendidas">
    <a4j:status for="bodyRegionReporteConsultasAtendidas">
      <f:facet name="start">
        <t:div id="chargindReporteConsultasAtendidas" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridReporteConsultasAtendidasTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneReporteConsultasAtendidas"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabReporteConsultasAtendidas" label="Reporte Consultas Atendidas">
          <h:panelGrid id="panelDatosReporteConsultasAtendidas" columns="1" border="0"
                       cellpadding="0" cellspacing="0" width="100%"
                       styleClass="tabContainer">
            <s:fieldset legend="Reporte Mis Consultas Atendidas" id="fieldSetInfoReporteConsultasAtendidas"
                        styleClass="fieldset">
              <h:panelGrid columns="6" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelDatosGridReporteConsultasAtendidas"
                           rowClasses="labelText,labelTextInfo2">
                           
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
                                 value="#{reporteConsultasAtendidasBean.fechaInicial}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaInicialReporteOportunidad" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <t:inputCalendar id="fechaFinalReporteOportunidad" monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{reporteConsultasAtendidasBean.fechaFinal}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaFinalReporteOportunidad" styleClass="errorMessage"/>
                </a4j:outputPanel>  
                <h:outputText value=" "/>
                <h:outputText value=" "/>
                
                <h:outputText value="M�dico"/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=" "/>
                
                
                <h:selectOneMenu id = "mnuMedico" value="#{reporteConsultasAtendidasBean.wcodmed}"
                disabled="true">
                <f:selectItems value = "#{reporteConsultasAtendidasBean.listaProfesionalesClinica}"/>
                </h:selectOneMenu>
               <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuMedico" styleClass="errorMessage"/>
                </a4j:outputPanel>  
                <h:outputText value = ""/>
                <h:outputText value = ""/>  
                <h:outputText value = ""/>
                <h:outputText value = ""/>
                
                
                <h:outputText value="Tipo Reporte"/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
                
                
                <h:selectOneRadio id="mnuTipoReporteConsultas" required="true"
                    value = "#{reporteConsultasAtendidasBean.tipoSelect}">
                <f:selectItems value = "#{reporteConsultasAtendidasBean.lstTipoReporte}"/>
                
                </h:selectOneRadio>
                
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuTipoReporteConsultas" styleClass="errorMessage"/>
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
      
        <f:subview id="generarReporteConsultasAtendidas" 
            rendered="#{reporteConsultasAtendidasBean.generoReporte}">
              <f:verbatim>
                <script type="text/javascript" language="JavaScript">
                        window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
                    </script>
              </f:verbatim>
            </f:subview>
      
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                   width="100%" id="panelBotonReporteConsultasAtendidas"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <a4j:commandButton value="Generar" styleClass="boton_fieldset" 
                           reRender="panelGridReporteConsultasAtendidasTab" 
                           action="#{reporteConsultasAtendidasBean.generarReporte}">
            <a4j:support event="onclick" status="statusButton"/>
          </a4j:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </h:panelGrid>
    <h:panelGrid>
      <h:panelGroup id="msgModificarReporteConsultasAtendidas">
        <a4j:outputPanel id="ajaxRegionMessagesReporteConsultasAtendidas" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsReporteConsultasAtendidas" showSummary="true"
                      errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>