<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="920px" id="panelGridRegistrarUsuarioAsesoriaTab" styleClass="tabContainer">
    <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuarioAsesoria.jsp" flush="true"/>
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneDatosUsuario" styleClass="tabbedPane"
                       selectedIndex="#{registroUsuarioNuevaAsesoriaBean.selectedIndex}" activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">

        <t:panelTab id="panelTabDatosOtraAsesoria" label="Datos Usuario(a)" rendered="#{!registroUsuarioNuevaAsesoriaBean.renderSelecionarUsuario}">
            <a4j:commandLink action="#{registroUsuarioNuevaAsesoriaBean.resetDatos}" immediate="true" reRender="panelGridRegistrarOtraAsesoriaTab" title="Registrar Nuevo Usuario(a)">
                <t:graphicImage alt="Registrar Nuevo Usuario(a)" title="Registrar Nuevo Usuario(a)" border="0" url="/comun/imagenes/nuevo.jpg"/>
            </a4j:commandLink>

            <s:fieldset legend="Asesoría " id="fieldSetSeleccionarOtraAsesoria" styleClass="fieldset" >

                <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" 
                             id="panelRegionSeleccionarOtraAsesoria" styleClass="labelTextInfo"
                             >

                    <h:panelGroup style="border-style:none;font-size:10px" >
                        <h:selectBooleanCheckbox id="checkConsejeríaPadresCuidadores" onkeydown="return blockEnter(event);" value="#{registroUsuarioNuevaAsesoriaBean.renderConsejeriaPadresCuidadores}"/>
                        <h:outputText value="  Consejería para Padres y Cuidadores  "/>
                    </h:panelGroup>
                    <h:outputText />

                    <h:panelGroup style="border-style:none;font-size:10px" >
                        <h:selectBooleanCheckbox id="checkSexualidadPlacer" onkeydown="return blockEnter(event);" value="#{registroUsuarioNuevaAsesoriaBean.renderSexualidadPlacer}"/>
                        <h:outputText value="  Consulta Sexualidad y Placer  "/>
                    </h:panelGroup>
                    <h:outputText />

                    <h:panelGroup style="border-style:none;font-size:10px" >
                        <h:selectBooleanCheckbox id="checkViolencia" onkeydown="return blockEnter(event);" 
                                                 value="#{registroUsuarioNuevaAsesoriaBean.renderViolencia}"/>
                        <h:outputText value="  Violencia "/>
                    </h:panelGroup>
                    <h:outputText />
                </h:panelGrid>

                <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" 
                             id="panelRegionVIH" styleClass="labelTextInfo"
                             >

                    <h:panelGroup style="border-style:none;font-size:10px" >
                        <h:selectBooleanCheckbox id="checkPrePruebaVIH" onkeydown="return blockEnter(event);" 
                                                 value="#{registroUsuarioNuevaAsesoriaBean.renderVIHPre}"
                                                 valueChangeListener="#{registroUsuarioNuevaAsesoriaBean.setRenderVIHPre}">
                            <a4j:support id="supportcheckPrePruebaVIH" event="onclick" 
                                         reRender="panelRegionVIH, panelTextIntervencionCrisis, panelIntervencionCrisisDetalle">
                                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                            </a4j:support>
                        </h:selectBooleanCheckbox>
                        <h:outputText value="  Asesoría Pre Prueba de VIH   "/>
                    </h:panelGroup>
                    <h:outputText />

                    <h:panelGroup style="border-style:none;font-size:10px" >
                        <h:selectBooleanCheckbox id="checkPosPruebaVIH" onkeydown="return blockEnter(event);" 
                                                 value="#{registroUsuarioNuevaAsesoriaBean.renderVIHPos}"
                                                 valueChangeListener="#{registroUsuarioNuevaAsesoriaBean.setRenderVIHPos}">
                            <a4j:support id="supportcheckPosPruebaVIH" event="onclick" 
                                         reRender="panelRegionVIH, panelTextIntervencionCrisis, panelIntervencionCrisisDetalle">
                                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                            </a4j:support>
                        </h:selectBooleanCheckbox>
                        <h:outputText value="  Asesoría Pos Prueba de VIH   "/>
                    </h:panelGroup>
                    <h:outputText />

                    <h:panelGrid id="panelTextIntervencionCrisis" columns="3" >
                        <h:outputText value="¿Realizó intervención en crisis?  " styleClass="labelTextInfo" 
                                      rendered="#{registroUsuarioNuevaAsesoriaBean.renderVIHPre or registroUsuarioNuevaAsesoriaBean.renderVIHPos}"/>
                        <h:outputText value="  " styleClass="labelTextInfo" 
                                      rendered="#{registroUsuarioNuevaAsesoriaBean.renderVIHPre or registroUsuarioNuevaAsesoriaBean.renderVIHPos}"/>
                        <h:selectOneRadio id="selectIntervencionCrisis"
                                          rendered="#{registroUsuarioNuevaAsesoriaBean.renderVIHPre or registroUsuarioNuevaAsesoriaBean.renderVIHPos}" 
                                          onkeydown="return blockEnter(event);"
                                          value="#{registroUsuarioNuevaAsesoriaBean.renderIntCris}"
                                          valueChangeListener="#{registroUsuarioNuevaAsesoriaBean.setRenderIntCris}">
                            <f:selectItems value="#{registroUsuarioNuevaAsesoriaBean.lstSiNo}"/>
                            <a4j:support id="supportselecIntervencionCrisis" event="onclick" reRender="panelIntervencionCrisisDetalle">
                                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                            </a4j:support>
                        </h:selectOneRadio>
                    </h:panelGrid>
                    <h:outputText />

                </h:panelGrid>

                <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" 
                             id="panelRegionIntervencionCrisisDetalle" styleClass="labelTextInfo"
                             >
                    <h:panelGrid id="panelIntervencionCrisisDetalle" columns="1" >
                        <h:outputText value="Intervención Crisis Detalle" styleClass="labelTextOblig" 
                                      rendered="#{(registroUsuarioNuevaAsesoriaBean.renderVIHPre or registroUsuarioNuevaAsesoriaBean.renderVIHPos) 
                                                  and registroUsuarioNuevaAsesoriaBean.renderIntCris}" />
                        <h:inputTextarea id="textIntervencionCrisisDetalle" 
                                         rendered="#{(registroUsuarioNuevaAsesoriaBean.renderVIHPre or registroUsuarioNuevaAsesoriaBean.renderVIHPos) 
                                                     and registroUsuarioNuevaAsesoriaBean.renderIntCris}"
                                         style="width:650px;height:70px"
                                         value="#{registroUsuarioNuevaAsesoriaBean.asesoria.hascintcrisdet}">
                            <f:validateLength maximum="4000"/>
                        </h:inputTextarea>
                    </h:panelGrid>
                </h:panelGrid>

                <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" 
                             id="panelRegionEmbarazo" styleClass="labelTextInfo"
                             >
                    <h:panelGroup style="border-style:none;font-size:10px" >
                        <h:outputText value="  Prueba de Embarazo (resultado)  "/>
                        <h:outputText />
                        <h:selectOneRadio id="itResultadoEmbarazoAsesoria" value="#{registroUsuarioNuevaAsesoriaBean.asesoria.haseresulembar}" style="font-size:10px;" >
                            <f:selectItems value="#{registroUsuarioNuevaAsesoriaBean.lstResultadoEmbarazo}" />
                        </h:selectOneRadio>
                        <a4j:outputPanel ajaxRendered="true" >
                            <t:message for="itResultadoEmbarazoAsesoria"  styleClass="errorMessage"/>
                        </a4j:outputPanel>
                    </h:panelGroup>

                    <h:outputText />
                    <h:outputText />
                    <h:outputText />
                    <h:outputText />
                </h:panelGrid>

                <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" 
                             id="panelRegionOtro" styleClass="labelTextInfo"
                             >
                    <h:panelGrid id="panelOtro" columns="2">
                        <a4j:region renderRegionOnly="false">
                            <h:panelGroup style="border-style:none;font-size:10px" >
                                <h:selectBooleanCheckbox id="checkOtroOtraAsesoria" onkeydown="return blockEnter(event);" value="#{registroUsuarioNuevaAsesoriaBean.renderOtro}"
                                                         valueChangeListener="#{registroUsuarioNuevaAsesoriaBean.setRenderOtro}">
                                    <a4j:support id="supportcheckOtroOtraAsesoria" event="onclick" reRender="panelTextCual">
                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    </a4j:support>
                                </h:selectBooleanCheckbox>
                                <h:outputText value="  Otro  "/>
                            </h:panelGroup>
                        </a4j:region>
                    </h:panelGrid>
                    <h:outputText />

                    <h:panelGrid id="panelTextCual" columns="3" >
                        <h:outputText value="Cuál? " styleClass="labelTextOblig" rendered="#{registroUsuarioNuevaAsesoriaBean.renderOtro}"/>
                        <h:outputText value=" " rendered="#{registroUsuarioNuevaAsesoriaBean.renderOtro}"/>
                        <h:inputText id="itCualOtroAsesoria" rendered="#{registroUsuarioNuevaAsesoriaBean.renderOtro}" onkeydown="return blockEnter(event);" maxlength="30" required="true"
                                     value="#{registroUsuarioNuevaAsesoriaBean.asesoria.hasccualotro}">
                        </h:inputText>
                    </h:panelGrid>
                </h:panelGrid>

            </s:fieldset>


            <s:fieldset legend="Conducta " id="fieldSetSeleccionarEnvia" styleClass="fieldset" >
                <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionSeleccionarEnvia" styleClass="labelTextInfo"
                             >
                    <h:panelGroup style="border-style:none;font-size:10px" >
                        <h:selectBooleanCheckbox id="checkEnviaAnticoncepcion" onkeydown="return blockEnter(event);" value="#{registroUsuarioNuevaAsesoriaBean.renderEnviaAnticoncepcion}"/>
                        <h:outputText value="  Consulta Anticoncepción "/>
                    </h:panelGroup>
                    <h:outputText />
                    <h:panelGroup style="border-style:none;font-size:10px" >
                        <h:selectBooleanCheckbox id="checkEnviaGeneral" onkeydown="return blockEnter(event);" value="#{registroUsuarioNuevaAsesoriaBean.renderEnviaGeneral}"/>
                        <h:outputText value="  Consulta medicina general "/>
                    </h:panelGroup>
                    <h:outputText />
                    <h:panelGroup style="border-style:none;font-size:10px" >
                        <h:selectBooleanCheckbox id="checkEnviaEspecializada" onkeydown="return blockEnter(event);" value="#{registroUsuarioNuevaAsesoriaBean.renderEnviaEspecial}"/>
                        <h:outputText value="  Consulta medicina Especializada "/>
                    </h:panelGroup>
                    <h:outputText />
                    <h:panelGroup style="border-style:none;font-size:10px" >
                        <h:selectBooleanCheckbox id="checkEnviaAborto" onkeydown="return blockEnter(event);" value="#{registroUsuarioNuevaAsesoriaBean.renderEnviaAborto}"/>
                        <h:outputText value="  Consulta Aborto "/>
                    </h:panelGroup>
                    <h:outputText />
                    <h:panelGroup style="border-style:none;font-size:10px" >
                        <h:selectBooleanCheckbox id="checkEnviaLaboratorio" onkeydown="return blockEnter(event);" value="#{registroUsuarioNuevaAsesoriaBean.renderEnviaLaboratorio}"/>
                        <h:outputText value="  Laboratorio Clínico "/>
                    </h:panelGroup>
                    <h:outputText />
                    <h:panelGroup style="border-style:none;font-size:10px" >
                        <h:selectBooleanCheckbox id="checkEnviaProductos" onkeydown="return blockEnter(event);" value="#{registroUsuarioNuevaAsesoriaBean.renderEnviaProductos}"/>
                        <h:outputText value="  Productos "/>
                    </h:panelGroup>
                    <h:outputText />
                    <h:panelGroup style="border-style:none;font-size:10px" >
                        <h:selectBooleanCheckbox id="checkEnviaPsicologia" onkeydown="return blockEnter(event);" value="#{registroUsuarioNuevaAsesoriaBean.renderPsicologia}"/>
                        <h:outputText value="  Consulta de Psicología "/>
                    </h:panelGroup>
                    <h:outputText />
                    <h:panelGroup style="border-style:none;font-size:10px" >
                        <h:selectBooleanCheckbox id="checkEnviaUnidadFertilidad" onkeydown="return blockEnter(event);" value="#{registroUsuarioNuevaAsesoriaBean.renderEnviaUnidadFertilidad}"/>
                        <h:outputText value="  Unidad Fertilidad "/>
                    </h:panelGroup>
                    <h:outputText />

                    <a4j:region renderRegionOnly="false">
                        <h:panelGroup style="border-style:none;font-size:10px" >
                            <h:selectBooleanCheckbox id="checkEnviaOtro" onkeydown="return blockEnter(event);" value="#{registroUsuarioNuevaAsesoriaBean.renderEnviaOtro}"
                                                     valueChangeListener="#{registroUsuarioNuevaAsesoriaBean.setRenderEnviaOtro}">
                                <a4j:support id="supportcheckEnviaOtro" event="onclick" reRender="panelTextConducta">
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                </a4j:support>
                            </h:selectBooleanCheckbox>
                            <h:outputText value="  Otro  "/>
                        </h:panelGroup>
                    </a4j:region>

                </h:panelGrid>

                <h:panelGrid id="panelTextConducta" columns="1" >
                    <h:outputText value="Conducta " styleClass="labelTextOblig" rendered="#{registroUsuarioNuevaAsesoriaBean.renderEnviaOtro}"/>
                    <h:inputTextarea id="textEnviaOtroConducta"  rendered="#{registroUsuarioNuevaAsesoriaBean.renderEnviaOtro}" 
                                     style="width:650px;height:70px" 
                                     value="#{registroUsuarioNuevaAsesoriaBean.asesoria.hascenvotrcond}">
                        <f:validateLength maximum="4000"/>
                    </h:inputTextarea>
                </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Observaciones " id="fieldSetObservacionesOtraAsesoria" styleClass="fieldset"
                        >
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionObservacionesOtraAsesoria" styleClass="labelTextInfo"
                             >
                    <h:outputText value="Observaciones"/>
                    <h:outputText value=""/>
                    <h:inputTextarea id="textObservaciones" style="width:650px;height:70px" value="#{registroUsuarioNuevaAsesoriaBean.asesoria.hascobservacio}">
                        <f:validateLength maximum="4000"/>
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
                    <h:commandButton value="Guardar" styleClass="btn btn btn-success" 
                                     action="#{registroUsuarioNuevaAsesoriaBean.guardarAsesoria}">
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