

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
        <t:div id="chargingRepoViniso" styleClass="loading">
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
          <h:outputText value="HISTORIAS CLINICAS >> Cirugia >> Reporte Viniso "
                        id="infoUbication"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridRepoViniTab"
                     styleClass="tabContainer">
          <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                             activePanelTabVar="true" width="100%" id="panelTabbedPaneReportViniso"
                             styleClass="tabbedPane" activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                             disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                             inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
            <t:panelTab id="panelTabReporViniso" label="Reporte Viniso">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelGridReporVini">
                <s:fieldset legend="Datos Busqueda" id="fieldReportViniso" styleClass="fieldset">
                  <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                               id="panelDatosReporteViniso" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Fecha Inicial " styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <h:outputText value="Fecha Final " styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <t:inputCalendar id="fechaInicial" title="Formato: dd/mm/yyyy" monthYearRowClass="yearMonthHeader"
                                     weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                     popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                     value="#{reporteVinisoBean.fechaInicial}" popupTodayString="Hoy"
                                     popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                     size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                     renderPopupButtonAsImage="true" align="top" required="true"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaInicial" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <t:inputCalendar id="fechaFinal" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                     currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                     renderAsPopup="true" value="#{reporteVinisoBean.fechaFinal}" popupTodayString="Hoy"
                                     popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                     size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                     renderPopupButtonAsImage="true" align="top" required="true"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaFinal" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:outputText value="Lista Clinicas " styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <h:outputText value=" "/>
                    <h:outputText value=" "/>
                    <h:panelGroup>
                      <h:selectOneMenu id="listaClinicas" value="#{reporteVinisoBean.clinicaSelect}" required="true" disabled="#{reporteVinisoBean.disableClinicas}">
                        <f:selectItems value="#{reporteVinisoBean.listaClinicas}"/>
                      </h:selectOneMenu>
                       <a4j:outputPanel ajaxRendered="true">
                    <t:message for="listaClinicas" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                    </h:panelGroup>
                    <h:outputText value=" "/>
                    <h:outputText value=" "/>
                  </h:panelGrid>
                </s:fieldset>
                <h:panelGroup>
                  <a4j:outputPanel id="ajaxRegionMensajesRepoVini" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInfRepoVini" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                                warnClass="advertencia"/>
                    <t:htmlTag value="br"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelBotonBotonesRepoVini" columnClasses="panelGridBotones"> 
                             
                             
                   
                  <a4j:commandButton value="Generar Reporte" styleClass="btn btn btn-success"
                                     reRender="panelGridRepoViniTab,panelBotonBotonesRepoVini" 
                                     action="#{reporteVinisoBean.consultarRegistros}"/>
                  <t:htmlTag value="br"/>
                  <a4j:commandButton value="Generar Archivo CSV" styleClass="btn btn btn-success"
                                     reRender="panelGridRepoViniTab,panelBotonBotonesRepoVini"  
                                     rendered="#{reporteVinisoBean.existeInformacion}"
                                     action="#{reporteVinisoBean.generarArchivoCsv}"/>
                </h:panelGrid>



                <f:subview id="generarReporte" rendered="#{reporteVinisoBean.generoReporte}">
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
