<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<s:fieldset legend="Criterios de Búsqueda consentimientos " id="fieldSetBuscadorConsentimientos" styleClass="fieldset">
  <a4j:region renderRegionOnly="false">
    <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="panelGridBuscarConsentimientos" rowClasses="labelText,labelTextInfo">
    <h:outputText value="Código "/>
    <h:outputText value="Descripción"/>
    <h:inputText value="#{buscadorConsentimientoBean.chplanconsinfoBusqueda.hpciccodigo}" onkeydown="return blockEnter(event);"/>
    <h:inputText value="#{buscadorConsentimientoBean.chplanconsinfoBusqueda.hpcicnombre}" onkeydown="return blockEnter(event);"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonConsulta" columnClasses="columnaBotonesCentrados">
    <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMessagesRegiones" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:message for="idButt" id="msgInformationAndErrorsR" errorClass="error" infoClass="informacion"/>
        </a4j:outputPanel>
    </h:panelGroup>
   
    <a4j:commandButton value="Buscar" action="#{buscadorConsentimientoBean.consultarConsentimientos}" 
                       reRender="fieldSetConsentimientosConsulta" styleClass="btn btn btn-success" id="idButt"/>
    </h:panelGrid>
    </a4j:region>
</s:fieldset>
<s:fieldset legend="Lista Consentimientos" id="fieldSetConsentimientosConsulta" styleClass="fieldset_dataTable">
  <h:panelGrid columns="1" id="panelGridNoCirugias" rendered="#{empty buscadorConsentimientoBean.lstConsentimientoInformado}">
    <h:outputText value="#{msg.msg_sin_consultar}"/>
  </h:panelGrid>
  <h:panelGrid columns="1" border="0" cellpadding="0" rendered="#{not empty buscadorConsentimientoBean.lstConsentimientoInformado}" cellspacing="0" width="100%" id="tableContentTabsBucar"
               styleClass="tabContainer">
    <t:buffer into="#{table}">
      <h:dataTable var="item" border="0" cellpadding="0" cellspacing="2" binding="#{buscadorConsentimientoBean.dtConsentimiento}" value="#{buscadorConsentimientoBean.lstConsentimientoInformado}" rows="10"
                   styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtConsentimientoBuscador">
        <h:column>
          <f:facet name="header">
            <h:outputText value="Codigo"/>
          </f:facet>
          <h:outputText value="#{item.hpciccodigo}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Nombre"/>
          </f:facet>
          <h:outputText value="#{item.hpcicnombre}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Seleccionar"/>
          </f:facet>
          <a4j:commandLink id="aceptarConsentiemiento" reRender="fieldConsentimientoSeleccionado" immediate="true" action="#{buscadorConsentimientoBean.agregarConsentimiento}">
            <t:graphicImage alt=""  border="0" url="/comun/imagenes/adicionar.gif"/>
          </a4j:commandLink>
        </h:column>
      </h:dataTable>
    </t:buffer>
    <t:buffer into="#{tableScroller}">
      <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
        <t:dataScroller id="scroll_1" for="dtConsentimientoBuscador" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
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
<s:fieldset legend="Lista consentimiento seleccionados" id="fieldConsentimientoSeleccionado" styleClass="fieldset" >
  <h:panelGrid columns="1" id="panelGridNoConsentimientosSeleccionados" rendered="#{empty buscadorConsentimientoBean.lstConsentimientoSelec}">
    <h:outputText value="#{msg.msg_sin_consultar}"/>
  </h:panelGrid>
  <h:panelGrid columns="1" border="0" cellpadding="0" rendered="#{not empty buscadorConsentimientoBean.lstConsentimientoSelec}" cellspacing="0" width="100%" id="panelConsentimientoSeleccionadoTable"
               styleClass="tabContainer">
    <t:buffer into="#{table}">
      <h:dataTable var="item" border="0" cellpadding="0" binding="#{buscadorConsentimientoBean.dtConsentimientoSelec}" cellspacing="2" value="#{buscadorConsentimientoBean.lstConsentimientoSelec}" rows="10"
                   styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtConsentimientos">
        <h:column>
          <f:facet name="header">
            <h:outputText value="Codigo"/>
          </f:facet>
          <h:outputText value="#{item.hpciccodigo}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Nombre"/>
          </f:facet>
          <h:outputText value="#{item.hpcicnombre}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Eliminar"/>
          </f:facet>
          <h:commandLink id="eliminar" immediate="true" action="#{buscadorConsentimientoBean.eliminarConsentimiento}">
            <t:graphicImage alt=""  border="0" url="/comun/imagenes/quitar.gif"/>
          </h:commandLink>
        </h:column>
      </h:dataTable>
    </t:buffer>
    <t:buffer into="#{tableScroller}">
      <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
        <t:dataScroller id="scroll_Consentimientos" for="dtConsentimientos" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
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