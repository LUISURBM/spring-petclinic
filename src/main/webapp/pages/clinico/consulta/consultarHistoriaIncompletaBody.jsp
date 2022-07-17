<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="consultarHistoriaIncompletoForm">
    <a4j:region id="bodyRegionHistoriaIncompleto">
        <a4j:status id="statusButton" for="bodyRegionHistoriaIncompleto">
            <f:facet name="start">
                <t:div id="chargindConsultarFolioIncompleto" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
         
        <h:panelGrid columns="1" id="tableConsultarFolioIncompleto" border="0" cellpadding="0" cellspacing="0"
                     width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
            <h:outputText value="Consultar Historias Incompletos " id="infoUbicationIncompleto"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableFolioIncompletosTabs" styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxFoliosIncompletos" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgFoliosIncompletos" showSummary="false" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion" showDetail="true"
                                tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabConFoliosIncompletos"
                               styleClass="tabbedPane" activeTabStyleClass="activeTab"
                               inactiveTabStyleClass="inactiveTab" 
                               selectedIndex="#{consultarFoliosBean.selectedIndex}"
                               disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                               inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                <t:panelTab id="panelConFoliosIncompletos" label="Consultar Folios Incompletos"
                            rendered="#{!consultarFoliosBean.renderBuscador}">
                   
                    <s:fieldset legend="Datos Paciente" id="fieldDatosFoliosIncompletos"
                                styleClass="fieldset">
                        <h:panelGrid columns="4" border="0" cellpadding="0" width="100%"
                                     id="tableContentListaConFoliosIncompletos"
                                     rowClasses="labelText,labelTextInfo">
                            <h:outputText value="N�mero Usuario" styleClass="labelTextOblig"/>
                            <h:panelGroup>
                                <h:outputText value="Nombre" styleClass="labelTextOblig"
                                              rendered="#{consultarFoliosBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Tipo Documento" styleClass="labelTextOblig"
                                              rendered="#{consultarFoliosBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Numero Documento" styleClass="labelTextOblig"
                                              rendered="#{consultarFoliosBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                                         columnClasses="labelTextInfo">
                                <a4j:commandLink action="#{consultarFoliosBean.mostrarBuscadorUsuarios}"
                                                 immediate="true" reRender="tableFolioIncompletosTabs">
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                                </a4j:commandLink>
                                <h:inputText id="idtipoAnulaIncompletos" maxlength="15" style="width:80px" immediate="true"
                                             value="#{consultarFoliosBean.numeroUsuario}"
                                             valueChangeListener="#{consultarFoliosBean.setNumeroUsuario}"
                                             binding="#{consultarFoliosBean.itNumeroUsuario}"
                                             onkeydown="return blockEnter(event);">
                                    <a4j:support id="supportNumUsuarioIncompleto" 
                                                 event="onchange" ignoreDupResponses="true"
                                                 action="#{consultarFoliosBean.changeUsuario}"
                                                 reRender="tableFolioIncompletosTabs">
                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    </a4j:support>
                                </h:inputText>
                                <a4j:outputPanel ajaxRendered="true">
                                    <t:message for="idtipoAnulaIncompletos" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                            </h:panelGrid>
                            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelNombreUsuarioIncompleto">
                                <h:outputText value=" #{consultarFoliosBean.nombreUsuario}" styleClass="buscador"/>
                            </h:panelGrid>
                            <h:outputText value="#{consultarFoliosBean.usuario.husetipoiden}"/>
                            <h:outputText value="#{consultarFoliosBean.usuario.husanumeiden}"/>
                            <h:panelGroup>
                                <h:outputText value="Fecha de Nacimiento" styleClass="labelTextOblig"
                                              rendered="#{consultarFoliosBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="Edad" styleClass="labelTextOblig"
                                          rendered="#{consultarFoliosBean.renderInformacionUsuario}"/>
                            <h:panelGroup>
                                <h:outputText value="Sexo" rendered="#{consultarFoliosBean.renderInformacionUsuario}"
                                              styleClass="labelTextOblig"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Estado Civil" styleClass="labelTextOblig"
                                              rendered="#{consultarFoliosBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="#{consultarFoliosBean.usuario.husdfechanacim}"/>
                            <h:outputText value="#{consultarFoliosBean.usuario.edad}"/>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioSexoIncompleto" disabled="true"
                                                 rendered="#{consultarFoliosBean.renderInformacionUsuario}"
                                                 value="#{consultarFoliosBean.usuario.husesexo}">
                                    <f:selectItems value="#{consultarFoliosBean.listSexos}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                            
                            <h:panelGroup>
                                <h:selectOneMenu id="radioEstadoCivilFoliosIncompleto" disabled="true"
                                                 rendered="#{consultarFoliosBean.renderInformacionUsuario}"
                                                 value="#{consultarFoliosBean.usuario.huseestadcivil}">
                                    <f:selectItems value="#{consultarFoliosBean.listEstadoCivil}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="panelBotonConsultaIncompleto" columnClasses="panelGridBotones">
                            <h:panelGroup>
                                <a4j:outputPanel id="ajaxRegionMessagesFoliosIncompleto" ajaxRendered="true">
                                    <t:htmlTag value="br"/>
                                    <t:message for="idButtonBuscarHistoriaIncompleto" id="msgFoliosIncompleto"
                                               errorClass="error" infoClass="informacion"/>
                                </a4j:outputPanel>
                            </h:panelGroup>
                            <a4j:commandButton value="Consultar Folios Incompletos"
                                               action="#{consultarFoliosBean.ConsultarFoliosIncompletos}"
                                               reRender="fieldSetConsultarFolioIncompleto"
                                               styleClass="btn btn btn-success" id="idButtonBuscarHistoriaIncompleto"/>
                        </h:panelGrid>
                    </s:fieldset>
                
           <s:fieldset legend="Resumen Folio" id="fieldCerrarFolioMedico" styleClass="fieldset"
                        rendered="#{consultarFoliosBean.renderFolio}">
                <a4j:region renderRegionOnly="false">
                    <h:panelGrid id="panelGridFoliosMedicoVisualizar" width="100%"
                                 rendered="#{consultarFoliosBean.renderFolio}" styleClass="tabContainerResumen"
                                 dir="LTR">
                        <jsp:include page="/pages/clinico/consulta/mostrarHistoriaConsulta.jsp" flush="true"/>
                    </h:panelGrid>
                </a4j:region>
            </s:fieldset>
                    
                    
                    <s:fieldset legend="Resultados Consulta" id="fieldSetConsultarFolioIncompleto"
                                styleClass="fieldset_dataTable">
                        <h:panelGrid columns="1" id="panelGridConsultarFoliosIncompleto"
                                     rendered="#{empty consultarFoliosBean.lstFolios}">
                            <h:outputText value="#{msg.msg_sin_consultar}"/>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="tableContentTabsBucarIncompleto" rendered="#{not empty consultarFoliosBean.lstFolios}"
                                     styleClass="tabContainer">
                            <t:buffer into="#{table}">
                                <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                                             binding="#{consultarFoliosBean.dtFolios}"
                                             value="#{consultarFoliosBean.lstFolios}" rows="10"
                                             styleClass="standard_table"
                                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                                             id="dtBucarFoliosIncompleto">
                                    <h:column id="column1FoliosIncompleto">
                                        <f:facet name="header">
                                            <h:outputText value="Fecha"/>
                                        </f:facet>
                                        <h:outputText value="#{item.hcodfecregistr}"/>
                                    </h:column>
                                    
                                     <h:column id="column2FoliosIncompleto">
                                        <f:facet name="header">
                                            <h:outputText value="N�mero consulta"/>
                                        </f:facet>
                                        <h:outputText value="#{item.hcolnumero}"/>
                                    </h:column>
                                    
                                    
                                    <h:column id="column3FoliosIncompleto">
                                        <f:facet name="header">
                                            <h:outputText value="Numero Usuario"/>
                                        </f:facet>
                                        <h:outputText value="#{item.hcolusuario.huslnumero}"/>
                                    </h:column>
                                    <h:column id="column4FoliosIncompleto">
                                        <f:facet name="header">
                                            <h:outputText value="Servicio"/>
                                        </f:facet>
                                        <h:outputText value="#{item.hcocservicio.csvcnombre}"/>
                                    </h:column>
                                    <h:column id="column5FoliosIncompleto">
                                        <f:facet name="header" >
                                            <h:outputText value="Visualizar"/>
                                        </f:facet>
                                        <h:commandLink id="visualizarFoliosIncompleto" action="#{consultarFoliosBean.visualizarConsultaFolio}">
                                            <t:graphicImage alt="" border="0" url="/comun/imagenes/PatientFile.png"/>
                                        </h:commandLink>
                                    </h:column>
                                </h:dataTable>
                            </t:buffer>
                            <t:buffer into="#{tableScroller}">
                                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                                    <t:dataScroller id="scroll_folios_Incompleto" for="dtBucarFoliosIncompleto" fastStep="10"
                                                    pageCountVar="pageCount" pageIndexVar="pageIndex"
                                                    styleClass="scroller" paginator="true" immediate="true"
                                                    paginatorMaxPages="9" paginatorTableClass="paginator"
                                                    renderFacetsIfSinglePage="false"
                                                    paginatorActiveColumnStyle="font-weight:bold;">
                                        <f:facet name="first">
                                            <t:graphicImage alt="" url="/comun/imagenes/primero.gif" border="0"/>
                                        </f:facet>
                                        <f:facet name="last">
                                            <t:graphicImage alt="" url="/comun/imagenes/ultimo.gif" border="0"/>
                                        </f:facet>
                                        <f:facet name="previous">
                                            <t:graphicImage alt="" url="/comun/imagenes/anterior.gif" border="0"/>
                                        </f:facet>
                                        <f:facet name="next">
                                            <t:graphicImage alt="" url="/comun/imagenes/siguiente.gif" border="0"/>
                                        </f:facet>
                                        <f:facet name="fastforward">
                                            <t:graphicImage alt="" url="/comun/imagenes/adelante.gif" border="0"/>
                                        </f:facet>
                                        <f:facet name="fastrewind">
                                            <t:graphicImage alt="" url="/comun/imagenes/atras.gif" border="0"/>
                                        </f:facet>
                                    </t:dataScroller>
                                </h:panelGrid>
                            </t:buffer>
                            <h:outputText value="#{tableScroller}" escape="false"/>
                            <h:outputText value="#{table}" escape="false"/>
                            <h:outputText value="#{tableScroller}" escape="false"/>
                        </h:panelGrid>
                    </s:fieldset>
               <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
               id="tableTabVisFolioIncompleto" styleClass="tabContainerResumen">
          
           </h:panelGrid>
           
           
         
                    <h:panelGrid>
                        <h:commandLink action="#{consultarFoliosBean.volverConsulta}" immediate="true">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                        </h:commandLink>
                    </h:panelGrid>
                </t:panelTab>
                <t:panelTab id="panelFoliosIncompleto" label="Buscar Usuarios"
                            rendered="#{consultarFoliosBean.renderBuscador}">
                    <a4j:region id="regionBuscadorUsuIncompleto" renderRegionOnly="false">
                        <a4j:status for="regionBuscadorUsuIncompleto">
                            <f:facet name="start">
                                <t:div id="chargingBuscUsuIncompleto" styleClass="loading">
                                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                                        <h:outputText value="Procesando..."/>
                                        <h:outputText value="Por favor espere."/>
                                    </h:panelGrid>
                                </t:div>
                            </f:facet>
                            <f:facet name="stop"/>
                        </a4j:status>
                        <jsp:include page="/pages/clinico/comunes/buscador/buscadorUsuarios.jsp" flush="true"/>
                        <h:panelGrid id="panelGridBusUsuaBotIncompleto" width="100%"
                                     columnClasses="columnaBotonesCentrados" dir="RTL">
                            <t:htmlTag value="br"/>
                            <h:panelGroup id="panelGroupBusUsuBotIncompleto">
                                <h:commandButton value="Aceptar Usuario" styleClass="btn btn btn-success"
                                                 action="#{consultarFoliosBean.aceptarUsuario}">
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
                <a4j:outputPanel id="ajaxRegionMsgFolioIncompleto" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationMsgFolioIncompleto" showSummary="true" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
            </h:panelGroup>
        </h:panelGrid>
        <f:subview id="generarFoliosIncompleto" rendered="#{consultarFoliosBean.generoHistoria}">
            <f:verbatim>
                <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
            </f:verbatim>
        </f:subview>
    </a4j:region>
    
    
</a4j:form>