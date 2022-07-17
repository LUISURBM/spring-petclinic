<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="consultarpruebasRapidasForm">
    <a4j:region id="bodyRegionpruebasRapidas">
        <a4j:status id = "statusButton" for="bodyRegionpruebasRapidas">
            <f:facet name="start">
                <t:div id="chargindConsultarpruebasRapidas" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
  
        <h:panelGrid columns="1" id="tableConsultarpruebasRapidas" border="0" cellpadding="0" cellspacing="0"
                     width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
            <h:outputText value="Imprimir Pruebas R�pidas " id="infoUbicationpruebasRapidas"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tablepruebasRapidasTabs"
                     styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxFoliospruebasRapidas" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgFoliospruebasRapidas" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabConpruebasRapidas" styleClass="tabbedPane"
                               activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                               selectedIndex="#{consultarPruebasRapidasBean.selectedIndex}"
                               disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                               inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                <t:panelTab id="panelConFoliospruebasRapidas" label="Consultar Pruebas R�pidas"
                            rendered="#{!consultarPruebasRapidasBean.renderBuscador}">
                    <s:fieldset legend="Datos Paciente" id="fieldDatospruebasRapidas" styleClass="fieldset">
                        <h:panelGrid columns="4" border="0" cellpadding="0" width="100%"
                                     id="tableContentListaConpruebasRapidas" rowClasses="labelText,labelTextInfo">
                            <h:outputText value="N�mero Usuario" styleClass="labelTextOblig"/>
                            <h:panelGroup>
                                <h:outputText value="Nombre" styleClass="labelTextOblig"
                                              rendered="#{consultarPruebasRapidasBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Tipo Documento" styleClass="labelTextOblig"
                                              rendered="#{consultarPruebasRapidasBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Numero Documento" styleClass="labelTextOblig"
                                              rendered="#{consultarPruebasRapidasBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                                         columnClasses="labelTextInfo">
                                <a4j:commandLink action="#{consultarPruebasRapidasBean.mostrarBuscadorUsuarios}"
                                                 immediate="true" reRender="tablepruebasRapidasTabs">
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                                </a4j:commandLink>
                                <h:inputText id="idtipopruebasRapidas" maxlength="15" style="width:80px"
                                             immediate="true" value="#{consultarPruebasRapidasBean.numeroUsuario}"
                                             valueChangeListener="#{consultarPruebasRapidasBean.setNumeroUsuario}"
                                             binding="#{consultarPruebasRapidasBean.itNumeroUsuario}"
                                             onkeydown="return blockEnter(event);">
                                    <a4j:support id="supportNumUsuariopruebasRapidas" event="onchange"
                                                 ignoreDupResponses="true"
                                                 action="#{consultarPruebasRapidasBean.changeUsuario}"
                                                 reRender="tablepruebasRapidasTabs">
                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    </a4j:support>
                                </h:inputText>
                                <a4j:outputPanel ajaxRendered="true">
                                    <t:message for="idtipopruebasRapidas" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                            </h:panelGrid>
                            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2"
                                         id="panelNombreUsuarioidtipopruebasRapidas">
                                <h:outputText value=" #{consultarPruebasRapidasBean.nombreUsuario}"
                                              styleClass="buscador"/>
                            </h:panelGrid>
                            <h:outputText value="#{consultarPruebasRapidasBean.usuario.husetipoiden}"/>
                            <h:outputText value="#{consultarPruebasRapidasBean.usuario.husanumeiden}"/>
                            <h:panelGroup>
                                <h:outputText value="Fecha de Nacimiento" styleClass="labelTextOblig"
                                              rendered="#{consultarPruebasRapidasBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="Edad" styleClass="labelTextOblig"
                                          rendered="#{consultarPruebasRapidasBean.renderInformacionUsuario}"/>
                            <h:panelGroup>
                                <h:outputText value="Sexo"
                                              rendered="#{consultarPruebasRapidasBean.renderInformacionUsuario}"
                                              styleClass="labelTextOblig"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Estado Civil" styleClass="labelTextOblig"
                                              rendered="#{consultarPruebasRapidasBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="#{consultarPruebasRapidasBean.usuario.husdfechanacim}"/>
                            <h:outputText value="#{consultarPruebasRapidasBean.usuario.edad}"/>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioSexopruebasRapidas" disabled="true"
                                                 rendered="#{consultarPruebasRapidasBean.renderInformacionUsuario}"
                                                 value="#{consultarPruebasRapidasBean.usuario.husesexo}">
                                    <f:selectItems value="#{consultarPruebasRapidasBean.listSexos}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioEstadoCivilpruebasRapidas" disabled="true"
                                                 rendered="#{consultarPruebasRapidasBean.renderInformacionUsuario}"
                                                 value="#{consultarPruebasRapidasBean.usuario.huseestadcivil}">
                                    <f:selectItems value="#{consultarPruebasRapidasBean.listEstadoCivil}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="panelBotonpruebasRapidas" columnClasses="panelGridBotones">
                            <h:panelGroup>
                                <a4j:outputPanel id="ajaxRegionMessagesFoliosMedico" ajaxRendered="true">
                                    <t:htmlTag value="br"/>
                                    <t:message for="idButtonBuscarHistoriaCitologia" id="msgpruebasRapidas"
                                               errorClass="error" infoClass="informacion"/>
                                </a4j:outputPanel>
                            </h:panelGroup>
                            <a4j:commandButton value="Consultar Pruebas R�pidas"
                                               action="#{consultarPruebasRapidasBean.consultarRegistros}"
                                               reRender="fieldSetpruebasRapidas" styleClass="btn btn btn-success"
                                               id="idButtonBuscarHistoriaCitologia"/>
                        </h:panelGrid>
                    </s:fieldset>
                    
                    
                    
     <s:fieldset legend="Resultados Consulta" id="fieldSetpruebasRapidas" styleClass="fieldset_dataTable">
        <h:panelGrid columns="1" id="panelGridpruebasRapidas"
                     rendered="#{empty consultarPruebasRapidasBean.lstRegistros}">
          <h:outputText value="#{msg.msg_sin_consultar}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
                    id="tableContentTabsBucarpruebasRapidas"
                     rendered="#{not empty consultarPruebasRapidasBean.lstRegistros}" 
                        styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         value="#{consultarPruebasRapidasBean.lstRegistros}" rows="10" styleClass="standard_table"
                         binding="#{consultarPruebasRapidasBean.dtPruebaRapida}"
                         rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtBucarpruebasRapidas">
                         
            <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha de Registro"/>
                </f:facet>
                <h:outputText value="#{item[1]}"/>
              </h:column>   
              
              
            <h:column>
                <f:facet name="header">
                  <h:outputText value="Nombre del Servicio"/>
                </f:facet>
                <h:outputText value="#{item[2]}"/>
              </h:column>   
     
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha de Nacimiento"/>
                </f:facet>
                <h:outputText value="#{item[5]}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="N�mero de Consulta"/>
                </f:facet>
                <h:outputText value="#{item[0]}"/>
              </h:column>
              
               <h:column>
                <f:facet name="header">
                  <h:outputText value="Nombre Paciente"/>
                </f:facet>
                <h:outputText value="#{item[6]} #{item[7]} #{item[8]} #{item[9]}"/>
              </h:column>
              
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Generar Impresi�n"/>
                </f:facet>
                <h:commandLink id="generarLectura" action="#{consultarPruebasRapidasBean.generarArchivoPdf}">
                  <t:graphicImage alt=""  border="0" url="/comun/imagenes/pdfIcon.png"/>
                </h:commandLink>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_Copia" for="dtBucarpruebasRapidas" fastStep="10" pageCountVar="pageCount"
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
                        <h:commandLink action="#{consultarPruebasRapidasBean.volverConsulta}" immediate="true">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                        </h:commandLink>
                    </h:panelGrid>
                </t:panelTab>
                <t:panelTab id="panelpruebasRapidas" label="Buscar Usuarios"
                            rendered="#{consultarPruebasRapidasBean.renderBuscador}">
                    <a4j:region id="regionBuscadorUsupruebasRapidas" renderRegionOnly="false">
                        <a4j:status for="regionBuscadorUsupruebasRapidas">
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
                        <h:panelGrid id="panelGridBusUsuaBotpruebasRapidas" width="100%"
                                     columnClasses="columnaBotonesCentrados" dir="RTL">
                            <t:htmlTag value="br"/>
                            <h:panelGroup id="panelGroupBusUsuBotpruebasRapidas">
                                <h:commandButton value="Aceptar Usuario" styleClass="btn btn btn-success"
                                                 action="#{consultarPruebasRapidasBean.aceptarUsuario}">
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
                <a4j:outputPanel id="ajaxRegionMsgpruebasRapidas" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationMsgpruebasRapidas" showSummary="true" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
            </h:panelGroup>
        </h:panelGrid>
        <f:subview id="generarpruebasRapidas" rendered="#{consultarPruebasRapidasBean.generoReporte}">
            <f:verbatim>
                <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
            </f:verbatim>
        </f:subview>
    </a4j:region>
</a4j:form>