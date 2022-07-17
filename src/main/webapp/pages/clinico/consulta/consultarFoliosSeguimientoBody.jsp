<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="consultarSeguimientoForm">
  <a4j:region id="bodyRegionConsultarSeguimiento">
    <a4j:status id="statusButton" for="bodyRegionConsultarSeguimiento">
      <f:facet name="start">
        <t:div id="chargindConsultarSeguimiento" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableConsultarSeguimiento" border="0" cellpadding="0"
                 cellspacing="0" width="100%" styleClass="td_ubicador">
      <h:outputText value="Consultar Folios Seguimiento Usuario " id="infoUbicationSeguimiento"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="tableContentConsultarFoliosSeguimiento"
                 styleClass="tabContainer">
      <s:fieldset legend="Datos Usuario" id="fieldSetInfoConsultarUsuarioSeguimiento"
                  styleClass="fieldset">
        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelRegionInfoConsultaSeguimiento"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Tipo Identificación"/>
          <h:outputText value=" Numero Identificación"/>
          <h:outputText value="Número Usuario"/>
          <h:panelGroup>
            <h:selectOneMenu id="tipoIdeSeguimiento" required="true" disabled="true"
                             value="#{consultarFoliosSeguimientoBean.usuario.husetipoiden}">
              <f:selectItems value="#{consultarFoliosSeguimientoBean.listTipoIdentificacion}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="tipoIdeSeguimiento" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="#{consultarFoliosSeguimientoBean.usuario.husanumeiden}"/>
          <h:outputText id="itNumeroUsuarioSeguimiento"
                        value="#{consultarFoliosSeguimientoBean.usuario.huslnumero}"/>
          <t:htmlTag value="br"/>
        </h:panelGrid>
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelDatosNombreSeguimiento"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Primer Nombre"/>
          <h:outputText value="Segundo Nombre"/>
          <h:outputText value="Primer Apellido"/>
          <h:outputText value="Segundo Apellido"/>
          <h:panelGroup>
            <h:outputText value="#{consultarFoliosSeguimientoBean.usuario.huscprimernomb}"/>
          </h:panelGroup>
          <h:outputText value="#{consultarFoliosSeguimientoBean.usuario.huscsegundnomb}"/>
          <h:panelGroup>
            <h:outputText id="primerApellido"
                          value="#{consultarFoliosSeguimientoBean.usuario.huscprimerapel}"/>
          </h:panelGroup>
          <h:outputText value="#{consultarFoliosSeguimientoBean.usuario.huscsegundapel}"/>
          <h:outputText value="Fecha Nacimiento"/>
          <h:outputText value="Edad"/>
          <h:outputText value="Sexo"/>
          <h:outputText value="Estado Civil"/>
          <h:panelGroup>
            <h:outputText value="#{consultarFoliosSeguimientoBean.usuario.husdfechanacim}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="#{consultarFoliosSeguimientoBean.edad}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneMenu id="radioSexoSeguimiento" disabled="true"
                             value="#{consultarFoliosSeguimientoBean.usuario.husesexo}">
              <f:selectItems value="#{consultarFoliosSeguimientoBean.listSexos}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="Seguimiento" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneMenu id="radioEstadoCivilSeguimiento" disabled="true"
                             value="#{consultarFoliosSeguimientoBean.usuario.huseestadcivil}">
              <f:selectItems value="#{consultarFoliosSeguimientoBean.listEstadoCivil}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioEstadoCivilSeguimiento" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelBotonConsultarUsuarioSeguimiento"
                     columnClasses="columnaBotonesCentrados">
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionCOnsultarHistoriaSeguimiento"
                             ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:message for="idButtonBuscarHistoriaSeguimiento"
                         id="msgInformationConsultarHistoriaSeguimiento" errorClass="error"
                         infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <t:htmlTag value="br"/>
          <a4j:commandButton value="Buscar Consultas"
                             action="#{consultarFoliosSeguimientoBean.consultarFoliosUsuario}"
                             reRender="fieldSetConsultarFolioSeguimiento"
                             styleClass="boton_fieldset"
                             id="idButtonBuscarHistoriaSeguimiento"/>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Resultados Consulta" id="fieldSetConsultarFolioSeguimiento"
                  styleClass="fieldset_dataTable">
        <h:panelGrid columns="1" id="panelGridConsultarFoliosSeguimiento"
                     rendered="#{empty consultarFoliosSeguimientoBean.lstFolios}">
          <h:outputText value="#{msg.msg_sin_consultar}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="tableContentTabsBucar"
                     rendered="#{not empty consultarFoliosSeguimientoBean.lstFolios}"
                     styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         binding="#{consultarFoliosSeguimientoBean.dtFolios}"
                         value="#{consultarFoliosSeguimientoBean.lstFolios}" rows="10"
                         styleClass="standard_table"
                         rowClasses="standardTable_Row1,standardTable_Row2"
                         footerClass="paginacion" id="dtBucarFoliosSeguimiento">
                         
               <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha"/>
                </f:facet>
                <h:outputText value="#{item.hcodfecregistr}"/>
              </h:column>           
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Numero Usuario"/>
                </f:facet>
                <h:outputText value="#{item.hcolusuario.huslnumero}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Servicio"/>
                </f:facet>
                <h:outputText value="#{item.hcocservicio.csvcnombre}"/>
              </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Registrar Seguimiento Consulta"/>
                  </f:facet>
                  <h:commandLink id="atenderSeguimiento"
                                 action="#{consultarFoliosSeguimientoBean.RegistrarEvolucion}">
                    <t:graphicImage alt=""  border="0"
                                    url="/comun/imagenes/editar.gif"/>
                  </h:commandLink>
                </h:column>
        </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_1" for="dtBucarFoliosSeguimiento" fastStep="10"
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
    </h:panelGrid>
      <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMsgFolioSeguimiento" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationMsgFolioSeguimiento" showSummary="true"
                      errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>