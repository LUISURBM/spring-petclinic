<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formListaVph">
 <a4j:region id="regionListaVph" renderRegionOnly="false">
    <a4j:status  id = "statusButton" for="regionListaVph">
      <f:facet name="start">
        <t:div id="chargingListaVph" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="tableContentTabsListaVph"
               styleClass="tabContainer">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="tabbedPaneListaVph"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                   width="100%" id="tableContentTabsListaUsuario"
                   styleClass="tabDerecha">
        <h:panelGroup>
          <t:inputCalendar id="fechaConsulta"
                          title="Formato: dd/mm/yyyy"
                           monthYearRowClass="yearMonthHeader"
                           weekRowClass="weekHeader"
                           currentDayCellClass="currentDayCell"
                           popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                           value="#{listaVphBean.fechaActual}"
                           popupTodayString="Hoy" popupWeekString="Semana"
                           popupButtonString="Fecha" readonly="false"
                           disabled="false" maxlength="11" size="11"
                           immediate="true"
                           popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                           renderPopupButtonAsImage="true" align="top"
                           valueChangeListener="#{listaVphBean.setFechaActual}"
                           required="true">
            <a4j:support id="supportmnuLis" event="onchange" immediate="true"
                         action="#{listaVphBean.changeConsultas}"
                         reRender="formListaVph">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
          </t:inputCalendar>
        </h:panelGroup>
        <h:panelGroup>
          <h:outputText value="Bienvenido(a) Doctor(a):  "/>
          <h:outputText id="otnomDoctor"
                        value="#{listaVphBean.usuarioSystem.curcnombre}"/>
        </h:panelGroup>
      </h:panelGrid>
      <t:panelTab id="panelTabListaVph" label="LISTA DE VPH">
        <t:htmlTag value="br"/>
        <s:fieldset legend="REGISTRAR TOMA VPH" id="fieldAsesoria"
                    styleClass="fieldset">
          <h:panelGrid columns="1" id="panelGridNoMisConsultas"
                       rendered="#{!listaVphBean.existeConsulta}">
            <h:outputText value="#{listaVphBean.msg_sin_registros}"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="tableContentTabs"
                       rendered="#{listaVphBean.existeConsulta}"
                       styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                           binding="#{listaVphBean.dtConsultas}"
                           value="#{listaVphBean.lstUsuarios}" rows="10"
                           styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2"
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
                  <h:outputText value="#{item.ccoctipide}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Numero Iden"/>
                  </f:facet>
                  <h:outputText value="#{item.ccoanumide}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Nombre"/>
                  </f:facet>
                  <h:outputText value="#{item.ccocprinom} #{item.ccocpriape}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Servicio"/>
                  </f:facet>
                  <h:outputText value="#{item.ccocservic.csvccodigo} #{item.ccocservic.csvcnombre}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Tipo Doc "/>
                  </f:facet>
                  <h:outputText value="#{item.ccontipdoc.ctdnnumero} #{item.ccontipdoc.ctdcdescri}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Numero Doc"/>
                  </f:facet>
                  <h:outputText value="#{item.cconnumdoc}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Atender"/>
                  </f:facet>
                  <h:commandLink id="atender"
                                 action="#{listaVphBean.atenderUsuario}">
                    <t:graphicImage border="0" alt="" 
                                    url="/comun/imagenes/editar.gif"/>
                  </h:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_1" for="dtConsultas" fastStep="10"
                                pageCountVar="pageCount"
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
      </t:panelTab>
    </t:panelTabbedPane>
  </h:panelGrid>
  </a4j:region>
</a4j:form>