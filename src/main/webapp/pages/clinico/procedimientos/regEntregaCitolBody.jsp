<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formCitolEntrega">
  <a4j:region id="regionCitolEntrega">
    <a4j:status id="statusButton" for="regionCitolEntrega">
      <f:facet name="start">
        <t:div id="chargingCitolEntrega" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableInfoUbication" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="td_ubicador">
      <h:outputText value="HISTORIAS CLINICAS >> Citologias >> Reporte de Citologias Entregadas " id="infoUbication"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridCitolEntregaTab" styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneCitolEntrega" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabCitolEntrega" label="Lista Entrega de Citologias">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridCitolEntrega">
            <s:fieldset legend="Datos Busqueda" id="fieldCitolEntrega" styleClass="fieldset">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosCitolEntrega" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Fecha Inicial " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value="Fecha Final " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <t:inputCalendar id="fechaInicialCitolEntrega" title="Formato: dd/mm/yyyy" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy" renderAsPopup="true" value="#{ repEntregaCitologiasBean.fechaInicial}" popupTodayString="Hoy" popupWeekString="Semana"
                                 popupButtonString="Fecha" readonly="false" maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                                 align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaInicialCitolEntrega" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <t:inputCalendar id="fechaFinalCitolEntrega" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                 renderAsPopup="true" value="#{ repEntregaCitologiasBean.fechaFinal}" popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha" readonly="false"
                                 maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true" align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaFinalCitolEntrega" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="Reporte de " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
                <h:panelGroup id="panelGroupRadio">
                  <h:selectOneRadio id="clsenniveluso" value="#{repEntregaCitologiasBean.tipoReporte}" required="true">
                    <f:selectItem itemLabel="Citologias Entregadas" itemValue="CE"/>
                    <f:selectItem itemLabel="Seguimiento" itemValue="SE"/>
                  </h:selectOneRadio>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="clsenniveluso" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
              </h:panelGrid>
            </s:fieldset>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionMensajesCitolEntrega" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInfCitolEntrega" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                            warnClass="advertencia"/>
                <t:htmlTag value="br"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesCitolEntrega" columnClasses="panelGridBotones">
              <a4j:commandButton value="Generar Reporte" styleClass="boton_fieldset" reRender="panelGridCitolEntregaTab" action="#{ repEntregaCitologiasBean.generarListaEntrega}"/>
            </h:panelGrid>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
      
      
      <f:subview id="generarReporte" rendered="#{repEntregaCitologiasBean.generoReporte}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript"> 
            function enviar(){
                window.location="<%=request.getSession().getAttribute(XlsServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>";
            }
            </script>
          <a href="javascript:enviar()"><img src="../../../comun/imagenes/xls.png" height="100" width="100" alt="Descargue"><br/>Descargar Archivo</a>
        </f:verbatim>
      </f:subview>
      
    <f:subview id="generarReporte_CE" rendered="#{repEntregaCitologiasBean.generoReporte_CE}">
      <f:verbatim>
        <script type="text/javascript" language="JavaScript">
            window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
      </f:verbatim>
    </f:subview>      
      
    </h:panelGrid>
  </a4j:region>
</a4j:form>