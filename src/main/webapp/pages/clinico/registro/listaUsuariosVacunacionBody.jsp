<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formListaUsuariosVacunacion">
  <a4j:region id="regionListaUsuariosVacunacion" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionListaUsuariosVacunacion">
      <f:facet name="start">
        <t:div id="chargingListaUsuariosVacunacion" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableinfoUbicationListaVacunacionListaVacunacion" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="td_ubicador">
      <h:outputText value="HISTORIAS CLINICAS >> Registro de Historias >> Todas las consultas " id="infoUbicationListaVacunacion"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsVacunacionListaVacunacionsVacunacion" styleClass="tabContainer">
    
         <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="tabbedPaneListaUsuariosVacunacion" styleClass="tabbedPane"
                                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                                       inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    
        <s:fieldset legend="Busqueda Vacunación" id="fieldListaVacunacion" styleClass="fieldset">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="10" width="100%" id="tableContentTabsVacunacionListaVacunacion" columnClasses="labelText,labelTextInfo">
            
            <h:outputText value="Sr(a): "/>
            <h:outputText id="otnomDoctorVacunacion" value="#{listaVacunacionBean.usuarioSystem.curcnombre}"/>
            <h:outputText value=" "/>
            <h:outputText value=" "/>          
            
            
            <h:outputText value="Fecha Consulta: "/>
            <t:inputCalendar id="fechaConsultaVacunacion" title="Formato: dd/MM/yyyy" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true" value="#{listaVacunacionBean.fechaActual}" popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                             readonly="false" disabled="false" maxlength="11" size="11" immediate="true" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                             align="top" valueChangeListener="#{listaVacunacionBean.setFechaActual}" required="true">
              <a4j:support id="supportmnuListaVacunacion" event="onchange" immediate="true" action="#{listaVacunacionBean.changeConsultas}" reRender="formListaUsuariosVacunacion">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </t:inputCalendar>
            <h:outputText value=" "/>
            <h:outputText value=" "/>
            
          </h:panelGrid>
        </s:fieldset>
        
        <t:panelTab id="panelTabListaUsuariosVacunacion" label="Lista de Consultas">
          <t:htmlTag value="br"/>
          <s:fieldset legend="Vacunación" id="fieldVacunacion" styleClass="fieldset">
            <h:panelGrid columns="1" id="panelGridNoConsultasVacunacion" rendered="#{!listaVacunacionBean.existeConsulta}">
              <h:outputText value="#{listaVacunacionBean.msg_sin_registros}"/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsVacunacion"
                         rendered="#{listaVacunacionBean.existeConsulta}" styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                             binding="#{listaVacunacionBean.dtConsultas}" value="#{listaVacunacionBean.lstUsuarios}"
                             styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                             footerClass="paginacion" rows="20" id="idDtConsultasVacunacion">
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Hora"/>
                    </f:facet>
                    <h:outputText value="#{item.horaRegi}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Identificación"/>
                    </f:facet>
                    <h:outputText value="#{item.ccoctipide} #{item.ccoanumide}"/>
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
                    <h:outputText value="#{item.ccocservic.csvccodigo} - #{item.ccocservic.csvcnombre}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Tipo Doc "/>
                    </f:facet>
                    <h:outputText value="#{item.ccontipdoc.ctdnnumero} - #{item.ccontipdoc.ctdcdescri}"/>
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
                    <t:commandLink id="atenderVacunacion"   action="#{listaVacunacionBean.atenderUsuario}">
                      <t:graphicImage id = "imageAtenderVacunacion" border="0" alt="Atender Vacunación"
                        url="/comun/imagenes/editar.gif"/>
                    </t:commandLink>
                  </h:column>
                </h:dataTable>
              </t:buffer>
              
             <t:buffer into="#{tableScroller}">
                                        <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                                            <t:dataScroller id="scroll_Vacunacion" for="idDtConsultasVacunacion" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                                                            immediate="true" renderFacetsIfSinglePage="false" paginatorMaxPages="9" paginatorTableClass="paginator"
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
                                            <t:dataScroller id="scroll_2" for="idDtConsultasVacunacion" immediate="true" rowsCountVar="rowsCount" displayedRowsCountVar="displayedRowsCountVar"
                                                            firstRowIndexVar="firstRowIndex" lastRowIndexVar="lastRowIndex" pageCountVar="pageCount" pageIndexVar="pageIndex">
                                                <h:outputFormat value="Registros : Total {0}, mostrados {1} del {2} al {3}  Pagina {4} / {5}" styleClass="standard">
                                                    <f:param value="#{rowsCount}"/>
                                                    <f:param value="#{displayedRowsCountVar}"/>
                                                    <f:param value="#{firstRowIndex}"/>
                                                    <f:param value="#{lastRowIndex}"/>
                                                    <f:param value="#{pageIndex}"/>
                                                    <f:param value="#{pageCount}"/>
                                                </h:outputFormat>
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
       <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionListaUsuariosVacunacion" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgListaUsuariosVacunacion" showSummary="true"
                      errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>