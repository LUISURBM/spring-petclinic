<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="consultarHistoriaAdministradorForm">
    <a4j:region id="bodyRegionHistoriaAdministrador">
        <a4j:status id="statusButton" for="bodyRegionHistoriaAdministrador">
            <f:facet name="start">
                <t:div id="chargindConsultarFolioAdministrador" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
        <h:panelGrid columns="1" id="tableConsultarFolioAdministrador" border="0" cellpadding="0" cellspacing="0"
                     width="100%" styleClass="td_ubicador">
            <h:outputText value="Consultar Folios Usuario " id="infoUbicationAdministrador"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableconsultarFoliosAdministracionTabs" styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxconsultarFoliosAdministracion" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgconsultarFoliosAdministracion" showSummary="false" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion" showDetail="true"
                                tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabconsultarFoliosAdministracion"
                               styleClass="tabbedPane" activeTabStyleClass="activeTab"
                               inactiveTabStyleClass="inactiveTab" selectedIndex="#{consultarFoliosBean.selectedIndex}"
                               disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                               inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                <t:panelTab id="panelconsultarFoliosAdministracion" label="Imprimir Folios"
                            rendered="#{!consultarFoliosBean.renderBuscador}">
                    <t:htmlTag value="br"/>
                    <s:fieldset legend="Datos Paciente" id="fieldDatosFoliosAdministradorConsulta"
                                styleClass="fieldset">
                        <h:panelGrid columns="4" border="0" cellpadding="0" width="100%"
                                     id="tableContentTabsListaconsultarFoliosAdministracion"
                                     rowClasses="labelText,labelTextInfo">
                            <h:outputText value="N�mero Usuario" styleClass="labelTextOblig"/>
                            <h:panelGroup>
                                <h:outputText value="Nombre " styleClass="labelTextOblig"
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
                                                 immediate="true" reRender="tableconsultarFoliosAdministracionTabs">
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                                </a4j:commandLink>
                                <h:inputText id="idtipoAnula" maxlength="15" style="width:80px" immediate="true"
                                             value="#{consultarFoliosBean.numeroUsuario}"
                                             valueChangeListener="#{consultarFoliosBean.setNumeroUsuario}"
                                             binding="#{consultarFoliosBean.itNumeroUsuario}"
                                             onkeydown="return blockEnter(event);">
                                    <a4j:support id="supportitDiagPrin" event="onchange" ignoreDupResponses="true"
                                                 action="#{consultarFoliosBean.changeUsuario}"
                                                 reRender="tableContentTabsListaconsultarFoliosAdministracion,fieldSetConsultarFolioAdministrador">
                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    </a4j:support>
                                </h:inputText>
                                <a4j:outputPanel ajaxRendered="true">
                                    <t:message for="idtipoAnula" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                            </h:panelGrid>
                            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelNombreUsuario">
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
                                <h:selectOneMenu id="radioSexo" disabled="true"
                                                 rendered="#{consultarFoliosBean.renderInformacionUsuario}"
                                                 value="#{consultarFoliosBean.usuario.husesexo}">
                                    <f:selectItems value="#{consultarFoliosBean.listSexos}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioEstadoCivil" disabled="true"
                                                 rendered="#{consultarFoliosBean.renderInformacionUsuario}"
                                                 value="#{consultarFoliosBean.usuario.huseestadcivil}">
                                    <f:selectItems value="#{consultarFoliosBean.listEstadoCivil}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="panelBotonConsulta" columnClasses="panelGridBotones">
                            <h:panelGroup>
                                <a4j:outputPanel id="ajaxRegionMessagesFoliosAdministrador" ajaxRendered="true">
                                    <t:htmlTag value="br"/>
                                    <t:message for="idButtonBuscarHistoria" id="msgFoliosAdministradorSolicitud"
                                               errorClass="error" infoClass="informacion"/>
                                </a4j:outputPanel>
                            </h:panelGroup>          
                            <a4j:commandButton value="Consultar Folios"
                                               action="#{consultarFoliosBean.consultarFoliosUsuario}"
                                               reRender="fieldSetConsultarFolioAdministrador,fieldSetConsultarOtraAsesoria,
                                                         fieldSetConsultarAsesoriaAdministrador,fieldSetConsultarViniso"
                                               styleClass="btn btn btn-success" id="idButtonBuscarHistoria"/>
                        </h:panelGrid>
                    </s:fieldset>
                    <s:fieldset legend="Historia Cirugia y Procedimientos" id="fieldSetConsultarFolioAdministrador"
                                styleClass="fieldset_dataTable">
                                <h:commandLink value="Consultar Digitalizados"
                                           actionListener="#{consultarFoliosBean.openPopupClicked}"
                                           styleClass="btn btn btn-warning" id="idButtonBuscarDigitalizados">
                                </h:commandLink>
                        <h:panelGrid columns="1" id="panelGridConsultarFolios"
                                     rendered="#{empty consultarFoliosBean.lstFolios}">
                            <h:outputText value="#{msg.msg_sin_consultar}"/>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="tableContentTabsBucar" rendered="#{not empty consultarFoliosBean.lstFolios}"
                                     styleClass="tabContainer">
                            <t:buffer into="#{table}">
                                <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                                             binding="#{consultarFoliosBean.dtFolios}"
                                             value="#{consultarFoliosBean.lstFolios}" rows="10"
                                             styleClass="standard_table"
                                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                                             id="dtBucarFolios">
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Fecha"/>
                                        </f:facet>
                                        <h:outputText value="#{item.hcodfecregistr}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Numero Usuario"/>
                                        </f:facet>
                                        <h:outputText value="#{item.hcolusuario.huslnumero}"/>
                                    </h:column>
                                     <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Tipo de Documento"/>
                                        </f:facet>
                                        <h:outputText value="#{item.hcontipdoc.ctdnnumero}  #{item.hcontipdoc.ctdcdescri}"/>
                                    </h:column>
                                     <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="N�mero de Documento"/>
                                        </f:facet>
                                        <h:outputText value="#{item.hconnumdoc}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Servicio"/>
                                        </f:facet>
                                        <h:outputText value="#{item.hcocservicio.csvcnombre}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="�Por qu� requiere imprimir la historia?"/>
                                        </f:facet>
                                            <h:panelGroup>
                                                <a4j:region renderRegionOnly="false">
                                                    <h:selectOneMenu id="menuMotivo" value="#{consultarFoliosBean.motivoImpresion}" immediate="true"
                                                        valueChangeListener="#{consultarFoliosBean.setHlicmotiimpr}">
                                                        <f:selectItems value="#{consultarFoliosBean.listMotivoImpresion}"/>
                                                        <a4j:support id="supportMotivoImpresion" event="onchange"
                                                                     action="#{consultarFoliosBean.changeMotivoImpresion}"
                                                                     reRender="descripcionPanel,textDescripcion">
                                                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                                        </a4j:support>
                                                    </h:selectOneMenu>
                                                </a4j:region>
                                            </h:panelGroup>
                                            <h:panelGrid columns="2">
                                            <h:panelGroup id="textDescripcion">
                                                <h:outputText value="Motivo" rendered="#{item.renderMotivoEPS}"/>
                                                <h:outputText value="�Cual?" rendered="#{item.renderMotivoOtro}"/>
                                            </h:panelGroup>
                                             <h:outputText value=""/>
                                            <h:panelGroup id="descripcionPanel">
                                                <h:inputTextarea value="#{item.hlicmotivoeps}"
                                                                 rendered="#{item.renderMotivoEPS}" rows="5"
                                                                 style="width:500px" id="motivoEps" required="true"></h:inputTextarea>
                                                <h:inputTextarea value="#{item.hlicmotivootro}"
                                                                 rendered="#{item.renderMotivoOtro}" rows="5"
                                                                 style="width:500px" id="motivoOtro" required="true"></h:inputTextarea>
                                            </h:panelGroup>
                                            <h:panelGroup id="errorMotivos">
                                            <a4j:outputPanel id="ajaxRegionMessagesMotivoEPS" ajaxRendered="true"
                                                             rendered="#{item.renderMotivoEPS}">
                                                <t:htmlTag value="br"/>
                                                <t:message for="motivoEps" id="msgMotivoEPS" errorClass="error"
                                                           infoClass="informacion"/>
                                            </a4j:outputPanel>
                                            <a4j:outputPanel id="ajaxRegionMessagesMotivoOtro" ajaxRendered="true"
                                                             rendered="#{item.renderMotivoOtro}">
                                                <t:htmlTag value="br"/>
                                                <t:message for="motivoOtro" id="msgMotivoOtro" errorClass="error"
                                                           infoClass="informacion"/>
                                            </a4j:outputPanel>
                                        </h:panelGroup>
                                            </h:panelGrid>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Visualizar"/>
                                        </f:facet>
                                        <h:commandLink id="atender" action="#{consultarFoliosBean.ImprimirFolios}">
                                            <t:graphicImage alt="" border="0" url="/comun/imagenes/pdf.gif"/>
                                        </h:commandLink>
                                    </h:column>
                                </h:dataTable>
                            </t:buffer>
                            <t:buffer into="#{tableScroller}">
                                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                                    <t:dataScroller id="scroll_1" for="dtBucarFolios" fastStep="10"
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
                    <s:fieldset legend="Otras Asesorias" id="fieldSetConsultarOtraAsesoria"
                                styleClass="fieldset_dataTable">
                        <h:panelGrid columns="1" id="panelGridConsultarOtraAsesoria"
                                     rendered="#{empty consultarFoliosBean.lstOtrasAsesoria}">
                            <h:outputText value="#{msg.msg_sin_consultar}"/>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="tableContentTabsConsultarOtraAsesoria"
                                     rendered="#{not empty consultarFoliosBean.lstOtrasAsesoria}"
                                     styleClass="tabContainer">
                            <t:buffer into="#{table}">
                                <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                                             binding="#{consultarFoliosBean.dtConsultaOtrasAsesoria}"
                                             value="#{consultarFoliosBean.lstOtrasAsesoria}" rows="10"
                                             styleClass="standard_table"
                                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                                             id="dtBucarUsuarios">
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Fecha Asesoria"/>
                                        </f:facet>
                                        <h:outputText value="#{item.hasdfecregistr}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Numero Documento"/>
                                        </f:facet>
                                        <h:outputText value="#{item.hasetipoiden} #{item.hasanumeiden}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Nombre"/>
                                        </f:facet>
                                        <h:outputText value="#{item.hascprimernomb}  #{item.hascsegundnomb} #{item.hascprimerapel} #{item.hascsegundapel}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Edad"/>
                                        </f:facet>
                                        <h:outputText value="#{item.hasnedad}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Imprimir"/>
                                        </f:facet>
                                        <h:commandLink id="aceptarAsesoria"
                                                       action="#{consultarFoliosBean.imprimirOtraAsesoria}">
                                             <t:graphicImage alt="" border="0" url="/comun/imagenes/pdf.gif"/>
                                        </h:commandLink>
                                    </h:column>
                                </h:dataTable>
                            </t:buffer>
                            <t:buffer into="#{tableScroller}">
                                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                                    <t:dataScroller id="scroll_2" for="dtBucarUsuarios" fastStep="10"
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
                     <s:fieldset legend="Asesorias en opciones" id="fieldSetConsultarAsesoriaAdministrador"
                                styleClass="fieldset_dataTable">
                        <h:panelGrid columns="1" id="panelGridConsultarAsesoria"
                                     rendered="#{empty consultarFoliosBean.lstAsesoria}">
                            <h:outputText value="#{msg.msg_sin_consultar}"/>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="tableContentConsultarAsesoria" 
                                        rendered="#{not empty consultarFoliosBean.lstAsesoria}"
                                     styleClass="tabContainer">
                            <t:buffer into="#{table}">
                                <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                                             binding="#{consultarFoliosBean.dtAsesoria}"
                                             value="#{consultarFoliosBean.lstAsesoria}" rows="10"
                                             styleClass="standard_table"
                                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                                             id="dtBucarAsesoria">
                                             
                                         
                                <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Clinica"/>
                                        </f:facet>
                                        <h:outputText value="#{item.havnclinic}"/>
                                    </h:column>
                                             
                                             
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Fecha Asesoria"/>
                                        </f:facet>
                                        <h:outputText value="#{item.id.havdfecase}"/>
                                    </h:column>
                                    
                                      <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="usuario"/>
                                        </f:facet>
                                        <h:outputText value="#{item.id.havlusuario}"/>
                                    </h:column>
                                     <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Visualizar"/>
                                        </f:facet>
                                        <h:commandLink id="atenderAsessoria" action="#{consultarFoliosBean.imprimirAsesoria}">
                                            <t:graphicImage alt="" border="0" url="/comun/imagenes/pdf.gif"/>
                                        </h:commandLink>
                                    </h:column>
                                </h:dataTable>
                            </t:buffer>
                            <t:buffer into="#{tableScroller}">
                                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                                    <t:dataScroller id="scroll_3" for="dtBucarAsesoria" fastStep="10"
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
                      <s:fieldset legend="Viniso" id="fieldSetConsultarViniso"
                                styleClass="fieldset_dataTable">
                        <h:panelGrid columns="1" id="panelGridConsultaViniso"
                                     rendered="#{empty consultarFoliosBean.lstViniso}">
                            <h:outputText value="#{msg.msg_sin_consultar}"/>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="tableContentTabsConsultarViniso"
                                     rendered="#{not empty consultarFoliosBean.lstViniso}"
                                     styleClass="tabContainer">
                            <t:buffer into="#{table}">
                                <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                                             binding="#{consultarFoliosBean.dtViniso}"
                                             value="#{consultarFoliosBean.lstViniso}" rows="10"
                                             styleClass="standard_table"
                                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                                             id="dtBucarViniso">
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Fecha Viniso"/>
                                        </f:facet>
                                        <h:outputText value="#{item.hstdfecregistr}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Histor�a Cl�nica"/>
                                        </f:facet>
                                        <h:outputText value="#{item.id.hstlnumero}"/>
                                    </h:column>
                                     <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="N�mero de Seguimiento"/>
                                        </f:facet>
                                        <h:outputText value="#{item.id.hstlconsecutiv}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Imprimir"/>
                                        </f:facet>
                                        <h:commandLink id="aceptarViniso"
                                                       action="#{consultarFoliosBean.imprimirViniso}">
                                             <t:graphicImage alt="" border="0" url="/comun/imagenes/pdf.gif"/>
                                        </h:commandLink>
                                    </h:column>
                                </h:dataTable>
                            </t:buffer>
                            <t:buffer into="#{tableScroller}">
                                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                                    <t:dataScroller id="scroll_4" for="dtBucarViniso" fastStep="10"
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
                    <h:panelGrid>
                        <h:commandLink action="#{consultarFoliosBean.volverConsulta}" immediate="true">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                        </h:commandLink>
                    </h:panelGrid>
                </t:panelTab>
                <t:panelTab id="panelBuscadorUsuarios" label="Buscar Usuarios"
                            rendered="#{consultarFoliosBean.renderBuscador}">
                    <a4j:region id="regionBuscadorUsuarios" renderRegionOnly="false">
                        <a4j:status for="regionBuscadorUsuarios">
                            <f:facet name="start">
                                <t:div id="chargingBuscadorUsuarios" styleClass="loading">
                                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                                        <h:outputText value="Procesando..."/>
                                        <h:outputText value="Por favor espere."/>
                                    </h:panelGrid>
                                </t:div>
                            </f:facet>
                            <f:facet name="stop"/>
                        </a4j:status>
                        <jsp:include page="/pages/clinico/comunes/buscador/buscadorUsuarios.jsp" flush="true"/>
                        <h:panelGrid id="panelGridBuscarUsuariosBotones" width="100%"
                                     columnClasses="columnaBotonesCentrados" dir="RTL">
                            <t:htmlTag value="br"/>
                            <h:panelGroup id="panelGroupBuscarUsuariosBotones1">
                                <h:commandButton value="Aceptar Usuario" styleClass="btn btn btn-success"
                                                 action="#{consultarFoliosBean.aceptarUsuario}"></h:commandButton>
                            </h:panelGroup>
                        </h:panelGrid>
                    </a4j:region>
                </t:panelTab>
            </t:panelTabbedPane>
        </h:panelGrid>
        <h:panelGrid>
            <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMsgFolioAdministrador" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationMsgFolioAdministrador" showSummary="true" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
            </h:panelGroup>
        </h:panelGrid>
        <f:subview id="generarHistoriaClinicaAdministrador" rendered="#{consultarFoliosBean.generoHistoria}">
            <f:verbatim>
                <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
            </f:verbatim>
        </f:subview>
    </a4j:region>
</a4j:form>