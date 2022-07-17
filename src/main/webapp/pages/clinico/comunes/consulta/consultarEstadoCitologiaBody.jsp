<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="consultarEstadoCitologiaForm">
    <a4j:region id="bodyRegionEstadoCitologia">
        <a4j:status id = "statusButton" for="bodyRegionEstadoCitologia">
            <f:facet name="start">
                <t:div id="chargindConsultarEstadoCitologia" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
      
        <h:panelGrid columns="1" id="tableConsultarEstadoCitologia" border="0" cellpadding="0" cellspacing="0"
                     width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
            <h:outputText value="Consultar Estado de la Citologia " id="infoUbicationEstadoCitologia"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableEstadoCitologiaTabs"
                     styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxFoliosEstadoCitologia" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgFoliosEstadoCitologia" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabConEstadoCitologia" styleClass="tabbedPane"
                               activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                               selectedIndex="#{consultarEstadoCitologiaBean.selectedIndex}"
                               disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                               inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                <t:panelTab id="panelConFoliosEstadoCitologia" label="Consultas Citologias"
                            rendered="#{!consultarEstadoCitologiaBean.renderBuscador}">
                    <s:fieldset legend="Datos Paciente" id="fieldDatosEstadoCitologia" styleClass="fieldset">
                        <h:panelGrid columns="4" border="0" cellpadding="0" width="100%"
                                     id="tableContentListaConEstadoCitologia" rowClasses="labelText,labelTextInfo">
                            <h:outputText value="Número Usuario" styleClass="labelTextOblig"/>
                            <h:panelGroup>
                                <h:outputText value="Nombre" styleClass="labelTextOblig"
                                              rendered="#{consultarEstadoCitologiaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Tipo Documento" styleClass="labelTextOblig"
                                              rendered="#{consultarEstadoCitologiaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Numero Documento" styleClass="labelTextOblig"
                                              rendered="#{consultarEstadoCitologiaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                                         columnClasses="labelTextInfo">
                                <a4j:commandLink action="#{consultarEstadoCitologiaBean.mostrarBuscadorUsuarios}"
                                                 immediate="true" reRender="tableEstadoCitologiaTabs">
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                                </a4j:commandLink>
                                <h:inputText id="idtipoEstadoCitologia" maxlength="15" style="width:80px"
                                             immediate="true" value="#{consultarEstadoCitologiaBean.numeroUsuario}"
                                             valueChangeListener="#{consultarEstadoCitologiaBean.setNumeroUsuario}"
                                             binding="#{consultarEstadoCitologiaBean.itNumeroUsuario}"
                                             onkeydown="return blockEnter(event);">
                                    <a4j:support id="supportNumUsuarioEstadoCitologia" event="onchange"
                                                 ignoreDupResponses="true"
                                                 action="#{consultarEstadoCitologiaBean.changeUsuario}"
                                                 reRender="tableEstadoCitologiaTabs,fieldSetEstadoCitologia">
                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    </a4j:support>
                                </h:inputText>
                                <a4j:outputPanel ajaxRendered="true">
                                    <t:message for="idtipoEstadoCitologia" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                            </h:panelGrid>
                            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2"
                                         id="panelNombreUsuarioidtipoEstadoCitologia">
                                <h:outputText value=" #{consultarEstadoCitologiaBean.nombreUsuario}"
                                              styleClass="buscador"/>
                            </h:panelGrid>
                            <h:outputText value="#{consultarEstadoCitologiaBean.usuario.husetipoiden}"/>
                            <h:outputText value="#{consultarEstadoCitologiaBean.usuario.husanumeiden}"/>
                            <h:panelGroup>
                                <h:outputText value="Fecha de Nacimiento" styleClass="labelTextOblig"
                                              rendered="#{consultarEstadoCitologiaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="Edad" styleClass="labelTextOblig"
                                          rendered="#{consultarEstadoCitologiaBean.renderInformacionUsuario}"/>
                            <h:panelGroup>
                                <h:outputText value="Sexo"
                                              rendered="#{consultarEstadoCitologiaBean.renderInformacionUsuario}"
                                              styleClass="labelTextOblig"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Estado Civil" styleClass="labelTextOblig"
                                              rendered="#{consultarEstadoCitologiaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="#{consultarEstadoCitologiaBean.usuario.husdfechanacim}"/>
                            <h:outputText value="#{consultarEstadoCitologiaBean.usuario.edad}"/>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioSexoEstadoCitologia" disabled="true"
                                                 rendered="#{consultarEstadoCitologiaBean.renderInformacionUsuario}"
                                                 value="#{consultarEstadoCitologiaBean.usuario.husesexo}">
                                    <f:selectItems value="#{consultarEstadoCitologiaBean.listSexos}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioEstadoCivilEstadoCitologia" disabled="true"
                                                 rendered="#{consultarEstadoCitologiaBean.renderInformacionUsuario}"
                                                 value="#{consultarEstadoCitologiaBean.usuario.huseestadcivil}">
                                    <f:selectItems value="#{consultarEstadoCitologiaBean.listEstadoCivil}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="panelBotonEstadoCitologia" columnClasses="panelGridBotones">
                            <h:panelGroup>
                                <a4j:outputPanel id="ajaxRegionMessagesFoliosMedico" ajaxRendered="true">
                                    <t:htmlTag value="br"/>
                                    <t:message for="idButtonBuscarHistoriaCitologia" id="msgEstadoCitologia"
                                               errorClass="error" infoClass="informacion"/>
                                </a4j:outputPanel>
                            </h:panelGroup>
                            <a4j:commandButton value="Consultar Citolgias"
                                               action="#{consultarEstadoCitologiaBean.consultarCitologiasUsuario}"
                                               reRender="fieldSetEstadoCitologia" styleClass="btn btn btn-success"
                                               id="idButtonBuscarHistoriaCitologia"/>
                        </h:panelGrid>
                    </s:fieldset>
                    
                    
                    
     <s:fieldset legend="Resultados Consulta" id="fieldSetEstadoCitologia" styleClass="fieldset_dataTable">
        <h:panelGrid columns="1" id="panelGridEstadoCitologia"
                     rendered="#{empty consultarEstadoCitologiaBean.lstCitologiaUsuario}">
          <h:outputText value="#{msg.msg_sin_consultar}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
                    id="tableContentTabsBucarEstadoCitologia"
                     rendered="#{not empty consultarEstadoCitologiaBean.lstCitologiaUsuario}" 
                        styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                             value="#{consultarEstadoCitologiaBean.lstCitologiaUsuario}" rows="10" styleClass="standard_table"
                         binding="#{consultarEstadoCitologiaBean.dtEstadoCitologia}"
                         rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtBucarEstadoCitologia">
                         
            <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha Toma"/>
                </f:facet>
                <h:outputText value="#{item[8]}"/>
              </h:column>   
              
              
            <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha Registro Lectura"/>
                </f:facet>
                <h:outputText value="#{item[9]}"/>
              </h:column>   
              
                  <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha de Entrega"/>
                </f:facet>
                <h:outputText value="#{item[10]}"/>
              </h:column>
                         
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Consecutivo"/>
                </f:facet>
                <h:outputText value="#{item[0]}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Número Citologia"/>
                </f:facet>
                <h:outputText value="#{item[1]}"/>
              </h:column>
              
          
        
              <h:column>
                <f:facet name="header">
                  <h:outputText value="ver detalle"/>
                </f:facet>
                <h:commandLink id="atender" action="#{consultarEstadoCitologiaBean.consultarEstadoCitologia}">
                  <t:graphicImage alt=""  border="0" url="/comun/imagenes/lupa.gif"/>
                </h:commandLink>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_Copia" for="dtBucarEstadoCitologia" fastStep="10" pageCountVar="pageCount"
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
                    
                    
                    
                    <h:panelGrid>
                        <h:commandLink action="#{consultarEstadoCitologiaBean.volverConsulta}" immediate="true">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                        </h:commandLink>
                    </h:panelGrid>
                </t:panelTab>
                <t:panelTab id="panelEstadoCitologia" label="Buscar Usuarios"
                            rendered="#{consultarEstadoCitologiaBean.renderBuscador}">
                    <a4j:region id="regionBuscadorUsuEstadoCitologia" renderRegionOnly="false">
                        <a4j:status for="regionBuscadorUsuEstadoCitologia">
                            <f:facet name="start">
                                <t:div id="chargingBuscUsuMedico" styleClass="loading">
                                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                                        <h:outputText value="Procesando..."/>
                                        <h:outputText value="Por favor espere."/>
                                    </h:panelGrid>
                                </t:div>
                            </f:facet>
                            <f:facet name="stop"/>
                        </a4j:status>
                        <jsp:include page="/pages/clinico/comunes/buscador/buscadorUsuarios.jsp" flush="true"/>
                        <h:panelGrid id="panelGridBusUsuaBotEstadoCitologia" width="100%"
                                     columnClasses="columnaBotonesCentrados" dir="RTL">
                            <t:htmlTag value="br"/>
                            <h:panelGroup id="panelGroupBusUsuBotEstadoCitologia">
                                <h:commandButton value="Aceptar Usuario" styleClass="btn btn btn-success"
                                                 action="#{consultarEstadoCitologiaBean.aceptarUsuario}">
                                                  <a4j:support event="onclick" status="statusButton"/>
                                                 </h:commandButton>
                            </h:panelGroup>
                        </h:panelGrid>
                    </a4j:region>
                </t:panelTab>
            </t:panelTabbedPane>
        </h:panelGrid>
        <h:panelGrid>
            <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMsgEstadoCitologia" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationMsgEstadoCitologia" showSummary="true" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:region>
</a4j:form>