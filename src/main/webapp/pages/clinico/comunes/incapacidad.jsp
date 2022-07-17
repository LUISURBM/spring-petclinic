<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridIncapacidadTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneIncapacidad" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabIncapacidad" label="Incapacidad">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridIncapacidad">
        <s:fieldset legend="Fechas Incapacidad" id="fieldIncapacidad" styleClass="fieldset">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosIncapacidad" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Fecha Inicial Incapacidad " styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:outputText value="N�mero D�as Incapacidad  " styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <t:inputCalendar id="fechaInicialIncapacidad" onkeydown="return blockEnter(event);"
                             title="Formato: dd/mm/yyyy" disabled="#{incapacidadUsuarioBean.modoconsulta}" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                             currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true" value="#{incapacidadUsuarioBean.incapacidad.hindfecinicia}" popupTodayString="Hoy"
                             popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                             renderPopupButtonAsImage="true" align="top" required="true"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="fechaInicialIncapacidad" styleClass="errorMessage"/>
            </a4j:outputPanel>
           <h:inputText id = "itNumeroDias" disabled="#{incapacidadUsuarioBean.modoconsulta}" onkeydown="return blockEnter(event);"
                    value = "#{incapacidadUsuarioBean.incapacidad.hidndias}" maxlength="2" style="width:40px"/>
              <a4j:outputPanel ajaxRendered="true">
              <t:message for="fechaInicialIncapacidad" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Tipo Incapacidad " styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:outputText value="Origen Incapacidad" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:selectOneMenu id="menuTipoIncapacidad" required="true" onkeydown="return blockEnter(event);"
                    disabled="#{incapacidadUsuarioBean.modoconsulta}" value="#{incapacidadUsuarioBean.incapacidad.hidntipoincapa}">
              <f:selectItems value="#{incapacidadUsuarioBean.lstTipoIncapacidad}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuTipoIncapacidad" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneMenu id="menuOrigenIncapacidad" onkeydown="return blockEnter(event);"
                required="true" disabled="#{incapacidadUsuarioBean.modoconsulta}" value="#{incapacidadUsuarioBean.incapacidad.hidnorigeincap}">
              <f:selectItems value="#{incapacidadUsuarioBean.lstOrigenIncapacidad}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuOrigenIncapacidad" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
        </s:fieldset>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMensajesIncapacidad" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInfIncapacidad" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesIncapacidad" columnClasses="panelGridBotones">
          <a4j:commandButton value="Generar Incapacidad" styleClass="btn btn btn-success" reRender="panelGridIncapacidadTab"
                             action="#{incapacidadUsuarioBean.generarIncapacidad}"/>
        </h:panelGrid>
        <f:subview id="generarIncapacidad" rendered="#{incapacidadUsuarioBean.generoIncapacidad}">
          <f:verbatim>
            <script type="text/javascript" language="JavaScript">
                window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
            </script>
          </f:verbatim>
        </f:subview>
      </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
      <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>