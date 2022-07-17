<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:keepAlive beanName="lecturaVphBean"/>
<a4j:form id="formLecturaVph">
    <a4j:region id="regionLecturaVph" renderRegionOnly="false">
        <a4j:status id="statusButton" for="regionLecturaVph">
            <f:facet name="start">
                <t:div id="chargingLecturaVph" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridLecturaVphTab"
                     styleClass="tabContainer">
   
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="panelTabbedPanelLecturaVph"
                               styleClass="tabbedPane" activeTabStyleClass="activeTab"
                               inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                               activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                               tabContentStyleClass="tabContent">
                                
                <t:panelTab id="panelTabLecturaVph" label="Lectura Vph">
                <h:panelGroup>
       <a4j:outputPanel id="ajaxRegionMedicamentosMsg" ajaxRendered="true">
         <t:htmlTag value="br"/>
         <t:messages id="msgInformationMedicamentoMsg" showSummary="false" errorClass="error" globalOnly="true"
                     layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
         <t:htmlTag value="br"/>
       </a4j:outputPanel>
     </h:panelGroup>
                    <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
                    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                 id="panelGridLecturaVph1" styleClass="tabContainer">
                        <s:fieldset legend="Lectura Vph" id="fieldLectura" styleClass="fieldset" rendered="#{false}">
                            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                                         id="panelDatosLecturaVph" rowClasses="labelText,labelTextInfo">
                                <h:outputText value="Lectura por" styleClass="labelTextOblig"/>
                                <h:outputText value="Nombre" styleClass="labelTextOblig"/>
                                <h:outputText value="Fecha" styleClass="labelTextOblig"/>
                                <h:panelGroup>
                                    <h:selectOneMenu id="menuVphLeida" required="true" immediate="true"
                                                     value="#{lecturaVphBean.lectura.ccvclectur}">
                                        <f:selectItem itemValue="15" itemLabel="Bacterióloga"/>
                                    </h:selectOneMenu>
                                    <a4j:outputPanel ajaxRendered="true">
                                        <t:message for="menuVphLeida" styleClass="errorMessage"/>
                                    </a4j:outputPanel>
                                </h:panelGroup>
                                <h:panelGroup>
                                    <h:inputText id="itNombreLectura" required="true" maxlength="30" immediate="true"
                                                 value="#{lecturaVphBean.lectura.ccvcnomlec}"/>
                                    <a4j:outputPanel ajaxRendered="true">
                                        <t:message for="itNombreLectura" styleClass="errorMessage"/>
                                    </a4j:outputPanel>
                                </h:panelGroup>
                                <h:panelGroup>
                                    <t:inputCalendar id="calendarLectura" title="Formato: dd/mm/yyyy"
                                                     onkeydown="return blockEnter(event);"
                                                     monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                                     currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                                     renderAsPopup="true" value="#{lecturaVphBean.lectura.ccvdfeclec}"
                                                     popupTodayString="Hoy" popupWeekString="Semana"
                                                     popupButtonString="Fecha" readonly="false" maxlength="11" size="11"
                                                     popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                                     renderPopupButtonAsImage="true" align="top" immediate="true"
                                                     required="true"/>
                                    <a4j:outputPanel ajaxRendered="true">
                                        <t:message for="calendarLectura" styleClass="errorMessage"/>
                                    </a4j:outputPanel>
                                </h:panelGroup>
                            </h:panelGrid>
                            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                                         id="panelObservacionesLectura" rowClasses="labelText,labelTextInfo">
                                <h:outputText value="Observaciones"/>
                                <h:outputText value=""/>
                                <h:panelGroup>
                                    <h:inputTextarea id="itObservaciones" style="width:600px"
                                                     value="#{lecturaVphBean.lectura.ccvcobserv}">
                                        <f:validateLength maximum="80"/>
                                    </h:inputTextarea>
                                </h:panelGroup>
                                <a4j:outputPanel ajaxRendered="true">
                                    <t:message for="itObservaciones" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                            </h:panelGrid>
                        </s:fieldset>
                        <s:fieldset legend="Genotipificación" id="fieldSetInfoGenotipicacion" styleClass="fieldset">
                            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                                         id="panelRegionGenotipicacion" rowClasses="labelText,labelTextInfo">
                                <h:outputText value="Resultado Genotipificación" styleClass="labelTextOblig"/>
                                <h:outputText value=""/>
                                <h:outputText value=""/>
                                <h:outputText value=""/>
                                <a4j:region renderRegionOnly="false">
                                    <h:panelGroup>
                                        <h:selectOneRadio id="mnuGenotipicacion" required="true" immediate="true"
                                                          onkeydown="return blockEnter(event);"
                                                          value="#{lecturaVphBean.lectura.ccvcgenoneg}"
                                                          valueChangeListener="#{lecturaVphBean.setCcvcgenoneg}">
                                            <f:selectItem itemValue="S" itemLabel="No detectable"/>
                                            <f:selectItem itemValue="N" itemLabel="Detectable"/>
                                            <f:selectItem itemValue="NS" itemLabel="No satisfactoria"/>
                                            <a4j:support id="supportGenotipicacion" event="onclick"
                                                         action="#{lecturaVphBean.changeGenotipificacion}"
                                                         reRender="panelGenotipicacionGral,fieldDatosLectura">
                                                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                            </a4j:support>
                                            <a4j:outputPanel ajaxRendered="true">
                                                <t:message for="mnuGenotipicacion" styleClass="errorMessage"/>
                                            </a4j:outputPanel>
                                        </h:selectOneRadio>
                                    </h:panelGroup>
                                </a4j:region>
                                <h:outputText value=""/>
                                <h:outputText value=""/>
                                <h:outputText value=""/>
                            </h:panelGrid>
                            <h:panelGrid id="panelGenotipicacionGral" border="0" cellpadding="0" cellspacing="0"
                                         width="100%">
                                <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0"
                                             rendered="#{lecturaVphBean.mostrarGenotipificacion}" width="100%"
                                             id="panelGenotipicacion" rowClasses="labelText,labelTextInfo">
                                    <h:panelGroup>
                                        <h:outputText value="16" styleClass="labelTextOblig"/>
                                        <h:selectOneRadio id="mnuGeno16" required="true" immediate="true"
                                                          onkeydown="return blockEnter(event);"
                                                          value="#{lecturaVphBean.lectura.ccvcgt16}"
                                                          valueChangeListener="#{lecturaVphBean.setCcvcgt16}">
                                            <f:selectItem itemValue="S" itemLabel="Detectable"/>
                                            <f:selectItem itemValue="N" itemLabel="No detectable"/>
                                             <a4j:support id="supportMenuGenotificacion16" event="onclick"
                                                 action="#{lecturaVphBean.changeAdicionDetectable}"
                                                 reRender="fieldDatosLectura,panelDatosLEctura,textInterpretacion">
                                                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                             </a4j:support>
                                            </h:selectOneRadio>
                                        <a4j:outputPanel ajaxRendered="true">
                                            <t:message for="mnuGeno16" styleClass="errorMessage"/>
                                        </a4j:outputPanel>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <h:outputText value="18" styleClass="labelTextOblig"/>
                                        <h:selectOneRadio id="mnuGeno18" required="true" immediate="true"
                                                          onkeydown="return blockEnter(event);"
                                                          value="#{lecturaVphBean.lectura.ccvcgt18}"
                                                          valueChangeListener="#{lecturaVphBean.setCcvcgt18}">
                                            <f:selectItem itemValue="S" itemLabel="Detectable"/>
                                            <f:selectItem itemValue="N" itemLabel="No detectable"/>
                                             <a4j:support id="supportMenuGenotificacion18" event="onclick"
                                                 action="#{lecturaVphBean.changeAdicionDetectable}"
                                                 reRender="fieldDatosLectura,panelDatosLEctura,textInterpretacion">
                                                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                             </a4j:support>
                                        </h:selectOneRadio>
                                        <a4j:outputPanel ajaxRendered="true">
                                            <t:message for="mnuGeno18" styleClass="errorMessage"/>
                                        </a4j:outputPanel>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <h:outputText value="31" styleClass="labelTextOblig"/>
                                        <h:selectOneRadio id="mnuGeno31" required="true" immediate="true"
                                                          onkeydown="return blockEnter(event);"
                                                          value="#{lecturaVphBean.lectura.ccvcgt31}"
                                                          valueChangeListener="#{lecturaVphBean.setCcvcgt31}">
                                            <f:selectItem itemValue="S" itemLabel="Detectable"/>
                                            <f:selectItem itemValue="N" itemLabel="No detectable"/>
                                              <a4j:support id="supportMenuGenotificacion31" event="onclick"
                                                 action="#{lecturaVphBean.changeAdicionDetectable}"
                                                 reRender="fieldDatosLectura,panelDatosLEctura,textInterpretacion">
                                                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                             </a4j:support>
                                        </h:selectOneRadio>
                                        <a4j:outputPanel ajaxRendered="true">
                                            <t:message for="mnuGeno31" styleClass="errorMessage"/>
                                        </a4j:outputPanel>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <h:outputText value="45" styleClass="labelTextOblig"/>
                                        <h:selectOneRadio id="mnuGeno45" required="true" immediate="true"
                                                          onkeydown="return blockEnter(event);"
                                                          value="#{lecturaVphBean.lectura.ccvcgt45}"
                                                          valueChangeListener="#{lecturaVphBean.setCcvcgt45}">
                                            <f:selectItem itemValue="S" itemLabel="Detectable"/>
                                            <f:selectItem itemValue="N" itemLabel="No detectable"/>
                                              <a4j:support id="supportMenuGenotificacion45" event="onclick"
                                                 action="#{lecturaVphBean.changeAdicionDetectable}"
                                                 reRender="fieldDatosLectura,panelDatosLEctura,textInterpretacion">
                                                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                             </a4j:support>
                                        </h:selectOneRadio>
                                        <a4j:outputPanel ajaxRendered="true">
                                            <t:message for="mnuGeno45" styleClass="errorMessage"/>
                                        </a4j:outputPanel>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <h:outputText value="51" styleClass="labelTextOblig"/>
                                        <h:selectOneRadio id="mnuGeno51" required="true" immediate="true"
                                                          onkeydown="return blockEnter(event);"
                                                          value="#{lecturaVphBean.lectura.ccvcgt51}"
                                                          valueChangeListener="#{lecturaVphBean.setCcvcgt51}">
                                            <f:selectItem itemValue="S" itemLabel="Detectable"/>
                                            <f:selectItem itemValue="N" itemLabel="No detectable"/>
                                              <a4j:support id="supportMenuGenotificacion51" event="onclick"
                                                 action="#{lecturaVphBean.changeAdicionDetectable}"
                                                 reRender="fieldDatosLectura,panelDatosLEctura,textInterpretacion">
                                                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                             </a4j:support>
                                        </h:selectOneRadio>
                                        <a4j:outputPanel ajaxRendered="true">
                                            <t:message for="mnuGeno51" styleClass="errorMessage"/>
                                        </a4j:outputPanel>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <h:outputText value="52" styleClass="labelTextOblig"/>
                                        <h:selectOneRadio id="mnuGeno52" required="true" immediate="true"
                                                          onkeydown="return blockEnter(event);"
                                                          value="#{lecturaVphBean.lectura.ccvcgt52}"
                                                          valueChangeListener="#{lecturaVphBean.setCcvcgt52}">
                                            <f:selectItem itemValue="S" itemLabel="Detectable"/>
                                            <f:selectItem itemValue="N" itemLabel="No detectable"/>
                                              <a4j:support id="supportMenuGenotificacion52" event="onclick"
                                                 action="#{lecturaVphBean.changeAdicionDetectable}"
                                                 reRender="fieldDatosLectura,panelDatosLEctura,textInterpretacion">
                                                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                             </a4j:support>
                                        </h:selectOneRadio>
                                        <a4j:outputPanel ajaxRendered="true">
                                            <t:message for="mnuGeno52" styleClass="errorMessage"/>
                                        </a4j:outputPanel>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <h:outputText value="Grupo 1(33,58)" styleClass="labelTextOblig"/>
                                        <h:selectOneRadio id="mnuGeno33-58" required="true" immediate="true"
                                                          onkeydown="return blockEnter(event);"
                                                          value="#{lecturaVphBean.lectura.ccvcgt3858}"
                                                          valueChangeListener="#{lecturaVphBean.setCcvcgt3858}">
                                            <f:selectItem itemValue="S" itemLabel="Detectable"/>
                                            <f:selectItem itemValue="N" itemLabel="No detectable"/>
                                              <a4j:support id="supportMenuGenotificacion33" event="onclick"
                                                 action="#{lecturaVphBean.changeAdicionDetectable}"
                                                 reRender="fieldDatosLectura,panelDatosLEctura,textInterpretacion">
                                                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                             </a4j:support>
                                        </h:selectOneRadio>
                                        <a4j:outputPanel ajaxRendered="true">
                                            <t:message for="mnuGeno33-58" styleClass="errorMessage"/>
                                        </a4j:outputPanel>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <h:outputText value=" Grupo 2(56,59,66)" styleClass="labelTextOblig"/>
                                        <h:selectOneRadio id="mnuGeno56-59-66" required="true" immediate="true"
                                                          onkeydown="return blockEnter(event);"
                                                          value="#{lecturaVphBean.lectura.ccvcgt565966}"
                                                          valueChangeListener="#{lecturaVphBean.setCcvcgt565966}">
                                            <f:selectItem itemValue="S" itemLabel="Detectable"/>
                                            <f:selectItem itemValue="N" itemLabel="No detectable "/>
                                              <a4j:support id="supportMenuGenotificacion56" event="onclick"
                                                 action="#{lecturaVphBean.changeAdicionDetectable}"
                                                 reRender="fieldDatosLectura,panelDatosLEctura,textInterpretacion">
                                                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                             </a4j:support>
                                        </h:selectOneRadio>
                                        <a4j:outputPanel ajaxRendered="true">
                                            <t:message for="mnuGeno56-59-66" styleClass="errorMessage"/>
                                        </a4j:outputPanel>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <h:outputText value=" Grupo 3(35,39,68)" styleClass="labelTextOblig"/>
                                        <h:selectOneRadio id="mnuGeno35-39-68" required="true" immediate="true"
                                                          onkeydown="return blockEnter(event);"
                                                          value="#{lecturaVphBean.lectura.ccvcgt353968}"
                                                          valueChangeListener="#{lecturaVphBean.setCcvcgt353968}">
                                            <f:selectItem itemValue="S" itemLabel="Detectable"/>
                                            <f:selectItem itemValue="N" itemLabel="No detectable"/>
                                              <a4j:support id="supportMenuGenotificacion35" event="onclick"
                                                 action="#{lecturaVphBean.changeAdicionDetectable}"
                                                 reRender="fieldDatosLectura,panelDatosLEctura,textInterpretacion">
                                                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                             </a4j:support>
                                        </h:selectOneRadio>
                                        <a4j:outputPanel ajaxRendered="true">
                                            <t:message for="mnuGeno35-39-68" styleClass="errorMessage"/>
                                        </a4j:outputPanel>
                                    </h:panelGroup>
                                </h:panelGrid>
                            </h:panelGrid>
                        </s:fieldset>
                        <s:fieldset legend="Datos Lectura" id="fieldDatosLectura" styleClass="fieldset">
                            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                                         id="panelDatosLEctura" rowClasses="labelText,labelTextInfo">
                                <h:outputText value="Interpretación" styleClass="labelTextOblig"/>
                                <h:outputText value="Fecha de Recepcion de la Toma" styleClass="labelTextOblig"/>
                                <h:panelGroup>
                                    <h:inputTextarea id="textInterpretacion" required="true"
                                                     onkeydown="return blockEnter(event);" immediate="true"
                                                     value="#{lecturaVphBean.lectura.ccvcinterpre}"
                                                     style="width:500px;height:60px">
                                        <f:validateLength maximum="250"/>
                                    </h:inputTextarea>
                                    <a4j:outputPanel ajaxRendered="true">
                                        <t:message for="textInterpretacion" styleClass="errorMessage"/>
                                    </a4j:outputPanel>
                                </h:panelGroup>
                                <h:panelGroup>
                                    <t:inputCalendar id="fechaRecep" title="Formato: dd/mm/yyyy"
                                                     onkeydown="return blockEnter(event);"
                                                     monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                                     currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                                     renderAsPopup="true" value="#{lecturaVphBean.lectura.ccvdfecrecep}"
                                                     popupTodayString="Hoy" popupWeekString="Semana"
                                                     popupButtonString="Fecha" readonly="false" maxlength="11" size="11"
                                                     popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                                     renderPopupButtonAsImage="true" align="top" immediate="true"
                                                     />
                                    <a4j:outputPanel ajaxRendered="true">
                                        <t:message for="fechaRecep" styleClass="errorMessage"/>
                                    </a4j:outputPanel>
                                </h:panelGroup>
                            </h:panelGrid>
                        </s:fieldset>
                    </h:panelGrid>
                    <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                                 id="panelBotonVisualzarLectura" columnClasses="panelGridBotones">
                        <h:commandButton value="Guardar Lectura" id="botonGuardarLectura"
                                         styleClass="boton_fieldset_Naranja" action="#{lecturaVphBean.aceptar}"
                                         onclick="if(!confirm(\'Esta seguro de guardar la Lectura?\')){ return false; }"></h:commandButton>
                        <h:commandButton value="Pre-Visualizar Lectura" styleClass="boton_fieldset" id="botonVisualizar"
                                         action="#{lecturaVphBean.preVisualizarLectura}">
                            <a4j:support event="onclick" status="statusButton"/>
                        </h:commandButton>
                    </h:panelGrid>
                    <t:htmlTag value="br"/>
                    <h:panelGrid>
                        <h:panelGroup>
                            <a4j:outputPanel id="ajaxRegionMsgLecturaVph" ajaxRendered="true">
                                <t:htmlTag value="br"/>
                                <t:messages id="msgLecturaVph" showSummary="true" errorClass="error" globalOnly="true"
                                            layout="table" infoClass="informacion"/>
                            </a4j:outputPanel>
                        </h:panelGroup>
                    </h:panelGrid>
                </t:panelTab>
                <s:fieldset legend="Datos Registrados" id="fieldGuardarLectura" styleClass="fieldset_report"
                            rendered="#{lecturaVphBean.generoLectura}">
                    <a4j:region renderRegionOnly="false">
                        <jsp:include page="/pages/clinico/comunes/mostrarLecturaCitologia.jsp" flush="true"/>
                    </a4j:region>
                </s:fieldset>
                
              
            </t:panelTabbedPane>
        </h:panelGrid>
    </a4j:region>
</a4j:form>