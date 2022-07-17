<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAntecedentesGeneralesTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneAntecedentes" styleClass="tabbedPane"
                     activeTabStyleClass="actMusaTab" inactiveTabStyleClass="inactMusaTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="actMusaSub"
                     inactiveSubStyleClass="inactMusaSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabAntecedentes" label="Antecedentes ">
      <s:fieldset legend="Antecedentes" id="fieldAntecedentes" styleClass="fieldset">
        <h:panelGrid columns="1" id="panelGridConsultar"
                     rendered="#{empty antecedentesUsuarioDetalladoBean.antecedentesDetalladoHistorial}">
          <h:outputText value="#{msg.msg_sin_antecedentes}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0"
                     rendered="#{not empty antecedentesUsuarioDetalladoBean.antecedentesDetalladoHistorial}" cellspacing="0"
                     width="100%" id="tableHistorico" styleClass="tabContainer">
          <t:buffer into="#{tableAntecedentes}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         value="#{antecedentesUsuarioDetalladoBean.antecedentesDetalladoHistorial}" rows="20"
                         styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                         footerClass="paginacion" id="dtHistoricoAntecedentes">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Tipo Antecedente"/>
                </f:facet>
                <h:outputText value="#{item.tipoAntecedente}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Nombre Antecedente"/>
                </f:facet>
                <h:outputText value="#{item.nombreAntecedente}"/>
              </h:column>
               <h:column>
                <f:facet name="header">
                  <h:outputText value="Descripción"/>
                </f:facet>
                <h:outputText value="#{item.descripcionAntecedente}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha Registro"/>
                </f:facet>
                <h:outputText value="#{item.fechaRegistro}"/>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScrollerAntecedente}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_Antecedente" for="dtHistoricoAntecedentes" fastStep="10"
                              pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                              immediate="true" paginatorMaxPages="9" paginatorTableClass="paginator"
                              renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
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
          <h:outputText value="#{tableScrollerAntecedente}" escape="false"/>
          <h:outputText value="#{tableAntecedentes}" escape="false"/>
          <h:outputText value="#{tableScrollerAntecedente}" escape="false"/>
        </h:panelGrid>
      </s:fieldset>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsAntecedentes"
                   styleClass="tabContainer">
        <s:fieldset legend="Grupo Sanguineo" id="fieldGrupoSanguineo" styleClass="fieldset">
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelSangre"
                       rowClasses="labelText,labelTextInfo">
            <h:panelGroup>
              <h:outputText value="Grupo Sanguineo" styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:panelGroup id="rh">
              <h:outputText value="RH" styleClass="labelTextOblig"
                            rendered="#{antecedentesUsuarioDetalladoBean.renderGrupoSanguineo}"/>
            </h:panelGroup>
            <h:panelGroup id="textIso">
              <h:outputText value="Isoinmunización en parto o aborto anterior "
                            rendered="#{antecedentesUsuarioDetalladoBean.renderRH}" styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <h:selectOneMenu id="mnuGruSangre" required="true"
                                 value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcgrupsang}">
                  <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstGrupoSangre}"/>
                  <a4j:support id="supportmnuGS" event="onchange"
                               action="#{antecedentesUsuarioDetalladoBean.changeGrupoSanguineo}"
                               reRender="grupoSanguineo,rh,panelMnuIsoinmunizacion,textIso">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuGruSangre" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </a4j:region>
            </h:panelGroup>
            <h:panelGroup id="grupoSanguineo">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuFacSangre" required="true"
                                  value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcrh}"
                                  valueChangeListener="#{antecedentesUsuarioDetalladoBean.setFacSangreSelect}"
                                  rendered="#{antecedentesUsuarioDetalladoBean.renderGrupoSanguineo}">
                  <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstFactorSangre}"/>
                  <a4j:support id="supportmnuRH" event="onclick" action="#{antecedentesUsuarioDetalladoBean.changeRH}"
                               reRender="panelMnuIsoinmunizacion,textIso,rh">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{antecedentesUsuarioDetalladoBean.renderGrupoSanguineo}">
                  <t:message for="mnuFacSangre" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </a4j:region>
            </h:panelGroup>
            <h:panelGroup id="panelMnuIsoinmunizacion">
              <h:selectOneRadio id="mnuIsoinmunizacion" required="#{antecedentesUsuarioDetalladoBean.renderRH}"
                                rendered="#{antecedentesUsuarioDetalladoBean.renderRH}"
                                value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcisoinabort}">
                <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpciones}"/>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true" rendered="#{antecedentesUsuarioDetalladoBean.renderRH}">
                <t:message for="mnuIsoinmunizacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Antecedentes Específicos" id="fieldAntecedentesMusa"
                    styleClass="fieldset">
           <jsp:include page="/pages/clinico/comunes/antecedentesPersonalesEspecíficos.jsp" flush="true"/>
        </s:fieldset>
        <s:fieldset legend="Otras Preguntas" id="fieldOtrasPreguntas" styleClass="fieldset">
          <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelOtrasPreguntas"
                       rowClasses="labelText,labelTextInfo">
            <h:panelGroup>
              <h:outputText value="Fecha ultima prueba de VIH" styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:outputText value=" "/>
            <h:panelGroup id="panelTextPruebaVIH">
              <h:outputText value="Opciones" styleClass="labelTextOblig"
                            rendered="#{antecedentesUsuarioDetalladoBean.renderPruebaVPH}"/>
            </h:panelGroup>
            <h:outputText value=" "/>
            <h:panelGroup>
              <h:outputText value="Fecha última prueba sífilis" styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:outputText value=" "/>
            <h:panelGroup id="panelTextFechaSifilis">
              <h:outputText value="Opciones" styleClass="labelTextOblig"
                            rendered="#{antecedentesUsuarioDetalladoBean.renderPruebaSifilis}"/>
            </h:panelGroup>
            <h:outputText value=" "/>
            <h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <h:selectOneMenu id="mnuFechaVIH" required="true"
                                 value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcultpruvih}">
                  <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesPregunta}"/>
                  <a4j:support id="supportmnuFechaVIH" event="onchange"
                               action="#{antecedentesUsuarioDetalladoBean.changePruebaVPH}"
                               reRender="panelPruebaVPH,panelTextPruebaVIH">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
              </a4j:region>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuFechaVIH" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelPruebaVPH">
              <h:selectOneMenu id="mnuOpcionesVPH" required="true"
                               rendered="#{antecedentesUsuarioDetalladoBean.renderPruebaVPH}"
                               value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcresultpruvih}">
                <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstRespuestaPregunta}"/>
              </h:selectOneMenu>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuOpcionesVPH" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <h:selectOneMenu id="mnuFechaSifilis" required="true"
                                 value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcultprusif}">
                  <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesPregunta}"/>
                  <a4j:support id="supportmnuFechaSifilis" event="onchange"
                               action="#{antecedentesUsuarioDetalladoBean.changePruebaSifilis}"
                               reRender="panelPruebaSifilis,panelTextFechaSifilis">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
              </a4j:region>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuFechaSifilis" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelPruebaSifilis">
              <h:selectOneMenu id="mnuOpcionesSifilis" required="true"
                               rendered="#{antecedentesUsuarioDetalladoBean.renderPruebaSifilis}"
                               value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcresultprusif}">
                <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstRespuestaPregunta}"/>
              </h:selectOneMenu>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuOpcionesSifilis" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
          <h:panelGroup>
            <h:outputText value="Se realizan pruebas rápidas en la consulta" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="menuPruebasRapidas" immediate="true" required="true"
                                value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcprurapcon}">
                <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpciones}"/>
                <a4j:support id="supportmnuPruebasRapidas" event="onclick"
                             action="#{antecedentesUsuarioDetalladoBean.changePruebaRapida}"
                             reRender="panelPreguntasPruebasRapidas,panelGPreguntasPruebasRapidas">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuPruebasRapidas" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup id="panelPreguntasPruebasRapidas">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="1" id="panelGPreguntasPruebasRapidas"
                         rowClasses="standardTable_Row8,standardTable_Row8" style="border-color:#3f3e23;"
                         rendered="#{antecedentesUsuarioDetalladoBean.renderPruebaRapida}">
              <h:panelGroup>
                <h:selectManyCheckbox required="false" style="border-style:none;" immediate="true"
                                      id="mnuPreguntasPruebasRapidas"
                                      value="#{antecedentesUsuarioDetalladoBean.lstOpcionesPruebasRapidasSelect}"
                                      valueChangeListener="#{antecedentesUsuarioDetalladoBean.setOpcionesPruebasRapidasSelect}"
                                      layout="pageDirection">
                  <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesPruebasRapidas}"/>
                  <a4j:support id="supportmnuPreguntasPruebasRapidas" event="onclick" immediate="true"
                               action="#{antecedentesUsuarioDetalladoBean.changeOpcionesPruebasRapidas}"
                               reRender="OpcionesPruebas,panelGOpcionesPruebasRapidas">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectManyCheckbox>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuPreguntasPruebasRapidas" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id="OpcionesPruebas">
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="1" width="800px"
                             id="panelGOpcionesPruebasRapidas" rowClasses="standardTable_Row8,standardTable_Row8"
                             style="border-color:#3f3e23;"
                             rendered="#{antecedentesUsuarioDetalladoBean.renderPruebaRapida}">
                  <h:panelGroup>
                    <h:selectOneRadio id="menuPruebasEmbarazo" immediate="true" required="true"
                                      rendered="#{antecedentesUsuarioDetalladoBean.renderEmbarazo}"
                                      value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcembarazo}">
                      <a4j:support id="supportmenuPruebasEmbarazo" event="onclick"/>
                      <f:selectItems value="#{antecedentesUsuarioDetalladoBean.resultadosPruebasRapidasEmbarazo}"/>
                    </h:selectOneRadio>
                  </h:panelGroup>
                  <h:panelGroup>
                    <h:selectOneRadio id="menuPruebasSifilis" immediate="true" required="true"
                                      rendered="#{antecedentesUsuarioDetalladoBean.renderSifilis}"
                                      value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcsifilis}">
                      <a4j:support id="supportmenuPruebasSifilis" event="onclick"/>
                      <f:selectItems value="#{antecedentesUsuarioDetalladoBean.resultadosPruebasRapidas}"/>
                    </h:selectOneRadio>
                  </h:panelGroup>
                  <h:panelGroup>
                    <h:selectOneRadio id="menuPruebasVIH" immediate="true" required="true"
                                      rendered="#{antecedentesUsuarioDetalladoBean.renderVIH}"
                                      value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcvih}">
                      <a4j:support id="supportmenuPruebasVih" event="onclick"/>
                      <f:selectItems value="#{antecedentesUsuarioDetalladoBean.resultadosPruebasRapidas}"/>
                    </h:selectOneRadio>
                  </h:panelGroup>
                </h:panelGrid>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGroup>
          <h:outputText/>
          <h:outputText/>
          <h:outputText/>
          <h:outputText/>
          <h:outputText/>
          <h:outputText/>
          <h:outputText/>
        </s:fieldset>
      </h:panelGrid>
      <a4j:region renderRegionOnly="false">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                             action="#{antecedentesUsuarioDetalladoBean.aceptar}">
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
    <a4j:outputPanel id="ajaxRegionMensajes" ajaxRendered="true">
      <t:messages id="msgInf" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                  infoClass="informacion"/>
    </a4j:outputPanel>
  </h:panelGroup>
</h:panelGrid>
<script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>