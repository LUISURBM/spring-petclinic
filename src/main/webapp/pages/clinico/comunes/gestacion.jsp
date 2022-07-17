<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridFormulaMedicaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneGestacion" styleClass="tabbedPane" activeTabStyleClass="activeTab"
                     inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                     activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabGestacion" label="Gestación">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="tableContentTabsGestacionPrenatal" styleClass="tabContainer">
        <h:panelGrid columns="2" id="tableInfoUbicationSemanaPrenatal1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" columnClasses="td_alertas">
          <h:outputText styleClass="lableTextOblig" value="  Numero de Semanas de embarazo: "/>
          <h:outputText value="#{examenFisicoPrenatalUsuarioBean.semanaGestacion}">
            <f:convertNumber maxFractionDigits="2"/>
          </h:outputText>
        </h:panelGrid>
        <s:fieldset legend="Gestación Prenatal" id="fieldGestacionPrenatal" styleClass="fieldset">
          <a4j:region renderRegionOnly="false">
            <h:panelGrid columns="7">
              <h:outputText value="[ " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value=" Todos SI" immediate="true"
                               action="#{gestacionPrenatalUsuarioBean.changeTodosSi}"
                               reRender="panelGestacionPrenatal"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true"
                               action="#{gestacionPrenatalUsuarioBean.changeTodosNo}"
                               reRender="panelGestacionPrenatal"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true"
                               action="#{gestacionPrenatalUsuarioBean.changeNinguno}"
                               reRender=" panelGestacionPrenatal"/>
              <h:outputText value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
            </h:panelGrid>
          </a4j:region>
          <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGestacionPrenatal"
                       rowClasses="labelCuestionario3,labelCuestionario4">
            <h:outputText value="Antitetanica Previa" styleClass="labelTextNoOblig"/>
            <h:outputText value="Antitetanica Actual 1ra Dosis" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="itFechaDosis1">
              <h:outputText value="Fecha 1ra Dosis " styleClass="labelTextOblig"
                            rendered="#{gestacionPrenatalUsuarioBean.mostrarFechaAntitetanica}"/>
            </h:panelGroup>
            <h:outputText value="Antitetanica Actual 2da Dosis" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="itFechaDosis2">
              <h:outputText value="Fecha  2da Dosis" styleClass="labelTextOblig"
                            rendered="#{gestacionPrenatalUsuarioBean.mostrarFechaAntitetanica2}"/>
            </h:panelGroup>
            <h:panelGroup>
              <h:selectOneRadio id="mnuAntitetanicaPrevia" onkeydown="return blockEnter(event);"
                                disabled="#{gestacionPrenatalUsuarioBean.desAntitetanicaPrevia}"
                                value="#{gestacionPrenatalUsuarioBean.gestacion.hgeeprevantite}"
                                styleClass="labelRadio">
                <f:selectItems value="#{gestacionPrenatalUsuarioBean.lstOpciones}"/>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuAntitetanicaPrevia" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuAntitetanicaActual" onkeydown="return blockEnter(event);" immediate="true"
                                  binding="#{gestacionPrenatalUsuarioBean.mnuAntitetanicaPrevia}"
                                  disabled="#{gestacionPrenatalUsuarioBean.desAntitetanicaActual1}"
                                  value="#{gestacionPrenatalUsuarioBean.gestacion.hgeeantidosis1}"
                                  valueChangeListener="#{gestacionPrenatalUsuarioBean.setAntitetanicaActual}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{gestacionPrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportAntitetanicaActua" event="onclick" immediate="true"
                               action="#{gestacionPrenatalUsuarioBean.ChangeAntitetanica}"
                               reRender="itFechaDosis1,itCalendarFechaDosis1">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntitetanicaActual" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="itCalendarFechaDosis1">
              <t:inputCalendar id="fechaAntitetanicaDosis1" onkeydown="return blockEnter(event);"
                               rendered="#{gestacionPrenatalUsuarioBean.mostrarFechaAntitetanica}"
                               disabled="#{gestacionPrenatalUsuarioBean.desAntitetanicaActual1}"
                               title="Formato: dd/mm/yyyy" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                               currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{gestacionPrenatalUsuarioBean.gestacion.hgedfecantdos1}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechaAntitetanicaDosis1" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuAntitetanicaActual2" onkeydown="return blockEnter(event);"
                                  disabled="#{gestacionPrenatalUsuarioBean.desAntitetanicaActual2}" immediate="true"
                                  binding="#{gestacionPrenatalUsuarioBean.mnuAntitetanicaActual2}"
                                  value="#{gestacionPrenatalUsuarioBean.gestacion.hgeeantidosis2}"
                                  valueChangeListener="#{gestacionPrenatalUsuarioBean.setAntitetanicaActual2}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{gestacionPrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportAntitetanicaActual2" event="onclick" immediate="true"
                               action="#{gestacionPrenatalUsuarioBean.ChangeAntitetanica2}"
                               reRender="itFechaDosis2,itCalendarFechaDosis2">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntitetanicaActual2" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="itCalendarFechaDosis2">
              <t:inputCalendar id="fechaAntitetanicaDosis2" onkeydown="return blockEnter(event);"
                               disabled="#{gestacionPrenatalUsuarioBean.desAntitetanicaActual2}"
                               title="Formato: dd/mm/yyyy"
                               rendered="#{gestacionPrenatalUsuarioBean.mostrarFechaAntitetanica2}"
                               monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                               currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{gestacionPrenatalUsuarioBean.gestacion.hgedfecantdos2}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechaAntitetanicaDosis2" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="Antirubeola Previa" styleClass="labelTextNoOblig"/>
            <h:outputText value="Antirubeola Actual" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="panelOutputTextAntirubeola">
              <h:outputText value="Fecha Antirubeola Actual"
                            rendered="#{gestacionPrenatalUsuarioBean.mostrarAntirubeola}" styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:panelGroup/>
            <h:panelGroup/>
            <h:panelGroup>
              <h:selectOneRadio id="mnuAntirubeolaPrevia" onkeydown="return blockEnter(event);"
                                disabled="#{gestacionPrenatalUsuarioBean.desAntirubeolaPrevia}" immediate="true"
                                value="#{gestacionPrenatalUsuarioBean.gestacion.hgeepreantrube}"
                                styleClass="labelRadio">
                <f:selectItems value="#{gestacionPrenatalUsuarioBean.lstOpciones}"/>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuAntirubeolaPrevia" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuAntirubeolaActual" onkeydown="return blockEnter(event);"
                                  disabled="#{gestacionPrenatalUsuarioBean.desAntirubeolaActual}" immediate="true"
                                  binding="#{gestacionPrenatalUsuarioBean.mnuAntirubeolaActual}"
                                  value="#{gestacionPrenatalUsuarioBean.gestacion.hgeeactantrube}"
                                  valueChangeListener="#{gestacionPrenatalUsuarioBean.setAntirubeola}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{gestacionPrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportAntirubeolaPrevia" event="onclick" immediate="true"
                               action="#{gestacionPrenatalUsuarioBean.ChangeAntirubeola}"
                               reRender="panelOutputTextAntirubeola,panelFechaAntirubeola">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntirubeolaActual" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelFechaAntirubeola">
              <t:inputCalendar id="fechaAntirubeola" title="Formato: dd/mm/yyyy"
                               disabled="#{gestacionPrenatalUsuarioBean.desAntirubeolaActual}"
                               rendered="#{gestacionPrenatalUsuarioBean.mostrarAntirubeola}"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{gestacionPrenatalUsuarioBean.gestacion.hgedfecantrube}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechaAntirubeola" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup/>
            <h:panelGroup/>
            <h:outputText value="Grupo/RH Paciente" styleClass="labelTextNoOblig"/>
            <h:outputText value="Grupo/RH Esposo" styleClass="labelTextNoOblig"/>
            <h:panelGroup/>
            <h:outputText value="Sensibilización" styleClass="labelTextNoOblig"/>
            <h:outputText value=""/>
            <h:panelGroup>
              <h:panelGroup>
                <h:selectOneMenu id="mnuGrupoPaciente" onkeydown="return blockEnter(event);"
                                 value="#{gestacionPrenatalUsuarioBean.gestacion.hgecgrupopacie}"
                                 disabled="#{gestacionPrenatalUsuarioBean.desGrupoPaciente}" styleClass="labelRadio">
                  <f:selectItems value="#{gestacionPrenatalUsuarioBean.lstGrupo}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuRHPaciente" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneMenu id="mnuRHPaciente" onkeydown="return blockEnter(event);"
                                 disabled="#{gestacionPrenatalUsuarioBean.desRHPaciente}"
                                 value="#{gestacionPrenatalUsuarioBean.gestacion.hgecrhpaciente}"
                                 styleClass="labelRadio">
                  <f:selectItems value="#{gestacionPrenatalUsuarioBean.lstRH}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuRHPaciente" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGroup>
                <h:selectOneMenu id="mnuGrupoEsposo" onkeydown="return blockEnter(event);"
                                 disabled="#{gestacionPrenatalUsuarioBean.desGrupoEsposo}"
                                 value="#{gestacionPrenatalUsuarioBean.gestacion.hgecgrupoespos}"
                                 styleClass="labelRadio">
                  <f:selectItems value="#{gestacionPrenatalUsuarioBean.lstGrupo}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuGrupoEsposo" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneMenu id="mnuRHEsposo" onkeydown="return blockEnter(event);"
                                 disabled="#{gestacionPrenatalUsuarioBean.desRHEsposo}"
                                 value="#{gestacionPrenatalUsuarioBean.gestacion.hgecrhesposo}" styleClass="labelRadio">
                  <f:selectItems value="#{gestacionPrenatalUsuarioBean.lstRH}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuRHEsposo" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup/>
            <h:panelGroup>
              <h:selectOneRadio id="mnuSensibilidad" onkeydown="return blockEnter(event);"
                                disabled="#{gestacionPrenatalUsuarioBean.desSensibilizacion}"
                                value="#{gestacionPrenatalUsuarioBean.gestacion.hgecsensibilid}"
                                styleClass="labelRadio">
                <f:selectItems value="#{gestacionPrenatalUsuarioBean.lstOpciones}"/>
              </h:selectOneRadio>
            </h:panelGroup>
            <h:panelGroup/>
            <h:outputText value="Solicito VIH " styleClass="labelTextNoOblig"/>
            <h:outputText value="Realizo VIH " styleClass="labelTextNoOblig"/>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:panelGroup/>
            <h:panelGroup>
              <h:selectOneRadio id="mnuSolicitoVIH" onkeydown="return blockEnter(event);"
                                disabled="#{gestacionPrenatalUsuarioBean.desSolicitoVIH}"
                                value="#{gestacionPrenatalUsuarioBean.gestacion.hgeesolicivih1}"
                                styleClass="labelRadio">
                <f:selectItems value="#{gestacionPrenatalUsuarioBean.lstOpciones}"/>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuSolicitoVIH" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:selectOneRadio id="mnuRealizoVIH" onkeydown="return blockEnter(event);"
                                disabled="#{gestacionPrenatalUsuarioBean.desRealizoVIH}"
                                value="#{gestacionPrenatalUsuarioBean.gestacion.hgeerealizvih1}"
                                styleClass="labelRadio">
                <f:selectItems value="#{gestacionPrenatalUsuarioBean.lstOpciones}"/>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuRealizoVIH" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Gestación Actual" id="fieldGestacionActual" styleClass="fieldset">
          <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGestacionActual"
                       rowClasses="labelCuestionario3,labelCuestionario4">
            <h:outputText value="Edad gestacional probable" styleClass="labelTextNoOblig"/>
            <h:outputText value="Metodo de confirmacion edad gestacional" styleClass="labelTextNoOblig"/>
            <h:outputText value="Signos y sintomas de la gestacion" styleClass="labelTextNoOblig"/>
            <h:outputText value="Presencia o Ausencia de movimientos fetales" styleClass="labelTextOblig"/>
            <h:panelGroup/>
            <h:panelGroup>
              <h:inputText id="inputEdadProbable" value="#{gestacionPrenatalUsuarioBean.gestacion.hgecedadgest}"
                           style="width:30px"></h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="inputEdadProbable" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:selectOneMenu id="mnuMetodoConfirm" onkeydown="return blockEnter(event);"
                               value="#{gestacionPrenatalUsuarioBean.gestacion.hgecconedages}" styleClass="labelRadio">
                <f:selectItems value="#{gestacionPrenatalUsuarioBean.lstOpcionesSemanas}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuMetodoConfirm" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputTextarea id="inputSignosSinto" value="#{gestacionPrenatalUsuarioBean.gestacion.hgecsignosinto}"></h:inputTextarea>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="inputSignosSinto" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
            <h:selectOneRadio id="mnuMovimientoFetal" immediate="true"
                                 required="true"
                              rendered="#{gestacionPrenatalUsuarioBean.habilitarmovimientoFetal}"
                              value="#{gestacionPrenatalUsuarioBean.gestacion.hgecmovimfetal}">
              <f:selectItems value="#{gestacionPrenatalUsuarioBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuMovimientoFetal" styleClass="errorMessage"/>
            </a4j:outputPanel>
             <h:outputText value = "N/A " rendered="#{!gestacionPrenatalUsuarioBean.habilitarmovimientoFetal}"/>
         </h:panelGroup>
            <h:panelGroup/>
          </h:panelGrid>
        </s:fieldset>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGestacionActualBoton"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="boton_fieldset"
                             action="#{gestacionPrenatalUsuarioBean.aceptar}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
      <h:panelGrid>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionGestacionActual" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrorsGestacionActual" showSummary="true" errorClass="error"
                        globalOnly="true" layout="table" infoClass="informacion"/>
          </a4j:outputPanel>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>