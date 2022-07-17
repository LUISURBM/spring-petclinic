<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEstadoPsicoemocionalTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneEstadoPsicoemocional" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabEstadoPsicoemocional" label="Estado Psicoemocional">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="tableContentTabsEstadoPsicoemocional" styleClass="tabContainer">
        <s:fieldset legend="" id="fieldAreaAfectivaAreaSomaticoPsicoemocional" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="1000px"
                       id="panelAreaAfectivaSomaticaPsicoemocional" rowClasses="labelText,labelTextInfo">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="500px"
                         id="panelAreaAfecSomaticatPsicoemocional" rowClasses="standardTable_Row4,standardTable_Row4"
                         style="border-color:#3f3e23;">
              <h:outputText value="Área Afectivo" styleClass="labelTextOblig"/>
              <h:panelGroup>
                <h:selectManyCheckbox required="false" style="border-style:none;" immediate="true"
                                      id="mnuAreaAfectivaPsicoemocional"
                                      value="#{estadoPsicoemocionalBean.lstAreaAfectivaSelect}" layout="pageDirection">
                  <f:selectItems value="#{estadoPsicoemocionalBean.lstAreaAfectiva}"/>
                </h:selectManyCheckbox>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAreaAfectivaPsicoemocional" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="500px"
                         id="panelAreaSomaticoPsicoemocional" rowClasses="standardTable_Row3,standardTable_Row3"
                         style="border-color:#3f3e23;">
              <h:outputText value="Área Somático" styleClass="labelTextOblig"/>
              <h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:selectManyCheckbox required="false" style="border-style:none;" immediate="true"
                                        id="mnuAreaSomaticoPsicoemocional"
                                        value="#{estadoPsicoemocionalBean.lstAreaSomaticoSelect}"
                                        valueChangeListener="#{estadoPsicoemocionalBean.setLstAreaSomaticoSelect}"
                                        layout="pageDirection">
                    <f:selectItems value="#{estadoPsicoemocionalBean.lstAreaSomatico}"/>
                    <a4j:support id="supportmnuAreaSomatica" event="onclick" immediate="true"
                                 action="#{estadoPsicoemocionalBean.ChangeAreaSomatica}"
                                 reRender="panelAreaSomaticoPsicoemocional">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectManyCheckbox>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAreaSomaticoPsicoemocional" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id="panelCualSomatico" rendered="#{estadoPsicoemocionalBean.renderOtroSomatico}">
                <h:outputText value="Cúal? " styleClass="labelTextOblig"
                              rendered="#{estadoPsicoemocionalBean.renderOtroSomatico}"/>
                <h:inputText id="itSomatico" style="width:300px" maxlength="80" required="true"
                             rendered="#{estadoPsicoemocionalBean.renderOtroSomatico}"
                             value="#{estadoPsicoemocionalBean.estadopsico.hepcotrosomat}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itSomatico" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="" id="fieldAreaCognitivaAreaRelacionalPsicoemocional" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="1000px"
                       id="panelAreaRelacionalCognitivaPsicoemocional" rowClasses="labelText,labelTextInfo">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="2" width="500px"
                         id="panelAreaCognitivaPsicoemocional" rowClasses="standardTable_Row4,standardTable_Row4"
                         style="border-color:#3f3e23;">
              <h:outputText value="Área Relacional" styleClass="labelTextOblig"/>
              <h:panelGroup/>
              <h:panelGroup>
                <h:selectManyCheckbox required="false" style="border-style:none;" immediate="true"
                                      id="mnuAreaRelacionalPsicoemocional"
                                      value="#{estadoPsicoemocionalBean.lstAreaRelacionalSelect}"
                                      valueChangeListener="#{estadoPsicoemocionalBean.setLstAreaRelacionalSelect}"
                                      layout="pageDirection">
                  <f:selectItems value="#{estadoPsicoemocionalBean.lstAreaRelacional}"/>
                  <a4j:support id="supportmnuAreaRelaciona" event="onclick" immediate="true"
                               action="#{estadoPsicoemocionalBean.ChangeAreaRelacional}"
                               reRender="panelCualRelacional,panelFobia">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectManyCheckbox>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAreaRelacionalPsicoemocional" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id="panelFobia">
                <h:outputText value="Cúal Fobia? " rendered="#{estadoPsicoemocionalBean.renderFobia}"
                              styleClass="labelTextOblig"/>
                <h:inputText id="itFobia" value="#{estadoPsicoemocionalBean.estadopsico.hepccualfobia}" required="true"
                             rendered="#{estadoPsicoemocionalBean.renderFobia}"/>
                              <a4j:outputPanel ajaxRendered="true"  rendered="#{estadoPsicoemocionalBean.renderFobia}">
                  <t:message for="itFobia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id="panelCualRelacional">
                <h:outputText value="Cúal? " styleClass="labelTextOblig"
                              rendered="#{estadoPsicoemocionalBean.renderOtroRelacional}"/>
                <h:inputText id="itRelacional" style="width:300px" maxlength="80" required="true"
                             rendered="#{estadoPsicoemocionalBean.renderOtroRelacional}"
                             value="#{estadoPsicoemocionalBean.estadopsico.hepcotrorelac}"/>
                <a4j:outputPanel ajaxRendered="true" rendered="#{estadoPsicoemocionalBean.renderOtroRelacional}">
                  <t:message for="itRelacional" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="500px" id="panelAreaCognitiva"
                         rowClasses="standardTable_Row3,standardTable_Row3" style="border-color:#3f3e23;">
              <h:outputText value="Área Cognitiva" styleClass="labelTextOblig"/>
              <h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:selectManyCheckbox required="false" style="border-style:none;" id="mnuAreaCognitiva"
                                        immediate="true" value="#{estadoPsicoemocionalBean.lstAreaCognitivaSelect}"
                                        valueChangeListener="#{estadoPsicoemocionalBean.setLstAreaCognitivaSelect}"
                                        layout="pageDirection">
                    <f:selectItems value="#{estadoPsicoemocionalBean.lstAreaCognitiva}"/>
                    <a4j:support id="supportmnuAreaCognitiva" event="onclick" immediate="true"
                                 action="#{estadoPsicoemocionalBean.ChangeAreaCognitiva}" reRender="panelAreaCognitiva">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectManyCheckbox>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAreaCognitiva" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id="panelCualCognitiva" rendered="#{estadoPsicoemocionalBean.renderOtroCognitivo}">
                <h:outputText value="Cúal? " styleClass="labelTextOblig"
                              rendered="#{estadoPsicoemocionalBean.renderOtroCognitivo}"/>
                <h:inputText id="itCognitiva" style="width:300px" maxlength="80" required="true"
                             rendered="#{estadoPsicoemocionalBean.renderOtroCognitivo}"
                             value="#{estadoPsicoemocionalBean.estadopsico.hepcotrocogni}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCognitiva" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Observaciones" id="fieldAreaObservacionesPsicoemocional" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="1000px"
                       id="panelAreaObservacionesPsicoemocional" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Observaciones"/>
            <h:outputText value=""/>
            <h:inputTextarea id="itObservaciones" style="width:600px;height:80px"
                             value="#{estadoPsicoemocionalBean.estadopsico.hepcobservacio}"/>
          </h:panelGrid>
        </s:fieldset>
        <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMensajesEstadoPsicoemocional" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInfEstadoPsicoemocional" showSummary="true" errorClass="error" globalOnly="true"
                          layout="table" infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="panelBotonGuardarEstadoPsicoemocional" columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                         action="#{estadoPsicoemocionalBean.guardarEstadoPsicoemocional}">
          <a4j:support event="onclick" status="statusButton"/>
        </h:commandButton>
      </h:panelGroup>
    </h:panelGrid>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>