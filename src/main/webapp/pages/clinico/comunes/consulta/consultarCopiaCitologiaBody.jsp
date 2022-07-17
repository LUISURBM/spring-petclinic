<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="consultarCopiaCitologiaForm">
    <a4j:region id="bodyRegionCopiaCitologia">
        <a4j:status id = "statusButton" for="bodyRegionCopiaCitologia">
            <f:facet name="start">
                <t:div id="chargindConsultarCopiaCitologia" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
  
        <h:panelGrid columns="1" id="tableConsultarCopiaCitologia" border="0" cellpadding="0" cellspacing="0"
                     width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
            <h:outputText value="Imprimir Copia Citologia " id="infoUbicationCopiaCitologia"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableCopiaCitologiaTabs"
                     styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxFoliosCopiaCitologia" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgFoliosCopiaCitologia" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabConCopiaCitologia" styleClass="tabbedPane"
                               activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                               selectedIndex="#{consultarCopiaCitologiaBean.selectedIndex}"
                               disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                               inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                <t:panelTab id="panelConFoliosCopiaCitologia" label="Consultar Citologias"
                            rendered="#{!consultarCopiaCitologiaBean.renderBuscador}">
                    <s:fieldset legend="Datos Paciente" id="fieldDatosCopiaCitologia" styleClass="fieldset">
                        <h:panelGrid columns="4" border="0" cellpadding="0" width="100%"
                                     id="tableContentListaConCopiaCitologia" rowClasses="labelText,labelTextInfo">
                            <h:outputText value="N�mero Usuario" styleClass="labelTextOblig"/>
                            <h:panelGroup>
                                <h:outputText value="Nombre" styleClass="labelTextOblig"
                                              rendered="#{consultarCopiaCitologiaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Tipo Documento" styleClass="labelTextOblig"
                                              rendered="#{consultarCopiaCitologiaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Numero Documento" styleClass="labelTextOblig"
                                              rendered="#{consultarCopiaCitologiaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                                         columnClasses="labelTextInfo">
                                <a4j:commandLink action="#{consultarCopiaCitologiaBean.mostrarBuscadorUsuarios}"
                                                 immediate="true" reRender="tableCopiaCitologiaTabs">
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                                </a4j:commandLink>
                                <h:inputText id="idtipoCopiaCitologia" maxlength="15" style="width:80px"
                                             immediate="true" value="#{consultarCopiaCitologiaBean.numeroUsuario}"
                                             valueChangeListener="#{consultarCopiaCitologiaBean.setNumeroUsuario}"
                                             binding="#{consultarCopiaCitologiaBean.itNumeroUsuario}"
                                             onkeydown="return blockEnter(event);">
                                    <a4j:support id="supportNumUsuarioCopiaCitologia" event="onchange"
                                                 ignoreDupResponses="true"
                                                 action="#{consultarCopiaCitologiaBean.changeUsuario}"
                                                 reRender="tableCopiaCitologiaTabs">
                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    </a4j:support>
                                </h:inputText>
                                <a4j:outputPanel ajaxRendered="true">
                                    <t:message for="idtipoCopiaCitologia" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                            </h:panelGrid>
                            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2"
                                         id="panelNombreUsuarioidtipoCopiaCitologia">
                                <h:outputText value=" #{consultarCopiaCitologiaBean.nombreUsuario}"
                                              styleClass="buscador"/>
                            </h:panelGrid>
                            <h:outputText value="#{consultarCopiaCitologiaBean.usuario.husetipoiden}"/>
                            <h:outputText value="#{consultarCopiaCitologiaBean.usuario.husanumeiden}"/>
                            <h:panelGroup>
                                <h:outputText value="Fecha de Nacimiento" styleClass="labelTextOblig"
                                              rendered="#{consultarCopiaCitologiaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="Edad" styleClass="labelTextOblig"
                                          rendered="#{consultarCopiaCitologiaBean.renderInformacionUsuario}"/>
                            <h:panelGroup>
                                <h:outputText value="Sexo"
                                              rendered="#{consultarCopiaCitologiaBean.renderInformacionUsuario}"
                                              styleClass="labelTextOblig"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Estado Civil" styleClass="labelTextOblig"
                                              rendered="#{consultarCopiaCitologiaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="#{consultarCopiaCitologiaBean.usuario.husdfechanacim}"/>
                            <h:outputText value="#{consultarCopiaCitologiaBean.usuario.edad}"/>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioSexoCopiaCitologia" disabled="true"
                                                 rendered="#{consultarCopiaCitologiaBean.renderInformacionUsuario}"
                                                 value="#{consultarCopiaCitologiaBean.usuario.husesexo}">
                                    <f:selectItems value="#{consultarCopiaCitologiaBean.listSexos}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioEstadoCivilCopiaCitologia" disabled="true"
                                                 rendered="#{consultarCopiaCitologiaBean.renderInformacionUsuario}"
                                                 value="#{consultarCopiaCitologiaBean.usuario.huseestadcivil}">
                                    <f:selectItems value="#{consultarCopiaCitologiaBean.listEstadoCivil}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="panelBotonCopiaCitologia" columnClasses="panelGridBotones">
                            <h:panelGroup>
                                <a4j:outputPanel id="ajaxRegionMessagesFoliosMedico" ajaxRendered="true">
                                    <t:htmlTag value="br"/>
                                    <t:message for="idButtonBuscarHistoriaCitologia" id="msgCopiaCitologia"
                                               errorClass="error" infoClass="informacion"/>
                                </a4j:outputPanel>
                            </h:panelGroup>
                            <a4j:commandButton value="Consultar Citologias"
                                               action="#{consultarCopiaCitologiaBean.consultarCitologiasUsuario}"
                                               reRender="fieldSetCopiaCitologia" styleClass="btn btn btn-success"
                                               id="idButtonBuscarHistoriaCitologia"/>
                        </h:panelGrid>
                    </s:fieldset>
                    
                    
                    
     <s:fieldset legend="Resultados Consulta" id="fieldSetCopiaCitologia" styleClass="fieldset_dataTable">
        <h:panelGrid columns="1" id="panelGridCopiaCitologia"
                     rendered="#{empty consultarCopiaCitologiaBean.lstCitologiaUsuario}">
          <h:outputText value="#{msg.msg_sin_consultar}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
                    id="tableContentTabsBucarCopiaCitologia"
                     rendered="#{not empty consultarCopiaCitologiaBean.lstCitologiaUsuario}" 
                        styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         value="#{consultarCopiaCitologiaBean.lstCitologiaUsuario}" rows="10" styleClass="standard_table"
                         binding="#{consultarCopiaCitologiaBean.dtCopiaCitologia}"
                         rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtBucarCopiaCitologia">
                         
            <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha Toma"/>
                </f:facet>
                <h:outputText value="#{item[8]}"/>
              </h:column>   
              
              
            <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha Registro Lectura"/>
                </f:facet>
                <h:outputText value="#{item[9]}"/>
              </h:column>   
                         
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Consecutivo"/>
                </f:facet>
                <h:outputText value="#{item[0]}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="N�mero Citologia"/>
                </f:facet>
                <h:outputText value="#{item[1]}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Documento"/>
                </f:facet>
                <h:outputText value="#{item[2]} #{item[3]}"/>
              </h:column>
              
               <h:column>
                <f:facet name="header">
                  <h:outputText value="Nombre Paciente"/>
                </f:facet>
                <h:outputText value="#{item[4]} #{item[5]} #{item[6]} #{item[7]}"/>
              </h:column>
              
              
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Generar Toma"/>
                </f:facet>
                <h:commandLink id="generarToma" action="#{consultarCopiaCitologiaBean.generarCopiaTomaBaseLiquida}">
                  <t:graphicImage alt=""  border="0" url="/comun/imagenes/pdfIcon.png"/>
                </h:commandLink>
              </h:column>
              
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Generar Lectura"/>
                </f:facet>
                <h:commandLink id="generarLectura" action="#{consultarCopiaCitologiaBean.generarCopiaLectura}">
                  <t:graphicImage alt=""  border="0" url="/comun/imagenes/pdfIcon.png"/>
                </h:commandLink>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_Copia" for="dtBucarCopiaCitologia" fastStep="10" pageCountVar="pageCount"
                              pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                              paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                              paginatorActiveColumnStyle="font-weight:bold;">
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
                    
                    
                    
                    <h:panelGrid>
                        <h:commandLink action="#{consultarCopiaCitologiaBean.volverConsulta}" immediate="true">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                        </h:commandLink>
                    </h:panelGrid>
                </t:panelTab>
                <t:panelTab id="panelCopiaCitologia" label="Buscar Usuarios"
                            rendered="#{consultarCopiaCitologiaBean.renderBuscador}">
                    <a4j:region id="regionBuscadorUsuCopiaCitologia" renderRegionOnly="false">
                        <a4j:status for="regionBuscadorUsuCopiaCitologia">
                            <f:facet name="start">
                                <t:div id="chargingBuscUsuMedico" styleClass="loading">
                                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                                        <h:outputText value="Procesando..."/>
                                        <h:outputText value="Por favor espere."/>
                                    </h:panelGrid>
                                </t:div>
                            </f:facet>
                            <f:facet name="stop"/>
                        </a4j:status>
                        <jsp:include page="/pages/clinico/comunes/buscador/buscadorUsuarios.jsp" flush="true"/>
                        <h:panelGrid id="panelGridBusUsuaBotCopiaCitologia" width="100%"
                                     columnClasses="columnaBotonesCentrados" dir="RTL">
                            <t:htmlTag value="br"/>
                            <h:panelGroup id="panelGroupBusUsuBotCopiaCitologia">
                                <h:commandButton value="Aceptar Usuario" styleClass="btn btn btn-success"
                                                 action="#{consultarCopiaCitologiaBean.aceptarUsuario}">
                                                 <a4j:support event="onclick" status="statusButton"/>
                                                 </h:commandButton>
                            </h:panelGroup>
                        </h:panelGrid>
                    </a4j:region>
                </t:panelTab>
            </t:panelTabbedPane>
        </h:panelGrid>
        <h:panelGrid>
            <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMsgCopiaCitologia" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationMsgCopiaCitologia" showSummary="true" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
            </h:panelGroup>
        </h:panelGrid>
        <f:subview id="generarCopiaCitologia" rendered="#{consultarCopiaCitologiaBean.generoHistoria}">
            <f:verbatim>
                <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
            </f:verbatim>
        </f:subview>
    </a4j:region>
</a4j:form>