<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formListaCirugiasProgramadas">
  <a4j:region id="regionListaCirugiasProgramadas" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionListaCirugiasProgramadas">
      <f:facet name="start">
        <t:div id="chargingListaCirugiasProgramadas" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="tableContentTabsListaCirugiasProgramadas"
                 styleClass="content-header">
                   <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionLstUsuariosIngresoEnfermeria2" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgLstUsuariosIngresoEnfermeria2" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="tabbedPaneListaCirugiasProgramadas"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabListaCirugiasProgramadas"
                    label="Lista de Cirugias Programadas">
          <t:htmlTag value="br"/>
          <s:fieldset legend="CIRUGIAS PROGRAMADAS" id="fieldAsesoria"
                      styleClass="fieldset">
            <h:panelGrid columns="1" id="panelGridNoConsultas"
                         rendered="#{empty listaCirugiasProgramadasBean.lstCirugias}">
              <h:outputText value="#{listaCirugiasProgramadasBean.msg_sin_registros}"/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="tableContentTabs"
                         rendered="#{not empty listaCirugiasProgramadasBean.lstCirugias}"
                         styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="1" cellpadding="0"
                             cellspacing="0"
                             binding="#{listaCirugiasProgramadasBean.dtCirugias}"
                             value="#{listaCirugiasProgramadasBean.lstCirugias}"
                             rows="30" styleClass="standard_table"
                             rowClasses="standardTable_Row3,standardTable_Row4"
                             footerClass="paginacion" id="dtConsultas">
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Hora"/>
                    </f:facet>
                    <h:outputText value="#{item.horaRegi}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Tipo Iden"/>
                    </f:facet>
                    <h:outputText value="#{item.hcplusuario.husetipoiden}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Numero Iden"/>
                    </f:facet>
                    <h:outputText value="#{item.hcplusuario.husanumeiden}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Procedimiento"/>
                    </f:facet>
                    <h:outputText value="#{item.nombreServicio}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Nombre"/>
                    </f:facet>
                    <h:outputText value="#{item.hcplusuario.huscprimernomb} #{item.hcplusuario.huscprimerapel}"/>
                  </h:column>
                 <h:column>
                    <f:facet name="header">
                      <h:outputText value="Hora de programación"/>
                    </f:facet>
                    <h:outputText value="#{item.hcpchoradurac} : #{item.hcpcminutdurac}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Atender"/>
                    </f:facet>
                    <h:commandLink id="atender"
                                   action="#{listaCirugiasProgramadasBean.atenderUsuario}"
                                   ondblclick="openWin()">
                      <t:graphicImage border="0" alt=""
                                      url="/comun/imagenes/editar.gif"/>
                    </h:commandLink>
                  </h:column>
                </h:dataTable>
              </t:buffer>
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1"
                             rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_1" for="dtConsultas" fastStep="10"
                                  pageCountVar="pageCount"
                                  pageIndexVar="pageIndex" styleClass="scroller"
                                  paginator="true" immediate="true"
                                  paginatorMaxPages="9"
                                  paginatorTableClass="paginator"
                                  renderFacetsIfSinglePage="false"
                                  paginatorActiveColumnStyle="font-weight:bold;">
                    <f:facet name="first">
                      <t:graphicImage url="/comun/imagenes/primero.gif" alt=""
                                      border="0"/>
                    </f:facet>
                    <f:facet name="last">
                      <t:graphicImage url="/comun/imagenes/ultimo.gif" alt=""
                                      border="0"/>
                    </f:facet>
                    <f:facet name="previous">
                      <t:graphicImage url="/comun/imagenes/anterior.gif" alt=""
                                      border="0"/>
                    </f:facet>
                    <f:facet name="next">
                      <t:graphicImage url="/comun/imagenes/siguiente.gif" alt=""
                                      border="0"/>
                    </f:facet>
                    <f:facet name="fastforward">
                      <t:graphicImage url="/comun/imagenes/adelante.gif" alt=""
                                      border="0"/>
                    </f:facet>
                    <f:facet name="fastrewind">
                      <t:graphicImage alt="" url="/comun/imagenes/atras.gif"
                                      border="0"/>
                    </f:facet>
                  </t:dataScroller>
                </h:panelGrid>
              </t:buffer>
              <h:outputText value="#{tableScroller}" escape="false"/>
              <h:outputText value="#{table}" escape="false"/>
              <h:outputText value="#{tableScroller}" escape="false"/>
            </h:panelGrid>
          </s:fieldset>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>