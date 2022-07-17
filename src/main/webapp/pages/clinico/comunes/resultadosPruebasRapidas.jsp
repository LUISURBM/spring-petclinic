<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="consultarAutorizacionRegistrosForm">
  <a4j:region id="bodyRegionAutorizacionRegistros">
    <a4j:status id="statusButton" for="bodyRegionAutorizacionRegistros">
      <f:facet name="start">
        <t:div id="chargindConsultarAutorizacionRegistros" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridDatosUsuarioTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneDatosUsuario" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabDatosUsuario" label="Pruebas Rapidas">
          <h:panelGrid id="panleDatosBasicos" columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       styleClass="tabContainer">
        
           
                <s:fieldset legend="Resultados pruebas rapidas" styleClass="fieldset" >
                <s:fieldset legend ="VIH 1 - 2" styleClass="fieldset" rendered="#{pruebasRapidasBean.renderVIH}">
                  <h:outputText value="Resultado" styleClass="labelTextOblig"/>
                          <h:selectOneRadio disabled="#{pruebasRapidasBean.botonImprimir}" id="mnuResultadoVih" required="true"
                                            value="#{pruebasRapidasBean.pruebasRapidas.hprcresulvih}">
                            <f:selectItems value="#{pruebasRapidasBean.listResultadoReactiva}"/>
                          </h:selectOneRadio>
                          <a4j:outputPanel ajaxRendered="true">
                            <t:message for="mnuResultadoVih" styleClass="errorMessage"/>
                          </a4j:outputPanel>
               </s:fieldset>
               <s:fieldset legend ="HEPATITIS B" styleClass="fieldset" rendered="#{pruebasRapidasBean.renderHepatitisB}">
                    <h:outputText value="Resultado" styleClass="labelTextOblig"/>
                          <h:selectOneRadio disabled="#{pruebasRapidasBean.botonImprimir}" id="mnuResultado" required="true"
                                            value="#{pruebasRapidasBean.pruebasRapidas.hprcresulhepab}">
                            <f:selectItems value="#{pruebasRapidasBean.listResultadoReactiva}"/>
                          </h:selectOneRadio>
                          <a4j:outputPanel ajaxRendered="true">
                            <t:message for="mnuResultado" styleClass="errorMessage"/>
                          </a4j:outputPanel>
               </s:fieldset>
               
                <s:fieldset legend ="HEPATITIS C" styleClass="fieldset" rendered="#{pruebasRapidasBean.renderHepatitisC}">
                    <h:outputText value="Resultado" styleClass="labelTextOblig"/>
                          <h:selectOneRadio disabled="#{pruebasRapidasBean.botonImprimir}" id="mnuResultadoHepatitisC" required="true"
                                            value="#{pruebasRapidasBean.pruebasRapidas.hprcresulhepac}">
                            <f:selectItems value="#{pruebasRapidasBean.listResultadoReactiva}"/>
                          </h:selectOneRadio>
                          <a4j:outputPanel ajaxRendered="true">
                            <t:message for="mnuResultadoHepatitisC" styleClass="errorMessage"/>
                          </a4j:outputPanel>
               </s:fieldset>
                 <s:fieldset legend ="S�FILIS" styleClass="fieldset" rendered="#{pruebasRapidasBean.renderSifilis}">
                   <h:outputText value="Resultado" styleClass="labelTextOblig"/>
                          <h:selectOneRadio disabled="#{pruebasRapidasBean.botonImprimir}" id="mnuResultadoSifil" required="true"
                                            value="#{pruebasRapidasBean.pruebasRapidas.hprcresulsifil}">
                             <f:selectItems value="#{pruebasRapidasBean.listResultado}"/>
                          </h:selectOneRadio>
                          <a4j:outputPanel ajaxRendered="true">
                            <t:message for="mnuResultadoSifil" styleClass="errorMessage"/>
                          </a4j:outputPanel>
               </s:fieldset>
                 <s:fieldset legend ="Prueba Embarazo (Orina)" styleClass="fieldset" rendered="#{pruebasRapidasBean.renderPruebaEmbarazo}">
                     <h:outputText value="Resultado" styleClass="labelTextOblig"/>
                          <h:selectOneRadio disabled="#{pruebasRapidasBean.botonImprimir}" id="mnuResultadoPruemb" required="true"
                                            value="#{pruebasRapidasBean.pruebasRapidas.hprcresulpruemb}">
                             <f:selectItems value="#{pruebasRapidasBean.listResultado}"/>
                          </h:selectOneRadio>
                          <a4j:outputPanel ajaxRendered="true">
                            <t:message for="mnuResultadoPruemb" styleClass="errorMessage"/>
                          </a4j:outputPanel>
               </s:fieldset>
                <h:outputText/>
                <h:outputText/>
                <h:outputText value="Nombre Profesional:" styleClass="labelTextOblig"/>
                <h:outputText value="#{pruebasRapidasBean.profesionalAct.cpfcnombre}"/>
                <h:outputText value="Cargo:" styleClass="labelTextOblig"/>
                 <h:outputText value="#{pruebasRapidasBean.cargoProfesional}"/>
               </s:fieldset>
               
          
              <s:fieldset legend="Observaciones" id="fieldSetInfoObservaciones" styleClass="fieldset" >
              <h:panelGrid columns="1">
              <h:outputText value="Observaciones" />
                    <h:inputTextarea disabled="#{pruebasRapidasBean.botonImprimir}" value="#{pruebasRapidasBean.pruebasRapidas.hprcobservacion}"
                      styleClass="textmayuscula" 
                      style="width:500px" id="observaciones">
                                            <f:validateLength maximum="255"/>   
                    </h:inputTextarea>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="observaciones" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    </h:panelGrid>
              </s:fieldset>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Guardar"  disabled="#{pruebasRapidasBean.botonImprimir}" styleClass="btn btn btn-success"
                        action="#{pruebasRapidasBean.guardarPruebasRapidasCierre}">
                  <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>
                 <h:commandButton value="Imprimir"  immediate="true" disabled="#{!pruebasRapidasBean.botonImprimir}" styleClass="btn btn btn-primary"
                        action="#{pruebasRapidasBean.generarArchivoPdf}">
                  <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>
                <h:commandButton value="Cerrar"  immediate="true" disabled="#{!pruebasRapidasBean.botonImprimir}" styleClass="btn btn btn-danger"
                        action="#{pruebasRapidasBean.cerrarPruebaRapida}">
                  <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
                  <t:messages id="msgInformationAndErrors1" showSummary="true" errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
         <f:subview id="generarpruebasRapidas" rendered="#{pruebasRapidasBean.generoReporte}">
            <f:verbatim>
                <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
            </f:verbatim>
        </f:subview>
  </a4j:region>
</a4j:form>