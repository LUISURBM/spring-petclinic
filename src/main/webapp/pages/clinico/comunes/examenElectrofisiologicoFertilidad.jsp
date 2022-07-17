<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridExamenElectrofisiologicoTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneExamenElectrofisiologico" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabExamenElectrofisiologico" label="Examenes Electrofisiologicos">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridExamenElectrofisiologico" styleClass="tabContainer">
      
        <s:fieldset legend=" Busqueda de Examenes Electrofisiologicos " id="fieldSetBuscadorElectrofisiologicos" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridBuscarElectrofisiologicos" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Codigo "/>
            <h:outputText value="Descripcion"/>
            <h:inputText value="#{examElectrofisiologicoFertilidadBean.servicio.csvccodigo}" onkeydown="return blockEnter(event);"/>
            <h:inputText value="#{examElectrofisiologicoFertilidadBean.servicio.csvcnombre}" onkeydown="return blockEnter(event);"/>
            
                <h:outputText value=""/>
    <h:outputText value="Descripcion 2"/>
                 
    <h:selectOneRadio id="radioOpcion2" onkeydown="return blockEnter(event);" value="#{examElectrofisiologicoFertilidadBean.servicio.csvcopera1}" >
      <f:selectItem itemValue="AND" itemLabel="AND"/>
      <f:selectItem itemValue="OR" itemLabel="OR"/>
    </h:selectOneRadio>
    
    <h:inputText value="#{examElectrofisiologicoFertilidadBean.servicio.csvcnombre2}" onkeydown="return blockEnter(event);"/>
    
    <h:outputText value=""/>
    <h:outputText value="Descripcion 3"/>
    
    <h:selectOneRadio id="radioOpcion3" value="#{examElectrofisiologicoFertilidadBean.servicio.csvcopera2}" onkeydown="return blockEnter(event);">
      <f:selectItem itemValue="AND" itemLabel="AND"/>
      <f:selectItem itemValue="OR" itemLabel="OR"/>
    </h:selectOneRadio>
    
    <h:inputText value="#{examElectrofisiologicoFertilidadBean.servicio.csvcnombre3}" onkeydown="return blockEnter(event);"/>
            
            
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonConsulta" columnClasses="columnaBotonesCentrados">
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionMessagesRegiones" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:message for="idButtonContrato" id="msgInformationAndErrorsR" errorClass="error" infoClass="informacion"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <t:htmlTag value="br"/>
            <a4j:commandButton value="Buscar" action="#{examElectrofisiologicoFertilidadBean.consultarElectrofisiologicos}" reRender="fieldSetElectrofisiologicosConsulta" styleClass="btn btn btn-success" id="idButtonContrato"/>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Resultados Consulta"  id="fieldSetElectrofisiologicosConsulta" styleClass="fieldset_dataTable">
          <h:panelGrid columns="1" id="panelGridNoElectrofisiologicos" rendered="#{empty examElectrofisiologicoFertilidadBean.lstExamenesElectrofisiologicos}">
            <h:outputText value="#{msg.msg_sin_consultar}"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" rendered="#{not empty examElectrofisiologicoFertilidadBean.lstExamenesElectrofisiologicos}" cellspacing="0" width="100%" id="tableContentTabsBucar"
                       styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0" binding="#{examElectrofisiologicoFertilidadBean.dtServicios}" value="#{examElectrofisiologicoFertilidadBean.lstExamenesElectrofisiologicos}" rows="10"
                           styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtBucarElectrofisiologicos">
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
                  <h:commandLink id="aceptarElectrofisiologicos" action="#{examElectrofisiologicoFertilidadBean.agregarRemision}">
                    <t:graphicImage alt=""  border="0" url="/comun/imagenes/adicionar.gif"/>
                  </h:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_1" for="dtBucarElectrofisiologicos" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
                  <f:facet name="first">
                    <t:graphicImage alt=""  url="/comun/imagenes/primero.gif" border="0"/>
                  </f:facet>
                  <f:facet name="last">
                    <t:graphicImage alt=""  url="/comun/imagenes/ultimo.gif" border="0"/>
                  </f:facet>
                  <f:facet name="previous">
                    <t:graphicImage alt=""  url="/comun/imagenes/anterior.gif" border="0"/>
                  </f:facet>
                  <f:facet name="next">
                    <t:graphicImage alt=""  url="/comun/imagenes/siguiente.gif" border="0"/>
                  </f:facet>
                  <f:facet name="fastforward">
                    <t:graphicImage alt=""  url="/comun/imagenes/adelante.gif" border="0"/>
                  </f:facet>
                  <f:facet name="fastrewind">
                    <t:graphicImage alt=""  url="/comun/imagenes/atras.gif" border="0"/>
                  </f:facet>
                </t:dataScroller>
              </h:panelGrid>
            </t:buffer>
            <h:outputText value="#{tableScroller}" escape="false"/>
            <h:outputText value="#{table}" escape="false"/>
            <h:outputText value="#{tableScroller}" escape="false"/>
          </h:panelGrid>
        </s:fieldset>
      <s:fieldset legend="Lista Examenes Electrofisiologicos " id="fieldExamenElectrofisiologicoLista" styleClass="fieldset">
      
        <h:panelGrid columns="1" id="panelGridNoElectrofisiologicosSeleccionados" rendered="#{empty examElectrofisiologicoFertilidadBean.lstRemision}">
            <h:outputText value="#{msg.msg_sin_consultar}"/>
          </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelExamenElectrofisiologicoTable" styleClass="tabContainer" rendered="#{not empty examElectrofisiologicoFertilidadBean.lstRemision}">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="0" cellpadding="0" binding="#{examElectrofisiologicoFertilidadBean.dtRemision}" cellspacing="0" value="#{examElectrofisiologicoFertilidadBean.lstRemision}"
                               rows="10" styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtExamenElectrofisiologico">
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
                      action="#{examElectrofisiologicoFertilidadBean.eliminarRemision}">
                        <t:graphicImage  alt="" border="0" url="/comun/imagenes/editar.gif"/>
                      </h:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_ExamenElectrofisiologico" for="dtExamenElectrofisiologico" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller"
                                    paginator="true" immediate="true" paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                                    paginatorActiveColumnStyle="font-weight:bold;">
                      <f:facet name="first">
                        <t:graphicImage alt=""  url="/comun/imagenes/primero.gif" border="0"/>
                      </f:facet>
                      <f:facet name="last">
                        <t:graphicImage alt=""  url="/comun/imagenes/ultimo.gif" border="0"/>
                      </f:facet>
                      <f:facet name="previous">
                        <t:graphicImage alt=""  url="/comun/imagenes/anterior.gif" border="0"/>
                      </f:facet>
                      <f:facet name="next">
                        <t:graphicImage alt=""  url="/comun/imagenes/siguiente.gif" border="0"/>
                      </f:facet>
                      <f:facet name="fastforward">
                        <t:graphicImage alt=""  url="/comun/imagenes/adelante.gif" border="0"/>
                      </f:facet>
                      <f:facet name="fastrewind">
                        <t:graphicImage alt=""  url="/comun/imagenes/atras.gif" border="0"/>
                      </f:facet>
                    </t:dataScroller>
                  </h:panelGrid>
                </t:buffer>
                  <h:outputText value="#{tableScroller}" escape="false"/>
                  <h:outputText value="#{table}" escape="false"/>
                  <h:outputText value="#{tableScroller}" escape="false"/>
              </h:panelGrid>
            </s:fieldset>
        <a4j:region renderRegionOnly="false">
          <s:fieldset legend="Observaciones " id="fieldObservaciones" styleClass="fieldset" rendered="#{not empty examElectrofisiologicoFertilidadBean.lstRemision}">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridObservaciones" rowClasses="labelText" styleClass="tabContainer">
              <h:outputText value="Observaciones "/>
              <h:panelGroup>
                <h:inputTextarea id="inputDescripcionRemision" value="#{examElectrofisiologicoFertilidadBean.descripcionRemision}" 
                                 style="width:300px"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="inputDescripcionRemision" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </s:fieldset>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionExamenesElectrofisiologicosMsg" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgExamenesElectrofisiologicosMsg" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                          warnClass="advertencia"/>
              <t:htmlTag value="br"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesControl" columnClasses="panelGridBotones">
            <a4j:commandButton value="Generar Remision" styleClass="btn btn btn-success" reRender="panelGridExamenElectrofisiologicoTab" 
                               action="#{examElectrofisiologicoFertilidadBean.generarRemision}"/>
          </h:panelGrid>
        </a4j:region>
        <h:panelGrid></h:panelGrid>
      </h:panelGrid>
        <f:subview id="generarExamenElectrofisiologico"
                       rendered="#{examElectrofisiologicoFertilidadBean.generoDocPDF}">
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