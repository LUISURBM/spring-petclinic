<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/estilos.css"/>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/estilos2.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.min.css"/>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridRegionManterCirugias"
             styleClass="tabContainer">
  <a4j:region renderRegionOnly="false">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneMantenerCirugias" styleClass="tabbedPane"
                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                       selectedIndex="#{mantenimientoCirugiasBean.selectedIndex}" inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabMostrarCirugias" label="Cirugias Programadas"
                  disabled="#{mantenimientoCirugiasBean.renderAdicionarCirugia}">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelGridMantenimientoCirugia">
          <s:fieldset legend="Lista Cirugias Programadas" id="fieldListaAgregarCirugiasProgramadas"
                      styleClass="fieldset">
            <h:panelGrid columns="1" id="panelGridCirugiasProgramadas"
                         rendered="#{empty mantenimientoCirugiasBean.lstCirugiasProgramadas}">
              <h:outputText value="#{msg.msg_sin_consultar}"/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="tableContentCirugiasProgramadas"
                         rendered="#{not empty mantenimientoCirugiasBean.lstCirugiasProgramadas}"
                         styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                             binding="#{mantenimientoCirugiasBean.dtCirugiasProgramadas}"
                             value="#{mantenimientoCirugiasBean.lstCirugiasProgramadas}" styleClass="standard_table"
                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" rows="10"
                             id="idDtCirugiasAgregarProgramadas">
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Codigo"/>
                    </f:facet>
                    <h:outputText value="#{item.id.hdccservicio}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Cirugia"/>
                    </f:facet>
                    <h:outputText value="#{item.hdccdescrservi}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Medico"/>
                    </f:facet>
                    <h:panelGroup>
                      <h:selectOneMenu id="mnuProfesionalesModificar" value="#{item.hdcnmedicatien}"
                                       disabled="#{mantenimientoCirugiasBean.deshabilitarMedicos}">
                        <f:selectItems value="#{mantenimientoCirugiasBean.lstProfesionales}"/>
                      </h:selectOneMenu>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuProfesionalesModificar" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                    
                      <h:outputText value="Eliminar"/>
                      
                    </f:facet>
                    <a4j:commandLink id="eliminar" immediate="true"
                                     onclick="if(!confirm(\' Desea remover este registro ? \')){ return false; }"
                                     action="#{mantenimientoCirugiasBean.eliminarCirugia}"
                                     rendered="#{item.renderEliminar}" reRender="panelGridRegionManterCirugias">
                     <t:graphicImage  alt="" border="0" url="/comun/imagenes/trash.png"/>
                    </a4j:commandLink>
                  </h:column>
                  <f:facet name="footer">
                    <a4j:commandLink id="aceptar" immediate="true" reRender="panelGridRegionManterCirugias"
                                    rendered="#{mantenimientoCirugiasBean.renderIconEliminar}"
                                     action="#{mantenimientoCirugiasBean.adicionarCirugias}">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/nuevo.jpg"/>
                    </a4j:commandLink>
                  </f:facet>
                </h:dataTable>
              </t:buffer>
              
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_3" for="idDtCirugiasAgregarProgramadas" fastStep="10"
                                  pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller"
                                  paginator="true" renderFacetsIfSinglePage="false" paginatorMaxPages="9"
                                  paginatorTableClass="paginator" paginatorActiveColumnStyle="font-weight:bold;">
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
        </h:panelGrid>
      </t:panelTab>
      <t:panelTab id="panelTabAdicionarCirugias" label="Adicionar Cirugias"
                  rendered="#{mantenimientoCirugiasBean.renderAdicionarCirugia}"
                   disabled="#{mantenimientoCirugiasBean.renderFacturas}">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAdicionarCirugia">
          <s:fieldset legend="Adicionar Cirugias" id="fieldListaAgregarCirugias" styleClass="fieldset">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelGridTipoDocumentoModificarCirugia" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Tiene Factura" styleClass="labelTextOblig"/>
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuTieneFactura" immediate="true"
                                  value="#{mantenimientoCirugiasBean.tieneFactura}"
                                  valueChangeListener="#{mantenimientoCirugiasBean.setTieneFactura}">
                  <f:selectItems value="#{mantenimientoCirugiasBean.lstOpciones}"/>
                  <a4j:support id="supportmnuTieneFactura" event="onclick"
                               action="#{mantenimientoCirugiasBean.changeFactura}" reRender="panelTabAdicionarCirugias">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <s:fieldset legend="Programar Cirugias Facturadas"
                          rendered="#{mantenimientoCirugiasBean.renderFacturada && !mantenimientoCirugiasBean.renderSinFactura}"
                          id="fieldAgregarCirugias" styleClass="fieldset">
                <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelAgregarCirugias" rowClasses="labelText,labelTextInfo">
                  <h:outputLabel value="Tipo de Documento" for="mnuTipDocAgregarCirugia" styleClass="labelTextOblig"/>
                  <h:outputText value=""/>
                  <h:outputLabel value="Número Documento" for="itNumDocAgregarCirugia" styleClass="labelTextOblig"/>
                  <h:outputText value=""/>
                  <h:selectOneMenu id="mnuTipDocAgregarCirugia" value="#{mantenimientoCirugiasBean.idTipoDocumento}">
                    <f:selectItem itemLabel="Seleccione una opción..." itemValue=""/>
                    <f:selectItem itemLabel="FACTURA SAP" itemValue="90"/>
                    <f:selectItem itemLabel="CIRUGIA SIN FACTURA" itemValue="30"/>
                  </h:selectOneMenu>
                  <t:message for="mnuTipDocAgregarCirugia" errorClass="errorMessage"/>
                  <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
                    <a4j:commandButton value="Buscar" action="#{mantenimientoCirugiasBean.mostrarBuscadorFacturas}"
                                       reRender="panelGridRegionManterCirugias" image="/comun/imagenes/lupita.png"/>
                    <h:inputText id="itNumDocAgregarCirugia" value="#{mantenimientoCirugiasBean.numerodocumento}"
                                 size="12"/>
                  </h:panelGrid>
                  <t:message for="itNumDocAgregarCirugia" styleClass="errorMessage"/>
                </h:panelGrid>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelBotonAgregarConsulta" columnClasses="columnaBotonesCentrados">
                  <a4j:outputPanel id="ajaxRegionMessagesAgregarCirugia" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationAndErrorsAgregarCirugia" showSummary="false" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion" showDetail="true"
                                tooltip="true"/>
                    <t:htmlTag value="br"/>
                  </a4j:outputPanel>
                  <h:panelGroup>
                    <a4j:commandButton value="Buscar Cirugias" action="#{mantenimientoCirugiasBean.buscadorDoc}"
                                       reRender="panelTabAdicionarCirugias" styleClass="btn btn btn-success"/>
                    <a4j:commandButton value="Nueva Factura" action="#{mantenimientoCirugiasBean.inicializarBean}"
                                       reRender="panelTabAdicionarCirugias" styleClass="btn btn btn-warning"/>
                  </h:panelGroup>
                </h:panelGrid>
              </s:fieldset>
              <s:fieldset legend="Programar Cirugias No Facturadas"
                          rendered="#{!mantenimientoCirugiasBean.renderFacturada && mantenimientoCirugiasBean.renderSinFactura}"
                          id="fieldAgregarCirugiasNoFacturadas" styleClass="fieldset">
                <a4j:region renderRegionOnly="false">
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelGridBuscarCirugias" rowClasses="labelText,labelTextInfo">
                  <h:outputText value="Codigo "/>
                  <h:outputText value="Descripcion 1"/>
                  <h:inputText value="#{mantenimientoCirugiasBean.servicio.csvccodigo}"
                               onkeydown="return blockEnter(event);"/>
                  <h:inputText value="#{mantenimientoCirugiasBean.servicio.csvcnombre}"
                               onkeydown="return blockEnter(event);"/>
                  <h:outputText value=""/>
                  <h:outputText value="Descripcion 2"/>
                  <h:selectOneRadio id="radioOpcion2" value="#{mantenimientoCirugiasBean.servicio.csvcopera1}">
                    <f:selectItem itemValue="AND" itemLabel="AND"/>
                    <f:selectItem itemValue="OR" itemLabel="OR"/>
                  </h:selectOneRadio>
                  <h:inputText value="#{mantenimientoCirugiasBean.servicio.csvcnombre2}"
                               onkeydown="return blockEnter(event);"/>
                  <h:outputText value=""/>
                  <h:outputText value="Descripcion 3"/>
                  <h:selectOneRadio id="radioOpcion3" value="#{mantenimientoCirugiasBean.servicio.csvcopera2}">
                    <f:selectItem itemValue="AND" itemLabel="AND"/>
                    <f:selectItem itemValue="OR" itemLabel="OR"/>
                  </h:selectOneRadio>
                  <h:inputText value="#{mantenimientoCirugiasBean.servicio.csvcnombre3}"
                               onkeydown="return blockEnter(event);"/>
                </h:panelGrid>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelBotonConsultarCirugiasNoFacturadas" columnClasses="columnaBotonesCentrados">
                             
                 <a4j:outputPanel id="ajaxRegionMessagesAgregarServicio" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationAndErrorsAgregarServicio" showSummary="false" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion" showDetail="true"
                                tooltip="true"/>
                    <t:htmlTag value="br"/>
                  </a4j:outputPanel>
                             
                  <a4j:commandButton value="Buscar" 
                                     action="#{mantenimientoCirugiasBean.consultarCirugias}"
                                     reRender="fieldSetCirugiasXServicio" styleClass="btn btn btn-success"
                                     id="idButt"/>
                </h:panelGrid>
                </a4j:region>
              </s:fieldset>
              <s:fieldset legend="Resultados Consulta" id="fieldSetCirugiasXServicio" styleClass="fieldset_dataTable"
                          rendered="#{!mantenimientoCirugiasBean.renderFacturada && mantenimientoCirugiasBean.renderSinFactura}">
                <h:panelGrid columns="1" id="panelGridNoCirugiasXServicio"
                             rendered="#{empty mantenimientoCirugiasBean.lstExamenesCirugias}">
                  <h:outputText value="#{msg.msg_sin_consultar}"/>
                </h:panelGrid>
                <h:panelGrid columns="1" border="0" cellpadding="0"
                             rendered="#{not empty mantenimientoCirugiasBean.lstExamenesCirugias}" cellspacing="0"
                             width="100%" id="tableContentTabsBucarCirugiasXServicio" styleClass="tabContainer">
                  <t:buffer into="#{table}">
                    <h:dataTable var="item" border="0" cellpadding="0" cellspacing="2"
                                 binding="#{mantenimientoCirugiasBean.dtServicios}"
                                 value="#{mantenimientoCirugiasBean.lstExamenesCirugias}" rows="10"
                                 styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                                 footerClass="paginacion" id="dtCirugiasXServicio">
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
                          <h:outputText value="Seleccionar"/>
                        </f:facet>
                        <a4j:commandLink id="aceptarCirugiasXServicio" 
                                         reRender="panelGridRegionManterCirugias"
                                         action="#{mantenimientoCirugiasBean.agregarServicio}">
                          <t:graphicImage alt="" border="0" url="/comun/imagenes/adicionar.gif"/>
                        </a4j:commandLink>
                      </h:column>
                    </h:dataTable>
                  </t:buffer>
                  <t:buffer into="#{tableScroller}">
                    <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                      <t:dataScroller id="scroll_CirugiasXServicio" for="dtCirugiasXServicio" fastStep="10" pageCountVar="pageCount"
                                      pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                      paginatorMaxPages="9" paginatorTableClass="paginator"
                                      renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
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
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Lista Cirugias Facturadas" id="fieldListaAgregarCirugiasFacturadas" styleClass="fieldset"
                      rendered="#{mantenimientoCirugiasBean.renderFacturada && !mantenimientoCirugiasBean.renderSinFactura && not empty mantenimientoCirugiasBean.lstCirugiasFactura}">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="tableContentAgregarCirugiasTabs"
                         rendered="#{not empty mantenimientoCirugiasBean.lstCirugiasFactura}" styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                             binding="#{mantenimientoCirugiasBean.dtFacturasCirugia}"
                             value="#{mantenimientoCirugiasBean.lstCirugiasFactura}" styleClass="standard_table"
                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" rows="10"
                             id="idDtCirugiasAgregar">
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Servicio"/>
                    </f:facet>
                    <h:outputText value="#{item.ccocservic.csvccodigo} #{item.ccocservic.csvcnombre}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Tipo Documento"/>
                    </f:facet>
                    <h:outputText value="#{item.ccontipdoc.ctdnnumero} #{item.ccontipdoc.ctdcdescri}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Número Documento"/>
                    </f:facet>
                    <h:outputText value="#{item.cconnumdoc}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Agregar"/>
                    </f:facet>
                    <a4j:commandLink id="agregar" immediate="true" reRender="panelGridRegionManterCirugias"
                                     action="#{mantenimientoCirugiasBean.agregarCirugia}">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/editar.gif"/>
                    </a4j:commandLink>
                  </h:column>
                </h:dataTable>
              </t:buffer>
             
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_1" for="idDtCirugiasAgregar" fastStep="10" pageCountVar="pageCount"
                                  pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                                  renderFacetsIfSinglePage="false" paginatorMaxPages="9" paginatorTableClass="paginator"
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
            <h:commandLink action="#{mantenimientoCirugiasBean.volverConsulta}" immediate="true">
              <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
            </h:commandLink>
          </h:panelGrid>
        </h:panelGrid>
      </t:panelTab>
      
      
          <t:panelTab id="panelBuscadorMantenientoFacturasVigentes" label="Buscador Facturas Usuario"
                    rendered="#{mantenimientoCirugiasBean.renderFacturas}">
          <a4j:region id="regionMantenimientoFacturasVigentes" renderRegionOnly="false">
            <a4j:status for="regionMantenimientoFacturasVigentes">
              <f:facet name="start">
                <t:div id="chargingMantenimientoFacturasVigentes" styleClass="loading">
                  <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                    <h:outputText value="Procesando..."/>
                    <h:outputText value="Por favor espere."/>
                  </h:panelGrid>
                </t:div>
              </f:facet>
              <f:facet name="stop"/>
            </a4j:status>
            <jsp:include page="/pages/clinico/cirugia/buscador/buscadorFacturas.jsp" flush="true"/>
            <h:panelGrid id="panelGridMantenimientoFacturasVigentesBotones" width="100%" 
                    columnClasses="columnaBotonesCentrados"
                         dir="RTL">
              <t:htmlTag value="br"/>
              <h:panelGroup id="panelGroupMantenimientoFacturasVigentesBotones1">
                <a4j:commandButton value="Aceptar Facturas" styleClass="btn btn btn-success" 
                    action="#{mantenimientoCirugiasBean.aceptarFacturas}"
                                   reRender="panelGridRegionManterCirugias">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:commandButton>
              </h:panelGroup>
            </h:panelGrid>
          </a4j:region>
        </t:panelTab>
        
        <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMensajeNoExisteFactura" ajaxRendered="true">
                  <t:messages id="msgNoExisteFactura" showSummary="true" errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
      
    </t:panelTabbedPane>
  </a4j:region>
</h:panelGrid>