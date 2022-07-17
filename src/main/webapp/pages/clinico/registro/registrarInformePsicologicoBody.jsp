<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="registrarInformePsicologicoForm">
  <a4j:region id="bodyRegionRegistrarInformePsicologico">
    <a4j:status id="statusButton" for="bodyRegionRegistrarInformePsicologico">
      <f:facet name="start">
        <t:div id="chargindRegistrarInformePsicologico" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
            <h:panelGrid columns="1" id="tableConsultarInformePsicologicoReg" border="0" cellpadding="0" cellspacing="0"
                     width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="tabRegInformePsicologico" styleClass="tabbedPane"
                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                       selectedIndex="#{registrarInformePsicologicoBean.selectedIndex}"
                       disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
      <t:panelTab id="panelRegInformePsicologico" label="Registrar Informe Psicologico"
                  rendered="#{!registrarInformePsicologicoBean.renderBuscador}">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableContentTabsRegistrarInformePsicologico"
                     styleClass="tabContainerRegistrarInformePsicologico">
          <t:htmlTag value="br"/>
          <s:fieldset legend="Registrar Informe Psicologico" id="fieldMotivo" styleClass="fieldset">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelMotivo"
                         rowClasses="labelText">
              <h:outputText value="Motivo de Informe" styleClass="labelTextOblig"/>
              <h:outputText/>
              <h:panelGroup>
                <h:inputTextarea id="textMotivo" required="true"
                                 value="#{registrarInformePsicologicoBean.informe.hipcmotivinfor}"
                                 disabled="#{registrarInformePsicologicoBean.visualizar}"
                                 style="width:500px;height:70px"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textMotivo" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelTecnicas"
                         rowClasses="labelText">
              <h:outputText value="T�cnicas e Instrumentos Utilizados" styleClass="labelTextOblig"/>
              <h:outputText/>
              <h:panelGroup>
                <h:inputTextarea id="textTecnicas" required="true"
                                 value="#{registrarInformePsicologicoBean.informe.hipctecinsutl}"
                                 disabled="#{registrarInformePsicologicoBean.visualizar}"
                                 style="width:500px;height:70px"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textTecnicas" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDescripcion"
                         rowClasses="labelText">
              <h:outputText value="Descripci�n del Caso" styleClass="labelTextOblig"/>
              <h:outputText/>
              <h:panelGroup>
                <h:inputTextarea id="textDescripcion" required="true"    
                                 value="#{registrarInformePsicologicoBean.informe.hipcdesccaso}"
                                 disabled="#{registrarInformePsicologicoBean.visualizar}"
                                 style="width:500px;height:70px"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textDescripcion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelConclusiones"
                         rowClasses="labelText">
              <h:outputText value="Conclusiones y recomendaciones" styleClass="labelTextOblig"/>
              <h:outputText/>
              <h:panelGroup>
                <h:inputTextarea id="textConclusiones" required="true"  
                                 value="#{registrarInformePsicologicoBean.informe.hipcconcreco}"
                                 disabled="#{registrarInformePsicologicoBean.visualizar}"
                                 style="width:500px;height:70px"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textConclusiones" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Datos Profesional" id="fieldProfesional" styleClass="fieldset">
            <h:panelGrid columns="2" border="0" cellpadding="8" cellspacing="8" id="panelNombreProf"
                         rowClasses="labelText">
              <h:outputText value="Nombre:"/>
              <h:panelGroup>
                <h:outputText id="textNombreProf" value="#{registrarInformePsicologicoBean.informe.hipcnombprof}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="textNombreProf" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Cargo:"/>
              <h:panelGroup>
                <h:outputText id="textCargoProf" value="#{registrarInformePsicologicoBean.informe.hipccargprof}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="textCargoProf" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Registro Profesional:"/>
              <h:panelGroup>
                <h:outputText id="textRegistroProf" value="#{registrarInformePsicologicoBean.informe.hipcregiprof}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="textRegistroProf" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Buscar Profesional" id="fieldBuscarProfesional" styleClass="fieldset" rendered="#{!registrarInformePsicologicoBean.visualizar}">
            <h:panelGrid columns="2" border="0" cellpadding="1" cellspacing="1" columnClasses="labelTextInfo">
              <a4j:commandLink action="#{registrarInformePsicologicoBean.mostrarBuscadorProfesional}" 
                               reRender="tableConsultarInformePsicologicoReg">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputText id="cedula" disabled="true"
                           value="#{registrarInformePsicologicoBean.profesionalCambio.cpfcnombre}"/>
            </h:panelGrid>
          </s:fieldset>
        </h:panelGrid>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" id="panelBotonRegistrarInformePsicologico"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="boton_fieldset" disabled="#{registrarInformePsicologicoBean.visualizar}"
                             onclick="if (!confirm(\'�Realmente desea Crear el Informe Psicologico\')) return false"
                             action="#{registrarInformePsicologicoBean.aceptar}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
             <h:commandButton value="Imprimir" styleClass="boton_fieldset" rendered="#{registrarInformePsicologicoBean.visualizar}"
                             action="#{registrarInformePsicologicoBean.generarCopiaLectura}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </t:panelTab>
      <t:panelTab id="panelBuscarPofesional" label="Buscar Usuarios"
                  rendered="#{registrarInformePsicologicoBean.renderBuscador}">
        <a4j:region id="regionBuscadorUsuProfesional" renderRegionOnly="false">
          <a4j:status for="regionBuscadorUsuProfesional">
            <f:facet name="start">
              <t:div id="chargingBuscUsuProfesional" styleClass="loading">
                <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                  <h:outputText value="Procesando..."/>
                  <h:outputText value="Por favor espere."/>
                </h:panelGrid>
              </t:div>
            </f:facet>
            <f:facet name="stop"/>
          </a4j:status>
          <jsp:include page="/pages/clinico/comunes/buscador/buscadorProfesional.jsp" flush="true"/>
          <h:panelGrid id="panelGridBusUsuaBotProfesional" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
            <t:htmlTag value="br"/>
            <h:panelGroup id="panelGroupBusUsuBotProfesional">
              <h:commandButton value="Aceptar Profesional" styleClass="btn btn btn-success"
                               action="#{registrarInformePsicologicoBean.aceptarProfesional}">
                <a4j:support event="onclick" status="statusButton"/>
              </h:commandButton>
            </h:panelGroup>
          </h:panelGrid>
        </a4j:region>
      </t:panelTab>
    </t:panelTabbedPane>
    </h:panelGrid>
    <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrors1" showSummary="true" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
   <f:subview id="generarInformePsicologico" rendered="#{registrarInformePsicologicoBean.generoReporte}">
              <f:verbatim>
                <script type="text/javascript" language="JavaScript">
                        window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
                    </script>
              </f:verbatim>
            </f:subview>
</a4j:form>