<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.min.css"/>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridSeleccionPruebasRapidasTab"
             styleClass="tabContainer">
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneSeleccionPruebasRapidas" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     selectedIndex = "#{datosBasicosUsuarioBean.selectedIndex}"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabSeleccionPruebasRapidas" label="Admision Seleccionada">
      <s:fieldset legend="Pruebas Rápidas Seleccionada" id="fieldSetInfoBasica" styleClass="fieldset">
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelRegionInfoConsulta" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Seleccione" styleClass="labelTextOblig"/>
                    
                    <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                                 binding="#{listaUsuariosPruebasRapidasBean.dtLstServicios}"
                                 value="#{listaUsuariosPruebasRapidasBean.lstPruebasRapidas}" styleClass="standard_table"
                                 rowClasses="standardTable_Row3,standardTable_Row4" footerClass="paginacion" rows="20"
                                 id="idtMisConsultas">
                                 <h:column>
                        <f:facet name="header">
                          <h:outputText value="Seleccionar"/>
                        </f:facet>
                        <h:panelGroup id="panelRegionEstablecioAcciones"  style="border-style:none;font-size:10px">
                          <a4j:region renderRegionOnly="false">
                            <h:selectBooleanCheckbox id="checkNingunaAccion" immediate="true"
                                                     onkeydown="return blockEnter(event);"
                                                     valueChangeListener="#{item.setSeleccionado}"
                                                     value="#{item.itemSelect}" >
                              <a4j:support id="supportNingunaAccion" event="onclick"
                                           reRender="panelRegionEstablecioAcciones">
                                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                              </a4j:support>
                            </h:selectBooleanCheckbox>
                          </a4j:region>
                        </h:panelGroup>
                        <a4j:outputPanel ajaxRendered="true">
                          <t:message for="checkNingunaAccion" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                      </h:column>
                      <h:column>
                        <f:facet name="header">
                          <h:outputText value="Codigo Servicio"/>
                        </f:facet>
                        <h:outputText value="#{item.ccocservic.csvccodigo}"/>
                      </h:column>
                       <h:column>
                        <f:facet name="header">
                          <h:outputText value="Descripcion"/>
                        </f:facet>
                        <h:outputText value="#{item.ccocservic.csvcnombre}"/>
                      </h:column>
                    </h:dataTable>
                </h:panelGrid>
      
      </s:fieldset>
      
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
          <t:htmlTag value="br"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
              <h:commandButton value="Siguiente" styleClass="btn btn btn-success"
                           action="#{listaUsuariosPruebasRapidasBean.siguienteSeleccion}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>
   </t:panelTabbedPane>
  <f:verbatim>
    <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
  </f:verbatim>
</h:panelGrid>