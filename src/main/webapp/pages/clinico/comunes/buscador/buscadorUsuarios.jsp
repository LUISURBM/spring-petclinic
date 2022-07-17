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
          <h:outputText value="Tipo Identificación"/>
          <h:outputText value=" Numero Identificación"/>
          <h:panelGroup>
            <h:selectOneMenu id="tipoIdentificacion"
                             value="#{buscadorUsuariosBean.usuario.husetipoiden}">
              <f:selectItems value="#{buscadorUsuariosBean.listTipoIdentificacion}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="tipoIdentificacion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:inputText id="itNumeroDocumento" 
                         value="#{buscadorUsuariosBean.usuario.husanumeiden}">      
            </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itNumeroDocumento" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="Primer Nombre"/>
          <h:outputText value=" Segundo Nombre"/>
          <h:panelGroup>
            <h:inputText id="itPrimerNombre" styleClass="textmayuscula"
                         value="#{buscadorUsuariosBean.usuario.huscprimernomb}">
                            <f:converter converterId="cadena.stringUpperCaseConverter"/>
                </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itNumeroDocumento" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:inputText id="itSegundoNombre" styleClass="textmayuscula"
                         value="#{buscadorUsuariosBean.usuario.huscsegundnomb}">
                            <f:converter converterId="cadena.stringUpperCaseConverter"/>
                </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itNumeroDocumento" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="Primer Apellido"/>
          <h:outputText value=" Segundo Apellido"/>
          <h:panelGroup>
            <h:inputText id="itPrimerApellido" styleClass="textmayuscula"
                         value="#{buscadorUsuariosBean.usuario.huscprimerapel}">
                            <f:converter converterId="cadena.stringUpperCaseConverter"/>
                </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itNumeroDocumento" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:inputText id="itSegundoApellido"
                         value="#{buscadorUsuariosBean.usuario.huscsegundapel}">
                         
            </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itNumeroDocumento" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelBotonUsuario"
                     columnClasses="columnaBotonesCentrados">
          <h:panelGroup>
            <a4j:outputPanel id="consultarUsuario" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:message for="idButtonUsuario" id="msgInformationUsuario"
                         errorClass="error" infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <t:htmlTag value="br"/>
          <a4j:commandButton value="Buscar"
                             action="#{buscadorUsuariosBean.consultarUsuario}"
                             reRender="fieldSetConsultar"
                             styleClass="btn btn btn-success" id="idButtonUsuario"/>
        </h:panelGrid>
      </s:fieldset>


 <s:fieldset legend="Resultados Consulta" id="fieldSetConsultar"
                  styleClass="fieldset_dataTable">
        <h:panelGrid columns="1" id="panelGridConsultar"
                     rendered="#{empty buscadorUsuariosBean.lstUsuarios}">
          <h:outputText value="#{msg.msg_sin_consultar}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="tableContentTabsConsultar"
                     rendered="#{not empty buscadorUsuariosBean.lstUsuarios}"
                     styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         binding="#{buscadorUsuariosBean.dtConsultaUsuario}"
                         value="#{buscadorUsuariosBean.lstUsuarios}" rows="10"
                         styleClass="standard_table"
                         rowClasses="standardTable_Row1,standardTable_Row2"
                         footerClass="paginacion" id="dtBucarUsuarios">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Numero Documento"/>
                </f:facet>
                <h:outputText value="#{item.husetipoiden} #{item.husanumeiden}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Nombre"/>
                </f:facet>
                <h:outputText value="#{item.huscprimernomb} #{item.huscsegundnomb} #{item.huscprimerapel} #{item.huscsegundapel}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha de Nacimiento"/>
                </f:facet>
                <h:outputText value="#{item.husdfechanacim}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Numero de Usuario"/>
                </f:facet>
                <h:outputText value="#{item.huslnumero}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Seleccione"/>
                </f:facet>
                <h:commandLink id="aceptar"
                               action="#{buscadorUsuariosBean.consultar}">
                  <t:graphicImage alt=""  border="0"
                                  url="/comun/imagenes/adicionar.gif"/>
                </h:commandLink>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_1" for="dtBucarUsuarios" fastStep="10"
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
<s:fieldset legend="Usuario Seleccionado" id="fieldUsuarioSeleccionado" styleClass="fieldset" >
    
        
   <h:outputText value="#{buscadorUsuariosBean.usuarioSelect.huscprimernomb} #{buscadorUsuariosBean.usuarioSelect.huscsegundnomb}  #{buscadorUsuariosBean.usuarioSelect.huscprimerapel}  #{buscadorUsuariosBean.usuarioSelect.huscsegundapel}" escape="false"/>
</s:fieldset>