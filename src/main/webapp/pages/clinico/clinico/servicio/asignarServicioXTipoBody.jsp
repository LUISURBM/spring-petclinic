<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="ajax"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<!-- registrarGrupoBody.jsp-->
<a4j:form id="infoAsignarServicioForm">
  <a4j:region id="bodyRegionAsignarServicio">
    <a4j:status for="bodyRegionAsignarServicio">
      <f:facet name="start">
        <t:div id="chargindAsignarServicio" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
     <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" 
                     activePanelTabVar="true" width="100%" id="panelTabbedPaneAsignarServicio" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" 
                     activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">

    
     <t:panelTab id="panelTabAsignarServicio" label="Asignar Servicio">
    <a4j:region renderRegionOnly="false">
      <s:fieldset legend="Tipo de Servicio" id="fieldSetInfoClase" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionAsignarServicio"
                     rowClasses="labelText,labelTextInfo">      
                     <h:outputText value = "Codigo Tipo Servicio" />
                     <h:outputText value = "Descripción Tipo Servicio" />
                     
                     <h:outputText value = "#{asignarServicioXTipoBean.tipoServicio.htsncodigo}" />
                     <h:outputText value = "#{asignarServicioXTipoBean.tipoServicio.htscdescripc}" />
                     
                     <h:outputText value = "Estado" />
                     <h:outputText value = ""/>
                     <h:outputText value = "#{asignarServicioXTipoBean.tipoServicio.htscdescestado}" />
                     <h:outputText value = ""/>
                  
        </h:panelGrid>
      </s:fieldset>
      
      
            <s:fieldset legend="Busqueda de Servicios " id="fieldSetBuscadorTipoServicio" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridBuscarImagenes"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Codigo "/>
            <h:outputText value="Descripcion"/>
            <h:inputText value="#{asignarServicioXTipoBean.servicio.csvccodigo}" onkeydown="return blockEnter(event);"/>
            <h:inputText value="#{asignarServicioXTipoBean.servicio.csvcnombre}" onkeydown="return blockEnter(event);"/>
            <h:outputText value=""/>
            <h:outputText value="Descripcion 2"/>
            <h:selectOneRadio id="radioOpcion2" onkeydown="return blockEnter(event);"
                              value="#{asignarServicioXTipoBean.servicio.csvcopera1}">
              <f:selectItem itemValue="AND" itemLabel="AND"/>
              <f:selectItem itemValue="OR" itemLabel="OR"/>
            </h:selectOneRadio>
            <h:inputText value="#{asignarServicioXTipoBean.servicio.csvcnombre2}" onkeydown="return blockEnter(event);"/>
            <h:outputText value=""/>
            <h:outputText value="Descripcion 3"/>
            <h:selectOneRadio id="radioOpcion3" onkeydown="return blockEnter(event);"
                              value="#{asignarServicioXTipoBean.servicio.csvcopera2}">
              <f:selectItem itemValue="AND" itemLabel="AND"/>
              <f:selectItem itemValue="OR" itemLabel="OR"/>
            </h:selectOneRadio>
            <h:inputText value="#{asignarServicioXTipoBean.servicio.csvcnombre3}" onkeydown="return blockEnter(event);"/>
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
            <a4j:commandButton value="Buscar" action="#{asignarServicioXTipoBean.consultarServicios}"
                               reRender="fieldSetTipoBean" styleClass="btn btn btn-success" id="idButtonContrato"/>
          </h:panelGrid>
        </s:fieldset>
        
        
          <s:fieldset legend="Resultados Consulta" id="fieldSetTipoBean" styleClass="fieldset_dataTable">
          <h:panelGrid columns="1" id="panelGridNoImagenes"
                       rendered="#{empty asignarServicioXTipoBean.lstServicios}">
            <h:outputText value="#{msg.msg_sin_consultar}"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0"
                       rendered="#{not empty asignarServicioXTipoBean.lstServicios}" cellspacing="0" width="100%"
                       id="tableContentTabsBucar" styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                           binding="#{asignarServicioXTipoBean.dtServicios}"
                           value="#{asignarServicioXTipoBean.lstServicios}" rows="10" styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                           id="dtBucarImagenes">
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
                  <h:commandLink id="aceptarImagenes" action="#{asignarServicioXTipoBean.agregarServicio}">
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/adicionar.gif"/>
                  </h:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_1" for="dtBucarImagenes" fastStep="10" pageCountVar="pageCount"
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
              </h:panelGrid>
            </t:buffer>
            <h:outputText value="#{tableScroller}" escape="false"/>
            <h:outputText value="#{table}" escape="false"/>
            <h:outputText value="#{tableScroller}" escape="false"/>
          </h:panelGrid>
        </s:fieldset>
        
        <s:fieldset legend="Servicios Asignados" id="fieldServiciosAsignados" styleClass="fieldset">
          <h:panelGrid columns="1" id="panelGridNoServiciosAsignados"
                       rendered="#{empty asignarServicioXTipoBean.lstServiciosAsignados}">
            <h:outputText value="#{msg.msg_sin_consultar}"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelExamenServiciosAsignadosTable"
                       styleClass="tabContainer" rendered="#{not empty asignarServicioXTipoBean.lstServiciosAsignados}">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="0" cellpadding="0" binding="#{asignarServicioXTipoBean.dtServiciosAsignados}"
                           cellspacing="0" value="#{asignarServicioXTipoBean.lstServiciosAsignados}" rows="30"
                           styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                           footerClass="paginacion" id="dtServiciosAsignados">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Codigo"/>
                  </f:facet>
                  <h:outputText value="#{item.comp_id.hstccodiserv}"/>
                </h:column>
                
                 <h:column>
                  <f:facet name="header">
                    <h:outputText value="Servicio"/>
                  </f:facet>
                  <h:outputText value="#{item.descServicio}"/>
                </h:column>
                
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Eliminar"/>
                  </f:facet>
                  <h:commandLink id="eliminar" immediate="true"
                                 action="#{asignarServicioXTipoBean.eliminarServicio}">
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/editar.gif"/>
                  </h:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_ExamenImagenes" for="dtServiciosAsignados" fastStep="30" pageCountVar="pageCount"
                                pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                paginatorMaxPages="30" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
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
          <t:commandLink action="#{asignarServicioXTipoBean.volver}" immediate="true">
            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
          </t:commandLink>
        </h:panelGrid>
      
         </a4j:region>
    </t:panelTab>
    </t:panelTabbedPane>
     <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMensajes" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInf" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                          infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      
  </a4j:region>
</a4j:form>