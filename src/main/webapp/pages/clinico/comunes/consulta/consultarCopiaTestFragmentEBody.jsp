<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="consultarCopiaTestFragEspermaForm">
    <a4j:region id="bodyRegionCopiaTestFragEsperma">
        <a4j:status id = "statusButton" for="bodyRegionCopiaTestFragEsperma">
            <f:facet name="start">
                <t:div id="chargindConsultarCopiaTestFragEsperma" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
  
        <h:panelGrid columns="1" id="tableConsultarCopiaTestFragEsperma" border="0" cellpadding="0" cellspacing="0"
                     width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
            <h:outputText value="Imprimir Copia Test Fragmentaci�n Esperm�tica " id="infoUbicationCopiaTestFragEsperma"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableCopiaTestFragEspermaTabs"
                     styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxFoliosCopiaTestFragEsperma" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgFoliosCopiaTestFragEsperma" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabConCopiaTestFragEsperma" styleClass="tabbedPane"
                               activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                               selectedIndex="#{consultarCopiaTestFragEspermaBean.selectedIndex}"
                               disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                               inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                <t:panelTab id="panelConFoliosCopiaTestFragEsperma" label="Consultar Test Fragmentaci�n Esperm�tica"
                            rendered="#{!consultarCopiaTestFragEspermaBean.renderBuscador}">
                    <s:fieldset legend="Datos Paciente" id="fieldDatosCopiaTestFragEsperma" styleClass="fieldset">
                        <h:panelGrid columns="4" border="0" cellpadding="0" width="100%"
                                     id="tableContentListaConCopiaTestFragEsperma" rowClasses="labelText,labelTextInfo">
                            <h:outputText value="N�mero Usuario" styleClass="labelTextOblig"/>
                            <h:panelGroup>
                                <h:outputText value="Nombre" styleClass="labelTextOblig"
                                              rendered="#{consultarCopiaTestFragEspermaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Tipo Documento" styleClass="labelTextOblig"
                                              rendered="#{consultarCopiaTestFragEspermaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Numero Documento" styleClass="labelTextOblig"
                                              rendered="#{consultarCopiaTestFragEspermaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                                         columnClasses="labelTextInfo">
                                <a4j:commandLink action="#{consultarCopiaTestFragEspermaBean.mostrarBuscadorUsuarios}"
                                                 immediate="true" reRender="tableCopiaTestFragEspermaTabs">
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                                </a4j:commandLink>
                                <h:inputText id="idtipoCopiaTestFragEsperma" maxlength="15" style="width:80px"
                                             immediate="true" value="#{consultarCopiaTestFragEspermaBean.numeroUsuario}"
                                             valueChangeListener="#{consultarCopiaTestFragEspermaBean.setNumeroUsuario}"
                                             binding="#{consultarCopiaTestFragEspermaBean.itNumeroUsuario}"
                                             onkeydown="return blockEnter(event);">
                                    <a4j:support id="supportNumUsuarioCopiaTestFragEsperma" event="onchange"
                                                 ignoreDupResponses="true"
                                                 action="#{consultarCopiaTestFragEspermaBean.changeUsuario}"
                                                 reRender="tableCopiaTestFragEspermaTabs">
                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    </a4j:support>
                                </h:inputText>
                                <a4j:outputPanel ajaxRendered="true">
                                    <t:message for="idtipoCopiaTestFragEsperma" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                            </h:panelGrid>
                            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2"
                                         id="panelNombreUsuarioidtipoCopiaTestFragEsperma">
                                <h:outputText value=" #{consultarCopiaTestFragEspermaBean.nombreUsuario}"
                                              styleClass="buscador"/>
                            </h:panelGrid>
                            <h:outputText value="#{consultarCopiaTestFragEspermaBean.usuario.husetipoiden}"/>
                            <h:outputText value="#{consultarCopiaTestFragEspermaBean.usuario.husanumeiden}"/>
                            <h:panelGroup>
                                <h:outputText value="Fecha de Nacimiento" styleClass="labelTextOblig"
                                              rendered="#{consultarCopiaTestFragEspermaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="Edad" styleClass="labelTextOblig"
                                          rendered="#{consultarCopiaTestFragEspermaBean.renderInformacionUsuario}"/>
                            <h:panelGroup>
                                <h:outputText value="Sexo"
                                              rendered="#{consultarCopiaTestFragEspermaBean.renderInformacionUsuario}"
                                              styleClass="labelTextOblig"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Estado Civil" styleClass="labelTextOblig"
                                              rendered="#{consultarCopiaTestFragEspermaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="#{consultarCopiaTestFragEspermaBean.usuario.husdfechanacim}"/>
                            <h:outputText value="#{consultarCopiaTestFragEspermaBean.usuario.edad}"/>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioSexoCopiaTestFragEsperma" disabled="true"
                                                 rendered="#{consultarCopiaTestFragEspermaBean.renderInformacionUsuario}"
                                                 value="#{consultarCopiaTestFragEspermaBean.usuario.husesexo}">
                                    <f:selectItems value="#{consultarCopiaTestFragEspermaBean.listSexos}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioEstadoCivilCopiaTestFragEsperma" disabled="true"
                                                 rendered="#{consultarCopiaTestFragEspermaBean.renderInformacionUsuario}"
                                                 value="#{consultarCopiaTestFragEspermaBean.usuario.huseestadcivil}">
                                    <f:selectItems value="#{consultarCopiaTestFragEspermaBean.listEstadoCivil}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="panelBotonCopiaTestFragEsperma" columnClasses="panelGridBotones">
                            <h:panelGroup>
                                <a4j:outputPanel id="ajaxRegionMessagesFoliosMedico" ajaxRendered="true">
                                    <t:htmlTag value="br"/>
                                    <t:message for="idButtonBuscarHistoriaCitologia" id="msgCopiaTestFragEsperma"
                                               errorClass="error" infoClass="informacion"/>
                                </a4j:outputPanel>
                            </h:panelGroup>
                            <a4j:commandButton value="Consultar Test"
                                               action="#{consultarCopiaTestFragEspermaBean.consultarTestUsuario}"
                                               reRender="fieldSetCopiaTestFragEsperma" styleClass="btn btn btn-success"
                                               id="idButtonBuscarHistoriaCitologia"/>
                        </h:panelGrid>
                    </s:fieldset>
                    
                    
                    
     <s:fieldset legend="Resultados Consulta" id="fieldSetCopiaTestFragEsperma" styleClass="fieldset_dataTable">
        <h:panelGrid columns="1" id="panelGridCopiaTestFragEsperma"
                     rendered="#{empty consultarCopiaTestFragEspermaBean.lstTestUsuario}">
          <h:outputText value="#{msg.msg_sin_consultar}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
                    id="tableContentTabsBucarCopiaTestFragEsperma"
                     rendered="#{not empty consultarCopiaTestFragEspermaBean.lstTestUsuario}" 
                        styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         value="#{consultarCopiaTestFragEspermaBean.lstTestUsuario}" rows="10" styleClass="standard_table"
                         binding="#{consultarCopiaTestFragEspermaBean.dtCopiaCitologia}"
                         rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtBucarCopiaTestFragEsperma">
                         
            <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha Toma"/>
                </f:facet>
                <h:outputText value="#{item[0]}"/>
              </h:column>   
              
              
            <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha Registro test"/>
                </f:facet>
                <h:outputText value="#{item[1]}"/>
              </h:column>   
     
              <h:column>
                <f:facet name="header">
                  <h:outputText value="N�mero Consulta"/>
                </f:facet>
                <h:outputText value="#{item[2]}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Documento"/>
                </f:facet>
                <h:outputText value="#{item[4]} #{item[5]}"/>
              </h:column>
              
               <h:column>
                <f:facet name="header">
                  <h:outputText value="Nombre Paciente"/>
                </f:facet>
                <h:outputText value="#{item[6]} #{item[7]} #{item[8]} #{item[9]}"/>
              </h:column>
              
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Generar Lectura"/>
                </f:facet>
                <h:commandLink id="generarLectura" action="#{consultarCopiaTestFragEspermaBean.generarCopiaTestFragE}">
                  <t:graphicImage alt=""  border="0" url="/comun/imagenes/pdfIcon.png"/>
                </h:commandLink>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_Copia" for="dtBucarCopiaTestFragEsperma" fastStep="10" pageCountVar="pageCount"
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
                        <h:commandLink action="#{consultarCopiaTestFragEspermaBean.volverConsulta}" immediate="true">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                        </h:commandLink>
                    </h:panelGrid>
                </t:panelTab>
                <t:panelTab id="panelCopiaTestFragEsperma" label="Buscar Usuarios"
                            rendered="#{consultarCopiaTestFragEspermaBean.renderBuscador}">
                    <a4j:region id="regionBuscadorUsuCopiaTestFragEsperma" renderRegionOnly="false">
                        <a4j:status for="regionBuscadorUsuCopiaTestFragEsperma">
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
                        <h:panelGrid id="panelGridBusUsuaBotCopiaTestFragEsperma" width="100%"
                                     columnClasses="columnaBotonesCentrados" dir="RTL">
                            <t:htmlTag value="br"/>
                            <h:panelGroup id="panelGroupBusUsuBotCopiaTestFragEsperma">
                                <h:commandButton value="Aceptar Usuario" styleClass="btn btn btn-success"
                                                 action="#{consultarCopiaTestFragEspermaBean.aceptarUsuario}">
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
                <a4j:outputPanel id="ajaxRegionMsgCopiaTestFragEsperma" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationMsgCopiaTestFragEsperma" showSummary="true" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
            </h:panelGroup>
        </h:panelGrid>
        <f:subview id="generarCopiaTestFragEsperma" rendered="#{consultarCopiaTestFragEspermaBean.generoTestFragEsperma}">
            <f:verbatim>
                <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
            </f:verbatim>
        </f:subview>
    </a4j:region>
</a4j:form>