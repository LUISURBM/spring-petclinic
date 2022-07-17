<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formAdministrarMedicos">
  <a4j:region id="regionAdministrarMedicos" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionAdministrarMedicos">
      <f:facet name="start">
        <t:div id="chargingAdministrarMedicos" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableInfoUbication" border="0" cellpadding="0"
                 cellspacing="0" width="100%" columnClasses="td_ubicador">
      <h:outputText value="HISTORIAS CLINICAS >> Cirugia >> Administrar Medicos por Sala "
                    id="infoUbicationModificarProgramacion"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridAgregarCirugiaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneAgregarCirugia"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabAgregarCirugia"
                    label="Administrar Medicos por Sala">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridAgregarCirugia"
                       styleClass="tabContainer">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelGridListaAnestesiologo"
                         styleClass="tabContainer">
              <s:fieldset legend="Profesionales Centro"
                          id="fieldProgramacionAnestesiologo"
                          styleClass="fieldset">
                <a4j:region renderRegionOnly="false">
                  <h:panelGrid columns="2" border="0" cellpadding="0"
                               cellspacing="0" width="100%"
                               rowClasses="labelText,labelTextInfo"
                               id="tableAnestesiologos">
                    <h:panelGroup>
                      <h:outputText id="otAnestesiologo" value="Médico"/>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="otAnestesiologo"
                                   styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                    <h:outputText value="No Sala" styleClass="labelTextOblig"/>
                    <h:panelGrid columns="2">
                      <h:panelGroup>
                        <h:selectOneMenu id="mnuAnestesiologos"
                                         value="#{administraMedicoSalaBean.programacion.id.hspnnumero}">
                          <f:selectItems value="#{administraMedicoSalaBean.lstAnestesiologos}"/>
                        </h:selectOneMenu>
                        <a4j:outputPanel ajaxRendered="true">
                          <t:message for="mnuAnestesiologos"
                                     styleClass="errorMessage"/>
                        </a4j:outputPanel>
                      </h:panelGroup>
                      <h:commandLink id="agregarAnestesiologo"
                                       action="#{administraMedicoSalaBean.aceptarMedico}">
                        <t:graphicImage border="0"
                                        url="/comun/imagenes/useradd.png"
                                        alt="Agregar"/>
                        <h:outputLabel value="Agregar"/>
                      </h:commandLink>
                    </h:panelGrid>
                    <h:selectOneMenu id="mnuSala"
                                     value="#{administraMedicoSalaBean.programacion.id.hspnsala}"
                                     required="true"
                                     styleClass="dropdown-toggle, input-medium">
                      <f:selectItems value="#{administraMedicoSalaBean.lstSalasCirugia}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuSala" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGrid>
                </a4j:region>
              </s:fieldset>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" styleClass="tabContainer"
                         id="tableAnestesiologosSelect">
              <h:panelGrid columns="1" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="tableAnestesiologoSeleccionados"
                           styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0"
                               cellspacing="0"
                               binding="#{administraMedicoSalaBean.dtAnestesiologo}"
                               value="#{administraMedicoSalaBean.lstAnestesiologosSelect}"
                               rows="10" styleClass="standard_table"
                               rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtAnestesiologo">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Codigo"/>
                      </f:facet>
                      <h:outputText value="#{item.id.hspnnumero}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Sala"/>
                      </f:facet>
                      <h:outputText value="#{item.hspcdescsala}"/>
                    </h:column>
                    
                      <h:column>
                      <f:facet name="header">
                        <h:outputText value="Clinica"/>
                      </f:facet>
                      <h:outputText value="#{item.id.hspnclinica}"/>
                    </h:column>
                    
                    
                       <h:column>
                    <f:facet name="header">
                      <h:outputText value="Eliminar"/>
                    </f:facet>      
                    <a4j:region renderRegionOnly="false">
                        <t:commandButton id="eliminarMedicoSala"  
                            value="Eliminar"  immediate="true" styleClass="btn btn bnt-danger"
                        action="#{administraMedicoSalaBean.eliminarAnestesiologo}"
                         image="/comun/imagenes/eliminarObj.gif">                      
                        </t:commandButton>               
                        </a4j:region>
                  </h:column>
                    
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1"
                               rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_anestesiologo"
                                    for="dtAnestesiologo" fastStep="10"
                                    pageCountVar="pageCount"
                                    pageIndexVar="pageIndex"
                                    styleClass="scroller" paginator="true"
                                    paginatorMaxPages="9"
                                    paginatorTableClass="paginator"
                                    renderFacetsIfSinglePage="false"
                                    paginatorActiveColumnStyle="font-weight:bold;">
                      <f:facet name="first">
                        <t:graphicImage url="/comun/imagenes/primero.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="last">
                        <t:graphicImage url="/comun/imagenes/ultimo.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="previous">
                        <t:graphicImage url="/comun/imagenes/anterior.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="next">
                        <t:graphicImage url="/comun/imagenes/siguiente.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="fastforward">
                        <t:graphicImage url="/comun/imagenes/adelante.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="fastrewind">
                        <t:graphicImage url="/comun/imagenes/atras.gif"
                                        border="0"/>
                      </f:facet>
                    </t:dataScroller>
                  </h:panelGrid>
                </t:buffer>
                <h:outputText value="#{table}" escape="false"/>
              </h:panelGrid>
            </h:panelGrid>
          </h:panelGrid>
  
          <h:panelGrid></h:panelGrid>
          <h:panelGrid>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionAgregarCirugiaMsg"
                               ajaxRendered="true">
                <t:messages id="msgAgregarCirugiaMsg" showSummary="true"
                            errorClass="error" globalOnly="true" layout="table"
                            infoClass="informacion"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>