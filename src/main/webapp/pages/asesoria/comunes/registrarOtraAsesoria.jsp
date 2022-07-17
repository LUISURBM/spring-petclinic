<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridRegistrarOtraAsesoriaTab" styleClass="tabContainer">
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneDatosOtraAsesoria" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     selectedIndex="#{registrarOtraAsesoriaBean.selectedIndex}" inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabDatosOtraAsesoria" label="Datos Usuario(a)" rendered="#{!registrarOtraAsesoriaBean.renderSelecionarUsuario}">
      <a4j:commandLink action="#{registrarOtraAsesoriaBean.resetDatos}" immediate="true" reRender="panelGridRegistrarOtraAsesoriaTab" title="Registrar Nuevo Usuario(a)">
        <t:graphicImage alt="Registrar Nuevo Usuario(a)" title="Registrar Nuevo Usuario(a)" border="0" url="/comun/imagenes/nuevo.jpg"/>
      </a4j:commandLink>
      <s:fieldset legend="Datos Basicos Usuario(a) " id="fieldSetInfoBasicaOtraAsesoria" styleClass="fieldset">
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoOtraAsesoria" rowClasses="labelText,labelTextInfo">
          <h:outputText value="Tipo Identificación" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value=" Número Identificación" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText/>
          <h:outputText value=""/>
          <h:panelGroup>
            <h:outputText rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          </h:panelGroup>
          <h:outputText value=""/>
          <h:selectOneMenu id="tipoIdeOtraAsesoria" disabled="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"
                           value="#{registrarOtraAsesoriaBean.asesoria.hasetipoiden}" onkeydown="return blockEnter(event);">
            <f:selectItems value="#{registrarOtraAsesoriaBean.listTipoIdentificacion}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="tipoIdeOtraAsesoria" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
            <a4j:commandButton value="Buscar" disabled="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}" action="#{registrarOtraAsesoriaBean.buscadorUsuario}"
                               reRender="panelGridRegistrarOtraAsesoriaTab" image="/comun/imagenes/lupita.png"/>
            <h:inputText id="itNumeroIdentificacionOtraAsesoria" maxlength="15" disabled="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"
                         value="#{registrarOtraAsesoriaBean.asesoria.hasanumeiden}" onkeydown="return blockEnter(event);"/>
          </h:panelGrid>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="itNumeroIdentificacionOtraAsesoria" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value="Nombre y Apellidos" styleClass="labelTextOblig" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <h:inputText id="primerNombreOtraAsesoria" onkeydown="return blockEnter(event);" maxlength="80" style="width:400px"
                       rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}" disabled="#{registrarOtraAsesoriaBean.renderUsuario}"
                       value="#{registrarOtraAsesoriaBean.asesoria.hascprimernomb}"></h:inputText>
          <a4j:outputPanel ajaxRendered="true" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <t:message for="primerNombreOtraAsesoria" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value="Edad" styleClass="labelTextOblig" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="Sexo" styleClass="labelTextOblig" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <h:panelGroup id="panelEdadOtraAsesoria">
            <h:inputText id="inputEdadOtraAsesoria" onkeydown="return blockEnter(event);" maxlength="4"
                         rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}" value="#{registrarOtraAsesoriaBean.asesoria.hasnedad}"/>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
              <t:message for="inputEdadOtraAsesoria" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value=""/>
          <h:selectOneMenu id="radioSexoOtraAsesoria" onkeydown="return blockEnter(event);" required="true"
                           rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}" value="#{registrarOtraAsesoriaBean.asesoria.hasesexo}">
            <f:selectItems value="#{registrarOtraAsesoriaBean.listSexos}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <t:message for="radioSexoOtraAsesoria" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
        <h:panelGrid columns="4" border="0" width="100%" id="panelDatosdeDiscapacidad">
          <h:outputText value="Discapacidad" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:panelGroup id="panelTipoDiscapacidad1" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <h:outputText value="Tipos de Discapacidad" rendered="#{registrarOtraAsesoriaBean.renderDiscapacidad}" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:outputText value=""/>
          <h:selectOneRadio id="radioDiscapacidad" value="#{registrarOtraAsesoriaBean.asesoria.hascdicapadad}" valueChangeListener="#{registrarOtraAsesoriaBean.setHascdicapadad}" immediate="true"
                            rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <f:selectItem itemValue="S" itemLabel="SI"/>
            <f:selectItem itemValue="N" itemLabel="NO"/>
            <a4j:support id="supportmnumnuDiscapacidad" action="#{registrarOtraAsesoriaBean.changeDiscapacidad}" reRender="panelTipoDiscapacidad1,panelDiscapaci" event="onclick" immediate="true">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
          </h:selectOneRadio>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="radioDiscapacidad" styleClass="errorMessage" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          </a4j:outputPanel>
          <h:panelGroup id="panelDiscapaci" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <h:selectOneMenu id="panelDiscapacidad" rendered="#{registrarOtraAsesoriaBean.renderDiscapacidad}" immediate="true" value="#{registrarOtraAsesoriaBean.asesoria.hascdiscaselec}">
              <f:selectItems value="#{registrarOtraAsesoriaBean.lstDiscapacidad}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="panelDiscapacidad" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value=""/>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Asesoría " id="fieldSetSeleccionarOtraAsesoria" styleClass="fieldset" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
        <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionSeleccionarOtraAsesoria" styleClass="labelTextInfo"
                     rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
          <h:panelGroup style="border-style:none;font-size:10px" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <a4j:region renderRegionOnly="false">
              <h:selectBooleanCheckbox id="checkPlanificacionTemporalOtraAsesoria" onkeydown="return blockEnter(event);" immediate="true"
                                       value="#{registrarOtraAsesoriaBean.renderPlanificacionTemporal}"></h:selectBooleanCheckbox>
            </a4j:region>
            <h:outputText value="  Anticoncepción temporal   "/>
          </h:panelGroup>
          <a4j:outputPanel ajaxRendered="true" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <t:message for="checkPlanificacionTemporalOtraAsesoria" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:panelGroup style="border-style:none;font-size:10px" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <h:selectBooleanCheckbox id="checkPlanificacionDefinitivaOtraAsesoria" onkeydown="return blockEnter(event);" value="#{registrarOtraAsesoriaBean.renderPlanificacionDefinitiva}"/>
            <h:outputText value="  Anticoncepción permanente "/>
          </h:panelGroup>
          <h:outputText rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <h:panelGroup style="border-style:none;font-size:10px" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <h:selectBooleanCheckbox id="checkIlveOtraAsesoria" onkeydown="return blockEnter(event);" value="#{registrarOtraAsesoriaBean.renderIlve}"/>
            <h:outputText value="  IVE "/>
          </h:panelGroup>
          <h:outputText rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <h:panelGroup style="border-style:none;font-size:10px" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <h:selectBooleanCheckbox id="checkSexualidadOtraAsesoria" onkeydown="return blockEnter(event);" value="#{registrarOtraAsesoriaBean.renderSexualidad}"/>
            <h:outputText value="  Sexualidad y alteraciones relacionadas con el ejercicio  "/>
          </h:panelGroup>
          <h:outputText rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <h:panelGroup style="border-style:none;font-size:10px" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <h:selectBooleanCheckbox id="checkPruebaVIHOtraAsesoria" onkeydown="return blockEnter(event);" value="#{registrarOtraAsesoriaBean.renderVih}"/>
            <h:outputText value="  Pre y Pos VIH   "/>
          </h:panelGroup>
          <h:outputText rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <h:panelGroup style="border-style:none;font-size:10px" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <h:selectBooleanCheckbox id="checkITSOtraAsesoria" onkeydown="return blockEnter(event);" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"
                                     value="#{registrarOtraAsesoriaBean.renderIts}"/>
            <h:outputText value="  ITS  "/>
          </h:panelGroup>
          <h:outputText rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <h:panelGroup style="border-style:none;font-size:10px">
            <h:selectBooleanCheckbox id="checkFisica" onkeydown="return blockEnter(event);" value="#{registrarOtraAsesoriaBean.existeVioFisica}"/>
            <h:outputText value="  Violencia Fisica "/>
          </h:panelGroup>
          <h:outputText/>
          <h:panelGroup style="border-style:none;font-size:10px" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <h:selectBooleanCheckbox id="checkPsicologica" onkeydown="return blockEnter(event);" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"
                                     value="#{registrarOtraAsesoriaBean.existeVioPsicologica}"/>
            <h:outputText value="  Violencia Psicologica "/>
          </h:panelGroup>
          <h:outputText rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <h:panelGroup style="border-style:none;font-size:10px" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <h:selectBooleanCheckbox id="checkSexual" onkeydown="return blockEnter(event);" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"
                                     value="#{registrarOtraAsesoriaBean.existeVioSexual}"/>
            <h:outputText value="  Violencia Sexual "/>
          </h:panelGroup>
          <h:outputText rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <h:panelGroup style="border-style:none;font-size:10px" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <h:selectOneRadio id="itResultadoEmbarazoAsesoria" value="#{registrarOtraAsesoriaBean.asesoria.haseresulembar}">
              <f:selectItems value="#{registrarOtraAsesoriaBean.lstResultadoEmbarazo}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
              <t:message for="itResultadoEmbarazoAsesoria" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="  Prueba de Embarazo (resultado)  "/>
          </h:panelGroup>
          <h:outputText rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup style="border-style:none;font-size:10px" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
              <h:selectBooleanCheckbox id="checkOtroOtraAsesoria" onkeydown="return blockEnter(event);" value="#{registrarOtraAsesoriaBean.renderOtro}"
                                       valueChangeListener="#{registrarOtraAsesoriaBean.setRenderOtro}">
                <a4j:support id="supportcheckOtroOtraAsesoria" event="onclick" reRender="panelTextCual">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
              <h:outputText value="  Otro  "/>
            </h:panelGroup>
          </a4j:region>
          <h:panelGrid id="panelTextCual" columns="1" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <h:outputText value="Cuál? " styleClass="labelTextOblig" rendered="#{registrarOtraAsesoriaBean.renderOtro}"/>
            <h:inputText id="itCualOtroOtraAsesoria" rendered="#{registrarOtraAsesoriaBean.renderOtro}" onkeydown="return blockEnter(event);" maxlength="30" required="true"
                         value="#{registrarOtraAsesoriaBean.asesoria.hasccualotro}"></h:inputText>
          </h:panelGrid>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Se envía a: " id="fieldSetSeleccionarEnvia" styleClass="fieldset" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
        <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionSeleccionarEnvia" styleClass="labelTextInfo"
                     rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
          <h:panelGroup style="border-style:none;font-size:10px" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <h:selectBooleanCheckbox id="checkEnviaTemporal" onkeydown="return blockEnter(event);" value="#{registrarOtraAsesoriaBean.renderEnviaTemporal}"/>
            <h:outputText value="  Anticoncepción temporal "/>
          </h:panelGroup>
          <h:outputText rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <h:panelGroup style="border-style:none;font-size:10px" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <h:selectBooleanCheckbox id="checkEnviaDefinitiva" onkeydown="return blockEnter(event);" value="#{registrarOtraAsesoriaBean.renderEnviaDefinitiva}"/>
            <h:outputText value="  Anticoncepción permanente "/>
          </h:panelGroup>
          <h:outputText rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <h:panelGroup style="border-style:none;font-size:10px" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <h:selectBooleanCheckbox id="checkEnviaGeneral" onkeydown="return blockEnter(event);" value="#{registrarOtraAsesoriaBean.renderEnviaGeneral}"/>
            <h:outputText value="  Consulta medicina general "/>
          </h:panelGroup>
          <h:outputText rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <h:panelGroup style="border-style:none;font-size:10px" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <h:selectBooleanCheckbox id="checkEnviaEspecializada" onkeydown="return blockEnter(event);" value="#{registrarOtraAsesoriaBean.renderEnviaEspecial}"/>
            <h:outputText value="  Consulta medicina Especializada "/>
          </h:panelGroup>
          <h:outputText rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <h:panelGroup style="border-style:none;font-size:10px" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <h:selectBooleanCheckbox id="checkEnviaLaboratorio" onkeydown="return blockEnter(event);" value="#{registrarOtraAsesoriaBean.renderEnviaLaboratorio}"/>
            <h:outputText value="  laboratorio clínico "/>
          </h:panelGroup>
          <h:outputText rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <h:panelGroup style="border-style:none;font-size:10px" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <h:selectBooleanCheckbox id="checkEnviaProductos" onkeydown="return blockEnter(event);" value="#{registrarOtraAsesoriaBean.renderEnviaProductos}"/>
            <h:outputText value="  Productos "/>
          </h:panelGroup>
          <h:outputText rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"/>
          <h:panelGroup style="border-style:none;font-size:10px" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
            <h:selectBooleanCheckbox id="checkEnviaPsicologia" onkeydown="return blockEnter(event);" value="#{registrarOtraAsesoriaBean.renderPsicologia}"/>
            <h:outputText value="  Consulta de Psicología "/>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Observaciones " id="fieldSetObservacionesOtraAsesoria" styleClass="fieldset"
                  rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionObservacionesOtraAsesoria" styleClass="labelTextInfo"
                     rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}">
          <h:outputText value="Observaciones"/>
          <h:outputText value=""/>
          <h:inputTextarea id="textObservaciones" style="width:650px;height:70px" value="#{registrarOtraAsesoriaBean.asesoria.hascobservacio}">
            
          </h:inputTextarea>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="textObservaciones" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
      </s:fieldset>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMessagesatributoOtraAsesoria" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsOtraAsesoria" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                      warnClass="advertencia"/>
          <t:htmlTag value="br"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificarOtraAsesoria" columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar" styleClass="btn btn btn-success" rendered="#{registrarOtraAsesoriaBean.renderUsuario || registrarOtraAsesoriaBean.renderRegistrar}"
                           action="#{registrarOtraAsesoriaBean.guardarUsuario}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>
    <t:panelTab id="panelTabSeleccionarUsuarioOtraAsesoria" label="Seleccionar Usuario" rendered="#{registrarOtraAsesoriaBean.renderSelecionarUsuario}">
      <s:fieldset legend="Usuarios" id="fieldSetSeleccionarUsuarioOtraAsesoria" styleClass="fieldset_dataTable">
        <h:panelGrid columns="1" id="panelGridSeleccionarUsuarioOtraAsesoria" rendered="#{empty registrarOtraAsesoriaBean.lstUsuarios}">
          <h:outputText value="#{msg.msg_sin_consultar}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentSeleccionarUsuarioOtraAsesoria" rendered="#{not empty registrarOtraAsesoriaBean.lstUsuarios}"
                     styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" binding="#{registrarOtraAsesoriaBean.dtConsultaUsuario}" value="#{registrarOtraAsesoriaBean.lstUsuarios}" rows="10"
                         styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtSeleccionarOtraAsesoria">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Numero Documento"/>
                </f:facet>
                <h:outputText value="#{item.husetipoiden} #{item.husanumeiden}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Nombre"/>
                </f:facet>
                <h:outputText value="#{item.huscprimernomb} #{item.huscsegundnomb} #{item.huscprimerapel} #{item.huscsegundapel}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha de Nacimiento"/>
                </f:facet>
                <h:outputText value="#{item.husdfechanacim}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Numero de Usuario"/>
                </f:facet>
                <h:outputText value="#{item.huslnumero}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Seleccione"/>
                </f:facet>
                <h:commandLink id="aceptar" action="#{registrarOtraAsesoriaBean.agregarUsuario}">
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/adicionar.gif"/>
                </h:commandLink>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_1" for="dtSeleccionarOtraAsesoria" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" paginatorMaxPages="9"
                              paginatorTableClass="paginator" renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
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
      <s:fieldset legend="Usuario Seleccionado" id="fieldUsuarioSeleccOtraAsesoria" styleClass="fieldset">
        <h:outputText value="#{registrarOtraAsesoriaBean.usuario.huscprimernomb} #{registrarOtraAsesoriaBean.usuario.huscsegundnomb}  #{registrarOtraAsesoriaBean.usuario.huscprimerapel}  #{registrarOtraAsesoriaBean.usuario.huscsegundapel}"
                      escape="false"/>
      </s:fieldset>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonSeleccionarUsuarioOtraAsesoria" columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Seleccionar Usuario" styleClass="boton_fieldset" action="#{registrarOtraAsesoriaBean.seleccionarUsuario}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>