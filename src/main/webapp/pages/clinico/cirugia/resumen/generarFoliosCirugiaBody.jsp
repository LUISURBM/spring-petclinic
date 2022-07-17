<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="generarFoliosCirugiaForm">
    <a4j:region id="bodyRegionGenerarFoliosCirugia">
        <a4j:status id="statusButton" for="bodyRegionGenerarFoliosCirugia">
            <f:facet name="start">
                <t:div id="chargindConsultarGenerarFoliosCirugia" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
        <h:panelGrid columns="1" id="tableGenerarFoliosCirugia" border="0" cellpadding="0" cellspacing="0" width="100%"
                     columnClasses="verticalaligntop,td_fondoBarraH">
            <h:outputText value="Folios Cirugia " id="infoUbicationGenerarFoliosCirugia"/>
        </h:panelGrid>
        <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableGenerarFoliosCirugiaTabs" styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxFoliosGenerarFoliosCirugia" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgFoliosGenerarFoliosCirugia" showSummary="false" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion" showDetail="true"
                                tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabConGenerarFoliosCirugia"
                               styleClass="tabbedPane" activeTabStyleClass="activeTab"
                               inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                               activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                               tabContentStyleClass="tabContent">
                <t:panelTab id="panelGenerarFoliosCirugia" label="Folios Cirugia">
                    <s:fieldset legend="Datos Paciente" id="fieldDatosGenerarFoliosCirugia" styleClass="fieldset">
                        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="panelRegionImprimirFolios" rowClasses="labelText,labelTextInfo">
                            <h:outputText value="Imprimir Cirugia " styleClass="labelTextOblig"/>
                            <h:outputText value=""/>
                            <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" width="100%"
                                         id="panelRegionGenerarFolios">
                                <h:panelGroup style="border-style:none;font-size:10px">
                                    <a4j:region renderRegionOnly="false">
                                        <h:selectBooleanCheckbox id="checkTodaCirugia" immediate="true" styleClass="css-checkbox"
                                                                 onkeydown="return blockEnter(event);"
                                                                 valueChangeListener="#{generarFoliosCirugiaBean.setRenderCirugiaCompleta}"
                                                                 value="#{generarFoliosCirugiaBean.renderCirugiaCompleta}">
                                            <a4j:support id="supportNingunaAccion" event="onclick"
                                                         action="#{generarFoliosCirugiaBean.changeCirugiaCompleta}"
                                                         reRender="panelRegionGenerarFolios">
                                                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                            </a4j:support>
                                            
                                          </h:selectBooleanCheckbox>
                                    </a4j:region>
                                  
                                    <h:outputLabel value=" Toda la Cirugia " for="checkTodaCirugia" styleClass="css-label"/>
                                </h:panelGroup>
                                <a4j:outputPanel ajaxRendered="true">
                                    <t:message for="checkTodaCirugia" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                                <h:panelGroup style="border-style:none;font-size:10px">
                                    <h:selectBooleanCheckbox id="checkDescripcionQuirurgica" styleClass="css-checkbox"
                                                             onkeydown="return blockEnter(event);"
                                                             disabled="#{generarFoliosCirugiaBean.renderCirugiaCompleta}"
                                                             value="#{generarFoliosCirugiaBean.renderDescripcion}"/>
                                    <h:outputLabel value=" Descripci�n Quirurgica" for="checkDescripcionQuirurgica" styleClass="css-label"/>
                                </h:panelGroup> 
                                <h:outputText/>
                                <h:panelGroup style="border-style:none;font-size:10px">
                                    <h:selectBooleanCheckbox id="checkEvolucionMedica" styleClass="css-checkbox"
                                                             onkeydown="return blockEnter(event);"
                                                             disabled="#{generarFoliosCirugiaBean.renderCirugiaCompleta}"
                                                             value="#{generarFoliosCirugiaBean.renderEvolucionMedica}"/>
                                    <h:outputLabel value=" Evoluci�n (M�dica) " for="checkEvolucionMedica" styleClass="css-label"/>
                                </h:panelGroup>
                                <h:outputText/>
                                <h:panelGroup style="border-style:none;font-size:10px">
                                    <h:selectBooleanCheckbox id="checkNotaEnfermeria" styleClass="css-checkbox"
                                                             onkeydown="return blockEnter(event);"
                                                             disabled="#{generarFoliosCirugiaBean.renderCirugiaCompleta}"
                                                             value="#{generarFoliosCirugiaBean.renderNotasEnfermeria}"/>
                                    <h:outputLabel value=" Notas Enfermeria " for="checkNotaEnfermeria" styleClass="css-label"/>
                                </h:panelGroup>
                                <h:outputText/>
                                <h:panelGroup style="border-style:none;font-size:10px">
                                    <h:selectBooleanCheckbox id="checkCanalizacion" styleClass="css-checkbox"
                                                             onkeydown="return blockEnter(event);"
                                                             disabled="#{generarFoliosCirugiaBean.renderCirugiaCompleta}"
                                                             value="#{generarFoliosCirugiaBean.renderCanalizacion}"/>
                                <h:outputLabel value="Canalizaci�n Vena " for="checkCanalizacion" styleClass="css-label"/>
                                </h:panelGroup>
                                <h:outputText/>
                                <h:panelGroup style="border-style:none;font-size:10px">
                                    <h:selectBooleanCheckbox id="checkIngreso" styleClass="css-checkbox"
                                                             onkeydown="return blockEnter(event);"
                                                             disabled="#{generarFoliosCirugiaBean.renderCirugiaCompleta}"
                                                             value="#{generarFoliosCirugiaBean.renderIngreso}"/>
                                    <h:outputLabel value="Ingreso Enfermer�a " for="checkIngreso" styleClass="css-label" />
                                    </h:panelGroup>
                                <h:outputText/>
                                <h:panelGroup style="border-style:none;font-size:10px">
                                    <h:selectBooleanCheckbox id="checkControlLiquidos" styleClass="css-checkbox"
                                                             onkeydown="return blockEnter(event);"
                                                             disabled="#{generarFoliosCirugiaBean.renderCirugiaCompleta}"
                                                             value="#{generarFoliosCirugiaBean.renderControlLiquidos}"/>
                                    <h:outputLabel value=" Control Liquidos " for="checkControlLiquidos" styleClass="css-label"/>
                                </h:panelGroup>
                                <h:outputText/>
                                <h:panelGroup style="border-style:none;font-size:10px">
                                    <h:selectBooleanCheckbox id="checkControlMedicamento" styleClass="css-checkbox"
                                                             onkeydown="return blockEnter(event);"
                                                             disabled="#{generarFoliosCirugiaBean.renderCirugiaCompleta}"
                                                             value="#{generarFoliosCirugiaBean.renderControlMedicamentos}"/>
                                    <h:outputLabel value=" Control Medicamentos " for="checkControlMedicamento" styleClass="css-label"/>
                                </h:panelGroup>
                                <h:outputText/>
                                <h:panelGroup style="border-style:none;font-size:10px">
                                    <h:selectBooleanCheckbox id="checkSignosVitales" styleClass="css-checkbox"
                                                             onkeydown="return blockEnter(event);"
                                                             disabled="#{generarFoliosCirugiaBean.renderCirugiaCompleta}"
                                                             value="#{generarFoliosCirugiaBean.renderSignosVitales}"/>
                                    <h:outputLabel value=" Signos Vitales " for="checkSignosVitales" styleClass="css-label"/>
                                </h:panelGroup>
                                <h:outputText/>
                                <h:panelGroup style="border-style:none;font-size:10px">
                                    <h:selectBooleanCheckbox id="checkAnestesia" onkeydown="return blockEnter(event);" styleClass="css-checkbox"
                                                             disabled="#{generarFoliosCirugiaBean.renderCirugiaCompleta}"
                                                             value="#{generarFoliosCirugiaBean.renderAnestesia}"/>
                                    <h:outputLabel value=" Registro de Anestesia " for="checkAnestesia" styleClass="css-label"/>
                                </h:panelGroup>
                                <h:outputText/>
                                 <h:panelGroup style="border-style:none;font-size:10px">
                                    <h:selectBooleanCheckbox id="checkEpicrisis" onkeydown="return blockEnter(event);" styleClass="css-checkbox"
                                                             disabled="#{generarFoliosCirugiaBean.renderCirugiaCompleta}"
                                                             value="#{generarFoliosCirugiaBean.renderEpicrisis}"/>
                                    <h:outputLabel value=" Imprimir Epicrisis " for="checkEpicrisis" styleClass="css-label"/>
                                </h:panelGroup>
                                 <h:outputText/>
                                 <h:panelGroup style="border-style:none;font-size:10px">
                                    <h:selectBooleanCheckbox id="checkEscalaValoracion" onkeydown="return blockEnter(event);" styleClass="css-checkbox"
                                                             disabled="#{generarFoliosCirugiaBean.renderCirugiaCompleta}"
                                                             value="#{generarFoliosCirugiaBean.renderEscalaValoracionCaidas}"/>
                                    <h:outputLabel value="Escala Valoraci�n Caidas " for="checkEscalaValoracion" styleClass="css-label"/>
                                </h:panelGroup>
                            </h:panelGrid>
                        </h:panelGrid>
                    </s:fieldset>
                    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                 id="panelBotonGenerarResumenCirugia" columnClasses="panelGridBotones">
                        <h:panelGroup>
                            <a4j:outputPanel id="ajaxRegionMessagesFoliosCirugia" ajaxRendered="true">
                                <t:htmlTag value="br"/>
                                <t:message for="idButtonBuscarFoliosCirugia" id="msgFoliosCirugia" errorClass="error"
                                           infoClass="informacion"/>
                            </a4j:outputPanel>
                        </h:panelGroup>
                        <h:commandButton value="Generar Resumen" action="#{generarFoliosCirugiaBean.consultarCirugia}"
                                         styleClass="btn btn btn-success" id="idButtonBuscarFoliosCirugia"/>
                    </h:panelGrid>
                </t:panelTab>
                <h:panelGrid>
                    <h:commandLink action="#{generarFoliosCirugiaBean.volverConsulta}" immediate="true">
                        <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                    </h:commandLink>
                </h:panelGrid>
            </t:panelTabbedPane>
        </h:panelGrid>
      
		
        <h:panelGrid>
            <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMsgGenerarFoliosCirugia" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationMsgGenerarFoliosCirugia" showSummary="true" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
        </h:panelGrid>
        <f:subview id="generarCirugia" rendered="#{generarFoliosCirugiaBean.generoHistoria}">
            <f:verbatim>
                <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
            </f:verbatim>
        </f:subview>
        <f:verbatim>
            <input id="pagina" type="hidden" name="pagina"/>
        </f:verbatim>
    </a4j:region>
</a4j:form>