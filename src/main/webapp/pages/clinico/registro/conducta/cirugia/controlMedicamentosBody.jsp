<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formControlMedicamentos">
  <a4j:region id="regionControlMedicamentos" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionControlMedicamentos">
      <f:facet name="start">
        <t:div id="chargingControlMedicamentos" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridControlMedicamentosTab" styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneControlMedicamentos" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent" selectedIndex="#{controlMedicamentosBean.selectedIndex}">
        <t:panelTab id="panelTabControlMedicamentos" label="Control Medicamentos" disabled="#{controlMedicamentosBean.renderPlantilla}">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsControlMedicamentos" styleClass="tabContainer">
            <s:fieldset legend="Datos Usuario" id="fieldSetInfoConsultarUsuarioMedicamento" styleClass="fieldset">
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoConsulta" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Tipo Identificación"/>
                <h:outputText value=" Numero Identificación"/>
                <h:outputText value="Número Usuario"/>
                <h:panelGroup>
                  <h:selectOneMenu id="tipoIde" required="true" disabled="true" value="#{controlMedicamentosBean.cirugia.hcplusuario.husetipoiden}">
                    <f:selectItems value="#{controlMedicamentosBean.listTipoIdentificacion}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="tipoIde" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="#{controlMedicamentosBean.cirugia.hcplusuario.husanumeiden}"/>
                <h:outputText id="itNumeroUsuario" value="#{controlMedicamentosBean.cirugia.hcplusuario.huslnumero}"/>
                <t:htmlTag value="br"/>
              </h:panelGrid>
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosNombre" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Primer Nombre"/>
                <h:outputText value="Segundo Nombre"/>
                <h:outputText value="Primer Apellido"/>
                <h:outputText value="Segundo Apellido"/>
                <h:panelGroup>
                  <h:outputText value="#{controlMedicamentosBean.cirugia.hcplusuario.huscprimernomb}"/>
                </h:panelGroup>
                <h:outputText value="#{controlMedicamentosBean.cirugia.hcplusuario.huscsegundnomb}"/>
                <h:panelGroup>
                  <h:outputText id="primerApellido" value="#{controlMedicamentosBean.cirugia.hcplusuario.huscprimerapel}"/>
                </h:panelGroup>
                <h:outputText value="#{controlMedicamentosBean.cirugia.hcplusuario.huscsegundapel}"/>
                <h:outputText value="Fecha Nacimiento"/>
                <h:outputText value="Edad"/>
                <h:outputText value="Sexo"/>
                <h:outputText value="Estado Civil"/>
                <h:panelGroup>
                  <h:outputText value="#{controlMedicamentosBean.cirugia.hcplusuario.husdfechanacim}"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value=""/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="radioSexo" disabled="true" value="#{controlMedicamentosBean.cirugia.hcplusuario.husesexo}">
                    <f:selectItems value="#{controlMedicamentosBean.listSexos}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="radioSexo" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="radioEstadoCivil" disabled="true" value="#{controlMedicamentosBean.cirugia.hcplusuario.huseestadcivil}">
                    <f:selectItems value="#{controlMedicamentosBean.listEstadoCivil}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="radioEstadoCivil" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Control Medicamentos" id="fieldCOntrolMedicamentos" styleClass="fieldset">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridControlMedicamentos" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Nombre Medicamento " styleClass="labelTextOblig"/>
                <h:outputText value="Presentacion " styleClass="labelTextOblig"/>
                <h:outputText value="Dosis " styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:outputText value="#{controlMedicamentosBean.formula.hfhcmedicament}"/>
                <h:outputText value="#{controlMedicamentosBean.formula.hfhcpresentaci}"/>
                <h:outputText value="#{controlMedicamentosBean.formula.hfhcadosis}"/>
                <h:outputText value=""/>
                <h:outputText value="Frecuencia(Horas)  " styleClass="labelTextOblig"/>
                <h:outputText value="Vía " styleClass="labelTextOblig"/>
                <h:outputText value="Forma "/>
                <h:outputText/>
                <h:outputText value="#{controlMedicamentosBean.formula.hfhnfrecuadmin}"/>
                <h:outputText value="#{controlMedicamentosBean.formula.hfhcviadministr}"/>
                <h:outputText value="#{controlMedicamentosBean.formula.hfhcformaadmin}"/>
                <h:outputText/>
                <h:outputText value="Administro Medicamento" styleClass="labelTextOblig"/>
                <h:outputText value="Lote - Fecha de vencimiento" styleClass="labelTextOblig"/>
                <h:outputText />
                <h:outputText/>                 
                <h:panelGroup>
                  <h:selectOneRadio id="mnuAdmnistroMedicamento" required="true" immediate="true" value="#{controlMedicamentosBean.administroSelect}"
                                    valueChangeListener="#{controlMedicamentosBean.setAdministroSelect}" styleClass="labelRadio">
                    <f:selectItems value="#{controlMedicamentosBean.lstOpciones}"/>
                    <a4j:support id="supportmnuAdministracion" event="onclick" immediate="true" action="#{controlMedicamentosBean.ChangeMedicamento}"
                                 reRender="panelTextFecha,panelCalendarAdministracion,itTextDosisSuministrada,itInputDosisSuministrada,panelTextHoraActual,panelMenuHoraActual">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuAdmnistroMedicamento" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuLote" value="#{controlMedicamentosBean.loteSelect}" required="true"
                                   valueChangeListener="#{controlMedicamentosBean.setLoteSelect}" immediate="false">
                    <f:selectItems value="#{controlMedicamentosBean.listLote}" />
                    <a4j:support id="supportLote" event="onchange" action="#{controlMedicamentosBean.ChangeLote}"
                                 reRender="panelfecven" immediate="true">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuLote" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText />
                <h:outputText />
                <h:panelGroup id="panelTextHoraActual">
                  <h:outputText value="El medicamento acaba de ser administrado?" styleClass="labelTextOblig" rendered="#{controlMedicamentosBean.mostrarMedicamento}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextFecha">
                  <h:outputText value="Hace cuantos (MINUTOS) fue administrado?" styleClass="labelTextOblig" rendered="#{controlMedicamentosBean.renderHoraActual}"/>
                </h:panelGroup>
                <h:outputText />
                <h:outputText />
                <h:panelGroup id="panelMenuHoraActual">
                  <h:selectOneRadio id="mnuHoraActual" required="true" immediate="true" rendered="#{controlMedicamentosBean.mostrarMedicamento}" value="#{controlMedicamentosBean.esHoraActual}"
                                    valueChangeListener="#{controlMedicamentosBean.setEsHoraActual}" styleClass="labelRadio">
                    <f:selectItems value="#{controlMedicamentosBean.lstOpciones}"/>
                    <a4j:support id="supportmnuHoraActual" event="onclick" immediate="true" action="#{controlMedicamentosBean.ChangeEsHoraActual}"
                                 reRender="panelTextFecha,panelCalendarAdministracion,itTextDosisSuministrada,itInputDosisSuministrada">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuHoraActual" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelCalendarAdministracion">
                  <h:inputText id="minutosAdministracion" required="true" maxlength="3" style="width:50px" value="#{controlMedicamentosBean.tiempoAdministracion}"
                               rendered="#{controlMedicamentosBean.renderHoraActual}"/>
                  <a4j:outputPanel ajaxRendered="true" rendered="#{controlMedicamentosBean.renderHoraActual}">
                    <t:message for="minutosAdministracion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup/>
                <h:panelGrid></h:panelGrid>
              </h:panelGrid>
              <a4j:region renderRegionOnly="false">
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridNotaEnfermeria" rowClasses="labelText,labelTextInfo">
                  <h:outputText value="Nota Enfermeria" styleClass="labelTextOblig"/>
                  <h:outputText value=""/>
                  <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
                    <a4j:commandLink action="#{controlMedicamentosBean.mostrarBuscadorPlantilla}" immediate="true" reRender="panelGridControlMedicamentosTab">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                    </a4j:commandLink>
                    <h:inputTextarea id="textNotaEnfermeria" required="true" onkeydown="return blockEnter(event);" immediate="true" binding="#{controlMedicamentosBean.itDescripcion}"
                                     value="#{controlMedicamentosBean.nota.hnecnotaenferm}" style="width:500px;height:60px"/>
                  </h:panelGrid>
                  <a4j:outputPanel ajaxRendered="true" rendered="#{controlMedicamentosBean.renderHoraActual}">
                    <t:message for="minutosAdministracion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <h:panelGrid></h:panelGrid>
                </h:panelGrid>
              </a4j:region>
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar" columnClasses="panelGridBotones">
                <t:htmlTag value="br"/>
                <h:panelGroup id="panelGroupCirugiaBotones1">
                  <h:commandButton value="Guardar" styleClass="btn btn btn-success" action="#{controlMedicamentosBean.registrarContolMedicamentos}"></h:commandButton>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionControlMedicamentosMsg" ajaxRendered="true">
                  <t:messages id="msgInformationControlMedicamentosSSMsg" showSummary="true" errorClass="error" globalOnly="true" layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
        </t:panelTab>
        <t:panelTab id="panelBuscadorPlantillaNotaEnfermeria" label="Buscar Plantillas" rendered="#{controlMedicamentosBean.renderPlantilla}">
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
            <h:panelGrid id="panelGridBuscadorBotonesPlantillaNotaEnfermeria" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
              <t:htmlTag value="br"/>
            </h:panelGrid>
          </a4j:region>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>