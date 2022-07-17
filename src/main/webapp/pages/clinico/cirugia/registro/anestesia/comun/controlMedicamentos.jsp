<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridFormulaHospitalizacionTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosAnestesiologo.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneFormulaHospitalizacion" styleClass="tabbedPane"
                     selectedIndex="#{registrarMedicamentoAnestesiaBean.selectedIndex}"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabPrescripcionHospitalizacion" label="Control Medicamentos">
      <a4j:region renderRegionOnly="false">
        <s:fieldset legend="Lista Medicamentos" id="fieldMedicamentosLista"
                    rendered="#{not empty registrarMedicamentoAnestesiaBean.lstMedicamento}" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelFormulacionTable"
                       styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0"
                           binding="#{registrarMedicamentoAnestesiaBean.dtMedicamento}" cellspacing="0"
                           value="#{registrarMedicamentoAnestesiaBean.lstMedicamento}" rows="20"
                           styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                           footerClass="paginacion" id="dtMedicamento">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Medicamento"/>
                  </f:facet>
                  <h:selectOneMenu id="mnuMedicamento" style="width:200px" disabled="true" styleClass="input-medium" 
                                   value="#{item.hmancodigvadem}">
                    <f:selectItems value="#{registrarMedicamentoAnestesiaBean.lstVademecumm}"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuMedicamento" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:selectOneMenu>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Unidad de Peso"></h:outputText>
                  </f:facet>
                    <h:selectOneMenu id="outTextPeso"
                                    value="#{item.hmacunidapeso}" styleClass="input-medium mainselection">
                        <f:selectItems value="#{registrarMedicamentoAnestesiaBean.lstUnidadesPeso}"/>
                         <a4j:outputPanel ajaxRendered="true">
                    <t:message for="outTextPeso" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                    </h:selectOneMenu>
         
                 
                 
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Inducción"/>
                  </f:facet>
                  <h:inputText id="itemInduccion" value="#{item.hmaninduccion}" styleClass="input-small"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itemInduccion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Mantenimiento "/>
                  </f:facet>
                  <h:inputText id="itemMantenimiento" value="#{item.hmanmantenimie}" styleClass="input-small"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itemMantenimiento" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Via de Administración"/>
                  </f:facet>
                  <h:selectOneMenu id="itemViaAdministracion" style="margin-left:20xp" 
                  value="#{item.hmacviaadmini}" styleClass="css-checkbox"
                  valueChangeListener="#{registrarMedicamentoAnestesiaBean.setViaAdministracion}">
                    <f:selectItems value="#{registrarMedicamentoAnestesiaBean.lstViaAdministracion}"/>
                     <a4j:support id="supportmnuViaAdministracionTable" event="onclick"
                           action="#{registrarMedicamentoAnestesiaBean.ChangeViaAdministracionTable}"
                           reRender="dtMedicamento">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itemViaAdministracion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:column>
                
                <h:column>
                  <f:facet name="header">
                  <h:panelGroup id="panelFormaAdmin" >
                    <h:outputText value="Forma Administración"/>    
                  
                  </h:panelGroup>
                  </f:facet>
                  <h:panelGroup id="panelFomaAdminiSelec">
                  <h:selectOneMenu id="itemFormaAdministracion" value="#{item.hmacformadmi}" >
                    <f:selectItems value="#{registrarMedicamentoAnestesiaBean.lstTipoIntravenosa}"/>
                     <a4j:support id="supportmnuFormaAdministracionTable" event="onclick"
                           action="#{registrarMedicamentoAnestesiaBean.ChangeFormAdministracionTable}"
                           reRender="dtMedicamento">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
                  </h:selectOneMenu>
                  </h:panelGroup>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itemFormaAdministracion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:column>
                
                
                <h:column>
                <f:facet name="header">
                <h:panelGroup id="panelVelocidadAdm">
                    <h:outputText value="Dosis Peso/Minuto"/>
                </h:panelGroup>
                </f:facet>
                <h:panelGroup id="panelInputVelocidadAdm">
                    <h:inputText id="inputVelocidadAdm" value="#{item.hmacformdosis}" style="width:40px;" />
                </h:panelGroup>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputVelocidadAdm" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:column>
                
                <h:column>
                  <f:facet name="header">
                  <h:panelGroup id="panelLocalTable">
                    <h:outputText value="Local"/>
                    </h:panelGroup>
                  </f:facet>
                  <h:panelGroup id="panelInputLocalTable">
                  <h:inputTextarea id="itemLocal" value="#{item.hmacviaadlocal}" style="width:50px;"/>
                  </h:panelGroup>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itemLocal" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Otra"/>
                  </f:facet>
                  <h:inputTextarea id="itemOtra" value="#{item.hmacviaadotra}" style="width:50px;"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itemOtra" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Total"/>
                  </f:facet>
                  <h:outputText id="itemTotal" value="#{item.hmantotalinma}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itemTotal" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:column>
                
                 <h:column>
                  <f:facet name="header">
                    <h:outputText value="Eliminar"/>
                  </f:facet>
                   <a4j:commandLink id="itemUsar"
                    action="#{registrarMedicamentoAnestesiaBean.eliminarRegistro}" reRender="dtMedicamento">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/trash.png"/>
                    </a4j:commandLink>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itemUsar" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:column>
                
                
                
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_1" for="dtMedicamento" fastStep="10" pageCountVar="pageCount"
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
      </a4j:region>
      <s:fieldset legend="Adicionar Medicamentos" id="fieldMedicamentosAdicionarMedicamento" styleClass="fieldset">
        <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelPosicion"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Medicamento Anestesico?" styleClass="labelTextOblig"/>
          <h:panelGroup id="panelMedicamentoAnes">
            <h:outputText value="Medicamento Anestesia" styleClass="labelTextOblig"
                          rendered="#{registrarMedicamentoAnestesiaBean.mostrarMedicamentoAnes}"/>
            <h:outputText value="Medicamento Adicional" styleClass="labelTextOblig"
                          rendered="#{registrarMedicamentoAnestesiaBean.mostrarMedicamentoNoAnes}"/>
          </h:panelGroup>
          <h:outputText value="Unidades de peso" styleClass="labelTextOblig"/>
          <h:outputText value="Inducción" styleClass="labelTextOblig"/>
          <h:outputText value="Mantenimiento" styleClass="labelTextOblig"/>
          <h:outputText value="Via de Administración" styleClass="labelTextOblig"/>
          <h:panelGroup id="panelAnestesia">
            <h:selectOneRadio id="mnuMedicamentoAnestesiaaa"
                              value="#{registrarMedicamentoAnestesiaBean.medicamento.hmacmedicamento}"
                              valueChangeListener="#{registrarMedicamentoAnestesiaBean.setMedicamentoAnestesia}"
                              binding="#{registrarMedicamentoAnestesiaBean.radioMedicamentoAnes}">
              <f:selectItems value="#{registrarMedicamentoAnestesiaBean.lstOpciones}"/>
              <a4j:support id="supportmnuMedicamentoAnestesiaaa" event="onclick"
                           action="#{registrarMedicamentoAnestesiaBean.ChangeMedicamentoAnestesia}"
                           reRender="panelMedicamentosAnestesicos,panelMedicamentoAnes">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:selectOneRadio>
          </h:panelGroup>
          <h:panelGroup id="panelMedicamentosAnestesicos">
            <h:panelGroup id="panelMedicamentoNoAnes">
              <a4j:commandLink action="#{registrarMedicamentoAnestesiaBean.renderMedicamentos}" immediate="true"
                               reRender="panelGridFormulaHospitalizacionTab"
                               rendered="#{registrarMedicamentoAnestesiaBean.mostrarMedicamentoNoAnes}">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputTextarea styleClass="input-large" value="#{registrarMedicamentoAnestesiaBean.medicamentoSelect}" required="false"
                        valueChangeListener="#{registrarMedicamentoAnestesiaBean.setMedicamentoo}"
                        onkeydown="return blockEnter(event);"
                                 disabled="#{formulaHospitalizacionBean.deshabilitarMedicamento}"
                           rendered="#{registrarMedicamentoAnestesiaBean.mostrarMedicamentoNoAnes}" binding="#{registrarMedicamentoAnestesiaBean.itMedicamento}"/>
            </h:panelGroup>
            <h:panelGroup id="panelCodigoVade">
              <a4j:region renderRegionOnly="false">
                <h:selectOneMenu id="mnuMedicamentoAnestesia"
                                 value="#{registrarMedicamentoAnestesiaBean.medicamento.hmancodigvadem}"
                                 rendered="#{registrarMedicamentoAnestesiaBean.mostrarMedicamentoAnes}">
                  <f:selectItems value="#{registrarMedicamentoAnestesiaBean.lstVademecum}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuMedicamentoAnestesia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </a4j:region>
            </h:panelGroup>
          </h:panelGroup>
          <h:selectOneMenu id="mnuUnidadesPeso" value="#{registrarMedicamentoAnestesiaBean.medicamento.hmacunidapeso}"
                           styleClass="input-medium">
            <f:selectItems value="#{registrarMedicamentoAnestesiaBean.lstUnidadesPeso}"/>
          </h:selectOneMenu>
          <h:panelGroup>
            <h:inputText id="itInduccion" maxlength="4"
                         value="#{registrarMedicamentoAnestesiaBean.medicamento.hmaninduccion}"
                         styleClass="input-mini"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itInduccion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:inputText id="itMantenimiento" maxlength="4"
                         value="#{registrarMedicamentoAnestesiaBean.medicamento.hmanmantenimie}"
                         styleClass="input-mini"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itMantenimiento" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup id="inputmnuViaAdministracion">
            <h:selectOneMenu id="mnuViaAdministracion"
                             value="#{registrarMedicamentoAnestesiaBean.medicamento.hmacviaadmini}"
                             styleClass="input-medium"
                             valueChangeListener="#{registrarMedicamentoAnestesiaBean.setViaAdministracion}"
                             binding="#{registrarMedicamentoAnestesiaBean.mnuViaAdministracion}">
              <f:selectItems value="#{registrarMedicamentoAnestesiaBean.lstViaAdministracion}"/>
              <a4j:support id="supportmnuViaAdministracion" event="onclick"
                           action="#{registrarMedicamentoAnestesiaBean.ChangeViaAdministracion}"
                           reRender="panelTextFormaAdmini, inputmnuFormaAdministracion,panelTextareaLocal,panelTextLocal,panelTextOtra,panelTextTareaOtra">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuViaAdministracion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText/>
          <h:panelGroup id="panelTextFormaAdmini">
            <h:outputText value="Forma de Administración" styleClass="labelTextOblig"
                          rendered="#{registrarMedicamentoAnestesiaBean.mostrarViaAdministracion}"/>
          </h:panelGroup>
          <h:panelGroup id="panelTextVeloAdmini">
            <h:outputText value="Dosis Peso/Minuto" styleClass="labelTextOblig"
                          rendered="#{registrarMedicamentoAnestesiaBean.mostrarFormAdministracion}"/>
          </h:panelGroup>
          <h:panelGroup id="panelTextLocal">
            <h:outputText value="Zona de Aplicación" styleClass="labelTextOblig"
                          rendered="#{registrarMedicamentoAnestesiaBean.mostrarLocal}"/>
          </h:panelGroup>
          <h:panelGroup id="panelTextOtra">
            <h:outputText value="Cuál?" styleClass="labelTextOblig"
                          rendered="#{registrarMedicamentoAnestesiaBean.mostrarOtra}"/>
          </h:panelGroup>
          <h:outputText/>
          <h:outputText/>
          <h:panelGroup id="inputmnuFormaAdministracion">
            <h:selectOneMenu id="mnuFormaAdministracion" 
                              rendered="#{registrarMedicamentoAnestesiaBean.mostrarViaAdministracion}"
                              value="#{registrarMedicamentoAnestesiaBean.medicamento.hmacformadmi}"
                              valueChangeListener="#{registrarMedicamentoAnestesiaBean.setFormaAdministracion}"
                              binding="#{registrarMedicamentoAnestesiaBean.radioFormaAdministracion}">
              <f:selectItems value="#{registrarMedicamentoAnestesiaBean.lstTipoIntravenosa}"/>
              <a4j:support id="supportmnuFormaAdministracion" event="onclick"
                           action="#{registrarMedicamentoAnestesiaBean.ChangeFormAdministracion}"
                           reRender="panelTextVeloAdmini,panelTextVeloAdministracion">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuFormaAdministracion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup id="panelTextVeloAdministracion">
            <h:inputText value="#{registrarMedicamentoAnestesiaBean.medicamento.hmacformdosis}"
                         rendered="#{registrarMedicamentoAnestesiaBean.mostrarFormAdministracion}"/>
          </h:panelGroup>
          <h:panelGroup id="panelTextareaLocal">
            <h:inputTextarea value="#{registrarMedicamentoAnestesiaBean.medicamento.hmacviaadlocal}"
                             rendered="#{registrarMedicamentoAnestesiaBean.mostrarLocal}"/>
          </h:panelGroup>
          <h:panelGroup id="panelTextTareaOtra">
            <h:inputTextarea value="#{registrarMedicamentoAnestesiaBean.medicamento.hmacviaadotra}"
                             rendered="#{registrarMedicamentoAnestesiaBean.mostrarOtra}"/>
          </h:panelGroup>
          <h:outputText/>
          <h:outputText/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelBotonesAgregarMedicamento" columnClasses="panelGridBotonesAgregarMeedicamento">
          <h:panelGroup>
            <a4j:commandLink id="agregarMedicamento" action="#{registrarMedicamentoAnestesiaBean.agregarMedicamento}"
                             reRender="panelGridFormulaHospitalizacionTab">
              <t:graphicImage border="0" url="/comun/imagenes/agregar_medicamento.png" width="130px" height="130px"
                              alt="Agregar"/>
            </a4j:commandLink>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="panelBotonesGuardarControlMedicamentos" columnClasses="panelGridBotonesControlMedicamentos">
        <h:panelGroup>
          <h:commandButton value="Siguiente" styleClass="btn btn btn-info medicamento"
                           action="#{registrarMedicamentoAnestesiaBean.guardarControlMedicamento}"/>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>
    <t:panelTab id="panelBuscadorMedicamentos" label="Buscar Medicamentos"
                rendered="#{registrarMedicamentoAnestesiaBean.renderBuscador}">
      <a4j:region id="regionMedicamento" renderRegionOnly="false">
        <a4j:status id="statusButton" for="regionMedicamento">
          <f:facet name="start">
            <t:div id="chargingMedicamento" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <a4j:region renderRegionOnly="false">
          <jsp:include page="/pages/clinico/comunes/buscador/buscadorMedicamentos.jsp" flush="true"/>
        </a4j:region>
        <h:panelGrid id="panelGridMedicamentosBotones" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
          <t:htmlTag value="br"/>
          <h:panelGroup id="panelGroupMedicamentosBotones1">
            <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success"
                               action="#{registrarMedicamentoAnestesiaBean.aceptarMedicamento}"
                               reRender="panelGridFormulaHospitalizacionTab">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </a4j:region>
    </t:panelTab>
  </t:panelTabbedPane>
  <h:panelGrid>
    <h:panelGroup>
      <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
        <t:htmlTag value="br"/>
        <t:messages id="msgInformationAndErrors1" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                    infoClass="informacion"/>
      </a4j:outputPanel>
    </h:panelGroup>
  </h:panelGrid>
</h:panelGrid>