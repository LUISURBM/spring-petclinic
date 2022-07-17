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
          <h:outputText value="HISTORIAS CLINICAS >> Citologias >> Resultados Citologias " id="infoUbication"/>
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

            <t:panelTab id="panelTabResulCitol_Imp" label="Registrar Resultados de Citologias">
              <a4j:region renderRegionOnly="false">
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridResulCitol_Imp">
                  <s:fieldset legend="Datos Busqueda " id="fieldResulCitol_Imp" styleClass="fieldset">
                    <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosResulCitol_Imp" rowClasses="labelText,labelTextInfo">
                      <h:outputText value="No. Listado " styleClass="labelTextOblig"/>
                      <h:outputText value=" "/>

                      <h:inputText id="itListadoLectura11" required="true" maxlength="30" value="#{resultadoLecturaUnoBean.idListado_mod}"/>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itListadoLectura11" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                      
                    </h:panelGrid>
                  </s:fieldset>
                  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesResulCitol_Imp" columnClasses="panelGridBotones">
                    <a4j:commandButton value="Buscar Lista" styleClass="boton_fieldset" reRender="panelGridResulCitol_Imp" action="#{resultadoLecturaUnoBean.generarListadoCitologias_mod}"/>
                  </h:panelGrid>
                  <s:fieldset legend="Resultados Consulta" id="fieldSetConsultar_mod" styleClass="fieldset_dataTable">
                  
                   <a4j:commandLink action="#{resultadoLecturaUnoBean.reimprimirListado}" reRender="formResulCitol"
                         rendered="#{not empty resultadoLecturaUnoBean.listadoCitologias_mod}" 
                       immediate="true" title="Imprimir Listado">
                     <t:graphicImage alt="Imprimir Listado" title="Imprimir Listado" border="0"
                        url="/comun/imagenes/print_Spa.gif"/>
                    </a4j:commandLink>
                  <t:htmlTag value= "br"/>

                   <a4j:commandLink action="#{resultadoLecturaUnoBean.generarArchivo}" reRender="formResulCitol"
                         rendered="#{resultadoLecturaUnoBean.generarCSV}" 
                       immediate="true" title="Generar Archivo">
                     <t:graphicImage alt="Generar Archivo Csv" title="Generar Archivo Csv" border="0"
                        url="/comun/imagenes/Export.png"/>
                    </a4j:commandLink>
                  <t:htmlTag value= "br"/>
                  
                    <h:panelGrid columns="1" id="panelGridConsultar1" rendered="#{empty resultadoLecturaUnoBean.listadoCitologias_mod}">
                      <h:outputText value="#{msg.msg_sin_consultar}"/>
                    </h:panelGrid>
                    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsConsultar1"
                                 rendered="#{not empty resultadoLecturaUnoBean.listadoCitologias_mod}" styleClass="tabContainer">
                      <h:panelGrid columns="6" styleClass="labelText">
                        <h:outputText value="Seleccionar "/>
                        <h:outputText value="[ "/>
                        <a4j:commandLink onclick="CheckAllMod('body:formResulCitol')" value=" Todos"/>
                        <h:outputText value=" | "/>
                        <a4j:commandLink onclick="unCheckAllMod('body:formResulCitol')" value="Ninguno "/>
                        <h:outputText value=" ]"/>
                      </h:panelGrid>
                      <h:dataTable var="item" border="0" cellpadding="0" cellspacing="2" binding="#{resultadoLecturaUnoBean.dtlistadoCitologias_mod}"
                                   value="#{resultadoLecturaUnoBean.listadoCitologias_mod}" styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                                   id="dtBucarUsuarios1">
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Item"/>
                          </f:facet>
                          <h:selectBooleanCheckbox value="#{item.itemSelected}" id="idSelectedItem"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Id Citologia"/>
                          </f:facet>
                          <h:outputText value="#{item.cncitologi.ccinconsec}"/>
                        </h:column>
                        
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="# Citologia"/>
                          </f:facet>
                          <h:outputText value="#{item.cncitologi.ccinnumero}"/>
                        </h:column>                        
                        
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Identificacion"/>
                          </f:facet>
                          <h:outputText value="#{item.cncitologi.ccictipide} #{item.cncitologi.ccianumide}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Usuaria"/>
                          </f:facet>
                          <h:outputText value="#{item.cncitologi.ccicprinom} #{item.cncitologi.ccicsegnom} #{item.cncitologi.ccicpriape} #{item.cncitologi.ccicsegape}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Etapa"/>
                          </f:facet>
                          <h:outputText value="#{item.descEtapa}"/>
                        </h:column>
                        
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Lectura"/>
                          </f:facet>
                      <h:selectOneMenu id="comboLectura" value="#{item.hdecetapa}" >
                        <f:selectItem itemLabel="Seleccionar ..." itemValue=""/>
                        <f:selectItem itemLabel="Primera Lectura" itemValue="RLU"/>
                        <f:selectItem itemLabel="Segunda Lectura" itemValue="RLD"/>
                      </h:selectOneMenu>
                        </h:column>                         
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Resultado"/>
                          </f:facet>
                          <h:selectOneMenu id="comboColumnasCon1" value="#{item.hdecresultado}" >
                            <f:selectItem itemLabel="Seleccionar ..." itemValue=""/>
                            <f:selectItem itemLabel="Positivo" itemValue="P"/>
                            <f:selectItem itemLabel="Negativo" itemValue="N"/>
                            <f:selectItem itemLabel="No Recibido" itemValue="NR"/>
                          </h:selectOneMenu>
                          <a4j:outputPanel ajaxRendered="true">
                            <t:message for="comboColumnasCon1" styleClass="errorMessage" />
                          </a4j:outputPanel>
                        
                        </h:column>
                      </h:dataTable>
                      <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonResulCitol_Imp" columnClasses="panelGridBotones">
                        <h:outputText value="Generar Listado"/>
                        <h:panelGroup id="panelGroupRadio">
                          <h:selectOneRadio id="clsenniveluso" value="#{resultadoLecturaUnoBean.imprimeListado}">
                            <f:selectItem itemLabel="Si" itemValue="S"/>
                            <f:selectItem itemLabel="No" itemValue="N"/>
                          </h:selectOneRadio>
                        </h:panelGroup>
                        <a4j:commandButton value="Guardar Resultados" styleClass="boton_fieldset" reRender="fieldSetConsultar_mod" action="#{resultadoLecturaUnoBean.guardarListadoCitologias_mod}"/>
                      </h:panelGrid>
                    </h:panelGrid>
                    <f:subview id="generarreporteL1" rendered="#{resultadoLecturaUnoBean.generoReporte}">
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