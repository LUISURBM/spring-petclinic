<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridTamizajeControlPrenatalTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  
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
                                rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarToxoplasmaIGG}"/>
                </h:panelGroup>
                <h:panelGroup id="panelOutputTextIGG">
                  <h:outputText value="Fecha IGG" styleClass="labelTextOblig"
                                rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarToxoplasmaIGG}"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuToxoplasmaIGG" immediate="true" onkeydown="return blockEnter(event);"
                                      value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htletoxoplaigg}"
                                      valueChangeListener="#{tamizajeControlPrenatalUsuarioBean.setToxoplasmaIGG}"
                                      styleClass="labelRadio">
                      <f:selectItems value="#{tamizajeControlPrenatalUsuarioBean.lstOpciones}"/>
                      <a4j:support id="supportToxoplasmaIGG" event="onclick"
                                   immediate="true"
                                   action="#{tamizajeControlPrenatalUsuarioBean.ChangeToxoplasmaIGG}"
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
                  <h:selectOneRadio id="mnuResultadoIGG" immediate="true" onkeydown="return blockEnter(event);"
                                    rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarToxoplasmaIGG}"
                                    value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htlcresutoxigg}"
                                    styleClass="labelRadio">
                    <f:selectItems value="#{tamizajeControlPrenatalUsuarioBean.lstResultado}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuResultadoIGG" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelFechaIGG">
              <t:inputCalendar id="fechaToxoplasmaIGG" title="Formato: dd/mm/yyyy"
                               rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarToxoplasmaIGG}"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htldfechtoxigg}"
                               popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                               readonly="false" maxlength="11" size="11"
                               popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                               align="top" required="true">
                        <f:validator validatorId="dateMenorIgualValidator"/>                                       
                    </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                    <t:message for="fechaToxoplasmaIGG"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Toxoplasma IGM"/>
                <h:panelGroup id="panelOutputTextResultadoIGM">
                  <h:outputText value="Resultado IGM"
                                rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarToxoplasmaIGM}"/>
                </h:panelGroup>
                <h:panelGroup id="panelOutputTextIGM">
                  <h:outputText value="Fecha IGM" styleClass="labelTextOblig"
                                rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarToxoplasmaIGM}"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuToxoplasmaIGM" immediate="true" onkeydown="return blockEnter(event);"
                                      value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htletoxoplaigm}"
                                      valueChangeListener="#{tamizajeControlPrenatalUsuarioBean.setToxoplasmaIGM}"
                                      styleClass="labelRadio">
                      <f:selectItems value="#{tamizajeControlPrenatalUsuarioBean.lstOpciones}"/>
                      <a4j:support id="supportToxoplasmaIGM" event="onclick"
                                   immediate="true"
                                   action="#{tamizajeControlPrenatalUsuarioBean.ChangeToxoplasmaIGM}"
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
                  <h:selectOneRadio id="mnuResultadoIGM" immediate="true" onkeydown="return blockEnter(event);"
                                    rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarToxoplasmaIGM}"
                                    value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htlcresutoxigm}"
                                    styleClass="labelRadio">
                    <f:selectItems value="#{tamizajeControlPrenatalUsuarioBean.lstResultado}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuResultadoIGM" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelFechaIGM">
                  <t:inputCalendar id="fechaToxoplasmaIGM"
                                   title="Formato: dd/mm/yyyy"
                                   rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarToxoplasmaIGM}"
                                   onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htldfechtoxigm}"
                                   popupTodayString="Hoy"
                                   popupWeekString="Semana"
                                   popupButtonString="Fecha" readonly="false"
                                   maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   required="true">
                                  <f:validator validatorId="dateMenorIgualValidator"/>         
                                </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="fechaToxoplasmaIGM"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Test O´Sullivan"/>
                <h:panelGroup id="panelTextResultadoSullivan">
                  <h:outputText value="Resultado Test O´Sullivan"
                                rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarTest}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextSullivan">
                  <h:outputText value="Fecha Test O´Sullivan"
                                rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarTest}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuSullivan" immediate="true" onkeydown="return blockEnter(event);"
                                      value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htletestsulliv}"
                                      valueChangeListener="#{tamizajeControlPrenatalUsuarioBean.setTestSullivan}"
                                      styleClass="labelRadio">
                      <f:selectItems value="#{tamizajeControlPrenatalUsuarioBean.lstOpciones}"/>
                      <a4j:support id="supportSullivan" event="onclick"
                                   immediate="true"
                                   action="#{tamizajeControlPrenatalUsuarioBean.ChangeTextSullivan}"
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
                  <h:inputText id="itResSullivan" onkeydown="return blockEnter(event);"
                               rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarTest}"
                               maxlength="3" style="width:40px"
                               value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htlnrestestsul}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itResSullivan" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelFechaSullivan">
                  <t:inputCalendar id="fechaSullivan"
                                   title="Formato: dd/mm/yyyy"
                                   rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarTest}"
                                   onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htldfectestsul}"
                                   popupTodayString="Hoy"
                                   popupWeekString="Semana"
                                   popupButtonString="Fecha" readonly="false"
                                   maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   required="true">
                                   <f:validator validatorId="dateMenorIgualValidator"/>        
                                </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="fechaSullivan" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Hemoglobina"/>
                <h:panelGroup id="panelTextResultadoHemoglobina">
                  <h:outputText value="Resultado Hemoglobina"
                                rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarHemoglobina}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextFechaHemoglobina">
                  <h:outputText value="Fecha Hemoglobina"
                                rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarHemoglobina}"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuHemoglobina" immediate="true" onkeydown="return blockEnter(event);"
                                      value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htlehemoglobin}"
                                      valueChangeListener="#{tamizajeControlPrenatalUsuarioBean.setHemoglobina}"
                                      styleClass="labelRadio">
                      <f:selectItems value="#{tamizajeControlPrenatalUsuarioBean.lstOpciones}"/>
                      <a4j:support id="supportHemoglobina" event="onclick"
                                   immediate="true"
                                   action="#{tamizajeControlPrenatalUsuarioBean.ChangeHemoglobina}"
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
                  <h:inputText id="itResHemoglonina" onkeydown="return blockEnter(event);"
                               rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarHemoglobina}"
                               maxlength="2" style="width:40px"
                               value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htlnreshemoglo}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itResHemoglonina"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelFechaHemoglobina">
                  <t:inputCalendar id="fechaHemoglobina"
                                   title="Formato: dd/mm/yyyy"
                                   rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarHemoglobina}"
                                   onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htldfechemoglo}"
                                   popupTodayString="Hoy"
                                   popupWeekString="Semana"
                                   popupButtonString="Fecha" readonly="false"
                                   maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   required="true">
                                <f:validator validatorId="dateMenorIgualValidator"/>        
                        </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="fechaHemoglobina"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Glucosa"/>
                <h:panelGroup id="panelTextResultadoGlucosa">
                  <h:outputText value="Resultado Glucosa"
                                rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarGlucosa}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextFechaGlucosa">
                  <h:outputText value="Fecha Glucosa"
                                rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarGlucosa}"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuGlucosa" immediate="true" onkeydown="return blockEnter(event);"
                                      value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htleglucosa}"
                                      valueChangeListener="#{tamizajeControlPrenatalUsuarioBean.setGlucosa}"
                                      styleClass="labelRadio">
                      <f:selectItems value="#{tamizajeControlPrenatalUsuarioBean.lstOpciones}"/>
                      <a4j:support id="supportGlucosa" event="onclick"
                                   immediate="true"
                                   action="#{tamizajeControlPrenatalUsuarioBean.ChangeGlucosa}"
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
                  <h:inputText id="itResGlucosa" onkeydown="return blockEnter(event);"
                               rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarGlucosa}"
                               maxlength="3" style="width:40px"
                               value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htlnresglucosa}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itResGlucosa" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelFechaGlucosa">
                  <t:inputCalendar id="fechaGlucosa" title="Formato: dd/mm/yyyy"
                                   rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarGlucosa}"
                                   onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htldfecglucosa}"
                                   popupTodayString="Hoy"
                                   popupWeekString="Semana"
                                   popupButtonString="Fecha" readonly="false"
                                   maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   required="true">
                                   <f:validator validatorId="dateMenorIgualValidator"/>        
                        </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="fechaGlucosa" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Serologia"/>
                <h:panelGroup id="panelTextResultadoSerologia">
                  <h:outputText value="Resultado Serologia"
                                rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarSerologia}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextFechaSerologia">
                  <h:outputText value="Fecha Serologia"
                                rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarSerologia}"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuSerologia" immediate="true" onkeydown="return blockEnter(event);"
                                      value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htleserologia}"
                                      valueChangeListener="#{tamizajeControlPrenatalUsuarioBean.setSerologia}"
                                      styleClass="labelRadio">
                      <f:selectItems value="#{tamizajeControlPrenatalUsuarioBean.lstOpciones}"/>
                      <a4j:support id="supportSerologia" event="onclick"
                                   immediate="true"
                                   action="#{tamizajeControlPrenatalUsuarioBean.ChangeSerologia}"
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
                  <h:selectOneRadio id="mnuResultadoSerologia" immediate="true" onkeydown="return blockEnter(event);"
                                    rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarSerologia}"
                                    value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htleresuserolo}"
                                    styleClass="labelRadio">
                    <f:selectItems value="#{tamizajeControlPrenatalUsuarioBean.lstResultado}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="panelResultadoSerologia"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelFechaSerologia">
                  <t:inputCalendar id="fechaSerologia"
                                   title="Formato: dd/mm/yyyy"
                                   rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarSerologia}"
                                   onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htldfecserolog}"
                                   popupTodayString="Hoy"
                                   popupWeekString="Semana"
                                   popupButtonString="Fecha" readonly="false"
                                   maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   required="true">
                                  <f:validator validatorId="dateMenorIgualValidator"/>         
                            </t:inputCalendar>
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
                                rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarEcografia}"/>
                </h:panelGroup>
                <h:outputText value="Micronutrientes"/>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuEcografia" immediate="true" onkeydown="return blockEnter(event);"
                                      styleClass="labelRadio" required="true"
                                      value="#{tamizajeControlPrenatalUsuarioBean.tieneEcografia}"
                                      valueChangeListener="#{tamizajeControlPrenatalUsuarioBean.setTieneEcografia}">
                      <f:selectItems value="#{tamizajeControlPrenatalUsuarioBean.lstOpciones}"/>
                      <a4j:support id="supportmnuEcografia" event="onclick"
                                   action="#{tamizajeControlPrenatalUsuarioBean.changeEcografia}"
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
                  <h:inputTextarea id="itAreaEcografia" onkeydown="return blockEnter(event);"
                                   rendered="#{tamizajeControlPrenatalUsuarioBean.mostrarEcografia}"
                                   value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htlcecografia}"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuMicroNutrientes" immediate="true"
                                    styleClass="labelRadio" required="true"
                                    value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htlemicronutri}">
                    <f:selectItems value="#{tamizajeControlPrenatalUsuarioBean.lstOpciones}"/>
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
                                rendered="#{tamizajeControlPrenatalUsuarioBean.existeParcial}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextProteinuria">
                  <h:outputText value="Proteinuria" styleClass="labelTextOblig"
                                rendered="#{tamizajeControlPrenatalUsuarioBean.existeParcial}"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuParcialOrina" immediate="true" onkeydown="return blockEnter(event);"
                                      styleClass="labelRadio" required="true"
                                      value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htleparciorina}"
                                      valueChangeListener="#{tamizajeControlPrenatalUsuarioBean.setParcialOrina}">
                      <f:selectItems value="#{tamizajeControlPrenatalUsuarioBean.lstOpciones}"/>
                      <a4j:support id="supportParcialOrina" event="onclick"
                                   action="#{tamizajeControlPrenatalUsuarioBean.changeParcial}"
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
                  <h:selectOneRadio id="mnuBacteriuria" immediate="true" onkeydown="return blockEnter(event);"
                                    rendered="#{tamizajeControlPrenatalUsuarioBean.existeParcial}"
                                    styleClass="labelRadio" required="true"
                                    value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htlebacteriuri}">
                    <f:selectItems value="#{tamizajeControlPrenatalUsuarioBean.lstResultado}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuBacteriuria" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelMenuProteinuria">
                  <h:selectOneRadio id="mnuProteinuria" immediate="true" onkeydown="return blockEnter(event);"
                                    rendered="#{tamizajeControlPrenatalUsuarioBean.existeParcial}"
                                    styleClass="labelRadio" required="true"
                                    value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htleproteinuri}">
                    <f:selectItems value="#{tamizajeControlPrenatalUsuarioBean.lstResultado}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuProteinuria" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelTextHematies">
                  <h:outputText value="Hematies" styleClass="labelTextOblig"
                                rendered="#{tamizajeControlPrenatalUsuarioBean.existeParcial}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextLeucocitos">
                  <h:outputText value="Leucocitos" styleClass="labelTextOblig"
                                rendered="#{tamizajeControlPrenatalUsuarioBean.existeParcial}"/>
                </h:panelGroup>
                <h:panelGroup/>
                <h:panelGroup id="panelMenuHematies">
                  <h:selectOneRadio id="mnuHematies" immediate="true" onkeydown="return blockEnter(event);"
                                    rendered="#{tamizajeControlPrenatalUsuarioBean.existeParcial}"
                                    styleClass="labelRadio" required="true"
                                    value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htlehematies}">
                    <f:selectItems value="#{tamizajeControlPrenatalUsuarioBean.lstResultado}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuHematies" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelMenuLeucocitos">
                  <h:selectOneRadio id="mnuLeucocitos" immediate="true" onkeydown="return blockEnter(event);"
                                    rendered="#{tamizajeControlPrenatalUsuarioBean.existeParcial}"
                                    styleClass="labelRadio" required="true"
                                    value="#{tamizajeControlPrenatalUsuarioBean.tamizaje.htleleucocitos}">
                    <f:selectItems value="#{tamizajeControlPrenatalUsuarioBean.lstResultado}"/>
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
                                 action="#{tamizajeControlPrenatalUsuarioBean.aceptar}">
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
                               value="#{tamizajeControlPrenatalUsuarioBean.lstHistorialTamizaje}"
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
 <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>