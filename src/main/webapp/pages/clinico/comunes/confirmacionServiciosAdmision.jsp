<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridMotivoConsultaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneMotivoConsulta" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabConfirmarInsumos" label="Confirmar Insumos">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsInsumos"
                   styleClass="tabContainer">
        <s:fieldset legend="Insumos " id="fieldInsumos" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabs"
                       rendered="#{not empty confirmarInsumosBean.confirmarInsumoDTOList}">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="0" cellpadding="0" cellspacing="4"
                           binding="#{confirmarInsumosBean.tableInsumos}"
                           value="#{confirmarInsumosBean.confirmarInsumoDTOList}" rows="30" styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                           id="tdatosInsumos">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="codigo Servicio"/>
                  </f:facet>
                  <h:outputText value="#{item.hricservicio}"></h:outputText>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="nombre Servicio"/>
                  </f:facet>
                  <h:outputText value="#{item.nombreServicio}"></h:outputText>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Confirmar Consumo"/>
                  </f:facet>
                  <h:selectBooleanCheckbox id="mnuConfirmarConsumo" value="#{item.consumo}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Observación"/>
                  </f:facet>
                  <h:inputTextarea value="#{item.hricobserv}"  rows="5" style="width:500px"/>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_1" for="tdatosInsumos" fastStep="10" pageCountVar="pageCount"
                                pageIndexVar="pageIndex" styleClass="scroller" paginator="true" paginatorMaxPages="9"
                                paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                                paginatorActiveColumnStyle="font-weight:bold;"></t:dataScroller>
              </h:panelGrid>
            </t:buffer>
            <h:outputText value="#{tableScroller}" escape="false"/>
            <h:outputText value="#{table}" escape="false"/>
            <h:outputText value="#{tableScroller}" escape="false"/>
          </h:panelGrid>

        </s:fieldset>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="boton_fieldset" action="#{confirmarInsumosBean.guardarInsumos}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
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
    </t:panelTab>
  </t:panelTabbedPane>
</h:panelGrid>