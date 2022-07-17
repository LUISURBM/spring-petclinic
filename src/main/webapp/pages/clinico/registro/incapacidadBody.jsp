<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formIncapacidad">
  <a4j:region id="regionIncapacidad" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionIncapacidad">
      <f:facet name="start">
        <t:div id="chargingIncapacidad" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>


    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridIncapacidadTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneIncapacidad"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabIncapacidad" label="Incapacidad">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridIncapacidad"
                       styleClass="tabContainer">
            <s:fieldset legend="Fechas Incapacidad" id="fieldIncapacidad"
                        styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelDatosIncapacidad" rowClasses="labelText">
                <h:outputText value="Fecha Inicial Incapacidad "
                              styleClass="labelTextOblig"/>
                <h:outputText value="Fecha Final Incapacidad  "
                              styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <t:inputCalendar id="fechaInicialIncapacidad"
                                   title="Formato: dd/mm/yyyy"
                                   disabled="#{incapacidadBean.modoconsulta}"
                                   monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{incapacidadBean.fechaInicial}"
                                   popupTodayString="Hoy"
                                   popupWeekString="Semana"
                                   popupButtonString="Fecha" readonly="false"
                                   maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   required="true"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="fechaInicialIncapacidad"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <t:inputCalendar id="fechaFinalIncapacidad"
                                   disabled="#{incapacidadBean.modoconsulta}"
                                   monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{incapacidadBean.fechaFinal}"
                                   popupTodayString="Hoy"
                                   popupWeekString="Semana"
                                   popupButtonString="Fecha" readonly="false"
                                   maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   required="true"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="fechaFinalIncapacidad"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Tipo Incapacidad "
                              styleClass="labelTextOblig"/>
                <h:outputText value="Origen Incapacidad"
                              styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:selectOneMenu id="menuTipoIncapacidad" required="true"
                                   disabled="#{incapacidadBean.modoconsulta}"
                                   value="#{incapacidadBean.tipoIncapacidadSelect}">
                    <f:selectItems value="#{incapacidadBean.lstTipoIncapacidad}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuTipoIncapacidad"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="menuOrigenIncapacidad" required="true"
                                   disabled="#{incapacidadBean.modoconsulta}"
                                   value="#{incapacidadBean.origenSelect}">
                    <f:selectItems value="#{incapacidadBean.lstOrigenIncapacidad}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuOrigenIncapacidad"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelBotonBotonesIncapacidad"
                         columnClasses="panelGridBotones">
              <a4j:commandButton value="Generar Incapacidad"
                                 styleClass="boton_fieldset"
                                 disabled="#{incapacidadBean.modoconsulta}"
                                 reRender="panelGridIncapacidad"
                                 action="#{incapacidadBean.generarIncapacidad}"/>
            </h:panelGrid>
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMensajesIncapacidad"
                                 ajaxRendered="true">
                  <t:htmlTag value="br"/>
                  <t:messages id="msgInfIncapacidad" showSummary="true"
                              errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
            <f:subview id="generarIncapacidad"
                       rendered="#{incapacidadBean.generoIncapacidad}">
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
  </a4j:region>
</a4j:form>