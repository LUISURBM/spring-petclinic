<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formFormulaHospitalizacion">
  <a4j:region id="regionFormulaHospitalizacion" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionFormulaHospitalizacion">
      <f:facet name="start">
        <t:div id="chargingFormulaHospitalizacion" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
   

    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridFormulaHospitalizacionTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneFormulaHospitalizacion"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabPrescripcionHospitalizacion"
                    label="Control Medicamentos">
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridFormulaHospitalizacion"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Medicamento" styleClass="labelTextOblig"/>
            <h:outputText value="Unidades" styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:panelGroup>
              <h:inputText id="itMedicamento" style="width:200px" maxlength="20"
                           value="#{registrarMedicamentoAnestesiaBean.medicamento.hmacmedicament}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itMedicamento" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:selectOneMenu id="mnuUnidades"
                               value="#{registrarMedicamentoAnestesiaBean.medicamento.hmacunidades}">
                <f:selectItems value="#{registrarMedicamentoAnestesiaBean.lstUnidades}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuUnidades" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText/>
            <h:outputText value="Vía de administración"
                          styleClass="labelTextOblig"/>
            <h:panelGroup id="panelTextTipoZonaCual">
              <h:outputText value="Tipo Intravenosa" styleClass="labelTextOblig"
                            rendered="#{registrarMedicamentoAnestesiaBean.mostrarintravenosa && !registrarMedicamentoAnestesiaBean.mostrarlocal && !registrarMedicamentoAnestesiaBean.mostrarotra}"/>
              <h:outputText value="Zona de aplicación "
                            styleClass="labelTextOblig"
                            rendered="#{registrarMedicamentoAnestesiaBean.mostrarlocal && !registrarMedicamentoAnestesiaBean.mostrarintravenosa && !registrarMedicamentoAnestesiaBean.mostrarotra}"/>
              <h:outputText value="Cual?"
                            rendered="#{registrarMedicamentoAnestesiaBean.mostrarotra && !registrarMedicamentoAnestesiaBean.mostrarintravenosa && !registrarMedicamentoAnestesiaBean.mostrarlocal}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextCantidad">
              <h:outputText value="Cantidad" styleClass="labelTextOblig"
                            rendered="#{registrarMedicamentoAnestesiaBean.mostrarcantidad}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneMenu id="mnuViaAdministracion" immediate="true"
                                 value="#{registrarMedicamentoAnestesiaBean.medicamento.hmacviadeadmin}"
                                 valueChangeListener="#{registrarMedicamentoAnestesiaBean.setHmacviadeadmin}">
                  <f:selectItems value="#{registrarMedicamentoAnestesiaBean.lstViaAdministracion}"/>
                  <a4j:support id="supportViaAdministracion" event="onchange"
                               immediate="true"
                               action="#{registrarMedicamentoAnestesiaBean.changeViaAdministracion}"
                               reRender="panelTextTipoZonaCual,panelInputTipoZonaCual,panelTextCantidad,panelInputCantidad">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuViaAdministracion"
                             styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelInputTipoZonaCual">
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectOneMenu id="mnuTipoIntravenosa" immediate="true"
                                   value="#{registrarMedicamentoAnestesiaBean.medicamento.hmactipointrav}"
                                   valueChangeListener="#{registrarMedicamentoAnestesiaBean.setHmactipointrav}"
                                   rendered="#{registrarMedicamentoAnestesiaBean.mostrarintravenosa && !registrarMedicamentoAnestesiaBean.mostrarlocal && !registrarMedicamentoAnestesiaBean.mostrarotra}">
                    <f:selectItems value="#{registrarMedicamentoAnestesiaBean.lstTipoIntravenosa}"/>
                    <a4j:support id="supportmnuTipoIntravenosa" event="onchange"
                                 immediate="true"
                                 action="#{registrarMedicamentoAnestesiaBean.changeTipoIntravenosa}"
                                 reRender="panelTextCantidad,panelInputCantidad">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuTipoIntravenosa"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
              <h:panelGroup>
                <h:inputText id="itZonaLocalizacion" required="false"
                             value="#{registrarMedicamentoAnestesiaBean.medicamento.hmaczonalocali}"
                             rendered="#{registrarMedicamentoAnestesiaBean.mostrarlocal && !registrarMedicamentoAnestesiaBean.mostrarintravenosa && !registrarMedicamentoAnestesiaBean.mostrarotra}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itZonaLocalizacion"
                             styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itOtraVia" required="false"
                             value="#{registrarMedicamentoAnestesiaBean.medicamento.hmacotraviaadm}"
                             rendered="#{registrarMedicamentoAnestesiaBean.mostrarotra && !registrarMedicamentoAnestesiaBean.mostrarintravenosa && !registrarMedicamentoAnestesiaBean.mostrarlocal}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itOtraVia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup id="panelInputCantidad">
              <h:inputText id="itCantidad" maxlength="3" style="width:50px"
                           value="#{registrarMedicamentoAnestesiaBean.medicamento.hmancantiinfus}"
                           rendered="#{registrarMedicamentoAnestesiaBean.mostrarcantidad}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itCantidad" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="Fecha de administración"
                          styleClass="labelTextOblig"/>
            <h:outputText value="Hora de administración"
                          styleClass="labelTextOblig"/>
            <h:outputText value=""/>
            <h:panelGroup id="panelFechaAdministracion">
              <t:inputCalendar id="fechaAdministracion"
                               onkeydown="return blockEnter(event);"
                               monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" immediate="true"
                               title="Formato: dd/mm/yyyy"
                               currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{registrarMedicamentoAnestesiaBean.medicamento.hmadhoraadmini}"
                               popupTodayString="Hoy" popupWeekString="Semana"
                               popupButtonString="Fecha" readonly="false"
                               maxlength="11" size="11"
                               popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top"
                               required="false"></t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechaAdministracion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelHoraAdministracion">
              <h:panelGroup>
                <h:selectOneMenu id="mnuHoraAdministracion" required="false"
                                 immediate="true"
                                 value="#{registrarMedicamentoAnestesiaBean.horaadministracion}">
                  <f:selectItems value="#{registrarMedicamentoAnestesiaBean.listHora}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuHoraAdministracion"
                             styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value=" : "/>
              <h:panelGroup>
                <h:selectOneMenu id="mnuMinutosAdministracion" required="false"
                                 immediate="true"
                                 value="#{registrarMedicamentoAnestesiaBean.minutoadministracion}">
                  <f:selectItems value="#{registrarMedicamentoAnestesiaBean.lstMinutos}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuMinutosAdministracion"
                             styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:outputText/>
            <h:outputText value="Inducción"/>
            <h:outputText value="Mantenimiento"/>
            <h:outputText value=""/>
            <h:panelGroup>
              <h:inputText id="itInduccion" maxlength="6" style="width:60px"
                           value="#{registrarMedicamentoAnestesiaBean.medicamento.hmaninduccion}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itInduccion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="itMantenimiento" maxlength="6" style="width:60px"
                           value="#{registrarMedicamentoAnestesiaBean.medicamento.hmanmantenimie}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itMantenimiento" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridObservaciones"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Observaciones"/>
            <h:panelGroup>
              <h:inputTextarea id="itObservaciones" style="width:500px"
                               value="#{registrarMedicamentoAnestesiaBean.medicamento.hmacobservacio}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itObservaciones" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelBotonAgregarFormula"
                       columnClasses="columnaBotones">
            <h:panelGroup>
              <t:htmlTag value="br"/>
                  <a4j:commandButton value="Agregar"
                                 styleClass="btn btn btn-warning"
                                 action="#{registrarMedicamentoAnestesiaBean.agregarMedicamento}"
                                 reRender="formFormulaHospitalizacion"/>
            </h:panelGroup>
          </h:panelGrid>
          <a4j:region renderRegionOnly="false">
            <s:fieldset legend="Lista Medicamentos"
                        id="fieldMedicamentosLista"
                        rendered="#{not empty registrarMedicamentoAnestesiaBean.lstMedicamento}"
                        styleClass="fieldset">
              <h:panelGrid columns="1" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelFormulacionTable" styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0"
                               binding="#{registrarMedicamentoAnestesiaBean.dtMedicamento}"
                               cellspacing="0"
                               value="#{registrarMedicamentoAnestesiaBean.lstMedicamento}"
                               rows="10" styleClass="standard_table"
                               rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtMedicamento">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Medicamento"/>
                      </f:facet>
                      <h:outputText value="#{item.hmacmedicament}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Unidades"/>
                      </f:facet>
                      <h:outputText value="#{item.hmacunidades}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Vía de administración"/>
                      </f:facet>
                      <h:outputText value="#{item.hmacviadeadmin}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Hora de administración"/>
                      </f:facet>
                      <h:outputText value="#{item.hmadhoraadmini}">
                      <f:convertDateTime pattern="dd/MM/yyyy hh:mm"/>
                      </h:outputText>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Inducción"/>
                      </f:facet>
                      <h:outputText value="#{item.hmaninduccion}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Mantenimiento "/>
                      </f:facet>
                      <h:outputText value="#{item.hmanmantenimie}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Eliminar"/>
                      </f:facet>
                      <a4j:commandLink id="eliminar" immediate="true"
                                    onclick="if(!confirm(\' Desea remover este registro ? \')){ return false; }"
                                    reRender="formFormulaHospitalizacion"
                                     action="#{registrarMedicamentoAnestesiaBean.eliminarMedicamento}">
                        <t:graphicImage  alt=""  border="0"
                                        url="/comun/imagenes/editar.gif"/>
                      </a4j:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1"
                               rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_1" for="dtMedicamento" fastStep="10"
                                    pageCountVar="pageCount"
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
          </a4j:region>
        </t:panelTab>
      </t:panelTabbedPane>
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                   width="100%" id="panelBotonModificar"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                           action="#{registrarMedicamentoAnestesiaBean.RegistrarMedicamento}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
      <h:panelGrid>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrors1" showSummary="true"
                        errorClass="error" globalOnly="true" layout="table"
                        infoClass="informacion"/>
          </a4j:outputPanel>
        </h:panelGroup>
      </h:panelGrid>
    </h:panelGrid>
  </a4j:region>
</a4j:form>