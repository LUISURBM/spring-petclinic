<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="920px"
             id="panelGridRegistrarUsuarioAsesoriaTab" styleClass="tabContainer">
    <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuarioRegistroTelefonico.jsp" flush="true"/>
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneDatosUsuario" styleClass="tabbedPane"
                       selectedIndex="#{registrarUsuarioTelefonicoBean.selectedIndex}" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabDatosUsuario" label="Registro Telef�nico">
            <a4j:outputPanel id="ajaxRegionMessage" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInformation" showSummary="false" errorClass="error" globalOnly="true" layout="table"
                            infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
                <t:htmlTag value="br"/>
            </a4j:outputPanel>
            <a4j:region renderRegionOnly="false">
                <s:fieldset id="idVerReporte" legend="Ver Reporte Registro Telef�nico" styleClass="fieldset"
                            rendered="#{registrarUsuarioTelefonicoBean.renderVerReporte}">
                    <a4j:commandLink action="#{registrarUsuarioTelefonicoBean.generarReporte}"
                                     reRender="panelTabDatosUsuario" immediate="true"
                                     title="Reporte Registro Telef�nico">
                        <t:graphicImage alt="Reporte Registro Telef�nico" title="Resumen Registro Telef�nico" border="0"
                                        url="/comun/imagenes/pdfIcon.png"/>
                    </a4j:commandLink>
                </s:fieldset>
            </a4j:region>
            <s:fieldset legend="Anteriores Registros" id="fieldSetAnteriores" styleClass="fieldset">
                <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelRegionAnteriores" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Fecha " styleClass="labelTextInfo"/>
                    <h:outputText/>
                    <h:outputText value="Registro " styleClass="labelTextInfo"/>
                    <a4j:region renderRegionOnly="false">
                        <h:selectOneMenu id="listaRegistrosAnteriores" immediate="true"
                                         value="#{registrarUsuarioTelefonicoBean.numeroRegiTelfAnterior}"
                                         valueChangeListener="#{registrarUsuarioTelefonicoBean.setRegistroChange}"
                                         onkeydown="return blockEnter(event);">
                            <f:selectItems value="#{registrarUsuarioTelefonicoBean.lstRegiTelfAnteriores}"/>
                            <a4j:support id="supportRegiTelfAnterior" event="onchange"
                                         reRender="textAreaRegiTelfAnterior,panelRegionAnterioresCovidAnt,panelGCovidAnt">
                                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                            </a4j:support>
                        </h:selectOneMenu>
                    </a4j:region>
                    <h:outputText/>
                    <h:inputTextarea id="textAreaRegiTelfAnterior" readonly="true"
                                     value="#{registrarUsuarioTelefonicoBean.registroRegiTelfAnterior}"
                                     style="width:650px;height:70px">
                        <f:validateLength maximum="4000"/>
                    </h:inputTextarea>
                </h:panelGrid>
                 <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelRegionAnterioresCovidAnt" rowClasses="labelText,labelTextInfo">
                             
                  <h:panelGroup>
                        <h:outputText value="�Se le ha realizado en Profamilia alg�n procedimiento quir�rgico en la �ltima semana?" rendered="#{registrarUsuarioTelefonicoBean.renderPreguntaCovidAnt}"/>
                            <h:selectOneRadio id="menuCovidAnt" immediate="true" disabled="true" rendered="#{registrarUsuarioTelefonicoBean.renderPreguntaCovidAnt}"
                                              value="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtcproqui}">
                                <f:selectItems value="#{registrarUsuarioTelefonicoBean.lstOpciones}"/>
                            </h:selectOneRadio>
                    </h:panelGroup>
                    <h:panelGroup id="panelGCovidAnt" >
                    <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"  id="panelRegionCovidAnt"
                                    rendered="#{registrarUsuarioTelefonicoBean.renderCovidAnt}" width="100%">
                    <h:panelGroup>                
                    <h:outputText value="�Presenta alguno de estos sintomas?"/>
                    </h:panelGroup>
                    <h:panelGroup>
                    <h:outputText value="�Hace cuantos dias presenta sintomas?"/>
                    </h:panelGroup>

                            <h:panelGroup>
                                    <h:selectManyCheckbox required="false" style="border-style:none;"
                                                          id="mnuPreguntasCovidAnt"
                                                          value="#{registrarUsuarioTelefonicoBean.lstPreguntasCovidSelectAnt}"
                                                          layout="pageDirection"
                                                          disabled="true">
                                        <f:selectItems value="#{registrarUsuarioTelefonicoBean.lstPreguntasCovid}"/>
                                    </h:selectManyCheckbox>
                            </h:panelGroup>
                            <h:panelGroup>
                            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="50%"
                                         id="panelGPreguntasCovidAnt">
                                <h:outputText value="Tos:" rendered="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnumdiatos  != null}" />
                                <h:outputText value="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnumdiatos}"  rendered="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnumdiatos  != null}"/>
                                <h:outputText value="Dias" rendered="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnumdiatos  != null}"/>
                                
                                <h:outputText value="Fiebre:"  rendered="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnumdiafie  != null}"/>
                                <h:outputText value="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnumdiafie}"  rendered="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnumdiafie  != null}"/>
                                <h:outputText value="Dias"  rendered="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnumdiafie  != null}"/>
                                
                                <h:outputText value="Dolor Garganta:"  rendered="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnudidoga  != null}"/>
                                <h:outputText value="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnudidoga}"  rendered="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnudidoga  != null}"/>
                                <h:outputText value="Dias" rendered="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnudidoga  != null}"/>
                                
                                <h:outputText value="Congesti�n Nasal:"  rendered="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnudicona  != null}"/>
                                <h:outputText value="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnudicona}"  rendered="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnudicona  != null}"/>
                                <h:outputText value="Dias"  rendered="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnudicona  != null}"/>
                                
                                <h:outputText value="Dificultad para respirar:"  rendered="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnudidire  != null}"/>
                                <h:outputText value="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnudidire}"  rendered="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnudidire  != null}"/>
                                <h:outputText value="Dias"  rendered="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnudidire  != null}"/>
                                
                                <h:outputText value="F�tiga:"  rendered="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnumdiafat  != null}"/>
                                <h:outputText value="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnumdiafat}"  rendered="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnumdiafat  != null}"/>
                                <h:outputText value="Dias"  rendered="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnumdiafat  != null}"/>
                                
                                <h:outputText value="Escalofrio:"  rendered="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnumdiaesc  != null}"/>
                                <h:outputText value="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnumdiaesc}"  rendered="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnumdiaesc  != null}"/>
                                <h:outputText value="Dias"  rendered="#{registrarUsuarioTelefonicoBean.regiTelfAnterior.hrtnnumdiaesc  != null}"/>
                            </h:panelGrid>
                        </h:panelGroup>
                </h:panelGrid>
                </h:panelGroup>
                             
                </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Informaci�n Covid" id="fieldSetCovid" styleClass="fieldset">
                
                    <h:panelGroup>
                        <h:outputText value="Se le ha realizado en Profamilia alg�n procedimiento quir�rgico en la �ltima semana"
                                      styleClass="labelTextOblig"/>
                        <a4j:region renderRegionOnly="false">
                            <h:selectOneRadio id="menuCovid" immediate="true" required="true"
                                              value="#{registrarUsuarioTelefonicoBean.registroTelefonico.hrtcproqui}">
                                <f:selectItems value="#{registrarUsuarioTelefonicoBean.lstOpciones}"/>
                                <a4j:support id="supportmnuCovid" event="onclick"
                                             action="#{registrarUsuarioTelefonicoBean.changePreguntasCovid}"
                                             reRender="panelGCovid">
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                </a4j:support>
                            </h:selectOneRadio>
                        </a4j:region>
                        <a4j:outputPanel ajaxRendered="true">
                            <t:message for="menuCovid" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                    </h:panelGroup>
                    <h:panelGroup id="panelGCovid" >
                    <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"  id="panelRegionCovid"
                                    rendered="#{registrarUsuarioTelefonicoBean.renderCovid}" width="100%">
                    <h:panelGroup>                
                    <h:outputText value="�Presenta alguno de estos sintomas?"/>
                    </h:panelGroup>
                    <h:panelGroup>
                    <h:outputText value="�Hace cuantos dias presenta sintomas?"/>
                    </h:panelGroup>

                            <h:panelGroup>
                                <a4j:region renderRegionOnly="false">
                                    <h:selectManyCheckbox required="false" style="border-style:none;" immediate="true"
                                                          id="mnuPreguntasCovid"
                                                          value="#{registrarUsuarioTelefonicoBean.lstPreguntasCovidSelect}"
                                                          valueChangeListener="#{registrarUsuarioTelefonicoBean.setPreguntasCovidSelect}"
                                                          layout="pageDirection">
                                        <f:selectItems value="#{registrarUsuarioTelefonicoBean.lstPreguntasCovid}"/>
                                        <a4j:support id="supportmnuPreCovid" event="onclick" immediate="true"
                                                     action="#{registrarUsuarioTelefonicoBean.changeListaPreguntasCovid}"
                                                     reRender="panelGPreguntasCovid">
                                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                        </a4j:support>
                                    </h:selectManyCheckbox>
                                </a4j:region>
                                <a4j:outputPanel ajaxRendered="true">
                                    <t:message for="mnuPreguntasCovid" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                            </h:panelGroup>
                            <h:panelGroup>
                            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0"
                                         id="panelGPreguntasCovid">
                                <h:outputText value="Tos:" rendered="#{registrarUsuarioTelefonicoBean.renderTos}"/>
                                <a4j:region renderRegionOnly="false"
                                            rendered="#{registrarUsuarioTelefonicoBean.renderTos}">
                                    <h:inputText id="numDiasTos"
                                                 value="#{registrarUsuarioTelefonicoBean.registroTelefonico.hrtnnumdiatos}"
                                                 style="width:20px;height:10px;"
                                                 binding="#{registrarUsuarioTelefonicoBean.numDiasTos}"
                                                 valueChangeListener="#{registrarUsuarioTelefonicoBean.setDiasTosSelect}"
                                                 immediate="true" required="true">
                                        <a4j:support id="supportDiasTos" event="onchange" immediate="true"
                                                     action="#{registrarUsuarioTelefonicoBean.changeNumDiasSintomas}">
                                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                        </a4j:support>
                                    </h:inputText>
                                </a4j:region>
                                <h:outputText value="Dias" rendered="#{registrarUsuarioTelefonicoBean.renderTos}"/>
                                <a4j:outputPanel ajaxRendered="true" rendered="#{registrarUsuarioTelefonicoBean.renderTos}">
                                    <t:message for="numDiasTos" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                                <h:outputText value="Fiebre:"
                                              rendered="#{registrarUsuarioTelefonicoBean.renderFiebre}"/>
                                <a4j:region renderRegionOnly="false"
                                            rendered="#{registrarUsuarioTelefonicoBean.renderFiebre}">
                                    <h:inputText id="numDiasFiebre"
                                                 value="#{registrarUsuarioTelefonicoBean.registroTelefonico.hrtnnumdiafie}"
                                                 style="width:20px;height:10px"
                                                 binding="#{registrarUsuarioTelefonicoBean.numDiasFiebre}"
                                                 valueChangeListener="#{registrarUsuarioTelefonicoBean.setDiasFiebreSelect}"
                                                 immediate="true" required="true">
                                        <a4j:support id="supportDiasFiebre" event="onchange" immediate="true"
                                                     action="#{registrarUsuarioTelefonicoBean.changeNumDiasSintomas}">
                                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                        </a4j:support>
                                    </h:inputText>
                                </a4j:region>
                                <h:outputText value="Dias" rendered="#{registrarUsuarioTelefonicoBean.renderFiebre}"/>
                                <a4j:outputPanel ajaxRendered="true" rendered="#{registrarUsuarioTelefonicoBean.renderFiebre}">
                                    <t:message for="numDiasFiebre" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                                <h:outputText value="Dolor Garganta:"
                                              rendered="#{registrarUsuarioTelefonicoBean.renderDolorGarganta}"/>
                                <a4j:region renderRegionOnly="false"
                                            rendered="#{registrarUsuarioTelefonicoBean.renderDolorGarganta}">
                                    <h:inputText id="numDiasDolorGarganta"
                                                 value="#{registrarUsuarioTelefonicoBean.registroTelefonico.hrtnnudidoga}"
                                                 style="width:20px;height:10px"
                                                 binding="#{registrarUsuarioTelefonicoBean.numDiasDolorGarganta}"
                                                 valueChangeListener="#{registrarUsuarioTelefonicoBean.setDiasDolorGargantaSelect}"
                                                 immediate="true" required="true">
                                        <a4j:support id="supportDiasDolorGarganta" event="onchange" immediate="true"
                                                     action="#{registrarUsuarioTelefonicoBean.changeNumDiasSintomas}">
                                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                        </a4j:support>
                                    </h:inputText>
                                </a4j:region>
                                <h:outputText value="Dias"
                                              rendered="#{registrarUsuarioTelefonicoBean.renderDolorGarganta}"/>
                                <a4j:outputPanel ajaxRendered="true" rendered="#{registrarUsuarioTelefonicoBean.renderDolorGarganta}">
                                    <t:message for="numDiasDolorGarganta" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                                <h:outputText value="Congesti�n Nasal:"
                                              rendered="#{registrarUsuarioTelefonicoBean.renderCongestionNasal}"/>
                                <a4j:region renderRegionOnly="false"
                                            rendered="#{registrarUsuarioTelefonicoBean.renderCongestionNasal}">
                                    <h:inputText id="numDiasCongestionNasal"
                                                 value="#{registrarUsuarioTelefonicoBean.registroTelefonico.hrtnnudicona}"
                                                 style="width:20px;height:10px"
                                                 binding="#{registrarUsuarioTelefonicoBean.numDiasCongestionNasal}"
                                                 valueChangeListener="#{registrarUsuarioTelefonicoBean.setDiasCongestionNasalSelect}"
                                                 immediate="true" required="true">
                                        <a4j:support id="supportDiasCongestionNasal" event="onchange" immediate="true"
                                                     action="#{registrarUsuarioTelefonicoBean.changeNumDiasSintomas}">
                                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                        </a4j:support>
                                    </h:inputText>
                                </a4j:region>
                                <h:outputText value="Dias"
                                              rendered="#{registrarUsuarioTelefonicoBean.renderCongestionNasal}"/>
                                <a4j:outputPanel ajaxRendered="true" rendered="#{registrarUsuarioTelefonicoBean.renderCongestionNasal}">
                                    <t:message for="numDiasCongestionNasal" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                                <h:outputText value="Dificultad para respirar:"
                                              rendered="#{registrarUsuarioTelefonicoBean.renderDificultadRespirar}"/>
                                <a4j:region renderRegionOnly="false"
                                            rendered="#{registrarUsuarioTelefonicoBean.renderDificultadRespirar}">
                                    <h:inputText id="numDiasDificultadRespirar"
                                                 value="#{registrarUsuarioTelefonicoBean.registroTelefonico.hrtnnudidire}"
                                                 style="width:20px;height:10px"
                                                 binding="#{registrarUsuarioTelefonicoBean.numDiasDificultadRespirar}"
                                                 valueChangeListener="#{registrarUsuarioTelefonicoBean.setDiasDificultadRespirarSelect}"
                                                 immediate="true" required="true">
                                        <a4j:support id="supportDiasDificultadRespirar" event="onchange"
                                                     immediate="true"
                                                     action="#{registrarUsuarioTelefonicoBean.changeNumDiasSintomas}">
                                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                        </a4j:support>
                                    </h:inputText>
                                </a4j:region>
                                <h:outputText value="Dias"
                                              rendered="#{registrarUsuarioTelefonicoBean.renderDificultadRespirar}"/>
                                <a4j:outputPanel ajaxRendered="true" rendered="#{registrarUsuarioTelefonicoBean.renderDificultadRespirar}">
                                    <t:message for="numDiasDificultadRespirar" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                                <h:outputText value="F�tiga:"
                                              rendered="#{registrarUsuarioTelefonicoBean.renderFatiga}"/>
                                <a4j:region renderRegionOnly="false"
                                            rendered="#{registrarUsuarioTelefonicoBean.renderFatiga}">
                                    <h:inputText id="numDiasFatiga"
                                                 value="#{registrarUsuarioTelefonicoBean.registroTelefonico.hrtnnumdiafat}"
                                                 style="width:20px;height:10px"
                                                 binding="#{registrarUsuarioTelefonicoBean.numDiasFatiga}"
                                                 valueChangeListener="#{registrarUsuarioTelefonicoBean.setDiasFatigaSelect}"
                                                 immediate="true" required="true">
                                        <a4j:support id="supportDiasFatiga" event="onchange" immediate="true"
                                                     action="#{registrarUsuarioTelefonicoBean.changeNumDiasSintomas}">
                                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                        </a4j:support>
                                    </h:inputText>
                                </a4j:region>
                                <h:outputText value="Dias" rendered="#{registrarUsuarioTelefonicoBean.renderFatiga}"/>
                                <a4j:outputPanel ajaxRendered="true" rendered="#{registrarUsuarioTelefonicoBean.renderFatiga}">
                                    <t:message for="numDiasFatiga" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                                <h:outputText value="Escalofrio:"
                                              rendered="#{registrarUsuarioTelefonicoBean.renderEscalosfrio}"/>
                                <a4j:region renderRegionOnly="false"
                                            rendered="#{registrarUsuarioTelefonicoBean.renderEscalosfrio}">
                                    <h:inputText id="numDiasEscalosfrio"
                                                 value="#{registrarUsuarioTelefonicoBean.registroTelefonico.hrtnnumdiaesc}"
                                                 style="width:20px;height:10px"
                                                 binding="#{registrarUsuarioTelefonicoBean.numDiasEscalosfrio}"
                                                 valueChangeListener="#{registrarUsuarioTelefonicoBean.setDiasEscalosfrioSelect}"
                                                 immediate="true" required="true">
                                        <a4j:support id="supportDiasEscalosfrio" event="onchange" immediate="true"
                                                     action="#{registrarUsuarioTelefonicoBean.changeNumDiasSintomas}">
                                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                        </a4j:support>
                                    </h:inputText>
                                </a4j:region>
                                <h:outputText value="Dias"
                                              rendered="#{registrarUsuarioTelefonicoBean.renderEscalosfrio}"/>
                                <a4j:outputPanel ajaxRendered="true" rendered="#{registrarUsuarioTelefonicoBean.renderEscalosfrio}">
                                    <t:message for="numDiasEscalosfrio" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                            </h:panelGrid>
                        </h:panelGroup>
                </h:panelGrid>
                </h:panelGroup>
            </s:fieldset>
            <s:fieldset legend="Informaci�n Registro" id="fieldSetTelefonico" styleClass="fieldset">
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelRegionTelefonico" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Informaci�n Registro" styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <h:inputTextarea id="textAreaTelefonicos" required="true" immediate="true"
                                     value="#{registrarUsuarioTelefonicoBean.registroTelefonico.hrtcregistro}"
                                     style="width:650px;height:70px">
                        <f:validateLength maximum="4000"/>
                    </h:inputTextarea>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="textAreaTelefonicos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                </h:panelGrid>
            </s:fieldset>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                         columnClasses="panelGridBotones">
                <h:panelGroup>
                    <h:commandButton value="Guardar" styleClass="boton_fieldset"
                                     action="#{registrarUsuarioTelefonicoBean.guardarTelefonico}">
                        <a4j:support event="onclick" status="statusButton"/>
                    </h:commandButton>
                </h:panelGroup>
            </h:panelGrid>
            <f:subview id="descargarReporteRegistro" rendered="#{registrarUsuarioTelefonicoBean.generoReporte}">
                <a4j:region renderRegionOnly="false">
                    <f:verbatim>
                        <script type="text/javascript" language="JavaScript">
                            window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
                        </script>
                    </f:verbatim>
                </a4j:region>
            </f:subview>
        </t:panelTab>
    </t:panelTabbedPane>
    <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
    </script>
</h:panelGrid>