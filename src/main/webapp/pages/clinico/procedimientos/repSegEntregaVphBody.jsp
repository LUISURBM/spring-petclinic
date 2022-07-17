

<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<%@ page import="org.profamilia.hc.view.servlet.CsvServlet"%>
<a4j:form id="formEntregaVph">
  <a4j:region id="regionEntregaVph" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionEntregaVph">
      <f:facet name="start">
        <t:div id="chargingEntregaVph" styleClass="loading">
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
          <h:outputText value="HISTORIAS CLINICAS >> VPH >> Seguimiento Control para Entrega de VPH "
                        id="infoUbication"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEntregaVphTab"
                     styleClass="tabContainer">
          <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                             activePanelTabVar="true" width="100%" id="panelTabbedPaneEntregaVph"
                             styleClass="tabbedPane" activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                             disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                             inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
            <t:panelTab id="panelTabEntregaVph" label="Lista Entrega de VPH">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelGridEntregaVph">
                <s:fieldset legend="Datos Busqueda" id="fieldEntregaVph" styleClass="fieldset">
                  <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                               id="panelDatosEntregaVph" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Fecha Inicial " styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <h:outputText value="Fecha Final " styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <t:inputCalendar id="fechaInicialEntregaVph" title="Formato: dd/mm/yyyy"
                                     monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                     currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                     renderAsPopup="true" value="#{repSegVphsBean.fechaInicial}"
                                     popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                     readonly="false" maxlength="11" size="11"
                                     popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                     renderPopupButtonAsImage="true" align="top" required="true"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaInicialEntregaVph" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <t:inputCalendar id="fechaFinalEntregaVph" monthYearRowClass="yearMonthHeader"
                                     weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                     popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                     value="#{repSegVphsBean.fechaFinal}" popupTodayString="Hoy"
                                     popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                     size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                     renderPopupButtonAsImage="true" align="top" required="true"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaFinalEntregaVph" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:outputText value="Fecha de Envio " styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <h:outputText value=" "/>
                    <h:outputText value=" "/>
                    <t:inputCalendar id="fechaEntregaVph" title="Formato: dd/mm/yyyy"
                                     monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                     currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                     renderAsPopup="true" value="#{repSegVphsBean.fechaEnvio}"
                                     popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                     readonly="false" maxlength="11" size="11"
                                     popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                     renderPopupButtonAsImage="true" align="top" required="true"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaEntregaVph" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:outputText value=" "/>
                    <h:outputText value=" "/>
                  </h:panelGrid>
                  <h:panelGroup>
                    <a4j:outputPanel id="ajaxRegionMensajesEntregaVph" ajaxRendered="true">
                      <t:htmlTag value="br"/>
                      <t:messages id="msgInfEntregaVph" showSummary="false" errorClass="error" globalOnly="true"
                                  layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                                  warnClass="advertencia"/>
                      <t:htmlTag value="br"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </s:fieldset>
                <h:panelGroup>
                  <a4j:outputPanel id="ajaxRegionMensajesVphEntrega" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInfVphEntrega" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                                warnClass="advertencia"/>
                    <t:htmlTag value="br"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelBotonBotonesEntregaVph" columnClasses="panelGridBotones"> 
                             
                             
                   
                  <a4j:commandButton value="Generar Lista de Entrega" styleClass="btn btn btn-success"
                                     reRender="panelGridEntregaVphTab,panelBotonBotonesEntregaVph" disabled="#{repSegVphsBean.generarArch}" 
                                     action="#{repSegVphsBean.generarListaEntrega}"/>
                  <t:htmlTag value="br"/>
                  <a4j:commandButton value="Generar Archivo CSV" styleClass="btn btn btn-success"
                                     reRender="panelGridEntregaVphTab,panelBotonBotonesEntregaVph"  disabled="#{!repSegVphsBean.generarArch}"
                                     action="#{repSegVphsBean.generarArchivoCsv}"/>
                </h:panelGrid>



                <f:subview id="generarReporte" rendered="#{repSegVphsBean.generoReporte}">
                  <f:verbatim>
                    <script type="text/javascript" language="JavaScript"> 
                      function enviar(){
                        window.location="<%=request.getSession().getAttribute(CsvServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>";
                      }
                    </script>
                    <a href="javascript:enviar()">
                      <img src="../../../comun/imagenes/csv.png" height="95" width="95" alt="Descargue"></img>
                      <br/>
                      Descargar Archivo
                    </a>
                  </f:verbatim>
                </f:subview>
                <f:subview id="generarReporte_CE" rendered="#{repSegVphsBean.generoReporte_CE}">
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
    <f:verbatim>
      <input id="pagina" type="hidden" name="pagina"/>
    </f:verbatim>
  </a4j:region>
</a4j:form>
