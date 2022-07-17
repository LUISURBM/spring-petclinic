<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAntecedentesGeneralesTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneExamenFisicoAnestesia" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabExamenFisicoAnestesia" label="Examen Fisico Preanestesia">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="tableContentTabsExamenFisicoAnestesia" styleClass="tabContainer">
         
            <s:fieldset legend="Evaluación Via Aerea" id="fieldEvaluacionViaAerea" styleClass="fieldset">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosEvaluacionViaAerea" rowClasses="labelText">
                <h:outputText value="Apertura Oral (cm)" styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:panelGroup>
                  <h:inputText id="itApertoral" required="true"  onkeydown="return blockEnter(event);"
                               value="#{examenFisicoAnestesiaUsuarioBean.examen.heanapertoral}" maxlength="2"
                               style="width:30px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itApertoral" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                  <h:outputText value="Mallampati" styleClass="labelTextOblig"/>
                <h:outputText value="Distancia Mento-Tiroidea(cm)" styleClass="labelTextOblig"/>
                <h:outputText value="Movilidad anterior de la mandíbula" styleClass="labelTextOblig"/>
                <h:outputText/>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuMallampati" required="true"
                                   onkeydown="return blockEnter(event);"
                                   value="#{examenFisicoAnestesiaUsuarioBean.examen.heacmallampati}">
                    <f:selectItems value="#{examenFisicoAnestesiaUsuarioBean.lstMallampati}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMallampati" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="itDistancia" required="true" style="width:30px" 
                                maxlength="2" onkeydown="return blockEnter(event);"
                               value="#{examenFisicoAnestesiaUsuarioBean.examen.heandistametri}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itDistancia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuMovilidad" required="true"
                                   onkeydown="return blockEnter(event);"
                                   value="#{examenFisicoAnestesiaUsuarioBean.examen.heacmovilanter}">
                    <f:selectItems value="#{examenFisicoAnestesiaUsuarioBean.lstMovilidadAnterior}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMovilidad" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText value="Movilidad atlanto-occipital" styleClass="labelTextOblig"/>
                <h:outputText value="Evaluación global vía aérea" styleClass="labelTextOblig"/>
                <h:outputText/>
                <h:outputText/>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuMovilidadAtlanto" required="true"
                                  onkeydown="return blockEnter(event);"
                                   value="#{examenFisicoAnestesiaUsuarioBean.examen.heacmovilatlan}">
                    <f:selectItems value="#{examenFisicoAnestesiaUsuarioBean.lstMovilidadAtlanto}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMovilidadAtlanto" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuEvaluacion" required="true"
                                    onkeydown="return blockEnter(event);"
                                    value="#{examenFisicoAnestesiaUsuarioBean.examen.heacevalugloba}">
                    <f:selectItems value="#{examenFisicoAnestesiaUsuarioBean.lstEvaluacion}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuEvaluacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText/>
                
                <h:outputText value="Prótesis dental" styleClass="labelTextOblig"/>
                    <h:panelGroup id="panelTextTipoProtesisInferior">
                  <h:outputText value="Prótesis Inferior" rendered="#{examenFisicoAnestesiaUsuarioBean.mostrarProtesis}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextGradoProtesisInferior">
                  <h:outputText value="Grado Prótesis" rendered="#{examenFisicoAnestesiaUsuarioBean.tieneprotesisinferior}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextMovilidadProtesisInferior">
                  <h:outputText value="Movilidad Prótesis" rendered="#{examenFisicoAnestesiaUsuarioBean.tieneprotesisinferior}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuTieneProtesis" required="true" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      value="#{examenFisicoAnestesiaUsuarioBean.examen.heactieneprote}"
                                      valueChangeListener="#{examenFisicoAnestesiaUsuarioBean.setHeactieneprote}">
                      <f:selectItems value="#{examenFisicoAnestesiaUsuarioBean.lstOpciones}"/>
                      <a4j:support id="supportmnuProtesis" event="onclick" immediate="true"
                                   action="#{examenFisicoAnestesiaUsuarioBean.changeProtesis}"
                                   reRender="panelMnuMovilidadProtesisInferior,panelMnuMovilidadSuperior,panelMnuTipoProtesisInferior,panelMnuTipoProtesis,panelMnuGradoProtesis,panelTextTipoProtesisInferior,panelTextGradoProtesisInferior,panelTextMovilidadProtesisInferior,panelTextTipoProtesisSuperior,panelTextGradoProtesisSuperior,panelTextMovilidadProtesisSuperior,panelMnuGradoSuperior,panelMnuTipoProtesisSuperior,panelTextMovilidadProtesisSuperior,panelMnuGradoProtesisInferior">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuTieneProtesis" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <a4j:region renderRegionOnly="false">
                <h:panelGroup id="panelMnuTipoProtesisInferior">
                  <h:selectBooleanCheckbox id="checkProtesisInferior" immediate="true"
                                           onkeydown="return blockEnter(event);"
                                            binding="#{examenFisicoAnestesiaUsuarioBean.checkProtesisInferior}"
                                           rendered="#{examenFisicoAnestesiaUsuarioBean.mostrarProtesis}"
                                           value="#{examenFisicoAnestesiaUsuarioBean.tieneprotesisinferior}"
                                           valueChangeListener="#{examenFisicoAnestesiaUsuarioBean.setTieneprotesisinferior}">
                    <a4j:support id="supportTipoProtesisInferior" event="onclick" immediate="true"
                                action="#{examenFisicoAnestesiaUsuarioBean.changeProtesisInferior}"
                                 reRender="panelTextGradoProtesisInferior,panelTextMovilidadProtesisInferior,panelMnuGradoProtesisInferior,panelMnuMovilidadProtesisInferior">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectBooleanCheckbox>
                </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelMnuGradoProtesisInferior">
                  <h:selectOneRadio id="mnuGradoProtesisInferior" required="true"
                                    onkeydown="return blockEnter(event);"
                                    binding="#{examenFisicoAnestesiaUsuarioBean.mnuGradoProtesisInferior}"
                                    rendered="#{examenFisicoAnestesiaUsuarioBean.tieneprotesisinferior}"
                                    value="#{examenFisicoAnestesiaUsuarioBean.examen.heacgradoproin}">
                    <f:selectItems value="#{examenFisicoAnestesiaUsuarioBean.lstGradoProtesis}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuGradoProtesisInferior" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelMnuMovilidadProtesisInferior">
                  <h:selectOneRadio id="mnuMovilidadInferior"
                                    onkeydown="return blockEnter(event);"
                                    binding="#{examenFisicoAnestesiaUsuarioBean.mnuMovilidadInferior}"
                                    rendered="#{examenFisicoAnestesiaUsuarioBean.tieneprotesisinferior}"
                                    value="#{examenFisicoAnestesiaUsuarioBean.examen.heacmovilproin}">
                    <f:selectItems value="#{examenFisicoAnestesiaUsuarioBean.lstMovilidadProtesis}"/>
                  </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMovilidadInferior" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=""/>
                <h:panelGroup id="panelTextTipoProtesisSuperior">
                  <h:outputText value="Prótesis Superior" rendered="#{examenFisicoAnestesiaUsuarioBean.mostrarProtesis}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextGradoProtesisSuperior">
                  <h:outputText value="Grado Prótesis" rendered="#{examenFisicoAnestesiaUsuarioBean.tieneprotesissuperior}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextMovilidadProtesisSuperior">
                  <h:outputText value="Movilidad Prótesis" rendered="#{examenFisicoAnestesiaUsuarioBean.tieneprotesissuperior}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup/>
                <a4j:region renderRegionOnly="false">
                <h:panelGroup id="panelMnuTipoProtesisSuperior">
                  <h:selectBooleanCheckbox id="checkProtesisSuperior" immediate="true"
                                           onkeydown="return blockEnter(event);"
                                           rendered="#{examenFisicoAnestesiaUsuarioBean.mostrarProtesis}"
                                           binding="#{examenFisicoAnestesiaUsuarioBean.checkProtesisSuperior}"
                                           value="#{examenFisicoAnestesiaUsuarioBean.tieneprotesissuperior}"
                                           valueChangeListener="#{examenFisicoAnestesiaUsuarioBean.setTieneprotesissuperior}">
                    <a4j:support id="supportTipoProtesisSuperior" event="onclick" immediate="true"
                                action="#{examenFisicoAnestesiaUsuarioBean.changeProtesisSuperior}"
                                 reRender="panelTextGradoProtesisSuperior,panelTextMovilidadProtesisSuperior,panelMnuGradoSuperior,panelMnuMovilidadSuperior">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectBooleanCheckbox>
                </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelMnuGradoSuperior">
                  <h:selectOneRadio id="mnuGradoSuperior" required="true"
                                    onkeydown="return blockEnter(event);"
                                    binding="#{examenFisicoAnestesiaUsuarioBean.mnuGradoSuperior}"
                                    rendered="#{examenFisicoAnestesiaUsuarioBean.tieneprotesissuperior}"
                                    value="#{examenFisicoAnestesiaUsuarioBean.examen.heacgradoprosu}">
                    <f:selectItems value="#{examenFisicoAnestesiaUsuarioBean.lstGradoProtesis}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuGradoSuperior" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelMnuMovilidadSuperior">
                  <h:selectOneRadio id="mnuMovilidadSuperior"
                                    onkeydown="return blockEnter(event);"
                                    binding="#{examenFisicoAnestesiaUsuarioBean.mnuMovilidadSuperior}"
                                    rendered="#{examenFisicoAnestesiaUsuarioBean.tieneprotesissuperior}"
                                    value="#{examenFisicoAnestesiaUsuarioBean.examen.heacmovilprosu}">
                    <f:selectItems value="#{examenFisicoAnestesiaUsuarioBean.lstMovilidadProtesis}"/>
                  </h:selectOneRadio>
                </h:panelGroup>
   
              </h:panelGrid>
            </s:fieldset>
         
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Guardar" styleClass="boton_fieldset"
                                 action="#{examenFisicoAnestesiaUsuarioBean.aceptar}">
                  <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
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