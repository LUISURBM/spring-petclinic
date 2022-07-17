<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="registrarExamenesClinicosForm">
  <a4j:region id="bodyRegionRegistrarExamenesClinicos">
    <a4j:status id="statusButton" for="bodyRegionRegistrarExamenesClinicos">
      <f:facet name="start">
        <t:div id="chargindRegistrarExamenesClinicos" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneExamenesClinicos" styleClass="tabbedPane"
                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabRegistrarExamenClinico" label="Registrar Examenes Clinicos">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableContentTabsRegistrarExamenesClinicos" styleClass="tabContainerRegistrarExamenesClinicos">
          <t:htmlTag value="br"/>
          <s:fieldset legend="Registrar Apoyo Diagnostico" id="fieldExamenesClinicos" styleClass="fieldset">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelGridRegistrarExamenes" rowClasses="standardTable_Row2,standardTable_Row1">
            
         
           
         
              <h:panelGroup>
                <h:selectBooleanCheckbox id="checkResultadosLaboratorioClinico" onkeydown="return blockEnter(event);"
                                         value="#{registrarExamenesClinicosBean.renderLaboratorio}"
                                         valueChangeListener="#{registrarExamenesClinicosBean.setRenderLaboratorio}"
                                         immediate="true">
                  <a4j:support id="supportLaboratorioClinico" event="onclick" immediate="true"
                               reRender="panelOutputLaboratorio,panelInputLaboratorio">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectBooleanCheckbox>
                <h:outputText value="Laboratorio Clinico  "/>
                <a4j:region renderRegionOnly="false"></a4j:region>
              </h:panelGroup>
              <h:panelGroup id="panelOutputLaboratorio">
                <h:outputText value="Descripción " styleClass="labelTextOblig"
                              rendered="#{registrarExamenesClinicosBean.renderLaboratorio}"/>
              </h:panelGroup>
              <h:outputText/>
              <h:panelGroup id="panelInputLaboratorio">
                <h:inputTextarea id="mnuCualLaboratorio" style="width:300px" onkeydown="return blockEnter(event);"
                             required="#{registrarExamenesClinicosBean.renderLaboratorio}"
                             value="#{registrarExamenesClinicosBean.examen.hreclaborclini}"
                             rendered="#{registrarExamenesClinicosBean.renderLaboratorio}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuCualLaboratorio" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectBooleanCheckbox id="checkResultadosImagenesDiagnosticas" onkeydown="return blockEnter(event);"
                                         value="#{registrarExamenesClinicosBean.renderImagenes}"
                                         valueChangeListener="#{registrarExamenesClinicosBean.setRenderImagenes}"
                                         immediate="true">
                  <a4j:support id="supportImagenes" event="onclick" immediate="true"
                               reRender="panelOutputImagenes,panelInputImagenes">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectBooleanCheckbox>
                <h:outputText value="Imagenes Diagnosticas  "/>
                <a4j:region renderRegionOnly="false"></a4j:region>
              </h:panelGroup>
              <h:panelGroup id="panelOutputImagenes">
                <h:outputText value="Descripción " styleClass="labelTextOblig"
                              rendered="#{registrarExamenesClinicosBean.renderImagenes}"/>
              </h:panelGroup>
              <h:outputText/>
              <h:panelGroup id="panelInputImagenes">
                <h:inputTextarea id="mnuCualImagen" style="width:300px" onkeydown="return blockEnter(event);"
                             required="#{registrarExamenesClinicosBean.renderImagenes}"
                             value="#{registrarExamenesClinicosBean.examen.hrecimagediagn}"
                             rendered="#{registrarExamenesClinicosBean.renderImagenes}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuCualImagen" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectBooleanCheckbox id="checkResultadosEstudioPatologia" onkeydown="return blockEnter(event);"
                                         value="#{registrarExamenesClinicosBean.renderEstudio}"
                                         valueChangeListener="#{registrarExamenesClinicosBean.setRenderEstudio}"
                                         immediate="true">
                  <a4j:support id="supportEstudio" event="onclick" immediate="true"
                               reRender="panelOutputEstudio,panelInputEstudio">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectBooleanCheckbox>
                <h:outputText value="Estudio de Patologia  "/>
                <a4j:region renderRegionOnly="false"></a4j:region>
              </h:panelGroup>
              <h:panelGroup id="panelOutputEstudio">
                <h:outputText value="Descripción " styleClass="labelTextOblig"
                              rendered="#{registrarExamenesClinicosBean.renderEstudio}"/>
              </h:panelGroup>
              <h:outputText/>
              <h:panelGroup id="panelInputEstudio">
                <h:inputTextarea id="mnuCualEstudio" style="width:300px" onkeydown="return blockEnter(event);"
                             required="#{registrarExamenesClinicosBean.renderEstudio}"
                             value="#{registrarExamenesClinicosBean.examen.hrecestudpatol}"
                             rendered="#{registrarExamenesClinicosBean.renderEstudio}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuCualEstudio" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectBooleanCheckbox id="checkResultadosPruebaEmbarazo" onkeydown="return blockEnter(event);"
                                         value="#{registrarExamenesClinicosBean.renderPruebaEmbarazo}"
                                         valueChangeListener="#{registrarExamenesClinicosBean.setRenderPruebaEmbarazo}"
                                         immediate="true">
                  <a4j:support id="supportPruebaEmbarazo" event="onclick" immediate="true"
                               reRender="panelOutputPrueba,panelInputPrueba">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectBooleanCheckbox>
                <h:outputText value="Prueba de Embarazo  "/>
                <a4j:region renderRegionOnly="false"></a4j:region>
              </h:panelGroup>
              <h:panelGroup id="panelOutputPrueba">
                <h:outputText value="Descripción " styleClass="labelTextOblig"
                              rendered="#{registrarExamenesClinicosBean.renderPruebaEmbarazo}"/>
              </h:panelGroup>
              <h:outputText/>
              <h:panelGroup id="panelInputPrueba">
                <h:inputTextarea id="mnuCualPrueba" style="width:300px" onkeydown="return blockEnter(event);"
                             required="#{registrarExamenesClinicosBean.renderPruebaEmbarazo}"
                             value="#{registrarExamenesClinicosBean.examen.hrecpruebembar}"
                             rendered="#{registrarExamenesClinicosBean.renderPruebaEmbarazo}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuCualPrueba" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectBooleanCheckbox id="checkResultadosCitologia" onkeydown="return blockEnter(event);"
                                         value="#{registrarExamenesClinicosBean.renderCitologia}"
                                         valueChangeListener="#{registrarExamenesClinicosBean.setRenderCitologia}"
                                         immediate="true">
                  <a4j:support id="supportCitologia" event="onclick" immediate="true"
                               reRender="panelOutputCitologia,panelInputCitologia">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectBooleanCheckbox>
                <h:outputText value="Citologia "/>
                <a4j:region renderRegionOnly="false"></a4j:region>
              </h:panelGroup>
              <h:panelGroup id="panelOutputCitologia">
                <h:outputText value="Descripción " styleClass="labelTextOblig"
                              rendered="#{registrarExamenesClinicosBean.renderCitologia}"/>
              </h:panelGroup>
              <h:outputText/>
              <h:panelGroup id="panelInputCitologia">
                <h:inputTextarea id="mnuCualCitologia" style="width:300px" onkeydown="return blockEnter(event);"
                             required="#{registrarExamenesClinicosBean.renderCitologia}"
                             value="#{registrarExamenesClinicosBean.examen.hreccitologia}"
                             rendered="#{registrarExamenesClinicosBean.renderCitologia}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuCualCitologia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectBooleanCheckbox id="checkResultadosColposcopia" onkeydown="return blockEnter(event);"
                                         value="#{registrarExamenesClinicosBean.renderColposcopia}"
                                         valueChangeListener="#{registrarExamenesClinicosBean.setRenderColposcopia}"
                                         immediate="true">
                  <a4j:support id="supportColposcopia" event="onclick" immediate="true"
                               reRender="panelOutputColposcopia,panelInputColposcopia">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectBooleanCheckbox>
                <h:outputText value="Colposcopia  "/>
                <a4j:region renderRegionOnly="false"></a4j:region>
              </h:panelGroup>
              <h:panelGroup id="panelOutputColposcopia">
                <h:outputText value="Descripción " styleClass="labelTextOblig"
                              rendered="#{registrarExamenesClinicosBean.renderColposcopia}"/>
              </h:panelGroup>
              <h:outputText/>
              <h:panelGroup id="panelInputColposcopia">
                <h:inputTextarea id="mnuCualColposcopia" style="width:300px" onkeydown="return blockEnter(event);"
                             required="#{registrarExamenesClinicosBean.renderColposcopia}"
                             value="#{registrarExamenesClinicosBean.examen.hreccolposcopi}"
                             rendered="#{registrarExamenesClinicosBean.renderColposcopia}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuCualColposcopia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectBooleanCheckbox id="checkResultadosOtros" onkeydown="return blockEnter(event);"
                                         value="#{registrarExamenesClinicosBean.renderOtro}"
                                         valueChangeListener="#{registrarExamenesClinicosBean.setRenderOtro}"
                                         immediate="true">
                  <a4j:support id="supportOtro" event="onclick" immediate="true"
                               reRender="panelOutputOtro,panelInputOtro">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectBooleanCheckbox>
                <h:outputText value="Otros Examenes "/>
                <a4j:region renderRegionOnly="false"></a4j:region>
              </h:panelGroup>
              <h:panelGroup id="panelOutputOtro">
                <h:outputText value="Descripción " styleClass="labelTextOblig"
                              rendered="#{registrarExamenesClinicosBean.renderOtro}"/>
              </h:panelGroup>
              <h:outputText/>
              <h:panelGroup id="panelInputOtro">
               <h:inputTextarea id="mnuCualOtro" style="width:300px" onkeydown="return blockEnter(event);"
                             required="#{registrarExamenesClinicosBean.renderOtro}"
                             value="#{registrarExamenesClinicosBean.examen.hreccualexame}"
                             rendered="#{registrarExamenesClinicosBean.renderOtro}">
                           <f:validateLength maximum="500"/>  
                             </h:inputTextarea>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuCualOtro" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </s:fieldset>
        </h:panelGrid>
      </t:panelTab>
    </t:panelTabbedPane>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="panelBotonRegistrarExamenesClinicos" columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Guardar" styleClass="boton_fieldset"
                         onclick="if (!confirm(\'¿Realmente desea Registrar los examenes \')) return false"
                         action="#{registrarExamenesClinicosBean.aceptar}">
          <a4j:support event="onclick" status="statusButton"/>
        </h:commandButton>
      </h:panelGroup>
    </h:panelGrid>
    <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionRegistrarExamenesClinicos" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationExamenesClinicos" showSummary="true" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
    
     <h:panelGrid>
                <h:commandLink action="#{registrarExamenesClinicosBean.volver}" immediate="true">
                   <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                </h:commandLink>
            </h:panelGrid>
  </a4j:region>
</a4j:form>