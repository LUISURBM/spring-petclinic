<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" id="tableTools"
             columnClasses="barraHizq,verticalaligntop" width="100%">
    <t:div id="sideBarTab" styleClass="rollover">
        <a4j:commandLink id="sideBarTabClick" immediate="true" onclick="slideSideBar(); return false"/>
    </t:div>
    <t:div id="sideBarContents">
        <!-- style="display:none;"> -->
         
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     rowClasses="nivelUnoBarraH,fndBarraH,nivelUnoBarraH,fndBarraHerr" width="100%">
            <t:htmlTag value="h1">
                <h:outputText value=" "/>
            </t:htmlTag>
            <t:div id="toolBarInstrumentos">
                <s:accordionPanel id="menuToolsAccordion" layout="accordion" style="border-bottom:White !important;">
                    <t:panelTab label="Procesos de Anticoncepción Temporal" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irDatosAnticoncepcion}"
                                           immediate="true"/>
                            <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irCuestionarioCovidAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.rendercovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irMotivoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderMotivo}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irAntecedentesGeneralesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderAntecedentesGenerales && menuHistoriaAnticoncepcionTemporalBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irAntecedentesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderAntecedentesGenerales && !menuHistoriaAnticoncepcionTemporalBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Temporales"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irAntecedentesTemporalesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderAntecedentesTemporales}"/>
                            <h:commandLink value="Antecedentes Ginecologicos"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irAntecedentesGinecologicosAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderAntecedentesGinecologicos}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irEncuestaViolenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderEncuestaViolencia}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irEscalaValoracionCaidasAnticoncepcionTemporal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderEscalaCaidas}"/>
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irExamenFisicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderExamen}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irImpDiagnosticaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderImpresionDiagnostica}"/>
                            <h:commandLink value="Métodos Planificación"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irMetodoPlanificacion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderMetodosPlanificacion}"/>
                            <h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irServiciosAdmisionAnticoncepcionTemporal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderServiciosAdmision}"/>
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irAnatPatologicaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderConducta}"/>
                            <h:commandLink value=" > Aplicacion Retiro P.F."
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irAplicacionRetiro}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irControlSinCostoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderConducta}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irFormulaMedicaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderConducta && !menuHistoriaAnticoncepcionTemporalBean.renderVademecum}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irVademecumMedicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderConducta && menuHistoriaAnticoncepcionTemporalBean.renderVademecum}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irRemHospitalizacionAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irIncapacidadAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irInterConsultaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irOrdenCirugiaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones" style="color:Green;"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irRecomedacionAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irReferenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irAutorizacionServicioAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irReservaSangreAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irCertMedicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irCertAsistenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irExamElectrofisiologicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irExamImagenAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irExamLaboratorioAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irCerrarConsultaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irResumenHistoriaAnticoncepcion}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Pausar Consulta"
                                           action="#{menuHistoriaAnticoncepcionTemporalBean.irPausarConsultaAnticoncepcionTemporal}"
                                           rendered="#{menuHistoriaAnticoncepcionTemporalBean.renderPausarConsulta}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>