<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridIngresoCirugiaTab"
             styleClass="tabContainer">
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridIngresoEnfermeriaTab"
               styleClass="tabContainer">
    <jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridNotaEnfermeriaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneNotaEnfermeria" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         selectedIndex="#{registrarNotaEnfermeriaBean.selectedIndex}"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabNotaEnfermeria" label="#{registrarNotaEnfermeriaBean.labelText}"
                    disabled="#{registrarNotaEnfermeriaBean.renderPlantilla}">
          <s:fieldset legend="#{registrarNotaEnfermeriaBean.legendServicio}" id="fieldCirugiasNotaEnfermeria"
                      styleClass="fieldset">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelCirugiasNotaEnfermeria" rowClasses="labelText,labelTextInfo">
              <h:outputText value="#{registrarNotaEnfermeriaBean.legendTablaServicio}"/>
              <h:outputText/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0"
                         rendered="#{not empty registrarNotaEnfermeriaBean.lstCirugias}" cellspacing="0" width="100%"
                         id="tableCirugiasProgramadasNotaEnfermeria" styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                             binding="#{registrarNotaEnfermeriaBean.dtCirugias}"
                             value="#{registrarNotaEnfermeriaBean.lstCirugias}" rows="10" styleClass="standard_table"
                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                             id="dtCirugiasProgramadasNotasEnfermeria">
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
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_1" for="dtCirugiasProgramadasNotasEnfermeria" fastStep="10"
                                  pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller"
                                  paginator="true" immediate="true" paginatorMaxPages="9"
                                  paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
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
                </h:panelGrid>
              </t:buffer>
              <h:outputText value="#{tableScroller}" escape="false"/>
              <h:outputText value="#{table}" escape="false"/>
              <h:outputText value="#{tableScroller}" escape="false"/>
            </h:panelGrid>
          </s:fieldset>
          <!-- Cancelaci�n de la cirug�a -->
          <s:fieldset legend="Cancelar Cirug�a" id="fieldCancela" styleClass="fieldset"
                      rendered="#{!registrarNotaEnfermeriaBean.notaEnfeProce}">
            <a4j:region renderRegionOnly="false">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" id="panelBotonCacelar" width="50%">
                <h:outputText value="Desea Cancelar la Cirug�a" styleClass="labelTextOblig"/>
                <h:outputText/>
                <h:panelGroup id="panelTextMotivoCancelacion">
                  <h:outputText value="Motivo Cancelaci�n" styleClass="labelTextOblig"
                                rendered="#{registrarNotaEnfermeriaBean.renderCancelar}"/>
                </h:panelGroup>
                <h:outputText/>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="menuCancela" required="true" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      value="#{registrarNotaEnfermeriaBean.radioCancelar}"
                                      valueChangeListener="#{registrarNotaEnfermeriaBean.listenCancelaCirugia}">
                      <f:selectItems value="#{registrarNotaEnfermeriaBean.lstOpciones}"/>
                      <a4j:support id="supportCancela" event="onclick"
                                   action="#{registrarNotaEnfermeriaBean.muestraCancelar}"
                                   reRender="panelTabNotaEnfermeria">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                  </h:panelGroup>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="menuCancela" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelGridMotivoCancelar">
                  <h:selectOneMenu id="mnuMotivoCancelar" value="#{registrarNotaEnfermeriaBean.cirugia.hcpcmotivanula}"
                                   required="true" rendered="#{registrarNotaEnfermeriaBean.renderCancelar}">
                    <f:selectItem itemValue="" itemLabel="Seleccione una opci�n"/>
                    <f:selectItem itemValue="1" itemLabel="ATRIBUIBLE A LA INSTITUCION"/>
                    <f:selectItem itemValue="2" itemLabel="ATRIBUIBLE AL USUARIO"/>
                    <f:selectItem itemValue="3" itemLabel="POR ORDEN MEDICA"/>
                  </h:selectOneMenu>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuMotivoCancelar" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="Observaciones" styleClass="labelTextOblig"
                              rendered="#{registrarNotaEnfermeriaBean.renderCancelar}"/>
                <h:outputText/>
                <h:outputText/>
                <h:outputText/>
                <h:inputTextarea id="textAreaObservacionesCancelacion"
                                 value="#{registrarNotaEnfermeriaBean.cirugia.hcpcobseranula}" style="width:400px"
                                 rendered="#{registrarNotaEnfermeriaBean.renderCancelar}">
                  <f:validateLength maximum="200"/>
                </h:inputTextarea>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="textAreaObservacionesCancelacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText/>
                <h:outputText/>
                <h:outputText/>
                <h:panelGroup>
                  <h:commandButton value="Cancelar Cirug�a"
                                   onclick="if (!confirm(\'�Realmente desea cancelar la cirugia \')) return false"
                                   action="#{registrarNotaEnfermeriaBean.cancelarCirugia}"
                                   rendered="#{registrarNotaEnfermeriaBean.renderCancelar}"
                                   styleClass="btn btn btn-danger"/>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText/>
                <h:outputText/>
                <h:outputText/>
              </h:panelGrid>
            </a4j:region>
          </s:fieldset>
          <!-- fin cancelacion cirugia -->
          <s:fieldset legend="Historial Venas Canalizadas" id="fieldVenasCanalizadas" styleClass="fieldset"
                      rendered="#{not empty registrarNotaEnfermeriaBean.lstHistorialCanalizacion && !registrarNotaEnfermeriaBean.esSalida}">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableVenasCanalizadas"
                         styleClass="tabContainer">
              <t:buffer into="#{table_suspender}">
                <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                             binding="#{registrarNotaEnfermeriaBean.dtHistorialCanalizacion}"
                             value="#{registrarNotaEnfermeriaBean.lstHistorialCanalizacion}" rows="10"
                             styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                             footerClass="paginacion" id="dtSuspender">
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Miembro Superior"/>
                    </f:facet>
                    <h:outputText value="#{item.hcvcdescmiembr}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Localizaci�n"/>
                    </f:facet>
                    <h:outputText value="#{item.hcvcdesclocali}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Tipo de Cateter"/>
                    </f:facet>
                    <h:outputText value="#{item.hcvcdesccatete}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Calibre(G.)"/>
                    </f:facet>
                    <h:outputText value="#{item.hcvncalibre}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="N�mero de intentos de venopunci�n"/>
                    </f:facet>
                    <h:outputText value="#{item.hcvnnumerinten}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Estado"/>
                    </f:facet>
                    <h:outputText value="#{item.hcvcestado}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Suspender"/>
                    </f:facet>
                    <h:selectBooleanCheckbox id="checkSuspender" disabled="#{!item.hcvbrendersusp}"
                                             onkeydown="return blockEnter(event);" value="#{item.hcvbsuspender}"></h:selectBooleanCheckbox>
                  </h:column>
                </h:dataTable>
              </t:buffer>
              <t:buffer into="#{tableScroller_suspender}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_suspender" for="dtSuspender" fastStep="10" pageCountVar="pageCount"
                                  pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                  paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
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
                </h:panelGrid>
              </t:buffer>
              <h:outputText value="#{tableScroller_suspender}" escape="false"/>
              <h:outputText value="#{table_suspender}" escape="false"/>
              <h:outputText value="#{tableScroller_suspender}" escape="false"/>
            </h:panelGrid>
          </s:fieldset>
          <!-- Canalizaci�n Vena -->
          <s:fieldset legend="Canalizaci�n Vena" id="fieldCanalizacionVena" styleClass="fieldset"
                      rendered="#{!registrarNotaEnfermeriaBean.esSalida}">
            <a4j:region renderRegionOnly="false">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelGridCanalizacion" rowClasses="labelText,labelTextInfo">
                <h:panelGroup>
                  <h:outputText value="Canalizacion Vena"
                                rendered="#{empty registrarNotaEnfermeriaBean.lstHistorialCanalizacion}"/>
                  <h:outputText value="Desea canalizar vena nuevamente"
                                rendered="#{not empty registrarNotaEnfermeriaBean.lstHistorialCanalizacion}"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuCanalizacion" immediate="true"
                                    value="#{registrarNotaEnfermeriaBean.canalizacion.hcvecanalizaci}"
                                    valueChangeListener="#{registrarNotaEnfermeriaBean.setCanaliza}">
                    <f:selectItems value="#{registrarNotaEnfermeriaBean.lstOpciones}"/>
                    <a4j:support id="supportmnuCanalizacion" event="onclick"
                                 action="#{registrarNotaEnfermeriaBean.changeCanalizacion}"
                                 reRender="fieldCanalizacionVena">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuCanalizacion" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:selectOneRadio>
                </a4j:region>
              </h:panelGrid>
              <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAsepsia"
                           rendered="#{registrarNotaEnfermeriaBean.mostrarCanalizacion}"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Asepsia y antisepsia zona a canalizar" styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:outputText value="Miembro Superior" styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:outputText value="Localizaci�n" styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAsepsia" immediate="true" required="true"
                                    value="#{registrarNotaEnfermeriaBean.canalizacion.hcveasepsia}"
                                    valueChangeListener="#{registrarNotaEnfermeriaBean.setHcveasepsia}">
                    <f:selectItems value="#{registrarNotaEnfermeriaBean.lstOpciones}"/>
                    <a4j:support id="supportmnuAsepsia" event="onclick"
                                 action="#{registrarNotaEnfermeriaBean.changeAsepsia}" reRender="panelAsepsia">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuAsepsia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:selectOneRadio>
                </a4j:region>
                <h:panelGroup id="panelAsepsia">
                  <h:outputText value="Debe realizar Asepsia" style="color:blue;"
                                rendered="#{registrarNotaEnfermeriaBean.mostrarAsepsia}"/>
                </h:panelGroup>
                <h:selectOneRadio id="mnuMiembroSuperior" immediate="true" required="true"
                                  value="#{registrarNotaEnfermeriaBean.canalizacion.hcvcmiembsuper}">
                  <f:selectItems value="#{registrarNotaEnfermeriaBean.lstMiembroSuperior}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMiembroSuperior" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:selectOneRadio>
                <h:outputText value=""/>
                <h:selectOneRadio id="mnuLocalizacion" immediate="true" required="true"
                                  value="#{registrarNotaEnfermeriaBean.canalizacion.hcvczonacanali}">
                  <f:selectItems value="#{registrarNotaEnfermeriaBean.lstLocalizacion}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuLocalizacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:selectOneRadio>
                <h:outputText value=""/>
                <h:outputText value="Tipo de Cateter" styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:panelGroup id="TextCalibre">
                  <h:outputText value="Calibre (G)" styleClass="labelTextOblig"
                                rendered="#{registrarNotaEnfermeriaBean.mostrarCalibre}"/>
                </h:panelGroup>
                <h:outputText value=""/>
                <h:panelGroup id="TextNumeroIntentos">
                  <h:outputText id="itNumeroIntentos" styleClass="labelTextOblig"
                                value="N�mero de intentos de venopunci�n"/>
                </h:panelGroup>
                <h:outputText value=""/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuTipoCateter" immediate="true" required="true"
                                    value="#{registrarNotaEnfermeriaBean.canalizacion.hcvctipocatete}"
                                    valueChangeListener="#{registrarNotaEnfermeriaBean.setHcvctipocatete}">
                    <f:selectItems value="#{registrarNotaEnfermeriaBean.lstTipoCateter}"/>
                    <a4j:support id="supportTipoCateter" event="onclick" immediate="true"
                                 action="#{registrarNotaEnfermeriaBean.changeCateter}"
                                 reRender="inputCalibre,TextCalibre">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuTipoCateter" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:selectOneRadio>
                </a4j:region>
                <h:outputText value=""/>
                <h:panelGroup id="inputCalibre">
                  <h:selectOneMenu id="menuCalibreCateter"
                                   value="#{registrarNotaEnfermeriaBean.canalizacion.hcvncalibre}"
                                   rendered="#{registrarNotaEnfermeriaBean.mostrarCalibre}" immediate="true"
                                   onkeydown="return blockEnter(event);">
                    <f:selectItems value="#{registrarNotaEnfermeriaBean.listCalibre}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuCalibreCateter" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=""/>
                <h:inputText id="itNumeroIntentosCanalizacion" style="width:50px" maxlength="2"
                             value="#{registrarNotaEnfermeriaBean.canalizacion.hcvnnumerinten}" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="menuCalibreCateter" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelBotonAgregarCanalizacion" columnClasses="panelGridBotones">
                <h:panelGroup>
                  <t:htmlTag value="br"/>
                  <a4j:commandButton value="Agregar" rendered="#{registrarNotaEnfermeriaBean.mostrarCanalizacion}"
                                     styleClass="btn btn btn-success"
                                     action="#{registrarNotaEnfermeriaBean.agregarCanalizacion}"
                                     reRender="fieldCanalizacionVena"/>
                </h:panelGroup>
              </h:panelGrid>
            </a4j:region>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="tableCanalizacionSeleccionada"
                         rendered="#{not empty registrarNotaEnfermeriaBean.lstCanalizacionSelect}"
                         styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                             binding="#{registrarNotaEnfermeriaBean.dtCanalizacion}"
                             value="#{registrarNotaEnfermeriaBean.lstCanalizacionSelect}" rows="10"
                             styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                             footerClass="paginacion" id="dtCanalizacion">
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Miembro Superior"/>
                    </f:facet>
                    <h:outputText value="#{item.hcvcdescmiembr}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Localizaci�n"/>
                    </f:facet>
                    <h:outputText value="#{item.hcvcdesclocali}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Tipo de Cateter"/>
                    </f:facet>
                    <h:outputText value="#{item.hcvcdesccatete}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Calibre(G.)"/>
                    </f:facet>
                    <h:outputText value="#{item.hcvncalibre}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="N�mero de intentos de venopunci�n"/>
                    </f:facet>
                    <h:outputText value="#{item.hcvnnumerinten}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Eliminar"/>
                    </f:facet>
                    <a4j:commandLink id="eliminar" immediate="true"
                                     onclick="if(!confirm(\' Desea remover este registro ? \')){ return false; }"
                                     action="#{registrarNotaEnfermeriaBean.eliminarCanalizacion}"
                                     reRender="fieldCanalizacionVena">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/quitar.gif"/>
                    </a4j:commandLink>
                  </h:column>
                </h:dataTable>
              </t:buffer>
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_4" for="dtCanalizacion" fastStep="10" pageCountVar="pageCount"
                                  pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                  paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
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
                </h:panelGrid>
              </t:buffer>
              <h:outputText value="#{tableScroller}" escape="false"/>
              <h:outputText value="#{table}" escape="false"/>
              <h:outputText value="#{tableScroller}" escape="false"/>
            </h:panelGrid>
          </s:fieldset>
          <!-- informacion de diu -->
          <s:fieldset legend="Informaci�n DIU" id="fieldInformacionDIU" styleClass="fieldset"
                      rendered="#{registrarNotaEnfermeriaBean.renderTieneDIU && !registrarNotaEnfermeriaBean.notaEnfeProce">
            <a4j:region renderRegionOnly="false">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelInformacionDIU"
                           rowClasses="labelText,labelTextInfo">
                <h:panelGroup>
                  <h:outputText value="El paciente NO tiene DIU"
                                rendered="#{!registrarNotaEnfermeriaBean.renderMensajeTieneDIU}" style="color:blue;"/>
                  <h:outputText value="El paciente tiene DIU"
                                rendered="#{registrarNotaEnfermeriaBean.renderMensajeTieneDIU}" style="color:red;"/>
                </h:panelGroup>
              </h:panelGrid>
            </a4j:region>
          </s:fieldset>
          <!-- Resultado de la prueba de embarazo-->
          <s:fieldset legend="Resultado Prueba de Embarazo" id="fieldInformacionPruebaEmbarazo" styleClass="fieldset"
                      rendered="#{registrarNotaEnfermeriaBean.renderPruebaEmbarazo && !registrarNotaEnfermeriaBean.esIngreso}">
            <a4j:region renderRegionOnly="false">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelInformacionPruebaEmbarazo" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Fecha de la Toma" styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:outputText value="Resultado Prueba: " styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <a4j:region renderRegionOnly="false">
                  <t:inputCalendar id="fechaInicialPrueba" monthYearRowClass="yearMonthHeader"
                                   title="Formato: dd/mm/yyyy" styleClass="input-small" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" required="true"
                                   value="#{registrarNotaEnfermeriaBean.fechaEmbarazo}"
                                   valueChangeListener="#{registrarNotaEnfermeriaBean.setFechaActual}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top">
                    <f:validator validatorId="dateValidatorEmbarazoCirugia"/>
                    <a4j:support id="supportFechaInicialPrueba" event="onchange"
                                 reRender="fieldInformacionPruebaEmbarazo">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </t:inputCalendar>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaInicialPrueba" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:selectOneRadio id="mnuResultadoPrueba" immediate="true" required="true"
                                  value="#{registrarNotaEnfermeriaBean.hiecresulpruemb}"
                                  valueChangeListener="#{registrarNotaEnfermeriaBean.setHiecresulpruemb}">
                  <f:selectItems value="#{registrarNotaEnfermeriaBean.lstOpcionesEmbarazo}"/>
                  <a4j:support id="supportmnuResultadoPrueba" event="onclick" immediate="true" reRender="panelMedias"
                               action="#{registrarNotaEnfermeriaBean.changeEmbarazo}">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuResultadoPrueba" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </a4j:region>
          </s:fieldset>
          <!-- COMIENZA ESCALA DE DOLOR -->
          <s:fieldset legend="Escala de Dolor" id="fieldEscalaDolor" styleClass="fieldset">
            <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelEscalaDolor"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Refiere dolor" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:panelGroup id="panelEscala">
                <h:outputText value="Escala de Dolor" styleClass="labelTextOblig"
                              rendered="#{registrarNotaEnfermeriaBean.renderDolor}"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:panelGroup id="itTextDuracionDolor">
                <h:outputText value="Duraci�n del dolor" rendered="#{registrarNotaEnfermeriaBean.renderDolor}"
                              styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:panelGroup id="itTextUnidadMedida">
                <h:outputText value="Unidad de Medida" rendered="#{registrarNotaEnfermeriaBean.renderDolor}"
                              styleClass="labelTextOblig"/>
              </h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectOneRadio id="radioEscalaDolor" required="true" immediate="true"
                                    onkeydown="return blockEnter(event);"
                                    value="#{registrarNotaEnfermeriaBean.nota.hnecrefiedolor}"
                                    valueChangeListener="#{registrarNotaEnfermeriaBean.listenDolorCirugia}">
                    <f:selectItems value="#{registrarNotaEnfermeriaBean.lstOpciones}"/>
                    <a4j:support id="supportradioEscalaDolor" event="onclick" reRender="fieldEscalaDolor">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  
                   <a4j:outputPanel ajaxRendered="true">
                  <t:message for="radioEscalaDolor" styleClass="errorMessage"/>
                </a4j:outputPanel>
                  
                </h:panelGroup>
              </a4j:region>
              <h:outputText value=""/>
              <h:panelGroup id="panelRenderDolor" rendered="#{registrarNotaEnfermeriaBean.renderDolor}">
                <h:selectOneRadio id="selectEscalaDolor" layout="lineDirection" immediate="true"
                                  value="#{registrarNotaEnfermeriaBean.nota.hnenescaladolo}" style="margin-left:35px">
                  <f:selectItems value="#{registrarNotaEnfermeriaBean.listEscala}"/>
                  <a4j:support event="onchange" status="statusButton"/>
                </h:selectOneRadio>
                <h:graphicImage url="/comun/imagenes/escalaDolor2.png" style="width:650px"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="selectEscalaDolor" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:panelGroup>
                <h:inputText id="menuDuraDolor" maxlength="2" size="2" style="width:30px"
                             rendered="#{registrarNotaEnfermeriaBean.renderDolor}" immediate="true"
                             value="#{registrarNotaEnfermeriaBean.nota.hnenduradolor}"
                             onkeypress="return justNumbers(event);">
                  <a4j:support event="onchange" status="statusButton"/>
                </h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="menuDuraDolor" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneMenu id="menuTiempo3" styleClass="input-small labelTextOblig" immediate="true"
                                 rendered="#{registrarNotaEnfermeriaBean.renderDolor}"
                                 value="#{registrarNotaEnfermeriaBean.nota.hnecdudointen}">
                  <f:selectItem itemLabel="Seleccione una opci�n ..." itemValue=""/>
                  <f:selectItem itemLabel="Minuto(s)" itemValue="MI"/>
                  <f:selectItem itemLabel="Hora(s)" itemValue="H"/>
                  <f:selectItem itemLabel="D�a(s)" itemValue="D"/>
                  <f:selectItem itemLabel="Semana(s)" itemValue="S"/>
                  <a4j:support event="onchange" status="statusButton"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="menuTiempo3" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </s:fieldset>
          <!--FIN DE LA ESCALA DE DOLOR -->
          <!-- COMIENZA REFERENCIA DEL PACIENTE -->
          <s:fieldset legend="Referencia del paciente" id="fieldReferencia" styleClass="fieldset">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelReferencia"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="�Referencia paciente?" styleClass="labelTextOblig"/>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectOneRadio id="radioReferencia" required="true" immediate="true"
                                    onkeydown="return blockEnter(event);"
                                    value="#{registrarNotaEnfermeriaBean.referenciaPaciente.hrpcrefepaci}"
                                    valueChangeListener="#{registrarNotaEnfermeriaBean.setHrpcrefepaci}">
                    <f:selectItems value="#{registrarNotaEnfermeriaBean.lstOpciones}"/>
                    <a4j:support id="supportRadioReferencia" event="onclick" reRender="fieldReferencia"
                                 action="#{registrarNotaEnfermeriaBean.changeReferenciaPaciente}">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </h:panelGroup>
              </a4j:region>
            </h:panelGrid>
            <spacer height="80"/>
            <s:fieldset legend="Datos IPS Receptora" id="fieldIPSRecep" styleClass="fieldset" rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelIpsReceptora"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Instituci�n Receptora" 
                              rendered="#{registrarNotaEnfermeriaBean.renderReferencia}"/>
                <h:panelGroup>
                  <a4j:region renderRegionOnly="false">
                    <h:inputTextarea id="menuInstRecep" style="width:250px"
                                     rendered="#{registrarNotaEnfermeriaBean.renderReferencia}" immediate="true"
                                     value="#{registrarNotaEnfermeriaBean.referenciaPaciente.hrpcinstrece}">
                      <a4j:support event="onchange" status="statusButton"/>
                    </h:inputTextarea>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
                      <t:message for="menuInstRecep" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </a4j:region>
                </h:panelGroup>
                <h:outputText value="Hora de confirmacion de la remisi�n" styleClass="labelTextOblig"
                              rendered="#{registrarNotaEnfermeriaBean.renderReferencia}"/>
                <h:panelGroup>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuHoraConfirmRemi"
                                     value="#{registrarNotaEnfermeriaBean.referenciaPaciente.hrpchoraconf}"
                                     styleClass="input-small"
                                     required="true"
                                     rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
                      <f:selectItems value="#{registrarNotaEnfermeriaBean.listHora}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
                      <t:message for="mnuHoraConfirmRemi" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value=" : Horas " rendered="#{registrarNotaEnfermeriaBean.renderReferencia}"/>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuMinutosConfirmRemi"
                                     value="#{registrarNotaEnfermeriaBean.referenciaPaciente.hrpcminuconf}"
                                     required="true" styleClass="dropdown-toggle, input-small"
                                     rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
                      <f:selectItems value="#{registrarNotaEnfermeriaBean.lstMinutos}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
                      <t:message for="mnuMinutosConfirmRemi" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value=" Minutos" rendered="#{registrarNotaEnfermeriaBean.renderReferencia}"/>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            <spacer height="80"/>
            <s:fieldset legend="Datos Transporte Ambulatorio" id="fieldTranAmbu" styleClass="fieldset" rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelTranAmbu"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Prestador de ambulancia"
                              rendered="#{registrarNotaEnfermeriaBean.renderReferencia}"/>
                <h:panelGroup>
                  <a4j:region renderRegionOnly="false">
                    <h:inputTextarea id="menuPresAmbu" style="width:250px"
                                     rendered="#{registrarNotaEnfermeriaBean.renderReferencia}" immediate="true"
                                     value="#{registrarNotaEnfermeriaBean.referenciaPaciente.hrpcpresambu}">
                      <a4j:support event="onchange" status="statusButton"/>
                    </h:inputTextarea>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
                      <t:message for="menuPresAmbu" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </a4j:region>
                </h:panelGroup>
                <h:outputText value="Tipo de Ambulancia" styleClass="labelTextOblig"
                              rendered="#{registrarNotaEnfermeriaBean.renderReferencia}"/>
                <h:panelGroup>
                  <h:selectOneMenu id="menuTipAmbu" immediate="true"
                                   rendered="#{registrarNotaEnfermeriaBean.renderReferencia}"
                                   value="#{registrarNotaEnfermeriaBean.referenciaPaciente.hrpctipoambu}">
                    <f:selectItem itemLabel="Seleccione una opci�n ..." itemValue=""/>
                    <f:selectItem itemLabel="B�sica" itemValue="BA"/>
                    <f:selectItem itemLabel="Medicalizada" itemValue="ME"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuTipAmbu" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Hora de llegada de la ambulancia a Profamilia" styleClass="labelTextOblig"
                              rendered="#{registrarNotaEnfermeriaBean.renderReferencia}"/>
                <h:panelGroup>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuHoraAmbuProfa"
                                     value="#{registrarNotaEnfermeriaBean.referenciaPaciente.hrpchorallega}"
                                     styleClass="input-small"
                                     required="true"
                                     rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
                      <f:selectItems value="#{registrarNotaEnfermeriaBean.listHora}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
                      <t:message for="mnuHoraAmbuProfa" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value=" : Horas " rendered="#{registrarNotaEnfermeriaBean.renderReferencia}"/>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuMinutosAmbuProfa"
                                     value="#{registrarNotaEnfermeriaBean.referenciaPaciente.hrpcminullega}"
                                     required="true" styleClass="dropdown-toggle, input-small"
                                     rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
                      <f:selectItems value="#{registrarNotaEnfermeriaBean.lstMinutos}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
                      <t:message for="mnuMinutosAmbuProfa" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value=" Minutos" rendered="#{registrarNotaEnfermeriaBean.renderReferencia}"/>
                </h:panelGroup>
                <h:outputText value="Tripulante de ambulancia que recibe el paciente"
                              rendered="#{registrarNotaEnfermeriaBean.renderReferencia}"/>
                <h:panelGroup>
                  <a4j:region renderRegionOnly="false">
                    <h:inputTextarea id="menuTripulante" style="width:250px"
                                     rendered="#{registrarNotaEnfermeriaBean.renderReferencia}" immediate="true"
                                     value="#{registrarNotaEnfermeriaBean.referenciaPaciente.hrpctripurecib}">
                      <a4j:support event="onchange" status="statusButton"/>
                    </h:inputTextarea>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
                      <t:message for="menuTripulante" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </a4j:region>
                </h:panelGroup>
                <h:outputText value="Hora de salida del Paciente" styleClass="labelTextOblig"
                              rendered="#{registrarNotaEnfermeriaBean.renderReferencia}"/>
                <h:panelGroup>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuHoraSalidaPaciente"
                                     value="#{registrarNotaEnfermeriaBean.referenciaPaciente.hrpchorasali}"
                                     styleClass="input-small"
                                     required="true"
                                     rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
                      <f:selectItems value="#{registrarNotaEnfermeriaBean.listHora}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
                      <t:message for="mnuHoraSalidaPaciente" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value=" : Horas " rendered="#{registrarNotaEnfermeriaBean.renderReferencia}"/>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuMinutosSalidaPaciente"
                                     value="#{registrarNotaEnfermeriaBean.referenciaPaciente.hrpcminusali}"
                                     required="true" styleClass="dropdown-toggle, input-small"
                                     rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
                      <f:selectItems value="#{registrarNotaEnfermeriaBean.lstMinutos}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
                      <t:message for="mnuMinutosSalidaPaciente" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value=" Minutos" rendered="#{registrarNotaEnfermeriaBean.renderReferencia}"/>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            <spacer height="80"/>
            <s:fieldset legend="Seguimiento" id="fieldSeguimiento" styleClass="fieldset" rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelSegumiento"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Hora de ingreso del paciente a la IPS receptora" styleClass="labelTextOblig"
                              rendered="#{registrarNotaEnfermeriaBean.renderReferencia}"/>
                <h:panelGroup>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuHoraIngreIPS"
                                     value="#{registrarNotaEnfermeriaBean.referenciaPaciente.hrpchoraingr}"
                                     rendered="#{registrarNotaEnfermeriaBean.renderReferencia}"
                                     required="true"
                                     styleClass="dropdown-toggle, input-small">
                      <f:selectItems value="#{registrarNotaEnfermeriaBean.listHora}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
                      <t:message for="mnuHoraIngreIPS" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value=" : Horas " rendered="#{registrarNotaEnfermeriaBean.renderReferencia}"/>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuMinutosIngreIPS"
                                     value="#{registrarNotaEnfermeriaBean.referenciaPaciente.hrpcminuingr}"
                                     required="true" styleClass="dropdown-toggle, input-small"
                                     rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
                      <f:selectItems value="#{registrarNotaEnfermeriaBean.lstMinutos}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
                      <t:message for="mnuMinutosIngreIPS" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value=" Minutos" rendered="#{registrarNotaEnfermeriaBean.renderReferencia}"/>
                </h:panelGroup>
                <h:outputText value="Nombre del funcionario que gestion� la remisi�n"
                              rendered="#{registrarNotaEnfermeriaBean.renderReferencia}"/>
                <h:panelGroup>
                  <a4j:region renderRegionOnly="false">
                    <h:inputTextarea id="menuNomFunGes" style="width:250px"
                                     rendered="#{registrarNotaEnfermeriaBean.renderReferencia}" immediate="true"
                                     value="#{registrarNotaEnfermeriaBean.referenciaPaciente.hrpcnomfunges}">
                      <a4j:support event="onchange" status="statusButton"/>
                    </h:inputTextarea>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarNotaEnfermeriaBean.renderReferencia}">
                      <t:message for="menuNomFunGes" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </a4j:region>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
          </s:fieldset>
          <!--FIN DE LA ESCALA DE DOLOR -->
          <!-- AQUI EMPIEZA LA NOTA DE ENFERMERIA -->
          <a4j:region renderRegionOnly="false">
          <a4j:commandLink action="#{registrarNotaEnfermeriaBean.resetDatos}" immediate="true"
                           rendered="#{!registrarNotaEnfermeriaBean.esIngreso}" reRender="panelGridIngresoCirugiaTab"
                           title="Registrar Nueva Nota de Enfermeria">
            <t:graphicImage alt="Registrar Nueva Nota de Enfermeria(a)" title="Registrar Nueva Nota de Enfermeria"
                            border="0" url="/comun/imagenes/nuevo.jpg"/>
          </a4j:commandLink>
          </a4j:region>
          <s:fieldset legend="Nota de Enfermeria" id="fieldNotaEnfermeria" styleClass="fieldset">
            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelGridCamaEnfermeria" rowClasses="labelText,labelTextInfo">
              <h:outputText value=""/>
              <t:popup styleClass="popup" closePopupOnExitingElement="true" closePopupOnExitingPopup="true"
                       displayAtDistanceX="-155" displayAtDistanceY="10"
                       rendered="#{!registrarNotaEnfermeriaBean.notaEnfeProce}">
                <h:commandLink id="imprimirControl" immediate="true" value="Visualizar Control de enfermer�a"
                               action="#{registrarNotaEnfermeriaBean.generarControl}">
                  <t:graphicImage title="Control de Enfermeria en Cirugia" alt="" border="0"
                                  url="/comun/imagenes/pdfIcon.png"/>
                </h:commandLink>
                <f:facet name="popup">
                  <h:panelGroup>
                    <h:panelGrid columns="2" style="text-align:left;">
                      <h:outputText value="Control de Enfermeria en Cirugia"/>
                    </h:panelGrid>
                  </h:panelGroup>
                </f:facet>
              </t:popup>
              <t:popup styleClass="popup" closePopupOnExitingElement="true" closePopupOnExitingPopup="true"
                       displayAtDistanceX="-155" displayAtDistanceY="10">
                <h:commandLink id="imprimirReporte" immediate="true" value="Visualizar Notas de enfermer�a"
                               action="#{registrarNotaEnfermeriaBean.generarReporte}">
                  <t:graphicImage title="Reporte Notas de Enfermeria Anteriores" alt="" border="0"
                                  url="/comun/imagenes/pdfIcon.png"/>
                </h:commandLink>
                <f:facet name="popup">
                  <h:panelGroup>
                    <h:panelGrid columns="2" style="text-align:left;">
                      <h:outputText value="Reporte Notas de Enfermeria Anteriores"/>
                    </h:panelGrid>
                  </h:panelGroup>
                </f:facet>
              </t:popup>
            </h:panelGrid>
            <a4j:region renderRegionOnly="false">
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelGridNotaEnfermeria" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Nota Enfermeria" styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                 <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
                  <a4j:commandLink action="#{registrarNotaEnfermeriaBean.mostrarBuscadorPlantilla}" immediate="true"
                                   reRender="panelGridIngresoCirugiaTab">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                  </a4j:commandLink>
                  <h:inputTextarea id="textNotaEnfermeria" required="true" onkeydown="return blockEnter(event);"
                                   immediate="true" binding="#{registrarNotaEnfermeriaBean.itDescripcion}"
                                   value="#{registrarNotaEnfermeriaBean.nota.hnecnotaenferm}"
                                   style="width:500px;height:60px"/>
                </h:panelGrid>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="textNotaEnfermeria" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGrid></h:panelGrid>
              </h:panelGrid>
            </a4j:region>
          </s:fieldset>
          <h:panelGroup>
            <a4j:commandLink action="#{registrarNotaEnfermeriaBean.registrarNuevaProceso}"
                             rendered="#{registrarNotaEnfermeriaBean.renderNuevoRegistro}"
                             title="Registrar Procedimiento de Urgencia" immediate="true">
              <t:graphicImage alt="Registrar Procedimiento de Urgencia" title="Registrar Procedimiento de Urgencia"
                              border="0" url="/comun/imagenes/Skalpell.png"/>
            </a4j:commandLink>
          </h:panelGroup>
          <h:panelGrid>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionNotaEnfermeriaMsg" ajaxRendered="true">
                <t:messages id="msgInformationNotaEnfermeriaMsg" showSummary="true" errorClass="error" globalOnly="true"
                            layout="table" infoClass="informacion"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelBotonesNotaEnfermeria" columnClasses="panelGridBotones">
            <h:panelGroup rendered="#{!registrarNotaEnfermeriaBean.esSalida && !registrarNotaEnfermeriaBean.esIngreso}">
              <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                               onclick="if (!confirm(\'�Esta seguro de Registrar la Nota de Enfermeria \')) return false"
                               action="#{registrarNotaEnfermeriaBean.aceptar}">
                <a4j:support event="onclick" status="statusButton"/>
              </h:commandButton>
            </h:panelGroup>
            <h:panelGroup rendered="#{registrarNotaEnfermeriaBean.esSalida}">
              <h:commandButton value="Dar de Alta" styleClass="btn btn btn-primary"
                               onclick="if (!confirm(\'�Est� seguro de dar salida al paciente, no se permitir�n anotaciones posteriores \')) return false"
                               action="#{registrarNotaEnfermeriaBean.darAlta}">
                <a4j:support event="onclick" status="statusButton"/>
              </h:commandButton>
            </h:panelGroup>
            <h:panelGroup rendered="#{!registrarNotaEnfermeriaBean.esSalida && registrarNotaEnfermeriaBean.esIngreso}">
              <h:commandButton value="Siguiente" styleClass="btn btn btn-success"
                               action="#{registrarNotaEnfermeriaBean.aceptar}">
                <a4j:support event="onclick" status="statusButton"/>
              </h:commandButton>
            </h:panelGroup>
          </h:panelGrid>
        </t:panelTab>
        <t:panelTab id="panelBuscadorPlantillaNotaEnfermeria" label="Buscar Plantillas"
                    rendered="#{registrarNotaEnfermeriaBean.renderPlantilla}">
          <a4j:region id="regionBuscadorPlantillaNotaEnfermeria" renderRegionOnly="false">
            <a4j:status for="regionBuscadorPlantillaNotaEnfermeria">
              <f:facet name="start">
                <t:div id="chargingBuscadorPlantillaNotaEnfermeria" styleClass="loading">
                  <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                    <h:outputText value="Procesando..."/>
                    <h:outputText value="Por favor espere."/>
                  </h:panelGrid>
                </t:div>
              </f:facet>
              <f:facet name="stop"/>
            </a4j:status>
            <jsp:include page="/pages/clinico/comunes/buscador/buscadorPlantillasCirugia.jsp" flush="true"/>
            <h:panelGrid id="panelGridBuscadorBotonesPlantillaNotaEnfermeria" width="100%"
                         columnClasses="columnaBotonesCentrados" dir="RTL">
              <t:htmlTag value="br"/>
            </h:panelGrid>
          </a4j:region>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </h:panelGrid>
  <f:subview id="generarContLiq" rendered="#{registrarNotaEnfermeriaBean.generoReporte}">
    <f:subview id="generarReporteContLiq" rendered="#{registrarNotaEnfermeriaBean.generoReporte}">
      <f:verbatim>
        <script type="text/javascript" language="JavaScript">
                    window.open("<%=request.getSession().getAttribute(XlsServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=1200,height=900");
                </script>
      </f:verbatim>
    </f:subview>
  </f:subview>
</h:panelGrid>