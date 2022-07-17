<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<a4j:form id="formConsultarCancelacion">
  <a4j:region id="regionConsultarCancelacion" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionConsultarCancelacion">
      <f:facet name="start">
        <t:div id="chargingConsultarCancelacion" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableInfoUbication" border="0" cellpadding="0" cellspacing="0" width="100%"
                 columnClasses="td_ubicador">
      <h:outputText value="HISTORIAS CLINICAS >> Cirugia >> Consultar Cancelacion Cirugias " id="infoUbication"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="tableContentTabsConsultarCancelacion" styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="tabbedPaneConsultarInicio" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <s:fieldset legend="Busqueda Consulta" id="fieldDatosConsulta" styleClass="fieldset">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="10" width="100%"
                       id="tableContentTabsListaUsuario" columnClasses="labelText,labelTextInfo">
            <h:outputText value="Se�or(a): "/>
            <h:outputText id="otnomDoctor" value="#{consultarCancelacionCirugiaBean.usuarioSystem.curcnombre}"/>
            <h:outputText value=" "/>
            <h:outputText value=" "/>
            
             <h:outputText value=" "/>
            <h:outputText value=" "/>
            <h:outputText value=" "/>
            <h:outputText value=" "/>
            
            <h:outputText value="Fecha Inicial: "/>
            <h:outputText value=" "/>
            
              <h:outputText value="Fecha Final: "/>
            <h:outputText value=" "/>
            
            <t:inputCalendar id="fechaConsulta" title="Formato: dd/MM/yyyy" monthYearRowClass="yearMonthHeader"
                             weekRowClass="weekHeader" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                             renderAsPopup="true" value="#{consultarCancelacionCirugiaBean.fechaInicial}"
                             popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha" readonly="false"
                             disabled="false" maxlength="11" size="11" immediate="true"
                             popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                             align="top" required="true"></t:inputCalendar>
               <a4j:outputPanel ajaxRendered="true">
            <t:message for="fechaConsulta" styleClass="errorMessage"/>
          </a4j:outputPanel>
            <t:inputCalendar id="fechaFinal" title="Formato: dd/MM/yyyy" monthYearRowClass="yearMonthHeader"
                             weekRowClass="weekHeader" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                             renderAsPopup="true" value="#{consultarCancelacionCirugiaBean.fechaFinal}"
                             popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha" readonly="false"
                             disabled="false" maxlength="11" size="11" immediate="true"
                             popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                             align="top" required="true"></t:inputCalendar>
                                 <a4j:outputPanel ajaxRendered="true">
            <t:message for="fechaFinal" styleClass="errorMessage"/>
          </a4j:outputPanel>
          </h:panelGrid>
          
          
                   <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelBotonGenerarReporte"
               columnClasses="columnaBotonesCentrados">
 
    <t:htmlTag value="br"/>
    <h:commandButton value="Generar" action="#{consultarCancelacionCirugiaBean.generarReporte}"
              styleClass="btn btn btn-success" id= "idButtonUsuarioCancelacionCirugia" />
        </h:panelGrid>
          
        </s:fieldset>
      
      </t:panelTabbedPane>
      <f:subview id="generarReporteLiquidosEnfermeria" rendered="#{consultarCancelacionCirugiaBean.generoReporte}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(XlsServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=1200,height=900");
        </script>
        </f:verbatim>
      </f:subview>
    </h:panelGrid>
  </a4j:region>
</a4j:form>