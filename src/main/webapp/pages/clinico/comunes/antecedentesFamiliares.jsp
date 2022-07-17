<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
        id="panelGridAntecedentesFamiliarTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneAntecedentesfamiliar"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabAntecedentesfamiliar"
                    label="Antecedentes Familiares">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="tableContentTabsAntecedentesfamiliar"
                       styleClass="tabContainer">
            <s:fieldset legend="Antecedentes" id="fieldAntecedentesFamiliares"
                        styleClass="fieldset">                
        <a4j:region renderRegionOnly="false">
          <h:panelGrid columns="7">
            <h:outputText value="[ " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value=" Todos SI" immediate="true"
                             action="#{antecedentesFamiliaresBean.changeTodosSi}" reRender="panelDatosAntecedentesFamiliares"/>
            <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true"
                             action="#{antecedentesFamiliaresBean.changeTodosNo}" reRender="panelDatosAntecedentesFamiliares"/>
            <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true"
                             action="#{antecedentesFamiliaresBean.changeNinguno}" reRender=" panelDatosAntecedentesFamiliares"/>
            <h:outputText value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
          </h:panelGrid>
        </a4j:region>
        <h:outputText value=" "/>
        <t:htmlTag value="br"/>
              <h:panelGrid columns="3" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelDatosAntecedentesFamiliares"
                           rowClasses="labelCuestionario3,labelCuestionario4">
               
                <h:outputText value="Antecedentes Familiares"/>
                <h:outputText/>
               <h:outputText/>
             
                <h:panelGroup>
                  <h:outputText value="Hipertension Arterial"
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuHTA" required="true"
                                      onkeydown="return blockEnter(event);"
                                      immediate="true" styleClass="labelRadio"
                                      value="#{antecedentesFamiliaresBean.antecedente.hafchiperarter}"
                                      valueChangeListener="#{antecedentesFamiliaresBean.setHafchiperarter}">
                      <a4j:support id="supportmnuHTA" event="onclick"
                                   immediate="true"
                                   action="#{antecedentesFamiliaresBean.changeHtaFami}"
                                   reRender="panelInputHTAFamiliar">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentesFamiliaresBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuHTA" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputHTAFamiliar">
                  <h:inputTextarea id="inputHtaFamiliar"  required="true"
                                   value="#{antecedentesFamiliaresBean.antecedente.hafcdeshtacrof}"
                                   style="width:200px"
                                   rendered="#{antecedentesFamiliaresBean.renderHTAfam}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputHtaFamiliar" styleClass="errorMessage"/>
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
                                      value="#{antecedentesFamiliaresBean.antecedente.hafcpreeclfami}"
                                      valueChangeListener="#{antecedentesFamiliaresBean.setHafcpreeclfami}">
                      <a4j:support id="supportPreeclampsiaFamiliar" event="onclick"
                                   immediate="true"
                                   action="#{antecedentesFamiliaresBean.changePreeclfami}"
                                   reRender="panelInputPreclaFamiliar">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentesFamiliaresBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuPreeclampsia"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputPreclaFamiliar">
                  <h:inputTextarea id="inputPreFamiliar"  required="true"
                                   value="#{antecedentesFamiliaresBean.antecedente.hafcdespreeclf}"
                                   style="width:200px"
                                   rendered="#{antecedentesFamiliaresBean.renderPreEclfam}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputPreFamiliar" styleClass="errorMessage"/>
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
                                      value="#{antecedentesFamiliaresBean.antecedente.hafceclampfami}"
                                      valueChangeListener="#{antecedentesFamiliaresBean.setHafceclampfami}">
                      <a4j:support id="supportEclampsiaFamiliar" event="onclick"
                                   immediate="true"
                                   action="#{antecedentesFamiliaresBean.changeEclampsiafami}"
                                   reRender="panelInputEclaFamiliar">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentesFamiliaresBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuEclampsia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputEclaFamiliar">
                  <h:inputTextarea id="inputEclaFamiliar"  required="true"
                                   value="#{antecedentesFamiliaresBean.antecedente.hafcdeseclampf}"
                                   style="width:200px"
                                   rendered="#{antecedentesFamiliaresBean.renderEclfam}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputEclaFamiliar" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>

              
              
            
                  <h:panelGroup>
                  <h:outputText value="Cardiopatia "
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
              <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuCardiopatiaFamiliar" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      styleClass="labelRadio" required="true"
                                      value="#{antecedentesFamiliaresBean.antecedente.hafccardiofami}"
                                      valueChangeListener="#{antecedentesFamiliaresBean.setHafccardiofami}">
                      <a4j:support id="supportCardiopatiaFamiliar" event="onclick"
                                   immediate="true"
                                   action="#{antecedentesFamiliaresBean.changeCardiopatiafami}"
                                   reRender="panelInputCardioFamiliar">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentesFamiliaresBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuCardiopatiaFamiliar"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                  <h:panelGroup id="panelInputCardioFamiliar">
                  <h:inputTextarea id="inputCardioFamiliar"  required="true"
                                   value="#{antecedentesFamiliaresBean.antecedente.hafcdescardiof}"
                                   style="width:200px"
                                   rendered="#{antecedentesFamiliaresBean.renderCardiopatiafam}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputCardioFamiliar" styleClass="errorMessage"/>
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
                                      value="#{antecedentesFamiliaresBean.antecedente.hafcdiabetfami}"
                                      valueChangeListener="#{antecedentesFamiliaresBean.setHafcdiabetfami}">
                      <a4j:support id="supportDiabetesFamiliar" event="onclick"
                                   immediate="true"
                                   action="#{antecedentesFamiliaresBean.changeDiabetesFamiliar}"
                                   reRender="panelInputDiabeteFamiliar">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentesFamiliaresBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuDiabetes" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputDiabeteFamiliar">
                  <h:inputTextarea id="inputDiaFamiliar"  required="true"
                                   value="#{antecedentesFamiliaresBean.antecedente.hafcdesdiabetf}"
                                   style="width:200px"
                                   rendered="#{antecedentesFamiliaresBean.renderDiafam}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputDiaFamiliar" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                         
              
                <h:panelGroup>
                  <h:outputText value="Metabolicas"
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
               <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuMetabolicaFamiliar" immediate="true"
                                     onkeydown="return blockEnter(event);"
                                      styleClass="labelRadio" required="true"
                                      value="#{antecedentesFamiliaresBean.antecedente.hafcmetabfami}"
                                      valueChangeListener="#{antecedentesFamiliaresBean.setHafcmetabfami}">
                      <a4j:support id="supportMetabolicoFami" event="onclick"
                                   immediate="true"
                                   action="#{antecedentesFamiliaresBean.changeMetabolicas}"
                                   reRender="panelInputMetabolicaFamiliar">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentesFamiliaresBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuMetabolicaFamiliar"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
               <h:panelGroup id="panelInputMetabolicaFamiliar">
                  <h:inputTextarea id="inputMetaFami"  required="true"
                                   value="#{antecedentesFamiliaresBean.antecedente.hafcdesmetabf}"
                                   style="width:200px"
                                   rendered="#{antecedentesFamiliaresBean.renderMetabolicoFamiliar}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputMetaFami" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
               
             
          
              
                <h:panelGroup>
                  <h:outputText value="Autoinmunes" styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuAutoinmune" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      styleClass="labelRadio" required="true"
                                      value="#{antecedentesFamiliaresBean.antecedente.hafcautoinmu}"
                                      valueChangeListener="#{antecedentesFamiliaresBean.setHafcautoinmu}">
                      <a4j:support id="supportAutoimnuneFamiliar" event="onclick"
                                   immediate="true"
                                   action="#{antecedentesFamiliaresBean.changeAutoimnuneFamiliar}"
                                   reRender="panelInputAutoInmuneFamiliar">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentesFamiliaresBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuAutoinmune"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputAutoInmuneFamiliar">
                  <h:inputTextarea id="inputAutoinmuneFamiliar"  required="true"
                                   value="#{antecedentesFamiliaresBean.antecedente.hafcdesauinf}"
                                   style="width:200px"
                                   rendered="#{antecedentesFamiliaresBean.renderAutoinmuneFamiliar}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputAutoinmuneFamiliar" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
         
                <h:panelGroup>
                  <h:outputText value="Infecciosas"
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuInfecciosasFamiliar" immediate="true"
                                      required="true" styleClass="labelRadio"
                                      onkeydown="return blockEnter(event);"
                                      value="#{antecedentesFamiliaresBean.antecedente.hafcmetabinfe}"
                                      valueChangeListener="#{antecedentesFamiliaresBean.setHafcmetabinfe}">
                      <a4j:support id="supporInfecciosasFamiliar" event="onclick"
                                   immediate="true"
                                   action="#{antecedentesFamiliaresBean.changeInfecciosaFamiliar}"
                                   reRender="panelInputInfecciosaFamiliar">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentesFamiliaresBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuInfecciosasFamiliar" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputInfecciosaFamiliar">
                  <h:inputTextarea id="inputInfecciosaFamiliar"  required="true"
                                   value="#{antecedentesFamiliaresBean.antecedente.hafcdesinfecf}"
                                   style="width:200px"
                                   rendered="#{antecedentesFamiliaresBean.renderInfecciosaFamiliar}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputInfecciosaFamiliar" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              
                <h:panelGroup>
                  <h:outputText value="Congenitas"
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuCongenitasFamiliar" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      required="true" styleClass="labelRadio"
                                      value="#{antecedentesFamiliaresBean.antecedente.hafccongefami}"
                                      valueChangeListener="#{antecedentesFamiliaresBean.setHafccongefami}">
                      <a4j:support id="supportCongenitoFamiliar" event="onclick"
                                   immediate="true"
                                   action="#{antecedentesFamiliaresBean.changeCongenitoFamiliar}"
                                   reRender="panelInputCongeFamiliar">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentesFamiliaresBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuCongenitasFamiliar" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputCongeFamiliar">
                  <h:inputTextarea id="inputCongenitaFamiliar"  required="true"
                                   value="#{antecedentesFamiliaresBean.antecedente.hafcdescongef}"
                                   style="width:200px"
                                   rendered="#{antecedentesFamiliaresBean.renderCongenitaFamiliar}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputCongenitaFamiliar" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              
                <h:panelGroup>
                  <h:outputText value="Epilepsia"
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuEpilepsiaFamiliar" immediate="true"
                                      styleClass="labelRadio" required="true"
                                      onkeydown="return blockEnter(event);"
                                      value="#{antecedentesFamiliaresBean.antecedente.hafcepilfami}"
                                      valueChangeListener="#{antecedentesFamiliaresBean.setHafcepilfami}">
                      <a4j:support id="supportEpilepsiaFamiliar" event="onclick"
                                   immediate="true"
                                   action="#{antecedentesFamiliaresBean.changeEpilepsiaFamiliar}"
                                   reRender="panelInputEpilepsiaFamiliar">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentesFamiliaresBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuEpilepsiaFamiliar" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputEpilepsiaFamiliar">
                  <h:inputTextarea id="inputEpilepsiaFamiliar"  required="true"
                                   value="#{antecedentesFamiliaresBean.antecedente.hafcdeseplif}"
                                   style="width:200px"
                                   rendered="#{antecedentesFamiliaresBean.renderEpilepsiaFamiliar}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputEpilepsiaFamiliar" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
               
            
            <h:panelGroup>
                  <h:outputText value="Trastornos Mentales"
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuTrastornoMentales" immediate="true"
                                      styleClass="labelRadio" required="true"
                                      onkeydown="return blockEnter(event);"
                                      value="#{antecedentesFamiliaresBean.antecedente.hafctrastmenta}"
                                      valueChangeListener="#{antecedentesFamiliaresBean.setHafctrastmenta}">
                      <a4j:support id="supportTrastornoMentales" event="onclick"
                                   immediate="true"
                                   action="#{antecedentesFamiliaresBean.changeTrastornoMentales}"
                                   reRender="panelInputTrastornoMentales">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentesFamiliaresBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuEpilepsiaFamiliar" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputTrastornoMentales">
                  <h:inputTextarea id="inputTrastornoMentales"  required="true"
                                   value="#{antecedentesFamiliaresBean.antecedente.hafcdestramen}"
                                   style="width:200px"
                                   rendered="#{antecedentesFamiliaresBean.renderTrastornoMental}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputTrastornoMentales" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
            
             <h:panelGroup>
                  <h:outputText value="Gestaciones Múltiples"
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuGestaMultiples" immediate="true"
                                      styleClass="labelRadio" required="true"
                                      onkeydown="return blockEnter(event);"
                                      value="#{antecedentesFamiliaresBean.antecedente.hafcgestamulti}"
                                      valueChangeListener="#{antecedentesFamiliaresBean.setHafcgestamulti}">
                      <f:selectItems value="#{antecedentesFamiliaresBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuGestaMultiples" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:outputText/>
                
                <h:panelGroup>
                  <h:outputText value="Tuberculosis"
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuTuberculosis" immediate="true"
                                      styleClass="labelRadio" required="true"
                                      onkeydown="return blockEnter(event);"
                                      value="#{antecedentesFamiliaresBean.antecedente.hafctuberculosis}"
                                      valueChangeListener="#{antecedentesFamiliaresBean.setHafctuberculosis}">
                      <f:selectItems value="#{antecedentesFamiliaresBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuTuberculosis" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:outputText/>
                
                <h:panelGroup>
                  <h:outputText value="Neoplasias"
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuNeoplasias" immediate="true"
                                      styleClass="labelRadio" required="true"
                                      onkeydown="return blockEnter(event);"
                                      value="#{antecedentesFamiliaresBean.antecedente.hafcneoplasias}"
                                      valueChangeListener="#{antecedentesFamiliaresBean.setHafcneoplasias}">
                      <f:selectItems value="#{antecedentesFamiliaresBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuNeoplasias" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:outputText/>
                
                <h:panelGroup>
                  <h:outputText value="Otras"
                                styleClass="labelTextAntecedentes"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuOtras" immediate="true"
                                      styleClass="labelRadio" required="true"
                                      onkeydown="return blockEnter(event);"
                                      value="#{antecedentesFamiliaresBean.antecedente.hafcotros}"
                                      valueChangeListener="#{antecedentesFamiliaresBean.setHafcotros}">
                      <a4j:support id="supportOtras" event="onclick"
                                   immediate="true"
                                   action="#{antecedentesFamiliaresBean.changeOtros}"
                                   reRender="panelInputOtras">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:selectItems value="#{antecedentesFamiliaresBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuOtras" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputOtras">
                  <h:inputTextarea id="inputOtras"  required="true"
                                   value="#{antecedentesFamiliaresBean.antecedente.hafcdescrotros}"
                                   style="width:200px"
                                   rendered="#{antecedentesFamiliaresBean.renderOtros}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputOtras" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
            
              </h:panelGrid>
            </s:fieldset>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelBotonModificar"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Guardar" styleClass="boton_fieldset"
                                 action="#{antecedentesFamiliaresBean.aceptar}">
                  <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
          <h:panelGrid>
            <h:panelGroup id="msgfamiliar">
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