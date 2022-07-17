<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="ReporteAsesoriaIlveForm">
  <a4j:region id="bodyRegionReporteAsesoriaIlve">
    <a4j:status id="statusButton" for="bodyRegionReporteAsesoriaIlve">
      <f:facet name="start">
        <t:div id="charginAsesoriaIlve" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAsesoriaIlveTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneReporteAsesoriaIlve" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabReporteAsesoriaIlve" label="Reporte Mis Asesorias IVE">
          <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionAsesoriaIlve" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInfAsesoriaIlve" showSummary="false" errorClass="error" globalOnly="true"
                            layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                            warnClass="advertencia"/>
                <t:htmlTag value="br"/>
              </a4j:outputPanel>
            </h:panelGroup>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridReporteAsesoriaIlve">
            <s:fieldset legend="Datos Busqueda" id="fieldReporteAsesoriaIlve" styleClass="fieldset">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosReporteAsesoriaIlve" rowClasses="labelText,labelTextInfo">
                           
                <h:outputText value="Clinica " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value="" />
                <h:outputText value=" "/>
                
                <h:selectOneMenu id ="mnuClinica" required="true" disabled = "true"
                    value="#{reporteMisAsesoriasIlveBean.wcodclin}">
                <f:selectItems value = "#{reporteMisAsesoriasIlveBean.lstClinicas}"/>
                 </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuClinica" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="" />
                <h:outputText value=" "/>
                           
                <h:outputText value="Fecha Inicial " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value="Fecha Final " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <t:inputCalendar id="fechaInicialReporteAsesoriaIlve" title="Formato: dd/mm/yyyy"
                                 monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                 currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{reporteMisAsesoriasIlveBean.fechaInicial}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaInicialReporteAsesoriaIlve" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <t:inputCalendar id="fechaFinalReporteAsesoriaIlve" monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{reporteMisAsesoriasIlveBean.fechaFinal}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaFinalReporteAsesoriaIlve" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </s:fieldset>
            
  
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionReporteAsesoriaIlve" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInfReporteAsesoriaIlve" showSummary="false" errorClass="error" globalOnly="true"
                            layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                            warnClass="advertencia"/>
                <t:htmlTag value="br"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
             <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
             id="panelBotonReporteAsesoriaIlve" columnClasses="panelGridBotones">
              <a4j:commandButton value="Generar Reporte" styleClass="boton_fieldset" 
              reRender="panelGridAsesoriaIlveTab"
                   action="#{reporteMisAsesoriasIlveBean.generarAsesoriaIlve}">
                     <a4j:support event="onclick" status="statusButton"/>
                   </a4j:commandButton>
            </h:panelGrid>
          </h:panelGrid>
        </t:panelTab>
        <h:commandLink action="#{reporteMisAsesoriasIlveBean.volverInicio}" immediate="true">
          <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif" align="Volver"/>
        </h:commandLink>
      </t:panelTabbedPane>
      
       <f:subview id="generarReporte" >
            <h:panelGrid id = "panelGridGenerarHistoriaPDF" rendered="#{reporteMisAsesoriasIlveBean.generoReporte}">
      
      <f:verbatim>
        <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
      </f:verbatim>
          </h:panelGrid>
    </f:subview>
      
       
    </h:panelGrid>
  </a4j:region>
  
</a4j:form>