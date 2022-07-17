<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<%@ page import="org.profamilia.hc.view.servlet.CsvServlet"%>
<a4j:form id="formEntregaCitol">
  <a4j:region id="regionEntregaCitol" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionEntregaCitol">
      <f:facet name="start">
        <t:div id="chargingEntregaCitol" styleClass="loading">
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
          <h:outputText value="HISTORIAS CLINICAS >> Citologias >> Seguimiento Control para Entrega de Citologias "
                        id="infoUbication"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEntregaCitolTab"
                     styleClass="tabContainer">
          <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                             activePanelTabVar="true" width="100%" id="panelTabbedPaneEntregaCitol"
                             styleClass="tabbedPane" activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                             disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                             inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
            <t:panelTab id="panelTabEntregaCitol" label="#{repSegCitologiasBean.labelPantalla}">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelGridEntregaCitol">
                <s:fieldset legend="Datos Busqueda" id="fieldEntregaCitol" styleClass="fieldset">
                  <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                               id="panelDatosEntregaCitol" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Fecha Inicial " styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <h:outputText value="Fecha Final " styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <t:inputCalendar id="fechaInicialEntregaCitol" title="Formato: dd/mm/yyyy"
                                     monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                     currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                     renderAsPopup="true" value="#{repSegCitologiasBean.fechaInicial}"
                                     popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                     readonly="false" maxlength="11" size="11"
                                     popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                     renderPopupButtonAsImage="true" align="top" required="true"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaInicialEntregaCitol" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <t:inputCalendar id="fechaFinalEntregaCitol" monthYearRowClass="yearMonthHeader"
                                     weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                     popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                     value="#{repSegCitologiasBean.fechaFinal}" popupTodayString="Hoy"
                                     popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                     size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                     renderPopupButtonAsImage="true" align="top" required="true"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaFinalEntregaCitol" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:outputText value="Fecha de Envio " styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <h:outputText value=" "/>
                    <h:outputText value=" "/>
                    <t:inputCalendar id="fechaEntregaCitol" title="Formato: dd/mm/yyyy"
                                     monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                     currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                     renderAsPopup="true" value="#{repSegCitologiasBean.fechaEnvio}"
                                     popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                     readonly="false" maxlength="11" size="11"
                                     popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                     renderPopupButtonAsImage="true" align="top" required="true"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaEntregaCitol" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:outputText value=" "/>
                    <h:outputText value=" "/>
                  </h:panelGrid>
                  <h:panelGroup>
                    <a4j:outputPanel id="ajaxRegionMensajesEntregaCitol" ajaxRendered="true">
                      <t:htmlTag value="br"/>
                      <t:messages id="msgInfEntregaCitol" showSummary="false" errorClass="error" globalOnly="true"
                                  layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                                  warnClass="advertencia"/>
                      <t:htmlTag value="br"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </s:fieldset>
                <h:panelGroup>
                  <a4j:outputPanel id="ajaxRegionMensajesCitolEntrega" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInfCitolEntrega" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                                warnClass="advertencia"/>
                    <t:htmlTag value="br"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <a4j:commandButton value="Buscar" styleClass="btn btn btn-success"
                                     reRender="panelGridEntregaCitolTab,panelBotonBotonesEntregaCitol,fieldConsultasProceso,tableGroupContent"
                                     action="#{repSegCitologiasBean.listaCitologias}"/>
                </h:panelGroup>
                <s:fieldset legend="Resultados Consulta" id="fieldConsultasProceso" styleClass="fieldset"
                            rendered="#{not empty repSegCitologiasBean.listaObjecto}">
                  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                               id="tableContentTabsConsultasProceso" styleClass="tabContainer">
                                
                     <h:panelGrid columns="6" styleClass="labelText">
                        <h:outputText value="Seleccionar "/>
                        <h:outputText value="[ "/>
                        <a4j:commandLink action="#{repSegCitologiasBean.seleccionTodos}" value=" Todos" reRender="idtMisConsultas" />
                        <h:outputText value=" | "/>
                        <a4j:commandLink action="#{repSegCitologiasBean.seleccionNinguno}" value="Ninguno " reRender="idtMisConsultas"  />
                        <h:outputText value=" ]"/>
                      </h:panelGrid>
                    <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                                 binding="#{repSegCitologiasBean.dtLstCitologia}"
                                 value="#{repSegCitologiasBean.listaObjecto}" styleClass="standard_table"
                                 rowClasses="standardTable_Row3,standardTable_Row4" footerClass="paginacion" rows="20"
                                 id="idtMisConsultas">
                      <h:column>
                        <f:facet name="header">
                          <h:outputText value="Seleccionar"/>
                        </f:facet>
                        <h:panelGroup id="panelRegionEstablecioAcciones"  style="border-style:none;font-size:10px">
                          <a4j:region renderRegionOnly="false">
                            <h:selectBooleanCheckbox id="checkNingunaAccion" immediate="true"
                                                     onkeydown="return blockEnter(event);"
                                                     valueChangeListener="#{item.setSeleccionado}"
                                                     value="#{item.itemSelect}" disabled="#{repSegCitologiasBean.reporteGeneradoPDF}">
                              <a4j:support id="supportNingunaAccion" event="onclick"
                                           reRender="panelRegionEstablecioAcciones">
                                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                              </a4j:support>
                            </h:selectBooleanCheckbox>
                          </a4j:region>
                        </h:panelGroup>
                        <a4j:outputPanel ajaxRendered="true">
                          <t:message for="checkNingunaAccion" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                      </h:column>
                      <h:column>
                        <f:facet name="header">
                          <h:outputText value="Consulta"/>
                        </f:facet>
                        <h:outputText value="#{item.ccinconsec}"/>
                      </h:column>
                      <h:column>
                        <f:facet name="header">
                          <h:outputText value="Tipo Identificacion"/>
                        </f:facet>
                        <h:outputText value="#{item.ccictipide}"/>
                      </h:column>
                      <h:column>
                        <f:facet name="header">
                          <h:outputText value="Numero ID"/>
                        </f:facet>
                        <h:outputText value="#{item.ccianumide}"/>
                      </h:column>
                      <h:column>
                        <f:facet name="header">
                          <h:outputText value="Usuario"/>
                        </f:facet>
                        <h:outputText value="#{item.ccicprinom} #{item.ccicsegnom} #{item.ccicpriape} #{item.ccicsegape}"/>
                      </h:column>
                    </h:dataTable>
                     <t:htmlTag value="br"/>
                    <a4j:commandButton value="Agregar Lectura por Usuario" styleClass="btn btn btn-success"
                                       reRender="fieldConsultasCitolUsua,panelUsu,usuar"
                                       rendered="#{not empty repSegCitologiasBean.listaCitologias}"
                                       disabled="#{repSegCitologiasBean.reporteGeneradoPDF}"
                                       action="#{repSegCitologiasBean.buscarUsuario}"/>
                  </h:panelGrid>
                </s:fieldset>
            <h:panelGroup id="usuar">
                <s:fieldset legend="Listado Lectura Usuario" id="fieldConsultasCitolUsua" styleClass="fieldset" rendered="#{repSegCitologiasBean.renderUsu}" >
                <h:panelGrid  columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelUsu"  rendered="#{repSegCitologiasBean.renderUsu}">
                             
                    <h:outputText value="Tipo de Identificacion " styleClass="labelTextOblig"/>
                     <h:selectOneMenu id="tipoIde"
                                     value="#{repSegCitologiasBean.tipoId}"
                                     onkeydown="return blockEnter(event);">
                        <f:selectItems value="#{repSegCitologiasBean.listTipoIdentificacion}"/>
                    </h:selectOneMenu>
                    
                     <h:outputText value="Numero Identificacion " styleClass="labelTextOblig"/>
                      <h:inputText id = "itnumId" onkeydown="return blockEnter(event);" 
                        required="true"  value="#{repSegCitologiasBean.numeroId}"/>
      
                 </h:panelGrid>
                  <t:htmlTag value="br"/>
                  <a4j:commandButton value="Consultar Examen" styleClass="btn btn btn-success"
                                     reRender="panelGridEntregaCitolTab,tableContentTabsConsultasUsuario,usuarop"
                                     action="#{repSegCitologiasBean.listaCitologiasBusquedaUsuario}"/>
                                     
              <h:panelGroup id="usuarop">
               <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" rendered="#{repSegCitologiasBean.resultado}"
                               id="tableContentTabsConsultasUsuario" styleClass="tabContainer">
                                         
                    <h:dataTable var="itemu" border="0" cellpadding="0" cellspacing="0"
                                 binding="#{repSegCitologiasBean.dtLstCitologiaUsuario}"
                                 value="#{repSegCitologiasBean.listaObjectoUsuario}" styleClass="standard_table"
                                 rowClasses="standardTable_Row3,standardTable_Row4" footerClass="paginacion" rows="20"
                                 id="idtMisConsultasUsuario">
                      <h:column>
                        <f:facet name="header">
                          <h:outputText value="Seleccionar"/>
                        </f:facet>
                        <h:panelGroup style="border-style:none;font-size:10px">
                          <a4j:region renderRegionOnly="false">
                          
                            <a4j:commandButton id="checkNingunaAccionUsu" immediate="true" image="/comun/imagenes/fnd_boton_agregar.gif"
                            action="#{repSegCitologiasBean.adicionarCitolUsua}" reRender="panelGridEntregaCitolTab" >
                              
                            </a4j:commandButton>
                          </a4j:region>
                        </h:panelGroup>
                        <a4j:outputPanel ajaxRendered="true">
                          <t:message for="checkNingunaAccion" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                      </h:column>
                       <h:column>
                        <f:facet name="header">
                          <h:outputText value="Consulta"/>
                        </f:facet>
                        <h:outputText value="#{itemu.ccinconsec}"/>
                      </h:column>
                      <h:column>
                        <f:facet name="header">
                          <h:outputText value="Tipo Identificacion"/>
                        </f:facet>
                        <h:outputText value="#{itemu.ccictipide}"/>
                      </h:column>
                      <h:column>
                        <f:facet name="header">
                          <h:outputText value="Numero ID"/>
                        </f:facet>
                        <h:outputText value="#{itemu.ccianumide}"/>
                      </h:column>
                      <h:column>
                        <f:facet name="header">
                          <h:outputText value="Usuario"/>
                        </f:facet>
                        <h:outputText value="#{itemu.ccicprinom} #{itemu.ccicsegnom} #{itemu.ccicpriape} #{itemu.ccicsegape}"/>
                      </h:column>
                    </h:dataTable>
                    </h:panelGrid>
                   
                    
              </h:panelGroup>
                </s:fieldset>
                </h:panelGroup>
                
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelBotonBotonesEntregaCitol" columnClasses="panelGridBotones" rendered="#{not empty repSegCitologiasBean.listaObjecto}">
                  <a4j:commandButton value="Generar Lista de Entrega" styleClass="btn btn btn-success"
                                     reRender="panelGridEntregaCitolTab,panelBotonBotonesEntregaCitol"
                                     action="#{repSegCitologiasBean.generarListaEntrega}" disabled="#{repSegCitologiasBean.reporteGeneradoPDF}"/>
                  <t:htmlTag value="br"/>
                  <a4j:commandButton value="Generar Archivo CSV" styleClass="btn btn btn-success"
                                     reRender="panelGridEntregaCitolTab,panelBotonBotonesEntregaCitol"
                                     rendered="#{repSegCitologiasBean.renderCsv}"
                                     disabled="#{repSegCitologiasBean.reporteGeneradoCSV}"
                                     action="#{repSegCitologiasBean.generarArchivoCsv}"/>
                </h:panelGrid>
                <f:subview id="generarReporte" rendered="#{repSegCitologiasBean.generoReporte}">
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
                <f:subview id="generarReporte_CE" rendered="#{repSegCitologiasBean.generoReporte_CE}">
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
