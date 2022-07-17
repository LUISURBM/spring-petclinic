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
                                                     value="#{lecturaVphModBean.lectura.ccvclectur}">
                                        <f:selectItem itemValue="15" itemLabel="Bacterióloga"/>
                                    </h:selectOneMenu>
                                    <a4j:outputPanel ajaxRendered="true">
                                        <t:message for="menuVphLeida" styleClass="errorMessage"/>
                                    </a4j:outputPanel>
                                </h:panelGroup>
                                <h:panelGroup>
                                    <h:inputText id="itNombreLectura" required="true" maxlength="30" immediate="true"
                                                 value="#{lecturaVphModBean.lectura.ccvcnomlec}"/>
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
                                                     value="#{lecturaVphModBean.lectura.ccvcobserv}">
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
                                                          value="#{lecturaVphModBean.lectura.ccvcgenoneg}"
                                                          valueChangeListener="#{lecturaVphModBean.setCcvcgenoneg}">
                                            <f:selectItem itemValue="S" itemLabel="No detectable"/>
                                            <f:selectItem itemValue="N" itemLabel="Detectable"/>
                                            <f:selectItem itemValue="NS" itemLabel="No satisfactoria"/>
                                            <a4j:support id="supportGenotipicacion" event="onclick"
                                                         action="#{lecturaVphModBean.changeGenotipificacion}"
                                                         reRender="panelGenotipicacionGral">
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
                                             rendered="#{lecturaVphModBean.mostrarGenotipificacion}" width="100%"
                                             id="panelGenotipicacion" rowClasses="labelText,labelTextInfo">
                                    <h:panelGroup>
                                        <h:outputText value="16" styleClass="labelTextOblig"/>
                                        <h:selectOneRadio id="mnuGeno16" required="true" immediate="true"
                                                          onkeydown="return blockEnter(event);"
                                                          value="#{lecturaVphModBean.lectura.ccvcgt16}"
                                                          valueChangeListener="#{lecturaVphModBean.setCcvcgt16}">
                                            <f:selectItem itemValue="S" itemLabel="Detectable"/>
                                            <f:selectItem itemValue="N" itemLabel="No detectable"/>
                                        </h:selectOneRadio>
                                        <a4j:outputPanel ajaxRendered="true">
                                            <t:message for="mnuGeno16" styleClass="errorMessage"/>
                                        </a4j:outputPanel>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <h:outputText value="18" styleClass="labelTextOblig"/>
                                        <h:selectOneRadio id="mnuGeno18" required="true" immediate="true"
                                                          onkeydown="return blockEnter(event);"
                                                          value="#{lecturaVphModBean.lectura.ccvcgt18}"
                                                          valueChangeListener="#{lecturaVphModBean.setCcvcgt18}">
                                            <f:selectItem itemValue="S" itemLabel="Detectable"/>
                                            <f:selectItem itemValue="N" itemLabel="No detectable"/>
                                        </h:selectOneRadio>
                                        <a4j:outputPanel ajaxRendered="true">
                                            <t:message for="mnuGeno18" styleClass="errorMessage"/>
                                        </a4j:outputPanel>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <h:outputText value="31" styleClass="labelTextOblig"/>
                                        <h:selectOneRadio id="mnuGeno31" required="true" immediate="true"
                                                          onkeydown="return blockEnter(event);"
                                                          value="#{lecturaVphModBean.lectura.ccvcgt31}"
                                                          valueChangeListener="#{lecturaVphModBean.setCcvcgt31}">
                                            <f:selectItem itemValue="S" itemLabel="Detectable"/>
                                            <f:selectItem itemValue="N" itemLabel="No detectable"/>
                                        </h:selectOneRadio>
                                        <a4j:outputPanel ajaxRendered="true">
                                            <t:message for="mnuGeno31" styleClass="errorMessage"/>
                                        </a4j:outputPanel>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <h:outputText value="45" styleClass="labelTextOblig"/>
                                        <h:selectOneRadio id="mnuGeno45" required="true" immediate="true"
                                                          onkeydown="return blockEnter(event);"
                                                          value="#{lecturaVphModBean.lectura.ccvcgt45}"
                                                          valueChangeListener="#{lecturaVphModBean.setCcvcgt45}">
                                            <f:selectItem itemValue="S" itemLabel="Detectable"/>
                                            <f:selectItem itemValue="N" itemLabel="No detectable"/>
                                        </h:selectOneRadio>
                                        <a4j:outputPanel ajaxRendered="true">
                                            <t:message for="mnuGeno45" styleClass="errorMessage"/>
                                        </a4j:outputPanel>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <h:outputText value="51" styleClass="labelTextOblig"/>
                                        <h:selectOneRadio id="mnuGeno51" required="true" immediate="true"
                                                          onkeydown="return blockEnter(event);"
                                                          value="#{lecturaVphModBean.lectura.ccvcgt51}"
                                                          valueChangeListener="#{lecturaVphModBean.setCcvcgt51}">
                                            <f:selectItem itemValue="S" itemLabel="Detectable"/>
                                            <f:selectItem itemValue="N" itemLabel="No detectable"/>
                                        </h:selectOneRadio>
                                        <a4j:outputPanel ajaxRendered="true">
                                            <t:message for="mnuGeno51" styleClass="errorMessage"/>
                                        </a4j:outputPanel>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <h:outputText value="52" styleClass="labelTextOblig"/>
                                        <h:selectOneRadio id="mnuGeno52" required="true" immediate="true"
                                                          onkeydown="return blockEnter(event);"
                                                          value="#{lecturaVphModBean.lectura.ccvcgt52}"
                                                          valueChangeListener="#{lecturaVphModBean.setCcvcgt52}">
                                            <f:selectItem itemValue="S" itemLabel="Detectable"/>
                                            <f:selectItem itemValue="N" itemLabel="No detectable"/>
                                        </h:selectOneRadio>
                                        <a4j:outputPanel ajaxRendered="true">
                                            <t:message for="mnuGeno52" styleClass="errorMessage"/>
                                        </a4j:outputPanel>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <h:outputText value="Grupo 1(33,58)" styleClass="labelTextOblig"/>
                                        <h:selectOneRadio id="mnuGeno33-58" required="true" immediate="true"
                                                          onkeydown="return blockEnter(event);"
                                                          value="#{lecturaVphModBean.lectura.ccvcgt3858}"
                                                          valueChangeListener="#{lecturaVphModBean.setCcvcgt3858}">
                                            <f:selectItem itemValue="S" itemLabel="Detectable"/>
                                            <f:selectItem itemValue="N" itemLabel="No detectable"/>
                                        </h:selectOneRadio>
                                        <a4j:outputPanel ajaxRendered="true">
                                            <t:message for="mnuGeno33-58" styleClass="errorMessage"/>
                                        </a4j:outputPanel>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <h:outputText value=" Grupo 2(56,59,66)" styleClass="labelTextOblig"/>
                                        <h:selectOneRadio id="mnuGeno56-59-66" required="true" immediate="true"
                                                          onkeydown="return blockEnter(event);"
                                                          value="#{lecturaVphModBean.lectura.ccvcgt565966}"
                                                          valueChangeListener="#{lecturaVphModBean.setCcvcgt565966}">
                                            <f:selectItem itemValue="S" itemLabel="Detectable"/>
                                            <f:selectItem itemValue="N" itemLabel="No detectable "/>
                                        </h:selectOneRadio>
                                        <a4j:outputPanel ajaxRendered="true">
                                            <t:message for="mnuGeno56-59-66" styleClass="errorMessage"/>
                                        </a4j:outputPanel>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <h:outputText value=" Grupo 3(35,39,68)" styleClass="labelTextOblig"/>
                                        <h:selectOneRadio id="mnuGeno35-39-68" required="true" immediate="true"
                                                          onkeydown="return blockEnter(event);"
                                                          value="#{lecturaVphModBean.lectura.ccvcgt353968}"
                                                          valueChangeListener="#{lecturaVphModBean.setCcvcgt353968}">
                                            <f:selectItem itemValue="S" itemLabel="Detectable"/>
                                            <f:selectItem itemValue="N" itemLabel="No detectable"/>
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
                                                     value="#{lecturaVphModBean.lectura.ccvcinterpre}"
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
                                                     renderAsPopup="true" value="#{lecturaVphModBean.lectura.ccvdfecrecep}"
                                                     popupTodayString="Hoy" popupWeekString="Semana"
                                                     popupButtonString="Fecha" readonly="false" maxlength="11" size="11"
                                                     popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                                     renderPopupButtonAsImage="true" align="top" immediate="true"
                                                     required="true"/>
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
                                         styleClass="boton_fieldset_Naranja" action="#{lecturaVphModBean.aceptar}"
                                         onclick="if(!confirm(\'Esta seguro de guardar la Lectura?\')){ return false; }"></h:commandButton>
                        <h:commandButton value="Pre-Visualizar Lectura" styleClass="boton_fieldset" id="botonVisualizar"
                                         action="#{lecturaVphModBean.preVisualizarLectura}">
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
                            rendered="#{lecturaVphModBean.generoLectura}">
                    <a4j:region renderRegionOnly="false">
                        <jsp:include page="/pages/clinico/comunes/mostrarLecturaCitologia.jsp" flush="true"/>
                    </a4j:region>
                </s:fieldset>
            </t:panelTabbedPane>
        </h:panelGrid>
    </a4j:region>
</a4j:form>