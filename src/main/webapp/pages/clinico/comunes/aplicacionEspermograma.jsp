<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
 <a4j:region>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAplicacionEspermogramaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneAplicacionEspermograma" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabAplicacionEspermograma" label="Espermograma">
      <s:fieldset legend="Registrar Espermograma" id="fieldSetEspermograma" styleClass="fieldset">
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelDatosEspermograma" rowClasses="labelText,labelTextInfo">
          <h:outputText value="Fecha Toma"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Fecha Resultado"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <t:inputCalendar id="fechaToma" title="Formato: dd/mm/yyyy" monthYearRowClass="yearMonthHeader"
                  weekRowClass="weekHeader" onkeydown="return blockEnter(event);" disabled="#{aplicacionEspermogramaBean.consultaCerrada}"
                  currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                  value="#{aplicacionEspermogramaBean.espevasec.hevdfechatoma}" popupTodayString="Hoy"
                  popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11" size="11"
                  popupButtonImageUrl="/comun/imagenes/ico_calendario.gif" renderPopupButtonAsImage="true"
                  align="top" required="true"/>
          <a4j:outputPanel ajaxRendered="true">
              <t:message for="fechaToma" styleClass="errorMessage"/>
          </a4j:outputPanel>
          
          <t:inputCalendar id="fechaResultado" title="Formato: dd/mm/yyyy" monthYearRowClass="yearMonthHeader"
                           weekRowClass="weekHeader" onkeydown="return blockEnter(event);" disabled="#{aplicacionEspermogramaBean.consultaCerrada}"
                           currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                           value="#{aplicacionEspermogramaBean.espevasec.hevdfecharesul}" popupTodayString="Hoy"
                           popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11" size="11"
                           popupButtonImageUrl="/comun/imagenes/ico_calendario.gif" renderPopupButtonAsImage="true"
                           align="top" required="true"/>
          <a4j:outputPanel ajaxRendered="true">
              <t:message for="fechaResultado" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value="Espermograma PostVasectomia"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Recuento de Espermatozoides"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:selectOneRadio id="mnuResultadoEspermograma" 
                       onkeydown="return blockEnter(event);"  disabled="#{aplicacionEspermogramaBean.consultaCerrada}"
                       value="#{aplicacionEspermogramaBean.espevasec.hevcesperpostv}">
               <f:selectItems value="#{aplicacionEspermogramaBean.lstResultado}"/>
          </h:selectOneRadio>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="mnuResultadoEspermograma" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="textRecuentoEspermatozides" value="#{aplicacionEspermogramaBean.espevasec.hevarecueesper}" required="true"
                      style="width:400px" maxlength="200" disabled="#{aplicacionEspermogramaBean.consultaCerrada}"/>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="textRecuentoEspermatozides" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosEspermograma2"
                   rowClasses="labelText,labelTextInfo">
          <h:outputText value="Observaciones Espermograma" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:inputTextarea id="textResultadoEspermograma" value="#{aplicacionEspermogramaBean.espevasec.hevcresulesper}"
                   style="width:500px;height:70px" disabled="#{aplicacionEspermogramaBean.consultaCerrada}"/>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="textResultadoEspermograma" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="10" width="100%"
                 id="panelBotonesEspermograma" columnClasses="panelGridBotones">
          <h:panelGroup>
              <h:commandButton value="Guardar" styleClass="btn btn btn-success" 
                            rendered="#{!aplicacionEspermogramaBean.consultaCerrada}"
                           action="#{aplicacionEspermogramaBean.guardar}">
                 <a4j:support event="onclick" status="statusButton"/> 
              </h:commandButton>
              <h:commandButton value="Imprimir Formato" styleClass="btn btn btn-success" 
                            rendered="#{aplicacionEspermogramaBean.consultaCerrada}"
                           action="#{aplicacionEspermogramaBean.imprimirEspermograma}">
                 <a4j:support event="onclick" status="statusButton"/> 
              </h:commandButton>
              <h:commandButton value="Siguiente" styleClass="btn btn btn-warning" 
                            rendered="#{aplicacionEspermogramaBean.consultaCerrada}"
                                 action="#{aplicacionEspermogramaBean.siguiente}"/>

          </h:panelGroup>
        </h:panelGrid>

        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMensajes" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInf" showSummary="false" errorClass="error" globalOnly="true" layout="table"
                        infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>


     
      </s:fieldset>
    </t:panelTab>
    <h:panelGrid rendered="#{aplicacionEspermogramaBean.generoEspermograma}" >
      <f:subview id="generarEspermograma" rendered="#{aplicacionEspermogramaBean.generoEspermograma}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
          </script>
        </f:verbatim>
      </f:subview>
    </h:panelGrid>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>
   </a4j:region>