<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formInformeMarcacionSeno">
  <a4j:region id="regionInformeMarcacionSeno" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionInformeMarcacionSeno">
      <f:facet name="start">
        <t:div id="chargingInformeMarcacionSeno" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
 

    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridInformeMarcacionSenoTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneInformeMarcacionSeno"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabInformeMarcacionSeno"
                    label="Informe Marcaci�n Seno">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridInformeContainer"
                       styleClass="tabContainer">
            <s:fieldset legend="Informe Marcaci�n Seno" id="fieldInforme"
                        styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelGridInformeMarcacionSeno"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Tipo de Estudio"
                              styleClass="labelTextOblig"/>
                <h:outputText value="N�mero de la Marcaci�n"
                              styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:selectOneMenu id="menTipoEstudio" required="true"
                                   disabled="#{informeMarcacionSenoBean.modoconsulta}"
                                   value="#{informeMarcacionSenoBean.informe.himctipoestudi}">
                    <f:selectItems value="#{informeMarcacionSenoBean.lstTipoEstudio}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menTipoEstudio" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="itNumeroMarcacionSeno" required="true"
                               style="width:50px" maxlength="9"
                               disabled="#{informeMarcacionSenoBean.modoconsulta}"
                               value="#{informeMarcacionSenoBean.informe.himnnumero}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNumeroMarcacionSeno"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Medico que remite"
                              styleClass="labelTextOblig"/>
                <h:panelGroup/>
                <h:panelGroup>
                  <h:inputText id="itMedicoRemite" required="true"
                               style="width:150px" maxlength="80"
                               disabled="#{informeMarcacionSenoBean.modoconsulta}"
                               value="#{informeMarcacionSenoBean.informe.himcmedicoremi}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itMedicoRemite" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelGridInformeMarcacionSeno2"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Informaci�n Clinica"
                              styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:inputTextarea id="itInformacionClinica" required="true"
                                   style="width:600px"
                                   disabled="#{informeMarcacionSenoBean.modoconsulta}"
                                   value="#{informeMarcacionSenoBean.informe.himcdatosclire}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itInformacionClinica"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelGridInformeMarcacionSeno3"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Se Realizo Ecografia?"
                              styleClass="labelTextOblig"/>
                <h:outputText value="Dosis Entrada a Superficie"
                              styleClass="labelTextOblig"/>
                <h:panelGrid columns="2">
                  <h:selectOneRadio id="mnuEcografia" required="true"
                                    disabled="#{informeMarcacionSenoBean.modoconsulta}"
                                    value="#{informeMarcacionSenoBean.informe.himcecografia}">
                    <f:selectItems value="#{informeMarcacionSenoBean.lstOpciones}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuEcografia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGrid>
                <h:panelGroup>
                  <h:inputText id="itDosisMarcacion" required="true"
                               style="width:50px" maxlength="1"
                               disabled="#{informeMarcacionSenoBean.modoconsulta}"
                               value="#{informeMarcacionSenoBean.informe.himndosisentra}"/>
                  <h:outputText value=" miliGreys (mGy)"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itDosisMarcacion"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
              
                <h:panelGrid columns="1" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelGridInformeMarcacionSeno4"
                           rowClasses="labelText,labelTextInfo">
                           
                            <h:outputText value="Informe"
                              styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:inputTextarea id="itInforme" required="true"
                                   style="width:600px"
                                   disabled="#{informeMarcacionSenoBean.modoconsulta}"
                                   value="#{informeMarcacionSenoBean.informe.himcinformamog}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itInforme"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                           
                        </h:panelGrid>   
              <f:subview id="generarInformeMarcacionSeno"
                         rendered="#{informeMarcacionSenoBean.generoInforme}">
                <f:verbatim>
                  <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
                </f:verbatim>
              </f:subview>
              <h:panelGrid columns="1" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelBotonesInformeMarcacionSeno" dir="RTL"
                           columnClasses="panelGridBotones">
                <h:panelGroup>
                  <h:commandButton value="Aceptar" styleClass="boton_fieldset"
                                     disabled="#{informeMarcacionSenoBean.modoconsulta}"
                                     action="#{informeMarcacionSenoBean.generarMarcacionSeno}"/>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
          </h:panelGrid>
          <h:panelGrid>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionInformeMarcacionSenoMsg"
                               ajaxRendered="true">
                <t:messages id="msgInformationInformeMarcacionSenoMsg"
                            showSummary="true" errorClass="error"
                            globalOnly="true" layout="table"
                            infoClass="informacion"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>