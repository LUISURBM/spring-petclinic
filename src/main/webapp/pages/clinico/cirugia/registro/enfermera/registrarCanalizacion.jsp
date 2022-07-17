<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridIngresoCirugiaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
        <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneCanalizacion"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabCanalizacion" label="Canalización Vena ">
        
         <s:fieldset legend="#{registrarCanalizacionBean.legendServicio}" id="fieldCirugiasCanalizacion"
                        styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelCirugiasCanalizacion"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Intervención(es)"/>
                 <h:outputText/>
    
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0"
                           rendered="#{not empty registrarCanalizacionBean.lstCirugias}"
                           cellspacing="0" width="100%"
                           id="tableCirugiasCanalizacion" styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0"
                               cellspacing="0"
                               binding="#{registrarCanalizacionBean.dtCirugias}"
                               value="#{registrarCanalizacionBean.lstCirugias}"
                               rows="10" styleClass="standard_table"
                               rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtCirugiasProgramadasCanalizacion">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Codigo"/>
                      </f:facet>
                      <h:outputText value="#{item.csvccodigo}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Nombre"/>
                      </f:facet>
                      <h:outputText value="#{item.csvcnombre}"/>
                    </h:column> 
                       <h:column>
                      <f:facet name="header">
                        <h:outputText value="Estado"/>
                      </f:facet>
                      <h:outputText value="#{item.csvcestado}"/>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1"
                               rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_1" for="dtCirugiasProgramadasCanalizacion"
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
              </h:panelGrid>.
            </s:fieldset>
        
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridCanalizacion"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Canalizacion Vena"
                          styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuCanalizacion" immediate="true"
                                required="true"
                                value="#{registrarCanalizacionBean.canalizacion.hcvecanalizaci}"
                                valueChangeListener="#{registrarCanalizacionBean.setCanaliza}">
                <f:selectItems value="#{registrarCanalizacionBean.lstOpciones}"/>
                <a4j:support id="supportmnuCanalizacion" event="onclick"
                             immediate="true"
                             action="#{registrarCanalizacionBean.changeCanalizacion}"
                             reRender="panelTabCanalizacion">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuCanalizacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:selectOneRadio>
            </a4j:region>
          </h:panelGrid>
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridAsepsia"
                       rendered="#{registrarCanalizacionBean.mostrarCanalizacion}"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Asepsia y antisepsia zona a canalizar"/>
            <h:outputText value="Miembro Superior"/>
            <h:outputText value="Localización"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuAsepsia" immediate="true" required="true"
                                value="#{registrarCanalizacionBean.canalizacion.hcveasepsia}"
                                valueChangeListener="#{registrarCanalizacionBean.setHcveasepsia}">
                <f:selectItems value="#{registrarCanalizacionBean.lstOpciones}"/>
                <a4j:support id="supportmnuAsepsia" event="onclick"
                             immediate="true"
                             action="#{registrarCanalizacionBean.changeAsepsia}"
                             reRender="panelTabbedPaneCanalizacion">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAsepsia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:selectOneRadio>
            </a4j:region>
            <h:selectOneRadio id="mnuMiembroSuperior" immediate="true"
                              required="true"
                              value="#{registrarCanalizacionBean.canalizacion.hcvcmiembsuper}">
              <f:selectItems value="#{registrarCanalizacionBean.lstMiembroSuperior}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuMiembroSuperior" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:selectOneRadio>
            <h:selectOneRadio id="mnuLocalizacion" immediate="true"
                              required="true"
                              value="#{registrarCanalizacionBean.canalizacion.hcvczonacanali}">
              <f:selectItems value="#{registrarCanalizacionBean.lstLocalizacion}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuLocalizacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:selectOneRadio>
            <h:outputText value="Tipo de Cateter"/>
            <h:panelGroup id = "TextCalibre">
              <h:outputText value="Calibre"
                            rendered="#{registrarCanalizacionBean.mostrarCalibre}"/>
            </h:panelGroup>
            <h:outputText value=""/>
            <a4j:region renderRegionOnly="false">
            <h:selectOneRadio id="mnuTipoCateter" immediate="true"
                              required="true"
                              value="#{registrarCanalizacionBean.canalizacion.hcvctipocatete}"
                              valueChangeListener="#{registrarCanalizacionBean.setHcvctipocatete}">
              <f:selectItems value="#{registrarCanalizacionBean.lstTipoCateter}"/>
              <a4j:support id="supportTipoCateter" event="onclick"
                           immediate="true"
                           action="#{registrarCanalizacionBean.changeCateter}"
                           reRender="inputCalibre,TextCalibre">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuTipoCateter" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:selectOneRadio>
            </a4j:region>
            <h:panelGroup id = "inputCalibre">
              <h:inputText id="itCalibre" maxlength="3" style="width:50px"
                           rendered="#{registrarCanalizacionBean.mostrarCalibre}"
                           value="#{registrarCanalizacionBean.canalizacion.hcvncalibre}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itCalibre" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelBotonesCanalizacion"
                       columnClasses="panelGridBotones">
            <h:panelGroup>
              <h:commandButton value="Aceptar" styleClass="btn btn btn-success"
                               action="#{registrarCanalizacionBean.registrarCanalizacion}"/>
            </h:panelGroup>
          </h:panelGrid>
          <h:panelGrid></h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
</h:panelGrid>