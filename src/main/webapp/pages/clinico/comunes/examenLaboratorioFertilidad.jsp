<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridExamenLaboratoriosTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneExamenLaboratorios" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabExamenLaboratorios" label="Examenes Laboratorios">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridExamenLaboratorios"
                   styleClass="tabContainer">
        <s:fieldset legend="" id="fieldSolicitudLaboratorios" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridSolicitudLaboratorios" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Lista de Laboratorios Iniciales"/>
            <a4j:region renderRegionOnly="false">
              <h:selectBooleanCheckbox id="checkSolicitudLaboratorios" onkeydown="return blockEnter(event);"
                                       value="#{examLaboratorioFertilidadBean.renderEnfermedadesIniciales}"
                                       valueChangeListener="#{examLaboratorioFertilidadBean.setRenderEnfermedadesIniciales}"
                                       immediate="true">
                <a4j:support id="support_enderEnfermedadesIniciales" event="onclick" immediate="true"
                             reRender="panelGridExamenLaboratorios">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
            </a4j:region>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Lista para enfermedades infecciosas iniciales"
                    rendered="#{examLaboratorioFertilidadBean.renderEnfermedadesIniciales}" id="fieldListaProfilaxis"
                    styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0"
                       rendered="#{not empty examLaboratorioFertilidadBean.lstRemisionEnfermedadesIniciales}"
                       cellspacing="0" width="100%" id="panelExamenLaboratoriosEnfermedadesInicalesTable"
                       styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="0" cellpadding="0"
                           binding="#{examLaboratorioFertilidadBean.dtRemisionEnfermedadesIniciales}" cellspacing="0"
                           value="#{examLaboratorioFertilidadBean.lstRemisionEnfermedadesIniciales}" rows="20"
                           styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                           footerClass="paginacion" id="dtExamenLaboratoriosEnfermedadesIniciales">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Examen"/>
                  </f:facet>
                  <h:outputText value="#{item.cpservicio.csvcnombre}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Adicionar"/>
                  </f:facet>
                  <h:commandLink id="adicionar" immediate="true"
                                 action="#{examLaboratorioFertilidadBean.adicionarRemisionEnfermedadesIniciales}">
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/editar.gif"/>
                  </h:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_ExamenEnfermedadesIniciales" for="dtExamenLaboratoriosEnfermedadesIniciales"
                                fastStep="20" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller"
                                paginator="true" immediate="true" paginatorMaxPages="9" paginatorTableClass="paginator"
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
        <s:fieldset legend="Criterios de Busqueda Laboratorios " id="fieldSetBuscadorLaboratorios"
                    styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridBuscarLaboratorios" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Codigo "/>
            <h:outputText value="Descripcion"/>
            <h:inputText value="#{examLaboratorioFertilidadBean.servicio.csvccodigo}"
                         onkeydown="return blockEnter(event);"/>
            <h:inputText value="#{examLaboratorioFertilidadBean.servicio.csvcnombre}"
                         onkeydown="return blockEnter(event);"/>
            <h:outputText value=""/>
            <h:outputText value="Descripcion 2"/>
            <h:selectOneRadio id="radioOpcion2" onkeydown="return blockEnter(event);"
                              value="#{examLaboratorioFertilidadBean.servicio.csvcopera1}">
              <f:selectItem itemValue="AND" itemLabel="AND"/>
              <f:selectItem itemValue="OR" itemLabel="OR"/>
            </h:selectOneRadio>
            <h:inputText value="#{examLaboratorioFertilidadBean.servicio.csvcnombre2}"
                         onkeydown="return blockEnter(event);"/>
            <h:outputText value=""/>
            <h:outputText value="Descripcion 3"/>
            <h:selectOneRadio id="radioOpcion3" onkeydown="return blockEnter(event);"
                              value="#{examLaboratorioFertilidadBean.servicio.csvcopera2}">
              <f:selectItem itemValue="AND" itemLabel="AND"/>
              <f:selectItem itemValue="OR" itemLabel="OR"/>
            </h:selectOneRadio>
            <h:inputText value="#{examLaboratorioFertilidadBean.servicio.csvcnombre3}"
                         onkeydown="return blockEnter(event);"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonConsulta"
                       columnClasses="columnaBotonesCentrados">
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionMessagesRegiones" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:message for="idButtonContrato" id="msgInformationAndErrorsR" errorClass="error"
                           infoClass="informacion"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <t:htmlTag value="br"/>
            <a4j:commandButton value="Buscar" action="#{examLaboratorioFertilidadBean.consultarLaboratorios}"
                               reRender="fieldSetLaboratoriosConsulta" styleClass="btn btn btn-success"
                               id="idButtonContrato"/>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Resultados Consulta" id="fieldSetLaboratoriosConsulta" styleClass="fieldset_dataTable">
          <h:panelGrid columns="1" id="panelGridNoLaboratorios"
                       rendered="#{empty examLaboratorioFertilidadBean.lstExamenesLaboratorios}">
            <h:outputText value="#{msg.msg_sin_consultar}"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0"
                       rendered="#{not empty examLaboratorioFertilidadBean.lstExamenesLaboratorios}" cellspacing="0"
                       width="100%" id="tableContentTabsBucar" styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                           binding="#{examLaboratorioFertilidadBean.dtServicios}"
                           value="#{examLaboratorioFertilidadBean.lstExamenesLaboratorios}" rows="10"
                           styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                           footerClass="paginacion" id="dtBucarLaboratorios">
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
                  <h:commandLink id="aceptarLaboratorios" action="#{examLaboratorioFertilidadBean.agregarRemision}">
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/adicionar.gif"/>
                  </h:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_1" for="dtBucarLaboratorios" fastStep="10" pageCountVar="pageCount"
                                pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
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
                <t:dataScroller id="scroll_2" for="dtBucarLaboratorios" immediate="true" rowsCountVar="rowsCount"
                                displayedRowsCountVar="displayedRowsCountVar" firstRowIndexVar="firstRowIndex"
                                lastRowIndexVar="lastRowIndex" pageCountVar="pageCount" pageIndexVar="pageIndex">
                  <h:outputFormat value="#{msg.msg_datos_tablas}" styleClass="standard">
                    <f:param value="#{rowsCount}"/>
                    <f:param value="#{displayedRowsCountVar}"/>
                    <f:param value="#{firstRowIndex}"/>
                    <f:param value="#{lastRowIndex}"/>
                    <f:param value="#{pageIndex}"/>
                    <f:param value="#{pageCount}"/>
                  </h:outputFormat>
                </t:dataScroller>
              </h:panelGrid>
            </t:buffer>
            <h:outputText value="#{tableScroller}" escape="false"/>
            <h:outputText value="#{table}" escape="false"/>
            <h:outputText value="#{tableScroller}" escape="false"/>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Lista Examenes Laboratorios " id="fieldExamenLaboratoriosLista" styleClass="fieldset">
          <h:panelGrid columns="1" id="panelGridNoLaboratoriosSeleccionados"
                       rendered="#{empty examLaboratorioFertilidadBean.lstRemision}">
            <h:outputText value="#{msg.msg_sin_consultar}"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0"
                       rendered="#{not empty examLaboratorioFertilidadBean.lstRemision}" cellspacing="0" width="100%"
                       id="panelExamenLaboratoriosTable" styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="0" cellpadding="0" binding="#{examLaboratorioFertilidadBean.dtRemision}"
                           cellspacing="0" value="#{examLaboratorioFertilidadBean.lstRemision}" rows="10"
                           styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                           footerClass="paginacion" id="dtExamenLaboratorios">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Examen"/>
                  </f:facet>
                  <h:outputText value="#{item.cpservicio.csvcnombre}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Eliminar"/>
                  </f:facet>
                  <h:commandLink id="eliminar" immediate="true" rendered="#{!item.modoconsulta}"
                                 action="#{examLaboratorioFertilidadBean.eliminarRemision}">
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/editar.gif"/>
                  </h:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_ExamenLaboratorios" for="dtExamenLaboratorios" fastStep="10"
                                pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                                immediate="true" paginatorMaxPages="9" paginatorTableClass="paginator"
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
        <s:fieldset legend="Observaciones " id="fieldObservaciones" styleClass="fieldset"
                    rendered="#{not empty examLaboratorioFertilidadBean.lstRemision}">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       rowClasses="labelText,labelTextInfo" id="panelGridObservaciones" styleClass="tabContainer">
            <h:outputText value="Observaciones "/>
            <h:panelGroup>
              <h:inputTextarea id="inputDescripcionRemision"
                               value="#{examLaboratorioFertilidadBean.descripcionRemision}" style="width:300px"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="inputDescripcionRemision" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionExamenesLaboratorioMsg" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgExamenesLaboratorioMsg" showSummary="false" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesControl"
                     columnClasses="panelGridBotones">
          <a4j:commandButton value="Generar Remision" styleClass="btn btn btn-success"
                             reRender="panelGridExamenLaboratoriosTab"
                             action="#{examLaboratorioFertilidadBean.generarRemision}"/>
        </h:panelGrid>
        <h:panelGrid></h:panelGrid>
      </h:panelGrid>
      <f:subview id="generarExamenLaboratorios" rendered="#{examLaboratorioFertilidadBean.generoDocPDF}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
        </f:verbatim>
      </f:subview>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>