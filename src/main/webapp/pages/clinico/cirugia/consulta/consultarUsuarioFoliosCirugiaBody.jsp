<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="consultarFoliosCirugiaForm">
    <a4j:region id="bodyRegionFoliosCirugia">
        <a4j:status for="bodyRegionFoliosCirugia">
            <f:facet name="start">
                <t:div id="chargindFoliosCirugia" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridFoliosCirugiaTab"
                     styleClass="tabContainer">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableFoliosCirugiaTabs"
                         styleClass="tabContainer">
                <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                                   activePanelTabVar="true" width="100%" id="tabConFoliosCirugia"
                                   styleClass="tabbedPane" activeTabStyleClass="activeTab"
                                   inactiveTabStyleClass="inactiveTab"
                                   selectedIndex="#{consultarUsuariosFoliosCirugiaBean.selectedIndex}"
                                   disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                                   inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                    <t:panelTab id="panelConFoliosCirugia" label="Consultar Folios Cirugia"
                                rendered="#{!consultarUsuariosFoliosCirugiaBean.renderBuscador}">
                        <s:fieldset legend="Datos Paciente" id="fieldDatosFoliosCirugia" styleClass="fieldset">
                            <h:panelGrid columns="4" border="0" cellpadding="0" width="100%"
                                         id="tableContentListaConFoliosCirugia" rowClasses="labelText,labelTextInfo">
                                <h:outputText value="Número Usuario" styleClass="labelTextOblig"/>
                                <h:panelGroup>
                                    <h:outputText value="Nombre" styleClass="labelTextOblig"
                                                  rendered="#{consultarUsuariosFoliosCirugiaBean.renderInformacionUsuario}"/>
                                </h:panelGroup>
                                <h:panelGroup>
                                    <h:outputText value="Tipo Documento" styleClass="labelTextOblig"
                                                  rendered="#{consultarUsuariosFoliosCirugiaBean.renderInformacionUsuario}"/>
                                </h:panelGroup>
                                <h:panelGroup>
                                    <h:outputText value="Numero Documento" styleClass="labelTextOblig"
                                                  rendered="#{consultarUsuariosFoliosCirugiaBean.renderInformacionUsuario}"/>
                                </h:panelGroup>
                                <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                                             columnClasses="labelTextInfo">
                                    <a4j:commandLink action="#{consultarUsuariosFoliosCirugiaBean.mostrarBuscadorUsuarios}"
                                                     immediate="true" reRender="tableFoliosCirugiaTabs">
                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                        <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                                    </a4j:commandLink>
                                    <h:inputText id="idNumeroUsuario" maxlength="15" style="width:80px" immediate="true"
                                                 value="#{consultarUsuariosFoliosCirugiaBean.numeroUsuario}"
                                                 valueChangeListener="#{consultarUsuariosFoliosCirugiaBean.setNumeroUsuario}"
                                                 binding="#{consultarUsuariosFoliosCirugiaBean.itNumeroUsuario}"
                                                 onkeydown="return blockEnter(event);">
                                        <a4j:support id="supportNumUsuarioMedico" event="onchange"
                                                     ignoreDupResponses="true"
                                                     action="#{consultarUsuariosFoliosCirugiaBean.changeUsuario}"
                                                     reRender="tableFoliosCirugiaTabs">
                                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                        </a4j:support>
                                    </h:inputText>
                                    <a4j:outputPanel ajaxRendered="true">
                                        <t:message for="idNumeroUsuario" styleClass="errorMessage"/>
                                    </a4j:outputPanel>
                                </h:panelGrid>
                                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2"
                                             id="panelNombreUsuarioMedico">
                                    <h:outputText value=" #{consultarUsuariosFoliosCirugiaBean.nombreUsuario}"
                                                  styleClass="buscador"/>
                                </h:panelGrid>
                                <h:outputText value="#{consultarUsuariosFoliosCirugiaBean.usuario.husetipoiden}"/>
                                <h:outputText value="#{consultarUsuariosFoliosCirugiaBean.usuario.husanumeiden}"/>
                                <h:panelGroup>
                                    <h:outputText value="Fecha de Nacimiento" styleClass="labelTextOblig"
                                                  rendered="#{consultarUsuariosFoliosCirugiaBean.renderInformacionUsuario}"/>
                                </h:panelGroup>
                                <h:outputText value="Edad" styleClass="labelTextOblig"
                                              rendered="#{consultarUsuariosFoliosCirugiaBean.renderInformacionUsuario}"/>
                                <h:panelGroup>
                                    <h:outputText value="Sexo"
                                                  rendered="#{consultarUsuariosFoliosCirugiaBean.renderInformacionUsuario}"
                                                  styleClass="labelTextOblig"/>
                                </h:panelGroup>
                                <h:panelGroup>
                                    <h:outputText value="Estado Civil" styleClass="labelTextOblig"
                                                  rendered="#{consultarUsuariosFoliosCirugiaBean.renderInformacionUsuario}"/>
                                </h:panelGroup>
                                <h:outputText value="#{consultarUsuariosFoliosCirugiaBean.usuario.husdfechanacim}"/>
                                <h:outputText value="#{consultarUsuariosFoliosCirugiaBean.usuario.edad}"/>
                                <h:panelGroup>
                                    <h:selectOneMenu id="radioSexoFoliosCirugia" disabled="true"
                                                     rendered="#{consultarUsuariosFoliosCirugiaBean.renderInformacionUsuario}"
                                                     value="#{consultarUsuariosFoliosCirugiaBean.usuario.husesexo}">
                                        <f:selectItems value="#{consultarUsuariosFoliosCirugiaBean.listSexos}"/>
                                    </h:selectOneMenu>
                                </h:panelGroup>
                                <h:panelGroup>
                                    <h:selectOneMenu id="radioEstadoCivilFoliosCirugia" disabled="true"
                                                     rendered="#{consultarUsuariosFoliosCirugiaBean.renderInformacionUsuario}"
                                                     value="#{consultarUsuariosFoliosCirugiaBean.usuario.huseestadcivil}">
                                        <f:selectItems value="#{consultarUsuariosFoliosCirugiaBean.listEstadoCivil}"/>
                                    </h:selectOneMenu>
                                </h:panelGroup>
                            </h:panelGrid>
                            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                         id="panelBotonConsultaFoliosCirugia" columnClasses="panelGridBotones">
                                <h:panelGroup>
                                    <a4j:outputPanel id="ajaxRegionMessagesFoliosCirugia" ajaxRendered="true">
                                        <t:htmlTag value="br"/>
                                        <t:message for="idButtonBuscarFoliosCirugia" id="msgFoliosCirugia"
                                                   errorClass="error" infoClass="informacion"/>
                                    </a4j:outputPanel>
                                </h:panelGroup>
                                <a4j:commandButton value="Consultar"
                                                   action="#{consultarUsuariosFoliosCirugiaBean.consultarRegistros}"
                                                   reRender="fieldSetListaFoliosCirugia" styleClass="btn btn btn-success"
                                                   id="idButtonBuscarFoliosCirugia"/>
                            </h:panelGrid>
                        </s:fieldset>
                        <s:fieldset legend="Imprimir Folios Cirugia" id="fieldSetListaFoliosCirugia"
                                    styleClass="fieldset_dataTable">
                            <h:panelGrid columns="1" id="panelGridFoliosCirugia"
                                         rendered="#{empty consultarUsuariosFoliosCirugiaBean.lstFolios}">
                                <h:outputText value="#{msg.msg_sin_consultar}"/>
                            </h:panelGrid>
                            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                         id="tableContentTabsFoliosCirugia"
                                         rendered="#{not empty consultarUsuariosFoliosCirugiaBean.lstFolios}"
                                         styleClass="tabContainer">
                               
                                    <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                                                 binding="#{consultarUsuariosFoliosCirugiaBean.dtFoliosCirugia}"
                                                 value="#{consultarUsuariosFoliosCirugiaBean.lstFolios}" rows="10"
                                                 styleClass="standard_table"
                                                 rowClasses="standardTable_Row1,standardTable_Row2"
                                                 footerClass="paginacion" id="dtFoliosCirugia">
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="Fecha Registro"/>
                                            </f:facet>
                                            <h:outputText value="#{item.hcodfecregistr}"/>
                                        </h:column>
                                        
                                         <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="Numero Cirugia"/>
                                            </f:facet>
                                            <h:outputText value="#{item.hcolnumero}"/>
                                        </h:column>
                                        
                                          <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="Cirugia Principal"/>
                                            </f:facet>
                                            <h:outputText value="#{item.hcocservicio.csvcnombre}"/>
                                        </h:column>
                                        
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="seleccionar"/>
                                            </f:facet>
                                            <h:commandLink id="imprimirDescripcion" immediate="true"
                                                           action="#{consultarUsuariosFoliosCirugiaBean.generar}">
                                                <t:graphicImage alt="" border="0" url="/comun/imagenes/LastThreeMonths.png"/>
                                            </h:commandLink>
                                        </h:column>
                                    </h:dataTable>
                                
                               
                                    <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                                        <t:dataScroller id="scroll_DetalleDescripcionQuirurgica" for="dtFoliosCirugia"
                                                        fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex"
                                                        styleClass="scroller" paginator="true" immediate="true"
                                                        paginatorMaxPages="9" paginatorTableClass="paginator"
                                                        renderFacetsIfSinglePage="false"
                                                        paginatorActiveColumnStyle="font-weight:bold;">
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
                              
                                <h:outputText value="#{tableScroller}" escape="false"/>
                                <h:outputText value="#{table}" escape="false"/>
                                <h:outputText value="#{tableScroller}" escape="false"/>
                            </h:panelGrid>
                        </s:fieldset>
                        <h:panelGrid>
                            <h:commandLink action="#{consultarUsuariosFoliosCirugiaBean.volverConsulta}"
                                           immediate="true">
                                <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                            </h:commandLink>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab id="panelRegistrosFoliosCirugia" label="Buscar Usuarios"
                                rendered="#{consultarUsuariosFoliosCirugiaBean.renderBuscador}">
                        <a4j:region id="regionBuscadorUsuMedico" renderRegionOnly="false">
                            <a4j:status for="regionBuscadorUsuMedico">
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
                            <h:panelGrid id="panelGridBusUsuaBotMedico" width="100%"
                                         columnClasses="columnaBotonesCentrados" dir="RTL">
                                <t:htmlTag value="br"/>
                                <h:panelGroup id="panelGroupBusUsuBotMedico">
                                    <h:commandButton value="Aceptar Usuario" styleClass="btn btn btn-success"
                                                     action="#{consultarUsuariosFoliosCirugiaBean.aceptarUsuario}">
                                        <a4j:support event="onclick" status="statusButton"/>
                                    </h:commandButton>
                                </h:panelGroup>
                            </h:panelGrid>
                        </a4j:region>
                    </t:panelTab>
                </t:panelTabbedPane>
            </h:panelGrid>
            <h:panelGrid>
                <h:panelGroup id="msgModificarFoliosCirugia">
                    <a4j:outputPanel id="ajaxRegionMessagesFoliosCirugia" ajaxRendered="true">
                        <t:htmlTag value="br"/>
                        <t:messages id="msgInformationAndErrorsFoliosCirugia" showSummary="true" errorClass="error"
                                    globalOnly="true" layout="table" infoClass="informacion"/>
                    </a4j:outputPanel>
                </h:panelGroup>
            </h:panelGrid>
        </h:panelGrid>
        
    </a4j:region>
</a4j:form>