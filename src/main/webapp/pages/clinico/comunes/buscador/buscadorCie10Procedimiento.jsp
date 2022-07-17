<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<s:fieldset legend="Criterios de Busqueda CIE10 " id="fieldSetBuscadorCie10Procedimiento"
            styleClass="fieldset">
  <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridCie10Procedimiento"
               rowClasses="labelText,labelTextInfo">
    <h:outputText value="Codigo "/>
    <h:outputText value="Descripcion 1"/>
   
    
    <h:inputText value="#{buscadorCie10Bean.cie10.cdcccodigo}" style="width:50px"
                 onkeydown="return blockEnter(event);"/>
                 
    <h:inputText value="#{buscadorCie10Bean.cie10.cdccdescri}"
                 onkeydown="return blockEnter(event);"/>
                 
     <h:outputText value=""/>
    <h:outputText value="Descripcion 2"/>
                 
    <h:selectOneRadio id="radioOpcionProcedimiento" 
        value="#{buscadorCie10Bean.cie10.cdccopera1}">
      <f:selectItem itemValue="AND" itemLabel="AND"/>
      <f:selectItem itemValue="OR" itemLabel="OR"/>
    </h:selectOneRadio>
    
    <h:inputText value="#{buscadorCie10Bean.cie10.cdccdescri2}"
                 onkeydown="return blockEnter(event);"/>
                 
    <h:outputText value=" "/>
    <h:outputText value="Descripcion 3"/>

    
      <h:selectOneRadio id="radioOpcionProcedimiento2" value="#{buscadorCie10Bean.cie10.cdccopera2}">
      <f:selectItem itemValue="Y" itemLabel="AND"/>
      <f:selectItem itemValue="O" itemLabel="OR"/>
    </h:selectOneRadio>
    
     
     <h:inputText value="#{buscadorCie10Bean.cie10.cdccdescri3}"
            onkeydown="return blockEnter(event);"/>
            
 
  </h:panelGrid>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelBotonConsultaProcedimiento"
               columnClasses="columnaBotonesCentrados">
    <h:panelGroup>
      <a4j:outputPanel id="ajaxRegionMessagesRegionesProcedimiento" ajaxRendered="true">
        <t:htmlTag value="br"/>
        <t:message for="idButtonContratoProcedimiento" id="msgInformationAndErrorsRProcedimiento"
                   errorClass="error" infoClass="informacion"/>
      </a4j:outputPanel>
    </h:panelGroup>
    <t:htmlTag value="br"/>
    <a4j:commandButton value="Buscar" action="#{buscadorCie10Bean.consultarCie10}"
                       reRender="fieldSetResConsultaProcedimiento"
                       styleClass="btn btn btn-success" id="idButtonContratoProcedimiento"/>
  </h:panelGrid>
</s:fieldset>
<s:fieldset legend="Resultados Consulta" id="fieldSetResConsultaProcedimiento"
            styleClass="fieldset_dataTable">
         <h:panelGrid columns="1" id="panelGridConsultarProcedimiento"
                     rendered="#{empty buscadorCie10Bean.listCIE10}">
          <h:outputText value="#{msg.msg_sin_consultar}"/>
        </h:panelGrid>     
            
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="tableContentTabsBucarProcedimiento"
                rendered="#{not empty buscadorCie10Bean.listCIE10}"
               styleClass="tabContainer">
    <t:buffer into="#{table}">
      <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                   binding="#{buscadorCie10Bean.dtConsultas}"
                   value="#{buscadorCie10Bean.listCIE10}" rows="10"
                   styleClass="standard_table"
                   rowClasses="standardTable_Row1,standardTable_Row2"
                   footerClass="paginacion" id="dtCieProcedimiento">
        <h:column>
          <f:facet name="header">
            <h:outputText value="Codigo"/>
          </f:facet>
          <h:outputText value="#{item.cdcccodigo}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Descripción"/>
          </f:facet>
          <h:outputText value="#{item.cdccdescri}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Sexo"/>
          </f:facet>
          <h:outputText value="#{item.cdccsexo}"/>
        </h:column>
       <h:column>
          <f:facet name="header">
            <h:outputText value="Seleccione"/>
          </f:facet>
          <a4j:commandLink id="aceptarCie10Procedimiento" immediate="true"
                         reRender="fieldSetResDiagnosticoprocedimiento"
                         action="#{buscadorCie10Bean.seleccionarCie10}">
            <t:graphicImage alt=""  border="0" url="/comun/imagenes/adicionar.gif"/>
          </a4j:commandLink>
        </h:column>
      </h:dataTable>
    </t:buffer>
    <t:buffer into="#{tableScroller}">
      <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
        <t:dataScroller id="scroll_1_procedimiento" for="dtCieProcedimiento" fastStep="10"
                        pageCountVar="pageCount" pageIndexVar="pageIndex"
                        styleClass="scroller" paginator="true" immediate="true"
                        paginatorMaxPages="9" paginatorTableClass="paginator"
                        renderFacetsIfSinglePage="false"
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
         <t:dataScroller id="scroll_2_procedimiento" for="dtCieProcedimiento" immediate="true" rowsCountVar="rowsCount" displayedRowsCountVar="displayedRowsCountVar"
                                                            firstRowIndexVar="firstRowIndex" lastRowIndexVar="lastRowIndex" pageCountVar="pageCount" pageIndexVar="pageIndex">
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
<s:fieldset legend="Diagnostico Seleccionado" id="fieldSetResDiagnosticoprocedimiento"
            styleClass="fieldset_dataTable">
  <h:outputText value="#{buscadorCie10Bean.cie10Select.cdccdescri}"/>
</s:fieldset>
