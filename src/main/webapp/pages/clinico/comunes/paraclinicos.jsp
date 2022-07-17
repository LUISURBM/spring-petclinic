<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAntecedentesGeneralesTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
 <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneAntecedentes"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabAntecedentes" label="Paraclinicos ">
              <s:fieldset legend="Paraclinicos" id="fieldAntecedentes"
                      styleClass="fieldset">
                      
        
            
              
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelAntecedentes"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Tiene Paraclinicos Nuevos"
                            styleClass="labelTextOblig"/>
             <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuAntecedentes" immediate="true"
                                required="true" onkeydown="return blockEnter(event);"
                                value="#{paraclinicosUsuarioBean.nuevosParaclinicos}"
                                valueChangeListener="#{paraclinicosUsuarioBean.setNuevosParaclinicos}">
                <f:selectItems value="#{paraclinicosUsuarioBean.lstOpciones}"/>
                <a4j:support id="supportmnuAntecedentes" event="onclick"
                             
                             action="#{paraclinicosUsuarioBean.changeParaclinicos}"
                             reRender="tableContentTabsAntecedentes">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentes" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:selectOneRadio>
              </a4j:region>
            </h:panelGrid>
          </s:fieldset>
        

          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="tableContentTabsAntecedentes"
                       styleClass="tabContainer">
                       
         <s:fieldset legend="Seleccion de Paraclinico" id="fieldAntecedentesSeleccion"
                      styleClass="fieldset"   rendered="#{paraclinicosUsuarioBean.mostrarParaclinicos}">
            <a4j:region id="regionAntece" renderRegionOnly="false">
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelDatosAntecedentes"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Nombre Paraclinico"
                              styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:panelGroup>
                  <h:inputText id="itNombreParaclinicoAnt" onkeydown="return blockEnter(event);"
                                   value="#{paraclinicosUsuarioBean.codigoParaclinico}"/>
                   
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNombreParaclinicoAnt" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=""/>
                 <h:outputText value="Descripción" styleClass="labelTextOblig"/>
                 <h:outputText value=""/>
                <h:panelGroup>
                  <h:inputTextarea id="textAnt"
                                   value="#{paraclinicosUsuarioBean.paraclinico}"
                                   style="width:600px">
                    <f:validateLength maximum="4000" minimum = "3"/>
                </h:inputTextarea>        
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="textAnt" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=""/>
              </h:panelGrid>
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelBotonAgregar"
                           columnClasses="panelGridBotones">
                <h:panelGroup>
                      <a4j:commandButton value="Agregar" styleClass="btn btn btn-success"
                                     action="#{paraclinicosUsuarioBean.agregarParaclinico}"
                                     reRender="tableContentTabsAntecedentes"/>
                </h:panelGroup>
              </h:panelGrid>
            </a4j:region>
            <s:fieldset legend="Lista Paraclinicos" id="fieldAntecedentesLista"   rendered="#{not empty paraclinicosUsuarioBean.lstParaclinicosConsulta}"
                        styleClass="fieldset">
              <h:panelGrid columns="1" border="0" cellpadding="0"
                           
                           cellspacing="0" width="100%" id="tableContentTabs"
                           styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0"
                               binding="#{paraclinicosUsuarioBean.dtParaclinico}"
                               cellspacing="0"
                                value="#{paraclinicosUsuarioBean.lstParaclinicosConsulta}"
                               rows="10" styleClass="standard_table"
                               rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtParaclinico">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Nombre Paraclinico"/>
                      </f:facet>
                      <h:outputText value="#{item.hpgcnombpara}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Descripcion Paraclinico"/>
                      </f:facet>
                      <h:outputText value="#{item.hpgtdescripcio}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Eliminar"/>
                      </f:facet>
                      <h:commandLink id="eliminar" immediate="true"
                                     action="#{paraclinicosUsuarioBean.eliminarParaclinico}">
                        <t:graphicImage border="0" alt="" 
                                        url="/comun/imagenes/editar.gif"/>
                      </h:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1"
                               rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_1" for="dtParaclinico"
                                    fastStep="10" pageCountVar="pageCount"
                                    pageIndexVar="pageIndex"
                                    styleClass="scroller" paginator="true"
                                    immediate="true" paginatorMaxPages="9"
                                    paginatorTableClass="paginator"
                                    renderFacetsIfSinglePage="false"
                                    paginatorActiveColumnStyle="font-weight:bold;">
                      <f:facet name="first">
                        <t:graphicImage alt=""  url="/comun/imagenes/primero.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="last">
                        <t:graphicImage alt=""  url="/comun/imagenes/ultimo.gif"
                                        border="0"/>
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
                        <t:graphicImage alt=""  url="/comun/imagenes/atras.gif"
                                        border="0"/>
                      </f:facet>
                    </t:dataScroller>
                  </h:panelGrid>
                </t:buffer>
                    <h:outputText value="#{tableScroller}" escape="false"/>
                  <h:outputText value="#{table}" escape="false"/>
                  <h:outputText value="#{tableScroller}" escape="false"/>
              </h:panelGrid>
            </s:fieldset>
   
              </s:fieldset>
                <a4j:region renderRegionOnly="false">
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelBotonModificar"
                           columnClasses="panelGridBotones">
                <h:panelGroup>
                  <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                                   action="#{paraclinicosUsuarioBean.aceptar}">
                    <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>
                </h:panelGroup>
              </h:panelGrid>
            </a4j:region>
          </h:panelGrid>
          <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMensajes" ajaxRendered="true">
                   <t:messages id="msgInf" showSummary="true" errorClass="error"
                              globalOnly="true" layout="table"
                              infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
        <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>