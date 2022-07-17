<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="consultarAutorizacionRegistrosForm">
  <a4j:region id="bodyRegionAutorizacionRegistros">
    <a4j:status id="statusButton" for="bodyRegionAutorizacionRegistros">
      <f:facet name="start">
        <t:div id="chargindConsultarAutorizacionRegistros" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridDatosUsuarioTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneDatosUsuario" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabDatosUsuario" label="Pruebas Rapidas">
          <h:panelGrid id="panleDatosBasicos" columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       styleClass="tabContainer">
            <s:fieldset legend="Condiciones de realizaci�n de la prueba"  id="fieldSetInfoCondiciones"
                        styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelRegionInfoAcompa" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Lugar donde se realiza la prueba"/>
                <h:outputText/>
                <h:outputText value="Departamento:" styleClass="labelTextOblig"/>
                <h:outputText value="Municipio:" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <a4j:region renderRegionOnly="false">
                    <h:selectOneMenu disabled="#{pruebasRapidasBean.botonImprimir}" id="menuDepartamentos" value="#{pruebasRapidasBean.departamentoSelect}"
                                     onkeydown="return blockEnter(event);"
                                     valueChangeListener="#{pruebasRapidasBean.setDepartamentoSelect}">
                      <f:selectItems value="#{pruebasRapidasBean.listDepartamentos}"/>
                      <a4j:support id="support7" action="#{pruebasRapidasBean.changeCiudad}"
                                   reRender="panleDatosBasicos" event="onchange">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="menuDepartamentos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </a4j:region>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="menuCiudad" disabled="#{pruebasRapidasBean.botonImprimir}" style="wdith:200px" onkeydown="return blockEnter(event);"
                                   value="#{pruebasRapidasBean.ciudadSelect}">
                    <f:selectItems value="#{pruebasRapidasBean.listMunicipios}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuCiudad" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Temperatura" styleClass="labelTextOblig"/>
                <h:outputText/>
                <h:panelGroup>
                  <h:inputText id="itTemperaura" disabled="#{pruebasRapidasBean.botonImprimir}" required="true" onkeydown="return blockEnter(event);"
                               title="Temperatura en grados cent�grados"
                               value="#{pruebasRapidasBean.pruebasRapidas.hprntemperatura}" style="width:50px"
                               maxlength="4">
                                </h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itTemperaura" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <h:outputText value="  �C"/>
                </h:panelGroup>
              </h:panelGrid>
              <h:outputText value=""/>
            </s:fieldset>
            <s:fieldset legend="Tipo de prueba"  id="fieldSetInfoTipoPrueba" styleClass="fieldset">
            
                           <s:fieldset legend="VIH 1 - 2" styleClass="fieldset" rendered="#{pruebasRapidasBean.renderVIH}">
                            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%">
                        <h:outputText value="Marca" styleClass="labelTextOblig"/>
                        <h:outputText value="Lote" styleClass="labelTextOblig"/>
                           <h:outputText value="Registro Invima" styleClass="labelTextOblig"/>
                              <h:outputText value="Fecha Vencimiento" styleClass="labelTextOblig"/>
                           <h:outputText value="#{pruebasRapidasBean.pruebasRapidas.hprcmarcavih}"  />
                               <h:inputText disabled="#{pruebasRapidasBean.botonImprimir}" value="#{pruebasRapidasBean.pruebasRapidas.hprclotevih}" maxlength="100" required="true"/>
                                   <h:outputText value="#{pruebasRapidasBean.pruebasRapidas.hprcreginvvih}"/>
                                     <t:inputCalendar id="fechaVencimientoVih" title="Formato: dd/MM/yyyy"
                                         monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                         currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                         renderAsPopup="true"
                                         value="#{pruebasRapidasBean.pruebasRapidas.hprdfecvenvih}"
                                         popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                         readonly="false" disabled="#{pruebasRapidasBean.botonImprimir}" maxlength="11" size="11" immediate="true"
                                         popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                         renderPopupButtonAsImage="true" align="top" required="true"></t:inputCalendar>
                </h:panelGrid>
                 </s:fieldset>
               
                          
                                 <s:fieldset legend="HEPATITIS B" styleClass="fieldset" rendered="#{pruebasRapidasBean.renderHepatitisB}">
                            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%">
                        <h:outputText value="Marca" styleClass="labelTextOblig"/>
                        <h:outputText value="Lote" styleClass="labelTextOblig"/>
                           <h:outputText value="Registro Invima" styleClass="labelTextOblig"/>
                              <h:outputText value="Fecha Vencimiento" styleClass="labelTextOblig"/>
                           <h:outputText value="#{pruebasRapidasBean.pruebasRapidas.hprcmarcahepab}" />
                               <h:inputText disabled="#{pruebasRapidasBean.botonImprimir}"  value="#{pruebasRapidasBean.pruebasRapidas.hprclotehepab}" maxlength="100" required="true" />
                                   <h:outputText value="#{pruebasRapidasBean.pruebasRapidas.hprcreginvhepb}" />
                                     <t:inputCalendar id="fechaVencimient" title="Formato: dd/MM/yyyy"
                                         monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                         currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                         renderAsPopup="true"
                                         value="#{pruebasRapidasBean.pruebasRapidas.hprdfecvenhepb}"
                                         popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                         readonly="false" disabled="#{pruebasRapidasBean.botonImprimir}" maxlength="11" size="11" immediate="true"
                                         popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                         renderPopupButtonAsImage="true" align="top" required="true"></t:inputCalendar>
                </h:panelGrid>
              
                           </s:fieldset>
                               <s:fieldset legend="HEPATITIS C" styleClass="fieldset" rendered="#{pruebasRapidasBean.renderHepatitisC}">
                            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%">
                        <h:outputText value="Marca" styleClass="labelTextOblig"/>
                        <h:outputText value="Lote" styleClass="labelTextOblig"/>
                           <h:outputText value="Registro Invima" styleClass="labelTextOblig"/>
                              <h:outputText value="Fecha Vencimiento" styleClass="labelTextOblig"/>
                           <h:outputText value="#{pruebasRapidasBean.pruebasRapidas.hprcmarcahepac}"/>
                               <h:inputText disabled="#{pruebasRapidasBean.botonImprimir}" value="#{pruebasRapidasBean.pruebasRapidas.hprclotehepac}" maxlength="100" required="true" />
                                   <h:outputText value="#{pruebasRapidasBean.pruebasRapidas.hprcreginvhepc}" />
                                     <t:inputCalendar id="fechaVencimientHepaC" title="Formato: dd/MM/yyyy"
                                         monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                         currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                         renderAsPopup="true"
                                         value="#{pruebasRapidasBean.pruebasRapidas.hprdfecvenhepc}"
                                         popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                         readonly="false" disabled="#{pruebasRapidasBean.botonImprimir}" maxlength="11" size="11" immediate="true"
                                         popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                         renderPopupButtonAsImage="true" align="top" required="true"></t:inputCalendar>
                </h:panelGrid>
               
                           </s:fieldset>
                            <s:fieldset legend="S�FILIS" styleClass="fieldset" rendered="#{pruebasRapidasBean.renderSifilis}">
                            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%">
                        <h:outputText value="Marca" styleClass="labelTextOblig"/>
                        <h:outputText value="Lote" styleClass="labelTextOblig"/>
                           <h:outputText value="Registro Invima" styleClass="labelTextOblig"/>
                              <h:outputText value="Fecha Vencimiento" styleClass="labelTextOblig"/>
                           <h:outputText value="#{pruebasRapidasBean.pruebasRapidas.hprcmarcasifil}" />
                               <h:inputText disabled="#{pruebasRapidasBean.botonImprimir}"  value="#{pruebasRapidasBean.pruebasRapidas.hprclotesifi}" maxlength="100" required="true" />
                                   <h:outputText value="#{pruebasRapidasBean.pruebasRapidas.hprcreginvsif}"  />
                                     <t:inputCalendar id="fechaVencimientSif" title="Formato: dd/MM/yyyy"
                                         monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                         currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                         renderAsPopup="true"
                                         value="#{pruebasRapidasBean.pruebasRapidas.hprdfecvensif}"
                                         popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                         readonly="false" disabled="#{pruebasRapidasBean.botonImprimir}" maxlength="11" size="11" immediate="true"
                                         popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                         renderPopupButtonAsImage="true" align="top" required="true"></t:inputCalendar>
                </h:panelGrid>
                
                           </s:fieldset>
                           
                              <s:fieldset legend="Prueba Embarazo (Orina)" styleClass="fieldset" rendered="#{pruebasRapidasBean.renderPruebaEmbarazo}">
                            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%">
                        <h:outputText value="Marca" styleClass="labelTextOblig"/>
                        <h:outputText value="Lote" styleClass="labelTextOblig"/>
                           <h:outputText value="Registro Invima" styleClass="labelTextOblig"/>
                              <h:outputText value="Fecha Vencimiento" styleClass="labelTextOblig"/>
                           <h:outputText value="#{pruebasRapidasBean.pruebasRapidas.hprcmarcapruemb}" />
                               <h:inputText disabled="#{pruebasRapidasBean.botonImprimir}"  value="#{pruebasRapidasBean.pruebasRapidas.hprclotepruemb}" maxlength="100" required="true" />
                                   <h:outputText  value="#{pruebasRapidasBean.pruebasRapidas.hprcreginvpruemb}"  />
                                     <t:inputCalendar  id="fechaVencimientpruemb" title="Formato: dd/MM/yyyy"
                                         monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                         currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                         renderAsPopup="true"
                                         value="#{pruebasRapidasBean.pruebasRapidas.hprdfecvenpruemb}"
                                         popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                         readonly="false" disabled="#{pruebasRapidasBean.botonImprimir}" maxlength="11" size="11" immediate="true"
                                         popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                         renderPopupButtonAsImage="true" align="top" required="true"></t:inputCalendar>
                </h:panelGrid>
                
                           </s:fieldset>
 </s:fieldset>  
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Guardar"  disabled="#{pruebasRapidasBean.botonImprimir}" styleClass="btn btn btn-success"
                        action="#{pruebasRapidasBean.guardarPruebasRapidas}">
                  <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>            
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
                  <t:messages id="msgInformationAndErrors1" showSummary="true" errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>