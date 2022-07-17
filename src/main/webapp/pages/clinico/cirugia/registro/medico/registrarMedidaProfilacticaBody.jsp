<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<a4j:form id="formMedidaProfilactica">
  <a4j:region id="regionMedidaProfilactica" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionMedidaProfilactica">
      <f:facet name="start">
        <t:div id="chargingMedidaProfilactica" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
  
   
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridMedidaProfilacticaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneMedidaProfilactica"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabMedidaProfilactica" label="Medida Profilactica">
          <s:fieldset legend="Posición" id="fieldPosicion"
                      styleClass="fieldset">
            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelPosicion"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Posición Básica" styleClass="labelTextOblig"/>
              <h:outputText value="Modificación posición" styleClass="labelTextOblig"/>
              <h:panelGroup id="panelTextCual">
                <h:outputText value="Cual" styleClass="labelTextOblig"
                              rendered="#{registrarMedidaProfilacticaBean.mostrarmodificacion}"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneMenu id="mnuPosicion" required="true"
                                 value="#{registrarMedidaProfilacticaBean.medida.hpacposicbasic}">
                  <f:selectItems value="#{registrarMedidaProfilacticaBean.lstBasica}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuPosicion" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectOneMenu id="mnuModificacion" immediate="true" required="true"
                                   value="#{registrarMedidaProfilacticaBean.medida.hpacmodifposic}"
                                   valueChangeListener="#{registrarMedidaProfilacticaBean.setHpacmodifposic}">
                    <f:selectItems value="#{registrarMedidaProfilacticaBean.lstModificacion}"/>
                    <a4j:support id="supportModificacion" event="onchange"
                                 immediate="true"
                                 action="#{registrarMedidaProfilacticaBean.changeModificacion}"
                                 reRender="panelTextCual,panelInputCual">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuModificacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
              <h:panelGroup id="panelInputCual">
                <h:inputText id="itCualModificacion" required="true"
                             value="#{registrarMedidaProfilacticaBean.medida.hpacotraposici}"
                             rendered="#{registrarMedidaProfilacticaBean.mostrarmodificacion}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCualModificacion"
                             styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Cambio de posición" id="fieldCambioPosicion"
                      styleClass="fieldset">
            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelCambioPosicion"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Fecha Cambio"/>
              <h:outputText value="Hora Cambio"/>
              <h:outputText value=""/>
              <h:panelGroup id="panelFechaInicioCambio">
                <t:inputCalendar id="fechaInicioCambio"
                                  onkeydown="return blockEnter(event);"
                                 monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader" immediate="true"
                                 title="Formato: dd/mm/yyyy"
                                 currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy"
                                 renderAsPopup="true"
                                 value="#{registrarMedidaProfilacticaBean.medida.hpadhoracampos}"
                                 popupTodayString="Hoy" popupWeekString="Semana"
                                 popupButtonString="Fecha" readonly="false"
                                 maxlength="11" size="11"
                                 popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top"
                                 required="false"></t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaInicioCambio" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id="panelHoraInicioCambio">
                <h:panelGroup>
                  <h:selectOneMenu id="mnuHoraInicioCambio" required="false"
                                   immediate="true"
                                   value="#{registrarMedidaProfilacticaBean.horainiciocambio}">
                    <f:selectItems value="#{registrarMedidaProfilacticaBean.listHora}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuHoraInicioCambio"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=" : "/>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuMinutosInicioCambio" required="false"
                                   immediate="true"
                                   value="#{registrarMedidaProfilacticaBean.minutoiniciocambio}">
                    <f:selectItems value="#{registrarMedidaProfilacticaBean.lstMinutos}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMinutosInicioCambio"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
              <h:panelGroup/>
              <h:outputText value="Nueva Posición Básica"/>
              <h:outputText value="Modificación posición"/>
              <h:panelGroup id="panelTextCualCambio">
                <h:outputText value="Cual" styleClass="labelTextOblig"
                              rendered="#{registrarMedidaProfilacticaBean.mostrarmodificacioncambio}"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneMenu id="mnuPosicionCambio" required="false"
                                 value="#{registrarMedidaProfilacticaBean.medida.hpacnuevabasic}">
                  <f:selectItems value="#{registrarMedidaProfilacticaBean.lstBasica}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuPosicionCambio" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectOneMenu id="mnuModificacionCambio" immediate="true" required="false"
                                   value="#{registrarMedidaProfilacticaBean.medida.hpacnuevamodif}"
                                   valueChangeListener="#{registrarMedidaProfilacticaBean.setHpacnuevamodif}">
                    <f:selectItems value="#{registrarMedidaProfilacticaBean.lstModificacion}"/>
                    <a4j:support id="supportModificacionCambio" event="onchange"
                                 immediate="true"
                                 action="#{registrarMedidaProfilacticaBean.changeModificacionCambio}"
                                 reRender="panelTextCualCambio,panelInputCualCambio">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuModificacionCambio"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
              <h:panelGroup id="panelInputCualCambio">
                <h:inputText id="itCualModificacionCambio" required="true"
                             value="#{registrarMedidaProfilacticaBean.medida.hpacnuevaotra}"
                             rendered="#{registrarMedidaProfilacticaBean.mostrarmodificacioncambio}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCualModificacionCambio"
                             styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Medidas de Protección"
                      id="fieldMedidaProfilactica" styleClass="fieldset">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelMedidasProteccion"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Protección puntos de presión"/>
              <h:outputText value=""/>
              <h:panelGroup>
                <h:selectBooleanCheckbox id="checkMedidasProteccion" required="false"
                                         value="#{registrarMedidaProfilacticaBean.proteccionpuntos}">
                </h:selectBooleanCheckbox>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="checkMedidasProteccion"
                             styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:outputText value="Protección ocular"/>
              <h:panelGroup id="panelTextTipoProteccion">
                <h:outputText value="Tipo de Protección" styleClass="labelTextOblig"
                              rendered="#{registrarMedidaProfilacticaBean.proteccionocular}"/>
              </h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectBooleanCheckbox id="checkMedidasProteccionOcular"
                                           immediate="true" required="false"
                                           value="#{registrarMedidaProfilacticaBean.proteccionocular}"
                                           valueChangeListener="#{registrarMedidaProfilacticaBean.setProteccionocular}">
                    <a4j:support id="supportMedidasProteccion" event="onclick"
                                 immediate="true" action="#{registrarMedidaProfilacticaBean.ChangeProteccion}"
                                 reRender="panelTextTipoProteccion,panelInputTipoProteccion">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectBooleanCheckbox>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="checkMedidasProteccionOcular"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
              <h:panelGroup id="panelInputTipoProteccion">
                <h:inputText id="itProteccion" required="true" 
                             rendered="#{registrarMedidaProfilacticaBean.proteccionocular}"
                             value="#{registrarMedidaProfilacticaBean.medida.hpacproteocula}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itProteccion" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Compresión neumática intermitente en miembros inferiores "/>
              <h:outputText value=""/>
              <h:panelGroup>
                <h:selectBooleanCheckbox id="checkMedidasCompresionNeumatica" required="true"
                                         value="#{registrarMedidaProfilacticaBean.compresionneumatica}"></h:selectBooleanCheckbox>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="checkMedidasCompresionNeumatica"
                             styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value=""/>
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Torniquete" id="fieldTorniquete"
                      styleClass="fieldset">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelTorniquete"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Torniquete" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
       
             <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="itTorniquete" immediate="true" required="true"
                                  value="#{registrarMedidaProfilacticaBean.medida.hpactorniquete}"
                                  valueChangeListener="#{registrarMedidaProfilacticaBean.setHpactorniquete}">
                  <f:selectItems value="#{registrarMedidaProfilacticaBean.lstOpciones}"/>
                     <a4j:support id="supportTorniquete" event="onclick"
                                 action="#{registrarMedidaProfilacticaBean.changeTorniquete}"
                                 immediate="true"
                                 reRender="itFechaInicio,itHoraInicio,panelFechaInicio,panelHoraInicio,panelTextLugarTorniquete,panelTextPresionInflado,panelInputLugarTorniquete,panelInputPresionInflado,itFechaFin,itHoraFin,panelFechaFin,panelHoraFin">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itTorniquete" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              </a4j:region>
              <h:outputText value=""/>
              <h:panelGroup id = "itFechaInicio">
                <h:outputText value="Fecha Inicio" styleClass="labelTextOblig"
                              rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}"/>
              </h:panelGroup>
              <h:panelGroup id = "itHoraInicio">
                <h:outputText value="Hora Inicio" styleClass="labelTextOblig"
                              rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}"/>
              </h:panelGroup>
              <h:panelGroup id="panelFechaInicio">
                <t:inputCalendar id="fechaInicio" 
                                 rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}"
                                 onkeydown="return blockEnter(event);"
                                 monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader" immediate="true"
                                 title="Formato: dd/mm/yyyy"
                                 currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy"
                                 renderAsPopup="true"
                                 value="#{registrarMedidaProfilacticaBean.medida.hpadhorainicio}"
                                 popupTodayString="Hoy" popupWeekString="Semana"
                                 popupButtonString="Fecha" readonly="false"
                                 maxlength="11" size="11"
                                 popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top"
                                 required="true"></t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}">
                  <t:message for="fechaInicio" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id="panelHoraInicio">
                <h:panelGroup>
                  <h:selectOneMenu id="mnuHoraInicio" required="true"
                                   rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}"
                                   immediate="true"
                                   value="#{registrarMedidaProfilacticaBean.horainicio}">
                    <f:selectItems value="#{registrarMedidaProfilacticaBean.listHora}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true"
                                   rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}">
                    <t:message for="mnuHoraInicio" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=" : "
                              rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}"/>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuMinutosInicio" required="true"
                                   immediate="true"
                                   rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}"
                                   value="#{registrarMedidaProfilacticaBean.minutoinicio}">
                    <f:selectItems value="#{registrarMedidaProfilacticaBean.lstMinutos}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true"
                                   rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}">
                    <t:message for="mnuMinutosInicio"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
              
              
              
                 <h:panelGroup id = "itFechaFin">
                <h:outputText value="Fecha Fin" styleClass="labelTextOblig"
                              rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}"/>
              </h:panelGroup>
              <h:panelGroup id = "itHoraFin">
                <h:outputText value="Hora Fin" styleClass="labelTextOblig"
                              rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}"/>
              </h:panelGroup>
              <h:panelGroup id="panelFechaFin">
                <t:inputCalendar id="fechaFin" 
                                 rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}"
                                 onkeydown="return blockEnter(event);"
                                 monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader" immediate="true"
                                 title="Formato: dd/mm/yyyy"
                                 currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy"
                                 renderAsPopup="true"
                                 value="#{registrarMedidaProfilacticaBean.medida.hpadhorafin}"
                                 popupTodayString="Hoy" popupWeekString="Semana"
                                 popupButtonString="Fecha" readonly="false"
                                 maxlength="11" size="11"
                                 popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top"
                                 required="true"></t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}">
                  <t:message for="fechaFin" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id="panelHoraFin">
                <h:panelGroup>
                  <h:selectOneMenu id="mnuHoraFin" required="true"
                                   rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}"
                                   immediate="true"
                                   value="#{registrarMedidaProfilacticaBean.horafin}">
                    <f:selectItems value="#{registrarMedidaProfilacticaBean.listHora}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true"
                                   rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}">
                    <t:message for="mnuHoraFin" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=" : "
                              rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}"/>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuMinutosFin" required="true"
                                   immediate="true"
                                   rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}"
                                   value="#{registrarMedidaProfilacticaBean.minutofin}">
                    <f:selectItems value="#{registrarMedidaProfilacticaBean.lstMinutos}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true"
                                   rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}">
                    <t:message for="mnuMinutosFin"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
              
              
              
              
              
              <h:panelGroup id = "panelTextLugarTorniquete">
                <h:outputText value="Lugar del Torniquete " styleClass="labelTextOblig"
                              rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}"/>
              </h:panelGroup>
              <h:panelGroup id = "panelTextPresionInflado">
                <h:outputText value="Presión de inflado (mmHg)" styleClass="labelTextOblig"
                              rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}"/>
              </h:panelGroup>
              <h:panelGroup id = "panelInputLugarTorniquete">
                <h:inputText id="itLugarTorniquete" required="true"
                             rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}"
                             value="#{registrarMedidaProfilacticaBean.medida.hpaclugartorni}"/>
                 <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itLugarTorniquete" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id = "panelInputPresionInflado">
                <h:inputText id="itPresionInflado" maxlength="3" required="true"
                             style="width:50px"
                             rendered="#{registrarMedidaProfilacticaBean.mostrartorniquete}"
                             value="#{registrarMedidaProfilacticaBean.medida.hpanpresiinfla}"/>
                             <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itPresionInflado" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelTorniqueteObservaciones"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Observaciones"/>
              <h:inputTextarea id="itObservaciones" style="width:600px"
                               value="#{registrarMedidaProfilacticaBean.medida.hpacobservacio}"/>
                   <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itObservaciones" styleClass="errorMessage"/>
                </a4j:outputPanel>
            </h:panelGrid>
          </s:fieldset>
        </t:panelTab>
      </t:panelTabbedPane>
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                   width="100%" id="panelBotonModificar"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                           action="#{registrarMedidaProfilacticaBean.RegistrarMedidaProfilactica}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
      <h:panelGrid>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrors1" showSummary="true"
                        errorClass="error" globalOnly="true" layout="table"
                        infoClass="informacion"/>
          </a4j:outputPanel>
        </h:panelGroup>
      </h:panelGrid>
    </h:panelGrid>
  </a4j:region>
</a4j:form>