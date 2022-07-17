<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formGestacion">
 <a4j:region id="regionGestacion" renderRegionOnly="false">
    <a4j:status  id = "statusButton" for="regionGestacion">
      <f:facet name="start">
        <t:div id="chargingGestacion" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>


  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridGestacionTab"
               styleClass="tabContainer">
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
        <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelGestacionActual"
                     rowClasses="labelText">
          <h:outputText value="Antitetanica Previa"/>
          <h:outputText value="Antitetanica Actual 1ra Dosis"
                        />
          <h:panelGroup id="itFechaDosis1">
            <h:outputText value="Fecha 1ra Dosis " styleClass="labelTextOblig"
                          rendered="#{gestacionBean.mostrarFechaAntitetanica}"/>
          </h:panelGroup>
          <h:outputText value="Antitetanica Actual 2da Dosis"/>
          <h:panelGroup id="itFechaDosis2">
            <h:outputText value="Fecha  2da Dosis" styleClass="labelTextOblig"
                          rendered="#{gestacionBean.mostrarFechaAntitetanica2}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuAntitetanicaPrevia" 
                              disabled="#{gestacionBean.desAntitetanicaPrevia}"
                              value="#{gestacionBean.gestacion.hgeeprevantite}"
                              styleClass="labelRadio">
              <f:selectItems value="#{gestacionBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuAntitetanicaPrevia" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
             <a4j:region renderRegionOnly="false">
          <h:panelGroup>
            <h:selectOneRadio id="mnuAntitetanicaActual" 
                              immediate="true"
                              disabled="#{gestacionBean.desAntitetanicaActual1}"
                              value="#{gestacionBean.gestacion.hgeeantidosis1}"
                              valueChangeListener="#{gestacionBean.setAntitetanicaActual}"
                              styleClass="labelRadio">
              <f:selectItems value="#{gestacionBean.lstOpciones}"/>
              <a4j:support id="supportAntitetanicaActua" event="onclick"
                           immediate="true"
                           action="#{gestacionBean.ChangeAntitetanica}"
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
                             rendered="#{gestacionBean.mostrarFechaAntitetanica}"
                             disabled="#{gestacionBean.desAntitetanicaActual1}"
                             title="Formato: dd/mm/yyyy"
                             onkeydown="return blockEnter(event);"
                             monthYearRowClass="yearMonthHeader"
                             weekRowClass="weekHeader"
                             currentDayCellClass="currentDayCell"
                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                             value="#{gestacionBean.gestacion.hgedfecantdos1}"
                             popupTodayString="Hoy" popupWeekString="Semana"
                             popupButtonString="Fecha" readonly="false"
                             maxlength="11" size="11"
                             popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                             renderPopupButtonAsImage="true" align="top"
                             required="true"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="fechaAntitetanicaDosis1"
                         styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
           <a4j:region renderRegionOnly="false">
          <h:panelGroup>
            <h:selectOneRadio id="mnuAntitetanicaActual2" 
              disabled="#{gestacionBean.desAntitetanicaActual2}"
                              immediate="true"
                              value="#{gestacionBean.gestacion.hgeeantidosis2}"
                              valueChangeListener="#{gestacionBean.setAntitetanicaActual2}"
                              styleClass="labelRadio">
              <f:selectItems value="#{gestacionBean.lstOpciones}"/>
              <a4j:support id="supportAntitetanicaActual2" event="onclick"
                           immediate="true"
                           action="#{gestacionBean.ChangeAntitetanica2}"
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
                             disabled="#{gestacionBean.desAntitetanicaActual2}"
                             title="Formato: dd/mm/yyyy"
                             rendered="#{gestacionBean.mostrarFechaAntitetanica2}"
                             onkeydown="return blockEnter(event);"
                             monthYearRowClass="yearMonthHeader"
                             weekRowClass="weekHeader"
                             currentDayCellClass="currentDayCell"
                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                             value="#{gestacionBean.gestacion.hgedfecantdos2}"
                             popupTodayString="Hoy" popupWeekString="Semana"
                             popupButtonString="Fecha" readonly="false"
                             maxlength="11" size="11"
                             popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                             renderPopupButtonAsImage="true" align="top"
                             required="true"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="fechaAntitetanicaDosis2"
                         styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="Antirubeola Previa" />
          <h:outputText value="Antirubeola Actual" />
          <h:panelGroup id = "panelOutputTextAntirubeola">
            <h:outputText value="Fecha Antirubeola Actual" rendered="#{gestacionBean.mostrarAntirubeola}"
                          styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup/>
          <h:panelGroup/>
          <h:panelGroup>
            <h:selectOneRadio id="mnuAntirubeolaPrevia" 
                              disabled="#{gestacionBean.desAntirubeolaPrevia}"
                              immediate="true"
                              value="#{gestacionBean.gestacion.hgeepreantrube}"
                              styleClass="labelRadio">
              <f:selectItems value="#{gestacionBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuAntirubeolaPrevia" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
           <a4j:region renderRegionOnly="false">
          <h:panelGroup>
            <h:selectOneRadio id="mnuAntirubeolaActual" 
                              disabled="#{gestacionBean.desAntirubeolaActual}"
                              immediate="true"
                              value="#{gestacionBean.gestacion.hgeeactantrube}"
                              valueChangeListener="#{gestacionBean.setAntirubeola}"
                              styleClass="labelRadio">
              <f:selectItems value="#{gestacionBean.lstOpciones}"/>
              <a4j:support id="supportAntirubeolaPrevia" event="onclick"
                           immediate="true"
                           action="#{gestacionBean.ChangeAntirubeola}"
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
                             disabled="#{gestacionBean.desAntirubeolaActual}"
                             rendered="#{gestacionBean.mostrarAntirubeola}"
                             onkeydown="return blockEnter(event);"
                             monthYearRowClass="yearMonthHeader"
                             weekRowClass="weekHeader"
                             currentDayCellClass="currentDayCell"
                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                             value="#{gestacionBean.gestacion.hgedfecantrube}"
                             popupTodayString="Hoy" popupWeekString="Semana"
                             popupButtonString="Fecha" readonly="false"
                             maxlength="11" size="11"
                             popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                             renderPopupButtonAsImage="true" align="top"
                             required="true"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="fechaAntirubeola" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup/>
          <h:panelGroup/>
          <h:outputText value="Grupo/RH Paciente" />
          <h:outputText value="Grupo/RH Esposo" />
          <h:panelGroup/>
          <h:outputText value="Sensibilización" />
          <h:outputText value="" />
          <h:panelGroup>
            <h:panelGroup>
              <h:selectOneMenu id="mnuGrupoPaciente" 
                               value="#{gestacionBean.gestacion.hgecgrupopacie}"
                               disabled="#{gestacionBean.desGrupoPaciente}"
                               styleClass="labelRadio">
                <f:selectItems value="#{gestacionBean.lstGrupo}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuRHPaciente" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:selectOneMenu id="mnuRHPaciente" 
                                disabled="#{gestacionBean.desRHPaciente}"
                               value="#{gestacionBean.gestacion.hgecrhpaciente}"
                               styleClass="labelRadio">
                <f:selectItems value="#{gestacionBean.lstRH}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuRHPaciente" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGroup>
              <h:selectOneMenu id="mnuGrupoEsposo" 
                               disabled="#{gestacionBean.desGrupoEsposo}"
                               value="#{gestacionBean.gestacion.hgecgrupoespos}"
                               styleClass="labelRadio">
                <f:selectItems value="#{gestacionBean.lstGrupo}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuGrupoEsposo" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:selectOneMenu id="mnuRHEsposo" 
                               disabled="#{gestacionBean.desRHEsposo}"
                               value="#{gestacionBean.gestacion.hgecrhesposo}"
                               styleClass="labelRadio">
                <f:selectItems value="#{gestacionBean.lstRH}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuRHEsposo" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGroup>
          <h:panelGroup/>
          <h:panelGroup>
            <h:selectOneRadio id="mnuSensibilidad" 
                              disabled="#{gestacionBean.desSensibilizacion}"
                              value="#{gestacionBean.gestacion.hgecsensibilid}"
                              styleClass="labelRadio">
              <f:selectItems value="#{gestacionBean.lstOpciones}"/>
            </h:selectOneRadio>
          </h:panelGroup>
          <h:panelGroup/>
          <h:outputText value="Solicito VIH " />
          <h:outputText value="Realizo VIH " />
          <h:panelGroup/>
          <h:panelGroup/>
          <h:panelGroup/>
          <h:panelGroup>
            <h:selectOneRadio id="mnuSolicitoVIH" 
                             disabled="#{gestacionBean.desSolicitoVIH}"
                              value="#{gestacionBean.gestacion.hgeesolicivih1}"
                              styleClass="labelRadio">
              <f:selectItems value="#{gestacionBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuSolicitoVIH" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuRealizoVIH" 
                              disabled="#{gestacionBean.desRealizoVIH}"
                              value="#{gestacionBean.gestacion.hgeerealizvih1}"
                              styleClass="labelRadio">
              <f:selectItems value="#{gestacionBean.lstOpciones}"/>
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
                             action="#{gestacionBean.aceptar}">
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
</h:panelGrid>
</a4j:region>
</a4j:form>