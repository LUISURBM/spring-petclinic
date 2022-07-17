<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<s:fieldset legend="Criterios de Búsqueda Controles " id="fieldSetBuscadorControles" styleClass="fieldset">
    <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="panelGridBuscarControles" rowClasses="labelText,labelTextInfo">
    <h:outputText value="Código "/>
    
    <h:outputText value="Descripcion 1"/>
    <h:inputText value="#{buscadorControlesBean.servicio.csvccodigo}" onkeydown="return blockEnter(event);"/>
    <h:inputText value="#{buscadorControlesBean.servicio.csvcnombre}" onkeydown="return blockEnter(event);"/>
    <h:outputText value=""/>
    
    <h:outputText value="Descripcion 2"/>
    <h:selectOneRadio id="radioOpcion2" value="#{buscadorControlesBean.servicio.csvcopera1}">
        <f:selectItem itemValue="AND" itemLabel="AND"/>
        <f:selectItem itemValue="OR" itemLabel="OR"/>
    </h:selectOneRadio>
    <h:inputText value="#{buscadorControlesBean.servicio.csvcnombre2}" onkeydown="return blockEnter(event);"/>
    
    <h:outputText value=""/>
    <h:outputText value="Descripcion 3"/>
    <h:selectOneRadio id="radioOpcion3" value="#{buscadorControlesBean.servicio.csvcopera2}">
        <f:selectItem itemValue="AND" itemLabel="AND"/>
        <f:selectItem itemValue="OR" itemLabel="OR"/>
    </h:selectOneRadio>
    <h:inputText value="#{buscadorControlesBean.servicio.csvcnombre3}" onkeydown="return blockEnter(event);"/>
    
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonConsulta" columnClasses="columnaBotonesCentrados">
    <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMessagesRegiones" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:message for="idButt" id="msgInformationAndErrorsR" errorClass="error" infoClass="informacion"/>
        </a4j:outputPanel>
    </h:panelGroup>
    <a4j:commandButton value="Buscar" action="#{buscadorControlesBean.consultarControles}" 
                       reRender="fieldSetControlesConsulta" styleClass="btn btn btn-success" id="idButt"/>
    </h:panelGrid>
</s:fieldset>

<s:fieldset legend="Resultados Consulta" id="fieldSetControlesConsulta" styleClass="fieldset_dataTable">
  <h:panelGrid columns="1" id="panelGridNoControles" rendered="#{empty buscadorControlesBean.lstControles}">
    <h:outputText value="#{msg.msg_sin_consultar}"/>
  </h:panelGrid>
  <h:panelGrid columns="1" border="0" cellpadding="0" rendered="#{not empty buscadorControlesBean.lstControles}" 
               cellspacing="0" width="100%" id="tableContentTabsBucar" styleClass="tabContainer">
    <t:buffer into="#{table}">
      <h:dataTable var="item" border="0" cellpadding="0" cellspacing="2" binding="#{buscadorControlesBean.dtServicios}" 
                   value="#{buscadorControlesBean.lstControles}" rows="10"
                   styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" 
                   footerClass="paginacion" id="dtControlesBuscador">
        <h:column>
          <f:facet name="header">
            <h:outputText value="Código"/>
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
          <a4j:commandLink id="aceptarControles" reRender="tableContentTabsBucar, fieldSetControlesConsulta, fieldExamenControlSeleccionado"
                rendered="#{empty buscadorControlesBean.lstControlSelec}"
                action="#{buscadorControlesBean.agregarServicio}">
            <t:graphicImage alt=""  border="0" url="/comun/imagenes/adicionar.gif"/>
          </a4j:commandLink>
        </h:column>
      </h:dataTable>
    </t:buffer>
    <t:buffer into="#{tableScroller}">
      <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
        <t:dataScroller id="scroll_1" for="dtControlesBuscador" fastStep="10" pageCountVar="pageCount" 
                pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false" 
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

<s:fieldset legend="Lista Controles Seleccionados/Incluidos" id="fieldExamenControlSeleccionado" styleClass="fieldset" >
    <h:panelGrid columns="1" id="panelGridNoControlesSeleccionados" rendered="#{empty buscadorControlesBean.lstControlSelec}">
        <h:outputText value="#{msg.msg_sin_consultar}"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" rendered="#{not empty buscadorControlesBean.lstControlSelec}" 
                 cellspacing="0" width="100%" id="panelControlSeleccionadoTable" styleClass="tabContainer">
        <t:buffer into="#{table}">
            <h:dataTable var="item" border="0" cellpadding="0" binding="#{buscadorControlesBean.dtControlesSelec}"
                    cellspacing="2" value="#{buscadorControlesBean.lstControlSelec}" rows="10"
                    styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" 
                    footerClass="paginacion" id="dtControles">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Control"/>
                  </f:facet>
                  <h:outputText value="#{item.csvcnombre}"/>
                </h:column>
                
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Observación Control"/>
                  </f:facet>
                  <h:inputText value="#{item.observaciones}" disabled="#{item.agregado}"
                        required="true" maxlength="40">
                    <a4j:support id="changeObservaciones" event="onchange"
                            reRender="tableContentTabsBucar">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:inputText>
                </h:column>
                
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Eliminar"/>
                  </f:facet>
                  <h:commandLink id="eliminar" immediate="true" rendered="#{not item.agregado}"
                    action="#{buscadorControlesBean.eliminarServicio}">
                    <t:graphicImage alt=""  border="0" url="/comun/imagenes/quitar.gif"/>
                  </h:commandLink>
                </h:column>
            </h:dataTable>
        </t:buffer>
        <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_ExamenLaboratorios" for="dtControles" fastStep="10" 
                        pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" 
                        paginator="true" immediate="true" paginatorMaxPages="9" paginatorTableClass="paginator" 
                        renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
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