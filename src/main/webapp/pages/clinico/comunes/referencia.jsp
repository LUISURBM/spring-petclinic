<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridReferenciaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneReferencia" styleClass="tabbedPane" activeTabStyleClass="activeTab"
                     inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                     selectedIndex="#{referenciaUsuarioBean.selectedIndex}" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabReferencia" label="Referencia">
      <a4j:region renderRegionOnly="false">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridReferencia"
                     styleClass="tabContainer">
          <s:fieldset legend="Referencia" id="fieldReferencia" styleClass="fieldset">
            <s:fieldset legend="Responsable" id="fieldReferenciaResponsable" styleClass="fieldset">
              <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosReferencia1" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Nombre Responsable" styleClass="labelTextOblig"/>
                <h:outputText/>
                <h:outputText/>
                <h:outputText/>
                <h:outputText/>
                <h:outputText/>
                <h:panelGroup>
                  <h:inputText id="itNombreResponsable" immediate="true" required="true"
                               onkeydown="return blockEnter(event);" maxlength="40"
                               disabled="#{referenciaUsuarioBean.modoconsulta}"
                               value="#{referenciaUsuarioBean.referencia.hrecnombrespon}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itNombreResponsable" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText/>
                <h:outputText/>
                <h:outputText/>
                <h:outputText/>
                <h:outputText value="Tipo Identificaci�n" styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:outputText value=" N�mero Identificaci�n" styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:outputText/>
                <h:outputText/>
                <h:selectOneMenu id="tipoIde" required="true" immediate="true"
                                 disabled="#{referenciaUsuarioBean.modoconsulta}"
                                 value="#{referenciaUsuarioBean.referencia.hreetipideresp}"
                                 onkeydown="return blockEnter(event);">
                  <f:selectItems value="#{referenciaUsuarioBean.listTipoIdentificacion}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="tipoIde" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:inputText id="itNumeroIdentificacion" maxlength="15" required="true" immediate="true"
                             disabled="#{referenciaUsuarioBean.modoconsulta}"
                             value="#{referenciaUsuarioBean.referencia.hreanumideresp}"></h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itNumeroIdentificacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText/>
                <h:outputText/>
                <h:outputText value="Direcci�n Responsable" styleClass="labelTextOblig"/>
                <h:outputText/>
                <h:outputText value="Telefono Responsable" styleClass="labelTextOblig"/>
                <h:outputText/>
                <h:outputText value="Celular Responsable" styleClass="labelTextOblig"/>
                <h:outputText/>
                <h:panelGroup>
                  <h:inputText id="itDirResponsable" immediate="true" required="true" maxlength="40"
                               onkeydown="return blockEnter(event);" disabled="#{referenciaUsuarioBean.modoconsulta}"
                               value="#{referenciaUsuarioBean.referencia.hrecdirecrespo}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itDirResponsable" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup>
                  <h:inputText id="itTelResponsable" required="true" immediate="true"
                               onkeydown="return blockEnter(event);" maxlength="20"
                               disabled="#{referenciaUsuarioBean.modoconsulta}"
                               value="#{referenciaUsuarioBean.referencia.hrectelefrespo}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itTelResponsable" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup>
                  <h:inputText id="itCelResponsable" immediate="true" required="true"
                               onkeydown="return blockEnter(event);" maxlength="20"
                               disabled="#{referenciaUsuarioBean.modoconsulta}"
                               value="#{referenciaUsuarioBean.referencia.hreccelulrespo}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCelResponsable" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="Departamento" styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:outputText value="Municipio" styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:outputText/>
                <h:outputText/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneMenu id="menuDepartamentos" onkeydown="return blockEnter(event);" immediate="true"
                                   disabled="#{referenciaUsuarioBean.modoconsulta}" required="true"
                                   value="#{referenciaUsuarioBean.referencia.hrendeparrespo}"
                                   valueChangeListener="#{referenciaUsuarioBean.setDepartamentoSelect}">
                    <f:selectItems value="#{referenciaUsuarioBean.listDepartamentos}"/>
                    <a4j:support id="support7" action="#{referenciaUsuarioBean.changeCiudad}" reRender="panelCiudad"
                                 event="onchange">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="menuDepartamentos" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelCiudad">
                  <h:selectOneMenu id="menuCiudad" onkeydown="return blockEnter(event);" required="true"
                                   immediate="true" disabled="#{referenciaUsuarioBean.modoconsulta}"
                                   value="#{referenciaUsuarioBean.referencia.hrenciudarespo}">
                    <f:selectItems value="#{referenciaUsuarioBean.listMunicipios}"/>
                  </h:selectOneMenu>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="menuCiudad" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText/>
                <h:outputText/>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Datos Referencia " id="fieldRef" styleClass="fieldset">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosReferencia2" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Servicio donde se encuentra el paciente" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:inputText id="textServicioSolicitaEncuentra" required="true" immediate="true"
                               disabled="#{referenciaUsuarioBean.modoconsulta}"
                               value="#{referenciaUsuarioBean.referencia.hrecserviencu}" style="width:300px"
                               onkeydown="return blockEnter(event);" maxlength="120"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="textServicioSolicitaEncuentra" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Servicio que se solicita" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:inputText id="textServicioSolicita" required="true" immediate="true"
                               disabled="#{referenciaUsuarioBean.modoconsulta}"
                               value="#{referenciaUsuarioBean.referencia.hrecservisolic}" style="width:300px"
                               onkeydown="return blockEnter(event);" maxlength="40"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="textServicioSolicita" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Anamnesis" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:inputTextarea id="textAnamnesis" required="true" immediate="true"
                                   disabled="#{referenciaUsuarioBean.modoconsulta}"
                                   value="#{referenciaUsuarioBean.referencia.hrecanamnesis}" style="width:600px"
                                   onkeydown="return blockEnter(event);"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="textAnamnesis" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Examen Fisico" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:inputTextarea id="textExamenFisico" required="true" immediate="true"
                                   disabled="#{referenciaUsuarioBean.modoconsulta}"
                                   value="#{referenciaUsuarioBean.referencia.hrecexamfisc}" style="width:600px"
                                   onkeydown="return blockEnter(event);"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="textExamenFisico" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Examenes de Apoyo Diagnostico" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:inputTextarea id="textApoyoDiagnostico" required="true" immediate="true"
                                   disabled="#{referenciaUsuarioBean.modoconsulta}"
                                   value="#{referenciaUsuarioBean.referencia.hrecapoyodiagn}" style="width:600px"
                                   onkeydown="return blockEnter(event);"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="textApoyoDiagnostico" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Evoluci�n" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:inputTextarea id="textJustificacion" required="true" immediate="true"
                                   disabled="#{referenciaUsuarioBean.modoconsulta}"
                                   value="#{referenciaUsuarioBean.referencia.hrecjustirefer}" style="width:600px"
                                   onkeydown="return blockEnter(event);"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="textJustificacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Diagnostico" styleClass="labelTextOblig"/>
                <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" id="panelDiagnostico">
                  <a4j:commandLink immediate="true" action="#{referenciaUsuarioBean.mostrarDiagnostico}"
                                   reRender="panelGridReferenciaTab">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                  </a4j:commandLink>
                  <h:inputText id="itDiagnostico" onkeydown="return blockEnter(event);" styleClass="textmayuscula"
                               value="#{referenciaUsuarioBean.referencia.hrecdiagnosti}"
                               valueChangeListener="#{referenciaUsuarioBean.setHrecdiagnosti}" style="width:50px"
                               maxlength="4" disabled="#{referenciaUsuarioBean.modoconsulta}"
                               binding="#{referenciaUsuarioBean.inputDiagnostico}">
                    <f:converter converterId="cadena.stringUpperCaseConverter"/>
                    <a4j:support id="supportDiagnostico" event="onchange"
                                 action="#{referenciaUsuarioBean.changeDiagnostico}" reRender="panelDiagnostico">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itDiagnostico" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:inputText>
                  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnostico1">
                    <h:outputText value="#{referenciaUsuarioBean.diagnostico}" styleClass="buscador"/>
                  </h:panelGrid>
                </h:panelGrid>
                <h:outputText value="Complicaciones" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:inputTextarea id="textComplicaciones" required="true" immediate="true"
                                   disabled="#{referenciaUsuarioBean.modoconsulta}"
                                   value="#{referenciaUsuarioBean.referencia.hreccomplicaci}" style="width:600px"
                                   onkeydown="return blockEnter(event);"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="textComplicaciones" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Tratamientos Aplicados" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:inputTextarea id="textTratamientosAplicados" required="true" immediate="true"
                                   disabled="#{referenciaUsuarioBean.modoconsulta}"
                                   value="#{referenciaUsuarioBean.referencia.hrectrataaplic}" style="width:600px"
                                   onkeydown="return blockEnter(event);"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="textTratamientosAplicados" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Motivo de Remisi�n" styleClass="labelTextOblig" />
                <h:panelGroup>
                  <h:inputTextarea id="textMotivoRemision" required="true" immediate="true"
                                   disabled="#{referenciaUsuarioBean.modoconsulta}"
                                   value="#{referenciaUsuarioBean.referencia.hrecmotivremis}" style="width:600px"
                                   onkeydown="return blockEnter(event);"/>
                  <a4j:outputPanel ajaxRendered="true" rendered="#{referenciaUsuarioBean.renderHistoriasValidas}">
                    <t:message for="textMotivoRemision" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                  <h:outputText value="Morbilidad Materna Extrema" styleClass="labelTextOblig" rendered="#{referenciaUsuarioBean.renderHistoriasValidas}"/>
                  <a4j:region renderRegionOnly="false">
                    <h:panelGroup>
                      <h:selectOneRadio id="radioMorbilidad" required="true" immediate="true"
                                        onkeydown="return blockEnter(event);"
                                        value="#{referenciaUsuarioBean.referencia.hrecmormatext}"
                                        rendered="#{referenciaUsuarioBean.renderHistoriasValidas}"
                                        valueChangeListener="#{referenciaUsuarioBean.setHrecmormatext}">
                        <f:selectItems value="#{registrarNotaEnfermeriaBean.lstOpciones}"/>
                        <a4j:support id="supportRadioMorbilidad" event="onclick" reRender="panelTextMedico,panelMedAutTras,textMedico"
                                     action="#{referenciaUsuarioBean.changeMorbilidad}">
                          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                      </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true"  rendered="#{referenciaUsuarioBean.renderHistoriasValidas}">
                    <t:message for="radioMorbilidad" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                    </h:panelGroup>
                  </a4j:region>
                </h:panelGrid>
                <h:panelGroup id="panelTextMedico">
                <h:outputText id="textMedico" value="Medico que autoriza el traslado" styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGrid columns="2" border="0" cellpadding="1" cellspacing="1" columnClasses="labelTextInfo" id="panelMedAutTras">
              <a4j:commandLink action="#{referenciaUsuarioBean.mostrarBuscadorProfesional}" 
                               reRender="panelGridReferenciaTab" immediate="true">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputText id="itMedico" disabled="true"
                           value="#{referenciaUsuarioBean.referencia.hrenmedauttra}" style="width:100px"/>
            </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Lista de Chequeo " id="fieldListaChequeo" styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelListaChequeo"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="1. El m�dico diligencia el formato de referencia de pacientes, de manera completa y legible"
                              styleClass="labelTextOblig"/>
                <h:outputText/>
                <h:selectOneRadio id="mnuDiligenciaFormato" immediate="true"
                                  disabled="#{referenciaUsuarioBean.modoconsulta}"
                                  value="#{referenciaUsuarioBean.referencia.hrecdiligforma}"
                                  onkeydown="return blockEnter(event);">
                  <f:selectItems value="#{referenciaUsuarioBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuDiligenciaFormato" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="2. Se adjunta copia de la historia cl�nica del paciente (de la atenci�n actual)"
                              styleClass="labelTextOblig"/>
                <h:outputText/>
                <h:selectOneRadio id="mnuCopiaHisto" immediate="true" disabled="#{referenciaUsuarioBean.modoconsulta}"
                                  value="#{referenciaUsuarioBean.referencia.hreccopiahisto}" required="true">
                  <f:selectItems value="#{referenciaUsuarioBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuCopiaHisto" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="3. Se anexan los resultados de los apoyos diagn�sticos tomados con ocasi�n de la atenci�n actual"
                              styleClass="labelTextOblig"/>
                <h:outputText/>
                <h:selectOneRadio id="mnuResulApoyo" immediate="true" disabled="#{referenciaUsuarioBean.modoconsulta}"
                                  value="#{referenciaUsuarioBean.referencia.hrecresulapoyo}" required="true">
                  <f:selectItems value="#{referenciaUsuarioBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuResulApoyo" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup>
                  <h:outputText value="4. Se entrega carta de intenci�n de pago (firmada por el director del centro) "
                                styleClass="labelTextOblig"/>
                  <h:outputText value="en caso que el paciente deba ser trasladao a la IPS contratada por Profamilia"/>
                </h:panelGroup>
                <h:outputText/>
                <h:selectOneRadio id="mnuCartaPago" immediate="true" disabled="#{referenciaUsuarioBean.modoconsulta}"
                                  value="#{referenciaUsuarioBean.referencia.hreccartapago}" required="true">
                  <f:selectItems value="#{referenciaUsuarioBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuCartaPago" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </s:fieldset>
          </s:fieldset>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionReferenciaMsg" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgReferenciaMsg" showSummary="false" errorClass="error" globalOnly="true" layout="table"
                          infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
              <t:htmlTag value="br"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesControl"
                       columnClasses="panelGridBotones">
            <a4j:commandButton value="Generar Referencia" styleClass="btn btn btn-success"
                               reRender="panelGridReferenciaTab" action="#{referenciaUsuarioBean.generarReferencia}"/>
          </h:panelGrid>
        </h:panelGrid>
      </a4j:region>
      <f:subview id="generarReferencia" rendered="#{referenciaUsuarioBean.generoReferencia}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
        </f:verbatim>
      </f:subview>
    </t:panelTab>
    <t:panelTab id="panelBuscador" label="Buscar Diagnosticos" rendered="#{referenciaUsuarioBean.mostrarCie10}">
      <a4j:region id="regionCie10" renderRegionOnly="false">
        <a4j:status id="statusButton" for="regionCie10">
          <f:facet name="start">
            <t:div id="chargingCie10" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <jsp:include page="/pages/clinico/registro/buscadorCie10.jsp" flush="true"/>
        <h:panelGrid id="panelGridCie10Botones" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
          <t:htmlTag value="br"/>
          <h:panelGroup id="panelGroupCie10Botones1">
            <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success"
                               action="#{referenciaUsuarioBean.aceptarDiagnostico}" reRender="panelGridReferenciaTab">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </a4j:region>
    </t:panelTab>
    <t:panelTab id="panelBuscarPofesional" label="Buscar Profesional"
                  rendered="#{referenciaUsuarioBean.renderProfesional}">
        <a4j:region id="regionBuscadorUsuProfesional" renderRegionOnly="false">
          <a4j:status for="regionBuscadorUsuProfesional">
            <f:facet name="start">
              <t:div id="chargingBuscUsuProfesional" styleClass="loading">
                <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                  <h:outputText value="Procesando..."/>
                  <h:outputText value="Por favor espere."/>
                </h:panelGrid>
              </t:div>
            </f:facet>
            <f:facet name="stop"/>
          </a4j:status>
          <jsp:include page="/pages/clinico/comunes/buscador/buscadorProfesional.jsp" flush="true"/>
          <h:panelGrid id="panelGridBusUsuaBotProfesional" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
            <t:htmlTag value="br"/>
            <h:panelGroup id="panelGroupBusUsuBotProfesional">
              <a4j:commandButton value="Aceptar Profesional" styleClass="btn btn btn-success"
                               action="#{referenciaUsuarioBean.aceptarProfesional}" reRender="panelGridReferenciaTab">
                <a4j:support event="onclick" status="statusButton"/>
              </a4j:commandButton>
            </h:panelGroup>
          </h:panelGrid>
        </a4j:region>
      </t:panelTab>
          
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>