<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridTamizajePrenatalTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneTamizajePrenatal" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabTamizajePrenatal" label="Tamizaje de Laboratorios">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="tableCotentTabsTamizajeLaboratorios" styleClass="tabContainer">
        <a4j:region renderRegionOnly="false">
          <h:panelGrid columns="7">
            <h:outputText value="[ " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value=" Todos SI" immediate="true"
                             action="#{tamizajePrenatalUsuarioBean.changeTodosSi}"
                             reRender="fieldExamenes,fieldExamenesLaboratorio"/>
            <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true"
                             action="#{tamizajePrenatalUsuarioBean.changeTodosNo}"
                             reRender="fieldExamenes,fieldExamenesLaboratorio"/>
            <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true"
                             action="#{tamizajePrenatalUsuarioBean.changeNinguno}"
                             reRender=" fieldExamenes,fieldExamenesLaboratorio"/>
            <h:outputText value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
          </h:panelGrid>
        </a4j:region>
        <s:fieldset legend="Examenes" id="fieldExamenesLaboratorio" styleClass="fieldset">
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelExamenesLab"
                       rowClasses="labelCuestionario3,labelCuestionario4">
            <h:outputText value="Toxoplasma IGG" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="panelOutputTextResultadoIGG">
              <h:outputText value="Resultado IGG" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarToxoplasmaIGG}"/>
            </h:panelGroup>
            <h:panelGroup id="panelOutputTextIGG">
              <h:outputText value="Fecha IGG" styleClass="labelTextOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarToxoplasmaIGG}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuToxoplasmaIGG" immediate="true" onkeydown="return blockEnter(event);"
                                  binding="#{tamizajePrenatalUsuarioBean.mnuToxoplasmaIGG}"
                                  value="#{tamizajePrenatalUsuarioBean.tamizaje.htletoxoplaigg}"
                                  valueChangeListener="#{tamizajePrenatalUsuarioBean.setToxoplasmaIGG}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportToxoplasmaIGG" event="onclick" immediate="true"
                               action="#{tamizajePrenatalUsuarioBean.ChangeToxoplasmaIGG}"
                               reRender="panelFechaIGG,panelOutputTextIGG,panelOutputTextResultadoIGG,panelResultadoIGG">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuToxoplasmaIGG" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelResultadoIGG">
              <h:selectOneRadio id="mnuResultadoIGG" immediate="true" onkeydown="return blockEnter(event);"
                                rendered="#{tamizajePrenatalUsuarioBean.mostrarToxoplasmaIGG}"
                                value="#{tamizajePrenatalUsuarioBean.tamizaje.htlcresutoxigg}" styleClass="labelRadio">
                <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstResultado}"/>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuResultadoIGG" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelFechaIGG">
              <t:inputCalendar id="fechaToxoplasmaIGG" title="Formato: dd/mm/yyyy"
                               rendered="#{tamizajePrenatalUsuarioBean.mostrarToxoplasmaIGG}"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{tamizajePrenatalUsuarioBean.tamizaje.htldfechtoxigg}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechaToxoplasmaIGG" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="Toxoplasma IGM" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="panelOutputTextResultadoIGM">
              <h:outputText value="Resultado IGM" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarToxoplasmaIGM}"/>
            </h:panelGroup>
            <h:panelGroup id="panelOutputTextIGM">
              <h:outputText value="Fecha IGM" styleClass="labelTextOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarToxoplasmaIGM}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuToxoplasmaIGM" immediate="true" onkeydown="return blockEnter(event);"
                                  value="#{tamizajePrenatalUsuarioBean.tamizaje.htletoxoplaigm}"
                                  binding="#{tamizajePrenatalUsuarioBean.mnuToxoplasmaIGM}"
                                  valueChangeListener="#{tamizajePrenatalUsuarioBean.setToxoplasmaIGM}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportToxoplasmaIGM" event="onclick" immediate="true"
                               action="#{tamizajePrenatalUsuarioBean.ChangeToxoplasmaIGM}"
                               reRender="panelFechaIGM,panelOutputTextIGM,panelOutputTextResultadoIGM,panelResultadoIGM">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuToxoplasmaIGM" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelResultadoIGM">
              <h:selectOneRadio id="mnuResultadoIGM" immediate="true" onkeydown="return blockEnter(event);"
                                rendered="#{tamizajePrenatalUsuarioBean.mostrarToxoplasmaIGM}"
                                value="#{tamizajePrenatalUsuarioBean.tamizaje.htlcresutoxigm}" styleClass="labelRadio">
                <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstResultado}"/>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuResultadoIGM" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelFechaIGM">
              <t:inputCalendar id="fechaToxoplasmaIGM" title="Formato: dd/mm/yyyy"
                               rendered="#{tamizajePrenatalUsuarioBean.mostrarToxoplasmaIGM}"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{tamizajePrenatalUsuarioBean.tamizaje.htldfechtoxigm}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechaToxoplasmaIGM" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="Test O´Sullivan" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="panelTextResultadoSullivan">
              <h:outputText value="Resultado Test O´Sullivan" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarTest}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextSullivan">
              <h:outputText value="Fecha Test O´Sullivan" rendered="#{tamizajePrenatalUsuarioBean.mostrarTest}"
                            styleClass="labelTextOblig"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuSullivan" immediate="true" onkeydown="return blockEnter(event);"
                                  binding="#{tamizajePrenatalUsuarioBean.mnuSullivan}"
                                  value="#{tamizajePrenatalUsuarioBean.tamizaje.htletestsulliv}"
                                  valueChangeListener="#{tamizajePrenatalUsuarioBean.setTestSullivan}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportSullivan" event="onclick" immediate="true"
                               action="#{tamizajePrenatalUsuarioBean.ChangeTextSullivan}"
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
                           rendered="#{tamizajePrenatalUsuarioBean.mostrarTest}" maxlength="3" style="width:40px"
                           value="#{tamizajePrenatalUsuarioBean.tamizaje.htlnrestestsul}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itResSullivan" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelFechaSullivan">
              <t:inputCalendar id="fechaSullivan" title="Formato: dd/mm/yyyy"
                               rendered="#{tamizajePrenatalUsuarioBean.mostrarTest}"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{tamizajePrenatalUsuarioBean.tamizaje.htldfectestsul}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechaSullivan" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="Hemoglobina" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="panelTextResultadoHemoglobina">
              <h:outputText value="Resultado Hemoglobina" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarHemoglobina}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextFechaHemoglobina">
              <h:outputText value="Fecha Hemoglobina" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarHemoglobina}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuHemoglobina" immediate="true" onkeydown="return blockEnter(event);"
                                  binding="#{tamizajePrenatalUsuarioBean.mnuHemoglobina}"
                                  value="#{tamizajePrenatalUsuarioBean.tamizaje.htlehemoglobin}"
                                  valueChangeListener="#{tamizajePrenatalUsuarioBean.setHemoglobina}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportHemoglobina" event="onclick" immediate="true"
                               action="#{tamizajePrenatalUsuarioBean.ChangeHemoglobina}"
                               reRender="panelTextResultadoHemoglobina,panelTextFechaHemoglobina,panelResultadoHemoglobina,panelFechaHemoglobina">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuHemoglobina" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelResultadoHemoglobina">
              <h:inputText id="itResHemoglonina" onkeydown="return blockEnter(event);"
                           rendered="#{tamizajePrenatalUsuarioBean.mostrarHemoglobina}" maxlength="2" style="width:40px"
                           value="#{tamizajePrenatalUsuarioBean.tamizaje.htlnreshemoglo}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itResHemoglonina" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelFechaHemoglobina">
              <t:inputCalendar id="fechaHemoglobina" title="Formato: dd/mm/yyyy"
                               rendered="#{tamizajePrenatalUsuarioBean.mostrarHemoglobina}"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{tamizajePrenatalUsuarioBean.tamizaje.htldfechemoglo}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechaHemoglobina" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="Glucosa" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="panelTextResultadoGlucosa">
              <h:outputText value="Resultado Glucosa" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarGlucosa}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextFechaGlucosa">
              <h:outputText value="Fecha Glucosa" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarGlucosa}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuGlucosa" onkeydown="return blockEnter(event);" immediate="true"
                                  value="#{tamizajePrenatalUsuarioBean.tamizaje.htleglucosa}"
                                  binding="#{tamizajePrenatalUsuarioBean.mnuGlucosa}"
                                  valueChangeListener="#{tamizajePrenatalUsuarioBean.setGlucosa}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportGlucosa" event="onclick" immediate="true"
                               action="#{tamizajePrenatalUsuarioBean.ChangeGlucosa}"
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
                           rendered="#{tamizajePrenatalUsuarioBean.mostrarGlucosa}" maxlength="3" style="width:40px"
                           value="#{tamizajePrenatalUsuarioBean.tamizaje.htlnresglucosa}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itResGlucosa" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelFechaGlucosa">
              <t:inputCalendar id="fechaGlucosa" title="Formato: dd/mm/yyyy"
                               rendered="#{tamizajePrenatalUsuarioBean.mostrarGlucosa}"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{tamizajePrenatalUsuarioBean.tamizaje.htldfecglucosa}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechaGlucosa" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="Serologia" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="panelTextResultadoSerologia">
              <h:outputText value="Resultado Serologia" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarSerologia}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextFechaSerologia">
              <h:outputText value="Fecha Serologia" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarSerologia}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuSerologia" immediate="true" onkeydown="return blockEnter(event);"
                                  value="#{tamizajePrenatalUsuarioBean.tamizaje.htleserologia}"
                                  binding="#{tamizajePrenatalUsuarioBean.mnuSerologia}"
                                  valueChangeListener="#{tamizajePrenatalUsuarioBean.setSerologia}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportSerologia" event="onclick" immediate="true"
                               action="#{tamizajePrenatalUsuarioBean.ChangeSerologia}"
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
                                rendered="#{tamizajePrenatalUsuarioBean.mostrarSerologia}"
                                value="#{tamizajePrenatalUsuarioBean.tamizaje.htleresuserolo}" styleClass="labelRadio">
                <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstResultado}"/>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="panelResultadoSerologia" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelFechaSerologia">
              <t:inputCalendar id="fechaSerologia" title="Formato: dd/mm/yyyy"
                               rendered="#{tamizajePrenatalUsuarioBean.mostrarSerologia}"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{tamizajePrenatalUsuarioBean.tamizaje.htldfecserolog}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechaSerologia" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
           
            <h:outputText value="Urocultivo" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="panelTextResultadoUrocultivo">
              <h:outputText value="Resultado Urocultivo" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarUrocultivo}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextFechaUrocultivo">
              <h:outputText value="Fecha Urocultivo" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarUrocultivo}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuUrocultivo" onkeydown="return blockEnter(event);" immediate="true" required="true"
                                  value="#{tamizajePrenatalUsuarioBean.tamizaje.htleurocultivo}"
                                  binding="#{tamizajePrenatalUsuarioBean.mnuUrocultivo}"
                                  valueChangeListener="#{tamizajePrenatalUsuarioBean.setHtleurocultivo}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportUrocultivo" event="onclick" immediate="true"
                               action="#{tamizajePrenatalUsuarioBean.ChangeNuevasOpciones}"
                               reRender="panelTextResultadoUrocultivo,panelTextFechaUrocultivo,panelResultadoUrocultivo,panelFechaUrocultivo">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuUrocultivo" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelResultadoUrocultivo">
              <h:inputText id="itResUrocultivo" onkeydown="return blockEnter(event);"
                           rendered="#{tamizajePrenatalUsuarioBean.mostrarUrocultivo}"
                           value="#{tamizajePrenatalUsuarioBean.tamizaje.htlcresulurocu}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itResUrocultivo" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelFechaUrocultivo">
              <t:inputCalendar id="fechaUrocultivo" title="Formato: dd/mm/yyyy"
                               rendered="#{tamizajePrenatalUsuarioBean.mostrarUrocultivo}"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{tamizajePrenatalUsuarioBean.tamizaje.htldfechaurocu}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechaUrocultivo" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
            
            <h:outputText value="Antibiograma" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="panelTextResultadoAntibiograma">
              <h:outputText value="Resultado Antibiograma" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarAntibiograma}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextFechaAntibiograma">
              <h:outputText value="Fecha Antibiograma" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarAntibiograma}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuAntibiograma" onkeydown="return blockEnter(event);" immediate="true"
                                  required="true"
                                  value="#{tamizajePrenatalUsuarioBean.tamizaje.htleantibiogra}"
                                  binding="#{tamizajePrenatalUsuarioBean.mnuAntibiograma}"
                                  valueChangeListener="#{tamizajePrenatalUsuarioBean.setHtleantibiogra}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportAntibiograma" event="onclick" immediate="true"
                               action="#{tamizajePrenatalUsuarioBean.ChangeNuevasOpciones}"
                               reRender="panelTextResultadoAntibiograma,panelTextFechaAntibiograma,panelResultadoAntibiograma,panelFechaAntibiograma">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntibiograma" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelResultadoAntibiograma">
              <h:inputText id="itResAntibiograma" onkeydown="return blockEnter(event);"
                           rendered="#{tamizajePrenatalUsuarioBean.mostrarAntibiograma}"
                           value="#{tamizajePrenatalUsuarioBean.tamizaje.htlcresulantib}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itResAntibiograma" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelFechaAntibiograma">
              <t:inputCalendar id="fechAntibiograma" title="Formato: dd/mm/yyyy"
                               rendered="#{tamizajePrenatalUsuarioBean.mostrarAntibiograma}"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{tamizajePrenatalUsuarioBean.tamizaje.htldfechaantib}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechAntibiograma" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
            <h:outputText value="Hemograma" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="panelTextResultadoHemograma">
              <h:outputText value="Resultado Hemograma" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarHemograma}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextFechaHemograma">
              <h:outputText value="Fecha Hemograma" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarHemograma}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuHemograma" onkeydown="return blockEnter(event);" immediate="true"
                                  required="true"
                                  value="#{tamizajePrenatalUsuarioBean.tamizaje.htlehemograma}"
                                  binding="#{tamizajePrenatalUsuarioBean.mnuHemograma}"
                                  valueChangeListener="#{tamizajePrenatalUsuarioBean.setHtlehemograma}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportHemograma" event="onclick" immediate="true"
                               action="#{tamizajePrenatalUsuarioBean.ChangeNuevasOpciones}"
                               reRender="panelTextResultadoHemograma,panelTextFechaHemograma,panelResultadoHemograma,panelFechaHemograma">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuHemograma" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelResultadoHemograma">
              <h:inputText id="itResHemograma" onkeydown="return blockEnter(event);"
                           rendered="#{tamizajePrenatalUsuarioBean.mostrarHemograma}"
                           value="#{tamizajePrenatalUsuarioBean.tamizaje.htlcresulhemog}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itResHemograma" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelFechaHemograma">
              <t:inputCalendar id="fechHemograma" title="Formato: dd/mm/yyyy"
                               rendered="#{tamizajePrenatalUsuarioBean.mostrarHemograma}"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{tamizajePrenatalUsuarioBean.tamizaje.htldfechahemog}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechHemograma" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
            
             <h:outputText value="Hemoclasificación" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="panelTextResultadoHemoclasificacion">
              <h:outputText value="Resultado Hemoclasificación" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarHemoclasificacion}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextFechaHemoclasificacion">
              <h:outputText value="Fecha Hemoclasificacion" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarHemoclasificacion}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuHemoclasificacion" onkeydown="return blockEnter(event);" immediate="true"
                                  required="true"
                                  value="#{tamizajePrenatalUsuarioBean.tamizaje.htlehemoclasif}"
                                  binding="#{tamizajePrenatalUsuarioBean.mnuHemoclasificacion}"
                                  valueChangeListener="#{tamizajePrenatalUsuarioBean.setHtlehemoclasif}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportHemoclasificacion" event="onclick" immediate="true"
                               action="#{tamizajePrenatalUsuarioBean.ChangeNuevasOpciones}"
                               reRender="panelTextResultadoHemoclasificacion,panelTextFechaHemoclasificacion,panelResultadoHemoclasificacion,panelFechaHemoclasificacion">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuHemoclasificacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelResultadoHemoclasificacion">
              <h:inputText id="itResHemoclasificacion" onkeydown="return blockEnter(event);"
                           rendered="#{tamizajePrenatalUsuarioBean.mostrarHemoclasificacion}"
                           value="#{tamizajePrenatalUsuarioBean.tamizaje.htlcresulhemoc}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itResHemoclasificacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelFechaHemoclasificacion">
              <t:inputCalendar id="fechHemoclasificacion" title="Formato: dd/mm/yyyy"
                               rendered="#{tamizajePrenatalUsuarioBean.mostrarHemoclasificacion}"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{tamizajePrenatalUsuarioBean.tamizaje.htldfechahemoc}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechHemoclasificacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
              <h:outputText value="Prueba rápida para VIH (VIH 1-VIH 2)" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="panelTextResultadoPruebaRapiVIH">
              <h:outputText value="Resultado Prueba rápida para VIH (VIH 1-VIH 2)" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarPruebaRapiVIH}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextFechaPruebaRapiVIH">
              <h:outputText value="Fecha Prueba rápida para VIH (VIH 1-VIH 2)" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarPruebaRapiVIH}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuPruebaRapiVIH" onkeydown="return blockEnter(event);" immediate="true"
                                  required="true"
                                  value="#{tamizajePrenatalUsuarioBean.tamizaje.htleprurapvih}"
                                  binding="#{tamizajePrenatalUsuarioBean.mnuPruebaRapiVIH}"
                                  valueChangeListener="#{tamizajePrenatalUsuarioBean.setHtleprurapvih}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportPruebaRapiVIH" event="onclick" immediate="true"
                               action="#{tamizajePrenatalUsuarioBean.ChangeNuevasOpciones}"
                               reRender="panelTextResultadoPruebaRapiVIH,panelTextFechaPruebaRapiVIH,panelResultadoPruebaRapiVIH,panelFechaPruebaRapiVIH">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuPruebaRapiVIH" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelResultadoPruebaRapiVIH">
              <h:inputText id="itResPruebaRapiVIH" onkeydown="return blockEnter(event);"
                           rendered="#{tamizajePrenatalUsuarioBean.mostrarPruebaRapiVIH}"
                           value="#{tamizajePrenatalUsuarioBean.tamizaje.htlcresulprravi}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itResPruebaRapiVIH" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelFechaPruebaRapiVIH">
              <t:inputCalendar id="fechPruebaRapiVIH" title="Formato: dd/mm/yyyy"
                               rendered="#{tamizajePrenatalUsuarioBean.mostrarPruebaRapiVIH}"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{tamizajePrenatalUsuarioBean.tamizaje.htldfechaprravi}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechPruebaRapiVIH" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
            
              <h:outputText value="Antígeno de superficie para  Hepatitis B  HbsAg" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="panelTextResultadoAntigenoHepatitis">
              <h:outputText value="Resultado Antígeno de superficie para  Hepatitis B  HbsAg" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarAntigenoHepatitis}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextFechaAntigenoHepatitis">
              <h:outputText value="Fecha Antígeno de superficie para  Hepatitis B  HbsAg" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarAntigenoHepatitis}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuAntigenoHepatitis" onkeydown="return blockEnter(event);" immediate="true"
                                  required="true"
                                  value="#{tamizajePrenatalUsuarioBean.tamizaje.htleantisupehepa}"
                                  binding="#{tamizajePrenatalUsuarioBean.mnuAntigenoHepatitis}"
                                  valueChangeListener="#{tamizajePrenatalUsuarioBean.setHtleantisupehepa}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportAntigenoHepatitis" event="onclick" immediate="true"
                               action="#{tamizajePrenatalUsuarioBean.ChangeNuevasOpciones}"
                               reRender="panelTextResultadoAntigenoHepatitis,panelTextFechaAntigenoHepatitis,panelResultadoAntigenoHepatitis,panelFechaAntigenoHepatitis">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntigenoHepatitis" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelResultadoAntigenoHepatitis">
              <h:inputText id="itResAntigenoHepatitis" onkeydown="return blockEnter(event);"
                           rendered="#{tamizajePrenatalUsuarioBean.mostrarAntigenoHepatitis}"
                           value="#{tamizajePrenatalUsuarioBean.tamizaje.htlcresulansuhe}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itResAntigenoHepatitis" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelFechaAntigenoHepatitis">
              <t:inputCalendar id="fechAntigenoHepatitis" title="Formato: dd/mm/yyyy"
                               rendered="#{tamizajePrenatalUsuarioBean.mostrarAntigenoHepatitis}"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{tamizajePrenatalUsuarioBean.tamizaje.htldfechaansuhe}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechAntigenoHepatitis" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
            
             <h:outputText value="Tamizaje de cáncer de cuello" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="panelTextResultadoTamizajeCancerCuello">
              <h:outputText value="Resultado Tamizaje de cáncer de cuello" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarTamizajeCancerCuello}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextFechaTamizajeCancerCuello">
              <h:outputText value="Fecha Tamizaje de cáncer de cuello" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarTamizajeCancerCuello}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuTamizajeCancerCuello" onkeydown="return blockEnter(event);" immediate="true"
                                  required="true"
                                  value="#{tamizajePrenatalUsuarioBean.tamizaje.htletamcancue}"
                                  binding="#{tamizajePrenatalUsuarioBean.mnuTamizajeCancerCuello}"
                                  valueChangeListener="#{tamizajePrenatalUsuarioBean.setHtletamcancue}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportTamizajeCancerCuello" event="onclick" immediate="true"
                               action="#{tamizajePrenatalUsuarioBean.ChangeNuevasOpciones}"
                               reRender="panelTextResultadoTamizajeCancerCuello,panelTextFechaTamizajeCancerCuello,panelResultadoTamizajeCancerCuello,panelFechaTamizajeCancerCuello">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuTamizajeCancerCuello" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelResultadoTamizajeCancerCuello">
              <h:inputText id="itResTamizajeCancerCuello" onkeydown="return blockEnter(event);"
                           rendered="#{tamizajePrenatalUsuarioBean.mostrarTamizajeCancerCuello}"
                           value="#{tamizajePrenatalUsuarioBean.tamizaje.htlcresultacacu}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itResTamizajeCancerCuello" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelFechaTamizajeCancerCuello">
              <t:inputCalendar id="fechTamizajeCancerCuello" title="Formato: dd/mm/yyyy"
                               rendered="#{tamizajePrenatalUsuarioBean.mostrarTamizajeCancerCuello}"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{tamizajePrenatalUsuarioBean.tamizaje.htldfechatacacu}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechTamizajeCancerCuello" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
            
             <h:outputText value="Pruebas de IgG para Rubeola en mujeres no vacunadas" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="panelTextResultadoPruebasIgg">
              <h:outputText value="Resultado Pruebas de IgG para Rubeola en mujeres no vacunadas" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarPruebasIgg}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextFechaPruebasIgg">
              <h:outputText value="Fecha Pruebas de IgG para Rubeola en mujeres no vacunadas" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarPruebasIgg}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuPruebasIgg" onkeydown="return blockEnter(event);" immediate="true"
                                  required="true"
                                  value="#{tamizajePrenatalUsuarioBean.tamizaje.htlepruigg}"
                                  binding="#{tamizajePrenatalUsuarioBean.mnuPruebasIgg}"
                                  valueChangeListener="#{tamizajePrenatalUsuarioBean.setHtlepruigg}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportPruebasIgg" event="onclick" immediate="true"
                               action="#{tamizajePrenatalUsuarioBean.ChangeNuevasOpciones}"
                               reRender="panelTextResultadoPruebasIgg,panelTextFechaPruebasIgg,panelResultadoPruebasIgg,panelFechaPruebasIgg">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuPruebasIgg" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelResultadoPruebasIgg">
              <h:inputText id="itResPruebasIgg" onkeydown="return blockEnter(event);"
                           rendered="#{tamizajePrenatalUsuarioBean.mostrarPruebasIgg}"
                           value="#{tamizajePrenatalUsuarioBean.tamizaje.htlcresulpruigg}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itResPruebasIgg" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelFechaPruebasIgg">
              <t:inputCalendar id="fechPruebasIgg" title="Formato: dd/mm/yyyy"
                               rendered="#{tamizajePrenatalUsuarioBean.mostrarPruebasIgg}"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{tamizajePrenatalUsuarioBean.tamizaje.htldfechpruigg}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechPruebasIgg" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
            
              <h:outputText value="Pruebas de IgA para toxoplasma" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="panelTextResultadoPruebasIga">
              <h:outputText value="Resultado Pruebas de IgA para toxoplasma" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarPruebasIga}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextFechaPruebasIga">
              <h:outputText value="Fecha Pruebas de IgA para toxoplasma" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarPruebasIga}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuPruebasIga" onkeydown="return blockEnter(event);" immediate="true"
                                  required="true"
                                  value="#{tamizajePrenatalUsuarioBean.tamizaje.htlepruigatox}"
                                  binding="#{tamizajePrenatalUsuarioBean.mnuPruebasIga}"
                                  valueChangeListener="#{tamizajePrenatalUsuarioBean.setHtlepruigatox}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportPruebasIga" event="onclick" immediate="true"
                               action="#{tamizajePrenatalUsuarioBean.ChangeNuevasOpciones}"
                               reRender="panelTextResultadoPruebasIga,panelTextFechaPruebasIga,panelResultadoPruebasIga,panelFechaPruebasIga">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuPruebasIga" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelResultadoPruebasIga">
              <h:inputText id="itResPruebasIga" onkeydown="return blockEnter(event);"
                           rendered="#{tamizajePrenatalUsuarioBean.mostrarPruebasIga}"
                           value="#{tamizajePrenatalUsuarioBean.tamizaje.htlcresulprigto}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itResPruebasIga" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelFechaPruebasIga">
              <t:inputCalendar id="fechPruebasIga" title="Formato: dd/mm/yyyy"
                               rendered="#{tamizajePrenatalUsuarioBean.mostrarPruebasIga}"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{tamizajePrenatalUsuarioBean.tamizaje.htldfechprigto}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechPruebasIga" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
            
            <h:outputText value="Tamización para estreptococo del grupo B con cultivo rectal y vaginal" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="panelTextResultadoTamizacionEstreptococo">
              <h:outputText value="Resultado Tamización para estreptococo del grupo B con cultivo rectal y vaginal" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarTamizacionEstreptococo}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextFechaTamizacionEstreptococo">
              <h:outputText value="Fecha Tamización para estreptococo del grupo B con cultivo rectal y vaginal" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarTamizacionEstreptococo}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuTamizacionEstreptococo" onkeydown="return blockEnter(event);" immediate="true"
                                  required="true"
                                  value="#{tamizajePrenatalUsuarioBean.tamizaje.htletamizestre}"
                                  binding="#{tamizajePrenatalUsuarioBean.mnuTamizacionEstreptococo}"
                                  valueChangeListener="#{tamizajePrenatalUsuarioBean.setHtletamizestre}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportTamizacionEstreptococo" event="onclick" immediate="true"
                               action="#{tamizajePrenatalUsuarioBean.ChangeNuevasOpciones}"
                               reRender="panelTextResultadoTamizacionEstreptococo,panelTextFechaTamizacionEstreptococo,panelResultadoTamizacionEstreptococo,panelFechaTamizacionEstreptococo">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuTamizacionEstreptococo" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelResultadoTamizacionEstreptococo">
              <h:inputText id="itResTamizacionEstreptococo" onkeydown="return blockEnter(event);"
                           rendered="#{tamizajePrenatalUsuarioBean.mostrarTamizacionEstreptococo}"
                           value="#{tamizajePrenatalUsuarioBean.tamizaje.htlcresultamest}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itResTamizacionEstreptococo" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelFechaTamizacionEstreptococo">
              <t:inputCalendar id="fechTamizacionEstreptococo" title="Formato: dd/mm/yyyy"
                               rendered="#{tamizajePrenatalUsuarioBean.mostrarTamizacionEstreptococo}"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{tamizajePrenatalUsuarioBean.tamizaje.htldfechtamest}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechTamizacionEstreptococo" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
            
            <h:outputText value="Prueba de tolerancia oral a la glucosa (PTOG)" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="panelTextResultadoPruebasTolerancia">
              <h:outputText value="Resultado Prueba de tolerancia oral a la glucosa (PTOG)" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarPruebasTolerancia}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextFechaPruebasTolerancia">
              <h:outputText value="Fecha Prueba de tolerancia oral a la glucosa (PTOG)" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarPruebasTolerancia}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuPruebasTolerancia" onkeydown="return blockEnter(event);" immediate="true"
                                  required="true"
                                  value="#{tamizajePrenatalUsuarioBean.tamizaje.htleprutoloraglu}"
                                  binding="#{tamizajePrenatalUsuarioBean.mnuPruebasTolerancia}"
                                  valueChangeListener="#{tamizajePrenatalUsuarioBean.setHtleprutoloraglu}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportPruebasTolerancia" event="onclick" immediate="true"
                               action="#{tamizajePrenatalUsuarioBean.ChangeNuevasOpciones}"
                               reRender="panelTextResultadoPruebasTolerancia,panelTextFechaPruebasTolerancia,panelResultadoPruebasTolerancia,panelFechaPruebasTolerancia">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuPruebasTolerancia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelResultadoPruebasTolerancia">
              <h:inputText id="itResPruebasTolerancia" onkeydown="return blockEnter(event);"
                           rendered="#{tamizajePrenatalUsuarioBean.mostrarPruebasTolerancia}"
                           value="#{tamizajePrenatalUsuarioBean.tamizaje.htlcresulprtoorgl}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itResPruebasTolerancia" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelFechaPruebasTolerancia">
              <t:inputCalendar id="fechPruebasTolerancia" title="Formato: dd/mm/yyyy"
                               rendered="#{tamizajePrenatalUsuarioBean.mostrarPruebasTolerancia}"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{tamizajePrenatalUsuarioBean.tamizaje.htldfechprtoorgl}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechPruebasTolerancia" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
            
            <h:outputText value="Tamizaje con gota gruesa" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="panelTextResultadoTamizajeGotaGruesa">
              <h:outputText value="Resultado Tamizaje con gota gruesa" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarTamizajeGotaGruesa}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextFechaTamizajeGotaGruesa">
              <h:outputText value="Fecha Tamizaje con gota gruesa" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarTamizajeGotaGruesa}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuTamizajeGotaGruesa" onkeydown="return blockEnter(event);" immediate="true"
                                  required="true"
                                  value="#{tamizajePrenatalUsuarioBean.tamizaje.htletamgotgru}"
                                  binding="#{tamizajePrenatalUsuarioBean.mnuTamizajeGotaGruesa}"
                                  valueChangeListener="#{tamizajePrenatalUsuarioBean.setHtletamgotgru}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportTamizajeGotaGruesa" event="onclick" immediate="true"
                               action="#{tamizajePrenatalUsuarioBean.ChangeNuevasOpciones}"
                               reRender="panelTextResultadoTamizajeGotaGruesa,panelTextFechaTamizajeGotaGruesa,panelResultadoTamizajeGotaGruesa,panelFechaTamizajeGotaGruesa">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuTamizajeGotaGruesa" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelResultadoTamizajeGotaGruesa">
              <h:inputText id="itResTamizajeGotaGruesa" onkeydown="return blockEnter(event);"
                           rendered="#{tamizajePrenatalUsuarioBean.mostrarTamizajeGotaGruesa}"
                           value="#{tamizajePrenatalUsuarioBean.tamizaje.htlcresultagogr}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itResTamizajeGotaGruesa" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelFechaTamizajeGotaGruesa">
              <t:inputCalendar id="fechTamizajeGotaGruesa" title="Formato: dd/mm/yyyy"
                               rendered="#{tamizajePrenatalUsuarioBean.mostrarTamizajeGotaGruesa}"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{tamizajePrenatalUsuarioBean.tamizaje.htldfechtagogr}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechTamizajeGotaGruesa" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
            
              <h:outputText value="ElISA para enfermedad de chagas" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="panelTextResultadoElisa">
              <h:outputText value="Resultado ElISA para enfermedad de chagas" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarElisa}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextFechaElisa">
              <h:outputText value="Fecha ElISA para enfermedad de chagas" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarElisa}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuElisa" onkeydown="return blockEnter(event);" immediate="true"
                                  required="true"
                                  value="#{tamizajePrenatalUsuarioBean.tamizaje.htleelisa}"
                                  binding="#{tamizajePrenatalUsuarioBean.mnuElisa}"
                                  valueChangeListener="#{tamizajePrenatalUsuarioBean.setHtleelisa}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportElisa" event="onclick" immediate="true"
                               action="#{tamizajePrenatalUsuarioBean.ChangeNuevasOpciones}"
                               reRender="panelTextResultadoElisa,panelTextFechaElisa,panelResultadoElisa,panelFechaElisa">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuElisa" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelResultadoElisa">
              <h:inputText id="itResElisa" onkeydown="return blockEnter(event);"
                           rendered="#{tamizajePrenatalUsuarioBean.mostrarElisa}"
                           value="#{tamizajePrenatalUsuarioBean.tamizaje.htlcresulelisa}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itResElisa" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelFechaElisa">
              <t:inputCalendar id="fechElisa" title="Formato: dd/mm/yyyy"
                               rendered="#{tamizajePrenatalUsuarioBean.mostrarElisa}"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{tamizajePrenatalUsuarioBean.tamizaje.htldfechelisa}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechElisa" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
            
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend=" " id="fieldExamenes" styleClass="fieldset">
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelExamenesLaboratorios" rowClasses="labelCuestionario3,labelCuestionario4">
            <h:outputText value="Ecografia" styleClass="labelTextNoOblig"/>
            <h:panelGroup id="panelTextEcografia">
              <h:outputText value="Descripción de Ecografia" styleClass="labelTextNoOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.mostrarEcografia}"/>
            </h:panelGroup>
            <h:outputText value="Micronutrientes" styleClass="labelTextNoOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuEcografia" onkeydown="return blockEnter(event);" immediate="true"
                                  styleClass="labelRadio" required="true"
                                  binding="#{tamizajePrenatalUsuarioBean.mnuEcografia}"
                                  value="#{tamizajePrenatalUsuarioBean.tieneEcografia}"
                                  valueChangeListener="#{tamizajePrenatalUsuarioBean.setTieneEcografia}">
                  <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportmnuEcografia" event="onclick"
                               action="#{tamizajePrenatalUsuarioBean.changeEcografia}"
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
                               rendered="#{tamizajePrenatalUsuarioBean.mostrarEcografia}"
                               value="#{tamizajePrenatalUsuarioBean.tamizaje.htlcecografia}"/>
            </h:panelGroup>
            <h:panelGroup>
              <h:selectOneRadio id="mnuMicroNutrientes" onkeydown="return blockEnter(event);" immediate="true"
                                styleClass="labelRadio" required="true"
                                value="#{tamizajePrenatalUsuarioBean.tamizaje.htlemicronutri}">
                <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpciones}"/>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuMicroNutrientes" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="Parcial de Orina"/>
            <h:panelGroup id="panelTextParcialOrinaDes">
              <h:outputText value="Descripción" styleClass="labelTextOblig"
                            rendered="#{tamizajePrenatalUsuarioBean.existeParcial}"/>
            </h:panelGroup>
            <h:panelGroup></h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuParcialOrina" onkeydown="return blockEnter(event);" immediate="true"
                                  styleClass="labelRadio"
                                  value="#{tamizajePrenatalUsuarioBean.tamizaje.htleparciorina}"
                                  binding="#{tamizajePrenatalUsuarioBean.mnuParcialOrina}"
                                  valueChangeListener="#{tamizajePrenatalUsuarioBean.setParcialOrina}">
                  <f:selectItems value="#{tamizajePrenatalUsuarioBean.lstOpcionesPruebaOrina}"/>
                  <a4j:support id="supportParcialOrina" event="onclick"
                               action="#{tamizajePrenatalUsuarioBean.changeParcial}"
                               reRender="panelTextParcialOrinaDes,panelMenuParcialOrinaDesc,itAreaParcial">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuParcialOrina" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelMenuParcialOrinaDesc">
              <h:inputTextarea id="itAreaParcial" onkeydown="return blockEnter(event);"
                               rendered="#{tamizajePrenatalUsuarioBean.existeParcial}"
                               binding="#{tamizajePrenatalUsuarioBean.parcialOrinaDesc}"
                               value="#{tamizajePrenatalUsuarioBean.tamizaje.htlcparorides}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itAreaParcial" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="boton_fieldset"
                             action="#{tamizajePrenatalUsuarioBean.aceptar}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
      <s:fieldset legend="Examenes Anteriores Consultas Prenatal" id="fieldListaExamenesPrenatal" styleClass="fieldset"
                  rendered="#{not empty tamizajePrenatalUsuarioBean.lstHistorialTamizaje}">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableControlPrenatal"
                     styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         value="#{tamizajePrenatalUsuarioBean.lstHistorialTamizaje}" rows="10"
                         styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
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
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_1" for="dtControlPrenatal" fastStep="10" pageCountVar="pageCount"
                              pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                              paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                              paginatorActiveColumnStyle="font-weight:bold;">
                <f:facet name="first">
                  <t:graphicImage alt="" url="/comun/imagenes/primero.gif" border="0"/>
                </f:facet>
                <f:facet name="last">
                  <t:graphicImage alt="" url="/comun/imagenes/ultimo.gif" border="0"/>
                </f:facet>
                <f:facet name="previous">
                  <t:graphicImage alt="" url="/comun/imagenes/anterior.gif" border="0"/>
                </f:facet>
                <f:facet name="next">
                  <t:graphicImage alt="" url="/comun/imagenes/siguiente.gif" border="0"/>
                </f:facet>
                <f:facet name="fastforward">
                  <t:graphicImage alt="" url="/comun/imagenes/adelante.gif" border="0"/>
                </f:facet>
                <f:facet name="fastrewind">
                  <t:graphicImage alt="" url="/comun/imagenes/atras.gif" border="0"/>
                </f:facet>
              </t:dataScroller>
            </h:panelGrid>
          </t:buffer>
          <h:outputText value="#{tableScroller}" escape="false"/>
          <h:outputText value="#{table}" escape="false"/>
          <h:outputText value="#{tableScroller}" escape="false"/>
        </h:panelGrid>
      </s:fieldset>
      <h:panelGrid>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrors1" showSummary="true" errorClass="error" globalOnly="true"
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