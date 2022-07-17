<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridFormulaMedicaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
   <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneGestacion"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabGestacion" label="Gestación Actual">
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="tableContentTabsGestacionActual"
                     styleClass="tabContainer">
      <s:fieldset legend="Gestación" id="fieldGestacionActual"
                  styleClass="fieldset">
        <a4j:region renderRegionOnly="false">
          <h:panelGrid columns="7">
            <h:outputText value="[ " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value=" Todos SI" immediate="true"
                             action="#{gestacionControlPranatalUsuarioBean.changeTodosSi}" reRender="panelGestacionActual"/>
            <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true"
                             action="#{gestacionControlPranatalUsuarioBean.changeTodosNo}" reRender="panelGestacionActual"/>
            <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true"
                             action="#{gestacionControlPranatalUsuarioBean.changeNinguno}" reRender=" panelGestacionActual"/>
            <h:outputText value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
          </h:panelGrid>
        </a4j:region>
        <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelGestacionActual"
                     rowClasses="labelCuestionario3,labelCuestionario4">
          <h:outputText value="Antitetanica Previa" styleClass="labelTextNoOblig"/>
          <h:outputText value="Antitetanica Actual 1ra Dosis" styleClass="labelTextNoOblig"
                        />
          <h:panelGroup id="itFechaDosis1">
            <h:outputText value="Fecha 1ra Dosis " styleClass="labelTextOblig"
                          rendered="#{gestacionControlPranatalUsuarioBean.mostrarFechaAntitetanica}"/>
          </h:panelGroup>
          <h:outputText value="Antitetanica Actual 2da Dosis" styleClass="labelTextNoOblig"/>
          <h:panelGroup id="itFechaDosis2">
            <h:outputText value="Fecha  2da Dosis" styleClass="labelTextOblig"
                          rendered="#{gestacionControlPranatalUsuarioBean.mostrarFechaAntitetanica2}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuAntitetanicaPrevia" 
                              onkeydown="return blockEnter(event);"
                              disabled="#{gestacionControlPranatalUsuarioBean.desAntitetanicaPrevia}"
                              value="#{gestacionControlPranatalUsuarioBean.gestacion.hgeeprevantite}"
                              styleClass="labelRadio">
              <f:selectItems value="#{gestacionControlPranatalUsuarioBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuAntitetanicaPrevia" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
             <a4j:region renderRegionOnly="false">
          <h:panelGroup>
            <h:selectOneRadio id="mnuAntitetanicaActual" 
                             onkeydown="return blockEnter(event);"
                              immediate="true"
                              binding="#{gestacionControlPranatalUsuarioBean.mnuAntitetanicaPrevia}"
                              disabled="#{gestacionControlPranatalUsuarioBean.desAntitetanicaActual1}"
                              value="#{gestacionControlPranatalUsuarioBean.gestacion.hgeeantidosis1}"
                              valueChangeListener="#{gestacionControlPranatalUsuarioBean.setAntitetanicaActual}"
                              styleClass="labelRadio">
              <f:selectItems value="#{gestacionControlPranatalUsuarioBean.lstOpciones}"/>
              <a4j:support id="supportAntitetanicaActua" event="onclick"
                           immediate="true"
                           action="#{gestacionControlPranatalUsuarioBean.ChangeAntitetanica}"
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
            <t:inputCalendar id="fechaAntitetanicaDosis1"
                             onkeydown="return blockEnter(event);"
                             rendered="#{gestacionControlPranatalUsuarioBean.mostrarFechaAntitetanica}"
                             disabled="#{gestacionControlPranatalUsuarioBean.desAntitetanicaActual1}"
                             title="Formato: dd/mm/yyyy"
                             monthYearRowClass="yearMonthHeader"
                             weekRowClass="weekHeader"
                             currentDayCellClass="currentDayCell"
                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                             value="#{gestacionControlPranatalUsuarioBean.gestacion.hgedfecantdos1}"
                             popupTodayString="Hoy" popupWeekString="Semana"
                             popupButtonString="Fecha" readonly="false"
                             maxlength="11" size="11"
                             popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                             renderPopupButtonAsImage="true" align="top"
                             required="true">
                        <f:validator validatorId="dateMenorIgualValidator"/>     
                </t:inputCalendar>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="fechaAntitetanicaDosis1"
                         styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
           <a4j:region renderRegionOnly="false">
          <h:panelGroup>
            <h:selectOneRadio id="mnuAntitetanicaActual2" 
                              onkeydown="return blockEnter(event);"
                              disabled="#{gestacionControlPranatalUsuarioBean.desAntitetanicaActual2}"
                              immediate="true"
                              binding="#{gestacionControlPranatalUsuarioBean.mnuAntitetanicaActual2}"
                              value="#{gestacionControlPranatalUsuarioBean.gestacion.hgeeantidosis2}"
                              valueChangeListener="#{gestacionControlPranatalUsuarioBean.setAntitetanicaActual2}"
                              styleClass="labelRadio">
              <f:selectItems value="#{gestacionControlPranatalUsuarioBean.lstOpciones}"/>
              <a4j:support id="supportAntitetanicaActual2" event="onclick"
                           immediate="true"
                           action="#{gestacionControlPranatalUsuarioBean.ChangeAntitetanica2}"
                           reRender="itFechaDosis2,itCalendarFechaDosis2">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuAntitetanicaActual2"
                         styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
           </a4j:region>
          <h:panelGroup id="itCalendarFechaDosis2">
            <t:inputCalendar id="fechaAntitetanicaDosis2"
                             onkeydown="return blockEnter(event);"
                             disabled="#{gestacionControlPranatalUsuarioBean.desAntitetanicaActual2}"
                             title="Formato: dd/mm/yyyy"
                             rendered="#{gestacionControlPranatalUsuarioBean.mostrarFechaAntitetanica2}"
                             monthYearRowClass="yearMonthHeader"
                             weekRowClass="weekHeader"
                             currentDayCellClass="currentDayCell"
                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                             value="#{gestacionControlPranatalUsuarioBean.gestacion.hgedfecantdos2}"
                             popupTodayString="Hoy" popupWeekString="Semana"
                             popupButtonString="Fecha" readonly="false"
                             maxlength="11" size="11"
                             popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                             renderPopupButtonAsImage="true" align="top"
                             required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
            </t:inputCalendar>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="fechaAntitetanicaDosis2"
                         styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="Antirubeola Previa" styleClass="labelTextNoOblig"/>
          <h:outputText value="Antirubeola Actual" styleClass="labelTextNoOblig"/>
          <h:panelGroup id = "panelOutputTextAntirubeola">
            <h:outputText value="Fecha Antirubeola Actual" rendered="#{gestacionControlPranatalUsuarioBean.mostrarAntirubeola}"
                          styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup/>
          <h:panelGroup/>
          <h:panelGroup>
            <h:selectOneRadio id="mnuAntirubeolaPrevia" 
                              onkeydown="return blockEnter(event);"
                              disabled="#{gestacionControlPranatalUsuarioBean.desAntirubeolaPrevia}"
                              immediate="true"
                              value="#{gestacionControlPranatalUsuarioBean.gestacion.hgeepreantrube}"
                              styleClass="labelRadio">
              <f:selectItems value="#{gestacionControlPranatalUsuarioBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuAntirubeolaPrevia" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
           <a4j:region renderRegionOnly="false">
          <h:panelGroup>
            <h:selectOneRadio id="mnuAntirubeolaActual" 
                             onkeydown="return blockEnter(event);"
                              disabled="#{gestacionControlPranatalUsuarioBean.desAntirubeolaActual}"
                              immediate="true"
                              binding="#{gestacionControlPranatalUsuarioBean.mnuAntirubeolaActual}"
                              value="#{gestacionControlPranatalUsuarioBean.gestacion.hgeeactantrube}"
                              valueChangeListener="#{gestacionControlPranatalUsuarioBean.setAntirubeola}"
                              styleClass="labelRadio">
              <f:selectItems value="#{gestacionControlPranatalUsuarioBean.lstOpciones}"/>
              <a4j:support id="supportAntirubeolaPrevia" event="onclick"
                           immediate="true"
                           action="#{gestacionControlPranatalUsuarioBean.ChangeAntirubeola}"
                           reRender="panelOutputTextAntirubeola,panelFechaAntirubeola">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuAntirubeolaActual" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          </a4j:region>
          <h:panelGroup id = "panelFechaAntirubeola">
            <t:inputCalendar id="fechaAntirubeola" title="Formato: dd/mm/yyyy"
                             disabled="#{gestacionControlPranatalUsuarioBean.desAntirubeolaActual}"
                             rendered="#{gestacionControlPranatalUsuarioBean.mostrarAntirubeola}"
                             onkeydown="return blockEnter(event);"
                             monthYearRowClass="yearMonthHeader"
                             weekRowClass="weekHeader"
                             currentDayCellClass="currentDayCell"
                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                             value="#{gestacionControlPranatalUsuarioBean.gestacion.hgedfecantrube}"
                             popupTodayString="Hoy" popupWeekString="Semana"
                             popupButtonString="Fecha" readonly="false"
                             maxlength="11" size="11"
                             popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                             renderPopupButtonAsImage="true" align="top"
                             required="true">
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
          <h:outputText value="Sensibilización" styleClass="labelTextNoOblig" />
          <h:outputText value="" />
          <h:panelGroup>
            <h:panelGroup>
              <h:selectOneMenu id="mnuGrupoPaciente" 
                               onkeydown="return blockEnter(event);"
                               value="#{gestacionControlPranatalUsuarioBean.gestacion.hgecgrupopacie}"
                               disabled="#{gestacionControlPranatalUsuarioBean.desGrupoPaciente}"
                               styleClass="labelRadio">
                <f:selectItems value="#{gestacionControlPranatalUsuarioBean.lstGrupo}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuRHPaciente" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:selectOneMenu id="mnuRHPaciente" onkeydown="return blockEnter(event);"
                                disabled="#{gestacionControlPranatalUsuarioBean.desRHPaciente}"
                               value="#{gestacionControlPranatalUsuarioBean.gestacion.hgecrhpaciente}"
                               styleClass="labelRadio">
                <f:selectItems value="#{gestacionControlPranatalUsuarioBean.lstRH}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuRHPaciente" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGroup>
              <h:selectOneMenu id="mnuGrupoEsposo" 
                               onkeydown="return blockEnter(event);"
                               disabled="#{gestacionControlPranatalUsuarioBean.desGrupoEsposo}"
                               value="#{gestacionControlPranatalUsuarioBean.gestacion.hgecgrupoespos}"
                               styleClass="labelRadio">
                <f:selectItems value="#{gestacionControlPranatalUsuarioBean.lstGrupo}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuGrupoEsposo" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:selectOneMenu id="mnuRHEsposo" 
                               onkeydown="return blockEnter(event);"
                               disabled="#{gestacionControlPranatalUsuarioBean.desRHEsposo}"
                               value="#{gestacionControlPranatalUsuarioBean.gestacion.hgecrhesposo}"
                               styleClass="labelRadio">
                <f:selectItems value="#{gestacionControlPranatalUsuarioBean.lstRH}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuRHEsposo" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGroup>
          <h:panelGroup/>
          <h:panelGroup>
            <h:selectOneRadio id="mnuSensibilidad" 
                              onkeydown="return blockEnter(event);"
                              disabled="#{gestacionControlPranatalUsuarioBean.desSensibilizacion}"
                              value="#{gestacionControlPranatalUsuarioBean.gestacion.hgecsensibilid}"
                              styleClass="labelRadio">
              <f:selectItems value="#{gestacionControlPranatalUsuarioBean.lstOpciones}"/>
            </h:selectOneRadio>
          </h:panelGroup>
          <h:panelGroup/>
          <h:outputText value="Solicito VIH " styleClass="labelTextNoOblig"/>
          <h:outputText value="Realizo VIH " styleClass="labelTextNoOblig"/>
          <h:panelGroup/>
          <h:panelGroup/>
          <h:panelGroup/>
          <h:panelGroup>
            <h:selectOneRadio id="mnuSolicitoVIH" 
                             onkeydown="return blockEnter(event);"
                             disabled="#{gestacionControlPranatalUsuarioBean.desSolicitoVIH}"
                              value="#{gestacionControlPranatalUsuarioBean.gestacion.hgeesolicivih1}"
                              styleClass="labelRadio">
              <f:selectItems value="#{gestacionControlPranatalUsuarioBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuSolicitoVIH" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuRealizoVIH" 
                              onkeydown="return blockEnter(event);"
                              disabled="#{gestacionControlPranatalUsuarioBean.desRealizoVIH}"
                              value="#{gestacionControlPranatalUsuarioBean.gestacion.hgeerealizvih1}"
                              styleClass="labelRadio">
              <f:selectItems value="#{gestacionControlPranatalUsuarioBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuRealizoVIH" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
     <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                   width="100%" id="panelGestacionActualBoton"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar" styleClass="boton_fieldset"
                             action="#{gestacionControlPranatalUsuarioBean.aceptar}">
                  <a4j:support event="onclick" status="statusButton"/>           
        </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </h:panelGrid><h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionGestacionActual" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsGestacionActual"
                      showSummary="true" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
</t:panelTab>
</t:panelTabbedPane>
    <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>