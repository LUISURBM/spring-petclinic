<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridImpresionDiagnosticaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneImpresionDiagnostica" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     selectedIndex="#{impresionDiagnosticaUsuarioBean.selectedIndex}"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabImpresionDiagnostica" label="Impresión Diagnostica"
                disabled="#{impresionDiagnosticaUsuarioBean.mostrarCie10}">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="panelGridImpresionDiagnostica">
        <s:fieldset legend="Tipo Diagnostico" id="fieldImpresionDiagnostica" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelDatosImpresionDiagnostica" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Tipo Diagnostico " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:panelGroup>
              <h:selectOneMenu id="tipoDiagnostico" onkeydown="return blockEnter(event);"
                               binding="#{impresionDiagnosticaUsuarioBean.mnuTipoDiagnostico}"
                               value="#{impresionDiagnosticaUsuarioBean.impresion.hidntipodiagn}">
                <f:selectItems value="#{impresionDiagnosticaUsuarioBean.lstTipoImpresion}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="tipoDiagnostico" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Diagnosticos Relacionados" id="fieldDiagnosticos" styleClass="fieldset">
          <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelDatosImpresionDiagnostica2" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Diagnostico Principal" styleClass="labelTextOblig"/>
            <h:panelGroup id="panelTextSemanas">
              <h:outputText value="Edad gestacional concepcional" styleClass="labelTextOblig"
                            rendered="#{impresionDiagnosticaUsuarioBean.renderSemanas && impresionDiagnosticaUsuarioBean.renderHistoriaIlve}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextConfirmaSemanas">
              <h:outputText value="Confirma Semanas" styleClass="labelTextOblig"
                            rendered="#{impresionDiagnosticaUsuarioBean.renderSemanas && impresionDiagnosticaUsuarioBean.renderHistoriaIlve}"/>
            </h:panelGroup>
            <h:panelGroup id = "panelTextNumeroSemanas">
                <h:outputText value = "Semanas de Embarazo" styleClass="labelTextOblig" 
                        rendered="#{impresionDiagnosticaUsuarioBean.renderSemanas  && impresionDiagnosticaUsuarioBean.renderConfirmacion && impresionDiagnosticaUsuarioBean.renderHistoriaIlve}"/>
            </h:panelGroup>
            <h:panelGroup id = "panelTextConfirmaPor">
            <h:outputText value= "Confirma por" styleClass="labelTextOblig" 
            rendered="#{impresionDiagnosticaUsuarioBean.renderSemanas  && impresionDiagnosticaUsuarioBean.renderConfirmacion && impresionDiagnosticaUsuarioBean.renderHistoriaIlve}"/>
            </h:panelGroup>
            
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink action="#{impresionDiagnosticaUsuarioBean.mostrarDiagnosticoPrincipal}"
                               reRender="panelGridImpresionDiagnosticaTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputText id="itDiagPrin" onkeydown="return blockEnter(event);" styleClass="textmayuscula"
                           value="#{impresionDiagnosticaUsuarioBean.impresion.hidcdiagprin}"
                           disabled="#{impresionDiagnosticaUsuarioBean.desHabilitarDiagnosticoPrincipal}"
                           valueChangeListener="#{impresionDiagnosticaUsuarioBean.setHidcdiagprin}" 
                           style="width:50px"
                           maxlength="4" immediate="true"
                           binding="#{impresionDiagnosticaUsuarioBean.inputDiagPrincipal}">
                <f:converter converterId="cadena.stringUpperCaseConverter"/>
                <a4j:support id="supportitDiagPrin" event="onchange" ignoreDupResponses="true"
                             action="#{impresionDiagnosticaUsuarioBean.changeDiagnosticoPrincipal}"
                             reRender="panelDiagnosticoPrincipal,panelTextSemanas,panelInputSemanas,panelTextNumeroSemanas,panelTextConfirmaPor,panelMenuMotivoConfirma,panelTextConfirmaSemanas,panelInputSemanas,panelConfirmaEmbarazo,panelSemanasEmbarazo">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:inputText>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoPrincipal">
                <h:outputText value=" #{impresionDiagnosticaUsuarioBean.diagnosticoPrincipal}" styleClass="buscador"/>
              </h:panelGrid>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDiagPrin" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
            <h:panelGroup id="panelInputSemanas">
              <h:outputText value="±" rendered="#{impresionDiagnosticaUsuarioBean.renderSemanas && impresionDiagnosticaUsuarioBean.renderHistoriaIlve}"/>
              <h:inputText id="itEdadGestacional" style="width:30px" maxlength="2" disabled="true"
                           rendered="#{impresionDiagnosticaUsuarioBean.renderSemanas && impresionDiagnosticaUsuarioBean.renderHistoriaIlve}"
                           value="#{impresionDiagnosticaUsuarioBean.impresion.hidnsemanameno}">
                <f:validator validatorId="validateSemanaEmbarazo"/>
              </h:inputText>
              <a4j:outputPanel ajaxRendered="true"  rendered="#{impresionDiagnosticaUsuarioBean.renderSemanas && impresionDiagnosticaUsuarioBean.renderHistoriaIlve}">
                <t:message for="itEdadGestacional" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id = "panelConfirmaEmbarazo">
            <h:selectOneRadio id = "mnuConfirmaEmbarazo"  immediate="true"
                    rendered="#{impresionDiagnosticaUsuarioBean.renderSemanas && impresionDiagnosticaUsuarioBean.renderHistoriaIlve}"
                    value = "#{impresionDiagnosticaUsuarioBean.impresion.hidcconfiseman}"
                    valueChangeListener="#{impresionDiagnosticaUsuarioBean.setHidcconfiseman}">
                <f:selectItems value = "#{impresionDiagnosticaUsuarioBean.lstOpciones}"/>
                <a4j:support id="supportitConfirmarEmbarazo" event="onclick" 
                             ignoreDupResponses="true" immediate="true"
                             action="#{impresionDiagnosticaUsuarioBean.changeConfirmacion}"
                             reRender="panelTextNumeroSemanas,panelSemanasEmbarazo,panelTextConfirmaPor,panelMenuMotivoConfirma">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
            </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true"  rendered="#{impresionDiagnosticaUsuarioBean.renderSemanas} && impresionDiagnosticaUsuarioBean.renderHistoriaIlve">
                <t:message for="mnuConfirmaEmbarazo" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id = "panelSemanasEmbarazo">
                <h:inputText id="itSemanasEmbarazo" style="width:50px"  maxlength="4"
                        rendered="#{impresionDiagnosticaUsuarioBean.renderSemanas && impresionDiagnosticaUsuarioBean.renderConfirmacion && impresionDiagnosticaUsuarioBean.renderHistoriaIlve}"
                        value ="#{impresionDiagnosticaUsuarioBean.impresion.hidnsemanembar}"/>
                        
            <a4j:outputPanel ajaxRendered="true"  rendered="#{impresionDiagnosticaUsuarioBean.renderSemanas  && impresionDiagnosticaUsuarioBean.renderConfirmacion && impresionDiagnosticaUsuarioBean.renderHistoriaIlve}">
                <t:message for="itSemanasEmbarazo" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id = "panelMenuMotivoConfirma">
            <h:selectOneMenu id = "mnuMotivoConfirma" 
             rendered="#{impresionDiagnosticaUsuarioBean.renderSemanas  && impresionDiagnosticaUsuarioBean.renderConfirmacion && impresionDiagnosticaUsuarioBean.renderHistoriaIlve}"
                value = "#{impresionDiagnosticaUsuarioBean.impresion.hidcmotivconfi}">
                <f:selectItems value = "#{impresionDiagnosticaUsuarioBean.lstConfirmaPor}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true" rendered="#{impresionDiagnosticaUsuarioBean.renderSemanas  && impresionDiagnosticaUsuarioBean.renderConfirmacion && impresionDiagnosticaUsuarioBean.renderHistoriaIlve}" >
                <t:message for="mnuMotivoConfirma" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="Diagnostico Relacionado Uno (1) "/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink action="#{impresionDiagnosticaUsuarioBean.mostrarDiagnosticoRelacionado1}"
                               reRender="panelGridImpresionDiagnosticaTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputText id="itDiagnosticoRelacionado1" onkeydown="return blockEnter(event);"
                           styleClass="textmayuscula" value="#{impresionDiagnosticaUsuarioBean.impresion.hidcdiagrela1}"
                           valueChangeListener="#{impresionDiagnosticaUsuarioBean.setHidcdiagrela1}" style="width:50px"
                           maxlength="4" immediate="true"
                           disabled="#{impresionDiagnosticaUsuarioBean.disableRel1}"
                           binding="#{impresionDiagnosticaUsuarioBean.inputDiagRelacionado1}">
                             <f:converter converterId="cadena.stringUpperCaseConverter"/>
                <a4j:support id="supportDiagnosticoRelacionado1" event="onchange"
                             action="#{impresionDiagnosticaUsuarioBean.changeDiagnosticoRelacionado1}"
                             reRender="panelDiagnosticoRelacionado1">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                  <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDiagnosticoRelacionado1" styleClass="errorMessage"/>
              </a4j:outputPanel>
              </h:inputText>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoRelacionado1">
                <h:outputText value="#{impresionDiagnosticaUsuarioBean.diagnosticoRelacionado1}" styleClass="buscador"/>
              </h:panelGrid>
            </h:panelGrid>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:panelGroup>
            <h:outputText value="Diagnostico Relacionado Dos (2) "  styleClass ="labelTextOblig"
            rendered="#{impresionDiagnosticaUsuarioBean.requiredRel2}"/>
            
           <h:outputText value="Diagnostico Relacionado Dos (2) " 
            rendered="#{!impresionDiagnosticaUsuarioBean.requiredRel2}"/>
            
            </h:panelGroup>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:panelGrid id="panelGroupDiagnostico" columns="4" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink action="#{impresionDiagnosticaUsuarioBean.mostrarDiagnosticoRelacionado2}"
                               reRender="panelGridImpresionDiagnosticaTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputText id="itDiagnosticoRelacionado2" styleClass="textmayuscula"
                           value="#{impresionDiagnosticaUsuarioBean.impresion.hidcdiagrela2}"
                           onkeydown="return blockEnter(event);"
                           valueChangeListener="#{impresionDiagnosticaUsuarioBean.setHidcdiagrela2}" style="width:50px"
                           maxlength="4" immediate="true"
                           required="#{impresionDiagnosticaUsuarioBean.requiredRel2}"
                           binding="#{impresionDiagnosticaUsuarioBean.inputDiagRelacionado2}">
                             <f:converter converterId="cadena.stringUpperCaseConverter"/>
                <a4j:support id="supportDiagnosticoRelacionado2" event="onchange"
                             action="#{impresionDiagnosticaUsuarioBean.changeDiagnosticoRelacionado2}"
                             reRender="panelDiagnosticoRelacionado2">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                 
                
              </h:inputText>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoRelacionado2">
                <h:outputText value="  #{impresionDiagnosticaUsuarioBean.diagnosticoRelacionado2}"
                              styleClass="buscador"/>
              </h:panelGrid>
              
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDiagnosticoRelacionado2" styleClass="errorMessage"/>
              </a4j:outputPanel>
              
              
            </h:panelGrid>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText value="Diagnostico Relacionado Tres (3) "/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:panelGrid id="mnuDiagnosticoRelacionado3" columns="3" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink action="#{impresionDiagnosticaUsuarioBean.mostrarDiagnosticoRelacionado3}"
                               reRender="panelGridImpresionDiagnosticaTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputText id="itDiagnosticoRelacionado3" onkeydown="return blockEnter(event);"
                           styleClass="textmayuscula" value="#{impresionDiagnosticaUsuarioBean.impresion.hidcdiagrela3}"
                           valueChangeListener="#{impresionDiagnosticaUsuarioBean.setHidcdiagrela3}" style="width:50px"
                           maxlength="4" immediate="true"
                           binding="#{impresionDiagnosticaUsuarioBean.inputDiagRelacionado3}">
                             <f:converter converterId="cadena.stringUpperCaseConverter"/>
                <a4j:support id="supportDiagnosticoRelacionado3" event="onchange"
                             action="#{impresionDiagnosticaUsuarioBean.changeDiagnosticoRelacionado3}"
                             reRender="panelDiagnosticoRelacionado3">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                  <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDiagnosticoRelacionado3" styleClass="errorMessage"/>
              </a4j:outputPanel>
              </h:inputText>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoRelacionado3">
                <h:outputText value="  #{impresionDiagnosticaUsuarioBean.diagnosticoRelacionado3}"
                              styleClass="buscador"/>
              </h:panelGrid>
            </h:panelGrid>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Observaciones" id="fieldRecomendacion" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelDatosRecomendaciones" rowClasses="labelText">
            <h:outputText value="Observaciones"/>
            <h:panelGroup>
              <h:inputTextarea id="textRecomendaciones" onkeydown="return blockEnter(event);"
                               value="#{impresionDiagnosticaUsuarioBean.impresion.hidtrecomen}" style="width:600px"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textRecomendaciones" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Estado Fisico ASA" id="fieldExamenFisicoASA"
                    rendered="#{impresionDiagnosticaUsuarioBean.mostrarAsa}" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelDatosExamenFisicoASA" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Grado Examen ASA" styleClass="labelTextOblig"/>
            <h:outputText value="Urgencia"/>
            <h:panelGroup>
              <h:selectOneRadio id="mnuGradoAsa" onkeydown="return blockEnter(event);"
                                value="#{impresionDiagnosticaUsuarioBean.impresion.hidngradoasa}">
                <f:selectItems value="#{impresionDiagnosticaUsuarioBean.lstGradoASA}"/>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuGradoAsa" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:selectBooleanCheckbox id="checkUrgente" onkeydown="return blockEnter(event);"
                                       value="#{impresionDiagnosticaUsuarioBean.esurgencia}"/>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMensajesImpresionDiagnostica" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelBotonBotonesImpresionDiagnostica" columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Aceptar" styleClass="btn btn btn-success"
                             action="#{impresionDiagnosticaUsuarioBean.guardarImpresion}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
    <t:panelTab id="panelBuscador" label="Buscar Diagnosticos"
                rendered="#{impresionDiagnosticaUsuarioBean.mostrarCie10}">
      <a4j:region id="regionCie10" renderRegionOnly="false">
        <a4j:status id="statusButton" for="regionCie10">
          <f:facet name="start">
            <t:div id="chargingCie10" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <jsp:include page="/pages/clinico/registro/buscadorCie10.jsp" flush="true"/>
        <h:panelGrid id="panelGridCie10Botones" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
          <t:htmlTag value="br"/>
          <h:panelGroup id="panelGroupCie10Botones1">
            <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success"
                               action="#{impresionDiagnosticaUsuarioBean.aceptarDiagnostico}"
                               reRender="panelGridImpresionDiagnosticaTab">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </a4j:region>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>