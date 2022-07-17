<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="consultamodificarModiProgaForm">
  <a4j:region id="bodyRegionConsultaModificacionProgramacion">
    <a4j:status id="statusButton" for="bodyRegionConsultaModificacionProgramacion">
      <f:facet name="start">
        <t:div id="chargindConsultarModificacionProgramacion" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableConsultarmodificarModiProga" border="0" cellpadding="0" cellspacing="0" width="100%"
                 styleClass="td_ubicador">
                 
      <h:outputText value="Datos Usuario - Reprogramar Cirugia Usuario  " id="infoUbication"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContenmodificarModiProga"
                 styleClass="tabContainer">
      <s:fieldset legend="Criterios de Busqueda" id="fieldSetInfoUsuarioModificarProgramar" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionConsultarModificaPrograma"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Tipo Identificación"/>
          <h:outputText value=" Numero Identificación"/>
          <h:panelGroup>
            <h:selectOneMenu id="tipoIdentificacionModiProga" value="#{reprogramarCirugiasProgramarBean.usuario.husetipoiden}">
              <f:selectItems value="#{reprogramarCirugiasProgramarBean.listTipoIdentificacion}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="tipoIdentificacionModiProga" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:inputText id="itNumeroDocumentoModiProga"  
                         value="#{reprogramarCirugiasProgramarBean.usuario.husanumeiden}">
             </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itNumeroDocumentoModiProga" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="Primer Nombre"/>
          <h:outputText value=" Segundo Nombre"/>
          <h:panelGroup>
            <h:inputText id="itPrimerNombreModiProga" styleClass="textmayuscula" 
                         value="#{reprogramarCirugiasProgramarBean.usuario.huscprimernomb}">
                            <f:converter converterId="cadena.stringUpperCaseConverter"/>
                </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itNumeroDocumentoModiProga" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:inputText id="itSegundoNombreModiProga" styleClass="textmayuscula" 
                         value="#{reprogramarCirugiasProgramarBean.usuario.huscsegundnomb}">
                            <f:converter converterId="cadena.stringUpperCaseConverter"/>
                </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itNumeroDocumentoModiProga" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="Primer Apellido"/>
          <h:outputText value=" Segundo Apellido"/>
          <h:panelGroup>
            <h:inputText id="itPrimerApellidoModiProga" styleClass="textmayuscula" 
                         value="#{reprogramarCirugiasProgramarBean.usuario.huscprimerapel}">
                            <f:converter converterId="cadena.stringUpperCaseConverter"/>
                        </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itNumeroDocumentoModiProga" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:inputText id="itSegundoApellidoProga" styleClass="textmayuscula" 
                         value="#{reprogramarCirugiasProgramarBean.usuario.huscsegundapel}">
                            <f:converter converterId="cadena.stringUpperCaseConverter"/>
                        </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itNumeroDocumentoModiProga" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonUsuarioModiProga"
                     columnClasses="columnaBotonesCentrados">
          <h:panelGroup>
            <a4j:outputPanel id="modificarModiProga" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:message for="idButtonUsuarioModiProga" id="msgModiProga" errorClass="error" infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <t:htmlTag value="br"/>
          <a4j:commandButton value="Buscar" action="#{reprogramarCirugiasProgramarBean.buscarUsuarioProgramacion}"
                             reRender="fieldSetConsultarModiProga,fieldSetModificar" styleClass="btn btn btn-success" 
                             id="idButtonUsuarioModiProga"/>
        </h:panelGrid>
      </s:fieldset>
    <s:fieldset legend="Resultados Consulta" id="fieldSetConsultarModiProga" styleClass="fieldset_dataTable" >
        <h:panelGrid columns="1" id="panelGridModiProga" rendered="#{empty reprogramarCirugiasProgramarBean.lstUsuarios}">
          <h:outputText value="#{msg.msg_sin_consultar}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
                        id="tableContentTabsModiProga"
                     rendered="#{not empty reprogramarCirugiasProgramarBean.lstUsuarios}" styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         binding="#{reprogramarCirugiasProgramarBean.dtConsultaUsuario}"
                         value="#{reprogramarCirugiasProgramarBean.lstUsuarios}" rows="10" styleClass="standard_table"
                         rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                         id="dtBucarModiProga">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Numero Documento"/>
                </f:facet>
                <h:outputText value="#{item.hcplusuario.husetipoiden} #{item.hcplusuario.husanumeiden}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Nombre"/>
                </f:facet>
                <h:outputText value="#{item.hcplusuario.huscprimernomb} #{item.hcplusuario.huscprimerapel}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha de Nacimiento"/>
                </f:facet>
                <h:outputText value="#{item.hcplusuario.husdfechanacim}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Numero de Usuario"/>
                </f:facet>
                <h:outputText value="#{item.hcplusuario.huslnumero}"/>
              </h:column>
               <h:column>
                <f:facet name="header">
                  <h:outputText value="Procedimiento(s)"/>
                </f:facet>
                <h:outputText value="#{item.nombreServicio}"/>
              </h:column>             
              
               <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha de Cirugía"/>
                </f:facet>
                <h:outputText value="#{item.hcpdfechacirug}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Seleccione"/>
                </f:facet>
                <h:commandLink id="aceptar" action="#{reprogramarCirugiasProgramarBean.consultar}">
                  <t:graphicImage border="0"  alt="" url="/comun/imagenes/adicionar.gif"/>
                </h:commandLink>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_1" for="dtBucarModiProga" fastStep="10" pageCountVar="pageCount"
                              pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                              paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                              paginatorActiveColumnStyle="font-weight:bold;">
                <f:facet name="first">
                  <t:graphicImage url="/comun/imagenes/primero.gif" border="0"  alt=""/>
                </f:facet>
                <f:facet name="last">
                  <t:graphicImage url="/comun/imagenes/ultimo.gif" border="0"  alt=""/>
                </f:facet>
                <f:facet name="previous">
                  <t:graphicImage url="/comun/imagenes/anterior.gif" border="0"  alt=""/>
                </f:facet>
                <f:facet name="next">
                  <t:graphicImage url="/comun/imagenes/siguiente.gif" border="0"  alt=""/>
                </f:facet>
                <f:facet name="fastforward">
                  <t:graphicImage url="/comun/imagenes/adelante.gif" border="0"  alt=""/>
                </f:facet>
                <f:facet name="fastrewind">
                  <t:graphicImage url="/comun/imagenes/atras.gif" border="0"  alt=""/>
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
        <a4j:outputPanel id="ajaxRegioModiProga" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInfHistoriaModiProga" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion" styleClass=""/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>