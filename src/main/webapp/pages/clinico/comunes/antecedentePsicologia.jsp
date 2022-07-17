<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAntecedentesPsicologiaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneAntecedentesPsicologia" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabAntecedentesPsicologia" label="Antecedentes Psicologia">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsAntecedentesPsicologia" styleClass="tabContainer">
        <s:fieldset legend="Antecedentes" id="fieldAntecedentes" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAntecedenteDesarrolloInfantil" rowClasses="labelText,labelTextInfo">
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputText value="¿Presenta algún tipo de discapacidad? " styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesDiscapacidad" immediate="true" value="#{antecedentePsicologiaBean.antecedente.hpacpresedisca}"
                                    valueChangeListener="#{antecedentePsicologiaBean.setHpacpresedisca}">
                    <f:selectItems value="#{antecedentePsicologiaBean.lstOpciones}"/>
                    <a4j:support id="supportAntecedentesDiscapacidad" event="onclick" action="#{antecedentePsicologiaBean.changeDiscapacidad}" reRender="panelInputCualDiscapacidad">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesDiscapacidad" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputCualDiscapacidad">
                  <h:outputText value="¿Cual? " styleClass="labelTextOblig" rendered="#{antecedentePsicologiaBean.renderDiscapacidad}"/>
                  <h:inputText id="itCualDiscapacidad" required="true" rendered="#{antecedentePsicologiaBean.renderDiscapacidad}" value="#{antecedentePsicologiaBean.antecedente.hpaccualdisca}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCualDiscapacidad" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputText value="¿Actualmente toma algún medicamento?" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesMedicamento" immediate="true" value="#{antecedentePsicologiaBean.antecedente.hpactomamedi}"
                                    valueChangeListener="#{antecedentePsicologiaBean.setHpactomamedi}">
                    <f:selectItems value="#{antecedentePsicologiaBean.lstOpciones}"/>
                    <a4j:support id="supportAntecedentesMedicamento" event="onclick" action="#{antecedentePsicologiaBean.changeMedicamento}" reRender="panelInputCualMedicamento">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesMedicamento" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputCualMedicamento">
                  <h:outputText value="¿Cual? " styleClass="labelTextOblig" rendered="#{antecedentePsicologiaBean.renderMedicamentos}"/>
                  <h:inputText id="itCualMedicamento" required="true" rendered="#{antecedentePsicologiaBean.renderMedicamentos}" value="#{antecedentePsicologiaBean.antecedente.hpaccualmedi}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCualMedicamento" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputText value="¿Presenta algún trastorno mental?" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesTrastornoM" immediate="true" value="#{antecedentePsicologiaBean.antecedente.hpactrastmenta}"
                                    valueChangeListener="#{antecedentePsicologiaBean.setHpactrastmenta}">
                    <f:selectItems value="#{antecedentePsicologiaBean.lstOpciones}"/>
                    <a4j:support id="supportAntecedentesTrastornoM" event="onclick" action="#{antecedentePsicologiaBean.changeTrastornoMental}" reRender="panelInputCualTrastornoM">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesTrastornoM" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputCualTrastornoM">
                  <h:outputText value="¿Cual? " styleClass="labelTextOblig" rendered="#{antecedentePsicologiaBean.renderTrastornos}"/>
                  <h:inputText id="itCualTrastornoM" required="true" rendered="#{antecedentePsicologiaBean.renderTrastornos}" value="#{antecedentePsicologiaBean.antecedente.hpaccualtrast}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCualTrastornoM" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputText value="¿Actualmente tiene alguna enfermedad médica diagnosticada?" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedenteEnferDiag" immediate="true" value="#{antecedentePsicologiaBean.antecedente.hpacenfediag}"
                                    valueChangeListener="#{antecedentePsicologiaBean.setHpacenfediag}">
                    <f:selectItems value="#{antecedentePsicologiaBean.lstOpciones}"/>
                    <a4j:support id="supportAntecedentesEnferDiag" event="onclick" action="#{antecedentePsicologiaBean.changeEnfermedadDiag}" reRender="panelInputCualEnferDiag">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesEnferDiag" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputCualEnferDiag">
                  <h:outputText value="¿Cual? " styleClass="labelTextOblig" rendered="#{antecedentePsicologiaBean.renderEnfermedadDiag}"/>
                  <h:inputText id="itCualEnferDiag" required="true" rendered="#{antecedentePsicologiaBean.renderEnfermedadDiag}" value="#{antecedentePsicologiaBean.antecedente.hpaccualenfe}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCualEnferDiag" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputText value="¿Tiene vida sexual activa?" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedenteVSexActiva" immediate="true" value="#{antecedentePsicologiaBean.antecedente.hpacvidasexac}"
                                    valueChangeListener="#{antecedentePsicologiaBean.setHpacvidasexac}">
                    <f:selectItems value="#{antecedentePsicologiaBean.lstOpciones}"/>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesVSexActiva" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputText value="¿Tiene relaciones sexuales satisfactorias?" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedenteRelaSatis" immediate="true" value="#{antecedentePsicologiaBean.antecedente.hpacrelacsatis}"
                                    valueChangeListener="#{antecedentePsicologiaBean.setHpacrelacsatis}">
                    <f:selectItems value="#{antecedentePsicologiaBean.lstOpciones}"/>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesRelaSatis" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputText value="¿Tiene hábitos de vida saludable?" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedenteHabitoSalud" immediate="true" value="#{antecedentePsicologiaBean.antecedente.hpachabitsalud}"
                                    valueChangeListener="#{antecedentePsicologiaBean.setHpachabitsalud}">
                    <f:selectItems value="#{antecedentePsicologiaBean.lstOpciones}"/>
                    <a4j:support id="supportAntecedentesHabitoSalud" event="onclick" action="#{antecedentePsicologiaBean.changHabitoSaludable}" reRender="panelInputCualHabitoSalud">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesHabitoSalud" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputCualHabitoSalud">
                  <h:outputText value="¿Cual? " styleClass="labelTextOblig" rendered="#{antecedentePsicologiaBean.renderHabitoSaludable}"/>
                  <h:inputText id="itCualHabitoSalud" required="true" rendered="#{antecedentePsicologiaBean.renderHabitoSaludable}" value="#{antecedentePsicologiaBean.antecedente.hpaccualhabit}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCualHabitoSalud" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputText value="¿Ha intentado quitarse la vida?" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedenteQuitVida" immediate="true" value="#{antecedentePsicologiaBean.antecedente.hpacquitavida}"
                                    valueChangeListener="#{antecedentePsicologiaBean.setHpacquitavida}">
                    <f:selectItems value="#{antecedentePsicologiaBean.lstOpciones}"/>
                    <a4j:support id="supportAntecedentesQuitVida" event="onclick" action="#{antecedentePsicologiaBean.changeQuitaVida}" reRender="panelInputCualQuitVida">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesQuitVida" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputCualQuitVida">
                  <h:outputText value="¿De qué manera? " styleClass="labelTextOblig" rendered="#{antecedentePsicologiaBean.renderquitaVida}"/>
                  <h:inputText id="itCualQuitVida" required="true" rendered="#{antecedentePsicologiaBean.renderquitaVida}" value="#{antecedentePsicologiaBean.antecedente.hpacmanequit}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCualQuitVida" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup rendered="false">
             <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="500px" id="panelTipoViolencia" rowClasses="standardTable_Row4,standardTable_Row4">
              <h:outputText value="¿Ha experimentado algún tipo de violencia? " styleClass="labelTextOblig"/>
              <h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:selectManyCheckbox required="false" style="border-style:none;" immediate="true" id="mnuAreaTipoViolencia" value="#{antecedentePsicologiaBean.lstTipoViolenciaSelect}"
                                        layout="pageDirection">
                    <f:selectItems value="#{antecedentePsicologiaBean.lstTipoViolencia}"/>
                  </h:selectManyCheckbox>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAreaTipoViolencia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
            
            </h:panelGroup>
            
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputText value="¿Ha consumido o consume algún tipo de sustancia psicoactiva?" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedenteSustPsico" immediate="true" value="#{antecedentePsicologiaBean.antecedente.hpacsustapsico}"
                                    valueChangeListener="#{antecedentePsicologiaBean.setHpacsustapsico}">
                    <f:selectItems value="#{antecedentePsicologiaBean.lstOpciones}"/>
                    <a4j:support id="supportAntecedentesSustPsico" event="onclick" action="#{antecedentePsicologiaBean.changeSustanciaPsico}" reRender="panelInputCualSustPsico">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesSustPsico" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputCualSustPsico">
                  <h:outputText value="¿Cual? " styleClass="labelTextOblig" rendered="#{antecedentePsicologiaBean.rendersustanciaPsico}"/>
                  <h:inputText id="itCualSustPsico" required="true" rendered="#{antecedentePsicologiaBean.rendersustanciaPsico}" value="#{antecedentePsicologiaBean.antecedente.hpaccualsusta}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCualSustPsico" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputText value="¿Es víctima de conflicto armado?" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedenteConflictoArm" immediate="true" value="#{antecedentePsicologiaBean.antecedente.hpacvicconfarm}"
                                    valueChangeListener="#{antecedentePsicologiaBean.setHpacvicconfarm}">
                    <f:selectItems value="#{antecedentePsicologiaBean.lstOpciones}"/>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesConflictoArm" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        
        <s:fieldset legend="Desarrollo Infantil (Hasta los 12 años)" id="fieldAntecedenteDesarrolloInfantil" styleClass="fieldset" rendered="#{antecedentePsicologiaBean.menor12edad}">
          <h:panelGrid columns="4" width="100%" id="panelAntecedenteDesarrolloI">
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputText value="¿A qué edad hablo? " styleClass="labelTextOblig"/>
                <h:inputText id="itEdadHablo" required="true" value="#{antecedentePsicologiaBean.antecedente.hpanedadhabla}" maxlength="2" style="width:30px"/>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputText value="¿A qué edad gateo? " styleClass="labelTextOblig"/>
                <h:inputText id="itEdadGateo" required="true" value="#{antecedentePsicologiaBean.antecedente.hpanedadgateo}" maxlength="2" style="width:30px"/>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputText value="¿A qué edad camino? " styleClass="labelTextOblig"/>
                <h:inputText id="itEdadCamino" required="true" value="#{antecedentePsicologiaBean.antecedente.hpanedadcamino}" maxlength="2" style="width:30px"/>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputText value="¿Cuántas horas duerme? " styleClass="labelTextOblig"/>
                <h:inputText id="itHoraDuerme" required="true" value="#{antecedentePsicologiaBean.antecedente.hpanhorasduerm}" maxlength="2" style="width:30px"/>
              </h:panelGrid>
            </h:panelGroup>
          </h:panelGrid>
          <h:panelGrid columns="2" width="100%" id="panelAntecedenteDesarrolloInf">
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputText value="¿Ha presentado dificultades de aprendizaje?" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedenteDifiApren" immediate="true" value="#{antecedentePsicologiaBean.antecedente.hpacdificapren}"
                                    valueChangeListener="#{antecedentePsicologiaBean.setHpacdificapren}">
                    <f:selectItems value="#{antecedentePsicologiaBean.lstOpciones}"/>
                    <a4j:support id="supportAntecedentesDifiApren" event="onclick" action="#{antecedentePsicologiaBean.changeDificultadAprend}" reRender="panelInputCualDifiApren">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesDifiApren" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputCualDifiApren">
                  <h:outputText value="¿Cual? " styleClass="labelTextOblig" rendered="#{antecedentePsicologiaBean.renderDificultadAprend}"/>
                  <h:inputText id="itCualDifiApren" required="true" rendered="#{antecedentePsicologiaBean.renderDificultadAprend}" value="#{antecedentePsicologiaBean.antecedente.hpaccualdific}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCualDifiApren" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputText value="¿Socializa fácilmente con pares?" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentePares" immediate="true" value="#{antecedentePsicologiaBean.antecedente.hpacsociapare}"
                                    valueChangeListener="#{antecedentePsicologiaBean.setHpacsociapare}">
                    <f:selectItems value="#{antecedentePsicologiaBean.lstOpciones}"/>
                    <a4j:support id="supportAntecedentesPares" event="onclick" action="#{antecedentePsicologiaBean.changeSocializaPares}" reRender="panelInputCualPares">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesPares" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputCualPares">
                  <h:outputText value="Observaciones " styleClass="labelTextOblig" rendered="#{antecedentePsicologiaBean.renderSocializarPares}"/>
                  <h:inputText id="itCualPares" required="true" rendered="#{antecedentePsicologiaBean.renderSocializarPares}" value="#{antecedentePsicologiaBean.antecedente.hpacobssoci}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCualPares" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputText value="¿Tienen rutinas establecidas?" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedenteRutina" immediate="true" value="#{antecedentePsicologiaBean.antecedente.hpacrutiesta}"
                                    valueChangeListener="#{antecedentePsicologiaBean.setHpacrutiesta}">
                    <f:selectItems value="#{antecedentePsicologiaBean.lstOpciones}"/>
                    <a4j:support id="supportAntecedentesRutina" event="onclick" action="#{antecedentePsicologiaBean.changeRutina}" reRender="panelInputCualRutina">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesRutina" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputCualRutina">
                  <h:outputText value="Cuales? " styleClass="labelTextOblig" rendered="#{antecedentePsicologiaBean.renderRutina}"/>
                  <h:inputText id="itCualRutina" required="true" rendered="#{antecedentePsicologiaBean.renderRutina}" value="#{antecedentePsicologiaBean.antecedente.hpacualruti}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCualRutina" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputText value="¿Cúal es el temperamento predominante?" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedenteTemperamento" immediate="true" value="#{antecedentePsicologiaBean.antecedente.hpactemppred}"
                                    valueChangeListener="#{antecedentePsicologiaBean.setHpactemppred}">
                    <f:selectItems value="#{antecedentePsicologiaBean.lstOpciones}"/>
                    <a4j:support id="supportAntecedentesTemperamento" event="onclick" action="#{antecedentePsicologiaBean.changeTemperamento}" reRender="panelInputCualTemperamento">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesTemperamento" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputCualTemperamento">
                  <h:outputText value="Observaciones " styleClass="labelTextOblig" rendered="#{antecedentePsicologiaBean.renderTemperamento}"/>
                  <h:inputText id="itCualTemperamento" required="true" rendered="#{antecedentePsicologiaBean.renderTemperamento}" value="#{antecedentePsicologiaBean.antecedente.hpacobstemp}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCualTemperamento" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
           
          </h:panelGrid>
        </s:fieldset>
        <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMensajesPsicologia" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInfPsicologia" showSummary="true" errorClass="error" globalOnly="true" layout="table" infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonGuardarAntecedentePsicologico" columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Guardar" styleClass="boton_fieldset" action="#{antecedentePsicologiaBean.guardarAntecedente}">
          <a4j:support event="onclick" status="statusButton" reRender="panelTabAntecedentesPsicologia"/>
        </h:commandButton>
      </h:panelGroup>
    </h:panelGrid>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>