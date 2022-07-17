<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formRegistrarCirugia">
  <a4j:region id="regionRegistrarCirugia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionRegistrarCirugia">
      <f:facet name="start">
        <t:div id="chargingRegistrarCirugia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableConsultarFolio" border="0" cellpadding="0" cellspacing="0" width="100%"
                 styleClass="td_ubicador">
      <h:outputText value="Registrar Consulta sin Factura Usuario " id="infoUbication"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentConsultarFolios"
                 styleClass="tabContainer">
      <s:fieldset legend="Datos Usuario" id="fieldSetInfoConsultarUsuario" styleClass="fieldset">
        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoConsulta"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Tipo Identificación"/>
          <h:outputText value=" Numero Identificación"/>
          <h:outputText value="Número Usuario"/>
          <h:panelGroup>
            <h:selectOneMenu id="tipoIde" required="true" disabled="true"
                             value="#{registrarConsultaSinFacturaBean.usuario.husetipoiden}">
              <f:selectItems value="#{registrarConsultaSinFacturaBean.listTipoIdentificacion}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="tipoIde" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="#{registrarConsultaSinFacturaBean.usuario.husanumeiden}"/>
          <h:outputText id="itNumeroUsuario" value="#{registrarConsultaSinFacturaBean.usuario.huslnumero}"/>
          <t:htmlTag value="br"/>
        </h:panelGrid>
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosNombre"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Primer Nombre"/>
          <h:outputText value="Segundo Nombre"/>
          <h:outputText value="Primer Apellido"/>
          <h:outputText value="Segundo Apellido"/>
          <h:panelGroup>
            <h:outputText value="#{registrarConsultaSinFacturaBean.usuario.huscprimernomb}"/>
          </h:panelGroup>
          <h:outputText value="#{registrarConsultaSinFacturaBean.usuario.huscsegundnomb}"/>
          <h:panelGroup>
            <h:outputText id="primerApellido" value="#{registrarConsultaSinFacturaBean.usuario.huscprimerapel}"/>
          </h:panelGroup>
          <h:outputText value="#{registrarConsultaSinFacturaBean.usuario.huscsegundapel}"/>
          <h:outputText value="Fecha Nacimiento"/>
          <h:outputText value="Edad"/>
          <h:outputText value="Sexo"/>
          <h:outputText value="Estado Civil"/>
          <h:panelGroup>
            <h:outputText value="#{registrarConsultaSinFacturaBean.usuario.husdfechanacim}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="#{registrarConsultaSinFacturaBean.edad}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneMenu id="radioSexo" disabled="true" value="#{registrarConsultaSinFacturaBean.usuario.husesexo}">
              <f:selectItems value="#{registrarConsultaSinFacturaBean.listSexos}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioSexo" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneMenu id="radioEstadoCivil" disabled="true"
                             value="#{registrarConsultaSinFacturaBean.usuario.huseestadcivil}">
              <f:selectItems value="#{registrarConsultaSinFacturaBean.listEstadoCivil}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioEstadoCivil" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridRegistrarCirugiaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneProgramarCirugia"
                         selectedIndex="#{registrarConsultaSinFacturaBean.selectedIndex}" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabRegistrarCirugia" label="Registro de Consulta(s) Sin Factura">
          <s:fieldset legend="Lista Consultas Sin Factura" id="fieldListaCirugiasRegistradas" styleClass="fieldset">
            <h:panelGrid columns="1" id="panelGridCirugiasRegistradas"
                         rendered="#{empty registrarConsultaSinFacturaBean.lstCirugiasRegistradas}">
              <h:outputText value="#{msg.msg_sin_consultar}"/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="tableContentCirugiasProgramadas"
                         rendered="#{not empty registrarConsultaSinFacturaBean.lstCirugiasRegistradas}"
                         styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                             binding="#{registrarConsultaSinFacturaBean.dtCirugiasRegistradas}"
                             value="#{registrarConsultaSinFacturaBean.lstCirugiasRegistradas}"
                             styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                             footerClass="paginacion" rows="10" id="idDtCirugiasRegistradas">
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Numero"/>
                    </f:facet>
                    <h:outputText value="#{item.hrcnnumero}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Fecha"/>
                    </f:facet>
                    <h:outputText value="#{item.hrcdfeccirpro}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Servicio"/>
                    </f:facet>
                    <h:outputText value="#{item.hrccservic.csvccodigo} - #{item.hrccservic.csvcnombre}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Consulta Inicial"/>
                    </f:facet>
                    <h:outputText value="#{item.hrcnconini}"/>
                  </h:column>
                </h:dataTable>
              </t:buffer>
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_3" for="idDtCirugiasRegistradas" fastStep="10" pageCountVar="pageCount"
                                  pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                                  renderFacetsIfSinglePage="false" paginatorMaxPages="9" paginatorTableClass="paginator"
                                  paginatorActiveColumnStyle="font-weight:bold;">
                    <f:facet name="first">
                      <t:graphicImage alt="" url="/comun/imagenes/primero.gif" border="0"/>
                    </f:facet>
                    <f:facet name="last">
                      <t:graphicImage alt="" url="/comun/imagenes/ultimo.gif" border="0"/>
                    </f:facet>
                    <f:facet name="previous">
                      <t:graphicImage alt="" url="/comun/imagenes/anterior.gif" border="0"/>
                    </f:facet>
                    <f:facet name="next">
                      <t:graphicImage alt="" url="/comun/imagenes/siguiente.gif" border="0"/>
                    </f:facet>
                    <f:facet name="fastforward">
                      <t:graphicImage alt="" url="/comun/imagenes/adelante.gif" border="0"/>
                    </f:facet>
                    <f:facet name="fastrewind">
                      <t:graphicImage alt="" url="/comun/imagenes/atras.gif" border="0"/>
                    </f:facet>
                  </t:dataScroller>
                  <t:dataScroller id="scroll_4" for="idDtCirugiasRegistradas" rowsCountVar="rowsCount"
                                  displayedRowsCountVar="displayedRowsCountVar" firstRowIndexVar="firstRowIndex"
                                  lastRowIndexVar="lastRowIndex" pageCountVar="pageCount" pageIndexVar="pageIndex">
                    <h:outputFormat value="Registros : Total {0}, mostrados {1} del {2} al {3}  Pagina {4} / {5}"
                                    styleClass="standard">
                      <f:param value="#{rowsCount}"/>
                      <f:param value="#{displayedRowsCountVar}"/>
                      <f:param value="#{firstRowIndex}"/>
                      <f:param value="#{lastRowIndex}"/>
                      <f:param value="#{pageIndex}"/>
                      <f:param value="#{pageCount}"/>
                    </h:outputFormat>
                  </t:dataScroller>
                </h:panelGrid>
              </t:buffer>
              
              <h:outputText value="#{table}" escape="false"/>
             
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Registrar Consulta Sin Factura" id="fieldRegistroCirugia" styleClass="fieldset">
            <h:panelGroup id="panelRegistroCirugias">
              <a4j:region renderRegionOnly="false">
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelCirugias"
                             rowClasses="labelText,labelTextInfo">
                  <h:outputText value="Intervención(es) Propuesta(s)" styleClass="labelTextOblig"/>
                  <h:outputText/>
                   <h:selectOneMenu required="true" 
                                    id="mnuAreaIve"
                                    value="#{registrarConsultaSinFacturaBean.servicioIve}">
                <f:selectItems value="#{registrarConsultaSinFacturaBean.listServiciosIve}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuAreaIve" styleClass="errorMessage"/>
              </a4j:outputPanel>
                  <h:outputText/>  
                  </h:panelGrid>
             
        
                <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                             rowClasses="labelText,labelTextInfo" id="tableRegistroCirugia">
                  <h:outputText value="No. Registro"/>
                  <h:outputText value="Consulta Inicial"/>
                  <h:outputText value="Clinica" styleClass="labelTextOblig"/>
                  <h:outputText value="#{registrarConsultaSinFacturaBean.regcirpro.hrcnnumero}"/>
                  <h:outputText value="#{registrarConsultaSinFacturaBean.regcirpro.hrcnconini}"/>
                  <h:outputText value="#{registrarConsultaSinFacturaBean.clinica.cclncodigo} #{registrarConsultaSinFacturaBean.clinica.cclcnombre}"/>
                  
                  <h:outputText value="Programa" styleClass="labelTextOblig"/>
                  <h:outputText value="Donante" styleClass="labelTextOblig"/>
                   <h:outputText value="Tipo de Usuario" styleClass="labelTextOblig"/>
                 
                  <a4j:region renderRegionOnly="false">
                    <h:panelGrid columns="2">
                      <h:panelGroup>
                        <h:selectOneMenu id="mnuProgramas" onkeydown="return blockEnter(event);"
                                         value="#{registrarConsultaSinFacturaBean.regcirpro.hrcnprogra}"
                                         valueChangeListener="#{registrarConsultaSinFacturaBean.setProgramaSelect}"
                                         binding="#{registrarConsultaSinFacturaBean.itPrograma}" required="true"
                                         disabled="#{!registrarConsultaSinFacturaBean.registrarCirugia}">
                          <f:selectItems value="#{registrarConsultaSinFacturaBean.lstProgramas}"/>
                        </h:selectOneMenu>
                        <a4j:outputPanel ajaxRendered="true">
                          <t:message for="mnuProgramas" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                      </h:panelGroup>
                    </h:panelGrid>
                  </a4j:region>
                  <a4j:region renderRegionOnly="false">
                    <h:panelGrid columns="2">
                      <h:panelGroup>
                        <h:selectOneMenu id="mnuDonantes" onkeydown="return blockEnter(event);"
                                         value="#{registrarConsultaSinFacturaBean.regcirpro.hrcndonant}"
                                         valueChangeListener="#{registrarConsultaSinFacturaBean.setDonanteSelect}"
                                         binding="#{registrarConsultaSinFacturaBean.itDonante}" required="true"
                                         disabled="#{!registrarConsultaSinFacturaBean.registrarCirugia}">
                          <f:selectItems value="#{registrarConsultaSinFacturaBean.lstDonantes}"/>
                        </h:selectOneMenu>
                        <a4j:outputPanel ajaxRendered="true">
                          <t:message for="mnuDonantes" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                      </h:panelGroup>
                    </h:panelGrid>
                  </a4j:region>
                           <a4j:region renderRegionOnly="false">
                    <h:panelGrid columns="2">
                      <h:panelGroup>
                        <h:selectOneMenu id="mnuTipoUsu" onkeydown="return blockEnter(event);"
                                         value="#{registrarConsultaSinFacturaBean.regcirpro.hrcntipusu}"
                                         valueChangeListener="#{registrarConsultaSinFacturaBean.setTipusuSelect}"
                                         binding="#{registrarConsultaSinFacturaBean.itTipusu}" required="true"
                                         disabled="#{!registrarConsultaSinFacturaBean.registrarCirugia}">
                          <f:selectItems value="#{registrarConsultaSinFacturaBean.lstTipoUsuarios}"/>
                        </h:selectOneMenu>
                        <a4j:outputPanel ajaxRendered="true">
                          <t:message for="mnuTipoUsu" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                      </h:panelGroup>
                    </h:panelGrid>
                  </a4j:region>
                 
                  
                  <h:panelGroup></h:panelGroup>
                  <h:panelGroup></h:panelGroup>
                  <h:panelGroup></h:panelGroup>
                  <h:panelGroup></h:panelGroup>
                 
                  <h:panelGroup>
                    <a4j:commandButton value="Guardar"  onclick="if (!confirm(\'¿Realmente desea Registrar la Consulta \')) return false"
                                     styleClass="btn btn btn-success"
                                     action="#{registrarConsultaSinFacturaBean.agregarConsulta}"/>
                  </h:panelGroup>
                    
                  
                </h:panelGrid>
              </a4j:region>
            </h:panelGroup>
          </s:fieldset>
           <h:commandLink action="#{registrarConsultaSinFacturaBean.volver}" immediate="true">
          <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
        </h:commandLink>
        </t:panelTab>
        <a4j:outputPanel id="ajaxRegionMessagesInferior" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsInferior" showSummary="false" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
          <t:htmlTag value="br"/>
        </a4j:outputPanel>
        <t:panelTab id="panelBuscadorServicio" label="Buscar Servicio"
                    rendered="#{registrarConsultaSinFacturaBean.renderBuscadorServicio}">
          <s:fieldset legend="buscaServicios" id="fieldSetBuscarServicio" styleClass="fieldset_dataTable">
            <a4j:region id="regionServicio" renderRegionOnly="false">
              <a4j:status id="statusButton" for="regionServicio">
                <f:facet name="start">
                  <t:div id="chargingServicio" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                      <h:outputText value="Procesando..."/>
                      <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                  </t:div>
                </f:facet>
                <f:facet name="stop"/>
              </a4j:status>
              <a4j:region renderRegionOnly="false">
                <jsp:include page="/pages/clinico/comunes/buscador/buscadorServicios.jsp" flush="true"/>
              </a4j:region>
            </a4j:region>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonServicio"
                         columnClasses="panelGridBoton">
              <h:panelGroup>
                <h:commandButton value="Aceptar Servicio" styleClass="btn btn btn-success"
                                 action="#{registrarConsultaSinFacturaBean.aceptarServicio}"/>
              </h:panelGroup>
            </h:panelGrid>
            
        
          </s:fieldset>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>