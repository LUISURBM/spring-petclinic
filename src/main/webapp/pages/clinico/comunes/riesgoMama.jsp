<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridRiesgoMamaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  
     <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneRiesgoMama"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabRiesgoMama" label="Factores de Riesgo">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="tableContentTabsRiesgoMama"
                       styleClass="tabContainer">
            <t:htmlTag value="br"/>
            <s:fieldset legend="Factores de Riesgo" id="fieldRiesgoMama"
                        styleClass="fieldset">
              <h:panelGrid columns="3" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelRiesgoMama"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Menarquia antes de los 12 años  "
                              styleClass="labelTextOblig"/>
                <h:outputText/>
                <h:outputText/>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuMenarquia" immediate="true"
                                    onkeydown="return blockEnter(event);"
                                    required="true"
                                    value="#{riesgoMamaUsuarioBean.riesgo.hrmemenarantes}">
                    <f:selectItems value="#{riesgoMamaUsuarioBean.lstOpciones}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMenarquia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText/>
                <h:outputText value="Menopausia despues de los 50 años   "
                              styleClass="labelTextOblig"/>
                <h:outputText/>
                <h:outputText/>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuMenopausia" immediate="true"
                                    onkeydown="return blockEnter(event);"
                                    required="true"
                                    disabled="#{riesgoMamaUsuarioBean.edadMenor}"
                                    value="#{riesgoMamaUsuarioBean.riesgo.hrmemenopadesp}">
                    <f:selectItems value="#{riesgoMamaUsuarioBean.lstOpciones}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMenopausia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText/>
                <h:outputText value="Primer Embarazo despues de los 30 años"
                              styleClass="labelTextOblig"/>
                <h:outputText/>
                <h:outputText/>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuEmbarazo" immediate="true"
                                    onkeydown="return blockEnter(event);"
                                    required="true"
                                    value="#{riesgoMamaUsuarioBean.riesgo.hrmeembaradesp}">
                    <f:selectItems value="#{riesgoMamaUsuarioBean.lstOpciones}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuEmbarazo" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText/>
                <h:outputText value="Terapia de reemplazo hormonal"
                              styleClass="labelTextOblig"/>
                <h:panelGroup id="panelTextTerapia">
                  <h:outputText value="Cuántos Años?"
                                styleClass="labelTextOblig"
                                rendered="#{riesgoMamaUsuarioBean.mostrarTerapia}"/>
                </h:panelGroup>
                <h:outputText/>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuTerapia" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      required="true"
                                      value="#{riesgoMamaUsuarioBean.terapiaSelect}"
                                      valueChangeListener="#{riesgoMamaUsuarioBean.setTerapiaSelect}">
                      <f:selectItems value="#{riesgoMamaUsuarioBean.lstOpciones}"/>
                      <a4j:support id="supportTerapia" event="onclick"
                                   immediate="true"
                                   action="#{riesgoMamaUsuarioBean.changeTerapia}"
                                   reRender="panelTextTerapia,panelInputTerapia">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuTerapia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputTerapia">
                  <h:inputText id="itTerapia"
                               onkeydown="return blockEnter(event);"
                               value="#{riesgoMamaUsuarioBean.riesgo.hrmnanosterap}"
                               maxlength="2" style="width:30px" required="true"
                               rendered="#{riesgoMamaUsuarioBean.mostrarTerapia}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itTerapia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText value="Antecedente personal de cancer"
                              styleClass="labelTextOblig"/>
                <h:panelGroup id="panelTextCancer">
                  <h:outputText value="Tipo Cancer" styleClass="labelTextOblig"
                                rendered="#{riesgoMamaUsuarioBean.mostrarCancerPersonal}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextOtroCancer">
                  <h:outputText/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuCancer" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      required="true"
                                      value="#{riesgoMamaUsuarioBean.antececancerSelect}"
                                      valueChangeListener="#{riesgoMamaUsuarioBean.setAntececancerSelect}">
                      <f:selectItems value="#{riesgoMamaUsuarioBean.lstOpciones}"/>
                      <a4j:support id="supportCancer" event="onclick"
                                   immediate="true"
                                   action="#{riesgoMamaUsuarioBean.changeCancerPersonal}"
                                   reRender="panelTextCancer,panelMenuCancer,panelTextOtroCancer,panelInputOtroCancer">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuCancer" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:selectOneRadio>
                  </h:panelGroup>
                </a4j:region>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup id="panelMenuCancer">
                    <h:inputTextarea value="#{riesgoMamaUsuarioBean.riesgo.hrmccancerpers}"
                                     onkeydown="return blockEnter(event);"
                                     style="width:300px" required="true"
                                     rendered="#{riesgoMamaUsuarioBean.mostrarCancerPersonal}"/>
                  </h:panelGroup>
                </a4j:region>
                <h:outputText/>
                <h:outputText value="Familiar con CA de mama "
                              styleClass="labelTextOblig"/>
                <h:panelGroup id="panelTextMadre">
                  <h:outputText value="Cual(es)  " styleClass="labelTextOblig"
                                rendered="#{riesgoMamaUsuarioBean.mostrarFamiliares}"/>
                </h:panelGroup>
                <h:outputText/>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuFamiliar" immediate="true"
                                     onkeydown="return blockEnter(event);"
                                      required="true"
                                      value="#{riesgoMamaUsuarioBean.familiarcancerSelect}"
                                      valueChangeListener="#{riesgoMamaUsuarioBean.setFamiliarcancerSelect}">
                      <f:selectItems value="#{riesgoMamaUsuarioBean.lstOpciones}"/>
                      <a4j:support id="supportFamiliarCancer" event="onclick"
                                   immediate="true"
                                   action="#{riesgoMamaUsuarioBean.changeFamiliaCancer}"
                                   reRender="panelTextMadre,panelTextEdadMadre,panelTextHija,panelTextEdadHija,panelTextAbuelaMa,panelTextEdadAbuelaMa,panelTextAbuelaPa,panelTextEdadAbuelaPa,panelCheckMadre,panelInputEdadMadre,panelCheckHija,panelInputEdadHija,panelCheckAbuelaMa,panelInputEdadAbuelaMa,panelCheckAbuelaPa,panelInputEdadAbuelaPa">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuFamiliar" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelTextEdadMadre">
                  <h:inputTextarea value="#{riesgoMamaUsuarioBean.riesgo.hrmccancerfami}"
                                   onkeydown="return blockEnter(event);"
                                   style="width:300px" required="true"
                                   rendered="#{riesgoMamaUsuarioBean.mostrarFamiliares}"/>
                </h:panelGroup>
                <h:panelGroup/>
                <h:panelGroup>
                  <h:outputText value="Antecedentes biopsa de mama "
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextBiopsa">
                  <h:outputText value="Naturaleza Biopsa"
                                styleClass="labelTextOblig"
                                rendered="#{riesgoMamaUsuarioBean.mostrarBiopsa}"/>
                </h:panelGroup>
                <h:outputText value=""/>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuAntecedentesBiopsa"
                                      onkeydown="return blockEnter(event);"
                                      immediate="true" required="true"
                                      value="#{riesgoMamaUsuarioBean.biopsamamaSelect}"
                                      valueChangeListener="#{riesgoMamaUsuarioBean.setBiopsamamaSelect}">
                      <f:selectItems value="#{riesgoMamaUsuarioBean.lstOpciones}"/>
                      <a4j:support id="supportAntecedentesBiopsa"
                                   event="onclick" immediate="true"
                                   action="#{riesgoMamaUsuarioBean.changeBiopsa}"
                                   reRender="panelTextBiopsa,panelMenuBiopsa">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuAntecedentesBiopsa"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelMenuBiopsa">
                  <h:selectOneMenu id="mnuNaturalezaBiopsa" immediate="true"
                                   onkeydown="return blockEnter(event);"
                                   required="true"
                                   rendered="#{riesgoMamaUsuarioBean.mostrarBiopsa}"
                                   value="#{riesgoMamaUsuarioBean.tipoBiopsa}">
                    <f:selectItems value="#{riesgoMamaUsuarioBean.lstAnteBiopsa}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuNaturalezaBiopsa"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText/>
                <h:panelGroup>
                  <h:outputText value="Lactancia Acumulada"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextTiempoLactancia">
                  <h:outputText value="Tiempo Lactancia"
                                rendered="#{riesgoMamaUsuarioBean.mostrarLactancia}"/>
                </h:panelGroup>
                <h:outputText/>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuLactancia" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      required="true"
                                      value="#{riesgoMamaUsuarioBean.riesgo.hrmelactancia}"
                                      valueChangeListener="#{riesgoMamaUsuarioBean.setTieneLactancia}">
                      <f:selectItems value="#{riesgoMamaUsuarioBean.lstOpciones}"/>
                      <a4j:support id="supportLactancia" event="onclick"
                                   immediate="true"
                                   action="#{riesgoMamaUsuarioBean.changeLactancia}"
                                   reRender="panelTextTiempoLactancia,panelMnuLactancia">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuLactancia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelMnuLactancia">
                  <h:selectOneRadio id="mnuTiempoLactancia" immediate="true"
                                    onkeydown="return blockEnter(event);"
                                    rendered="#{riesgoMamaUsuarioBean.mostrarLactancia}"
                                    value="#{riesgoMamaUsuarioBean.lactanciaSelect}">
                    <f:selectItems value="#{riesgoMamaUsuarioBean.lstLactancia}"/>
                  </h:selectOneRadio>
                </h:panelGroup>
                <h:outputText/>
              </h:panelGrid>
            </s:fieldset>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelBotonModificar"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Guardar" styleClass="boton_fieldset"
                                 action="#{riesgoMamaUsuarioBean.aceptar}">
                  <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMensajes" ajaxRendered="true">
                  <t:htmlTag value="br"/>
                  <t:messages id="msgInf" showSummary="true" errorClass="error"
                              globalOnly="true" layout="table"
                              infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
 <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>