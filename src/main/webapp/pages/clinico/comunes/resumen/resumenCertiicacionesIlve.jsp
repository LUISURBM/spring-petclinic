<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridresumenConsultaTab"
             styleClass="tabContainer">
    <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
   
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabconsultarFoliosAdministracion"
                               styleClass="tabbedPane" activeTabStyleClass="activeTab"
                               inactiveTabStyleClass="inactiveTab" selectedIndex="#{consultarAsesoriaBean.selectedIndex}"
                               disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                               inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                <t:panelTab id="panelconsultarFoliosAdministracion" label="Consultar Asesoria"
                            rendered="#{!consultarAsesoriaBean.renderBuscador}">
                    <t:htmlTag value="br"/>
                                   
                    
                    <s:fieldset legend="Asesorias" id="fieldSetConsultarAsesoriaAdministrador"
                                styleClass="fieldset_dataTable">
                        <h:panelGrid columns="1" id="panelGridConsultarAsesoria"
                                     rendered="#{empty consultarAsesoriaBean.lstAsesoria}">
                            <h:outputText value="#{msg.msg_sin_consultar}"/>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="tableContentConsultarAsesoria" 
                                        rendered="#{not empty consultarAsesoriaBean.lstAsesoria}"
                                     styleClass="tabContainer">
                            <t:buffer into="#{table}">
                                <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                                             binding="#{consultarAsesoriaBean.dtAsesoria}"
                                             value="#{consultarAsesoriaBean.lstAsesoria}" rows="10"
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
                                        <h:commandLink id="atender" action="#{consultarAsesoriaBean.imprimirAsesoria}">
                                            <t:graphicImage alt="" border="0" url="/comun/imagenes/pdf.gif"/>
                                        </h:commandLink>
                                    </h:column>
                                </h:dataTable>
                            </t:buffer>
                            <t:buffer into="#{tableScroller}">
                                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                                    <t:dataScroller id="scroll_1" for="dtBucarAsesoria" fastStep="10"
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
                        <h:commandLink action="#{consultarAsesoriaBean.volverConsulta}" immediate="true">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                        </h:commandLink>
                    </h:panelGrid>
                </t:panelTab>
                <t:panelTab id="panelBuscadorUsuarios" label="Buscar Usuarios"
                            rendered="#{consultarAsesoriaBean.renderBuscador}">
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
                                                 action="#{consultarAsesoriaBean.aceptarUsuario}"></h:commandButton>
                            </h:panelGroup>
                        </h:panelGrid>
                    </a4j:region>
                </t:panelTab>
            </t:panelTabbedPane>
            
        <f:subview id="generarHistoriaClinicaAdministrador" rendered="#{consultarAsesoriaBean.generoHistoria}">
            <f:verbatim>
                <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
            </f:verbatim>
        </f:subview>
   
</h:panelGrid>