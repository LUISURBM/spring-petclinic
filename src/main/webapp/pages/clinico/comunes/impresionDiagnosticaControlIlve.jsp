<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridImpresionDiagnosticaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneImpresionDiagnostica" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     selectedIndex="#{impresionDiagnosticaControlIlveBean.selectedIndex}"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabImpresionDiagnostica" label="Impresión Diagnostica Control Ilve"
                disabled="#{impresionDiagnosticaControlIlveBean.mostrarCie10}">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="panelGridImpresionDiagnostica">
       
           <s:fieldset legend="Impresión Diagnostica" id="fieldDiagnosticosConsultaControl" styleClass="fieldset">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelDatosTipoImpresionConsultaControl" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Tipo Diagnostico " styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:selectOneMenu id="tipoDiagnosticoConsultaControl"
                               value="#{impresionDiagnosticaControlIlveBean.impresion.hidntipodiagn}">
                <f:selectItems value="#{impresionDiagnosticaControlIlveBean.lstTipoImpresion}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="tipoDiagnosticoConsultaControl" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelDatosDiagnosticosConsultaControl" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Diagnostico Principal" styleClass="labelTextOblig"/>
              <a4j:region renderRegionOnly="false">
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
                  <h:selectOneMenu id="itDiagPrin" required="true"
                                   value="#{impresionDiagnosticaControlIlveBean.impresion.hidcdiagprin}">
                    <f:selectItems value="#{impresionDiagnosticaControlIlveBean.lstDiagnosticoPrincipal}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itDiagPrin" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGrid>
              </a4j:region>
              <h:outputText value="Diagnostico Relacionado Uno (1) "/>
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
                <h:selectOneMenu id="itDiagnosticoRelacionado1" required="true"
                                 value="#{impresionDiagnosticaControlIlveBean.impresion.hidcdiagrela1}">
                  <f:selectItems value="#{impresionDiagnosticaControlIlveBean.lstDiagnosticoRelacionado1}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itDiagnosticoRelacionado1" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
              <h:panelGroup>
                <h:outputText value="Diagnostico Relacionado Dos (2) " styleClass="labelTextOblig"
                              rendered="#{impresionDiagnosticaControlIlveBean.requiredRel2}"/>
                <h:outputText value="Diagnostico Relacionado Dos (2) "
                              rendered="#{!impresionDiagnosticaControlIlveBean.requiredRel2}"/>
              </h:panelGroup>
              <h:panelGrid id="panelGroupDiagnostico" columns="2" border="0" cellpadding="0" cellspacing="0">
                <h:selectOneMenu id="itDiagnosticoRelacionado2" required="true"
                                 value="#{impresionDiagnosticaControlIlveBean.impresion.hidcdiagrela2}">
                  <f:selectItems value="#{impresionDiagnosticaControlIlveBean.lstDiagnosticoRelacionado2}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itDiagnosticoRelacionado2" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
              <h:outputText value="Diagnostico Relacionado Tres (3) "/>
              <a4j:region renderRegionOnly="false">
             <h:panelGrid id="mnuDiagnosticoRelacionado3" columns="3" border="0" cellpadding="0" cellspacing="0">
             
              <a4j:commandLink action="#{impresionDiagnosticaControlIlveBean.mostrarDiagnosticoRelacionado3}"
                               reRender="panelGridImpresionDiagnosticaTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputText id="itDiagnosticoRelacionado3" onkeydown="return blockEnter(event);"
                           styleClass="textmayuscula" value="#{impresionDiagnosticaControlIlveBean.impresion.hidcdiagrela3}"
                           valueChangeListener="#{impresionDiagnosticaControlIlveBean.setHidcdiagrela3}" style="width:50px"
                           maxlength="4" immediate="true"
                           binding="#{impresionDiagnosticaControlIlveBean.inputDiagRelacionado3}">
                             <f:converter converterId="cadena.stringUpperCaseConverter"/>
                <a4j:support id="supportDiagnosticoRelacionado3" event="onchange"
                             action="#{impresionDiagnosticaControlIlveBean.changeDiagnosticoRelacionado3}"
                             reRender="panelDiagnosticoRelacionado3">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                  <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDiagnosticoRelacionado3" styleClass="errorMessage"/>
              </a4j:outputPanel>
              </h:inputText>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoRelacionado3">
                <h:outputText value="  #{impresionDiagnosticaControlIlveBean.diagnosticoRelacionado3}"
                              styleClass="buscador"/>
              </h:panelGrid>
            </h:panelGrid>
        </a4j:region>
            </h:panelGrid>
          </s:fieldset>
      
    
     
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelBotonBotonesImpresionDiagnostica" columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Aceptar" styleClass="btn btn btn-success"
                             action="#{impresionDiagnosticaControlIlveBean.aceptar}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
    <t:panelTab id="panelBuscador" label="Buscar Diagnosticos"
                rendered="#{impresionDiagnosticaControlIlveBean.mostrarCie10}">
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
                               action="#{impresionDiagnosticaControlIlveBean.aceptarDiagnostico}"
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