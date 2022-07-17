<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAntecedentesFarmacologicosTuberculinaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneAntecedentesFarmacologicosTuberculina"
                     styleClass="tabbedPane" activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabAntecedentesFarmacologicosTuberculina" label="Antecedentes Farmacológicos Tuberculina">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsAntecedentesFarmacologicosTuberculina" styleClass="tabContainer">
        <s:fieldset legend="Aplicación" id="fieldAntecedentes" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%">
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputLabel value="AINES (Ibuprofeno, naproxeno, ASA, Diclofenaco, Indometacina, Piroxican, Etericoxib) "  styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesFarmacologicoso" immediate="true" value="#{antecedentesFarmacologicosTuberculinaBean.antecedfarma.hafcaines}"
                                    valueChangeListener="#{antecedentesFarmacologicosTuberculinaBean.setHafcaines}" required="true">
                    <f:selectItems value="#{antecedentesFarmacologicosTuberculinaBean.lstOpciones}"/>
                    <a4j:support id="supportAntecedentesFarmacologicosoo" event="onclick" action="#{antecedentesFarmacologicosTuberculinaBean.changeaines}" reRender="panelInputAines">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesFarmacologicoso" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputAines">
                  <h:panelGrid columns="1">
                    <h:panelGroup>
                      <h:outputLabel value="¿Cual ?" styleClass="labelTextOblig" rendered="#{antecedentesFarmacologicosTuberculinaBean.renderCualaines}"/>
                      <h:inputText id="itAinesCual" required="true" rendered="#{antecedentesFarmacologicosTuberculinaBean.renderCualaines}"
                                   value="#{antecedentesFarmacologicosTuberculinaBean.antecedfarma.hafcainecual}"/>
                    </h:panelGroup>
                    <h:panelGroup>
                      <h:outputLabel value="Frecuencia" styleClass="labelTextOblig" rendered="#{antecedentesFarmacologicosTuberculinaBean.renderCualaines}"/>
                      <h:inputText id="itAinesfrec" required="true" rendered="#{antecedentesFarmacologicosTuberculinaBean.renderCualaines}"
                                   value="#{antecedentesFarmacologicosTuberculinaBean.antecedfarma.hafcainefrecu}"/>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itAinesCual" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itAinesfrec" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputLabel value="Antiagregantes (ASA, Clopidrogel, Triflusal, Sulfinpirazona, Dipiramol, Proaciclina, Triclopidina)"  styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesFarmacologicosoaagr" immediate="true" value="#{antecedentesFarmacologicosTuberculinaBean.antecedfarma.hafcantiagre}"
                                    valueChangeListener="#{antecedentesFarmacologicosTuberculinaBean.setHafcantiagre}" required="true">
                    <f:selectItems value="#{antecedentesFarmacologicosTuberculinaBean.lstOpciones}"/>
                    <a4j:support id="supportAntecedentesFarmacologicosoaagr" event="onclick" action="#{antecedentesFarmacologicosTuberculinaBean.changeafcantiagre}" reRender="panelInputafcantiagre">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesFarmacologicosoaagr" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputafcantiagre">
                  <h:panelGrid columns="1">
                    <h:panelGroup>
                      <h:outputLabel value="¿Cual ?" styleClass="labelTextOblig" rendered="#{antecedentesFarmacologicosTuberculinaBean.renderCualagr}"/>
                      <h:inputText id="itAntiagCual" required="true" rendered="#{antecedentesFarmacologicosTuberculinaBean.renderCualagr}"
                                   value="#{antecedentesFarmacologicosTuberculinaBean.antecedfarma.hafcaagrecual}"/>
                    </h:panelGroup>
                    <h:panelGroup>
                      <h:outputLabel value="Frecuencia" styleClass="labelTextOblig" rendered="#{antecedentesFarmacologicosTuberculinaBean.renderCualagr}"/>
                      <h:inputText id="itAntiagfrec" required="true" rendered="#{antecedentesFarmacologicosTuberculinaBean.renderCualagr}"
                                   value="#{antecedentesFarmacologicosTuberculinaBean.antecedfarma.hafcaagrefrecu}"/>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itAntiagCual" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itAntiagfrec" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputLabel value="Anticoagulantes (Heparina, Enoxaparina, Nadroparina, Deltaparina, Fondaniparinux Sódico, Rivaroxaban, Dabigatran, Warfarina)"  styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesFarmacologicosac" immediate="true" value="#{antecedentesFarmacologicosTuberculinaBean.antecedfarma.hafcanticoag}"
                                    valueChangeListener="#{antecedentesFarmacologicosTuberculinaBean.setHafcanticoag}" required="true">
                    <f:selectItems value="#{antecedentesFarmacologicosTuberculinaBean.lstOpciones}"/>
                    <a4j:support id="supportAntecedentesFarmacologicosoaco" event="onclick" action="#{antecedentesFarmacologicosTuberculinaBean.changeanticoag}" reRender="panelInputAc">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesFarmacologicosac" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputAc">
                  <h:panelGrid columns="1">
                    <h:panelGroup>
                      <h:outputLabel value="¿Cual ?" styleClass="labelTextOblig" rendered="#{antecedentesFarmacologicosTuberculinaBean.renderCualaco}"/>
                      <h:inputText id="itAcoCual" required="true" rendered="#{antecedentesFarmacologicosTuberculinaBean.renderCualaco}"
                                   value="#{antecedentesFarmacologicosTuberculinaBean.antecedfarma.hafcacoagcual}"/>
                    </h:panelGroup>
                    <h:panelGroup>
                      <h:outputLabel value="Frecuencia" styleClass="labelTextOblig" rendered="#{antecedentesFarmacologicosTuberculinaBean.renderCualaco}"/>
                      <h:inputText id="itAcofrec" required="true" rendered="#{antecedentesFarmacologicosTuberculinaBean.renderCualaco}"
                                   value="#{antecedentesFarmacologicosTuberculinaBean.antecedfarma.hafcacoagfrec}"/>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itAcoCual" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itAcofrec" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputLabel value="Se ha aplicado algún medicamento en los últimos tres días?"  styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesFarmacologicosoapl" immediate="true" value="#{antecedentesFarmacologicosTuberculinaBean.antecedfarma.hafcaplimedic}"
                                    valueChangeListener="#{antecedentesFarmacologicosTuberculinaBean.setHafcaplimedic}" required="true">
                    <f:selectItems value="#{antecedentesFarmacologicosTuberculinaBean.lstOpciones}"/>
                    <a4j:support id="supportAntecedentesFarmacologicosApl" event="onclick" action="#{antecedentesFarmacologicosTuberculinaBean.changeafcaplimedic}" reRender="panelInputAmed">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesFarmacologicosoapl" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputAmed">
                  <h:panelGrid columns="1">
                    <h:panelGroup>
                      <h:outputLabel value="¿Cual ?" styleClass="labelTextOblig" rendered="#{antecedentesFarmacologicosTuberculinaBean.renderCualmedi}"/>
                      <h:inputText id="itAplCual" required="true" rendered="#{antecedentesFarmacologicosTuberculinaBean.renderCualmedi}"
                                   value="#{antecedentesFarmacologicosTuberculinaBean.antecedfarma.hafcaplmedcual}"/>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itAplCual" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputLabel value="Se ha aplicado alguna vacuna?"  styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesFarmacologicosav" immediate="true" value="#{antecedentesFarmacologicosTuberculinaBean.antecedfarma.hafcaplivacu}"
                                    valueChangeListener="#{antecedentesFarmacologicosTuberculinaBean.setHhafcaplivacu}" required="true">
                    <f:selectItems value="#{antecedentesFarmacologicosTuberculinaBean.lstOpciones}"/>
                    <a4j:support id="supportAntecedentesFarmacologicosoapv" event="onclick" action="#{antecedentesFarmacologicosTuberculinaBean.changehafcaplivacu}" reRender="panelInputAv">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesFarmacologicosav" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputAv">
                  <h:panelGrid columns="1">
                    <h:panelGroup>
                      <h:outputLabel value="¿Cual ?" styleClass="labelTextOblig" rendered="#{antecedentesFarmacologicosTuberculinaBean.renderCualva}"/>
                      <h:inputText id="itAvCual" required="true" rendered="#{antecedentesFarmacologicosTuberculinaBean.renderCualva}"
                                   value="#{antecedentesFarmacologicosTuberculinaBean.antecedfarma.hafcapvacucual}"/>
                    </h:panelGroup>
                    <h:panelGroup>
                      <h:outputLabel value="¿Hace cuántos días?" styleClass="labelTextOblig" rendered="#{antecedentesFarmacologicosTuberculinaBean.renderCualva}"/>
                      <h:inputText id="itAvDias" required="true" rendered="#{antecedentesFarmacologicosTuberculinaBean.renderCualva}"
                                   value="#{antecedentesFarmacologicosTuberculinaBean.antecedfarma.haflapvacudias}"/>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itAvCual" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itAvDias" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
      </h:panelGrid>
    </t:panelTab>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonGuardarAntecedenteFarmacologicosTuberculina" columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Guardar" styleClass="boton_fieldset" action="#{antecedentesFarmacologicosTuberculinaBean.aceptar}">
          <a4j:support event="onclick" status="statusButton" reRender="panelTabAntecedentesFarmacologicosTuberculina"/>
        </h:commandButton>
      </h:panelGroup>
    </h:panelGrid>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>