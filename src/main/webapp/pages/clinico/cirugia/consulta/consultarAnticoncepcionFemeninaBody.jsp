<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="consultarUsuarioForm">
  <a4j:region id="bodyRegionConsultaUsuario">
    <a4j:status id="statusButton" for="bodyRegionConsultaUsuario">
      <f:facet name="start">
        <t:div id="chargindUsuario" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableInfoUbication" border="0" cellpadding="0" cellspacing="0" width="100%"
                 columnClasses="td_ubicador">
      <h:outputText value="HISTORIAS CLINICAS >> Cirugias >> Consulta Usuaria" id="infoUbication"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContenUsuario"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneDescripcionQuirurgica" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabAnticoncepcionFemenina" label="Datos Usuaria">
          <s:fieldset legend="Criterios de Busqueda" id="fieldSetInfoUsuario" styleClass="fieldset">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionUsuario"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value=" Numero Identificación"/>
              <h:outputText value="Tipo Identificación"/>
              <h:panelGroup>
                <h:inputText id="itNumeroDocumento" 
                             value="#{consultarAnticoncepcionFemeninaBean.usuario.husanumeiden}">
                               
                </h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itNumeroDocumento" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneMenu id="tipoIdentificacion"
                                 value="#{consultarAnticoncepcionFemeninaBean.usuario.husetipoiden}">
                  <f:selectItems value="#{consultarAnticoncepcionFemeninaBean.listTipoIdentificacion}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="tipoIdentificacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Primer Nombre"/>
              <h:outputText value=" Segundo Nombre"/>
              <h:panelGroup>
                <h:inputText id="itPrimerNombre" styleClass="textmayuscula" 
                             value="#{consultarAnticoncepcionFemeninaBean.usuario.huscprimernomb}">
                         <f:converter converterId="cadena.stringUpperCaseConverter"/>
                </h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itNumeroDocumento" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itSegundoNombre" styleClass="textmayuscula" 
                value="#{consultarAnticoncepcionFemeninaBean.usuario.huscsegundnomb}">
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
                             value="#{consultarAnticoncepcionFemeninaBean.usuario.huscprimerapel}">
                                <f:converter converterId="cadena.stringUpperCaseConverter"/>
                </h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itNumeroDocumento" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itSegundoApellido" styleClass="textmayuscula" 
                             value="#{consultarAnticoncepcionFemeninaBean.usuario.huscsegundapel}">
                                <f:converter converterId="cadena.stringUpperCaseConverter"/>
                        </h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itNumeroDocumento" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonUsuario"
                         columnClasses="columnaBotonesCentrados">
              <h:panelGroup>
                <a4j:outputPanel id="consultarUsuario" ajaxRendered="true">
                  <t:htmlTag value="br"/>
                  <t:message for="idButtonUsuario" id="msgInformationUsuario" errorClass="error"
                             infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <t:htmlTag value="br"/>
              <a4j:commandButton value="Buscar"
                                 action="#{consultarAnticoncepcionFemeninaBean.buscarPacientesIngresados}"
                                 reRender="fieldSetConsultar" styleClass="btn btn btn-success" id="idButtonUsuario"/>
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Resultados Consulta" id="fieldSetConsultar" styleClass="fieldset_dataTable">
            <h:panelGrid columns="1" id="panelGridConsultar"
                         rendered="#{empty consultarAnticoncepcionFemeninaBean.lstUsuariosIngresados}">
              <h:outputText value="#{msg.msg_sin_consultar}"/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="tableContentTabsConsultar"
                         rendered="#{not empty consultarAnticoncepcionFemeninaBean.lstUsuariosIngresados}"
                         styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" cellspacing="2"
                             binding="#{consultarAnticoncepcionFemeninaBean.dtConsultaUsuario}"
                             value="#{consultarAnticoncepcionFemeninaBean.lstUsuariosIngresados}" rows="10"
                             styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                             footerClass="paginacion" id="dtBucarUsuarios">
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Ingreso"/>
                    </f:facet>
                    <h:outputLabel value="#{item.hiedfecregistr}">
                      <f:convertDateTime pattern="dd/MM/yyyy" type="date"/>
                    </h:outputLabel>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Documento"/>
                    </f:facet>
                    <h:outputText value="#{item.hielusuario.husetipoiden} #{item.hielusuario.husanumeiden}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Nombre"/>
                    </f:facet>
                    <h:outputText value="#{item.hielusuario.huscprimernomb} #{item.hielusuario.huscsegundnomb} #{item.hielusuario.huscprimerapel} #{item.hielusuario.huscsegundapel}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="# Usuario"/>
                    </f:facet>
                    <h:outputText value="#{item.hielusuario.huslnumero}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Seleccionar"/>
                    </f:facet>
                    <h:commandLink id="consultarAnticoncepcionFemenina"
                                   action="#{consultarAnticoncepcionFemeninaBean.registrarAnticoncepcionFemenina}">
                      <t:graphicImage border="0" url="/comun/imagenes/editar.gif"/>
                    </h:commandLink>
                  </h:column>
                </h:dataTable>
              </t:buffer>
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_1" for="dtBucarUsuarios" fastStep="10" pageCountVar="pageCount"
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
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
    <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMensajesHistoria" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInfHistoria" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>