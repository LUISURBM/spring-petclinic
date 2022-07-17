<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridInformeCitopuncionTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     selectedIndex="#{informeCitopuncionSenoBean.selectIndex}" width="100%"
                     id="panelTabbedPaneInformeCitopuncion" styleClass="tabbedPane" activeTabStyleClass="activeTab"
                     inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                     activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabInformeCitopuncion" label="Informe Citopunci�n">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="panelGridInformeContainerCitopuncion" styleClass="tabContainer">
        <s:fieldset legend="Informe Citopunci�n Seno" id="fieldInformeCitopuncion" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridInformeCitopuncion" rowClasses="labelText,labelTextInfo">
            <h:outputText value="N�mero de Citopunci�n" styleClass="labelTextOblig"/>
            <h:outputText value="Medico que remite" styleClass="labelTextOblig"/>
            <h:panelGroup>
              <h:inputText id="itNumeroCitopuncion" required="true" style="width:50px" maxlength="9"
                           onkeydown="return blockEnter(event);" disabled="#{informeCitopuncionSenoBean.modoconsulta}"
                           value="#{informeCitopuncionSenoBean.informe.himnnumero}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itNumeroCitopuncion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="itMedicoRemiteCitopuncion" required="true" style="width:150px" maxlength="80"
                           onkeydown="return blockEnter(event);" disabled="#{informeCitopuncionSenoBean.modoconsulta}"
                           value="#{informeCitopuncionSenoBean.informe.himcmedicoremi}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itMedicoRemiteCitopuncion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridInformeCitopuncion2" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Informaci�n Clinica" styleClass="labelTextOblig"/>
            <h:panelGroup>
              <h:inputTextarea id="itDatosClinicosRelevantesCitopuncion" required="true" style="width:600px"
                               disabled="#{informeCitopuncionSenoBean.modoconsulta}"
                               value="#{informeCitopuncionSenoBean.informe.himcdatosclire}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDatosClinicosRelevantesCitopuncion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="Transductor utilizado" styleClass="labelTextOblig"/>
            <h:panelGroup>
              <h:inputText id="itInformeTransductorCitopuncion" onkeydown="return blockEnter(event);"
                           style="width:300px" maxlength="60" required="true"
                           disabled="#{informeCitopuncionSenoBean.modoconsulta}"
                           value="#{informeCitopuncionSenoBean.informe.himctransducto}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itInformeTransductorCitopuncion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="Informe" styleClass="labelTextOblig"/>
            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink action="#{informeCitopuncionSenoBean.mostrarBuscadorPlantilla}" immediate="true"
                               reRender="panelGridInformeCitopuncionTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt=""  border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputTextarea id="itInformeCitopuncion" immediate="true" onkeydown="return blockEnter(event);"
                               binding="#{informeCitopuncionSenoBean.itInforme}"
                               disabled="#{informeCitopuncionSenoBean.modoconsulta}"
                               value="#{informeCitopuncionSenoBean.informe.himcinformamog}" style="width:600px">
                <f:validateLength minimum="2"/>
              </h:inputTextarea>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itInformeCitopuncion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
            <h:outputText value="Conclusi�n" styleClass="labelTextOblig"/>
            <h:panelGroup>
              <h:inputTextarea id="itOpinionCitopuncion" required="true" style="width:600px"
                               disabled="#{informeCitopuncionSenoBean.modoconsulta}"
                               value="#{informeCitopuncionSenoBean.informe.himcopinion}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itOpinionCitopuncion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
          <f:subview id="generarInformeCitopuncion" rendered="#{informeCitopuncionSenoBean.generoInforme}">
            <f:verbatim>
              <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
            </f:verbatim>
          </f:subview>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelBotonesInformeCitopuncion" dir="RTL" columnClasses="panelGridBotones">
            <h:panelGroup>
              <h:commandButton value="Aceptar" styleClass="btn btn btn-success"
                               disabled="#{informeCitopuncionSenoBean.modoconsulta}"
                               action="#{informeCitopuncionSenoBean.generarCitopuncion}"/>
                               <a4j:support event="onclick" status="statusButton"/>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
      </h:panelGrid>
      <h:panelGrid>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionInformeCitopuncionMsg" ajaxRendered="true">
            <t:messages id="msgInformationInformeCitopuncionMsg" showSummary="true" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion"/>
          </a4j:outputPanel>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>
    <t:panelTab id="panelBuscadorCitopuncion" label="Buscar Plantillas"
                rendered="#{informeCitopuncionSenoBean.renderBuscador}">
      <a4j:region id="regionBuscadorCitopuncion" renderRegionOnly="false">
        <a4j:status id="statusButton" for="regionBuscadorCitopuncion">
          <f:facet name="start">
            <t:div id="chargingBuscadorCitopuncion" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <jsp:include page="/pages/clinico/comunes/buscador/buscadorPlantillas.jsp" flush="true"/>
        <h:panelGrid id="panelGridBuscadorBotonesCitopuncion" width="100%" columnClasses="columnaBotonesCentrados"
                     dir="RTL">
          <t:htmlTag value="br"/>
          <h:panelGroup id="panelGroupBuscadorBotones1Citopuncion">
            <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success"
                               action="#{informeCitopuncionSenoBean.aceptarPlantilla}"
                               reRender="panelGridInformeCitopuncionTab">
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