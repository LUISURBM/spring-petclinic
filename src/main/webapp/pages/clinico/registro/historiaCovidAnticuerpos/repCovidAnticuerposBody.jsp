<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<%@ page import="org.profamilia.hc.view.servlet.CsvServlet"%>
<a4j:form id="formReporteLogImpresion">
  <a4j:region id="regionReporteLogImpresion" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionReporteLogImpresion">
      <f:facet name="start">
        <t:div id="chargingRepoLogImpresion" styleClass="loading">
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
          <h:outputText value="HISTORIAS CLINICAS >> Reportes >> Reporte Anticuerpos Covid-19 "
                        id="infoUbication"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridRepoLogTab"
                     styleClass="tabContainer">
          <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                             activePanelTabVar="true" width="100%" id="panelTabbedPaneReportLogImpresion"
                             styleClass="tabbedPane" activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                             disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" selectedIndex="#{repCovidAnticureposBean.selectedIndex}"
                             inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
            <t:panelTab id="panelTabReporLogImpresion" label="Reporte Pruebas Anticuerpos de Covid-19"  rendered="#{!repCovidAnticureposBean.renderBuscador}">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelGridReporLogImpresion">
                <s:fieldset legend="Datos Busqueda" id="fieldReportLogImpresion" styleClass="fieldset">
                  <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                               id="panelDatosReporteLogImpresion" rowClasses="labelText,labelTextInfo">
                     <h:outputText value="N�mero Usuario:"  />
                     <h:outputText value=" "/>
                    <h:outputText value=" "/>
                    <h:outputText value=" "/>
                    <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" columnClasses="labelTextInfo">
                      <a4j:commandLink action="#{repCovidAnticureposBean.mostrarBuscadorUsuarios}" immediate="true"
                                       reRender="panelGridRepoLogTab">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                      </a4j:commandLink>
                      <h:inputText id="idUsuario" maxlength="15" style="width:80px" immediate="true"
                                   value="#{repCovidAnticureposBean.numeroUsuario}"
                                   valueChangeListener="#{repCovidAnticureposBean.setNumeroUsuario}"
                                   binding="#{repCovidAnticureposBean.itNumeroUsuario}"
                                   onkeydown="return blockEnter(event);">
                        <a4j:support id="supportUsuarioNumero" event="onchange" ignoreDupResponses="true"
                                     action="#{consultarFoliosBean.changeUsuario}"
                                     reRender="panelDatosReporteLogImpresion">
                          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                      </h:inputText>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="idUsuario" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGrid>
                    <h:outputText value=" "/>
                    <h:outputText value=" "/>
                    <h:outputText value=" "/>
                    <h:outputText value="Fecha Inicial " styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <h:outputText value="Fecha Final " styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <t:inputCalendar id="fechaInicial" title="Formato: dd/mm/yyyy" monthYearRowClass="yearMonthHeader"
                                     weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                     popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                     value="#{repCovidAnticureposBean.fechaInicial}" popupTodayString="Hoy"
                                     popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                     size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                     renderPopupButtonAsImage="true" align="top" required="true"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaInicial" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <t:inputCalendar id="fechaFinal" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                     currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                     renderAsPopup="true" value="#{repCovidAnticureposBean.fechaFinal}"
                                     popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                     readonly="false" maxlength="11" size="11"
                                     popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                     renderPopupButtonAsImage="true" align="top" required="true"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaFinal" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:outputText value="Lista Clinicas " styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <h:outputText value=" "/>
                    <h:outputText value=" "/>
                    <h:panelGroup>
                      <h:selectOneMenu id="listaClinicas" value="#{repCovidAnticureposBean.clinicaSelect}"
                                       required="true" disabled="#{repCovidAnticureposBean.disableClinicas}">
                        <f:selectItems value="#{repCovidAnticureposBean.listaClinicas}"/>
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
                             id="panelBotonBotonesRepoLogImpresion" columnClasses="panelGridBotones"> 
  
                  <a4j:commandButton value="Generar Reporte" styleClass="btn btn btn-success"
                                     reRender="panelGridRepoLogTab,panelBotonBotonesRepoLogImpresion" 
                                     action="#{repCovidAnticureposBean.consultarRegistros}"/>
                  <t:htmlTag value="br"/>
                  <a4j:commandButton value="Generar Archivo CSV" styleClass="btn btn btn-success"
                                     reRender="panelGridRepoLogTab,panelBotonBotonesRepoLogImpresion"  
                                     rendered="#{repCovidAnticureposBean.existeInformacion}"
                                     action="#{repCovidAnticureposBean.generarArchivoCsv}"/>
                </h:panelGrid>



                <f:subview id="generarReporte" rendered="#{repCovidAnticureposBean.generoReporte}">
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
            <t:panelTab id="panelBuscadorUsuarios" label="Buscar Usuarios"
                            rendered="#{repCovidAnticureposBean.renderBuscador}">
                    <a4j:region id="regionBuscadorUsuarios" renderRegionOnly="false">
                        <a4j:status for="regionBuscadorUsuarios">
                            <f:facet name="start">
                                <t:div id="chargingBuscadorUsuarios" styleClass="loading">
                                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                                        <h:outputText value="Procesando..."/>
                                        <h:outputText value="Por favor espere."/>
                                    </h:panelGrid>
                                </t:div>
                            </f:facet>
                            <f:facet name="stop"/>
                        </a4j:status>
                        <jsp:include page="/pages/clinico/comunes/buscador/buscadorUsuarios.jsp" flush="true"/>
                        <h:panelGrid id="panelGridBuscarUsuariosBotones" width="100%"
                                     columnClasses="columnaBotonesCentrados" dir="RTL">
                            <t:htmlTag value="br"/>
                            <h:panelGroup id="panelGroupBuscarUsuariosBotones1">
                                <h:commandButton value="Aceptar Usuario" styleClass="btn btn btn-success"
                                                 action="#{repCovidAnticureposBean.aceptarUsuario}"></h:commandButton>
                            </h:panelGroup>
                        </h:panelGrid>
                    </a4j:region>
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
