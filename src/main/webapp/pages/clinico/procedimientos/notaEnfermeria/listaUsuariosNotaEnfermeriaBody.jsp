<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="ajax"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<a4j:form id="formLstUsuariosNotaEnfermeria">
  <a4j:region id="regionLstUsuariosNotaEnfermeria" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionLstUsuariosNotaEnfermeria">
      <t:div id="chargingLstUsuariosNotaEnfermeria" styleClass="loading">
        <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
          <h:outputText value="Procesando..."/>
          <h:outputText value="Por favor espere."/>
        </h:panelGrid>
      </t:div>
    </a4j:status>
    <h:panelGrid columns="1" id="tableInfoUbication" border="0" cellpadding="0" cellspacing="0" width="100%"
                 columnClasses="td_ubicador">
      <h:outputText value="HISTORIAS CLINICAS >> Registro de Historias >> Todas las consultas " id="infoUbication"/>
    </h:panelGrid>
     <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionLstUsuariosNotaEnfermeria2" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgLstUsuariosNotaEnfermeria2" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsLstUsuariosNotaEnfermeria"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="tabbedPaneLstUsuariosNotaEnfermeria" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <s:fieldset legend="Busqueda Consulta" id="fieldDatosConsulta" styleClass="fieldset">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="10" width="100%"
                       id="tableContentTabsBusqueda" columnClasses="labelText,labelTextInfo">
            <h:outputText value="Doctor(a): "/>
            <h:outputText id="otnomDoctor" value="#{listaUsuarioNotaEnfermeriaBean.usuarioSystem.curcnombre}"/>
            <h:outputText value=" "/>
            <h:outputText value=" "/>
            <h:outputText value="Fecha Consulta: "/>
            <a4j:region renderRegionOnly="false">
              <t:inputCalendar id="fechaConsulta" title="Formato: dd/MM/yyyy" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{listaUsuarioNotaEnfermeriaBean.fechaActual}" popupTodayString="Hoy" popupWeekString="Semana"
                               popupButtonString="Fecha" readonly="false" disabled="false" maxlength="11" size="11"
                               immediate="true" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top"
                               valueChangeListener="#{listaUsuarioNotaEnfermeriaBean.setFechaActual}" required="true">
                <a4j:support id="supportmnuLis" event="onchange" action="#{listaUsuarioNotaEnfermeriaBean.buscarConsultas}"
                             reRender="formLstUsuariosNotaEnfermeria">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </t:inputCalendar>
            </a4j:region>
            <h:outputText value=" "/>
            <h:outputText value=" "/>
          </h:panelGrid>
                      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
          <h:outputText value=" N?mero Identificaci?n" rendered="#{listaUsuarioNotaEnfermeriaBean.busquedaXCedula}"/>
          <h:outputText/>
                   <h:inputText id="itNumeroIdentificacion" maxlength="15" onkeypress="searchByEnterAndReturn(event)"
                               rendered="#{listaUsuarioNotaEnfermeriaBean.busquedaXCedula}"
                               value="#{listaUsuarioNotaEnfermeriaBean.numeroIdentificacion}"
                               onkeydown="return blockEnter(event);"/>
                               <a4j:commandButton value="Buscar" id="BtnBuscar"
                                     rendered="#{listaUsuarioNotaEnfermeriaBean.busquedaXCedula}"
                                     action="#{listaUsuarioNotaEnfermeriaBean.buscarConsultas}"
                                     image="/comun/imagenes/lupita.png"
                                     reRender="formLstUsuariosNotaEnfermeria"/>
                   
                </h:panelGrid>
        </s:fieldset>
        <t:panelTab id="panelTabLstUsuariosNotaEnfermeria" label="Lista de Consultas">
          <t:htmlTag value="br"/>
          <s:fieldset legend="Consultas Libres" id="fieldAsesoria" styleClass="fieldset">
            <h:panelGrid columns="1" id="panelGridNoConsultas" rendered="#{!listaUsuarioNotaEnfermeriaBean.existeConsulta}">
              <h:outputText value="#{listaUsuarioNotaEnfermeriaBean.msg_sin_registros}"/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabs"
                         rendered="#{listaUsuarioNotaEnfermeriaBean.existeConsulta}" styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                             binding="#{listaUsuarioNotaEnfermeriaBean.dtConsultas}" value="#{listaUsuarioNotaEnfermeriaBean.lstUsuarios}"
                             styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                             footerClass="paginacion" rows="20" id="idDtConsultas">
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Consulta"/>
                        </f:facet>
                        <h:outputText value="#{item.cconnumero}"/>
                    </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Hora"/>
                    </f:facet>
                    <h:outputText value="#{item.horaRegi}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Identificaci?n"/>
                    </f:facet>
                    <h:outputText value="#{item.ccoctipide} #{item.ccoanumide}"/>
                  </h:column>
                   
                     <h:column>
                  <f:facet name="header">
                    <h:outputText value="Como desea ser llamado"/>
                  </f:facet>
                  <h:outputText value="#{item.ccocprinom} #{item.ccocpriape}"/>
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
                      <h:outputText value="Contrato"/>
                    </f:facet>
                    <h:outputText value="#{item.cconcontra}"/>
                  </h:column>

                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Atender"/>
                    </f:facet>
                    <t:commandLink id="atender" action="#{listaUsuarioNotaEnfermeriaBean.atenderUsuario}">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/editar.gif"/>
                    </t:commandLink>
                  </h:column>
                  
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Cerrar nota"/>
                    </f:facet>
                    <t:commandLink id="cerrar" action="#{listaUsuarioNotaEnfermeriaBean.cierreNotaEnfermeria}" 
                                    rendered="#{item.renderCerrarIngreso}"
                                    onclick="if (!confirm(\'?Realmente desea Cerrar la Nota de Enfermeria\')) return false">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/salida.gif"/>
                    </t:commandLink>
                  </h:column>
                </h:dataTable>
              </t:buffer>
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_1" for="idDtConsultas" fastStep="10" pageCountVar="pageCount"
                                  pageIndexVar="pageIndex" styleClass="pagination" paginator="true" immediate="true"
                                  renderFacetsIfSinglePage="false" paginatorMaxPages="9" paginatorTableClass="paginator"
                                  paginatorActiveColumnStyle="font-weight:bold;"></t:dataScroller>
                  <t:dataScroller id="scroll_2" for="idDtConsultas" immediate="true" rowsCountVar="rowsCount"
                                  displayedRowsCountVar="displayedRowsCountVar" firstRowIndexVar="firstRowIndex"
                                  lastRowIndexVar="lastRowIndex" pageCountVar="pageCount" pageIndexVar="pageIndex">
                    <h:outputFormat value="Registros : Total {0}, mostrados {1} del {2} al {3}  Pagina {4} / {5}"
                                    styleClass="standard">
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
        <a4j:outputPanel id="ajaxRegionLstUsuariosNotaEnfermeria" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgLstUsuariosNotaEnfermeria" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>