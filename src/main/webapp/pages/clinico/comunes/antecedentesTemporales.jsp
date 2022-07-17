<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAntecedentesTemporalesTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneAntecedentesTemporal" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabAntecedentesTemporales" label="Antecedentes Temporales">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="tableContentTabsAntecedentesTemporales" styleClass="tabContainer">
        <h:panelGrid id="panelMetodosUsa" width="100%">
          <s:fieldset legend="M�todo de planificaci�n" id="fieldMetodo" styleClass="fieldset">
            <a4j:region renderRegionOnly="false">
              <h:panelGrid columns="7">
                <h:outputText value="[ " style="font-size:8.0pt; font-weight:bold;"/>
                <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value=" Todos SI" immediate="true"
                                 action="#{antecedentesTemporalesUsuario.changeTodosSi}"
                                 reRender="tableMostrarMetodos"/>
                <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
                <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true"
                                 action="#{antecedentesTemporalesUsuario.changeTodosNo}"
                                 reRender="tableMostrarMetodos"/>
                <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
                <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true"
                                 action="#{antecedentesTemporalesUsuario.changeNinguno}"
                                 reRender=" tableMostrarMetodos"/>
                <h:outputText value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
              </h:panelGrid>
            </a4j:region>
            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableMostrarMetodos"
                         rowClasses="labelCuestionario,labelCuestionario2">
              <t:div style="overflow:auto;width:550px;height:30px;">
                <h:outputText value="�Recibi� usted informaci�n o asesor�a sobre todos los m�todos temporales de planificaci�n  familiar?"
                              styleClass="labelTextOblig"/>
              </t:div>
              <h:panelGroup>
                <h:selectOneRadio id="mnuMetodosTemporales" required="true" immediate="true"
                                  onkeydown="return blockEnter(event);"
                                  binding="#{antecedentesTemporalesUsuario.mnuHcpcmetotempla}"
                                  value="#{antecedentesTemporalesUsuario.cuestionario.hcpcmetotempla}">
                  <f:selectItems value="#{antecedentesTemporalesUsuario.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuMetodosTemporales" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText/>
              <t:div style="overflow:auto;width:550px;height:30px;">
                <h:outputText value="�Recibi� usted informaci�n o asesor�a sobre todos los m�todos definitivos de  planificaci�n familiar?"
                              styleClass="labelTextOblig"/>
              </t:div>
              <h:panelGroup>
                <h:selectOneRadio id="mnuMetodosDefinitivos" required="true" immediate="true"
                                  onkeydown="return blockEnter(event);"
                                  binding="#{antecedentesTemporalesUsuario.mnuHcpcmetodefpla}"
                                  value="#{antecedentesTemporalesUsuario.cuestionario.hcpcmetodefpla}">
                  <f:selectItems value="#{antecedentesTemporalesUsuario.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuMetodosDefinitivos" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText/>
              <t:div style="overflow:auto;width:550px;height:20px;">
                <h:outputText value="�Est� usted embarazada o cree que lo est�?" styleClass="labelTextOblig"/>
              </t:div>
              <h:panelGroup>
                <h:selectOneRadio id="mnuEmbarazada" required="true" immediate="true"
                                  onkeydown="return blockEnter(event);"
                                  binding="#{antecedentesTemporalesUsuario.mnuHcpcembarazada}"
                                  value="#{antecedentesTemporalesUsuario.cuestionario.hcpcembarazada}">
                  <f:selectItems value="#{antecedentesTemporalesUsuario.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuEmbarazada" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText/>
            
    
        
              <t:div style="overflow:auto;width:550px;height:20px;">
                <h:outputText value="�Sabe usted que los m�todos temporales pueden fallar aun us�ndolos consistentemente?"
                              styleClass="labelTextOblig"/>
              </t:div>
              <h:panelGroup>
                <h:selectOneRadio id="mnuFalloMetodos" immediate="true" required="true"
                                  onkeydown="return blockEnter(event);"
                                  binding="#{antecedentesTemporalesUsuario.mnuHcpcfallametem}"
                                  value="#{antecedentesTemporalesUsuario.cuestionario.hcpcfallametem}">
                  <f:selectItems value="#{antecedentesTemporalesUsuario.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuFalloMetodos" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText/>
              
               <t:div style="overflow:auto;width:550px;height:20px;">
                <h:outputText value="�Sabe usted que los m�todos de anticoncepci�n no se emplean como m�todo para interrupci�n del embarazo?"
                              styleClass="labelTextOblig"/>
              </t:div>
              <h:panelGroup>
                <h:selectOneRadio id="mnuNoEsInterrupcionEmbarazo" immediate="true" required="true"
                                  onkeydown="return blockEnter(event);"
                                  binding="#{antecedentesTemporalesUsuario.mnuHcpcmetintemb}"
                                  value="#{antecedentesTemporalesUsuario.cuestionario.hcpcmetintemb}">
                  <f:selectItems value="#{antecedentesTemporalesUsuario.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuNoEsInterrupcionEmbarazo" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText/>
              
              
              
              
              <t:div style="overflow:auto;width:550px;height:30px;">
                <h:outputText value="Recibi� informaci�n suficiente para suscribir el consentimiento informado para el m�todo  temporal solicitado"
                              styleClass="labelTextOblig"/>
              </t:div>
              <h:panelGroup>
                <h:selectOneRadio id="mnuInformacionSuficiente" required="true" immediate="true"
                                  onkeydown="return blockEnter(event);"
                                  binding="#{antecedentesTemporalesUsuario.mnuHcpcinfometoso}"
                                  value="#{antecedentesTemporalesUsuario.cuestionario.hcpcinfometoso}">
                  <f:selectItems value="#{antecedentesTemporalesUsuario.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuInformacionSuficiente" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText/>
            </h:panelGrid>
          </s:fieldset>
        </h:panelGrid>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                            action="#{antecedentesTemporalesUsuario.aceptar}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
        <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMensajesAntecedentes" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInformacionAntecedentes" showSummary="true" errorClass="error" globalOnly="true"
                          layout="table" infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
        <f:subview id="generarConsentimiento" rendered="#{antecedentesTemporalesUsuario.generoConsentimiento}">
          <f:verbatim>
            <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
          </f:verbatim>
        </f:subview>
      </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>