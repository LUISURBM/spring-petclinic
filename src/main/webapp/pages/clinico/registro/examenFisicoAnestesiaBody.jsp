<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<a4j:form id="formExamenFisicoAnestesia">
  <a4j:region id="regionExamenFisicoAnestesia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionExamenFisicoAnestesia">
      <f:facet name="start">
        <t:div id="chargingExamenFisicoAnestesia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
   
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="panelGridExamenFisicoAnestesiaTab" styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneExamenFisicoAnestesia" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabExamenFisicoAnestesia" label="Examen Fisico Preanestesia">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="tableContentTabsExamenFisicoAnestesia" styleClass="tabContainer">
            <s:fieldset legend="Datos Examen Fisico" id="fieldExamenFisicoAnestesia" styleClass="fieldset">
              <a4j:region renderRegionOnly="false">
                <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosExamen"
                             rowClasses="labelText,labelTextInfo">
                  <h:outputText value="Presion Arterial" styleClass="labelTextOblig"/>
                  <h:outputText value="Frecuencia Cardiaca" styleClass="labelTextOblig"/>
                  <h:outputText value="Frecuencia Respiratoria" styleClass="labelTextOblig"/>
                  <h:panelGroup>
                    <h:inputText id="itPresion" title="mm Hg" required="true" onkeydown="return blockEnter(event);"
                                 value="#{examenFisicoAnestesiaBean.examen.heacpresart1}" style="width:30px"
                                 maxlength="3"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itPresion" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:outputText value="/"/>
                    <h:inputText id="itPresion2" title="mm Hg" required="true" onkeydown="return blockEnter(event);"
                                 value="#{examenFisicoAnestesiaBean.examen.heacpresart2}" style="width:30px"
                                 maxlength="3"/>
                    <h:outputText value="  mm Hg"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itPresion2" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:panelGroup>
                    <h:inputText id="itCardiaca" title="latidos por minuto" onkeydown="return blockEnter(event);"
                                 required="true" value="#{examenFisicoAnestesiaBean.examen.heanfreccard}"
                                 style="width:30px" maxlength="3"/>
                    <h:outputText value="  l.p.m"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itCardiaca" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:panelGroup>
                    <h:inputText id="itRespiratoria" title="respiraciones por minuto"
                                 onkeydown="return blockEnter(event);" required="true"
                                 value="#{examenFisicoAnestesiaBean.examen.heanfrecresp}" style="width:30px"
                                 maxlength="2"/>
                    <h:outputText value="  r.p.m"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itRespiratoria" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value="Peso" styleClass="labelTextOblig"/>
                  <h:outputText value="Talla" styleClass="labelTextOblig"/>
                  <h:outputText value="IMC" styleClass="labelTextOblig"/>
                  <h:panelGroup>
                    <h:panelGroup>
                      <h:inputText id="itPeso" required="true" onkeydown="return blockEnter(event);"
                                   value="#{examenFisicoAnestesiaBean.peso}" style="width:40px" maxlength="4"
                                   title="Peso en Kilogramos"/>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itPeso" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                    <h:panelGroup>
                      <h:outputText value="  kg"/>
                    </h:panelGroup>
                  </h:panelGroup>
                  <h:panelGroup>
                    <h:inputText id="itTalla" title="Talla en metros" required="true"
                                 onkeydown="return blockEnter(event);" value="#{examenFisicoAnestesiaBean.talla}"
                                 valueChangeListener="#{examenFisicoAnestesiaBean.setTalla}" style="width:40px"
                                 maxlength="4">
                      <a4j:support id="supportIMC" event="onchange" oncomplete="imcJs()"
                                   action="#{examenFisicoAnestesiaBean.calcularIMC}"
                                   reRender="tableContentTabsExamenFisicoAnestesia">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itTalla" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:outputText value="  mts  "/>
                  </h:panelGroup>
                  <h:panelGroup>
                    <h:outputText id="itMasaCorporal" value="#{examenFisicoAnestesiaBean.masacor}" style="width:30px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itMasaCorporal" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:panelGroup>
                    <h:outputText value="Temperatura" />
                  </h:panelGroup>
                 <h:panelGroup>
                    <h:outputText value=""/>
                  </h:panelGroup>
                  <h:panelGroup>
                    <h:outputText value="Perímetro Cefálico" rendered="#{examenFisicoAnestesiaBean.esPediatria}"/>
                  </h:panelGroup>
                  <h:panelGroup>
                    <h:inputText id="itTemperaura" required="true" onkeydown="return blockEnter(event);"
                                 title="Temperatura en grados centígrados"
                                 value="#{examenFisicoAnestesiaBean.examen.heaatemperatu}" style="width:50px"
                                 maxlength="5"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itTemperaura" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:outputText value="  ºC" />
                  </h:panelGroup>
                  <h:panelGroup>
                    <h:outputText value=""/>
                  </h:panelGroup>
                  <h:panelGroup>
                    <h:inputText id="itPerimetro" title="perimetro en centímetros" onkeydown="return blockEnter(event);"
                                 value="#{examenFisicoAnestesiaBean.examen.heanpericefali}"
                                 rendered="#{examenFisicoAnestesiaBean.esPediatria}" style="width:20px" maxlength="2"/>
                    <h:outputText value="   cm" rendered="#{examenFisicoAnestesiaBean.esPediatria}"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itPerimetro" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:panelGroup>
                    <h:outputText value="Saturación de oxihemoglobina"
                                  rendered="#{examenFisicoAnestesiaBean.esPediatria}"/>
                  </h:panelGroup>
                  <h:outputText value=""/>
                  <h:outputText value=""/>
                  <h:panelGroup>
                    <h:inputText id="itSaturacion" onkeydown="return blockEnter(event);"
                                 rendered="#{examenFisicoAnestesiaBean.esPediatria}"
                                 value="#{examenFisicoAnestesiaBean.examen.heansatuoxihe}" style="width:30px"
                                 maxlength="3"/>
                    <h:outputText value="    O2" rendered="#{examenFisicoAnestesiaBean.esPediatria}"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itSaturacion" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGrid>
              </a4j:region>
            </s:fieldset>
            <s:fieldset legend="Evaluación Via Aerea" id="fieldEvaluacionViaAerea" styleClass="fieldset">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosEvaluacionViaAerea" rowClasses="labelText">
                <h:outputText value="Apertura Oral (cm)" styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:panelGroup>
                  <h:inputText id="itApertoral" required="true"
                               value="#{examenFisicoAnestesiaBean.examen.heanapertoral}" maxlength="2"
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
                                   value="#{examenFisicoAnestesiaBean.examen.heacmallampati}">
                    <f:selectItems value="#{examenFisicoAnestesiaBean.lstMallampati}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMallampati" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="itDistancia" required="true" style="width:30px" maxlength="2"
                               value="#{examenFisicoAnestesiaBean.examen.heandistametri}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itDistancia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuMovilidad" required="true"
                                   value="#{examenFisicoAnestesiaBean.examen.heacmovilanter}">
                    <f:selectItems value="#{examenFisicoAnestesiaBean.lstMovilidadAnterior}"/>
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
                                   value="#{examenFisicoAnestesiaBean.examen.heacmovilatlan}">
                    <f:selectItems value="#{examenFisicoAnestesiaBean.lstMovilidadAtlanto}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMovilidadAtlanto" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuEvaluacion" required="true"
                                    value="#{examenFisicoAnestesiaBean.examen.heacevalugloba}">
                    <f:selectItems value="#{examenFisicoAnestesiaBean.lstEvaluacion}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuEvaluacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText/>
                
                <h:outputText value="Prótesis dental" styleClass="labelTextOblig"/>
                    <h:panelGroup id="panelTextTipoProtesisInferior">
                  <h:outputText value="Prótesis Inferior" rendered="#{examenFisicoAnestesiaBean.mostrarProtesis}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextGradoProtesisInferior">
                  <h:outputText value="Grado Prótesis" rendered="#{examenFisicoAnestesiaBean.tieneprotesisinferior}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextMovilidadProtesisInferior">
                  <h:outputText value="Movilidad Prótesis" rendered="#{examenFisicoAnestesiaBean.tieneprotesisinferior}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuTieneProtesis" required="true" immediate="true"
                                      value="#{examenFisicoAnestesiaBean.examen.heactieneprote}"
                                      valueChangeListener="#{examenFisicoAnestesiaBean.setHeactieneprote}">
                      <f:selectItems value="#{examenFisicoAnestesiaBean.lstOpciones}"/>
                      <a4j:support id="supportmnuProtesis" event="onclick" immediate="true"
                                   action="#{examenFisicoAnestesiaBean.changeProtesis}"
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
                                            binding="#{examenFisicoAnestesiaBean.checkProtesisInferior}"
                                           rendered="#{examenFisicoAnestesiaBean.mostrarProtesis}"
                                           value="#{examenFisicoAnestesiaBean.tieneprotesisinferior}"
                                           valueChangeListener="#{examenFisicoAnestesiaBean.setTieneprotesisinferior}">
                    <a4j:support id="supportTipoProtesisInferior" event="onclick" immediate="true"
                                action="#{examenFisicoAnestesiaBean.changeProtesisInferior}"
                                 reRender="panelTextGradoProtesisInferior,panelTextMovilidadProtesisInferior,panelMnuGradoProtesisInferior,panelMnuMovilidadProtesisInferior">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectBooleanCheckbox>
                </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelMnuGradoProtesisInferior">
                  <h:selectOneRadio id="mnuGradoProtesisInferior" required="true"
                                    binding="#{examenFisicoAnestesiaBean.mnuGradoProtesisInferior}"
                                    rendered="#{examenFisicoAnestesiaBean.tieneprotesisinferior}"
                                    value="#{examenFisicoAnestesiaBean.examen.heacgradoproin}">
                    <f:selectItems value="#{examenFisicoAnestesiaBean.lstGradoProtesis}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuGradoProtesisInferior" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelMnuMovilidadProtesisInferior">
                  <h:selectOneRadio id="mnuMovilidadInferior"
                                    binding="#{examenFisicoAnestesiaBean.mnuMovilidadInferior}"
                                    rendered="#{examenFisicoAnestesiaBean.tieneprotesisinferior}"
                                    value="#{examenFisicoAnestesiaBean.examen.heacmovilproin}">
                    <f:selectItems value="#{examenFisicoAnestesiaBean.lstMovilidadProtesis}"/>
                  </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMovilidadInferior" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=""/>
                <h:panelGroup id="panelTextTipoProtesisSuperior">
                  <h:outputText value="Prótesis Superior" rendered="#{examenFisicoAnestesiaBean.mostrarProtesis}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextGradoProtesisSuperior">
                  <h:outputText value="Grado Prótesis" rendered="#{examenFisicoAnestesiaBean.tieneprotesissuperior}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextMovilidadProtesisSuperior">
                  <h:outputText value="Movilidad Prótesis" rendered="#{examenFisicoAnestesiaBean.tieneprotesissuperior}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup/>
                <a4j:region renderRegionOnly="false">
                <h:panelGroup id="panelMnuTipoProtesisSuperior">
                  <h:selectBooleanCheckbox id="checkProtesisSuperior" immediate="true"
                                           rendered="#{examenFisicoAnestesiaBean.mostrarProtesis}"
                                           binding="#{examenFisicoAnestesiaBean.checkProtesisSuperior}"
                                           value="#{examenFisicoAnestesiaBean.tieneprotesissuperior}"
                                           valueChangeListener="#{examenFisicoAnestesiaBean.setTieneprotesissuperior}">
                    <a4j:support id="supportTipoProtesisSuperior" event="onclick" immediate="true"
                                action="#{examenFisicoAnestesiaBean.changeProtesisSuperior}"
                                 reRender="panelTextGradoProtesisSuperior,panelTextMovilidadProtesisSuperior,panelMnuGradoSuperior,panelMnuMovilidadSuperior">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectBooleanCheckbox>
                </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelMnuGradoSuperior">
                  <h:selectOneRadio id="mnuGradoSuperior" required="true"
                                    binding="#{examenFisicoAnestesiaBean.mnuGradoSuperior}"
                                    rendered="#{examenFisicoAnestesiaBean.tieneprotesissuperior}"
                                    value="#{examenFisicoAnestesiaBean.examen.heacgradoprosu}">
                    <f:selectItems value="#{examenFisicoAnestesiaBean.lstGradoProtesis}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuGradoProtesis" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelMnuMovilidadSuperior">
                  <h:selectOneRadio id="mnuMovilidadSuperior"
                                    binding="#{examenFisicoAnestesiaBean.mnuMovilidadSuperior}"
                                    rendered="#{examenFisicoAnestesiaBean.tieneprotesissuperior}"
                                    value="#{examenFisicoAnestesiaBean.examen.heacmovilprosu}">
                    <f:selectItems value="#{examenFisicoAnestesiaBean.lstMovilidadProtesis}"/>
                  </h:selectOneRadio>
                </h:panelGroup>
   
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Hallazgos" id="fieldHallazgos" styleClass="fieldset">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosExamenHallazgos" rowClasses="labelText">
                <h:outputText value="Hallazgos del examen físico" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:inputTextarea id="textHallazgos" required="true"
                                   value="#{examenFisicoAnestesiaBean.examen.heathallazgo}" style="width:600px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="textHallazgos" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Guardar" styleClass="boton_fieldset"
                                 action="#{examenFisicoAnestesiaBean.aceptar}">
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
    </h:panelGrid>
  </a4j:region>
</a4j:form>