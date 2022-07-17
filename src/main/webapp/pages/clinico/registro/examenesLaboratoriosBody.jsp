<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formExamenesLaboratorios">
 <a4j:region id="regionExamenesLaboratorios" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionExamenesLaboratorios">
      <f:facet name="start">
        <t:div id="chargingExamenesLaboratorios" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>


 
 
 
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridExamenLaboratoriosTab"
               styleClass="tabContainer">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneExamenLaboratorios"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabExamenLaboratorios" label="Examenes Laboratorios">
    
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridExamenLaboratorios"
                       styleClass="tabContainer">
            <s:fieldset legend="Criterios de Busqueda Laboratorios "
                        rendered="#{!examenesLaboratorioBean.modoConsulta}"
                        id="fieldSetBuscadorLaboratorios" styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelGridBuscarLaboratorios"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Codigo "/>
                <h:outputText value="Descripcion"/>
                <h:inputText value="#{examenesLaboratorioBean.servicio.csvccodigo}"
                             onkeydown="return blockEnter(event);"/>
                <h:inputText value="#{examenesLaboratorioBean.servicio.csvcnombre}"
                             onkeydown="return blockEnter(event);"/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelBotonConsulta"
                           columnClasses="columnaBotonesCentrados">
                <h:panelGroup>
                  <a4j:outputPanel id="ajaxRegionMessagesRegiones"
                                   ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:message for="idButtonContrato"
                               id="msgInformationAndErrorsR" errorClass="error"
                               infoClass="informacion"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <t:htmlTag value="br"/>
                <a4j:commandButton value="Buscar"
                                   action="#{examenesLaboratorioBean.consultarLaboratorios}"
                                   reRender="fieldSetLaboratoriosConsulta"
                                   styleClass="boton_fieldset"
                                   id="idButtonContrato"/>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Resultados Consulta"
                        rendered="#{!examenesLaboratorioBean.modoConsulta}"
                        id="fieldSetLaboratoriosConsulta"
                        styleClass="fieldset_dataTable">
                        
             <h:panelGrid columns="1" id="panelGridNoLaboratorios"
                                     rendered="#{empty examenesLaboratorioBean.lstExamenesLaboratorios}">
                            <h:outputText value="#{msg.msg_sin_consultar}"/>
                        </h:panelGrid>
            
              <h:panelGrid columns="1" border="0" cellpadding="0"  rendered="#{not empty examenesLaboratorioBean.lstExamenesLaboratorios}"
                           cellspacing="0" width="100%"
                           id="tableContentTabsBucar" styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0"
                               cellspacing="0"
                               binding="#{examenesLaboratorioBean.dtServicios}"
                               value="#{examenesLaboratorioBean.lstExamenesLaboratorios}"
                               rows="10" styleClass="standard_table"
                               rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion"
                               id="dtBucarLaboratorios">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Codigo"/>
                      </f:facet>
                      <h:outputText value="#{item.csvccodigo}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Nombre"/>
                      </f:facet>
                      <h:outputText value="#{item.csvcnombre}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Seleccione"/>
                      </f:facet>
                      <h:commandLink id="aceptarLaboratorios"
                                     action="#{examenesLaboratorioBean.agregarRemision}">
                        <t:graphicImage alt=""  border="0"
                                        url="/comun/imagenes/adicionar.gif"/>
                      </h:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1"
                               rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_1" for="dtBucarLaboratorios"
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
            <s:fieldset legend="Lista Examenes Laboratorios "
                        id="fieldExamenLaboratoriosLista" styleClass="fieldset">
                        
                <h:panelGrid columns="1" id="panelGridNoLaboratoriosSeleccionados"
                          rendered="#{empty examenesLaboratorioBean.lstRemision}">
                 <h:outputText value="#{msg.msg_sin_consultar}"/>
                        </h:panelGrid>       
                        
              <h:panelGrid columns="1" border="0" cellpadding="0" rendered="#{not empty examenesLaboratorioBean.lstRemision}"
                           cellspacing="0" width="100%"
                           id="panelExamenLaboratoriosTable"
                           styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0"
                               binding="#{examenesLaboratorioBean.dtRemision}"
                               cellspacing="0"
                               value="#{examenesLaboratorioBean.lstRemision}"
                               rows="10" styleClass="standard_table"
                               rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion"
                               id="dtExamenLaboratorios">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Examen"/>
                      </f:facet>
                      <h:outputText value="#{item.cpservicio.csvcnombre}"/>
                    </h:column>
                    <h:column rendered="#{!examenesLaboratorioBean.modoConsulta}">
                      <f:facet name="header">
                        <h:outputText value="Eliminar"/>
                      </f:facet>
                      <h:commandLink id="eliminar" immediate="true"
                                     action="#{examenesLaboratorioBean.eliminarRemision}">
                        <t:graphicImage alt=""  border="0"
                                        url="/comun/imagenes/editar.gif"/>
                      </h:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1"
                               rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_ExamenLaboratorios"
                                    for="dtExamenLaboratorios" fastStep="10"
                                    pageCountVar="pageCount"
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
            <s:fieldset legend="Observaciones " id="fieldObservaciones"
                        styleClass="fieldset">
              <h:panelGrid columns="1" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           rowClasses="labelText,labelTextInfo"
                           id="panelGridObservaciones"
                           styleClass="tabContainer">
                <h:outputText value="Observaciones "/>
                <h:panelGroup>
                  <h:inputTextarea id="inputDescripcionRemision"
                                   value="#{examenesLaboratorioBean.descripcionRemision}"
                                   disabled="#{examenesLaboratorioBean.modoConsulta}"
                                   style="width:300px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputDescripcionRemision"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelBotonExamenLaboratorio"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <a4j:commandButton value="Generar Remision"
                                   styleClass="boton_fieldset"
                                   reRender="formExamenesLaboratorios"
                                   disabled="#{examenesLaboratorioBean.modoConsulta}"
                                   action="#{examenesLaboratorioBean.generarRemision}"/>
              </h:panelGroup>
            </h:panelGrid>
                <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionExamenesLaboratorioMsg"
                                 ajaxRendered="true">
                  <t:messages id="msgExamenesLaboratorioMsg" showSummary="true"
                              errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
            
            <f:subview id="generarExamenLaboratorios"
                       rendered="#{examenesLaboratorioBean.generoDocPDF}">
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