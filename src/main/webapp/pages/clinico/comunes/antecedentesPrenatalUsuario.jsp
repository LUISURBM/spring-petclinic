<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAntecedentesPrenatalTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneAntecedentesPrenatal"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabAntecedentesPrenatal"
                    label="Antecedentes Prenatal">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="tableContentTabsAntecedentesPrenatal"
                       styleClass="tabContainer">
            <s:fieldset legend="Antecedentes" id="fieldAntecedentesFamiliares"
                        styleClass="fieldset">                
        <a4j:region renderRegionOnly="false">
          <h:panelGrid columns="7">
            <h:outputText value="[ " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value=" Todos SI" immediate="true"
                             action="#{antecedentePrenatalUsuarioBean.changeTodosSi}" reRender="panelDatosAntecedentesFamiliares"/>
            <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true"
                             action="#{antecedentePrenatalUsuarioBean.changeTodosNo}" reRender="panelDatosAntecedentesFamiliares"/>
            <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true"
                             action="#{antecedentePrenatalUsuarioBean.changeNinguno}" reRender=" panelDatosAntecedentesFamiliares"/>
            <h:outputText value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
          </h:panelGrid>
        </a4j:region>
        <h:outputText value=" "/>
        <t:htmlTag value="br"/>
              <h:panelGrid columns="5" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelDatosAntecedentesFamiliares"
                           rowClasses="labelCuestionario3,labelCuestionario4">
                <h:outputText value="Antecedentes Familiares"/>
                <h:outputText/>
                <h:outputText/>
                <h:outputText value="Antecedentes Personales"/>
                <h:outputText/>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuHTACronicaFami" required="true"
                                      immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      value="#{antecedentePrenatalUsuarioBean.antecedente.hapchtacrofami}"
                                      valueChangeListener="#{antecedentePrenatalUsuarioBean.setHapchtacrofami}"
                                      styleClass="labelRadio">
                      <f:selectItems value="#{antecedentePrenatalUsuarioBean.lstOpciones}"/>
                      <a4j:support id="supportHTACronicaFami" event="onclick"
                                   immediate="true"
                                   action="#{antecedentePrenatalUsuarioBean.ChangeHtaFami}"
                                   reRender="panelInputHTAFami">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuHTACronicaFami"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputHTAFami">
                  <h:inputTextarea id="inputHtaFami" required="true"
                                   value="#{antecedentePrenatalUsuarioBean.antecedente.hapcdeshtacrof}"
                                   style="width:200px"
                                   rendered="#{antecedentePrenatalUsuarioBean.renderHTAfam}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputHtaFami" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="HTA Cronica"
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuHTA" required="true"
                                      onkeydown="return blockEnter(event);"
                                      immediate="true" styleClass="labelRadio"
                                      value="#{antecedentePrenatalUsuarioBean.antecedente.hapchtacropers}"
                                      valueChangeListener="#{antecedentePrenatalUsuarioBean.setHapchtacropers}">
                      <a4j:support id="supportmnuHTA" event="onclick"
                                   immediate="true"
                                   action="#{antecedentePrenatalUsuarioBean.ChangeHtaPers}"
                                   reRender="panelInputHTAPers">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentePrenatalUsuarioBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuHTA" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputHTAPers">
                  <h:inputTextarea id="inputHtaPers"  required="true"
                                   value="#{antecedentePrenatalUsuarioBean.antecedente.hapcdeshtacrop}"
                                   style="width:200px"
                                   rendered="#{antecedentePrenatalUsuarioBean.renderHTAper}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputHtaPers" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuDiabetesFami" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      styleClass="labelRadio" required="true"
                                      value="#{antecedentePrenatalUsuarioBean.antecedente.hapcdiabetfami}"
                                      valueChangeListener="#{antecedentePrenatalUsuarioBean.setHapcdiabetfami}">
                      <a4j:support id="supportDiabetesFami" event="onclick"
                                   immediate="true"
                                   action="#{antecedentePrenatalUsuarioBean.ChangeDiabetesFamiliar}"
                                   reRender="panelInputDiaFami">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentePrenatalUsuarioBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuDiabetesFami"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputDiaFami">
                  <h:inputTextarea id="inputDiaFami"  required="true"
                                   value="#{antecedentePrenatalUsuarioBean.antecedente.hapcdesdiabetf}"
                                   style="width:200px"
                                   rendered="#{antecedentePrenatalUsuarioBean.renderDiafam}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputDiaFami" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Diabetes "
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuDiabetes" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      required="true" styleClass="labelRadio"
                                      value="#{antecedentePrenatalUsuarioBean.antecedente.hapcdiabeperso}"
                                      valueChangeListener="#{antecedentePrenatalUsuarioBean.setHapcdiabeperso}">
                      <a4j:support id="supportDiabetesPers" event="onclick"
                                   immediate="true"
                                   action="#{antecedentePrenatalUsuarioBean.ChangeDiabetesPersonal}"
                                   reRender="panelInputDiaPers">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentePrenatalUsuarioBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuDiabetes" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputDiaPers">
                  <h:inputTextarea id="inputDiaPers"  required="true"
                                   value="#{antecedentePrenatalUsuarioBean.antecedente.hapcdesdiabepe}"
                                   style="width:200px"
                                   rendered="#{antecedentePrenatalUsuarioBean.renderDiaper}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputDiaPers" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuPreeclampsiaFami" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      styleClass="labelRadio" required="true"
                                      value="#{antecedentePrenatalUsuarioBean.antecedente.hapcpreeclfami}"
                                      valueChangeListener="#{antecedentePrenatalUsuarioBean.setHapcpreeclfami}">
                      <a4j:support id="supportPreeclampsiaFami" event="onclick"
                                   immediate="true"
                                   action="#{antecedentePrenatalUsuarioBean.ChangePreeclfami}"
                                   reRender="panelInputPreFami">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentePrenatalUsuarioBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuPreeclampsiaFami"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputPreFami">
                  <h:inputTextarea id="inputPreFami"  required="true"
                                   value="#{antecedentePrenatalUsuarioBean.antecedente.hapcdespreeclf}"
                                   style="width:200px"
                                   rendered="#{antecedentePrenatalUsuarioBean.renderPreEclfam}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputPreFami" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Preeclampsia"
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuPreeclampsia" immediate="true"
                                      styleClass="labelRadio" required="true"
                                      onkeydown="return blockEnter(event);"
                                      value="#{antecedentePrenatalUsuarioBean.antecedente.hapcpreeclpers}"
                                      valueChangeListener="#{antecedentePrenatalUsuarioBean.setHapcpreeclpers}">
                      <a4j:support id="supportPreeclampsiaPers" event="onclick"
                                   immediate="true"
                                   action="#{antecedentePrenatalUsuarioBean.ChangePreeclpers}"
                                   reRender="panelInputPrePers">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentePrenatalUsuarioBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuPreeclampsia"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputPrePers">
                  <h:inputTextarea id="inputPrePers"  required="true"
                                   value="#{antecedentePrenatalUsuarioBean.antecedente.hapcdespreeclp}"
                                   style="width:200px"
                                   rendered="#{antecedentePrenatalUsuarioBean.renderPreEclper}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputPrePers" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuEclampsiaFami" immediate="true"
                                    onkeydown="return blockEnter(event);"
                                      styleClass="labelRadio" required="true"
                                      value="#{antecedentePrenatalUsuarioBean.antecedente.hapceclampfami}"
                                      valueChangeListener="#{antecedentePrenatalUsuarioBean.setHapceclampfami}">
                      <a4j:support id="supportEclampsiaFami" event="onclick"
                                   immediate="true"
                                   action="#{antecedentePrenatalUsuarioBean.ChangeEclampsiafami}"
                                   reRender="panelInputEclaFami">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentePrenatalUsuarioBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuEclampsiaFami"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputEclaFami">
                  <h:inputTextarea id="inputEclaFami"  required="true"
                                   value="#{antecedentePrenatalUsuarioBean.antecedente.hapcdeseclampf}"
                                   style="width:200px"
                                   rendered="#{antecedentePrenatalUsuarioBean.renderEclfam}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputEclaFami" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Eclampsia"
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuEclampsia" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      required="true" styleClass="labelRadio"
                                      value="#{antecedentePrenatalUsuarioBean.antecedente.hapceclamppers}"
                                      valueChangeListener="#{antecedentePrenatalUsuarioBean.setHapceclamppers}">
                      <a4j:support id="supportEclampsiaPers" event="onclick"
                                   immediate="true"
                                   action="#{antecedentePrenatalUsuarioBean.ChangeEclampsiapers}"
                                   reRender="panelInputEclaPers">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentePrenatalUsuarioBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuEclampsia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputEclaPers">
                  <h:inputTextarea id="inputEclaPers"  required="true"
                                   value="#{antecedentePrenatalUsuarioBean.antecedente.hapcdeseclampp}"
                                   style="width:200px"
                                   rendered="#{antecedentePrenatalUsuarioBean.renderEclper}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputEclaPers" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuGemelaresFami" immediate="true"
                                     onkeydown="return blockEnter(event);"
                                      styleClass="labelRadio" required="true"
                                      value="#{antecedentePrenatalUsuarioBean.antecedente.hapcgemelafami}"
                                      valueChangeListener="#{antecedentePrenatalUsuarioBean.setHapcgemelafami}">
                      <a4j:support id="supportGemelaresFami" event="onclick"
                                   immediate="true"
                                   action="#{antecedentePrenatalUsuarioBean.ChangeGemelaresfami}"
                                   reRender="panelInputGemFami">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentePrenatalUsuarioBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuGemelaresFami"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputGemFami">
                  <h:inputTextarea id="inputGemFami"  required="true"
                                   value="#{antecedentePrenatalUsuarioBean.antecedente.hapcdesgemelaf}"
                                   style="width:200px"
                                   rendered="#{antecedentePrenatalUsuarioBean.renderGemfam}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputGemFami" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Gemelares"
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
               <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuGemelaresPerso" immediate="true"
                                     onkeydown="return blockEnter(event);"
                                      styleClass="labelRadio" required="true"
                                      value="#{antecedentePrenatalUsuarioBean.antecedente.hapcgemelapers}"
                                      valueChangeListener="#{antecedentePrenatalUsuarioBean.setHapcgemelapers}">
                      <a4j:support id="supportGemelarespers" event="onclick"
                                   immediate="true"
                                   action="#{antecedentePrenatalUsuarioBean.ChangeGemelarespers}"
                                   reRender="panelInputGemPers">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentePrenatalUsuarioBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuGemelaresPerso"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
               <h:panelGroup id="panelInputGemPers">
                  <h:inputTextarea id="inputGemPers"  required="true"
                                   value="#{antecedentePrenatalUsuarioBean.antecedente.hapcdesgemelap}"
                                   style="width:200px"
                                   rendered="#{antecedentePrenatalUsuarioBean.renderGemper}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputGemPers" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuCardiopatiaFami" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      styleClass="labelRadio" required="true"
                                      value="#{antecedentePrenatalUsuarioBean.antecedente.hapccardiofami}"
                                      valueChangeListener="#{antecedentePrenatalUsuarioBean.setHapccardiofami}">
                      <a4j:support id="supportCardiopatiaFami" event="onclick"
                                   immediate="true"
                                   action="#{antecedentePrenatalUsuarioBean.ChangeCardiopatiafami}"
                                   reRender="panelInputCardioFami">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentePrenatalUsuarioBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuCardiopatiaFami"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputCardioFami">
                  <h:inputTextarea id="inputCardioFami"  required="true"
                                   value="#{antecedentePrenatalUsuarioBean.antecedente.hapcdescardiof}"
                                   style="width:200px"
                                   rendered="#{antecedentePrenatalUsuarioBean.renderCardiopatiafam}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputCardioFami" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Cardiopatia "
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
              <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuCardiopatiaPers" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      styleClass="labelRadio" required="true"
                                      value="#{antecedentePrenatalUsuarioBean.antecedente.hapccardiopers}"
                                      valueChangeListener="#{antecedentePrenatalUsuarioBean.setHapccardiopers}">
                      <a4j:support id="supportCardiopatiaPers" event="onclick"
                                   immediate="true"
                                   action="#{antecedentePrenatalUsuarioBean.ChangeCardiopatiapers}"
                                   reRender="panelInputCardioPerso">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentePrenatalUsuarioBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuCardiopatiaPers"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                  <h:panelGroup id="panelInputCardioPerso">
                  <h:inputTextarea id="inputCardioPerso"  required="true"
                                   value="#{antecedentePrenatalUsuarioBean.antecedente.hapcdescardiop}"
                                   style="width:200px"
                                   rendered="#{antecedentePrenatalUsuarioBean.renderCardiopatiaper}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputCardioPerso" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuTBCFami" immediate="true"
                                      required="true" styleClass="labelRadio"
                                      onkeydown="return blockEnter(event);"
                                      value="#{antecedentePrenatalUsuarioBean.antecedente.hapctbcfamilia}"
                                      valueChangeListener="#{antecedentePrenatalUsuarioBean.setHapctbcfamilia}">
                      <a4j:support id="supportTBCFami" event="onclick"
                                   immediate="true"
                                   action="#{antecedentePrenatalUsuarioBean.ChangeTBCfami}"
                                   reRender="panelInputTBCFami">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentePrenatalUsuarioBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuTBCFami" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputTBCFami">
                  <h:inputTextarea id="inputTBCFami"  required="true"
                                  value="#{antecedentePrenatalUsuarioBean.antecedente.hapcdestbcfami}"
                                   style="width:200px"
                                   rendered="#{antecedentePrenatalUsuarioBean.renderTBCfam}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputTBCFami" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Tuberculosis" styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuTuberculosis" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      styleClass="labelRadio" required="true"
                                      value="#{antecedentePrenatalUsuarioBean.antecedente.hapctuberperso}"
                                      valueChangeListener="#{antecedentePrenatalUsuarioBean.setHapctuberperso}">
                      <a4j:support id="supportTuberculosisPerso" event="onclick"
                                   immediate="true"
                                   action="#{antecedentePrenatalUsuarioBean.ChangeTBCperso}"
                                   reRender="panelInputTBCper">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentePrenatalUsuarioBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuTuberculosis"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputTBCper">
                  <h:inputTextarea id="inputTBCPer"  required="true"
                                   value="#{antecedentePrenatalUsuarioBean.antecedente.hapcdestuberpe}"
                                   style="width:200px"
                                   rendered="#{antecedentePrenatalUsuarioBean.renderTBCper}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputTBCPer" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup/>
                <h:outputText/>
                <h:panelGroup>
                  <h:outputText value="Cirugia Pelvico-Uterina"
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuCirugia" immediate="true"
                                      required="true" styleClass="labelRadio"
                                      onkeydown="return blockEnter(event);"
                                      value="#{antecedentePrenatalUsuarioBean.antecedente.hapccirpeutepe}"
                                      valueChangeListener="#{antecedentePrenatalUsuarioBean.setHapccirpeutepe}">
                      <a4j:support id="supportCirugiaPerso" event="onclick"
                                   immediate="true"
                                   action="#{antecedentePrenatalUsuarioBean.ChangeCirugiaperso}"
                                   reRender="panelInputPelPers">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentePrenatalUsuarioBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuCirugia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputPelPers">
                  <h:inputTextarea id="inputPelPers"  required="true"
                                   value="#{antecedentePrenatalUsuarioBean.antecedente.hapcdescirugpe}"
                                   style="width:200px"
                                   rendered="#{antecedentePrenatalUsuarioBean.renderpelvicoper}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputPelPers" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup/>
                <h:outputText/>
                <h:panelGroup>
                  <h:outputText value="Alergicos"
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuAlergicos" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      required="true" styleClass="labelRadio"
                                      value="#{antecedentePrenatalUsuarioBean.antecedente.hapcalergipers}"
                                      valueChangeListener="#{antecedentePrenatalUsuarioBean.setHapcalergipers}">
                      <a4j:support id="supportAlergicosPerso" event="onclick"
                                   immediate="true"
                                   action="#{antecedentePrenatalUsuarioBean.ChangeAlergicospers}"
                                   reRender="panelInputAlerPers">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentePrenatalUsuarioBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuEclampsia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputAlerPers">
                  <h:inputTextarea id="inputAlerPers"  required="true"
                                   value="#{antecedentePrenatalUsuarioBean.antecedente.hapcdesalergip}"
                                   style="width:200px"
                                   rendered="#{antecedentePrenatalUsuarioBean.renderAlergicoper}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputAlerPers" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup/>
                <h:outputText/>
                <h:panelGroup>
                  <h:outputText value="Tabaquismo"
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuTabaquismo" immediate="true"
                                      styleClass="labelRadio" required="true"
                                      onkeydown="return blockEnter(event);"
                                      value="#{antecedentePrenatalUsuarioBean.antecedente.hapctabaqupers}"
                                      valueChangeListener="#{antecedentePrenatalUsuarioBean.setHapctabaqupers}">
                      <a4j:support id="supportTabaquismoPers" event="onclick"
                                   immediate="true"
                                   action="#{antecedentePrenatalUsuarioBean.ChangeTabaquismoperso}"
                                   reRender="panelInputTabaPers">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentePrenatalUsuarioBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuTabaquismo" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputTabaPers">
                  <h:inputTextarea id="inputTabaPers"  required="true"
                                   value="#{antecedentePrenatalUsuarioBean.antecedente.hapcdestabaqup}"
                                   style="width:200px"
                                   rendered="#{antecedentePrenatalUsuarioBean.renderTabaquismoper}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputTabaPers" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup/>
                <h:outputText/>
                <h:panelGroup>
                  <h:outputText value="Antitetanica previa"
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuAntitetanica" immediate="true"
                                      styleClass="labelRadio" required="true"
                                      onkeydown="return blockEnter(event);"
                                      value="#{antecedentePrenatalUsuarioBean.antecedente.hapcantitepers}"
                                      valueChangeListener="#{antecedentePrenatalUsuarioBean.setHapcantitepers}">
                      <a4j:support id="supportAntitetanicaPers" event="onclick"
                                   immediate="true"
                                   action="#{antecedentePrenatalUsuarioBean.ChangeAntitetanicapers}"
                                   reRender="panelInputAntiPers">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentePrenatalUsuarioBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuAntitetanica"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputAntiPers">
                  <h:inputTextarea id="inputAntiFami"  required="true"
                                   value="#{antecedentePrenatalUsuarioBean.antecedente.hapcdesantitep}"
                                   style="width:200px"
                                   onkeydown="return blockEnter(event);"
                                   rendered="#{antecedentePrenatalUsuarioBean.renderAntitetanicaper}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputAntiFami" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuOtroFami" immediate="true"
                                      required="true" styleClass="labelRadio"
                                      onkeydown="return blockEnter(event);"
                                      value="#{antecedentePrenatalUsuarioBean.antecedente.hapcotrofamili}"
                                      valueChangeListener="#{antecedentePrenatalUsuarioBean.setOtroFamiliar}">
                      <f:selectItems value="#{antecedentePrenatalUsuarioBean.lstOpciones}"/>
                      <a4j:support id="supportOtroFami" event="onclick"
                                   immediate="true"
                                   action="#{antecedentePrenatalUsuarioBean.ChangeOtroFamiliar}"
                                   reRender="panelGroupTextCuales,panelGroupInputCuales">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuTBCFami" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelGroupInputCuales">
                  <h:inputTextarea id="inputOtroFami"  required="true"
                                   value="#{antecedentePrenatalUsuarioBean.antecedente.hapccualotrfam}"
                                   style="width:200px"
                                   rendered="#{antecedentePrenatalUsuarioBean.renderFamiliar}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputOtroFami" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Otros"
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuOtrosPersonal" immediate="true"
                                      styleClass="labelRadio" required="true"
                                      onkeydown="return blockEnter(event);"
                                      value="#{antecedentePrenatalUsuarioBean.antecedente.hapcotrosperso}"
                                      valueChangeListener="#{antecedentePrenatalUsuarioBean.setOtroPersonal}">
                      <f:selectItems value="#{antecedentePrenatalUsuarioBean.lstOpciones}"/>
                      <a4j:support id="supportOtrosPersonal" event="onclick"
                                   immediate="true"
                                   action="#{antecedentePrenatalUsuarioBean.ChangeOtroPersonal}"
                                   reRender="panelGroupTextCuales,panelInputOtrosPersonal">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuOtrosPersonal"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputOtrosPersonal">
                  <h:inputTextarea id="inputOtroPers"  required="true"
                                   value="#{antecedentePrenatalUsuarioBean.antecedente.hapccualotrper}"
                                   style="width:200px"
                                   rendered="#{antecedentePrenatalUsuarioBean.renderPersonal}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputOtroPers" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText/>
              </h:panelGrid>
            </s:fieldset>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelBotonModificar"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Guardar" styleClass="boton_fieldset"
                                 action="#{antecedentePrenatalUsuarioBean.aceptar}">
                  <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
          <h:panelGrid>
            <h:panelGroup id="msgPrenatal">
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