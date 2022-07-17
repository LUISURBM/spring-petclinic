<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
 <s:fieldset legend="Criterios de Busqueda" id="fieldSetInfoUsuario"
                  styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelRegionUsuario"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Cedula"/>
          <h:outputText value="Nombre"/>
          <h:panelGroup>
            <h:inputText id="itNumeroDocumento" 
                         value="#{buscadorProfesionalBean.profesional.cpfacedula}">      
            </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itNumeroDocumento" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:inputText id="itNombre" styleClass="textmayuscula"
                         value="#{buscadorProfesionalBean.profesional.cpfcnombre}">
                            <f:converter converterId="cadena.stringUpperCaseConverter"/>
                </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itNombre" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelBotonProfesional"
                     columnClasses="columnaBotonesCentrados">
          <h:panelGroup>
            <a4j:outputPanel id="consultarProfesional" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:message for="idButtonProfesional" id="msgInformationProfesional"
                         errorClass="error" infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <t:htmlTag value="br"/>
          <a4j:commandButton value="Buscar"
                             action="#{buscadorProfesionalBean.consultarProfesional}"
                             reRender="fieldSetConsultar"
                             styleClass="btn btn btn-success" id="idButtonUsuario"/>
        </h:panelGrid>
      </s:fieldset>


 <s:fieldset legend="Resultados Consulta" id="fieldSetConsultar"
                  styleClass="fieldset_dataTable">
        <h:panelGrid columns="1" id="panelGridConsultar"
                     rendered="#{empty buscadorProfesionalBean.lstProfesional}">
          <h:outputText value="#{msg.msg_sin_consultar}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="tableContentTabsConsultar"
                     rendered="#{not empty buscadorProfesionalBean.lstProfesional}"
                     styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         binding="#{buscadorProfesionalBean.dtConsultaProfesional}"
                         value="#{buscadorProfesionalBean.lstProfesional}" rows="10"
                         styleClass="standard_table"
                         rowClasses="standardTable_Row1,standardTable_Row2"
                         footerClass="paginacion" id="dtBucarProfesional">
               <h:column>
                <f:facet name="header">
                  <h:outputText value="Codigo"/>
                </f:facet>
                <h:outputText value="#{item.id.cpfncodigo}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Cedula"/>
                </f:facet>
                <h:outputText value="#{item.cpfacedula}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Nombre"/>
                </f:facet>
                <h:outputText value="#{item.cpfcnombre}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Seleccione"/>
                </f:facet>
                <a4j:commandLink id="aceptar"
                               action="#{buscadorProfesionalBean.consultar}"
                               immediate="true"
                               reRender="fieldProfesionalSeleccionado">
                  <t:graphicImage alt=""  border="0"
                                  url="/comun/imagenes/adicionar.gif"/>
                </a4j:commandLink>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_1" for="dtBucarProfesional" fastStep="10"
                              pageCountVar="pageCount" pageIndexVar="pageIndex"
                              styleClass="scroller" paginator="true"
                              immediate="true" paginatorMaxPages="9"
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
                  <t:graphicImage alt=""  url="/comun/imagenes/anterior.gif"
                                  border="0"/>
                </f:facet>
                <f:facet name="next">
                  <t:graphicImage alt=""  url="/comun/imagenes/siguiente.gif"
                                  border="0"/>
                </f:facet>
                <f:facet name="fastforward">
                  <t:graphicImage alt=""  url="/comun/imagenes/adelante.gif"
                                  border="0"/>
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
<s:fieldset legend="Profesional Seleccionado" id="fieldProfesionalSeleccionado" styleClass="fieldset" >
    
        
   <h:outputText value="#{buscadorProfesionalBean.profesionalSelect.cpfncodigo} #{buscadorProfesionalBean.profesionalSelect.cpfacedula}  #{buscadorProfesionalBean.profesionalSelect.cpfcnombre}" escape="false"/>
</s:fieldset>