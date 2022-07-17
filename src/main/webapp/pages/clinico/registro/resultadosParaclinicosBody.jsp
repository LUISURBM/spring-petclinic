<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formResultadosParaclinicos">
  <a4j:region id="regionResultadosParaclinicos" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionResultadosParaclinicos">
      <f:facet name="start">
        <t:div id="chargingResultadosParaclinicos" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
  
    
   
    
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridResultadosParaclinicosTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneResultadosParaclinicos"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabResultadosParaclinicos"
                    label="Resultados Paraclinicos">
          <s:fieldset legend="Cuadro Hematico" id="fieldMotivo1"
                      styleClass="fieldset">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelGridResultadosParaclinicos"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Hemoglobina (gr/dl)"/>
              <h:outputText value="Hematocrito(%)"  />
              <h:outputText value="Leucocitos µl(microlitros)" />
              <h:outputText value="PT(segundos)"  />
              <h:panelGroup>
                <h:inputText id="itHemoglobina" required="false" style="width:50px" maxlength="4"
                             value="#{resultadosParaclinicosBean.resultado.hrpnhemoglobin}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itHemoglobina" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itHematocrito" required="false" style="width:50px" maxlength="4"
                             value="#{resultadosParaclinicosBean.resultado.hrpnhematocrit}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itHematocrito" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itLeucocitos" required="false" style="width:50px" maxlength="5"
                             value="#{resultadosParaclinicosBean.resultado.hrpnleucocitos}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itLeucocitos" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itPt" required="false" style="width:50px" maxlength="4"
                             value="#{resultadosParaclinicosBean.resultado.hrpnpt}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itPt" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="INR"  />
              <h:outputText value="PTT(segundos)"  />
              <h:outputText value="Plaquetas µl(microlitros)"
                             />
              <h:outputText/>
              <h:panelGroup>
                <h:inputText id="itInr" required="false" style="width:50px" maxlength="3"
                             value="#{resultadosParaclinicosBean.resultado.hrpninr}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itInr" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itPtt" required="false" style="width:50px" maxlength="4"
                             value="#{resultadosParaclinicosBean.resultado.hrpnptt}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itPtt" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itPlaquetas" required="false" style="width:50px" maxlength="6"
                             value="#{resultadosParaclinicosBean.resultado.hrpnplaquetas}"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itPlaquetas" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText/>
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Parcial Orina" id="fieldParcialOrina"
                      styleClass="fieldset">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelGridResultadosParaclinicos2"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Parcial de orina"
                             />
              <h:panelGroup>
                <h:inputTextarea id="itParcialOrina" required="false" 
                                 style="width:600px"
                                 value="#{resultadosParaclinicosBean.resultado.hrpcparciorina}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itParcialOrina" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Otros Examenes" id="fieldOtrosExamenes"
                      styleClass="fieldset">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelGridResultadosParaclinicos3"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Glicemia Pre (mg/dl)"
                             />
              <h:outputText value="Glicemia Post (mg/dl)"
                             />
              <h:outputText value="Nitrógeno ureíco(mg/dl)"
                             />
              <h:outputText value="Creatinina(mg/dl)"
                             />
              <h:panelGroup>
                <h:inputText id="itGlicemiaPre" required="false" style="width:50px" maxlength="5"
                             value="#{resultadosParaclinicosBean.resultado.hrpnglicemipre}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itGlicemiaPre" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itGlicemiaPos" required="false" style="width:50px" maxlength="5"
                             value="#{resultadosParaclinicosBean.resultado.hrpnglicemipos}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itGlicemiaPos" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itNitrogeno" required="false" style="width:50px" maxlength="4"
                             value="#{resultadosParaclinicosBean.resultado.hrpnnitroureic}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itNitrogeno" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itCreatinina" required="false" style="width:50px" maxlength="4"
                             value="#{resultadosParaclinicosBean.resultado.hrpnncreatinin}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCreatinina" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelGridResultadosParaclinicos4"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Electrocardiograma"
                             />
              <h:panelGroup>
                <h:inputTextarea id="itElectrocardiograma" required="false"
                                 style="width:600px"
                                 value="#{resultadosParaclinicosBean.resultado.hrpcelectrocar}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itElectrocardiograma"
                             styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Rayos X de Tórax"
                             />
              <h:panelGroup>
                <h:inputTextarea id="itRayosXTorax" required="false"
                                 style="width:600px"
                                 value="#{resultadosParaclinicosBean.resultado.hrpcrayosxtora}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itRayosXTorax" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Ecografías"  />
              <h:panelGroup>
                <h:inputTextarea id="itEcografías" required="false"
                                 style="width:600px"
                                 value="#{resultadosParaclinicosBean.resultado.hrpcecografias}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itEcografías" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Otros resultados de laboratorio"
                             />
              <h:panelGroup>
                <h:inputTextarea id="itOtrosResultados" required="false"
                                 style="width:600px"
                                 value="#{resultadosParaclinicosBean.resultado.hrpcotrosresul}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itOtrosResultados" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </s:fieldset>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelBotonesResultadosParaclinicos"
                       columnClasses="panelGridBotones">
            <h:panelGroup>
              <h:commandButton value="Guardar" styleClass="boton_fieldset"
                               action="#{resultadosParaclinicosBean.aceptar}"/>
            </h:panelGroup>
          </h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionResultadosParaclinicosMsg"
                             ajaxRendered="true">
              <t:messages id="msgInformationResultadosParaclinicosMsg"
                          showSummary="true" errorClass="error"
                          globalOnly="true" layout="table"
                          infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>