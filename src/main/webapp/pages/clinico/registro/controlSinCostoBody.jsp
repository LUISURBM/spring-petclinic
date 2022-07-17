<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formControlSinCosto">
 <a4j:region id="regionControlSinCosto" renderRegionOnly="false">
    <a4j:status id="statusButton"  for="regionControlSinCosto">
      <f:facet name="start">
        <t:div id="chargingControlSinCosto" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>


  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridControlSinCostoTab"
               styleClass="tabContainer">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneControlSinCosto"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabControlSinCosto" label="Control">

  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridControl" styleClass="tabContainer">
    <s:fieldset legend="Fecha Control" id="fieldControl"
                styleClass="fieldset">
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                   width="100%" id="panelDatosControl"
                   rowClasses="labelText">
        <h:outputText value="Fecha Proximo Control " styleClass="labelTextOblig"/>
        <h:outputText value="Hora  Proximo Control " styleClass="labelTextOblig"/>
        <h:panelGroup>
          <t:inputCalendar id="fechaControl"
                        title="Formato: dd/mm/yyyy"
                           disabled="#{controlBean.modoconsulta}"
                           monthYearRowClass="yearMonthHeader"
                           weekRowClass="weekHeader"
                           currentDayCellClass="currentDayCell"
                           popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                           value="#{controlBean.fechaControl}"
                           popupTodayString="Hoy" popupWeekString="Semana"
                           popupButtonString="Fecha" readonly="false"
                           maxlength="11" size="11"
                           popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                           renderPopupButtonAsImage="true" align="top"
                           required="true"/>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="fechaControl" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGroup>
       
       <h:panelGroup>
       <h:panelGroup>
           <h:selectOneMenu id="mnuHora" required="true" disabled="#{controlBean.modoconsulta}"
                           value="#{controlBean.horaSelect}">
            <f:selectItems value="#{controlBean.listHora}"/>
          </h:selectOneMenu>
               <a4j:outputPanel ajaxRendered="true">
            <t:message for="mnuHora" styleClass="errorMessage"/>
          </a4j:outputPanel>
       </h:panelGroup>   
          <h:outputText value=" : "/>
          <h:panelGroup>
              <h:selectOneMenu id="mnuMinutos" required="true" disabled="#{controlBean.modoconsulta}"
                                value="#{controlBean.minutoSelect}">
             <f:selectItems value="#{controlBean.lstMinutos}"/>
          </h:selectOneMenu>
           <a4j:outputPanel ajaxRendered="true">
            <t:message for="mnuMinutos" styleClass="errorMessage"/>
          </a4j:outputPanel>
          </h:panelGroup>
          
       
       
       </h:panelGroup>
        
        
      </h:panelGrid>
    </s:fieldset>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelBotonBotonesControl"
                 columnClasses="panelGridBotones">

        <a4j:commandButton value="Generar Control" styleClass="boton_fieldset"
                           disabled="#{controlBean.modoconsulta}"
                           reRender="panelGridControl"
                           action="#{controlBean.generarControl}"/>
    
    </h:panelGrid>
    
    <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionControlSinCostoMsg"
                                 ajaxRendered="true">
                  <t:messages id="msgControlSinCostoMsg" showSummary="true"
                              errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
      <f:subview id="generarControl"
               rendered="#{controlBean.generoContol}">
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