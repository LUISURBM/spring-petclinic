<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="actualizarPersonalForm">
  <a4j:region id="bodyRegionOportunidadEntrega">
    <a4j:status id="statusButton" for="bodyRegionOportunidadEntrega">
      <f:facet name="start">
        <t:div id="chargindOportunidadEntrega" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridOportunidadEntregaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneOportunidadEntrega"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabOportunidadEntrega" label="Oportunidad Entrega Citolog�as">
          <h:panelGrid id="panelDatosOportunidadEntrega" columns="1" border="0"
                       cellpadding="0" cellspacing="0" width="100%"
                       styleClass="tabContainer">
            <s:fieldset legend="Toma Citolog�a" id="fieldSetInfoOportunidadEntrega"
                        styleClass="fieldset">
              <h:panelGrid columns="4" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelDatosGridOportunidadEntrega"
                           rowClasses="labelText,labelTextInfo2">
                           
                <h:outputText value="Fecha Inicial " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value="Fecha Final " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <t:inputCalendar id="fechaInicialReporteOportunidad" title="Formato: dd/mm/yyyy"
                                 monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                 currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" 
                                 renderAsPopup="true"
                                 value="#{reporteOportunidadEntregaBean.fechaInicial}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaInicialReporteOportunidad" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <t:inputCalendar id="fechaFinalReporteOportunidad" monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{reporteOportunidadEntregaBean.fechaFinal}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaFinalReporteOportunidad" styleClass="errorMessage"/>
                </a4j:outputPanel>  
                
                <h:outputText value="Tipo Reporte"/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                
                
                <h:selectOneRadio id="mnuTipoReporte" required="true"
                    value = "#{reporteOportunidadEntregaBean.tipoSelect}">
                <f:selectItems value = "#{reporteOportunidadEntregaBean.lstTipoReporte}"/>
                
                </h:selectOneRadio>
                
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuTipoReporte" styleClass="errorMessage"/>
                </a4j:outputPanel>  
                <h:outputText value=""/>
                <h:outputText value=""/>
             
              </h:panelGrid>
            </s:fieldset>
           </h:panelGrid>
       </t:panelTab>
      </t:panelTabbedPane>
      
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                   width="100%" id="panelBotonOportunidadEntrega"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Generar" styleClass="boton_fieldset"
                           action="#{reporteOportunidadEntregaBean.aceptar}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </h:panelGrid>
    <h:panelGrid>
      <h:panelGroup id="msgModificarOportunidadEntrega">
        <a4j:outputPanel id="ajaxRegionMessagesOportunidadEntrega" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsOportunidadEntrega" showSummary="true"
                      errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
  
   <f:subview id="generarReporteOportunidadEntrega" rendered="#{reporteOportunidadEntregaBean.generoReporte}">
              <f:verbatim>
                <script type="text/javascript" language="JavaScript">
                        window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
                    </script>
              </f:verbatim>
            </f:subview>
</a4j:form>