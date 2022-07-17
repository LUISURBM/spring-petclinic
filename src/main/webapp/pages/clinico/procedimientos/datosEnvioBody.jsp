<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="infoClinicaForm">
  <a4j:region id="bodyRegionCU">
    <a4j:status id="statusButton" for="bodyRegionCU">
      <f:facet name="start">
        <t:div id="chargindDiv2" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableInfoUbication" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="td_ubicador">
      <h:outputText value="Historias Clinicas >> Datos de Envio" id="infoUbication"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabs" styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="tabbedPaneParametro" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabInfoGenral" label="#{datosEnvioBean.titulo}" rendered="true">
          <t:htmlTag value="br"/>
          <s:fieldset legend="Datos Basicos" id="fieldSetInfoBasica" styleClass="fieldset">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoConsulta" rowClasses="labelText,labelTextInfo">
              
              
              <h:outputLabel value="Codigo Lista" for="heplidentificador" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:outputLabel value="Fecha de Envio" for="hepdfechaenvio" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              
              
                <h:inputText id="heplidentificador" required="true" size="5" value="#{datosEnvioBean.listaEntregaClone.heplidentificador}" disabled="true"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="heplidentificador" styleClass="errorMessage"/>
              </a4j:outputPanel>
              
              
             <t:inputCalendar id="hepdfechaenvio" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                     renderAsPopup="true" value="#{datosEnvioBean.fechaEnvio}" popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha" readonly="false"
                                     maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true" align="top" required="true"/>
                    
             
                    
                    
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="hepdfechaenvio" styleClass="errorMessage"/>
                    </a4j:outputPanel>
      
      
                    
                    
                    
               <h:outputLabel value="Empresa Transportadora" for="hepcempenvio" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:outputLabel value="Número de Guía" for="hepcnumguia" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              
                <h:inputText id="hepcempenvio" required="true"  value="#{datosEnvioBean.listaEntregaClone.hepcempenvio}" size="25"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="hepcempenvio" styleClass="errorMessage"/>
              </a4j:outputPanel>    
              
               <h:inputText id="hepcnumguia" required="true"  value="#{datosEnvioBean.listaEntregaClone.hepcnumguia}" size="8" />
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="hepcnumguia" styleClass="errorMessage"/>
              </a4j:outputPanel>
              
               <h:outputLabel value="Observaciones" for="hepcobservenvio" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              
              <h:inputTextarea id="hepcobservenvio" value="#{datosEnvioBean.listaEntregaClone.hepcobservenvio}" rows="4" cols="60"/>
              <t:message for="hepcobservenvio" styleClass="errorMessage"/>


            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonConsulta" columnClasses="columnaBotonesCentrados">
              <a4j:outputPanel id="ajaxRegionMessages" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                <t:htmlTag value="br"/>
              </a4j:outputPanel>
              <h:panelGroup>
                <a4j:commandButton value="Ingresar Datos" action="#{datosEnvioBean.modificar}" reRender="tableContentTabs" 
                                   styleClass="boton_fieldset"/>
              </h:panelGroup>
            </h:panelGrid>
          </s:fieldset>
        </t:panelTab>
      </t:panelTabbedPane>
      <h:panelGrid>
        <h:commandLink action="#{datosEnvioBean.volverConsulta}" immediate="true">
          <t:graphicImage border="0" url="/comun/imagenes/volver.gif"/>
        </h:commandLink>
      </h:panelGrid>
    </h:panelGrid>
  </a4j:region>
</a4j:form>