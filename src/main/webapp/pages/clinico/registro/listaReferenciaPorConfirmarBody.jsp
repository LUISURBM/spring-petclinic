<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="listaConsultaForm">
  <a4j:region id="bodyRegionListaConsulta">
    <a4j:status for="bodyRegionListaConsulta">
      <f:facet name="start">
        <t:div id="chargindListaConsulta" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridConsultaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneListaConsulta" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabListaConsulta" label="Referencias Por Confirmar">
          <h:panelGrid id="panelDatosListaConsulta" columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       styleClass="tabContainer">
            <s:fieldset legend="Consultas" id="fieldSetConsulta" styleClass="fieldset_dataTable">
              <h:panelGrid columns="1" id="panelGridConsultarConsulta" 
                           rendered="#{empty listaReferenciaPorConfirmarBean.lstConsultas}">
                <h:outputText value="#{msg.msg_sin_consultar}"/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="tableContentTabsConsultarConsultas"
                           rendered="#{not empty listaReferenciaPorConfirmarBean.lstConsultas}"
                           styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                               binding="#{listaReferenciaPorConfirmarBean.dtConsulta}"
                               value="#{listaReferenciaPorConfirmarBean.lstConsultas}" rows="10"
                               styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtBuscarConsulta">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Fecha"/>
                      </f:facet>
                      <h:outputText value="#{item.hcodfecregistr}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Identificación"/>
                      </f:facet>
                      <h:outputText value="#{item.hcolusuario.husetipoiden} #{item.hcolusuario.husanumeiden}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Nombre"/>
                      </f:facet>
                      <h:outputText value="#{item.hcolusuario.huscprimernomb} #{item.hcolusuario.huscprimerapel}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Confirmar"/>
                      </f:facet>
                      <h:commandLink id="seleccionarConsulta"
                                     action="#{listaReferenciaPorConfirmarBean.seleccionarConsulta}">
                        <t:graphicImage border="0" alt="Seleccionar Consulta" url="/comun/imagenes/Select.png"/>
                      </h:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid id="panel2" columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_Consulta" for="dtBuscarConsulta" fastStep="10" pageCountVar="pageCount"
                                    pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                    paginatorMaxPages="9" paginatorTableClass="paginator"
                                    renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
                      <f:facet name="first">
                        <t:graphicImage url="/comun/imagenes/primero.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="last">
                        <t:graphicImage url="/comun/imagenes/ultimo.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="previous">
                        <t:graphicImage url="/comun/imagenes/anterior.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="next">
                        <t:graphicImage url="/comun/imagenes/siguiente.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="fastforward">
                        <t:graphicImage url="/comun/imagenes/adelante.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="fastrewind">
                        <t:graphicImage url="/comun/imagenes/atras.gif" border="0" alt=""/>
                      </f:facet>
                    </t:dataScroller>
                  </h:panelGrid>
                </t:buffer>
                <h:outputText value="#{tableScroller}" escape="false"/>
                <h:outputText value="#{table}" escape="false"/>
                <h:outputText value="#{tableScroller}" escape="false"/>
              </h:panelGrid>
            </s:fieldset>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
    <h:panelGrid id="panel3">
      <h:panelGroup id="msgModificarListaConsulta">
        <a4j:outputPanel id="ajaxRegionMessagesListaConsulta" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsConsulta" showSummary="true" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>