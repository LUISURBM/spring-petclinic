<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridMonitorTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosAnestesiologo.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneMonitor" styleClass="tabbedPane" activeTabStyleClass="activeTab"
                     inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                     activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabRegistrarMonitoria" label="Monitoria">
      <s:fieldset legend="Registrar Monitores" id="fieldMonitores" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelElectrocardiografia"
                     rowClasses="labelText,labelTextInfo" rendered="#{registrarMonitoriaBean.renderOtrasCirugias}">
          <h:outputText value="Fonendoscopio"/>
          <h:panelGroup>
            <h:outputText value="Sitio de colocación" styleClass="labelTextOblig"
                          rendered="#{registrarMonitoriaBean.mostrarfonendoscopio}"/>
          </h:panelGroup>
          <a4j:region renderRegionOnly="false">
            <h:selectOneRadio id="mnuFonendoscopio" immediate="true"
                              value="#{registrarMonitoriaBean.monitoria.hmocfonendosco}"
                              valueChangeListener="#{registrarMonitoriaBean.setHmocfonendosco}">
              <f:selectItems value="#{registrarMonitoriaBean.lstFonendoscopio}"/>
              <a4j:support id="supportFonendoscopio" event="onclick" ignoreDupResponses="true" immediate="true"
                           action="#{registrarMonitoriaBean.changeFonendoscopio}" reRender="panelElectrocardiografia">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:selectOneRadio>
          </a4j:region>
          <h:panelGroup>
            <h:inputText id="itSitio" required="true" rendered="#{registrarMonitoriaBean.mostrarfonendoscopio}"
                         value="#{registrarMonitoriaBean.monitoria.hmocsitiofonen}"/>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarMonitoriaBean.mostrarfonendoscopio}">
              <t:message for="itSitio" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          
          
        
  
          
        </h:panelGrid>
        <h:panelGroup id="fieldElectro">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelElectro"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Electrocardiografía"/>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:outputText value="Derivación" styleClass="labelTextOblig"/>
            <h:panelGroup id="panelTextCual">
              <h:outputText value="Cual? " styleClass="labelTextOblig"
                            rendered="#{registrarMonitoriaBean.mostrarotroelectro}"/>
            </h:panelGroup>
            <h:outputText value="Capnografía" styleClass="labelTextOblig"/>
            <h:panelGroup id="panelTipoCapnografia">
              <h:outputText value="Tipo de Capnografía" styleClass="labelTextOblig"
                            rendered="#{registrarMonitoriaBean.mostrartipocapnografia}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
          
              <h:selectOneRadio id="mnuElectrocardiografia" immediate="true"
                                value="#{registrarMonitoriaBean.monitoria.hmocelectderiv}"
                                valueChangeListener="#{registrarMonitoriaBean.setHmocelectderiv}">
                <f:selectItems value="#{registrarMonitoriaBean.lstDerivacion}"/>
                <a4j:support id="supportElectrocardiografia" event="onclick" ignoreDupResponses="true" immediate="true"
                             action="#{registrarMonitoriaBean.changeElectrocardiografia}"
                             reRender="panelTextCual,panelInputCual">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              
            </a4j:region>
            <h:panelGroup id="panelInputCual">
              <h:inputText id="itCualElectro" maxlength="20" required="true"
                           rendered="#{registrarMonitoriaBean.mostrarotroelectro}"
                           value="#{registrarMonitoriaBean.monitoria.hmocotraderiva}"/>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarMonitoriaBean.mostrarotroelectro}">
                <t:message for="itCualElectro" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuCapnografia" immediate="true" required="true"
                                  value="#{registrarMonitoriaBean.monitoria.hmoccapnografi}"
                                  valueChangeListener="#{registrarMonitoriaBean.setHmoccapnografi}">
                  <f:selectItems value="#{registrarMonitoriaBean.lstOpciones}"/>
                  <a4j:support id="supportCapnografia" event="onclick" ignoreDupResponses="true" immediate="true"
                               action="#{registrarMonitoriaBean.changeCapnografia}"
                               reRender="panelTipoCapnografia,panelTipoCapnografia2">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuCapnografia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </a4j:region>
            </h:panelGroup>
              <h:panelGroup id="panelTipoCapnografia2">
            <h:selectOneRadio id="mnuTipoCapnografia" required="true"
                              rendered="#{registrarMonitoriaBean.mostrartipocapnografia}"
                              value="#{registrarMonitoriaBean.monitoria.hmoctipocapnog}">
              <f:selectItems value="#{registrarMonitoriaBean.lstTipoCapnografia}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registrarMonitoriaBean.mostrartipocapnografia}">
              <t:message for="mnuTipoCapnografia" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          
             <h:outputText value="Oximetria de pulso" rendered="#{registrarMonitoriaBean.renderOximetria}"/>
           <h:outputText value = ""/>
           <h:outputText value = ""/>
           <h:outputText value = ""/>
           
                    
           <h:selectOneRadio id="mnuOximetriaPulso" required="true"
                              rendered="#{registrarMonitoriaBean.renderOximetria}"
                              value="#{registrarMonitoriaBean.monitoria.hmocoximepulso}">
              <f:selectItems value="#{registrarMonitoriaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuOximetriaPulso" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
                       <h:outputText value = ""/>
           <h:outputText value = ""/>
      
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" rendered="#{registrarMonitoriaBean.ligadura}"
                       id="panelElectrocardiografiaObservaciones" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Observaciones"/>
            <h:inputTextarea id="inputObserElectro" style="width:600px"
                             value="#{registrarMonitoriaBean.monitoria.hmocobserderiv}"/>
          </h:panelGrid>
        </h:panelGroup>
        <h:panelGroup id="fieldPresionArterial" rendered="#{registrarMonitoriaBean.renderOtrasCirugias}">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelPresionArterial"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Presión Arterial"/>
            <h:panelGroup>
              <h:panelGroup>
                <h:outputText value="Procedimiento de canualción arterial" styleClass="labelTextOblig"
                              rendered="#{!registrarMonitoriaBean.mostrarnoinvasiva && registrarMonitoriaBean.mostrarinvasiva}"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:outputText value="Tipo Presion Arterial" styleClass="labelTextOblig"
                              rendered="#{registrarMonitoriaBean.mostrarnoinvasiva && !registrarMonitoriaBean.mostrarinvasiva}"/>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuPresionArterial" immediate="true"
                                  value="#{registrarMonitoriaBean.monitoria.hmocpresiarter}"
                                  valueChangeListener="#{registrarMonitoriaBean.setHmocpresiarter}">
                  <f:selectItems value="#{registrarMonitoriaBean.lstTipoPresionArterial}"/>
                  <a4j:support id="supportPresionArterial" event="onclick" ignoreDupResponses="true" immediate="true"
                               action="#{registrarMonitoriaBean.changePresionArterial}" reRender="fieldPresionArterial">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGroup>
                <h:selectManyCheckbox id="mnuTipoPresionArterial" required="true" layout="pageDirection"
                                      rendered="#{registrarMonitoriaBean.mostrarnoinvasiva && !registrarMonitoriaBean.mostrarinvasiva}"
                                      value="#{registrarMonitoriaBean.lstPresionSelect}">
                  <f:selectItems value="#{registrarMonitoriaBean.lstPresionArterialNoInvasiva}"/>
                </h:selectManyCheckbox>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{registrarMonitoriaBean.mostrarnoinvasiva && !registrarMonitoriaBean.mostrarinvasiva}">
                  <t:message for="mnuTipoPresionArterial" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputTextarea id="inputAreaInvasiva" style="width:200px" required="true"
                                 rendered="#{!registrarMonitoriaBean.mostrarnoinvasiva && registrarMonitoriaBean.mostrarinvasiva}"
                                 value="#{registrarMonitoriaBean.monitoria.hmoccanuaarter}"/>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{!registrarMonitoriaBean.mostrarnoinvasiva && registrarMonitoriaBean.mostrarinvasiva}">
                  <t:message for="inputAreaInvasiva" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
          </h:panelGrid>
        </h:panelGroup>
 
        <h:panelGroup id="fieldRelajacion" rendered="#{registrarMonitoriaBean.renderOtrasCirugias}">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRelajacion"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Relajación Muscular" styleClass="labelTextOblig"/>
            <h:panelGroup id="panelTextRelajacion">
              <h:outputText value="Observaciones" styleClass="labelTextOblig"
                            rendered="#{registrarMonitoriaBean.mostrarrelajacion}"/>
            </h:panelGroup>
            <h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuRelajacion" immediate="true" required="true"
                                  value="#{registrarMonitoriaBean.monitoria.hmocrelajmuscu}"
                                  valueChangeListener="#{registrarMonitoriaBean.setHmocrelajmuscu}">
                  <f:selectItems value="#{registrarMonitoriaBean.lstOpciones}"/>
                  <a4j:support id="supportRelajacion" event="onclick" ignoreDupResponses="true" immediate="true"
                               action="#{registrarMonitoriaBean.changeRelajacion}"
                               reRender="panelInputRelajacion,panelTextRelajacion">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuRelajacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </a4j:region>
            </h:panelGroup>
            <h:panelGroup id="panelInputRelajacion">
              <h:inputTextarea id="itRelajacionMuscular" required="true"
                               rendered="#{registrarMonitoriaBean.mostrarrelajacion}"
                               value="#{registrarMonitoriaBean.monitoria.hmocobserrelaj}" style="width:400px"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itRelajacionMuscular" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </h:panelGroup>
        <h:panelGroup id="fieldTemperatura" rendered="#{registrarMonitoriaBean.renderOtrasCirugias}">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelTemperatura"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Temperatura"  styleClass="labelTextOblig"/>
            <h:panelGroup id="panelTextSitio">
              <h:outputText value="Sitio de toma de la temperatura" styleClass="labelTextOblig"
                            rendered="#{registrarMonitoriaBean.mostartemperatura}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuTemperatura" immediate="true" required="true"
                                value="#{registrarMonitoriaBean.monitoria.hmocmonittempe}"
                                valueChangeListener="#{registrarMonitoriaBean.setHmocmonittempe}">
                <f:selectItems value="#{registrarMonitoriaBean.lstOpciones}"/>
                <a4j:support id="supportTemperatura" event="onclick" ignoreDupResponses="true" immediate="true"
                             action="#{registrarMonitoriaBean.changeTemperatura}"
                             reRender="panelTextSitio,panelInputSitio">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuTemperatura" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:selectOneRadio>
            </a4j:region>
            <h:panelGroup id="panelInputSitio">
              <h:inputTextarea id="itInputSitio" style="width:400px" required="true"
                               value="#{registrarMonitoriaBean.monitoria.hmocsitiotempe}"
                               rendered="#{registrarMonitoriaBean.mostartemperatura}"/>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarMonitoriaBean.mostartemperatura}">
                <t:message for="itInputSitio" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </h:panelGroup>
      </s:fieldset>
    </t:panelTab>
  </t:panelTabbedPane>
  <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
               columnClasses="panelGridBotones">
    <h:panelGroup>
      <h:commandButton value="Siguiente" styleClass="btn btn btn-info"
                       action="#{registrarMonitoriaBean.registrarMonitores}">
        <a4j:support event="onclick" status="statusButton"/>
      </h:commandButton>
    </h:panelGroup>
  </h:panelGrid>
  <h:panelGrid>
    <h:panelGroup>
      <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
        <t:htmlTag value="br"/>
        <t:messages id="msgInformationAndErrors1" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                    infoClass="informacion"/>
      </a4j:outputPanel>
    </h:panelGroup>
  </h:panelGrid>
</h:panelGrid>