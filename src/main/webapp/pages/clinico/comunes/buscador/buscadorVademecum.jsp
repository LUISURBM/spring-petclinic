<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<s:fieldset legend="Busqueda Vademecum " id="fieldSetBuscadorVademecum" styleClass="fieldset">
  <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridBuscarVademecum"
               rowClasses="labelText,labelTextInfo">
    <h:outputText value="Codigo "/>
    <h:outputText value="Descripcion 1"/>
    <h:inputText value="#{buscadorVademecumBean.medicamento.hvpnconsecutiv}" onkeydown="return blockEnter(event);"/>
    <h:inputText value="#{buscadorVademecumBean.medicamento.hvpcprincactiv}" onkeydown="return blockEnter(event);"/>
    <h:outputText value=""/>
    <h:outputText value="Descripcion 2"/>
    <h:selectOneRadio id="radioOpcion2" value="#{buscadorVademecumBean.medicamento.hvpcopera1}">
      <f:selectItem itemValue="AND" itemLabel="AND"/>
      <f:selectItem itemValue="OR" itemLabel="OR"/>
    </h:selectOneRadio>
    <h:inputText value="#{buscadorVademecumBean.medicamento.hvpcprincactiv2}" onkeydown="return blockEnter(event);"/>
    <h:outputText value=""/>
    <h:outputText value="Descripcion 3"/>
    <h:selectOneRadio id="radioOpcion3" value="#{buscadorVademecumBean.medicamento.hvpcopera2}">
      <f:selectItem itemValue="AND" itemLabel="AND"/>
      <f:selectItem itemValue="OR" itemLabel="OR"/>
    </h:selectOneRadio>
    <h:inputText value="#{buscadorVademecumBean.medicamento.hvpcprincactiv3}" onkeydown="return blockEnter(event);"/>
  </h:panelGrid>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonConsulta"
               columnClasses="columnaBotonesCentrados">
    <h:panelGroup>
      <a4j:outputPanel id="ajaxRegionMessagesRegiones" ajaxRendered="true">
        <t:htmlTag value="br"/>
        <t:message for="idButt" id="msgInformationAndErrorsR" errorClass="error" infoClass="informacion"/>
      </a4j:outputPanel>
    </h:panelGroup>
    <a4j:commandButton value="Buscar" action="#{buscadorVademecumBean.consultarMedicamentos}"
                       reRender="fieldSetBuscadorMedicamentos,fieldSetMedicamentos" styleClass="btn btn btn-success"
                       id="idButt"/>
  </h:panelGrid>
</s:fieldset>
<s:fieldset legend="Resultados Consulta" id="fieldSetMedicamentos" styleClass="fieldset_dataTable">
  <h:panelGrid columns="1" id="panelGridNoMedicamentos" rendered="#{empty buscadorVademecumBean.lstMedicamentos}">
    <h:outputText value="#{msg.msg_sin_consultar}"/>
  </h:panelGrid>
  <h:panelGrid columns="1" border="0" cellpadding="0" rendered="#{not empty buscadorVademecumBean.lstMedicamentos}"
               cellspacing="0" width="100%" id="tableContentTabsBucar" styleClass="tabContainer">
    <rich:spacer height="30"/>
    <rich:dataTable binding="#{buscadorVademecumBean.dtMedicamentos}"
                    value="#{buscadorVademecumBean.lstMedicamentos}" rows="10" var="item" rowKeyVar="row"
                    styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                    id="dtMedicamentosBuscador">
      <f:facet name="header">
        <rich:columnGroup>
          <rich:column>
            <h:outputText styleClass="headerText" value="Principio Activo"/>
          </rich:column>
 
          
            <rich:column>
            <h:outputText styleClass="headerText" value="Concentración"/>
          </rich:column>
          
          
            <rich:column>
            <h:outputText styleClass="headerText" value="Unidad de Medida"/>
          </rich:column>
          
            <rich:column>
            <h:outputText styleClass="headerText" value="Via de Administracion"/>
          </rich:column>
          
             <rich:column>
            <h:outputText styleClass="headerText" value="Nombre Comercial"/>
          </rich:column>
          
                       <rich:column>
            <h:outputText styleClass="headerText" value="Profamilia"/>
          </rich:column>
          
          <rich:column>
            <h:outputText styleClass="headerText" value="Seleccionar"/>
          </rich:column>
        </rich:columnGroup>
      </f:facet>
    
      <rich:column>
        <h:outputText value="#{item.hvpcprincactiv}" id="nombre"/>
      </rich:column>
      
         <rich:column>
        <h:outputText value="#{item.hvpcconcentrac}" id="concentracion"/>
      </rich:column>
      
         <rich:column>
        <h:outputText value="#{item.hvpcunidmedi}" id="unidadMedida"/>
      </rich:column>
         <rich:column>
        <h:outputText value="#{item.hvpcformafarma}" id="formafarma"/>
      </rich:column>
         <rich:column>
        <h:outputText value="#{item.hvpccomercial}" id="presentacion"/>
      </rich:column>
      
           
     <rich:column>
        <h:outputText value="#{item.hvpcmedicprof}" id="Profamilia"/>
      </rich:column>
      
      
      
      <rich:column>
        <a4j:commandLink id="aceptarMedicamentos" reRender="fieldVademecumSeleccionada"
                         action="#{buscadorVademecumBean.agregarMedicamento}">
          <t:graphicImage alt="" border="0" url="/comun/imagenes/adicionar.gif"/>
        </a4j:commandLink>
      </rich:column>
    </rich:dataTable>
    <rich:datascroller for="dtMedicamentosBuscador" renderIfSinglePage="true" reRender="dtMedicamentosBuscador"/>
    <rich:spacer height="30"/>
    <t:dataScroller id="scroll_proceso3" for="dtMedicamentosBuscador" immediate="true" rowsCountVar="rowsCount"
                    displayedRowsCountVar="displayedRowsCountVar" firstRowIndexVar="firstRowIndex"
                    lastRowIndexVar="lastRowIndex" pageCountVar="pageCount" pageIndexVar="pageIndex">
      <h:outputFormat value="Registros : Total {0}, mostrados {1} del {2} al {3}  Pagina {4} / {5}"
                      styleClass="standard">
        <f:param value="#{rowsCount}"/>
        <f:param value="#{displayedRowsCountVar}"/>
        <f:param value="#{firstRowIndex}"/>
        <f:param value="#{lastRowIndex}"/>
        <f:param value="#{pageIndex}"/>
        <f:param value="#{pageCount}"/>
      </h:outputFormat>
    </t:dataScroller>
  </h:panelGrid>
</s:fieldset>
<s:fieldset legend="Medicamento Seleccionado" id="fieldVademecumSeleccionada" styleClass="fieldset">
  <h:outputText value="#{buscadorVademecumBean.medicamentoSelect.hvpcprincactiv}"
                escape="false"/>
</s:fieldset>