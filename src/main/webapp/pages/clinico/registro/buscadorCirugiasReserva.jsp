<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<s:fieldset legend="Criterios de Busqueda Cirugias "
            id="fieldSetBusCirugias" styleClass="fieldset">
  <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridBuscarCirugias"
               rowClasses="labelText,labelTextInfo">
    <h:outputText value="Codigo "/>
    <h:outputText value="Descripcion"/>
    <h:inputText value="#{buscadorCirugiasReservaBean.servicio.csvccodigo}"
                 onkeydown="return blockEnter(event);"/>
    <h:inputText value="#{buscadorCirugiasReservaBean.servicio.csvcnombre}"
                 onkeydown="return blockEnter(event);"/>
                 
                    <h:outputText value=""/>
    <h:outputText value="Descripcion 2"/>
                 
    <h:selectOneRadio id="radioOpcion2" value="#{buscadorCirugiasReservaBean.servicio.csvcopera1}">
      <f:selectItem itemValue="AND" itemLabel="AND"/>
      <f:selectItem itemValue="OR" itemLabel="OR"/>
    </h:selectOneRadio>
    
    <h:inputText value="#{buscadorCirugiasReservaBean.servicio.csvcnombre2}" onkeydown="return blockEnter(event);"/>
    
    <h:outputText value=""/>
    <h:outputText value="Descripcion 3"/>
    
    <h:selectOneRadio id="radioOpcion3" value="#{buscadorCirugiasReservaBean.servicio.csvcopera2}">
      <f:selectItem itemValue="AND" itemLabel="AND"/>
      <f:selectItem itemValue="OR" itemLabel="OR"/>
    </h:selectOneRadio>
    
    <h:inputText value="#{buscadorCirugiasReservaBean.servicio.csvcnombre3}" onkeydown="return blockEnter(event);"/>
    
    
  </h:panelGrid>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelBotonConsulta"
               columnClasses="columnaBotonesCentrados">
    <h:panelGroup>
      <a4j:outputPanel id="ajaxRegionMessagesRegiones" ajaxRendered="true">
        <t:htmlTag value="br"/>
        <t:message for="idButt" id="msgInformationAndErrorsR"
                   errorClass="error" infoClass="informacion"/>
      </a4j:outputPanel>
    </h:panelGroup>
    <a4j:commandButton value="Buscar"
                       action="#{buscadorCirugiasReservaBean.consultarCirugias}"
                       reRender="fieldSetCirugiasConsulta"
                       styleClass="boton_fieldset" id="idButt"/>
  </h:panelGrid>
</s:fieldset>
<s:fieldset legend="Resultados Consulta" id="fieldSetCirugiasConsulta"
            styleClass="fieldset_dataTable">
  <h:panelGrid columns="1" id="panelGridNoCirugias"
               rendered="#{empty buscadorCirugiasReservaBean.lstExamenesCirugias}">
    <h:outputText value="#{msg.msg_sin_consultar}"/>
  </h:panelGrid>
  <h:panelGrid columns="1" border="0" cellpadding="0"
               rendered="#{not empty buscadorCirugiasReservaBean.lstExamenesCirugias}"
               cellspacing="0" width="100%" id="tableContentTabsBucar"
               styleClass="tabContainer">
    <t:buffer into="#{table}">
      <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                   binding="#{buscadorCirugiasReservaBean.dtServicios}"
                   value="#{buscadorCirugiasReservaBean.lstExamenesCirugias}" rows="10"
                   styleClass="standard_table"
                   rowClasses="standardTable_Row1,standardTable_Row2"
                   footerClass="paginacion" id="dtCirBus">
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
          <a4j:commandLink id="aceptarCirugias" reRender="fieldExamenCirugiaSeleccionada"
                         action="#{buscadorCirugiasReservaBean.agregarIntervencion}">
            <t:graphicImage alt=""  border="0" url="/comun/imagenes/adicionar.gif"/>
          </a4j:commandLink>
        </h:column>
      </h:dataTable>
    </t:buffer>
    <t:buffer into="#{tableScroller}">
      <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
        <t:dataScroller id="scroll_1" for="dtCirBus" fastStep="10"
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
      </h:panelGrid>
    </t:buffer>
    <h:outputText value="#{tableScroller}" escape="false"/>
    <h:outputText value="#{table}" escape="false"/>
    <h:outputText value="#{tableScroller}" escape="false"/>
  </h:panelGrid>
</s:fieldset>
<s:fieldset legend="Lista Cirugias Seleccionadas"
            id="fieldExamenCirugiaSeleccionada" styleClass="fieldset">
  <h:panelGrid columns="1" id="panelGridNoCirugiasSeleccionados"
               rendered="#{empty buscadorCirugiasReservaBean.lstCirugiaSelec}">
    <h:outputText value="#{msg.msg_sin_consultar}"/>
  </h:panelGrid>
  <h:panelGrid columns="1" border="0" cellpadding="0"
               rendered="#{not empty buscadorCirugiasReservaBean.lstCirugiaSelec}"
               cellspacing="0" width="100%" id="panelCirugiaSeleccionadaTable"
               styleClass="tabContainer">
    <t:buffer into="#{table}">
      <h:dataTable var="item" border="1" cellpadding="0"
                   binding="#{buscadorCirugiasReservaBean.dtCirugiasSelec}"
                   cellspacing="0"
                   value="#{buscadorCirugiasReservaBean.lstCirugiaSelec}" rows="10"
                   styleClass="standard_table"
                   rowClasses="standardTable_Row1,standardTable_Row2"
                   footerClass="paginacion" id="dtCirugias">
        <h:column>
          <f:facet name="header">
            <h:outputText value="Examen"/>
          </f:facet>
          <h:outputText value="#{item.csvcnombre}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Eliminar"/>
          </f:facet>
          <h:commandLink id="eliminar" immediate="true"
                         action="#{buscadorCirugiasReservaBean.eliminarCirugia}">
            <t:graphicImage alt=""  border="0" url="/comun/imagenes/editar.gif"/>
          </h:commandLink>
        </h:column>
      </h:dataTable>
    </t:buffer>
    <t:buffer into="#{tableScroller}">
      <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
        <t:dataScroller id="scroll_ExamenLaboratorios" for="dtCirugias"
                        fastStep="10" pageCountVar="pageCount"
                        pageIndexVar="pageIndex" styleClass="scroller"
                        paginator="true" immediate="true" paginatorMaxPages="9"
                        paginatorTableClass="paginator"
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
      </h:panelGrid>
    </t:buffer>
                      <h:outputText value="#{tableScroller}" escape="false"/>
                  <h:outputText value="#{table}" escape="false"/>
                  <h:outputText value="#{tableScroller}" escape="false"/>
  </h:panelGrid>
</s:fieldset>
