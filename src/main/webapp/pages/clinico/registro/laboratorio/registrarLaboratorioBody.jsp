<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="ajax"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<a4j:form id="formRegistrarLaboratorio">
  <a4j:region id="regionListaRegistrarLaboratorio" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionListaRegistrarLaboratorio">
      <t:div id="chargingListaUsuarios" styleClass="loading">
        <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
          <h:outputText value="Procesando..."/>
          <h:outputText value="Por favor espere."/>
        </h:panelGrid>
      </t:div>
    </a4j:status>
    <h:panelGrid columns="1" id="tableInfoUbicationRegistrarLaboratorio" border="0" cellpadding="0" cellspacing="0" width="100%"
                 columnClasses="td_ubicador">
      <h:outputText value="HISTORIAS CLINICAS >> Registro de Historias >> Registrar Laboratorios " id="infoUbicationLaboratorio"/>
    </h:panelGrid>
     <h:panelGroup>
        <a4j:outputPanel id="ajaxregionListaRegistrarLaboratorio2" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgListaUsuariosLaboratorio2" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentRegistrarLaboratorio"
                 styleClass="tabContainer">
                  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="tabbedPaneListaUsuariosLaboratorio" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
         <s:fieldset legend="Laboratorios" id="fieldRegistrarLabs" styleClass="fieldset">
            <h:panelGrid columns="1" id="panelGridNoLaboratorios" rendered="#{!registrarLaboratorioBean.existeConsulta}">
              <h:outputText value="#{registrarLaboratorioBean.msg_sin_registros}"/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsLaboratorios"
                         rendered="#{registrarLaboratorioBean.existeConsulta}" styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                              value="#{registrarLaboratorioBean.lstLaboratorios}"
                             styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                             footerClass="paginacion" rows="20" id="idDtConsultasLaboratorio">
  
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Servicio"/>
                    </f:facet>
                    <h:outputText value="#{item.ccocservic.csvccodigo} #{item.ccocservic.csvcnombre}"/>
                  </h:column>
                    <h:column>
                    <f:facet name="header">
                      <h:outputText value="Atendido"/>
                    </f:facet>
                    <h:panelGroup>
                    <h:selectOneRadio id = "mnuServicioAtendido" value="#{item.servicioAtendido}" required="true">
                      <f:selectItems value = "#{registrarLaboratorioBean.lstOpciones}"/>
                    </h:selectOneRadio>
                      <a4j:outputPanel ajaxRendered="true">
                             <t:message for="mnuServicioAtendido" styleClass="errorMessage"/>
                       </a4j:outputPanel>
                    </h:panelGroup>
                  </h:column>

              
                </h:dataTable>
              </t:buffer>
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_1" for="idDtConsultasLaboratorio" fastStep="10" pageCountVar="pageCount"
                                  pageIndexVar="pageIndex" styleClass="pagination" paginator="true" immediate="true"
                                  renderFacetsIfSinglePage="false" paginatorMaxPages="9" paginatorTableClass="paginator"
                                  paginatorActiveColumnStyle="font-weight:bold;"></t:dataScroller>
                  <t:dataScroller id="scroll_2" for="idDtConsultasLaboratorio" immediate="true" rowsCountVar="rowsCount"
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
            
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonGuardarLaboratorio"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="btn btn btn-success" action="#{registrarLaboratorioBean.aceptar}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
            
          </s:fieldset>
        
        <!-- Consultas Agendadas  -->
     
      
    
      </t:panelTabbedPane>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxregionListaRegistrarLaboratorio" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgListaUsuarios" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>