<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridresumenConsultaTab"
             styleClass="tabContainer">
    <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="tabConFoliosMedico" styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab" selectedIndex="#{consultarFoliosBean.selectedIndex}"
                       disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelConFoliosMedico" label="Consultar Folios"
                    rendered="#{!consultarFoliosBean.renderBuscador}">
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
            <s:fieldset legend="Resultados Consulta" id="fieldSetConsultarFolioMedico" styleClass="fieldset_dataTable">
                 <h:commandLink value="Consultar Digitalizados"
                                           actionListener="#{consultarFoliosBean.openPopupClicked}"
                                           styleClass="btn btn btn-warning" id="idButtonBuscarDigitalziados">
                </h:commandLink>
                
                <h:panelGrid columns="1" id="panelGridConsultarFoliosMedico"
                             rendered="#{empty consultarFoliosBean.lstFolios}">
                    <h:outputText value="#{msg.msg_sin_consultar}"/>
                </h:panelGrid>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="tableContentTabsBucarMedico" rendered="#{not empty consultarFoliosBean.lstFolios}"
                             styleClass="tabContainer">
                    <t:buffer into="#{table}">
                        <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                                     binding="#{consultarFoliosBean.dtFolios}" value="#{consultarFoliosBean.lstFolios}"
                                     rows="10" styleClass="standard_table"
                                     rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                                     id="dtBucarFoliosMedico">
                            <h:column id="column1FoliosMedico">
                                <f:facet name="header">
                                    <h:outputText value="Fecha"/>
                                </f:facet>
                                <h:outputText value="#{item.hcodfecregistr}"/>
                            </h:column>
                            <h:column id="column2FoliosMedico">
                                <f:facet name="header">
                                    <h:outputText value="Numero Usuario"/>
                                </f:facet>
                                <h:outputText value="#{item.hcolusuario.huslnumero}"/>
                            </h:column>
                            
                              <h:column id="column2FoliosFactura">
                                <f:facet name="header">
                                    <h:outputText value="Numero Factura"/>
                                </f:facet>
                                <h:outputText value="#{item.hcolusuario.huslnumero}"/>
                            </h:column>
                            
                            <h:column id="column3FoliosMedico">
                                <f:facet name="header">
                                    <h:outputText value="Servicio"/>
                                </f:facet>
                                <h:outputText value="#{item.hcocservicio.csvcnombre}"/>
                            </h:column>
                            <h:column id="column4FoliosMedico">
                                <f:facet name="header">
                                    <h:outputText value="Visualizar"/>
                                </f:facet>
                                <h:commandLink id="visualizarFoliosMedico"
                                               action="#{consultarFoliosBean.visualizarConsultaFolio}">
                                    <t:graphicImage alt="" border="0" url="/comun/imagenes/PatientFile.png"/>
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </t:buffer>
                    <t:buffer into="#{tableScroller}">
                        <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                            <t:dataScroller id="scroll_folios_medico" for="dtBucarFoliosMedico" fastStep="10"
                                            pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller"
                                            paginator="true" immediate="true" paginatorMaxPages="9"
                                            paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
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
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableTabVisFolioMedico"
                         styleClass="tabContainerResumen"></h:panelGrid>
        </t:panelTab>
    </t:panelTabbedPane>
</h:panelGrid>