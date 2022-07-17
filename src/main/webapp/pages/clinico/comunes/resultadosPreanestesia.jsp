<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAntecedentesGeneralesTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  
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
                             onkeydown="return blockEnter(event);"
                             value="#{resultadosParaclinicosUsuarioBean.resultado.hrpnhemoglobin}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itHemoglobina" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itHematocrito" required="false" style="width:50px" maxlength="4"
                            onkeydown="return blockEnter(event);"
                             value="#{resultadosParaclinicosUsuarioBean.resultado.hrpnhematocrit}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itHematocrito" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itLeucocitos" required="false" style="width:50px" maxlength="5"
                            onkeydown="return blockEnter(event);"
                             value="#{resultadosParaclinicosUsuarioBean.resultado.hrpnleucocitos}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itLeucocitos" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itPt" required="false" style="width:50px" maxlength="4"
                            onkeydown="return blockEnter(event);"
                             value="#{resultadosParaclinicosUsuarioBean.resultado.hrpnpt}"/>
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
                             onkeydown="return blockEnter(event);"
                             value="#{resultadosParaclinicosUsuarioBean.resultado.hrpninr}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itInr" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itPtt" required="false" style="width:50px" maxlength="4"
                             onkeydown="return blockEnter(event);"
                             value="#{resultadosParaclinicosUsuarioBean.resultado.hrpnptt}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itPtt" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itPlaquetas" required="false" style="width:50px" maxlength="6"
                             onkeydown="return blockEnter(event);"
                             value="#{resultadosParaclinicosUsuarioBean.resultado.hrpnplaquetas}"/>
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
                <h:inputTextarea id="itParcialOrina" required="false" onkeydown="return blockEnter(event);"
                                 style="width:600px"
                                 value="#{resultadosParaclinicosUsuarioBean.resultado.hrpcparciorina}">
                        <f:validateLength maximum="200"/>
                            </h:inputTextarea>
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
                             onkeydown="return blockEnter(event);"
                             value="#{resultadosParaclinicosUsuarioBean.resultado.hrpnglicemipre}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itGlicemiaPre" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itGlicemiaPos" required="false" style="width:50px" maxlength="5"
                             onkeydown="return blockEnter(event);"
                             value="#{resultadosParaclinicosUsuarioBean.resultado.hrpnglicemipos}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itGlicemiaPos" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itNitrogeno" required="false" style="width:50px" maxlength="4"
                             onkeydown="return blockEnter(event);"
                             value="#{resultadosParaclinicosUsuarioBean.resultado.hrpnnitroureic}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itNitrogeno" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itCreatinina" required="false" style="width:50px" maxlength="4"
                             onkeydown="return blockEnter(event);"
                             value="#{resultadosParaclinicosUsuarioBean.resultado.hrpnncreatinin}"/>
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
                                 onkeydown="return blockEnter(event);"
                                 style="width:600px"
                                 value="#{resultadosParaclinicosUsuarioBean.resultado.hrpcelectrocar}">
                                 <f:validateLength maximum="500"/>
                                 </h:inputTextarea>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itElectrocardiograma"
                             styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Rayos X de Tórax"
                             />
              <h:panelGroup>
                <h:inputTextarea id="itRayosXTorax" required="false" onkeydown="return blockEnter(event);"
                                 style="width:600px"
                                 value="#{resultadosParaclinicosUsuarioBean.resultado.hrpcrayosxtora}">
                                 <f:validateLength maximum="200"/>
               </h:inputTextarea>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itRayosXTorax" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Ecografías"  />
              <h:panelGroup>
                <h:inputTextarea id="itEcografías" required="false" onkeydown="return blockEnter(event);"
                                 style="width:600px"
                                 value="#{resultadosParaclinicosUsuarioBean.resultado.hrpcecografias}">
                              <f:validateLength maximum="500"/>   
                        </h:inputTextarea>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itEcografías" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Otros resultados de laboratorio"
                             />
              <h:panelGroup>
                <h:inputTextarea id="itOtrosResultados" required="false" onkeydown="return blockEnter(event);"
                                 style="width:600px"
                                 value="#{resultadosParaclinicosUsuarioBean.resultado.hrpcotrosresul}">
                              <f:validateLength maximum="1000"/>
                            </h:inputTextarea>
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
                               action="#{resultadosParaclinicosUsuarioBean.aceptar}">
                   </h:commandButton>
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

    <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>