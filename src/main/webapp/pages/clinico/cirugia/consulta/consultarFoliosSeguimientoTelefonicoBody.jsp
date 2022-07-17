<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="consultarHistoriaForm">
  <a4j:region id="bodyRegionConsultarFolio">
    <a4j:status id="statusButton" for="bodyRegionConsultarFolio">
      <f:facet name="start">
        <t:div id="chargindConsultarFolio" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableConsultarFolio" border="0" cellpadding="0"
                 cellspacing="0" width="100%" styleClass="td_ubicador">
      <h:outputText value="Consultar Cirugias Usuario " id="infoUbication"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="tableContentConsultarFolios"
                 styleClass="tabContainer">
      <s:fieldset legend="Datos Usuario" id="fieldSetInfoConsultarUsuario"
                  styleClass="fieldset">
        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelRegionInfoConsulta"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Tipo Identificación"/>
          <h:outputText value=" Numero Identificación"/>
          <h:outputText value="Número Usuario"/>
          <h:panelGroup>
            <h:selectOneMenu id="tipoIde" required="true" disabled="true"
                             value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.husetipoiden}">
              <f:selectItems value="#{consultarFoliosSeguimientoTelefonicoBean.listTipoIdentificacion}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="tipoIde" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.husanumeiden}"/>
          <h:outputText id="itNumeroUsuario"
                        value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.huslnumero}"/>
          <t:htmlTag value="br"/>
        </h:panelGrid>
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelDatosNombre"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Primer Nombre"/>
          <h:outputText value="Segundo Nombre"/>
          <h:outputText value="Primer Apellido"/>
          <h:outputText value="Segundo Apellido"/>
          <h:panelGroup>
            <h:outputText value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.huscprimernomb}"/>
          </h:panelGroup>
          <h:outputText value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.huscsegundnomb}"/>
          <h:panelGroup>
            <h:outputText id="primerApellido"
                          value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.huscprimerapel}"/>
          </h:panelGroup>
          <h:outputText value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.huscsegundapel}"/>
          <h:outputText value="Fecha Nacimiento"/>
          <h:outputText value="Edad"/>
          <h:outputText value="Sexo"/>
          <h:outputText value="Estado Civil"/>
          <h:panelGroup>
            <h:outputText value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.husdfechanacim}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="#{consultarFoliosSeguimientoTelefonicoBean.edad}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneMenu id="radioSexo" disabled="true"
                             value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.husesexo}">
              <f:selectItems value="#{consultarFoliosSeguimientoTelefonicoBean.listSexos}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioSexo" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneMenu id="radioEstadoCivil" disabled="true"
                             value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.huseestadcivil}">
              <f:selectItems value="#{consultarFoliosSeguimientoTelefonicoBean.listEstadoCivil}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioEstadoCivil" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          
       <h:outputText value="Telefono Contacto" />
       <h:outputText value="Telefono Celular" />
       <h:outputText value="" />
       <h:outputText value="" />
       
       
        <h:outputText value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.husctelefono}" />
       <h:outputText value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.husccelular}" />
        <h:outputText value="" />
          
          
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelBotonConsultarUsuario"
                     columnClasses="columnaBotonesCentrados">
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionCOnsultarHistoria"
                             ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:message for="idButtonBuscarHistoria"
                         id="msgInformationConsultarHistoria" errorClass="error"
                         infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <t:htmlTag value="br"/>
          <a4j:commandButton value="Buscar Cirugias"
                             action="#{consultarFoliosSeguimientoTelefonicoBean.consultarFoliosUsuario}"
                             reRender="fieldSetConsultarFolio"
                             styleClass="btn btn btn-success"
                             id="idButtonBuscarHistoria"/>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Resultados Consulta" id="fieldSetConsultarFolio"
                  styleClass="fieldset_dataTable">
        <h:panelGrid columns="1" id="panelGridConsultarFolios"
                     rendered="#{empty consultarFoliosSeguimientoTelefonicoBean.lstFolios}">
          <h:outputText value="#{msg.msg_sin_consultar}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="tableContentTabsBucar"
                     rendered="#{not empty consultarFoliosSeguimientoTelefonicoBean.lstFolios}"
                     styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         binding="#{consultarFoliosSeguimientoTelefonicoBean.dtFolios}"
                         value="#{consultarFoliosSeguimientoTelefonicoBean.lstFolios}" rows="10"
                         styleClass="standard_table"
                         rowClasses="standardTable_Row1,standardTable_Row2"
                         footerClass="paginacion" id="dtBucarFolios">
                         
               <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha"/>
                </f:facet>
                <h:outputText value="#{item.hcpdfecregistr}"/>
              </h:column>           
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Numero Usuario"/>
                </f:facet>
                <h:outputText value="#{item.hcplusuario.huslnumero}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="VINISO"/>
                </f:facet>
                <h:commandLink id="atender"
                               action="#{consultarFoliosSeguimientoTelefonicoBean.RegistrarSeguimientoTelefonico}">
                  <t:graphicImage alt=""  border="0"
                                  url="/comun/imagenes/telefono.jpg"/>
                  </h:commandLink>
                </h:column>
        </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_1" for="dtBucarFolios" fastStep="10"
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
        <a4j:outputPanel id="ajaxRegionMsgFolioNota" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationMsgFolioNota" showSummary="true"
                      errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>