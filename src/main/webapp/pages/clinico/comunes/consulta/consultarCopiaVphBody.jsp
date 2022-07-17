<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="consultarCopiaVphForm">
    <a4j:region id="bodyRegionCopiaVph">
        <a4j:status id = "statusButton" for="bodyRegionCopiaVph">
            <f:facet name="start">
                <t:div id="chargindConsultarCopiaVph" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
  
        <h:panelGrid columns="1" id="tableConsultarCopiaVph" border="0" cellpadding="0" cellspacing="0"
                     width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
            <h:outputText value="Imprimir Copia Vph " id="infoUbicationCopiaVph"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableCopiaVphTabs"
                     styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxFoliosCopiaVph" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgFoliosCopiaVph" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabConCopiaVph" styleClass="tabbedPane"
                               activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                               selectedIndex="#{consultarCopiaVphBean.selectedIndex}"
                               disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                               inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                <t:panelTab id="panelConFoliosCopiaVph" label="Consultar VPH"
                            rendered="#{!consultarCopiaVphBean.renderBuscador}">
                    <s:fieldset legend="Datos Paciente" id="fieldDatosCopiaVph" styleClass="fieldset">
                        <h:panelGrid columns="4" border="0" cellpadding="0" width="100%"
                                     id="tableContentListaConCopiaVph" rowClasses="labelText,labelTextInfo">
                            <h:outputText value="N�mero Usuario" styleClass="labelTextOblig"/>
                            <h:panelGroup>
                                <h:outputText value="Nombre" styleClass="labelTextOblig"
                                              rendered="#{consultarCopiaVphBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Tipo Documento" styleClass="labelTextOblig"
                                              rendered="#{consultarCopiaVphBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Numero Documento" styleClass="labelTextOblig"
                                              rendered="#{consultarCopiaVphBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                                         columnClasses="labelTextInfo">
                                <a4j:commandLink action="#{consultarCopiaVphBean.mostrarBuscadorUsuarios}"
                                                 immediate="true" reRender="tableCopiaVphTabs">
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                                </a4j:commandLink>
                                <h:inputText id="idtipoCopiaVph" maxlength="15" style="width:80px"
                                             immediate="true" value="#{consultarCopiaVphBean.numeroUsuario}"
                                             valueChangeListener="#{consultarCopiaVphBean.setNumeroUsuario}"
                                             binding="#{consultarCopiaVphBean.itNumeroUsuario}"
                                             onkeydown="return blockEnter(event);">
                                    <a4j:support id="supportNumUsuarioCopiaVph" event="onchange"
                                                 ignoreDupResponses="true"
                                                 action="#{consultarCopiaVphBean.changeUsuario}"
                                                 reRender="tableCopiaVphTabs">
                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    </a4j:support>
                                </h:inputText>
                                <a4j:outputPanel ajaxRendered="true">
                                    <t:message for="idtipoCopiaVph" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                            </h:panelGrid>
                            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2"
                                         id="panelNombreUsuarioidtipoCopiaVph">
                                <h:outputText value=" #{consultarCopiaVphBean.nombreUsuario}"
                                              styleClass="buscador"/>
                            </h:panelGrid>
                            <h:outputText value="#{consultarCopiaVphBean.usuario.husetipoiden}"/>
                            <h:outputText value="#{consultarCopiaVphBean.usuario.husanumeiden}"/>
                            <h:panelGroup>
                                <h:outputText value="Fecha de Nacimiento" styleClass="labelTextOblig"
                                              rendered="#{consultarCopiaVphBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="Edad" styleClass="labelTextOblig"
                                          rendered="#{consultarCopiaVphBean.renderInformacionUsuario}"/>
                            <h:panelGroup>
                                <h:outputText value="Sexo"
                                              rendered="#{consultarCopiaVphBean.renderInformacionUsuario}"
                                              styleClass="labelTextOblig"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Estado Civil" styleClass="labelTextOblig"
                                              rendered="#{consultarCopiaVphBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="#{consultarCopiaVphBean.usuario.husdfechanacim}"/>
                            <h:outputText value="#{consultarCopiaVphBean.usuario.edad}"/>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioSexoCopiaVph" disabled="true"
                                                 rendered="#{consultarCopiaVphBean.renderInformacionUsuario}"
                                                 value="#{consultarCopiaVphBean.usuario.husesexo}">
                                    <f:selectItems value="#{consultarCopiaVphBean.listSexos}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioEstadoCivilCopiaVph" disabled="true"
                                                 rendered="#{consultarCopiaVphBean.renderInformacionUsuario}"
                                                 value="#{consultarCopiaVphBean.usuario.huseestadcivil}">
                                    <f:selectItems value="#{consultarCopiaVphBean.listEstadoCivil}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="panelBotonCopiaVph" columnClasses="panelGridBotones">
                            <h:panelGroup>
                                <a4j:outputPanel id="ajaxRegionMessagesFoliosMedico" ajaxRendered="true">
                                    <t:htmlTag value="br"/>
                                    <t:message for="idButtonBuscarHistoriaVph" id="msgCopiaVph"
                                               errorClass="error" infoClass="informacion"/>
                                </a4j:outputPanel>
                            </h:panelGroup>
                            <a4j:commandButton value="Consultar VPH"
                                               action="#{consultarCopiaVphBean.consultarVphsUsuario}"
                                               reRender="fieldSetCopiaVph,fieldSetConsultarConsec" styleClass="btn btn btn-success"
                                               id="idButtonBuscarHistoriaVph"/>
                        </h:panelGrid>
                    </s:fieldset>
                    
                    
                    
     <s:fieldset legend="Resultados Consulta" id="fieldSetCopiaVph" styleClass="fieldset_dataTable">
        <h:panelGrid columns="1" id="panelGridCopiaVph"
                     rendered="#{empty consultarCopiaVphBean.lstVphUsuario}">
          <h:outputText value="#{msg.msg_sin_consultar}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
                    id="tableContentTabsBucarCopiaVph"
                     rendered="#{not empty consultarCopiaVphBean.lstVphUsuario}" 
                        styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         value="#{consultarCopiaVphBean.lstVphUsuario}" rows="10" styleClass="standard_table"
                         binding="#{consultarCopiaVphBean.dtCopiaVph}"
                         rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtBucarCopiaVph">
                         
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
                  <h:outputText value="N�mero Vph"/>
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
                <h:commandLink id="toma" action="#{consultarCopiaVphBean.generarCopiaToma}">
                  <t:graphicImage alt=""  border="0" url="/comun/imagenes/pdfIcon.png"/>
                </h:commandLink>
              </h:column>
              
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Generar Lectura"/>
                </f:facet>
                <h:commandLink id="lectura" action="#{consultarCopiaVphBean.generarCopiaLectura}">
                  <t:graphicImage alt=""  border="0" url="/comun/imagenes/pdfIcon.png"/>
                </h:commandLink>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Generar CodigoQR"/>
                </f:facet>
                <h:commandLink id="codigoQR" action="#{consultarCopiaVphBean.generarReporteCodigoQR}">
                  <t:graphicImage alt=""  border="0" url="/comun/imagenes/pdfIcon.png"/>
                </h:commandLink>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_Copia" for="dtBucarCopiaVph" fastStep="10" pageCountVar="pageCount"
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
                    
       <s:fieldset legend="Consulta por Consecutivo" id="fieldSetConsultarConsec" styleClass="fieldset_dataTable">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonConsec"
                     columnClasses="columnaBotonesCentrados">
        <h:outputText value=" N�mero Consecutivo"/>
        <h:panelGroup>
            <h:inputText id="itNumeroConsec" value="#{consultarCopiaVphBean.consecutivoCito}"></h:inputText>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itNumeroConsec" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <a4j:outputPanel id="consultarConsec" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:message for="idButtonConsec" id="msgInformationConsec" errorClass="error" infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <t:htmlTag value="br"/>
          <a4j:commandButton value="Buscar por Consecutivo" action="#{consultarCopiaVphBean.consultarConsecutivoCitologia}"
                             reRender="fieldSetCopiaVph,fieldDatosCopiaVph" styleClass="boton_fieldset" id="idButtonConsec"/>
        </h:panelGrid>
      </s:fieldset>              
                    
                    <h:panelGrid>
                        <h:commandLink action="#{consultarCopiaVphBean.volverConsulta}" immediate="true">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                        </h:commandLink>
                    </h:panelGrid>
                </t:panelTab>
                <t:panelTab id="panelCopiaVph" label="Buscar Usuarios"
                            rendered="#{consultarCopiaVphBean.renderBuscador}">
                    <a4j:region id="regionBuscadorUsuCopiaVph" renderRegionOnly="false">
                        <a4j:status for="regionBuscadorUsuCopiaVph">
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
                        <h:panelGrid id="panelGridBusUsuaBotCopiaVph" width="100%"
                                     columnClasses="columnaBotonesCentrados" dir="RTL">
                            <t:htmlTag value="br"/>
                            <h:panelGroup id="panelGroupBusUsuBotCopiaVph">
                                <h:commandButton value="Aceptar Usuario" styleClass="btn btn btn-success"
                                                 action="#{consultarCopiaVphBean.aceptarUsuario}">
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
                <a4j:outputPanel id="ajaxRegionMsgCopiaVph" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationMsgCopiaVph" showSummary="true" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
            </h:panelGroup>
        </h:panelGrid>
        <f:subview id="generarCopiaVph" rendered="#{consultarCopiaVphBean.generoHistoria}">
            <f:verbatim>
                <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
            </f:verbatim>
        </f:subview>
    </a4j:region>
</a4j:form>