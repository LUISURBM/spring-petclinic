<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formResulCitol">
  <a4j:region id="regionResulCitol" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionResulCitol">
      <f:facet name="start">
        <t:div id="chargingResulCitol" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="2" id="tableBodyGeneral" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
      <h:panelGroup id="tableGroupContent">
        <h:panelGrid columns="1" id="tableInfoUbication" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="td_ubicador">
          <h:outputText value="HISTORIAS CLINICAS >> Patologias >> Resultados Patologias " id="infoUbication"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridResulCitolTab" styleClass="tabContainer">
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMensajesResulCitol" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInfResulCitol" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                          warnClass="advertencia"/>
              <t:htmlTag value="br"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneResulCitol" styleClass="tabbedPane"
                             activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                             tabContentStyleClass="tabContent">
            <t:panelTab id="panelTabResulCitol_Imp" label="Registrar Resultados de Otras Patologias">
              <a4j:region renderRegionOnly="false">
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridResulCitol_Imp">
                  <s:fieldset legend="Datos Busqueda " id="fieldResulCitol_Imp" styleClass="fieldset">
                    <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosResulCitol_Imp" rowClasses="labelText,labelTextInfo">
                      <h:outputText value="No. Listado " />
                      <h:outputText value=" "/>
                      <h:outputText value="No. Patologia " />
                      <h:outputText value=" "/>
                      <h:inputText id="itListadoLectura11" required="false" maxlength="20" value="#{resultadoPatologiaBean.idListado_mod}"/>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itListadoLectura11" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                      <h:inputText id="itidPatologia" required="false" maxlength="30" value="#{resultadoPatologiaBean.idPatologia}"/>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itidPatologia" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGrid>
                  </s:fieldset>
                  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesResulCitol_Imp" columnClasses="panelGridBotones">
                    <a4j:commandButton value="Buscar Lista" styleClass="boton_fieldset" reRender="panelGridResulCitol_Imp" action="#{resultadoPatologiaBean.generarlistadoPatologias_mod}"/>
                  </h:panelGrid>
                  <s:fieldset legend="Resultados Consulta" id="fieldSetConsultar_mod" styleClass="fieldset_dataTable">
                    <h:panelGrid columns="1" id="panelGridConsultar1" rendered="#{empty resultadoPatologiaBean.listadoPatologias_mod}">
                      <h:outputText value="#{msg.msg_sin_consultar}"/>
                    </h:panelGrid>
                    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsConsultar1"
                                 rendered="#{not empty resultadoPatologiaBean.listadoPatologias_mod}" styleClass="tabContainer">
                      <h:panelGrid columns="6" styleClass="labelText">
                        <h:outputText value="Seleccionar "/>
                        <h:outputText value="[ "/>
                        <a4j:commandLink onclick="CheckAllMod(\'body:formResulCitol\')" value=" Todos"/>
                        <h:outputText value=" | "/>
                        <a4j:commandLink onclick="unCheckAllMod(\'body:formResulCitol\')" value="Ninguno "/>
                        <h:outputText value=" ]"/>
                      </h:panelGrid>
                      <h:dataTable var="item" border="0" cellpadding="0" cellspacing="2" binding="#{resultadoPatologiaBean.dtlistadoPatologias_mod}"
                                   value="#{resultadoPatologiaBean.listadoPatologias_mod}" styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                                   id="dtBucarUsuarios1">
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Item"/>
                          </f:facet>
                          <h:selectBooleanCheckbox value="#{item.itemSelected}" id="idSelectedItem"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="# Listado"/>
                          </f:facet>
                          <t:popup styleClass="popup" closePopupOnExitingElement="true" closePopupOnExitingPopup="true" displayAtDistanceX="2" displayAtDistanceY="2">
                            <h:outputText value="#{item.idListado}"/>
                            <f:facet name="popup">
                              <h:panelGroup>
                                <h:panelGrid columns="2">
                                  <h:outputText value="Clinica: " style="font-weight:bold;"/>
                                  <h:outputText value="#{item.chopnclinorig} #{item.nombClinica}"/>
                                  <h:outputText value="Laboratorio/Patologo: " style="font-weight:bold;"/>
                                  <h:outputText value="#{item.idLab} - #{item.laboratorio}"/>
                                </h:panelGrid>
                              </h:panelGroup>
                            </f:facet>
                          </t:popup>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="# Patologia"/>
                          </f:facet>
                          <h:outputText value="#{item.chopnconsec}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Documento"/>
                          </f:facet>
                          <h:outputText value="#{item.descTipoDoc} - #{item.chopnnumdoc}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Servicio"/>
                          </f:facet>
                          <h:outputText value="#{item.chopccodiserv} - #{item.nombServcio}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Usuario(a)"/>
                          </f:facet>
                          <h:outputText value="#{item.tipoIden} #{item.numInden} #{item.nombusuario}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Etapa"/>
                          </f:facet>
                          <h:outputText value="#{item.descetapa}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Seleccionar"/>
                          </f:facet>
                          <h:commandLink id="editar" action="#{resultadoPatologiaBean.verEditar}">
                            <t:graphicImage border="0" url="/comun/imagenes/editar.gif"/>
                          </h:commandLink>
                        </h:column>
                      </h:dataTable>
                      <t:htmlTag value="br"/>
                      <t:htmlTag value="br"/>
                      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonResulCitol_Imp" columnClasses="panelGridBotones">
                        <a4j:commandButton value="Generar Listado" styleClass="boton_fieldset" reRender="fieldSetConsultar_mod" action="#{resultadoPatologiaBean.guardarlistadoPatologias_mod}"/>
                      </h:panelGrid>
                    </h:panelGrid>
                    <f:subview id="generarreporteL1" rendered="#{resultadoPatologiaBean.generoReporte}">
                      <f:verbatim>
                        <script type="text/javascript" language="JavaScript">
                             window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
                        </script>
                      </f:verbatim>
                    </f:subview>
                  </s:fieldset>
                </h:panelGrid>
              </a4j:region>
            </t:panelTab>
          </t:panelTabbedPane>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                          warnClass="advertencia"/>
              <t:htmlTag value="br"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>