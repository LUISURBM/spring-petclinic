<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
             id="tableTools" columnClasses="barraHizq,verticalaligntop"
             width="100%">
    <t:div id="sideBarTab" styleClass="rollover">
        <a4j:commandLink id="sideBarTabClick" immediate="true"
                         onclick="slideSideBar(); return false"/>
    </t:div>
    <t:div id="sideBarContents">
        <!-- style="display:none;"> -->
         
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     rowClasses="nivelUnoBarraH,fndBarraH,nivelUnoBarraH,fndBarraHerr"
                     width="100%">
            <t:htmlTag value="h1">
                <h:outputText value=" "/>
            </t:htmlTag>
            <t:div id="toolBarInstrumentos">
                <s:accordionPanel id="menuToolsAccordion" layout="accordion"
                                  style="border-bottom:White !important;">
                    <t:panelTab label="Procesos de Efecto Joven"
                                id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0"
                                     cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuHistoriaEfectoJoven.irDatosEfectoJoven}"
                                           immediate="true"/>
                                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaEfectoJoven.irCuestionarioCovidEfectoJoven}" immediate="true"
                                            rendered="#{menuHistoriaEfectoJoven.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaEfectoJoven.irMotivoEfectoJoven}"
                                           immediate="true"
                                           rendered="#{menuHistoriaEfectoJoven.renderMotivo}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaEfectoJoven.irAntecedentesGeneralesEfectoJoven}"
                                           immediate="true"
                                           rendered="#{menuHistoriaEfectoJoven.renderAntecedentesGenerales && menuHistoriaEfectoJoven.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaEfectoJoven.irAntecedentesEfectoJoven}"
                                           immediate="true"
                                           rendered="#{menuHistoriaEfectoJoven.renderAntecedentesGenerales && !menuHistoriaEfectoJoven.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Ginecologicos"
                                           action="#{menuHistoriaEfectoJoven.irAntecedentesGinecologicosEfectoJoven}"
                                           immediate="true"
                                           rendered="#{menuHistoriaEfectoJoven.renderAntecedentesGinecologicos}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaEfectoJoven.irEncuestaViolenciaEfectoJoven}"
                                           immediate="true"
                                           rendered="#{menuHistoriaEfectoJoven.renderEncuestaViolencia}"/>
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaEfectoJoven.irExamenFisicoEfectoJoven}"
                                           immediate="true"
                                           rendered="#{menuHistoriaEfectoJoven.renderExamen}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaEfectoJoven.irImpDiagnosticaEfectoJoven}"
                                           immediate="true"
                                           rendered="#{menuHistoriaEfectoJoven.renderImpresionDiagnostica}"/>
							<h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaEfectoJoven.irServiciosAdmisionEfectoJoven}"
                                           immediate="true" rendered="#{menuHistoriaEfectoJoven.renderServiciosAdmision}"/>			   
                            <h:outputText value="Conducta"
                                          styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaEfectoJoven.renderConducta}"/>
                              <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaEfectoJoven.irFormulaMedicaEfectoJoven}"
                                           immediate="true" rendered="#{menuHistoriaEfectoJoven.renderConducta && !menuHistoriaEfectoJoven.renderVademecum}"/>
                                           
                             <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaEfectoJoven.irVademecumMedicoEfectoJoven}"
                                           immediate="true" rendered="#{menuHistoriaEfectoJoven.renderConducta && menuHistoriaEfectoJoven.renderVademecum}"/>
                                           
                        
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaEfectoJoven.irInterConsultaEfectoJoven}"
                                           immediate="true"
                                           rendered="#{menuHistoriaEfectoJoven.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones"
                                           style="color:Green;"
                                           action="#{menuHistoriaEfectoJoven.irRecomedacionEfectoJoven}"
                                           immediate="true"
                                           rendered="#{menuHistoriaEfectoJoven.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaEfectoJoven.irCerrarConsultaEfectoJoven}"
                                           immediate="true"
                                           rendered="#{menuHistoriaEfectoJoven.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia"
                                id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0"
                                     cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaEfectoJoven.irResumenHistoriaEfectoJoven}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                     <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuHistoriaEfectoJoven.irPausarConsultaControlEfectoJoven}"
                                   rendered="#{menuHistoriaEfectoJoven.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>