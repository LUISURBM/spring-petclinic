<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="consultarUsuarioResumenForm">
  <a4j:region id="bodyRegionConsultaUsuarioResumen">
    <a4j:status id="statusButton" for="bodyRegionConsultaUsuarioResumen">
      <f:facet name="start">
        <t:div id="chargindUsuarioResumen" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    
      <h:panelGrid columns="1" id="tableConsultarUsuarioResumen" border="0" cellpadding="0"
                 cellspacing="0" width="100%" styleClass="td_ubicador">
        <h:outputText value="Resumen Historia Clinica "
                      id="infoUbication"/>
    </h:panelGrid>
    
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContenUsuarioResumen"
                 styleClass="tabContainer">
      <s:fieldset legend="Criterios de Busqueda" id="fieldSetInfoUsuarioResumen" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionUsuarioResumen"
                     rowClasses="labelText,labelTextInfo">
        <h:outputText value="Tipo Identificación" />
        <h:outputText value=" Numero Identificación" />
         <h:panelGroup>
          <h:selectOneMenu id="tipoIdentificacion" 
                           value="#{consultarUsuarioResumenBean.usuario.husetipoiden}">
            <f:selectItems value="#{consultarUsuarioResumenBean.listTipoIdentificacion}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="tipoIdentificacion" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGroup>
          <h:inputText id="itNumeroDocumento" 
                     value="#{consultarUsuarioResumenBean.usuario.husanumeiden}">
          </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="itNumeroDocumento" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGroup>

        <h:outputText value="Primer Nombre" />
        <h:outputText value=" Segundo Nombre" />
        
           <h:panelGroup>
          <h:inputText id="itPrimerNombre" styleClass="textmayuscula"
                          value="#{consultarUsuarioResumenBean.usuario.huscprimernomb}">
                          <f:converter converterId="cadena.stringUpperCaseConverter"/>
        </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="itNumeroDocumento" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGroup>
   <h:panelGroup>
          <h:inputText id="itSegundoNombre" styleClass="textmayuscula"
                       value="#{consultarUsuarioResumenBean.usuario.huscsegundnomb}">
                          <f:converter converterId="cadena.stringUpperCaseConverter"/>
            </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="itNumeroDocumento" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:outputText value="Primer Apellido" />
        <h:outputText value=" Segundo Apellido" />
           <h:panelGroup>
          <h:inputText id="itPrimerApellido" styleClass="textmayuscula"
                       value="#{consultarUsuarioResumenBean.usuario.huscprimerapel}">
                          <f:converter converterId="cadena.stringUpperCaseConverter"/>
            </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="itNumeroDocumento" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGroup>


   <h:panelGroup>
          <h:inputText id="itSegundoApellido" styleClass="textmayuscula"
                       value="#{consultarUsuarioResumenBean.usuario.huscsegundapel}">
                          <f:converter converterId="cadena.stringUpperCaseConverter"/>
            </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="itNumeroDocumento" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGroup>
  </h:panelGrid>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelBotonUsuarioResumen"
               columnClasses="columnaBotonesCentrados">
    <h:panelGroup>
      <a4j:outputPanel id="consultarUsuarioResumen" ajaxRendered="true">
        <t:htmlTag value="br"/>
        <t:message for="idButtonUsuarioResumen" id="msgInformationUsuarioResumen"
                   errorClass="error" infoClass="informacion"/>
      </a4j:outputPanel>
    </h:panelGroup>
    <t:htmlTag value="br"/>
    <a4j:commandButton value="Buscar" action="#{consultarUsuarioResumenBean.consultarUsuario}"
                       reRender="fieldSetConsultarResumen"
                       styleClass="boton_fieldset" id= "idButtonUsuarioResumen" />
        </h:panelGrid>
      </s:fieldset>
      
      <s:fieldset legend="Resultados Consulta" id="fieldSetConsultarResumen"
            styleClass="fieldset_dataTable">
            
        <h:panelGrid columns="1" id="panelGridConsultarResumen"
                rendered="#{empty consultarUsuarioResumenBean.lstUsuarios}">
                    <h:outputText value="#{msg.msg_sin_consultar}"/>
                        </h:panelGrid>    
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="tableContentTabsConsultarResumen"
               rendered="#{not empty consultarUsuarioResumenBean.lstUsuarios}" 
               styleClass="tabContainer">
    <t:buffer into="#{table}">
      <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                   binding="#{consultarUsuarioResumenBean.dtConsultaUsuario}"
                   value="#{consultarUsuarioResumenBean.lstUsuarios}" rows="10"
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
           <h:outputText value="#{item.huscprimernomb} #{item.huscprimerapel}"/>
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
                                  action="#{consultarUsuarioResumenBean.consultarResumen}">
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
            <t:graphicImage  alt="" url="/comun/imagenes/anterior.gif" border="0"/>
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
    </h:panelGrid>
    
       <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMensajesResumenHistoria" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInfResumenHistoria" showSummary="true"
                      errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>

  </a4j:region>
</a4j:form>