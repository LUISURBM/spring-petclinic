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

    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="panelGridFormulaHospitalizacionTab" styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneFormulaHospitalizacion" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabPrescripcionHospitalizacion" label="Prescripción Hospitalizacion">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridFormulaHospitalizacion" styleClass="tabContainer">
            <s:fieldset legend="Prescripción Hospitalización" id="fieldFormulaHospitalizacion" styleClass="fieldset">
              <a4j:region id="regionFormulaHospitalizacion" renderRegionOnly="false">
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelDatosFormulaHospitalizacion" rowClasses="labelText">
                  <h:outputText value="Nombre genérico del medicamento formulado" styleClass="labelTextOblig"/>
                  <h:outputText value="Presentación del medicamento" styleClass="labelTextOblig"/>
                  <h:panelGroup>
                    <h:inputTextarea id="itMedicamento" required="true"
                                     value="#{formulaHospitalizacionBean.medicamentoSelect}" style="width:300px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itMedicamento" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:panelGroup>
                    <h:inputText id="itPresentacion" required="true" maxlength="50"
                                 value="#{formulaHospitalizacionBean.presentacionSelect}" style="width:200px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itPresentacion" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value="Dosis" styleClass="labelTextOblig"/>
                  <h:outputText value="Frecuencia de administración" styleClass="labelTextOblig"/>
                  <h:panelGrid columns="4">
                    <h:inputText id="itDosis" required="true" maxlength="4"
                                 value="#{formulaHospitalizacionBean.dosisSelect}" style="width:40px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itDosis" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:selectOneRadio id="mnuUnidades" required="true"
                                      value="#{formulaHospitalizacionBean.unidadSelect}">
                      <f:selectItems value="#{formulaHospitalizacionBean.lstUnidades}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuUnidades" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGrid>
                  <h:panelGroup>
                    <h:inputText id="itFrecuencia" required="true" maxlength="50"
                                 value="#{formulaHospitalizacionBean.frecuenciaAdm}" style="width:200px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itFrecuencia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGrid>
                <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelDatosViaAdministracion" rowClasses="labelText">
                  <h:outputText value="Vía de administración" styleClass="labelTextOblig"/>
                  <h:panelGroup id="outputForma">
                    <h:outputText value="Forma de Administración"
                                  rendered="#{formulaHospitalizacionBean.mostrarIntravenosa}"
                                  styleClass="labelTextOblig"/>
                  </h:panelGroup>
                  <h:panelGroup id="panelTextVolumen">
                    <h:outputText value="Volumen en mililitros"
                                  rendered="#{formulaHospitalizacionBean.mostrarBuretrol}"/>
                    <h:outputText value="velocidad de infusión en ml/hora"
                                  rendered="#{formulaHospitalizacionBean.mostrarInfusion}"/>
                  </h:panelGroup>
                  <h:panelGroup id="panelTextTiempo">
                    <h:outputText value="Tiempo de infusión en minutos"
                                  rendered="#{formulaHospitalizacionBean.mostrarBuretrol}"/>
                  </h:panelGroup>
                  <a4j:region renderRegionOnly="false">
                    <h:panelGroup>
                      <h:selectOneMenu id="mnuVia" required="true" immediate="true"
                                       value="#{formulaHospitalizacionBean.viaSelect}"
                                       valueChangeListener="#{formulaHospitalizacionBean.setViaSelect}">
                        <f:selectItems value="#{formulaHospitalizacionBean.lstVia}"/>
                        <a4j:support id="supportmnuViaAdministracion" event="onchange" immediate="true"
                                     action="#{formulaHospitalizacionBean.ChangeViaAdministracion}"
                                     reRender="outputForma,panelmnuForma">
                          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                      </h:selectOneMenu>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuVia" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </a4j:region>
                  <h:panelGroup id="panelmnuForma">
                    <h:selectOneMenu id="mnuForma" required="true" immediate="true"
                                     rendered="#{formulaHospitalizacionBean.mostrarIntravenosa}"
                                     value="#{formulaHospitalizacionBean.formaSelect}"
                                     valueChangeListener="#{formulaHospitalizacionBean.setFormaSelect}">
                      <f:selectItems value="#{formulaHospitalizacionBean.lstFormaAdministracion}"/>
                      <a4j:support id="supportmnuForma" event="onchange" immediate="true"
                                   action="#{formulaHospitalizacionBean.ChangeForma}"
                                   reRender="panelTextVolumen,panelTextTiempo,panelInputVolumen,panelInputTiempo">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuForma" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:panelGroup id="panelInputVolumen">
                    <h:panelGroup>
                      <h:inputText id="itVolumen" required="true" maxlength="4"
                                   rendered="#{formulaHospitalizacionBean.mostrarBuretrol}"
                                   value="#{formulaHospitalizacionBean.volumenBuretrol}" style="width:50px"/>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itVolumen" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                    <h:panelGroup>
                      <h:inputText id="itVelocidadInfusion" required="true" maxlength="4"
                                   rendered="#{formulaHospitalizacionBean.mostrarInfusion}"
                                   value="#{formulaHospitalizacionBean.velocidadInfusion}" style="width:50px"/>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itVelocidadInfusion" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </h:panelGroup>
                  <h:panelGroup id="panelInputTiempo">
                    <h:inputText id="itTiempo" required="true" maxlength="4"
                                 rendered="#{formulaHospitalizacionBean.mostrarBuretrol}"
                                 value="#{formulaHospitalizacionBean.tiempoBuretrol}" style="width:50px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itTiempo" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGrid>
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelBotonAgregarFormula" columnClasses="columnaBotones">
                  <h:panelGroup>
                    <t:htmlTag value="br"/>
                    <a4j:commandButton value="Agregar" styleClass="boton_fieldset_Naranja"
                                       action="#{formulaHospitalizacionBean.agregarPrescripcion}"
                                       reRender="panelGridFormulaHospitalizacion"/>
                  </h:panelGroup>
                </h:panelGrid>
              </a4j:region>
              <a4j:region renderRegionOnly="false">
                <s:fieldset legend="Formula Hospitalización" id="fieldHospitalizacionLista"
                            rendered="#{not empty formulaHospitalizacionBean.lstPrescripciones}" styleClass="fieldset">
                  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                               id="panelFormulacionTable" styleClass="tabContainer">
                    <t:buffer into="#{table}">
                      <h:dataTable var="item" border="1" cellpadding="0"
                                   binding="#{formulaHospitalizacionBean.dtFormula}" cellspacing="0"
                                   value="#{formulaHospitalizacionBean.lstPrescripciones}" rows="10"
                                   styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                                   footerClass="paginacion" id="dtFormula">
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Medicamento"/>
                          </f:facet>
                          <h:outputText value="#{item.hfhcmedicament}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Presentación"/>
                          </f:facet>
                          <h:outputText value="#{item.hfhcpresentaci}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Dosis"/>
                          </f:facet>
                          <h:outputText value="#{item.hfhcadosis} #{item.hfhcunidad}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Frecuencia"/>
                          </f:facet>
                          <h:outputText value="#{item.hfhcfrecuadmin}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Via"/>
                          </f:facet>
                          <h:outputText value="#{item.hfhcviadministr}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Recomendación"/>
                          </f:facet>
                          <h:outputText value="#{item.wdesforma}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Eliminar"/>
                          </f:facet>
                          <a4j:commandLink id="eliminar" immediate="true"
                                           onclick="if(!confirm(\' Desea remover este registro ? \')){ return false; }"
                                           reRender="panelGridFormulaHospitalizacion"
                                           action="#{formulaHospitalizacionBean.eliminarFormula}">
                            <t:graphicImage alt=""  border="0" url="/comun/imagenes/editar.gif"/>
                          </a4j:commandLink>
                        </h:column>
                      </h:dataTable>
                    </t:buffer>
                    <t:buffer into="#{tableScroller}">
                      <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                        <t:dataScroller id="scroll_1" for="dtFormula" fastStep="10" pageCountVar="pageCount"
                                        pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                        paginatorMaxPages="9" paginatorTableClass="paginator"
                                        renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
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
              </a4j:region>
            </s:fieldset>
            <a4j:region renderRegionOnly="false">
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                           columnClasses="panelGridBotones">
                <a4j:commandButton value="Generar Formula Hospitalizacion" reRender="panelGridFormulaHospitalizacion"
                                   styleClass="boton_fieldset" action="#{formulaHospitalizacionBean.generarFormula}"/>
              </h:panelGrid>
            </a4j:region>
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionFormulaHospitalizacionMsg" ajaxRendered="true">
                  <t:messages id="msgFormulaHospitalizacionMsg" showSummary="true" errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>