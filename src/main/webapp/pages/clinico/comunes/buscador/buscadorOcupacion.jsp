 
<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>


 

<s:fieldset legend="Busqueda Ocupaciones " id="fieldSetBuscadorMedicamentos" styleClass="fieldset">
  <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridBuscarMedicamentos"
               rowClasses="labelText,labelTextInfo">
    <h:outputText value="Codigo"/>
    <h:outputText value="Nombre Ocupacion"/>
    <h:inputText value="#{buscadorOcupacionBean.ocupacion.cocncodigo}" onkeydown="return blockEnter(event);"/>
    <h:inputText value="#{buscadorOcupacionBean.ocupacion.coccdescri}" onkeydown="return blockEnter(event);"/>
    <h:outputText value=""/>
   
  
    
  </h:panelGrid>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonConsulta"
               columnClasses="columnaBotonesCentrados">
    <h:panelGroup>
      <a4j:outputPanel id="ajaxRegionMessagesRegiones" ajaxRendered="true">
        <t:htmlTag value="br"/>
        <t:message for="idButt" id="msgInformationAndErrorsR" errorClass="error" infoClass="informacion"/>
      </a4j:outputPanel>
    </h:panelGroup>
    <a4j:commandButton value="Buscar" action="#{buscadorOcupacionBean.consultarOcupacion}"
                       reRender="fieldSetBuscadorMedicamentos,fieldSetMedicamentos" styleClass="btn btn btn-success"
                       id="idButt"/>
  </h:panelGrid>
</s:fieldset>
<s:fieldset legend="Resultados Consulta" id="fieldSetMedicamentos" styleClass="fieldset_dataTable">
 
    <h:panelGrid columns="1" id="panelGridNoMedicamentos" rendered="#{empty buscadorOcupacionBean.lstOcupacion}">
    <h:outputText value="#{msg.msg_sin_consultar}"/>
  </h:panelGrid>
  <h:panelGrid columns="1" border="0" cellpadding="0" rendered="#{not empty buscadorOcupacionBean.lstOcupacion}" cellspacing="0" width="100%" id="tableContentTabsBucar"
               styleClass="tabContainer">
               
   
        
        <rich:spacer height="30" />
        <rich:dataTable binding="#{buscadorOcupacionBean.dtOcupacion}" value="#{buscadorOcupacionBean.lstOcupacion}" rows="10"
                 var="item" rowKeyVar="row" styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" id="dtServiciosBuscador" >
             <f:facet name="header">
                <rich:columnGroup>
                    <rich:column>
                        <h:outputText styleClass="headerText" value="Codigo" />
                    </rich:column>
                    <rich:column>
                        <h:outputText styleClass="headerText" value="Descripción" />
                    </rich:column>
                    <rich:column>
                        <h:outputText styleClass="headerText" value="Seleccionar" />
                    </rich:column>
                  
                </rich:columnGroup>
            </f:facet>
            <rich:column>
                <h:outputText value="#{item.cocncodigo}"/>
            </rich:column>
            <rich:column>
                <h:outputText value="#{item.coccdescri}" id="nombre" />
            </rich:column>
            <rich:column>
                 <h:commandLink id="aceptarEps" 
                           action="#{buscadorOcupacionBean.agregarOcupacion}">
            <t:graphicImage alt="" border="0" url="/comun/imagenes/adicionar.gif"/>
          </h:commandLink>
            </rich:column>
           

 

        </rich:dataTable>
       <rich:datascroller for="dtServiciosBuscador" renderIfSinglePage="true" reRender="dtServiciosBuscador"/>
        <rich:spacer height="30" />
     <t:dataScroller id="scroll_proceso3" for="dtServiciosBuscador" immediate="true" rowsCountVar="rowsCount" displayedRowsCountVar="displayedRowsCountVar"
                                                            firstRowIndexVar="firstRowIndex" lastRowIndexVar="lastRowIndex" pageCountVar="pageCount" pageIndexVar="pageIndex">
                                                <h:outputFormat value="Registros : Total {0}, mostrados {1} del {2} al {3}  Pagina {4} / {5}" styleClass="standard">
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
   
