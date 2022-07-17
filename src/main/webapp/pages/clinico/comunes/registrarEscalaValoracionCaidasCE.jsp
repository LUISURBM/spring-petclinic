<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEscalaValoracionTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEscalaValoracionCETab"
               styleClass="tabContainer">
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEscalaValoracionCE2Tab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneAldrete" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabAldret" label="Escala Valoraci�n Ca�das">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsAldrete"
                       styleClass="tabContainer">
            <s:fieldset legend="Datos Escala Valoraci�n Ca�das" id="fieldAldrete" styleClass="fieldset">
              <s:fieldset legend="" id="fieldAreaEscalaG1" styleClass="fieldset">
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="1000px"
                             id="panelAreaEscalaG1" rowClasses="labelText,labelTextInfo">
                  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="500px"
                               id="panelCaidasPrevias" rowClasses="standardTable_Row4,standardTable_Row4"
                               style="border-color:#3f3e23;">
                    <h:outputText value="Ca�das previas" styleClass="labelTextOblig"/>
                    <h:panelGroup>
                      <a4j:region renderRegionOnly="false">
                        <h:selectOneRadio style="border-style:none;" immediate="true"
                                              id="mnuAreaCaidasPrevias"
                                              value="#{registrarEscalaValoracionCaidasCEBean.chescvalcai.hevccaidprev}"
                                              valueChangeListener="#{registrarEscalaValoracionCaidasCEBean.setHevccaidprev}"
                                              layout="pageDirection">
                          <f:selectItems value="#{registrarEscalaValoracionCaidasCEBean.lstCaidasPrevias}"/>
                          <a4j:support id="supportmnuAreaCaidasPrevias" event="onclick" immediate="true"
                                       action="#{registrarEscalaValoracionCaidasCEBean.calcularEscalaValoracionCaidas}"
                                       reRender="panelPuntos">
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                          </a4j:support>
                        </h:selectOneRadio>
                        <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuAreaCaidasPrevias" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                      </a4j:region>
                    </h:panelGroup>
                  </h:panelGrid>
                  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="500px"
                               id="panelAreaEstadoMental" rowClasses="standardTable_Row3,standardTable_Row3"
                               style="border-colo:#3f3e23;">
                    <h:outputText value="Estado Mental" styleClass="labelTextOblig"/>
                    <h:panelGroup>
                      <a4j:region renderRegionOnly="false">
                        <h:selectOneRadio required="true" style="border-style:none;" immediate="true"
                                              id="mnuAreaEstadoMental"
                                              value="#{registrarEscalaValoracionCaidasCEBean.chescvalcai.hevccestament}"
                                              valueChangeListener="#{registrarEscalaValoracionCaidasCEBean.setHevccestament}"
                                              layout="pageDirection">
                          <f:selectItems value="#{registrarEscalaValoracionCaidasCEBean.lstEstadoMental}"/>
                          <a4j:support id="supportmnuAreaEstadoMental" event="onclick" immediate="true"
                                       action="#{registrarEscalaValoracionCaidasCEBean.calcularEscalaValoracionCaidas}"
                                       reRender="panelPuntos">
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                          </a4j:support>
                        </h:selectOneRadio>
                        <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuAreaEstadoMental" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                      </a4j:region>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGrid>
              </s:fieldset>
              <s:fieldset legend="" id="fieldAreaEscalaG2" styleClass="fieldset">
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="1000px"
                             id="panelAreaEscalaG2" rowClasses="labelText,labelTextInfo">
                  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="500px"
                               id="panelAreaDeficitSensorial" rowClasses="standardTable_Row3,standardTable_Row3"
                               style="border-colo:#3f3e23;">
                    <h:outputText value="D�ficit Sensorial" styleClass="labelTextOblig"/>
                    <h:panelGroup>
                      <a4j:region renderRegionOnly="false">
                        <h:selectManyCheckbox required="true" style="border-style:none;" immediate="true"
                                              id="mnuAreaDeficitSensorial"
                                              value="#{registrarEscalaValoracionCaidasCEBean.lstDeficitSensorialSelect}"
                                              valueChangeListener="#{registrarEscalaValoracionCaidasCEBean.setDeficitSensorialSelect}"
                                              layout="pageDirection">
                          <f:selectItems value="#{registrarEscalaValoracionCaidasCEBean.lstDeficitSensorial}"/>
                          <a4j:support id="supportmnuAreaDeficitSensorial" event="onclick" immediate="true"
                                       action="#{registrarEscalaValoracionCaidasCEBean.calcularEscalaValoracionCaidas}"
                                       reRender="panelPuntos">
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                          </a4j:support>
                        </h:selectManyCheckbox>
                        <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuAreaDeficitSensorial" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                      </a4j:region>
                    </h:panelGroup>
                  </h:panelGrid>
                  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="500px"
                               id="panelDeambulacion" rowClasses="standardTable_Row4,standardTable_Row4"
                               style="border-color:#3f3e23;">
                    <h:outputText value="Deambulaci�n" styleClass="labelTextOblig"/>
                    <h:panelGroup>
                      <a4j:region renderRegionOnly="false">
                        <h:selectManyCheckbox required="true" style="border-style:none;" immediate="true"
                                              id="mnuAreaDeambulacion"
                                              value="#{registrarEscalaValoracionCaidasCEBean.lstDeambulacionSelect}"
                                              valueChangeListener="#{registrarEscalaValoracionCaidasCEBean.setDeambulacionSelect}"
                                              layout="pageDirection">
                          <f:selectItems value="#{registrarEscalaValoracionCaidasCEBean.lstDeambulacion}"/>
                          <a4j:support id="supportmnuAreaDeambulacion" event="onclick" immediate="true"
                                       action="#{registrarEscalaValoracionCaidasCEBean.calcularEscalaValoracionCaidas}"
                                       reRender="panelPuntos">
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                          </a4j:support>
                        </h:selectManyCheckbox>
                        <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuAreaDeambulacion" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                      </a4j:region>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGrid>
              </s:fieldset>
              <s:fieldset legend="" id="fieldAreaEscalaG3" styleClass="fieldset">
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="1000px"
                             id="panelAreaEscalaG3" rowClasses="labelText,labelTextInfo">
                  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="500px"
                               id="panelMedicamentos" rowClasses="standardTable_Row4,standardTable_Row4"
                               style="border-color:#3f3e23;">
                    <h:outputText value="Medicamentos" styleClass="labelTextOblig"/>
                    <h:panelGroup>
                      <a4j:region renderRegionOnly="false">
                        <h:selectManyCheckbox required="true" style="border-style:none;" immediate="true"
                                              id="mnuAreaMedicamentos"
                                              value="#{registrarEscalaValoracionCaidasCEBean.lstMedicamentosSelect}"
                                              valueChangeListener="#{registrarEscalaValoracionCaidasCEBean.setMedicamentosSelect}"
                                              layout="pageDirection">
                          <f:selectItems value="#{registrarEscalaValoracionCaidasCEBean.lstMedicamentos}"/>
                          <a4j:support id="supportmnuAreaMedicamentos" event="onclick" immediate="true"
                                       action="#{registrarEscalaValoracionCaidasCEBean.calcularEscalaValoracionCaidas}"
                                       reRender="panelPuntos">
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                          </a4j:support>
                        </h:selectManyCheckbox>
                        <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuAreaMedicamentos" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                      </a4j:region>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGrid>
              </s:fieldset>
              <h:panelGrid style="text-align:left" columns="1" id="panelPuntos" border="0" cellpadding="0"
                           cellspacing="0" width="90%">
                <h:outputText value=" "/>
                <h:panelGroup>
                  <h:outputText value="#{registrarEscalaValoracionCaidasCEBean.msgPuntos}"
                                styleClass="labelTextBlueUnderLine"/>
                </h:panelGroup>
                <h:outputText value=" "/>
                 <h:panelGroup>
                  <h:outputText value="#{registrarEscalaValoracionCaidasCEBean.msgRiesgo}"
                                styleClass="labelTextBlueUnderLine"/>
                </h:panelGroup>
                
                 <h:outputText value=" "/>
                 <h:panelGroup>
                  <h:outputText value="#{registrarEscalaValoracionCaidasCEBean.msgRiesgo1}"
                                styleClass="labelTextBlueUnderLine"/>
                </h:panelGroup>
                
                 <h:outputText value=" "/>
                 <h:panelGroup>
                  <h:outputText value="#{registrarEscalaValoracionCaidasCEBean.msgRiesgo2}"
                                styleClass="labelTextBlueUnderLine"/>
                </h:panelGroup>
                
                 <h:outputText value=" "/>
                 <h:panelGroup>
                  <h:outputText value="#{registrarEscalaValoracionCaidasCEBean.msgRiesgo3}"
                                styleClass="labelTextBlueUnderLine"/>
                </h:panelGroup>
                
                 <h:outputText value=" "/>
                 <h:panelGroup>
                  <h:outputText value="#{registrarEscalaValoracionCaidasCEBean.msgRiesgo4}"
                                styleClass="labelTextBlueUnderLine"/>
                </h:panelGroup>
                
                 <h:outputText value=" "/>
                 <h:panelGroup>
                  <h:outputText value="#{registrarEscalaValoracionCaidasCEBean.msgRiesgo5}"
                                styleClass="labelTextBlueUnderLine"/>
                </h:panelGroup>
                
                 <h:outputText value=" "/>
                 <h:panelGroup>
                  <h:outputText value="#{registrarEscalaValoracionCaidasCEBean.msgRiesgo6}"
                                styleClass="labelTextBlueUnderLine"/>
                </h:panelGroup>
                
                <h:outputText value=" "/>
                 <h:panelGroup>
                  <h:outputText value="#{registrarEscalaValoracionCaidasCEBean.msgRiesgo7}"
                                styleClass="labelTextBlueUnderLine"/>
                </h:panelGroup>
                
              </h:panelGrid>
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonEscala"
                           columnClasses="panelGridBotones">
                <h:panelGroup>
                  <h:commandButton value="Agregar Seguimiento" styleClass="btn btn btn-success"
                                   action="#{registrarEscalaValoracionCaidasCEBean.agregarEscala}">
                    <a4j:support event="onclick" status="statusButton" reRender="fieldListaEscValCai"/>
                  </h:commandButton>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Seguimiento Escala Valoraci�n Ca�das" id="fieldListaEscValCai" styleClass="fieldset">
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="tableListaEscValCai" styleClass="tabContainer">
                    <a4j:region renderRegionOnly="false">
                      <h:dataTable var="item" border="0" cellpadding="0" cellspacing="4"
                                   value="#{registrarEscalaValoracionCaidasCEBean.listaEscalaValoracionCaida}" rows="15"
                                   styleClass="standard_table"
                                   binding="#{registrarEscalaValoracionCaidasCEBean.dtSeguimiento}"
                                   rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                                   rendered="#{not empty registrarEscalaValoracionCaidasCEBean.listaEscalaValoracionCaida}"
                                   id="dtEscala">
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Caidas Previas"/>
                          </f:facet>
                          <h:outputText value="#{item.caidasPrevias}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Medicamentos"/>
                          </f:facet>
                          <h:outputText value="#{item.medicamentos}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="D�ficit sensorial"/>
                          </f:facet>
                          <h:outputText value="#{item.deficitSensorial}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Estado Mental"/>
                          </f:facet>
                          <h:outputText value="#{item.estadoMental}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Deambulaci�n"/>
                          </f:facet>
                          <h:outputText value="#{item.deambulacion}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Puntos"/>
                          </f:facet>
                          <h:outputText value="#{item.hevccpuntos}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Eliminar"/>
                          </f:facet>
                          <a4j:commandLink id="eliminarEscala"
                                           action="#{registrarEscalaValoracionCaidasCEBean.eliminarEscala}"
                                           rendered="#{item.editable}"
                                           onclick="if (!confirm(\'�Esta seguro de Eliminar? \')) return false"
                                           reRender="tableListaEscValCai">
                            <t:graphicImage id="imageEliminar" border="0" url="/comun/imagenes/eliminarObj.gif"
                                            alt="Eliminar"/>
                          </a4j:commandLink>
                        </h:column>
                      </h:dataTable>
                    </a4j:region>
                </h:panelGrid>
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonAldrete"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <a4j:commandButton value="Guardar" styleClass="btn btn btn-success" reRender="fieldListaEscValCai"
                                 action="#{registrarEscalaValoracionCaidasCEBean.aceptar}" >
                  <a4j:support event="onclick" status="statusButton" />
                </a4j:commandButton>
                </a4j:region>
              </h:panelGroup>
            </h:panelGrid>
            </s:fieldset>
          </h:panelGrid>
          <h:panelGrid>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionMessagesAldrete" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInformationAndErrorsAldrete" showSummary="true" errorClass="error" globalOnly="true"
                            layout="table" infoClass="informacion"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </h:panelGrid>
</h:panelGrid>