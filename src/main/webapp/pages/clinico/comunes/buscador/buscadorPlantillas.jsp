<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<s:fieldset legend="Criterios de Busqueda Plantillas " id="fieldSetBuscador"
            styleClass="fieldset">
  <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridPlantillas"
               rowClasses="labelText,labelTextInfo">
    <h:outputText value="Nombre Plantilla "/>
    <h:outputText value="Descripción"/>
   
    
    <h:inputText value="#{buscadorPlantillaBean.plantilla.hplcnombrplant}" style="width:200px"
                 onkeydown="return blockEnter(event);"/>
                 
    <h:inputText value="#{buscadorPlantillaBean.plantilla.hplcdescripcio}"
                 onkeydown="return blockEnter(event);"/>
 </h:panelGrid>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelBotonConsulta"
               columnClasses="columnaBotonesCentrados">
    <h:panelGroup>
      <a4j:outputPanel id="ajaxRegionMessagesRegiones" ajaxRendered="true">
        <t:htmlTag value="br"/>
        <t:message for="idButtonContrato" id="msgInformationAndErrorsR"
                   errorClass="error" infoClass="informacion"/>
      </a4j:outputPanel>
    </h:panelGroup>
    <t:htmlTag value="br"/>
    <a4j:commandButton value="Buscar" action="#{buscadorPlantillaBean.consultarPlantillas}"
                       reRender="fieldPlantillas"
                       styleClass="btn btn btn-success" id="idButtonContrato"/>
  </h:panelGrid>
</s:fieldset>

  <s:fieldset legend="Lista Plantillas" id="fieldPlantillas" styleClass="fieldset">
        <h:panelGrid columns="1" id="panelGridNoPlantillasSeleccionados" 
             rendered="#{empty buscadorPlantillaBean.lstPlantillas}">
            <h:outputText value="#{msg.msg_sin_consultar}"/>
          </h:panelGrid>
      
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelPlantillasTable" styleClass="tabContainer" 
              rendered="#{not empty buscadorPlantillaBean.lstPlantillas}">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="0" cellpadding="0" 
                               binding="#{buscadorPlantillaBean.dtPlantilla}"  cellspacing="0" 
                               value="#{buscadorPlantillaBean.lstPlantillas}" rows="10"
                               styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" 
                               footerClass="paginacion" id="dtPlantilla">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Nombre Plantilla"/>
                      </f:facet>
                      <h:outputText value="#{item.hplcnombrplant}"/>
                    </h:column>
                    
                              
                    
                    <h:column>
                    <f:facet name="header">
                      <h:outputText value="Descripción Plantillas"/>
                    </f:facet>
                    <t:div style="overflow:auto;width:500px;height:50px;">
                      <h:panelGrid>
                        <h:outputText value="#{item.hplcdescripcio}"/>
                      </h:panelGrid>
                    </t:div>
                  </h:column>
                  
                   <h:column>
                  <f:facet name="header">
                    <h:outputText value="Seleccione"/>
                  </f:facet>
                  <a4j:commandLink id="aceptarPlantilla" action="#{buscadorPlantillaBean.selectPlantilla}" reRender="fieldSetResDiagnostico">
                    <t:graphicImage alt=""  border="0" url="/comun/imagenes/adicionar.gif"/>
                  </a4j:commandLink>
                </h:column>
                  
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_Plantillas" for="dtPlantilla" fastStep="10" 
                          pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                          immediate="true" paginatorMaxPages="9" paginatorTableClass="paginator" 
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

<s:fieldset legend="Diagnostico Seleccionado" id="fieldSetResDiagnostico"
            styleClass="fieldset_dataTable">
  <h:outputText value="#{buscadorPlantillaBean.plantillaSelect.hplcnombrplant}"/>
</s:fieldset>
