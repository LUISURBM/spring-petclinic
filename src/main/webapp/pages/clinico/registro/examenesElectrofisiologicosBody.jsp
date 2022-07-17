<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formExamenesElectrofisiologicos">
 <a4j:region id="regionExamenesElectrofisiologicos" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionExamenesElectrofisiologicos">
      <f:facet name="start">
        <t:div id="chargingExamenesElectrofisiologicos" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
 

  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridExamenElectrofisiologicoTab"
               styleClass="tabContainer">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneExamenElectrofisiologico"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabExamenElectrofisiologico"
                  label="Examenes Electrofisiologicos">
    
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridExamenElectrofisiologico"
                       styleClass="tabContainer">
            <s:fieldset legend="Datos Examenes Electrofisiologicos"
                        id="fieldExamenElectrofisiologico"
                        styleClass="fieldset">
              <a4j:region id="regionExamenElectrofisiologico"
                          renderRegionOnly="false">
                <h:panelGrid columns="2" border="0" cellpadding="0"
                             cellspacing="0" width="100%"
                             id="panelDatosExamenElectrofisiologico"
                             rendered="#{!examenesElectrofisiologicosBean.modoConsulta}"
                             rowClasses="labelText">
                  <h:outputText value="Examen" styleClass="labelTextOblig"/>
                  <h:outputText value=" "/>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuTipoExamenElectrofisiologico"
                                     required="true"
                                     value="#{examenesElectrofisiologicosBean.remisionSelect}">
                      <f:selectItems value="#{examenesElectrofisiologicosBean.lstExamenesElectrofisiologicos}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuTipoExamenElectrofisiologico"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:panelGroup></h:panelGroup>
                </h:panelGrid>
                <h:panelGrid columns="2" border="0" cellpadding="0"
                             cellspacing="0" width="100%"
                             id="panelBotonAgregarExamenElectrofisiologico"
                             columnClasses="panelGridBotones">
                  <h:panelGroup>
                    <t:htmlTag value="br"/>
                    <a4j:commandButton value="Agregar"
                                       styleClass="boton_fieldset_Naranja"
                                       rendered="#{!examenesElectrofisiologicosBean.modoConsulta}"
                                       action="#{examenesElectrofisiologicosBean.agregarRemision}"
                                       reRender="panelGridExamenElectrofisiologico"/>
                  </h:panelGroup>
                </h:panelGrid>
              </a4j:region>
              <a4j:region renderRegionOnly="false">
       
                <s:fieldset legend="Lista Examenes Electrofisiologicos "
                            id="fieldExamenElectrofisiologicoLista"
                            styleClass="fieldset">
                  <h:panelGrid columns="1" border="0" cellpadding="0"
                               cellspacing="0" width="100%"
                               id="panelExamenElectrofisiologicoTable"
                               styleClass="tabContainer">
                    <t:buffer into="#{table}">
                      <h:dataTable var="item" border="1" cellpadding="0"
                                   binding="#{examenesElectrofisiologicosBean.dtRemision}"
                                   cellspacing="0"
                                   value="#{examenesElectrofisiologicosBean.lstRemision}"
                                   rows="10" styleClass="standard_table"
                                   rowClasses="standardTable_Row1,standardTable_Row2"
                                   footerClass="paginacion"
                                   id="dtExamenElectrofisiologico">
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Examen"/>
                          </f:facet>
                          <h:outputText value="#{item.cpservicio.csvcnombre}"/>
                        </h:column>
                        <h:column rendered="#{!examenesElectrofisiologicosBean.modoConsulta}">
                          <f:facet name="header">
                            <h:outputText value="Eliminar"/>
                          </f:facet>
                          <h:commandLink id="eliminar" immediate="true"
                                         action="#{examenesElectrofisiologicosBean.eliminarRemision}">
                            <t:graphicImage alt=""  border="0"
                                            url="/comun/imagenes/editar.gif"/>
                          </h:commandLink>
                        </h:column>
                      </h:dataTable>
                    </t:buffer>
                    <t:buffer into="#{tableScroller}">
                      <h:panelGrid columns="1"
                                   rowClasses="labelTextInfo,labelTextInfo">
                        <t:dataScroller id="scroll_ExamenElectrofisiologico"
                                        for="dtExamenElectrofisiologico"
                                        fastStep="10" pageCountVar="pageCount"
                                        pageIndexVar="pageIndex"
                                        styleClass="scroller" paginator="true"
                                        immediate="true" paginatorMaxPages="9"
                                        paginatorTableClass="paginator"
                                        renderFacetsIfSinglePage="false"
                                        paginatorActiveColumnStyle="font-weight:bold;">
                          <f:facet name="first">
                            <t:graphicImage alt=""  url="/comun/imagenes/primero.gif"
                                            border="0"/>
                          </f:facet>
                          <f:facet name="last">
                            <t:graphicImage alt=""  url="/comun/imagenes/ultimo.gif"
                                            border="0"/>
                          </f:facet>
                          <f:facet name="previous">
                            <t:graphicImage alt=""  url="/comun/imagenes/anterior.gif"
                                            border="0"/>
                          </f:facet>
                          <f:facet name="next">
                            <t:graphicImage alt=""  url="/comun/imagenes/siguiente.gif"
                                            border="0"/>
                          </f:facet>
                          <f:facet name="fastforward">
                            <t:graphicImage alt=""  url="/comun/imagenes/adelante.gif"
                                            border="0"/>
                          </f:facet>
                          <f:facet name="fastrewind">
                            <t:graphicImage alt=""  url="/comun/imagenes/atras.gif"
                                            border="0"/>
                          </f:facet>
                        </t:dataScroller>
                      </h:panelGrid>
                    </t:buffer>
                                      <h:outputText value="#{tableScroller}" escape="false"/>
                  <h:outputText value="#{table}" escape="false"/>
                  <h:outputText value="#{tableScroller}" escape="false"/>
                  </h:panelGrid>
                </s:fieldset>
              </a4j:region>
            </s:fieldset>
            <a4j:region renderRegionOnly="false">
                     <s:fieldset legend="Observaciones " id="fieldObservaciones"
                            styleClass="fieldset">
                  <h:panelGrid columns="1" border="0" cellpadding="0"
                               cellspacing="0" width="100%"
                               id="panelGridObservaciones"  rowClasses="labelText"
                               styleClass="tabContainer">
                    <h:outputText value="Observaciones "/>
                    <h:panelGroup>
                      <h:inputTextarea id="inputDescripcionRemision"
                                       value="#{examenesElectrofisiologicosBean.descripcionRemision}"
                                       disabled="#{examenesElectrofisiologicosBean.modoConsulta}"
                                       style="width:300px"/>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="inputDescripcionRemision"
                                   styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </h:panelGrid>
                </s:fieldset>
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelBotonExamenElectrofisiologico"
                           columnClasses="panelGridBotones">
                <h:panelGroup>
                  <a4j:commandButton value="Generar Remision"
                                     styleClass="boton_fieldset"
                                     reRender="formExamenesElectrofisiologicos"
                                     disabled="#{examenesElectrofisiologicosBean.modoConsulta}"
                                     action="#{examenesElectrofisiologicosBean.generarRemision}"/>
                </h:panelGroup>
              </h:panelGrid>
            </a4j:region>
            
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionExamenesElectrofisiologicosMsg"
                                 ajaxRendered="true">
                  <t:messages id="msgExamenesElectrofisiologicosMsg" showSummary="true"
                              errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
            <f:subview id="generarExamenElectrofisiologico"
                       rendered="#{examenesElectrofisiologicosBean.generoDocPDF}">
              <f:verbatim>
                <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
              </f:verbatim>
            </f:subview>
          </h:panelGrid>
       </t:panelTab>
    </t:panelTabbedPane>
  </h:panelGrid>
  </a4j:region>
</a4j:form>