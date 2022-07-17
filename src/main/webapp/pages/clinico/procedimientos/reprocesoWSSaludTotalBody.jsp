<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formResulCitol">
  <a4j:region id="regionResulCitol" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionResulCitol">
      <f:facet name="start">
        <t:div id="chargingResulCitol" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="2" id="tableBodyGeneral" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
      <h:panelGroup id="tableGroupContent">
        <h:panelGrid columns="1" id="tableInfoUbication" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="td_ubicador">
          <h:outputText value="HISTORIAS CLINICAS >> Citologias >> Reproceso WS SaludTotal " id="infoUbication"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridResulCitolTab" styleClass="tabContainer">
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMensajesResulCitol" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInfResulCitol" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                          warnClass="advertencia"/>
              <t:htmlTag value="br"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneResulCitol" styleClass="tabbedPane"
                             activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                             tabContentStyleClass="tabContent">

            <t:panelTab id="panelTabResulCitol_Imp" label="Reprocesar WS SaludTotal">
              <a4j:region renderRegionOnly="false">
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridResulBusqueda">
                  <s:fieldset legend="Datos Busqueda " id="fieldResulCitol_Imp" styleClass="fieldset">
                   <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosReporteAsesoriaIlve" rowClasses="labelText,labelTextInfo">
                           
                <h:outputText value="Tipo de Busqueda " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value="N�mero identificaci�n" styleClass="labelTextOblig" />
                <h:outputText value=" "/>
                
                <h:selectOneMenu id ="soBusquedas" required="true"
                    value="#{reprocesoWSSaludTotalBean.busquedaSelected}">
                <f:selectItems value = "#{reprocesoWSSaludTotalBean.lstBusquedas}"/>
                 </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="soBusquedas" styleClass="errorMessage"/>
                </a4j:outputPanel>
                 <h:inputText id ="inNumDoc"
                    value="#{reprocesoWSSaludTotalBean.numDocPac}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="inNumDoc" styleClass="errorMessage"/>
                </a4j:outputPanel>
              
             
                           
                <h:outputText value="Fecha Inicial " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value="Fecha Final " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <t:inputCalendar id="fechaInicialReporteAsesoriaIlve" title="Formato: dd/mm/yyyy"
                                 monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                 currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{reprocesoWSSaludTotalBean.fechaInicio}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" />
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaInicialReporteAsesoriaIlve" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <t:inputCalendar id="fechaFinalReporteAsesoriaIlve" monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{reprocesoWSSaludTotalBean.fechaFin}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaFinalReporteAsesoriaIlve" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>              
                  </s:fieldset>
                  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesResulCitol_Imp" columnClasses="panelGridBotones">
                    <a4j:commandButton value="Buscar" styleClass="boton_fieldset" reRender="panelGridResulBusqueda" action="#{reprocesoWSSaludTotalBean.generarConsultas}"/>
                  </h:panelGrid>
                  <s:fieldset legend="Resultados Consulta" id="fieldSetConsultar_mod" styleClass="fieldset_dataTable">                 
                  <t:htmlTag value= "br"/>
                  <t:htmlTag value= "br"/>                
                    <h:panelGrid columns="1" id="panelGridConsultar1" rendered="#{empty reprocesoWSSaludTotalBean.lstCnconsclin}">
                      <h:outputText value="#{msg.msg_sin_consultar}"/>
                    </h:panelGrid>
                    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsConsultar1"
                                 rendered="#{not empty reprocesoWSSaludTotalBean.lstCnconsclin}" styleClass="tabContainer">
                      <h:panelGrid columns="6" styleClass="labelText">
                        <h:outputText value="Seleccionar "/>
                        <h:outputText value="[ "/>
                        <a4j:commandLink action="#{reprocesoWSSaludTotalBean.activarTodos}" reRender="tableContentTabsConsultar1" value=" Todos"/>
                        <h:outputText value=" | "/>
                        <a4j:commandLink action="#{reprocesoWSSaludTotalBean.desactivarTodos}" reRender="tableContentTabsConsultar1" value="Ninguno "/>
                        <h:outputText value=" ]"/>
                      </h:panelGrid>
                      <h:dataTable var="item" border="0" cellpadding="0" cellspacing="2" binding="#{reprocesoWSSaludTotalBean.dtlstCnconsclin}"
                                   value="#{reprocesoWSSaludTotalBean.lstCnconsclin}" styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                                   id="dtBucarUsuarios1">
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Item"/>
                          </f:facet>
                          <h:selectBooleanCheckbox value="#{item.itemSelect}" id="idSelectedItem"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="N�mero consulta"/>
                          </f:facet>
                          <h:outputText value="#{item.cconnumero}"/>
                        </h:column>
                        
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Fecha de Registro"/>
                          </f:facet>
                          <h:outputText value="#{item.ccodfecreg}"/>
                        </h:column>                        
                        
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Identificacion"/>
                          </f:facet>
                          <h:outputText value="#{item.ccoctipide} #{item.ccoanumide}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Nombre Paciente"/>
                          </f:facet>
                          <h:outputText value="#{item.ccocprinom} #{item.ccocsegnom} #{item.ccocpriape} #{item.ccocsegape}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Servicio"/>
                          </f:facet>
                          <h:outputText value="#{item.ccocservic.csvccodigo} #{item.ccocservic.csvcnombre}"/>
                        </h:column>
                      </h:dataTable>
                      <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonResulCitol_Imp" columnClasses="panelGridBotones">
                       
                        <a4j:commandButton value="Reprocesar seleccionados" styleClass="boton_fieldset"  action="#{reprocesoWSSaludTotalBean.reprocesarWS}"/>
                      </h:panelGrid>
                    </h:panelGrid>
                  
                  </s:fieldset>
                </h:panelGrid>
              </a4j:region>
            </t:panelTab>
          </t:panelTabbedPane>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                          warnClass="advertencia"/>
              <t:htmlTag value="br"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>