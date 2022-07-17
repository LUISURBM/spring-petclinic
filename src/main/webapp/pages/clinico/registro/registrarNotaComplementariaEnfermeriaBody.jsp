<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="registrarNotaAclaratoriaForm">
  <a4j:region id="bodyRegionRegistrarNotaAclaratoria">
    <a4j:status  id = "statusButton" for="bodyRegionRegistrarNotaAclaratoria">
      <f:facet name="start">
        <t:div id="chargindRegistrarNotaAclaratoria" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="tableContentTabsRegistrarNotaAclaratoria"
                     styleClass="tabContainerRegistrarNotaAclaratoria">
      <t:htmlTag value="br"/>
      <s:fieldset legend="Registro Complementario Enfermeria" id="fieldRegistrarNotaComplementaria"
                  styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelRegistrarNotaComplementaria"
                     rowClasses="labelText">
      
          <h:outputText value="Nota Complementaria" styleClass="labelTextOblig"/>
          <h:outputText/>
       
          
          <h:panelGroup>
            <h:inputTextarea id="textNotaComplementaria" required="true"
                             value="#{registrarNotaComplementariaEnfermeriaBean.notaMedica}"
                             style="width:500px;height:70px"/>
          
          </h:panelGroup>
          
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textNotaComplementaria" styleClass="errorMessage"/>
            </a4j:outputPanel>
        </h:panelGrid>
        
          <!-- COMIENZA REFERENCIA DEL PACIENTE -->
          <s:fieldset legend="Referencia del paciente" id="fieldReferencia" styleClass="fieldset">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelReferencia"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="¿Referencia paciente?" styleClass="labelTextOblig"/>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectOneRadio id="radioReferencia" required="true" immediate="true"
                                    onkeydown="return blockEnter(event);"
                                    value="#{registrarNotaComplementariaEnfermeriaBean.referenciaPaciente.hrpcrefepaci}"
                                    valueChangeListener="#{registrarNotaComplementariaEnfermeriaBean.setHrpcrefepaci}">
                    <f:selectItems value="#{registrarNotaComplementariaEnfermeriaBean.lstOpciones}"/>
                    <a4j:support id="supportRadioReferencia" event="onclick" reRender="fieldReferencia"
                                 action="#{registrarNotaComplementariaEnfermeriaBean.changeReferenciaPaciente}">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </h:panelGroup>
              </a4j:region>
            </h:panelGrid>
            <spacer height="80"/>
            <s:fieldset legend="Datos IPS Receptora" id="fieldIPSRecep" styleClass="fieldset" rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelIpsReceptora"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Institución Receptora" 
                              rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}"/>
                <h:panelGroup>
                  <a4j:region renderRegionOnly="false">
                    <h:inputTextarea id="menuInstRecep" style="width:250px"
                                     rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}" immediate="true"
                                     value="#{registrarNotaComplementariaEnfermeriaBean.referenciaPaciente.hrpcinstrece}">
                      <a4j:support event="onchange" status="statusButton"/>
                    </h:inputTextarea>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
                      <t:message for="menuInstRecep" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </a4j:region>
                </h:panelGroup>
                <h:outputText value="Hora de confirmacion de la remisión" styleClass="labelTextOblig"
                              rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}"/>
                <h:panelGroup>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuHoraConfirmRemi"
                                     value="#{registrarNotaComplementariaEnfermeriaBean.referenciaPaciente.hrpchoraconf}"
                                     styleClass="input-small"
                                     required="true"
                                     rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
                      <f:selectItems value="#{registrarNotaComplementariaEnfermeriaBean.listHora}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
                      <t:message for="mnuHoraConfirmRemi" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value=" : Horas " rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}"/>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuMinutosConfirmRemi"
                                     value="#{registrarNotaComplementariaEnfermeriaBean.referenciaPaciente.hrpcminuconf}"
                                     required="true" styleClass="dropdown-toggle, input-small"
                                     rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
                      <f:selectItems value="#{registrarNotaComplementariaEnfermeriaBean.lstMinutos}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
                      <t:message for="mnuMinutosConfirmRemi" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value=" Minutos" rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}"/>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            <spacer height="80"/>
            <s:fieldset legend="Datos Transporte Ambulatorio" id="fieldTranAmbu" styleClass="fieldset" rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelTranAmbu"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Prestador de ambulancia"
                              rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}"/>
                <h:panelGroup>
                  <a4j:region renderRegionOnly="false">
                    <h:inputTextarea id="menuPresAmbu" style="width:250px"
                                     rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}" immediate="true"
                                     value="#{registrarNotaComplementariaEnfermeriaBean.referenciaPaciente.hrpcpresambu}">
                      <a4j:support event="onchange" status="statusButton"/>
                    </h:inputTextarea>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
                      <t:message for="menuPresAmbu" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </a4j:region>
                </h:panelGroup>
                <h:outputText value="Tipo de Ambulancia" styleClass="labelTextOblig"
                              rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}"/>
                <h:panelGroup>
                  <h:selectOneMenu id="menuTipAmbu" immediate="true"
                                   rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}"
                                   value="#{registrarNotaComplementariaEnfermeriaBean.referenciaPaciente.hrpctipoambu}">
                    <f:selectItem itemLabel="Seleccione una opción ..." itemValue=""/>
                    <f:selectItem itemLabel="Básica" itemValue="BA"/>
                    <f:selectItem itemLabel="Medicalizada" itemValue="ME"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuTipAmbu" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Hora de llegada de la ambulancia a Profamilia" styleClass="labelTextOblig"
                              rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}"/>
                <h:panelGroup>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuHoraAmbuProfa"
                                     value="#{registrarNotaComplementariaEnfermeriaBean.referenciaPaciente.hrpchorallega}"
                                     styleClass="input-small"
                                     required="true"
                                     rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
                      <f:selectItems value="#{registrarNotaComplementariaEnfermeriaBean.listHora}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
                      <t:message for="mnuHoraAmbuProfa" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value=" : Horas " rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}"/>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuMinutosAmbuProfa"
                                     value="#{registrarNotaComplementariaEnfermeriaBean.referenciaPaciente.hrpcminullega}"
                                     required="true" styleClass="dropdown-toggle, input-small"
                                     rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
                      <f:selectItems value="#{registrarNotaComplementariaEnfermeriaBean.lstMinutos}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
                      <t:message for="mnuMinutosAmbuProfa" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value=" Minutos" rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}"/>
                </h:panelGroup>
                <h:outputText value="Tripulante de ambulancia que recibe el paciente"
                              rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}"/>
                <h:panelGroup>
                  <a4j:region renderRegionOnly="false">
                    <h:inputTextarea id="menuTripulante" style="width:250px"
                                     rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}" immediate="true"
                                     value="#{registrarNotaComplementariaEnfermeriaBean.referenciaPaciente.hrpctripurecib}">
                      <a4j:support event="onchange" status="statusButton"/>
                    </h:inputTextarea>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
                      <t:message for="menuTripulante" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </a4j:region>
                </h:panelGroup>
                <h:outputText value="Hora de salida del Paciente" styleClass="labelTextOblig"
                              rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}"/>
                <h:panelGroup>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuHoraSalidaPaciente"
                                     value="#{registrarNotaComplementariaEnfermeriaBean.referenciaPaciente.hrpchorasali}"
                                     styleClass="input-small"
                                     required="true"
                                     rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
                      <f:selectItems value="#{registrarNotaComplementariaEnfermeriaBean.listHora}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
                      <t:message for="mnuHoraSalidaPaciente" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value=" : Horas " rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}"/>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuMinutosSalidaPaciente"
                                     value="#{registrarNotaComplementariaEnfermeriaBean.referenciaPaciente.hrpcminusali}"
                                     required="true" styleClass="dropdown-toggle, input-small"
                                     rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
                      <f:selectItems value="#{registrarNotaComplementariaEnfermeriaBean.lstMinutos}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
                      <t:message for="mnuMinutosSalidaPaciente" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value=" Minutos" rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}"/>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            <spacer height="80"/>
            <s:fieldset legend="Seguimiento" id="fieldSeguimiento" styleClass="fieldset" rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelSegumiento"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Hora de ingreso del paciente a la IPS receptora" styleClass="labelTextOblig"
                              rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}"/>
                <h:panelGroup>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuHoraIngreIPS"
                                     value="#{registrarNotaComplementariaEnfermeriaBean.referenciaPaciente.hrpchoraingr}"
                                     rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}"
                                     required="true"
                                     styleClass="dropdown-toggle, input-small">
                      <f:selectItems value="#{registrarNotaComplementariaEnfermeriaBean.listHora}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
                      <t:message for="mnuHoraIngreIPS" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value=" : Horas " rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}"/>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuMinutosIngreIPS"
                                     value="#{registrarNotaComplementariaEnfermeriaBean.referenciaPaciente.hrpcminuingr}"
                                     required="true" styleClass="dropdown-toggle, input-small"
                                     rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
                      <f:selectItems value="#{registrarNotaComplementariaEnfermeriaBean.lstMinutos}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
                      <t:message for="mnuMinutosIngreIPS" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value=" Minutos" rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}"/>
                </h:panelGroup>
                <h:outputText value="Nombre del funcionario que gestionó la remisión"
                              rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}"/>
                <h:panelGroup>
                  <a4j:region renderRegionOnly="false">
                    <h:inputTextarea id="menuNomFunGes" style="width:250px"
                                     rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}" immediate="true"
                                     value="#{registrarNotaComplementariaEnfermeriaBean.referenciaPaciente.hrpcnomfunges}">
                      <a4j:support event="onchange" status="statusButton"/>
                    </h:inputTextarea>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaComplementariaEnfermeriaBean.renderReferencia}">
                      <t:message for="menuNomFunGes" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </a4j:region>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
          </s:fieldset>
          <!--FIN DE LA REFERENCIA DEL PACIENTE -->
      </s:fieldset>
    </h:panelGrid>
    
     <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelBotonRegistrarNotaComplementaria"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="boton_fieldset"
            onclick="if (!confirm(\'¿Realmente desea crear el registro complementario\')) return false"
                               action="#{registrarNotaComplementariaEnfermeriaBean.aceptar}">
                   <a4j:support event="onclick" status="statusButton"/>            
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
    
    
    <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrors1" showSummary="true"
                      errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>

    
      

  </a4j:region>
</a4j:form>