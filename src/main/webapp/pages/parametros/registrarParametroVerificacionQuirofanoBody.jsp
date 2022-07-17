<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<!-- registrarRegistrarMaterialInstrumental.jsp -->
<a4j:form id="infoRegistrarParametroForm">
  <a4j:region id="bodyRegionRegistrarParametro">
    <a4j:status for="bodyRegionRegistrarParametro">
      <f:facet name="start">
        <t:div id="chargindRegistrarParametro" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneRegistrarParametro" styleClass="tabbedPane"
                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabRegistrarParametro" label="Registrar Parametro Verificación Quirofano">
        <a4j:region renderRegionOnly="false">
          <s:fieldset legend="Registrar Parametro de Verificación" id="fieldSetInfoRegistrarParametro"
                      styleClass="fieldset">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelRegionRegistrarParametro" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Literal" styleClass="labelTextOblig"/>
              <h:outputText value="Numeral" styleClass="labelTextOblig"/>
              <h:panelGrid columns="2">
                <h:panelGroup>
                  <h:inputText id="codigoLiteral" styleClass="textmayuscula" maxlength="1" style="width:20px"
                               value="#{registrarParametroVerificacionQuirofanoBean.parametroAdd.hpqcliteral}"
                               immediate="true" converter="cadena.stringUpperCaseConverter"></h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="codigoLiteral" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
              <h:panelGrid columns="2">
                <h:panelGroup>
                  <h:inputText id="codigoNumeral" onkeydown="return blockEnter(event);" maxlength="2" style="width:40px"
                               immediate="true"
                               value="#{registrarParametroVerificacionQuirofanoBean.parametroAdd.hpqnnumeral}"
                               valueChangeListener="#{registrarParametroVerificacionQuirofanoBean.setHpqnnumeral}">
                    <a4j:support id="supporTitulo" event="onclick"
                                 action="#{registrarParametroVerificacionQuirofanoBean.changeNumeral}"
                                 reRender="panelRegistro2" immediate="true">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="codigoNumeral" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
            </h:panelGrid>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegistro2"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Descripción" styleClass="labelTextOblig"/>
              <h:panelGrid columns="2">
                <h:outputText id="menuTipoanestesia" value="Tipo de Anestesia" styleClass="labelTextOblig"
                              rendered="#{!registrarParametroVerificacionQuirofanoBean.renderTitulo}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="menuTipoanestesia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
              <h:panelGrid columns="2">
                <h:inputText id="itDescripcionRegistrarParametro" style="width:700px;height:60px" maxlength="400"
                             value="#{registrarParametroVerificacionQuirofanoBean.parametroAdd.hpqcdescri}"></h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itDescripcionRegistrarParametro" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
              <a4j:region renderRegionOnly="false">
                <h:panelGrid columns="2">
                  <h:outputText value="General" style="font-size:10px"
                                rendered="#{!registrarParametroVerificacionQuirofanoBean.renderTitulo}"/>
                  <h:selectBooleanCheckbox id="checkGeneral" onkeydown="return blockEnter(event);"
                                           rendered="#{!registrarParametroVerificacionQuirofanoBean.renderTitulo}"
                                           value="#{registrarParametroVerificacionQuirofanoBean.renderGeneral}"/>
                  <h:outputText value="Regional" style="font-size:10px"
                                rendered="#{!registrarParametroVerificacionQuirofanoBean.renderTitulo}"/>
                  <h:selectBooleanCheckbox id="checkRegional" onkeydown="return blockEnter(event);"
                                           rendered="#{!registrarParametroVerificacionQuirofanoBean.renderTitulo}"
                                           value="#{registrarParametroVerificacionQuirofanoBean.renderRegional}"/>
                  <h:outputText value="Local" style="font-size:10px"
                                rendered="#{!registrarParametroVerificacionQuirofanoBean.renderTitulo}"/>
                  <h:selectBooleanCheckbox id="checkLocal" onkeydown="return blockEnter(event);"
                                           rendered="#{!registrarParametroVerificacionQuirofanoBean.renderTitulo}"
                                           value="#{registrarParametroVerificacionQuirofanoBean.renderLocal}"/>
                </h:panelGrid>
              </a4j:region>
              <h:outputText value="Permite No Aplica" styleClass="labelTextOblig"
                            rendered="#{!registrarParametroVerificacionQuirofanoBean.renderTitulo}"/>
              <h:outputText value="Registra el Anestesiologo" styleClass="labelTextOblig"
                            rendered="#{!registrarParametroVerificacionQuirofanoBean.renderTitulo}"/>
              <h:panelGrid columns="2">
                <h:selectOneRadio id="menuNoaplica" onkeydown="return blockEnter(event);" immediate="true"
                                  rendered="#{!registrarParametroVerificacionQuirofanoBean.renderTitulo}"
                                  valueChangeListener="#{registrarParametroVerificacionQuirofanoBean.setHpqcnoaplica}"
                                  value="#{registrarParametroVerificacionQuirofanoBean.parametroAdd.hpqcnoaplica}">
                  <f:selectItems value="#{registrarParametroVerificacionQuirofanoBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="menuNoaplica" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
              <h:panelGrid columns="2">
                <h:selectOneRadio id="menuReganestesiologo"
                                  rendered="#{!registrarParametroVerificacionQuirofanoBean.renderTitulo}"
                                  valueChangeListener="#{registrarParametroVerificacionQuirofanoBean.setHpqcreganeste}"
                                  value="#{registrarParametroVerificacionQuirofanoBean.parametroAdd.hpqcreganeste}">
                  <f:selectItems value="#{registrarParametroVerificacionQuirofanoBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="menuReganestesiologo" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
              <h:outputText value="Etapa de Registro" styleClass="labelTextOblig"
                            rendered="#{!registrarParametroVerificacionQuirofanoBean.renderTitulo}"/>
              <h:outputText value=" " 
                           rendered="#{!registrarParametroVerificacionQuirofanoBean.renderTitulo}"/>
              <h:panelGrid columns="2">
                <h:selectOneRadio id="menuEtapa"
                                  rendered="#{!registrarParametroVerificacionQuirofanoBean.renderTitulo}"
                                  valueChangeListener="#{registrarParametroVerificacionQuirofanoBean.setHpqcetapa}"
                                  value="#{registrarParametroVerificacionQuirofanoBean.parametroAdd.hpqcetapa}">
                  <f:selectItems value="#{registrarParametroVerificacionQuirofanoBean.lstEtapa}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="menuEtapa" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGrid>
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelBotonAgregarRegistrarParametro">
              <a4j:commandButton value="Nuevo"  styleClass="btn btn btn-success"
                                 action="#{registrarParametroVerificacionQuirofanoBean.nuevoParametro}"/>
             <h:outputText value=""/>
             <h:outputText value=""/>
              <a4j:commandButton value="Agregar" styleClass="btn btn btn-success"
                                 action="#{registrarParametroVerificacionQuirofanoBean.agregarParametro}"/>
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Lista Parametros de Verificación Quirofano" id="fieldListaRegistrarParametro"
                      styleClass="fieldset">
            <h:panelGrid columns="1" id="panelGridListaRegistrarParametro"
                         rendered="#{empty registrarParametroVerificacionQuirofanoBean.lstParametro}">
              <h:outputText value="No existen Parametros de Verificación Quirofano"/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelRegistrarParametro" styleClass="tabContainer"
                         rendered="#{not empty registrarParametroVerificacionQuirofanoBean.lstParametro}">
              <h:dataTable var="item" border="0" cellpadding="0"
                           binding="#{registrarParametroVerificacionQuirofanoBean.dtParametro}" cellspacing="0"
                           value="#{registrarParametroVerificacionQuirofanoBean.lstParametro}" rows="10"
                           styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                           footerClass="paginacion" id="dtParametro">
             

                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Descripción"/>
                  </f:facet>
                  <t:div style="overflow:auto;width:400px;height:50px;">
                    <h:panelGrid>
                    <h:outputText value="#{item.hpqcdescri}" rendered="#{item.hpqnnumeral != \'0\'}"
                                  style="font-size: 13px"/>
                    <h:outputText value="#{item.hpqcdescri}" rendered="#{item.hpqnnumeral == \'0\'}"
                                  style="font-size: 15px; font-weight: bold"/>
                    </h:panelGrid>
                  </t:div>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Reg. Anestesiologo"/>
                  </f:facet>
                  <h:panelGrid>
                  <h:outputText value="#{item.hpqcreganeste}" rendered="#{item.hpqnnumeral != \'0\'}"
                                style="font-size: 13px"/>
                  <h:outputText value=" " rendered="#{item.hpqnnumeral == \'0\'}"/>
                  </h:panelGrid>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Permite No Aplica"/>
                  </f:facet>
                  <h:panelGrid>
                    <h:outputText value="#{item.hpqcnoaplica}" rendered="#{item.hpqnnumeral != \'0\'}"
                                style="font-size: 13px"/>
                    <h:outputText value=" " rendered="#{item.hpqnnumeral == \'0\'}"/>
                  </h:panelGrid>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Anestesia General"/>
                  </f:facet>
                  <h:panelGrid>
                    <h:outputText value="#{item.hpqcanesgen}" rendered="#{item.hpqnnumeral != \'0\'}"
                                style="font-size: 13px"/>
                    <h:outputText value=" " rendered="#{item.hpqnnumeral == \'0\'}"/>
                  </h:panelGrid>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Anestesia Regional"/>
                  </f:facet>
                  <h:panelGrid>
                    <h:outputText value="#{item.hpqcanesreg}" rendered="#{item.hpqnnumeral != \'0\'}"
                                style="font-size: 13px"/>
                    <h:outputText value=" " rendered="#{item.hpqnnumeral == \'0\'}"/>
                  </h:panelGrid>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Anestesia Local"/>
                  </f:facet>
                  <h:panelGrid>
                    <h:outputText value="#{item.hpqcanesloc}" rendered="#{item.hpqnnumeral != \'0\'}"
                                style="font-size: 13px"/>
                    <h:outputText value=" " rendered="#{item.hpqnnumeral == \'0\'}"/>
                  </h:panelGrid>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Etapa de Registro"/>
                  </f:facet>
                  <h:panelGrid>
                    <h:outputText value="#{item.hpqcetapa} - #{(item.hpqcetapa == \'AA\') ? \'Antes de la Anestesia\' : (item.hpqcetapa == \'AI\') ? \'Antes de la Insición\' : \'Antes de la Salida\' }" rendered="#{item.hpqnnumeral != \'0\'}"
                                style="font-size: 13px"/>
                    <h:outputText value=" " rendered="#{item.hpqnnumeral == \'0\'}"/>
                  </h:panelGrid>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Estado"/>
                  </f:facet>
                  <h:panelGrid>
                    <h:outputText value="#{item.hpqcestado}"/>
                  </h:panelGrid>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Editar"/>
                  </f:facet>
                  <a4j:region renderRegionOnly="false">
                    <t:commandLink id="editarRegistrarParametro" immediate="true"
                                   action="#{registrarParametroVerificacionQuirofanoBean.editarParametro}">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/editar.gif"/>
                      <a4j:support id="supporEditar" event="onclick" immediate="true"
                                   action="#{registrarParametroVerificacionQuirofanoBean.changeNumeral}"
                                   reRender="panelRegistro2">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </t:commandLink>
                  </a4j:region>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Activar/Inactivar"/>
                  </f:facet>
                  <a4j:region renderRegionOnly="false">
                    <t:commandButton id="activarRegistrarParametro" value="Activar" styleClass="btn btn btn-warning" 
                                     action="#{registrarParametroVerificacionQuirofanoBean.activarParametro}"
                                     onclick="return confirmar(\'Realmente desea Inactivar el Parametro de Verificación Quirofano?\')"
                                     image="/comun/imagenes/eliminarObj.gif"></t:commandButton>
                  </a4j:region>
                </h:column>
              </h:dataTable>
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_RegistrarParametro" for="dtParametro" fastStep="10" pageCountVar="pageCount"
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
              <h:outputText value="#{tableScroller}" escape="false"/>
              <h:outputText value="#{table}" escape="false"/>
              <h:outputText value="#{tableScroller}" escape="false"/>
            </h:panelGrid>
          </s:fieldset>
        </a4j:region>
        <h:panelGrid>
          <t:commandLink action="#{registrarParametroVerificacionQuirofanoBean.volver}" immediate="true">
            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
          </t:commandLink>
        </h:panelGrid>
      </t:panelTab>
    </t:panelTabbedPane>
    <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMensajes" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInf" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>