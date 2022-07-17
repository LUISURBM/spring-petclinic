<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formTamizajeControlPrenatal">
  <a4j:region id="regionTamizajeControlPrenatal" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionTamizajeControlPrenatal">
      <f:facet name="start">
        <t:div id="chargingTamizajeControlPrenatal" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    

    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridTamizajeControlPrenatalTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%"
                         id="panelTabbedPaneTamizajeControlPrenatal"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabTamizajeControlPrenatal"
                    label="Tamizaje de Laboratorios">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="tableContentTabsTamizajeLaboratorios"
                       styleClass="tabContainer">
            <s:fieldset legend="Examenes" id="fieldExamenesLaboratorio"
                        styleClass="fieldset">
              <h:panelGrid columns="3" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelExamenesLab"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Toxoplasma IGG"/>
                <h:panelGroup id="panelOutputTextResultadoIGG">
                  <h:outputText value="Resultado IGG"
                                rendered="#{tamizajeControlPrenatalBean.mostrarToxoplasmaIGG}"/>
                </h:panelGroup>
                <h:panelGroup id="panelOutputTextIGG">
                  <h:outputText value="Fecha IGG" styleClass="labelTextOblig"
                                rendered="#{tamizajeControlPrenatalBean.mostrarToxoplasmaIGG}"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuToxoplasmaIGG" immediate="true"
                                      value="#{tamizajeControlPrenatalBean.tamizaje.htletoxoplaigg}"
                                      valueChangeListener="#{tamizajeControlPrenatalBean.setToxoplasmaIGG}"
                                      styleClass="labelRadio">
                      <f:selectItems value="#{tamizajeControlPrenatalBean.lstOpciones}"/>
                      <a4j:support id="supportToxoplasmaIGG" event="onclick"
                                   immediate="true"
                                   action="#{tamizajeControlPrenatalBean.ChangeToxoplasmaIGG}"
                                   reRender="panelFechaIGG,panelOutputTextIGG,panelOutputTextResultadoIGG,panelResultadoIGG">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuToxoplasmaIGG"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelResultadoIGG">
                  <h:selectOneRadio id="mnuResultadoIGG" immediate="true"
                                    rendered="#{tamizajeControlPrenatalBean.mostrarToxoplasmaIGG}"
                                    value="#{tamizajeControlPrenatalBean.tamizaje.htlcresutoxigg}"
                                    styleClass="labelRadio">
                    <f:selectItems value="#{tamizajeControlPrenatalBean.lstResultado}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuResultadoIGG" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelFechaIGG">
                  <t:inputCalendar id="fechaToxoplasmaIGG"
                                   title="Formato: dd/mm/yyyy"
                                   rendered="#{tamizajeControlPrenatalBean.mostrarToxoplasmaIGG}"
                                   onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{tamizajeControlPrenatalBean.tamizaje.htldfechtoxigg}"
                                   popupTodayString="Hoy"
                                   popupWeekString="Semana"
                                   popupButtonString="Fecha" readonly="false"
                                   maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   required="true"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="fechaToxoplasmaIGG"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Toxoplasma IGM"/>
                <h:panelGroup id="panelOutputTextResultadoIGM">
                  <h:outputText value="Resultado IGM"
                                rendered="#{tamizajeControlPrenatalBean.mostrarToxoplasmaIGM}"/>
                </h:panelGroup>
                <h:panelGroup id="panelOutputTextIGM">
                  <h:outputText value="Fecha IGM" styleClass="labelTextOblig"
                                rendered="#{tamizajeControlPrenatalBean.mostrarToxoplasmaIGM}"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuToxoplasmaIGM" immediate="true"
                                      value="#{tamizajeControlPrenatalBean.tamizaje.htletoxoplaigm}"
                                      valueChangeListener="#{tamizajeControlPrenatalBean.setToxoplasmaIGM}"
                                      styleClass="labelRadio">
                      <f:selectItems value="#{tamizajeControlPrenatalBean.lstOpciones}"/>
                      <a4j:support id="supportToxoplasmaIGM" event="onclick"
                                   immediate="true"
                                   action="#{tamizajeControlPrenatalBean.ChangeToxoplasmaIGM}"
                                   reRender="panelFechaIGM,panelOutputTextIGM,panelOutputTextResultadoIGM,panelResultadoIGM">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuToxoplasmaIGM"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelResultadoIGM">
                  <h:selectOneRadio id="mnuResultadoIGM" immediate="true"
                                    rendered="#{tamizajeControlPrenatalBean.mostrarToxoplasmaIGM}"
                                    value="#{tamizajeControlPrenatalBean.tamizaje.htlcresutoxigm}"
                                    styleClass="labelRadio">
                    <f:selectItems value="#{tamizajeControlPrenatalBean.lstResultado}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuResultadoIGM" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelFechaIGM">
                  <t:inputCalendar id="fechaToxoplasmaIGM"
                                   title="Formato: dd/mm/yyyy"
                                   rendered="#{tamizajeControlPrenatalBean.mostrarToxoplasmaIGM}"
                                   onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{tamizajeControlPrenatalBean.tamizaje.htldfechtoxigm}"
                                   popupTodayString="Hoy"
                                   popupWeekString="Semana"
                                   popupButtonString="Fecha" readonly="false"
                                   maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   required="true"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="fechaToxoplasmaIGM"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Test O´Sullivan"/>
                <h:panelGroup id="panelTextResultadoSullivan">
                  <h:outputText value="Resultado Test O´Sullivan"
                                rendered="#{tamizajeControlPrenatalBean.mostrarTest}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextSullivan">
                  <h:outputText value="Fecha Test O´Sullivan"
                                rendered="#{tamizajeControlPrenatalBean.mostrarTest}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuSullivan" immediate="true"
                                      value="#{tamizajeControlPrenatalBean.tamizaje.htletestsulliv}"
                                      valueChangeListener="#{tamizajeControlPrenatalBean.setTestSullivan}"
                                      styleClass="labelRadio">
                      <f:selectItems value="#{tamizajeControlPrenatalBean.lstOpciones}"/>
                      <a4j:support id="supportSullivan" event="onclick"
                                   immediate="true"
                                   action="#{tamizajeControlPrenatalBean.ChangeTextSullivan}"
                                   reRender="panelTextSullivan,panelFechaSullivan,panelTextResultadoSullivan,panelResultadoSullivan">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuSullivan" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelResultadoSullivan">
                  <h:inputText id="itResSullivan"
                               rendered="#{tamizajeControlPrenatalBean.mostrarTest}"
                               maxlength="3" style="width:40px"
                               value="#{tamizajeControlPrenatalBean.tamizaje.htlnrestestsul}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itResSullivan" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelFechaSullivan">
                  <t:inputCalendar id="fechaSullivan"
                                   title="Formato: dd/mm/yyyy"
                                   rendered="#{tamizajeControlPrenatalBean.mostrarTest}"
                                   onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{tamizajeControlPrenatalBean.tamizaje.htldfectestsul}"
                                   popupTodayString="Hoy"
                                   popupWeekString="Semana"
                                   popupButtonString="Fecha" readonly="false"
                                   maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   required="true"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="fechaSullivan" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Hemoglobina"/>
                <h:panelGroup id="panelTextResultadoHemoglobina">
                  <h:outputText value="Resultado Hemoglobina"
                                rendered="#{tamizajeControlPrenatalBean.mostrarHemoglobina}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextFechaHemoglobina">
                  <h:outputText value="Fecha Hemoglobina"
                                rendered="#{tamizajeControlPrenatalBean.mostrarHemoglobina}"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuHemoglobina" immediate="true"
                                      value="#{tamizajeControlPrenatalBean.tamizaje.htlehemoglobin}"
                                      valueChangeListener="#{tamizajeControlPrenatalBean.setHemoglobina}"
                                      styleClass="labelRadio">
                      <f:selectItems value="#{tamizajeControlPrenatalBean.lstOpciones}"/>
                      <a4j:support id="supportHemoglobina" event="onclick"
                                   immediate="true"
                                   action="#{tamizajeControlPrenatalBean.ChangeHemoglobina}"
                                   reRender="panelTextResultadoHemoglobina,panelTextFechaHemoglobina,panelResultadoHemoglobina,panelFechaHemoglobina">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuHemoglobina"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelResultadoHemoglobina">
                  <h:inputText id="itResHemoglonina"
                               rendered="#{tamizajeControlPrenatalBean.mostrarHemoglobina}"
                               maxlength="2" style="width:40px"
                               value="#{tamizajeControlPrenatalBean.tamizaje.htlnreshemoglo}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itResHemoglonina"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelFechaHemoglobina">
                  <t:inputCalendar id="fechaHemoglobina"
                                   title="Formato: dd/mm/yyyy"
                                   rendered="#{tamizajeControlPrenatalBean.mostrarHemoglobina}"
                                   onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{tamizajeControlPrenatalBean.tamizaje.htldfechemoglo}"
                                   popupTodayString="Hoy"
                                   popupWeekString="Semana"
                                   popupButtonString="Fecha" readonly="false"
                                   maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   required="true"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="fechaHemoglobina"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Glucosa"/>
                <h:panelGroup id="panelTextResultadoGlucosa">
                  <h:outputText value="Resultado Glucosa"
                                rendered="#{tamizajeControlPrenatalBean.mostrarGlucosa}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextFechaGlucosa">
                  <h:outputText value="Fecha Glucosa"
                                rendered="#{tamizajeControlPrenatalBean.mostrarGlucosa}"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuGlucosa" immediate="true"
                                      value="#{tamizajeControlPrenatalBean.tamizaje.htleglucosa}"
                                      valueChangeListener="#{tamizajeControlPrenatalBean.setGlucosa}"
                                      styleClass="labelRadio">
                      <f:selectItems value="#{tamizajeControlPrenatalBean.lstOpciones}"/>
                      <a4j:support id="supportGlucosa" event="onclick"
                                   immediate="true"
                                   action="#{tamizajeControlPrenatalBean.ChangeGlucosa}"
                                   reRender="panelTextResultadoGlucosa,panelTextFechaGlucosa,panelResultadoGlucosa,panelFechaGlucosa">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuGlucosa" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelResultadoGlucosa">
                  <h:inputText id="itResGlucosa"
                               rendered="#{tamizajeControlPrenatalBean.mostrarGlucosa}"
                               maxlength="3" style="width:40px"
                               value="#{tamizajeControlPrenatalBean.tamizaje.htlnresglucosa}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itResGlucosa" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelFechaGlucosa">
                  <t:inputCalendar id="fechaGlucosa" title="Formato: dd/mm/yyyy"
                                   rendered="#{tamizajeControlPrenatalBean.mostrarGlucosa}"
                                   onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{tamizajeControlPrenatalBean.tamizaje.htldfecglucosa}"
                                   popupTodayString="Hoy"
                                   popupWeekString="Semana"
                                   popupButtonString="Fecha" readonly="false"
                                   maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   required="true"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="fechaGlucosa" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Serologia"/>
                <h:panelGroup id="panelTextResultadoSerologia">
                  <h:outputText value="Resultado Serologia"
                                rendered="#{tamizajeControlPrenatalBean.mostrarSerologia}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextFechaSerologia">
                  <h:outputText value="Fecha Serologia"
                                rendered="#{tamizajeControlPrenatalBean.mostrarSerologia}"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuSerologia" immediate="true"
                                      value="#{tamizajeControlPrenatalBean.tamizaje.htleserologia}"
                                      valueChangeListener="#{tamizajeControlPrenatalBean.setSerologia}"
                                      styleClass="labelRadio">
                      <f:selectItems value="#{tamizajeControlPrenatalBean.lstOpciones}"/>
                      <a4j:support id="supportSerologia" event="onclick"
                                   immediate="true"
                                   action="#{tamizajeControlPrenatalBean.ChangeSerologia}"
                                   reRender="panelTextResultadoSerologia,panelTextFechaSerologia,panelResultadoSerologia,panelFechaSerologia">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuSerologia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelResultadoSerologia">
                  <h:selectOneRadio id="mnuResultadoSerologia" immediate="true"
                                    rendered="#{tamizajeControlPrenatalBean.mostrarSerologia}"
                                    value="#{tamizajeControlPrenatalBean.tamizaje.htleresuserolo}"
                                    styleClass="labelRadio">
                    <f:selectItems value="#{tamizajeControlPrenatalBean.lstResultado}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="panelResultadoSerologia"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelFechaSerologia">
                  <t:inputCalendar id="fechaSerologia"
                                   title="Formato: dd/mm/yyyy"
                                   rendered="#{tamizajeControlPrenatalBean.mostrarSerologia}"
                                   onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{tamizajeControlPrenatalBean.tamizaje.htldfecserolog}"
                                   popupTodayString="Hoy"
                                   popupWeekString="Semana"
                                   popupButtonString="Fecha" readonly="false"
                                   maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   required="true"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="fechaSerologia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Examenes" id="fieldExamenes"
                        styleClass="fieldset">
              <h:panelGrid columns="3" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelExamenesLaboratorios"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Ecografia"/>
                <h:panelGroup id="panelTextEcografia">
                  <h:outputText value="Descripción de Ecografia"
                                rendered="#{tamizajeControlPrenatalBean.mostrarEcografia}"/>
                </h:panelGroup>
                <h:outputText value="Micronutrientes"/>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuEcografia" immediate="true"
                                      styleClass="labelRadio" required="true"
                                      value="#{tamizajeControlPrenatalBean.tieneEcografia}"
                                      valueChangeListener="#{tamizajeControlPrenatalBean.setTieneEcografia}">
                      <f:selectItems value="#{tamizajeControlPrenatalBean.lstOpciones}"/>
                      <a4j:support id="supportmnuEcografia" event="onclick"
                                   action="#{tamizajeControlPrenatalBean.changeEcografia}"
                                   reRender="panelTextEcografia,panelMenuEcografia">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuEcografia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelMenuEcografia">
                  <h:inputTextarea id="itAreaEcografia"
                                   rendered="#{tamizajeControlPrenatalBean.mostrarEcografia}"
                                   value="#{tamizajeControlPrenatalBean.tamizaje.htlcecografia}"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuMicroNutrientes" immediate="true"
                                    styleClass="labelRadio" required="true"
                                    value="#{tamizajeControlPrenatalBean.tamizaje.htlemicronutri}">
                    <f:selectItems value="#{tamizajeControlPrenatalBean.lstOpciones}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMicroNutrientes"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Parcial de Orina"
                              styleClass="labelTextOblig"/>
                <h:panelGroup id="panelTextBacteriuria">
                  <h:outputText value="Bacteriuria" styleClass="labelTextOblig"
                                rendered="#{tamizajeControlPrenatalBean.existeParcial}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextProteinuria">
                  <h:outputText value="Proteinuria" styleClass="labelTextOblig"
                                rendered="#{tamizajeControlPrenatalBean.existeParcial}"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuParcialOrina" immediate="true"
                                      styleClass="labelRadio" required="true"
                                      value="#{tamizajeControlPrenatalBean.tamizaje.htleparciorina}"
                                      valueChangeListener="#{tamizajeControlPrenatalBean.setParcialOrina}">
                      <f:selectItems value="#{tamizajeControlPrenatalBean.lstOpciones}"/>
                      <a4j:support id="supportParcialOrina" event="onclick"
                                   action="#{tamizajeControlPrenatalBean.changeParcial}"
                                   reRender="panelTextBacteriuria,panelTextProteinuria,panelTextHematies,panelMenuBacteriuria,panelMenuProteinuria,panelMenuHematies,panelTextLeucocitos,panelMenuLeucocitos">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuParcialOrina"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelMenuBacteriuria">
                  <h:selectOneRadio id="mnuBacteriuria" immediate="true"
                                    rendered="#{tamizajeControlPrenatalBean.existeParcial}"
                                    styleClass="labelRadio" required="true"
                                    value="#{tamizajeControlPrenatalBean.tamizaje.htlebacteriuri}">
                    <f:selectItems value="#{tamizajeControlPrenatalBean.lstResultado}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuBacteriuria" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelMenuProteinuria">
                  <h:selectOneRadio id="mnuProteinuria" immediate="true"
                                    rendered="#{tamizajeControlPrenatalBean.existeParcial}"
                                    styleClass="labelRadio" required="true"
                                    value="#{tamizajeControlPrenatalBean.tamizaje.htleproteinuri}">
                    <f:selectItems value="#{tamizajeControlPrenatalBean.lstResultado}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuProteinuria" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelTextHematies">
                  <h:outputText value="Hematies" styleClass="labelTextOblig"
                                rendered="#{tamizajeControlPrenatalBean.existeParcial}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextLeucocitos">
                  <h:outputText value="Leucocitos" styleClass="labelTextOblig"
                                rendered="#{tamizajeControlPrenatalBean.existeParcial}"/>
                </h:panelGroup>
                <h:panelGroup/>
                <h:panelGroup id="panelMenuHematies">
                  <h:selectOneRadio id="mnuHematies" immediate="true"
                                    rendered="#{tamizajeControlPrenatalBean.existeParcial}"
                                    styleClass="labelRadio" required="true"
                                    value="#{tamizajeControlPrenatalBean.tamizaje.htlehematies}">
                    <f:selectItems value="#{tamizajeControlPrenatalBean.lstResultado}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuHematies" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelMenuLeucocitos">
                  <h:selectOneRadio id="mnuLeucocitos" immediate="true"
                                    rendered="#{tamizajeControlPrenatalBean.existeParcial}"
                                    styleClass="labelRadio" required="true"
                                    value="#{tamizajeControlPrenatalBean.tamizaje.htleleucocitos}">
                    <f:selectItems value="#{tamizajeControlPrenatalBean.lstResultado}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuLeucocitos" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
       
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelBotonModificar"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Guardar" styleClass="boton_fieldset"
                                 action="#{tamizajeControlPrenatalBean.aceptar}">
                  <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>
              </h:panelGroup>
            </h:panelGrid>
            
                 <s:fieldset legend="Examenes Anteriores Consultas Prenatal"
                        id="fieldListaExamenesPrenatal" styleClass="fieldset"
                        rendered="true">
              <h:panelGrid columns="1" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="tableControlPrenatal" styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0"
                               cellspacing="0"
                               value="#{tamizajeControlPrenatalBean.lstHistorialTamizaje}"
                               rows="10" styleClass="standard_table"
                               rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtControlPrenatal">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Fecha"/>
                      </f:facet>
                      <h:outputText value="#{item.htldfecharegis}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Toxoplasma IGG"/>
                      </f:facet>
                      <h:outputText value="#{item.htletoxoplaigg}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Toxoplasma IGM"/>
                      </f:facet>
                      <h:outputText value="#{item.htletoxoplaigm}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Test O´Sullivan"/>
                      </f:facet>
                      <h:outputText value="#{item.htletestsulliv}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Hemoglobina"/>
                      </f:facet>
                      <h:outputText value="#{item.htlehemoglobin}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Glucosa"/>
                      </f:facet>
                      <h:outputText value="#{item.htleglucosa}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Serologia"/>
                      </f:facet>
                      <h:outputText value="#{item.htleserologia}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Ecografia"/>
                      </f:facet>
                      <h:outputText value="#{item.htlcecografia}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Parcial de Orina"/>
                      </f:facet>
                      <h:outputText value="#{item.htleparciorina}"/>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1"
                               rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_1" for="dtControlPrenatal"
                                    fastStep="10" pageCountVar="pageCount"
                                    pageIndexVar="pageIndex"
                                    styleClass="scroller" paginator="true"
                                    immediate="true" paginatorMaxPages="9"
                                    paginatorTableClass="paginator"
                                    renderFacetsIfSinglePage="false"
                                    paginatorActiveColumnStyle="font-weight:bold;">
                      <f:facet name="first">
                        <t:graphicImage alt=""  url="/comun/imagenes/primero.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="last">
                        <t:graphicImage alt=""  url="/comun/imagenes/ultimo.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="previous">
                        <t:graphicImage alt=""  url="/comun/imagenes/anterior.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="next">
                        <t:graphicImage alt=""  url="/comun/imagenes/siguiente.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="fastforward">
                        <t:graphicImage alt=""  url="/comun/imagenes/adelante.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="fastrewind">
                        <t:graphicImage alt=""  url="/comun/imagenes/atras.gif"
                                        border="0"/>
                      </f:facet>
                    </t:dataScroller>
                  </h:panelGrid>
                </t:buffer>
                <h:outputText value="#{tableScroller}" escape="false"/>
                <h:outputText value="#{table}" escape="false"/>
                <h:outputText value="#{tableScroller}" escape="false"/>
              </h:panelGrid>
            </s:fieldset>
          </h:panelGrid>
          <h:panelGrid>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionMessagesatributo1"
                               ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInformationAndErrors1" showSummary="true"
                            errorClass="error" globalOnly="true" layout="table"
                            infoClass="informacion"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>