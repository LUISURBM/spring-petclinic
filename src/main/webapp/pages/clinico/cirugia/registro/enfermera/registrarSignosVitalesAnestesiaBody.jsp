<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<a4j:form id="formSignosVitalesAnestesia">
  <a4j:region id="regionSignosVitalesAnestesia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionSignosVitalesAnestesia">
      <f:facet name="start">
        <t:div id="chargingSignosVitalesAnestesia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
 
 
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridSignosVitalesAnestesiaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneSignosVitalesAnestesia"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabSignosVitalesAnestesia" label="Signos Vitales">

          <s:fieldset legend="Signos Vitales" id="fieldListaSignosVitales"
                      styleClass="fieldset">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="tableSignosVitales"
                         rendered="#{not empty registrarSignosVitalesAnestesiaBean.lstsigno}"
                         styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="1" cellpadding="0"
                             cellspacing="0"
                             binding="#{registrarSignosVitalesAnestesiaBean.dtSignosVitales}"
                             value="#{registrarSignosVitalesAnestesiaBean.lstsigno}"
                             rows="10" styleClass="standard_table"
                             rowClasses="standardTable_Row1,standardTable_Row2"
                             footerClass="paginacion" id="dtSignosVitales">
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Fecha Actividad"/>
                    </f:facet>
                    <h:outputText value="#{item.hsvdfechaactiv}">
                      <f:convertDateTime pattern="dd/MM/yyyy hh:mm"/>
                    </h:outputText>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Presión Arterial"/>
                    </f:facet>
                    <h:inputText value="#{item.hsvnpresart1}" style="width:30px"
                                 maxlength="3"/>
                    <h:outputText value="/"/>
                    <h:inputText value="#{item.hsvnpresart2}" style="width:30px"
                                 maxlength="3"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Frecuencia Cardiaca"/>
                    </f:facet>
                    <h:inputText value="#{item.hsvnfreccard}" style="width:30px"
                                 maxlength="3"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Saturación de Oxígeno"/>
                    </f:facet>
                    <h:inputText value="#{item.hsvnsatuoxihe}"
                                 style="width:30px" maxlength="3"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Presión Dióxido de Carbono "/>
                    </f:facet>
                    <h:inputText value="#{item.hsvnpresioxido}"
                                 style="width:30px" maxlength="3"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Tipo de Respiración "/>
                    </f:facet>
                    <h:selectOneMenu value="#{item.hsvctiporespir}">
                      <f:selectItems value="#{registrarSignosVitalesAnestesiaBean.lstTipoRespiracion}"/>
                    </h:selectOneMenu>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Guardar"/>
                    </f:facet>
                    <h:commandLink id="guardar"
                                   action="#{registrarSignosVitalesAnestesiaBean.guardarSignoVital}">
                      <t:graphicImage border="0"  alt="" 
                                      url="/comun/imagenes/editar.gif"/>
                    </h:commandLink>
                  </h:column>
                </h:dataTable>
              </t:buffer>
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1"
                             rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_3" for="dtSignosVitales"
                                  fastStep="10" pageCountVar="pageCount"
                                  pageIndexVar="pageIndex" styleClass="scroller"
                                  paginator="true" immediate="true"
                                  paginatorMaxPages="9"
                                  paginatorTableClass="paginator"
                                  renderFacetsIfSinglePage="false"
                                  paginatorActiveColumnStyle="font-weight:bold;">
                    <f:facet name="first">
                      <t:graphicImage alt=""  url="/comun/imagenes/primero.gif"
                                      border="0"/>
                    </f:facet>
                    <f:facet name="last">
                      <t:graphicImage alt=""  url="/comun/imagenes/ultimo.gif"
                                      border="0"/>
                    </f:facet>
                    <f:facet name="previous">
                      <t:graphicImage alt=""  url="/comun/imagenes/anterior.gif"
                                      border="0"/>
                    </f:facet>
                    <f:facet name="next">
                      <t:graphicImage alt=""  url="/comun/imagenes/siguiente.gif"
                                      border="0"/>
                    </f:facet>
                    <f:facet name="fastforward">
                      <t:graphicImage alt=""  url="/comun/imagenes/adelante.gif"
                                      border="0"/>
                    </f:facet>
                    <f:facet name="fastrewind">
                      <t:graphicImage alt=""  url="/comun/imagenes/atras.gif"
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
      <h:panelGrid>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrors1" showSummary="true"
                        errorClass="error" globalOnly="true" layout="table"
                        infoClass="informacion"/>
          </a4j:outputPanel>
        </h:panelGroup>
      </h:panelGrid>
    </h:panelGrid>
  </a4j:region>
</a4j:form>