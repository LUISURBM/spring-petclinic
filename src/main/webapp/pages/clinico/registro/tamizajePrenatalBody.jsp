<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formTamizajePrenatal">
  <a4j:region id="regionTamizajePrenatal" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionTamizajePrenatal">
      <f:facet name="start">
        <t:div id="chargingTamizajePrenatal" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
   
  
    <h:panelGrid columns="1" id="tableInfoUbication" border="0" cellpadding="0"
                 cellspacing="0" width="100%" styleClass="td_ubicador">
    
        <h:panelGroup>
              <h:outputText value = "Fecha Actual: "/> 
                <t:inputCalendar id="fechaToxoplasmaIGG" title="Formato: dd/mm/yyyy"
                             onkeydown="return blockEnter(event);"
                             monthYearRowClass="yearMonthHeader"
                             weekRowClass="weekHeader"
                             currentDayCellClass="currentDayCell"
                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                             value="#{tamizajePrenatalBean.fechaActual}"
                             popupTodayString="Hoy" popupWeekString="Semana"
                             popupButtonString="Fecha" readonly="false"
                             maxlength="11" size="11"
                             popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                             renderPopupButtonAsImage="true" align="top"
                             required="true"/>
               </h:panelGroup>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridTamizajePrenatalTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneTamizajePrenatal"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabTamizajePrenatal"
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
                <h:panelGroup id = "panelOutputTextResultadoIGG">
                  <h:outputText value="Resultado IGG"  rendered="#{tamizajePrenatalBean.mostrarToxoplasmaIGG}"/>
                </h:panelGroup>
                <h:panelGroup id="panelOutputTextIGG">
                  <h:outputText value="Fecha IGG" styleClass="labelTextOblig"
                                rendered="#{tamizajePrenatalBean.mostrarToxoplasmaIGG}"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuToxoplasmaIGG" immediate="true"
                                      value="#{tamizajePrenatalBean.tamizaje.htletoxoplaigg}"
                                      valueChangeListener="#{tamizajePrenatalBean.setToxoplasmaIGG}"
                                      styleClass="labelRadio">
                      <f:selectItems value="#{tamizajePrenatalBean.lstOpciones}"/>
                      <a4j:support id="supportToxoplasmaIGG" event="onclick"
                                   immediate="true"
                                   action="#{tamizajePrenatalBean.ChangeToxoplasmaIGG}"
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
                <h:panelGroup id = "panelResultadoIGG">
                  <h:selectOneRadio id="mnuResultadoIGG" immediate="true"
                          rendered="#{tamizajePrenatalBean.mostrarToxoplasmaIGG}"
                           value="#{tamizajePrenatalBean.tamizaje.htlcresutoxigg}"
                           styleClass="labelRadio">
                    <f:selectItems value="#{tamizajePrenatalBean.lstResultado}"/>
                </h:selectOneRadio>
                 <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuResultadoIGG"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                
                </h:panelGroup>
                <h:panelGroup id = "panelFechaIGG">
            <t:inputCalendar id="fechaToxoplasmaIGG" title="Formato: dd/mm/yyyy"
                             rendered="#{tamizajePrenatalBean.mostrarToxoplasmaIGG}"
                             onkeydown="return blockEnter(event);"
                             monthYearRowClass="yearMonthHeader"
                             weekRowClass="weekHeader"
                             currentDayCellClass="currentDayCell"
                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                             value="#{tamizajePrenatalBean.tamizaje.htldfechtoxigg}"
                             popupTodayString="Hoy" popupWeekString="Semana"
                             popupButtonString="Fecha" readonly="false"
                             maxlength="11" size="11"
                             popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                             renderPopupButtonAsImage="true" align="top"
                             required="true"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="fechaToxoplasmaIGG" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
                <h:outputText value="Toxoplasma IGM"/>
                <h:panelGroup id = "panelOutputTextResultadoIGM">
                  <h:outputText value="Resultado IGM" rendered="#{tamizajePrenatalBean.mostrarToxoplasmaIGM}"/>
                </h:panelGroup>
                <h:panelGroup id="panelOutputTextIGM">
                  <h:outputText value="Fecha IGM" styleClass="labelTextOblig"
                                rendered="#{tamizajePrenatalBean.mostrarToxoplasmaIGM}"/>
                </h:panelGroup>
                 <a4j:region renderRegionOnly="false">
          <h:panelGroup>
            <h:selectOneRadio id="mnuToxoplasmaIGM" 
                              immediate="true"
                              value="#{tamizajePrenatalBean.tamizaje.htletoxoplaigm}"
                              valueChangeListener="#{tamizajePrenatalBean.setToxoplasmaIGM}"
                              styleClass="labelRadio">
              <f:selectItems value="#{tamizajePrenatalBean.lstOpciones}"/>
              <a4j:support id="supportToxoplasmaIGM" event="onclick"
                           immediate="true"
                           action="#{tamizajePrenatalBean.ChangeToxoplasmaIGM}"
                           reRender="panelFechaIGM,panelOutputTextIGM,panelOutputTextResultadoIGM,panelResultadoIGM">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuToxoplasmaIGM" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          </a4j:region>
          <h:panelGroup id = "panelResultadoIGM">
            <h:selectOneRadio id="mnuResultadoIGM" immediate="true"
                          rendered="#{tamizajePrenatalBean.mostrarToxoplasmaIGM}"
                           value="#{tamizajePrenatalBean.tamizaje.htlcresutoxigm}"
                           styleClass="labelRadio">
                    <f:selectItems value="#{tamizajePrenatalBean.lstResultado}"/>
                </h:selectOneRadio>
                 <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuResultadoIGM"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
            </h:panelGroup>
                  <h:panelGroup id = "panelFechaIGM">
            <t:inputCalendar id="fechaToxoplasmaIGM" title="Formato: dd/mm/yyyy"
                             rendered="#{tamizajePrenatalBean.mostrarToxoplasmaIGM}"
                             onkeydown="return blockEnter(event);"
                             monthYearRowClass="yearMonthHeader"
                             weekRowClass="weekHeader"
                             currentDayCellClass="currentDayCell"
                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                             value="#{tamizajePrenatalBean.tamizaje.htldfechtoxigm}"
                             popupTodayString="Hoy" popupWeekString="Semana"
                             popupButtonString="Fecha" readonly="false"
                             maxlength="11" size="11"
                             popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                             renderPopupButtonAsImage="true" align="top"
                             required="true"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="fechaToxoplasmaIGM" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
                <h:outputText value="Test O´Sullivan" />
                <h:panelGroup id = "panelTextResultadoSullivan">
                  <h:outputText value="Resultado Test O´Sullivan" rendered="#{tamizajePrenatalBean.mostrarTest}"/>
                </h:panelGroup>
                 <h:panelGroup id = "panelTextSullivan">
                         <h:outputText value="Fecha Test O´Sullivan" rendered="#{tamizajePrenatalBean.mostrarTest}"
                          styleClass="labelTextOblig"/>
                 </h:panelGroup>
                 <a4j:region renderRegionOnly="false">
          <h:panelGroup>
            <h:selectOneRadio id="mnuSullivan"  immediate="true"
                              value="#{tamizajePrenatalBean.tamizaje.htletestsulliv}"
                              valueChangeListener="#{tamizajePrenatalBean.setTestSullivan}"
                              styleClass="labelRadio">
              <f:selectItems value="#{tamizajePrenatalBean.lstOpciones}"/>
              <a4j:support id="supportSullivan" event="onclick" immediate="true"
                           action="#{tamizajePrenatalBean.ChangeTextSullivan}"
                           reRender="panelTextSullivan,panelFechaSullivan,panelTextResultadoSullivan,panelResultadoSullivan">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuSullivan" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          </a4j:region>
          <h:panelGroup id = "panelResultadoSullivan">
                <h:inputText id= "itResSullivan" rendered="#{tamizajePrenatalBean.mostrarTest}"
                maxlength="3" style="width:40px"
                value = "#{tamizajePrenatalBean.tamizaje.htlnrestestsul}"/>
                  <a4j:outputPanel ajaxRendered="true">
              <t:message for="itResSullivan" styleClass="errorMessage"/>
            </a4j:outputPanel>
            </h:panelGroup>
                 <h:panelGroup id = "panelFechaSullivan">
            <t:inputCalendar id="fechaSullivan" title="Formato: dd/mm/yyyy"
                             rendered="#{tamizajePrenatalBean.mostrarTest}"
                             onkeydown="return blockEnter(event);"
                             monthYearRowClass="yearMonthHeader"
                             weekRowClass="weekHeader"
                             currentDayCellClass="currentDayCell"
                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                             value="#{tamizajePrenatalBean.tamizaje.htldfectestsul}"
                             popupTodayString="Hoy" popupWeekString="Semana"
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
                <h:panelGroup id = "panelTextResultadoHemoglobina">
                  <h:outputText value="Resultado Hemoglobina" rendered="#{tamizajePrenatalBean.mostrarHemoglobina}"/>
                </h:panelGroup>
                <h:panelGroup id = "panelTextFechaHemoglobina">
                  <h:outputText value="Fecha Hemoglobina" rendered="#{tamizajePrenatalBean.mostrarHemoglobina}"/>
                </h:panelGroup>
                 <a4j:region renderRegionOnly="false">
          <h:panelGroup>
            <h:selectOneRadio id="mnuHemoglobina" 
                              immediate="true"
                              value="#{tamizajePrenatalBean.tamizaje.htlehemoglobin}"
                              valueChangeListener="#{tamizajePrenatalBean.setHemoglobina}"
                              styleClass="labelRadio">
              <f:selectItems value="#{tamizajePrenatalBean.lstOpciones}"/>
              <a4j:support id="supportHemoglobina" event="onclick"
                           immediate="true"
                           action="#{tamizajePrenatalBean.ChangeHemoglobina}"
                           reRender="panelTextResultadoHemoglobina,panelTextFechaHemoglobina,panelResultadoHemoglobina,panelFechaHemoglobina">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuHemoglobina" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          </a4j:region>
          <h:panelGroup id = "panelResultadoHemoglobina">
              <h:inputText id= "itResHemoglonina" rendered="#{tamizajePrenatalBean.mostrarHemoglobina}"
                maxlength="2" style="width:40px"
                value = "#{tamizajePrenatalBean.tamizaje.htlnreshemoglo}"/>
                  <a4j:outputPanel ajaxRendered="true">
              <t:message for="itResHemoglonina" styleClass="errorMessage"/>
            </a4j:outputPanel>
            </h:panelGroup>
                  <h:panelGroup id = "panelFechaHemoglobina">
            <t:inputCalendar id="fechaHemoglobina" title="Formato: dd/mm/yyyy"
                             rendered="#{tamizajePrenatalBean.mostrarHemoglobina}"
                             onkeydown="return blockEnter(event);"
                             monthYearRowClass="yearMonthHeader"
                             weekRowClass="weekHeader"
                             currentDayCellClass="currentDayCell"
                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                             value="#{tamizajePrenatalBean.tamizaje.htldfechemoglo}"
                             popupTodayString="Hoy" popupWeekString="Semana"
                             popupButtonString="Fecha" readonly="false"
                             maxlength="11" size="11"
                             popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                             renderPopupButtonAsImage="true" align="top"
                             required="true"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="fechaHemoglobina" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
                <h:outputText value="Glucosa"/>
                <h:panelGroup id = "panelTextResultadoGlucosa">
                  <h:outputText value="Resultado Glucosa" rendered="#{tamizajePrenatalBean.mostrarGlucosa}"/>
                </h:panelGroup>
                <h:panelGroup id = "panelTextFechaGlucosa">
                  <h:outputText value="Fecha Glucosa" rendered="#{tamizajePrenatalBean.mostrarGlucosa}"/>
                </h:panelGroup>
                 <a4j:region renderRegionOnly="false">
          <h:panelGroup>
            <h:selectOneRadio id="mnuGlucosa" 
                              immediate="true"
                              value="#{tamizajePrenatalBean.tamizaje.htleglucosa}"
                              valueChangeListener="#{tamizajePrenatalBean.setGlucosa}"
                              styleClass="labelRadio">
              <f:selectItems value="#{tamizajePrenatalBean.lstOpciones}"/>
              <a4j:support id="supportGlucosa" event="onclick"
                           immediate="true"
                           action="#{tamizajePrenatalBean.ChangeGlucosa}"
                           reRender="panelTextResultadoGlucosa,panelTextFechaGlucosa,panelResultadoGlucosa,panelFechaGlucosa">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuGlucosa" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          </a4j:region>
          <h:panelGroup id = "panelResultadoGlucosa">
           <h:inputText id= "itResGlucosa" rendered="#{tamizajePrenatalBean.mostrarGlucosa}"
                maxlength="3" style="width:40px"
                value = "#{tamizajePrenatalBean.tamizaje.htlnresglucosa}"/>
                  <a4j:outputPanel ajaxRendered="true">
              <t:message for="itResGlucosa" styleClass="errorMessage"/>
            </a4j:outputPanel>
            </h:panelGroup>
                  <h:panelGroup id = "panelFechaGlucosa">
            <t:inputCalendar id="fechaGlucosa" title="Formato: dd/mm/yyyy"
                             rendered="#{tamizajePrenatalBean.mostrarGlucosa}"
                             onkeydown="return blockEnter(event);"
                             monthYearRowClass="yearMonthHeader"
                             weekRowClass="weekHeader"
                             currentDayCellClass="currentDayCell"
                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                             value="#{tamizajePrenatalBean.tamizaje.htldfecglucosa}"
                             popupTodayString="Hoy" popupWeekString="Semana"
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
                <h:panelGroup id = "panelTextResultadoSerologia" >
                  <h:outputText value="Resultado Serologia" rendered="#{tamizajePrenatalBean.mostrarSerologia}"/>
                </h:panelGroup>
                <h:panelGroup id = "panelTextFechaSerologia">
                  <h:outputText value="Fecha Serologia" rendered="#{tamizajePrenatalBean.mostrarSerologia}"/>
                </h:panelGroup>
                   <a4j:region renderRegionOnly="false">
          <h:panelGroup>
            <h:selectOneRadio id="mnuSerologia" 
                              immediate="true"
                              value="#{tamizajePrenatalBean.tamizaje.htleserologia}"
                              valueChangeListener="#{tamizajePrenatalBean.setSerologia}"
                              styleClass="labelRadio">
              <f:selectItems value="#{tamizajePrenatalBean.lstOpciones}"/>
              <a4j:support id="supportSerologia" event="onclick"
                           immediate="true"
                           action="#{tamizajePrenatalBean.ChangeSerologia}"
                           reRender="panelTextResultadoSerologia,panelTextFechaSerologia,panelResultadoSerologia,panelFechaSerologia">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuSerologia" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          </a4j:region>
          <h:panelGroup id = "panelResultadoSerologia">
            <h:selectOneRadio id="mnuResultadoSerologia" immediate="true"
                          rendered="#{tamizajePrenatalBean.mostrarSerologia}"
                           value="#{tamizajePrenatalBean.tamizaje.htleresuserolo}"
                           styleClass="labelRadio">
                    <f:selectItems value="#{tamizajePrenatalBean.lstResultado}"/>
                </h:selectOneRadio>
                 <a4j:outputPanel ajaxRendered="true">
                      <t:message for="panelResultadoSerologia"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
            </h:panelGroup>
                  <h:panelGroup id = "panelFechaSerologia">
            <t:inputCalendar id="fechaSerologia" title="Formato: dd/mm/yyyy"
                             rendered="#{tamizajePrenatalBean.mostrarSerologia}"
                             onkeydown="return blockEnter(event);"
                             monthYearRowClass="yearMonthHeader"
                             weekRowClass="weekHeader"
                             currentDayCellClass="currentDayCell"
                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                             value="#{tamizajePrenatalBean.tamizaje.htldfecserolog}"
                             popupTodayString="Hoy" popupWeekString="Semana"
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
                                rendered="#{tamizajePrenatalBean.mostrarEcografia}"/>
                </h:panelGroup>
                <h:outputText value="Micronutrientes"/>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuEcografia" immediate="true"
                                      styleClass="labelRadio" required="true"
                                      value="#{tamizajePrenatalBean.tieneEcografia}"
                                      valueChangeListener="#{tamizajePrenatalBean.setTieneEcografia}">
                      <f:selectItems value="#{tamizajePrenatalBean.lstOpciones}"/>
                      <a4j:support id="supportmnuEcografia" event="onclick"
                                   action="#{tamizajePrenatalBean.changeEcografia}"
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
                                   rendered="#{tamizajePrenatalBean.mostrarEcografia}"
                                   value="#{tamizajePrenatalBean.tamizaje.htlcecografia}"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuMicroNutrientes" immediate="true"
                                    styleClass="labelRadio" required="true"
                                    value="#{tamizajePrenatalBean.tamizaje.htlemicronutri}">
                    <f:selectItems value="#{tamizajePrenatalBean.lstOpciones}"/>
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
                                rendered="#{tamizajePrenatalBean.existeParcial}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextProteinuria">
                  <h:outputText value="Proteinuria" styleClass="labelTextOblig"
                                rendered="#{tamizajePrenatalBean.existeParcial}"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuParcialOrina" immediate="true"
                                      styleClass="labelRadio" required="true"
                                      value="#{tamizajePrenatalBean.tamizaje.htleparciorina}"
                                      valueChangeListener="#{tamizajePrenatalBean.setParcialOrina}">
                      <f:selectItems value="#{tamizajePrenatalBean.lstOpciones}"/>
                      <a4j:support id="supportParcialOrina" event="onclick"
                                   action="#{tamizajePrenatalBean.changeParcial}"
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
                                    rendered="#{tamizajePrenatalBean.existeParcial}"
                                    styleClass="labelRadio" required="true"
                                    value="#{tamizajePrenatalBean.tamizaje.htlebacteriuri}">
                    <f:selectItems value="#{tamizajePrenatalBean.lstResultado}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuBacteriuria" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelMenuProteinuria">
                  <h:selectOneRadio id="mnuProteinuria" immediate="true"
                                    rendered="#{tamizajePrenatalBean.existeParcial}"
                                    styleClass="labelRadio" required="true"
                                    value="#{tamizajePrenatalBean.tamizaje.htleproteinuri}">
                    <f:selectItems value="#{tamizajePrenatalBean.lstResultado}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuProteinuria" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelTextHematies">
                  <h:outputText value="Hematies" styleClass="labelTextOblig"
                                rendered="#{tamizajePrenatalBean.existeParcial}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextLeucocitos">
                  <h:outputText value="Leucocitos" styleClass="labelTextOblig"
                                rendered="#{tamizajePrenatalBean.existeParcial}"/>
                </h:panelGroup>
                <h:panelGroup/>
                <h:panelGroup id="panelMenuHematies">
                  <h:selectOneRadio id="mnuHematies" immediate="true"
                                    rendered="#{tamizajePrenatalBean.existeParcial}"
                                    styleClass="labelRadio" required="true"
                                    value="#{tamizajePrenatalBean.tamizaje.htlehematies}">
                    <f:selectItems value="#{tamizajePrenatalBean.lstResultado}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuHematies" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelMenuLeucocitos">
                  <h:selectOneRadio id="mnuLeucocitos" immediate="true"
                                    rendered="#{tamizajePrenatalBean.existeParcial}"
                                    styleClass="labelRadio" required="true"
                                    value="#{tamizajePrenatalBean.tamizaje.htleleucocitos}">
                    <f:selectItems value="#{tamizajePrenatalBean.lstResultado}"/>
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
                                 action="#{tamizajePrenatalBean.aceptar}">
                  <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>
              </h:panelGroup>
            </h:panelGrid>
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