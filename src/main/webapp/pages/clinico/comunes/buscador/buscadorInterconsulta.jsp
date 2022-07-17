<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<s:fieldset legend="Criterios de Busqueda >Interconsulta" id="fieldSetBuscadorInterconsulta" 
styleClass="fieldset">
  <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridPlantillasInterconsulta"
               rowClasses="labelText,labelTextInfo">
    <h:outputText value="Codigo Cups "/>
    <h:outputText value="Descripción"/>
    <h:inputText value="#{buscadorInterconsultaBean.interconsulta.hticcodigo}" style="width:200px"
                 onkeydown="return blockEnter(event);"/>
    <h:inputText value="#{buscadorInterconsultaBean.interconsulta.hticdescripcio}"
                 onkeydown="return blockEnter(event);"/>
  </h:panelGrid>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonInterconsulta"
               columnClasses="columnaBotonesCentrados">
    <h:panelGroup>
      <a4j:outputPanel id="ajaxRegionMessagesRegionesInterconsulta" ajaxRendered="true">
        <t:htmlTag value="br"/>
        <t:message for="idButtonInterconsulta" id="msgInformationAndErrorsInterconsulta" errorClass="error" infoClass="informacion"/>
      </a4j:outputPanel>
    </h:panelGroup>
    <t:htmlTag value="br"/>
    <a4j:commandButton value="Buscar" action="#{buscadorInterconsultaBean.consultarInterconsulta}"
                       reRender="fieldInterconsulta" styleClass="btn btn btn-success" id="idButtonInterconsulta"/>
  </h:panelGrid>
</s:fieldset>
<s:fieldset legend="Lista Interconsultas" id="fieldInterconsulta" styleClass="fieldset">
  <h:panelGrid columns="1" id="panelGridNoInterconsultaSeleccionados"
               rendered="#{empty buscadorInterconsultaBean.lstInterconsulta}">
    <h:outputText value="#{msg.msg_sin_consultar}"/>
  </h:panelGrid>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelInterconsultaTable"
               styleClass="tabContainer" rendered="#{not empty buscadorInterconsultaBean.lstInterconsulta}">
    <t:buffer into="#{table}">
      <h:dataTable var="item" border="0" cellpadding="0" binding="#{buscadorInterconsultaBean.dtInterconsulta}"
                   cellspacing="0" value="#{buscadorInterconsultaBean.lstInterconsulta}" rows="10"
                   styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                   footerClass="paginacion" id="dtInterconsulta">
        <h:column>
          <f:facet name="header">
            <h:outputText value="Codigo Cups"/>
          </f:facet>
          <h:outputText value="#{item.hticcodigo}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Descripción Interconsulta"/>
          </f:facet>
          <t:div style="overflow:auto;width:500px;height:50px;">
            <h:panelGrid>
              <h:outputText value="#{item.hticdescripcio}"/>
            </h:panelGrid>
          </t:div>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Seleccione"/>
          </f:facet>
          <a4j:commandLink id="aceptarInterconsulta" action="#{buscadorInterconsultaBean.selectInterconsulta}"
                           reRender="#{buscadorInterconsultaBean.tagRenderizar}">
            <t:graphicImage alt="" border="0" url="/comun/imagenes/adicionar.gif"/>
          </a4j:commandLink>
        </h:column>
      </h:dataTable>
    </t:buffer>
    <t:buffer into="#{tableScroller}">
      <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
        <t:dataScroller id="scroll_Interconsulta" for="dtInterconsulta" fastStep="10" pageCountVar="pageCount"
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