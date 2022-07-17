<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formControlCitologiasNal">
  <a4j:region id="regionControlCitologiaNal">
    <a4j:status id="statusButton" for="regionControlCitologiaNal">
      <f:facet name="start">
        <t:div id="chargingControlCitologiaNal" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableInfoControlCitologiaNal" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="td_ubicador">
      <h:outputText value="HISTORIAS CLINICAS >> Reportes >> Libro Control de Citologias Nacional " id="infoUbication"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridControlCitologiaNalTab" styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" 
      id="panelTabbedPaneControlCitologiaNal" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabControlCitologiaNal" label="Libro Control de Citologias Nacional">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
          id="panelGridCitoControl">
            <s:fieldset legend="Datos Busqueda" id="fieldCitolControlNal" styleClass="fieldset">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosCitolControlNal" rowClasses="labelText,labelTextInfo">
              
              
                 <h:outputText value="Clinica " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value="" />
                <h:outputText value=" "/>
    
                <h:selectOneMenu id ="mnuClinica" required="true"
                    value="#{reporteControlCitologiasNalBean.wcodclin}">
                <f:selectItems value = "#{reporteControlCitologiasNalBean.lstClinicas}"/>
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
                <t:inputCalendar id="fechaInicialCitolControlNal" title="Formato: dd/mm/yyyy" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy" renderAsPopup="true" 
                                 value="#{reporteControlCitologiasNalBean.fechaInicial}" popupTodayString="Hoy" popupWeekString="Semana"
                                 popupButtonString="Fecha" readonly="false" maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                                 align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaInicialCitolControlNal" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <t:inputCalendar id="fechaFinalCitolControlNal" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                 renderAsPopup="true" value="#{reporteControlCitologiasNalBean.fechaFinal}" popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha" readonly="false"
                                 maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true" align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaFinalCitolControlNal" styleClass="errorMessage"/>
                </a4j:outputPanel>
               
              </h:panelGrid>
            </s:fieldset>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionMensajesCitolControlNal" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInfCitolControlNal" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                            warnClass="advertencia"/>
                <t:htmlTag value="br"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
                id="panelBotonBotonesCitolControlNal" columnClasses="panelGridBotones">
              <a4j:commandButton value="Generar Reporte" styleClass="boton_fieldset" reRender="panelGridControlCitologiaNalTab" action="#{reporteControlCitologiasNalBean.generarListaEntrega}"/>
              <a4j:commandButton value="Generar Reporte Excel" styleClass="boton_fieldset" reRender="panelGridControlCitologiaNalTab" action="#{reporteControlCitologiasNalBean.generarListaEntregaXls}"/>
            </h:panelGrid>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
      
    <f:subview id="generarReporteControlNal" rendered="#{reporteControlCitologiasNalBean.generoReporte_CE}">
      <f:verbatim>
        <script type="text/javascript" language="JavaScript">
            window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
      </f:verbatim>
    </f:subview>      
      
    </h:panelGrid>
  </a4j:region>
</a4j:form>