<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridFoliosCirugiaTab"
             styleClass="tabContainer">
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableFoliosCirugiaTabs"
                 styleClass="tabContainer">
        <jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
        <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                           activePanelTabVar="true" width="100%" id="tabConFoliosCirugia" styleClass="tabbedPane"
                           activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                           selectedIndex="#{consultarFoliosUsuarioCirugiaMedicoBean.selectedIndex}"
                           disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                           inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
            <t:panelTab id="panelConFoliosCirugia" label="Consultar Folios Cirugia">
                <s:fieldset legend="Imprimir Folios Cirugia" id="fieldSetListaFoliosCirugia"
                            styleClass="fieldset_dataTable">
                    <h:panelGrid columns="1" id="panelGridFoliosCirugia"
                                 rendered="#{empty consultarFoliosUsuarioCirugiaMedicoBean.lstFolios}">
                        <h:outputText value="#{msg.msg_sin_consultar}"/>
                    </h:panelGrid>
                    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                 id="tableContentTabsFoliosCirugia"
                                 rendered="#{not empty consultarFoliosUsuarioCirugiaMedicoBean.lstFolios}"
                                 styleClass="tabContainer">
                        <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                                     binding="#{consultarFoliosUsuarioCirugiaMedicoBean.dtFoliosCirugia}"
                                     value="#{consultarFoliosUsuarioCirugiaMedicoBean.lstFolios}" rows="10"
                                     styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
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
                                               action="#{consultarFoliosUsuarioCirugiaMedicoBean.generar}">
                                    <t:graphicImage alt="" border="0" url="/comun/imagenes/LastThreeMonths.png"/>
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                        <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                            <t:dataScroller id="scroll_DetalleDescripcionQuirurgica" for="dtFoliosCirugia" fastStep="10"
                                            pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller"
                                            paginator="true" immediate="true" paginatorMaxPages="9"
                                            paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
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