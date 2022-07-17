<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<a4j:form id="reporteResolucion256Form">
  <a4j:region id="bodyRegionreporteResolucion256">
    <a4j:status id="statusButton" for="bodyRegionreporteResolucion256">
      <f:facet name="start">
        <t:div id="charginreporteResolucion256" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridreporteResolucion256Tab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPanereporteResolucion256" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabreporteResolucion256" label="Reporte Resolucion 256">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridreporteResolucion256">
            <s:fieldset legend="Datos Busqueda" id="fieldreporteResolucion256" styleClass="fieldset">
            
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelDatosGridReporteResolucion256"
                           rowClasses="labelText,labelTextInfo2">
                           
                <h:outputText value="Clinica " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
               
                
                <h:selectOneMenu id ="mnuClinica" required="true"
                    value="#{reporteResolucion256Bean.wcodclin}">
                <f:selectItems value = "#{reporteResolucion256Bean.lstClinicas}"/>
                 </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuClinica" styleClass="errorMessage"/>
                </a4j:outputPanel>
               
              </h:panelGrid>           
            
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosreporteResolucion256" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Fecha Inicial " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value="Fecha Final " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <t:inputCalendar id="fechaInicialreporteResolucion256" title="Formato: dd/mm/yyyy"
                                 monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                 currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{reporteResolucion256Bean.fechaInicial}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaInicialreporteResolucion256" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <t:inputCalendar id="fechaFinalreporteResolucion256" monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{reporteResolucion256Bean.fechaFinal}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaFinalreporteResolucion256" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </s:fieldset>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionreporteResolucion256" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInfreporteResolucion256" showSummary="false" errorClass="error" globalOnly="true"
                            layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                            warnClass="advertencia"/>
                <t:htmlTag value="br"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
             <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonreporteResolucion256" columnClasses="panelGridBotones">
              <h:commandButton value="Generar Reporte" styleClass="boton_fieldset" 
                              action="#{reporteResolucion256Bean.generarReporte256}">
                <a4j:support event="onclick" status="statusButton"/>
              </h:commandButton>
            </h:panelGrid>
          </h:panelGrid>
        </t:panelTab>
        <h:commandLink action="#{reporteResolucion256Bean.volverInicio}" immediate="true">
          <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif" align="Volver"/>
        </h:commandLink>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
      <f:subview id="generarreporteResolucion256" rendered="#{reporteResolucion256Bean.generoReporte}">
                 <f:verbatim>
            <script type="text/javascript" language="JavaScript">
            function enviar(){
           window.location="<%=request.getSession().getAttribute(XlsServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>";
           }
        </script>
            <a href="javascript:enviar()">
              <img src="../../../../comun/imagenes/xls.png" height="100" width="100" alt="Descargue"></img>
              <br/>
              Descargar Archivo
            </a>
          </f:verbatim>
            </f:subview>
</a4j:form>