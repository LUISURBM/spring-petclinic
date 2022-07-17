<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridIngresoMedicoTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneIngresoMedico" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" selectedIndex="#{ingresoCirugiaMedicoBean.selectedIndex}"
                     inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                     activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabIngresoMedico" label="Ingreso Médico" disabled="#{ingresoCirugiaMedicoBean.renderPlantilla}"
    >
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="tableContentTabsIngresoMedico" styleClass="tabContainer">
        <s:fieldset legend="Cirugia(s) Programada(s)" id="fieldCirugiasIngreso" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelCirugiasLiquidos"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Intervención(es)" styleClass="labelTextOblig"/>
            <h:outputText/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0"
                       rendered="#{not empty ingresoCirugiaMedicoBean.lstCirugias}" cellspacing="0" width="100%"
                       id="tableCirugiasProgramadasLiquidos" styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                           binding="#{ingresoCirugiaMedicoBean.dtCirugias}"
                           value="#{ingresoCirugiaMedicoBean.lstCirugias}" rows="10" styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                           id="dtCirugiasProgramadasLiquidos">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Codigo"/>
                  </f:facet>
                  <h:outputText value="#{item.csvccodigo}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Nombre"/>
                  </f:facet>
                  <h:outputText value="#{item.csvcnombre}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Estado"/>
                  </f:facet>
                  <h:outputText value="#{item.csvcestado}"/>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_1" for="dtCirugiasProgramadasLiquidos" fastStep="10" pageCountVar="pageCount"
                                pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                                paginatorActiveColumnStyle="font-weight:bold;">
                  <f:facet name="first">
                    <t:graphicImage alt=""  url="/comun/imagenes/primero.gif" border="0"/>
                  </f:facet>
                  <f:facet name="last">
                    <t:graphicImage alt=""  url="/comun/imagenes/ultimo.gif" border="0"/>
                  </f:facet>
                  <f:facet name="previous">
                    <t:graphicImage alt=""  url="/comun/imagenes/anterior.gif" border="0"/>
                  </f:facet>
                  <f:facet name="next">
                    <t:graphicImage alt=""  url="/comun/imagenes/siguiente.gif" border="0"/>
                  </f:facet>
                  <f:facet name="fastforward">
                    <t:graphicImage alt=""  url="/comun/imagenes/adelante.gif" border="0"/>
                  </f:facet>
                  <f:facet name="fastrewind">
                    <t:graphicImage alt=""  url="/comun/imagenes/atras.gif" border="0"/>
                  </f:facet>
                </t:dataScroller>
              </h:panelGrid>
            </t:buffer>
            <h:outputText value="#{tableScroller}" escape="false"/>
            <h:outputText value="#{table}" escape="false"/>
            <h:outputText value="#{tableScroller}" escape="false"/>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Observaciones y Alergias " id="fieldSetInfoIngresoMedicoAlergias" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelRegionIngresoMedicoAlergias" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Observaciones"/>
            <h:panelGroup>
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
                <a4j:commandLink action="#{ingresoCirugiaMedicoBean.mostrarBuscadorPlantilla}" immediate="true"
                                 reRender="panelGridIngresoMedicoTab">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                </a4j:commandLink>
                <h:inputTextarea id="itObservaciones" onkeydown="return blockEnter(event);" immediate="true"
                                     binding="#{ingresoCirugiaMedicoBean.itDescripcion}"
                                 value="#{ingresoCirugiaMedicoBean.ingreso.himcobservacio}" style="width:750px"/>
              </h:panelGrid>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itObservaciones" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="Alergias"/>
            <h:panelGroup>
              <h:inputTextarea id="itAlergias" style="width:750px"
                               value="#{ingresoCirugiaMedicoBean.ingreso.himcalergias}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itAlergias" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                     columnClasses="panelGridBotones">
          <t:htmlTag value="br"/>
          <h:panelGroup id="panelGroupCirugiaBotones1">
            <h:commandButton value="Aceptar" styleClass="btn btn btn-success"
                             action="#{ingresoCirugiaMedicoBean.RegistrarIngreso}"></h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
        <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionIngresoMedicoMsg" ajaxRendered="true">
              <t:messages id="msgInformationIngresoMedicoMsg" showSummary="true" errorClass="error" globalOnly="true"
                          layout="table" infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
    
       <t:panelTab id="panelBuscadorPlantillaIngresoMedico" label="Buscar Plantillas" 
        rendered="#{ingresoCirugiaMedicoBean.renderPlantilla}">
      <a4j:region id="regionBuscadorPlantillaIngresoMedico" renderRegionOnly="false">
        <a4j:status for="regionBuscadorPlantillaIngresoMedico">
          <f:facet name="start">
            <t:div id="chargingBuscadorPlantillaIngresoMedico" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <jsp:include page="/pages/clinico/comunes/buscador/buscadorPlantillas.jsp" flush="true"/>
        <h:panelGrid id="panelGridBuscadorBotonesPlantillaIngresoMedico" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
          <t:htmlTag value="br"/>
          <h:panelGroup id="panelGroupBuscadorBotonesPlantillaIngresoMedico">
            <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success" 
              action="#{ingresoCirugiaMedicoBean.aceptarPlantilla}" 
                reRender="panelGridIngresoMedicoTab">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </a4j:region>
    </t:panelTab>
    
    
  </t:panelTabbedPane>
</h:panelGrid>