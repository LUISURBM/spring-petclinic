<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formEncuestaViolencia">
  <a4j:region id="regionEncuestaViolencia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionEncuestaViolencia">
      <f:facet name="start">
        <t:div id="chargingEncuestaViolencia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
   

    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEncuestaViolenciaTab" styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneEncuestaViolencia" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabEncuestaViolencia" label="Encuesta Violencia">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsEncuestaViolencia" styleClass="tabContainer">
            <s:fieldset legend="Encuesta de Violencia" id="fieldEnc" styleClass="fieldset">
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelEncustaViolencia" rowClasses="labelText,labelTextInfo">
                <h:outputText value="¿Ha sufrido violencia? " styleClass="labelTextOblig"/>
                <h:outputText/>
                <h:outputText/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuViolencia" immediate="true" required="true" value="#{encuestaViolenciaBean.sufreViolencia}" valueChangeListener="#{encuestaViolenciaBean.setSufreViolencia}">
                    <f:selectItems value="#{encuestaViolenciaBean.lstOpcionesViolencia}"/>
                    <a4j:support id="supportmnuViolencia" event="onclick" immediate="true" oncomplete="cursorViolencia()" action="#{encuestaViolenciaBean.changeViolencia}"
                                 reRender="tableContentTabsEncuestaViolencia">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuViolencia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:selectOneRadio>
                </a4j:region>
                <t:htmlTag value="br"/>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Tipo de Violencia" id="fieldEncuestaViolencia" styleClass="fieldset" rendered="#{encuestaViolenciaBean.mostrar}">
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridTipoViolencia" rowClasses="labelText">
                <h:outputText value="Tipo de Violencia:"/>
                <h:outputText/>
                <h:outputText/>
                <h:outputText value="Fisica"/>
                <h:outputText value="Psicologica"/>
                <h:outputText value="Sexual"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectBooleanCheckbox id="checkFisica" value="#{encuestaViolenciaBean.existeVioFisica}" valueChangeListener="#{encuestaViolenciaBean.setExisteVioFisica}" immediate="true">
                    <a4j:support id="support2" event="onclick" immediate="true" action="#{encuestaViolenciaBean.changeViolenciaFisica}" reRender="panelOutputFisica,panelInputFisica">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectBooleanCheckbox>
                </a4j:region>
                <a4j:region renderRegionOnly="false">
                  <h:selectBooleanCheckbox id="checkPsicologica" value="#{encuestaViolenciaBean.existeVioPsicologica}" valueChangeListener="#{encuestaViolenciaBean.setExisteVioPsicologica}"
                                           immediate="true">
                    <a4j:support id="support" event="onclick" immediate="true" action="#{encuestaViolenciaBean.changeViolenciaPsicologica}" reRender="panelOutputPsicologica,panelInputPsicologica">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectBooleanCheckbox>
                </a4j:region>
                <a4j:region renderRegionOnly="false">
                  <h:selectBooleanCheckbox id="checkSexual" value="#{encuestaViolenciaBean.existeVioSexual}" valueChangeListener="#{encuestaViolenciaBean.setExisteVioSexual}" immediate="true">
                    <a4j:support id="supportSexual" event="onclick" immediate="true" action="#{encuestaViolenciaBean.changeViolenciaSexual}" reRender="panelOutputSexual,panelInputSexual">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectBooleanCheckbox>
                </a4j:region>
                <h:panelGroup id="panelOutputFisica">
                  <h:outputText value="¿Por quién? " styleClass="labelTextOblig" rendered="#{encuestaViolenciaBean.existeVioFisica}"/>
                </h:panelGroup>
                <h:panelGroup id="panelOutputPsicologica">
                  <h:outputText value="¿Por quién?" styleClass="labelTextOblig" rendered="#{encuestaViolenciaBean.existeVioPsicologica}"/>
                </h:panelGroup>
                <h:panelGroup id="panelOutputSexual">
                  <h:outputText value="¿Por quién?" styleClass="labelTextOblig" rendered="#{encuestaViolenciaBean.existeVioSexual}"/>
                </h:panelGroup>
                <h:panelGroup id="panelInputFisica">
                  <h:inputText id="mnuFisica" maxlength="20" required="#{encuestaViolenciaBean.existeVioFisica}" onkeydown="return blockEnter(event);"
                               value="#{encuestaViolenciaBean.encuesta.hvicfisiquien}" rendered="#{encuestaViolenciaBean.existeVioFisica}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuFisica" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelInputPsicologica">
                  <h:inputText id="mnuPsicologica" maxlength="20" required="#{encuestaViolenciaBean.existeVioPsicologica}" onkeydown="return blockEnter(event);"
                               value="#{encuestaViolenciaBean.encuesta.hvicpsicquien}" rendered="#{encuestaViolenciaBean.existeVioPsicologica}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuPsicologica" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelInputSexual">
                  <h:inputText id="mnuSexual" maxlength="20" required="#{encuestaViolenciaBean.existeVioSexual}" onkeydown="return blockEnter(event);"
                               value="#{encuestaViolenciaBean.encuesta.hvicsexuquien}" rendered="#{encuestaViolenciaBean.existeVioSexual}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuSexual" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
              <s:fieldset legend="Asesoria Violencia" id="fieldEncuestaViolenciaAsesoria" styleClass="fieldset" rendered="#{encuestaViolenciaBean.mostrar}">
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelEncustaViolenciaRiesgo" rowClasses="labelText,labelTextInfo">
                  <h:outputText value="¿Se siente en riesgo por la persona que lo maltrata?" styleClass="labelTextOblig"/>
                  <h:panelGroup id="panelOutputRiesgo">
                    <h:outputText value="¿Por quién?" rendered="#{encuestaViolenciaBean.mostrarRiesgo}" styleClass="labelTextOblig"/>
                  </h:panelGroup>
                  <a4j:region renderRegionOnly="false">
                    <h:panelGroup>
                      <h:selectOneRadio id="mnuRiesgo" value="#{encuestaViolenciaBean.sufreRiesgo}" immediate="true" required="true" valueChangeListener="#{encuestaViolenciaBean.setSufreRiesgo}">
                        <f:selectItems value="#{encuestaViolenciaBean.lstOpcionesViolencia}"/>
                        <a4j:support id="supportRiesgo" event="onclick" immediate="true" action="#{encuestaViolenciaBean.changeSufreRiesgo}" reRender="panelOutputRiesgo,panelInputRiesgo">
                          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                      </h:selectOneRadio>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuRiesgo" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </a4j:region>
                  <h:panelGroup id="panelInputRiesgo">
                    <h:inputText id="itRiesgoquien" maxlength="20" onkeydown="return blockEnter(event);" value="#{encuestaViolenciaBean.encuesta.hvicrsgxquien}"
                                 rendered="#{encuestaViolenciaBean.mostrarRiesgo}" required="#{encuestaViolenciaBean.mostrarRiesgo}"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itRiesgoquien" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGrid>
                <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelEncustaViolenciaRiesgo2" rowClasses="labelText,labelTextInfo">
                  <h:outputText value="¿Desea asesoría para hablar más sobre este asunto?" styleClass="labelTextOblig"/>
                  <h:panelGroup id="panelOutputTipoRemision">
                    <h:outputText value="Tipo Remision" rendered="#{encuestaViolenciaBean.mostrarDeseaHablar}" styleClass="labelTextOblig"/>
                  </h:panelGroup>
                  <h:panelGroup id="panelOutputRemitido">
                    <h:outputText value="Remitido/a a" rendered="#{encuestaViolenciaBean.mostrarDeseaHablar}" styleClass="labelTextOblig"/>
                  </h:panelGroup>
                  <h:panelGroup id="panelOutputCual">
                    <h:outputText value=" Cual" rendered="#{encuestaViolenciaBean.mostrarCual}" styleClass="labelTextOblig"/>
                  </h:panelGroup>
                  <a4j:region renderRegionOnly="false">
                    <h:panelGroup>
                      <h:selectOneRadio id="mnuHablar" immediate="true" required="true" value="#{encuestaViolenciaBean.deseaHablar}" valueChangeListener="#{encuestaViolenciaBean.setDeseaHablar}">
                        <f:selectItems value="#{encuestaViolenciaBean.lstOpcionesViolencia}"/>
                        <a4j:support id="supportHablar" event="onclick" immediate="true" action="#{encuestaViolenciaBean.changeDeseaHablar}"
                                     reRender="panelOutputRemitido,panelInputRemitido,panelOutputTipoRemision,panelRemision">
                          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                      </h:selectOneRadio>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuHablar" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </a4j:region>
                  <h:panelGroup id="panelRemision">
                    <a4j:region renderRegionOnly="false">
                      <h:selectOneRadio id="mnuTipoRemision" immediate="true" required="true" rendered="#{encuestaViolenciaBean.mostrarDeseaHablar}" value="#{encuestaViolenciaBean.tipoSelect}"
                                        valueChangeListener="#{encuestaViolenciaBean.setTipoSelect}">
                        <f:selectItems value="#{encuestaViolenciaBean.lstTipoRemision}"/>
                        <a4j:support id="supportTipoRemision" event="onclick" immediate="true" action="#{encuestaViolenciaBean.changeRemision}" reRender="panelOutputRemitido,panelInputRemitido">
                          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                        <a4j:outputPanel ajaxRendered="true">
                          <t:message for="mnuTipoRemision" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                      </h:selectOneRadio>
                    </a4j:region>
                  </h:panelGroup>
                  <h:panelGroup id="panelInputRemitido">
                    <h:selectOneMenu id="mnuRemision" rendered="#{encuestaViolenciaBean.mostrarDeseaHablar}" required="#{encuestaViolenciaBean.mostrarDeseaHablar}"
                                     value="#{encuestaViolenciaBean.encuesta.hvicremitidoa}" valueChangeListener="#{encuestaViolenciaBean.setHvicremitidoa}">
                      <f:selectItems value="#{encuestaViolenciaBean.lstRemision}"/>
                      <a4j:support id="supportmnuRemision" event="onchange" action="#{encuestaViolenciaBean.changeOtro}" reRender="panelInPutCual,panelOutputCual">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuRemision" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:panelGroup id="panelInPutCual">
                    <h:inputText id="itCual" value="#{encuestaViolenciaBean.encuesta.hvilcualremisi}" maxlength="100" rendered="#{encuestaViolenciaBean.mostrarCual}"/>
                  </h:panelGroup>
                </h:panelGrid>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelEncustaViolenciaRiesgoObservaciones" rowClasses="labelText,labelTextInfo">
                  <h:outputText value="Observaciones"/>
                  <h:outputText/>
                  <h:inputTextarea id="textEnfermedaActual" value="#{encuestaViolenciaBean.encuesta.hvitobserva}" style="width:600px"/>
                </h:panelGrid>
              </s:fieldset>
            </s:fieldset>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar" columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Guardar" styleClass="boton_fieldset" action="#{encuestaViolenciaBean.aceptar}">
                  <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMensajes" ajaxRendered="true">
                  <t:htmlTag value="br"/>
                  <t:messages id="msgInf" showSummary="true" errorClass="error" globalOnly="true" layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
  <script>
  document.forms['body:formEncuestaViolencia'].elements[5].focus(); 
  </script>
</a4j:form>