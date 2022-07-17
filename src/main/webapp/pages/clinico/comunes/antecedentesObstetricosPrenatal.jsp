<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
             id="panelGridAntecedentesGinecoObstetricosTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneAntecedentesObstetricos" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
      <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMensajes1" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInf1" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
    <t:panelTab id="panelTabAntecedentesObstetricos" label="Antecedentes Gineco-Obstetricos">
      <a4j:region renderRegionOnly="false">
        <s:fieldset legend="Embarazos" id="fieldAntecedentesObstetricos" styleClass="fieldset">
          <a4j:region id="regionAntecedentesObstetricos" renderRegionOnly="false">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelDatosAntecedentesObstetricos" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Gestaciones" styleClass="labelTextOblig"/>
              <h:outputText value="Partos" styleClass="labelTextOblig"/>
              <h:outputText value="Abortos" styleClass="labelTextOblig"/>
              <h:outputText value="Ectopicos" styleClass="labelTextOblig"/>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:inputText id="itNumGesta" onkeydown="return blockEnter(event);" immediate="true"
                               binding="#{antecedentesObstetricosPrenatalBean.itNumGesta}" required="true"
                               title="Numero de Gestaciones" maxlength="2" style="width:30px" 
                               value="#{antecedentesObstetricosPrenatalBean.antecedente.haonnumgesta}"
                               valueChangeListener="#{antecedentesObstetricosPrenatalBean.setNumeroGestaciones}">
                    <a4j:support id="supportNumGestacion" immediate="true" event="onchange"
                                 action="#{antecedentesObstetricosPrenatalBean.changeNumeroGestaciones}"
                                 reRender="fieldAntecedentesGinecoobstetricos,panelTabAntecedentesObstetricos">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNumGesta" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup id="panelInputPartos">
                  <h:panelGroup>
                    <h:inputText id="itNumPartos" onkeydown="return blockEnter(event);" required="true"
                                 title="Numero de Partos" immediate="true"
                                 disabled="#{antecedentesObstetricosPrenatalBean.esCeroGestaciones}"
                                 value="#{antecedentesObstetricosPrenatalBean.antecedente.haonnumparto}" maxlength="2"
                                 style="width:30px"  valueChangeListener="#{antecedentesObstetricosPrenatalBean.setNumeroPartos}">
                    <a4j:support id="supportNumPartos" immediate="true" event="onchange"
                                 action="#{antecedentesObstetricosPrenatalBean.changeNumeroPartos}"
                                 reRender="fieldAntecedentesObstetricos,fieldAntecedentesGinecoobstetricos">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                   </h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itNumPartos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
              </a4j:region>
              <h:panelGroup id="panelInputAbortos">
                <h:panelGroup>
                  <h:inputText id="itNumAbortos" onkeydown="return blockEnter(event);" immediate="true" required="true"
                               title="Numero de Abortos" maxlength="2" style="width:30px"
                               disabled="#{antecedentesObstetricosPrenatalBean.esCeroGestaciones}"
                               value="#{antecedentesObstetricosPrenatalBean.antecedente.haonnumaborto}"></h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNumAbortos" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
              <h:panelGroup id="panelInputEctopicos">
                <h:panelGroup>
                  <h:inputText id="itNumcEctopicos" onkeydown="return blockEnter(event);" immediate="true"
                               required="false" title="Numero de Ectopicos" maxlength="2" style="width:30px"
                               disabled="#{antecedentesObstetricosPrenatalBean.esCeroGestaciones}"
                               value="#{antecedentesObstetricosPrenatalBean.antecedente.haonectopico}"></h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNumcEctopicos" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
              <h:outputText value="Molas" styleClass="labelTextOblig"/>
              <h:outputText value="Mortinatos" styleClass="labelTextOblig"/>
              <h:outputText value="Numero Nacidos Vivos" styleClass="labelTextOblig"/>
              <h:outputText/>
             
              <h:panelGroup id="panelInputMolas">
                <h:panelGroup>
                  <h:inputText id="itNumMolas" onkeydown="return blockEnter(event);" immediate="true" required="false"
                               title="Numero de Molas" maxlength="2" style="width:30px"
                               disabled="#{antecedentesObstetricosPrenatalBean.esCeroGestaciones}"
                               value="#{antecedentesObstetricosPrenatalBean.antecedente.haonmolas}"></h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNumMolas" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
               <h:panelGroup id="panelInputMalformaciones">
                <h:panelGroup>
                  <h:inputText id="itNumMalformaciones" onkeydown="return blockEnter(event);" immediate="true"
                               required="false" title="Numero de Mortinatos" maxlength="2" style="width:30px"
                               disabled="#{antecedentesObstetricosPrenatalBean.esCeroGestaciones  || antecedentesObstetricosPrenatalBean.renderedNacidoVivo}"
                               value="#{antecedentesObstetricosPrenatalBean.antecedente.haonmortina}">
                               </h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNumMalformaciones" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
               <h:panelGroup id="panelInputHijosNacidosVivos">
                <h:panelGroup>
                  <h:inputText id="itNumHijoNacidoVivo" onkeydown="return blockEnter(event);" immediate="true"
                               required="false" title="Numero de Hijos Nacidos Vivos" maxlength="2" style="width:30px"
                               disabled="#{antecedentesObstetricosPrenatalBean.esCeroGestaciones  || !antecedentesObstetricosPrenatalBean.renderedParto}"
                               value="#{antecedentesObstetricosPrenatalBean.antecedente.haonnacivivo}"
                              valueChangeListener="#{antecedentesObstetricosPrenatalBean.setNumeroHijosVivos}">
                    <a4j:support id="supportNumHijosNacidos" immediate="true" event="onchange"
                                 action="#{antecedentesObstetricosPrenatalBean.changeNumeroHijosVivos}"
                                 reRender="fieldAntecedentesGinecoobstetricos">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support> </h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNumHijoNacidoVivo" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
             
              <h:outputText/>
            </h:panelGrid>
          </a4j:region>
        </s:fieldset>
        <s:fieldset legend="Gineco-Obstetricos" id="fieldAntecedentesGinecoobstetricos" styleClass="fieldset">
          <a4j:region renderRegionOnly="false">
            <h:panelGrid columns="7">
              <h:outputText value="[ " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value=" Todos SI" immediate="true"
                               action="#{antecedentesObstetricosPrenatalBean.changeTodosSi}"
                               reRender="panelDatosAntecedentesGinecobstetricos"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true"
                               action="#{antecedentesObstetricosPrenatalBean.changeTodosNo}"
                               reRender="panelDatosAntecedentesGinecobstetricos"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true"
                               action="#{antecedentesObstetricosPrenatalBean.changeNinguno}"
                               reRender=" panelDatosAntecedentesGinecobstetricos"/>
              <h:outputText value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
            </h:panelGrid>
          </a4j:region>
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelDatosAntecedentesGinecobstetricos" rowClasses="labelCuestionario3,labelCuestionario4">
            <h:panelGroup id="panelLeucorreas">
              <h:outputText value="Leucorreas" styleClass="labelTextOblig"/>
              <h:panelGroup>
                <h:selectOneRadio id="mnuLeucorreas" immediate="true" required="true"
                                  disabled="#{!antecedentesObstetricosPrenatalBean.renderedGest1}"
                                  value="#{antecedentesObstetricosPrenatalBean.antecedente.haocleucorreas}">
                  <f:selectItems value="#{antecedentesObstetricosPrenatalBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuLeucorreas" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup id="panelPreclamsia">
              <h:panelGrid columns="2">
                <h:panelGroup>
                  <h:panelGroup>
                    <h:outputText value="Preeclampsia" styleClass="labelTextOblig"/>
                  </h:panelGroup>
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuPreclampsia" immediate="true" required="true"
                                      disabled="#{!antecedentesObstetricosPrenatalBean.renderedGest1}"
                                      value="#{antecedentesObstetricosPrenatalBean.antecedente.haocpreclamps}"
                                      valueChangeListener="#{antecedentesObstetricosPrenatalBean.setHaocpreclamps}">
                      <f:selectItems value="#{antecedentesObstetricosPrenatalBean.lstOpciones}"/>
                      <a4j:support id="supportPreclampsia" event="onclick" immediate="true"
                                   action="#{antecedentesObstetricosPrenatalBean.changePreclampsia}"
                                   reRender="panelTextCualPrec,panelCualPreclampsia">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuPreclampsia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGrid columns="1">
                    <h:panelGroup id="panelTextCualPrec">
                      <h:outputText value="Observaciones" styleClass="labelTextOblig"
                                    rendered="#{antecedentesObstetricosPrenatalBean.renderPreclampsia}"/>
                    </h:panelGroup>
                    <h:panelGroup id="panelCualPreclampsia">
                      <h:inputText id="itCualPreclampsia" onkeydown="return blockEnter(event);"
                                   rendered="#{antecedentesObstetricosPrenatalBean.renderPreclampsia}" required="false"
                                   title="Cuales Malformaciones" immediate="true"
                                   value="#{antecedentesObstetricosPrenatalBean.antecedente.haocdesprecla}"
                                   maxlength="1000" style="width:200px"></h:inputText>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itCualPreclampsia" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup id="panelEclamsia">
              <h:panelGrid columns="2">
                <h:panelGroup>
                  <h:panelGroup>
                    <h:outputText value="Eclampsia" styleClass="labelTextOblig"/>
                  </h:panelGroup>
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuEclampsia" immediate="true" required="true"
                                      disabled="#{!antecedentesObstetricosPrenatalBean.renderedGest1}"
                                      value="#{antecedentesObstetricosPrenatalBean.antecedente.haoceclampsia}"
                                      valueChangeListener="#{antecedentesObstetricosPrenatalBean.setHaoceclampsia}">
                      <f:selectItems value="#{antecedentesObstetricosPrenatalBean.lstOpciones}"/>
                      <a4j:support id="supportEclampsia" event="onclick" immediate="true"
                                   action="#{antecedentesObstetricosPrenatalBean.changeEclampsia}"
                                   reRender="panelCualEclampsia,panelInputCualEclampsia">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuEclampsia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                <h:panelGroup id="panelInputCualEclampsia">
                  <h:panelGrid columns="1">
                    <h:panelGroup id="panelCualEclampsia">
                      <h:outputText value="Observaciones" styleClass="labelTextOblig"
                                    rendered="#{antecedentesObstetricosPrenatalBean.renderEclampsia}"/>
                    </h:panelGroup>
                    <h:panelGroup>
                      <h:inputText id="itCualEclampsia" onkeydown="return blockEnter(event);"
                                   rendered="#{antecedentesObstetricosPrenatalBean.renderEclampsia}" required="false"
                                   title="Cuales Malformaciones" immediate="true"
                                   value="#{antecedentesObstetricosPrenatalBean.antecedente.haocdeseclamp}"
                                   maxlength="1000" style="width:200px"></h:inputText>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itCualEclampsia" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGroup>
                <h:outputText value="Amenazo de Parto" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneRadio id="mnuAmenazaParto" immediate="true" required="true"  disabled="#{!antecedentesObstetricosPrenatalBean.renderedParto}"
                                  value="#{antecedentesObstetricosPrenatalBean.antecedente.haocamenaparto}">
                  <f:selectItems value="#{antecedentesObstetricosPrenatalBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAmenazaParto" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup id="panelPolihidr">
              <h:panelGroup>
                <h:outputText value="Polihidramnios" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneRadio id="mnuPolihidramnios" immediate="true" required="true"
                                  disabled="#{!antecedentesObstetricosPrenatalBean.renderedGest1}"
                                  value="#{antecedentesObstetricosPrenatalBean.antecedente.haocpolhidramn}">
                  <f:selectItems value="#{antecedentesObstetricosPrenatalBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuPolihidramnios" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup id="panelOligam">
              <h:panelGroup>
                <h:outputText value="Oligoamnios" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneRadio id="mnuOligoamnios" immediate="true" required="true"
                                  disabled="#{!antecedentesObstetricosPrenatalBean.renderedGest1}"
                                  value="#{antecedentesObstetricosPrenatalBean.antecedente.haocoligohidra}">
                  <f:selectItems value="#{antecedentesObstetricosPrenatalBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuOligoamnios" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup id="panelRetarCreci">
              <h:panelGroup>
                <h:outputText value="Retardo Crecimiento Intrauterino" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneRadio id="mnuRetardoCrecimiento" immediate="true" required="true"
                                  disabled="#{!antecedentesObstetricosPrenatalBean.renderedGest1}"
                                  value="#{antecedentesObstetricosPrenatalBean.antecedente.haocretcrcint}">
                  <f:selectItems value="#{antecedentesObstetricosPrenatalBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuRetardoCrecimiento" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:panelGroup>
                  <h:outputText value="Fecha del Ultimo Parto" styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup id="panelInputParto">
                  <t:inputCalendar id="calendarUltimoParto" title="Formato: dd/mm/yyyy"
                                   onkeydown="return blockEnter(event);" immediate="true"
                                   disabled="#{antecedentesObstetricosPrenatalBean.esCeroGestaciones || !antecedentesObstetricosPrenatalBean.renderedParto}"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{antecedentesObstetricosPrenatalBean.antecedente.haodfup}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11" 
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top" required="false">
                    <f:validator validatorId="dateMenorIgualValidator"/>
                  </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarUltimoParto" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGroup>
                <h:outputText value="Partos Unicos o Multiples" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneRadio id="mnuPartosMultiples" immediate="true" required="true" disabled="#{!antecedentesObstetricosPrenatalBean.renderedParto}"
                                  value="#{antecedentesObstetricosPrenatalBean.antecedente.haocparunimul}">
                  <f:selectItems value="#{antecedentesObstetricosPrenatalBean.lstTipoParto}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuPartosMultiples" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGroup>
                <h:outputText value="Termino Parto" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneRadio id="mnuParto" immediate="true" required="true"  disabled="#{!antecedentesObstetricosPrenatalBean.renderedParto}"
                                  value="#{antecedentesObstetricosPrenatalBean.antecedente.haoctipparto}">
                  <f:selectItems value="#{antecedentesObstetricosPrenatalBean.lstTerminoParto}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuParto" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGroup>
                <h:outputText value="Via Parto" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneRadio id="mnuViaParto" immediate="true" required="true"  disabled="#{!antecedentesObstetricosPrenatalBean.renderedParto}"
                                  value="#{antecedentesObstetricosPrenatalBean.antecedente.haocviaparto}">
                  <f:selectItems value="#{antecedentesObstetricosPrenatalBean.lstViaParto}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuViaParto" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGroup>
                <h:outputText value="Retencion de la Placenta" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneRadio id="mnuRetencionPlacenta" immediate="true" required="true"  disabled="#{!antecedentesObstetricosPrenatalBean.renderedParto}"
                                  value="#{antecedentesObstetricosPrenatalBean.antecedente.haocretplace}">
                  <f:selectItems value="#{antecedentesObstetricosPrenatalBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuRetencionPlacenta" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGroup>
                <h:outputText value="Infecciones en el Posparto" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneRadio id="mnuInfeccionesPosparto" immediate="true" required="true"  disabled="#{!antecedentesObstetricosPrenatalBean.renderedParto}"
                                  value="#{antecedentesObstetricosPrenatalBean.antecedente.haocinfepost}">
                  <f:selectItems value="#{antecedentesObstetricosPrenatalBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuInfeccionesPosparto" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGroup>
                <h:outputText value="Placenta Previa" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneRadio id="mnuPacentaPrevia" immediate="true" required="true"  disabled="#{!antecedentesObstetricosPrenatalBean.renderedParto}"
                                  value="#{antecedentesObstetricosPrenatalBean.antecedente.haocplacprevi}">
                  <f:selectItems value="#{antecedentesObstetricosPrenatalBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuPacentaPrevia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGroup>
                <h:outputText value="Abrupcio" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneRadio id="mnuAbrupio" immediate="true" required="true"  disabled="#{!antecedentesObstetricosPrenatalBean.renderedParto}"
                                  value="#{antecedentesObstetricosPrenatalBean.antecedente.haocabrupio}">
                  <f:selectItems value="#{antecedentesObstetricosPrenatalBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAbrupio" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGroup>
                <h:outputText value="Ruptura Prematura de Membranas" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneRadio id="mnuRupturaPrematura" immediate="true" required="true"  disabled="#{!antecedentesObstetricosPrenatalBean.renderedParto}"
                                  value="#{antecedentesObstetricosPrenatalBean.antecedente.haocrupprememb}">
                  <f:selectItems value="#{antecedentesObstetricosPrenatalBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAbrupio" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGroup>
                <h:outputText value="Hemorragia Obstetrica" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneRadio id="mnuHemorragiaObstetrica" immediate="true" required="true"  disabled="#{!antecedentesObstetricosPrenatalBean.renderedParto}"
                                  value="#{antecedentesObstetricosPrenatalBean.antecedente.haochemoobst}">
                  <f:selectItems value="#{antecedentesObstetricosPrenatalBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuViaParto" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup id="panelAmenAborto">
              <h:panelGroup>
                <h:outputText value="Amenaza de Aborto" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneRadio id="mnuAmenazaAborto" immediate="true" required="true"
                                  disabled="#{!antecedentesObstetricosPrenatalBean.renderedGest1}"
                                  value="#{antecedentesObstetricosPrenatalBean.antecedente.haocamenaabort}">
                  <f:selectItems value="#{antecedentesObstetricosPrenatalBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAmenazaAborto" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGroup>
                <h:outputText value="Peso al Nacer" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:panelGroup id="panelInputPesoAlNacer">
                <h:inputText id="itPesoalNacer" onkeydown="return blockEnter(event);" immediate="true"
                             title="Numero de Abortos" maxlength="4" style="width:30px" required="true"
                             disabled="#{antecedentesObstetricosPrenatalBean.esCeroGestaciones || !antecedentesObstetricosPrenatalBean.renderedParto}"
                             value="#{antecedentesObstetricosPrenatalBean.antecedente.haonpesonacer}"></h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itPesoalNacer" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="2">
                <h:panelGroup>
                  <h:panelGroup>
                    <h:outputText value="Muertes Perinatales" styleClass="labelTextOblig"/>
                  </h:panelGroup>
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuMuertesPerinatales" immediate="true" required="true"   disabled="#{!antecedentesObstetricosPrenatalBean.renderedParto}"
                                      value="#{antecedentesObstetricosPrenatalBean.antecedente.haocmueperinat}" 
                                      valueChangeListener="#{antecedentesObstetricosPrenatalBean.setHaocmueperinat}">
                      <f:selectItems value="#{antecedentesObstetricosPrenatalBean.lstOpciones}"/>
                      <a4j:support id="supportMuertesPerinatales" event="onclick" immediate="true"
                                   action="#{antecedentesObstetricosPrenatalBean.changeMuertes}"
                                   reRender="panelTextCausas,panelCausas">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuMuertesPerinatales" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGroup id="panelTextCausas">
                    <h:outputText value="Causas" styleClass="labelTextOblig"
                                  rendered="#{antecedentesObstetricosPrenatalBean.renderCausas}"/>
                  </h:panelGroup>
                  <h:panelGroup id="panelCausas">
                    <h:panelGroup>
                      <h:inputText id="itCualCausas" onkeydown="return blockEnter(event);"
                                   rendered="#{antecedentesObstetricosPrenatalBean.renderCausas}" required="false"
                                   title="Cuales Causas" immediate="true"
                                   value="#{antecedentesObstetricosPrenatalBean.antecedente.haocmuepercual}"
                                   maxlength="1000" style="width:200px"></h:inputText>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itCualCausas" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </h:panelGroup>
                </h:panelGroup>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="2">
                <h:panelGroup>
                  <h:panelGroup>
                    <h:outputText value="Hijos Malformaciones Congenitas" styleClass="labelTextOblig"/>
                  </h:panelGroup>
                  <h:panelGroup id="panelInputMortinatos">
                    <h:panelGroup>
                      <h:selectOneRadio id="mnuHijoMalformaciones" immediate="true" required="true" disabled="#{!antecedentesObstetricosPrenatalBean.renderedNacidoVivo}"
                                        value="#{antecedentesObstetricosPrenatalBean.antecedente.haocmalformaci}"
                                        valueChangeListener="#{antecedentesObstetricosPrenatalBean.setHaocmalformaci}">
                        <f:selectItems value="#{antecedentesObstetricosPrenatalBean.lstOpciones}"/>
                        <a4j:support id="supportHijoMalformaciones" event="onclick" immediate="true"
                                     action="#{antecedentesObstetricosPrenatalBean.changeMalformaciones}"
                                     reRender="panelCualesMalformaciones,panelTextMalformaciones">
                          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                      </h:selectOneRadio>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuHijoMalformaciones" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </h:panelGroup>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGroup>
                    <h:panelGrid columns="1">
                      <h:panelGroup id="panelTextMalformaciones">
                        <h:outputText value="Cuales Malformaciones" styleClass="labelTextOblig"
                                      rendered="#{antecedentesObstetricosPrenatalBean.renderMalformaciones}"/>
                      </h:panelGroup>
                      <h:panelGroup id="panelCualesMalformaciones">
                        <h:panelGroup>
                          <h:inputText id="itCualesMalformaciones" onkeydown="return blockEnter(event);"
                                       rendered="#{antecedentesObstetricosPrenatalBean.renderMalformaciones}"
                                       required="false" title="Cuales Malformaciones" immediate="true"
                                       value="#{antecedentesObstetricosPrenatalBean.antecedente.haocmalforcual}"
                                       maxlength="1000" style="width:200px"></h:inputText>
                          <a4j:outputPanel ajaxRendered="true">
                            <t:message for="itCualesMalformaciones" styleClass="errorMessage"/>
                          </a4j:outputPanel>
                        </h:panelGroup>
                      </h:panelGroup>
                    </h:panelGrid>
                  </h:panelGroup>
                </h:panelGroup>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup id="panelPeriodoIn">
              <h:panelGroup>
                <h:outputText value="Periodo Intergenésico Corto" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:panelGroup id="panelInputPeriodoInter">
                <h:panelGroup>
                  <a4j:region renderRegionOnly="false">
                    <h:selectOneRadio id="mnuPeriodoInter" immediate="true" required="true"
                                      disabled="#{!antecedentesObstetricosPrenatalBean.renderedGest2 || !antecedentesObstetricosPrenatalBean.renderedNacidoVivo}"
                                      value="#{antecedentesObstetricosPrenatalBean.antecedente.haocperintcor}"
                                      valueChangeListener="#{antecedentesObstetricosPrenatalBean.setHaocperintcor}">
                      <f:selectItems value="#{antecedentesObstetricosPrenatalBean.lstOpciones}"/>
                      <a4j:support id="supportPeriodoInter" event="onclick" immediate="true"
                                   action="#{antecedentesObstetricosPrenatalBean.changePeriodoInterCorto}"
                                   reRender="panelCualPeriodoInter,panelTextPeriodoInter">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuPeriodoInter" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </a4j:region>
                </h:panelGroup>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGroup id="panelTextPeriodoInter">
                <h:outputText value="Cual" styleClass="labelTextOblig"
                              rendered="#{antecedentesObstetricosPrenatalBean.renderPeriodoInterCorto}"/>
              </h:panelGroup>
              <h:panelGroup id="panelCualPeriodoInter">
                <h:panelGroup>
                  <h:inputText id="itCualPeriodoInter" onkeydown="return blockEnter(event);"
                               rendered="#{antecedentesObstetricosPrenatalBean.renderPeriodoInterCorto}"
                               required="false" immediate="true"
                               value="#{antecedentesObstetricosPrenatalBean.antecedente.haocpeincocual}"
                               maxlength="4000" style="width:200px"></h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itCualPeriodoInter" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
      </a4j:region>
    </t:panelTab>
    <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificarObstetricos"
                 columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Guardar" styleClass="boton_fieldset"
                         action="#{antecedentesObstetricosPrenatalBean.aceptar}">
          <a4j:support event="onclick" status="statusButton"/>
        </h:commandButton>
      </h:panelGroup>
    </h:panelGrid>
    <h:panelGrid id="panelMensajesGinecoObstetricos">
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMensajes" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInf" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>