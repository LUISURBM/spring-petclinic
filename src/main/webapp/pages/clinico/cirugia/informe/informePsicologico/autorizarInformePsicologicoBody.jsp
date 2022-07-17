<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="autorizarAclaracionRegistrosDescripcionForm">
    <a4j:region id="bodyRegionAutorizarAclaracionRegistrosDescripcion">
        <a4j:status id="statusButton" for="bodyRegionAutorizarAclaracionRegistrosDescripcion">
            <f:facet name="start">
                <t:div id="chargindautorizarAclaracionRegistrosDescripcion" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
       
        <h:panelGrid columns="1" id="tableautorizarAclaracionRegistrosDescripcion" border="0" cellpadding="0" cellspacing="0"
                     width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
            <h:outputText value="Autorizar Informe Psicologico " 
            id="infoUbicationAutorizacionRegistrosDescripción"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableAutorizacionRegistrosDescripcionTabs" styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxAutorizarRegistrosDescripcion" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgAutorizarRegistrosDescripcion" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabConAutorizarRegistrosDescripcion"
                               styleClass="tabbedPane" activeTabStyleClass="activeTab"
                               inactiveTabStyleClass="inactiveTab"
                               disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                               inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                <t:panelTab id="panelAutorizarRegistrosDescripcion" label="Autorizar Informe Psicologico">
                 
                    <s:fieldset legend="Autorizaciones Informe Psicologico Pendientes " 
                    id="fieldSetListaAutorizacionDescripcione"
                                styleClass="fieldset_dataTable">
                        <h:panelGrid columns="1" id="panelGridListaAutorizarAclaracionDescripciones"
                                     rendered="#{empty autorizarInformePsicologicoBean.lstDescripcion}">
                            <h:outputText value="#{msg.msg_sin_consultar}"/>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="tableContentTabslstAutorizacionDescripcionAclaracion"
                                     rendered="#{not empty autorizarInformePsicologicoBean.lstDescripcion}"
                                     styleClass="tabContainer">
                            <t:buffer into="#{table}">
                                <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                                             binding="#{autorizarInformePsicologicoBean.dtDescripcionAutorizacion}"
                                             value="#{autorizarInformePsicologicoBean.lstDescripcion}" rows="10"
                                             styleClass="standard_table"
                                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                                             id="dtDescripcionAutorizacion">
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Fecha Solicitud"/>
                                        </f:facet>
                                        <h:outputText value="#{item.haipdfechasolic}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Fecha Consulta"/>
                                        </f:facet>
                                        <h:outputText value="#{item.haipdfechaconsu}"/>
                                    </h:column>
                                    
                                        <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Clinica"/>
                                        </f:facet>
                                        <h:outputText value="#{item.haipnclinica} #{item.nombreClinica}"/>
                                    </h:column>
                                    
                                     <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Servicio"/>
                                        </f:facet>
                                        <h:outputText value="#{item.haipcservicio} #{item.haipcnombserv}"/>
                                    </h:column>
                                    
                                      <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Paciente"/>
                                        </f:facet>
                                        <h:outputText value="#{item.haipcnombpaci} #{item.haipctipoiden} #{item.haipnnumeiden}"/>
                                    </h:column>
                                    
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Motivo Solicitud"/>
                                        </f:facet>
                                        <h:outputText value="#{item.haipcmotivsolic}"/>
                                    </h:column>
                                      <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Usuario Solicitud"/>
                                        </f:facet>
                                        <h:outputText value="#{item.haipcoperasolic}"/>
                                    </h:column>
                                    
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Autorizar"/>
                                        </f:facet>
                                        <h:commandLink id="aclararDescripcion" immediate="true"
                                                       action="#{autorizarInformePsicologicoBean.autorizarInformePsicologico}">
                                            <t:graphicImage alt="" border="0" url="/comun/imagenes/PatientData.png"/>
                                        </h:commandLink>
                                    </h:column>
                                </h:dataTable>
                            </t:buffer>
                            <t:buffer into="#{tableScroller}">
                                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                                    <t:dataScroller id="scroll_DetalleAutorizacion" for="dtDescripcionAutorizacion"
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
                            </t:buffer>
                            <h:outputText value="#{tableScroller}" escape="false"/>
                            <h:outputText value="#{table}" escape="false"/>
                            <h:outputText value="#{tableScroller}" escape="false"/>
                        </h:panelGrid>
                    </s:fieldset>
                    
                    
           
                    <h:panelGrid>
                        <h:commandLink action="#{autorizarInformePsicologicoBean.volverConsulta}" immediate="true">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                        </h:commandLink>
                    </h:panelGrid>
                </t:panelTab>
            
            </t:panelTabbedPane>
        </h:panelGrid>
        <h:panelGrid>
            <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMsgAutorizacionRegistrosQuirurgicos" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationMsgAutorizacionRegistrosQuirurgicos" showSummary="true" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:region>
</a4j:form>