<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
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
                                           action="#{menuHistoriaAnticoncepcionInsercion.irDatosAnticoncepcion}"
                                           immediate="true"/>
                            <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irCuestionarioCovidAnticoncepcion}" immediate="true"
                                            rendered="#{menuHistoriaAnticoncepcionInsercion.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irMotivoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderMotivo}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irAntecedentesGeneralesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderAntecedentesGenerales && menuHistoriaAnticoncepcionInsercion.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irAntecedentesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderAntecedentesGenerales && !menuHistoriaAnticoncepcionInsercion.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Temporales"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irAntecedentesTemporalesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderAntecedentesTemporales}"/>
                            <h:commandLink value="Antecedentes Ginecologicos"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irAntecedentesGinecologicosAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderAntecedentesGinecologicos}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irEncuestaViolenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderEncuestaViolencia}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irEscalaValoracionCaidasAnticoncepcionInsercion}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionInsercion.renderEscalaCaidas}"/>               
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irExamenFisicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderExamen}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irImpDiagnosticaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderImpresionDiagnostica}"/>
                            <h:commandLink value="Métodos Planificación"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irMetodoPlanificacion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderMetodosPlanificacion}"/>
                           <h:commandLink value="Aplicacion Retiro P.F."
                                           action="#{menuHistoriaAnticoncepcionInsercion.irAplicacionRetiro}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderInsercionMetodo}"/>
							<h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irServiciosAdmisionAnticoncepcionInsercion}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionInsercion.renderServiciosAdmision}"/>			   
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaAnticoncepcionInsercion.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irAnatPatologicaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderConducta}"/>
                          <h:commandLink value=" > Control"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irControlSinCostoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderConducta}"/>
                             <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irFormulaMedicaAnticoncepcion}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionInsercion.renderConducta && !menuHistoriaAnticoncepcionInsercion.renderVademecum}"/>
                                           
                             <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irVademecumMedicoAnticoncepcion}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionInsercion.renderConducta && menuHistoriaAnticoncepcionInsercion.renderVademecum}"/>
                                           
                        
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irRemHospitalizacionAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irIncapacidadAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irInterConsultaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irOrdenCirugiaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones"  style="color:Green;"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irRecomedacionAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irReferenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderConducta}"/>
                             <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irAutorizacionServicioAnticoncepcion}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionInsercion.renderConducta}"/>                 
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irReservaSangreAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaAnticoncepcionInsercion.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irCertMedicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irCertAsistenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaAnticoncepcionInsercion.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irExamElectrofisiologicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irExamImagenAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irExamLaboratorioAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irCerrarConsultaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionInsercion.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                                <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaAnticoncepcionInsercion.irResumenHistoriaAnticoncepcion}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuHistoriaAnticoncepcionInsercion.irPausarConsultaAnticoncepcionInsercion}"
                                   rendered="#{menuHistoriaAnticoncepcionInsercion.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>