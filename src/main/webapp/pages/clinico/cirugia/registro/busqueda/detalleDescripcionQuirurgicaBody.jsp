<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<a4j:form id="listaDetalleDescripcionQuirurgicaForm">
  <a4j:region id="bodyRegionListaDetalleDescripcionQuirurgica">
    <a4j:status for="bodyRegionListaDetalleDescripcionQuirurgica">
      <f:facet name="start">
        <t:div id="chargindListaDetalleDescripcionQuirurgica" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="panelGridDetalleDescripcionQuirurgicaTab" styleClass="tabContainer">
      <jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneListaDetalleDescripcionQuirurgica" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabListaDetalleDescripcionQuirurgica" label="Descripci�n Quirurgica ">
          <h:panelGrid id="panelDatosListaDetalleDescripcionQuirurgica" columns="1" border="0" cellpadding="0"
                       cellspacing="0" width="100%" styleClass="tabContainer">
            <s:fieldset legend="Cirugias Programadas" id="fieldSetDetalleDescripcionQuirurgica"
                        styleClass="fieldset_dataTable">
              <h:panelGrid columns="1" id="panelGridConsultarDetalleDescripcionQuirurgica"
                           rendered="#{empty detalleDescripcionQuirurgicaBean.lstCirugiasIngresadas}">
                <h:outputText value="#{msg.msg_sin_consultar}"/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="tableContentTabsConsultarDetalleDescripcionQuirurgica"
                           rendered="#{not empty detalleDescripcionQuirurgicaBean.lstCirugiasIngresadas}"
                           styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                               binding="#{detalleDescripcionQuirurgicaBean.dtCirugia}" 
                               value="#{detalleDescripcionQuirurgicaBean.lstCirugiasIngresadas}" rows="10"
                               styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtDetalleQuirurgica">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Seleccionar"/>
                      </f:facet>
                      <h:selectBooleanCheckbox id="checkSeleccionar" immediate="true" value="#{item.seleccionado}"
                                               style="margin-left: 50%;"
                                               valueChangeListener="#{item.setSeleccionado}">
                        <a4j:support id="supportcheckSeleccionar" event="onchange">
                          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                      </h:selectBooleanCheckbox>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Cirugia" />
                      </f:facet>
                      <h:outputText value="#{item.hdccdescrservi}"/>
                    </h:column>
                 
             
                
                    
                
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_DetalleDescripcionQuirurgica" for="dtDetalleQuirurgica" fastStep="10"
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
                </t:buffer>
                <h:outputText value="#{tableScroller}" escape="false"/>
                <h:outputText value="#{table}" escape="false"/>
                <h:outputText value="#{tableScroller}" escape="false"/>
              </h:panelGrid>
              
            
            </s:fieldset>
            
              
              
       <s:fieldset legend="Cirugias Realizadas" id="fieldSetDetalleDescripcionRealizada"
                        styleClass="fieldset_dataTable">
              <h:panelGrid columns="1" id="panelGridDescripcionQuirurgicaRealizada"
                           rendered="#{empty detalleDescripcionQuirurgicaBean.lstCirugiasRealizadas}">
                <h:outputText value="#{msg.msg_sin_consultar}"/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="tableContentTabsConDetDescQxRealizada"
                           rendered="#{not empty detalleDescripcionQuirurgicaBean.lstCirugiasRealizadas}"
                           styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                               binding="#{detalleDescripcionQuirurgicaBean.dtCirugiaRealizada}" 
                               value="#{detalleDescripcionQuirurgicaBean.lstCirugiasRealizadas}" rows="10"
                               styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtDetalleQuirurgicaRealizada">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Cirugia" />
                      </f:facet>
                      <h:outputText value="#{item.hdccdescrservi}"/>
                    </h:column>
                    <h:column  >
                  
                      <f:facet name="header" >
                        <h:panelGroup >
                          <h:outputText value="Imprimir"  />
                            </h:panelGroup>
                          </f:facet>
                   
                         <h:commandLink id="imprimirDescripcion" immediate="true" 
                                     action="#{detalleDescripcionQuirurgicaBean.imprimirDescripcion}">
                        <t:graphicImage alt="" border="0" url="/comun/imagenes/print_Spa.gif"/>
                      </h:commandLink>
                       
                      
                    </h:column>
                <h:column>
              
                <f:facet name="header" >
                 <h:panelGroup >
                          <h:outputText value="Anatomia Patologica"  />
                           </h:panelGroup>
                           </f:facet>
                          
                 <h:panelGroup id="panelImprimir">
                <h:commandLink id="reporteAnatomia" rendered="#{item.renderAnatomia}"
                               action="#{detalleDescripcionQuirurgicaBean.buscaDatosAnatomiaPatologica}">
                  <t:graphicImage border="0" alt="Imprimir Reporte Anatomia Patol�gica"
                                  url="/comun/imagenes/print_Spa.gif"/>
                </h:commandLink>
              </h:panelGroup>
              
                </h:column>
                
                    
                
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_DetalleDx" for="dtDetalleQuirurgicaRealizada" fastStep="10"
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
                </t:buffer>
                <h:outputText value="#{tableScroller}" escape="false"/>
                <h:outputText value="#{table}" escape="false"/>
                <h:outputText value="#{tableScroller}" escape="false"/>
              </h:panelGrid>
              
            
            </s:fieldset>             
            
            
          </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelBotonesDetalleDescripcion" columnClasses="panelGridBotones">
                <h:panelGroup>
                  <h:commandButton value="Siguiente" styleClass="btn btn btn-success" immediate="true"
                                   action="#{detalleDescripcionQuirurgicaBean.continuarRegistro}"/>
                </h:panelGroup>
              </h:panelGrid>
        </t:panelTab>
        <h:commandLink action="#{detalleDescripcionQuirurgicaBean.volver}" immediate="true">
          <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
        </h:commandLink>
      </t:panelTabbedPane>
    </h:panelGrid>
    <f:subview id="generarAnatomiaPat" rendered="#{detalleDescripcionQuirurgicaBean.generoReporte}">
      <f:subview id="generarRepAnatomia" rendered="#{detalleDescripcionQuirurgicaBean.generoReporte}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript">
                    window.open("<%=request.getSession().getAttribute(XlsServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=1200,height=900");
                </script>
        </f:verbatim>
      </f:subview>
    </f:subview>
    <h:panelGrid>
      <h:panelGroup id="msgModificarListaDetalleDescripcionQuirurgica">
        <a4j:outputPanel id="ajaxRegionMessagesListaDetalleDescripcionQuirurgica" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsDetalleDescripcionQuirurgica" showSummary="true" errorClass="error"
                      globalOnly="true" layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>